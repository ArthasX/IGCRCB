/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.condition;

/**
 * 
 * ���ͳ��ʵ��
 *
 */
public class SingleGoodsStockSearchCondImpl implements SingleGoodsStockSearchCond {
	
	/**
	 * ͳ�ƿ�ʼʱ���ѯ
	 */
	public String etime_from;
	
	/**
	 * ͳ�ƽ���ʱ���ѯ
	 */
	public String etime_to;
	
	/**
	 * ����
	 */
	public String edate;
	
	/**
	 * ��ƷID
	 */
	public String goods;
	
	/** ��Ʒ��� */
	protected String giodcode;
	
	/**
	 * ʳ����֯
	 */
	public String giodorg;
	
	/**
	 * ��Ʒ����
	 */
	public String giodcategory;
	
	/**
	 * ͳ�ƿ�ʼʱ���ѯ
	 * @return ͳ�ƿ�ʼʱ���ѯ
	 */
	public String getEtime_from() {
		return etime_from;
	}
	
	/**
	 * ͳ�ƿ�ʼʱ���ѯ
	 * @param etime_from ͳ�ƿ�ʼʱ���ѯ
	 */
	public void setEtime_from(String etime_from) {
		this.etime_from = etime_from;
	}
	
	/**
	 * ͳ�ƽ���ʱ���ѯ
	 * @return ͳ�ƽ���ʱ���ѯ
	 */
	public String getEtime_to() {
		return etime_to;
	}
	
	/**
	 * ͳ�ƽ���ʱ���ѯ
	 * @param etime_to ͳ�ƽ���ʱ���ѯ
	 */
	public void setEtime_to(String etime_to) {
		this.etime_to = etime_to;
	}
	
	/**
	 * ����
	 * @return ����
	 */
	public String getEdate() {
		return edate;
	}
	
	/**
	 * ����
	 * @param edate ����
	 */
	public void setEdate(String edate) {
		this.edate = edate;
	}

	public String getGoods() {
		return goods;
	}

	public void setGoods(String goods) {
		this.goods = goods;
	}

	public String getGiodorg() {
		return giodorg;
	}

	public void setGiodorg(String giodorg) {
		this.giodorg = giodorg;
	}
	
	public String getGiodcategory() {
		return giodcategory;
	}

	public void setGiodcategory(String giodcategory) {
		this.giodcategory = giodcategory;
	}

	public String getGiodcode() {
		return giodcode;
	}

	public void setGiodcode(String giodcode) {
		this.giodcode = giodcode;
	}

}
