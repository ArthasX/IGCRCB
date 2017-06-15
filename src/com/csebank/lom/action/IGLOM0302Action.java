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
import com.csebank.lom.form.IGLOM0302Form;
import com.csebank.lom.util.CodeUtils;
import com.csebank.lom.util.LOMHelper;
import com.csebank.lom.vo.IGLOM03021VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;

/**
 * 预支费用管理Action
 * 
 */
public class IGLOM0302Action extends BaseAction {

	static Log log = LogFactory.getLog(IGLOM0302Action.class);

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
		IGLOM0302Form form = (IGLOM0302Form)actionForm;
		
		//BL取得
		IGLOM03BL ctlBL = (IGLOM03BL) getBean("iglom03BL");
		
		//DTO生成
		IGLOM03DTO dto = new IGLOM03DTO();
		
		String forward = "";
		
		req.getSession().setAttribute("AD_advancescost_acstatus", LOMHelper.getItemsCodes(CodeUtils.ADVANCESCOST_ACSTATUS));
		
		if( "DISP".equals(mapping.getParameter())){
			
			//预支费用管理查询画面初期显示处理
			log.debug("========预支费用管理查询画面初期显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========预支费用管理查询画面初期显示处理终了========");

			saveToken(req);
			forward = "DISP";
			
			
		} else if("REDISP".equals(mapping.getParameter())){
			
			//预支费用管理查询画面再显示处理
			log.debug("========预支费用管理查询画面再显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========预支费用管理查询画面再显示处理终了========");
			
			forward = "DISP";
			
			
		} else if ("DELETE".equals(mapping.getParameter())){
			
			log.debug("========预支费用管理删除处理开始========");
			//DTO输入参数设定
			dto.setDeleteAcid(form.getDeleteAcid());
			
			if (isTokenValid(req, true)) {
				
				ctlBL.deleteAdvanCescostAction(dto);
			} else {
				
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			
			log.debug("========预支费用管理删除处理终了========");
			
			forward = "DELETE";
			
		} else if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//预支费用管理查询处理
			log.debug("========预支费用管理查询处理开始========");
			//分页用DTO取得
			getPaginDTO(req,"IGLOM0302");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGLOM0302Form) req.getSession().getAttribute("IGLOM0302Form");
				if ( form == null ) {
					form = new IGLOM0302Form();
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
					form = (IGLOM0302Form) req.getSession().getAttribute("IGLOM0302Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGLOM0302");
			
			//DTO输入参数设定
			dto.setAdvanCescostSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//预支费用管理信息检索逻辑调用
			dto = ctlBL.searchAdvanCescostAction(dto);
			
			
			//将预支费用管理信息检索结果设定到VO中
			IGLOM03021VO vo = new IGLOM03021VO();
			vo.setAdvanCescostList(dto.getAdvanCescostList());
			
			super.<IGLOM03021VO>setVO(req, vo);
			
			log.debug("========预支费用管理查询处理终了========");
			
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
