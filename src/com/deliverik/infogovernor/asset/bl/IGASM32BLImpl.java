package com.deliverik.infogovernor.asset.bl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.bl.FileUploadBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.soc.asset.bl.task.SOC0107BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0109BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0117BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0119BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0151BL;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.entity.SOC0107TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0118TB;
import com.deliverik.framework.user.bl.task.OrganizationBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.infogovernor.asset.bl.task.RiskcaseVWBL;
import com.deliverik.infogovernor.asset.dto.IGASM32DTO;
import com.deliverik.infogovernor.asset.form.IGASM3202Form;
import com.deliverik.infogovernor.asset.model.RiskcaseVWInfo;
import com.deliverik.infogovernor.asset.model.condition.RiskcaseVWSearchCondImpl;

/**
 * 文档配置管理业务逻辑实现
 *
 */
public class IGASM32BLImpl extends BaseBLImpl implements IGASM32BL {

	static Log log = LogFactory.getLog(IGASM32BLImpl.class);

	/** 版本号升级标识 */
	public static final String SAVE_VERSION_UP = "1";

	/** 版本号不升级标识 */
	public static final String SAVE_VERSION = "0";
	
	public static final String  EIRRELATIONCODE="'013-001','013-002','013-003','013-006','013-010'";
	
	/** 资产信息BL */
//	protected IG117BL ig117BL;
	protected SOC0117BL soc0117BL;

	/** 配置项信息BL */
//	protected IG013BL soc0118BL;
	protected SOC0118BL soc0118BL;
	// TODO
	/** 资产配置项BL */
//	protected IG800BL soc0107BL;
	protected SOC0107BL soc0107BL;
	
	/** 更新类API */
	protected FlowSetBL flowSetBL;
	
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
	
	/** 配置项BL */
//	protected IG225BL soc0109BL;
	protected SOC0109BL soc0109BL;
	
	/** 用户角色BL */
	protected UserRoleBL userRoleBL;
	
	/** 风险事件BL */
	protected RiskcaseVWBL riskcaseVWBL;

	public void setRiskcaseVWBL(RiskcaseVWBL riskcaseVWBL) {
		this.riskcaseVWBL = riskcaseVWBL;
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

	/**
	 * @param flowSetBL the flowSetBL to set
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
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
	 * 风险事件登记处理
	 *
	 * @param dto IGASM32DTO
	 * @return IGASM32DTO
	 */
	public IGASM32DTO insertEntityItemAction(IGASM32DTO dto) throws BLException {
		log.debug("========风险事件登记处理开始========");
		IGASM3202Form form = dto.getIgasm3202Form();
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "风险事件基本信息") );

		//创建资产相关对象并附默认值
		SOC0118TB entityItem = new SOC0118TB();
		entityItem.setEiuserid(form.getEiuserid());
		entityItem.setEiusername(form.getEiusername());
		entityItem.setEid(IGASMBL11Type.RISK_CASE_EID);
		entityItem.setEsyscoding(IGASMBL11Type.RISK_CASE_ESYSCODING);
		entityItem.setEiname(form.getFcname());
		entityItem.setEidesc(form.getFcdesc());
		entityItem.setEiversion(1);
		entityItem.setEismallversion(0);
		entityItem.setEistatus("1");
		entityItem.setEiinsdate(IGStringUtils.getCurrentDate());
		dto.setEntityItem(entityItem);
		SOC0118Info entityInfo = soc0118BL.registRiskCase(entityItem);
		
		//创建资产风险关系数据
		if(form.getRiskid()!=null && form.getRiskjobid()!=null && !(form.getRiskjobid().equals("")) && !(form.getRiskid().equals(""))){
			Integer riskjobid = Integer.parseInt(form.getRiskjobid());
			Integer riskid = Integer.parseInt(form.getRiskid());
			flowSetBL.setProcessEntityRelation(riskjobid , "相关风险事件",riskid, entityInfo.getEiid());
		}
		
