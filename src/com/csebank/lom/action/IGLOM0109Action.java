/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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

import com.csebank.lom.bl.IGLOM01BL;
import com.csebank.lom.dto.IGLOM01DTO;
import com.csebank.lom.form.IGLOM0109Form;
import com.csebank.lom.vo.IGLOM0109VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;

public class IGLOM0109Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGLOM0109Action.class);
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
        
		String forward="";
		//ʵ����FORM
		IGLOM0109Form form = (IGLOM0109Form)actionForm;
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========�Ӵ����˲�ѯ��ʼ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("=======�Ӵ����˲�ѯ��ʼ����ʼ����========");
			forward="DISP";
		}	
		//��ȡBL�ӿ�ʵ��
		IGLOM01BL ctlBL = (IGLOM01BL) getBean("iglom01BL");
		//ʵ����DTO
		IGLOM01DTO dto = new IGLOM01DTO();
		//ͳ����ͳ��
		if( "SEARCH".equals(mapping.getParameter())){
			log.debug("========�Ӵ����˲�ѯ����ʼ========");	
			getPaginDTO(req,"IGLOM0402");

			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
		    dto.getMaxSearchCount();
			dto.setRecptionGuestInfoCond(form);
            int maxCnt = getMaxDataCount("IGLOM0402");			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			//����BL��ѯ
			dto = ctlBL.searchRecptionGuestInfoAction(dto);
			
			//����VO
			IGLOM0109VO vo = new IGLOM0109VO(dto.getRecptionGuestInfoList());
			
			super.<IGLOM0109VO>setVO(req, vo);
			
			log.debug("========�Ӵ����˲�ѯ��������========");
			forward="DISP";
		}
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
		}
//		if(StringUtils.isNotEmpty(req.getParameter("report"))) {
//			return mapping.findForward("REPORT");
//		}
		return mapping.findForward(forward);
	}
	
}
