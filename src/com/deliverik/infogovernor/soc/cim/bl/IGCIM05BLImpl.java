package com.deliverik.infogovernor.soc.cim.bl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.MessageResources;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.bl.FileUploadBL;
import com.deliverik.framework.soc.asset.EiDomainKeyWords;
import com.deliverik.framework.soc.asset.EiRelationKeyWords;
import com.deliverik.framework.soc.asset.EntityCategory;
import com.deliverik.framework.soc.asset.bl.task.SOC0107BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0109BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0110BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0111BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0112BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0117BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0119BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0126BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0151BL;
import com.deliverik.framework.soc.asset.model.SOC0111Info;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0117SearchCondImpl;
import com.deliverik.framework.user.bl.task.OrganizationBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.condition.OrganizationSearchCondImpl;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.infogovernor.soc.bl.task.CR01BL;
import com.deliverik.infogovernor.soc.bl.task.CR03BL;
import com.deliverik.infogovernor.soc.bl.task.SocRelationBL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM05DTO;

/**
 * 设备配置管理业务逻辑实现
 *
 */
public class IGCIM05BLImpl extends BaseBLImpl implements IGCIM05BL {

	static Log log = LogFactory.getLog(IGCIM05BLImpl.class);
	
	public static final String DEVICE_DEVICE = "001-001";
	
	public static final String DEVICE_DEVICE_CONN_ID = "1";
	/** 资产信息BL */
	protected SOC0117BL soc0117BL;

	/** 配置项信息BL */
	protected SOC0118BL soc0118BL;
	
	/** 资产配置项BL */
	protected SOC0107BL soc0107BL;
	
	/** 配置项关系BL */
	protected SOC0119BL soc0119BL;
	
	/** 文件上传BL */
	protected FileUploadBL fileUploadBL;
	
	/** 资产取值范围下拉数据BL */
	protected SOC0151BL soc0151BL;
	
	/** 资产关联关系下拉数据BL */
	protected CodeDetailBL codeDetailBL;
	
	/** 机构BL */
	protected OrganizationBL organizationBL;
	
	/** 配置项BL */
	protected SOC0109BL soc0109BL;
	
	/** 用户角色BL */
	protected UserRoleBL userRoleBL;
	
	/** SOC关系表BL */
	protected SocRelationBL socRelationBL;

	protected MessageResources resources = MessageResources.getMessageResources("com.deliverik.infogovernor.soc.cim.asmResources"); 
	
	/** 依赖关系表BL */
	protected SOC0110BL soc0110BL;
	
	/** 最大版本域明细BL */
	protected SOC0126BL soc0126BL;
	
	/** 域明细BL */
	protected SOC0112BL soc0112BL;
	
	/** 域定义信息BL */
	protected SOC0111BL soc0111BL;
	
	/** 配置元数据版本信息BL */
	protected CR03BL cr03BL;
	
	/** 采集结果BL */
	protected CR01BL cr01BL;
	
	public void setSoc0117BL(SOC0117BL soc0117BL) {
		this.soc0117BL = soc0117BL;
	}


	public void setSoc0118BL(SOC0118BL soc0118BL) {
		this.soc0118BL = soc0118BL;
	}


	public void setSoc0107BL(SOC0107BL soc0107BL) {
		this.soc0107BL = soc0107BL;
	}


	public void setSoc0119BL(SOC0119BL soc0119BL) {
		this.soc0119BL = soc0119BL;
	}


	public void setSoc0109BL(SOC0109BL soc0109BL) {
		this.soc0109BL = soc0109BL;
	}


	public void setSoc0110BL(SOC0110BL soc0110BL) {
		this.soc0110BL = soc0110BL;
	}


	public void setSoc0126BL(SOC0126BL soc0126BL) {
		this.soc0126BL = soc0126BL;
	}


	public void setSoc0112BL(SOC0112BL soc0112BL) {
		this.soc0112BL = soc0112BL;
	}


	public void setSoc0111BL(SOC0111BL soc0111BL) {
		this.soc0111BL = soc0111BL;
	}


	public void setSocRelationBL(SocRelationBL socRelationBL) {
		this.socRelationBL = socRelationBL;
	}


	public void setOrganizationBL(OrganizationBL organizationBL) {
		this.organizationBL = organizationBL;
	}


