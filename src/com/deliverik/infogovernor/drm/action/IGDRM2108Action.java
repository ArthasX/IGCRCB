package com.deliverik.infogovernor.drm.action;

import java.io.PrintWriter;
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
import com.deliverik.infogovernor.drm.IGDRMCONSTANTS;
import com.deliverik.infogovernor.drm.bl.IGDRM21BL;
import com.deliverik.infogovernor.drm.dto.IGDRM21DTO;
import com.deliverik.infogovernor.drm.form.IGDRM2108Form;

/**
 * 预案查看和导出Action
 * 
 * @author zhangjian
 *
 */
public class IGDRM2108Action extends BaseAction {
	
	private static Log log = LogFactory.getLog(IGDRM2108Action.class);
	
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm aform,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		// FORM取得
		IGDRM2108Form form = (IGDRM2108Form) aform;
		// BL取得
		IGDRM21BL ctlBL = (IGDRM21BL) getBean("igdrm21BL");

		// DTO生成
		IGDRM21DTO dto = new IGDRM21DTO();
		
		dto.setForm(form);
		
		if ("AJAX".equals(mapping.getParameter())) {

			log.info("===========ajax查询预案目录内容开始=============");
			res.setCharacterEncoding("UTF-8");

			res.setContentType("text/html; charset=utf-8");

			PrintWriter writer = res.getWriter();

			try {

				if (IGDRMCONSTANTS.PLAN_DIR_TYPE_TEXT.equals(form.getCtype())) {
					// 如果是富文本类型直接查询数据库

					dto = ctlBL.loadPlanTextContent(dto);

					if (dto.getSoc0507Info() != null) {
						dto.setResultHTML(dto.getSoc0507Info().getCivalue());
					}


				} else if (IGDRMCONSTANTS.PLAN_DIR_TYPE_SCENE.equals(form.getCtype())) {
					// 场景

					dto = ctlBL.loadPlanScenceHtml(dto);

				} else if (IGDRMCONSTANTS.PLAN_DIR_TYPE_RESOURCE.equals(form.getCtype())) {
					// 应急资源

				} else if (IGDRMCONSTANTS.PLAN_DIR_TYPE_ORG.equals(form.getCtype())) {
					// 组织架构

					ctlBL.loadPlanOrgHTML(dto);
				}

				writer.write(dto.getResultHTML() == null ? "" : dto.getResultHTML());

			} catch (Exception e) {
				writer.write("加载信息出错!");
				e.printStackTrace();
			}

			log.info("===========ajax查询预案目录内容完成=============");

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
