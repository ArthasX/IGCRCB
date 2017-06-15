package com.deliverik.infogovernor.asset.bl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

import com.deliverik.framework.asset.bl.task.IG013BL;
import com.deliverik.framework.asset.bl.task.IG117BL;
import com.deliverik.framework.asset.bl.task.IG313BL;
import com.deliverik.framework.asset.bl.task.IG800BL;
import com.deliverik.framework.asset.model.IG002Info;
import com.deliverik.framework.asset.model.IG013Info;
import com.deliverik.framework.asset.model.IG117Info;
import com.deliverik.framework.asset.model.IG313Info;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.asset.model.IG800Info;
import com.deliverik.framework.asset.model.condition.IG117SearchCondImpl;
import com.deliverik.framework.asset.model.condition.IG313SearchCondImpl;
import com.deliverik.framework.asset.model.condition.IG688SearchCondImpl;
import com.deliverik.framework.asset.model.entity.IG013TB;
import com.deliverik.framework.asset.model.entity.IG313TB;
import com.deliverik.framework.asset.model.entity.IG800TB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.FileUploadBL;
import com.deliverik.framework.utility.BLErrorType;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.asset.dto.IGASM07DTO;
import com.deliverik.infogovernor.asset.form.IGASM0702Form;
import com.deliverik.infogovernor.asset.form.IGASM0704Form;
import com.deliverik.infogovernor.asset.form.IGASM0707Form;

/**
 * �������ù���ҵ���߼�ʵ��
 *
 */
public class IGASM07BLImpl extends BaseBLImpl implements IGASM07BL {

	static Log log = LogFactory.getLog(IGASM07BLImpl.class);

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

	/**
	 * ������Ϣ��ѯ����
	 *
	 * @param dto IGASM07DTO
	 * @return IGASM07DTO
	 */
	public IGASM07DTO searchEntityItemAction(IGASM07DTO dto) throws BLException {

		log.debug("========������Ϣ��ѯ����ʼ========");
		
		//������Ϣ��ѯ����ȡ�� 
		int totalCount = this.ig013BL.getIG688InfoSearchCount(dto.getEntityItemVWSearchCond());
		
		if (totalCount == 0) {
			log.debug("========������Ϣ��ѯ���ݲ�����========");
			//������Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========������Ϣ��ѯ���ݼ�������========");
			//������Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();

		//��ǰҳ������Ϣȡ��
		List<IG688Info> entityItemVWInfoList = this.ig013BL.searchIG688Info(dto.getEntityItemVWSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setEntityItemVWInfoList(entityItemVWInfoList);

		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========������Ϣ��ѯ��������========");
		return dto;
	}
	
	/**
	 * ������Ϣ�ǼǴ���
	 *
	 * @param dto IGASM07DTO
	 * @return IGASM07DTO
	 */
	public IGASM07DTO insertEntityItemAction(IGASM07DTO dto) throws BLException {
		log.debug("========������Ϣ�ǼǴ���ʼ========");
		//����Formȡ��
		IGASM0702Form form = dto.getIgasm0702Form();
		
		//����IDȡ��
		IG117SearchCondImpl cond = new IG117SearchCondImpl();
		cond.setElabel(form.getElabel());
		
		//�ǼǴ���ǰ���ʲ���Ϣȷ��
		List<IG117Info> entityList = this.ig117BL.searchIG117Info(cond, 0, 0);
		
		if ( entityList == null || entityList.size() ==0 ) {
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","(���=" + form.getElabel() + ")�ʲ�����");
		}
		
		IG117Info entity = entityList.get(0);
		
		//***************************************************************************
		//���ͷ�����
		if (!entity.getEcategory().equals(CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_ROOM)) {
			//������������
			throw new BLException(BLErrorType.ENTITY_CATEGORY_ERROR,
					"IGCO10000.E011","����");
		}
		//***************************************************************************
		
		form.setEid(entity.getEid());
		form.setEidStr(entity.getEid().toString());
		
		//����ʱ���趨
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		
		form.setEiupdtime(datetime);
		
		//��汾�趨���̶���Ϊ0��
		form.setEiversion(0);
		
		//С�汾�趨���̶���Ϊ0��
		form.setEismallversion(0);

		//������Ϣ��¼
		IG013Info entityItem = this.ig013BL.registIG013Info(dto.getIgasm0702Form());
		
		form.setEiidStr(entityItem.getEiid().toString());
		
		dto.setIgasm0702Form(form);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "����������Ϣ") );

		log.debug("========������Ϣ�ǼǴ�������========");
		return dto;
	}

