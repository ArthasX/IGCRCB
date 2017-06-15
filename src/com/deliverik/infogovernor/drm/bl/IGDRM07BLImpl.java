/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.bl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.springframework.beans.BeanUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.bl.task.SOC0107BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0117BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0119BL;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0107SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0117SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0118SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0119SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0129SearchCondImpl;
import com.deliverik.framework.soc.asset.model.entity.SOC0124VW;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.model.UserInfo;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCondImpl;
import com.deliverik.infogovernor.drm.IGDRMCONSTANTS;
import com.deliverik.infogovernor.drm.bl.task.DrillplanitemBL;
import com.deliverik.infogovernor.drm.bl.task.OptionSencesBL;
import com.deliverik.infogovernor.drm.bl.task.StructureRoleBL;
import com.deliverik.infogovernor.drm.dto.IGDRM07DTO;
import com.deliverik.infogovernor.drm.form.IGDRM0702Form;
import com.deliverik.infogovernor.drm.form.IGDRM0710Form;
import com.deliverik.infogovernor.drm.model.OptionSencesInfo;
import com.deliverik.infogovernor.drm.model.StructureRoleInfo;
import com.deliverik.infogovernor.drm.model.condition.OptionSencesSearchCondImpl;
import com.deliverik.infogovernor.drm.model.condition.StructureRoleSearchCondImpl;

/**
 * 演练方案BL
 * 
 *
 * 2015年3月6日09:15:56
 */
public class IGDRM07BLImpl extends BaseBLImpl implements IGDRM07BL {
	
	static Log log = LogFactory.getLog(IGDRM07BLImpl.class);
	/**流程BL*/
	private IG500BL ig500BL; 
	/**资产模型BL*/
	private SOC0117BL soc0117BL ;
	/** EntityItemBL */
	protected SOC0118BL soc0118BL;
	/** 资产关系0119BL */
	protected SOC0119BL soc0119BL;
	/**资产属性BL*/
	protected SOC0107BL soc0107BL;
	/**流程定义BL*/
	protected WorkFlowDefinitionBL workFlowDefinitionBL;

	protected StructureRoleBL structureRoleBL;

	protected DrillplanitemBL drillplanitemBL;

	protected UserBL userBL;

	/** 备选场景BL */
	protected OptionSencesBL optionSencesBL;

	public void setOptionSencesBL(OptionSencesBL optionSencesBL) {
		this.optionSencesBL = optionSencesBL;
	}

