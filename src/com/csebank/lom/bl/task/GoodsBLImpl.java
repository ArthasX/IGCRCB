/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.Goods;
import com.csebank.lom.model.condition.GoodsSearchCond;
import com.csebank.lom.model.dao.GoodsDAO;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;

/**
 * ��Ʒ��Ϣҵ���߼��ӿ�ʵ��
 */
public class GoodsBLImpl extends BaseBLImpl implements GoodsBL {
	
	/**  DAO */
	protected GoodsDAO goodsDAO;
	
	

	/**
	 * @param goodsDAO the goodsDAO to set
	 */
	public void setGoodsDAO(GoodsDAO goodsDAO) {
		this.goodsDAO = goodsDAO;
	}

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(GoodsSearchCond cond){
		
		return goodsDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 * 
	 * @param gid ��Ʒ��ϢID
	 * @return ��Ʒ��ϢID
	 */
	public Goods searchGoodsByKey(Integer gid) throws BLException{
		
		return checkExistGoods(gid);
	}
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ����Ʒ��ϢID
	 */
	public List<Goods> searchGoodsAll(){
		
		return goodsDAO.findAll();
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Goods> searchGoods(GoodsSearchCond cond, int start, int count){
		
		return goodsDAO.findByCond(cond,start,count);
	}
	
	public List<Goods> searchGoods(String gcategory){
		
		return goodsDAO.findByCond(gcategory);
	}

	/**
	 * ��¼����
	 * 
	 * @param Goods ��¼����
	 * @return ��Ʒ��Ϣ
	 */
	public Goods registGoods(Goods Goods) throws BLException{
		
		return goodsDAO.save(Goods);
	}

	/**
	 * ɾ������
	 * 
	 * @param gid ��Ʒ��ϢID
	 * @return
	 */
	public void deleteGoods(Integer gid) throws BLException{
		
		Goods Goods = checkExistGoods(gid);
		
		goodsDAO.delete(Goods);
	}

	/**
	 * �������
	 * 
	 * @param Goods �������
	 * @return ��Ʒ��ϢID
	 */
	public Goods updateGoods(Goods Goods) throws BLException{
		
		checkExistGoods(Goods.getGid());
		return goodsDAO.save(Goods);
	}

	/**
	 * ֵ��������Ϣ���ڼ��
	 * 
	 * @param gid ��Ʒ��ϢID
	 * @return ��Ʒ��Ϣ
	 * @throws BLException 
	 */
	protected Goods checkExistGoods(Integer gid) throws BLException{
		Goods info = goodsDAO.findByPK(gid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","��Ʒ��Ϣ����");
		}
		return info;
	}

}