	/**
	 * ������Ϣɾ������
	 *
	 * @param dto IGASM07DTO
	 * @return IGASM07DTO
	 */
	public IGASM07DTO deleteEntityItemAction(IGASM07DTO dto) throws BLException {
		log.debug("========������Ϣɾ������ʼ========");
		
		for( int i=0;i<dto.getDeleteEntityItem().length;i++ ){
			String eiid = dto.getDeleteEntityItem()[i];
			
			//ɾ��ǰɾ���������ȷ��
			IG013Info entityItem = this.ig013BL.searchIG013InfoByKey(Integer.parseInt(eiid));
			
			if (entityItem == null){
				throw new BLException("IGCO10000.E004","ɾ�������������");
			}

			//����ɾ��
			this.ig013BL.deleteIG013Info(entityItem);
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I006","������Ϣ"));

		log.debug("========������Ϣɾ����������========");
		return dto;
	}

	/**
	 * ����������Ϣ�༭������ڻ�����
	 *
	 * @param dto IGASM07DTO
	 * @return IGASM07DTO
	 */
	public IGASM07DTO initIGASM0704Action(IGASM07DTO dto) throws BLException {

		log.debug("========����������Ϣ�༭������ڻ�����ʼ========");
		
		IGASM0704Form form = dto.getIgasm0704Form();
		
		//������Ϣ����
		IG688Info entityItemVWInfo = this.ig013BL.searchIG688InfoByKey(
				form.getEiid());
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","����");
		}
		
		form.setEidesc(entityItemVWInfo.getEidesc());
//		form.setEistatus(entityItemVWInfo.getEistatus());
		
		dto.setEntityItemVWInfo(entityItemVWInfo);
		form.setEsyscoding_q(entityItemVWInfo.getEsyscoding());
		
		//����������Ϣ��ѯ����ȡ�� 
		int totalCount = this.ig800BL.getIG002InfoSearchCount(form);
		
		if (totalCount == 0) {
			log.debug("========����������Ϣ��ѯ���ݲ�����========");
			//����������Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I007",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========����������Ϣ��ѯ���ݼ�������========");
			//����������Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//����������Ϣȫ����ѯ
		List<IG002Info> configItemVWInfoList = this.ig800BL.searchIG002Info(
				form, 0, 0);
		
		//������ʾ����Ϣ�趨
		String[] civalue = new String[totalCount];
		
		for(int i=0;i<totalCount;i++) {
			civalue[i] = configItemVWInfoList.get(i).getCivalue();
		}
		
		form.setCivalue(civalue);
		
		dto.setConfigItemVWInfoList(configItemVWInfoList);
		

		dto.addMessage(new ActionMessage("IGCO10000.I007",totalCount));
		
		log.debug("========����������Ϣ�༭������ڻ���������========");
		return dto;
	}
	
	/**
	 * ����������Ϣ�༭����
	 *
	 * @param dto IGASM07DTO
	 * @return IGASM07DTO
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public IGASM07DTO editEntityItemAction(IGASM07DTO dto) throws BLException, FileNotFoundException, IOException {
		log.debug("========����������Ϣ�༭����ʼ========");
		//�汾������
		IGASM0704Form form = dto.getIgasm0704Form();
		
		int version = form.getEiversion() + 1;
		
		//����������Ϣ����
		IG013TB entityItem = (IG013TB) this.ig013BL.searchIG013InfoByKey(form.getEiid());

		//�ʲ���ϵ��Ϣ�汾��������
		this.ig313BL.upgradeIG313Info(entityItem.getEiid(), entityItem.getEiversion(), entityItem.getEismallversion(),
				version, 0);
		//����״̬
//		entityItem.setEistatus(form.getEistatus());
		//�����汾
		entityItem.setEiversion(version);
		
		//����˵��
		entityItem.setEidesc(form.getEidesc());

		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		
		//����ʱ��
		entityItem.setEiupdtime(datetime);
		
		this.ig013BL.updateIG013Info(entityItem);
		
		//���ø���BL
		
		//����������Ϣ����
		if (form.getCiid() != null && form.getCiid().length > 0 ) {
			
			for( int i=0 ; i < form.getCiid().length; i++ ){
				IG800TB configItem = new IG800TB();
				if (StringUtils.isEmpty(form.getCiid()[i])) {
					//����
					//����ID
					configItem.setEiid(form.getEiid());
					//�ʲ�����ID
					configItem.setCid(Integer.parseInt(form.getCid()[i]));
					//����ID
					configItem.setEid(Integer.parseInt(form.getEid()));
					//����
					configItem.setCivalue(form.getCivalue()[i]);
					//��汾��
					configItem.setCiversion(version);
					//С�汾��
					configItem.setCismallversion(0);
					//����ʱ��
					configItem.setCiupdtime(datetime);
					
					configItem = (IG800TB) this.ig800BL.registIG800Info(configItem);
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
					
					//��������IDɾ��
					insertConfigItem.setCiid(null);

					configItem = (IG800TB) this.ig800BL.registIG800Info(insertConfigItem);
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
						//����ID
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
	
		dto.addMessage(new ActionMessage("IGCO10000.I005","����������Ϣ"));
		
		log.debug("========����������Ϣ�༭��������========");
		
		return dto;
	}

	/**
	 * ����������Ϣ��ʷ��¼������ڻ�����
	 *
	 * @param dto IGASM07DTO
	 * @return IGASM07DTO
	 */
	public IGASM07DTO initIGASM0705Action(IGASM07DTO dto) throws BLException {
		log.debug("========����������Ϣ��ʷ��¼������ڻ�����ʼ========");
		
		//������Ϣ����
		IG688Info entityItemVWInfo = this.ig013BL.searchIG688InfoByKey(
			dto.getIgasm0705Form().getEiid());
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","����");
		}
		
		if (entityItemVWInfo.getEiversion() == 0 && entityItemVWInfo.getEismallversion() == 0) {
			dto.addMessage(new ActionMessage("IGASM0205.W001"));
		}
		
		dto.setEntityItemVWInfo(entityItemVWInfo);
		
		if ((dto.getIgasm0705Form().getCiversion())!=null) {
			dto.getIgasm0705Form().setCiversion(String.valueOf(entityItemVWInfo.getEiversion()));
		}
		
		//����������Ϣ��ѯ����ȡ�� 
		int totalCount = this.ig800BL.getIG800InfoSearchCount(dto.getIgasm0705Form());
		
		if (totalCount == 0) {
			log.debug("========��ѯ���ݲ�����========");
			//��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I007",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========��ѯ���ݼ�������========");
			//��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//����������Ϣȫ������
		List<IG800Info> configItemList = this.ig800BL.searchIG800Info(
				dto.getIgasm0705Form(), 0, 0);
		
		dto.setConfigItemList(configItemList);

		dto.addMessage(new ActionMessage("IGCO10000.I007",totalCount));
		
		log.debug("========����������Ϣ��ʷ��¼������ڻ���������========");
		return dto;
	}

	/**
	 * ������ϵ��������ڻ�����
	 *
	 * @param dto IGASM07DTO
	 * @return IGASM07DTO
	 */
	public IGASM07DTO initIGASM0706Action(IGASM07DTO dto) throws BLException {
		log.debug("========������ϵ��������ڻ�����ʼ========");
		
		//������Ϣ����
		IG688Info entityItemVWInfo = this.ig013BL.searchIG688InfoByKey(
				Integer.parseInt(dto.getIgasm0706Form().getEiid()));
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","����");
		}
		
		dto.setEntityItemVWInfo(entityItemVWInfo);
		
		//���������ϵ����
		IG313SearchCondImpl parcond = new IG313SearchCondImpl();
		if(dto.getIgasm0706Form().getEiid()!=null){
		parcond.setPareiid(Integer.parseInt(dto.getIgasm0706Form().getEiid()));}
		parcond.setParversion(entityItemVWInfo.getEiversion());
		parcond.setParsmallversion(entityItemVWInfo.getEismallversion());
		parcond.setDeleteflag("0");
		
		//������ϵ��Ϣ��ѯ����ȡ�� 
		int totalCount = this.ig313BL.getIG313InfoSearchCount(parcond);
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========������ϵ��Ϣ��ѯ���ݼ�������========");
			//������ϵ��Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		if ( totalCount>0 ) {
			//������ϵ��Ϣȫ������
			List<IG313Info> parEntityItemRelationList = 
				this.ig313BL.searchMaxIG313Info(parcond);
			
			dto.setParEntityItemRelationList(parEntityItemRelationList);
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I007",totalCount));
		
		//���������ϵ����
		//������ϵ����
		IG313SearchCondImpl cldcond = new IG313SearchCondImpl();
		if((dto.getIgasm0706Form().getEiid())!=null){
		cldcond.setCldeiid(Integer.parseInt(dto.getIgasm0706Form().getEiid()));}
		cldcond.setCldversion(entityItemVWInfo.getEiversion());
		cldcond.setCldsmallversion(entityItemVWInfo.getEismallversion());
		cldcond.setDeleteflag("0");
		
		//������ϵ��Ϣ��ѯ����ȡ�� 
		totalCount = this.ig313BL.getIG313InfoSearchCount(cldcond);
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========������ϵ��Ϣ��ѯ���ݼ�������========");
			//������ϵ��Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//������ϵ��Ϣȫ������
		List<IG313Info> cldEntityItemRelationList = 
			this.ig313BL.searchMaxIG313Info(cldcond);
		
		dto.setCldEntityItemRelationList(cldEntityItemRelationList);

		
		
		log.debug("========������ϵ��������ڻ���������========");
		return dto;
	}
	
