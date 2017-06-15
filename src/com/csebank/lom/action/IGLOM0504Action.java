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
import com.csebank.lom.form.IGLOM0504Form;
import com.csebank.lom.form.IGLOM0519Form;
import com.csebank.lom.vo.IGLOM05031VO;
import com.csebank.lom.vo.IGLOM05181VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;

/**
 * ʳ�ù����͹���Action
 * 
 */
public class IGLOM0504Action extends BaseAction {

	static Log log = LogFactory.getLog(IGLOM0504Action.class);

	/**
	 * ʳ�ù����͹���
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
		IGLOM0504Form form = (IGLOM0504Form)actionForm;
		
		//BLȡ��
		IGLOM05BL ctlBL = (IGLOM05BL) getBean("iglom05BL");
		
		//DTO����
		IGLOM05DTO dto = new IGLOM05DTO();
		
		String forward = "";
		
		if( "DISP".equals(mapping.getParameter())){
			
			//ʳ�ù����͹����ѯ���������ʾ����
			log.debug("========ʳ�ù����͹����ѯ���������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			IGLOM0519Form formPage = new IGLOM0519Form();
			formPage.setDesc("1");
			dto.setLunchCardSearchCond(formPage);
			dto = ctlBL.searchELunchCardAction(dto);
			
			//���Ϳ�������Ϣ��������趨��VO��
			IGLOM05181VO vo = new IGLOM05181VO();
			vo.setLunchCardList(dto.getItemsCodesList());
			
			super.<IGLOM05181VO>setVO(req, vo);
			log.debug("========ʳ�ù����͹����ѯ���������ʾ��������========");
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
			//ʳ�ù����͹����ѯ����
			log.debug("========ʳ�ù����͹����ѯ����ʼ========");
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGLOM0502");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGLOM0504Form) req.getSession().getAttribute("IGLOM0504Form");
				if ( form == null ) {
					form = new IGLOM0504Form();
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
					form = (IGLOM0504Form) req.getSession().getAttribute("IGLOM0504Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGLOM0504");
			
			//DTO��������趨
			dto.setEworkingLunchSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//ʳ�ù����͹�����Ϣ�����߼�����
			dto = ctlBL.searchEworkingLunchAction(dto);
			
			
			//��ʳ�ù����͹�����Ϣ��������趨��VO��
			IGLOM05031VO vo = new IGLOM05031VO();
			vo.setEworkingLunchList(dto.getEworkingLunchList());
			
			super.<IGLOM05031VO>setVO(req, vo);
			
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
