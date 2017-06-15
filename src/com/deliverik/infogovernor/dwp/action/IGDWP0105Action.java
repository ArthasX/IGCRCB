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
import com.deliverik.infogovernor.dwp.form.IGDWP0105Form;
import com.deliverik.infogovernor.dwp.util.IGDWPUtils;
import com.deliverik.infogovernor.dwp.vo.IGDWP01051VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ����������ϢAction
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGDWP0105Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��־����ȡ��
		Log log = LogFactory.getLog(IGDWP0105Action.class);
		//BLȡ��
		IGDWP01BL ctlBL = (IGDWP01BL) getBean("igdwp01BL");
		//ʵ����dto
		IGDWP01DTO dto = new IGDWP01DTO();
		//��¼�û�ȡ��
		User user = (User) request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		//Formȡ��
		IGDWP0105Form form = (IGDWP0105Form) actionForm;
		//dto�����趨
		dto.setUser(user);
		dto.setForm(actionForm);
		//ҳ���ʼ������
		if("DISP".equals(mapping.getParameter())){
			log.debug("==============����������Ϣҳ���ʼ��������ʼ=================");
			dto = ctlBL.initProcessDefinitionAction(dto);
			//ʵ����vo
			IGDWP01051VO vo = new IGDWP01051VO();
			vo.setPlan(dto.getPlan());
			vo.setProcessDefinition(dto.getProcessDefinition());
			vo.setLabelValueBeanList(dto.getLabelValueBeanList());
			vo.setPtdInfo(dto.getPtdInfo());
			vo.setProcessInfoList(dto.getProcessInfoList());
			vo.setProcessStatusDef(dto.getProcessStatusDef());
			super.setVO(request, vo);
			saveToken(request);
			log.debug("==============����������Ϣҳ���ʼ����������=================");
		}
		//�������̵Ǽǲ���
		if("INSERT".equals(mapping.getParameter())){
			log.debug("=============�������̵Ǽǲ�����ʼ===============");
			if (isTokenValid(request, true)){
				dto = ctlBL.craeteProcessAction(dto);
			}else{
				addMessage(request, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			log.debug("=============�������̵Ǽǲ�������===============");
			//�����Ҫ���ɣ�����������ҳ��
			if(IGDWPUtils.ASSIGN_FLAG_YES.equals(dto.getAssignFlag())){
				return new ActionForward("/IGDWP0106_Disp.do?planid=" + form.getId() + "&prid=" + dto.getProcess().getId(),true);
			}
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