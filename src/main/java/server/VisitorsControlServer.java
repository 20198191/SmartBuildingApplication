package server;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import visitorsControl.GuestBookServiceResponse;
import visitorsControl.VisitorRequest;
import visitorsControl.visitorsControlRegistration;
import visitorsControl.visitorsControlServiceGrpc.visitorsControlServiceImplBase;


public class VisitorsControlServer {
	
	
	
	public static void main(String[] args) {
		//jmDNS 
		int port = 50051;
		String service_unary = "_grpc._tcp.local.";
		String service_name = "GrpcServer";
		visitorsControlRegistration ssr = new visitorsControlRegistration();
		ssr.run(port, service_unary, service_name);
		//we create the server
		try {
			System.out.println("Starting Register Server...");
			//we pass the services that will be used by the client
			Server server = ServerBuilder.forPort(50051).addService(new visitorsControlServiceImpl()).build();
			server.start();
			System.out.println("Register Server started!");
			server.awaitTermination();
		} catch (Exception e) {
			System.out.println("Error starting Register Server! "+e.getMessage());
		}	
	}
	//we create the service 
	static class  visitorsControlServiceImpl extends visitorsControlServiceImplBase {
		//First we established an array with some names already registered then we create an arraylist that contains
		//those names an also will contain the new names that will be input
		String[] guestArray = {"James Smith", "Robert Johnson", "Jennifer Jones", "John Davis"};
		List<String> guestList = new ArrayList<>(Arrays.asList(guestArray));

	//we create the method registerVisitor, 
		public void registerVisitor(VisitorRequest request, StreamObserver<GuestBookServiceResponse> responseObserver) {
			String message = searchGuest(request.getGuestName());				
			GuestBookServiceResponse response = GuestBookServiceResponse.newBuilder().setConfirmationMessage(message).build();				
			responseObserver.onNext(response);
			responseObserver.onCompleted();		
		}
		//we create this method to check if the new guestName is already registered, a return message will let them know as an error
		private String searchGuest(String guestName) {
			for (String guest : guestList) {
				if (guest.equalsIgnoreCase(guestName)) {
					return "Guest is already register!";
				}
			}
			// if it is a completely new name the new guest will be Registered.
			guestList.add(guestName);
			return "Guest registration completed!"; 
		}
		
	}

	
	
	
}
