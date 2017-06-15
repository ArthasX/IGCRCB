/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
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
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.utility.CodeListUtils;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0801Form;
import com.deliverik.infogovernor.util.StringEncrypt;

/**
 * 概述: HQ自动登录
 * 创建记录：2013/5/31
 * 修改记录：
 */
public class IGCIM0801Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM0801Action.class);

	/**
	 * 
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//画面跳转设定
		String forward = "DISP";
		
		//Get Form
		IGCIM0801Form form=(IGCIM0801Form)actionForm;

		//注入值
		//注入值
		log.info("========自动登录HQ画面初期显示处理开始========");
		CodeListUtils codeListUtils = (CodeListUtils) WebApplicationSupport.getBean("codeListUtils");
		form.setUrl("http://"+codeListUtils.getCodeValue("160", null, null, "1")+":"+codeListUtils.getCodeValue("160", null, null, "2"));
		form.setJ_username(codeListUtils.getCodeValue("160", null, null, "3"));
		form.setJ_password(StringEncrypt.asciiToChar(codeListUtils.getCodeValue("160", null, null, "4")));
		log.info("========自动登录HQ画面初期显示处理终了========");
		
		return mapping.findForward(forward);
	}
}
