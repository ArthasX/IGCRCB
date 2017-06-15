/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.csebank.lom.bl.IGLOM01BL;
import com.csebank.lom.dto.IGLOM01DTO;
import com.csebank.lom.form.IGLOM0108Form;
import com.csebank.lom.vo.IGLOM01081VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.utility.IGStringUtils;

/**
 * ���ŽӴ�ͳ��Action
 * 
 */
public class IGLOM0108Action extends BaseAction {

	static Log log = LogFactory.getLog(IGLOM0108Action.class);

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
		IGLOM0108Form form = (IGLOM0108Form)actionForm;
		
		//BLȡ��
		IGLOM01BL ctlBL = (IGLOM01BL) getBean("iglom01BL");
		
		//DTO����
		IGLOM01DTO dto = new IGLOM01DTO();
		
		String forward = "";
		
		if( "DISP".equals(mapping.getParameter())){
			
			//���ŽӴ�ͳ�Ʋ�ѯ���������ʾ����
			log.debug("========���ŽӴ�ͳ�Ʋ�ѯ���������ʾ����ʼ========");
			form.setYear(IGStringUtils.getCurrentYear());
			form.setMonth_to(IGStringUtils.getCurrentDate().substring(5,7));
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========���ŽӴ�ͳ�Ʋ�ѯ���������ʾ��������========");
			
			forward = "DISP";
			
			
		}else if( "SEARCH".equals(mapping.getParameter())){
			//���ŽӴ�ͳ�Ʋ�ѯ����
			log.debug("========���ŽӴ�ͳ�Ʋ�ѯ����ʼ========");
	
			form = (IGLOM0108Form) req.getSession().getAttribute("IGLOM0108Form");
			//DTO��������趨
			dto.setRecptionOrgVWSearchCond(form);
						
			//���ŽӴ�ͳ����Ϣ�����߼�����
			dto = ctlBL.searchRecptionOrgVWAction(dto);		
			
			//�����ŽӴ�ͳ����Ϣ��������趨��VO��
			IGLOM01081VO vo = new IGLOM01081VO();
			vo.setRecptionOrgVWList(dto.getRecptionOrgVWList());
			
			super.<IGLOM01081VO>setVO(req, vo);
			
			log.debug("========���ŽӴ�ͳ�Ʋ�ѯ��������========");
			if(StringUtils.isNotEmpty(req.getParameter("report"))) {
				return mapping.findForward("REPORT");
			} else {
				forward = "DISP";
			}
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
