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
import com.deliverik.framework.security.UserPermission;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.bl.IGCOM02BL;
import com.deliverik.infogovernor.dto.IGCOM02DTO;
import com.deliverik.infogovernor.vo.IGCOM02111VO;

/**
 * ͳ�Ʒ���������Action����
 *
 */
public class IGCOM0211Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCOM0211Action.class);
	
	/**
	 * ͳ�Ʒ���������Action����
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

		//Session���
		clearSessionFormData(req);
		
		//BLȡ��
		IGCOM02BL ctlBL = (IGCOM02BL) getBean("igcom02BL");
		
		//DTO����
		IGCOM02DTO dto = new IGCOM02DTO();
		
		//��ȡUser��Ϣ
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		
		dto.setUser(user);
		
		//�����������ѯ����
		dto = ctlBL.filterReportTypeTreeAction(dto);
		
		IGCOM02111VO vo = new IGCOM02111VO(dto.getTreeNodeMap());
		
		
		String actname = req.getParameter("actname");
		UserPermission perm = (UserPermission)req.getSession().getAttribute("UserPermission");
		//���ø����˵�
		if(StringUtils.isNotEmpty(actname)&& perm != null) {
			String actsortid = perm.getActsortid(actname);//��ȡָ���˵�ID��ACTSORTID
			if(StringUtils.isNotEmpty(actsortid)){
				if(actsortid.length() == 2) {//���һ���˵�ʱ����ն����˵�session����
					setSessionAttribute(req, "firstactid", actsortid);
					setSessionAttribute(req, "secondactid", null);
				} else {//������������˵�
						setSessionAttribute(req, "firstactid", actsortid.substring(0, 2));
						setSessionAttribute(req, "secondactid", actsortid.substring(0, 4));
				}
			}
		}
		
		super.<IGCOM02111VO>setVO(req, vo);
		
		return mapping.findForward("DISP");
		
	}

}
