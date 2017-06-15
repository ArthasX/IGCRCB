package com.deliverik.infogovernor.soc.vir.bl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG677Info;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG677SearchCondImpl;
import com.deliverik.infogovernor.com.bl.task.ProcessInHandBL;
import com.deliverik.infogovernor.com.model.ProcessInHandVWInfo;
import com.deliverik.infogovernor.soc.vir.bl.task.VIM01BL;
import com.deliverik.infogovernor.soc.vir.bl.task.VIM03BL;
import com.deliverik.infogovernor.soc.vir.bl.task.VIM03CountByOrgVWBL;
import com.deliverik.infogovernor.soc.vir.bl.task.VIM03CountByProjVWBL;
import com.deliverik.infogovernor.soc.vir.bl.task.VIM03CountByUserVWBL;
import com.deliverik.infogovernor.soc.vir.bl.task.VIM03CountVWBL;
import com.deliverik.infogovernor.soc.vir.bl.task.VIM05BL;
import com.deliverik.infogovernor.soc.vir.bl.task.VIM06BL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR10DTO;
import com.deliverik.infogovernor.soc.vir.model.VIM01Info;
import com.deliverik.infogovernor.soc.vir.model.VIM03CountByOrgVWInfo;
import com.deliverik.infogovernor.soc.vir.model.VIM03CountByUserVWInfo;
import com.deliverik.infogovernor.soc.vir.model.VIM03Info;
import com.deliverik.infogovernor.soc.vir.model.VIM05Info;
import com.deliverik.infogovernor.soc.vir.model.VIM06Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM03CountByOrgVWSearchCondImpl;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM03CountByUserVWSearchCondImpl;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM03CountVWSearchCondImpl;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM06SearchCondImpl;
import com.deliverik.infogovernor.soc.vir.model.condition.Vim03SearchCondImpl;
import com.deliverik.infogovernor.soc.vir.vim.VIMBL;
import com.deliverik.infogovernor.soc.vir.vim.model.Host;
import com.deliverik.infogovernor.soc.vir.vim.model.Template;
import com.deliverik.infogovernor.soc.vir.vim.model.VMachine;
import com.google.gson.Gson;

/**
 * 首页业务逻辑实现
 *
 */
public class IGVIR10BLImpl extends BaseBLImpl implements IGVIR10BL{

	static Log log = LogFactory.getLog(IGVIR10BLImpl.class);
	
	/**流程定义BL*/
	protected WorkFlowDefinitionBL workFlowDefinitionBL;
	
	/**流程处理BL*/
	protected WorkFlowOperationBL workFlowOperationBL;
	
	/** 流程BL */
	protected IG500BL ig500BL;
	
	/**CodeDetail信息BL*/
	protected CodeDetailBL codeDetailBL;
	
	/**虚拟机资源BL*/
	protected VIM03BL vim03BL;
	
	/**虚拟机统计BL*/
	protected VIM03CountVWBL vim03CountVWBL;
	
	/**流程处理BL*/
	protected ProcessInHandBL processInHandBL;
	
	protected VIM03CountByUserVWBL vim03CountByUserVWBL;
	
	protected VIM03CountByProjVWBL vim03CountByProjVWBL;
	
	/**根据机构统计虚拟机的BL*/
	protected VIM03CountByOrgVWBL vim03CountByOrgVWBL;
	
	protected VIM01BL vim01BL;
	
	protected VIMBL vimBL;
	
	protected VIM05BL vim05BL;
	
	protected VIM06BL vim06BL;
	
	/**
	 * 流程BL设定
	 * @param ig500BL 流程BL
	 */
	public void setIg500BL(IG500BL ig500bl) {
		ig500BL = ig500bl;
	}

	public void setProcessInHandBL(ProcessInHandBL processInHandBL) {
		this.processInHandBL = processInHandBL;
	}

	public void setVim05BL(VIM05BL vim05BL) {
		this.vim05BL = vim05BL;
	}

	public void setVim06BL(VIM06BL vim06BL) {
		this.vim06BL = vim06BL;
	}

