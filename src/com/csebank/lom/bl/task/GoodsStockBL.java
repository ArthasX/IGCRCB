/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.GoodsStock;
import com.csebank.lom.model.condition.GoodsStockSearchCond;
import com.deliverik.framework.base.BaseBL;

/**
 * ���ͳ��ҵ���߼��ӿ�
 */
public interface GoodsStockBL extends BaseBL {
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<GoodsStock> searchGoodsStock(GoodsStockSearchCond cond, int start, int count);
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<GoodsStock> searchGoodsStockDetail(GoodsStockSearchCond cond, int start, int count);
	
	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public List<GoodsStock> getSearchCount(GoodsStockSearchCond cond);
	
	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public List<GoodsStock> getDetailSearchCount(GoodsStockSearchCond cond);

}
