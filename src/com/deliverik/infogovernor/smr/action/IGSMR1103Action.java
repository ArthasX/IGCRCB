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
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.infogovernor.smr.bl.IGSMR11BL;
import com.deliverik.infogovernor.smr.dto.IGSMR11DTO;
import com.deliverik.infogovernor.smr.form.IGSMR1102Form;
import com.deliverik.infogovernor.smr.vo.IGSMR11021VO;
import com.ibm.icu.util.Calendar;

/**
 * ����:�����߰�
 * ���������������߰�
 * �����ˣ�����͢
 * ������¼�� 2013-08-08
 * �޸ļ�¼��
 */
public class IGSMR1103Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSMR1103Action.class);
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//FORMȡ��
		IGSMR1102Form form = (IGSMR1102Form)actionForm;
								
		//BLȡ��
		IGSMR11BL ctlBL = (IGSMR11BL) getBean("igSMR11BL");
								
		//DTO����
		IGSMR11DTO dto = new IGSMR11DTO();
						
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);		
		dto.setUser(user);						
		String forward = "DISP";
		if("DISP".equals(mapping.getParameter())){
			log.debug("========���ѯҳ����ʾ����ʼ========");
			//�õ���ǰ�꣬form�����Ϊ���򽫵�ǰ��Ž�form��
			if(form.getYear()==null){				
				form.setYear(IGStringUtils.getCurrentYear());
			}
			//�õ���ǰ�꣬form�����Ϊ���򽫵�ǰ��Ž�form��
			if(form.getMonth()==null){				
				form.setMonth(String.valueOf(Calendar.getInstance().get(Calendar.MONTH)+1));
			}
			dto.setIgSMR1102Form(form);
			//��ѯ��ǰ��¼����Ҫ������걨
			dto = ctlBL.seeFillInAction(dto);
			//ʵ����vo
			IGSMR11021VO vo = new IGSMR11021VO();
			vo.setMap_see(dto.getMap_see());
			super.<IGSMR11021VO>setVO(request, vo);
			saveToken(request);
			log.debug("========�������ѯҳ����ʾ�������========");

		}
		if("STOP".equals(mapping.getParameter())){
			if (isTokenValid(request, true)){
				//��form�Ž�dto��
				dto.setIgSMR1102Form(form);
				//��ֹ����
				dto = ctlBL.stopFillInAction(dto);
				forward = "STOP";
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
			dto.setIgSMR1102Form(form);
			//���ô�����
			dto = ctlBL.pressAction(dto);
			request.setAttribute("flag", "1");
			forward = "Insert";
			log.debug("========�߰칤��������� ========");
		}
		return mapping.findForward(forward);
	}

}
