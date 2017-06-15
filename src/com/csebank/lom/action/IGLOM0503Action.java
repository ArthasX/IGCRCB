/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.csebank.lom.bl.IGLOM05BL;
import com.csebank.lom.dto.IGLOM05DTO;
import com.csebank.lom.form.IGLOM0503Form;
import com.csebank.lom.form.IGLOM0518Form;
import com.csebank.lom.form.IGLOM0519Form;
import com.csebank.lom.vo.IGLOM05181VO;
import com.deliverik.framework.base.BaseAction;



/**
 * �Ӵ�����Action
 * 
 */
public class IGLOM0503Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGLOM0503Action.class);
	
	String forward = "";

	/**
	 * ʳ�ù�������Ϣ����
	 * 
	 * @param mapping
	 * @param actionForm
	 * @param req
	 * @param res
	 * @return ActionForward
	 * @throws Exception
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		// FORMȡ��
		IGLOM0503Form form = (IGLOM0503Form) actionForm;
		// BLȡ��
		IGLOM05BL ctlBL = (IGLOM05BL) getBean("iglom05BL");
		// DTO����
		IGLOM05DTO dto = new IGLOM05DTO();
		
		if ("DISP".equals(mapping.getParameter())) {
			
			// ʳ�ù����͵Ǽǳ�����ʾ����
			log.debug("========ʳ�ù����͵Ǽǻ��������ʾ����ʼ========");
			
			req.getSession().setAttribute("IGLOM0503Form", new IGLOM0503Form());
			addMessage(req, new ActionMessage("IGCO10000.I001", "ʳ�ù�������Ϣ"));
			IGLOM0519Form formPage = new IGLOM0519Form();
			formPage.setDesc("1");
			dto.setLunchCardSearchCond(formPage);
			dto = ctlBL.searchELunchCardAction(dto);
			
			//���Ϳ�������Ϣ��������趨��VO��
			IGLOM05181VO vo = new IGLOM05181VO();
			if(dto.getItemsCodesList()==null || (dto.getItemsCodesList()!=null && dto.getItemsCodesList().size()==0)){
				addMessage(req, new ActionMessage("IGLOM0503.E001"));
			}else{
				vo.setLunchCardList(dto.getItemsCodesList());
			}
			super.<IGLOM05181VO>setVO(req, vo);
			log.debug("========ʳ�ù�������Ϣ�Ǽǻ��������ʾ��������========");
			saveToken(req);
			
			forward = "DISP";
			
		} else if( "INSERT".equals(mapping.getParameter())){
			if((form.getMode().equals("0"))){
				// ���͵ǼǴ���
				log.debug("========ʳ�ù�������Ϣ�ǼǴ���ʼ========");
				// DTO��������趨
				dto.setEworkingLunch(form);
				dto.setIglom0503Form(form);

				if (isTokenValid(req, true)) {
					// ������Ϣ�Ǽ��߼�����
					dto = ctlBL.insertEworkingLunchAction(dto);
				} else {
					
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				
				
				log.debug("========ʳ�ù�������Ϣ�ǼǴ�������========");

				forward = "DISP";
				
			}else {
				//�Ӵ���Ϣ�������
				log.debug("========ʳ�ù�������Ϣ�������ʼ========");
				
				//DTO��������趨
				dto.setEworkingLunch(form);
				dto.setIglom0503Form(form);
				
				//�Ӵ���Ϣ����߼�����
				dto = ctlBL.updateEworkingLunchAction(dto);
				
				log.debug("========ʳ�ù�������Ϣ�����������========");
				
				return mapping.findForward("DETAIL");

			}
		}	else if ("EDIT".equals(mapping.getParameter())){
			
			log.debug("========ʳ�ù����͹�����������ʾ����ʼ========");
			
			//DTO��������趨
			IGLOM0518Form formPage = new IGLOM0518Form();
			IGLOM0519Form formCond = new IGLOM0519Form();
			formPage.setIcid(form.getIcid());
			dto.setIglom0518Form(formPage);
			formCond.setIcid(formPage.getIcid());
			dto.setLunchCardSearchCond(formCond);
			dto = ctlBL.searchELunchCardAction(dto);
			
			//���Ϳ�������Ϣ��������趨��VO��
			IGLOM05181VO vo = new IGLOM05181VO();
			vo.setLunchCardList(dto.getItemsCodesList());
			
			super.<IGLOM05181VO>setVO(req, vo);
			form.setMode("1");
			
			dto.setIglom0503Form(form);
			dto = ctlBL.initEworkingLunchAction(dto);
			log.debug("========ʳ�ù����͹�����������ʾ��������========");
			return mapping.findForward("DISP");
			
		}

		// �߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();

		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(req, message);
			}

		}

		return mapping.findForward(forward);
	}
}
