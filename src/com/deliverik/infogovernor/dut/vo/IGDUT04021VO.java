/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dut.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.dut.model.DelayInfo;

/**
 * ��ʱ����VO
 */
public class IGDUT04021VO extends BaseVO {

	private static final long serialVersionUID = 1L;

	/**
	 * ��ʱ���������
	 */
	protected List<DelayInfo> delayList;
	

	/**
	 * ��ʱ���������ȡ��
	 * @return
	 */
	public List<DelayInfo> getDelayList() {
		return delayList;
	}

	/**
	 * ��ʱ����������趨
	 * @param delayList
	 */
	public void setDelayList(List<DelayInfo> delayList) {
		this.delayList = delayList;
	}

}
