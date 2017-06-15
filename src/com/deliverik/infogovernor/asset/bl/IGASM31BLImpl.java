package com.deliverik.infogovernor.asset.bl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.asset.EntityCategory;
import com.deliverik.framework.asset.EntityItemKeyWords;
import com.deliverik.framework.asset.model.entity.IG013TB;
import com.deliverik.framework.asset.model.entity.IG225TB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.bl.FileUploadBL;
import com.deliverik.framework.igflow.parameter.EntityItem;
import com.deliverik.framework.igflow.parameter.EntityItemConfigValue;
import com.deliverik.framework.igflow.parameter.EntityItemConfigValueInfo;
import com.deliverik.framework.igflow.parameter.EntityItemInfo;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;
import com.deliverik.framework.soc.asset.bl.task.SOC0107BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0109BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0117BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0119BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0151BL;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.SOC0109Info;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0119Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.framework.soc.asset.model.SOC0151Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0107SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0109SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0117SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0119SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0151SearchCondImpl;
import com.deliverik.framework.soc.asset.model.entity.SOC0107TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0118TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0119TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0129VW;
import com.deliverik.framework.user.bl.task.OrganizationBL;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.condition.OrganizationSearchCondImpl;
import com.deliverik.framework.utility.BLErrorType;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.asset.bl.task.MaintenanceBL;
import com.deliverik.infogovernor.asset.bl.task.RiskIndexContextVWBL;
import com.deliverik.infogovernor.asset.bl.task.RiskIndexSearchVWBL;
import com.deliverik.infogovernor.asset.bl.task.RiskIndexShowVWBL;
import com.deliverik.infogovernor.asset.dto.IGASM31DTO;
import com.deliverik.infogovernor.asset.form.IGASM3101Form;
import com.deliverik.infogovernor.asset.form.IGASM3102Form;
import com.deliverik.infogovernor.asset.form.IGASM3104Form;
import com.deliverik.infogovernor.asset.form.IGASM3107Form;
import com.deliverik.infogovernor.asset.form.IGASM3112Form;
import com.deliverik.infogovernor.asset.form.IGASM3116Form;
import com.deliverik.infogovernor.asset.model.MaintenanceInfo;
import com.deliverik.infogovernor.asset.model.RiskIndexContextVWInfo;
import com.deliverik.infogovernor.asset.model.RiskIndexSearchVWInfo;
import com.deliverik.infogovernor.asset.model.RiskIndexShowVWInfo;
import com.deliverik.infogovernor.asset.model.condition.MaintenanceSearchCondImpl;
import com.deliverik.infogovernor.asset.model.condition.RiskIndexContextVWSearchCondImpl;
import com.deliverik.infogovernor.asset.model.condition.RiskIndexSearchVWSearchCondImpl;
import com.deliverik.infogovernor.asset.model.condition.RiskIndexShowVWSearchCondImpl;
import com.deliverik.infogovernor.asset.model.entity.MaintenanceTB;
import com.deliverik.infogovernor.util.CodeDefine;

/**
 * 检查项配置管理业务逻辑实现
 *
 */
public class IGASM31BLImpl extends BaseBLImpl implements IGASM31BL {

	
	static Log log = LogFactory.getLog(IGASM31BLImpl.class);

	/** 版本号升级标识 */
	public static final String SAVE_VERSION_UP = "1";

	/** 版本号不升级标识 */
	public static final String SAVE_VERSION = "0";
	
	public static final String  EIRRELATIONCODE="'013-001','013-002','013-003','013-006','013-010'";
	
	/**风险sysconding默认值*/
	protected static final String SYSCODE = "999019";	
	
	/** 资产信息BL */
//	protected IG117BL ig117BL;
	protected SOC0117BL soc0117BL;

	
	/** 配置项信息BL */
//	protected IG013BL soc0118BL;
	protected SOC0118BL soc0118BL;
	/** 资产配置项BL */
//	protected IG800BL soc0107BL;
	protected SOC0107BL soc0107BL;
	
	/** 配置项关系BL */
//	protected IG313BL soc0119BL;
	protected SOC0119BL soc0119BL;
	
	/** 文件上传BL */
	protected FileUploadBL fileUploadBL;
	
	/** 资产关联关系下拉数据BL */
	protected CodeDetailBL codeDetailBL;
	
	/** 资产取值范围下拉数据BL */
//	protected IG545BL ig545BL;
	protected SOC0151BL soc0151BL;
	
	/** 机构BL */
	protected OrganizationBL organizationBL;
	
	/**风险指标展示查询条数*/
	protected RiskIndexShowVWBL riskIndexShowVWBL;
	
	protected RiskIndexContextVWBL riskIndexContextVWBL;
	
	/**maintenanceBL*/
	protected MaintenanceBL maintenanceBL;
	
	
	/**
	 * maintenanceBL设定
	 * @param maintenanceBL maintenanceBL
	 */
	public void setMaintenanceBL(MaintenanceBL maintenanceBL) {
		this.maintenanceBL = maintenanceBL;
	}
	/**
	 * riskIndexContextVWBL设定
	 * @param riskIndexContextVWBL riskIndexContextVWBL
	 */
	public void setRiskIndexContextVWBL(RiskIndexContextVWBL riskIndexContextVWBL) {
		this.riskIndexContextVWBL = riskIndexContextVWBL;
	}

	/** 配置项BL */
//	protected IG225BL soc0109BL;
	protected SOC0109BL soc0109BL;
	
	/** 用户角色BL */
	protected UserRoleBL userRoleBL;
	
	
	protected UserBL userBL;
	
	/**风险指标查询*/
	protected RiskIndexSearchVWBL riskIndexSearchVWBL;
	
