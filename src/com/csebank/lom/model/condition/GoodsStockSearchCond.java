/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.condition;

/**
 * 
 * ���ͳ�ƽӿ�
 *
 */
public interface GoodsStockSearchCond {
	
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
	public String getFlag();
	public String getGoods();
	public String getGiodorg();
	public String getGiodcategory();

}
