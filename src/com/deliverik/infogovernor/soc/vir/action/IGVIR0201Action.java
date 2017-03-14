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
import com.deliverik.infogovernor.soc.vir.bl.IGVIR02BL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR02DTO;
import com.deliverik.infogovernor.soc.vir.form.IGVIR0201Form;

/**
 * ����: ��Դ���� ��������: ���⻯������ʾAction ������¼: 2013/12/25 �޸ļ�¼:
 */
public class IGVIR0201Action extends BaseAction {

    static Log log = LogFactory.getLog(IGVIR0201Action.class);

    /**
     * ���ð�����ϵ��ʾ����
     * 
     * @param mapping
     *            ActionMapping
     * @param actionForm
     *            ActionForm
     * @param req
     *            HttpServletRequest
     * @param res
     *            HttpServletResponse
     * @return ActionForward
     * @throws Exception
     */
    @Override
    public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req,
            HttpServletResponse res) throws Exception {
        // BLȡ��
        IGVIR02BL ctlBL = (IGVIR02BL) getBean("igvir02BL");

        IGVIR0201Form form = (IGVIR0201Form) actionForm;
        
        // DTO����
        IGVIR02DTO dto = new IGVIR02DTO();
        
        User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);

        if ("GETTEMPLATE".equals(mapping.getParameter())) {
            log.debug("======== ��Դ��������ģ����Ϣ��ѯ��ʼ========");

            PrintWriter out = null;
            try {
                out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
                dto = ctlBL.getTemplate(dto);
                out.print(dto.getTemplateJson());
            } catch (Exception e) {
                log.error("AjaxAction Exception", e);
            } finally {
                if (out != null){
                    out.close();
                }
            }
            log.debug("======== ��Դ��������ģ����Ϣ��ѯ����========");
            return null;
        } 
        
        else if ("SAVEVM".equals(mapping.getParameter())) {
            log.debug("============= �������������Ϣ����ʼ ===========");
            dto.setUser(user);
            dto.setIgvir0201Form(form);
            System.out.println(form);
            dto = ctlBL.saveApplyVMInfo(dto);
            PrintWriter out = null;
            try {
                out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
                out.print(dto.getVim02info().getId() + "@_@" + dto.getVmids());
            } catch (Exception e) {
                log.error("AjaxAction Exception", e);
            } finally {
                if (out != null){
                    out.close();
                }
            }
            log.debug("============= �������������Ϣ������� ===========");
            return null;
        }
        return mapping.findForward("DISP");
    }
}
