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
import com.deliverik.framework.soc.asset.model.condition.SOC0118SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0119SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCondImpl;
import com.deliverik.framework.soc.asset.model.entity.SOC0107TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0109TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0118TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0119TB;
import com.deliverik.framework.user.bl.task.OrganizationBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.condition.OrganizationSearchCondImpl;
import com.deliverik.framework.utility.BLErrorType;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.asset.dto.IGASM08DTO;
import com.deliverik.infogovernor.asset.form.IGASM0802Form;
import com.deliverik.infogovernor.asset.form.IGASM0804Form;
import com.deliverik.infogovernor.asset.form.IGASM0807Form;
import com.deliverik.infogovernor.asset.form.IGASM0812Form;
import com.deliverik.infogovernor.util.CodeDefine;

/**
 * Ӧ�����ù���ҵ���߼�ʵ��
 *
 */
public class IGASM08BLImpl extends BaseBLImpl implements IGASM08BL {

	static Log log = LogFactory.getLog(IGASM08BLImpl.class);

	/** �汾��������ʶ */
	public static final String SAVE_VERSION_UP = "1";

	/** �汾�Ų�������ʶ */
	public static final String SAVE_VERSION = "0";
	
	public static final String  EIRRELATIONCODE="'002-003','003-003','003-005','003-006','003-011','003-010','003-001','012-003','013-003'";
	
	/** �ļ��ϴ�BL */
	protected FileUploadBL fileUploadBL;
	
	/** �ʲ�������ϵ��������BL */
	protected CodeDetailBL codeDetailBL;
	
	/** ����BL */
	protected OrganizationBL organizationBL;
	
	
	/** �û���ɫBL */
	protected UserRoleBL userRoleBL;
	
	protected SOC0117BL soc0117BL;
	
	protected SOC0118BL soc0118BL;
	
	protected SOC0107BL soc0107BL;
	
	protected SOC0119BL soc0119BL;
	
	protected SOC0151BL soc0151BL;
	
