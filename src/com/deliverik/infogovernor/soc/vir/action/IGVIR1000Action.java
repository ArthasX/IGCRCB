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
import com.deliverik.infogovernor.soc.vir.bl.IGVIR10BL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR10DTO;
import com.deliverik.infogovernor.soc.vir.vo.IGVIR10001VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 虚拟化辅助功能Action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGVIR1000Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//日志对象取得
		Log log = LogFactory.getLog(IGVIR1000Action.class);
		//BL取得
		IGVIR10BL ctlBL = (IGVIR10BL) getBean("igvir10BL");
		//实例化dto
		IGVIR10DTO dto = new IGVIR10DTO();
		//获取模板列表
		if("TAMPLATELIST".equals(mapping.getParameter())){
			log.debug("================获取模板列表操作开始================");
			dto = ctlBL.getTemplateList(dto);
			//实例化vo
			IGVIR10001VO vo = new IGVIR10001VO();
			vo.setTemplateList(dto.getTemplateList());
			super.<IGVIR10001VO>setVO(request, vo);
			log.debug("================获取模板列表操作结束================");
		}
		return mapping.findForward("DISP");
	}

}
