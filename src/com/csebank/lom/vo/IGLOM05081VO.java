/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.vo;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.EentertainmentStatistics;
import com.csebank.lom.model.GoutDetailInfo;
import com.deliverik.framework.base.BaseVO;

/**
 * 
 * �Ӵ�ͳ��VO
 *
 */
public class IGLOM05081VO extends BaseVO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	/**
	 * �Ӵ�ͳ�ƽ��
	 */
	protected List<EentertainmentStatistics> eentertainmentStatistics;
	//ʳ����Ʒ������ϸ�������
	protected List<GoutDetailInfo> goutDetailInfoList;

	/**
	 * �Ӵ�ͳ�ƽ��ȡ��
	 * @return �Ӵ�ͳ�ƽ��
	 */
	public List<EentertainmentStatistics> getEentertainmentStatisticsList() {
		return eentertainmentStatistics;
	}

	/**
	 * �Ӵ�ͳ�ƽ��
	 * @param eentertainmentStatistics �Ӵ�ͳ�ƽ��
	 */
	public void setEentertainmentStatisticsList(List<EentertainmentStatistics> eentertainmentStatistics) {
		this.eentertainmentStatistics = eentertainmentStatistics;
	}

	public List<GoutDetailInfo> getGoutDetailInfoList() {
		return goutDetailInfoList;
	}

	public void setGoutDetailInfoList(List<GoutDetailInfo> goutDetailInfoList) {
		this.goutDetailInfoList = goutDetailInfoList;
	}

}
