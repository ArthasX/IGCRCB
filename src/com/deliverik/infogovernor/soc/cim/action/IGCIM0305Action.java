/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.cim.action;

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
import com.deliverik.infogovernor.soc.cim.bl.IGCIM03BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM03DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0305Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM03051VO;

/**
 * 概述: 审计任务Action处理
 * 功能描述: 审计任务Action处理
 * 创建记录: 2011/05/19
 * 修改记录: 
 */
public class IGCIM0305Action extends BaseAction {
	static Log log = LogFactory.getLog(IGCIM0305Action.class);

	/**
	 * 事件处理
	 * 
	 * @param mapping
	 * @param actionForm
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		// FORM取得
		IGCIM0305Form form = (IGCIM0305Form) actionForm;
		// BL取得
		 IGCIM03BL ctlBL = (IGCIM03BL) getBean("igcim03BL");
		// DTO生成
		IGCIM03DTO dto = new IGCIM03DTO();
		dto.setLocale(this.getLocale(req));
		// 画面跳转设定
		String forward = null;
		if ("DISP".equals(mapping.getParameter())) {
			// 审计任务登记画面初期显示处理
			log.debug("========审计任务登记画面初期显示处理========");
			saveToken(req);
			addMessage(req, new ActionMessage("IGCO10000.I001", "审计任务基本信息"));
			log.debug("========审计任务登记画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}
		if( "INSERT".equals(mapping.getParameter())){
			//审计任务信息编辑处理
			if (form.getMode().equals("0")){
				//审计任务信息登记处理
				log.debug("========审计任务信息登记处理开始========");
				//DTO输入参数设定
				dto.setIgcim0305Form(form);
				if (isTokenValid(req, true)){
				//审计任务信息登记逻辑调用
				dto = ctlBL.insertAuditTaskAction(dto);
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				//将登记完了的审计任务信息设定到VO中
				IGCIM03051VO vo = new IGCIM03051VO(dto.getIgcim0305Form());
				super.<IGCIM03051VO>setVO(req.getSession(), vo);
				log.debug("========审计任务信息登记处理终了========");
				forward = "DISP";
			}else{
				//审计任务变更处理
				log.debug("========审计任务修改处理开始========");
				dto.setIgcim0305Form(form);
				dto = ctlBL.updateAuditTaskAction(dto);
				log.debug("========审计任务登记处理终了========");
				forward = "DETAIL";
			}
		}
		//变更页面初始化
		if ("EDIT".equals(mapping.getParameter())){
			log.debug("========审计任务初期显示处理开始========");
			dto.setIgcim0305Form(form);
			dto = ctlBL.initIGCIM0305Action(dto);
			log.debug("========审计任务初期显示处理终了========");
			forward = "DISP";
		}
		
		
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
		}
		return mapping.findForward(forward);
		
	}
}
