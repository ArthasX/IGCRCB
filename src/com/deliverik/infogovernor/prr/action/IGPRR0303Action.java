/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prr.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.prr.bl.IGPRR03BL;
import com.deliverik.infogovernor.prr.dto.IGPRR03DTO;
import com.deliverik.infogovernor.prr.form.IGPRR0303Form;
import com.deliverik.infogovernor.prr.vo.IGPRR03031VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 人员查询action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGPRR0303Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//日志对象取得
		Log log = LogFactory.getLog(IGPRR0303Action.class);
		//BL取得
		IGPRR03BL ctlBL = (IGPRR03BL) getBean("igprr03BL");
		//实例化dto
		IGPRR03DTO dto = new IGPRR03DTO();
		//form取得
		IGPRR0303Form form = (IGPRR0303Form) actionForm;
		//dto参数设定
		dto.setIgprr0303Form(form);
		log.debug("==========人员查询页面初始化操作开始==========");
		String roletype = request.getParameter("roletype");
		String pidid = request.getParameter("pidid");
		form.reset();
		if(StringUtils.isNotEmpty(roletype)){
			form.setRoletype(roletype);
		}
		if(StringUtils.isNotEmpty(pidid)){
			form.setPidid(pidid);
		}
		dto = ctlBL.searchRoleidNotInAction(dto);
		//页面初始化操作
		/*if("DISP".equals(mapping.getParameter())){
			log.debug("==========人员查询页面初始化操作开始==========");
			String roletype = request.getParameter("roletype");
			String pidid = request.getParameter("pidid");
			form.reset();
			if(StringUtils.isNotEmpty(roletype)){
				form.setRoletype(roletype);
			}
			if(StringUtils.isNotEmpty(pidid)){
				form.setPidid(pidid);
			}
			dto = ctlBL.searchRoleidNotInAction(dto);
			log.debug("==========人员查询页面初始化操作结束==========");
		}*/
		if("SEARCH".equals(mapping.getParameter())){
			log.debug("============人员查询操作开始============");
			//调用BL查询用户信息
			dto = ctlBL.searchUserRoleAction(dto);
			//实例化vo
			IGPRR03031VO vo = new IGPRR03031VO();
			vo.setUserRoleInfoMap(dto.getUserRoleInfoMap());
			super.<IGPRR03031VO>setVO(request, vo);
			log.debug("============人员查询操作结束============");
		}
		
		List<ActionMessage> messageList = dto.getMessageList();
		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}

}
