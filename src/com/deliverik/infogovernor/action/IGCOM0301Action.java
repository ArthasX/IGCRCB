package com.deliverik.infogovernor.action;

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
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.bl.IGCOM03BL;
import com.deliverik.infogovernor.dto.IGCOM03DTO;
import com.deliverik.infogovernor.form.IGCOM0301Form;
import com.deliverik.infogovernor.vo.IGCOM03011VO;

/**
 * 资产查询HELP画面用Action处理
 *
 */
public class IGCOM0301Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCOM0301Action.class);

	/**
	 * 
	 * 事件处理
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORM取得
		IGCOM0301Form form = (IGCOM0301Form)actionForm;
		
		//BL取得
		IGCOM03BL ctlBL = (IGCOM03BL) getBean("igcom03BL");
		
		//DTO生成
		IGCOM03DTO dto = new IGCOM03DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========资产类型HELP查询画面初期显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========资产类型HELP查询画面初期显示处理终了========");
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			log.debug("========资产类型HELP查询画面再显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========资产类型HELP查询画面再显示处理终了========");
			return mapping.findForward("DISP");
		}	

		if( "SEARCH".equals(mapping.getParameter())){
			log.debug("========资产类型HELP查询处理开始========");

			//分页用DTO取得
			getPaginDTO(req,"IGCOM0301");

			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
//			pDto.setFromCount(form.getFromCount());
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGCOM0301");
			
			//DTO输入参数设定
			dto.setEntitySearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//资产信息检索逻辑调用
			dto = ctlBL.searchEntityAction(dto);
			
			//将资产信息检索结果设定到VO中
			IGCOM03011VO vo = new IGCOM03011VO(dto.getEntityList());
			
			super.<IGCOM03011VO>setVO(req, vo);
			
			//逻辑处理过程中的信息显示
			List<ActionMessage> messageList = dto.getMessageList();
			
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(req, message);
				}
				
			}
			log.debug("========资产类型查询处理终了========");
		}
		return mapping.findForward("DISP");
	}
}
