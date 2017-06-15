/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.action;

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
import com.deliverik.infogovernor.sym.bl.IGSYM18BL;
import com.deliverik.infogovernor.sym.dto.IGSYM18DTO;
import com.deliverik.infogovernor.sym.form.IGSYM1802Form;
import com.deliverik.infogovernor.sym.vo.IGSYM18011VO;

/**
 * 概述: 首页管理 修改Action
 * 功能描述: 首页管理 修改Action
 * 创建记录: 20121114
 * 修改记录: 
 */
public class IGSYM1802Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSYM1802Action.class);

	/**
	 * 修改Action 
	 * @param mapping
	 * @param actionForm
	 * @param req
	 * @param res
	 * @return ActionForward
	 * @throws Exception
	 */
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		// BL取得
		IGSYM18BL ctlBL = (IGSYM18BL) getBean("igSYM18BL");
		// DTO生成
		IGSYM18DTO dto = new IGSYM18DTO();
		// FORM取得
		IGSYM1802Form form = (IGSYM1802Form) actionForm;
		dto.setIgSYM1802Form(form);
		if ("EDIT".equals(mapping.getParameter())) {
			log.debug("========首页管理设置修改处理开始========");
			if (isTokenValid(req, true)){
				dto = ctlBL.editFirstJspInfoAction(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			log.debug("========首页管理修改处理结束========");
		}else if ("INIT".equals(mapping.getParameter())) {
			log.debug("========首页管理修改初始化处理开始========");
			dto = ctlBL.searchFirstJspInfoByPKAction(dto);		
     		IGSYM18011VO vo = new IGSYM18011VO(dto.getFirstJspInfoList());		
            super.<IGSYM18011VO>setVO(req, vo); 
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			saveToken(req);
			log.debug("========首页管理修改初始化处理结束========");
		}
		else if ("DEL".equals(mapping.getParameter()))
		{
			log.debug("========首页管理删除处理开始========");
			if(form.getHpid() != null && !"".equals(form.getHpid()))
			{
				ctlBL.deleteFirstJspInfoAction(dto);				
			}
			else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			log.debug("========首页管理删除处理结束========");
		}
		// 逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(req, message);
			}
		}
		return mapping.findForward("Disp");
	}
}
