/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.soc.mnt.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.soc.mnt.bl.IGMNT01BL;
import com.deliverik.infogovernor.soc.mnt.dto.IGMNT01DTO;
import com.deliverik.infogovernor.soc.mnt.vo.IGMNT01011VO;
/**
 * 概述:监控管理类型树查询Action
 * 功能描述：1.监控管理类型树查询
 * 创建记录：张楠    2012/02/09
 */
public class IGMNT0101Action extends BaseAction{
	static Log log = LogFactory.getLog(IGMNT0101Action.class);

	/**
	 * 监控管理类型树查询
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
		//BL取得
		IGMNT01BL ctlBL = (IGMNT01BL) getBean("igmnt01BL");
		//DTO生成
		IGMNT01DTO dto=new IGMNT01DTO();
		//监控管理类型树查询
		dto = ctlBL.searchMonitorTypeTreeAction(dto);
		IGMNT01011VO vo=new IGMNT01011VO(dto.getTreeNodeMap());
		super.<IGMNT01011VO>setVO(req, vo);
		return mapping.findForward("DISP");
	}
	
	
}
