/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.SingleGoodsStock;
import com.csebank.lom.model.condition.SingleGoodsStockSearchCond;
import com.deliverik.framework.base.BaseBL;

/**
 * ��һ��Ʒ���ͳ��ҵ���߼��ӿ�
 */
public interface SingleGoodsStockBL extends BaseBL {
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SingleGoodsStock> searchSingleGoodsStock(SingleGoodsStockSearchCond cond, int start, int count);
	
	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public List<SingleGoodsStock> getSearchCount(SingleGoodsStockSearchCond cond);

}
