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
import com.deliverik.infogovernor.soc.vir.form.IGVIR3001Form;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: vCloud虚拟化资源申请发起Action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGVIR3001Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//日志对象取得
		Log log = LogFactory.getLog(IGVIR3001Action.class);
		//BL取得
		IGVIR30BL ctlBL = (IGVIR30BL) getBean("igvir30BL");
		//实例化dto
		IGVIR30DTO dto = new IGVIR30DTO();
		//form取得
		IGVIR3001Form form = (IGVIR3001Form) actionForm;
		//登陆用户取得
		User user = (User) request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		//dto参数设定
		dto.setUser(user);
		dto.setIgvir3001Form(form);
		//初始化发起页面信息
		if("DISP".equals(mapping.getParameter())){
			log.debug("==========基础信息初始化操作开始==========");
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
			log.debug("==========基础信息初始化操作结束==========");
		}
		//取得模板信息
		if("GETTEMPLATE".equals(mapping.getParameter())){
			log.debug("===========取得模板信息操作开始=========");
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
			log.debug("===========取得模板信息操作结束=========");
		}
		//保存模板信息
		if("SAVEVM".equals(mapping.getParameter())){
			log.debug("=========保存模板信息操作开始=========");
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
			log.debug("=========保存模板信息操作结束=========");
		}
		return null;
	}

}
