package com.deliverik.infogovernor.asset.bl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
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
import com.deliverik.framework.asset.bl.task.IG013BL;
import com.deliverik.framework.asset.bl.task.IG117BL;
import com.deliverik.framework.asset.bl.task.IG225BL;
import com.deliverik.framework.asset.bl.task.IG313BL;
import com.deliverik.framework.asset.bl.task.IG545BL;
import com.deliverik.framework.asset.bl.task.IG800BL;
import com.deliverik.framework.asset.model.IG002Info;
import com.deliverik.framework.asset.model.IG013Info;
import com.deliverik.framework.asset.model.IG117Info;
import com.deliverik.framework.asset.model.IG225Info;
import com.deliverik.framework.asset.model.IG313Info;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.asset.model.IG800Info;
import com.deliverik.framework.asset.model.condition.IG013SearchCondImpl;
import com.deliverik.framework.asset.model.condition.IG117SearchCondImpl;
import com.deliverik.framework.asset.model.condition.IG225SearchCondImpl;
import com.deliverik.framework.asset.model.condition.IG313SearchCondImpl;
import com.deliverik.framework.asset.model.condition.IG688SearchCondImpl;
import com.deliverik.framework.asset.model.condition.IG800SearchCondImpl;
import com.deliverik.framework.asset.model.entity.IG013TB;
import com.deliverik.framework.asset.model.entity.IG225TB;
import com.deliverik.framework.asset.model.entity.IG313TB;
import com.deliverik.framework.asset.model.entity.IG800TB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.bl.FileUploadBL;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;
import com.deliverik.framework.user.bl.task.OrganizationBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.condition.OrganizationSearchCondImpl;
import com.deliverik.framework.utility.BLErrorType;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.asset.dto.IGASM17DTO;
import com.deliverik.infogovernor.asset.form.IGASM1702Form;
import com.deliverik.infogovernor.asset.form.IGASM1704Form;
import com.deliverik.infogovernor.asset.form.IGASM1707Form;
import com.deliverik.infogovernor.asset.form.IGASM1712Form;
import com.deliverik.infogovernor.util.CodeDefine;

/**
 * ������ù���ҵ���߼�ʵ��
 *
 */
public class IGASM17BLImpl extends BaseBLImpl implements IGASM17BL {

	static Log log = LogFactory.getLog(IGASM17BLImpl.class);

	/** �汾��������ʶ */
	public static final String SAVE_VERSION_UP = "1";

	/** �汾�Ų�������ʶ */
	public static final String SAVE_VERSION = "0";
	
	public static final String EIRRELATIONCODE="'012-012','012-001','012-001','012-006','012-003','012-012'";
	
	public static final String DEVICE_DEVICE = "001-001";
	
	public static final String DEVICE_DEVICE_CONN_ID = "1";
	
	/** �ʲ���ϢBL */
	protected IG117BL ig117BL;

	/** ��������ϢBL */
	protected IG013BL ig013BL;
	
	/** �ʲ�������BL */
	protected IG800BL ig800BL;
	
	/** �������ϵBL */
	protected IG313BL ig313BL;
	
	/** �ļ��ϴ�BL */
	protected FileUploadBL fileUploadBL;
	
	/** �ʲ�������ϵ��������BL */
	protected CodeDetailBL codeDetailBL;
	
	/** �ʲ�ȡֵ��Χ��������BL */
	protected IG545BL ig545BL;
	
	/** ����BL */
	protected OrganizationBL organizationBL;
	
	/** ������BL */
	protected IG225BL ig225BL;
	
	/** �û���ɫBL */
	protected UserRoleBL userRoleBL;
	
