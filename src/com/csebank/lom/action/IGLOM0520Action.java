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

import com.csebank.lom.bl.IGLOM05BL;
import com.csebank.lom.dto.IGLOM05DTO;
import com.csebank.lom.form.IGLOM0520Form;
import com.csebank.lom.vo.IGLOM01081VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.utility.IGStringUtils;



/**
 * ģ�飺���ڹ���-ʳ�ù���-�����д�����
 * ˵���������д�����Action
 * ���ߣ�������
 */
public class IGLOM0520Action extends BaseAction {

	static Log log = LogFactory.getLog(IGLOM0520Action.class);

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
		IGLOM0520Form form = (IGLOM0520Form)actionForm;
		
		//BLȡ��
		IGLOM05BL ctlBL = (IGLOM05BL) getBean("iglom05BL");
		
		//DTO����
		IGLOM05DTO dto = new IGLOM05DTO();
		
		String forward = "";
		//������ʾ��ת�����Բ�ѯ��ҳ��
		if( "DISP".equals(mapping.getParameter())){
			
			
			log.debug("========�����д����ܲ�ѯ���������ʾ����ʼ========");
			form.setYear(IGStringUtils.getCurrentYear());
			form.setMonth_to(IGStringUtils.getCurrentDate().substring(5,7));		
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========�����д����ܲ�ѯ���������ʾ��������========");
			
			forward = "DISP";
			
		
		}else if( "SEARCH".equals(mapping.getParameter())){
			
			log.debug("========�����д����ܲ�ѯ����ʼ========");
	
			form = (IGLOM0520Form) req.getSession().getAttribute("IGLOM0520Form");
			
			dto.setEeOrgVWSearchCond(form);
						
		
			dto = ctlBL.searchEEOrgVWAction(dto);		
			
			
			IGLOM01081VO vo = new IGLOM01081VO();
			vo.setEeOrgVWList(dto.getEeOrgVWList());
			
			super.<IGLOM01081VO>setVO(req, vo);
			
			log.debug("========ʳ�ù����Ż��ܲ�ѯ��������========");
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
