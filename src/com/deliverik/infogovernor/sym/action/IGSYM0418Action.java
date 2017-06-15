/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sym.action;

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
import com.deliverik.infogovernor.sym.bl.IGSYM04BL;
import com.deliverik.infogovernor.sym.dto.IGSYM04DTO;
import com.deliverik.infogovernor.sym.form.IGSYM0418Form;
import com.deliverik.infogovernor.sym.vo.IGSYM04181VO;

/**
 * @Description:  ���ݽ�ɫ���Ͳ�ѯ�û�Action
 * @Author  masai
 * @History 2010-6-22     �½� 
 * @Version V2.0
 */
 
public class IGSYM0418Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSYM0418Action.class);
	
	/**
	 * <p>
	 * Description: ���ݽ�ɫ���Ͳ�ѯ�û�action����
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		//ʵ����FORM
		IGSYM0418Form form = (IGSYM0418Form)actionForm;
		//��ȡBL�ӿ�ʵ��
		IGSYM04BL ctlBL = (IGSYM04BL)getBean("igsym04BL");
		//ʵ����DTO
		IGSYM04DTO dto = new IGSYM04DTO();

		if( "DISP".equals(mapping.getParameter())){
			
			log.debug("========��ɫ�����˲�ѯ���������ʾ����ʼ========");
			
			addMessage(request, new ActionMessage("IGCO10000.I003"));

			dto.setUserRoleVWSearchCond(form);
			dto.setRoleid(form.getRoleid());
			dto.setUserInfoSearchCond(form);

			//����BL��ѯ
			dto = ctlBL.searchUserByRoleTypeNoPage(dto);
			//����VO
			IGSYM04181VO vo = new IGSYM04181VO(dto.getUserInfoList() , dto.getRole());	
			
			super.<IGSYM04181VO>setVO(request, vo);
			
			log.debug("========��ɫ�����˲�ѯ���������ʾ��������========");
			
		} else if ("DELETE".equals(mapping.getParameter())) {

			log.debug("========���ݽ�ɫ����ɾ���û���ʼ========");
			
			dto.setRoleid(form.getRoleid());
			dto.setUrid(form.getUrids());
			
			//����BL��ѯ
			ctlBL.deleteRoleUser(dto);

			log.debug("========���ݽ�ɫ����ɾ���û�����========");
			
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
