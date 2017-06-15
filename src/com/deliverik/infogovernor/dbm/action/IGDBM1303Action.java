package com.deliverik.infogovernor.dbm.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.dbm.bl.IGDBM13BL;
import com.deliverik.infogovernor.dbm.dto.IGDBM13DTO;
import com.deliverik.infogovernor.dbm.form.IGDBM1301Form;
import com.deliverik.infogovernor.xls.svc.bl.IGSVC1301ExcelBL;
import com.deliverik.infogovernor.xls.svc.dto.IGSVC1301ExcelDTO;

/**
 * ���������ѯ����Action����
 *
 */
public class IGDBM1303Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDBM1303Action.class);

	/**
	 * ���������ѯ����
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGDBM1301Form form = (IGDBM1301Form)actionForm;
		
		//BLȡ��
		IGDBM13BL ctlBL = (IGDBM13BL) getBean("igdbm13BL");
		//DTO����
		IGDBM13DTO dto = new IGDBM13DTO();
		
		if ("EXPORT".equals(mapping.getParameter())) {
			log.debug("==========������Ϣ������ʼ ==========");
			
			dto.setIgdbm1301Form(form);
			dto = ctlBL.exportWorkmanagerInfos(dto);
			IGSVC1301ExcelDTO excelDTO = new IGSVC1301ExcelDTO();
			//��ѯģ��
			excelDTO.setFileid("SVC1302");
			excelDTO.setResponse(res);
			excelDTO.setIgdbm1301Form(form);
			excelDTO.setWmList(dto.getWmList());
			IGSVC1301ExcelBL excelBL = (IGSVC1301ExcelBL) getBean("igsvc1301excelBL");
			excelBL.initExcel(excelDTO);

			log.debug("========������Ϣ��������========");
			return null;
		}
		
		//�߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
		}

		return mapping.findForward("DISP");
	}
}
