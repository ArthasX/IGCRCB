/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prr.bl.task;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.ProcessInfoDefinitionInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.infogovernor.asset.model.dao.RiskPointVMDAO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 过滤未选中的风险点和检查项
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGFXK0403BLImpl implements WorkFlowEventHandlerBL{
	
	/** 日志对象 */
	private static final Log log = LogFactory.getLog(IGFXK0403BLImpl.class);
	
	private List<Map<String, Object>> listMap;
	
	/** 查询类API */
	protected FlowSearchBL flowSearchBL;
	
	/** 更新类API */
	protected FlowSetBL flowSetBL;

	/**
	 * @return the flowSearchBL
	 */
	public FlowSearchBL getFlowSearchBL() {
		return flowSearchBL;
	}

	/**
	 * @return the listMap
	 */
	public List<Map<String, Object>> getListMap() {
		return listMap;
	}

	/**
	 * @param listMap the listMap to set
	 */
	public void setListMap(List<Map<String, Object>> listMap) {
		this.listMap = listMap;
	}

	/**
	 * @return the flowSetBL
	 */
	public FlowSetBL getFlowSetBL() {
		return flowSetBL;
	}

	/**
	 * 查询类API设定
	 * @param flowSearchBL 查询类API
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	/**
	 * 更新类API设定
	 * @param flowSetBL 更新类API
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		
	}

	@SuppressWarnings("unchecked")
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		log.debug("================过滤表格式表单操作开始=================");
		//查询表格定义
		Map<String, ProcessInfoDefinitionInfo> def = flowSearchBL.searchProcessTableColumnDef(bean.getLogInfo().getPrid());
		Object list = flowSearchBL.searchPublicTableValue("评估内容", bean.getLogInfo().getPrid(), null);
		List<Map<String, Object>> dataList = (List<Map<String, Object>>) list;
		if(dataList != null){
			int idx_one = 0;
			for(Map<String, Object> map:dataList){
				idx_one ++;
				if(map.get("风险点") != null){
					List<Map<String, String>> tempList = (List<Map<String, String>>) map.get("风险点");
					int idx_two = 0;
					for(Map<String, String> dataMap:tempList){
						idx_two ++;
						if(idx_two == 1){
							continue;
						}
						if(!".".equals(dataMap.get("选择"))){
							flowSetBL.deletePublicTableFormValue(def, "评估内容#风险点", bean.getLogInfo().getPrid(), idx_one + "_" + idx_two);
						}
					}
				}
				if(map.get("检查项") != null){
					List<Map<String, String>> tempList = (List<Map<String, String>>) map.get("检查项");
					int idx_two = 0;
					for(Map<String, String> dataMap:tempList){
						idx_two ++;
						if(idx_two == 1){
							continue;
						}
						if(!".".equals(dataMap.get("选择"))){
							flowSetBL.deletePublicTableFormValue(def, "评估内容#检查项", bean.getLogInfo().getPrid(), idx_one + "_" + idx_two);
						}
					}
				}
			}
		}
		
		
		
		this.listMap = dataList;
		log.debug("================过滤表格式表单操作结束=================");
	}
	
}
