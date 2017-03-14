package com.deliverik.infogovernor.bl;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.asset.FsLvVgTB;
import com.deliverik.framework.asset.bl.task.IG013BL;
import com.deliverik.framework.asset.bl.task.IG117BL;
import com.deliverik.framework.asset.bl.task.IG313BL;
import com.deliverik.framework.asset.bl.task.IG800BL;
import com.deliverik.framework.asset.model.IG002Info;
import com.deliverik.framework.asset.model.IG117Info;
import com.deliverik.framework.asset.model.IG313Info;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.asset.model.IG800Info;
import com.deliverik.framework.asset.model.condition.IG002SearchCondImpl;
import com.deliverik.framework.asset.model.condition.IG313SearchCondImpl;
import com.deliverik.framework.asset.model.entity.IG313TB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.CodeCategoryBL;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.model.CodeCategoryInfo;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeCategorySearchCondImpl;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;
import com.deliverik.framework.soc.asset.EiRelationKeyWords;
import com.deliverik.framework.soc.asset.SOC0130Info;
import com.deliverik.framework.soc.asset.SOC0131Info;
import com.deliverik.framework.soc.asset.bl.task.IGDomainGraphBL;
import com.deliverik.framework.soc.asset.bl.task.SOC0107BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0117BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0119BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0121BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0130BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0131BL;
import com.deliverik.framework.soc.asset.bl.task.SocDomainGraphBL;
import com.deliverik.framework.soc.asset.bl.task.SocImpactGraphBL;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0119Info;
import com.deliverik.framework.soc.asset.model.SOC0121Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0128Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.framework.soc.asset.model.SOC0132VW;
import com.deliverik.framework.soc.asset.model.SOC0133VW;
import com.deliverik.framework.soc.asset.model.SOC0139VW;
import com.deliverik.framework.soc.asset.model.SOC0605Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0107SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0117SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0118SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0119SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0121SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0121SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0129SearchCondImpl;
import com.deliverik.framework.soc.asset.model.entity.SOC0121TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0140VW;
import com.deliverik.framework.soc.asset.model.entity.SOC0141VW;
import com.deliverik.framework.user.bl.task.OrganizationBL;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.condition.OrganizationSearchCondImpl;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.infogovernor.dto.IGCOM03DTO;
import com.deliverik.infogovernor.form.IGCOM0304Form;
import com.deliverik.infogovernor.form.IGCOM0314Form;
import com.deliverik.infogovernor.form.IGCOM0319Form;
import com.deliverik.infogovernor.form.IGCOM0320Form;
import com.deliverik.infogovernor.form.IGCOM0321Form;
import com.deliverik.infogovernor.form.IGCOM0322Form;
import com.deliverik.infogovernor.form.IGCOM0324Form;
import com.deliverik.infogovernor.form.IGCOM0329Form;
import com.deliverik.infogovernor.util.ArrayListFastSort;
import com.deliverik.infogovernor.util.CodeDefine;
import com.deliverik.infogovernor.util.MapKeySort;

/**
 * ��ѯHELPҵ���߼�ʵ��
 */
public class IGCOM03BLImpl extends BaseBLImpl implements IGCOM03BL
{

	static Log log = LogFactory.getLog(IGCOM03BLImpl.class);

	/** EntityTB DAO */
	protected IG117BL ig117BL;

	/** EntityItemBL */
	protected IG013BL ig013BL;
	
	/** EntityItemBL */
	protected SOC0118BL soc0118BL;
	
	protected SOC0117BL soc0117BL;
	
	protected SOC0121BL soc0121BL;
	
	protected SOC0107BL soc0107BL;

	/** �ʲ�������BL */
	protected IG800BL ig800BL;

	/** ���ݷ�����ϢBL */
	protected CodeCategoryBL codeCategoryBL;

	/** ������ϸ��ϢBL */
	protected CodeDetailBL codeDetailBL;

	/** �������ϵBL */
	protected IG313BL ig313BL;
	/** �������ϵBL */
	protected SOC0119BL soc0119BL;
	
	/** SOC����������ͼBL */
	protected SocDomainGraphBL socDomainGraphBL;

	/** SOC������Ӱ�����ͼBL */
	protected SocImpactGraphBL socImpactGraphBL;

	/** ������ͼBL */
	protected IGDomainGraphBL igDomainGraphBL;

	/** ����BL */
	protected OrganizationBL organizationBL;

	protected SOC0130BL soc0130BL;
	
	protected SOC0131BL soc0131BL;
	
	public void setSoc0121BL(SOC0121BL soc0121BL) {
		this.soc0121BL = soc0121BL;
	}

	public void setSoc0118BL(SOC0118BL soc0118BL) {
		this.soc0118BL = soc0118BL;
	}

	public void setSoc0107BL(SOC0107BL soc0107BL) {
		this.soc0107BL = soc0107BL;
	}

	public void setSoc0117BL(SOC0117BL soc0117BL) {
		this.soc0117BL = soc0117BL;
	}

	public void setSoc0130BL(SOC0130BL soc0130BL) {
		this.soc0130BL = soc0130BL;
	}

	public void setSoc0131BL(SOC0131BL soc0131BL) {
		this.soc0131BL = soc0131BL;
	}

	public void setOrganizationBL(OrganizationBL organizationBL)
	{
		this.organizationBL = organizationBL;
	}

	public void setIg117BL(IG117BL ig117BL)
	{
		this.ig117BL = ig117BL;
	}

	public void setIg013BL(IG013BL ig013BL)
	{
		this.ig013BL = ig013BL;
	}

	public void setIg800BL(IG800BL ig800BL)
	{
		this.ig800BL = ig800BL;
	}

	public void setCodeCategoryBL(CodeCategoryBL codeCategoryBL)
	{
		this.codeCategoryBL = codeCategoryBL;
	}

	public void setCodeDetailBL(CodeDetailBL codeDetailBL)
	{
		this.codeDetailBL = codeDetailBL;
	}

	public void setIg313BL(
			IG313BL ig313BL)
	{
		this.ig313BL = ig313BL;
	}
	public void setSoc0119BL(SOC0119BL soc0119BL) {
		this.soc0119BL = soc0119BL;
	}

	public void setSocDomainGraphBL(SocDomainGraphBL socDomainGraphBL)
	{
		this.socDomainGraphBL = socDomainGraphBL;
	}

	public void setSocImpactGraphBL(SocImpactGraphBL socImpactGraphBL)
	{
		this.socImpactGraphBL = socImpactGraphBL;
	}

	public void setIgDomainGraphBL(IGDomainGraphBL igDomainGraphBL)
	{
		this.igDomainGraphBL = igDomainGraphBL;
	}

	/**
	 * �ʲ���Ϣ��ѯ
	 * 
	 * @param dto
	 *            IGCOM03DTO
	 * @return IGCOM03DTO
	 */
	public IGCOM03DTO searchEntityAction(IGCOM03DTO dto) throws BLException
	{

		log.debug("========�ʲ�����HELP��ѯ����ʼ========");

		// ��ѯ����ȡ��
		int totalCount = this.ig117BL.getIG117InfoSearchCount(dto
				.getEntitySearchCond());

		if (totalCount == 0)
		{
			log.debug("========��ѯ���ݲ�����========");
			// ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}

		if (totalCount > dto.getMaxSearchCount())
		{
			log.debug("========��ѯ���ݼ�������========");
			// ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}

		PagingDTO pDto = dto.getPagingDto();

		List<IG117Info> entityList = this.ig117BL.searchIG117Info(dto
				.getEntitySearchCond(), pDto.getFromCount(), pDto
				.getPageDispCount());

		pDto.setTotalCount(totalCount);

		dto.setEntityList(entityList);

		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));

		log.debug("========�ʲ�����HELP��ѯ��������========");
		return dto;
	}

