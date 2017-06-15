/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.action;

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
import com.deliverik.infogovernor.soc.vir.bl.IGVIR14BL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR14DTO;
import com.deliverik.infogovernor.soc.vir.form.IGVIR1401Form;
import com.deliverik.infogovernor.soc.vir.vo.IGVIR14011VO;
import com.deliverik.infogovernor.xls.soc.vir.bl.IGVIR1401ExcelBL;
import com.deliverik.infogovernor.xls.soc.vir.dto.IGVIR1401ExcelDTO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��Դ����ͳ��Action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGVIR1401Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��־����ȡ��
		Log log = LogFactory.getLog(IGVIR1401Action.class);
		//BLȡ��
		IGVIR14BL ctlBL = (IGVIR14BL) getBean("igvir14BL");
		//ʵ����dto
		IGVIR14DTO dto = new IGVIR14DTO();
		//formȡ��
		IGVIR1401Form form = (IGVIR1401Form) actionForm;
		//dto�����趨
		dto.setIgvir1401Form(form);
		//ҳ���ʼ������
		if("DISP".equals(mapping.getParameter())){
			log.debug("===============��Դ����ͳ��ҳ���ʼ��������ʼ================");
			log.debug("===============��Դ����ͳ��ҳ���ʼ����������================");
		}
		//ͳ�����ݲ�ѯ
		if("SEARCH".equals(mapping.getParameter())){
			log.debug("=================��Դ����ͳ��ͳ�����ݲ�ѯ������ʼ================");
			dto = ctlBL.searchVMApplyStatisticsDataAction(dto);
			//ʵ����vo
			IGVIR14011VO vo = new IGVIR14011VO();
			vo.setVmApplyStatisticsDataMap(dto.getVmApplyStatisticsDataMap());
			super.<IGVIR14011VO>setVO(request, vo);
			log.debug("=================��Դ����ͳ��ͳ�����ݲ�ѯ��������================");
		}
		//��������
		if("EXPORT".equals(mapping.getParameter())){
			log.debug("==============��Դ����ͳ�Ƶ���������ʼ================");
			dto = ctlBL.searchVMApplyStatisticsDataAction(dto);
			IGVIR1401ExcelDTO excelDto = new IGVIR1401ExcelDTO();
			excelDto.setVmApplyStatisticsDataMap(dto.getVmApplyStatisticsDataMap());
			excelDto.setResponse(response);
			excelDto.setFileid("VIR1401");
			IGVIR1401ExcelBL excelBL = (IGVIR1401ExcelBL) getBean("igvir1401ExcelBL");
			excelBL.initExcel(excelDto);
			log.debug("==============��Դ����ͳ�Ƶ�����������================");
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
