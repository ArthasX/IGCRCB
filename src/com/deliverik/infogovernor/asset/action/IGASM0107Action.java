/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.asset.action;

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
import com.deliverik.infogovernor.asset.bl.IGASM01BL;
import com.deliverik.infogovernor.asset.dto.IGASM01DTO;
import com.deliverik.infogovernor.asset.vo.IGASM01071VO;

/**
 * 资产下拉数据选择画面Action处理
 *
 */

public class IGASM0107Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGASM0107Action.class);
	
	/**
	 * <p>
	 * Description:选择数据ACTION处理
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
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//获取BL接口实例
		IGASM01BL ctlBL = (IGASM01BL) getBean("igasm01BL");
		//实例化DTO
		IGASM01DTO dto = new IGASM01DTO();
		//选择流程类型查询
		log.debug("========资产下拉数据查询处理开始========");
		//调用BL查询
		dto = ctlBL.searchConfigurationCodeDetailBean(dto);
		//构造VO
		IGASM01071VO vo = new IGASM01071VO(dto.getConfigurationCodeDetailBeanList());
		super.<IGASM01071VO>setVO(request, vo);
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		log.debug("========资产下拉数据查询处理终了========");
		return mapping.findForward("DISP");
	}

}
