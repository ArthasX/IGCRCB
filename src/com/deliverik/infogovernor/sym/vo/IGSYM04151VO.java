/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.sym.model.ReportFileDefinition;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_��Ȩ����_��ɫ��ȨVO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSYM04151VO extends BaseVO implements Serializable {

	/**
	 * δ��Ȩ��ɫ����List
	 */
	
	protected List<ReportFileDefinition> yroleList;
	
	/**
	 * ����Ȩ��ɫ����List
	 */
	
	protected List<ReportFileDefinition> ownList;
	
	
	protected Map<String,List<ReportFileDefinition>> roleMap;

	/**
	 * ���췽��
	 * @param roleList List<Role>,ownRoleList List<RoleReport>
	 */
	

	
	public IGSYM04151VO(List<ReportFileDefinition> yroleList,List<ReportFileDefinition> ownList) {
		this.ownList = ownList;
		this.yroleList = yroleList;
	}
	
	/**
	 * ��ȡδ��Ȩ��ɫ����List
	 * @return List<UserRoleInfo>
	 */
	




	public List<ReportFileDefinition> getYroleList() {
		return yroleList;
	}

	public void setYroleList(List<ReportFileDefinition> yroleList) {
		this.yroleList = yroleList;
	}

	public List<ReportFileDefinition> getOwnList() {
		return ownList;
	}

	public void setOwnList(List<ReportFileDefinition> ownList) {
		this.ownList = ownList;
	}

	public Map<String, List<ReportFileDefinition>> getRoleMap() {
		return roleMap;
	}

	public void setRoleMap(Map<String, List<ReportFileDefinition>> roleMap) {
		this.roleMap = roleMap;
	}


	


	
}
