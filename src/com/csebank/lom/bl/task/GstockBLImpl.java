/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.Gstock;
import com.csebank.lom.model.condition.GstockSearchCond;
import com.csebank.lom.model.dao.GstockDAO;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;

/**
 * ��Ʒ��Ϣҵ���߼��ӿ�ʵ��
 */
public class GstockBLImpl extends BaseBLImpl implements GstockBL {

	/** DAO */
	protected GstockDAO gstockDAO;
	

	public void setGstockDAO(GstockDAO gstockDAO) {
		this.gstockDAO = gstockDAO;
	}

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(GstockSearchCond cond){
		
		return gstockDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 * 
	 * @param gid ��Ʒ��ϢID
	 * @return ��Ʒ��ϢID
	 */
	public Gstock searchGstockByKey(Integer gsid) throws BLException{
		
		return checkExistGstock(gsid);
	}
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ����Ʒ��ϢID
	 */
	public List<Gstock> searchGstockAll(){
		
		return gstockDAO.findAll();
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Gstock> searchGstock(GstockSearchCond cond, int start, int count){
		
		return gstockDAO.findByCond(cond,start,count);
	}

	/**
	 * ��¼����
	 * 
	 * @param Gstock ��¼����
	 * @return ��Ʒ��Ϣ
	 */
	public Gstock registGstock(Gstock Gstock) throws BLException{
		
		return gstockDAO.save(Gstock);
	}

	/**
	 * ɾ������
	 * 
	 * @param gid ��Ʒ��ϢID
	 * @return
	 */
	public void deleteGstock(Integer gid) throws BLException{
		
		Gstock Gstock = checkExistGstock(gid);
		
		gstockDAO.delete(Gstock);
	}

	/**
	 * �������
	 * 
	 * @param Gstock �������
	 * @return ��Ʒ��ϢID
	 */
	public Gstock updateGstock(Gstock Gstock) throws BLException{
		
		checkExistGstock(Gstock.getGsid());
		return gstockDAO.save(Gstock);
	}

	/**
	 * ֵ��������Ϣ���ڼ��
	 * 
	 * @param gid ��Ʒ��ϢID
	 * @return ��Ʒ��Ϣ
	 * @throws BLException 
	 */
	protected Gstock checkExistGstock(Integer gsid) throws BLException{
		Gstock info = gstockDAO.findByPK(gsid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","��Ʒ����");
		}
		return info;
	}

}
