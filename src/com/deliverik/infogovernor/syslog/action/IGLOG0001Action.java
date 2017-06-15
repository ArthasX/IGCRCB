/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.syslog.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.syslog.bl.IGLOG00BL;
import com.deliverik.infogovernor.syslog.dto.IGLOG00DTO;
import com.deliverik.infogovernor.syslog.form.IGLOG0001Form;
import com.deliverik.infogovernor.syslog.vo.IGLOG0001VO;

/**
 * 设备实时日志告警控制类
 * 2013.04.08 王省
 *
 */
public class IGLOG0001Action extends BaseAction{
	static Log log=LogFactory.getLog(IGLOG0001Action.class);
	
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		IGLOG0001Form form = (IGLOG0001Form)actionForm;
		IGLOG00BL ctrBL = (IGLOG00BL)getBean("iglog00BL");
		IGLOG00DTO dto = new IGLOG00DTO();
		
		//设置国际化
		dto.setLocale(this.getLocale(request));
		//查询记录最大数值
		int maxCnt = getMaxDataCount("IGLOG0001");
		dto.setMaxSearchCount(maxCnt);
		
		if("SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())){
			log.debug("========设备日志告警信息查询处理开始========");
			if("yes".equals(request.getAttribute("fixflag"))){
				form.setIds(null);
			}
			form.setPriority(request.getParameterValues("priority"));
			request.setAttribute("fixflag", null);
			dto.setIglog0001Form(form);
			dto = ctrBL.searchSysLogAlarmListAction(dto);
			dto = ctrBL.getAlarmPriority(dto);
			dto = ctrBL.searchSysLogAlarmListActionWithProcess(dto);
			dto = ctrBL.getRefreshRate(dto);
			//String alarmstate = form.getAlarmstate();
//			if(!"2".equals(alarmstate))
				request.setAttribute("showFixButton", true);
//			else
//				request.setAttribute("showFixButton", false);
			IGLOG0001VO vo = new IGLOG0001VO();
			vo.setSysLogAlarmList(dto.getSysLogAlarmList());
			vo.setList_vo(dto.getList_vo());
			vo.setAlarmPrioritiesList(dto.getAlarmPrioritiesList());
			vo.setAlarmPrioritiesStr(dto.getAlarmPrioritiesStr());
			vo.setRefreshRate(dto.getRefreshRate());
			
			String[] string = form.getPriority();
			String checkedPrioritiesStr = "";
			if(string !=null && string.length !=0){
				for(String str:string){
					checkedPrioritiesStr = checkedPrioritiesStr + str + "&";
				}
			}
			vo.setCheckedPrioritiesStr(checkedPrioritiesStr);
			//页面显示告警总数
			vo.setTotalcount(dto.getTotalcount());
			super.<IGLOG0001VO>setVO(request, vo);
			
			if("yes".equals(request.getParameter("isquery"))){
				form.setIsquery("yes");
			}else{
				form.setIsquery("");
			}
			
			log.debug("========设备日志告警信息查询处理终了========");
		}else if("FIX".equals(mapping.getParameter())){
			log.debug("========设备日志告警信息修复处理开始========");
			
			dto.setIglog0001Form(form);
			dto = ctrBL.FixSysLogAlarmsAction(dto);
			request.setAttribute("fixflag", "yes");
			log.debug("========设备日志告警信息修复处理开始========");
		}
		
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}

}