		dto.setEntityInfo(entityInfo);
		//添加资产
		createEntityItem(dto);
		log.debug("========风险事件登记处理终了========");
		return dto;
	}
	
	/**
	 * 添加资产
	 * @param entityItem 资产信息
	 * @return 资产ID
	 * @throws BLException
	 */
	public void createEntityItem(IGASM32DTO dto) 	throws BLException {
		SOC0118Info entityInfo = dto.getEntityInfo();
		IGASM3202Form form = dto.getIgasm3202Form();
		
		dto.setEiid(entityInfo.getEiid());
		
		/** 风险事件名称 */
		createConfigItem(IGASMBL11Type.FCNAME,form.getFcname(),dto);
		/** 风险事件描述 */
		createConfigItem(IGASMBL11Type.FCDESC,form.getFcdesc(),dto);
		/** 风险事件来源 */
		createConfigItem(IGASMBL11Type.FCORIGIN,form.getFcorigin(),dto);
		/** 风险事件所属领域 */
		createConfigItem(IGASMBL11Type.FCCATEGORY,form.getFccategory(),dto);
		/** 相关评估工作ID */
		createConfigItem(IGASMBL11Type.RISKJOBID,form.getRiskjobid(),dto);
		/** 风险点ID */
		createConfigItem(IGASMBL11Type.RISKID,form.getRiskid(),dto);
		/** 风险点分类ID */
		createConfigItem(IGASMBL11Type.RISKTYPE,form.getRisktype(),dto);
		/** 风险严重级别名称 */
		createConfigItem(IGASMBL11Type.FCSEVERITYLEVEL,form.getFcseveritylevel(),dto);
		/** 风险发生可能性名称 */
		createConfigItem(IGASMBL11Type.FCPOSSIBILITY,form.getFcpossibility(),dto);
		/** 风险级别名称 */
		createConfigItem(IGASMBL11Type.FCLEVEL,form.getFclevel(),dto);
		/** 风险识别时间 */
		createConfigItem(IGASMBL11Type.RISKCATCHTIME,form.getRiskcatchtime(),dto);
		/** 应对任务名称 */
		createConfigItem(IGASMBL11Type.FCRISKTASK,form.getFcrisktask(),dto);
		/** 应对任务描述 */
		createConfigItem(IGASMBL11Type.FCRISKTASKDESC,form.getFcrisktaskdesc(),dto);
		/** 应对策略 */
		createConfigItem(IGASMBL11Type.FCPOLICY,form.getFcpolicy(),dto);
		/** 应对目标 */
		createConfigItem(IGASMBL11Type.FCOPERATORAIM,form.getFcoperatoraim(),dto);
		/** 应对部门ID */
		createConfigItem(IGASMBL11Type.RISKOPERATORDEPT,form.getRiskoperatordept(),dto);
		/** 应对负责人ID */
		createConfigItem(IGASMBL11Type.RISKOPERATOR,form.getRiskoperator(),dto);
		/** 抄送风控人员ID */
		createConfigItem(IGASMBL11Type.RISKCCOPERATOR,form.getRiskccoperator(),dto);
		/** 评审结果 */
		createConfigItem(IGASMBL11Type.RISKREVIEWRESULT,form.getRiskreviewresult(),dto);
		/** 问题整改工作ID */
		createConfigItem(IGASMBL11Type.RISKDEALID,form.getRiskdealid(),dto);
	}
	
	/**
	 * 添加资产属性
	 * cid-资产表cid、civalue-资产表civalue、IGASM32DTO
	 * @throws BLException
	 */
	public void createConfigItem(String cid,String civalue,IGASM32DTO dto) throws BLException {
		//增加资产配置信息
		SOC0118Info entityItem = dto.getEntityInfo();
		SOC0107TB configItem = new SOC0107TB();
		//模型ID
		configItem.setEid(entityItem.getEid());
		//设备ID
		configItem.setEiid(dto.getEiid());
		//模型属性ID
		configItem.setCid(cid);
		//模型值
		configItem.setCivalue(civalue);
		//更新时间
		configItem.setCiupdtime(entityItem.getEiinsdate());
		//模型层次码
		configItem.setEsyscoding(entityItem.getEsyscoding());
		//大版本号
		configItem.setCiversion(entityItem.getEiversion());
		//小版本号
		configItem.setCismallversion(0);
		
		//资产属性登记入库
		soc0107BL.registSOC0107(configItem);
	}
	
	/**
	 * 风险事件查询处理
	 *
	 * @param dto IGASM32DTO
	 * @return IGASM32DTO
	 */
	public IGASM32DTO searchEntityItemAction(IGASM32DTO dto) throws BLException {

		log.debug("========风险事件查询处理开始========");
		RiskcaseVWSearchCondImpl cond = dto.getRiskcaseVWSearchCond();
		//文档信息查询件数取得 
		int totalCount = this.riskcaseVWBL.getSearchCount(cond);
		
		if (totalCount == 0) {
			log.debug("=======风险事件信息查询数据不存在========");
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========风险事件查询数据件数过多========");
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//分页用信息取得
		PagingDTO pDto = dto.getPagingDto();

		List<RiskcaseVWInfo> entityItemVWInfoList = this.riskcaseVWBL.searchRiskcaseVW(dto.getRiskcaseVWSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		dto.setRiskcaseVWList(entityItemVWInfoList);
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========风险事件查询处理终了========");
		return dto;
	}
	
	/**
	 * 风险事件历史版本查询处理
	 *
	 * @param dto IGASM32DTO
	 * @return IGASM32DTO
	 */
	public IGASM32DTO searchEntityItemByVersion(IGASM32DTO dto) throws BLException{
		List<RiskcaseVWInfo> entityItemVWInfoList = this.riskcaseVWBL.searchRiskcaseByVersion(dto.getRiskcaseVWSearchCond());
		dto.setRiskcaseVWList(entityItemVWInfoList);
		return dto;
	}
	
	/**
	 * 风险事件应对策略
	 *
	 * @param dto IGASM32DTO
	 * @return IGASM32DTO
	 */
	public IGASM32DTO searchRiskPolicyAction(IGASM32DTO dto) throws BLException{
		RiskcaseVWSearchCondImpl cond = new RiskcaseVWSearchCondImpl ();
		cond.setEiid(dto.getEiid());
		List<RiskcaseVWInfo> entityItemVWInfoList = this.riskcaseVWBL.searchRiskcaseVW(cond);
		if(entityItemVWInfoList!=null && entityItemVWInfoList.size()>0){
			for(int num = 0; num<entityItemVWInfoList.size(); num++){
				if(num == 0){
					dto.setRiskPolicy(entityItemVWInfoList.get(num).getFcpolicy());
				}else{
					if(entityItemVWInfoList.get(num).getFcpolicy()!=null 
					&& !entityItemVWInfoList.get(num).getFcpolicy().equals(entityItemVWInfoList.get(num-1).getFcpolicy()))
					{//本版本值与上一版本值不同
						dto.setRiskPolicy(dto.getRiskPolicy()+"->"+entityItemVWInfoList.get(num).getFcpolicy());
					}
					
				}
			}
		}
		return dto;
	}
	
	/**
	 *风险事件修改处理
	 *
	 * @param dto IGASM32DTO
	 * @return IGASM32DTO
	 */
	public IGASM32DTO updateEntityItem(IGASM32DTO dto) throws BLException {
		
		log.debug("========风险事件信息编辑画面初期显示处理开始========");
		IGASM3202Form form = dto.getIgasm3202Form();
		SOC0118TB entityItem = (SOC0118TB) this.soc0118BL.searchEntityItemByKey(form.getEiid());

		entityItem.setEiname(form.getFcname());
		entityItem.setEidesc(form.getFcdesc());
		entityItem.setEiversion(entityItem.getEiversion()+1);
		entityItem.setEismallversion(0);
		entityItem.setEistatus(form.getEistatus());
		entityItem.setEiupdtime(IGStringUtils.getCurrentDate());
		
		SOC0118Info entityInfo = this.soc0118BL.updateEntityItem(entityItem);
		dto.setEntityInfo(entityInfo);
		//添加资产
		createEntityItem(dto);
		dto.addMessage(new ActionMessage("IGCO10000.I005","风险事件信息"));
		log.debug("========风险事件信息编辑画面初期显示处理终了========");
		return dto;
	}
}
