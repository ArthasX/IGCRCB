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
import com.deliverik.infogovernor.sym.bl.IGSYM04BL;
import com.deliverik.infogovernor.sym.dto.IGSYM04DTO;
import com.deliverik.infogovernor.sym.form.IGSYM0413Form;
import com.deliverik.infogovernor.sym.vo.IGSYM04091VO;

/**
 * 报表查询Action处理
 *
 */
public class IGSYM0413Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSYM0413Action.class);

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
		IGSYM0413Form form = (IGSYM0413Form)actionForm;
		
		//BL取得
		IGSYM04BL ctlBL = (IGSYM04BL) getBean("igsym04BL");
		
		//DTO生成
		IGSYM04DTO dto = new IGSYM04DTO();
		
		if ( "SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())){
			//报表查询处理
			log.debug("========报表查询处理开始========");
			//分页用DTO取得
			getPaginDTO(req,"IGSYM0413");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGSYM0413Form) req.getSession().getAttribute("IGSYM0413Form");
				if ( form == null ) {
					form = new IGSYM0413Form();
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
					form = (IGSYM0413Form) req.getSession().getAttribute("IGSYM0413Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGSYM0413");
			
			dto.setReportFileDefinitionSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//报表信息检索逻辑调用
			dto = ctlBL.searchReportFileDefinitionAction(dto);
			
			//将报表信息检索结果设定到VO中
			IGSYM04091VO vo = new IGSYM04091VO(dto.getReportFileDefinitionList());
			
			super.<IGSYM04091VO>setVO(req, vo);
			
			log.debug("========报表查询处理终了========");
		} else if ("INIT".equals(mapping.getParameter())){ //报表信息变更页面初始化
			
			log.debug("========报表信息变更初期显示处理开始========");
			
			dto.setIgSYM0413Form(form);
			
			dto = ctlBL.initReportFileDefinitionAction(dto);
			
			log.debug("========报表信息变更初期显示处理终了========");
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
