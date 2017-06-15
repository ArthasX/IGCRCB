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
import com.deliverik.infogovernor.asset.bl.IGASM22BL;
import com.deliverik.infogovernor.asset.dto.IGASM22DTO;
import com.deliverik.infogovernor.asset.form.IGASM2205Form;
import com.deliverik.infogovernor.asset.vo.IGASM22051VO;

/**
 * ����: CI�������Action����
 * ��������: CI�������Action����
 * ������¼: 2011/05/19
 * �޸ļ�¼: 
 */
public class IGASM2205Action extends BaseAction {
	static Log log = LogFactory.getLog(IGASM2205Action.class);

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
		IGASM2205Form form = (IGASM2205Form) actionForm;
		// BLȡ��
		 IGASM22BL ctlBL = (IGASM22BL) getBean("igasm22BL");
		// DTO����
		IGASM22DTO dto = new IGASM22DTO();

		// ������ת�趨
		String forward = null;
		if ("DISP".equals(mapping.getParameter())) {
			// CI�������Ǽǻ��������ʾ����
			log.debug("========CI�������Ǽǻ��������ʾ����========");
			saveToken(req);
			addMessage(req, new ActionMessage("IGCO10000.I001", "CI������������Ϣ"));
			log.debug("========CI�������Ǽǻ��������ʾ��������========");
			return mapping.findForward("DISP");
		}
		if( "INSERT".equals(mapping.getParameter())){
			//CI���������Ϣ�༭����
			if (form.getMode().equals("0")){
				//CI���������Ϣ�ǼǴ���
				log.debug("========CI���������Ϣ�ǼǴ���ʼ========");
				//DTO��������趨
				dto.setIgasm2205Form(form);
				if (isTokenValid(req, true)){
				//CI���������Ϣ�Ǽ��߼�����
				dto = ctlBL.insertCITaskAction(dto);
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				//���Ǽ����˵�CI���������Ϣ�趨��VO��
				IGASM22051VO vo = new IGASM22051VO(dto.getIgasm2205Form());
				super.<IGASM22051VO>setVO(req.getSession(), vo);
				log.debug("========CI���������Ϣ�ǼǴ�������========");
				forward = "DISP";
			}else{
				//CI�������������
				log.debug("========CI��������޸Ĵ���ʼ========");
				dto.setIgasm2205Form(form);
				dto = ctlBL.updateCITaskAction(dto);
				log.debug("========CI�������ǼǴ�������========");
				forward = "DETAIL";
			}
		}
		//���ҳ���ʼ��
		if ("EDIT".equals(mapping.getParameter())){
			log.debug("========CI������������ʾ����ʼ========");
			dto.setIgasm2205Form(form);
			dto = ctlBL.initIGASM2205Action(dto);
			log.debug("========CI������������ʾ��������========");
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
