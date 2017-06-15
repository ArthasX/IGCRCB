package com.deliverik.infogovernor.svc.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.infogovernor.svc.bl.IGPROCESSType;
import com.deliverik.infogovernor.svc.bl.IGSVC06BL;
import com.deliverik.infogovernor.svc.form.IGSVC0601Form;

public class IGSVC0601Action extends BaseAction {

	/**
	 * <p>
	 * Description: 各类型流程数量图形统计action处理
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @author duchong@deliverik.com
	 * @update
	 */
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse resp) throws Exception {

		//BL取得
		IGSVC06BL svcBL = (IGSVC06BL) getBean("igsvc06BL");
		
		IGSVC0601Form igsvc0601Form = (IGSVC0601Form)actionForm;
		
		igsvc0601Form.setSvcxml("");
		List<LabelValueBean> list = new ArrayList<LabelValueBean>();
		req.setAttribute("processTemplateList", list);
		//获取流程类型下拉选
		List<IG259Info> ptList = new ArrayList<IG259Info>();
		List<IG259Info> processTemplateList = svcBL.getAllActiveTemplate();
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
		
		for(IG259Info info : ptList){
			list.add(new LabelValueBean(info.getPtname(),info.getPttype()));
		}
		
		
		if( "DISP".equals(mapping.getParameter())){
			igsvc0601Form.setPryear(IGStringUtils.getCurrentYear());
			return mapping.findForward("DISP");
			
		}else if("STATISTICS".equals(mapping.getParameter())){
			//将选中的类型名称设置到Form中
			for(IG259Info pt : ptList){
				if(pt.getPttype().equals(igsvc0601Form.getPrkind())){
					igsvc0601Form.setPrname(pt.getPtname());
				}
			}
			
			//获取图形显示用XML
			svcBL.getXmlByCondition(igsvc0601Form);
			
			return mapping.findForward("DISP");
		}
		
		return mapping.findForward("DISP");
	}

}
