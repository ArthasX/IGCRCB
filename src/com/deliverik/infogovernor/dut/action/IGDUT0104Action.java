/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dut.action;

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
import com.deliverik.infogovernor.dut.bl.IGDUT01BL;
import com.deliverik.infogovernor.dut.dto.IGDUT01DTO;
import com.deliverik.infogovernor.dut.form.IGDUT0104Form;
import com.deliverik.infogovernor.dut.vo.IGDUT01041VO;

/**
 * 
 * ֵ�������ѯ�б�Action
 *
 */
public class IGDUT0104Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDUT0104Action.class);

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
		IGDUT0104Form form = (IGDUT0104Form)actionForm;
		
		//BLȡ��
		IGDUT01BL ctlBL = (IGDUT01BL) getBean("igdut01BL");
		
		//DTO����
		IGDUT01DTO dto = new IGDUT01DTO();
		
		String forward = "null";
		
		if( "DISP".equals(mapping.getParameter())){
			
			//ֵ���ѯ���������ʾ����
			log.debug("========ֵ���ѯ���������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========ֵ���ѯ���������ʾ��������========");
			
			forward = "DISP";
			
			
		} else if("REDISP".equals(mapping.getParameter())){
			
			//ֵ���ѯ��������ʾ����
			log.debug("========ֵ���ѯ��������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========ֵ���ѯ��������ʾ��������========");
			
			forward = "DISP";
			
			
		} if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//ֵ���ѯ����
			log.debug("========ֵ���ѯ����ʼ========");
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGDUT0104");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGDUT0104Form) req.getSession().getAttribute("IGDUT0104Form");
				if ( form == null ) {
					form = new IGDUT0104Form();
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
					form = (IGDUT0104Form) req.getSession().getAttribute("IGDUT0104Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGDUT0104");
			
			//DTO��������趨
//			form.setEstatus(null);
			dto.setDutyAuditDefSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//ֵ����Ϣ�����߼�����
			dto = ctlBL.searchDutyAuditDefAction(dto);
			
			
			//��ֵ����Ϣ��������趨��VO��
			IGDUT01041VO vo = new IGDUT01041VO();
			vo.setDutyAuditList(dto.getDutyAuditList());
			
			super.<IGDUT01041VO>setVO(req, vo);
			
			log.debug("========ֵ���ѯ��������========");
			
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
