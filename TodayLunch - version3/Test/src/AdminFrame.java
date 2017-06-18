import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

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

public class AdminFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminFrame frame = new AdminFrame();
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
	public AdminFrame() {
		setTitle("\uC624\uB298\uC758 \uC810\uC2EC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnGotoMain = new JButton("Go to Main");
		btnGotoMain.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		btnGotoMain.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StartFrame sFrame = new StartFrame();
				sFrame.setVisible(true);
				sFrame.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		btnGotoMain.setBounds(144, 166, 137, 55);
		contentPane.add(btnGotoMain);

		JButton btnNewButton = new JButton("Menu");
		btnNewButton.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CMFrame cmFrame = new CMFrame();
				cmFrame.setVisible(true);
				cmFrame.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(144, 32, 137, 55);
		contentPane.add(btnNewButton);

		JButton button = new JButton("Question");
		button.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button.setBounds(144, 99, 137, 55);
		contentPane.add(button);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("100.jpg"));
		lblNewLabel.setBounds(0, 0, 434, 261);
		contentPane.add(lblNewLabel);
	}

}