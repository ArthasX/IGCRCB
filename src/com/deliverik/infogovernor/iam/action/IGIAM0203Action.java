/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
/**
 * 
 */
package com.deliverik.infogovernor.iam.action;

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
import com.deliverik.infogovernor.iam.bl.IGIAM02BL;
import com.deliverik.infogovernor.iam.dto.IGIAM02DTO;
import com.deliverik.infogovernor.iam.form.IGIAM0203Form;
import com.deliverik.infogovernor.iam.vo.IGIAM02011VO;

/**
 * @author zhaomin
 *
 */
/**
 * 概述: 内置工作管理修改、删除action
 * 功能描述：内置工作管理修改、删除action
 * 创建人：赵敏
 * 创建记录： 2012-7-27
 * 修改记录：
 */
public class IGIAM0203Action extends BaseAction {

	static Log log = LogFactory.getLog(IGIAM0203Action.class);
	
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		//获取form
		IGIAM0203Form form = (IGIAM0203Form)actionForm;
		
		//获取bl
		IGIAM02BL iajBL = (IGIAM02BL)getBean("igiam02bl");
		
		//获取dto
		IGIAM02DTO dto = new IGIAM02DTO();
		
		if("EDIT".equals(mapping.getParameter())){
			log.debug("========内审工作编辑处理开始========");
			dto.setIgiam0203form(form);
			dto = iajBL.dsearchIAMAction(dto);
			//初始化VO
			IGIAM02011VO vo = new IGIAM02011VO();
			vo.setIgiam0203form(form);
			vo.setAttkeyList(dto.getAttkeyList());
			super.<IGIAM02011VO>setVO(request, vo);
			log.debug("========内审工作编辑处理结束========");
		}
		if("UPDATE".equals(mapping.getParameter())){
			log.debug("========内审工作修改处理开始========");
			dto.setIgiam0203form(form);
			dto = iajBL.updateIAMAction(dto);
			log.debug("========内审工作修改处理结束========");
		}
		if("DELETE".equals(mapping.getParameter())){
			log.debug("========内审工作删除处理开始========");
			String iajids = request.getParameter("iajids");
			
			dto.setIajids(iajids);
			dto = iajBL.deleteIAMAction(dto);
			log.debug("========内审工作删除处理结束========");
		}
		//附件下载
		if ("LOADFILE".equals(mapping.getParameter())){
			log.debug("========通知附件下载处理开始========");
			
			String attId = request.getParameter("attId");
			String type="iam";
			request.setAttribute("type", type);
			request.setAttribute("attId", attId);

			log.debug("========通知附件下载处理结束========");
			return mapping.findForward("LOADFILE");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}

}
