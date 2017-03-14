package com.deliverik.framework.user.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.user.model.UserRole;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.UserRoleSearchCond;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCond;

/**
 * <p>
 * �û���ɫ��Ȩ��Ϣҵ���߼�
 * </p>
 */
public interface UserRoleBL extends BaseBL {
	
	/**
	 * ���ݼ�������ȡ���û���ɫ��Ȩ��Ϣ����
	 * 
	 * @param cond �û���ɫ��Ȩ��Ϣ��������
	 * @return �û���ɫ��Ȩ��Ϣ����
	 */
	
	public int getUserRoleSearchCount(UserRoleSearchCond cond);

	/**
	 * �����û���ɫ��Ȩ��Ϣ����ȡ���û���ɫ��Ȩ��Ϣ
	 * 
	 * @param urid �û���ɫ��Ȩ��Ϣ����
	 * @return �û���ɫ��Ȩ��Ϣ
	 * @throws BLException 
	 */
	public UserRole searchUserRoleByKey(Integer urid) throws BLException;
	
	/**
	 * ���ݼ�������ȡ���û���ɫ��Ȩ��Ϣ�б�
	 * 
	 * @param cond �û���ɫ��Ȩ��Ϣ��������
	 * @return �û���ɫ��Ȩ��Ϣ�б�
	 */
	
	public List<UserRole> searchUserRole(UserRoleSearchCond cond);
	
	/**
	 * ���ݼ�������ȡ���û���ɫ��Ȩ��Ϣ�б�(��ҳ��ѯ��)
	 * 
	 * @param cond �û���ɫ��Ȩ��Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return �û���ɫ��Ȩ��Ϣ�б�
	 */
	
	public List<UserRole> searchUserRole(UserRoleSearchCond cond, int start, int count);
	
	/**
	 * �����û���ɫ��Ȩ��Ϣ����
	 * 
	 * @param userRole ������û���ɫ��Ȩ��Ϣ
	 * @return ������û���ɫ��Ȩ��Ϣ
	 * @throws BLException
	 */
	public UserRole registUserRole(UserRole userRole) throws BLException;
	
	/**
	 * ɾ���û���ɫ��Ȩ��Ϣ����
	 * 
	 * @param userRole ɾ�����û���ɫ��Ȩ��Ϣ
	 * @return
	 * @throws BLException
	 */
	public void deleteUserRole(UserRole userRole) throws BLException;
	
	/**
	 * �����û���ɫ��Ȩ��Ϣ����ɾ���û���ɫ��Ȩ��Ϣ����
	 * 
	 * @param urid ɾ���û���ɫ��Ȩ��Ϣ������
	 * @return
	 * @throws BLException
	 */
	public void deleteUserRoleByKey(Integer urid) throws BLException;


	/**
	 * ����û���ɫ��Ȩ��Ϣ����
	 * 
	 * @param userRole ������û���ɫ��Ȩ��Ϣ
	 * @return ������û���ɫ��Ȩ��Ϣ
	 * @throws BLException
	 */
	public UserRole updateUserRole(UserRole userRole) throws BLException;
	
	/**
	 * ���ݼ�������ȡ���û���ɫ��Ȩ��Ϣ����
	 * 
	 * @param cond �û���ɫ��Ȩ��Ϣ��������
	 * @return �û���ɫ��Ȩ����
	 */
	
	public int getUserRoleVWSearchCount(UserRoleVWSearchCond cond);

	/**
	 * ���ݼ�������ȡ���û���ɫ��Ȩ��Ϣ�б�
	 * 
	 * @param cond �û���ɫ��Ȩ��Ϣ��������
	 * @return �û���ɫ��Ȩ��Ϣ�б�
	 */
	public List<UserRoleInfo> searchUserRoleVW(UserRoleVWSearchCond cond);
	
	/**
	 * ���ݼ�������ȡ���û���ɫ��Ȩ��Ϣ�б�(��ҳ��ѯ��)
	 * 
	 * @param cond �û���ɫ��Ȩ��Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return �û���ɫ��Ȩ��Ϣ�б�
	 */
	public List<UserRoleInfo> searchUserRoleVW(UserRoleVWSearchCond cond, int start, int count);

	/**
	 * <p>
	 * ��ȡָ���û���������������̽�ɫ�б�
	 * </p>
	 * 
	 * @param userId �û�ID
	 * @return ָ���û���������������̽�ɫ�б�
	 *
	 */
	public List<UserRoleInfo> getUserRoles(String userId);
	
	
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
	public boolean isRoleInUserRole(String userId, Integer roleId);
	
	/**
	 * <p>
	 * ��ȡָ���û�����������̹����ɫ��������н�ɫ��Ϣ
	 * </p>
	 * 
	 * @param userId �û�ID
	 * @return ���̹����ɫ��������н�ɫ��Ϣ
	 *
	 */
	public List<UserRoleInfo> getUserRolesNotInProcess(String userId);
	
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
	public boolean checkRoleManagerByType(String userId, String roletype);
	
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
	public boolean checkRoleManagerByID(String userId, Integer roleId);
	
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
	public boolean checkRoleDutyflagByID(String userId, Integer roleId);
	
	/**
	 * ��ѯ���̶���������Ҫ����Ա�ͽ�ɫ��Ϣ
	 * @param pdid
	 * @return
	 */
	public List<UserRoleInfo> findByPdid(String pdid);
}
