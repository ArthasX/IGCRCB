/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.smr.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.infogovernor.smr.bl.IGSMR03BL;
import com.deliverik.infogovernor.smr.dto.IGSMR03DTO;
import com.deliverik.infogovernor.smr.form.IGSMR0301Form;
import com.deliverik.infogovernor.smr.form.IGSMR0302Form;
import com.deliverik.infogovernor.smr.vo.IGSMR03011VO;
import com.deliverik.infogovernor.smr.vo.IGSMR03021VO;

/**
 * ����:�ҵ�����걨����ѯ 
 * �����������ҵ�����걨����ѯ 
 * �����ˣ�����͢
 * ������¼�� 2013-07-25
 * �޸ļ�¼��
 */
public class IGSMR0302Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSMR0302Action.class);

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//FORMȡ��
		IGSMR0302Form form = (IGSMR0302Form)actionForm;
						
		//BLȡ��
		IGSMR03BL ctlBL = (IGSMR03BL) getBean("igSMR03BL");
						
		//DTO����
		IGSMR03DTO dto = new IGSMR03DTO();
				
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);		
		dto.setUser(user);
				
		String forward = "DISP";
		if("DISP".equals(mapping.getParameter())){
			log.debug("========���ѯҳ����ʾ����ʼ========");
			//�õ���ǰ�꣬form�����Ϊ���򽫵�ǰ��Ž�form��
			if(form.getYear()==null){				
				form.setYear(IGStringUtils.getCurrentYear());
			}
			//��form�Ž�dto��
			dto.setIgSMR0302Form(form);
			//��ѯ��ǰ��¼����Ҫ������걨
			dto = ctlBL.seeFillInAction(dto);
			//ʵ����vo
			IGSMR03021VO vo = new IGSMR03021VO();
			vo.setMap_see(dto.getMap_see());
			super.<IGSMR03021VO>setVO(request, vo);
			saveToken(request);
			log.debug("========�������ѯҳ����ʾ�������========");
		}
		if("STOP".equals(mapping.getParameter())){
			if (isTokenValid(request, true)){
				//��form�Ž�dto��
				dto.setIgSMR0302Form(form);
				//��ֹ����
				dto = ctlBL.stopFillInAction(dto);
				if(StringUtils.isNotEmpty(request.getParameter("type"))){
					forward ="STOP1";
				}else{
					forward = "STOP";
				}
			}else{
				addMessage(request, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}			
		}
		if("Modal".equals(mapping.getParameter())){
			log.debug("========ģ̬ҳ��ʾ����ʼ ========");
			//��form�е�prid���·Ž�form��
			form.setPrid(form.getPrid());
			log.debug("========ģ̬ҳ��ʾ�������========");
			forward = "Modal";
		}
		if("Message".equals(mapping.getParameter())){
			log.debug("========ģ̬ҳ��ʾ����ʼ ========");
			//��form�е�prid���·Ž�form��
			form.setPrid(form.getPrid());
			log.debug("========ģ̬ҳ��ʾ�������========");
			forward = "Message";
		}
		if("Insert".equals(mapping.getParameter())){
			log.debug("========�߰칤������ʼ ========");
			//��form�Ž�dto��
			dto.setIgSMR0302Form(form);
			//���ô�����
			dto = ctlBL.pressAction(dto);
			request.setAttribute("flag", "1");
			forward = "Insert";
			log.debug("========�߰칤��������� ========");
		}
		return mapping.findForward(forward);
	}

}
