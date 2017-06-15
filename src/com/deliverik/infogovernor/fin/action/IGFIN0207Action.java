/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.fin.action;

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
import com.deliverik.infogovernor.fin.bl.IGFIN02BL;
import com.deliverik.infogovernor.fin.dto.IGFIN02DTO;
import com.deliverik.infogovernor.fin.form.IGFIN0206Form;
import com.deliverik.infogovernor.fin.vo.IGFIN02013VO;
import com.deliverik.infogovernor.fin.vo.IGFIN02014VO;

/**
 * 费用详细信息画面Action处理
 *
 */
public class IGFIN0207Action extends BaseAction {

	static Log log = LogFactory.getLog(IGFIN0207Action.class);

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
	@SuppressWarnings("unchecked")
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORM取得
		IGFIN0206Form form = (IGFIN0206Form)actionForm;
		
		//BL取得
		IGFIN02BL ctlBL = (IGFIN02BL) getBean("igfin02BL");
		
		//DTO生成
		IGFIN02DTO dto = new IGFIN02DTO();

		if( "DISP".equals(mapping.getParameter())){
			//费用查询详细画面显示处理
			log.debug("========费用查询画面详细显示处理开始========");
			
			String bid = req.getParameter("eid");
			
			dto.setBid(Integer.valueOf(bid));
			
			form.setBid(Integer.valueOf(bid));
			
			dto.setIgfin0206Form(form);
			
			//费用查询画面详细显示处理逻辑调用
			dto = ctlBL.initIGFIN0206Action(dto);
			
			form.setAttkey(dto.getExpense().getExattkey());
			
			//费用检索结果设定到VO中

			IGFIN02013VO vo = new IGFIN02013VO(dto.getExpense());
			
			super.<IGFIN02013VO>setVO(req,vo);
			
			IGFIN02014VO vo1 = new IGFIN02014VO(dto.getAttachmentList());
			
			super.<IGFIN02014VO>setVO(req,vo1);
			
			log.debug("========费用查询画面详细显示处理终了========");
		}
		
		if ("DELETE".equals(mapping.getParameter())){
			//费用删除处理
			log.debug("========费用删除处理开始========");
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)){
				//返回处理
				return mapping.findForward("BACK");
			}
			
			log.debug("========费用删除处理终了========");
		}
		
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
		}

		return mapping.findForward("DISP");
	}
}
