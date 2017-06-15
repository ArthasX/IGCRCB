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
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCondImpl;
import com.deliverik.infogovernor.prd.bl.IGPRD01BL;
import com.deliverik.infogovernor.prd.dto.IGPRD01DTO;
import com.deliverik.infogovernor.prd.form.IGPRD0117Form;
import com.deliverik.infogovernor.prd.vo.IGPRD01101VO;

/**
 * 表单信息查询Action处理
 *
 * @author liupeng@deliverik.com
 */
public class IGPRD0117Action extends BaseAction {

	static Log log = LogFactory.getLog(IGPRD0117Action.class);

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
		IGPRD0117Form form = (IGPRD0117Form)actionForm;
		
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
				form = (IGPRD0117Form) req.getSession().getAttribute("IGPRD0117Form");
				if ( form == null ) {
					form = new IGPRD0117Form();
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
					form = (IGPRD0117Form) req.getSession().getAttribute("IGPRD0117Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGPRD0117");
			
			dto.setProcessInfoDefGeneralSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//dto.setPdid(form.getPdid());
			//表单信息信息检索逻辑调用
			dto = ctlBL.searchProcessInfoDefGeneralAction(dto);
			
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
			if("basic".equals(req.getParameter("gtbl"))){
				boolean flag = false;//如果该流程类型有正在处理中的流程时不让增加表单和缺省参与人。
				StringBuffer mesg = new StringBuffer("");
				IG500BL ig500BL = (IG500BL)getBean("ig500BL");
				IG500SearchCondImpl cond = new IG500SearchCondImpl();
				cond.setPrpdid(form.getPdid());
				List<IG500Info> list = ig500BL.searchIG500Info(cond);
				for(IG500Info pr:list){
					if(!"C".equals(pr.getPrstatus())){
						if(!flag){
							flag = true;
						}
						mesg=mesg.append(pr.getPrserialnum()+",");
					}
				}
				if(flag){
					form.setDisp("0");
					dto.addMessage(new ActionMessage("IGPRM0302.E001",mesg.toString().substring(0,mesg.toString().length()-1)));
					List<ActionMessage> messageList = dto.getMessageList();
					if( messageList != null && messageList.size() > 0 ) {
						for (ActionMessage message : messageList) {	
							addMessage(req, message);
						}
					}
				}
				req.setAttribute("pdid", req.getParameter("pdid"));
				return mapping.findForward("BASIC");
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
