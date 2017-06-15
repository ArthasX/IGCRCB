/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.dev.crc.igflow.init.form;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.WorkFlowParameterInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowInitFormHandlerBL;
import com.deliverik.infogovernor.asset.bl.task.RiskIndexSearchVWBL;
import com.deliverik.infogovernor.asset.model.RiskIndexSearchVWInfo;
import com.deliverik.infogovernor.asset.model.condition.RiskIndexSearchVWSearchCondImpl;
import com.deliverik.infogovernor.ven.bl.task.MonitoringWorkBL;
import com.deliverik.infogovernor.ven.bl.task.RiskMonitoringBL;
import com.deliverik.infogovernor.ven.model.MonitoringWorkInfo;

/***
 * 监测指派工作待发起节点的表单初始化
 * @time 2014/06/19
 * @author shikailong
 * @version 1.0
 * @mail shikailong@deliverik.com
 */
public class IGVEN0102BLImpl extends BaseBLImpl implements
		WorkFlowInitFormHandlerBL {
	
	static Log log = LogFactory.getLog(IGVEN0102BLImpl.class);
	
	/** 风险监测BL*/
	private MonitoringWorkBL monitoringWorkBL;
	
	/** 风险监测任务BL*/
	private RiskMonitoringBL riskMonitoringBL;
	
	/** 风险指标视图BL*/
	private RiskIndexSearchVWBL riskIndexSearchVWBL;
	
	/**
	 * 风险监测BL设定
	 * @param monitoringWorkBL the 风险监测BL
	 */
	public void setMonitoringWorkBL(MonitoringWorkBL monitoringWorkBL) {
		this.monitoringWorkBL = monitoringWorkBL;
	}

	/**
	 * 风险指标视图BL设定
	 * @param riskIndexSearchVWBL the 风险指标视图BL
	 */
	public void setRiskIndexSearchVWBL(RiskIndexSearchVWBL riskIndexSearchVWBL) {
		this.riskIndexSearchVWBL = riskIndexSearchVWBL;
	}

	/**
	 * 风险监测任务BL设定
	 * @param riskMonitoringBL the 风险监测任务BL
	 */
	public void setRiskMonitoringBL(RiskMonitoringBL riskMonitoringBL) {
		this.riskMonitoringBL = riskMonitoringBL;
	}

	/**
	 * 风险监测指派工作发起节点的表单初始化
	 * @param param 流程处理参数接口
	 * @return 表单值集合（<名称-值>）
	 */
	public Map<String, Object> initForm(WorkFlowParameterInfo param)
			throws BLException {		
		log.debug("======== 风险监测指派工作初始化处理开始   ========");
		//表单值集合返回对象
		Map<String, Object> map = new HashMap<String, Object>();
		//如果主流程id不为空，说明该问题整改流程是从别的流程发起的
		String str =  param.getParameters();
		Pattern pattern = Pattern.compile("[0-9]*"); 
		if(StringUtils.isNotBlank(str) && pattern.matcher(str).matches()){
			Integer mtid = Integer.parseInt(str);
			MonitoringWorkInfo info = monitoringWorkBL.searchMonitoringWorkByPK(mtid);
			Integer eiid = info.getRiid();
			if(eiid!=null && !(eiid.equals("0"))){
				RiskIndexSearchVWSearchCondImpl cond = new RiskIndexSearchVWSearchCondImpl();
				cond.setEiid(eiid.toString());
				cond.setSyscoding("999019");
				List<RiskIndexSearchVWInfo> vwInfo = riskIndexSearchVWBL.searchRiskIndexSearchVW(cond);
				if(vwInfo!=null&& vwInfo.size()>0){
					map.put("指标编号", vwInfo.get(0).getEilabel());
					map.put("风险领域", vwInfo.get(0).getRiskly());
					map.put("风险项", vwInfo.get(0).getRiskitem());
					map.put("风险子域", vwInfo.get(0).getRiskarea());
					map.put("人员", vwInfo.get(0).getRiskarea());
				}
			}
			map.put("风险监测任务名称", riskMonitoringBL.searchRiskMonitoringByPK(info.getRmid()).getRmname());
		}
		log.debug("======== 风险监测指派工作表单初始化处理结束   ========");
		return map;
	}
}
