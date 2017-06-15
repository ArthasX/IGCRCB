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
import com.deliverik.infogovernor.smr.bl.IGSMR06BL;
import com.deliverik.infogovernor.smr.dto.IGSMR06DTO;
import com.deliverik.infogovernor.smr.form.IGSMR0601Form;
import com.deliverik.infogovernor.smr.vo.IGSMR03011VO;
import com.deliverik.infogovernor.smr.vo.IGSMR06011VO;

/**
 * ����:�������������ѯ
 * �����������������������ѯ
 * �����ˣ�����͢
 * ������¼�� 2013-08-08
 * �޸ļ�¼��
 */
public class IGSMR0602Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSMR0602Action.class);
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//FORMȡ��
		IGSMR0601Form form = (IGSMR0601Form)actionForm;
						
		//BLȡ��
		IGSMR06BL ctlBL = (IGSMR06BL) getBean("igSMR06BL");
						
		//DTO����
		IGSMR06DTO dto = new IGSMR06DTO();
				
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);		
		dto.setUser(user);
				
		String forward = "DISP";
		if("DISP".equals(mapping.getParameter())){
			log.debug("========��������ѯҳ����ʾ����ʼ========");
			//��ѯ��ǰ��¼����Ҫ������걨
			dto = ctlBL.needMeManagerAction(dto);
			//ʵ����vo
			IGSMR06011VO vo = new IGSMR06011VO();
			vo.setMap_arq(dto.getMap_arq());
			super.<IGSMR06011VO>setVO(request, vo);
			log.debug("========������ѯҳ����ʾ�������========");
		}
		if("FIRSTSEARCH".equals(mapping.getParameter())){
			log.debug("========����������ѯҳ����ʾ����ʼ========");
			//��ѯ��ǰ��¼����Ҫ������걨
			dto = ctlBL.reportExamineAction(dto);
			//ʵ����vo
			IGSMR06011VO vo = new IGSMR06011VO();
			vo.setMap_first(dto.getMap_first());
			super.<IGSMR06011VO>setVO(request, vo);
			forward = "FIRST";
			log.debug("========����������ѯҳ����ʾ�������========");
		}
		if("SECONDSEARCH".equals(mapping.getParameter())){
			log.debug("========�걨������ѯҳ����ʾ����ʼ========");
			//��ѯ��ǰ��¼����Ҫ������걨
			dto = ctlBL.AnnualreportExamineAction(dto);
			//ʵ����vo
			IGSMR06011VO vo = new IGSMR06011VO();
			vo.setSecond_list(dto.getSecond_list());
			super.<IGSMR06011VO>setVO(request, vo);
			forward = "SECOND";
			log.debug("========�걨������ѯҳ����ʾ�������========");
		}
		return mapping.findForward(forward);
	}

}
