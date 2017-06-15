/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.mtp.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.mtp.model.QuartzJobDetails;
import com.deliverik.infogovernor.mtp.model.condition.QuartzJobDetailsSearchCond;
import com.deliverik.infogovernor.mtp.model.entity.QuartzJobDetailsTB;

/**
 * <p>
 * ���̱�����Ϣҵ���߼�
 * </p>
 */

public interface QuartzJobDetailsBL extends BaseBL {


	/**
	 * �����ճ���ά�ƻ���Ϣ
	 * @param qjdList
	 * @return
	 * @throws BLException
	 */
	public List<QuartzJobDetails> saveOrUpdQuartzJobDetails(List<QuartzJobDetails> qjdList) throws BLException;

	/**
	 * �����ճ���ά�ƻ���Ϣ
	 * @param qjdInfo
	 * @return
	 * @throws BLException
	 */
	public QuartzJobDetails saveQuartzJobDetails(QuartzJobDetails qjdInfo) throws BLException;
	

	/**
	 * �����ճ���ά�ƻ���Ϣ
	 * @param quartzJobDetailsList
	 * @throws BLException
	 */
	public void registQuartzJobDetails(List<QuartzJobDetails> quartzJobDetailsList) throws BLException;
	

	/**
	 * �����ճ���ά�ƻ���Ϣ
	 * @param qjd
	 * @throws BLException
	 */
	public QuartzJobDetails updateQuartzJobDetails(QuartzJobDetails qjd) throws BLException;
	

	/**
	 * �����ճ���ά�ƻ���Ϣ
	 * @param quartzJobDetailsList
	 * @throws BLException
	 */
	public void updateQuartzJobDetails(List<QuartzJobDetails> quartzJobDetailsList) throws BLException;
	

	/**
	 * �����ճ���ά�ƻ�����ID��ѯ�ճ���ά�ƻ���ϸ��Ϣ
	 * @param qjid
	 * @return
	 */
	public List<QuartzJobDetails> searchQuartzJobDetailsByKey(Integer qjid);
	

	/**
	 * ���ݼ���������ѯ�ճ���ά�ƻ���ϸ��Ϣ
	 * @param cond
	 * @return
	 */
	public List<QuartzJobDetails> searchQuartzJobDetailsByCond(QuartzJobDetailsSearchCond cond,final int start, final int count);
	
	/**
	 * ���ݼ�������ȡ�ý������
	 * @param cond
	 * @return
	 */
	public int getSearchCount(QuartzJobDetailsSearchCond cond);

	/**
	 * ��������ID��ѯ�ճ���ά�ƻ���ϸ��Ϣ
	 * @param piid
	 * @return
	 * @throws BLException
	 */
	public QuartzJobDetails searchQuartzJobDetailsByQjdid(Integer qjdid) throws BLException;
	
	/**
	 * ��ȡʵ��
	 * 
	 * @return QuartzJobDetailsTB
	 * @throws BLException
	 */
	
	public QuartzJobDetailsTB getQuartzJobDetailsTBInstance();
	
	/**
	 * ��������ɾ����ά�ƻ���ϸ��Ϣ
	 * @param qjdid
	 * @throws BLException
	 */
	public void deleteQuartzJobDetails(Integer qjdid) throws BLException;
}
