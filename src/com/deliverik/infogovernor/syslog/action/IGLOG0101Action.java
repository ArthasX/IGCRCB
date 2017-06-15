/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * �豸ʵʱ��־������
 * 2013.04.08 ��ʡ
 * �޸�:2013.08.14
 */
public class IGLOG0101Action extends BaseAction{
	static Log log=LogFactory.getLog(IGLOG0101Action.class);
	
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		IGLOG0101Form form = (IGLOG0101Form)actionForm;
		IGLOG01BL ctrBL = (IGLOG01BL)getBean("iglog01BL");
		IGLOG01DTO dto = new IGLOG01DTO();
		
		//���ù��ʻ�
		dto.setLocale(this.getLocale(request));
		IGLOG0101VO vo = new IGLOG0101VO();
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setUser(user);
		if("SEARCH".equals(mapping.getParameter())){
			log.debug("========�豸��־��Ϣ��ѯ����ʼ========");
			
			//��ѯ��¼�����ֵ
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
			
			//�趨syslog��־�б�
			vo.setSysLogList(dto.getSysLogList());
			//�趨�����̵�syslog��־�б���ҳ������ʾ��
			vo.setList_vo(dto.getList_vo());
			//�趨��ѡ�ĸ澯����ƴ�ӳɵ��ַ���
			vo.setCheckedPrioritiesStr(checkedPrioritiesStr);
			
			vo.setAlarmPrioritiesList(dto.getAlarmPrioritiesList());
			//�趨�澯����ƴ�ӳɵ��ַ���
			vo.setAlarmPrioritiesStr(dto.getAlarmPrioritiesStr());
			//�趨ˢ��Ƶ��
			vo.setRefreshRate(dto.getRefreshRate());
			//�趨�澯����
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
			
			log.debug("========�豸��־��Ϣ��ѯ��������========");
		}else if("FIX".equals(mapping.getParameter())){
			log.debug("========�豸��־�澯��Ϣ�޸�����ʼ========");
			
			dto.setIglog0101Form(form);
			
			dto = ctrBL.FixSysLogAlarmsAction(dto);
			
			request.setAttribute("fixflag", "yes");
			
			log.debug("========�豸��־�澯��Ϣ�޸�����ʼ========");
		}else if("FILTER_DISP".equals(mapping.getParameter())){
			log.debug("=======�豸��־���γ���ҳ����ʾ����ʼ=======");
			
			dto.setIglog0101Form(form);
			
			dto = ctrBL.getSysLogBean(dto);
			
			vo.setSyslogbean(dto.getSyslogbean());
			
			
			log.debug("=======�豸��־���γ���ҳ����ʾ�������=======");
		}else if("FILTER".equals(mapping.getParameter())){
			log.debug("=======�豸��־���δ���ʼ=======");
			
			dto.setIglog0101Form(form);
			dto = ctrBL.doFilter(dto);
			
			log.debug("=======�豸��־���δ������=======");
		}
		super.<IGLOG0101VO>setVO(request, vo);
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		if(StringUtils.isNotEmpty(form.getIsRealTimeCollect())&&"1".equals(form.getIsRealTimeCollect())){		// ����ʵʱ�澯��Ϣ��ʶ
			return mapping.findForward("COLLECT");
		}
		return mapping.findForward("DISP");
	}

}
