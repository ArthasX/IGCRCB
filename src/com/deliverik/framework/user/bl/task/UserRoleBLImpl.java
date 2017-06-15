package com.deliverik.framework.user.bl.task;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.user.model.UserRole;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.UserRoleSearchCond;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCond;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.user.model.dao.UserRoleTBDAO;
import com.deliverik.framework.user.model.dao.UserRoleVWDAO;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.framework.workflow.WorkFlowConstDefine;

/**
 * <p>
 * �û���ɫ��Ȩ��Ϣҵ���߼�ʵ��
 * </p>
 */
public class UserRoleBLImpl extends BaseBLImpl implements UserRoleBL {
	
	/** �û���ɫ��Ȩ��Ϣ��ز���DAO */
	protected UserRoleTBDAO userRoleTBDAO;
	
	/** �û���ɫ��Ȩ��Ϣ��ز���DAO */
	protected UserRoleVWDAO userRoleVWDAO;

	/**
	 * �û���ɫ��Ȩ��Ϣ��ز���DAO�趨
	 * @param userRoleTBDAO �û���ɫ��Ȩ��Ϣ��ز���DAO
	 */
	
	public void setUserRoleTBDAO(UserRoleTBDAO userRoleTBDAO) {
		this.userRoleTBDAO = userRoleTBDAO;
	}
	
	/**
	 * �û���ɫ��Ȩ��Ϣ��ز���DAO�趨
	 * @param userRoleVWDAO �û���ɫ��Ȩ��Ϣ��ز���DAO
	 */
	
	public void setUserRoleVWDAO(UserRoleVWDAO userRoleVWDAO) {
		this.userRoleVWDAO = userRoleVWDAO;
	}
	
	/**
	 * ���ݼ�������ȡ���û���ɫ��Ȩ��Ϣ�������
	 * 
	 * @param cond �û���ɫ��Ȩ��Ϣ��������
	 * @return �û���ɫ��Ȩ��Ϣ�������
	 */
	public int getUserRoleSearchCount(UserRoleSearchCond cond){

		return userRoleTBDAO.getSearchCount(cond);
	}

	
	/**
	 * �����û���ɫ��Ȩ��Ϣ����ȡ���û���ɫ��Ȩ��Ϣ
	 * 
	 * @param urid �û���ɫ��Ȩ��Ϣ����
	 * @return �û���ɫ��Ȩ��Ϣ
	 * @throws BLException 
	 */
	public UserRole searchUserRoleByKey(Integer urid) throws BLException{

		return checkExistUserRole(urid);
	}
	
	/**
	 * ���ݼ�������ȡ���û���ɫ��Ȩ��Ϣ�б�
	 * 
	 * @param cond �û���ɫ��Ȩ��Ϣ��������
	 * @return �û���ɫ��Ȩ��Ϣ��������б�
	 */

	public List<UserRole> searchUserRole(UserRoleSearchCond cond){

		List<UserRole> ret = userRoleTBDAO.findByCond(cond,0,0);
		return ret;
	}

	/**
	 * ���ݼ�������ȡ���û���ɫ��Ȩ��Ϣ�б�
	 * 
	 * @param cond �û���ɫ��Ȩ��Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return �û���ɫ��Ȩ��Ϣ��������б�
	 */
	public List<UserRole> searchUserRole(UserRoleSearchCond cond, int start, int count){

		List<UserRole> ret = userRoleTBDAO.findByCond(cond,start,count);
		return ret;
	}

	/**
	 * �����û���ɫ��Ȩ��Ϣ����
	 * 
	 * @param userRole ������û���ɫ��Ȩ��Ϣ����
	 * @return �û���ɫ��Ȩ��Ϣ
	 * @throws BLException
	 */
	public UserRole registUserRole(UserRole UserRole) throws BLException{
		UserRole ret = userRoleTBDAO.save(UserRole);
		return ret;
	}

	/**
	 * ����û���ɫ��Ȩ��Ϣ����
	 * 
	 * @param userRole ������û���ɫ��Ȩ��Ϣ����
	 * @return �û���ɫ��Ȩ��Ϣ
	 * @throws BLException
	 */
	public UserRole updateUserRole(UserRole userRole) throws BLException{
		checkExistUserRole(userRole.getUrid());
		UserRole ret = userRoleTBDAO.save(userRole);
		return ret;
	}

	/**
	 * ɾ���û���ɫ��Ȩ��Ϣ����
	 * 
	 * @param userRole ɾ�����û���ɫ��Ȩ��Ϣ����
	 * @return
	 * @throws BLException
	 */
	public void deleteUserRole(UserRole userRole) throws BLException{
		checkExistUserRole(userRole.getUrid());
		userRoleTBDAO.delete(userRole);
	}
	
	/**
	 * �����û���ɫ��Ȩ��Ϣ����ɾ���û���ɫ��Ȩ��Ϣ����
	 * 
	 * @param urid ɾ���û���ɫ��Ȩ��Ϣ������
	 * @return
	 * @throws BLException
	 */

	public void deleteUserRoleByKey(Integer urid) throws BLException {
		UserRole userRole = checkExistUserRole(urid);
		userRoleTBDAO.delete(userRole);
	}
	
	/**
	 * �û���ɫ��Ȩ��Ϣ���ڼ��
	 * 
	 * @param urid �û���ɫ��Ȩ��ϢID
	 * @return �û���ɫ��Ȩ��Ϣ
	 * @throws BLException 
	 */
	protected UserRole checkExistUserRole(Integer urid) throws BLException{
		UserRole info = userRoleTBDAO.findByPK(urid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","�û���ɫ��Ȩ");
		}
		
		return info;
	}
	
