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
import org.apache.struts.util.MessageResources;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.soc.mnt.bl.IGMNT01BL;
import com.deliverik.infogovernor.soc.mnt.dto.IGMNT01DTO;
import com.deliverik.infogovernor.soc.mnt.form.IGMNT0102Form;
import com.deliverik.infogovernor.soc.mnt.model.MonitorTypeDefInfo;
import com.deliverik.infogovernor.soc.mnt.vo.IGMNT01021VO;
/**
 * 概述:监控类型阀值信息Action
 * 功能描述：1.监控类型阀值信息查询
 *           2.监控类型阀值信息修改
 * 创建记录：张楠    2012/02/09
 */
public class IGMNT0102Action extends BaseAction{
	
	static Log log = LogFactory.getLog(IGMNT0102Action.class);

	protected MessageResources resources = MessageResources.getMessageResources("com.deliverik.infogovernor.soc.mnt.mntResources"); 
	
	/**
	 * 监控类型阀值信息处理
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
		IGMNT0102Form form=(IGMNT0102Form)actionForm;
		//BL取得
		IGMNT01BL ctlBL = (IGMNT01BL) getBean("igmnt01BL");
		//DTO生成
		IGMNT01DTO dto=new IGMNT01DTO();
		dto.setIgmnt0102Form(form);
		if("DISP".equals(mapping.getParameter())){
			log.debug("==============监控类型阀值信息初始化开始===============");
			req.getSession().removeAttribute("mtId");
			req.getSession().removeAttribute("mtName");
			log.debug("==============监控类型阀值信息初始化结束===============");
		}
		if("SEARCH".equals(mapping.getParameter())){
			log.debug("==============监控类型阀值信息查询开始===============");
			dto = ctlBL.searchMonitorTypeDefAction(dto);
			List<MonitorTypeDefInfo> monitorTypeDefInfoList = dto.getMonitorTypeDefInfoList();
			Integer mtId = form.getMtId();
			req.setAttribute("mtId", mtId);
			if(monitorTypeDefInfoList!=null&&monitorTypeDefInfoList.size()>0){
				IGMNT01021VO vo=new IGMNT01021VO(monitorTypeDefInfoList);
				super.<IGMNT01021VO>setVO(req, vo);
			}
			log.debug("==============监控类型阀值信息查询结束===============");
		}
		if("UPDATE".equals(mapping.getParameter())){
			log.debug("==============监控类型阀值信息修改开始===============");
			ctlBL.updateMonitorTypeDefAction(dto);
			//更新容量阈值
			ctlBL.updateCapacityObject(dto);
			addMessage(req, new ActionMessage("IGCO10000.I005", resources.getMessage(getLocale(req),"message.IGMNT01BLImpl.002")));
			log.debug("==============监控类型阀值信息修改结束===============");
		}
		return mapping.findForward("DISP");
	}
}
