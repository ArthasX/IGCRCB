package com.deliverik.infogovernor.drm.bl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;
import org.springframework.beans.BeanUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.office.word.WordDocument;
import com.deliverik.framework.office.word.XMLWordDocument;
import com.deliverik.framework.office.word.file.Image;
import com.deliverik.framework.office.word.model.Color;
import com.deliverik.framework.office.word.model.Paragraph;
import com.deliverik.framework.office.word.model.Run;
import com.deliverik.framework.office.word.table.Cell;
import com.deliverik.framework.office.word.table.Row;
import com.deliverik.framework.office.word.table.Table;
import com.deliverik.framework.office.word.utils.Align;
import com.deliverik.framework.office.word.utils.BreakType;
import com.deliverik.framework.office.word.utils.VerticalAlign;
import com.deliverik.framework.soc.asset.bl.task.SOC0117BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0117VWBL;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0118VWBL;
import com.deliverik.framework.soc.asset.bl.task.SOC0119BL;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.framework.soc.asset.model.SOC0117VWInfo;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0118VWInfo;
import com.deliverik.framework.soc.asset.model.SOC0119Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0117SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0118SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0118VWSearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0119SearchCondImpl;
import com.deliverik.framework.soc.asset.model.entity.SOC0117VWPK;
import com.deliverik.framework.soc.asset.model.entity.SOC0118TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0119TB;
import com.deliverik.framework.user.bl.task.OrganizationBL;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.UserInfo;
import com.deliverik.framework.user.model.condition.OrganizationSearchCondImpl;
import com.deliverik.framework.user.model.condition.UserInfoSearchCondImpl;
import com.deliverik.framework.user.model.entity.OrganizationTB;
import com.deliverik.framework.user.model.entity.UserInfoVW;
import com.deliverik.framework.user.model.entity.UserTB;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.prd.model.IG222Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG560Info;
import com.deliverik.framework.workflow.prd.model.condition.IG222SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG560SearchCondImpl;
import com.deliverik.infogovernor.drm.IGDRMCONSTANTS;
import com.deliverik.infogovernor.drm.bl.task.PlanBL;
import com.deliverik.infogovernor.drm.bl.task.SOC0507BL;
import com.deliverik.infogovernor.drm.bl.task.SOC0509BL;
import com.deliverik.infogovernor.drm.bl.task.SpecialPlanBL;
import com.deliverik.infogovernor.drm.dto.IGDRM01DTO;
import com.deliverik.infogovernor.drm.dto.IGDRM10DTO;
import com.deliverik.infogovernor.drm.dto.IGDRM21DTO;
import com.deliverik.infogovernor.drm.form.IGDRM2101Form;
import com.deliverik.infogovernor.drm.form.IGDRM2102Form;
import com.deliverik.infogovernor.drm.form.IGDRM2103Form;
import com.deliverik.infogovernor.drm.form.IGDRM2104Form;
import com.deliverik.infogovernor.drm.form.IGDRM2105Form;
import com.deliverik.infogovernor.drm.form.IGDRM2108Form;
import com.deliverik.infogovernor.drm.model.PlanInfo;
import com.deliverik.infogovernor.drm.model.SOC0507Info;
import com.deliverik.infogovernor.drm.model.SOC0509Info;
import com.deliverik.infogovernor.drm.model.condition.PlanSearchCondImpl;
import com.deliverik.infogovernor.drm.model.condition.SOC0507SearchCondImpl;
import com.deliverik.infogovernor.drm.model.condition.SOC0509SearchCondImpl;
import com.deliverik.infogovernor.drm.model.condition.SpecialPlanSearchCondImpl;
import com.deliverik.infogovernor.drm.model.entity.SOC0507TB;
import com.deliverik.infogovernor.drm.model.entity.SOC0509TB;
import com.deliverik.infogovernor.drm.util.ComputingTime;
import com.deliverik.infogovernor.drm.util.FlowDetail;
import com.deliverik.infogovernor.drm.util.WordUtils;
import com.google.gson.Gson;

/**
 * ����: ��������: ������¼: �޸ļ�¼:
 */
public class IGDRM21BLImpl extends BaseBLImpl implements IGDRM21BL {

	static Log log = LogFactory.getLog(IGDRM21BLImpl.class);

	private SOC0118BL soc0118BL;

	private OrganizationBL organizationBL;

	private SOC0509BL soc0509BL;

	private SOC0507BL soc0507BL;

	private SOC0117BL soc0117BL;

	private SOC0119BL soc0119BL;

	private SOC0117VWBL soc0117VWBL;

	private SOC0118VWBL soc0118VWBL;

	private IGDRM01BL igdrm01BL;

	private IGDRM10BL igdrm10BL;
	
	/** ���̶���BL */
	protected WorkFlowDefinitionBL workFlowDefinitionBL;
	
	/** �û�BL */
	protected UserBL userBL;
	
	/** ר��Ԥ��BL */
	protected SpecialPlanBL specialPlanBL;

	public void setIgdrm10BL(IGDRM10BL igdrm10bl) {
		igdrm10BL = igdrm10bl;
	}

	public void setIgdrm01BL(IGDRM01BL igdrm01bl) {
		igdrm01BL = igdrm01bl;
	}

	/** PlanBL���� */
	protected PlanBL planBL;

	public void setSoc0118BL(SOC0118BL soc0118BL) {
		this.soc0118BL = soc0118BL;
	}

	public void setSoc0117BL(SOC0117BL soc0117bl) {
		soc0117BL = soc0117bl;
	}

	public void setSoc0509BL(SOC0509BL soc0509bl) {
		soc0509BL = soc0509bl;
	}

	public void setOrganizationBL(OrganizationBL organizationBL) {
		this.organizationBL = organizationBL;
	}

	public void setPlanBL(PlanBL planBL) {
		this.planBL = planBL;
	}

	public void setSoc0507BL(SOC0507BL soc0507bl) {
		soc0507BL = soc0507bl;
	}

	public void setSoc0119BL(SOC0119BL soc0119bl) {
		soc0119BL = soc0119bl;
	}

	public void setSoc0117VWBL(SOC0117VWBL soc0117vwbl) {
		soc0117VWBL = soc0117vwbl;
	}

	public void setSoc0118VWBL(SOC0118VWBL soc0118vwbl) {
		soc0118VWBL = soc0118vwbl;
	}

	/**
	 * ���̶���BL�趨
	 * @param workFlowDefinitionBL ���̶���BL
	 */
	public void setWorkFlowDefinitionBL(WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}

