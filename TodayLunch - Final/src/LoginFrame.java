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

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setTitle("\uC624\uB298\uC758 \uC810\uC2EC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("아이디");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("굴림", Font.PLAIN, 20));
		label.setBounds(73, 76, 78, 35);
		contentPane.add(label);

		JLabel label_1 = new JLabel("비밀번호");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("굴림", Font.PLAIN, 20));
		label_1.setBounds(60, 123, 91, 35);
		contentPane.add(label_1);

		textField = new JTextField();
		textField.setBounds(175, 77, 147, 27);
		contentPane.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(175, 129, 147, 27);
		contentPane.add(passwordField);

		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 20));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String Id = textField.getText();
				char[] pass = passwordField.getPassword();

				String password = new String(pass);
				if (Id.equals("today") && password.equals("lunch")) {
					AdminFrame aFrame = new AdminFrame();
					aFrame.setVisible(true);
					aFrame.setLocationRelativeTo(null);
					setVisible(false);
				} else if (Id.equals("") || password.equals("")) {
					JOptionPane.showMessageDialog(null, "빈칸이 입력 되었습니다. 다시 입력하세요");
				} else
					JOptionPane.showMessageDialog(null, "존재하지 않는 ID이거나 틀린 비밀번호 입니다.");
			}
		});
		btnNewButton.setBounds(175, 176, 147, 35);
		contentPane.add(btnNewButton);

		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("100.jpg"));
		lblNewLabel.setBounds(0, 0, 434, 261);
		contentPane.add(lblNewLabel);
	}
}