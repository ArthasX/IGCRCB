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
import com.deliverik.infogovernor.drm.form.IGDRM1604Form;
import com.deliverik.infogovernor.drm.vo.IGDRM16021VO;

public class IGDRM1604Action extends BaseAction {
	static Log log = LogFactory.getLog(IGDRM1604Action.class);

	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionform, HttpServletRequest request,
			HttpServletResponse res) throws Exception {

		// 获得form
		IGDRM1604Form form = (IGDRM1604Form) actionform;

		// BL取得
		IGDRM16BL ctlBL = (IGDRM16BL) getBean("igdrm16BL");
		// DTO生成
		IGDRM16DTO dto = new IGDRM16DTO();
		//dto.setForm(form);
		dto.setIgdrm1604Form(form);
		// 修改
		if ("TOEDIT".equals(mapping.getParameter())) {
			log.debug("========事件更新取值处理开始========");

			dto = ctlBL.searchEventssByPK(dto);
			// 将查到的结果放到vo
			IGDRM16021VO vo = new IGDRM16021VO();
			vo.setEventssInfo(dto.getEventssInfo());
			vo.setScopeInfoList(dto.getScopesInfoList());
			super.setVO(request, vo);
			log.debug("========事件更新取值处理结束========");
		}
		
		if ("EDIT".equals(mapping.getParameter())) {
			log.debug("========事件影响范围添加处理开始========");
			// 调用BL新增
			IGDRM16021VO vo = new IGDRM16021VO();
            ctlBL.editScopeAction(dto);
			vo.setScopeInfoList(dto.getScopesInfoList());
			super.setVO(request, vo);
			log.debug("========事件影响范围添加处理结束========");
		}
		return mapping.findForward("DISP");
	}

}
