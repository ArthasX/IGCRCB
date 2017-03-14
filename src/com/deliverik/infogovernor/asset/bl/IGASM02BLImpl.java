package com.deliverik.infogovernor.asset.bl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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

import com.deliverik.framework.asset.bl.task.EiBelongRelationBL;
import com.deliverik.framework.asset.bl.task.IG013BL;
import com.deliverik.framework.asset.bl.task.IG117BL;
import com.deliverik.framework.asset.bl.task.IG225BL;
import com.deliverik.framework.asset.bl.task.IG313BL;
import com.deliverik.framework.asset.bl.task.IG545BL;
import com.deliverik.framework.asset.bl.task.IG800BL;
import com.deliverik.framework.asset.model.EiBelongRelationInfo;
import com.deliverik.framework.asset.model.IG002Info;
import com.deliverik.framework.asset.model.IG013Info;
import com.deliverik.framework.asset.model.IG225Info;
import com.deliverik.framework.asset.model.IG313Info;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.asset.model.condition.EiBelongRelationSearchCondImpl;
import com.deliverik.framework.asset.model.condition.IG313SearchCondImpl;
import com.deliverik.framework.asset.model.condition.IG688SearchCondImpl;
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
import com.deliverik.framework.utility.BLErrorType;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.asset.dto.IGASM02DTO;
import com.deliverik.infogovernor.asset.form.IGASM0202Form;
import com.deliverik.infogovernor.asset.form.IGASM0204Form;
import com.deliverik.infogovernor.asset.form.IGASM0207Form;
import com.deliverik.infogovernor.util.CodeDefine;

/**
 * �ʲ����ù���ҵ���߼�ʵ��
 *
 */
public class IGASM02BLImpl extends BaseBLImpl implements IGASM02BL {

	static Log log = LogFactory.getLog(IGASM02BLImpl.class);

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
	
	/** �ʲ�ȡֵ��Χ��������BL */
	protected IG545BL ig545BL;
	
	/** �ʲ�������ϵ��������BL */
	protected CodeDetailBL codeDetailBL;
	
	/** ������BL */
	protected IG225BL ig225BL;
	/** ������ϵ��BL */
	protected EiBelongRelationBL eiBelongRelationBL;
	
	public void setEiBelongRelationBL(EiBelongRelationBL eiBelongRelationBL) {
		this.eiBelongRelationBL = eiBelongRelationBL;
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
	
	public void setIg545BL(
			IG545BL ig545BL) {
		this.ig545BL = ig545BL;
	}
	
	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}

	/**
	 * ��������Ϣ��ѯ����
	 *
	 * @param dto IGASM02DTO
	 * @return IGASM02DTO
	 */
	public IGASM02DTO searchEntityItemAction(IGASM02DTO dto) throws BLException {

		log.debug("========��������Ϣ��ѯ����ʼ========");
		
		//��������Ϣ��ѯ����ȡ�� 
		int totalCount = this.ig013BL.getIG688InfoSearchCount(dto.getEntityItemVWSearchCond());
		
		if (totalCount == 0) {
			log.debug("========��������Ϣ��ѯ���ݲ�����========");
			//��������Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========��������Ϣ��ѯ���ݼ�������========");
			//��������Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();

		//��ǰҳ��������Ϣȡ��
		List<IG688Info> entityItemVWInfoList = this.ig013BL.searchIG688Info(dto.getEntityItemVWSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setEntityItemVWInfoList(entityItemVWInfoList);

		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========��������Ϣ��ѯ��������========");
		return dto;
	}
	
	/**
	 * ��������Ϣ�ǼǴ���
	 *
	 * @param dto IGASM02DTO
	 * @return IGASM02DTO
	 */
	public IGASM02DTO insertEntityItemAction(IGASM02DTO dto) throws BLException {
		log.debug("========��������Ϣ�ǼǴ���ʼ========");
		//����Formȡ��
		IGASM0202Form form = dto.getIgasm0202Form();
		
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

		//��������Ϣ��¼
		IG013Info entityItem = this.ig013BL.registIG013Info(dto.getIgasm0202Form());
		
		form.setEiidStr(entityItem.getEiid().toString());
		
		dto.setIgasm0202Form(form);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "�����������Ϣ") );

		log.debug("========��������Ϣ�ǼǴ�������========");
		return dto;
	}

