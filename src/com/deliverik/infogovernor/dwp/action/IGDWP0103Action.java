/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dwp.action;

import java.util.List;

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
import com.deliverik.infogovernor.dwp.bl.IGDWP01BL;
import com.deliverik.infogovernor.dwp.dto.IGDWP01DTO;
import com.deliverik.infogovernor.dwp.form.IGDWP0103Form;
import com.deliverik.infogovernor.dwp.util.IGDWPUtils;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �ճ�����������Action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGDWP0103Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��־����ȡ��
		Log log = LogFactory.getLog(IGDWP0103Action.class);
		//BLȡ��
		IGDWP01BL ctlBL = (IGDWP01BL) getBean("igdwp01BL");
		//ʵ����dto
		IGDWP01DTO dto = new IGDWP01DTO();
		//formȡ��
		IGDWP0103Form form = (IGDWP0103Form) actionForm;
		//��¼�û�ȡ��
		User user = (User) request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		//dto�����趨
		dto.setForm(actionForm);
		dto.setUser(user);
		//ҳ���ʼ������
		if("DISP".equals(mapping.getParameter())){
			log.debug("==============ҳ���ʼ��������ʼ===============");
			dto = ctlBL.initDayWorkPlanAction(dto);
			saveToken(request);
			log.debug("==============ҳ���ʼ����������===============");
		}
		//����Ǽǲ���
		if("INSERT".equals(mapping.getParameter())){
			log.debug("==============�ճ������ƻ��Ǽǲ�����ʼ================");
			if (isTokenValid(request, true)){
				if(form.getId() != null && form.getId() > 0){
					//����BL����
					dto = ctlBL.changeDayWorkPlanAction(dto);
				}else{
					//����BL����
					dto = ctlBL.insertDayWorkPlanAction(dto);
					/**
					 * 1�����̡���ָ�ɶ�����Ҫ���ɣ�����ת������Ҳ
					 * 2������Ǽǵ�������Ҫ��ת�����̷���ҳ
					 */
					if(form.getPmode().equals("1")){
					if(IGDWPUtils.ASSIGN_FLAG_YES.equals(dto.getAssignFlag())){
						return new ActionForward("/IGDWP0106_Disp.do?planid=" + form.getId(),true);
					}else{
						return new ActionForward("/IGDWP0105_Disp.do?id=" + form.getId(),true);
					}
					}
				}
			}else{
				addMessage(request, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			log.debug("==============�ճ������ƻ��Ǽǲ�������================");
		}
		//�߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}

}
