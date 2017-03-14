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

import com.csebank.lom.bl.IGLOM05BL;
import com.csebank.lom.dto.IGLOM05DTO;
import com.csebank.lom.form.IGLOM0502Form;
import com.csebank.lom.vo.IGLOM05011VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;

/**
 * ʳ�óɱ�����Action
 * 
 */
public class IGLOM0502Action extends BaseAction {

	static Log log = LogFactory.getLog(IGLOM0502Action.class);

	/**
	 * ʳ�óɱ�����
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
		IGLOM0502Form form = (IGLOM0502Form)actionForm;
		
		//BLȡ��
		IGLOM05BL ctlBL = (IGLOM05BL) getBean("iglom05BL");
		
		//DTO����
		IGLOM05DTO dto = new IGLOM05DTO();
		
		String forward = "";
		
		if( "DISP".equals(mapping.getParameter())){
			
			//ʳ�óɱ������ѯ���������ʾ����
			log.debug("========ʳ�óɱ������ѯ���������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========ʳ�óɱ������ѯ���������ʾ��������========");
			
			forward = "DISP";
			
			
		} 	/*
			else if ("DELETE".equals(mapping.getParameter())){
			
			log.debug("========ʳ�óɱ�����ɾ������ʼ========");
			//DTO��������趨
			dto.setDeleteRid(form.getDeleteRid());
			
			ctlBL.deleteRecptionAction(dto);
			
			log.debug("========�Ӵ���������ɾ����������========");
			
			forward = "DELETE";
			
		} */else if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//ʳ�óɱ������ѯ����
			log.debug("========ʳ�óɱ������ѯ����ʼ========");
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGLOM0502");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGLOM0502Form) req.getSession().getAttribute("IGLOM0502Form");
				if ( form == null ) {
					form = new IGLOM0502Form();
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
					form = (IGLOM0502Form) req.getSession().getAttribute("IGLOM0502Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGLOM0502");
			
			//DTO��������趨
			dto.setEaterySearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//ʳ�óɱ�������Ϣ�����߼�����
			dto = ctlBL.searchEateryAction(dto);
			
			
			//��ʳ�óɱ�������Ϣ��������趨��VO��
			IGLOM05011VO vo = new IGLOM05011VO();
			vo.setEateryList(dto.getEateryList());
			
			super.<IGLOM05011VO>setVO(req, vo);
			
			log.debug("========ʳ�óɱ������ѯ��������========");
			
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
