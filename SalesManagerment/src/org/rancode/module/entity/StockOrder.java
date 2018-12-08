package org.rancode.module.entity;

public class StockOrder {
	private String id;
	private String billNo;//销售单编号
	private String handlerId;//经手人ID
	private String warehouseId;//仓库
	private String categoryId;//所属类别
	private double amount;//数量
	private String goodsId;//商品ID
	private int sign;
	private int del_flag;//删除标识

	public int getDel_flag() {
		return del_flag;//是否删除
	}

	public void setDel_flag(int del_flag) {
		this.del_flag = del_flag;//定义删除
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public String getHandlerId() {
		return handlerId;
	}

	public void setHandlerId(String handlerId) {
		this.handlerId = handlerId;
	}

	public String getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(String warehouseId) {
		this.warehouseId = warehouseId;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public int getSign() {
		return sign;
	}

	public void setSign(int sign) {
		this.sign = sign;
	}

}
