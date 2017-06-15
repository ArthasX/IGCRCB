/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.igflow.resultset.RoleInfo;
import com.deliverik.infogovernor.drm.model.StructureRoleInfo;
import com.deliverik.infogovernor.drm.model.condition.StructureRoleSearchCond;

/**
  * ����: ��֯�ܹ�������DAO�ӿ�
  * ��������: ��֯�ܹ�������DAO�ӿ�
  * ������¼: 2015/03/09
  * �޸ļ�¼: 
  */
public interface StructureRoleDAO extends BaseHibernateDAO<StructureRoleInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<StructureRoleInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public StructureRoleInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final StructureRoleSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<StructureRoleInfo> findByCond(
			final StructureRoleSearchCond cond, final int start,
			final int count);
	/**
     * ��ɫ��ѯ
     * @param cond
     * @return
     */
    public List<RoleInfo> searchRole(final StructureRoleSearchCond cond,final int start,final int count);

    /**
     * ��ɫ��ѯ
     * @param cond
     * @return
     */
    public Integer searchRoleCount(final StructureRoleSearchCond cond);
}