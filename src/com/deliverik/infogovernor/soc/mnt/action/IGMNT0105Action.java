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
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.soc.dbs.model.entity.Collect_Symmetrix_InfoTB;
import com.deliverik.infogovernor.soc.mnt.bl.IGMNT01BL;
import com.deliverik.infogovernor.soc.mnt.dto.IGMNT01DTO;
import com.deliverik.infogovernor.soc.mnt.form.IGMNT0103Form;
import com.deliverik.infogovernor.soc.mnt.model.MonitorObjectDefInfo;
import com.deliverik.infogovernor.soc.mnt.model.MonitorObjectInfo;
import com.deliverik.infogovernor.soc.mnt.model.entity.MonitorTypeTB;
import com.deliverik.infogovernor.soc.mnt.vo.IGMNT01051VO;
/**
 * 概述:监控对象修改Action
 * 功能描述：1.监控对象修改
 * 创建记录：张楠    2012/02/09
 */
public class IGMNT0105Action extends BaseAction{
	
	static Log log = LogFactory.getLog(IGMNT0105Action.class);
	
	/**
	 * 监控对象修改
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
		IGMNT0103Form form=(IGMNT0103Form)actionForm;
		//BL取得
		IGMNT01BL ctlBL = (IGMNT01BL) getBean("igmnt01BL");
		//DTO生成
		IGMNT01DTO dto=new IGMNT01DTO();
		dto.setIgmnt0103Form(form);
		if("DISP".equals(mapping.getParameter())){
			log.debug("==============监控对象修改初始化开始===============");
			dto=ctlBL.searchMonitorTypeAction(dto);
			List<LabelValueBean> monitorTypeList = dto.getMonitorTypeList();
			req.getSession().setAttribute("monitorTypeList", monitorTypeList);
			//获取监控对象
			dto=ctlBL.searchMonitorObjectByPKAction(dto);
			MonitorObjectInfo monitorObject = dto.getMonitorObject();
			MonitorTypeTB monitorTypeTB = monitorObject.getMonitorTypeTB();
			form.setSymm_id(monitorObject.getMoName());
			form.setMtId(String.valueOf(monitorTypeTB.getMtId()));
			form.setMtName(monitorTypeTB.getMtName());
			form.setIp(monitorObject.getIp());
			Collect_Symmetrix_InfoTB collect_Symmetrix_InfoTB = monitorObject.getCollect_Symmetrix_InfoTB();
			form.setSymm_model(collect_Symmetrix_InfoTB.getSymm_model());
			form.setSymm_version(collect_Symmetrix_InfoTB.getSymm_version());
			form.setSymm_cachesize(collect_Symmetrix_InfoTB.getSymm_cachesize());
			//获取监控对象阀值集合
			dto=ctlBL.searchMonitorObjectDefAction(dto);
			List<MonitorObjectDefInfo> monitorObjectDefList = dto.getMonitorObjectDefList();
			IGMNT01051VO vo=new IGMNT01051VO(monitorObjectDefList);
			super.<IGMNT01051VO>setVO(req, vo);
			log.debug("==============监控对象修改初始化结束===============");
		}
		if("UPDATE".equals(mapping.getParameter())){
			log.debug("==============监控对象信息修改开始===============");
			ctlBL.updateMonitorObjectAction(dto);
			log.debug("==============监控对象信息修改结束===============");
		}
		return mapping.findForward("DISP");
	}
}
