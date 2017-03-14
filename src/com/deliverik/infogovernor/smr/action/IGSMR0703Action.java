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
import com.deliverik.infogovernor.smr.bl.IGSMR07BL;
import com.deliverik.infogovernor.smr.dto.IGSMR07DTO;
import com.deliverik.infogovernor.smr.form.IGSMR0703Form;
import com.deliverik.infogovernor.smr.vo.IGSMR07031VO;

/**
 * ����:�ҵ���������ڣ���ѯ 
 * �����������ҵ�����걨����ѯ 
 * �����ˣ�����
 * ������¼�� 2013-08-08
 * �޸ļ�¼��
 */
public class IGSMR0703Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSMR0703Action.class);

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//FORMȡ��
		IGSMR0703Form form = (IGSMR0703Form)actionForm;
						
		//BLȡ��
		IGSMR07BL ctlBL = (IGSMR07BL) getBean("igSMR07BL");
						
		//DTO����
		IGSMR07DTO dto = new IGSMR07DTO();
				
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);		
		dto.setUser(user);
				
		String forward = "DISP";
		if("DISP".equals(mapping.getParameter())){
			log.debug("========���ѯҳ����ʾ����ʼ========");
			//��form�Ž�dto��
			dto.setIGSMR0703Form(form);
			//��ѯ��ǰ��¼����Ҫ������걨
			dto = ctlBL.seeFillInAction(dto);
			//ʵ����vo
			IGSMR07031VO vo = new IGSMR07031VO();
			vo.setMap_see(dto.getMap_see());
			super.<IGSMR07031VO>setVO(request, vo);
			saveToken(request);
			log.debug("========�������ѯҳ����ʾ�������========");
		}
		return mapping.findForward(forward);
	}

}
