package guiClient;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import lightsControl.LightRequest;
import lightsControl.LightResponse;
import lightsControl.lightsControlServiceGrpc;

public class GuiLightsControlClient extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldRoomNumber;
	private JTextArea textAreaResult;
		
	private StreamObserver<LightRequest> requestObserver;
	private CountDownLatch latch;
	private ManagedChannel channel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiLightsControlClient frame = new GuiLightsControlClient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GuiLightsControlClient() {
		setTitle("Lights GUI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 271, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Room Number:");
		lblNewLabel.setBounds(28, 29, 108, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Status of Heating Systems:");
		lblNewLabel_1.setBounds(28, 121, 154, 14);
		contentPane.add(lblNewLabel_1);
		
		textFieldRoomNumber = new JTextField();
		textFieldRoomNumber.setBounds(125, 26, 86, 20);
		contentPane.add(textFieldRoomNumber);
		textFieldRoomNumber.setColumns(10);
		
		JButton btnRequest = new JButton("Request");
		btnRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendBidirectionalStreamingRPC();
			}
		});
		btnRequest.setBounds(29, 80, 86, 23);
		contentPane.add(btnRequest);
		
		JButton btnFinish = new JButton("Finish");
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finish();
			}
		});
		btnFinish.setBounds(125, 80, 89, 23);
		contentPane.add(btnFinish);
		
		textAreaResult = new JTextArea();
		textAreaResult.setRows(10);
		textAreaResult.setEditable(false);
		textAreaResult.setBounds(10, 143, 235, 165);
		contentPane.add(textAreaResult);
	}
	
	public void sendBidirectionalStreamingRPC() {
		try {
			if (channel==null) {
				channel = ManagedChannelBuilder.forAddress("localhost", 50054).usePlaintext().build();		
							
				lightsControlServiceGrpc.lightsControlServiceStub stub = lightsControlServiceGrpc.newStub(channel);
				latch = new CountDownLatch(1);
	
				requestObserver =
					stub.readRoomLightStatus(new StreamObserver<LightResponse>() {
						@Override
						public void onNext(LightResponse response) {
							String message = "Room Number: "+response.getRoomNumber();						
							if (response.getRoomNotFound()) {
								message = message + " not found!\n";
							} else {
								if (response.getLightOn()) {
									message = message + " with light on!\n";
								} else {
									message = message + " with light off!\n";
								}
							}												
							textAreaResult.setText(textAreaResult.getText()+message);
						}
	
						@Override
						public void onError(Throwable t) {
						}
	
						@Override
						public void onCompleted() {						
							latch.countDown();
						}
					});
			}
				
					
			LightRequest request = LightRequest.newBuilder()
					.setRoomNumber(Integer.parseInt(textFieldRoomNumber.getText()))				
					.build();
			
			requestObserver.onNext(request);							
		} catch (Exception e) {
			textAreaResult.setText("Error sending light data!");
		}
	}
	
	public void finish() {
		try {
			requestObserver.onCompleted();
			latch.await(1, TimeUnit.SECONDS);
			channel.shutdownNow();
			channel = null;
			textAreaResult.setText("");
		} catch (Exception e) {			
			textAreaResult.setText("Error sending light data!");
		}
	}
}
