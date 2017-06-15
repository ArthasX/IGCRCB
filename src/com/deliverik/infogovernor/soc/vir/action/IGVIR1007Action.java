/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.vir.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.soc.vir.bl.IGVIR10BL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR10DTO;
import com.deliverik.infogovernor.soc.vir.vo.IGVIR10071VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 资源管理首页Action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGVIR1007Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//日志对象取得
		Log log = LogFactory.getLog(IGVIR1007Action.class);
		//BL取得
		IGVIR10BL ctlBL = (IGVIR10BL) getBean("igvir10BL");
		//实例化dto
		IGVIR10DTO dto = new IGVIR10DTO();
		//登录用户取得
		User user = (User) request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		//dto参数设定
		dto.setUser(user);
		log.debug("==========资源管理首页初始化操作开始==========");
		dto = ctlBL.initResourceManageHomePageAction(dto);
		//实例化vo
		IGVIR10071VO vo = new IGVIR10071VO();
		vo.setTemplateList(dto.getTemplateList());
		vo.setPihList(dto.getPihList());
		vo.setHostMap(dto.getHostMap());
		vo.setVmReportMap(dto.getVmReportMap());
		vo.setPrRecportMap(dto.getPrRecportMap());
		super.<IGVIR10071VO>setVO(request, vo);
		log.debug("==========资源管理首页初始化操作结束==========");
		return mapping.findForward("DISP");
	}

}
