/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.UserInfo;
import com.deliverik.framework.workflow.prr.model.IG677Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_授权管理_角色用户VO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSYM04051VO extends BaseVO implements Serializable {

	/** 用户ID */
	private String userida;

	/** 所属机构 */
	private String orgname;
	
	private String orgida;

	/** 用户姓名 */
	private String username;

	/** 用户电话 */
	private String userphone;

	/** 用户手机 */
	private String usermobile;

	/** 用户邮箱 */
	private String useremail;

	/** 工作数量 */
	private int workCount;
	
	/** 用户状态 */
	private String userstatus;

	/** 工作内容 */
	private List<IG677Info> processRecordInfoList;

	/** VO显示用数据集合 */
	private List<IGSYM04051VO> desplayVOList;

	/**
	 * 角色用户List
	 */

	protected List<UserInfo> roleUserList;

	/**
	 * 构造方法
	 */

	public IGSYM04051VO() {
	}
	
	/**
	 * 构造方法
	 * 
	 * @param roleUserList
	 *            List<UserInfo>
	 */

	public IGSYM04051VO(List<UserInfo> roleUserList) {
		this.roleUserList = roleUserList;
	}

	/**
	 * 获取角色用户
	 * 
	 * @return List<UserInfo>
	 */

	public List<UserInfo> getRoleUserList() {
		return roleUserList;
	}

	public String getUserida() {
		return userida;
	}

	public void setUserida(String userida) {
		this.userida = userida;
	}

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserphone() {
		return userphone;
	}

	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}

	public String getUsermobile() {
		return usermobile;
	}

	public void setUsermobile(String usermobile) {
		this.usermobile = usermobile;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public int getWorkCount() {
		return workCount;
	}

	public void setWorkCount(int workCount) {
		this.workCount = workCount;
	}

	public void setRoleUserList(List<UserInfo> roleUserList) {
		this.roleUserList = roleUserList;
	}

	public List<IGSYM04051VO> getDesplayVOList() {
		return desplayVOList;
	}

	public void setDesplayVOList(List<IGSYM04051VO> desplayVOList) {
		this.desplayVOList = desplayVOList;
	}

	public String getOrgida() {
		return orgida;
	}

	public void setOrgida(String orgida) {
		this.orgida = orgida;
	}

	public List<IG677Info> getProcessRecordInfoList() {
		return processRecordInfoList;
	}

	public void setProcessRecordInfoList(
			List<IG677Info> processRecordInfoList) {
		this.processRecordInfoList = processRecordInfoList;
	}

	public String getUserstatus() {
		return userstatus;
	}

	public void setUserstatus(String userstatus) {
		this.userstatus = userstatus;
	}

}
