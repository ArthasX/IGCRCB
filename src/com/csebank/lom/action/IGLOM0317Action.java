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
import com.csebank.lom.form.IGLOM0317Form;
import com.csebank.lom.vo.IGLOM03171VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;

/**
 * Ԥ֧��ϸ��ѯAction
 * 
 */
public class IGLOM0317Action extends BaseAction {

	static Log log = LogFactory.getLog(IGLOM0317Action.class);

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
		IGLOM0317Form form = (IGLOM0317Form)actionForm;
		
		//BLȡ��
		IGLOM03BL ctlBL = (IGLOM03BL) getBean("iglom03BL");
		
		//DTO����
		IGLOM03DTO dto = new IGLOM03DTO();
		
		String forward = "";
		
		if( "DISP".equals(mapping.getParameter())){
			
			//Ԥ֧���ù����ѯ���������ʾ����
			log.debug("========Ԥ֧��ϸ��ѯ���������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========Ԥ֧��ϸ��ѯ���������ʾ��������========");
			
			forward = "DISP";
			
			
		} else if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//Ԥ֧��ϸ��ѯ����
			log.debug("========Ԥ֧��ϸ��ѯ����ʼ========");
			
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGLOM0317");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGLOM0317Form) req.getSession().getAttribute("IGLOM0317Form");
				if ( form == null ) {
					form = new IGLOM0317Form();
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
					form = (IGLOM0317Form) req.getSession().getAttribute("IGLOM0317Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGLOM0317");
			
			//DTO��������趨
			dto.setAdvanceDetailSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			dto = ctlBL.searchAdvanceDetailAction(dto);
			
			IGLOM03171VO vo = new IGLOM03171VO();
			vo.setAdvanceDetailList(dto.getAdvanceDetailList());
			
			super.<IGLOM03171VO>setVO(req, vo);
			
			log.debug("========Ԥ֧��ϸ��ѯ��������========");
			
			forward = "DISP";
		} else if( "EXPORT".equals(mapping.getParameter())){
			//Ԥ֧��ϸ��������
			log.debug("========Ԥ֧��ϸ��������ʼ========");
			
			//������¼������ȡ��
			int maxCnt = getMaxDataCount("IGLOM0317");
			
			//DTO��������趨
			dto.setAdvanceDetailSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto = ctlBL.exportAdvanceDetailAction(dto);
			
			IGLOM03171VO vo = new IGLOM03171VO();
			vo.setAdvanceDetailList(dto.getAdvanceDetailList());
			
			super.<IGLOM03171VO>setVO(req, vo);
			
			log.debug("========Ԥ֧��ϸ������������========");
			
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
