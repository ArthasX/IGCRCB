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
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.crc.bl.IGCRC23BL;
import com.deliverik.infogovernor.crc.bl.IGCRC23ExcelBL;
import com.deliverik.infogovernor.crc.dto.IGCRC2301DTO;
import com.deliverik.infogovernor.crc.dto.IGCRC2301ExcelDTO;
import com.deliverik.infogovernor.crc.form.IGCRC2301Form;
import com.deliverik.infogovernor.crc.vo.IGCRC2301VO;

/**	
 * ����: ���򿪷�ͳ����ȡaction
 * ���������� ���򿪷�ͳ����ȡaction
 * ������¼��ʷ����    2014-8-15 ����1:55:43	
 * �޸ļ�¼��
 *          
 */	
public class IGCRC2302Action extends BaseAction {
	//��־����ȡ��
	static Log log = LogFactory.getLog(IGCRC2302Action.class);

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

		log.debug("================���򿪷�ͳ����ȡAction��ʼ=============");
		//formȡ��
		IGCRC2301Form form = (IGCRC2301Form)actionForm;
		//BLȡ��
		IGCRC23BL igcrc23bl = (IGCRC23BL)getBean("igcrc23bl");
		//ʵ����dto
		IGCRC2301DTO dto = new IGCRC2301DTO();
		PagingDTO pDto = getPaginDTO(request, "IGCRC1304");
		dto.setIgcrc2301Form(form);
		if("SEARCH".equals(mapping.getParameter())){
			//��ѯ������ϸ��Ϣ
			int maxCnt = getMaxDataCount("IGCRC1304");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			dto = igcrc23bl.searchIG500ItemAction(dto);
			IGCRC2301VO vo = new IGCRC2301VO();
			//��ȡ��ѯ�Ĵ��ϼƵ������б���ܺϼ��б�
			vo.setProcessList(dto.getProcessList());
			super.<IGCRC2301VO>setVO(request, vo);
		}
		log.debug("================���򿪷�ͳ����ȡAction����=============");
		return mapping.findForward("DISP");
	}
}
