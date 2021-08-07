package guiClient;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import visitorsControl.GuestBookServiceResponse;
import visitorsControl.VisitorRequest;
import visitorsControl.visitorsControlServiceGrpc;

public class GuiVisitorsControlClient extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldGuestName;
	private JTextField textFieldConfirmation;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiVisitorsControlClient frame = new GuiVisitorsControlClient();
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
	public GuiVisitorsControlClient() {
		setTitle("Visitors GUI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 328, 235);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Guest name:");
		lblNewLabel.setBounds(38, 42, 78, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Confirmation message:");
		lblNewLabel_1.setBounds(36, 128, 145, 14);
		contentPane.add(lblNewLabel_1);
		
		textFieldGuestName = new JTextField();
		textFieldGuestName.setBounds(38, 67, 127, 20);
		contentPane.add(textFieldGuestName);
		textFieldGuestName.setColumns(10);
		
		textFieldConfirmation = new JTextField();
		textFieldConfirmation.setEditable(false);
		textFieldConfirmation.setBounds(36, 153, 245, 20);
		contentPane.add(textFieldConfirmation);
		textFieldConfirmation.setColumns(10);
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendUnaryRPC();
			}
		});
		btnSend.setBounds(192, 66, 89, 23);
		contentPane.add(btnSend);
	}

	public void sendUnaryRPC() {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
		visitorsControlServiceGrpc.visitorsControlServiceBlockingStub stub = visitorsControlServiceGrpc.newBlockingStub(channel);

		String guestName = textFieldGuestName.getText();
		
		VisitorRequest request = VisitorRequest.newBuilder().setGuestName(guestName).build();
		// RPC: Client send request and Server reply with response
		GuestBookServiceResponse response = stub.registerVisitor(request);
		
		textFieldConfirmation.setText(response.getConfirmationMessage());		
		channel.shutdownNow();	
	}
}
