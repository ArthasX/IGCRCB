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
import com.deliverik.infogovernor.soc.vir.bl.IGVIR04BL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR04DTO;
import com.deliverik.infogovernor.soc.vir.form.IGVIR0401Form;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 虚拟资源回收申请发起Action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGVIR0401Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//日志对象取得
		Log log = LogFactory.getLog(IGVIR0401Action.class);
		//BL取得
		IGVIR04BL ctlBL = (IGVIR04BL) getBean("igvir04BL");
		//实例化dto
		IGVIR04DTO dto = new IGVIR04DTO();
		//form取得
		IGVIR0401Form form = (IGVIR0401Form) actionForm;
		//登陆用户取得
		User user = (User) request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		//dto参数设定
		dto.setUser(user);
		dto.setPid(form.getPid());
		dto.setVmids(form.getVmids());
		//取得VM信息
		if("GETVM".equals(mapping.getParameter())){
			log.debug("===========取得VM信息操作开始===========");
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
			log.debug("===========取得VM信息操作结束===========");
		}
		//保存虚机操作
		if("SAVEVM".equals(mapping.getParameter())){
			log.debug("===========保存回收虚机信息操作开始=========");
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
			log.debug("===========保存回收虚机信息操作结束=========");
		}
		return null;
	}

}
