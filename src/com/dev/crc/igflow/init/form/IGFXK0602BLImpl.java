/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.dev.crc.igflow.init.form;

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
import com.deliverik.framework.workflow.WorkFlowParameterInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowInitFormHandlerBL;

/***
 * 问题整改管理待发起节点的表单初始化
 * @time 2014/06/19
 * @author taoye
 * @version 1.0
 * @mail taoye@deliverik.com
 */
public class IGFXK0602BLImpl extends BaseBLImpl implements
		WorkFlowInitFormHandlerBL {
	
	static Log log = LogFactory.getLog(IGFXK0602BLImpl.class);
	
	/** 查询类API */
	private FlowSearchBL flowSearchBL;
	
	/**
	 * 查询类API设定
	 * @param flowSearchBL 查询类API
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}
	
	/**
	 * 问题整改管理待发起节点的表单初始化
	 * @param param 流程处理参数接口
	 * @return 表单值集合（<名称-值>）
	 */
	public Map<String, Object> initForm(WorkFlowParameterInfo param)
			throws BLException {		
		log.debug("======== 问题整改流程表单初始化处理开始   ========");
		
		//表单值集合返回对象
		Map<String, Object> map = new HashMap<String, Object>();
		//如果主流程id不为空，说明该问题整改流程是从别的流程发起的
		if(param.getParprid() != null && param.getParprid() > 0){
			//获取主流程表单——风险清单标题的值
			String listTitle = flowSearchBL.searchPublicProcessInfo(param.getParprid(), "风险清单标题");
			//将主流程表单——风险清单标题的值 赋值给 问题整改表单——问题整改标题
			map.put("问题整改标题",listTitle);
			
			//获取主流程表单——风险清单标题的值
			String listDesc = flowSearchBL.searchPublicProcessInfo(param.getParprid(), "风险清单描述");
			//将主流程表单——风险清单描述的值 赋值给 问题整改表单——问题整改描述
			map.put("问题整改描述",listDesc);
			
			//获取主流程表单——清单所属领域的值
			String listField = flowSearchBL.searchPublicProcessInfo(param.getParprid(), "清单所属领域");
			//将主流程表单——清单所属领域的值 赋值给 问题整改表单——问题所属领域
			map.put("问题所属领域",listField);
			
			//获取主流程表单——来源的值
			String source = flowSearchBL.searchPublicProcessInfo(param.getParprid(), "来源");
			//将主流程表单——来源的值 赋值给 问题整改表单——问题整改来源
			map.put("问题整改来源", source);
			
			//创建隐藏域向页面传入初始值
			StringBuffer hiddenField = new StringBuffer();
			//设置隐藏域间的分隔符
			String filter = "_$_";
			//获取主流程
			List<ProcessRecordInfo> baseProcess = flowSearchBL.searchProcessInfo(param.getParprid(), "");
			//拼接流程表单隐藏域的传值信息——流程ID
			hiddenField.append(baseProcess.get(0).getPrid()+filter);
			//拼接流程表单隐藏域的传值信息——流程类型
			hiddenField.append(baseProcess.get(0).getPrtype()+filter);
			//拼接流程表单隐藏域的传值信息——主流程标题
			hiddenField.append(listTitle);
			//将主流程标题 赋值给 问题整改表单——隐藏域
			map.put("隐藏域", hiddenField.toString());
			
		}
		if(StringUtils.isNotEmpty(param.getParameters())){
			map.put("资产ID", param.getParameters());
		}
		
		log.debug("======== 问题整改流程表单初始化处理结束   ========");
		
		return map;
	}
}
