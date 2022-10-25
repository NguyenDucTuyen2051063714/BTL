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
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTree;

public class GUI_Car_BanHang extends JFrame{

	private JPanel contentPane;
	private JTable table_banhang;
	private JTextField txt_hoadon_banhang;
	private JTextField txt_maxe_banhang,txt_tenxe_banhang,txt_mauxe_banhang,txt_giaxe_banhang,txt_giamgia_banhang;
	private JTextField txt_tongtien_banhang;
	private JTextField txt_ngaylap_banhang;
	
	private JComboBox<Object> cb_de = new JComboBox<Object>();
	private DefaultTableModel dtm = new DefaultTableModel();
	private Vector<String> columns = new Vector<String>();
	private Vector<Vector<Object>> rows = new Vector<>();
	private Process_Car ps = new Process_Car();
	private ArrayList<Car> lst;
	private Process_Bill pss = new Process_Bill();
	private ArrayList<Bill> lstt;
	private Process_Staff psss = new Process_Staff();
	private ArrayList<Staff> lsttt;
	private Process_Customer pssss = new Process_Customer();
	private ArrayList<Customer> lstttt;
	private Process_Detail_Bill psssss = new Process_Detail_Bill();
	private ArrayList<Detail_Bill> lsttttt;
	JComboBox cbx_manv_banhang;
	JComboBox cbx_hinhthucthanhtoan_banhang;
	JComboBox cbx_makh_banhang_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Car_BanHang frame = new GUI_Car_BanHang();
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
	public GUI_Car_BanHang() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1096, 645);
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
		
		 cbx_makh_banhang_2 = new JComboBox();
		cbx_makh_banhang_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbx_makh_banhang_2.setBounds(141, 160, 151, 21);
		contentPane.add(cbx_makh_banhang_2);
		
		cbx_manv_banhang = new JComboBox();
		cbx_manv_banhang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		cbx_manv_banhang.setBounds(141, 112, 151, 21);
		contentPane.add(cbx_manv_banhang);
		btnNewButton.setBounds(987, 577, 85, 21);
		contentPane.add(btnNewButton);
		
		table_banhang = new JTable();
		table_banhang.addMouseListener(new MouseAdapter() {
		
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int selectRow=table_banhang.getSelectedRow();
				if(selectRow!=-1) {
					Vector<Object> row = rows.get(selectRow);
					txt_maxe_banhang.setText(row.get(0).toString());
					
					Double gia=Double.parseDouble(row.get(3).toString());
					Double giamgia=Double.parseDouble(row.get(4).toString());
					Double tongtien=gia-gia*giamgia;
					String tongTien=String.valueOf(tongtien);
					txt_tongtien_banhang.setText(tongTien.toString());	
					txt_tenxe_banhang.setText(row.get(2).toString());
					txt_mauxe_banhang.setText(row.get(6).toString());
					txt_giaxe_banhang.setText(row.get(3).toString());
					txt_giamgia_banhang.setText(row.get(4).toString());
					
			}
			}
		}
			
		);
		table_banhang.setBounds(370, 195, 679, 372);
		contentPane.add(table_banhang);
		
		JLabel lblNewLabel = new JLabel("Đơn hàng");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(117, 11, 94, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã hóa đơn");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(30, 220, 85, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mã xe");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(30, 260, 85, 32);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Tổng tiền");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(30, 302, 85, 32);
		contentPane.add(lblNewLabel_1_2);
