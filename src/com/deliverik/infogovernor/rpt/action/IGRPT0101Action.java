package com.deliverik.infogovernor.rpt.action;

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
import com.deliverik.infogovernor.rpt.bl.IGRPT01BL;
import com.deliverik.infogovernor.rpt.dto.IGRPT01DTO;
import com.deliverik.infogovernor.rpt.vo.IGRPT01011VO;

/**
 * ͳ�Ʒ���������Action����
 *
 */
public class IGRPT0101Action extends BaseAction {

	static Log log = LogFactory.getLog(IGRPT0101Action.class);
	
	
	
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
		IGRPT01BL ctlBL = (IGRPT01BL) getBean("igRPT01BL");
		
		//DTO����
		IGRPT01DTO dto = new IGRPT01DTO();
		
		//��ȡUser��Ϣ
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		
		dto.setUser(user);
		
		//�����������ѯ����
		dto = ctlBL.filterReportTypeTreeAction(dto);
		
		IGRPT01011VO vo = new IGRPT01011VO(dto.getTreeNodeMap());
		
		
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
		
		super.<IGRPT01011VO>setVO(req, vo);
		
		return mapping.findForward("DISP");
		
	}

}
