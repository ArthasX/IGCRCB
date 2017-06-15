package com.deliverik.infogovernor.asset.bl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
import org.apache.struts.util.MessageResources;

import com.deliverik.framework.asset.EntityCategory;
import com.deliverik.framework.asset.EntityItemKeyWords;
import com.deliverik.framework.asset.bl.task.IG013BL;
import com.deliverik.framework.asset.bl.task.IG499BL;
import com.deliverik.framework.asset.model.IG499Info;
import com.deliverik.framework.asset.model.condition.IG499SearchCondImpl;
import com.deliverik.framework.asset.model.entity.IG225TB;
import com.deliverik.framework.asset.model.entity.IG499VW;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.bl.FileUploadBL;
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
import com.deliverik.framework.soc.asset.model.condition.SOC0107SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0109SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0117SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0119SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0129SearchCondImpl;
import com.deliverik.framework.soc.asset.model.entity.SOC0107TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0118TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0119TB;
import com.deliverik.framework.user.bl.task.OrganizationBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.condition.OrganizationSearchCondImpl;
import com.deliverik.framework.utility.BLErrorType;
import com.deliverik.framework.utility.CodeListUtils;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.asset.dto.IGASM04DTO;
import com.deliverik.infogovernor.asset.form.IGASM0402Form;
import com.deliverik.infogovernor.asset.form.IGASM0404Form;
import com.deliverik.infogovernor.asset.form.IGASM0407Form;
import com.deliverik.infogovernor.asset.form.IGASM0412Form;
import com.deliverik.infogovernor.asset.form.IGASM0421Form;
import com.deliverik.infogovernor.asset.form.IGASM0424Form;
import com.deliverik.infogovernor.util.CodeDefine;

/**
 * ��ͬ���ù���ҵ���߼�ʵ��
 *
 */
public class IGASM04BLImpl extends BaseBLImpl implements IGASM04BL {

	static Log log = LogFactory.getLog(IGASM04BLImpl.class);
	
	private final static String XML_HEADER= "%3C?xml%20version=%221.0%22%20encoding=%22utf-8%22%20?%3E";
	
	private final static String SERVICE_PROVIDER = "4";
	
	/** ��ȡSystemConfigResources��Ϣ��Դ�ļ� */
	private MessageResources resources = MessageResources.getMessageResources("SystemConfigResources");

	/** �汾��������ʶ */
	public static final String SAVE_VERSION_UP = "1";

	/** �汾�Ų�������ʶ */
	public static final String SAVE_VERSION = "0";
	
	public static final String EIRRELATIONCODE="'002-011','003-011','011-005','006-011','011-011','011-010','001-011'";
	
	/** �ʲ���ϢBL */
	protected SOC0117BL soc0117BL;

	/** ��������ϢBL */
	protected IG013BL ig013BL;
	protected SOC0118BL soc0118BL;
	
	/** �ʲ�������BL */
	protected SOC0107BL soc0107BL;
	
	/** �������ϵBL */
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
	protected SOC0109BL soc0109BL;
	
	/** �û���ɫBL */
	protected UserRoleBL userRoleBL;
	
	protected IG499BL ig499BL;
	
	/** ��������BL */
	protected CodeListUtils codeListUtils;
	
