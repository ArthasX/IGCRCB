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
import com.deliverik.infogovernor.smr.form.IGSMR0702Form;
import com.deliverik.infogovernor.smr.vo.IGSMR07021VO;

/**
 * ����:�ҵ���������ڱ�����ѯ 
 * �����������ҵ���������ڱ�����ѯ 
 * �����ˣ�����
 * ������¼�� 2013-08-08
 * �޸ļ�¼��
 */
public class IGSMR0702Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSMR0702Action.class);
	
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//FORMȡ��
		IGSMR0702Form form = (IGSMR0702Form)actionForm;
				
		//BLȡ��
		IGSMR07BL ctlBL = (IGSMR07BL) getBean("igSMR07BL");
				
		//DTO����
		IGSMR07DTO dto = new IGSMR07DTO();
		
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);		
		dto.setUser(user);
		
		String forward = "DISP";
		if("DISP".equals(mapping.getParameter())){
			log.debug("========�����ڱ����ѯҳ����ʾ����ʼ========");
			//��ѯ��ǰ��¼����Ҫ����Ĳ����ڱ���
			dto = ctlBL.needMeManagerAction(dto);
			//ʵ����vo
			IGSMR07021VO vo = new IGSMR07021VO();
			vo.setMap_arq(dto.getMap_arq());
			super.<IGSMR07021VO>setVO(request, vo);
			log.debug("========�����ڱ����ѯҳ����ʾ�������========");
		}
		if("FIRSTSEARCH".equals(mapping.getParameter())){
			log.debug("========����������ѯҳ����ʾ����ʼ========");
			//��ѯ��ǰ��¼����Ҫ����Ĳ����ڱ���
			dto = ctlBL.reportExamineAction(dto);
			//ʵ����vo
			IGSMR07021VO vo = new IGSMR07021VO();
			vo.setMap_first(dto.getMap_first());
			super.<IGSMR07021VO>setVO(request, vo);
			forward = "FIRST";
			log.debug("========����������ѯҳ����ʾ�������========");
		}
		if("SECONDSEARCH".equals(mapping.getParameter())){
			log.debug("========�����ڱ���������ѯҳ����ʾ����ʼ========");
			//��ѯ��ǰ��¼����Ҫ����Ĳ����ڱ���
			dto = ctlBL.AnnualreportExamineAction(dto);
			//ʵ����vo
			IGSMR07021VO vo = new IGSMR07021VO();
			vo.setSecond_list(dto.getSecond_list());
			super.<IGSMR07021VO>setVO(request, vo);
			forward = "SECOND";
			log.debug("========�����ڱ���������ѯҳ����ʾ�������========");
		}
		return mapping.findForward(forward);
	}

}
