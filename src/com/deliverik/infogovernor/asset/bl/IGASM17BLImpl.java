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
 * 组件配置管理业务逻辑实现
 *
 */
public class IGASM17BLImpl extends BaseBLImpl implements IGASM17BL {

	static Log log = LogFactory.getLog(IGASM17BLImpl.class);

	/** 版本号升级标识 */
	public static final String SAVE_VERSION_UP = "1";

	/** 版本号不升级标识 */
	public static final String SAVE_VERSION = "0";
	
	public static final String EIRRELATIONCODE="'012-012','012-001','012-001','012-006','012-003','012-012'";
	
	public static final String DEVICE_DEVICE = "001-001";
	
	public static final String DEVICE_DEVICE_CONN_ID = "1";
	
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
	
	/** 资产关联关系下拉数据BL */
	protected CodeDetailBL codeDetailBL;
	
	/** 资产取值范围下拉数据BL */
	protected IG545BL ig545BL;
	
	/** 机构BL */
	protected OrganizationBL organizationBL;
	
	/** 配置项BL */
	protected IG225BL ig225BL;
	
	/** 用户角色BL */
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
	 * 组件信息查询处理
	 *
	 * @param dto IGASM17DTO
	 * @return IGASM17DTO
	 */
	public IGASM17DTO searchEntityItemAction(IGASM17DTO dto) throws BLException {

		log.debug("========组件信息查询处理开始========");
		
		//组件信息查询件数取得 
		int totalCount = this.ig013BL.getIG688InfoSearchCount(dto.getEntityItemVWSearchCond());
		
		if (totalCount == 0) {
			log.debug("========组件信息查询数据不存在========");
			//组件信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========组件信息查询数据件数过多========");
			//组件信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//分页用信息取得
		PagingDTO pDto = dto.getPagingDto();

		//当前页组件信息取得
		List<IG688Info> entityItemVWInfoList = this.ig013BL.searchIG688Info(dto.getEntityItemVWSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setEntityItemVWInfoList(entityItemVWInfoList);

		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========组件信息查询处理终了========");
		return dto;
	}
	
	/**
	 * 组件信息登记处理
	 *
	 * @param dto IGASM17DTO
	 * @return IGASM17DTO
	 */
	public IGASM17DTO insertEntityItemAction(IGASM17DTO dto) throws BLException {
		log.debug("========组件信息登记处理开始========");
		//输入Form取得
		IGASM1702Form form = dto.getIgasm1702Form();
		
		form.setEidStr(form.getEid().toString());
		
		//更新时间设定
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		
		form.setEiupdtime(datetime);
		
		//大版本设定（固定设为0）
		form.setEiversion(0);
		
		//小版本设定（固定设为0）
		form.setEismallversion(0);

		//组件信息登录
		IG013Info entityItem = this.ig013BL.registIG013Info(dto.getIgasm1702Form());
		
		IG313TB eir = new IG313TB();
		eir.setPareid(entityItem.getEid());
		eir.setPareiid(entityItem.getEiid());
		eir.setParversion(0);
		eir.setParsmallversion(0);
		String deviceEid = dto.getIgasm1702Form().getDeviceEid();
		String moduleEid = dto.getIgasm1702Form().getModuleEid();
		if(StringUtils.isNotEmpty(deviceEid)){//所属设备
			eir.setCldeid(Integer.parseInt(deviceEid));
			eir.setCldeiid(Integer.parseInt(dto.getIgasm1702Form().getDeviceEiid()));
			IG013Info ei = this.ig013BL.searchIG013InfoByKey(eir.getCldeiid());
			eir.setCldversion(ei.getEiversion());
			eir.setCldsmallversion(ei.getEismallversion());
			eir.setEirrelation(CommonDefineUtils.MODULE_RELATION_ENTIY_ID);
			eir.setEirrelationcode(CommonDefineUtils.MODULE_RELATION_ENTIY_CODE);
			eir.setEirinfo("#" + eir.getCldeiid() + "#");//所属设备ID
		}else if(StringUtils.isNotEmpty(moduleEid)){//所属组件
			eir.setCldeid(Integer.parseInt(moduleEid));
			eir.setCldeiid(Integer.parseInt(dto.getIgasm1702Form().getModuleEiid()));
			IG013Info ei = this.ig013BL.searchIG013InfoByKey(eir.getCldeiid());
			eir.setCldversion(ei.getEiversion());
			eir.setCldsmallversion(ei.getEismallversion());
			//查询组件所属设备ID
			IG313SearchCondImpl cond = new IG313SearchCondImpl();
			cond.setPareiid(eir.getCldeiid());
			//组件所属关系
			cond.setEirrelation(CommonDefineUtils.MODULE_RELATION_MODULE_ID);
			cond.setDeleteflag("0");
			//查找其所属组件eiinfo中的#所属设备ID#
			List<IG313Info> list = this.ig313BL.searchMaxIG313Info(cond);
			if(list.isEmpty()) {
				//设备所属关系
				cond.setEirrelation(CommonDefineUtils.MODULE_RELATION_ENTIY_ID);
				list = this.ig313BL.searchMaxIG313Info(cond);
			}
			if(list.size() != 1) {
				throw new BLException("IGCO10000.E004","所选组件所属设备基本");
			}
			eir.setEirrelation(CommonDefineUtils.MODULE_RELATION_MODULE_ID);
			eir.setEirrelationcode(CommonDefineUtils.MODULE_RELATION_MODULE_CODE);
			eir.setEirinfo(list.get(0).getEirinfo());//所属设备ID
		}
		eir.setEirupdtime(datetime);
		eir.setEirstatus("C");
		eir.setEirdesc("由组件："+form.getEiname()+"建立所属关系");
		this.ig313BL.registIG313Info(eir);
		
		form.setEiidStr(entityItem.getEiid().toString());
		
		dto.setIgasm1702Form(form);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "组件基本信息") );

		log.debug("========组件信息登记处理终了========");
		return dto;
	}

