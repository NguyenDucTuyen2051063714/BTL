package Cars;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JEditorPane;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUI_KhachHang extends JFrame {

	private JPanel contentPane;
	private JTextField txt_makhachhang_khachhang;
	private JTextField txt_tenkhachhang_khachhang;
	private JTextField txt_sdt_khachhang;
	private JTextField txt_namsinh_khachhang;
	private JTextField txt_diachi_khachhang;
	private JTextField txt_timkiem_khachhang;
	private JTable table;
	private final JTable table_khachhang = new JTable();
	private JRadioButton  rdb_nam_khachhang, rdb_nu_khachhang;

	
	private DefaultTableModel dtm = new DefaultTableModel();
	private Vector<String> columns = new Vector<String>();
	private Vector<Vector<Object>> rows = new Vector<>();
	private Process_Customer ps = new Process_Customer();
	private ArrayList<Customer> lst;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_KhachHang frame = new GUI_KhachHang();
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
	public GUI_KhachHang() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1007, 666);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		table_khachhang.setBounds(36, 369, 875, 174);
		contentPane.add(table_khachhang);
		
		JButton btn_timkiem_khachhang = new JButton("Tìm kiếm");
		btn_timkiem_khachhang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getAllCustomerbyName(txt_timkiem_khachhang.getText());
			}
		});
		btn_timkiem_khachhang.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btn_timkiem_khachhang.setBounds(746, 315, 120, 28);
		contentPane.add(btn_timkiem_khachhang);
		
		JLabel lblNewLabel = new JLabel("Tên khách hàng");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(48, 88, 158, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblMKhchHng = new JLabel("Mã khách hàng");
		lblMKhchHng.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblMKhchHng.setBounds(48, 49, 158, 36);
		contentPane.add(lblMKhchHng);
		
		JLabel lblSt = new JLabel("Số điện thoại");
		lblSt.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSt.setBounds(529, 130, 120, 36);
		contentPane.add(lblSt);
		
		JLabel lblGiiTnh = new JLabel("Giới tính");
		lblGiiTnh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblGiiTnh.setBounds(48, 130, 104, 36);
		contentPane.add(lblGiiTnh);
		
		JLabel lblNmSinh = new JLabel("Năm sinh");
		lblNmSinh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNmSinh.setBounds(529, 49, 158, 36);
		contentPane.add(lblNmSinh);
		
		JLabel lblaCh = new JLabel("Địa chỉ");
		lblaCh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblaCh.setBounds(529, 88, 99, 36);
		contentPane.add(lblaCh);
		
		txt_makhachhang_khachhang = new JTextField();
		txt_makhachhang_khachhang.setBounds(216, 55, 198, 28);
		contentPane.add(txt_makhachhang_khachhang);
		txt_makhachhang_khachhang.setColumns(10);
		
		txt_tenkhachhang_khachhang = new JTextField();
		txt_tenkhachhang_khachhang.setColumns(10);
		txt_tenkhachhang_khachhang.setBounds(216, 94, 198, 28);
		contentPane.add(txt_tenkhachhang_khachhang);
		
		txt_sdt_khachhang = new JTextField();
		txt_sdt_khachhang.setColumns(10);
		txt_sdt_khachhang.setBounds(649, 136, 198, 28);
		contentPane.add(txt_sdt_khachhang);
		
		txt_namsinh_khachhang = new JTextField();
		txt_namsinh_khachhang.setColumns(10);
		txt_namsinh_khachhang.setBounds(649, 55, 198, 28);
		contentPane.add(txt_namsinh_khachhang);
		
		txt_diachi_khachhang = new JTextField();
		txt_diachi_khachhang.setColumns(10);
		txt_diachi_khachhang.setBounds(649, 94, 198, 28);
		contentPane.add(txt_diachi_khachhang);
		
		JButton btn_them_khachhang = new JButton("Thêm");
		btn_them_khachhang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Insertgetlistcustomer();
			}
		});
		btn_them_khachhang.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btn_them_khachhang.setBounds(240, 186, 99, 32);
		contentPane.add(btn_them_khachhang);
		
		JButton btn_sua_khachhang = new JButton("Sửa");
		btn_sua_khachhang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Updategetlistcustomer();
			}
		});
		btn_sua_khachhang.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btn_sua_khachhang.setBounds(375, 188, 99, 28);
		contentPane.add(btn_sua_khachhang);
		
		JButton btn_xoa_khachhang = new JButton("Xóa");
		btn_xoa_khachhang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delgetlistcustomer();
				DeleteAll();
				btn_them_khachhang.setEnabled(true);
				txt_makhachhang_khachhang.setEnabled(true);
			}
		});
		btn_xoa_khachhang.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btn_xoa_khachhang.setBounds(514, 188, 99, 28);
		contentPane.add(btn_xoa_khachhang);
		JButton btn_nhaplai_khachhang = new JButton("Nhập lại");
		btn_nhaplai_khachhang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteAll();
				btn_them_khachhang.setEnabled(true);
				txt_makhachhang_khachhang.setEnabled(true);
			}
		});
		btn_nhaplai_khachhang.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btn_nhaplai_khachhang.setBounds(655, 188, 124, 28);
		contentPane.add(btn_nhaplai_khachhang);
		JLabel lblTmKim = new JLabel("Tìm Kiếm");
		lblTmKim.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTmKim.setBounds(33, 310, 99, 36);
		contentPane.add(lblTmKim);
		
		txt_timkiem_khachhang = new JTextField();
		txt_timkiem_khachhang.setBounds(128, 315, 588, 28);
		contentPane.add(txt_timkiem_khachhang);
		txt_timkiem_khachhang.setColumns(10);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBackground(new Color(210, 210, 210));
		editorPane.setBounds(10, 289, 928, 276);
		contentPane.add(editorPane);
		
		JLabel lblNewLabel_1 = new JLabel("Thông tin khách hàng");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_1.setBounds(365, 266, 235, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Thiết lập thông tin khách hàng");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_1_1.setBounds(365, 10, 235, 21);
		contentPane.add(lblNewLabel_1_1);
		
		 rdb_nam_khachhang = new JRadioButton("Nam");
		 buttonGroup_1.add(rdb_nam_khachhang);
		rdb_nam_khachhang.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rdb_nam_khachhang.setBounds(216, 137, 81, 23);
		contentPane.add(rdb_nam_khachhang);
		
		 rdb_nu_khachhang = new JRadioButton("Nữ");
		 buttonGroup_1.add(rdb_nu_khachhang);
		rdb_nu_khachhang.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rdb_nu_khachhang.setBounds(299, 137, 111, 23);
		contentPane.add(rdb_nu_khachhang);
		
		JEditorPane editorPane_1 = new JEditorPane();
		editorPane_1.setBackground(new Color(207, 207, 207));
		editorPane_1.setBounds(10, 29, 928, 227);
		contentPane.add(editorPane_1);
		
		table_khachhang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int selectRow=table_khachhang.getSelectedRow();
				if(selectRow!=-1) {
					Vector<Object> row = rows.get(selectRow);
					txt_makhachhang_khachhang.setText(row.get(0).toString());
					txt_tenkhachhang_khachhang.setText(row.get(1).toString());
					if(row.get(2).toString().equals("Nam"))
						rdb_nam_khachhang.setSelected(true);
					if(row.get(2).toString().equals("Nu"))
						rdb_nu_khachhang.setSelected(true);
					txt_namsinh_khachhang.setText(row.get(3).toString());
					txt_diachi_khachhang.setText(row.get(4).toString());
					txt_sdt_khachhang.setText(row.get(5).toString());
					btn_them_khachhang.setEnabled(false);
					txt_makhachhang_khachhang.setEnabled(false);
				
			}
			}
		});
		JButton btnThot = new JButton("Thoát");
		btnThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int hoi = JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát không?",
                        null, JOptionPane.YES_NO_OPTION);
                if (hoi == JOptionPane.YES_OPTION) {
                	dispose();
                }
			}
		});
		btnThot.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnThot.setBounds(879, 583, 90, 36);
		contentPane.add(btnThot);
		
		table = new JTable();
		table.setBounds(33, 369, 746, 174);
		contentPane.add(table);
		columns.add("Mã khách hàng");
		columns.add("Tên");
		columns.add("Giới tính");
		columns.add("Năm sinh");
		columns.add("Địa chỉ");
		columns.add("Số điện thoại");
		getAllCustomer();
	}
	private void getAllCustomer() {
		dtm.setNumRows(0);
		
		lst = ps.getListCustomer();
		for(int i = 0; i < lst.size(); i++) {
			Customer t = (Customer)lst.get(i);
			Vector<Object> tbRow = new Vector<>();
			tbRow.add(t.getID());
			tbRow.add(t.getNAME());
			tbRow.add(t.getGIOI_TINH());
			tbRow.add(t.getNAM_SINH());
			tbRow.add(t.getDIA_CHI());
			tbRow.add(t.getSDT());
			
			rows.add(tbRow);
		}
		dtm.setDataVector(rows, columns);
		dtm.insertRow(0, columns);
		table_khachhang.setModel(dtm);
	}
	private void getAllCustomerbyName(String NAME) {
		dtm.setNumRows(0);
		lst = ps. getListCustomerbyName(NAME);
		for(int i = 0; i < lst.size(); i++) {
			Customer t = (Customer)lst.get(i);
			Vector<Object> tbRow = new Vector<>();
			tbRow.add(t.getID());
			tbRow.add(t.getNAME());
			tbRow.add(t.getGIOI_TINH());
			tbRow.add(t.getNAM_SINH());
			tbRow.add(t.getDIA_CHI());
			tbRow.add(t.getSDT());
			
			rows.add(tbRow);
		}
		
		dtm.setDataVector(rows, columns);
		dtm.insertRow(0, columns);
		table_khachhang.setModel(dtm);
		if(NAME=="") getAllCustomer();	
	
	}
	private String gioitinh_customer;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	
	
	private void Insertgetlistcustomer() {
		String MaNv = txt_makhachhang_khachhang.getText();
		String TenNv = txt_tenkhachhang_khachhang.getText();
		if(rdb_nam_khachhang.isSelected()) {
			gioitinh_customer="Nam";
		}
		else  gioitinh_customer="Nu";
		String GioiTinh = gioitinh_customer.toString();
		String NamSinh = txt_namsinh_khachhang.getText();
		String DiaChi = txt_diachi_khachhang.getText();
		String Sdt = txt_sdt_khachhang.getText();
		ps.Insert_getlistCustomer(MaNv, TenNv,GioiTinh, NamSinh, DiaChi,Sdt);
		getAllCustomer();
	
	}
	private void Updategetlistcustomer() {
		String MaNv = txt_makhachhang_khachhang.getText();
		String TenNv = txt_tenkhachhang_khachhang.getText();
		if(rdb_nam_khachhang.isSelected()) {
			gioitinh_customer="Nam";
		}
		else  gioitinh_customer="Nu";
		String GioiTinh = gioitinh_customer.toString();
		String NamSinh = txt_namsinh_khachhang.getText();
		String DiaChi = txt_diachi_khachhang.getText();
		String Sdt = txt_sdt_khachhang.getText();
		ps.Update_getlistCustomer(MaNv, TenNv,GioiTinh, NamSinh, DiaChi,Sdt);
		getAllCustomer();
	
	}
	private void Delgetlistcustomer() {
		String MaNv = txt_makhachhang_khachhang.getText();
		String TenNv = txt_tenkhachhang_khachhang.getText();
		if(rdb_nam_khachhang.isSelected()) {
			gioitinh_customer="Nam";
		}
		else  gioitinh_customer="Nu";
		String GioiTinh = gioitinh_customer.toString();
		String NamSinh = txt_namsinh_khachhang.getText();
		String DiaChi = txt_diachi_khachhang.getText();
		String Sdt = txt_sdt_khachhang.getText();
		ps.Del_getlistCustomer(MaNv, TenNv,GioiTinh, NamSinh, DiaChi,Sdt);
		getAllCustomer();
	
	}
	private void DeleteAll() {
		
		txt_makhachhang_khachhang.setText("");;
		txt_tenkhachhang_khachhang.setText("");
	
		buttonGroup_1.clearSelection();
		txt_namsinh_khachhang.setText("");
		txt_diachi_khachhang.setText("");
		txt_sdt_khachhang.setText("");
		
		
	}
}