/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
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
import com.deliverik.infogovernor.crc.bl.IGCRC21ExcelBL;
import com.deliverik.infogovernor.crc.dto.IGCRC2101DTO;
import com.deliverik.infogovernor.crc.dto.IGCRC2101ExcelDTO;
import com.deliverik.infogovernor.crc.form.IGCRC2101Form;
import com.deliverik.infogovernor.crc.model.IGCRC2102VWInfo;
import com.deliverik.infogovernor.crc.model.entity.IGCRC2102VW;
import com.deliverik.infogovernor.crc.vo.IGCRC2101VO;

/**	
 * ����:��Ա����ͳ�Ʋ�ѯAction
 * ����������1.���̲�ѯ	
 *           2.Excel����
 * ������¼��yukexin    2014-8-14 17:28:40
 * �޸ļ�¼�� 
 *          	
 */	

public class IGCRC2101Action extends BaseAction {
	//��־����ȡ��
	static Log log = LogFactory.getLog(IGCRC2101Action.class);
	
	/**	
	 * ���ܣ�ҳ���ѯaction����
	 * @param mapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * �޸ļ�¼��
	 *          	
	 */	
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		log.debug("================��Ա����ͳ��Action��ʼ=============");
		//formȡ��
		IGCRC2101Form form = (IGCRC2101Form)actionForm;
		//BLȡ��
		IGCRC21BL igcrc21bl = (IGCRC21BL)getBean("igcrc21bl");
		//ʵ����dto
		IGCRC2101DTO dto = new IGCRC2101DTO();
		// ��ת
		String forward = "";
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
		//form����dto
		dto.setIgcrc2101Form(form);
		
		//�����������б�
		Integer yearNum = 5;//��ʾ��ݸ���
		//��2014�꿪ʼ
		Integer year = 2014;
		List<LabelValueBean> yearBeanList = new ArrayList<LabelValueBean>();
		yearBeanList.add(new LabelValueBean());
		for (int i = 0; i < yearNum; i++) {
			yearBeanList.add(new LabelValueBean(year + "��",year.toString()));
			year++;
		}
		//���浽request
		request.setAttribute("yearBeanList", yearBeanList);
		
		//����·������б�
		List<LabelValueBean> monthBeanList = new ArrayList<LabelValueBean>();
		monthBeanList.add(new LabelValueBean());
		for (Integer month = 1; month < 13; month++) {
			monthBeanList.add(new LabelValueBean(month + "��",month.toString().length() == 1?"0" + month.toString() : month.toString()));
		}
		//���浽request
		request.setAttribute("monthBeanList", monthBeanList);
		
		//����BL��ѯ ��ò���������ֵ
		dto = igcrc21bl.searchDepartmentBeanList(dto);
		//��ȡdto�еĲ��������б�ֵ
		List<IGCRC2102VWInfo> departmentBeanList = dto.getDepartmentBeanList();
		//Ϊ������������ӳ�ʼ����ֵ
		departmentBeanList.add(0, new IGCRC2102VW());
		
		request.setAttribute("departmentBeanList", departmentBeanList);
		
		
		if("SEARCH".equals(mapping.getParameter())){
			log.debug("========��Ա����ͳ�Ʋ�ѯ����ʼ========");
			//����BL��ѯ 
			dto = igcrc21bl.searchEntityItemAction(dto);
			//����VO
			IGCRC2101VO vo = new IGCRC2101VO();
			//��ȡ��ѯ�Ĵ��ϼƵ������б���ܺϼ��б�
			vo.setIgcrc2102VOList(dto.getIgcrc2102voList());
			vo.setListSum(dto.getListSum());
			super.<IGCRC2101VO>setVO(request, vo);
			log.debug("========��Ա����ͳ�Ʋ�ѯ�������========");
			forward = "DISP";
		}else if ("EXCEL".equals(mapping.getParameter())) {
			log.debug("=====================��Ա����ͳ�Ƶ�����ʼ=======================");
			//��ȡbl
			IGCRC21ExcelBL excelBL = (IGCRC21ExcelBL)getBean("igcrc21ExcelBL");
			//��ȡ��ѯ����dto
			dto = igcrc21bl.searchEntityItemAction(dto);
			// ʵ��ExeclDTO
			IGCRC2101ExcelDTO excelDTO = new IGCRC2101ExcelDTO();
			excelDTO.setIgcrc2102voList(dto.getIgcrc2102voList());
			excelDTO.setListSum(dto.getListSum());
			// ���ģ����
			excelDTO.setFileid("CRC2101");
			excelDTO.setResponse(response);
			excelBL.initExcel(excelDTO);
			log.debug("=====================��Ա����ͳ�Ƶ�������=======================");
			log.debug("================��Ա����ͳ��Action����=============");
			return null;
		}
		log.debug("================��Ա����ͳ��Action����=============");
		return mapping.findForward(forward);
	}
}