	/**
	 * ��������Ϣɾ������
	 *
	 * @param dto IGASM02DTO
	 * @return IGASM02DTO
	 */
	public IGASM02DTO deleteEntityItemAction(IGASM02DTO dto) throws BLException {
		log.debug("========��������Ϣɾ������ʼ========");
		
		for( int i=0;i<dto.getDeleteEntityItem().length;i++ ){
			String eiid = dto.getDeleteEntityItem()[i];
			
			//ɾ��ǰɾ������������ȷ��
			IG013Info entityItem = this.ig013BL.searchIG013InfoByKey(Integer.parseInt(eiid));
			
			if (entityItem == null){
				throw new BLException("IGCO10000.E004","ɾ���������������");
			}

			//������ɾ��
			this.ig013BL.deleteIG013Info(entityItem);
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I006","��������Ϣ"));

		log.debug("========��������Ϣɾ����������========");
		return dto;
	}

	/**
	 * ������������Ϣ�༭������ڻ�����
	 *
	 * @param dto IGASM02DTO
	 * @return IGASM02DTO
	 */
	public IGASM02DTO initIGASM0204Action(IGASM02DTO dto) throws BLException {

		log.debug("========������������Ϣ�༭������ڻ�����ʼ========");
		
		IGASM0204Form form = dto.getIgasm0204Form();
		
		//��������Ϣ����
		IG688Info entityItemVWInfo = this.ig013BL.searchIG688InfoByKey(
				form.getEiid());
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","������");
		}
		
		form.setEidesc(entityItemVWInfo.getEidesc());
//		form.setEistatus(entityItemVWInfo.getEistatus());
		form.setEiorgsyscoding(entityItemVWInfo.getEiorgsyscoding());
		dto.setEntityItemVWInfo(entityItemVWInfo);
		form.setEsyscoding_q(entityItemVWInfo.getEsyscoding());
		//�жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
		Boolean flag = this.ig013BL.checkIG688InfoDomain(dto.getUser(), entityItemVWInfo);

		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}else{
			dto.setFlag(flag);
		}
		
		
		//������������Ϣ��ѯ����ȡ�� 
		int totalCount = this.ig800BL.getIG002InfoSearchCount(form);
		
		if (totalCount == 0) {
			log.debug("========������������Ϣ��ѯ���ݲ�����========");
			//������������Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I007",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========������������Ϣ��ѯ���ݼ�������========");
			//������������Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//������������Ϣȫ����ѯ
		List<IG002Info> configItemVWInfoList = this.ig800BL.searchIG002Info(
				form, 0, 0);
		
		String[] civalue = new String[totalCount];
		Map<String,List<IG002Info>> map = new LinkedHashMap<String,List<IG002Info>>();
		int i = 0;
		int j = 0;
		List<String> strlist = new ArrayList<String>();
		for(IG002Info e : configItemVWInfoList){
			if(!map.containsKey(e.getCcategory())){
				map.put(e.getCcategory(), new ArrayList<IG002Info>());
				strlist.add(e.getCcategory());
			}
			if("2".equals(e.getCattach())){
				List<LabelValueBean> list = ig545BL.searchLabelValueBeanList(e.getCoption());
				form.setSelectedListMap(j++, list);
			}
			map.get(e.getCcategory()).add(e);
		}
		
		for(String str : strlist){
			for(IG002Info e : map.get(str)){
				civalue[i] = e.getCivalue();
				i++;
			}
		}
		
		//������ʾ����Ϣ�趨
		
		form.setCivalue(civalue);
		
		dto.setConfigItemVWInfoMap(map);
//		dto.addMessage(new ActionMessage("IGCO10000.I007",totalCount));
		

		
		log.debug("========������������Ϣ�༭������ڻ���������========");
		return dto;
	}
	
