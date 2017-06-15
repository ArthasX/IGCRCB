/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.soc.aut.bl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.MessageResources;
import org.springframework.beans.BeanUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.EiDomainKeyWords;
import com.deliverik.framework.soc.asset.EiRelationKeyWords;
import com.deliverik.framework.soc.asset.EntityCategory;
import com.deliverik.framework.soc.asset.bl.task.SOC0111BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0117BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.soc.asset.model.SOC0111Info;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0117SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCondImpl;
import com.deliverik.framework.user.bl.task.OrganizationBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.condition.OrganizationSearchCondImpl;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.infogovernor.soc.aut.dto.IGAUT02DTO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程管理_个人工作业务逻辑接口实现类
 * </p>
 * 
 * @version 1.0
 */

public class IGAUT02BLImpl implements IGAUT02BL {

	static Log log = LogFactory.getLog(IGAUT02BLImpl.class);
	
	private UserRoleBL userRoleBL;
	private OrganizationBL organizationBL;
	private SOC0117BL soc0117BL;
	private SOC0118BL soc0118BL;
	private SOC0111BL soc0111BL;
	
	protected MessageResources resources = MessageResources.getMessageResources("com.deliverik.infogovernor.soc.cim.asmResources"); 

	public IGAUT02DTO checkEntityItemDomain(IGAUT02DTO dto) throws BLException {
		boolean isRoleManager = this.userRoleBL.checkRoleManagerByType(dto
				.getUser().getUserid(), EntityCategory.ROLE_TYPE_STORAGE);

		if (isRoleManager) {
			OrganizationSearchCondImpl orgCond = new OrganizationSearchCondImpl();
			orgCond.setOrgpar("0001");
			List<Organization> org = this.organizationBL
					.searchOrganization(orgCond);

			if (org.size() != 1) {
				throw new BLException("IGCO10000.E004", resources.getMessage(
						dto.getLocale(), "message.IGASM03BLImpl.017"));
			} else {
				dto.setOrgname(org.get(0).getOrgname());
				dto.setOrgsyscoding(org.get(0).getOrgsyscoding());
			}
			SOC0117SearchCondImpl entityCond = new SOC0117SearchCondImpl();
			entityCond
					.setEsyscoding(CommonDefineUtils.ENTIY_CATEGORY_DEVICE_SYSCODING);
			List<SOC0117Info> entity = this.soc0117BL.searchEntity(entityCond,
					0, 0);

			if (entity.size() != 1) {
				throw new BLException("IGCO10000.E004", resources.getMessage(
						dto.getLocale(), "message.IGASM03BLImpl.018"));
			} else {
				dto.setEname(entity.get(0).getEname());
				dto.setEsyscoding(entity.get(0).getEsyscoding());
			}
		}

		dto.setFlag(isRoleManager);

		return dto;
	}

	public IGAUT02DTO searchEntityItemAction(IGAUT02DTO dto) throws BLException {
		log.debug("========设备信息查询处理开始========");

		
		SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
		
		BeanUtils.copyProperties(dto.getIgaut0201Form(), cond);
		
		// 设备信息查询件数取得
		int totalCount = this.soc0118BL.getEntityItemVWSearchCount(cond);

		if (totalCount == 0) {
			log.debug("========设备信息查询数据不存在========");
			// 设备信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}

		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========设备信息查询数据件数过多========");
			// 设备信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}

		// 分页用信息取得
		PagingDTO pDto = dto.getPagingDto();

		// 当前页设备信息取得
		List<SOC0124Info> entityItemVWInfoList = this.soc0118BL
				.searchEntityItemVW(cond,
						pDto.getFromCount(), pDto.getPageDispCount());

		pDto.setTotalCount(totalCount);

		dto.setEntityItemVWInfoList(entityItemVWInfoList);

		Integer domainid = EiDomainKeyWords.DOOMAIN_ID_DEFAULT;
		SOC0111Info domain = this.soc0111BL.searchDomainMaxVersion(domainid);
		Integer domainversion = domain.getVersion();
		String createtime = domain.getUpdatetime();
		String showRelation = "N";
		Map<String, String> showRelationMap = new HashMap<String, String>();
		if (entityItemVWInfoList != null) {
			// 主机，交换机，存储可以查看关系
			// 将存储改为只查看DMX存储 --20130607 yanglongquan
			for (SOC0124Info bean : entityItemVWInfoList) {
				if (bean.getEsyscoding().startsWith(EiRelationKeyWords.HOST)
						|| bean.getEsyscoding().startsWith(
								EiRelationKeyWords.SWITCH)
						|| bean.getEsyscoding().startsWith(
								EiRelationKeyWords.STORAGE_DMX)) {
					showRelation = "Y";
				} else {
					showRelation = "N";
				}
				showRelationMap.put(String.valueOf(bean.getEiid()),
						showRelation);
			}
		}
		dto.setDomainid(domainid);
		dto.setDomainversion(domainversion);
		dto.setCreatetime(createtime);
		dto.setShowRelationMap(showRelationMap);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));

