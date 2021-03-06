/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.dev.ext.igflow.event.status;

import java.util.List;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prd.bl.task.IG333BL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.smr.bl.IGSMRCONSTANT;
import com.deliverik.infogovernor.smr.bl.task.RegulatoryReportDetailBL;
import com.deliverik.infogovernor.smr.bl.task.RegulatoryReportInstanceBL;
import com.deliverik.infogovernor.smr.model.RegulatoryReportDetailInfo;
import com.deliverik.infogovernor.smr.model.RegulatoryReportInstanceInfo;
import com.deliverik.infogovernor.smr.model.condition.RegulatoryReportDetailSearchCondImpl;
import com.deliverik.infogovernor.smr.model.entity.RegulatoryReportInstanceTB;

/**
 * 概述:一级审批后处理 
 * 功能描述：一级审批后处理
 * 创建人：赵梓廷
 * 创建记录： 2013-08-02
 * 修改记录：
 */
public class IGEVENT1403BLImpl extends BaseBLImpl implements
		WorkFlowEventHandlerBL {

	static Log log = LogFactory.getLog(IGEVENT1405BLImpl.class);
	
	private IG500BL ig500BL;
	
	/** 流程状态定义 */
	protected IG333BL ig333BL;
	
	private RegulatoryReportDetailBL regulatoryReportDetailBL;
	
	private RegulatoryReportInstanceBL regulatoryReportInstanceBL;
		
	public void setIg500BL(IG500BL ig500bl) {
		ig500BL = ig500bl;
	}

	public void setRegulatoryReportDetailBL(
			RegulatoryReportDetailBL regulatoryReportDetailBL) {
		this.regulatoryReportDetailBL = regulatoryReportDetailBL;
	}

	public void setRegulatoryReportInstanceBL(
			RegulatoryReportInstanceBL regulatoryReportInstanceBL) {
		this.regulatoryReportInstanceBL = regulatoryReportInstanceBL;
	}


	/**
	 *流程状态定义设定
	 */
	public void setIg333BL(IG333BL ig333BL) {
		this.ig333BL = ig333BL;
	}

	/**
	 * 后处理改变实例状态
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		log.debug("========判断是否改变年报状态处理开始========");
		//实例化查询条件
		RegulatoryReportDetailSearchCondImpl cond = new RegulatoryReportDetailSearchCondImpl();
		cond.setPrid(bean.getLogInfo().getPrid());
		List<RegulatoryReportDetailInfo> list_ttd = regulatoryReportDetailBL.searchRegulatoryReportDetailInfo(cond);
		//遍历集合得到实例id
		Integer instanceid = 0;
		for(RegulatoryReportDetailInfo info:list_ttd){
			instanceid = info.getInstanceID();
			break;
		}
		//判断点击的按钮是审批通过还是驳回
		IG333Info info333 = ig333BL.searchIG333InfoByKey(bean.getAfstatus());
		//是否是审批通过标识
		String target ="0";
		//判断当前流程状态
		if(IGSMRCONSTANT.PRSTATUSNAME_SECONDEXAMINE.equals(info333.getPsdname())){
			target = "1";
		}else if(IGSMRCONSTANT.PRSTATUSNAME_SECONDE.equals(info333.getPsdname())){
			target = "1";
		}else if(IGSMRCONSTANT.PRSTATUSNAME_IRREGULAREXAMINE.equals(info333.getPsdname())){
			target = "1";
		}else if(IGSMRCONSTANT.PRSTATUSNAME_MONTHSECONDE.equals(info333.getPsdname())){
			target = "1";
		}
		if("1".equals(target)){
			//定义全部为二级审批状态的标识
			String mark = "0";		
			//根据实例id查询所有实例下的流程状态是否都是二级审批
			//实例化查询条件
			RegulatoryReportDetailSearchCondImpl cond_rrd = new RegulatoryReportDetailSearchCondImpl();
			cond_rrd.setInstanceID(instanceid);
			List<RegulatoryReportDetailInfo> list = regulatoryReportDetailBL.searchRegulatoryReportDetailInfo(cond_rrd);
			//遍历集合根据流程id查询流程状态
			for(RegulatoryReportDetailInfo rrd:list){
				if(rrd.getPrid().toString().equals(bean.getLogInfo().getPrid().toString())){
					continue;
				}
				IG500Info ig = ig500BL.searchIG500InfoByKey(rrd.getPrid());
				IG333SearchCondImpl ig333cond = new IG333SearchCondImpl();
				ig333cond.setPdid(ig.getPrpdid());
				ig333cond.setPsdcode(ig.getPrstatus());
				IG333Info ig333 = ig333BL.searchIG333Info(ig333cond).get(0);
				String flag = "";
				if(IGSMRCONSTANT.PRYTPE_REPORT.equals(ig.getPrtype())){
					flag = IGSMRCONSTANT.PRSTATUSNAME_SECONDEXAMINE;
				}else if(IGSMRCONSTANT.PRYTPE_QUARTER.equals(ig.getPrtype())){
					flag = IGSMRCONSTANT.PRSTATUSNAME_SECONDE;
				}else if(IGSMRCONSTANT.PRTYPE_IRREGULAR.equals(ig.getPrtype())){
					flag = IGSMRCONSTANT.PRSTATUSNAME_IRREGULAREXAMINE;
				}else{
					flag = IGSMRCONSTANT.PRSTATUSNAME_MONTHSECONDE;
				}
				if(!flag.equals(ig333.getPsdname())){
					mark ="1";
					break;
				}
				
			}
			if(mark.equals("0")){
				RegulatoryReportInstanceInfo rri = regulatoryReportInstanceBL.searchRegulatoryReportInstanceInfoByPK(instanceid);
				RegulatoryReportInstanceTB tb = (RegulatoryReportInstanceTB)SerializationUtils.clone(rri);
				tb.setStatus("1");
				regulatoryReportInstanceBL.updateRegulatoryReportInstanceInfo(tb);
			}
		}
		
		log.debug("========判断是否改变年报状态处理开始========");
		
	}

	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo arg0)
			throws BLException {
		

	}

}
