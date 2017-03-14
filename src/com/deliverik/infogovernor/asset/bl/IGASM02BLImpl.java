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
 * 资产配置管理业务逻辑实现
 *
 */
public class IGASM02BLImpl extends BaseBLImpl implements IGASM02BL {

	static Log log = LogFactory.getLog(IGASM02BLImpl.class);

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
	
	/** 资产取值范围下拉数据BL */
	protected IG545BL ig545BL;
	
	/** 资产关联关系下拉数据BL */
	protected CodeDetailBL codeDetailBL;
	
	/** 配置项BL */
	protected IG225BL ig225BL;
	/** 依赖关系表BL */
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
	 * 配置项信息查询处理
	 *
	 * @param dto IGASM02DTO
	 * @return IGASM02DTO
	 */
	public IGASM02DTO searchEntityItemAction(IGASM02DTO dto) throws BLException {

		log.debug("========配置项信息查询处理开始========");
		
		//配置项信息查询件数取得 
		int totalCount = this.ig013BL.getIG688InfoSearchCount(dto.getEntityItemVWSearchCond());
		
		if (totalCount == 0) {
			log.debug("========配置项信息查询数据不存在========");
			//配置项信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========配置项信息查询数据件数过多========");
			//配置项信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//分页用信息取得
		PagingDTO pDto = dto.getPagingDto();

		//当前页配置项信息取得
		List<IG688Info> entityItemVWInfoList = this.ig013BL.searchIG688Info(dto.getEntityItemVWSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setEntityItemVWInfoList(entityItemVWInfoList);

		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========配置项信息查询处理终了========");
		return dto;
	}
	
	/**
	 * 配置项信息登记处理
	 *
	 * @param dto IGASM02DTO
	 * @return IGASM02DTO
	 */
	public IGASM02DTO insertEntityItemAction(IGASM02DTO dto) throws BLException {
		log.debug("========配置项信息登记处理开始========");
		//输入Form取得
		IGASM0202Form form = dto.getIgasm0202Form();
		
		/*//类型ID取得
		EntitySearchCondImpl cond = new EntitySearchCondImpl();
		cond.setElabel(form.getElabel());
		
		//登记处理前的资产信息确认
		List<Entity> entityList = this.ig117BL.searchEntity(cond, 0, 0);
		
		if ( entityList == null || entityList.size() ==0 ) {
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","(编号=" + form.getElabel() + ")资产基本");
		}
		
		Entity entity = entityList.get(0);
		
		form.setEid(entity.getEid());*/
		form.setEidStr(form.getEid().toString());
		
		//更新时间设定
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		
		form.setEiupdtime(datetime);
		
		//大版本设定（固定设为0）
		form.setEiversion(0);
		
		//小版本设定（固定设为0）
		form.setEismallversion(0);

		//配置项信息登录
		IG013Info entityItem = this.ig013BL.registIG013Info(dto.getIgasm0202Form());
		
		form.setEiidStr(entityItem.getEiid().toString());
		
		dto.setIgasm0202Form(form);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "配置项基本信息") );

		log.debug("========配置项信息登记处理终了========");
		return dto;
	}

	/**
	 * 配置项信息删除处理
	 *
	 * @param dto IGASM02DTO
	 * @return IGASM02DTO
	 */
	public IGASM02DTO deleteEntityItemAction(IGASM02DTO dto) throws BLException {
		log.debug("========配置项信息删除处理开始========");
		
		for( int i=0;i<dto.getDeleteEntityItem().length;i++ ){
			String eiid = dto.getDeleteEntityItem()[i];
			
			//删除前删除对象配置项确认
			IG013Info entityItem = this.ig013BL.searchIG013InfoByKey(Integer.parseInt(eiid));
			
			if (entityItem == null){
				throw new BLException("IGCO10000.E004","删除对象配置项基本");
			}

			//配置项删除
			this.ig013BL.deleteIG013Info(entityItem);
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I006","配置项信息"));

		log.debug("========配置项信息删除处理终了========");
		return dto;
	}

	/**
	 * 配置项配置信息编辑画面初期化处理
	 *
	 * @param dto IGASM02DTO
	 * @return IGASM02DTO
	 */
	public IGASM02DTO initIGASM0204Action(IGASM02DTO dto) throws BLException {

		log.debug("========配置项配置信息编辑画面初期化处理开始========");
		
		IGASM0204Form form = dto.getIgasm0204Form();
		
		//配置项信息检索
		IG688Info entityItemVWInfo = this.ig013BL.searchIG688InfoByKey(
				form.getEiid());
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","配置项");
		}
		
		form.setEidesc(entityItemVWInfo.getEidesc());
//		form.setEistatus(entityItemVWInfo.getEistatus());
		form.setEiorgsyscoding(entityItemVWInfo.getEiorgsyscoding());
		dto.setEntityItemVWInfo(entityItemVWInfo);
		form.setEsyscoding_q(entityItemVWInfo.getEsyscoding());
		//判断登陆用户是否有查看该资产配置信息的权限
		Boolean flag = this.ig013BL.checkIG688InfoDomain(dto.getUser(), entityItemVWInfo);

		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}else{
			dto.setFlag(flag);
		}
		
		
		//配置项配置信息查询件数取得 
		int totalCount = this.ig800BL.getIG002InfoSearchCount(form);
		
