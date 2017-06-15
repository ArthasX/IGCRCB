/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prr.action;

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
import com.deliverik.infogovernor.prr.bl.IGPRR01BL;
import com.deliverik.infogovernor.prr.dto.IGPRR01DTO;
import com.deliverik.infogovernor.prr.form.IGPRR0123Form;
import com.deliverik.infogovernor.prr.vo.IGPRR01231VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程表单日志查看Action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGPRR0123Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//日志对象取得
		Log log = LogFactory.getLog(IGPRR0123Action.class);
		//BL取得
		IGPRR01BL ctlBL = (IGPRR01BL) getBean("igPRR01BL");
		//实例化的dto
		IGPRR01DTO dto = new IGPRR01DTO();
		//登录用户取得
		User user = (User) request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		//form对象取得
		IGPRR0123Form form = (IGPRR0123Form) actionForm;
		//dto参数设定
		dto.setUser(user);
		dto.setPrid(form.getPrid());
		//查询操作
		if("SEARCH".equals(mapping.getParameter())){
			log.debug("================表单日志查询操作开始=================");
			dto = ctlBL.searchProcessInfoLog(dto);
			//实例化vo
			IGPRR01231VO vo = new IGPRR01231VO();
			vo.setVarLogList(dto.getVarLogList());
			super.<IGPRR01231VO>setVO(request, vo);
			log.debug("================表单日志查询操作结束=================");
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
