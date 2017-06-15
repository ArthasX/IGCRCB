/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.GoodsStock;
import com.csebank.lom.model.condition.GoodsStockSearchCond;
import com.csebank.lom.model.dao.GoodsStockDAO;
import com.deliverik.framework.base.BaseBLImpl;

/**
 * ʳ�óɱ���Ϣҵ���߼��ӿ�ʵ��
 */
public class GoodsStockBLImpl extends BaseBLImpl implements GoodsStockBL {
	
	/** WorkLunchEatery DAO */
	protected GoodsStockDAO goodsStockDAO;
	
	public void setGoodsStockDAO(
			GoodsStockDAO goodsStockDAO) {
		this.goodsStockDAO = goodsStockDAO;
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<GoodsStock> searchGoodsStock(GoodsStockSearchCond cond, int start, int count){
		
		return goodsStockDAO.findByCond(cond,start,count);
	}
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<GoodsStock> getSearchCount(GoodsStockSearchCond cond){
		
		return goodsStockDAO.getSearchCount(cond);
	}
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<GoodsStock> searchGoodsStockDetail(GoodsStockSearchCond cond, int start, int count){
		
		return goodsStockDAO.findByCond(cond,start,count);
	}
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<GoodsStock> getDetailSearchCount(GoodsStockSearchCond cond){
		
		return goodsStockDAO.getSearchCount(cond);
	}

}
