/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.csebank.lom.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.csebank.lom.bl.IGLOM02BL;
import com.csebank.lom.dto.IGLOM02DTO;
import com.csebank.lom.form.IGLOM0201Form;
import com.csebank.lom.util.CodeUtils;
import com.csebank.lom.util.LOMHelper;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseAction;

public class IGLOM0201Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGLOM0201Action.class);
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse resp) throws BLException{

		IGLOM02BL ctlBL = (IGLOM02BL)this.getBean("iglom02BL");
		IGLOM02DTO dto = new IGLOM02DTO();
		String forword = "DISP";
		if("DISP".equals(mapping.getParameter())){
			IGLOM0201Form form = (IGLOM0201Form)actionForm;
			form.setMode("0");
			req.setAttribute("itemsCodesList", LOMHelper.getItemsCodes(CodeUtils.GOODS_CATEGORY));
			req.setAttribute("statusList", LOMHelper.getItemsCodes(CodeUtils.GOODS_STATUS));
		} else if ("EDIT".equals(mapping.getParameter())){
			IGLOM0201Form form = (IGLOM0201Form)actionForm;
			dto.setIglom0201Form(form);
			dto = ctlBL.searchGoodsByKey(dto);
			req.setAttribute("itemsCodesList", LOMHelper.getItemsCodes(CodeUtils.GOODS_CATEGORY));
			req.setAttribute("statusList", LOMHelper.getItemsCodes(CodeUtils.GOODS_STATUS));
		}
		if("INSERT".equals(mapping.getParameter())){
			log.debug("========类型新增处理开始========");
			IGLOM0201Form form = (IGLOM0201Form)actionForm;
			if(form.getGid() != null && 0 != form.getGid()){
				forword = "EDIT_DISP";
			}
			dto.setGoods(form);
			dto.setIglom0201Form(form);
			dto = ctlBL.insertGoodsAction(dto);
			log.debug("========类型新增处理终了========");
		} 
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
		}
		return mapping.findForward(forword);
	}
	
}