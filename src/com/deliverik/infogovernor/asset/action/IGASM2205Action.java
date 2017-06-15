/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.action;

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
import com.deliverik.infogovernor.asset.bl.IGASM22BL;
import com.deliverik.infogovernor.asset.dto.IGASM22DTO;
import com.deliverik.infogovernor.asset.form.IGASM2205Form;
import com.deliverik.infogovernor.asset.vo.IGASM22051VO;

/**
 * 概述: CI变更任务Action处理
 * 功能描述: CI变更任务Action处理
 * 创建记录: 2011/05/19
 * 修改记录: 
 */
public class IGASM2205Action extends BaseAction {
	static Log log = LogFactory.getLog(IGASM2205Action.class);

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
		IGASM2205Form form = (IGASM2205Form) actionForm;
		// BL取得
		 IGASM22BL ctlBL = (IGASM22BL) getBean("igasm22BL");
		// DTO生成
		IGASM22DTO dto = new IGASM22DTO();

		// 画面跳转设定
		String forward = null;
		if ("DISP".equals(mapping.getParameter())) {
			// CI变更任务登记画面初期显示处理
			log.debug("========CI变更任务登记画面初期显示处理========");
			saveToken(req);
			addMessage(req, new ActionMessage("IGCO10000.I001", "CI变更任务基本信息"));
			log.debug("========CI变更任务登记画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}
		if( "INSERT".equals(mapping.getParameter())){
			//CI变更任务信息编辑处理
			if (form.getMode().equals("0")){
				//CI变更任务信息登记处理
				log.debug("========CI变更任务信息登记处理开始========");
				//DTO输入参数设定
				dto.setIgasm2205Form(form);
				if (isTokenValid(req, true)){
				//CI变更任务信息登记逻辑调用
				dto = ctlBL.insertCITaskAction(dto);
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				//将登记完了的CI变更任务信息设定到VO中
				IGASM22051VO vo = new IGASM22051VO(dto.getIgasm2205Form());
				super.<IGASM22051VO>setVO(req.getSession(), vo);
				log.debug("========CI变更任务信息登记处理终了========");
				forward = "DISP";
			}else{
				//CI变更任务变更处理
				log.debug("========CI变更任务修改处理开始========");
				dto.setIgasm2205Form(form);
				dto = ctlBL.updateCITaskAction(dto);
				log.debug("========CI变更任务登记处理终了========");
				forward = "DETAIL";
			}
		}
		//变更页面初始化
		if ("EDIT".equals(mapping.getParameter())){
			log.debug("========CI变更任务初期显示处理开始========");
			dto.setIgasm2205Form(form);
			dto = ctlBL.initIGASM2205Action(dto);
			log.debug("========CI变更任务初期显示处理终了========");
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
