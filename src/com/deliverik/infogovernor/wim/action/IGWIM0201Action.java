package com.deliverik.infogovernor.wim.action;

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
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.infogovernor.wim.bl.IGWIM02BL;
import com.deliverik.infogovernor.wim.dto.IGWIM02DTO;
import com.deliverik.infogovernor.wim.form.IGWIM0201Form;
import com.deliverik.infogovernor.wim.vo.IGWIM02011VO;

/**
 * 工作登记画面Action处理
 *
 */
public class IGWIM0201Action extends BaseAction {

	static Log log = LogFactory.getLog(IGWIM0201Action.class);

	/**
	 * 工作登记处理
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	@Override
    public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//FORM取得
		IGWIM0201Form form = (IGWIM0201Form)actionForm;
		
		//BL取得
		IGWIM02BL ctlBL = (IGWIM02BL) getBean("igwim02BL");
		//DTO生成
		IGWIM02DTO dto = new IGWIM02DTO();
		
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setIgwim0201Form(form);
		dto.setUser(user);
		//工作查询初始化
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========工作查询初始化画面初期显示处理开始========");

			//分页用DTO取得
			getPaginDTO(request,"IGWIM0201");
			PagingDTO pDto;
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			int maxCnt = getMaxDataCount("IGWIM0201");
			
			//DTO输入参数设定
			dto.setMaxSearchCount(maxCnt);
			//设置分页DTO
			dto.setPagingDto(pDto);
			//获取当前时间，从而获取当前一周，显示出一周的工作
			dto = ctlBL.getCurrentWorkByDateAction(dto);
			//获取机构
			dto = ctlBL.getCenterOrgAction(dto);
			//获取机构下的人
			dto = ctlBL.getCenterOrgUserAction(dto);
			//获取当前登录用户权限
			dto = ctlBL.getPermissionByUser(dto);
			
			IGWIM02011VO vo = new IGWIM02011VO();
			vo.setDateList(dto.getDateList());
			vo.setDateToWeekYearList(dto.getDateToWeekYearList());
			vo.setOrgMap(dto.getOrgMap());
			vo.setUserOrgList(dto.getUserOrgList());
			vo.setWiList(dto.getWiList());
			super.<IGWIM02011VO>setVO(request, vo);	
			//默认机构、人员是自己，时间默认今天
			request.setAttribute("myorg", user.getOrgid());
			request.setAttribute("myuserid", user.getUserid());
			request.setAttribute("permission", dto.getUserPermission());
			form.setWorkDate(IGStringUtils.getCurrentDate());
			form.setUserid(user.getUserid());
			//查看权限用，不是自己的单子，只能看，不能处理
			request.setAttribute("powerUserid", user.getUserid());
			log.debug("========工作查询初始化画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}
		 
		if("SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			log.info("==========工作查询处理Action开始==========");
			
			//分页用DTO取得
			getPaginDTO(request,"IGWIM0201");
			PagingDTO pDto;
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGWIM0201Form) request.getSession().getAttribute("IGWIM0201Form");
				if ( form == null ) {
					form = new IGWIM0201Form();
				}else {
					if (request.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			}else {
				if (request.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					form = (IGWIM0201Form) request.getSession().getAttribute("IGWIM0201Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				 }
			}
			
			int maxCnt = getMaxDataCount("IGWIM0201");
			
			//DTO输入参数设定
			dto.setMaxSearchCount(maxCnt);
			//设置分页DTO
			dto.setPagingDto(pDto);
			
			//调用bl数据检索
			ctlBL.getCurrentWorkByDateAction(dto);

			//获取机构
			dto = ctlBL.getCenterOrgAction(dto);
			//获取机构下的人
			dto = ctlBL.getCenterOrgUserAction(dto);
			
			//获取当前登录用户权限
			dto = ctlBL.getPermissionByUser(dto);
			//实例化IGWIM02011VO
			IGWIM02011VO vo = new IGWIM02011VO();
			vo.setDateList(dto.getDateList());
			vo.setDateToWeekYearList(dto.getDateToWeekYearList());
			vo.setOrgMap(dto.getOrgMap());
			vo.setUserOrgList(dto.getUserOrgList());
			vo.setWiList(dto.getWiList());
			super.<IGWIM02011VO>setVO(request,vo);
			//查看权限用，不是自己的单子，只能看，不能处理
			request.setAttribute("powerUserid", user.getUserid());
			request.setAttribute("permission", dto.getUserPermission());
			log.info("==========工作查询处理Action结束==========");
		}
		//周期工作确认处理初始化
		if( "CYCLE_INIT".equals(mapping.getParameter())){
			log.debug("========周期工作确认处理初始化处理开始========");
			//获取当前时间，从而获取当前一周，显示出一周的工作
			dto = ctlBL.confirmCycleWorkInit(dto);
			request.setAttribute("titleDate", form.getTitleDate());
			//只读标识
			request.setAttribute("lookFlag", request.getParameter("lookFlag"));
			IGWIM02011VO vo = new IGWIM02011VO();
			vo.setWiInfo(dto.getWiInfo());
			vo.setWlogList(dto.getWlogList());
			//工作描述
			log.info("周期工作查看中工作项描述："+dto.getDesc());
			vo.setDesc(dto.getDesc());
			super.<IGWIM02011VO>setVO(request, vo);	
			log.debug("========周期工作确认处理初始化处理终了========");
			return mapping.findForward("DISP");
		}
		//周期工作确认处理
		if( "CYCLE".equals(mapping.getParameter())){
			log.debug("========周期工作确认处理处理开始========");
			//获取当前时间，从而获取当前一周，显示出一周的工作
			dto = ctlBL.confirmCycleWork(dto);
			//关闭父页,并刷新
			request.setAttribute("close", form.getOpenFlag());
			log.debug("========周期工作确认处理处理终了========");
			return mapping.findForward("DISP");
		}
		//当天工作确认处理初始化
		if( "Today_Init".equals(mapping.getParameter())){
			log.debug("========当天工作确认处理初始化处理开始========");
			//获取当前时间，从而获取当前一周，显示出一周的工作
			dto = ctlBL.confirmTodayWorkInit(dto);	
			request.setAttribute("titleDate", form.getTitleDate());
			//只读标识
			request.setAttribute("lookFlag", request.getParameter("lookFlag"));
			IGWIM02011VO vo = new IGWIM02011VO();
			vo.setIsOverTime(dto.getIsOverTime());
			vo.setWiInfo(dto.getWiInfo());
			vo.setWlogList(dto.getWlogList());
			//工作描述
			vo.setDesc(dto.getDesc());
			super.<IGWIM02011VO>setVO(request, vo);	
			log.debug("========当天工作确认处理初始化处理终了========");
			return mapping.findForward("DISP");
		}
		//当天工作确认处理
		if( "TODAY".equals(mapping.getParameter())){
			log.debug("========当天工作确认处理处理开始========");
			//获取当前时间，从而获取当前一周，显示出一周的工作
			dto = ctlBL.confirmTodayWork(dto);
			//关闭父页并刷新
			request.setAttribute("close", form.getOpenFlag());
			log.debug("========当天工作确认处理处理终了========");
			return mapping.findForward("DISP");
		}
		
		if("EXPORT".equals(mapping.getParameter())){
			log.debug("========工作信息统计查询导出处理Action开始========");
			dto.setResponse(response);
			dto = ctlBL.searchExport(dto);
			log.debug("========工作信息统计查询导出处理Action终了========");
			return null;
		}

		if("COUNT".equals(mapping.getParameter())){
			log.debug("========工作信息统计查询处理Action开始========");
			//分页用DTO取得
			getPaginDTO(request,"IGWIM0201");
			PagingDTO pDto;
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			
			if (request.getParameter("PAGING") == null) {
				pDto.setFromCount(0);
				form = (IGWIM0201Form) request.getSession().getAttribute("IGWIM0201Form");
				if (form !=null) {
					form.setFromCount(0);
				}
			 }
			
			//获取最大行数
			int maxCnt = getMaxDataCount("IGWIM0201");
			//DTO输入参数设定
			dto.setMaxSearchCount(maxCnt);
			//设置分页DTO
			dto.setPagingDto(pDto);
			
			//调用bl数据检索
			dto = ctlBL.countSearch(dto);
			
			//实例化IGWIM02011VO
			IGWIM02011VO vo = new IGWIM02011VO();
			vo.setWiList(dto.getWiList());
			super.<IGWIM02011VO>setVO(request,vo);
			log.debug("========工作信息统计查询处理Action终了========");
		}
		//首页我的当日工作
		if( "FIRSTPAGE".equals(mapping.getParameter())){
			log.debug("========首页我的当日工作查询画面初期显示处理开始========");

			//分页用DTO取得
			getPaginDTO(request,"IGWIM0201");
			PagingDTO pDto;
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			int maxCnt = getMaxDataCount("IGWIM0201");
			//DTO输入参数设定
			dto.setMaxSearchCount(maxCnt);
			//设置分页DTO
			dto.setPagingDto(pDto);
			//首页我的当日工作
			dto = ctlBL.findTodayWorkByCondForFirstPage(dto);
			
			IGWIM02011VO vo = new IGWIM02011VO();
			vo.setWiList(dto.getWiList());
			super.<IGWIM02011VO>setVO(request, vo);
			//查看权限用，不是自己的单子，只能看，不能处理
			request.setAttribute("myuserid", user.getUserid());
			request.setAttribute("titledate", IGStringUtils.getCurrentDate());
			log.debug("========首页我的当日工作查询画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}
		
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}
}
	
