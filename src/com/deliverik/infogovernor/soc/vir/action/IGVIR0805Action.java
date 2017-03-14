/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.action;


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
import com.deliverik.infogovernor.soc.vir.bl.IGVIR08BL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR08DTO;
import com.deliverik.infogovernor.soc.vir.form.IGVIR0805Form;
import com.deliverik.infogovernor.soc.vir.vo.IGVIR08051VO;

/**
 * 概述: 虚拟资源统计（按用户）
 * 功能描述: 虚拟资源统计（按用户）
 * 创建记录: 2014/02/12
 * 修改记录: 
 */
public class IGVIR0805Action extends BaseAction {

	static Log log = LogFactory.getLog(IGVIR0805Action.class);

	/**
	 * 配置包含关系显示处理
	 *
	 * @param mapping ActionMapping 
	 * @param actionForm ActionForm 
	 * @param req HttpServletRequest 
	 * @param res HttpServletResponse 
	 * @return ActionForward
	 * @throws Exception
	 */
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		IGVIR0805Form form = (IGVIR0805Form)actionForm;
		//BL取得
		IGVIR08BL ctlBL = (IGVIR08BL) getBean("igvir08BL");
		
		//DTO生成
		IGVIR08DTO dto = new IGVIR08DTO();
		
		String forward = "DISP";
		if ("DISP".equals(mapping.getParameter())){
			log.debug("========虚拟资源统计显示开始（按用户）========");
			form.setPname_like(null);
			IGVIR08051VO vo = new IGVIR08051VO();
			super.<IGVIR08051VO>setVO(req, vo);
			log.debug("========虚拟资源统计显示终了（按用户）========");
		}else if("SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			log.debug("========虚拟资源统计查询开始（按用户）========");
			getPaginDTO(req,"IGVIR0805");
			PagingDTO pDto;
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				form = (IGVIR0805Form) req.getSession().getAttribute("IGVIR0805Form");
				if ( form== null){
					form = new IGVIR0805Form();
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
					form = (IGVIR0805Form) req.getSession().getAttribute("IGVIR0805Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			int maxCnt = getMaxDataCount("IGVIR0805");
			dto.setIgVIR0805Form(form);
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			ctlBL.getVim03CountByProj(dto);
			IGVIR08051VO vo = new IGVIR08051VO();
			vo.setVim03pList(dto.getVim03pList());
			
			super.<IGVIR08051VO>setVO(req.getSession(), vo);
			log.debug("========虚拟资源统计查询终了（按用户）========");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
		}
		return mapping.findForward(forward);
	}
}
