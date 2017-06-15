/*	
 * ��������������������޹�˾��Ȩ���У���������Ȩ����	
 */
package com.deliverik.infogovernor.crc.dto;

import java.util.List;

import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.infogovernor.wkm.form.IGWKM0101Form;

/**
 * ����:���������DTO 
 * ������¼�������� 2014/07/07
 */
public class IGCRC06ExcelDTO extends ExcelDTO {
	/** ����Ϣ���� */
	protected List<IG500Info> processList;
	/** ��ֵ */
	protected List<IG599Info> processInfoList;
	/** ������ */
	protected List<IG337Info> processParticipantList;
	/** ״̬���� */
	protected List<IG333Info> processStatusDefList;
	protected IGWKM0101Form igwkm0101form;
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
