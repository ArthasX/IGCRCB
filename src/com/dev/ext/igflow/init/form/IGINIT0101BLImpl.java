/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.dev.ext.igflow.init.form;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.WorkFlowParameterInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowInitFormHandlerBL;
import com.sybase.jdbc4.a.b.o;

/**
 * <p>
 * 测试流程发起状态表单值初始化
 * </p>
 */
public class IGINIT0101BLImpl extends BaseBLImpl implements
		WorkFlowInitFormHandlerBL {
	
	static Log log = LogFactory.getLog(IGINIT0101BLImpl.class);
	
	/**
	 * 流程状态表单值初始化
	 * 
	 * @param param 流程处理参数接口
	 * @return 表单值集合（<名称-值>）
	 */
	public Map<String, Object> initForm(WorkFlowParameterInfo param) throws BLException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("一", "一有值了");
		map.put("二", "二有值了");
		return map;
	}

}
