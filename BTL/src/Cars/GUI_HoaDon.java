package Cars;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUI_HoaDon extends JFrame {

	private JPanel contentPane;
	private JTextField txtMHan;
	private JTextField txtMNhnVin;
	private JTextField txtMKhchHng;
	private JTable table_HD_hoadon;
	private JTable table_chitietHD__hoadon;
	private JTextField txt_mahd;
	
	private DefaultTableModel dtm = new DefaultTableModel();
	private DefaultTableModel dtm1 = new DefaultTableModel();
	private Vector<String> columns = new Vector<String>();
	private Vector<String> columns1 = new Vector<String>();
	private Vector<Vector<Object>> rows = new Vector<>();
	private Vector<Vector<Object>> rows1 = new Vector<>();
	private Process_Bill ps = new Process_Bill();
	private ArrayList<Bill> lst;
	private JTextField txtMXe;
	private JTextField txtHtThanhTon;
	private JTextField txtNgyLpH;
	private JTextField txtTmKimHa;
	private JComboBox cbx_MaHD_hoadon,cbx_MaKH_hoadon,cbx_MaNV_hoadon,cbx_MaXe_hoadon,cbx_HTTT_hoadon,cbx_NgayLapHD_hoadon;
	private Process_Detail_Bill pss = new Process_Detail_Bill();
	private ArrayList<Detail_Bill> lstt;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_HoaDon frame = new GUI_HoaDon();
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
	public GUI_HoaDon() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1125, 654);
		contentPane = new JPanel();
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cbx_MaHD_hoadon.setSelectedIndex(0);
				cbx_MaNV_hoadon.setSelectedIndex(0);
		 		cbx_MaKH_hoadon.setSelectedIndex(0);
		 		cbx_MaXe_hoadon.setSelectedIndex(0);
		 		cbx_HTTT_hoadon.setSelectedIndex(0);
		 		cbx_NgayLapHD_hoadon.setSelectedIndex(0);
			}
		});
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 cbx_NgayLapHD_hoadon = new JComboBox();
		 cbx_NgayLapHD_hoadon.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		cbx_MaNV_hoadon.setSelectedIndex(0);
		 		cbx_MaKH_hoadon.setSelectedIndex(0);
		 		cbx_MaXe_hoadon.setSelectedIndex(0);
		 		cbx_HTTT_hoadon.setSelectedIndex(0);
		 		cbx_MaKH_hoadon.setSelectedIndex(0);
		 	}
		 });
		cbx_NgayLapHD_hoadon.setBounds(770, 90, 98, 21);
		contentPane.add(cbx_NgayLapHD_hoadon);
		
		txtNgyLpH = new JTextField();
		txtNgyLpH.setText("Ngày lập HĐ");
		txtNgyLpH.setColumns(10);
		txtNgyLpH.setBounds(770, 60, 96, 19);
		contentPane.add(txtNgyLpH);
		
		txtHtThanhTon = new JTextField();
		txtHtThanhTon.setText("HT Thanh toán");
		txtHtThanhTon.setColumns(10);
		txtHtThanhTon.setBounds(628, 60, 96, 19);
		contentPane.add(txtHtThanhTon);
		
		 cbx_HTTT_hoadon = new JComboBox();
		 cbx_HTTT_hoadon.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		cbx_MaNV_hoadon.setSelectedIndex(0);
		 		cbx_MaKH_hoadon.setSelectedIndex(0);
		 		cbx_MaXe_hoadon.setSelectedIndex(0);
		 		cbx_MaKH_hoadon.setSelectedIndex(0);
		 		cbx_NgayLapHD_hoadon.setSelectedIndex(0);
		 	}
		 });
		cbx_HTTT_hoadon.setBounds(628, 90, 98, 21);
		contentPane.add(cbx_HTTT_hoadon);
		
		 cbx_MaXe_hoadon = new JComboBox();
		 cbx_MaXe_hoadon.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		cbx_MaNV_hoadon.setSelectedIndex(0);
		 		cbx_MaKH_hoadon.setSelectedIndex(0);
		 		cbx_MaKH_hoadon.setSelectedIndex(0);
		 		cbx_HTTT_hoadon.setSelectedIndex(0);
		 		cbx_NgayLapHD_hoadon.setSelectedIndex(0);
		 	}
		 });
		cbx_MaXe_hoadon.setBounds(484, 90, 98, 21);
		contentPane.add(cbx_MaXe_hoadon);
		
		txtMXe = new JTextField();
		txtMXe.setText("Mã xe");
		txtMXe.setColumns(10);
		txtMXe.setBounds(484, 60, 98, 19);
		contentPane.add(txtMXe);
		
		txtMKhchHng = new JTextField();
		txtMKhchHng.setText("Mã khách hàng");
		txtMKhchHng.setColumns(10);
		txtMKhchHng.setBounds(343, 60, 96, 19);
		contentPane.add(txtMKhchHng);
		
		txtMNhnVin = new JTextField();
		txtMNhnVin.setText("Mã nhân viên");
		txtMNhnVin.setColumns(10);
		txtMNhnVin.setBounds(198, 60, 110, 19);
		contentPane.add(txtMNhnVin);
		
		txtMHan = new JTextField();
		txtMHan.setText("Mã hóa đơn");
		txtMHan.setBounds(56, 60, 110, 19);
		contentPane.add(txtMHan);
		txtMHan.setColumns(10);
		
		 cbx_MaHD_hoadon = new JComboBox();
		 cbx_MaHD_hoadon.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		cbx_MaNV_hoadon.setSelectedIndex(0);
		 		cbx_MaKH_hoadon.setSelectedIndex(0);
		 		cbx_MaXe_hoadon.setSelectedIndex(0);
		 		cbx_HTTT_hoadon.setSelectedIndex(0);
		 		cbx_NgayLapHD_hoadon.setSelectedIndex(0);

		 	}
		 });
		cbx_MaHD_hoadon.setBounds(56, 90, 110, 21);
		contentPane.add(cbx_MaHD_hoadon);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBackground(new Color(128, 188, 255));
		editorPane.setBounds(46, 50, 132, 76);
		contentPane.add(editorPane);
		
		 cbx_MaNV_hoadon = new JComboBox();
		 cbx_MaNV_hoadon.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		cbx_MaHD_hoadon.setSelectedIndex(0);
		 		cbx_MaKH_hoadon.setSelectedIndex(0);
		 		cbx_MaXe_hoadon.setSelectedIndex(0);
		 		cbx_HTTT_hoadon.setSelectedIndex(0);
		 		cbx_NgayLapHD_hoadon.setSelectedIndex(0);
		 	}
		 });
		cbx_MaNV_hoadon.setBounds(198, 90, 110, 21);
		contentPane.add(cbx_MaNV_hoadon);
		
		 cbx_MaKH_hoadon = new JComboBox();
		 cbx_MaKH_hoadon.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		cbx_MaNV_hoadon.setSelectedIndex(0);
		 		cbx_MaHD_hoadon.setSelectedIndex(0);
		 		cbx_MaXe_hoadon.setSelectedIndex(0);
		 		cbx_HTTT_hoadon.setSelectedIndex(0);
		 		cbx_NgayLapHD_hoadon.setSelectedIndex(0);
		 	}
		 });
		cbx_MaKH_hoadon.setBounds(341, 90, 98, 21);
		contentPane.add(cbx_MaKH_hoadon);
		
		JEditorPane editorPane_2 = new JEditorPane();
		editorPane_2.setBackground(new Color(128, 188, 255));
		editorPane_2.setBounds(330, 50, 132, 76);
		contentPane.add(editorPane_2);
		
		JEditorPane editorPane_1 = new JEditorPane();
		editorPane_1.setBackground(new Color(128, 188, 255));
		editorPane_1.setBounds(188, 50, 132, 76);
		contentPane.add(editorPane_1);
		txt_mahd = new JTextField();
		contentPane.add(txt_mahd);
		txt_mahd.setColumns(10);
		
		table_HD_hoadon = new JTable();
		table_HD_hoadon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectRow=table_HD_hoadon.getSelectedRow();
				if(selectRow!=-1) {
					Vector<Object> row = rows.get(selectRow);
					txt_mahd.setText(row.get(0).toString());					
			}
				getAllDetailBill(txt_mahd.getText());				
			}			
		}	
		);
		
		table_HD_hoadon.setBackground(new Color(191, 222, 255));
		table_HD_hoadon.setBounds(46, 137, 1033, 216);
		contentPane.add(table_HD_hoadon);
		
		txt_mahd = new JTextField();
		contentPane.add(txt_mahd);
		txt_mahd.setColumns(10);
		
		table_chitietHD__hoadon =new JTable();
		table_chitietHD__hoadon.setBackground(new Color(191, 222, 255));
		table_chitietHD__hoadon.setBounds(46, 364, 1033, 217);
		contentPane.add(table_chitietHD__hoadon);
		
		JEditorPane editorPane_2_1 = new JEditorPane();
		editorPane_2_1.setBackground(new Color(128, 188, 255));
		editorPane_2_1.setBounds(472, 50, 132, 76);
		contentPane.add(editorPane_2_1);
		
		JEditorPane editorPane_2_2 = new JEditorPane();
		editorPane_2_2.setBackground(new Color(128, 188, 255));
		editorPane_2_2.setBounds(614, 50, 132, 76);
		contentPane.add(editorPane_2_2);
		
		JEditorPane editorPane_2_2_1 = new JEditorPane();
		editorPane_2_2_1.setBackground(new Color(128, 188, 255));
		editorPane_2_2_1.setBounds(756, 50, 132, 76);
		contentPane.add(editorPane_2_2_1);
		
		JButton btnNewButton = new JButton("Tìm kiếm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cbx_MaHD_hoadon.getSelectedIndex()!=0)
					getBill_MaHD((String) cbx_MaHD_hoadon.getSelectedItem());
				else if(cbx_MaNV_hoadon.getSelectedIndex()!=0)
					getBill_MaNV((String) cbx_MaNV_hoadon.getSelectedItem());
				else if(cbx_MaKH_hoadon.getSelectedIndex()!=0)
					getBill_MaKH((String) cbx_MaKH_hoadon.getSelectedItem());
				else if(cbx_MaXe_hoadon.getSelectedIndex()!=0)
					getBill_MaXE((String) cbx_MaXe_hoadon.getSelectedItem());
				else if(cbx_HTTT_hoadon.getSelectedIndex()!=0)
						getBill_HTTT((String) cbx_HTTT_hoadon.getSelectedItem());
				else if(cbx_NgayLapHD_hoadon.getSelectedIndex()!=0)
				getBill_NgayLapHD((String) cbx_NgayLapHD_hoadon.getSelectedItem());
				
			}
		});
		btnNewButton.setBounds(898, 52, 103, 28);
		contentPane.add(btnNewButton);
		
		JButton btnXa = new JButton("Xóa");
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteBill();
			}
		});
		btnXa.setBounds(898, 98, 103, 28);
		contentPane.add(btnXa);
		
		txtTmKimHa = new JTextField();
		txtTmKimHa.setText("Tìm kiếm hóa đơn");
		txtTmKimHa.setBounds(45, 11, 121, 28);
		contentPane.add(txtTmKimHa);
		txtTmKimHa.setColumns(10);
		
		
		
		
		columns.add("Mã hóa đơn	");
		columns.add("Mã nhân viên");
		columns.add("Mã khách hàng");
		columns.add("Mã xe");
		columns.add("Tổng tiền");
		columns.add("HT Thanh toán");
		columns.add("Ngày lập hóa đơn");
		
		
		getAllBill();
		Select_Cbx_MaHD();
		Select_Cbx_MaNV();
		Select_Cbx_MaKH();
		Select_Cbx_MaXE();
		Select_Cbx_HTTT();
		Select_Cbx_NgayLapHD();
		columns1.add("Mã hóa đơn	");
		columns1.add("Mã xe");
		columns1.add("Tên xe");
		columns1.add("Màu xe");
		columns1.add("Giá xe");
		columns1.add("Giảm giá");
	
		
		
	}
	private void getAllBill() {
		dtm.setNumRows(0);
		
		lst = ps.getListBill();
		for(int i = 0; i < lst.size(); i++) {
			Bill t = (Bill)lst.get(i);
			Vector<Object> tbRow = new Vector<>();
			tbRow.add(t.getMaHD());
			tbRow.add(t.getMa_nv_Bill());
			tbRow.add(t.getMa_kh_Bill());
			tbRow.add(t.getMa_xe_Bill());
			tbRow.add(t.getTongTien());
			tbRow.add(t.getHTThanhToan());
			tbRow.add(t.getNgayLapHD());
			
			
			rows.add(tbRow);
		} 
		dtm.setDataVector(rows, columns);
		dtm.insertRow(0, columns);
		table_HD_hoadon.setModel(dtm);
	}
	///////////

		
		
	
	private void getAllDetailBill(String mahd) {
		dtm1.setNumRows(0);
		
		lstt = pss.getListBill_ChiTietHD(mahd);
		
			Detail_Bill t = (Detail_Bill)lstt.get(0);
			Vector<Object> tbRow = new Vector<>();
			tbRow.add(t.getMa_hd());
			tbRow.add(t.getMa_xe());
			tbRow.add(t.getTen_xe());
			tbRow.add(t.getMau_xe());
			tbRow.add(t.getGia_xe());
			tbRow.add(t.getGiam_gia());			
			rows1.add(tbRow);
		
		dtm1.setDataVector(rows1, columns1);
		dtm1.insertRow(0, columns1);
		table_chitietHD__hoadon.setModel(dtm1);
	}
	///////////
	private void getBill_MaHD(String hoadon) {
		dtm.setNumRows(0);
		
		lst = ps.getListBill_MaHD(hoadon);
		for(int i = 0; i < lst.size(); i++) {
			Bill t = (Bill)lst.get(i);
			Vector<Object> tbRow1 = new Vector<>();
			tbRow1.add(t.getMaHD());
			tbRow1.add(t.getMa_nv_Bill());
			tbRow1.add(t.getMa_kh_Bill());
			tbRow1.add(t.getMa_xe_Bill());
			tbRow1.add(t.getTongTien());
			tbRow1.add(t.getHTThanhToan());
			tbRow1.add(t.getNgayLapHD());
			rows.add(tbRow1);
		} 
		dtm.setDataVector(rows, columns);
		dtm.insertRow(0, columns);
		table_HD_hoadon.setModel(dtm);
	}
	private void getBill_MaNV(String nhanvien) {
		dtm.setNumRows(0);
		
		lst = ps.getListBill_MaNV(nhanvien);
		for(int i = 0; i < lst.size(); i++) {
			Bill t = (Bill)lst.get(i);
			Vector<Object> tbRow = new Vector<>();
			tbRow.add(t.getMaHD());
			tbRow.add(t.getMa_nv_Bill());
			tbRow.add(t.getMa_kh_Bill());
			tbRow.add(t.getMa_xe_Bill());
			tbRow.add(t.getTongTien());
			tbRow.add(t.getHTThanhToan());
			tbRow.add(t.getNgayLapHD());
			rows.add(tbRow);
		} 
		dtm.setDataVector(rows, columns);
		dtm.insertRow(0, columns);
		table_HD_hoadon.setModel(dtm);
	}
	private void getBill_MaKH(String khachhang) {
		dtm.setNumRows(0);
		
		lst = ps.getListBill_MaKH(khachhang);
		for(int i = 0; i < lst.size(); i++) {
			Bill t = (Bill)lst.get(i);
			Vector<Object> tbRow = new Vector<>();
			tbRow.add(t.getMaHD());
			tbRow.add(t.getMa_nv_Bill());
			tbRow.add(t.getMa_kh_Bill());
			tbRow.add(t.getMa_xe_Bill());
			tbRow.add(t.getTongTien());
			tbRow.add(t.getHTThanhToan());
			tbRow.add(t.getNgayLapHD());
			rows.add(tbRow);
		} 
		dtm.setDataVector(rows, columns);
		dtm.insertRow(0, columns);
		table_HD_hoadon.setModel(dtm);
	}
	private void getBill_MaXE(String maxe) {
		dtm.setNumRows(0);
		
		lst = ps.getListBill_MaXE(maxe);
		for(int i = 0; i < lst.size(); i++) {
			Bill t = (Bill)lst.get(i);
			Vector<Object> tbRow = new Vector<>();
			tbRow.add(t.getMaHD());
			tbRow.add(t.getMa_nv_Bill());
			tbRow.add(t.getMa_kh_Bill());
			tbRow.add(t.getMa_xe_Bill());
			tbRow.add(t.getTongTien());
			tbRow.add(t.getHTThanhToan());
			tbRow.add(t.getNgayLapHD());
			rows.add(tbRow);
		} 
		dtm.setDataVector(rows, columns);
		dtm.insertRow(0, columns);
		table_HD_hoadon.setModel(dtm);
	}
	private void getBill_HTTT(String httt) {
		dtm.setNumRows(0);
		
		lst = ps.getListBill_HTTT(httt);
		for(int i = 0; i < lst.size(); i++) {
			Bill t = (Bill)lst.get(i);
			Vector<Object> tbRow = new Vector<>();
			tbRow.add(t.getMaHD());
			tbRow.add(t.getMa_nv_Bill());
			tbRow.add(t.getMa_kh_Bill());
			tbRow.add(t.getMa_xe_Bill());
			tbRow.add(t.getTongTien());
			tbRow.add(t.getHTThanhToan());
			tbRow.add(t.getNgayLapHD());
			rows.add(tbRow);
		} 
		dtm.setDataVector(rows, columns);
		dtm.insertRow(0, columns);
		table_HD_hoadon.setModel(dtm);
	}
	private void getBill_NgayLapHD(String ngaylaphd) {
		dtm.setNumRows(0);
		
		lst = ps.getListBill_NgayLapHD(ngaylaphd);
		for(int i = 0; i < lst.size(); i++) {
			Bill t = (Bill)lst.get(i);
			Vector<Object> tbRow = new Vector<>();
			tbRow.add(t.getMaHD());
			tbRow.add(t.getMa_nv_Bill());
			tbRow.add(t.getMa_kh_Bill());
			tbRow.add(t.getMa_xe_Bill());
			tbRow.add(t.getTongTien());
			tbRow.add(t.getHTThanhToan());
			tbRow.add(t.getNgayLapHD());
			rows.add(tbRow);
		} 
		dtm.setDataVector(rows, columns);
		dtm.insertRow(0, columns);
		table_HD_hoadon.setModel(dtm);
	}
	Vector<String> data = new Vector<String>();
	private void Select_Cbx_MaHD() {
		lst = ps. getShowMaHD();
		data.addElement("Mã hóa đơn");
		for(int i = 0; i < lst.size(); i++) {
			Bill t = (Bill)lst.get(i);
			data.addElement(t.getMaHD());
			cbx_MaHD_hoadon.setModel(new DefaultComboBoxModel(data));
		}	
	}
	Vector<String> data1 = new Vector<String>();
	private void Select_Cbx_MaNV() {
		lst = ps. getShowMaNV();
		data1.addElement("Mã nhân viên");
		for(int i = 0; i < lst.size(); i++) {
			Bill t = (Bill)lst.get(i);
			data1.addElement(t.getMaHD());
			cbx_MaNV_hoadon.setModel(new DefaultComboBoxModel(data1));
		}	
	}
	Vector<String> data2 = new Vector<String>();
	private void Select_Cbx_MaKH() {
		lst = ps. getShowMaKH();
		data2.addElement("Mã khách hàng");
		for(int i = 0; i < lst.size(); i++) {
			Bill t = (Bill)lst.get(i);
			data2.addElement(t.getMaHD());
			cbx_MaKH_hoadon.setModel(new DefaultComboBoxModel(data2));
		}	
	}
	Vector<String> data3 = new Vector<String>();
	private void Select_Cbx_MaXE() {
		lst = ps. getShowMaXE();
		data3.addElement("Mã xe");
		for(int i = 0; i < lst.size(); i++) {
			Bill t = (Bill)lst.get(i);
			data3.addElement(t.getMaHD());
			cbx_MaXe_hoadon.setModel(new DefaultComboBoxModel(data3));
		}	
	}
	Vector<String> data4 = new Vector<String>();
	private void Select_Cbx_HTTT() {
		lst = ps. getShowHTTT();
		data4.addElement("Hình thức thanh toán");
		for(int i = 0; i < lst.size(); i++) {
			Bill t = (Bill)lst.get(i);
			data4.addElement(t.getMaHD());
			cbx_HTTT_hoadon.setModel(new DefaultComboBoxModel(data4));
		}	
	}
	Vector<String> data5 = new Vector<String>();
	private JButton btnNewButton_1;
	private void Select_Cbx_NgayLapHD() {
		lst = ps. getShowNgayLapHD();
		data5.addElement("Ngày lập hóa đơn");
		for(int i = 0; i < lst.size(); i++) {
			Bill t = (Bill)lst.get(i);
			data5.addElement(t.getMaHD());
			cbx_NgayLapHD_hoadon.setModel(new DefaultComboBoxModel(data5));
		}	
	}
	private void DeleteBill() {
		
		String MaHd = txt_mahd.getText();
		ps.Del_getlistBill(MaHd);
		getAllBill();
		
	
	}
}
