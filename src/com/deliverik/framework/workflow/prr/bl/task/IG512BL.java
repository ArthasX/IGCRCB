/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.IG512Info;
import com.deliverik.framework.workflow.prr.model.condition.IG512SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG512TB;

/**
 * ���̹�ϵҵ���߼��ӿ�
 * 
 */
public interface IG512BL extends BaseBL{
	
	/**
	 * ��ȡ���̹�ϵʵ��
	 * @return IG512TB
	 */
	public IG512TB getIG512TBInstance();
	
	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(IG512SearchCond cond);

	/**
	 * ������������
	 * 
	 * @param pprid ���̹�ϵID
	 * @return ���̹�ϵ
	 */
	public IG512Info searchIG512InfoByKey(Integer pprid) throws BLException;
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ�����̹�ϵ��Ϣ
	 */
	public List<IG512Info> searchIG512InfoAll();

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG512Info> searchIG512Info(IG512SearchCond cond, int start, int count);

	/**
	 * ��¼����
	 * 
	 * @param ig512Info ��¼����
	 * @return ���̹�ϵ
	 */
	public IG512Info registIG512Info(IG512Info ig512Info) throws BLException;

	/**
	 * ɾ������
	 * 
	 * @param pprid ���̹�ϵID
	 * @return
	 */
	public void deleteIG512Info(Integer pprid) throws BLException;

	/**
	 * �������
	 * 
	 * @param ig512Info �������
	 * @return ���̹�ϵ
	 */
	public IG512Info updateIG512Info(IG512Info ig512Info) throws BLException;
	
	/**
	 * ���̹�ϵ������ʱ����������
	 * 
	 * @param ig512InfoList ���̹�ϵ�б�
	 * 
	 */
	public void orderByTimeAsc(List<IG512Info> ig512InfoList);
	
}
