/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.Goutstock;
import com.csebank.lom.model.condition.GoutstockSearchCond;
import com.csebank.lom.model.dao.GoutstockDAO;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;

/**
 * ��Ʒ������Ϣҵ���߼��ӿ�ʵ��
 */
public class GoutstockBLImpl extends BaseBLImpl implements GoutstockBL {
	
	/**  DAO */
	protected GoutstockDAO goutstockDAO;

	/**
	 * @param goutstockDAO the goutstockDAO to set
	 */
	public void setGoutstockDAO(GoutstockDAO goutstockDAO) {
		this.goutstockDAO = goutstockDAO;
	}

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(GoutstockSearchCond cond){
		
		return goutstockDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 * 
	 * @param goid ��Ʒ������ϢID
	 * @return ��Ʒ������ϢID
	 */
	public Goutstock searchGoutstockByKey(Integer goid) throws BLException{
		
		return checkExistGoutstock(goid);
	}
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ����Ʒ�������ϸ��Ϣ
	 */
	public List<Goutstock> searchGoodsAll(){
		
		return goutstockDAO.findAll();
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Goutstock> searchGoutstock(GoutstockSearchCond cond, int start, int count){
		
		return goutstockDAO.findByCond(cond,start,count);
	}

	/**
	 * ��¼����
	 * 
	 * @param Goutstock ��¼����
	 * @return ��Ʒ������Ϣ
	 */
	public Goutstock registGoutstock(Goutstock Goutstock) throws BLException{
		
		return goutstockDAO.save(Goutstock);
	}

	/**
	 * ɾ������
	 * 
	 * @param goid ��Ʒ������ϢID
	 * @return
	 */
	public void deleteGoutstock(Integer giodid) throws BLException{
		
		Goutstock Goutstock = checkExistGoutstock(giodid);
		
		goutstockDAO.delete(Goutstock);
	}

	/**
	 * �������
	 * 
	 * @param Goutstock �������
	 * @return ��Ʒ������Ϣ
	 */
	public Goutstock updateGoods(Goutstock Goutstock) throws BLException{
		
		checkExistGoutstock(Goutstock.getGoid());
		return goutstockDAO.save(Goutstock);
	}

	/**
	 * ��Ʒ������Ϣ���ڼ��
	 * 
	 * @param goid ��Ʒ������ϢID
	 * @return ��Ʒ������Ϣ
	 * @throws BLException 
	 */
	protected Goutstock checkExistGoutstock(Integer goid) throws BLException{
		Goutstock info = goutstockDAO.findByPK(goid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","��Ʒ������Ϣ����");
		}
		return info;
	}

}
