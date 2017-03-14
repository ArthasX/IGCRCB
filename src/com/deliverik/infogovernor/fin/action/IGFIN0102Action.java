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
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.infogovernor.fin.bl.IGFIN01BL;
import com.deliverik.infogovernor.fin.dto.IGFIN01DTO;
import com.deliverik.infogovernor.fin.form.IGFIN0102Form;
import com.deliverik.infogovernor.fin.vo.IGFIN01011VO;
import com.deliverik.infogovernor.fin.vo.IGFIN01013VO;


/**
 * Ԥ���ѯ����Action����
 *
 */
public class IGFIN0102Action extends BaseAction {

	static Log log = LogFactory.getLog(IGFIN0102Action.class);

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

		IGFIN0102Form form = (IGFIN0102Form)actionForm;
		
		//BLȡ��
		IGFIN01BL ctlBL = (IGFIN01BL) getBean("igfin01BL");
		
		//DTO����
		IGFIN01DTO dto = new IGFIN01DTO();
		//Ԥ������б�
		List<LabelValueBean> byearList = new ArrayList<LabelValueBean>();
		if( "DISP".equals(mapping.getParameter())){
			//Ԥ���ѯ���������ʾ����
			log.debug("========Ԥ���ѯ���������ʾ����ʼ========");
			req.setAttribute("IGFIN0102Form", form);
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
			form.setByear_q(IGStringUtils.getCurrentYear());
			//�洢����б�
			req.setAttribute("byearList", byearList);
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========Ԥ���ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			//Ԥ���ѯ��������ʾ����
			log.debug("========Ԥ���ѯ��������ʾ����ʼ========");
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
			//�洢����б�
			form.setByear_q(currentYear+"");
			req.setAttribute("byearList", byearList);
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========Ԥ���ѯ��������ʾ��������========");
			return mapping.findForward("DISP");
		}	

		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			getPaginDTO(req,"IGFIN0102");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			//Ԥ���ѯ����
			log.debug("========Ԥ���ѯ����ʼ========");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGFIN0102Form) req.getSession().getAttribute("IGFIN0102Form");
				if ( form == null ) {
					form = new IGFIN0102Form();
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
					form = (IGFIN0102Form) req.getSession().getAttribute("IGFIN0102Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}

			
			int maxCnt = getMaxDataCount("IGFIN0102");
			//DTO��������趨
			dto.setBudgetSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//Ԥ������߼�����
			dto = ctlBL.searchBudgetAction(dto);

			//��Ԥ���������趨��VO��
			IGFIN01011VO vo = new IGFIN01011VO();
			vo.setBudgetFormList(dto.getBudgetFormList());
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
			if(null==form.getByear_q()){
				form.setByear_q(IGStringUtils.getCurrentYear());
			}
			
			req.setAttribute("byearList", byearList);
			super.<IGFIN01011VO>setVO(req, vo);
			
			log.debug("========Ԥ���ѯ��������========");
		}
		if ("EDIT".equals(mapping.getParameter())){
			//Ԥ��༭������ڴ���
			log.debug("========Ԥ��༭������ڴ���ʼ========");
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
			req.setAttribute("byearList", byearList);
//			//DTO��������趨
			dto.setIgfin0102Form(form);
			dto = ctlBL.initIGFIN0102Action(dto);
			//Ԥ��༭������ڴ����߼�����
			log.debug("========Ԥ��༭��������========");
		}

		if ("UPDATE".equals(mapping.getParameter())){
			
			//Ԥ��������
			log.debug("========Ԥ��������ʼ========");
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
			//DTO��������趨
			form.setBamount(Double.parseDouble(form.getBamount_show()));//�����ڸ�ʽ����ʾ����Ŀ��ֵ��form�е�����
			dto.setIgfin0102Form(form);
			dto.setBudget(form);
			
			//Ԥ�����߼�����
			dto = ctlBL.updateBudgetAction(dto);
			/**ִ���޸ĺ�ť��ʾ��ʶ*/
			form.setUpdateShow("show");
			log.debug("========Ԥ������������========");
			
		}
		if ("PROJECTSEARCH".equals(mapping.getParameter())){
			dto.setIgfin0102Form(form);
			//��Ŀ�Ǽ���Ԥ�㼯����ʾ����
			dto = ctlBL.initProjectBudgetList(dto);
			IGFIN01013VO vo = new IGFIN01013VO();
			vo.setPbsummaryList(dto.getPbsummaryList());
			super.<IGFIN01013VO>setVO(req, vo);
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
