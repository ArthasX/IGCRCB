/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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

import com.csebank.lom.bl.IGLOM04BL;
import com.csebank.lom.dto.IGLOM04DTO;
import com.csebank.lom.form.IGLOM0405Form;
import com.csebank.lom.vo.IGLOM04021VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.utility.IGStringUtils;

public class IGLOM0406Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGLOM0405Action.class);
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
        
		String forward="";
		//ʵ����FORM
		IGLOM0405Form form = (IGLOM0405Form)actionForm;
		if( "VWBYYEAR".equals(mapping.getParameter())){
			log.debug("========��Ʊ���ͳ�Ƴ�ʼ����ʼ========");
			form.setIyear(IGStringUtils.getCurrentYear());
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========��Ʊ���ͳ�Ƴ�ʼ����ʼ����========");
			forward="YEAR";
		}	
		//��ȡBL�ӿ�ʵ��
		IGLOM04BL ctlBL = (IGLOM04BL) getBean("iglom04BL");
		//ʵ����DTO
		IGLOM04DTO dto = new IGLOM04DTO();
		//ͳ����ͳ��
		if( "SEARCHBYYEAR".equals(mapping.getParameter())){
			log.debug("========��Ʊ���ͳ�ƴ���ʼ========");	
			//��istatus���ڡ�year����ʾ������ͳ��
			form.setIstatus("year");
			dto.setInvoiceInfoSearchCond(form);
			
			//����BL��ѯ
			dto = ctlBL.searchInvoiceYearVWAction(dto);
			
			//����VO
			IGLOM04021VO vo = new IGLOM04021VO(dto.getInvoiceVWList());
			
			super.<IGLOM04021VO>setVO(req, vo);
			
			log.debug("========��Ʊ���ͳ�ƴ�������========");
			forward="YEAREND";
		}
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
		}
		if(StringUtils.isNotEmpty(req.getParameter("report"))) {
			return mapping.findForward("REPORT");
		}
		return mapping.findForward(forward);
	}
	
}
