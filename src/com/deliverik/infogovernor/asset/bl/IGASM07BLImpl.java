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
 * 机房配置管理业务逻辑实现
 *
 */
public class IGASM07BLImpl extends BaseBLImpl implements IGASM07BL {

	static Log log = LogFactory.getLog(IGASM07BLImpl.class);

	/** 资产信息BL */
	protected IG117BL ig117BL;

	/** 配置项信息BL */
	protected IG013BL ig013BL;
	
	/** 资产配置项BL */
	protected IG800BL ig800BL;
	
	/** 配置项关系BL */
	protected IG313BL ig313BL;
	
	/** 文件上传BL */
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
	 * 机房信息查询处理
	 *
	 * @param dto IGASM07DTO
	 * @return IGASM07DTO
	 */
	public IGASM07DTO searchEntityItemAction(IGASM07DTO dto) throws BLException {

		log.debug("========机房信息查询处理开始========");
		
		//机房信息查询件数取得 
		int totalCount = this.ig013BL.getIG688InfoSearchCount(dto.getEntityItemVWSearchCond());
		
		if (totalCount == 0) {
			log.debug("========机房信息查询数据不存在========");
			//机房信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========机房信息查询数据件数过多========");
			//机房信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//分页用信息取得
		PagingDTO pDto = dto.getPagingDto();

		//当前页机房信息取得
		List<IG688Info> entityItemVWInfoList = this.ig013BL.searchIG688Info(dto.getEntityItemVWSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setEntityItemVWInfoList(entityItemVWInfoList);

		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========机房信息查询处理终了========");
		return dto;
	}
	
	/**
	 * 机房信息登记处理
	 *
	 * @param dto IGASM07DTO
	 * @return IGASM07DTO
	 */
	public IGASM07DTO insertEntityItemAction(IGASM07DTO dto) throws BLException {
		log.debug("========机房信息登记处理开始========");
		//输入Form取得
		IGASM0702Form form = dto.getIgasm0702Form();
		
		//类型ID取得
		IG117SearchCondImpl cond = new IG117SearchCondImpl();
		cond.setElabel(form.getElabel());
		
		//登记处理前的资产信息确认
		List<IG117Info> entityList = this.ig117BL.searchIG117Info(cond, 0, 0);
		
		if ( entityList == null || entityList.size() ==0 ) {
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","(编号=" + form.getElabel() + ")资产基本");
		}
		
		IG117Info entity = entityList.get(0);
		
		//***************************************************************************
		//类型分类检测
		if (!entity.getEcategory().equals(CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_ROOM)) {
			//机房以外的情况
			throw new BLException(BLErrorType.ENTITY_CATEGORY_ERROR,
					"IGCO10000.E011","机房");
		}
		//***************************************************************************
		
		form.setEid(entity.getEid());
		form.setEidStr(entity.getEid().toString());
		
		//更新时间设定
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		
		form.setEiupdtime(datetime);
		
		//大版本设定（固定设为0）
		form.setEiversion(0);
		
		//小版本设定（固定设为0）
		form.setEismallversion(0);

		//机房信息登录
		IG013Info entityItem = this.ig013BL.registIG013Info(dto.getIgasm0702Form());
		
		form.setEiidStr(entityItem.getEiid().toString());
		
		dto.setIgasm0702Form(form);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "机房基本信息") );

		log.debug("========机房信息登记处理终了========");
		return dto;
	}

