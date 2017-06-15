/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

 package com.deliverik.infogovernor.kgm.bl.task;

import java.util.List;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.kgm.model.KnowLedgeInfo;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeSearchCond;
import com.deliverik.infogovernor.kgm.model.dao.KnowLedgeInfoDAO;

 /**
  * ����:֪ʶ���ѯ��BLʵ����
  * ����������֪ʶ���ѯ��BLʵ����
  * ������¼��wangxiaoqiang 2010/12/07
  * �޸ļ�¼��
  */
public class KnowLedgeInfoBLImpl extends BaseBLImpl implements KnowLedgeInfoBL {
	
	/** ֪ʶ���ѯ����ϢDAO */
	protected KnowLedgeInfoDAO knowLedgeInfoDAO;

	/**
	 * ֪ʶ���ѯ����ϢDAO
	 * 
	 * @param knowLedgeInfoDAO ֪ʶ���ѯ����ϢDAO
	 */
	public void setKnowLedgeInfoDAO(KnowLedgeInfoDAO knowLedgeInfoDAO) {
		this.knowLedgeInfoDAO = knowLedgeInfoDAO;
	}

	/**
	 * ȫ������
	 * 
	 * @return ���������
	 */
	public List<KnowLedgeInfo> searchAllKnowLedgeInfo() throws BLException {
		return knowLedgeInfoDAO.findAll();
	}

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(KnowledgeSearchCond cond) throws BLException {
		return knowLedgeInfoDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<KnowLedgeInfo> searchKnowLedgeInfoByCond(
			KnowledgeSearchCond cond, int start, int count)
			throws BLException {
		return knowLedgeInfoDAO.findByCond(cond, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<KnowLedgeInfo> searchKnowLedgeInfoOrderByTime(
			KnowledgeSearchCond cond, int start, int count)
			throws BLException {
		return knowLedgeInfoDAO.findByCondTime(cond, start, count);
	}
	
	/**
	 * �����������Ĺ���֪ʶ����
	 * @return �������Ĺ���֪ʶ�����б�
	 */
	public List<KnowLedgeInfo> searchKnowLedgeSummary()throws BLException {
		return knowLedgeInfoDAO.findKgmSummary();
	}
}

