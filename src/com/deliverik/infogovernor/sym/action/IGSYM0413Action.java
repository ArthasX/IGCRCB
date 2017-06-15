/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.sym.bl.IGSYM04BL;
import com.deliverik.infogovernor.sym.dto.IGSYM04DTO;
import com.deliverik.infogovernor.sym.form.IGSYM0413Form;
import com.deliverik.infogovernor.sym.vo.IGSYM04091VO;

/**
 * �����ѯAction����
 *
 */
public class IGSYM0413Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSYM0413Action.class);

	/**
	 * �����ѯ����
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return ActionForward
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGSYM0413Form form = (IGSYM0413Form)actionForm;
		
		//BLȡ��
		IGSYM04BL ctlBL = (IGSYM04BL) getBean("igsym04BL");
		
		//DTO����
		IGSYM04DTO dto = new IGSYM04DTO();
		
		if ( "SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())){
			//�����ѯ����
			log.debug("========�����ѯ����ʼ========");
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGSYM0413");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGSYM0413Form) req.getSession().getAttribute("IGSYM0413Form");
				if ( form == null ) {
					form = new IGSYM0413Form();
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
					form = (IGSYM0413Form) req.getSession().getAttribute("IGSYM0413Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGSYM0413");
			
			dto.setReportFileDefinitionSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//������Ϣ�����߼�����
			dto = ctlBL.searchReportFileDefinitionAction(dto);
			
			//��������Ϣ��������趨��VO��
			IGSYM04091VO vo = new IGSYM04091VO(dto.getReportFileDefinitionList());
			
			super.<IGSYM04091VO>setVO(req, vo);
			
			log.debug("========�����ѯ��������========");
		} else if ("INIT".equals(mapping.getParameter())){ //������Ϣ���ҳ���ʼ��
			
			log.debug("========������Ϣ���������ʾ����ʼ========");
			
			dto.setIgSYM0413Form(form);
			
			dto = ctlBL.initReportFileDefinitionAction(dto);
			
			log.debug("========������Ϣ���������ʾ��������========");
		}
		
		//�߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}

		return mapping.findForward("DISP");
	}
}
