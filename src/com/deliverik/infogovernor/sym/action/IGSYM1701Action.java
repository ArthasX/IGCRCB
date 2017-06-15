/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
import com.deliverik.infogovernor.sym.bl.IGSYM17BL;
import com.deliverik.infogovernor.sym.dto.IGSYM17DTO;
import com.deliverik.infogovernor.sym.form.IGSYM1701Form;
import com.deliverik.infogovernor.sym.vo.IGSYM17011VO;

/**
 * ����: ���̶����ѯAction����
 * �������������̶����ѯAction����
 * ������¼������    2010/11/26
 * �޸ļ�¼��
 */
public class IGSYM1701Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSYM1701Action.class);

	/**
	 * ���ܣ����̶����ѯ����
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
		IGSYM1701Form form = (IGSYM1701Form)actionForm;
		
		//BLȡ��
		IGSYM17BL ctlBL = (IGSYM17BL) getBean("igSYM17BL");
		
		//DTO����
		IGSYM17DTO dto = new IGSYM17DTO();
		
		dto.setIgSYM1701Form(form);
		
		if( "DISP".equals(mapping.getParameter())){
			//���̶����ѯ���������ʾ����
			log.debug("========���̶����ѯ���������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========���̶����ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		} else if ( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//���̶����ѯ����
			log.debug("========���̶����ѯ����ʼ========");
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGSYM1701");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGSYM1701Form) req.getSession().getAttribute("IGSYM1701Form");
				if ( form == null ) {
					form = new IGSYM1701Form();
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
					form = (IGSYM1701Form) req.getSession().getAttribute("IGSYM1701Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGSYM1701");
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//���̶�����Ϣ�����߼�����
			dto = ctlBL.searchProcessDefinitionAction(dto);
			
			//�����̶�����Ϣ��������趨��VO��
			IGSYM17011VO vo = new IGSYM17011VO(dto.getProcessDefinitionList());
			
			super.<IGSYM17011VO>setVO(req, vo);
			
			log.debug("========���̶����ѯ��������========");
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
