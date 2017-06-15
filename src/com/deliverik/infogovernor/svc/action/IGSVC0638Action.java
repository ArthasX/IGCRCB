/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.svc.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.svc.bl.IGSVC06BL;
import com.deliverik.infogovernor.svc.dto.IGSVC06DTO;
import com.deliverik.infogovernor.svc.form.IGSVC0638Form;
import com.deliverik.infogovernor.svc.vo.IGSVC06381VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��������ƽ�����ʱ��ͳ��Action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGSVC0638Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��־����ȡ��
		Log log = LogFactory.getLog(IGSVC0638Action.class);
		//BLȡ��
		IGSVC06BL ctlBL = (IGSVC06BL) getBean("igsvc06BL");
		//ʵ����dto
		IGSVC06DTO dto = new IGSVC06DTO();
		//formȡ��
		IGSVC0638Form form = (IGSVC0638Form) actionForm;
		//dto�����趨
		dto.setIgsvc0638Form(form);
		//ҳ���ʼ������
		if("DISP".equals(mapping.getParameter())){
			log.debug("============��������ƽ�����ʱ��ͳ��ҳ���ʼ��������ʼ============");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
			Date date = new Date();
			String year = sdf.format(date);
			form.setYear(year);
			sdf = new SimpleDateFormat("MM");
			String month = sdf.format(date);
			form.setMonth(month);
			log.debug("============��������ƽ�����ʱ��ͳ��ҳ���ʼ����������============");
		}
		//ͳ�����ݲ�ѯ
		if("SEARCH".equals(mapping.getParameter())){
			log.debug("===========��������ƽ������ʱ��ͳ�����ݲ�ѯ������ʼ=============");
			dto = ctlBL.searchIncidentAveSolveTimeAction(dto);
			//ʵ����vo
			IGSVC06381VO vo = new IGSVC06381VO();
			vo.setIncidentAveSolveTimeDate(dto.getIncidentAveSolveTimeDate());
			super.<IGSVC06381VO>setVO(request, vo);
			log.debug("===========��������ƽ������ʱ��ͳ�����ݲ�ѯ��������=============");
		}
		return mapping.findForward("DISP");
	}

}
