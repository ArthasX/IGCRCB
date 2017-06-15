/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.svc.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prr.model.IG500Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程管理_服务台_通用查询VO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSVC01061VO extends BaseVO implements Serializable {

	/**流程List*/
	private List<IG500Info> processRecordList;
	
	/**流程模板查看页URL*/
	private Map<String,String> detailPgMap;
	
	/**
	 * 获取流程List
	 * @return 流程List
	 */
	public List<IG500Info> getProcessRecordList() {
		return processRecordList;
	}
	

	/**
	 * 设置流程map
	 * @param processRecordList 流程List
	 */

	public void setProcessRecordList(List<IG500Info> processRecordList) {
		this.processRecordList = processRecordList;
	}

	/**
	 * 获取流程模板查看页URL
	 * @return 流程模板查看页URL
	 */
	public Map<String,String> getDetailPgMap() {
		return detailPgMap;
	}

	/**
	 * 设置流程模板查看页URL
	 * @param detailPgMap 流程模板查看页URL
	 */
	public void setDetailPgMap(Map<String,String> detailPgMap) {
		this.detailPgMap = detailPgMap;
	}
	
}
