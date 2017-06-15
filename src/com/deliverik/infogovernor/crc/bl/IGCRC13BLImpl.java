package com.deliverik.infogovernor.crc.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.igflow.api.SysManageBL;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCondImpl;
import com.deliverik.infogovernor.crc.bl.task.IGCRC1301BL;
import com.deliverik.infogovernor.crc.bl.task.IGCRC1303BL;
import com.deliverik.infogovernor.crc.bl.task.IGCRC1304BL;
import com.deliverik.infogovernor.crc.dto.IGCRC1301DTO;
import com.deliverik.infogovernor.crc.dto.IGCRC1302DTO;
import com.deliverik.infogovernor.crc.dto.IGCRC1303DTO;
import com.deliverik.infogovernor.crc.dto.IGCRC1304DTO;
import com.deliverik.infogovernor.crc.form.IGCRC1301Form;
import com.deliverik.infogovernor.crc.form.IGCRC1303Form;
import com.deliverik.infogovernor.crc.form.IGCRC1304Form;
import com.deliverik.infogovernor.crc.model.IGCRC1301VWInfo;
import com.deliverik.infogovernor.crc.model.IGCRC1303VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC1301CondImpl;
import com.deliverik.infogovernor.crc.model.condition.IGCRC1303Cond;
import com.deliverik.infogovernor.crc.model.condition.IGCRC1303CondImpl;
import com.deliverik.infogovernor.crc.model.condition.IGCRC1304CondImpl;
import com.deliverik.infogovernor.crc.model.entity.DepartModelVW;
import com.deliverik.infogovernor.crc.model.entity.IGCRC1301VW;
import com.deliverik.infogovernor.crc.model.entity.ModelVW;

/**
 * 文档查询业务逻辑实现
 *
 */
public class IGCRC13BLImpl implements IGCRC13BL {

	static Log log = LogFactory.getLog(IGCRC13BLImpl.class);
	
	/** 文档信息BL */
	protected IGCRC1301BL igcrc1301BL;
	
	/** 文档信息统计BL */
	protected IGCRC1303BL igcrc1303BL;
	
	/** 部门文档统计信息BL */
	protected IGCRC1304BL igcrc1304BL;
	
	/** 流程查询功能API */
	protected SysManageBL sysManageBL;
	
	/**流程处理BL*/
	protected WorkFlowOperationBL workFlowOperationBL;

