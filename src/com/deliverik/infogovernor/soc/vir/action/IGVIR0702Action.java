/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.action;


import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.soc.vir.bl.IGVIR07BL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR07DTO;
import com.deliverik.infogovernor.soc.vir.form.IGVIR0702Form;

/**
 * 概述: vCenter新增、修改
 * 功能描述: vCenter新增、修改Action
 * 创建记录: 2014/02/12
 * 修改记录: 
 */
public class IGVIR0702Action extends BaseAction {

	static Log log = LogFactory.getLog(IGVIR0702Action.class);

	/**
	 * 配置包含关系显示处理
	 *
	 * @param mapping ActionMapping 
	 * @param actionForm ActionForm 
	 * @param req HttpServletRequest 
	 * @param res HttpServletResponse 
	 * @return ActionForward
	 * @throws Exception
	 */
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//实例化FORM
		IGVIR0702Form form = (IGVIR0702Form)actionForm;
		//BL取得
		IGVIR07BL ctlBL = (IGVIR07BL) getBean("igvir07BL");
		
		//DTO生成
		IGVIR07DTO dto = new IGVIR07DTO();
		
		String forward = "DISP";
		if ("DISP".equals(mapping.getParameter())){
			log.debug("========vCenter新增显示开始========");
			form.setMode("0");
			log.debug("========vCenter新增显示终了========");
		}else if("INSERT".equals(mapping.getParameter())){
			log.debug("========vCenter信息新增、修改开始========");
			dto.setIgVIR0702Form(form);
			ctlBL.registVIM01(dto);
			if("0".equals(form.getMode())){
				forward = "SUCCEE";
			}else{
				forward = "LIST";
			}
			log.debug("========vCenter信息新增、修改开始========");
		}else if("EDIT".equals(mapping.getParameter())){
			log.debug("========vCenter信息修改显示开始========");
			form.setMode("1");
			dto.setIgVIR0702Form(form);
			ctlBL.searchVIM01ByPK(dto);
			log.debug("========vCenter信息修改显示终了========");
		}else if("DEL".equals(mapping.getParameter())){
			log.debug("========vCenter信息删除开始========");
			dto.setIgVIR0702Form(form);
			ctlBL.deleteVIM01ByPK(dto);
			log.debug("========vCenter信息删除终了========");
		}else if("CHECK".equals(mapping.getParameter())){
			log.debug("========vCenter URL唯一校验开始========");
			PrintWriter out = null;
            try {
                out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
    			dto.setIgVIR0702Form(form);
    			ctlBL.checkVIM01ByURL(dto);
    			out.print(dto.getUrlcheckflag());
            } catch (Exception e) {
                out.print("");
                log.error("AjaxAction Exception", e);
            } finally {
                if (out != null)
                    out.close();
            }
            log.debug("========vCenter URL唯一校验终了========");
			return null;
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
		}
		return mapping.findForward(forward);
	}
}
