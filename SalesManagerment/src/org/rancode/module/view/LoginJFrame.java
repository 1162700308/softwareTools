package org.rancode.module.view;

import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;
import org.rancode.framework.util.ImagePanel;
import org.rancode.framework.util.MyFont;
import org.rancode.module.entity.User;
import org.rancode.module.services.Impl.UserServiceImpl;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class LoginJFrame extends JFrame implements MouseListener, FocusListener {

	// 全局的位置变量，用于表示鼠标在窗口上的位置
	static Point origin = new Point();

	// 定义全局组件
	JTextField username = new JTextField(20);//用户名
	JPasswordField password = new JPasswordField(20);//密码
	ImagePanel backgroundPanel = null;
	JButton button_minimize, button_close, button_login, button_reset;//按钮，最小化，关闭，登录，重置

	public LoginJFrame() {
		//System.setProperty("sun.java2d.noddraw", "true");//防止窗口白屏，开始加错了位置
		//窗口淡入淡出
		//new WindowOpacity(this);//取消了窗口淡入淡出的动画
		Image backgrounImage = null;
		try {
			backgrounImage = ImageIO.read(new File("image/loginbackground.png"));
			Image imgae = ImageIO.read(new File("image/logo.png"));
			//this.setIconImage(imgae);//应用图标更改
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 窗口背景面板
		backgroundPanel = new ImagePanel(backgrounImage);
		backgroundPanel.setLayout(null);//设置布局，默认流式布局

		username.setBounds(378, 202, 173, 30);//前两个150，150表示新建窗体的起始点（即x横向150，y纵向150处）第三个150表示新建窗体的宽度，第四个150表示新建窗体的高度 
		username.setFont(MyFont.Static);
		username.addFocusListener(this);
		username.setText("用户名/账号");
		username.setText("admin");

		password.setBounds(378, 240, 173, 30);
		password.setFont(MyFont.Static);
		password.addFocusListener(this);
		password.setText("密码");
		password.setText("123456");
		password.setEchoChar('\0');//设置输密码的时候显示的字符，回显字符

		button_login = new JButton("登录");
		button_login.setBounds(380, 280, 70, 27);
		button_login.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.lightBlue));
		button_login.setForeground(Color.white);
		button_login.setFont(MyFont.Static);
		button_login.addMouseListener(this);

		button_reset = new JButton("重置");
		button_reset.setBounds(480, 280, 70, 27);
		button_reset.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.red));
		button_reset.setForeground(Color.white);
		button_reset.setFont(MyFont.Static);
		button_reset.addMouseListener(this);

		backgroundPanel.add(username);
		backgroundPanel.add(password);
		backgroundPanel.add(button_login);
		backgroundPanel.add(button_reset);

		this.add(backgroundPanel);
		this.setTitle("销售管理系统");
		this.setSize(830, 530);
		this.setVisible(true);
		this.requestFocus();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}

	// 鼠标点击事件
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == button_login) {
			if ("用户名/账号".equals(username.getText())) {
				JOptionPane.showMessageDialog(null, "用户名不能为空");
			} else if ("密码".equals(password.getText())) {
				JOptionPane.showMessageDialog(null, "用户密码不能为空");
			} else {
				String params[] = { username.getText(), password.getText() };
				UserServiceImpl userService = new UserServiceImpl();
				try {
					User user = userService.selectOne(params);
					if (user == null) {
						JOptionPane.showMessageDialog(null, "用户名密码有误");
					} else {
						this.setVisible(false);
						new IndexJFrame(user);

					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		} else if (e.getSource() == button_reset) {
			username.setText("用户名/账号");
			username.setText("admin");
			password.setText("密码");
			password.setText("123456");
			password.setEchoChar('\0');//设置密码那个框内文字可见
		}

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	// 聚焦事件
	@Override
	public void focusGained(FocusEvent e) {
		if (e.getSource() == username) {
			if (username.getText().equals("用户名/账号")) {
				username.setText("");
			}
		} else if (e.getSource() == password) {
			if (password.getText().equals("密码")) {
				password.setText("");
				password.setEchoChar('*');
			}
		}

	}

	// 失焦事件
	@Override
	public void focusLost(FocusEvent e) {
		if (e.getSource() == username) {
			if (username.getText().equals("")) {
				username.setText("用户名/账号");
			}
		} else if (e.getSource() == password) {
			if (password.getText().equals("")) {
				password.setText("密码");
				password.setEchoChar('\0');
			}
		}
	}

	
}