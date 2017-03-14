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
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.syslog.bl.IGLOG00BL;
import com.deliverik.infogovernor.syslog.dto.IGLOG00DTO;
import com.deliverik.infogovernor.syslog.form.IGLOG0002Form;
import com.deliverik.infogovernor.syslog.vo.IGLOG0002VO;

/**
 * 设备实时日志告警控制类
 * 2013.04.08 王省
 *
 */
public class IGLOG0002Action extends BaseAction{
	static Log log=LogFactory.getLog(IGLOG0001Action.class);
	
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		IGLOG0002Form form = (IGLOG0002Form)actionForm;
		IGLOG00BL ctrBL = (IGLOG00BL)getBean("iglog00BL");
		IGLOG00DTO dto = new IGLOG00DTO();
		
		//设置国际化
		dto.setLocale(this.getLocale(request));
		
		if("SEARCH".equals(mapping.getParameter())){
			log.debug("========设备日志告警信息查询处理开始========");
			//查询记录最大数值
			int maxCnt = getMaxDataCount("IGLOG0002");
			dto.setMaxSearchCount(maxCnt);
			
			getPaginDTO(request,"IGLOG0002");
			PagingDTO pDto;
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			if (request.getParameter("PAGING") == null) {
				pDto.setFromCount(0);
				form = (IGLOG0002Form) request.getSession().getAttribute("IGLOG0002Form");
				if (form !=null) {
					form.setFromCount(0);
				}
			}
			form.setPriority(request.getParameterValues("priority"));
			dto.setIglog0002Form(form);
			//分页Bean设置
			pDto.setPageDispCount(17);
			dto.setPagingDto(pDto);
			dto = ctrBL.searchHistorySysLogAlarmListAction(dto);
			dto = ctrBL.getAlarmPriority(dto);
			
			IGLOG0002VO vo = new IGLOG0002VO();
			vo.setHistorySysLogAlarmList(dto.getHistorySysLogAlarmList());
			//页面显示告警总数
			vo.setTotalcount(dto.getTotalcount());
			vo.setAlarmPrioritiesStr(dto.getAlarmPrioritiesStr());
			
			String[] string = form.getPriority();
			String checkedPrioritiesStr = "";
			if(string !=null && string.length !=0){
				for(String str:string){
					checkedPrioritiesStr = checkedPrioritiesStr + str + "&";
				}
			}
			vo.setCheckedPrioritiesStr(checkedPrioritiesStr);
			super.<IGLOG0002VO>setVO(request, vo);
			
			if("yes".equals(request.getParameter("report"))){
				//把符合搜索条件的所有告警都导出，而不只是当前页
				dto = ctrBL.searchHistorySysLogAlarmListNopageAction(dto);
				vo.setHistorySysLogAlarmList(dto.getHistorySysLogAlarmList());
				request.setAttribute("vo", vo);
				request.setAttribute("form", form);
				return mapping.findForward("REPORT");
			}
			
			log.debug("========设备日志告警信息查询处理终了========");
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
