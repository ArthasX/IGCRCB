/*
 * 北京递蓝科软件技术有限公司版权所有,保留所有权利.
 */

package com.deliverik.infogovernor.dut.bl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.utility.CodeListUtils;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.infogovernor.dut.bl.task.DutyAuditDefBL;
import com.deliverik.infogovernor.dut.bl.task.DutyAuditTimeBL;
import com.deliverik.infogovernor.dut.bl.task.DutyPersonBL;
import com.deliverik.infogovernor.dut.bl.task.DutyPlanBL;
import com.deliverik.infogovernor.dut.bl.task.DutyResultBL;
import com.deliverik.infogovernor.dut.bl.task.DutyResultVWBL;
import com.deliverik.infogovernor.dut.dto.IGDUT02DTO;
import com.deliverik.infogovernor.dut.form.IGDUT0202Form;
import com.deliverik.infogovernor.dut.form.IGDUT0203Form;
import com.deliverik.infogovernor.dut.form.IGDUT0204Form;
import com.deliverik.infogovernor.dut.form.IGDUT0206Form;
import com.deliverik.infogovernor.dut.form.IGDUT0207Form;
import com.deliverik.infogovernor.dut.model.DutyPerson;
import com.deliverik.infogovernor.dut.model.DutyPlan;
import com.deliverik.infogovernor.dut.model.DutyResult;
import com.deliverik.infogovernor.dut.model.DutyResultVWInfo;
import com.deliverik.infogovernor.dut.model.condition.DutyPersonSearchCondImpl;
import com.deliverik.infogovernor.dut.model.condition.DutyPlanSearchCondImpl;
import com.deliverik.infogovernor.dut.model.condition.DutyResultSearchCondImpl;
import com.deliverik.infogovernor.dut.model.condition.DutyResultVWSearchCondImpl;
import com.deliverik.infogovernor.dut.model.entity.DutyPersonTB;
import com.deliverik.infogovernor.dut.model.entity.DutyPlanTB;
import com.deliverik.infogovernor.dut.model.entity.DutyResultTB;
import com.deliverik.infogovernor.util.CodeDefine;

/**
 * 值班管理业务逻辑实现
 *
 */
public class IGDUT02BLImpl extends BaseBLImpl implements IGDUT02BL {

	static Log log = LogFactory.getLog(IGDUT02BLImpl.class);
	/** CodeListUtils */
	protected CodeListUtils codeListUtils;
	
	/** 值班检查内容BL */
	protected DutyResultBL dutyResultBL;
	
	/** 值班计划BL */
	protected DutyPlanBL dutyPlanBL;
	
	/** 值班人BL */
	protected DutyPersonBL dutyPersonBL;
	
	/** 用户角色BL */
	protected UserRoleBL userRoleBL;
	
	/** 用户BL */
	protected UserBL userBL;
	
	
	/** 值班检查项BL */
	protected DutyAuditDefBL dutyAuditDefBL;
	
	/** 值班检查时间BL */
	protected DutyAuditTimeBL dutyAuditTimeBL;

	/** 值班日报视图BL */
	protected DutyResultVWBL dutyResultVWBL;
	
	
	
	/**
	 * 值班日报视图BL
	 * @param dutyResultVWBL the dutyResultVWBL to set
	 */
	public void setDutyResultVWBL(DutyResultVWBL dutyResultVWBL) {
		this.dutyResultVWBL = dutyResultVWBL;
	}

	/**
	 *  值班检查项BL
	 * @param dutyAuditDefBL 值班检查项BL
	 */
	public void setDutyAuditDefBL(DutyAuditDefBL dutyAuditDefBL) {
		this.dutyAuditDefBL = dutyAuditDefBL;
	}

	/**
	 *  值班检查时间BL
	 * @param dutyAuditTimeBL 值班检查时间BL
	 */
	public void setDutyAuditTimeBL(DutyAuditTimeBL dutyAuditTimeBL) {
		this.dutyAuditTimeBL = dutyAuditTimeBL;
	}
	
	/**
	 *  值班检查内容BL设定
	 * @param dutyResultBL 值班检查内容BL
	 */
	public void setDutyResultBL(DutyResultBL dutyResultBL) {
		this.dutyResultBL = dutyResultBL;
	}
	
	/**
	 *  值班检查计划BL设定
	 * @param dutyPlanBL 值班检查计划BL
	 */
	public void setDutyPlanBL(DutyPlanBL dutyPlanBL) {
		this.dutyPlanBL = dutyPlanBL;
	}
	
