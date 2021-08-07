package guiClient;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import heatingControl.HeatingRequest;
import heatingControl.HeatingResponse;
import heatingControl.heatingControlServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class GuiHeatingControlClient extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldHeatingNumber;
	private JCheckBox chckbxTurnOn;
	private JTextArea textAreaStatus;
	
	private StreamObserver<HeatingRequest> requestObserver;
	private CountDownLatch latch;
	private ManagedChannel channel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiHeatingControlClient frame = new GuiHeatingControlClient();
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
	public GuiHeatingControlClient() {
		setTitle("Heating GUI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 271, 273);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Heating Number:");
		lblNewLabel.setBounds(28, 29, 108, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Status of Heating Systems:");
		lblNewLabel_1.setBounds(28, 121, 154, 14);
		contentPane.add(lblNewLabel_1);
		
		textFieldHeatingNumber = new JTextField();
		textFieldHeatingNumber.setBounds(125, 26, 86, 20);
		contentPane.add(textFieldHeatingNumber);
		textFieldHeatingNumber.setColumns(10);
		
		chckbxTurnOn = new JCheckBox("Turn On");
		chckbxTurnOn.setBounds(135, 50, 76, 23);
		contentPane.add(chckbxTurnOn);
		
		JButton btnRequest = new JButton("Request");
		btnRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendClientStreamingRPC();
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
		
		textAreaStatus = new JTextArea();
		textAreaStatus.setRows(10);
		textAreaStatus.setEditable(false);
		textAreaStatus.setBounds(10, 143, 235, 80);
		contentPane.add(textAreaStatus);
	}
	
	public void sendClientStreamingRPC() {
		try {
			
			// Is the first send request?
			if (channel == null) {			
				channel = ManagedChannelBuilder.forAddress("localhost", 50053).usePlaintext().build();		
				heatingControlServiceGrpc.heatingControlServiceStub stub = heatingControlServiceGrpc.newStub(channel);
				latch = new CountDownLatch(1);					
				requestObserver = stub.changeHeatingStatus(
						new StreamObserver<HeatingResponse>() {
				    // Pong
					@Override
					public void onNext(HeatingResponse response) {
						textAreaStatus.setText(response.getHeatingStatus());						
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
			}				
	
			// Ping
			HeatingRequest request = HeatingRequest.newBuilder()
					.setHeatingNumber(Integer.parseInt(textFieldHeatingNumber.getText()))
					.setTurnOn(chckbxTurnOn.isSelected())
					.build();
			requestObserver.onNext(request);
			textAreaStatus.setText("Request sent!");
		} catch (Exception e) {			
			textAreaStatus.setText("Error sending heating data!");
		}
	}
	
	public void finish() {
		try {
			requestObserver.onCompleted();
			latch.await(3, TimeUnit.SECONDS);
			channel.shutdownNow();
			channel = null;
		} catch (Exception e) {			
			textAreaStatus.setText("Error sending heating data!");
		}
	}
}
