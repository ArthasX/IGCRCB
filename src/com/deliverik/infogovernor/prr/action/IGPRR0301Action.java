/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prr.action;

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
import com.deliverik.infogovernor.prr.bl.IGPRR03BL;
import com.deliverik.infogovernor.prr.dto.IGPRR03DTO;
import com.deliverik.infogovernor.prr.form.IGPRR0301Form;
import com.deliverik.infogovernor.prr.vo.IGPRR03011VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �Զ�������OAģʽ��Ӧ��ɫȫ������Action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGPRR0301Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��־����ȡ��
		Log log = LogFactory.getLog(IGPRR0301Action.class);
		//blȡ��
		IGPRR03BL ctlBL = (IGPRR03BL) getBean("igprr03BL");
		//dtoʵ����
		IGPRR03DTO dto = new IGPRR03DTO();
		//formȡ��
		IGPRR0301Form form = (IGPRR0301Form) actionForm;
		if("DISP".equals(mapping.getParameter())){
			log.debug("===========OA��ɫ����ҳ���ʼ��������ʼ===========");
			//��ѯ��ʷ������Ϣ
			dto = ctlBL.searchIG001InfoListAction(dto);
			//ʵ����vo
			IGPRR03011VO vo = new IGPRR03011VO();
			vo.setIg001List_A(dto.getIg001List_A());
			vo.setIg001List_B(dto.getIg001List_B());
			vo.setIg001List_C(dto.getIg001List_C());
			super.<IGPRR03011VO>setVO(request, vo);
			saveToken(request);
			log.debug("===========OA��ɫ����ҳ���ʼ����������===========");
		}
		if("DELETE".equals(mapping.getParameter())){
			log.debug("==========ɾ�����ý�ɫ��Ϣ��ʼ===========");
			if(isTokenValid(request,true)){
				dto.setIgprr0301Form(form);
				dto = ctlBL.deleteIG001Action(dto);
			}else{
				addMessage(request, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			log.debug("==========ɾ�����ý�ɫ��Ϣ����===========");
		}
		
		List<ActionMessage> messageList = dto.getMessageList();
		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}

}
