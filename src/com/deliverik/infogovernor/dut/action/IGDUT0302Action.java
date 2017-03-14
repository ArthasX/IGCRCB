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
import com.deliverik.infogovernor.dut.bl.IGDUT03BL;
import com.deliverik.infogovernor.dut.dto.IGDUT03DTO;
import com.deliverik.infogovernor.dut.form.IGDUT0302Form;
import com.deliverik.infogovernor.dut.vo.IGDUT03021VO;

/**
 * ֵ���������Action
 */
public class IGDUT0302Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDUT0302Action.class);

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
			
			//DTO��������趨
			dto.setDutyResultSearchCond(form);
			
			//ֵ����Ϣ�����߼�����
			dto = ctlBL.searchAllDutyResultAction(dto);
			
			//��ֵ����Ϣ��������趨��VO��
			IGDUT03021VO vo = new IGDUT03021VO();
			vo.setDutyResultList(dto.getDutyResultList());
			vo.setDutyPlanAM(dto.getDutyPlanAM());
			vo.setDutyPlanPM(dto.getDutyPlanPM());
			
			super.<IGDUT03021VO>setVO(req, vo);
			
			log.debug("========ֵ���ѯ��������========");
			
			forward = "DISP";
		}else if("UPDATE".equals(mapping.getParameter())){
			
			//ֵ����˵���޸Ĵ���
			log.debug("========ֵ����˵���޸Ĵ���ʼ========");
			
			//DTO��������趨
			dto.setIgDUT0302Form(form);
			
			//ֵ����Ϣ�����߼�����
			dto = ctlBL.changeDrresultAction(dto);
			
			log.debug("========ֵ����˵���޸Ĵ�������========");
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
