package com.deliverik.framework.user.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserInfo;
import com.deliverik.framework.user.model.condition.UserInfoSearchCond;
import com.deliverik.framework.user.model.condition.UserSearchCond;

/**
 * <p>
 * �û���Ϣҵ���߼�
 * </p>
 */
public interface UserBL extends BaseBL {
	
	/**
	 * ���ݼ�������ȡ���û���Ϣ����
	 * 
	 * @param cond �û���Ϣ��������
	 * @return �û���Ϣ����
	 */
	
	public int getUserSearchCount(UserSearchCond cond);

	/**
	 * �����û���Ϣ����ȡ���û���Ϣ
	 * 
	 * @param userid �û���Ϣ����
	 * @return �û���Ϣ
	 * @throws BLException 
	 */
	public User searchUserByKey(String userid) throws BLException;
	
	/**
	 * ���ݼ�������ȡ���û���Ϣ�б�
	 * 
	 * @param cond �û���Ϣ��������
	 * @return �û���Ϣ�б�
	 */
	
	public List<User> searchUser(UserSearchCond cond);
	
	/**
	 * ���ݼ�������ȡ���û���Ϣ�б�(��ҳ��ѯ��)
	 * 
	 * @param cond �û���Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return �û���Ϣ�б�
	 */
	
	public List<User> searchUser(UserSearchCond cond, int start, int count);
	
	/**
	 * �����û���Ϣ����
	 * 
	 * @param user ������û���Ϣ
	 * @return ������û���Ϣ
	 * @throws BLException
	 */
	public User registUser(User user) throws BLException;
	
	/**
	 * ɾ���û���Ϣ����
	 * 
	 * @param user ɾ�����û���Ϣ
	 * @return
	 * @throws BLException
	 */
	public void deleteUser(User user) throws BLException;
	
	/**
	 * �����û���Ϣ���߼���ɾ���û���Ϣ����
	 * 
	 * @param userid �߼�ɾ���û���Ϣ������
	 * @return
	 * @throws BLException
	 */
	public void deleteUserByKey(String userid) throws BLException;


	/**
	 * ����û���Ϣ����
	 * 
	 * @param user ������û���Ϣ
	 * @return ������û���Ϣ
	 * @throws BLException
	 */
	public User updateUser(User user) throws BLException;
	
	/**
	 * ���ݼ�������ȡ���û���ɫ������Ϣ����
	 * 
	 * @param cond �û���ɫ������Ϣ��������
	 * @return �û���ɫ������Ϣ����
	 */
	
	public int getUserInfoSearchCount(UserInfoSearchCond cond);

	/**
	 * ���ݼ�������ȡ���û���ɫ������Ϣ�б�
	 * 
	 * @param cond �û���ɫ������Ϣ��������
	 * @return �û���ɫ������Ϣ�б�
	 */
	
	public List<UserInfo> searchUserInfo(UserInfoSearchCond cond);
	
	/**
	 * ���ݼ�������ȡ���û���ɫ������Ϣ�б�(��ҳ��ѯ��)
	 * 
	 * @param cond �û���ɫ������Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return �û���ɫ������Ϣ�б�
	 */
	
	public List<UserInfo> searchUserInfo(UserInfoSearchCond cond, int start, int count);
	
	/**
	 * ��ѯָ����ɫ�����µ������û�����
	 * @param cond ��������
	 * @return �����������
	 */
	public int getUserCountByRoleType(UserInfoSearchCond cond);
	
	/**
	 * ��ѯָ����ɫ�����µ������û�
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<User> searchUserByRoleType(UserInfoSearchCond cond, int start, int count);

	/**
	 * ���ݽ�ɫID��ѯ�û�
	 * @param roleid
	 * @return
	 */
	public List<UserInfo> searchUserByRoleId(Integer roleid);
}
