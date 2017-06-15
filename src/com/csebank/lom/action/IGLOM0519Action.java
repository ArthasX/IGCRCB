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

import com.csebank.lom.bl.IGLOM05BL;
import com.csebank.lom.dto.IGLOM05DTO;
import com.csebank.lom.form.IGLOM0519Form;
import com.csebank.lom.util.CodeUtils;
import com.csebank.lom.util.LOMHelper;
import com.csebank.lom.vo.IGLOM05181VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;

/**
 * 餐卡管理Action
 * 
 */
public class IGLOM0519Action extends BaseAction {

	static Log log = LogFactory.getLog(IGLOM0519Action.class);

	/**
	 * 餐卡管理
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
		IGLOM0519Form form = (IGLOM0519Form)actionForm;
		
		//BL取得
		IGLOM05BL ctlBL = (IGLOM05BL) getBean("iglom05BL");
		
		//DTO生成
		IGLOM05DTO dto = new IGLOM05DTO();
		
		String forward = "";
		
		req.setAttribute("card_status", LOMHelper.getItemsCodes(CodeUtils.GOODS_STATUS));
		if( "DISP".equals(mapping.getParameter())){
			
			//餐卡管理查询画面初期显示处理
			log.debug("========餐卡管理查询画面初期显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========餐卡管理查询画面初期显示处理终了========");
			
			forward = "DISP";
			
			
		} 	/*
			else if ("DELETE".equals(mapping.getParameter())){
			
			log.debug("========食堂成本管理删除处理开始========");
			//DTO输入参数设定
			dto.setDeleteRid(form.getDeleteRid());
			
			ctlBL.deleteRecptionAction(dto);
			
			log.debug("========接待工作管理删除处理终了========");
			
			forward = "DELETE";
			
		} */else if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//食堂成本管理查询处理
			log.debug("========餐卡管理查询处理开始========");
			//分页用DTO取得
			getPaginDTO(req,"IGLOM0519");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGLOM0519Form) req.getSession().getAttribute("IGLOM0519Form");
				form.setDesc("");
				if ( form == null ) {
					form = new IGLOM0519Form();
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
					form = (IGLOM0519Form) req.getSession().getAttribute("IGLOM0519Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGLOM0519");
			
			//DTO输入参数设定
			form.setDesc(form.getStatus());
			dto.setLunchCardSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//餐卡管理信息检索逻辑调用
			dto = ctlBL.searchLunchCardAction(dto);
			
			
			//将餐卡管理信息检索结果设定到VO中
			IGLOM05181VO vo = new IGLOM05181VO();
			vo.setLunchCardList(dto.getItemsCodesList());
			
			super.<IGLOM05181VO>setVO(req, vo);
			
			log.debug("========餐卡管理查询处理终了========");
			
			forward = "DISP";
			
		}else if ("CHANGE".equals(mapping.getParameter())){
			log.debug("=======餐卡状态停用/启用处理开始========");
			//DTO输入参数设定
			dto.setIglom0519Form(form);
			
			

//			if (isTokenValid(req, true)) {
//
//				
//			} else {
//				
//				addMessage(req, new ActionMessage("IGCO00000.E007"));
//				return mapping.findForward("/error1");
//			}
			
			ctlBL.changeLunchCardAction(dto);
			form.setIcid(null);
			log.debug("========餐卡状态停用/启用处理终了========");
			
			forward = "CHANGE";
			
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
