package com.deliverik.infogovernor.asset.action;

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
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.infogovernor.asset.bl.IGASM12BL;
import com.deliverik.infogovernor.asset.dto.IGASM12DTO;
import com.deliverik.infogovernor.asset.form.IGASM1201Form;
import com.deliverik.infogovernor.asset.vo.IGASM12011VO;

/**
 * 机柜查询画面Action处理
 *
 */
public class IGASM1201Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM1201Action.class);

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
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORM取得
		IGASM1201Form form = (IGASM1201Form)actionForm;
		
		//BL取得
		IGASM12BL ctlBL = (IGASM12BL) getBean("igasm12BL");
		
		//DTO生成
		IGASM12DTO dto = new IGASM12DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//机柜查询画面初期显示处理
			log.debug("========机柜查询画面初期显示处理开始========");
			
			//***************************************************************************
			//类型分类(机柜)设定
			form = new IGASM1201Form();
			form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_CONTAINER);
			req.setAttribute("IGASM1201Form", form);
			//***************************************************************************
			
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========机柜查询画面初期显示处理终了========");
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			//机柜查询画面再显示处理
			log.debug("========机柜查询画面再显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========机柜查询画面再显示处理终了========");
			return mapping.findForward("DISP");
		}	

		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//分页用DTO取得
			getPaginDTO(req,"IGASM1201");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			//机柜查询处理
			log.debug("========机柜查询处理开始========");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGASM1201Form) req.getSession().getAttribute("IGASM1201Form");
				if ( form== null){
					form = new IGASM1201Form();
					form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_DEVICE);
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
					form = (IGASM1201Form) req.getSession().getAttribute("IGASM1201Form");
					form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_DEVICE);
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}		
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGASM1201");
			
			//DTO输入参数设定
			dto.setEntityItemVWSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//机柜检索逻辑调用
			dto = ctlBL.searchEntityItemAction(dto);
			
			//将机柜信息检索结果设定到VO中
			IGASM12011VO vo = new IGASM12011VO(dto.getEntityItemVWInfoList());
			
			super.<IGASM12011VO>setVO(req, vo);
			
			log.debug("========机柜查询处理终了========");
		}
		if ("DELETE".equals(mapping.getParameter())){
			//机柜删除处理
			log.debug("========机柜删除处理开始========");
			
			//DTO输入参数设定
			dto.setDeleteEntityItem(form.getDeleteEiid());
			
			//机柜信息删除逻辑调用
			ctlBL.deleteEntityItemAction(dto);
			
			log.debug("========机柜删除处理终了========");
		}
		
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}

		return mapping.findForward("DISP");
	}
}
