/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.prd.action;

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

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.prd.bl.IGPRD01BL;
import com.deliverik.infogovernor.prd.dto.IGPRD01DTO;
import com.deliverik.infogovernor.prd.form.IGPRD0110Form;
import com.deliverik.infogovernor.prd.vo.IGPRD01101VO;

/**
 * 表单信息查询Action处理
 *
 * @author liupeng@deliverik.com
 */
public class IGPRD0110Action extends BaseAction {

	static Log log = LogFactory.getLog(IGPRD0110Action.class);

	/**
	 * 表单信息查询处理
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return ActionForward
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORM取得
		IGPRD0110Form form = (IGPRD0110Form)actionForm;
		
		//BL取得
		IGPRD01BL ctlBL = (IGPRD01BL) getBean("igPRD01BL");
		
		//DTO生成
		IGPRD01DTO dto = new IGPRD01DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//表单信息查询画面初期显示处理
			log.debug("========表单信息查询画面初期显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========表单信息查询画面初期显示处理终了========");
			return mapping.findForward("DISP");
		} else if ( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//表单信息查询处理
			log.debug("========表单信息查询处理开始========");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGPRD0110Form) req.getSession().getAttribute("IGPRD0110Form");
				if ( form == null ) {
					form = new IGPRD0110Form();
				}
			} 
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGPRD0110");
			
			dto.setProcessInfoDefSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			
			dto.setPdid(form.getPdid());
			//dto参数设定
			dto.setIgprd0110Form(form);
			//表单信息信息检索逻辑调用
			dto = ctlBL.searchProcessInfoDefAction(dto);
			dto = ctlBL.isProcessDefinitionInUse(dto);
			dto = ctlBL.searchBackURLAction(dto);
			//将表单信息信息检索结果设定到VO中
			IGPRD01101VO vo = new IGPRD01101VO(dto.getProcessInfoDefList());
			vo.setProcessInfoDef(dto.getProcessInfoDef());
			req.setAttribute("isInUse", dto.getIsProcessDefinitionInUse());
			super.<IGPRD01101VO>setVO(req, vo);
			log.debug("========表单信息查询处理终了========");
		}
		
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}
		if(StringUtils.isNotEmpty(form.getViewhistory()) && "1".equalsIgnoreCase(form.getViewhistory())){
			//历史版本下的查看
			return mapping.findForward("VIEWHISTORY");
		}else{
			return mapping.findForward("DISP");
		}
	}
}
