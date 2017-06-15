/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG480Info;
import com.deliverik.framework.workflow.prd.model.IG481Info;
import com.deliverik.framework.workflow.prd.model.condition.IG481SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG481PK;
import com.deliverik.framework.workflow.prd.model.entity.IG481TB;

/**
  * ����: �������Ա��ҵ���߼��ӿ�
  * ��������: �������Ա��ҵ���߼��ӿ�
  * ������¼: 2015/02/03
  * �޸ļ�¼: 
  */
public interface IG481BL extends BaseBL {

	/**
	 * �������Ա��ʵ��ȡ��
	 *
	 * @return �������Ա��ʵ��
	 */
	public IG481TB getIG481TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG481Info> searchIG481();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG481Info searchIG481ByPK(IG481PK pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG481SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG481Info> searchIG481(
			IG481SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG481Info> searchIG481(
			IG481SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG481Info registIG481(IG481Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG481Info updateIG481(IG481Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG481ByPK(IG481PK pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG481(IG481Info instance)
		throws BLException;
	
	/**
	 * ��������ɾ��
	 * @param cond
	 */
	public void deleteByCond(IG481SearchCond cond)throws BLException;
	
	/**
	 * �������̶���ID��ѯ�鶨���б�
	 * @param pdid ���̶���ID
	 * @return �鶨���б�
	 */
	public List<IG480Info> searchIG480(String pdid);

}