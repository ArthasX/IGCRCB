/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.crc.action;

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
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.crc.bl.IGCRC04BL;
import com.deliverik.infogovernor.crc.dto.IGCRC04DTO;
import com.deliverik.infogovernor.crc.form.IGCRC0403Form;
import com.deliverik.infogovernor.crc.vo.IGCRC04031VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: 
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGCRC0403Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��־����ȡ��
		Log log = LogFactory.getLog(IGCRC0403Action.class);
		//BLȡ��
		IGCRC04BL ctlBL = (IGCRC04BL) getBean("igcrc04BL");
		//ʵ����dto
		IGCRC04DTO dto = new IGCRC04DTO();
		//��¼�û�ȡ��
		User user = (User) request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		//formȡ��
		IGCRC0403Form form = (IGCRC0403Form) actionForm;
		//dto����ȡ��
		dto.setUser(user);
		dto.setForm(form);
		//ҳ���ʼ������
		if("DISP".equals(mapping.getParameter())){
			log.debug("==============�����������ҳ���ʼ��������ʼ================");
			dto = ctlBL.initAssignPageAction(dto);
			//ʵ����dto
			IGCRC04031VO vo = new IGCRC04031VO();
			vo.setAssignInfo(dto.getAssignInfo());
			super.<IGCRC04031VO>setVO(request, vo);
			saveToken(request);
			log.debug("==============�����������ҳ���ʼ����������================");
		}
		
		//���ɲ���
		if("ASSIGN".equals(mapping.getParameter())){
			log.debug("=============����������ɲ�����ʼ===============");
			if (isTokenValid(request, true)){
				dto = ctlBL.assignAction(dto);
			}else{
				addMessage(request, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			log.debug("=============����������ɲ�������===============");
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
