/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.action;

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
import com.csebank.lom.form.IGLOM0402Form;
import com.csebank.lom.util.CodeUtils;
import com.csebank.lom.util.LOMHelper;
import com.csebank.lom.vo.IGLOM04021VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;

/**
 * ��Ʊ��������Action
 * 
 */
public class IGLOM0402Action extends BaseAction {

	static Log log = LogFactory.getLog(IGLOM0103Action.class);

	/**
	 * ����
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
		IGLOM0402Form form = (IGLOM0402Form)actionForm;		
		//��ȡBL�ӿ�ʵ��
		IGLOM04BL ctlBL = (IGLOM04BL) getBean("iglom04BL");
		//ʵ����DTO
		IGLOM04DTO dto = new IGLOM04DTO();
		String forward = "";
		//��Ʊ����		
		req.setAttribute("invoice_itype", LOMHelper.getItemsCodes(CodeUtils.INVOICE_ITYPE));
		//����״̬
		req.setAttribute("invoice_istatus", LOMHelper.getItemsCodes(CodeUtils.INVOICE_ISTATUS));
		//���ʽ
		req.setAttribute("invoice_ipaymenttype", LOMHelper.getItemsCodes(CodeUtils.INVOICE_IPAYMENTTYPE));
		
		if( "DISP_SEARCH".equals(mapping.getParameter())){
			
			//��Ʊ�����ѯ���������ʾ����
			log.debug("========��Ʊ�����ѯ���������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========��Ʊ�����ѯ���������ʾ��������========");
			
			forward = "DISP";
			
		}	
		//��Ʊ��ѯ
		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			log.debug("========��Ʊ��ѯ����ʼ========");
			//��ȡ��ҳBean
			getPaginDTO(req,"IGLOM0402");

			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGLOM0402Form) req.getSession().getAttribute("IGLOM0402Form");
				if ( form== null){
					form = new IGLOM0402Form();
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
					form = (IGLOM0402Form) req.getSession().getAttribute("IGLOM0402Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			int maxCnt = getMaxDataCount("IGLOM0402");
			
			dto.setInvoiceInfoSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			//����BL��ѯ
			dto = ctlBL.searchInvoiceAction(dto);
			//����VO
			IGLOM04021VO vo = new IGLOM04021VO(null);
			vo.setInvoiceList(dto.getInvoiceList());
			
			super.<IGLOM04021VO>setVO(req, vo);
			
			log.debug("========�û���ѯ��������========");
			forward = "SEARCH_END";
		}
		//ɾ��
		if ("DELETE".equals(mapping.getParameter())){
			log.debug("========֪ͨɾ������ʼ========");
			dto.setDeleteNid(form.getIid());
			ctlBL.deleteNoticeAction(dto);
			log.debug("========֪ͨɾ����������========");
			forward="DELETE_END";
		}
//		List<ActionMessage> messageList = dto.getMessageList();
//		
//		if( messageList != null && messageList.size() > 0 ) {
//			for (ActionMessage message : messageList) {	
//				addMessage(request, message);
//			}
//		}
		return mapping.findForward(forward);
	}

}
