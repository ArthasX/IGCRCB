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
import com.deliverik.infogovernor.form.IGCOM0305Form;
import com.deliverik.infogovernor.vo.IGCOM03051VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 资产管理_关系图查看ACTION
 * </p>
 * 
 * @version 1.0
 */

public class IGCOM0305Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCOM0305Action.class);

	/**
	 * <p>
	 * Description:关系图ACTION处理
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//FORM取得
		IGCOM0305Form form = (IGCOM0305Form)actionForm;
		// 获取BL接口实例
		IGCOM03BL ctlBL = (IGCOM03BL) getBean("igcom03BL");
		// 实例化DTO
		IGCOM03DTO dto = new IGCOM03DTO();
		dto.setIgcom0305Form(form);
		
		// 选择关系图查询
		log.debug("========关系图查询处理开始========");
		if(request.getParameter("eiid")!=null){
		dto.setEiid(Integer.parseInt(request.getParameter("eiid")));
		}
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		
		dto.setUser(user);
		// 调用BL查询
		dto = ctlBL.searchRelationAction(dto);
		// 构造VO
		IGCOM03051VO vo = new IGCOM03051VO(dto.getEntityItemVWInfo(), dto
				.getParEntityItemRelationMap());
		//返回查看资产配置信息权限标识
		vo.setFlag(dto.getFlag());
		super.<IGCOM03051VO> setVO(request, vo);
		List<ActionMessage> messageList = dto.getMessageList();
		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(request, message);
			}
		}
		log.debug("========关系图查询处理终了========");
		return mapping.findForward("DISP");
	}

}
