/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.svc.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prr.model.IG500Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程管理_流程管理_查询VO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSVC01001VO extends BaseVO implements Serializable {

	/**
	 * 流程对象List
	 */
	
	protected List<IG500Info> processRecordList;

	/**
	 * 构造方法
	 * @param processRecordList List<ProcessRecord>
	 */
	
	public IGSVC01001VO(List<IG500Info> processRecordList) {
		this.processRecordList = processRecordList;
	}
	
	/**
	 * 获取流程对象List
	 * @return List<ProcessRecord>
	 */
	
	public List<IG500Info> getProcessRecordList() {
		return processRecordList;
	}
}