	/**
	 * @return the userBL
	 */
	public UserBL getUserBL() {
		return userBL;
	}
	/**
	 * @param userBL the userBL to set
	 */
	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
	}
	/**
	 * @return the maintenanceBL
	 */
	public MaintenanceBL getMaintenanceBL() {
		return maintenanceBL;
	}

	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}
	public void setSoc0109BL(SOC0109BL soc0109BL) {
		this.soc0109BL = soc0109BL;
	}
	
	public void setOrganizationBL(OrganizationBL organizationBL) {
		this.organizationBL = organizationBL;
	}
	
	public void setSoc0117BL(SOC0117BL soc0117BL) {
		this.soc0117BL = soc0117BL;
	}
	
	
	public void setRiskIndexSearchVWBL(RiskIndexSearchVWBL riskIndexSearchVWBL) {
		this.riskIndexSearchVWBL = riskIndexSearchVWBL;
	}
	public void setSoc0118BL(SOC0118BL soc0118BL) {
		this.soc0118BL = soc0118BL;
	}

	public void setSoc0107BL(SOC0107BL soc0107BL) {
		this.soc0107BL = soc0107BL;
	}

	public void setSoc0119BL(
			SOC0119BL soc0119BL) {
		this.soc0119BL = soc0119BL;
	}

	public void setFileUploadBL(FileUploadBL fileUploadBL) {
		this.fileUploadBL = fileUploadBL;
	}

	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}
	
	public void setSoc0151BL(
			SOC0151BL soc0151BL) {
		this.soc0151BL = soc0151BL;
	}
	/**
	 * 风险指标展示查询条数设定
	 * @param riskIndexShowVWBL 风险指标展示查询条数
	 */
	public void setRiskIndexShowVWBL(RiskIndexShowVWBL riskIndexShowVWBL) {
		this.riskIndexShowVWBL = riskIndexShowVWBL;
	}

	/**
	 * 风险指标查询处理
	 *
	 * @param dto IGASM31DTO
	 * @return IGASM31DTO
	 */
	public IGASM31DTO searchEntityItemAction(IGASM31DTO dto) throws BLException {

		log.debug("========风险指标查询处理开始========");
		//实例化IGASM3101Form
		IGASM3101Form form = dto.getIGASM3101FORM(); 
		
		RiskIndexSearchVWSearchCondImpl cond  = new RiskIndexSearchVWSearchCondImpl();
		
		//设定查询条件
		cond.setEiid(form.getEiid());//指标名称
		cond.setEiname(form.getEiname());//指标名称
		cond.setEilabel(form.getEilabel());//指标编号
		cond.setIndexused(form.getIndexused());//指标用途
		cond.setZbfz(form.getZbfz());//阀值
		cond.setDutyuser(form.getDutyuser());//指标责任人
		cond.setDutydepartment(form.getDutydepartment());//指标责任部门
		cond.setKeyindex(form.getKeyindex());//是否关键指标
		cond.setMguserid(form.getMguserid());//指标管理人
		cond.setEiStartDate(form.getEiStartDate());//登记日期开始
		cond.setEiEndDate(form.getEiEndDate());//登记日期结束
		cond.setEuStartDate(form.getEuStartDate());//更新日期开始
		cond.setEuEndDate(form.getEuEndDate());//更新日期结束	
		if(StringUtils.isNotEmpty(form.getEiid_NotIn())){
			cond.setEiid_NotIn(form.getEiid_NotIn());
		}
		/**设定风险分类 syscoding码*/
		if(null==form.getEsyscoding()||"".equals(form.getEsyscoding())){
			cond.setSyscoding(SYSCODE);
		}else{
			cond.setSyscoding(form.getEsyscoding());
		}
		//分页用信息取得
		PagingDTO pDto = dto.getPagingDto();
		pDto.getPageDispCount();
		
		//检查项信息查询条数取得 
		int totalCount = this.riskIndexSearchVWBL.searchRiskIndexSearchVW(cond, 0,0).size();
				//this.soc0118BL.getEntityItemVWSearchCount(dto.getEntityItemVWSearchCond());
		
		if (totalCount == 0) {
			log.debug("========风险指标查询数据不存在========");
			//检查项信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========风险指标查询数据件数过多========");
			//检查项信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}


		
		//当前页检查项信息取得
		//List<SOC0124Info> entityItemVWInfoList = this.soc0118BL.searchEntityItemVW(dto.getEntityItemVWSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		List<RiskIndexSearchVWInfo> searchRiskIndexSearchVWList = this.riskIndexSearchVWBL.searchRiskIndexSearchVW(cond, pDto.getFromCount(), pDto.getPageDispCount());
		//返回查询条数
		pDto.setTotalCount(totalCount);
		//返回查询信息
		dto.setSearchRiskIndexSearchVWList(searchRiskIndexSearchVWList);

		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========风险指标查询处理终了========");
		return dto;
	}
	
	/**
	 * 风险指标登记处理
	 * 
	 * @param dto
	 *            IGASM31DTO
	 * @return IGASM31DTO
	 */
	public IGASM31DTO insertEntityItemAction(IGASM31DTO dto) throws BLException {
		log.debug("========风险指标登记处理开始========");
		// 输入Form取得
		IGASM3102Form form = dto.getIgasm3102Form();
		
		/*SOC0118SearchCondImpl soc0118Cond = new SOC0118SearchCondImpl();
		soc0118Cond.setEilabel(CommonDefineUtils.ENTIY_CATEGORY_RISK_TARGET_KEY );
		
		String eilabel = this.soc0118BL.searchNewNextEntityItemLable(soc0118Cond);
		form.setEilabel(eilabel);*/
		//查看数据库中是否有此风险点编号的
		String syscoding = this.soc0118BL.searchEntityESyscoding(form.getEilabel());
		if(StringUtils.isNotEmpty(syscoding)){
			throw new BLException("IGCO10000.E141","此风险指标编号已存在请重新获取");
		}

		/*
		 * //类型ID取得 EntitySearchCondImpl cond = new EntitySearchCondImpl();
		 * cond.setElabel(form.getElabel());
		 * 
		 * //登记处理前的资产信息确认 List<Entity> entityList =
		 * this.ig117BL.searchEntity(cond, 0, 0);
		 * 
		 * if ( entityList == null || entityList.size() ==0 ) { throw new
		 * BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
		 * "IGCO10000.E004","(编号=" + form.getElabel() + ")资产基本"); }
		 * 
		 * Entity entity = entityList.get(0);
		 * 
		 * //********************************************************************
		 * ******* //类型分类检测 if (!entity.getEcategory().equals(CommonDefineUtils.
		 * ENTIY_CATEGORY_RISK_TARGET)) { //检查项以外的情况 throw new
		 * BLException(BLErrorType.ENTITY_CATEGORY_ERROR,
		 * "IGCO10000.E011","检查项"); }
		 * //*****************************************
		 * **********************************
		 * 
		 * form.setEid(entity.getEid());
		 */
		form.setEidStr(form.getEid().toString());

		// 更新时间设定
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

		form.setEiupdtime(datetime);

		// 大版本设定（固定设为0）
		form.setEiversion(0);

		// 小版本设定（固定设为0）
		form.setEismallversion(0);

		// 检查项信息登录
		/*SOC0118Info entityItem = this.soc0118BL.registEntityItem(dto
				.getIgasm3102Form());
*/
	/*	form.setEiidStr(entityItem.getEiid().toString());*/

		dto.setIgasm3102Form(form);

		dto.addMessage(new ActionMessage("IGCO10000.I004", "检查项基本信息"));

		// 风险点指标属性查询条件设定
		SOC0109SearchCondImpl soc0109Cond = new SOC0109SearchCondImpl();
		soc0109Cond.setEid("CM16000000");
		// 检查项属性查询集合
		List<SOC0109Info> soc0109List = soc0109BL.searchConfiguration(soc0109Cond);

		// 创建资产相关对象
		EntityItem entityItem1 = new EntityItem();
		entityItem1.setEidesc(form.getEidesc());
		entityItem1.setEilabel(form.getEilabel());
		entityItem1.setEiname(form.getEiname());
		entityItem1.setEiorgsyscoding(form.getEiorgsyscoding());
		entityItem1.setEiuserid(form.getEiuserid());
		entityItem1.setEiusername(form.getEiusername());
		entityItem1.setEsyscoding(form.getEsyscoding());

		String[] civalue = form.getCivalue();
		//管理员id ([6]是管理员)
		civalue[6] = form.getMguserid();
		// 创建资产属性信息列表
		List<EntityItemConfigValueInfo> configItems = new ArrayList<EntityItemConfigValueInfo>();
		EntityItemConfigValue configItem = null;
		for (int i = 0; i < soc0109List.size(); i++) {
			SOC0109Info info = soc0109List.get(i);
			configItem = new EntityItemConfigValue();
			configItem.setName(info.getCname());
			configItem.setValue(civalue[i]);
			configItem.setFile(null);
			configItems.add(configItem);
		}
		entityItem1.setConfigItems(configItems);
		//添加资产
		Integer eiiddd = createEntityItem(entityItem1);
		dto.setEiid(eiiddd);
		log.debug("========风险指标登记处理终了========");
		return dto;
	}

	/**
	 * 添加资产
	 * 所属机构码不存在时抛异常
	 * 所属模型信息不存在时抛异常
	 * @param entityItem 资产信息
	 * @return 资产ID
	 * @throws BLException
	 */
	public Integer createEntityItem(EntityItemInfo entityItem) 	throws BLException {
		if(entityItem == null) throw new BLException("IGFLOW0000.E001","资产相关信息");
		if(StringUtils.isEmpty(entityItem.getEsyscoding())) throw new BLException("IGFLOW0000.E001","资产所属模型信息");
		if(StringUtils.isEmpty(entityItem.getEiorgsyscoding())) throw new BLException("IGFLOW0000.E001","资产所属机构信息");
		//查询资产所属模型信息
		SOC0117SearchCondImpl entitycond = new SOC0117SearchCondImpl();
		entitycond.setEsyscoding(entityItem.getEsyscoding());
		List<SOC0117Info> entitylist = soc0117BL.searchEntity(entitycond);
		if(entitylist == null || entitylist.isEmpty()){
			throw new BLException("IGFLOW0000.E001","资产所属模型信息");
		}else if(entitylist.size() > 1){
			throw new BLException("IGFLOW0000.E002","资产所属模型信息");
		}
		//封装资产基本信息
		SOC0118TB instance = soc0118BL.getEntityItemTBInstance();
		instance.setEid(entitylist.get(0).getEid().toString());
		instance.setEidesc(entityItem.getEidesc());
		instance.setEiinsdate(IGStringUtils.getCurrentDate());
		instance.setEilabel(entityItem.getEilabel());
		instance.setEiname(entityItem.getEiname());
		instance.setEiorgsyscoding(entityItem.getEiorgsyscoding());
		instance.setEismallversion(0);
		instance.setEistatus(entityItem.getEistatus());
		instance.setEiuserid(entityItem.getEiuserid());
		instance.setEiusername(entityItem.getEiusername());
		instance.setEiversion(0);
		instance.setEsyscoding(entityItem.getEsyscoding());
		instance.setEiupdtime(IGStringUtils.getCurrentDateTime());
		instance.setFingerPrint(entityItem.getFingerPrint());
		SOC0118Info entity = soc0118BL.registEntityItem(instance);
		//增加资产配置信息
		if(entityItem.getConfigItems() != null && entityItem.getConfigItems().size() > 0){
			//查询资产的配置信息
			List<SOC0117Info> parentNodes = soc0117BL.getParentNodes(entity.getEid());
			List<SOC0109Info> configurations = new ArrayList<SOC0109Info>();
			SOC0109SearchCondImpl configcond = new SOC0109SearchCondImpl();
			configcond.setCseq(1);
			for(SOC0117Info e:parentNodes){
				configcond.setEid(e.getEid().toString());
				configurations.addAll(soc0109BL.searchConfiguration(configcond, 0, 0));
			}
			Map<String, EntityItemConfigValueInfo> configItemValueMap = new HashMap<String, EntityItemConfigValueInfo>();
			for(EntityItemConfigValueInfo configItem:entityItem.getConfigItems()){
				configItemValueMap.put(configItem.getName(), configItem);
			}
			for(SOC0109Info configuration:configurations){
				SOC0107TB configItem = new SOC0107TB();
				//设备ID
				configItem.setEiid(entity.getEiid());
				//模型属性ID
				configItem.setCid(configuration.getCid());
				//模型ID
				configItem.setEid(entity.getEid());
				//模型层次码
				configItem.setEsyscoding(entity.getEsyscoding());
				//大版本号
				configItem.setCiversion(1);
				//小版本号
				configItem.setCismallversion(0);
				//更新时间
				configItem.setCiupdtime(entity.getEiupdtime());
				//处理配置项值
				EntityItemConfigValueInfo valueInfo = configItemValueMap.get(configuration.getCname());
				if(valueInfo != null){
					configItem.setCivalue(valueInfo.getValue());
					//附件类属性处理
					if("1".equals(configuration.getCattach())){
						/*String fileName = uploadAssetFormFile(valueInfo.getFile(), entity.getEiid(), 1);
						if(fileName == null && !"".equals(valueInfo.getValue()) ){
							fileName = valueInfo.getValue();
						}
						configItem.setCivalue(fileName);*/
					}
				}
				soc0107BL.registSOC0107(configItem);
			}
			instance = (SOC0118TB) SerializationUtils.clone(entity);
			instance.setEiversion(1);
			soc0118BL.updateEntityItem(instance);
		}
		return entity.getEiid();
	}
	
	
	/**
	 * 检查项信息删除处理
	 *
	 * @param dto IGASM31DTO
	 * @return IGASM31DTO
	 */
	public IGASM31DTO deleteEntityItemAction(IGASM31DTO dto) throws BLException {
		log.debug("========检查项信息删除处理开始========");
		
		for( int i=0;i<dto.getDeleteEntityItem().length;i++ ){
			String eiid = dto.getDeleteEntityItem()[i];
			
			//删除前删除对象检查项确认
			SOC0118Info entityItem = this.soc0118BL.searchEntityItemByKey(Integer.parseInt(eiid));
			
			if (entityItem == null){
				throw new BLException("IGCO10000.E004","删除对象检查项基本");
			}

			//检查项删除
			this.soc0118BL.deleteEntityItem(entityItem);
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I006","检查项信息"));

		log.debug("========检查项信息删除处理终了========");
		return dto;
	}

	/**
	 * 检查项配置信息编辑画面初期化处理
	 *
	 * @param dto IGASM31DTO
	 * @return IGASM31DTO
	 */
	public IGASM31DTO initIGASM3104Action(IGASM31DTO dto) throws BLException {

		log.debug("========检查项配置信息编辑画面初期化处理开始========");
		
		IGASM3104Form form = dto.getIgasm3104Form();
		
		//检查项信息检索
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(
				Integer.parseInt(form.getEiid()));
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","检查项");
		}
		
		form.setEidesc(entityItemVWInfo.getEidesc());
//		form.setEistatus(entityItemVWInfo.getEistatus());
		String eiorgsyscoding = entityItemVWInfo.getEiorgsyscoding();
		form.setEiorgsyscoding(eiorgsyscoding);
		form.setEsyscoding_q(entityItemVWInfo.getEsyscoding());
		if(!StringUtils.isEmpty(eiorgsyscoding)){
			OrganizationSearchCondImpl OrgCond = new OrganizationSearchCondImpl();
			OrgCond.setOrgsyscoding(eiorgsyscoding);
			List<Organization> orgList = this.organizationBL.searchOrganization(OrgCond, 0, 0);
			for (int i = 0; i < orgList.size(); i++) {
				form.setEiorgname(orgList.get(0).getOrgname());
			}
		}
		dto.setEiorgname(form.getEiorgname());
		dto.setEntityItemVWInfo(entityItemVWInfo);
		//判断登陆用户是否有查看该资产配置信息的权限
		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(), entityItemVWInfo);

		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}else{
			dto.setFlag(flag);
		}
		
		
		//检查项配置信息查询件数取得 
		int totalCount = this.soc0107BL.getConfigItemVWSearchCount(form);
		
		if (totalCount == 0) {
			log.debug("========检查项配置信息查询数据不存在========");
			//检查项配置信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I007",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========检查项配置信息查询数据件数过多========");
			//检查项配置信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//检查项配置信息全件查询
		List<SOC0129Info> configItemVWInfoList = this.soc0107BL.searchConfigItemSoc0109VW(
				form, 0, 0);
		
		String[] civalue = new String[totalCount];
		String[] delfile = new String[totalCount];
		String[] entityItemCivalue = new String[totalCount];
		String[] isUpgrade=new String[totalCount];
		//存放旧版本值
		String[] civalue_bak = new String[totalCount];
		Map<String,List<SOC0129Info>> map = new LinkedHashMap<String,List<SOC0129Info>>();
		int i = 0;
		int j = 0;
		List<String> strlist = new ArrayList<String>();
		Map<String, String> cldVersionMap=new HashMap<String, String>();//子资产版本集合
		for(SOC0129Info e : configItemVWInfoList){
			if("4".equals(e.getCattach())){
				String value = e.getCivalue();
				if(StringUtils.isNotEmpty(value)){
					Integer cldeiid = Integer.parseInt(value.substring(value.lastIndexOf("(")+1, value.length()-1));//子资产eiid
					
					SOC0119SearchCondImpl cond=new SOC0119SearchCondImpl();
					cond.setPareiid(Integer.parseInt(form.getEiid()));
					cond.setCldeiid(cldeiid);
					cond.setParversion(entityItemVWInfo.getEiversion());
					cond.setEirinfo("_"+e.getCiid()+"_");
					cond.setDeleteflag("0");
					List<SOC0119Info> ig313Info = soc0119BL.searchEntityItemRelation(cond);
					String cldversion="";
					if(ig313Info!=null&&ig313Info.size()>0){
						cldversion = String.valueOf(ig313Info.get(0).getCldversion());//子资产版本
					}
					cldVersionMap.put(cldeiid.toString(), cldversion);
				}
			}
			if(!map.containsKey(e.getCcategory())){
				map.put(e.getCcategory(), new ArrayList<SOC0129Info>());
				strlist.add(e.getCcategory());
			}
			map.get(e.getCcategory()).add(e);
			if("2".equals(e.getCattach())){
				List<LabelValueBean> list = soc0151BL.searchLabelValueBeanList(e.getCoption());
				form.setSelectedListMap(j++, list);
			}
			if("5".equals(e.getCattach())){
				List<LabelValueBean> list = soc0151BL.searchLabelValueBeanList(e.getCoption());
				if(list.size() > 0){
					list.remove(0);
				}
				form.setSelectedListMap(j++, list);
			}
		}
		form.setCldVersionMap(cldVersionMap);
		for(String str : strlist){
			for(SOC0129Info e : map.get(str)){
				//显示是资产名称，实际存值是资产名称(资产ID)
				if("4".equals(e.getCattach()) && StringUtils.isNotEmpty(e.getCivalue())){
					civalue[i] = e.getCivalue().substring(0, e.getCivalue().lastIndexOf("("));
					isUpgrade[i]= e.getCivalue().substring(e.getCivalue().lastIndexOf("(")+1, e.getCivalue().lastIndexOf(")"));
					entityItemCivalue[i] = e.getCivalue();
				} else {
					civalue[i] = e.getCivalue();
				}
				civalue_bak[i] = e.getCivalue();
				i++;
			}
		}
		if(dto.getUser().getUserid().equals(civalue[6])){
			dto.setIdentyFlag("true");
		}else{
			dto.setIdentyFlag("false");
		}
		//判断管理员id是否存在 ([6]管理员)
		if(("").equals(civalue[6]) || civalue[6]==null){
		}else{
			/**查询管理人姓名*/
			User searchUserByKey = this.userBL.searchUserByKey(civalue[6]);
			dto.setHiddenmguserid(civalue[6]);
			/**设定管理人名字*/
			civalue[6] =searchUserByKey.getUsername();
		}
		form.setCivalue(civalue);
		form.setEntityItemCivalue(entityItemCivalue);
		form.setDelfile(delfile);
		form.setCivalue_bak(civalue_bak);
		form.setIsUpgrade(isUpgrade);
		
		// 替换map中 管理员id为名称([6]管理员)
		for (Entry<String, List<SOC0129Info>> entry : map.entrySet()) {
			//复制指定管理人实体
			SOC0129VW soc0129vw = (SOC0129VW) SerializationUtils
					.clone((Serializable) entry.getValue().get(6));
			/** 查询管理人姓名 */
			User user = this.userBL.searchUserByKey(soc0129vw.getCivalue());
			/** 设定管理人名字 */
			soc0129vw.setCivalue(user.getUsername());
			//将修改的实体赋值给map
			entry.getValue().set(6, soc0129vw);
		}

		
		
		dto.setConfigItemVWInfoMap(map);
//		dto.addMessage(new ActionMessage("IGCO10000.I007",totalCount));

		/**检查项查询条件设定*/
		RiskIndexSearchVWSearchCondImpl riskIndexCond  = new RiskIndexSearchVWSearchCondImpl();
		riskIndexCond.setEiid(form.getEiid());
//		riskIndexCond.set
		riskIndexCond.setSyscoding("999019");
		/**检查项资产版本查询*/
		List<RiskIndexSearchVWInfo> searchRiskIndexSearchVWList = this.riskIndexSearchVWBL.searchRiskIndexSearchVW(riskIndexCond, 0, 0);
		Integer riskIndexLength = Integer.parseInt(searchRiskIndexSearchVWList.get(0).getEiversion());
		Map<Integer,Integer> checkVersionMap = new LinkedHashMap<Integer, Integer>();
		for (i=0;i<riskIndexLength;i++){
			checkVersionMap.put(i,i+1);
		}
		dto.setSearchRiskIndexSearchVWList(searchRiskIndexSearchVWList);
		dto.setCheckVersionMap(checkVersionMap);
		//根据rimid 查询sql
		if(StringUtils.isNotEmpty(form.getEiid())){
			MaintenanceSearchCondImpl maCond = new MaintenanceSearchCondImpl();
			maCond.setRIID(Integer.parseInt(form.getEiid()));
			List<MaintenanceInfo> maintenanceList = maintenanceBL.searchMaintenance(maCond);
			if(null != maintenanceList && maintenanceList.size() > 0){
				for (MaintenanceInfo maInfo : maintenanceList) {
					form.setRimtype(maInfo.getRIMTYPE());
					form.setRimsql(maInfo.getRIMSQL());
					form.setRimdesc(maInfo.getRIMDESC());
				}
			}
		}
		
		log.debug("========检查项配置信息编辑画面初期化处理终了========");
		return dto;
	}
	
	/**
	 * 检查项配置信息编辑处理
	 *
	 * @param dto IGASM31DTO
	 * @return IGASM31DTO
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public IGASM31DTO editEntityItemAction(IGASM31DTO dto) throws BLException, FileNotFoundException, IOException {
		log.debug("========检查项配置信息编辑处理开始========");
		//版本号生成
		IGASM3104Form form = dto.getIgasm3104Form();
		
		//检查项基本信息更新
		SOC0118TB entityItem = (SOC0118TB) this.soc0118BL.searchEntityItemByKey(Integer.parseInt(form.getEiid()));
		// 取得版本是否升级标识
		String ident = form.getIdent();
		if(StringUtils.isEmpty(ident)){
			ident = IGASM31BLImpl.SAVE_VERSION;
		}
		// 版本号初始化
		int version = 1;
		boolean versonFlag = false;
		// 判断是否升级版本号
		// =====================>> 修改 start
		if (IGASM31BLImpl.SAVE_VERSION_UP.equals(ident)) { // 升级版本号
			version = form.getEiversion() + 1;
			
			//增加是否关系升级复选框，判断哪个资产关系升级
			String[] cldeiids=new String[form.getCiid().length];
			int index=0;
			if(form.getIsUpgrade()!=null&&form.getIsUpgrade().length>0){
                for(int i=0;i<form.getIsUpgrade().length;i++){
                    if(form.getIsUpgrade()[i]!=null&&"1".equals(form.getIsUpgrade()[i])){
                        if(form.getEntityItemCivalue()[i].lastIndexOf("(") != -1 && form.getEntityItemCivalue()[i].lastIndexOf(")") != -1){
                            String cldeiid=form.getEntityItemCivalue()[i].substring(form.getEntityItemCivalue()[i].lastIndexOf("(")+1,
                                    form.getEntityItemCivalue()[i].lastIndexOf(")"));
                            //子资产基本信息
                            IG013TB cldEntityItem = (IG013TB) this.soc0118BL.searchEntityItemByKey(Integer.parseInt(cldeiid));
                            if(cldEntityItem!=null){
                            	 cldeiids[index]=cldeiid+"_"+cldEntityItem.getEiversion()+"_"+cldEntityItem.getEismallversion()+"_"+form.getCiid()[i];
                            }
                        }
                        index++;
                    }
                }
            }
			
			//资产关系信息版本升级处理
			this.soc0119BL.upgradeEntityItemRelationOne(entityItem.getEiid(), entityItem.getEiversion(), entityItem.getEismallversion(),
					version, 0,cldeiids);
			
			if (version - 1 != entityItem.getEiversion()) {
				throw new BLException("IGCO00000.E004");
			}
		} else if (IGASM31BLImpl.SAVE_VERSION.equals(ident)) { // 不升级版本号

			version = form.getEiversion();
			if (version != entityItem.getEiversion()) {
				throw new BLException("IGCO00000.E004");
			}

			if (form.getEiversion() == 0) { // 如果为第一版时设定版本号为 “1”
				versonFlag = true;
				version = 1;
			}
		}
		//  << =================  end
		
		//检查项状态
//		entityItem.setEistatus(form.getEistatus());
		//检查项版本
		entityItem.setEiversion(version);
		
		//检查项说明
		entityItem.setEidesc(form.getEidesc());

		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		
		//更新时间
		entityItem.setEiupdtime(datetime);
		
		this.soc0118BL.updateEntityItem(entityItem);
		//=======更新关系开始========
		if(version ==1&&versonFlag){
			SOC0119SearchCondImpl eircond1 = new SOC0119SearchCondImpl();
			//删除标识
			eircond1.setDeleteflag("0");
			//与该资产相关的关系码
			eircond1.setEirrelationcode(IGASM31BLImpl.EIRRELATIONCODE);
			eircond1.setEiid(String.valueOf(entityItem.getEiid()));
			//该资产现有的关系信息
			List<SOC0119Info> ig313InfoList = this.soc0119BL.searchMaxEntityItemRelation(eircond1);
			if(ig313InfoList!=null&&ig313InfoList.size()>0){
				for(SOC0119Info ig313Info:ig313InfoList){
					SOC0119TB ig313tb=new SOC0119TB();
					ig313tb.setPareiid(ig313Info.getPareiid());
					ig313tb.setPareid(ig313Info.getPareid());
					ig313tb.setParsmallversion(ig313Info.getParsmallversion());
					ig313tb.setParversion(ig313Info.getParversion());
					ig313tb.setCldeiid(ig313Info.getCldeiid());
					ig313tb.setCldeid(ig313Info.getCldeid());
					ig313tb.setCldsmallversion(ig313Info.getCldsmallversion());
					ig313tb.setCldversion(ig313Info.getCldversion());
					ig313tb.setEirdesc(ig313Info.getEirdesc());
					ig313tb.setEirinfo(ig313Info.getEirinfo());
					ig313tb.setEirrelation(ig313Info.getEirrelation());
					ig313tb.setEirrelationcode(ig313Info.getEirrelationcode());
					ig313tb.setDeleteflag(ig313Info.getDeleteflag());
					ig313tb.setEirstatus(ig313Info.getEirstatus());
					ig313tb.setEirupdtime(ig313Info.getEirupdtime());
					ig313tb.setFingerPrint(ig313tb.getFingerPrint());
					//正向关系时
					if(entityItem.getEiid().equals(ig313Info.getPareiid())){
						ig313tb.setParversion(entityItem.getEiversion());
						this.soc0119BL.registEntityItemRelation(ig313tb);
					}
					//方向关系时
					if(entityItem.getEiid().equals(ig313Info.getCldeiid())){
						ig313tb.setCldversion(entityItem.getEiversion());
						this.soc0119BL.registEntityItemRelation(ig313tb);
					}
				}
			}
		}
		//=======更新关系结束========
		
		//调用更新BL
		
		//检查项配置信息更新
		if (form.getCiid() != null && form.getCiid().length > 0 ) {
			
			for( int i=0 ; i < form.getCiid().length; i++ ){
				SOC0107TB configItem = new SOC0107TB();
				//检查项ID
				configItem.setEiid(Integer.parseInt(form.getEiid()));
				//资产配置ID
				configItem.setCid(form.getCid()[i]);
				//类型ID
				configItem.setEid(form.getEid()[i]);
				//类型层次码
				configItem.setEsyscoding(form.getEsyscoding()[i]);
				//内容
				configItem.setCivalue(form.getCivalue()[i]);
				//大版本号
				configItem.setCiversion(version);
				//小版本号
				configItem.setCismallversion(0);
				//更新时间
				configItem.setCiupdtime(datetime);
				
				//显示是资产名称，实际存值是资产名称(资产ID)
				if("4".equals(form.getCiattach()[i]) && StringUtils.isNotEmpty(form.getEntityItemCivalue()[i])){
					configItem.setCivalue(form.getEntityItemCivalue()[i]);
				}
				
				//附件删除
				if("1".equals(form.getCiattach()[i]) && "1".equals(form.getDelfile()[i])){
					configItem.setCivalue("");
				}
				
				if (StringUtils.isEmpty(form.getCiid()[i])) {
					//更新标识
					if(StringUtils.isEmpty(configItem.getCivalue())) {
						configItem.setCicurver("0");
					} else {
						configItem.setCicurver("1");
					}
					configItem = (SOC0107TB) this.soc0107BL.registSOC0107(configItem);
					//属性类别为资产时，增加关联关系
					if("4".equals(form.getCiattach()[i]) && StringUtils.isNotEmpty(form.getCivalue()[i])){
						SOC0119TB e = new SOC0119TB();
						e.setPareid(entityItem.getEid());
						e.setPareiid(entityItem.getEiid());
						e.setParversion(entityItem.getEiversion());
						e.setParsmallversion(entityItem.getEismallversion());
						String str = form.getEntityItemCivalue()[i];
						SOC0118Info ei = this.soc0118BL.searchEntityItemByKey(Integer.parseInt(str.substring(str.lastIndexOf("(")+1, str.length()-1)));
						e.setCldeid(ei.getEid());
						e.setCldeiid(ei.getEiid());
						e.setCldversion(ei.getEiversion());
						e.setCldsmallversion(ei.getEismallversion());
						//双向
						String relationcode = entityItem.getEsyscoding().substring(3, 6)+"-"+ei.getEsyscoding().substring(3, 6);	
						boolean flag = true ;
						CodeDetailSearchCondImpl condimpl = new CodeDetailSearchCondImpl();
						condimpl.setBusinesscode_like(relationcode);
						List<CodeDetail> cd = codeDetailBL.searchCodeDetail(condimpl, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
						if ( cd.size()==1){
							flag = false;
							e.setEirrelation(cd.get(0).getCid());
							e.setEirrelationcode(cd.get(0).getBusinesscode());
						}
						if(flag){
							condimpl.setBusinesscode_like(ei.getEsyscoding().substring(3, 6)+"-"+entityItem.getEsyscoding().substring(3, 6));
							cd = codeDetailBL.searchCodeDetail(condimpl, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
							if ( cd.size()!=1){
								throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
										"IGCO10000.E017");
							}else{
								e.setEirrelation(cd.get(0).getCid());
								e.setEirrelationcode(cd.get(0).getBusinesscode());
								flag = false;
							}
						}
						if (flag){
							throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
									"IGCO10000.E017");
						}
						e.setEirupdtime(datetime);
						//查询属性名称
						SOC0109Info config = this.soc0109BL.searchConfigurationByKey(form.getCid()[i]);
						String cname = config.getCname();
						e.setEirdesc("由配置项："+cname+"建立");
						//增加key
						e.setEirinfo(entityItem.getEiid()+"_"+configItem.getCiid()+"_"+ei.getEiid());
						//设置状态为C，关系管理中不可删除
						e.setEirstatus("C");
						this.soc0119BL.registEntityItemRelation(e);
					}
					log.debug("资产配置项：[资产配置ID:" + form.getCid()[i] + "]插入处理成功。");
					
				} else {
					//更新标识默认为0
					configItem.setCicurver("0");
					if ("4".equals(form.getCiattach()[i])){
						if(!form.getCivalue_bak()[i].equals(configItem.getCivalue())){
							//更新资产属性标识
							configItem.setCicurver("1");
						}
					} else if(!form.getCivalue_bak()[i].equals(configItem.getCivalue())){
						//更新属性标识
						configItem.setCicurver("1");
					}
					
					// 判断是否升级版本号
					if (IGASM31BLImpl.SAVE_VERSION_UP.equals(ident)) { // 升级版本号

						configItem = (SOC0107TB) this.soc0107BL.registSOC0107(configItem);

					} else if (IGASM31BLImpl.SAVE_VERSION.equals(ident)) { // 不升级版本号
					
						Integer ciid = Integer.valueOf(form.getCiid()[i]); 
						
						// 查询当前配置项
						SOC0107Info cfi = this.soc0107BL.searchSOC0107ByKey(ciid);
						
						// 判断当前配置项是否是新增的
						if(configItem.getCid().equals(cfi.getCid())){ // 不是新增配置项进行更新
							
							configItem.setCiid(ciid);
							configItem = (SOC0107TB) this.soc0107BL
								.updateSOC0107(configItem);
							
						}else{  // 新增配置项进行新增
							
							configItem = (SOC0107TB) this.soc0107BL
							.registSOC0107(configItem);
							
						}
					}
					
					//属性类别为资产时，增加关联关系
					if("4".equals(form.getCiattach()[i]) && StringUtils.isNotEmpty(form.getCivalue()[i])){
						SOC0119TB e = new SOC0119TB();
						e.setPareid(entityItem.getEid());
						e.setPareiid(entityItem.getEiid());
						e.setParversion(entityItem.getEiversion());
						e.setParsmallversion(entityItem.getEismallversion());
						String str = form.getEntityItemCivalue()[i];			
						SOC0118Info ei = this.soc0118BL.searchEntityItemByKey(Integer.parseInt(str.substring(str.lastIndexOf("(")+1, str.length()-1)));
				
						e.setCldeid(ei.getEid());
						e.setCldeiid(ei.getEiid());
						e.setCldversion(ei.getEiversion());
						e.setCldsmallversion(ei.getEismallversion());
						//校验关系是否存在
						SOC0119SearchCondImpl condPar = new SOC0119SearchCondImpl();
						condPar.setPareiid(entityItem.getEiid());//资产ID
						condPar.setParversion(entityItem.getEiversion());//资产大版本
						condPar.setParsmallversion(entityItem.getEismallversion());//资产小版本
						condPar.setDeleteflag("0");
						condPar.setEirstatus("C");
						condPar.setEirinfo(entityItem.getEiid()+"_"+form.getCiid()[i]+"_"+ei.getEiid());
						
						List<SOC0119Info> eirlist = this.soc0119BL.searchEntityItemRelation(condPar);
						
						if(eirlist.isEmpty()){
							//删除原来已有的关系
							SOC0119SearchCondImpl eircond = new SOC0119SearchCondImpl();
							eircond.setEirinfo(entityItem.getEiid()+"_"+form.getCiid()[i]+"_");
							eircond.setEirstatus("C");
							eircond.setDeleteflag("0");
							List<SOC0119Info> eir = this.soc0119BL.searchMaxEntityItemRelation(eircond);
							for (SOC0119Info entityItemRelation : eir) {
								this.soc0119BL.deleteEntityItemRelation(entityItemRelation);
							}
							//双向
							String relationcode = entityItem.getEsyscoding().substring(3, 6)+"-"+ei.getEsyscoding().substring(3, 6);	
							boolean flag = true ;
							CodeDetailSearchCondImpl condimpl = new CodeDetailSearchCondImpl();
							condimpl.setBusinesscode_like(relationcode);
							List<CodeDetail> cd = codeDetailBL.searchCodeDetail(condimpl, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
							if ( cd.size()==1){
								flag = false;
								e.setEirrelation(cd.get(0).getCid());
								e.setEirrelationcode(cd.get(0).getBusinesscode());
							}
							if(flag){
								condimpl.setBusinesscode_like(ei.getEsyscoding().substring(3, 6)+"-"+entityItem.getEsyscoding().substring(3, 6));
								cd = codeDetailBL.searchCodeDetail(condimpl, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
								if ( cd.size()!=1){
									throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
											"IGCO10000.E017");
								}else{
									e.setEirrelation(cd.get(0).getCid());
									e.setEirrelationcode(cd.get(0).getBusinesscode());
									flag = false;
								}
							}
							if (flag){
								throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
										"IGCO10000.E017");
							}
							e.setEirupdtime(datetime);
							//查询属性名称
							SOC0109Info config = this.soc0109BL.searchConfigurationByKey(form.getCid()[i]);
							String cname = config.getCname();
							e.setEirdesc("由配置项："+cname+"建立");
							//增加key
							e.setEirinfo(entityItem.getEiid()+"_"+configItem.getCiid()+"_"+ei.getEiid());
							//设置状态为C，关系管理中不可删除
							e.setEirstatus("C");
							this.soc0119BL.registEntityItemRelation(e);
						} else {
							if(eirlist.size() != 1) {
								throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR, "IGCO10000.E017");
							} else {
								SOC0119TB eirTB = (SOC0119TB)SerializationUtils.clone(eirlist.get(0));
								
								eirTB.setEirinfo(eirTB.getEirinfo().replaceAll("_" + form.getCiid()[i] + "_", "_" + configItem.getCiid() + "_"));
								
								this.soc0119BL.updateEntityItemRelation(eirTB);
							}
						}
					}
					
					if("4".equals(form.getCiattach()[i]) && StringUtils.isEmpty(form.getCivalue()[i])){
						//删除原来已有的关系
						SOC0119SearchCondImpl eircond = new SOC0119SearchCondImpl();
						eircond.setEirinfo(entityItem.getEiid()+"_"+form.getCiid()[i]+"_");
						eircond.setEirstatus("C");
						eircond.setDeleteflag("0");
						List<SOC0119Info> eir = this.soc0119BL.searchMaxEntityItemRelation(eircond);
						for (SOC0119Info entityItemRelation : eir) {
							this.soc0119BL.deleteEntityItemRelation(entityItemRelation);
						}
					}
					log.debug("资产配置项：[资产配置ID:" + form.getCid()[i] + "]更新处理成功。");
				}
				
				//上传文件检测
				if (form.getCiattach()[i].toUpperCase().equals("1")) {
					FormFile file = form.getAttachFile(i);
					if ( file != null && file.getFileSize() > 0) {
						//上传文件存在的情况
						//上传文件路径
						String rootPath = ResourceUtility.getString("UPLOAD_FILE_ROOT_PATH");
						StringBuffer pathBuf = new StringBuffer();
						
						//根目录
						pathBuf.append(rootPath);
						//机能ID
						pathBuf.append("asm"+File.separator);
						//检查项ID
						pathBuf.append(configItem.getEiid());
						pathBuf.append(File.separator);
						
						StringBuffer fileName = new StringBuffer();
						
						//扩展名取得
						String fileType = "";
						String sFileName = file.getFileName();
						int point = sFileName.lastIndexOf(".");
						if (point != -1) {
							fileType = sFileName.substring(point);
							fileName.append(sFileName.substring(0, point));
						}
						
						//文件名后加版本号
						fileName.append("_");
						fileName.append(configItem.getCiversion());
						//文件扩展名
						fileName.append(fileType);

						//文件上传处理
						this.fileUploadBL.saveFile(file, pathBuf.toString(), fileName.toString());
						
						//上传文件名保存
						configItem.setCivalue(fileName.toString());
						
						//更新属性标识
						configItem.setCicurver("1");
						
						this.soc0107BL.updateSOC0107(configItem);					
						
					}
				}
			}
			
		}
	
		dto.addMessage(new ActionMessage("IGCO10000.I005","检查项配置信息"));
		
		log.debug("========检查项配置信息编辑处理终了========");
		
		return dto;
	}

	/**
	 * 检查项配置信息历史记录画面初期化处理
	 *
	 * @param dto IGASM31DTO
	 * @return IGASM31DTO
	 */
	public IGASM31DTO initIGASM3105Action(IGASM31DTO dto) throws BLException {
		log.debug("========检查项配置信息历史记录画面初期化处理开始========");
		
		//检查项信息检索
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(
				dto.getIgasm3105Form().getEiid());
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","检查项");
		}
		String eiorgsyscoding = entityItemVWInfo.getEiorgsyscoding();
		if(!StringUtils.isEmpty(eiorgsyscoding)){
			OrganizationSearchCondImpl OrgCond = new OrganizationSearchCondImpl();
			OrgCond.setOrgsyscoding(eiorgsyscoding);
			List<Organization> orgList = this.organizationBL.searchOrganization(OrgCond, 0, 0);
			for (int i = 0; i < orgList.size(); i++) {
				dto.setEiorgname(orgList.get(0).getOrgname());
			}
		}
		if (entityItemVWInfo.getEiversion() == 0 && entityItemVWInfo.getEismallversion() == 0) {
			dto.addMessage(new ActionMessage("IGASM0205.W001"));
		}
		
		dto.setEntityItemVWInfo(entityItemVWInfo);
		
		if (StringUtils.isEmpty(dto.getIgasm3105Form().getCiversion()+"")) {
			dto.getIgasm3105Form().setCiversion(String.valueOf(entityItemVWInfo.getEiversion()));
		}
		//获取历史版本更新时间
		dto.setConfigItemVersionTime(this.soc0118BL.searchVersionUpdateTime(dto.getIgasm3105Form().getEiid()));
		
		//判断登陆用户是否有查看该资产配置信息的权限
		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(), entityItemVWInfo);

		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}else{
			dto.setFlag(flag);
		}
		
		log.debug("========检查项配置信息历史记录画面初期化处理终了========");
		return dto;
	}

	/**
	 * 检查项关系管理画面初期化处理
	 *
	 * @param dto IGASM31DTO
	 * @return IGASM31DTO
	 */
	public IGASM31DTO initIGASM3106Action(IGASM31DTO dto) throws BLException {
		log.debug("========检查项关系管理画面初期化处理开始========");
		
		//检查项信息检索
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(
				Integer.parseInt(dto.getIgasm3106Form().getEiid()));
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","检查项");
		}
		String eiorgsyscoding = entityItemVWInfo.getEiorgsyscoding();
		if(!StringUtils.isEmpty(eiorgsyscoding)){
			OrganizationSearchCondImpl OrgCond = new OrganizationSearchCondImpl();
			OrgCond.setOrgsyscoding(eiorgsyscoding);
			List<Organization> orgList = this.organizationBL.searchOrganization(OrgCond, 0, 0);
			for (int i = 0; i < orgList.size(); i++) {
				dto.setEiorgname(orgList.get(0).getOrgname());
			}
		}
		dto.setEntityItemVWInfo(entityItemVWInfo);
		
		Map<String,List<SOC0119Info>> parmap = new LinkedHashMap<String,List<SOC0119Info>>();
		//正向关联关系检索
		SOC0119SearchCondImpl parcond = new SOC0119SearchCondImpl();
		if((dto.getIgasm3106Form().getEiid())!=null)
		{parcond.setPareiid(Integer.parseInt(dto.getIgasm3106Form().getEiid()));}
		parcond.setParversion(entityItemVWInfo.getEiversion());
		parcond.setParsmallversion(entityItemVWInfo.getEismallversion());
		parcond.setDeleteflag("0");
		//判断登陆用户是否有查看该资产配置信息的权限
		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(), entityItemVWInfo);

		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}else{
			dto.setFlag(flag);
		}
		//检查项关系信息查询件数取得 
		int totalCount = this.soc0119BL.getEntityItemRelationSearchCount(parcond);
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========检查项关系信息查询数据件数过多========");
			//检查项关系信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		if ( totalCount>0 ) {
			//检查项关系信息全件检索
			//设备关系信息全件检索
			List<SOC0119Info> parEntityItemRelationList = 
				this.soc0119BL.searchEntityItemRelation(parcond);
			dto.setParCount(parEntityItemRelationList.size());
			for(SOC0119Info e : parEntityItemRelationList){
				String key = e.getEirrelationcode().split("-")[0];
				String eirrelationcode = e.getEirrelationcode();
				String ecategory = e.getParEntityItemVW().getEcategory();
				if(!"-".equals(eirrelationcode.replaceAll(ecategory, ""))){
					key = eirrelationcode.replaceAll(ecategory, "").replaceAll("-", "");
				}
					if(!parmap.containsKey(key)){
						parmap.put(key, new ArrayList<SOC0119Info>());
					}
					((SOC0119TB)e).setParflag("0");
					parmap.get(key).add(e);
				}
		}
		
		//逆向关联关系检索
		//关联关系检索
