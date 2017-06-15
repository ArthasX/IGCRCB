package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.asset.model.IG343Info;
import com.deliverik.infogovernor.asset.model.IG344Info;

/**
 * �����¼ͳ�ƽ��VO
 * 
 * @author ����
 *
 */
@SuppressWarnings("serial")
public class IGASM25011VO extends BaseVO implements Serializable{
	/** �����¼������� */
	protected List<IG343Info> entityItemRelationVWInfoList;
	
	/** �豸�ʲ����� */
	protected int sbSumCount;
	
	/** Ӧ���ʲ����� */
	protected int yySumCount;
	
	/** ��ѵ��¼���� */
	protected int pxSumCount;
	
	/**
	 *  �ϼƴ������� 
	 */
	protected int hjSumCount;

	/** �����¼��ϸ������� */
	protected List<IG344Info> entityItemRelationDetailVWInfo;
	
	/** ��������ۼ� */
	protected int fwcsSumCount;
	
	/** ����ƽ�����ۼ� */
	protected Double fwpjfSumStore;
	
	/** �����¼��ʼʱ�� */
	protected String beginTime_q;
	
	/** �����¼����ʱ�� */
	protected String endTime_q;
	
	/** ���������� */
	protected String einame_like;
	
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
	 * ��ȡeiname_like
	 * @return feiname_like einame_like
	 */
	public String getEiname_like() {
		return einame_like;
	}

	/**
	 * ����einame_like
	 * @param einame_like  einame_like
	 */
	public void setEiname_like(String einame_like) {
		this.einame_like = einame_like;
	}

}


