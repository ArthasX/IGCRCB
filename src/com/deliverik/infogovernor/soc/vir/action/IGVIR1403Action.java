/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.action;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.springframework.beans.BeanUtils;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.soc.vir.bl.IGVIR14BL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR14DTO;
import com.deliverik.infogovernor.soc.vir.form.IGVIR1403Form;
import com.deliverik.infogovernor.soc.vir.vo.IGVIR13011VO;
import com.deliverik.infogovernor.soc.vir.vo.IGVIR14031VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���м���ά���Action
 * </p>
 * 
 * @version 1.0
 */
public class IGVIR1403Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��־����ȡ��
		Log log = LogFactory.getLog(IGVIR1403Action.class);
		//BLȡ��
		IGVIR14BL ctlBL = (IGVIR14BL) getBean("igvir14BL");
		//ʵ����dto
		IGVIR14DTO dto = new IGVIR14DTO();
		//formȡ��
		IGVIR1403Form form = (IGVIR1403Form) actionForm;
		
		//ҳ���ʼ��������ʼ
		if("DISP".equals(mapping.getParameter())){
			log.debug("============== ���м���ά���ҳ���ʼ��������ʼ =============");
			dto = ctlBL.getProcessCountAction(dto);
			dto = ctlBL.searchProcessList(dto);
			
			IGVIR14031VO vo = new IGVIR14031VO();
			BeanUtils.copyProperties(dto, vo);
            super.<IGVIR14031VO>setVO(request, vo);
			
			log.debug("============== ���м���ά���ҳ���ʼ���������� =============");
		}
		if("GETVMCOUNT".equals(mapping.getParameter())){
			log.debug("============= ���м���ά�����ѯ������ʼ ============");
			
			Object actionPath = request.getAttribute("javax.servlet.forward.servlet_path");
			if (null != actionPath) {
			    form.setActionPath(actionPath.toString().replace(".do", ""));
			} else {
			    form.setActionPath("");
			}
			
			dto.setIgvir1403Form(form);
			
			dto = ctlBL.getVMCount4HostActon(dto);
			PrintWriter out = null;
            try {
                out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "utf-8"));
                out.print(dto.getVmcountJson());
            } catch (Exception e) {
                log.error("AjaxAction Exception", e);
            } finally {
                if (out != null){
                    out.close();
                }
            }
            log.debug("============= ���м���ά�����ѯ�������� ============");
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
