/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.svc.action;

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
import com.deliverik.infogovernor.svc.bl.IGSVC06BL;
import com.deliverik.infogovernor.svc.dto.IGSVC06DTO;
import com.deliverik.infogovernor.svc.form.IGSVC0642Form;
import com.deliverik.infogovernor.svc.vo.IGSVC06421VO;
import com.deliverik.infogovernor.xls.svc.bl.IGSVC0642ExcelBL;
import com.deliverik.infogovernor.xls.svc.dto.IGSVC0642ExcelDTO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��������ͳ��Action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGSVC0642Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��־����ȡ��
		Log log = LogFactory.getLog(IGSVC0642Action.class);
		//BLȡ��
		IGSVC06BL ctlBL = (IGSVC06BL) getBean("igsvc06BL");
		//ʵ����dto
		IGSVC06DTO dto = new IGSVC06DTO();
		//formȡ��
		IGSVC0642Form form = (IGSVC0642Form) actionForm;
		//dto�����趨
		dto.setIgsvc0642Form(form);
		//ҳ���ʼ������
		if("DISP".equals(mapping.getParameter())){
			log.debug("=============��������ͳ��ҳ���ʼ��������ʼ=============");
			log.debug("=============��������ͳ��ҳ���ʼ����������=============");
		}
		//ͳ�Ʋ���
		if("SEARCH".equals(mapping.getParameter())){
			log.debug("==============��������ͳ�����ݲ�ѯ������ʼ=============");
			dto = ctlBL.searchProcessRecordCountAction(dto);
			IGSVC06421VO vo = dto.getIgsvc06421VO();
			super.<IGSVC06421VO>setVO(request, vo);
			log.debug("==============��������ͳ�����ݲ�ѯ��������=============");
		}
		//��������
		if("EXPORT".equals(mapping.getParameter())){
			log.debug("============��������ͳ�Ƶ���������ʼ============");
			dto = ctlBL.searchProcessRecordCountAction(dto);
			IGSVC06421VO vo = dto.getIgsvc06421VO();
			IGSVC0642ExcelDTO excelDTO = new IGSVC0642ExcelDTO();
			this.copyProperties(excelDTO, vo);
			excelDTO.setResponse(response);
			excelDTO.setFileid("SVC0642");
			IGSVC0642ExcelBL excelBL = (IGSVC0642ExcelBL) getBean("igsvc0642ExcelBL");
			excelBL.initExcel(excelDTO);
			log.debug("============��������ͳ�Ƶ�����������============");
			return null;
		}
		
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}

}