		if (totalCount == 0) {
			log.debug("========配置项配置信息查询数据不存在========");
			//配置项配置信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I007",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========配置项配置信息查询数据件数过多========");
			//配置项配置信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//配置项配置信息全件查询
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
		
		//画面显示用信息设定
		
		form.setCivalue(civalue);
		
		dto.setConfigItemVWInfoMap(map);
//		dto.addMessage(new ActionMessage("IGCO10000.I007",totalCount));
		

		
		log.debug("========配置项配置信息编辑画面初期化处理终了========");
		return dto;
	}
	
	/**
	 * 配置项配置信息编辑处理
	 *
	 * @param dto IGASM02DTO
	 * @return IGASM02DTO
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public IGASM02DTO editEntityItemAction(IGASM02DTO dto) throws BLException, FileNotFoundException, IOException {
		log.debug("========配置项配置信息编辑处理开始========");
		//版本号生成
		IGASM0204Form form = dto.getIgasm0204Form();
		
		int version = form.getEiversion() + 1;
		
		//配置项基本信息更新
		IG013TB entityItem = (IG013TB) this.ig013BL.searchIG013InfoByKey(form.getEiid());
		
		//配置项状态
//		entityItem.setEistatus(form.getEistatus());
		//配置项版本
		entityItem.setEiversion(version);
		
		//配置项说明
		entityItem.setEidesc(form.getEidesc());

		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		
		//更新时间
		entityItem.setEiupdtime(datetime);
		
		this.ig013BL.updateIG013Info(entityItem);
		
		//调用更新BL
		
		//配置项配置信息更新
		if (form.getCiid() != null && form.getCiid().length > 0 ) {
			
			for( int i=0 ; i < form.getCiid().length; i++ ){
				IG800TB configItem = new IG800TB();
				if (StringUtils.isEmpty(form.getCiid()[i])) {
					//插入
					//配置项ID
					configItem.setEiid(form.getEiid());
					//资产配置ID
					configItem.setCid(Integer.parseInt(form.getCid()[i]));
					//类型ID
					configItem.setEid(Integer.parseInt(form.getEid()[i]));
					//类型层次码
					configItem.setEsyscoding(form.getEsyscoding()[i]);
					//内容
					configItem.setCivalue(form.getCivalue()[i]);
					
					//版本号
					configItem.setCiversion(version);
					//更新时间
					configItem.setCiupdtime(datetime);
					
					configItem = (IG800TB) this.ig800BL.registIG800Info(configItem);
					
					//属性类别为资产时，增加关联关系
					if("4".equals(form.getCiattach()[i]) && StringUtils.isNotEmpty(form.getCivalue()[i])){
						IG313TB e = new IG313TB();
						e.setPareid(entityItem.getEid());
						e.setPareiid(entityItem.getEiid());
						String str = form.getCivalue()[i];
						IG013Info ei = this.ig013BL.searchIG013InfoByKey(Integer.parseInt(str.substring(str.lastIndexOf("(")+1, str.length()-1)));
						e.setCldeid(ei.getEid());
						e.setCldeiid(ei.getEiid());
						//双向
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
						//查询属性名称
						IG225Info config = this.ig225BL.searchIG225InfoByKey(Integer.parseInt(form.getCid()[i]));
						String cname = config.getCname();
						//增加key
						e.setEirdesc("由配置项："+cname+"建立("+entityItem.getEiid()+"_"+configItem.getCiid()+"_"+ei.getEiid()+")");
						//设置状态为C，关系管理中不可删除
						e.setEirstatus("C");
						this.ig313BL.registIG313Info(e);
					}
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
					
					//配置项配置ID删除
					insertConfigItem.setCiid(null);

					configItem = (IG800TB) this.ig800BL.registIG800Info(insertConfigItem);
					//属性类别为资产时，增加关联关系
					if("4".equals(form.getCiattach()[i]) && StringUtils.isNotEmpty(form.getCivalue()[i])){
						IG313TB e = new IG313TB();
						e.setPareid(entityItem.getEid());
						e.setPareiid(entityItem.getEiid());
						String str = form.getCivalue()[i];			
						IG013Info ei = this.ig013BL.searchIG013InfoByKey(Integer.parseInt(str.substring(str.lastIndexOf("(")+1, str.length()-1)));
				
						e.setCldeid(ei.getEid());
						e.setCldeiid(ei.getEiid());
						//校验关系是否存在
						IG313SearchCondImpl cond = new IG313SearchCondImpl();
						cond.setEirdesc("("+entityItem.getEiid()+"_"+form.getCiid()[i]+"_"+ei.getEiid()+")");
						cond.setEirstatus("C");
						cond.setDeleteflag("0");
						List<IG313Info> eirlist = this.ig313BL.searchMaxIG313Info(cond);
						if(eirlist.isEmpty()){
							//删除原来已有的关系
							IG313SearchCondImpl eircond = new IG313SearchCondImpl();
							eircond.setEirdesc("("+entityItem.getEiid()+"_"+form.getCiid()[i]+"_");
							eircond.setEirstatus("C");
							eircond.setDeleteflag("0");
							List<IG313Info> eir = this.ig313BL.searchMaxIG313Info(eircond);
							for (IG313Info entityItemRelation : eir) {
								this.ig313BL.deleteIG313Info(entityItemRelation);
							}
							//双向
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
							//查询属性名称
							IG225Info config = this.ig225BL.searchIG225InfoByKey(Integer.parseInt(form.getCid()[i]));
							String cname = config.getCname();
							//增加key
							e.setEirdesc("由配置项："+cname+"建立("+entityItem.getEiid()+"_"+configItem.getCiid()+"_"+ei.getEiid()+")");
							//设置状态为C，关系管理中不可删除
							e.setEirstatus("C");
							this.ig313BL.registIG313Info(e);
						}
					}
					if("4".equals(form.getCiattach()[i]) && StringUtils.isEmpty(form.getCivalue()[i])){
						//删除原来已有的关系
						IG313SearchCondImpl eircond = new IG313SearchCondImpl();
						eircond.setEirdesc("("+entityItem.getEiid()+"_"+form.getCiid()[i]+"_");
						eircond.setEirstatus("C");
						eircond.setDeleteflag("0");
						List<IG313Info> eir = this.ig313BL.searchMaxIG313Info(eircond);
						for (IG313Info entityItemRelation : eir) {
							this.ig313BL.deleteIG313Info(entityItemRelation);
						}
					}
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
						//配置项ID
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
	
		dto.addMessage(new ActionMessage("IGCO10000.I005","配置项配置信息"));
		
		log.debug("========配置项配置信息编辑处理终了========");
		
		return dto;
	}

	/**
	 * 配置项配置信息历史记录画面初期化处理
	 *
	 * @param dto IGASM02DTO
	 * @return IGASM02DTO
	 */
	public IGASM02DTO initIGASM0205Action(IGASM02DTO dto) throws BLException {
		log.debug("========配置项配置信息历史记录画面初期化处理开始========");
		
		//配置项信息检索
		IG688Info entityItemVWInfo = this.ig013BL.searchIG688InfoByKey(
				dto.getIgasm0205Form().getEiid());
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","配置项");
		}
		
