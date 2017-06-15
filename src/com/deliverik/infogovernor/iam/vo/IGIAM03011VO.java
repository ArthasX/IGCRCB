/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.iam.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.Attachment;
import com.deliverik.infogovernor.iam.form.IGIAM0301Form;
import com.deliverik.infogovernor.iam.model.AUDITPROJECTInfo;

/**
 * ����: 
 * ����������
 * �����ˣ���ӿ��
 * ������¼�� 2012-8-9
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IGIAM03011VO extends BaseVO implements Serializable {
	/**
	 * ��Ʊ����ѯForm
	 */
	private IGIAM0301Form igiam0301Form ;
	/**
     * ��Ʊ����ѯ���list
     */
	protected List<AUDITPROJECTInfo> auditProjectInfoList;
	/**
	 * ����KEYlist
	 */
	protected List<Attachment> attkeyList;
	
	public IGIAM0301Form getIgiam0301Form() {
		return igiam0301Form;
	}
	public void setIgiam0301Form(IGIAM0301Form igiam0301Form) {
		this.igiam0301Form = igiam0301Form;
	}
	public List<AUDITPROJECTInfo> getAuditProjectInfoList() {
		return auditProjectInfoList;
	}
	public void setAuditProjectInfoList(List<AUDITPROJECTInfo> auditProjectInfoList) {
		this.auditProjectInfoList = auditProjectInfoList;
	}
	public List<Attachment> getAttkeyList() {
		return attkeyList;
	}
	public void setAttkeyList(List<Attachment> attkeyList) {
		this.attkeyList = attkeyList;
	}
}
