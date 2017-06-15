/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.risk.action;

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
import com.deliverik.infogovernor.risk.bl.IGRIS01BL;
import com.deliverik.infogovernor.risk.dto.IGRIS01DTO;
import com.deliverik.infogovernor.risk.form.IGRIS0118Form;
import com.deliverik.infogovernor.risk.vo.IGRIS01181VO;

/**
 * ���������ѯAction����
 *
 * @author liupeng@deliverik.com
 */
public class IGRIS0118Action extends BaseAction {

	static Log log = LogFactory.getLog(IGRIS0118Action.class);

	/**
	 * ���������ѯ����
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
		IGRIS0118Form form = (IGRIS0118Form)actionForm;
		
		//BLȡ��
		IGRIS01BL ctlBL = (IGRIS01BL) getBean("igRIS01BL");
		
		//DTO����
		IGRIS01DTO dto = new IGRIS01DTO();
		
		//��ȡ�汾���������б�
		dto = ctlBL.searchRiskAuditInsLabelInUse(dto);
		req.setAttribute("labelList", dto.getLabelList());
		
		if( "DISP".equals(mapping.getParameter())){
			//���������ѯ���������ʾ����
			log.debug("========���������ѯ���������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========���������ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		} else if ( "SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())){
			//���������ѯ����
			log.debug("========���������ѯ����ʼ========");
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGRIS0118");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGRIS0118Form) req.getSession().getAttribute("IGRIS0118Form");
				if ( form == null ) {
					form = new IGRIS0118Form();
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
					form = (IGRIS0118Form) req.getSession().getAttribute("IGRIS0118Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGRIS0118");
			
			dto.setRiskAuditInsSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//���������Ϣ�����߼�����
			dto = ctlBL.searchRiskAuditInsAction(dto);
			
			//�����������Ϣ��������趨��VO��
			IGRIS01181VO vo = new IGRIS01181VO(dto.getRiskAuditInsList());
			
			super.<IGRIS01181VO>setVO(req, vo);
			
			log.debug("========���������ѯ��������========");
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
