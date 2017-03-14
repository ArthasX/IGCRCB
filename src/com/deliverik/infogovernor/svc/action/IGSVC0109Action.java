/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.svc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.security.UserPermission;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.prm.bl.IGPRM00BL;
import com.deliverik.infogovernor.prm.dto.IGPRM00DTO;
import com.deliverik.infogovernor.prm.vo.IGPRM00001VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̹���_����̨_��ѯACTION
 * </p>
 * 
 * @author sunkaiyu@deliverik.com
 * @version 1.0
 */

public class IGSVC0109Action extends BaseAction {

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		UserPermission perm = (UserPermission)req.getSession().getAttribute("UserPermission");
		//��ȡBL�ӿ�ʵ��
		IGPRM00BL ctlBL = (IGPRM00BL) getBean("igprm00BL");
		IGPRM00001VO vo = new IGPRM00001VO();
		IGPRM00DTO dto = new IGPRM00DTO();
		dto = ctlBL.searchProcessDefinition(user,perm,dto);
		vo.setTemplateDefinitionMap(dto.getTemplateDefinitionMap());

		super.<IGPRM00001VO>setVO(req, vo);
		
		return mapping.findForward("DISP");
	}
}
