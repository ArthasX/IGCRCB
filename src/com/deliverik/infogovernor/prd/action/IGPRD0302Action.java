/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
import com.deliverik.infogovernor.prd.bl.IGPRD03BL;
import com.deliverik.infogovernor.prd.dto.IGPRD03DTO;
import com.deliverik.infogovernor.prd.form.IGPRD0302Form;
import com.deliverik.infogovernor.prd.vo.IGPRD03021VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程组定义保存Action
 * </p>
 * 
 * @version 1.0
 */
public class IGPRD0302Action extends BaseAction{
	//日志对象取得
	static Log log = LogFactory.getLog(IGPRD0302Action.class);

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse response) throws Exception {
		//BL取得
		IGPRD03BL ctlBL = (IGPRD03BL) getBean("igprd03BL");
		//实例化dto
		IGPRD03DTO dto = new IGPRD03DTO();
		//form取得
		IGPRD0302Form form = (IGPRD0302Form) actionForm;
		//dto参数设定
		//页面初始化操作
		
		if("INSERT".equals(mapping.getParameter())||"NEXT".equals(mapping.getParameter())){
			log.info("流程组定义保存开始");
			dto.setIgprd0302Form(form);
			if (isTokenValid(req, true)){
				ctlBL.regProcessGroupDefinition(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			form.setPgdid(dto.getProcessGroupDefinition().getPgdid());
			log.info("流程组定义保存完成");
			
		}
		if("EDIT".equals(mapping.getParameter())){
			log.info("流程组编辑预处理开始");
			dto.setIgprd0302Form(form);
			ctlBL.initPGDforEdit(dto);
			IGPRD03021VO vo = new IGPRD03021VO();
			vo.setProcessGroupDefinition(dto.getProcessGroupDefinition());
			super.<IGPRD03021VO>setVO(req, vo);
			saveToken(req);
			log.info("流程组编辑预处理完成");
		}
		
		
		if("DISP".equals(mapping.getParameter())){
			req.removeAttribute("IGPRD0302Form");
			if(form == null) {
				req.setAttribute("ptid", req.getParameter("ptid"));
			} else {
				req.setAttribute("ptid", form.getPtid());
			}
			saveToken(req);
		}
		
		
		List<ActionMessage> messageList = dto.getMessageList();
		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(req, message);
			}
		}
		return mapping.findForward("DISP");
	}

}