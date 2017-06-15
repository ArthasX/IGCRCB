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
import com.deliverik.infogovernor.crc.bl.IGCRC23BL;
import com.deliverik.infogovernor.crc.bl.IGCRC23ExcelBL;
import com.deliverik.infogovernor.crc.dto.IGCRC2301DTO;
import com.deliverik.infogovernor.crc.dto.IGCRC2301ExcelDTO;
import com.deliverik.infogovernor.crc.form.IGCRC2301Form;
import com.deliverik.infogovernor.crc.vo.IGCRC2301VO;

/**	
 * ����:���򿪷�ͳ�Ʋ�ѯAction
 * ���������� 1.���򿪷�ͳ�Ʋ�ѯ
 *           2.���򿪷�ͳ�Ƶ���
 * ������¼��yukexin    2014-8-15 ����1:55:43	
 * �޸ļ�¼��
 *          
 */	
public class IGCRC2301Action extends BaseAction {
	//��־����ȡ��
	static Log log = LogFactory.getLog(IGCRC2301Action.class);

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

		log.debug("================���򿪷�ͳ��Action��ʼ=============");
		//formȡ��
		IGCRC2301Form form = (IGCRC2301Form)actionForm;
		//BLȡ��
		IGCRC23BL igcrc23bl = (IGCRC23BL)getBean("igcrc23bl");
		//ʵ����dto
		IGCRC2301DTO dto = new IGCRC2301DTO();
		
		//��ȡ��ǰʱ��
		Calendar calendar = Calendar.getInstance();
		
		//��ʼ��ҳ��ʱ��
		if(null == form.getYear()){
			Integer year = calendar.get(Calendar.YEAR);
			form.setYear(year.toString());
		}
		if(null == form.getMonth()){
			Integer month = calendar.get(Calendar.MONTH) + 1;
			form.setMonth(month.toString().length() == 1 ? "0" + month : month.toString());
		}
		
		dto.setIgcrc2301Form(form);
		
		// ��ת
		String forward = "";
		
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
		
		if("SEARCH".equals(mapping.getParameter())){
			log.debug("========���򿪷�ͳ�Ʋ�ѯ����ʼ========");
			//����BL��ѯ 
			dto = igcrc23bl.searchEntityItemAction(dto);
			//����VO
			IGCRC2301VO vo = new IGCRC2301VO();
			//��ȡ��ѯ�Ĵ��ϼƵ������б���ܺϼ��б�
			vo.setIgcrc2301VWList(dto.getEntityItemVWInfoList());
			super.<IGCRC2301VO>setVO(request, vo);
			log.debug("========���򿪷�ͳ�Ʋ�ѯ��������========");
			forward = "DISP";
		}else if ("EXCEL".equals(mapping.getParameter())) {
			log.debug("=====================���򿪷�ͳ�Ƶ�����ʼ=======================");
			//BLȡ��
			IGCRC23ExcelBL excelBL = (IGCRC23ExcelBL)getBean("igcrc23ExcelBL");
			//dto��ȡ
			dto = igcrc23bl.searchEntityItemAction(dto);
			
			// ʵ��ExeclDTO
			IGCRC2301ExcelDTO excelDTO = new IGCRC2301ExcelDTO();
			//dto���ݴ���excelDto	
			excelDTO.setIgcrc2301VWList(dto.getEntityItemVWInfoList());
			// ���ģ����
			excelDTO.setFileid("CRC2301");
			excelDTO.setResponse(response);
			excelBL.initExcel(excelDTO);
			log.debug("=====================���򿪷�ͳ�Ƶ�������=======================");
			log.debug("================���򿪷�ͳ��Action����=============");
			return null;
		}
		log.debug("================���򿪷�ͳ��Action����=============");
		return mapping.findForward(forward);
	}
}