JLabel lblNewLabel_1_3 = new JLabel("Hình thức Thanh toán");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(30, 344, 142, 32);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Ngày lập hóa đơn");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_4.setBounds(30, 382, 142, 32);
		contentPane.add(lblNewLabel_1_4);
		 
	
		
		txt_hoadon_banhang = new JTextField();
		txt_hoadon_banhang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_hoadon_banhang.setBounds(179, 221, 129, 19);
		contentPane.add(txt_hoadon_banhang);
		txt_hoadon_banhang.setColumns(10);
		
		txt_maxe_banhang = new JTextField();
		txt_maxe_banhang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_maxe_banhang.setColumns(10);
		txt_maxe_banhang.setBounds(179, 261, 129, 19);
		contentPane.add(txt_maxe_banhang);
		
		txt_tenxe_banhang = new JTextField();
		txt_tenxe_banhang.setColumns(10);
		contentPane.add(txt_tenxe_banhang); 
		
		txt_mauxe_banhang = new JTextField();
		txt_mauxe_banhang.setColumns(10);
		contentPane.add(txt_mauxe_banhang); 
		
		txt_giaxe_banhang = new JTextField();
		txt_giaxe_banhang.setColumns(10);
		contentPane.add(txt_giaxe_banhang); 
		
		txt_giamgia_banhang = new JTextField();
		txt_giamgia_banhang.setColumns(10);
		contentPane.add(txt_giamgia_banhang); 
		
		txt_tongtien_banhang = new JTextField();
		txt_tongtien_banhang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_tongtien_banhang.setColumns(10);
		txt_tongtien_banhang.setBounds(179, 303, 129, 19);
		contentPane.add(txt_tongtien_banhang);
		
		txt_ngaylap_banhang = new JTextField();
		txt_ngaylap_banhang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_ngaylap_banhang.setColumns(10);
		txt_ngaylap_banhang.setBounds(179, 383, 129, 19);
		contentPane.add(txt_ngaylap_banhang);
		
		 cbx_hinhthucthanhtoan_banhang = new JComboBox();
		 cbx_hinhthucthanhtoan_banhang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 cbx_hinhthucthanhtoan_banhang.setModel(new DefaultComboBoxModel(new String[] {"Hình thức thanh toán", "ATM", "Tiền mặt"}));
		cbx_hinhthucthanhtoan_banhang.setBounds(180, 344, 129, 21);
		contentPane.add(cbx_hinhthucthanhtoan_banhang);
		
		JButton btn_thanhtoan_hoadon = new JButton("Thanh toán");
		btn_thanhtoan_hoadon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertBill();
				InsertDetail_Bill();
				DeleteAll();
			}
		});
		btn_thanhtoan_hoadon.setFont(new Font("Tahoma", Font.BOLD, 17));
		btn_thanhtoan_hoadon.setBounds(30, 441, 282, 49);
		contentPane.add(btn_thanhtoan_hoadon);
		
		JButton btn_lammoi_banhang = new JButton("Làm mới");
		btn_lammoi_banhang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteAll();
			}
		});
		btn_lammoi_banhang.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_lammoi_banhang.setBounds(86, 57, 131, 45);
		contentPane.add(btn_lammoi_banhang);
		
		JLabel lblNewLabel_1_7 = new JLabel("Mã nhân viên");
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_7.setBounds(30, 112, 101, 32);
		contentPane.add(lblNewLabel_1_7);
		
		JLabel lblNewLabel_1_8 = new JLabel("Mã khách hàng");
		lblNewLabel_1_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_8.setBounds(30, 154, 110, 32);
		contentPane.add(lblNewLabel_1_8);
		
		JEditorPane editorPane_1 = new JEditorPane();
		editorPane_1.setBackground(new Color(197, 227, 228));
		editorPane_1.setBounds(0, 42, 343, 159);
		contentPane.add(editorPane_1);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBackground(new Color(217, 217, 217));
		editorPane.setBounds(0, 42, 343, 495);
		contentPane.add(editorPane);
		
		JLabel lblDanhSchSn = new JLabel("Danh sách ô tô");
		lblDanhSchSn.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDanhSchSn.setBounds(627, 57, 142, 21);
		contentPane.add(lblDanhSchSn);
		
		
		
		JComboBox cbx_hangxe_banhang = new JComboBox();
		cbx_hangxe_banhang.setModel(new DefaultComboBoxModel(new String[] {"--Hãng xe--", "BMW", "BMW1", "Honda", "Lexus", "Mercedes", "Vinfast"}));
		cbx_hangxe_banhang.setBounds(599, 102, 215, 32);
		contentPane.add(cbx_hangxe_banhang);
		
		JButton btn_timkiem_banhang = new JButton("Tìm kiếm ");
		btn_timkiem_banhang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getCarbyHANG_XE((String) cbx_hangxe_banhang.getSelectedItem());
				
			}
		});
		btn_timkiem_banhang.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_timkiem_banhang.setBounds(834, 99, 115, 32);
		contentPane.add(btn_timkiem_banhang);
		JLabel lblNewLabel_1_9 = new JLabel("Hãng xe");
		lblNewLabel_1_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_9.setBounds(525, 100, 85, 32);
		contentPane.add(lblNewLabel_1_9);
		
		JEditorPane editorPane_2 = new JEditorPane();
		editorPane_2.setBackground(new Color(210, 210, 210));
		editorPane_2.setBounds(370, 40, 679, 497);
		contentPane.add(editorPane_2);
		
		JTree tree = new JTree();
		tree.setBounds(423, 403, 70, 64);
		contentPane.add(tree);
		
		JComboBox cbx_manv_banhang_1 = new JComboBox();
		cbx_manv_banhang_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbx_manv_banhang_1.setBounds(141, 161, 151, 21);
		contentPane.add(cbx_manv_banhang_1);
		columns.add("Mã xe");
		columns.add("Hãng xe");
		columns.add("Tên xe");
		columns.add("Giá xe");
		columns.add("Giảm giá");
		columns.add("Phân loại xe");
		columns.add("Màu xe");
		columns.add("Số lượng");
		getAllCar();
		Select_Cbx_Manv();
		Select_Cbx_Makh();
	}
	
	private void getAllCar() {
		dtm.setNumRows(0);
		
		lst = ps.getListCar();
		for(int i = 0; i < lst.size(); i++) {
			Car t = (Car)lst.get(i);
			Vector<Object> tbRow = new Vector<>();
			tbRow.add(t.getMA_XE());
			tbRow.add(t.getHANG_XE());
			tbRow.add(t.getTEN_XE());
			tbRow.add(t.getGIA_XE());
			tbRow.add(t.getGIAM_GIA());
			tbRow.add(t.getLOAI_XE());
			tbRow.add(t.getMAU());
			tbRow.add(t.getSO_LUONG());
			rows.add(tbRow);
		}
		dtm.setDataVector(rows, columns);
		dtm.insertRow(0, columns);
		table_banhang.setModel(dtm);
	}
	private void getCarbyHANG_XE(String HANG_XE) {
		dtm.setNumRows(0);
		lst = ps.getListCarbyHANG_XE(HANG_XE);
		for(int i = 0; i < lst.size(); i++) {
			Car t = (Car)lst.get(i);
			Vector<Object> tbRow = new Vector<>();
			tbRow.add(t.getMA_XE());
			tbRow.add(t.getHANG_XE());
			tbRow.add(t.getTEN_XE());
			tbRow.add(t.getGIA_XE());
			tbRow.add(t.getGIAM_GIA());
			tbRow.add(t.getLOAI_XE());
			tbRow.add(t.getMAU());
			tbRow.add(t.getSO_LUONG());
			rows.add(tbRow);
		}
		
		dtm.setDataVector(rows, columns);
		dtm.insertRow(0, columns);
		table_banhang.setModel(dtm);
		if(HANG_XE=="--Hãng xe--") getAllCar();	
	
	}
	private void InsertBill() {
		String MaHD = txt_hoadon_banhang.getText();
		String MaNV = cbx_manv_banhang.getSelectedItem() + "";
		String MaKH = cbx_makh_banhang_2.getSelectedItem() + "";
		String MaXE = txt_maxe_banhang.getText();
		String TongTien = txt_tongtien_banhang.getText();
		String HTTT = cbx_hinhthucthanhtoan_banhang.getSelectedItem() + "";
		String NgayLap = txt_ngaylap_banhang.getText();
		
		pss.Insert_getlistBill(MaHD, MaNV,MaKH, MaXE, TongTien,HTTT,NgayLap);
	}
	private void InsertDetail_Bill() {
		String MaHD = txt_hoadon_banhang.getText();
		String MAXE = txt_maxe_banhang.getText();
		String TENXE = txt_tenxe_banhang.getText();
		String MAUXE = txt_mauxe_banhang.getText();
		String GIAXE = txt_giaxe_banhang.getText();
		String GIAMGIA = txt_giamgia_banhang.getText();	
		psssss.Insert_getlistDetail_Bill(MaHD, MAXE,TENXE, MAUXE, GIAXE,GIAMGIA);	
	}
	Vector<String> data = new Vector<String>();
	private void Select_Cbx_Manv() {
		lsttt = psss. getShowMaNV();
		data.addElement("Mã nhân viên");
		for(int i = 0; i < lsttt.size(); i++) {
			Staff t = (Staff)lsttt.get(i);
			data.addElement(t.getID());
			cbx_manv_banhang.setModel(new DefaultComboBoxModel(data));
		}	
	}
	Vector<String> data1 = new Vector<String>();
	private void Select_Cbx_Makh() {
		lstttt = pssss. getShowMaKH();
		data1.addElement("Mã khách hàng");
		for(int i = 0; i < lsttt.size(); i++) {
			Customer t = (Customer)lstttt.get(i);
			data1.addElement(t.getID());
			cbx_makh_banhang_2.setModel(new DefaultComboBoxModel(data1));
		}	
	}
private void DeleteAll() {
		cbx_manv_banhang.setSelectedIndex(0);
		cbx_makh_banhang_2.setSelectedIndex(0);
		txt_hoadon_banhang.setText("");
		txt_maxe_banhang.setText("");
		cbx_hinhthucthanhtoan_banhang.setSelectedIndex(0);
		txt_tongtien_banhang.setText("");
		txt_ngaylap_banhang.setText("");
		
	}
}