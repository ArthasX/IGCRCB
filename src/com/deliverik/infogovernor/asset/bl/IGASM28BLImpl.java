package com.deliverik.infogovernor.asset.bl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
import com.deliverik.framework.soc.asset.model.condition.SOC0118SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0119SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0151SearchCondImpl;
import com.deliverik.framework.soc.asset.model.entity.SOC0107TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0118TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0119TB;
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
import com.deliverik.infogovernor.asset.bl.task.CheckItemVWBL;
import com.deliverik.infogovernor.asset.bl.task.CheckToRiskRelateVWBL;
import com.deliverik.infogovernor.asset.bl.task.RiskToZhRelateVWBL;
import com.deliverik.infogovernor.asset.dto.IGASM28DTO;
import com.deliverik.infogovernor.asset.form.IGASM2802Form;
import com.deliverik.infogovernor.asset.form.IGASM2804Form;
import com.deliverik.infogovernor.asset.form.IGASM2807Form;
import com.deliverik.infogovernor.asset.form.IGASM2812Form;
import com.deliverik.infogovernor.asset.form.IGASM2814Form;
import com.deliverik.infogovernor.asset.model.CheckItemVWInfo;
import com.deliverik.infogovernor.asset.model.CheckToRiskRelateVWInfo;
import com.deliverik.infogovernor.asset.model.RiskToZhRelateVWInfo;
import com.deliverik.infogovernor.asset.model.condition.CheckItemVWSearchCondImpl;
import com.deliverik.infogovernor.asset.model.condition.CheckToRiskRelateVWSearchCondImpl;
import com.deliverik.infogovernor.asset.model.condition.RiskToZhRelateVWSearchCondImpl;
import com.deliverik.infogovernor.util.CodeDefine;

/**
 * ��������ù���ҵ���߼�ʵ��
 *
 */
public class IGASM28BLImpl extends BaseBLImpl implements IGASM28BL {

	static Log log = LogFactory.getLog(IGASM28BLImpl.class);

	/** �汾��������ʶ */
	public static final String SAVE_VERSION_UP = "1";

	/** �汾�Ų�������ʶ */
	public static final String SAVE_VERSION = "0";
	
	public static final String  EIRRELATIONCODE="'013-001','013-002','013-003','013-006','013-010'";
	/**����syscondingĬ��ֵ*/
	
	protected static final String SYSCODE = "999018";	
	
	/** �ʲ���ϢBL */
//	protected IG117BL ig117BL;
	protected SOC0117BL soc0117BL;

	/** ��������ϢBL */
//	protected IG013BL soc0118BL;
	protected SOC0118BL soc0118BL;
	// TODO
	/** �ʲ�������BL */
//	protected IG800BL soc0107BL;
	protected SOC0107BL soc0107BL;
	
	/** �������ϵBL */
//	protected IG313BL soc0119BL;
	protected SOC0119BL soc0119BL;
	
	/** �ļ��ϴ�BL */
	protected FileUploadBL fileUploadBL;
	
	/** �ʲ�������ϵ��������BL */
	protected CodeDetailBL codeDetailBL;
	
	/** �ʲ�ȡֵ��Χ��������BL */
//	protected IG545BL ig545BL;
	protected SOC0151BL soc0151BL;
	
	/** ����BL */
	protected OrganizationBL organizationBL;
	
	/** ������BL */
//	protected IG225BL soc0109BL;
	protected SOC0109BL soc0109BL;
	
	/** �û���ɫBL */
	protected UserRoleBL userRoleBL;
	
	/**������ʲ���ѯ*/
	protected CheckItemVWBL checkItemVWBL;
	/**����ָ��*/
	protected  RiskToZhRelateVWBL riskToZhRelateVWBL;
	
	/**�û���ѯ*/
	protected UserBL userBL;
	
	
	/**�������յ��ϵ��ѯ*/
	protected CheckToRiskRelateVWBL checkToRiskRelateVWBL;
	
