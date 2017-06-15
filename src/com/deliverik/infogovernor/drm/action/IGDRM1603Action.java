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
import com.deliverik.infogovernor.drm.bl.IGDRM16BL;
import com.deliverik.infogovernor.drm.dto.IGDRM16DTO;
import com.deliverik.infogovernor.drm.form.IGDRM1603Form;
import com.deliverik.infogovernor.drm.vo.IGDRM16021VO;

public class IGDRM1603Action extends BaseAction {
	static Log log = LogFactory.getLog(IGDRM1603Action.class);

	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionform, HttpServletRequest request,
			HttpServletResponse res) throws Exception {

		// 获得form
		IGDRM1603Form form = (IGDRM1603Form) actionform;

		// BL取得
		IGDRM16BL ctlBL = (IGDRM16BL) getBean("igdrm16BL");
		// DTO生成
		IGDRM16DTO dto = new IGDRM16DTO();
		dto.setIgdrm1603Form(form);
		// 修改
		if ("TOEDIT".equals(mapping.getParameter())) {
			log.debug("========事件更新取值处理开始========");

			dto = ctlBL.searchEventssByPK(dto);
			// 将查到的结果放到vo
			IGDRM16021VO vo = new IGDRM16021VO();
			vo.setEventssInfo(dto.getEventssInfo());
			super.setVO(request, vo);
			log.debug("========事件更新取值处理结束========");
		}
		
		if ("TOUPDATE".equals(mapping.getParameter())) {
			log.debug("========事件更新处理开始========");
			ctlBL.updateEventssAction(dto);	
			log.debug("========事件更新处理结束========");
		}
		
		if ("TOCHANGE".equals(mapping.getParameter())) {
			log.debug("========事件等级修改处理开始========");
			ctlBL.updateEventssLabelsAction(dto);	
			log.debug("========事件等级修改处理结束========");
		}
		return mapping.findForward("DISP");
	}

}
