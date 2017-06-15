/*
 * ��������������������޹�˾��Ȩ����,��������Ȩ��.
 */

package com.deliverik.infogovernor.dut.action;

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
import com.deliverik.infogovernor.dut.bl.IGDUT02BL;
import com.deliverik.infogovernor.dut.dto.IGDUT02DTO;
import com.deliverik.infogovernor.dut.form.IGDUT0204Form;
import com.deliverik.infogovernor.dut.vo.IGDUT02041VO;

/**
 * ֵ�ཻ����ϸ����Action����
 *
 */
public class IGDUT0204Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDUT0204Action.class);

	/**
	 * �¼�����
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGDUT0204Form form = (IGDUT0204Form)actionForm;
		
		//BLȡ��
		IGDUT02BL ctlBL = (IGDUT02BL) getBean("igdut02BL");
		
		//DTO����
		IGDUT02DTO dto = new IGDUT02DTO();
		
		String forward = "null";
		
		if( "DISP".equals(mapping.getParameter())){
			//ֵ�ཻ����ϸ���������ʾ����
			log.debug("========ֵ�ཻ����ϸ���������ʾ����ʼ========");
			
			dto.setDutyPlanSearchCond(form);
			dto.setUser((User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER));
			dto.setIgDUT0204Form(form);
			//ֵ�ཻ����ϸ���������ʾ�߼�����
			dto = ctlBL.initIGDUT0204Action(dto);
			
			//��ֵ�ཻ����ϸ����趨��VO��
			IGDUT02041VO vo = new IGDUT02041VO();
			vo.setDutyResultList(dto.getDutyResultList());
			vo.setDutyPlan(dto.getDutyPlan());
			vo.setUsersinfo(dto.getUsersinfo());
			vo.setHasNullDrcontent(dto.getHasNullDrcontent());
			if(vo.getDutyPlan() != null) {
				form.setDpid_executing(vo.getDutyPlan().getDpid());//����ƻ�ID
			}
			super.<IGDUT02041VO>setVO(req.getSession(), vo);
			log.debug("========ֵ�ཻ����ϸ���������ʾ��������========");
			saveToken(req);
			forward = "DISP";
		} else if( "COMPLETE".equals(mapping.getParameter())){
			//ֵ�ཻ��ȷ�ϻ��������ʾ����
			forward = "DISP";
		}
		//�߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}
		
		return mapping.findForward(forward);
	}
}
