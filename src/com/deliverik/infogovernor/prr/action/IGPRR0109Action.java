/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
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
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.prr.bl.IGPRR01BL;
import com.deliverik.infogovernor.prr.dto.IGPRR01DTO;
import com.deliverik.infogovernor.prr.form.IGPRR0109Form;
import com.deliverik.infogovernor.prr.vo.IGPRR01091VO;

/**
 * @Description: ����OAִ����Action
 * @Author  
 * @History 2010-9-13     �½� 
 * @Version V1.0
 */
public class IGPRR0109Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGPRR0109Action.class);
	
	/**
	 * <p>
	 * Description: ִ���˴���action
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
		IGPRR0109Form form = (IGPRR0109Form)actionForm;
		//��ȡBL�ӿ�ʵ��
		IGPRR01BL ctlBL = (IGPRR01BL) getBean("igPRR01BL");
		//ʵ����DTO
		IGPRR01DTO dto = new IGPRR01DTO();
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setPrid(form.getPrid());
		dto.setUser(user);
		dto.setIgPRR0109Form(form);
		if ("DISP".equals(mapping.getParameter())){
			log.debug("========ִ���˲�ѯ����ʼ========");
			
			//����BL��ѯ
			dto = ctlBL.searchAssignOAPersonAction(dto);
			//����VO
			IGPRR01091VO vo = new IGPRR01091VO(dto.getUserInfoList());
			super.<IGPRR01091VO>setVO(request, vo);
			saveToken(request);
			log.debug("========ִ���˲�ѯ��������========");
		}
		//ִ����
		if ("MANAGER".equals(mapping.getParameter())){
			log.debug("========ִ���˴���ʼ========");
			dto.setIgPRR0109Form(form);
			
			if (isTokenValid(request, true)){
				dto = ctlBL.assignOAPersonAction(dto);
			}else{
				addMessage(request, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			
			request.setAttribute("prserialnum", dto.getProcess().getPrserialnum());// ������
			request.setAttribute("prid",dto.getProcess().getPrid());
			request.setAttribute("pts",dto.getProcess().getPrtype());
			log.debug("========ִ���˴�������========");
			//====>
			ActionForward actionForward = new ActionForward();
			actionForward.setPath("/IGPRR0102_Disp.do?prtype=WD&prid=" + dto.getProcess().getPrid());
			return actionForward;
			//====>
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
