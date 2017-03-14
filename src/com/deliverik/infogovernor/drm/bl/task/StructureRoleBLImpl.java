/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.resultset.RoleInfo;
import com.deliverik.infogovernor.drm.model.StructureRoleInfo;
import com.deliverik.infogovernor.drm.model.condition.StructureRoleSearchCond;
import com.deliverik.infogovernor.drm.model.dao.StructureRoleDAO;
import com.deliverik.infogovernor.drm.model.entity.StructureRoleTB;

/**
  * ����: ��֯�ܹ�������ҵ���߼�ʵ��
  * ��������: ��֯�ܹ�������ҵ���߼�ʵ��
  * ������¼: 2015/03/09
  * �޸ļ�¼: 
  */
public class StructureRoleBLImpl extends BaseBLImpl implements
		StructureRoleBL {

	/** ��֯�ܹ�������DAO�ӿ� */
	protected StructureRoleDAO structureRoleDAO;
	
	/**
	 * ��֯�ܹ�������DAO�ӿ��趨
	 *
	 * @param structureRoleDAO ��֯�ܹ�������DAO�ӿ�
	 */
	public void setStructureRoleDAO(StructureRoleDAO structureRoleDAO) {
		this.structureRoleDAO = structureRoleDAO;
	}

	/**
	 * ��֯�ܹ�������ʵ��ȡ��
	 *
	 * @return ��֯�ܹ�������ʵ��
	 */
	public StructureRoleTB getStructureRoleTBInstance() {
		return new StructureRoleTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<StructureRoleInfo> searchStructureRole() {
		return structureRoleDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public StructureRoleInfo searchStructureRoleByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(StructureRoleSearchCond cond) {
		return structureRoleDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<StructureRoleInfo> searchStructureRole(
			StructureRoleSearchCond cond) {
		return structureRoleDAO.findByCond(cond, 0, 0);
	}

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
			int count) {
		return structureRoleDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public StructureRoleInfo registStructureRole(StructureRoleInfo instance)
		throws BLException {
		return structureRoleDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public StructureRoleInfo updateStructureRole(StructureRoleInfo instance)
		throws BLException {
		checkExistInstance(instance.getSrid());
		return structureRoleDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteStructureRoleByPK(Integer pk)
		throws BLException {
		structureRoleDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteStructureRole(StructureRoleInfo instance)
		throws BLException {
		structureRoleDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public StructureRoleInfo checkExistInstance(Integer pk)
		throws BLException {
		StructureRoleInfo instance = structureRoleDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}
	   /**
     * ��ɫ��ѯ
     * @param cond
     * @return
     */
    public List<RoleInfo> searchRole( StructureRoleSearchCond cond, int start, int count)throws BLException{
        return this.structureRoleDAO.searchRole(cond, start, count);
    }
    /**
     * ��ɫ��ѯ
     * @param cond
     * @return
     */
    public Integer searchRoleCount( StructureRoleSearchCond cond)throws BLException{
        return this.structureRoleDAO.searchRoleCount(cond);
    }

}