/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.dev.qlb.igflow.generator.serialnum;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.resultset.ProcessRecordInfo;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowSerialnumGeneratorBL;


/**
 * 通用工单号生成器
 *
 * 2015-4-16
 */
public class IGPUBGENERATOR0101BLImpl extends BaseBLImpl implements
		WorkFlowSerialnumGeneratorBL {
	
	/** 查询类功能API类 */
	private FlowSearchBL flowSearchBL;
	/**
	 * 查询类功能API类设定
	 * @param flowSearchBL 查询类功能API类
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
		
		//根据流程ID查询流程基本信息
		List<ProcessRecordInfo> lst_ProcessInfo = this.flowSearchBL.searchProcessInfo(prid, null);
		String prpdid = lst_ProcessInfo.get(0).getPrpdid();
	   
		// 定义工单编号起始字符
        String processType = "WD";
        if(IGPUBGENERATORType.SERIALNUM_MAP.get(prpdid.substring(0,5)) != null){
        	processType = IGPUBGENERATORType.SERIALNUM_MAP.get(prpdid.substring(0,5));
        }
        
        // 获取当前日期
        String date = IGStringUtils.getCurrentDate();
        // 工单编号规则，编号 + YYYYMMDD + 两位顺序序号
        StringBuffer serialNum = new StringBuffer();
        serialNum.append(processType);
        serialNum.append(date.replaceAll("/", ""));
        
        String maxSerialNum = flowSearchBL.searchMaxSerialnum(String.valueOf(serialNum));
        //最大工单号为空时，顺序号默认为01
        if (null == maxSerialNum) {
            return serialNum + StringUtils.leftPad("1", 2, "0");
        }
        
       //最大工单号不为空时，顺序号加1
        String num = "";
        num = maxSerialNum.substring(maxSerialNum.length()-2);
        
        int maxNumber = Integer.valueOf(num) + 1;
        serialNum.append(StringUtils.leftPad(String.valueOf(maxNumber), 2, "0"));
        
        return String.valueOf(serialNum);
	}
}
