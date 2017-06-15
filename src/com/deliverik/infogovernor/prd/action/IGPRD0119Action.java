/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.prd.action;

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
import com.deliverik.infogovernor.prd.bl.IGPRD01BL;
import com.deliverik.infogovernor.prd.dto.IGPRD01DTO;
import com.deliverik.infogovernor.prd.form.IGPRD0119Form;
import com.deliverik.infogovernor.prd.vo.IGPRD01101VO;

/**
 * 表单信息查询Action处理
 *
 * @author liupeng@deliverik.com
 */
public class IGPRD0119Action extends BaseAction {

	static Log log = LogFactory.getLog(IGPRD0119Action.class);

	/**
	 * 表单信息查询处理
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
		IGPRD0119Form form = (IGPRD0119Form)actionForm;
		
		//BL取得
		IGPRD01BL ctlBL = (IGPRD01BL) getBean("igPRD01BL");
		
		//DTO生成
		IGPRD01DTO dto = new IGPRD01DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//表单信息查询画面初期显示处理
			log.debug("========表单信息查询画面初期显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========表单信息查询画面初期显示处理终了========");
			
			return mapping.findForward("DISP");
		} else if ( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//表单信息查询处理
			log.debug("========表单信息查询处理开始========");
			//分页用DTO取得
			getPaginDTO(req,"IGPRD0117");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGPRD0119Form) req.getSession().getAttribute("IGPRD0119Form");
				if ( form == null ) {
					form = new IGPRD0119Form();
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
					form = (IGPRD0119Form) req.getSession().getAttribute("IGPRD0119Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGPRD0117");
			
			if(form == null){
				form = new IGPRD0119Form();
			}
			dto.setProcessInfoDefGeneralSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//dto.setPdid(form.getPdid());
			//表单信息信息检索逻辑调用
			dto = ctlBL.searchProcessInfoDefGeneralActionFor0119(dto);
			
			//dto = ctlBL.isProcessDefinitionInUse(dto);
			//将表单信息信息检索结果设定到VO中
			IGPRD01101VO vo = new IGPRD01101VO();
			vo.setProcessInfoDefGeneralList(dto.getProcessInfoDefGeneralList());
			//req.setAttribute("isInUse", dto.getIsProcessDefinitionInUse());
			super.<IGPRD01101VO>setVO(req, vo);
			
			log.debug("========表单信息查询处理终了========");
			if("ok".equals(req.getParameter("gtbl"))){
				req.setAttribute("pdid", req.getParameter("pdid"));
				return mapping.findForward("GTBL");
			}
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
