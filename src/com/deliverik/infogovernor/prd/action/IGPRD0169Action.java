/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
import com.deliverik.infogovernor.prd.form.IGPRD0169Form;
import com.deliverik.infogovernor.prd.vo.IGPRD01681VO;

/**
 * ����: �Զ�������ҳ������ �޸�Action
 * ��������: �Զ�������ҳ������ �޸�Action
 * ������¼: 20121113
 * �޸ļ�¼: 
 */
public class IGPRD0169Action extends BaseAction {

	static Log log = LogFactory.getLog(IGPRD0169Action.class);

	/**
	 * �޸�Action 
	 * @param mapping
	 * @param actionForm
	 * @param req
	 * @param res
	 * @return ActionForward
	 * @throws Exception
	 */
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		// BLȡ��
		IGPRD01BL ctlBL = (IGPRD01BL) getBean("igPRD01BL");
		// DTO����
		IGPRD01DTO dto = new IGPRD01DTO();
		if ("EDIT".equals(mapping.getParameter())) {
			log.debug("========�Զ�������ҳ�������޸Ĵ���ʼ========");
			IGPRD0169Form form = (IGPRD0169Form) actionForm;
			dto.setIgPRD0169Form(form);
			if (isTokenValid(req, true)){
				dto = ctlBL.editProcessJspAction(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			log.debug("========�Զ�������ҳ�������޸Ĵ������========");
		}else if ("INIT".equals(mapping.getParameter())) {
			log.debug("========�Զ�������ҳ�������޸ĳ�ʼ������ʼ========");
			// FORMȡ��
			IGPRD0169Form form = (IGPRD0169Form) actionForm;
			dto.setIgPRD0169Form(form);
			dto = ctlBL.searchProcessJspInfoAction(dto);		
     		IGPRD01681VO vo = new IGPRD01681VO(dto.getProcessJspInfoList());		
            super.<IGPRD01681VO>setVO(req, vo); 
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			saveToken(req);
			log.debug("========�Զ�������ҳ�������޸ĳ�ʼ���������========");
		}
		else if ("DEL".equals(mapping.getParameter()))
		{
			log.debug("========�Զ�������ҳ������ɾ������ʼ========");
			IGPRD0169Form form = (IGPRD0169Form) actionForm;
			dto.setIgPRD0169Form(form);
			if(form.getPjdid() != null && !"".equals(form.getPjdid()))
			{
				ctlBL.deleteProcessJspAction(dto);				
			}
			else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			log.debug("========�Զ�������ҳ��������ɾ���������========");
		}
		// �߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(req, message);
			}
		}
		return mapping.findForward("DISP");
	}
}
