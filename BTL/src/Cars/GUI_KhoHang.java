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
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUI_KhoHang extends JFrame {

	private JPanel contentPane;
	private JTextField txt_maxe_khohang;
	private JTextField txt_tenxe_khohang;
	private JTextField txt_giaxe_khohang;
	private JTextField txt_soluong_khohang;
	private JTable table_khohang;
	private JComboBox cbx_hangxe_khohang,cbx_giamgia_khohang,cbx_mau_khohang,cbx_phanloai_khohang,hangxe_hoadon1,cbx_phanloai_khohang_1 ;
	
	private DefaultTableModel dtm = new DefaultTableModel();
	private Vector<String> columns = new Vector<String>();
	private Vector<Vector<Object>> rows = new Vector<>();
	private Process_Car ps = new Process_Car();
	private ArrayList<Car> lst;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_KhoHang frame = new GUI_KhoHang();
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
	public GUI_KhoHang() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1091, 676);
		contentPane = new JPanel();
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				////////////
				hangxe_hoadon1.setSelectedIndex(0);
				cbx_phanloai_khohang_1.setSelectedIndex(0);
				getAllCar();
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Thoát");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(936, 583, 117, 46);
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
		
		JButton btnNewButton_1_2_1 = new JButton("Nhập lại");
		btnNewButton_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteAll() ;
			}
		});
		btnNewButton_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1_2_1.setBounds(636, 282, 108, 36);
		contentPane.add(btnNewButton_1_2_1);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Mã xe");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(66, 58, 59, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblHngXe = new JLabel("Hãng xe");
		lblHngXe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHngXe.setBounds(66, 104, 59, 36);
		contentPane.add(lblHngXe);
		
		JLabel lblTnXe = new JLabel("Tên xe");
		lblTnXe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTnXe.setBounds(66, 150, 59, 36);
		contentPane.add(lblTnXe);
		
		JLabel lblGi = new JLabel("Giá");
		lblGi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGi.setBounds(66, 196, 59, 36);
		contentPane.add(lblGi);
		
		JLabel lblGimGi = new JLabel("Giảm giá");
		lblGimGi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGimGi.setBounds(429, 58, 69, 36);
		contentPane.add(lblGimGi);
		
		JLabel lblMu = new JLabel("Màu");
		lblMu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMu.setBounds(429, 104, 69, 36);
		contentPane.add(lblMu);
		
		JLabel lblLoiXe = new JLabel("Loại xe");
lblLoiXe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLoiXe.setBounds(429, 150, 69, 36);
		contentPane.add(lblLoiXe);
		
		JLabel lblSLung = new JLabel("Số lượng");
		lblSLung.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSLung.setBounds(429, 196, 69, 36);
		contentPane.add(lblSLung);
		
		txt_maxe_khohang = new JTextField();
		txt_maxe_khohang.setBounds(133, 69, 125, 19);
		contentPane.add(txt_maxe_khohang);
		txt_maxe_khohang.setColumns(10);
		
		cbx_hangxe_khohang = new JComboBox();
		cbx_hangxe_khohang.setModel(new DefaultComboBoxModel(new String[] {"Hãng xe", "BMW", "BMW1", "Honda", "Lexus", "Mercedes", "Vinfast"}));
		cbx_hangxe_khohang.setBounds(133, 114, 125, 21);
		contentPane.add(cbx_hangxe_khohang);
		
		txt_tenxe_khohang = new JTextField();
		txt_tenxe_khohang.setColumns(10);
		txt_tenxe_khohang.setBounds(133, 161, 125, 19);
		contentPane.add(txt_tenxe_khohang);
		
		txt_giaxe_khohang = new JTextField();
		txt_giaxe_khohang.setColumns(10);
		txt_giaxe_khohang.setBounds(133, 207, 125, 19);
		contentPane.add(txt_giaxe_khohang);
		
		 cbx_giamgia_khohang = new JComboBox();
		 cbx_giamgia_khohang.setModel(new DefaultComboBoxModel(new String[] {"Giảm giá", "0", "0.01", "0.02", "0.03", "0.04", "0.05", "0.06", "0.07", "0.08", "0.09", "0.1", "0.11", "0.12", "0.13", "0.14", "0.15"}));
		cbx_giamgia_khohang.setBounds(519, 68, 125, 21);
		contentPane.add(cbx_giamgia_khohang);
		
		 cbx_mau_khohang = new JComboBox();
		 cbx_mau_khohang.setModel(new DefaultComboBoxModel(new String[] {"Màu xe", "Đỏ", "Đen", "Trắng"}));
		cbx_mau_khohang.setBounds(519, 114, 125, 21);
		contentPane.add(cbx_mau_khohang);
		
		 cbx_phanloai_khohang = new JComboBox();
		 cbx_phanloai_khohang.setModel(new DefaultComboBoxModel(new String[] {"Phân loại xe", "Xe coupe thể thao", "Xe hạng sang"}));
		cbx_phanloai_khohang.setBounds(519, 160, 125, 21);
		contentPane.add(cbx_phanloai_khohang);
		
		txt_soluong_khohang = new JTextField();
		txt_soluong_khohang.setColumns(10);
		txt_soluong_khohang.setBounds(519, 207, 125, 19);
		contentPane.add(txt_soluong_khohang);
		
		JButton btnNewButton_1 = new JButton("Thêm");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Insert_KhoHang() ;
				DeleteAll() ;
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(133, 282, 108, 36);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Sửa");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Update_KhoHang();
				DeleteAll() ;
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1_1.setBounds(304, 282, 108, 36);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Xóa");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delete_KhoHang();
				DeleteAll() ;
			}
		});
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1_2.setBounds(479, 282, 108, 36);
		contentPane.add(btnNewButton_1_2);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBackground(new Color(215, 215, 215));
		editorPane.setBounds(10, 10, 1043, 308);
		contentPane.add(editorPane);
		
		JLabel label = new JLabel("New label");
		label.setBounds(78, 72, 45, 13);
		contentPane.add(label);
		
		JButton btnNewButton_1_3 = new JButton("Tìm kiếm");
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(hangxe_hoadon1.getSelectedItem().toString()!="Hãng xe")
				getAllCar_HangXe((String) hangxe_hoadon1.getSelectedItem());
				else if(cbx_phanloai_khohang_1.getSelectedItem().toString()!="Phân loại")
				getAllCar_PhanLoai((String) cbx_phanloai_khohang_1.getSelectedItem());
			}
		});
		btnNewButton_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1_3.setBounds(744, 344, 128, 36);
		contentPane.add(btnNewButton_1_3);
		
		JLabel lblHngXe_1 = new JLabel("Hãng xe");
		lblHngXe_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHngXe_1.setBounds(240, 344, 69, 36);
		contentPane.add(lblHngXe_1);
		
		 hangxe_hoadon1 = new JComboBox();
		 hangxe_hoadon1.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		cbx_phanloai_khohang_1.setSelectedIndex(0);
		 	}
		 });
		hangxe_hoadon1.setBounds(313, 354, 125, 21);
