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
import com.deliverik.infogovernor.dut.bl.IGDUT03BL;
import com.deliverik.infogovernor.dut.dto.IGDUT03DTO;
import com.deliverik.infogovernor.dut.form.IGDUT0302Form;
import com.deliverik.infogovernor.dut.vo.IGDUT03031VO;

/**
 * ֵ���������Action
 */
public class IGDUT0303Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDUT0303Action.class);

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
		IGDUT0302Form form = (IGDUT0302Form)actionForm;
		
		//BLȡ��
		IGDUT03BL ctlBL = (IGDUT03BL) getBean("igdut03BL");
		
		//DTO����
		IGDUT03DTO dto = new IGDUT03DTO();
		
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
			
			
		} else if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//ֵ���ѯ����
			log.debug("========ֵ���ѯ����ʼ========");
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGDUT0302");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGDUT0302Form) req.getSession().getAttribute("IGDUT0302Form");
				if ( form == null ) {
					form = new IGDUT0302Form();
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
					form = (IGDUT0302Form) req.getSession().getAttribute("IGDUT0302Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGDUT0302");
			
			//DTO��������趨
//			form.setEstatus(null);
			dto.setDutyResultSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//ֵ����Ϣ�����߼�����
			dto = ctlBL.searchDutyResultAction(dto);
			
			
			//��ֵ����Ϣ��������趨��VO��
			IGDUT03031VO vo = new IGDUT03031VO();
			vo.setDutyResultList(dto.getDutyResultList());
			
			super.<IGDUT03031VO>setVO(req, vo);
			
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
