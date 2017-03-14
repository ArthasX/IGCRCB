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

import com.csebank.lom.bl.IGLOM05BL;
import com.csebank.lom.dto.IGLOM05DTO;
import com.csebank.lom.form.IGLOM0520Form;
import com.csebank.lom.vo.IGLOM01081VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.utility.IGStringUtils;



/**
 * 模块：后勤管理-食堂管理-部门招待汇总
 * 说明：部门招待汇总Action
 * 作者：唐晓娜
 */
public class IGLOM0520Action extends BaseAction {

	static Log log = LogFactory.getLog(IGLOM0520Action.class);

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
		IGLOM0520Form form = (IGLOM0520Form)actionForm;
		
		//BL取得
		IGLOM05BL ctlBL = (IGLOM05BL) getBean("iglom05BL");
		
		//DTO生成
		IGLOM05DTO dto = new IGLOM05DTO();
		
		String forward = "";
		//初期显示跳转到可以查询的页面
		if( "DISP".equals(mapping.getParameter())){
			
			
			log.debug("========部门招待汇总查询画面初期显示处理开始========");
			form.setYear(IGStringUtils.getCurrentYear());
			form.setMonth_to(IGStringUtils.getCurrentDate().substring(5,7));		
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========部门招待汇总查询画面初期显示处理终了========");
			
			forward = "DISP";
			
		
		}else if( "SEARCH".equals(mapping.getParameter())){
			
			log.debug("========部门招待汇总查询处理开始========");
	
			form = (IGLOM0520Form) req.getSession().getAttribute("IGLOM0520Form");
			
			dto.setEeOrgVWSearchCond(form);
						
		
			dto = ctlBL.searchEEOrgVWAction(dto);		
			
			
			IGLOM01081VO vo = new IGLOM01081VO();
			vo.setEeOrgVWList(dto.getEeOrgVWList());
			
			super.<IGLOM01081VO>setVO(req, vo);
			
			log.debug("========食堂管理部门汇总查询处理终了========");
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
