/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.crc.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prr.model.IG500Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 变更批量处理查询VO
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGCRC04011VO extends BaseVO{

	/** 流程信息集合 */
	protected List<IG500Info> prList;

	/**
	 * 流程信息集合取得
	 * @return prList 流程信息集合
	 */
	public List<IG500Info> getPrList() {
		return prList;
	}

	/**
	 * 流程信息集合设定
	 * @param prList 流程信息集合
	 */
	public void setPrList(List<IG500Info> prList) {
		this.prList = prList;
	}
}
