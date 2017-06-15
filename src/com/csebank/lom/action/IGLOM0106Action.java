/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.csebank.lom.bl.IGLOM01BL;
import com.csebank.lom.dto.IGLOM01DTO;
import com.csebank.lom.form.IGLOM0106Form;
import com.csebank.lom.vo.IGLOM01061VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.utility.IGStringUtils;

/**
 * 接待统计管理Action
 * 
 */
public class IGLOM0106Action extends BaseAction {

	static Log log = LogFactory.getLog(IGLOM0106Action.class);

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
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//FORM取得
		IGLOM0106Form form = (IGLOM0106Form)actionForm;
		
		//BL取得
		IGLOM01BL ctlBL = (IGLOM01BL) getBean("iglom01BL");
		
		//DTO生成
		IGLOM01DTO dto = new IGLOM01DTO();
		
		String forward = "";
		
		if( "DISP".equals(mapping.getParameter())){
			
			//接待统计管理查询画面初期显示处理
			log.debug("========接待统计管理查询画面初期显示处理开始========");
			form.setYear(IGStringUtils.getCurrentYear());
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========接待统计管理查询画面初期显示处理终了========");
			
			forward = "DISP";
			
			
		} else if("REDISP".equals(mapping.getParameter())){
			
			//接待统计管理查询画面再显示处理
			log.debug("========接待统计管理查询画面再显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========接待统计管理查询画面再显示处理终了========");
			
			forward = "DISP";
			
			
		} else if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//接待统计管理查询处理
			log.debug("========接待统计管理查询处理开始========");
	
			form = (IGLOM0106Form) req.getSession().getAttribute("IGLOM0106Form");
			//DTO输入参数设定
			dto.setRecptionVWSearchCond(form);
			
			
			//接待统计管理信息检索逻辑调用
			dto = ctlBL.searchRecptionVWAction(dto);
			
			
			//将接待统计管理信息检索结果设定到VO中
			IGLOM01061VO vo = new IGLOM01061VO();
			vo.setRecptionVWList(dto.getRecptionVWList());
			
			super.<IGLOM01061VO>setVO(req, vo);
			
			log.debug("========接待统计管理查询处理终了========");
			if(StringUtils.isNotEmpty(req.getParameter("report"))) {
				return mapping.findForward("REPORT");
			} else {
				forward = "DISP";
			}
		}
		
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}

		return mapping.findForward(forward);
	}

}
