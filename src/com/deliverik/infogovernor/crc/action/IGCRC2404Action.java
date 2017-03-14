/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.crc.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.crc.bl.IGCRC21BL;
import com.deliverik.infogovernor.crc.bl.IGCRC24BL;
import com.deliverik.infogovernor.crc.bl.IGCRC24ExcelBL;
import com.deliverik.infogovernor.crc.dto.IGCRC2101DTO;
import com.deliverik.infogovernor.crc.dto.IGCRC2401DTO;
import com.deliverik.infogovernor.crc.dto.IGCRC2401ExcelDTO;
import com.deliverik.infogovernor.crc.form.IGCRC2401Form;
import com.deliverik.infogovernor.crc.model.IGCRC2102VWInfo;
import com.deliverik.infogovernor.crc.model.entity.IGCRC2102VW;
import com.deliverik.infogovernor.crc.vo.IGCRC2401VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �澯ƽ����Ӧʱ��Action
 *              zhangq@deliverik.com
 * </p>
 * @version 1.0
 */
public class IGCRC2404Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCRC2404Action.class);

	/**
	 * <p>
	 * Description: �¼�ƽ�����ʱ��action����
	 * </p>
	 * 
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// Form���
		IGCRC2401Form form = (IGCRC2401Form) actionForm;
		// BL��ȡ
		IGCRC24BL ctlBl = (IGCRC24BL) getBean("igcrc24bl");
		// DTO����
		IGCRC2401DTO dto = new IGCRC2401DTO();
		
		//�趨Ϊ�¼�
		form.setSign("2");
		
		// ��������б�
		int beginYear = 2014;
		int endYear = 2018;
		// ���List
		List<LabelValueBean> yearList = new ArrayList<LabelValueBean>();
		yearList.add(new LabelValueBean());
		for (Integer i = beginYear; i <= endYear; i++) {
			yearList.add(new LabelValueBean(i + "��", i.toString()));
		}
		request.setAttribute("yearList", yearList);
		// �·������б�
		int endMonth = 12;
		int beginMonth = 1;
		// �·�List
		List<LabelValueBean> monthList = new ArrayList<LabelValueBean>();
		monthList.add(new LabelValueBean());
		for (Integer i = beginMonth; i <= endMonth; i++) {
			monthList.add(new LabelValueBean(i + "��",i.toString().length() == 1?"0" + i.toString() : i.toString()));
		}
		request.setAttribute("monthList", monthList);

		// ���������б�
		IGCRC21BL igcrc21bl = (IGCRC21BL) getBean("igcrc21bl");
		IGCRC2101DTO dto2101 = new IGCRC2101DTO();
		dto2101 = igcrc21bl.searchDepartmentBeanList(dto2101);
		// ��ȡdto�еĲ��������б�ֵ
		List<IGCRC2102VWInfo> departmentBeanList = dto2101.getDepartmentBeanList();
		// Ϊ������������ӳ�ʼ����ֵ
		departmentBeanList.add(0, new IGCRC2102VW());

		request.setAttribute("deptList", departmentBeanList);
		//��ȡ��ǰʱ��
		Calendar calendar = Calendar.getInstance();
		//��ʼ��ҳ��ʱ��(����) 
		if(null == form.getYear()){
			Integer year = calendar.get(Calendar.YEAR);
			form.setYear(year.toString());
		}
		if(null == form.getMonth()){
			Integer month = calendar.get(Calendar.MONTH) + 1;
			//�·������1λʱ��ȫ2λ
			form.setMonth(month.toString().length() == 1 ? "0" + month : month.toString());
		}
		// DTO�����趨
		dto.setIgcrc2401Form(form);
		String forward = "";
		if ("DISP".equals(mapping.getParameter())) {
			log.debug("========�����¼���ѯ���������ʾ����ʼ========");
			forward = "DISP";
			log.debug("========�����¼���ѯ���������ʾ�������========");
		} else if ("SEARCH".equals(mapping.getParameter())) {
			log.debug("=====================���ͳ�Ʋ�ѯ��ʼ=======================");
			// ����BL��ѯ
			dto = ctlBl.getFindStatisticsConfirm(dto);
			
			IGCRC2401VO vo = new IGCRC2401VO();
			// ���������VO��
			vo.setIgcrc2402voList(dto.getIgcrc2402voList());
			super.<IGCRC2401VO> setVO(request, vo);
			forward = "DISP";
			log.debug("=====================���ͳ�Ʋ�ѯ����=======================");
		} else if ("EXCEL".equals(mapping.getParameter())) {
			log.debug("=====================���ͳ�Ƶ�����ʼ=======================");
			// DTO�����趨
			dto.setIgcrc2401Form(form);
			// ����BL��ѯ
			dto = ctlBl.getFindStatisticsConfirm(dto);
			// ȡ��Excel����BL
			IGCRC24ExcelBL excelBL = (IGCRC24ExcelBL) getBean("igcrc24ExcelBL");
			// ����excelDTO
			IGCRC2401ExcelDTO excelDTO = new IGCRC2401ExcelDTO();
			// ���Ҫ�����Ľ��
			excelDTO.setIgcrc2402voList(dto.getIgcrc2402voList());
			// ���ģ����
			excelDTO.setFileid("CRC2401");
			excelDTO.setResponse(response);
			excelBL.initExcel(excelDTO);
			log.debug("=====================���ͳ�Ƶ�������=======================");
			forward = null;
		}
		return mapping.findForward(forward);
	}

}
