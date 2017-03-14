/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * ����: �������Action����
 * ��������: �������Action����
 * ������¼: 2011/05/19
 * �޸ļ�¼: 
 */
public class IGCIM0305Action extends BaseAction {
	static Log log = LogFactory.getLog(IGCIM0305Action.class);

	/**
	 * �¼�����
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
		// FORMȡ��
		IGCIM0305Form form = (IGCIM0305Form) actionForm;
		// BLȡ��
		 IGCIM03BL ctlBL = (IGCIM03BL) getBean("igcim03BL");
		// DTO����
		IGCIM03DTO dto = new IGCIM03DTO();
		dto.setLocale(this.getLocale(req));
		// ������ת�趨
		String forward = null;
		if ("DISP".equals(mapping.getParameter())) {
			// �������Ǽǻ��������ʾ����
			log.debug("========�������Ǽǻ��������ʾ����========");
			saveToken(req);
			addMessage(req, new ActionMessage("IGCO10000.I001", "������������Ϣ"));
			log.debug("========�������Ǽǻ��������ʾ��������========");
			return mapping.findForward("DISP");
		}
		if( "INSERT".equals(mapping.getParameter())){
			//���������Ϣ�༭����
			if (form.getMode().equals("0")){
				//���������Ϣ�ǼǴ���
				log.debug("========���������Ϣ�ǼǴ���ʼ========");
				//DTO��������趨
				dto.setIgcim0305Form(form);
				if (isTokenValid(req, true)){
				//���������Ϣ�Ǽ��߼�����
				dto = ctlBL.insertAuditTaskAction(dto);
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				//���Ǽ����˵����������Ϣ�趨��VO��
				IGCIM03051VO vo = new IGCIM03051VO(dto.getIgcim0305Form());
				super.<IGCIM03051VO>setVO(req.getSession(), vo);
				log.debug("========���������Ϣ�ǼǴ�������========");
				forward = "DISP";
			}else{
				//�������������
				log.debug("========��������޸Ĵ���ʼ========");
				dto.setIgcim0305Form(form);
				dto = ctlBL.updateAuditTaskAction(dto);
				log.debug("========�������ǼǴ�������========");
				forward = "DETAIL";
			}
		}
		//���ҳ���ʼ��
		if ("EDIT".equals(mapping.getParameter())){
			log.debug("========������������ʾ����ʼ========");
			dto.setIgcim0305Form(form);
			dto = ctlBL.initIGCIM0305Action(dto);
			log.debug("========������������ʾ��������========");
			forward = "DISP";
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
