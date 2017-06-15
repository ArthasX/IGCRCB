/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG731Info;
import com.deliverik.framework.workflow.prd.model.condition.IG731SearchCond;

/**
 * �������ʲ���ϵҵ���߼�
 * 
 */

public interface IG731BL extends BaseBL {
	
	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	
	public int getIG731InfoSearchCount(IG731SearchCond cond);

	/**
	 * ������������
	 * 
	 * @param pieid ����״̬����ǰ����ID
	 * @return ����״̬����ǰ������Ϣ
	 */
	
	public IG731Info searchIG731InfoByKey(Integer pieid) throws BLException;

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return ��������б�
	 */
	
	public List<IG731Info> searchIG731Info(IG731SearchCond cond);

	/**
	 * ��������
	 * 
	 * @param IG731Info ��������
	 * @return �ʲ���Ϣ
	 */
	
	public IG731Info registIG731Info(
			IG731Info processInfoEntity) throws BLException;

	/**
	 * ɾ������
	 * 
	 * @param pieid ɾ������״̬����ǰ��������
	 * @return
	 */
	
	public void deleteIG731Info(Integer pieid) throws BLException;

	/**
	 * �������
	 * 
	 * @param ig731Info �������
	 * @return ����״̬����ǰ����
	 */
	
	public IG731Info updateIG731Info(
			IG731Info ig731Info) throws BLException;
	
	
	/**
	 * ������������
	 * 
	 * @param prid ��������
	 * @return ��������б�
	 */
	
	public List<IG731Info> searchIG731InfoByPrid(Integer prid);
	
	/**
	 * ͨ������prid��ѯ��ص�ҵ��ϵͳ�ʲ�
	 * @param prid
	 * @return ��������б�
	 */
	public List<IG731Info> searchIG731InfoBySePrid(Integer prid,String flowType);

	/**
	 * ��������prid��ѯ������eiid
	 * @param prid ����id
	 * @param flowType ��������
	 * @return
	 */
	public List<IG731Info> searchSenceBySePrid( Integer prid, String flowType);
}
