/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.igflow.api;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.bl.SendMailBL;
import com.deliverik.framework.bl.SendMessageBL;
import com.deliverik.framework.igflow.resultset.Organization;
import com.deliverik.framework.igflow.resultset.OrganizationInfo;
import com.deliverik.framework.igflow.resultset.RoleDuty;
import com.deliverik.framework.igflow.resultset.RoleDutyInfo;
import com.deliverik.framework.igflow.resultset.RoleInfo;
import com.deliverik.framework.igflow.resultset.RoleMng;
import com.deliverik.framework.igflow.resultset.RoleMngInfo;
import com.deliverik.framework.igflow.resultset.User;
import com.deliverik.framework.igflow.resultset.UserInfo;
import com.deliverik.framework.user.bl.task.OrganizationBL;
import com.deliverik.framework.user.bl.task.RoleBL;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.UserRole;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.OrganizationSearchCondImpl;
import com.deliverik.framework.user.model.condition.RoleSearchCondImpl;
import com.deliverik.framework.user.model.condition.UserRoleSearchCondImpl;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.utility.CodeListUtils;

/**
 * ���̲�ѯ����API
 */
public class SysManageBLImpl extends BaseBLImpl implements SysManageBL {
	
    /** �Զ���������־*/
    static Log igflowlog = LogFactory.getLog(Constants.IGFLOW_LOG_NAME);
    
	/** �������ݶ���BL */
	protected CodeListUtils codeListUtils;
	
	/** ����BL */
	protected OrganizationBL organizationBL;

	/** ��ɫBL */
	protected RoleBL roleBL;

	/** �ʼ�����BL */
	protected SendMailBL sendMailBL;
	
    /** ���ŷ���BL */
	protected SendMessageBL sendMessageBL;
	
	/** �û�BL */
	protected UserBL userBL;
	
	/** �û���ɫBL */
	protected UserRoleBL userRoleBL;
	
	/**
	 * �������ݶ���BL�趨
	 * 
	 * @param codeListUtils �������ݶ���BL
	 */
	public void setCodeListUtils(CodeListUtils codeListUtils) {
		this.codeListUtils = codeListUtils;
	}

	/**
	 * ����BL�趨
	 * 
	 * @param organizationBL ����BL
	 */
	public void setOrganizationBL(OrganizationBL organizationBL) {
		this.organizationBL = organizationBL;
	}

	/**
	 * ��ɫBL�趨
	 * 
	 * @param roleBL ��ɫBL
	 */
	public void setRoleBL(RoleBL roleBL) {
		this.roleBL = roleBL;
	}

	/**
	 * �ʼ�����BL�趨
	 * @param sendMailBL �ʼ�����BL
	 */
	public void setSendMailBL(SendMailBL sendMailBL) {
		this.sendMailBL = sendMailBL;
	}
	
	/**
	 * ���ŷ���BL�趨
	 * @param sendMessageBL ���ŷ���BL
	 */
	public void setSendMessageBL(SendMessageBL sendMessageBL) {
		this.sendMessageBL = sendMessageBL;
	}

