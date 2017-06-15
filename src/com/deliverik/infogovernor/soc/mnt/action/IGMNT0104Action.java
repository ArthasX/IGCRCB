/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
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
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.soc.mnt.bl.IGMNT01BL;
import com.deliverik.infogovernor.soc.mnt.dto.IGMNT01DTO;
import com.deliverik.infogovernor.soc.mnt.form.IGMNT0104Form;
import com.deliverik.infogovernor.soc.mnt.model.MonitorObjectInfo;
import com.deliverik.infogovernor.soc.mnt.vo.IGMNT01041VO;
/**
 * 概述:监控对象管理Action
 * 功能描述：1.监控对象查询
 * 创建记录：张楠    2012/02/09
 */
public class IGMNT0104Action extends BaseAction{
	
	static Log log = LogFactory.getLog(IGMNT0104Action.class);

	/**
	 * 监控对象管理
	 * 
	 * @param mapping
	 * @param actionForm
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		//form取得
		IGMNT0104Form form=(IGMNT0104Form)actionForm;
		//BL取得
		IGMNT01BL ctlBL = (IGMNT01BL) getBean("igmnt01BL");
		//DTO生成
		IGMNT01DTO dto=new IGMNT01DTO();
		dto.setIgmnt0104Form(form);
		if("DISP".equals(mapping.getParameter())){
			log.debug("==============监控对象管理初始化开始===============");
			dto=ctlBL.searchMonitorTypeAction(dto);
			List<LabelValueBean> monitorTypeList = dto.getMonitorTypeList();
			req.getSession().setAttribute("monitorTypeList", monitorTypeList);
			log.debug("==============监控对象管理初始化结束===============");
		}
		if("SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			log.debug("==============监控对象查询开始===============");
			
			//分页用DTO取得
			getPaginDTO(req,"IGMNT0104");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGMNT0104Form) req.getSession().getAttribute("IGMNT0104Form");
				if ( form== null){
					form = new IGMNT0104Form();
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
					form = (IGMNT0104Form) req.getSession().getAttribute("IGMNT0104Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGMNT0104");
			
			//DTO输入参数设定
			dto.setIgmnt0104Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			dto = ctlBL.searchMonitorObjectAction(dto);
			List<MonitorObjectInfo> monitorObjectList = dto.getMonitorObjectList();
		
			IGMNT01041VO vo=new IGMNT01041VO(monitorObjectList);
			super.<IGMNT01041VO>setVO(req, vo);
			log.debug("==============监控对象查询结束===============");
		}
		if("CHANGE".equals(mapping.getParameter())){
			log.debug("==============监控对象状态改变开始===============");
			ctlBL.updateMonitorObjectStatusAction(dto);
			log.debug("==============监控对象状态改变结束===============");
		}
		if("DELETE".equals(mapping.getParameter())){
			log.debug("==============监控对象删除开始===============");
			//存储其它信息删除逻辑调用
			dto=ctlBL.deleteSymmOtherInfoAction(dto);
			//存储基本信息删除逻辑调用
			dto=ctlBL.deleteSymmInfoAction(dto);
			//删除监控对象
			dto=ctlBL.deleteMonitorObject(dto);
			//获取User信息
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			req.getSession().setAttribute(user.getUserid()+"host1","");
			req.getSession().setAttribute(user.getUserid()+"host2","");
			log.debug("==============监控对象删除结束===============");
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
