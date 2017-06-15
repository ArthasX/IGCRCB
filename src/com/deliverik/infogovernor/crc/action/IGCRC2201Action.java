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
import com.deliverik.infogovernor.crc.bl.IGCRC22BL;
import com.deliverik.infogovernor.crc.bl.IGCRC22ExcelBL;
import com.deliverik.infogovernor.crc.dto.IGCRC2201DTO;
import com.deliverik.infogovernor.crc.dto.IGCRC2201ExcelDTO;
import com.deliverik.infogovernor.crc.form.IGCRC2201Form;
import com.deliverik.infogovernor.crc.vo.IGCRC2201VO;

/**	
 * ����:�������ͳ��Action����
 * ���������� 1.��ѯ�������
 *           2.�����������
 * ������¼��yukexin    2014-8-15 ����1:54:45	
 * �޸ļ�¼��
 *          
 */	
public class IGCRC2201Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCRC2201Action.class);
	/**	
	 * ���ܣ��¼�����
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
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception {

		log.debug("================�������ͳ��Action��ʼ=============");
		// Form���
		IGCRC2201Form form = (IGCRC2201Form) actionForm;
		// BL��ȡ
		IGCRC22BL ctlBl = (IGCRC22BL) this.getBean("igcrc22bl");
		// DTO����
		IGCRC2201DTO dto = new IGCRC2201DTO();
		// ��ת
		String forward = "";

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
		
		//��2014�꿪ʼ
		int year = 2014;
		// ����������б�
		List<LabelValueBean> yearList = new ArrayList<LabelValueBean>();
		yearList.add(new LabelValueBean("", ""));
		for (int i = 0; i < 5; i++) {
			yearList.add(new LabelValueBean(year + i + "��", year + i + ""));
		}
		//���浽request
		request.setAttribute("yearList", yearList);

		// ����������б�
		List<LabelValueBean> monthList = new ArrayList<LabelValueBean>();
		monthList.add(new LabelValueBean("", ""));
		for (int i = 1; i <= 12; i++) {
			monthList.add(new LabelValueBean(i + "��", new Integer(i).toString().length() == 1 ? "0" + i : "" + i));
		}
		//���浽request
		request.setAttribute("monthList", monthList);
		
		if ("SEARCH".equals(mapping.getParameter())) {
			log.debug("=====================�������ͳ�Ʋ�ѯ��ʼ=======================");
			// DTO�����趨
			dto.setIgcrc2201Form(form);
			// ���ͳ���߼�����
			dto = ctlBl.searchEntityItemAction(dto);
			// ���������VO��
			IGCRC2201VO vo = new IGCRC2201VO();
			vo.setIgcrc2202voList(dto.getIgcrc2202voList());
			super.<IGCRC2201VO> setVO(request, vo);
			log.debug("=====================�������ͳ�Ʋ�ѯ����=======================");
			forward = "SUCCESS";
		}else if("EXCEL".equals(mapping.getParameter())){ 
			log.debug("=====================�������ͳ�Ƶ�����ʼ=======================");
			dto.setIgcrc2201Form(form);
			// ���ͳ���߼�����
			dto = ctlBl.searchEntityItemAction(dto);
			//��ȡexcel bl
			IGCRC22ExcelBL excelBL = (IGCRC22ExcelBL)getBean("igcrc22ExcelBL");
			// ʵ��ExeclDTO
			IGCRC2201ExcelDTO excelDTO = new IGCRC2201ExcelDTO();
			excelDTO.setIgcrc2202voList(dto.getIgcrc2202voList());
			// ���ģ����
			excelDTO.setFileid("CRC2201");
			excelDTO.setResponse(response);
			excelBL.initExcel(excelDTO);
			log.debug("=====================�������ͳ�Ƶ�������=======================");
			log.debug("================�������ͳ��Action������=============");
			return null;
		}else if("DISP".equals(mapping.getParameter())) {
			forward = "DISP";
		}
		log.debug("================�������ͳ��Action������=============");
		return mapping.findForward(forward);
		
	}
}