		if (entityItemVWInfo.getEiversion() == 0 && entityItemVWInfo.getEismallversion() == 0) {
			dto.addMessage(new ActionMessage("IGASM0205.W001"));
		}
		
		dto.setEntityItemVWInfo(entityItemVWInfo);
		
		if ((dto.getIgasm0205Form().getCiversion())!=null) {
			dto.getIgasm0205Form().setCiversion(String.valueOf(entityItemVWInfo.getEiversion()));
		}
		//获取历史版本更新时间
		dto.setConfigItemVersionTime(this.ig013BL.searchVersionUpdateTime(dto.getIgasm0205Form().getEiid()));
		
		//判断登陆用户是否有查看该资产配置信息的权限
		Boolean flag = this.ig013BL.checkIG688InfoDomain(dto.getUser(), entityItemVWInfo);

		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}else{
			dto.setFlag(flag);
		}
		
		log.debug("========配置项配置信息历史记录画面初期化处理终了========");
		return dto;
	}

	/**
	 * 配置项关系管理画面初期化处理
	 *
	 * @param dto IGASM02DTO
	 * @return IGASM02DTO
	 */
	public IGASM02DTO initIGASM0206Action(IGASM02DTO dto) throws BLException {
		log.debug("========配置项关系管理画面初期化处理开始========");
		
		//配置项信息检索
		IG688Info entityItemVWInfo = this.ig013BL.searchIG688InfoByKey(
				dto.getIgasm0206Form().getEiid());
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","配置项");
		}
		
		dto.setEntityItemVWInfo(entityItemVWInfo);
		
		//正向关联关系检索
		IG313SearchCondImpl parcond = new IG313SearchCondImpl();
		
		parcond.setEiid(dto.getIgasm0206Form().getEiid());
		
		Map<String,List<IG313Info>> parmap = new LinkedHashMap<String,List<IG313Info>>();
		//判断登陆用户是否有查看该资产配置信息的权限
		Boolean flag = this.ig013BL.checkIG688InfoDomain(dto.getUser(), entityItemVWInfo);

		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}else{
			dto.setFlag(flag);
		}
		
		
		//配置项关系信息查询件数取得 
		int totalCount = this.ig313BL.getIG313InfoSearchCount(parcond);
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========配置项关系信息查询数据件数过多========");
			//配置项关系信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		if ( totalCount>0 ) {
			//配置项关系信息全件检索
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
		
		//逆向关联关系检索
		//关联关系检索
		IG313SearchCondImpl cldcond = new IG313SearchCondImpl();
		
		cldcond.setCldeiid(dto.getIgasm0206Form().getEiid());
		
		//配置项关系信息查询件数取得 
		totalCount = this.ig313BL.getIG313InfoSearchCount(cldcond);
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========配置项关系信息查询数据件数过多========");
			//配置项关系信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//配置项关系信息全件检索
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
		
		log.debug("========配置项关系管理画面初期化处理终了========");
		return dto;
	}
	
	/**
	 * 设备依赖关系画面初期化处理
	 *
	 * @param dto IGASM02DTO
	 * @return IGASM03DTO
	 */
	public IGASM02DTO initIGASM0206BelongAction(IGASM02DTO dto) throws BLException {
		log.debug("========设备依赖关系管理画面初期化处理开始========");
		
		//设备信息检索
		IG688Info entityItemVWInfo = this.ig013BL.searchIG688InfoByKey(
				dto.getIgasm0206Form().getEiid());
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004", "资产基本");
		}
		
		dto.setEntityItemVWInfo(entityItemVWInfo);
		
		//判断登陆用户是否有查看该资产配置信息的权限
		Boolean flag = this.ig013BL.checkIG688InfoDomain(dto.getUser(), entityItemVWInfo);

		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}else{
			dto.setFlag(flag);
		}
		
		//依赖关系检索
		EiBelongRelationSearchCondImpl belongcond = new EiBelongRelationSearchCondImpl();
		belongcond.setBrpareiid(String.valueOf(entityItemVWInfo.getEiid()));
		belongcond.setBrparsmallversion(String.valueOf(entityItemVWInfo.getEismallversion()));
		belongcond.setBrparversion(String.valueOf(entityItemVWInfo.getEiversion()));
		belongcond.setDeleteflag("0");
		List<EiBelongRelationInfo> belongRelationList = null;
		//设备依赖关系信息查询件数取得 
		int totalCount = this.eiBelongRelationBL.getSearchCount(belongcond);
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========设备关系信息查询数据件数过多========");
			//设备依赖关系信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		if ( totalCount>0 ) {
			//设备依赖关系信息全件检索
			belongRelationList = this.eiBelongRelationBL.searchEiBelongRelation(belongcond);
		}

		dto.setBelongRelationList(belongRelationList);

		
		log.debug("========设备依赖关系管理画面初期化处理终了========");
		return dto;
	}
	/**
	 * 配置项关系删除处理
	 *
	 * @param dto IGASM02DTO
	 * @return IGASM02DTO
	 */
	public IGASM02DTO deleteEntityItemRelationAction(IGASM02DTO dto) throws BLException {
		log.debug("========配置项关系删除处理开始========");
		
		for( int i=0;i<dto.getDeleteEntityItemRelation().length;i++ ){
			String eirid = dto.getDeleteEntityItemRelation()[i];
			
			IG313Info entityItemRelation = 
				this.ig313BL.searchIG313InfoByKey(Integer.parseInt(eirid));
			
			if (entityItemRelation == null){
				throw new BLException("IGCO10000.E004","删除对象配置项关系");
			}

			this.ig313BL.deleteIG313Info(entityItemRelation);
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I006","配置项关系信息"));

		log.debug("========配置项关系删除处理终了========");
		return dto;
	}

	/**
	 * 配置项关系登记处理
	 *
	 * @param dto IGASM02DTO
	 * @return IGASM02DTO
	 */
	public IGASM02DTO insertEntityItemRelationAction(IGASM02DTO dto) throws BLException {
		log.debug("========配置项关系登记处理开始========");
		
		IGASM0207Form form = dto.getIgasm0207Form();
		
		//配置项ID（子）取得
		IG688SearchCondImpl cond = new IG688SearchCondImpl();
		
		cond.setElabel(form.getElabel());
		cond.setEilabel(form.getEilabel());
		
		List<IG688Info> entityItemVWList = this.ig013BL.searchIG688Info(cond, 0, 0);
		
		if ( entityItemVWList==null || entityItemVWList.size() == 0 ) {
			throw new BLException("IGCO10000.E004","(资产编号=" + form.getElabel() + ",配置项编号=" 
					+ form.getEilabel() + ")配置项");
		}
		
		form.setCldeiid(entityItemVWList.get(0).getEiid());
		form.setCldeid(Integer.parseInt(entityItemVWList.get(0).getEid()));
		
		//配置项ID（父）和（子）检测
		if (form.getPareiid().intValue() == form.getCldeiid().intValue()) {
			//配置项ID（父）= （子）
			throw new BLException(BLErrorType.ENTITY_ITEM_RELATION_ERROR,
					"IGCO10000.E012","配置项");
		}
		
		//更新时间设定
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

		form.setEirupdtime(datetime);
		
		//资产关系登记
		IG313Info ret = 
			this.ig313BL.registIG313Info(dto.getIgasm0207Form());
		
		dto.setEntityItemRelation(ret);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "配置项关系信息") );
		
		log.debug("========配置项关系登记处理终了========");
		return dto;
	}
	
	/**
	 * 配置项关系编辑画面初期化处理
	 *
	 * @param dto IGASM02DTO
	 * @return IGASM02DTO
	 */
	public IGASM02DTO initIGASM0207Action(IGASM02DTO dto) throws BLException {
		log.debug("========配置项关系编辑画面初期化处理开始========");
		
		IGASM0207Form form = dto.getIgasm0207Form();
		IG313TB ret = 		
			(IG313TB) this.ig313BL.searchIG313InfoByKey(
				form.getEirid());
		
		if ( ret == null ){
			throw new BLException("IGCO10000.E004","编辑对象配置项关系");
		}
		
		//检索结果设定
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
		
		log.debug("========配置项关系编辑画面初期化处理终了========");
		return dto;
	}

	/**
	 * 配置项关系变更处理处理
	 *
	 * @param dto IGASM02DTO
	 * @return IGASM02DTO
	 */
	public IGASM02DTO updateEntityItemRelationAction(IGASM02DTO dto) throws BLException {
		log.debug("========配置项关系变更处理处理开始========");
		IGASM0207Form form = dto.getIgasm0207Form();

		//更新时间设定
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

		form.setEirupdtime(datetime);
		
		this.ig313BL.updateIG313Info(form);

		dto.addMessage(new ActionMessage( "IGCO10000.I005", "配置项关系信息") );

		log.debug("========配置项关系变更处理处理终了========");
		return dto;
	}
	
	/**
	 *	获取配置项关联关系处理
	 *
	 * @param dto IGASM02DTO
	 * @return IGASM02DTO
	 */
	public IGASM02DTO searchRelationListAction(IGASM02DTO dto) throws BLException {
		log.debug("========获取配置项关联关系处理开始========");
		List<LabelValueBean> list = this.codeDetailBL.searchLabelValueBeanList(CommonDefineUtils.ENTIY_CATEGORY_DEVICE,CodeDefine.getCodeDefine("ENTITY_ITEM_RELATION_CODE").getCcid());
		dto.setRelationList(list);
		log.debug("========获取配置项关联关系处理终了========");
		return dto;
	}
}
