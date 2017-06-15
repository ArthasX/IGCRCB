/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prr.action;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import com.deliverik.framework.security.UserPermission;
import com.deliverik.framework.user.model.Action;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.prr.bl.IGPRR04BL;
import com.deliverik.infogovernor.prr.dto.IGPRR04DTO;
import com.deliverik.infogovernor.prr.form.IGPRR0402Form;
import com.deliverik.infogovernor.prr.vo.IGPRR04021VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 一级菜单下的服务目录
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGPRR0402Action extends BaseAction {

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//日志对象取得
		Log log = LogFactory.getLog(IGPRR0402Action.class);
		//BL取得
		IGPRR04BL ctlBL = (IGPRR04BL) getBean("igprr04BL");
		//实例化dto
		IGPRR04DTO dto = new IGPRR04DTO();
		//用户信息取得
		User user = (User) request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		//form取得
		IGPRR0402Form form = (IGPRR0402Form) actionForm;
		//菜单标识ID取得
		String actsortid = (String) request.getSession().getAttribute("igactionid");
		if(StringUtils.isNotEmpty(actsortid)){
			//获取菜单权限
			UserPermission perm = (UserPermission)request.getSession().getAttribute("UserPermission");
			List<Map<Action, List<Map<Action, List<Map<Action, List<Action>>>>>>> actionList = perm.getActionList();
			for(Map<Action, List<Map<Action, List<Map<Action, List<Action>>>>>> map:actionList){
				Set<Action> set = map.keySet();
				for(Iterator<Action> iter = set.iterator();iter.hasNext();){
					Action action = iter.next();
					if(action.getActsortid().equals(actsortid)){
						form.setFirstActlabel(action.getActlabel());
					}
				}
			}
		}
		//dto参数设定
		dto.setIgprr0402Form(form);
		dto.setUser(user);
		//页面初始化操作
		if("DISP".equals(mapping.getParameter())){
			log.debug("==============服务目录显示页面初始化操作开始=============");
			dto = ctlBL.searchFirstActionServiceCatalog(dto);
			IGPRR04021VO vo = new IGPRR04021VO(dto.getServiceCatalogMap(), dto.getPdList());
			super.<IGPRR04021VO>setVO(request, vo);
			log.debug("==============服务目录显示页面初始化操作结束=============");
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
