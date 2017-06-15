package com.deliverik.infogovernor.drm.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.drm.bl.IGDRM21BL;
import com.deliverik.infogovernor.drm.dto.IGDRM21DTO;
import com.deliverik.infogovernor.drm.form.IGDRM2105Form;
import com.deliverik.infogovernor.drm.vo.IGDRM21051VO;

public class IGDRM2105Action extends BaseAction {
	
	private static Log log = LogFactory.getLog(IGDRM2105Action.class);
	
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm aform,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		// FORM取得
		IGDRM2105Form form = (IGDRM2105Form) aform;
		// BL取得
		IGDRM21BL ctlBL = (IGDRM21BL) getBean("igdrm21BL");

		// DTO生成
		IGDRM21DTO dto = new IGDRM21DTO();
		
		dto.setForm(form);
		
		String p = mapping.getParameter();
		
		if(null != req.getParameter("btn_delete_sel")){
			log.debug("===============删除选择的预案信息开始================");
			
			dto = ctlBL.deleteSelectedSoc0118(dto);
			
			log.debug("===============删除选择的预案信息终了================");
		}
		
		// 判断是管理查询还是简单查询
		if("MANAGE".equals(p) || null != req.getParameter("MANAGE")){
			// 管理界面
			form.setMode("1");
			p = "SEARCH";
		}
		
		if("SEARCH".equals(p) || "SEARCH1".equals(p)){
			log.debug("===============查询预案信息开始================");
			getPaginDTO(req, "IGDRM2105");
			PagingDTO pDto = (PagingDTO) req.getAttribute("PagingDTO");
			dto.setPagingDto(pDto);

			if ("SEARCH1".equals(p)) {
				// 由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGDRM2105Form) req.getSession().getAttribute("IGDRM2105Form");
				if (form == null) {
					form = new IGDRM2105Form();
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
					form = (IGDRM2105Form) req.getSession().getAttribute("IGDRM2105Form");
					if (form != null) {
						form.setFromCount(0);
					}
				}
			}
			
			//获取查询最大记录数量
			int maxCnt = getMaxDataCount("IGDRM2105");
			dto.setMaxSearchCount(maxCnt);
			dto = ctlBL.searchSpecialPlanAction(dto);
			
			IGDRM21051VO vo = new IGDRM21051VO(dto.getSoc0118VWList());
			super.<IGDRM21051VO>setVO(req, vo);
			log.debug("===============查询预案信息终了================");
		}
		
		if("EXPORT".equals(mapping.getParameter())){
			log.debug("=================专项预案导出操作开始===================");
			dto.setResponse(res);
			dto = ctlBL.exportSpecialPlanAction(dto);
			log.debug("=================专项预案导出操作结束===================");
			return null;
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
