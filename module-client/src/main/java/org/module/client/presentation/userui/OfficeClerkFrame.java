package org.module.client.presentation.userui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import org.module.client.presentation.managementui.Cars;
import org.module.client.presentation.managementui.DriversPanel;
import org.module.client.presentation.orderui.ListTableForOfficeArrival;
import org.module.client.presentation.orderui.ListTableForOfficeLoading;
import org.module.client.presentation.orderui.ListTableForSending;
import org.module.client.presentation.statisticui.ReceiptPanel;

public class OfficeClerkFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OfficeClerkFrame frame = new OfficeClerkFrame();
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
	public OfficeClerkFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 545, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel label = new JLabel("营业厅业务员");
		panel.add(label);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel_1 = new Cars();
		tabbedPane.addTab("车辆管理", null, panel_1, null);
		
		JPanel panel_2 = new DriversPanel();
		tabbedPane.addTab("司机管理", null, panel_2, null);
		
		JPanel panel_3 = new ListTableForOfficeLoading();
		tabbedPane.addTab("订单装车", null, panel_3, null);
		
		JPanel panel_4 = new ListTableForOfficeArrival();
		tabbedPane.addTab("订单接收", null, panel_4, null);
		
		JPanel panel_5 = new ListTableForSending();
		tabbedPane.addTab("订单派送", null, panel_5, null);
		
		JPanel panel_6 = new ReceiptPanel();
		tabbedPane.addTab("收款单管理", null, panel_6, null);
	}

}
