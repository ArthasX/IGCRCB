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
import com.deliverik.infogovernor.soc.vir.bl.IGVIR04BL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR04DTO;
import com.deliverik.infogovernor.soc.vir.form.IGVIR0401Form;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ������Դ�������뷢��Action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGVIR0401Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��־����ȡ��
		Log log = LogFactory.getLog(IGVIR0401Action.class);
		//BLȡ��
		IGVIR04BL ctlBL = (IGVIR04BL) getBean("igvir04BL");
		//ʵ����dto
		IGVIR04DTO dto = new IGVIR04DTO();
		//formȡ��
		IGVIR0401Form form = (IGVIR0401Form) actionForm;
		//��½�û�ȡ��
		User user = (User) request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		//dto�����趨
		dto.setUser(user);
		dto.setPid(form.getPid());
		dto.setVmids(form.getVmids());
		//ȡ��VM��Ϣ
		if("GETVM".equals(mapping.getParameter())){
			log.debug("===========ȡ��VM��Ϣ������ʼ===========");
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
			log.debug("===========ȡ��VM��Ϣ��������===========");
		}
		//�����������
		if("SAVEVM".equals(mapping.getParameter())){
			log.debug("===========������������Ϣ������ʼ=========");
			dto = ctlBL.saveRecycleVMInfoAction(dto);
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
			log.debug("===========������������Ϣ��������=========");
		}
		return null;
	}

}
