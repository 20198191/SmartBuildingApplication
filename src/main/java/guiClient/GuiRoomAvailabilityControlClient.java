package guiClient;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import roomAvailabilityControl.EmptyRequest;
import roomAvailabilityControl.RoomResponse;
import roomAvailabilityControl.roomAvailabilityControlServiceGrpc;

public class GuiRoomAvailabilityControlClient extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea textArea;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiRoomAvailabilityControlClient frame = new GuiRoomAvailabilityControlClient();
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
	public GuiRoomAvailabilityControlClient() {
		setTitle("Availability GUI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 335, 316);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSend = new JButton("Show Room Availabilities");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendServerStreamingRPC();
			}
		});
		
		btnSend.setBounds(64, 28, 191, 23);
		contentPane.add(btnSend);
		
		textArea = new JTextArea();
		textArea.setBounds(10, 84, 299, 179);
		contentPane.add(textArea);
	}
	
	public void sendServerStreamingRPC() {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();				
		roomAvailabilityControlServiceGrpc.roomAvailabilityControlServiceBlockingStub stub = roomAvailabilityControlServiceGrpc.newBlockingStub(channel);

		EmptyRequest request = EmptyRequest.newBuilder().build();				
		Iterator<RoomResponse> responses = stub.getRoomStatus(request);
		String message = "";
		while (responses.hasNext()) {
			RoomResponse response = responses.next();			
			message = message + "Room Number: "+response.getRoomNumber()+" Status: "+response.getRoomStatus()+"\n";
		}		
		textArea.setText(message);
		channel.shutdownNow();	
	}
}
