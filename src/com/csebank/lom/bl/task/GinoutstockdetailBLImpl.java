/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.Ginoutstockdetail;
import com.csebank.lom.model.GoutDetailInfo;
import com.csebank.lom.model.condition.GinoutstockdetailSearchCond;
import com.csebank.lom.model.condition.GoutDetailSearchCond;
import com.csebank.lom.model.dao.GinoutStockDetailVWDAO;
import com.csebank.lom.model.dao.GinoutstockdetailDAO;
import com.csebank.lom.model.dao.GoutDetailInfoDAO;
import com.csebank.lom.model.entity.GinoutStockDetailVW;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;

/**
 * ��Ʒ��Ϣҵ���߼��ӿ�ʵ��
 */
public class GinoutstockdetailBLImpl extends BaseBLImpl implements GinoutstockdetailBL {
	
	/**  DAO */
	protected GinoutstockdetailDAO ginoutstockdetailDAO;
	
	protected GinoutStockDetailVWDAO ginoutStockDetailVWDAO;
	//ʳ����Ʒ������ϸ
	protected GoutDetailInfoDAO goutDetailInfoDAO;

	/**
	 * @param ginoutstockdetailDAO the ginoutstockdetailDAO to set
	 */
	public void setGinoutstockdetailDAO(GinoutstockdetailDAO ginoutstockdetailDAO) {
		this.ginoutstockdetailDAO = ginoutstockdetailDAO;
	}
	
	public void setGinoutStockDetailVWDAO(GinoutStockDetailVWDAO ginoutStockDetailVWDAO) {
		this.ginoutStockDetailVWDAO = ginoutStockDetailVWDAO;
	}

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(GinoutstockdetailSearchCond cond){
		
		return ginoutstockdetailDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 * 
	 * @param giodid ��Ʒ�������ϸ��ϢID
	 * @return ��Ʒ�������ϸ��ϢID
	 */
	public Ginoutstockdetail searchGinoutstockdetailByKey(Integer giodid) throws BLException{
		
		return checkExistGinoutstockdetail(giodid);
	}
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ����Ʒ�������ϸ��Ϣ
	 */
	public List<Ginoutstockdetail> searchGinoutstockdetailAll(){
		
		return ginoutstockdetailDAO.findAll();
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Ginoutstockdetail> searchGinoutstockdetail(GinoutstockdetailSearchCond cond, int start, int count){
		
		return ginoutstockdetailDAO.findByCond(cond,start,count);
	}
	
	public List<GinoutStockDetailVW> searchGinoutstockdetail(GinoutstockdetailSearchCond cond, int start, int count, String temp){
		
		return ginoutStockDetailVWDAO.findByCond(cond,start,count);
	}

	/**
	 * ��¼����
	 * 
	 * @param Ginoutstockdetail ��¼����
	 * @return ��Ʒ�������ϸ��Ϣ
	 */
	public Ginoutstockdetail registGinoutstockdetail(Ginoutstockdetail Ginoutstockdetail) throws BLException{
		
		return ginoutstockdetailDAO.save(Ginoutstockdetail);
	}

	/**
	 * ɾ������
	 * 
	 * @param giodid ��Ʒ�������ϸ��ϢID
	 * @return
	 */
	public void deleteGinoutstockdetail(Integer giodid) throws BLException{
		
		Ginoutstockdetail Ginoutstockdetail = checkExistGinoutstockdetail(giodid);
		
		ginoutstockdetailDAO.delete(Ginoutstockdetail);
	}

	/**
	 * �������
	 * 
	 * @param Ginoutstockdetail �������
	 * @return ��Ʒ�������ϸ��Ϣ
	 */
	public Ginoutstockdetail updateGinoutstockdetail(Ginoutstockdetail Ginoutstockdetail) throws BLException{
		
		checkExistGinoutstockdetail(Ginoutstockdetail.getGiodid());
		return ginoutstockdetailDAO.save(Ginoutstockdetail);
	}

	/**
	 * ��Ʒ�������ϸ��Ϣ���ڼ��
	 * 
	 * @param rid ֵ������ID
	 * @return ֵ��������Ϣ
	 * @throws BLException 
	 */
	protected Ginoutstockdetail checkExistGinoutstockdetail(Integer giodid) throws BLException{
		Ginoutstockdetail info = ginoutstockdetailDAO.findByPK(giodid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","��Ʒ�������ϸ��Ϣ����");
		}
		return info;
	}
	public List<GoutDetailInfo> getGoutDetailInfo(GoutDetailSearchCond cond,
			int start, int count) {
		
		return goutDetailInfoDAO.findByCond(cond, start, count);
	}

	public GoutDetailInfoDAO getGoutDetailInfoDAO() {
		return goutDetailInfoDAO;
	}

	public void setGoutDetailInfoDAO(GoutDetailInfoDAO goutDetailInfoDAO) {
		this.goutDetailInfoDAO = goutDetailInfoDAO;
	}

}
