/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̹���_���˹���ҵ���߼��ӿ�ʵ����
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
		log.debug("========�豸��Ϣ��ѯ����ʼ========");

		
		SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
		
		BeanUtils.copyProperties(dto.getIgaut0201Form(), cond);
		
		// �豸��Ϣ��ѯ����ȡ��
		int totalCount = this.soc0118BL.getEntityItemVWSearchCount(cond);

		if (totalCount == 0) {
			log.debug("========�豸��Ϣ��ѯ���ݲ�����========");
			// �豸��Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}

		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========�豸��Ϣ��ѯ���ݼ�������========");
			// �豸��Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}

		// ��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();

		// ��ǰҳ�豸��Ϣȡ��
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
			// ���������������洢���Բ鿴��ϵ
			// ���洢��Ϊֻ�鿴DMX�洢 --20130607 yanglongquan
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

		log.debug("========�豸��Ϣ��ѯ��������========");
		return dto;
	}
	
	/**
	 * �����豸��Ʋ�ѯ
	 */
	public IGAUT02DTO searchEntityItemFor0201Action(IGAUT02DTO dto) throws BLException{
		log.debug("========�豸��Ϣ��ѯ����ʼ========");

		
		SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
		
		BeanUtils.copyProperties(dto.getIgaut0201Form(), cond);
		
		// �豸��Ϣ��ѯ����ȡ��
		int totalCount = this.soc0118BL.getEntityItemVWSearchCount(cond);

		if (totalCount == 0) {
			log.debug("========�豸��Ϣ��ѯ���ݲ�����========");
			// �豸��Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}

		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========�豸��Ϣ��ѯ���ݼ�������========");
			// �豸��Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}

		// ��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();

		// ��ǰҳ�豸��Ϣȡ��
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
			// ���������������洢���Բ鿴��ϵ
			// ���洢��Ϊֻ�鿴DMX�洢 --20130607 yanglongquan
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

		log.debug("========�豸��Ϣ��ѯ��������========");
		return dto;
	}
	
	/**
	 * �м���豸��Ʋ�ѯ
	 */
	public IGAUT02DTO searchEntityItemFor0202Action(IGAUT02DTO dto) throws BLException{
		log.debug("========�豸��Ϣ��ѯ����ʼ========");

		
		SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
		
		BeanUtils.copyProperties(dto.getIgaut0202Form(), cond);
		
		// �豸��Ϣ��ѯ����ȡ��
		int totalCount = this.soc0118BL.getEntityItemVWSearchCount(cond);

		if (totalCount == 0) {
			log.debug("========�豸��Ϣ��ѯ���ݲ�����========");
			// �豸��Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}

		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========�豸��Ϣ��ѯ���ݼ�������========");
			// �豸��Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}

		// ��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();

		// ��ǰҳ�豸��Ϣȡ��
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
			// ���������������洢���Բ鿴��ϵ
			// ���洢��Ϊֻ�鿴DMX�洢 --20130607 yanglongquan
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

		log.debug("========�豸��Ϣ��ѯ��������========");
		return dto;
	}
	
	/**
	 * ���ݿ���Ʋ�ѯ
	 */
	public IGAUT02DTO searchEntityItemFor0203Action(IGAUT02DTO dto) throws BLException{
		log.debug("========�豸��Ϣ��ѯ����ʼ========");

		
		SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
		
		BeanUtils.copyProperties(dto.getIgaut0203Form(), cond);
		
		// �豸��Ϣ��ѯ����ȡ��
		int totalCount = this.soc0118BL.getEntityItemVWSearchCount(cond);

		if (totalCount == 0) {
			log.debug("========�豸��Ϣ��ѯ���ݲ�����========");
			// �豸��Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}

		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========�豸��Ϣ��ѯ���ݼ�������========");
			// �豸��Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}

		// ��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();

		// ��ǰҳ�豸��Ϣȡ��
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
			// ���������������洢���Բ鿴��ϵ
			// ���洢��Ϊֻ�鿴DMX�洢 --20130607 yanglongquan
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

		log.debug("========�豸��Ϣ��ѯ��������========");
		return dto;
	}
	
	/**
	 * �����豸��Ʋ�ѯ
	 */
	public IGAUT02DTO searchEntityItemFor0204Action(IGAUT02DTO dto) throws BLException{
		log.debug("========�豸��Ϣ��ѯ����ʼ========");

		
		SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
		
		BeanUtils.copyProperties(dto.getIgaut0204Form(), cond);
		
		// �豸��Ϣ��ѯ����ȡ��
		int totalCount = this.soc0118BL.getEntityItemVWSearchCount(cond);

		if (totalCount == 0) {
			log.debug("========�豸��Ϣ��ѯ���ݲ�����========");
			// �豸��Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}

		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========�豸��Ϣ��ѯ���ݼ�������========");
			// �豸��Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}

		// ��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();

		// ��ǰҳ�豸��Ϣȡ��
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
			// ���������������洢���Բ鿴��ϵ
			// ���洢��Ϊֻ�鿴DMX�洢 --20130607 yanglongquan
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

		log.debug("========�豸��Ϣ��ѯ��������========");
		return dto;
	}
	
	
	/**
	 * �����豸��Ʋ�ѯ
	 */
	public IGAUT02DTO searchEntityItemFor0205Action(IGAUT02DTO dto) throws BLException{
		log.debug("========�豸��Ϣ��ѯ����ʼ========");

		
		SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
		
		BeanUtils.copyProperties(dto.getIgaut0205Form(), cond);
		
		// �豸��Ϣ��ѯ����ȡ��
		int totalCount = this.soc0118BL.getEntityItemVWSearchCount(cond);

		if (totalCount == 0) {
			log.debug("========�豸��Ϣ��ѯ���ݲ�����========");
			// �豸��Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}

		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========�豸��Ϣ��ѯ���ݼ�������========");
			// �豸��Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}

		// ��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();

		// ��ǰҳ�豸��Ϣȡ��
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
			// ���������������洢���Բ鿴��ϵ
			// ���洢��Ϊֻ�鿴DMX�洢 --20130607 yanglongquan
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

		log.debug("========�豸��Ϣ��ѯ��������========");
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