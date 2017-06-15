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
import com.deliverik.infogovernor.sym.bl.IGSYM18BL;
import com.deliverik.infogovernor.sym.dto.IGSYM18DTO;
import com.deliverik.infogovernor.sym.form.IGSYM1802Form;
import com.deliverik.infogovernor.sym.vo.IGSYM18011VO;

/**
 * ����: ��ҳ���� �޸�Action
 * ��������: ��ҳ���� �޸�Action
 * ������¼: 20121114
 * �޸ļ�¼: 
 */
public class IGSYM1802Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSYM1802Action.class);

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
		IGSYM18BL ctlBL = (IGSYM18BL) getBean("igSYM18BL");
		// DTO����
		IGSYM18DTO dto = new IGSYM18DTO();
		// FORMȡ��
		IGSYM1802Form form = (IGSYM1802Form) actionForm;
		dto.setIgSYM1802Form(form);
		if ("EDIT".equals(mapping.getParameter())) {
			log.debug("========��ҳ���������޸Ĵ���ʼ========");
			if (isTokenValid(req, true)){
				dto = ctlBL.editFirstJspInfoAction(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			log.debug("========��ҳ�����޸Ĵ������========");
		}else if ("INIT".equals(mapping.getParameter())) {
			log.debug("========��ҳ�����޸ĳ�ʼ������ʼ========");
			dto = ctlBL.searchFirstJspInfoByPKAction(dto);		
     		IGSYM18011VO vo = new IGSYM18011VO(dto.getFirstJspInfoList());		
            super.<IGSYM18011VO>setVO(req, vo); 
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			saveToken(req);
			log.debug("========��ҳ�����޸ĳ�ʼ���������========");
		}
		else if ("DEL".equals(mapping.getParameter()))
		{
			log.debug("========��ҳ����ɾ������ʼ========");
			if(form.getHpid() != null && !"".equals(form.getHpid()))
			{
				ctlBL.deleteFirstJspInfoAction(dto);				
			}
			else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			log.debug("========��ҳ����ɾ���������========");
		}
		// �߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(req, message);
			}
		}
		return mapping.findForward("Disp");
	}
}