	public void setOrganizationBL(OrganizationBL organizationBL) {
		this.organizationBL = organizationBL;
	}
	
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}
	
	public void setIg225BL(IG225BL ig225BL) {
		this.ig225BL = ig225BL;
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
	
	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}
	
	public void setIg545BL(
			IG545BL ig545BL) {
		this.ig545BL = ig545BL;
	}
	/**
	 * �����Ϣ��ѯ����
	 *
	 * @param dto IGASM17DTO
	 * @return IGASM17DTO
	 */
	public IGASM17DTO searchEntityItemAction(IGASM17DTO dto) throws BLException {

		log.debug("========�����Ϣ��ѯ����ʼ========");
		
		//�����Ϣ��ѯ����ȡ�� 
		int totalCount = this.ig013BL.getIG688InfoSearchCount(dto.getEntityItemVWSearchCond());
		
		if (totalCount == 0) {
			log.debug("========�����Ϣ��ѯ���ݲ�����========");
			//�����Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========�����Ϣ��ѯ���ݼ�������========");
			//�����Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();

		//��ǰҳ�����Ϣȡ��
		List<IG688Info> entityItemVWInfoList = this.ig013BL.searchIG688Info(dto.getEntityItemVWSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setEntityItemVWInfoList(entityItemVWInfoList);

		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========�����Ϣ��ѯ��������========");
		return dto;
	}
	
	/**
	 * �����Ϣ�ǼǴ���
	 *
	 * @param dto IGASM17DTO
	 * @return IGASM17DTO
	 */
	public IGASM17DTO insertEntityItemAction(IGASM17DTO dto) throws BLException {
		log.debug("========�����Ϣ�ǼǴ���ʼ========");
		//����Formȡ��
		IGASM1702Form form = dto.getIgasm1702Form();
		
		form.setEidStr(form.getEid().toString());
		
		//����ʱ���趨
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		
		form.setEiupdtime(datetime);
		
		//��汾�趨���̶���Ϊ0��
		form.setEiversion(0);
		
		//С�汾�趨���̶���Ϊ0��
		form.setEismallversion(0);

		//�����Ϣ��¼
		IG013Info entityItem = this.ig013BL.registIG013Info(dto.getIgasm1702Form());
		
		IG313TB eir = new IG313TB();
		eir.setPareid(entityItem.getEid());
		eir.setPareiid(entityItem.getEiid());
		eir.setParversion(0);
		eir.setParsmallversion(0);
		String deviceEid = dto.getIgasm1702Form().getDeviceEid();
		String moduleEid = dto.getIgasm1702Form().getModuleEid();
		if(StringUtils.isNotEmpty(deviceEid)){//�����豸
			eir.setCldeid(Integer.parseInt(deviceEid));
			eir.setCldeiid(Integer.parseInt(dto.getIgasm1702Form().getDeviceEiid()));
			IG013Info ei = this.ig013BL.searchIG013InfoByKey(eir.getCldeiid());
			eir.setCldversion(ei.getEiversion());
			eir.setCldsmallversion(ei.getEismallversion());
			eir.setEirrelation(CommonDefineUtils.MODULE_RELATION_ENTIY_ID);
			eir.setEirrelationcode(CommonDefineUtils.MODULE_RELATION_ENTIY_CODE);
			eir.setEirinfo("#" + eir.getCldeiid() + "#");//�����豸ID
		}else if(StringUtils.isNotEmpty(moduleEid)){//�������
			eir.setCldeid(Integer.parseInt(moduleEid));
			eir.setCldeiid(Integer.parseInt(dto.getIgasm1702Form().getModuleEiid()));
			IG013Info ei = this.ig013BL.searchIG013InfoByKey(eir.getCldeiid());
			eir.setCldversion(ei.getEiversion());
			eir.setCldsmallversion(ei.getEismallversion());
			//��ѯ��������豸ID
			IG313SearchCondImpl cond = new IG313SearchCondImpl();
			cond.setPareiid(eir.getCldeiid());
			//���������ϵ
			cond.setEirrelation(CommonDefineUtils.MODULE_RELATION_MODULE_ID);
			cond.setDeleteflag("0");
			//�������������eiinfo�е�#�����豸ID#
			List<IG313Info> list = this.ig313BL.searchMaxIG313Info(cond);
			if(list.isEmpty()) {
				//�豸������ϵ
				cond.setEirrelation(CommonDefineUtils.MODULE_RELATION_ENTIY_ID);
				list = this.ig313BL.searchMaxIG313Info(cond);
			}
			if(list.size() != 1) {
				throw new BLException("IGCO10000.E004","��ѡ��������豸����");
			}
			eir.setEirrelation(CommonDefineUtils.MODULE_RELATION_MODULE_ID);
			eir.setEirrelationcode(CommonDefineUtils.MODULE_RELATION_MODULE_CODE);
			eir.setEirinfo(list.get(0).getEirinfo());//�����豸ID
		}
		eir.setEirupdtime(datetime);
		eir.setEirstatus("C");
		eir.setEirdesc("�������"+form.getEiname()+"����������ϵ");
		this.ig313BL.registIG313Info(eir);
		
		form.setEiidStr(entityItem.getEiid().toString());
		
		dto.setIgasm1702Form(form);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "���������Ϣ") );

		log.debug("========�����Ϣ�ǼǴ�������========");
		return dto;
	}

	/**
	 * �����Ϣɾ������
	 *
	 * @param dto IGASM17DTO
	 * @return IGASM17DTO
	 */
	public IGASM17DTO deleteEntityItemAction(IGASM17DTO dto) throws BLException {
		log.debug("========�����Ϣɾ������ʼ========");
		List<Integer> retList = new ArrayList<Integer>();//�ݹ�ɾ�������û�ѡ��ɾ�������ظ�
		for( int i=0;i<dto.getDeleteEntityItem().length;i++ ){
			String eiid = dto.getDeleteEntityItem()[i];
			if(!retList.contains(Integer.parseInt(eiid))){
				cycleDelete (eiid,retList);
			}
		}
		for(Integer eiid : retList){
			//ɾ��ǰɾ���������ȷ��
			IG013Info entityItem = this.ig013BL.searchIG013InfoByKey(eiid);
			
			if (entityItem == null){
				throw new BLException("IGCO10000.E004","ɾ���������");
			}
			//���ɾ��
			this.ig013BL.deleteIG013Info(entityItem);
		}
		dto.addMessage(new ActionMessage("IGCO10000.I006","�����Ϣ"));

		log.debug("========�����Ϣɾ����������========");
		return dto;
	}
	
	//�ݹ�ɾ��������������
	private List<Integer> cycleDelete (String eiid,List<Integer> retList) throws BLException{
		
		IG313SearchCondImpl parcond = new IG313SearchCondImpl();
		if(eiid!=null){
		parcond.setCldeiid(Integer.parseInt(eiid));}
		parcond.setDeleteflag("0");
		//������ϵ
		parcond.setEirrelation(CommonDefineUtils.MODULE_RELATION_MODULE_ID);
		//����ָ������µ��������������ݹ����
		List<IG313Info> list = this.ig313BL.searchMaxIG313Info(parcond);
		for(IG313Info eir : list){
			this.cycleDelete(eir.getPareiid()+"",retList);
		}
		if(!retList.contains(Integer.parseInt(eiid))){
			retList.add(Integer.parseInt(eiid));
		}
		return retList;
	}


	/**
	 * ���������Ϣ�༭������ڻ�����
	 *
	 * @param dto IGASM17DTO
	 * @return IGASM17DTO
	 */
	public IGASM17DTO initIGASM1704Action(IGASM17DTO dto) throws BLException {

		log.debug("========���������Ϣ�༭������ڻ�����ʼ========");
		
		IGASM1704Form form = dto.getIgasm1704Form();
		
		//�����Ϣ����
		IG688Info entityItemVWInfo = this.ig013BL.searchIG688InfoByKey(
				form.getEiid());
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","���");
		}
		
		form.setEidesc(entityItemVWInfo.getEidesc());
