/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.cic.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.cic.model.CompareProcessRoleRelationInfo;
import com.deliverik.infogovernor.cic.model.condition.CompareProcessRoleRelationSearchCond;
import com.deliverik.infogovernor.cic.model.entity.CompareProcessRoleRelationTB;

/**
  * ����: ��ϵ��ҵ���߼��ӿ�
  * ��������: ��ϵ��ҵ���߼��ӿ�
  * ������¼: 2014/04/24
  * �޸ļ�¼: 
  */
public interface CompareProcessRoleRelationBL extends BaseBL {

	/**
	 * ��ϵ��ʵ��ȡ��
	 *
	 * @return ��ϵ��ʵ��
	 */
	public CompareProcessRoleRelationTB getCompareProcessRoleRelationTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CompareProcessRoleRelationInfo> searchCompareProcessRoleRelation();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CompareProcessRoleRelationInfo searchCompareProcessRoleRelationByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(CompareProcessRoleRelationSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CompareProcessRoleRelationInfo> searchCompareProcessRoleRelation(
			CompareProcessRoleRelationSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CompareProcessRoleRelationInfo> searchCompareProcessRoleRelation(
			CompareProcessRoleRelationSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public CompareProcessRoleRelationInfo registCompareProcessRoleRelation(CompareProcessRoleRelationInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public CompareProcessRoleRelationInfo updateCompareProcessRoleRelation(CompareProcessRoleRelationInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteCompareProcessRoleRelationByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteCompareProcessRoleRelation(CompareProcessRoleRelationInfo instance)
		throws BLException;

}