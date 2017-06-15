/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
 * 流程查询功能API
 */
public class SysManageBLImpl extends BaseBLImpl implements SysManageBL {
	
    /** 自定义流程日志*/
    static Log igflowlog = LogFactory.getLog(Constants.IGFLOW_LOG_NAME);
    
	/** 基础数据定义BL */
	protected CodeListUtils codeListUtils;
	
	/** 机构BL */
	protected OrganizationBL organizationBL;

	/** 角色BL */
	protected RoleBL roleBL;

	/** 邮件发送BL */
	protected SendMailBL sendMailBL;
	
    /** 短信发送BL */
	protected SendMessageBL sendMessageBL;
	
	/** 用户BL */
	protected UserBL userBL;
	
	/** 用户角色BL */
	protected UserRoleBL userRoleBL;
	
	/**
	 * 基础数据定义BL设定
	 * 
	 * @param codeListUtils 基础数据定义BL
	 */
	public void setCodeListUtils(CodeListUtils codeListUtils) {
		this.codeListUtils = codeListUtils;
	}

	/**
	 * 机构BL设定
	 * 
	 * @param organizationBL 机构BL
	 */
	public void setOrganizationBL(OrganizationBL organizationBL) {
		this.organizationBL = organizationBL;
	}

	/**
	 * 角色BL设定
	 * 
	 * @param roleBL 角色BL
	 */
	public void setRoleBL(RoleBL roleBL) {
		this.roleBL = roleBL;
	}

	/**
	 * 邮件发送BL设定
	 * @param sendMailBL 邮件发送BL
	 */
	public void setSendMailBL(SendMailBL sendMailBL) {
		this.sendMailBL = sendMailBL;
	}
	
	/**
	 * 短信发送BL设定
	 * @param sendMessageBL 短信发送BL
	 */
	public void setSendMessageBL(SendMessageBL sendMessageBL) {
		this.sendMessageBL = sendMessageBL;
	}

