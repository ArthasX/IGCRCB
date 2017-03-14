/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.action;


import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.soc.vir.bl.IGVIR12BL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR12DTO;
import com.deliverik.infogovernor.soc.vir.form.IGVIR1201Form;
import com.google.gson.Gson;

/**
 * 概述: 资源占用情况
 * 功能描述: 资源占用情况
 * 创建记录: 2014/02/12
 * 修改记录: 
 */
public class IGVIR1201Action extends BaseAction {

	static Log log = LogFactory.getLog(IGVIR1201Action.class);

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
		
	    IGVIR1201Form form = (IGVIR1201Form)actionForm;
		//BL取得
		IGVIR12BL ctlBL = (IGVIR12BL) getBean("igvir12BL");

		//DTO生成
		IGVIR12DTO dto = new IGVIR12DTO();
		
		String forward = "DISP";
		if ("DISP".equals(mapping.getParameter())){
		    log.debug("============= 资源分配情况初始化开始 ==============");
			log.debug("---- 显示的主机：" + form.getHostname() + "-------------");
			form.setHostname(form.getHostname());
		    log.debug("============= 资源分配情况初始化结束 ==============");
		}else if("TREEDATA".equals(mapping.getParameter())){
            log.debug("========开始========");
			PrintWriter out = null;
            try {
            	out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
            	ctlBL.getvCenterList(dto);
    			Gson gson = new Gson();
				gson.toJson(dto.getTreeData(), out);
            } catch (Exception e) {
                out.print("");
                log.error("AjaxAction Exception", e);
            } finally {
                if (out != null)
                    out.close();
            }
            log.debug("========终了========");
            return null;
		}else if("PAGEDATA".equals(mapping.getParameter())){
            log.debug("========开始========");
			PrintWriter out = null;
            try {
            	out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
            	String treeId = req.getParameter("treeId");
            	dto.setTreeId(treeId);
            	ctlBL.getHostInfo(dto);
    			Gson gson = new Gson();
				gson.toJson(dto.getHost(), out);
            } catch (Exception e) {
                out.print("");
                log.error("AjaxAction Exception", e);
            } finally {
                if (out != null)
                    out.close();
            }
            log.debug("========终了========");
            return null;
        //启动或者关闭虚机
		}else if("OPRATE".equals(mapping.getParameter())){
			log.debug("========虚机操作开始========");
			String treeId = req.getParameter("treeId");
			String vmname = req.getParameter("vmName");
			String type = req.getParameter("type");
			dto.setTreeId(treeId);
			dto.setVmName(vmname);
			dto.setOprateType(type);
			ctlBL.startOrStopPowerOfVM(dto);
			log.debug("========虚机操作终了========");
		}
//		List<ActionMessage> messageList = dto.getMessageList();
//		if( messageList != null && messageList.size() > 0 ) {
//			for (ActionMessage message : messageList) {	
//				addMessage(req, message);
//			}
//		}
		return mapping.findForward(forward);
	}
}
