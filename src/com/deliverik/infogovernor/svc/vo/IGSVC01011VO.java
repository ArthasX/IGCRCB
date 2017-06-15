/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.svc.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG677Info;
import com.deliverik.infogovernor.com.model.ProcessInHandVWInfo;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程管理_事件管理_查询VO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSVC01011VO extends BaseVO implements Serializable {

	/**流程map*/
	private Map<String, List<IG500Info>> processRecordMap;
	
	/**流程与参与者视图map*/
	private Map<String, List<IG677Info>> processRecordInfoMap;
	
	/**流程模板查看页URL*/
	private Map<String,String> detailPgMap;
	
	/**流程模板名称*/
	private String[] templateNames;
	
	/**流程模板查看页URL*/
	private String[] detailPgs;
	
	/** 工作信息集合 */
	protected List<ProcessInHandVWInfo> workList;
	
	/** 角色工作结合 */
	protected Map<String, List<ProcessInHandVWInfo>> workMap;

	/**
	 * 获取流程map
	 * @return 流程map
	 */
	public Map<String, List<IG500Info>> getProcessRecordMap() {
		return processRecordMap;
	}

	/**
	 * 设置流程map
	 * @param processRecordMap 流程map
	 */
	public void setProcessRecordMap(
			Map<String, List<IG500Info>> processRecordMap) {
		this.processRecordMap = processRecordMap;
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
	
	/**
	 * 获取流程与参与者视图map
	 * @return 流程与参与者视图map
	 */
	public Map<String, List<IG677Info>> getProcessRecordInfoMap() {
		return processRecordInfoMap;
	}

	/**
	 * 设置流程与参与者视图map
	 * @param processRecordInfoMap 流程与参与者视图map
	 */
	public void setProcessRecordInfoMap(
			Map<String, List<IG677Info>> processRecordInfoMap) {
		this.processRecordInfoMap = processRecordInfoMap;
	}
	
	
	/**
	 * 获取流程模板查看页URL
	 * @return 流程模板查看页URL
	 */
	public String[] getDetailPgs() {
		return detailPgs;
	}

	/**
	 * 设置流程模板查看页URL
	 * @param detailPgs 流程模板查看页URL
	 */
	public void setDetailPgs(String[] detailPgs) {
		this.detailPgs = detailPgs;
	}
	
		/**
	 * 获取流程模板名称
	 * @return 流程模板名称
	 */
	public String[] getTemplateNames() {
		return templateNames;
	}

	/**
	 * 设置流程模板名称
	 * @param String[] 流程模板名称
	 */
	public void setTemplateNames(String[] templateNames) {
		this.templateNames = templateNames;
	}

	/**
	 * 工作信息集合取得
	 * @return workList 工作信息集合
	 */
	public List<ProcessInHandVWInfo> getWorkList() {
		return workList;
	}

	/**
	 * 工作信息集合设定
	 * @param workList 工作信息集合
	 */
	public void setWorkList(List<ProcessInHandVWInfo> workList) {
		this.workList = workList;
	}

	/**
	 * 角色工作结合取得
	 * @return workMap 角色工作结合
	 */
	public Map<String, List<ProcessInHandVWInfo>> getWorkMap() {
		if(workList != null && workList.size() > 0){
			workMap = new LinkedHashMap<String, List<ProcessInHandVWInfo>>();
			for(ProcessInHandVWInfo info:workList){
				if(workMap.get(info.getPprolename()) == null){
					workMap.put(info.getPprolename(), new ArrayList<ProcessInHandVWInfo>());
				}
				workMap.get(info.getPprolename()).add(info);
			}
		}
		return workMap;
	}
	
}
