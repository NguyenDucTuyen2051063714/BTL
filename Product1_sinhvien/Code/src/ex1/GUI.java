package ex1;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField txt_MaSv;
	private JTextField txt_TenSv;
	private JTextField txt_ClassSv;
	private JTextField txt_Diem;
	private JTable table;
	private JRadioButton rdb_nam,rdb_nu;
	private ButtonGroup buttonGroup_1= new ButtonGroup();
	
	
	private DefaultTableModel dtm = new DefaultTableModel();
	private Vector<String> columns = new Vector<String>();
	private Vector<Vector<Object>> rows = new Vector<>();
	private Process_Sinhvien ps = new Process_Sinhvien();
	private ArrayList<Sinhvien> lst;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 738, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txt_MaSv = new JTextField();
		txt_MaSv.setBackground(Color.CYAN);
		txt_MaSv.setColumns(10);
		txt_MaSv.setBounds(135, 35, 86, 20);
		contentPane.add(txt_MaSv);
		
		txt_TenSv = new JTextField();
		txt_TenSv.setBackground(Color.CYAN);
		txt_TenSv.setColumns(10);
		txt_TenSv.setBounds(135, 66, 86, 20);
		contentPane.add(txt_TenSv);
		
		txt_ClassSv = new JTextField();
		txt_ClassSv.setBackground(Color.CYAN);
		txt_ClassSv.setColumns(10);
		txt_ClassSv.setBounds(400, 35, 86, 20);
		contentPane.add(txt_ClassSv);
		
		txt_Diem = new JTextField();
		txt_Diem.setBackground(Color.CYAN);
		txt_Diem.setColumns(10);
		txt_Diem.setBounds(400, 66, 86, 20);
		contentPane.add(txt_Diem);
		
		rdb_nam = new JRadioButton("Nam");
		buttonGroup_1.add(rdb_nam);
		rdb_nam.setBounds(135, 96, 55, 23);
		contentPane.add(rdb_nam);
		
		rdb_nu = new JRadioButton("Nữ");
		buttonGroup_1.add(rdb_nu);
		rdb_nu.setBounds(192, 96, 47, 23);
		contentPane.add(rdb_nu);
		
		JTextPane txtpnMSinhVin = new JTextPane();
		txtpnMSinhVin.setBackground(SystemColor.control);
		txtpnMSinhVin.setText("Mã sinh viên");
		txtpnMSinhVin.setBounds(39, 35, 86, 20);
		contentPane.add(txtpnMSinhVin);
		
		JTextPane txtpnTnSinhVin = new JTextPane();
		txtpnTnSinhVin.setText("Tên sinh viên");
		txtpnTnSinhVin.setBackground(SystemColor.control);
		txtpnTnSinhVin.setBounds(39, 66, 86, 20);
		contentPane.add(txtpnTnSinhVin);
		
		JTextPane txtpnGiiTnh = new JTextPane();
		txtpnGiiTnh.setText("Giơi tính");
		txtpnGiiTnh.setBackground(SystemColor.control);
		txtpnGiiTnh.setBounds(39, 96, 86, 20);
		contentPane.add(txtpnGiiTnh);
		
		JTextPane txtpnLp = new JTextPane();
		txtpnLp.setText("Lớp");
		txtpnLp.setBackground(SystemColor.control);
		txtpnLp.setBounds(343, 35, 47, 20);
		contentPane.add(txtpnLp);
		
		JTextPane txtpnim = new JTextPane();
		txtpnim.setText("Điểm");
		txtpnim.setBackground(SystemColor.control);
		txtpnim.setBounds(343, 66, 47, 20);
		contentPane.add(txtpnim);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectRow=table.getSelectedRow();
				if(selectRow!=-1) {
					Vector<Object> row = rows.get(selectRow);
					txt_MaSv.setText(row.get(0).toString());
					txt_TenSv.setText(row.get(1).toString());
					if(row.get(2).toString().equals("Nam"))
						rdb_nam.setSelected(true);
					if(row.get(2).toString().equals("Nữ"))
						rdb_nu.setSelected(true);
					txt_ClassSv.setText(row.get(3).toString());
					txt_Diem.setText(row.get(4).toString());
				}
			}
		});
		table.setBackground(Color.CYAN);
		table.setBounds(39, 182, 643, 233);
		contentPane.add(table);
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Insertgetlist();
			}
		});
		btnNewButton.setBounds(116, 126, 86, 32);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sửa");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Updategetlist();
			}
		});
		btnNewButton_1.setBounds(212, 126, 86, 32);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Xóa");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delgetlist();
			}
		});
		btnNewButton_2.setBounds(308, 126, 86, 32);
		contentPane.add(btnNewButton_2);
		
		JButton btnLmMi = new JButton("Làm mới");
		btnLmMi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteAll();
			}
		});
		btnLmMi.setBounds(508, 126, 86, 32);
		contentPane.add(btnLmMi);
		columns.add("Mã sinh viên");
		columns.add("Tên sinh viên");
		columns.add("Giới tính");
		columns.add("Lớp");
		columns.add("Điểm");
		getAll();
	}
	private void getAll() {
		dtm.setNumRows(0);
		
		lst = ps.getList();
		for(int i = 0; i < lst.size(); i++) {
			Sinhvien t = (Sinhvien)lst.get(i);
			Vector<Object> tbRow = new Vector<>();
			tbRow.add(t.getMaSv());
			tbRow.add(t.getTenSv());
			tbRow.add(t.getGender());
			tbRow.add(t.getClassSv());
			tbRow.add(t.getDiem());		
			rows.add(tbRow);
		}
		dtm.setDataVector(rows, columns);
		dtm.insertRow(0, columns);
		table.setModel(dtm);
	}
	private String masv,tensv,gender,classsv,diem;
	private void getValue(){
		
		masv = txt_MaSv.getText();
		tensv = txt_TenSv.getText();
		if(rdb_nam.isSelected()) {
			gender="Nam";
		}
		else  gender="Nữ";
		classsv = txt_ClassSv.getText();
		diem = txt_Diem.getText();
		
	}
	private void Insertgetlist() {
		
		getValue();
		ps.Insert(masv, tensv,gender, classsv, diem);
		getAll();
		DeleteAll();
	}
	
	private void Updategetlist() {
		getValue();
		ps.Update(masv, tensv,gender, classsv, diem);
		getAll();
		DeleteAll();
	
	}
	private void Delgetlist() {
		getValue();
		ps.Delete(masv);
		getAll();
		DeleteAll();
	
	}
	private void DeleteAll() {
		
		txt_MaSv.setText("");;
		txt_TenSv.setText("");
		buttonGroup_1.clearSelection();
		txt_ClassSv.setText("");
		txt_Diem.setText("");
		
		
	}
}
