/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.condition;

/**
 * 
 * ���ͳ�ƽӿ�
 *
 */
public interface SingleGoodsStockSearchCond {
	
	/**
	 * ����
	 */
	public String getEdate();
	
	/**
	 * ͳ�Ʋ�ѯʱ�俪ʼ
	 */
	public String getEtime_from();
	
	/**
	 * ͳ�Ʋ�ѯʱ�����
	 */
	public String getEtime_to();
	
	/**
	 * ��ƷID
	 */
	public String getGoods();
	public String getGiodcode();
	public String getGiodorg();
	public String getGiodcategory();

}
