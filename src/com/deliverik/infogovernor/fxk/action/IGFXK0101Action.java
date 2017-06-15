package com.deliverik.infogovernor.fxk.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.fxk.bl.IGFXK07BL;
import com.deliverik.infogovernor.fxk.dto.IGFXK07DTO;
import com.deliverik.infogovernor.fxk.form.IGFXK0700Form;
import com.deliverik.infogovernor.fxk.vo.IGFXK01011VO;

public class IGFXK0101Action extends BaseAction {

	/** ��־���� */
	private static Log log = LogFactory.getLog(IGFXK0101Action.class);
	// ��ȡBL�ӿ�ʵ��
	
	IGFXK07DTO dto=new IGFXK07DTO();
	
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionform,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		// ��תҳ��
		String forward = "DISP";
		
	    IGFXK07BL ctrlBL = (IGFXK07BL) getBean("igFXK07BL");
	    IGFXK0700Form form=(IGFXK0700Form) actionform;
	    
	    
	    User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
	    form.setUser(user);
	    dto.setIgfxk0700Form(form);
		
		/**����BL������ҳ���ݲ�ѯ*/
		dto = ctrlBL.getProcessRecords(dto);
		/**ҳ��VO��ʼ��*/
		IGFXK01011VO vo=new IGFXK01011VO();
		/**����ҳ�����ݣ����ռƻ��������嵥���������ģ���������*/
		vo.setPrList(dto.getPrList());
		vo.setQdList(dto.getQdList());
		vo.setQmList(dto.getQuestModfiy());
		vo.setPgList(dto.getRiskpg());
		vo.setVoList(dto.getVoList());
		
		req.getSession().setAttribute("prlistsize",dto.getPrlistsize());
	    req.setAttribute("qmlistsize", dto.getQmlistsize());
	    req.setAttribute("pglistsize", dto.getPglistsize());
	    req.setAttribute("qdlistsize", dto.getQdlistsize());
	    req.setAttribute("risklistsize", dto.getRisklistsize());
	    //������ҳ���л���������������tab��ѡ�񡰸���/ȫ������ˢ�º�Ӧ�û������ڷ�����������tab
	    req.setAttribute("flag", req.getParameter("flag"));
		form.setPrlistsize(dto.getPrlistsize());
		form.setPglistsize(dto.getPglistsize());
		form.setQdlistsize(dto.getQdlistsize());
		form.setQmlistsize(dto.getQmlistsize());
		form.setRiskCount(dto.getRiskCount());
		form.setCheckCount(dto.getCheckCount());
		form.setPgExcing(dto.getPgExcing());
		form.setPgYear(dto.getPgYear());
		form.setQdExcing(dto.getQdExcing());
		form.setQdYear(dto.getQdYear());
		super.setVO(req, vo);
		log.debug("========������ѯ��������========");
		return mapping.findForward(forward);
	}
}