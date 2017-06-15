/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.dev.crc.igflow.event.status;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.ProcessInfoDefinitionInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

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
public class IGFXK0402BLImpl implements WorkFlowEventHandlerBL{
	
	/** 日志对象 */
	private static final Log log = LogFactory.getLog(IGFXK0402BLImpl.class);
	
	/** 查询类API */
	protected FlowSearchBL flowSearchBL;
	
	/** 更新类API */
	protected FlowSetBL flowSetBL;

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
		//查询评估内容表格式表单值
		Object obj = flowSearchBL.searchPublicTableValue("评估内容", bean.getLogInfo().getPrid(), null);
		//表单值结构：第一层--每一个分类下的风险点和检查项，第二层，具体到风险点或检查项内部值
		List<Map<String, Object>> dataList = (List<Map<String, Object>>) obj;
		if(dataList != null){
			//处理数据，遍历数据，记录被选中的值，然后清空原有值重新添加
			List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
			//评估内容行号
			int idx_one = 0;
			for(Map<String, Object> dataMap:dataList){
				idx_one ++;
				//记录风险点
				List<Map<String, String>> one_list = new ArrayList<Map<String,String>>();
				//记录检查项
				List<Map<String, String>> two_list = new ArrayList<Map<String,String>>();
				//取得风险点表格式表单值
				List<Map<String, String>> one = (List<Map<String, String>>) dataMap.get("风险点");
				if(one != null){
					//遍历风险点，取得被选中的值
					int idx_two = 0;
					for(Map<String, String> map:one){
						idx_two ++;
						//选择列的值为"."代表该条数据被选中
						if(".".equals(map.get("选择"))){
							one_list.add(map);
						}
						//删除数据库中的记录
						flowSetBL.deletePublicTableFormValue(def, "评估内容#风险点", bean.getLogInfo().getPrid(), idx_one + "_" + idx_two);
					}
				}
				//取得检查项表格式表单值
				List<Map<String, String>> two = (List<Map<String, String>>) dataMap.get("检查项");
				if(two != null){
					//遍历风险点，取得被选中的值
					int idx_two = 0;
					for(Map<String, String> map:two){
						idx_two ++;
						//选择列的值为"."代表该条数据被选中
						if(".".equals(map.get("选择"))){
							two_list.add(map);
						}
						//删除数据库中的记录
						flowSetBL.deletePublicTableFormValue(def, "评估内容#检查项", bean.getLogInfo().getPrid(), idx_one + "_" + idx_two);
					}
				}
				//处理值
				Map<String, Object> tempMap = new LinkedHashMap<String, Object>();
				tempMap.put("风险类别", dataMap.get("风险类别"));
				tempMap.put("风险点", one_list);
				tempMap.put("检查项", two_list);
				list.add(tempMap);
			}
			idx_one = 0;
			//遍历被选中的值
			for(Map<String, Object> map:list){
				//取得风险点
				List<Map<String, String>> one_list = (List<Map<String, String>>) map.get("风险点");
				//取得检查项
				List<Map<String, String>> two_list = (List<Map<String, String>>) map.get("检查项");
				//封装该数据时是按照风险分类封装，但是分类下的风险点或检查项可有一个都没选的情况，过滤这样的数据
				if(one_list.size() > 0 || two_list.size() > 0){
					idx_one ++;
					//插入风险类别
					flowSetBL.setPublicTableColumnValue(def, "评估内容#风险类别", bean.getLogInfo().getPrid(), idx_one + "", (String) map.get("风险类别"));
					//插入风险点
					//有数据正常插入，没有说数据插入一行空行
					if(one_list.size() > 0){
						int idx_two = 0;
						for(Map<String, String> oneMap:one_list){
							idx_two ++;
							for(Iterator<Entry<String, String>> iter = oneMap.entrySet().iterator();iter.hasNext();){
								Entry<String, String> entry = iter.next();
								String key = entry.getKey();
								String value = entry.getValue();
								flowSetBL.setPublicTableColumnValue(def, "评估内容#风险点#" + key, bean.getLogInfo().getPrid(), idx_one + "_" + idx_two, value);
							}
						}
					}else{
						flowSetBL.setPublicTableColumnValue(def, "评估内容#风险点#选择", bean.getLogInfo().getPrid(), idx_one + "_1", "");
						flowSetBL.setPublicTableColumnValue(def, "评估内容#风险点#风险点", bean.getLogInfo().getPrid(), idx_one + "_1", "");
						flowSetBL.setPublicTableColumnValue(def, "评估内容#风险点#检查结果", bean.getLogInfo().getPrid(), idx_one + "_1", "");
						flowSetBL.setPublicTableColumnValue(def, "评估内容#风险点#操作", bean.getLogInfo().getPrid(), idx_one + "_1", "");
						flowSetBL.setPublicTableColumnValue(def, "评估内容#风险点#风险点ID", bean.getLogInfo().getPrid(), idx_one + "_1", "");
						
					}
					//插入检查项
					if(two_list.size() > 0){
						int idx_two = 0;
						for(Map<String, String> twoMap:two_list){
							idx_two ++;
							for(Iterator<Entry<String, String>> iter = twoMap.entrySet().iterator();iter.hasNext();){
								Entry<String, String> entry = iter.next();
								String key = entry.getKey();
								String value = entry.getValue();
								flowSetBL.setPublicTableColumnValue(def, "评估内容#检查项#" + key, bean.getLogInfo().getPrid(), idx_one + "_" + idx_two, value);
							}
						}
					}else{
						flowSetBL.setPublicTableColumnValue(def, "评估内容#检查项#选择", bean.getLogInfo().getPrid(), idx_one + "_1", "");
						flowSetBL.setPublicTableColumnValue(def, "评估内容#检查项#检查项", bean.getLogInfo().getPrid(), idx_one + "_1", "");
						flowSetBL.setPublicTableColumnValue(def, "评估内容#检查项#风险控制情况", bean.getLogInfo().getPrid(), idx_one + "_1", "");
						flowSetBL.setPublicTableColumnValue(def, "评估内容#检查项#操作", bean.getLogInfo().getPrid(), idx_one + "_1", "");
						flowSetBL.setPublicTableColumnValue(def, "评估内容#检查项#检查项ID", bean.getLogInfo().getPrid(), idx_one + "_1", "");
					}
				}
			}
		}
		log.debug("================过滤表格式表单操作结束=================");
	}

}
