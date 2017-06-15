/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sdl.action;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.sdl.bl.IGSDL05BL;
import com.deliverik.infogovernor.sdl.dto.IGSDL05DTO;
import com.deliverik.infogovernor.sdl.form.IGSDL0502Form;
import com.deliverik.infogovernor.sdl.vo.IGSDL05011VO;
import com.deliverik.infogovernor.util.PRJHelper;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务管理_服务水平管理_统计查询(信息明细)ACTION
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSDL0502Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSDL0502Action.class);
	
	/**
	 * <p>
	 * Description:统计查询ACTION处理
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @author maozhipeng@deliverik.com
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//实例化FORM
		IGSDL0502Form form = (IGSDL0502Form)actionForm;
		//获取BL接口实例
		IGSDL05BL ctlBL = (IGSDL05BL) getBean("igSDL05BL");
		//实例化DTO
		IGSDL05DTO dto = new IGSDL05DTO();
		
		//获取分页Bean
		getPaginDTO(request,"IGSDL0401");

		PagingDTO pDto;
		
		pDto = (PagingDTO)request.getAttribute("PagingDTO");
		
		//pDto.setFromCount(form.getFromCount());
		
		int maxCnt = getMaxDataCount("IGSDL0401");
		//信息查询初始化
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========信息查询处理开始========");
			
			String year = request.getParameter("year");
			String month = request.getParameter("month");
			String sieiid = request.getParameter("sieiid");
			String sitype = request.getParameter("sitype");
			String day = "";
			switch(Integer.parseInt(month)){
				case 1:	
				case 3:	
				case 5:	
				case 7:	
				case 8:	
				case 10:	
				case 12:	
					day = 31+"";
					break;
				case 2:	
					if(PRJHelper.isLeapYear(Calendar.getInstance().get(Calendar.YEAR))){
						day = 29+"";
					}else{
						day = 28+"";
					}
					break;
				case 4:	
				case 6:	
				case 9:	
				case 11:	
					day = 30+"";
					break;
			}
			form.setSieiid(Integer.parseInt(sieiid));
			form.setSitype(sitype);
			form.setSibegin(year+"/"+month+"/"+"01"+" "+"00:00");
			form.setSiend(year+"/"+month+"/"+day+" "+"23:59");
			
			dto.setSdlInfoSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//调用BL查询
			dto = ctlBL.searchSdlInfoAction(dto);
			
			//构造VO
			IGSDL05011VO vo = new IGSDL05011VO();
			vo.setSdlInfoList(dto.getSdlInfoList());
			
			super.<IGSDL05011VO>setVO(request, vo);
			
			log.debug("========信息查询处理终了========");
		}
		//信息查询
		if( "SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())){
			log.debug("========信息查询处理开始========");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGSDL0502Form) request.getSession().getAttribute("IGSDL0502Form");
				if ( form == null ) {
					form = new IGSDL0502Form();
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
					form = (IGSDL0502Form) request.getSession().getAttribute("IGSDL0502Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			String year = form.getYear();
			String month = form.getMonth();
			String day = "";

			if (StringUtils.isEmpty(month)) {
				form.setSibegin(year+"/"+"01"+"/"+"01"+" "+"00:00");
				form.setSiend(year+"/"+"12"+"/"+"31"+" "+"23:59");
			}else{
				switch(Integer.parseInt(month)){
				case 1:	
				case 3:	
				case 5:	
				case 7:	
				case 8:	
				case 10:	
				case 12:	
					day = 31+"";
					break;
				case 2:	
					if(PRJHelper.isLeapYear(Calendar.getInstance().get(Calendar.YEAR))){
						day = 29+"";
					}else{
						day = 28+"";
					}
					break;
				case 4:	
				case 6:	
				case 9:	
				case 11:	
					day = 30+"";
					break;
				}
				form.setSibegin(year+"/"+month+"/"+"01"+" "+"00:00");
				form.setSiend(year+"/"+month+"/"+day+" "+"23:59");
			}
			
			dto.setSdlInfoSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//调用BL查询
			dto = ctlBL.searchSdlInfoAction(dto);
			
			//构造VO
			IGSDL05011VO vo = new IGSDL05011VO();
			vo.setSdlInfoList(dto.getSdlInfoList());
			
			super.<IGSDL05011VO>setVO(request, vo);
			
			log.debug("========信息查询处理终了========");
		}
		//详细信息
		if ("DETAIL".equals(mapping.getParameter())){
			log.debug("========信息详细信息处理开始========");
			dto.setSiid(form.getSiid());
			dto = ctlBL.searchSdlInfoDetailAction(dto);
			IGSDL05011VO vo = new IGSDL05011VO();
			vo.setSdlInfo(dto.getSdlInfo());
			vo.setAttachmentList(dto.getAttachmentList());
			super.<IGSDL05011VO>setVO(request, vo);
			log.debug("========信息详细信息处理终了========");
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
