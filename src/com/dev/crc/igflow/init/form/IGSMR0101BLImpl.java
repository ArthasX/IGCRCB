/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.dev.crc.igflow.init.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.resultset.TableFormColumnValue;
import com.deliverik.framework.igflow.resultset.TableFormColumnValueInfo;
import com.deliverik.framework.workflow.WorkFlowParameterInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowInitFormHandlerBL;
import com.dev.crc.report.jdbc.query.ReportValueQueryDAO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 监管报表表单初始化
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGSMR0101BLImpl extends BaseBLImpl implements WorkFlowInitFormHandlerBL{
	
	/** 表单值查询DAO */
	protected ReportValueQueryDAO reportValueQueryDAO;

	/**
	 * 表单值查询DAO设定
	 * @param reportValueQueryDAO 表单值查询DAO
	 */
	public void setReportValueQueryDAO(ReportValueQueryDAO reportValueQueryDAO) {
		this.reportValueQueryDAO = reportValueQueryDAO;
	}


	public Map<String, Object> initForm(WorkFlowParameterInfo param)
			throws BLException {
		//表单值Map
		Map<String, Object> map = new HashMap<String, Object>();
		//取得流程定义ID
		String pdid = param.getPdid().substring(0,5);
		//查询表单值
		Map<String, List<String>> dataMap = reportValueQueryDAO.getValue(pdid);
		//重新组装数据，过滤出表格式表单的顶级标题
		Map<String, Map<String, List<String>>> valueMap = new HashMap<String, Map<String,List<String>>>();
		for(Iterator<Entry<String, List<String>>> iter = dataMap.entrySet().iterator();iter.hasNext();){
			Entry<String, List<String>> next = iter.next();
			//表单全路径
			String key = next.getKey();
			//表单值
			List<String> list = next.getValue();
			//表单一级标题
			String formName = key.split("#")[0];
			if(valueMap.get(formName) == null){
				valueMap.put(formName, new HashMap<String, List<String>>());
			}
			valueMap.get(formName).put(key, list);
		}
		//重组数据，将数据组装成可以传递给页面的格式
		Map<String, List<TableFormColumnValueInfo>> finalValueMap = new HashMap<String, List<TableFormColumnValueInfo>>();
		//遍历Map初始化页面
		for(Iterator<Entry<String, Map<String, List<String>>>> iter = valueMap.entrySet().iterator();iter.hasNext();){
			Entry<String, Map<String, List<String>>> next = iter.next();
			String key = next.getKey();
			Map<String, List<String>> value = next.getValue();
			if(finalValueMap.get(key) == null){
				finalValueMap.put(key, new ArrayList<TableFormColumnValueInfo>());
			}
			for(Iterator<Entry<String, List<String>>> iterator = value.entrySet().iterator();iterator.hasNext();){
				Entry<String, List<String>> entry = iterator.next();
				String formUrl = entry.getKey();
				List<String> valueList = entry.getValue();
				int i = 0;
				for(String val:valueList){
					i ++;
					TableFormColumnValue tableValue = new TableFormColumnValue();
					tableValue.setFullName(formUrl);
					/*
						确定行号逻辑有待确定，目前默认按照数据顺序编排行号，但是要求数据位根级表格数据，
						基本大多数据不符合规格，等待现场联调时给出具体数据格式加以分析，总结出通用算法。
						ps:目前只能按照层级算出表格式行号，当前级别按照集合顺序编排，其他层级默认为第一
						行，然后拼接。
					*/
					String rownum = "";
					if(formUrl.split("#").length > 0){
						for(int j=1;j<formUrl.split("#").length;j++){
							if(j > 1){
								rownum += "_";
							}
							if(j == formUrl.split("#").length - 1){
								rownum += i;
							}else{
								rownum += "1";
							}
						}
					}
					tableValue.setRownumber(rownum);
					tableValue.setValue(val);
					finalValueMap.get(key).add(tableValue);
				}
			}
		}
		for(Iterator<Entry<String, List<TableFormColumnValueInfo>>> iter = finalValueMap.entrySet().iterator();iter.hasNext();){
			Entry<String, List<TableFormColumnValueInfo>> next = iter.next();
			String key = next.getKey();
			List<TableFormColumnValueInfo> value = next.getValue();
			map.put(key, value);
		}
		return map;
	}

}
