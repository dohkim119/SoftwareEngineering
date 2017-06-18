import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.SystemColor;

public class RandomFrame extends JFrame {

   private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblNewLabel_1;
	private JLabel label;
	private JLabel lblNewLabel_2;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               RandomFrame frame = new RandomFrame();
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
   public RandomFrame() {
      int i = (int) (Math.random() * 28) + 1;
      MenuList ml = start.ml;
      Menu m = ml.getItem(i);

      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 562, 463);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);

      JLabel lblNewLabel = new JLabel("");
      lblNewLabel.setIcon(new ImageIcon(m.fil));
      lblNewLabel.setBounds(137, 12, 268, 233);
      lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
      contentPane.add(lblNewLabel);

      textField = new JTextField();
      textField.setBackground(Color.BLACK);
      textField.setHorizontalAlignment(SwingConstants.CENTER);
      textField.setFont(new Font("±¼¸²", Font.PLAIN, 19));
      textField.setText(m.name);
      textField.setBounds(137, 266, 268, 35);
      contentPane.add(textField);
      textField.setEnabled(false);
      textField.setColumns(10);

      textField_1 = new JTextField();
      textField_1.setBackground(Color.BLACK);
      textField_1.setText(m.position + " ) " +m.Sname);
      textField_1.setHorizontalAlignment(SwingConstants.CENTER);
      textField_1.setFont(new Font("±¼¸²", Font.PLAIN, 19));
      textField_1.setEnabled(false);
      textField_1.setColumns(10);
      textField_1.setBounds(137, 311, 268, 35);
      contentPane.add(textField_1);
      
      lblNewLabel_1 = new JLabel("\uC74C\uC2DD :");
      lblNewLabel_1.setForeground(SystemColor.inactiveCaption);
      lblNewLabel_1.setFont(new Font("±¼¸²", Font.BOLD, 19));
      lblNewLabel_1.setBounds(74, 266, 68, 35);
      contentPane.add(lblNewLabel_1);
      
      label = new JLabel("\uC7A5\uC18C :");
      label.setForeground(SystemColor.inactiveCaption);
      label.setFont(new Font("±¼¸²", Font.BOLD, 19));
      label.setBounds(74, 311, 68, 35);
      contentPane.add(label);
      
      lblNewLabel_2 = new JLabel("");
      lblNewLabel_2.setIcon(new ImageIcon("200.png"));
      lblNewLabel_2.setBounds(0, 0, 546, 424);
      contentPane.add(lblNewLabel_2);


   }
}