	public void setIg499BL(IG499BL ig499BL) {
		this.ig499BL = ig499BL;
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
	 * ��������BL�趨
	 * 
	 * @param codeListUtils ��������BL
	 */
	public void setCodeListUtils(CodeListUtils codeListUtils) {
		this.codeListUtils = codeListUtils;
	}

	/**
	 * ��ͬ��Ϣ��ѯ����
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO searchEntityItemAction(IGASM04DTO dto) throws BLException {

		log.debug("========��ͬ��Ϣ��ѯ����ʼ========");
		
		//��ͬ��Ϣ��ѯ����ȡ�� 
		int totalCount = this.ig499BL.getSearchCount(dto.getEntityItemCompactVWSearchCond());
		List<LabelValueBean> selectList = this.soc0151BL.searchLabelValueBeanList("039");
		dto.setSelectList(selectList);
		
		if (totalCount == 0) {
			log.debug("========��ͬ��Ϣ��ѯ���ݲ�����========");
			//��ͬ��Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========��ͬ��Ϣ��ѯ���ݼ�������========");
			//��ͬ��Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();

		//��ǰҳ��ͬ��Ϣȡ��
		List<IG499Info> entityItemCompactVWInfoList = this.ig499BL.searchIG499Info(dto.getEntityItemCompactVWSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setEntityItemCompactVWInfoList(entityItemCompactVWInfoList);

		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========��ͬ��Ϣ��ѯ��������========");
		return dto;
	}
	
	/**
	 * ��ͬ��Ϣ�ǼǴ���
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO insertEntityItemAction(IGASM04DTO dto) throws BLException {
		log.debug("========��ͬ��Ϣ�ǼǴ���ʼ========");
		//����Formȡ��
		IGASM0402Form form = dto.getIgasm0402Form();
		
		/*//����IDȡ��
		EntitySearchCondImpl cond = new EntitySearchCondImpl();
		cond.setElabel(form.getElabel());
		
		//�ǼǴ���ǰ���ʲ���Ϣȷ��
		List<Entity> entityList = this.soc0117BL.searchEntity(cond, 0, 0);
		
		if ( entityList == null || entityList.size() ==0 ) {
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","(���=" + form.getElabel() + ")�ʲ�����");
		}
		
		Entity entity = entityList.get(0);
		
		//***************************************************************************
		//���ͷ�����
		if (!entity.getEcategory().equals(CommonDefineUtils.ENTIY_CATEGORY_CONTRACT)) {
			//��ͬ��������
			throw new BLException(BLErrorType.ENTITY_CATEGORY_ERROR,
					"IGCO10000.E011","��ͬ");
		}
		//***************************************************************************
		
		form.setEid(entity.getEid());*/
		form.setEidStr(form.getEid().toString());
		//�����ʲ�����
//		form.setEid(CommonDefineUtils.ENTIY_CATEGORY_CONTRACT);
		form.setEid(form.getEid().toString());
		//�����ʲ�ģ����
		form.setEsyscoding(CommonDefineUtils.ENTIY_CATEGORY_CONTRACT_SYSCODING);
		//���ú�ͬ�ʲ�Ĭ�ϻ�����������
		form.setEiorgsyscoding(dto.getUser().getOrgid());
		
		//����ʱ���趨
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		
		form.setEiupdtime(datetime);
		
		//��汾�趨���̶���Ϊ0��
		form.setEiversion(0);
		
		//С�汾�趨���̶���Ϊ0��
		form.setEismallversion(0);

		//��ͬ��Ϣ��¼
		SOC0118Info entityItem = this.soc0118BL.registEntityItem(dto.getIgasm0402Form());
		
		form.setEiidStr(entityItem.getEiid().toString());
		
		dto.setIgasm0402Form(form);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "��ͬ������Ϣ") );

		log.debug("========��ͬ��Ϣ�ǼǴ�������========");
		return dto;
	}

	/**
	 * ��ͬ��Ϣɾ������
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO deleteEntityItemAction(IGASM04DTO dto) throws BLException {
		log.debug("========��ͬ��Ϣɾ������ʼ========");
		
		for( int i=0;i<dto.getDeleteEntityItem().length;i++ ){
			String eiid = dto.getDeleteEntityItem()[i];
			
			//ɾ��ǰɾ�������ͬȷ��
			SOC0118Info entityItem = this.soc0118BL.searchEntityItemByKey(Integer.parseInt(eiid));
			
			if (entityItem == null){
				throw new BLException("IGCO10000.E004","ɾ�������ͬ����");
			}

			//��ͬɾ��
			this.soc0118BL.deleteEntityItem(entityItem);
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I006","��ͬ��Ϣ"));

		log.debug("========��ͬ��Ϣɾ����������========");
		return dto;
	}

	/**
	 * ��ͬ������Ϣ�༭������ڻ�����
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO initIGASM0404Action(IGASM04DTO dto) throws BLException {

		log.debug("========��ͬ������Ϣ�༭������ڻ�����ʼ========");
		
		IGASM0404Form form = dto.getIgasm0404Form();
		//��ȡ��Ϣ��Դ�ļ���ʶ
		String image_flag = resources.getMessage("IMAGE_FLAG");
		
		//��ͬ��Ϣ����
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(
			Integer.parseInt(form.getEiid()));
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","��ͬ");
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
		
		//��ͬ������Ϣ��ѯ����ȡ�� 
		int totalCount = this.soc0107BL.getConfigItemVWSearchCount(form);
		
		if (totalCount == 0) {
			log.debug("========��ͬ������Ϣ��ѯ���ݲ�����========");
			//��ͬ������Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I007",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========��ͬ������Ϣ��ѯ���ݼ�������========");
			//��ͬ������Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//��ͬ������Ϣȫ����ѯ
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
		Map<String,String> dismap = new HashMap<String, String>();
		
		
		dismap.put("IG_0121","n");
		dismap.put("IG_0122","n");
		dismap.put("IG_0123","n");
		dismap.put("IG_0124","n");
		dismap.put("IG_0125","n");
		dismap.put("IG_0126","n");
		dismap.put("IG_0127","n");
		dismap.put("IG_0128","n");
		dismap.put("IG_0129","n");
		dismap.put("IG_0130","n");
		dismap.put("IG_0131","n");
		dismap.put("IG_0132","n");
		dismap.put("IG_0133","n");
		dismap.put("IG_0134","n");
		dismap.put("IG_0135","n");
		dismap.put("IG_0136","n");
		
		dismap.put("IG_0154","n");
		dismap.put("IG_0155","n");
		dismap.put("IG_0156","n");
		dismap.put("IG_0157","n");
		dismap.put("IG_0159","n");
		dismap.put("IG_0160","n");
		dismap.put("IG_0161","n");
		dismap.put("IG_0162","n");
		dismap.put("IG_0167","n");
		dismap.put("IG_0168","n");
		dismap.put("IG_0169","n");
		dismap.put("IG_0170","n");
		
		//��6�ʸ���
		dismap.put("IG_0191","n");
		dismap.put("IG_0192","n");
		dismap.put("IG_0193","n");
		dismap.put("IG_0194","n");
		dismap.put("IG_0195","n");
		dismap.put("IG_0196","n");
		dismap.put("IG_0197","n");
		
		//��7�ʸ���
        dismap.put("IG_0198","n");
        dismap.put("IG_0199","n");
        dismap.put("IG_0200","n");
        dismap.put("IG_0201","n");
        dismap.put("IG_0202","n");
        dismap.put("IG_0203","n");
        dismap.put("IG_0204","n");
        
      //��8�ʸ���
        dismap.put("IG_0205","n");
        dismap.put("IG_0206","n");
        dismap.put("IG_0207","n");
        dismap.put("IG_0208","n");
        dismap.put("IG_0209","n");
        dismap.put("IG_0210","n");
        dismap.put("IG_0211","n");
        
      //��9�ʸ���
        dismap.put("IG_0212","n");
        dismap.put("IG_0213","n");
        dismap.put("IG_0214","n");
        dismap.put("IG_0215","n");
        dismap.put("IG_0216","n");
        dismap.put("IG_0217","n");
        dismap.put("IG_0218","n");
        
      //��10�ʸ���
        dismap.put("IG_0219","n");
        dismap.put("IG_0220","n");
        dismap.put("IG_0221","n");
        dismap.put("IG_0222","n");
        dismap.put("IG_0223","n");
        dismap.put("IG_0224","n");
        dismap.put("IG_0225","n");
        
      //��11�ʸ���
        dismap.put("IG_0226","n");
        dismap.put("IG_0227","n");
        dismap.put("IG_0228","n");
        dismap.put("IG_0229","n");
        dismap.put("IG_0230","n");
        dismap.put("IG_0231","n");
        dismap.put("IG_0232","n");
        
      //��12�ʸ���
        dismap.put("IG_0233","n");
        dismap.put("IG_0234","n");
        dismap.put("IG_0235","n");
        dismap.put("IG_0236","n");
        dismap.put("IG_0237","n");
        dismap.put("IG_0238","n");
        dismap.put("IG_0239","n");
        
      //��13�ʸ���
        dismap.put("IG_0240","n");
        dismap.put("IG_0241","n");
        dismap.put("IG_0242","n");
        dismap.put("IG_0243","n");
        dismap.put("IG_0244","n");
        dismap.put("IG_0245","n");
        dismap.put("IG_0246","n");
        
      //��14�ʸ���
        dismap.put("IG_0247","n");
        dismap.put("IG_0248","n");
        dismap.put("IG_0249","n");
        dismap.put("IG_0250","n");
        dismap.put("IG_0251","n");
        dismap.put("IG_0252","n");
        dismap.put("IG_0253","n");
        
      //��15�ʸ���
        dismap.put("IG_0254","n");
        dismap.put("IG_0255","n");
        dismap.put("IG_0256","n");
        dismap.put("IG_0257","n");
        dismap.put("IG_0258","n");
        dismap.put("IG_0259","n");
        dismap.put("IG_0260","n");

		
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
				
				String clabel = e.getClabel();
				String cvalue = e.getCivalue();
				if("IG_0121".equals(clabel)||"IG_0122".equals(clabel)||"IG_0123".equals(clabel)||"IG_0124".equals(clabel)
						||"IG_0167".equals(clabel)||"IG_0154".equals(clabel)||"IG_0159".equals(clabel)){
					if(StringUtils.isNotEmpty(cvalue)){
						dismap.put("IG_0121","y");
						dismap.put("IG_0122","y");
						dismap.put("IG_0123","y");
						dismap.put("IG_0124","y");
						
						dismap.put("IG_0167","y");
						dismap.put("IG_0154","y");
						dismap.put("IG_0159","y");
					}
				}
				
				if("IG_0125".equals(clabel)||"IG_0126".equals(clabel)||"IG_0127".equals(clabel)||"IG_0128".equals(clabel)
						||"IG_0168".equals(clabel)||"IG_0155".equals(clabel)||"IG_0160".equals(clabel)){
					if(StringUtils.isNotEmpty(cvalue)){
						dismap.put("IG_0125","y");
						dismap.put("IG_0126","y");
						dismap.put("IG_0127","y");
						dismap.put("IG_0128","y");
						
						dismap.put("IG_0168","y");
						dismap.put("IG_0155","y");
						dismap.put("IG_0160","y");
					}
				}
				
				if("IG_0129".equals(clabel)||"IG_0130".equals(clabel)||"IG_0131".equals(clabel)||"IG_0132".equals(clabel)
						||"IG_0169".equals(clabel)||"IG_0156".equals(clabel)||"IG_0161".equals(clabel)){
					if(StringUtils.isNotEmpty(cvalue)){
						dismap.put("IG_0129","y");
						dismap.put("IG_0130","y");
						dismap.put("IG_0131","y");
						dismap.put("IG_0132","y");
						
						dismap.put("IG_0169","y");
						dismap.put("IG_0156","y");
						dismap.put("IG_0161","y");
					}
				}
				
				if("IG_0133".equals(clabel)||"IG_0134".equals(clabel)||"IG_0135".equals(clabel)||"IG_0136".equals(clabel)
						||"IG_0170".equals(clabel)||"IG_0157".equals(clabel)||"IG_0162".equals(clabel)){
					if(StringUtils.isNotEmpty(cvalue)){
						dismap.put("IG_0133","y");
						dismap.put("IG_0134","y");
						dismap.put("IG_0135","y");
						dismap.put("IG_0136","y");
						
						dismap.put("IG_0170","y");
						dismap.put("IG_0157","y");
						dismap.put("IG_0162","y");
					}
				}
				//��6�ʸ���
				if("IG_0191".equals(clabel)||"IG_0192".equals(clabel)||"IG_0193".equals(clabel)||"IG_0194".equals(clabel)
                        ||"IG_0195".equals(clabel)||"IG_0196".equals(clabel)||"IG_0197".equals(clabel)){
                    if(StringUtils.isNotEmpty(cvalue)){
                        dismap.put("IG_0191","y");
                        dismap.put("IG_0192","y");
                        dismap.put("IG_0193","y");
                        dismap.put("IG_0194","y");
                        
                        dismap.put("IG_0195","y");
                        dismap.put("IG_0196","y");
                        dismap.put("IG_0197","y");
                    }
                }
				//��7�ʸ���
                if("IG_0198".equals(clabel)||"IG_0199".equals(clabel)||"IG_0200".equals(clabel)||"IG_0201".equals(clabel)
                        ||"IG_0202".equals(clabel)||"IG_0203".equals(clabel)||"IG_0204".equals(clabel)){
                    if(StringUtils.isNotEmpty(cvalue)){
                        dismap.put("IG_0198","y");
                        dismap.put("IG_0199","y");
                        dismap.put("IG_0200","y");
                        dismap.put("IG_0201","y");
                        
                        dismap.put("IG_0202","y");
                        dismap.put("IG_0203","y");
                        dismap.put("IG_0204","y");
                    }
                }
              //��8�ʸ���
                if("IG_0205".equals(clabel)||"IG_0206".equals(clabel)||"IG_0207".equals(clabel)||"IG_0208".equals(clabel)
                        ||"IG_0209".equals(clabel)||"IG_0210".equals(clabel)||"IG_0211".equals(clabel)){
                    if(StringUtils.isNotEmpty(cvalue)){
                        dismap.put("IG_0205","y");
                        dismap.put("IG_0206","y");
                        dismap.put("IG_0207","y");
                        dismap.put("IG_0208","y");
                        
                        dismap.put("IG_0209","y");
                        dismap.put("IG_0210","y");
                        dismap.put("IG_0211","y");
                    }
                }
              //��9�ʸ���
                if("IG_0212".equals(clabel)||"IG_0213".equals(clabel)||"IG_0214".equals(clabel)||"IG_0215".equals(clabel)
                        ||"IG_0216".equals(clabel)||"IG_0217".equals(clabel)||"IG_0218".equals(clabel)){
                    if(StringUtils.isNotEmpty(cvalue)){
                        dismap.put("IG_0212","y");
                        dismap.put("IG_0213","y");
                        dismap.put("IG_0214","y");
                        dismap.put("IG_0215","y");
                        
                        dismap.put("IG_0216","y");
                        dismap.put("IG_0217","y");
                        dismap.put("IG_0218","y");
                    }
                }
              //��10�ʸ���
                if("IG_0219".equals(clabel)||"IG_0220".equals(clabel)||"IG_0221".equals(clabel)||"IG_0222".equals(clabel)
                        ||"IG_0223".equals(clabel)||"IG_0224".equals(clabel)||"IG_0225".equals(clabel)){
                    if(StringUtils.isNotEmpty(cvalue)){
                        dismap.put("IG_0219","y");
                        dismap.put("IG_0220","y");
                        dismap.put("IG_0221","y");
                        dismap.put("IG_0222","y");
                        
                        dismap.put("IG_0223","y");
                        dismap.put("IG_0224","y");
                        dismap.put("IG_0225","y");
                    }
                }
              //��11�ʸ���
                if("IG_0226".equals(clabel)||"IG_0227".equals(clabel)||"IG_0228".equals(clabel)||"IG_0229".equals(clabel)
                        ||"IG_0230".equals(clabel)||"IG_0231".equals(clabel)||"IG_0232".equals(clabel)){
                    if(StringUtils.isNotEmpty(cvalue)){
                        dismap.put("IG_0226","y");
                        dismap.put("IG_0227","y");
                        dismap.put("IG_0228","y");
                        dismap.put("IG_0229","y");
                        
                        dismap.put("IG_0230","y");
                        dismap.put("IG_0231","y");
                        dismap.put("IG_0232","y");
                    }
                }
              //��12�ʸ���
                if("IG_0233".equals(clabel)||"IG_0234".equals(clabel)||"IG_0235".equals(clabel)||"IG_0236".equals(clabel)
                        ||"IG_0237".equals(clabel)||"IG_0238".equals(clabel)||"IG_0239".equals(clabel)){
                    if(StringUtils.isNotEmpty(cvalue)){
                        dismap.put("IG_0233","y");
                        dismap.put("IG_0234","y");
                        dismap.put("IG_0235","y");
                        dismap.put("IG_0236","y");
                        
                        dismap.put("IG_0237","y");
                        dismap.put("IG_0238","y");
                        dismap.put("IG_0239","y");
                    }
                }
              //��13�ʸ���
                if("IG_0240".equals(clabel)||"IG_0241".equals(clabel)||"IG_0242".equals(clabel)||"IG_0243".equals(clabel)
                        ||"IG_0244".equals(clabel)||"IG_0245".equals(clabel)||"IG_0246".equals(clabel)){
                    if(StringUtils.isNotEmpty(cvalue)){
                        dismap.put("IG_0240","y");
                        dismap.put("IG_0241","y");
                        dismap.put("IG_0242","y");
                        dismap.put("IG_0243","y");
                        
                        dismap.put("IG_0244","y");
                        dismap.put("IG_0245","y");
                        dismap.put("IG_0246","y");
                    }
                }
              //��14�ʸ���
                if("IG_0247".equals(clabel)||"IG_0248".equals(clabel)||"IG_0249".equals(clabel)||"IG_0250".equals(clabel)
                        ||"IG_0251".equals(clabel)||"IG_0252".equals(clabel)||"IG_0253".equals(clabel)){
                    if(StringUtils.isNotEmpty(cvalue)){
                        dismap.put("IG_0247","y");
                        dismap.put("IG_0248","y");
                        dismap.put("IG_0249","y");
                        dismap.put("IG_0250","y");
                        
                        dismap.put("IG_0251","y");
                        dismap.put("IG_0252","y");
                        dismap.put("IG_0253","y");
                    }
                }
              //��15�ʸ���
                if("IG_0254".equals(clabel)||"IG_0255".equals(clabel)||"IG_0256".equals(clabel)||"IG_0257".equals(clabel)
                        ||"IG_0258".equals(clabel)||"IG_0259".equals(clabel)||"IG_0260".equals(clabel)){
                    if(StringUtils.isNotEmpty(cvalue)){
                        dismap.put("IG_0254","y");
                        dismap.put("IG_0255","y");
                        dismap.put("IG_0256","y");
                        dismap.put("IG_0257","y");
                        
                        dismap.put("IG_0258","y");
                        dismap.put("IG_0259","y");
                        dismap.put("IG_0260","y");
                    }
                }
			}
		}
		dto.setDismap(dismap);
		form.setCivalue(civalue);
		form.setEntityItemCivalue(entityItemCivalue);
		form.setDelfile(delfile);
		form.setCivalue_bak(civalue_bak);
		form.setIsUpgrade(isUpgrade);
		dto.setConfigItemVWInfoMap(map);
//		dto.addMessage(new ActionMessage("IGCO10000.I007",totalCount));
		//Ӱ�����XML�趨
		//���IMAGE_FLAGΪtrue�򲻽���XML�Ĵ���
		if(image_flag.equals("true")){
			dto.setImage_flag(true);
		}else {
			dto.setImage_flag(false);
			dto.setPicuXml(createImageXml(entityItemVWInfo.getEiid(), entityItemVWInfo.getEilabel(),
					entityItemVWInfo.getEiname(), entityItemVWInfo.getEidesc(), "1"));
			dto.setPicsXml(createImageXml(entityItemVWInfo.getEiid(), entityItemVWInfo.getEilabel(),
					entityItemVWInfo.getEiname(), entityItemVWInfo.getEidesc(), "2"));
		}
		
		log.debug("========��ͬ������Ϣ�༭������ڻ���������========");
		return dto;
	}
	
	/**
	 * ����Ӱ�����XML
	 * @param eiid ��ͬID
	 * @param eilabel ��ͬ���
	 * @param einame ��ͬ����
	 * @param eidesc ��ͬ˵��
	 * @param operType �������ͣ�1�鿴��2�ϴ�
	 * @return XML
	 */
	private String createImageXml(Integer eiid, String eilabel,
			String einame, String eidesc, String operType) {
		//����XML
		StringBuffer sbf = new StringBuffer();
		sbf.append("<pluginBean>");
		sbf.append("<signType>");
		sbf.append("1");
		sbf.append("</signType>");
		sbf.append("<serviceType>");
		sbf.append(operType);
		sbf.append("</serviceType>");
		sbf.append("<index>");
		sbf.append("<operId>");
		sbf.append(this.codeListUtils.getCodeValue("158", null, null, "5"));
		sbf.append("</operId>");
		sbf.append("<contractId>");
		sbf.append(eiid);
		sbf.append("</contractId>");
		sbf.append("<contractLabel>");
		sbf.append(StringUtils.isEmpty(eilabel) ? "" : eilabel.trim());
		sbf.append("</contractLabel>");
		sbf.append("<contractName>");
		sbf.append(StringUtils.isEmpty(einame) ? "" : einame.trim());
		sbf.append("</contractName>");
		sbf.append("<contractDesc>");
		sbf.append(StringUtils.isEmpty(eidesc) ? "" : eidesc.trim());
		sbf.append("</contractDesc>");
		sbf.append("</index>");
		sbf.append("<fileType>");	
		sbf.append(this.codeListUtils.getCodeValue("158", null, null, "2"));
		sbf.append("</fileType>");
		sbf.append("</pluginBean>");
		//���ɼ��ܺ��XML
		StringBuffer xml = new StringBuffer();
		xml.append(this.codeListUtils.getCodeValue("158", null, null, "1"));
		xml.append(XML_HEADER);
		log.debug(sbf.toString());
		try {
			xml.append(URLEncoder.encode(sbf.toString(), "UTF-8"));
			xml.append("&nocache=");
			xml.append(new Date());
		} catch (UnsupportedEncodingException e) {
			log.error("�쳣��", e);
		}
		return xml.toString();
	}
	
	/**
	 * ��ͬ������Ϣ�༭����
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public IGASM04DTO editEntityItemAction(IGASM04DTO dto) throws BLException, FileNotFoundException, IOException {
		log.debug("========��ͬ������Ϣ�༭����ʼ========");
		//�汾������
		IGASM0404Form form = dto.getIgasm0404Form();
		
		//��ͬ������Ϣ����
		SOC0118TB entityItem = (SOC0118TB) this.soc0118BL.searchEntityItemByKey(Integer.parseInt(form.getEiid()));
		// ȡ�ð汾�Ƿ�������ʶ
		String ident = form.getIdent();
		if(StringUtils.isEmpty(ident)){
			ident = IGASM04BLImpl.SAVE_VERSION;
		}
		// �汾�ų�ʼ��
		int version = 1;
		boolean versonFlag = false;
		// �ж��Ƿ������汾��
		// =====================>> �޸� start
		if (IGASM04BLImpl.SAVE_VERSION_UP.equals(ident)) { // �����汾��
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
		} else if (IGASM04BLImpl.SAVE_VERSION.equals(ident)) { // �������汾��

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
		
		//��ͬ״̬
//		entityItem.setEistatus(form.getEistatus());
		//��ͬ�汾
		entityItem.setEiversion(version);
		
		//��ͬ˵��
		entityItem.setEidesc(form.getEidesc());

		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		
		//����ʱ��
		entityItem.setEiupdtime(datetime);
		
		this.soc0118BL.updateEntityItem(entityItem);
		//=======���¹�ϵ��ʼ========
		if(version ==1&&versonFlag){
			SOC0119SearchCondImpl eircond1 = new SOC0119SearchCondImpl();
			//ɾ����ʶ
			eircond1.setDeleteflag("0");
			//����ʲ���صĹ�ϵ��
			eircond1.setEirrelationcode(IGASM04BLImpl.EIRRELATIONCODE);
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
		
		//��ͬ������Ϣ����
		if (form.getCiid() != null && form.getCiid().length > 0 ) {
			
			for( int i=0 ; i < form.getCiid().length; i++ ){
				SOC0107TB configItem = new SOC0107TB();
				//��ͬID
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
					if (IGASM04BLImpl.SAVE_VERSION_UP.equals(ident)) { // �����汾��

						configItem = (SOC0107TB) this.soc0107BL.registSOC0107(configItem);

					} else if (IGASM04BLImpl.SAVE_VERSION.equals(ident)) { // �������汾��
					
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
						//��ͬID
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
	
		dto.addMessage(new ActionMessage("IGCO10000.I005","��ͬ������Ϣ"));
		
		log.debug("========��ͬ������Ϣ�༭��������========");
		
		return dto;
	}

	/**
	 * ��ͬ������Ϣ��ʷ��¼������ڻ�����
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO initIGASM0405Action(IGASM04DTO dto) throws BLException {
		log.debug("========��ͬ������Ϣ��ʷ��¼������ڻ�����ʼ========");
		
		//��ͬ��Ϣ����
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(
				dto.getIgasm0405Form().getEiid());
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","��ͬ");
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
		
		if (StringUtils.isEmpty(dto.getIgasm0405Form().getCiversion()+"")) {
			dto.getIgasm0405Form().setCiversion(String.valueOf(entityItemVWInfo.getEiversion()));
		}
		//��ȡ��ʷ�汾����ʱ��
		dto.setConfigItemVersionTime(this.soc0118BL.searchVersionUpdateTime(dto.getIgasm0405Form().getEiid()));
		
		//�жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(), entityItemVWInfo);

		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}else{
			dto.setFlag(flag);
		}
		
		log.debug("========��ͬ������Ϣ��ʷ��¼������ڻ���������========");
		return dto;
	}

	/**
	 * ��ͬ��ϵ��������ڻ�����
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO initIGASM0406Action(IGASM04DTO dto) throws BLException {
		log.debug("========��ͬ��ϵ��������ڻ�����ʼ========");
		
		//��ͬ��Ϣ����
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(
				Integer.parseInt(dto.getIgasm0406Form().getEiid()));
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","��ͬ");
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
		if(dto.getIgasm0406Form().getEiid()!=null){
		parcond.setPareiid(Integer.parseInt(dto.getIgasm0406Form().getEiid()));}
		parcond.setParversion(entityItemVWInfo.getEiversion());
		parcond.setParsmallversion(entityItemVWInfo.getEismallversion());
		parcond.setDeleteflag("0");
		
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
		//��ͬ��ϵ��Ϣ��ѯ����ȡ�� 
		int totalCount = this.soc0119BL.getEntityItemRelationSearchCount(parcond);
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========��ͬ��ϵ��Ϣ��ѯ���ݼ�������========");
			//��ͬ��ϵ��Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		if ( totalCount>0 ) {
			//��ͬ��ϵ��Ϣȫ������
			List<SOC0119Info> parEntityItemRelationList = 
				this.soc0119BL.searchMaxEntityItemRelation(parcond);
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
		SOC0119SearchCondImpl cldcond = new SOC0119SearchCondImpl();
		if((dto.getIgasm0406Form().getEiid())!=null){
		cldcond.setCldeiid(Integer.parseInt(dto.getIgasm0406Form().getEiid()));}
		cldcond.setCldversion(entityItemVWInfo.getEiversion());
		cldcond.setCldsmallversion(entityItemVWInfo.getEismallversion());
		cldcond.setDeleteflag("0");
		
		//��ͬ��ϵ��Ϣ��ѯ����ȡ�� 
		totalCount = this.soc0119BL.getEntityItemRelationSearchCount(cldcond);
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========��ͬ��ϵ��Ϣ��ѯ���ݼ�������========");
			//��ͬ��ϵ��Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//��ͬ��ϵ��Ϣȫ������
		List<SOC0119Info> cldEntityItemRelationList = 
			this.soc0119BL.searchMaxEntityItemRelation(cldcond);
		
		dto.setParCount(dto.getParCount()+cldEntityItemRelationList.size());
//		dto.addMessage(new ActionMessage("IGCO10000.I007",dto.getParCount()));
		for(SOC0119Info e : cldEntityItemRelationList){
			String key = e.getEirrelationcode().split("-")[0];
			String eirrelationcode = e.getEirrelationcode();
			String ecategory = e.getCldEntityItemVW().getEcategory();
			if(!"-".equals(eirrelationcode.replaceAll(ecategory, ""))){
				key = eirrelationcode.replaceAll(ecategory, "").replaceAll("-", "");
			}
			if(!parmap.containsKey(key)){
				parmap.put(key, new ArrayList<SOC0119Info>());
			}
			((SOC0119TB)e).setParflag("1");
			parmap.get(key).add(e);
		}
		if(parmap.size()==0){
			parmap = null;
		}
		dto.setParEntityItemRelationMap(parmap);

		
		log.debug("========��ͬ��ϵ��������ڻ���������========");
		return dto;
	}
	
	/**
	 * ��ͬ��ϵɾ������
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO deleteEntityItemRelationAction(IGASM04DTO dto) throws BLException {
		log.debug("========��ͬ��ϵɾ������ʼ========");
		
		for( int i=0;i<dto.getDeleteEntityItemRelation().length;i++ ){
			String eirid = dto.getDeleteEntityItemRelation()[i];
			
			SOC0119Info entityItemRelation = 
				this.soc0119BL.searchEntityItemRelationByKey(Integer.parseInt(eirid));
			
			if (entityItemRelation == null){
				throw new BLException("IGCO10000.E004","ɾ�������ͬ��ϵ");
			}

			this.soc0119BL.deleteEntityItemRelation(entityItemRelation);
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I006","��ͬ��ϵ��Ϣ"));

		log.debug("========��ͬ��ϵɾ����������========");
		return dto;
	}

	/**
	 * ��ͬ��ϵ�ǼǴ���
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO insertEntityItemRelationAction(IGASM04DTO dto) throws BLException {
		log.debug("========��ͬ��ϵ�ǼǴ���ʼ========");
		
		IGASM0407Form form = dto.getIgasm0407Form();
		
		//��ͬID���ӣ�ȡ��
		SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
		
		cond.setElabel(form.getElabel());
		cond.setEilabel(form.getEilabel());
		
		List<SOC0124Info> entityItemVWList = this.soc0118BL.searchEntityItemVW(cond, 0, 0);
		
		if ( entityItemVWList==null || entityItemVWList.size() == 0 ) {
			throw new BLException("IGCO10000.E004","(�ʲ����=" + form.getElabel() + ",��ͬ���=" 
					+ form.getEilabel() + ")��ͬ");
		}
		
		form.setCldeiid(entityItemVWList.get(0).getEiid());
		form.setCldeid(entityItemVWList.get(0).getEid());
		form.setCldsmallversion(entityItemVWList.get(0).getEismallversion());
		form.setCldversion(entityItemVWList.get(0).getEiversion());
		
		//��ͬID�������ͣ��ӣ����
		if (form.getPareiid().intValue() == form.getCldeiid().intValue()) {
			//��ͬID������= ���ӣ�
			throw new BLException(BLErrorType.ENTITY_ITEM_RELATION_ERROR,
					"IGCO10000.E012","��ͬ");
		}
		
		//����ʱ���趨
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

		form.setEirupdtime(datetime);
		
		//�ʲ���ϵ�Ǽ�
		SOC0119Info ret = 
			this.soc0119BL.registEntityItemRelation(dto.getIgasm0407Form());
		
		dto.setEntityItemRelation(ret);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "��ͬ��ϵ��Ϣ") );
		
		log.debug("========��ͬ��ϵ�ǼǴ�������========");
		return dto;
	}
	
	/**
	 * ��ͬ��ϵ�༭������ڻ�����
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO initIGASM0407Action(IGASM04DTO dto) throws BLException {
		log.debug("========��ͬ��ϵ�༭������ڻ�����ʼ========");
		
		IGASM0407Form form = dto.getIgasm0407Form();
		SOC0119TB ret = 		
			(SOC0119TB) this.soc0119BL.searchEntityItemRelationByKey(
				form.getEirid());
		
		if ( ret == null ){
			throw new BLException("IGCO10000.E004","�༭�����ͬ��ϵ");
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
		form.setEiname(ret.getCldEntityItemVW().getEiname());
		form.setTempeirrelation(ret.getEirrelation()+"#"+ret.getEirrelationcode());
		form.setMode("1");
		
		log.debug("========��ͬ��ϵ�༭������ڻ���������========");
		return dto;
	}

	/**
	 * ��ͬ��ϵ���������
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO updateEntityItemRelationAction(IGASM04DTO dto) throws BLException {
		log.debug("========��ͬ��ϵ���������ʼ========");
		IGASM0407Form form = dto.getIgasm0407Form();

		//����ʱ���趨
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

		form.setEirupdtime(datetime);
		
		this.soc0119BL.updateEntityItemRelation(form);

		dto.addMessage(new ActionMessage( "IGCO10000.I005", "��ͬ��ϵ��Ϣ") );

		log.debug("========��ͬ��ϵ�������������========");
		return dto;
	}
	
	/**
	 *	��ȡ��ͬ������ϵ����
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO searchRelationListAction(IGASM04DTO dto) throws BLException {
		log.debug("========��ȡ��ͬ������ϵ����ʼ========");
		List<LabelValueBean> list = this.codeDetailBL.searchLabelValueBeanList(CommonDefineUtils.ENTIY_CATEGORY_CONTRACT,CodeDefine.getCodeDefine("ENTITY_ITEM_RELATION_CODE").getCcid());
		dto.setRelationList(list);
		log.debug("========��ȡ��ͬ������ϵ��������========");
		return dto;
	}
	
	/**
	 *��ͬ��Ϣ�޸ĳ�����ʾ����
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO initEntityItem(IGASM04DTO dto) throws BLException {

		log.debug("========��ͬ��Ϣ�༭���������ʾ����ʼ========");
		
		IGASM0412Form form = dto.getIgasm0412Form();
		
		//��ʾ���ʲ���Ϣȡ��
		SOC0124Info entityItem = this.soc0118BL.searchEntityItemVWByKey(form.getEiid());
		
		if ( entityItem == null ){
			throw new BLException("IGCO10000.E004","�����ͬ����");
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
		boolean isRoleManager = this.userRoleBL.checkRoleManagerByType(dto.getUser().getUserid(), EntityCategory.ROLE_TYPE_CONTRACT);
		form.setRoleManager(isRoleManager);
		form.setPermission(permission);
		
		dto.setIgasm0412Form(form);
		
		//dto.addMessage(new ActionMessage("IGCO10000.I001","��ͬ������Ϣ"));
		if(!permission) {
			dto.addMessage(new ActionMessage("IGCO10000.E023","�޸�"));
		}
		log.debug("========��ͬ��Ϣ�༭���������ʾ��������========");
		return dto;
	}
	/**
	 *��ͬ��Ϣ�޸Ĵ���
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO updateEntityItem(IGASM04DTO dto) throws BLException {
		
		log.debug("========��ͬ��Ϣ�༭���������ʾ����ʼ========");
		
		IGASM0412Form form = dto.getIgasm0412Form();
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
		dto.addMessage(new ActionMessage("IGCO10000.I005","��ͬ������Ϣ"));
		log.debug("========��ͬ��Ϣ�༭���������ʾ��������========");
		return dto;
	}
	
	/**
	 * ��ȡ��ͬ������ֵ
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO searchEntityItemLableAction(IGASM04DTO dto) throws BLException {
		
		log.debug("========��ȡ��ͬ������ֵ����ʼ========");
		
//		IGASM0402Form form = dto.getIgasm0402Form();
//		
//		SOC0118SearchCondImpl cond = new SOC0118SearchCondImpl();
//		
//		cond.setEilabel(CommonDefineUtils.ENTIY_CATEGORY_CONTRACT_KEY + IGStringUtils.getCurrentYear().substring(2));
//		
//		String eilabel = this.soc0118BL.searchNextEntityItemLable(cond);
//		
//		form.setEilabel(eilabel);
		
		log.debug("========��ȡ��ͬ������ֵ��������========");
		return dto;
	}
	
	/**
	 * �жϵ�½�û��Ƿ��Ǻ�ͬ�ʲ������ɫ������
	 * 
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 * @throws BLException 
	 */
	public IGASM04DTO checkEntityItemDomain(IGASM04DTO dto) throws BLException{
		boolean isRoleManager = this.userRoleBL.checkRoleManagerByType(dto.getUser().getUserid(), EntityCategory.ROLE_TYPE_CONTRACT);
		
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
			entityCond.setEsyscoding(CommonDefineUtils.ENTIY_CATEGORY_CONTRACT_SYSCODING);
			List<SOC0117Info> entity = this.soc0117BL.searchEntity(entityCond, 0, 0);
			
			if(entity.size() != 1) {
				throw new BLException("IGCO10000.E004","��ͬģ��");
			} else {
				dto.setEname(entity.get(0).getEname());
				dto.setEsyscoding(entity.get(0).getEsyscoding());
			}
		}
		List<LabelValueBean> selectList = this.soc0151BL.searchLabelValueBeanList("039");
		dto.setSelectList(selectList);
		dto.setFlag(isRoleManager);
		
		return dto;
	}
	
	/**
	 * Ӧ����Ǽǲ�ѯ����(��ӦӦ����Ǽǲ�ѯ)
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO searchEntityItemCompactVWAction(IGASM04DTO dto) throws BLException {
		log.debug("========��ͬӦ�����ѯ��ʼ========");
		
		//��ͬ��Ϣ��ѯ����ȡ�� 
		//int totalCount = this.ig499BL.getSearchCount(dto.getEntityItemCompactVWSearchCond());
		
//		if (totalCount == 0) {
//			log.debug("========��ͬӦ�����ѯ���ݲ�����========");
//			//��ͬ��Ϣ��ѯ���ݲ�����
//			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
//			return dto;
//		} 
//		
//		if ( totalCount > dto.getMaxSearchCount() ) {
//			log.debug("========��ͬӦ�����ѯ���ݼ�������========");
//			//��ͬ��Ϣ��ѯ���ݼ�������
//			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
//			return dto;
//		}

		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();

		//���к�ͬ��Ϣȡ��
		List<IG499Info> entityItemCompactVWInfoListA = this.ig499BL.searchIG499Info(dto.getEntityItemCompactVWSearchCond());
		
		//��ͬ����δ��ɵ���Ϣȡ��
		List<IG499Info> entityItemCompactVWInfoListB=new ArrayList<IG499Info>();
		for (IG499Info entityItemCompactVWInfo : entityItemCompactVWInfoListA) {
			if(entityItemCompactVWInfo.getEiversion()!=0){
				entityItemCompactVWInfoListB.add(entityItemCompactVWInfo);
			}
		}
		int totalCount=entityItemCompactVWInfoListB.size();
		if (totalCount == 0) {
			log.debug("========��ͬӦ�����ѯ���ݲ�����========");
			//��ͬ��Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========��ͬӦ�����ѯ���ݼ�������========");
			//��ͬ��Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		
		//��ǰҳ��ͬ��Ϣȡ��
		List<IG499Info> entityItemCompactVWInfoList=new ArrayList<IG499Info>();
		int fromCount = pDto.getFromCount();
		int pageDispCount = pDto.getPageDispCount();
		for (int i = fromCount; i < entityItemCompactVWInfoListB.size()&&i<fromCount+pageDispCount; i++) {
			entityItemCompactVWInfoList.add(entityItemCompactVWInfoListB.get(i));
		}
		
		pDto.setTotalCount(totalCount);
		
		dto.setEntityItemCompactVWInfoList(entityItemCompactVWInfoList);

		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========��ͬӦ�����ѯ����========");
		return dto;
	}
	/**
	 * Ӧ����Ǽǲ�ѯ����2(��ӦӦ�����ѯ)
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO searchEntityItemCompactVW2Action(IGASM04DTO dto) throws BLException {
		log.debug("========��ͬӦ�����ѯ��ʼ========");
		
		//ǿ��Ĭ��ʱ����ֹNULLֵ����
		if(dto.getEntityItemCompactVWSearchCond().getDatetime()==null){
			//�����²�ѯ����
			IG499SearchCondImpl newcond=new IG499SearchCondImpl();
			//������������
			newcond.setDatetime(IGStringUtils.getCurrentDate());
			//����dto
			dto.setEntityItemCompactVWSearchCond(newcond);
		}

		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();

		//��ǰҳ��ͬ��Ϣȡ��
		List<IG499Info> entityItemCompactVWInfoList = this.ig499BL.findImprestByCond(dto.getEntityItemCompactVWSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		
		//��ͬ��Ϣ��ѯ����ȡ�� 
		//int totalCount = this.ig499BL.getSearchImprestCount(dto.getEntityItemCompactVWSearchCond());
		//��ͬ��Ϣ��ѯ����ͨ��listȡ��
		int totalCount = entityItemCompactVWInfoList.size();
		
		if (totalCount == 0) {
			log.debug("========��ͬӦ�����ѯ���ݲ�����========");
			//��ͬ��Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========��ͬӦ�����ѯ���ݼ�������========");
			//��ͬ��Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		
		pDto.setTotalCount(totalCount);
		
		dto.setEntityItemCompactVWInfoList(entityItemCompactVWInfoList);

		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========��ͬӦ�����ѯ����========");
		return dto;
	}


	/**
	 * ��ͬ���������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGASM04DTO intiIGASM0422Action(IGASM04DTO dto) throws BLException {
		//����������������������
		List<IG499Info> entityItemCompactVWInfoList = this.ig499BL.findImprestByCond(dto.getEntityItemCompactVWSearchCond(), 0, 0);
		//�������ݴ���dto
		dto.setReportDataList(entityItemCompactVWInfoList);
		return dto;
	}

	/**
	 * ��ͬ����Ǽǳ�����ʾ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGASM04DTO initIGASM0421Action(IGASM04DTO dto) throws BLException {
		log.debug("========��ͬ����Ǽǻ�����ڻ�����ʼ========");
		//Formȡ��
		IGASM0421Form form = dto.getIgasm0421Form();
		//��ȡ��Ϣ��Դ�ļ���ʶ
		String image_flag = resources.getMessage("IMAGE_FLAG");
		
		IG499SearchCondImpl eCond=new IG499SearchCondImpl();
		eCond.setEiid(form.getEiid().toString());
		//��ͬ��Ϣ����
		List<IG499Info> entityItemCompactVWInfoList = this.ig499BL.searchIG499Info(eCond);
		
		if (entityItemCompactVWInfoList == null ) {
			throw new BLException("IGCO10000.E004","��ͬ");
		}
		//��ͬ���������
		String eiorgsyscoding = entityItemCompactVWInfoList.get(0).getEiorgsyscoding();
		form.setEiorgsyscoding(eiorgsyscoding);
		form.setEsyscoding_q(entityItemCompactVWInfoList.get(0).getEsyscoding());
		//���������
		if(!StringUtils.isEmpty(eiorgsyscoding)){
			OrganizationSearchCondImpl OrgCond = new OrganizationSearchCondImpl();
			OrgCond.setOrgsyscoding(eiorgsyscoding);
			//���ݻ���������ѯ
			List<Organization> orgList = this.organizationBL.searchOrganization(OrgCond, 0, 0);
			for (int i = 0; i < orgList.size(); i++) {
				dto.setEiorgname(orgList.get(0).getOrgname());
			}
		}
		dto.setEntityItemCompactVWInfo(entityItemCompactVWInfoList.get(0));
		
		String facilitator = entityItemCompactVWInfoList.get(0).getFacilitator();//��������Ϣ
		if(StringUtils.isNotEmpty(facilitator)){
			Integer eiid = Integer.parseInt(facilitator.substring(facilitator.indexOf("(")+1, facilitator.length()-1));//������eiid
			
			SOC0119SearchCondImpl ig313cond=new SOC0119SearchCondImpl();
			ig313cond.setPareiid(Integer.parseInt(form.getEiid()));
			ig313cond.setCldeiid(eiid);
			ig313cond.setParversion(entityItemCompactVWInfoList.get(0).getEiversion());//��ͬ�汾
			List<SOC0119Info> ig313Info = soc0119BL.searchEntityItemRelation(ig313cond);
			if(ig313Info!=null&&ig313Info.size()>0){
				Integer cldversion = ig313Info.get(0).getCldversion();//�����̰汾
				SOC0107SearchCondImpl cond=new SOC0107SearchCondImpl();
				cond.setEiid(String.valueOf(eiid));
				cond.setCiversion(String.valueOf(cldversion));
				List<SOC0107Info> ig800InfoList = soc0107BL.searchSOC0107(cond);
				for (SOC0107Info info : ig800InfoList) {
//					int cid = Integer.parseInt(info.getCid());
//					if(cid==1736){//������
//						dto.setKaihuhang(info.getCivalue());
//					}
//					if(cid==1737){//�����˺�
//						dto.setKaihuzhanghao(info.getCivalue());
//					}
//					if(cid==1738){//��������
//						dto.setKaihumingcheng(info.getCivalue());
//					}
					String cid = info.getCid();
					if("CI040000000014".equals(cid)){//������
						dto.setKaihuhang(info.getCivalue());
					}
					if("CI040000000015".equals(cid)){//�����˺�
						dto.setKaihuzhanghao(info.getCivalue());
					}
					if("CI040000000016".equals(cid)){//��������
						dto.setKaihumingcheng(info.getCivalue());
					}
				}
			}
		}
		
		//�жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
//		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(), entityItemCompactVWInfoList.get(0));

//		if(!flag) {
//			dto.addMessage(new ActionMessage("IGCO10000.E022"));
//			dto.setFlag(flag);
//			return dto;
//		}else{
//			dto.setFlag(flag);
//		}
		
		
		//��ͬ������Ϣ��ѯ����ȡ�� 
		int totalCount = this.soc0107BL.getConfigItemVWSearchCount(form);
		
		if (totalCount == 0) {
			log.debug("========��ͬ������Ϣ��ѯ���ݲ�����========");
			//��ͬ������Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I007",0));
			return dto;
		} 
		
		if (totalCount > dto.getMaxSearchCount() ) {
			log.debug("========��ͬ������Ϣ��ѯ���ݼ�������========");
			//��ͬ������Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//��ͬ������Ϣȫ����ѯ
		List<SOC0129Info> configItemVWInfoList = this.soc0107BL.searchConfigItemVW(
				form, 0, 0);
		
		//������ں�ͬ������Ϣ
		if(configItemVWInfoList != null && configItemVWInfoList.size() > 0){
			form.setBtnFlag1(false);
			form.setBtnFlag2(false);
			form.setBtnFlag3(false);
			form.setBtnFlag4(false);
			form.setBtnFlag5(false);
			form.setBtnFlag6(false);
            form.setBtnFlag7(false);
            form.setBtnFlag8(false);
            form.setBtnFlag9(false);
            form.setBtnFlag10(false);
            form.setBtnFlag11(false);
            form.setBtnFlag12(false);
            form.setBtnFlag13(false);
            form.setBtnFlag14(false);
            form.setBtnFlag15(false);
			for(SOC0129Info configItemVWInfo:configItemVWInfoList){
				getCompactInfo(configItemVWInfo,form);
			}
			String actualmoney1 = form.getActualmoney1();
			String actualmoney2 = form.getActualmoney2();
			String actualmoney3 = form.getActualmoney3();
			String actualmoney4 = form.getActualmoney4();
			String actualmoney5 = form.getActualmoney5();
			String actualmoney6 = form.getActualmoney6();
            String actualmoney7 = form.getActualmoney7();
            String actualmoney8 = form.getActualmoney8();
            String actualmoney9 = form.getActualmoney9();
            String actualmoney10 = form.getActualmoney10();
            String actualmoney11 = form.getActualmoney11();
            String actualmoney12 = form.getActualmoney12();
            String actualmoney13 = form.getActualmoney13();
            String actualmoney14 = form.getActualmoney14();
            String actualmoney15 = form.getActualmoney15();
			if(StringUtils.isEmpty(actualmoney1)){
				form.setBtnFlag1(false);
			}
			if(StringUtils.isEmpty(actualmoney2)){
				form.setBtnFlag2(false);
			}
			if(StringUtils.isEmpty(actualmoney3)){
				form.setBtnFlag3(false);
			}
			if(StringUtils.isEmpty(actualmoney4)){
				form.setBtnFlag4(false);
			}
			if(StringUtils.isEmpty(actualmoney5)){
				form.setBtnFlag5(false);
			}
			if(StringUtils.isEmpty(actualmoney6)){
                form.setBtnFlag6(false);
            }
            if(StringUtils.isEmpty(actualmoney7)){
                form.setBtnFlag7(false);
            }
            if(StringUtils.isEmpty(actualmoney8)){
                form.setBtnFlag8(false);
            }
            if(StringUtils.isEmpty(actualmoney9)){
                form.setBtnFlag9(false);
            }
            if(StringUtils.isEmpty(actualmoney10)){
                form.setBtnFlag10(false);
            }
            if(StringUtils.isEmpty(actualmoney11)){
                form.setBtnFlag11(false);
            }
            if(StringUtils.isEmpty(actualmoney12)){
                form.setBtnFlag12(false);
            }
            if(StringUtils.isEmpty(actualmoney13)){
                form.setBtnFlag13(false);
            }
            if(StringUtils.isEmpty(actualmoney14)){
                form.setBtnFlag14(false);
            }
            if(StringUtils.isEmpty(actualmoney15)){
                form.setBtnFlag15(false);
            }
		}
		
		//Ӱ�����XML�趨
		if(image_flag.equals("true")){
			dto.setImage_flag(true);
		}else {
			dto.setImage_flag(false);
			dto.setPicuXml(createImageXml(dto.getEntityItemCompactVWInfo().getEiid(),
					dto.getEntityItemCompactVWInfo().getEilabel(),
					dto.getEntityItemCompactVWInfo().getEiname(),
					dto.getEntityItemCompactVWInfo().getEidesc(), "1"));
			dto.setPicsXml(createImageXml(dto.getEntityItemCompactVWInfo().getEiid(),
					dto.getEntityItemCompactVWInfo().getEilabel(),
					dto.getEntityItemCompactVWInfo().getEiname(),
					dto.getEntityItemCompactVWInfo().getEidesc(), "2"));
		}
		log.debug("========��ͬ����Ǽǻ�����ڻ���������========");
		return dto;
	}
	
	/**
	 * ��ȡ��ͬ������Ϣ
	 * @param configItemVWInfo
	 * @param form
	 */
	public void getCompactInfo(SOC0129Info configItemVWInfo,IGASM0421Form form){
		String civalue = configItemVWInfo.getCivalue();
		//��һ�ʸ����
		if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY1.equals(configItemVWInfo.getClabel())){
			form.setActualmoney1(configItemVWInfo.getCivalue());
			if(StringUtils.isEmpty(civalue)){
				form.setBtnFlag1(true);
			}
			//Ӱ�񼯳�
			String eiid = configItemVWInfo.getEiid();
			String cid = configItemVWInfo.getCid();
			form.setContractId1(eiid+"_"+cid);
			String clabel = configItemVWInfo.getEilabel();
			form.setContractLabel1(clabel);
			String cname = configItemVWInfo.getCname();
			form.setContractName1(configItemVWInfo.getEiname()+"_"+cname);
		}
		//��һ��Ӧ����
		if(CommonDefineUtils.ENTIY_COMPACT_EXPECTDAY1.equals(configItemVWInfo.getClabel())){
			form.setExpectday1(configItemVWInfo.getCivalue());
			if(StringUtils.isEmpty(civalue)){
				form.setBtnFlag1(true);
			}
		}
		//��һ��ʵ����
		if(CommonDefineUtils.ENTIY_COMPACT_ACTUALDAY1.equals(configItemVWInfo.getClabel())){
			form.setActualday1(configItemVWInfo.getCivalue());
			if(StringUtils.isEmpty(civalue)){
				form.setBtnFlag1(true);
			}
		}
		//��Ʊ˵��
		if(CommonDefineUtils.ENTIY_COMPACT_INVOICEEXPLAIN1.equals(configItemVWInfo.getClabel())){
			form.setInvoiceexplain1(configItemVWInfo.getCivalue());
			form.setContractDesc1(configItemVWInfo.getCivalue());
		}
		//�ڶ��ʸ����
		if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY2.equals(configItemVWInfo.getClabel())){
			form.setActualmoney2(configItemVWInfo.getCivalue());
			if(StringUtils.isEmpty(civalue)){
				form.setBtnFlag2(true);
			}
			//Ӱ�񼯳�
			String eiid = configItemVWInfo.getEiid();
			String cid = configItemVWInfo.getCid();
			form.setContractId2(eiid+"_"+cid);
			String clabel = configItemVWInfo.getEilabel();
			form.setContractLabel2(clabel);
			String cname = configItemVWInfo.getCname();
			form.setContractName2(configItemVWInfo.getEiname()+"_"+cname);
		}
		//�ڶ���Ӧ����
		if(CommonDefineUtils.ENTIY_COMPACT_EXPECTDAY2.equals(configItemVWInfo.getClabel())){
			form.setExpectday2(configItemVWInfo.getCivalue());
			if(StringUtils.isEmpty(civalue)){
				form.setBtnFlag2(true);
			}
		}
		//�ڶ���ʵ����
		if(CommonDefineUtils.ENTIY_COMPACT_ACTUALDAY2.equals(configItemVWInfo.getClabel())){
			form.setActualday2(configItemVWInfo.getCivalue());
			if(StringUtils.isEmpty(civalue)){
				form.setBtnFlag2(true);
			}
		}
		//��Ʊ˵��
		if(CommonDefineUtils.ENTIY_COMPACT_INVOICEEXPLAIN2.equals(configItemVWInfo.getClabel())){
			form.setInvoiceexplain2(configItemVWInfo.getCivalue());
			form.setContractDesc2(configItemVWInfo.getCivalue());
		}
		//�����ʸ����
		if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY3.equals(configItemVWInfo.getClabel())){
			form.setActualmoney3(configItemVWInfo.getCivalue());
			if(StringUtils.isEmpty(civalue)){
				form.setBtnFlag3(true);
			}
			//Ӱ�񼯳�
			String eiid = configItemVWInfo.getEiid();
			String cid = configItemVWInfo.getCid();
			form.setContractId3(eiid+"_"+cid);
			String clabel = configItemVWInfo.getEilabel();
			form.setContractLabel3(clabel);
			String cname = configItemVWInfo.getCname();
			form.setContractName3(configItemVWInfo.getEiname()+"_"+cname);
		}
		//������Ӧ����
		if(CommonDefineUtils.ENTIY_COMPACT_EXPECTDAY3.equals(configItemVWInfo.getClabel())){
			form.setExpectday3(configItemVWInfo.getCivalue());
			if(StringUtils.isEmpty(civalue)){
				form.setBtnFlag3(true);
			}
		}
		//������ʵ����
		if(CommonDefineUtils.ENTIY_COMPACT_ACTUALDAY3.equals(configItemVWInfo.getClabel())){
			form.setActualday3(configItemVWInfo.getCivalue());
			if(StringUtils.isEmpty(civalue)){
				form.setBtnFlag3(true);
			}
		}
		//��Ʊ˵��
		if(CommonDefineUtils.ENTIY_COMPACT_INVOICEEXPLAIN3.equals(configItemVWInfo.getClabel())){
			form.setInvoiceexplain3(configItemVWInfo.getCivalue());
			form.setContractDesc3(configItemVWInfo.getCivalue());
		}
		//���ıʸ����
		if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY4.equals(configItemVWInfo.getClabel())){
			form.setActualmoney4(configItemVWInfo.getCivalue());
			if(StringUtils.isEmpty(civalue)){
				form.setBtnFlag4(true);
			}
			//Ӱ�񼯳�
			String eiid = configItemVWInfo.getEiid();
			String cid = configItemVWInfo.getCid();
			form.setContractId4(eiid+"_"+cid);
			String clabel = configItemVWInfo.getEilabel();
			form.setContractLabel4(clabel);
			String cname = configItemVWInfo.getCname();
			form.setContractName4(configItemVWInfo.getEiname()+"_"+cname);
		}
		//���ı�Ӧ����
		if(CommonDefineUtils.ENTIY_COMPACT_EXPECTDAY4.equals(configItemVWInfo.getClabel())){
			form.setExpectday4(configItemVWInfo.getCivalue());
			if(StringUtils.isEmpty(civalue)){
				form.setBtnFlag4(true);
			}
		}
		//���ı�ʵ����
		if(CommonDefineUtils.ENTIY_COMPACT_ACTUALDAY4.equals(configItemVWInfo.getClabel())){
			form.setActualday4(configItemVWInfo.getCivalue());
			if(StringUtils.isEmpty(civalue)){
				form.setBtnFlag4(true);
			}
		}
		//��Ʊ˵��
		if(CommonDefineUtils.ENTIY_COMPACT_INVOICEEXPLAIN4.equals(configItemVWInfo.getClabel())){
			form.setInvoiceexplain4(configItemVWInfo.getCivalue());
			form.setContractDesc4(configItemVWInfo.getCivalue());
		}
		//����ʸ����
		if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY5.equals(configItemVWInfo.getClabel())){
			form.setActualmoney5(configItemVWInfo.getCivalue());
			if(StringUtils.isEmpty(civalue)){
				form.setBtnFlag5(true);
			}
			//Ӱ�񼯳�
			String eiid = configItemVWInfo.getEiid();
			String cid = configItemVWInfo.getCid();
			form.setContractId5(eiid+"_"+cid);
			String clabel = configItemVWInfo.getEilabel();
			form.setContractLabel5(clabel);
			String cname = configItemVWInfo.getCname();
			form.setContractName5(configItemVWInfo.getEiname()+"_"+cname);
		}
		//�����Ӧ����
		if(CommonDefineUtils.ENTIY_COMPACT_EXPECTDAY5.equals(configItemVWInfo.getClabel())){
			form.setExpectday5(configItemVWInfo.getCivalue());
			if(StringUtils.isEmpty(civalue)){
				form.setBtnFlag5(true);
			}
		}
		//�����ʵ����
		if(CommonDefineUtils.ENTIY_COMPACT_ACTUALDAY5.equals(configItemVWInfo.getClabel())){
			form.setActualday5(configItemVWInfo.getCivalue());
			if(StringUtils.isEmpty(civalue)){
				form.setBtnFlag5(true);
			}
		}
		//��Ʊ˵��
		if(CommonDefineUtils.ENTIY_COMPACT_INVOICEEXPLAIN5.equals(configItemVWInfo.getClabel())){
			form.setInvoiceexplain5(configItemVWInfo.getCivalue());
			form.setContractDesc5(configItemVWInfo.getCivalue());
		}
		
		////////////////////////////////////////////////////
		//��6�ʸ����
        if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY6.equals(configItemVWInfo.getClabel())){
            form.setActualmoney6(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag6(true);
            }
            //Ӱ�񼯳�
            String eiid = configItemVWInfo.getEiid();
            String cid = configItemVWInfo.getCid();
            form.setContractId6(eiid+"_"+cid);
            String clabel = configItemVWInfo.getEilabel();
            form.setContractLabel6(clabel);
            String cname = configItemVWInfo.getCname();
            form.setContractName6(configItemVWInfo.getEiname()+"_"+cname);
        }
        //��6��Ӧ����
        if(CommonDefineUtils.ENTIY_COMPACT_EXPECTDAY6.equals(configItemVWInfo.getClabel())){
            form.setExpectday6(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag6(true);
            }
        }
        //��6��ʵ����
        if(CommonDefineUtils.ENTIY_COMPACT_ACTUALDAY6.equals(configItemVWInfo.getClabel())){
            form.setActualday6(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag6(true);
            }
        }
        //��Ʊ˵��
        if(CommonDefineUtils.ENTIY_COMPACT_INVOICEEXPLAIN6.equals(configItemVWInfo.getClabel())){
            form.setInvoiceexplain6(configItemVWInfo.getCivalue());
            form.setContractDesc6(configItemVWInfo.getCivalue());
        }
        
      //��7�ʸ����
        if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY7.equals(configItemVWInfo.getClabel())){
            form.setActualmoney7(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag7(true);
            }
            //Ӱ�񼯳�
            String eiid = configItemVWInfo.getEiid();
            String cid = configItemVWInfo.getCid();
            form.setContractId7(eiid+"_"+cid);
            String clabel = configItemVWInfo.getEilabel();
            form.setContractLabel7(clabel);
            String cname = configItemVWInfo.getCname();
            form.setContractName7(configItemVWInfo.getEiname()+"_"+cname);
        }
        //��7��Ӧ����
        if(CommonDefineUtils.ENTIY_COMPACT_EXPECTDAY7.equals(configItemVWInfo.getClabel())){
            form.setExpectday7(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag7(true);
            }
        }
        //��7��ʵ����
        if(CommonDefineUtils.ENTIY_COMPACT_ACTUALDAY7.equals(configItemVWInfo.getClabel())){
            form.setActualday7(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag7(true);
            }
        }
        //��Ʊ˵��
        if(CommonDefineUtils.ENTIY_COMPACT_INVOICEEXPLAIN7.equals(configItemVWInfo.getClabel())){
            form.setInvoiceexplain7(configItemVWInfo.getCivalue());
            form.setContractDesc7(configItemVWInfo.getCivalue());
        }
        
      //��8�ʸ����
        if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY8.equals(configItemVWInfo.getClabel())){
            form.setActualmoney8(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag8(true);
            }
            //Ӱ�񼯳�
            String eiid = configItemVWInfo.getEiid();
            String cid = configItemVWInfo.getCid();
            form.setContractId8(eiid+"_"+cid);
            String clabel = configItemVWInfo.getEilabel();
            form.setContractLabel8(clabel);
            String cname = configItemVWInfo.getCname();
            form.setContractName8(configItemVWInfo.getEiname()+"_"+cname);
        }
        //��8��Ӧ����
        if(CommonDefineUtils.ENTIY_COMPACT_EXPECTDAY8.equals(configItemVWInfo.getClabel())){
            form.setExpectday8(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag8(true);
            }
        }
        //��8��ʵ����
        if(CommonDefineUtils.ENTIY_COMPACT_ACTUALDAY8.equals(configItemVWInfo.getClabel())){
            form.setActualday8(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag8(true);
            }
        }
        //��Ʊ˵��
        if(CommonDefineUtils.ENTIY_COMPACT_INVOICEEXPLAIN8.equals(configItemVWInfo.getClabel())){
            form.setInvoiceexplain8(configItemVWInfo.getCivalue());
            form.setContractDesc8(configItemVWInfo.getCivalue());
        }
        
      //��9�ʸ����
        if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY9.equals(configItemVWInfo.getClabel())){
            form.setActualmoney9(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag9(true);
            }
            //Ӱ�񼯳�
            String eiid = configItemVWInfo.getEiid();
            String cid = configItemVWInfo.getCid();
            form.setContractId9(eiid+"_"+cid);
            String clabel = configItemVWInfo.getEilabel();
            form.setContractLabel9(clabel);
            String cname = configItemVWInfo.getCname();
            form.setContractName9(configItemVWInfo.getEiname()+"_"+cname);
        }
        //��9��Ӧ����
        if(CommonDefineUtils.ENTIY_COMPACT_EXPECTDAY9.equals(configItemVWInfo.getClabel())){
            form.setExpectday9(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag9(true);
            }
        }
        //��9��ʵ����
        if(CommonDefineUtils.ENTIY_COMPACT_ACTUALDAY9.equals(configItemVWInfo.getClabel())){
            form.setActualday9(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag9(true);
            }
        }
        //��Ʊ˵��
        if(CommonDefineUtils.ENTIY_COMPACT_INVOICEEXPLAIN9.equals(configItemVWInfo.getClabel())){
            form.setInvoiceexplain9(configItemVWInfo.getCivalue());
            form.setContractDesc9(configItemVWInfo.getCivalue());
        }
        
      //��10�ʸ����
        if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY10.equals(configItemVWInfo.getClabel())){
            form.setActualmoney10(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag10(true);
            }
            //Ӱ�񼯳�
            String eiid = configItemVWInfo.getEiid();
            String cid = configItemVWInfo.getCid();
            form.setContractId10(eiid+"_"+cid);
            String clabel = configItemVWInfo.getEilabel();
            form.setContractLabel10(clabel);
            String cname = configItemVWInfo.getCname();
            form.setContractName10(configItemVWInfo.getEiname()+"_"+cname);
        }
        //��10��Ӧ����
        if(CommonDefineUtils.ENTIY_COMPACT_EXPECTDAY10.equals(configItemVWInfo.getClabel())){
            form.setExpectday10(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag10(true);
            }
        }
        //��10��ʵ����
        if(CommonDefineUtils.ENTIY_COMPACT_ACTUALDAY10.equals(configItemVWInfo.getClabel())){
            form.setActualday10(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag10(true);
            }
        }
        //��Ʊ˵��
        if(CommonDefineUtils.ENTIY_COMPACT_INVOICEEXPLAIN10.equals(configItemVWInfo.getClabel())){
            form.setInvoiceexplain10(configItemVWInfo.getCivalue());
            form.setContractDesc10(configItemVWInfo.getCivalue());
        }
        
      //��11�ʸ����
        if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY11.equals(configItemVWInfo.getClabel())){
            form.setActualmoney11(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag11(true);
            }
            //Ӱ�񼯳�
            String eiid = configItemVWInfo.getEiid();
            String cid = configItemVWInfo.getCid();
            form.setContractId11(eiid+"_"+cid);
            String clabel = configItemVWInfo.getEilabel();
            form.setContractLabel11(clabel);
            String cname = configItemVWInfo.getCname();
            form.setContractName11(configItemVWInfo.getEiname()+"_"+cname);
        }
        //��11��Ӧ����
        if(CommonDefineUtils.ENTIY_COMPACT_EXPECTDAY11.equals(configItemVWInfo.getClabel())){
            form.setExpectday11(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag11(true);
            }
        }
        //��11��ʵ����
        if(CommonDefineUtils.ENTIY_COMPACT_ACTUALDAY11.equals(configItemVWInfo.getClabel())){
            form.setActualday11(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag11(true);
            }
        }
        //��Ʊ˵��
        if(CommonDefineUtils.ENTIY_COMPACT_INVOICEEXPLAIN11.equals(configItemVWInfo.getClabel())){
            form.setInvoiceexplain11(configItemVWInfo.getCivalue());
            form.setContractDesc11(configItemVWInfo.getCivalue());
        }
        
      //��12�ʸ����
        if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY12.equals(configItemVWInfo.getClabel())){
            form.setActualmoney12(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag12(true);
            }
            //Ӱ�񼯳�
            String eiid = configItemVWInfo.getEiid();
            String cid = configItemVWInfo.getCid();
            form.setContractId12(eiid+"_"+cid);
            String clabel = configItemVWInfo.getEilabel();
            form.setContractLabel12(clabel);
            String cname = configItemVWInfo.getCname();
            form.setContractName12(configItemVWInfo.getEiname()+"_"+cname);
        }
        //��12��Ӧ����
        if(CommonDefineUtils.ENTIY_COMPACT_EXPECTDAY12.equals(configItemVWInfo.getClabel())){
            form.setExpectday12(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag12(true);
            }
        }
        //��12��ʵ����
        if(CommonDefineUtils.ENTIY_COMPACT_ACTUALDAY12.equals(configItemVWInfo.getClabel())){
            form.setActualday12(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag12(true);
            }
        }
        //��Ʊ˵��
        if(CommonDefineUtils.ENTIY_COMPACT_INVOICEEXPLAIN12.equals(configItemVWInfo.getClabel())){
            form.setInvoiceexplain12(configItemVWInfo.getCivalue());
            form.setContractDesc12(configItemVWInfo.getCivalue());
        }
        
      //��13�ʸ����
        if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY13.equals(configItemVWInfo.getClabel())){
            form.setActualmoney13(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag13(true);
            }
            //Ӱ�񼯳�
            String eiid = configItemVWInfo.getEiid();
            String cid = configItemVWInfo.getCid();
            form.setContractId13(eiid+"_"+cid);
            String clabel = configItemVWInfo.getEilabel();
            form.setContractLabel13(clabel);
            String cname = configItemVWInfo.getCname();
            form.setContractName13(configItemVWInfo.getEiname()+"_"+cname);
        }
        //��13��Ӧ����
        if(CommonDefineUtils.ENTIY_COMPACT_EXPECTDAY13.equals(configItemVWInfo.getClabel())){
            form.setExpectday13(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag13(true);
            }
        }
        //��13��ʵ����
        if(CommonDefineUtils.ENTIY_COMPACT_ACTUALDAY13.equals(configItemVWInfo.getClabel())){
            form.setActualday13(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag13(true);
            }
        }
        //��Ʊ˵��
        if(CommonDefineUtils.ENTIY_COMPACT_INVOICEEXPLAIN13.equals(configItemVWInfo.getClabel())){
            form.setInvoiceexplain13(configItemVWInfo.getCivalue());
            form.setContractDesc13(configItemVWInfo.getCivalue());
        }
        
      //��14�ʸ����
        if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY14.equals(configItemVWInfo.getClabel())){
            form.setActualmoney14(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag14(true);
            }
            //Ӱ�񼯳�
            String eiid = configItemVWInfo.getEiid();
            String cid = configItemVWInfo.getCid();
            form.setContractId14(eiid+"_"+cid);
            String clabel = configItemVWInfo.getEilabel();
            form.setContractLabel14(clabel);
            String cname = configItemVWInfo.getCname();
            form.setContractName14(configItemVWInfo.getEiname()+"_"+cname);
        }
        //��14��Ӧ����
        if(CommonDefineUtils.ENTIY_COMPACT_EXPECTDAY14.equals(configItemVWInfo.getClabel())){
            form.setExpectday14(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag14(true);
            }
        }
        //��14��ʵ����
        if(CommonDefineUtils.ENTIY_COMPACT_ACTUALDAY14.equals(configItemVWInfo.getClabel())){
            form.setActualday14(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag14(true);
            }
        }
        //��Ʊ˵��
        if(CommonDefineUtils.ENTIY_COMPACT_INVOICEEXPLAIN14.equals(configItemVWInfo.getClabel())){
            form.setInvoiceexplain14(configItemVWInfo.getCivalue());
            form.setContractDesc14(configItemVWInfo.getCivalue());
        }
        
      //��15�ʸ����
        if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY15.equals(configItemVWInfo.getClabel())){
            form.setActualmoney15(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag15(true);
            }
            //Ӱ�񼯳�
            String eiid = configItemVWInfo.getEiid();
            String cid = configItemVWInfo.getCid();
            form.setContractId15(eiid+"_"+cid);
            String clabel = configItemVWInfo.getEilabel();
            form.setContractLabel15(clabel);
            String cname = configItemVWInfo.getCname();
            form.setContractName15(configItemVWInfo.getEiname()+"_"+cname);
        }
        //��15��Ӧ����
        if(CommonDefineUtils.ENTIY_COMPACT_EXPECTDAY15.equals(configItemVWInfo.getClabel())){
            form.setExpectday15(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag15(true);
            }
        }
        //��15��ʵ����
        if(CommonDefineUtils.ENTIY_COMPACT_ACTUALDAY15.equals(configItemVWInfo.getClabel())){
            form.setActualday15(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag15(true);
            }
        }
        //��Ʊ˵��
        if(CommonDefineUtils.ENTIY_COMPACT_INVOICEEXPLAIN15.equals(configItemVWInfo.getClabel())){
            form.setInvoiceexplain15(configItemVWInfo.getCivalue());
            form.setContractDesc15(configItemVWInfo.getCivalue());
        }
        
        /////////////////////////////////////////////////////////////////
		//��һ���Ƶ���
		if(CommonDefineUtils.ENTIY_COMPACT_ZHIDANDAY1.equals(configItemVWInfo.getClabel())){
			form.setZhidanday1(configItemVWInfo.getCivalue());
			if(StringUtils.isEmpty(civalue)){
				form.setBtnFlag1(true);
			}
		}
		//��һ��Ӧ�������
		if(CommonDefineUtils.ENTIY_COMPACT_YINGFUMONEYRATIO1.equals(configItemVWInfo.getClabel())){
			form.setYingfumoneyratio1(configItemVWInfo.getCivalue());
			if(StringUtils.isEmpty(civalue)){
				form.setBtnFlag1(true);
			}
		}
		//��һ��ʵ�����
		if(CommonDefineUtils.ENTIY_COMPACT_SHIFUMONEY1.equals(configItemVWInfo.getClabel())){
			form.setShifumoney1(configItemVWInfo.getCivalue());
			if(StringUtils.isEmpty(civalue)){
				form.setBtnFlag1(true);
			}
		}
		
		//�ڶ����Ƶ���
		if(CommonDefineUtils.ENTIY_COMPACT_ZHIDANDAY2.equals(configItemVWInfo.getClabel())){
			form.setZhidanday2(configItemVWInfo.getCivalue());
			if(StringUtils.isEmpty(civalue)){
				form.setBtnFlag2(true);
			}
		}
		//�ڶ���Ӧ�������
		if(CommonDefineUtils.ENTIY_COMPACT_YINGFUMONEYRATIO2.equals(configItemVWInfo.getClabel())){
			form.setYingfumoneyratio2(configItemVWInfo.getCivalue());
			if(StringUtils.isEmpty(civalue)){
				form.setBtnFlag2(true);
			}
		}
		//�ڶ���ʵ�����
		if(CommonDefineUtils.ENTIY_COMPACT_SHIFUMONEY2.equals(configItemVWInfo.getClabel())){
			form.setShifumoney2(configItemVWInfo.getCivalue());
			if(StringUtils.isEmpty(civalue)){
				form.setBtnFlag2(true);
			}
		}
		
		//�������Ƶ���
		if(CommonDefineUtils.ENTIY_COMPACT_ZHIDANDAY3.equals(configItemVWInfo.getClabel())){
			form.setZhidanday3(configItemVWInfo.getCivalue());
			if(StringUtils.isEmpty(civalue)){
				form.setBtnFlag3(true);
			}
		}
		//������Ӧ�������
		if(CommonDefineUtils.ENTIY_COMPACT_YINGFUMONEYRATIO3.equals(configItemVWInfo.getClabel())){
			form.setYingfumoneyratio3(configItemVWInfo.getCivalue());
			if(StringUtils.isEmpty(civalue)){
				form.setBtnFlag3(true);
			}
		}
		//������ʵ�����
		if(CommonDefineUtils.ENTIY_COMPACT_SHIFUMONEY3.equals(configItemVWInfo.getClabel())){
			form.setShifumoney3(configItemVWInfo.getCivalue());
			if(StringUtils.isEmpty(civalue)){
				form.setBtnFlag3(true);
			}
		}
		
		//���ı��Ƶ���
		if(CommonDefineUtils.ENTIY_COMPACT_ZHIDANDAY4.equals(configItemVWInfo.getClabel())){
			form.setZhidanday4(configItemVWInfo.getCivalue());
			if(StringUtils.isEmpty(civalue)){
				form.setBtnFlag4(true);
			}
		}
		//���ı�Ӧ�������
		if(CommonDefineUtils.ENTIY_COMPACT_YINGFUMONEYRATIO4.equals(configItemVWInfo.getClabel())){
			form.setYingfumoneyratio4(configItemVWInfo.getCivalue());
			if(StringUtils.isEmpty(civalue)){
				form.setBtnFlag4(true);
			}
		}
		//���ı�ʵ�����
		if(CommonDefineUtils.ENTIY_COMPACT_SHIFUMONEY4.equals(configItemVWInfo.getClabel())){
			form.setShifumoney4(configItemVWInfo.getCivalue());
			if(StringUtils.isEmpty(civalue)){
				form.setBtnFlag4(true);
			}
		}
		
		//������Ƶ���
		if(CommonDefineUtils.ENTIY_COMPACT_ZHIDANDAY5.equals(configItemVWInfo.getClabel())){
			form.setZhidanday5(configItemVWInfo.getCivalue());
			if(StringUtils.isEmpty(civalue)){
				form.setBtnFlag5(true);
			}
		}
		//�����Ӧ�������
		if(CommonDefineUtils.ENTIY_COMPACT_YINGFUMONEYRATIO5.equals(configItemVWInfo.getClabel())){
			form.setYingfumoneyratio5(configItemVWInfo.getCivalue());
			if(StringUtils.isEmpty(civalue)){
				form.setBtnFlag5(true);
			}
		}
		//�����ʵ�����
		if(CommonDefineUtils.ENTIY_COMPACT_SHIFUMONEY5.equals(configItemVWInfo.getClabel())){
			form.setShifumoney5(configItemVWInfo.getCivalue());
			if(StringUtils.isEmpty(civalue)){
				form.setBtnFlag5(true);
			}
		}
		
		//////////////////////////////////////////////////////
		//��6���Ƶ���
        if(CommonDefineUtils.ENTIY_COMPACT_ZHIDANDAY6.equals(configItemVWInfo.getClabel())){
            form.setZhidanday6(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag6(true);
            }
        }
        //��6��Ӧ�������
        if(CommonDefineUtils.ENTIY_COMPACT_YINGFUMONEYRATIO6.equals(configItemVWInfo.getClabel())){
            form.setYingfumoneyratio6(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag6(true);
            }
        }
        //��6��ʵ�����
        if(CommonDefineUtils.ENTIY_COMPACT_SHIFUMONEY6.equals(configItemVWInfo.getClabel())){
            form.setShifumoney6(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag6(true);
            }
        }
        
      //��7���Ƶ���
        if(CommonDefineUtils.ENTIY_COMPACT_ZHIDANDAY7.equals(configItemVWInfo.getClabel())){
            form.setZhidanday7(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag7(true);
            }
        }
        //��7��Ӧ�������
        if(CommonDefineUtils.ENTIY_COMPACT_YINGFUMONEYRATIO7.equals(configItemVWInfo.getClabel())){
            form.setYingfumoneyratio7(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag7(true);
            }
        }
        //��7��ʵ�����
        if(CommonDefineUtils.ENTIY_COMPACT_SHIFUMONEY7.equals(configItemVWInfo.getClabel())){
            form.setShifumoney7(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag7(true);
            }
        }
        
      //��8���Ƶ���
        if(CommonDefineUtils.ENTIY_COMPACT_ZHIDANDAY8.equals(configItemVWInfo.getClabel())){
            form.setZhidanday8(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag8(true);
            }
        }
        //��8��Ӧ�������
        if(CommonDefineUtils.ENTIY_COMPACT_YINGFUMONEYRATIO8.equals(configItemVWInfo.getClabel())){
            form.setYingfumoneyratio8(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag8(true);
            }
        }
        //��8��ʵ�����
        if(CommonDefineUtils.ENTIY_COMPACT_SHIFUMONEY8.equals(configItemVWInfo.getClabel())){
            form.setShifumoney8(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag8(true);
            }
        }
        
      //��9���Ƶ���
        if(CommonDefineUtils.ENTIY_COMPACT_ZHIDANDAY9.equals(configItemVWInfo.getClabel())){
            form.setZhidanday9(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag9(true);
            }
        }
        //��9��Ӧ�������
        if(CommonDefineUtils.ENTIY_COMPACT_YINGFUMONEYRATIO9.equals(configItemVWInfo.getClabel())){
            form.setYingfumoneyratio9(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag9(true);
            }
        }
        //��9��ʵ�����
        if(CommonDefineUtils.ENTIY_COMPACT_SHIFUMONEY9.equals(configItemVWInfo.getClabel())){
            form.setShifumoney9(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag9(true);
            }
        }
        
      //��10���Ƶ���
        if(CommonDefineUtils.ENTIY_COMPACT_ZHIDANDAY10.equals(configItemVWInfo.getClabel())){
            form.setZhidanday10(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag10(true);
            }
        }
        //��10��Ӧ�������
        if(CommonDefineUtils.ENTIY_COMPACT_YINGFUMONEYRATIO10.equals(configItemVWInfo.getClabel())){
            form.setYingfumoneyratio10(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag10(true);
            }
        }
        //��10��ʵ�����
        if(CommonDefineUtils.ENTIY_COMPACT_SHIFUMONEY10.equals(configItemVWInfo.getClabel())){
            form.setShifumoney10(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag10(true);
            }
        }
        
      //��11���Ƶ���
        if(CommonDefineUtils.ENTIY_COMPACT_ZHIDANDAY11.equals(configItemVWInfo.getClabel())){
            form.setZhidanday11(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag11(true);
            }
        }
        //��11��Ӧ�������
        if(CommonDefineUtils.ENTIY_COMPACT_YINGFUMONEYRATIO11.equals(configItemVWInfo.getClabel())){
            form.setYingfumoneyratio11(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag11(true);
            }
        }
        //��11��ʵ�����
        if(CommonDefineUtils.ENTIY_COMPACT_SHIFUMONEY11.equals(configItemVWInfo.getClabel())){
            form.setShifumoney11(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag11(true);
            }
        }
        
      //��12���Ƶ���
        if(CommonDefineUtils.ENTIY_COMPACT_ZHIDANDAY12.equals(configItemVWInfo.getClabel())){
            form.setZhidanday12(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag12(true);
            }
        }
        //��12��Ӧ�������
        if(CommonDefineUtils.ENTIY_COMPACT_YINGFUMONEYRATIO12.equals(configItemVWInfo.getClabel())){
            form.setYingfumoneyratio12(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag12(true);
            }
        }
        //��12��ʵ�����
        if(CommonDefineUtils.ENTIY_COMPACT_SHIFUMONEY12.equals(configItemVWInfo.getClabel())){
            form.setShifumoney12(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag12(true);
            }
        }
        
      //��13���Ƶ���
        if(CommonDefineUtils.ENTIY_COMPACT_ZHIDANDAY13.equals(configItemVWInfo.getClabel())){
            form.setZhidanday13(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag13(true);
            }
        }
        //��13��Ӧ�������
        if(CommonDefineUtils.ENTIY_COMPACT_YINGFUMONEYRATIO13.equals(configItemVWInfo.getClabel())){
            form.setYingfumoneyratio13(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag13(true);
            }
        }
        //��13��ʵ�����
        if(CommonDefineUtils.ENTIY_COMPACT_SHIFUMONEY13.equals(configItemVWInfo.getClabel())){
            form.setShifumoney13(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag13(true);
            }
        }
        
      //��14���Ƶ���
        if(CommonDefineUtils.ENTIY_COMPACT_ZHIDANDAY14.equals(configItemVWInfo.getClabel())){
            form.setZhidanday14(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag14(true);
            }
        }
        //��14��Ӧ�������
        if(CommonDefineUtils.ENTIY_COMPACT_YINGFUMONEYRATIO14.equals(configItemVWInfo.getClabel())){
            form.setYingfumoneyratio14(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag14(true);
            }
        }
        //��14��ʵ�����
        if(CommonDefineUtils.ENTIY_COMPACT_SHIFUMONEY14.equals(configItemVWInfo.getClabel())){
            form.setShifumoney14(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag14(true);
            }
        }
        
      //��15���Ƶ���
        if(CommonDefineUtils.ENTIY_COMPACT_ZHIDANDAY15.equals(configItemVWInfo.getClabel())){
            form.setZhidanday15(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag15(true);
            }
        }
        //��15��Ӧ�������
        if(CommonDefineUtils.ENTIY_COMPACT_YINGFUMONEYRATIO15.equals(configItemVWInfo.getClabel())){
            form.setYingfumoneyratio15(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag15(true);
            }
        }
        //��15��ʵ�����
        if(CommonDefineUtils.ENTIY_COMPACT_SHIFUMONEY15.equals(configItemVWInfo.getClabel())){
            form.setShifumoney15(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag15(true);
            }
        }
        
	}

	/**
	 * ��ͬ����ǼǴ���
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGASM04DTO editIGASM0421Action(IGASM04DTO dto) throws BLException {
		log.debug("========��ͬ������Ϣ�༭����ʼ========");
		//�汾������
		IGASM0421Form form = dto.getIgasm0421Form();
		
		int version = form.getEiversion() + 1;
		
		//��ͬ������Ϣ����
		SOC0118TB entityItem = (SOC0118TB)SerializationUtils.clone(this.soc0118BL.searchEntityItemByKey(Integer.parseInt(form.getEiid())));

		if(version - 1 != entityItem.getEiversion()) {
			throw new BLException("IGCO00000.E004");
		}
		String[] cldeiids=null;
		
		//�ʲ���ϵ��Ϣ�汾��������
		this.soc0119BL.upgradeEntityItemRelationOne(entityItem.getEiid(), entityItem.getEiversion(), entityItem.getEismallversion(),
				version, 0,cldeiids);
		//��ͬ�汾
		entityItem.setEiversion(version);
		
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		
		//����ʱ��
		entityItem.setEiupdtime(datetime);
		
		//���ò�ѯ����
		SOC0129SearchCondImpl cond=new SOC0129SearchCondImpl();
		cond.setEiid(form.getEiid());
		cond.setEsyscoding_q("999011");
		//���ݲ�ѯ����������ͬ������Ϣ
		List<SOC0129Info> configItemVWInfoList=this.soc0107BL.searchConfigItemVW(cond, 0, 0);
		if(configItemVWInfoList!=null&&configItemVWInfoList.size()>0){
			form.setAccountMoney(BigDecimal.valueOf(0));
			for(SOC0129Info configItemVWInfo:configItemVWInfoList){
				SOC0107TB configItemTB =new SOC0107TB();
				configItemTB.setCiid(null);
				configItemTB.setCid(configItemVWInfo.getCid());
				configItemTB.setEiid(Integer.parseInt(configItemVWInfo.getEiid()));
				configItemTB.setEid(configItemVWInfo.getEid());
				configItemTB.setCiupdtime(configItemVWInfo.getCiupdtime());
				configItemTB.setEsyscoding(configItemVWInfo.getEsyscoding());
				configItemTB.setCistatus(configItemVWInfo.getCistatus());
				configItemTB.setCiverinfo(configItemVWInfo.getCiverinfo());
				configItemTB.setCiversion(version);
				configItemTB.setCismallversion(configItemVWInfo.getCismallversion());
				configItemTB=getCompactOneInfo(configItemVWInfo,form,configItemTB);
				//���±�ʶ
                if((StringUtils.isEmpty(configItemVWInfo.getCivalue()) && StringUtils.isNotEmpty(configItemTB.getCivalue()))
                        || (StringUtils.isNotEmpty(configItemVWInfo.getCivalue()) && StringUtils.isEmpty(configItemTB.getCivalue()))
                        || (configItemVWInfo.getCivalue() != null && configItemTB.getCivalue() != null && !configItemVWInfo.getCivalue().equals(configItemTB.getCivalue()))) {
                    configItemTB.setCicurver("1");//��ɫ
                } else {
                    configItemTB.setCicurver("0");
                }
                SOC0107Info info=this.soc0107BL.registSOC0107(configItemTB);
                //���·����̹�ϵ
                if(SERVICE_PROVIDER.equals(configItemVWInfo.getCattach())){
                    if(configItemVWInfo.getCivalue() != null && configItemVWInfo.getCivalue().lastIndexOf("(") > -1 && configItemVWInfo.getCivalue().lastIndexOf(")") > -1){
                        String cldeiid=configItemVWInfo.getCivalue().substring(configItemVWInfo.getCivalue().lastIndexOf("(")+1,
                                configItemVWInfo.getCivalue().lastIndexOf(")"));
                        SOC0119SearchCondImpl ig313Cond = new SOC0119SearchCondImpl();
                        ig313Cond.setEirinfo(info.getEiid()+"_"+configItemVWInfo.getCiid()+"_"+cldeiid);
                        ig313Cond.setDeleteflag("0");
                        ig313Cond.setParversion(version);
                        List<SOC0119Info> ig313Info = soc0119BL.searchEntityItemRelation(ig313Cond);
                        if(ig313Info!=null&&ig313Info.size()>0){
                            SOC0119TB eirTB = (SOC0119TB)SerializationUtils.clone(ig313Info.get(0));
                            eirTB.setEirinfo(info.getEiid()+"_"+info.getCiid()+"_"+cldeiid);
                            eirTB.setEirupdtime(IGStringUtils.getCurrentDateTime());
                            soc0119BL.updateEntityItemRelation(eirTB);
                        }
                    }
                }
			}
		}
	
		this.soc0118BL.updateEntityItem(entityItem);
		dto.addMessage(new ActionMessage("IGCO10000.I005","��ͬ������Ϣ"));
		
		log.debug("========��ͬ������Ϣ�༭��������========");
		return dto;
	}

	/**
	 * ���º�ͬ������Ϣ
	 * @param configItemTB
	 * @param form
	 * @return
	 */
	private SOC0107TB getCompactOneInfo(SOC0129Info configItemVWInfo, IGASM0421Form form,SOC0107TB configItemTB) {
		log.debug("========��ͬ������Ϣ���ÿ�ʼ========");
		//��һ�ʸ����
		if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY1.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getActualmoney1());
		}
		//��һ��Ӧ����
		else if(CommonDefineUtils.ENTIY_COMPACT_EXPECTDAY1.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getExpectday1());
		}
		//��һ��ʵ����
		else if(CommonDefineUtils.ENTIY_COMPACT_ACTUALDAY1.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getActualday1());
			if(StringUtils.isNotEmpty(form.getActualday1())){
				if(StringUtils.isNotEmpty(form.getShifumoney1())){
					if(form.getAccountMoney().intValue()== 0){
						BigDecimal accountMoney=form.getAccountMoney().add(roundBig(Double.parseDouble(form.getShifumoney1()),0));
						form.setAccountMoney(accountMoney);
						form.setFlag1(true);
					}
				}
				form.setLastDateTime(form.getActualday1());
			}
		}
		//��Ʊ˵��
		else if(CommonDefineUtils.ENTIY_COMPACT_INVOICEEXPLAIN1.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getInvoiceexplain1());
		}
		//�ڶ��ʸ����
		else if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY2.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getActualmoney2());
		}
		//�ڶ���Ӧ����
		else if(CommonDefineUtils.ENTIY_COMPACT_EXPECTDAY2.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getExpectday2());
		}
		//�ڶ���ʵ����
		else if(CommonDefineUtils.ENTIY_COMPACT_ACTUALDAY2.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getActualday2());
			if(StringUtils.isNotEmpty(form.getActualday2())){
				if(StringUtils.isNotEmpty(form.getShifumoney2())){
					if(form.getFlag1()){
						BigDecimal accountMoney=form.getAccountMoney().add(roundBig(Double.parseDouble(form.getShifumoney2()),0));
						form.setAccountMoney(accountMoney);
						form.setFlag1(false);
						form.setFlag2(true);
					}
				}
				form.setLastDateTime(form.getActualday2());
			}
		}
		//��Ʊ˵��
		else if(CommonDefineUtils.ENTIY_COMPACT_INVOICEEXPLAIN2.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getInvoiceexplain2());
		}
		//�����ʸ����
		else if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY3.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getActualmoney3());
		}
		//������Ӧ����
		else if(CommonDefineUtils.ENTIY_COMPACT_EXPECTDAY3.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getExpectday3());
		}
		//������ʵ����
		else if(CommonDefineUtils.ENTIY_COMPACT_ACTUALDAY3.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getActualday3());
			if(StringUtils.isNotEmpty(form.getActualday3())){
				if(StringUtils.isNotEmpty(form.getShifumoney3())){
					if(form.getFlag2()){
						BigDecimal accountMoney=form.getAccountMoney().add(roundBig(Double.parseDouble(form.getShifumoney3()),0));
						form.setAccountMoney(accountMoney);
						form.setFlag2(false);
						form.setFlag3(true);
					}
				}
				form.setLastDateTime(form.getActualday3());
			}
		}
		//��Ʊ˵��
		else if(CommonDefineUtils.ENTIY_COMPACT_INVOICEEXPLAIN3.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getInvoiceexplain3());
		}
		//���ıʸ����
		else if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY4.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getActualmoney4());
		}
		//���ı�Ӧ����
		else if(CommonDefineUtils.ENTIY_COMPACT_EXPECTDAY4.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getExpectday4());
		}
		//���ı�ʵ����
		else if(CommonDefineUtils.ENTIY_COMPACT_ACTUALDAY4.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getActualday4());
			if(StringUtils.isNotEmpty(form.getActualday4())){
				if(StringUtils.isNotEmpty(form.getShifumoney4())){
					if(form.getFlag3()){
						BigDecimal accountMoney=form.getAccountMoney().add(roundBig(Double.parseDouble(form.getShifumoney4()),0));
						form.setAccountMoney(accountMoney);
						form.setFlag3(false);
						form.setFlag4(true);
					}
				}
				form.setLastDateTime(form.getActualday4());
			}
		}
		//��Ʊ˵��
		else if(CommonDefineUtils.ENTIY_COMPACT_INVOICEEXPLAIN4.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getInvoiceexplain4());
		}
		//����ʸ����
		else if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY5.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getActualmoney5());
		}
		//�����Ӧ����
		else if(CommonDefineUtils.ENTIY_COMPACT_EXPECTDAY5.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getExpectday5());
		}
		//�����ʵ����
		else if(CommonDefineUtils.ENTIY_COMPACT_ACTUALDAY5.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getActualday5());
			if(StringUtils.isNotEmpty(form.getActualday5())){
				if(StringUtils.isNotEmpty(form.getShifumoney5())){
					if(form.getFlag4()){
						BigDecimal accountMoney=form.getAccountMoney().add(roundBig(Double.parseDouble(form.getShifumoney5()),0));
						form.setAccountMoney(accountMoney);
						form.setFlag4(false);
						form.setFlag5(true);
					}
				}
				form.setLastDateTime(form.getActualday5());
			}
		}
		//��Ʊ˵��
		else if(CommonDefineUtils.ENTIY_COMPACT_INVOICEEXPLAIN5.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getInvoiceexplain5());
		}
		
		////////////////////////////////////////////////////////////////////
		//��6�ʸ����
		else if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY6.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getActualmoney6());
		}
		//��6��Ӧ����
		else if(CommonDefineUtils.ENTIY_COMPACT_EXPECTDAY6.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getExpectday6());
		}
		//��6��ʵ����
		else if(CommonDefineUtils.ENTIY_COMPACT_ACTUALDAY6.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getActualday6());
			if(StringUtils.isNotEmpty(form.getActualday6())){
				if(StringUtils.isNotEmpty(form.getShifumoney6())){
					if(form.getFlag5()){
						BigDecimal accountMoney=form.getAccountMoney().add(roundBig(Double.parseDouble(form.getShifumoney6()),0));
						form.setAccountMoney(accountMoney);
						form.setFlag5(false);
						form.setFlag6(true);
					}
				}
				form.setLastDateTime(form.getActualday6());
			}
		}
		//��Ʊ˵��
		else if(CommonDefineUtils.ENTIY_COMPACT_INVOICEEXPLAIN6.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getInvoiceexplain6());
		}
		
		//��7�ʸ����
		else if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY7.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getActualmoney7());
		}
		//��7��Ӧ����
		else if(CommonDefineUtils.ENTIY_COMPACT_EXPECTDAY7.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getExpectday7());
		}
		//��7��ʵ����
		else if(CommonDefineUtils.ENTIY_COMPACT_ACTUALDAY7.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getActualday7());
			if(StringUtils.isNotEmpty(form.getActualday7())){
				if(StringUtils.isNotEmpty(form.getShifumoney7())){
					if(form.getFlag6()){
						BigDecimal accountMoney=form.getAccountMoney().add(roundBig(Double.parseDouble(form.getShifumoney7()),0));
						form.setAccountMoney(accountMoney);
						form.setFlag6(false);
						form.setFlag7(true);
					}
				}
				form.setLastDateTime(form.getActualday7());
			}
		}
		//��Ʊ˵��
		else if(CommonDefineUtils.ENTIY_COMPACT_INVOICEEXPLAIN7.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getInvoiceexplain7());
		}
		
		//��8�ʸ����
		else if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY8.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getActualmoney8());
		}
		//��8��Ӧ����
		else if(CommonDefineUtils.ENTIY_COMPACT_EXPECTDAY8.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getExpectday8());
		}
		//��8��ʵ����
		else if(CommonDefineUtils.ENTIY_COMPACT_ACTUALDAY8.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getActualday8());
			if(StringUtils.isNotEmpty(form.getActualday8())){
				if(StringUtils.isNotEmpty(form.getShifumoney8())){
					if(form.getFlag7()){
						BigDecimal accountMoney=form.getAccountMoney().add(roundBig(Double.parseDouble(form.getShifumoney8()),0));
						form.setAccountMoney(accountMoney);
						form.setFlag7(false);
						form.setFlag8(true);
					}
				}
				form.setLastDateTime(form.getActualday8());
			}
		}
		//��Ʊ˵��
		else if(CommonDefineUtils.ENTIY_COMPACT_INVOICEEXPLAIN8.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getInvoiceexplain8());
		}
		
		//��9�ʸ����
		else if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY9.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getActualmoney9());
		}
		//��9��Ӧ����
		else if(CommonDefineUtils.ENTIY_COMPACT_EXPECTDAY9.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getExpectday9());
		}
		//��9��ʵ����
		else if(CommonDefineUtils.ENTIY_COMPACT_ACTUALDAY9.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getActualday9());
			if(StringUtils.isNotEmpty(form.getActualday9())){
				if(StringUtils.isNotEmpty(form.getShifumoney9())){
					if(form.getFlag8()){
						BigDecimal accountMoney=form.getAccountMoney().add(roundBig(Double.parseDouble(form.getShifumoney9()),0));
						form.setAccountMoney(accountMoney);
						form.setFlag8(false);
						form.setFlag9(true);
					}
				}
				form.setLastDateTime(form.getActualday9());
			}
		}
		//��Ʊ˵��
		else if(CommonDefineUtils.ENTIY_COMPACT_INVOICEEXPLAIN9.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getInvoiceexplain9());
		}
		
		//��10�ʸ����
		else if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY10.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getActualmoney10());
		}
		//��10��Ӧ����
		else if(CommonDefineUtils.ENTIY_COMPACT_EXPECTDAY10.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getExpectday10());
		}
		//��10��ʵ����
		else if(CommonDefineUtils.ENTIY_COMPACT_ACTUALDAY10.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getActualday10());
			if(StringUtils.isNotEmpty(form.getActualday10())){
				if(StringUtils.isNotEmpty(form.getShifumoney10())){
					if(form.getFlag9()){
						BigDecimal accountMoney=form.getAccountMoney().add(roundBig(Double.parseDouble(form.getShifumoney10()),0));
						form.setAccountMoney(accountMoney);
						form.setFlag9(false);
						form.setFlag10(true);
					}
				}
				form.setLastDateTime(form.getActualday10());
			}
		}
		//��Ʊ˵��
		else if(CommonDefineUtils.ENTIY_COMPACT_INVOICEEXPLAIN10.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getInvoiceexplain10());
		}
		
		//��11�ʸ����
		else if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY11.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getActualmoney11());
		}
		//��11��Ӧ����
		else if(CommonDefineUtils.ENTIY_COMPACT_EXPECTDAY11.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getExpectday11());
		}
		//��11��ʵ����
		else if(CommonDefineUtils.ENTIY_COMPACT_ACTUALDAY11.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getActualday11());
			if(StringUtils.isNotEmpty(form.getActualday11())){
				if(StringUtils.isNotEmpty(form.getShifumoney11())){
					if(form.getFlag10()){
						BigDecimal accountMoney=form.getAccountMoney().add(roundBig(Double.parseDouble(form.getShifumoney11()),0));
						form.setAccountMoney(accountMoney);
						form.setFlag10(false);
						form.setFlag11(true);
					}
				}
				form.setLastDateTime(form.getActualday11());
			}
		}
		//��Ʊ˵��
		else if(CommonDefineUtils.ENTIY_COMPACT_INVOICEEXPLAIN11.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getInvoiceexplain11());
		}
		
		//��12�ʸ����
		else if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY12.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getActualmoney12());
		}
		//��12��Ӧ����
		else if(CommonDefineUtils.ENTIY_COMPACT_EXPECTDAY12.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getExpectday12());
		}
		//��12��ʵ����
		else if(CommonDefineUtils.ENTIY_COMPACT_ACTUALDAY12.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getActualday12());
			if(StringUtils.isNotEmpty(form.getActualday12())){
				if(StringUtils.isNotEmpty(form.getShifumoney12())){
					if(form.getFlag11()){
						BigDecimal accountMoney=form.getAccountMoney().add(roundBig(Double.parseDouble(form.getShifumoney12()),0));
						form.setAccountMoney(accountMoney);
						form.setFlag11(false);
						form.setFlag12(true);
					}
				}
				form.setLastDateTime(form.getActualday12());
			}
		}
		//��Ʊ˵��
		else if(CommonDefineUtils.ENTIY_COMPACT_INVOICEEXPLAIN12.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getInvoiceexplain12());
		}
		
		//��13�ʸ����
		else if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY13.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getActualmoney13());
		}
		//��13��Ӧ����
		else if(CommonDefineUtils.ENTIY_COMPACT_EXPECTDAY13.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getExpectday13());
		}
		//��13��ʵ����
		else if(CommonDefineUtils.ENTIY_COMPACT_ACTUALDAY13.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getActualday13());
			if(StringUtils.isNotEmpty(form.getActualday13())){
				if(StringUtils.isNotEmpty(form.getShifumoney13())){
					if(form.getFlag12()){
						BigDecimal accountMoney=form.getAccountMoney().add(roundBig(Double.parseDouble(form.getShifumoney13()),0));
						form.setAccountMoney(accountMoney);
						form.setFlag12(false);
						form.setFlag13(true);
					}
				}
				form.setLastDateTime(form.getActualday13());
			}
		}
		//��Ʊ˵��
		else if(CommonDefineUtils.ENTIY_COMPACT_INVOICEEXPLAIN13.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getInvoiceexplain13());
		}
		
		//��14�ʸ����
		else if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY14.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getActualmoney14());
		}
		//��14��Ӧ����
		else if(CommonDefineUtils.ENTIY_COMPACT_EXPECTDAY14.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getExpectday14());
		}
		//��14��ʵ����
		else if(CommonDefineUtils.ENTIY_COMPACT_ACTUALDAY14.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getActualday14());
			if(StringUtils.isNotEmpty(form.getActualday14())){
				if(StringUtils.isNotEmpty(form.getShifumoney14())){
					if(form.getFlag13()){
						BigDecimal accountMoney=form.getAccountMoney().add(roundBig(Double.parseDouble(form.getShifumoney14()),0));
						form.setAccountMoney(accountMoney);
						form.setFlag13(false);
						form.setFlag14(true);
					}
				}
				form.setLastDateTime(form.getActualday14());
			}
		}
		//��Ʊ˵��
		else if(CommonDefineUtils.ENTIY_COMPACT_INVOICEEXPLAIN14.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getInvoiceexplain14());
		}
		
		//��15�ʸ����
		else if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY15.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getActualmoney15());
		}
		//��15��Ӧ����
		else if(CommonDefineUtils.ENTIY_COMPACT_EXPECTDAY15.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getExpectday15());
		}
		//��15��ʵ����
		else if(CommonDefineUtils.ENTIY_COMPACT_ACTUALDAY15.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getActualday15());
			if(StringUtils.isNotEmpty(form.getActualday15())){
				if(StringUtils.isNotEmpty(form.getShifumoney15())){
					if(form.getFlag14()){
						BigDecimal accountMoney=form.getAccountMoney().add(roundBig(Double.parseDouble(form.getShifumoney15()),0));
						form.setAccountMoney(accountMoney);
						form.setFlag14(false);
					}
				}
				form.setLastDateTime(form.getActualday15());
			}
		}
		//��Ʊ˵��
		else if(CommonDefineUtils.ENTIY_COMPACT_INVOICEEXPLAIN15.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getInvoiceexplain15());
		}
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////
		//�Ѹ���
		else if(CommonDefineUtils.ENTIY_COMPACT_ACCOUNTMONEY.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getAccountMoney().toString());
		}
		//��󸶿���
		else if(CommonDefineUtils.ENTIY_COMPACT_LASTDATETIME.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getLastDateTime());
		}
		//��һ���Ƶ���
		else if(CommonDefineUtils.ENTIY_COMPACT_ZHIDANDAY1.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getZhidanday1());
		}
		//��һ��Ӧ�������
		else if(CommonDefineUtils.ENTIY_COMPACT_YINGFUMONEYRATIO1.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getYingfumoneyratio1());
		}
		//��һ��ʵ�����
		else if(CommonDefineUtils.ENTIY_COMPACT_SHIFUMONEY1.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getShifumoney1());
		}
		
		//�ڶ����Ƶ���
		else if(CommonDefineUtils.ENTIY_COMPACT_ZHIDANDAY2.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getZhidanday2());
		}
		//�ڶ���Ӧ�������
		else if(CommonDefineUtils.ENTIY_COMPACT_YINGFUMONEYRATIO2.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getYingfumoneyratio2());
		}
		//�ڶ���ʵ�����
		else if(CommonDefineUtils.ENTIY_COMPACT_SHIFUMONEY2.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getShifumoney2());
		}
		
		//�������Ƶ���
		else if(CommonDefineUtils.ENTIY_COMPACT_ZHIDANDAY3.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getZhidanday3());
		}
		//������Ӧ�������
		else if(CommonDefineUtils.ENTIY_COMPACT_YINGFUMONEYRATIO3.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getYingfumoneyratio3());
		}
		//������ʵ�����
		else if(CommonDefineUtils.ENTIY_COMPACT_SHIFUMONEY3.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getShifumoney3());
		}
		
		//���ı��Ƶ���
		else if(CommonDefineUtils.ENTIY_COMPACT_ZHIDANDAY4.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getZhidanday4());
		}
		//���ı�Ӧ�������
		else if(CommonDefineUtils.ENTIY_COMPACT_YINGFUMONEYRATIO4.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getYingfumoneyratio4());
		}
		//���ı�ʵ�����
		else if(CommonDefineUtils.ENTIY_COMPACT_SHIFUMONEY4.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getShifumoney4());
		}
		
		//������Ƶ���
		else if(CommonDefineUtils.ENTIY_COMPACT_ZHIDANDAY5.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getZhidanday5());
		}
		//�����Ӧ�������
		else if(CommonDefineUtils.ENTIY_COMPACT_YINGFUMONEYRATIO5.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getYingfumoneyratio5());
		}
		//�����ʵ�����
		else if(CommonDefineUtils.ENTIY_COMPACT_SHIFUMONEY5.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getShifumoney5());
		}
		
		///////////////////////////////////////////////////////////////////////////////////////
		
		//��6���Ƶ���
		else if(CommonDefineUtils.ENTIY_COMPACT_ZHIDANDAY6.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getZhidanday6());
		}
		//��6��Ӧ�������
		else if(CommonDefineUtils.ENTIY_COMPACT_YINGFUMONEYRATIO6.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getYingfumoneyratio6());
		}
		//��6��ʵ�����
		else if(CommonDefineUtils.ENTIY_COMPACT_SHIFUMONEY6.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getShifumoney6());
		}
		
		//��7���Ƶ���
		else if(CommonDefineUtils.ENTIY_COMPACT_ZHIDANDAY7.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getZhidanday7());
		}
		//��7��Ӧ�������
		else if(CommonDefineUtils.ENTIY_COMPACT_YINGFUMONEYRATIO7.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getYingfumoneyratio7());
		}
		//��7��ʵ�����
		else if(CommonDefineUtils.ENTIY_COMPACT_SHIFUMONEY7.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getShifumoney7());
		}
		
		//��8���Ƶ���
		else if(CommonDefineUtils.ENTIY_COMPACT_ZHIDANDAY8.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getZhidanday8());
		}
		//��8��Ӧ�������
		else if(CommonDefineUtils.ENTIY_COMPACT_YINGFUMONEYRATIO8.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getYingfumoneyratio8());
		}
		//��8��ʵ�����
		else if(CommonDefineUtils.ENTIY_COMPACT_SHIFUMONEY8.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getShifumoney8());
		}
		
		//��9���Ƶ���
		else if(CommonDefineUtils.ENTIY_COMPACT_ZHIDANDAY9.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getZhidanday9());
		}
		//��9��Ӧ�������
		else if(CommonDefineUtils.ENTIY_COMPACT_YINGFUMONEYRATIO9.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getYingfumoneyratio9());
		}
		//��9��ʵ�����
		else if(CommonDefineUtils.ENTIY_COMPACT_SHIFUMONEY9.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getShifumoney9());
		}
		
		//��10���Ƶ���
		else if(CommonDefineUtils.ENTIY_COMPACT_ZHIDANDAY10.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getZhidanday10());
		}
		//��10��Ӧ�������
		else if(CommonDefineUtils.ENTIY_COMPACT_YINGFUMONEYRATIO10.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getYingfumoneyratio10());
		}
		//��10��ʵ�����
		else if(CommonDefineUtils.ENTIY_COMPACT_SHIFUMONEY10.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getShifumoney10());
		}
		
		//��11���Ƶ���
		else if(CommonDefineUtils.ENTIY_COMPACT_ZHIDANDAY11.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getZhidanday11());
		}
		//��11��Ӧ�������
		else if(CommonDefineUtils.ENTIY_COMPACT_YINGFUMONEYRATIO11.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getYingfumoneyratio11());
		}
		//��11��ʵ�����
		else if(CommonDefineUtils.ENTIY_COMPACT_SHIFUMONEY11.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getShifumoney11());
		}
		
		//��12���Ƶ���
		else if(CommonDefineUtils.ENTIY_COMPACT_ZHIDANDAY12.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getZhidanday12());
		}
		//��12��Ӧ�������
		else if(CommonDefineUtils.ENTIY_COMPACT_YINGFUMONEYRATIO12.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getYingfumoneyratio12());
		}
		//��12��ʵ�����
		else if(CommonDefineUtils.ENTIY_COMPACT_SHIFUMONEY12.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getShifumoney12());
		}
		
		//��13���Ƶ���
		else if(CommonDefineUtils.ENTIY_COMPACT_ZHIDANDAY13.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getZhidanday13());
		}
		//��13��Ӧ�������
		else if(CommonDefineUtils.ENTIY_COMPACT_YINGFUMONEYRATIO13.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getYingfumoneyratio13());
		}
		//��13��ʵ�����
		else if(CommonDefineUtils.ENTIY_COMPACT_SHIFUMONEY13.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getShifumoney13());
		}
		
		//��14���Ƶ���
		else if(CommonDefineUtils.ENTIY_COMPACT_ZHIDANDAY14.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getZhidanday14());
		}
		//��14��Ӧ�������
		else if(CommonDefineUtils.ENTIY_COMPACT_YINGFUMONEYRATIO14.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getYingfumoneyratio14());
		}
		//��14��ʵ�����
		else if(CommonDefineUtils.ENTIY_COMPACT_SHIFUMONEY14.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getShifumoney14());
		}
		
		//��15���Ƶ���
		else if(CommonDefineUtils.ENTIY_COMPACT_ZHIDANDAY15.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getZhidanday15());
		}
		//��15��Ӧ�������
		else if(CommonDefineUtils.ENTIY_COMPACT_YINGFUMONEYRATIO15.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getYingfumoneyratio15());
		}
		//��15��ʵ�����
		else if(CommonDefineUtils.ENTIY_COMPACT_SHIFUMONEY15.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getShifumoney15());
		}
		
		///////////////////////////////////////////////////////////////////////////////////////////
		else{
			configItemTB.setCivalue(configItemVWInfo.getCivalue());
		}
		log.debug("========��ͬ������Ϣ��������========");
		return configItemTB;
	}
	
	/**
	 * ����ת������ʾ��ѧ������
	 * @param double_param
	 * @param scale
	 * @return
	 */
	public static BigDecimal roundBig(Double double_param,int scale){
		BigDecimal varDouble=new BigDecimal(double_param);
		BigDecimal one = new BigDecimal("1");
		return varDouble.divide(one, scale, BigDecimal.ROUND_HALF_UP);
	}
	

	
	/**
     * ��ͬͳ�Ʋ�ѯ����
     * add by zhangze
     * @param dto IGASM04DTO
     * @return IGASM04DTO
     */
    public IGASM04DTO searchStatics(IGASM04DTO dto) throws BLException {
        log.debug("========��ͬӦ�����ѯ��ʼ========");
        
        //��ҳ����Ϣȡ��
        PagingDTO pDto = dto.getPagingDto();

        //���к�ͬ��Ϣȡ��
        List<IG499Info> entityItemCompactVWInfoListA = this.ig499BL.searchIG499Info(dto.getEntityItemCompactVWSearchCond());
        
        //�����ѯ�����ĺ�ͬ entityItemCompactVWInfoListA���˺�Ľ��
        List<IG499Info> entityItemCompactVWInfoListB=new ArrayList<IG499Info>();
        
        List<String> eiid_list = new ArrayList<String>() ;
        
        for (IG499Info entityItemCompactVWInfo : entityItemCompactVWInfoListA) {
            //�õ���������������ͬeiid�ļ���
            eiid_list.add(entityItemCompactVWInfo.getEiid()+"");
        }
        //��15������ʵ����
        //{"1694","1701","1708","1715","1722","1785","1792","1799","1806","1813","1820","1827","1834","1841","1848"};
        String[] cid = IGASM04BLType.CID; 
        //��15��������
        //{"1691","1698","1705","1712","1719","1782","1789","1796","1803","1810","1817","1824","1831","1838","1845"};
        String[] civalueOfMoney = IGASM04BLType.CivalueOfMoney; 
        List<String> cid_list = new ArrayList<String>();
        List<String> civalueOfMoney_list = new ArrayList<String>();
        
        for(int i=0;i<cid.length;i++){
            cid_list.add(cid[i]);
            civalueOfMoney_list.add(civalueOfMoney[i]);
        }

        List<SOC0129Info> configItemVWInfoList;
        
        //Calendar calendars = Calendar.getInstance(Locale.CHINA);
        Calendar calendars = Calendar.getInstance();
        int year = calendars.get(Calendar.YEAR);
        
        //��ʼʱ�䣬����ʱ��
        //Date beginOfDate = new Date(IGStringUtils.getCurrentYear()+"/01/01");
        Date beginOfDate = stringToDate(year+"/01/01");
        //Date endOfDate = new Date();
        Date endOfDate = calendars.getTime();
        IGASM0424Form form = (IGASM0424Form)dto.getEntityItemCompactVWSearchCond();
        //����ҳ�����뿪ʼʱ�䣬��ֵ
        if(form.getTime_from()!=null && !"".equals(form.getTime_from())){
            //beginOfDate = new Date(form.getTime_from());
            beginOfDate = stringToDate(form.getTime_from());
        }
        //����ҳ���������ʱ�䣬��ֵ        
        if(form.getTime_to()!=null && !"".equals(form.getTime_to())){
            //endOfDate = new Date(form.getTime_to());
            endOfDate = stringToDate(form.getTime_to());
        } 
            
        //�����ʼʱ���ڽ���ʱ��֮�����Զ��޸Ŀ�ʼʱ��Ϊ����Ŀ�ʼʱ��
        if(endOfDate != null && beginOfDate != null && beginOfDate.after(endOfDate)){
            //��������������ѯ���Ϊ��
            //beginOfDate.setYear(endOfDate.getYear());
            Calendar bcal = Calendar.getInstance();
            Calendar ecal = Calendar.getInstance();
            bcal.setTime(beginOfDate);
            ecal.setTime(endOfDate);
            bcal.set(Calendar.YEAR, ecal.get(Calendar.YEAR));
            beginOfDate = bcal.getTime();
        }

        
        List<Integer> resultOfEiid = new ArrayList<Integer>();
        //���ҳ����Ҫ��ʾ����Ϣ
        Map<String,List<SOC0129Info>> mapOfSOC0129Info = new HashMap<String,List<SOC0129Info>>();
        SOC0129SearchCondImpl ig002SearchCondImpl = new SOC0129SearchCondImpl();
        ig002SearchCondImpl.setEsyscoding_q("999011");
        for(String str : (List<String>)eiid_list){
            //����
            ig002SearchCondImpl.setEiid(str);
            
            configItemVWInfoList = this.soc0107BL.searchConfigItemVW(ig002SearchCondImpl,0,0);
            
            for(SOC0129Info info : configItemVWInfoList){
                
                //ȥ��û�е�
                if(cid_list.contains(info.getCid()) ){
                    //�ж�ʱ����ʱ����ڣ�Ĭ����һ��
//                  System.out.println("info:::"+info.getCid()+":::"+info.getCivalue()+IGStringUtils.getCurrentDate());
                    String civalue = info.getCivalue();
                    if(civalue != null && civalue != ""){
                        //Date date = new Date(civalue); 
                        Date date = stringToDate(civalue); 
                        if(endOfDate != null && beginOfDate != null && date.before(endOfDate) && date.after(beginOfDate)){
                            //ʱ�����������
                            resultOfEiid.add(Integer.parseInt(info.getEiid()));
                            mapOfSOC0129Info.put(str, configItemVWInfoList);
                            break;
                        }
                    }
                    
                }
            }//for
        }//for
        
        //����ҳ����ʾ������
        for (IG499Info entityItemCompactVWInfo : entityItemCompactVWInfoListA) {
            if(resultOfEiid.contains(entityItemCompactVWInfo.getEiid())){
                int eiid = entityItemCompactVWInfo.getEiid();
                //�������ڵ��Ѹ���Ľ��
                Double ekey1 = new Double(0);
                Map<String,String> temp = new HashMap<String,String>();
                for(SOC0129Info info : mapOfSOC0129Info.get(eiid+"")){
                    //15�����ڣ�15�����
                    if(civalueOfMoney_list.contains(info.getCid()) || cid_list.contains(info.getCid())){
                        temp.put(info.getCid(), info.getCivalue());
                    }
                    temp.put(info.getCid(), info.getCivalue());
                }//for
                //��ʱ�䣬���������ĸ���key1
                for(int i=0;i<cid.length;i++){
                    if(temp.get(cid[i])!=null && temp.get(cid[i])!=""){
                        //Date date = new Date(temp.get(cid[i]));
                        Date date = stringToDate(temp.get(cid[i]));
                        if(endOfDate != null && beginOfDate != null && date.before(endOfDate) && date.after(beginOfDate)){
                            if(temp.get(civalueOfMoney[i])!=null && temp.get(civalueOfMoney[i])!=""){
                                ekey1 = ekey1 + Double.parseDouble(temp.get(civalueOfMoney[i]) );
                            }
                        }
                    }
                }//for
                IG499VW ig499VW= (IG499VW)entityItemCompactVWInfo;
                ig499VW.setEkey1(ekey1.intValue()+"");
                //entityItemCompactVWInfo
                entityItemCompactVWInfoListB.add(ig499VW);
            }
        }
        int totalCount=entityItemCompactVWInfoListB.size();
        if (totalCount == 0) {
            log.debug("========��ͬͳ�Ʋ�ѯ���ݲ�����========");
            //��ͬ��Ϣ��ѯ���ݲ�����
            dto.addMessage(new ActionMessage("IGCO10000.I002",0));
            return dto;
        } 
        
        if ( totalCount > dto.getMaxSearchCount() ) {
            log.debug("========��ͬͳ�Ʋ�ѯ���ݼ�������========");
            //��ͬ��Ϣ��ѯ���ݼ�������
            dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
            return dto;
        }
        
        //��ǰҳ��ͬ��Ϣȡ��
        List<IG499Info> entityItemCompactVWInfoList=new ArrayList<IG499Info>();
        int fromCount = pDto.getFromCount();
        int pageDispCount = pDto.getPageDispCount();
        for (int i = fromCount; i < entityItemCompactVWInfoListB.size()&&i<fromCount+pageDispCount; i++) {
            entityItemCompactVWInfoList.add(entityItemCompactVWInfoListB.get(i));
        }
        
        pDto.setTotalCount(totalCount);
        
        dto.setEntityItemCompactVWInfoList(entityItemCompactVWInfoList);

        dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
        log.debug("========��ͬͳ�Ʋ�ѯ����========");
        return dto;
    }
    
	public static Date stringToDate(String dstr){
        String str = dstr;
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        Date date = null;
        try {
            date = format.parse(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }
	
	/**
	 * ��ͬ���������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGASM04DTO intiIGASM0420Action(IGASM04DTO dto) throws BLException {
		//����������������������
		List<IG499Info> entityItemCompactVWInfoList = this.ig499BL.searchIG499Info(dto.getEntityItemCompactVWSearchCond(), 0, 0);
		//��ͬ����δ��ɵ���Ϣȡ��
        List<IG499Info> entityItemCompactVWInfoListB=new ArrayList<IG499Info>();
        for (IG499Info entityItemCompactVWInfo : entityItemCompactVWInfoList) {
            if(entityItemCompactVWInfo.getEiversion()!=0){
                entityItemCompactVWInfoListB.add(entityItemCompactVWInfo);
            }
        }
		//�������ݴ���dto
		dto.setReportDataList(entityItemCompactVWInfoListB);
		return dto;
	}
}