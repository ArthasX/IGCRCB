/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.action;

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
import com.deliverik.infogovernor.bl.IGCOM03BL;
import com.deliverik.infogovernor.dto.IGCOM03DTO;
import com.deliverik.infogovernor.form.IGCOM0307Form;
import com.deliverik.infogovernor.vo.IGCOM03071VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 资产配置项信息版本比较ACTION
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGCOM0307Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCOM0307Action.class);

	/**
	 * <p>
	 * Description:资产配置项信息版本比较显示画面ACTION处理
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @author liupeng@deliverik.com
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//FORM取得
		IGCOM0307Form form = (IGCOM0307Form)actionForm;
		
		// 获取BL接口实例
		IGCOM03BL ctlBL = (IGCOM03BL) getBean("igcom03BL");
		
		// 实例化DTO
		IGCOM03DTO dto = new IGCOM03DTO();
		
		if( "SEARCH".equals(mapping.getParameter())){
			//资产配置项信息版本比较画面初期显示处理
			log.debug("========资产配置项信息版本比较画面初期显示处理开始========");
			
			//DTO输入参数设定
			dto.setIgcom0307Form(form);
			
			User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//资产配置项信息版本比较画面初期显示逻辑调用
			dto = ctlBL.initIGCOM0307Action(dto);
			
			//将资产配置项信息版本比较检索结果设定到VO中
			IGCOM03071VO vo = new IGCOM03071VO(dto.getSoc0124Info(),
					dto.getConfigItemList());
			//返回查看资产配置信息权限标识
			vo.setFlag(dto.getFlag());
			super.<IGCOM03071VO>setVO(request, vo);
			
			//逻辑处理过程中的信息显示
			List<ActionMessage> messageList = dto.getMessageList();
			
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(request, message);
				}
				
			}
			log.debug("========资产配置项信息版本比较画面初期显示处理终了========");
		}
		return mapping.findForward("DISP");
	}

}