	/**
	 * 组件信息删除处理
	 *
	 * @param dto IGASM17DTO
	 * @return IGASM17DTO
	 */
	public IGASM17DTO deleteEntityItemAction(IGASM17DTO dto) throws BLException {
		log.debug("========组件信息删除处理开始========");
		List<Integer> retList = new ArrayList<Integer>();//递归删除的与用户选择删除的有重复
		for( int i=0;i<dto.getDeleteEntityItem().length;i++ ){
			String eiid = dto.getDeleteEntityItem()[i];
			if(!retList.contains(Integer.parseInt(eiid))){
				cycleDelete (eiid,retList);
			}
		}
		for(Integer eiid : retList){
			//删除前删除对象组件确认
			IG013Info entityItem = this.ig013BL.searchIG013InfoByKey(eiid);
			
			if (entityItem == null){
				throw new BLException("IGCO10000.E004","删除对象基本");
			}
			//组件删除
			this.ig013BL.deleteIG013Info(entityItem);
		}
		dto.addMessage(new ActionMessage("IGCO10000.I006","组件信息"));

		log.debug("========组件信息删除处理终了========");
		return dto;
	}
	
	//递归删除组件所属的组件
	private List<Integer> cycleDelete (String eiid,List<Integer> retList) throws BLException{
		
		IG313SearchCondImpl parcond = new IG313SearchCondImpl();
		if(eiid!=null){
		parcond.setCldeiid(Integer.parseInt(eiid));}
		parcond.setDeleteflag("0");
		//所属关系
		parcond.setEirrelation(CommonDefineUtils.MODULE_RELATION_MODULE_ID);
		//查找指定组件下的所属组件，组件递归查找
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
	 * 组件配置信息编辑画面初期化处理
	 *
	 * @param dto IGASM17DTO
	 * @return IGASM17DTO
	 */
	public IGASM17DTO initIGASM1704Action(IGASM17DTO dto) throws BLException {

		log.debug("========组件配置信息编辑画面初期化处理开始========");
		
		IGASM1704Form form = dto.getIgasm1704Form();
		
		//组件信息检索
		IG688Info entityItemVWInfo = this.ig013BL.searchIG688InfoByKey(
				form.getEiid());
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","组件");
		}
		
		form.setEidesc(entityItemVWInfo.getEidesc());
//		form.setEistatus(entityItemVWInfo.getEistatus());
		form.setEsyscoding_q(entityItemVWInfo.getEsyscoding());
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
		//组件配置信息查询件数取得 
		int totalCount = this.ig800BL.getIG002InfoSearchCount(form);
		
		if (totalCount == 0) {
			log.debug("========组件配置信息查询数据不存在========");
			//组件配置信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I007",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========组件配置信息查询数据件数过多========");
			//组件配置信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//组件配置信息全件查询
		List<IG002Info> configItemVWInfoList = this.ig800BL.searchIG002Info(
				form, 0, 0);
		
		String[] civalue = new String[totalCount];
		String[] delfile = new String[totalCount];
		String[] entityItemCivalue = new String[totalCount];
		String[] isUpgrade=new String[totalCount];
		//存放旧版本值
		String[] civalue_bak = new String[totalCount];
		Map<String,List<IG002Info>> map = new LinkedHashMap<String,List<IG002Info>>();
		int i = 0;
		int j = 0;
		List<String> strlist = new ArrayList<String>();
		Map<String, String> cldVersionMap=new HashMap<String, String>();//子资产版本集合
		for(IG002Info e : configItemVWInfoList){
			if("4".equals(e.getCattach())){
				String value = e.getCivalue();
				if(StringUtils.isNotEmpty(value)){
					String cldeiid = value.substring(value.lastIndexOf("(")+1, value.length()-1);//子资产eiid
					
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
						cldversion = String.valueOf(ig313Info.get(0).getCldversion());//子资产版本
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
				//显示是资产名称，实际存值是资产名称(资产ID)
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


		
		log.debug("========组件配置信息编辑画面初期化处理终了========");
		return dto;
	}
	
	/**
	 * 组件配置信息编辑处理
	 *
	 * @param dto IGASM17DTO
	 * @return IGASM17DTO
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public IGASM17DTO editEntityItemAction(IGASM17DTO dto) throws BLException, FileNotFoundException, IOException {
		log.debug("========组件配置信息编辑处理开始========");
		//版本号生成
		IGASM1704Form form = dto.getIgasm1704Form();
		
		//组件基本信息更新
		IG013TB entityItem = (IG013TB) this.ig013BL.searchIG013InfoByKey(form.getEiid());
		// 取得版本是否升级标识
		String ident = form.getIdent();
		if(StringUtils.isEmpty(ident)){
			ident = IGASM17BLImpl.SAVE_VERSION;
		}
		// 版本号初始化
		int version = 1;
		boolean versonFlag = false;
		// 判断是否升级版本号
		// =====================>> 修改 start
		if (IGASM17BLImpl.SAVE_VERSION_UP.equals(ident)) { // 升级版本号
			version = form.getEiversion() + 1;
			
			//增加是否关系升级复选框，判断哪个资产关系升级
			String[] cldeiids=new String[form.getCiid().length];
			int index=0;
			if(form.getIsUpgrade()!=null&&form.getIsUpgrade().length>0){
                for(int i=0;i<form.getIsUpgrade().length;i++){
                    if(form.getIsUpgrade()[i]!=null&&"1".equals(form.getIsUpgrade()[i])){
                        if(form.getEntityItemCivalue()[i].lastIndexOf("(") != -1 && form.getEntityItemCivalue()[i].lastIndexOf(")") != -1){
                            String cldeiid=form.getEntityItemCivalue()[i].substring(form.getEntityItemCivalue()[i].lastIndexOf("(")+1,
                                    form.getEntityItemCivalue()[i].lastIndexOf(")"));
                            //子资产基本信息
                            IG013TB cldEntityItem = (IG013TB) this.ig013BL.searchIG013InfoByKey(Integer.parseInt(cldeiid));
                            if(cldEntityItem!=null){
                            	 cldeiids[index]=cldeiid+"_"+cldEntityItem.getEiversion()+"_"+cldEntityItem.getEismallversion()+"_"+form.getCiid()[i];
                            }
                        }
                        index++;
                    }
                }
            }
			
			//资产关系信息版本升级处理
			this.ig313BL.upgradeIG313InfoOne(entityItem.getEiid(), entityItem.getEiversion(), entityItem.getEismallversion(),
					version, 0,cldeiids);
			
			if (version - 1 != entityItem.getEiversion()) {
				throw new BLException("IGCO00000.E004");
			}
		} else if (IGASM17BLImpl.SAVE_VERSION.equals(ident)) { // 不升级版本号

			version = form.getEiversion();
			if (version != entityItem.getEiversion()) {
				throw new BLException("IGCO00000.E004");
			}

			if (form.getEiversion() == 0) { // 如果为第一版时设定版本号为 “1”
				versonFlag = true;
				version = 1;
			}
		}
		//  << =================  end
		
		//组件状态
//		entityItem.setEistatus(form.getEistatus());
		//组件版本
		entityItem.setEiversion(version);
		
		//组件说明
		entityItem.setEidesc(form.getEidesc());

		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		
		//更新时间
		entityItem.setEiupdtime(datetime);
		
		this.ig013BL.updateIG013Info(entityItem);
		//=======更新关系开始========
		if(version ==1&&versonFlag){
			IG313SearchCondImpl eircond1 = new IG313SearchCondImpl();
			//删除标识
			eircond1.setDeleteflag("0");
			//与该资产相关的关系码
			eircond1.setEirrelationcode(IGASM17BLImpl.EIRRELATIONCODE);
			eircond1.setEiid(entityItem.getEiid());
			//该资产现有的关系信息
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
					//正向关系时
					if(entityItem.getEiid().equals(ig313Info.getPareiid())){
						ig313tb.setParversion(entityItem.getEiversion());
						this.ig313BL.registIG313Info(ig313tb);
					}
					//方向关系时
					if(entityItem.getEiid().equals(ig313Info.getCldeiid())){
						ig313tb.setCldversion(entityItem.getEiversion());
						this.ig313BL.registIG313Info(ig313tb);
					}
				}
			}
		}
		//=======更新关系结束========
		
		//调用更新BL
		
		//组件配置信息更新
		if (form.getCiid() != null && form.getCiid().length > 0 ) {
			
			for( int i=0 ; i < form.getCiid().length; i++ ){
				IG800TB configItem = new IG800TB();
				//组件ID
				configItem.setEiid(form.getEiid());
				//资产配置ID
				configItem.setCid(Integer.parseInt(form.getCid()[i]));
				//类型ID
				configItem.setEid(Integer.parseInt(form.getEid()[i]));
				//类型层次码
				configItem.setEsyscoding(form.getEsyscoding()[i]);
				//内容
				configItem.setCivalue(form.getCivalue()[i]);
				//大版本号
				configItem.setCiversion(version);
				//小版本号
				configItem.setCismallversion(0);
				//更新时间
				configItem.setCiupdtime(datetime);
				
				//显示是资产名称，实际存值是资产名称(资产ID)
				if("4".equals(form.getCiattach()[i]) && StringUtils.isNotEmpty(form.getEntityItemCivalue()[i])){
					configItem.setCivalue(form.getEntityItemCivalue()[i]);
				}
				
				//附件删除
				if("1".equals(form.getCiattach()[i]) && "1".equals(form.getDelfile()[i])){
					configItem.setCivalue("");
				}
				
				if (StringUtils.isEmpty(form.getCiid()[i])) {
					//更新标识
					if(StringUtils.isEmpty(configItem.getCivalue())) {
						configItem.setCicurver("0");
					} else {
						configItem.setCicurver("1");
					}
					configItem = (IG800TB) this.ig800BL.registIG800Info(configItem);
					
					//属性类别为资产时，增加关联关系
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
						e.setEirdesc("由配置项："+cname+"建立");
						//增加key
						e.setEirinfo(entityItem.getEiid()+"_"+configItem.getCiid()+"_"+ei.getEiid());
						//设置状态为C，关系管理中不可删除
						e.setEirstatus("C");
						this.ig313BL.registIG313Info(e);
					}
					log.debug("资产配置项：[资产配置ID:" + form.getCid()[i] + "]插入处理成功。");
					
				} else {
					//更新标识默认为0
					configItem.setCicurver("0");
					if ("4".equals(form.getCiattach()[i])){
						if(!form.getCivalue_bak()[i].equals(configItem.getCivalue())){
							//更新资产属性标识
							configItem.setCicurver("1");
						}
					} else if(!form.getCivalue_bak()[i].equals(configItem.getCivalue())){
						//更新属性标识
						configItem.setCicurver("1");
					}
					
					// 判断是否升级版本号
					if (IGASM17BLImpl.SAVE_VERSION_UP.equals(ident)) { // 升级版本号

						configItem = (IG800TB) this.ig800BL.registIG800Info(configItem);

					} else if (IGASM17BLImpl.SAVE_VERSION.equals(ident)) { // 不升级版本号
					
						Integer ciid = Integer.valueOf(form.getCiid()[i]); 
						
						// 查询当前配置项
						IG800Info cfi = this.ig800BL.searchIG800InfoByKey(ciid);
						
						// 判断当前配置项是否是新增的
						if(configItem.getCid().equals(cfi.getCid())){ // 不是新增配置项进行更新
							
							configItem.setCiid(ciid);
							configItem = (IG800TB) this.ig800BL
								.updateIG800Info(configItem);
							
						}else{  // 新增配置项进行新增
							
							configItem = (IG800TB) this.ig800BL
							.registIG800Info(configItem);
							
						}
					}
					
					//属性类别为资产时，增加关联关系
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
						//校验关系是否存在
						IG313SearchCondImpl condPar = new IG313SearchCondImpl();
						condPar.setPareiid(entityItem.getEiid());//资产ID
						condPar.setParversion(entityItem.getEiversion());//资产大版本
						condPar.setParsmallversion(entityItem.getEismallversion());//资产小版本
						condPar.setDeleteflag("0");
						condPar.setEirstatus("C");
						condPar.setEirinfo(entityItem.getEiid()+"_"+form.getCiid()[i]+"_"+ei.getEiid());
						
						List<IG313Info> eirlist = this.ig313BL.searchIG313Info(condPar);
						
						if(eirlist.isEmpty()){
							//删除原来已有的关系
							IG313SearchCondImpl eircond = new IG313SearchCondImpl();
							eircond.setEirinfo(entityItem.getEiid()+"_"+form.getCiid()[i]+"_");
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
							e.setEirdesc("由配置项："+cname+"建立");
							//增加key
							e.setEirinfo(entityItem.getEiid()+"_"+configItem.getCiid()+"_"+ei.getEiid());
							//设置状态为C，关系管理中不可删除
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
						//删除原来已有的关系
						IG313SearchCondImpl eircond = new IG313SearchCondImpl();
						eircond.setEirinfo(entityItem.getEiid()+"_"+form.getCiid()[i]+"_");
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
						//组件ID
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
						
						//更新属性标识
						configItem.setCicurver("1");
						
						this.ig800BL.updateIG800Info(configItem);					
						
					}
				}
			}
			
		}
	
		dto.addMessage(new ActionMessage("IGCO10000.I005","组件配置信息"));
		
		log.debug("========组件配置信息编辑处理终了========");
		
		return dto;
	}

	/**
	 * 组件配置信息历史记录画面初期化处理
	 *
	 * @param dto IGASM17DTO
	 * @return IGASM17DTO
	 */
	public IGASM17DTO initIGASM1705Action(IGASM17DTO dto) throws BLException {
		log.debug("========组件配置信息历史记录画面初期化处理开始========");
		
		//组件信息检索
		IG688Info entityItemVWInfo = this.ig013BL.searchIG688InfoByKey(
				dto.getIgasm1705Form().getEiid());
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","组件");
		}
		
		if (entityItemVWInfo.getEiversion() == 0 && entityItemVWInfo.getEismallversion() == 0) {
			dto.addMessage(new ActionMessage("IGASM0205.W001"));
		}
		
		dto.setEntityItemVWInfo(entityItemVWInfo);
		
		if ((dto.getIgasm1705Form().getCiversion())!=null) {
			dto.getIgasm1705Form().setCiversion(String.valueOf(entityItemVWInfo.getEiversion()));
		}
		//获取历史版本更新时间
		dto.setConfigItemVersionTime(this.ig013BL.searchVersionUpdateTime(dto.getIgasm1705Form().getEiid()));
		
		//判断登陆用户是否有查看该资产配置信息的权限
		Boolean flag = this.ig013BL.checkIG688InfoDomain(dto.getUser(), entityItemVWInfo);

		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}else{
			dto.setFlag(flag);
		}
		log.debug("========组件配置信息历史记录画面初期化处理终了========");
		return dto;
	}

	/**
	 * 组件关系管理画面初期化处理
	 *
	 * @param dto IGASM17DTO
	 * @return IGASM17DTO
	 */
	public IGASM17DTO initIGASM1706Action(IGASM17DTO dto) throws BLException {
		log.debug("========组件关系管理画面初期化处理开始========");
		
		//组件信息检索
		IG688Info entityItemVWInfo = this.ig013BL.searchIG688InfoByKey(
				Integer.parseInt(dto.getIgasm1706Form().getEiid()));
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","组件");
		}
		
		dto.setEntityItemVWInfo(entityItemVWInfo);
		
		//正向关联关系检索
		IG313SearchCondImpl parcond = new IG313SearchCondImpl();
		if((dto.getIgasm1706Form().getEiid())!=null){
		parcond.setPareiid(Integer.parseInt(dto.getIgasm1706Form().getEiid()));}
		parcond.setParversion(entityItemVWInfo.getEiversion());
		parcond.setParsmallversion(entityItemVWInfo.getEismallversion());
		parcond.setDeleteflag("0");
		
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
		//组件关系信息查询件数取得 
		int totalCount = this.ig313BL.getIG313InfoSearchCount(parcond);
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========组件关系信息查询数据件数过多========");
			//组件关系信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		if ( totalCount>0 ) {
			//组件关系信息全件检索
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
		
		//逆向关联关系检索
		//关联关系检索
//		IG313SearchCondImpl cldcond = new IG313SearchCondImpl();
//		
//		cldcond.setCldeiid(dto.getIgasm1706Form().getEiid());
//		cldcond.setCldversion(entityItemVWInfo.getEiversion().toString());
//		cldcond.setCldsmallversion(entityItemVWInfo.getEismallversion().toString());
//		cldcond.setDeleteflag("0");
//		
//		//组件关系信息查询件数取得 
//		totalCount = this.ig313BL.getIG313InfoSearchCount(cldcond);
//		
//		if ( totalCount > dto.getMaxSearchCount() ) {
//			log.debug("========组件关系信息查询数据件数过多========");
//			//组件关系信息查询数据件数过多
//			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
//			return dto;
//		}
//
//		//组件关系信息全件检索
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

		
		log.debug("========组件关系管理画面初期化处理终了========");
		return dto;
	}
	
	/**
	 * 组件关系删除处理
	 *
	 * @param dto IGASM17DTO
	 * @return IGASM17DTO
	 */
	public IGASM17DTO deleteEntityItemRelationAction(IGASM17DTO dto) throws BLException {
		log.debug("========组件关系删除处理开始========");
		
		for( int i=0;i<dto.getDeleteEntityItemRelation().length;i++ ){
			
			IG313Info entityItemRelation = 
				this.ig313BL.searchIG313InfoByKey(Integer.parseInt(dto.getDeleteEntityItemRelation()[i]));
			
			if (entityItemRelation == null){
				throw new BLException("IGCO10000.E004","删除对象组件关系");
			}

			this.ig313BL.deleteIG313Info(entityItemRelation);
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I006","组件关系信息"));

		log.debug("========组件关系删除处理终了========");
		return dto;
	}

	/**
	 * 组件关系登记处理
	 *
	 * @param dto IGASM17DTO
	 * @return IGASM17DTO
	 */
	public IGASM17DTO insertEntityItemRelationAction(IGASM17DTO dto) throws BLException {
		log.debug("========组件关系登记处理开始========");
		
		IGASM1707Form form = dto.getIgasm1707Form();
		
		//组件ID（子）取得
		IG688SearchCondImpl cond = new IG688SearchCondImpl();
		
		cond.setElabel(form.getElabel());
		cond.setEilabel(form.getEilabel());
		
		List<IG688Info> entityItemVWList = this.ig013BL.searchIG688Info(cond, 0, 0);
		
		if ( entityItemVWList==null || entityItemVWList.size() == 0 ) {
			throw new BLException("IGCO10000.E004","(资产编号=" + form.getElabel() + ",组件编号=" 
					+ form.getEilabel() + ")组件");
		}
		
		form.setCldeiid(entityItemVWList.get(0).getEiid());
		form.setCldeid(Integer.parseInt(entityItemVWList.get(0).getEid()));
		form.setCldsmallversion(entityItemVWList.get(0).getEismallversion());//
		form.setCldversion(entityItemVWList.get(0).getEiversion());//

		
		//组件ID（父）和（子）检测
		if (form.getPareiid().intValue() == form.getCldeiid().intValue()) {
			//组件ID（父）= （子）
			throw new BLException(BLErrorType.ENTITY_ITEM_RELATION_ERROR,
					"IGCO10000.E012","组件");
		}
		
		//更新时间设定
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

		form.setEirupdtime(datetime);
		
		//资产关系登记
		IG313Info ret = 
			this.ig313BL.registIG313Info(form);
		
		dto.setEntityItemRelation(ret);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "组件关系信息") );
		
		log.debug("========组件关系登记处理终了========");
		return dto;
	}
	
