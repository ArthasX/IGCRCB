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
import com.deliverik.infogovernor.soc.vir.bl.IGVIR30BL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR30DTO;
import com.deliverik.infogovernor.soc.vir.form.IGVIR3002Form;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 虚拟化资源申请处理Action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGVIR3002Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//日志对象取得
		Log log = LogFactory.getLog(IGVIR3002Action.class);
		//BL取得
		IGVIR30BL ctlBL = (IGVIR30BL) getBean("igvir30BL");
		//实例化dto
		IGVIR30DTO dto = new IGVIR30DTO();
		//form取得
		IGVIR3002Form form = (IGVIR3002Form) actionForm;
		//登陆用户取得
		User user = (User) request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		//dto参数设定
		dto.setIgvir3002Form(form);
		dto.setUser(user);
		//取得vm信息
		if("GETVM".equals(mapping.getParameter())){
			log.debug("=============vm信息取得操作开始===========");
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
			log.debug("=============vm信息取得操作结束===========");
		}
		//部署日志
		if("GETDEPLOYLOG".equals(mapping.getParameter())){
			log.debug("===========部署日志查询操作开始==========");
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
			log.debug("===========部署日志查询操作结束==========");
		}
		return null;
	}

}
