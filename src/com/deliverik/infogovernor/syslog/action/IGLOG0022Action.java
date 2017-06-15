package com.deliverik.infogovernor.syslog.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.syslog.bl.IGLOG002BL;
import com.deliverik.infogovernor.syslog.dto.IGLOG0021DTO;
import com.deliverik.infogovernor.syslog.form.IGLOG0022Form;
import com.deliverik.infogovernor.syslog.vo.IGLOG0022VO;
/**
 * 
 * �澯����ģ�����ACTION
 *
 * @���� ��ʡ
 *
 * ������2013-4-8
 * �޸ģ�2013-8-19
 */
public class IGLOG0022Action extends BaseAction{
	static Log log = LogFactory.getLog(IGLOG0022Action.class);

	/**
	 * �澯����ģ�����
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//ʵ����DTO
		IGLOG0021DTO dto = new IGLOG0021DTO();
		
		//ʵ����form��
		IGLOG0022Form form = (IGLOG0022Form) actionForm;
		
		//ʵ����ctrolBL
		IGLOG002BL ctlBL = (IGLOG002BL) getBean("iglog002BL");
		
		//�澯����ģ��ҳ���ʼ��
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========�澯����ģ��ҳ���ʼ����ʼ========");
			//�Ƿ���ʾ���ذ�ť
			String couldReturn = request.getParameter("couldReturn");
			IGLOG0022VO vo = new IGLOG0022VO();
			vo.setCouldReturn(couldReturn);
			super.<IGLOG0022VO>setVO(request, vo);
			log.debug("========�澯����ģ��ҳ���ʼ������========");
		}
		
		if( "INSERT".equals(mapping.getParameter())){
			log.debug("========�澯����ģ��¼�뿪ʼ========");
			
			//��¼��form��������dto��
			dto.setIgLog0022Form(form);
			
			//¼��澯����
			dto = ctlBL.insertDeviceAndRules(dto);
			
			log.debug("========�澯����ģ��¼�����========");
		}
		
		if("DISP_FAST".equals(mapping.getParameter())){
			log.debug("========����¼��澯����ģ��ҳ���ʼ����ʼ========");
			dto.setIgLog0022Form(form);
			dto = ctlBL.getDeviceByIp(dto);
			IGLOG0022VO vo = new IGLOG0022VO();
			vo.setMss00001TB(dto.getMss00001TB());
			vo.setPriority(form.getPriority());
			if(form.getAlarmmsgs() != null)
				vo.setAlarmmsg(form.getAlarmmsgs()[0]);
			super.<IGLOG0022VO>setVO(request, vo);
			log.debug("========����¼��澯����ģ��ҳ���ʼ������========");
		}
		
		if("INSERT_FAST".equals(mapping.getParameter())){
			log.debug("========����¼��澯����ʼ========");
			dto.setIgLog0022Form(form);
			dto = ctlBL.fastConfigAlarmRule(dto);
			log.debug("========����¼��澯�������========");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}

}
