import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;

public class ResultFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblNewLabel_1;
	private JLabel label;
	private JLabel lblNewLabel_2;
	Menu m;

	/**
	 * Create the frame.
	 */
	public ResultFrame(int result, User u) {
		String Result;
		MenuList ml = start.ml;
		m = ml.getItem(result);
		Result = m.name;
		setTitle("\uC624\uB298\uC758 \uC810\uC2EC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton2 = new JButton("¿Ã∞« Ω»æÓ");
		btnNewButton2.setFont(new Font("±º∏≤", Font.PLAIN, 13));
		btnNewButton2.setBounds(440, 313, 90, 35);
		contentPane.add(btnNewButton2);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(m.fil));
		lblNewLabel.setBounds(137, 12, 268, 233);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBackground(Color.BLACK);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("±º∏≤", Font.PLAIN, 19));
		textField.setText(m.name);
		textField.setBounds(137, 266, 268, 35);
		contentPane.add(textField);
		textField.setEnabled(false);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBackground(Color.BLACK);
		textField_1.setText(m.position + " ) " + m.Sname);
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("±º∏≤", Font.PLAIN, 19));
		textField_1.setEnabled(false);
		textField_1.setColumns(10);
		textField_1.setBounds(137, 311, 268, 35);
		contentPane.add(textField_1);

		JButton btnNewButton = new JButton("Ω√¿€¿∏∑Œ");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				UserFrame uFrame = new UserFrame();
				uFrame.setVisible(true);
				uFrame.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(440, 266, 90, 35);
		contentPane.add(btnNewButton);

		lblNewLabel_1 = new JLabel("\uC74C\uC2DD :");
		lblNewLabel_1.setForeground(SystemColor.inactiveCaption);
		lblNewLabel_1.setFont(new Font("±º∏≤", Font.BOLD, 19));
		lblNewLabel_1.setBounds(74, 266, 68, 35);
		contentPane.add(lblNewLabel_1);

		label = new JLabel("\uC7A5\uC18C :");
		label.setForeground(SystemColor.inactiveCaption);
		label.setFont(new Font("±º∏≤", Font.BOLD, 19));
		label.setBounds(74, 311, 68, 35);
		contentPane.add(label);

		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("200.png"));
		lblNewLabel_2.setBounds(0, 0, 546, 424);
		contentPane.add(lblNewLabel_2);

		Match match = new Match();
		btnNewButton2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				m = start.ml.getItem(match.resultMenu(u));
				lblNewLabel.setIcon(new ImageIcon(m.fil));
				textField.setText(m.name);
				textField_1.setText(m.position + " ) " + m.Sname);
				// contentPane.add(lblNewLabel);
				lblNewLabel.repaint();
				contentPane.add(textField_1);
				contentPane.add(textField);
				System.out.printf("¿Á∞·∞˙ : %s\n", m.name);
			}
		});

	}
}