	/**
	 * �û�BL�趨
	 * @param userBL �û�BL
	 */
	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
	}

	/**
	 * ר��Ԥ��BL�趨
	 * @param specialPlanBL ר��Ԥ��BL
	 */
	public void setSpecialPlanBL(SpecialPlanBL specialPlanBL) {
		this.specialPlanBL = specialPlanBL;
	}

	public IGDRM21DTO searchEntityItemLableAction(IGDRM21DTO dto)
			throws BLException {

		log.debug("========��ȡ�豸������ֵ����ʼ========");

		IGDRM2101Form form = (IGDRM2101Form) dto.getForm();

		SOC0118SearchCondImpl cond = new SOC0118SearchCondImpl();

		cond.setEilabel(CommonDefineUtils.ENTIY_CATEGORY_PLAN_KEY
				+ IGStringUtils.getCurrentYear().substring(2));

		String eilabel = this.soc0118BL.searchNextEntityItemLable(cond);

		form.setEilabel(eilabel);

		log.debug("========��ȡ�豸������ֵ��������========");

		return dto;
	}

	public IGDRM21DTO insertEntityItemAction(IGDRM21DTO dto)
			throws BLException {

		log.debug("========�豸��Ϣ�ǼǴ���ʼ========");
		// ����Formȡ��
		IGDRM2101Form form = (IGDRM2101Form) dto.getForm();

		form.setEidStr(form.getEid().toString());

		// ����ʱ���趨

		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

		form.setEiupdtime(datetime);

		// ��汾�趨���̶���Ϊ1��
		form.setEiversion(1);

		// С�汾�趨���̶���Ϊ0��
		form.setEismallversion(0);

		SOC0118TB entityItemTB = soc0118BL.getEntityItemTBInstance();
		this.copyProperties(entityItemTB, form);
		entityItemTB.setFingerPrint(form.getFingerPrint());
		// �豸��Ϣ��¼
		SOC0118Info soc0118Info = this.soc0118BL.registEntityItem(entityItemTB);
		if (form.getEiids() != null && form.getEiids().length > 0) {
			for (int i = 0; i < form.getEiids().length; i++) {
				// ���Ԥ����ҵ��ϵͳ�Ĺ�ϵ
				SOC0119TB soc0119tb = soc0119BL
						.getEntityItemRelationTBInstance();
				soc0119tb.setPareid(soc0118Info.getEid());
				soc0119tb.setPareiid(soc0118Info.getEiid());
				soc0119tb.setCldeid(form.getEids()[i]);
				soc0119tb.setCldeiid(Integer.parseInt(form.getEiids()[i]));
				soc0119tb.setEirrelation("03");
				soc0119tb.setEirrelationcode("080-040");
				soc0119tb.setEirupdtime(datetime);
				soc0119tb.setParversion(1);
				soc0119tb.setParsmallversion(0);
				soc0119tb.setEirdesc(form.getIds()[i]);
				soc0119tb
						.setCldversion(Integer.parseInt(form.getEiversions()[i]));
				soc0119tb.setCldsmallversion(0);
				soc0119tb.setDeleteflag("0");
				soc0119BL.registEntityItemRelation(soc0119tb);
			}
		}

		form.setEiidStr(soc0118Info.getEiid().toString());

		dto.setForm(form);

		dto.addMessage(new ActionMessage("IGCO10000.I004", "Ԥ��������Ϣ"));

		log.debug("========�豸��Ϣ�ǼǴ�������========");
		return dto;

	}

	public IGDRM21DTO initPlanInfo4Create(IGDRM21DTO dto) throws BLException {
		log.debug("========�豸������Ϣ�༭������ڻ�����ʼ========");

		IGDRM2102Form form = (IGDRM2102Form) dto.getForm();

		// �豸��Ϣ����
		SOC0124Info entityItemVWInfo = this.soc0118BL
				.searchEntityItemVWByKey(Integer.parseInt(form.getEiid()));

		if (entityItemVWInfo == null) {
			throw new BLException("IGCO10000.E004", "Ԥ��");
		}

		form.setEidesc(entityItemVWInfo.getEidesc());
		form.setEistatus(entityItemVWInfo.getEistatus());
		form.setEmodeltype(entityItemVWInfo.getEmodeltype());
		String eiorgsyscoding = entityItemVWInfo.getEiorgsyscoding();
		form.setEiorgsyscoding(eiorgsyscoding);
		form.setEsyscoding_q(entityItemVWInfo.getEsyscoding());
		if (!StringUtils.isEmpty(eiorgsyscoding)) {
			OrganizationSearchCondImpl OrgCond = new OrganizationSearchCondImpl();
			OrgCond.setOrgsyscoding(eiorgsyscoding);
			List<Organization> orgList = this.organizationBL
					.searchOrganization(OrgCond, 0, 0);
			for (int i = 0; i < orgList.size(); i++) {
				form.setEiorgname(orgList.get(0).getOrgname());
			}
		}
		dto.setEntityItemVWInfo(entityItemVWInfo);
		dto.setEiorgname(form.getEiorgname());
		// �жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(),
				entityItemVWInfo);

		if (!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		} else {
			dto.setFlag(flag);
		}
		return dto;
	}

	public IGDRM21DTO getPlanSectionTree(IGDRM21DTO dto) throws BLException {
		// ��ȡ����ʵ��
		IGDRM2102Form form = (IGDRM2102Form) dto.getForm();
		SOC0118Info soc0118Info = soc0118BL.searchEntityItemByKey(Integer
				.parseInt(form.getEiid()));

		// ��ѯ�½���Ϣ
		SOC0509SearchCondImpl cond = new SOC0509SearchCondImpl();

		String esyscoding = soc0118Info.getEsyscoding();
		dto.setEsyscoding(esyscoding);
		cond.setEsyscoding(esyscoding);
		List<SOC0509Info> searchSOC0509 = soc0509BL.searchSOC0509(cond);

		// �����ڵ�
		if (searchSOC0509 == null || searchSOC0509.isEmpty()) {
			searchSOC0509 = new ArrayList<SOC0509Info>();
		}
		SOC0117SearchCondImpl entityCond = new SOC0117SearchCondImpl();
		int level = CommonDefineUtils.TREE_LEVEL_CODE;
		int ccid = CommonDefineUtils.CCID_LENGTH + level;
		List<String> esyscodingList = new ArrayList<String>();
		esyscodingList.add(esyscoding.substring(0, ccid));
		while (esyscoding.length() > ccid) {
			ccid = ccid + CommonDefineUtils.CCID_LENGTH;
			esyscodingList.add(esyscoding.substring(0, ccid));
		}
		entityCond.setEsyscodingList(esyscodingList);
		entityCond.setEparcoding_neq("888");
		List<SOC0117Info> searchEntity = soc0117BL.searchEntity(entityCond);
		for (SOC0117Info soc0117Info : searchEntity) {
			SOC0509TB soc0509TB = new SOC0509TB();
			soc0509TB.setCid("CI" + soc0117Info.getEsyscoding());
			if ("888001".equals(soc0117Info.getEparcoding())) {
				soc0509TB.setPcid("0");
			} else {
				soc0509TB.setPcid("CI" + soc0117Info.getEparcoding());
			}
			soc0509TB.setCname(soc0117Info.getEname());
			soc0509TB.setEid(soc0117Info.getEid());
			soc0509TB.setEsyscoding(soc0117Info.getEsyscoding());
			searchSOC0509.add(soc0509TB);
		}

		// �����½���
		dto.setPlanSectionTree(searchSOC0509);
		return dto;
	}

	public IGDRM21DTO searchPlan(IGDRM21DTO dto) throws BLException {
		IGDRM2104Form form = (IGDRM2104Form) dto.getForm();
		PlanSearchCondImpl cond = new PlanSearchCondImpl();
		BeanUtils.copyProperties(form, cond);
		// �豸��Ϣ��ѯ����ȡ��
		int totalCount = this.planBL.getSearchCount(cond);
		if (totalCount == 0) {
			log.debug("========Ԥ����ѯ���ݲ�����========");
			// Ԥ����ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("=======Ԥ����ѯ���ݼ�������========");
			// Ԥ����ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}
		// ��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();

		// ��ǰҳ�豸��Ϣȡ��
		List<PlanInfo> planList = this.planBL.findByCond(cond,
				pDto.getFromCount(), pDto.getPageDispCount());

		pDto.setTotalCount(totalCount);

		dto.setPlanList(planList);
		log.debug("========Ԥ����ѯ��������========");
		return dto;
	}

	public IGDRM21DTO savePlanInfo(IGDRM21DTO dto) throws BLException {
		IGDRM2104Form form = (IGDRM2104Form) dto.getForm();
		String[] eiids = form.getEiids();
		// ɾ���ɹ�ϵ
		SOC0119SearchCondImpl cond = new SOC0119SearchCondImpl();
		cond.setPareiid(Integer.parseInt(form.getEiid()));
		cond.setEirrelation("01");
		cond.setEirrelationcode("080-060");
		cond.setEirinfo(form.getCid());
		List<SOC0119Info> relationList = soc0119BL
				.searchEntityItemRelation(cond);
		if (relationList != null && !relationList.isEmpty()) {
			for (SOC0119Info soc0119Info : relationList) {
				soc0119BL.deleteEntityItemRelation(soc0119Info);
			}
		}
		if (eiids != null && eiids.length > 0) {
			// ������ϵ
			for (String eiid : eiids) {
				if(!eiid.isEmpty()){
					SOC0118Info soc0118Info = soc0118BL
							.searchEntityItemByKey(Integer.parseInt(eiid));
					SOC0119TB soc0119tb = soc0119BL
							.getEntityItemRelationTBInstance();
					soc0119tb.setPareid(form.getEid());
					soc0119tb.setPareiid(Integer.parseInt(form.getEiid()));
					soc0119tb.setCldeid(soc0118Info.getEid());
					soc0119tb.setCldeiid(soc0118Info.getEiid());
					soc0119tb.setEirrelation("01");
					soc0119tb.setEirrelationcode("080-"
							+ soc0118Info.getSoc0117TB().getEcategory());
					Date nowDateTime = new Date();
					String datetime = CommonDefineUtils.DATETIME_FORMAT
							.format(nowDateTime);
					soc0119tb.setEirupdtime(datetime);
					soc0119tb.setParversion(1);
					soc0119tb.setEirinfo(form.getCid());
					soc0119tb.setParsmallversion(0);
					soc0119tb.setCldversion(soc0118Info.getEiversion());
					soc0119tb.setCldsmallversion(soc0118Info.getEismallversion());
					soc0119tb.setDeleteflag("0");
					soc0119BL.registEntityItemRelation(soc0119tb);
				}
				
			}
		}
		return dto;
	}

	public IGDRM21DTO savePlanInfoContent(IGDRM21DTO dto) throws BLException {
		IGDRM2103Form form = (IGDRM2103Form) dto.getForm();
		String civalue = dto.getContent();
		SOC0507TB soc0507tb = soc0507BL.getSOC0507TBInstance();
		soc0507tb.setCivalue(civalue);
		soc0507tb.setCid(form.getCid());
		soc0507tb.setEid(form.getEid());
		soc0507tb.setEiid(Integer.parseInt(form.getEiid()));
		soc0507tb.setCiversion(1);
		soc0507tb.setCismallversion(0);
		soc0507tb.setEsyscoding(form.getEsyscoding());
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		soc0507tb.setCiupdtime(datetime);
		soc0507BL.registSOC0507(soc0507tb);
		return dto;
	}

	public IGDRM21DTO initUeditorInfo(IGDRM21DTO dto) throws BLException {
		IGDRM2103Form form = (IGDRM2103Form) dto.getForm();
		String cid = form.getCid();
		String eid = form.getEid();
		Integer eiid = Integer.parseInt(form.getEiid());
		SOC0507SearchCondImpl cond = new SOC0507SearchCondImpl();
		cond.setCid(cid);
		cond.setEid(eid);
		cond.setEiid(eiid);
		List<SOC0507Info> searchSOC0507 = soc0507BL.searchSOC0507(cond);
		if (searchSOC0507 != null && !searchSOC0507.isEmpty()) {
			SOC0507Info soc0507Info = searchSOC0507.get(0);
			dto.setSoc0507Info(soc0507Info);
			form.setCivalue(soc0507Info.getCivalue());
			form.setCiid(soc0507Info.getCiid());
		}
		return dto;
	}

	public IGDRM21DTO updatePlanInfoContent(IGDRM21DTO dto)
			throws BLException {
		Integer ciid = dto.getCiid();
		SOC0507Info soc0507Info = soc0507BL.searchSOC0507ByPK(ciid);
		SOC0507TB soc0507tb = (SOC0507TB) SerializationUtils.clone(soc0507Info);
		soc0507tb.setCivalue(dto.getContent());
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		soc0507tb.setCiupdtime(datetime);
		soc0507BL.updateSOC0507(soc0507tb);
		return dto;
	}

	public IGDRM21DTO initStoryboardInfo(IGDRM21DTO dto) throws BLException {
		IGDRM2103Form form = (IGDRM2103Form) dto.getForm();
		SOC0119SearchCondImpl cond = new SOC0119SearchCondImpl();
		cond.setPareiid(Integer.parseInt(form.getEiid()));
		cond.setEirrelation("01");
		cond.setDeleteflag("0");
		cond.setEirinfo(form.getCid());
		cond.setEirrelationcode("080-060");
		List<SOC0119Info> relationList = soc0119BL
				.searchEntityItemRelation(cond);
		List<PlanInfo> planList_new = new ArrayList<PlanInfo>();
		for (SOC0119Info soc0119Info : relationList) {
			PlanSearchCondImpl planCond = new PlanSearchCondImpl();
			planCond.setEiid(soc0119Info.getCldeiid());
			List<PlanInfo> palnList = planBL.findByCond(planCond, 0, 0);
			if (palnList != null && !palnList.isEmpty()) {
				planList_new.add(palnList.get(0));
			}
		}
		dto.setPlanList(planList_new);
		return dto;
	}

	public IGDRM21DTO searchEntityDisp(IGDRM21DTO dto) throws BLException {

		log.debug("========�豸��Ϣ��ѯ����ʼ========");
		// ��ȡform
		IGDRM2101Form form = (IGDRM2101Form) dto.getForm();
		String esyscoding = form.getEsyscoding();
		// ��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();
		SOC0117VWInfo s117Info = soc0117VWBL.searchEntityByKey(new SOC0117VWPK(
				Integer.parseInt(esyscoding.split("_")[0]), esyscoding
						.split("_")[1]));
		form.setEname(s117Info.getEname());
		form.setEsyscoding(esyscoding);
		// �豸��Ϣ��ѯ����ȡ��
		SOC0118VWSearchCondImpl cond = new SOC0118VWSearchCondImpl();
		cond.setId(Integer.parseInt(esyscoding.split("_")[0]));
		cond.setEsyscoding_like(esyscoding.split("_")[2]);
		if(StringUtils.isNotEmpty(form.getEiname()))cond.setEiname(form.getEiname());
		if(StringUtils.isNotEmpty(form.getEiupdtime_from()))cond.setEiinsdate_gt(form.getEiupdtime_from());
		if(StringUtils.isNotEmpty(form.getEiupdtime_to()))cond.setEiinsdate_lt(form.getEiupdtime_to());
		int totalCount = this.soc0118VWBL.getEntityItemSearchCount(cond);
		if (totalCount == 0) {
			log.debug("========�ʲ���Ϣ��ѯ���ݲ�����========");
			// �ʲ���Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}

		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========�ʲ���Ϣ��ѯ���ݼ�������========");
			// �ʲ���Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}
		List<SOC0118VWInfo> entityItemVWInfoList = this.soc0118VWBL
				.searchEntityItem(cond, pDto.getFromCount(),
						pDto.getPageDispCount());

		pDto.setTotalCount(totalCount);

		dto.setEntityItemVWInfoList(entityItemVWInfoList);
		dto.setForm(form);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));

		log.debug("========�豸��Ϣ��ѯ��������========");
		return dto;
	}

	public IGDRM21DTO viewStoryboardInfo(IGDRM21DTO dto) throws BLException {

		return dto;
	}
	
	/**
	 * ר��Ԥ����ѯ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM21DTO searchSpecialPlanAction(IGDRM21DTO dto) throws BLException {
		log.debug("===================ר��Ԥ����ѯ������ʼ===================");
		//ʵ������ѯ����
		SpecialPlanSearchCondImpl cond = new SpecialPlanSearchCondImpl();
		this.copyProperties(cond, dto.getForm());
		int totalCount = specialPlanBL.getSearchCount(cond);
		if (totalCount == 0) {
			log.debug("========��ѯ���ݲ�����========");
			// ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========��ѯ���ݼ�������========");
			// ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto.getMaxSearchCount(), totalCount));
			return dto;
		}
		PagingDTO pDto = dto.getPagingDto();
		List<SOC0118VWInfo> list = specialPlanBL.search(cond, pDto.getFromCount(), pDto.getPageDispCount());
		dto.setSoc0118VWList(list);
		pDto.setTotalCount(totalCount);
		log.debug("===================ר��Ԥ����ѯ��������===================");
		return dto;
	}

	/**
	 * ��ʼ�������ĵ�ģ����Ϣ
	 */
	public IGDRM21DTO initSoc0118EditInfo(IGDRM21DTO dto) throws BLException {
		log.debug("===============��ʼ�������ĵ�ģ����Ϣ================");
		IGDRM2101Form form = (IGDRM2101Form) dto.getForm();

		// ��ѯ�ʲ���Ϣ
		Integer eiid = form.getEiid();
		SOC0118Info soc0118 = soc0118BL.searchEntityItemByKey(eiid);
		this.copyProperties(form, soc0118);
		
		// ��ѯģ������
		String eid = form.getEid();
		SOC0117Info soc0117 = soc0117BL.searchEntityByKey(eid);
		form.setEname(soc0117.getEname());
		
		// ��ѯ��������
		String orgSysc = soc0118.getEiorgsyscoding();
		OrganizationSearchCondImpl orgCond = new OrganizationSearchCondImpl();
		orgCond.setOrgsyscoding(orgSysc);
		List<Organization> orgs = organizationBL.searchOrganization(orgCond);
		log.debug("===============����ѯ��" + orgs.size() + "��������Ϣ================");
		if (orgs.size() > 0) {
			// ��ѯ������� �������ٸ������ѡ���һ��
			form.setEiorgname(orgs.get(0).getOrgname());
		} else {
			log.debug("===============δ�ҵ�orgsyscodingΪ'" + orgSysc
					+ "��'������Ϣ================");
			form.setEiorgname("<δ�ҵ�������Ϣ>");
		}

		// ��ѯ�ʲ���Ϣ
		SOC0119SearchCondImpl cond = new SOC0119SearchCondImpl();
		cond.setPareiid(eiid);
		// ��ѯ����
		cond.setEirrelationcode("080-040");
		
		List<SOC0119Info> soc0119List = soc0119BL
				.searchEntityItemRelation(cond);
		List<String> soc0119ListNames = new ArrayList<String>();
		log.debug("===============����ѯ��" + soc0119List.size()
				+ "���ʲ���Ϣ================");
		for (int i = 0; i < soc0119List.size(); i++) {
			SOC0119Info info = soc0119List.get(i);
			Integer pk = info.getCldeiid();
			SOC0118VWSearchCondImpl soc0118Cond = new SOC0118VWSearchCondImpl();
			soc0118Cond.setEiid(pk.toString());
			soc0118Cond.setId(Integer.valueOf(info.getEirdesc()));
			List<SOC0118VWInfo> vws = soc0118VWBL.searchEntityItem(soc0118Cond);
			if (null != vws && vws.size() > 0) {
				soc0119ListNames.add(vws.get(0).getEiname());
			} else {
				log.debug("===============δ�ҵ�eidΪ'" + pk
						+ "'���ʲ���Ϣ================");
				soc0119ListNames.add("<δ֪>");
			}
		}
		dto.setSoc0119List(soc0119List);
		dto.setSoc0119ListNames(soc0119ListNames);
		log.debug("===============��ʼ�������ĵ�ģ����Ϣ����================");
		return dto;
	}

	/**
	 * �����豸��Ϣ
	 */
	public IGDRM21DTO updateEntityItemAction(IGDRM21DTO dto)
			throws BLException {
		// ����Formȡ��
		IGDRM2101Form form = (IGDRM2101Form) dto.getForm();

		form.setEidStr(form.getEid().toString());

		// ����ʱ���趨
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

		form.setEiupdtime(datetime);

		// ��ѯʵ��
		Integer eiid = form.getEiid();
		SOC0118TB entityItem = (SOC0118TB) SerializationUtils.clone(soc0118BL
				.searchEntityItemByKey(eiid));

		/**** �����ֶ� ****/
		// Ԥ�����Ƹ���
		entityItem.setEiname(form.getEiname());
		// Ԥ������
		entityItem.setEidesc(form.getEidesc());
		// Ԥ���ؼ��� (����fingerPrint�洢)
		entityItem.setFingerPrint(form.getFingerPrint());

		// �豸��Ϣ����
		SOC0118Info soc0118Info = soc0118BL.updateEntityItem(entityItem);

		/**** ά���豸�б� ****/
		// ����ɾ�������Ѵ���豸�б�
		soc0119BL.delByEiid(eiid,"080-040");

		// Ȼ���µ��豸�б���µ�soc0119��
		if (form.getEiids() != null && form.getEiids().length > 0) {
			for (int i = 0; i < form.getEiids().length; i++) {
				// ���Ԥ����ҵ��ϵͳ�Ĺ�ϵ
				SOC0119TB soc0119tb = soc0119BL
						.getEntityItemRelationTBInstance();
				soc0119tb.setPareid(soc0118Info.getEid());
				soc0119tb.setPareiid(soc0118Info.getEiid());
				soc0119tb.setCldeid(form.getEids()[i]);
				soc0119tb.setCldeiid(Integer.parseInt(form.getEiids()[i]));
				soc0119tb.setEirrelation("03");
				soc0119tb.setEirrelationcode("080-040");
				soc0119tb.setEirupdtime(datetime);
				soc0119tb.setParversion(1);
				soc0119tb.setParsmallversion(0);
				soc0119tb.setEirdesc(form.getIds()[i]);
				soc0119tb
						.setCldversion(Integer.parseInt(form.getEiversions()[i]));
				soc0119tb.setCldsmallversion(0);
				soc0119tb.setDeleteflag("0");
				soc0119BL.registEntityItemRelation(soc0119tb);
			}
		}
		return dto;
	}

	public IGDRM21DTO deleteSelectedSoc0118(IGDRM21DTO dto)
			throws BLException {
		
		IGDRM2105Form form = (IGDRM2105Form) dto.getForm();
		
		Integer[] eiids = form.getSelectedEiids();
		soc0118BL.delByEiid(eiids);
		
		dto.addMessage(new ActionMessage("IGCO10000.I006", " Ԥ����Ϣ, "));
		
		return dto;
	}
	
	/**
	 * ר��Ԥ����������
	 * @param dto
	 * @return
	 * @throws BLException
	 * @throws IOException 
	 */
	public IGDRM21DTO exportSpecialPlanAction(IGDRM21DTO dto) throws BLException, IOException {
		log.debug("================ר��Ԥ������������ʼ================");
		if(dto.getForm() != null && dto.getForm() instanceof IGDRM2105Form){
			//����ȡ��
			IGDRM2105Form form = (IGDRM2105Form) dto.getForm();
			//���ɵ����ļ�
			String filename = generaterExportFile(form.getEiid());
			//�����ļ�
			downloadReportFileAction(filename, dto.getResponse());
		}
		log.debug("================ר��Ԥ��������������================");
		return dto;
	}
	
	/**
	 * ɾ���ļ����ļ���
	 * @param file �ļ����ļ���·��
	 * @return �Ƿ�ɾ���ɹ�
	 */
	private void deleteFileAndDir(File file){
		if(file.exists()){
			if(file.isDirectory()){
				for(File f:file.listFiles()){
					deleteFileAndDir(f);
				}
			}
			file.delete();
		}
	}

	private String generaterExportFile(Integer eiid) throws BLException, IOException {
		//��ѯר��Ԥ��
		SOC0118Info entity = soc0118BL.searchEntityItemByKey(eiid);
		//����ʱ���
		String key = IGStringUtils.getAttKey();
		//��ȡ�������ɸ�Ŀ¼
		String rootPath = ResourceUtility.getString("UPLOAD_FILE_ROOT_PATH");
		//ƴ���ļ�·��
		StringBuffer path = new StringBuffer(rootPath);
		//ƴ�ӱ���Ŀ¼
		path.append("temp");
		path.append(File.separator);
		path.append("drm");
		path.append(File.separator);
		//ɾ��ԭ����ʱ�ļ�
		File oldDir = new File(path.toString());
		deleteFileAndDir(oldDir);
		//ƴ��ʱ���
		path.append(key);
		path.append(File.separator);
		//�����ļ�Ŀ¼
		File file = new File(path.toString());
		if(!file.exists()){
			file.mkdirs();
		}
		path.append(entity.getEiname());
		path.append(".docx");
		//�ļ�ȫ·������
		String fullName = path.toString();
		//ʵ�����ĵ�����
		WordDocument document = new XMLWordDocument();
		document.createParagraph();
		document.createParagraph();
		document.createParagraph();
		document.createParagraph();
		document.createParagraph();
		//����һ��������ʽ
		WordUtils.getInstance().createStyle(document, "1", "heading 1", 1);
		//�㼶map
		Map<Integer, Boolean> level = new HashMap<Integer, Boolean>();
		level.put(1, true);
		//�����������
		Paragraph title = document.createParagraph();
		//�������ֶ��뷽ʽΪ���ж���
		title.setAlign(Align.CENTER);
		//���ô�ֱ����
		title.setVerticalAlign(VerticalAlign.TOP);
		//�����ĵ������
		Run titleRun = title.createRun();
		//�����ĵ����������
		titleRun.setText(entity.getEiname());
		//��������Ӵ�
		titleRun.setBold(true);
		//���������С - 30
		titleRun.setFontSize(60);
		//��������Ϊ����
		titleRun.setFontFamily("����");
		//�����и�-100
		titleRun.setTextPosition(100);
		
		document.createParagraph();
		document.createParagraph();
		document.createParagraph();
		document.createParagraph();
		document.createParagraph();
		document.createParagraph();
		document.createParagraph();
		document.createParagraph();
		document.createParagraph();
		document.createParagraph();
		document.createParagraph();
		document.createParagraph();
		document.createParagraph();
		document.createParagraph();
		document.createParagraph();
		document.createParagraph();
		Paragraph t = null;
		Run tr = null;
		t = document.createParagraph();
		//�������ֶ��뷽ʽΪ���ж���
		t.setAlign(Align.CENTER);
		//���ô�ֱ����
		t.setVerticalAlign(VerticalAlign.TOP);
		tr = t.createRun();
		//��������Ӵ�
		tr.setBold(true);
		//���������С - 30
		tr.setFontSize(40);
		//��������Ϊ����
		tr.setFontFamily("����");
		//�����и�-100
		tr.setTextPosition(40);
		if(StringUtils.isNotEmpty(entity.getEiorgsyscoding())){
			OrganizationSearchCondImpl OrgCond = new OrganizationSearchCondImpl();
			OrgCond.setOrgsyscoding(entity.getEiorgsyscoding());
			List<Organization> orgList = this.organizationBL.searchOrganization(OrgCond, 0, 0);
			tr.setText(orgList.get(0).getOrgname());
		}
		
		t = document.createParagraph();
		//�������ֶ��뷽ʽΪ���ж���
		t.setAlign(Align.CENTER);
		//���ô�ֱ����
		t.setVerticalAlign(VerticalAlign.TOP);
		tr = t.createRun();
		//��������Ӵ�
		tr.setBold(true);
		//���������С - 30
		tr.setFontSize(40);
		//��������Ϊ����
		tr.setFontFamily("����");
		//�����и�-100
		tr.setTextPosition(40);
		if(StringUtils.isNotEmpty(entity.getEiinsdate())){
			try{
				DateFormat df1 = new SimpleDateFormat("yyyy/MM/dd");
				Date date = df1.parse(entity.getEiinsdate());
				DateFormat df2 = new SimpleDateFormat("yyyy��MM��");
				tr.setText(df2.format(date));
			}catch(Exception e){
			}
		}
		tr.addBreak(BreakType.PAGE);
		
		//��ѯ�ĵ�Ŀ¼
		SOC0509SearchCondImpl cond = new SOC0509SearchCondImpl();
		cond.setEid(entity.getEid());
		cond.setEsyscoding(entity.getEsyscoding());
		List<SOC0509Info> configList = soc0509BL.searchSOC0509(cond);
		for(SOC0509Info info:configList){
			if(("CI" + entity.getEsyscoding()).equals(info.getPcid())){
				Paragraph p = document.createParagraph();
				p.setStyle("1");
				Run r = p.createRun();
				r.setText(info.getCname());
				writeValue(entity,info,document);
				//�ݹ������ĵ�Ŀ¼
				writeDocumentDirAction(document,info,configList,level,1,entity);
			}
		}
		
		//�����Ŀ��Ź���
		WordUtils.getInstance().addNumberProjectNumbering(document);
		
		//ʵ���������
		FileOutputStream out = new FileOutputStream(fullName);
		//д��word�ĵ�
		document.write(out);
		//�ر������
		out.close();
		return fullName;
	}
	
	private void writeDocumentDirAction(WordDocument document, SOC0509Info parent, 
			List<SOC0509Info> configList, Map<Integer, Boolean> level,int parentLevel,SOC0118Info entity) throws BLException, IOException {
		int len = parentLevel + 1;
		if(level.get(len) == null){
			WordUtils.getInstance().createStyle(document, len + "", "heading " + len, len);
			level.put(len, true);
		}
		
		for(SOC0509Info info:configList){
			if(parent.getCid().equals(info.getPcid())){
				Paragraph p = document.createParagraph();
				p.setStyle("" + len);
				Run r = p.createRun();
				r.setText(info.getCname());
				writeValue(entity,info,document);
				//�ݹ������ĵ�Ŀ¼
				writeDocumentDirAction(document,info,configList,level,len,entity);
			}
		}
	}

	private void writeValue(SOC0118Info entity, SOC0509Info info, WordDocument document) throws BLException, IOException {
		/*
		 * 0 �� �ı�����
		 * 1 �� ����
		 * 2 �� ��֯�ܹ�
		 * 3 �� Ӧ����Դ
		 */
		if(IGDRMCONSTANTS.PLAN_DIR_TYPE_TEXT.equals(info.getCattach())){
			writeText(entity,info,document);
		}else if(IGDRMCONSTANTS.PLAN_DIR_TYPE_SCENE.equals(info.getCattach())){
			writeScene(entity,info,document);
		}else if(IGDRMCONSTANTS.PLAN_DIR_TYPE_ORG.equals(info.getCattach())){
			writeOrganization(entity,info,document);
		}
	}

	/**
	 * д����֯�ܹ�
	 * @param entity ʵ����Ϣ
	 * @param info Ŀ¼��������Ϣ
	 * @param document �ĵ���Ϣ
	 * @throws BLException 
	 */
	@SuppressWarnings("unchecked")
	private void writeOrganization(SOC0118Info entity, SOC0509Info info, WordDocument document) throws BLException {
		//ʵ������֯�ܹ���ѯdto
		IGDRM10DTO drm10Dto = new IGDRM10DTO();
		drm10Dto.setPlanEiid(entity.getEiid() + "");
		igdrm10BL.searchRoleAndUser(drm10Dto);
		Map<String, LinkedHashMap<String, Object>> orgArr = drm10Dto.getOrgArr();
		
		//�������
		Paragraph p = null;
		//�ı�����
		Run r = null;
		//������
		Table table = null;
		//����ж���
		Row row = null;
		//��Ԫ�����
		Cell cell = null;
		
		table = document.createTable();
		row = table.insertRow();
		cell = row.insertCell();
		cell.setWidth(1659);
		p = cell.createParagraph();
		p.setAlign(Align.CENTER);
		r = p.createRun();
		//��������Ӵ�
		r.setBold(true);
		r.setText("��֯�ܹ���");
		
		cell = row.insertCell();
		cell.setWidth(1659);
		p = cell.createParagraph();
		p.setAlign(Align.CENTER);
		r = p.createRun();
		//��������Ӵ�
		r.setBold(true);
		r.setText("��λ");
		
		cell = row.insertCell();
		cell.setWidth(1659);
		p = cell.createParagraph();
		p.setAlign(Align.CENTER);
		r = p.createRun();
		//��������Ӵ�
		r.setBold(true);
		r.setText("��Ա����");
		
		cell = row.insertCell();
		cell.setWidth(1659);
		p = cell.createParagraph();
		p.setAlign(Align.CENTER);
		r = p.createRun();
		//��������Ӵ�
		r.setBold(true);
		r.setText("��������");
		
		cell = row.insertCell();
		cell.setWidth(1659);
		p = cell.createParagraph();
		p.setAlign(Align.CENTER);
		r = p.createRun();
		//��������Ӵ�
		r.setBold(true);
		r.setText("�ֻ�");
		
		cell = row.insertCell();
		cell.setWidth(1659);
		p = cell.createParagraph();
		p.setAlign(Align.CENTER);
		r = p.createRun();
		//��������Ӵ�
		r.setBold(true);
		r.setText("�绰");
		
		cell = row.insertCell();
		cell.setWidth(1659);
		p = cell.createParagraph();
		p.setAlign(Align.CENTER);
		r = p.createRun();
		//��������Ӵ�
		r.setBold(true);
		r.setText("����");
		
		for(Iterator<Entry<String, LinkedHashMap<String, Object>>> iter = orgArr.entrySet().iterator();iter.hasNext();){
			Entry<String, LinkedHashMap<String, Object>> entry = iter.next();
			LinkedHashMap<String, Object> orgMap = entry.getValue();
			//����������
			row = table.insertRow();
			
			Cell firstCell = row.insertCell();
			p = firstCell.createParagraph();
			r = p.createRun();
			r.setText((String)orgMap.get("name"));
			
			int orgNum = 1;
			
			// ��ȡ���µĸ�λ�ļ���
			Map<String, Object> roleArr = (LinkedHashMap<String, Object>) orgMap.get("roleArr");
			for(Iterator<Entry<String, Object>> roleIt = roleArr.entrySet().iterator();roleIt.hasNext();){
				Entry<String, Object> roleEntry = roleIt.next();
				Map<String, Object> roleMap = (Map<String, Object>) roleEntry.getValue();
				
				if(orgNum > 1){
					row = table.insertRow();
				}
				
				Cell rowCell = row.insertCell();
				p = rowCell.createParagraph();
				r = p.createRun();
				r.setText((String)roleMap.get("roleName"));
				
				List<UserInfo> userList = (List<UserInfo>) roleMap.get("userList");
				
				if(userList != null){
					int roleNum = 1;
					// ������λ�µ���Ա��Ϣ
					for (int i = 0; i < userList.size(); i++) {
						UserTB user = (UserTB) userList.get(i);
						if(roleNum > 1){
							row = table.insertRow();
						}
						
						cell = row.insertCell();
						p = cell.createParagraph();
						r = p.createRun();
						r.setText(user.getUsername());
						
						cell = row.insertCell();
						p = cell.createParagraph();
						r = p.createRun();
						r.setText(getFullOrgName(user.getOrganizationTB()));
						
						cell = row.insertCell();
						p = cell.createParagraph();
						r = p.createRun();
						r.setText(user.getUsermobile());
						
						cell = row.insertCell();
						p = cell.createParagraph();
						r = p.createRun();
						r.setText(user.getUserphone());
						
						cell = row.insertCell();
						p = cell.createParagraph();
						r = p.createRun();
						r.setText(user.getUseremail());
						
						roleNum++;
					}
					
					if(roleNum == 1){
						for(int i=0;i<5;i++){
							cell = row.insertCell();
							p = cell.createParagraph();
							r = p.createRun();
						}
					}
					
					rowCell.setRowspan(roleNum == 1 ? 1 : roleNum - 1);
					
					orgNum += (roleNum == 1 ? 1 : roleNum - 1);
				}
				
				firstCell.setRowspan(orgNum == 1 ? 1 : orgNum - 1);
			}
		}
	}

	/**
	 * д������
	 * @param entity ʵ����Ϣ
	 * @param info Ŀ¼��������Ϣ
	 * @param document �ĵ���Ϣ
	 * @throws BLException 
	 */
	private void writeScene(SOC0118Info entity, SOC0509Info info, WordDocument document) throws BLException {
		//��ѯ������Ϣ
		List<PlanInfo> scenceList = searchScenceByPlan(entity.getEiid());
		if(scenceList != null){
			//�������
			Paragraph p = null;
			//�ı�����
			Run r = null;
			//������
			Table table = null;
			//����ж���
			Row row = null;
			//��Ԫ�����
			Cell cell = null;
			for(int i=0;i<scenceList.size();i++){
				
				if(i > 0){
					//�ڵ�һ�������͵ڶ�������֮�����һ�����У���Ȼ������
					document.createParagraph();
				}
				
				PlanInfo plan = scenceList.get(i);
				
				//��������Table
				table = document.createTable();
				//��������������
				row = table.insertRow();
				cell = row.insertCell();
				cell.setWidth(1659);
				p = cell.createParagraph();
				p.setAlign(Align.CENTER);
				r = p.createRun();
				//��������Ӵ�
				r.setBold(true);
				r.setText("�������");
				
				cell = row.insertCell();
				cell.setWidth(1659);
				p = cell.createParagraph();
				p.setAlign(Align.CENTER);
				r = p.createRun();
				r.setBold(true);
				r.setText("��������");
			
				cell = row.insertCell();
				cell.setWidth(3000);
				p = cell.createParagraph();
				p.setAlign(Align.CENTER);
				r = p.createRun();
				r.setBold(true);
				r.setText("������������");
				
				cell = row.insertCell();
				cell.setWidth(1659);
				p = cell.createParagraph();
				p.setAlign(Align.CENTER);
				r = p.createRun();
				r.setBold(true);
				r.setText("�Ƿ�������");
				
				cell = row.insertCell();
				cell.setWidth(1659);
				p = cell.createParagraph();
				p.setAlign(Align.CENTER);
				r = p.createRun();
				r.setBold(true);
				r.setText("����˵��");
				
				row = table.insertRow();
				
				cell = row.insertCell();
				cell.setWidth(1659);
				p = cell.createParagraph();
				p.setAlign(Align.CENTER);
				r = p.createRun();
				//��������Ӵ�
				r.setText(plan.getEilabel());
				
				cell = row.insertCell();
				cell.setWidth(1659);
				p = cell.createParagraph();
				p.setAlign(Align.CENTER);
				r = p.createRun();
				r.setText(plan.getEiname());
			
				cell = row.insertCell();
				cell.setWidth(3000);
				p = cell.createParagraph();
				p.setAlign(Align.CENTER);
				r = p.createRun();
				r.setText(plan.getOrgname());
				
				cell = row.insertCell();
				cell.setWidth(1659);
				p = cell.createParagraph();
				p.setAlign(Align.CENTER);
				r = p.createRun();
				r.setText(plan.getIsplan());
				
				cell = row.insertCell();
				cell.setWidth(1659);
				p = cell.createParagraph();
				p.setAlign(Align.CENTER);
				r = p.createRun();
				r.setText(plan.getScedes());
				
				p = document.createParagraph();
				
				table = document.createTable();
				
				row = table.insertRow();
				
				cell = row.insertCell();
				cell.setWidth(600);
				p = cell.createParagraph();
				r = p.createRun();
				r.setBold(true);
				r.setText("���");
				
				cell = row.insertCell();
				cell.setWidth(2000);
				p = cell.createParagraph();
				r = p.createRun();
				r.setBold(true);
				r.setText("����");
				
				cell = row.insertCell();
				cell.setWidth(1500);
				p = cell.createParagraph();
				r = p.createRun();
				r.setBold(true);
				r.setText("�ָ�ʱ��");
				
				cell = row.insertCell();
				cell.setWidth(2000);
				p = cell.createParagraph();
				r = p.createRun();
				r.setBold(true);
				r.setText("����");
				
				cell = row.insertCell();
				cell.setWidth(2000);
				p = cell.createParagraph();
				r = p.createRun();
				r.setBold(true);
				r.setText("Ӧ����Դ");
				
				cell = row.insertCell();
				cell.setWidth(1500);
				p = cell.createParagraph();
				r = p.createRun();
				r.setBold(true);
				r.setText("������");
				
				//��ѯ���̽ڵ���Ϣ
				List<FlowDetail> list = getProcessDetail(plan.getScepdid());
				for (FlowDetail detail : list) {
					row = table.insertRow();
					
					cell = row.insertCell();
					cell.setWidth(600);
					p = cell.createParagraph();
					r = p.createRun();
					r.setText(detail.getSequence());
					
					cell = row.insertCell();
					cell.setWidth(2000);
					p = cell.createParagraph();
					r = p.createRun();
					r.setText(detail.getIg333Info().getPsdname());
					
					cell = row.insertCell();
					cell.setWidth(1200);
					p = cell.createParagraph();
					r = p.createRun();
					r.setText(detail.getIg333Info().getBysequence() + "����");
					
					cell = row.insertCell();
					cell.setWidth(2300);
					p = cell.createParagraph();
					r = p.createRun();
					r.setText(detail.getDuty());
					
					cell = row.insertCell();
					cell.setWidth(2000);
					p = cell.createParagraph();
					r = p.createRun();
					if(detail.getSoc0118Map() != null){
						StringBuffer b = new StringBuffer();
						int rows = 0;
						for(Iterator<Entry<String, List<SOC0118VWInfo>>> iter = detail.getSoc0118Map().entrySet().iterator();iter.hasNext();){
							Entry<String, List<SOC0118VWInfo>> entry = iter.next();
							if(rows > 0){
								p = cell.createParagraph();
								r = p.createRun();
							}else{
								rows ++;
							}
							b.append(entry.getKey().split("_")[1]);
							b.append("��");
							List<SOC0118VWInfo> es = entry.getValue();
							for(int n=0;n<es.size();n++){
								b.append(es.get(n).getEiname());
								b.append("��");
							}
						}
						r.setText(b.toString());
					}
					cell = row.insertCell();
					cell.setWidth(1500);
					p = cell.createParagraph();
					r = p.createRun();
					if(detail.getUserMap() != null){
						StringBuffer b = new StringBuffer();
						int index = 0;
						for(Iterator<Entry<String, UserInfo>> iter = detail.getUserMap().entrySet().iterator();iter.hasNext();){
							if(index > 0){
								b.append("��");
							}else{
								index ++;
							}
							b.append(iter.next().getValue().getUsername());
						}
						r.setText(b.toString());
					}
				}
				
			}
		}
	}

	/**
	 * д���ı�����
	 * @param entity ʵ����Ϣ
	 * @param info Ŀ¼��������Ϣ
	 * @param document �ĵ���Ϣ
	 * @throws IOException 
	 */
	private void writeText(SOC0118Info entity, SOC0509Info info, WordDocument document) throws IOException {
		SOC0507SearchCondImpl cond = new SOC0507SearchCondImpl();
		cond.setCid(info.getCid());
		cond.setEid(entity.getEid());
		cond.setEiid(entity.getEiid());
		List<SOC0507Info> list = soc0507BL.searchSOC0507(cond);
		if(!list.isEmpty()){
			//�õ����ı�Ϊ���ı���ʽ�����а���html��ǩ����Ҫͨ��Jsoup����HTML����
			String html = list.get(0).getCivalue();
			Document doc = Jsoup.parse(html);
			Element body = doc.body();
			Paragraph p = document.createParagraph();
			List<Node> nodes = body.childNodes();
			writeHTML(nodes, p,document,true);
		}
	}
	
	public void writeHTML(List<Node> nodes,Paragraph p,WordDocument document,boolean isCreateParagraph) throws IOException{
		if(nodes != null){
			for(Node n:nodes){
				if(n instanceof TextNode){
					Run r = p.createRun();
					setHTMLStyle(p,r,n);
					r.setText(filterHTML(((TextNode) n).text()));
				}else if(n instanceof Element){
					String tagname = ((Element) n).tagName().toUpperCase();
					if("P".equals(tagname) && p.getRuns().size() > 0 && isCreateParagraph){
						p = document.createParagraph();
					}
					if("TABLE".equals(tagname)){
						writeTable(document,((Element) n));
						System.out.println(111);
					}else if("IMG".equals(tagname)){
						writeImage(p,n);
					}else if("A".equals(tagname)){
						boolean flag = writeLink(p,n);
						if(!flag){
							writeHTML(n.childNodes(),p,document,isCreateParagraph);
						}
					}else{
						writeHTML(n.childNodes(),p,document,isCreateParagraph);
					}
				}
			}
		}
	}
	
	private void writeTable(WordDocument document, Element e) throws IOException {
		//�������
		Table table = document.createTable();
		//�ݹ���ӱ��
		writeTr(document,table,e);
	}

	private void writeTr(WordDocument document,Table table, Element e) throws IOException {
		Elements elements = e.children();
		if(elements != null){
			for(Element n:elements){
				String tagName = n.tagName().toLowerCase();
				if(tagName.equals("tbody") || tagName.equals("thead")){
					writeTr(document,table, n);
				}else if(tagName.endsWith("tr")){
					Row row = table.insertRow();
					writeTD(document,row,n);
				}
			}
		}
	}

	private void writeTD(WordDocument document,Row row, Element e) throws IOException {
		Elements elements = e.children();
		if(elements != null){
			int width = 8300 / elements.size();
			for(Element n:elements){
				String tagName = n.tagName().toLowerCase();
				if(tagName.equals("td") || tagName.equals("th")){
					Cell cell = row.insertCell();
					String rowspan = n.attr("rowspan");
					if(StringUtils.isNotEmpty(rowspan)){
						cell.setRowspan(Integer.valueOf(rowspan));
					}
					String colspan = n.attr("colspan");
					if(StringUtils.isNotEmpty(colspan)){
						cell.setColspan(Integer.valueOf(colspan));
					}
					cell.setWidth(width);
					Paragraph p = cell.createParagraph();
					p.setVerticalAlign(VerticalAlign.CENTER);
					writeHTML(n.childNodes(), p, document,false);
				}
			}
		}
	}

	private boolean writeLink(Paragraph p, Node n) throws IOException {
		String src = n.attr("href");
		if(StringUtils.isNotEmpty(src)){
			src = src.replace("/InfoGovernor/IGDRM2102_File.do?", "");
			String[] split = src.split("&");
			if(split != null){
				StringBuffer path = new StringBuffer();
				path.append(ResourceUtility.getString("PALN_ATTA"));
				Map<String, String> map = new HashMap<String, String>();
				for(String s:split){
					String[] param = s.trim().split("=");
					if(param.length == 2){
						map.put(param[0], param[1]);
					}
				}
				String fileDir = map.get("dirName");
				String fileName = map.get("fileName");
				path.append(fileDir);
				path.append(File.separator);
				path.append(fileName);
				File file = new File(path.toString());
				if(file.exists() && (file.getName().endsWith(".xls") || file.getName().endsWith(".xlsx"))){
					Run r = p.createRun();
					r.createFile(file,((Element)n).text());
					return true;
				}
			}
		}
		return false;
	}

	private void writeImage(Paragraph p, Node n) throws IOException {
		String src = n.attr("src");
		if(StringUtils.isNotEmpty(src)){
			src = src.replace("/InfoGovernor/IGDRM2102_File.do?", "");
			String[] split = src.split("&");
			if(split != null){
				StringBuffer path = new StringBuffer();
				path.append(ResourceUtility.getString("PALN_ATTA"));
				Map<String, String> map = new HashMap<String, String>();
				for(String s:split){
					String[] param = s.trim().split("=");
					if(param.length == 2){
						map.put(param[0], param[1]);
					}
				}
				String fileDir = map.get("dirName");
				String fileName = map.get("fileName");
				path.append(fileDir);
				path.append(File.separator);
				path.append(fileName);
				File file = new File(path.toString());
				if(file.exists()){
					Run r = p.createRun();
					Image img = r.createImage(file);
					String style = n.attr("style");
					if(StringUtils.isNotEmpty(style)){
						for(String s:style.split(";")){
							String[] styles = s.split(":");
							if(styles.length == 2){
								if("width".equals(styles[0].toLowerCase())){
									Integer width = Integer.valueOf(styles[1].replace("px", ""));
									img.setWidth(width);
								}
								if("height".equals(styles[0].toLowerCase())){
									Integer height = Integer.valueOf(styles[1].replace("px", ""));
									img.setHeight(height);
								}
							}
						}
					}
				}
			}
		}
	}

	private void setHTMLStyle(Paragraph p,Run r, Node node) {
		Set<String> set = new HashSet<String>();
		for(;node != null;node = node.parent()){
			//�������strong��ǩ����b��ǩ�����ּӴ�
			if(node instanceof Element){
				String tagname = ((Element) node).tagName().toUpperCase();
				if("STRONG".equals(tagname) || "B".equals(tagname)){
					r.setBold(true);
				}
			}
			String style = node.attr("style");
			if(StringUtils.isNotBlank(style)){
				for(String s:style.split(";")){
					String[] split = s.split(":");
					if(split.length == 2){
						String key = split[0].trim().toUpperCase();
						if(!set.contains(key)){
							set.add(key);
							String value = split[1].trim();
							//������ɫ
							if("COLOR".equals(key)){
								r.setColor(new Color(value));
							}
							//���ִ�С
							else if("FONT-SIZE".equals(key)){
								try{
									//��px�����pt
									int pt = Integer.valueOf(value.replace("px", "")) * 3 / 2;
									r.setFontSize(pt);
								}catch (Exception e) {
								}
							}
							//����
							else if("FONT-FAMILY".equals(key)){
								r.setFontFamily(value);
							}else if("TEXT-INDENT".equals(key)){
								p.setInd("200");
							}
						}
					}
				}
			}
		}
	}

	private String filterHTML(String text) {
		return text.replaceAll("&nbsp;", "  ");
	}

	private List<FlowDetail> getProcessDetail(String pdid) throws BLException{
		UserInfoSearchCondImpl userCond = new UserInfoSearchCondImpl();
		IG560SearchCondImpl ig560Cond = new IG560SearchCondImpl();
		IG333SearchCondImpl ig333Cond = new IG333SearchCondImpl();
		IG222SearchCondImpl ig222Cond = new IG222SearchCondImpl();
		SOC0118VWSearchCondImpl soc0118Cond = new SOC0118VWSearchCondImpl();
		ig333Cond.setPdid(pdid);
		// �ڵ�list
		List<IG333Info> ig333List = workFlowDefinitionBL.searchProcessStatusDef(ig333Cond);
		// �����List
		Map<String, FlowDetail> flowDetailMap = new HashMap<String, FlowDetail>();
		// ����ӽڵ��List
		Map<String, Map<String, FlowDetail>> childFlowDetailMap = new HashMap<String, Map<String, FlowDetail>>();
		if (ig333List != null && ig333List.size() > 0) {
			for (IG333Info ig333Info : ig333List) {
				FlowDetail flowDetail = new FlowDetail();
				// �洢�ڵ�
				flowDetail.setIg333Info(ig333Info);
				ig560Cond.setPsdid(ig333Info.getPsdid());
				// ��ѯ560�е����ݲ���ӵ�flowDetail��
				List<IG560Info> ig560List = workFlowDefinitionBL.searchIG560TBInfo(ig560Cond);
				//����Ӧ����Դ�������齨���Map;
				if(ig560List != null && ig560List.size()>0){
					if(flowDetail.getSoc0118Map()==null){
						flowDetail.setSoc0118Map(new HashMap<String, List<SOC0118VWInfo>>());
					}
					for(IG560Info ig560Info : ig560List){
						if(ig560Info.getDfvalue()!=null &&!ig560Info.getDfvalue().isEmpty()){
							String type = ig560Info.getDfvalue().split("_SOC_")[1];
							soc0118Cond.setEiid(ig560Info.getDfvalue().split("_")[1]);
							soc0118Cond.setId(Integer.parseInt(ig560Info.getDfvalue().split("_")[0]));
							SOC0118VWInfo soc0118VWInfo = soc0118VWBL.searchEntityItem(soc0118Cond).get(0);
							if(flowDetail.getSoc0118Map().get(type)!=null){
								List<SOC0118VWInfo> soc0118VWInfoList = flowDetail.getSoc0118Map().get(type);
								soc0118VWInfoList.add(soc0118VWInfo);
								flowDetail.getSoc0118Map().put(type, soc0118VWInfoList);
							}else{
								flowDetail.getSoc0118Map().put(type, new ArrayList<SOC0118VWInfo>());
								List<SOC0118VWInfo> soc0118VWInfoList = flowDetail.getSoc0118Map().get(type);
								soc0118VWInfoList.add(soc0118VWInfo);
								flowDetail.getSoc0118Map().put(type, soc0118VWInfoList);
							}
						}
						
					}
				}
				
				//����
				flowDetail.setDuty(ig333Info.getPsddesc());
				// ��ѯ�����˲��洢
				Map<String, UserInfo> userMap = new HashMap<String, UserInfo>();
				ig222Cond.setPsdid(ig333Info.getPsdid());
				List<IG222Info> ig222List = workFlowDefinitionBL.searchParticipantDef(ig222Cond);
				if (ig222List != null && ig222List.size() > 0) {
					for (IG222Info ig222Info : ig222List) {
						if (StringUtils.isNotEmpty(ig222Info.getUserid())) {
							userCond.setUserida(ig222Info.getUserid());
							List<UserInfo> userList = userBL.searchUserInfo(userCond);
							if (userList != null && userList.size() > 0) {
								UserInfo user = (UserInfo) userList.get(0);
								userMap.put(user.getUserida(), user);
							}
						} else {
							List<UserInfo> userInfoList = userBL.searchUserByRoleId(ig222Info.getRoleid());
							if (userInfoList != null && userInfoList.size() > 0) {
								for (int i = 0; i < userInfoList.size(); i++) {
									UserInfoVW user = new UserInfoVW();
									BeanUtils.copyProperties(userInfoList.get(i), user);
									user.setUserida(((UserTB) userInfoList.get(i)).getUserid());
									userMap.put(user.getUserida(), user);
								}
							}
						}
					}
					flowDetail.setUserMap(userMap);
				}
				// �ж��Ƿ�Ϊ�ӽڵ�
				if (StringUtils.isNotEmpty(ig333Info.getPpsdid())) {
					if (childFlowDetailMap.get(ig333Info.getPpsdid()) == null) {
						Map<String, FlowDetail> childStepMap = new HashMap<String, FlowDetail>();
						childStepMap.put(ig333Info.getPsdid(), flowDetail);
						childFlowDetailMap.put(ig333Info.getPpsdid(), childStepMap);
					} else {
						childFlowDetailMap.get(ig333Info.getPpsdid()).put(ig333Info.getPsdid(), flowDetail);
					}
				} else {
					flowDetailMap.put(ig333Info.getPsdid(), flowDetail);
				}

			}
		}

		// �Ը��ڵ���������
		ComputingTime computingTime = new ComputingTime();
		Map<String, String> parentStepMap = computingTime.getOrderStep(pdid, "null");
		List<FlowDetail> parentStepList = new ArrayList<FlowDetail>();
		Integer parentIndex = 0;
		for (String key : parentStepMap.keySet()) {
			parentIndex++;
			FlowDetail flowDetail = flowDetailMap.get(key);
			flowDetail.setSequence(parentIndex.toString());
			parentStepList.add(flowDetail);
		}
		// ����childFlowDetailMap���ӽڵ�ŵ����ڵ��List��
		for (String ppsdid : childFlowDetailMap.keySet()) {
			Map<String, String> childStepMap = computingTime.getOrderStep(pdid, ppsdid);
			Map<String, FlowDetail> childFlowMap = childFlowDetailMap.get(ppsdid);
			List<FlowDetail> childList = new ArrayList<FlowDetail>();
			for (String psdid : childStepMap.keySet()) {
				childList.add(childFlowMap.get(psdid));
			}
			for (FlowDetail parentStep : parentStepList) {
				if (parentStep.getIg333Info().getPsdid().equals(ppsdid)) {
					// �������̽ڵ���
					Integer childIndex = 0;
					String parentSequence = parentStep.getSequence();
					for (FlowDetail childStep : childList) {
						childIndex++;
						childStep.setSequence(parentSequence + "." + childIndex);
					}
					parentStep.setChildStepList(childList);
				}
			}
		}
		
		return parentStepList;
	}

	/**
	 * �ļ����ز���
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public void downloadReportFileAction(String filename,HttpServletResponse response) throws BLException{
		// �����
		OutputStream output = null;
		// ������
		FileInputStream input = null;
		try{
			File file = new File(filename);
			//�ļ����ش���
			response.reset();
			response.setContentType("binary/octet-stream");
			response.setHeader("Content-Disposition", "attachment;filename=" +  new String(file.getName().getBytes("gb2312"),"iso-8859-1"));
			// �����ȡ��
			output = response.getOutputStream();
			// ������ȡ��
			input = new FileInputStream(file);
			int actual = 0;
			byte[] b = new byte[1024];
			
			while ((actual = input.read(b)) > 0) {
				output.write(b,0,actual);
			}
			output.flush();
		}catch (Exception e) {
		}finally {
			try {
				// �ر�������
				if(input != null){
					input.close();
					input = null;
				}
				// �ر������
				if(output != null){
					output.close();
					output = null;
				}
			} catch (Exception e) {
			}
		}
	}

	public IGDRM21DTO loadAllReservePlan(IGDRM21DTO dto) throws BLException {
		//��ȡ����Ϣ
		//���ݲ�����ѯ��������Ϣ
		SOC0509SearchCondImpl soc0509Cond = new SOC0509SearchCondImpl();
		soc0509Cond.setEsyscoding(dto.getEsyscoding());
		List<SOC0509Info> soc0509List = soc0509BL.searchSOC0509(soc0509Cond);
		Map<String,SOC0509Info> treeMap = new LinkedHashMap<String, SOC0509Info>();
		if(soc0509List != null && !soc0509List.isEmpty()){
			//����ID����Ϊmap
			Map<String, List<SOC0509Info>> pcidKeySoc0509Map = new LinkedHashMap<String, List<SOC0509Info>>();
			for (SOC0509Info soc0509Info : soc0509List) {
				List<SOC0509Info> newSoc0509List = new ArrayList<SOC0509Info>();
				if(pcidKeySoc0509Map.containsKey(soc0509Info.getPcid())){
					newSoc0509List = pcidKeySoc0509Map.get(soc0509Info.getPcid());
				}
				newSoc0509List.add(soc0509Info);
				pcidKeySoc0509Map.put(soc0509Info.getPcid(), newSoc0509List);
			}
			Set<String> keySet = pcidKeySoc0509Map.keySet();
			for (String pcid : keySet) {
				List<SOC0509Info> list = pcidKeySoc0509Map.get(pcid);
				recursionSetDirInfo(treeMap, pcidKeySoc0509Map, list);
			}
		}
		SOC0507SearchCondImpl soc0507Cond = new SOC0507SearchCondImpl();
		soc0507Cond.setEsyscoding(dto.getEsyscoding());
		//���ݲ�����ѯԤ��������Ϣ
		List<SOC0507Info> soc0507List = soc0507BL.searchSOC0507(soc0507Cond);
		if(soc0507List != null && !soc0507List.isEmpty()){
			for (SOC0507Info soc0507Info : soc0507List) {
				if(treeMap.containsKey(soc0507Info.getCid())){
					SOC0509Info soc0509Info = treeMap.get(soc0507Info.getCid());
					SOC0509TB soc0509TB = (SOC0509TB) SerializationUtils.clone(soc0509Info);
					soc0509TB.setCdesc(soc0507Info.getCivalue());
					treeMap.put(soc0507Info.getCid(), soc0509TB);
				}
			}
		}
		dto.setTreeMap(treeMap);
		return dto;
	}
	
	/**
	 * �ݹ�����Ŀ¼��Ϣ
	 * @param treeMap
	 * @param pcidKeySoc0509Map
	 * @param soc0509List
	 * @return
	 */
	private Map<String,SOC0509Info> recursionSetDirInfo(Map<String,SOC0509Info> treeMap,Map<String, List<SOC0509Info>> pcidKeySoc0509Map, List<SOC0509Info> soc0509List) {
		if(soc0509List != null && !soc0509List.isEmpty()){
			for (SOC0509Info soc0509Info : soc0509List) {
				treeMap.put(soc0509Info.getCid(), soc0509Info);
				List<SOC0509Info> list = pcidKeySoc0509Map.get(soc0509Info.getCid());
				recursionSetDirInfo(treeMap, pcidKeySoc0509Map, list);
			}
		}
		return treeMap;
	}

	/**
	 * ����Ԥ�����ı�����
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM21DTO loadPlanTextContent(IGDRM21DTO dto) throws BLException {
		
		IGDRM2108Form form = (IGDRM2108Form)dto.getForm();
		dto.setSoc0507Info(soc0507BL.getPlanContent(form.getCid(), form.getPlanEiid()));

		return dto;
	}

	/**
	 * ���س�����Ϣ
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM21DTO loadPlanScenceHtml(IGDRM21DTO dto) throws BLException {

		log.debug("==========����Ԥ���еĳ���HTML��ʼ==============");
		
		IGDRM2108Form form = (IGDRM2108Form) dto.getForm();
		
		StringBuffer sbHTML = new StringBuffer();
		
		List<PlanInfo> scenceList = searchScenceByPlan(form.getPlanEiid());
		if (scenceList != null)
		for (PlanInfo planInfo : scenceList) {
			sbHTML.append("<br/>");
			sbHTML.append("<table class=\"table_style\"  style=\"width: 98%;\">");
			sbHTML.append("<tr>");
				sbHTML.append("<th width=\"15%\">�������</th>");
			sbHTML.append("<th width=\"20%\">��������</th>");
			sbHTML.append("<th width=\"20%\">������������</th>");
				sbHTML.append("<th width=\"15%\">�Ƿ�������</th>");
			
			sbHTML.append("<th width=\"30%\">����˵��</th>");
			sbHTML.append("</tr><tr>");
			sbHTML.append("<td>"+planInfo.getEilabel()+"</td>");
			sbHTML.append("<td>"+planInfo.getEiname()+"</td>");
			sbHTML.append("<td>"+planInfo.getOrgname()+"</td>");
			sbHTML.append("<td>"+planInfo.getIsplan()+"</td>");
			sbHTML.append("<td>"+planInfo.getScedes()+"</td>");
			sbHTML.append("</tr></table>");

				IGDRM01DTO drm01Dto = new IGDRM01DTO();
				drm01Dto.setPdid(planInfo.getScepdid());

				igdrm01BL.searchFlowDetail(drm01Dto);

				sbHTML.append("</br>");
				sbHTML.append(drm01Dto.getOutPrintStr());

		}

		dto.setResultHTML(sbHTML.toString());
		log.debug("==========����Ԥ���еĳ���HTML���==============");
		return dto;
	}

	/**
	 * ����Ԥ���е���֯�ܹ���Ϣ
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	@SuppressWarnings("unchecked")
	public IGDRM21DTO loadPlanOrgHTML(IGDRM21DTO dto) throws BLException {

		log.debug("==============����Ԥ������֯�ܹ���Ϣ��ʼ=================");

		IGDRM2108Form form = (IGDRM2108Form) dto.getForm();

		IGDRM10DTO drm10Dto = new IGDRM10DTO();

		drm10Dto.setPlanEiid(form.getPlanEiid() + "");

		igdrm10BL.searchRoleAndUser(drm10Dto);

		LinkedHashMap<String, LinkedHashMap<String, Object>> orgArr = drm10Dto.getOrgArr();
		Gson g = new Gson();

		log.debug("����:" + g.toJson(orgArr));

		StringBuffer sbHTML = new StringBuffer();

		sbHTML.append("<table class=\"table_style4\"><tr>");
		sbHTML.append("<th width=\"12%\">��֯�ܹ���</th>");
		sbHTML.append("<th width=\"14%\">��λ</th>");
		sbHTML.append("<th width=\"10%\">��Ա����</th>");
		sbHTML.append("<th width=\"12%\">��������</th>");
		sbHTML.append("<th width=\"11%\">�ֻ�</th>");
		sbHTML.append("<th width=\"12%\">�绰</th>");
		sbHTML.append("<th>����</th></tr>");
		
		for (Iterator<String> it = orgArr.keySet().iterator(); it.hasNext();) {
			LinkedHashMap<String, Object> orgMap = orgArr.get(it.next());
			sbHTML.append("<tr><td  rowspan=\"");
			int orgReplace = sbHTML.length();
			sbHTML.append("org_num\">" + orgMap.get("name") + "</td>");
			
			// ��ȡ���µĸ�λ�ļ���
			LinkedHashMap<String, Object> roleArr = (LinkedHashMap<String, Object>) orgMap.get("roleArr");
			int orgNum = 1;
			// ���� ���µĸ�λ��Ϣ
			for (Iterator<String> roleIt = roleArr.keySet().iterator(); roleIt.hasNext();) {

				Map<String, Object> roleMap = (Map<String, Object>) roleArr.get(roleIt.next());

				if(orgNum>1){
					sbHTML.append("<tr org='org'>");
				}
				sbHTML.append("<td rowspan=\"");
				int roleReplace = sbHTML.length();
				sbHTML.append("role_num\" >" + roleMap.get("roleName").toString() + "</td>");

				List<UserInfo> userList = (List<UserInfo>) roleMap.get("userList");
				int roleNum = 1;
				// ������λ�µ���Ա��Ϣ
				for (int i = 0; i < userList.size(); i++) {
					UserTB user = (UserTB) userList.get(i);
					if (roleNum > 1) {
						sbHTML.append("<tr role='role'>");
					}
					sbHTML.append("<td>"+user.getUsername()+"</td>");
					sbHTML.append("<td>" + getFullOrgName(user.getOrganizationTB()) + "</td>");
					// �ֻ�
					sbHTML.append("<td>" + user.getUsermobile() + "</td>");
					// �绰
					sbHTML.append("<td>" + user.getUserphone() + "</td>");
					// email
					sbHTML.append("<td>" + user.getUseremail() + "</td>");
					sbHTML.append("</tr>");
					roleNum++;
				}
				// �����λ��û����Ա,���ÿ����ݲ�����
				if (roleNum == 1) {
					sbHTML.append("<td></td><td></td><td></td><td></td><td></td></tr>");
				}
				System.out.println(roleMap.get("roleName").toString() + ":" + (roleNum == 1 ? 1 : roleNum - 1));
				orgNum += (roleNum == 1 ? 1 : roleNum - 1);
				sbHTML = sbHTML.replace(roleReplace, roleReplace + 8, (roleNum == 1 ? 1 : roleNum - 1) + "");
			}
			// �������û�и�λ,���ÿ����ݲ�����
			if (orgNum == 1) {
				// sbHTML.append("<td></td><td></td><td></td><td></td><td></td><td></td></tr>");
			}
			System.out.println(orgMap.get("name").toString() + ":" + (orgNum - 1));
			sbHTML = sbHTML.replace(orgReplace, orgReplace + 7, (orgNum == 1 ? 1 : orgNum - 1) + "");
		}
		dto.setResultHTML(sbHTML.toString());

		log.debug("==============����Ԥ������֯�ܹ���Ϣ���=================");
		return dto;
	}

	/**
	 * �ݹ��ȡ����ȫ����
	 * 
	 * @param orgTB
	 * @return
	 */
	private String getFullOrgName(OrganizationTB orgTB) {
		if (orgTB.getOrganizationTB() != null && !orgTB.getOrgpar().equals("0001")) {
			return getFullOrgName(orgTB.getOrganizationTB()) + "-" + orgTB.getOrgname();
		} else {
			return orgTB.getOrgname();
		}
	}
	/**
	 * ����Ԥ���е�Ӧ����Դ��Ϣ
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM21DTO loadPlanResourceHTML(IGDRM21DTO dto) throws BLException {

		log.debug("==============����Ԥ����Ӧ����Դ��Ϣ��ʼ=================");

		log.debug("==============����Ԥ����Ӧ����Դ��Ϣ���=================");

		return dto;
	}

	/**
	 * ��ѯԤ����Ϣ
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	private List<PlanInfo> searchScenceByPlan(Integer planeiid) throws BLException {

		log.debug("======��ѯԤ���г�����ʼ=======");

		SOC0119SearchCondImpl cond = new SOC0119SearchCondImpl();

		cond.setPareiid(planeiid);

		cond.setEirrelation("01");

		cond.setDeleteflag("0");

		List<Integer> cldEiidArr = soc0119BL.searchCldeiidByPareiid(cond);

		if (cldEiidArr != null && cldEiidArr.size() > 0) {
			PlanSearchCondImpl planCond = new PlanSearchCondImpl();

			planCond.setPlanEiids(cldEiidArr);

			List<PlanInfo> scenceList = planBL.findByCond(planCond, 0, 0);
			
			return scenceList;
		}

		log.debug("======��ѯԤ���г�������=======");

		return null;
	}
}
