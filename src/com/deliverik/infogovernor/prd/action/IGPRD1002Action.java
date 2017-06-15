/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prd.action;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
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
import com.deliverik.infogovernor.prd.bl.IGPRD10BL;
import com.deliverik.infogovernor.prd.dto.IGPRD10DTO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程定义Action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGPRD1002Action extends BaseAction {

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//日志对象取得
		Log log = LogFactory.getLog(IGPRD1002Action.class);
		//BL取得
		IGPRD10BL ctlBL = (IGPRD10BL) getBean("igprd10BL");
		//实例化dto
		IGPRD10DTO dto = new IGPRD10DTO();
		//dto参数设定
		dto.setForm(actionForm);

		response.setCharacterEncoding("utf-8");
		//页面初始化操作
		if("DISP".equals(mapping.getParameter())){
			log.debug("============流程定义页面初始化操作开始=============");
			dto = ctlBL.initProcessDefinitionAction(dto);
			log.debug("============流程定义页面初始化操作结束=============");
		}
		if("CHANGE".equals(mapping.getParameter())){
			log.debug("===========流程定义信息更改操作============");
			try {
				dto = ctlBL.changeProcessDefinitionAction(dto);
				response.getWriter().write("{\"msg\":\"success\"}");
			} catch (Exception e) {
				response.getWriter().write("{\"msg\":\"保存场景定义错误\",\"err\":\"" + e.getMessage() + "\"}");
			}
			log.debug("===========流程定义信息更改结束============");
		}
		if("GETBUTTON".equals(mapping.getParameter())){
			log.debug("==========节点按钮信息取得操作开始==========");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "utf-8"));
				dto = ctlBL.searchProcessStepButtonAction(dto);
				out.print(dto.getAjaxResult());
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("==========节点按钮信息取得操作结束==========");
		}
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}

}
