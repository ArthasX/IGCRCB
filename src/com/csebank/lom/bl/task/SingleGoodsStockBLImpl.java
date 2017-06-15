/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.SingleGoodsStock;
import com.csebank.lom.model.condition.SingleGoodsStockSearchCond;
import com.csebank.lom.model.dao.SingleGoodsStockDAO;
import com.deliverik.framework.base.BaseBLImpl;

/**
 * ʳ�óɱ���Ϣҵ���߼��ӿ�ʵ��
 */
public class SingleGoodsStockBLImpl extends BaseBLImpl implements SingleGoodsStockBL {
	
	protected SingleGoodsStockDAO singleGoodsStockDAO;
	
	public void setSingleGoodsStockDAO(
			SingleGoodsStockDAO singleGoodsStockDAO) {
		this.singleGoodsStockDAO = singleGoodsStockDAO;
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SingleGoodsStock> searchSingleGoodsStock(SingleGoodsStockSearchCond cond, int start, int count){
		
		return singleGoodsStockDAO.findByCond(cond,start,count);
	}
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SingleGoodsStock> getSearchCount(SingleGoodsStockSearchCond cond){
		
		return singleGoodsStockDAO.getSearchCount(cond);
	}

}
