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

import com.csebank.lom.bl.IGLOM01BL;
import com.csebank.lom.dto.IGLOM01DTO;
import com.csebank.lom.form.IGLOM0115Form;
import com.csebank.lom.util.CodeUtils;
import com.csebank.lom.util.LOMHelper;
import com.deliverik.framework.base.BaseAction;



/**
 * ģ�飺���ڹ���-�Ӵ�����
 * ˵��������Ͳ͵Ǽ�Action
 * ���ߣ������� 
 */
public class IGLOM0115Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGLOM0115Action.class);
	
	String forward = "";

	/**
	 * ����Ͳ͵Ǽ�
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
		// �Ӵ��Ǽ�FORMȡ��
		IGLOM0115Form form = (IGLOM0115Form) actionForm;
		//�Ӵ�����formȥ��
		
//		// BLȡ��
		IGLOM01BL ctlBL = (IGLOM01BL) getBean("iglom01BL");
		// DTO����
		IGLOM01DTO dto = new IGLOM01DTO();
//		// �����˵�
		req.setAttribute("recption_rscale", LOMHelper.getItemsCodes(CodeUtils.RECPTION_RSCALE));
		req.setAttribute("recption_status", LOMHelper.getItemsCodes(CodeUtils.RECPTION_STATUS));
		req.setAttribute("recption_rstandard", LOMHelper.getItemsCodes(CodeUtils.RECPTION_RSTANDARD));
		// ����Ͳ͵Ǽǻ�����ʾ
		if ("deal".equals(mapping.getParameter())) {
			
			
			log.debug("========����Ͳ͵Ǽǳ�����ʾ����ʼ========");

			addMessage(req, new ActionMessage("IGCO10000.I001", "����Ͳ͵Ǽǻ�����Ϣ"));
			
			log.debug("========����Ͳ͵Ǽǳ�����ʾ��������========");
			saveToken(req);
			
			forward = "deal";
			//����Ͳ͵Ǽ���Ϣ����
		}else if( "INSERT".equals(mapping.getParameter())){
			//mode=0��������Ϣ����mode=1������Ͳ͵Ǽ���Ϣ�������
			if(form.getMode().equals("0")){
				//��form���ݸ�dto��װ
				dto.setDeal(form);
				//����form
				dto.setIglom0115Form(form);
				if (isTokenValid(req, true)) {
					dto = ctlBL.insetDealInfo(dto);
				} else {
					
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				forward="insert-over";
			}else {
				//�Ӵ���Ϣ�������
				log.debug("========����Ͳ���Ϣ�������ʼ========");
				
				//DTO��������趨
				dto.setDeal(form);
				dto.setIglom0115Form(form);

				if (isTokenValid(req, true)) {
					
					//�Ӵ���Ϣ����߼�����
					dto = ctlBL.updateDealAction(dto);
				} else {
					
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				
				log.debug("========����Ͳ���Ϣ�����������========");
				
				forward = "DISP1";

			}
			
		}
		//����Ͳ͹�����Ϣ��ת��ʼ��
		else if("view-init".equals(mapping.getParameter())){
			addMessage(req, new ActionMessage("IGCO10000.I001", "����Ͳ͹�����Ϣ"));
			saveToken(req);
			forward = "dealmanagerinit";
		}
		//���ҳ���ʼ��
		if("EDIT".equals(mapping.getParameter())){
			
			log.debug("========�Ӵ���Ϣ���������ʾ����ʼ========");
			form.setMode("1");
			
			dto.setIglom0115Form(form);

			dto = ctlBL.initDeal(dto);
			forward = "DISP";
			log.debug("========�Ӵ���Ϣ���������ʾ��������========");
		
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
