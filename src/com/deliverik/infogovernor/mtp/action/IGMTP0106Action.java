/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
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
import com.deliverik.infogovernor.mtp.bl.IGMTP01BL;
import com.deliverik.infogovernor.mtp.dto.IGMTP01DTO;
import com.deliverik.infogovernor.mtp.form.IGMTP0106Form;
import com.deliverik.infogovernor.mtp.vo.IGMTP01061VO;

/**
 *	�ճ���ά�����޸Ĺ���Action
 */

public class IGMTP0106Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGMTP0106Action.class);

	/**
	 * �����߼�
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//��ʼ��
		IGMTP0106Form form = (IGMTP0106Form)actionForm;
		IGMTP01BL ctrlBL = (IGMTP01BL) getBean("igmtp01BL");
		IGMTP01DTO dto = new IGMTP01DTO();
	
		//ȡ�ò���
		String periodType = form.getPeriodType();
		String exeHour = form.getQjhour();
		String exeMinute = form.getQjminute();
		String qjcrttime = form.getQjcrttime().trim();
		String qjendtime = form.getQjendtime().trim();
		String startDate = form.getQjcrttime().trim();
		
		//ȡ��ִ�����ڱ��ʽ
		String cronExpression =  ctrlBL.creatCronExp(periodType,exeHour,exeMinute,qjcrttime);
		form.setQjtricron(cronExpression);
		
		//ȡ��ִ�����ڱ��ʽ˵����Ϣ
		String periodInfo = ctrlBL.getPeriodInfo(periodType, exeHour, exeMinute,startDate);
		form.setQjperiodinfo(periodInfo);
		
		dto.setIgmtp0106Form(form);
		//������ά�ƻ�����ID
		dto.setQjid(form.getQjid());
		
		//��ʼ�������޸�ҳ����Ҫ����Ϣ
		dto = ctrlBL.initIGMTP0107(dto,cronExpression);
		
		IGMTP01061VO vo = new IGMTP01061VO();
		vo.setStartDate(qjcrttime);
		vo.setEndDate(qjendtime);
		vo.setDateList(dto.getDateList());
		
		form.setDotime(dto.getDateList().get(0)+" "+exeHour+":"+exeMinute);//2010/10/22 21:16
		
		//����ά�ƻ��Ǽ���Ϣ���浽session��
		request.getSession().setAttribute("IGMTP0106Form", form);
		saveToken(request);
		super.<IGMTP01061VO>setVO(request, vo);
		return mapping.findForward("DISP");

	}
	
	

}