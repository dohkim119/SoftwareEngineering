import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CQFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private PrintWriter print1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CQFrame frame = new CQFrame();
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
	public CQFrame() {
		setTitle("\uC624\uB298\uC758 \uC810\uC2EC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 402);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		// 스크롤 설정
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1168, 210);
		contentPane.add(scrollPane);

		// 스크롤에 table 넣기
		scrollPane.setViewportView(table);

		// 테이블 만들기
		DefaultTableModel model = new DefaultTableModel();
		JTable table = new JTable(model);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "질문", "밥", "국", "면", "빵", "고기", "매움", "느끼함", "따뜻함", "해장", "국적", "시간" }));
		scrollPane.setViewportView(table);
		table.setEnabled(false);
		// 테이블 색깔 폰트 설정
		table.setBackground(Color.LIGHT_GRAY);
		table.setForeground(Color.BLACK);
		Font font = new Font("", 1, 22);
		table.setFont(font);
		table.setRowHeight(30);
		
		JLabel label = new JLabel("질문");
		label.setBounds(14, 240, 62, 18);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(70, 237, 327, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("속성값");
		lblNewLabel.setBounds(14, 283, 62, 18);
		contentPane.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(70, 280, 109, 24);
		contentPane.add(textField_1);
		
		table.getColumn("질문").setPreferredWidth(600);
		Object[] row = new Object[12];
		// 테이블에 스트링 입력하기
	    	
		for (int i = 0; i < start.ql.getNumberOfItem(); i++) {
			QuestionList ql = start.ql;	
			Question m = ql.getItem(i);
		     row[0] = m.getQuestion();
		     row[1] = m.isRice();
		     row[2] = m.isSoup();
		     row[3] = m.isNoodle();
		     row[4] = m.isBread();
		     row[5] = m.isMeat();
		     row[6] = m.isSpicy();
		     row[7] = m.isOily();
		     row[8] = m.isHot();
		     row[9] = m.isSober();
		     row[10] = m.isNation();
		     row[11] = m.isFastFood();
			((DefaultTableModel) table.getModel()).addRow(row);
		}
		
		JButton btnNewButton = new JButton("추가");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					print1 = new PrintWriter(new FileWriter("question.txt", true));
			
					print1.write("\r\n" + textField_1.getText() + "-" + textField.getText());
					String split[] = textField_1.getText().split("");
					
					Question question = new Question(textField.getText(), 
							Integer.parseInt(split[0]),	Integer.parseInt(split[1]),	Integer.parseInt(split[2]),
							Integer.parseInt(split[3]), 	Integer.parseInt(split[4]), 	Integer.parseInt(split[5]),
							Integer.parseInt(split[6]), 	Integer.parseInt(split[7]), 	Integer.parseInt(split[8]),
							Integer.parseInt(split[9]), 	Integer.parseInt(split[10]));
					start.ql.setItem(question);
		
					
				     row[0] = question.getQuestion();
				     row[1] = question.isRice();
				     row[2] = question.isSoup();
				     row[3] = question.isNoodle();
				     row[4] = question.isBread();
				     row[5] = question.isMeat();
				     row[6] = question.isSpicy();
				     row[7] = question.isOily();
				     row[8] = question.isHot();
				     row[9] = question.isSober();
				     row[10] = question.isNation();
				     row[11] = question.isFastFood();
					((DefaultTableModel) table.getModel()).addRow(row);
				
					textField.setText("");
					textField_1.setText("");
					print1.close();
					JOptionPane.showMessageDialog(null, "추가 완료되었습니다.");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(425, 237, 116, 85);
		contentPane.add(btnNewButton);

		JButton button = new JButton("goto main");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserFrame uFrame = new UserFrame();
				uFrame.setVisible(true);
				uFrame.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		button.setBounds(770, 237, 116, 85);
		contentPane.add(button);

		// contentPane.setLayout(gl_contentPane);
		table.getTableHeader().setReorderingAllowed(false); // 순서고정
		table.getTableHeader().setResizingAllowed(false); // 사이즈 고정

	}
}
