/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.prm.action;

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
import com.deliverik.infogovernor.prm.bl.IGPRM01BL;
import com.deliverik.infogovernor.prm.dto.IGPRM01DTO;
import com.deliverik.infogovernor.prm.form.IGPRM0305Form;
import com.deliverik.infogovernor.prm.vo.IGPRM03051VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��������_ȱʡ����������ACTION
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGPRM0305Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGPRM0305Action.class);
	
	/**
	 * <p>
	 * Description: ȱʡ����������action
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
		IGPRM0305Form form = (IGPRM0305Form)actionForm;
		//��ȡBL�ӿ�ʵ��
		IGPRM01BL ctlBL = (IGPRM01BL) getBean("IGPRM01BL");
		//ʵ����DTO
		IGPRM01DTO dto = new IGPRM01DTO();
		dto.setIgprm0305Form(form);
		if ("DISP".equals(mapping.getParameter())){
			log.debug("========ȱʡ���������˲�ѯ��ʼ========");
			//����BL��ѯ
			dto = ctlBL.initApproveDispatcher(dto);
			//����VO
			IGPRM03051VO vo = new IGPRM03051VO();
			vo.setRoleList(dto.getApproveDispatcherRoleList());
			vo.setApproveDispatcherList(dto.getApproveDispatcherList());
			super.<IGPRM03051VO>setVO(request, vo);
			saveToken(request);
			log.debug("========ȱʡ���������˲�ѯ����========");
		}
		//ȱʡ����������
		if ("APPROVORS".equals(mapping.getParameter())){
			log.debug("========ȱʡ�������������ÿ�ʼ========");
			dto.setIgprm0305Form(form);
			//ɾ����ɫ
			if("0".equals(form.getMode())){
				if (isTokenValid(request, true)){
					//����BL����
					ctlBL.removeApproveDispatcher(dto);
				}else{
					addMessage(request, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
			}else{//��ӽ�ɫ
				if (isTokenValid(request, true)){
					//����BL����
					ctlBL.addApproveDispatcher(dto);
				}else{
					addMessage(request, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
			}
			log.debug("========ȱʡ������������������========");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}
	
}
