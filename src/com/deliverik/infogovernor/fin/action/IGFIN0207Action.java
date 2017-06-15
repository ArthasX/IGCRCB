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
import com.deliverik.infogovernor.fin.bl.IGFIN02BL;
import com.deliverik.infogovernor.fin.dto.IGFIN02DTO;
import com.deliverik.infogovernor.fin.form.IGFIN0206Form;
import com.deliverik.infogovernor.fin.vo.IGFIN02013VO;
import com.deliverik.infogovernor.fin.vo.IGFIN02014VO;

/**
 * ������ϸ��Ϣ����Action����
 *
 */
public class IGFIN0207Action extends BaseAction {

	static Log log = LogFactory.getLog(IGFIN0207Action.class);

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
	@SuppressWarnings("unchecked")
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGFIN0206Form form = (IGFIN0206Form)actionForm;
		
		//BLȡ��
		IGFIN02BL ctlBL = (IGFIN02BL) getBean("igfin02BL");
		
		//DTO����
		IGFIN02DTO dto = new IGFIN02DTO();

		if( "DISP".equals(mapping.getParameter())){
			//���ò�ѯ��ϸ������ʾ����
			log.debug("========���ò�ѯ������ϸ��ʾ����ʼ========");
			
			String bid = req.getParameter("eid");
			
			dto.setBid(Integer.valueOf(bid));
			
			form.setBid(Integer.valueOf(bid));
			
			dto.setIgfin0206Form(form);
			
			//���ò�ѯ������ϸ��ʾ�����߼�����
			dto = ctlBL.initIGFIN0206Action(dto);
			
			form.setAttkey(dto.getExpense().getExattkey());
			
			//���ü�������趨��VO��

			IGFIN02013VO vo = new IGFIN02013VO(dto.getExpense());
			
			super.<IGFIN02013VO>setVO(req,vo);
			
			IGFIN02014VO vo1 = new IGFIN02014VO(dto.getAttachmentList());
			
			super.<IGFIN02014VO>setVO(req,vo1);
			
			log.debug("========���ò�ѯ������ϸ��ʾ��������========");
		}
		
		if ("DELETE".equals(mapping.getParameter())){
			//����ɾ������
			log.debug("========����ɾ������ʼ========");
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)){
				//���ش���
				return mapping.findForward("BACK");
			}
			
			log.debug("========����ɾ����������========");
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
