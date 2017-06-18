
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

import javax.swing.UIManager;

public class ChoiceFrame extends JFrame {
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField;

	int q_max = 10;
	int q_count = 0;
	int question;

	/**
	 *Launch the application.
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
		setTitle("\uC624\uB298\uC758 \uC810\uC2EC");
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

		User u = new User();
		Match match = new Match();

		JLabel lblQuestion = new JLabel("Question");
		lblQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuestion.setFont(new Font("±¼¸²", Font.BOLD, 23));
		lblQuestion.setBounds(172, 12, 96, 27);
		panel.add(lblQuestion);

		textField = new JTextField();
		textField.setForeground(Color.DARK_GRAY);
		textField.setBackground(new Color(0, 0, 0));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		question = match.selectQestion(u);
		textField.setText(start.ql.getItem(question).getQuestion());
		textField.setFont(new Font("±¼¸²", Font.BOLD, 19));
		textField.setEnabled(false);
		textField.setBounds(14, 51, 406, 34);
		panel.add(textField);
		textField.setColumns(10);

		

		JButton btnNewButton = new JButton("Yes");
		btnNewButton.setFont(new Font("±¼¸²", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int answer = 2;

				if (answer != 0) {
					match.processAnswer(question, answer, u);
					u.showWeight();
				
				if (q_count < q_max - 1) {
					
						q_count++;
						question = match.selectQestion(u);
						textField.setText(start.ql.getItem(question).getQuestion());
						buttonGroup.clearSelection();
					
				} else {
					// Result Section
					int result;
					result = match.resultMenu(u);
					ResultFrame rFrame = new ResultFrame(result,u);
					System.out.printf("\n°á°ú : %s\n", start.ml.getItem(result).getName());
					rFrame.setVisible(true);
					rFrame.setLocationRelativeTo(null);
					setVisible(false);
				}
				}
				
				
			}
		});
		btnNewButton.setBounds(101, 133, 96, 50);
		panel.add(btnNewButton);
		
		JButton button = new JButton("No");
		button.setFont(new Font("±¼¸²", Font.BOLD, 20));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				int answer = 1;

				if (answer != 0) {
					match.processAnswer(question, answer, u);
					u.showWeight();
				
				if (q_count < q_max - 1) {
					
						q_count++;
						question = match.selectQestion(u);
						textField.setText(start.ql.getItem(question).getQuestion());
						buttonGroup.clearSelection();
					
				} else {
					// Result Section
					int result;
					result = match.resultMenu(u);
					ResultFrame rFrame = new ResultFrame(result,u);
					System.out.printf("\n°á°ú : %s\n", start.ml.getItem(result).getName());
					rFrame.setVisible(true);
					rFrame.setLocationRelativeTo(null);
					setVisible(false);
				}
				}
				
				
				
				
			}
		});
		button.setBounds(231, 133, 96, 50);
		panel.add(button);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("100.jpg"));
		lblNewLabel.setBounds(0, 0, 434, 253);
		panel.add(lblNewLabel);




	}

}
