/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sdl.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.scheduling.bl.IGSCH01BL;
import com.deliverik.infogovernor.sdl.dto.IGSDL01DTO;
import com.deliverik.infogovernor.sdl.form.IGSDL0110Form;
import com.deliverik.infogovernor.sdl.vo.IGSDL01101VO;

public class IGSDL0203Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSDL0203Action.class);

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		if ("SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())){
			IGSCH01BL ctlBL = (IGSCH01BL) getBean("IGSCH01BL");
			IGSDL0110Form form = (IGSDL0110Form)actionForm;
			IGSDL01DTO dto = new IGSDL01DTO();
			dto.setIgsdl0110Form(form);
			
			getPaginDTO(request,"IGSDL0203");
			PagingDTO pDto;
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGSDL0110Form) request.getSession().getAttribute("IGSDL0110Form");
				if ( form == null ) {
					form = new IGSDL0110Form();
				}else {
					if (request.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} else {
				if (request.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					form = (IGSDL0110Form) request.getSession().getAttribute("IGSDL0110Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//pDto.setFromCount(form.getFromCount());
			int maxCnt = getMaxDataCount("IGSDL0203");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			// 调用BL查询
			dto = ctlBL.findQuartzJobsForSDL(dto);
			
			// 构造VO
			IGSDL01101VO vo = new IGSDL01101VO();
			vo.setQuartzJobsList(dto.getQuartzJobsList());
			super.<IGSDL01101VO> setVO(request, vo);
		}
		
		return mapping.findForward("DISP");
	}
}