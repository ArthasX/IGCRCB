/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dut.action;

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
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.dut.bl.IGDUT04BL;
import com.deliverik.infogovernor.dut.dto.IGDUT04DTO;
import com.deliverik.infogovernor.dut.form.IGDUT0401Form;

/**
 * 延时解锁登记Action
 */
public class IGDUT0401Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDUT0401Action.class);

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
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//FORM取得
		IGDUT0401Form form = (IGDUT0401Form)actionForm;
		
		//BL取得
		IGDUT04BL ctlBL = (IGDUT04BL) getBean("igdut04BL");
		
		//DTO生成
		IGDUT04DTO dto = new IGDUT04DTO();
		
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		
		String forward = "null";
		
		if( "DISP".equals(mapping.getParameter())){
			
			//延时解锁登记画面初期显示处理
			log.debug("========延时解锁登记画面初期显示处理开始========");
			form.setOperater(user.getUsername());
			saveToken(req);
			log.debug("========延时解锁登记画面初期显示处理终了========");
			forward = "DISP";
		} else if("INSERT".equals(mapping.getParameter())){
			if((form.getMode().equals("0"))){
				//延时解锁登记处理
				log.debug("========延时解锁登记处理开始========");
				
				dto.setUser(user);
				String[] titles = form.getTitles();
				String title="";
				for (String ttl : titles) {
					title+=ttl;
				}
				form.setTitle(title);
				dto.setIgdut0401Form(form);
				if (isTokenValid(req, true)){
					dto = ctlBL.insertEntityAction(dto);
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				log.debug("========延时解锁登记处理终了========");
				
				forward = "DISP";
			}else{
				//延时解锁变更处理
				log.debug("========延时解锁变更处理开始========");
				
				String[] titles = form.getTitles();
				String title="";
				for (String ttl : titles) {
					title+=ttl;
				}
				form.setTitle(title);
				//DTO输入参数设定
				dto.setIgdut0401Form(form);
				
				//延时解锁变更逻辑调用
				dto = ctlBL.updateDelayAuditAction(dto);
				
				log.debug("========延时解锁变更处理终了========");
				
				forward = "DISP1";
			}
		}//变更页面初始化
		else if("EDIT".equals(mapping.getParameter())){
			log.debug("========延时解锁变更初期显示处理开始========");
			form.setMode("1");
			
			dto.setIgdut0401Form(form);
					
			dto = ctlBL.initDelayAudit(dto);
			
			forward = "DISP";
			log.debug("========延时解锁变更初期显示处理终了========");
		
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
