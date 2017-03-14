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
import com.deliverik.infogovernor.soc.vir.form.IGVIR3001Form;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: vCloud���⻯��Դ���뷢��Action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGVIR3001Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��־����ȡ��
		Log log = LogFactory.getLog(IGVIR3001Action.class);
		//BLȡ��
		IGVIR30BL ctlBL = (IGVIR30BL) getBean("igvir30BL");
		//ʵ����dto
		IGVIR30DTO dto = new IGVIR30DTO();
		//formȡ��
		IGVIR3001Form form = (IGVIR3001Form) actionForm;
		//��½�û�ȡ��
		User user = (User) request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		//dto�����趨
		dto.setUser(user);
		dto.setIgvir3001Form(form);
		//��ʼ������ҳ����Ϣ
		if("DISP".equals(mapping.getParameter())){
			log.debug("==========������Ϣ��ʼ��������ʼ==========");
			PrintWriter out = null;
            try {
                out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "utf-8"));
                dto = ctlBL.initBasicInfoAction(dto);
                out.print(dto.getJsonResult());
            } catch (Exception e) {
                log.error("AjaxAction Exception", e);
            } finally {
                if (out != null){
                    out.close();
                }
            }
			log.debug("==========������Ϣ��ʼ����������==========");
		}
		//ȡ��ģ����Ϣ
		if("GETTEMPLATE".equals(mapping.getParameter())){
			log.debug("===========ȡ��ģ����Ϣ������ʼ=========");
			PrintWriter out = null;
            try {
                out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "utf-8"));
                dto = ctlBL.searchTemplateAction(dto);
                out.print(dto.getJsonResult());
            } catch (Exception e) {
                log.error("AjaxAction Exception", e);
            } finally {
                if (out != null){
                    out.close();
                }
            }
			log.debug("===========ȡ��ģ����Ϣ��������=========");
		}
		//����ģ����Ϣ
		if("SAVEVM".equals(mapping.getParameter())){
			log.debug("=========����ģ����Ϣ������ʼ=========");
			dto = ctlBL.saveApplyVMInfoAction(dto);
			PrintWriter out = null;
            try {
                out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "utf-8"));
                out.print(dto.getVcd02().getId() + "@_@" + dto.getVmids());
            } catch (Exception e) {
                log.error("AjaxAction Exception", e);
            } finally {
                if (out != null){
                    out.close();
                }
            }
			log.debug("=========����ģ����Ϣ��������=========");
		}
		return null;
	}

}
