/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.asset.bl.IGASM20BL;
import com.deliverik.infogovernor.asset.dto.IGASM20DTO;
import com.deliverik.infogovernor.asset.form.IGASM2005Form;

/**
 * 概述: 显示资产域定义详细信息Action处理
 * 功能描述: 显示资产域定义详细信息Action处理
 * 创建记录: 2011/04/25
 * 修改记录: 
 */
public class IGASM2005Action extends BaseAction {
	static Log log = LogFactory.getLog(IGASM2005Action.class);

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
		IGASM2005Form form = (IGASM2005Form) actionForm;
		// BL取得
		 IGASM20BL ctlBL = (IGASM20BL) getBean("igasm20BL");
		// DTO生成
		IGASM20DTO dto = new IGASM20DTO();
		
		// 画面跳转设定
		String forward = null;
		if ("DISP".equals(mapping.getParameter())) {
			log.debug("========资产域定义初期显示处理开始========");
			dto.setIgasm2005Form(form);
			dto = ctlBL.initIGASM2005Action(dto);
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
