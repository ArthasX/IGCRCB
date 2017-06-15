/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * �豸ʵʱ��־�澯������
 * 2013.04.08 ��ʡ
 *
 */
public class IGLOG0001Action extends BaseAction{
	static Log log=LogFactory.getLog(IGLOG0001Action.class);
	
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		IGLOG0001Form form = (IGLOG0001Form)actionForm;
		IGLOG00BL ctrBL = (IGLOG00BL)getBean("iglog00BL");
		IGLOG00DTO dto = new IGLOG00DTO();
		
		//���ù��ʻ�
		dto.setLocale(this.getLocale(request));
		//��ѯ��¼�����ֵ
		int maxCnt = getMaxDataCount("IGLOG0001");
		dto.setMaxSearchCount(maxCnt);
		
		if("SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())){
			log.debug("========�豸��־�澯��Ϣ��ѯ����ʼ========");
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
			//ҳ����ʾ�澯����
			vo.setTotalcount(dto.getTotalcount());
			super.<IGLOG0001VO>setVO(request, vo);
			
			if("yes".equals(request.getParameter("isquery"))){
				form.setIsquery("yes");
			}else{
				form.setIsquery("");
			}
			
			log.debug("========�豸��־�澯��Ϣ��ѯ��������========");
		}else if("FIX".equals(mapping.getParameter())){
			log.debug("========�豸��־�澯��Ϣ�޸�����ʼ========");
			
			dto.setIglog0001Form(form);
			dto = ctrBL.FixSysLogAlarmsAction(dto);
			request.setAttribute("fixflag", "yes");
			log.debug("========�豸��־�澯��Ϣ�޸�����ʼ========");
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
