package com.deliverik.infogovernor.kgm.action;

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
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.kgm.bl.IGKGM02BL;
import com.deliverik.infogovernor.kgm.bl.IGKGMCONSTANTS;
import com.deliverik.infogovernor.kgm.dto.IGKGM03DTO;
import com.deliverik.infogovernor.kgm.form.IGKGM0202Form;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeSearchCondImpl;
import com.deliverik.infogovernor.kgm.vo.IGKGM02011VO;

public class IGKGM0202Action extends BaseAction{

	static Log log = LogFactory.getLog(IGKGM0201Action.class);
	
	/**
	 * 知识查询
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
		IGKGM0202Form form = (IGKGM0202Form)actionForm;
		
		//BL取得
		IGKGM02BL ctlBL = (IGKGM02BL) getBean("igkgm02BL");
		
		//DTO生成
		IGKGM03DTO dto = new IGKGM03DTO();
		
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);

		if("DISP".equals(mapping.getParameter())){
			//知识查询画面再显示处理
			log.debug("========知识查询画面再显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========知识查询画面再显示处理终了========");
			return mapping.findForward("DISP");
	    }else if( "SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())){
	    	

			//知识查询处理
			log.debug("========知识查询处理开始========");
			
			//分页用DTO取得
			getPaginDTO(req,"IGKGM0202");
			PagingDTO pDto;
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGKGM0202Form) req.getSession().getAttribute("IGKGM0202Form");
				if ( form == null ) {
					form = new IGKGM0202Form();
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
					form = (IGKGM0202Form) req.getSession().getAttribute("IGKGM0202Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			int maxCnt = getMaxDataCount("IGKGM0202");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);

			//知识查询处理
			KnowledgeSearchCondImpl cond = new KnowledgeSearchCondImpl();
			cond.setKnproffer(user.getUserid());
			cond.setKnstatus(IGKGMCONSTANTS.KNOWLEDGE_REJECT + "," + IGKGMCONSTANTS.KNOWLEDGE_INIT+ "," + IGKGMCONSTANTS.KNOWLEDGE_UN_APPROVE);
            dto.setKnowledgeSearchCond(cond);
            
			//DTO输入参数设定
			dto.setIgkgm0202Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//知识信息检索逻辑调用
			dto = ctlBL.searchMyKnowLedgeAction(dto);
			
			//将知识类型信息检索结果设定到VO中
			IGKGM02011VO vo = new IGKGM02011VO();
			vo.setKnowledgeList(dto.getKnowledgeList());
			super.<IGKGM02011VO>setVO(req, vo);
			
			log.debug("========知识查询处理终了========");
			
	    }  else if( "DELETE".equals(mapping.getParameter())){
			log.debug("========知识删除处理开始========");
			dto.setIgkgm0202Form(form);
			ctlBL.deleteKnowLedgeAction(dto);
			log.debug("========知识删除处理结束========");
			return mapping.findForward("DELETE");
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
