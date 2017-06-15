/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.scheduling.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessInfoEntity;
import com.deliverik.infogovernor.scheduling.model.condition.QuartzProcessInfoEntitySearchCond;

/**
 * �������ʲ���ϵҵ���߼�
 * 
 */

public interface QuartzProcessInfoEntityBL extends BaseBL {
	
	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	
	public int getQuartzProcessInfoEntitySearchCount(QuartzProcessInfoEntitySearchCond cond);

	/**
	 * ������������
	 * 
	 * @param pieid ����״̬����ǰ����ID
	 * @return ����״̬����ǰ������Ϣ
	 */
	
	public QuartzProcessInfoEntity searchQuartzProcessInfoEntityByKey(Integer pieid) throws BLException;

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return ��������б�
	 */
	
	public List<QuartzProcessInfoEntity> searchQuartzProcessInfoEntity(QuartzProcessInfoEntitySearchCond cond);

	/**
	 * ��������
	 * 
	 * @param QuartzProcessInfoEntity ��������
	 * @return �ʲ���Ϣ
	 */
	
	public QuartzProcessInfoEntity registQuartzProcessInfoEntity(
			QuartzProcessInfoEntity processInfoEntity) throws BLException;

	/**
	 * ɾ������
	 * 
	 * @param pieid ɾ������״̬����ǰ��������
	 * @return
	 */
	
	public void deleteQuartzProcessInfoEntity(Integer pieid) throws BLException;

	/**
	 * �������
	 * 
	 * @param processInfoEntity �������
	 * @return ����״̬����ǰ����
	 */
	
	public QuartzProcessInfoEntity updateQuartzProcessInfoEntity(
			QuartzProcessInfoEntity processInfoEntity) throws BLException;
	
	
	/**
	 * ������������
	 * 
	 * @param prid ��������
	 * @return ��������б�
	 */
	
	public List<QuartzProcessInfoEntity> searchQuartzProcessInfoEntityByPrid(Integer prid);

}