	protected SOC0109BL soc0109BL;
	
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}
	
	
	public void setOrganizationBL(OrganizationBL organizationBL) {
		this.organizationBL = organizationBL;
	}
	
	public void setFileUploadBL(FileUploadBL fileUploadBL) {
		this.fileUploadBL = fileUploadBL;
	}

	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
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

	public void setSoc0151BL(SOC0151BL soc0151BL) {
		this.soc0151BL = soc0151BL;
	}

	public void setSoc0109BL(SOC0109BL soc0109BL) {
		this.soc0109BL = soc0109BL;
	}

	/**
	 * Ӧ����Ϣ��ѯ����
	 *
	 * @param dto IGASM08DTO
	 * @return IGASM08DTO
	 */
	public IGASM08DTO searchEntityItemAction(IGASM08DTO dto) throws BLException {

		log.debug("========Ӧ����Ϣ��ѯ������ʼ========");
		
		//Ӧ����Ϣ��ѯ����ȡ�� 
		int totalCount = this.soc0118BL.getEntityItemVWSearchCount(dto.getEntityItemVWSearchCond());
		
		if (totalCount == 0) {
			log.debug("========Ӧ����Ϣ��ѯ���ݲ�����========");
			//Ӧ����Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========Ӧ����Ϣ��ѯ���ݼ�������========");
			//Ӧ����Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();

		//��ǰҳӦ����Ϣȡ��
		List<SOC0124Info> entityItemVWInfoList = this.soc0118BL.searchEntityItemVW(dto.getEntityItemVWSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setEntityItemVWInfoList(entityItemVWInfoList);

		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========Ӧ����Ϣ��ѯ��������========");
		return dto;
	}
	
	/**
	 * Ӧ����Ϣ�ǼǴ���
	 *
	 * @param dto IGASM08DTO
	 * @return IGASM08DTO
	 */
	public IGASM08DTO insertEntityItemAction(IGASM08DTO dto) throws BLException {
		log.debug("========Ӧ����Ϣ�ǼǴ�����ʼ========");
		//����Formȡ��
		IGASM0802Form form = dto.getIgasm0802Form();
		
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
		if (!entity.getEcategory().equals(CommonDefineUtils.ENTIY_CATEGORY_APPLICATION)) {
			//Ӧ����������
			throw new BLException(BLErrorType.ENTITY_CATEGORY_ERROR,
					"IGCO10000.E011","Ӧ��");
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

		//Ӧ����Ϣ��¼
		SOC0118Info entityItem = this.soc0118BL.registEntityItem(dto.getIgasm0802Form());
		
		form.setEiidStr(entityItem.getEiid().toString());
		
		dto.setIgasm0802Form(form);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "Ӧ�û�����Ϣ") );

		log.debug("========Ӧ����Ϣ�ǼǴ�������========");
		return dto;
	}

	/**
	 * Ӧ����Ϣɾ������
	 *
	 * @param dto IGASM08DTO
	 * @return IGASM08DTO
	 */
	public IGASM08DTO deleteEntityItemAction(IGASM08DTO dto) throws BLException {
		log.debug("========Ӧ����Ϣɾ��������ʼ========");
		
		for( int i=0;i<dto.getDeleteEntityItem().length;i++ ){
			String eiid = dto.getDeleteEntityItem()[i];
			
			//ɾ��ǰɾ������Ӧ��ȷ��
			SOC0118Info entityItem = this.soc0118BL.searchEntityItemByKey(Integer.parseInt(eiid));
			
			if (entityItem == null){
				throw new BLException("IGCO10000.E004","ɾ������Ӧ�û���");
			}

			//Ӧ��ɾ��
			this.soc0118BL.deleteEntityItem(entityItem);
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I006","Ӧ����Ϣ"));

		log.debug("========Ӧ����Ϣɾ����������========");
		return dto;
	}

	/**
	 * Ӧ��������Ϣ�༭������ڻ�����
	 *
	 * @param dto IGASM08DTO
	 * @return IGASM08DTO
	 */
	public IGASM08DTO initIGASM0804Action(IGASM08DTO dto) throws BLException {

		log.debug("========Ӧ��������Ϣ�༭������ڻ�������ʼ========");
		
		IGASM0804Form form = dto.getIgasm0804Form();
		
		//Ӧ����Ϣ����
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(
				Integer.parseInt(form.getEiid()));
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","Ӧ��");
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
		//Ӧ��������Ϣ��ѯ����ȡ�� 
		int totalCount = this.soc0107BL.getConfigItemVWSearchCount(form);
		
		if (totalCount == 0) {
			log.debug("========Ӧ��������Ϣ��ѯ���ݲ�����========");
			//Ӧ��������Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I007",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========Ӧ��������Ϣ��ѯ���ݼ�������========");
			//Ӧ��������Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//Ӧ��������Ϣȫ����ѯ
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


		
		log.debug("========Ӧ��������Ϣ�༭������ڻ���������========");
		return dto;
	}
	
	/**
	 * Ӧ��������Ϣ�༭����
	 *
	 * @param dto IGASM08DTO
	 * @return IGASM08DTO
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public IGASM08DTO editEntityItemAction(IGASM08DTO dto) throws BLException, FileNotFoundException, IOException {
		log.debug("========Ӧ��������Ϣ�༭������ʼ========");
		//�汾������
		IGASM0804Form form = dto.getIgasm0804Form();
		
		//Ӧ�û�����Ϣ����
		SOC0118TB entityItem = (SOC0118TB) this.soc0118BL.searchEntityItemByKey(Integer.parseInt(form.getEiid()));
		
		// ȡ�ð汾�Ƿ�������ʶ
		String ident = form.getIdent();
		if(StringUtils.isEmpty(ident)){
			ident = IGASM08BLImpl.SAVE_VERSION;
		}
		// �汾�ų�ʼ��
		int version = 1;
		boolean versonFlag = false;
		// �ж��Ƿ������汾��
		// =====================>> �޸� start
		if (IGASM08BLImpl.SAVE_VERSION_UP.equals(ident)) { // �����汾��
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
		} else if (IGASM08BLImpl.SAVE_VERSION.equals(ident)) { // �������汾��

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
		
		//Ӧ��״̬
//		entityItem.setEistatus(form.getEistatus());
		//Ӧ�ð汾
		entityItem.setEiversion(version);
		
		//Ӧ��˵��
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
			eircond1.setEirrelationcode(IGASM08BLImpl.EIRRELATIONCODE);
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
		
		//Ӧ��������Ϣ����
		if (form.getCiid() != null && form.getCiid().length > 0 ) {
			
			for( int i=0 ; i < form.getCiid().length; i++ ){
				SOC0107TB configItem = new SOC0107TB();
				//Ӧ��ID
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
						e.setPareid(entityItem.getEid().toString());
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
					log.debug("�ʲ������[�ʲ�����ID:" + form.getCid()[i] + "]���봦���ɹ���");
					
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
					if (IGASM08BLImpl.SAVE_VERSION_UP.equals(ident)) { // �����汾��

						configItem = (SOC0107TB) this.soc0107BL.registSOC0107(configItem);

					} else if (IGASM08BLImpl.SAVE_VERSION.equals(ident)) { // �������汾��
					
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
						e.setPareid(entityItem.getEid().toString());
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
					log.debug("�ʲ������[�ʲ�����ID:" + form.getCid()[i] + "]���´����ɹ���");
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
						//Ӧ��ID
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
	
		dto.addMessage(new ActionMessage("IGCO10000.I005","Ӧ��������Ϣ"));
		
		log.debug("========Ӧ��������Ϣ�༭��������========");
		
		return dto;
	}

	/**
	 * Ӧ��������Ϣ��ʷ��¼������ڻ�����
	 *
	 * @param dto IGASM08DTO
	 * @return IGASM08DTO
	 */
	public IGASM08DTO initIGASM0805Action(IGASM08DTO dto) throws BLException {
		log.debug("========Ӧ��������Ϣ��ʷ��¼������ڻ�������ʼ========");
		
		//Ӧ����Ϣ����
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(
				dto.getIgasm0805Form().getEiid());
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","Ӧ��");
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
		
		if ((dto.getIgasm0805Form().getCiversion())!=null) {
			dto.getIgasm0805Form().setCiversion(String.valueOf(entityItemVWInfo.getEiversion()));
		}
		//��ȡ��ʷ�汾����ʱ��
		dto.setConfigItemVersionTime(this.soc0118BL.searchVersionUpdateTime(dto.getIgasm0805Form().getEiid()));
		
		//�жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(), entityItemVWInfo);

		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}else{
			dto.setFlag(flag);
		}
		
		log.debug("========Ӧ��������Ϣ��ʷ��¼������ڻ���������========");
		return dto;
	}

	/**
	 * Ӧ�ù�ϵ����������ڻ�����
	 *
	 * @param dto IGASM08DTO
	 * @return IGASM08DTO
	 */
	public IGASM08DTO initIGASM0806Action(IGASM08DTO dto) throws BLException {
		log.debug("========Ӧ�ù�ϵ����������ڻ�������ʼ========");
		
		//Ӧ����Ϣ����
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(
				Integer.parseInt(dto.getIgasm0806Form().getEiid()));
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","Ӧ��");
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
		if((dto.getIgasm0806Form().getEiid())!=null){
		parcond.setPareiid(Integer.parseInt(dto.getIgasm0806Form().getEiid()));}
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
		//Ӧ�ù�ϵ��Ϣ��ѯ����ȡ�� 
		int totalCount = this.soc0119BL.getEntityItemRelationSearchCount(parcond);
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========Ӧ�ù�ϵ��Ϣ��ѯ���ݼ�������========");
			//Ӧ�ù�ϵ��Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		if ( totalCount>0 ) {
			//Ӧ�ù�ϵ��Ϣȫ������
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
//		cldcond.setCldeiid(dto.getIgasm0806Form().getEiid());
//		cldcond.setCldversion(entityItemVWInfo.getEiversion().toString());
//		cldcond.setCldsmallversion(entityItemVWInfo.getEismallversion().toString());
//		cldcond.setDeleteflag("0");
//		
//		//Ӧ�ù�ϵ��Ϣ��ѯ����ȡ�� 
//		totalCount = this.soc0119BL.getIG313InfoSearchCount(cldcond);
//		
//		if ( totalCount > dto.getMaxSearchCount() ) {
//			log.debug("========Ӧ�ù�ϵ��Ϣ��ѯ���ݼ�������========");
//			//Ӧ�ù�ϵ��Ϣ��ѯ���ݼ�������
//			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
//			return dto;
//		}
//
//		//Ӧ�ù�ϵ��Ϣȫ������
//		List<SOC0119Info> cldEntityItemRelationList = 
//			this.soc0119BL.searchMaxEntityItemRelation(
//					cldcond);
		
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

		log.debug("========Ӧ�ù�ϵ����������ڻ���������========");
		return dto;
	}
	
	/**
	 * Ӧ�ù�ϵɾ������
	 *
	 * @param dto IGASM08DTO
	 * @return IGASM08DTO
	 */
	public IGASM08DTO deleteEntityItemRelationAction(IGASM08DTO dto) throws BLException {
		log.debug("========Ӧ�ù�ϵɾ��������ʼ========");
		
		for( int i=0;i<dto.getDeleteEntityItemRelation().length;i++ ){
			String eirid = dto.getDeleteEntityItemRelation()[i];
			
			SOC0119Info entityItemRelation = 
				this.soc0119BL.searchEntityItemRelationByKey(Integer.parseInt(eirid));
			
			if (entityItemRelation == null){
				throw new BLException("IGCO10000.E004","ɾ������Ӧ�ù�ϵ");
			}

			this.soc0119BL.deleteEntityItemRelation(entityItemRelation);
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I006","Ӧ�ù�ϵ��Ϣ"));

		log.debug("========Ӧ�ù�ϵɾ����������========");
		return dto;
	}

	/**
	 * Ӧ�ù�ϵ�ǼǴ���
	 *
	 * @param dto IGASM08DTO
	 * @return IGASM08DTO
	 */
	public IGASM08DTO insertEntityItemRelationAction(IGASM08DTO dto) throws BLException {
		log.debug("========Ӧ�ù�ϵ�ǼǴ�����ʼ========");
		
		IGASM0807Form form = dto.getIgasm0807Form();
		
		//Ӧ��ID���ӣ�ȡ��
		SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
		
		cond.setElabel(form.getElabel());
		cond.setEilabel(form.getEilabel());
		
		List<SOC0124Info> entityItemVWList = this.soc0118BL.searchEntityItemVW(cond, 0, 0);
		
		if ( entityItemVWList==null || entityItemVWList.size() == 0 ) {
			throw new BLException("IGCO10000.E004","(�ʲ����=" + form.getElabel() + ",Ӧ�ñ��=" 
					+ form.getEilabel() + ")Ӧ��");
		}
		
		form.setCldeiid(entityItemVWList.get(0).getEiid());
		form.setCldeid(entityItemVWList.get(0).getEid());
		form.setCldversion(entityItemVWList.get(0).getEiversion());
		form.setCldsmallversion(entityItemVWList.get(0).getEismallversion());
		//Ӧ��ID�������ͣ��ӣ����
		if (form.getPareiid().intValue() == form.getCldeiid().intValue()) {
			//Ӧ��ID������= ���ӣ�
			throw new BLException(BLErrorType.ENTITY_ITEM_RELATION_ERROR,
					"IGCO10000.E012","Ӧ��");
		}
		
		//����ʱ���趨
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

		form.setEirupdtime(datetime);
		
		//�ʲ���ϵ�Ǽ�
		SOC0119Info ret = 
			this.soc0119BL.registEntityItemRelation(dto.getIgasm0807Form());
		
		dto.setEntityItemRelation(ret);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "Ӧ�ù�ϵ��Ϣ") );
		
		log.debug("========Ӧ�ù�ϵ�ǼǴ�������========");
		return dto;
	}
	
	/**
	 * Ӧ�ù�ϵ�༭������ڻ�����
	 *
	 * @param dto IGASM08DTO
	 * @return IGASM08DTO
	 */
	public IGASM08DTO initIGASM0807Action(IGASM08DTO dto) throws BLException {
		log.debug("========Ӧ�ù�ϵ�༭������ڻ�������ʼ========");
		
		IGASM0807Form form = dto.getIgasm0807Form();
		SOC0119TB ret = 		
			(SOC0119TB) this.soc0119BL.searchEntityItemRelationByKey(
				form.getEirid());
		
		if ( ret == null ){
			throw new BLException("IGCO10000.E004","�༭����Ӧ�ù�ϵ");
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
		
		log.debug("========Ӧ�ù�ϵ�༭������ڻ���������========");
		return dto;
	}

	/**
	 * Ӧ�ù�ϵ�����������
	 *
	 * @param dto IGASM08DTO
	 * @return IGASM08DTO
	 */
	public IGASM08DTO updateEntityItemRelationAction(IGASM08DTO dto) throws BLException {
		log.debug("========Ӧ�ù�ϵ�������������ʼ========");
		IGASM0807Form form = dto.getIgasm0807Form();

		//����ʱ���趨
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

		form.setEirupdtime(datetime);
		
		this.soc0119BL.updateEntityItemRelation(form);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "Ӧ�ù�ϵ��Ϣ") );

		log.debug("========Ӧ�ù�ϵ���������������========");
		return dto;
	}
	
	/**
	 *	��ȡӦ�ù�����ϵ����
	 *
	 * @param dto IGASM08DTO
	 * @return IGASM08DTO
	 */
	public IGASM08DTO searchRelationListAction(IGASM08DTO dto) throws BLException {
		log.debug("========��ȡӦ�ù�����ϵ������ʼ========");
		List<LabelValueBean> list = this.codeDetailBL.searchLabelValueBeanList(CommonDefineUtils.ENTIY_CATEGORY_APPLICATION,CodeDefine.getCodeDefine("ENTITY_ITEM_RELATION_CODE").getCcid());
		dto.setRelationList(list);
		log.debug("========��ȡӦ�ù�����ϵ��������========");
		return dto;
	}
	

	/**
	 *Ӧ����Ϣ�޸ĳ�����ʾ����
	 *
	 * @param dto IGASM08DTO
	 * @return IGASM08DTO
	 */
	public IGASM08DTO initEntityItem(IGASM08DTO dto) throws BLException {

		log.debug("========Ӧ����Ϣ�༭���������ʾ������ʼ========");
		
		IGASM0812Form form = dto.getIgasm0812Form();
		
		//��ʾ���ʲ���Ϣȡ��
		SOC0124Info entityItem = this.soc0118BL.searchEntityItemVWByKey(form.getEiid());
		
		if ( entityItem == null ){
			throw new BLException("IGCO10000.E004","���Ӧ�û���");
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
		boolean isRoleManager = this.userRoleBL.checkRoleManagerByType(dto.getUser().getUserid(), EntityCategory.ROLE_TYPE_APPLICATION);
		form.setRoleManager(isRoleManager);
		form.setPermission(permission);
		
		dto.setIgasm0812Form(form);
		
		//dto.addMessage(new ActionMessage("IGCO10000.I001","Ӧ�û�����Ϣ"));
		if(!permission) {
			dto.addMessage(new ActionMessage("IGCO10000.E023","�޸�"));
		}
		log.debug("========Ӧ����Ϣ�༭���������ʾ��������========");
		return dto;
	}
	/**
	 *Ӧ����Ϣ�޸Ĵ���
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM08DTO updateEntityItem(IGASM08DTO dto) throws BLException {
		
		log.debug("========Ӧ����Ϣ�༭���������ʾ������ʼ========");
		
		IGASM0812Form form = dto.getIgasm0812Form();
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
		dto.addMessage(new ActionMessage("IGCO10000.I005","Ӧ�û�����Ϣ"));
		log.debug("========Ӧ����Ϣ�༭���������ʾ��������========");
		return dto;
	}
	
	/**
	 * ��ȡӦ�ñ�����ֵ
	 *
	 * @param dto IGASM08DTO
	 * @return IGASM08DTO
	 */
	public IGASM08DTO searchEntityItemLableAction(IGASM08DTO dto) throws BLException {
		
		log.debug("========��ȡӦ�ñ�����ֵ������ʼ========");
		
		IGASM0802Form form = dto.getIgasm0802Form();
		
		SOC0118SearchCondImpl cond = new SOC0118SearchCondImpl();
		
		cond.setEilabel(CommonDefineUtils.ENTIY_CATEGORY_APPLICATION_KEY + IGStringUtils.getCurrentYear().substring(2));
		
		String eilabel = this.soc0118BL.searchNextEntityItemLable(cond);
		
		form.setEilabel(eilabel);
		
		log.debug("========��ȡӦ�ñ�����ֵ��������========");
		return dto;
	}
	
	/**
	 * �жϵ�½�û��Ƿ���Ӧ���ʲ�������ɫ������
	 * 
	 * @param dto IGASM08DTO
	 * @return IGASM08DTO
	 * @throws BLException 
	 */
	public IGASM08DTO checkEntityItemDomain(IGASM08DTO dto) throws BLException{
		boolean isRoleManager = this.userRoleBL.checkRoleManagerByType(dto.getUser().getUserid(), EntityCategory.ROLE_TYPE_APPLICATION);
		
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
			entityCond.setEsyscoding(CommonDefineUtils.ENTIY_CATEGORY_APPLICATION_SYSCODING);
			List<SOC0117Info> entity = this.soc0117BL.searchEntity(entityCond, 0, 0);
			
			if(entity.size() != 1) {
				throw new BLException("IGCO10000.E004","Ӧ��ģ��");
			} else {
				dto.setEname(entity.get(0).getEname());
				dto.setEsyscoding(entity.get(0).getEsyscoding());
			}
		}
		
		dto.setFlag(isRoleManager);
		
		return dto;
	}
}