	/**
	 * vim01BL设定
	 * @param vim01BL vim01BL
	 */
	public void setVim01BL(VIM01BL vim01bl) {
		vim01BL = vim01bl;
	}

	/**
	 * vimBL设定
	 * @param vimBL vimBL
	 */
	public void setVimBL(VIMBL vimBL) {
		this.vimBL = vimBL;
	}

	public void setVim03CountByOrgVWBL(VIM03CountByOrgVWBL vim03CountByOrgVWBL) {
		this.vim03CountByOrgVWBL = vim03CountByOrgVWBL;
	}

	public void setVim03BL(VIM03BL vim03bl) {
		vim03BL = vim03bl;
	}

	public void setWorkFlowDefinitionBL(WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}

	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}

	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}
	
	/**
	 * 虚拟资源统计BL设定
	 * @param vim03CountByUserVWBL 虚拟资源统计BL
	 */
	public void setVim03CountByUserVWBL(VIM03CountByUserVWBL vim03CountByUserVWBL) {
		this.vim03CountByUserVWBL = vim03CountByUserVWBL;
	}

	/**
	 * vim03CountByProjVWBL设定
	 * @param vim03CountByProjVWBL vim03CountByProjVWBL
	 */
	public void setVim03CountByProjVWBL(VIM03CountByProjVWBL vim03CountByProjVWBL) {
		this.vim03CountByProjVWBL = vim03CountByProjVWBL;
	}
	
	/**
	 * 虚拟机统计BL设定
	 * @param vim03CountVWBL 虚拟机统计BL
	 */
	public void setVim03CountVWBL(VIM03CountVWBL vim03CountVWBL) {
		this.vim03CountVWBL = vim03CountVWBL;
	}

	/**
	 *  获取流程信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR10DTO getProcessList(IGVIR10DTO dto) throws BLException{
	
		IG500SearchCondImpl ig500Cond = new IG500SearchCondImpl();
		
		ig500Cond.setPruserid(dto.getUser().getUserid());
		
		//ig500Cond.setPrStatusArray(new String[]{"Z","Y","X","W","U","V","O","P","Q","R","S","T"});
		ig500Cond.setPrstatus_ne("C");
		List<IG500Info> lstProcessRecord = workFlowOperationBL.searchProcessRecord(ig500Cond, 0, 5);
		
		dto.setLstProcessRecord(lstProcessRecord);
		
		return dto;
	}
	
	
	/**
	 * 获取资源信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR10DTO getResouceInfo(IGVIR10DTO dto)throws BLException{
		
		VIM03CountVWSearchCondImpl userCond = new VIM03CountVWSearchCondImpl();
		userCond.setUserid(dto.getUser().getUserid());
		
		VIM03CountVWSearchCondImpl orgCond = new VIM03CountVWSearchCondImpl();
		orgCond.setOrgsyscoding(dto.getUser().getOrgid());
		
		String dateStr = getExpiryTime();
		
		Integer userCount = vim03CountVWBL.getCount(userCond);
		Integer orgCount = vim03CountVWBL.getCount(orgCond);
		
		userCond.setExpirytime_greater(dateStr);
		orgCond.setExpirytime_greater(dateStr);
		Integer userExpireCount = vim03CountVWBL.getCount(userCond);
		Integer orgExpireCount = vim03CountVWBL.getCount(orgCond);
		
		dto.setUserCount(userCount);
		dto.setUserExpireCount(userExpireCount);
		dto.setOrgCount(orgCount);
		dto.setOrgExpireCount(orgExpireCount);
		
		return dto;
	}

	/**
	 * @return
	 */
	private String getExpiryTime() {
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        cal.add(Calendar.DAY_OF_MONTH, 10);
        Date resDate = cal.getTime();
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		String dateStr = format.format(resDate);
		return dateStr;
	}
	
	
	/**
	 * 获取金额信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR10DTO getFigureInfo(IGVIR10DTO dto)throws BLException{
		
		getUserCostInfo(dto);
		
		getOrgCostInfo(dto);
		
		return dto;
	}
	
	
	/**
	 * 初始化Action信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR10DTO initVir10UserAction(IGVIR10DTO dto)throws BLException{
		
		//获取流程信息
		getProcessList(dto);
		//获取资源分析数据
		getResouceInfo(dto);
		//获取费用信息
		getFigureInfo(dto);
		//获取模板信息
		getTemplateList(dto);
		//获取个人VM信息
		getOwnVm(dto);
		
		return dto;
	}
	
	/**
	 * 获取个人Vm信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	private IGVIR10DTO getOwnVm(IGVIR10DTO dto)throws BLException{
		
		Vim03SearchCondImpl cond = new Vim03SearchCondImpl();
		cond.setUserid_eq(dto.getUser().getUserid());
		cond.setProgress_eq("100");
		
		List<VIM03Info> ownVMList = vim03BL.searchVim03(cond, 0, 0);
		
		dto.setOwnVMList(ownVMList);
		
		return dto;
	}
	
	/**
	 * 获取模板信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR10DTO getTemplateList(IGVIR10DTO dto)throws BLException{
		log.debug("=========== 查询所有模板信息处理开始 ==========");
		
		try {
		    List<Template> templateList = vimBL.searchTemplate();
		    dto.setTemplateList(templateList);
        } catch (Exception e) {
            dto.setTemplateList(new ArrayList<Template>());
        }
		
		log.debug("=========== 查询所有模板信息处理结束 ==========");
		return dto;
	}
	
	
	private IGVIR10DTO getOrgCostInfo(IGVIR10DTO dto) {
		
		User user = dto.getUser();
		VIM03CountByOrgVWSearchCondImpl cond = new VIM03CountByOrgVWSearchCondImpl();
		cond.setOrgsyscoding_like(user.getOrgid());
		List<VIM03CountByOrgVWInfo> olist = vim03CountByOrgVWBL.findByCond(cond, 0, 0);
		
		/**
		 * 计费逻辑开始
		 */
		HashMap<String,Integer> priceMap = getPriceMap();
		
		Integer total = 0;
		
		for(VIM03CountByOrgVWInfo info:olist){
			Integer cpuuse = info.getTotalcpu() == null?0:info.getTotalcpu();
			Integer cpuprice = cpuuse*(priceMap.get("001") == null?0:priceMap.get("001"));
			
			Integer memuse = info.getTotalmem() == null?0:info.getTotalmem();
			Integer memprice = memuse*(priceMap.get("002") == null?0:priceMap.get("002"));
			
			Integer diskuse = info.getTotaldisk() == null?0:info.getTotaldisk();
			Integer diskprice = diskuse*(priceMap.get("003") == null?0:priceMap.get("003"));
			
			total = total +cpuprice + memprice + diskprice;
		}
		dto.setOrgcost(total);
		
		return dto;
	}
	
	private IGVIR10DTO getUserCostInfo(IGVIR10DTO dto) {
		
		User user = dto.getUser();
		VIM03CountByUserVWSearchCondImpl cond = new VIM03CountByUserVWSearchCondImpl();
		cond.setUserid_like(user.getUserid());
//		cond.setUsername_like(user.getUsername());
//		cond.setOrgsyscoding_like(user.getOrgid());
		List<VIM03CountByUserVWInfo> ulist = vim03CountByUserVWBL.findByCond(cond, 0, 0);
		
		/**
		 * 计费逻辑开始
		 */
		HashMap<String,Integer> priceMap = getPriceMap();
		
		Integer total = 0;
		
		for(VIM03CountByUserVWInfo info:ulist){
			Integer cpuuse = info.getTotalcpu() == null?0:info.getTotalcpu();
			Integer cpuprice = cpuuse*(priceMap.get("001") == null?0:priceMap.get("001"));
			
			Integer memuse = info.getTotalmem() == null?0:info.getTotalmem();
			Integer memprice = memuse*(priceMap.get("002") == null?0:priceMap.get("002"));
			
			Integer diskuse = info.getTotaldisk() == null?0:info.getTotaldisk();
			Integer diskprice = diskuse*(priceMap.get("003") == null?0:priceMap.get("003"));
			
			total = total +cpuprice + memprice + diskprice;
		}
		dto.setUsercost(total);
		
		return dto;
	}
	
	private Integer getTotalCostInfo() {
		
		VIM03CountByUserVWSearchCondImpl cond = new VIM03CountByUserVWSearchCondImpl();
		List<VIM03CountByUserVWInfo> wholelist = vim03CountByUserVWBL.findByCond(cond, 0, 0);
		
		/**
		 * 计费逻辑开始
		 */
		HashMap<String,Integer> priceMap = getPriceMap();
		
		Integer total = 0;
		
		for(VIM03CountByUserVWInfo info:wholelist){
			Integer cpuuse = info.getTotalcpu() == null?0:info.getTotalcpu();
			Integer cpuprice = cpuuse*(priceMap.get("001") == null?0:priceMap.get("001"));
			
			Integer memuse = info.getTotalmem() == null?0:info.getTotalmem();
			Integer memprice = memuse*(priceMap.get("002") == null?0:priceMap.get("002"));
			
			Integer diskuse = info.getTotaldisk() == null?0:info.getTotaldisk();
			Integer diskprice = diskuse*(priceMap.get("003") == null?0:priceMap.get("003"));
			
			total = total +cpuprice + memprice + diskprice;
		}
		
		return total;
	}
	
	private HashMap<String,Integer> getPriceMap(){
		
		HashMap<String,Integer> priceMap = new HashMap<String,Integer>();
		//获取计费策略
		List<VIM05Info> strategies = vim05BL.searchVim05();
		if(strategies.size() != 0){
			VIM05Info strategy = strategies.get(0);
			VIM06SearchCondImpl vim06Cond = new VIM06SearchCondImpl();
			vim06Cond.setStrategyid_eq(String.valueOf(strategy.getId()));
			//价格列表
			List<VIM06Info> list = vim06BL.searchVim06(vim06Cond);
			for(VIM06Info vim06info:list){
				priceMap.put(vim06info.getResourceitem(), vim06info.getPrice());//价格
			}
		}
		return priceMap;
	}

	/**
	 * 初始化管理员Action信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR10DTO initVir10ManageAction(IGVIR10DTO dto)throws BLException{
		
		//获取部门资源分布信息
		getResourceInfoByOrg(dto);
		
		//获取代办工作
		getPendingProcessList(dto);
		
		//获取模板信息
		getTemplateList(dto);
		
		//获取部门 每月 申请统计情况
		getOrgCountByMonth(dto);
		
		return dto;
	}
	
	/***
	 * 获取部门 每月 申请统计情况
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR10DTO getOrgCountByMonth(IGVIR10DTO dto)throws BLException{
		
		Date nowDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		Calendar ca = Calendar.getInstance();
		ca.setTime(nowDate);
		ca.add(Calendar.MONTH, -3);
		String startDate = sdf.format(ca.getTime());
		
		List<Object[]> monthCountData = vim03BL.getOrgCountByMonth(startDate);
		dto.setMonthCountData(monthCountData);
		
		monthCountData = vim03BL.getOrgCount(startDate);
		
		// 月份数组
		String[] monthArr = new String[3];
		nowDate = new Date();
        ca = Calendar.getInstance();
        ca.setTime(nowDate);
        
		ca.add(Calendar.MONTH, -2);
		startDate = sdf.format(ca.getTime());
		monthArr[0] = startDate;
		ca.add(Calendar.MONTH, +1);
        startDate = sdf.format(ca.getTime());
		monthArr[1] = startDate;
		ca.add(Calendar.MONTH, +1); // 当前月
        startDate = sdf.format(ca.getTime());
		monthArr[2] = startDate;
		
		Map<String, Map<String, String>> rootmap = new HashMap<String, Map<String, String>>();
		for (Object[] objects : monthCountData) {
		    Map<String, String> map = new HashMap<String, String>();
		    map.put("y", objects[0].toString());
		    rootmap.put(objects[1].toString(), map);
        }
		List<Map<String, String>> list = new ArrayList<Map<String,String>>();
		for (String month : monthArr) {
            if (rootmap.get(month) == null) {
                Map<String, String> map = new HashMap<String, String>();
                map.put("y", "0");
                list.add(map);
            } else {
                list.add(rootmap.get(month));
            }
        }
		
		Gson gson = new Gson();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("data", list);
		dataMap.put("name", "'数量'");
		List<Map<String, Object>> list1 = new ArrayList<Map<String, Object>>();
		list1.add(dataMap);
		String json = gson.toJson(list1);
		String month = gson.toJson(monthArr);
		dto.setMonthCountJson(json.replace("\"", ""));
		dto.setMonthJson(month);
		rootmap = null;
		dataMap = null;
		return dto;
		
	}
	
	/**
	 * 获取待处理的流程信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR10DTO getPendingProcessList(IGVIR10DTO dto)throws BLException{
		
		String userid = dto.getUser().getUserid();
		
		List<ProcessInHandVWInfo> pihList = this.processInHandBL.searchProcessInHandByUserID(userid,0,10, true);
		
		dto.setPihList(pihList);
		
		return dto;
	}


	/**
	 * 获取各部门资源使用情况
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR10DTO getResourceInfoByOrg(IGVIR10DTO dto)throws BLException{
		
		VIM03CountByOrgVWSearchCondImpl cond = new VIM03CountByOrgVWSearchCondImpl();
		
		List<VIM03CountByOrgVWInfo> orgResList = vim03CountByOrgVWBL.getCount(cond);
		
		String dateStr = getExpiryTime();
		
		cond.setExpiryTime(dateStr);
		
		List<VIM03CountByOrgVWInfo> orgExpiryResList = vim03CountByOrgVWBL.getCount(cond);
		
		dto.setOrgResList(orgResList);
		
		dto.setOrgExpiryResList(orgExpiryResList);
		
		return dto;
	}
	
	/**
	 * 获取资源概况
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR10DTO getResourceSurvey(IGVIR10DTO dto)throws BLException{
		
		Integer hostCount = 0;
		
		List<VIM01Info> list01 = vim01BL.searchVIM01();
		for(VIM01Info bean01:list01){
		    try {
		        List<Host> hostList = vimBL.searchHostByVcid(bean01.getVcid());
		        if(hostList != null){
		            hostCount += hostList.size();
		        }
            } catch (Exception e) {
            }
		}
		VIM03CountVWSearchCondImpl cond = new VIM03CountVWSearchCondImpl();
		Integer vmCount = vim03CountVWBL.getCountByCond(cond);
		VIM03CountVWSearchCondImpl ucond = new VIM03CountVWSearchCondImpl();
		ucond.setCountUser("y");
		Integer userCount = vim03CountVWBL.getCountByCond(ucond);
		VIM03CountVWSearchCondImpl ocond = new VIM03CountVWSearchCondImpl();
		ocond.setCountOrg("y");
		Integer orgCount = vim03CountVWBL.getCountByCond(ocond);
		VIM03CountVWSearchCondImpl pcond = new VIM03CountVWSearchCondImpl();
		pcond.setCountProj("y");
		Integer projCount = vim03CountVWBL.getCountByCond(pcond);
		
		Map<String,Integer> cmap = new HashMap<String, Integer>();
		cmap.put("host", hostCount);
		cmap.put("vm", vmCount);
		cmap.put("user", userCount);
		cmap.put("org", orgCount);
		cmap.put("proj", projCount);
		
		Integer totalcost = getTotalCostInfo();
		cmap.put("cost", totalcost);
		
		dto.setResourceSurveyMap(cmap);
		return dto;
	}
	
	/**
	 * 初始化管理员首页
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR10DTO initManageHomePageAction(IGVIR10DTO dto) throws BLException {
		log.debug("===============初始化管理员首页操作开始===============");
		//初始化流程信息
		dto = searchProcessRecordAction(dto);
		//初始化Host信息
		dto = searchHostInfosAction(dto);
		dto.getIgvir10051VO().setHostMap(dto.getHostMap());
		log.debug("===============初始化管理员首页操作结束===============");
		return dto;
	}

	/**
	 * 初始化Host信息
	 * @param dto
	 * @return
	 */
	private IGVIR10DTO searchHostInfosAction(IGVIR10DTO dto) throws BLException{
		log.debug("==============Host信息查询操作开始===============");
		List<VIM01Info> vim01List = vim01BL.searchVIM01();
		Map<Integer, List<Host>> map = new LinkedHashMap<Integer, List<Host>>();
		for(VIM01Info info : vim01List){
			map.put(info.getVcid(), vimBL.searchHostByVcid(info.getVcid()));
		}
		dto.setHostMap(map);
		log.debug("==============Host信息查询操作结束===============");
		return dto;
	}

	/**
	 * 初始化流程信息
	 * @param dto
	 * @return
	 */
	private IGVIR10DTO searchProcessRecordAction(IGVIR10DTO dto) {
		log.debug("===========初始化流程信息操作开始===========");
		IG500SearchCondImpl cond = new IG500SearchCondImpl();
		String [] prpds = {"01002","01003","01004"};
		cond.setPrpdid_like_or(prpds);
		List<IG500Info> list = workFlowOperationBL.searchProcessRecord(cond);
		//申请数量
		int countS = 0;
		//调整数量
		int countT = 0;
		//回收数量
		int countH = 0;
		//本月申请数量
		int countS_C = 0;
		//本月调整数量
		int countT_C = 0;
		//本月回收数量
		int countH_C = 0;
		//本月字符串
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM");
		String cdate = sdf.format(new Date());
		Map<String, Integer> orgCountMap = new LinkedHashMap<String, Integer>();
		Map<String, Integer> monthCountMapS = newCountMap();
		Map<String, Integer> monthCountMapT = newCountMap();
		Map<String, Integer> monthCountMapH = newCountMap();
		for(IG500Info info:list){
			//申请数量
			if(info.getPrpdid().startsWith(prpds[0])){
				if(StringUtils.isEmpty(info.getPrclosetime())){
					countS ++;
				}
				if(info.getPropentime().startsWith(cdate)){
					countS_C ++;
				}
				if(orgCountMap.get(info.getProrgname()) == null){
					orgCountMap.put(info.getProrgname(), 1);
				}else{
					orgCountMap.put(info.getProrgname(),orgCountMap.get(info.getProrgname()) + 1) ;
				}
				if(monthCountMapS.get(info.getPropentime().substring(0,7)) != null){
					monthCountMapS.put(info.getPropentime().substring(0,7), monthCountMapS.get(info.getPropentime().substring(0,7)) + 1);
				}
			}
			//调整数量
			if(info.getPrpdid().startsWith(prpds[1])){
				if(StringUtils.isEmpty(info.getPrclosetime())){
					countT ++;
				}
				if(info.getPropentime().startsWith(cdate)){
					countT_C ++;
				}
				if(monthCountMapT.get(info.getPropentime().substring(0,7)) != null){
					monthCountMapT.put(info.getPropentime().substring(0,7), monthCountMapT.get(info.getPropentime().substring(0,7)) + 1);
				}
			}
			//回收数量
			if(info.getPrpdid().startsWith(prpds[2])){
				if(StringUtils.isEmpty(info.getPrclosetime())){
					countH ++;
				}
				if(info.getPropentime().startsWith(cdate)){
					countH_C ++;
				}
				if(monthCountMapH.get(info.getPropentime().substring(0,7)) != null){
					monthCountMapH.put(info.getPropentime().substring(0,7), monthCountMapH.get(info.getPropentime().substring(0,7)) + 1);
				}
			}
		}
		//top5
		Map<String, Integer> top5Map = new LinkedHashMap<String, Integer>();
		List<Entry<String, Integer>> mapEntityList = shortedMap(orgCountMap);
		for(int i=0;i<(mapEntityList.size() > 5 ? 5 : mapEntityList.size());i++){
			top5Map.put(mapEntityList.get(i).getKey(), mapEntityList.get(i).getValue());
		}
		dto.getIgvir10051VO().setTop5Map(top5Map);
		dto.getIgvir10051VO().setCountH(countH);
		dto.getIgvir10051VO().setCountH_C(countH_C);
		dto.getIgvir10051VO().setCountS(countS);
		dto.getIgvir10051VO().setCountS_C(countS_C);
		dto.getIgvir10051VO().setCountT(countT);
		dto.getIgvir10051VO().setCountT_C(countT_C);
		List<Integer> monthCountS = new ArrayList<Integer>(monthCountMapS.values());
		List<Integer> monthCountT = new ArrayList<Integer>(monthCountMapT.values());
		List<Integer> monthCountH = new ArrayList<Integer>(monthCountMapH.values());
		dto.getIgvir10051VO().setMonthCountS(monthCountS);
		dto.getIgvir10051VO().setMonthCountT(monthCountT);
		dto.getIgvir10051VO().setMonthCountH(monthCountH);
		log.debug("===========初始化流程信息操作结束===========");
		return dto;
	}
	
	/**
	 * 排序
	 * @param map
	 * @return
	 */
	private List<Map.Entry<String, Integer>> shortedMap(Map<String, Integer> map){
		List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
		Collections.sort(list,new Comparator<Map.Entry<String, Integer>>() {

			public int compare(Entry<String, Integer> v1,
					Entry<String, Integer> v2) {
				return v1.getValue() - v2.getValue();
			}
		});
		return list;
	}
	
	/**
	 * 实例化map
	 */
	private Map<String, Integer> newCountMap(){
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String year = sdf.format(new Date());
		for(int i=1;i<=12;i++){
			String key = year + "/0" + i;
			if(i >= 10){
				key = year + "/" + i;
			}
			map.put(key, 0);
		}
		return map;
	}
	
	/**
	 * 初始化用户首页
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR10DTO initUserHomePageAction(IGVIR10DTO dto) throws BLException {
		log.debug("===============用户首页初始化操作开始================");
		//查询我的发起
		dto = searchMyOpenProcessAction(dto);
		//获取模板信息
		dto = getTemplateList(dto);
		//初始化虚机信息
		dto = searchVMInfoAction(dto);
		log.debug("===============用户首页初始化操作结束================");
		return dto;
	}

	/**
	 * 查询虚机信息
	 * @param dto
	 * @return
	 */
	private IGVIR10DTO searchVMInfoAction(IGVIR10DTO dto) throws BLException {
		log.debug("=============虚机信息查询操作开始==============");
		//dto参数取得
		User user = dto.getUser();
		Vim03SearchCondImpl cond = new Vim03SearchCondImpl();
		cond.setUserid_eq(user.getUserid());
		List<VIM03Info> list = vim03BL.searchVim03(cond);
		Map<String, VIM03Info> map = new HashMap<String, VIM03Info>();
		for(VIM03Info info:list){
			map.put(info.getVmName(), info);
		}
		dto.setOwnVMList(list);
		List<VIM01Info> vim01List = vim01BL.searchVIM01();
		List<VMachine> vmList = new ArrayList<VMachine>();
		for(VIM01Info info : vim01List){
			for(Host host : vimBL.searchHostByVcid(info.getVcid())){
				if(host.getVmsList() != null){
					for(VMachine vm:host.getVmsList()){
						VIM03Info vim03 = map.get(vm.getName());
						if(vim03 != null){
							if(vim03 != null && StringUtils.isNotEmpty(vim03.getExpiryTime())){
								if(isPastDue(vim03.getExpiryTime())){
									vm.setPastdueflag("Y");
								}else{
									vm.setPastdueflag("N");
								}
							}
							vm.setVcid(vim03.getVcid());
							vmList.add(vm);
						}
					}
				}
			}
		}
		dto.setVmList(vmList);
		log.debug("=============虚机信息查询操作结束==============");
		return dto;
	}

	/**
	 * 计算是否将要过期
	 * @param expiryTime 预计过期时间
	 * @return 是否将要过期
	 */
	private boolean isPastDue(String expiryTime) {
		boolean flag = false;
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			Date d1 = sdf.parse(expiryTime);
			Date d2 = new Date();
			long diff = d1.getTime() - d2.getTime();
			long days = diff / (1000L * 60L * 60L * 24L);
			flag = days <= 10;
		}catch (Exception e) {
			log.error("",e);
		}
		return flag;
	}

	/**
	 * 我的发起查询
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	private IGVIR10DTO searchMyOpenProcessAction(IGVIR10DTO dto) throws BLException{
		log.debug("============我的发起查询操作开始=============");
		//dto参数取得
		User user = dto.getUser();
		IG677SearchCondImpl cond = new IG677SearchCondImpl();
		//设定发起人员ID
		cond.setPpuserid(user.getUserid());
		//发起状态
		cond.setPpstatus(IGPRDCONSTANTS.PROCESS_END_STATUS);
		List<IG677Info> list = ig500BL.searchProcessRecordInfo(cond);
		dto.setMyOpenProcessList(list);
		log.debug("============我的发起查询操作结束=============");
		return dto;
	}
	
	/**
	 * 改变虚机状态操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR10DTO changeVMAction(IGVIR10DTO dto) throws BLException{
		log.debug("=============改变虚机状态操作开始==============");
		//dto参数取得
		String name = dto.getVmname();
		String status = dto.getPowerState();
		Integer vcid = dto.getVcid();
		if(StringUtils.isNotEmpty(name) && StringUtils.isNotEmpty(status)){
			Vim03SearchCondImpl cond = new Vim03SearchCondImpl();
			cond.setVmName(name);
			List<VIM03Info> list = vim03BL.searchVim03(cond);
			if(list.isEmpty()){
				throw new BLException("IGCO10000.E004","虚机信息");
			}
			if("poweredOn".equals(status)){
				vimBL.poweredOffVM(vcid, name,list.get(0).getHostName());
			}else{
				vimBL.poweredOnVM(vcid, name,list.get(0).getHostName());
			}
		}
		log.debug("=============改变虚机状态操作结束==============");
		return dto;
	}
	
	/**
	 * 初始化资源管理首页
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR10DTO initResourceManageHomePageAction(IGVIR10DTO dto) throws BLException{
		log.debug("==============资源管理首页初始化操作开始================");
		//查询待办工作
		dto = getPendingProcessList(dto);
		//获取模板信息
		dto = getTemplateList(dto);
		//初始化Host信息
		dto = searchHostInfosAction(dto);
		//初始化流程信息
		dto = searchProcessReportAction(dto);
		log.debug("==============资源管理首页初始化操作结束================");
		return dto;
	}

	/**
	 * 查询流程趋势信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	private IGVIR10DTO searchProcessReportAction(IGVIR10DTO dto) throws BLException{
		log.debug("================流程趋势信息查询操作开始=================");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String year = sdf.format(new Date());
		String [] prpds = {"01080","01083","01084"};
		IG500SearchCondImpl cond = new IG500SearchCondImpl();
		List<IG500Info> list = workFlowOperationBL.searchProcessRecord(cond);
		Map<String, Integer> vmReportMap = newCountMap();
		Map<String, Map<String, Integer>> prRecportMap = new LinkedHashMap<String, Map<String,Integer>>();
		for(IG500Info info:list){
			String infoYear = info.getPropentime().substring(0,4);
			if(year.equals(infoYear) && info.getPrpdid().startsWith("01002")){
				vmReportMap.put(info.getPropentime().substring(0,7),vmReportMap.get(info.getPropentime().substring(0,7)) + 1);
			}
			for(String prpdid : prpds){
				if(info.getPrpdid().equals(prpdid)){
					if(prRecportMap.get(infoYear) == null){
						Map<String, Integer> map = new LinkedHashMap<String, Integer>();
						for(String s:prpds){
							map.put(s, 0);
						}
						map.put(info.getPrpdid().substring(0,5), 1);
						prRecportMap.put(infoYear, map);
					}else{
						prRecportMap.get(infoYear).put(info.getPrpdid().substring(0,5), prRecportMap.get(infoYear).get(info.getPrpdid().substring(0,5) + 1));
					}
					break;
				}
			}
		}
		dto.setVmReportMap(vmReportMap);
		dto.setPrRecportMap(prRecportMap);
		log.debug("================流程趋势信息查询操作结束=================");
		return dto;
	}
}
