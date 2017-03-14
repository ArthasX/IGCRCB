package com.deliverik.infogovernor.asset.bl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;
import org.apache.struts.util.LabelValueBean;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.deliverik.framework.asset.EntityCategory;
import com.deliverik.framework.asset.EntityItemKeyWords;
import com.deliverik.framework.asset.bl.task.EiBelongRelationBL;
import com.deliverik.framework.asset.bl.task.IG013BL;
import com.deliverik.framework.asset.bl.task.IG117BL;
import com.deliverik.framework.asset.bl.task.IG225BL;
import com.deliverik.framework.asset.bl.task.IG313BL;
import com.deliverik.framework.asset.bl.task.IG545BL;
import com.deliverik.framework.asset.bl.task.IG800BL;
import com.deliverik.framework.asset.bl.task.IG912BL;
import com.deliverik.framework.asset.model.EiBelongRelationVWInfo;
import com.deliverik.framework.asset.model.IG013Info;
import com.deliverik.framework.asset.model.IG117Info;
import com.deliverik.framework.asset.model.IG313Info;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.asset.model.IG749Info;
import com.deliverik.framework.asset.model.IG800Info;
import com.deliverik.framework.asset.model.IG887Info;
import com.deliverik.framework.asset.model.IG912Info;
import com.deliverik.framework.asset.model.condition.EiBelongRelationVWSearchCondImpl;
import com.deliverik.framework.asset.model.condition.IG013SearchCondImpl;
import com.deliverik.framework.asset.model.condition.IG117SearchCondImpl;
import com.deliverik.framework.asset.model.condition.IG313SearchCondImpl;
import com.deliverik.framework.asset.model.condition.IG688SearchCondImpl;
import com.deliverik.framework.asset.model.condition.IG800SearchCond;
import com.deliverik.framework.asset.model.condition.IG800SearchCondImpl;
import com.deliverik.framework.asset.model.condition.IG912SearchCondImpl;
import com.deliverik.framework.asset.model.entity.IG013TB;
import com.deliverik.framework.asset.model.entity.IG313TB;
import com.deliverik.framework.asset.model.entity.IG800TB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.bl.FileUploadBL;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;
import com.deliverik.framework.soc.asset.SOC0138Info;
import com.deliverik.framework.soc.asset.bl.task.SOC0107BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0109BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0110BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0112BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0117BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0119BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0126BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0151BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0601BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0603BL;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.SOC0109Info;
import com.deliverik.framework.soc.asset.model.SOC0112Info;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0119Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0128Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.framework.soc.asset.model.SOC0601Info;
import com.deliverik.framework.soc.asset.model.SOC0603Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0107SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0109SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0117SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0118SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0119SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0126SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0601SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0603SearchCondImpl;
import com.deliverik.framework.soc.asset.model.entity.SOC0107TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0109TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0112PK;
import com.deliverik.framework.soc.asset.model.entity.SOC0112TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0118TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0119TB;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.bl.task.OrganizationBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.condition.OrganizationSearchCondImpl;
import com.deliverik.framework.utility.BLErrorType;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.asset.dto.IGASM03DTO;
import com.deliverik.infogovernor.asset.form.IGASM0301Form;
import com.deliverik.infogovernor.asset.form.IGASM0302Form;
import com.deliverik.infogovernor.asset.form.IGASM0304Form;
import com.deliverik.infogovernor.asset.form.IGASM0307Form;
import com.deliverik.infogovernor.asset.form.IGASM0317Form;
import com.deliverik.infogovernor.asset.form.IGASM0321Form;
import com.deliverik.infogovernor.asset.form.IGASM0346Form;
import com.deliverik.infogovernor.util.ASMHelper;
import com.deliverik.infogovernor.util.CodeDefine;

/**
 * �豸���ù���ҵ���߼�ʵ��
 *
 */
public class IGASM03BLImpl extends BaseBLImpl implements IGASM03BL {

	static Log log = LogFactory.getLog(IGASM03BLImpl.class);
	
	public static final String DEVICE_DEVICE = "001-001";
	
	public static final String DEVICE_DEVICE_CONN_ID = "1";
	
	/** �汾��������ʶ */
	public static final String SAVE_VERSION_UP = "1";

	/** �汾�Ų�������ʶ */
	public static final String SAVE_VERSION = "0";
	
	public static final String EIRRELATIONCODE="'001-001','001-002','003-001','012-001','012-001','013-001','001-005','001-006','001-011','001-010','001-008','007-001'";
	
	/** �ʲ���ϢBL */
	protected IG117BL ig117BL;
	
	protected SOC0117BL soc0117BL;

	/** ��������ϢBL */
	protected IG013BL ig013BL;
	
	protected SOC0118BL soc0118BL;
	
	/** �ʲ�������BL */
	protected IG800BL ig800BL;
	
	protected SOC0107BL soc0107BL;
	
	/** �������ϵBL */
	protected IG313BL ig313BL;
	
	protected SOC0119BL soc0119BL;
	
	/** �����ʲ�BL*/
	protected SOC0601BL soc0601BL;
	
	/** �����ʲ�BL*/
	protected SOC0603BL soc0603BL;
	
	/** �ļ��ϴ�BL */
	protected FileUploadBL fileUploadBL;
	
	/** �ʲ�ȡֵ��Χ��������BL */
	protected IG545BL ig545BL;
	
	protected SOC0151BL soc0151BL;
	
	/** �ʲ�������ϵ��������BL */
	protected CodeDetailBL codeDetailBL;
	
	/** ����BL */
	protected OrganizationBL organizationBL;
	
	/** ������BL */
	protected IG225BL ig225BL;
	
	protected SOC0109BL soc0109BL;
	
	/** �û���ɫBL */
	protected UserRoleBL userRoleBL;
	
	/** ������ϵ��BL */
	protected EiBelongRelationBL eiBelongRelationBL;
	
	protected SOC0110BL soc0110BL;
	
	/** ���汾����ϸBL */
	protected SOC0126BL soc0126BL;
	
	/** ����ϸBL */
	protected SOC0112BL soc0112BL;
	
	
	/** ����ϸBL */
	protected IG912BL ig912BL;
	
	public void setEiBelongRelationBL(EiBelongRelationBL eiBelongRelationBL) {
		this.eiBelongRelationBL = eiBelongRelationBL;
	}
	
	public void setIg225BL(IG225BL ig225BL) {
		this.ig225BL = ig225BL;
	}

	/**
	 * @param soc0601bl the soc0601BL to set
	 */
	public void setSoc0601BL(SOC0601BL soc0601bl) {
		soc0601BL = soc0601bl;
	}

	/**
	 * @param soc0603bl the soc0603BL to set
	 */
	public void setSoc0603BL(SOC0603BL soc0603bl) {
		soc0603BL = soc0603bl;
	}

	public void setOrganizationBL(OrganizationBL organizationBL) {
		this.organizationBL = organizationBL;
	}

	public void setIg117BL(IG117BL ig117BL) {
		this.ig117BL = ig117BL;
	}
	
	public void setIg013BL(IG013BL ig013BL) {
		this.ig013BL = ig013BL;
	}

	public void setIg800BL(IG800BL ig800BL) {
		this.ig800BL = ig800BL;
	}

	public void setIg313BL(
			IG313BL ig313BL) {
		this.ig313BL = ig313BL;
	}

	public void setFileUploadBL(FileUploadBL fileUploadBL) {
		this.fileUploadBL = fileUploadBL;
	}
	
