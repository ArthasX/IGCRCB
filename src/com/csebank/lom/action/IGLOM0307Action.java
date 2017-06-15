/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
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

import com.csebank.lom.bl.IGLOM03BL;
import com.csebank.lom.dto.IGLOM03DTO;
import com.csebank.lom.form.IGLOM0307Form;
import com.csebank.lom.vo.IGLOM03021VO;
import com.csebank.lom.vo.IGLOM03071VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;

/**
 * 冲抵计财部借款Action
 * 
 */
public class IGLOM0307Action extends BaseAction {

	static Log log = LogFactory.getLog(IGLOM0307Action.class);

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
		IGLOM0307Form form = (IGLOM0307Form)actionForm;
		
		//BL取得
		IGLOM03BL ctlBL = (IGLOM03BL) getBean("iglom03BL");
		
		//DTO生成
		IGLOM03DTO dto = new IGLOM03DTO();
		
		String forward = "";
		
		if( "DISP".equals(mapping.getParameter())){
			
			//冲抵计财部借款查询画面初期显示处理
			log.debug("========冲抵计财部借款查询画面初期显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========冲抵计财部借款查询画面初期显示处理终了========");
			
			forward = "DISP";
			
			
		} else if ("PAY".equals(mapping.getParameter())){
			
			log.debug("========冲抵计财部借款预支费用列表初始化开始========");
			//DTO输入参数设定
			dto.setIglom0307Form(form);
			//冲抵计财部借款汇总
			dto = ctlBL.searchLoanPayDetailSummaryAction(dto);
			IGLOM03021VO vo = new IGLOM03021VO();
			vo.setAdvanCescostList(dto.getAdvanCescostList());
			super.<IGLOM03021VO>setVO(req, vo);
			saveToken(req);
			forward = "PAY";
			log.debug("========冲抵计财部借款预支费用列表初始化终了========");
			
		} else if ("CREDIT".equals(mapping.getParameter())){
			
			log.debug("========冲抵计财部借款处理开始========");
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			dto.setUserid(user.getUserid());
			dto.setUsername(user.getUsername());
			//DTO输入参数设定
			dto.setIglom0307Form(form);
			//冲抵计财部借款
			if (isTokenValid(req, true)){
				dto = ctlBL.loanPayDetailCredit(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			forward = "CREDIT";
			log.debug("========冲抵计财部借款处理终了========");
			
		} else if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			
			//冲抵计财部借款查询处理
			log.debug("========冲抵计财部借款查询处理开始========");
			
			//查询记录最大数取得
			int maxCnt = getMaxDataCount("IGLOM0307");
			
			//DTO输入参数设定
			dto.setLoanPayDetailSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			//冲抵计财部借款信息检索逻辑调用
			dto = ctlBL.searchLoanPayDetailNoPagingAction(dto);
			
			//将冲抵计财部借款信息检索结果设定到VO中
			IGLOM03071VO vo = new IGLOM03071VO();
			vo.setLoanPayDetailList(dto.getLoanPayDetailList());
			
			super.<IGLOM03071VO>setVO(req, vo);
			
			log.debug("========冲抵计财部借款查询处理终了========");
			
			forward = "DISP";
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