		log.debug("========设备信息查询处理终了========");
		return dto;
	}
	
	/**
	 * 主机设备审计查询
	 */
	public IGAUT02DTO searchEntityItemFor0201Action(IGAUT02DTO dto) throws BLException{
		log.debug("========设备信息查询处理开始========");

		
		SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
		
		BeanUtils.copyProperties(dto.getIgaut0201Form(), cond);
		
		// 设备信息查询件数取得
		int totalCount = this.soc0118BL.getEntityItemVWSearchCount(cond);

		if (totalCount == 0) {
			log.debug("========设备信息查询数据不存在========");
			// 设备信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}

		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========设备信息查询数据件数过多========");
			// 设备信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}

		// 分页用信息取得
		PagingDTO pDto = dto.getPagingDto();

		// 当前页设备信息取得
		List<SOC0124Info> entityItemVWInfoList = this.soc0118BL
				.searchEntityItemVW(cond,
						pDto.getFromCount(), pDto.getPageDispCount());

		pDto.setTotalCount(totalCount);

		dto.setEntityItemVWInfoList(entityItemVWInfoList);

		Integer domainid = EiDomainKeyWords.DOOMAIN_ID_DEFAULT;
		SOC0111Info domain = this.soc0111BL.searchDomainMaxVersion(domainid);
		Integer domainversion = domain.getVersion();
		String createtime = domain.getUpdatetime();
		String showRelation = "N";
		Map<String, String> showRelationMap = new HashMap<String, String>();
		if (entityItemVWInfoList != null) {
			// 主机，交换机，存储可以查看关系
			// 将存储改为只查看DMX存储 --20130607 yanglongquan
			for (SOC0124Info bean : entityItemVWInfoList) {
				if (bean.getEsyscoding().startsWith(EiRelationKeyWords.HOST)
						|| bean.getEsyscoding().startsWith(
								EiRelationKeyWords.SWITCH)
						|| bean.getEsyscoding().startsWith(
								EiRelationKeyWords.STORAGE_DMX)) {
					showRelation = "Y";
				} else {
					showRelation = "N";
				}
				showRelationMap.put(String.valueOf(bean.getEiid()),
						showRelation);
			}
		}
		dto.setDomainid(domainid);
		dto.setDomainversion(domainversion);
		dto.setCreatetime(createtime);
		dto.setShowRelationMap(showRelationMap);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));

		log.debug("========设备信息查询处理终了========");
		return dto;
	}
	
	/**
	 * 中间件设备审计查询
	 */
	public IGAUT02DTO searchEntityItemFor0202Action(IGAUT02DTO dto) throws BLException{
		log.debug("========设备信息查询处理开始========");

		
		SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
		
		BeanUtils.copyProperties(dto.getIgaut0202Form(), cond);
		
		// 设备信息查询件数取得
		int totalCount = this.soc0118BL.getEntityItemVWSearchCount(cond);

		if (totalCount == 0) {
			log.debug("========设备信息查询数据不存在========");
			// 设备信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}

		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========设备信息查询数据件数过多========");
			// 设备信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}

		// 分页用信息取得
		PagingDTO pDto = dto.getPagingDto();

		// 当前页设备信息取得
		List<SOC0124Info> entityItemVWInfoList = this.soc0118BL
				.searchEntityItemVW(cond,
						pDto.getFromCount(), pDto.getPageDispCount());

		pDto.setTotalCount(totalCount);

		dto.setEntityItemVWInfoList(entityItemVWInfoList);

		Integer domainid = EiDomainKeyWords.DOOMAIN_ID_DEFAULT;
		SOC0111Info domain = this.soc0111BL.searchDomainMaxVersion(domainid);
		Integer domainversion = domain.getVersion();
		String createtime = domain.getUpdatetime();
		String showRelation = "N";
		Map<String, String> showRelationMap = new HashMap<String, String>();
		if (entityItemVWInfoList != null) {
			// 主机，交换机，存储可以查看关系
			// 将存储改为只查看DMX存储 --20130607 yanglongquan
			for (SOC0124Info bean : entityItemVWInfoList) {
				if (bean.getEsyscoding().startsWith(EiRelationKeyWords.HOST)
						|| bean.getEsyscoding().startsWith(
								EiRelationKeyWords.SWITCH)
						|| bean.getEsyscoding().startsWith(
								EiRelationKeyWords.STORAGE_DMX)) {
					showRelation = "Y";
				} else {
					showRelation = "N";
				}
				showRelationMap.put(String.valueOf(bean.getEiid()),
						showRelation);
			}
		}
		dto.setDomainid(domainid);
		dto.setDomainversion(domainversion);
		dto.setCreatetime(createtime);
		dto.setShowRelationMap(showRelationMap);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));

		log.debug("========设备信息查询处理终了========");
		return dto;
	}
	
	/**
	 * 数据库审计查询
	 */
	public IGAUT02DTO searchEntityItemFor0203Action(IGAUT02DTO dto) throws BLException{
		log.debug("========设备信息查询处理开始========");

		
		SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
		
		BeanUtils.copyProperties(dto.getIgaut0203Form(), cond);
		
		// 设备信息查询件数取得
		int totalCount = this.soc0118BL.getEntityItemVWSearchCount(cond);

		if (totalCount == 0) {
			log.debug("========设备信息查询数据不存在========");
			// 设备信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}

		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========设备信息查询数据件数过多========");
			// 设备信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}

		// 分页用信息取得
		PagingDTO pDto = dto.getPagingDto();

		// 当前页设备信息取得
		List<SOC0124Info> entityItemVWInfoList = this.soc0118BL
				.searchEntityItemVW(cond,
						pDto.getFromCount(), pDto.getPageDispCount());

		pDto.setTotalCount(totalCount);

		dto.setEntityItemVWInfoList(entityItemVWInfoList);

		Integer domainid = EiDomainKeyWords.DOOMAIN_ID_DEFAULT;
		SOC0111Info domain = this.soc0111BL.searchDomainMaxVersion(domainid);
		Integer domainversion = domain.getVersion();
		String createtime = domain.getUpdatetime();
		String showRelation = "N";
		Map<String, String> showRelationMap = new HashMap<String, String>();
		if (entityItemVWInfoList != null) {
			// 主机，交换机，存储可以查看关系
			// 将存储改为只查看DMX存储 --20130607 yanglongquan
			for (SOC0124Info bean : entityItemVWInfoList) {
				if (bean.getEsyscoding().startsWith(EiRelationKeyWords.HOST)
						|| bean.getEsyscoding().startsWith(
								EiRelationKeyWords.SWITCH)
						|| bean.getEsyscoding().startsWith(
								EiRelationKeyWords.STORAGE_DMX)) {
					showRelation = "Y";
				} else {
					showRelation = "N";
				}
				showRelationMap.put(String.valueOf(bean.getEiid()),
						showRelation);
			}
		}
		dto.setDomainid(domainid);
		dto.setDomainversion(domainversion);
		dto.setCreatetime(createtime);
		dto.setShowRelationMap(showRelationMap);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));

		log.debug("========设备信息查询处理终了========");
		return dto;
	}
	
	/**
	 * 网络设备设计查询
	 */
	public IGAUT02DTO searchEntityItemFor0204Action(IGAUT02DTO dto) throws BLException{
		log.debug("========设备信息查询处理开始========");

		
		SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
		
		BeanUtils.copyProperties(dto.getIgaut0204Form(), cond);
		
		// 设备信息查询件数取得
		int totalCount = this.soc0118BL.getEntityItemVWSearchCount(cond);

		if (totalCount == 0) {
			log.debug("========设备信息查询数据不存在========");
			// 设备信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}

		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========设备信息查询数据件数过多========");
			// 设备信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}

		// 分页用信息取得
		PagingDTO pDto = dto.getPagingDto();

		// 当前页设备信息取得
		List<SOC0124Info> entityItemVWInfoList = this.soc0118BL
				.searchEntityItemVW(cond,
						pDto.getFromCount(), pDto.getPageDispCount());

		pDto.setTotalCount(totalCount);

		dto.setEntityItemVWInfoList(entityItemVWInfoList);

		Integer domainid = EiDomainKeyWords.DOOMAIN_ID_DEFAULT;
		SOC0111Info domain = this.soc0111BL.searchDomainMaxVersion(domainid);
		Integer domainversion = domain.getVersion();
		String createtime = domain.getUpdatetime();
		String showRelation = "N";
		Map<String, String> showRelationMap = new HashMap<String, String>();
		if (entityItemVWInfoList != null) {
			// 主机，交换机，存储可以查看关系
			// 将存储改为只查看DMX存储 --20130607 yanglongquan
			for (SOC0124Info bean : entityItemVWInfoList) {
				if (bean.getEsyscoding().startsWith(EiRelationKeyWords.HOST)
						|| bean.getEsyscoding().startsWith(
								EiRelationKeyWords.SWITCH)
						|| bean.getEsyscoding().startsWith(
								EiRelationKeyWords.STORAGE_DMX)) {
					showRelation = "Y";
				} else {
					showRelation = "N";
				}
				showRelationMap.put(String.valueOf(bean.getEiid()),
						showRelation);
			}
		}
		dto.setDomainid(domainid);
		dto.setDomainversion(domainversion);
		dto.setCreatetime(createtime);
		dto.setShowRelationMap(showRelationMap);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));

		log.debug("========设备信息查询处理终了========");
		return dto;
	}
	
	
	/**
	 * 虚拟设备审计查询
	 */
	public IGAUT02DTO searchEntityItemFor0205Action(IGAUT02DTO dto) throws BLException{
		log.debug("========设备信息查询处理开始========");

		
		SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
		
		BeanUtils.copyProperties(dto.getIgaut0205Form(), cond);
		
		// 设备信息查询件数取得
		int totalCount = this.soc0118BL.getEntityItemVWSearchCount(cond);

		if (totalCount == 0) {
			log.debug("========设备信息查询数据不存在========");
			// 设备信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}

		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========设备信息查询数据件数过多========");
			// 设备信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}

		// 分页用信息取得
		PagingDTO pDto = dto.getPagingDto();

		// 当前页设备信息取得
		List<SOC0124Info> entityItemVWInfoList = this.soc0118BL
				.searchEntityItemVW(cond,
						pDto.getFromCount(), pDto.getPageDispCount());

		pDto.setTotalCount(totalCount);

		dto.setEntityItemVWInfoList(entityItemVWInfoList);

		Integer domainid = EiDomainKeyWords.DOOMAIN_ID_DEFAULT;
		SOC0111Info domain = this.soc0111BL.searchDomainMaxVersion(domainid);
		Integer domainversion = domain.getVersion();
		String createtime = domain.getUpdatetime();
		String showRelation = "N";
		Map<String, String> showRelationMap = new HashMap<String, String>();
		if (entityItemVWInfoList != null) {
			// 主机，交换机，存储可以查看关系
			// 将存储改为只查看DMX存储 --20130607 yanglongquan
			for (SOC0124Info bean : entityItemVWInfoList) {
				if (bean.getEsyscoding().startsWith(EiRelationKeyWords.HOST)
						|| bean.getEsyscoding().startsWith(
								EiRelationKeyWords.SWITCH)
						|| bean.getEsyscoding().startsWith(
								EiRelationKeyWords.STORAGE_DMX)) {
					showRelation = "Y";
				} else {
					showRelation = "N";
				}
				showRelationMap.put(String.valueOf(bean.getEiid()),
						showRelation);
			}
		}
		dto.setDomainid(domainid);
		dto.setDomainversion(domainversion);
		dto.setCreatetime(createtime);
		dto.setShowRelationMap(showRelationMap);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));

		log.debug("========设备信息查询处理终了========");
		return dto;
	}
	
	
	

	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}

	public void setOrganizationBL(OrganizationBL organizationBL) {
		this.organizationBL = organizationBL;
	}

	public void setSoc0117BL(SOC0117BL soc0117bl) {
		soc0117BL = soc0117bl;
	}

	public void setSoc0118BL(SOC0118BL soc0118bl) {
		soc0118BL = soc0118bl;
	}

	public void setSoc0111BL(SOC0111BL soc0111bl) {
		soc0111BL = soc0111bl;
	}

	public void setResources(MessageResources resources) {
		this.resources = resources;
	}

}