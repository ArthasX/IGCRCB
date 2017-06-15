/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.rpt.action;

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
import com.deliverik.infogovernor.rpt.bl.IGRPT02BL;
import com.deliverik.infogovernor.rpt.dto.IGRPT02DTO;
import com.deliverik.infogovernor.rpt.vo.IGRPT02001VO;

/**
 * ����: ͳ�Ʒ�����ҳAction
 * ��������: ��ҳ(igcom0218)����ʾ,�Զ��屨��Ĳ�ѯ��ʾ
 * ������¼: 2012-7-20
 * �޸ļ�¼: 
 */
public class IGRPT0200Action extends BaseAction{
	static Log log = LogFactory.getLog(IGRPT0200Action.class);
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//ȡ�ÿ���BL
		IGRPT02BL ctlBL =(IGRPT02BL)getBean("IGRPT02BL");
		//dto
		IGRPT02DTO dto=new IGRPT02DTO();
		User u=(User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setCurUser(u);
		
		 //��ȡ�˵�Ȩ��
		UserPermission perm = (UserPermission)req.getSession().getAttribute("UserPermission");
		//���ø����˵�
		if(perm != null) {
			String actsortid = perm.getActsortid("ACT05STA02");//��ȡָ���˵�ID��ACTSORTID
			if(StringUtils.isNotEmpty(actsortid)){
				setSessionAttribute(req, "firstactid", actsortid.substring(0, 2));
				setSessionAttribute(req, "secondactid", actsortid.substring(0, 4));
			}
		}
		if("DISP".equals(mapping.getParameter())){
			log.debug("========ͳ�Ʒ�����ҳ��ʾ��ʼ========");
			ctlBL.searchSOC0204Action(dto);
			IGRPT02001VO vo=new IGRPT02001VO();
			vo.setReportCustomLinkList_Pref(dto.getReportCustomLinkList_Pref());//ȡ������list
			vo.setReportCustomLinkList_Cap(dto.getReportCustomLinkList_Cap());//ȡ������list
			super.<IGRPT02001VO>setVO(req, vo);
			log.debug("========ͳ�Ʒ�����ҳ��ʾ����========");
		}
		
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
		}
		
		return mapping.findForward("DISP");
	}
	
}
