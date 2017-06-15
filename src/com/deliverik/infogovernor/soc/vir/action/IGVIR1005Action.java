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
import com.deliverik.infogovernor.soc.vir.vo.IGVIR10051VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 虚拟化管理员首页Action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGVIR1005Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//日志对象取得
		Log log = LogFactory.getLog(IGVIR1005Action.class);
		//BL取得
		IGVIR10BL ctlBL = (IGVIR10BL) getBean("igvir10BL");
		//实例化dto
		IGVIR10DTO dto = new IGVIR10DTO();
		//form取得
//		IGVIR1005Form form = (IGVIR1005Form) actionForm;
		log.debug("===========虚拟化管理首页初始化操作开始==========");
		//实例化vo
		IGVIR10051VO vo = new IGVIR10051VO();
		dto.setIgvir10051VO(vo);
		dto = ctlBL.initManageHomePageAction(dto);
		super.<IGVIR10051VO>setVO(request, vo);
		log.debug("===========虚拟化管理首页初始化操作结束==========");
		return mapping.findForward("DISP");
	}

}
