/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.sym.bl.IGSYM19BL;
import com.deliverik.infogovernor.sym.dto.IGSYM19DTO;

/**
 * @Description: �쵼��¼����Action����
 * @Author  ZhaoJun
 * @History 2010-6-8 �½�
 * @Version V2.0
 * �޸�ʱ�䣺LuJiayuan 2013/01/31 Ǩ��SOC��������
 */
public class IGPOR0101Action extends BaseAction {

	static Log log = LogFactory.getLog(IGPOR0101Action.class);

	/**
	 * 
	 * 
	 * @param mapping
	 * @param actionForm
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		IGSYM19BL igsym19BL=(IGSYM19BL) getBean("igsym19BL");
		IGSYM19DTO dto=new IGSYM19DTO();
		User user = (User) request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setUserId(user.getUserid());
		dto = igsym19BL.searchProcessWorkTimeCount(dto);
		Integer processWorkTimeCount = dto.getProcessWorkTimeCount();
		request.setAttribute("processWorkTimeCount", processWorkTimeCount);
		return mapping.findForward("SUCCESS");
	}
}