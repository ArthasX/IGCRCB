/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.dev.crc.igflow.event.status;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.resultset.ProcessRecordInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 问题流程处理节点前处理
 * </p>
 * <strong> 如果正常驳回，清空所有人处理时间，如果是等待程序开发节点正常跃迁，清空当前处理人的处理时间 </strong>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGCRC0301BLImpl extends BaseBLImpl implements
		WorkFlowEventHandlerBL {

	/** 日志对象取得 */
	protected static final Log log = LogFactory.getLog(IGCRC0301BLImpl.class);
	
	/** 查询类API */
	protected FlowSearchBL flowSearchBL;

	/** 更新类API */
	protected FlowSetBL flowSetBL;

	/**
	 * 查询类API设定
	 * @param flowSearchBL 查询类API
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	/**
	 * 更新类API设定
	 * 
	 * @param flowSetBL
	 *            更新类API
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	/**
	 * 前处理
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		log.debug("==============清空当前处理用户的处理时间开始===============");
		if (bean.getBfstatus().equals("0108301007")) {
			//查询子流程发起人
			List<Integer> list = flowSearchBL.searchProcessRelationForCld(bean.getLogInfo().getPrid());
			if(list != null && list.size() > 0){
				ProcessRecordInfo info = null;
				long l = 0;
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
				for(Integer prid:list){
					List<ProcessRecordInfo> prs = flowSearchBL.searchProcessInfo(prid, null);
					String time = prs.get(0).getPrclosetime();
					try {
						Date d = sdf.parse(time);
						if(d.getTime() > l){
							l = d.getTime();
							info = prs.get(0);
						}
					} catch (ParseException e) {
						log.error("",e);
					}
				}
				flowSetBL.setStatusParticipantRehandle(bean.getLogInfo().getPrid(),
						"问题处理", info.getPrroleid(), info.getPruserid());
			}
		} else {
			flowSetBL.setStatusParticipantAllRehandle(bean.getLogInfo()
					.getPrid(), bean.getAfstatus());
		}
		log.debug("==============清空当前处理用户的处理时间结束===============");
	}

	/**
	 * 后处理
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {

	}

}