	/**
	 * �ʲ�����Ϣ��ѯ
	 * 
	 * @param dto
	 *            IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCOM03DTO searchEntityItemAction(IGCOM03DTO dto) throws BLException
	{

		log.debug("========�ʲ���HELP��ѯ����ʼ========");

		// ��ѯ����ȡ��
		int totalCount = this.soc0118BL.getEntityItemVWSearchCount(dto.getSoc0214SearchCond());

		if (totalCount == 0)
		{
			log.debug("========��ѯ���ݲ�����========");
			// ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}

		if (totalCount > dto.getMaxSearchCount())
		{
			log.debug("========��ѯ���ݼ�������========");
			// ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}

		PagingDTO pDto = dto.getPagingDto();

		List<SOC0124Info> entityItemVWInfoList = this.soc0118BL.searchEntityItemVW(dto.getSoc0214SearchCond(), pDto
				.getFromCount(), pDto.getPageDispCount());

		pDto.setTotalCount(totalCount);

		dto.setSoc0124List(entityItemVWInfoList);

		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));

		log.debug("========�ʲ���HELP��ѯ��������========");
		return dto;
	}

	/**
	 * �ʲ�����Ϣnew��ѯ
	 * 
	 * @param dto
	 *            IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCOM03DTO searchEntityItem0327Action(IGCOM03DTO dto) throws BLException
	{
	
		log.debug("========�ʲ���HELP��ѯ����ʼ========");
	
		// ��ѯ����ȡ��
		int totalCount = this.soc0118BL.getEntityItemVWSearchCount(dto.getSoc0214SearchCond());
	
		if (totalCount == 0)
		{
			log.debug("========��ѯ���ݲ�����========");
			// ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
	
		if (totalCount > dto.getMaxSearchCount())
		{
			log.debug("========��ѯ���ݼ�������========");
			// ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}
	
		PagingDTO pDto = dto.getPagingDto();
	
		List<SOC0124Info> entityItemVWInfoList = this.soc0118BL
				.searchEntityItemVW(dto.getSoc0214SearchCond(), pDto
						.getFromCount(), pDto.getPageDispCount());
	
		pDto.setTotalCount(totalCount);
	
		dto.setSoc0124List(entityItemVWInfoList);
	
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
	
		log.debug("========�ʲ���HELP��ѯ��������========");
		return dto;
	}

	/**
	 * �ʲ�����Ϣ��ѯ
	 * 
	 * @param dto
	 *            IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCOM03DTO searchEntityItemByEiid(IGCOM03DTO dto) throws BLException
	{

		if (dto.getEiid() != null)
		{
			SOC0118Info e = this.soc0118BL.searchEntityItemByKey(
					dto.getEiid());
			dto.setSoc0118Info(e);
		}
		return dto;
	}

	/**
	 * ���ݴ�����������ƻ�ȡ�����и�������ȫ��������ɵ������б�
	 * 
	 * @param srbList
	 * @param name
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<LabelValueBean> getParContentList(List<FsLvVgTB> srbList,
			String name) throws Exception
	{
		List<String> tempList = new ArrayList<String>();
		List<LabelValueBean> codeList = new ArrayList<LabelValueBean>();
		codeList.add(new LabelValueBean("", ""));

		if (StringUtils.isNotEmpty(name))
		{
			// ȡ��Ӧ�õ���Class�е��ĸ�����
			Class s = Class.forName("com.deliverik.framework.asset.FsLvVgInfo");
			String first = name.substring(0, 1);
			String methodName = "get" + first.toUpperCase()
					+ name.substring(1, name.length());
			Method method = s.getMethod(methodName, null);

			for (Iterator<FsLvVgTB> iter = srbList.iterator(); iter.hasNext();)
			{
				FsLvVgTB srb = iter.next();

				String attr = (String) method.invoke(srb, null);

				if (!tempList.contains(attr))
				{
					tempList.add(attr);
					codeList.add(new LabelValueBean(attr, attr));
				}
			}
		}
		return codeList;
	}

	/**
	 * ������ϸ��Ϣ������ڻ�����
	 * 
	 * @param dto
	 *            IGCOM03DTO
	 * @return IGCOM03DTO
	 */
	public IGCOM03DTO initIGCOM0303Action(IGCOM03DTO dto) throws BLException
	{
		log.debug("========������ϸ��Ϣ������ڻ�����ʼ========");

		// �豸��Ϣ����
		IG688Info entityItemVWInfo = this.ig013BL
				.searchIG688InfoByKey(dto
						.getIgcom0303Form().getEiid());

		if (entityItemVWInfo == null)
		{
			throw new BLException("IGCO10000.E004", "������");
		}

		dto.setEntityItemVWInfo(entityItemVWInfo);

		// �жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
		Boolean flag = this.ig013BL.checkIG688InfoDomain(dto.getUser(),
				entityItemVWInfo);

		if (!flag)
		{
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}
		else
		{
			dto.setFlag(flag);
		}
		// ������Ϣ��ѯ����ȡ��
		int totalCount = this.ig800BL.getIG800InfoSearchCount(dto
				.getIgcom0303Form());
		if (totalCount == 0)
		{
			log.debug("========��ѯ���ݲ�����========");
			// ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I007", 0));
			return dto;
		}

		if (totalCount > dto.getMaxSearchCount())
		{
			log.debug("========��ѯ���ݼ�������========");
			// ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}
		// ������������Ϣȫ����ѯ
		IG002SearchCondImpl cond = new IG002SearchCondImpl();
		cond.setEiid(entityItemVWInfo.getEiid());
		cond.setEsyscoding_q(entityItemVWInfo.getEsyscoding());
		cond.setCiversion(dto.getIgcom0303Form().getCiversion());
		List<IG002Info> configItemVWInfoList = this.ig800BL
				.searchIG002Info(cond, 0, 0);

		Map<String, List<IG002Info>> map = new LinkedHashMap<String, List<IG002Info>>();
		List<String> strlist = new ArrayList<String>();
		boolean bool=false;
		for (IG002Info e : configItemVWInfoList)
		{
			//���˵�����ĿֵΪ�յ�����Ŀѡ��
			if(e.getCname().startsWith("����Ŀ") && StringUtils.isEmpty(e.getCivalue())){
				continue;
			}
			if (!map.containsKey(e.getCcategory()))
			{
				map.put(e.getCcategory(), new ArrayList<IG002Info>());
				strlist.add(e.getCcategory());
			}
			//��ͬ�ʲ�ֻ��ʾӦ���Ϊ�յı���
			if(CommonDefineUtils.ENTIY_CATEGORY_CONTRACT_SYSCODING.equals(entityItemVWInfo.getEsyscoding())){
				//��2��
				if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY2.equals(e.getClabel())&&StringUtils.isEmpty(e.getCivalue())){
					bool=true;
				}
				//��3��
				if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY3.equals(e.getClabel())&&StringUtils.isEmpty(e.getCivalue())){
					bool=true;
				}
				//��4��
				if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY4.equals(e.getClabel())&&StringUtils.isEmpty(e.getCivalue())){
					bool=true;
				}
				//��5��
				if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY5.equals(e.getClabel())&&StringUtils.isEmpty(e.getCivalue())){
					bool=true;
				}
				//��6��
				if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY6.equals(e.getClabel())&&StringUtils.isEmpty(e.getCivalue())){
					bool=true;
				}
				//��7��
				if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY7.equals(e.getClabel())&&StringUtils.isEmpty(e.getCivalue())){
					bool=true;
				}
				//��8��
				if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY8.equals(e.getClabel())&&StringUtils.isEmpty(e.getCivalue())){
					bool=true;
				}
				//��9��
				if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY9.equals(e.getClabel())&&StringUtils.isEmpty(e.getCivalue())){
					bool=true;
				}
				//��10��
				if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY10.equals(e.getClabel())&&StringUtils.isEmpty(e.getCivalue())){
					bool=true;
				}
				//��11��
				if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY11.equals(e.getClabel())&&StringUtils.isEmpty(e.getCivalue())){
					bool=true;
				}
				//��12��
				if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY12.equals(e.getClabel())&&StringUtils.isEmpty(e.getCivalue())){
					bool=true;
				}
				//��13��
				if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY13.equals(e.getClabel())&&StringUtils.isEmpty(e.getCivalue())){
					bool=true;
				}
				//��14��
				if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY14.equals(e.getClabel())&&StringUtils.isEmpty(e.getCivalue())){
					bool=true;
				}
				//��15��
				if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY15.equals(e.getClabel())&&StringUtils.isEmpty(e.getCivalue())){
					bool=true;
				}
				//�Ѹ���
				if(CommonDefineUtils.ENTIY_COMPACT_ACCOUNTMONEY.equals(e.getClabel())){
					bool=false;
				}
			}
			if(bool){
				continue;
			}
			map.get(e.getCcategory()).add(e);
		}

		dto.setConfigItemVWInfoMap(map);
		// dto.addMessage(new ActionMessage("IGCO10000.I007",totalCount));

		log.debug("========������ϸ��Ϣ���ڻ���������========");
		return dto;

	}
	
	/**
	 * ������ϸ��Ϣ������ڻ�����
	 * 
	 * @param dto
	 *            IGCOM03DTO
	 * @return IGCOM03DTO
	 */
	public IGCOM03DTO initIGCOM0328Action(IGCOM03DTO dto) throws BLException
	{
		log.debug("========������ϸ��Ϣ������ڻ�����ʼ========");

		// �豸��Ϣ����
		SOC0124Info entityItemVWInfo = this.soc0118BL
				.searchEntityItemVWByKey(Integer.parseInt(dto
						.getIgcom0328Form().getEiid()));

		if (entityItemVWInfo == null)
		{
			throw new BLException("IGCO10000.E004", "������");
		}

		dto.setSoc0124Info(entityItemVWInfo);

		// �жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(),
				entityItemVWInfo);

		if (!flag)
		{
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}
		else
		{
			dto.setFlag(flag);
		}
		// ������Ϣ��ѯ����ȡ��
		int totalCount = this.soc0107BL.getSOC0107SearchCount(dto
				.getIgcom0328Form());
		if (totalCount == 0)
		{
			log.debug("========��ѯ���ݲ�����========");
			// ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I007", 0));
			return dto;
		}

		if (totalCount > dto.getMaxSearchCount())
		{
			log.debug("========��ѯ���ݼ�������========");
			// ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}
		// ������������Ϣȫ����ѯ
		SOC0129SearchCondImpl cond = new SOC0129SearchCondImpl();
		cond.setEiid(entityItemVWInfo.getEiid().toString());
		cond.setEsyscoding_q(entityItemVWInfo.getEsyscoding());
		List<SOC0129Info> configItemVWInfoList = this.soc0107BL
				.searchConfigItemVW(cond, 0, 0);

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

		log.debug("========������ϸ��Ϣ���ڻ���������========");
		return dto;

	}

	/**
	 * ������������
	 * 
	 * @param cond��������
	 * @return ��������б�
	 */
	public List<SOC0121Info> searchSnapshotRelation(IGCOM03DTO dto)
			throws BLException
	{

		SOC0121SearchCond cond = dto.getSnapshotRelationSearchCond();
		return soc0121BL.searchSnapshotRelation(cond);
	}

	/**
	 * ��ϵͼ�鿴��ϵ������ڻ�����
	 * 
	 * @param dto
	 *            IGCOM03DTO
	 * @return IGCOM03DTO
	 */
	public IGCOM03DTO initIGCOM0319RelationAction(IGCOM03DTO dto)
			throws Exception
	{
		log.debug("========��ϵͼ�鿴��ϵ������ڻ�����ʼ========");
		IGCOM0319Form form = dto.getIGCOM0319Form();
		// ��ѯ�ʲ�
		SOC0118Info entityItem = this.soc0118BL.searchEntityItemByKey(Integer
				.parseInt(form.getSrpareiid_eq()));
		if (entityItem == null)
		{
			throw new BLException("IGCO10000.E004", "������");
		}

		// FS-LV-VG��Ϣ
		ArrayList<SOC0130Info> fsLvVgInfoList = this.soc0130BL.searchFsLvVg(form);

		// VG-PV-META��Ϣ
		ArrayList<SOC0131Info> vgPvMetaInfoList = this.soc0131BL
				.searchVgPvMeta(form);

		// �ж��Ƿ���Ҫ����
		Integer soltType = form.getSoltType();// ����ʽ
		String soltName = form.getSoltName();// FS-LV-VG������
		String soltNameVg = form.getSoltNameVg();// VG-PV-META������
		if (soltType != null
				&& StringUtils.isNotEmpty(soltName)
				&& (soltType == ArrayListFastSort.ASC || soltType == ArrayListFastSort.DESC))
		{
			// ��FS-LV-VG��������
			ArrayListFastSort.QuickSort(fsLvVgInfoList,
					"com.deliverik.framework.soc.asset.SOC0130Info", soltName,
					ArrayListFastSort.STRING, soltType);
		}
		if (soltType != null
				&& StringUtils.isNotEmpty(soltNameVg)
				&& (soltType == ArrayListFastSort.ASC || soltType == ArrayListFastSort.DESC))
		{
			// ��VG-PV-META��������
			ArrayListFastSort.QuickSort(vgPvMetaInfoList,
					"com.deliverik.framework.soc.asset.SOC0131Info", soltNameVg,
					ArrayListFastSort.STRING, soltType);
		}

		SOC0117Info entity = this.soc0117BL.searchEntityByKey(entityItem.getEid());
		// �豸������������ȡ��
		if (!StringUtils.isEmpty(entityItem.getEiorgsyscoding()))
		{
			OrganizationSearchCondImpl orgCond = new OrganizationSearchCondImpl();
			orgCond.setOrgsyscoding(entityItem.getEiorgsyscoding());
			List<Organization> orgList = this.organizationBL
					.searchOrganization(orgCond, 0, 0);
            String orgname = orgList.size()>0?orgList.get(0).getOrgname():"";
			dto.setEiorgname(orgname);// �豸������������
		}
		dto.setEname(entity.getEname());// �ʲ�ģ������
		dto.setSoc0118Info(entityItem);// �ʲ���Ϣ
		dto.setVgPvMetaInfoList(vgPvMetaInfoList);// �豸��ϵ��VG-PV-META��
		dto.setFsLvVgInfoList(fsLvVgInfoList);// �豸��ϵ��FS-LV-VG��
		log.debug("========��ϵͼ�鿴��ϵ������ڻ���������========");
		return dto;

	}

	/**
	 * ��ϵͼ�鿴��ϵ������ڻ�����
	 * 
	 * @param dto
	 *            IGCOM03DTO
	 * @return IGCOM03DTO
	 */
	public IGCOM03DTO initIGCOM0320RelationAction(IGCOM03DTO dto)
			throws Exception
	{
		log.debug("========��ϵͼ�鿴��ϵ������ڻ�����ʼ========");

		IGCOM0320Form form = dto.getIGCOM0320Form();
		form.setDeleteflag_eq("0");
		// ��չ�㷨��������Ϊ3ʱ תΪ ������ͼʹ��
		form.setSrarithmetictype_eq("3");
		// ��ȡ����������
		List<SOC0139VW> switchConfigItem = this.soc0118BL
				.searchSwitchService(form.getSrpareiid_eq(), form
						.getSrparversion_eq(), form.getSrparsmallversion_eq());
		if (switchConfigItem.size() == 0)
		{
			throw new BLException("IGCO10000.E004", "EI");
		}
		SOC0139VW switchconfigitem = switchConfigItem.get(0);
		// ȡ�ý����� �� port�Ĺ�ϵ
		form.setSrassetrelation_eq(EiRelationKeyWords.EIR_ID_225);
		List<SOC0132VW> portList = this.soc0121BL
				.searchSwitchPortByCond(form);

		// ȡ�ý������� zoning�Ĺ�ϵ
		form.setSrassetrelation_eq(EiRelationKeyWords.EIR_ID_226);
		List<SOC0133VW> zoneList = this.soc0121BL
				.searchSwitchZoneByCond(form);
        Collections.sort(zoneList, new Comparator<SOC0133VW>(){
            public int compare(SOC0133VW p1, SOC0133VW p2) {
                      final String count1 = p1.getZonename().substring(p1.getZonename().lastIndexOf("_")+1);
                      final String count2 = p2.getZonename().substring(p2.getZonename().lastIndexOf("_")+1);
                     
                      return count1.compareTo(count2);
                  }
        });
		switchconfigitem.setEffectivecfg(zoneList.size() > 0 ? zoneList.get(0)
				.getEffectivecfg() : "");
        
		// Zoning �� Port �Ĺ�ϵ
		SOC0121SearchCondImpl cond2 = new SOC0121SearchCondImpl();
		cond2.setSrdomainid_eq(form.getSrdomainid_eq());
		cond2.setSrdomainversion_eq(form.getSrdomainversion_eq());
		cond2.setSrcreatetime_eq(form.getSrcreatetime_eq());
		cond2.setDeleteflag_eq("0");
		cond2.setSrarithmetictype_eq("3");
		cond2.setSrassetrelation_eq(EiRelationKeyWords.EIR_ID_227);
		List<SOC0121TB> relation = this.soc0121BL
				.searchSwitchRelationByCond(form, cond2);

		// ȡ�� port ���� Zoning �Լ� Zoning ���� port Map<String,<String>>
		Map<String, List<String>> switchMap = getColorMaping(relation);
		setEiidsForPort(portList, switchMap);
		setEiidsForZone(zoneList, switchMap);
		dto.setZoneList(zoneList);
		dto.setPortList(portList);
		dto.setSwitchConfigItem(switchconfigitem);
		log.debug("========��ϵͼ�鿴��ϵ������ڻ���������========");
		return dto;
	}

	/**
	 * ��ϵͼ�鿴��ϵ������ڻ�����
	 * 
	 * @param dto
	 *            IGCOM03DTO
	 * @return IGCOM03DTO
	 */
	public IGCOM03DTO initIGCOM0322RelationAction(IGCOM03DTO dto)
			throws Exception
	{
		log.debug("========��ϵͼ�鿴��ϵ������ڻ�����ʼ========");

		IGCOM0322Form form = dto.getIgcom0322Form();
		form.setDeleteflag_eq("0");
		// ��չ�㷨��������Ϊ1ʱ ����ͼ��
		form.setSrarithmetictype_eq("4");
		// ȡ�ô洢�� �����Ĺ�ϵ
		form.setSrassetrelation_eq(EiRelationKeyWords.EIR_ID_222);
		// �豸��Ϣ����
		// �豸��Ϣ����
		SOC0124Info entityItemVW = this.soc0118BL
				.searchEntityItemVWByKey(Integer.parseInt(form
						.getSrcldeiid_eq()));

		if (entityItemVW == null)
		{
			throw new BLException("IGCO10000.E004", "EI");
		}
		List<SOC0141VW> snapshotRelationInfoList = this.soc0121BL
				.searchSnapshotEntityVW(form);
		StringBuffer strXml = new StringBuffer();
		strXml.append("<?xml version=1.0 encoding=UTF-8?><ROOT><DATAID>");
		strXml.append(entityItemVW.getEilabel());
		strXml.append("</DATAID>");
		SOC0121SearchCondImpl snapshotRelationSearchCond = new SOC0121SearchCondImpl();
		snapshotRelationSearchCond.setSrdomainid_eq(form.getSrdomainid_eq());
		snapshotRelationSearchCond.setSrdomainversion_eq(form
				.getSrdomainversion_eq());
		snapshotRelationSearchCond
				.setSrcreatetime_eq(form.getSrcreatetime_eq());
		snapshotRelationSearchCond.setDeleteflag_eq("0");
		snapshotRelationSearchCond.setSrarithmetictype_eq("4");
		snapshotRelationSearchCond.setSrassetrelation_eq("3"); // Ӧ����������ϵ
		List<SOC0141VW> app = getAppList(snapshotRelationSearchCond,
				snapshotRelationInfoList);
		List<Integer> appeiid = new ArrayList<Integer>();
		Map<String, List<String>> host_appmap = getHost_AppMaping(app);
		for (int i = 0; i < snapshotRelationInfoList.size(); i++)
		{
			SOC0141VW info = snapshotRelationInfoList.get(i);
			// ȡ�ö�Ӧ��ϵ
			List<String> cldEiids = host_appmap.get(info.getSrpareiid()
					.toString());
			StringBuffer eiids = new StringBuffer();
			if (cldEiids != null)
			{
				for (int j = 0; j < cldEiids.size(); j++)
				{
					if (j > 0)
					{
						eiids.append(";");
					}
					eiids.append(cldEiids.get(j));
				}
			}
			strXml.append("<hostitem label='" + info.getSrpareiname()
					+ "' value='" + info.getSrpareiid() + "' version ='"
					+ info.getSrparversion() + "' smallversion = '"
					+ info.getSrparsmallversion() + "' eiids = '"
					+ eiids.toString() + "' />");

		}
		for (int i = 0; i < app.size(); i++)
		{
			SOC0141VW info = app.get(i);
			if (!appeiid.contains(info.getSrpareiid()))
			{
				// ȡ�ö�Ӧ��ϵ
				List<String> cldEiids = host_appmap.get(info.getSrpareiid()
						.toString());
				StringBuffer eiids = new StringBuffer();
				if (cldEiids != null)
				{
					for (int j = 0; j < cldEiids.size(); j++)
					{
						if (j > 0)
						{
							eiids.append(";");
						}
						eiids.append(cldEiids.get(j));
					}
				}
				strXml.append("<appitem label='" + info.getSrpareiname()
						+ "' value='" + info.getSrpareiid() + "' version ='"
						+ info.getSrparversion() + "' smallversion = '"
						+ info.getSrparsmallversion() + "' eiids = '"
						+ eiids.toString() + "' />");
				appeiid.add(info.getSrpareiid());
			}
		}
		strXml.append("</ROOT>");
		dto.setSoc0124Info(entityItemVW);
		dto.setStorageEiname(entityItemVW.getEilabel());
		dto.setStrXml(strXml.toString());
		log.debug("========��ϵͼ�鿴��ϵ������ڻ���������========");
		return dto;
	}

	/**
	 * ������ϸ��Ϣ������ڻ�����
	 * 
	 * @param dto
	 *            IGCOM03DTO
	 * @return IGCOM03DTO
	 */
	public IGCOM03DTO initIGCOM0304Action(IGCOM03DTO dto) throws BLException
	{
		// ���ݷ�����Ϣ��ѯ
		CodeCategorySearchCondImpl cond = new CodeCategorySearchCondImpl();

		List<CodeCategoryInfo> codeCategoryInfoList = this.codeCategoryBL
				.searchCodeCategory(cond);

		// ���ݷ����б�����
		List<LabelValueBean> labelList = new ArrayList<LabelValueBean>();

		labelList.add(new LabelValueBean("", ""));

		for (CodeCategoryInfo info : codeCategoryInfoList)
		{
			labelList.add(new LabelValueBean(info.getCcname(), info.getCcid()));
		}

		dto.setCodeCategorylList(labelList);

		return dto;
	}

	/**
	 * ������ϸ��Ϣ��ѯ����
	 * 
	 * @param dto
	 *            IGCOM03DTO
	 * @return IGCOM03DTO
	 */
	public IGCOM03DTO searchCodeDetailAction(IGCOM03DTO dto) throws BLException
	{
		log.debug("========������ϸ��Ϣ������ڻ�����ʼ========");
		IGCOM0304Form form = dto.getIgcom0304Form();

		// ��ѯ����ȡ��
		int totalCount = this.codeDetailBL.getSearchCount(form);

		if (totalCount == 0)
		{
			log.debug("========��ѯ���ݲ�����========");
			// ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}

		if (totalCount > dto.getMaxSearchCount())
		{
			log.debug("========��ѯ���ݼ�������========");
			// ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}

		PagingDTO pDto = dto.getPagingDto();

		List<CodeDetail> codeDetailList = this.codeDetailBL.searchCodeDetail(
				form, pDto.getFromCount(), pDto.getPageDispCount(),
				CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_0);

		pDto.setTotalCount(totalCount);

		dto.setCodeDetailList(codeDetailList);

		log.debug("========������ϸ��Ϣ������ڻ���������========");
		return dto;
	}

	/**
	 * <p> ��ѯ��ϵͼ </p>
	 * 
	 * @param dto
	 *            IGCOM03DTO
	 * @return IGCOM03DTO
	 * @throws BLException
	 */

	public IGCOM03DTO searchRelationAction(IGCOM03DTO dto) throws BLException
	{
		log.debug("========��ϵͼ��ѯ����ʼ========");
		// �豸��Ϣ����
	Integer eiid = dto.getEiid();
		if (eiid.toString() == null)
		{
			throw new BLException("IGCO10000.E004", "�ʲ���");
		}
		IG688Info entityItemVWInfo = this.ig013BL
				.searchIG688InfoByKey(eiid);

		if (entityItemVWInfo == null)
		{
			throw new BLException("IGCO10000.E004", "�ʲ���");
		}

		dto.setEntityItemVWInfo(entityItemVWInfo);
		dto.getIgcom0305Form().setEiversion(String.valueOf(entityItemVWInfo.getEiversion()));
		// ���������ϵ����
		IG313SearchCondImpl parcond = new IG313SearchCondImpl();

		parcond.setPareiid(eiid);
		parcond.setParversion(entityItemVWInfo.getEiversion());
		parcond.setParsmallversion(entityItemVWInfo.getEismallversion());
		parcond.setDeleteflag("0");

		Map<String, List<IG313Info>> parmap = new LinkedHashMap<String, List<IG313Info>>();
		// �豸��ϵ��Ϣȫ������
		List<IG313Info> parEntityItemRelationList = this.ig313BL
				.searchMaxIG313Info(parcond);
		for (IG313Info e : parEntityItemRelationList)
		{
			String key = e.getEirrelationcode().split("-")[0];
			String eirrelationcode = e.getEirrelationcode();
			String ecategory = e.getParEntityItemVW().getEcategory();
			if (!"-".equals(eirrelationcode.replaceAll(ecategory, "")))
			{
				key = eirrelationcode.replaceAll(ecategory, "").replaceAll("-",
						"");
			}
			if (!parmap.containsKey(key))
			{
				parmap.put(key, new ArrayList<IG313Info>());
			}
			((IG313TB) e).setParflag("0");
			parmap.get(key).add(e);
		}

		// ���������ϵ����
		// ������ϵ����
		IG313SearchCondImpl cldcond = new IG313SearchCondImpl();

		cldcond.setCldeid(eiid);
		cldcond.setCldversion(entityItemVWInfo.getEiversion());
		cldcond.setCldsmallversion(entityItemVWInfo.getEismallversion());
		cldcond.setDeleteflag("0");

		// �豸��ϵ��Ϣȫ������
		List<IG313Info> cldEntityItemRelationList = this.ig313BL
				.searchMaxIG313Info(cldcond);
		
		for (IG313Info e : cldEntityItemRelationList)
		{
			String key = e.getEirrelationcode().split("-")[0];
			String eirrelationcode = e.getEirrelationcode();
			String ecategory = e.getCldEntityItemVW().getEcategory();
			if (!"-".equals(eirrelationcode.replaceAll(ecategory, "")))
			{
				key = eirrelationcode.replaceAll(ecategory, "").replaceAll("-",
						"");
			}
			if (!parmap.containsKey(key))
			{
				parmap.put(key, new ArrayList<IG313Info>());
			}
			((IG313TB) e).setParflag("1");
			parmap.get(key).add(e);
		}
		if (parmap.size() == 0)
		{
			parmap = null;
		}
		dto.setParEntityItemRelationMap(parmap);
		// �жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
		Boolean flag = this.ig013BL.checkIG688InfoDomain(dto.getUser(),
				entityItemVWInfo);

		if (!flag)
		{
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
		}

		dto.setFlag(flag);
		log.debug("========��ϵͼ��ѯ����ʼ========");
		return dto;
	}

	/**
	 * <p> ��ѯ�ʲ�ģ������ </p>
	 * 
	 * @param dto
	 *            IGCOM03DTO
	 * @return IGCOM03DTO
	 * @throws BLException
	 */

	public IGCOM03DTO searchEntityNameAction(IGCOM03DTO dto) throws BLException
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
	
	/**
	 * <p> ��ѯ�ʲ�ģ������ </p>
	 * 
	 * @param dto
	 *            IGCOM03DTO
	 * @return IGCOM03DTO
	 * @throws BLException
	 */

	public IGCOM03DTO searchEntityNameActionSOC(IGCOM03DTO dto) throws BLException
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

	/**
	 * �ʲ���������Ϣ�汾�Ƚϻ�����ڻ�����
	 * 
	 * @param dto
	 *            IGCOM03DTO
	 * @return IGCOM03DTO
	 * @throws BLException
	 */
	public IGCOM03DTO initIGCOM0307Action(IGCOM03DTO dto) throws BLException
	{
		log.debug("========�ʲ���������Ϣ�汾�Ƚϻ�����ڻ�����ʼ========");

//		// �豸��Ϣ����
//		IG688Info entityItemVWInfo = this.ig013BL
//				.searchIG688InfoByKey(dto
//						.getIgcom0307Form().getEiid());
//
//		if (entityItemVWInfo == null)
//		{
//			throw new BLException("IGCO10000.E004", "�豸");
//		}
//
//		if (entityItemVWInfo.getEiversion() == 0)
//		{
//			dto.addMessage(new ActionMessage("IGCOM0205.W001"));
//		}
//
//		dto.setEntityItemVWInfo(entityItemVWInfo);
//
//		// �жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
//		Boolean flag = this.ig013BL.checkIG688InfoDomain(dto.getUser(),
//				entityItemVWInfo);
//
//		if (!flag)
//		{
//			dto.addMessage(new ActionMessage("IGCO10000.E022"));
//			dto.setFlag(flag);
//			return dto;
//		}
//		else
//		{
//			dto.setFlag(flag);
//		}
//
//		// �豸������Ϣ��ѯ����ȡ��
//		int totalCount = this.ig800BL.getIG800InfoSearchCount(dto
//				.getIgcom0307Form());
//
//		if (totalCount == 0)
//		{
//			log.debug("========��ѯ���ݲ�����========");
//			// ��ѯ���ݲ�����
//			dto.addMessage(new ActionMessage("IGCO10000.I007", 0));
//			return dto;
//		}
//
//		// �豸������Ϣȫ������
//
//		List<IG800Info> configItemList = this.ig800BL.searchIG800Info(
//				dto.getIgcom0307Form(), 0, 0);
//		Map<String, String> cldVersionMap=new HashMap<String, String>();//���ʲ��汾����
//		for (IG800Info info : configItemList) {
//			String cattach = info.getConfiguration().getCattach();
//			if("4".equals(cattach)){
//				String value = info.getCivalue();
//				if(StringUtils.isNotEmpty(value)){
//					Integer cldeiid =Integer.parseInt(( value.substring(value.lastIndexOf("(")+1, value.length()-1)));//���ʲ�eiid
//					
//					IG313SearchCondImpl cond=new IG313SearchCondImpl();
//					cond.setPareiid(entityItemVWInfo.getEiid());
//					cond.setCldeiid(cldeiid);
//					cond.setParversion(info.getCiversion());
//					cond.setEirinfo("_"+info.getCiid()+"_");
//					cond.setDeleteflag("0");
//					List<IG313Info> ig313Info = ig313BL.searchIG313Info(cond);
//					String cldversion="";
//					if(ig313Info!=null&&ig313Info.size()>0){
//						cldversion = String.valueOf(ig313Info.get(0).getCldversion());//���ʲ��汾
//					}
//					cldVersionMap.put(value+info.getCiversion(), cldversion);
//				}
//			}
//		}
//		dto.getIgcom0307Form().setCldVersionMap(cldVersionMap);
//		dto.setConfigItemList(configItemList);
//
//		dto.setFlag(flag);
//
//		log.debug("========�ʲ���������Ϣ�汾�Ƚϻ�����ڻ���������========");
//		return dto;
		// �豸��Ϣ����
		SOC0124Info entityItemVWInfo = this.soc0118BL
				.searchEntityItemVWByKey(Integer.parseInt(dto.getIgcom0307Form().getEiid()));

		if (entityItemVWInfo == null)
		{
			throw new BLException("IGCO10000.E004", "�豸");
		}

		if (entityItemVWInfo.getEiversion() == 0)
		{
			dto.addMessage(new ActionMessage("IGCOM0205.W001"));
		}

		dto.setSoc0124Info(entityItemVWInfo);

		// �жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(),
				entityItemVWInfo);

		if (!flag)
		{
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}
		else
		{
			dto.setFlag(flag);
		}

		// �豸������Ϣ��ѯ����ȡ��
		int totalCount = this.soc0107BL.getSOC0107SearchCount(dto
				.getIgcom0307Form());

		if (totalCount == 0)
		{
			log.debug("========��ѯ���ݲ�����========");
			// ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I007", 0));
			return dto;
		}

		// �豸������Ϣȫ������

		List<SOC0107Info> configItemList = this.soc0107BL.searchSOC0107(dto.getIgcom0307Form(), 0, 0);
		dto.setConfigItemList(configItemList);

		dto.setFlag(flag);

		log.debug("========�ʲ���������Ϣ�汾�Ƚϻ�����ڻ���������========");
		return dto;
	}

	/**
	 * ������Ϣ��ʷ��¼������ڻ�����
	 * 
	 * @param dto
	 *            IGCOM03DTO
	 * @return IGCOM03DTO
	 */
	public IGCOM03DTO initIGCOM0308Action(IGCOM03DTO dto) throws BLException
	{
		log.debug("========������Ϣ��ʷ��¼������ڻ�����ʼ========");

		// ��Ϣ����
		SOC0605Info entityItemVWInfo = this.soc0118BL
				.searchSOC0605InfoByKey(dto
						.getIgcom0308Form().getEiid());

		if (entityItemVWInfo == null)
		{
			throw new BLException("IGCO10000.E004", "");
		}

		if (entityItemVWInfo.getEiversion() == 0 && entityItemVWInfo.getEismallversion() == 0) {
			dto.addMessage(new ActionMessage("IGASM0205.W001"));
		}

		if (StringUtils.isEmpty(dto.getIgcom0308Form().getCiversion()+""))
		{
			dto.getIgcom0308Form().setCiversion(String.valueOf(
					entityItemVWInfo.getEiversion()));
		}
		// �жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
		Boolean flag = this.soc0118BL.checkSOC0605InfoDomain(dto.getUser(),
				entityItemVWInfo);

		if (!flag)
		{
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}
		else
		{
			dto.setFlag(flag);
		}

		//SOC0107SearchCond
		SOC0107SearchCondImpl soc0107Cond = new SOC0107SearchCondImpl();
		soc0107Cond.setEiid(dto.getIgcom0308Form().getEiid().toString());
		soc0107Cond.setCiversion(dto.getIgcom0308Form().getCiversion());
		soc0107Cond.setCismallversion(dto.getIgcom0308Form().getCismallversion());
		// ������Ϣ��ѯ����ȡ��
		int totalCount = this.soc0107BL.getSOC0107SearchCount(soc0107Cond);

		if (totalCount == 0)
		{
			log.debug("========��ѯ���ݲ�����========");
			// ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I007", 0));
			return dto;
		}

		// ������Ϣȫ������

		List<SOC0107Info> configItemList = this.soc0107BL.searchSOC0107(soc0107Cond, 0, 0);
		Map<String, List<SOC0107Info>> map = new LinkedHashMap<String, List<SOC0107Info>>();
		
		Map<String, String> cldVersionMap=new HashMap<String, String>();//���ʲ��汾����
		boolean bool=false;
		for (SOC0107Info e : configItemList)
		{
			if("4".equals(e.getConfiguration().getCattach())){
				String civalue = e.getCivalue();
				if(StringUtils.isNotEmpty(civalue)){
					int cldeiid = Integer.parseInt(civalue.substring(civalue.lastIndexOf("(")+1, civalue.length()-1));//���ʲ�eiid
					
//					IG313SearchCondImpl cond=new IG313SearchCondImpl();
					SOC0119SearchCondImpl cond = new SOC0119SearchCondImpl();
					cond.setPareiid(dto.getIgcom0308Form().getEiid());
					cond.setCldeiid(cldeiid);
					if(StringUtils.isNotEmpty(dto.getIgcom0308Form().getCiversion())){
						cond.setParversion(Integer.parseInt(dto.getIgcom0308Form().getCiversion()));
					}
					cond.setEirinfo("_"+e.getCiid()+"_");
					cond.setDeleteflag("0");
//					List<IG313Info> ig313Info = ig313BL.searchIG313Info(cond);
					List<SOC0119Info> soc0119Info = soc0119BL.searchEntityItemRelation(cond);
					String cldversion="";
					if(soc0119Info!=null&&soc0119Info.size()>0){
						cldversion = String.valueOf(soc0119Info.get(0).getCldversion());//���ʲ��汾
					}
					cldVersionMap.put(String.valueOf(cldeiid), cldversion);
				}
			}
			if (!map.containsKey(e.getConfiguration().getCcategory()))
			{
				map.put(e.getConfiguration().getCcategory(),
						new ArrayList<SOC0107Info>());
			}
			//��ͬ�ʲ�ֻ��ʾӦ���Ϊ�յı���
			if(CommonDefineUtils.ENTIY_CATEGORY_CONTRACT_SYSCODING.equals(entityItemVWInfo.getEsyscoding())){
				String clabel = e.getConfiguration().getClabel();
				//��2��
				if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY2.equals(clabel)&&StringUtils.isEmpty(e.getCivalue())){
					bool=true;
				}
				//��3��
				if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY3.equals(clabel)&&StringUtils.isEmpty(e.getCivalue())){
					bool=true;
				}
				//��4��
				if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY4.equals(clabel)&&StringUtils.isEmpty(e.getCivalue())){
					bool=true;
				}
				//��5��
				if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY5.equals(clabel)&&StringUtils.isEmpty(e.getCivalue())){
					bool=true;
				}
				//��6��
				if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY6.equals(clabel)&&StringUtils.isEmpty(e.getCivalue())){
					bool=true;
				}
				//��7��
				if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY7.equals(clabel)&&StringUtils.isEmpty(e.getCivalue())){
					bool=true;
				}
				//��8��
				if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY8.equals(clabel)&&StringUtils.isEmpty(e.getCivalue())){
					bool=true;
				}
				//��9��
				if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY9.equals(clabel)&&StringUtils.isEmpty(e.getCivalue())){
					bool=true;
				}
				//��10��
				if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY10.equals(clabel)&&StringUtils.isEmpty(e.getCivalue())){
					bool=true;
				}
				//��11��
				if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY11.equals(clabel)&&StringUtils.isEmpty(e.getCivalue())){
					bool=true;
				}
				//��12��
				if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY12.equals(clabel)&&StringUtils.isEmpty(e.getCivalue())){
					bool=true;
				}
				//��13��
				if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY13.equals(clabel)&&StringUtils.isEmpty(e.getCivalue())){
					bool=true;
				}
				//��14��
				if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY14.equals(clabel)&&StringUtils.isEmpty(e.getCivalue())){
					bool=true;
				}
				//��15��
				if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY15.equals(clabel)&&StringUtils.isEmpty(e.getCivalue())){
					bool=true;
				}
				//�Ѹ���
				if(CommonDefineUtils.ENTIY_COMPACT_ACCOUNTMONEY.equals(clabel)){
					bool=false;
				}
			}
			if(bool){
				continue;
			}
			map.get(e.getConfiguration().getCcategory()).add(e);
		}
		dto.getIgcom0308Form().setCldVersionMap(cldVersionMap);
		map = new MapKeySort<List<SOC0107Info>>().sort(map);
		dto.setConfigItemMapSOC(map);
		dto.setEntityItemVWInfoSOC(entityItemVWInfo);
		log.debug("========������Ϣ��ʷ��¼������ڻ���������========");
		return dto;
	}

	/**
	 * ������Ϣ��ʾ������ڻ�����
	 * 
	 * @param dto
	 *            IGCOM03DTO
	 * @return IGCOM03DTO
	 */
	public IGCOM03DTO showConfigAction(IGCOM03DTO dto) throws BLException {
		log.debug("========������Ϣ��ʾ������ڻ�����ʼ========");

		// ��Ϣ����
//		IG688Info entityItemVWInfo = this.ig013BL.searchIG688InfoByKey(dto.getIgcom0308Form().getEiid());
		SOC0605Info entityItemVWInfo = this.soc0118BL.searchSOC0605InfoByKey(dto.getIgcom0308Form().getEiid());
		
		if (entityItemVWInfo == null){
			throw new BLException("IGCO10000.E004", "");
		}
		dto.setEntityItemVWInfoSOC(entityItemVWInfo);
		if (StringUtils.isEmpty(dto.getIgcom0308Form().getCiversion()+"")){
			dto.getIgcom0308Form().setCiversion(String.valueOf(entityItemVWInfo.getEiversion()));
		}
		// �жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
		Boolean flag = this.soc0118BL.checkSOC0605InfoDomain(dto.getUser(), entityItemVWInfo);

		if (!flag){
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}
		else {
			dto.setFlag(flag);
		}

		//SOC0107SearchCond
		SOC0107SearchCondImpl soc0107Cond = new SOC0107SearchCondImpl();
		soc0107Cond.setEiid(dto.getIgcom0308Form().getEiid().toString());
		soc0107Cond.setCiversion(dto.getIgcom0308Form().getCiversion());
		soc0107Cond.setCismallversion(dto.getIgcom0308Form().getCismallversion());
		// ������Ϣ��ѯ����ȡ��
//		int totalCount = this.ig800BL.getIG800InfoSearchCount(dto.getIgcom0308Form());
		int totalCount = this.soc0107BL.getSOC0107SearchCount(soc0107Cond);
		
		if (totalCount == 0){
			log.debug("========��ѯ���ݲ�����========");
			// ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I007", 0));
			return dto;
		}

		// ������Ϣȫ������
		List<SOC0107Info> configItemList = this.soc0107BL.searchSOC0107(soc0107Cond, 0, 0);
		Map<String, List<SOC0107Info>> map = new LinkedHashMap<String, List<SOC0107Info>>();
		for (SOC0107Info e : configItemList)
		{
			if (!map.containsKey(e.getConfiguration().getCcategory()))
			{
				map.put(e.getConfiguration().getCcategory(),
						new ArrayList<SOC0107Info>());
			}
			map.get(e.getConfiguration().getCcategory()).add(e);
		}
		map = new MapKeySort<List<SOC0107Info>>().sort(map);
		dto.setConfigItemMapSOC(map);

		log.debug("========������Ϣ��ʾ������ڻ���������========");
		return dto;
	}

	/**
	 * �ʲ���ϵͼ������ڻ�����
	 * 
	 * @param dto
	 *            IGCOM03DTO
	 * @return IGCOM03DTO
	 * @throws BLException
	 */
	public IGCOM03DTO initIGCOM0314Action(IGCOM03DTO dto) throws BLException
	{
		log.debug("========�ʲ���ϵͼ������ڻ�����ʼ========");

		IGCOM0314Form form = dto.getIgcom0314Form();
		SOC0118Info eiInfo=this.soc0118BL.searchEntityItemByKey(Integer
				.parseInt(form.getEiid()));
		dto.setEsyscoding(eiInfo.getEsyscoding());

		if(StringUtils.isNotEmpty(form.getDiskeiid())){
			SOC0118Info diskei = this.soc0118BL.searchEntityItemByKey(Integer
					.parseInt(form.getDiskeiid()));
			if(diskei!=null){
				if("999001013".equals(diskei.getEsyscoding())){
					form.setGraphXml(this.socDomainGraphBL.initGraph(eiInfo,
							form.getDomainid(), form.getDomainversion(), form
									.getUpdatetime(),diskei));
				}else{
					form.setGraphXml(this.socDomainGraphBL.initGraph(eiInfo,
							form.getDomainid(), form.getDomainversion(), form
									.getUpdatetime()));
				}
			}
		}else{
			form.setGraphXml(this.socDomainGraphBL.initGraph(eiInfo,
					form.getDomainid(), form.getDomainversion(), form
							.getUpdatetime()));
		}

		log.debug(form.getGraphXml());
		log.debug("========�ʲ���ϵͼ������ڻ���������========");
		return dto;
	}

	/**
	 * Ӱ�����ͼ������ڻ�����
	 * 
	 * @param dto
	 *            IGCOM03DTO
	 * @return IGCOM03DTO
	 * @throws BLException
	 */
	public IGCOM03DTO initIGCOM0321Action(IGCOM03DTO dto) throws BLException
	{
		log.debug("========Ӱ�����������ڻ�����ʼ========");

		IGCOM0321Form form = dto.getIgcom0321Form();

		SOC0124Info ei = this.soc0118BL.searchEntityItemVWByKey(Integer
				.parseInt(form.getEiid()));

		// �жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(),
				ei);

		if (!flag)
		{
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			form.setFlag(flag);
			return dto;
		}
		else
		{
			form.setFlag(flag);
		}

		form.setGraphXml(this.socImpactGraphBL.initGraph(ei,
				form.getDomainid(), form.getDomainversion(), form
						.getUpdatetime()));

		log.debug(form.getGraphXml());
		log.debug("========Ӱ�����ͼ������ڻ���������========");
		return dto;
	}

	/**
	 * ������ͼ������ڻ�����
	 * 
	 * @param dto
	 *            IGCOM03DTO
	 * @return IGCOM03DTO
	 * @throws BLException
	 */
	public IGCOM03DTO initIGCOM0324Action(IGCOM03DTO dto) throws BLException
	{
		log.debug("========������ͼ������ڻ�����ʼ========");
		IGCOM0324Form form = dto.getIgcom0324Form();
		Integer eiid = form.getEiid();
		if (eiid != null && eiid == 0)
		{
			eiid = null;
		}
		form.setGraphXml(this.igDomainGraphBL.initGraph(form.getEiid(), form
				.getDomainid(), form.getDomainversion(), form.getUpdatetime()));
		log.debug(form.getGraphXml());
		log.debug("========������ͼ������ڻ���������========");
		return dto;
	}

	public Map<String, String> getConfigItemMap(List<IG800Info> configItemList)
	{
		Map<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < configItemList.size(); i++)
		{
			IG800Info config = configItemList.get(i);
			map.put(config.getCid() + "", config.getCivalue());
		}
		return map;
	}

	/**
	 * ȡ�����ڱ�ɫ��Mapӳ��
	 * 
	 * @return
	 */
	public Map<String, List<String>> getColorMaping(
			List<SOC0121TB> snapshotRelationInfoList)
	{

		// �� ����Ϊ0 ������
		Map<String, List<String>> map = new HashMap<String, List<String>>();

		for (int i = 0; i < snapshotRelationInfoList.size(); i++)
		{
			SOC0121Info info = snapshotRelationInfoList.get(i);
			String pareiid = info.getSrpareiid().toString();
			String cldeiid = info.getSrcldeiid().toString();

			// ������� Zoning �� port ӳ��
			if (map.containsKey(pareiid))
			{
				List<String> value = map.get(pareiid);
				if (!value.contains(cldeiid))
				{
					value.add(cldeiid);
				}
			}
			else
			{
				List<String> value = new ArrayList<String>();
				value.add(cldeiid);
				map.put(pareiid, value);
			}
			// ������� Port �� Zoning ӳ��
			if (map.containsKey(cldeiid))
			{
				List<String> value = map.get(cldeiid);
				if (!value.contains(pareiid))
				{
					value.add(pareiid);
				}

			}
			else
			{
				List<String> value = new ArrayList<String>();
				value.add(pareiid);
				map.put(cldeiid, value);
			}
		}
		return map;
	}

	/**
	 * ȡ�����ڱ�ɫ��Mapӳ��
	 * 
	 * @return
	 */
	public Map<String, List<String>> getHost_AppMaping(
			List<SOC0141VW> app)
	{

		// �� ����Ϊ0 ������
		Map<String, List<String>> map = new HashMap<String, List<String>>();

		for (int i = 0; i < app.size(); i++)
		{
			SOC0141VW info = app.get(i);
			String pareiid = info.getSrpareiid().toString();
			String cldeiid = info.getSrcldeiid().toString();

			// ������� App �� Host ӳ��
			if (map.containsKey(pareiid))
			{
				List<String> value = map.get(pareiid);
				if (!value.contains(cldeiid))
				{
					value.add(cldeiid);
				}
			}
			else
			{
				List<String> value = new ArrayList<String>();
				value.add(cldeiid);
				map.put(pareiid, value);
			}
			// ������� Host �� App ӳ��
			if (map.containsKey(cldeiid))
			{
				List<String> value = map.get(cldeiid);
				if (!value.contains(pareiid))
				{
					value.add(pareiid);
				}
			}
			else
			{
				List<String> value = new ArrayList<String>();
				value.add(pareiid);
				map.put(cldeiid, value);
			}
		}
		return map;
	}

	/**
	 * ����Ӧ��XML
	 * 
	 * @param cond
	 * @return
	 * @throws Exception
	 */
	public String createAppXml(SOC0121SearchCond cond)
			throws Exception
	{
		List<SOC0141VW> snapshotRelationInfoList = this.soc0121BL
				.searchSnapshotEntityVW(cond);
		StringBuffer strXml = new StringBuffer();
		strXml.append("<?xml version=1.0 encoding=UTF-8?><ROOT>");
		for (int i = 0; i < snapshotRelationInfoList.size(); i++)
		{
			SOC0141VW info = snapshotRelationInfoList.get(i);
			strXml.append("<appitem label='" + info.getSrpareiname()
					+ "' value='" + info.getSrpareiid() + "' version ='"
					+ info.getSrparversion() + "' smallversion = '"
					+ info.getSrparsmallversion() + "' />");
		}
		strXml.append("</ROOT>");
		return strXml.toString();
	}

	/**
	 * ����MetaXML
	 * 
	 * @param cond
	 * @return
	 * @throws Exception
	 */
	public String createMetaXml(SOC0121SearchCond cond, String symid)
			throws Exception
	{
		List<SOC0141VW> snapshotRelationInfoList = this.soc0121BL
				.searchSnapshotEntityVW(cond);
		StringBuffer strXml = new StringBuffer();
		strXml.append("<?xml version=1.0 encoding=UTF-8?><ROOT>");
		for (int i = 0; i < snapshotRelationInfoList.size(); i++)
		{
			SOC0141VW info = snapshotRelationInfoList.get(i);
			if (info.getSrcldeilabel().contains(symid))
			{
				strXml.append("<metaitem label='" + info.getSrcldeiname()
						+ "' value='" + info.getSrcldeiid() + "' version ='"
						+ info.getSrcldversion() + "' smallversion = '"
						+ info.getSrcldsmallversion() + "' />");
			}
		}
		strXml.append("</ROOT>");
		return strXml.toString();
	}

	/**
	 * ����MetaXML
	 * 
	 * @param cond
	 * @return
	 * @throws Exception
	 */
	public String createXml(SOC0121SearchCond meta_diskcond,
			SOC0121SearchCond storage_Dacond,
			SOC0121SearchCond host_facond, String strStorageEilabel)
			throws Exception
	{
		List<SOC0140VW> DiskList = this.soc0121BL
				.searchDiskFromSnapshotEntityVW(meta_diskcond);
		List<String> FaList = this.soc0121BL
				.searchFaFromSnapshotEntityVW(host_facond, strStorageEilabel);
		List<String> DaCpuList = getCpubyDisk(DiskList);
		List<String> DaCardList = getCardbyDisk(DiskList);
		List<String> FaCpu = getCpu(FaList);
		List<String> FaCard = getCard(FaList);
		StringBuffer strXml = new StringBuffer();
		strXml.append("<?xml version=1.0 encoding=UTF-8?><ROOT>");
		// Disk
		for (int i = 0; i < DiskList.size(); i++)
		{
			strXml.append("<UNIT eiid ='" + DiskList.get(i).getEiid()
					+ "' version ='" + DiskList.get(i).getVersion()
					+ "' smallversion='" + DiskList.get(i).getSmallversion()
					+ "' show='" + DiskList.get(i).getCivalue() + "'>"
					+ parseHexString(DiskList.get(i).getCivalue()) + "</UNIT>");
		}
		// Da card
		for (int i = 0; i < DaCardList.size(); i++)
		{
			strXml
					.append("<UNIT eiid ='' version = ''  smallversion = '' show='"
							+ DaCardList.get(i)
							+ "'>"
							+ DaCardList.get(i)
							+ "</UNIT>");
		}
		// Da Cpu
		for (int i = 0; i < DaCpuList.size(); i++)
		{
			strXml
					.append("<UNIT eiid ='' version = ''  smallversion = '' show='"
							+ DaCpuList.get(i)
							+ "'>"
							+ DaCpuList.get(i)
							+ "</UNIT>");
		}
		// Fa port
		for (int i = 0; i < FaList.size(); i++)
		{
			strXml
					.append("<UNIT eiid ='' version = ''  smallversion = '' show='"
							+ FaList.get(i) + "'>" + FaList.get(i) + "</UNIT>");
		}
		// Fa card
		for (int i = 0; i < FaCard.size(); i++)
		{
			strXml
					.append("<UNIT eiid ='' version = ''  smallversion = '' show='"
							+ FaCard.get(i) + "'>" + FaCard.get(i) + "</UNIT>");
		}
		// Fa Cpu
		for (int i = 0; i < FaCpu.size(); i++)
		{
			strXml
					.append("<UNIT eiid ='' version = ''  smallversion = '' show='"
							+ FaCpu.get(i) + "'>" + FaCpu.get(i) + "</UNIT>");
		}
		strXml.append("</ROOT>");
		return strXml.toString();
	}
	/**
	 * ����DiskXML
	 * 
	 * @param cond
	 * @return
	 * @throws Exception
	 */
	public String createDiskXml(SOC0121SearchCond meta_diskcond,
			SOC0121SearchCond host_Diskcond,
			SOC0121SearchCondImpl app_hostcond) throws Exception
	{
		List<SOC0141VW> metaList = this.soc0121BL
				.searchSnapshotEntityVW(meta_diskcond);
		List<SOC0141VW> hostList = this.soc0121BL
				.searchSnapshotEntityVW(host_Diskcond);
		List<SOC0141VW> appList = getAppList(app_hostcond, hostList);
		StringBuffer strXml = new StringBuffer();
		strXml.append("<?xml version=1.0 encoding=UTF-8?><ROOT>");
		for (int i = 0; i < metaList.size(); i++)
		{
			SOC0141VW info = metaList.get(i);
			strXml.append("<metaitem einame='" + info.getSrpareiname()
					+ "' eilabel = '" + info.getSrpareilabel() + "' />");
		}
		for (int i = 0; i < hostList.size(); i++)
		{
			SOC0141VW info = hostList.get(i);
			strXml.append("<hostitem einame='" + info.getSrpareiname()
					+ "' eilabel = '" + info.getSrpareilabel() + "' />");
		}
		List<Integer> appeiid = new ArrayList<Integer>();
		for (int i = 0; i < appList.size(); i++)
		{
			SOC0141VW info = appList.get(i);
			if (!appeiid.contains(info.getSrpareiid()))
			{
				strXml.append("<appitem einame='" + info.getSrpareiname()
						+ "' eilabel = '" + info.getSrpareilabel() + "' />");
				appeiid.add(info.getSrpareiid());
			}
		}
		strXml.append("</ROOT>");
		return strXml.toString();
	}

	/**
	 * ת����ʽ
	 * 
	 * @param value
	 * @return
	 */
	public String parseHexString(String value)
	{

		String str1 = value.substring(0, 4);
		String str2 = value.substring(4);
		int int3 = Integer.parseInt(str2, 16);
		return str1 + int3;
	}

	/**
	 * ȡ���cpuʹ����
	 * 
	 * @param behindCPUBusy
	 * @return
	 */
	public List<String> getCpu(List<String> diskList)
	{

		List<String> card = new ArrayList<String>();
		for (int i = 0; i < diskList.size(); i++)
		{
			String info = diskList.get(i);
			if (!card.contains(info.substring(0, 3)))
			{
				card.add(info.substring(0, 3));
			}
		}
		return card;
	}

	/**
	 * ȡ���cpuʹ����
	 * 
	 * @param behindCPUBusy
	 * @return
	 */
	public List<String> getCard(List<String> diskList)
	{

		List<String> card = new ArrayList<String>();
		for (int i = 0; i < diskList.size(); i++)
		{
			String info = diskList.get(i);
			if (!card.contains(info.substring(0, 2)))
			{
				card.add(info.substring(0, 2));
			}
		}
		return card;
	}

	/**
	 * ȡ���cpuʹ����
	 * 
	 * @param behindCPUBusy
	 * @return
	 */
	public List<String> getCpubyDisk(List<SOC0140VW> diskList)
	{

		List<String> card = new ArrayList<String>();
		for (int i = 0; i < diskList.size(); i++)
		{
			SOC0140VW info = diskList.get(i);
			if (!card.contains(info.getCivalue().substring(0, 3)))
			{
				card.add(info.getCivalue().substring(0, 3));
			}
		}
		return card;
	}

	/**
	 * ȡ���cpuʹ����
	 * 
	 * @param behindCPUBusy
	 * @return
	 */
	public List<String> getCardbyDisk(List<SOC0140VW> diskList)
	{

		List<String> card = new ArrayList<String>();
		for (int i = 0; i < diskList.size(); i++)
		{
			SOC0140VW info = diskList.get(i);
			if (!card.contains(info.getCivalue().substring(0, 2)))
			{
				card.add(info.getCivalue().substring(0, 2));
			}
		}
		return card;
	}

	/**
	 * ȡ���CPU
	 * 
	 * @param args
	 */
	public List<String> getBehindInterfaceCardVWInfo(List<String> diskList)
	{

		List<String> card = new ArrayList<String>();
		for (int i = 0; i < diskList.size(); i++)
		{
			String info = diskList.get(i);
			if (!card.contains(info.substring(0, 2)))
			{
				card.add(info.substring(0, 2));
			}
		}
		return card;
	}

	/**
	 * ��ȡӦ��
	 */
	public List<SOC0141VW> getAppList(
			SOC0121SearchCondImpl app_hostcond,
			List<SOC0141VW> hostList)
	{
		List<SOC0141VW> app = new ArrayList<SOC0141VW>();
		for (int i = 0; i < hostList.size(); i++)
		{
			app_hostcond.setSrcldeiid_eq(hostList.get(i).getSrpareiid()
					.toString());
			app_hostcond.setSrcldversion_eq(hostList.get(i).getSrparversion()
					.toString());
			app_hostcond.setSrcldsmallversion_eq(hostList.get(i)
					.getSrparsmallversion().toString());
			List<SOC0141VW> appList = this.soc0121BL
					.searchSnapshotEntityVW(app_hostcond);
			app.addAll(appList);
		}
		return app;
	}

	/**
	 * Ϊport �� eiids ��ֵ
	 * 
	 * @param port
	 * @param switchMap
	 */
	private void setEiidsForPort(List<SOC0132VW> port,
			Map<String, List<String>> switchMap)
	{
		for (int i = 0; i < port.size(); i++)
		{
			List<String> cldEiids = switchMap.get(port.get(i).getEiid()
					.toString());
			StringBuffer eiids = new StringBuffer();
			if (cldEiids != null)
			{
				for (int j = 0; j < cldEiids.size(); j++)
				{
					if (j > 0)
					{
						eiids.append(";");
					}
					eiids.append(cldEiids.get(j));
				}
				port.get(i).setEiids(eiids.toString());
			}
		}
	}

	/**
	 * ΪZone�� eiids ��ֵ
	 * 
	 * @param port
	 * @param switchMap
	 */
	private void setEiidsForZone(List<SOC0133VW> zone,
			Map<String, List<String>> switchMap)
	{
		for (int i = 0; i < zone.size(); i++)
		{
			List<String> cldEiids = switchMap.get(zone.get(i).getEiid()
					.toString());
			StringBuffer eiids = new StringBuffer();
			if (cldEiids != null)
			{
				for (int j = 0; j < cldEiids.size(); j++)
				{
					if (j > 0)
					{
						eiids.append(";");
					}
					eiids.append(cldEiids.get(j));
				}
				zone.get(i).setEiids(eiids.toString());
			}
		}
	}
	
	/**
	 * ������Ϣ��ʷ��¼������ڻ�����
	 * 
	 * @param dto
	 *            IGCOM03DTO
	 * @return IGCOM03DTO
	 */
	public IGCOM03DTO initIGCIM0147Action(IGCOM03DTO dto) throws BLException
	{
		log.debug("========������Ϣ��ʷ��¼������ڻ�����ʼ========");

		// ��Ϣ����
		SOC0124Info entityItemVWInfo = this.soc0118BL
				.searchEntityItemVWByKey(Integer.parseInt(dto.getIgcim0147Form().getEiid()));

		if (entityItemVWInfo == null)
		{
			throw new BLException("IGCO10000.E004", "");
		}

		if (entityItemVWInfo.getEiversion() == 0)
		{
			dto.addMessage(new ActionMessage("IGASM0205.W001"));
		}

		if (StringUtils.isEmpty(dto.getIgcim0147Form().getCiversion()))
		{
			dto.getIgcim0147Form().setCiversion(
					entityItemVWInfo.getEiversion() + "");
		}
		// �жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(),
				entityItemVWInfo);

		if (!flag)
		{
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}
		else
		{
			dto.setFlag(flag);
		}
		
		// ������Ϣ��ѯ����ȡ��
		//int totalCount = this.soc0107BL.getSOC0107SearchCount(dto.getIgcim0147Form());
		String esyscoding = entityItemVWInfo.getEsyscoding();
		dto.getIgcim0147Form().setEsyscoding_q(esyscoding);
		//����ʲ����鸸������
		//�Ƿ�ɼ̳б�ʶ��ʹ��entity����Ԥ���ֶ�EKEY2, 0����̳У�1�����̳�
		if (esyscoding.startsWith(CommonDefineUtils.ENTIY_CATEGORY_SOFTWARE_SYSCODING)) {
			dto.getIgcim0147Form().setEkey2("1");
		} 
		//�豸�ʲ��鸸������
		else if (esyscoding.startsWith(CommonDefineUtils.ENTIY_CATEGORY_SOFTWARE_SYSCODING)) {
			dto.getIgcim0147Form().setEkey2("0");
		}
		//�豸������Ϣ��ѯ����ȡ�� 
		int totalCount = this.soc0107BL.getConfigItemVWSearchCount(dto.getIgcim0147Form());
		
		if (totalCount == 0)
		{
			log.debug("========��ѯ���ݲ�����========");
			// ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I007", 0));
			return dto;
		}

		// ������Ϣȫ������
