/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.infogovernor.bl.IGCOM01BL;
import com.deliverik.infogovernor.dto.IGCOM01DTO;
import com.deliverik.infogovernor.form.IGCOM0201Form;
import com.deliverik.infogovernor.vo.IGCOM01031VO;
import com.deliverik.plugin.sms.SMSThread;

/**
 * @Description: 领导登录画面Action处理
 * @Author  ZhaoJun
 * @History 2010-6-8     新建
 * @Version V2.0
 */
public class IGCOM0103Action extends BaseAction {

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

		String Forward = "SUCCESS";
		if("CHANGE".equals(mapping.getParameter())){
			//日历翻页
			Forward =  "IGCOM0403";
		} 

		// Session清除
		clearSessionFormData(req);
		IGCOM0201Form form = (IGCOM0201Form) actionForm;
		setLinkID(req, form.getLinkID());
		// 点击'首页'的转发

		User user = (User) req.getSession().getAttribute(
				SESSION_KEY_LOGIN_USER);
		IGCOM01DTO dto = new IGCOM01DTO();
		dto.setIgcom0201Form(form);
		dto.setUser(user);
		
		IGCOM01BL ctrlBl = (IGCOM01BL) getBean("IGCOM01BL");
		
		dto = ctrlBl.getUserRoles(dto);
		List<UserRoleInfo> userRoleInfoList = dto.getUserRoleInfoList();
		for (UserRoleInfo userRoleInfo : userRoleInfoList) {
			String roletype = userRoleInfo.getRoletype();
			//判断当前用户是否有知识审批角色
			if("IGKG02".equals(roletype)){
				req.setAttribute("roleType", "IGKG02");
				break;
			}
		}

		dto = ctrlBl.getProcessInHand(dto); // 我的工作相关工作
//		dto = ctrlBl.getKnowledge(dto); // 知识
		dto = ctrlBl.findTodayWorkByCondForFirstPage(dto); // 首页我的当日工作查询
		//查看权限用，不是自己的单子，只能看，不能处理
		req.setAttribute("myuserid", user.getUserid());
		req.setAttribute("titledate", IGStringUtils.getCurrentDate());
		dto = ctrlBl.getNotice(dto); // 通知
		dto = ctrlBl.getDaysPlans(dto); // 日常计划
		dto = ctrlBl.getRiskCheckResultGoup(dto);	//首页检查工作查询
//		dto = ctrlBl.searchHQAlertListDetailVWAction(dto); // hq告警
//		dto = ctrlBl.searchBussinessAvailvalVWAction(dto); // 业务系统可用性
//		dto = ctrlBl.searchOracleAlertAction(dto); // Oracle告警

		IGCOM01031VO vo = new IGCOM01031VO();
		vo.setProcessInHandAsc(dto.getPihListAsc()); // 我的工作正序
		vo.setProcessInHandDesc(dto.getPihListDesc()); // 我的工作倒序
		vo.setProcessInHandGroupDesc(dto.getPihGroupListDesc()); // 相关工作倒序
		vo.setProcessInHandGroupAsc(dto.getPihGroupListAsc()); // 相关工作正序
		vo.setProcessInHandDiscontinueDesc(dto.getProcessInHandDiscontinueDesc());//中止工作倒序
		vo.setProcessInHandDiscontinueAsc(dto.getProcessInHandDiscontinueAsc());//中止工作正序
		vo.setKnvoList(dto.getKnvoList()); // 最新知识
		vo.setAppKnList(dto.getAppKnList());//待审批知识
		vo.setNoticeList(dto.getNoticeList()); // 通知
		vo.setDayplans(dto.getRiliString()); // 日常计划
		vo.setLst_RiskCheckResult_Asc(dto.getLst_RiskCheckResult_Asc());//个人检查工作正序
		vo.setLst_RiskCheckResult_Desc(dto.getLst_RiskCheckResult_Desc());//个人检查工作倒序
		vo.setLst_RiskCheckResultGroup_Asc(dto.getLst_RiskCheckResultGroup_Asc());//相关检查工作正序
		vo.setLst_RiskCheckResultGroup_Desc(dto.getLst_RiskCheckResultGroup_Desc());//相关检查工作倒序
		vo.setRiskChecktime(IGStringUtils.getCurrentDateTime());//获取系统当前时间
//		vo.setHqAlertListDetailVWList(dto.getHqAlertListDetailVWList()); // 告警
//		vo.setLst_BussinessAvailval(dto.getLst_BussinessAvailval()); // 业务系统可用性
		vo.setLst_CRM06Info(dto.getLst_CRM06Info()); // Oracle告警
		
		vo.setYear(form.getYear());
		vo.setMonth(form.getMonth());
		req.getSession().setAttribute("AD_SMSSTATUS_REQUEST", SMSThread.isSmsOpen());
		//存入当前系统时间
		req.getSession().setAttribute("Current_Time", IGStringUtils.getCurrentDate());
		vo.setMyWorkItemList(dto.getMyWorkItemList());
		super.<IGCOM01031VO> setVO(req, vo);
		return mapping.findForward(Forward);
	}

}