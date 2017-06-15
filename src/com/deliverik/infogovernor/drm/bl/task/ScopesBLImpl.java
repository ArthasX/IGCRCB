/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.drm.model.ScopesInfo;
import com.deliverik.infogovernor.drm.model.condition.ScopesSearchCond;
import com.deliverik.infogovernor.drm.model.dao.ScopesDAO;
import com.deliverik.infogovernor.drm.model.entity.ScopesTB;

/**
  * ����: �¼�Ӱ�췶Χҵ���߼�ʵ��
  * ��������: �¼�Ӱ�췶Χҵ���߼�ʵ��
  * ������¼: 2015/03/20
  * �޸ļ�¼: 
  */
public class ScopesBLImpl extends BaseBLImpl implements
		ScopesBL {

	/** �¼�Ӱ�췶ΧDAO�ӿ� */
	protected ScopesDAO scopesDAO;
	
	/**
	 * �¼�Ӱ�췶ΧDAO�ӿ��趨
	 *
	 * @param scopesDAO �¼�Ӱ�췶ΧDAO�ӿ�
	 */
	public void setScopesDAO(ScopesDAO scopesDAO) {
		this.scopesDAO = scopesDAO;
	}

	/**
	 * �¼�Ӱ�췶Χʵ��ȡ��
	 *
	 * @return �¼�Ӱ�췶Χʵ��
	 */
	public ScopesTB getScopesTBInstance() {
		return new ScopesTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<ScopesInfo> searchScopes() {
		return scopesDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public ScopesInfo searchScopesByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(ScopesSearchCond cond) {
		return scopesDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<ScopesInfo> searchScopes(
			ScopesSearchCond cond) {
		return scopesDAO.findByCond(cond, 0, 0);
	}

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
			int count) {
		return scopesDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public ScopesInfo registScopes(ScopesInfo instance)
		throws BLException {
		return scopesDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public ScopesInfo updateScopes(ScopesInfo instance)
		throws BLException {
		checkExistInstance(instance.getScopeid());
		return scopesDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteScopesByPK(Integer pk)
		throws BLException {
		scopesDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteScopes(ScopesInfo instance)
		throws BLException {
		scopesDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public ScopesInfo checkExistInstance(Integer pk)
		throws BLException {
		ScopesInfo instance = scopesDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}