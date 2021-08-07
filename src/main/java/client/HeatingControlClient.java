package client;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import javax.jmdns.ServiceInfo;

import heatingControl.HeatingControlDiscovery;
import heatingControl.HeatingRequest;
import heatingControl.HeatingResponse;
import heatingControl.heatingControlServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class HeatingControlClient {
	public static void main(String[] args) {
			
		
		ServiceInfo serviceInfo;
		String service_clientstreaming = "_grpc._tcp.local.";
		//Now retrieve the service info - all we are supplying is the service type
		serviceInfo = HeatingControlDiscovery.run(service_clientstreaming);
				
		//Use the serviceInfo to retrieve the port
		int port = serviceInfo.getPort();
		String host = "localhost";
		
		
		try {
			ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();		
			
			heatingControlServiceGrpc.heatingControlServiceStub stub = heatingControlServiceGrpc.newStub(channel);	
			//the latch will control the synchronization of our requests
			CountDownLatch latch = new CountDownLatch(1);
					
			StreamObserver<HeatingRequest> requestObserver = stub.changeHeatingStatus(
					new StreamObserver<HeatingResponse>() {
				@Override
				public void onNext(HeatingResponse response) {	
					System.out.println(response.getHeatingStatus());
				}
	
				@Override
				public void onError(Throwable t) {				
					latch.countDown();
				}
	
				@Override
				public void onCompleted() {				
					latch.countDown();				
				}
			});
	//we create our requests
			Scanner scanner = new Scanner(System.in);
			boolean sendAnother = false;
			do {
				HeatingRequest request = inputRequestData(scanner);
				System.out.println("Do you want to send another request? (Y/N) ");
				String answer = scanner.next();
				if (answer.equalsIgnoreCase("Y")) {
					sendAnother = true;
				} else {
					sendAnother = false;
				}
				requestObserver.onNext(request);
			} while(sendAnother);			
			scanner.close();
			
			requestObserver.onCompleted();
			latch.await(3, TimeUnit.SECONDS);
			channel.shutdownNow();	
		} catch (Exception e) {
			System.out.println("Error sending heating data!");
		}
	}
	//we create our method of heating request.
	public static HeatingRequest inputRequestData(Scanner scanner) {	
		System.out.println("Input the number of heating system: ");
		int number = scanner.nextInt();		
		System.out.println("Do you want to turn on? (Y/N) ");
		String answer = scanner.next();
		boolean isOn = false;
		if (answer.equalsIgnoreCase("Y")) {
			isOn = true;
		} else {
			isOn = false;
		}		
		HeatingRequest request = HeatingRequest.newBuilder()
				.setHeatingNumber(number).setTurnOn(isOn).build();
		return request;
	}
}
