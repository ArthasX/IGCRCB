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
import com.deliverik.infogovernor.prr.bl.IGPRR04BL;
import com.deliverik.infogovernor.prr.dto.IGPRR04DTO;
import com.deliverik.infogovernor.prr.vo.IGPRR04011VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程服务目录显示action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGPRR0401Action extends BaseAction {

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//日志对象取得
		Log log = LogFactory.getLog(IGPRR0401Action.class);
		//BL取得
		IGPRR04BL ctlBL = (IGPRR04BL) getBean("igprr04BL");
		//实例化dto
		IGPRR04DTO dto = new IGPRR04DTO();
		//页面初始化操作
		if("DISP".equals(mapping.getParameter())){
			log.debug("========服务目录页面初始化操作开始========");
			//调用Bl处理数据
			dto = ctlBL.initServiceCatelogAction(dto);
			//实例化vo
			IGPRR04011VO vo = new IGPRR04011VO();
			vo.setServiceCatalogMap(dto.getServiceCatalogMap());
			vo.setServiceCatalogFirstClassify(dto.getServiceCatalogFirstClassify());
			super.<IGPRR04011VO>setVO(request, vo);
			log.debug("========服务目录页面初始化操作结束========");
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