	/**
	 * 用户BL设定
	 * 
	 * @param userBL 用户BL
	 */
	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
	}

	/**
	 * 用户角色BL设定
	 * 
	 * @param userRoleBL 用户角色BL
	 */
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}
	
	/**
	 * 基础数据列表查询
	 * 
	 * @param ccid 数据分类ID
	 * @return 基础数据列表
	 * @throws BLException
	 */
	public List<LabelValueBean> searchCodeList(String ccid) throws BLException{
	    igflowlog.debug(">>>基础数据列表查询开始");
		if(StringUtils.isEmpty(ccid)) {
			throw new BLException("IGCO10000.E004", "数据分类ID");
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
            igflowlog.debug(">>>基础数据列表查询结束，返回基础数据列表：" + sbCodedetail.toString());
        }
		return codelist;
	}
	
	/**
	 * 基础数据内容查询
	 * 
	 * @param ccid 数据分类ID
	 * @param cid 数据ID
	 * @return 基础数据内容
	 * @throws BLException
	 */
	public String searchCodeValue(String ccid, String cid) throws BLException{
	    igflowlog.debug(">>>基础数据内容查询开始");
		if(StringUtils.isEmpty(ccid)) {
			throw new BLException("IGCO10000.E004", "数据分类ID");
		} else if(StringUtils.isEmpty(cid)) {
			throw new BLException("IGCO10000.E004", "数据ID");
		}
		String codeValue =  codeListUtils.getCodeValue(ccid, "", "", cid);
		igflowlog.debug(">>>基础数据内容查询结束，返回基础数据内容："+codeValue);
		return codeValue;
	}
	
	/**
	 * 机构信息查询
	 * 
	 * @param orgsyscoding 机构层次码
	 * @return 机构信息
	 * @throws BLException
	 */
	public OrganizationInfo searchOrganizationInfo(String orgsyscoding) throws BLException{
	    igflowlog.debug(">>>机构信息查询开始");
		OrganizationSearchCondImpl cond = new OrganizationSearchCondImpl();
		cond.setOrgsyscoding(orgsyscoding);
		List<com.deliverik.framework.user.model.Organization> orgList = this.organizationBL.searchOrganization(cond); 
		if(orgList != null && orgList.isEmpty()) {
			throw new BLException("IGCO10000.E004","机构（" + orgsyscoding + "）基本");
		}
		Organization org = new Organization();
		org.setOrgsyscoding(orgsyscoding);
		org.setOrgname(orgList.get(0).getOrgname());
		org.setFingerPrint(orgList.get(0).getFingerPrint());
		igflowlog.debug(">>>机构信息查询结束，返回机构信息："+org.getOrgname());
		return org;
	}
	
	/**
	 * 机构下角色列表查询
	 * 
	 * @param roletype 角色类型
	 * @param roledomain 机构层次码
	 * @param step 角色管理范围是否包括下级（true：包括，false：不包括）
	 * @return 角色ID列表
	 * @throws BLException
	 */
	public List<Integer> searchRoleByOrg(String roletype, String roledomain, boolean step) throws BLException{
	    igflowlog.debug(">>>机构下角色列表查询开始");
		RoleSearchCondImpl cond = new RoleSearchCondImpl();
		cond.setRoletype(roletype);//角色类型
		//角色管理范围是否包括下级
		if(step) {
			cond.setRoledomain_Like(roledomain);//包括
		} else {
			cond.setRoledomain(roledomain);//不包括
		}
		//查询角色
		List<Role> lst_Role = roleBL.searchRole(cond);
		//定义角色ID集合
		List<Integer> lst_Roleid = null;
		if(lst_Role != null && !lst_Role.isEmpty()) {
			lst_Roleid = new ArrayList<Integer>();
			//填充集合
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
	        igflowlog.debug(">>>机构下角色列表查询结束，返回角色ID列表：" + sbRoleid.toString());
	    }
		return lst_Roleid;
	}

	/**
     * 角色值班人列表查询
     * 
     * @param roleid 角色ID
     * @return 角色值班人列表
     * @throws BLException
     */
	public List<RoleDutyInfo> searchRoleDutyInfo(Integer roleid) throws BLException{
	    igflowlog.debug(">>>角色值班人查询开始");
		UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
		cond.setRoleid(roleid);//角色ID
		cond.setDutyflag(true);//角色值班人
		//查询角色值班人
		List<UserRoleInfo> lst_UserRole = userRoleBL.searchUserRoleVW(cond);
		//角色值班人集合
		List<RoleDutyInfo> lst_RoleDuty = null;
		//角色值班人实例
		RoleDuty instance = null;
		if(lst_UserRole != null && !lst_UserRole.isEmpty()) {
			lst_RoleDuty = new ArrayList<RoleDutyInfo>();
			//填充集合
			for(UserRoleInfo bean : lst_UserRole) {
				instance = new RoleDuty();
				instance.setUserid(bean.getUserid());//用户ID
				instance.setUsername(bean.getUsername());//用户姓名
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
            igflowlog.debug(">>>角色值班人查询结束，返回角色值班人列表：" + sbRoleDuty.toString());
        }
		return lst_RoleDuty;
	}

	/**
	 * 角色信息查询
	 * 
	 * @param roleid 角色ID
	 * @return 角色信息
	 * @throws BLException
	 */
	public RoleInfo searchRoleInfo(Integer roleid) throws BLException{
	    igflowlog.debug(">>>角色信息查询开始");
		//查询角色
	    Role role = roleBL.searchRoleByKey(roleid);
	    com.deliverik.framework.igflow.resultset.Role instance = new com.deliverik.framework.igflow.resultset.Role();
	    instance.setRoleid(role.getRoleid());//角色ID
	    instance.setRolename(role.getRolename());//角色名称
	    instance.setRoletype(role.getRoletype());//角色类型
	    instance.setRoledomain(role.getRoledomain());//机构管理范围
	    instance.setAssetdomain(role.getAssetdomain());//资产管理内容
	    igflowlog.debug(">>>角色信息查询结束");
		return instance;
	}

	/**
	 * 角色列表查询
	 * 
	 * @param rolename 角色名称
	 * @return 角色列表
	 * @throws BLException 
	 */
	public List<com.deliverik.framework.igflow.resultset.RoleInfo> searchRoleInfo(String rolename) throws BLException{
		igflowlog.debug(">>>角色列表查询");
		RoleSearchCondImpl cond = new RoleSearchCondImpl();
		cond.setRolename_q(rolename);//角色名称//完全匹配
		//查询角色
		List<Role> lst_Role = roleBL.searchRole(cond);
		List<com.deliverik.framework.igflow.resultset.RoleInfo> lst_Instance 
			= new ArrayList<com.deliverik.framework.igflow.resultset.RoleInfo>();
		com.deliverik.framework.igflow.resultset.Role instance = null;
		for(Role role : lst_Role) {
			instance = new com.deliverik.framework.igflow.resultset.Role();
		    instance.setRoleid(role.getRoleid());//角色ID
		    instance.setRolename(role.getRolename());//角色名称
		    instance.setRoletype(role.getRoletype());//角色类型
		    instance.setRoledomain(role.getRoledomain());//机构管理范围
		    instance.setAssetdomain(role.getAssetdomain());//资产管理内容
		    lst_Instance.add(instance);
		}
		igflowlog.debug(">>>角色列表查询");
		return lst_Instance;
	}

	/**
	 * 用户角色列表查询
	 * 
	 * @param userid 用户ID
	 * @return 角色ID列表
	 * @throws BLException
	 */
	public List<Integer> searchRoleListByUserid(String userid) throws BLException{
	    igflowlog.debug(">>>用户角色列表查询开始");
		UserRoleSearchCondImpl cond = new UserRoleSearchCondImpl();
		cond.setUserid(userid); // 用户ID
		//查询角色
		List<UserRole> lst_UserRole = this.userRoleBL.searchUserRole(cond);
		//定义角色ID集合
		List<Integer> lst_Roleid = null;
		if(lst_UserRole != null && !lst_UserRole.isEmpty()) {
			lst_Roleid = new ArrayList<Integer>();
			//填充集合
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
            igflowlog.debug(">>>用户角色列表查询结束，返回用户角色ID列表：" + sbRoleid.toString());
        }
		return lst_Roleid;
	}
	
	/**
     * 角色负责人列表查询
     * 
     * @param roleid 角色ID
     * @return 角色负责人列表
     * @throws BLException
     */
	public List<RoleMngInfo> searchRoleMngInfo(Integer roleid) throws BLException{
	    igflowlog.debug(">>>角色负责人查询开始");
		UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
		cond.setRoleid(roleid);//角色ID
		cond.setRolemanager(true);//角色负责人
		//查询角色负责人
		List<UserRoleInfo> lst_UserRole = userRoleBL.searchUserRoleVW(cond);
		//角色负责人集合
		List<RoleMngInfo> lst_RoleMng = null;
		//角色负责人实例
		RoleMng instance = null;
		if(lst_UserRole != null && !lst_UserRole.isEmpty()) {
			lst_RoleMng = new ArrayList<RoleMngInfo>();
			//填充集合
			for(UserRoleInfo bean : lst_UserRole) {
				instance = new RoleMng();
				instance.setUserid(bean.getUserid());//用户ID
				instance.setUsername(bean.getUsername());//用户姓名
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
            igflowlog.debug(">>>角色负责人查询结束，返回角色负责人列表：" + sbRoleMng.toString());
        }
		return lst_RoleMng;
	}
	
	/**
	 * 用户列表查询
	 * <BR>
	 * 不包括工号和手机号
	 * 
	 * @param roleid 角色ID
	 * @param orgid 机构层次码
	 * @return 用户列表
	 * @throws BLException
	 */
	public List<UserInfo> searchUserInfo(Integer roleid, String orgid) throws BLException{
	    igflowlog.debug(">>>用户信息查询开始");
		UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
		cond.setRoleid(roleid);//角色ID
		cond.setOrgid_like(orgid);//机构层次码
		//查询角色负责人
		List<UserRoleInfo> lst_UserRole = userRoleBL.searchUserRoleVW(cond);
		//用户集合
		List<UserInfo> lst_User = new ArrayList<UserInfo>();
		//用户实例
		User instance = null;
		if(lst_UserRole != null && !lst_UserRole.isEmpty()) {
			//填充集合
			for(UserRoleInfo bean : lst_UserRole) {
				instance = new User();
				instance.setOrgid(bean.getOrgid());//所属机构层次码
				instance.setOrgname(bean.getOrgname()); //所属机构名称
				instance.setUserid(bean.getUserid());//用户ID
				instance.setUserinfo(bean.getUserinfo());//工号
				instance.setUsermobile(bean.getUsermobile());//手机号
				instance.setUseremail(bean.getUseremail());//用户邮箱
				instance.setUsername(bean.getUsername());//用户姓名
				lst_User.add(instance);
			}
		}
		igflowlog.debug(">>>用户信息查询结束");
		return lst_User;
	}
	
	/**
	 * 用户信息查询
	 * 
	 * @param userid 用户ID
	 * @return 用户信息
	 * @throws BLException
	 */
	public UserInfo searchUserInfo(String userid) throws BLException{
	    igflowlog.debug(">>>用户信息查询开始");
		com.deliverik.framework.user.model.User user = userBL.searchUserByKey(userid);
		User ret = new User();
		ret.setOrgid(user.getOrgid());//所属机构层次码
		ret.setOrgname(user.getOrgname()); //所属机构名称
		ret.setUserid(userid);//用户ID
		ret.setUserinfo(user.getUserinfo());//工号
		ret.setUsermobile(user.getUsermobile());//手机号
		ret.setUsername(user.getUsername());//用户姓名
		ret.setUseremail(user.getUseremail());
		igflowlog.debug(">>>用户信息查询结束");
		return ret;
	}
	
	/**
	 * 邮件发送处理
	 * 
	 * @param title 主题
	 * @param content 内容
	 * @param to 收件人地址
	 * @param cc 抄送人地址
	 * @param bcc 暗送人地址
	 * @throws BLException
	 */
	public void sendMail(String title, String content, String[] to, String[] cc, String[] bcc) throws BLException{
		igflowlog.debug(">>>邮件发送处理开始");
		this.sendMailBL.sendMail(title, content, to, cc, bcc);
		igflowlog.debug(">>>邮件发送处理结束");
	}
}
