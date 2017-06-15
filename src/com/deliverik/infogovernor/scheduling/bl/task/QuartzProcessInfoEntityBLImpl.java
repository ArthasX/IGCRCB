/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.scheduling.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessInfoEntity;
import com.deliverik.infogovernor.scheduling.model.condition.QuartzProcessInfoEntitySearchCond;
import com.deliverik.infogovernor.scheduling.model.condition.QuartzProcessInfoEntitySearchCondImpl;
import com.deliverik.infogovernor.scheduling.model.dao.QuartzProcessInfoEntityDAO;

/**
 * 
 * �������ʲ���ϵҵ���߼�ʵ��
 * 
 */
public class QuartzProcessInfoEntityBLImpl extends BaseBLImpl implements QuartzProcessInfoEntityBL {
	
	/** ����״̬ԾǨ����DAO���� */
	protected QuartzProcessInfoEntityDAO quartzProcessInfoEntityDAO;

	public void setQuartzProcessInfoEntityDAO(
			QuartzProcessInfoEntityDAO quartzProcessInfoEntityDAO) {
		this.quartzProcessInfoEntityDAO = quartzProcessInfoEntityDAO;
	}

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	
	public int getQuartzProcessInfoEntitySearchCount(QuartzProcessInfoEntitySearchCond cond) {
		return quartzProcessInfoEntityDAO.getSearchCount(cond);
	}
	
	

	/**
	 * ������������
	 * 
	 * @param pieid ����״̬ԾǨ����ID
	 * @return ����״̬ԾǨ������Ϣ
	 * @throws BLException 
	 */
	
	public QuartzProcessInfoEntity searchQuartzProcessInfoEntityByKey(Integer qpieid) throws BLException {
		return quartzProcessInfoEntityDAO.findByPK(qpieid);
	}
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return ��������б�
	 */
	
	public List<QuartzProcessInfoEntity> searchQuartzProcessInfoEntity(
			QuartzProcessInfoEntitySearchCond cond) {
		return quartzProcessInfoEntityDAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * ȫ����������
	 * 
	 * @return ��������б�
	 */
	
	public List<QuartzProcessInfoEntity> searchQuartzProcessInfoEntityAll() {
		return quartzProcessInfoEntityDAO.findAll();
	}

	/**
	 * ��������
	 * 
	 * @param QuartzProcessInfoEntity ��������
	 * @return �ʲ���Ϣ
	 */
	
	public QuartzProcessInfoEntity registQuartzProcessInfoEntity(
			QuartzProcessInfoEntity quartzProcessInfoEntity) throws BLException {
		return quartzProcessInfoEntityDAO.save(quartzProcessInfoEntity);
	}

	/**
	 * ɾ������
	 * 
	 * @param pieid ɾ������״̬ԾǨ��������
	 * @return
	 */
	
	public void deleteQuartzProcessInfoEntity(Integer qpieid) throws BLException {
		QuartzProcessInfoEntity quartzProcessInfoEntity = quartzProcessInfoEntityDAO.findByPK(qpieid);
		quartzProcessInfoEntityDAO.delete(quartzProcessInfoEntity);
	}

	/**
	 * �������
	 * 
	 * @param quartzProcessInfoEntity �������
	 * @return ����״̬ԾǨ����
	 */
	
	public QuartzProcessInfoEntity updateQuartzProcessInfoEntity(
			QuartzProcessInfoEntity quartzProcessInfoEntity) throws BLException {
		return quartzProcessInfoEntityDAO.save(quartzProcessInfoEntity);
	}
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return ��������б�
	 */
	
	public List<QuartzProcessInfoEntity> searchQuartzProcessInfoEntityByPrid(Integer qprid) {
		QuartzProcessInfoEntitySearchCondImpl cond = new QuartzProcessInfoEntitySearchCondImpl();
		cond.setQprid(qprid);
		return quartzProcessInfoEntityDAO.findByCond(cond, 0, 0);
	}



}
