/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.wim.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.wim.bl.IGWIM01BL;
import com.deliverik.infogovernor.wim.dto.IGWIM01DTO;
import com.deliverik.infogovernor.wim.form.IGWIM0101Form;

/**
 * @Description 工作项管理Action
 * 
 * @date 2017年6月9日16:38:55
 * 
 * @author WangLiang
 *
 */
public class IGWIM0101Action extends BaseAction{
	
	static Log log = LogFactory.getLog(IGWIM0101Action.class);

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		//Form取得
		IGWIM0101Form form = (IGWIM0101Form) actionForm;
		//BL取得
		IGWIM01BL ctlBL  = (IGWIM01BL) getBean("igwim01BL");
		//DTO生成
		IGWIM01DTO dto = new IGWIM01DTO();
		//获取登录用户
		User user = (User) request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		//登陆用户保存
		dto.setUser(user);
		
		if("DISP".equals(mapping.getParameter())){
			log.info("==========工作项定义新增页面Action初始化开始==========");
			log.info("==========工作项定义新增页面Action初始化结束==========");
		}
		
		return mapping.findForward("DISP");
	}

}
