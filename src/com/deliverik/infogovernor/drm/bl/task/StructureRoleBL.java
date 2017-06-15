/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.igflow.resultset.RoleInfo;
import com.deliverik.infogovernor.drm.model.StructureRoleInfo;
import com.deliverik.infogovernor.drm.model.condition.StructureRoleSearchCond;
import com.deliverik.infogovernor.drm.model.entity.StructureRoleTB;

/**
  * ����: ��֯�ܹ�������ҵ���߼��ӿ�
  * ��������: ��֯�ܹ�������ҵ���߼��ӿ�
  * ������¼: 2015/03/09
  * �޸ļ�¼: 
  */
public interface StructureRoleBL extends BaseBL {

	/**
	 * ��֯�ܹ�������ʵ��ȡ��
	 *
	 * @return ��֯�ܹ�������ʵ��
	 */
	public StructureRoleTB getStructureRoleTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<StructureRoleInfo> searchStructureRole();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public StructureRoleInfo searchStructureRoleByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(StructureRoleSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<StructureRoleInfo> searchStructureRole(
			StructureRoleSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<StructureRoleInfo> searchStructureRole(
			StructureRoleSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public StructureRoleInfo registStructureRole(StructureRoleInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public StructureRoleInfo updateStructureRole(StructureRoleInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteStructureRoleByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteStructureRole(StructureRoleInfo instance)
		throws BLException;
	/**
     * ��ɫ��ѯ
     * @param cond
     * @return
     */
    public List<RoleInfo> searchRole( StructureRoleSearchCond cond, int start, int count)throws BLException;

    /**
     * ��ɫ��ѯ
     * @param cond
     * @return
     */
    public Integer searchRoleCount( StructureRoleSearchCond cond)throws BLException;
}