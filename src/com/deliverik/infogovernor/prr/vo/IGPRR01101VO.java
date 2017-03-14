/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prr.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prr.model.IG224Info;

/**
 * @Description: 流程状态日志查看VO
 * @Author  
 * @History 2010-9-13     新建 
 * @Version V1.0
 */
@SuppressWarnings("serial")
public class IGPRR01101VO extends BaseVO implements Serializable {

	/** 流程状态日志集合 */
	protected List<IG224Info> recordStatusLogList;

	/**
	 * 构造方法
	 * @param recordStatusLogList 流程状态日志集合
	 */
	public IGPRR01101VO(List<IG224Info> recordStatusLogList) {
		this.recordStatusLogList = recordStatusLogList;
	}

	/**
	 * 流程状态日志集合取得
	 * @return 流程状态日志集合
	 */
	public List<IG224Info> getRecordStatusLogList() {
		return recordStatusLogList;
	}
	
}