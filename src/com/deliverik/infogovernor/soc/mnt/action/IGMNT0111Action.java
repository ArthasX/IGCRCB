package com.deliverik.infogovernor.soc.mnt.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.security.UserPermission;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.soc.mnt.bl.IGMNT01BL;
import com.deliverik.infogovernor.soc.mnt.dto.IGMNT01DTO;
import com.deliverik.infogovernor.soc.mnt.vo.IGMNT01071VO;

/**
 * DEBUG��ض���Action����
 *
 */
public class IGMNT0111Action extends BaseAction {

	static Log log = LogFactory.getLog(IGMNT0111Action.class);

	/**
	 * 
	 * ����
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		 //��ȡ�˵�Ȩ��
		UserPermission perm = (UserPermission)req.getSession().getAttribute("UserPermission");
		//���ø����˵�
		if(perm != null) {
			String actsortid = perm.getActsortid("ACT17KGM02");//��ȡָ���˵�ID��ACTSORTID
			if(StringUtils.isNotEmpty(actsortid)){
				setSessionAttribute(req, "firstactid", actsortid.substring(0, 2));
				setSessionAttribute(req, "secondactid", actsortid.substring(0, 4));
			}
		}
		//BLȡ��
		IGMNT01BL ctlBL = (IGMNT01BL) getBean("igmnt01BL");
		//DTO����
		IGMNT01DTO dto = new IGMNT01DTO();
		User user = (User) req.getSession().getAttribute(
				SESSION_KEY_LOGIN_USER);
		dto.setUser(user);
		if("DISP".equals(mapping.getParameter())){
			//��form����dto��
			//��ʼ����ѯ
			ctlBL.searchDebugTaskInitAction(dto);
			saveToken(req);
		}
		IGMNT01071VO igmnt01071vo=new IGMNT01071VO();
		//����vo
		igmnt01071vo.setSoc0304List(dto.getSoc0304List());
		igmnt01071vo.setUserId(user.getUserid());
		//����vo
		super.<IGMNT01071VO>setVO(req, igmnt01071vo);
		//�߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
		}
		return mapping.findForward("DISP");
	}
}
