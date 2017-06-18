import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChoiceFrame extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField;

	int q_max = 10;
	int q_count = 0;
	int question;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChoiceFrame frame = new ChoiceFrame();
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
	public ChoiceFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 253);
		contentPane.add(panel);
		panel.setLayout(null);

		JRadioButton radioButton_1 = new JRadioButton("No");
		radioButton_1.setFont(new Font("±º∏≤", Font.PLAIN, 20));
		buttonGroup.add(radioButton_1);
		radioButton_1.setBounds(43, 128, 135, 27);
		panel.add(radioButton_1);

		JRadioButton radioButton_2 = new JRadioButton("Yes");
		radioButton_2.setFont(new Font("±º∏≤", Font.PLAIN, 20));
		buttonGroup.add(radioButton_2);
		radioButton_2.setBounds(43, 99, 135, 27);
		panel.add(radioButton_2);

		User u = new User();
		Match match = new Match();

		JButton btnNewButton = new JButton("Next");
		btnNewButton.setFont(new Font("±º∏≤", Font.PLAIN, 20));

		btnNewButton.setBounds(163, 180, 105, 35);
		panel.add(btnNewButton);

		JLabel lblQuestion = new JLabel("Question");
		lblQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuestion.setFont(new Font("±º∏≤", Font.BOLD, 23));
		lblQuestion.setBounds(172, 12, 96, 27);
		panel.add(lblQuestion);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		question = match.selectQestion(u);
		textField.setText(start.ql.getItem(question).getQuestion());
		textField.setFont(new Font("±º∏≤", Font.ITALIC, 19));
		textField.setEnabled(false);
		textField.setBounds(14, 51, 406, 34);
		panel.add(textField);
		textField.setColumns(10);

		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int answer = 0;

				if (radioButton_1.isSelected()) {
					answer = 2;
				} else if (radioButton_2.isSelected()) {
					answer = 1;
				} else
					JOptionPane.showMessageDialog(null, "yes or no∏¶ º±≈√«ÿ¡÷ººø‰.\n");

				if (answer != 0) {
					match.processAnswer(question, answer, u);
					u.showWeight();
				}
				if (q_count < q_max - 1) {
					if (answer != 0) {
						q_count++;
						question = match.selectQestion(u);
						textField.setText(start.ql.getItem(question).getQuestion());
						buttonGroup.clearSelection();
					}
				} else {
					// Result Section
					int result = match.resultMenu(u);
					ResultFrame rFrame = new ResultFrame(result);
					System.out.printf("\n∞·∞˙ : %s\n", start.ml.getItem(result).getName());
					rFrame.setVisible(true);
					rFrame.setLocationRelativeTo(null);
					setVisible(false);
				}
			}
		});

	}
}