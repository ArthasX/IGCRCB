/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */

package com.deliverik.infogovernor.iam.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.iam.bl.IGIAM01BL;
import com.deliverik.infogovernor.iam.dto.IGIAM01DTO;
import com.deliverik.infogovernor.iam.form.IGIAM0101Form;


/**
 * ������Ŀ����Action����
 *
 * @author
 */
public class IGIAM0103Action extends BaseAction {

	static Log log = LogFactory.getLog(IGIAM0103Action.class);

	/**
	 * ������Ŀ��������
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return ActionForward
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//�ж���ת
		String forwardstr = null;
		if (req.getParameter("iapStatus") != null) {
			if (req.getParameter("iapStatus").equals("0")) {			
				forwardstr = "DISP1";
			} else {
				forwardstr = "DISP2";
			}
		} else {
			forwardstr = "DISP";
		}
		//FORMȡ��
		IGIAM0101Form form = (IGIAM0101Form)actionForm;
		
		//BLȡ��
		IGIAM01BL ctlBL = (IGIAM01BL) getBean("igiam01BL");
		
		//DTO����
		IGIAM01DTO dto = new IGIAM01DTO();
		
		//������Ŀ�Ǽ�
		if ("INSERT".equals(mapping.getParameter())) {
			log.debug("========������Ŀ���桢�ύ����ʼ========");
			//�ж�״̬�Ƿ�Ϊ��
			if (req.getParameter("iapStatus") != null) {
				//�������л��״̬��Ϣ		
				String iapStatus = req.getParameter("iapStatus");
				//��״̬��Ϣ��װ��form��
				form.setIapStatus(iapStatus);
			}
			//���ø���
			dto.setAttachFile(form);
			//��form��װ��dto��
			dto.setIgIAM0101Form(form);
			//����ҵ�񷽷�ִ����������
			dto = ctlBL.insertIAMAction(dto);
			log.debug("========������Ŀ���桢�ύ�������========");
		}
		return mapping.findForward(forwardstr);
	}
}
