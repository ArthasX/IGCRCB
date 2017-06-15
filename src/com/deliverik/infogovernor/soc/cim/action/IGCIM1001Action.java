package com.deliverik.infogovernor.soc.cim.action;

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
import com.deliverik.infogovernor.soc.cim.bl.IGCIM10BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM10DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1001Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM04371VO;

/**
 * 伐值设定画面Action处理
 *
 */
public class IGCIM1001Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM1001Action.class);

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
		IGCIM1001Form form = (IGCIM1001Form)actionForm;
		
		//BL取得
		IGCIM10BL ctlBL = (IGCIM10BL) getBean("igcim10BL");
		
		//DTO生成
		IGCIM10DTO dto = new IGCIM10DTO();
		if( "DISP".equals(mapping.getParameter())){
			//伐值画面初期显示处理
			log.debug("========伐值画面初期显示处理开始========");
			
			//***************************************************************************
			//类型分类(设备)设定
			form = new IGCIM1001Form();
			req.setAttribute("IGCIM1001Form", form);
			
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========伐值查询画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}
		if("SEARCH".equals(mapping.getParameter())){
			//分页用DTO取得
			getPaginDTO(req,"IGCIM1001");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			//伐值查询处理
			log.debug("========伐值查询处理开始========");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGCIM1001Form) req.getSession().getAttribute("IGCIM1001Form");
				if ( form== null){
					form = new IGCIM1001Form();
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
					form = (IGCIM1001Form) req.getSession().getAttribute("IGCIM1001Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGCIM1001");
			
			//DTO输入参数设定			
			dto.setSoc0437SearchCond(form);
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			
			//伐值检索逻辑调用
			dto = ctlBL.searchCutItemAction(dto);
			
			//将伐值信息检索结果设定到VO中
			IGCIM04371VO vo = new IGCIM04371VO(dto.getSoc0437InfoList());		
			super.<IGCIM04371VO>setVO(req, vo);
			log.debug("========伐值查询处理终了========");
		}
		if("UPDATE".equals(mapping.getParameter())){
			//伐值设定处理
			form.setEiid(req.getParameter("pdid"));
			dto.setIgcim1001Form(form);
			ctlBL.updateCutValueAction(dto);
			
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
