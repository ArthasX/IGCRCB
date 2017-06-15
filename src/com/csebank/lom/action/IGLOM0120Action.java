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
import com.csebank.lom.form.IGLOM0120Form;
import com.csebank.lom.vo.IGLOM01081VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.utility.IGStringUtils;

/**
 * ģ�飺���ڹ���-�Ӵ�����-����ͲͲ��Ż���
 * ˵�������ŽӴ�ͳ��Action
 * ���ߣ�������
 */
public class IGLOM0120Action extends BaseAction {

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
		IGLOM0120Form form = (IGLOM0120Form)actionForm;
		
		//BLȡ��
		IGLOM01BL ctlBL = (IGLOM01BL) getBean("iglom01BL");
		
		//DTO����
		IGLOM01DTO dto = new IGLOM01DTO();
		
		String forward = "";
		//������ʾ��ת�����Բ�ѯ��ҳ��
		if( "DISP".equals(mapping.getParameter())){
			
			//���ŽӴ�ͳ�Ʋ�ѯ���������ʾ����
			log.debug("========��������Ͳ�ͳ�Ʋ�ѯ���������ʾ����ʼ========");
			form.setYear(IGStringUtils.getCurrentYear());
			form.setMonth_to(IGStringUtils.getCurrentDate().substring(5,7));		
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========��������Ͳ�ͳ�Ʋ�ѯ���������ʾ��������========");
			
			forward = "DISP";
			
			
		}else if( "SEARCH".equals(mapping.getParameter())){
			//���ŽӴ�ͳ�Ʋ�ѯ����
			log.debug("========��������Ͳ�ͳ�Ʋ�ѯ����ʼ========");
	
			form = (IGLOM0120Form) req.getSession().getAttribute("IGLOM0120Form");
			//DTO��������趨
			dto.setDealOrgVWSearchCond(form);
						
			//���ŽӴ�ͳ����Ϣ�����߼�����
			dto = ctlBL.searchDealOrgVWAction(dto);		
			
			//�����ŽӴ�ͳ����Ϣ��������趨��VO��
			IGLOM01081VO vo = new IGLOM01081VO();
			vo.setDealOrgVWList(dto.getDealOrgVWList());
			
			super.<IGLOM01081VO>setVO(req, vo);
			
			log.debug("========��������Ͳ�ͳ�Ʋ�ѯ��������========");
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
