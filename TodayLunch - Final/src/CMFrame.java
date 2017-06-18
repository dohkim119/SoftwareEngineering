import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class CMFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	public String fil;
	public String position;
	public String Sname;
	int i;
	private PrintWriter print1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CMFrame frame = new CMFrame();
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
	public CMFrame() {
		super.setTitle("오늘의 점심");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
				new String[] { "메뉴", "밥", "국", "면", "빵", "고기", "매움", "느끼함", "따뜻함", "해장", "국적", "시간","위치","식당명" }));
		scrollPane.setViewportView(table);
		table.setEnabled(false);
		// 테이블 색깔 폰트 설정
		table.setBackground(Color.LIGHT_GRAY);
		table.setForeground(Color.BLACK);
		Font font = new Font("", 1, 22);
		table.setFont(font);
		table.setRowHeight(30);
		
		table.getColumn("메뉴").setPreferredWidth(200);
		table.getColumn("식당명").setPreferredWidth(340);
		
		Object[] row = new Object[14];
		// 테이블에 스트링 입력하기
	    	
		for (i = 0; i < start.ml.getNumberOfItem(); i++) {
			MenuList ml = start.ml;	
			Menu m = ml.getItem(i);
		     row[0] = m.name;
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
		     row[12] = m.position;
		     row[13] = m.Sname;
			((DefaultTableModel) table.getModel()).addRow(row);
		}
		JLabel lblNewLabel = new JLabel("메뉴명");
		lblNewLabel.setBounds(10, 222, 62, 18);
		contentPane.add(lblNewLabel);

		JLabel label = new JLabel("속성값");
		label.setBounds(10, 252, 62, 18);
		contentPane.add(label);

		JLabel label_1 = new JLabel("위치");
		label_1.setBounds(10, 285, 62, 18);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("가게이름");
		label_2.setBounds(10, 315, 62, 18);
		contentPane.add(label_2);

		textField = new JTextField();
		textField.setBounds(75, 219, 116, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(75, 249, 116, 24);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(75, 282, 116, 24);
		contentPane.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(75, 312, 116, 24);
		contentPane.add(textField_3);
		
		JButton btnNewButton = new JButton("추가");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					i++;
					print1 = new PrintWriter(new FileWriter("menu.txt", true));
			
					print1.write("\r\n" + textField_1.getText() + "-" + textField.getText() + "-" + 
					i + "-" +textField_2.getText() + "-" + textField_3.getText());
					String split[] = textField_1.getText().split("");
					
					Menu menu = new Menu(textField.getText(), 
							Integer.parseInt(split[0])-1,	Integer.parseInt(split[1])-1,	Integer.parseInt(split[2])-1,
							Integer.parseInt(split[3])-1, 	Integer.parseInt(split[4])-1, 	Integer.parseInt(split[5])-1,
							Integer.parseInt(split[6])-1, 	Integer.parseInt(split[7])-1, 	Integer.parseInt(split[8])-1,
							Integer.parseInt(split[9])-1, 	Integer.parseInt(split[10])-1
								,i+".png", textField_2.getText(), textField_3.getText());
					start.ml.setItem(menu);
		
					
				     row[0] = menu.name;
				     row[1] = menu.isRice();
				     row[2] = menu.isSoup();
				     row[3] = menu.isNoodle();
				     row[4] = menu.isBread();
				     row[5] = menu.isMeat();
				     row[6] = menu.isSpicy();
				     row[7] = menu.isOily();
				     row[8] = menu.isHot();
				     row[9] = menu.isSober();
				     row[10] = menu.isNation();
				     row[11] = menu.isFastFood();
				     row[12] = menu.position;
				     row[13] = menu.Sname;
					((DefaultTableModel) table.getModel()).addRow(row);
				
					
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
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
