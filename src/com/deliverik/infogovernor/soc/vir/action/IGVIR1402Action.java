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
import com.deliverik.infogovernor.soc.vir.form.IGVIR1402Form;
import com.deliverik.infogovernor.soc.vir.vo.IGVIR14021VO;
import com.deliverik.infogovernor.xls.soc.vir.bl.IGVIR1402ExcelBL;
import com.deliverik.infogovernor.xls.soc.vir.dto.IGVIR1402ExcelDTO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��Դʹ�����ͳ��Action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGVIR1402Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��־����ȡ��
		Log log = LogFactory.getLog(IGVIR1402Action.class);
		//BLȡ��
		IGVIR14BL ctlBL = (IGVIR14BL) getBean("igvir14BL");
		//ʵ����dto
		IGVIR14DTO dto = new IGVIR14DTO();
		//formȡ��
		IGVIR1402Form form = (IGVIR1402Form) actionForm;
		//dto�����趨
		dto.setVcid(form.getVcid());
		dto.setHostname(form.getHostname());
		//��ѯ������Ϣ
		dto = ctlBL.searchVCenterConnectionAction(dto);
		request.setAttribute("AD_vcnames", dto.getLabelValueBeanList());
		//ҳ���ʼ������
		if("DISP".equals(mapping.getParameter())){
			log.debug("============��Դʹ�����ͳ��ҳ���ʼ��������ʼ===========");
			log.debug("============��Դʹ�����ͳ��ҳ���ʼ����������===========");
		}
		//ͳ�Ʋ���
		if("SEARCH".equals(mapping.getParameter())){
			log.debug("=============��Դʹ�����ͳ�����ݲ�ѯ������ʼ=============");
			dto = ctlBL.searchHostInfosAction(dto);
			//ʵ����vo
			IGVIR14021VO vo = new IGVIR14021VO();
			vo.setHostMap(dto.getHostMap());
			super.setVO(request, vo);
			log.debug("=============��Դʹ�����ͳ�����ݲ�ѯ��������=============");
		}
		//��������
		if("EXPORT".equals(mapping.getParameter())){
			log.debug("============��Դʹ���������������ʼ============");
			dto = ctlBL.searchHostInfosAction(dto);
			IGVIR1402ExcelDTO excelDto = new IGVIR1402ExcelDTO();
			excelDto.setHostMap(dto.getHostMap());
			excelDto.setResponse(response);
			excelDto.setFileid("VIR1402");
			IGVIR1402ExcelBL excelBL = (IGVIR1402ExcelBL) getBean("igvir1402ExcelBL");
			excelBL.initExcel(excelDto);
			log.debug("============��Դʹ�����������������============");
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
