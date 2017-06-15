/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.wim.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.wim.bl.IGWIM01BL;
import com.deliverik.infogovernor.wim.dto.IGWIM01DTO;
import com.deliverik.infogovernor.wim.form.IGWIM0101Form;

/**
 * @Description ���������Action
 * 
 * @date 2017��6��9��16:38:55
 * 
 * @author WangLiang
 *
 */
public class IGWIM0101Action extends BaseAction{
	
	static Log log = LogFactory.getLog(IGWIM0101Action.class);

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		//Formȡ��
		IGWIM0101Form form = (IGWIM0101Form) actionForm;
		//BLȡ��
		IGWIM01BL ctlBL  = (IGWIM01BL) getBean("igwim01BL");
		//DTO����
		IGWIM01DTO dto = new IGWIM01DTO();
		//��ȡ��¼�û�
		User user = (User) request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		//��½�û�����
		dto.setUser(user);
		
		if("DISP".equals(mapping.getParameter())){
			log.info("==========�����������ҳ��Action��ʼ����ʼ==========");
			log.info("==========�����������ҳ��Action��ʼ������==========");
		}
		
		return mapping.findForward("DISP");
	}

}
