/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.sym.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.sym.bl.IGSYM19BL;
import com.deliverik.infogovernor.sym.dto.IGSYM19DTO;
import com.deliverik.infogovernor.sym.form.IGSYM1902Form;
/**
 * 概述:作息日期模板登记Action
 * 功能描述：作息日期模板登记
 * 创建记录：张楠 2011/10/18
 * 修改记录：LuJiayuan 迁移功能将名称由IGSYM1702Action变更为IGSYM1902Action 2013/01/30
 */
public class IGSYM1902Action extends BaseAction{

	static Log log = LogFactory.getLog(IGSYM1901Action.class);
	
	/**
	 * 作息日期模板登记处理
	 * @param mapping 
	 * @param actionForm 
	 * @param request 
	 * @param response 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		IGSYM1902Form igsym1902Form=(IGSYM1902Form) actionForm;
		IGSYM19BL igsym19BL=(IGSYM19BL) getBean("igsym19BL");
		IGSYM19DTO dto = new IGSYM19DTO();
		dto.setIgsym1902Form(igsym1902Form);
		//作息时间登记
		if("INSERT".equals(mapping.getParameter())){
			log.debug("==============作息时间登记开始===============");
			dto = igsym19BL.insertProcessWorkTimeTemplateAction(dto);
			log.debug("==============作息时间登记结束===============");
			Integer year = igsym1902Form.getYear();
			return new ActionForward("/IGSYM1901_ReDisp.do?year="+year+"&month="+0);
		}
		//作息时间登记画面初始化
		if("DISP".equals(mapping.getParameter())){
			log.debug("==============作息时间登记画面初始化开始===============");
			log.debug("==============作息时间登记画面初始化结束===============");
		}
		
		return mapping.findForward("DISP");
	}

}
