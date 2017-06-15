/**
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.cim.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.soc.cim.bl.IGCIM02BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM02DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0205Form;

/**
 * 概述: 显示资产域定义详细信息Action处理
 * 功能描述: 显示资产域定义详细信息Action处理
 * 创建记录: 2011/04/25
 * 修改记录: 
 */
public class IGCIM0205Action extends BaseAction {
	static Log log = LogFactory.getLog(IGCIM0205Action.class);

	/**
	 * 事件处理
	 * 
	 * @param mapping
	 * @param actionForm
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		// FORM取得
		IGCIM0205Form form = (IGCIM0205Form) actionForm;
		// BL取得
		 IGCIM02BL ctlBL = (IGCIM02BL) getBean("igcim02BL");
		// DTO生成
		IGCIM02DTO dto = new IGCIM02DTO();
		dto.setLocale(this.getLocale(req));
		// 画面跳转设定
		String forward = null;
		if ("DISP".equals(mapping.getParameter())) {
			log.debug("========资产域定义初期显示处理开始========");
			dto.setIgcim0205Form(form);
			dto = ctlBL.initIGCIM0205Action(dto);
			log.debug("========资产域定义初期显示处理终了========");
			forward = "DISP";
		}
		if("BACK".equals(mapping.getParameter())){
			//资产域定义信息查询画面跳转
			log.debug("========资产域定义信息查询========");
			forward="BACK";
		}
		return mapping.findForward(forward);
	}
}
