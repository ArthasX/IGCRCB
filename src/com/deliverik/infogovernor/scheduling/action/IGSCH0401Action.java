/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.scheduling.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.Role;
import com.deliverik.infogovernor.scheduling.bl.IGSCH04BL;
import com.deliverik.infogovernor.scheduling.dto.IGSCH04DTO;
import com.deliverik.infogovernor.scheduling.form.IGSCH0401Form;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������_�������_�¼��ලAction
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSCH0401Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSCH0401Action.class);
	
	/**
	 * <p>
	 * Description: �¼��ල����
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @author liupeng@deliverik.com
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//ʵ����FORM
		IGSCH0401Form form = (IGSCH0401Form)actionForm;
		//��ȡBL�ӿ�ʵ��
		IGSCH04BL ctlBL = (IGSCH04BL) getBean("igSCH04BL");
		//ʵ����DTO
		IGSCH04DTO dto = new IGSCH04DTO();
		dto = ctlBL.searchRoleAction(dto);
		List<Role> list = dto.getRoleList();
		List<LabelValueBean> roleList = new ArrayList<LabelValueBean>();
		roleList.add(new LabelValueBean("", ""));
		for(Iterator<Role> iter = list.iterator();iter.hasNext();){
			Role role = iter.next();
			roleList.add(new LabelValueBean(role.getRolename(), role.getRoleid().toString()));
		}
		request.setAttribute("roleList", roleList);		
//		String[] min = new String[]{"-1","5","10","15","20","25","30","60","120"};
//		List<LabelValueBean> minList = new ArrayList<LabelValueBean>();
//		for(String i :min){
//			if(i.equals("-1")){
//				minList.add(new LabelValueBean("�ر�",i));
//			}else{
//				minList.add(new LabelValueBean(i+"����",i));
//			}
//		}
//		request.setAttribute("minList", minList);		
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========�¼��ල���������ʾ����ʼ========");
			dto.setIgsch0401Form(form);
			dto = ctlBL.searchQuartzJobsAction(dto);
			log.debug("========�¼��ල���������ʾ��������========");
			return mapping.findForward("DISP");
		}	
		if( "SAVE".equals(mapping.getParameter())){
			log.debug("========�¼��ල����ʼ========");
			dto.setIgsch0401Form(form);
			String forward = "DISP";
			if (request.getParameter("btn_remove")!=null) {
				dto = ctlBL.removeQuartzJobsAction(dto);
				forward = "DELETE_DISP";
			} else if (request.getParameter("btn_delete")!=null) {
				dto = ctlBL.deleteQuartzJobsAction(dto);
				forward = "DELETE_DISP";
			}else{
				dto = ctlBL.saveQuartzJobsAction(dto);
			}
			List<ActionMessage> messageList = dto.getMessageList();
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(request, message);
				}
			}
			log.debug("========�¼��ල��������========");
			return mapping.findForward(forward);
		}
		return mapping.findForward("DISP");
	}

}
