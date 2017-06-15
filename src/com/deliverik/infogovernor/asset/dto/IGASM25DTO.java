/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.infogovernor.asset.form.IGASM2502Form;
import com.deliverik.infogovernor.asset.model.IG343Info;
import com.deliverik.infogovernor.asset.model.IG344Info;

/**
 * �����¼ͳ����DTO
 * 
 */
@SuppressWarnings("serial")
public class IGASM25DTO extends BaseDTO implements Serializable{

	/** ���������� */
	protected String einame_like;
	
	/** �����¼��ʼʱ�� */
	protected String beginTime_q;
	
	/** �����¼����ʱ�� */
	protected String endTime_q;
	
	/** �����¼��Ϣ�������� */
//	protected EntityItemVWSearchCond entityItemVWSearchCond;

	/** �����¼������� */
	protected List<IG343Info> entityItemRelationVWInfoList;
	
	/** �豸�ʲ����� */
	protected int sbSumCount;
	
	/** Ӧ���ʲ����� */
	protected int yySumCount;
	
	/** ��ѵ��¼���� */
	protected int pxSumCount;
	
	/** �ϼƴ������� */
	protected int hjSumCount;
	
	/** �����¼��ϸ��ѯform*/
	protected IGASM2502Form igasm2502Form;
	
	/** �����¼��ϸ������� */
	protected List<IG344Info> entityItemRelationDetailVWInfo;
	
	/** ��������ۼ� */
	protected int fwcsSumCount;
	
	/** ����ƽ�����ۼ� */
	protected Double fwpjfSumStore;
	
//	/**
//	 * ��ȡentityItemVWSearchCond
//	 * @return fentityItemVWSearchCond entityItemVWSearchCond
//	 */
//	public EntityItemVWSearchCond getEntityItemVWSearchCond() {
//		return entityItemVWSearchCond;
//	}
//
//	/**
//	 * ����entityItemVWSearchCond
//	 * @param entityItemVWSearchCond  entityItemVWSearchCond
//	 */
//	public void setEntityItemVWSearchCond(
//			EntityItemVWSearchCond entityItemVWSearchCond) {
//		this.entityItemVWSearchCond = entityItemVWSearchCond;
//	}

	/**
	 * ��ȡentityItemRelationVWInfoList
	 * @return fentityItemRelationVWInfoList entityItemRelationVWInfoList
	 */
	public List<IG343Info> getEntityItemRelationVWInfoList() {
		return entityItemRelationVWInfoList;
	}

	/**
	 * ����entityItemRelationVWInfoList
	 * @param entityItemRelationVWInfoList  entityItemRelationVWInfoList
	 */
	public void setEntityItemRelationVWInfoList(
			List<IG343Info> entityItemRelationVWInfoList) {
		this.entityItemRelationVWInfoList = entityItemRelationVWInfoList;
	}

	/**
	 * ��ȡ����������
	 * @return einame_like
	 */
	public String getEiname_like() {
		return einame_like;
	}

	/**
	 * ���÷���������
	 * @param einame_like
	 */
	public void setEiname_like(String einame_like) {
		this.einame_like = einame_like;
	}

	/**
	 * ��ȡ�����¼��ʼʱ�� 
	 * @return beginTime_q
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
	 * ��ȡsbSumCount
	 * @return fsbSumCount sbSumCount
	 */
	public int getSbSumCount() {
		return sbSumCount;
	}

	/**
	 * ����sbSumCount
	 * @param sbSumCount  sbSumCount
	 */
	public void setSbSumCount(int sbSumCount) {
		this.sbSumCount = sbSumCount;
	}

	/**
	 * ��ȡyySumCount
	 * @return fyySumCount yySumCount
	 */
	public int getYySumCount() {
		return yySumCount;
	}

	/**
	 * ����yySumCount
	 * @param yySumCount  yySumCount
	 */
	public void setYySumCount(int yySumCount) {
		this.yySumCount = yySumCount;
	}

	/**
	 * ��ȡpxSumCount
	 * @return fpxSumCount pxSumCount
	 */
	public int getPxSumCount() {
		return pxSumCount;
	}

	/**
	 * ����pxSumCount
	 * @param pxSumCount  pxSumCount
	 */
	public void setPxSumCount(int pxSumCount) {
		this.pxSumCount = pxSumCount;
	}

	/**
	 * ��ȡhjSumCount
	 * @return fhjSumCount hjSumCount
	 */
	public int getHjSumCount() {
		return hjSumCount;
	}

	/**
	 * ����hjSumCount
	 * @param hjSumCount  hjSumCount
	 */
	public void setHjSumCount(int hjSumCount) {
		this.hjSumCount = hjSumCount;
	}
	
	/**
	 * ��ȡentityItemRelationDetailVWInfo
	 * @return fentityItemRelationDetailVWInfo entityItemRelationDetailVWInfo
	 */
	public List<IG344Info> getEntityItemRelationDetailVWInfo() {
		return entityItemRelationDetailVWInfo;
	}

	/**
	 * ����entityItemRelationDetailVWInfo
	 * @param entityItemRelationDetailVWInfo  entityItemRelationDetailVWInfo
	 */
	public void setEntityItemRelationDetailVWInfo(
			List<IG344Info> entityItemRelationDetailVWInfo) {
		this.entityItemRelationDetailVWInfo = entityItemRelationDetailVWInfo;
	}

	/**
	 * ��ȡfwcsSumCount
	 * @return ffwcsSumCount fwcsSumCount
	 */
	public int getFwcsSumCount() {
		return fwcsSumCount;
	}

	/**
	 * ����fwcsSumCount
	 * @param fwcsSumCount  fwcsSumCount
	 */
	public void setFwcsSumCount(int fwcsSumCount) {
		this.fwcsSumCount = fwcsSumCount;
	}

	/**
	 * ��ȡfwpjfSumStore
	 * @return ffwpjfSumStore fwpjfSumStore
	 */
	public Double getFwpjfSumStore() {
		return fwpjfSumStore;
	}

	/**
	 * ����fwpjfSumStore
	 * @param fwpjfSumStore  fwpjfSumStore
	 */
	public void setFwpjfSumStore(Double fwpjfSumStore) {
		this.fwpjfSumStore = fwpjfSumStore;
	}

	/**
	 * ��ȡigasm2102Form
	 * @return figasm2102Form igasm2102Form
	 */
	public IGASM2502Form getIgasm2502Form() {
		return igasm2502Form;
	}

	/**
	 * ����igasm2102Form
	 * @param igasm2102Form  igasm2102Form
	 */
	public void setIgasm2502Form(IGASM2502Form igasm2502Form) {
		this.igasm2502Form = igasm2502Form;
	}
	
}


