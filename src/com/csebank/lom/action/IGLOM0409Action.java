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

import com.csebank.lom.bl.IGLOM04BL;
import com.csebank.lom.dto.IGLOM04DTO;
import com.csebank.lom.form.IGLOM0409Form;
import com.csebank.lom.vo.IGLOM04021VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;

/**
 *  ��Ʊ����ͳ����ϸAction
 * 
 */
public class IGLOM0409Action extends BaseAction {

	static Log log = LogFactory.getLog(IGLOM0409Action.class);

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
		
		String forward="";
		//ʵ����FORM
		IGLOM0409Form form = (IGLOM0409Form)actionForm;
		
		//BLȡ��
		IGLOM04BL ctlBL = (IGLOM04BL) getBean("iglom04BL");
		
		//DTO����
		IGLOM04DTO dto = new IGLOM04DTO();
	
		if( "SEARCH".equals(mapping.getParameter())){
			log.debug("========��Ʊ����ͳ����ϸ��Ϣ��ѯ����ʼ========");
			//��ȡ��ҳBean
			getPaginDTO(req,"IGLOM0409");

			PagingDTO pDto = (PagingDTO)req.getAttribute("PagingDTO");

			if (req.getParameter("PAGING") == null) {
				pDto.setFromCount(0);
				form = (IGLOM0409Form) req.getSession().getAttribute("IGLOM0409Form");
				if (form !=null) {
					form.setFromCount(0);
				}
			}

			int maxCnt = getMaxDataCount("IGLOM0409");
			
			dto.setInvoiceInfoSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			//����BL��ѯ
			dto = ctlBL.searchInvoiceAction(dto);
			//����VO
			IGLOM04021VO vo = new IGLOM04021VO(null);
			vo.setInvoiceList(dto.getInvoiceList());
			
			super.<IGLOM04021VO>setVO(req, vo);
			
			log.debug("========��Ʊ����ͳ����ϸ��Ϣ��ѯ�����ѯ��������========");
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
