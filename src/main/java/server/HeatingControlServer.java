
package server;

import java.util.ArrayList;
import java.util.List;

import heatingControl.HeatingControlRegistration;
import heatingControl.HeatingRequest;
import heatingControl.HeatingResponse;
import heatingControl.heatingControlServiceGrpc.heatingControlServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
//Client streaming RPC
public class HeatingControlServer {
	public static void main(String[] args) {
		//implement to our jmDNS
		int port = 50053;
		String service_clientstreaming = "_grpc._tcp.local.";
		String service_name = "GrpcServer";
		HeatingControlRegistration ssr = new HeatingControlRegistration();
		ssr.run(port, service_clientstreaming, service_name);
		
		//we create our server
		try {
			System.out.println("Starting Heating Server...");
			Server server = ServerBuilder.forPort(50053).addService(new heatingControlServiceImpl()).build();
			server.start();
			System.out.println("Heating Server started!");
			server.awaitTermination();
		} catch (Exception e) {
			System.out.println("Error starting Heating Server! "+e.getMessage());
		}	
	}
	//we create our service
	static class heatingControlServiceImpl extends heatingControlServiceImplBase {
		
		// Client Streaming RPC	
		public StreamObserver<HeatingRequest> changeHeatingStatus(StreamObserver<HeatingResponse> responseObserver) {
			return new StreamObserver<HeatingRequest>() {			
				private List<HeatingSystem> heatings = createHeatings();
				@Override
				//we do the request of the information of the heatings 
				public void onNext(HeatingRequest request) {
					for (int i=0; i<heatings.size(); i++) {				
						if (heatings.get(i).getNumber() == request.getHeatingNumber()) {
							heatings.get(i).setOn(request.getTurnOn());
						}
					}			
				}

				@Override
				public void onError(Throwable t) {					
				}
         
				@Override
				//we create our method to create the response of the server.
				//where the server give to the client the number of the heating and if its ON or OFF
				public void onCompleted() {
					String message = "";
					for (int i=0; i<heatings.size(); i++) {
						String number = String.valueOf(heatings.get(i).getNumber());
						String heatingInfo = "";
						if (heatings.get(i).isOn()) {
							heatingInfo = number+" is on!\n";
						} else {
							heatingInfo = number+" is off!\n";
						}
						message = message + heatingInfo;
					}
					
					HeatingResponse response = HeatingResponse.newBuilder()
						.setHeatingStatus(message)						
						.build();				
					responseObserver.onNext(response); 
					responseObserver.onCompleted();				
				}
			};
		}
		//we create a list of heatings according to the floors in the building.
		private List<HeatingSystem> createHeatings() {
			List<HeatingSystem> heatings = new ArrayList<>();
			HeatingSystem heatingFloor1 = new HeatingSystem();
			HeatingSystem heatingFloor2 = new HeatingSystem();
			HeatingSystem heatingFloor3 = new HeatingSystem();
			heatingFloor1.setNumber(1);
			heatingFloor2.setNumber(2);
			heatingFloor3.setNumber(3);
			heatingFloor1.setOn(false);
			heatingFloor2.setOn(false);		
			heatingFloor3.setOn(false);
			heatings.add(heatingFloor1);
			heatings.add(heatingFloor2);
			heatings.add(heatingFloor3);
			return heatings;
		}
	}

	
	
	
}
