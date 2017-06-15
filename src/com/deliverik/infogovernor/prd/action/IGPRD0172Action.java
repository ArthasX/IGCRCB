/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.prd.action;

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
import com.deliverik.infogovernor.prd.bl.IGPRD01BL;
import com.deliverik.infogovernor.prd.dto.IGPRD01DTO;
import com.deliverik.infogovernor.prd.form.IGPRD0172Form;
import com.deliverik.infogovernor.prd.vo.IGPRD01721VO;

/**
 * 表单查看权限
 * @author byf 2012-10-16
 *
 */
public class IGPRD0172Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGPRD0172Action.class);
	
	/**
	 * <p>
	 * Description: 授权处理action
	 * </p>
	 */
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//实例化FORM
		IGPRD0172Form form = (IGPRD0172Form)actionForm;
		//BL取得
		IGPRD01BL ctlBL = (IGPRD01BL) getBean("igPRD01BL");	
		//DTO生成
		IGPRD01DTO dto = new IGPRD01DTO();

		String forward = "DISP";
		if ("DISP".equals(mapping.getParameter())){
			log.debug("========授权查询处理开始========");
			request.setAttribute("pdid", form.getPdid());
			request.setAttribute("roleid", form.getRoleid());
			dto.setIgPRD0172Form(form);
			dto.setPdid(form.getPdid());
			//调用BL查询
			
			dto = ctlBL.getProcessRoleFormRelationAction(dto);
			
			dto = ctlBL.isProcessDefinitionInUse(dto);
			saveToken(request);
			//构造VO
			IGPRD01721VO vo = new IGPRD01721VO();
			vo.setIg701InfoList(dto.getIg701InfoList());
			vo.setIg007InfoList(dto.getProcessInfoDefList());
			request.setAttribute("isInUse", dto.getIsProcessDefinitionInUse());
			super.<IGPRD01721VO>setVO(request, vo);
			log.debug("========授权查询处理终了========");
		} else if ("INSERT".equals(mapping.getParameter())){//添加参与者
			log.debug("========授权处理开始========");

			dto.setIgPRD0172Form(form);
			//删除角色
			if("0".equals(form.getMode())){
				if (isTokenValid(request, true)){
					//调用BL发起
					ctlBL.removeProcessRoleFormRelation(dto);
				}else{
					addMessage(request, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
			}else{//添加角色
				if (isTokenValid(request, true)){
					//调用BL发起
					ctlBL.addProcessRoleFormRelation(dto);
				}else{
					addMessage(request, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
			}

			log.debug("========授权处理终了========");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward(forward);
	}
}
