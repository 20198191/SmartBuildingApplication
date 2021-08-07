
package server;

import java.util.List;


import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import lightsControl.LightRequest;
import lightsControl.LightResponse;
import lightsControl.LightsControlRegistration;
import lightsControl.lightsControlServiceGrpc.lightsControlServiceImplBase;


public class LightsControlServer {
	public static void main(String[] args) {
		
	//we implement the jmDNS code our rpc
		int port = 50054;
		String service_bidirectionalStreaming = "_grpc._tcp.local.";
		String service_name = "GrpcServer";
		LightsControlRegistration ssr = new LightsControlRegistration();
		ssr.run(port, service_bidirectionalStreaming, service_name);
		
		//we create our server
		try {
			System.out.println("Starting Light Server...");
			Server server = ServerBuilder.forPort(50054).addService(new LightsControlServiceImpl()).build();
			server.start();
			System.out.println("Light Server started!");
			server.awaitTermination();
		} catch (Exception e) {
			System.out.println("Error starting Light Server! "+e.getMessage());
		}	
	}
	//we create uur service
	static class LightsControlServiceImpl extends lightsControlServiceImplBase {
		List<Room> rooms = RoomAvailabityControlServer.RoomAvailabilityControlServiceImpl.createRooms();
		
		// Bidirectional Streaming RPC
		public StreamObserver<LightRequest> readRoomLightStatus(StreamObserver<LightResponse> responseObserver) {
			return new StreamObserver<LightRequest>() {
				@Override
				public void onNext(LightRequest request) {
					//we create multiple responses 
					for (Room room : rooms) {
						if (request.getRoomNumber()==room.getNumber()) {
							LightResponse response = LightResponse.newBuilder()
								.setRoomNumber(request.getRoomNumber())
								.setRoomNotFound(false)
								.setLightOn(room.isLightOn()).build();
							responseObserver.onNext(response);
							return;
						}
					}
					LightResponse response = LightResponse.newBuilder()
						.setRoomNumber(request.getRoomNumber())
						.setRoomNotFound(true).build();
					responseObserver.onNext(response);
				}
				
				@Override
				public void onError(Throwable t) {				
				}

				@Override
				public void onCompleted() {
					responseObserver.onCompleted();				
				}
			};
		}
	}

	
}