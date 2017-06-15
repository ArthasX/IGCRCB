/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.mnt.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.soc.mnt.bl.IGMNT01BL;
import com.deliverik.infogovernor.soc.mnt.model.SOC0301Info;

/**
 * 概述: 实时性能数据导出
 * 功能描述: 实时性能数据导出
 * 创建记录: 2012/05/17
 * 修改记录: 
 */
public class IGMNT0109Action extends BaseAction{

	static Log log = LogFactory.getLog(IGMNT0109Action.class);
	
	public ActionForward doProcess(ActionMapping mapping, ActionForm arg1,
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//BL取得
		IGMNT01BL ctlBL = (IGMNT01BL) getBean("igmnt01BL");
		log.debug("=============实时性能数据导出开始=============");
		int mtId=Integer.parseInt(req.getParameter("MtId"));
		Map<String, List<SOC0301Info>> dataMap = ctlBL.getDataMap(mtId);//取得实时性能数据集合
		req.setAttribute("dataMap", dataMap);
		log.debug("=============实时性能数据导出终了=============");
		return mapping.findForward("DISP");
	}
}