	/**
	 * ������������Ϣ�༭����
	 *
	 * @param dto IGASM02DTO
	 * @return IGASM02DTO
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public IGASM02DTO editEntityItemAction(IGASM02DTO dto) throws BLException, FileNotFoundException, IOException {
		log.debug("========������������Ϣ�༭����ʼ========");
		//�汾������
		IGASM0204Form form = dto.getIgasm0204Form();
		
		int version = form.getEiversion() + 1;
		
		//�����������Ϣ����
		IG013TB entityItem = (IG013TB) this.ig013BL.searchIG013InfoByKey(form.getEiid());
		
		//������״̬
//		entityItem.setEistatus(form.getEistatus());
		//������汾
		entityItem.setEiversion(version);
		
		//������˵��
		entityItem.setEidesc(form.getEidesc());

		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		
		//����ʱ��
		entityItem.setEiupdtime(datetime);
		
		this.ig013BL.updateIG013Info(entityItem);
		
		//���ø���BL
		
		//������������Ϣ����
		if (form.getCiid() != null && form.getCiid().length > 0 ) {
			
			for( int i=0 ; i < form.getCiid().length; i++ ){
				IG800TB configItem = new IG800TB();
				if (StringUtils.isEmpty(form.getCiid()[i])) {
					//����
					//������ID
					configItem.setEiid(form.getEiid());
					//�ʲ�����ID
					configItem.setCid(Integer.parseInt(form.getCid()[i]));
					//����ID
					configItem.setEid(Integer.parseInt(form.getEid()[i]));
					//���Ͳ����
					configItem.setEsyscoding(form.getEsyscoding()[i]);
					//����
					configItem.setCivalue(form.getCivalue()[i]);
					
					//�汾��
					configItem.setCiversion(version);
					//����ʱ��
					configItem.setCiupdtime(datetime);
					
					configItem = (IG800TB) this.ig800BL.registIG800Info(configItem);
					
					//�������Ϊ�ʲ�ʱ�����ӹ�����ϵ
					if("4".equals(form.getCiattach()[i]) && StringUtils.isNotEmpty(form.getCivalue()[i])){
						IG313TB e = new IG313TB();
						e.setPareid(entityItem.getEid());
						e.setPareiid(entityItem.getEiid());
						String str = form.getCivalue()[i];
						IG013Info ei = this.ig013BL.searchIG013InfoByKey(Integer.parseInt(str.substring(str.lastIndexOf("(")+1, str.length()-1)));
						e.setCldeid(ei.getEid());
						e.setCldeiid(ei.getEiid());
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
						//����key
						e.setEirdesc("�������"+cname+"����("+entityItem.getEiid()+"_"+configItem.getCiid()+"_"+ei.getEiid()+")");
						//����״̬ΪC����ϵ�����в���ɾ��
						e.setEirstatus("C");
						this.ig313BL.registIG313Info(e);
					}
					log.debug("�ʲ������[�ʲ�����ID:" + form.getCid()[i] + "]���봦��ɹ���");
					
				} else {
					//����
					configItem = (IG800TB) this.ig800BL.searchIG800InfoByKey(Integer.parseInt(form.getCiid()[i]));
					
					IG800TB insertConfigItem = null;
					
					insertConfigItem = (IG800TB) SerializationUtils.clone(configItem);
					//����
					insertConfigItem.setCivalue(form.getCivalue()[i]);
					
					//�汾��
					insertConfigItem.setCiversion(version);
					//����ʱ��
					insertConfigItem.setCiupdtime(datetime);
					
					//����������IDɾ��
					insertConfigItem.setCiid(null);

					configItem = (IG800TB) this.ig800BL.registIG800Info(insertConfigItem);
					//�������Ϊ�ʲ�ʱ�����ӹ�����ϵ
					if("4".equals(form.getCiattach()[i]) && StringUtils.isNotEmpty(form.getCivalue()[i])){
						IG313TB e = new IG313TB();
						e.setPareid(entityItem.getEid());
						e.setPareiid(entityItem.getEiid());
						String str = form.getCivalue()[i];			
						IG013Info ei = this.ig013BL.searchIG013InfoByKey(Integer.parseInt(str.substring(str.lastIndexOf("(")+1, str.length()-1)));
				
						e.setCldeid(ei.getEid());
						e.setCldeiid(ei.getEiid());
						//У���ϵ�Ƿ����
						IG313SearchCondImpl cond = new IG313SearchCondImpl();
						cond.setEirdesc("("+entityItem.getEiid()+"_"+form.getCiid()[i]+"_"+ei.getEiid()+")");
						cond.setEirstatus("C");
						cond.setDeleteflag("0");
						List<IG313Info> eirlist = this.ig313BL.searchMaxIG313Info(cond);
						if(eirlist.isEmpty()){
							//ɾ��ԭ�����еĹ�ϵ
							IG313SearchCondImpl eircond = new IG313SearchCondImpl();
							eircond.setEirdesc("("+entityItem.getEiid()+"_"+form.getCiid()[i]+"_");
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
							//����key
							e.setEirdesc("�������"+cname+"����("+entityItem.getEiid()+"_"+configItem.getCiid()+"_"+ei.getEiid()+")");
							//����״̬ΪC����ϵ�����в���ɾ��
							e.setEirstatus("C");
							this.ig313BL.registIG313Info(e);
						}
					}
					if("4".equals(form.getCiattach()[i]) && StringUtils.isEmpty(form.getCivalue()[i])){
						//ɾ��ԭ�����еĹ�ϵ
						IG313SearchCondImpl eircond = new IG313SearchCondImpl();
						eircond.setEirdesc("("+entityItem.getEiid()+"_"+form.getCiid()[i]+"_");
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
						//������ID
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
						
						this.ig800BL.updateIG800Info(configItem);					
						
					}
				}
			}
			
		}
	
		dto.addMessage(new ActionMessage("IGCO10000.I005","������������Ϣ"));
		
		log.debug("========������������Ϣ�༭��������========");
		
		return dto;
	}

	/**
	 * ������������Ϣ��ʷ��¼������ڻ�����
	 *
	 * @param dto IGASM02DTO
	 * @return IGASM02DTO
	 */
	public IGASM02DTO initIGASM0205Action(IGASM02DTO dto) throws BLException {
		log.debug("========������������Ϣ��ʷ��¼������ڻ�����ʼ========");
		
		//��������Ϣ����
		IG688Info entityItemVWInfo = this.ig013BL.searchIG688InfoByKey(
				dto.getIgasm0205Form().getEiid());
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","������");
		}
		