	/**
	 * 机房信息删除处理
	 *
	 * @param dto IGASM07DTO
	 * @return IGASM07DTO
	 */
	public IGASM07DTO deleteEntityItemAction(IGASM07DTO dto) throws BLException {
		log.debug("========机房信息删除处理开始========");
		
		for( int i=0;i<dto.getDeleteEntityItem().length;i++ ){
			String eiid = dto.getDeleteEntityItem()[i];
			
			//删除前删除对象机房确认
			IG013Info entityItem = this.ig013BL.searchIG013InfoByKey(Integer.parseInt(eiid));
			
			if (entityItem == null){
				throw new BLException("IGCO10000.E004","删除对象机房基本");
			}

			//机房删除
			this.ig013BL.deleteIG013Info(entityItem);
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I006","机房信息"));

		log.debug("========机房信息删除处理终了========");
		return dto;
	}

	/**
	 * 机房配置信息编辑画面初期化处理
	 *
	 * @param dto IGASM07DTO
	 * @return IGASM07DTO
	 */
	public IGASM07DTO initIGASM0704Action(IGASM07DTO dto) throws BLException {

		log.debug("========机房配置信息编辑画面初期化处理开始========");
		
		IGASM0704Form form = dto.getIgasm0704Form();
		
		//机房信息检索
		IG688Info entityItemVWInfo = this.ig013BL.searchIG688InfoByKey(
				form.getEiid());
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","机房");
		}
		
		form.setEidesc(entityItemVWInfo.getEidesc());
//		form.setEistatus(entityItemVWInfo.getEistatus());
		
		dto.setEntityItemVWInfo(entityItemVWInfo);
		form.setEsyscoding_q(entityItemVWInfo.getEsyscoding());
		
		//机房配置信息查询件数取得 
		int totalCount = this.ig800BL.getIG002InfoSearchCount(form);
		
		if (totalCount == 0) {
			log.debug("========机房配置信息查询数据不存在========");
			//机房配置信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I007",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========机房配置信息查询数据件数过多========");
			//机房配置信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//机房配置信息全件查询
		List<IG002Info> configItemVWInfoList = this.ig800BL.searchIG002Info(
				form, 0, 0);
		
		//画面显示用信息设定
		String[] civalue = new String[totalCount];
		
		for(int i=0;i<totalCount;i++) {
			civalue[i] = configItemVWInfoList.get(i).getCivalue();
		}
		
		form.setCivalue(civalue);
		
		dto.setConfigItemVWInfoList(configItemVWInfoList);
		

		dto.addMessage(new ActionMessage("IGCO10000.I007",totalCount));
		
		log.debug("========机房配置信息编辑画面初期化处理终了========");
		return dto;
	}
	
	/**
	 * 机房配置信息编辑处理
	 *
	 * @param dto IGASM07DTO
	 * @return IGASM07DTO
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public IGASM07DTO editEntityItemAction(IGASM07DTO dto) throws BLException, FileNotFoundException, IOException {
		log.debug("========机房配置信息编辑处理开始========");
		//版本号生成
		IGASM0704Form form = dto.getIgasm0704Form();
		
		int version = form.getEiversion() + 1;
		
		//机房基本信息更新
		IG013TB entityItem = (IG013TB) this.ig013BL.searchIG013InfoByKey(form.getEiid());

		//资产关系信息版本升级处理
		this.ig313BL.upgradeIG313Info(entityItem.getEiid(), entityItem.getEiversion(), entityItem.getEismallversion(),
				version, 0);
		//机房状态
//		entityItem.setEistatus(form.getEistatus());
		//机房版本
		entityItem.setEiversion(version);
		
		//机房说明
		entityItem.setEidesc(form.getEidesc());

		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		
		//更新时间
		entityItem.setEiupdtime(datetime);
		
		this.ig013BL.updateIG013Info(entityItem);
		
		//调用更新BL
		
		//机房配置信息更新
		if (form.getCiid() != null && form.getCiid().length > 0 ) {
			
			for( int i=0 ; i < form.getCiid().length; i++ ){
				IG800TB configItem = new IG800TB();
				if (StringUtils.isEmpty(form.getCiid()[i])) {
					//插入
					//机房ID
					configItem.setEiid(form.getEiid());
					//资产配置ID
					configItem.setCid(Integer.parseInt(form.getCid()[i]));
					//类型ID
					configItem.setEid(Integer.parseInt(form.getEid()));
					//内容
					configItem.setCivalue(form.getCivalue()[i]);
					//大版本号
					configItem.setCiversion(version);
					//小版本号
					configItem.setCismallversion(0);
					//更新时间
					configItem.setCiupdtime(datetime);
					
					configItem = (IG800TB) this.ig800BL.registIG800Info(configItem);
					log.debug("资产配置项：[资产配置ID:" + form.getCid()[i] + "]插入处理成功。");
					
				} else {
					//更新
					configItem = (IG800TB) this.ig800BL.searchIG800InfoByKey(Integer.parseInt(form.getCiid()[i]));
					
					IG800TB insertConfigItem = null;
					
					insertConfigItem = (IG800TB) SerializationUtils.clone(configItem);
					//内容
					insertConfigItem.setCivalue(form.getCivalue()[i]);
					//版本号
					insertConfigItem.setCiversion(version);
					//更新时间
					insertConfigItem.setCiupdtime(datetime);
					
					//机房配置ID删除
					insertConfigItem.setCiid(null);

					configItem = (IG800TB) this.ig800BL.registIG800Info(insertConfigItem);
					log.debug("资产配置项：[资产配置ID:" + form.getCid()[i] + "]更新处理成功。");
				}
				
				//上传文件检测
				if (form.getCiattach()[i].toUpperCase().equals("1")) {
					FormFile file = form.getAttachFile(i);
					if ( file != null && file.getFileSize() > 0) {
						//上传文件存在的情况
						//上传文件路径
						String rootPath = ResourceUtility.getString("UPLOAD_FILE_ROOT_PATH");
						StringBuffer pathBuf = new StringBuffer();
						
						//根目录
						pathBuf.append(rootPath);
						//机能ID
						pathBuf.append("asm"+File.separator);
						//机房ID
						pathBuf.append(configItem.getEiid());
						pathBuf.append(File.separator);
						
						StringBuffer fileName = new StringBuffer();
						
						//扩展名取得
						String fileType = "";
						String sFileName = file.getFileName();
						int point = sFileName.lastIndexOf(".");
						if (point != -1) {
							fileType = sFileName.substring(point);
							fileName.append(sFileName.substring(0, point));
						}
						
						//文件名后加版本号
						fileName.append("_");
						fileName.append(configItem.getCiversion());
						//文件扩展名
						fileName.append(fileType);

						//文件上传处理
						this.fileUploadBL.saveFile(file, pathBuf.toString(), fileName.toString());
						
						//上传文件名保存
						configItem.setCivalue(fileName.toString());
						
						this.ig800BL.updateIG800Info(configItem);					
						
					}
				}
			}
			
		}
	
		dto.addMessage(new ActionMessage("IGCO10000.I005","机房配置信息"));
		
		log.debug("========机房配置信息编辑处理终了========");
		
		return dto;
	}

	/**
	 * 机房配置信息历史记录画面初期化处理
	 *
	 * @param dto IGASM07DTO
	 * @return IGASM07DTO
	 */
	public IGASM07DTO initIGASM0705Action(IGASM07DTO dto) throws BLException {
		log.debug("========机房配置信息历史记录画面初期化处理开始========");
		
		//机房信息检索
		IG688Info entityItemVWInfo = this.ig013BL.searchIG688InfoByKey(
			dto.getIgasm0705Form().getEiid());
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","机房");
		}
		
		if (entityItemVWInfo.getEiversion() == 0 && entityItemVWInfo.getEismallversion() == 0) {
			dto.addMessage(new ActionMessage("IGASM0205.W001"));
		}
		
		dto.setEntityItemVWInfo(entityItemVWInfo);
		
		if ((dto.getIgasm0705Form().getCiversion())!=null) {
			dto.getIgasm0705Form().setCiversion(String.valueOf(entityItemVWInfo.getEiversion()));
		}
		
		//机房配置信息查询件数取得 
		int totalCount = this.ig800BL.getIG800InfoSearchCount(dto.getIgasm0705Form());
		
		if (totalCount == 0) {
			log.debug("========查询数据不存在========");
			//查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I007",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========查询数据件数过多========");
			//查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//机房配置信息全件检索
		List<IG800Info> configItemList = this.ig800BL.searchIG800Info(
				dto.getIgasm0705Form(), 0, 0);
		
		dto.setConfigItemList(configItemList);

		dto.addMessage(new ActionMessage("IGCO10000.I007",totalCount));
		
		log.debug("========机房配置信息历史记录画面初期化处理终了========");
		return dto;
	}

	/**
	 * 机房关系管理画面初期化处理
	 *
	 * @param dto IGASM07DTO
	 * @return IGASM07DTO
	 */
	public IGASM07DTO initIGASM0706Action(IGASM07DTO dto) throws BLException {
		log.debug("========机房关系管理画面初期化处理开始========");
		
		//机房信息检索
		IG688Info entityItemVWInfo = this.ig013BL.searchIG688InfoByKey(
				Integer.parseInt(dto.getIgasm0706Form().getEiid()));
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","机房");
		}
		
		dto.setEntityItemVWInfo(entityItemVWInfo);
		
		//正向关联关系检索
		IG313SearchCondImpl parcond = new IG313SearchCondImpl();
		if(dto.getIgasm0706Form().getEiid()!=null){
		parcond.setPareiid(Integer.parseInt(dto.getIgasm0706Form().getEiid()));}
		parcond.setParversion(entityItemVWInfo.getEiversion());
		parcond.setParsmallversion(entityItemVWInfo.getEismallversion());
		parcond.setDeleteflag("0");
		
		//机房关系信息查询件数取得 
		int totalCount = this.ig313BL.getIG313InfoSearchCount(parcond);
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========机房关系信息查询数据件数过多========");
			//机房关系信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		if ( totalCount>0 ) {
			//机房关系信息全件检索
			List<IG313Info> parEntityItemRelationList = 
				this.ig313BL.searchMaxIG313Info(parcond);
			
			dto.setParEntityItemRelationList(parEntityItemRelationList);
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I007",totalCount));
		
		//逆向关联关系检索
		//关联关系检索
		IG313SearchCondImpl cldcond = new IG313SearchCondImpl();
		if((dto.getIgasm0706Form().getEiid())!=null){
		cldcond.setCldeiid(Integer.parseInt(dto.getIgasm0706Form().getEiid()));}
		cldcond.setCldversion(entityItemVWInfo.getEiversion());
		cldcond.setCldsmallversion(entityItemVWInfo.getEismallversion());
		cldcond.setDeleteflag("0");
		
		//机房关系信息查询件数取得 
		totalCount = this.ig313BL.getIG313InfoSearchCount(cldcond);
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========机房关系信息查询数据件数过多========");
			//机房关系信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//机房关系信息全件检索
		List<IG313Info> cldEntityItemRelationList = 
			this.ig313BL.searchMaxIG313Info(cldcond);
		
		dto.setCldEntityItemRelationList(cldEntityItemRelationList);

		
		
		log.debug("========机房关系管理画面初期化处理终了========");
		return dto;
	}
	
