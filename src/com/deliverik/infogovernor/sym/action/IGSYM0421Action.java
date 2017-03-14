/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.sym.bl.IGSYM04BL;
import com.deliverik.infogovernor.sym.dto.IGSYM04DTO;
import com.deliverik.infogovernor.sym.vo.IGSYM04211VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_授权管理_资源组授权角色查询ACTION
 * </p>
 * 
 * @author lujiayuan 2012/11/15
 * @version 1.0
 */

public class IGSYM0421Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSYM0421Action.class);
	
	/**
	 * <p>
	 * Description: 资源组授权action处理
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @author lujiayuan
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//获取BL接口实例
		IGSYM04BL ctlBL = (IGSYM04BL) getBean("igsym04BL");
		//实例化DTO
		IGSYM04DTO dto = new IGSYM04DTO();

		if( "DISP".equals(mapping.getParameter())){
			log.debug("========资源组授权查询画面初期显示处理开始========");
			
			//获取已同步到HQ库EAM_ROLE表的角色
			dto = ctlBL.searchSYNRoleAction(dto);
			//构造VO
			IGSYM04211VO vo = new IGSYM04211VO();
			vo.setRoleList(dto.getRoleList());
			super.<IGSYM04211VO>setVO(request, vo);
			
			log.debug("========资源组授权查询画面初期显示处理终了========");
		}
		return mapping.findForward("DISP");
	}

}