//		form.setEistatus(entityItemVWInfo.getEistatus());
		form.setEsyscoding_q(entityItemVWInfo.getEsyscoding());
		dto.setEntityItemVWInfo(entityItemVWInfo);
		//�жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
		Boolean flag = this.ig013BL.checkIG688InfoDomain(dto.getUser(), entityItemVWInfo);

		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}else{
			dto.setFlag(flag);
		}
		//���������Ϣ��ѯ����ȡ�� 
		int totalCount = this.ig800BL.getIG002InfoSearchCount(form);
		
		if (totalCount == 0) {
			log.debug("========���������Ϣ��ѯ���ݲ�����========");
			//���������Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I007",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========���������Ϣ��ѯ���ݼ�������========");
			//���������Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//���������Ϣȫ����ѯ
		List<IG002Info> configItemVWInfoList = this.ig800BL.searchIG002Info(
				form, 0, 0);
		
		String[] civalue = new String[totalCount];
		String[] delfile = new String[totalCount];
		String[] entityItemCivalue = new String[totalCount];
		String[] isUpgrade=new String[totalCount];
		//��žɰ汾ֵ
		String[] civalue_bak = new String[totalCount];
		Map<String,List<IG002Info>> map = new LinkedHashMap<String,List<IG002Info>>();
		int i = 0;
		int j = 0;
		List<String> strlist = new ArrayList<String>();
		Map<String, String> cldVersionMap=new HashMap<String, String>();//���ʲ��汾����
		for(IG002Info e : configItemVWInfoList){
			if("4".equals(e.getCattach())){
				String value = e.getCivalue();
				if(StringUtils.isNotEmpty(value)){
					String cldeiid = value.substring(value.lastIndexOf("(")+1, value.length()-1);//���ʲ�eiid
					
					IG313SearchCondImpl cond=new IG313SearchCondImpl();
					cond.setPareiid(form.getEiid());
					if(cldeiid!=null){
					cond.setCldeiid(Integer.parseInt(cldeiid));}
					cond.setParversion(entityItemVWInfo.getEiversion());
					cond.setEirinfo("_"+e.getCiid()+"_");
					cond.setDeleteflag("0");
					List<IG313Info> ig313Info = ig313BL.searchIG313Info(cond);
					String cldversion="";
					if(ig313Info!=null&&ig313Info.size()>0){
						cldversion = String.valueOf(ig313Info.get(0).getCldversion());//���ʲ��汾
					}
					cldVersionMap.put(cldeiid, cldversion);
				}
			}
			if(!map.containsKey(e.getCcategory())){
				map.put(e.getCcategory(), new ArrayList<IG002Info>());
				strlist.add(e.getCcategory());
			}
			map.get(e.getCcategory()).add(e);
			if("2".equals(e.getCattach())){
				List<LabelValueBean> list = ig545BL.searchLabelValueBeanList(e.getCoption());
				form.setSelectedListMap(j++, list);
			}
			if("5".equals(e.getCattach())){
				List<LabelValueBean> list = ig545BL.searchLabelValueBeanList(e.getCoption());
				if(list.size() > 0){
					list.remove(0);
				}
				form.setSelectedListMap(j++, list);
			}
		}
		form.setCldVersionMap(cldVersionMap);
		for(String str : strlist){
			for(IG002Info e : map.get(str)){
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


		
		log.debug("========���������Ϣ�༭������ڻ���������========");
		return dto;
	}
	
	/**
	 * ���������Ϣ�༭����
	 *
	 * @param dto IGASM17DTO
	 * @return IGASM17DTO
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public IGASM17DTO editEntityItemAction(IGASM17DTO dto) throws BLException, FileNotFoundException, IOException {
		log.debug("========���������Ϣ�༭����ʼ========");
		//�汾������
		IGASM1704Form form = dto.getIgasm1704Form();
		
		//���������Ϣ����
		IG013TB entityItem = (IG013TB) this.ig013BL.searchIG013InfoByKey(form.getEiid());
		// ȡ�ð汾�Ƿ�������ʶ
		String ident = form.getIdent();
		if(StringUtils.isEmpty(ident)){
			ident = IGASM17BLImpl.SAVE_VERSION;
		}
		// �汾�ų�ʼ��
		int version = 1;
		boolean versonFlag = false;
		// �ж��Ƿ������汾��
		// =====================>> �޸� start
		if (IGASM17BLImpl.SAVE_VERSION_UP.equals(ident)) { // �����汾��
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
                            IG013TB cldEntityItem = (IG013TB) this.ig013BL.searchIG013InfoByKey(Integer.parseInt(cldeiid));
                            if(cldEntityItem!=null){
                            	 cldeiids[index]=cldeiid+"_"+cldEntityItem.getEiversion()+"_"+cldEntityItem.getEismallversion()+"_"+form.getCiid()[i];
                            }
                        }
                        index++;
                    }
                }
            }
			
			//�ʲ���ϵ��Ϣ�汾��������
			this.ig313BL.upgradeIG313InfoOne(entityItem.getEiid(), entityItem.getEiversion(), entityItem.getEismallversion(),
					version, 0,cldeiids);
			
			if (version - 1 != entityItem.getEiversion()) {
				throw new BLException("IGCO00000.E004");
			}
		} else if (IGASM17BLImpl.SAVE_VERSION.equals(ident)) { // �������汾��

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
		
		//���״̬
//		entityItem.setEistatus(form.getEistatus());
		//����汾
		entityItem.setEiversion(version);
		
		//���˵��
		entityItem.setEidesc(form.getEidesc());

		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		
		//����ʱ��
		entityItem.setEiupdtime(datetime);
		
		this.ig013BL.updateIG013Info(entityItem);
		//=======���¹�ϵ��ʼ========
		if(version ==1&&versonFlag){
			IG313SearchCondImpl eircond1 = new IG313SearchCondImpl();
			//ɾ����ʶ
			eircond1.setDeleteflag("0");
			//����ʲ���صĹ�ϵ��
			eircond1.setEirrelationcode(IGASM17BLImpl.EIRRELATIONCODE);
			eircond1.setEiid(entityItem.getEiid());
			//���ʲ����еĹ�ϵ��Ϣ
			List<IG313Info> ig313InfoList = this.ig313BL.searchMaxIG313Info(eircond1);
			if(ig313InfoList!=null&&ig313InfoList.size()>0){
				for(IG313Info ig313Info:ig313InfoList){
					IG313TB ig313tb=new IG313TB();
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
						this.ig313BL.registIG313Info(ig313tb);
					}
					//�����ϵʱ
					if(entityItem.getEiid().equals(ig313Info.getCldeiid())){
						ig313tb.setCldversion(entityItem.getEiversion());
						this.ig313BL.registIG313Info(ig313tb);
					}
				}
			}
		}
		//=======���¹�ϵ����========
		
		//���ø���BL
		
		//���������Ϣ����
		if (form.getCiid() != null && form.getCiid().length > 0 ) {
			
			for( int i=0 ; i < form.getCiid().length; i++ ){
				IG800TB configItem = new IG800TB();
				//���ID
				configItem.setEiid(form.getEiid());
				//�ʲ�����ID
				configItem.setCid(Integer.parseInt(form.getCid()[i]));
				//����ID
				configItem.setEid(Integer.parseInt(form.getEid()[i]));
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
					configItem = (IG800TB) this.ig800BL.registIG800Info(configItem);
					
					//�������Ϊ�ʲ�ʱ�����ӹ�����ϵ
					if("4".equals(form.getCiattach()[i]) && StringUtils.isNotEmpty(form.getCivalue()[i])){
						IG313TB e = new IG313TB();
						e.setPareid(entityItem.getEid());
						e.setPareiid(entityItem.getEiid());
						e.setParversion(entityItem.getEiversion());
						e.setParsmallversion(entityItem.getEismallversion());
						String str = form.getEntityItemCivalue()[i];
						IG013Info ei = this.ig013BL.searchIG013InfoByKey(Integer.parseInt(str.substring(str.lastIndexOf("(")+1, str.length()-1)));
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
						IG225Info config = this.ig225BL.searchIG225InfoByKey(Integer.parseInt(form.getCid()[i]));
						String cname = config.getCname();
						e.setEirdesc("�������"+cname+"����");
						//����key
						e.setEirinfo(entityItem.getEiid()+"_"+configItem.getCiid()+"_"+ei.getEiid());
						//����״̬ΪC����ϵ�����в���ɾ��
						e.setEirstatus("C");
						this.ig313BL.registIG313Info(e);
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
					if (IGASM17BLImpl.SAVE_VERSION_UP.equals(ident)) { // �����汾��

						configItem = (IG800TB) this.ig800BL.registIG800Info(configItem);

					} else if (IGASM17BLImpl.SAVE_VERSION.equals(ident)) { // �������汾��
					
						Integer ciid = Integer.valueOf(form.getCiid()[i]); 
						
						// ��ѯ��ǰ������
						IG800Info cfi = this.ig800BL.searchIG800InfoByKey(ciid);
						
						// �жϵ�ǰ�������Ƿ���������
						if(configItem.getCid().equals(cfi.getCid())){ // ����������������и���
							
							configItem.setCiid(ciid);
							configItem = (IG800TB) this.ig800BL
								.updateIG800Info(configItem);
							
						}else{  // �����������������
							
							configItem = (IG800TB) this.ig800BL
							.registIG800Info(configItem);
							
						}
					}
					
					//�������Ϊ�ʲ�ʱ�����ӹ�����ϵ
					if("4".equals(form.getCiattach()[i]) && StringUtils.isNotEmpty(form.getCivalue()[i])){
						IG313TB e = new IG313TB();
						e.setPareid(entityItem.getEid());
						e.setPareiid(entityItem.getEiid());
						e.setParversion(entityItem.getEiversion());
						e.setParsmallversion(entityItem.getEismallversion());
						String str = form.getEntityItemCivalue()[i];			
						IG013Info ei = this.ig013BL.searchIG013InfoByKey(Integer.parseInt(str.substring(str.lastIndexOf("(")+1, str.length()-1)));
				
						e.setCldeid(ei.getEid());
						e.setCldeiid(ei.getEiid());
						e.setCldversion(ei.getEiversion());
						e.setCldsmallversion(ei.getEismallversion());
						//У���ϵ�Ƿ����
						IG313SearchCondImpl condPar = new IG313SearchCondImpl();
						condPar.setPareiid(entityItem.getEiid());//�ʲ�ID
						condPar.setParversion(entityItem.getEiversion());//�ʲ���汾
						condPar.setParsmallversion(entityItem.getEismallversion());//�ʲ�С�汾
						condPar.setDeleteflag("0");
						condPar.setEirstatus("C");
						condPar.setEirinfo(entityItem.getEiid()+"_"+form.getCiid()[i]+"_"+ei.getEiid());
						
						List<IG313Info> eirlist = this.ig313BL.searchIG313Info(condPar);
						
						if(eirlist.isEmpty()){
							//ɾ��ԭ�����еĹ�ϵ
							IG313SearchCondImpl eircond = new IG313SearchCondImpl();
							eircond.setEirinfo(entityItem.getEiid()+"_"+form.getCiid()[i]+"_");
							eircond.setEirstatus("C");
							eircond.setDeleteflag("0");
							List<IG313Info> eir = this.ig313BL.searchMaxIG313Info(eircond);
							for (IG313Info entityItemRelation : eir) {
								this.ig313BL.deleteIG313Info(entityItemRelation);
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
							IG225Info config = this.ig225BL.searchIG225InfoByKey(Integer.parseInt(form.getCid()[i]));
							String cname = config.getCname();
							e.setEirdesc("�������"+cname+"����");
							//����key
							e.setEirinfo(entityItem.getEiid()+"_"+configItem.getCiid()+"_"+ei.getEiid());
							//����״̬ΪC����ϵ�����в���ɾ��
							e.setEirstatus("C");
							this.ig313BL.registIG313Info(e);
						} else {
							if(eirlist.size() != 1) {
								throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR, "IGCO10000.E017");
							} else {
								IG313TB eirTB = (IG313TB)SerializationUtils.clone(eirlist.get(0));
								
								eirTB.setEirinfo(eirTB.getEirinfo().replaceAll("_" + form.getCiid()[i] + "_", "_" + configItem.getCiid() + "_"));
								
								this.ig313BL.updateIG313Info(eirTB);
							}
						}
					}
					if("4".equals(form.getCiattach()[i]) && StringUtils.isEmpty(form.getCivalue()[i])){
						//ɾ��ԭ�����еĹ�ϵ
						IG313SearchCondImpl eircond = new IG313SearchCondImpl();
						eircond.setEirinfo(entityItem.getEiid()+"_"+form.getCiid()[i]+"_");
						eircond.setEirstatus("C");
						eircond.setDeleteflag("0");
						List<IG313Info> eir = this.ig313BL.searchMaxIG313Info(eircond);
						for (IG313Info entityItemRelation : eir) {
							this.ig313BL.deleteIG313Info(entityItemRelation);
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
						//���ID
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
						
						this.ig800BL.updateIG800Info(configItem);					
						
					}
				}
			}
			
		}
	
		dto.addMessage(new ActionMessage("IGCO10000.I005","���������Ϣ"));
		
		log.debug("========���������Ϣ�༭��������========");
		
		return dto;
	}

	/**
	 * ���������Ϣ��ʷ��¼������ڻ�����
	 *
	 * @param dto IGASM17DTO
	 * @return IGASM17DTO
	 */
	public IGASM17DTO initIGASM1705Action(IGASM17DTO dto) throws BLException {
		log.debug("========���������Ϣ��ʷ��¼������ڻ�����ʼ========");
		
		//�����Ϣ����
		IG688Info entityItemVWInfo = this.ig013BL.searchIG688InfoByKey(
				dto.getIgasm1705Form().getEiid());
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","���");
		}
		
		if (entityItemVWInfo.getEiversion() == 0 && entityItemVWInfo.getEismallversion() == 0) {
			dto.addMessage(new ActionMessage("IGASM0205.W001"));
		}
		
		dto.setEntityItemVWInfo(entityItemVWInfo);
		
		if ((dto.getIgasm1705Form().getCiversion())!=null) {
			dto.getIgasm1705Form().setCiversion(String.valueOf(entityItemVWInfo.getEiversion()));
		}
		//��ȡ��ʷ�汾����ʱ��
		dto.setConfigItemVersionTime(this.ig013BL.searchVersionUpdateTime(dto.getIgasm1705Form().getEiid()));
		
		//�жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
		Boolean flag = this.ig013BL.checkIG688InfoDomain(dto.getUser(), entityItemVWInfo);

		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}else{
			dto.setFlag(flag);
		}
		log.debug("========���������Ϣ��ʷ��¼������ڻ���������========");
		return dto;
	}

	/**
	 * �����ϵ��������ڻ�����
	 *
	 * @param dto IGASM17DTO
	 * @return IGASM17DTO
	 */
	public IGASM17DTO initIGASM1706Action(IGASM17DTO dto) throws BLException {
		log.debug("========�����ϵ��������ڻ�����ʼ========");
		
		//�����Ϣ����
		IG688Info entityItemVWInfo = this.ig013BL.searchIG688InfoByKey(
				Integer.parseInt(dto.getIgasm1706Form().getEiid()));
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","���");
		}
		
		dto.setEntityItemVWInfo(entityItemVWInfo);
		
		//���������ϵ����
		IG313SearchCondImpl parcond = new IG313SearchCondImpl();
		if((dto.getIgasm1706Form().getEiid())!=null){
		parcond.setPareiid(Integer.parseInt(dto.getIgasm1706Form().getEiid()));}
		parcond.setParversion(entityItemVWInfo.getEiversion());
		parcond.setParsmallversion(entityItemVWInfo.getEismallversion());
		parcond.setDeleteflag("0");
		
		Map<String,List<IG313Info>> parmap = new LinkedHashMap<String,List<IG313Info>>();
		//�жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
		Boolean flag = this.ig013BL.checkIG688InfoDomain(dto.getUser(), entityItemVWInfo);

		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}else{
			dto.setFlag(flag);
		}
		//�����ϵ��Ϣ��ѯ����ȡ�� 
		int totalCount = this.ig313BL.getIG313InfoSearchCount(parcond);
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========�����ϵ��Ϣ��ѯ���ݼ�������========");
			//�����ϵ��Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		if ( totalCount>0 ) {
			//�����ϵ��Ϣȫ������
			List<IG313Info> parEntityItemRelationList = 
				this.ig313BL.searchIG313Info(parcond);
			dto.setParCount(parEntityItemRelationList.size());
			for(IG313Info e : parEntityItemRelationList){
				String key = e.getEirrelationcode().split("-")[0];
				String eirrelationcode = e.getEirrelationcode();
				String ecategory = e.getParEntityItemVW().getEcategory();
				if(!"-".equals(eirrelationcode.replaceAll(ecategory, ""))){
					key = eirrelationcode.replaceAll(ecategory, "").replaceAll("-", "");
				}
					if(!parmap.containsKey(key)){
						parmap.put(key, new ArrayList<IG313Info>());
					}
					((IG313TB)e).setParflag("0");
					parmap.get(key).add(e);
				}
		}
		
		//���������ϵ����
		//������ϵ����
