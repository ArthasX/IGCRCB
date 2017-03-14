/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.soc.vir.bl.IGVIR06BL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR06DTO;

/**
 * 概述: 阜新拓扑，虚拟化管理显示
 * 功能描述: 虚拟化管理显示Action
 * 创建记录: 2013/12/25
 * 修改记录: 
 */
public class IGVIR0601Action extends BaseAction {

	static Log log = LogFactory.getLog(IGVIR0601Action.class);

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
		//BL取得
		IGVIR06BL ctlBL = (IGVIR06BL) getBean("igvir06BL");
		
		//DTO生成
		IGVIR06DTO dto = new IGVIR06DTO();
		
		if ("DISP".equals(mapping.getParameter())){
			log.debug("========VMTopoMap_FuXinApp显示开始========");
			//关系树xml查询
			String eiid=req.getParameter("EIID");
			dto.setEiid(eiid);
			dto = ctlBL.getVMWareTree(dto);
			String treeXml = dto.getTreeXml();
			System.out.println(treeXml);
			req.setAttribute("treeXml", treeXml);
			if(StringUtils.isNotEmpty(eiid)){
				req.setAttribute("eiid", eiid);
			}else{
				req.setAttribute("eiid", dto.getEiid());
			}
			
			log.debug("========VMTopoMap_FuXinApp显示终了========");
		}
		
		return mapping.findForward("DISP");
	}
}
