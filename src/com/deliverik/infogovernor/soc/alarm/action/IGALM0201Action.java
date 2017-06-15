/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.soc.alarm.action;

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
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.soc.alarm.bl.IGALM02BL;
import com.deliverik.infogovernor.soc.alarm.dto.IGALM02DTO;
import com.deliverik.infogovernor.soc.alarm.form.IGALM0201Form;

/**
 * ����ģ����Ӵ���
 * @author wangxing 
 * 2013.07.31
 */
public class IGALM0201Action extends BaseAction {

	static Log log = LogFactory.getLog(IGALM0201Action.class);

	/**
	 * ����ģ����Ӵ���
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return ActionForward
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGALM0201Form form = (IGALM0201Form)actionForm;
		
		//BLȡ��
		IGALM02BL ctlBL = (IGALM02BL) getBean("igalm02BL");
		//DTO����
		IGALM02DTO dto = new IGALM02DTO();
		
		if("DISP".equals(mapping.getParameter())){
			log.debug("========����ģ����ӻ��������ʾ����ʼ========");
			
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			saveToken(req);
			log.debug("========����ģ����ӻ��������ʾ��������========");
			
		}else if("INSERT".equals(mapping.getParameter())){
			log.debug("========����ģ����Ӵ���ʼ========");
			if (isTokenValid(req, true)){
				dto.setIgalm0201Form(form);
				dto = ctlBL.insertRuleTempAndCondition(dto);
				addMessage(req, new ActionMessage("IGALM0201.I001"));
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			log.debug("========����ģ����Ӵ�������========");
		} 
		
		//�߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}
		
		return mapping.findForward("DISP");
		
	}
}
