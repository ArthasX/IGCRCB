/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prj.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.prj.bl.IGPRJ01BL;
import com.deliverik.infogovernor.prj.dto.IGPRJ01DTO;
import com.deliverik.infogovernor.prj.form.IGPRJ0110Form;
import com.deliverik.infogovernor.xls.prj.bl.IGPRJ0101ExcelBL;
import com.deliverik.infogovernor.xls.prj.bl.IGPRJ0110ExcelBL;
import com.deliverik.infogovernor.xls.prj.dto.IGPRJ0101ExcelDTO;
import com.deliverik.infogovernor.xls.prj.dto.IGPRJ0110ExcelDTO;

/**
 * ����:ͳ�Ʒ���ҳaction 
 * ����������ͳ�Ʒ���ҳaction
 * �����ˣ���͢־
 * ������¼�� 2012-5-24
 * �޸ļ�¼��
 */
public class IGPRJ0110Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Log log = LogFactory.getLog(IGPRJ0110Action.class);
		IGPRJ01BL ctlBL = (IGPRJ01BL) getBean("igprj01BL");
		@SuppressWarnings("unused")
		IGPRJ0110Form  form = (IGPRJ0110Form) actionForm;
		if("DISP".equals(mapping.getParameter())){
			log.debug("===============ͳ�Ʒ���ҳ��ʼ����ʼ=================");
			log.debug("===============ͳ�Ʒ���ҳ��ʼ������=================");
		}
		if("IUSEEXPORT".equals(mapping.getParameter())){
			log.debug("===============Ͷ��ʹ�ñ�������ʼ=================");
			IGPRJ01DTO dto = new IGPRJ01DTO();
			dto = ctlBL.exportSearchAction(dto);
			IGPRJ0101ExcelDTO excelDTO = new IGPRJ0101ExcelDTO();
			excelDTO.setInvestUseInfoList(dto.getInvestUseInfoList());
			excelDTO.setPpqCodeList(dto.getPpqCodeList());
			excelDTO.setPtypeCodeList(dto.getPtypeCodeList());
			excelDTO.setResponse(response);
			excelDTO.setFileid("PRJ0101");
			IGPRJ0101ExcelBL excelBL = (IGPRJ0101ExcelBL) getBean("igprj0101ExcelBL");
			excelBL.initExcel(excelDTO);
			log.debug("===============Ͷ��ʹ�ñ���������=================");
			return null;
		}
		if("ICAEXPORT".equals(mapping.getParameter())){
			log.debug("===============Ͷ�ʺ�ͬ��ϸ��������ʼ=================");
			IGPRJ01DTO dto = new IGPRJ01DTO();
			dto = ctlBL.exportSearchInvestCaAction(dto);
			IGPRJ0110ExcelDTO excelDTO = new IGPRJ0110ExcelDTO();
			excelDTO.setInvestContractList(dto.getInvestContractInfoList());
			excelDTO.setResponse(response);
			excelDTO.setFileid("PRJ0110");
			IGPRJ0110ExcelBL excelBL = (IGPRJ0110ExcelBL) getBean("igprj0110ExcelBL");
			excelBL.initExcel(excelDTO);
			log.debug("===============Ͷ�ʺ�ͬ��ϸ����������=================");
			return null;
		}
		return mapping.findForward("DISP");
	}

}