	public void setStructureRoleBL(StructureRoleBL structureRoleBL) {
		this.structureRoleBL = structureRoleBL;
	}

	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
	}
	/**
     * @Description: 演练方案定义节点流程显示 
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM07DTO    
     * @throws
     */
	public IGDRM07DTO initIGDRM0701DefAction(IGDRM07DTO dto)throws BLException{
		IG500SearchCondImpl ig500cond = new IG500SearchCondImpl();
		//演练方案定义节点
		ig500cond.setPrstatus("Y");
		ig500cond.setPrpdid("01385");
		ig500cond.setOrder("propentime");
		ig500cond.setSing("DESC");
		List<IG500Info> ig500InfoList = ig500BL.searchIG500Info(ig500cond);
		dto.setIg500InfoList(ig500InfoList);
	    return dto;
	}
	/**
	 * @Description: 演练实施节点流程显示 
	 * @param dto
	 * @return
	 * @throws BLException    
	 * IGDRM07DTO    
	 * @throws
	 */
	public IGDRM07DTO initIGDRM0701ImplAction(IGDRM07DTO dto)throws BLException{
		IG500SearchCondImpl ig500cond = new IG500SearchCondImpl();
		//“指挥流程prid”表单值为空的流程
		ig500cond.setVarnames(new String[]{"指挥流程prid"});
		ig500cond.setVarvalues(new String[]{""});
		ig500cond.setVarmodes(new String[]{"isNull"});
		//演练实施节点
		ig500cond.setPrstatus("V");
		ig500cond.setPrpdid("01385");
		ig500cond.setOrder("propentime");
		ig500cond.setSing("DESC");
		
		List<IG500Info> ig500InfoList = ig500BL.searchIG500Info(ig500cond);
		dto.setIg500InfoList(ig500InfoList);
		return dto;
	}
	/**
	 * @Description: 全面演练查询
	 * @param dto
	 * @return
	 * @throws BLException    
	 * IGDRM07DTO    
	 * @throws
	 */
	public IGDRM07DTO initIGDRM0701ALLProcessAction(IGDRM07DTO dto)throws BLException{
		IG500SearchCondImpl ig500cond = new IG500SearchCondImpl();
		BeanUtils.copyProperties(dto.getIgdrm0701Form(), ig500cond);
		//查询该流程定义下的所有流程状态
        IG333SearchCondImpl ig333Cond = new IG333SearchCondImpl();
        ig333Cond.setPdid_like(dto.getIgdrm0701Form().getPrpdid());
        List<IG333Info> ig333Infos = workFlowDefinitionBL.searchProcessStatusDef(ig333Cond);
        dto.setiG333InfoList(ig333Infos);
		//全面演练查询
		// 查询件数取得												  
		int totalCount = this.ig500BL.getIG500InfoSearchCount(ig500cond);
	
		if (totalCount == 0)
		{
			log.debug("========查询数据不存在========");
			// 查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
	
		if (totalCount > dto.getMaxSearchCount())
		{
			log.debug("========查询数据件数过多========");
			// 查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}
		PagingDTO pDto = dto.getPagingDto();
		pDto.setTotalCount(totalCount);
		ig500cond.setOrder("propentime");
		ig500cond.setSing("DESC");
		List<IG500Info> ig500InfoList = ig500BL.searchIG500Info(ig500cond, pDto.getFromCount(), pDto.getPageDispCount());
		dto.setIg500InfoList(ig500InfoList);
		return dto;
	}
	
	
	/**
	 * @Description: 演练流程弹出查询页
	 * @param dto
	 * @return
	 * @throws BLException    
	 * IGDRM07DTO    
	 * @throws
	 */
	public IGDRM07DTO searchProcess(IGDRM07DTO dto)throws BLException{
		IG500SearchCondImpl ig500cond = new IG500SearchCondImpl();
		ig500cond.setPrstatus(dto.getPrstatus());
		ig500cond.setPrtype(dto.getPrtype());
		ig500cond.setPrpdid(dto.getPrpdidLike());
		ig500cond.setPrActive("Y");
		ig500cond.setOrder("propentime");
		ig500cond.setSing("DESC");
		List<IG500Info> ig500InfoList = ig500BL.searchIG500Info(ig500cond);
		dto.setIg500InfoList(ig500InfoList);
		return dto;
	}
	
	/**
	 * 获取资产详细信息
	 * 流程中资产表单
	 * 
	 * @param dto    IGDRM07DTO
	 * @return IGDRM07DTO
	 */
	public IGDRM07DTO getEntityFullInfo(IGDRM07DTO dto) throws BLException
	{
		log.debug("========配置详细信息画面初期化处理开始========");
		
		IGDRM0702Form form = dto.getIgdrm0702Form();

		// 设备信息检索
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(Integer.valueOf(form.getSp_eiid()));

		if (entityItemVWInfo == null)
		{
			throw new BLException("IGCO10000.E004", "属性");
		}

		dto.setSoc0124Info(entityItemVWInfo);

		// 配置信息查询件数取得
		SOC0107SearchCondImpl socCond = new SOC0107SearchCondImpl();
		BeanUtils.copyProperties(dto.getIgdrm0702Form(), socCond);
//		int totalCount = this.soc0107BL.getSOC0107SearchCount(socCond);
//		if (totalCount == 0)
//		{
//			log.debug("========查询数据不存在========");
//			// 查询数据不存在
//			dto.addMessage(new ActionMessage("IGCO10000.I007", 0));
//			return dto;
//		}
//
//		if (totalCount > dto.getMaxSearchCount())
//		{
//			log.debug("========查询数据件数过多========");
//			// 查询数据件数过多
//			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
//					.getMaxSearchCount(), totalCount));
//			return dto;
//		}
		// 配置项配置信息全件查询
		SOC0129SearchCondImpl cond = new SOC0129SearchCondImpl();
		cond.setEiid(entityItemVWInfo.getEiid().toString());
		cond.setEsyscoding_q(entityItemVWInfo.getEsyscoding());
		List<SOC0129Info> configItemVWInfoList = this.soc0107BL.searchConfigItemVW(cond, 0, 0);

		Map<String, List<SOC0129Info>> map = new LinkedHashMap<String, List<SOC0129Info>>();
		List<String> strlist = new ArrayList<String>();
		for (SOC0129Info e : configItemVWInfoList)
		{
			if (!map.containsKey(e.getCcategory()))
			{
				map.put(e.getCcategory(), new ArrayList<SOC0129Info>());
				strlist.add(e.getCcategory());
			}
			map.get(e.getCcategory()).add(e);
		}

		dto.setSoc0129InfoVWMap(map);

		log.debug("========配置详细信息初期化处理终了========");
		return dto;

	}

	
	
	/**
	 * 资产项信息查询
	 * 
	 * @param dto
	 *            IGDRM07DTO
	 * @return IGDRM07DTO
	 */
	public IGDRM07DTO searchEntityItem0702Action(IGDRM07DTO dto) throws BLException
	{
		
		log.debug("========资产项HELP查询处理开始========");
		IGDRM0702Form form = dto.getIgdrm0702Form();
		
		//找关联的资产关系eiid
		List<Integer> eiids = new ArrayList<Integer>();
		List<String> eiidstrs = new ArrayList<String>();
		SOC0124SearchCondImpl soc0124cond = new SOC0124SearchCondImpl();
		soc0124cond.setEsyscoding(form.getEsyscoding());
		soc0124cond.setEiname(form.getEiname());
		//场景关联专项预案
		if(dto.getSp_eiid()!=null&&!"".equals(dto.getSp_eiid())){
			if(soc0124cond.getEsyscoding()!=null&&"999060".equals(soc0124cond.getEsyscoding().substring(0, 6))){
				
			SOC0119SearchCondImpl soc0119cond = new SOC0119SearchCondImpl();
			soc0119cond.setPareiid(Integer.parseInt(dto.getSp_eiid()));
			soc0119cond.setDeleteflag("0");
			eiids = soc0119BL.searchCldeiidByPareiid(soc0119cond);
			if(eiids.size()>0){
				for(int i = 0; i<eiids.size();i++){
					eiidstrs.add(eiids.get(i)+"");
				}
				soc0124cond.setEiidList(eiidstrs);
			}else{
				//没有资产关联关系的情况
				eiidstrs.add("999");
				soc0124cond.setEiidList(eiidstrs);
			}
			}
		}
		soc0124cond.setEistatus("ISNULL");
		// 查询件数取得												  
		int totalCount = this.soc0118BL.getEntityItemVWSearchCount(soc0124cond);
	
		if (totalCount == 0)
		{
			log.debug("========查询数据不存在========");
			// 查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
	
		if (totalCount > dto.getMaxSearchCount())
		{
			log.debug("========查询数据件数过多========");
			// 查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}
	
		PagingDTO pDto = dto.getPagingDto();
	
		List<SOC0124Info> entityItemVWInfoList = this.soc0118BL.searchEntityItemVW(soc0124cond, pDto
						.getFromCount(), pDto.getPageDispCount());
		
		if(IGDRMCONSTANTS.SCENE_ESYSCODING.equals(soc0124cond.getEsyscoding())){
			for(SOC0124Info soc0124Info :entityItemVWInfoList){
				SOC0124VW vw = (SOC0124VW)soc0124Info;
				vw.setAote(soc0107BL.searchSOC0107HistoryByEiid(soc0124Info.getEiid(), soc0124Info.getEiversion(), IGDRMCONSTANTS.DRILL_FINISED_FORM_NAME).get(0).getCivalue());
				soc0124Info = vw;
			}
		}
		
	
		pDto.setTotalCount(totalCount);
	
		dto.setSoc0124List(entityItemVWInfoList);
	
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
	
		log.debug("========资产项HELP查询处理终了========");
		return dto;
	}
	
	/**
	 * 关联关系资产项信息查询
	 * 
	 * @param dto
	 *            IGDRM07DTO
	 * @return IGDRM07DTO
	 */
	public IGDRM07DTO searchEntityItemRelation(IGDRM07DTO dto) throws BLException
	{
		
		log.debug("========资产项HELP查询处理开始========");
		//找关联的资产关系eiid
		List<Integer> eiids = new ArrayList<Integer>();
		List<String> eiidstrs = new ArrayList<String>();
		SOC0124SearchCondImpl soc0124cond = new SOC0124SearchCondImpl();
		BeanUtils.copyProperties(dto.getIgdrm0702Form(), soc0124cond);
		//场景关联专项预案
		if(dto.getSp_eiid()!=null&&!"".equals(dto.getSp_eiid())){
			if(soc0124cond.getEsyscoding()!=null&&"999060".equals(soc0124cond.getEsyscoding().substring(0, 6))){
				
				SOC0119SearchCondImpl soc0119cond = new SOC0119SearchCondImpl();
				soc0119cond.setPareiid(Integer.parseInt(dto.getSp_eiid()));
				soc0119cond.setDeleteflag("0");
				eiids = soc0119BL.searchCldeiidByPareiid(soc0119cond);
				if(eiids.size()>0){
					for(int i = 0; i<eiids.size();i++){
						eiidstrs.add(eiids.get(i)+"");
					} 
					soc0124cond.setEiidNotInList(eiidstrs);
				}
			}
		}
		
		// 查询件数取得												  
		int totalCount = this.soc0118BL.getEntityItemVWSearchCount(soc0124cond);
		
		if (totalCount == 0)
		{
			log.debug("========查询数据不存在========");
			// 查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		
		if (totalCount > dto.getMaxSearchCount())
		{
			log.debug("========查询数据件数过多========");
			// 查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto.getMaxSearchCount(), totalCount));
			return dto;
		}
		
		PagingDTO pDto = dto.getPagingDto();
		
		List<SOC0124Info> entityItemVWInfoList = this.soc0118BL.searchEntityItemVW(soc0124cond, pDto
				.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setSoc0124List(entityItemVWInfoList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		
		log.debug("========资产项HELP查询处理终了========");
		return dto;
	}
	
	/**
	 * <p> 查询资产模型名称 </p>
	 * 
	 * @param dto
	 *            IGDRM07DTO
	 * @return IGDRM07DTO
	 * @throws BLException
	 */

	public IGDRM07DTO searchEntityNameActionSOC(IGDRM07DTO dto) throws BLException
	{
		SOC0117SearchCondImpl cond = new SOC0117SearchCondImpl();
		cond.setEsyscoding(dto.getEsyscoding());
		List<SOC0117Info> list = soc0117BL.searchEntity(cond, 0, 0);
		if (list.size() == 1)
		{
			dto.setEname(list.get(0).getEname());
		}
		else
		{
			throw new BLException("IGASM0104.E001", dto.getEsyscoding());
		}
		return dto;
	}
	public IG500BL getIg500BL() {
		return ig500BL;
	}
	public void setIg500BL(IG500BL ig500bl) {
		ig500BL = ig500bl;
	}
	public SOC0117BL getSoc0117BL() {
		return soc0117BL;
	}
	public void setSoc0117BL(SOC0117BL soc0117bl) {
		soc0117BL = soc0117bl;
	}
	public SOC0118BL getSoc0118BL() {
		return soc0118BL;
	}
	public void setSoc0118BL(SOC0118BL soc0118bl) {
		soc0118BL = soc0118bl;
	}

	public SOC0119BL getSoc0119BL() {
		return soc0119BL;
	}

	public void setSoc0119BL(SOC0119BL soc0119bl) {
		soc0119BL = soc0119bl;
	}
	/**
	 * soc0107BL   设定
	 * @param soc0107BL soc0107BL
	 */
	public void setSoc0107BL(SOC0107BL soc0107bl) {
		soc0107BL = soc0107bl;
	}
	/**
	 * @return the 流程定义BL
	 */
	public WorkFlowDefinitionBL getWorkFlowDefinitionBL() {
		return workFlowDefinitionBL;
	}
	/**
	 * @param 流程定义BL the workFlowDefinitionBL to set
	 */
	public void setWorkFlowDefinitionBL(WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}
	
	/**
	 * 资产项信息查询,不分页
	 * 
	 * @param dto
	 *            IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGDRM07DTO searchEntityItemActionNoPage(IGDRM07DTO dto) throws BLException{

		log.debug("========查询指挥流程中的预案，场景信息开始========");
		//找关联的资产关系eiid
		List<Integer> eiids = new ArrayList<Integer>();
		IGDRM0702Form igdrm0702Form = dto.getIgdrm0702Form();

		//场景关联专项预案
		if(dto.getSp_eiid()!=null&&!"".equals(dto.getSp_eiid())){
			if (dto.getEsyscoding() != null && dto.getEsyscoding().startsWith("999060")) {
				if (igdrm0702Form.getPrid() != null && igdrm0702Form.getPrid() > 0) {
					OptionSencesSearchCondImpl cond = new OptionSencesSearchCondImpl();
					cond.setPrid_eq(igdrm0702Form.getPrid());
					List<OptionSencesInfo> optionSences = optionSencesBL.searchOptionSences(cond);
					for (OptionSencesInfo optionSencesInfo : optionSences) {
						eiids.add(optionSencesInfo.getSenceEiid());
					}

				}
				if (eiids == null || eiids.size() == 0) {
					SOC0119SearchCondImpl soc0119cond = new SOC0119SearchCondImpl();
					soc0119cond.setPareiid(Integer.parseInt(dto.getSp_eiid()));
					soc0119cond.setDeleteflag("0");
					// 预案-场景
					soc0119cond.setEirrelation("01");
					eiids = soc0119BL.searchCldeiidByPareiid(soc0119cond);
				}
			}
			// 根据业务系统查询预案
			else if (dto.getEsyscoding() != null && dto.getEsyscoding().startsWith("888001")) {
				SOC0119SearchCondImpl soc0119cond = new SOC0119SearchCondImpl();
				//预案-业务系统
				soc0119cond.setEirrelation("03");
				soc0119cond.setDeleteflag("0");
				String[] speiids = dto.getSp_eiid().split(",");
				List<Integer> cldeiid_id = new ArrayList<Integer>();
				for(String seiid : speiids){
					if(StringUtils.isNotBlank(seiid)){
						cldeiid_id.add(Integer.parseInt(seiid));
					}
				}
				soc0119cond.setCldriid_in(cldeiid_id);
				eiids = this.soc0119BL.searchRelationByEiid_in(soc0119cond);
			}
			
			if(eiids.size()<=0){
				//没有资产关联关系的情况
				eiids.add(999);
			}
		}
		
		SOC0118SearchCondImpl soc0118cond = new SOC0118SearchCondImpl();
		soc0118cond.setEsyscoding_like(dto.getEsyscoding());
		soc0118cond.setEiids(eiids);
		soc0118cond.setEistatus_ne("0");
		soc0118cond.setScenceCategory(igdrm0702Form.getScenceCategory());
		List<SOC0118Info> entityItemInfoList = this.soc0118BL.searchEntityItem(soc0118cond);
		
		dto.setSoc0118InfoList(entityItemInfoList);
		
		log.debug("========查询指挥流程中的预案，场景信息完成========");
		return dto;
	}
	@SuppressWarnings("unchecked")
	public IGDRM07DTO searchProcessDefineUser(IGDRM07DTO dto) throws BLException {
		String eiid = dto.getIgdrm0702Form().getSp_eiid();
		String cid = dto.getIgdrm0702Form().getCid();
		
		if(StringUtils.isNotBlank(cid) && StringUtils.isNotBlank(eiid)){
			//查询场景参与用户信息
			List<Map<String,Object>> list = soc0107BL.searchProcessDefineUserByEiidInfo(cid, Integer.parseInt(eiid));
			//重组数据
			Map<String, Map<String, Object>> dataMap = new LinkedHashMap<String, Map<String,Object>>();
			for(Map<String, Object> map : list){
				//取得节点ID
				String psdid = map.get("PSDID").toString();
				//取得节点名称
				String psdname = map.get("PSDNAME").toString();
				//角色ID
				String roleid = map.get("ROLEID").toString();
				//角色名称
				String rolename = (String) map.get("ROLENAME");
				//用户ID
				String userid = (String) map.get("USERID");
				//用户名
				String username = (String) map.get("USERNAME");
				if(dataMap.get(psdid) == null){
					Map<String, Object> psdMap = new LinkedHashMap<String, Object>();
					psdMap.put("psdid", psdid);
					psdMap.put("psdname", psdname);
					dataMap.put(psdid, psdMap);
				}
				if(dataMap.get(psdid).get("userrole") == null){
					dataMap.get(psdid).put("userrole", new LinkedHashMap<String, Object>());
				}
				
				Map<String, Map<String, Object>> userroleMap = (Map<String, Map<String, Object>>) dataMap.get(psdid).get("userrole");
				if(userroleMap.get(roleid) == null){
					Map<String, Object> roleMap = new LinkedHashMap<String, Object>();
					roleMap.put("roleid", roleid);
					roleMap.put("rolename", rolename);
					roleMap.put("userinfo", new ArrayList<Map<String, String>>());
					userroleMap.put(roleid, roleMap);
				}
				List<Map<String, String>> users = (List<Map<String, String>>) userroleMap.get(roleid).get("userinfo");
				Map<String, String> user = new HashMap<String, String>();
				user.put("userid", userid);
				user.put("username", username);
				users.add(user);
			}
			
			for (Map.Entry<String, Map<String, Object>> entry : dataMap.entrySet()) {
				Map<String, Map<String, Object>> userroleMap2 = (Map<String, Map<String, Object>>) entry.getValue().get("userrole");
				for(String key:userroleMap2.keySet()){
					List<Map<String, String>> userss=(List<Map<String, String>>) userroleMap2.get(key).get("userinfo");
					 Collections.sort(userss, new Comparator<Map<String, String>>() {
				            public int compare(Map<String, String> arg0, Map<String, String> arg1) {
				                return arg0.get("userid").compareTo(arg1.get("userid"));
				            }
				        });
				}
				
			}
			dto.setDataMap(dataMap);
		}
		return dto;
	}
	
	public IGDRM07DTO searchRoleAndUser(IGDRM07DTO dto) throws BLException{
		log.debug("========查询应急组织架构下的人开始=======");
    	
    	StructureRoleSearchCondImpl condStructureRole = new StructureRoleSearchCondImpl();

    	//查询应急组织架构中其中一个层级的角色和人员并且组织数据
    	List<StructureRoleInfo>structureRoleList = structureRoleBL.searchStructureRole(condStructureRole);
    	Map<String,List<UserInfo>> userRoleMap = new HashMap<String,List<UserInfo>>();
    	if(structureRoleList!=null && structureRoleList.size()>0){
    		for(StructureRoleInfo info:structureRoleList){
    			List<UserInfo> userList= userBL.searchUserByRoleId(info.getRoleid());
    			userRoleMap.put(info.getRoleid()+"#"+info.getRolename(), userList);
    		}
    	}
    	//数据组织结束
    	dto.setUserRoleMap(userRoleMap);
		log.debug("========查询应急组织架构下的人完成========");
        return dto;
    }
	
	/**查询演练基本信息*/
	public IGDRM07DTO searchDrillDetail(IGDRM07DTO dto,String flowType) throws BLException{
		log.debug("========演练基本信息开始========");
		IGDRM0710Form form = dto.getIgdrm0710Form();
		dto.setDrillDetailMap(drillplanitemBL.searchDrillDetailByPrid(form.getPrid(),flowType));
		log.debug("========演练基本信息结束========");
		return dto;
	}

	public void setDrillplanitemBL(DrillplanitemBL drillplanitemBL) {
		this.drillplanitemBL = drillplanitemBL;
	}
}
