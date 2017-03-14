/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
import com.deliverik.infogovernor.drm.bl.IGDRM15BL;
import com.deliverik.infogovernor.drm.dto.IGDRM15DTO;
import com.deliverik.infogovernor.drm.form.IGDRM1512Form;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description:培训计划更新
 * </p>
 * 
 * @author zhangying@deliverik.com
 * @version 1.0
 */
public class IGDRM1513Action extends BaseAction {
	static Log log = LogFactory.getLog(IGDRM1513Action.class);

	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionform, HttpServletRequest request,
			HttpServletResponse res) throws Exception {

		// 获得form
		IGDRM1512Form form = (IGDRM1512Form) actionform;
		// BL取得
		IGDRM15BL ctlBL = (IGDRM15BL) getBean("igdrm15BL");
		// DTO生成
		IGDRM15DTO dto = new IGDRM15DTO();
		dto.setIgdrm1512Form(form);
		// 修改
		
		if ("TOUPDATE".equals(mapping.getParameter())) {
			log.debug("========培训计划/培训任务更新处理开始========");
			ctlBL.updateTrainPlanMission(dto);
			log.debug("========培训计划/培训任务更新处理结束========");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return new ActionForward("/IGDRM1511_ToEdit.do?tpid=" + form.getUpTpid());
	}

}
