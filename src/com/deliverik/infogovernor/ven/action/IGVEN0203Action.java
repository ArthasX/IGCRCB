package com.deliverik.infogovernor.ven.action;

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
import com.deliverik.infogovernor.risk.bl.IGRISCONSTANTS;
import com.deliverik.infogovernor.ven.bl.IGVEN02BL;
import com.deliverik.infogovernor.ven.dto.IGVEN02DTO;
import com.deliverik.infogovernor.ven.form.IGVEN0203Form;

/**
 * 监测工作结果查询画面Action处理
 *
 */
public class IGVEN0203Action extends BaseAction {

	static Log log = LogFactory.getLog(IGVEN0203Action.class);

	/**
	 * 监测工作结果查询处理
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORM取得
		IGVEN0203Form form = (IGVEN0203Form)actionForm;
		
		//BL取得
		IGVEN02BL ctlBL = (IGVEN02BL) getBean("IGVEN02BL");
		
		//DTO生成
		IGVEN02DTO dto = new IGVEN02DTO();
		
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		
		if ("INSERT".equals(mapping.getParameter())){
			log.debug("========监测工作结果保存处理开始========");
			dto.setIgVEN0203Form(form);
			dto.setUser(user);
			dto = ctlBL.insertMonitoringWorkAction(dto);
			
			if(IGRISCONSTANTS.RISKCHECKRESULT_SUBMIT_ERROR.equals(dto.getGoToError())){
				//页面提交的记录已经被其他用户提交过
				return mapping.findForward("ERROR");//返回错误提示信息页
			}
			form.setResult("");
			log.debug("========监测工作结果保存处理终了========");
		}
		
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
		}

		return mapping.findForward("DISP");
	}
}
