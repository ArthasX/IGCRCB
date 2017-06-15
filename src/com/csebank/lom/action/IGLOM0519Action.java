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
import com.csebank.lom.form.IGLOM0519Form;
import com.csebank.lom.util.CodeUtils;
import com.csebank.lom.util.LOMHelper;
import com.csebank.lom.vo.IGLOM05181VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;

/**
 * �Ϳ�����Action
 * 
 */
public class IGLOM0519Action extends BaseAction {

	static Log log = LogFactory.getLog(IGLOM0519Action.class);

	/**
	 * �Ϳ�����
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
		IGLOM0519Form form = (IGLOM0519Form)actionForm;
		
		//BLȡ��
		IGLOM05BL ctlBL = (IGLOM05BL) getBean("iglom05BL");
		
		//DTO����
		IGLOM05DTO dto = new IGLOM05DTO();
		
		String forward = "";
		
		req.setAttribute("card_status", LOMHelper.getItemsCodes(CodeUtils.GOODS_STATUS));
		if( "DISP".equals(mapping.getParameter())){
			
			//�Ϳ������ѯ���������ʾ����
			log.debug("========�Ϳ������ѯ���������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========�Ϳ������ѯ���������ʾ��������========");
			
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
			log.debug("========�Ϳ������ѯ����ʼ========");
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGLOM0519");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGLOM0519Form) req.getSession().getAttribute("IGLOM0519Form");
				form.setDesc("");
				if ( form == null ) {
					form = new IGLOM0519Form();
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
					form = (IGLOM0519Form) req.getSession().getAttribute("IGLOM0519Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGLOM0519");
			
			//DTO��������趨
			form.setDesc(form.getStatus());
			dto.setLunchCardSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//�Ϳ�������Ϣ�����߼�����
			dto = ctlBL.searchLunchCardAction(dto);
			
			
			//���Ϳ�������Ϣ��������趨��VO��
			IGLOM05181VO vo = new IGLOM05181VO();
			vo.setLunchCardList(dto.getItemsCodesList());
			
			super.<IGLOM05181VO>setVO(req, vo);
			
			log.debug("========�Ϳ������ѯ��������========");
			
			forward = "DISP";
			
		}else if ("CHANGE".equals(mapping.getParameter())){
			log.debug("=======�Ϳ�״̬ͣ��/���ô���ʼ========");
			//DTO��������趨
			dto.setIglom0519Form(form);
			
			

//			if (isTokenValid(req, true)) {
//
//				
//			} else {
//				
//				addMessage(req, new ActionMessage("IGCO00000.E007"));
//				return mapping.findForward("/error1");
//			}
			
			ctlBL.changeLunchCardAction(dto);
			form.setIcid(null);
			log.debug("========�Ϳ�״̬ͣ��/���ô�������========");
			
			forward = "CHANGE";
			
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
