package com.deliverik.infogovernor.syslog.action;

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
import com.deliverik.infogovernor.syslog.bl.IGLOG004BL;
import com.deliverik.infogovernor.syslog.dto.IGLOG0041DTO;
import com.deliverik.infogovernor.syslog.form.IGLOG0042Form;
import com.deliverik.infogovernor.syslog.vo.IGLOG0041VO;
import com.deliverik.infogovernor.syslog.vo.IGLOG0043VO;
/**
 * 
 * ��������ģ��¼��Action
 *
 * @���� zhaoyong
 *
 * 2013-4-2
 */
public class IGLOG0043Action extends BaseAction{
	static Log log = LogFactory.getLog(IGLOG0043Action.class);

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//ʵ����DTO
		IGLOG0041DTO dto = new IGLOG0041DTO();
		
		//ʵ����form��
		IGLOG0042Form form = (IGLOG0042Form) actionForm;
		
		//ʵ����ctrolBL
		IGLOG004BL ctlBL = (IGLOG004BL) getBean("iglog004BL");
		
		//ģ��¼��ҳ���ʼ��
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========��������ģ��¼��ҳ���ʼ����ʼ========");
			
			dto = ctlBL.getAlarmPriority(dto);
			String couldReturn = request.getParameter("couldReturn");
			
			IGLOG0041VO vo = new IGLOG0041VO();
			vo.setCouldReturn(couldReturn);
			vo.setAlarmPriorities(dto.getAlarmPriorities());
			super.<IGLOG0041VO>setVO(request,vo);
			
			log.debug("========��������ģ��¼��ҳ���ʼ������========");
		}
		
		//��ģ��¼��
		if("INSERT".equals(mapping.getParameter())){
			log.debug("========��������ģ��¼�뿪ʼ========");
			
			//��form���뵽dto��
			dto.setIgLog0042Form(form);
			
			//����ctlBL¼���������
			dto = ctlBL.insertMss0004(dto);
			
			//�ɹ���Ϣ
			List<ActionMessage> messageList = dto.getMessageList();
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(request, message);
				}
			}
			
			log.debug("========��������ģ��¼�����========");
		}
		
		//ģ���޸�ҳ���ʼ��
		if( "EDIT_DISP".equals(mapping.getParameter())){
			log.debug("========��������ģ���޸�ҳ���ʼ����ʼ========");
			
			//��form���뵽����dto��
			dto.setIgLog0042Form(form);
			
			//����ctlBL��ѯ��ǰ��������
			dto = ctlBL.getMss0004(dto);
			
			dto = ctlBL.getAlarmPriority(dto);
			
			dto = ctlBL.getDeviceListString(dto);
			
			//ʵ��������vo
			IGLOG0043VO vo = new IGLOG0043VO();
			
			vo.setMss00004TB(dto.getMss00004TB());
			
			vo.setMss00003InfoList(dto.getMss00003InfoList());
			
			vo.setAlarmPrioritiesList(dto.getAlarmPrioritiesList());
			
			vo.setAlarmPriorities(dto.getAlarmPriorities());
			
			vo.setDeviceListString(dto.getDeviceListString());
			
			super.<IGLOG0043VO>setVO(request,vo);
			
			log.debug("========��������ģ���޸�ҳ���ʼ������========");
		}
		
		//ģ���޸�
		if( "EDIT".equals(mapping.getParameter())){
			log.debug("========��������ģ���޸Ŀ�ʼ========");
			
			//��form���뵽����dto��
			dto.setIgLog0042Form(form);
			
			//����ctlBL�޸Ĺ�������ģ��
			dto=ctlBL.updateMss0004(dto);
			
			//�ɹ���Ϣ
			List<ActionMessage> messageList = dto.getMessageList();
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(request, message);
				}
			}
			
			log.debug("========��������ģ���޸Ľ���========");
			
		}
		
		
		return mapping.findForward("DISP");
	}

}
