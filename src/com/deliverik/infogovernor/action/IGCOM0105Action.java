/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.bl.IGCOM01BL;
import com.deliverik.infogovernor.dto.IGCOM01DTO;

/**
 * ����: ��ҳ��ת����Action
 * ��������: ��ҳ��ת����Action
 * ������¼: 2012/07/18
 * �޸ļ�¼: 
 */
public class IGCOM0105Action extends BaseAction {
	static Log log = LogFactory.getLog(IGCOM0105Action.class);

	/**
	 * ��ҳ��ת����Action
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
		log.debug("========��ҳ��ת����ʼ========");
		//������ҳ����
		setSessionAttribute(req, "firstactid", "00");
		setSessionAttribute(req, "secondactid", null);
		clearSessionFormData(req);
		IGCOM01BL ctrlBL = (IGCOM01BL) getBean("IGCOM01BL");
		IGCOM01DTO dto = new IGCOM01DTO();
		//��ת��ʶ,�ӵ�¼ҳ��ת����ҳindex��ֵ�������ҳ������תʱindex��ֵΪ���Ӧ��hpid
		String index = req.getParameter("index");
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		if(StringUtils.isEmpty(index)) {
			//�ӵ�¼ҳ��ת
			dto.setUser(user);
		} else {
			dto.setUsertype(index);
		}
		ctrlBL.initIGCOM0105Action(dto);
		if(StringUtils.isEmpty(index)) {
			setSessionAttribute(req, "UserPermission", dto.getUserPermission());
		} else {
			//���û��ɿ��������ҳʱ��ƥ����ҳ�����ӵ�light����ֵ���и�����ʾ
			if(!user.getUsertype().equals(index)) {
				req.setAttribute("light", index);
			}
		}
		/*if(dto.getUserPermission() == null || dto.getUserPermission().getActionSize() == 0){
			addMessage(req, new ActionMessage("IGCOM0101.E005","��û�з���Ȩ�ޣ�����ϵ����Ա��"));
			return mapping.findForward("NOROLE");
		}*/
		log.debug("========��ҳ��ת�������========");
		return new ActionForward(dto.getHomepage());
	}

}
