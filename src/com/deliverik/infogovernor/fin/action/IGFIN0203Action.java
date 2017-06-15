/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */
package com.deliverik.infogovernor.fin.action;

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
import com.deliverik.infogovernor.fin.bl.IGFIN01BL;
import com.deliverik.infogovernor.fin.dto.IGFIN01DTO;
import com.deliverik.infogovernor.fin.form.IGFIN0101Form;
import com.deliverik.infogovernor.fin.vo.IGFIN01021VO;



/**
 * Ԥ����ϸ��Ϣ����Action����
 *
 */
public class IGFIN0203Action extends BaseAction {

	static Log log = LogFactory.getLog(IGFIN0203Action.class);

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
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGFIN0101Form form = (IGFIN0101Form)actionForm;
		
		//BLȡ��
		IGFIN01BL ctlBL = (IGFIN01BL) getBean("igfin01BL");
		
		//DTO����
		IGFIN01DTO dto = new IGFIN01DTO();

		if( "DISP".equals(mapping.getParameter())){
			//Ԥ���ѯ��ϸ������ʾ����
			log.debug("========Ԥ���ѯ������ϸ��ʾ����ʼ========");
			
			String bid = req.getParameter("eid");
			
			dto.setBid(Integer.valueOf(bid));
			
			form.setBid(Integer.valueOf(bid));
			
			dto.setIgfin0101Form(form);
			
			//Ԥ���ѯ������ϸ��ʾ�����߼�����
			dto = ctlBL.initIGFIN0103Action(dto);
			
			//Ԥ���������趨��VO��

			IGFIN01021VO vo = new IGFIN01021VO(dto.getBudget());
			
			super.<IGFIN01021VO>setVO(req.getSession(),vo);
			
			log.debug("========Ԥ���ѯ������ϸ��ʾ��������========");
		}
		
		if ("DELETE".equals(mapping.getParameter())){
			//Ԥ��ɾ������
			log.debug("========Ԥ��ɾ������ʼ========");
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)){
				//���ش���
				return mapping.findForward("BACK");
			}
			
			log.debug("========Ԥ��ɾ����������========");
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
