/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.asset.bl.IGASM4001ExcelBL;
import com.deliverik.infogovernor.asset.bl.IGASM41BL;
import com.deliverik.infogovernor.asset.dto.IGASM41DTO;
import com.deliverik.infogovernor.asset.dto.IGASM41ExcelDTO;
import com.deliverik.infogovernor.asset.vo.IGASM40011VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: 
 * </p>
 * 
 * @author shenbing@deliverik.com
 * @version 1.0
 */
public class IGASM4001Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGASM4001Action.class);
	
	/**
	 * <p>
	 * Description: ҳ���ѯaction����
	 * </p>
	 * 
	 * @update
	 */
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��תҳ��
		String forward = "DISP";
		//ʵ����DTO
		IGASM41DTO dto = new IGASM41DTO();
		//��ȡBL�ӿ�ʵ��
		IGASM41BL crcBL = (IGASM41BL)getBean("igasm41bl");
		//����BL��ѯ 
		dto = crcBL.searchEntityItemAction(dto);
		if("SEARCH".equals(mapping.getParameter())){
			log.debug("========���ռ��ͳ����Ϣ��ѯ����ʼ========");
			//ʵ����FORM
			//IGCRC1301Form form = (IGCRC1301Form)actionForm;
			//���ռ��ͳ����Ϣ��ѯ
			//����VO
			IGASM40011VO vo = new IGASM40011VO();
			vo.setRiskCheckMap(dto.getRiskCheckMap());
			super.<IGASM40011VO>setVO(request, vo);
			log.debug("========���ռ��ͳ����Ϣ��ѯ��������========");
		}else if("EXCEL".equals(mapping.getParameter())){
			log.debug("=====================���ռ��ͳ����Ϣ������ʼ=======================");
			// ȡ��Excel����BL
			IGASM4001ExcelBL excelBL = (IGASM4001ExcelBL) getBean("igasm41ExcelBL");
			// ʵ��ExeclDTO
			IGASM41ExcelDTO excelDTO = new IGASM41ExcelDTO();
			excelDTO.setRiskCheckMap(dto.getRiskCheckMap());
			// ���ģ����
			excelDTO.setFileid("ASM4001");
			excelDTO.setResponse(response);
			excelBL.initExcel(excelDTO);
			log.debug("=====================���ռ��ͳ����Ϣ��������=======================");
			forward = null;
		}
		return mapping.findForward(forward);
	}
}
