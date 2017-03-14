/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prd.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG222Info;
import com.deliverik.framework.workflow.prd.model.IG123Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description:������֧�ֻ���ѡ��VO 
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRD01341VO extends BaseVO{
	
	/** δ��Ӳ����߶���List */
	protected List<IG123Info> orgList;
	
	/** ����Ӳ����߶���List */
	protected List<IG222Info> processParticipantDefList;

	/** ����״̬��Ϣ */
	protected IG333Info processStatusDef;
	
	/** ����Ӳ����߶���ListSize */
	protected Integer processParticipantDefListSize;

	/**
	 * δ��Ӳ����߶���Listȡ��
	 * @return δ��Ӳ����߶���List
	 */
	public List<IG123Info> getOrgList() {
		return orgList;
	}

	/**
	 * δ��Ӳ����߶���List�趨
	 * @param orgList δ��Ӳ����߶���List
	 */
	public void setOrgList(List<IG123Info> orgList) {
		this.orgList = orgList;
	}

	/**
	 * ����Ӳ����߶���Listȡ��
	 * @return ����Ӳ����߶���List
	 */
	public List<IG222Info> getProcessParticipantDefList() {
		return processParticipantDefList;
	}

	/**
	 * ����Ӳ����߶���List�趨
	 * @param processParticipantDefList ����Ӳ����߶���List
	 */
	public void setProcessParticipantDefList(
			List<IG222Info> processParticipantDefList) {
		this.processParticipantDefList = processParticipantDefList;
	}
	
	/**
	 * ����״̬��Ϣȡ��
	 * @return ����״̬��Ϣ
	 */
	public IG333Info getProcessStatusDef() {
		return processStatusDef;
	}

	/**
	 * ����״̬��Ϣ�趨
	 * @param processStatusDef ����״̬��Ϣ
	 */
	public void setProcessStatusDef(IG333Info processStatusDef) {
		this.processStatusDef = processStatusDef;
	}

	/**
	 * ����Ӳ����߶���ListSizeȡ��
	 * @return ����Ӳ����߶���ListSize
	 */
	public Integer getProcessParticipantDefListSize() {
		return processParticipantDefListSize;
	}

	/**
	 * ����Ӳ����߶���ListSize�趨
	 * @param processParticipantDefListSize ����Ӳ����߶���ListSize
	 */
	public void setProcessParticipantDefListSize(
			Integer processParticipantDefListSize) {
		this.processParticipantDefListSize = processParticipantDefListSize;
	}
	
}
