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
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.syslog.bl.IGLOG01BL;
import com.deliverik.infogovernor.syslog.dto.IGLOG01DTO;
import com.deliverik.infogovernor.syslog.form.IGLOG0102Form;
import com.deliverik.infogovernor.syslog.vo.IGLOG0102VO;

/**
 * �豸��ʷ��־������
 * 2013.04.08 ��ʡ
 *
 */
public class IGLOG0102Action extends BaseAction{
	static Log log=LogFactory.getLog(IGLOG0101Action.class);
	
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		IGLOG0102Form form = (IGLOG0102Form)actionForm;
		IGLOG01BL ctrBL = (IGLOG01BL)getBean("iglog01BL");
		IGLOG01DTO dto = new IGLOG01DTO();
		
		//���ù��ʻ�
		dto.setLocale(this.getLocale(request));
		
		if("SEARCH".equals(mapping.getParameter())){
			
			log.debug("========�豸��־��Ϣ��ѯ����ʼ========");

			form.setId(null);
			//��ѯ��¼�����ֵ
			int maxCnt = getMaxDataCount("IGLOG0102");
			form.setPriority(request.getParameterValues("priority"));
			dto.setMaxSearchCount(maxCnt);
			getPaginDTO(request,"IGLOG0102");
			PagingDTO pDto;
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			if (request.getParameter("PAGING") == null) {
				pDto.setFromCount(0);
				form = (IGLOG0102Form) request.getSession().getAttribute("IGLOG0102Form");
				if (form !=null) {
					form.setFromCount(0);
				}
			}
			dto.setIglog0102Form(form);
			pDto.setPageDispCount(30);
			dto.setPagingDto(pDto);
			dto = ctrBL.searchHistorySysLogListAction(dto);
			dto = ctrBL.searchSysLogHistoryAlarmListActionWithProcess(dto);
			dto = ctrBL.getAlarmPriority(dto);
			dto=ctrBL.getCodeList(dto);
			String[] string = form.getCvalue();
			String checkedPrioritiesStr = "";
			if(string !=null && string.length !=0){
				for(String str:string){
					checkedPrioritiesStr = checkedPrioritiesStr + str + "&";
				}
			}
			
			IGLOG0102VO vo = new IGLOG0102VO();
			vo.setRuleli(dto.getRuleli());
			vo.setHistorySysLogList(dto.getHistorySysLogList());
			vo.setCheckedPrioritiesStr(checkedPrioritiesStr);
			vo.setAlarmPrioritiesList(dto.getAlarmPrioritiesList());
			vo.setAlarmPrioritiesStr(dto.getAlarmPrioritiesStr());
			vo.setList_vo(dto.getList_vo());
			form.setCvalue(null);
			super.<IGLOG0102VO>setVO(request, vo);
			
			if("yes".equals(request.getParameter("report"))){
				//�ѷ����������������и澯������������ֻ�ǵ�ǰҳ
				dto = ctrBL.searchHistorySysLogListNopageAction(dto);
				vo.setHistorySysLogList(dto.getHistorySysLogList());
				request.setAttribute("vo", vo);
				request.setAttribute("form", form);
				return mapping.findForward("REPORT");
			}
			
			
			log.debug("========�豸��־��Ϣ��ѯ��������========");
		}
		
		if("DELETE".equals(mapping.getParameter()))
		{   
//			form = (IGLOG0102Form) request.getSession().getAttribute("IGLOG0102Form");
			
			dto.setIglog0102Form(form);
			//��ѯѡ���sysylogҳ����Ϣ;
			dto=ctrBL.searchHistoryChecked(dto);
			//��ѯѡ���syslog���α���Ϣ;
			dto=ctrBL.findAllMS00013(dto);
			//mss00013���̨ɾ���߼�
			ctrBL.delete00013TB(dto);
			form.reset(mapping, request);
			log.info("Mss00013ɾ���߼�����");
		}
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
