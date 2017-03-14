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
import com.deliverik.infogovernor.fin.bl.IGFIN02BL;
import com.deliverik.infogovernor.fin.dto.IGFIN02DTO;
import com.deliverik.infogovernor.fin.form.IGFIN0206Form;
import com.deliverik.infogovernor.fin.vo.IGFIN02012VO;


/**
 * ���ò�ѯ����Action����
 *
 */
public class IGFIN0206Action extends BaseAction {

	static Log log = LogFactory.getLog(IGFIN0206Action.class);

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

		IGFIN0206Form form = (IGFIN0206Form)actionForm;
		
		//BLȡ��
		IGFIN02BL ctlBL = (IGFIN02BL) getBean("igfin02BL");
		
		//DTO����
		IGFIN02DTO dto = new IGFIN02DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//���ò�ѯ���������ʾ����
			log.debug("========���ò�ѯ���������ʾ����ʼ========");
			req.setAttribute("IGFIN0206Form", form);
			
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========���ò�ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			//���ò�ѯ��������ʾ����
			log.debug("========���ò�ѯ��������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========���ò�ѯ��������ʾ��������========");
			return mapping.findForward("DISP");
		}	

		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			getPaginDTO(req,"IGFIN0206");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			//���ò�ѯ����
			log.debug("========���ò�ѯ����ʼ========");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGFIN0206Form) req.getSession().getAttribute("IGFIN0206Form");
				if ( form == null ) {
					form = new IGFIN0206Form();
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
					form = (IGFIN0206Form) req.getSession().getAttribute("IGFIN0206Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
//			if(form!=null && !"".equals(form.getFromCount())){
//				pDto.setFromCount(form.getFromCount());
//			}else{
//				pDto.setFromCount(0);
//			}
			int maxCnt = getMaxDataCount("IGFIN0206");
			
			//DTO��������趨
			dto.setExpenseSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//���ü����߼�����
			dto = ctlBL.searchExpenseAction(dto);
			
			//�����ü�������趨��VO��
			IGFIN02012VO vo = new IGFIN02012VO(dto.getExpenseList());
			
			super.<IGFIN02012VO>setVO(req, vo);
			
			log.debug("========���ò�ѯ��������========");
		}
		
		if ("EDIT".equals(mapping.getParameter())){
			//���ñ༭������ڴ���
			log.debug("========���ñ༭������ڴ���ʼ========");

			//DTO��������趨
			dto.setBudget(form);
			
			//���ñ༭������ڴ����߼�����
			
			log.debug("========���ñ༭��������========");
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