	/**
	 * ���ݼ�������ȡ���û���ɫ��Ȩ����
	 * 
	 * @param cond �û���ɫ��Ȩ��Ϣ��������
	 * @return �û���ɫ��Ȩ��Ϣ����
	 */
	public int getUserRoleVWSearchCount(UserRoleVWSearchCond cond){

		return userRoleVWDAO.getSearchCount(cond);
	}

	/**
	 * ���ݼ�������ȡ���û���ɫ��Ȩ��Ϣ�б�
	 * 
	 * @param cond �û���ɫ��Ȩ��Ϣ��������
	 * @return �û���ɫ��Ȩ��Ϣ�б�
	 */
	public List<UserRoleInfo> searchUserRoleVW(UserRoleVWSearchCond cond){

		List<UserRoleInfo> ret = userRoleVWDAO.findByCond(cond,0,0);
		return ret;
	}

	/**
	 * ���ݼ�������ȡ���û���ɫ��Ȩ��Ϣ�б�(��ҳ��ѯ��)
	 * 
	 * @param cond �û���ɫ��Ȩ��Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return �û���ɫ��Ȩ��Ϣ�б�
	 */
	public List<UserRoleInfo> searchUserRoleVW(UserRoleVWSearchCond cond, int start, int count){

		List<UserRoleInfo> ret = userRoleVWDAO.findByCond(cond,start,count);
		return ret;
	}

	
	/**
	 * <p>
	 * ��ȡָ���û���������������̽�ɫ�б�
	 * </p>
	 * 
	 * @param userId �û�ID
	 * @return ָ���û���������������̽�ɫ�б�
	 *
	 */
	public List<UserRoleInfo> getUserRoles(String userId) {
		UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
		cond.setUserid(userId);
		String roles_BP_EX = ResourceUtility.getString("ROLES_BP_EX");
		if(!StringUtils.isEmpty(roles_BP_EX)){
			cond.setRoles_BP_EX(roles_BP_EX.split(","));
		}
		cond.setRoles_Like(WorkFlowConstDefine.PROCESS_ROLE_MARK);
		List<UserRoleInfo> roleList = searchUserRoleVW(cond, 0, 0);
		return roleList;
	}
	
	/**
	 * <p>
	 * �ж�ָ���û��Ƿ�����ָ����ɫ
	 * </p>
	 * 
	 * @param userId �û�ID
	 * @param roleId ��ɫID
	 * @return false:δ����
	 *         true:����
	 *
	 */
	public boolean isRoleInUserRole(String userId, Integer roleId) {
		UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
		cond.setUserid(userId);
		cond.setRoleid(roleId);
		List<UserRoleInfo> roleList = searchUserRoleVW(cond, 0, 0);
		return roleList.isEmpty() ? false : true;
	}
	
	/**
	 * <p>
	 * ��ȡָ���û�����������̹����ɫ��������н�ɫ��Ϣ
	 * </p>
	 * 
	 * @param userId �û�ID
	 * @return ���̹����ɫ��������н�ɫ��Ϣ
	 *
	 */
	public List<UserRoleInfo> getUserRolesNotInProcess(String userId) {
		List<UserRoleInfo> roleList = getUserRoles(userId);
		for (int i = 0; i < roleList.size(); i++) {
			if (WorkFlowConstDefine.PROCESSADMIN_ROLE_TYPE.equals(roleList.get(i)
					.getRoletype())) {
				roleList.remove(i);
				i--;
			}
		}
		return roleList;
	}
	
	/**
	 * <p>
	 * �ж��û��Ƿ���ָ����ɫ���͵ĸ�����
	 * </p>
	 * 
	 * @param userId �û�ID
	 * @param roletype ��ɫ����
	 * @return false:����
	 *         true:��
	 *
	 */
	public boolean checkRoleManagerByType(String userId, String roletype) {
		UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
		cond.setUserid(userId);
		cond.setRoletype(roletype);
		cond.setRolemanager(true);
		List<UserRoleInfo> roleList = searchUserRoleVW(cond, 0, 0);
		return roleList.isEmpty() ? false : true;
	}
	
	/**
	 * <p>
	 * �ж��û��Ƿ���ָ����ɫ�ĸ�����
	 * </p>
	 * 
	 * @param userId �û�ID
	 * @param roleId ��ɫID
	 * @return false:����
	 *         true:��
	 *
	 */
	public boolean checkRoleManagerByID(String userId, Integer roleId) {
		UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
		cond.setUserid(userId);
		cond.setRoleid(roleId);
		cond.setRolemanager(true);
		List<UserRoleInfo> roleList = searchUserRoleVW(cond, 0, 0);
		return roleList.isEmpty() ? false : true;
	}
	
	/**
	 * <p>
	 * �ж��û��Ƿ���ָ����ɫ��ֵ����
	 * </p>
	 * 
	 * @param userId �û�ID
	 * @param roleId ��ɫID
	 * @return false:����
	 *         true:��
	 *
	 */
	public boolean checkRoleDutyflagByID(String userId, Integer roleId) {
		UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
		cond.setUserid(userId);
		cond.setRoleid(roleId);
		cond.setDutyflag(true);
		List<UserRoleInfo> roleList = searchUserRoleVW(cond, 0, 0);
		return roleList.isEmpty() ? false : true;
	}

	public List<UserRoleInfo> findByPdid(String pdid) {
		// TODO Auto-generated method stub
		return userRoleVWDAO.findByPdid(pdid);
	}
}
