/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.scheduling.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.workflow.prd.model.IG380Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������_�������_��ҵ��ʱ����VO
 * </p>
 * 
 * @author maozhipengpeng@deliverik.com
 * @version 1.0
 * @param <Role>
 */

@SuppressWarnings("serial")
public class IGSCH03011VO extends BaseVO implements Serializable {

	private String beginDate;

	private User user;
	
	private List<Role> rolelist;
	
	private List<IG380Info> pdList;
	
	
	public List<IG380Info> getPdList() {
		return pdList;
	}

	public void setPdList(List<IG380Info> pdList) {
		this.pdList = pdList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public List<Role> getRolelist() {
		return rolelist;
	}

	public void setRolelist(List<Role> rolelist) {
		this.rolelist = rolelist;
	}
	
	
	
}
