/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dut.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.dut.model.DelayInfo;

/**
 * 延时解锁VO
 */
public class IGDUT04021VO extends BaseVO {

	private static final long serialVersionUID = 1L;

	/**
	 * 延时解锁结果集
	 */
	protected List<DelayInfo> delayList;
	

	/**
	 * 延时解锁结果集取得
	 * @return
	 */
	public List<DelayInfo> getDelayList() {
		return delayList;
	}

	/**
	 * 延时解锁结果集设定
	 * @param delayList
	 */
	public void setDelayList(List<DelayInfo> delayList) {
		this.delayList = delayList;
	}

}
