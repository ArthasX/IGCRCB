/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.dev.crc.igflow.event.status;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.api.SysManageBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prr.bl.task.IG599BL;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.entity.IG599TB;

/***
 * 文档入库 文档编号表单值初始化   待发起后节点前处理
 *
 */
public class IGCRC0803BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL{
	
	/**日志对象取得*/
	static Log log = LogFactory.getLog(IGCRC0803BLImpl.class);
	
	/** 更新功能API类 */
	private FlowSetBL flowSetBL;

    /** 查询类功能API类 */
    private FlowSearchBL flowSearchBL;
    
    /** 流程查询功能API */
    private SysManageBL sysManageBL;
    
    /** 流程变量操作 */
	private IG599BL ig599BL;

	/**
	 * 流程变量操作设定
	 * 
	 * @param ig599bl
	 *            ig599BL
	 */
	public void setIg599BL(IG599BL ig599bl) {
		ig599BL = ig599bl;
	}
    
	/**
	 * 注入更新功能API类
	 * 
	 * @param flowSetBL
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	/**
	 * 注入查询功能API类
	 * 
	 * @param flowSearchBL
	 */
    public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
        this.flowSearchBL = flowSearchBL;
    }
      
    /**
     * 注入流程查询功能API
     * @param sysManageBL 流程查询功能API
     */
    public void setSysManageBL(SysManageBL sysManageBL) {
		this.sysManageBL = sysManageBL;
	}

	/**
     * 前处理
     */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		
	}

	/**
	 * 后处理
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		
		log.debug("======== 文档入库 文档编号表单值初始化   待发起后节点前处理 开始 ========");
		
		// 获取当前时间
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String date = formatter.format(new Date());
		String HEAD = "WD";
		//文档编号，年-月-日-序号(2位)
		//获取已有最大编号
		String maxSerialNum = ig599BL.searchMaxSerialnum(date, "文档编号");
		//如果没有编号或者不符合格式赋初始值
		if (null == maxSerialNum || maxSerialNum.length() != 12) {
			maxSerialNum = (HEAD + date + "01").trim();
		}else{
			//获取当前序号
			String num = maxSerialNum.substring(10).trim();
			//截取年-月-日
			String numStr = maxSerialNum.substring(2, 10);
			int maxNumber = Integer.valueOf(num) + 1;
			//添加序号 小于10时加零
			if(maxNumber < 10){
				maxSerialNum = HEAD + numStr + "0" + maxNumber;
			}else{
				maxSerialNum = HEAD + numStr + maxNumber;
			}
		}
		IG599SearchCondImpl cond = new IG599SearchCondImpl();
		cond.setPrid(bean.getLogInfo().getPrid());
		cond.setPivarname("文档编号");
		List<IG599Info> list = ig599BL.searchIG599InfosByCond(cond);
		if(list != null && list.size() > 0){
			IG599TB ig599TB = (IG599TB)SerializationUtils.clone(list.get(0));
			ig599TB.setPivarvalue(maxSerialNum);
			ig599BL.updateIG599Info(ig599TB);
		}

		log.debug("======== 文档入库 文档编号表单值初始化   待发起后节点前处理 结束========");
	}

}