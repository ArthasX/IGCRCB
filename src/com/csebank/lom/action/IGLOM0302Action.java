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
import com.csebank.lom.form.IGLOM0302Form;
import com.csebank.lom.util.CodeUtils;
import com.csebank.lom.util.LOMHelper;
import com.csebank.lom.vo.IGLOM03021VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;

/**
 * Ԥ֧���ù���Action
 * 
 */
public class IGLOM0302Action extends BaseAction {

	static Log log = LogFactory.getLog(IGLOM0302Action.class);

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
		IGLOM0302Form form = (IGLOM0302Form)actionForm;
		
		//BLȡ��
		IGLOM03BL ctlBL = (IGLOM03BL) getBean("iglom03BL");
		
		//DTO����
		IGLOM03DTO dto = new IGLOM03DTO();
		
		String forward = "";
		
		req.getSession().setAttribute("AD_advancescost_acstatus", LOMHelper.getItemsCodes(CodeUtils.ADVANCESCOST_ACSTATUS));
		
		if( "DISP".equals(mapping.getParameter())){
			
			//Ԥ֧���ù����ѯ���������ʾ����
			log.debug("========Ԥ֧���ù����ѯ���������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========Ԥ֧���ù����ѯ���������ʾ��������========");

			saveToken(req);
			forward = "DISP";
			
			
		} else if("REDISP".equals(mapping.getParameter())){
			
			//Ԥ֧���ù����ѯ��������ʾ����
			log.debug("========Ԥ֧���ù����ѯ��������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========Ԥ֧���ù����ѯ��������ʾ��������========");
			
			forward = "DISP";
			
			
		} else if ("DELETE".equals(mapping.getParameter())){
			
			log.debug("========Ԥ֧���ù���ɾ������ʼ========");
			//DTO��������趨
			dto.setDeleteAcid(form.getDeleteAcid());
			
			if (isTokenValid(req, true)) {
				
				ctlBL.deleteAdvanCescostAction(dto);
			} else {
				
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			
			log.debug("========Ԥ֧���ù���ɾ����������========");
			
			forward = "DELETE";
			
		} else if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//Ԥ֧���ù����ѯ����
			log.debug("========Ԥ֧���ù����ѯ����ʼ========");
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGLOM0302");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGLOM0302Form) req.getSession().getAttribute("IGLOM0302Form");
				if ( form == null ) {
					form = new IGLOM0302Form();
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
					form = (IGLOM0302Form) req.getSession().getAttribute("IGLOM0302Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGLOM0302");
			
			//DTO��������趨
			dto.setAdvanCescostSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//Ԥ֧���ù�����Ϣ�����߼�����
			dto = ctlBL.searchAdvanCescostAction(dto);
			
			
			//��Ԥ֧���ù�����Ϣ��������趨��VO��
			IGLOM03021VO vo = new IGLOM03021VO();
			vo.setAdvanCescostList(dto.getAdvanCescostList());
			
			super.<IGLOM03021VO>setVO(req, vo);
			
			log.debug("========Ԥ֧���ù����ѯ��������========");
			
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
