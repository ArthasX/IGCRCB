/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
/**
 * 
 */
package com.deliverik.infogovernor.asset.dto;

import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.asset.form.IGASM2601Form;
import com.deliverik.infogovernor.asset.model.IG342Info;

/**
 * @author Administrator
 *
 */
/**
 * ����: 
 * ����������
 * �����ˣ�����
 * ������¼�� 2012-8-1
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IGASM26DTO extends BaseDTO {

	/** ��������Դ��ͳ�ƽ�� */
	protected List<IG342Info>  entityItemAndConfigItemVWInfoList;
	
	/** �����¼��ʼʱ�� */
	protected String beginTime_q;
	
	/** �����¼����ʱ�� */
	protected String endTime_q;
	
	/** ���������� */
	protected int maxSearchCount;

	/** ��ҳ��DTO */
	protected PagingDTO pagingDto;

	/** ��ѯform*/
	protected IGASM2601Form igasm2601Form;
	
	/**
	 * ��ȡigasm2201Form
	 * @return figasm2201Form igasm2201Form
	 */
	public IGASM2601Form getIgasm2601Form() {
		return igasm2601Form;
	}

	/**
	 * ����igasm2201Form
	 * @param igasm2201Form  igasm2201Form
	 */
	public void setIgasm2601Form(IGASM2601Form igasm2601Form) {
		this.igasm2601Form = igasm2601Form;
	}

	/**
	 * ��ȡentityItemAndConfigItemVWInfoList
	 * @return fentityItemAndConfigItemVWInfoList entityItemAndConfigItemVWInfoList
	 */
	public List<IG342Info> getEntityItemAndConfigItemVWInfoList() {
		return entityItemAndConfigItemVWInfoList;
	}

	/**
	 * ����entityItemAndConfigItemVWInfoList
	 * @param entityItemAndConfigItemVWInfoList  entityItemAndConfigItemVWInfoList
	 */
	public void setEntityItemAndConfigItemVWInfoList(
			List<IG342Info> entityItemAndConfigItemVWInfoList) {
		this.entityItemAndConfigItemVWInfoList = entityItemAndConfigItemVWInfoList;
	}

	/**
	 * ��ȡbeginTime_q
	 * @return fbeginTime_q beginTime_q
	 */
	public String getBeginTime_q() {
		return beginTime_q;
	}

	/**
	 * ����beginTime_q
	 * @param beginTime_q  beginTime_q
	 */
	public void setBeginTime_q(String beginTime_q) {
		this.beginTime_q = beginTime_q;
	}

	/**
	 * ��ȡendTime_q
	 * @return fendTime_q endTime_q
	 */
	public String getEndTime_q() {
		return endTime_q;
	}

	/**
	 * ����endTime_q
	 * @param endTime_q  endTime_q
	 */
	public void setEndTime_q(String endTime_q) {
		this.endTime_q = endTime_q;
	}

	/**
	 * ��ȡmaxSearchCount
	 * @return fmaxSearchCount maxSearchCount
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * ����maxSearchCount
	 * @param maxSearchCount  maxSearchCount
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * ��ȡpagingDto
	 * @return fpagingDto pagingDto
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * ����pagingDto
	 * @param pagingDto  pagingDto
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}
	
}
