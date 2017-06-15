/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.drm.model.ErRelationInfo;
import com.deliverik.infogovernor.drm.model.condition.ErRelationSearchCond;
import com.deliverik.infogovernor.drm.model.entity.ErRelationTB;

/**
  * ����: ErRelationҵ���߼��ӿ�
  * ��������: ErRelationҵ���߼��ӿ�
  * ������¼: 2016/06/14
  * �޸ļ�¼: 
  */
public interface ErRelationBL extends BaseBL {

	/**
	 * ErRelationʵ��ȡ��
	 *
	 * @return ErRelationʵ��
	 */
	public ErRelationTB getErRelationTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<ErRelationInfo> searchErRelation();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public ErRelationInfo searchErRelationByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(ErRelationSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<ErRelationInfo> searchErRelation(
			ErRelationSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<ErRelationInfo> searchErRelation(
			ErRelationSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public ErRelationInfo registErRelation(ErRelationInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public ErRelationInfo updateErRelation(ErRelationInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteErRelationByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteErRelation(ErRelationInfo instance)
		throws BLException;

}