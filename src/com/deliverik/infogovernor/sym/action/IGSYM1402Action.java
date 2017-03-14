/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.action;

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
import com.deliverik.infogovernor.sym.bl.IGSYM14BL;
import com.deliverik.infogovernor.sym.dto.IGSYM14DTO;
import com.deliverik.infogovernor.sym.form.IGSYM1402Form;

/**
 * ���������Ϣ�༭����Action����
 *
 */
public class IGSYM1402Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSYM1402Action.class);

	/**
	 * ������
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGSYM1402Form form = (IGSYM1402Form)actionForm;
		
		//BLȡ��
		IGSYM14BL ctlBL = (IGSYM14BL) getBean("igSYM14BL");
		
		//DTO����
		IGSYM14DTO dto = new IGSYM14DTO();
		
		//��ת
		String forward = "DISP";
		
		if( "DISP".equals(mapping.getParameter())){
			//�����������������ʾ����
			log.debug("========�����������������ʾ����ʼ========");
			
			addMessage(req, new ActionMessage("IGCO10000.I001","���������Ϣ"));
			
			saveToken(req);
			dto=ctlBL.searchPrtypeAndRfdFilenameList(dto);
			req.setAttribute("ADPrTypeList", dto.getPrtypeList());
			req.setAttribute("rfdFileNameList", dto.getRfdFileNameList());
			log.debug("========�����������������ʾ��������========");
			
		} else if( "INSERT".equals(mapping.getParameter())){//������������
			
			log.debug("========������������ʼ========");
			
			//DTO��������趨
			dto.setIgSYM1402Form(form);
			
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//������Ϣ�����߼�����
			if (isTokenValid(req, true)){
				dto = ctlBL.insertReportFileDefinitionAction(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			
			log.debug("========����������������========");
			
		} else if ("INIT".equals(mapping.getParameter())){ //������Ϣ���ҳ���ʼ��
			
			log.debug("========������Ϣ���������ʾ����ʼ========");
			
			dto.setIgSYM1402Form(form);
			dto=ctlBL.searchPrtypeAndRfdFilenameList(dto);
			dto = ctlBL.initReportFileDefinitionAction(dto);
			req.setAttribute("ADPrTypeList", dto.getPrtypeList());
			req.setAttribute("rfdFileNameList", dto.getRfdFileNameList());
			log.debug("========������Ϣ���������ʾ��������========");
		} else if ("EDIT".equals(mapping.getParameter())){ //������Ϣ���
			
			log.debug("========������Ϣ�������ʼ========");
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			dto.setIgSYM1402Form(form);
			
			dto = ctlBL.editReportFileDefinitionAction(dto);
			
			log.debug("========������Ϣ�����������========");
		}
		
		//�߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}

		return mapping.findForward(forward);
	}
}
