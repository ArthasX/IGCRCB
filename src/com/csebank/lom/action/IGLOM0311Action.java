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
import com.csebank.lom.form.IGLOM0311Form;
import com.csebank.lom.vo.IGLOM03111VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;

/**
 * ��Ա�����ϸ��ѯAction
 * 
 */
public class IGLOM0311Action extends BaseAction {

	static Log log = LogFactory.getLog(IGLOM0311Action.class);

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
		IGLOM0311Form form = (IGLOM0311Form)actionForm;
		
		//BLȡ��
		IGLOM03BL ctlBL = (IGLOM03BL) getBean("iglom03BL");
		
		//DTO����
		IGLOM03DTO dto = new IGLOM03DTO();
		
		String forward = "";
		
		if( "DISP".equals(mapping.getParameter())){
			
			//Ԥ֧���ù����ѯ���������ʾ����
			log.debug("========��Ա�����ϸ��ѯ���������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========��Ա�����ϸ��ѯ���������ʾ��������========");
			
			forward = "DISP";
			
			
		} else if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//��Ա�����ϸ��ѯ����
			log.debug("========��Ա�����ϸ��ѯ����ʼ========");
			
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGLOM0311");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGLOM0311Form) req.getSession().getAttribute("IGLOM0311Form");
				if ( form == null ) {
					form = new IGLOM0311Form();
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
					form = (IGLOM0311Form) req.getSession().getAttribute("IGLOM0311Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGLOM0311");
			
			//DTO��������趨
			dto.setPersonLoanDetailSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			dto = ctlBL.searchPersonLoanDetailAction(dto);
			
			IGLOM03111VO vo = new IGLOM03111VO();
			vo.setPersonLoanDetailList(dto.getPersonLoanDetailList());
			
			super.<IGLOM03111VO>setVO(req, vo);
			
			log.debug("========��Ա�����ϸ��ѯ��������========");
			
			forward = "DISP";
		} else if( "EXPORT".equals(mapping.getParameter())){
			//��Ա�����ϸ��������
			log.debug("========��Ա�����ϸ��������ʼ========");
			
			//������¼������ȡ��
			int maxCnt = getMaxDataCount("IGLOM0311");
			
			//DTO��������趨
			dto.setPersonLoanDetailSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto = ctlBL.exportPersonLoanDetailAction(dto);
			
			IGLOM03111VO vo = new IGLOM03111VO();
			vo.setPersonLoanDetailList(dto.getPersonLoanDetailList());
			
			super.<IGLOM03111VO>setVO(req, vo);
			
			log.debug("========��Ա�����ϸ������������========");
			
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
