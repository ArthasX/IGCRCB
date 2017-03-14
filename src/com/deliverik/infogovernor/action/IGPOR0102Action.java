/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import org.apache.struts.util.MessageResources;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.security.UserPermission;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.WorkFlowConstDefine;
import com.deliverik.framework.workflow.prr.model.IG677Info;
import com.deliverik.infogovernor.bl.IGCOM01BL;
import com.deliverik.infogovernor.bl.IGCOM07BL;
import com.deliverik.infogovernor.dto.IGCOM01DTO;
import com.deliverik.infogovernor.dto.IGCOM04DTO;
import com.deliverik.infogovernor.form.IGPOR0102Form;
import com.deliverik.infogovernor.scheduling.bl.IGSCH01BL;
import com.deliverik.infogovernor.scheduling.model.QuartzJobsDetail;
import com.deliverik.infogovernor.sdl.bl.IGSDL07BL;
import com.deliverik.infogovernor.sdl.dto.IGSDL01DTO;
import com.deliverik.infogovernor.sdl.dto.IGSDL07DTO;
import com.deliverik.infogovernor.sdl.form.IGSDL0110Form;
import com.deliverik.infogovernor.sdl.form.IGSDL0701Form;
import com.deliverik.infogovernor.sdl.model.IncidentKpi;
import com.deliverik.infogovernor.svc.bl.IGPROCESSType;
import com.deliverik.infogovernor.vo.IGCOM03041VO;
import com.deliverik.infogovernor.vo.IGCOM04033VO;
import com.deliverik.infogovernor.vo.IGCOM04034VO;
import com.deliverik.infogovernor.vo.IGCOM04035VO;

/**
 * @Description: 操作平台Action处理
 * @Author  杨亮
 * @History 2010-12-8 新建
 * @Version V1.0
 * 修改时间：LuJiayuan 2013/01/31 迁移SOC所属功能
 */
public class IGPOR0102Action extends BaseAction {

	static Log log = LogFactory.getLog(IGPOR0102Action.class);
	protected MessageResources resources = MessageResources.getMessageResources("com.deliverik.infogovernor.comResources"); 
	
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
		clearSessionFormData(req);
		IGPOR0102Form form = (IGPOR0102Form) actionForm;
		setLinkID(req, form.getLinkID());
		// 点击'首页'的转发
		User user = (User) req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		IGCOM01DTO dto = new IGCOM01DTO();
		dto.setUser(user);
		dto.setUserPermission((UserPermission) req.getSession().getAttribute("UserPermission"));
		req.setAttribute("igcom03041VO", getIGCOM03041VO(dto, file_path));		
		IGCOM04033VO vo = getIGCOM04034VO(dto.getProcessRecordInfoList(), dto.getProcessRecordInfoListAsc(),req);

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
		//add by wangly 20111118 增加判断是否为流程管理员
		for(int i=0; i<userRoleInfoList.size(); i++){
			UserRoleInfo ur = userRoleInfoList.get(i);
			if(WorkFlowConstDefine.PROCESSADMIN_ROLE_TYPE.equalsIgnoreCase(ur.getRoletype())){
				req.setAttribute("isProcessAdminRole", "1");
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
	/**
	 * 全部流程内容检索结果设定
	 * @param dutyDataList 全部流程内容检索结果
	 */
	public IGCOM04033VO getIGCOM04034VO(List<IG677Info> processRecordInfoList, List<IG677Info> processRecordInfoListAsc,HttpServletRequest req) {
		
		IGCOM04033VO vo = new IGCOM04033VO();
		List<IGCOM04034VO> voList = new ArrayList<IGCOM04034VO>();
		
		if(processRecordInfoList != null) {
		
			voList.add(new IGCOM04034VO(resources.getMessage(this.getLocale(req),"title.IGPOR0102.incidents")));
			voList.add(new IGCOM04034VO(resources.getMessage(this.getLocale(req),"title.IGPOR0102.changes")));
			voList.add(new IGCOM04034VO(resources.getMessage(this.getLocale(req),"title.IGPOR0102.workorders")));

			for(IG677Info pri :processRecordInfoList) {
				
				if (pri.getPrtype().startsWith(IGPROCESSType.INCIDENT_PRTYPE)) {
					voList.get(0).getProcessRecordInfoList().add(pri);
				} else if (pri.getPrtype().startsWith(IGPROCESSType.CHANGE_PRTYPE)) {
					voList.get(1).getProcessRecordInfoList().add(pri);
				} else if (pri.getPrtype().startsWith(IGPROCESSType.WORK_PRTYPE)) {
					voList.get(2).getProcessRecordInfoList().add(pri);
				}
			}
			
			for(IG677Info pri :processRecordInfoListAsc) {
				
				if (pri.getPrtype().startsWith(IGPROCESSType.INCIDENT_PRTYPE)) {
					voList.get(0).getProcessRecordInfoListAsc().add(pri);
				} else if (pri.getPrtype().startsWith(IGPROCESSType.CHANGE_PRTYPE)) {
					voList.get(1).getProcessRecordInfoListAsc().add(pri);
				} else if (pri.getPrtype().startsWith(IGPROCESSType.WORK_PRTYPE)) {
					voList.get(2).getProcessRecordInfoListAsc().add(pri);
				}
			}
			vo.setVoList(voList);
		}
		return vo;
	}
}