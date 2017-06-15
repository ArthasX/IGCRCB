package com.deliverik.infogovernor.crc.dto;


import java.util.List;

import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG599Info;

public class IGCRC01ExcelDTO extends ExcelDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected List<IG500Info> prList;

	public List<IG500Info> getPrList() {
		return prList;
	}

	public void setPrList(List<IG500Info> prList) {
		this.prList = prList;
	}
	/** ����Ϣ���� */
	protected List<IG500Info> processList;
	/** ��ֵ */
	protected List<IG599Info> processInfoList;
	/** ������ */
	protected List<IG337Info> processParticipantList;
	/** ״̬���� */
	protected List<IG333Info> processStatusDefList;

	/**
	 * ����������Ϣ����
	 * 
	 * @return
	 */
	public List<IG500Info> getProcessList() {
		return processList;
	}

	/**
	 * ��ȡ������Ϣ����
	 * 
	 * @param processList
	 */
	public void setProcessList(List<IG500Info> processList) {
		this.processList = processList;
	}

	/**
	 * ���ر���Ϣ����
	 * 
	 * @return
	 */
	public List<IG599Info> getProcessInfoList() {
		return processInfoList;
	}

	/**
	 * ��ȡ����Ϣ����
	 * 
	 * @param processInfoList
	 */
	public void setProcessInfoList(List<IG599Info> processInfoList) {
		this.processInfoList = processInfoList;
	}

	/**
	 * ���ز����˼���
	 * 
	 * @return
	 */
	public List<IG337Info> getProcessParticipantList() {
		return processParticipantList;
	}

	/**
	 * ��ȡ�����˼���
	 * 
	 * @param processParticipantList
	 */
	public void setProcessParticipantList(List<IG337Info> processParticipantList) {
		this.processParticipantList = processParticipantList;
	}

	/**
	 * ����״̬���弯��
	 * 
	 * @return
	 */
	public List<IG333Info> getProcessStatusDefList() {
		return processStatusDefList;
	}

	/**
	 * ��ȡ״̬���弯��
	 * 
	 * @param processStatusDefList
	 */
	public void setProcessStatusDefList(List<IG333Info> processStatusDefList) {
		this.processStatusDefList = processStatusDefList;
	}
	
}
