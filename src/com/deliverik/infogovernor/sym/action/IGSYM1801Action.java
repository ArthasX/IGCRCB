/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
import com.deliverik.infogovernor.sym.bl.IGSYM18BL;
import com.deliverik.infogovernor.sym.dto.IGSYM18DTO;
import com.deliverik.infogovernor.sym.form.IGSYM1802Form;
import com.deliverik.infogovernor.sym.vo.IGSYM18011VO;

/**
 * ����: ��ҳ�����ѯ/����Action����
 * ������������ҳ�����ѯ/����Action����
 * ������¼����ѧ־    2012/11/14
 * �޸ļ�¼��
 */
public class IGSYM1801Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSYM1801Action.class);

	/**
	 * ���ܣ���ҳ�����ѯ ��ѯig622���÷�ҳ
	 * 
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return ActionForward
	 * @throws Exception
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//BLȡ��
		IGSYM18BL ctlBL = (IGSYM18BL) getBean("igSYM18BL");
		//DTO����
		IGSYM18DTO dto = new IGSYM18DTO();
		if ("DISP".equals(mapping.getParameter())) {
			log.debug("========��ҳ�����ѯ��ʼ������ʼ========");
			//��ѯig126������
			dto = ctlBL.searchFirstJspInfoAction(dto);		
			IGSYM18011VO vo = new IGSYM18011VO(dto.getFirstJspInfoList());		
            super.<IGSYM18011VO>setVO(req, vo); 
			addMessage(req, new ActionMessage("IGCO10000.I003"));			
			log.debug("========��ҳ�����ѯ��ʼ���������========");
		}
		else if("INSERT".equals(mapping.getParameter()))
		{
			log.debug("========��ҳ����ǼǴ���ʼ========");
			//FORMȡ��
			IGSYM1802Form form = (IGSYM1802Form)actionForm;
			dto.setIgSYM1802Form(form);
			if (isTokenValid(req, true)){
				dto = ctlBL.insertFirstJspInfoAction(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========��ҳ����ǼǴ������========");
		}
		else if("INSERT_INIT".equals(mapping.getParameter()))
		{
			log.debug("========��ҳ����Ǽǳ�ʼ������ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			saveToken(req);
			log.debug("========��ҳ����Ǽǳ�ʼ���������========");
		}
		//�߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
		}
		return mapping.findForward("Disp");
	}
}