		if (entityItemVWInfo.getEiversion() == 0 && entityItemVWInfo.getEismallversion() == 0) {
			dto.addMessage(new ActionMessage("IGASM0205.W001"));
		}
		
		dto.setEntityItemVWInfo(entityItemVWInfo);
		
		if ((dto.getIgasm0205Form().getCiversion())!=null) {
			dto.getIgasm0205Form().setCiversion(String.valueOf(entityItemVWInfo.getEiversion()));
		}
		//��ȡ��ʷ�汾����ʱ��
		dto.setConfigItemVersionTime(this.ig013BL.searchVersionUpdateTime(dto.getIgasm0205Form().getEiid()));
		
		//�жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
		Boolean flag = this.ig013BL.checkIG688InfoDomain(dto.getUser(), entityItemVWInfo);

		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}else{
			dto.setFlag(flag);
		}
		
		log.debug("========������������Ϣ��ʷ��¼������ڻ���������========");
		return dto;
	}

	/**
	 * �������ϵ��������ڻ�����
	 *
	 * @param dto IGASM02DTO
	 * @return IGASM02DTO
	 */
	public IGASM02DTO initIGASM0206Action(IGASM02DTO dto) throws BLException {
		log.debug("========�������ϵ��������ڻ�����ʼ========");
		
		//��������Ϣ����
		IG688Info entityItemVWInfo = this.ig013BL.searchIG688InfoByKey(
				dto.getIgasm0206Form().getEiid());
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","������");
		}
		
		dto.setEntityItemVWInfo(entityItemVWInfo);
		
		//���������ϵ����
		IG313SearchCondImpl parcond = new IG313SearchCondImpl();
		
		parcond.setEiid(dto.getIgasm0206Form().getEiid());
		
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
		
		
		//�������ϵ��Ϣ��ѯ����ȡ�� 
		int totalCount = this.ig313BL.getIG313InfoSearchCount(parcond);
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========�������ϵ��Ϣ��ѯ���ݼ�������========");
			//�������ϵ��Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		if ( totalCount>0 ) {
			//�������ϵ��Ϣȫ������
			List<IG313Info> parEntityItemRelationList = 
				this.ig313BL.searchMaxIG313Info(parcond);
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
		IG313SearchCondImpl cldcond = new IG313SearchCondImpl();
		
		cldcond.setCldeiid(dto.getIgasm0206Form().getEiid());
		
		//�������ϵ��Ϣ��ѯ����ȡ�� 
		totalCount = this.ig313BL.getIG313InfoSearchCount(cldcond);
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========�������ϵ��Ϣ��ѯ���ݼ�������========");
			//�������ϵ��Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//�������ϵ��Ϣȫ������
		List<IG313Info> cldEntityItemRelationList = 
			this.ig313BL.searchMaxIG313Info(cldcond);
		
		dto.setParCount(dto.getParCount()+cldEntityItemRelationList.size());