	/**
	 * 流程处理BL设定
	 * @param workFlowOperationBL 流程处理BL
	 */
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}

	public void setIgcrc1301BL(IGCRC1301BL igcrc1301bl) {
		igcrc1301BL = igcrc1301bl;
	}
	
	public void setSysManageBL(SysManageBL sysManagebl) {
		sysManageBL = sysManagebl;
	}

	public void setIgcrc1303BL(IGCRC1303BL igcrc1303bl) {
		igcrc1303BL = igcrc1303bl;
	}

	public void setIgcrc1304BL(IGCRC1304BL igcrc1304bl) {
		igcrc1304BL = igcrc1304bl;
	}

	/**
	 * 文档信息查询处理
	 *
	 * @param dto IGCRC1301DTO
	 * @return IGCRC1301DTO
	 */
	public IGCRC1301DTO searchEntityItemAction(IGCRC1301DTO dto)
			throws BLException {
		log.debug("========文档信息查询处理开始========");
		IGCRC1301Form form = dto.getIgcrc1301Form();
		
		IGCRC1301CondImpl cond = new IGCRC1301CondImpl();
		
		BeanUtils.copyProperties(form, cond);
		
		//分页用信息取得
		PagingDTO pDto = dto.getPagingDto();
		List<IGCRC1301VWInfo> crList = igcrc1301BL.searchIGCRC1301(cond, pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(igcrc1301BL.getSearchCount(cond));
		dto.setEntityItemVWInfoList(crList);
		
		//获取用户角色列表
		List<Integer> roleList  = sysManageBL.searchRoleListByUserid(dto.getUser().getUserid());
		
		String isManeger = "";
		
		for(int i=0;i<roleList.size();i++){
//			if(roleList.get(i) == 3002 ||  roleList.get(i) == 3003 || roleList.get(i) == 3004 ){
//				dto.setIsManeger("1");
//				break;
//			}
			if (roleList.get(i) == 3002) {
				isManeger += "_科技管理类";
			} else if (roleList.get(i) == 3003) {
				isManeger += "_软件开发类";
			} else if (roleList.get(i) == 3004) {
				isManeger += "_生产运行类";
			}
		}		
		if (StringUtils.isNotEmpty(isManeger)) {
			isManeger = isManeger.substring(1);
		}
		
		dto.setIsManeger(isManeger);
		
		log.debug("========文档信息查询处理终了========");
		return dto;
	}
	/**
	 * 按照文档统计处理
	 *
	 * @param dto IGCRC1301DTO
	 * @return IGCRC1301DTO
	 */
	public IGCRC1303DTO searchEntitySumAction(IGCRC1303DTO dto) throws BLException{
		// TODO Auto-generated method stub
		log.debug("========文档存量统计查询处理开始========");
		IGCRC1303Form form = dto.getIgcrc1303Form();
		
		IGCRC1303CondImpl cond = new IGCRC1303CondImpl();
		
		BeanUtils.copyProperties(form, cond);	
		
		StringBuffer type = new StringBuffer();
		type.append(form.getEiSort());
		if(form.getEiSort()!= null && !type.toString().contains("-")){
			type.append("%");
			cond.setEiSort(type.toString());
		}

		//分页用信息取得		
		PagingDTO pDto = dto.getPagingDto();
		List<IGCRC1303VWInfo> crList = igcrc1303BL.searchIGCRC1303(cond, pDto.getFromCount(), pDto.getPageDispCount());

		Map<String,Integer> maps = new HashMap<String, Integer>();
		List<ModelVW> vwList = new ArrayList<ModelVW>();
		if(crList.size()!=0){
			/**进行去重,并进行统计 **/
			
			List<String> typeList = new ArrayList<String>();
			
			for(int i =0 ;i<crList.size();i++){
				String temp = crList.get(i).getEiSort();
				typeList.add(temp);
			}
			//去重，去掉相同项
			Set<String> sets = new HashSet<String>(typeList);
			
			Object[] strs = (Object[]) sets.toArray();
			//查看每一项的数量
			for(int i = 0;i<strs.length;i++){
				ModelVW model = new ModelVW();
				
				String[] str1 = ((String) strs[i]).split("_");
				
				model.setTypeid(str1[0]);
				
				int y = getSum1(crList,(String)strs[i]);
				
				model.setType(str1[str1.length-1]);

				model.setWordSum(y);

				vwList.add(model);
			}
			
		}else{
			
			String str = form.getEiSort();
			ModelVW model = new ModelVW();
			if(str!=null && !(str.equals(""))){
				model.setType(str);
				model.setWordSum(0);
				vwList.add(model);
			}
//			int z = getReadSum(listMap,str);
//			model.setReadSum(z); 
		}
		dto.setListVM(vwList);
		pDto.setTotalCount(vwList.size());
		dto.setEntityItemVWInfoList(crList);
		
		//获取用户角色列表
		List<Integer> roleList  = sysManageBL.searchRoleListByUserid(dto.getUser().getUserid());
		
		for(int i=0;i<roleList.size();i++){
			if(roleList.get(i) == 3002 ||  roleList.get(i) == 3003 || roleList.get(i) == 3004 ){
				dto.setIsManeger("1");
				break;
			}
		}
		log.debug("========文档存量统计查询处理开始========");		
		return dto;
	}


	/**
	 * 按申请人部门查询统计处理
	 *
	 * @param dto IGCRC1301DTO
	 * @return IGCRC1301DTO
	 */
	public IGCRC1304DTO searchDepartSumAction(IGCRC1304DTO dto) throws BLException{
		log.debug("========文档部门统计查询处理开始========");
		IGCRC1304Form form = dto.getIgcrc1304Form();
		IGCRC1304CondImpl cond = new IGCRC1304CondImpl();

		BeanUtils.copyProperties(form, cond);
		String department = form.getDepartment();
		if(department!=null){
			if(department.equals("信息科技部")){
				department = "科技部";
				cond.setDepartment(department);
			}
		}
		
		//分页用信息取得
		PagingDTO pDto = dto.getPagingDto();
		List<IGCRC1303VWInfo> crList = igcrc1304BL.searchIGCRC1304(cond, pDto.getFromCount(), pDto.getPageDispCount());
		List<String> condList = igcrc1304BL.searchDownDepart();
		
		List<String> listMap = igcrc1304BL.searchType();
		
		List<DepartModelVW> vwList = new ArrayList<DepartModelVW>();
		
		
		//判断查询的结果是否为空，如果为空的话，直接输出各种0
		if(crList.size()!=0){
			List<String> typeList = new ArrayList<String>();
			//选出各个文档资产的名称
			for(int i =0 ;i<crList.size();i++){
				String temp = crList.get(i).getEiName();
				typeList.add(temp);
			}
			//查看每一项的数量
			for(int i = 0;i<crList.size();i++){
				int x = getDownSun(condList,crList.get(i).getEiName());
				DepartModelVW model = new DepartModelVW();
				model.setEiname(typeList.get(i));
				model.setEiid(crList.get(i).getEiid());
				model.setDowSum(x);
				int z = getReadSum(listMap,crList.get(i).getEiName());
				model.setReadSum(z);
				vwList.add(model);
			}
		}
		dto.setListVM(vwList);
		pDto.setTotalCount(vwList.size());
		dto.setEntityItemVWInfoList(crList);
		
		
		//获取用户角色列表
		List<Integer> roleList  = sysManageBL.searchRoleListByUserid(dto.getUser().getUserid());
		
		for(int i=0;i<roleList.size();i++){
			if(roleList.get(i) == 3002 ||  roleList.get(i) == 3003 || roleList.get(i) == 3004 ){
				dto.setIsManeger("1");
				break;
			}
		}
		log.debug("========文档部门统计查询处理开始========");	
		return dto;
	}
	
	/**
	 * 文档信息查询处理
	 *
	 * @param dto IGCRC1301DTO
	 * @return IGCRC1301DTO
	 */
	public IGCRC1301DTO searchItemAction(IGCRC1301DTO dto)
			throws BLException {
		log.debug("========文档详细信息查询处理开始========");
		IGCRC1301Form form = dto.getIgcrc1301Form();
		
		IGCRC1301CondImpl cond = new IGCRC1301CondImpl();
		
		BeanUtils.copyProperties(form, cond);
		//分页用信息取得
		PagingDTO pDto = dto.getPagingDto();
		List<IGCRC1301VWInfo> crList = igcrc1301BL.searchIGCRC1302(cond, pDto.getFromCount(), pDto.getPageDispCount());
		
		
		List<IGCRC1301VWInfo> finalList = new ArrayList<IGCRC1301VWInfo>();
		String type = dto.getType();
		if(type!=null && !(type.equals(""))){
			for(int i =0 ;i<crList.size();i++){
				String[] temp = crList.get(i).getEiSort().split("_");
				if(temp[0].equals(type)){
					IGCRC1301VW igcrc1301vw = (IGCRC1301VW) crList.get(i);
					igcrc1301vw.setEiSort(type);
					finalList.add(igcrc1301vw);
				}
			}
		}else{
			for(int i =0 ;i<crList.size();i++){
				IGCRC1301VW igcrc1301vw = (IGCRC1301VW) crList.get(i);
				if(crList.get(i).getEiSort()!=null){
					String[] temp = crList.get(i).getEiSort().split("_");
					igcrc1301vw.setEiSort(temp[0]);
				}
				finalList.add(igcrc1301vw);
			}
		}
		dto.setEntityItemVWInfoList(finalList);
		pDto.setTotalCount(finalList.size());
		log.debug("========文档详细信息查询处理终了========");
		return dto;
	}

	/**
	 * 得到该集合中与字符串匹配的数量
	 * @param listMap
	 * @param str
	 * @return
	 */
	private int getReadSum(List<String> listMap, String str) {
		// TODO Auto-generated method stub
		int x = 0;
		for(int i = 0;i<listMap.size()&&str!=null;i++){
			String[] strs = listMap.get(i).split("_");
			//获取一级分类
			String[] strs2 = strs[strs.length-1].split("-");
			if(str.equals(strs2[0])){
				x++;
			}
		}
		return x;
	}

	/**
	 * 判断某个元素在List 集合中的个数
	 * @param crList
	 * @param string
	 * @return
	 */
	private int getSum(List<IGCRC1303VWInfo> crList, String str) {
		// TODO Auto-generated method stub
		int x = 0;
		for(int i=0;i<crList.size()&&str!=null;i++){
			String[] strs = crList.get(i).getDepartment().split("-");
			if(str.equals(strs[0])){
				x++;
			}	
		}
		return x;
	}
	/**
	 * 判断某个元素在List 集合中的个数
	 * @param crList
	 * @param string
	 * @return
	 */
	private int getSum1(List<IGCRC1303VWInfo> crList, String str) {
		// TODO Auto-generated method stub
		int x = 0;
		for(int i=0;i<crList.size()&&str!=null;i++){
			if(str.equals(crList.get(i).getEiSort())){
				x++;
			}	
		}
		return x;
	}
	/**
	 * 迭代处每个部门的下载数量
	 * @param condList
	 * @param object
	 * @return
	 */
	private int getDownSun(List<String> condList, String str) {
		// TODO Auto-generated method stub
		int x = 0;
		for(int i =0;i<condList.size()&&str!=null;i++){
			if(str.equals(condList.get(i))){
				x++;
			}
		}
		return x;
	}
	
	
	/**
	 * 文档信息查询处理
	 *
	 * @param dto IGCRC1301DTO
	 * @return IGCRC1301DTO
	 */
	public IGCRC1301DTO openSearchEntityItemAction(IGCRC1301DTO dto)
			throws BLException {
		log.debug("========文档信息查询处理开始========");
		IGCRC1301Form form = dto.getIgcrc1301Form();
		
		IGCRC1301CondImpl cond = new IGCRC1301CondImpl();
		
		BeanUtils.copyProperties(form, cond);
		//查询是否可下载为‘否’的
		cond.setIsDownload("否");
		//分页用信息取得
		PagingDTO pDto = dto.getPagingDto();
		List<IGCRC1301VWInfo> crList = igcrc1301BL.searchIGCRC1301(cond, pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(igcrc1301BL.getSearchCount(cond));
		dto.setEntityItemVWInfoList(crList);
		
		log.debug("========文档信息查询处理终了========");
		return dto;
	}
	
	public IGCRC1304DTO searchIG500ItemAction(IGCRC1304DTO dto)throws BLException{
		
		IGCRC1304Form form = dto.getIgcrc1304Form();
		IGCRC1304CondImpl cond = new IGCRC1304CondImpl();

		
		BeanUtils.copyProperties(form, cond);
		//分页用信息取得
		PagingDTO pDto = dto.getPagingDto();		
		
		List<Integer> IdList = igcrc1304BL.searchTypeID(cond);
		
		IG500SearchCondImpl condIg500 = new IG500SearchCondImpl();
		
		// 变更管理类型编号
		condIg500.setPrpdid("0112001");

		// 查询流程信息
		dto.setProcessList(workFlowOperationBL.searchProcessByType(condIg500, 0, 0,null));
		
		List<IG500Info> ig500 = dto.getProcessList();
		
		List<IG500Info> ig500final = new ArrayList<IG500Info>();

		if(IdList.size()<1){
			dto.setProcessList(ig500final);
		}else{
			for(int i =0;i<ig500.size();i++){
				for(int j=0;j<IdList.size();j++){
					Integer prid = IdList.get(j);
					if(ig500.get(i).getPrid().equals(prid)){
						ig500final.add(ig500.get(i));
					}
				}
			}
			dto.setProcessList(ig500final);
		}
		pDto.setTotalCount(ig500final.size());
		return dto;
	}
	
	
	/**
	 * 我的借阅，获取用户发起的文档借阅
	 *
	 * @param dto IGCRC1302DTO
	 * @return IGCRC1302DTO
	 */
	public IGCRC1302DTO getWorkInitByMe(IGCRC1302DTO dto) throws BLException {
		log.debug("========获取我的文档借阅开始========");
		String userId = dto.getUserId();
		IG500SearchCondImpl cond = new IG500SearchCondImpl();
		cond.setPrpdid("0112001");//文档借阅流程
		cond.setPruserid(userId);
		List<IG500Info> processRecords = workFlowOperationBL.searchProcessRecordSubStatusList(cond, 0, 0);
		dto.setEntityItemInfoList(processRecords);
		log.debug("========获取我的文档借阅结束========");
		return dto;
	}

	
	
	
}
