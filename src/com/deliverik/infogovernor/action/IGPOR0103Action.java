/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.security.UserPermission;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.WorkFlowConstDefine;
import com.deliverik.infogovernor.bl.IGCOM01BL;
import com.deliverik.infogovernor.bl.IGCOM07BL;
import com.deliverik.infogovernor.dto.IGCOM01DTO;
import com.deliverik.infogovernor.dto.IGCOM04DTO;
import com.deliverik.infogovernor.form.IGPOR0103Form;
import com.deliverik.infogovernor.scheduling.bl.IGSCH01BL;
import com.deliverik.infogovernor.scheduling.model.QuartzJobsDetail;
import com.deliverik.infogovernor.sdl.bl.IGSDL07BL;
import com.deliverik.infogovernor.sdl.dto.IGSDL01DTO;
import com.deliverik.infogovernor.sdl.dto.IGSDL07DTO;
import com.deliverik.infogovernor.sdl.form.IGSDL0110Form;
import com.deliverik.infogovernor.sdl.form.IGSDL0701Form;
import com.deliverik.infogovernor.sdl.model.IncidentKpi;
import com.deliverik.infogovernor.vo.IGCOM03041VO;
import com.deliverik.infogovernor.vo.IGCOM04033VO;
import com.deliverik.infogovernor.vo.IGCOM04035VO;

/**
 * @Description: 领导登录画面Action处理
 * @Author  ZhaoJun
 * @History 2010-6-8 新建
 * @Version V2.0
 * 修改时间：LuJiayuan 2013/01/31 迁移SOC所属功能
 */
