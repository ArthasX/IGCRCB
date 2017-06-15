/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.crc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.crc.bl.IGCRC13BL;
import com.deliverik.infogovernor.crc.bl.IGCRC14ExcelBL;
import com.deliverik.infogovernor.crc.dto.IGCRC1304DTO;
import com.deliverik.infogovernor.crc.dto.IGCRC1306ExcelDTO;
import com.deliverik.infogovernor.crc.form.IGCRC1304Form;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���������ύͳ��Action
 * </p>
 * 
 * @author wangnan@deliverik.com 
 * @version 1.0
 */
public class IGCRC1306Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCRC1306Action.class);
	
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.debug("================���������ύͳ��Action��ʼ=============");
		IGCRC1304Form form = (IGCRC1304Form)actionForm;
		
		IGCRC13BL igcrc13bl = (IGCRC13BL)getBean("igcrc13bl");
		
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		
		IGCRC1304DTO dto = new IGCRC1304DTO();
		
		dto.setUser(user);
		
		if("EXCEL".equals(mapping.getParameter())){
			log.debug("=================�����ύͳ�ƴ���ʼ===============");
			
			int maxCnt = getMaxDataCount("IGCRC1304");
			//��ȡ��ҳDTO
			PagingDTO pDto = getPaginDTO(request, "IGCRC1304");
			//�޸ķ�ҳDTO,��ѯȫ����������
			pDto.setFromCount(0);
			pDto.setPageDispCount(maxCnt);
			
			dto.setIgcrc1304Form(form);
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			dto = igcrc13bl.searchDepartSumAction(dto);
			
			//����excel DTO
			IGCRC1306ExcelDTO excelDTO = new IGCRC1306ExcelDTO();
			excelDTO.setListVM(dto.getListVM());
			// ���ģ����
			excelDTO.setFileid("CRC1306");
			excelDTO.setResponse(response);
			IGCRC14ExcelBL excelbl = (IGCRC14ExcelBL)getBean("igcrc14excelbl");
			excelbl.initExcel(excelDTO);
			log.debug("=================�����ύͳ�ƴ������===============");
		}
		log.debug("================���������ύͳ��Action����=============");
		return null;
	}

}
