/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */
package com.deliverik.infogovernor.fin.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.infogovernor.fin.bl.IGFIN01BL;
import com.deliverik.infogovernor.fin.dto.IGFIN01DTO;
import com.deliverik.infogovernor.fin.form.IGFIN0101Form;


/**
 * Ԥ��Ǽǻ���Action����
 *
 */
public class IGFIN0101Action extends BaseAction {

	static Log log = LogFactory.getLog(IGFIN0101Action.class);

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

		IGFIN0101Form form = (IGFIN0101Form)actionForm;
		
		//BLȡ��
		IGFIN01BL ctlBL = (IGFIN01BL) getBean("igfin01BL");
		
		//DTO����
		IGFIN01DTO dto = new IGFIN01DTO();
		//Ԥ������б�
		List<LabelValueBean> byearList = new ArrayList<LabelValueBean>();
		if( "DISP".equals(mapping.getParameter())){
			//Ԥ��Ǽǻ��������ʾ����
			log.debug("========Ԥ��Ǽǻ��������ʾ����ʼ========");
			//��ȡ��ǰ���
			int currentYear = Integer.parseInt(IGStringUtils.getCurrentYear());
			//���㵱ǰ��ݵ�ǰ���꼰��һ��
			for(int i=5;i>0;i--){
				int temp = currentYear - i;
				byearList.add(new LabelValueBean(temp+"",temp+""));
			}
			byearList.add(new LabelValueBean(currentYear+"",currentYear+""));
			byearList.add(new LabelValueBean(currentYear +1+"",currentYear +1+""));
			dto.setByearList(byearList);
			form.setByear(currentYear+"");
			//�洢����б�
			req.setAttribute("byearList", byearList);
			addMessage(req, new ActionMessage("IGCO10000.I001","Ԥ����Ϣ"));
			saveToken(req);
			log.debug("========Ԥ��Ǽǻ��������ʾ��������========");
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			//Ԥ��Ǽǻ�������ʾ����
			log.debug("========Ԥ��Ǽǻ�������ʾ����ʼ========");
			//��ȡ��ǰ���
			int currentYear = Integer.parseInt(IGStringUtils.getCurrentYear());
			//���㵱ǰ��ݵ�ǰ���꼰��һ��
			for(int i=5;i>0;i--){
				int temp = currentYear - i;
				byearList.add(new LabelValueBean(temp+"",temp+""));
			}
			byearList.add(new LabelValueBean(currentYear+"",currentYear+""));
			byearList.add(new LabelValueBean(currentYear +1+"",currentYear +1+""));
			//�洢����б�
			form.setByear_q(currentYear+"");
			req.setAttribute("byearList", byearList);
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			saveToken(req);
			log.debug("========Ԥ��Ǽǻ�������ʾ��������========");
			return mapping.findForward("DISP");
		}	

		if( "INSERT".equals(mapping.getParameter())){
			//Ԥ��༭����
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)){
				//Ԥ��༭���水�·��ذ�ťʱ�ķ��ش���
				if (form.getRoute().equals("0")){
					//����Ԥ��Ǽǻ���
					return mapping.findForward("BACK1");
				} else {
					//����Ԥ����ϸ ����
					return mapping.findForward("BACK2");
				}
			}
			if (form.getBstatus().equals("O")){
				//Ԥ��ǼǴ���
				log.debug("========Ԥ��ǼǴ���ʼ========");

				//DTO��������趨
				
				User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
				
				form.setBreqname(user.getUsername());
															
				dto.setBudget(form);
				if (isTokenValid(req, true)){
					//Ԥ��Ǽ��߼�����
					
					dto = ctlBL.insertBudgetTBDAOAction(dto);
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				log.debug("========Ԥ��ǼǴ�������========");

			}
		}
		
		
		if ("DELETE".equals(mapping.getParameter())){
			//Ԥ��ɾ������
			log.debug("========Ԥ��ɾ������ʼ========");
			
			//DTO��������趨
			
			dto.setDeleteBudget(form.getBid());
			
			//Ԥ����Ϣɾ���߼�����
			dto = ctlBL.deleteBudgetAction(dto);
			if(null == dto){
				return mapping.findForward("ERROR");
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
