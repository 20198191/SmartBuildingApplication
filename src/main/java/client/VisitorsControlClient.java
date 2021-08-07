package client;

import java.util.Scanner;

import javax.jmdns.ServiceInfo;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import visitorsControl.GuestBookServiceResponse;
import visitorsControl.VisitorRequest;
import visitorsControl.visitorsControlDiscovery;
import visitorsControl.visitorsControlServiceGrpc;

public class VisitorsControlClient {
	
	
	// Unary RPC
	public static void main(String[] args) {

		
		ServiceInfo serviceInfo;
		String service_unary = "_grpc._tcp.local.";
		//Now retrieve the service info - all we are supplying is the service type
		serviceInfo = visitorsControlDiscovery.run(service_unary);
				
				
		//Use the serviceInfo to retrieve the port
		int port = serviceInfo.getPort();
		String host = "localhost";
		
		//the channel contains the ip and the port
		ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
		visitorsControlServiceGrpc.visitorsControlServiceBlockingStub stub = visitorsControlServiceGrpc.newBlockingStub(channel);
//we aks the user to input the name to be registered
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please, input your full name: ");
		String guestName = scanner.nextLine();
		scanner.close();
		//this is the request with the guestName inside of it
		VisitorRequest request = VisitorRequest.newBuilder().setGuestName(guestName).build();
		// RPC: Client send request and Server reply with response
		GuestBookServiceResponse response = stub.registerVisitor(request);
		
		System.out.println(response.getConfirmationMessage());		
		channel.shutdownNow();		
	}
}
