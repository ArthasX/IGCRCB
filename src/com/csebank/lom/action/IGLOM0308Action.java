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

import com.csebank.lom.bl.IGLOM03BL;
import com.csebank.lom.dto.IGLOM03DTO;
import com.csebank.lom.form.IGLOM0308Form;
import com.csebank.lom.vo.IGLOM03081VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;

/**
 * Ԥ֧��Աͳ�Ʋ�ѯAction
 * 
 */
public class IGLOM0308Action extends BaseAction {

	static Log log = LogFactory.getLog(IGLOM0308Action.class);

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
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//FORMȡ��
		IGLOM0308Form form = (IGLOM0308Form)actionForm;
		
		//BLȡ��
		IGLOM03BL ctlBL = (IGLOM03BL) getBean("iglom03BL");
		
		//DTO����
		IGLOM03DTO dto = new IGLOM03DTO();
		
		String forward = "";
		
		if( "DISP".equals(mapping.getParameter())){
			
			log.debug("========Ԥ֧��Աͳ�Ʋ�ѯ���������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========Ԥ֧��Աͳ�Ʋ�ѯ���������ʾ��������========");
			
			forward = "DISP";
			
			
		} else if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//Ԥ֧��Աͳ�Ʋ�ѯ����
			log.debug("========Ԥ֧��Աͳ�Ʋ�ѯ����ʼ========");
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGLOM0308");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGLOM0308Form) req.getSession().getAttribute("IGLOM0308Form");
				if ( form == null ) {
					form = new IGLOM0308Form();
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
					form = (IGLOM0308Form) req.getSession().getAttribute("IGLOM0308Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGLOM0308");
			
			//DTO��������趨
			dto.setPersonLoanSummarySearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			dto = ctlBL.searchPersonLoanSummaryAction(dto);
			
			IGLOM03081VO vo = new IGLOM03081VO();
			vo.setPersonLoanSummaryList(dto.getPersonLoanSummaryList());
			
			super.<IGLOM03081VO>setVO(req, vo);
			
			log.debug("========Ԥ֧��Աͳ�Ʋ�ѯ��������========");
			
			forward = "DISP";
		} else if( "EXPORT".equals(mapping.getParameter())){
			//Ԥ֧��Աͳ�Ƶ�������
			log.debug("========Ԥ֧��Աͳ�Ƶ�������ʼ========");
			
			//������¼������ȡ��
			int maxCnt = getMaxDataCount("IGLOM0308");
			
			//DTO��������趨
			dto.setPersonLoanSummarySearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto = ctlBL.exportPersonLoanSummaryAction(dto);
			
			IGLOM03081VO vo = new IGLOM03081VO();
			vo.setPersonLoanSummaryList(dto.getPersonLoanSummaryList());
			
			super.<IGLOM03081VO>setVO(req, vo);
			
			log.debug("========Ԥ֧��Աͳ�Ƶ�����������========");
			
			forward = "DISP";
		}
		
		//�߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}

		return mapping.findForward(forward);
	}

}
