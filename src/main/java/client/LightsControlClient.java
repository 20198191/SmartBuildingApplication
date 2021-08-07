package client;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import javax.jmdns.ServiceInfo;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import lightsControl.LightRequest;
import lightsControl.LightResponse;
import lightsControl.LightsControlDiscovery;
import lightsControl.lightsControlServiceGrpc;

//Bidirectional Streaming RPC
public class LightsControlClient {
	public static void main(String[] args) {
		
		
		ServiceInfo serviceInfo;
		String service_bidirectionalStreaming = "_grpc._tcp.local.";
		//Now retrieve the service info - all we are supplying is the service type
		serviceInfo = LightsControlDiscovery.run(service_bidirectionalStreaming);
				
		//Use the serviceInfo to retrieve the port
		int port = serviceInfo.getPort();
		String host = "localhost";
		
		
		try {
			ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();		
						
			lightsControlServiceGrpc.lightsControlServiceStub stub = lightsControlServiceGrpc.newStub(channel);
			CountDownLatch latch = new CountDownLatch(1);

			StreamObserver<LightRequest> requestObserver =
				stub.readRoomLightStatus(new StreamObserver<LightResponse>() {
					@Override
					public void onNext(LightResponse response) {	
						System.out.println("Room Number: "+response.getRoomNumber());
						if (response.getRoomNotFound()) {
							System.out.println("Not found!");
						} else {
							if (response.getLightOn()) {
								System.out.println("Light is on!");
							} else {
								System.out.println("Light is off!");
							}
						}
					}

					@Override
					public void onError(Throwable t) {
					}

					@Override
					public void onCompleted() {						
						latch.countDown();
					}
				});
					//we create our method for our request
			Scanner scanner = new Scanner(System.in);
			boolean sendAnother = false;
			do {
				LightRequest request = inputRequestData(scanner);
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
			System.out.println("Communication errors!");
		}
	}
	// this methos allows to the client to input 
	public static LightRequest inputRequestData(Scanner scanner) {	
		System.out.println("Input the number of room: ");
		int number = scanner.nextInt();
		LightRequest request = LightRequest.newBuilder()
				.setRoomNumber(number).build();
		return request;
	}
}
