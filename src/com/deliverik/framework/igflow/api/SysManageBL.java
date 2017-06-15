/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.igflow.api;

import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.igflow.resultset.OrganizationInfo;
import com.deliverik.framework.igflow.resultset.RoleDutyInfo;
import com.deliverik.framework.igflow.resultset.RoleInfo;
import com.deliverik.framework.igflow.resultset.RoleMngInfo;
import com.deliverik.framework.igflow.resultset.UserInfo;

/**
 * ���̲�ѯ����API
 */
public interface SysManageBL extends BaseBL {
	
	/**
	 * ���������б��ѯ
	 * 
	 * @param ccid ���ݷ���ID
	 * @return ���������б�
	 * @throws BLException
	 */
	public List<LabelValueBean> searchCodeList(String ccid) throws BLException;

	/**
	 * �����������ݲ�ѯ
	 * 
	 * @param ccid ���ݷ���ID
	 * @param cid ����ID
	 * @return ������������
	 * @throws BLException
	 */
	public String searchCodeValue(String ccid, String cid) throws BLException;

	/**
     * ������Ϣ��ѯ
     * 
     * @param orgsyscoding ���������
     * @return ������Ϣ
     * @throws BLException
     */
    public OrganizationInfo searchOrganizationInfo(String orgsyscoding) throws BLException;
	
	/**
	 * �����½�ɫ�б��ѯ
	 * 
	 * @param roletype ��ɫ����
	 * @param roledomain ���������
	 * @param step ��ɫ����Χ�Ƿ�����¼���true��������false����������
	 * @return ��ɫID�б�
	 * @throws BLException
	 */
	public List<Integer> searchRoleByOrg(String roletype, String roledomain, boolean step) throws BLException;

	/**
     * ��ɫֵ�����б��ѯ
     * 
     * @param roleid ��ɫID
     * @return ��ɫֵ�����б�
     * @throws BLException
     */
    public List<RoleDutyInfo> searchRoleDutyInfo(Integer roleid) throws BLException;
    
    /**
	 * ��ɫ��Ϣ��ѯ
	 * 
	 * @param roleid ��ɫID
	 * @return ��ɫ��Ϣ
	 * @throws BLException
	 */
	public RoleInfo searchRoleInfo(Integer roleid) throws BLException;

	/**
	 * ��ɫ�б��ѯ
	 * 
	 * @param rolename ��ɫ����
	 * @return ��ɫ�б�
	 * @throws BLException 
	 */
	public List<com.deliverik.framework.igflow.resultset.RoleInfo> searchRoleInfo(String rolename) throws BLException;

	/**
	 * �û���ɫ�б��ѯ
	 * 
	 * @param userid �û�ID
	 * @return ��ɫID�б�
	 * @throws BLException
	 */
	public List<Integer> searchRoleListByUserid(String userid) throws BLException;

	/**
     * ��ɫ�������б��ѯ
     * 
     * @param roleid ��ɫID
     * @return ��ɫ�������б�
     * @throws BLException
     */
    public List<RoleMngInfo> searchRoleMngInfo(Integer roleid) throws BLException;
    
    /**
	 * �û��б��ѯ
	 * <BR>
	 * ���������ź��ֻ���
	 * 
	 * @param roleid ��ɫID
	 * @param orgid ���������
	 * @return �û��б�
	 * @throws BLException
	 */
	public List<UserInfo> searchUserInfo(Integer roleid, String orgid) throws BLException;

	/**
	 * �û���Ϣ��ѯ
	 * 
	 * @param userid �û�ID
	 * @return �û���Ϣ
	 * @throws BLException
	 */
	public UserInfo searchUserInfo(String userid) throws BLException;

	/**
	 * �ʼ����ʹ���
	 * 
	 * @param title ����
	 * @param content ����
	 * @param to �ռ��˵�ַ
	 * @param cc �����˵�ַ
	 * @param bcc �����˵�ַ
	 * @throws BLException
	 */
	public void sendMail(String title, String content, String[] to, String[] cc, String[] bcc) throws BLException;
    
}
