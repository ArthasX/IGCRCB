package com.deliverik.infogovernor.svc.action;

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
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.infogovernor.svc.bl.IGSVC07BL;
import com.deliverik.infogovernor.svc.dto.IGSVC07DTO;
import com.deliverik.infogovernor.svc.form.IGSVC0602Form;
import com.deliverik.infogovernor.svc.vo.IGSVC05131VO;

public class IGSVC0611Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSVC0611Action.class);
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		

		//BL取得
		IGSVC07BL svcBL = (IGSVC07BL) getBean("igsvc07BL");
		
		IGSVC0602Form form = (IGSVC0602Form)actionForm;
		
		IGSVC07DTO dto = new IGSVC07DTO();
		
		if( "DISP".equals(mapping.getParameter())){

			log.debug("========业务运行报告画面初期显示处理开始========");
			form.setCurrentyear(IGStringUtils.getCurrentYear());
			log.debug("========业务运行报告画面初期显示处理终了========");
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			
			log.debug("========业务运行报告画面再显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========业务运行报告画面再显示处理终了========");
			return mapping.findForward("DISP");
		}if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){

			log.debug("========业务运行处理开始========");
			if ("SEARCH1".equals(mapping.getParameter())){
				
				form = (IGSVC0602Form) req.getSession().getAttribute("IGSVC0602Form");
				if ( form == null ) {
					form = new IGSVC0602Form();
				}
			}
			req.setAttribute("form", form);
			dto.setProcessSummarySearchCond(form);
			dto = svcBL.findSummaryOfYear(dto);
			IGSVC05131VO vo = new IGSVC05131VO();
			vo.setProcessSummaryList(dto.getProcessSummaryList());
			req.setAttribute("vo", vo);
			
			log.debug("========业务运行处理终了========");
			if(StringUtils.isNotEmpty(req.getParameter("report4"))) {
				return mapping.findForward("REPORT4");
			}
		}
		
		return mapping.findForward("DISP");
	}

}
