/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.smr.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.smr.bl.IGSMR03BL;
import com.deliverik.infogovernor.smr.dto.IGSMR03DTO;
import com.deliverik.infogovernor.smr.vo.IGSMR03041VO;

/**
 * ����:������ʾ���� 
 * ����������������ʾ����
 * �����ˣ�����͢
 * ������¼�� 2013-08-14
 * �޸ļ�¼��
 */
public class IGSMR0304Action extends BaseAction {
	static Log log = LogFactory.getLog(IGSMR0304Action.class);
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {		
		//BLȡ��
		IGSMR03BL ctlBL = (IGSMR03BL) getBean("igSMR03BL");										
		//DTO����
		IGSMR03DTO dto = new IGSMR03DTO();								
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);		
		dto.setUser(user);						
		String forward = "DISP";
		if( "DISP".equals(mapping.getParameter())){
			dto = ctlBL.init0304Action(dto);
			//ʵ����vo
			IGSMR03041VO vo = new IGSMR03041VO();
			vo.setMap_more(dto.getMap_more());
			super.<IGSMR03041VO>setVO(request, vo);
		}
		return mapping.findForward(forward);
	}

}
