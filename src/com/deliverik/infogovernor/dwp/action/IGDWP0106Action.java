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
import com.deliverik.infogovernor.dwp.vo.IGDWP01061VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �ճ������ƻ�����ҳ��Action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGDWP0106Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��־����ȡ��
		Log log = LogFactory.getLog(IGDWP0106Action.class);
		//BLȡ��
		IGDWP01BL ctlBL = (IGDWP01BL) getBean("igdwp01BL");
		//ʵ����dto
		IGDWP01DTO dto = new IGDWP01DTO();
		//��¼�û�
		User user = (User) request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		//dto�����趨
		dto.setUser(user);
		dto.setForm(actionForm);
		//ҳ���ʼ������
		if("DISP".equals(mapping.getParameter())){
			log.debug("============�ճ������ƻ�����ҳ���ʼ��������ʼ============");
			dto = ctlBL.initDayWorkPlanAssignAction(dto);
			//ʵ����vo
			IGDWP01061VO vo = new IGDWP01061VO();
			vo.setAssignInfoMap(dto.getAssignInfoMap());
			super.setVO(request, vo);
			saveToken(request);
			log.debug("============�ճ������ƻ�����ҳ���ʼ����������============");
		}
		//���ɲ���
		if("ASSIGN".equals(mapping.getParameter())){
			log.debug("==============�ճ������ƻ����ɲ�����ʼ================");
			if (isTokenValid(request, true)){
				dto = ctlBL.saveAssignAction(dto);
			}else{
				addMessage(request, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			log.debug("==============�ճ������ƻ����ɲ�������================");
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