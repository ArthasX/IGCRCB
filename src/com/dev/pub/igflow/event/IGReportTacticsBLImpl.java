/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.dev.pub.igflow.event;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG334VWInfo;
import com.deliverik.framework.workflow.prd.model.condition.IG334SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCondImpl;
import com.deliverik.infogovernor.util.DisposeTimeForPrstatus;

/**
 * 概述：流程状态超时的实现BL
 * 功能描述：流程状态超时的实现BL
 * 创建记录：2014/06/17
 * (1)增加无表单关联的相应修正
 * 修改记录：
 */
public class IGReportTacticsBLImpl extends IGReportSuperTacticsBLImpl {

	static Log log = LogFactory.getLog(IGReportTacticsBLImpl.class);
	
	/**
	 * 流程状态策略判断的规则的事件
	 * 
	 * @param pdid 
	 * @param psdid 
	 * @throws BLException
	 */
	@Override
	public void regulation(String pdid, String psdid) throws BLException {
		//没有流程类型ID时不激活报告上级策略
		if(StringUtils.isEmpty(pdid)){
			log.debug("流程类型ID为不能为空。");
			return;
		}
		
		//超时提醒时间前的间隔时间单位：分钟
		Integer begintime = 5;//提前几分钟发送
		//流程策略设定信息查询
		IG334SearchCondImpl condIg334 = new IG334SearchCondImpl();
		condIg334.setPdid_like(pdid);
		List<IG334VWInfo> lstTactics = this.ig334BL.findByCondTactics(condIg334);
		
		//没有流程策略设定信息时不激活状态超时策略
		if(lstTactics == null || lstTactics.size() <= 0){
			log.debug("流程类型ID为【"+pdid +"】的流程没有流程通知策略设置。");
			return;
		}
		
		//增加pidid非表单相关的判断
		String pidid = lstTactics.get(0).getPidid();
		//表单名称
		String pidname = lstTactics.get(0).getPidname();
		
		//封装流程策略信息
		Map<String, Map<String, IG334VWInfo>> map = new LinkedHashMap<String, Map<String,IG334VWInfo>>();
		for (IG334VWInfo info : lstTactics) {
			if(map.get(info.getPsdcode()) != null){
				if(map.get(info.getPsdcode()).get(info.getPivalue()) == null){
					map.get(info.getPsdcode()).put(info.getPivalue(), info);
				}
			}else{
				Map<String, IG334VWInfo> mapIg334 = new LinkedHashMap<String, IG334VWInfo>();
				mapIg334.put(info.getPivalue(), info);
				map.put(info.getPsdcode(), mapIg334);
			}
		}
		
		//根据流程类型ID查询所有未关闭的流程
		IG500SearchCondImpl cond = new IG500SearchCondImpl();
		cond.setPrActive("Y");
		cond.setPrpdid(pdid);
		
		//流程状态信息
		if(StringUtils.isNotEmpty(psdid)){
			IG333Info ig333Info = this.ig333BL.searchIG333InfoByKey(psdid);
			cond.setPrstatus(ig333Info.getPsdcode());
		}
		
		//查询流程信息
		List<IG500Info> lstIG500Info = workFlowOperationBL.searchProcessRecord(cond);
		
		//没有未关闭流程不激活状态超时策略
		if(lstIG500Info != null && lstIG500Info.size() > 0){
			//当前状态处理时间
			Integer counttime = 0;
			//当前状态当前指定表单对应的超时时间
			Integer overtime = 0;
			//当前流程指定表单的值
			String pivalue = "";
			for (IG500Info info : lstIG500Info) {
				if(pidid.endsWith(IGPRDCONSTANTS.PROCESS_UNRELFORM_IDEND)){
					//通知策略与表单无关
					pivalue = IGPRDCONSTANTS.PROCESS_UNRELFORM_VALUE;
				} else {
					pivalue = flowSearchBL.searchPublicProcessInfo(info.getPrid(), pidname);
					pivalue = StringUtils.isEmpty(pivalue) ? "#" : pivalue;					
				}
				//获取当前状态的策略设定信息
				if(map.get(info.getPrstatus()) == null ){
					log.debug("流程【"+info.getPrtitle() +"】中的对应状态标识为【"+info.getPrstatus()+"】的状态没有超时流程策略的设置。");
					continue;
				}
				
				//获取指定状态下指定表单值对应的策略设定信息
				IG334VWInfo tactics = map.get(info.getPrstatus()).get(pivalue);
				
				//当前状态指定表单值对应的流程策略不存在时进入下一次循环
				if(tactics == null){
					if(pidid.endsWith(IGPRDCONSTANTS.PROCESS_UNRELFORM_IDEND)){
						//通知策略与表单无关
						log.debug("流程【"+info.getPrtitle() +"】中没有状态超时流程策略的设置。");
					} else {
						log.debug("流程【"+info.getPrtitle() +"】中的对应【"+pidname+"】中【"+("#".equals(pivalue) ? "缺省" :pivalue)+"】没有状态超时流程策略的设置。");
					}
					continue;
				}
				
				//计算当前状态的处理时间//新版本ig224表没有对应的prstatus所以不能用info.getPrstatus()
				if(IGPRDCONSTANTS.SUBSTATUS_CONFIRM_YES.equals(tactics.getPsdconfirm())){
					//状态有确认动作时，状态当前处理时间
					counttime = DisposeTimeForPrstatus.getCountTime(info.getPrid(), psdid, true);
				}else{
					//状态没有确认动作时，状态当前处理时间
					counttime = DisposeTimeForPrstatus.getCountTime(info.getPrid(), psdid, false);
				}
				
				//获取设定的超时时间
				if(tactics.getNotifyd() != null && tactics.getNotifyd() > 0){
					overtime += tactics.getNotifyd() * 24 * 60;
				}
				if(tactics.getNotifyh() != null && tactics.getNotifyh() > 0){
					overtime += tactics.getNotifyh() * 60;
				}
				if(tactics.getNotifym() != null && tactics.getNotifym() > 0){
					overtime += tactics.getNotifym();
				}
				
				//当前流程超时时间大于0时，激活动作提醒
				if(overtime > 0){
					//提前超时时间5分钟提醒处理人
					if(counttime >= overtime-begintime){
						this.event(tactics, info, begintime, false);
					}
					//记录超时状态和人员
					if(counttime > overtime){
						this.event(tactics, info, begintime, true);
					}
				}
			}//end for
		}//end if
	}
}