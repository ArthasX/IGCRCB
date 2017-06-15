/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.drm.bl.IGDRM15BL;
import com.deliverik.infogovernor.drm.dto.IGDRM15DTO;
import com.deliverik.infogovernor.drm.form.IGDRM1502Form;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description:培训计划操作Action
 * </p>
 * 
 * @author zhangying@deliverik.com
 * @version 1.0
 */
public class IGDRM1502Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM1502Action.class);

	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse res) throws Exception {

		// 实例化FORM
		IGDRM1502Form form = (IGDRM1502Form) actionForm;
		// 获取BL接口实例
		IGDRM15BL ctlBL = (IGDRM15BL) getBean("igdrm15BL");
		// 实例化DTO
		IGDRM15DTO dto = new IGDRM15DTO();  
		// 获取form
		dto.setIgdrm1502Form(form);	
		// 新增页面跳转
		if ("INSERT".equals(mapping.getParameter())) {
			log.debug("========培训计划/培训任务开始========");
			ctlBL.insertTrainplanAction(dto);
			log.debug("========培训计划新增结束========");
		}
		return mapping.findForward("DISP");
	}
}
