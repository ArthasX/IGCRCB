/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.dev.ext.igflow.generator.serialnum;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowSerialnumGeneratorBL;

/**
 * <p>
 * 工单号生成器
 * </p>
 */
public class IGGENERATOR0101BLImpl extends BaseBLImpl implements
		WorkFlowSerialnumGeneratorBL {

	/**
	 * 流程工单号生成处理
	 * 
	 * @param 流程ID
	 * @return 流程工单号
	 * @throws BLException
	 */
	public String serialnumGenerator(Integer prid) throws BLException {
		return "ddd";
	}
}
