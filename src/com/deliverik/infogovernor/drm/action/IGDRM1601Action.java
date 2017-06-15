/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.drm.bl.IGDRM16BL;
import com.deliverik.infogovernor.drm.dto.IGDRM16DTO;
import com.deliverik.infogovernor.drm.form.IGDRM1601Form;
import com.deliverik.infogovernor.drm.vo.IGDRM16021VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author zhangying@deliverik.com
 * @version 1.0
 */
public class IGDRM1601Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM1601Action.class);

	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse res) throws Exception {

		// 实例化FORM
		IGDRM1601Form form = (IGDRM1601Form) actionForm;
		// 获取BL接口实例
		IGDRM16BL ctlBL = (IGDRM16BL) getBean("igdrm16BL");
		// 实例化DTO
		IGDRM16DTO dto = new IGDRM16DTO();
        
		// 获取form
		dto.setIgdrm1601Form(form);
		
		//新增事件初始化
		if ("SEARCH1".equals(mapping.getParameter())) {
			log.debug("========事件新增初始化开始========");
			
			dto=ctlBL.searchMaxLabelsAction(dto);
			
			IGDRM16021VO vo = new IGDRM16021VO();
			vo.setEventssInfoList(dto.getEventssInfoList());
			super.<IGDRM16021VO>setVO(request, vo);
			log.debug("========事件新增初始化结束========");
		}
		// 新增页面跳转
		if ("INSERT".equals(mapping.getParameter())) {
			log.debug("========事件新增开始========");
			ctlBL.insertEventssAction(dto);
			log.debug("========事件新增结束========");
		}
		return mapping.findForward("DISP");
	}
}
