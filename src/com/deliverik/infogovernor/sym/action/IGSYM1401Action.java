/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.action;

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
import com.deliverik.infogovernor.sym.bl.IGSYM14BL;
import com.deliverik.infogovernor.sym.dto.IGSYM14DTO;
import com.deliverik.infogovernor.sym.form.IGSYM1401Form;
import com.deliverik.infogovernor.sym.vo.IGSYM14011VO;

/**
 * �����ѯAction����
 *
 */
public class IGSYM1401Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSYM1401Action.class);

	/**
	 * �����ѯ����
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
		IGSYM1401Form form = (IGSYM1401Form)actionForm;
		
		//BLȡ��
		IGSYM14BL ctlBL = (IGSYM14BL) getBean("igSYM14BL");
		
		//DTO����
		IGSYM14DTO dto = new IGSYM14DTO();
		
		if ( "SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())){
			//�����ѯ����
			log.debug("========�����ѯ����ʼ========");
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGSYM1401");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGSYM1401Form) req.getSession().getAttribute("IGSYM1401Form");
				if ( form == null ) {
					form = new IGSYM1401Form();
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
					form = (IGSYM1401Form) req.getSession().getAttribute("IGSYM1401Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGSYM1401");
			
			dto.setReportFileDefinitionSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//������Ϣ�����߼�����
			dto = ctlBL.searchReportFileDefinitionAction(dto);
			
			//��������Ϣ��������趨��VO��
			IGSYM14011VO vo = new IGSYM14011VO(dto.getReportFileDefinitionList());
			
			super.<IGSYM14011VO>setVO(req, vo);
			
			log.debug("========�����ѯ��������========");
		} else if("DELETE".equals(mapping.getParameter())){
			log.debug("========����ɾ������ʼ========");
			dto.setDeleteRfdid(form.getDeleteRfdid());
			ctlBL.deleteReportFileDefinitionAction(dto);
			log.debug("========����ɾ����������========");
		} else if("VERSION".equals(mapping.getParameter())){
			log.debug("========����汾��������ʼ========");
			dto.setRfdid(form.getRfdid());
			ctlBL.insertReportFileVersionAction(dto);
			log.debug("========����汾������������========");
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