	/**
	 * ������ϵɾ������
	 *
	 * @param dto IGASM07DTO
	 * @return IGASM07DTO
	 */
	public IGASM07DTO deleteEntityItemRelationAction(IGASM07DTO dto) throws BLException {
		log.debug("========������ϵɾ������ʼ========");
		
		for( int i=0;i<dto.getDeleteEntityItemRelation().length;i++ ){
			String eirid = dto.getDeleteEntityItemRelation()[i];
			
			IG313Info entityItemRelation = 
				this.ig313BL.searchIG313InfoByKey(Integer.parseInt(eirid));
			
			if (entityItemRelation == null){
				throw new BLException("IGCO10000.E004","ɾ�����������ϵ");
			}

			this.ig313BL.deleteIG313Info(entityItemRelation);
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I006","������ϵ��Ϣ"));

		log.debug("========������ϵɾ����������========");
		return dto;
	}

	/**
	 * ������ϵ�ǼǴ���
	 *
	 * @param dto IGASM07DTO
	 * @return IGASM07DTO
	 */
	public IGASM07DTO insertEntityItemRelationAction(IGASM07DTO dto) throws BLException {
		log.debug("========������ϵ�ǼǴ���ʼ========");
		
		IGASM0707Form form = dto.getIgasm0707Form();
		
		//����ID���ӣ�ȡ��
		IG688SearchCondImpl cond = new IG688SearchCondImpl();
		
		cond.setElabel(form.getElabel());
		cond.setEilabel(form.getEilabel());
		
		List<IG688Info> entityItemVWList = this.ig013BL.searchIG688Info(cond, 0, 0);
		
		if ( entityItemVWList==null || entityItemVWList.size() == 0 ) {
			throw new BLException("IGCO10000.E004","(�ʲ����=" + form.getElabel() + ",�������=" 
					+ form.getEilabel() + ")����");
		}
		
		form.setCldeiid(entityItemVWList.get(0).getEiid());
		form.setCldeid(Integer.parseInt(entityItemVWList.get(0).getEid()));
		
		//����ID�������ͣ��ӣ����
		if (form.getPareiid().intValue() == form.getCldeiid().intValue()) {
			//����ID������= ���ӣ�
			throw new BLException(BLErrorType.ENTITY_ITEM_RELATION_ERROR,
					"IGCO10000.E012","����");
		}
		
		//����ʱ���趨
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

		form.setEirupdtime(datetime);
		
		//�ʲ���ϵ�Ǽ�
		IG313Info ret = 
			this.ig313BL.registIG313Info(dto.getIgasm0707Form());
		
		dto.setEntityItemRelation(ret);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "������ϵ��Ϣ") );
		
		log.debug("========������ϵ�ǼǴ�������========");
		return dto;
	}
	
	/**
	 * ������ϵ�༭������ڻ�����
	 *
	 * @param dto IGASM07DTO
	 * @return IGASM07DTO
	 */
	public IGASM07DTO initIGASM0707Action(IGASM07DTO dto) throws BLException {
		log.debug("========������ϵ�༭������ڻ�����ʼ========");
		
		IGASM0707Form form = dto.getIgasm0707Form();
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
		form.setMode("1");
		
		log.debug("========������ϵ�༭������ڻ���������========");
		return dto;
	}

	/**
	 * ������ϵ���������
	 *
	 * @param dto IGASM07DTO
	 * @return IGASM07DTO
	 */
	public IGASM07DTO updateEntityItemRelationAction(IGASM07DTO dto) throws BLException {
		log.debug("========������ϵ���������ʼ========");
		IGASM0707Form form = dto.getIgasm0707Form();

		//����ʱ���趨
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

		form.setEirupdtime(datetime);
		
		this.ig313BL.updateIG313Info(form);

		dto.addMessage(new ActionMessage( "IGCO10000.I005", "������ϵ��Ϣ") );

		log.debug("========������ϵ�������������========");
		return dto;
	}
	
}
