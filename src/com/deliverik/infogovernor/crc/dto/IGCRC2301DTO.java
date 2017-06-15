/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.crc.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.crc.form.IGCRC2301Form;
import com.deliverik.infogovernor.crc.model.IGCRC2301VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC2301Cond;

/**	
 * ����:���򿪷�ͳ�Ʋ�ѯ��DTO
 * ������¼��yukexin    2014-8-15 ����5:15:49	
 * �޸ļ�¼��null
 */	
@SuppressWarnings("serial")
public class IGCRC2301DTO extends BaseDTO implements Serializable{
	
	
	/** ���򿪷�ͳ�Ʋ�ѯ����FORM */
	private IGCRC2301Form igcrc2301Form;
	
	/** ���򿪷�ͳ����Ϣ�������� */
	protected IGCRC2301Cond entityItemVWSearchCond;

	/** ��ҳ��DTO */
	protected PagingDTO pagingDto;
	
	/** ������Ϣ���� */
	protected List<IG500Info> processList;

	/** ���򿪷�ͳ�Ƽ������ �����ϼ� */
	protected List<IGCRC2301VWInfo> entityItemVWInfoList;
	
	/** ���������� */
	protected int maxSearchCount;

	/**
	 * ��ҳ��DTOȡ��
	 * @return ��ҳ��DTO
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * ��ҳ��DTO�趨
	 *
	 * @param pagingDto ��ҳ��DTO
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * ���򿪷�ͳ����Ϣ�������ȡ��
	 * @return ���򿪷�ͳ����Ϣ�������
	 */
	public List<IGCRC2301VWInfo> getEntityItemVWInfoList() {
		return entityItemVWInfoList;
	}

	/**
	 * ���򿪷�ͳ����Ϣ��������趨
	 *
	 * @param entityItemVWInfoList ���򿪷�ͳ����Ϣ�������
	 */
	public void setEntityItemVWInfoList(List<IGCRC2301VWInfo> entityItemVWInfoList) {
		this.entityItemVWInfoList = entityItemVWInfoList;
	}

	public IGCRC2301Form getIgcrc2301Form() {
		return igcrc2301Form;
	}

	public void setIgcrc2301Form(IGCRC2301Form igcrc2301Form) {
		this.igcrc2301Form = igcrc2301Form;
	}

	
	/**
	 * @return the processList
	 */
	public List<IG500Info> getProcessList() {
		return processList;
	}

	/**
	 * @param processList the processList to set
	 */
	public void setProcessList(List<IG500Info> processList) {
		this.processList = processList;
	}

	/**
	 * ���򿪷�ͳ����Ϣ��������ȡ��
	 * @return ���򿪷�ͳ����Ϣ��������
	 */
	public IGCRC2301Cond getEntityItemVWSearchCond() {
		return entityItemVWSearchCond;
	}

	/**
	 * ���򿪷�ͳ����Ϣ���������趨
	 *
	 * @param entityItemVWSearchCond ���򿪷�ͳ����Ϣ��������
	 */
	public void setEntityItemVWSearchCond(IGCRC2301Cond entityItemVWSearchCond) {
		this.entityItemVWSearchCond = entityItemVWSearchCond;
	}

	/**
	 * @return the maxSearchCount
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * @param maxSearchCount the maxSearchCount to set
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	
}
