/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.rpt.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.MessageResources;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.rpt.bl.IGRPT04BL;
import com.deliverik.infogovernor.rpt.dto.IGRPT04DTO;
import com.deliverik.infogovernor.rpt.form.IGRPT0402Form;

/**
 * ����: ����ͳ�Ʋ���Action
 * ������¼:����ȫ 2012/10/29
 * �޸ļ�¼: 
 */
public class IGRPT0402Action extends BaseAction{
	
	static Log log = LogFactory.getLog(IGRPT0402Action.class);
	
	protected MessageResources syresources = MessageResources.getMessageResources("SystemConfigResources");
    
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
	    
	    //BLȡ��
		IGRPT04BL ctlBL = (IGRPT04BL) getBean("igrpt04BL");
		
		IGRPT0402Form form=(IGRPT0402Form) actionForm;
		
		//DTO����
		IGRPT04DTO dto = new IGRPT04DTO();
		
		dto.setIgrpt0402Form(form);
		
		if("DISP".equals(mapping.getParameter())){
		    
		    String temName = form.getTemplateName();
		    
		    // ���Ʊ�����������ȡ�ñ���ģ������
		    if ("0".equals(form.getIsFlag())) {
		        //����ģ���ѯcid�趨
		        dto.setTemName(temName);
		        //���������Ϣ���ѯ�����趨
		        dto.setRfdid(form.getRfdid());
		        //�����������Ϣȡ��
		        dto = ctlBL.getCustomConfigurationInfo(dto);
		        //�趨���Ʊ���ı���ģ������
		        temName = dto.getTemName();
		        //���Ʊ�������趨
                form.setTemplateName(temName);
                form.setPdid(dto.getPdid());
                form.setPsdcode(dto.getPsdcode());
                form.setPidid(dto.getPidid());
                form.setPidvalue(dto.getPidvalue());
                form.setTitle(dto.getTitle());
		    }
			
			//�ж���������
			if(StringUtils.isNotEmpty(form.getRfdpictype())){
				if("0".equals(form.getRfdpictype())){
					//���
					temName=temName+"_table";
				}else if("1".equals(form.getRfdpictype())){
					//����
					temName=temName+"_bar";
				}else if("2".equals(form.getRfdpictype())){
					//��ͼ
					temName=temName+"_pie";
				}else if("3".equals(form.getRfdpictype())){
					//��ͼ
					temName=temName+"_line";
				}
			}
			if (StringUtils.isEmpty(dto.getTreeFormLevel2())) {
			    form.setReportPath(syresources.getMessage("BIRT_REPORT_PATH")+form.getTemplateName()+"/1/"+temName+".rptdesign");
			} else {
			    form.setReportPath(syresources.getMessage("BIRT_REPORT_PATH")+form.getTemplateName()+"/2/"+temName+".rptdesign");
			}
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
