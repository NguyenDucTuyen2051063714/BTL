package Cars;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import java.awt.SystemColor;

public class GUI_ThongKe extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField_2;
	private JTextField txtDoanhThu;
	private JTextField txtSHan;
	private JTextField txtTngKhch;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_ThongKe frame = new GUI_ThongKe();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI_ThongKe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 958, 602);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Thoát");
		btnNewButton.setBounds(836, 504, 98, 51);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int hoi = JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát không?",
                        null, JOptionPane.YES_NO_OPTION);
                if (hoi == JOptionPane.YES_OPTION) {
                	dispose();
                }
			}
		});
		contentPane.setLayout(null);
		
		txtTngKhch = new JTextField();
		txtTngKhch.setText("Tổng khách");
		txtTngKhch.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		txtTngKhch.setColumns(10);
		txtTngKhch.setBounds(484, 30, 134, 36);
		contentPane.add(txtTngKhch);
		
		txtSHan = new JTextField();
		txtSHan.setText("Số hóa đơn");
		txtSHan.setFont(new Font("Bahnschrift", Font.BOLD, 22));
		txtSHan.setColumns(10);
		txtSHan.setBounds(263, 30, 134, 36);
		contentPane.add(txtSHan);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Thống kê");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(380, 113, 103, 59);
		contentPane.add(lblNewLabel);
		
		table = new JTable();
		table.setBounds(84, 220, 770, 260);
		contentPane.add(table);
		
		JEditorPane editorPane_1 = new JEditorPane();
		editorPane_1.setBackground(SystemColor.inactiveCaption);
		editorPane_1.setBounds(234, 11, 191, 117);
		contentPane.add(editorPane_1);
		
		txtDoanhThu = new JTextField();
		txtDoanhThu.setFont(new Font("Snap ITC", Font.BOLD, 25));
		txtDoanhThu.setText("Doanh thu");
		txtDoanhThu.setBounds(39, 24, 174, 36);
		contentPane.add(txtDoanhThu);
		txtDoanhThu.setColumns(10);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBackground(SystemColor.scrollbar);
		editorPane.setBounds(33, 11, 191, 117);
		contentPane.add(editorPane);
		
		JEditorPane editorPane_1_1 = new JEditorPane();
		editorPane_1_1.setBackground(SystemColor.activeCaptionBorder);
		editorPane_1_1.setBounds(450, 11, 191, 117);
		contentPane.add(editorPane_1_1);
		
		textField = new JTextField();
		textField.setBounds(49, 71, 118, 51);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(286, 522, 228, 19);
	}
}