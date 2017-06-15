/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.drm.action;

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
import com.deliverik.infogovernor.drm.bl.IGDRM17BL;
import com.deliverik.infogovernor.drm.dto.IGDRM17DTO;
import com.deliverik.infogovernor.drm.vo.IGDRM17031VO;

/**
 * <p>
 * Title : InfoGovernor 模块名称
 * </p>
 * <p>
 * Description:培训记录人员选择弹出窗
 * </p>
 * 
 * @author zhangbo@deliverik.com
 * @version 1.0
 */
public class IGDRM1703Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//日志对象取得 
		Log log = LogFactory.getLog(IGDRM1703Action.class);
		//BL取得
		IGDRM17BL ctlBL = (IGDRM17BL) getBean("igdrm17BL");
		//实例化DTO
		IGDRM17DTO dto = new IGDRM17DTO();
		//dto参数设定
		dto.setForm(actionForm);
		//页面初始化操作
		if("SEARCH".equals(mapping.getParameter())){
			log.debug("===============培训记录查询人员开始==================");
			dto = ctlBL.searchUserRoleAction(dto);
			//实例化vo
			IGDRM17031VO vo = new IGDRM17031VO();
			vo.setUserRoleInfoMap(dto.getUserRoleInfoMap());
			super.setVO(request, vo);
			log.debug("===============培训记录查询人员结束==================");
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
