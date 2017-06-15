/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.action;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.soc.vir.bl.IGVIR30BL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR30DTO;
import com.deliverik.infogovernor.soc.vir.form.IGVIR3002Form;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���⻯��Դ���봦��Action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGVIR3002Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��־����ȡ��
		Log log = LogFactory.getLog(IGVIR3002Action.class);
		//BLȡ��
		IGVIR30BL ctlBL = (IGVIR30BL) getBean("igvir30BL");
		//ʵ����dto
		IGVIR30DTO dto = new IGVIR30DTO();
		//formȡ��
		IGVIR3002Form form = (IGVIR3002Form) actionForm;
		//��½�û�ȡ��
		User user = (User) request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		//dto�����趨
		dto.setIgvir3002Form(form);
		dto.setUser(user);
		//ȡ��vm��Ϣ
		if("GETVM".equals(mapping.getParameter())){
			log.debug("=============vm��Ϣȡ�ò�����ʼ===========");
			PrintWriter out = null;
	        try {
                out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "utf-8"));
                dto = ctlBL.getApplyVMInfAction(dto);
                out.print(dto.getJsonResult());
            } catch (Exception e) {
                log.error("AjaxAction Exception", e);
            } finally {
                if (out != null){
                    out.close();
                }
            }
			log.debug("=============vm��Ϣȡ�ò�������===========");
		}
		//������־
		if("GETDEPLOYLOG".equals(mapping.getParameter())){
			log.debug("===========������־��ѯ������ʼ==========");
			dto = ctlBL.searchDeployLogAction(dto);
			PrintWriter out = null;
            try {
                out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "utf-8"));
                out.print(dto.getJsonResult());
            } catch (Exception e) {
                log.error("AjaxAction Exception", e);
            } finally {
                if (out != null){
                    out.close();
                }
            }
			log.debug("===========������־��ѯ��������==========");
		}
		return null;
	}

}
