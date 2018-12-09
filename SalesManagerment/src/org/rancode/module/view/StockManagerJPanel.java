package org.rancode.module.view;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableColumnModel;

import org.rancode.framework.util.BaseTableModule;
import org.rancode.framework.util.Item;
import org.rancode.framework.util.Tools;
import org.rancode.module.services.Impl.CategoryServiceImpl;
import org.rancode.module.services.Impl.GoodsServiceImpl;
import org.rancode.module.services.Impl.WarehouseServiceImpl;

public class StockManagerJPanel extends GoodsManagerJPanel implements ActionListener, MouseListener  {

	// 初始化顶部面板
	public void initTopPanel() {

		super.initTopPanel();
	}

	// 初始化工具面板
	public void initToolPanel() {

		toolPanel = new JPanel();
		// 工具图标
		Icon icon_modify = new ImageIcon("image/modify.png");
		tool_modify = new JLabel(icon_modify);
		tool_modify.setToolTipText("修改库存");
		tool_modify.addMouseListener(this);
		
		toolPanel.add(tool_modify);

		topPanel.add(toolPanel, "West");

	}

	// 初始化搜素条件面板
	public void initSearchPanel() {

		super.initSearchPanel();
		
	}

	// 初始化数据表格面板
	public void initTablePanel() {

		String conditionParams[] = { "全部", "全部" };
		String params[] = { "商品id", "名称", "价格", "产地", "所属分类", "所属仓库", "库存", "仓库id", "分类id" };
		GoodsServiceImpl goodsService = new GoodsServiceImpl();
		Vector<Vector> vector = new Vector<Vector>();
		try {
			vector = goodsService.selectByCondition(conditionParams);
		} catch (Exception e) {
			e.printStackTrace();
		}

		baseTableModule = new BaseTableModule(params, vector);

		table = new JTable(baseTableModule);
		Tools.setTableStyle(table);
		DefaultTableColumnModel dcm = (DefaultTableColumnModel) table.getColumnModel();// 获取列模型
		dcm.getColumn(0).setMinWidth(0); // 将第一列的最小宽度、最大宽度都设置为0
		dcm.getColumn(0).setMaxWidth(0);
		dcm.getColumn(3).setMinWidth(0); // 将第一列的最小宽度、最大宽度都设置为0
		dcm.getColumn(3).setMaxWidth(0);
		dcm.getColumn(2).setMinWidth(0); // 将第3列的最小宽度、最大宽度都设置为0
		dcm.getColumn(2).setMaxWidth(0);
		dcm.getColumn(4).setMinWidth(0); // 将第一列的最小宽度、最大宽度都设置为0
		dcm.getColumn(4).setMaxWidth(0);
		dcm.getColumn(7).setMinWidth(0); // 将第8列的最小宽度、最大宽度都设置为0
		dcm.getColumn(7).setMaxWidth(0);
		dcm.getColumn(8).setMinWidth(0); // 将第9列的最小宽度、最大宽度都设置为0
		dcm.getColumn(8).setMaxWidth(0);

		jScrollPane = new JScrollPane(table);
		Tools.setJspStyle(jScrollPane);

		tablePanel = new JPanel(new BorderLayout());
		tablePanel.setOpaque(false);

		tablePanel.add(jScrollPane);

		backgroundPanel.add(tablePanel, "Center");
	}

	// 更新数据表格
	public void refreshTablePanel() {

		backgroundPanel.remove(tablePanel);
		Item item_category = (Item) select_category.getSelectedItem();
		Item item_warehouse = (Item) select_warehouse.getSelectedItem();
		String conditionParams[] = { item_category.getKey(), item_warehouse.getKey() };
		String params[] = { "商品id", "名称", "价格", "产地", "所属分类", "所属仓库", "库存", "仓库id", "分类id" };
		GoodsServiceImpl goodsService = new GoodsServiceImpl();
		Vector<Vector> vector = new Vector<Vector>();
		try {
			vector = goodsService.selectByCondition(conditionParams);
		} catch (Exception e) {
			e.printStackTrace();
		}

		baseTableModule = new BaseTableModule(params, vector);

		table = new JTable(baseTableModule);
		Tools.setTableStyle(table);
		DefaultTableColumnModel dcm = (DefaultTableColumnModel) table.getColumnModel();// 获取列模型
		dcm.getColumn(0).setMinWidth(0); // 将第一列的最小宽度、最大宽度都设置为0
		dcm.getColumn(0).setMaxWidth(0);
		dcm.getColumn(2).setMinWidth(0); // 将第3列的最小宽度、最大宽度都设置为0
		dcm.getColumn(2).setMaxWidth(0);
		dcm.getColumn(3).setMinWidth(0); // 将第一列的最小宽度、最大宽度都设置为0
		dcm.getColumn(3).setMaxWidth(0);
		dcm.getColumn(4).setMinWidth(0); // 将第一列的最小宽度、最大宽度都设置为0
		dcm.getColumn(4).setMaxWidth(0);
		dcm.getColumn(7).setMinWidth(0); // 将第8列的最小宽度、最大宽度都设置为0
		dcm.getColumn(7).setMaxWidth(0);
		dcm.getColumn(8).setMinWidth(0); // 将第9列的最小宽度、最大宽度都设置为0
		dcm.getColumn(8).setMaxWidth(0);

		jScrollPane = new JScrollPane(table);
		Tools.setJspStyle(jScrollPane);

		tablePanel = new JPanel(new BorderLayout());
		tablePanel.setOpaque(false);

		tablePanel.add(jScrollPane);

		backgroundPanel.add(tablePanel, "Center");
		backgroundPanel.validate();
	}

	// 下拉框改变事件
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == select_category) {
			refreshTablePanel();
		} else if (e.getSource() == select_warehouse) {
			refreshTablePanel();
		}

	}

	// 鼠标点击事件
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tool_add) {
			new AddGoodsJFrame(this);
		} else if (e.getSource() == tool_modify) {
			int row = table.getSelectedRow();
			if (row < 0) {
				JOptionPane.showMessageDialog(null, "请选择商品");
			} else {
				//new ModifyGoodsJFrame(this, table, row);
				new ModifyStockJFrame(this, table, row);
			}

		} else if (e.getSource() == tool_delete) {
			int row = table.getSelectedRow();
			if (row < 0) {
				JOptionPane.showMessageDialog(null, "请选择商品");
			} else {
				String id = (String) table.getValueAt(row, 0);
				int result = JOptionPane.showConfirmDialog(null, "是否确定删除？", "用户提示", JOptionPane.YES_NO_OPTION);
				if (result == 0) {
					String[] params = { id };
					GoodsServiceImpl goodsService = new GoodsServiceImpl();
					try {
						int tempresult = goodsService.deleteById(params);
						if (tempresult > 0) {
							JOptionPane.showMessageDialog(null, "商品删除成功！");
							refreshTablePanel();
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		}

	}

	// 鼠标划入事件
	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == tool_add) {
			tool_add.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		} else if (e.getSource() == tool_modify) {
			tool_modify.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		} else if (e.getSource() == tool_delete) {
			tool_delete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
