package com.deliverik.infogovernor.soc.vir.bl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.bl.task.OrganizationBL;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.infogovernor.soc.vir.bl.task.VIM03BL;
import com.deliverik.infogovernor.soc.vir.bl.task.VIM03CountByOrgVWBL;
import com.deliverik.infogovernor.soc.vir.bl.task.VIM03CountByProjVWBL;
import com.deliverik.infogovernor.soc.vir.bl.task.VIM03CountByUserVWBL;
import com.deliverik.infogovernor.soc.vir.bl.task.VIM05BL;
import com.deliverik.infogovernor.soc.vir.bl.task.VIM06BL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR11DTO;
import com.deliverik.infogovernor.soc.vir.form.IGVIR1101Form;
import com.deliverik.infogovernor.soc.vir.form.IGVIR1102Form;
import com.deliverik.infogovernor.soc.vir.form.IGVIR1103Form;
import com.deliverik.infogovernor.soc.vir.model.VIM03CountByOrgVWInfo;
import com.deliverik.infogovernor.soc.vir.model.VIM03CountByProjVWInfo;
import com.deliverik.infogovernor.soc.vir.model.VIM03CountByUserVWInfo;
import com.deliverik.infogovernor.soc.vir.model.VIM03Info;
import com.deliverik.infogovernor.soc.vir.model.VIM05Info;
import com.deliverik.infogovernor.soc.vir.model.VIM06Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM03CountByOrgVWSearchCondImpl;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM03CountByProjVWSearchCondImpl;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM03CountByUserVWSearchCondImpl;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM06SearchCondImpl;
import com.deliverik.infogovernor.soc.vir.model.condition.Vim03SearchCondImpl;
import com.deliverik.infogovernor.soc.vir.model.entity.VIM03CountByOrgVW;
import com.deliverik.infogovernor.soc.vir.model.entity.VIM03CountByProjVW;
import com.deliverik.infogovernor.soc.vir.model.entity.VIM03CountByUserVW;
import com.deliverik.infogovernor.soc.vir.model.entity.VIM03TB;

/**
 * 虚拟化管理业务逻辑实现
 *
 */
public class IGVIR11BLImpl extends BaseBLImpl implements IGVIR11BL{

	static Log log = LogFactory.getLog(IGVIR08BLImpl.class);
	
	/** 虚拟资源统计BL */
	protected VIM03CountByUserVWBL vim03CountByUserVWBL;
	protected VIM03CountByOrgVWBL vim03CountByOrgVWBL;
	protected VIM03CountByProjVWBL vim03CountByProjVWBL;
	
	protected VIM03BL vim03BL;
	
	protected UserBL userBL;
	
	protected OrganizationBL organizationBL;
	
	protected VIM05BL vim05BL;
	
	protected VIM06BL vim06BL;

	/**
	 * 虚拟资源统计BL设定
	 * @param vim03CountByUserVWBL 虚拟资源统计BL
	 */
	public void setVim03CountByUserVWBL(VIM03CountByUserVWBL vim03CountByUserVWBL) {
		this.vim03CountByUserVWBL = vim03CountByUserVWBL;
	}

	/**
	 * vim03CountByOrgVWBL设定
	 * @param vim03CountByOrgVWBL vim03CountByOrgVWBL
	 */
	public void setVim03CountByOrgVWBL(VIM03CountByOrgVWBL vim03CountByOrgVWBL) {
		this.vim03CountByOrgVWBL = vim03CountByOrgVWBL;
	}

	/**
	 * vim03CountByProjVWBL设定
	 * @param vim03CountByProjVWBL vim03CountByProjVWBL
	 */
	public void setVim03CountByProjVWBL(VIM03CountByProjVWBL vim03CountByProjVWBL) {
		this.vim03CountByProjVWBL = vim03CountByProjVWBL;
	}

	/**
	 * vim03BL设定
	 * @param vim03BL vim03BL
	 */
	public void setVim03BL(VIM03BL vim03bl) {
		vim03BL = vim03bl;
	}

