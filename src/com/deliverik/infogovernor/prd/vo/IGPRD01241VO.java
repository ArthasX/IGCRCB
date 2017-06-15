/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.prd.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.workflow.prd.model.IG213Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;

/**
 * ���̶���_��ȨVO
 * 
 */
@SuppressWarnings("serial")
public class IGPRD01241VO extends BaseVO implements Serializable {

	/** ����״̬��Ϣ */
	protected IG333Info processStatusDef;
	
	/** ��ѡ��ɫ����List */
	protected List<CodeDetail> codeDetailList;
	
	/** ����ӽ�ɫ����List  */
	protected List<IG213Info> processRoleTypeDefList;

	public List<IG213Info> getProcessRoleTypeDefList() {
		return processRoleTypeDefList;
	}

	public void setProcessRoleTypeDefList(
			List<IG213Info> processRoleTypeDefList) {
		this.processRoleTypeDefList = processRoleTypeDefList;
	}

	public IG333Info getProcessStatusDef() {
		return processStatusDef;
	}

	public void setProcessStatusDef(IG333Info processStatusDef) {
		this.processStatusDef = processStatusDef;
	}

	public List<CodeDetail> getCodeDetailList() {
		return codeDetailList;
	}

	public void setCodeDetailList(List<CodeDetail> codeDetailList) {
		this.codeDetailList = codeDetailList;
	}

}
