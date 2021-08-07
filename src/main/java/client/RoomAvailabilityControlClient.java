package client;

import java.util.Iterator;

import javax.jmdns.ServiceInfo;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import roomAvailabilityControl.EmptyRequest;
import roomAvailabilityControl.RoomResponse;
import roomAvailabilityControl.roomAvailabilityControlServiceGrpc;
import roomAvailabilityControl.roomAvailabilityDiscovery;

public class RoomAvailabilityControlClient {
	// Server Streaming RPC
	public static void main(String[] args) {
		
		
		ServiceInfo serviceInfo;
		String service_serverStreaming = "_grpc._tcp.local.";
		//Now retrieve the service info - all we are supplying is the service type
		serviceInfo = roomAvailabilityDiscovery.run(service_serverStreaming);
					
		//Use the serviceInfo to retrieve the port
		int port = serviceInfo.getPort();
		String host = "localhost";
		
		
		ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();				
		roomAvailabilityControlServiceGrpc.roomAvailabilityControlServiceBlockingStub stub = roomAvailabilityControlServiceGrpc.newBlockingStub(channel);

		EmptyRequest request = EmptyRequest.newBuilder().build();				
		Iterator<RoomResponse> responses = stub.getRoomStatus(request);
		// if there is a next one, look for it and print
		while (responses.hasNext()) {
			RoomResponse response = responses.next();
			System.out.println("Room Number: "+response.getRoomNumber()+" Status: "+response.getRoomStatus()+"\n");
		}		
		
		channel.shutdownNow();		
	}
}
