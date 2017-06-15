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
import com.deliverik.infogovernor.soc.vir.bl.IGVIR11BL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR11DTO;
import com.deliverik.infogovernor.soc.vir.form.IGVIR1102Form;
import com.deliverik.infogovernor.soc.vir.vo.IGVIR11021VO;

/**
 * 概述: 虚拟资源统计（按机构）
 * 功能描述: 虚拟资源统计（按机构）
 * 创建记录: 2014/02/12
 * 修改记录: 
 */
public class IGVIR1102Action extends BaseAction {

	static Log log = LogFactory.getLog(IGVIR1102Action.class);

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
		
		IGVIR1102Form form = (IGVIR1102Form)actionForm;
		//BL取得
		IGVIR11BL ctlBL = (IGVIR11BL) getBean("igvir11BL");
		
		//DTO生成
		IGVIR11DTO dto = new IGVIR11DTO();
		
		String forward = "DISP";
		if ("DISP".equals(mapping.getParameter())){
			log.debug("========虚拟资源统计显示开始（按机构）========");
			form.setOrgname(null);
			form.setOrgsyscoding_like(null);
			IGVIR11021VO vo = new IGVIR11021VO();
			super.<IGVIR11021VO>setVO(req, vo);
			log.debug("========虚拟资源统计显示终了（按机构）========");
		}else if("SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			log.debug("========虚拟资源统计查询开始（按机构）========");
			getPaginDTO(req,"IGVIR1102");
			PagingDTO pDto;
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				form = (IGVIR1102Form) req.getSession().getAttribute("IGVIR1102Form");
				if ( form== null){
					form = new IGVIR1102Form();
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
					form = (IGVIR1102Form) req.getSession().getAttribute("IGVIR1102Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			int maxCnt = getMaxDataCount("IGVIR1102");
			dto.setIgVIR1102Form(form);
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			ctlBL.getVim03CountByOrg(dto);
			IGVIR11021VO vo = new IGVIR11021VO();
			vo.setVim03oList(dto.getVim03oList());
			
			super.<IGVIR11021VO>setVO(req.getSession(), vo);
			log.debug("========虚拟资源统计查询终了（按机构）========");
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
