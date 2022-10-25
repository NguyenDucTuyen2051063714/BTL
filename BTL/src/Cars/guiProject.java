package Cars;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import java.net.URL;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class guiProject extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guiProject frame = new guiProject();
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
	public guiProject() {
		setTitle("Trang chủ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 745, 562);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		URL url_icon_home = guiProject.class.getResource("House-icon.png");
		Image img = Toolkit.getDefaultToolkit().createImage(url_icon_home);
		this.setIconImage(img);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 200, 30);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Quản lý bán ô tô");
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnNewMenu.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(guiProject.class.getResource("Icon_quanly.png"))));
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("Bán hàng");
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu_1.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(guiProject.class.getResource("Icon_banhang.png"))));
		mnNewMenu_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GUI_Car_BanHang f = null;
				f = new GUI_Car_BanHang();
				f.show();
				f.setLocationRelativeTo(null);
			}
		});
		mnNewMenu.add(mnNewMenu_1);
		JMenu mnNewMenu_2 = new JMenu("Kho hàng");
		mnNewMenu_2.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(guiProject.class.getResource("Icon_Khohang.png"))));
		mnNewMenu_2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GUI_KhoHang f = null;
				f = new GUI_KhoHang();
				f.show();
				f.setLocationRelativeTo(null);
			}
		});
		mnNewMenu.add(mnNewMenu_2);
		JMenu mnNewMenu_3 = new JMenu("Hóa đơn");
		mnNewMenu_3.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(guiProject.class.getResource("Icon_Hoadon.png"))));
		mnNewMenu_3.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GUI_HoaDon f = null;
				f = new GUI_HoaDon();
				f.show();
				f.setLocationRelativeTo(null);
			}
		});
		mnNewMenu.add(mnNewMenu_3);
		JMenu mnNewMenu_4 = new JMenu("Nhân viên");
		mnNewMenu_4.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(guiProject.class.getResource("Icon_Nhanvien.png"))));
		mnNewMenu_4.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GUI_Staff f = null;
				f = new GUI_Staff();
				f.show();
				f.setLocationRelativeTo(null);
			}
		});
		mnNewMenu.add(mnNewMenu_4);
		JMenu mnNewMenu_5 = new JMenu("Khách hàng");
		mnNewMenu_5.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(guiProject.class.getResource("Icon_Khachhang.png"))));
		mnNewMenu_5.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GUI_KhachHang f = null;
				f = new GUI_KhachHang();
				f.show();
				f.setLocationRelativeTo(null);
			}
		});
		mnNewMenu.add(mnNewMenu_5);
		JMenu mnNewMenu_6 = new JMenu("Thống kê");
		mnNewMenu_6.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(guiProject.class.getResource("Icon_Thongke.png"))));
		mnNewMenu_6.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GUI_ThongKe f = null;
				f = new GUI_ThongKe();
				f.show();
				f.setLocationRelativeTo(null);
			}
		});
		mnNewMenu.add(mnNewMenu_6);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 5));
		lblNewLabel.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(guiProject.class.getResource("main.jpg"))));
		lblNewLabel.setBounds(0, 0, 736, 525);
		contentPane.add(lblNewLabel);
		
		JMenu mnNewMenu_7 = new JMenu("Thoát");
		mnNewMenu_7.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu_7.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(guiProject.class.getResource("Icon_thoat.png"))));
		mnNewMenu_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int hoi = JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát không?",
                        null, JOptionPane.YES_NO_OPTION);
                if (hoi == JOptionPane.YES_OPTION) {
                	System.exit(0);
                }
			}
		});
		mnNewMenu.add(mnNewMenu_7);
	}
}
