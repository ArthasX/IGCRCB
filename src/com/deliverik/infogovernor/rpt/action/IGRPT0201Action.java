/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.rpt.action;

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
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.rpt.bl.IGRPT02BL;
import com.deliverik.infogovernor.rpt.dto.IGRPT02DTO;
import com.deliverik.infogovernor.rpt.form.IGRPT0201Form;
import com.deliverik.infogovernor.rpt.form.IGRPT0202Form;
import com.deliverik.infogovernor.rpt.vo.IGRPT02011VO;

/**
 * ����: ģ�����Action
 * ��������: ģ�����Action
 * ������¼: 2012/06/07
 * �޸ļ�¼: 
 */
public class IGRPT0201Action extends BaseAction{
	
	static Log log = LogFactory.getLog(IGRPT0201Action.class);

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse resp) throws Exception {	
		//ȡ�ÿ���BL
		IGRPT02BL ctlBL =(IGRPT02BL) getBean("IGRPT02BL");
		//dto
		IGRPT02DTO dto=new IGRPT02DTO();
		//��ѯ����
		if("SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){//�����ѯ�¼�
			//ȡ��02Form
			IGRPT0202Form form=(IGRPT0202Form)actionForm;
			log.debug("===�Զ�����ģ������ѯ��ʼ===");
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGRPT0201");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			//�豸��ѯ����
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGRPT0202Form) req.getSession().getAttribute("IGRPT0202Form");
				if (form == null){
					form=new IGRPT0202Form();
				}else {
					if (req.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} else {
				if (req.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					form = (IGRPT0202Form) req.getSession().getAttribute("IGRPT0202Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGRPT0202Form");
			//DTO��������趨
			
			dto.setIGRPT0202Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			dto = ctlBL.searchReportTemplateByCond(dto);//��ѯReportTemplate��
			IGRPT02011VO vo=new IGRPT02011VO();
			vo.setReportTemplateList(dto.getReportTemplateList());
			super.<IGRPT02011VO>setVO(req, vo);
			
			log.debug("===�Զ�����ģ������ѯ����===");
		}
		//ɾ������
		if("DELETE".equals(mapping.getParameter())){
			//ȡ��02Form
			IGRPT0202Form form=(IGRPT0202Form)actionForm;
			log.debug("===�Զ�����ģ��ɾ������ʼ===");
			int maxCnt = getMaxDataCount("IGRPT0202Form");
			getPaginDTO(req,"IGRPT0201");
			PagingDTO pDto;
			dto.setMaxSearchCount(maxCnt);
			dto.setIGRPT0202Form(form);
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			dto.setPagingDto(pDto);
			//ɾ������
			ctlBL.deleteReportTemplateInstance(dto);
			//���²�ѯ
			dto=ctlBL.searchReportTemplateByCond(dto);
			IGRPT02011VO vo=new IGRPT02011VO();
			vo.setReportTemplateList(dto.getReportTemplateList());
			super.<IGRPT02011VO>setVO(req, vo);
			log.debug("===�Զ�����ģ��ɾ����������===");
		}
		//��������
		if("INSERT".equals(mapping.getParameter())){//�����Ӧ�˵�
			//ȡ��01Form
			IGRPT0201Form form=(IGRPT0201Form)actionForm;
			log.debug("===�Զ�����ģ����������ʼ===");
			dto.setIGRPT0201Form(form);
			ctlBL.insertReportTemplateInstance(dto);
			form.setInsertFlag("yes");
			req.getSession().setAttribute("ADmonitorObjectList", dto.getMonitorObjectList());
			req.getSession().setAttribute("ADDMX_KPI_List", dto.getDmx_list());
			req.getSession().setAttribute("ADIBM_KPI_List", dto.getIbm_list());
			req.getSession().setAttribute("ADCX_KPI_List", dto.getCx_list());
			IGRPT02011VO vo=new IGRPT02011VO();
			vo.setReportTemplateMappingList(dto.getSoc0206List());
			super.<IGRPT02011VO>setVO(req, vo);
			log.debug("===�Զ�����ģ��������������===");
		}
		
		
		//��ѯ��ʾ
		if("DISP".equals(mapping.getParameter())){//�����Ӧ�˵�
			log.debug("===�Զ�����ģ�����ҳ���ʼ����ʼ===");
			log.debug("===�Զ�����ģ�����ҳ���ʼ������===");
		}
		//������ʾ
		if("INSERT_DISP".equals(mapping.getParameter())){
			//ȡ��01Form
			IGRPT0201Form form=(IGRPT0201Form)actionForm;
			log.debug("===�Զ�����ģ��������ʾ��ʼ===");
			form.setMode("0");//������ʾ
//			dto.setIGRPT0101Form(form);
//			dto=ctlBL.initInsertAction(dto);
//			req.getSession().setAttribute("ADmonitorObjectList", dto.getMonitorObjectList());
//			req.getSession().setAttribute("ADDMX_KPI_List", dto.getDmx_list());
//			req.getSession().setAttribute("ADIBM_KPI_List", dto.getIbm_list());
//			req.getSession().setAttribute("ADCX_KPI_List", dto.getCx_list());
			log.debug("===�Զ�����ģ��������ʾ����===");
		}
		//�޸Ĵ���
		if("UPDATE".equals(mapping.getParameter())){
			//ȡ��01Form
			IGRPT0201Form form=(IGRPT0201Form)actionForm;
			log.debug("===�Զ�����ģ�������ʾ��ʼ===");
			dto.setIGRPT0201Form(form);
			ctlBL.updateReportTemplateInstance(dto);
			log.debug("===�Զ�����ģ�������ʾ����===");
		}
		//�޸���ʾ
		if("UPDATE_DISP".equals(mapping.getParameter())){
			//ȡ��01Form
			IGRPT0201Form form=(IGRPT0201Form)actionForm;
			form.setInsertFlag("yes");
			log.debug("===�Զ�����ģ�������ʾ��ʼ===");
			form.setMode("1");//���±�ʾ
			if(req.getParameter("rtId")!=null){
				Integer rtId=Integer.parseInt(req.getParameter("rtId"));
				form.setRtId(rtId);
			}
			dto.setIGRPT0201Form(form);
			dto=ctlBL.initUpdateReportTemplateAction(dto);
			req.getSession().setAttribute("ADmonitorObjectList", dto.getMonitorObjectList());
			req.getSession().setAttribute("ADDMX_KPI_List", dto.getDmx_list());
			req.getSession().setAttribute("ADIBM_KPI_List", dto.getIbm_list());
			req.getSession().setAttribute("ADCX_KPI_List", dto.getCx_list());
			IGRPT02011VO vo=new IGRPT02011VO();
			vo.setReportTemplateMappingList(dto.getSoc0206List());
			super.<IGRPT02011VO>setVO(req, vo);
			log.debug("===�Զ�����ģ�������ʾ����===");
		}
		if("MAPPINGINSERT".equals(mapping.getParameter())){
			//ȡ��01Form
			log.debug("===�Զ�����ģ�������ʾ��ʼ===");
			IGRPT0201Form form=(IGRPT0201Form)actionForm;
			dto.setIGRPT0201Form(form);
			ctlBL.updateSOC0206(dto);
			log.debug("===�Զ�����ģ�������ʾ����===");
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
