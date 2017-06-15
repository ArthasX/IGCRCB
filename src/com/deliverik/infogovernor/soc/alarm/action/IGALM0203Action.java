/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.soc.alarm.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.soc.alarm.bl.IGALM02BL;
import com.deliverik.infogovernor.soc.alarm.dto.IGALM02DTO;
import com.deliverik.infogovernor.soc.alarm.form.IGALM0201Form;
import com.deliverik.infogovernor.soc.alarm.model.entity.CRM07TB;
import com.deliverik.infogovernor.soc.alarm.vo.IGALM02031VO;

/**
 * ����ģ���޸Ĵ���
 * @author zhangnan 
 * 2013.08.02
 */
public class IGALM0203Action extends BaseAction {

	static Log log = LogFactory.getLog(IGALM0203Action.class);

	/**
	 * ����ģ���޸Ĵ���
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
		IGALM0201Form form = (IGALM0201Form)actionForm;
		
		//BLȡ��
		IGALM02BL ctlBL = (IGALM02BL) getBean("igalm02BL");
		//DTO����
		IGALM02DTO dto = new IGALM02DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========����ģ���޸Ļ��������ʾ����ʼ========");
			dto.setIgalm0201Form(form);
			dto = ctlBL.initRuleTemp(dto);
			//��������ȡ��
			List<CRM07TB> crm07TBList = dto.getCrm07TBList();
			//���ָ��ȡ��
			List<LabelValueBean> monitorIndexList = dto.getMonitorIndexList();
			req.setAttribute("monitorIndexList", monitorIndexList);
			IGALM02031VO vo=new IGALM02031VO();
			vo.setCrm07TBList(crm07TBList);
			super.<IGALM02031VO>setVO(req, vo);
			log.debug("========����ģ���޸Ļ��������ʾ��������========");
			
		}else if("EDIT".equals(mapping.getParameter())){
			log.debug("========����ģ���޸Ĵ���ʼ========");
			dto.setIgalm0201Form(form);
			dto = ctlBL.updateRuleTemp(dto);
			log.debug("========����ģ���޸Ĵ�������========");
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
