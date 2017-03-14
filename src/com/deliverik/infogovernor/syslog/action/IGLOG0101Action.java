/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.syslog.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.syslog.bl.IGLOG01BL;
import com.deliverik.infogovernor.syslog.dto.IGLOG01DTO;
import com.deliverik.infogovernor.syslog.form.IGLOG0101Form;
import com.deliverik.infogovernor.syslog.vo.IGLOG0101VO;

/**
 * 设备实时日志控制类
 * 2013.04.08 王省
 * 修改:2013.08.14
 */
public class IGLOG0101Action extends BaseAction{
	static Log log=LogFactory.getLog(IGLOG0101Action.class);
	
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		IGLOG0101Form form = (IGLOG0101Form)actionForm;
		IGLOG01BL ctrBL = (IGLOG01BL)getBean("iglog01BL");
		IGLOG01DTO dto = new IGLOG01DTO();
		
		//设置国际化
		dto.setLocale(this.getLocale(request));
		IGLOG0101VO vo = new IGLOG0101VO();
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setUser(user);
		if("SEARCH".equals(mapping.getParameter())){
			log.debug("========设备日志信息查询处理开始========");
			
			//查询记录最大数值
			String maxcount = ResourceUtility.getString("SYSLOG_NUM");
			if(StringUtils.isEmpty(maxcount)) maxcount = "500";
			int maxCnt = Integer.parseInt(maxcount);
			form.setPriority(request.getParameterValues("priority"));
			dto.setMaxSearchCount(maxCnt);
			
			dto.setIglog0101Form(form);
			dto = ctrBL.searchSysLogListAction(dto);
			dto = ctrBL.searchSysLogAlarmListActionWithProcess(dto);
			dto = ctrBL.getAlarmPriority(dto);
			dto = ctrBL.getRefreshRate(dto);
			dto = ctrBL.getAlarmTotalcount(dto);
			dto = ctrBL.searchUserRole(dto);
			String[] string = form.getPriority();
			String checkedPrioritiesStr = "";
			if(string !=null && string.length !=0){
				for(String str:string){
					checkedPrioritiesStr = checkedPrioritiesStr + str + "&";
				}
			}
			
			//设定syslog日志列表
			vo.setSysLogList(dto.getSysLogList());
			//设定带流程的syslog日志列表（在页面中显示）
			vo.setList_vo(dto.getList_vo());
			//设定已选的告警级别拼接成的字符串
			vo.setCheckedPrioritiesStr(checkedPrioritiesStr);
			
			vo.setAlarmPrioritiesList(dto.getAlarmPrioritiesList());
			//设定告警级别拼接成的字符串
			vo.setAlarmPrioritiesStr(dto.getAlarmPrioritiesStr());
			//设定刷新频率
			vo.setRefreshRate(dto.getRefreshRate());
			//设定告警总数
			vo.setTotalcount(dto.getTotalcount());
			vo.setIsMaintain(dto.getIsMaintain());
			if("yes".equals(request.getParameter("isquery"))){
				form.setIsquery("yes");
			}else{
				form.setIsquery("");
			}
			
			if("yes".equals(request.getParameter("report"))){
				request.setAttribute("vo", vo);
				request.setAttribute("form", form);
				return mapping.findForward("REPORT");
			}
			
			log.debug("========设备日志信息查询处理终了========");
		}else if("FIX".equals(mapping.getParameter())){
			log.debug("========设备日志告警信息修复处理开始========");
			
			dto.setIglog0101Form(form);
			
			dto = ctrBL.FixSysLogAlarmsAction(dto);
			
			request.setAttribute("fixflag", "yes");
			
			log.debug("========设备日志告警信息修复处理开始========");
		}else if("FILTER_DISP".equals(mapping.getParameter())){
			log.debug("=======设备日志屏蔽初期页面显示处理开始=======");
			
			dto.setIglog0101Form(form);
			
			dto = ctrBL.getSysLogBean(dto);
			
			vo.setSyslogbean(dto.getSyslogbean());
			
			
			log.debug("=======设备日志屏蔽初期页面显示处理结束=======");
		}else if("FILTER".equals(mapping.getParameter())){
			log.debug("=======设备日志屏蔽处理开始=======");
			
			dto.setIglog0101Form(form);
			dto = ctrBL.doFilter(dto);
			
			log.debug("=======设备日志屏蔽处理结束=======");
		}
		super.<IGLOG0101VO>setVO(request, vo);
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		if(StringUtils.isNotEmpty(form.getIsRealTimeCollect())&&"1".equals(form.getIsRealTimeCollect())){		// 汇总实时告警信息标识
			return mapping.findForward("COLLECT");
		}
		return mapping.findForward("DISP");
	}

}
