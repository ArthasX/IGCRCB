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
import com.deliverik.infogovernor.drm.bl.IGDRM18BL;
import com.deliverik.infogovernor.drm.dto.IGDRM18DTO;
import com.deliverik.infogovernor.drm.vo.IGDRM18111VO;

/**
 * <p>
 * Title : InfoGovernor 应急管理
 * </p>
 * <p>
 * Description:预案统计
 * </p>
 * 
 * @author zhangjian@deliverik.com
 * @version 1.0
 */
public class IGDRM1811Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//日志对象取得 
		Log log = LogFactory.getLog(IGDRM1811Action.class);
		//BL取得
		IGDRM18BL ctlBL = (IGDRM18BL) getBean("igdrm18BL");
		//实例化DTO
		IGDRM18DTO dto = new IGDRM18DTO();
		//dto参数设定
		dto.setForm(actionForm);
		//页面初始化操作
		if("SEARCH".equals(mapping.getParameter())){
			log.debug("===============演练统计查询开始==================");
			dto = ctlBL.getDrillRate(dto);
			//实例化vo
			IGDRM18111VO vo = new IGDRM18111VO();
			vo.setDrillRateList(dto.getDrillRateList());;
			vo.setDrillTypeRateList(dto.getDrillTypeRateList());
			super.setVO(request, vo);
			log.debug("===============演练统计查询结束==================");
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
