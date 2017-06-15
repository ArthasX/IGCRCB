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
import com.deliverik.infogovernor.sym.form.IGSYM1903Form;
/**
 * 概述:作息日期变更Action
 * 功能描述：作息日期变更
 * 创建记录：张楠 2011/10/18
 * 修改记录：LuJiayuan 迁移功能将名称由IGSYM1703Action变更为IGSYM1903Action 2013/01/30
 */
public class IGSYM1903Action extends BaseAction{
	
	static Log log = LogFactory.getLog(IGSYM1901Action.class);
	
	/**
	 * 作息日期变更处理
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
		
		IGSYM1903Form igsym1903Form=(IGSYM1903Form) actionForm;
		IGSYM19BL igsym19BL=(IGSYM19BL) getBean("igsym19BL");
		IGSYM19DTO dto = new IGSYM19DTO();
		dto.setIgsym1903Form(igsym1903Form);
		//作息时间修改画面初始化
		if("DISP".equals(mapping.getParameter())){
			log.debug("==============作息时间修改画面初始化开始===============");
			dto = igsym19BL.searchProcessWorkTimeTemplateByPK(dto);
			log.debug("==============作息时间修改画面初始化结束===============");
		}
		//作息时间变更
		if("UPDATE".equals(mapping.getParameter())){
			log.debug("==============作息时间修改开始===============");
			igsym19BL.updateProcessWorkTimeTemplateAction(dto);
			log.debug("==============作息时间修改结束===============");
			String pwtDate = igsym1903Form.getPwtDate();
			String year = pwtDate.substring(0, 4);
			String month = pwtDate.substring(5, 7);
			return new ActionForward("/IGSYM1901_ReDisp.do?year="+year+"&month="+(Integer.valueOf(month)-1));
		}
		return mapping.findForward("DISP");
	}

}
