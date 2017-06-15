/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.fxk.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.infogovernor.fxk.bl.IGFXK07BL;
import com.deliverik.infogovernor.fxk.dto.IGFXK07DTO;
import com.deliverik.infogovernor.fxk.form.IGFXK0700Form;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 风险管理_风险提示管理_ACTION
 * </p>
 * 
 * @author zhangq@deliverik.com
 * @version 1.0
 */

public class IGFXK0702Action extends BaseAction {

	/** 日志参数 */
	private static Log log = LogFactory.getLog(IGFXK0701Action.class);

	/** 页面跳转参数设定 */
	private final String forward = "DISP";

	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse res) throws Exception {
		log.debug("=======================风险提示管理开始=======================");
		IGFXK0700Form form = (IGFXK0700Form) actionForm;

		/** dto */
		IGFXK07DTO dto = new IGFXK07DTO();
		
		dto.setForm(form);
		dto.setAttachFile(form);
		// 获取BL接口实例
		IGFXK07BL ctrlBL = (IGFXK07BL) getBean("igFXK07BL");
		
		// 初始化页面
		if ("DISP".equals(mapping.getParameter())) {

			User user = (User) request.getSession().getAttribute(
					SESSION_KEY_LOGIN_USER);
			form.setNuserid(user.getUserid());
			form.setNusername(user.getUsername());
			form.setNorgid(user.getOrgid());
			form.setNorgname(user.getOrgname());
			form.setNtime(CommonDefineUtils.DATE_FORMAT.format(new Date()));
			form.setNtel(user.getUsermobile());
			log.debug("========通知新增画面初期显示处理开始========");
			addMessage(request, new ActionMessage("IGCO10000.I001", "风险提示基本信息"));
			saveToken(request);
			log.debug("========通知新增画面初期显示处理终了========");
		} else if ("INSERT".equals(mapping.getParameter())) {

			if (isTokenValid(request, true)) {
				/** 调用BL添加新提示 */
				ctrlBL.addRiskmanagerwaring(dto);
				log.debug("=======签到管理查询处理结束========");
			} else {
				addMessage(request, new ActionMessage("IGCO00000.E007"));

			}
		}

		return mapping.findForward(forward);
	}
}
