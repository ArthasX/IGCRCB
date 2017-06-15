/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.action;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.nms.bl.IGNMS01BL;
import com.deliverik.infogovernor.nms.bl.task.NMSBaseBLImpl;
import com.deliverik.infogovernor.nms.dto.IGNMS01DTO;
import com.deliverik.infogovernor.nms.event.IGNMS0101Pushlet;
import com.deliverik.infogovernor.nms.form.IGNMS0101Form;

/**
 * 概述: 自动发现Action
 * 功能描述: 自动发现Action
 * 创建记录: 2013/12/20
 * 修改记录:
 */
public class IGNMS0101Action extends BaseAction {
    static Log log = LogFactory.getLog(IGNMS0101Action.class);

    public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
		IGNMS0101Form form = (IGNMS0101Form) actionForm;
        IGNMS01BL ctlBL = (IGNMS01BL) getBean("ignms01BL");
        IGNMS01DTO dto = new IGNMS01DTO();
        User user = (User) request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
        if(form.getGid() == null || form.getGid() == 0) {
        	form.setGid(NMSBaseBLImpl.GROUPID_DEFAULT);//默认组ID
        }
        dto.setGroupId(form.getGid());
        dto.setShowType(form.getShowtype());
        String parameter = mapping.getParameter();
        if("DISP".equals(parameter)){
            log.debug("=========== 显示拓扑开始 ==========");
            //组版本
            form.setGversion(ctlBL.searchGroupVersionAction(dto).getGroupVersion());
            log.debug("=========== 显示拓扑开始 ==========");
        } if("ManualScan".equals(parameter)){
            log.debug("=========== 启动拓扑扫描开始 ==========");
            PrintWriter out = null;
            int flag = 0;
            try {
                out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "utf-8"));
                flag = ctlBL.execCommandAction(dto).getFlag();
            } catch (Exception e) {
                log.error("AjaxAction Exception", e);
            } finally {
            	if(flag == 1) {
            		out.print("扫描程序启动成功！");
            	} else if(flag == -1) {
            		out.print("扫描程序执行文件不存在！");
            	} else {
            		out.print("扫描程序启动失败！");
            	}
                if (out != null)
                    out.close();
            }
            log.debug("=========== 启动拓扑扫描结束 ==========");
            return null;
        } else if ("GET_TOPOXML".equals(parameter)) {
            log.debug("=========== 显示拓扑开始 ==========");
            Integer gversion_int = form.getGversion();
            String topotype = form.getTopotype();
            PrintWriter out = null;
            try {
                dto.setGroupVersion(gversion_int);
                dto.setTopoType(topotype);
            	// 显示拓扑
            	dto.setUserid(user.getUserid());
            	dto = ctlBL.searchTopoXML(dto);
                out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "utf-8"));
                out.print(dto.getXml());
            } catch (Exception e) {
            	if (out != null)
            		out.print("");
                log.error("AjaxAction Exception", e);
            } finally {
                if (out != null)
                    out.close();
            }
            log.debug("=========== 显示拓扑结束 ==========");
            return null;
        } else if ("SAVE".equals(parameter)) {
            PrintWriter out = null;
            try {
                // 显示拓扑
                ctlBL.saveTopoXML(dto);
                out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "utf-8"));
                out.print("保存拓扑图成功");
            } catch (Exception e) {
                if (out != null)
                    out.print("保存拓扑图失败");
                log.error("AjaxAction Exception", e);
            } finally {
                if (out != null)
                    out.close();
            }
            return null;
        }
        // 更新拓扑
        else if ("UPDATE_AIXS".equals(parameter)) {
            log.debug("=========== 更新拓扑设备坐标开始 ==========");
            Integer gversion_int = form.getGversion();
            String topotype = form.getTopotype();
            String updateDevice = form.getUpdateDevice();
            PrintWriter out = null;
            try {
                out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "utf-8"));
                // 显示拓扑
                dto.setGroupVersion(gversion_int);
                dto.setTopoType(topotype);
                dto.setUserid(user.getUserid());
                dto.setUpdateDevice(updateDevice);
                dto.setAddDevice(form.getAddDevice());
                dto.setDelDevice(form.getDelDevice());
                dto.setAddRela(form.getAddRela());
                dto.setDelRela(form.getDelRela());
                dto.setRenameDevice(form.getRenameDevice());
                dto.setSubNetRegion(form.getRegionStr());
                dto.setUpdateRegionStr(form.getUpdateRegionStr());
                dto.setDelRegionStr(form.getDelRegionStr());
                dto = ctlBL.saveTopoInfo(dto);
//                out.print(dto.getXml());
                out.print("保存拓扑图成功！");
            } catch (Exception e) {
                if (out != null) {
                    out.print("保存拓扑图失败！");
                }
                log.error("AjaxAction Exception", e);
            } finally {
                if (out != null)
                    out.close();
            }
            log.debug("=========== 更新拓扑设备坐标结束 ==========");
            return null;

        }
        // 获取面板大小
        else if ("GET_PANELSIZE".equals(parameter)) {
            log.debug("=========== 获取面板大小开始 ==========");
            Integer gversion_int = form.getGversion();
            String topotype = form.getTopotype();
            PrintWriter out = null;
            try {
                out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "utf-8"));
                // 显示拓扑
                dto.setGroupVersion(gversion_int);
                dto.setTopoType(topotype);
                dto.setUserid(user.getUserid());
                dto = ctlBL.getPanelSize(dto);
                out.print(dto.getPanelSizeInfoXml());
            } catch (Exception e) {
                out.print("");
                log.error("AjaxAction Exception", e);
            } finally {
                if (out != null)
                    out.close();
            }
            log.debug("=========== 获取面板大小结束 ==========");
            return null;
        }
        // 更新面板
        else if ("UPDATE_PANELSIZE".equals(parameter)) {
            log.debug("=========== 更新面板大小开始 ==========");
            Integer gversion_int = form.getGversion();
            String topotype = form.getTopotype();
            PrintWriter out = null;
            try {
                out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "utf-8"));
                // 显示拓扑
                dto.setGroupVersion(gversion_int);
                dto.setTopoType(topotype);
                dto.setUserid(user.getUserid());
                dto.setPanelSize(form.getPanelSize());
                dto = ctlBL.updatePanelSize(dto);
                out.print("更新面板大小成功");
            } catch (Exception e) {
                out.print("更新面板大小失败！");
                log.error("AjaxAction Exception", e);
            } finally {
                if (out != null)
                    out.close();
            }
            log.debug("=========== 更新面板大小结束 ==========");
            return null;
            
        }

        return mapping.findForward("DISP");
    }

}