	/**
	 * �û�BL�趨
	 * 
	 * @param userBL �û�BL
	 */
	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
	}

	/**
	 * �û���ɫBL�趨
	 * 
	 * @param userRoleBL �û���ɫBL
	 */
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}
	
	/**
	 * ���������б��ѯ
	 * 
	 * @param ccid ���ݷ���ID
	 * @return ���������б�
	 * @throws BLException
	 */
	public List<LabelValueBean> searchCodeList(String ccid) throws BLException{
	    igflowlog.debug(">>>���������б��ѯ��ʼ");
		if(StringUtils.isEmpty(ccid)) {
			throw new BLException("IGCO10000.E004", "���ݷ���ID");
		}
		List<LabelValueBean> codelist = codeListUtils.getCodeList(ccid, "", "", false, false);
		if (igflowlog.isDebugEnabled()) {
            StringBuffer sbCodedetail = new StringBuffer();
            for(LabelValueBean bean : codelist) {
                if (sbCodedetail.toString().equals("")) {
                    sbCodedetail.append("(" + bean.getValue() + "," + bean.getLabel() + ")");
                } else {
                    sbCodedetail.append(",").append("(" + bean.getValue() + "," + bean.getLabel() + ")");
                }
            }
            igflowlog.debug(">>>���������б��ѯ���������ػ��������б�" + sbCodedetail.toString());
        }
		return codelist;
	}
	
	/**
	 * �����������ݲ�ѯ
	 * 
	 * @param ccid ���ݷ���ID
	 * @param cid ����ID
	 * @return ������������
	 * @throws BLException
	 */
	public String searchCodeValue(String ccid, String cid) throws BLException{
	    igflowlog.debug(">>>�����������ݲ�ѯ��ʼ");
		if(StringUtils.isEmpty(ccid)) {
			throw new BLException("IGCO10000.E004", "���ݷ���ID");
		} else if(StringUtils.isEmpty(cid)) {
			throw new BLException("IGCO10000.E004", "����ID");
		}
		String codeValue =  codeListUtils.getCodeValue(ccid, "", "", cid);
		igflowlog.debug(">>>�����������ݲ�ѯ���������ػ����������ݣ�"+codeValue);
		return codeValue;
	}
	
	/**
	 * ������Ϣ��ѯ
	 * 
	 * @param orgsyscoding ���������
	 * @return ������Ϣ
	 * @throws BLException
	 */
	public OrganizationInfo searchOrganizationInfo(String orgsyscoding) throws BLException{
	    igflowlog.debug(">>>������Ϣ��ѯ��ʼ");
		OrganizationSearchCondImpl cond = new OrganizationSearchCondImpl();
		cond.setOrgsyscoding(orgsyscoding);
		List<com.deliverik.framework.user.model.Organization> orgList = this.organizationBL.searchOrganization(cond); 
		if(orgList != null && orgList.isEmpty()) {
			throw new BLException("IGCO10000.E004","������" + orgsyscoding + "������");
		}
		Organization org = new Organization();
		org.setOrgsyscoding(orgsyscoding);
		org.setOrgname(orgList.get(0).getOrgname());
		org.setFingerPrint(orgList.get(0).getFingerPrint());
		igflowlog.debug(">>>������Ϣ��ѯ���������ػ�����Ϣ��"+org.getOrgname());
		return org;
	}
	
	/**
	 * �����½�ɫ�б��ѯ
	 * 
	 * @param roletype ��ɫ����
	 * @param roledomain ���������
	 * @param step ��ɫ����Χ�Ƿ�����¼���true��������false����������
	 * @return ��ɫID�б�
	 * @throws BLException
	 */
	public List<Integer> searchRoleByOrg(String roletype, String roledomain, boolean step) throws BLException{
	    igflowlog.debug(">>>�����½�ɫ�б��ѯ��ʼ");
		RoleSearchCondImpl cond = new RoleSearchCondImpl();
		cond.setRoletype(roletype);//��ɫ����
		//��ɫ����Χ�Ƿ�����¼�
		if(step) {
			cond.setRoledomain_Like(roledomain);//����
		} else {
			cond.setRoledomain(roledomain);//������
		}
		//��ѯ��ɫ
		List<Role> lst_Role = roleBL.searchRole(cond);
		//�����ɫID����
		List<Integer> lst_Roleid = null;
		if(lst_Role != null && !lst_Role.isEmpty()) {
			lst_Roleid = new ArrayList<Integer>();
			//��伯��
			for(Role role : lst_Role) {
				lst_Roleid.add(role.getRoleid());
			}
		}
		
		if (igflowlog.isDebugEnabled()) {
	        StringBuffer sbRoleid = new StringBuffer();
	        for(Integer roleid : lst_Roleid) {
	            if (sbRoleid.toString().equals("")) {
	                sbRoleid.append(String.valueOf(roleid));
	            } else {
	                sbRoleid.append(",").append(String.valueOf(roleid));
	            }
	        }
	        igflowlog.debug(">>>�����½�ɫ�б��ѯ���������ؽ�ɫID�б�" + sbRoleid.toString());
	    }
		return lst_Roleid;
	}

	/**
     * ��ɫֵ�����б��ѯ
     * 
     * @param roleid ��ɫID
     * @return ��ɫֵ�����б�
     * @throws BLException
     */
	public List<RoleDutyInfo> searchRoleDutyInfo(Integer roleid) throws BLException{
	    igflowlog.debug(">>>��ɫֵ���˲�ѯ��ʼ");
		UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
		cond.setRoleid(roleid);//��ɫID
		cond.setDutyflag(true);//��ɫֵ����
		//��ѯ��ɫֵ����
		List<UserRoleInfo> lst_UserRole = userRoleBL.searchUserRoleVW(cond);
		//��ɫֵ���˼���
		List<RoleDutyInfo> lst_RoleDuty = null;
		//��ɫֵ����ʵ��
		RoleDuty instance = null;
		if(lst_UserRole != null && !lst_UserRole.isEmpty()) {
			lst_RoleDuty = new ArrayList<RoleDutyInfo>();
			//��伯��
			for(UserRoleInfo bean : lst_UserRole) {
				instance = new RoleDuty();
				instance.setUserid(bean.getUserid());//�û�ID
				instance.setUsername(bean.getUsername());//�û�����
				lst_RoleDuty.add(instance);
			}
		}
		
		if (igflowlog.isDebugEnabled()) {
            StringBuffer sbRoleDuty = new StringBuffer();
            for(RoleDutyInfo roleDutyInfo : lst_RoleDuty) {
                if (sbRoleDuty.toString().equals("")) {
                    sbRoleDuty.append("(" + roleDutyInfo.getUserid() + "," + roleDutyInfo.getUsername() + ")");
                } else {
                    sbRoleDuty.append(",").append("(" + roleDutyInfo.getUserid() + "," + roleDutyInfo.getUsername() + ")");
                }
            }
            igflowlog.debug(">>>��ɫֵ���˲�ѯ���������ؽ�ɫֵ�����б�" + sbRoleDuty.toString());
        }
		return lst_RoleDuty;
	}

	/**
	 * ��ɫ��Ϣ��ѯ
	 * 
	 * @param roleid ��ɫID
	 * @return ��ɫ��Ϣ
	 * @throws BLException
	 */
	public RoleInfo searchRoleInfo(Integer roleid) throws BLException{
	    igflowlog.debug(">>>��ɫ��Ϣ��ѯ��ʼ");
		//��ѯ��ɫ
	    Role role = roleBL.searchRoleByKey(roleid);
	    com.deliverik.framework.igflow.resultset.Role instance = new com.deliverik.framework.igflow.resultset.Role();
	    instance.setRoleid(role.getRoleid());//��ɫID
	    instance.setRolename(role.getRolename());//��ɫ����
	    instance.setRoletype(role.getRoletype());//��ɫ����
	    instance.setRoledomain(role.getRoledomain());//��������Χ
	    instance.setAssetdomain(role.getAssetdomain());//�ʲ���������
	    igflowlog.debug(">>>��ɫ��Ϣ��ѯ����");
		return instance;
	}

	/**
	 * ��ɫ�б��ѯ
	 * 
	 * @param rolename ��ɫ����
	 * @return ��ɫ�б�
	 * @throws BLException 
	 */
	public List<com.deliverik.framework.igflow.resultset.RoleInfo> searchRoleInfo(String rolename) throws BLException{
		igflowlog.debug(">>>��ɫ�б��ѯ");
		RoleSearchCondImpl cond = new RoleSearchCondImpl();
		cond.setRolename_q(rolename);//��ɫ����//��ȫƥ��
		//��ѯ��ɫ
		List<Role> lst_Role = roleBL.searchRole(cond);
		List<com.deliverik.framework.igflow.resultset.RoleInfo> lst_Instance 
			= new ArrayList<com.deliverik.framework.igflow.resultset.RoleInfo>();
		com.deliverik.framework.igflow.resultset.Role instance = null;
		for(Role role : lst_Role) {
			instance = new com.deliverik.framework.igflow.resultset.Role();
		    instance.setRoleid(role.getRoleid());//��ɫID
		    instance.setRolename(role.getRolename());//��ɫ����
		    instance.setRoletype(role.getRoletype());//��ɫ����
		    instance.setRoledomain(role.getRoledomain());//��������Χ
		    instance.setAssetdomain(role.getAssetdomain());//�ʲ���������
		    lst_Instance.add(instance);
		}
		igflowlog.debug(">>>��ɫ�б��ѯ");
		return lst_Instance;
	}

	/**
	 * �û���ɫ�б��ѯ
	 * 
	 * @param userid �û�ID
	 * @return ��ɫID�б�
	 * @throws BLException
	 */
	public List<Integer> searchRoleListByUserid(String userid) throws BLException{
	    igflowlog.debug(">>>�û���ɫ�б��ѯ��ʼ");
		UserRoleSearchCondImpl cond = new UserRoleSearchCondImpl();
		cond.setUserid(userid); // �û�ID
		//��ѯ��ɫ
		List<UserRole> lst_UserRole = this.userRoleBL.searchUserRole(cond);
		//�����ɫID����
		List<Integer> lst_Roleid = null;
		if(lst_UserRole != null && !lst_UserRole.isEmpty()) {
			lst_Roleid = new ArrayList<Integer>();
			//��伯��
			for(UserRole role : lst_UserRole) {
				lst_Roleid.add(role.getRoleid());
			}
		}
		
		if (igflowlog.isDebugEnabled()) {
            StringBuffer sbRoleid = new StringBuffer();
            for(Integer roleid : lst_Roleid) {
                if (sbRoleid.toString().equals("")) {
                    sbRoleid.append(String.valueOf(roleid));
                } else {
                    sbRoleid.append(",").append(String.valueOf(roleid));
                }
            }
            igflowlog.debug(">>>�û���ɫ�б��ѯ�����������û���ɫID�б�" + sbRoleid.toString());
        }
		return lst_Roleid;
	}
	
	/**
     * ��ɫ�������б��ѯ
     * 
     * @param roleid ��ɫID
     * @return ��ɫ�������б�
     * @throws BLException
     */
	public List<RoleMngInfo> searchRoleMngInfo(Integer roleid) throws BLException{
	    igflowlog.debug(">>>��ɫ�����˲�ѯ��ʼ");
		UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
		cond.setRoleid(roleid);//��ɫID
		cond.setRolemanager(true);//��ɫ������
		//��ѯ��ɫ������
		List<UserRoleInfo> lst_UserRole = userRoleBL.searchUserRoleVW(cond);
		//��ɫ�����˼���
		List<RoleMngInfo> lst_RoleMng = null;
		//��ɫ������ʵ��
		RoleMng instance = null;
		if(lst_UserRole != null && !lst_UserRole.isEmpty()) {
			lst_RoleMng = new ArrayList<RoleMngInfo>();
			//��伯��
			for(UserRoleInfo bean : lst_UserRole) {
				instance = new RoleMng();
				instance.setUserid(bean.getUserid());//�û�ID
				instance.setUsername(bean.getUsername());//�û�����
				lst_RoleMng.add(instance);
			}
		}
		
		if (igflowlog.isDebugEnabled()) {
            StringBuffer sbRoleMng = new StringBuffer();
            for(RoleMngInfo roleMngInfo : lst_RoleMng) {
                if (sbRoleMng.toString().equals("")) {
                    sbRoleMng.append("(" + roleMngInfo.getUserid() + "," + roleMngInfo.getUsername() + ")");
                } else {
                    sbRoleMng.append(",").append("(" + roleMngInfo.getUserid() + "," + roleMngInfo.getUsername() + ")");
                }
            }
            igflowlog.debug(">>>��ɫ�����˲�ѯ���������ؽ�ɫ�������б�" + sbRoleMng.toString());
        }
		return lst_RoleMng;
	}
	
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
	public List<UserInfo> searchUserInfo(Integer roleid, String orgid) throws BLException{
	    igflowlog.debug(">>>�û���Ϣ��ѯ��ʼ");
		UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
		cond.setRoleid(roleid);//��ɫID
		cond.setOrgid_like(orgid);//���������
		//��ѯ��ɫ������
		List<UserRoleInfo> lst_UserRole = userRoleBL.searchUserRoleVW(cond);
		//�û�����
		List<UserInfo> lst_User = new ArrayList<UserInfo>();
		//�û�ʵ��
		User instance = null;
		if(lst_UserRole != null && !lst_UserRole.isEmpty()) {
			//��伯��
			for(UserRoleInfo bean : lst_UserRole) {
				instance = new User();
				instance.setOrgid(bean.getOrgid());//�������������
				instance.setOrgname(bean.getOrgname()); //������������
				instance.setUserid(bean.getUserid());//�û�ID
				instance.setUserinfo(bean.getUserinfo());//����
				instance.setUsermobile(bean.getUsermobile());//�ֻ���
				instance.setUseremail(bean.getUseremail());//�û�����
				instance.setUsername(bean.getUsername());//�û�����
				lst_User.add(instance);
			}
		}
		igflowlog.debug(">>>�û���Ϣ��ѯ����");
		return lst_User;
	}
	
	/**
	 * �û���Ϣ��ѯ
	 * 
	 * @param userid �û�ID
	 * @return �û���Ϣ
	 * @throws BLException
	 */
	public UserInfo searchUserInfo(String userid) throws BLException{
	    igflowlog.debug(">>>�û���Ϣ��ѯ��ʼ");
		com.deliverik.framework.user.model.User user = userBL.searchUserByKey(userid);
		User ret = new User();
		ret.setOrgid(user.getOrgid());//�������������
		ret.setOrgname(user.getOrgname()); //������������
		ret.setUserid(userid);//�û�ID
		ret.setUserinfo(user.getUserinfo());//����
		ret.setUsermobile(user.getUsermobile());//�ֻ���
		ret.setUsername(user.getUsername());//�û�����
		ret.setUseremail(user.getUseremail());
		igflowlog.debug(">>>�û���Ϣ��ѯ����");
		return ret;
	}
	
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
	public void sendMail(String title, String content, String[] to, String[] cc, String[] bcc) throws BLException{
		igflowlog.debug(">>>�ʼ����ʹ���ʼ");
		this.sendMailBL.sendMail(title, content, to, cc, bcc);
		igflowlog.debug(">>>�ʼ����ʹ������");
	}
}
