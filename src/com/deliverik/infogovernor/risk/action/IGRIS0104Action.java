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
import com.deliverik.infogovernor.risk.form.IGRIS0104Form;
import com.deliverik.infogovernor.risk.vo.IGRIS01051VO;

/**
 * 审计项查询Action处理
 *
 */
public class IGRIS0104Action extends BaseAction {

	static Log log = LogFactory.getLog(IGRIS0104Action.class);

	/**
	 * 成功处理
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {

		//实例化FORM
		IGRIS0104Form form = (IGRIS0104Form)actionForm;
		//获取BL接口实例
		IGRIS01BL ctlBL = (IGRIS01BL) getBean("igRIS01BL");
		//实例化DTO
		IGRIS01DTO dto = new IGRIS01DTO();
		//获取版本号下拉列表
		dto = ctlBL.searchRiskAuditLabelInUse(dto);
		req.setAttribute("labelList", dto.getLabelList());
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========审计项管理画面初期显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========审计项管理画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}
		if( "BUTTON".equals(mapping.getParameter())){
			log.debug("========审计项管理画面初期显示处理开始========");
			if (req.getParameter("btn_next")!=null) {
				//审计项查询下一级画面跳转
				log.debug("========审计项信息添加========");
				return mapping.findForward("NEXT");
			}
			if (req.getParameter("btn_all")!=null) {
				//审计项查询全部下级画面跳转
				log.debug("========审计项列表========");
				return mapping.findForward("ALL");
			}	
			log.debug("========审计项管理画面初期显示处理终了========");
			return mapping.findForward(null);
		} 
		if( "NEXT".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){	//审计项下一级查询
			log.debug("========审计项查询处理开始========");
			//获取分页Bean
			getPaginDTO(req,"IGRIS0104");

			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGRIS0104Form) req.getSession().getAttribute("IGRIS0104Form");
				if ( form== null){
					form = new IGRIS0104Form();
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
					form = (IGRIS0104Form) req.getSession().getAttribute("IGRIS0104Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			int maxCnt = getMaxDataCount("IGRIS0104");
			
			dto.setIgRIS0104Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			//调用BL查询
			dto = ctlBL.searchRiskAuditDefNextAction(dto);
			//构造VO
			IGRIS01051VO vo = new IGRIS01051VO(dto.getRiskAuditDefList());
			super.<IGRIS01051VO>setVO(req, vo);
			log.debug("========审计项查询处理终了========");
		}
		if( "ALL".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){	//审计项全部下级查询
			log.debug("========审计项查询处理开始========");
			//获取分页Bean
			getPaginDTO(req,"IGRIS0104");

			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGRIS0104Form) req.getSession().getAttribute("IGRIS0104Form");
				if ( form== null){
					form = new IGRIS0104Form();
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
					form = (IGRIS0104Form) req.getSession().getAttribute("IGRIS0104Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			int maxCnt = getMaxDataCount("IGRIS0104");
			
			dto.setIgRIS0104Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			//调用BL查询
			dto = ctlBL.searchRiskAuditDefAllAction(dto);
			//构造VO
			IGRIS01051VO vo = new IGRIS01051VO(dto.getRiskAuditDefList());
			super.<IGRIS01051VO>setVO(req, vo);
			log.debug("========审计项查询处理终了========");
		}
		if("TREE".equals(mapping.getParameter())){
			dto.setIgRIS0104Form(form);
			dto = ctlBL.searchAuditTreeAction(dto);
			//构造VO
			IGRIS01051VO vo = new IGRIS01051VO();
			vo.setTreeNodeMap(dto.getTreeNodeMap());
			super.<IGRIS01051VO>setVO(req, vo);
		}
		if ("CHANGE".equals(mapping.getParameter())){
			log.debug("========审计项停用/启用处理开始========");
			//DTO输入参数设定
			dto.setIgRIS0104Form(form);
			
			ctlBL.changeRiskAuditDefAction(dto);
			
			log.debug("========审计项停用/启用处理终了========");
	}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
		}
		return mapping.findForward("DISP");
	}
}
