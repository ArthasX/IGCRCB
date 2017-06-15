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
import com.csebank.lom.form.IGLOM0120Form;
import com.csebank.lom.vo.IGLOM01081VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.utility.IGStringUtils;

/**
 * 模块：后勤管理-接待管理-外出就餐部门汇总
 * 说明：部门接待统计Action
 * 作者：唐晓娜
 */
public class IGLOM0120Action extends BaseAction {

	static Log log = LogFactory.getLog(IGLOM0108Action.class);

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
		IGLOM0120Form form = (IGLOM0120Form)actionForm;
		
		//BL取得
		IGLOM01BL ctlBL = (IGLOM01BL) getBean("iglom01BL");
		
		//DTO生成
		IGLOM01DTO dto = new IGLOM01DTO();
		
		String forward = "";
		//初期显示跳转到可以查询的页面
		if( "DISP".equals(mapping.getParameter())){
			
			//部门接待统计查询画面初期显示处理
			log.debug("========部门外出就餐统计查询画面初期显示处理开始========");
			form.setYear(IGStringUtils.getCurrentYear());
			form.setMonth_to(IGStringUtils.getCurrentDate().substring(5,7));		
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========部门外出就餐统计查询画面初期显示处理终了========");
			
			forward = "DISP";
			
			
		}else if( "SEARCH".equals(mapping.getParameter())){
			//部门接待统计查询处理
			log.debug("========部门外出就餐统计查询处理开始========");
	
			form = (IGLOM0120Form) req.getSession().getAttribute("IGLOM0120Form");
			//DTO输入参数设定
			dto.setDealOrgVWSearchCond(form);
						
			//部门接待统计信息检索逻辑调用
			dto = ctlBL.searchDealOrgVWAction(dto);		
			
			//将部门接待统计信息检索结果设定到VO中
			IGLOM01081VO vo = new IGLOM01081VO();
			vo.setDealOrgVWList(dto.getDealOrgVWList());
			
			super.<IGLOM01081VO>setVO(req, vo);
			
			log.debug("========部门外出就餐统计查询处理终了========");
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