	public void setFileUploadBL(FileUploadBL fileUploadBL) {
		this.fileUploadBL = fileUploadBL;
	}
	
	
	public void setSoc0151BL(SOC0151BL soc0151BL) {
		this.soc0151BL = soc0151BL;
	}


	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}
	
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}

	/**
	 * 配置元数据版本信息BL设定
	 * @param cr03bl 配置元数据版本信息BL
	 */
	public void setCr03BL(CR03BL cr03bl) {
		cr03BL = cr03bl;
	}
	
	/**
	 * 采集结果BL设定
	 * @param cr01bl 采集结果BL
	 */
	public void setCr01BL(CR01BL cr01bl) {
		cr01BL = cr01bl;
	}
	
	/**
	 * 设备信息查询处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM05DTO searchEntityItemAction(IGCIM05DTO dto) throws BLException {

		log.debug("========设备信息查询处理开始========");
		
		//设备信息查询件数取得 
		int totalCount = this.soc0118BL.getEntityItemVWSearchCount(dto.getEntityItemVWSearchCond());
		
		if (totalCount == 0) {
			log.debug("========设备信息查询数据不存在========");
			//设备信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========设备信息查询数据件数过多========");
			//设备信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//分页用信息取得
		PagingDTO pDto = dto.getPagingDto();

		//当前页设备信息取得
		List<SOC0124Info> entityItemVWInfoList = this.soc0118BL.searchEntityItemVW(dto.getEntityItemVWSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setEntityItemVWInfoList(entityItemVWInfoList);

		Integer domainid = EiDomainKeyWords.DOOMAIN_ID_DEFAULT;
		SOC0111Info domain  = this.soc0111BL.searchDomainMaxVersion(domainid);
		Integer domainversion = domain.getVersion();
		String createtime = domain.getUpdatetime();
		String showRelation = "N";
		Map<String,String> showRelationMap = new HashMap<String,String>();
		if(entityItemVWInfoList!=null){
			//主机，交换机，存储可以查看关系
			for(SOC0124Info bean:entityItemVWInfoList){
				if(bean.getEsyscoding().startsWith(EiRelationKeyWords.HOST) 
						|| bean.getEsyscoding().startsWith(EiRelationKeyWords.SWITCH)
						|| bean.getEsyscoding().startsWith(EiRelationKeyWords.STORAGE_DMX)) {
					showRelation = "Y";
				}else{
					showRelation = "N";
				}
				showRelationMap.put(String.valueOf(bean.getEiid()), showRelation);
			}
		}
		dto.setDomainid(domainid);
		dto.setDomainversion(domainversion);
		dto.setCreatetime(createtime);
		dto.setShowRelationMap(showRelationMap);
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========设备信息查询处理终了========");
		return dto;
	}
	
	
	/**
	 * 判断登陆用户是否是设备资产管理角色负责人
	 * 
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 * @throws BLException 
	 */
	public IGCIM05DTO checkEntityItemDomain(IGCIM05DTO dto) throws BLException{
		boolean isRoleManager = this.userRoleBL.checkRoleManagerByType(dto.getUser().getUserid(), EntityCategory.ROLE_TYPE_STORAGE);
		
		if(isRoleManager) {
			OrganizationSearchCondImpl orgCond = new OrganizationSearchCondImpl();
			orgCond.setOrgpar("0001");
			List<Organization> org = this.organizationBL.searchOrganization(orgCond);
			
			if(org.size() != 1) {
				throw new BLException("IGCO10000.E004",resources.getMessage(dto.getLocale(),"message.IGASM03BLImpl.017"));
			} else {
				dto.setOrgname(org.get(0).getOrgname());
				dto.setOrgsyscoding(org.get(0).getOrgsyscoding());
			}
			SOC0117SearchCondImpl entityCond = new SOC0117SearchCondImpl();
			entityCond.setEsyscoding(CommonDefineUtils.ENTIY_CATEGORY_DEVICE_SYSCODING);
			List<SOC0117Info> entity = this.soc0117BL.searchEntity(entityCond, 0, 0);
			
			if(entity.size() != 1) {
				throw new BLException("IGCO10000.E004",resources.getMessage(dto.getLocale(),"message.IGASM03BLImpl.018"));
			} else {
				dto.setEname(entity.get(0).getEname());
				dto.setEsyscoding(entity.get(0).getEsyscoding());
			}
		}
		
		dto.setFlag(isRoleManager);
		
		return dto;
	}
}
