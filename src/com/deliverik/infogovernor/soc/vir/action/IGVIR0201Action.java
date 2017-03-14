/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
 * 概述: 资源申请 功能描述: 虚拟化管理显示Action 创建记录: 2013/12/25 修改记录:
 */
public class IGVIR0201Action extends BaseAction {

    static Log log = LogFactory.getLog(IGVIR0201Action.class);

    /**
     * 配置包含关系显示处理
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
        // BL取得
        IGVIR02BL ctlBL = (IGVIR02BL) getBean("igvir02BL");

        IGVIR0201Form form = (IGVIR0201Form) actionForm;
        
        // DTO生成
        IGVIR02DTO dto = new IGVIR02DTO();
        
        User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);

        if ("GETTEMPLATE".equals(mapping.getParameter())) {
            log.debug("======== 资源申请虚拟模板信息查询开始========");

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
            log.debug("======== 资源申请虚拟模板信息查询结束========");
            return null;
        } 
        
        else if ("SAVEVM".equals(mapping.getParameter())) {
            log.debug("============= 保存申请虚机信息处理开始 ===========");
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
            log.debug("============= 保存申请虚机信息处理结束 ===========");
            return null;
        }
        return mapping.findForward("DISP");
    }
}
