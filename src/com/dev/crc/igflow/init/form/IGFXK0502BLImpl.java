/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.dev.crc.igflow.init.form;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.resultset.ProcessRecordInfo;
import com.deliverik.framework.workflow.WorkFlowParameterInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowInitFormHandlerBL;

/***
 * 风险清单管理待发起节点的表单初始化
 * @time 2014/06/24
 * @author taoye
 * @version 1.0
 * @mail taoye@deliverik.com
 */
public class IGFXK0502BLImpl extends BaseBLImpl implements
		WorkFlowInitFormHandlerBL {
	
	static Log log = LogFactory.getLog(IGFXK0502BLImpl.class);
	
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
	 * 风险清单管理待发起节点的表单初始化
	 * @param param 流程处理参数接口
	 * @return 表单值集合（<名称-值>）
	 */
	public Map<String, Object> initForm(WorkFlowParameterInfo param)
			throws BLException {		
		log.debug("======== 风险清单流程表单初始化处理开始   ========");
		
		//表单值集合返回对象
		Map<String, Object> map = new HashMap<String, Object>();
		//如果扩展参数值不为空，那么该风险清单是由风险评估流程发起的
		if(param.getParameters() != null){
			//扩展参数值为风险评估流程ID,风险评估流程名称,风险点或检查项ID,风险点或检查项名称
			String[] parameter = param.getParameters().split(",");
			//如果不是4个值域，说明传输参数不对
			if(parameter.length != 4){
				log.debug("参数传输格式不对：" + param.getParameters());
			}else{
				//检查资产ID初始化
				map.put("检查资产ID", parameter[2]);
				//风险点或检查项初始化
				map.put("风险点或检查项", parameter[3]);
				//获取发起风险评估流程
				List<ProcessRecordInfo> baseProcess = flowSearchBL.searchProcessInfo(parameter[0], "");
				//隐藏域字段分隔符
				String filter = "_$_";
				//隐藏域,为流程表单赋值
				StringBuffer hiddenField = new StringBuffer();
				//隐藏域赋值
				hiddenField.append(parameter[0]+filter);
				hiddenField.append(baseProcess.get(0).getPrtype()+filter);
				hiddenField.append(parameter[1]);
				//隐藏域初始化
				map.put("隐藏域", hiddenField.toString());			
			}
			
		}
		
		log.debug("======== 风险清单流程表单初始化处理结束   ========");
		
		return map;
	}
}
