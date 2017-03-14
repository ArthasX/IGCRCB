package com.deliverik.infogovernor.drm.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.drm.bl.IGDRM20BL;
import com.deliverik.infogovernor.drm.dto.IGDRM20DTO;
import com.deliverik.infogovernor.drm.form.IGDRM2004Form;
import com.deliverik.infogovernor.drm.vo.IGDRM20041VO;

/**
 * 
 * @author baixiaoguang
 *
 */

public class IGDRM2004Action extends BaseAction {

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm aform,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		// FORM取得
		IGDRM2004Form form = (IGDRM2004Form) aform;
		// BL取得
		IGDRM20BL ctlBL = (IGDRM20BL) getBean("igdrm20BL");
		// DTO取得
		IGDRM20DTO dto = new IGDRM20DTO();
		String p = mapping.getParameter();
		dto.setForm(form);


		if ("SEARCH".equals(p) || "SEARCH1".equals(p)) {
			// 拷贝筛选条件
			getPaginDTO(req, "IGDRM2004");
			PagingDTO pDto = (PagingDTO) req.getAttribute("PagingDTO");
			dto.setPagingDTO(pDto);

			if ("SEARCH1".equals(p)) {
				// 由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGDRM2004Form) req.getSession().getAttribute(
						"IGDRM2004Form");
				if (form == null) {
					form = new IGDRM2004Form();
				} else {
					if (req.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} else {
				if (req.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					form = (IGDRM2004Form) req.getSession().getAttribute(
							"IGDRM2004Form");
					if (form != null) {
						form.setFromCount(0);
					}
				}
			}
			dto = ctlBL.searchPlanAction(dto);

			IGDRM20041VO vo = new IGDRM20041VO(dto.getSoc0117List());
			super.<IGDRM20041VO> setVO(req, vo);
		} else if ("START".equals(p)) {
			dto = ctlBL.startAction(dto);
		} else if ("STOP".equals(p)) {
			dto = ctlBL.stopAction(dto);
		} else if ("COPY".equals(p)){
			dto = ctlBL.copyAction(dto);
		}
		// 逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();

		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(req, message);
			}
		}
		return mapping.findForward("DISP");
	}
}
