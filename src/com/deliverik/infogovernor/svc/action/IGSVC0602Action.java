package com.deliverik.infogovernor.svc.action;

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
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.infogovernor.svc.bl.IGPROCESSType;
import com.deliverik.infogovernor.svc.bl.IGSVC07BL;
import com.deliverik.infogovernor.svc.dto.IGSVC06DTO;
import com.deliverik.infogovernor.svc.dto.IGSVC07DTO;
import com.deliverik.infogovernor.svc.form.IGSVC0602Form;
import com.deliverik.infogovernor.svc.vo.IGSVC05131VO;
import com.deliverik.infogovernor.util.CodeDefine;

public class IGSVC0602Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSVC0602Action.class);
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		

		//BL取得
		IGSVC07BL svcBL = (IGSVC07BL) getBean("igsvc07BL");
		
		IGSVC0602Form form = (IGSVC0602Form)actionForm;
		
		IGSVC06DTO dto = new IGSVC06DTO();
		
		if( "DISP".equals(mapping.getParameter())){

			log.debug("========业务运行报告画面初期显示处理开始========");
//			req.setAttribute("IGSVC0602Form", form);
//			
//			addMessage(req, new ActionMessage("IGCO10000.I001","业务运行报告"));
			log.debug("========业务运行报告画面初期显示处理终了========");
			return mapping.findForward("DISP");
		} else if( "POPDISP".equals(mapping.getParameter())){

			log.debug("========业务运行报告画面初期显示处理开始========");
//			req.setAttribute("IGSVC0602Form", form);
//			
//			addMessage(req, new ActionMessage("IGCO10000.I001","业务运行报告"));
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
			String type = req.getParameter("type");
			String type1 = req.getParameter("type1");
			if (!StringUtils.isEmpty(type1)) {
				type = type1;
			}
			CodeDetailBL bl = (CodeDetailBL) getBean("codeDetailBL");
	        CodeDetailSearchCondImpl condimpl = new CodeDetailSearchCondImpl();
	        condimpl.setCcid(CodeDefine.PRPDID.getCcid());
	        List<CodeDetail> cds = bl.searchCodeDetail(condimpl,CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_0);
	        for(CodeDetail cd:cds){
	            if(cd.getCdinfo().equals(IGPROCESSType.getTypeName(IGPROCESSType.INCIDENT_PRTYPE))){
                    form.setIpdid(cd.getCvalue());
                }else if (cd.getCdinfo().equals(IGPROCESSType.getTypeName(IGPROCESSType.PROBLEM_PRTYPE))) {
                    form.setPpdid(cd.getCvalue());
                }else if (cd.getCdinfo().equals(IGPROCESSType.getTypeName(IGPROCESSType.CHANGE_PRTYPE))) {
                    form.setCpdid(cd.getCvalue());
                }else if (cd.getCdinfo().equals(IGPROCESSType.getTypeName(IGPROCESSType.SERVICE_PRTYPE))) {
                    form.setSpdid(cd.getCvalue());
                }
	        }
			if("003".equals(type)){
				
				form.setPrassetcategory(type);
				
				dto.setProcesscountsearchcond(form);
				dto.setPrassetcategory(type);
				
				dto = svcBL.findSummaryCountForOperation(dto);
				
				IGSVC05131VO igsvc05131vo = new IGSVC05131VO();
				
				igsvc05131vo.setProcessCountList(dto.getProcessCountList());
				
				if(igsvc05131vo.getProcessCountList().size() == 0){
					req.setAttribute("message", "没有相关信息！");
				}
				
				super.<IGSVC05131VO>setVO(req, igsvc05131vo);
				
				
			}else if("001".equals(type)){
				
				form.setPrassetcategory(type);
				dto.setProcesscountsearchcond(form);
				dto = svcBL.findSummaryCountForOperation(dto);
				IGSVC05131VO igsvc05131vo = new IGSVC05131VO();
				
				igsvc05131vo.setProcessCountList(dto.getProcessCountList());
				
				if(igsvc05131vo.getProcessCountList().size() == 0){
					req.setAttribute("message", "没有相关信息！");
				}
				
				super.<IGSVC05131VO>setVO(req, igsvc05131vo);
				
			}else if("user".equals(type)){
				IGSVC07DTO igsvc07DTO = new IGSVC07DTO();
				igsvc07DTO.setUserProcessCountSearchCond(form);
				igsvc07DTO = svcBL.findSummaryCountForPerson(igsvc07DTO);
				IGSVC05131VO igsvc05131vo = new IGSVC05131VO();
				igsvc05131vo.setUserProcessCountList(igsvc07DTO.getUserProcessCountList());
				if(igsvc05131vo.getUserProcessCountList().size() == 0){
					req.setAttribute("message", "没有相关信息！");
				}
				req.setAttribute("igsvc05131vo", igsvc05131vo);
//				IGSYM01BL ctlBL = (IGSYM01BL) getBean("igsym01BL");
				//实例化DTO
//				IGSYM01DTO igsym01DTO = new IGSYM01DTO();
//				igsym01DTO = ctlBL.searchOrganizationAll(igsym01DTO);
//				List<Organization> organizationList = igsym01DTO.getOrganizationList();
//				req.setAttribute("organizationList", organizationList);
			}
			log.debug("========业务运行处理终了========");
		}
		
		if(StringUtils.isNotEmpty(req.getParameter("report"))) {
			return mapping.findForward("REPORT");
		}
		if(StringUtils.isNotEmpty(req.getParameter("report1"))) {
			return mapping.findForward("REPORT1");
		}
		if(StringUtils.isNotEmpty(req.getParameter("report2"))) {
			return mapping.findForward("REPORT2");
		}
		
		return mapping.findForward("DISP");
	}

}