	/**
	 * userBL设定
	 * @param userBL userBL
	 */
	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
	}

	/**
	 * organizationBL设定
	 * @param organizationBL organizationBL
	 */
	public void setOrganizationBL(OrganizationBL organizationBL) {
		this.organizationBL = organizationBL;
	}
	
	public void setVim05BL(VIM05BL vim05BL) {
		this.vim05BL = vim05BL;
	}

	public void setVim06BL(VIM06BL vim06BL) {
		this.vim06BL = vim06BL;
	}

	/**
	 * 虚拟资源统计(按用户)
	 *
	 * @param dto IGVIR11DTO
	 * @return IGVIR11DTO
	 */
	public IGVIR11DTO getVim03CountByUser(IGVIR11DTO dto) throws BLException {
		log.debug("========虚拟资源统计查询开始（按用户）========");
		
		// 查询记录总数
		IGVIR1101Form form = dto.getIgVIR1101Form();
		VIM03CountByUserVWSearchCondImpl cond = new VIM03CountByUserVWSearchCondImpl();
		cond.setUserid_like(form.getUserid_like());
		cond.setUsername_like(form.getUsername_like());
		cond.setOrgsyscoding_like(form.getOrgsyscoding_like());
		
		List<VIM03CountByUserVWInfo> listAll = vim03CountByUserVWBL.findByCond(cond, 0, 0);
		if(listAll == null || listAll.size() == 0){
			log.debug("========查询数据不存在========");
			// 查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		// 查询记录总数
		int totalCount = listAll.size();
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========查询数据件数过多========");
			// 查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}
		//获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		pDto.setTotalCount(totalCount);
		List<VIM03CountByUserVWInfo> vim03uList = vim03CountByUserVWBL.findByCond(cond,pDto.getFromCount(), pDto.getPageDispCount());
		
		/**
		 * 计费逻辑开始
		 */
		List<VIM03CountByUserVWInfo> results = new ArrayList<VIM03CountByUserVWInfo>();
		HashMap<String,Integer> priceMap = getPriceMap();
		
		for(VIM03CountByUserVWInfo info:vim03uList){
			Integer cpuuse = info.getTotalcpu() == null?0:info.getTotalcpu();
			Integer cpuprice = cpuuse*(priceMap.get("001") == null?0:priceMap.get("001"));
			
			Integer memuse = info.getTotalmem() == null?0:info.getTotalmem();
			Integer memprice = memuse*(priceMap.get("002") == null?0:priceMap.get("002"));
			
			Integer diskuse = info.getTotaldisk() == null?0:info.getTotaldisk();
			Integer diskprice = diskuse*(priceMap.get("003") == null?0:priceMap.get("003"));
			
			VIM03CountByUserVW bean = (VIM03CountByUserVW)info;
			bean.setCost(cpuprice + memprice + diskprice);
			results.add(bean);
		}
		
		dto.setVim03uList(results);
		log.debug("========虚拟资源统计查询终了（按用户）========");
		return dto;
	}
	
	/**
	 * 虚拟资源统计(按用户)
	 *
	 * @param dto IGVIR11DTO
	 * @return IGVIR11DTO
	 */
	public IGVIR11DTO searchVim03ByUser(IGVIR11DTO dto) throws BLException{
		
//		User user = userBL.searchUserByKey(dto.getIgVIR1104Form().getUserid());
//		dto.setUser(user);
		Vim03SearchCondImpl cond = new Vim03SearchCondImpl();
		cond.setUserid_eq(dto.getIgVIR1104Form().getUserid());
		cond.setProgress_eq("100");
		List<VIM03Info> vim03List = vim03BL.searchVim03(cond);
		dto.setOneVim03uList(vim03List);
		return dto;
	}
	
	/**
	 * 虚拟资源统计(按机构)
	 *
	 * @param dto IGVIR11DTO
	 * @return IGVIR11DTO
	 */
	public IGVIR11DTO getVim03CountByOrg(IGVIR11DTO dto) throws BLException {
		log.debug("========虚拟资源统计查询开始（按机构）========");
		// 查询记录总数
		IGVIR1102Form form = dto.getIgVIR1102Form();
		VIM03CountByOrgVWSearchCondImpl cond = new VIM03CountByOrgVWSearchCondImpl();
		cond.setOrgsyscoding_like(form.getOrgsyscoding_like());
		
		List<VIM03CountByOrgVWInfo> listAll = vim03CountByOrgVWBL.findByCond(cond, 0, 0);
		if(listAll == null || listAll.size() == 0){
			log.debug("========查询数据不存在========");
			// 查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		// 查询记录总数
		int totalCount = listAll.size();
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========查询数据件数过多========");
			// 查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}
		//获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		pDto.setTotalCount(totalCount);
		List<VIM03CountByOrgVWInfo> vim03oList = vim03CountByOrgVWBL.findByCond(cond,pDto.getFromCount(), pDto.getPageDispCount());
		
		/**
		 * 计费逻辑开始
		 */
		List<VIM03CountByOrgVWInfo> results = new ArrayList<VIM03CountByOrgVWInfo>();
		HashMap<String,Integer> priceMap = getPriceMap();
		
		for(VIM03CountByOrgVWInfo info:vim03oList){
			Integer cpuuse = info.getTotalcpu() == null?0:info.getTotalcpu();
			Integer cpuprice = cpuuse*(priceMap.get("001") == null?0:priceMap.get("001"));
			
			Integer memuse = info.getTotalmem() == null?0:info.getTotalmem();
			Integer memprice = memuse*(priceMap.get("002") == null?0:priceMap.get("002"));
			
			Integer diskuse = info.getTotaldisk() == null?0:info.getTotaldisk();
			Integer diskprice = diskuse*(priceMap.get("003") == null?0:priceMap.get("003"));
			
			VIM03CountByOrgVW bean = (VIM03CountByOrgVW)info;
			bean.setCost(cpuprice + memprice + diskprice);
			results.add(bean);
		}
		
		dto.setVim03oList(results);
		log.debug("========虚拟资源统计查询终了（按机构）========");
		return dto;
	}
	
	
	/**
	 * 虚拟资源统计
	 *
	 * @param dto IGVIR11DTO
	 * @return IGVIR11DTO
	 */
	public IGVIR11DTO searchVim03(IGVIR11DTO dto) throws BLException{
		String searchType = dto.getIgVIR1104Form().getSearchType();
		Vim03SearchCondImpl cond = new Vim03SearchCondImpl();
		if("ctrl".equals(dto.getIgVIR1104Form().getShowType())){
			if("user".equals(searchType)){
				cond.setUserid_eq(dto.getIgVIR1104Form().getUserid());
			}else if("org".equals(searchType)){
				cond.setOrgsyscoding_eq(dto.getIgVIR1104Form().getOrgsyscoding());
			}else if("proj".equals(searchType)){
				cond.setPid_eq(dto.getIgVIR1104Form().getPid_eq());
			}
		}else{
			if("user".equals(searchType)){
				cond.setUserid_eq(dto.getLoginUser().getUserid());
			}else if("org".equals(searchType)){
				cond.setOrgsyscoding_eq(dto.getLoginUser().getOrgid());
			}
		}
		cond.setProgress_eq("100");
		List<VIM03Info> vim03List = vim03BL.searchVim03(cond);
		
		/**
		 * 计费策略开始
		 */
		List<VIM03Info> results = new ArrayList<VIM03Info>();
		HashMap<String,Integer> priceMap = new HashMap<String,Integer>();
		
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
		
		for(VIM03Info info:vim03List){
			
			int useTime = 0;
			try {
				useTime = daysBetween(info.getApplyTime(),new SimpleDateFormat("yyyy/MM/dd").format(new Date()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			Integer cpuuse = info.getVmCpus() == null?0:info.getVmCpus();
			Integer cpuprice = cpuuse*(priceMap.get("001") == null?0:priceMap.get("001"))*useTime;
			
			Integer memuse = info.getVmMem() == null?0:info.getVmMem();
			Integer memprice = memuse*(priceMap.get("002") == null?0:priceMap.get("002"))*useTime;
			
			Integer diskuse = info.getVmDisk() == null?0:info.getVmDisk();
			Integer diskprice = diskuse*(priceMap.get("003") == null?0:priceMap.get("003"))*useTime;
			
			VIM03TB bean = (VIM03TB)info;
			bean.setCpucost(String.valueOf(cpuprice));
			bean.setMemcost(String.valueOf(memprice));
			bean.setDiskcost(String.valueOf(diskprice));
			results.add(bean);
			
		}
		
		dto.setOneVim03List(results);
		return dto;
	}
	
	/**
	 * 虚拟资源统计(按项目)
	 *
	 * @param dto IGVIR11DTO
	 * @return IGVIR11DTO
	 */
	public IGVIR11DTO getVim03CountByProj(IGVIR11DTO dto) throws BLException {
		log.debug("========虚拟资源统计查询开始（按项目）========");
		// 查询记录总数
		IGVIR1103Form form = dto.getIgVIR1103Form();
		VIM03CountByProjVWSearchCondImpl cond = new VIM03CountByProjVWSearchCondImpl();
		cond.setPname_like(form.getPname_like());
		
		List<VIM03CountByProjVWInfo> listAll = vim03CountByProjVWBL.findByCond(cond, 0, 0);
		if(listAll == null || listAll.size() == 0){
			log.debug("========查询数据不存在========");
			// 查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		// 查询记录总数
		int totalCount = listAll.size();
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========查询数据件数过多========");
			// 查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}
		//获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		pDto.setTotalCount(totalCount);
		List<VIM03CountByProjVWInfo> vim03pList = vim03CountByProjVWBL.findByCond(cond,pDto.getFromCount(), pDto.getPageDispCount());
		
		/**
		 * 计费逻辑开始
		 */
		List<VIM03CountByProjVWInfo> results = new ArrayList<VIM03CountByProjVWInfo>();
		HashMap<String,Integer> priceMap = getPriceMap();
		
		for(VIM03CountByProjVWInfo info:vim03pList){
			Integer cpuuse = info.getTotalcpu() == null?0:info.getTotalcpu();
			Integer cpuprice = cpuuse*(priceMap.get("001") == null?0:priceMap.get("001"));
			
			Integer memuse = info.getTotalmem() == null?0:info.getTotalmem();
			Integer memprice = memuse*(priceMap.get("002") == null?0:priceMap.get("002"));
			
			Integer diskuse = info.getTotaldisk() == null?0:info.getTotaldisk();
			Integer diskprice = diskuse*(priceMap.get("003") == null?0:priceMap.get("003"));
			
			VIM03CountByProjVW bean = (VIM03CountByProjVW)info;
			bean.setCost(cpuprice + memprice + diskprice);
			results.add(bean);
		}
		
		dto.setVim03pList(results);
		log.debug("========虚拟资源统计查询终了（按项目）========");
		return dto;
	}

	public IGVIR11DTO searchVim03ByOrg(IGVIR11DTO dto) throws BLException {
		return dto;
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
   *字符串的日期格式的计算 
   */  
   public static int daysBetween(String smdate,String bdate) throws ParseException{  
	    SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");  
	    Calendar cal = Calendar.getInstance();    
	    cal.setTime(sdf.parse(smdate));    
	    long time1 = cal.getTimeInMillis();                 
	    cal.setTime(sdf.parse(bdate));    
	    long time2 = cal.getTimeInMillis();         
	    long between_days=(time2-time1)/(1000*3600*24);  
            
	    return Integer.parseInt(String.valueOf(between_days));     
    }  
}
