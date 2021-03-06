package org.module.client.presentation.orderui;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.jdesktop.swingx.JXDatePicker;
import org.module.client.main.Main;
import org.module.client.presentation.DateTransferHelper;
import org.module.client.presentation.Numeric;
import org.module.client.vo.AbstractArrialListVO;

import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class NewArrivalListInputFrame extends JFrame {

	
	private static final long serialVersionUID = -4520957429125852209L;
	protected JPanel contentPane;
	protected JTextField deparmentID;
	protected JTextField transportID;
	protected JTextField origin;
	protected String[] arriveState = {"完整","损坏","丢失"};
	protected JButton comfirm;
	protected JButton cancel;
	protected JLabel state;
	protected JComboBox stateOfArrival;
	protected JXDatePicker time;
	
	
	public NewArrivalListInputFrame() {
		init();
		this.addListeners();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String dateString = formatter.format(new Date());
		String s = Main.currentUser.getDepartmeny() + dateString;
		this.transportID.setText(s);
	}
	
	public NewArrivalListInputFrame(AbstractArrialListVO vo) {
		init();
		this.addListeners();
		this.deparmentID.setText(vo.getDepartmentId());
		this.time.setDate(DateTransferHelper.getDate(vo.getDate()));
		this.transportID.setText(vo.getTransportListId());
		this.stateOfArrival.setSelectedItem(vo.getStateOfGoods());
		this.origin.setText(vo.getOrigin());
		this.transportID.setEditable(false);
	}
	
	protected void init(){	
		setBounds(400, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		state = new JLabel("");
		state.setFont(new Font("楷体", Font.PLAIN, 16));
		
		JLabel label = new JLabel("部门编号");
		label.setFont(new Font("楷体", Font.PLAIN, 16));
		
		JLabel label_1 = new JLabel("中转单号");
		label_1.setFont(new Font("楷体", Font.PLAIN, 16));
		
		JLabel label_2 = new JLabel("出发地");
		label_2.setFont(new Font("楷体", Font.PLAIN, 16));
		
		JLabel label_3 = new JLabel("到达时间");
		label_3.setFont(new Font("楷体", Font.PLAIN, 16));
		
		JLabel label_4 = new JLabel("到达状态");
		label_4.setFont(new Font("楷体", Font.PLAIN, 16));
		
		stateOfArrival = new JComboBox(arriveState);
		
		time = new JXDatePicker();
		time.setDate(new Date());
		
		deparmentID = new JTextField();
		
		deparmentID.setFont(new Font("楷体", Font.PLAIN, 15));
		deparmentID.setColumns(10);
		
		transportID = new JTextField();
		
		transportID.setFont(new Font("楷体", Font.PLAIN, 15));
		transportID.setColumns(10);
		
		origin = new JTextField();
		
		origin.setFont(new Font("楷体", Font.PLAIN, 15));
		origin.setColumns(10);
		
		comfirm = new JButton("确定");
		comfirm.setFont(new Font("方正姚体", Font.PLAIN, 12));
		
		cancel = new JButton("取消");
		cancel.setFont(new Font("方正姚体", Font.PLAIN, 12));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(98)
					.addComponent(state, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(102, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(118)
							.addComponent(comfirm, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
							.addGap(30))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(42)
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(origin, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
							.addGap(23)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(stateOfArrival, 0, 88, Short.MAX_VALUE))
						.addComponent(cancel, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
					.addGap(15))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(42)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(transportID, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(deparmentID, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
							.addGap(21)
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(time, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)))
					.addGap(16))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(state)
					.addGap(23)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(deparmentID, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addComponent(time, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(15)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(transportID, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(origin, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(stateOfArrival, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(comfirm)
						.addComponent(cancel)))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	protected void addListeners(){
		cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		
		deparmentID.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if(!Numeric.isNumeric(deparmentID.getText())||deparmentID.getText().length()!=6){
					state.setText("！部门编号必须是6位数值");
				}else{
					state.setText("");
				}
			}
		});
		
		transportID.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if((!Numeric.isNumeric(transportID.getText()))||transportID.getText().length()!=21){
					state.setText("！中转单号必须是21位数值");
				}else{
					state.setText("");
				}
			}
		});
		
		origin.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if(origin.getText().isEmpty()){
					state.setText("！出发地不能为空");
				}else{
					state.setText("");
				}
			}
		});
		
	}
	public JButton getComfirmButton() {
		return comfirm;
	}
	/**
	 * 
	 * @return
	 */
	public boolean isDataUsable(){
		if(!Numeric.isNumeric(deparmentID.getText())||deparmentID.getText().length()!=6){
			return false;
		}else if(!Numeric.isNumeric(transportID.getText())||transportID.getText().length()!=21){
			return false;
		}else if(origin.getText().isEmpty()){
			return false;
		}
		return true;
	}
}
