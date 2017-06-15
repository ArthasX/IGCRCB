/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.dev.crc.igflow.init.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.resultset.ProcessRecordInfo;
import com.deliverik.framework.igflow.resultset.TableFormColumnValue;
import com.deliverik.framework.workflow.WorkFlowParameterInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowInitFormHandlerBL;
import com.deliverik.infogovernor.crc.bl.task.IgalarmBL;
import com.deliverik.infogovernor.crc.model.IgalarmInfo;
import com.deliverik.infogovernor.crc.model.condition.IgalarmSearchCondImpl;

/**
 * 概述: 发起状态表单值初始化 功能描述: 发起状态表单值初始化 创建记录: 2014/07/01 修改记录: 2014/07/09
 * 新添告警信息表单值初始化
 */
public class IGCRC0201BLImpl extends BaseBLImpl implements
		WorkFlowInitFormHandlerBL {

	static Log log = LogFactory.getLog(IGCRC0201BLImpl.class);

	/** 查询类功能API类 */
	private FlowSearchBL flowSearchBL;
	/** 集成告警表业务逻辑BL */
	private IgalarmBL igalarmBL;

	/**
	 * 集成告警表业务逻辑BL设置
	 * 
	 * @param igalarmBL
	 *            集成告警表业务逻辑BL
	 */
	public void setIgalarmBL(IgalarmBL igalarmBL) {
		this.igalarmBL = igalarmBL;
	}

	/**
	 * @param 查询类功能API类
	 *            the flowSearchBL to set
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	/**
	 * 流程状态表单值初始化
	 * 
	 * @param param
	 *            流程处理参数接口
	 * @return 表单值集合（<名称-值>）
	 */
	public Map<String, Object> initForm(WorkFlowParameterInfo param)
			throws BLException {
		log.debug("======== 事件流程待发起节点初始化处理开始========");
		Map<String, Object> map = new HashMap<String, Object>();
		if (param.getParprid() != null) {
			List<ProcessRecordInfo> process = flowSearchBL.searchProcessInfo(
					param.getParprid(), null);
			for (ProcessRecordInfo prInfo : process) {
				map.put("事件描述", prInfo.getPrdesc());
			}
		}
		// 事件发起页面中新添表格式表单(告警信息)内容的初始化
		if (StringUtils.isNotEmpty(param.getParameters())) {

			String[] split = param.getParameters().split(",");
			List<TableFormColumnValue> list = new ArrayList<TableFormColumnValue>();
			// 集成告警表检索条件
			IgalarmSearchCondImpl alarmSearchCond = new IgalarmSearchCondImpl();
			alarmSearchCond.setAlarmIds(split);
			// 通过主键查询行全部信息放入list中
			List<IgalarmInfo> lst = igalarmBL.searchIgalarm(alarmSearchCond);
			// 循环初始化告警信息表格式表单
			for (int j = 0; j < lst.size(); j++) {
				TableFormColumnValue tfcv = new TableFormColumnValue();
				tfcv.setFullName("告警信息#告警ID");
				tfcv.setRownumber(j + 1 + "");
				tfcv.setValue(lst.get(j).getSerial());
				list.add(tfcv);
				TableFormColumnValue tfcv4 = new TableFormColumnValue();
				tfcv4.setFullName("告警信息#主机名称");
				tfcv4.setRownumber(j + 1 + "");
				tfcv4.setValue(lst.get(j).getAppname());
				list.add(tfcv4);
				TableFormColumnValue tfcv1 = new TableFormColumnValue();
				tfcv1.setFullName("告警信息#事件内容");
				tfcv1.setRownumber(j + 1 + "");
				tfcv1.setValue(lst.get(j).getSummary());
				list.add(tfcv1);
				TableFormColumnValue tfcv2 = new TableFormColumnValue();
				tfcv2.setFullName("告警信息#触发时间");
				tfcv2.setRownumber(j + 1 + "");
				tfcv2.setValue(lst.get(j).getLasttime());
				list.add(tfcv2);
				TableFormColumnValue tfcv3 = new TableFormColumnValue();
				tfcv3.setFullName("告警信息#恢复时间");
				tfcv3.setRownumber(j + 1 + "");
				tfcv3.setValue(lst.get(j).getRecoveryTime());
				list.add(tfcv3);
			}
			map.put("告警信息", list);
			map.put("事件来源", "监控告警");
		}

		log.debug("======== 事件流程待发起节点初始化处理结束========");
		return map;

	}

}
