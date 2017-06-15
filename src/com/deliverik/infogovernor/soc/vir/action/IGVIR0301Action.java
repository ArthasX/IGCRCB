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
import com.deliverik.infogovernor.soc.vir.bl.IGVIR03BL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR03DTO;
import com.deliverik.infogovernor.soc.vir.form.IGVIR0301Form;

/**
 * 概述: 资源调整<br/> 
 * 功能描述: 资源调整查询项目列表Action<br/> 
 * 创建记录: 2014/02/14<br/> 
 * 修改记录:<br/>
 */
public class IGVIR0301Action extends BaseAction {

    static Log log = LogFactory.getLog(IGVIR0301Action.class);

    /**
     * 显示处理
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
    	//实例化FORM
        IGVIR0301Form form = (IGVIR0301Form)actionForm;
    	
        // BL取得
        IGVIR03BL ctlBL = (IGVIR03BL) getBean("igvir03BL");
        
        // DTO生成
        IGVIR03DTO dto = new IGVIR03DTO();
        
        User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
        dto.setUser(user);
        if ("GETVM".equals(mapping.getParameter())) {
            log.debug("======== 查询项目和虚机信息开始 ========");
            dto.setPid(form.getPid() + "");
            PrintWriter out = null;
            try {
                out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
                dto = ctlBL.getApplyVMInf(dto);
                out.print(dto.getVmInfo_json());
            } catch (Exception e) {
                log.error("AjaxAction Exception", e);
            } finally {
                if (out != null){
                    out.close();
                }
            }
            
            log.debug("======== 查询项目和虚机信息结束 ========");
            return null;
        } else if ("SAVEVM".equals(mapping.getParameter())) {
            log.debug("============= 保存调整后虚机信息处理开始 ===========");
            dto.setIgvir0301Form(form);
            dto = ctlBL.saveApplyVMInfo(dto);
            PrintWriter out = null;
            try {
                out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
            } catch (Exception e) {
                log.error("AjaxAction Exception", e);
            } finally {
                if (out != null){
                    out.close();
                }
            }
            log.debug("============= 保存调整后虚机信息处理结束 ===========");
            return null;
        }
        
        
        return mapping.findForward("DISP");
    }
}