	/**
	 * 机房关系删除处理
	 *
	 * @param dto IGASM07DTO
	 * @return IGASM07DTO
	 */
	public IGASM07DTO deleteEntityItemRelationAction(IGASM07DTO dto) throws BLException {
		log.debug("========机房关系删除处理开始========");
		
		for( int i=0;i<dto.getDeleteEntityItemRelation().length;i++ ){
			String eirid = dto.getDeleteEntityItemRelation()[i];
			
			IG313Info entityItemRelation = 
				this.ig313BL.searchIG313InfoByKey(Integer.parseInt(eirid));
			
			if (entityItemRelation == null){
				throw new BLException("IGCO10000.E004","删除对象机房关系");
			}

			this.ig313BL.deleteIG313Info(entityItemRelation);
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I006","机房关系信息"));

		log.debug("========机房关系删除处理终了========");
		return dto;
	}

	/**
	 * 机房关系登记处理
	 *
	 * @param dto IGASM07DTO
	 * @return IGASM07DTO
	 */
	public IGASM07DTO insertEntityItemRelationAction(IGASM07DTO dto) throws BLException {
		log.debug("========机房关系登记处理开始========");
		
		IGASM0707Form form = dto.getIgasm0707Form();
		
		//机房ID（子）取得
		IG688SearchCondImpl cond = new IG688SearchCondImpl();
		
		cond.setElabel(form.getElabel());
		cond.setEilabel(form.getEilabel());
		
		List<IG688Info> entityItemVWList = this.ig013BL.searchIG688Info(cond, 0, 0);
		
		if ( entityItemVWList==null || entityItemVWList.size() == 0 ) {
			throw new BLException("IGCO10000.E004","(资产编号=" + form.getElabel() + ",机房编号=" 
					+ form.getEilabel() + ")机房");
		}
		
		form.setCldeiid(entityItemVWList.get(0).getEiid());
		form.setCldeid(Integer.parseInt(entityItemVWList.get(0).getEid()));
		
		//机房ID（父）和（子）检测
		if (form.getPareiid().intValue() == form.getCldeiid().intValue()) {
			//机房ID（父）= （子）
			throw new BLException(BLErrorType.ENTITY_ITEM_RELATION_ERROR,
					"IGCO10000.E012","机房");
		}
		
		//更新时间设定
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

		form.setEirupdtime(datetime);
		
		//资产关系登记
		IG313Info ret = 
			this.ig313BL.registIG313Info(dto.getIgasm0707Form());
		
		dto.setEntityItemRelation(ret);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "机房关系信息") );
		
