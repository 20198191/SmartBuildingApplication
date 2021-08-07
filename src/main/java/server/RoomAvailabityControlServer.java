package server;

import java.util.ArrayList;
import java.util.List;


import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import roomAvailabilityControl.EmptyRequest;
import roomAvailabilityControl.RoomResponse;
import roomAvailabilityControl.roomAvailabilityControlServiceGrpc.roomAvailabilityControlServiceImplBase;
import roomAvailabilityControl.roomAvailabilityRegistration;


public class RoomAvailabityControlServer {
	public static void main(String[] args) {
		
		
		int port = 50052;
		String service_serverStreaming = "_grpc._tcp.local.";
		String service_name = "GrpcServer";
		roomAvailabilityRegistration ssr = new roomAvailabilityRegistration();
		ssr.run(port, service_serverStreaming, service_name);
		//we create the server
		try {
			System.out.println("Starting Room Server...");
			Server server = ServerBuilder.forPort(50052).addService(new RoomAvailabilityControlServiceImpl()).build();
			server.start();
			System.out.println("Room Server started!");
			server.awaitTermination();
		} catch (Exception e) {
			System.out.println("Error starting Room Server! "+e.getMessage());
		}	
	}
	
	static class RoomAvailabilityControlServiceImpl extends roomAvailabilityControlServiceImplBase {
		List<Room> rooms = createRooms();
		
		public void getRoomStatus(EmptyRequest request, StreamObserver<RoomResponse> responseObserver) {				
			// we go through the list to create a response, the onNext send from the server to the client
			for (Room room : rooms) {
				RoomResponse response = RoomResponse.newBuilder()
						.setRoomNumber(room.getNumber())
						.setRoomStatus(room.getStatus()).build();
				responseObserver.onNext(response);
			}
			//at the end we estate we finalise
			responseObserver.onCompleted();			
		}
		
		public static List<Room> createRooms() {
			//we create our list with the room number, status and if the light is on or off for the LighsntControlService
			Room r1 = new Room();
			r1.setNumber(201);
			r1.setStatus("Occupied");
			r1.setLightOn(true);
			Room r2 = new Room();
			r2.setNumber(202);
			r2.setStatus("Free");
			r2.setLightOn(false);
			Room r3 = new Room();
			r3.setNumber(203);
			r3.setStatus("Occupied");
			r3.setLightOn(true);
			Room r4 = new Room();
			r4.setNumber(301);
			r4.setStatus("Occupied");
			r4.setLightOn(false);
			Room r5 = new Room();
			r5.setNumber(302);
			r5.setStatus("Free");
			r5.setLightOn(true); 
			Room r6 = new Room();
			r6.setNumber(303);
			r6.setStatus("Free");
			r6.setLightOn(false);
			
			List<Room> rooms = new ArrayList<>();
			rooms.add(r1);
			rooms.add(r2);
			rooms.add(r3);
			rooms.add(r4);
			rooms.add(r5);
			rooms.add(r6);
			return rooms;
		}
	}

}