public class IGPOR0103Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCOM0101Action.class);
	
	/**
	 * 
	 * 
	 * @param mapping
	 * @param actionForm
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws Exception {

		String file_path = this.getServlet().getServletContext().getRealPath(
				File.separator);// 获得要创建目录的绝对路径
		if("CHANGE".equals(mapping.getParameter())){
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER); 
			IGCOM01DTO dto = new IGCOM01DTO();
			dto.setUser(user);		
			dto.setUserPermission((UserPermission)req.getSession().getAttribute("UserPermission"));			
			req.setAttribute("igcom03041VO", getIGCOM03041VO(dto,file_path));
			IGCOM01BL ctrlBl = (IGCOM01BL) getBean("IGCOM01BL");	
			dto = ctrlBl.getUserRoles(dto);
			List<UserRoleInfo> userRoleInfoList = dto.getUserRoleInfoList();
			IGPOR0103Form form = (IGPOR0103Form)actionForm;
			String forward = form.getForward();
			Integer year = Integer.parseInt(form.getYear());
			Integer month = Integer.parseInt(form.getMonth());
			String curmonth = form.getCurmonth();//目标年(页面日历)
			String curyear = form.getCuryear();//目标月

			if("back".equals(forward)){
				if(month == 0){
					req.setAttribute("year", year - 1);
					req.setAttribute("month", 11);
				} else {
					req.setAttribute("year", year);
					req.setAttribute("month", month - 1);
				}
			} else if ("next".equals(forward)){
				if(month >= 11){
					req.setAttribute("year", year + 1);
					req.setAttribute("month", 0);
				} else {
					req.setAttribute("year", year);
					req.setAttribute("month", month + 1);
				}
			}else if ("now".equals(forward)){
				req.setAttribute("year", year);
				req.setAttribute("month", month-1);
			}
			IGCOM04033VO vo = new IGCOM04033VO(dto.getProcessRecordInfoList(), dto.getProcessRecordInfoListAsc());			
			super.<IGCOM04033VO> setVO(req, vo);
			Map<String,String> urlMap = new HashMap<String,String>();
			String roletype = WorkFlowConstDefine.PROCESS_ROLE_MARK;
			boolean flag = false;
			for(int i=0; i<userRoleInfoList.size(); i++){
				UserRoleInfo ur = userRoleInfoList.get(i);
				if(roletype.equals(ur.getRoletype().substring(0, roletype.length()))){
					flag = true;
					break;
				}
			}
			if(flag){
				IGSCH01BL ctBL_sdl = (IGSCH01BL)getBean("IGSCH01BL");
				IGSDL01DTO dto_sdl = new IGSDL01DTO();
				IGSDL0110Form form_sdl = new IGSDL0110Form();
				form_sdl.setYmonth(curyear+"/"+curmonth);
				dto_sdl.setIgsdl0110Form(form_sdl);
				dto_sdl.setUserid(user.getUserid());
				
				//根据USERID和时间查询QuartzJobsDetail
				dto_sdl = ctBL_sdl.searchQuartzJobsByUserDate(dto_sdl);
				List<QuartzJobsDetail> quartzJobsList = dto_sdl.getQuartzJobsDetailList();
				
				String time = IGStringUtils.getCurrentDate();//当前时间
				for(QuartzJobsDetail qjd:quartzJobsList){
					if(qjd.getQjdtime().length()>=10 && (qjd.getQjdtime().substring(0,10).compareTo(time)>=0)){
						urlMap.put(qjd.getQjdtime().substring(0,10), "red");  //将需要变红的时间设成红色
					}
				}
			}
			req.setAttribute("dwmap", urlMap);
			return mapping.findForward("IGPOR0103");
		}else{
		// Session清除
		//clearSessionFormData(req);
			
		IGPOR0103Form form = (IGPOR0103Form) actionForm;
		setLinkID(req, form.getLinkID());
		// 点击'首页'的转发

		User user = (User) req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		IGCOM01DTO dto = new IGCOM01DTO();
		dto.setUser(user);

		dto.setUserPermission((UserPermission) req.getSession().getAttribute(
				"UserPermission"));
		req.setAttribute("igcom03041VO", getIGCOM03041VO(dto, file_path));
		
		IGCOM04033VO vo = new IGCOM04033VO(dto.getProcessRecordInfoList(), dto.getProcessRecordInfoListAsc());

		super.<IGCOM04033VO> setVO(req, vo);
		
		IGCOM04035VO vo2 = new IGCOM04035VO(dto.getProcessRecordInfoALLList(), dto.getProcessRecordInfoALLListAsc());
		super.<IGCOM04035VO> setVO(req, vo2);
		
		IGCOM01BL ctrlBl = (IGCOM01BL) getBean("IGCOM01BL");
		dto = ctrlBl.getUserRoles(dto);
		List<UserRoleInfo> userRoleInfoList = dto.getUserRoleInfoList();
		Map<String,String> urlMap = new HashMap<String,String>();
		//判断是否有流程角色
		String roletype = WorkFlowConstDefine.PROCESS_ROLE_MARK;
		boolean flag = false;
		for(int i=0; i<userRoleInfoList.size(); i++){
			UserRoleInfo ur = userRoleInfoList.get(i);
			if(roletype.equals(ur.getRoletype().substring(0, roletype.length()))){
				flag = true;
				break;
			}
		}
		if(flag){
			IGSCH01BL ctBL_sdl = (IGSCH01BL)getBean("IGSCH01BL");
			IGSDL01DTO dto_sdl = new IGSDL01DTO();
			IGSDL0110Form form_sdl = new IGSDL0110Form();
			String curmonth = IGStringUtils.getCurrentDate().substring(5, 7);//当前月
			String curyear = IGStringUtils.getCurrentYear();//当前年					
			form_sdl.setYmonth(curyear+"/"+curmonth);
//			form_sdl.setDate_j(curyear+"/"+curmonth+"/31 23:59");
//			form_sdl.setDate(IGStringUtils.getCurrentDate()+" 00:00");
			dto_sdl.setIgsdl0110Form(form_sdl);
			dto_sdl.setUserid(user.getUserid());

			dto_sdl = ctBL_sdl.searchQuartzJobsByUserDate(dto_sdl);
			List<QuartzJobsDetail> quartzJobsList = dto_sdl.getQuartzJobsDetailList();
			
			String time = IGStringUtils.getCurrentDate();//当前时间
			for(QuartzJobsDetail qjd:quartzJobsList){
				if(qjd.getQjdtime().length()>=10 && (qjd.getQjdtime().substring(0,10).compareTo(time)>=0) ){
					urlMap.put(qjd.getQjdtime().substring(0,10), "red");
				}
			}

		}
		req.setAttribute("dwmap", urlMap);
		req.setAttribute("form", form);
		/////////////////////////////////////////
		return mapping.findForward("SUCCESS");
		}
	}

	/**
	 * 取得首页显示用VO
	 * 
	 * @param dto
	 * @param file_path
	 * @return
	 * @throws Exception
	 */

	private IGCOM03041VO getIGCOM03041VO(IGCOM01DTO dto, String file_path)
			throws Exception {
		IGCOM03041VO igcom03041VO = this.getWorkAssigned(dto.getUser().getUserid(), dto);		
		return igcom03041VO;
	}

	/**
	 * 取得首页显示的工作的相关信息
	 * 
	 * @param userId
	 * @return
	 * @throws BLException
	 */
	private IGCOM03041VO getWorkAssigned(String userId, IGCOM01DTO dto)
			throws BLException {
		IGCOM07BL igcom07BL = (IGCOM07BL) getBean("igcom07BL");
		IGCOM04DTO igcom04DTO = new IGCOM04DTO();
		igcom04DTO.setUserId(userId);
		igcom04DTO.setPerm(dto.getUserPermission());
		igcom04DTO = igcom07BL.getProcessRecordList(igcom04DTO);
		IGCOM03041VO igcom03041VO = igcom04DTO.getIgcom03041VO();
		dto.setProcessRecordInfoList(igcom03041VO.getProcessRecordInfoForMeList());
		dto.setProcessRecordInfoListAsc(igcom03041VO.getProcessRecordInfoForMeListAsc());				
		//yangliang  2010/12/01	
		dto.setProcessRecordInfoALLList(igcom03041VO.getProcessRecordInfoForGroupList());
		dto.setProcessRecordInfoALLListAsc(igcom03041VO.getProcessRecordInfoForGroupListAsc());	
		//yangliang  2010/12/01
		
//		int count = 5;

//		List<ProcessRecordInfo> forMeList = igcom03041VO
//				.getProcessRecordInfoForMeList();
//		if (forMeList.size() > count) {
//			forMeList = forMeList.subList(0, count);
//		}
//		List<ProcessRecordInfo> forGroupList = igcom03041VO
//				.getProcessRecordInfoForGroupList();
//		if (forGroupList.size() > count) {
//			forGroupList = forGroupList.subList(0, count);
//		}
		
		
//		List<ProcessRecordInfo> forMeListAsc = igcom03041VO
//		.getProcessRecordInfoForMeListAsc();
//		if (forMeListAsc.size() > count) {
//			forMeListAsc = forMeListAsc.subList(0, count);
//		}
//		List<ProcessRecordInfo> forGroupListAsc = igcom03041VO
//				.getProcessRecordInfoForGroupListAsc();
//		if (forGroupListAsc.size() > count) {
//			forGroupListAsc = forGroupListAsc.subList(0, count);
//		}

//		List<ProcessRecordInfo> waJobList = igcom03041VO
//		.getProcessRecordInfoForWAList();
//		if (waJobList.size() > 5) {
//			waJobList = waJobList.subList(0, 5);
//		}
		
		

//		igcom03041VO.setProcessRecordInfoForMeList(forMeList);
//		igcom03041VO.setProcessRecordInfoForGroupList(forGroupList);
//		igcom03041VO.setProcessRecordInfoForMeListAsc(forMeListAsc);
//		igcom03041VO.setProcessRecordInfoForGroupListAsc(forGroupListAsc);
//		igcom03041VO.setProcessRecordInfoForWAList(waJobList);
		igcom03041VO.setIncidentKpiList(getIncidentKpiList());

		return igcom03041VO;
	}

	/**
	 * 取得事件KPI
	 * @throws BLException 
	 */
	private List<IncidentKpi> getIncidentKpiList() throws BLException{

		SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd");
		String nowYear = sdfTime.format(new Date()).split("-")[0];//当前年
		String nowmonth = sdfTime.format(new Date()).split("-")[1];//当前月
		IGSDL0701Form form = new IGSDL0701Form();
		//获取BL接口实例
		IGSDL07BL ctlBL = (IGSDL07BL) getBean("igSDL07BL");
		//实例化DTO
		IGSDL07DTO dto = new IGSDL07DTO();
		form.setKpiYear(nowYear);
		form.setKpiMonth(nowmonth);
		form.setRadioValue("B");
		dto.setIncidentKpiSearchCond(form);
		dto = ctlBL.searchIncidentKpiListAction(dto);
		List<IncidentKpi> list=dto.getIncidentKpiList();
		return list;
		
	}
}