/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.ram.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.infogovernor.ram.bl.IGRAM04BL;
import com.deliverik.infogovernor.ram.dto.IGRAM04DTO;
import com.deliverik.infogovernor.ram.form.IGRAM0401Form;
import com.deliverik.infogovernor.ram.vo.IGRAM04011VO;
import com.deliverik.infogovernor.xls.ram.bl.IGRAM0401ExcelBL;
import com.deliverik.infogovernor.xls.ram.dto.IGRAM0401ExcelDTO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ��ȫ����ƽ̨
 * </p>
 * <p>
 * Description: ��������_��ȹ���ͳ��ACTION
 * </p>
 * 
 * @author tangzhen@deliverik.com
 * @version 1.0
 */

public class IGRAM0401Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGRAM0401Action.class);
	
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// ʵ����DTO
		IGRAM04DTO dto = new IGRAM04DTO();
		// ��ȡBL�ӿ�ʵ��
		IGRAM04BL ctlBL = (IGRAM04BL) getBean("igram04BL");
		// ʵ����Form
		IGRAM0401Form form = (IGRAM0401Form) actionForm;

		if ("DISP".equals(mapping.getParameter())) {
			log.debug("==========���������ѯ��ʼ����ʼ==========");
			//����Ĭ�ϲ�ѯ���
			form.setCurrentyear(IGStringUtils.getCurrentYear());
			log.debug("==========���������ѯ��ʼ������==========");
		}
		if ("SEARCH".equals(mapping.getParameter())) {
			log.debug("==========���������ѯ��ʼ ==========");
			dto.setCurrentyear(form.getCurrentyear());
			//��ѯ�������ͳ�ƣ�ҳ����ʾ
			dto = ctlBL.getAssessmentYearReport(dto);
			IGRAM04011VO vo = new IGRAM04011VO();
			vo.setYearReport(dto.getYearReport());
			super.<IGRAM04011VO> setVO(request, vo);
			log.debug("==========���������ѯ��ʼ ==========");
		}
		if ("EXPORT".equals(mapping.getParameter())) {
			log.debug("==========�������������ʼ ==========");
			dto.setCurrentyear(form.getCurrentyear());
			dto = ctlBL.getAssessmentYearReport(dto);
			IGRAM0401ExcelDTO excelDTO = new IGRAM0401ExcelDTO();
			//��ѯģ���
			excelDTO.setFileid("RAM0401");
			//��ѯ�������
			excelDTO.setYearReport(dto.getYearReport());
			excelDTO.setResponse(response);
			//��Ӳ�ѯ�����ʾ
			excelDTO.setCurrentyear(form.getCurrentyear());
			
			IGRAM0401ExcelBL excelBL = (IGRAM0401ExcelBL) getBean("igram0401excelBL");
			excelBL.initExcel(excelDTO);
			request.removeAttribute("report1");
			log.debug("========�����������������========");
			return null;
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}

}
