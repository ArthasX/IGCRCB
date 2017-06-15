/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.mtp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.mtp.bl.IGMTP01BL;
import com.deliverik.infogovernor.mtp.bl.IGMTP01BLType;
import com.deliverik.infogovernor.mtp.dto.IGMTP01DTO;
import com.deliverik.infogovernor.mtp.form.IGMTP0101Form;
import com.deliverik.infogovernor.mtp.vo.IGMTP01011VO;

/**
 * 	<p>
 *	�ճ���ά����(�Զ��幤��)Action
 *	</p>
 *	<p>
 *	������¼:	��ʢ�	2010-12-9
 *	</p>
 */

public class IGMTP0109Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGMTP0109Action.class);

	/**
	 * �����߼�
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception  {
		
		//��ʼ��
		IGMTP0101Form form = (IGMTP0101Form)actionForm;
		IGMTP01BL ctrlBL = (IGMTP01BL) getBean("igmtp01BL");
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		IGMTP01DTO dto = new IGMTP01DTO();

		//������ά�ƻ��Ǽ�����Ϣ
		form.setQjcrtuser(user.getUserid());
		form.setQjcrtusername(user.getUsername());
		form.setQjimpluser(user.getUserid());
		form.setQjimplusername(user.getUsername());
		
		
		//ȡ�ò���
		String periodType = form.getPeriodType();
		//String CustomDate = form.getCustomDate();
		String exeHour = form.getQjhour();
		String exeMinute = form.getQjminute();
		String qjcrttime = form.getQjcrttime().trim();
		String qjendtime = "";
		String startDate = form.getQjcrttime().trim();
		
		if(!"once".equals(periodType)){
			qjendtime = form.getQjendtime().trim();
		}else{
			qjendtime = form.getQjcrttime().trim();
		}
		form.setQjendtime(qjendtime);
		//ȡ��ִ�����ڱ��ʽ
		String cronExpression =  ctrlBL.creatCronExp(periodType,exeHour,exeMinute,qjcrttime);
		form.setQjtricron(cronExpression);
		
		//ȡ��ִ�����ڱ��ʽ˵����Ϣ
		String periodInfo = ctrlBL.getPeriodInfo(periodType, exeHour, exeMinute,startDate);
		form.setQjperiodinfo(periodInfo);
		
		form.setWorkType(IGMTP01BLType.PROCESS_USERDEFINED_TYPE);
		dto.setIgmtp0101Form(form);
		//���������Ͳ��ǽ�ִ��һ��ʱ����ʼ������������Ҫ����Ϣ
//		if(!"once".equals(periodType)){
			//��ʼ������ҳ����Ҫ����Ϣ
			dto = ctrlBL.initIGMTP0104(dto,cronExpression);
			
			IGMTP01011VO vo = new IGMTP01011VO();
			vo.setStartDate(qjcrttime);
			vo.setEndDate(qjendtime);	
			vo.setDateList(dto.getDateList());
			
			form.setDotime(dto.getDateList().get(0)+" "+exeHour+":"+exeMinute);//2010/10/22 21:16
			
			//����ά�ƻ��Ǽ���Ϣ���浽session��
			request.getSession().setAttribute("IGMTP0101Form", form);
			saveToken(request);
			super.<IGMTP01011VO>setVO(request, vo);
			return mapping.findForward("DISP");
//		}else{
//			//����ά�ƻ��Ǽ���Ϣ���浽session��
//			form.setDotime(qjcrttime+" "+exeHour+":"+exeMinute);//2010/10/22 21:16
//			request.getSession().setAttribute("IGMTP0101Form", form);
//			saveToken(request);
//			return mapping.findForward("ONCE");
//		}
	}
	

}