//		List<SOC0107Info> configItemList = this.soc0107BL.searchSOC0107(
//				dto.getIgcim0147Form(), 0, 0);
//		Map<String, List<SOC0107Info>> map = new LinkedHashMap<String, List<SOC0107Info>>();
//		for (SOC0107Info e : configItemList)
//		{
//			if (!map.containsKey(e.getConfiguration().getCcategory()))
//			{
//				map.put(e.getConfiguration().getCcategory(),
//						new ArrayList<SOC0107Info>());
//			}
//			map.get(e.getConfiguration().getCcategory()).add(e);
//		}
//		map = new MapKeySort<List<SOC0107Info>>().sort(map,false);
//		dto.setSoc0107InfoMap(map);
		
		List<SOC0129Info> configItemVWInfoList = this.soc0107BL.searchConfigItemVW(dto.getIgcim0147Form());
		Map<String, List<SOC0129Info>> map = new LinkedHashMap<String, List<SOC0129Info>>();
		for (SOC0129Info e : configItemVWInfoList)
		{
			if (!map.containsKey(e.getCcategory()))
			{
				map.put(e.getCcategory(),
						new ArrayList<SOC0129Info>());
			}
			map.get(e.getCcategory()).add(e);
		}
		dto.setSoc0129InfoVWMap(map);
		dto.setSoc0124Info(entityItemVWInfo);
		
		//��ȡ��ʷ�汾����ʱ��
		if(entityItemVWInfo.getEiversion() > 0) {
			dto.setConfigItemVersionTime(this.soc0118BL.searchVersionUpdateTime(entityItemVWInfo.getEiid()));
		}else{
			dto.setConfigItemVersionTime(new ArrayList<SOC0128Info>());
		}
		
		log.debug("========������Ϣ��ʷ��¼������ڻ���������========");
		return dto;
	}

	public static void main(String[] args)
	{
		IGCOM03BLImpl a = new IGCOM03BLImpl();
		System.out.println(a.parseHexString("15ADD") + "");
		System.out.println("15ADD".substring(0, 2));
	}

	public IGCOM03DTO getEsyscodingList(IGCOM03DTO dto) throws BLException {
		List<LabelValueBean> lvList = new ArrayList<LabelValueBean>();
		lvList.add(new LabelValueBean("",""));
		dto.setEsyscodingList(lvList);
		IGCOM0329Form form = dto.getIgcom0329Form();
		String eirrelation = form.getEirrelation();
		if (StringUtils.isEmpty(eirrelation)) {
			return dto;
		}
		CodeDetailSearchCondImpl condimpl = new CodeDetailSearchCondImpl();
	    condimpl.setCcid(CodeDefine.EIRRELATION.getCcid());
	    condimpl.setCdinfo_eq(form.getEirrelation());
		List<CodeDetail> clist=this.codeDetailBL.searchCodeDetail(condimpl, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
		if(clist!=null&&clist.size()>0){
			for(CodeDetail cd:clist){
				lvList.add(new LabelValueBean(cd.getCvalue(),cd.getSyscoding()));
			}
		}
		return dto;
	}

	/**
	 * �豸��Ϣ��ѯ����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCOM03DTO searchSOC0118(IGCOM03DTO dto) throws BLException {

		log.debug("========�豸��Ϣ��ѯ����ʼ========");
		
		//�豸��Ϣ��ѯ����ȡ�� 
		SOC0124SearchCond entityItemVWSearchCond = dto.getSoc0214SearchCond();
		String esyscoding = entityItemVWSearchCond.getEsyscoding();
		String einame = entityItemVWSearchCond.getEiname();
		String eiupdtime_from = entityItemVWSearchCond.getEiupdtime_from();
		String eiupdtime_to = entityItemVWSearchCond.getEiupdtime_to();
		Integer eirootmark_eq = entityItemVWSearchCond.getEirootmark_eq();
		
		SOC0118SearchCondImpl cond = new SOC0118SearchCondImpl();
		cond.setEsyscoding_eq(esyscoding);
		cond.setEiname(einame);
		cond.setEiupdtime_from(eiupdtime_from);
		cond.setEirootmark(eirootmark_eq);
		
		if (StringUtils.isNotEmpty(eiupdtime_to)) {
			cond.setEiupdtime_to(eiupdtime_to + " 23:59");
		}
		int totalCount = soc0118BL.getEntityItemSearchCount(cond);
		
		if (totalCount == 0) {
			log.debug("========�豸��Ϣ��ѯ���ݲ�����========");
			//�豸��Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========�豸��Ϣ��ѯ���ݼ�������========");
			//�豸��Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();

		//��ǰҳ�豸��Ϣȡ��
		List<SOC0118Info> soc0118List = this.soc0118BL.searchEntityItem(cond, pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setEntityItemList(soc0118List);

		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========�豸��Ϣ��ѯ��������========");
		return dto;
	}
}
