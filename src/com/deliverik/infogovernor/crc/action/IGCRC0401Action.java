/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.crc.action;

import java.io.OutputStreamWriter;
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
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.crc.bl.IGCRC04BL;
import com.deliverik.infogovernor.crc.dto.IGCRC04DTO;
import com.deliverik.infogovernor.crc.form.IGCRC0401Form;
import com.deliverik.infogovernor.crc.vo.IGCRC04011VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 变更批量处理查询Action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGCRC0401Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		IGCRC0401Form form = (IGCRC0401Form)actionForm;
		//日志对象取得
		Log log = LogFactory.getLog(IGCRC0401Action.class);
		//BL取得
		IGCRC04BL ctlBL = (IGCRC04BL) getBean("igcrc04BL");
		//实例化dto
		IGCRC04DTO dto = new IGCRC04DTO();
		//登录用户取得
		User user = (User) request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		//dto参数设定
		dto.setUser(user);
		dto.setForm(actionForm);
		//判断表单查询条件是否已经存在
		if(request.getSession().getAttribute("AD_ProcessInfoQueryMap")==null){
			ctlBL.getPivarQueryInfoAction(dto);
			request.getSession().setAttribute("AD_ProcessInfoQueryMap", dto.getProcessInfoQueryMap());
		}
		//页面初始化操作
		if("SEARCH".equals(mapping.getParameter())){
			log.debug("=============变更批量处理查询页面显示操作开始==============");
			dto = ctlBL.searchProcessRecords(dto);
			//实例化vo
			IGCRC04011VO vo = new IGCRC04011VO();
			vo.setPrList(dto.getProcessList());
			super.<IGCRC04011VO>setVO(request, vo);
			request.setAttribute("IGCRC0401Form", form);
			log.debug("=============变更批量处理查询页面显示操作结束==============");
		}
		
		if("GETPARINFO".equals(mapping.getParameter())){
			log.debug("===========取得主流程信息操作开始=============");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "utf-8"));
				dto = ctlBL.getParentProcessInfoAction(dto);
				out.print(dto.getAjaxResult());
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("===========取得主流程信息操作结束=============");
			return null;
		}
		
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}

}
