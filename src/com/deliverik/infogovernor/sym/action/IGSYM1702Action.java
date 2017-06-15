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
import com.deliverik.infogovernor.sym.bl.IGSYM17BL;
import com.deliverik.infogovernor.sym.dto.IGSYM17DTO;
import com.deliverik.infogovernor.sym.form.IGSYM1702Form;
import com.deliverik.infogovernor.sym.vo.IGSYM17021VO;

/**
 * ����: ���̲����趨Action����
 * �������������̲����趨Action����
 * ������¼������    2010/11/26
 * �޸ļ�¼��
 */
public class IGSYM1702Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSYM1702Action.class);

	/**
	 * ���ܣ����̲����趨����
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
		IGSYM1702Form form = (IGSYM1702Form)actionForm;
		
		//BLȡ��
		IGSYM17BL ctlBL = (IGSYM17BL) getBean("igSYM17BL");
		
		//DTO����
		IGSYM17DTO dto = new IGSYM17DTO();
		
		dto.setIgSYM1702Form(form);
		
		if( "DISP".equals(mapping.getParameter())){
			//���̶���Ǽǻ��������ʾ����
			log.debug("========���̲����趨���������ʾ����ʼ========");
			
			dto = ctlBL.initIGSYM1702Action(dto);
			
			form.setStrategyMap(dto.getStrategyMap());
			
			//�����̲�����Ϣ�趨��VO��
			IGSYM17021VO vo = new IGSYM17021VO();
			
			vo.setPrurgencyList(dto.getPrurgencyList());
			
			vo.setPrstatusList(dto.getPrstatusList());
			
			vo.setProcessDefinition(dto.getProcessDefinition());
			
			vo.setMaxPsdversion(dto.getMaxPsdversion());
			
			super.<IGSYM17021VO>setVO(req.getSession(), vo);
			
			log.debug("========���̲����趨���������ʾ��������========");
			
		} else if ("EDIT".equals(mapping.getParameter())){
			log.debug("========���̲����趨�༭����ʼ========");
			
			dto = ctlBL.editIGSYM1702Action(dto);
			
			log.debug("========���̲����趨�༭��������========");

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
