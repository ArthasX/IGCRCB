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
import com.deliverik.infogovernor.asset.bl.IGASM02BL;
import com.deliverik.infogovernor.asset.dto.IGASM02DTO;
import com.deliverik.infogovernor.asset.form.IGASM0201Form;
import com.deliverik.infogovernor.asset.vo.IGASM02011VO;

/**
 * 配置项查询画面Action处理
 *
 */
public class IGASM0201Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM0201Action.class);

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
		IGASM0201Form form = (IGASM0201Form)actionForm;
		
		//BL取得
		IGASM02BL ctlBL = (IGASM02BL) getBean("igasm02BL");
		
		//DTO生成
		IGASM02DTO dto = new IGASM02DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//配置项查询画面初期显示处理
			log.debug("========配置项查询画面初期显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========配置项查询画面初期显示处理终了========");
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			//配置项查询画面再显示处理
			log.debug("========配置项查询画面再显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========配置项查询画面再显示处理终了========");
			return mapping.findForward("DISP");
		}	

		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//分页用DTO取得
			getPaginDTO(req,"IGASM0201");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			//配置项查询处理
			log.debug("========配置项查询处理开始========");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGASM0201Form) req.getSession().getAttribute("IGASM0201Form");
				if ( form== null){
					form = new IGASM0201Form();
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
					form = (IGASM0201Form) req.getSession().getAttribute("IGASM0201Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}

			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGASM0201");
			
			
			
			//DTO输入参数设定
			dto.setEntityItemVWSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//配置项检索逻辑调用
			dto = ctlBL.searchEntityItemAction(dto);
			
			//将配置项信息检索结果设定到VO中
			IGASM02011VO vo = new IGASM02011VO(dto.getEntityItemVWInfoList());
			
			super.<IGASM02011VO>setVO(req, vo);
			
			log.debug("========配置项查询处理终了========");
		}
		if ("DELETE".equals(mapping.getParameter())){
			//配置项删除处理
			log.debug("========配置项删除处理开始========");
			
			//DTO输入参数设定
			dto.setDeleteEntityItem(form.getDeleteEiid());
			
			//配置项信息删除逻辑调用
			ctlBL.deleteEntityItemAction(dto);
			
			log.debug("========配置项删除处理终了========");
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
