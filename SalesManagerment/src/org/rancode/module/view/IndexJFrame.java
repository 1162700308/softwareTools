package org.rancode.module.view;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.*;
import javax.swing.*;

import org.rancode.framework.util.ImagePanel;
import org.rancode.framework.util.MyFont;
import org.rancode.module.entity.User;

public class IndexJFrame extends JFrame implements MouseListener, ActionListener {

	// 定义用户对象
	private User user;

	// 定义辅助变量
	int sign_home = 0;//首页
	int sign_baseData = 0;//货品资料维护
	int sign_purchase_sale_stock = 0;//销售业务管理
	int sign_person_manager = 0;//客户资料维护
	int sign_warehouse_manager=0;//库存管理
	int sign_userManager = 0;//密码修改

	// 获得屏幕的大小
	final static int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	final static int height = Toolkit.getDefaultToolkit().getScreenSize().height;

	// 定义全局组件
	JPanel backgroundPanel, topPanel, topMenu, topPrompt, centerPanel, subPanel, subMenu;//背景图，顶部，顶部菜单，快捷方式，中心，子面板，子菜单
	JTabbedPane jTabbedPane;

	JLabel home, baseData, purchase_sale_stock, person_manager,warehouse_manager,user_manager;

	public IndexJFrame(User user) {

		this.user = user;
		
		//窗口淡入淡出
		//new WindowOpacity(this);//取消
		
		// 设置tab面板缩进
		UIManager.put("TabbedPane.tabAreaInsets", new javax.swing.plaf.InsetsUIResource(0, 0, 0, 0));//界面管理

//		try {
//			Image imgae = ImageIO.read(new File("image/logo.png"));
//			this.setIconImage(imgae);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		initBackgroundPanel();

		this.setTitle("销售管理系统");
		this.setSize((int) (width * 0.8f), (int) (height * 0.8f));
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	// 初始化背景面板
	public void initBackgroundPanel() {

		backgroundPanel = new JPanel(new BorderLayout());
		initTop();
		initCenterPanel();

		backgroundPanel.add(topPanel, "North");
		backgroundPanel.add(centerPanel, "Center");

		this.add(backgroundPanel);
	}

	// 初始化顶部顶部面板
	public void initTop() {

		initTopMenu();
		//initTopPrompt();

		topPanel = new JPanel(new BorderLayout());
		//topPanel.setPreferredSize(null);
		topPanel.setPreferredSize(new Dimension((int) (width * 0.8f), 40));
		topPanel.add(topMenu, "West");
		//topPanel.add(topPrompt, "East");
	}

	// 初始化顶部菜单
	public void initTopMenu() {

		topMenu = new JPanel();
		topMenu.setPreferredSize(new Dimension((int) (width * 0.8f), 40));//设置最好的大小
		//topMenu.setOpaque(false);//美化使用,不知道干啥的，先注释

		String[] nameStrings = { "首页", "货品资料维护", "销售业务管理", "客户资料维护","库存管理","用户管理"};

		home = CreateMenuLabel(home, nameStrings[0], "home", topMenu);
		//home.setName("home");
		baseData = CreateMenuLabel(baseData, nameStrings[1], "baseData", topMenu);
		//baseData.setName("baseData");
		purchase_sale_stock = CreateMenuLabel(purchase_sale_stock, nameStrings[2], "purchase_sale_stock", topMenu);
		//purchase_sale_stock.setName("purchase_sale_stock");
		person_manager = CreateMenuLabel(person_manager, nameStrings[3], "person_manager", topMenu);
		//person_manager.setName("userManager");
		warehouse_manager = CreateMenuLabel(warehouse_manager, nameStrings[4], "warehouse_house", topMenu);
		//warehouse_manager.setName("userManager");
		user_manager= CreateMenuLabel(user_manager, nameStrings[5], "user_manager", topMenu);
		//user_manager.setName("userManager");
	}

	// 创建顶部菜单Label
	public JLabel CreateMenuLabel(JLabel jlb, String text, String name, JPanel who) {
		JLabel line = new JLabel("<html>&nbsp;<font color='#D2D2D2'>|</font>&nbsp;</html>");
		//Icon icon = new ImageIcon("image/" + name + ".png");
		//jlb = new JLabel(icon);//设置图标等等
		jlb =new JLabel();
		jlb.setText("<html><font color='black'>" + text + "</font>&nbsp;</html>");
		jlb.addMouseListener(this);
		jlb.setFont(MyFont.Static);
		who.add(jlb);
		if (!"user_manager".equals(name)) {
			who.add(line);
		}//这些代码是在各个标签中加入竖线
		return jlb;
	}

	// 初始化顶部欢迎面板
	public void initTopPrompt() {

//		Icon icon = new ImageIcon("image/male.png");
//		JLabel label = new JLabel(icon);
		//JLabel label= new JLabel();
//		if (user != null) {
//			label.setText("<html><font color='black'>欢迎您，</font><font color='#336699'><b>" + this.user.getName()
//					+ "</b></font></html>");
//		} else {
//			label.setText("<html><font color='black'>欢迎您，</font><font color='#336699'><b></b></font></html>");
//		}
		//label.setFont(MyFont.Static);
//		topPrompt = new JPanel();
//		topPrompt.setPreferredSize(new Dimension(180, 40));
//		topPrompt.setOpaque(false);
//		topPrompt.add(label);

	}

	// 初始化中心面板
	public void initCenterPanel() {
		centerPanel = new JPanel(new BorderLayout());
		home.setText("<html><font color='#336699' style='font-weight:bold'>" + "首页" + "</font>&nbsp;</html>");
		creatHome();
		centerPanel.setOpaque(false);
	}

	// 初始化辅助变量
	public void initSign() {
		sign_home = 0;//首页
		sign_baseData = 0;//货品资料维护
		sign_purchase_sale_stock = 0;//销售业务管理
		sign_person_manager = 0;//客户资料维护
		sign_warehouse_manager=0;//库存管理
		sign_userManager = 0;//用户管理
	}

	// 创建首页面板
	public void creatHome() {

		centerPanel.removeAll();
		try {
			Image bgimg = ImageIO.read(new File("image/indexbackground.png"));
			ImagePanel centerBackground = new ImagePanel(bgimg);
			centerPanel.add(centerBackground, "Center");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// 创建货品资料维护面板
	public void creatBaseDataTab() {

		centerPanel.removeAll();
		// 设置tab标题位置
		jTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		// 设置tab布局
		jTabbedPane.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
		jTabbedPane.setFont(MyFont.Static);

		jTabbedPane.addTab("货品资料管理", new GoodsManagerJPanel().backgroundPanel);
		centerPanel.add(jTabbedPane, "Center");
	}

	// // 创建销售业务面板
	public void creatpurchaseSaleStockTab() {

		centerPanel.removeAll();
		// 设置tab标题位置
		jTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		// 设置tab布局
		jTabbedPane.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
		jTabbedPane.setFont(MyFont.Static);

		jTabbedPane.addTab("批发销售单", new SaleOrderManagerJPanel(user).backgroundPanel);
		jTabbedPane.addTab("Post收银台", new StockInputManagerJPanel(user).backgroundPanel);
		//jTabbedPane.addTab("出库单", new StockOutputManagerJPanel(user).backgroundPanel);
		//jTabbedPane.addTab("库存管理", new WarehouseManagerJPanel().backgroundPanel);

		centerPanel.add(jTabbedPane, "Center");
	}

	// 刷新销售业务管理面板
	public void refreshpurchaseSaleStockTab() {

		centerPanel.removeAll();
		// 设置tab标题位置
		jTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		// 设置tab布局
		jTabbedPane.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
		jTabbedPane.setFont(MyFont.Static);

		jTabbedPane.addTab("批发销售单", new SaleOrderManagerJPanel(user).backgroundPanel);
		jTabbedPane.addTab("Post收银台", new StockInputManagerJPanel(user).backgroundPanel);
//		jTabbedPane.addTab("销售单", new SaleOrderManagerJPanel(user).backgroundPanel);
//		jTabbedPane.addTab("入库单", new StockInputManagerJPanel(user).backgroundPanel);
//		jTabbedPane.addTab("出库单", new StockOutputManagerJPanel(user).backgroundPanel);
//		jTabbedPane.addTab("库存管理", new WarehouseManagerJPanel().backgroundPanel);

		centerPanel.add(jTabbedPane, "Center");
	}
	public void creatwarehousemanagerTab() {

		centerPanel.removeAll();
		// 设置tab标题位置
		jTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		// 设置tab布局
		jTabbedPane.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
		jTabbedPane.setFont(MyFont.Static);

		//jTabbedPane.addTab("销售单", new SaleOrderManagerJPanel(user).backgroundPanel);
		jTabbedPane.addTab("入库单", new StockInputManagerJPanel(user).backgroundPanel);
		jTabbedPane.addTab("出库单", new StockOutputManagerJPanel(user).backgroundPanel);
		jTabbedPane.addTab("调拨商品", new StockOutputManagerJPanel(user).backgroundPanel);
		jTabbedPane.addTab("库存管理", new WarehouseManagerJPanel().backgroundPanel);

		centerPanel.add(jTabbedPane, "Center");
	}

	// 刷新进销存管理面板
	public void referwarehousemanagerTab() {

		centerPanel.removeAll();
		// 设置tab标题位置
		jTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		// 设置tab布局
		jTabbedPane.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
		jTabbedPane.setFont(MyFont.Static);

		//jTabbedPane.addTab("销售单", new SaleOrderManagerJPanel(user).backgroundPanel);
		jTabbedPane.addTab("入库单", new StockInputManagerJPanel(user).backgroundPanel);
		jTabbedPane.addTab("出库单", new StockOutputManagerJPanel(user).backgroundPanel);
		jTabbedPane.addTab("库存管理", new WarehouseManagerJPanel().backgroundPanel);

		centerPanel.add(jTabbedPane, "Center");
	}

	// 创建用户管理面板
	public void creatUserManagerTab() {

		centerPanel.removeAll();
		// 设置tab标题位置
		jTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		// 设置tab布局
		jTabbedPane.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
		jTabbedPane.setFont(MyFont.Static);

		jTabbedPane.addTab("用户管理", new UserManagerJPanel(user, this).backgroundPanel);
		centerPanel.add(jTabbedPane, "Center");
	}

	// 鼠标点击事件
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == home) {
			initSign();
			sign_home = 1;
			creatHome();
			home.setText("<html><font color='#336699' style='font-weight:bold'>" + "首页" + "</font>&nbsp;</html>");
			baseData.setText("<html><font color='black'>" + "货品资料维护" + "</font>&nbsp;</html>");
			purchase_sale_stock.setText("<html><font color='black'>" + "销售业务管理" + "</font>&nbsp;</html>");
			person_manager.setText("<html><font color='black'>" + "客户资料维护" + "</font>&nbsp;</html>");
			warehouse_manager.setText("<html><font color='black'>" + "库存管理" + "</font>&nbsp;</html>");
			user_manager.setText("<html><font color='black'>" + "用户管理" + "</font>&nbsp;</html>");
		} else if (e.getSource() == baseData) {
			initSign();
			sign_baseData = 1;
			creatBaseDataTab();
			baseData.setText("<html><font color='#336699' style='font-weight:bold'>" + "货品资料维护" + "</font>&nbsp;</html>");
			home.setText("<html><font color='black'>" + "首页" + "</font>&nbsp;</html>");
			purchase_sale_stock.setText("<html><font color='black'>" + "销售业务管理" + "</font>&nbsp;</html>");
			person_manager.setText("<html><font color='black'>" + "客户资料维护" + "</font>&nbsp;</html>");
			warehouse_manager.setText("<html><font color='black'>" + "库存管理" + "</font>&nbsp;</html>");
			user_manager.setText("<html><font color='black'>" + "用户管理" + "</font>&nbsp;</html>");
		} else if (e.getSource() == purchase_sale_stock) {
			initSign();
			sign_purchase_sale_stock = 1;
			creatpurchaseSaleStockTab();
			purchase_sale_stock.setText(
					"<html><font color='#336699' style='font-weight:bold'>" + "销售业务管理" + "</font>&nbsp;</html>");
			home.setText("<html><font color='black'>" + "首页" + "</font>&nbsp;</html>");
			baseData.setText("<html><font color='black'>" + "货品资料维护" + "</font>&nbsp;</html>");
			person_manager.setText("<html><font color='black'>" + "客户资料维护" + "</font>&nbsp;</html>");
			warehouse_manager.setText("<html><font color='black'>" + "库存管理" + "</font>&nbsp;</html>");
			user_manager.setText("<html><font color='black'>" + "用户管理" + "</font>&nbsp;</html>");
		}  else if (e.getSource() == person_manager) {
			initSign();
			sign_person_manager= 1;
			//creatpurchaseSaleStockTab();
			person_manager.setText(
					"<html><font color='#336699' style='font-weight:bold'>" + "客户资料维护" + "</font>&nbsp;</html>");
			home.setText("<html><font color='black'>" + "首页" + "</font>&nbsp;</html>");
			baseData.setText("<html><font color='black'>" + "货品资料维护" + "</font>&nbsp;</html>");
			purchase_sale_stock.setText("<html><font color='black'>" + "销售业务管理" + "</font>&nbsp;</html>");
			warehouse_manager.setText("<html><font color='black'>" + "库存管理" + "</font>&nbsp;</html>");
			user_manager.setText("<html><font color='black'>" + "用户管理" + "</font>&nbsp;</html>");
		}  else if (e.getSource() == warehouse_manager) {
			initSign();
			sign_warehouse_manager = 1;
			creatwarehousemanagerTab();
			warehouse_manager.setText("<html><font color='#336699' style='font-weight:bold'>" + "库存管理" + "</font>&nbsp;</html>");
			home.setText("<html><font color='black'>" + "首页" + "</font>&nbsp;</html>");
			baseData.setText("<html><font color='black'>" + "货品资料维护" + "</font>&nbsp;</html>");
			person_manager.setText("<html><font color='black'>" + "客户资料维护" + "</font>&nbsp;</html>");
			purchase_sale_stock.setText("<html><font color='black'>" + "销售业务管理" + "</font>&nbsp;</html>");
			user_manager.setText("<html><font color='black'>" + "用户管理" + "</font>&nbsp;</html>");
		} else if (e.getSource() == user_manager) {
			initSign();
			sign_userManager = 1;
			creatUserManagerTab();
			user_manager.setText("<html><font color='#336699' style='font-weight:bold'>" + "用户管理" + "</font>&nbsp;</html>");
			home.setText("<html><font color='black'>" + "首页" + "</font>&nbsp;</html>");
			baseData.setText("<html><font color='black'>" + "货品资料维护" + "</font>&nbsp;</html>");
			purchase_sale_stock.setText("<html><font color='black'>" + "销售业务管理" + "</font>&nbsp;</html>");
		} else {
			//System.out.println("ok");
		}

	}

	// 鼠标划入事件
	@Override
	public void mouseEntered(MouseEvent e) {
//		if (e.getSource() == home) {
//			home.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//			home.setText("<html><font color='#336699' style='font-weight:bold'>" + "首页" + "</font>&nbsp;</html>");
//		} else if (e.getSource() == baseData) {
//			baseData.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//			baseData.setText("<html><font color='#336699' style='font-weight:bold'>" + "货品资料维护" + "</font>&nbsp;</html>");
//		} else if (e.getSource() == purchase_sale_stock) {
//			purchase_sale_stock.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//			purchase_sale_stock.setText(
//					"<html><font color='#336699' style='font-weight:bold'>" + "销售业务管理" + "</font>&nbsp;</html>");
//		} else if (e.getSource() == user_manager) {
//			user_manager.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//			user_manager.setText("<html><font color='#336699' style='font-weight:bold'>" + "用户管理" + "</font>&nbsp;</html>");
//		}

	}

	// 鼠标划出事件
	@Override
	public void mouseExited(MouseEvent e) {
//		if (e.getSource() == home) {
//			if (sign_home == 0) {
//				home.setText("<html><font color='black'>" + "首页" + "</font>&nbsp;</html>");
//			}
//		} else if (e.getSource() == baseData) {
//			if (sign_baseData == 0) {
//				baseData.setText("<html><font color='black'>" + "货品资料维护" + "</font>&nbsp;</html>");
//			}
//		} else if (e.getSource() == purchase_sale_stock) {
//			if (sign_purchase_sale_stock == 0) {
//				purchase_sale_stock.setText("<html><font color='black'>" + "销售业务管理" + "</font>&nbsp;</html>");
//			}
//		} else if (e.getSource() == user_manager) {
//			if (sign_userManager == 0) {
//				user_manager.setText("<html><font color='black'>" + "用户管理" + "</font>&nbsp;</html>");
//			}
//		}

	}
	
	
	/*
	 * 默认鼠标其他操作的事件处理，不用管。(non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	}
	
}
