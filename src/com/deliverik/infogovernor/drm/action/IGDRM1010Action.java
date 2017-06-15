/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.drm.action;

import java.io.PrintWriter;
import java.util.Date;
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
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.drm.bl.IGDRM10BL;
import com.deliverik.infogovernor.drm.dto.IGDRM10DTO;
import com.deliverik.infogovernor.drm.form.IGDRM1010Form;
import com.deliverik.infogovernor.drm.vo.IGDRM10101VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 应急工作台Action
 * </p>
 * 
 * @author zhangjian@deliverik.com
 */

public class IGDRM1010Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM1010Action.class);

	/**
	 * 应急工作台Action处理
	 *
	 * @param mapping
	 * @param actionForm
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */	
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//BL取得
		IGDRM10BL ctlBL = (IGDRM10BL) getBean("igdrm10BL");
		
		//DTO生成
		IGDRM10DTO dto = new IGDRM10DTO();
		
		//登录用户取得
		User user = (User) req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		
		//dto参数设定
		dto.setForm(actionForm);
		dto.setUser(user);
		
		res.setCharacterEncoding("UTF-8");
		PrintWriter out = res.getWriter();
		if( "DISP".equals(mapping.getParameter())){
			// 应急工作台画面初期显示处理
			log.info("========应急工作台画面初期显示处理开始========");
			Date d = new Date();
			dto = ctlBL.initWorkbenchAction(dto);
			IGDRM10101VO vo = new IGDRM10101VO();
			vo.setWorkbenchMap(dto.getWorkbenchMap());
			setVO(req, vo);
			log.info("========应急工作台画面初期显示处理终了  >>>耗时"+(new Date().getTime()-d.getTime())+"========");
		} else if ("AJAX".equals(mapping.getParameter())) {
			try {
				dto = ctlBL.initWorkFlowAction(dto);
				out.print(dto.getJsonResult());
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			return null;
		}else if("COMMIT".equals(mapping.getParameter())){
			log.info("===========提交操作开始============");
			Date d = new Date();
			try { 

				dto = ctlBL.doFlowAction(dto);
				out.print("success");
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.info("===========提交操作结束  >>>>>>耗时"+(new Date().getTime()-d.getTime())+"============");
			return null;
		} else if ("SMS".equals(mapping.getParameter())) {

			log.info("===========发送短信开始============");
			try {
				ctlBL.sendSMS(dto);
				out.print("{\"msg\":\"success\"}");
			} catch (Exception e) {
				out.print("{\"msg\":\"failed\"}");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}

			log.info("===========发送短信结束============");
			return null;

		} else if ("NOTICE".equals(mapping.getParameter())) {
			log.info("===========发送通知开始============");
			try {
				IGDRM1010Form form = (IGDRM1010Form) actionForm;
				form.setSendUserid(user.getUserid());
				form.setSendUserName(user.getUsername());

				dto.setForm(form);

				ctlBL.sendNotice(dto);
				out.print("{\"msg\":\"success\"}");
			} catch (Exception e) {
				out.print("{\"msg\":\"failed\"}");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}

			log.info("===========发送通知结束============");
			return null;
		} else if ("LOG".equals(mapping.getParameter())) {
			log.info("==============查询日志开始==================");
			try {
				ctlBL.searchLog(dto);
				out.print(dto.getJsonResult());
			} catch (Exception e) {
				out.print("{\"msg\":\"failed\"}");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}

			log.info("==============查询日志完成==================");
			return null;
		} else if ("UPLOAD".equals(mapping.getParameter())) {
			log.info("============附件上传开始===============");
			try {
				ctlBL.uploadAtt(dto);
				out.print(dto.getJsonResult());
			} catch (Exception e) {
				out.print("{\"msg\":\"failed\"}");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.info("============附件上传完成===============");
			return null;
		} else if ("TIMES".equals(mapping.getParameter())) {
			log.info("=========查询场景预计恢复时长开始==========");
			try {
				ctlBL.searchSenceTimes(dto);
				out.print(dto.getJsonResult());
			} catch (Exception e) {
				out.print("{\"msg\":\"failed\"}");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.info("=========查询场景预计恢复时长完成==========");
			return null;
		} else if ("GETDESC".equals(mapping.getParameter())) {
			log.info("=========查询单节点处置说明开始==========");
			try {
				ctlBL.searchDesc(dto);
				out.print(dto.getJsonResult());
			} catch (Exception e) {
				out.print("{\"msg\":\"failed\"}");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.info("=========查询单节点处置说明完成==========");
			return null;
		} else if ("SAVEDESC".equals(mapping.getParameter())) {
			log.info("=========保存单节点处置说明开始==========");
			try {
				ctlBL.saveDesc(dto);
				out.print(dto.getJsonResult());
			} catch (Exception e) {
				out.print("{\"msg\":\"failed\"}");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.info("=========保存单节点处置说明完成==========");
			return null;
		}
		
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
		}
		return mapping.findForward("DISP");
	}

}