	/**
	 * 组件关系编辑画面初期化处理
	 *
	 * @param dto IGASM17DTO
	 * @return IGASM17DTO
	 */
	public IGASM17DTO initIGASM1707Action(IGASM17DTO dto) throws BLException {
		log.debug("========组件关系编辑画面初期化处理开始========");
		
		IGASM1707Form form = dto.getIgasm1707Form();
		IG313TB ret = 		
			(IG313TB) this.ig313BL.searchIG313InfoByKey(
				form.getEirid());
		
		if ( ret == null ){
			throw new BLException("IGCO10000.E004","编辑对象组件关系");
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
		form.setTempeirrelation(ret.getEirrelation()+"#"+ret.getEirrelationcode());
		form.setMode("1");
		
		log.debug("========组件关系编辑画面初期化处理终了========");
		return dto;
	}

	/**
	 * 组件关系变更处理处理
	 *
	 * @param dto IGASM17DTO
	 * @return IGASM17DTO
	 */
	public IGASM17DTO updateEntityItemRelationAction(IGASM17DTO dto) throws BLException {
		log.debug("========组件关系变更处理处理开始========");
		IGASM1707Form form = dto.getIgasm1707Form();

		//更新时间设定
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

		form.setEirupdtime(datetime);
		
		this.ig313BL.updateIG313Info(form);

		dto.addMessage(new ActionMessage( "IGCO10000.I005", "组件关系信息") );

		log.debug("========组件关系变更处理处理终了========");
		return dto;
	}
	
	/**
	 *	获取组件关联关系处理
	 *
	 * @param dto IGASM17DTO
	 * @return IGASM17DTO
	 */
	public IGASM17DTO searchRelationListAction(IGASM17DTO dto) throws BLException {
		log.debug("========获取组件关联关系处理开始========");
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
		log.debug("========获取组件关联关系处理终了========");
		return dto;
	}
	
	/**
	 *组件信息修改初期显示处理
	 *
	 * @param dto IGASM17DTO
	 * @return IGASM17DTO
	 */
	public IGASM17DTO initEntityItem(IGASM17DTO dto) throws BLException {

		log.debug("========组件信息编辑画面初期显示处理开始========");
		
		IGASM1712Form form = dto.getIgasm1712Form();
		
		//显示用资产信息取得
		IG688Info entityItem = this.ig013BL.searchIG688InfoByKey(form.getEiid());
		
		if ( entityItem == null ){
			throw new BLException("IGCO10000.E004","变更组件基本");
		}
		
		//画面显示设定
		
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
		
		//判断登陆用户是否有查看该资产配置信息的权限
		boolean permission = this.ig013BL.checkIG688InfoDomain(dto.getUser(), entityItem);
		boolean isRoleManager = this.userRoleBL.checkRoleManagerByType(dto.getUser().getUserid(), EntityCategory.ROLE_TYPE_DEVICE);
		form.setRoleManager(isRoleManager);
		form.setPermission(permission);
		
		dto.setIgasm1712Form(form);
		
		//dto.addMessage(new ActionMessage("IGCO10000.I001","组件基本信息"));
		if(!permission) {
			dto.addMessage(new ActionMessage("IGCO10000.E023","修改"));
		}
		log.debug("========组件信息编辑画面初期显示处理终了========");
		return dto;
	}
	/**
	 *组件信息修改处理
	 *
	 * @param dto IGASM17DTO
	 * @return IGASM17DTO
	 */
	public IGASM17DTO updateEntityItem(IGASM17DTO dto) throws BLException {
		
		log.debug("========组件信息编辑画面初期显示处理开始========");
		
		IGASM1712Form form = dto.getIgasm1712Form();
		if(!form.getEilabel().equals(form.getEilabelbak())){
			this.ig013BL.checkNotExistIG013Info(form.getEilabel());
		}
	
		IG013Info entityItem = this.ig013BL.searchIG013InfoByKey(form.getEiid());
		
		//找configitem中完全匹配的civalue
		//与该资产存在关系的名称同步修改
		//正常全匹配
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
			
		
		
		//EntityItemRelation中取得有关系的资产列表
		IG313SearchCondImpl ercond = new IG313SearchCondImpl();
		ercond.setCldeiid(entityItem.getEiid());
//		ercond.setCldeid(String.valueOf(entityItem.getEid()));
		List<IG313Info> erlist = this.ig313BL.searchIG313Info(ercond);
		
		if(!erlist.isEmpty()){
			
			//服务记录
			//Configuration中取得资产相关资产的cid
			IG225SearchCondImpl ccond = new IG225SearchCondImpl();
			//资产ID的cid
			ccond.setClabel(EntityItemKeyWords.ENTITY_DEFAULT_DEVICE_EIID);
			List<IG225Info> clist1 = this.ig225BL.searchIG225Info(ccond);
			IG225TB cTB1 = (IG225TB)SerializationUtils.clone(clist1.get(0));
			//资产名称的cid
			ccond.setClabel(EntityItemKeyWords.ENTITY_DEFAULT_DEVICE_ENAME);
			List<IG225Info> clist2 = this.ig225BL.searchIG225Info(ccond);
			IG225TB cTB2 = (IG225TB)SerializationUtils.clone(clist2.get(0));
			
			cicond.setCivalue(null);
			for(int j = 0; j < erlist.size(); j++){
				//服务记录
				//资产ID
				IG313TB erTB = (IG313TB)SerializationUtils.clone(erlist.get(j));
				cicond.setEiid(erTB.getPareiid());
				cicond.setCid(cTB1.getCid());
				List<IG800Info> cilist1 = this.ig800BL.searchIG800Info(cicond);
				//如果关系了其他资产civalue中有资产ID的值,则查下一条中的资产名称
				if(!cilist1.isEmpty()){
					IG800TB ciTB1 = (IG800TB)SerializationUtils.clone(cilist1.get(0));
					cicond.setCid(cTB2.getCid());
					List<IG800Info> cilist2 = this.ig800BL.searchIG800Info(cicond);
					IG800TB ciTB2 = (IG800TB)SerializationUtils.clone(cilist2.get(0));
					//将civalue中值按<br />拆开
					String[] id = ciTB1.getCivalue().split("<br />");
					String[] name = ciTB2.getCivalue().split("<br />");
					StringBuffer bf = new StringBuffer();
					for(int n = 0; n < id.length; n++){
						if(id[n].equals(String.valueOf(entityItem.getEiid()))){
							name[n] = form.getEiname();
						}
						//换成修改后的资产名称，再拼上
						bf.append(name[n] + "<br />");
					}
					ciTB2.setCivalue(bf.toString());
					this.ig800BL.updateIG800Info(ciTB2);
				}
			}
		}
	
		this.ig013BL.updateIG013Info(form);
		dto.addMessage(new ActionMessage("IGCO10000.I005","组件基本信息"));
		log.debug("========组件信息编辑画面初期显示处理终了========");
		return dto;
	}
	
	/**
	 * 获取组件编号最大值
	 *
	 * @param dto IGASM17DTO
	 * @return IGASM17DTO
	 */
	public IGASM17DTO searchEntityItemLableAction(IGASM17DTO dto) throws BLException {
		
		log.debug("========获取组件编号最大值处理开始========");
		
		IGASM1702Form form = dto.getIgasm1702Form();
		
		IG013SearchCondImpl cond = new IG013SearchCondImpl();
		
		cond.setEilabel(CommonDefineUtils.ENTIY_CATEGORY_MODULE_KEY + IGStringUtils.getCurrentYear().substring(2));
		
		String eilabel = this.ig013BL.searchNextIG013InfoLable(cond);
		
		form.setEilabel(eilabel);
		
		log.debug("========获取组件编号最大值处理终了========");
		return dto;
	}
	
	/**
	 * 判断登陆用户是否是组件资产管理角色负责人
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
				throw new BLException("IGCO10000.E004","顶级机构");
			} else {
				dto.setOrgname(org.get(0).getOrgname());
				dto.setOrgsyscoding(org.get(0).getOrgsyscoding());
			}
			IG117SearchCondImpl entityCond = new IG117SearchCondImpl();
			entityCond.setEsyscoding(CommonDefineUtils.ENTIY_CATEGORY_MODULE_SYSCODING);
			List<IG117Info> entity = this.ig117BL.searchIG117Info(entityCond, 0, 0);
			
			if(entity.size() != 1) {
				throw new BLException("IGCO10000.E004","组件模型");
			} else {
				dto.setEname(entity.get(0).getEname());
				dto.setEsyscoding(entity.get(0).getEsyscoding());
			}
		}
		
		dto.setFlag(isRoleManager);
		
		return dto;
	}
}
