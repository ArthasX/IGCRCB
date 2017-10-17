/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.wim.bl;

import java.awt.Color;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts.action.ActionMessage;
import org.eclipse.birt.report.model.api.util.StringUtil;
import org.springframework.beans.BeanUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.bl.task.OrganizationBL;
import com.deliverik.framework.user.bl.task.RoleBL;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.condition.OrganizationSearchCondImpl;
import com.deliverik.framework.user.model.condition.UserSearchCondImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.infogovernor.wim.bl.task.WorkDefinitionBL;
import com.deliverik.infogovernor.wim.bl.task.WorkInstanceBL;
import com.deliverik.infogovernor.wim.bl.task.WorkLogBL;
import com.deliverik.infogovernor.wim.dto.IGWIM02DTO;
import com.deliverik.infogovernor.wim.form.IGWIM0201Form;
import com.deliverik.infogovernor.wim.model.WorkDefinitionInfo;
import com.deliverik.infogovernor.wim.model.WorkInstanceInfo;
import com.deliverik.infogovernor.wim.model.WorkLogInfo;
import com.deliverik.infogovernor.wim.model.condition.WorkInstanceSearchCondImpl;
import com.deliverik.infogovernor.wim.model.condition.WorkLogSearchCondImpl;
import com.deliverik.infogovernor.wim.model.entity.WorkDefinitionTB;
import com.deliverik.infogovernor.wim.model.entity.WorkInstanceTB;
import com.deliverik.infogovernor.wim.model.entity.WorkLogTB;
import com.deliverik.infogovernor.wim.utils.IGDateUtils;

/**
 * @Description 工作管理BL实现，工作和处理日志业务实现类
 * 
 * @date 2017年6月14日13:42:31
 * 
 * @author zyl
 * @version 1.1
 * 改过的人，请更新版本
 *
 */
public class IGWIM02BLImpl extends BaseBLImpl implements IGWIM02BL{
	
	static Log log = LogFactory.getLog(IGWIM02BLImpl.class);
	
	/** 工作项管理BL注入 */
	protected WorkDefinitionBL workDefinitionBL;
	
	/** 工作BL注入 */
	protected WorkInstanceBL workInstanceBL;
	
	/** 机构BL注入 */
	protected OrganizationBL organizationBL;
	
	/** 用户BL注入 */
	protected UserBL userBL;
	
	/** 工作日志BL注入 */
	protected WorkLogBL workLogBL;
	
	/** 用户角色BL注入 */
	protected UserRoleBL userRoleBL;
	
	/** 角色BL注入 */
	protected RoleBL roleBL;

	
	/**
	 * 设定 角色BL
	 * 
	 * @param roleBL 角色BL
	 */
	public void setRoleBL(RoleBL roleBL) {
		this.roleBL = roleBL;
	}

