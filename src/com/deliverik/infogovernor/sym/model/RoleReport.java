/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.model;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.infogovernor.sym.model.entity.ReportFileDefinitionTB;

 
/**
 * ������Ȩ��Ϣ�ӿ�
 * 
 */

public interface RoleReport  extends BaseModel {

	/**
	 * ����ȡ��
	 * @return ����
	 */
	public abstract Integer getRrid();

	/**
	 * ��ɫID
	 * @return 
	 */
	public abstract Integer getRoleid();
	
	/**
	 * ����ID
	 * @return ����
	 */
	public abstract Integer getRfdid();
	
	public abstract String getRrperm();
	
	public abstract String getRrdesc();
	
	public ReportFileDefinitionTB getReportFileDefinitionTB();
	

}