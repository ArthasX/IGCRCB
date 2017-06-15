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
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.fin.bl.IGFIN01BL;
import com.deliverik.infogovernor.fin.dto.IGFIN01DTO;
import com.deliverik.infogovernor.fin.form.IGFIN0202Form;
import com.deliverik.infogovernor.fin.vo.IGFIN02011VO;


/**
 * Ԥ���ѯ����Action����
 *
 */
public class IGFIN0202Action extends BaseAction {

	static Log log = LogFactory.getLog(IGFIN0202Action.class);

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

		IGFIN0202Form form = (IGFIN0202Form)actionForm;
		
		//BLȡ��
		IGFIN01BL ctlBL = (IGFIN01BL) getBean("igfin01BL");
		
		//DTO����
		IGFIN01DTO dto = new IGFIN01DTO();

		if( "DISP".equals(mapping.getParameter())){
			//Ԥ���ѯ���������ʾ����
			log.debug("========Ԥ���ѯ���������ʾ����ʼ========");
			req.setAttribute("IGFIN0202Form", form);
			
			addMessage(req, new ActionMessage("IGCO10000.I001","Ԥ����Ϣ"));
			log.debug("========Ԥ���ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			//Ԥ���ѯ��������ʾ����
			log.debug("========Ԥ���ѯ��������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========Ԥ���ѯ��������ʾ��������========");
			return mapping.findForward("DISP");
		}	

		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			getPaginDTO(req,"IGFIN0202");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			//Ԥ���ѯ����
			log.debug("========Ԥ���ѯ����ʼ========");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGFIN0202Form) req.getSession().getAttribute("IGFIN0202Form");
				if ( form == null ) {
					form = new IGFIN0202Form();
				}else {
					if (req.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} else {
				if (req.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					form = (IGFIN0202Form) req.getSession().getAttribute("IGFIN0202Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			int maxCnt = getMaxDataCount("IGFIN0202");
			
			form.setBstatus("O");
			
			//DTO��������趨
			dto.setBudgetSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//Ԥ������߼�����
			dto = ctlBL.searchBudgetAction(dto);
			
			//��Ԥ���������趨��VO��
			IGFIN02011VO vo = new IGFIN02011VO(dto.getBudgetList());
			
			super.<IGFIN02011VO>setVO(req, vo);
			
			log.debug("========Ԥ���ѯ��������========");
		}
		
		if ("EDIT".equals(mapping.getParameter())){
			//Ԥ��༭������ڴ���
			log.debug("========Ԥ��༭������ڴ���ʼ========");

			//DTO��������趨
			dto.setBudget(form);
			
			//Ԥ��༭������ڴ����߼�����
			
			log.debug("========Ԥ��༭��������========");
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
