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
import com.csebank.lom.form.IGLOM0304Form;
import com.csebank.lom.util.CodeUtils;
import com.csebank.lom.util.LOMHelper;
import com.csebank.lom.vo.IGLOM03041VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;

/**
 * ���Action
 * 
 */
public class IGLOM0304Action extends BaseAction {

	static Log log = LogFactory.getLog(IGLOM0304Action.class);

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
		IGLOM0304Form form = (IGLOM0304Form)actionForm;
		
		//BLȡ��
		IGLOM03BL ctlBL = (IGLOM03BL) getBean("iglom03BL");
		
		//DTO����
		IGLOM03DTO dto = new IGLOM03DTO();
		
		//��ǰ�û���Ϣ
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setUserid(user.getUserid());
		dto.setUsername(user.getUsername());
		//��ȡ����״̬�����б�
		req.setAttribute("sp_status", LOMHelper.getItemsCodes(CodeUtils.LOANPAYDETAIL_LPDSTATUS));
		String forward = "";
		
		if( "DISP".equals(mapping.getParameter())){
			
			//����ѯ���������ʾ����
			log.debug("========����ѯ���������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========����ѯ���������ʾ��������========");

			saveToken(req);
			forward = "DISP";
			
			
		} else if ("CHANGE".equals(mapping.getParameter())){
			
			log.debug("========���ȷ�ϴ���ʼ========");
			//DTO��������趨
			dto.setIglom0304Form(form);
			
			
			if (isTokenValid(req, true)) {

				ctlBL.changeLoanPayDetailAction(dto);
			} else {
				
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			
			
			log.debug("========���ȷ�ϴ�������========");
			
			forward = "CHANGE";
			
		} else if ("DELETE".equals(mapping.getParameter())){
			
			log.debug("========���ɾ������ʼ========");
			//DTO��������趨
			dto.setDeleteLpdid(form.getDeleteLpdid());
			
			
			if (isTokenValid(req, true)) {
				
				ctlBL.deleteLoanPayDetailAction(dto);
			} else {
				
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			
			log.debug("========���ɾ����������========");
			
			forward = "DELETE";
			
		} else if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			
			//����ѯ����
			log.debug("========����ѯ����ʼ========");
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGLOM0304");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGLOM0304Form) req.getSession().getAttribute("IGLOM0304Form");
				if ( form == null ) {
					form = new IGLOM0304Form();
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
					form = (IGLOM0304Form) req.getSession().getAttribute("IGLOM0304Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//��ѯ��¼�����ȡ��
			int maxCnt = getMaxDataCount("IGLOM0304");
			
			//DTO��������趨
			dto.setLoanPayDetailSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			saveToken(req);
			
			//�����Ϣ�����߼�����
			dto = ctlBL.searchLoanPayDetailAction(dto);
			
			
			//�������Ϣ��������趨��VO��
			IGLOM03041VO vo = new IGLOM03041VO();
			vo.setLoanPayDetailList(dto.getLoanPayDetailList());
			
			super.<IGLOM03041VO>setVO(req, vo);
			
			log.debug("========����ѯ��������========");
			
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
