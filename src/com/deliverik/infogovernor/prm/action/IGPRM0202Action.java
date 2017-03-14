/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.prm.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.infogovernor.prm.bl.IGPRM01BL;
import com.deliverik.infogovernor.prm.dto.IGPRM01DTO;
import com.deliverik.infogovernor.prm.form.IGPRM0202Form;
import com.deliverik.infogovernor.svc.bl.IGPROCESSType;

public class IGPRM0202Action extends BaseAction {

	/**
	 * <p>
	 * Title : InfoGovernor 信息服务管理平台
	 * </p>
	 * <p>
	 * Description: 系统管理_模板管理_添加类型ACTION
	 * </p>
	 * 
	 * @author sunkaiyu@deliverik.com
	 * @version 1.0
	 */
	
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		IGPRM01BL igprm01BL = (IGPRM01BL)this.getBean("IGPRM01BL");
		IGPRM01DTO dto = new IGPRM01DTO();
		dto = igprm01BL.getAllActiveTemplate(dto);
		List<IG259Info> ptList = new ArrayList<IG259Info>();
		List<IG259Info> processTemplateList = dto.getProcessTemplateList();
		for(IG259Info pt : processTemplateList){
			if(IGPROCESSType.INCIDENT_PRTYPE.equals(pt.getPttype())||
				IGPROCESSType.CHANGE_PRTYPE.equals(pt.getPttype())||
				IGPROCESSType.PROBLEM_PRTYPE.equals(pt.getPttype())||
				IGPROCESSType.DEPLOYMENT_PRTYPE.equals(pt.getPttype())||
				IGPROCESSType.SERVICE_PRTYPE.equals(pt.getPttype())||
				IGPROCESSType.SKILL_SUPPORT_PRTYPE.equals(pt.getPttype())||
				IGPROCESSType.NEW_WORK_PRTYPE_1.equals(pt.getPttype())||
				IGPROCESSType.NEW_WORK_PRTYPE_2.equals(pt.getPttype())){
				ptList.add(pt);
			}
		}
		dto.setProcessTemplateList(ptList);
		
		List<LabelValueBean> list = new ArrayList<LabelValueBean>();
		
		for(IG259Info pt : dto.getProcessTemplateList()){
			list.add(new LabelValueBean(pt.getPtname(), pt.getPtid().toString()));
		}
		if(list.isEmpty()) {
			list.add(new LabelValueBean("", ""));
		}
		req.setAttribute("list", list);
		if("INSERT".equals(mapping.getParameter())){
			IGPRM0202Form form = (IGPRM0202Form)actionForm;
			form.setPdstatus("a");
			dto.setIgPRM0202Form(form);
			if (isTokenValid(req, true)){
				dto = igprm01BL.insertProcessDefinition(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
		}else{
			saveToken(req);
		}
		return mapping.findForward("DISP");
	}
	
}
