/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.smr.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.smr.bl.IGSMR03BL;
import com.deliverik.infogovernor.smr.dto.IGSMR03DTO;
import com.deliverik.infogovernor.smr.form.IGSMR0301Form;
import com.deliverik.infogovernor.smr.vo.IGSMR03011VO;

/**
 * ����:�ҵ�����걨����ѯ 
 * �����������ҵ�����걨����ѯ 
 * �����ˣ�����͢
 * ������¼�� 2013-07-25
 * �޸ļ�¼��
 */
public class IGSMR0301Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSMR0301Action.class);
	
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//FORMȡ��
		IGSMR0301Form form = (IGSMR0301Form)actionForm;
				
		//BLȡ��
		IGSMR03BL ctlBL = (IGSMR03BL) getBean("igSMR03BL");
				
		//DTO����
		IGSMR03DTO dto = new IGSMR03DTO();
		
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);		
		dto.setUser(user);
		
		String forward = "DISP";
		if("DISP".equals(mapping.getParameter())){
			log.debug("========�걨��ѯҳ����ʾ����ʼ========");
			//��ѯ��ǰ��¼����Ҫ������걨
			dto = ctlBL.needMeManagerAction(dto);
			//ʵ����vo
			IGSMR03011VO vo = new IGSMR03011VO();
			vo.setMap_arq(dto.getMap_arq());
			super.<IGSMR03011VO>setVO(request, vo);
			log.debug("========�걨��ѯҳ����ʾ�������========");
		}
		if("FIRSTSEARCH".equals(mapping.getParameter())){
			log.debug("========����������ѯҳ����ʾ����ʼ========");
			//��ѯ��ǰ��¼����Ҫ������걨
			dto = ctlBL.reportExamineAction(dto);
			//ʵ����vo
			IGSMR03011VO vo = new IGSMR03011VO();
			vo.setMap_first(dto.getMap_first());
			super.<IGSMR03011VO>setVO(request, vo);
			forward = "FIRST";
			log.debug("========����������ѯҳ����ʾ�������========");
		}
		if("SECONDSEARCH".equals(mapping.getParameter())){
			log.debug("========�걨������ѯҳ����ʾ����ʼ========");
			//��ѯ��ǰ��¼����Ҫ������걨
			dto = ctlBL.AnnualreportExamineAction(dto);
			//ʵ����vo
			IGSMR03011VO vo = new IGSMR03011VO();
			vo.setSecond_list(dto.getSecond_list());
			super.<IGSMR03011VO>setVO(request, vo);
			forward = "SECOND";
			log.debug("========�걨������ѯҳ����ʾ�������========");
		}
		return mapping.findForward(forward);
	}

}
