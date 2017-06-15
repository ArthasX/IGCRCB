package com.deliverik.framework.user.bl.task;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.condition.RoleSearchCond;
import com.deliverik.framework.user.model.condition.RoleSearchCondImpl;
import com.deliverik.framework.user.model.dao.RoleTBDAO;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.framework.workflow.WorkFlowConstDefine;

/**
 * <p>
 * ��ɫ��Ϣҵ���߼�ʵ��
 * </p>
 */
public class RoleBLImpl extends BaseBLImpl implements RoleBL {
	
	/** ��ɫ��Ϣ��ز���DAO */
	
	protected RoleTBDAO roleTBDAO;

	/**
	 * ��ɫ��Ϣ��ز���DAO�趨
	 * @param roleTBDAO ��ɫ��Ϣ��ز���DAO
	 */
	
	public void setRoleTBDAO(RoleTBDAO roleTBDAO) {
		this.roleTBDAO = roleTBDAO;
	}
	
	/**
	 * ���ݼ�������ȡ�ý�ɫ��Ϣ�������
	 * 
	 * @param cond ��ɫ��Ϣ��������
	 * @return ��ɫ��Ϣ�������
	 */
	public int getRoleSearchCount(RoleSearchCond cond){

		return roleTBDAO.getSearchCount(cond);
	}

	
	/**
	 * ���ݽ�ɫ��Ϣ����ȡ�ý�ɫ��Ϣ
	 * 
	 * @param roleid ��ɫ��Ϣ����
	 * @return ��ɫ��Ϣ
	 * @throws BLException 
	 */
	public Role searchRoleByKey(Integer roleid) throws BLException{

		return checkExistRole(roleid);
	}
	
	/**
	 * ���ݼ�������ȡ�ý�ɫ��Ϣ�б�
	 * 
	 * @param cond ��ɫ��Ϣ��������
	 * @return ��ɫ��Ϣ��������б�
	 */

	public List<Role> searchRole(RoleSearchCond cond){

		List<Role> ret = roleTBDAO.findByCond(cond,0,0);
		return ret;
	}

	/**
	 * ���ݼ�������ȡ�ý�ɫ��Ϣ�б�
	 * 
	 * @param cond ��ɫ��Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return ��ɫ��Ϣ��������б�
	 */
	public List<Role> searchRole(RoleSearchCond cond, int start, int count){

		List<Role> ret = roleTBDAO.findByCond(cond,start,count);
		return ret;
	}

	/**
	 * �����ɫ��Ϣ����
	 * 
	 * @param role ����Ľ�ɫ��Ϣ����
	 * @return ��ɫ��Ϣ
	 * @throws BLException
	 */
	public Role registRole(Role Role) throws BLException{
		Role ret = roleTBDAO.save(Role);
		return ret;
	}

	/**
	 * �����ɫ��Ϣ����
	 * 
	 * @param role ����Ľ�ɫ��Ϣ����
	 * @return ��ɫ��Ϣ
	 * @throws BLException
	 */
	public Role updateRole(Role role) throws BLException{
		checkExistRole(role.getRoleid());
		Role ret = roleTBDAO.save(role);
		return ret;
	}

	/**
	 * ɾ����ɫ��Ϣ����
	 * 
	 * @param role ɾ���Ľ�ɫ��Ϣ����
	 * @return
	 * @throws BLException
	 */
	public void deleteRole(Role role) throws BLException{
		checkExistRole(role.getRoleid());
		roleTBDAO.delete(role);
	}
	
	/**
	 * ���ݽ�ɫ��Ϣ����ɾ����ɫ��Ϣ����
	 * 
	 * @param roleid ɾ����ɫ��Ϣ������
	 * @return
	 * @throws BLException
	 */

	public void deleteRoleByKey(Integer roleid) throws BLException {
		Role role = checkExistRole(roleid);
		roleTBDAO.delete(role);
		
	}
	
	/**
	 * ��ɫ��Ϣ���ڼ��
	 * 
	 * @param roleid ��ɫ��ϢID
	 * @return ��ɫ��Ϣ
	 * @throws BLException 
	 */
	protected Role checkExistRole(Integer roleid) throws BLException{
		Role info = roleTBDAO.findByPK(roleid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","��ɫ");
		}
		
		return info;
	}
	
	/**
	 * ���̹���Ա��ɫ�ж�
	 * 
	 * @param roleid ��ɫ��ϢID
	 * @return true:��,false:��
	 * @throws BLException 
	 *
	 */
	
