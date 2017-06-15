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
import com.deliverik.framework.base.PagingDTO;


public class IGLOM0405Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGLOM0405Action.class);
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String forward="";
		//ʵ����FORM
		IGLOM0405Form form = (IGLOM0405Form)actionForm;
		if( "TONGJI".equals(mapping.getParameter())){
			log.debug("========��Ʊ����ͳ�Ƴ�ʼ����ʼ========");
		//	form.setKpiYear(IGStringUtils.getCurrentYear());
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========��Ʊ����ͳ�Ƴ�ʼ����ʼ����========");
			forward="TONGJI";
		}	
		//��ȡBL�ӿ�ʵ��
		IGLOM04BL ctlBL = (IGLOM04BL) getBean("iglom04BL");
		//ʵ����DTO
		IGLOM04DTO dto = new IGLOM04DTO();
		//ͳ�Ʋ��Ų�ѯ
		if( "SEARCHVW".equals(mapping.getParameter())){
			log.debug("========��Ʊͳ�Ʋ�ѯ����ʼ========");
			
			//��ȡ��ҳBean
			getPaginDTO(req,"IGLOM0405");

			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			
			if (req.getParameter("PAGING") == null) {
				pDto.setFromCount(0);
				form = (IGLOM0405Form) req.getSession().getAttribute("IGLOM0405Form");
				if (form !=null) {
					form.setFromCount(0);
				}
			}
			int maxCnt = getMaxDataCount("IGLOM0405");
			
			dto.setInvoiceInfoSearchCond(form);
			
            dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//����BL��ѯ
			dto = ctlBL.searchInvoiceVWAction(dto);
			
			//����VO
			IGLOM04021VO vo = new IGLOM04021VO(dto.getInvoiceVWList());
			
			super.<IGLOM04021VO>setVO(req, vo);
			
			log.debug("========��Ʊͳ�Ʋ�ѯ��������========");
			forward="DISK";
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
