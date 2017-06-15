/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.vo;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.RecptionGuestInfo;
import com.deliverik.framework.base.BaseVO;

/**
 * 
 * 接待客人查询VO
 *
 */
public class IGLOM0109VO extends BaseVO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	/**接待客人查询List*/
	protected List<RecptionGuestInfo> recptionguestInfoList;

	/**
	 * 构造函数
	 * @param invoiceVWList List<ChangeKpi>
	 * 
	 */
	
	public IGLOM0109VO(List<RecptionGuestInfo> recptionguestInfoList) {
		this.recptionguestInfoList = recptionguestInfoList;
	}

	public List<RecptionGuestInfo> getRecptionguestInfoList() {
		return recptionguestInfoList;
	}

	public void setRecptionguestInfoList(
			List<RecptionGuestInfo> recptionguestInfoList) {
		this.recptionguestInfoList = recptionguestInfoList;
	}

	/**
	 * 获取接待客人查询统计信息Lis
	 * @return 接待客人查询信息Lis
	 */
	
	

	
}
