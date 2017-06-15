/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.crc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.crc.bl.IGCRC13BL;
import com.deliverik.infogovernor.crc.dto.IGCRC1304DTO;
import com.deliverik.infogovernor.crc.form.IGCRC1304Form;
import com.deliverik.infogovernor.crc.vo.IGCRC1304VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 文档信息查询Action
 * </p>
 * 
 * @author 史凯龙@deliverik.com
 * @version 1.0
 */
public class IGCRC1304Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCRC1304Action.class);
	
	/**
	 * <p>
	 * Description: 页面查询action处理
	 * </p>
	 * 
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.debug("================部门提交统计Action开始=============");
		IGCRC1304Form form = (IGCRC1304Form)actionForm;
		
		IGCRC13BL igcrc13bl = (IGCRC13BL)getBean("igcrc13bl");

		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		
		IGCRC1304DTO dto = new IGCRC1304DTO();
		
		dto.setUser(user);
		
		if("DISP".equals(mapping.getParameter())){
			log.debug("=================部门提交统计处理开始===============");
			PagingDTO pDto = getPaginDTO(request, "IGCRC1304");
			
			int maxCnt = getMaxDataCount("IGCRC1304");
			
			dto.setIgcrc1304Form(form);
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			
			dto = igcrc13bl.searchDepartSumAction(dto);

			//构造VO
			IGCRC1304VO vo = new IGCRC1304VO();
			vo.setIgcrc1304VWList(dto.getEntityItemVWInfoList());
			vo.setMaps(dto.getMaps());
			vo.setListVM(dto.getListVM());
			request.getSession().setAttribute("isManager", dto.getIsManeger()==null?"0":dto.getIsManeger());
			super.<IGCRC1304VO>setVO(request, vo);
			
			log.debug("=================部门提交统计处理结束===============");
		}else if("SEARCH".equals(mapping.getParameter())){
			log.debug("=================部门统计查询流程处理开始===============");
			PagingDTO pDto = getPaginDTO(request, "IGCRC1304");
			String type = request.getParameter("type");
			int maxCnt = getMaxDataCount("IGCRC1304");
			form.setEiid(type);
			dto.setIgcrc1304Form(form);
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			
			dto = igcrc13bl.searchIG500ItemAction(dto);
			IGCRC1304VO vo = new IGCRC1304VO();
			vo.setProcessList(dto.getProcessList());
			super.<IGCRC1304VO>setVO(request, vo);
			log.debug("=================部门统计流程查询处理结束===============");
		}
		log.debug("================部门提交统计Action结束=============");
		return mapping.findForward("DISP");
	}
}
