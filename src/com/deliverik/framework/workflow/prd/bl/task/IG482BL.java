/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG482Info;
import com.deliverik.framework.workflow.prd.model.condition.IG482SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG482TB;

/**
  * ����: �����������ϵ�����ҵ���߼��ӿ�
  * ��������: �����������ϵ�����ҵ���߼��ӿ�
  * ������¼: 2015/02/03
  * �޸ļ�¼: 
  */
public interface IG482BL extends BaseBL {

	/**
	 * �����������ϵ�����ʵ��ȡ��
	 *
	 * @return �����������ϵ�����ʵ��
	 */
	public IG482TB getIG482TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG482Info> searchIG482();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG482Info searchIG482ByPK(String pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG482SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG482Info> searchIG482(
			IG482SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG482Info> searchIG482(
			IG482SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG482Info registIG482(IG482Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG482Info updateIG482(IG482Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG482ByPK(String pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG482(IG482Info instance)
		throws BLException;

}