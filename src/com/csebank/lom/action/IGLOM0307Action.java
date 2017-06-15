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
import com.csebank.lom.form.IGLOM0307Form;
import com.csebank.lom.vo.IGLOM03021VO;
import com.csebank.lom.vo.IGLOM03071VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;

/**
 * ��ּƲƲ����Action
 * 
 */
public class IGLOM0307Action extends BaseAction {

	static Log log = LogFactory.getLog(IGLOM0307Action.class);

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
		IGLOM0307Form form = (IGLOM0307Form)actionForm;
		
		//BLȡ��
		IGLOM03BL ctlBL = (IGLOM03BL) getBean("iglom03BL");
		
		//DTO����
		IGLOM03DTO dto = new IGLOM03DTO();
		
		String forward = "";
		
		if( "DISP".equals(mapping.getParameter())){
			
			//��ּƲƲ�����ѯ���������ʾ����
			log.debug("========��ּƲƲ�����ѯ���������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========��ּƲƲ�����ѯ���������ʾ��������========");
			
			forward = "DISP";
			
			
		} else if ("PAY".equals(mapping.getParameter())){
			
			log.debug("========��ּƲƲ����Ԥ֧�����б��ʼ����ʼ========");
			//DTO��������趨
			dto.setIglom0307Form(form);
			//��ּƲƲ�������
			dto = ctlBL.searchLoanPayDetailSummaryAction(dto);
			IGLOM03021VO vo = new IGLOM03021VO();
			vo.setAdvanCescostList(dto.getAdvanCescostList());
			super.<IGLOM03021VO>setVO(req, vo);
			saveToken(req);
			forward = "PAY";
			log.debug("========��ּƲƲ����Ԥ֧�����б��ʼ������========");
			
		} else if ("CREDIT".equals(mapping.getParameter())){
			
			log.debug("========��ּƲƲ�����ʼ========");
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			dto.setUserid(user.getUserid());
			dto.setUsername(user.getUsername());
			//DTO��������趨
			dto.setIglom0307Form(form);
			//��ּƲƲ����
			if (isTokenValid(req, true)){
				dto = ctlBL.loanPayDetailCredit(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			forward = "CREDIT";
			log.debug("========��ּƲƲ���������========");
			
		} else if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			
			//��ּƲƲ�����ѯ����
			log.debug("========��ּƲƲ�����ѯ����ʼ========");
			
			//��ѯ��¼�����ȡ��
			int maxCnt = getMaxDataCount("IGLOM0307");
			
			//DTO��������趨
			dto.setLoanPayDetailSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			//��ּƲƲ������Ϣ�����߼�����
			dto = ctlBL.searchLoanPayDetailNoPagingAction(dto);
			
			//����ּƲƲ������Ϣ��������趨��VO��
			IGLOM03071VO vo = new IGLOM03071VO();
			vo.setLoanPayDetailList(dto.getLoanPayDetailList());
			
			super.<IGLOM03071VO>setVO(req, vo);
			
			log.debug("========��ּƲƲ�����ѯ��������========");
			
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
