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
import com.deliverik.infogovernor.dut.bl.IGDUT02BL;
import com.deliverik.infogovernor.dut.dto.IGDUT02DTO;
import com.deliverik.infogovernor.dut.form.IGDUT0206Form;
import com.deliverik.infogovernor.dut.vo.IGDUT02061VO;

/**
 * ֵ������Action
 */
public class IGDUT0206Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDUT0206Action.class);

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
		IGDUT0206Form form = (IGDUT0206Form)actionForm;
		
		//BLȡ��
		IGDUT02BL ctlBL = (IGDUT02BL) getBean("igdut02BL");
		
		//DTO����
		IGDUT02DTO dto = new IGDUT02DTO();
		
		String forward = "null";
		
		if ("CHANGE".equals(mapping.getParameter())){
			
			log.debug("========ֵ��״̬ͣ��/���ô���ʼ========");
			//DTO��������趨
			dto.setIgDUT0206Form(form);
			
			ctlBL.changeDutyPlanAction(dto);
			
			log.debug("========ֵ��״̬ͣ��/���ô�������========");
			
			forward = "CHANGE";
			
		} else if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//ֵ���ѯ����
			log.debug("========ֵ���ѯ����ʼ========");
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGDUT0206");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGDUT0206Form) req.getSession().getAttribute("IGDUT0206Form");
				if ( form == null ) {
					form = new IGDUT0206Form();
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
					form = (IGDUT0206Form) req.getSession().getAttribute("IGDUT0206Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGDUT0206");
			
			//DTO��������趨
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			dto.setIgDUT0206Form(form);
			
			//ֵ����Ϣ�����߼�����
			dto = ctlBL.searchDutyPlanAction(dto);
			//��ֵ����Ϣ��������趨��VO��
			IGDUT02061VO vo = new IGDUT02061VO();
			vo.setDutyPlanList(dto.getDutyPlanList());
			
			super.<IGDUT02061VO>setVO(req, vo);
			
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