	/**
	 * 设定 用户角色BL
	 * 
	 * @param userRoleBL 用户角色BL
	 */
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}

	/**
	 * 设定 工作日志BL
	 * 
	 * @param workLogBL 工作日志BL
	 */
	public void setWorkLogBL(WorkLogBL workLogBL) {
		this.workLogBL = workLogBL;
	}

	/**
	 * 用户BL设定
	 * @param 用户管理BL
	 */
	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
	}

	/**
	 * 机构BL设定
	 * @param 机构管理BL
	 */
	public void setOrganizationBL(OrganizationBL organizationBL) {
		this.organizationBL = organizationBL;
	}

	/**
	 * 工作项管理BL设定
	 * @param 工作项管理BL
	 */
	public void setWorkDefinitionBL(WorkDefinitionBL workDefinitionBL) {
		this.workDefinitionBL = workDefinitionBL;
	}
	
	/**
	 * 工作BL设定
	 * @param 工作BL
	 */
	public void setWorkInstanceBL(WorkInstanceBL workInstanceBL) {
		this.workInstanceBL = workInstanceBL;
	}
	
	/**
	 * @Description 工作查询，通过工作时间，从而获取所在的周，展示一周的工作
	 * @param dto IGWIM02DTO
	 * @return IGWIM02DTO
	 * @throws BLException
	 */
	public IGWIM02DTO getCurrentWorkByDateAction(IGWIM02DTO dto) throws BLException {
		log.info("=================工作查询展示一周的工作查询处理开始=================");
		IGWIM0201Form form = dto.getIgwim0201Form();
		//工作时间
		String workDate = form.getWorkDate();
		//人员
		String userid = form.getUserid();
		//第一次进页面
		if(StringUtils.isEmpty(userid)&&StringUtils.isEmpty(workDate)){
			workDate = IGStringUtils.getCurrentDate();
//			userid = dto.getUser().getUserid();
		}
		//获取日期栏日期
		List<String> dateToWeek = IGDateUtils.dateToWeekStr(workDate);
		dto.setDateList(dateToWeek);
		//获取日期栏日期（年），2017/05/20标准格式,日期比较、传参数用这个
		List<String> dateToWeekYear = IGDateUtils.dateToWeekYear(workDate);
		dto.setDateToWeekYearList(dateToWeekYear);
		// 分页用信息取得
		PagingDTO pDto = dto.getPagingDto();
		pDto.getPageDispCount();
		//设置查询条件
		WorkInstanceSearchCondImpl cond = new WorkInstanceSearchCondImpl();
		cond.setUserid(userid);
		cond.setWorkDate(workDate);
		cond.setLogin_userid(dto.getUser().getUserid());
		cond.setOrgsyscoding(form.getOrgsyscoding());
		//检索条数
		int totalCount = workInstanceBL.findWeekWorkByCond(cond, 0, 0).size();
		
		if (totalCount == 0) {
			log.info("========工作项检索数据不存在========");
			// 知识服务检索数据不存在
			dto.addMessage(new ActionMessage("IGBCM0101.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.info("========工作项数据件数过多========");
			// 用户检索数据件数过多
			dto.addMessage(new ActionMessage("IGBCM0101.E005", dto.getMaxSearchCount(), totalCount));
			return dto;
		}
		
		//调用BL查询工作信息
		List<Map<String, String>> wiList = workInstanceBL.findWeekWorkByCond(cond, pDto.getFromCount(), pDto.getPageDispCount());
		
		//保存查询结果集
		dto.setWiList(wiList);
		//设置分页总条数
		pDto.setTotalCount(totalCount);
		
		log.info("=================工作查询展示一周的工作查询处理结束=================");
		return dto;
	}
//	
//	/**
//	 * @Description 工作查询，通过工作时间，从而获取所在的周，展示一周的工作(初始化)
//	 * @param dto IGWIM02DTO
//	 * @return IGWIM02DTO
//	 * @throws BLException
//	 */
//	public IGWIM02DTO getCurrentWorkByDateInitAction(IGWIM02DTO dto) throws BLException {
//		log.info("=================工作查询展示一周的工作初始化处理开始=================");
//		IGWIM0201Form form = dto.getIgwim0201Form();
//		//工作时间
//		String workDate = IGStringUtils.getCurrentDate();
//		//部门
//		String orgsyscoding = dto.getUser().getOrgid();
//		//人员
//		String userid = dto.getUser().getUserid();
//		
//		
//		
//		log.info("=================工作查询展示一周的工作初始化处理结束=================");
//		return dto;
//	}
	/**
	 * @Description 获取中心部门
	 * @param dto IGWIM02DTO
	 * @return IGWIM02DTO
	 * @throws BLException
	 * @author zyl
	 */
	public IGWIM02DTO getCenterOrgAction(IGWIM02DTO dto) throws BLException {
		log.info("=================获取中心部门数据开始=================");
		//机构格式 Map<orgsyscoding,orgname>有序
		Map<String,String> orgMap = new LinkedHashMap<String, String>();
		//查询中心下的所有机构
		OrganizationSearchCondImpl cond = new OrganizationSearchCondImpl();
		//查询用户是否具体最高权限，既查看所有用户的工作
		boolean hasMostPower = hasMostPower(dto.getUser().getUserid());
		if(hasMostPower){
			//最高权限的为科技部领导，顶级机构先入库
			orgMap.put(IGWIMCONSTANTS.IGWIM_ORGPAR_CENTER_CODE, IGWIMCONSTANTS.IGWIM_ORGPAR_CENTER_NAME);
			//通过父级编码找中心部门
			cond.setOrgpar(IGWIMCONSTANTS.IGWIM_ORGPAR_CENTER_CODE);
			cond.setOrgparid(IGWIMCONSTANTS.IGWIM_ORGPAR_CENTER_CODE);
			List<Organization> orgList = organizationBL.searchOrganization(cond);
			if(CollectionUtils.isNotEmpty(orgList)){
				for(Organization orgInfo : orgList){
					String orgname = orgInfo.getOrgname();
					orgMap.put(orgInfo.getOrgsyscoding(), orgInfo.getOrgname().substring(orgname.lastIndexOf("-")+1,orgname.length()));
				}
			}else{
				throw new BLException("IGCO10000.E141", "信息科技部下各中心信息不存在");
			}
		}else{
			//负责人权限,可查看自己部门下所有人的工作
			String orgsyscoding = hasLeaderPower(dto.getUser().getUserid());
			if(StringUtils.isNotEmpty(orgsyscoding)){
				//通过机构编码找中心部门
//				//机构码
//				String orgsyscoding = dto.getUser().getOrgid();
//				//用户机构不直接在中心上的情况，不合实际场景，补充漏洞
//				if(orgsyscoding.length()>(IGWIMCONSTANTS.IGWIM_ORGPAR_CENTER_CODE.length()+3))
//					orgsyscoding = orgsyscoding.substring(0, IGWIMCONSTANTS.IGWIM_ORGPAR_CENTER_CODE.length()+3);
				cond.setOrgsyscoding(orgsyscoding);
				List<Organization> orgList = organizationBL.searchOrganization(cond);
				if(CollectionUtils.isNotEmpty(orgList)){
					for(Organization orgInfo : orgList){
						String orgname = orgInfo.getOrgname();
						orgMap.put(orgInfo.getOrgsyscoding(), orgInfo.getOrgname().substring(orgname.lastIndexOf("-")+1,orgname.length()));
					}
				}else{
					throw new BLException("IGCO10000.E141", "用户所在机构不在中心负责人管理范围内");
				}
			}else{
				//普通用户，不具有负责人和科技总经理权限，只能看自己的工作
				//机构码
				String orgsyscode = dto.getUser().getOrgid();
				//用户机构不直接在中心上的情况，不合实际场景，补充漏洞
				if(orgsyscode.length()>=(IGWIMCONSTANTS.IGWIM_ORGPAR_CENTER_CODE.length()+3)){
					orgsyscode = orgsyscode.substring(0, IGWIMCONSTANTS.IGWIM_ORGPAR_CENTER_CODE.length()+3);
				}else{
					throw new BLException("IGCO10000.E141", "用户所在机构不在信息科技部下各中心");
				}
				cond.setOrgsyscoding(orgsyscode);
				List<Organization> orgList = organizationBL.searchOrganization(cond);
				if(CollectionUtils.isNotEmpty(orgList)){
					for(Organization orgInfo : orgList){
						String orgname = orgInfo.getOrgname();
						orgMap.put(orgInfo.getOrgsyscoding(), orgInfo.getOrgname().substring(orgname.lastIndexOf("-")+1,orgname.length()));
					}
				}else{
					throw new BLException("IGCO10000.E141", "用户所在机构不在信息科技部下各中心");
				}
			}
		}
		dto.setOrgMap(orgMap);
		log.info("=================获取中心部门数据结束=================");
		return dto;
	}
/**
 * hasLeaderPower是否具有负责人权限、既查看本机构下用户工作的权限
 * @param orgsyscoding 此角色说管理的机构码
 * @return hasLeaderPower
 */
	private String hasLeaderPower(String userid) {
		//是否具有负责人权限
		String orgsyscoding = "";
		for(LeaderRoleids roleid : LeaderRoleids.values()){
			Integer id = Integer.parseInt(roleid.toString().split("_")[1]);
			//是否具有查看本机构下用户的权限
			boolean tempPower = userRoleBL.isRoleInUserRole(userid, id);
			if(tempPower){
				Role roleInfo;
				try {
					roleInfo = roleBL.searchRoleByKey(id);
					orgsyscoding = roleInfo.getRoledomain();
					return orgsyscoding;
				} catch (BLException e) {
					log.error("查询角色报错roleid："+id+"---"+e.getMessage());
					e.printStackTrace();
				}
			}
		}
		return orgsyscoding;
	}
	/**
	 * hasMostPower 查询用户是否具体最高权限，既查看所有用户的工作
	 * @param userid 用户id
	 * @return boolean
	 */
	private boolean hasMostPower(String userid) {
		//是否具有查看所有工作的最大权限
		boolean hasMostPower = userRoleBL.isRoleInUserRole(userid, IGWIMCONSTANTS.IGWIM_MOST_POWER_ROLEID);
		return hasMostPower;
	}

	/**
	 * @Description 获取中心部门下的人
	 * 格式：List<Map<orgid,orgid>,Map<orgname,orgname>,Map<username,username>,Map<userid,userid>>
	 * @param dto IGWIM02DTO
	 * @return IGWIM02DTO
	 * @throws BLException
	 * @author zyl
	 */
	public IGWIM02DTO getCenterOrgUserAction(IGWIM02DTO dto) throws BLException {
		log.info("=================获取中心部门下的人开始=================");
		//返回数据格式：List<Map<orgid,orgid>,Map<orgname,orgname>,Map<username,username>,Map<userid,userid>>
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		//创建添加空行的下拉列表值
		Map<String,String> orgMap = new HashMap<String, String>();
		//创建添加空行的下拉列表值
		Map<String,String> centerMap = new HashMap<String, String>();
		//获取中心下所有的用户，用于页面选机构表单联动
		UserSearchCondImpl cond = new UserSearchCondImpl();
		//科技总经理权限，最高权限，看到所有人
		boolean hasMostPower = hasMostPower(dto.getUser().getUserid());
		if(hasMostPower){
			cond.setOrgid_like(IGWIMCONSTANTS.IGWIM_ORGPAR_CENTER_CODE);
			List<User> userList = userBL.searchUser(cond);
			if(CollectionUtils.isNotEmpty(userList)){
				for(User user : userList){
					//判断此机构是否录入过
					if(StringUtils.isEmpty(orgMap.get(user.getOrgid()))){
						orgMap.put(user.getOrgid(), user.getOrgid());
						Map<String,String> map = new HashMap<String, String>();
						map.put("orgsyscoding", user.getOrgid());//机构码，联动用
						map.put("username", "");//用户名，用户显示
						map.put("userid", "");//用户id，用户查询
						list.add(map);
					}
					Map<String,String> map = new HashMap<String, String>();
					map.put("orgsyscoding", user.getOrgid());//机构码，联动用
					map.put("username", user.getUsername());//用户名，用户显示
					map.put("userid", user.getUserid());//用户id，用户查询
					list.add(map);
				}
			}
		}else{
			
			//负责人权限,查看自己部门的人
			String orgsyscoding = hasLeaderPower(dto.getUser().getUserid());
			if(StringUtils.isNotEmpty(orgsyscoding)){
				cond.setOrgid_like(orgsyscoding);
				List<User> userList = userBL.searchUser(cond);
				if(CollectionUtils.isNotEmpty(userList)){
					for(User user : userList){
						if(StringUtils.isEmpty(centerMap.get(user.getOrgid()))){
							centerMap.put(user.getOrgid(), user.getOrgid());
							Map<String,String> map = new HashMap<String, String>();
							map.put("orgsyscoding", user.getOrgid());//机构码，联动用
							map.put("username", "");//用户名，用户显示
							map.put("userid", "");//用户id，用户查询
							list.add(map);
						}
						Map<String,String> map = new HashMap<String, String>();
						map.put("orgsyscoding", user.getOrgid());//机构码，联动用
						map.put("username", user.getUsername());//用户名，用户显示
						map.put("userid", user.getUserid());//用户id，用户查询
						list.add(map);
					}
				}
				
			}else{
				//普通人，看自己就可以了
				Map<String,String> map = new HashMap<String, String>();
				map.put("orgsyscoding", dto.getUser().getOrgid());//机构码，联动用
				map.put("username", dto.getUser().getUsername());//用户名，用户显示
				map.put("userid", dto.getUser().getUserid());//用户id，用户查询
				list.add(map);
			}
		}
		dto.setUserOrgList(list);
		log.info("=================获取中心部门下的人结束=================");
		return dto;
	}
	/**
	 * @Description 周期工作确认处理初始化
	 * @param dto IGWIM02DTO
	 * @return IGWIM02DTO
	 * @throws BLException
	 * @author zyl
	 */
	public IGWIM02DTO confirmCycleWorkInit(IGWIM02DTO dto) throws BLException {
		log.info("=================周期工作确认初始化处理开始=================");
		IGWIM0201Form form = dto.getIgwim0201Form();
		Integer wiid = form.getWiid();
		if(wiid!=null&&wiid>0){
			//工作实例
			WorkInstanceInfo wiInfo = getWorkInstanceInfo(wiid);
			WorkLogSearchCondImpl cond = new WorkLogSearchCondImpl();
			cond.setWiid(wiid);
			//非保存状态
			cond.setBtnAction("1");
			//查询工作处理日志
			List<WorkLogInfo> wlogList = workLogBL.searchWorkLog(cond);
			WorkInstanceTB wi = (WorkInstanceTB)SerializationUtils.clone(wiInfo);
			//如果工作实例中执行时间为空，则查询所有执行人处理时间之和
			dto = getTotalExcuteTime(dto);
			if(StringUtils.isNotEmpty(dto.getTotalExcuteTime())&&(!"0".equals(dto.getTotalExcuteTime()))){
				wi.setExcuteTime(dto.getTotalExcuteTime());
			}
			//工作实例传值
			dto.setWiInfo(wi);
			//工作处理日志集合传值
			dto.setWlogList(wlogList);
			//取得工作项对象
			log.info("was服务器取不到工作项描述，id="+wiInfo.getWdid());
			WorkDefinitionInfo workDefinitionInfo = workDefinitionBL.searchWorkDefinitionByPK(wiInfo.getWdid());
			log.info("was服务器取不到工作项描述，desc="+workDefinitionInfo.getDescription());
			dto.setDesc(workDefinitionInfo.getDescription());
		}
		log.info("=================周期工作确认初始化处理结束=================");
		return dto;
	}
	/**
	 * @Description 周期工作确认处理
	 * @param dto IGWIM02DTO
	 * @return IGWIM02DTO
	 * @throws BLException
	 * @author zyl
	 * @modifier WangLiang
	 * @modifyContent 工作结束后需要同步更新工作项定义表的实际完成时间字段
	 */
	public IGWIM02DTO confirmCycleWork(IGWIM02DTO dto) throws BLException {
		log.info("=================周期工作确认处理开始=================");
		IGWIM0201Form form = dto.getIgwim0201Form();
		//1.工作实例基本信息入库
		Integer wiid = form.getWiid();
		//工作实例
		WorkInstanceInfo wiInfo = getWorkInstanceInfo(wiid);
		WorkInstanceTB wiTB = (WorkInstanceTB) SerializationUtils.clone(wiInfo);
		//情况描述
		wiTB.setWiDescription(form.getWiDescription());
		//处理历时
		wiTB.setExcuteTime(form.getExcuteTime());
		//处理日期
		wiTB.setConfirmDate(IGStringUtils.getCurrentDateTime());
		//处理过变成结束状态
		wiTB.setWistatus(form.getWistatus());
		workInstanceBL.updateWorkInstance(wiTB);
		
		//==========同步更新工作项定义表的实际完成时间开始  Wangliang==========
		
//		WorkDefinitionTB workDefinitionTB = new WorkDefinitionTB();
		//获取工作定义对象
//		WorkDefinitionInfo workDefinitionInfo = workDefinitionBL.searchWorkDefinitionByPK(wiInfo.getWdid());
		//Copy工作项定义TB
//		BeanUtils.copyProperties(workDefinitionInfo, workDefinitionTB);
		//设置工作项实际完成时间(以下注释逻辑为，当最后一个工作完毕之后立即置实际完成时间)------------------赵梓廷  2017/07/03
		//如果当前日期超过预计完成时间或者没有超过预计完成时间，但是状态已经中止，判断是否是工作最后一条，如果是，设置当前时间为实际完成时间,
//		if(IGStringUtils.getCurrentDateTime().compareTo(workDefinitionInfo.getEstimateFinishDate())>=0||
//				(IGStringUtils.getCurrentDateTime().compareTo(workDefinitionInfo.getEstimateFinishDate())<0&&"0".equals(workDefinitionInfo.getWdstatus()))){
//			//查询当前工作是否是最后一条没有处理结束的，如果是则设置实际完成时间
//			WorkInstanceSearchCondImpl cond = new WorkInstanceSearchCondImpl();
//			cond.setWdid(wiInfo.getWdid());
//			cond.setWiid(wiid);
//			String count = workInstanceBL.getExcutedCount(cond);
//			if("0".equals(count)){
//				workDefinitionTB.setActualFinishDate(IGStringUtils.getCurrentDateTime());
//			}	
//		}else if(IGStringUtils.getCurrentDateTime().compareTo(workDefinitionInfo.getEstimateFinishDate())<0&&"1".equals(workDefinitionInfo.getWdstatus())){
//			//判断同一配置项的其他工作是否都已结束
//			WorkInstanceSearchCondImpl cond = new WorkInstanceSearchCondImpl();
//			cond.setWdid(wiInfo.getWdid());
//			cond.setWiid(wiid);
//			String count = workInstanceBL.getExcutedCount(cond);
//			//如果在预计完成时间之内，判断是否是最后一条工作，如果是，根据周期判断出最后一次发起工作的日期，判断当前时间是否已经超过这个日期，如果是，则设置当前时间为实际完成时间			
//			if("day".equals(workDefinitionInfo.getCycle())){
//				isSetOverTimeByDay(workDefinitionTB, workDefinitionInfo, count);				
//			}else if("week".equals(workDefinitionInfo.getCycle())){				      
//				isSetOverTimeByWeek(workDefinitionTB, workDefinitionInfo, count);					
//			}else if("month".equals(workDefinitionInfo.getCycle())){
//				isSetOverTimeByMonth(workDefinitionInfo);				
//					
//			}else if("quarter".equals(workDefinitionInfo.getCycle())){
//				//根据预计完成时间、开始时间判断最后一次执行发起工作时间
//				isSetOverTimeByQuarter(workDefinitionTB, workDefinitionInfo,count);
//			}else if("halfyear".equals(workDefinitionInfo.getCycle())){
//				isSetOverTimeByHalfyear(workDefinitionTB, workDefinitionInfo,count);
//			}else if("year".equals(workDefinitionInfo.getCycle())){
//				isSetOverTimeByYear(workDefinitionTB, workDefinitionInfo,count);
//			}
//			
//		}
		
		//更新工作项定义表
//		workDefinitionBL.updateWorkDefinition(workDefinitionTB);
		//==========同步更新工作项定义表的实际完成时间结束  Wangliang==========
		
		log.info("=================周期工作确认处理结束=================");
		return dto;
	}

	private void isSetOverTimeByMonth(WorkDefinitionInfo workDefinitionInfo) {
		//找到最后一次发起工作的时间
		String lastovertime = "";
		//如果设置的为每月最后一天，
		if("Y".equals(workDefinitionInfo.getMonthLastDay())){					
			//查询预计完成时间是否是该月最后一天，如果是，则判断预计完成时间加上时分是否小于预计完成时间，如果小于，则最后一次发起工作时间为预计完成时间加上时、分，如果大于，则查询上一个月的最后一天日期加上时分
			Calendar calendar = Calendar.getInstance();   
			// 设置时间,当前时间不用设置   
			calendar.setTime(new Date(workDefinitionInfo.getEstimateFinishDate().substring(0, 10)));   
			if(calendar.get(Calendar.DATE)==calendar.getActualMaximum(Calendar.DAY_OF_MONTH)){
		        //判断时分是否小于预计时间的时分，如果小于，则取预计完成时间加时分，如果大于，则查找上一个月的最后一天日期
				if(workDefinitionInfo.getEstimateFinishDate().substring(10, workDefinitionInfo.getEstimateFinishDate().length()-1).compareTo(" "+workDefinitionInfo.getWdhour()+":"+workDefinitionInfo.getWdminute())>=0){
					lastovertime = workDefinitionInfo.getEstimateFinishDate().substring(0, 10)+" "+workDefinitionInfo.getWdhour()+":"+workDefinitionInfo.getWdminute();
				}else{
					SimpleDateFormat formatter=new SimpleDateFormat("yyyy/MM/dd");  
					//查找上一个月的最后一天日期
					int month = calendar.get(Calendar.MONTH);
					calendar.set(Calendar.MONTH, month-1);
					calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DAY_OF_MONTH));  
					Date strDateTo = calendar.getTime();  
					lastovertime = formatter.format(strDateTo)+" "+workDefinitionInfo.getWdhour()+":"+workDefinitionInfo.getWdminute();
				}
		    }else{
		    	//查找上一个月的最后一天日期
		    	SimpleDateFormat formatter=new SimpleDateFormat("yyyy/MM/dd");  
				int month = calendar.get(Calendar.MONTH);
				calendar.set(Calendar.MONTH, month-1);
				calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DAY_OF_MONTH));  
				Date strDateTo = calendar.getTime();  
				lastovertime = formatter.format(strDateTo)+" "+workDefinitionInfo.getWdhour()+":"+workDefinitionInfo.getWdminute();
		    }
		}else{
			//如果不是每月最后一天，则判断预计完成日期是否大于选中日周期，如果大于则查询上一个月该日加上时分为最后一次发起工作的时间，如果小于，则取得当月的日加上时分为最后一次发起工作时间
			String wdmonth = "";
			if(workDefinitionInfo.getWdmonth().length()==1){
				wdmonth = "0"+workDefinitionInfo.getWdmonth();
			}else{
				wdmonth = workDefinitionInfo.getWdmonth();
			}
			if(workDefinitionInfo.getEstimateFinishDate().substring(8,10).compareTo(wdmonth)>0){
				lastovertime = workDefinitionInfo.getEstimateFinishDate().substring(0,8)+wdmonth+" "+workDefinitionInfo.getWdhour()+":"+workDefinitionInfo.getWdminute();
			}else if(workDefinitionInfo.getEstimateFinishDate().substring(8,10).compareTo(wdmonth)==0){
				//
				if(workDefinitionInfo.getEstimateFinishDate().substring(10,workDefinitionInfo.getEstimateFinishDate().length()-1).compareTo(" "+workDefinitionInfo.getWdhour()+":"+workDefinitionInfo.getWdminute())>0){
					lastovertime = workDefinitionInfo.getEstimateFinishDate().substring(0,8)+wdmonth+" "+workDefinitionInfo.getWdhour()+":"+workDefinitionInfo.getWdminute();
				}else{
					//如果当前选中的为1月份，那么上一个月为去年的12月份
					if("1".equals(workDefinitionInfo.getWdmonth())){
						Integer beforeyear = Integer.parseInt(workDefinitionInfo.getEstimateFinishDate().substring(0,4))-1;
						lastovertime = beforeyear+"/12/"+wdmonth+" "+workDefinitionInfo.getWdhour()+":"+workDefinitionInfo.getWdminute();
					}else{
						Integer newwdmonth = Integer.parseInt(workDefinitionInfo.getWdmonth())-1;
						if(String.valueOf(newwdmonth).length()==1){
							wdmonth = "0"+newwdmonth;
						}else{
							wdmonth = String.valueOf(newwdmonth);
						}
						lastovertime = workDefinitionInfo.getEstimateFinishDate().substring(0,8)+wdmonth+" "+workDefinitionInfo.getWdhour()+":"+workDefinitionInfo.getWdminute();
					}
					
				}
			}else{
				//上一个月本天的日期
				//如果当前选中的为1月份，那么上一个月为去年的12月份
				if("1".equals(workDefinitionInfo.getWdmonth())){
					Integer beforeyear = Integer.parseInt(workDefinitionInfo.getEstimateFinishDate().substring(0,4))-1;
					lastovertime = beforeyear+"/12/"+wdmonth+" "+workDefinitionInfo.getWdhour()+":"+workDefinitionInfo.getWdminute();
				}else{
					Integer newwdmonth = Integer.parseInt(workDefinitionInfo.getWdmonth())-1;
					if(String.valueOf(newwdmonth).length()==1){
						wdmonth = "0"+newwdmonth;
					}else{
						wdmonth = String.valueOf(newwdmonth);
					}
					lastovertime = workDefinitionInfo.getEstimateFinishDate().substring(0,8)+wdmonth+" "+workDefinitionInfo.getWdhour()+":"+workDefinitionInfo.getWdminute();
				}
			}
		}
	}
	/**
	 * 计算两个日期之间的月数差
	 *<p>
	 * Description: 
	 *</p>
	 *  
	 * @param date1
	 * @param date2
	 * @return
	 * @throws ParseException
	 */
	public int getMonthSpace(String date1, String date2){

        int result = 0;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        try {
			c1.setTime(sdf.parse(date1));
			c2.setTime(sdf.parse(date2));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        result = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);

        return result == 0 ? 1 : Math.abs(result);

    }
	private void isSetOverTimeByWeek(WorkDefinitionTB workDefinitionTB,
			WorkDefinitionInfo workDefinitionInfo, String count) {
		//找到最后一次发起工作的时间
		String lastovertime = "";
		//判断预计完成时间为星期几
		int weeknum = IGDateUtils.dateToWeekByNum(workDefinitionInfo.getEstimateFinishDate());
		//选中的周期为星期几
		int selectedweeknum = 0;
		String[] weekOfDays = {"MON", "TUE", "WED", "THU", "FRI", "SAT","SUN"};  
		for(int i=0;i<weekOfDays.length;i++){
			if(weekOfDays[i].equals(workDefinitionInfo.getWdweek())){
				selectedweeknum = i;
				break;
			}
		}
		if(weeknum>selectedweeknum){
			//得到该预计完成时间所在周，按照当前为周几判定时间
			lastovertime = IGDateUtils.getdateToWeek(workDefinitionInfo.getEstimateFinishDate().substring(0, 10),selectedweeknum)+" "+workDefinitionInfo.getWdhour()+":"+workDefinitionInfo.getWdminute();
		}else if(weeknum==selectedweeknum){
			//判断预计完成时间是否大于设置的时分，如果大于时分，则直接取当天的日期，否则取上一周的日期
			if(workDefinitionInfo.getEstimateFinishDate().substring(10, workDefinitionInfo.getEstimateFinishDate().length()-1).compareTo(" "+workDefinitionInfo.getWdhour()+":"+workDefinitionInfo.getWdminute())>=0){
				lastovertime = workDefinitionInfo.getEstimateFinishDate().substring(0, 10)+" "+workDefinitionInfo.getWdhour()+":"+workDefinitionInfo.getWdminute();
			}else{
				//查找上一周的日期
				lastovertime = IGDateUtils.getbeforeweekDate(workDefinitionInfo.getEstimateFinishDate().substring(0, 10))+" "+workDefinitionInfo.getWdhour()+":"+workDefinitionInfo.getWdminute();
			}
		}else{
			//直接找上一周的日期
			lastovertime = IGDateUtils.getbeforeweekDate(workDefinitionInfo.getEstimateFinishDate().substring(0, 10))+" "+workDefinitionInfo.getWdhour()+":"+workDefinitionInfo.getWdminute();					
		}			
		//如果当前时间大于最后一次发起工作时间，则设置实际完成时间
		if(IGStringUtils.getCurrentDateTime().compareTo(lastovertime)>=0&&"0".equals(count)){
			workDefinitionTB.setActualFinishDate(IGStringUtils.getCurrentDateTime());
		}
	}

	private void isSetOverTimeByDay(WorkDefinitionTB workDefinitionTB,
			WorkDefinitionInfo workDefinitionInfo, String count) {
		//找到最后一次发起工作的时间
		String lastovertime = "";
		//将预计完成时间截取到天，在添加上小时和分钟是否小于预计完成时间，如果是，则该时间为最后一次发起工作时间，否则将预计完成时间提前一天，添加上小时和分钟，为最后一次发起工作的时间
		String temptime = workDefinitionInfo.getEstimateFinishDate().substring(0, 10)+" "+workDefinitionInfo.getWdhour()+":"+workDefinitionInfo.getWdminute();
		if(temptime.compareTo(workDefinitionInfo.getEstimateFinishDate())<0){
			lastovertime = temptime;
		}else{
			//得到预计完成时间的前一天，加上时、分
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
			Calendar c = Calendar.getInstance(); 
			Date date=null; 
			try { 
				date = simpleDateFormat.parse(workDefinitionInfo.getEstimateFinishDate().substring(0, 10));
			} catch (ParseException e) {
				 e.printStackTrace(); 
			}
			 c.setTime(date); 
			 int day=c.get(Calendar.DATE); 
			 c.set(Calendar.DATE,day-1); 
			 String dayBefore=new SimpleDateFormat("yyyy/MM/dd").format(c.getTime()); 
			 lastovertime = dayBefore+" "+workDefinitionInfo.getWdhour()+":"+workDefinitionInfo.getWdminute();
		}
		//如果当前时间大于最后一次发起工作时间，则设置实际完成时间
		if(IGStringUtils.getCurrentDateTime().compareTo(lastovertime)>=0&&"0".equals(count)){
			workDefinitionTB.setActualFinishDate(IGStringUtils.getCurrentDateTime());
		}
	}

	@SuppressWarnings("deprecation")
	private void isSetOverTimeByYear(WorkDefinitionTB workDefinitionTB,
			WorkDefinitionInfo workDefinitionInfo,String count) {
		//根据预计完成时间、开始时间判断最后一次执行发起工作时间
		//获取开始时间
		String beginDate = workDefinitionInfo.getBeginDate();
		//获取预计完成时间
		String estimateFinishDate = workDefinitionInfo.getEstimateFinishDate();
		//换算最后一次预计执行时间
		String lastStartDate = estimateFinishDate.substring(0,5)+beginDate.substring(5,beginDate.length());
		//如果最后一次执行时间大于预计完成时间，则当前时间为实际完成时间
		String lastovertime ="";
		if(lastStartDate.compareTo(estimateFinishDate)<=0){
			lastovertime = lastStartDate;
		}else{
			int lastYear = strParseDate(estimateFinishDate).getYear();
			lastovertime = (lastYear-1)+beginDate.substring(5,beginDate.length());
		}
		//如果当前时间大于最后一次发起工作时间，则设置实际完成时间
		if(IGStringUtils.getCurrentDateTime().compareTo(lastovertime)>=0&&"0".equals(count)){
			workDefinitionTB.setActualFinishDate(IGStringUtils.getCurrentDateTime());
		}
	}

	private void isSetOverTimeByHalfyear(WorkDefinitionTB workDefinitionTB,
			WorkDefinitionInfo workDefinitionInfo,String count) {
		//获取开始时间
		String beginDate = workDefinitionInfo.getBeginDate();
		//获取预计完成时间
		String estimateFinishDate = workDefinitionInfo.getEstimateFinishDate();
		//判断开始时间到预计完成时间之间有多少个可执行周期
		int monthcount = getMonthSpace(beginDate,estimateFinishDate)%6;
		//相差周期数
		int cyclenumber =  getMonthSpace(beginDate,estimateFinishDate)/6;
		String lastovertime ="";
		//开始时间的时分秒
		String startTime = beginDate.substring(12,beginDate.length());
		//预计完成时间时分秒
		String estimateStartTime = estimateFinishDate.substring(12,beginDate.length());
		DateFormat df = new SimpleDateFormat("HH:mm");
		if(monthcount==0){
			//如果是整数周期
			try {  
		    		//开始时间的时分秒
		            Date dt1 = df.parse(startTime);//将字符串转换为date类型  
		            Date dt2 = df.parse(estimateStartTime);  
		            if(dt1.getTime()<dt2.getTime())//比较时间大小,如果dt1大于dt2  
		            {  
		            	 df = new SimpleDateFormat("yyyy/mm/dd HH:mm");
		            	 df.parse(beginDate).setMonth(6*cyclenumber);
				    	 lastovertime = df.toString();
		            }  
		            else  
		            {  
		            	df = new SimpleDateFormat("yyyy/mm/dd HH:mm");
		            	df.parse(beginDate).setMonth(6*(cyclenumber-1));
				    	lastovertime = df.toString();
		            }  
		        } catch (ParseException e) {  
		       e.printStackTrace();  
		     } 
		}else{
			 df = new SimpleDateFormat("yyyy/mm/dd HH:mm");
			 try {
				df.parse(beginDate).setMonth(6*cyclenumber);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 lastovertime = df.toString();
		}
		//如果当前时间大于最后一次发起工作时间，则设置实际完成时间
		if(IGStringUtils.getCurrentDateTime().compareTo(lastovertime)>=0&&"0".equals(count)){
			workDefinitionTB.setActualFinishDate(IGStringUtils.getCurrentDateTime());
		}
	}

	@SuppressWarnings("deprecation")
	private void isSetOverTimeByQuarter(WorkDefinitionTB workDefinitionTB,
			WorkDefinitionInfo workDefinitionInfo,String count){
		//根据预计完成时间、开始时间判断最后一次执行发起工作时间
		//获取开始时间
		String beginDate = workDefinitionInfo.getBeginDate();
		//获取预计完成时间
		String estimateFinishDate = workDefinitionInfo.getEstimateFinishDate();
		//判断开始时间到预计完成时间之间有多少个可执行周期
		int monthcount = getMonthSpace(beginDate,estimateFinishDate)%3;
		//相差周期数
		int cyclenumber =  getMonthSpace(beginDate,estimateFinishDate)/3;
		String lastovertime ="";
		//开始时间的时分秒
		String startTime = beginDate.substring(12,beginDate.length());
		//预计完成时间时分秒
		String estimateStartTime = estimateFinishDate.substring(12,beginDate.length());
		DateFormat df = new SimpleDateFormat("HH:mm");
		if(monthcount==0){
			//如果是整数周期
			try {  
		    		//开始时间的时分秒
		            Date dt1 = df.parse(startTime);//将字符串转换为date类型  
		            Date dt2 = df.parse(estimateStartTime);  
		            if(dt1.getTime()<dt2.getTime())//比较时间大小,如果dt1大于dt2  
		            {  
		            	 df = new SimpleDateFormat("yyyy/mm/dd HH:mm");
		            	 df.parse(beginDate).setMonth(3*cyclenumber);
				    	 lastovertime = df.toString();
		            }  
		            else  
		            {  
		            	df = new SimpleDateFormat("yyyy/mm/dd HH:mm");
		            	df.parse(beginDate).setMonth(3*(cyclenumber-1));
				    	lastovertime = df.toString();
		            }  
		        } catch (ParseException e) {  
		       e.printStackTrace();  
		     } 
		}else{
			 df = new SimpleDateFormat("yyyy/mm/dd HH:mm");
			 try {
				df.parse(beginDate).setMonth(3*cyclenumber);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 lastovertime = df.toString();
		}
		//如果当前时间大于最后一次发起工作时间，则设置实际完成时间
		if(IGStringUtils.getCurrentDateTime().compareTo(lastovertime)>=0&&"0".equals(count)){
			workDefinitionTB.setActualFinishDate(IGStringUtils.getCurrentDateTime());
		}
	}
	/**
	 * @Description 当天工作确认处理初始化
	 * @param dto IGWIM02DTO
	 * @return IGWIM02DTO
	 * @throws BLException
	 * @author zyl
	 * @modifier WangLiang
	 * @modifyContent 工作定义加入了超时停止处理时间（天），确认初始化时需要将预计完成日期+超时停止处理时间 和 系统日期作比较，若已超时则不允许执行人确认/保存相关工作
	 */
	public IGWIM02DTO confirmTodayWorkInit(IGWIM02DTO dto) throws BLException {
		log.info("=================当天工作确认初始化处理开始=================");
		IGWIM0201Form form = dto.getIgwim0201Form();
		//工作实例主键
		Integer wiid = form.getWiid();
		//日期栏日期
		String titleDate = form.getTitleDate();
		if(wiid!=null&&wiid>0){
			//工作实例
			WorkInstanceInfo wiInfo = getWorkInstanceInfo(wiid);
			WorkLogSearchCondImpl cond = new WorkLogSearchCondImpl();
			cond.setWiid(wiid);
			//非保存状态
			cond.setBtnAction("1");
			//只查自己的处理记录
			cond.setExcutorId(dto.getUser().getUserid());
			//日期栏日期
			cond.setTitleDate(form.getTitleDate());
			//查询工作处理日志
			List<WorkLogInfo> wlogList = workLogBL.searchWorkLog(cond);
			//工作实例传值
			dto.setWiInfo(wiInfo);
			WorkInstanceTB wiTB = (WorkInstanceTB) SerializationUtils.clone(wiInfo);
			//根据日期栏日期判断能否再处理
			WorkLogSearchCondImpl cond1 = new WorkLogSearchCondImpl();
			cond1.setWiid(wiid);
			//只查自己的处理记录
			cond1.setExcutorId(dto.getUser().getUserid());
			cond1.setTitleDate(titleDate);
			List<WorkLogInfo> logList = workLogBL.searchWorkLog(cond1);
			if(CollectionUtils.isNotEmpty(logList)){//处理过日志的情况
				WorkLogInfo workLogInfo = logList.get(0);
				if("0".equals(workLogInfo.getBtnAction())){//保存状态,可以继续填,同时把值带到页面
					wiTB.setDescription(workLogInfo.getWlDescription());
					wiTB.setExcuteTime(workLogInfo.getExcuteTime());
					//日志处理状态0保存，1确认
					wiTB.setWistatus("0");
					dto.setWiInfo(wiTB);
				}else{
					wiTB.setDescription(workLogInfo.getWlDescription());
					wiTB.setExcuteTime(workLogInfo.getExcuteTime());
					//日志处理状态0保存，1确认
					wiTB.setWistatus("1");
					dto.setWiInfo(wiTB);
				}
			}else{
				//没处理过日志情况
				wiTB.setDescription("");
				wiTB.setExcuteTime("");
				//日志处理状态0保存，1确认
				dto.setWiInfo(wiTB);
			}
			//工作处理日志集合传值
			dto.setWlogList(wlogList);
			
			//==========超时停止处理检测开始  Wangliang==========
			//取得工作项对象
			WorkDefinitionInfo workDefinitionInfo = workDefinitionBL.searchWorkDefinitionByPK(wiInfo.getWdid());
			//计算得到工作可确认/保存范围内的日期
			Date dateAfter = getDateAfter(strParseDate(workDefinitionInfo.getEstimateFinishDate()), 
					Integer.parseInt(workDefinitionInfo.getOvertimeStopDealTime()));
			if(compairDate(dateAfter, new Date())==-1){
				//已超时
				dto.setIsOverTime("1");
			}else{
				//未超时
				dto.setIsOverTime("0");
			}
			dto.setDesc(workDefinitionInfo.getDescription());
			//==========超时停止处理检测结束  Wangliang==========
		}
		log.info("=================当天工作确认初始化处理结束=================");
		return dto;
	}
	/**
	 * @Description 当天工作确认处理
	 * @param dto IGWIM02DTO
	 * @return IGWIM02DTO
	 * @throws BLException
	 * @author zyl
	 */
	public IGWIM02DTO confirmTodayWork(IGWIM02DTO dto) throws BLException {
		log.info("=================当天工作确认处理开始=================");
		IGWIM0201Form form = dto.getIgwim0201Form();
		//工作实例主键
		Integer wiid = form.getWiid();
		
		//==========执行人确认时，根据userid（登陆用户）和btnaction =2 查询到的结果集删除日志表相关数据开始　ＷａｎｇＬｉａｎｇ==========
		
		WorkLogSearchCondImpl workLogCond = new WorkLogSearchCondImpl();
		//设置执行人userid
		workLogCond.setExcutorId(dto.getUser().getUserid());
		//设置按钮动作类型（1：保存；2：提交）
		workLogCond.setBtnAction("2");
		//调用BL检索结果集
		List<WorkLogInfo> searchWorkLog = workLogBL.searchWorkLog(workLogCond);
		//若结果集非空，遍历结果执行逐条删除
		if(searchWorkLog!=null && searchWorkLog.size()>0){
			for (int i = 0; i < searchWorkLog.size(); i++) {
				workLogBL.deleteWorkLogByPK(searchWorkLog.get(i).getWlid());
			}
		}
		//==========执行人确认时，根据userid（登陆用户）和btnaction =2 查询到的结果集删除日志表相关数据结束　ＷａｎｇＬｉａｎｇ==========
		if(wiid!=null&&wiid>0){
			//处理反复保存情况
			WorkLogSearchCondImpl cond = new WorkLogSearchCondImpl();
			cond.setWiid(wiid);
			//只查自己的处理记录
			cond.setExcutorId(dto.getUser().getUserid());
			cond.setTitleDate(form.getTitleDate());
			List<WorkLogInfo> logList = workLogBL.searchWorkLog(cond);
			if(CollectionUtils.isNotEmpty(logList)){
				for(WorkLogInfo info : logList){
					workLogBL.deleteWorkLog(info);
				}
			}
			//1.工作日志信息入库
			WorkLogTB tb = new WorkLogTB();
			//关联实例
			tb.setWiid(wiid);
			//实际处理日期
			tb.setActualDealwithDate(IGStringUtils.getCurrentDateTime());
			//日期栏日期
			tb.setTitleDate(form.getTitleDate());
			//执行时间（小时 ）
			tb.setExcuteTime(form.getExcuteTime());
			//执行情况描述
			tb.setWlDescription(form.getWlDescription());
			//执行人
			tb.setExcutorName(dto.getUser().getUsername());
			//执行人id
			tb.setExcutorId(dto.getUser().getUserid());
			//动作
			if("1".equals(form.getBtnAction())){
				//提交
				tb.setBtnAction("1");
			}else{
				//保存
				tb.setBtnAction("0");
			}
			workLogBL.registWorkLog(tb);
			//有一人处理过的工作，状态变为执行中,如果是保存则不更改
			if("1".equals(form.getBtnAction())){				
				WorkInstanceTB wiTb =  (WorkInstanceTB) SerializationUtils.clone(workInstanceBL.searchWorkInstanceByPK(wiid));
				wiTb.setWistatus("执行中");
				workInstanceBL.updateWorkInstance(wiTb);
			}
		}
		log.info("=================当天工作确认处理结束=================");
		return dto;
	}
	/**
	 * @Description 获取工作信息实例
	 * @param id 工作主键
	 * @return WorkInstanceInfo
	 * @throws BLException
	 * @author zyl
	 */
	public WorkInstanceInfo getWorkInstanceInfo(Integer id) throws BLException {
		log.info("=================获取工作信息实例=================");
		return workInstanceBL.searchWorkInstanceByPK(id);
	}
	
	/**
	 * @Description 工作信息统计查询
	 * @param dto IGWIM02DTO
	 * @return IGWIM02DTO
	 * @throws BLException
	 * @author songzhihui
	 */
	public IGWIM02DTO countSearch(IGWIM02DTO dto) throws BLException {
		IGWIM0201Form form = dto.getIgwim0201Form();
		// 分页用信息取得
		PagingDTO pDto = dto.getPagingDto();
		pDto.getPageDispCount();
		//设置查询条件
		WorkInstanceSearchCondImpl cond = new WorkInstanceSearchCondImpl();
		BeanUtils.copyProperties(form, cond);
		
		//检索条数
		int totalCount = workInstanceBL.findCountSearch(cond, 0, 0).size();
		
		if (totalCount == 0) {
			log.info("========工作信息数据不存在========");
			// 工作信息数据不存在
			dto.addMessage(new ActionMessage("IGBCM0101.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.info("========工作信息数据过多========");
			// 工作信息数据过多
			dto.addMessage(new ActionMessage("IGBCM0101.E005", dto.getMaxSearchCount(), totalCount));
			return dto;
		}
		
		//调用BL查询工作信息
		List<Map<String, String>> wiList = workInstanceBL.findCountSearch(cond, pDto.getFromCount(), pDto.getPageDispCount());
		
		//保存查询结果集
		dto.setWiList(wiList);
		//设置分页总条数
		pDto.setTotalCount(totalCount);
				
		return dto;
	}
	
	/**
	 * @Description 工作信息统计查询导出
	 * @param dto IGWIM02DTO
	 * @return IGWIM02DTO
	 * @throws BLException
	 * @author songzhihui
	 */
	public IGWIM02DTO searchExport(IGWIM02DTO dto) throws BLException {
		log.info("=================工作信息统计查询导出BL处理开始=================");
		IGWIM0201Form form = dto.getIgwim0201Form();
		//设置查询条件
		WorkInstanceSearchCondImpl cond = new WorkInstanceSearchCondImpl();
		BeanUtils.copyProperties(form, cond);
		//获取的结果集
		List<Map<String, String>> wiList = workInstanceBL.findCountSearch(cond, 0, 0);
		
		//设置响应对象
		HttpServletResponse response = dto.getResponse();
		response.reset();
		response.setContentType("binary/octet-stream");
		OutputStream output = null;
		try {
			response.setHeader("Content-Disposition", "attachment;filename="
					+ new String("工作信息.xlsx".getBytes("gb2312"), "iso-8859-1"));
			output = response.getOutputStream();
			// 创建工作薄
			XSSFWorkbook book = new XSSFWorkbook();
			XSSFSheet sheet = book.createSheet("工作信息");
			
			// 合并单元格
			// 四个参数分别是：起始行，结束行，起始列，结束列
			sheet.addMergedRegion(new org.apache.poi.ss.util.CellRangeAddress(0, 1, 0, 12));
			//设置标题单元格样式
			XSSFCellStyle bigtitlestyle = bigtitlecellstyle(book);
			// 添加大标题行
			XSSFRow bigtitleRow = sheet.createRow(0);
			bigtitleRow.setHeight((short) 980);
			// 创建单元格
			XSSFCell bigtitlecell = bigtitleRow.createCell(0);
			bigtitlecell.setCellValue("工作信息");
			bigtitlecell.setCellStyle(bigtitlestyle);
			
			// 合并单元格
			// 四个参数分别是：起始行，结束行，起始列，结束列
			sheet.addMergedRegion(new org.apache.poi.ss.util.CellRangeAddress(2, 2, 0, 4));
			// 添加查询条件表单行
			XSSFRow searchformRow = sheet.createRow(2);
			searchformRow.setHeight((short) 480);
			// 创建单元格
			XSSFCell searchformcell = searchformRow.createCell(0);
			searchformcell.setCellValue("工作开始日期："+form.getBegindate_from()+"--"+form.getBegindate_to());
			
			//设置标题单元格样式
			XSSFCellStyle titlestyle = titlecellstyle(book);
			// 添加标题行
			XSSFRow titleRow = sheet.createRow(3);
			titleRow.setHeight((short) 980);
			String[] titles = { "工作名称","周期","发起人","负责人","执行人","工作状态",
					"工作开始日期","工作发起日期","日期栏日期","执行确认日期","工作执行情况","执行时间（小时）","执行情况描述" };
			int[] titlewidths = { 50 * 70, 50 * 70, 50 * 70, 50 * 70, 50 * 100, 
					50 * 70, 50 * 100, 50 * 100, 50 * 90, 50 * 100, 50 * 70, 50 * 100, 50 * 70 };

			for (int i = 0; i < titles.length; i++) {
				// 创建单元格
				XSSFCell cell = titleRow.createCell(i);
				cell.setCellValue(titles[i]);
				cell.setCellStyle(titlestyle);
				sheet.setColumnWidth(i, titlewidths[i]);
			}
			
			//设置数据单元格和查询条件表单样式
			XSSFCellStyle liststyle = listcellstyle(book);
			//导出数据行
			for(int k = 0; k< wiList.size();k++) {
				//获取每行数据
				Map<String, String> listmap = wiList.get(k);	
				
				// 添加标题行
				XSSFRow listRow = sheet.createRow(4+k);
				listRow.setHeight((short) 580);
				
				//判断周期的值
				String cycle = "";
				if("day".equals(listmap.get("CYCLE"))) {
					cycle = "每日";
				} 
				else if("week".equals(listmap.get("CYCLE"))) {
					cycle = "每周";
				} 
				else if("month".equals(listmap.get("CYCLE"))) {
					cycle = "每月";
				} 
				else if("quarter".equals(listmap.get("CYCLE"))) {
					cycle = "每季度";
				} 
				else if("halfyear".equals(listmap.get("CYCLE"))) {
					cycle = "每半年";
				} 
				else if("year".equals(listmap.get("CYCLE"))) {
					cycle = "每年";
				} 
				
				String[] list = { listmap.get("WDNAME"),
						cycle,
						listmap.get("INITIATORID"),
						listmap.get("LEADERNAME"),
						listmap.get("EXCUTORNAME"),
						listmap.get("WISTATUS"),
						listmap.get("BEGINDATE"),
						listmap.get("CRTDATE"),
						listmap.get("TITLEDATE"),
						listmap.get("ACTUALDEALWITHDATE"),
						listmap.get("BTNACTION"),
						listmap.get("EXCUTETIME"),
						listmap.get("WLDESCRIPTION") };

				for (int i = 0; i < list.length; i++) {
					// 创建单元格
					XSSFCell cell = listRow.createCell(i);
					cell.setCellStyle(liststyle);
					cell.setCellValue(list[i]);
				}
			}
			
			
			
			book.write(output);
		} catch (Exception e) {
			log.error(">>下载文件异常：" + e.getMessage());
		} finally {
			try {
				// 关闭输出流
				if (output != null) {
					output.close();
				}
			} catch (Exception e) {
				log.error(">>下载文件异常：" + e.getMessage());
			}
		}

		log.info("=================工作信息统计查询导出BL处理结束=================");
		return dto;
	}
	
	/**
	 * 设置导出excel标题样式
	 * 
	 * */
	@SuppressWarnings("deprecation")
	public XSSFCellStyle titlecellstyle(XSSFWorkbook book){
		// 创建单元格样式
		XSSFCellStyle titlestyle = book.createCellStyle();
		// 设置单元格背景色 (白色)
		XSSFColor color = new XSSFColor(Color.white);
		titlestyle.setFillForegroundColor(color);
		// 设置边框 第一行应该是边框样式
		titlestyle.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
		
		titlestyle.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		titlestyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);
		titlestyle.setBorderRight(XSSFCellStyle.BORDER_THIN);
		titlestyle.setBorderTop(XSSFCellStyle.BORDER_THIN);
		// 设置对齐
		titlestyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);// 水平
		titlestyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);// 垂直
		// 设置自动换行
		titlestyle.setWrapText(true);
		//设置字体
		XSSFFont font = book.createFont();    
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");    
		font.setFontHeightInPoints((short) 10);//设置字体大小    
		titlestyle.setFont(font);
		
		return titlestyle;
		
	}
	
	/**
	 * 设置导出excel标题样式
	 * 
	 * */
	@SuppressWarnings("deprecation")
	public XSSFCellStyle bigtitlecellstyle(XSSFWorkbook book){
		// 创建单元格样式
		XSSFCellStyle bigtitlestyle = book.createCellStyle();
		// 设置单元格背景色 (白色)
		XSSFColor color = new XSSFColor(Color.white);
		bigtitlestyle.setFillForegroundColor(color);
		// 设置对齐
		bigtitlestyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);// 水平
		bigtitlestyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);// 垂直
		// 设置自动换行
		bigtitlestyle.setWrapText(true);
		//设置字体
		XSSFFont font = book.createFont();    
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");    
		font.setFontHeightInPoints((short) 20);//设置字体大小    
		bigtitlestyle.setFont(font);
		
		return bigtitlestyle;
		
	}
	
	/**
	 * 设置导出excel数据样式
	 * 
	 * */
	@SuppressWarnings("deprecation")
	public XSSFCellStyle listcellstyle(XSSFWorkbook book){
		// 创建单元格样式
		XSSFCellStyle listtyle = book.createCellStyle();
		// 设置单元格背景色 (白色)
		XSSFColor color = new XSSFColor(Color.white);
		listtyle.setFillForegroundColor(color);
		// 设置边框 第一行应该是边框样式
		listtyle.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
		
		listtyle.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		listtyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);
		listtyle.setBorderRight(XSSFCellStyle.BORDER_THIN);
		listtyle.setBorderTop(XSSFCellStyle.BORDER_THIN);
		// 设置对齐
		listtyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);// 水平
		listtyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);// 垂直
		// 设置自动换行
		listtyle.setWrapText(true);
		
		return listtyle;
		
	}
	/**
	 * @Description 首页我的当日工作查询
	 * @param dto IGWIM02DTO
	 * @return IGWIM02DTO
	 * @throws BLException
	 */
	public IGWIM02DTO findTodayWorkByCondForFirstPage(IGWIM02DTO dto) throws BLException {
		log.info("=================首页我的当日工作查询处理开始=================");
		// 分页用信息取得
		PagingDTO pDto = dto.getPagingDto();
		pDto.getPageDispCount();
		//设置查询条件
		WorkInstanceSearchCondImpl cond = new WorkInstanceSearchCondImpl();
		//当前用户
		cond.setUserid(dto.getUser().getUserid());
		//检索条数
		int totalCount = workInstanceBL.findTodayWorkByCondForFirstPage(cond, 0, 0).size();
		
		if (totalCount == 0) {
			log.info("========工作项检索数据不存在========");
			// 知识服务检索数据不存在
			dto.addMessage(new ActionMessage("IGBCM0101.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.info("========工作项数据件数过多========");
			// 用户检索数据件数过多
			dto.addMessage(new ActionMessage("IGBCM0101.E005", dto.getMaxSearchCount(), totalCount));
			return dto;
		}
		
		//调用BL查询工作信息
		List<Map<String, String>> wiList = workInstanceBL.findTodayWorkByCondForFirstPage(cond, pDto.getFromCount(), pDto.getPageDispCount());
		
		//保存查询结果集
		dto.setWiList(wiList);
		//设置分页总条数
		pDto.setTotalCount(totalCount);
		
		log.info("=================首页我的当日工作查询处理结束=================");
		return dto;
	}
	/**
	 * 查询当前工作已经用时多久了，所有日志里填的处理时间之和
	 * @param cond 只用到了实例id-wiid
	 * @return
	 */
	public IGWIM02DTO getTotalExcuteTime(IGWIM02DTO dto){
		IGWIM0201Form form = dto.getIgwim0201Form();
		// 分页用信息取得
		WorkInstanceSearchCondImpl cond = new WorkInstanceSearchCondImpl();
		cond.setWiid(form.getWiid());
		String totalExcuteTime = workInstanceBL.getTotalExcuteTime(cond);
		dto.setTotalExcuteTime(totalExcuteTime);
		return dto;
	}
	
	/**
	 * 字符串格式转成日期
	 * @param str 字符串
	 * @return 日期
	 */
	private Date strParseDate(String str){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm");
		Date date = null;
		try {
			date = sdf.parse(str);
		} catch (ParseException e) {
			log.error("字符串强转成日期格式失败，要转换的字符串:"+str+"\n类：WorkRemindBLImpl，方法：strParseDate() 942\n"+e.getMessage());
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 获取日期后几天的日期
	 * @param d 传入的日期
	 * @param day 增加的天数
	 * @return
	 */
	private Date getDateAfter(Date d, int day) {  
		
        Calendar now = Calendar.getInstance();  
        //设置当系统日期
        now.setTime(d);
        //系统日期+天
        now.set(Calendar.DATE, now.get(Calendar.DATE) + day);  
        return now.getTime();  
    }
	
	/**
	 * 比较日期大小
	 * @param dt1 日期1
	 * @param dt2 日期2
	 * @return 返回1：日期1>日期2，返回-1：日期1<日期2，返回0：日期1=日期2
	 */
	private int compairDate(Date dt1,Date dt2){
		
		if(dt1.getTime() > dt2.getTime()){
			return 1;
		}else if(dt1.getTime() < dt2.getTime()){
			return -1;
		}else{
			return 0;
		}
	}

	public IGWIM02DTO getPermissionByUser(IGWIM02DTO dto) {
		//最大用户权限，科技部领导
		boolean hasMostPower = hasMostPower(dto.getUser().getUserid());
		if(hasMostPower){
			dto.setUserPermission("1");
		}else{
			String orgsyscoding = hasLeaderPower(dto.getUser().getUserid());
			if(StringUtils.isNotEmpty(orgsyscoding)){
				dto.setUserPermission("2");
			}else{
				dto.setUserPermission("3");
			}
		}
		
		return dto;
	}
}
