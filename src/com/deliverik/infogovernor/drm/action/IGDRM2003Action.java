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
import com.deliverik.infogovernor.drm.bl.IGDRM20BL;
import com.deliverik.infogovernor.drm.dto.IGDRM20DTO;
import com.deliverik.infogovernor.drm.form.IGDRM2003Form;
import com.deliverik.infogovernor.drm.vo.IGDRM20042VO;
import com.google.gson.Gson;

/**
 * @Description:
 * @Author
 * @History
 * @History
 * @Version
 */
public class IGDRM2003Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM2003Action.class);

	/**
	 * 
	 *
	 * @param mapping
	 * @param actionForm
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		// FORM取得
		IGDRM2003Form form = (IGDRM2003Form) actionForm;

		// BL取得
		 IGDRM20BL ctlBL = (IGDRM20BL) getBean("igdrm20BL");

		// DTO生成
		IGDRM20DTO dto = new IGDRM20DTO();
		
		dto.setForm(form);

		if ("DISP".equals(mapping.getParameter())) {
			// 类型配置信息登记画面初期显示处理
			log.debug("========类型配置信息登记画面初期显示处理开始========");
			
			form.setPcid(req.getParameter("pcid"));
			form.setEid(req.getParameter("eid"));
			
			ctlBL.initModelAction(dto);
			
			IGDRM20042VO vo = new IGDRM20042VO(dto);
			super.<IGDRM20042VO>setVO(req, vo);
			
			log.debug("========类型配置信息登记画面初期显示处理终了========");
			saveToken(req);
		} else if("SORT_AJAX".equals(mapping.getParameter())){
			log.debug("========排序开始========");
			try{
				dto = ctlBL.sortSoc0509Action(dto);
				success(res);
			}catch(Exception ex){
				failed(res);
				log.debug("===========排序出错==========");
			}
			log.debug("========排序结束========");
			return null;
		}
		if (null != form.getBtn_save()) {
			log.debug("========保存用户添加的节点信息开始========");
			ctlBL.insertSoc0509Info(dto);
			IGDRM20042VO vo = new IGDRM20042VO(dto);
			super.<IGDRM20042VO>setVO(req, vo);
			log.debug("========保存用户添加的节点信息终了========");
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
