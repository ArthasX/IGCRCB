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
import com.deliverik.infogovernor.svc.form.IGSVC0637Form;
import com.deliverik.infogovernor.svc.vo.IGSVC06371VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���ŷ���top5ͳ��Action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGSVC0637Action extends BaseAction	{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��־����ȡ��
		Log log = LogFactory.getLog(IGSVC0637Action.class);
		//BLȡ��
		IGSVC06BL ctlBL = (IGSVC06BL) getBean("igsvc06BL");
		//ʵ����dto
		IGSVC06DTO dto = new IGSVC06DTO();
		//formȡ��
		IGSVC0637Form form = (IGSVC0637Form) actionForm;
		//dto�����趨
		dto.setIgsvc0637Form(form);
		//ҳ���ʼ������
		if("DISP".equals(mapping.getParameter())){
			log.debug("==============���ŷ���top5ͳ��ҳ���ʼ��������ʼ==============");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
			Date date = new Date();
			String year = sdf.format(date);
			form.setYear(year);
			sdf = new SimpleDateFormat("MM");
			String month = sdf.format(date);
			form.setMonth(month);
			log.debug("==============���ŷ���top5ͳ��ҳ���ʼ����������==============");
		}
		//ͳ�Ʋ�ѯ����
		if("SEARCH".equals(mapping.getParameter())){
			log.debug("==========���ŷ���ͳ��topͳ�Ʋ�ѯ������ʼ============");
			dto = ctlBL.searchServiceTopFiveDateAction(dto);
			//ʵ����vo
			IGSVC06371VO vo = new IGSVC06371VO();
			vo.setServiceTopFiveList(dto.getServiceTopFiveList());
			super.<IGSVC06371VO>setVO(request, vo);
			log.debug("==========���ŷ���ͳ��topͳ�Ʋ�ѯ��������============");
		}
		return mapping.findForward("DISP");
	}

}