//		IG313SearchCondImpl cldcond = new IG313SearchCondImpl();
//		
//		cldcond.setCldeiid(dto.getIgasm1706Form().getEiid());
//		cldcond.setCldversion(entityItemVWInfo.getEiversion().toString());
//		cldcond.setCldsmallversion(entityItemVWInfo.getEismallversion().toString());
//		cldcond.setDeleteflag("0");
//		
//		//�����ϵ��Ϣ��ѯ����ȡ�� 
//		totalCount = this.ig313BL.getIG313InfoSearchCount(cldcond);
//		
//		if ( totalCount > dto.getMaxSearchCount() ) {
//			log.debug("========�����ϵ��Ϣ��ѯ���ݼ�������========");
//			//�����ϵ��Ϣ��ѯ���ݼ�������
//			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
//			return dto;
//		}
//
//		//�����ϵ��Ϣȫ������
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

		
		log.debug("========�����ϵ��������ڻ���������========");
		return dto;
	}
	
	/**
	 * �����ϵɾ������
	 *
	 * @param dto IGASM17DTO
	 * @return IGASM17DTO
	 */
	public IGASM17DTO deleteEntityItemRelationAction(IGASM17DTO dto) throws BLException {
		log.debug("========�����ϵɾ������ʼ========");
		
		for( int i=0;i<dto.getDeleteEntityItemRelation().length;i++ ){
			
			IG313Info entityItemRelation = 
				this.ig313BL.searchIG313InfoByKey(Integer.parseInt(dto.getDeleteEntityItemRelation()[i]));
			
			if (entityItemRelation == null){
				throw new BLException("IGCO10000.E004","ɾ�����������ϵ");
			}

			this.ig313BL.deleteIG313Info(entityItemRelation);
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I006","�����ϵ��Ϣ"));

		log.debug("========�����ϵɾ����������========");
		return dto;
	}

	/**
	 * �����ϵ�ǼǴ���
	 *
	 * @param dto IGASM17DTO
	 * @return IGASM17DTO
	 */
	public IGASM17DTO insertEntityItemRelationAction(IGASM17DTO dto) throws BLException {
		log.debug("========�����ϵ�ǼǴ���ʼ========");
		
		IGASM1707Form form = dto.getIgasm1707Form();
		
		//���ID���ӣ�ȡ��
		IG688SearchCondImpl cond = new IG688SearchCondImpl();
		
		cond.setElabel(form.getElabel());
		cond.setEilabel(form.getEilabel());
		
		List<IG688Info> entityItemVWList = this.ig013BL.searchIG688Info(cond, 0, 0);
		
		if ( entityItemVWList==null || entityItemVWList.size() == 0 ) {
			throw new BLException("IGCO10000.E004","(�ʲ����=" + form.getElabel() + ",������=" 
					+ form.getEilabel() + ")���");
		}
		
		form.setCldeiid(entityItemVWList.get(0).getEiid());
		form.setCldeid(Integer.parseInt(entityItemVWList.get(0).getEid()));
		form.setCldsmallversion(entityItemVWList.get(0).getEismallversion());//
		form.setCldversion(entityItemVWList.get(0).getEiversion());//

		
		//���ID�������ͣ��ӣ����
		if (form.getPareiid().intValue() == form.getCldeiid().intValue()) {
			//���ID������= ���ӣ�
			throw new BLException(BLErrorType.ENTITY_ITEM_RELATION_ERROR,
					"IGCO10000.E012","���");
		}
		
		//����ʱ���趨
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

		form.setEirupdtime(datetime);
		
		//�ʲ���ϵ�Ǽ�
		IG313Info ret = 
			this.ig313BL.registIG313Info(form);
		
		dto.setEntityItemRelation(ret);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "�����ϵ��Ϣ") );
		
		log.debug("========�����ϵ�ǼǴ�������========");
		return dto;
	}
	
	/**
	 * �����ϵ�༭������ڻ�����
	 *
	 * @param dto IGASM17DTO
	 * @return IGASM17DTO
	 */
	public IGASM17DTO initIGASM1707Action(IGASM17DTO dto) throws BLException {
		log.debug("========�����ϵ�༭������ڻ�����ʼ========");
		
		IGASM1707Form form = dto.getIgasm1707Form();
		IG313TB ret = 		
			(IG313TB) this.ig313BL.searchIG313InfoByKey(
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
		form.setEiname(ret.getCldEntityItemVW().getEiname());
		form.setTempeirrelation(ret.getEirrelation()+"#"+ret.getEirrelationcode());
		form.setMode("1");
		
		log.debug("========�����ϵ�༭������ڻ���������========");
		return dto;
	}

	/**
	 * �����ϵ���������
	 *
	 * @param dto IGASM17DTO
	 * @return IGASM17DTO
	 */
	public IGASM17DTO updateEntityItemRelationAction(IGASM17DTO dto) throws BLException {
		log.debug("========�����ϵ���������ʼ========");
		IGASM1707Form form = dto.getIgasm1707Form();

		//����ʱ���趨
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

		form.setEirupdtime(datetime);
		
		this.ig313BL.updateIG313Info(form);

		dto.addMessage(new ActionMessage( "IGCO10000.I005", "�����ϵ��Ϣ") );

		log.debug("========�����ϵ�������������========");
		return dto;
	}
	
	/**
	 *	��ȡ���������ϵ����
	 *
	 * @param dto IGASM17DTO
	 * @return IGASM17DTO
	 */
	public IGASM17DTO searchRelationListAction(IGASM17DTO dto) throws BLException {
		log.debug("========��ȡ���������ϵ����ʼ========");
		List<LabelValueBean> list = this.codeDetailBL.searchLabelValueBeanList(CommonDefineUtils.ENTIY_CATEGORY_MODULE,CodeDefine.getCodeDefine("ENTITY_ITEM_RELATION_CODE").getCcid());
		for(Iterator<LabelValueBean> iter = list.iterator();iter.hasNext();){
			LabelValueBean bean = (LabelValueBean)iter.next();
			if(bean.getValue().startsWith(CommonDefineUtils.MODULE_RELATION_ENTIY_ID+"#")){
				iter.remove();
			}else if(bean.getValue().startsWith(CommonDefineUtils.MODULE_RELATION_MODULE_ID+"#")){
				iter.remove();
			}
		}
		dto.setRelationList(list);
		log.debug("========��ȡ���������ϵ��������========");
		return dto;
	}
	
	/**
	 *�����Ϣ�޸ĳ�����ʾ����
	 *
	 * @param dto IGASM17DTO
	 * @return IGASM17DTO
	 */
	public IGASM17DTO initEntityItem(IGASM17DTO dto) throws BLException {

		log.debug("========�����Ϣ�༭���������ʾ����ʼ========");
		
		IGASM1712Form form = dto.getIgasm1712Form();
		
		//��ʾ���ʲ���Ϣȡ��
		IG688Info entityItem = this.ig013BL.searchIG688InfoByKey(form.getEiid());
		
		if ( entityItem == null ){
			throw new BLException("IGCO10000.E004","����������");
		}
		
		//������ʾ�趨
		
//		String orgsyscoding = entityItem.getEiorgsyscoding();
		String esyscoding = entityItem.getEsyscoding();
		IG117SearchCondImpl EntityCond = new IG117SearchCondImpl();
		EntityCond.setEsyscoding(esyscoding);
		List<IG117Info> entityList = this.ig117BL.searchIG117Info(EntityCond, 0, 0);
		for (int i = 0; i < entityList.size(); i++) {
			form.setEname(entityList.get(0).getEname());
		}
//		OrganizationSearchCondImpl OrgCond = new OrganizationSearchCondImpl();
//		OrgCond.setOrgsyscoding(orgsyscoding);
		
		form.setEiid(entityItem.getEiid());
		form.setEid(Integer.parseInt(entityItem.getEid()));
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
		boolean permission = this.ig013BL.checkIG688InfoDomain(dto.getUser(), entityItem);
		boolean isRoleManager = this.userRoleBL.checkRoleManagerByType(dto.getUser().getUserid(), EntityCategory.ROLE_TYPE_DEVICE);
		form.setRoleManager(isRoleManager);
		form.setPermission(permission);
		
		dto.setIgasm1712Form(form);
		
		//dto.addMessage(new ActionMessage("IGCO10000.I001","���������Ϣ"));
		if(!permission) {
			dto.addMessage(new ActionMessage("IGCO10000.E023","�޸�"));
		}
		log.debug("========�����Ϣ�༭���������ʾ��������========");
		return dto;
	}
	/**
	 *�����Ϣ�޸Ĵ���
	 *
	 * @param dto IGASM17DTO
	 * @return IGASM17DTO
	 */
	public IGASM17DTO updateEntityItem(IGASM17DTO dto) throws BLException {
		
		log.debug("========�����Ϣ�༭���������ʾ����ʼ========");
		
		IGASM1712Form form = dto.getIgasm1712Form();
		if(!form.getEilabel().equals(form.getEilabelbak())){
			this.ig013BL.checkNotExistIG013Info(form.getEilabel());
		}
	
		IG013Info entityItem = this.ig013BL.searchIG013InfoByKey(form.getEiid());
		
		//��configitem����ȫƥ���civalue
		//����ʲ����ڹ�ϵ������ͬ���޸�
		//����ȫƥ��
		IG800SearchCondImpl cicond = new IG800SearchCondImpl();
		cicond.setCivalue(entityItem.getEiname()+"("+ form.getEiid() +")");
		
		List<IG800Info> configItemlist = this.ig800BL.searchIG800Info(cicond, 0, 0);
		if(!configItemlist.isEmpty()){
			for(int i = 0; i < configItemlist.size(); i++){
				IG800TB ciTB = (IG800TB)SerializationUtils.clone(configItemlist.get(i));
				ciTB.setCivalue(form.getEiname() + "(" + form.getEiid() + ")");
				this.ig800BL.updateIG800Info(ciTB);
			}
		}
			
		
		
		//EntityItemRelation��ȡ���й�ϵ���ʲ��б�
		IG313SearchCondImpl ercond = new IG313SearchCondImpl();
		ercond.setCldeiid(entityItem.getEiid());
//		ercond.setCldeid(String.valueOf(entityItem.getEid()));
		List<IG313Info> erlist = this.ig313BL.searchIG313Info(ercond);
		
		if(!erlist.isEmpty()){
			
			//�����¼
			//Configuration��ȡ���ʲ�����ʲ���cid
			IG225SearchCondImpl ccond = new IG225SearchCondImpl();
			//�ʲ�ID��cid
			ccond.setClabel(EntityItemKeyWords.ENTITY_DEFAULT_DEVICE_EIID);
			List<IG225Info> clist1 = this.ig225BL.searchIG225Info(ccond);
			IG225TB cTB1 = (IG225TB)SerializationUtils.clone(clist1.get(0));
			//�ʲ����Ƶ�cid
			ccond.setClabel(EntityItemKeyWords.ENTITY_DEFAULT_DEVICE_ENAME);
			List<IG225Info> clist2 = this.ig225BL.searchIG225Info(ccond);
			IG225TB cTB2 = (IG225TB)SerializationUtils.clone(clist2.get(0));
			
			cicond.setCivalue(null);
			for(int j = 0; j < erlist.size(); j++){
				//�����¼
				//�ʲ�ID
				IG313TB erTB = (IG313TB)SerializationUtils.clone(erlist.get(j));
				cicond.setEiid(erTB.getPareiid());
				cicond.setCid(cTB1.getCid());
				List<IG800Info> cilist1 = this.ig800BL.searchIG800Info(cicond);
				//�����ϵ�������ʲ�civalue�����ʲ�ID��ֵ,�����һ���е��ʲ�����
				if(!cilist1.isEmpty()){
					IG800TB ciTB1 = (IG800TB)SerializationUtils.clone(cilist1.get(0));
					cicond.setCid(cTB2.getCid());
					List<IG800Info> cilist2 = this.ig800BL.searchIG800Info(cicond);
					IG800TB ciTB2 = (IG800TB)SerializationUtils.clone(cilist2.get(0));
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
					this.ig800BL.updateIG800Info(ciTB2);
				}
			}
		}
	
		this.ig013BL.updateIG013Info(form);
		dto.addMessage(new ActionMessage("IGCO10000.I005","���������Ϣ"));
		log.debug("========�����Ϣ�༭���������ʾ��������========");
		return dto;
	}
	
	/**
	 * ��ȡ���������ֵ
	 *
	 * @param dto IGASM17DTO
	 * @return IGASM17DTO
	 */
	public IGASM17DTO searchEntityItemLableAction(IGASM17DTO dto) throws BLException {
		
		log.debug("========��ȡ���������ֵ����ʼ========");
		
		IGASM1702Form form = dto.getIgasm1702Form();
		
		IG013SearchCondImpl cond = new IG013SearchCondImpl();
		
		cond.setEilabel(CommonDefineUtils.ENTIY_CATEGORY_MODULE_KEY + IGStringUtils.getCurrentYear().substring(2));
		
		String eilabel = this.ig013BL.searchNextIG013InfoLable(cond);
		
		form.setEilabel(eilabel);
		
		log.debug("========��ȡ���������ֵ��������========");
		return dto;
	}
	
	/**
	 * �жϵ�½�û��Ƿ�������ʲ������ɫ������
	 * 
	 * @param dto IGASM17DTO
	 * @return IGASM17DTO
	 * @throws BLException 
	 */
	public IGASM17DTO checkEntityItemDomain(IGASM17DTO dto) throws BLException{
		boolean isRoleManager = this.userRoleBL.checkRoleManagerByType(dto.getUser().getUserid(), EntityCategory.ROLE_TYPE_DEVICE);
		
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
			IG117SearchCondImpl entityCond = new IG117SearchCondImpl();
			entityCond.setEsyscoding(CommonDefineUtils.ENTIY_CATEGORY_MODULE_SYSCODING);
			List<IG117Info> entity = this.ig117BL.searchIG117Info(entityCond, 0, 0);
			
			if(entity.size() != 1) {
				throw new BLException("IGCO10000.E004","���ģ��");
			} else {
				dto.setEname(entity.get(0).getEname());
				dto.setEsyscoding(entity.get(0).getEsyscoding());
			}
		}
		
		dto.setFlag(isRoleManager);
		
		return dto;
	}
}
