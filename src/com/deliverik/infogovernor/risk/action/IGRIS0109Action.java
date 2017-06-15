/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.risk.action;

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
import com.deliverik.infogovernor.risk.bl.IGRIS01BL;
import com.deliverik.infogovernor.risk.dto.IGRIS01DTO;
import com.deliverik.infogovernor.risk.form.IGRIS0109Form;
import com.deliverik.infogovernor.risk.vo.IGRIS01091VO;

/**
 * 审计发起查询Action处理
 *
 * @author liupeng@deliverik.com
 */
public class IGRIS0109Action extends BaseAction {

	static Log log = LogFactory.getLog(IGRIS0109Action.class);

	/**
	 * 审计发起查询处理
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
		IGRIS0109Form form = (IGRIS0109Form)actionForm;
		
		//BL取得
		IGRIS01BL ctlBL = (IGRIS01BL) getBean("igRIS01BL");
		
		//DTO生成
		IGRIS01DTO dto = new IGRIS01DTO();
		
		//获取版本名称下拉列表
		dto = ctlBL.searchRiskAuditLabelInUse(dto);
		req.setAttribute("labelList", dto.getLabelList());
		
		if( "DISP".equals(mapping.getParameter())){
			//审计发起查询画面初期显示处理
			log.debug("========审计发起查询画面初期显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========审计发起查询画面初期显示处理终了========");
			return mapping.findForward("DISP");
		} else if ( "SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())){
			//审计发起查询处理
			log.debug("========审计发起查询处理开始========");
			//分页用DTO取得
			getPaginDTO(req,"IGRIS0109");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGRIS0109Form) req.getSession().getAttribute("IGRIS0109Form");
				if ( form == null ) {
					form = new IGRIS0109Form();
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
					form = (IGRIS0109Form) req.getSession().getAttribute("IGRIS0109Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGRIS0109");
			
			dto.setRiskAuditInsSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//审计发起信息检索逻辑调用
			dto = ctlBL.searchRiskAuditInsAction(dto);
			
			//将审计发起信息检索结果设定到VO中
			IGRIS01091VO vo = new IGRIS01091VO(dto.getRiskAuditInsList());
			
			super.<IGRIS01091VO>setVO(req, vo);
			
			log.debug("========审计发起查询处理终了========");
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
