/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.crc.dto;

import java.util.List;
import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.infogovernor.wkm.form.IGWKM0101Form;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������DTO
 * </p>
 * 
 * @author zhangxinru 2016/02/25
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGCRC30DTO extends BaseDTO{

    protected IGWKM0101Form igwkm0101form;
	

	/** ������Ϣ���� */
	protected List<IG500Info> processList;
	
	/** ��ֵ*/
	protected List<IG599Info> processInfoList;
	/** ������*/
	protected List<IG337Info> processParticipantList;
	/** ״̬����*/
	protected List<IG333Info> processStatusDefList;
	

	

	

	/**
	 * @return the igwkm0101form
	 */
	public IGWKM0101Form getIgwkm0101form() {
		return igwkm0101form;
	}

	/**
	 * @param igwkm0101form the igwkm0101form to set
	 */
	public void setIgwkm0101form(IGWKM0101Form igwkm0101form) {
		this.igwkm0101form = igwkm0101form;
	}

	/**
	 * ������Ϣ����ȡ��
	 * @return processList ������Ϣ����
	 */
	public List<IG500Info> getProcessList() {
		return processList;
	}

	/**
	 * ������Ϣ�����趨
	 * @param processList ������Ϣ����
	 */
	public void setProcessList(List<IG500Info> processList) {
		this.processList = processList;
	}


	public List<IG599Info> getProcessInfoList() {
		return processInfoList;
	}

	public void setProcessInfoList(List<IG599Info> processInfoList) {
		this.processInfoList = processInfoList;
	}

	public List<IG337Info> getProcessParticipantList() {
		return processParticipantList;
	}

	public void setProcessParticipantList(List<IG337Info> processParticipantList) {
		this.processParticipantList = processParticipantList;
	}

	public List<IG333Info> getProcessStatusDefList() {
		return processStatusDefList;
	}

	public void setProcessStatusDefList(List<IG333Info> processStatusDefList) {
		this.processStatusDefList = processStatusDefList;
	}


}
