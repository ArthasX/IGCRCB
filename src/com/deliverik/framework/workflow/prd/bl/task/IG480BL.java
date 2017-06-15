/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG480Info;
import com.deliverik.framework.workflow.prd.model.condition.IG480SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG480TB;

/**
  * ����: �����鶨���ҵ���߼��ӿ�
  * ��������: �����鶨���ҵ���߼��ӿ�
  * ������¼: 2015/02/03
  * �޸ļ�¼: 
  */
public interface IG480BL extends BaseBL {

	/**
	 * �����鶨���ʵ��ȡ��
	 *
	 * @return �����鶨���ʵ��
	 */
	public IG480TB getIG480TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG480Info> searchIG480();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG480Info searchIG480ByPK(String pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG480SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG480Info> searchIG480(
			IG480SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG480Info> searchIG480(
			IG480SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG480Info registIG480(IG480Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG480Info updateIG480(IG480Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG480ByPK(String pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG480(IG480Info instance)
		throws BLException;

	/**
	 * �����鶨�����洦��
	 * 
	 * @param pdid ���̶���ID
	 */
	public void upgradeGroupProcessDefVersion(String pgdid) throws BLException;
	/**
	 * �����鶨������ֵȡ��
	 * @param firstsite ������λ��ʶ
	 * @param pdsequence ��������
	 * @return PDID����ֵ
	 */
	public String getPdidNextValue(String firstsite,String pdsequence);
	/**
	 * �����鶨�帴�ƴ���
	 * 
	 * @param pgdid �����鶨��ID
	 * @param pdsequence ���ж���
	 */
	public String copyGroupProcessDefVersion(String pgdid,String pdsequence) throws BLException;
}