	/**
	 *  值班人BL设定
	 * @param dutyPersonBL 值班人BL
	 */
	public void setDutyPersonBL(DutyPersonBL dutyPersonBL) {
		this.dutyPersonBL = dutyPersonBL;
	}
	
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}
	
	/**
	 *  用户BL设定
	 * @param userBL 用户BL
	 */
	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
	}

	/**
	 * CodeListUtils
	 * @param codeListUtils
	 */
	public void setCodeListUtils(CodeListUtils codeListUtils) {
		this.codeListUtils = codeListUtils;
	}

	/**
	 * 值班交接详细信息查询处理
	 *
	 * @param dto IGDUT02DTO
	 * @return IGDUT02DTO
	 */
	public IGDUT02DTO initIGDUT0204Action(IGDUT02DTO dto) throws BLException {
		log.debug("========值班交接详细信息查询处理开始========");
		//查询执行中计划
		List<DutyPlan> dutyPlanList = this.dutyPlanBL.searchDutyPlan(dto.getDutyPlanSearchCond(), 0, 0);
		//没有执行中计划显示提示信息
		if(dutyPlanList.size() != 1 ) {
			throw new BLException("IGDUT0205.E003"); 
		} else {
			List<DutyPersonTB> dutyPersonList = dutyPlanList.get(0).getDutyPersonList();
			//判断登录用户是否是值班人
			boolean flag = true;
			StringBuffer usersinfo = new StringBuffer();
			for(DutyPerson dp : dutyPersonList) {
				if(dp.getDperuserid().equals(dto.getUser().getUserid())) {
					flag = false;
				}
				usersinfo.append(dp.getDperusername()).append("&nbsp;&nbsp;&nbsp;&nbsp;");
			}
			if(flag) {
				throw new BLException("IGDUT0204.E001"); 
			}
			//检查日报是否含有未检查项
			DutyResultSearchCondImpl drCond = new DutyResultSearchCondImpl();
			drCond.setDpid(dutyPlanList.get(0).getDpid());
			drCond.setIsNullDrcontent("yes");
			int size = this.dutyResultBL.getSearchCount(drCond);
			if(size > 0) {
				dto.addMessage(new ActionMessage("IGDUT0204.W001"));
				dto.setHasNullDrcontent("1");
			}
			
			//值班日期
			String date = dutyPlanList.get(0).getDptime();
			//白班/夜班
			String type = dutyPlanList.get(0).getDptype();
			//判断接班计划是否存在
			DutyPlanSearchCondImpl cond = new DutyPlanSearchCondImpl();
			cond.setDpstatus(IGDUTCONSTANTS.PLAN_STATUS_UNEXECUTE);
			cond.setDadcategory(dutyPlanList.get(0).getDadcategory());
			//白班找夜班，夜班找第二天的白班
			if(IGDUTCONSTANTS.DAY_SHIFT.equals(type)) {
				cond.setDptime(date);
				cond.setDptype(IGDUTCONSTANTS.NIGHT_SHIFT);
			} else if(IGDUTCONSTANTS.NIGHT_SHIFT.equals(type)) {
				SimpleDateFormat df = new SimpleDateFormat(
	            "yyyy/MM/dd");
				Calendar c = Calendar.getInstance();
		        try {
					c.setTime(df.parse(date));
				} catch (ParseException e) {
					log.debug("交班计划日期格式不正确：" + date);
					throw new BLException("IGDUT0204.E003",date);
				}
		        c.add(Calendar.DATE, 1);
				cond.setDptime(df.format(c.getTime()));
				cond.setDptype(IGDUTCONSTANTS.DAY_SHIFT);
			} else {
				throw new BLException("IGCO10000.E004","值班时间");
			}
			List<DutyPlan> list = this.dutyPlanBL.searchDutyPlan(cond, 0, 0);
			if(list.isEmpty()) {
				throw new BLException("IGDUT0204.E002");
			} else if(list.size() != 1){
				throw new BLException("IGDUT0205.E001" ,list.size() + "");
			} else {
				dto.getIgDUT0204Form().setDpid_unexecute(list.get(0).getDpid());
			}
			//查询执行中值班计划信息
			DutyResultSearchCondImpl dutyResultCond = new DutyResultSearchCondImpl();
			dutyResultCond.setDpid(dutyPlanList.get(0).getDpid());
			List<DutyResult> dutyResultList = dutyResultBL.searchDutyResult(dutyResultCond, 0, 0);
			if(dutyResultList.isEmpty()) {
				throw new BLException("IGCO10000.E004","值班日报基本"); 
			}
			dto.setDutyResultList(dutyResultList);
			dto.setUsersinfo(usersinfo.toString());
			dto.setDutyPlan(dutyPlanList.get(0));
		}
		log.debug("========值班交接详细信息查询处理结束========");
		return dto;
	}
	
	/**
	 * 值班交接确认信息查询处理
	 *
	 * @param dto IGDUT02DTO
	 * @return IGDUT02DTO
	 */
	public IGDUT02DTO initIGDUT0205Action(IGDUT02DTO dto) throws BLException {
		log.debug("========值班交接确认信息查询处理开始========");
		IGDUT0204Form form = dto.getIgDUT0204Form();
		//查询接班计划
		DutyPlan dp = this.dutyPlanBL.searchDutyPlanByKey(form.getDpid_unexecute());
		//没有接班计划显示提示信息
		List<DutyPersonTB> dutyPersonList = dp.getDutyPersonList();
		if(dutyPersonList.isEmpty()) {
			throw new BLException("IGCO10000.E004","接班人基本");
		}
		String[] password = new String[dutyPersonList.size()];
		form.setPassword(password);
		dto.setDutyPersonList(dutyPersonList);
		log.debug("========值班交接确认信息查询处理结束========");
		return dto;
	}
	
	/**
	 * 值班交接确认处理
	 *
	 * @param dto IGDUT02DTO
	 * @return IGDUT02DTO
	 */
	public IGDUT02DTO confirmIGDUT0205Action(IGDUT02DTO dto) throws BLException {
		log.debug("========值班交接确认处理开始========");
		IGDUT0204Form form = dto.getIgDUT0204Form();
		String[] userids = form.getUserid();
		String[] passwords = form.getPassword();
		int i = 0;
		if(userids != null && passwords != null) {
			for(String userid : userids) {
				//用户名检查 
				User user = this.userBL.searchUserByKey(userid);
				
				if (!user.getPassword().equals(passwords[i++])){
					log.debug("========用户登录失败(密码不正确)========");
					//密码不正确
					throw new BLException("IGDUT0205.E002",user.getUsername());
				}
			}
		}
		//交班计划完结
		DutyPlan dp_executing = this.dutyPlanBL.searchDutyPlanByKey(form.getDpid_executing());
		//复制
		DutyPlanTB dp_executing_tb = (DutyPlanTB)SerializationUtils.clone(dp_executing);
		//交班人
		dp_executing_tb.setDpuserid(dto.getUser().getUserid());
		dp_executing_tb.setDpusername(dto.getUser().getUsername());
		//遗留问题
		dp_executing_tb.setDpquestion(form.getDpquestion());
		//总结
		dp_executing_tb.setDpinfo(form.getDpinfo());
		//状态改为已执行
		dp_executing_tb.setDpstatus(IGDUTCONSTANTS.PLAN_STATUS_EXECUTED);
		//完结时间
		dp_executing_tb.setDpfintime(IGStringUtils.getCurrentDateTime());
		//更新
		dutyPlanBL.updateDutyPlan(dp_executing_tb);
		
		//接班计划开始
		DutyPlan dp_unexecute = this.dutyPlanBL.searchDutyPlanByKey(form.getDpid_unexecute());
		DutyPlanTB dp_unexecute_tb = (DutyPlanTB)SerializationUtils.clone(dp_unexecute);
		//状态改为执行中
		dp_unexecute_tb.setDpstatus(IGDUTCONSTANTS.PLAN_STATUS_EXECUTING);
		//更新
		this.dutyPlanBL.updateDutyPlan(dp_unexecute_tb);
		dto.addMessage(new ActionMessage("IGDUT0205.I001"));
		log.debug("========值班交接确认处理结束========");
		return dto;
	}
	
	/**
	 * 值班中止详细信息查询处理
	 *
	 * @param dto IGDUT02DTO
	 * @return IGDUT02DTO
	 */
	public IGDUT02DTO initIGDUT0207Action(IGDUT02DTO dto) throws BLException {
		log.debug("========值班中止详细信息查询处理开始========");
		//查询执行中计划
		List<DutyPlan> dutyPlanList = this.dutyPlanBL.searchDutyPlan(dto.getDutyPlanSearchCond(), 0, 0);
		//没有执行中计划显示提示信息
		if(dutyPlanList.size() < 1 ) {
			throw new BLException("IGDUT0205.E003"); 
		} else {
			List<DutyPersonTB> dutyPersonList = dutyPlanList.get(0).getDutyPersonList();
			//判断登录用户是否是值班人
			//boolean flag = true;
			StringBuffer usersinfo = new StringBuffer();
			for(DutyPerson dp : dutyPersonList) {
				if(dp.getDperuserid().equals(dto.getUser().getUserid())) {
					//flag = false;
				}
				usersinfo.append(dp.getDperusername()).append("&nbsp;&nbsp;&nbsp;&nbsp;");
			}
//			if(flag) {
//				throw new BLException("IGDUT0204.E001"); 
//			}
			//查询执行中值班计划信息
			DutyResultSearchCondImpl dutyResultCond = new DutyResultSearchCondImpl();
			dutyResultCond.setDpid(dutyPlanList.get(0).getDpid());
			List<DutyResult> dutyResultList = dutyResultBL.searchDutyResult(dutyResultCond, 0, 0);
//			if(dutyResultList.isEmpty()) {
//				throw new BLException("IGCO10000.E004","值班日报基本"); 
//			}
			dto.setDutyResultList(dutyResultList);
			dto.setUsersinfo(usersinfo.toString());
			dto.setDutyPlan(dutyPlanList.get(0));
		}
		log.debug("========值班中止详细信息查询处理结束========");
		return dto;
	}
	
	/**
	 * 值班中止处理
	 *
	 * @param dto IGDUT02DTO
	 * @return IGDUT02DTO
	 */
	public IGDUT02DTO terminateIGDUT0207Action(IGDUT02DTO dto) throws BLException {
		log.debug("========值班中止处理开始========");
		IGDUT0207Form form = dto.getIgDUT0207Form();
		//交班计划完结
		DutyPlan dp_executing = this.dutyPlanBL.searchDutyPlanByKey(form.getDpid_executing());
		//复制
		DutyPlanTB dp_executing_tb = (DutyPlanTB)SerializationUtils.clone(dp_executing);
		//交班人
		dp_executing_tb.setDpuserid(dto.getUser().getUserid());
		dp_executing_tb.setDpusername(dto.getUser().getUsername());
		//遗留问题
		dp_executing_tb.setDpquestion(form.getDpquestion());
		//总结
		dp_executing_tb.setDpinfo(form.getDpinfo());
		//状态改为中止
		dp_executing_tb.setDpstatus(IGDUTCONSTANTS.PLAN_STATUS_TERMINATE);
		//完结时间
		dp_executing_tb.setDpfintime(IGStringUtils.getCurrentDateTime());
		//更新
		dutyPlanBL.updateDutyPlan(dp_executing_tb);
		
		dto.addMessage(new ActionMessage("IGDUT0207.I001"));
		log.debug("========值班中止处理结束========");
		return dto;
	}

	public IGDUT02DTO initIGDUT0202Action(IGDUT02DTO dto) throws BLException {
		UserRoleVWSearchCondImpl userRoleVWcond = new UserRoleVWSearchCondImpl();
		userRoleVWcond.setRoletype(IGDUTCONSTANTS.USER_ROLE_TYPE);
		List<UserRoleInfo> userRoleInfoList = userRoleBL.searchUserRoleVW(userRoleVWcond, 0, 0);
		List<UserRoleInfo> dayShiftUsers = new ArrayList<UserRoleInfo>(); 
		List<UserRoleInfo> nightShiftUsers = new ArrayList<UserRoleInfo>(); 
		List<String> tempList = new ArrayList<String>(); 
		for (UserRoleInfo userRoleInfo : userRoleInfoList) {
			if(tempList.contains(userRoleInfo.getUserid())){				
				continue;
			}
			dayShiftUsers.add(userRoleInfo);
			nightShiftUsers.add(userRoleInfo);
			tempList.add(userRoleInfo.getUserid());
		}
		List<UserRoleInfo> dayShiftDutyUsers = new ArrayList<UserRoleInfo>(); 
		List<UserRoleInfo> nightShiftDutyUsers = new ArrayList<UserRoleInfo>(); 
		List<DutyPlan> dutyPlanList = dutyPlanBL.searchDutyPlan(dto.getDutyPlanSearchCond(), 0, 0);
		for (DutyPlan dutyPlan : dutyPlanList) {
			Integer dpid = dutyPlan.getDpid();
			if(IGDUTCONSTANTS.DAY_SHIFT.equals(dutyPlan.getDptype())){ //白班
				DutyPersonSearchCondImpl dutyPersonCond = new DutyPersonSearchCondImpl();
				dutyPersonCond.setDpid(dpid);
				List<DutyPerson> dutyPersonList = dutyPersonBL.searchDutyPerson(dutyPersonCond, 0, 0);
				for (DutyPerson dutyPerson : dutyPersonList) {
					String dayShiftUserId = dutyPerson.getDperuserid();
					for (UserRoleInfo user : dayShiftUsers) {
						if(dayShiftUserId.equals(user.getUserid())){
							dayShiftDutyUsers.add(user);
						}
					}
				}
			} else if(IGDUTCONSTANTS.NIGHT_SHIFT.equals(dutyPlan.getDptype())){ //夜班
				DutyPersonSearchCondImpl dutyPersonCond = new DutyPersonSearchCondImpl();
				dutyPersonCond.setDpid(dpid);
				List<DutyPerson> dutyPersonList = dutyPersonBL.searchDutyPerson(dutyPersonCond, 0, 0);
				for (DutyPerson dutyPerson : dutyPersonList) {
					String nightShiftUserId = dutyPerson.getDperuserid();
					for (UserRoleInfo user : nightShiftUsers) {
						if(nightShiftUserId.equals(user.getUserid())){
							nightShiftDutyUsers.add(user);
						}
					}
				}
			}
		}
		dayShiftUsers.removeAll(dayShiftDutyUsers);
		nightShiftUsers.removeAll(nightShiftDutyUsers);
		dto.setDayShiftUsers(dayShiftUsers);
		dto.setNightShiftUsers(nightShiftUsers);
		dto.setDayShiftDutyUsers(dayShiftDutyUsers);
		dto.setNightShiftDutyUsers(nightShiftDutyUsers);
		return dto;
	}

	public IGDUT02DTO addDutyPersonAction(IGDUT02DTO dto) throws BLException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String nowdate = sdf.format(System.currentTimeMillis());
		IGDUT0202Form igdut0202Form = dto.getIgdut0202Form();	
		DutyPlanSearchCondImpl dutyPlanCond = new DutyPlanSearchCondImpl();
		dutyPlanCond.setDadcategory(igdut0202Form.getDadcategory());
		dutyPlanCond.setDptime(igdut0202Form.getDptime());
		dutyPlanCond.setDptype(IGDUTCONSTANTS.DAY_SHIFT);
		List<DutyPlan> dayDutyPlanList = dutyPlanBL.searchDutyPlan(dutyPlanCond, 0, 0);
		Integer dayDpid = null;
		Integer nightDpid = null;
		String[] dayShiftUserids = igdut0202Form.getDayShiftUserids();
		if(dayDutyPlanList.size() == 0 && dayShiftUserids != null){
			DutyPlanTB dutyPlanTB = new DutyPlanTB();
			dutyPlanTB.setDadcategory(igdut0202Form.getDadcategory());
			dutyPlanTB.setDpcretime(nowdate);
			dutyPlanTB.setDpstatus(IGDUTCONSTANTS.PLAN_STATUS_UNEXECUTE);
			dutyPlanTB.setDptype(IGDUTCONSTANTS.DAY_SHIFT);
			dutyPlanTB.setDptime(igdut0202Form.getDptime());
			DutyPlan retDutyPlan = dutyPlanBL.registDutyPlan(dutyPlanTB);
			dayDpid = retDutyPlan.getDpid();
		} else if(dayDutyPlanList.size() > 0 && dayShiftUserids != null){
			DutyPlanTB dutyPlanTB = (DutyPlanTB) dayDutyPlanList.get(0);
			dutyPlanTB.setDpupdtime(nowdate);
			DutyPlan retDutyPlan = dutyPlanBL.registDutyPlan(dutyPlanTB);
			dayDpid = retDutyPlan.getDpid();
		}
		dutyPlanCond.setDptype(IGDUTCONSTANTS.NIGHT_SHIFT);
		if(null != dayShiftUserids){
			for (String userid : dayShiftUserids) {
				DutyPersonTB dutyPersonTB = new DutyPersonTB();
				dutyPersonTB.setDperuserid(userid.split("__")[1].split(",,,,")[0]);
				dutyPersonTB.setDpertime(igdut0202Form.getDptime());
				dutyPersonTB.setDperusername(userid.split(",,,,")[1]);
				dutyPersonTB.setDpid(dayDpid);
				dutyPersonTB.setDptype(IGDUTCONSTANTS.DAY_SHIFT);
				dutyPersonBL.registDutyPerson(dutyPersonTB);
			}
		}

		String[] nightShiftUserids = igdut0202Form.getNightShiftUserids();
		List<DutyPlan> nightDutyPlanList = dutyPlanBL.searchDutyPlan(dutyPlanCond, 0, 0);
		if(nightDutyPlanList.size() == 0 && nightShiftUserids != null){
			DutyPlanTB dutyPlanTB = new DutyPlanTB();
			dutyPlanTB.setDadcategory(igdut0202Form.getDadcategory());
			dutyPlanTB.setDpcretime(nowdate);
			dutyPlanTB.setDpstatus(IGDUTCONSTANTS.PLAN_STATUS_UNEXECUTE);
			dutyPlanTB.setDptype(IGDUTCONSTANTS.NIGHT_SHIFT);
			dutyPlanTB.setDptime(igdut0202Form.getDptime());
			DutyPlan retDutyPlan = dutyPlanBL.registDutyPlan(dutyPlanTB);
			nightDpid = retDutyPlan.getDpid();
		} else if(nightDutyPlanList.size() > 0 && nightShiftUserids != null){
			DutyPlanTB dutyPlanTB = (DutyPlanTB) nightDutyPlanList.get(0);
			dutyPlanTB.setDpupdtime(nowdate);
			DutyPlan retDutyPlan = dutyPlanBL.registDutyPlan(dutyPlanTB);
			nightDpid = retDutyPlan.getDpid();
		}
		if(null != nightShiftUserids){
			for (String userid : nightShiftUserids) {
				DutyPersonTB dutyPersonTB = new DutyPersonTB();
				dutyPersonTB.setDperuserid(userid.split("__")[1].split(",,,,")[0]);
				dutyPersonTB.setDpertime(igdut0202Form.getDptime());
				dutyPersonTB.setDperusername(userid.split(",,,,")[1]);
				dutyPersonTB.setDpid(nightDpid);
				dutyPersonTB.setDptype(IGDUTCONSTANTS.NIGHT_SHIFT);
				dutyPersonBL.registDutyPerson(dutyPersonTB);
			}
		}
		dto.addMessage(new ActionMessage("IGCO10000.I010","值班人调整"));
		return dto;
	}

	public IGDUT02DTO removeDutyPersonAction(IGDUT02DTO dto) throws BLException {
		IGDUT0202Form igdut0202Form = dto.getIgdut0202Form();	
		String[] dayShiftDutyUserids = igdut0202Form.getDayShiftDutyUserids();
		String dadcategory = igdut0202Form.getDadcategory();
		String dptime = igdut0202Form.getDptime();
		if(null != dayShiftDutyUserids){		
			DutyPersonSearchCondImpl dutyPersonCond = new DutyPersonSearchCondImpl();
			dutyPersonCond.setDpertime(dptime);
			dutyPersonCond.setDptype(IGDUTCONSTANTS.DAY_SHIFT);
			for (String userid : dayShiftDutyUserids) {
				dutyPersonCond.setDperuserid(userid.split("__")[1]);
				List<DutyPerson> dutyPersonList = dutyPersonBL.searchDutyPerson(dutyPersonCond, 0, 0);
				for (DutyPerson dutyPerson : dutyPersonList) {
					dutyPersonBL.deleteDutyPerson(dutyPerson.getDperid());
				}
			}
			dutyPersonCond.setDperuserid(null);
			List<DutyPerson> dutyPersonList = dutyPersonBL.searchDutyPerson(dutyPersonCond, 0, 0);
			if(dutyPersonList.size() == 0){
				DutyPlanSearchCondImpl dutyPlanCond = new DutyPlanSearchCondImpl();
				dutyPlanCond.setDptime(dptime);
				dutyPlanCond.setDptype(IGDUTCONSTANTS.DAY_SHIFT);
				dutyPlanCond.setDadcategory(dadcategory);
				List<DutyPlan> dutyPlanList = dutyPlanBL.searchDutyPlan(dutyPlanCond, 0, 0);
				for (DutyPlan dutyPlan : dutyPlanList) {
					dutyPlanBL.deleteDutyPlan(dutyPlan.getDpid());
				}
			}
		}
		
		String[] nightShiftDutyUserids = igdut0202Form.getNightShiftDutyUserids();
		if(null != nightShiftDutyUserids){			
			DutyPersonSearchCondImpl dutyPersonCond = new DutyPersonSearchCondImpl();
			dutyPersonCond.setDpertime(igdut0202Form.getDptime());
			dutyPersonCond.setDptype(IGDUTCONSTANTS.NIGHT_SHIFT);
			for (String userid : nightShiftDutyUserids) {
				dutyPersonCond.setDperuserid(userid.split("__")[1]);
				List<DutyPerson> dutyPersonList = dutyPersonBL.searchDutyPerson(dutyPersonCond, 0, 0);
				for (DutyPerson dutyPerson : dutyPersonList) {
					dutyPersonBL.deleteDutyPerson(dutyPerson.getDperid());
				}
			}
			
			dutyPersonCond.setDperuserid(null);
			List<DutyPerson> dutyPersonList = dutyPersonBL.searchDutyPerson(dutyPersonCond, 0, 0);
			if(dutyPersonList.size() == 0){
				DutyPlanSearchCondImpl dutyPlanCond = new DutyPlanSearchCondImpl();
				dutyPlanCond.setDptime(dptime);
				dutyPlanCond.setDptype(IGDUTCONSTANTS.NIGHT_SHIFT);
				dutyPlanCond.setDadcategory(dadcategory);
				List<DutyPlan> dutyPlanList = dutyPlanBL.searchDutyPlan(dutyPlanCond, 0, 0);
				for (DutyPlan dutyPlan : dutyPlanList) {
					dutyPlanBL.deleteDutyPlan(dutyPlan.getDpid());
				}
			}
		}
		dto.addMessage(new ActionMessage("IGCO10000.I010","值班人调整"));
		return dto;
	}

	public IGDUT02DTO initIGDUT0201Action(IGDUT02DTO dto) throws BLException {
		int showYear = dto.getCalendarYear();
		int showMonth = dto.getCalendarMonth() + 1;
		Map<String,String> dutyUserMap = new HashMap<String,String>();
		String beginDate = showYear + "/" + appendZero(showMonth) + "/00";
		if (showMonth == 12) {
			showYear = showYear + 1;
			showMonth = 1;
		} else {
			showMonth++;
		}
		String endDate = showYear + "/" + appendZero(showMonth) + "/00";
		DutyPlanSearchCondImpl dutyPlanCond = new DutyPlanSearchCondImpl();
		dutyPlanCond.setDptime_ge(beginDate);
		dutyPlanCond.setDptime_le(endDate);
		dutyPlanCond.setDadcategory(dto.getIgdut0201Form().getDadcategory());
		List<DutyPlan> dutyPlanList = dutyPlanBL.searchDutyPlan(dutyPlanCond, 0, 0);
		List<Integer> dpidList = new ArrayList<Integer>();
		for (DutyPlan dutyPlan : dutyPlanList) {
			if(IGDUTCONSTANTS.PLAN_STATUS_EXECUTING.equals(dutyPlan.getDpstatus())){ //执行日期
				dutyUserMap.put(dutyPlan.getDptime(), IGDUTCONSTANTS.PLAN_STATUS_EXECUTING);
				if(dutyPlan.getDptype().equals(IGDUTCONSTANTS.DAY_SHIFT)){ //白班
					dutyUserMap.put(dutyPlan.getDptime() + IGDUTCONSTANTS.DAY_SHIFT, IGDUTCONSTANTS.DAY_SHIFT);
				}
			} else if(IGDUTCONSTANTS.PLAN_STATUS_EXECUTED.equals(dutyPlan.getDpstatus())
					|| IGDUTCONSTANTS.PLAN_STATUS_TERMINATE.equals(dutyPlan.getDpstatus())){ //已执行，执行中止
				if(dutyPlan.getDptype().equals(IGDUTCONSTANTS.NIGHT_SHIFT)){ //夜班
					dutyUserMap.put(dutyPlan.getDptime(), "34");
					dutyUserMap.put(dutyPlan.getDptime() + IGDUTCONSTANTS.NIGHT_SHIFT, IGDUTCONSTANTS.NIGHT_SHIFT);
				}
			}
			dpidList.add(dutyPlan.getDpid());
		}
		if(dutyPlanList.size() > 0){			
			DutyPersonSearchCondImpl dutyPersonCond = new DutyPersonSearchCondImpl();
			dutyPersonCond.setDpidList(dpidList);
			List<DutyPerson> dutyPersonList = dutyPersonBL.searchDutyPerson(dutyPersonCond, 0, 0);
			for (DutyPerson dutyPerson : dutyPersonList) {
				String key = dutyPerson.getDptype() + "_" + dutyPerson.getDpertime();
				String value = dutyPerson.getDperusername();
				if(dutyUserMap.containsKey(key)){
					dutyUserMap.put(key, dutyUserMap.get(key) + "," + value);
				} else {
					dutyUserMap.put(key, value);
				}
			}
		}
		dto.setDutyUserMap(dutyUserMap);
		return dto;
	}
	
	private String appendZero(int arg){
		if(arg < 10){
			return "0" + arg;
		}
		return String.valueOf(arg);
	}
	
	/**
	 * 值班日报初始化处理
	 *
	 * @param dto IGDUT02DTO
	 * @return IGDUT02DTO
	 */
	public IGDUT02DTO initIGDUT0203Action(IGDUT02DTO dto) throws BLException {
		log.debug("========值班日报初始化处理开始========");
		IGDUT0203Form form = dto.getIgDUT0203Form();
		if(form!=null){
			DutyPlanSearchCondImpl cond = new DutyPlanSearchCondImpl();
			cond.setDpstatus(IGDUTCONSTANTS.PLAN_STATUS_EXECUTING);//状态
			cond.setDadcategory(form.getDadcategory());//类型
			List<DutyPlan> planlist = dutyPlanBL.searchDutyPlan(cond, 0, 0);
			//存在值班计划时
			if(planlist!=null && planlist.size()==1){
				DutyPlan dutyPlan = planlist.get(0);
				dto.setDutyPlan(dutyPlan);//值班计划
				
				DutyPersonSearchCondImpl cond1 = new DutyPersonSearchCondImpl();
				cond1.setDpid(dutyPlan.getDpid());
				List<DutyPerson> personList = dutyPersonBL.searchDutyPerson(cond1, 0, 0);
				
				//判断登录用户是否是值班人
				boolean flag = true;
				StringBuffer buff = new StringBuffer();
				for(DutyPerson dp : personList) {
					if(dp.getDperuserid().equals(dto.getUser().getUserid())) {
						flag = false;
					}
					buff.append(dp.getDperusername()).append("&nbsp;&nbsp;");
				}
				if(flag) {
					throw new BLException("IGDUT0203.E001"); 
				}
				dto.setDptype(dutyPlan.getDptype());//值班时间
				dto.setUsersinfo(buff.toString());//值班人
				dto.setDpremarks(dutyPlan.getDpremarks());
		
				//查询当前值班计划下的值班日报信息
				DutyResultVWSearchCondImpl vwcond = new DutyResultVWSearchCondImpl();
				//白班时间
				String daytime_from = codeListUtils.getCodeValue(CodeDefine.DAYSHIFT_DUTY_PERIOD.getCcid(), "", "",(form.getDadcategory()+"001"));
				String daytime_to = codeListUtils.getCodeValue(CodeDefine.DAYSHIFT_DUTY_PERIOD.getCcid(), "", "",(form.getDadcategory()+"002"));
				//夜班时间
				String nighttime_from = codeListUtils.getCodeValue(CodeDefine.NIGHTSHIFT_DUTY_PERIOD.getCcid(), "", "",(form.getDadcategory()+"001"));
				String nighttime_to = codeListUtils.getCodeValue(CodeDefine.NIGHTSHIFT_DUTY_PERIOD.getCcid(), "", "",(form.getDadcategory()+"002"));
				//设置交接班时间
				dto.setNightStartTime(nighttime_from);
				
				//当前为白班时
				if(IGDUTCONSTANTS.DAY_SHIFT.equals(dutyPlan.getDptype())){
					vwcond.setDattime_form(daytime_from);
					vwcond.setDattime_to(daytime_to);
					vwcond.setDattime_q(null);
				}else{
					//当前为夜班时
					vwcond.setDattime_form(nighttime_from);
					vwcond.setDattime_to(nighttime_to);
					vwcond.setDattime_q("1");
				}

				vwcond.setDadcategory(form.getDadcategory());
				List<DutyResultVWInfo> vwlist = dutyResultVWBL.searchDutyResultVW(vwcond, 0, 0);
				if(vwlist!=null && vwlist.size()>0){
					Map<String,List<DutyResultVWInfo>> typeMap = new LinkedHashMap<String, List<DutyResultVWInfo>>();
					List<String>  dadtypeList = new ArrayList<String>();//检查分类集合
					List<Integer> dridList = new ArrayList<Integer>();//值班日报ID集合
					List<String> showList = new ArrayList<String>();//值班日报检查结果选择标识 0不可选 1可选
					List<String> showResultList = new ArrayList<String>();//结果说明是否可编辑
					for(DutyResultVWInfo vw:vwlist){
						if(!dadtypeList.contains(vw.getDadtype())){
							dadtypeList.add(vw.getDadtype());
						}
						if(vw.getDrid()!=null && vw.getDrid()!=0){
							if(!dridList.contains(vw.getDrid())){
								dridList.add(vw.getDrid());
							}
						}
					}
					dto.setDridList(dridList);//值班日报ID集合
					dto.setNum(vwlist.size());
					String dateTime=IGStringUtils.getCurrentDate();
					String week="";
					String month=dateTime.split("/")[2];
					String quarter=dateTime.substring(5);
					String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
					Calendar cal = Calendar.getInstance();
			        try {
						cal.setTime(sdf.parse(dateTime));
					} catch (Exception e) {
						log.debug(e.getMessage());
					}
			        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
			        week=weekDays[w];
					//将查询结果按检查分类进行分类
					for(String type:dadtypeList){
						List<DutyResultVWInfo> typeList = new ArrayList<DutyResultVWInfo>();
						for(DutyResultVWInfo vw:vwlist){
							if(vw.getDadtype()!=null && vw.getDadtype().equals(type)){
								if("week".equalsIgnoreCase(vw.getPeriodType())){
									//当周期类为：周
									if(week.equalsIgnoreCase(vw.getPeriodValue())){
										typeList.add(vw);
									}
								}else if("month".equalsIgnoreCase(vw.getPeriodType())){
									//当周期类型为：月
									if(month.equalsIgnoreCase(vw.getPeriodValue())){
										typeList.add(vw);
									}
								}else if("quarter".equalsIgnoreCase(vw.getPeriodType())){
									//当周期类型为：季
									if(vw.getPeriodValue().contains(quarter)){
										typeList.add(vw);
									}
								}else{
									//当周期类型为：天
									typeList.add(vw);
								}
								
							}
						}
						for(DutyResultVWInfo vw:typeList){
							//获取检查结果是否可选择
							getShowList(dto,vw,showList,showResultList);
						}
						typeMap.put(type, typeList);//tab表头,datalist
						
					}
					dto.setShowList(showList);
					dto.setShowResultList(showResultList);
					dto.setTypeMap(typeMap);
				}else{
					//dto.addMessage(new ActionMessage("IGDUT0203.I001"));
					throw new BLException("IGDUT0203.E003"); 
				}

			}else{
				//不存在执行中的值班计划
				throw new BLException("IGDUT0203.E002"); 
			}
		}
		log.debug("========值班日报初始化处理结束========");
		return dto;
	}
	
	/**
	 * 获取检查结果是否可选择
	 * @param dto
	 * @param vw
	 * @return
	 */
	@SuppressWarnings("static-access")
	private void getShowList(IGDUT02DTO dto, DutyResultVWInfo vw,
			List<String> showList, List<String> showResultList) {
		//获取检查计划
		DutyPlan dutyPlan=dto.getDutyPlan();
		//获取当前系统时间
		String nowtime=IGStringUtils.getCurrentDateTime();
		//选过检查结果的记录不允许再选择
		if(StringUtils.isNotEmpty(vw.getDrcontent())){
			//不可选择
			showList.add(IGDUTCONSTANTS.DADCONTENT_SHOW_DISABLE);
			//当前为白班时
			if(IGDUTCONSTANTS.DAY_SHIFT.equals(dutyPlan.getDptype())){
				String dattime=dutyPlan.getDptime()+" "+vw.getDattime();
				// 当检查时间大于等于当前系统时间时不可选择
				if(dattime.compareTo(nowtime) >=0){
					//不可选择
					showResultList.add(IGDUTCONSTANTS.DADCONTENT_SHOW_DISABLE);
				}else {
					//可选择
					showResultList.add(IGDUTCONSTANTS.DADCONTENT_SHOW_ABLE);
				}
			}else{
				//当前为夜班时
				//当前检查时间大于等于交接班时间
				if(vw.getDattime().compareTo(dto.getNightStartTime())>=0){
					String dattime=dutyPlan.getDptime()+" "+vw.getDattime();
					// 当检查时间大于当前系统时间时不可选择
					if(dattime.compareTo(nowtime) >=0){
						//不可选择
						showResultList.add(IGDUTCONSTANTS.DADCONTENT_SHOW_DISABLE);
					}else {
						//可选择
						showResultList.add(IGDUTCONSTANTS.DADCONTENT_SHOW_ABLE);
					}
				}else{
					//当前检查时间小于交接班时间
					DateFormat f1 = new SimpleDateFormat("yyyy/MM/dd");
					Calendar calendar = new GregorianCalendar();
					try {
						// 设置当前时间
						calendar.setTime(f1.parse(dutyPlan.getDptime()));
					} catch (ParseException e) {
						// 抛异常
					}
					calendar.add(calendar.DATE, 1);
					String date=f1.format(calendar.getTime());
					String dattime=date+" "+vw.getDattime();
					//当检查时间大于当前系统时间时不可选择
					if(dattime.compareTo(nowtime) >=0){
						//不可选择
						showResultList.add(IGDUTCONSTANTS.DADCONTENT_SHOW_DISABLE);
					}else {
						//可选择
						showResultList.add(IGDUTCONSTANTS.DADCONTENT_SHOW_ABLE);
					}
				}
			}
		}else{
			//当前为白班时
			if(IGDUTCONSTANTS.DAY_SHIFT.equals(dutyPlan.getDptype())){
				String dattime=dutyPlan.getDptime()+" "+vw.getDattime();
				// 当检查时间大于等于当前系统时间时不可选择
				if(dattime.compareTo(nowtime) >=0){
					//不可选择
					showList.add(IGDUTCONSTANTS.DADCONTENT_SHOW_DISABLE);
					showResultList.add(IGDUTCONSTANTS.DADCONTENT_SHOW_DISABLE);
				}else {
					//可选择
					showList.add(IGDUTCONSTANTS.DADCONTENT_SHOW_ABLE);
					showResultList.add(IGDUTCONSTANTS.DADCONTENT_SHOW_ABLE);
				}
			}else{
				//当前为夜班时
				//当前检查时间大于等于交接班时间
				if(vw.getDattime().compareTo(dto.getNightStartTime())>=0){
					String dattime=dutyPlan.getDptime()+" "+vw.getDattime();
					// 当检查时间大于当前系统时间时不可选择
					if(dattime.compareTo(nowtime) >=0){
						//不可选择
						showList.add(IGDUTCONSTANTS.DADCONTENT_SHOW_DISABLE);
						showResultList.add(IGDUTCONSTANTS.DADCONTENT_SHOW_DISABLE);
					}else {
						//可选择
						showList.add(IGDUTCONSTANTS.DADCONTENT_SHOW_ABLE);
						showResultList.add(IGDUTCONSTANTS.DADCONTENT_SHOW_ABLE);
					}
				}else{
					//当前检查时间小于交接班时间
					DateFormat f1 = new SimpleDateFormat("yyyy/MM/dd");
					Calendar calendar = new GregorianCalendar();
					try {
						// 设置当前时间
						calendar.setTime(f1.parse(dutyPlan.getDptime()));
					} catch (ParseException e) {
						// 抛异常
					}
					calendar.add(calendar.DATE, 1);
					String date=f1.format(calendar.getTime());
					String dattime=date+" "+vw.getDattime();
					//当检查时间大于当前系统时间时不可选择
					if(dattime.compareTo(nowtime) >=0){
						//不可选择
						showList.add(IGDUTCONSTANTS.DADCONTENT_SHOW_DISABLE);
						showResultList.add(IGDUTCONSTANTS.DADCONTENT_SHOW_DISABLE);
					}else {
						//可选择
						showList.add(IGDUTCONSTANTS.DADCONTENT_SHOW_ABLE);
						showResultList.add(IGDUTCONSTANTS.DADCONTENT_SHOW_ABLE);
					}
				}
			}
			
		}
	}

	
	/**
	 * 值班日报保存处理
	 *
	 * @param dto IGDUT02DTO
	 * @return IGDUT02DTO
	 */
	public IGDUT02DTO insertIGDUT0203Action(IGDUT02DTO dto) throws BLException {
		log.debug("========值班日报保存处理开始========");
		IGDUT0203Form form = dto.getIgDUT0203Form();
		User user = dto.getUser();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd;HH:mm");
		if(form!=null){
			DutyPlan dutyPlan = form.getDutyPlan();
			Integer[] dadids = form.getDadids();//检查项ID
			String[] dadtypes = form.getDadtypes();//检查分类
			String[] dadnames = form.getDadnames();//检查名称
			String[] dattimes = form.getDattimes();//检查时间
			//String[] datlimtimes = form.getDatlimtimes();//填报时间限制
			String[] dadcontents = form.getDadcontents();//检查结果类型
			String[] dadlimtimes = form.getDadlimtimes();//限制时间
			//List<Integer> dridList = form.getDridList();//值班日报id集合
			//String[] dadcontenttypes_hides = form.getDadcontenttypes_hides();//drcontent隐藏表单
			
			//页面输入
			String[] dadcontenttypes = form.getDadcontenttypes();//检查结果(drcontent,页面选择)
			String[] drfilltimes = form.getDrfilltimes();//实际填报时间
			String[] drresults = form.getDrresults();//结果说明
			if(dadids!=null && dadids.length>0){
					int num=0;
					List<DutyResult> dutyResultList=new ArrayList<DutyResult>();
					for(int i=0;i< dadids.length;i++){
						DutyResultSearchCondImpl cond=new DutyResultSearchCondImpl();
						cond.setDpid(dutyPlan.getDpid());
						cond.setDadid(dadids[i]);
						cond.setDattime(dattimes[i]);
						//根据值班类型、检查项查询日报信息
						List<DutyResult> dutyResultInfoList=this.dutyResultBL.searchDutyResult(cond, 0, 0);
						if(dutyResultInfoList!=null&&dutyResultInfoList.size()>0){
							for(DutyResult dutyResult:dutyResultInfoList){
								DutyResultTB dutyResultTB=(DutyResultTB) SerializationUtils.clone(dutyResult);
								if(StringUtils.isNotEmpty(dutyResultTB.getDrcontent())){
									dutyResultTB.setDrresult(drresults[num]);
								}else if(StringUtils.isNotEmpty(dadcontenttypes[num])){
									dutyResultTB.setDrcontent(StringUtils.isEmpty(dadcontenttypes[num])?"":dadcontenttypes[num]);//检查结果
									dutyResultTB.setDrresult(StringUtils.isEmpty(drresults[num])?"":drresults[num]);
									dutyResultTB.setDrfilltime(IGStringUtils.getCurrentDateTime().split(" ")[1]);//实际填报时间
									dutyResultTB.setDrcretime(IGStringUtils.getCurrentDateTime());//检查结果填写时间
									dutyResultTB.setDruserid(user.getUserid());
									dutyResultTB.setDrusername(user.getUsername());
								}
								dutyResultList.add(dutyResultTB);
							}
						}else{
							DutyResultTB drtb = new DutyResultTB();
							drtb.setDpid(dutyPlan.getDpid());
							drtb.setDadid(dadids[num]);
							drtb.setDadtype(StringUtils.isEmpty(dadtypes[num])?"":dadtypes[num]);
							drtb.setDadname(StringUtils.isEmpty(dadnames[num])?"":dadnames[num]);
							drtb.setDptime(dutyPlan.getDptime());
							drtb.setDptype(dutyPlan.getDptype());
							drtb.setDattime(StringUtils.isEmpty(dattimes[num])?"":dattimes[num]);
							drtb.setDadcontent(StringUtils.isEmpty(dadcontents[num])?"":dadcontents[num]);
							drtb.setDrcontent(StringUtils.isEmpty(dadcontenttypes[num])?"":dadcontenttypes[num]);//检查结果
							drtb.setDrresult(StringUtils.isEmpty(drresults[num])?"":drresults[num]);
							
							drtb.setDadcategory(form.getDadcategory());//值班类型
							
							//填报日、时限制计算
							String hour = dattimes[num].split(":")[0];
							String min = dattimes[num].split(":")[1];
							Calendar c = Calendar.getInstance();
							c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH), Integer.valueOf(hour), 
									Integer.valueOf(min));
							if(StringUtils.isNotEmpty(dadlimtimes[num])){
								c.add(Calendar.MINUTE, Integer.valueOf(dadlimtimes[num]));//限制时间
							}
							drtb.setDrlimdtime(sdf.format(c.getTime()));//保存时间限制
							drtb.setDatlimtime(sdf1.format(c.getTime()).split(";")[1]);//填报时间限制
							//如果页面可以选择，则要保存时间
							if(StringUtils.isNotEmpty(dadcontenttypes[num])){
								if(StringUtils.isEmpty(drfilltimes[num])){
									//当实际填报时间为空时 重新设置时间
									drtb.setDrfilltime(IGStringUtils.getCurrentDateTime().split(" ")[1]);//实际填报时间
									drtb.setDrcretime(IGStringUtils.getCurrentDateTime());//检查结果填写时间
									drtb.setDruserid(user.getUserid());
									drtb.setDrusername(user.getUsername());
								}
							}
							dutyResultList.add(drtb);
						}
						num++;
					}
					//循环更新检查结果
					for(DutyResult dutyResultInfo:dutyResultList){
						dutyResultBL.registDutyResult(dutyResultInfo);
					}
				// update by yagyyining start
				// 增加计划备注
				DutyPlanTB dp = (DutyPlanTB) SerializationUtils.clone(dutyPlanBL.searchDutyPlanByKey(dutyPlan.getDpid()));
				dp.setDpremarks(form.getDpremarks());
				dutyPlanBL.registDutyPlan(dp);
				// update by yangyining end
					
			}
			
		}

		log.debug("========值班日报保存处理结束========");
		return dto;
	}



	
	/**
	 * 未执行值班计划信息查询处理
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 */
	public IGDUT02DTO searchDutyPlanAction(IGDUT02DTO dto) throws BLException {

		log.debug("========未执行值班计划信息查询处理开始========");
		
		//启动列表初始
		DutyPlanSearchCondImpl co = new DutyPlanSearchCondImpl();
		co.setDadcategory(dto.getIgDUT0206Form().getDadcategory());
		co.setDpstatus(IGDUTCONSTANTS.PLAN_STATUS_EXECUTING);
		
		//值班时间条件
		co.setDptime(IGStringUtils.getCurrentDate());
		
		//校验是否有执行中的值班计划
		int exStatus = this.dutyPlanBL.getSearchCount(co);
		if (exStatus > 0) {
			log.debug("========执行中值班计划存在========");
			List<DutyPlan> dayDutyPlanList = this.dutyPlanBL.searchDutyPlan(co, 0, 0);
			DutyPlanTB dutyPlanTB = (DutyPlanTB) dayDutyPlanList.get(0);
			//白班/夜班
			String oldPassword = codeListUtils.getCodeValue(CodeDefine.DUTY_PLANTYPE.getCcid(), "", "", dutyPlanTB.getDptype());

			//可启动的值班计划不存在
			throw new BLException("IGDUT0206.E001", dutyPlanTB.getDptime(), oldPassword, dutyPlanTB.getDutyPersonName()); 
		} 

		//状态中止
		co.setDpstatus(IGDUTCONSTANTS.PLAN_STATUS_TERMINATE);
		//值班类型：晚班
		co.setDptype("2");
		
		int totalCount1 = this.dutyPlanBL.getSearchCount(co);
		
		if (totalCount1 > 0) {
			log.debug("========今日值班计划被终止========");
			//今日值班计划被终止
			dto.addMessage(new ActionMessage("IGDUT0205.E004"));
			return dto;
		} 
		//状态未执行
		co.setDpstatus(IGDUTCONSTANTS.PLAN_STATUS_UNEXECUTE);
		//值班类型
		co.setDptype("");
		
		int totalCount = this.dutyPlanBL.getSearchCount(co);
		
		if (totalCount == 0) {
			log.debug("========未执行值班计划信息查询数据不存在========");
			//未执行值班计划信息查询数据不存在
			dto.addMessage(new ActionMessage("IGDUT0206.E002"));
			return dto;
		} 
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========未执行值班计划信息数据件数过多========");
			//未执行值班计划信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		
		//启动只查询当天的值班计划
		co.setDptime_le(null);
		co.setDptime(IGStringUtils.getCurrentDate());

		//分页用信息取得
		PagingDTO pDto = dto.getPagingDto();

		//当前页信息取得
		List<DutyPlan> dutyPlanList = this.dutyPlanBL.searchDutyPlan(co, pDto.getFromCount(), pDto.getPageDispCount());

		
		pDto.setTotalCount(totalCount);
		
		dto.setDutyPlanList(dutyPlanList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========未执行值班计划信息查询处理终了========");
		return dto;
	}
	
	/**
	 * 值班计划启动处理
	 *
	 * @param dto IGDUT02DTO
	 * @return IGDUT02DTO
	 */
	public IGDUT02DTO changeDutyPlanAction(IGDUT02DTO dto) throws BLException {
		log.debug("========值班状态关闭/启用处理开始========");
		IGDUT0206Form form = dto.getIgDUT0206Form();
		
		DutyPlan rai = this.dutyPlanBL.searchDutyPlanByKey(form.getDpid());
		
		//复制对象
		DutyPlanTB pdTB = (DutyPlanTB)SerializationUtils.clone(rai);
		//执行中状态
		pdTB.setDpstatus(IGDUTCONSTANTS.PLAN_STATUS_EXECUTING);
		log.debug("========启动========");
		dto.addMessage(new ActionMessage( "IGDUT0206.I001", "") );
		
		this.dutyPlanBL.updateDutyPlan(pdTB);
		log.debug("========值班计划启动处理终了========");
		return dto;
	}
}