		log.debug("========机房关系登记处理终了========");
		return dto;
	}
	
	/**
	 * 机房关系编辑画面初期化处理
	 *
	 * @param dto IGASM07DTO
	 * @return IGASM07DTO
	 */
	public IGASM07DTO initIGASM0707Action(IGASM07DTO dto) throws BLException {
		log.debug("========机房关系编辑画面初期化处理开始========");
		
		IGASM0707Form form = dto.getIgasm0707Form();
		IG313TB ret = 		
			(IG313TB) this.ig313BL.searchIG313InfoByKey(
				form.getEirid());
		
		if ( ret == null ){
			throw new BLException("IGCO10000.E004","编辑对象机房关系");
		}
		
		//检索结果设定
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
		
		log.debug("========机房关系编辑画面初期化处理终了========");
		return dto;
	}

	/**
	 * 机房关系变更处理处理
	 *
	 * @param dto IGASM07DTO
	 * @return IGASM07DTO
	 */
	public IGASM07DTO updateEntityItemRelationAction(IGASM07DTO dto) throws BLException {
		log.debug("========机房关系变更处理处理开始========");
		IGASM0707Form form = dto.getIgasm0707Form();

		//更新时间设定
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

		form.setEirupdtime(datetime);
		
		this.ig313BL.updateIG313Info(form);

		dto.addMessage(new ActionMessage( "IGCO10000.I005", "机房关系信息") );

		log.debug("========机房关系变更处理处理终了========");
		return dto;
	}
	
}
