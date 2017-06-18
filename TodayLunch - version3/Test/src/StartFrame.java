import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StartFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartFrame frame = new StartFrame();
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
	public StartFrame() {
		setTitle("\uC624\uB298\uC758 \uC810\uC2EC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Adminstor");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("±¼¸²", Font.BOLD, 20));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginFrame lFrame = new LoginFrame();
				lFrame.setVisible(true);
				lFrame.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(119, 35, 176, 49);
		contentPane.add(btnNewButton);

		JButton button = new JButton("Shop Owner");
		button.setForeground(Color.BLACK);
		button.setFont(new Font("±¼¸²", Font.BOLD, 20));
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				OwnerFrame oFrame = new OwnerFrame();
				oFrame.setVisible(true);
				oFrame.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		button.setBounds(119, 109, 176, 49);
		contentPane.add(button);

		JButton button_1 = new JButton("User");
		button_1.setFont(new Font("±¼¸²", Font.BOLD, 20));
		button_1.setForeground(Color.BLACK);
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				UserFrame uFrame = new UserFrame();
				uFrame.setVisible(true);
				uFrame.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		button_1.setBounds(119, 178, 176, 49);
		contentPane.add(button_1);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("100.jpg"));
		lblNewLabel_1.setBounds(0, 0, 434, 259);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(0, 0, 434, 261);
		contentPane.add(lblNewLabel);
	}
}