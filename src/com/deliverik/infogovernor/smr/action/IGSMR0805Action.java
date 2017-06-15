/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.smr.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.smr.bl.IGSMR08BL;
import com.deliverik.infogovernor.smr.dto.IGSMR08DTO;
import com.deliverik.infogovernor.smr.form.IGSMR0804Form;
import com.deliverik.infogovernor.smr.vo.IGSMR08041VO;

/**
 * ����:��������ϵͳ�������ͳ�Ʋ�ѯaction
 * ������������������ϵͳ�������ͳ�Ʋ�ѯaction
 * ������¼�� 2013/09/13
 * �޸ļ�¼��
 */
public class IGSMR0805Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSMR0805Action.class);
	
	/**
	 * ��������ϵͳ�������ͳ�Ʋ�ѯ
	 * 
	 * @param mapping
	 * @param actionForm
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��תҳ���ʶ
		String forward = "DISP";
		//��ȡForm
		IGSMR0804Form form = (IGSMR0804Form) actionForm;
		//controlBLȡ��
		IGSMR08BL ctlBL = (IGSMR08BL) getBean("igSMR08BL");
		
		//ʵ����dto
		IGSMR08DTO dto = new IGSMR08DTO();
		
		//��������ϵͳ�������ͳ�Ʋ�ѯ��ʼ��
		if("DISP".equals(mapping.getParameter())){
			log.debug("======��������ϵͳ�������ͳ�Ʋ�ѯ��ʼ������ʼ======");
			form.setPagesize(0);
			dto.setIgsmr0804Form(form);
			dto = ctlBL.searchIGSMR0805Action(dto);
			
			form.setCountall(dto.getCountall());
			
			IGSMR08041VO vo = new IGSMR08041VO();
			vo.setMap_report(dto.getMap_report());
			super.<IGSMR08041VO>setVO(request, vo);
			
			log.debug("======��������ϵͳ�������ͳ�Ʋ�ѯ��ʼ���������======");
		}
		//��������ϵͳ�������ͳ�Ʋ�ѯ��ʼ��
		if("SEARCH".equals(mapping.getParameter())){
			dto.setIgsmr0804Form(form);
			dto = ctlBL.searchIGSMR0805Action(dto);
			form.setYear_flag(form.getYear());
			form.setCountall(dto.getCountall());
			
			IGSMR08041VO vo = new IGSMR08041VO();
			vo.setMap_report(dto.getMap_report());
			super.<IGSMR08041VO>setVO(request, vo);
		}
		return mapping.findForward(forward);
	}
}
