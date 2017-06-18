import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserFrame frame = new UserFrame();
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
	public UserFrame() {
		setTitle("\uC624\uB298\uC758 \uC810\uC2EC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("¿¡¶ó ¸ð¸£°Ú´Ù");
		btnNewButton.setFont(new Font("±¼¸²", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RandomFrame rFrame = new RandomFrame();
				rFrame.setVisible(true);
				rFrame.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(108, 55, 213, 59);
		contentPane.add(btnNewButton);

		JButton button = new JButton("³ª¸¦ ÇÑ ¹ø ¹Ï¾îºÁ!");
		button.setFont(new Font("±¼¸²", Font.BOLD, 20));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChoiceFrame cFrame = new ChoiceFrame();
				cFrame.setVisible(true);
				cFrame.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		button.setBounds(108, 146, 213, 59);
		contentPane.add(button);
		
		JButton btnNewButton_1 = new JButton("A");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginFrame lFrame = new LoginFrame();
				lFrame.setVisible(true);
				lFrame.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(371, 226, 61, 27);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("100.jpg"));
		lblNewLabel.setBounds(0, 0, 434, 261);
		contentPane.add(lblNewLabel);
	
	}
}