	public boolean isProcessAdminRole(Integer roleid) throws BLException {
		Role role = checkExistRole(roleid);
		if(WorkFlowConstDefine.PROCESSADMIN_ROLE_TYPE.equals(role.getRoletype())) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * ���̷����߽�ɫ�ж�
	 * 
	 * @param roleid ��ɫ��ϢID
	 * @return true:��,false:��
	 * @throws BLException 
	 *
	 */
	
	public boolean isProcessDispatchRole(Integer roleid) throws BLException {
		Role role = checkExistRole(roleid);
		if(WorkFlowConstDefine.DISPATCH_ROLE_TYPE.equals(role.getRoletype())) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * ָ����ɫ��������Χ�����̽�ɫȡ�ã����ݲ���flag�ж��Ƿ�������̹���Ա
	 * true:��,false:��
	 * @param roleid ��ɫ��ϢID
	 * @param flag �Ƿ�������̹���Ա
	 * @return ��ɫ��Ϣ�б�
	 *
	 */
	
	public List<Role> getRoleDomain(Integer roleid, boolean flag) throws BLException{
		Role role = checkExistRole(roleid);
		RoleSearchCondImpl cond = new RoleSearchCondImpl();
		cond.setRoledomain_Like(role.getRoledomain());
		cond.setRoles_Like(WorkFlowConstDefine.PROCESS_ROLE_MARK);
		List<Role> roleList = roleTBDAO.findByCond(cond, 0, 0);
		if(!flag) {
			for(Iterator<Role> iter = roleList.iterator(); iter.hasNext();) {
				if(WorkFlowConstDefine.PROCESSADMIN_ROLE_TYPE.equals(iter.next().getRoletype())) {
					iter.remove();
				}
			}
		}
		return roleList;
	}
	
	
	/**
	 * <p>
	 * ��ȡϵͳ�п��Է��ɵĽ�ɫ���ϣ��Ȳ���ϵͳ�е����̹����ɫ
	 * </p>
	 * 
	 * @return ���Է��ɵĽ�ɫ����
	 *
	 */

	public List<Role> getRolesNotInProcess() {
		RoleSearchCondImpl cond = new RoleSearchCondImpl();
		cond.setRoletype(WorkFlowConstDefine.PROCESSADMIN_ROLE_TYPE);
		cond.setRoletypeEqual(2);
		String roles_BP_EX = ResourceUtility.getString("ROLES_BP_EX");
		if(!StringUtils.isEmpty(roles_BP_EX)){
			cond.setRoles_BP_EX(roles_BP_EX.split(","));
		}
		cond.setRoles_Like(WorkFlowConstDefine.PROCESS_ROLE_MARK);
		return searchRole(cond, 0, 0);
	}
	
	/**
	 * <p>
	 * ��ȡָ���Ľ�ɫ
	 * </p>
	 * 
	 * @param roleId ��ɫID
	 * @return ָ���Ľ�ɫ����
	 * @throws BLException
	 *
	 */
	
	public Role getRole(Integer roleId) throws BLException {
		return searchRoleByKey(roleId);
	}
	
	/**
	 * <p>
	 * ��ȡָ�����͵Ľ�ɫ
	 * </p>
	 * 
	 * @param roletype ��ɫ����
	 * @return ָ���Ľ�ɫ����
	 *
	 */

	public List<Role> getRoleByType(String roletype) {
		RoleSearchCondImpl cond = new RoleSearchCondImpl();
		cond.setRoletype(roletype);
		return searchRole(cond, 0, 0);
	}
	
	/**
	 * <p>
	 * ��ȡϵͳ�е�������ɫ
	 * </p>
	 * 
	 * @return ϵͳ�е�������ɫ����
	 *
	 */

	public List<Role> getApproveRoles() {
		RoleSearchCondImpl cond = new RoleSearchCondImpl();
		cond.setRoletype(WorkFlowConstDefine.APPROVE_ROLE_TYPE);
		return searchRole(cond, 0, 0);
	}
	
	/**
	 * ���ݼ�������ȡ�ý�ɫ��Ϣ�������(�Զ������̷���ʱ��ѯ������֧�ֵĽ�ɫʹ��)
	 * 
	 * @param cond ��ɫ��Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return ��ɫ��Ϣ��������б�
	 */
	public int searchRoleCountForSelfDef(RoleSearchCond cond){

		int ret = roleTBDAO.searchRoleCountForSelfDef(cond);
		return ret;
	}
	
	
	/**
	 * ���ݼ�������ȡ�ý�ɫ��Ϣ�б�(�Զ������̷���ʱ��ѯ������֧�ֵĽ�ɫʹ��)
	 * 
	 * @param cond ��ɫ��Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return ��ɫ��Ϣ��������б�
	 */
	public List<Role> searchRoleForSelfDef(RoleSearchCond cond, int start, int count){

		List<Role> ret = roleTBDAO.searchRoleForSelfDef(cond,start,count);
		return ret;
	}
	
}
