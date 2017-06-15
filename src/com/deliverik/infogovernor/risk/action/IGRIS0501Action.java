/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.risk.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.risk.bl.IGRIS05BL;
import com.deliverik.infogovernor.risk.bl.IGRIS05ExcelBL;
import com.deliverik.infogovernor.risk.dto.IGRIS05DTO;
import com.deliverik.infogovernor.risk.dto.IGRIS05ExcelDTO;
import com.deliverik.infogovernor.risk.form.IGRIS0501Form;
import com.deliverik.infogovernor.risk.vo.IGRIS05011VO;

/***
 * ��Ϣ��ȫ����ͳ��
 * @author zhangqiang
 * @time   2014-07-09
 * @version 1.0
 */

public class IGRIS0501Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGRIS0501Action.class);

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		//ʵ�������ͳ�Ʋ�ѯBL
		IGRIS05BL ctrlBL =(IGRIS05BL)getBean("igris05BL");
		//ʵ�������ͳ��DTO
		IGRIS05DTO dto = new IGRIS05DTO();
		//ʵ����FORM
		IGRIS0501Form igris0501Form = (IGRIS0501Form) actionForm;
		
		//��תҳ��
		String forward = "DISP";
		
		if("DISP".equals(mapping.getParameter())){
			log.debug("=====================���ͳ�Ƴ�ʼ��ҳ�濪ʼ=======================");
			
			
			log.debug("=====================���ͳ�Ƴ�ʼ��ҳ�����=======================");
			
		}else if("SEARCH".equals(mapping.getParameter())){
			log.debug("=====================���ͳ�Ʋ�ѯ��ʼ=======================");
			dto.setIgris0501Form(igris0501Form);
			dto.setFlag("1");
			//����ctrlBL��ѯ
			ctrlBL.searchRiskCount(dto);
			//ҳ��VO�趨
			IGRIS05011VO vo = new IGRIS05011VO();
			vo.setCheckWorkMap(dto.getCheckExcelWorkConutmap());
			super.<IGRIS05011VO>setVO(req, vo);
			log.debug("=====================���ͳ�Ʋ�ѯ����=======================");
		}else if("EXCEL".equals(mapping.getParameter())){
			log.debug("=====================���ͳ�Ƶ�����ʼ=======================");
			dto.setIgris0501Form(igris0501Form);
			dto.setFlag("2");
			//����ctrlBL��ѯ
			ctrlBL.searchRiskCount(dto);
			// ȡ��Excel����BL
			IGRIS05ExcelBL excelBL = (IGRIS05ExcelBL) getBean("igris05ExcelBL");
			// ʵ��ExeclDTO
			IGRIS05ExcelDTO excelDTO = new IGRIS05ExcelDTO();
			excelDTO.setMap(dto.getCheckExcelWorkConutmap());
			excelDTO.setMapType(dto.getMapTypeExcel());
			// ���ģ����
			excelDTO.setFileid("RIS0501");
			excelDTO.setResponse(res);
			excelBL.initExcel(excelDTO);
			log.debug("=====================���ͳ�Ƶ�������=======================");
			forward=null;
		}
		return mapping.findForward(forward);
	}

}
