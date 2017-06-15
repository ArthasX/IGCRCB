/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.mtp.bl.task;

import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.mtp.model.QuartzJobDetails;
import com.deliverik.infogovernor.mtp.model.condition.QuartzJobDetailsSearchCond;
import com.deliverik.infogovernor.mtp.model.condition.QuartzJobDetailsSearchCondImpl;
import com.deliverik.infogovernor.mtp.model.dao.QuartzJobDetailsTBDAO;
import com.deliverik.infogovernor.mtp.model.entity.QuartzJobDetailsTB;

/**
 * <p>
 * �ճ���ά�ƻ���Ϣҵ���߼�ʵ��
 * </p>
 */
public class QuartzJobDetailsBLImpl extends BaseBLImpl implements QuartzJobDetailsBL {

	protected QuartzJobDetailsTBDAO quartzJobDetailsTBDAO;

	
	public void setQuartzJobDetailsTBDAO(QuartzJobDetailsTBDAO quartzJobDetailsTBDAO) {
		this.quartzJobDetailsTBDAO = quartzJobDetailsTBDAO;
	}

	/**
	 * �����ճ���ά�ƻ���Ϣ
	 * @param qjdList
	 * @return
	 * @throws BLException
	 */
	public List<QuartzJobDetails> saveOrUpdQuartzJobDetails(List<QuartzJobDetails> qjdList)
			throws BLException {
		List<QuartzJobDetails> newList = new ArrayList<QuartzJobDetails>();
		for(QuartzJobDetails qjd:qjdList){
			QuartzJobDetails QuartzJobDetails = quartzJobDetailsTBDAO.save(qjd);
			
			newList.add(QuartzJobDetails);
		}
		
		return newList;
	}

	/**
	 * �����ճ���ά�ƻ���Ϣ
	 * @param qjdInfo
	 * @return
	 * @throws BLException
	 */
	public QuartzJobDetails saveQuartzJobDetails(QuartzJobDetails qjdInfo)throws BLException {
		return quartzJobDetailsTBDAO.save(qjdInfo);
	}


	/**
	 * �����ճ���ά�ƻ���Ϣ
	 * @param quartzJobDetailsList
	 * @throws BLException
	 */
	public void registQuartzJobDetails(List<QuartzJobDetails> quartzJobDetailsList) throws BLException{
		quartzJobDetailsTBDAO.saveOrUpdateAll(quartzJobDetailsList);
	}
	

	/**
	 * �����ճ���ά�ƻ���Ϣ
	 * @param qjd
	 * @throws BLException
	 */
	public QuartzJobDetails updateQuartzJobDetails(QuartzJobDetails qjd) throws BLException{
		return quartzJobDetailsTBDAO.save(qjd);
	}
	

	/**
	 * �����ճ���ά�ƻ���Ϣ
	 * @param quartzJobDetailsList
	 * @throws BLException
	 */
	public void updateQuartzJobDetails(List<QuartzJobDetails> quartzJobDetailsList) throws BLException{
		quartzJobDetailsTBDAO.saveOrUpdateAll(quartzJobDetailsList);
	}
	

	/**
	 * �����ճ���ά�ƻ�����ID��ѯ�ճ���ά�ƻ���ϸ��Ϣ
	 * @param qjid
	 * @return
	 */
	public List<QuartzJobDetails> searchQuartzJobDetailsByKey(Integer qjid){
		QuartzJobDetailsSearchCondImpl cond = new QuartzJobDetailsSearchCondImpl();
		cond.setQjid(qjid);
		List<QuartzJobDetails> qjdInfoList = quartzJobDetailsTBDAO.findByCond(cond, 0, 0);
		return qjdInfoList;
	}
	

	/**
	 * ���ݼ���������ѯ�ճ���ά�ƻ���ϸ��Ϣ
	 * @param cond
	 * @return
	 */
	public List<QuartzJobDetails> searchQuartzJobDetailsByCond(QuartzJobDetailsSearchCond cond,final int start, final int count){
		List<QuartzJobDetails> qjdInfoList = quartzJobDetailsTBDAO.findByCond(cond, start, count);
		return qjdInfoList;
	}
	
	/**
	 * ���ݼ�������ȡ�ý������
	 * @param cond
	 * @return
	 */
	public int getSearchCount(QuartzJobDetailsSearchCond cond){
		return quartzJobDetailsTBDAO.getSearchCount(cond);
	}
	

	/**
	 * ��������ID��ѯ�ճ���ά�ƻ���ϸ��Ϣ
	 * @param piid
	 * @return
	 * @throws BLException
	 */
	public QuartzJobDetails searchQuartzJobDetailsByQjdid(Integer qjdid) throws BLException{
		return checkExistQuartzJobDetails(qjdid);
	}
	
	/**
	 * ��ȡʵ��
	 * 
	 * @return QuartzJobDetailsTB
	 * @throws BLException
	 */
	
	public QuartzJobDetailsTB getQuartzJobDetailsTBInstance(){
		return new QuartzJobDetailsTB();
	}
	
	/**
	 * ��������ɾ����ά�ƻ���ϸ��Ϣ
	 * @param qjdid
	 * @throws BLException
	 */
	public void deleteQuartzJobDetails(Integer qjdid) throws BLException {
		QuartzJobDetails quartzJobDetails = checkExistQuartzJobDetails(qjdid);
		quartzJobDetailsTBDAO.delete(quartzJobDetails);
		
	}
	
	
	
	/**
	 * ʵ����ڼ��
	 * 
	 * @param piid ���̱���ID
	 * @return ���̱�������ֵ��Ϣ
	 * @throws BLException 
	 */
	private QuartzJobDetails checkExistQuartzJobDetails(Integer qjdid) throws BLException{
		QuartzJobDetails info = quartzJobDetailsTBDAO.findByPK(qjdid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","�ճ���ά�ƻ�");
		}
		
		return info;
	}
}
