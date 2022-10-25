package Cars;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JEditorPane;
import javax.swing.ButtonGroup;
import java.awt.Color;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout.Group;

public class GUI_Staff extends JFrame {

	private JPanel contentPane;
	private JTextField txt_manhanvien_staff;
	private JTextField txt_tennhanvien_staff;
	private JTextField txt_diachi_staff;
	private JTextField txt_sdt_staff;
	private JTextField txt_namsinh_staff;
	private JTextField txt_luong_staff;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable table_staff;
	private JTextField txt_timkiem_staff;
	private JRadioButton rdb_nam_staff,rdb_nu_staff;

	private JComboBox<Object> cbx_vitri_staff ;
	private DefaultTableModel dtm = new DefaultTableModel();
	private Vector<String> columns = new Vector<String>();
	private Vector<Vector<Object>> rows = new Vector<>();
	private Process_Staff ps = new Process_Staff();
	private ArrayList<Staff> lst;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Staff frame = new GUI_Staff();
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
	public GUI_Staff() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1099, 663);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Thoát");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int hoi = JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát không?",
                        null, JOptionPane.YES_NO_OPTION);
                if (hoi == JOptionPane.YES_OPTION) {
                	dispose();
                }
			}
		});
		
		JButton btn_timkiem_staff_1 = new JButton("Tìm kiếm");
		btn_timkiem_staff_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getAllStaffbyName(txt_timkiem_staff.getText());
			}
		});
		btn_timkiem_staff_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_timkiem_staff_1.setBounds(781, 335, 118, 35);
		contentPane.add(btn_timkiem_staff_1);
		btnNewButton.setBounds(951, 588, 109, 38);
		contentPane.add(btnNewButton);
		
		txt_manhanvien_staff = new JTextField();
		txt_manhanvien_staff.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_manhanvien_staff.setBounds(258, 63, 133, 19);
		contentPane.add(txt_manhanvien_staff);
		txt_manhanvien_staff.setColumns(10);
		
		txt_tennhanvien_staff = new JTextField();
		txt_tennhanvien_staff.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_tennhanvien_staff.setColumns(10);
		txt_tennhanvien_staff.setBounds(258, 100, 133, 19);
		contentPane.add(txt_tennhanvien_staff);
		
		txt_diachi_staff = new JTextField();
		txt_diachi_staff.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_diachi_staff.setColumns(10);
		txt_diachi_staff.setBounds(753, 63, 146, 19);
		contentPane.add(txt_diachi_staff);
		
		txt_sdt_staff = new JTextField();
		txt_sdt_staff.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_sdt_staff.setColumns(10);
		txt_sdt_staff.setBounds(753, 100, 146, 19);
		contentPane.add(txt_sdt_staff);
		
		txt_namsinh_staff = new JTextField();
		txt_namsinh_staff.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_namsinh_staff.setColumns(10);
		txt_namsinh_staff.setBounds(258, 177, 133, 19);
		contentPane.add(txt_namsinh_staff);
		
		txt_luong_staff = new JTextField();
		txt_luong_staff.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_luong_staff.setColumns(10);
		txt_luong_staff.setBounds(753, 138, 146, 19);
		contentPane.add(txt_luong_staff);
		
		JLabel lblNewLabel = new JLabel("Mã nhân viên");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(83, 64, 122, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblTnNhnVin = new JLabel("Tên nhân viên");
		lblTnNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTnNhnVin.setBounds(83, 101, 122, 13);
		contentPane.add(lblTnNhnVin);
		
		JLabel lblVTr = new JLabel("Vị trí");
		lblVTr.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblVTr.setBounds(578, 180, 87, 13);
		contentPane.add(lblVTr);
		
		JLabel lblaCh = new JLabel("Địa chỉ");
		lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblaCh.setBounds(578, 69, 87, 13);
		contentPane.add(lblaCh);
		
		JLabel lblSDinThoi = new JLabel("Số diện thoại");
		lblSDinThoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSDinThoi.setBounds(578, 101, 109, 13);
		contentPane.add(lblSDinThoi);
		
		JLabel lblNmSinh = new JLabel("Năm sinh");
		lblNmSinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNmSinh.setBounds(83, 180, 87, 13);
		contentPane.add(lblNmSinh);
		
		JLabel lblLng = new JLabel("Lương");
		lblLng.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLng.setBounds(578, 137, 87, 20);
		contentPane.add(lblLng);
		
		JLabel lblGiiTnh = new JLabel("Giới tính");
		lblGiiTnh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGiiTnh.setBounds(83, 141, 87, 13);
		contentPane.add(lblGiiTnh);
		
		cbx_vitri_staff = new JComboBox();
		cbx_vitri_staff.setModel(new DefaultComboBoxModel(new String[] {"Vị trí", "Nhân viên", "Quản lý"}));
		cbx_vitri_staff.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbx_vitri_staff.setBounds(753, 181, 133, 21);
		contentPane.add(cbx_vitri_staff);
		
		rdb_nam_staff = new JRadioButton("Nam");
		buttonGroup.add(rdb_nam_staff);
		rdb_nam_staff.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdb_nam_staff.setBounds(258, 139, 87, 21);
		contentPane.add(rdb_nam_staff);
		
		rdb_nu_staff = new JRadioButton("Nữ");
		buttonGroup.add(rdb_nu_staff);
		rdb_nu_staff.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdb_nu_staff.setBounds(347, 139, 87, 21);
		contentPane.add(rdb_nu_staff);
		
		JButton btn_them_staff = new JButton("Thêm");
		btn_them_staff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertgetlistStaff();
			}
		});
		btn_them_staff.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_them_staff.setBounds(298, 226, 103, 38);
		contentPane.add(btn_them_staff);
		
		JButton btn_sua_staff = new JButton("Sửa");
		btn_sua_staff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdategetlistStaff();
			}
		});
		btn_sua_staff.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_sua_staff.setBounds(471, 226, 103, 38);
		contentPane.add(btn_sua_staff);
		
		JButton btn_xoa_staff = new JButton("Xóa");
		btn_xoa_staff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DelgetlistStaff();
		
			}
		});
		JButton btn_xoa_staff_1 = new JButton("Nhập lại");
		btn_xoa_staff_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteAll();
				btn_them_staff.setEnabled(true);
				txt_manhanvien_staff.setEnabled(true);
			}
		});
		btn_xoa_staff_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_xoa_staff_1.setBounds(799, 226, 116, 38);
		contentPane.add(btn_xoa_staff_1);
		btn_xoa_staff.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_xoa_staff.setBounds(642, 226, 103, 38);
		contentPane.add(btn_xoa_staff);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btn_them_staff.setEnabled(true);
				txt_manhanvien_staff.setEnabled(true);
				
			}
		});
		editorPane.setBackground(new Color(208, 208, 208));
		editorPane.setBounds(10, 56, 1065, 230);
		contentPane.add(editorPane);
		
		JLabel lblNewLabel_1 = new JLabel("Thiết lập thông tin nhân viên");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(406, 10, 281, 36);
		contentPane.add(lblNewLabel_1);
		
		table_staff = new JTable();
		table_staff.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
					int selectRow=table_staff.getSelectedRow();
					if(selectRow!=-1) {
						Vector<Object> row = rows.get(selectRow);
						txt_manhanvien_staff.setText(row.get(0).toString());
						txt_tennhanvien_staff.setText(row.get(1).toString());
						if(row.get(2).toString().equals("Nam"))
							rdb_nam_staff.setSelected(true);
						if(row.get(2).toString().equals("Nu"))
							rdb_nu_staff.setSelected(true);
						txt_namsinh_staff.setText(row.get(3).toString());
						txt_diachi_staff.setText(row.get(4).toString());
						txt_sdt_staff.setText(row.get(5).toString());
						txt_luong_staff.setText(row.get(6).toString());
						int vt = 0;
						if(row.get(7).toString().equals("Nhân Viên")) vt=1;
						if(row.get(7).toString().equals("Quản Lý")) vt=2;
						cbx_vitri_staff.setSelectedIndex(vt);
						btn_them_staff.setEnabled(false);
						txt_manhanvien_staff.setEnabled(false);
					
				}
				
			}
		});
		table_staff.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table_staff.setBounds(83, 381, 923, 201);
		contentPane.add(table_staff);
		
		txt_timkiem_staff = new JTextField();
		txt_timkiem_staff.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_timkiem_staff.setBounds(326, 335, 419, 36);
		contentPane.add(txt_timkiem_staff);
		txt_timkiem_staff.setColumns(10);
		
		JLabel lblTmKim = new JLabel("Tìm kiếm");
		lblTmKim.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTmKim.setBounds(229, 344, 87, 27);
		contentPane.add(lblTmKim);
		
		JEditorPane editorPane_1 = new JEditorPane();
		editorPane_1.setBackground(new Color(210, 210, 210));
		editorPane_1.setBounds(10, 323, 1065, 259);
		contentPane.add(editorPane_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Thông tin nhân viên");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(406, 289, 281, 36);
		contentPane.add(lblNewLabel_1_1);
		
		columns.add("Mã nhân viên");
		columns.add("Tên");
		columns.add("Giới tính");
		columns.add("Năm sinh");
		columns.add("Địa chỉ");
		columns.add("Số điện thoại");
		columns.add("Lương");
		columns.add("Vị trí");
		getAllStaff();
	}
	private void getAllStaff() {
		dtm.setNumRows(0);
		
		lst = ps.getListStaff();
		for(int i = 0; i < lst.size(); i++) {
			Staff t = (Staff)lst.get(i);
			Vector<Object> tbRow = new Vector<>();
			tbRow.add(t.getID());
			tbRow.add(t.getNAME());
			tbRow.add(t.getGIOI_TINH());
			tbRow.add(t.getNAM_SINH());
			tbRow.add(t.getDIA_CHI());
			tbRow.add(t.getSDT());
			tbRow.add(t.getLUONG());
			tbRow.add(t.getVI_TRI());
			
			rows.add(tbRow);
		}
		dtm.setDataVector(rows, columns);
		dtm.insertRow(0, columns);
		table_staff.setModel(dtm);
	}
	
	private void getAllStaffbyName(String NAME) {
		dtm.setNumRows(0);
		lst = ps.getListStaffbyNAME(NAME);
		for(int i = 0; i < lst.size(); i++) {
			Staff t = (Staff)lst.get(i);
			Vector<Object> tbRow = new Vector<>();
			tbRow.add(t.getID());
			tbRow.add(t.getNAME());
			tbRow.add(t.getGIOI_TINH());
			tbRow.add(t.getNAM_SINH());
			tbRow.add(t.getDIA_CHI());
			tbRow.add(t.getSDT());
			tbRow.add(t.getLUONG());
			tbRow.add(t.getVI_TRI());
			
			rows.add(tbRow);
		}
		
		dtm.setDataVector(rows, columns);
		dtm.insertRow(0, columns);
		table_staff.setModel(dtm);
		if(NAME=="") getAllStaff();	
	
	}
	private String gioitinh_staff;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	
	
	private void InsertgetlistStaff() {
		String MaNv = txt_manhanvien_staff.getText();
		String TenNv = txt_tennhanvien_staff.getText();
		if(rdb_nam_staff.isSelected()) {
			gioitinh_staff="Nam";
		}
		else gioitinh_staff="Nu";
		String GioiTinh = gioitinh_staff.toString();
		String NamSinh = txt_namsinh_staff.getText();
		String DiaChi = txt_diachi_staff.getText();
		String Sdt = txt_sdt_staff.getText();
		String Luong = txt_luong_staff.getText();
		String Vitri = cbx_vitri_staff.getSelectedItem() + "";
		ps.Insert_getlistStaff(MaNv, TenNv,GioiTinh, NamSinh, DiaChi,Sdt,Luong,Vitri);
		getAllStaff();
	
	}
	private void UpdategetlistStaff() {
		String MaNv = txt_manhanvien_staff.getText();
		String TenNv = txt_tennhanvien_staff.getText();
		if(rdb_nam_staff.isSelected()) {
			gioitinh_staff="Nam";
		}
		else if(rdb_nu_staff.isSelected())
			gioitinh_staff="Nu";
		String GioiTinh = gioitinh_staff.toString();
		String NamSinh = txt_namsinh_staff.getText();
		String DiaChi = txt_diachi_staff.getText();
		String Sdt = txt_sdt_staff.getText();
		String Luong = txt_luong_staff.getText();
		String Vitri = cbx_vitri_staff.getSelectedItem() + "";
		ps.Update_getlistStaff(MaNv, TenNv,GioiTinh, NamSinh, DiaChi,Sdt,Luong,Vitri);
		getAllStaff();
	
	}
	private void DelgetlistStaff() {
		String MaNv = txt_manhanvien_staff.getText();
		ps.Del_getlistStaff(MaNv);
		getAllStaff();
	
	}
	private void DeleteAll() {
		
		txt_manhanvien_staff.setText("");;
		txt_tennhanvien_staff.setText("");
	
		buttonGroup.clearSelection();
		txt_namsinh_staff.setText("");
		txt_diachi_staff.setText("");
		txt_sdt_staff.setText("");
		txt_luong_staff.setText("");
		cbx_vitri_staff.setSelectedIndex(0);
	}
}