package org.rancode.framework.util;

/**
 * 
 * 说明:自定义TabelModel工具类
 * 
 * @author
 * 
 * */
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class BaseTableModule extends AbstractTableModel {

	Vector<Vector> rows;// 定义行
	Vector<String> columns;// 定义列

	public BaseTableModule(String[] parameters, Vector<Vector> vector) {
		// 初始化列
		this.columns = new Vector<String>();
		for (String column : parameters) {
			columns.add(column);
		}

		// 初始化行
		this.rows = vector;

	}

	@Override
	public String getColumnName(int column) {
		return this.columns.get(column);
	}

	@Override
	public int getColumnCount() {
		return this.columns.size();
	}

	@Override
	public int getRowCount() {
		return this.rows.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return ((Vector) rows.get(rowIndex)).get(columnIndex);
	}

}
