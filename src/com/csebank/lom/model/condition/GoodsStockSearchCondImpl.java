/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.condition;

/**
 * 
 * ���ͳ��ʵ��
 *
 */
public class GoodsStockSearchCondImpl implements GoodsStockSearchCond {
	
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
	 * ��Ʒ��
	 */
	public String goods;
	
	/**
	 * ʳ����֯
	 */
	public String giodorg;
	
	/**
	 * ��Ʒ����
	 */
	public String giodcategory;
	public String flag;
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
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

}
