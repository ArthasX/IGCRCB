/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.sym.action;

import java.util.Calendar;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.sym.bl.IGSYM19BL;
import com.deliverik.infogovernor.sym.dto.IGSYM19DTO;
import com.deliverik.infogovernor.sym.form.IGSYM1901Form;
import com.deliverik.infogovernor.sym.vo.IGSYM19011VO;
import com.deliverik.framework.workflow.prr.model.ProcessWorkTimeTemplateInfo;
/**
 * ����:��Ϣ����ģ���ѯAction
 * ������������Ϣ����ģ���ѯ
 * ������¼����� 2011/10/18
 * �޸ļ�¼��LuJiayuan Ǩ�ƹ��ܽ�������IGSYM1701Action���ΪIGSYM1901Action 2013/01/30
 */
public class IGSYM1901Action extends BaseAction{

	static Log log = LogFactory.getLog(IGSYM1901Action.class);
	
	/**
	 * ��Ϣ����ģ���ѯ����
	 * @param mapping 
	 * @param actionForm 
	 * @param request 
	 * @param response 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		IGSYM1901Form igsym1901Form = (IGSYM1901Form)actionForm;
		IGSYM19BL igsym19BL=(IGSYM19BL) getBean("igsym19BL");
		IGSYM19DTO dto = new IGSYM19DTO();
		//��ʼ����Ϣģ���ѯ����
		if("DISP".equals(mapping.getParameter())){
			log.debug("==============��Ϣģ���ѯ�����ʼ����ʼ===============");
			Calendar cal=Calendar.getInstance();
			//ȡ�õ�ǰ��
			Integer year = cal.get(Calendar.YEAR);
			//ȡ�õ�ǰ��
			Integer month = cal.get(Calendar.MONTH);
			igsym1901Form.setYear(year);
			igsym1901Form.setMonth(month);
			dto.setIgsym1901Form(igsym1901Form);
			//��Ϣģ���¼��ѯ
			dto = igsym19BL.searchProcessWorkTimeTemplate(dto);
			//��Ϣģ���¼�����
			List<ProcessWorkTimeTemplateInfo> processWorkTimeTemplateInfoList = dto.getProcessWorkTimeTemplateInfoList();
			IGSYM19011VO igsym19011vo=new IGSYM19011VO();
			igsym19011vo.setProcessWorkTimeTemplateInfoList(processWorkTimeTemplateInfoList);
			super.<IGSYM19011VO>setVO(request, igsym19011vo);
			request.setAttribute("voMap", dto.getVoMap());
			log.debug("==============��Ϣģ���ѯ�����ʼ������===============");
		}
		//�ز�ѯ��Ϣģ�廭��
		if("REDISP".equals(mapping.getParameter())){
			log.debug("==============��Ϣģ���ز�ѯ���濪ʼ===============");
			dto.setIgsym1901Form(igsym1901Form);
			//��Ϣģ���¼��ѯ
			dto = igsym19BL.searchProcessWorkTimeTemplate(dto);
			List<ProcessWorkTimeTemplateInfo> processWorkTimeTemplateInfoList = dto.getProcessWorkTimeTemplateInfoList();
			IGSYM19011VO igsym19011vo=new IGSYM19011VO();
			igsym19011vo.setProcessWorkTimeTemplateInfoList(processWorkTimeTemplateInfoList);
			request.setAttribute("voMap", dto.getVoMap());
			super.<IGSYM19011VO>setVO(request, igsym19011vo);
			log.debug("==============��Ϣģ���ز�ѯ�������===============");
		}
		return mapping.findForward("DISP");
	}

}
