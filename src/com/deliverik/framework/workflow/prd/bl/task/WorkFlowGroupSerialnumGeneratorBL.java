/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.bl.task;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * <p>
 * 流程组实例工单号生成器HandlerBL
 * </p>
 */
public interface WorkFlowGroupSerialnumGeneratorBL extends BaseBL {

	/**
	 * 流程组实例工单号生成处理
	 * 
	 * @param pgdid 流程组定义ID
	 * @return 流程组实例工单号
	 * @throws BLException
	 */
	public String serialnumGenerator(String pgdid) throws BLException;

}
