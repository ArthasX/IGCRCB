/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.drm.model.ScopesInfo;
import com.deliverik.infogovernor.drm.model.condition.ScopesSearchCond;
import com.deliverik.infogovernor.drm.model.entity.ScopesTB;

/**
  * ����: �¼�Ӱ�췶Χҵ���߼��ӿ�
  * ��������: �¼�Ӱ�췶Χҵ���߼��ӿ�
  * ������¼: 2015/03/20
  * �޸ļ�¼: 
  */
public interface ScopesBL extends BaseBL {

	/**
	 * �¼�Ӱ�췶Χʵ��ȡ��
	 *
	 * @return �¼�Ӱ�췶Χʵ��
	 */
	public ScopesTB getScopesTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<ScopesInfo> searchScopes();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public ScopesInfo searchScopesByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(ScopesSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<ScopesInfo> searchScopes(
			ScopesSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<ScopesInfo> searchScopes(
			ScopesSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public ScopesInfo registScopes(ScopesInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public ScopesInfo updateScopes(ScopesInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteScopesByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteScopes(ScopesInfo instance)
		throws BLException;

}