/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
import com.deliverik.infogovernor.asset.bl.IGASM21BL;
import com.deliverik.infogovernor.asset.dto.IGASM21DTO;
import com.deliverik.infogovernor.asset.form.IGASM2105Form;
import com.deliverik.infogovernor.asset.vo.IGASM21051VO;

/**
 * ����: �������Action����
 * ��������: �������Action����
 * ������¼: 2011/05/19
 * �޸ļ�¼: 
 */
public class IGASM2105Action extends BaseAction {
	static Log log = LogFactory.getLog(IGASM2105Action.class);

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
		IGASM2105Form form = (IGASM2105Form) actionForm;
		// BLȡ��
		 IGASM21BL ctlBL = (IGASM21BL) getBean("igasm21BL");
		// DTO����
		IGASM21DTO dto = new IGASM21DTO();

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
				dto.setIgasm2105Form(form);
				if (isTokenValid(req, true)){
				//���������Ϣ�Ǽ��߼�����
				dto = ctlBL.insertAuditTaskAction(dto);
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				//���Ǽ����˵����������Ϣ�趨��VO��
				IGASM21051VO vo = new IGASM21051VO(dto.getIgasm2105Form());
				super.<IGASM21051VO>setVO(req.getSession(), vo);
				log.debug("========���������Ϣ�ǼǴ�������========");
				forward = "DISP";
			}else{
				//�������������
				log.debug("========��������޸Ĵ���ʼ========");
				dto.setIgasm2105Form(form);
				dto = ctlBL.updateAuditTaskAction(dto);
				log.debug("========�������ǼǴ�������========");
				forward = "DETAIL";
			}
		}
		//���ҳ���ʼ��
		if ("EDIT".equals(mapping.getParameter())){
			log.debug("========������������ʾ����ʼ========");
			dto.setIgasm2105Form(form);
			dto = ctlBL.initIGASM2105Action(dto);
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
