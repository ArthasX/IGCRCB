/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.mnt.action;

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
import com.deliverik.infogovernor.soc.mnt.bl.IGMNT02BL;
import com.deliverik.infogovernor.soc.mnt.dto.IGMNT02DTO;
import com.deliverik.infogovernor.soc.mnt.form.IGMNT0112Form;
import com.deliverik.infogovernor.soc.mnt.vo.IGMNT01121VO;

/**
 * 概述: 容量监控管理Action
 * 功能描述: 容量监控管理Action
 * 创建记录: 2012-8-2
 * 修改记录: 
 */
public class IGMNT0112Action extends BaseAction{
	
	static Log log = LogFactory.getLog(IGMNT0104Action.class);

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		//获取查询form
		IGMNT0112Form form=(IGMNT0112Form)actionForm;
		//BL取得
		IGMNT02BL ctlBL = (IGMNT02BL) getBean("igmnt02BL");
		//DTO生成
		IGMNT02DTO dto=new IGMNT02DTO();
		//查询主机select
		ctlBL.initHostListSelectAction(dto);
		//存放到session
		req.getSession().setAttribute("ADHostList", dto.getLabelValueBeanList());
		
		if("SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			log.debug("==============容量监控管理查询开始===============");
			
			//分页用DTO取得
			getPaginDTO(req,"IGMNT0112");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGMNT0112Form) req.getSession().getAttribute("IGMNT0112Form");
				if ( form== null){
					form = new IGMNT0112Form();
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
					form = (IGMNT0112Form) req.getSession().getAttribute("IGMNT0112Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGMNT0112");
			
			//DTO输入参数设定
			dto.setIgmnt0112Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			dto = ctlBL.searchSOC0423Action(dto);
			IGMNT01121VO vo=new IGMNT01121VO();
			vo.setSoc0423List(dto.getSoc0423List());
		
			super.<IGMNT01121VO>setVO(req, vo);
			log.debug("==============容量监控管理查询结束===============");
		}
		if("UPDATE".equals(mapping.getParameter())){
			log.debug("==============容量监控管理查询更新开始===============");
			dto.setIgmnt0112Form(form);
			ctlBL.updateSOC0423Action(dto);
			log.debug("==============容量监控管理查询更新结束===============");
			
		}
		if("DISP".equals(mapping.getParameter())){
			log.debug("==============容量监控管理查询页面显示开始===============");
			log.debug("==============容量监控管理查询页面显示结束===============");
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
