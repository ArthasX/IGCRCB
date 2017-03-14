/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
 * 流程查询功能API
 */
public interface SysManageBL extends BaseBL {
	
	/**
	 * 基础数据列表查询
	 * 
	 * @param ccid 数据分类ID
	 * @return 基础数据列表
	 * @throws BLException
	 */
	public List<LabelValueBean> searchCodeList(String ccid) throws BLException;

	/**
	 * 基础数据内容查询
	 * 
	 * @param ccid 数据分类ID
	 * @param cid 数据ID
	 * @return 基础数据内容
	 * @throws BLException
	 */
	public String searchCodeValue(String ccid, String cid) throws BLException;

	/**
     * 机构信息查询
     * 
     * @param orgsyscoding 机构层次码
     * @return 机构信息
     * @throws BLException
     */
    public OrganizationInfo searchOrganizationInfo(String orgsyscoding) throws BLException;
	
	/**
	 * 机构下角色列表查询
	 * 
	 * @param roletype 角色类型
	 * @param roledomain 机构层次码
	 * @param step 角色管理范围是否包括下级（true：包括，false：不包括）
	 * @return 角色ID列表
	 * @throws BLException
	 */
	public List<Integer> searchRoleByOrg(String roletype, String roledomain, boolean step) throws BLException;

	/**
     * 角色值班人列表查询
     * 
     * @param roleid 角色ID
     * @return 角色值班人列表
     * @throws BLException
     */
    public List<RoleDutyInfo> searchRoleDutyInfo(Integer roleid) throws BLException;
    
    /**
	 * 角色信息查询
	 * 
	 * @param roleid 角色ID
	 * @return 角色信息
	 * @throws BLException
	 */
	public RoleInfo searchRoleInfo(Integer roleid) throws BLException;

	/**
	 * 角色列表查询
	 * 
	 * @param rolename 角色名称
	 * @return 角色列表
	 * @throws BLException 
	 */
	public List<com.deliverik.framework.igflow.resultset.RoleInfo> searchRoleInfo(String rolename) throws BLException;

	/**
	 * 用户角色列表查询
	 * 
	 * @param userid 用户ID
	 * @return 角色ID列表
	 * @throws BLException
	 */
	public List<Integer> searchRoleListByUserid(String userid) throws BLException;

	/**
     * 角色负责人列表查询
     * 
     * @param roleid 角色ID
     * @return 角色负责人列表
     * @throws BLException
     */
    public List<RoleMngInfo> searchRoleMngInfo(Integer roleid) throws BLException;
    
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
	public List<UserInfo> searchUserInfo(Integer roleid, String orgid) throws BLException;

	/**
	 * 用户信息查询
	 * 
	 * @param userid 用户ID
	 * @return 用户信息
	 * @throws BLException
	 */
	public UserInfo searchUserInfo(String userid) throws BLException;

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
	public void sendMail(String title, String content, String[] to, String[] cc, String[] bcc) throws BLException;
    
}
