/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prd.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.UserRoleInfo;

/**
 * @Description: ���̲���֪ͨ��VO
 * @Author  
 * @History 2009-8-23     �½� 
 * @Version V2.0
 */
@SuppressWarnings("serial")
public class IGPRD01592VO extends BaseVO implements Serializable {
	
	/** ��ɫID */
	private Integer roleid;
	
	/** ��ɫ���� */
	private String rolename;
	
	/** �û��б� */
	private List<UserRoleInfo> lst_userRoleInfo = new ArrayList<UserRoleInfo>();
	
	/**
	 * ���캯��
	 * 
	 * @param roleid ��ɫID
	 * @param rolename ��ɫ����
	 * @param lst_UserRole �û��б�
	 */
	public IGPRD01592VO(Integer roleid, String rolename, UserRoleInfo userRoleInfo) {
		this.roleid = roleid;
		this.rolename = rolename;
		if(userRoleInfo != null) {
			this.lst_userRoleInfo.add(userRoleInfo);
		}
	}

	/**
	 * ��ɫIDȡ��
	 * 
	 * @return ��ɫID
	 */
	public Integer getRoleid() {
		return roleid;
	}
	
	/**
	 * ��ɫ����ȡ��
	 * 
	 * @return ��ɫ����
	 */
	public String getRolename() {
		return rolename;
	}

	/**
	 * �û��б�ȡ��
	 * 
	 * @return �û��б�
	 */
	public List<UserRoleInfo> getLst_userRoleInfo() {
		return lst_userRoleInfo;
	}

}
