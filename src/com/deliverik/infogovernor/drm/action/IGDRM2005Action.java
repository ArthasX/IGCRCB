package com.deliverik.infogovernor.drm.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.drm.bl.IGDRM20BL;
import com.deliverik.infogovernor.drm.dto.IGDRM20DTO;
import com.deliverik.infogovernor.drm.vo.IGDRM20011VO;
import com.deliverik.infogovernor.drm.vo.IGDRM20021VO;
import com.google.gson.Gson;

public class IGDRM2005Action extends BaseAction {

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		IGDRM20DTO dto = new IGDRM20DTO();

		IGDRM20BL ctlBL = (IGDRM20BL) getBean("igdrm20BL");

		dto.setForm(form);

		String p = mapping.getParameter();
		if ("DISP".equals(p)) {
			dto = ctlBL.initEntityAction(dto);
			IGDRM20011VO vo = new IGDRM20011VO(dto.getEntity());
			req.getSession().setAttribute("IGDRM20011VO", vo);
		} else if ("DEL_AJAX".equals(p)) {
			try {
				dto = ctlBL.deletePlanOfEntity(dto);
				success(res);
			} catch (Exception ex) {
				failed(res);
			}
			return null;
		} else if ("RENAME_AJAX".equals(p)) {
			try {
				dto = ctlBL.renamePlanOfEntity(dto);
				success(res);
			} catch (Exception ex) {
				failed(res);
			}
			return null;
		}
		else if("DETAIL".equals(p)){
			dto = ctlBL.getPlanTreeDetail(dto);
			Gson gson = new Gson();
			String json = gson.toJson(dto.getPlanSectionTree());
			IGDRM20021VO vo = new IGDRM20021VO();
			vo.setPlanSectionTreeJson(json);
			super.<IGDRM20021VO>setVO(req, vo);
		}
		return mapping.findForward(p);
	}
	
	/**
	 * 输出字符‘success’到页面，标识成功
	 * @param res
	 */
	private void success(HttpServletResponse res){
		out("success", res);
	}
	
	/**
	 * 输出字符‘failed’到页面，标识失败
	 * @param res
	 */
	private void failed(HttpServletResponse res){
		out("failed", res);
	}
	
	/**
	 * 输出字符到页面
	 * @param msg
	 * @param res
	 */
	private void out(String msg, HttpServletResponse res){
		try {
			res.setContentType("text/html");
			res.setCharacterEncoding("UTF-8");
	        PrintWriter out = res.getWriter();
	        Gson gson = new Gson();
        	out.print(gson.toJson(msg));
        	out.flush();
        	out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