//		SOC0119SearchCondImpl cldcond = new SOC0119SearchCondImpl();
//		
//		cldcond.setCldeiid(dto.getIgasm3106Form().getEiid());
//		cldcond.setCldversion(entityItemVWInfo.getEiversion().toString());
//		cldcond.setCldsmallversion(entityItemVWInfo.getEismallversion().toString());
//		cldcond.setDeleteflag("0");
//		
//		//检查项关系信息查询件数取得 
//		totalCount = this.soc0119BL.getEntityItemRelationSearchCount(cldcond);
//		
//		if ( totalCount > dto.getMaxSearchCount() ) {
//			log.debug("========检查项关系信息查询数据件数过多========");
//			//检查项关系信息查询数据件数过多
//			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
//			return dto;
//		}
//
//		//检查项关系信息全件检索
//		List<SOC0119Info> cldEntityItemRelationList = 
//			this.soc0119BL.searchMaxEntityItemRelation(cldcond);
		
		dto.setParCount(dto.getParCount());
//		dto.addMessage(new ActionMessage("IGCO10000.I007",dto.getParCount()));
//		for(SOC0119Info e : cldEntityItemRelationList){
//			String key = e.getEirrelationcode().split("-")[0];
//			String eirrelationcode = e.getEirrelationcode();
//			String ecategory = e.getCldEntityItemVW().getEcategory();
//			if(!"-".equals(eirrelationcode.replaceAll(ecategory, ""))){
//				key = eirrelationcode.replaceAll(ecategory, "").replaceAll("-", "");
//			}
//			if(!parmap.containsKey(key)){
//				parmap.put(key, new ArrayList<SOC0119Info>());
//			}
//			((SOC0119TB)e).setParflag("1");
//			parmap.get(key).add(e);
//		}
		if(parmap.size()==0){
			parmap = null;
		}
		dto.setParEntityItemRelationMap(parmap);

		log.debug("========检查项关系管理画面初期化处理终了========");
		return dto;
	}
	
	/**
	 * 检查项关系删除处理
	 *
	 * @param dto IGASM31DTO
	 * @return IGASM31DTO
	 */
	public IGASM31DTO deleteEntityItemRelationAction(IGASM31DTO dto) throws BLException {
		log.debug("========检查项关系删除处理开始========");
		
		for( int i=0;i<dto.getDeleteEntityItemRelation().length;i++ ){
			String eirid = dto.getDeleteEntityItemRelation()[i];
			
			SOC0119Info entityItemRelation = 
				this.soc0119BL.searchEntityItemRelationByKey(Integer.parseInt(eirid));
			
			if (entityItemRelation == null){
				throw new BLException("IGCO10000.E004","删除对象检查项关系");
			}

			this.soc0119BL.deleteEntityItemRelation(entityItemRelation);
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I006","检查项关系信息"));

		log.debug("========检查项关系删除处理终了========");
		return dto;
	}

	/**
	 * 检查项关系登记处理
	 *
	 * @param dto IGASM31DTO
	 * @return IGASM31DTO
	 */
	public IGASM31DTO insertEntityItemRelationAction(IGASM31DTO dto) throws BLException {
		log.debug("========检查项关系登记处理开始========");
		
		IGASM3107Form form = dto.getIgasm3107Form();
		
		//检查项ID（子）取得
		SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
		
		cond.setElabel(form.getElabel());
		cond.setEilabel(form.getEilabel());
		
		List<SOC0124Info> entityItemVWList = this.soc0118BL.searchEntityItemVW(cond, 0, 0);
		
		if ( entityItemVWList==null || entityItemVWList.size() == 0 ) {
			throw new BLException("IGCO10000.E004","(资产编号=" + form.getElabel() + ",检查项编号=" 
					+ form.getEilabel() + ")检查项");
		}
		
		form.setCldeiid(entityItemVWList.get(0).getEiid());
		form.setCldeid(entityItemVWList.get(0).getEid());
		form.setCldsmallversion(entityItemVWList.get(0).getEismallversion());
		form.setCldversion(entityItemVWList.get(0).getEiversion());
		
		//检查项ID（父）和（子）检测
		if (form.getPareiid().intValue() == form.getCldeiid().intValue()) {
			//检查项ID（父）= （子）
			throw new BLException(BLErrorType.ENTITY_ITEM_RELATION_ERROR,
					"IGCO10000.E012","检查项");
		}
		
		//更新时间设定
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

		form.setEirupdtime(datetime);
		
		//资产关系登记
		SOC0119Info ret = 
			this.soc0119BL.registEntityItemRelation(dto.getIgasm3107Form());
		
		dto.setEntityItemRelation(ret);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "检查项关系信息") );
		
		log.debug("========检查项关系登记处理终了========");
		return dto;
	}
	
	/**
	 * 检查项关系编辑画面初期化处理
	 *
	 * @param dto IGASM31DTO
	 * @return IGASM31DTO
	 */
	public IGASM31DTO initIGASM3107Action(IGASM31DTO dto) throws BLException {
		log.debug("========检查项关系编辑画面初期化处理开始========");
		
		IGASM3107Form form = dto.getIgasm3107Form();
		SOC0119TB ret = 		
			(SOC0119TB) this.soc0119BL.searchEntityItemRelationByKey(
				form.getEirid());
		
		if ( ret == null ){
			throw new BLException("IGCO10000.E004","编辑对象检查项关系");
		}
		
		//检索结果设定
		form.setPareiname(ret.getParEntityItemVW().getEiname());
		form.setPareid(ret.getPareid());
		form.setPareiid(ret.getPareiid());
		form.setCldeid(ret.getCldeid());
		form.setCldeiid(ret.getCldeiid());
		form.setEiridStr(ret.getEirid().toString());
		form.setEirdesc(ret.getEirdesc());
		form.setEirinfo(ret.getEirinfo());
		form.setEirrelation(ret.getEirrelation());
		form.setEirrelationcode(ret.getEirrelationcode());
		form.setElabel(ret.getCldEntityItemVW().getElabel());
		form.setEilabel(ret.getCldEntityItemVW().getEilabel());
		form.setTempeirrelation(ret.getEirrelation()+"#"+ret.getEirrelationcode());
		form.setEiname(ret.getCldEntityItemVW().getEiname());
		form.setMode("1");
		
		log.debug("========检查项关系编辑画面初期化处理终了========");
		return dto;
	}

	/**
	 * 检查项关系变更处理处理
	 *
	 * @param dto IGASM31DTO
	 * @return IGASM31DTO
	 */
	public IGASM31DTO updateEntityItemRelationAction(IGASM31DTO dto) throws BLException {
		log.debug("========检查项关系变更处理处理开始========");
		IGASM3107Form form = dto.getIgasm3107Form();

		//更新时间设定
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

		form.setEirupdtime(datetime);
		
		this.soc0119BL.updateEntityItemRelation(form);

		dto.addMessage(new ActionMessage( "IGCO10000.I005", "检查项关系信息") );

		log.debug("========检查项关系变更处理处理终了========");
		return dto;
	}
	
	/**
	 *	获取检查项关联关系处理
	 *
	 * @param dto IGASM31DTO
	 * @return IGASM31DTO
	 */
	public IGASM31DTO searchRelationListAction(IGASM31DTO dto) throws BLException {
		log.debug("========获取检查项关联关系处理开始========");
		List<LabelValueBean> list = this.codeDetailBL.searchLabelValueBeanList(CommonDefineUtils.ENTIY_CATEGORY_RISK_TARGET,CodeDefine.getCodeDefine("ENTITY_ITEM_RELATION_CODE").getCcid());
		dto.setRelationList(list);
		log.debug("========获取检查项关联关系处理终了========");
		return dto;
	}
	

	/**
	 *检查项信息修改初期显示处理
	 *
	 * @param dto IGASM31DTO
	 * @return IGASM31DTO
	 */
	public IGASM31DTO initEntityItem(IGASM31DTO dto) throws BLException {

		log.debug("========检查项信息编辑画面初期显示处理开始========");
		
		IGASM3112Form form = dto.getIgasm3112Form();
		
		//显示用资产信息取得
		SOC0124Info entityItem = this.soc0118BL.searchEntityItemVWByKey(form.getEiid());
		
		if ( entityItem == null ){
			throw new BLException("IGCO10000.E004","变更检查项基本");
		}
		
		//画面显示设定
		
		String orgsyscoding = entityItem.getEiorgsyscoding();
		String esyscoding = entityItem.getEsyscoding();
		SOC0117SearchCondImpl EntityCond = new SOC0117SearchCondImpl();
		EntityCond.setEsyscoding(esyscoding);
		List<SOC0117Info> entityList = this.soc0117BL.searchEntity(EntityCond, 0, 0);
		for (int i = 0; i < entityList.size(); i++) {
			form.setEname(entityList.get(0).getEname());
		}
		OrganizationSearchCondImpl OrgCond = new OrganizationSearchCondImpl();
		OrgCond.setOrgsyscoding(orgsyscoding);
		List<Organization> orgList = this.organizationBL.searchOrganization(OrgCond, 0, 0);
		for (int i = 0; i < orgList.size(); i++) {
			form.setEiorgname(orgList.get(0).getOrgname());
		}
		form.setEiorgsyscoding(orgsyscoding);
		form.setEiid(entityItem.getEiid());
		form.setEid(entityItem.getEid());
		form.setEistatus(entityItem.getEistatus());
		form.setEiupdtime(entityItem.getEiupdtime());
		form.setEiversion(entityItem.getEiversion());
		form.setEsyscoding(entityItem.getEsyscoding());
		form.setEilabel(entityItem.getEilabel());
		form.setEiname(entityItem.getEiname());
		form.setEiinsdate(entityItem.getEiinsdate());
		form.setEidesc(entityItem.getEidesc());
		form.setEilabelbak(entityItem.getEilabel());
		form.setEiuserid(entityItem.getEiuserid());
		form.setEiusername(entityItem.getEiusername());
		
		//判断登陆用户是否有查看该资产配置信息的权限
		boolean permission = this.soc0118BL.checkEntityItemDomain(dto.getUser(), entityItem);
		boolean isRoleManager = this.userRoleBL.checkRoleManagerByType(dto.getUser().getUserid(), EntityCategory.ROLE_TYPE_DOCUMENT);
		form.setRoleManager(isRoleManager);
		form.setPermission(permission);
		
		dto.setIgasm3112Form(form);
		
		//dto.addMessage(new ActionMessage("IGCO10000.I001","检查项基本信息"));
		if(!permission) {
			dto.addMessage(new ActionMessage("IGCO10000.E023","修改"));
		}
		log.debug("========检查项信息编辑画面初期显示处理终了========");
		return dto;
	}
	/**
	 *检查项信息修改处理
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM31DTO updateEntityItem(IGASM31DTO dto) throws BLException {
		
		log.debug("========检查项信息编辑画面初期显示处理开始========");
		
		IGASM3112Form form = dto.getIgasm3112Form();
		if(!form.getEilabel().equals(form.getEilabelbak())){
			this.soc0118BL.checkNotExistEntityItem(form.getEilabel());
		}
		
		SOC0118Info entityItem = this.soc0118BL.searchEntityItemByKey(form.getEiid());
		
		//找configitem中完全匹配的civalue
		//与该资产存在关系的名称同步修改
		//正常全匹配
		SOC0107SearchCondImpl cicond = new SOC0107SearchCondImpl();
		cicond.setCivalue(entityItem.getEiname()+"("+ form.getEiid() +")");
		
		List<SOC0107Info> configItemlist = this.soc0107BL.searchSOC0107(cicond, 0, 0);
		if(!configItemlist.isEmpty()){
			for(int i = 0; i < configItemlist.size(); i++){
				SOC0107TB ciTB = (SOC0107TB)SerializationUtils.clone(configItemlist.get(i));
				ciTB.setCivalue(form.getEiname() + "(" + form.getEiid() + ")");
				this.soc0107BL.updateSOC0107(ciTB);
			}
		}
			
		
		
		//EntityItemRelation中取得有关系的资产列表
		SOC0119SearchCondImpl ercond = new SOC0119SearchCondImpl();
		ercond.setCldeiid(entityItem.getEiid());
//		ercond.setCldeid(String.valueOf(entityItem.getEid()));
		List<SOC0119Info> erlist = this.soc0119BL.searchEntityItemRelation(ercond);
		
		if(!erlist.isEmpty()){
			
			//服务记录
			//Configuration中取得资产相关资产的cid
			SOC0109SearchCondImpl ccond = new SOC0109SearchCondImpl();
			//资产ID的cid
			ccond.setClabel(EntityItemKeyWords.ENTITY_DEFAULT_DEVICE_EIID);
			List<SOC0109Info> clist1 = this.soc0109BL.searchConfiguration(ccond);
			IG225TB cTB1 = (IG225TB)SerializationUtils.clone(clist1.get(0));
			//资产名称的cid
			ccond.setClabel(EntityItemKeyWords.ENTITY_DEFAULT_DEVICE_ENAME);
			List<SOC0109Info> clist2 = this.soc0109BL.searchConfiguration(ccond);
			IG225TB cTB2 = (IG225TB)SerializationUtils.clone(clist2.get(0));
			
			cicond.setCivalue(null);
			for(int j = 0; j < erlist.size(); j++){
				//服务记录
				//资产ID
				SOC0119TB erTB = (SOC0119TB)SerializationUtils.clone(erlist.get(j));
				cicond.setEiid(String.valueOf(erTB.getPareiid()));
				cicond.setCid(String.valueOf(cTB1.getCid()));
				List<SOC0107Info> cilist1 = this.soc0107BL.searchSOC0107(cicond);
				//如果关系了其他资产civalue中有资产ID的值,则查下一条中的资产名称
				if(!cilist1.isEmpty()){
					SOC0107TB ciTB1 = (SOC0107TB)SerializationUtils.clone(cilist1.get(0));
					cicond.setCid(String.valueOf(cTB2.getCid()));
					List<SOC0107Info> cilist2 = this.soc0107BL.searchSOC0107(cicond);
					SOC0107TB ciTB2 = (SOC0107TB)SerializationUtils.clone(cilist2.get(0));
					//将civalue中值按<br />拆开
					String[] id = ciTB1.getCivalue().split("<br />");
					String[] name = ciTB2.getCivalue().split("<br />");
					StringBuffer bf = new StringBuffer();
					for(int n = 0; n < id.length; n++){
						if(id[n].equals(String.valueOf(entityItem.getEiid()))){
							name[n] = form.getEiname();
						}
						//换成修改后的资产名称，再拼上
						bf.append(name[n] + "<br />");
					}
					ciTB2.setCivalue(bf.toString());
					this.soc0107BL.updateSOC0107(ciTB2);
				}
			}
		}
	
		this.soc0118BL.updateEntityItem(form);
		dto.addMessage(new ActionMessage("IGCO10000.I005","检查项基本信息"));
		log.debug("========检查项信息编辑画面初期显示处理终了========");
		return dto;
	}
	
	/**
	 * 获取检查项编号最大值
	 *
	 * @param dto IGASM31DTO
	 * @return IGASM31DTO
	 */
	public IGASM31DTO searchEntityItemLableAction(IGASM31DTO dto) throws BLException {
		
		log.debug("========获取检查项编号最大值处理开始========");
		
		IGASM3102Form form = dto.getIgasm3102Form();
		//风险指标属性查询条件设定
		SOC0109SearchCondImpl soc0109Cond = new SOC0109SearchCondImpl();
		soc0109Cond.setEid("CM16000000");
		//检查项属性查询集合
		List<SOC0109Info> soc0109List = soc0109BL.searchConfiguration(soc0109Cond);
		
		/*SOC0118SearchCondImpl cond = new SOC0118SearchCondImpl();
		
		cond.setEilabel(CommonDefineUtils.ENTIY_CATEGORY_RISK_TARGET_KEY);
		
		String eilabel = this.soc0118BL.searchNewNextEntityItemLable(cond);
		
		form.setEilabel(eilabel);*/
		dto.setSoc0109List(soc0109List);
		log.debug("========获取检查项编号最大值处理终了========");
		return dto;
	}
	
	/**
	 * 判断登陆用户是否是检查项资产管理角色负责人
	 * 
	 * @param dto IGASM31DTO
	 * @return IGASM31DTO
	 * @throws BLException 
	 */
	public IGASM31DTO checkEntityItemDomain(IGASM31DTO dto) throws BLException{
		boolean isRoleManager = this.userRoleBL.checkRoleManagerByType(dto.getUser().getUserid(), EntityCategory.ROLE_TYPE_DOCUMENT);
		
		if(isRoleManager) {
			OrganizationSearchCondImpl orgCond = new OrganizationSearchCondImpl();
			orgCond.setOrgpar("0001");
			List<Organization> org = this.organizationBL.searchOrganization(orgCond);
			
			if(org.size() != 1) {
				throw new BLException("IGCO10000.E004","顶级机构");
			} else {
				dto.setOrgname(org.get(0).getOrgname());
				dto.setOrgsyscoding(org.get(0).getOrgsyscoding());
			}
			SOC0117SearchCondImpl entityCond = new SOC0117SearchCondImpl();
			entityCond.setEsyscoding(CommonDefineUtils.ENTIY_CATEGORY_RISK_TARGET_SYSCODING);
			List<SOC0117Info> entity = this.soc0117BL.searchEntity(entityCond, 0, 0);
			
			if(entity.size() != 1) {
				throw new BLException("IGCO10000.E004","检查项模型");
			} else {
				dto.setEname(entity.get(0).getEname());
				dto.setEsyscoding(entity.get(0).getEsyscoding());
			}
		}
		
		dto.setFlag(isRoleManager);
		
		return dto;
	}
	
	/**
	 * 获取风险点指标所需下拉值
	 *
	 * @param dto IGASM31DTO
	 * @return IGASM31DTO
	 */
	public IGASM31DTO searchRiskPropertyActioin(IGASM31DTO dto)	throws BLException{
		
		/**风险指标登记--指标模板下拉*/
		SOC0151SearchCondImpl titCond=new SOC0151SearchCondImpl();
		/**设定查询条件*/
		titCond.setCcdtype("A");
		titCond.setCcdcategory("151");
		titCond.setCcdstatus("1");
		List<SOC0151Info> titList = soc0151BL.searchConfigurationCodeDetail(titCond);
		
		/**风险指标登记--是否关键指标下拉*/
		SOC0151SearchCondImpl keyIndexCond = new SOC0151SearchCondImpl();
		/**设定查询条件*/
		keyIndexCond.setCcdtype("A");
		keyIndexCond.setCcdcategory("150");
		keyIndexCond.setCcdstatus("1");
		List<SOC0151Info> keyIndexList = soc0151BL.searchConfigurationCodeDetail(keyIndexCond);
		
		/**风险指标登记--阀值下拉*/
		SOC0151SearchCondImpl thresholdCond = new SOC0151SearchCondImpl();
		/**设定查询条件*/
		thresholdCond.setCcdtype("A");
		thresholdCond.setCcdcategory("141");
		thresholdCond.setCcdstatus("1");
		List<SOC0151Info> thresholdList = soc0151BL.searchConfigurationCodeDetail(thresholdCond);
		
		/**条件设定*/
		dto.setThresholdList(thresholdList);
		dto.setTitList(titList);;
		dto.setKeyIndexList(keyIndexList);
		return dto;
	}
	public IGASM31DTO insertMaintenance(IGASM31DTO dto) throws BLException {
		
		MaintenanceTB info = new MaintenanceTB();
		MaintenanceSearchCondImpl cond =  new MaintenanceSearchCondImpl();
		cond.setRIID(dto.getRiid());
		List<MaintenanceInfo> maList = maintenanceBL.searchMaintenance(cond);
		if(maList!=null){
			for (MaintenanceInfo ma : maList) {
				info = (MaintenanceTB)SerializationUtils.clone(ma);
			}
		}
		
		info.setRIID(dto.getRiid());
//		info.setRIMSQL(dto.getRimsql());
		info.setFingerPrint(dto.getFingerprint());
		info.setRIMTYPE(dto.getRimtype());
		info.setRIMDESC(dto.getRimdesc());
		if(dto.getRimtype()!=null &&(!dto.getRimtype().equals("")) ){
			List<Integer> list = (List<Integer>) this.maintenanceBL.saveOrUpdateMaintenance(info);
			
			if(list.size()>0){
				MaintenanceInfo info2 = this.maintenanceBL.searchMaintenanceByPK(list.get(0));
				
				info.setRIID(info2.getRIID());
				info.setRIMID(info2.getRIMID());
				
				this.maintenanceBL.updateMaintenance(info);
			}else{
				this.maintenanceBL.registMaintenance(info);
			}
		}
		

		return dto; 
	}
	/**
	 * 风险展示内容查询 
	 */
	public IGASM31DTO searchRiskIndexContext(IGASM31DTO dto) throws BLException {
		
		//form取得
		IGASM3116Form form = dto.getIgasm3116form();
		//设定查询条件
		RiskIndexContextVWSearchCondImpl cond = new RiskIndexContextVWSearchCondImpl();
		cond.setEsyscoding(form.getEsyscoding());
		List<RiskIndexContextVWInfo> searchRiskIndexContextVW = this.riskIndexContextVWBL.searchRiskIndexContextVW(cond, 0, 0);
		
		dto.setSearchRiskIndexContextVW(searchRiskIndexContextVW);
		return dto;
	}

	/**
	 * <p>
	 * Description: 风险指标展示数据查询
	 * </p>
	 * 
	 * @param dto IGASM31DTO
	 * @return IGASM31DTO
	 * @throws BLException
	 * @author wanglei@deliverik.com
	 * @update
	 */
	public IGASM31DTO searchRiskIndexByRiid(IGASM31DTO dto) throws BLException {
		//form取得
		IGASM3116Form form = dto.getIgasm3116form();
		//设定查询条件
		RiskIndexContextVWSearchCondImpl cond = new RiskIndexContextVWSearchCondImpl();
		cond.setEsyscoding(form.getEsyscoding());
		//风险展示集合查询 根据分类
		List<RiskIndexContextVWInfo> searchRiskIndexContextVW = this.riskIndexContextVWBL.searchRiskIndexContextVW(cond, 0, 0);
		dto.setSearchRiskIndexContextVW(searchRiskIndexContextVW);
		//根据rimid 查询sql
		MaintenanceInfo searchMaintenanceByPK = maintenanceBL.searchMaintenanceByPK(Integer.parseInt(form.getRimid()));
		
		//风险指标维护实体
		MaintenanceTB tb = (MaintenanceTB)SerializationUtils.clone(searchMaintenanceByPK);
		String type = searchMaintenanceByPK.getRIMTYPE();
		//查询的时间
		String searchTime = "";
		if("2".equals(type)){// 饼图查询的时间为年月
			searchTime = form.getYear()+"/"+form.getMonth();
		}else{				// 其他查询为年
			searchTime = form.getYear();
		}
		MaintenanceSearchCondImpl maCond = new MaintenanceSearchCondImpl();
		maCond.setSearchSQL(tb.getRIMSQL());
		maCond.setSearchTime(searchTime);
		List<Object> objList = maintenanceBL.SearchBySQL(maCond);
		StringBuffer xml = new StringBuffer();
		String dataXml = "";
		if("1".equals(type)){		// 柱图
			xml.append("<chart palette='2' chartLeftMargin='1' canvasTopMargin='1' chartBottomMargin='1' caption='' xAxisName='' yAxisName='' showValues='0' decimals='0' formatNumberScale='0' useRoundEdges='1'>");
		}else if("2".equals(type)){// 饼图
			xml.append("<chart palette='4' decimals='0' enableSmartLabels='1' enableRotation='0' bgColor='99CCFF,FFFFFF' bgAlpha='40,100' bgRatio='0,100' bgAngle='360' showBorder='1' startingAngle='70'>");
		}else if("3".equals(type)){// 线图
			xml.append("<chart showValues='0' alternateHGridColor='FCB541' alternateHGridAlpha='20' divLineColor='FCB541' divLineAlpha='50' canvasBorderColor='666666' baseFontColor='666666' lineColor='FCB541'>");
		}
		for (Object obj : objList) {
			Object[] object = (Object[])obj;
			xml.append("<set label='"+object[0]+"' value='"+object[1]+"' /> ");
		}
		xml.append("</chart>");
		form.setRIMSQL(tb.getRIMSQL());
		form.setRIMDESC(tb.getRIMDESC());
		form.setRIMTYPE(tb.getRIMTYPE());
		boolean showFlag = true;
		dataXml=xml.toString();
		if(showFlag){
			form.setAsmxml(dataXml);
		}else{
			form.setAsmxml("");
		}
		log.debug("================统计结束=================");
		return null;
	}
	/**
	 * 风险指标展示信息查询
	 * 
	 * @param dto IGASM31DTO
	 * @return IGASM31DTO
	 * @throws BLException 
	 */
	public IGASM31DTO searchRiskIndexShow(IGASM31DTO dto) throws BLException {
		//风险展示查询条件设定
		RiskIndexShowVWSearchCondImpl cond = new RiskIndexShowVWSearchCondImpl();
		//风险展示查询集合
		List<RiskIndexShowVWInfo> riskIndexShowList = riskIndexShowVWBL.searchRiskIndexShowVW(cond, 0, 0);
		//set
		dto.setRiskIndexShowList(riskIndexShowList);
		return dto;
	}
	/**	
	 * 功能：查风险指标基本信息
	 * @param dto
	 * @return
	 * @throws BLException
	 * 修改记录：null
	 */	
	public IGASM31DTO initIGASM3116Action(IGASM31DTO dto) throws BLException {
		IGASM3116Form form = dto.getIgasm3116form();
		/**检查项查询条件设定*/
		RiskIndexSearchVWSearchCondImpl riskIndexCond  = new RiskIndexSearchVWSearchCondImpl();
		riskIndexCond.setEiid(form.getEiid());
		riskIndexCond.setSyscoding("999019");
		/**检查项资产版本查询*/
		List<RiskIndexSearchVWInfo> searchRiskIndexSearchVWList = this.riskIndexSearchVWBL.searchRiskIndexSearchVW(riskIndexCond, 0, 0);
		dto.setSearchRiskIndexSearchVWList(searchRiskIndexSearchVWList);
		return dto;
	}
	
}
