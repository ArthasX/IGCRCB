/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.dev.cyb.igflow.generator.serialnum;

import java.util.Calendar;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowSerialnumGeneratorBL;

/**
 * <p>
 * 机房访问申请(内) 工单号生成器
 * </p>
 */
public class IGGENERATOR0106BLImpl extends BaseBLImpl implements
		WorkFlowSerialnumGeneratorBL {
	/** 查询类功能API类 */
	private FlowSearchBL flowSearchBL;
	/**
	 * 注入flowSearchBL
	 * @param flowSearchBL
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}
	
	/**
	 * 流程工单号生成处理
	 * 
	 * @param 流程ID
	 * @return 流程工单号
	 * @throws BLException
	 */
	public String serialnumGenerator(Integer prid) throws BLException {
	    // 定义工单编号起始字符
        String processType = "RP";
        
        // 获取当前日期
        Calendar date = Calendar.getInstance();
        String sermonth = StringUtils.leftPad(String.valueOf(date.get(Calendar.MONTH) + 1), 2, "0");        //月
        String serday = StringUtils.leftPad(String.valueOf(date.get(Calendar.DAY_OF_MONTH)), 2, "0");   //日
        
        // 工单编号规则，I + 年（后两位） + 月（两位） + 日（两位） + 三位顺序序号
        StringBuffer serialNum = new StringBuffer();
        serialNum.append(processType);
        serialNum.append(String.valueOf(date.get(Calendar.YEAR)));
        serialNum.append(sermonth);
        serialNum.append(serday);
        
        String maxSerialNum = flowSearchBL.searchMaxSerialnum(String.valueOf(serialNum));
        if (null == maxSerialNum) {
            return serialNum + StringUtils.leftPad("1", 2, "0");
        }
        String num = "";
        num = maxSerialNum.substring(10);
        
        int maxNumber = Integer.valueOf(num) + 1;
        serialNum.append(StringUtils.leftPad(String.valueOf(maxNumber), 2, "0"));
        
        return String.valueOf(serialNum);
	}
}