	public void setIg545BL(
			IG545BL ig545BL) {
		this.ig545BL = ig545BL;
	}
	
	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}
	
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
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

	public void setSoc0119BL(SOC0119BL soc0119BL) {
		this.soc0119BL = soc0119BL;
	}

	public void setSoc0109BL(SOC0109BL soc0109BL) {
		this.soc0109BL = soc0109BL;
	}

	public void setSoc0151BL(SOC0151BL soc0151BL) {
		this.soc0151BL = soc0151BL;
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

	/**
	 * �豸��Ϣ��ѯ����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO searchEntityItemAction(IGASM03DTO dto) throws BLException {

		log.debug("========�豸��Ϣ��ѯ����ʼ========");
		
		//�豸��Ϣ��ѯ����ȡ�� 
		int totalCount = this.soc0118BL.getEntityItemVWSearchCount(dto.getEntityItemVWSearchCond());
		
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
		List<SOC0124Info> entityItemVWInfoList = this.soc0118BL.searchEntityItemVW(dto.getEntityItemVWSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setEntityItemVWInfoList(entityItemVWInfoList);

		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========�豸��Ϣ��ѯ��������========");
		return dto;
	}
	
	/**
	 * �豸��Ϣ�ǼǴ���
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO insertEntityItemAction(IGASM03DTO dto) throws BLException {
		log.debug("========�豸��Ϣ�ǼǴ���ʼ========");
		//����Formȡ��
		IGASM0302Form form = dto.getIgasm0302Form();
		
		//����IDȡ��
//		EntitySearchCondImpl cond = new EntitySearchCondImpl();
//		cond.setElabel(form.getElabel());
		//�ǼǴ���ǰ���ʲ���Ϣȷ��
//		List<Entity> entityList = this.ig117BL.searchEntity(cond, 0, 0);
//		if ( entityList == null || entityList.size() ==0 ) {
//			throw new BLException(BLErrorType.ENTITY_ITEM_NOT_EXISTS_ERROR,
//					"IGCO10000.E004","(���=" + form.getEilabel() + ")�豸����");
//		}
		
//		Entity entity = entityList.get(0);
//		EntityItem entityItem = entityitemList.get(0);
		
		//***************************************************************************
		//���ͷ�����
//		if (!entity.getEcategory().equals(CommonDefineUtils.ENTIY_CATEGORY_DEVICE)) {
//			//�豸��������
//			throw new BLException(BLErrorType.ENTITY_CATEGORY_ERROR,
//					"IGCO10000.E011","�豸");
//		}
		//***************************************************************************
		
//		form.setEid(entity.getEid());
		form.setEidStr(form.getEid().toString());
		
		//����ʱ���趨
		
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		
		form.setEiupdtime(datetime);
		
		//��汾�趨���̶���Ϊ0��
		form.setEiversion(0);
		
		//С�汾�趨���̶���Ϊ0��
		form.setEismallversion(0);
		
		form.setEistatus(CommonDefineUtils.ENTITYITEM_STARUS_NEW);

		//�豸��Ϣ��¼
		SOC0118Info entityItem = this.soc0118BL.registEntityItem(dto.getIgasm0302Form());
		
		form.setEiidStr(entityItem.getEiid().toString());
		
		dto.setIgasm0302Form(form);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "�豸������Ϣ") );

		log.debug("========�豸��Ϣ�ǼǴ�������========");
		return dto;
	}

	/**
	 * �豸��Ϣɾ������
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO deleteEntityItemAction(IGASM03DTO dto) throws BLException {
		log.debug("========�豸��Ϣɾ������ʼ========");
		
		List<Integer> retList = new ArrayList<Integer>();//�ݹ�ɾ�������û�ѡ��ɾ�������ظ�
		for( int i=0;i<dto.getDeleteEntityItem().length;i++ ){
			String eiid = dto.getDeleteEntityItem()[i];
			if(!retList.contains(Integer.parseInt(eiid))){
				cycleDelete (eiid,retList);
			}
		}
		for(Integer eiid : retList){
			//ɾ��ǰɾ�������豸ȷ��
			SOC0118Info entityItem = this.soc0118BL.searchEntityItemByKey(eiid);
			
			if (entityItem == null){
				throw new BLException("IGCO10000.E004","ɾ�������豸����");
			}
			//�豸ɾ��
			this.soc0118BL.deleteEntityItem(entityItem);
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I006","�豸��Ϣ"));

		log.debug("========�豸��Ϣɾ����������========");
		return dto;
	}
	//�ݹ�ɾ���豸���������
	private List<Integer> cycleDelete (String eiid,List<Integer> retList) throws BLException{
		SOC0119SearchCondImpl cond = new SOC0119SearchCondImpl();
		cond.setEirinfo("#" + eiid + "#");
		cond.setEirstatus("C");
		cond.setDeleteflag("0");
		//����ָ���豸�µ��������������ݹ����
		List<SOC0119Info> list = this.soc0119BL.searchEntityItemRelation(cond);
		for(SOC0119Info eir : list){
			this.cycleDelete(eir.getPareiid()+"",retList);
		}
		if(!retList.contains(Integer.parseInt(eiid))){
			retList.add(Integer.parseInt(eiid));
		}
		return retList;
	}


	/**
	 * �豸������Ϣ�༭������ڻ�����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO initIGASM0304Action(IGASM03DTO dto) throws BLException {

		log.debug("========�豸������Ϣ�༭������ڻ�����ʼ========");
		
		IGASM0304Form form = dto.getIgasm0304Form();
		
		//�豸��Ϣ����
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(
			Integer.parseInt(form.getEiid()));
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","�豸");
		}
		
		form.setEidesc(entityItemVWInfo.getEidesc());
		form.setEistatus(entityItemVWInfo.getEistatus());
		form.setEmodeltype(entityItemVWInfo.getEmodeltype());
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
		//�жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(), entityItemVWInfo);

		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}else{
			dto.setFlag(flag);
		}
		
		
		//�豸������Ϣ��ѯ����ȡ�� 
		int totalCount = this.soc0107BL.getConfigItemVWSearchCount(form);
		
		if (totalCount == 0) {
			log.debug("========�豸������Ϣ��ѯ���ݲ�����========");
			//�豸������Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I007",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========�豸������Ϣ��ѯ���ݼ�������========");
			//�豸������Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//������������Ϣȫ����ѯ
		List<SOC0129Info> configItemVWInfoList = this.soc0107BL.searchConfigItemVW(
				form, 0, 0);
		
		String[] civalue = new String[totalCount];
		String[] delfile = new String[totalCount];
		String[] entityItemCivalue = new String[totalCount];
		String[] isUpgrade=new String[totalCount];
		//��žɰ汾ֵ
		String[] civalue_bak = new String[totalCount];
		Map<String,List<SOC0129Info>> map = new LinkedHashMap<String,List<SOC0129Info>>();
		int i = 0;
		int j = 0;
		List<String> strlist = new ArrayList<String>();
		Map<String, String> cldVersionMap=new HashMap<String, String>();//���ʲ��汾����
		for(SOC0129Info e : configItemVWInfoList){
			if("4".equals(e.getCattach())){
				String value = e.getCivalue();
				if(StringUtils.isNotEmpty(value)){
					String cldeiid = value.substring(value.lastIndexOf("(")+1, value.length()-1);//���ʲ�eiid
					
					SOC0119SearchCondImpl cond=new SOC0119SearchCondImpl();
					cond.setPareiid(Integer.parseInt(form.getEiid()));
					if(cldeiid!=null){
					cond.setCldeiid(Integer.parseInt(cldeiid));}
					cond.setParversion(entityItemVWInfo.getEiversion());
					cond.setEirinfo("_"+e.getCiid()+"_");
					cond.setDeleteflag("0");
					List<SOC0119Info> ig313Info = soc0119BL.searchEntityItemRelation(cond);
					String cldversion="";
					if(ig313Info!=null&&ig313Info.size()>0){
						cldversion = String.valueOf(ig313Info.get(0).getCldversion());//���ʲ��汾
					}
					cldVersionMap.put(cldeiid, cldversion);
				}
			}
			if(!map.containsKey(e.getCcategory())){
				map.put(e.getCcategory(), new ArrayList<SOC0129Info>());
				strlist.add(e.getCcategory());
			}
			map.get(e.getCcategory()).add(e);
			if("IG_0012".equals(e.getClabel())){
				List<LabelValueBean> list = new ArrayList<LabelValueBean>();
				list.add(new LabelValueBean("", ""));
				SOC0601SearchCondImpl soc0601cond = new SOC0601SearchCondImpl();
				List<SOC0601Info> soc0601List = soc0601BL.searchSOC0601Info(soc0601cond);
				for(SOC0601Info ccd : soc0601List){
					list.add(new LabelValueBean(ccd.getEiname(), ccd.getEiname()));
				}
				form.setSelectedListMap(j++, list);
				continue;
			}
			
			if("IG_0013".equals(e.getClabel())){
				List<LabelValueBean> list = new ArrayList<LabelValueBean>();
				if(e.getCivalue()!=null && !(e.getCivalue().equals(""))){
					dto.setArea(e.getCivalue());					
				}
				form.setSelectedListMap(j++, list);
				continue;
			}
			if("IG_0014".equals(e.getClabel())){
				List<LabelValueBean> list = new ArrayList<LabelValueBean>();
				list.add(new LabelValueBean("", ""));
				SOC0603SearchCondImpl soc0603cond = new SOC0603SearchCondImpl();
				List<SOC0603Info> soc0603List = soc0603BL.searchSOC0603Info(soc0603cond);
				for(SOC0603Info ccd : soc0603List){
					list.add(new LabelValueBean(ccd.getEiname(), ccd.getEiname()));
				}
				form.setSelectedListMap(j++, list);
				continue;
			}
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
				//��ʾ���ʲ����ƣ�ʵ�ʴ�ֵ���ʲ�����(�ʲ�ID)
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
		
		form.setCivalue(civalue);
		form.setEntityItemCivalue(entityItemCivalue);
		form.setDelfile(delfile);
		form.setCivalue_bak(civalue_bak);
		form.setIsUpgrade(isUpgrade);
		dto.setConfigItemVWInfoMap(map);
//		dto.addMessage(new ActionMessage("IGCO10000.I007",totalCount));
		
		
		//��ȡ��ʷ�汾����ʱ��
		if(entityItemVWInfo.getEiversion() > 0) {
			dto.setConfigItemVersionTime(this.soc0118BL.searchVersionUpdateTime(entityItemVWInfo.getEiid()));
		}

    	IG912SearchCondImpl cond = new IG912SearchCondImpl();
    	cond.setInJiguiFlg("Y");
    	cond.setEiid(Integer.parseInt(form.getEiid()));
		//��ǰҳ�豸��Ϣȡ��
		List<IG912Info> computerDeviceVWInfoList = ig912BL.searchIG912Info(cond,0,0);
		if(computerDeviceVWInfoList!=null&&computerDeviceVWInfoList.size()>0){
			dto.setInJiguiFlg("Y");
		}else{
			dto.setInJiguiFlg("N");
		}
		log.debug("========�豸������Ϣ�༭������ڻ���������========");
		return dto;
	}
	
	
	/**
	 * �豸������Ϣ�༭����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public IGASM03DTO editEntityItemAction(IGASM03DTO dto) throws BLException, FileNotFoundException, IOException {
		log.debug("========�豸������Ϣ�༭����ʼ========");
		//�汾������
		IGASM0304Form form = dto.getIgasm0304Form();
		
		//�豸������Ϣ����
		SOC0118TB entityItem = (SOC0118TB) this.soc0118BL.searchEntityItemByKey(Integer.parseInt(form.getEiid()));
		
		// ȡ�ð汾�Ƿ�������ʶ
		String ident = form.getIdent();
		if(StringUtils.isEmpty(ident)){
			ident = IGASM03BLImpl.SAVE_VERSION_UP;
		}
		
		//����ģ������С�汾������������汾
		int version = form.getEiversion();//��汾
		int smallversion = form.getEismallversion();//С�汾
		String fileversion = version + "";//�����汾
		boolean versonFlag = false;
		if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(form.getEmodeltype())) {
			// �ж��Ƿ������汾��
			// =====================>> �޸� start
			if (IGASM03BLImpl.SAVE_VERSION_UP.equals(ident)) { // �����汾��
				smallversion++;
				
				//�ʲ���ϵ��Ϣ�汾��������
				this.soc0119BL.upgradeEntityItemRelation(entityItem.getEiid(), entityItem.getEiversion(), entityItem.getEismallversion(),
						version, smallversion);
				
				if(smallversion - 1 != entityItem.getEismallversion()) {
					throw new BLException("IGCO00000.E004");
				}
			} else if (IGASM03BLImpl.SAVE_VERSION.equals(ident)) { // �������汾��

//				version = form.getEiversion();
				if (smallversion != entityItem.getEismallversion()) {
					throw new BLException("IGCO00000.E004");
				}

				if (form.getEismallversion() == 0) { // ���Ϊ��һ��ʱ�趨�汾��Ϊ ��0.1��
					smallversion = 1;
				}
			}
			//  << =================  end
			fileversion = version + "." + smallversion;
		} else {
//			version++;
			// �ж��Ƿ������汾��
			// =====================>> �޸� start
			if (IGASM03BLImpl.SAVE_VERSION_UP.equals(ident)) { // �����汾��
				version = form.getEiversion() + 1;
				
				//�����Ƿ��ϵ������ѡ���ж��ĸ��ʲ���ϵ����
				String[] cldeiids=new String[form.getCiid().length];
				int index=0;
				if(form.getIsUpgrade()!=null&&form.getIsUpgrade().length>0){
	                for(int i=0;i<form.getIsUpgrade().length;i++){
	                    if(form.getIsUpgrade()[i]!=null&&"1".equals(form.getIsUpgrade()[i])){
	                        if(form.getEntityItemCivalue()[i].lastIndexOf("(") != -1 && form.getEntityItemCivalue()[i].lastIndexOf(")") != -1){
	                            String cldeiid=form.getEntityItemCivalue()[i].substring(form.getEntityItemCivalue()[i].lastIndexOf("(")+1,
	                                    form.getEntityItemCivalue()[i].lastIndexOf(")"));
	                            //���ʲ�������Ϣ
	                            SOC0118TB cldEntityItem = (SOC0118TB) this.soc0118BL.searchEntityItemByKey(Integer.parseInt(cldeiid));
	                            if(cldEntityItem!=null){
	                            	 cldeiids[index]=cldeiid+"_"+cldEntityItem.getEiversion()+"_"+cldEntityItem.getEismallversion()+"_"+form.getCiid()[i];
	                            }
	                        }
	                        index++;
	                    }
	                }
	            }
				
				//�ʲ���ϵ��Ϣ�汾��������
				this.soc0119BL.upgradeEntityItemRelationOne(entityItem.getEiid(), entityItem.getEiversion(), entityItem.getEismallversion(),
						version, 0,cldeiids);
				
				if (version - 1 != entityItem.getEiversion()) {
					throw new BLException("IGCO00000.E004");
				}
			} else if (IGASM03BLImpl.SAVE_VERSION.equals(ident)) { // �������汾��

				version = form.getEiversion();
				if (version != entityItem.getEiversion()) {
					throw new BLException("IGCO00000.E004");
				}

				if (form.getEiversion() == 0) { // ���Ϊ��һ��ʱ�趨�汾��Ϊ ��1��
					versonFlag = true;
					version = 1;
				}
			}
			//  << =================  end
		}

		
		if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(form.getEmodeltype())) {
			//�ʲ�������ϵ��Ϣ�汾��������
			this.soc0110BL.upgradeEntityItemRelation(entityItem.getEiid(), entityItem.getEiversion(), entityItem.getEismallversion(),
					version, smallversion);
		}
		
		
		//�豸״̬
		entityItem.setEistatus(form.getEistatus());
		
		//�豸��汾
		entityItem.setEiversion(version);
		
		//�豸С�汾
		entityItem.setEismallversion(smallversion);
		
		//�豸˵��
		entityItem.setEidesc(form.getEidesc());

		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		
		//����ʱ��
		entityItem.setEiupdtime(datetime);
		
		SOC0118Info hostei = this.soc0118BL.updateEntityItem(entityItem);
		//=======���¹�ϵ��ʼ========
		if(version ==1&&versonFlag){
			SOC0119SearchCondImpl eircond1 = new SOC0119SearchCondImpl();
			//ɾ����ʶ
			eircond1.setDeleteflag("0");
			//����ʲ���صĹ�ϵ��
			eircond1.setEirrelationcode(IGASM03BLImpl.EIRRELATIONCODE);
			eircond1.setEiid(entityItem.getEiid().toString());
			//���ʲ����еĹ�ϵ��Ϣ
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
					//�����ϵʱ
					if(entityItem.getEiid().equals(ig313Info.getPareiid())){
						ig313tb.setParversion(entityItem.getEiversion());
						this.soc0119BL.registEntityItemRelation(ig313tb);
					}
					//�����ϵʱ
					if(entityItem.getEiid().equals(ig313Info.getCldeiid())){
						ig313tb.setCldversion(entityItem.getEiversion());
						this.soc0119BL.registEntityItemRelation(ig313tb);
					}
				}
			}
		}
		//=======���¹�ϵ����========
		
		//���ø���BL
		String rootPath = ResourceUtility.getString("UPLOAD_FILE_ROOT_PATH");
		String fileNameXML = null;
		SOC0118Info hosteiXML = null;
		boolean flagXML = false;
		
		boolean copyFlag = false;//�Ƿ�Ϊ�����������ļ�
		SOC0107TB configItemXML = new SOC0107TB();
		//�豸������Ϣ����
		if (form.getCiid() != null && form.getCiid().length > 0 ) {
			
			for( int i=0 ; i < form.getCiid().length; i++ ){
				SOC0107TB configItem = new SOC0107TB();
				//�豸ID
				configItem.setEiid(Integer.parseInt(form.getEiid()));
				//�ʲ�����ID
				configItem.setCid(form.getCid()[i]);
				//����ID
				configItem.setEid(form.getEid()[i].toString());
				//���Ͳ����
				configItem.setEsyscoding(form.getEsyscoding()[i]);
				//��汾��
				configItem.setCiversion(version);
				//С�汾��
				configItem.setCismallversion(smallversion);
				//����ʱ��
				configItem.setCiupdtime(datetime);
				
				if (StringUtils.isEmpty(form.getCiid()[i])) {
					//Ĭ�����ԣ��豸״̬
					if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_STATUS.equals(form.getClabel()[i])){
						configItem.setCivalue(CommonDefineUtils.ENTITYITEM_STARUS_NEW);
					}else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_OPERATORID.equals(form.getClabel()[i])){
						//Ĭ�����ԣ�������id
						configItem.setCivalue(dto.getUserid());
					}else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_OPERATORNAME.equals(form.getClabel()[i])){
						//Ĭ�����ԣ�������
						configItem.setCivalue(dto.getUsername());
					}else{
						//��ʾ���ʲ����ƣ�ʵ�ʴ�ֵ���ʲ�����(�ʲ�ID)
						if("4".equals(form.getCiattach()[i]) && StringUtils.isNotEmpty(form.getEntityItemCivalue()[i])){
							configItem.setCivalue(form.getEntityItemCivalue()[i]);
						}else {
							configItem.setCivalue(form.getCivalue()[i]);
						}
					}
					
					//���±�ʶ
					if(StringUtils.isEmpty(configItem.getCivalue())) {
						configItem.setCicurver("0");
					} else {
						configItem.setCicurver("1");
					}
					
					configItem = (SOC0107TB) this.soc0107BL.registSOC0107(configItem);
					
					//�������Ϊ�ʲ�ʱ�����ӹ�����ϵ
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
						//˫��
						String relationcode = entityItem.getEsyscoding().substring(3, 6)+"-"+ei.getEsyscoding().substring(3, 6);	
						if(IGASM03BLImpl.DEVICE_DEVICE.equals(relationcode)){
							e.setEirrelation(IGASM03BLImpl.DEVICE_DEVICE_CONN_ID);
							e.setEirrelationcode(IGASM03BLImpl.DEVICE_DEVICE);
						}else{
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
						}
						e.setEirupdtime(datetime);
						//��ѯ��������
						SOC0109Info config = this.soc0109BL.searchConfigurationByKey(form.getCid()[i]);
						String cname = config.getCname();
						e.setEirdesc("�������"+cname+"����");
						//����key
						e.setEirinfo(entityItem.getEiid()+"_"+configItem.getCiid()+"_"+ei.getEiid());
						//����״̬ΪC����ϵ�����в���ɾ��
						e.setEirstatus("C");
						this.soc0119BL.registEntityItemRelation(e);
					}
					
					log.debug("�ʲ������[�ʲ�����ID:" + form.getCid()[i] + "]���봦��ɹ���");
					
				} else {
					if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_OPERATORID.equals(form.getClabel()[i])){
						//Ĭ�����ԣ�������id
						configItem.setCivalue(dto.getUserid());
					}else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_OPERATORNAME.equals(form.getClabel()[i])){
						//Ĭ�����ԣ�������
						configItem.setCivalue(dto.getUsername());
					}else{
						//��ʾ���ʲ����ƣ�ʵ�ʴ�ֵ���ʲ�����(�ʲ�ID)
						if("4".equals(form.getCiattach()[i]) && StringUtils.isNotEmpty(form.getEntityItemCivalue()[i])){
							configItem.setCivalue(form.getEntityItemCivalue()[i]);
						}else {
							configItem.setCivalue(form.getCivalue()[i]);
						}
					}
					
					//���±�ʶĬ��Ϊ0
					configItem.setCicurver("0");
					if ("4".equals(form.getCiattach()[i])){
						if(!form.getCivalue_bak()[i].equals(configItem.getCivalue())){
							//�����ʲ����Ա�ʶ
							configItem.setCicurver("1");
						}
					} else if(!form.getCivalue_bak()[i].equals(configItem.getCivalue())){
						//�������Ա�ʶ
						configItem.setCicurver("1");
					}

					//����ɾ��
					if("1".equals(form.getCiattach()[i]) && "1".equals(form.getDelfile()[i])){
						configItem.setCivalue("");
					}
					
					// �ж��Ƿ������汾�� ��������汾��ִ�в����������� ciid ���и���
					if (IGASM03BLImpl.SAVE_VERSION_UP.equals(ident)) { // �����汾��
						
						configItem = (SOC0107TB) this.soc0107BL.registSOC0107(configItem);

					} else if (IGASM03BLImpl.SAVE_VERSION.equals(ident)) { // �������汾��
					
						Integer ciid = Integer.valueOf(form.getCiid()[i]);
						 
						// ��ȡ��ǰ������
						IG800Info cfi = this.ig800BL.searchIG800InfoByKey(ciid);
						
						// �жϵ�ǰ�������Ƿ���������
						if(configItem.getCid().equals(cfi.getCid())){ // ����������������и���
							
							configItem.setCiid(ciid);
							configItem = (SOC0107TB) this.soc0107BL
								.updateSOC0107(configItem);
							
						}else{  // �����������������
							
							configItem = (SOC0107TB) this.soc0107BL
							.registSOC0107(configItem);
							
						}
					}
					
					
					//�������Ϊ�ʲ�ʱ�����ӹ�����ϵ
					if("4".equals(form.getCiattach()[i]) && StringUtils.isNotEmpty(form.getCivalue()[i])){
						SOC0119TB e = new SOC0119TB();
						e.setPareid(entityItem.getEid());
						e.setPareiid(entityItem.getEiid());
						e.setParversion(entityItem.getEiversion());
						e.setParsmallversion(entityItem.getEismallversion());
						String str = form.getEntityItemCivalue()[i];
						SOC0118Info ei =null;
						try{
							ei = this.soc0118BL.searchEntityItemByKey(Integer.parseInt(str.substring(str.lastIndexOf("(")+1, str.length()-1)));
						}catch(Exception er){
							throw new BLException("IGCO10000.E004", new String[] {
									"("+str.substring(0, str.lastIndexOf("("))+")�ʲ�����"
					            });
						}
						e.setCldeid(ei.getEid());
						e.setCldeiid(ei.getEiid());
						e.setCldversion(ei.getEiversion());
						e.setCldsmallversion(ei.getEismallversion());
						//У���ϵ�Ƿ����
						SOC0119SearchCondImpl condPar = new SOC0119SearchCondImpl();
						condPar.setPareiid(entityItem.getEiid());//�ʲ�ID
						condPar.setParversion(entityItem.getEiversion());//�ʲ���汾
						condPar.setParsmallversion(entityItem.getEismallversion());//�ʲ�С�汾
						condPar.setDeleteflag("0");
						condPar.setEirstatus("C");
						condPar.setEirinfo(entityItem.getEiid()+"_"+form.getCiid()[i]+"_"+ei.getEiid());
						
						List<SOC0119Info> eirlist = this.soc0119BL.searchEntityItemRelation(condPar);
						
						if(eirlist.isEmpty()){
							//ɾ��ԭ�����еĹ�ϵ
							SOC0119SearchCondImpl eircond = new SOC0119SearchCondImpl();
							eircond.setEirinfo(entityItem.getEiid()+"_"+form.getCiid()[i]+"_");
							eircond.setEirstatus("C");
							eircond.setDeleteflag("0");
							List<SOC0119Info> eir = this.soc0119BL.searchMaxEntityItemRelation(eircond);
							for (SOC0119Info entityItemRelation : eir) {
								this.soc0119BL.deleteEntityItemRelation(entityItemRelation);
							}
							//˫��
							String relationcode = entityItem.getEsyscoding().substring(3, 6)+"-"+ei.getEsyscoding().substring(3, 6);	
							if(IGASM03BLImpl.DEVICE_DEVICE.equals(relationcode)){
								e.setEirrelation(IGASM03BLImpl.DEVICE_DEVICE_CONN_ID);
								e.setEirrelationcode(IGASM03BLImpl.DEVICE_DEVICE);
							}else{
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
							}
							e.setEirupdtime(datetime);
							//��ѯ��������
							SOC0109Info config = this.soc0109BL.searchConfigurationByKey(form.getCid()[i]);
							String cname = config.getCname();
							e.setEirdesc("�������"+cname+"����");
							//����key
							e.setEirinfo(entityItem.getEiid()+"_"+configItem.getCiid()+"_"+ei.getEiid());
							//����״̬ΪC����ϵ�����в���ɾ��
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
						//ɾ��ԭ�����еĹ�ϵ
						SOC0119SearchCondImpl eircond = new SOC0119SearchCondImpl();
						eircond.setEirinfo(entityItem.getEiid()+"_"+form.getCiid()[i]+"_");
						eircond.setEirstatus("C");
						eircond.setDeleteflag("0");
						List<SOC0119Info> eir = this.soc0119BL.searchMaxEntityItemRelation(eircond);
						for (SOC0119Info entityItemRelation : eir) {
							this.soc0119BL.deleteEntityItemRelation(entityItemRelation);
						}
					}
					log.debug("�ʲ������[�ʲ�����ID:" + form.getCid()[i] + "]���´���ɹ���");
				}
				
				//�ϴ��ļ����
				if (form.getCiattach()[i].toUpperCase().equals("1")) {
					FormFile file = form.getAttachFile(i);
					if ( file != null && file.getFileSize() > 0) {
						//�ϴ��ļ����ڵ����
						//�ϴ��ļ�·��
						
						StringBuffer pathBuf = new StringBuffer();
						
						//��Ŀ¼
						pathBuf.append(rootPath);
						//����ID
						pathBuf.append("asm"+File.separator);
						//�豸ID
						pathBuf.append(configItem.getEiid());
						pathBuf.append(File.separator);
						
						StringBuffer fileName = new StringBuffer();
						
						//��չ��ȡ��
						String fileType = "";
						String sFileName = file.getFileName();
						int point = sFileName.lastIndexOf(".");
						if (point != -1) {
							fileType = sFileName.substring(point);
							fileName.append(sFileName.substring(0, point));
						}
						
						//�ļ�����Ӱ汾��
						fileName.append("_");
						fileName.append(fileversion);
						//�ļ���չ��
						fileName.append(fileType);

						//�ļ��ϴ�����
						this.fileUploadBL.saveFile(file, pathBuf.toString(), fileName.toString());
						
						//�ϴ��ļ�������
						configItem.setCivalue(fileName.toString());
						
						//�������Ա�ʶ
						configItem.setCicurver("1");
						
						this.soc0107BL.updateSOC0107(configItem);					
						
					}
				}
				//=================================>
				//�ϴ�xml�ļ����
				if (form.getCiattach()[i].toUpperCase().equals("8")) {
					FormFile file = form.getAttachFileXML(i);
					if ( file != null && file.getFileSize() > 0) {
						//�ϴ��ļ����ڵ����
						//�ϴ��ļ�·��
						
						StringBuffer pathBuf = new StringBuffer();
						
						//��Ŀ¼
						pathBuf.append(rootPath+"XML"+File.separator+"asm"+File.separator);
						//�豸ID
						pathBuf.append(configItem.getEiid()+File.separator);
						
						StringBuffer fileName = new StringBuffer();
						
						//��չ��ȡ��
						//String fileType = "";
						//String sFileName = file.getFileName();
//						int point = sFileName.lastIndexOf(".");
//						if (point != -1) {
//							fileType = sFileName.substring(point);
//							fileName.append(sFileName.substring(0, point));
//
//						}

						//�ļ���չ��
						//fileName.append(fileType);
//						fileName.append("config-view.xml");
						fileName.append(file.getFileName());
						fileName.append("_"+String.valueOf(fileversion));//��汾
						//�ļ��ϴ�����
						this.fileUploadBL.saveFile(file, pathBuf.toString(), fileName.toString());
						
						//�ϴ��ļ�������
						configItem.setCivalue(fileName.toString());
						
						//�������Ա�ʶ
						configItem.setCicurver("1");
						
						this.soc0107BL.updateSOC0107(configItem);			
						hosteiXML = hostei;
						flagXML = true;
						fileNameXML = fileName.toString();
						configItemXML = configItem;
						
						copyFlag = true;
					}else{
						if(!copyFlag){
							//�����ļ�����
							//����ģ�崴��Excel�ļ�
							Integer ver = configItem.getCiversion() - 1;
							if(ver==0){
								ver = 1;
							}
							File modelfile = new File(rootPath+"XML"+File.separator+"asm"+File.separator+String.valueOf(configItem.getEiid())+File.separator+"config-view.xml_"+String.valueOf(ver));
							
							if(modelfile.exists()){
								File newfile = new File(rootPath+"XML"+File.separator+"asm"+File.separator+String.valueOf(configItem.getEiid())+File.separator+"config-view.xml_" + fileversion);
								
								FileInputStream fis = new FileInputStream(modelfile);
								BufferedReader in = new BufferedReader(new InputStreamReader(fis));
								
								FileOutputStream output = new FileOutputStream(newfile);
								String str = null;
								while((str=in.readLine())!=null){
									output.write(str.getBytes());
								}
								
								in.close();
								output.flush();
								output.close();
								
								copyFlag = false;
								
								SOC0107TB newConfigItem = (SOC0107TB)SerializationUtils.clone(configItem);
								newConfigItem.setCivalue("config-view.xml_" + fileversion);
								
								this.soc0107BL.updateSOC0107(newConfigItem);			
							}
							
							
							
						}
						
					}
				}
				//<============================================
			}
			
			if(copyFlag){
				//saveXML(new File(rootPath+"XML"+File.separator+"asm"+File.separator+String.valueOf(configItemXML.getEiid())+File.separator+fileNameXML),dto.getUser(),hostei);
			}
			
			
		}
		
		 //����ֵ�����仯ʱ������ʵ��Ķ���CI���Ϊ�޸ģ�����ֶ����յ�Ч��
		if (entityItem.getEirootmark() != null) {
			SOC0118TB topCI = (SOC0118TB) this.soc0118BL.searchEntityItemByKey(entityItem.getEirootmark());
			String topciName = topCI.getEiname();
			SOC0126SearchCondImpl eiDomainDetailMaxVWSearchCond = new SOC0126SearchCondImpl();
			eiDomainDetailMaxVWSearchCond.setTypeId("1");
			eiDomainDetailMaxVWSearchCond.setEiname(topciName);
			List<SOC0138Info> listEiDomainDetailMax=soc0126BL.searchEiDomainDetailVW(eiDomainDetailMaxVWSearchCond,0,0);
			for(SOC0138Info eiDomainDetailMaxVWInfo:listEiDomainDetailMax){
				
				SOC0112PK pk = new SOC0112PK(eiDomainDetailMaxVWInfo.getEiddid(),
						eiDomainDetailMaxVWInfo.getEiddversion(),
						eiDomainDetailMaxVWInfo.getEiname(),
						eiDomainDetailMaxVWInfo.getEiImportversion());
				SOC0112Info eiDomainDetailInfo =soc0112BL.searchEiDomainDetailByPK(pk);
				SOC0112TB instance = (SOC0112TB)SerializationUtils.clone(eiDomainDetailInfo);
				instance.setModifyFlag("1");
				soc0112BL.updateEiDomainDetail(instance);
				
			}
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I005","�豸������Ϣ"));
		
		log.debug("========�豸������Ϣ�༭��������========");
		
		return dto;
	}

	/**
	 * �豸������Ϣ��ʷ��¼������ڻ�����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO initIGASM0305Action(IGASM03DTO dto) throws BLException {
		log.debug("========�豸������Ϣ��ʷ��¼������ڻ�����ʼ========");
		
		//�豸��Ϣ����
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(
				dto.getIgasm0305Form().getEiid());
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","�豸");
		}
		
		if (entityItemVWInfo.getEiversion() == 0 && entityItemVWInfo.getEismallversion() == 0) {
			dto.addMessage(new ActionMessage("IGASM0205.W001"));
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
		
		if (dto.getIgasm0305Form().getCiversion()!=null) {
			dto.getIgasm0305Form().setCiversion(String.valueOf(entityItemVWInfo.getEiversion()));
		}
		//��ȡ��ʷ�汾����ʱ��
		dto.setConfigItemVersionTime(this.soc0118BL.searchVersionUpdateTime(dto.getIgasm0305Form().getEiid()));
		
		//�жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(), entityItemVWInfo);

		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}else{
			dto.setFlag(flag);
		}
		
		log.debug("========�豸������Ϣ��ʷ��¼������ڻ���������========");
		return dto;
	}
	
	/**
	 * �豸������Ϣ�汾�Ƚϻ�����ڻ�����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO initIGASM0305ActionForXML(IGASM03DTO dto) throws BLException {
		log.debug("========�豸������Ϣ��ʷ��¼������ڻ�����ʼ========");
		
		//�豸��Ϣ����
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(
				dto.getIgasm0305Form().getEiid());
		Integer eiid = dto.getIgasm0305Form().getEiid();
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004", "�豸����");
		}
		
		if (entityItemVWInfo.getEiversion() == 0 && entityItemVWInfo.getEismallversion() == 0) {
			dto.addMessage(new ActionMessage("IGASM0205.W001"));
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
		
		if (StringUtils.isEmpty(dto.getIgasm0305Form().getCiversion()+"")) {
			dto.getIgasm0305Form().setCiversion(String.valueOf(entityItemVWInfo.getEiversion()));
		}
		
		String fileversion = entityItemVWInfo.getEiversion() + "";//XML�ļ��汾
		
		if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(entityItemVWInfo.getEmodeltype())) {
			fileversion = fileversion + "_" + entityItemVWInfo.getEismallversion();
		}
		//��ȡ��ʷ�汾����ʱ��
		List<SOC0128Info> old_civtList = this.soc0118BL.searchVersionUpdateTime(dto.getIgasm0305Form().getEiid());
		List<SOC0128Info> civtList = new ArrayList<SOC0128Info>();
		String rootPath = ResourceUtility.getString("UPLOAD_FILE_ROOT_PATH");
		for(SOC0128Info civt:old_civtList){
			File verfile = new File(rootPath+"XML"+File.separator+"asm"+File.separator+eiid+File.separator+"config-view.xml_" + fileversion);
			if(verfile.exists()){
				civtList.add(civt);
			}
		}
		
		dto.setConfigItemVersionTime(civtList);
		
		//�жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(), entityItemVWInfo);

		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}else{
			dto.setFlag(flag);
		}
		
		log.debug("========�豸������Ϣ��ʷ��¼������ڻ���������========");
		return dto;
	}

	/**
	 * �豸��ϵ��������ڻ�����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO initIGASM0306Action(IGASM03DTO dto) throws BLException {
		log.debug("========�豸��ϵ��������ڻ�����ʼ========");
		
		//�豸��Ϣ����
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(
				Integer.parseInt(dto.getIgasm0306Form().getEiid()));
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","�豸");
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
		//�жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(), entityItemVWInfo);
		
		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}else{
			dto.setFlag(flag);
		}
		
		//���������ϵ����
		SOC0119SearchCondImpl parcond = new SOC0119SearchCondImpl();
		if((dto.getIgasm0306Form().getEiid())!=null)
		{parcond.setEiid(dto.getIgasm0306Form().getEiid());}
		parcond.setParversion(entityItemVWInfo.getEiversion());
		parcond.setParsmallversion(entityItemVWInfo.getEismallversion());
		parcond.setDeleteflag("0");
		//�豸��ϵ��Ϣ��ѯ����ȡ�� 
		int totalCount = this.soc0119BL.getEntityItemRelationSearchCount(parcond);
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========�豸��ϵ��Ϣ��ѯ���ݼ�������========");
			//�豸��ϵ��Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		if ( totalCount>0 ) {
			//�豸��ϵ��Ϣȫ������
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

		//���������ϵ����
		//������ϵ����
//		IG313SearchCondImpl cldcond = new IG313SearchCondImpl();
//		
//		cldcond.setCldeiid(dto.getIgasm0306Form().getEiid());
//		cldcond.setCldversion(entityItemVWInfo.getEiversion().toString());
//		cldcond.setCldsmallversion(entityItemVWInfo.getEismallversion().toString());
//		cldcond.setDeleteflag("0");
//		//�豸��ϵ��Ϣ��ѯ����ȡ�� 
//		totalCount = this.ig313BL.getIG313InfoSearchCount(cldcond);
//		
//		if ( totalCount > dto.getMaxSearchCount() ) {
//			log.debug("========�豸��ϵ��Ϣ��ѯ���ݼ�������========");
//			//�豸��ϵ��Ϣ��ѯ���ݼ�������
//			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
//			return dto;
//		}
//
//		//�豸��ϵ��Ϣȫ������
//		List<IG313Info> cldEntityItemRelationList = 
//			this.ig313BL.searchMaxIG313Info(cldcond);
		dto.setParCount(dto.getParCount());
//		dto.addMessage(new ActionMessage("IGCO10000.I007",dto.getParCount()));
//		for(IG313Info e : cldEntityItemRelationList){
//			String key = e.getEirrelationcode().split("-")[0];
//			String eirrelationcode = e.getEirrelationcode();
//			String ecategory = e.getCldEntityItemVW().getEcategory();
//			if(!"-".equals(eirrelationcode.replaceAll(ecategory, ""))){
//				key = eirrelationcode.replaceAll(ecategory, "").replaceAll("-", "");
//			}
//			if(!parmap.containsKey(key)){
//				parmap.put(key, new ArrayList<IG313Info>());
//			}
//			((IG313TB)e).setParflag("1");
//			parmap.get(key).add(e);
//		}
		if(parmap.size()==0){
			parmap = null;
		}
		dto.setParEntityItemRelationMap(parmap);

		
		log.debug("========�豸��ϵ��������ڻ���������========");
		return dto;
	}
	
	
	/**
	 * �豸��ϵ��������ڻ�����(��ʾȫ��������EIΪ��)
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO initIGASM0346Action(IGASM03DTO dto) throws BLException {
		log.debug("========���ð�����ϵ��ʾ����ʼ========");
		
		IGASM0346Form form = dto.getIgasm0346Form();
		//��ѯ���������ʲ��������ӽڵ�
		EiBelongRelationVWSearchCondImpl cond = new EiBelongRelationVWSearchCondImpl();
		cond.setEirootmark(Integer.parseInt(form.getEirootmark()));
		cond.setBrparversion(Integer.parseInt(form.getEiversion()));
		cond.setBrcldversion(cond.getBrparversion());
		List<EiBelongRelationVWInfo> eibrList = this.eiBelongRelationBL.searchEiBelongRelationVW(cond);
		//��ѯ����EI
		IG749Info rootEi = this.ig013BL.searchIG749InfoByKey(Integer.parseInt(form.getEirootmark()));
		//����ѡ���ʲ���汾��ѯ����EI�����С�汾
		Integer rootEiMaxSmallveision = this.ig800BL.searchEiMaxSmallVersion(rootEi.getEiid(), Integer.parseInt(form.getEiversion()));
		//����������
		Map<String,TreeNode> treeNodeMap = new LinkedHashMap<String,TreeNode>();
		//�����	
		TreeNode rootNode = new TreeNode();
		rootNode.setId(rootEi.getEiid() + "_" + rootEi.getEiversion() + "_" + rootEiMaxSmallveision);//�ʲ�ID|��汾|С�汾
		rootNode.setName(rootEi.getEiname() + "(" + form.getEiversion() + "." + rootEiMaxSmallveision + ")");//�ʲ�����
		//�ݹ鹹�������ϵ��
		searchConfigurationTreeNode(eibrList, rootEi, rootNode);
		//�����ڵ�
		treeNodeMap.put(rootNode.getId(),rootNode);		
		dto.setTreeNodeMap(treeNodeMap);
		
		log.debug("========���ð�����ϵ��ʾ��������========");
		return dto;
	}
	
	/**
	 * �豸��ϵ��������ڻ�����(ѡ�е��ʲ�Ϊ��)
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	/*public IGASM03DTO initIGASM0346Action(IGASM03DTO dto) throws BLException {
		log.debug("========���ð�����ϵ��ʾ����ʼ========");
		
		IGASM0346Form form = dto.getIgasm0346Form();
		//��ѯ���������ʲ��������ӽڵ�
		EiBelongRelationVWSearchCondImpl cond = new EiBelongRelationVWSearchCondImpl();
		cond.setEirootmark(Integer.parseInt(form.getEirootmark()));
		cond.setBrparversion(Integer.parseInt(form.getEiversion()));
		cond.setBrcldversion(cond.getBrparversion());
		List<EiBelongRelationVWInfo> eibrList = this.eiBelongRelationBL.searchEiBelongRelationVW(cond);
		//��ѯ��ǰEI
		EntityItemEntityVWInfo rootEi = this.ig013BL.searchEntityItemEntityVWByKey(Integer.parseInt(form.getEiid()));
		//����������
		Map<String,TreeNode> treeNodeMap = new LinkedHashMap<String,TreeNode>();
		//�����	
		TreeNode rootNode = new TreeNode();
		rootNode.setId(rootEi.getEiid() + "_" + form.getEiversion() + "_" + form.getEismallversion());//�ʲ�ID|��汾|С�汾
		rootNode.setName(rootEi.getEiname() + "(" + form.getEiversion() + "." + form.getEismallversion() + ")");//�ʲ�����
		//�ݹ鹹�������ϵ��
		searchConfigurationTreeNode(eibrList, rootEi, rootNode);
		//�����ڵ�
		treeNodeMap.put(rootNode.getId(),rootNode);		
		dto.setTreeNodeMap(treeNodeMap);
		
		log.debug("========���ð�����ϵ��ʾ��������========");
		return dto;
	}*/
	
	/**
	 * �ݹ鹹�����ð���������
	 *
	 * @param eibrList �ڵ㼯��
	 * @param ei �����ʲ��ڵ�
	 * @param parNode �����ڵ�
	 */
	public void searchConfigurationTreeNode(List<EiBelongRelationVWInfo> eibrList,
			IG749Info ei, TreeNode parNode) throws BLException {
		
		//�����ڵ㼯��
		for(EiBelongRelationVWInfo eibr : eibrList) {
			if(ei.getEiid().equals(eibr.getBrpareiid())) {//ƥ��ID
				//�����ӽڵ�
				TreeNode cldNode = new TreeNode();
				cldNode.setId(eibr.getBrcldeiid() + "_" + eibr.getBrcldversion() + "_" + eibr.getBrcldsmallversion());//�ʲ�ID|��汾|С�汾
				cldNode.setName(eibr.getCldEntityItemVW().getEiname() + "(" + eibr.getBrcldversion() + "." + eibr.getBrcldsmallversion() + ")");//�ʲ�����
				//����ӽڵ�
				parNode.addChildTreeNode(cldNode.getId(),cldNode);
				//�ݹ�
				searchConfigurationTreeNode(eibrList, eibr.getCldEntityItemVW(), cldNode);
			}
		}
		
	}
	
	/**
	 * �豸��ϵɾ������
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO deleteEntityItemRelationAction(IGASM03DTO dto) throws BLException {
		log.debug("========�豸��ϵɾ������ʼ========");
		
		for( int i=0;i<dto.getDeleteEntityItemRelation().length;i++ ){
			String eirid = dto.getDeleteEntityItemRelation()[i];
			
			SOC0119Info entityItemRelation = 
				this.soc0119BL.searchEntityItemRelationByKey(Integer.parseInt(eirid));
			
			if (entityItemRelation == null){
				throw new BLException("IGCO10000.E004","ɾ�������豸��ϵ");
			}

			this.soc0119BL.deleteEntityItemRelation(entityItemRelation);
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I006","�豸��ϵ��Ϣ"));

		log.debug("========�豸��ϵɾ����������========");
		return dto;
	}

	/**
	 * �豸��ϵ�ǼǴ���
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO insertEntityItemRelationAction(IGASM03DTO dto) throws BLException {
		log.debug("========�豸��ϵ�ǼǴ���ʼ========");
		
		IGASM0307Form form = dto.getIgasm0307Form();
		
		//�豸ID���ӣ�ȡ��
		IG688SearchCondImpl cond = new IG688SearchCondImpl();
		
		cond.setElabel(form.getElabel());
		cond.setEilabel(form.getEilabel());
		
		List<IG688Info> entityItemVWList = this.ig013BL.searchIG688Info(cond, 0, 0);
		
		if ( entityItemVWList==null || entityItemVWList.size() == 0 ) {
			throw new BLException("IGCO10000.E004","(�ʲ����=" + form.getElabel() + ",�豸���=" 
					+ form.getEilabel() + ")�豸");
		}
		
		form.setCldeiid(entityItemVWList.get(0).getEiid());
		form.setCldeid(entityItemVWList.get(0).getEid().toString());
		
		//�豸ID�������ͣ��ӣ����
		if (form.getPareiid().intValue() == form.getCldeiid().intValue()) {
			//�豸ID������= ���ӣ�
			throw new BLException("IGCO10000.E012","�豸");
		}
		
		//����ʱ���趨
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

		form.setEirupdtime(datetime);
		form.setCldsmallversion(entityItemVWList.get(0).getEismallversion());
		form.setCldversion(entityItemVWList.get(0).getEiversion());
		//�ʲ���ϵ�Ǽ�
		SOC0119Info ret = 
			this.soc0119BL.registEntityItemRelation(dto.getIgasm0307Form());
		
		dto.setEntityItemRelation(ret);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "�ʲ���ϵ��Ϣ") );
		
		log.debug("========�豸��ϵ�ǼǴ�������========");
		return dto;
	}
	
	/**
	 * �豸��ϵ�༭������ڻ�����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO initIGASM0307Action(IGASM03DTO dto) throws BLException {
		log.debug("========�豸��ϵ�༭������ڻ�����ʼ========");
		
		IGASM0307Form form = dto.getIgasm0307Form();
		IG313TB ret = 		
			(IG313TB) this.ig313BL.searchIG313InfoByKey(
				form.getEirid());
		
		if ( ret == null ){
			throw new BLException("IGCO10000.E004","�༭�����豸��ϵ");
		}
		
		//��������趨
		form.setPareiname(ret.getParEntityItemVW().getEiname());
		form.setPareid(ret.getPareid().toString());
		form.setPareiid(ret.getPareiid());
		form.setCldeid(ret.getCldeid().toString());
		form.setCldeiid(ret.getCldeiid());
		form.setEiridStr(ret.getEirid().toString());
		form.setEirdesc(ret.getEirdesc());
		form.setEirinfo(ret.getEirinfo());
		form.setEirrelation(ret.getEirrelation());
		form.setEirrelationcode(ret.getEirrelationcode());
		form.setElabel(ret.getCldEntityItemVW().getElabel());
		form.setEilabel(ret.getCldEntityItemVW().getEilabel());
		form.setEiname(ret.getCldEntityItemVW().getEiname());
		form.setTempeirrelation(ret.getEirrelation()+"#"+ret.getEirrelationcode());
		form.setMode("1");
		
		log.debug("========�豸��ϵ�༭������ڻ���������========");
		return dto;
	}

	/**
	 * �豸��ϵ���������
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO updateEntityItemRelationAction(IGASM03DTO dto) throws BLException {
		log.debug("========�豸��ϵ���������ʼ========");
		IGASM0307Form form = dto.getIgasm0307Form();

		//����ʱ���趨
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

		form.setEirupdtime(datetime);
		
		this.soc0119BL.updateEntityItemRelation(form);

		dto.addMessage(new ActionMessage( "IGCO10000.I005", "�豸��ϵ��Ϣ") );

		log.debug("========�豸��ϵ�������������========");
		return dto;
	}
	
	/**
	 * �豸�·���Ϣ��ѯ����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO searchNewAndReciveEntityItemAction(IGASM03DTO dto) throws BLException {

		log.debug("========�豸�·���Ϣ��ѯ����ʼ========");
		
		//�豸��Ϣ��ѯ����ȡ�� 
		int totalCount = this.soc0118BL.getEntityItemVWSearchCount(dto.getEntityItemVWSearchCond());
		
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
		List<SOC0124Info> entityItemVWInfoList = this.soc0118BL.searchEntityItemVW(dto.getEntityItemVWSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setEntityItemVWInfoList(entityItemVWInfoList);

		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========�豸�·���Ϣ��ѯ��������========");
		return dto;
	}
	

	
	/**
	 * �豸�Ͻ���Ϣ��ѯ����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO searchUsingEntityItemAction(IGASM03DTO dto)
			throws BLException {
		log.debug("========�豸�Ͻ���Ϣ��ѯ����ʼ========");
		
		//�豸��Ϣ��ѯ����ȡ�� 
		int totalCount = this.soc0118BL.getEntityItemVWSearchCount(dto.getEntityItemVWSearchCond());
		
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
		List<SOC0124Info> entityItemVWInfoList = this.soc0118BL.searchEntityItemVW(dto.getEntityItemVWSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setEntityItemVWInfoList(entityItemVWInfoList);

		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========�豸�Ͻ���Ϣ��ѯ��������========");
		return dto;
	}
	
	/**
	 * �豸������Ϣ��ѯ����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO searchCanScrapEntityItemAction(IGASM03DTO dto) throws BLException {
		log.debug("========�豸������Ϣ��ѯ����ʼ========");
		//�豸��Ϣ��ѯ����ȡ�� 
		int totalCount = this.soc0118BL.getEntityItemVWSearchCount(dto.getEntityItemVWSearchCond());
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
		List<SOC0124Info> entityItemVWInfoList = this.soc0118BL.searchEntityItemVW(dto.getEntityItemVWSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);
		dto.setEntityItemVWInfoList(entityItemVWInfoList);
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		log.debug("========�豸������Ϣ��ѯ��������========");
		return dto;
	}
	
	/**
	 * �豸�·�����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public void entityIssueAction(IGASM03DTO dto) throws BLException {

		log.debug("========�豸�·�����ʼ========");
		
		IG013TB entityItem = (IG013TB)ig013BL.searchIG013InfoByKey(dto.getIgasm0309Form().getEiid());
		entityItem.setEistatus(CommonDefineUtils.ENTITYITEM_STARUS_USE);
//		entityItem.setEiorgsyscoding(dto.getIgasm0309Form().getOrgid());
		
		IG800SearchCondImpl cond = new IG800SearchCondImpl();
		cond.setEiid(dto.getIgasm0309Form().getEiid());
		if((dto.getIgasm0309Form().getEiversion())!=null){
		cond.setCiversion(dto.getIgasm0309Form().getEiversion());}
		cond.setCismallversion(entityItem.getEismallversion().toString());
		List<IG800Info> configItemList = ig800BL.searchIG800Info(cond, 0, 0);
		
		IG117Info entity = this.ig117BL.searchIG117InfoByKey(entityItem.getEid());
		
		Integer old_eiversion = entityItem.getEiversion();
		Integer old_eismallversion = entityItem.getEismallversion();
		
		if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(entity.getEmodeltype())) {
			entityItem.setEismallversion(entityItem.getEismallversion() + 1);
		} else {
			entityItem.setEiversion(entityItem.getEiversion() + 1);
		}
		
		//�ʲ���ϵ��Ϣ�汾��������
		this.ig313BL.upgradeIG313Info(entityItem.getEiid(), old_eiversion, old_eismallversion,
				entityItem.getEiversion(), entityItem.getEismallversion());
		
		if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(entity.getEmodeltype())) {
			//�ʲ�������ϵ��Ϣ�汾��������
			this.eiBelongRelationBL.upgradeEntityItemRelation(entityItem.getEiid(), old_eiversion, old_eismallversion,
					entityItem.getEiversion(), entityItem.getEismallversion());
		}
		ig013BL.updateIG013Info(entityItem);
		String updatetime = IGStringUtils.getCurrentDateTime();
		for (IG800Info configItem : configItemList) {
			IG800TB ciTB = (IG800TB)SerializationUtils.clone(configItem);
			ciTB.setCiid(null);
			if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(entity.getEmodeltype())) {
				ciTB.setCismallversion(configItem.getCismallversion() + 1);
			} else {
				ciTB.setCiversion(configItem.getCiversion() + 1);
			}
			String cLabel = configItem.getConfiguration().getClabel();
			if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_STATUS.equals(cLabel)){
				ciTB.setCivalue(CommonDefineUtils.ENTITYITEM_STARUS_USE);
			} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_OPERATORID.equals(cLabel)){
				ciTB.setCivalue(dto.getUserid());
			} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_OPERATORNAME.equals(cLabel)){
				ciTB.setCivalue(dto.getUsername());
			} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_RECIVENAME.equals(cLabel)){
				ciTB.setCivalue(dto.getIgasm0309Form().getReciveUser());
			} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_RECIVEORGNAME.equals(cLabel)){
				ciTB.setCivalue(dto.getIgasm0309Form().getOrgname());
			} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_RECIVEORGCODE.equals(cLabel)){
				ciTB.setCivalue(dto.getIgasm0309Form().getOrgid());
			}
			String civalue = configItem.getCivalue();
			String tbcivalue = ciTB.getCivalue();
			if(civalue == null){
				civalue = "";
			}
			if(tbcivalue == null){
				tbcivalue = "";
			}
			if(civalue.equals(tbcivalue)) {
				//���Ը��±�ʶ
				ciTB.setCicurver("0");
			} else {
				//���Ը��±�ʶ
				ciTB.setCicurver("1");
			}
			ciTB.setCiupdtime(updatetime);
			IG800Info ci = ig800BL.registIG800Info(ciTB);
			//�������Ϊ�ʲ�ʱ���޸Ĺ�����ϵ
			if("4".equals(configItem.getConfiguration().getCattach()) && StringUtils.isNotEmpty(configItem.getCivalue())){
				


				String str = ci.getCivalue();	
				IG013Info ei = new IG013TB(); 
				Integer eiid = Integer.parseInt(str.substring(str.lastIndexOf("(")+1, str.length()-1)); 
				try{
					ei = ig013BL.searchIG013InfoByKey(eiid);
					//У���ϵ�Ƿ����
					IG313SearchCondImpl eirCond = new IG313SearchCondImpl();
					eirCond.setEirinfo(ci.getEiid()+"_"+configItem.getCiid()+"_"+ei.getEiid());
					eirCond.setEirstatus("C");
					eirCond.setDeleteflag("0");
					eirCond.setParversion(ci.getCiversion());//�ʲ���汾
					eirCond.setParsmallversion(configItem.getCismallversion());//�ʲ�С�汾
					
					List<IG313Info> eirlist = ig313BL.searchMaxIG313Info(eirCond);
					if(eirlist.size() != 1) {
						throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR, "IGCO10000.E017");
					} else {
						IG313TB eirTB = (IG313TB)SerializationUtils.clone(eirlist.get(0));
//						eirTB.setEirid(null);
						eirTB.setEirupdtime(IGStringUtils.getCurrentDateTime());
						eirTB.setEirinfo(eirTB.getEirinfo().replaceAll("_" + configItem.getCiid() + "_", "_" + ci.getCiid() + "_"));
						eirTB.setParversion(ci.getCiversion());
						eirTB.setParsmallversion(ci.getCismallversion());
						ig313BL.updateIG313Info(eirTB);
					}
				}catch(Exception ex){
					log.warn("��ģʽ��ϵ��Ϣ�д��ڵ��ʲ�eiid���ʲ����в����ڡ�eiid:"+eiid);
				}
			
			}
		}
		
		dto.addMessage(new ActionMessage("IGASM0309.I001"));
	}
	
	/**
	 * �豸�����·�����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public void entityBatchIssueAction(IGASM03DTO dto) throws BLException{
		for (int i = 0; i < dto.getBatchEntityItem().length; i++) {
			IG800SearchCondImpl cond = new IG800SearchCondImpl();
			Integer eiid =Integer.parseInt(dto.getBatchEntityItem()[i]);
			cond.setEiid(eiid);
			IG013TB entityItem = (IG013TB)ig013BL.searchIG013InfoByKey(eiid);
			cond.setCiversion(String.valueOf(entityItem.getEiversion()));
			cond.setCismallversion(entityItem.getEismallversion().toString());
			List<IG800Info> configItemList = ig800BL.searchIG800Info(cond, 0, 0);
			
			IG117Info entity = this.ig117BL.searchIG117InfoByKey(entityItem.getEid());

			Integer old_eiversion = entityItem.getEiversion();
			Integer old_eismallversion = entityItem.getEismallversion();
			if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(entity.getEmodeltype())) {
				entityItem.setEismallversion(entityItem.getEismallversion() + 1);
			} else {
				entityItem.setEiversion(entityItem.getEiversion() + 1);
			}
			
			entityItem.setEistatus(CommonDefineUtils.ENTITYITEM_STARUS_USE);
			ig013BL.updateIG013Info(entityItem);
			
			//�ʲ���ϵ��Ϣ�汾��������
			this.ig313BL.upgradeIG313Info(entityItem.getEiid(), old_eiversion, old_eismallversion,
					entityItem.getEiversion(), entityItem.getEismallversion());
			
			if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(entity.getEmodeltype())) {
				//�ʲ�������ϵ��Ϣ�汾��������
				this.eiBelongRelationBL.upgradeEntityItemRelation(entityItem.getEiid(), old_eiversion, old_eismallversion,
						entityItem.getEiversion(), entityItem.getEismallversion());
			}
			
			for (IG800Info configItem : configItemList) {
				IG800TB ciTB = (IG800TB)SerializationUtils.clone(configItem);
				ciTB.setCiid(null);
				if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(entity.getEmodeltype())) {
					ciTB.setCismallversion(configItem.getCismallversion() + 1);
				} else {
					ciTB.setCiversion(configItem.getCiversion() + 1);
				}
				String cLabel = configItem.getConfiguration().getClabel();
				if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_STATUS.equals(cLabel)){
					ciTB.setCivalue(CommonDefineUtils.ENTITYITEM_STARUS_USE);
				} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_OPERATORID.equals(cLabel)){
					ciTB.setCivalue(dto.getUserid());
				} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_OPERATORNAME.equals(cLabel)){
					ciTB.setCivalue(dto.getUsername());
				} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_RECIVENAME.equals(cLabel)){
					ciTB.setCivalue(dto.getIgasm0309Form().getReciveUser());
				} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_RECIVEORGNAME.equals(cLabel)){
					ciTB.setCivalue(dto.getIgasm0309Form().getOrgname());
				} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_RECIVEORGCODE.equals(cLabel)){
					ciTB.setCivalue(dto.getIgasm0309Form().getOrgid());
				}
				if(configItem.getCivalue()==null&&ciTB.getCivalue()==null) {
					//���Ը��±�ʶ
					ciTB.setCicurver("0");
				}else if(configItem.getCivalue()!=null&&configItem.getCivalue().equals(ciTB.getCivalue())){
					ciTB.setCicurver("0");
				}else {
					//���Ը��±�ʶ
					ciTB.setCicurver("1");
				}
				IG800Info ci = ig800BL.registIG800Info(ciTB);
				//�������Ϊ�ʲ�ʱ���޸Ĺ�����ϵ
				if("4".equals(configItem.getConfiguration().getCattach()) && StringUtils.isNotEmpty(configItem.getCivalue())){
					IG313TB e = new IG313TB();
					e.setPareid(entityItem.getEid());
					e.setPareiid(entityItem.getEiid());
					e.setParversion(entityItem.getEiversion());
					e.setParsmallversion(entityItem.getEismallversion());
					String str = configItem.getCivalue();			
					IG013Info ei = this.ig013BL.searchIG013InfoByKey(Integer.parseInt(str.substring(str.lastIndexOf("(")+1, str.length()-1)));
					e.setCldeid(ei.getEid());
					e.setCldeiid(ei.getEiid());
					e.setCldversion(ei.getEiversion());
					e.setCldsmallversion(ei.getEismallversion());
					//У���ϵ�Ƿ����
					IG313SearchCondImpl eirCond = new IG313SearchCondImpl();
					eirCond.setEirinfo(entityItem.getEiid()+"_"+configItem.getCiid()+"_"+ei.getEiid());
					eirCond.setEirstatus("C");
					eirCond.setDeleteflag("0");
					List<IG313Info> eirlist = this.ig313BL.searchMaxIG313Info(eirCond);
					if(eirlist.size() != 1) {
						throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR, "IGCO10000.E017");
					} else {
						IG313TB eirTB = (IG313TB)SerializationUtils.clone(eirlist.get(0));
						
						eirTB.setEirinfo(eirTB.getEirinfo().replaceAll("_" + configItem.getCiid() + "_", "_" + ci.getCiid() + "_"));
						
						this.ig313BL.updateIG313Info(eirTB);
					}
				}
			}
			
		}
		dto.addMessage(new ActionMessage("IGASM0309.I001"));
	}
	
	/**
	 * ��ѯָ��eiid�Ĵ��Ͻ��豸
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO searchEntityPayByEiidAction(IGASM03DTO dto) throws BLException {

		log.debug("========���Ͻ��豸��ѯ��ʼ========");
		IG800SearchCondImpl cond = new IG800SearchCondImpl();
		cond.setEiid(dto.getIgasm0313Form().getEiid());
		List<IG800Info> configItemList = ig800BL.searchIG800Info(cond, 0, 0);
		ArrayList<IG800Info> list = new ArrayList<IG800Info>();//�洢���µ��豸�汾��Ϣ
		//int version = 0;
		//ȡ�����µİ汾��Ϣ
//		for(int i = 0,j = configItemList.size();i<j;i++ ){
//			if(i==0){
//				version = configItemList.get(i).getCiversion();
//				list.add(configItemList.get(i));
//			}else{
//				if(version==configItemList.get(i).getCiversion()){
//					list.add(configItemList.get(i));
//				}
//			}
//			
//		}
		IG013Info entityItem = ig013BL.searchIG013InfoByKey(dto.getIgasm0313Form().getEiid());
		for(int i = 0,j = configItemList.size();i<j;i++ ){
			if(entityItem.getEiversion().equals(configItemList.get(i).getCiversion())
					&& entityItem.getEismallversion().equals(configItemList.get(i).getCismallversion())){
				list.add(configItemList.get(i));
			}
		}
		//ȡ��������,����
		for(IG800Info config:list){
			if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_RECIVENAME.equals(config.getConfiguration().getClabel())){//������name
				dto.setRecivename(config.getCivalue());
			}
			if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_RECIVEORGNAME.equals(config.getConfiguration().getClabel())){//������org
				dto.setOrgname(config.getCivalue());
				
			}
		}
		log.debug("========���Ͻ��豸��ѯ����========");
		return dto;
	}
	
	/**
	 * �豸�Ͻɴ���
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public void entityPayAction(IGASM03DTO dto) throws BLException {

		log.debug("========�豸�Ͻɴ���ʼ========");
		IG013TB entityItem = (IG013TB)ig013BL.searchIG013InfoByKey(dto.getIgasm0313Form().getEiid());
		entityItem.setEistatus(CommonDefineUtils.ENTITYITEM_STARUS_RENEW);
	//	entityItem.setEiorgsyscoding(dto.getIgasm0313Form().getEiiorgid().substring(0, 4));//ȡ�����˻�����1������
		IG117Info entity = this.ig117BL.searchIG117InfoByKey(entityItem.getEid());
		
		IG800SearchCondImpl cond = new IG800SearchCondImpl();
		cond.setEiid(dto.getIgasm0313Form().getEiid());
		cond.setCiversion(dto.getIgasm0313Form().getEiversion());
		cond.setCismallversion(entityItem.getEismallversion().toString());
		List<IG800Info> configItemList = ig800BL.searchIG800Info(cond, 0, 0);

		Integer old_eiversion = entityItem.getEiversion();
		Integer old_eismallversion = entityItem.getEismallversion();
		if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(entity.getEmodeltype())) {
			entityItem.setEismallversion(entityItem.getEismallversion() + 1);
		} else {
			entityItem.setEiversion(entityItem.getEiversion() + 1);
		}
		ig013BL.updateIG013Info(entityItem);
		//�ʲ���ϵ��Ϣ�汾��������
		this.ig313BL.upgradeIG313Info(entityItem.getEiid(), old_eiversion, old_eismallversion,
				entityItem.getEiversion(), entityItem.getEismallversion());
		
		if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(entity.getEmodeltype())) {
			//�ʲ�������ϵ��Ϣ�汾��������
			this.eiBelongRelationBL.upgradeEntityItemRelation(entityItem.getEiid(), old_eiversion, old_eismallversion,
					entityItem.getEiversion(), entityItem.getEismallversion());
		}
		String updatetime = IGStringUtils.getCurrentDateTime();
		for (IG800Info configItem : configItemList) {
			IG800TB ciTB = (IG800TB)SerializationUtils.clone(configItem);
			ciTB.setCiid(null);
			if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(entity.getEmodeltype())) {
				ciTB.setCismallversion(configItem.getCismallversion() + 1);
			} else {
				ciTB.setCiversion(configItem.getCiversion() + 1);
			}
			String cLabel = configItem.getConfiguration().getClabel();
			if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_STATUS.equals(cLabel)){//�ʲ�״̬
				ciTB.setCivalue(CommonDefineUtils.ENTITYITEM_STARUS_RENEW);
			} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_OPERATORID.equals(cLabel)){//������ID
				ciTB.setCivalue(dto.getUserid());
			} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_OPERATORNAME.equals(cLabel)){//������name
				ciTB.setCivalue(dto.getUsername());
			} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_RECIVENAME.equals(cLabel)){
				ciTB.setCivalue("");
			} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_RECIVEORGNAME.equals(cLabel)){
				ciTB.setCivalue("");
			} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_RECIVEORGCODE.equals(cLabel)){
				ciTB.setCivalue("");
			}
			if(configItem.getCivalue()==null&&ciTB.getCivalue()==null){
				//���Ը��±�ʶ
				ciTB.setCicurver("0");
			}else if(configItem.getCivalue()!=null&&configItem.getCivalue().equals(ciTB.getCivalue())) {
				//���Ը��±�ʶ
				ciTB.setCicurver("0");
			} else {
				//���Ը��±�ʶ
				ciTB.setCicurver("1");
			}
			ciTB.setCiupdtime(updatetime);
			IG800Info ci = ig800BL.registIG800Info(ciTB);
			//�������Ϊ�ʲ�ʱ���޸Ĺ�����ϵ
			if("4".equals(configItem.getConfiguration().getCattach()) && StringUtils.isNotEmpty(configItem.getCivalue())){
				IG313TB e = new IG313TB();
				e.setPareid(entityItem.getEid());
				e.setPareiid(entityItem.getEiid());
				e.setParversion(entityItem.getEiversion());
				e.setParsmallversion(entityItem.getEismallversion());
				String str = configItem.getCivalue();			
				IG013Info ei = this.ig013BL.searchIG013InfoByKey(Integer.parseInt(str.substring(str.lastIndexOf("(")+1, str.length()-1)));
				e.setCldeid(ei.getEid());
				e.setCldeiid(ei.getEiid());
				e.setCldversion(ei.getEiversion());
				e.setCldsmallversion(ei.getEismallversion());
				//У���ϵ�Ƿ����
				IG313SearchCondImpl eirCond = new IG313SearchCondImpl();
				eirCond.setEirinfo(entityItem.getEiid()+"_"+configItem.getCiid()+"_"+ei.getEiid());
				eirCond.setEirstatus("C");
				eirCond.setDeleteflag("0");
				List<IG313Info> eirlist = this.ig313BL.searchMaxIG313Info(eirCond);
				if(eirlist.size() != 1) {
					throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR, "IGCO10000.E017");
				} else {
					IG313TB eirTB = (IG313TB)SerializationUtils.clone(eirlist.get(0));
					
					eirTB.setEirinfo(eirTB.getEirinfo().replaceAll("_" + configItem.getCiid() + "_", "_" + ci.getCiid() + "_"));
					
					this.ig313BL.updateIG313Info(eirTB);
				}
			}
		}
		
		dto.addMessage(new ActionMessage("IGASM0313.I001"));
		
	}
	
	/**
	 * �豸�����Ͻɴ���
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public void entityBatchPayAction(IGASM03DTO dto) throws BLException {

		log.debug("========�豸�����Ͻɴ���ʼ========");
		for (int i = 0; i < dto.getBatchEntityItem().length; i++) {
		IG800SearchCondImpl cond = new IG800SearchCondImpl();
		Integer eiid =Integer.parseInt(dto.getBatchEntityItem()[i]);
		cond.setEiid(eiid);
		IG013TB entityItem = (IG013TB)ig013BL.searchIG013InfoByKey(eiid);
		IG117Info entity = this.ig117BL.searchIG117InfoByKey(entityItem.getEid());
		cond.setCiversion(String.valueOf(entityItem.getEiversion()));
		cond.setCismallversion(entityItem.getEismallversion().toString());
		List<IG800Info> configItemList = ig800BL.searchIG800Info(cond, 0, 0);
		entityItem.setEistatus(CommonDefineUtils.ENTITYITEM_STARUS_RENEW);

		Integer old_eiversion = entityItem.getEiversion();
		Integer old_eismallversion = entityItem.getEismallversion();
		if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(entity.getEmodeltype())) {
			entityItem.setEismallversion(entityItem.getEismallversion() + 1);
		} else {
			entityItem.setEiversion(entityItem.getEiversion() + 1);
		}
		ig013BL.updateIG013Info(entityItem);
		//�ʲ���ϵ��Ϣ�汾��������
		this.ig313BL.upgradeIG313Info(entityItem.getEiid(), old_eiversion, old_eismallversion,
				entityItem.getEiversion(), entityItem.getEismallversion());
		
		if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(entity.getEmodeltype())) {
			//�ʲ�������ϵ��Ϣ�汾��������
			this.eiBelongRelationBL.upgradeEntityItemRelation(entityItem.getEiid(), old_eiversion, old_eismallversion,
					entityItem.getEiversion(), entityItem.getEismallversion());
		}
		for (IG800Info configItem : configItemList) {
			IG800TB ciTB = (IG800TB)SerializationUtils.clone(configItem);
			ciTB.setCiid(null);
			if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(entity.getEmodeltype())) {
				ciTB.setCismallversion(configItem.getCismallversion() + 1);
			} else {
				ciTB.setCiversion(configItem.getCiversion() + 1);
			}
			String cLabel = configItem.getConfiguration().getClabel();
			if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_STATUS.equals(cLabel)){//�ʲ�״̬
				ciTB.setCivalue(CommonDefineUtils.ENTITYITEM_STARUS_RENEW);
			} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_OPERATORID.equals(cLabel)){//������ID
				ciTB.setCivalue(dto.getUserid());
			} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_OPERATORNAME.equals(cLabel)){//������name
				ciTB.setCivalue(dto.getUsername());
			} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_RECIVENAME.equals(cLabel)){
				ciTB.setCivalue("");
			} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_RECIVEORGNAME.equals(cLabel)){
				ciTB.setCivalue("");
			} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_RECIVEORGCODE.equals(cLabel)){
				ciTB.setCivalue("");
			}
			if(configItem.getCivalue()==null&&ciTB.getCivalue()==null) {
				//���Ը��±�ʶ
				ciTB.setCicurver("0");
			} else if(configItem.getCivalue()!=null&&configItem.getCivalue().equals(ciTB.getCivalue())){
				//���Ը��±�ʶ
				ciTB.setCicurver("0");
			}else {
				//���Ը��±�ʶ
				ciTB.setCicurver("1");
			}
			IG800Info ci = ig800BL.registIG800Info(ciTB);
			//�������Ϊ�ʲ�ʱ���޸Ĺ�����ϵ
			if("4".equals(configItem.getConfiguration().getCattach()) && StringUtils.isNotEmpty(configItem.getCivalue())){
				IG313TB e = new IG313TB();
				e.setPareid(entityItem.getEid());
				e.setPareiid(entityItem.getEiid());
				e.setParversion(entityItem.getEiversion());
				e.setParsmallversion(entityItem.getEismallversion());
				String str = configItem.getCivalue();			
				IG013Info ei = this.ig013BL.searchIG013InfoByKey(Integer.parseInt(str.substring(str.lastIndexOf("(")+1, str.length()-1)));
				e.setCldeid(ei.getEid());
				e.setCldeiid(ei.getEiid());
				e.setCldversion(ei.getEiversion());
				e.setCldsmallversion(ei.getEismallversion());
				//У���ϵ�Ƿ����
				IG313SearchCondImpl eirCond = new IG313SearchCondImpl();
				eirCond.setEirinfo(entityItem.getEiid()+"_"+configItem.getCiid()+"_"+ei.getEiid());
				eirCond.setEirstatus("C");
				eirCond.setDeleteflag("0");
				List<IG313Info> eirlist = this.ig313BL.searchMaxIG313Info(eirCond);
				if(eirlist.size() != 1) {
					throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR, "IGCO10000.E017");
				} else {
					IG313TB eirTB = (IG313TB)SerializationUtils.clone(eirlist.get(0));
					
					eirTB.setEirinfo(eirTB.getEirinfo().replaceAll("_" + configItem.getCiid() + "_", "_" + ci.getCiid() + "_"));
					
					this.ig313BL.updateIG313Info(eirTB);
				}
			}
		}
		
		}
		dto.addMessage(new ActionMessage("IGASM0313.I001"));
		log.debug("========�豸�����Ͻɴ���ʼ========");
		
	}
	public IGASM03DTO searchPreScrapEntityItemAction(IGASM03DTO dto) throws BLException {
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(dto.getIgasm0311Form().getEiid());
		dto.setEntityItemVWInfo(entityItemVWInfo);
		//�жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(), entityItemVWInfo);
		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E023","Ԥ����"));
		}
		dto.setFlag(flag);
		return dto;
	}
	
	public IGASM03DTO searchScrapEntityItemAction(IGASM03DTO dto) throws BLException {
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(dto.getIgasm0314Form().getEiid());
		dto.setEntityItemVWInfo(entityItemVWInfo);
		//�жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(), entityItemVWInfo);
		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E023","����"));
		}
		dto.setFlag(flag);
		return dto;
	}
	
	public IGASM03DTO searchReceiveEntityItemAction(IGASM03DTO dto) throws BLException {
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(dto.getIgasm0315Form().getEiid());
		dto.setEntityItemVWInfo(entityItemVWInfo);
		//�жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(), entityItemVWInfo);
		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E023","����Ԥ����"));
		}
		dto.setFlag(flag);
		return dto;
	}
		
	/**
	 * �豸Ԥ���ϴ���
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public void entityPreScrapAction(IGASM03DTO dto) throws BLException {
			IG013TB entityItem = (IG013TB)ig013BL.searchIG013InfoByKey(dto.getIgasm0311Form().getEiid());
			IG800SearchCondImpl cond = new IG800SearchCondImpl();
			cond.setEiid(dto.getIgasm0311Form().getEiid());
			cond.setCiversion(dto.getIgasm0311Form().getEiversion());
			cond.setCismallversion(entityItem.getEismallversion().toString());
			this.saveConfigItem(dto, cond, CommonDefineUtils.ENTITYITEM_STARUS_PRESCRAP);
			
			entityItem.setEistatus(CommonDefineUtils.ENTITYITEM_STARUS_PRESCRAP);
			IG117Info entity = this.ig117BL.searchIG117InfoByKey(entityItem.getEid());
			Integer old_eiversion = entityItem.getEiversion();
			Integer old_eismallversion = entityItem.getEismallversion();
			if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(entity.getEmodeltype())) {
				entityItem.setEismallversion(entityItem.getEismallversion() + 1);
			} else {
				entityItem.setEiversion(entityItem.getEiversion() + 1);
			}
			ig013BL.updateIG013Info(entityItem);
			//�ʲ���ϵ��Ϣ�汾��������
			this.ig313BL.upgradeIG313Info(entityItem.getEiid(), old_eiversion, old_eismallversion,
					entityItem.getEiversion(), entityItem.getEismallversion());
			
			if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(entity.getEmodeltype())) {
				//�ʲ�������ϵ��Ϣ�汾��������
				this.eiBelongRelationBL.upgradeEntityItemRelation(entityItem.getEiid(), old_eiversion, old_eismallversion,
						entityItem.getEiversion(), entityItem.getEismallversion());
			}
	}
	
	public void entityPreScrapBatchAction(IGASM03DTO dto) throws BLException {
		for (int i = 0; i < dto.getBatchEntityItem().length; i++) {
			IG800SearchCondImpl cond = new IG800SearchCondImpl();
			cond.setEiid(Integer.parseInt(dto.getBatchEntityItem()[i]));
			IG013TB entityItem = (IG013TB)ig013BL.searchIG013InfoByKey(Integer.parseInt(dto.getBatchEntityItem()[i]));
			cond.setCiversion(String.valueOf(entityItem.getEiversion()));
			cond.setCismallversion(entityItem.getEismallversion().toString());
			this.saveConfigItem(dto, cond, CommonDefineUtils.ENTITYITEM_STARUS_PRESCRAP);
			
			entityItem.setEistatus(CommonDefineUtils.ENTITYITEM_STARUS_PRESCRAP);
			IG117Info entity = this.ig117BL.searchIG117InfoByKey(entityItem.getEid());
			Integer old_eiversion = entityItem.getEiversion();
			Integer old_eismallversion = entityItem.getEismallversion();
			if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(entity.getEmodeltype())) {
				entityItem.setEismallversion(entityItem.getEismallversion() + 1);
			} else {
				entityItem.setEiversion(entityItem.getEiversion() + 1);
			}
			ig013BL.updateIG013Info(entityItem);
			//�ʲ���ϵ��Ϣ�汾��������
			this.ig313BL.upgradeIG313Info(entityItem.getEiid(), old_eiversion, old_eismallversion,
					entityItem.getEiversion(), entityItem.getEismallversion());
			
			if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(entity.getEmodeltype())) {
				//�ʲ�������ϵ��Ϣ�汾��������
				this.eiBelongRelationBL.upgradeEntityItemRelation(entityItem.getEiid(), old_eiversion, old_eismallversion,
						entityItem.getEiversion(), entityItem.getEismallversion());
			}
		}
	}
	
	/**
	 * �豸���ϴ���
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public void entityScrapAction(IGASM03DTO dto) throws BLException {
		IG800SearchCondImpl cond = new IG800SearchCondImpl();
		cond.setEiid(dto.getIgasm0314Form().getEiid());
		cond.setCiversion(dto.getIgasm0314Form().getEiversion());
		IG013TB entityItem = (IG013TB)ig013BL.searchIG013InfoByKey(dto.getIgasm0314Form().getEiid());
		cond.setCismallversion(entityItem.getEismallversion().toString());
		this.saveConfigItem(dto, cond, CommonDefineUtils.ENTITYITEM_STARUS_SCRAP);
		
		entityItem.setEistatus(CommonDefineUtils.ENTITYITEM_STARUS_SCRAP);
		IG117Info entity = this.ig117BL.searchIG117InfoByKey(entityItem.getEid());
		Integer old_eiversion = entityItem.getEiversion();
		Integer old_eismallversion = entityItem.getEismallversion();
		if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(entity.getEmodeltype())) {
			entityItem.setEismallversion(entityItem.getEismallversion() + 1);
		} else {
			entityItem.setEiversion(entityItem.getEiversion() + 1);
		}
		ig013BL.updateIG013Info(entityItem);
		//�ʲ���ϵ��Ϣ�汾��������
		this.ig313BL.upgradeIG313Info(entityItem.getEiid(), old_eiversion, old_eismallversion,
				entityItem.getEiversion(), entityItem.getEismallversion());
		
		if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(entity.getEmodeltype())) {
			//�ʲ�������ϵ��Ϣ�汾��������
			this.eiBelongRelationBL.upgradeEntityItemRelation(entityItem.getEiid(), old_eiversion, old_eismallversion,
					entityItem.getEiversion(), entityItem.getEismallversion());
		}
	}
	
	public void entityScrapBatchAction(IGASM03DTO dto) throws BLException {
		for (int i = 0; i < dto.getBatchEntityItem().length; i++) {
			IG800SearchCondImpl cond = new IG800SearchCondImpl();
			cond.setEiid(Integer.parseInt(dto.getBatchEntityItem()[i]));
			IG013TB entityItem = (IG013TB)ig013BL.searchIG013InfoByKey(Integer.parseInt(dto.getBatchEntityItem()[i]));
			cond.setCiversion(String.valueOf(entityItem.getEiversion()));
			cond.setCismallversion(entityItem.getEismallversion().toString());
			this.saveConfigItem(dto, cond, CommonDefineUtils.ENTITYITEM_STARUS_SCRAP);
			
			entityItem.setEistatus(CommonDefineUtils.ENTITYITEM_STARUS_SCRAP);
			IG117Info entity = this.ig117BL.searchIG117InfoByKey(entityItem.getEid());
			Integer old_eiversion = entityItem.getEiversion();
			Integer old_eismallversion = entityItem.getEismallversion();
			if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(entity.getEmodeltype())) {
				entityItem.setEismallversion(entityItem.getEismallversion() + 1);
			} else {
				entityItem.setEiversion(entityItem.getEiversion() + 1);
			}
			ig013BL.updateIG013Info(entityItem);
			//�ʲ���ϵ��Ϣ�汾��������
			this.ig313BL.upgradeIG313Info(entityItem.getEiid(), old_eiversion, old_eismallversion,
					entityItem.getEiversion(), entityItem.getEismallversion());
			
			if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(entity.getEmodeltype())) {
				//�ʲ�������ϵ��Ϣ�汾��������
				this.eiBelongRelationBL.upgradeEntityItemRelation(entityItem.getEiid(), old_eiversion, old_eismallversion,
						entityItem.getEiversion(), entityItem.getEismallversion());
			}
		}
	}
	
	/**
	 * �豸Ԥ���ϳ�������
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public void entityCancelPreScrapAction(IGASM03DTO dto) throws BLException {
		IG800SearchCondImpl cond = new IG800SearchCondImpl();
		cond.setEiid(dto.getIgasm0315Form().getEiid());
		cond.setCiversion(dto.getIgasm0315Form().getEiversion());
		IG013TB entityItem = (IG013TB)ig013BL.searchIG013InfoByKey(dto.getIgasm0315Form().getEiid());
		cond.setCismallversion(entityItem.getEismallversion().toString());
		this.saveConfigItem(dto, cond, CommonDefineUtils.ENTITYITEM_STARUS_RENEW);
		
		entityItem.setEistatus(CommonDefineUtils.ENTITYITEM_STARUS_RENEW);
		IG117Info entity = this.ig117BL.searchIG117InfoByKey(entityItem.getEid());
		Integer old_eiversion = entityItem.getEiversion();
		Integer old_eismallversion = entityItem.getEismallversion();
		if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(entity.getEmodeltype())) {
			entityItem.setEismallversion(entityItem.getEismallversion() + 1);
		} else {
			entityItem.setEiversion(entityItem.getEiversion() + 1);
		}
		ig013BL.updateIG013Info(entityItem);
		//�ʲ���ϵ��Ϣ�汾��������
		this.ig313BL.upgradeIG313Info(entityItem.getEiid(), old_eiversion, old_eismallversion,
				entityItem.getEiversion(), entityItem.getEismallversion());
		
		if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(entity.getEmodeltype())) {
			//�ʲ�������ϵ��Ϣ�汾��������
			this.eiBelongRelationBL.upgradeEntityItemRelation(entityItem.getEiid(), old_eiversion, old_eismallversion,
					entityItem.getEiversion(), entityItem.getEismallversion());
		}
	}
	public void entityCancelPreScrapBatchAction(IGASM03DTO dto) throws BLException {
		for (int i = 0; i < dto.getBatchEntityItem().length; i++) {
			IG800SearchCondImpl cond = new IG800SearchCondImpl();
			cond.setEiid(Integer.parseInt(dto.getBatchEntityItem()[i]));
			IG013TB entityItem = (IG013TB)ig013BL.searchIG013InfoByKey(Integer.parseInt(dto.getBatchEntityItem()[i]));
			cond.setCiversion(String.valueOf(entityItem.getEiversion()));
			cond.setCismallversion(entityItem.getEismallversion().toString());
			this.saveConfigItem(dto, cond, CommonDefineUtils.ENTITYITEM_STARUS_RENEW);
			
			entityItem.setEistatus(CommonDefineUtils.ENTITYITEM_STARUS_RENEW);
			
			IG117Info entity = this.ig117BL.searchIG117InfoByKey(entityItem.getEid());

			Integer old_eiversion = entityItem.getEiversion();
			Integer old_eismallversion = entityItem.getEismallversion();
			if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(entity.getEmodeltype())) {
				entityItem.setEismallversion(entityItem.getEismallversion() + 1);
			} else {
				entityItem.setEiversion(entityItem.getEiversion() + 1);
			}
			
			ig013BL.updateIG013Info(entityItem);
			//�ʲ���ϵ��Ϣ�汾��������
			this.ig313BL.upgradeIG313Info(entityItem.getEiid(), old_eiversion, old_eismallversion,
					entityItem.getEiversion(), entityItem.getEismallversion());
			
			if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(entity.getEmodeltype())) {
				//�ʲ�������ϵ��Ϣ�汾��������
				this.eiBelongRelationBL.upgradeEntityItemRelation(entityItem.getEiid(), old_eiversion, old_eismallversion,
						entityItem.getEiversion(), entityItem.getEismallversion());
			}
		}
	}
	
	private void saveConfigItem(IGASM03DTO dto,IG800SearchCond cond,String status) throws BLException {
		IG688Info entityItem = ig013BL.searchIG688InfoByKey(cond.getEiid());
		List<IG800Info> configItemList = ig800BL.searchIG800Info(cond, 0, 0);
		for (IG800Info configItem : configItemList) {
			IG800TB ciTB = (IG800TB)SerializationUtils.clone(configItem);

			ciTB.setCiid(null);
			if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(entityItem.getEmodeltype())) {
				ciTB.setCismallversion(configItem.getCismallversion() + 1);
			} else {
				ciTB.setCiversion(configItem.getCiversion() + 1);
			}
			
			
			String cLabel = configItem.getConfiguration().getClabel();
			if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_STATUS.equals(cLabel)){
				ciTB.setCivalue(status);
			} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_OPERATORID.equals(cLabel)){
				ciTB.setCivalue(dto.getUserid());
			} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_OPERATORNAME.equals(cLabel)){
				ciTB.setCivalue(dto.getUsername());
			} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_RECIVENAME.equals(cLabel)){
				ciTB.setCivalue("");
			} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_RECIVEORGNAME.equals(cLabel)){
				ciTB.setCivalue("");
			} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_RECIVEORGCODE.equals(cLabel)){
				ciTB.setCivalue("");
			}
			String civalue = configItem.getCivalue();
			String citbvalue = ciTB.getCivalue();
			if(civalue == null){
				civalue="";
			}
			if(citbvalue == null){
				citbvalue="";
			}
			if(civalue.equals(citbvalue)) {
				//���Ը��±�ʶ
				ciTB.setCicurver("0");
			} else {
				//���Ը��±�ʶ
				ciTB.setCicurver("1");
			}
			IG800Info ci = ig800BL.registIG800Info(ciTB);
			//�������Ϊ�ʲ�ʱ���޸Ĺ�����ϵ
			if("4".equals(configItem.getConfiguration().getCattach()) && StringUtils.isNotEmpty(configItem.getCivalue())){
				IG313TB e = new IG313TB();
				e.setPareid(Integer.parseInt(entityItem.getEid()));
				e.setPareiid(entityItem.getEiid());
				e.setParversion(entityItem.getEiversion());
				e.setParsmallversion(entityItem.getEismallversion());
				String str = configItem.getCivalue();			
				IG013Info ei = this.ig013BL.searchIG013InfoByKey(Integer.parseInt(str.substring(str.lastIndexOf("(")+1, str.length()-1)));
				e.setCldeid(ei.getEid());
				e.setCldeiid(ei.getEiid());
				e.setCldversion(ei.getEiversion());
				e.setCldsmallversion(ei.getEismallversion());
				//У���ϵ�Ƿ����
				IG313SearchCondImpl eirCond = new IG313SearchCondImpl();
				eirCond.setEirinfo(entityItem.getEiid()+"_"+configItem.getCiid()+"_"+ei.getEiid());
				eirCond.setEirstatus("C");
				eirCond.setDeleteflag("0");
				List<IG313Info> eirlist = this.ig313BL.searchMaxIG313Info(eirCond);
				if(eirlist.size() != 1) {
					throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR, "IGCO10000.E017");
				} else {
					IG313TB eirTB = (IG313TB)SerializationUtils.clone(eirlist.get(0));
					
					eirTB.setEirinfo(eirTB.getEirinfo().replaceAll("_" + configItem.getCiid() + "_", "_" + ci.getCiid() + "_"));
					
					this.ig313BL.updateIG313Info(eirTB);
				}
			}
		}
	}	
	/**
	 *�豸��Ϣ�޸ĳ�����ʾ����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO initEntityItem(IGASM03DTO dto) throws BLException {

		log.debug("========�豸��Ϣ�༭���������ʾ����ʼ========");
		
		IGASM0321Form form = dto.getIgasm0321Form();
		
		//��ʾ���ʲ���Ϣȡ��
		SOC0124Info entityItem = this.soc0118BL.searchEntityItemVWByKey(form.getEiid());
		
		if ( entityItem == null ){
			throw new BLException("IGCO10000.E004","����豸����");
		}
		
		//������ʾ�趨
		
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
		form.setEismallversion(entityItem.getEismallversion());
		form.setEirootmark(entityItem.getEirootmark());
		
		//�жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
		boolean permission = this.soc0118BL.checkEntityItemDomain(dto.getUser(), entityItem);
		boolean isRoleManager = this.userRoleBL.checkRoleManagerByType(dto.getUser().getUserid(), EntityCategory.ROLE_TYPE_DEVICE);
		form.setRoleManager(isRoleManager);
		form.setPermission(permission);
		
		dto.setIgasm0321Form(form);
		
		//dto.addMessage(new ActionMessage("IGCO10000.I001","�豸������Ϣ"));
		
		if(!permission) {
			dto.addMessage(new ActionMessage("IGCO10000.E023","�޸�"));
		}
		
		log.debug("========�豸��Ϣ�༭���������ʾ��������========");
		return dto;
	}
	/**
	 *�豸��Ϣ�޸Ĵ���
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO updateEntityItem(IGASM03DTO dto) throws BLException {
		
		log.debug("========�豸��Ϣ�༭���������ʾ����ʼ========");
		
		IGASM0321Form form = dto.getIgasm0321Form();
		if(!form.getEilabel().equals(form.getEilabelbak())){
			this.soc0118BL.checkNotExistEntityItem(form.getEilabel());
		}
		

		SOC0118Info entityItem = this.soc0118BL.searchEntityItemByKey(form.getEiid());
		
		//��configitem����ȫƥ���civalue
		//����ʲ����ڹ�ϵ������ͬ���޸�
		//����ȫƥ��
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
			
		
		
		//EntityItemRelation��ȡ���й�ϵ���ʲ��б�
		SOC0119SearchCondImpl ercond = new SOC0119SearchCondImpl();
		ercond.setCldeiid(entityItem.getEiid());
//		ercond.setCldeid(String.valueOf(entityItem.getEid()));
		List<SOC0119Info> erlist = this.soc0119BL.searchEntityItemRelation(ercond);
		
		if(!erlist.isEmpty()){
			
			//�����¼
			//Configuration��ȡ���ʲ�����ʲ���cid
			SOC0109SearchCondImpl ccond = new SOC0109SearchCondImpl();
			//�ʲ�ID��cid
			ccond.setClabel(EntityItemKeyWords.ENTITY_DEFAULT_DEVICE_EIID);
			List<SOC0109Info> clist1 = this.soc0109BL.searchConfiguration(ccond);
			SOC0109TB cTB1 = (SOC0109TB)SerializationUtils.clone(clist1.get(0));
			//�ʲ����Ƶ�cid
			ccond.setClabel(EntityItemKeyWords.ENTITY_DEFAULT_DEVICE_ENAME);
			List<SOC0109Info> clist2 = this.soc0109BL.searchConfiguration(ccond);
			SOC0109TB cTB2 = (SOC0109TB)SerializationUtils.clone(clist2.get(0));
			
			cicond.setCivalue(null);
			for(int j = 0; j < erlist.size(); j++){
				//�����¼
				//�ʲ�ID
				SOC0119TB erTB = (SOC0119TB)SerializationUtils.clone(erlist.get(j));
				cicond.setEiid(erTB.getPareiid().toString());
				cicond.setCid(cTB1.getCid());
				List<SOC0107Info> cilist1 = this.soc0107BL.searchSOC0107(cicond);
				//�����ϵ�������ʲ�civalue�����ʲ�ID��ֵ,�����һ���е��ʲ�����
				if(!cilist1.isEmpty()){
					SOC0107TB ciTB1 = (SOC0107TB)SerializationUtils.clone(cilist1.get(0));
					cicond.setCid(cTB2.getCid());
					List<SOC0107Info> cilist2 = this.soc0107BL.searchSOC0107(cicond);
					SOC0107TB ciTB2 = (SOC0107TB)SerializationUtils.clone(cilist2.get(0));
					//��civalue��ֵ��<br />��
					String[] id = ciTB1.getCivalue().split("<br />");
					String[] name = ciTB2.getCivalue().split("<br />");
					StringBuffer bf = new StringBuffer();
					for(int n = 0; n < id.length; n++){
						if(id[n].equals(String.valueOf(entityItem.getEiid()))){
							name[n] = form.getEiname();
						}
						//�����޸ĺ���ʲ����ƣ���ƴ��
						bf.append(name[n] + "<br />");
					}
					ciTB2.setCivalue(bf.toString());
					this.soc0107BL.updateSOC0107(ciTB2);
				}
			}
		}

	
		
		
		this.soc0118BL.updateEntityItem(form);
		dto.addMessage(new ActionMessage("IGCO10000.I005","�豸������Ϣ"));
		log.debug("========�豸��Ϣ�༭���������ʾ��������========");
		return dto;
	}
	
	/**
	 *	��ȡ�豸������ϵ����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO searchRelationListAction(IGASM03DTO dto) throws BLException {
		log.debug("========��ȡ�豸������ϵ����ʼ========");
		List<LabelValueBean> list = this.codeDetailBL.searchLabelValueBeanList(CommonDefineUtils.ENTIY_CATEGORY_DEVICE,CodeDefine.getCodeDefine("ENTITY_ITEM_RELATION_CODE").getCcid());
		dto.setRelationList(list);
		log.debug("========��ȡ�豸������ϵ��������========");
		return dto;
	}
	
	
	/**
	 * �豸�������ǼǱ༭������ڻ�����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO initIGASM0317Action(IGASM03DTO dto) throws BLException{
		
		log.debug("========�豸�������Ǽ���Ϣ�༭���������ʾ����ʼ========");
		
		IGASM0317Form form = dto.getIgasm0317Form();
		///��ʾ���ʲ���Ϣȡ��
		IG013Info entityItem = this.ig013BL.searchIG013InfoByKey(Integer.parseInt(form.getPareiid()));
		
		if ( entityItem == null ){
			throw new BLException("IGCO10000.E004","��������豸ģ�����");
		}
		
		//������ʾ�趨
		
		String orgsyscoding = entityItem.getEiorgsyscoding();
		String esyscoding = entityItem.getEsyscoding();
		IG117SearchCondImpl EntityCond = new IG117SearchCondImpl();
		EntityCond.setEsyscoding(esyscoding);
		List<IG117Info> entityList = this.ig117BL.searchIG117Info(EntityCond, 0, 0);
		for (int i = 0; i < entityList.size(); i++) {
			form.setEname(entityList.get(0).getEname());
		}
		form.setEsyscoding(esyscoding);
		OrganizationSearchCondImpl OrgCond = new OrganizationSearchCondImpl();
		OrgCond.setOrgsyscoding(orgsyscoding);
		List<Organization> orgList = this.organizationBL.searchOrganization(OrgCond, 0, 0);
		for (int i = 0; i < orgList.size(); i++) {
			form.setEiorgname(orgList.get(0).getOrgname());
		}
		form.setEiorgsyscoding(orgsyscoding);
		Date nowDateTime = new Date();
		String date = CommonDefineUtils.DATE_FORMAT.format(nowDateTime);
		form.setEid(entityItem.getEid());
		form.setEiinsdate(date);
		form.setEidesc(entityItem.getEidesc());
		form.setEiname(entityItem.getEiname());
		dto.setIgasm0317Form(form);
		log.debug("========�豸�������Ǽ���Ϣ�༭���������ʾ����ʼ========");
		return dto;
	}
	
	/**
	 * �豸�������ǼǴ���
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public synchronized IGASM03DTO insertBatchEntityItemAction(IGASM03DTO dto) throws BLException {
		//����Formȡ��
		IGASM0317Form form = dto.getIgasm0317Form();
		String[] ids_default = form.getIds_default();//�趨Ҫ�ύ������
		String[] ids = form.getIds();//�����ύ������
		boolean id_flag = false;
		if(form.getEinames() != null) {
			int length = ids_default.length;
			int id_length = ids.length;
			List<LabelValueBean> label = new ArrayList<LabelValueBean>();
			//��ȡ��ʼ�豸���
			IG013SearchCondImpl eiCond = new IG013SearchCondImpl();
			
			eiCond.setEilabel(CommonDefineUtils.ENTIY_CATEGORY_DEVICE_KEY + IGStringUtils.getCurrentYear().substring(2));
			
			String eilabel = this.ig013BL.searchNextIG013InfoLable(eiCond);
			
			eiCond = null;
			
			Integer serialnum = new Integer(eilabel.substring(EntityItemKeyWords.LABEL_LEFT_LENGTH));
			
			List<IG800Info> configitemList = this.ig800BL.searchIG800InfoHistoryByEiid(Integer.parseInt(form.getPareiid()), -1, null, null);
			
			Map<String,IG313TB> map = new HashMap<String, IG313TB>();
			form.setEid(form.getEid());
			form.setEidesc(form.getEidesc());
			form.setEiinsdate(form.getEiinsdate());
			form.setEiorgsyscoding(form.getEiorgsyscoding());
			form.setEsyscoding(form.getEsyscoding());
			form.setEistatus(CommonDefineUtils.ENTITYITEM_STARUS_NEW);
			IG688Info entityItemVW = this.ig013BL.searchIG688InfoByKey(Integer.parseInt(form.getPareiid()));
			
			if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(entityItemVW.getEmodeltype())) {
				form.setEiversion(0);
				form.setEismallversion(1);
			} else {
				form.setEiversion(1);
				form.setEismallversion(0);
			}
			
			int num = 0;
			for (int i = 0; i < length; i++) {
				id_flag = false;
	
				for(int n = 0;n<id_length;n++){
					if(ids_default[i].equals(ids[n])){
						id_flag = true;
						break;
					}
				}
				if(!id_flag){
					continue;
				}
				
				form.setEilabel(CommonDefineUtils.ENTIY_CATEGORY_DEVICE_KEY + IGStringUtils.getCurrentYear().substring(2)
						+ StringUtils.leftPad(String.valueOf(serialnum + num) , EntityItemKeyWords.LABEL_LENGTH, EntityItemKeyWords.LABEL_LEFT_PAD));
				num++;
				form.setEiname(form.getEinames()[i]);
				label.add(new LabelValueBean(form.getEiname(), form.getEilabel()));
				
				String serial = form.getSerials()[i];//�豸���к�
			
				//����ʱ���趨
				Date nowDateTime = new Date();
				String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
				nowDateTime = null;
				form.setEiupdtime(datetime);
				//dto.setIgasm0317Form(form);
				//�豸��Ϣ��¼
				IG013Info entityitem  = this.ig013BL.registIG013Info(form);
				for (IG800Info configItem : configitemList) {
					IG800TB configitemTB = (IG800TB)SerializationUtils.clone(configItem);
					configitemTB.setCiid(null);
					configitemTB.setEiid(entityitem.getEiid());
					configitemTB.setCiversion(entityitem.getEiversion());
					configitemTB.setCismallversion(entityitem.getEismallversion());
					// add by songhy 2010-05-31 start
					//�������ʱ�����豸���ƺ����һ����д�豸���кţ�102ΪConfiguration�������кŵļ�ֵ
					if(EntityItemKeyWords.ENTITY_DEFAULT_SERIAL_NUMBER.equals(configItem.getConfiguration().getClabel())){
						configitemTB.setCivalue(serial);
					}
					// add by songhy 2010-05-31 end
					//���Ը��±�ʶ
					if(StringUtils.isEmpty(configItem.getCivalue())) {
						configitemTB.setCicurver("0");
					} else {
						configitemTB.setCicurver("1");
					}
					IG800Info ci = ig800BL.registIG800Info(configitemTB);
					
					configitemTB = null;
					//�������Ϊ�ʲ�ʱ�����ӹ�����ϵ
					if("4".equals(configItem.getConfiguration().getCattach()) && StringUtils.isNotEmpty(ci.getCivalue())){
						if(map.containsKey(ci.getCid().toString())){
							IG313TB e = map.get(ci.getCid().toString());
							e.setEirid(null);
							e.setPareid(entityitem.getEid());
							e.setPareiid(entityitem.getEiid());
							e.setParversion(entityitem.getEiversion());
							e.setParsmallversion(entityitem.getEismallversion());
							e.setEirinfo(entityitem.getEiid()+"_"+ci.getCiid()+"_"+e.getCldeiid());
							this.ig313BL.registIG313Info(e);
							e = null;
						} else {
							IG313TB e = new IG313TB();
							e.setPareid(entityitem.getEid());
							e.setPareiid(entityitem.getEiid());
							e.setParversion(entityitem.getEiversion());
							e.setParsmallversion(entityitem.getEismallversion());
							String str = ci.getCivalue();
							IG013Info ei = this.ig013BL.searchIG013InfoByKey(Integer.parseInt(str.substring(str.lastIndexOf("(")+1, str.length()-1)));
							e.setCldeid(ei.getEid());
							e.setCldeiid(ei.getEiid());
							e.setCldversion(ei.getEiversion());
							e.setCldsmallversion(ei.getEismallversion());
							//˫��
							String relationcode = entityitem.getEsyscoding().substring(3, 6)+"-"+ei.getEsyscoding().substring(3, 6);	
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
								condimpl.setBusinesscode_like(ei.getEsyscoding().substring(3, 6)+"-"+entityitem.getEsyscoding().substring(3, 6));
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
							//��ѯ��������
							String cname = configItem.getConfiguration().getCname();
							e.setEirdesc("�������"+cname+"����");
							//����key
							e.setEirinfo(entityitem.getEiid()+"_"+ci.getCiid()+"_"+ei.getEiid());
							//����״̬ΪC����ϵ�����в���ɾ��
							e.setEirstatus("C");
							this.ig313BL.registIG313Info(e);
							map.put(ci.getCid().toString(), e);
							ei = null;
						}
					}
				}
				entityitem = null;
				
			}		
			dto.setRelationList(label);
		}
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "�ʲ�������Ϣ") );
		log.debug("========�豸��Ϣ�ǼǴ�������========");
		return dto;
	}
	

	/**
	 * ��ȡ�豸������ֵ
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO searchEntityItemLableAction(IGASM03DTO dto) throws BLException {
		
		log.debug("========��ȡ�豸������ֵ����ʼ========");
		
		IGASM0302Form form = dto.getIgasm0302Form();
		
		SOC0118SearchCondImpl cond = new SOC0118SearchCondImpl();
		
		cond.setEilabel(CommonDefineUtils.ENTIY_CATEGORY_DEVICE_KEY + IGStringUtils.getCurrentYear().substring(2));
		
		String eilabel = this.soc0118BL.searchNextEntityItemLable(cond);
		
		form.setEilabel(eilabel);
		
		log.debug("========��ȡ�豸������ֵ��������========");
		return dto;
	}
	
	/**
	 * �жϵ�½�û��Ƿ����豸�ʲ������ɫ������
	 * 
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 * @throws BLException 
	 */
	public IGASM03DTO checkEntityItemDomain(IGASM03DTO dto) throws BLException{
		boolean isRoleManager = this.userRoleBL.checkRoleManagerByType(dto.getUser().getUserid(), EntityCategory.ROLE_TYPE_DEVICE);
		
		if(isRoleManager) {
			OrganizationSearchCondImpl orgCond = new OrganizationSearchCondImpl();
			orgCond.setOrgpar("0001");
			List<Organization> org = this.organizationBL.searchOrganization(orgCond);
			
			if(org.size() != 1) {
			    log.info("========����������Ϣ�����ڣ�����=======");
				throw new BLException("IGCO10000.E004","��������");
			} else {
				dto.setOrgname(org.get(0).getOrgname());
				dto.setOrgsyscoding(org.get(0).getOrgsyscoding());
			}
			SOC0117SearchCondImpl entityCond = new SOC0117SearchCondImpl();
			entityCond.setEsyscoding(CommonDefineUtils.ENTIY_CATEGORY_DEVICE_SYSCODING);
			List<SOC0117Info> entity = this.soc0117BL.searchEntity(entityCond, 0, 0);
			
			if(entity.size() != 1) {
				throw new BLException("IGCO10000.E004","�豸ģ��");
			} else {
				dto.setEname(entity.get(0).getEname());
				dto.setEsyscoding(entity.get(0).getEsyscoding());
			}
		}
		
		dto.setFlag(isRoleManager);
		
		return dto;
	}
	/**
	 * ��ȡ��ʷ�汾����ʱ��
	 * @param version
	 * @return list
	 * @throws BLException
	 */
	public List<IG887Info> getVersionUpdateTime (String eiid)throws BLException{
		
		
		List<IG887Info> resultList=this.ig013BL.searchVersionUpdateTime(Integer.parseInt(eiid));
		return resultList;
	}
	
	

	/**
	 * ��ʼ���ʲ�������Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGASM03DTO initXMLInfo(IGASM03DTO dto) throws BLException{
		//dto.setTreeNodeMap(parseXML(new File(dto.getFilepath())));
		dto.setTreeNodeMap(parseXML(dto.getFilepath()));
		return dto;
	}
	
	/**
	 * �鿴������Ϣָ��������Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGASM03DTO readXMLNodeInfo(IGASM03DTO dto) throws BLException{
		IGASM0301Form form = dto.getIgASM0301Form();
		//dto.setInfoMap(parseXMLNode(new File(dto.getFilepath()),form.getNodeID()));
		dto.setInfoMap(parseXMLNode(dto.getFilepath(),form.getNodeID()));
		//dto.setInfoMap(parseXMLNode(new File(dto.getFilepath()),form.getNodeID()));
		return dto;
	}
	
	
	
	/**
	 * ����������ϢXML�ļ��е�ָ����������
	 * @param File
	 * @return Map<String,TreeNode> 
	 */
	@SuppressWarnings({"finally" })
	public Map<String,String> parseXMLNode(String filepath,String id) {
		Map<String,String> infoMap=new LinkedHashMap<String,String>();
		try{
			DocumentBuilderFactory domfac = DocumentBuilderFactory.newInstance();
			DocumentBuilder dombuilder = domfac.newDocumentBuilder();
		    //InputStream is = new FileInputStream(file); //���ļ���ȡ��
		    InputSource is = new InputSource(new InputStreamReader(new FileInputStream(new File(filepath)), "GBK"));
			
//			DocumentBuilderFactory domfac = DocumentBuilderFactory.newInstance();
//			DocumentBuilder dombuilder = domfac.newDocumentBuilder();
//		    InputStream is = new FileInputStream(file); //���ļ���ȡ��
		    Document doc = dombuilder.parse(is);   
		    Element root = doc.getDocumentElement();
		    NodeList nodes = root.getChildNodes();
		    String key = ASMHelper.NODE_KEY;
		    if(nodes!=null){
		    	//���ø����
		    	TreeNode rootNode = new TreeNode();
	    	    rootNode.setId(key);
	    	    rootNode.setName(root.getNodeName());

	    	    //���һ�����ӽ��
		    	for(int i=0,j=nodes.getLength();i<j;i++){
		    		Node node = nodes.item(i);
		    		
		    		if(node.getNodeType()==Node.ELEMENT_NODE && !"DATE".equals(node.getNodeName()) && !"VER".equals(node.getNodeName())){

			    	    TreeNode ptNode = new TreeNode();
			    	    key = getXMLKey(key,2);
			    		ptNode.setId(key);
			 			ptNode.setName(node.getNodeName());
			 			//��麢�ӽ��
			 			checkChildNodes(node,ptNode,key,3,id,infoMap);

		    		}
		    		
		    	}
		    	
		    }
		}catch(Exception e){
			log.debug("Exception:", e);
		}finally{
			return infoMap;
		}
	}
	
	/**
	 * ���ÿ������Ƿ�Ϊѡ���Ľ��
	 * @param node	��ǰ���
	 * @param ptNode �ϼ����
	 */
	public  void checkChildNodes(Node node,TreeNode ptNode,String key,Integer level,String id,Map<String,String> infoMap) {
		 NodeList nodes = node.getChildNodes();
		 
		 for(int i=0,j=nodes.getLength();i<j;i++){
			 Node tempnode = nodes.item(i);
			 if(tempnode.getNodeType()==Node.ELEMENT_NODE){
				 String temp_key = getXMLKey(key,level);
				 
				 TreeNode pdNode = new TreeNode();
				 pdNode.setId(temp_key);
				 pdNode.setName(tempnode.getNodeName());
				 //���Ϊѡ�����ĺ��ӽ����ȡ��������
				 if(pdNode.getId().substring(0, id.length()).equals(id) && pdNode.getId().length()>id.length()){
					 infoMap.put(tempnode.getNodeName(), tempnode.getTextContent());
				 }

				 if(tempnode.getChildNodes().getLength()>0 && level <= 3){
					 checkChildNodes(tempnode,pdNode,pdNode.getId(),(level+1),id,infoMap);
				 }
				 ptNode.addChildTreeNode(pdNode.getId(),pdNode); 
				 
				 key = getXMLKey(key,level);
			 }
		 }
	}
	
	
	/**
	 * ����������ϢXML�ļ��е�����
	 * @param File
	 * @return Map<String,TreeNode> 
	 */
	@SuppressWarnings({"finally" })
	public Map<String,TreeNode> parseXML(File file) {
		Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
		try{
			DocumentBuilderFactory domfac = DocumentBuilderFactory.newInstance();
			DocumentBuilder dombuilder = domfac.newDocumentBuilder();
		    InputStream is = new FileInputStream(file); //���ļ���ȡ��
		    Document doc = dombuilder.parse(is);   
		    Element root = doc.getDocumentElement();
		    NamedNodeMap rootmap = root.getAttributes();//root�������Լ���
		    NodeList nodes = root.getChildNodes();
		    String key = ASMHelper.NODE_KEY;
		    if(nodes!=null){
		    	//���ø����
		    	TreeNode rootNode = new TreeNode();
	    	    rootNode.setId(key);
	    	    String tmp = "";
	    	    if(rootmap!=null && rootmap.getLength()>0){
	    	    	tmp = rootmap.getNamedItem("label").getNodeValue();
	    	    }
	    	    rootNode.setName(root.getNodeName()+"_"+tmp);

	    	    //���һ�����ӽ��
		    	for(int i=0,j=nodes.getLength();i<j;i++){
		    		Node node = nodes.item(i);
		    		
		    		if(node.getNodeType()==Node.ELEMENT_NODE && !"DATE".equals(node.getNodeName()) && !"VER".equals(node.getNodeName())){
		    			NamedNodeMap nodemap = node.getAttributes();//��ǰ�������Լ���
		    			
			    	    TreeNode ptNode = new TreeNode();
			    	    key = getXMLKey(key,2);
			    		ptNode.setId(key);
			    		if(nodemap!=null && nodemap.getLength()>0){
			    			ptNode.setName(nodemap.getNamedItem("label").getNodeValue());
			    		}else{
			    			ptNode.setName(node.getNodeName());
			    		}
			 			
			 			
			 			//��Ӻ��ӽ��
			 			getChildNodes(node,ptNode,key,3);
			 			rootNode.addChildTreeNode(ptNode.getId(), ptNode);
		    		}
		    		
		    	}
		    	treeNodeMap.put(rootNode.getId(),rootNode);
		    	
		    }
		}catch(Exception e){
			log.debug("Exception:", e);
		}finally{
			return treeNodeMap;
		}
	}
	
	/**
	 * ȡ���¼����
	 * @param node	��ǰ���
	 * @param ptNode �ϼ����
	 */
	public  void getChildNodes(Node node,TreeNode ptNode,String key,Integer level) {
		 NodeList nodes = node.getChildNodes();
		 
		 for(int i=0,j=nodes.getLength();i<j;i++){
			 Node tempnode = nodes.item(i);
			 if(tempnode.getNodeType()==Node.ELEMENT_NODE){
				 NamedNodeMap nodemap = tempnode.getAttributes();//��ǰ�������Լ���
				 
				 String temp_key = getXMLKey(key,level);
				 TreeNode pdNode = new TreeNode();
				 pdNode.setId(temp_key);
				 if(nodemap!=null && nodemap.getLength()>0){
					 pdNode.setName(nodemap.getNamedItem("label").getNodeValue());
				 }else{
					 pdNode.setName(tempnode.getNodeName());
				 }
				 
				 String temp_name = pdNode.getName().replace("'", "");
				 pdNode.setName(temp_name);
				 
				 
				 //ֻȡǰ3���Ľ����Ϊ�������Ԫ��
				 if(tempnode.getChildNodes().getLength()>0 && level <= 3){
					getChildNodes(tempnode,pdNode,pdNode.getId(),(level+1));
				 }
				 if(level <= 3){
					//����ΪCOMMAND����
					ptNode.addChildTreeNode(pdNode.getId(),pdNode); 
				 }
				 key = getXMLKey(key,level);
			 }
		 }
	}
	
	/**
	 * ȡ�ø�����ΨһID(ÿ3λΪһ��)
	 * @param String key
	 * @param String level
	 * @return String
	 */
	public static synchronized String getXMLKey(String key,Integer level){
		String syscode = key;
		String temp = "";
		if(key.length()>=(level*3)){
			temp = key.substring(key.length()-3);	
			if("0".equals(temp.substring(0, 1))){//0**
				String tmp = String.valueOf(Integer.valueOf(temp)+1);
				if(tmp.length()==1){
					temp = "00"+tmp;
				}else if(tmp.length()==2){
					temp = "0"+tmp;
				}else{
					temp = tmp;
				}
				syscode = syscode.substring(0,syscode.length()-3)+temp;
			}else{//***
				syscode = syscode.substring(0,syscode.length()-3)+String.valueOf(Integer.valueOf(temp)+1);
			}
		}else{
			syscode = key + "001";
		}

		return syscode;
	 }
	

	
	
	/**
	 * ����������ϢXML�ļ��е�����
	 * @param File
	 * @return Map<String,TreeNode> 
	 */
	@SuppressWarnings({"finally" })
	public Map<String,TreeNode> parseXML(String filepath) {
		Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
		try{
			DocumentBuilderFactory domfac = DocumentBuilderFactory.newInstance();
			DocumentBuilder dombuilder = domfac.newDocumentBuilder();
			
		    //InputStream is = new FileInputStream(file); //���ļ���ȡ��
			InputSource is = new InputSource(new InputStreamReader(new FileInputStream(new File(filepath)), "GBK"));
		    Document doc = dombuilder.parse(is);   
		    Element root = doc.getDocumentElement();
		    NamedNodeMap rootmap = root.getAttributes();//root�������Լ���
		    NodeList nodes = root.getChildNodes();
		    String key = ASMHelper.NODE_KEY;
		    if(nodes!=null){
		    	//���ø����
		    	TreeNode rootNode = new TreeNode();
	    	    rootNode.setId(key);
	    	    String tmp = "";//HOST Name
	    	    String tmp_type = "";//AIX etc.
	    	    if(rootmap!=null && rootmap.getLength()>0){
	    	    	if(rootmap.getNamedItem("label")!=null){
	    	    		tmp = rootmap.getNamedItem("label").getNodeValue();
	    	    	}
	    	    	if(rootmap.getNamedItem("type")!=null){
	    	    		tmp_type = rootmap.getNamedItem("type").getNodeValue();
	    	    	}
	    	    	
	    	    	
	    	    }
	    	    if(StringUtils.isNotEmpty(tmp_type) && StringUtils.isNotEmpty(tmp)){
	    	    	rootNode.setName(tmp_type+"-"+tmp);
	    	    }else if(StringUtils.isEmpty(tmp_type) && StringUtils.isNotEmpty(tmp)){
	    	    	rootNode.setName(tmp);	
	    	    }else if(StringUtils.isEmpty(tmp) && StringUtils.isNotEmpty(tmp_type)){
	    	    	rootNode.setName(tmp_type);	
	    	    }else{
	    	    	rootNode.setName("Host");	
	    	    }
	    	    
	    	    

	    	    //���һ�����ӽ��
		    	for(int i=0,j=nodes.getLength();i<j;i++){
		    		Node node = nodes.item(i);
		    		if(node.getNodeType()==Node.ELEMENT_NODE && !"DATE".equals(node.getNodeName().toUpperCase()) && !"VER".equals(node.getNodeName().toUpperCase()) && !"RELATION".equals(node.getNodeName().toUpperCase())){
		    			NamedNodeMap nodemap = node.getAttributes();
		    			
			    	    TreeNode ptNode = new TreeNode();
			    	    key = getXMLKey(key,2);
			    		ptNode.setId(key);
			    		if(nodemap!=null && nodemap.getNamedItem("label")!=null){
			    			ptNode.setName(nodemap.getNamedItem("label").getNodeValue());
			    		}else{
			    			ptNode.setName(node.getNodeName());
			    		}
			 			
			 			
			 			//��Ӻ��ӽ��
			 			getChildNodes(node,ptNode,key,3);
			 			String temp_name = ptNode.getName().replace("'", "");
			 			ptNode.setName(temp_name);
			 			rootNode.addChildTreeNode(ptNode.getId(), ptNode);
		    		}
		    		
		    	}
		    	treeNodeMap.put(rootNode.getId(),rootNode);
		    	
		    }
		}catch(Exception e){
			log.debug("Exception:", e);
		}finally{
			return treeNodeMap;
		}
	}
	

	
	
	/**
	 * �Ƚ�2���汾������ϢXML�е�����(����XML�ļ��е�SCETION����һ�����ܽ��бȽ�)
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGASM03DTO compareXMLInfoByVersion(IGASM03DTO dto) throws BLException{
		
		//ȡ�õ�1���汾������
		//dto = searchXMLInfo(new File(dto.getFilepath()),dto);
		dto = searchXMLInfo(dto.getFilepath(),dto);
		List<String> section_list = new ArrayList<String>();
	    Map<String,List<TreeNode>> command_map_1 = dto.getCommand_map();
	    
	    //ȡ�õ�2���汾������
		//dto = searchXMLInfo(new File(dto.getOtherfilepath()),dto);
		dto = searchXMLInfo(dto.getOtherfilepath(),dto);
	    Map<String,List<TreeNode>> command_map_2 = dto.getCommand_map();
	    
	    //�Ƚ�����
		Set<Map.Entry<String,List<TreeNode>>> set_1 = command_map_1.entrySet();
		
		List<String> new_command_list1 = new ArrayList<String>();
		List<String> new_command_list2 = new ArrayList<String>();
		List<String> new_output_list1 = new ArrayList<String>();
		List<String> new_output_list2 = new ArrayList<String>();
		List<String> command_color_list = new ArrayList<String>();//0����ɫ 1��ɫ
		List<String> output_color_list = new ArrayList<String>();//0����ɫ 1��ɫ
		
		for(Iterator<Map.Entry<String,List<TreeNode>>> iter = set_1.iterator();iter.hasNext();){
			Map.Entry<String,List<TreeNode>> entry_1 = iter.next();
			String section =  entry_1.getKey();//eitype: HOST HBA etc.
			
			List<TreeNode> list1 = entry_1.getValue();
			List<TreeNode> list2 = command_map_2.get(section);
			
			
			//����SECTION
			if(list2==null ||(list1!=null &&  list1.size()>=list2.size())){
				for(TreeNode node:list1){
					section_list.add(section);
				}
			}else{
				for(TreeNode node:list2){
					section_list.add(section);
				}
			}
			
				//��һ���汾Ϊ������Ƚ�����һ���汾�е�����
				if(list1!=null){
					for(int i=0,j=list1.size();i<j;i++){
						TreeNode node1 = list1.get(i);
						boolean flag = true;
						boolean flag2 = true;
						
						//�Ƚ�command
						if(list2!=null){
							for(int m=0,n=list2.size();m<n;m++){
								TreeNode node2 = list2.get(m);	
								if(node1!=null && node1.getName()!=null && 
										node2!=null && node2.getName()!=null){
									if(node1.getName().equals(node2.getName())){
										//��command1����command2ʱ��ֱ�ӽ���ǰcommand���浽�Լ��µ�list��
										new_command_list1.add(node1.getName());
										new_command_list2.add(node2.getName());
										flag = false;
										command_color_list.add("0");
										break;
									}
								}
								
							}
						}
						
						
						if(flag){
							//��command2��������list1�в���new_command_list2������command2ʱ����new_command_list2�����һ�����У������ñ�ɫ
							new_command_list1.add(node1.getName());
							new_command_list2.add("");
							command_color_list.add("1");
						}
	
						//�Ƚ�output
						if(list2!=null){
							for(int m=0,n=list2.size();m<n;m++){
								TreeNode node2 = list2.get(m);
								
								if(node1!=null && node1.getBelong()!=null && 
										node2!=null && node2.getBelong()!=null){
									if(node1.getBelong().equals(node2.getBelong())){
										new_output_list1.add(node1.getBelong());
										new_output_list2.add(node2.getBelong());
										flag2 = false;
										output_color_list.add("0");
										break;
									}
								}
								
								
							}
						}
						
						
						if(flag2){
							//��output2��������list1�в���new_output_list1������output2ʱ����new_output_list2�����һ�����У������ñ�ɫ
							new_output_list1.add(node1.getBelong());
							String out_put = "";
							if(list2!=null){
								for(int m=0,n=list2.size();m<n;m++){
									TreeNode node2 = list2.get(m);	
									if(node1!=null && node1.getName()!=null && 
											node2!=null && node2.getName()!=null){
										if(node1.getName().equals(node2.getName())){
											//��command1����command2ʱ�������������
											out_put = node2.getBelong();
											break;
										}
									}
								}
								
							}
							new_output_list2.add(out_put);
							output_color_list.add("1");
						}
						
					}
				}
				

				//����һ���汾Ϊ������Ƚ�����
				if(list2!=null){
					for(int i=0,j=list2.size();i<j;i++){
						TreeNode node2 = list2.get(i);
						boolean flag = true;
						boolean flag2 = true;
						
						
						if(node2!=null && node2.getName()!=null){
							String command = node2.getName();
							if(!new_command_list2.contains(command) && !new_command_list1.contains(command)){
								//�Ƚ�command
								if(list1!=null){
									for(int m=0,n=list1.size();m<n;m++){
										TreeNode node1 = list1.get(m);
										if(node1!=null && node1.getName()!=null && 
												node2!=null && node2.getName()!=null){
											if(node2.getName().equals(node1.getName())){
												//new_command_list1.add(node1.getName());
												//new_command_list2.add(node2.getName());
												//command_color_list.add("0");
												flag = false;
												break;
											}
										}
										
									}
								}
								
								if(flag){
									new_command_list1.add("");
									new_command_list2.add(node2.getName());
									command_color_list.add("1");
								}
								
								//�Ƚ�output
								if(list1!=null){
									for(int m=0,n=list1.size();m<n;m++){
										TreeNode node1 = list1.get(m);
										if(node1!=null && node1.getBelong()!=null && 
												node2!=null && node2.getBelong()!=null){
											if(node2.getBelong().equals(node1.getBelong())){
												//new_output_list1.add(node1.getBelong());
												//new_output_list2.add(node2.getBelong());
												//output_color_list.add("0");
												flag2 = false;
												break;
											}
										}
										
									}
								}
								
								if(flag2){
									String out_put = "";
									if(list1!=null){
										for(int m=0,n=list1.size();m<n;m++){
											TreeNode node1 = list1.get(m);
											if(node1!=null && node1.getName()!=null && 
													node2!=null && node2.getName()!=null){
												if(node1.getName().equals(node2.getName())){
													//��command1����command2ʱ�������������
													out_put = node1.getBelong();
													break;
												}
											}
										}
										
									}
									
									new_output_list1.add(out_put);
									new_output_list2.add(node2.getBelong());
									output_color_list.add("1");
								}
							}
							
						}

						
					}
				}
				
			
		}

		//����ȽϺ������
	    dto.setSection_list(section_list);
	    dto.setCommand_list1(new_command_list1);
	    dto.setCommand_list2(new_command_list2);
	    dto.setOutput_list1(new_output_list1);
	    dto.setOutput_list2(new_output_list2);
	    dto.setCommand_color_list(command_color_list);
	    dto.setOutput_color_list(output_color_list);
	    
		return dto;
	}
	
	/**
	 * ��XML�ļ���ȡ����Ҫ������
	 * @param File
	 * @param IGASM03DTO
	 * @return IGASM03DTO
	 */
	@SuppressWarnings({"finally" })
	public IGASM03DTO searchXMLInfo(String filepath,IGASM03DTO dto) {
		try{
			
			DocumentBuilderFactory domfac = DocumentBuilderFactory.newInstance();
			DocumentBuilder dombuilder = domfac.newDocumentBuilder();
		    //InputStream is = new FileInputStream(file); //���ļ���ȡ��
		    InputSource is = new InputSource(new InputStreamReader(new FileInputStream(new File(filepath)), "GBK"));
//			DocumentBuilderFactory domfac = DocumentBuilderFactory.newInstance();
//			DocumentBuilder dombuilder = domfac.newDocumentBuilder();
//		    InputStream is = new FileInputStream(file); //���ļ���ȡ��
		    Document doc = dombuilder.parse(is);   
		    Element root = doc.getDocumentElement();
		    NodeList nodes = root.getChildNodes();
		    //List<String> section_list = new ArrayList<String>();
		    Map<String,List<TreeNode>> command_map = new LinkedHashMap<String,List<TreeNode>>();
		    if(nodes!=null){
		    	for(int i=0,j=nodes.getLength();i<j;i++){
			    	//ȡ������SECTION NODE
		    		Node node = nodes.item(i);
		    		//NamedNodeMap nodemap1 = node.getAttributes();
//		    		if(nodemap1!=null && nodemap1.getLength()>0){
//		    			System.out.println("name==="+node.getNodeName()+"----"+nodemap1.getNamedItem("label").getNodeValue());
//		    		}
		    		
		    		if(node.getNodeType()==Node.ELEMENT_NODE && !"DATE".equals(node.getNodeName()) && !"VER".equals(node.getNodeName())){
		    			List<TreeNode> commandList = new ArrayList<TreeNode>();
		    			//����SECTION
		    			NamedNodeMap nodemap = node.getAttributes();//��ǰ�������Լ���
		    			String section_name = "";
		    			if(nodemap!=null && nodemap.getLength()>0){
		    				section_name = nodemap.getNamedItem("label").getNodeValue();
		    			}else{
		    				section_name = node.getNodeName();
		    			}
		    			
		    			//section_list.add(section_name);
			 			NodeList commandnodes = node.getChildNodes();
			 			//ȡ��COMMAND
			 			for(int m=0,n=commandnodes.getLength();m<n;m++){
			 				Node commandnode = commandnodes.item(m);
			 				if(commandnode.getNodeType()==Node.ELEMENT_NODE){
			 					TreeNode pdNode = new TreeNode();
			 					//����COMMAND
			 					NamedNodeMap commandnodemap = commandnode.getAttributes();//��ǰ�������Լ���
			 					String command_LBL = "";
			 					if(commandnodemap!=null && commandnodemap.getLength()>0){
			 						command_LBL = commandnodemap.getNamedItem("label").getNodeValue();
			 					}
			 					
			 					
//			 					NodeList lblnodes = commandnode.getChildNodes();
//			 					for(int x=0,y=lblnodes.getLength();x<y;x++){
//			 						Node temp = lblnodes.item(x);
//			 						if(temp.getNodeType()==Node.ELEMENT_NODE && "RUN_CMD".equals(temp.getNodeName())){
//			 							command_LBL = temp.getTextContent();
//			 						}
//			 					}
			 					pdNode.setName(command_LBL);
			 					//System.out.println("command==="+command_LBL);
				 				NodeList outputnodes = commandnode.getChildNodes();
				 				//ȡ��OUTPUT
				 				for(int x=0,y=outputnodes.getLength();x<y;x++){
				 					Node outputnode = outputnodes.item(x);
				 					//�жϵ�ǰ����Ƿ�Ϊҳ��ѡ��Ľ��
				 					if(outputnode.getNodeType()==Node.ELEMENT_NODE && "OUTPUT".equals(outputnode.getNodeName())){
				 						//����OUTPUT
				 						pdNode.setBelong(outputnode.getTextContent());
				 						//System.out.println("OUTPUT==="+outputnode.getTextContent());
				 					}
				 					
				 				}
				 				commandList.add(pdNode);
			 				}
			 			}
			 			
			 			//Ϊsection����ͬsection_name����
//			 			int num = commandList.size()-1;
//			 			for(int m=0,n=num;m<n;m++){
//			 				section_list.add(section_name);
//			 			}
			 			
			 			command_map.put(section_name, commandList);
		    		}
		    		
		    	}
		    	dto.setCommand_map(command_map);
		    	//dto.setSection_list(section_list);
		    }
		}catch(Exception e){
			log.debug("Exception:", e);
		}finally{
			return dto;
		}
	}

	/**
	 * @param ig912BL the ig912BL to set
	 */
	public void setIg912BL(IG912BL ig912BL) {
		this.ig912BL = ig912BL;
	}
	
	/**
	 * �豸��ϵ����POP������ڻ�����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 * @update 0000201
	 */
	public IGASM03DTO initIGASM1110Action(IGASM03DTO dto) throws BLException {
		log.debug("========�豸��ϵ��������ڻ�����ʼ========");
		
		//�豸��Ϣ����
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(
				Integer.parseInt(dto.getIgasm0306Form().getEiid()));
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","�豸");
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
		
		//���������ϵ����
		SOC0119SearchCondImpl parcond = new SOC0119SearchCondImpl();
		
		parcond.setEiid(dto.getIgasm0306Form().getEiid());
		parcond.setParversion(entityItemVWInfo.getEiversion());
		parcond.setParsmallversion(entityItemVWInfo.getEismallversion());
		parcond.setDeleteflag("0");
		
		Map<String,List<SOC0119Info>> parmap = new LinkedHashMap<String,List<SOC0119Info>>();
		//�豸��ϵ��Ϣ��ѯ����ȡ�� 
		int totalCount = this.soc0119BL.getEntityItemRelationSearchCount(parcond);
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========�豸��ϵ��Ϣ��ѯ���ݼ�������========");
			//�豸��ϵ��Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		if ( totalCount>0 ) {
			//�豸��ϵ��Ϣȫ������
			List<SOC0119Info> parEntityItemRelationList = 
				this.soc0119BL.searchEntityItemRelation(parcond, 0, 0);
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

		//���������ϵ����
		//������ϵ����
//		IG313SearchCondImpl cldcond = new IG313SearchCondImpl();
//		
//		cldcond.setCldeiid(dto.getIgasm0306Form().getEiid());
//		cldcond.setCldversion(entityItemVWInfo.getEiversion().toString());
//		cldcond.setCldsmallversion(entityItemVWInfo.getEismallversion().toString());
//		cldcond.setDeleteflag("0");
//		
//		//�豸��ϵ��Ϣ��ѯ����ȡ�� 
//		totalCount = this.ig313BL.getIG313InfoSearchCount(cldcond);
//		
//		if ( totalCount > dto.getMaxSearchCount() ) {
//			log.debug("========�豸��ϵ��Ϣ��ѯ���ݼ�������========");
//			//�豸��ϵ��Ϣ��ѯ���ݼ�������
//			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
//			return dto;
//		}
//
//		//�豸��ϵ��Ϣȫ������
//		List<IG313Info> cldEntityItemRelationList = 
//			this.ig313BL.searchIG313Info(
//					cldcond, 0, 0);
//		dto.setParCount(dto.getParCount()+cldEntityItemRelationList.size());
////		dto.addMessage(new ActionMessage("IGCO10000.I007",dto.getParCount()));
//		for(IG313Info e : cldEntityItemRelationList){
//			String key = e.getEirrelationcode().split("-")[0];
//			String eirrelationcode = e.getEirrelationcode();
//			String ecategory = e.getCldEntityItemVW().getEcategory();
//			if(!"-".equals(eirrelationcode.replaceAll(ecategory, ""))){
//				key = eirrelationcode.replaceAll(ecategory, "").replaceAll("-", "");
//			}
//			if(!parmap.containsKey(key)){
//				parmap.put(key, new ArrayList<IG313Info>());
//			}
//			((IG313TB)e).setParflag("1");
//			parmap.get(key).add(e);
//		}
		if(parmap.size()==0){
			parmap = null;
		}
		dto.setParEntityItemRelationMap(parmap);

		log.debug("========�豸��ϵ��������ڻ���������========");
		return dto;
	}
	

	
	
	
}
