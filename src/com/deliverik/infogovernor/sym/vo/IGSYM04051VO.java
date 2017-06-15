/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_��Ȩ����_��ɫ�û�VO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSYM04051VO extends BaseVO implements Serializable {

	/** �û�ID */
	private String userida;

	/** �������� */
	private String orgname;
	
	private String orgida;

	/** �û����� */
	private String username;

	/** �û��绰 */
	private String userphone;

	/** �û��ֻ� */
	private String usermobile;

	/** �û����� */
	private String useremail;

	/** �������� */
	private int workCount;
	
	/** �û�״̬ */
	private String userstatus;

	/** �������� */
	private List<IG677Info> processRecordInfoList;

	/** VO��ʾ�����ݼ��� */
	private List<IGSYM04051VO> desplayVOList;

	/**
	 * ��ɫ�û�List
	 */

	protected List<UserInfo> roleUserList;

	/**
	 * ���췽��
	 */

	public IGSYM04051VO() {
	}
	
	/**
	 * ���췽��
	 * 
	 * @param roleUserList
	 *            List<UserInfo>
	 */

	public IGSYM04051VO(List<UserInfo> roleUserList) {
		this.roleUserList = roleUserList;
	}

	/**
	 * ��ȡ��ɫ�û�
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
