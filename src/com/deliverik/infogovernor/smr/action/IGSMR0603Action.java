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
import com.deliverik.infogovernor.smr.bl.IGSMR06BL;
import com.deliverik.infogovernor.smr.dto.IGSMR06DTO;
import com.deliverik.infogovernor.smr.form.IGSMR0602Form;
import com.deliverik.infogovernor.smr.vo.IGSMR06021VO;

/**
 * ����:�����߰�
 * ���������������߰�
 * �����ˣ�����͢
 * ������¼�� 2013-08-08
 * �޸ļ�¼��
 */
public class IGSMR0603Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSMR0603Action.class);
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//FORMȡ��
		IGSMR0602Form form = (IGSMR0602Form)actionForm;
								
		//BLȡ��
		IGSMR06BL ctlBL = (IGSMR06BL) getBean("igSMR06BL");
								
		//DTO����
		IGSMR06DTO dto = new IGSMR06DTO();
						
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);		
		dto.setUser(user);						
		String forward = "DISP";
		if("DISP".equals(mapping.getParameter())){
			log.debug("========���ѯҳ����ʾ����ʼ========");
			//�õ���ǰ���ȣ�form�м���Ϊ���򽫵�ǰ���ȷŽ�form��
			if(StringUtils.isEmpty(form.getQuarter())){
				if(IGStringUtils.getCurrentDate().substring(5, 7).equals("02")
						||IGStringUtils.getCurrentDate().substring(5, 7).equals("03")
						||IGStringUtils.getCurrentDate().substring(5, 7).equals("04")){
					form.setQuarter("1");
				}
				if(IGStringUtils.getCurrentDate().substring(5, 7).equals("05")
						||IGStringUtils.getCurrentDate().substring(5, 7).equals("06")
						||IGStringUtils.getCurrentDate().substring(5, 7).equals("07")){
					form.setQuarter("2");
				}
				if(IGStringUtils.getCurrentDate().substring(5, 7).equals("08")
						||IGStringUtils.getCurrentDate().substring(5, 7).equals("09")
						||IGStringUtils.getCurrentDate().substring(5, 7).equals("10")){
					form.setQuarter("3");
				}
				if(IGStringUtils.getCurrentDate().substring(5, 7).equals("11")
						||IGStringUtils.getCurrentDate().substring(5, 7).equals("12")
						||IGStringUtils.getCurrentDate().substring(5, 7).equals("01")){
					form.setQuarter("4");
				}
				
			}
			//�����ǰ��Ϊ�գ��򽫵�ǰ��Ž�form��
			if(StringUtils.isEmpty(form.getYear())){
				form.setYear(IGStringUtils.getCurrentYear());
			}
			//��form�Ž�dto��
			dto.setIgSMR0602Form(form);
			//��ѯ��ǰ��¼����Ҫ������걨
			dto = ctlBL.seeFillInAction(dto);
			//ʵ����vo
			IGSMR06021VO vo = new IGSMR06021VO();
			vo.setMap_see(dto.getMap_see());
			super.<IGSMR06021VO>setVO(request, vo);
			saveToken(request);
			log.debug("========�������ѯҳ����ʾ�������========");
		}
		if("STOP".equals(mapping.getParameter())){
			if (isTokenValid(request, true)){
				//��form�Ž�dto��
				dto.setIgSMR0602Form(form);
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
			dto.setIgSMR0602Form(form);
			//���ô�����
			dto = ctlBL.pressAction(dto);
			request.setAttribute("flag", "1");
			forward = "Insert";
			log.debug("========�߰칤��������� ========");
		}
		return mapping.findForward(forward);
	}

}
