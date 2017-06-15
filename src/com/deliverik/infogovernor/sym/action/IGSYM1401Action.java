/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.action;

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
import com.deliverik.infogovernor.sym.bl.IGSYM14BL;
import com.deliverik.infogovernor.sym.dto.IGSYM14DTO;
import com.deliverik.infogovernor.sym.form.IGSYM1401Form;
import com.deliverik.infogovernor.sym.vo.IGSYM14011VO;

/**
 * 报表查询Action处理
 *
 */
public class IGSYM1401Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSYM1401Action.class);

	/**
	 * 报表查询处理
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
		IGSYM1401Form form = (IGSYM1401Form)actionForm;
		
		//BL取得
		IGSYM14BL ctlBL = (IGSYM14BL) getBean("igSYM14BL");
		
		//DTO生成
		IGSYM14DTO dto = new IGSYM14DTO();
		
		if ( "SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())){
			//报表查询处理
			log.debug("========报表查询处理开始========");
			//分页用DTO取得
			getPaginDTO(req,"IGSYM1401");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGSYM1401Form) req.getSession().getAttribute("IGSYM1401Form");
				if ( form == null ) {
					form = new IGSYM1401Form();
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
					form = (IGSYM1401Form) req.getSession().getAttribute("IGSYM1401Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGSYM1401");
			
			dto.setReportFileDefinitionSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//报表信息检索逻辑调用
			dto = ctlBL.searchReportFileDefinitionAction(dto);
			
			//将报表信息检索结果设定到VO中
			IGSYM14011VO vo = new IGSYM14011VO(dto.getReportFileDefinitionList());
			
			super.<IGSYM14011VO>setVO(req, vo);
			
			log.debug("========报表查询处理终了========");
		} else if("DELETE".equals(mapping.getParameter())){
			log.debug("========报表删除处理开始========");
			dto.setDeleteRfdid(form.getDeleteRfdid());
			ctlBL.deleteReportFileDefinitionAction(dto);
			log.debug("========报表删除处理终了========");
		} else if("VERSION".equals(mapping.getParameter())){
			log.debug("========报表版本升级处理开始========");
			dto.setRfdid(form.getRfdid());
			ctlBL.insertReportFileVersionAction(dto);
			log.debug("========报表版本升级处理终了========");
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
