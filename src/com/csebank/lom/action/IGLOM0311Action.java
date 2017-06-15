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
import com.csebank.lom.form.IGLOM0311Form;
import com.csebank.lom.vo.IGLOM03111VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;

/**
 * 人员借款明细查询Action
 * 
 */
public class IGLOM0311Action extends BaseAction {

	static Log log = LogFactory.getLog(IGLOM0311Action.class);

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
		IGLOM0311Form form = (IGLOM0311Form)actionForm;
		
		//BL取得
		IGLOM03BL ctlBL = (IGLOM03BL) getBean("iglom03BL");
		
		//DTO生成
		IGLOM03DTO dto = new IGLOM03DTO();
		
		String forward = "";
		
		if( "DISP".equals(mapping.getParameter())){
			
			//预支费用管理查询画面初期显示处理
			log.debug("========人员借款明细查询画面初期显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========人员借款明细查询画面初期显示处理终了========");
			
			forward = "DISP";
			
			
		} else if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//人员借款明细查询处理
			log.debug("========人员借款明细查询处理开始========");
			
			//分页用DTO取得
			getPaginDTO(req,"IGLOM0311");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGLOM0311Form) req.getSession().getAttribute("IGLOM0311Form");
				if ( form == null ) {
					form = new IGLOM0311Form();
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
					form = (IGLOM0311Form) req.getSession().getAttribute("IGLOM0311Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGLOM0311");
			
			//DTO输入参数设定
			dto.setPersonLoanDetailSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			dto = ctlBL.searchPersonLoanDetailAction(dto);
			
			IGLOM03111VO vo = new IGLOM03111VO();
			vo.setPersonLoanDetailList(dto.getPersonLoanDetailList());
			
			super.<IGLOM03111VO>setVO(req, vo);
			
			log.debug("========人员借款明细查询处理终了========");
			
			forward = "DISP";
		} else if( "EXPORT".equals(mapping.getParameter())){
			//人员借款明细导出处理
			log.debug("========人员借款明细导出处理开始========");
			
			//导出记录最大件数取得
			int maxCnt = getMaxDataCount("IGLOM0311");
			
			//DTO输入参数设定
			dto.setPersonLoanDetailSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto = ctlBL.exportPersonLoanDetailAction(dto);
			
			IGLOM03111VO vo = new IGLOM03111VO();
			vo.setPersonLoanDetailList(dto.getPersonLoanDetailList());
			
			super.<IGLOM03111VO>setVO(req, vo);
			
			log.debug("========人员借款明细导出处理终了========");
			
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