//		dto.addMessage(new ActionMessage("IGCO10000.I007",dto.getParCount()));
		for(IG313Info e : cldEntityItemRelationList){
			String key = e.getEirrelationcode().split("-")[0];
			String eirrelationcode = e.getEirrelationcode();
			String ecategory = e.getCldEntityItemVW().getEcategory();
			if(!"-".equals(eirrelationcode.replaceAll(ecategory, ""))){
				key = eirrelationcode.replaceAll(ecategory, "").replaceAll("-", "");
			}
			if(!parmap.containsKey(key)){
				parmap.put(key, new ArrayList<IG313Info>());
			}
			((IG313TB)e).setParflag("1");
			parmap.get(key).add(e);
		}
		if(parmap.size()==0){
			parmap = null;
		}
		dto.setParEntityItemRelationMap(parmap);
		
		log.debug("========�������ϵ��������ڻ���������========");
		return dto;
	}
	
	/**
	 * �豸������ϵ������ڻ�����
	 *
	 * @param dto IGASM02DTO
	 * @return IGASM03DTO
	 */
	public IGASM02DTO initIGASM0206BelongAction(IGASM02DTO dto) throws BLException {
		log.debug("========�豸������ϵ��������ڻ�����ʼ========");
		
		//�豸��Ϣ����
		IG688Info entityItemVWInfo = this.ig013BL.searchIG688InfoByKey(
				dto.getIgasm0206Form().getEiid());
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004", "�ʲ�����");
		}
		
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
		
		//������ϵ����
		EiBelongRelationSearchCondImpl belongcond = new EiBelongRelationSearchCondImpl();
		belongcond.setBrpareiid(String.valueOf(entityItemVWInfo.getEiid()));
		belongcond.setBrparsmallversion(String.valueOf(entityItemVWInfo.getEismallversion()));
		belongcond.setBrparversion(String.valueOf(entityItemVWInfo.getEiversion()));
		belongcond.setDeleteflag("0");
		List<EiBelongRelationInfo> belongRelationList = null;
		//�豸������ϵ��Ϣ��ѯ����ȡ�� 
		int totalCount = this.eiBelongRelationBL.getSearchCount(belongcond);
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========�豸��ϵ��Ϣ��ѯ���ݼ�������========");
			//�豸������ϵ��Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		if ( totalCount>0 ) {
			//�豸������ϵ��Ϣȫ������
			belongRelationList = this.eiBelongRelationBL.searchEiBelongRelation(belongcond);
		}

		dto.setBelongRelationList(belongRelationList);

		
		log.debug("========�豸������ϵ��������ڻ���������========");
		return dto;
	}
	/**
	 * �������ϵɾ������
	 *
	 * @param dto IGASM02DTO
	 * @return IGASM02DTO
	 */
	public IGASM02DTO deleteEntityItemRelationAction(IGASM02DTO dto) throws BLException {
		log.debug("========�������ϵɾ������ʼ========");
		
		for( int i=0;i<dto.getDeleteEntityItemRelation().length;i++ ){
			String eirid = dto.getDeleteEntityItemRelation()[i];
			
			IG313Info entityItemRelation = 
				this.ig313BL.searchIG313InfoByKey(Integer.parseInt(eirid));
			
			if (entityItemRelation == null){
				throw new BLException("IGCO10000.E004","ɾ�������������ϵ");
			}

			this.ig313BL.deleteIG313Info(entityItemRelation);
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I006","�������ϵ��Ϣ"));

		log.debug("========�������ϵɾ����������========");
		return dto;
	}

	/**
	 * �������ϵ�ǼǴ���
	 *
	 * @param dto IGASM02DTO
	 * @return IGASM02DTO
	 */
	public IGASM02DTO insertEntityItemRelationAction(IGASM02DTO dto) throws BLException {
		log.debug("========�������ϵ�ǼǴ���ʼ========");
		
		IGASM0207Form form = dto.getIgasm0207Form();
		
		//������ID���ӣ�ȡ��
		IG688SearchCondImpl cond = new IG688SearchCondImpl();
		
		cond.setElabel(form.getElabel());
		cond.setEilabel(form.getEilabel());
		
		List<IG688Info> entityItemVWList = this.ig013BL.searchIG688Info(cond, 0, 0);
		
		if ( entityItemVWList==null || entityItemVWList.size() == 0 ) {
			throw new BLException("IGCO10000.E004","(�ʲ����=" + form.getElabel() + ",��������=" 
					+ form.getEilabel() + ")������");
		}
		
		form.setCldeiid(entityItemVWList.get(0).getEiid());
		form.setCldeid(Integer.parseInt(entityItemVWList.get(0).getEid()));
		
		//������ID�������ͣ��ӣ����
		if (form.getPareiid().intValue() == form.getCldeiid().intValue()) {
			//������ID������= ���ӣ�
			throw new BLException(BLErrorType.ENTITY_ITEM_RELATION_ERROR,
					"IGCO10000.E012","������");
		}
		
		//����ʱ���趨
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

		form.setEirupdtime(datetime);
		
		//�ʲ���ϵ�Ǽ�
		IG313Info ret = 
			this.ig313BL.registIG313Info(dto.getIgasm0207Form());
		
		dto.setEntityItemRelation(ret);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "�������ϵ��Ϣ") );
		
		log.debug("========�������ϵ�ǼǴ�������========");
		return dto;
	}
	
	/**
	 * �������ϵ�༭������ڻ�����
	 *
	 * @param dto IGASM02DTO
	 * @return IGASM02DTO
	 */
	public IGASM02DTO initIGASM0207Action(IGASM02DTO dto) throws BLException {
		log.debug("========�������ϵ�༭������ڻ�����ʼ========");
		
		IGASM0207Form form = dto.getIgasm0207Form();
		IG313TB ret = 		
			(IG313TB) this.ig313BL.searchIG313InfoByKey(
				form.getEirid());
		
		if ( ret == null ){
			throw new BLException("IGCO10000.E004","�༭�����������ϵ");
		}
		
		//��������趨
		form.setPareiname(ret.getParEntityItemVW().getEiname());
		form.setPareid(ret.getPareid());
		form.setPareiid(ret.getPareiid());
		form.setCldeid(ret.getCldeid());
		form.setCldeiid(ret.getCldeiid());
		form.setEiridStr(ret.getEirid().toString());
		form.setEirdesc(ret.getEirdesc());
		form.setEirrelation(ret.getEirrelation());
		form.setEirrelationcode(ret.getEirrelationcode());
		form.setElabel(ret.getCldEntityItemVW().getElabel());
		form.setEilabel(ret.getCldEntityItemVW().getEilabel());
		form.setEiname(ret.getCldEntityItemVW().getEiname());
		form.setTempeirrelation(ret.getEirrelation()+"#"+ret.getEirrelationcode());
		form.setMode("1");
		
		log.debug("========�������ϵ�༭������ڻ���������========");
		return dto;
	}

	/**
	 * �������ϵ���������
	 *
	 * @param dto IGASM02DTO
	 * @return IGASM02DTO
	 */
	public IGASM02DTO updateEntityItemRelationAction(IGASM02DTO dto) throws BLException {
		log.debug("========�������ϵ���������ʼ========");
		IGASM0207Form form = dto.getIgasm0207Form();

		//����ʱ���趨
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

		form.setEirupdtime(datetime);
		
		this.ig313BL.updateIG313Info(form);

		dto.addMessage(new ActionMessage( "IGCO10000.I005", "�������ϵ��Ϣ") );

		log.debug("========�������ϵ�������������========");
		return dto;
	}
	
	/**
	 *	��ȡ�����������ϵ����
	 *
	 * @param dto IGASM02DTO
	 * @return IGASM02DTO
	 */
	public IGASM02DTO searchRelationListAction(IGASM02DTO dto) throws BLException {
		log.debug("========��ȡ�����������ϵ����ʼ========");
		List<LabelValueBean> list = this.codeDetailBL.searchLabelValueBeanList(CommonDefineUtils.ENTIY_CATEGORY_DEVICE,CodeDefine.getCodeDefine("ENTITY_ITEM_RELATION_CODE").getCcid());
		dto.setRelationList(list);
		log.debug("========��ȡ�����������ϵ��������========");
		return dto;
	}
}