	/**
	 * �������յ��ϵ��ѯ�趨
	 * @param checkToRiskRelateVWBL �������յ��ϵ��ѯ
	 */
	public void setCheckToRiskRelateVWBL(CheckToRiskRelateVWBL checkToRiskRelateVWBL) {
		this.checkToRiskRelateVWBL = checkToRiskRelateVWBL;
	}
	/**
	 * ����ָ���趨
	 * @param riskToZhRelateVWBL ����ָ��
	 */
	public void setRiskToZhRelateVWBL(RiskToZhRelateVWBL riskToZhRelateVWBL) {
		this.riskToZhRelateVWBL = riskToZhRelateVWBL;
	}
	/**
	 * �û���ѯ�趨
	 * @param userBL �û���ѯ
	 */
	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
	}
	/**
	 * ������ʲ���ѯ�趨
	 * @param checkItemVWBL ������ʲ���ѯ
	 */
	public void setCheckItemVWBL(CheckItemVWBL checkItemVWBL) {
		this.checkItemVWBL = checkItemVWBL;
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
	 * �������Ϣ��ѯ����
	 *
	 * @param dto IGASM28DTO
	 * @return IGASM28DTO
	 */
	public IGASM28DTO searchEntityItemAction(IGASM28DTO dto) throws BLException {

		log.debug("========�������Ϣ��ѯ����ʼ========");
		
		//�������Ϣ��ѯ����ȡ�� 
		int totalCount = this.soc0118BL.getEntityItemVWSearchCount(dto.getEntityItemVWSearchCond());
		
		if (totalCount == 0) {
			log.debug("========�������Ϣ��ѯ���ݲ�����========");
			//�������Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========�������Ϣ��ѯ���ݼ�������========");
			//�������Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();

		//��ǰҳ�������Ϣȡ��
		List<SOC0124Info> entityItemVWInfoList = this.soc0118BL.searchEntityItemVW(dto.getEntityItemVWSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setEntityItemVWInfoList(entityItemVWInfoList);

		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========�������Ϣ��ѯ��������========");
		return dto;
	}
	
	/**
	 * �������Ϣ�ǼǴ���
	 *
	 * @param dto IGASM28DTO
	 * @return IGASM28DTO
	 */
	public IGASM28DTO insertEntityItemAction(IGASM28DTO dto) throws BLException {
		log.debug("========�������Ϣ�ǼǴ���ʼ========");
		//����Formȡ��
		IGASM2802Form form = dto.getIgasm2802Form();
		
		
		/*SOC0118SearchCondImpl soc0118Cond = new SOC0118SearchCondImpl();
		soc0118Cond.setEilabel(CommonDefineUtils.ENTIY_CHECK_CHECKITEMS_KEY );
		
		String eilabel = this.soc0118BL.searchNewNextEntityItemLable(soc0118Cond);
		form.setEilabel(eilabel);*/
		//�鿴���ݿ����Ƿ��д˷��յ��ŵ�
		String syscoding = this.soc0118BL.searchEntityESyscoding(form.getEilabel());
		if(StringUtils.isNotEmpty(syscoding)){
			throw new BLException("IGCO10000.E141","�� ��������Ѵ��������»�ȡ");
		}
		/*//����IDȡ��
		EntitySearchCondImpl cond = new EntitySearchCondImpl();
		cond.setElabel(form.getElabel());
		
		//�ǼǴ���ǰ���ʲ���Ϣȷ��
		List<Entity> entityList = this.ig117BL.searchEntity(cond, 0, 0);
		
		if ( entityList == null || entityList.size() ==0 ) {
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","(���=" + form.getElabel() + ")�ʲ�����");
		}
		
		Entity entity = entityList.get(0);
		
		//***************************************************************************
		//���ͷ�����
		if (!entity.getEcategory().equals(CommonDefineUtils.ENTIY_CATEGORY_CHECKITEMS)) {
			//�������������
			throw new BLException(BLErrorType.ENTITY_CATEGORY_ERROR,
					"IGCO10000.E011","�����");
		}
		//***************************************************************************
		
		form.setEid(entity.getEid());*/
		form.setEidStr(form.getEid().toString());
		
		//����ʱ���趨
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		
		form.setEiupdtime(datetime);
		
		//��汾�趨���̶���Ϊ0��
		form.setEiversion(0);
		
		//С�汾�趨���̶���Ϊ0��
		form.setEismallversion(0);

		dto.setIgasm2802Form(form);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "����������Ϣ") );
		//��������Բ�ѯ�����趨
		SOC0109SearchCondImpl soc0109Cond = new SOC0109SearchCondImpl();
		soc0109Cond.setEid("CM15000000");
		//��������Բ�ѯ����
		List<SOC0109Info> soc0109List = soc0109BL.searchConfiguration(soc0109Cond);
				
		
		
		//�����ʲ���ض���
		EntityItem entityItem1 = new EntityItem();
		entityItem1.setEidesc(form.getEidesc());
		entityItem1.setEilabel(form.getEilabel());
		entityItem1.setEiname(form.getEiname());
		entityItem1.setEiorgsyscoding(form.getEiorgsyscoding());
		entityItem1.setEiuserid(form.getEiuserid());
		entityItem1.setEiusername(form.getEiusername());
		entityItem1.setEsyscoding(form.getEsyscoding());
		
		String[] civalue = form.getCivalue();
		civalue[1]=form.getMguserid();
		//�����ʲ�������Ϣ�б�
		List<EntityItemConfigValueInfo> configItems = new ArrayList<EntityItemConfigValueInfo>();
		EntityItemConfigValue configItem = null;
		for(int i=0; i<soc0109List.size();i++){
		SOC0109Info info =soc0109List.get(i);
		configItem = new EntityItemConfigValue();
		configItem.setName(info.getCname());
		configItem.setValue(civalue[i]);	
		configItem.setFile(null);
		configItems.add(configItem);
		}
		
		
		
		entityItem1.setConfigItems(configItems);
		//����ʲ�
		Integer eiiddd = createEntityItem(entityItem1);
		dto.setEiid(eiiddd);
		log.debug("========�������Ϣ�ǼǴ�������========");
		return dto;
	}

	/**
	 * �������Ϣɾ������
	 *
	 * @param dto IGASM28DTO
	 * @return IGASM28DTO
	 */
	public IGASM28DTO deleteEntityItemAction(IGASM28DTO dto) throws BLException {
		log.debug("========�������Ϣɾ������ʼ========");
		
		for( int i=0;i<dto.getDeleteEntityItem().length;i++ ){
			String eiid = dto.getDeleteEntityItem()[i];
			
			//ɾ��ǰɾ����������ȷ��
			SOC0118Info entityItem = this.soc0118BL.searchEntityItemByKey(Integer.parseInt(eiid));
			
			if (entityItem == null){
				throw new BLException("IGCO10000.E004","ɾ�������������");
			}

			//�����ɾ��
			this.soc0118BL.deleteEntityItem(entityItem);
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I006","�������Ϣ"));

		log.debug("========�������Ϣɾ����������========");
		return dto;
	}

	/**
	 * �����������Ϣ�༭������ڻ�����
	 *
	 * @param dto IGASM28DTO
	 * @return IGASM28DTO
	 */
	public IGASM28DTO initIGASM2804Action(IGASM28DTO dto) throws BLException {

		log.debug("========�����������Ϣ�༭������ڻ�����ʼ========");
		IGASM2804Form form = dto.getIgasm2804Form();
		
		
		
		//�������Ϣ����
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(
				Integer.parseInt(form.getEiid()));
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","�����");
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
		//�жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(), entityItemVWInfo);

		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}else{
			dto.setFlag(flag);
		}
		
		
		//�����������Ϣ��ѯ����ȡ�� 
		int totalCount = this.soc0107BL.getConfigItemVWSearchCount(form);
		
		if (totalCount == 0) {
			log.debug("========�����������Ϣ��ѯ���ݲ�����========");
			//�����������Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I007",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========�����������Ϣ��ѯ���ݼ�������========");
			//�����������Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//�����������Ϣȫ����ѯ
		List<SOC0129Info> configItemVWInfoList = this.soc0107BL.searchConfigItemSoc0109VW(
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
					Integer cldeiid = Integer.parseInt(value.substring(value.lastIndexOf("(")+1, value.length()-1));//���ʲ�eiid
					
					SOC0119SearchCondImpl cond=new SOC0119SearchCondImpl();
					cond.setPareiid(Integer.parseInt(form.getEiid()));
					cond.setCldeiid(cldeiid);
					cond.setParversion(entityItemVWInfo.getEiversion());
					cond.setEirinfo("_"+e.getCiid()+"_");
					cond.setDeleteflag("0");
					List<SOC0119Info> ig313Info = soc0119BL.searchEntityItemRelation(cond);
					String cldversion="";
					if(ig313Info!=null&&ig313Info.size()>0){
						cldversion = String.valueOf(ig313Info.get(0).getCldversion());//���ʲ��汾
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
		if(dto.getUser().getUserid().equals(civalue[1])){
			dto.setIdentyFlag("true");
		}else{
			dto.setIdentyFlag("false");
		}
		/**������ID*/
		if(civalue[1]!=null && civalue[1] !=""){
		/**��ѯ����������*/
		User searchUserByKey = this.userBL.searchUserByKey(civalue[1]);
		dto.setHiddenmguserid(civalue[1]);
		/**�趨����������*/
		civalue[1] =searchUserByKey.getUsername();
		}
		
		form.setCivalue(civalue);
		form.setEntityItemCivalue(entityItemCivalue);
		form.setDelfile(delfile);
		form.setCivalue_bak(civalue_bak);
		form.setIsUpgrade(isUpgrade);
		
		/**������ѯ�����趨*/
		CheckItemVWSearchCondImpl checkCond = new CheckItemVWSearchCondImpl();
		checkCond.setEiid(form.getEiid());
		checkCond.setSyscoding("999018");
		/**������ʲ��汾��ѯ*/
		List<CheckItemVWInfo> itemList = this.checkItemVWBL.searchCheckItemVW(checkCond, 0,0);
		Map<Integer,Integer> checkVersionMap = new LinkedHashMap<Integer, Integer>();
		for (i=0;i<itemList.get(0).getEiversion();i++){
			checkVersionMap.put(i,i+1);
		}
		dto.setItemList(itemList);
		dto.setCheckVersionMap(checkVersionMap);
		dto.setConfigItemVWInfoMap(map);
//		dto.addMessage(new ActionMessage("IGCO10000.I007",totalCount));
		
		/**�����-----���յ� ��ϵ��ѯ*/
		//��ѯ�����趨
		CheckToRiskRelateVWSearchCondImpl checkToRiskRealateCond = new CheckToRiskRelateVWSearchCondImpl();
		checkToRiskRealateCond.setEiid(form.getEiid());
		List<CheckToRiskRelateVWInfo> checkToRiskRelateList = this.checkToRiskRelateVWBL.searchCheckToRiskRelateVW(checkToRiskRealateCond, 0, 0);
		/**����---------ָ���ϵ��ѯ*/
		//��ѯ�����趨
		RiskToZhRelateVWSearchCondImpl riskToZbCond = new RiskToZhRelateVWSearchCondImpl();
		riskToZbCond.setSign("0");
		riskToZbCond.setEiid(form.getEiid());
	    List<RiskToZhRelateVWInfo> riskToZhRelateList = riskToZhRelateVWBL.searchRiskToZhRelateVW(riskToZbCond, 0, 0);
	    //dto����ֵ�趨
		dto.setRiskToZhRelateList(riskToZhRelateList);
		dto.setCheckToRiskRelateList(checkToRiskRelateList);
		log.debug("========�����������Ϣ�༭������ڻ���������========");
		return dto;
	}
	
	/**
	 * �����������Ϣ�༭����
	 *
	 * @param dto IGASM28DTO
	 * @return IGASM28DTO
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public IGASM28DTO editEntityItemAction(IGASM28DTO dto) throws BLException, FileNotFoundException, IOException {
		log.debug("========�����������Ϣ�༭����ʼ========");
		//�汾������
		IGASM2804Form form = dto.getIgasm2804Form();
		
		//����������Ϣ����
		SOC0118TB entityItem = (SOC0118TB) this.soc0118BL.searchEntityItemByKey(Integer.parseInt(form.getEiid()));
		// ȡ�ð汾�Ƿ�������ʶ
		String ident = form.getIdent();
		if(StringUtils.isEmpty(ident)){
			ident = IGASM28BLImpl.SAVE_VERSION;
		}
		// �汾�ų�ʼ��
		int version = 1;
		boolean versonFlag = false;
		// �ж��Ƿ������汾��
		// =====================>> �޸� start
		if (IGASM28BLImpl.SAVE_VERSION_UP.equals(ident)) { // �����汾��
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
                            IG013TB cldEntityItem = (IG013TB) this.soc0118BL.searchEntityItemByKey(Integer.parseInt(cldeiid));
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
		} else if (IGASM28BLImpl.SAVE_VERSION.equals(ident)) { // �������汾��

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
		
		//�����״̬
//		entityItem.setEistatus(form.getEistatus());
		//�����汾
		entityItem.setEiversion(version);
		
		//�����˵��
		entityItem.setEidesc(form.getEidesc());

		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		
		//����ʱ��
		entityItem.setEiupdtime(datetime);
		//���¼������
		entityItem.setEiname(form.getCivalue()[0]);
		//���¼��˵��
		entityItem.setEidesc(form.getCivalue()[6]);
		this.soc0118BL.updateEntityItem(entityItem);
		//=======���¹�ϵ��ʼ========
		if(version ==1&&versonFlag){
			SOC0119SearchCondImpl eircond1 = new SOC0119SearchCondImpl();
			//ɾ����ʶ
			eircond1.setDeleteflag("0");
			//����ʲ���صĹ�ϵ��
			eircond1.setEirrelationcode(IGASM28BLImpl.EIRRELATIONCODE);
			eircond1.setEiid(String.valueOf(entityItem.getEiid()));
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
		
		//�����������Ϣ����
		if (form.getCiid() != null && form.getCiid().length > 0 ) {
			
			for( int i=0 ; i < form.getCiid().length; i++ ){
				SOC0107TB configItem = new SOC0107TB();
				//�����ID
				configItem.setEiid(Integer.parseInt(form.getEiid()));
				//�ʲ�����ID
				configItem.setCid(form.getCid()[i]);
				//����ID
				configItem.setEid(form.getEid()[i]);
				//���Ͳ����
				configItem.setEsyscoding(form.getEsyscoding()[i]);
				//����
				configItem.setCivalue(form.getCivalue()[i]);
				//��汾��
				configItem.setCiversion(version);
				//С�汾��
				configItem.setCismallversion(0);
				//����ʱ��
				configItem.setCiupdtime(datetime);
				
				//��ʾ���ʲ����ƣ�ʵ�ʴ�ֵ���ʲ�����(�ʲ�ID)
				if("4".equals(form.getCiattach()[i]) && StringUtils.isNotEmpty(form.getEntityItemCivalue()[i])){
					configItem.setCivalue(form.getEntityItemCivalue()[i]);
				}
				
				//����ɾ��
				if("1".equals(form.getCiattach()[i]) && "1".equals(form.getDelfile()[i])){
					configItem.setCivalue("");
				}
				
				if (StringUtils.isEmpty(form.getCiid()[i])) {
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
					
					// �ж��Ƿ������汾��
					if (IGASM28BLImpl.SAVE_VERSION_UP.equals(ident)) { // �����汾��

						configItem = (SOC0107TB) this.soc0107BL.registSOC0107(configItem);

					} else if (IGASM28BLImpl.SAVE_VERSION.equals(ident)) { // �������汾��
					
						Integer ciid = Integer.valueOf(form.getCiid()[i]); 
						
						// ��ѯ��ǰ������
						SOC0107Info cfi = this.soc0107BL.searchSOC0107ByKey(ciid);
						
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
						SOC0118Info ei = this.soc0118BL.searchEntityItemByKey(Integer.parseInt(str.substring(str.lastIndexOf("(")+1, str.length()-1)));
				
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
						String rootPath = ResourceUtility.getString("UPLOAD_FILE_ROOT_PATH");
						StringBuffer pathBuf = new StringBuffer();
						
						//��Ŀ¼
						pathBuf.append(rootPath);
						//����ID
						pathBuf.append("asm"+File.separator);
						//�����ID
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
						fileName.append(configItem.getCiversion());
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
			}
			
		}
	
		dto.addMessage(new ActionMessage("IGCO10000.I005","�����������Ϣ"));
		
		log.debug("========�����������Ϣ�༭��������========");
		
		return dto;
	}

	/**
	 * �����������Ϣ��ʷ��¼������ڻ�����
	 *
	 * @param dto IGASM28DTO
	 * @return IGASM28DTO
	 */
	public IGASM28DTO initIGASM2805Action(IGASM28DTO dto) throws BLException {
		log.debug("========�����������Ϣ��ʷ��¼������ڻ�����ʼ========");
		
		//�������Ϣ����
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(
				dto.getIgasm2805Form().getEiid());
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","�����");
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
		
		if (StringUtils.isEmpty(dto.getIgasm2805Form().getCiversion()+"")) {
			dto.getIgasm2805Form().setCiversion(String.valueOf(entityItemVWInfo.getEiversion()));
		}
		//��ȡ��ʷ�汾����ʱ��
		dto.setConfigItemVersionTime(this.soc0118BL.searchVersionUpdateTime(dto.getIgasm2805Form().getEiid()));
		
		//�жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(), entityItemVWInfo);

		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}else{
			dto.setFlag(flag);
		}
		
		log.debug("========�����������Ϣ��ʷ��¼������ڻ���������========");
		return dto;
	}

	/**
	 * ������ϵ��������ڻ�����
	 *
	 * @param dto IGASM28DTO
	 * @return IGASM28DTO
	 */
	public IGASM28DTO initIGASM2806Action(IGASM28DTO dto) throws BLException {
		log.debug("========������ϵ��������ڻ�����ʼ========");
		
		//�������Ϣ����
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(
				Integer.parseInt(dto.getIgasm2806Form().getEiid()));
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","�����");
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
		//���������ϵ����
		SOC0119SearchCondImpl parcond = new SOC0119SearchCondImpl();
		if((dto.getIgasm2806Form().getEiid())!=null)
		{parcond.setPareiid(Integer.parseInt(dto.getIgasm2806Form().getEiid()));}
		parcond.setParversion(entityItemVWInfo.getEiversion());
		parcond.setParsmallversion(entityItemVWInfo.getEismallversion());
		parcond.setDeleteflag("0");
		//�жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(), entityItemVWInfo);

		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}else{
			dto.setFlag(flag);
		}
		//������ϵ��Ϣ��ѯ����ȡ�� 
		int totalCount = this.soc0119BL.getEntityItemRelationSearchCount(parcond);
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========������ϵ��Ϣ��ѯ���ݼ�������========");
			//������ϵ��Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		if ( totalCount>0 ) {
			//������ϵ��Ϣȫ������
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
//		SOC0119SearchCondImpl cldcond = new SOC0119SearchCondImpl();
//		
//		cldcond.setCldeiid(dto.getIgasm2806Form().getEiid());
//		cldcond.setCldversion(entityItemVWInfo.getEiversion().toString());
//		cldcond.setCldsmallversion(entityItemVWInfo.getEismallversion().toString());
//		cldcond.setDeleteflag("0");
//		
//		//������ϵ��Ϣ��ѯ����ȡ�� 
//		totalCount = this.soc0119BL.getEntityItemRelationSearchCount(cldcond);
//		
//		if ( totalCount > dto.getMaxSearchCount() ) {
//			log.debug("========������ϵ��Ϣ��ѯ���ݼ�������========");
//			//������ϵ��Ϣ��ѯ���ݼ�������
//			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
//			return dto;
//		}
//
//		//������ϵ��Ϣȫ������
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

		log.debug("========������ϵ��������ڻ���������========");
		return dto;
	}
	
	/**
	 * ������ϵɾ������
	 *
	 * @param dto IGASM28DTO
	 * @return IGASM28DTO
	 */
	public IGASM28DTO deleteEntityItemRelationAction(IGASM28DTO dto) throws BLException {
		log.debug("========������ϵɾ������ʼ========");
		
		for( int i=0;i<dto.getDeleteEntityItemRelation().length;i++ ){
			String eirid = dto.getDeleteEntityItemRelation()[i];
			
			SOC0119Info entityItemRelation = 
				this.soc0119BL.searchEntityItemRelationByKey(Integer.parseInt(eirid));
			
			if (entityItemRelation == null){
				throw new BLException("IGCO10000.E004","ɾ�����������ϵ");
			}

			this.soc0119BL.deleteEntityItemRelation(entityItemRelation);
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I006","������ϵ��Ϣ"));

		log.debug("========������ϵɾ����������========");
		return dto;
	}

	/**
	 * ������ϵ�ǼǴ���
	 *
	 * @param dto IGASM28DTO
	 * @return IGASM28DTO
	 */
	public IGASM28DTO insertEntityItemRelationAction(IGASM28DTO dto) throws BLException {
		log.debug("========������ϵ�ǼǴ���ʼ========");
		
		IGASM2807Form form = dto.getIgasm2807Form();
		
		//�����ID���ӣ�ȡ��
		SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
		
		cond.setElabel(form.getElabel());
		cond.setEilabel(form.getEilabel());
		
		List<SOC0124Info> entityItemVWList = this.soc0118BL.searchEntityItemVW(cond, 0, 0);
		
		if ( entityItemVWList==null || entityItemVWList.size() == 0 ) {
			throw new BLException("IGCO10000.E004","(�ʲ����=" + form.getElabel() + ",�������=" 
					+ form.getEilabel() + ")�����");
		}
		
		form.setCldeiid(entityItemVWList.get(0).getEiid());
		form.setCldeid(entityItemVWList.get(0).getEid());
		form.setCldsmallversion(entityItemVWList.get(0).getEismallversion());
		form.setCldversion(entityItemVWList.get(0).getEiversion());
		
		//�����ID�������ͣ��ӣ����
		if (form.getPareiid().intValue() == form.getCldeiid().intValue()) {
			//�����ID������= ���ӣ�
			throw new BLException(BLErrorType.ENTITY_ITEM_RELATION_ERROR,
					"IGCO10000.E012","�����");
		}
		
		//����ʱ���趨
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

		form.setEirupdtime(datetime);
		
		//�ʲ���ϵ�Ǽ�
		SOC0119Info ret = 
			this.soc0119BL.registEntityItemRelation(dto.getIgasm2807Form());
		
		dto.setEntityItemRelation(ret);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "������ϵ��Ϣ") );
		
		log.debug("========������ϵ�ǼǴ�������========");
		return dto;
	}
	
	/**
	 * ������ϵ�༭������ڻ�����
	 *
	 * @param dto IGASM28DTO
	 * @return IGASM28DTO
	 */
	public IGASM28DTO initIGASM2807Action(IGASM28DTO dto) throws BLException {
		log.debug("========������ϵ�༭������ڻ�����ʼ========");
		
		IGASM2807Form form = dto.getIgasm2807Form();
		SOC0119TB ret = 		
			(SOC0119TB) this.soc0119BL.searchEntityItemRelationByKey(
				form.getEirid());
		
		if ( ret == null ){
			throw new BLException("IGCO10000.E004","�༭���������ϵ");
		}
		
		//��������趨
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
		
		log.debug("========������ϵ�༭������ڻ���������========");
		return dto;
	}

	/**
	 * ������ϵ���������
	 *
	 * @param dto IGASM28DTO
	 * @return IGASM28DTO
	 */
	public IGASM28DTO updateEntityItemRelationAction(IGASM28DTO dto) throws BLException {
		log.debug("========������ϵ���������ʼ========");
		IGASM2807Form form = dto.getIgasm2807Form();

		//����ʱ���趨
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

		form.setEirupdtime(datetime);
		
		this.soc0119BL.updateEntityItemRelation(form);

		dto.addMessage(new ActionMessage( "IGCO10000.I005", "������ϵ��Ϣ") );

		log.debug("========������ϵ�������������========");
		return dto;
	}
	
	/**
	 *	��ȡ����������ϵ����
	 *
	 * @param dto IGASM28DTO
	 * @return IGASM28DTO
	 */
	public IGASM28DTO searchRelationListAction(IGASM28DTO dto) throws BLException {
		log.debug("========��ȡ����������ϵ����ʼ========");
		List<LabelValueBean> list = this.codeDetailBL.searchLabelValueBeanList(CommonDefineUtils.ENTIY_CATEGORY_CHECKITEMS,CodeDefine.getCodeDefine("ENTITY_ITEM_RELATION_CODE").getCcid());
		dto.setRelationList(list);
		log.debug("========��ȡ����������ϵ��������========");
		return dto;
	}
	

	/**
	 *�������Ϣ�޸ĳ�����ʾ����
	 *
	 * @param dto IGASM28DTO
	 * @return IGASM28DTO
	 */
	public IGASM28DTO initEntityItem(IGASM28DTO dto) throws BLException {

		log.debug("========�������Ϣ�༭���������ʾ����ʼ========");
		
		IGASM2812Form form = dto.getIgasm2812Form();
		
		//��ʾ���ʲ���Ϣȡ��
		SOC0124Info entityItem = this.soc0118BL.searchEntityItemVWByKey(form.getEiid());
		
		if ( entityItem == null ){
			throw new BLException("IGCO10000.E004","�����������");
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
		
		//�жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
		boolean permission = this.soc0118BL.checkEntityItemDomain(dto.getUser(), entityItem);
		boolean isRoleManager = this.userRoleBL.checkRoleManagerByType(dto.getUser().getUserid(), EntityCategory.ROLE_TYPE_DOCUMENT);
		form.setRoleManager(isRoleManager);
		form.setPermission(permission);
		
		dto.setIgasm2812Form(form);
		
		//dto.addMessage(new ActionMessage("IGCO10000.I001","����������Ϣ"));
		if(!permission) {
			dto.addMessage(new ActionMessage("IGCO10000.E023","�޸�"));
		}
		log.debug("========�������Ϣ�༭���������ʾ��������========");
		return dto;
	}
	/**
	 *�������Ϣ�޸Ĵ���
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM28DTO updateEntityItem(IGASM28DTO dto) throws BLException {
		
		log.debug("========�������Ϣ�༭���������ʾ����ʼ========");
		
		IGASM2812Form form = dto.getIgasm2812Form();
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
			IG225TB cTB1 = (IG225TB)SerializationUtils.clone(clist1.get(0));
			//�ʲ����Ƶ�cid
			ccond.setClabel(EntityItemKeyWords.ENTITY_DEFAULT_DEVICE_ENAME);
			List<SOC0109Info> clist2 = this.soc0109BL.searchConfiguration(ccond);
			IG225TB cTB2 = (IG225TB)SerializationUtils.clone(clist2.get(0));
			
			cicond.setCivalue(null);
			for(int j = 0; j < erlist.size(); j++){
				//�����¼
				//�ʲ�ID
				SOC0119TB erTB = (SOC0119TB)SerializationUtils.clone(erlist.get(j));
				cicond.setEiid(String.valueOf(erTB.getPareiid()));
				cicond.setCid(String.valueOf(cTB1.getCid()));
				List<SOC0107Info> cilist1 = this.soc0107BL.searchSOC0107(cicond);
				//�����ϵ�������ʲ�civalue�����ʲ�ID��ֵ,�����һ���е��ʲ�����
				if(!cilist1.isEmpty()){
					SOC0107TB ciTB1 = (SOC0107TB)SerializationUtils.clone(cilist1.get(0));
					cicond.setCid(String.valueOf(cTB2.getCid()));
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
		dto.addMessage(new ActionMessage("IGCO10000.I005","����������Ϣ"));
		log.debug("========�������Ϣ�༭���������ʾ��������========");
		return dto;
	}
	
	/**
	 * ��ȡ����������ֵ
	 *
	 * @param dto IGASM28DTO
	 * @return IGASM28DTO
	 */
	public IGASM28DTO searchEntityItemLableAction(IGASM28DTO dto) throws BLException {
		
		log.debug("========��ȡ����������ֵ����ʼ========");
		//��������Բ�ѯ�����趨
		SOC0109SearchCondImpl soc0109Cond = new SOC0109SearchCondImpl();
		soc0109Cond.setEid("CM15000000");
		//��������Բ�ѯ����
		List<SOC0109Info> soc0109List = soc0109BL.searchConfiguration(soc0109Cond);
		
		IGASM2802Form form = dto.getIgasm2802Form();
		
		//SOC0118SearchCondImpl cond = new SOC0118SearchCondImpl();
		
		//cond.setEilabel(CommonDefineUtils.ENTIY_CHECK_CHECKITEMS_KEY );
		
		//String eilabel = this.soc0118BL.searchNewNextEntityItemLable(cond);
		
		//form.setEilabel(eilabel);
		dto.setSoc0109List(soc0109List);
		log.debug("========��ȡ����������ֵ��������========");
		return dto;
	}
	
	/**
	 * �жϵ�½�û��Ƿ��Ǽ�����ʲ������ɫ������
	 * 
	 * @param dto IGASM28DTO
	 * @return IGASM28DTO
	 * @throws BLException 
	 */
	public IGASM28DTO checkEntityItemDomain(IGASM28DTO dto) throws BLException{
		boolean isRoleManager = this.userRoleBL.checkRoleManagerByType(dto.getUser().getUserid(), EntityCategory.ROLE_TYPE_DOCUMENT);
		
		if(isRoleManager) {
			OrganizationSearchCondImpl orgCond = new OrganizationSearchCondImpl();
			orgCond.setOrgpar("0001");
			List<Organization> org = this.organizationBL.searchOrganization(orgCond);
			
			if(org.size() != 1) {
				throw new BLException("IGCO10000.E004","��������");
			} else {
				dto.setOrgname(org.get(0).getOrgname());
				dto.setOrgsyscoding(org.get(0).getOrgsyscoding());
			}
			SOC0117SearchCondImpl entityCond = new SOC0117SearchCondImpl();
			entityCond.setEsyscoding(CommonDefineUtils.ENTIY_CATEGORY_CHECKITEMS_SYSCODING);
			List<SOC0117Info> entity = this.soc0117BL.searchEntity(entityCond, 0, 0);
			
			if(entity.size() != 1) {
				throw new BLException("IGCO10000.E004","�����ģ��");
			} else {
				dto.setEname(entity.get(0).getEname());
				dto.setEsyscoding(entity.get(0).getEsyscoding());
			}
		}
		
		dto.setFlag(isRoleManager);
		
		return dto;
	}
	public IGASM28DTO searchCheckItemListAction(IGASM28DTO dto)
			throws BLException {
		
		IGASM2814Form form = dto.getIgasm2814form();
		/**������ѯ�����趨*/
		CheckItemVWSearchCondImpl cond = new CheckItemVWSearchCondImpl();
		cond.setEiname(form.getEiname());
		cond.setManagername(form.getMguserid());
		cond.setBh(form.getEilabel());
		cond.setCheckfrequency(form.getCheckfrequency());
		cond.setStartdate(form.getStartdate());
		cond.setEnddate(form.getEnddate());
		/**�趨���շ��� syscoding��*/
		if(null==form.getSyscoding()||"".equals(form.getSyscoding())){
			cond.setSyscoding(SYSCODE);
		}else{
			cond.setSyscoding(form.getSyscoding());
		}
		// ��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();
		pDto.getPageDispCount();
		/**��ҳ����*/
		int totalCount = this.checkItemVWBL.searchCheckItemVW(cond, 0, 0).size();
		
		
		
		if (totalCount == 0) {

			log.debug("========�û����ݼ������ݲ�����========");
			// ֪ʶ����������ݲ�����
			dto.addMessage(new ActionMessage("IGBCM0101.I002", 0));

			return dto;
		}

		if (totalCount > dto.getMaxSearchCount()) {

			log.debug("========�û��������ݼ�������========");
			// �û��������ݼ�������
			dto.addMessage(new ActionMessage("IGBCM0101.E005", dto
					.getMaxSearchCount(), totalCount));

			return dto;
		}
		
		/**������ʲ���ѯ*/
		List<CheckItemVWInfo> itemList = this.checkItemVWBL.searchCheckItemVW(cond, pDto.getFromCount(),
				pDto.getPageDispCount());
		
		/**��ѯ�����set��dto*/
		dto.setItemList(itemList);
		pDto.setTotalCount(totalCount);
		return dto;
	}
	
	/**
	 * ��������� ȡֵ��Χ
	 * @param dto IGASM18DTO
	 * @return IGASM18DTO 
	 */
	public IGASM28DTO searchRiskPropertyActioin(IGASM28DTO dto)
			throws BLException {
		
		/**������Ƶ��ȡֵ ��ѯ*/
		SOC0151SearchCondImpl levelCond=new SOC0151SearchCondImpl();
		/**�趨��ѯ����*/
		levelCond.setCcdtype("A");
		levelCond.setCcdcategory("149");
		levelCond.setCcdstatus("1");
		/**������Ƶ�ȼ��ϻ�ȡ*/
		List<SOC0151Info> checkfrequencyList = soc0151BL.searchConfigurationCodeDetail(levelCond);

		//set��dto
		dto.setCheckfrequencyList(checkfrequencyList);
		return dto;
	}

	/**
	 * ����ʲ�����
	 * @param eiid �ʲ�ID
	 * @param lst_EntityItemConfigValueInfo �ʲ�������Ϣ
	 * @throws BLException
	 */
	public IGASM28DTO createConfigItem(Integer eiid, List<EntityItemConfigValueInfo> lst_EntityItemConfigValueInfo)throws BLException {
		IGASM28DTO dto = new IGASM28DTO();
		if(eiid == null || eiid == 0) throw new BLException("IGFLOW0000.E001","�ʲ�ID");
		if(lst_EntityItemConfigValueInfo == null || lst_EntityItemConfigValueInfo.size() == 0)
			throw new BLException("IGFLOW0000.E001","�ʲ�������Ϣ");
		//��װ�ʲ�������Ϣ
		SOC0118Info entity = soc0118BL.searchEntityItemByKey(eiid);
		if(entity.getEiversion() != null && entity.getEiversion() > 0) {
			throw new BLException("IGFLOW0000.E005", entity.getEiname() + "�Ѱ���������Ϣ");
		}
		//�����ʲ�������Ϣ
		//��ѯ�ʲ���������Ϣ
		List<SOC0117Info> parentNodes = soc0117BL.getParentNodes(entity.getEsyscoding());
		List<SOC0109Info> configurations = new ArrayList<SOC0109Info>();
		SOC0109SearchCondImpl configcond = new SOC0109SearchCondImpl();
		configcond.setCseq(1);
		for(SOC0117Info e:parentNodes){
			configcond.setEid(e.getEid().toString());
			configurations.addAll(soc0109BL.searchConfiguration(configcond, 0, 0));
		}
		Map<String, EntityItemConfigValueInfo> configItemValueMap = new HashMap<String, EntityItemConfigValueInfo>();
		for(EntityItemConfigValueInfo configItem: lst_EntityItemConfigValueInfo){
			configItemValueMap.put(configItem.getName(), configItem);
		}
		for(SOC0109Info configuration:configurations){
			SOC0107TB configItem = new SOC0107TB();
			//�豸ID
			configItem.setEiid(entity.getEiid());
			//ģ������ID
			configItem.setCid(configuration.getCid());
			//ģ��ID
			configItem.setEid(entity.getEid());
			//ģ�Ͳ����
			configItem.setEsyscoding(entity.getEsyscoding());
			//��汾��
			configItem.setCiversion(1);
			//С�汾��
			configItem.setCismallversion(0);
			//����ʱ��
			configItem.setCiupdtime(entity.getEiupdtime());
			//����������ֵ
			EntityItemConfigValueInfo valueInfo = configItemValueMap.get(configuration.getCname());
			if(valueInfo != null){
				configItem.setCivalue(valueInfo.getValue());
				//���������Դ���
				/*if("1".equals(configuration.getCattach())){
					String fileName = uploadAssetFormFile(valueInfo.getFile(), entity.getEiid(), 1);
					configItem.setCivalue(fileName);
				}*/
			}
			soc0107BL.registSOC0107(configItem);
		}
		SOC0118TB instance = (SOC0118TB) SerializationUtils.clone(entity);
		instance.setEiversion(1);
		soc0118BL.updateEntityItem(instance);
		
		return dto;
	}
	
	/**
	 * ����ʲ�
	 * ���������벻����ʱ���쳣
	 * ����ģ����Ϣ������ʱ���쳣
	 * @param entityItem �ʲ���Ϣ
	 * @return �ʲ�ID
	 * @throws BLException
	 */
	public Integer createEntityItem(EntityItemInfo entityItem) 	throws BLException {
		if(entityItem == null) throw new BLException("IGFLOW0000.E001","�ʲ������Ϣ");
		if(StringUtils.isEmpty(entityItem.getEsyscoding())) throw new BLException("IGFLOW0000.E001","�ʲ�����ģ����Ϣ");
		if(StringUtils.isEmpty(entityItem.getEiorgsyscoding())) throw new BLException("IGFLOW0000.E001","�ʲ�����������Ϣ");
		//��ѯ�ʲ�����ģ����Ϣ
		SOC0117SearchCondImpl entitycond = new SOC0117SearchCondImpl();
		entitycond.setEsyscoding(entityItem.getEsyscoding());
		List<SOC0117Info> entitylist = soc0117BL.searchEntity(entitycond);
		if(entitylist == null || entitylist.isEmpty()){
			throw new BLException("IGFLOW0000.E001","�ʲ�����ģ����Ϣ");
		}else if(entitylist.size() > 1){
			throw new BLException("IGFLOW0000.E002","�ʲ�����ģ����Ϣ");
		}
		//��װ�ʲ�������Ϣ
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
		//�����ʲ�������Ϣ
		if(entityItem.getConfigItems() != null && entityItem.getConfigItems().size() > 0){
			//��ѯ�ʲ���������Ϣ
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
				//�豸ID
				configItem.setEiid(entity.getEiid());
				//ģ������ID
				configItem.setCid(configuration.getCid());
				//ģ��ID
				configItem.setEid(entity.getEid());
				//ģ�Ͳ����
				configItem.setEsyscoding(entity.getEsyscoding());
				//��汾��
				configItem.setCiversion(1);
				//С�汾��
				configItem.setCismallversion(0);
				//����ʱ��
				configItem.setCiupdtime(entity.getEiupdtime());
				//����������ֵ
				EntityItemConfigValueInfo valueInfo = configItemValueMap.get(configuration.getCname());
				if(valueInfo != null){
					configItem.setCivalue(valueInfo.getValue());
					//���������Դ���
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
}
