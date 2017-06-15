/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.crc.action;

import java.util.ArrayList;
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
import com.deliverik.infogovernor.crc.bl.IGCRC20BL;
import com.deliverik.infogovernor.crc.bl.IGCRC20ExcelBL;
import com.deliverik.infogovernor.crc.dto.IGCRC2001DTO;
import com.deliverik.infogovernor.crc.dto.IGCRC2001ExcelDTO;
import com.deliverik.infogovernor.crc.form.IGCRC2001Form;
import com.deliverik.infogovernor.crc.vo.IGCRC2001VO;


/**	
 * ����:��ȹ���ͳ�Ʋ�ѯAction
 * ���������� 1.��ȹ���ͳ�Ʋ�ѯ
 *        2.Excel����
 * ������¼��lianghongyang    2014-8-14 15:28:40
 * �޸ļ�¼�� 
 *          	
 */	
public class IGCRC2001Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCRC2001Action.class);


	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// Form���
		IGCRC2001Form form = (IGCRC2001Form) actionForm;
		// BL��ȡ
		IGCRC20BL ctlBl = (IGCRC20BL) getBean("igcrc20bl");
		// DTO����
		IGCRC2001DTO dto = new IGCRC2001DTO();

		// ��������б�
		int endYear = 2018;
		int beginYear = 2014;
		List<LabelValueBean> list = new ArrayList<LabelValueBean>();
		for (Integer i = beginYear; i <= endYear; i++) {
			list.add(new LabelValueBean(i.toString() + "��", i.toString()));
		}
		request.setAttribute("Yearlist", list);

		String forward = "";
		if ("SEARCH".equals(mapping.getParameter())) {
			log.debug("=====================���ͳ�Ʋ�ѯ��ʼ=======================");
			// DTO�����趨
			dto.setIgcrc2001Form(form);
			// ���ͳ���߼�����
			dto = ctlBl.getFindStatistics(dto);
			// ���������VO��
			IGCRC2001VO vo = new IGCRC2001VO();
			vo.setIgcrc2002voList(dto.getIgcrc2002voList());
			vo.setSumList(dto.getSumList());
			super.<IGCRC2001VO> setVO(request, vo);
			forward = "DISP";
			log.debug("=====================���ͳ�Ʋ�ѯ����=======================");
			// ����
		} else if ("EXCEL".equals(mapping.getParameter())) {
			log.debug("=====================���ͳ�Ƶ�����ʼ=======================");
			// ����excelDTO
			IGCRC2001ExcelDTO excelDTO = new IGCRC2001ExcelDTO();
			// DTO�����趨
			dto.setIgcrc2001Form(form);
			// ����BL��ѯ
			dto = ctlBl.getFindStatistics(dto);
			// ȡ��Excel����BL
			IGCRC20ExcelBL excelBL = (IGCRC20ExcelBL) getBean("igcrc20ExcelBL");
			// ���Ҫ�����Ľ��
			excelDTO.setIgcrc2002voList(dto.getIgcrc2002voList());
			excelDTO.setSumList(dto.getSumList());
			// ���ģ����
			excelDTO.setFileid("CRC2001");
			excelDTO.setResponse(response);
			excelBL.initExcel(excelDTO);
			log.debug("=====================���ͳ�Ƶ�������=======================");
			forward = null;
		}
		return mapping.findForward(forward);
	}
}
