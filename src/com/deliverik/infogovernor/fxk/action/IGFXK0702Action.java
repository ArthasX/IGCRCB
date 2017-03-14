/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.fxk.action;

import java.util.Date;

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
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.infogovernor.fxk.bl.IGFXK07BL;
import com.deliverik.infogovernor.fxk.dto.IGFXK07DTO;
import com.deliverik.infogovernor.fxk.form.IGFXK0700Form;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���չ���_������ʾ����_ACTION
 * </p>
 * 
 * @author zhangq@deliverik.com
 * @version 1.0
 */

public class IGFXK0702Action extends BaseAction {

	/** ��־���� */
	private static Log log = LogFactory.getLog(IGFXK0701Action.class);

	/** ҳ����ת�����趨 */
	private final String forward = "DISP";

	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse res) throws Exception {
		log.debug("=======================������ʾ����ʼ=======================");
		IGFXK0700Form form = (IGFXK0700Form) actionForm;

		/** dto */
		IGFXK07DTO dto = new IGFXK07DTO();
		
		dto.setForm(form);
		dto.setAttachFile(form);
		// ��ȡBL�ӿ�ʵ��
		IGFXK07BL ctrlBL = (IGFXK07BL) getBean("igFXK07BL");
		
		// ��ʼ��ҳ��
		if ("DISP".equals(mapping.getParameter())) {

			User user = (User) request.getSession().getAttribute(
					SESSION_KEY_LOGIN_USER);
			form.setNuserid(user.getUserid());
			form.setNusername(user.getUsername());
			form.setNorgid(user.getOrgid());
			form.setNorgname(user.getOrgname());
			form.setNtime(CommonDefineUtils.DATE_FORMAT.format(new Date()));
			form.setNtel(user.getUsermobile());
			log.debug("========֪ͨ�������������ʾ����ʼ========");
			addMessage(request, new ActionMessage("IGCO10000.I001", "������ʾ������Ϣ"));
			saveToken(request);
			log.debug("========֪ͨ�������������ʾ��������========");
		} else if ("INSERT".equals(mapping.getParameter())) {

			if (isTokenValid(request, true)) {
				/** ����BL�������ʾ */
				ctrlBL.addRiskmanagerwaring(dto);
				log.debug("=======ǩ�������ѯ�������========");
			} else {
				addMessage(request, new ActionMessage("IGCO00000.E007"));

			}
		}

		return mapping.findForward(forward);
	}
}
