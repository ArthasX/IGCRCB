/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prr.action;

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
import com.deliverik.infogovernor.prr.bl.IGPRR01BL;
import com.deliverik.infogovernor.prr.dto.IGPRR01DTO;
import com.deliverik.infogovernor.prr.form.IGPRR0122Form;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̲�������ϢAction
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGPRR0122Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��־��Ϣȡ��
		Log log = LogFactory.getLog(IGPRR0122Action.class);
		//BLȡ��
		IGPRR01BL ctlBL = (IGPRR01BL) getBean("igPRR01BL");
		//ʵ����dto
		IGPRR01DTO dto = new IGPRR01DTO();
		//formȡ��
		IGPRR0122Form form = (IGPRR0122Form) actionForm;
		//ҳ����Ϣ��ʼ������
		if("DISP".equals(mapping.getParameter())){
			log.debug("==============���̲�������Ϣ��ʼ��������ʼ=================");
			User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			dto.setUser(user);
			dto.setPrid(form.getPrid());
			dto = ctlBL.searchParticipantInfoActon(dto);
			User authorizeuser = dto.getAuthorizeuser();
			//��Ȩģʽ�£�����������Ϣ����ӵ�������
            if(authorizeuser != null){
            	String personinfo = dto.getStatus();
            	personinfo = personinfo.replace(authorizeuser.getUsername(), authorizeuser.getUsername() + " ��ǰ�Ĵ����ˡ�" +user.getUsername()+"��" );
            	request.setAttribute("personinfo", personinfo);
            }else{
            	request.setAttribute("personinfo", dto.getStatus());
            }
			log.debug("==============���̲�������Ϣ��ʼ����������=================");
		}
		
		
		//�߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		} 
		return mapping.findForward("DISP");
	}

}
