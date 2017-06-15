package com.deliverik.framework.user.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserInfo;
import com.deliverik.framework.user.model.condition.UserInfoSearchCond;
import com.deliverik.framework.user.model.condition.UserSearchCond;
import com.deliverik.framework.user.model.dao.UserInfoVWDAO;
import com.deliverik.framework.user.model.dao.UserTBDAO;
import com.deliverik.framework.user.model.entity.UserTB;
import com.deliverik.framework.utility.StringEncrypt;

/**
 * <p>
 * �û���Ϣҵ���߼�ʵ��
 * </p>
 */
public class UserBLImpl extends BaseBLImpl implements UserBL {
	
	/** �û���Ϣ��ز���DAO */
	
	protected UserTBDAO userTBDAO;
	
	/** �û���Ϣ��ز���DAO */
	
	protected UserInfoVWDAO userInfoVWDAO;

	/**
	 * �û���Ϣ��ز���DAO�趨
	 * @param userTBDAO �û���Ϣ��ز���DAO
	 */
	
	public void setUserTBDAO(UserTBDAO userTBDAO) {
		this.userTBDAO = userTBDAO;
	}
	
	/**
	 * �û���Ϣ��ز���DAO�趨
	 * @param userInfoVWDAO �û���Ϣ��ز���DAO
	 */
	
	public void setUserInfoVWDAO(UserInfoVWDAO userInfoVWDAO) {
		this.userInfoVWDAO = userInfoVWDAO;
	}
	
	/**
	 * ���ݼ�������ȡ���û���Ϣ�������
	 * 
	 * @param cond �û���Ϣ��������
	 * @return �û���Ϣ�������
	 */
	public int getUserSearchCount(UserSearchCond cond){

		return userTBDAO.getSearchCount(cond);
	}

	
	/**
	 * �����û���Ϣ����ȡ���û���Ϣ
	 * 
	 * @param userid �û���Ϣ����
	 * @return �û���Ϣ
	 * @throws BLException 
	 */
	public User searchUserByKey(String userid) throws BLException{

		return checkExistUser(userid);
	}
	
	/**
	 * ���ݼ�������ȡ���û���Ϣ�б�
	 * 
	 * @param cond �û���Ϣ��������
	 * @return �û���Ϣ��������б�
	 */

	public List<User> searchUser(UserSearchCond cond){

		List<User> ret = userTBDAO.findByCond(cond,0,0);
		return ret;
	}

	/**
	 * ���ݼ�������ȡ���û���Ϣ�б�
	 * 
	 * @param cond �û���Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return �û���Ϣ��������б�
	 */
	public List<User> searchUser(UserSearchCond cond, int start, int count){

		List<User> ret = userTBDAO.findByCond(cond,start,count);
		return ret;
	}

	/**
	 * �����û���Ϣ����
	 * 
	 * @param user ������û���Ϣ����
	 * @return �û���Ϣ
	 * @throws BLException
	 */
	public User registUser(User user) throws BLException{
		UserTB userTB = new UserTB();
		this.copyProperties(userTB, user);
		userTB.setPassword(StringEncrypt.charToAscii(user.getPassword()));
		return userTBDAO.save(userTB);
	}
	
	/**
	 * ����û���Ϣ����
	 * 
	 * @param user ������û���Ϣ����
	 * @return �û���Ϣ
	 * @throws BLException
	 */
	public User updateUser(User user) throws BLException{
		checkExistUser(user.getUserid());
		UserTB userTB = new UserTB();
		this.copyProperties(userTB, user);
		userTB.setPassword(StringEncrypt.charToAscii(user.getPassword()));
		return userTBDAO.save(userTB);
	}

	/**
	 * �߼�ɾ���û���Ϣ����
	 * 
	 * @param user �߼�ɾ�����û���Ϣ����
	 * @return
	 * @throws BLException
	 */
	public void deleteUser(User user) throws BLException{
		checkExistUser(user.getUserid());
		userTBDAO.delete(user);
	}
	
	/**
	 * �����û���Ϣ����ɾ���û���Ϣ����
	 * 
	 * @param userid ɾ���û���Ϣ������
	 * @return
	 * @throws BLException
	 */

	public void deleteUserByKey(String userid) throws BLException {
		User user = checkExistUser(userid);
		userTBDAO.delete(user);
	}
	
	/**
	 * �û���Ϣ���ڼ��
	 * 
	 * @param userid �û���ϢID
	 * @return �û���Ϣ
	 * @throws BLException 
	 */
	protected User checkExistUser(String userid) throws BLException{
		User info = userTBDAO.findByPK(userid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","�û�");
		}
		
		return info;
	}
	
	/**
	 * ���ݼ�������ȡ���û���Ϣ�������
	 * 
	 * @param cond �û���Ϣ��������
	 * @return �û���Ϣ�������
	 */
	public int getUserInfoSearchCount(UserInfoSearchCond cond){

		return userInfoVWDAO.getSearchCount(cond);
	}

	/**
	 * ���ݼ�������ȡ���û���Ϣ�б�
	 * 
	 * @param cond �û���Ϣ��������
	 * @return �û���Ϣ��������б�
	 */

	public List<UserInfo> searchUserInfo(UserInfoSearchCond cond){

		List<UserInfo> ret = userInfoVWDAO.findByCond(cond,0,0);
		return ret;
	}

	/**
	 * ���ݼ�������ȡ���û���Ϣ�б�
	 * 
	 * @param cond �û���Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return �û���Ϣ��������б�
	 */
	public List<UserInfo> searchUserInfo(UserInfoSearchCond cond, int start, int count){

		List<UserInfo> ret = userInfoVWDAO.findByCond(cond,start,count);
		return ret;
	}
	
	/**
	 * ��ѯָ����ɫ�����µ������û�����
	 * @param cond ��������
	 * @return �����������
	 */
	public int getUserCountByRoleType(UserInfoSearchCond cond){
		return userInfoVWDAO.getUserCountByRoleType(cond);
	}
	
	/**
	 * ��ѯָ����ɫ�����µ������û�
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<User> searchUserByRoleType(UserInfoSearchCond cond, int start, int count){
		return userInfoVWDAO.findUserByRoleType(cond, start, count);
	}
	/**
	 * ���ݽ�ɫID��ѯ�û�
	 * @param roleid
	 * @return
	 */
	public List<UserInfo> searchUserByRoleId(Integer roleid){
		return userTBDAO.searchUserByRoleId(roleid);
	}
}
