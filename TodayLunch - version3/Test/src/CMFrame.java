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
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
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
	private Scanner input1;

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
		setBounds(100, 100, 982, 402);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// 스크롤 설정
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 964, 210);
		contentPane.add(scrollPane);

		// 스크롤에 table 넣기
		scrollPane.setViewportView(table);

		// 테이블 만들기
		DefaultTableModel model = new DefaultTableModel();
		JTable table = new JTable(model);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "메뉴", "밥", "국", "면", "빵", "고기", "매움", "느끼함", "따뜻함", "해장", "국적", "시간" }));
		scrollPane.setViewportView(table);
		table.setEnabled(false);
		// 테이블 색깔 폰트 설정
		table.setBackground(Color.LIGHT_GRAY);
		table.setForeground(Color.BLACK);
		Font font = new Font("", 1, 22);
		table.setFont(font);
		table.setRowHeight(30);
		// ArrayList 객체 생성
		ArrayList<MenuList> lists = ReadItemList1();

		Object[] row = new Object[12];
		// 테이블에 스트링 입력하기
		for (int i = 0; i < lists.size(); i++) {
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
		btnNewButton.setBounds(425, 237, 116, 85);
		contentPane.add(btnNewButton);

		JButton button = new JButton("goto main");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StartFrame sFrame = new StartFrame();
				sFrame.setVisible(true);
				sFrame.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		button.setBounds(770, 237, 116, 85);
		contentPane.add(button);

		// contentPane.setLayout(gl_contentPane);
		table.getTableHeader().setReorderingAllowed(false); // 순서고정
		table.getTableHeader().setResizingAllowed(false); // 사이즈 고정
		
	}

	public ArrayList<MenuList> ReadItemList1() {
		ArrayList<MenuList> list1 = new ArrayList<MenuList>();
		Scanner input = ItemInven1();

		while (input.hasNext()) {

			String line = input.nextLine();
			String[] split = line.split("-");
			String[] split2 = split[0].split("");
			fil = split[2] + ".png";
			position = split[3];
			Sname = split[4];
			String name = split[1];
			int rice = Integer.parseInt(split2[0]);
			int soup = Integer.parseInt(split2[1]);
			int noodle = Integer.parseInt(split2[2]);
			int bread = Integer.parseInt(split2[3]);
			int meat = Integer.parseInt(split2[4]);
			int spicy = Integer.parseInt(split2[5]);
			int oily = Integer.parseInt(split2[6]);
			int hot = Integer.parseInt(split2[7]);
			int sober = Integer.parseInt(split2[8]);
			int notkorean = Integer.parseInt(split2[9]);
			int fastfood = Integer.parseInt(split2[10]);

			Menu menu = new Menu(name, rice, soup, noodle, bread, meat, spicy, oily, sober, hot, notkorean, fastfood,
					fil, position, Sname);
			list1.add(list);
		}

		return list1;
	}

	public Scanner ItemInven1() {

		try {
			input1 = new Scanner(Paths.get("Menu.txt"));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "No such file!");
		}

		return input1;
	}
}
