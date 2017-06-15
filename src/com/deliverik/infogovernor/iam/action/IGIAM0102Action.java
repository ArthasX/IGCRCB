/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */

package com.deliverik.infogovernor.iam.action;

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
import com.deliverik.infogovernor.iam.bl.IGIAM01BL;
import com.deliverik.infogovernor.iam.dto.IGIAM01DTO;
import com.deliverik.infogovernor.iam.form.IGIAM0101Form;
import com.deliverik.infogovernor.iam.vo.IGIAM01011VO;

/**
 * ������Ŀ����Action����
 *
 * @author
 */
public class IGIAM0102Action extends BaseAction {

	static Log log = LogFactory.getLog(IGIAM0102Action.class);

	/**
	 * ������Ŀ���´���
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
		IGIAM0101Form form = (IGIAM0101Form)actionForm;
		
		//BLȡ��
		IGIAM01BL ctlBL = (IGIAM01BL) getBean("igiam01BL");
		
		//DTO����
		IGIAM01DTO dto = new IGIAM01DTO();
		
		//������Ŀ�鿴
		if ("DSEARCH".equals(mapping.getParameter())) {
			log.debug("========������Ŀ�鿴����ʼ========");
			
			req.setAttribute("jump", req.getParameter("jump"));
			//��form��װ��dto��
			dto.setIgIAM0101Form(form);
			//����ҵ�񷽷�ִ��������ѯ����
			dto = ctlBL.dsearchIAMAction(dto);
			//form���¸�ֵ
			form = dto.getIgIAM0101Form();
			//��ʼ��VO
			IGIAM01011VO vo = new IGIAM01011VO();
			//������List��װ��VO��
			vo.setAttkeyList(dto.getAttkeyList());
			//����VO
			super.<IGIAM01011VO>setVO(req, vo);
			log.debug("========������Ŀ�鿴��������========");
		}
		//��ת��������Ŀ�鿴ҳ
		if ("TOUPDATE".equals(mapping.getParameter())) {
			log.debug("========��ת��������Ŀ�鿴ҳ����ʼ========");
			//��form��װ��dto��
			dto.setIgIAM0101Form(form);
			//����ҵ�񷽷�ִ��������ѯ����
			dto = ctlBL.dsearchIAMAction(dto);
			//form���¸�ֵ
			form = dto.getIgIAM0101Form();
			//��ʼ��VO
			IGIAM01011VO vo = new IGIAM01011VO();
			//������List��װ��VO��
			vo.setAttkeyList(dto.getAttkeyList());
			//����VO
			super.<IGIAM01011VO>setVO(req, vo);
			log.debug("========��ת��������Ŀ�鿴ҳ�������========");
		}
		//������Ŀ�޸�
		if ("UPDATE".equals(mapping.getParameter())) {
			log.debug("========������Ŀ���桢�ύ����ʼ========");
			//�ж�״̬�Ƿ�Ϊ��
			if (req.getParameter("iapStatus") != null) {
				//�������л��״̬��Ϣ
				String iapStatus = req.getParameter("iapStatus");
				//��״̬��Ϣ��װ��form��
				form.setIapStatus(iapStatus);
			}
			//��form��װ��dto��
			dto.setIgIAM0101Form(form);
			//����ҵ�񷽷����и��²���
			dto = ctlBL.updateIAMAction(dto);
			log.debug("========������Ŀ���桢�ύ�������========");
		}
		//������Ŀɾ��
		if ("DELETE".equals(mapping.getParameter())) {
			log.debug("========������Ŀɾ����ʼ========");
			//��form��װ��DTO
			dto.setIgIAM0101Form(form);
			//����ҵ�񷽷�ɾ������
			dto = ctlBL.deleteIAMAction(dto);
			log.debug("========������Ŀɾ������========");
		}
		//��������
		if ("LOADFILE".equals(mapping.getParameter())){
			log.debug("========֪ͨ�������ش���ʼ========");
			
			String attId = req.getParameter("attId");
			String type="iam";
			req.setAttribute("type", type);
			req.setAttribute("attId", attId);

			log.debug("========֪ͨ�������ش������========");
			return mapping.findForward("LOADFILE");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
		}
		return mapping.findForward("DISP");
	}
}