contentPane.add(hangxe_hoadon1);
		
		table_khohang = new JTable();
		table_khohang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int selectRow=table_khohang.getSelectedRow();
				if(selectRow!=-1) {
					Vector<Object> row = rows.get(selectRow);
					txt_maxe_khohang.setText(row.get(0).toString());
					int hangxe = 0;
					if(row.get(1).toString().equals("BMW")) hangxe=1;
					else if(row.get(1).toString().equals("BMW1")) hangxe=2;
					else if(row.get(1).toString().equals("Honda")) hangxe=3;
					else if(row.get(1).toString().equals("Lexus")) hangxe=4;
					else if(row.get(1).toString().equals("Mercedes")) hangxe=5;
					cbx_hangxe_khohang.setSelectedIndex(hangxe);
					txt_tenxe_khohang.setText(row.get(2).toString());
					txt_giaxe_khohang.setText(row.get(3).toString());
					
					int giamgia = 0;
					if(row.get(4).toString().equals("0")) giamgia=1;
					else if(row.get(4).toString().equals("0.01")) giamgia=2;
					else if(row.get(4).toString().equals("0.02")) giamgia=3;
					else if(row.get(4).toString().equals("0.03")) giamgia=4;
					else if(row.get(4).toString().equals("0.04")) giamgia=5;
					else if(row.get(4).toString().equals("0.05")) giamgia=6;
					else if(row.get(4).toString().equals("0.06")) giamgia=7;
					else if(row.get(4).toString().equals("0.07")) giamgia=8;
					else if(row.get(4).toString().equals("0.08")) giamgia=9;
					else if(row.get(4).toString().equals("0.09")) giamgia=10;
					else if(row.get(4).toString().equals("0.1")) giamgia=11;
					else if(row.get(4).toString().equals("0.11")) giamgia=12;
					else if(row.get(4).toString().equals("0.12")) giamgia=13;
					else if(row.get(4).toString().equals("0.13")) giamgia=14;
					else if(row.get(4).toString().equals("0.14")) giamgia=15;
					else if(row.get(4).toString().equals("0.15")) giamgia=16;
					
					cbx_giamgia_khohang.setSelectedIndex(giamgia);
					
					int phanloai = 0;
				
					if(row.get(5).toString().equals("Xe coupe thể thao")) phanloai=1;
					else if(row.get(5).toString().equals("Xe hạng sang")) phanloai=2;
					cbx_phanloai_khohang.setSelectedIndex(phanloai);
					
					int mauxe = 0;
					if(row.get(6).toString().equals("Đỏ")) mauxe=1;
					else if(row.get(6).toString().equals("Đen")) mauxe=2;
					else if(row.get(6).toString().equals("Trắng")) mauxe=3;
					
					cbx_mau_khohang.setSelectedIndex(mauxe);
					
					
					
					
					txt_soluong_khohang.setText(row.get(7).toString());

			}
			}
		});
		table_khohang.setBounds(133, 390, 787, 180);
		contentPane.add(table_khohang);
		
		 cbx_phanloai_khohang_1 = new JComboBox();
		 cbx_phanloai_khohang_1.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		hangxe_hoadon1.setSelectedIndex(0);
		 	}
		 });
		cbx_phanloai_khohang_1.setBounds(539, 354, 125, 21);
		contentPane.add(cbx_phanloai_khohang_1);
		
		JLabel lblLoiXe_1 = new JLabel("Loại xe");
		lblLoiXe_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLoiXe_1.setBounds(460, 344, 69, 36);
		contentPane.add(lblLoiXe_1);
		columns.add("Mã xe");
		columns.add("Hãng xe");
		columns.add("Tên xe");
		columns.add("Giá xe");
		columns.add("Giảm giá");
		columns.add("Phân loại xe");
		columns.add("Màu xe");
		columns.add("Số lượng");
		getAllCar();
		Select_Cbx_HANGXE();
		Select_Cbx_PHANLOAI();
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
		table_khohang.setModel(dtm);
	}
	private void getAllCar_HangXe(String hangxe) {
		dtm.setNumRows(0);
		
		lst = ps.getListCarbyHANG_XE(hangxe);
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
		table_khohang.setModel(dtm);
	
	}
	private void getAllCar_PhanLoai(String phanloai) {
		dtm.setNumRows(0);
		
		lst = ps.getListCarbyPhanLoai(phanloai);
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
		table_khohang.setModel(dtm);
	
	}
	private void Insert_KhoHang() {
		String MAXE = txt_maxe_khohang.getText();
		String HANGXE = cbx_hangxe_khohang.getSelectedItem() + "";
		String TENXE = txt_tenxe_khohang.getText();
		String GIAXE = txt_giaxe_khohang.getText();
		String GIAMGIA = cbx_giamgia_khohang.getSelectedItem() + "";
		String PHANLOAI = cbx_phanloai_khohang.getSelectedItem() + "";
		String MAUXE = cbx_mau_khohang.getSelectedItem() + "";
		String SOLUONG=txt_soluong_khohang.getText();
		ps.Insert_getlistKhoHang(MAXE, HANGXE,TENXE, GIAXE, GIAMGIA,PHANLOAI,MAUXE,SOLUONG);
		getAllCar();
	}
	
	private void Update_KhoHang() {
		String MAXE = txt_maxe_khohang.getText();
		String HANGXE = cbx_hangxe_khohang.getSelectedItem() + "";
		String TENXE = txt_tenxe_khohang.getText();
		String GIAXE = txt_giaxe_khohang.getText();
		String GIAMGIA = cbx_giamgia_khohang.getSelectedItem() + "";
		String PHANLOAI = cbx_phanloai_khohang.getSelectedItem() + "";
		String MAUXE = cbx_mau_khohang.getSelectedItem() + "";
		String SOLUONG=txt_soluong_khohang.getText();
		ps.Update_getlistKhoHang(MAXE, HANGXE,TENXE, GIAXE, GIAMGIA,PHANLOAI,MAUXE,SOLUONG);
		getAllCar();
	}
	private void Delete_KhoHang() {
		String MAXE = txt_maxe_khohang.getText();
		ps.Delete_getlistKhoHang(MAXE);
		getAllCar();
	}
	Vector<String> data = new Vector<String>();
	private void Select_Cbx_HANGXE() {
		lst = ps. getShowHANGXE();
		data.addElement("Hãng xe");
		for(int i = 0; i < lst.size(); i++) {
			Car t = (Car)lst.get(i);
			data.addElement(t.getHANG_XE());
			hangxe_hoadon1.setModel(new DefaultComboBoxModel(data));
		}	
	}
	Vector<String> data1 = new Vector<String>();
	private void Select_Cbx_PHANLOAI() {
		lst = ps. getShowPHANLOAI();
		data1.addElement("Phân loại");
		for(int i = 0; i < lst.size(); i++) {
			Car t = (Car)lst.get(i);
			data1.addElement(t.getLOAI_XE());
			cbx_phanloai_khohang_1.setModel(new DefaultComboBoxModel(data1));
		}	
	}
private void DeleteAll() {

		txt_maxe_khohang.setText("");
		cbx_hangxe_khohang.setSelectedIndex(0) ;
		txt_tenxe_khohang.setText("");
		txt_giaxe_khohang.setText("");
		cbx_giamgia_khohang.setSelectedIndex(0) ;
		cbx_phanloai_khohang.setSelectedIndex(0) ;
		cbx_mau_khohang.setSelectedIndex(0) ;
		txt_soluong_khohang.setText("");

	}
}