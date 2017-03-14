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

import com.csebank.lom.bl.IGLOM01BL;
import com.csebank.lom.dto.IGLOM01DTO;
import com.csebank.lom.form.IGLOM0114Form;
import com.csebank.lom.vo.IGLOM01131VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;

/**
 * 接待客人查询Action
 * 
 */
public class IGLOM0114Action extends BaseAction {

	static Log log = LogFactory.getLog(IGLOM0114Action.class);

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
		IGLOM0114Form form = (IGLOM0114Form)actionForm;
		
		//BL取得
		IGLOM01BL ctlBL = (IGLOM01BL) getBean("iglom01BL");
		
		//DTO生成
		IGLOM01DTO dto = new IGLOM01DTO();
		
		String forward = "";
		
		if( "DISP".equals(mapping.getParameter())){
			
			//接待客人查询画面初期显示处理
			log.debug("========接待客人查询画面初期显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========接待客人查询画面初期显示处理终了========");
			
			forward = "DISP";
			
		} else if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//接待客人查询处理
			log.debug("========接待客人查询处理开始========");
			//分页用DTO取得
			getPaginDTO(req,"IGLOM0114");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由食堂信息画面，借款信息画面返回查询画面时的再检索处理
				form = (IGLOM0114Form) req.getSession().getAttribute("IGLOM0114Form");
				if ( form == null ) {
					form = new IGLOM0114Form();
				}else {
					if (req.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} else {
				if (req.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					form = (IGLOM0114Form) req.getSession().getAttribute("IGLOM0114Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//查询记录最大数取得
			int maxCnt = getMaxDataCount("IGLOM0114");
			
			//DTO输入参数设定
			dto.setRecptionGuestInfoCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//部门接待工作信息检索逻辑调用
			dto = ctlBL.searchRecptionByGusetAction(dto);
			
			
			//将部门接待工作信息检索结果设定到VO中
			IGLOM01131VO vo = new IGLOM01131VO();
			vo.setGuestRecptionList(dto.getGuestRecptionList());
			
			super.<IGLOM01131VO>setVO(req, vo);
			
			log.debug("========接待客人查询处理终了========");
			
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
