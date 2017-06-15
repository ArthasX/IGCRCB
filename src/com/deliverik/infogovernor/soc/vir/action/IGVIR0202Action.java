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
import com.deliverik.infogovernor.soc.vir.bl.IGVIR02BL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR02DTO;
import com.deliverik.infogovernor.soc.vir.form.IGVIR0202Form;

/**
 * 概述: 资源申请<br/> 
 * 功能描述: 虚拟化管理显示Action<br/> 
 * 创建记录: 2013/12/25<br/> 
 * 修改记录:<br/>
 */
public class IGVIR0202Action extends BaseAction {

    static Log log = LogFactory.getLog(IGVIR0202Action.class);

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

        IGVIR0202Form form = (IGVIR0202Form) actionForm;
        
        // DTO生成
        IGVIR02DTO dto = new IGVIR02DTO();

        if ("GETVM".equals(mapping.getParameter())) {
            log.debug("======== 资源申请虚拟信息查询开始========");
            dto.setPid(form.getPid());
            dto.setPrid(form.getPrid());
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
            log.debug("======== 资源申请虚拟信息查询结束========");
            return null;
        } 
        else if ("SAVEVM".equals(mapping.getParameter())) {
            log.debug("============= 保存申请虚机信息处理开始 ===========");
            dto.setIgvir0202Form(form);
            System.out.println(form);
            dto = ctlBL.saveVMInfo4Approve(dto);
//            PrintWriter out = null;
//            try {
//                out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
//            } catch (Exception e) {
//                log.error("AjaxAction Exception", e);
//            } finally {
//                if (out != null){
//                    out.close();
//                }
//            }
            log.debug("============= 保存申请虚机信息处理结束 ===========");
            return null;
        }
        // 根据vCenter查询主机列表
        else if ("GETHOSTLIST".equals(mapping.getParameter())) {
            log.debug("============= 根据vCenter查询主机列表开始 ===========");
            dto.setVcid(form.getVcid());
            dto = ctlBL.searchHostByVcid(dto);
            PrintWriter out = null;
            try {
                out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
                out.print(dto.getHostlist_json());
            } catch (Exception e) {
                log.error("AjaxAction Exception", e);
            } finally {
                if (out != null){
                    out.close();
                }
            }
            log.debug("============= 根据vCenter查询主机列表结束 ===========");
            return null;
        }
        // 根据主机IP查询网络列表
        else if ("GETNETLIST".equals(mapping.getParameter())) {
            log.debug("============= 根据主机IP查询网络列表开始 ===========");
            dto.setVcid(form.getVcid());
            dto.setDcname(form.getDcname());
            dto = ctlBL.searchNetLabelByDatacenter(dto);
            PrintWriter out = null;
            try {
                out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
                out.print(dto.getNetLabel_json());
            } catch (Exception e) {
                log.error("AjaxAction Exception", e);
            } finally {
                if (out != null){
                    out.close();
                }
            }
            log.debug("============= 根据主机IP查询网络列表结束 ===========");
            return null;
        }
        // 查询数据中心
        else if ("GETDATACENTER".equals(mapping.getParameter())) {
            log.debug("============= 根据vCenter查询数据中心列表开始 ===========");
            dto.setVcid(form.getVcid());
            dto = ctlBL.searchDatacenterByVcid(dto);
            PrintWriter out = null;
            try {
                out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
                out.print(dto.getDatacenter_json());
            } catch (Exception e) {
                log.error("AjaxAction Exception", e);
            } finally {
                if (out != null){
                    out.close();
                }
            }
            log.debug("============= 根据vCenter查询数据中心列表结束 ===========");
            return null;
        }
        // 查询资源池
        else if ("GETRESOURCEPOOL".equals(mapping.getParameter())) {
            log.debug("============= 根据vCenter查询资源池列表开始 ===========");
            dto.setVcid(form.getVcid());
            dto = ctlBL.searchResourcePoolByVcid(dto);
            PrintWriter out = null;
            try {
                out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
                out.print(dto.getResourcePool_json());
            } catch (Exception e) {
                log.error("AjaxAction Exception", e);
            } finally {
                if (out != null){
                    out.close();
                }
            }
            log.debug("============= 根据vCenter查询资源池列表结束 ===========");
            return null;
        }
        // 查询部署日志
        else if ("GETDEPLOYLOG".equals(mapping.getParameter())) {
            log.debug("============= 查询部署日志列表开始 ===========");
            dto.setPid(form.getPid());
            dto = ctlBL.searchDeployLog(dto);
            PrintWriter out = null;
            try {
                out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
                out.print(dto.getDeployLog_json());
            } catch (Exception e) {
                log.error("AjaxAction Exception", e);
            } finally {
                if (out != null){
                    out.close();
                }
            }
            log.debug("============= 查询部署日志列表结束 ===========");
            return null;
        }
        
        return mapping.findForward("DISP");
    }
}
