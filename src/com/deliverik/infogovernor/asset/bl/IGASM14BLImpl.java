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
import com.deliverik.framework.asset.model.entity.IG225TB;
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
import com.deliverik.infogovernor.asset.dto.IGASM14DTO;
import com.deliverik.infogovernor.asset.form.IGASM1402Form;
import com.deliverik.infogovernor.asset.form.IGASM1404Form;
import com.deliverik.infogovernor.asset.form.IGASM1407Form;
import com.deliverik.infogovernor.asset.form.IGASM1412Form;

/**
 * 服务记录管理业务逻辑实现
 *
 */
public class IGASM14BLImpl extends BaseBLImpl implements IGASM14BL {

	static Log log = LogFactory.getLog(IGASM14BLImpl.class);
	
	/** 资产信息BL */
//	protected IG117BL soc0117BL;
	protected SOC0117BL soc0117BL;

	/** 配置项信息BL */
//	protected IG013BL soc0118BL;
	protected SOC0118BL soc0118BL;
	
	/** 资产配置项BL */
//	protected IG800BL soc0107BL;
	protected SOC0107BL soc0107BL;
	
	/** 配置项关系BL */
//	protected IG313BL soc0119BL;
	protected SOC0119BL soc0119BL;
	
	/** 文件上传BL */
	protected FileUploadBL fileUploadBL;
	
	/** 资产取值范围下拉数据BL */
//	protected IG545BL ig545BL;
	protected SOC0151BL soc0151BL;
	
	/** 资产关联关系下拉数据BL */
	protected CodeDetailBL codeDetailBL;
	
	/** 机构BL */
	protected OrganizationBL organizationBL;
	
	/** 配置项BL */
//	protected IG225BL soc0109BL;
	protected SOC0109BL soc0109BL;
	
	/** 用户角色BL */
	protected UserRoleBL userRoleBL;
	
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
	 * 通过设备查询服务记录
	 * 
	 * @param dto IGASM14DTO
	 * @return IGASM14DTO
	 * @throws BLException 
	 */
	public IGASM14DTO searchServiceAction(IGASM14DTO dto) throws BLException{
        log.debug("========通过设备查询服务记录处理开始========");
		
		//服务记录信息查询件数取得 
		int totalCount = this.soc0118BL.searchDeviceService(dto.getEntityItemVWSearchCond(), 0, 0).size();
		
		if (totalCount == 0) {
			log.debug("========服务记录信息查询数据不存在========");
			//服务记录信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========服务记录信息查询数据件数过多========");
			//服务记录信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//分页用信息取得
		PagingDTO pDto = dto.getPagingDto();

		//当前页服务记录信息取得
		List<SOC0118Info> entityItemVWInfoList = this.soc0118BL.searchDeviceService(dto.getEntityItemVWSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setEntityItemList(entityItemVWInfoList);

		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========通过设备查询服务记录处理终了========");
		return dto;
	}
	
	/**
	 * 服务记录信息查询处理
	 *
	 * @param dto IGASM14DTO
	 * @return IGASM14DTO
	 */
	public IGASM14DTO searchEntityItemAction(IGASM14DTO dto) throws BLException {

		log.debug("========服务记录信息查询处理开始========");
		
		//服务记录信息查询件数取得 
		int totalCount = this.soc0118BL.getEntityItemVWSearchCount(dto.getEntityItemVWSearchCond());
		
		if (totalCount == 0) {
			log.debug("========服务记录信息查询数据不存在========");
			//服务记录信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========服务记录信息查询数据件数过多========");
			//服务记录信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//分页用信息取得
		PagingDTO pDto = dto.getPagingDto();

		//当前页服务记录信息取得
		List<SOC0124Info> entityItemVWInfoList = this.soc0118BL.searchEntityItemVW(dto.getEntityItemVWSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setEntityItemVWInfoList(entityItemVWInfoList);

		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========服务记录信息查询处理终了========");
		return dto;
	}
	
	/**
	 * 服务记录信息登记处理
	 *
	 * @param dto IGASM14DTO
	 * @return IGASM14DTO
	 */
	public IGASM14DTO insertEntityItemAction(IGASM14DTO dto) throws BLException {
		log.debug("========服务记录信息登记处理开始========");
		//输入Form取得
		IGASM1402Form form = dto.getIgasm1402Form();
		
		//类型ID取得
//		EntitySearchCondImpl cond = new EntitySearchCondImpl();
//		cond.setElabel(form.getElabel());
		//登记处理前的资产信息确认
//		List<Entity> entityList = this.soc0117BL.searchEntity(cond, 0, 0);
//		if ( entityList == null || entityList.size() ==0 ) {
//			throw new BLException(BLErrorType.ENTITY_ITEM_NOT_EXISTS_ERROR,
//					"IGCO10000.E004","(编号=" + form.getEilabel() + ")服务记录基本");
//		}
		
//		Entity entity = entityList.get(0);
//		EntityItem entityItem = entityitemList.get(0);
		
		//***************************************************************************
		//类型分类检测
//		if (!entity.getEcategory().equals(CommonDefineUtils.ENTIY_CATEGORY_DEVICE)) {
//			//服务记录以外的情况
//			throw new BLException(BLErrorType.ENTITY_CATEGORY_ERROR,
//					"IGCO10000.E011","服务记录");
//		}
		//***************************************************************************
		
//		form.setEid(entity.getEid());
		form.setEidStr(form.getEid().toString());
		
		//更新时间设定
		
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		
		form.setEiupdtime(datetime);
		
		//大版本设定（固定设为0）
		form.setEiversion(0);
		
		//小版本设定（固定设为0）
		form.setEismallversion(0);
		
		//服务记录信息登录
		SOC0118Info entityItem = this.soc0118BL.registEntityItem(dto.getIgasm1402Form());
		
		form.setEiidStr(entityItem.getEiid().toString());
		
		dto.setIgasm1402Form(form);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "服务记录基本信息") );

		log.debug("========服务记录信息登记处理终了========");
		return dto;
	}

	/**
	 * 服务记录信息删除处理
	 *
	 * @param dto IGASM14DTO
	 * @return IGASM14DTO
	 */
	public IGASM14DTO deleteEntityItemAction(IGASM14DTO dto) throws BLException {
		log.debug("========服务记录信息删除处理开始========");
		
		for( int i=0;i<dto.getDeleteEntityItem().length;i++ ){
			String eiid = dto.getDeleteEntityItem()[i];
			
			//删除前删除对象服务记录确认
			SOC0118Info entityItem = this.soc0118BL.searchEntityItemByKey(Integer.parseInt(eiid));
			
			if (entityItem == null){
				throw new BLException("IGCO10000.E004","删除对象服务记录基本");
			}

			//服务记录删除
			this.soc0118BL.deleteEntityItem(entityItem);
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I006","服务记录信息"));

		log.debug("========服务记录信息删除处理终了========");
		return dto;
	}

	/**
	 * 服务记录配置信息编辑画面初期化处理
	 *
	 * @param dto IGASM14DTO
	 * @return IGASM14DTO
	 */
	public IGASM14DTO initIGASM1404Action(IGASM14DTO dto) throws BLException {

		log.debug("========服务记录配置信息编辑画面初期化处理开始========");
		
		IGASM1404Form form = dto.getIgasm1404Form();
		
		//服务记录信息检索
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(
				Integer.parseInt(form.getEiid()));
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","服务记录");
		}
		
		form.setEidesc(entityItemVWInfo.getEidesc());
//		form.setEistatus(entityItemVWInfo.getEistatus());
		form.setEsyscoding_q(entityItemVWInfo.getEsyscoding());
		dto.setEntityItemVWInfo(entityItemVWInfo);
		//判断登陆用户是否有查看该资产配置信息的权限
		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(), entityItemVWInfo);

		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}else{
			dto.setFlag(flag);
		}
		//服务记录配置信息查询件数取得 
		int totalCount = this.soc0107BL.getConfigItemVWSearchCount(form);
		
		if (totalCount == 0) {
			log.debug("========服务记录配置信息查询数据不存在========");
			//服务记录配置信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I007",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========服务记录配置信息查询数据件数过多========");
			//服务记录配置信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//配置项配置信息全件查询
		List<SOC0129Info> configItemVWInfoList = this.soc0107BL.searchConfigItemVW(
				form, 0, 0);
		
		String[] civalue = new String[totalCount];
		String[] delfile = new String[totalCount];
		String[] entityItemCivalue = new String[totalCount];
		String[] isUpgrade=new String[totalCount];
		Map<String,List<SOC0129Info>> map = new LinkedHashMap<String,List<SOC0129Info>>();
		int i = 0;
		int j = 0;
		List<String> strlist = new ArrayList<String>();
		Map<String, String> cldVersionMap=new HashMap<String, String>();//子资产版本集合
		for(SOC0129Info e : configItemVWInfoList){
			if("4".equals(e.getCattach())){
				String value = e.getCivalue();
				if(StringUtils.isNotEmpty(value)){
					String cldeiid = value.substring(value.lastIndexOf("(")+1, value.length()-1);//子资产eiid
					
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
						cldversion = String.valueOf(ig313Info.get(0).getCldversion());//子资产版本
					}
					cldVersionMap.put(cldeiid, cldversion);
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
			if ("5".equals(e.getCattach())) {
				List<LabelValueBean> list =soc0151BL.searchLabelValueBeanList(e.getCoption());
				if (list.size() > 0) {
					list.remove(0);
				}
				form.setSelectedListMap(j++, list);
			}
		}
		form.setCldVersionMap(cldVersionMap);
		String civalueTemp = null;
		for(String str : strlist){
			for(SOC0129Info e : map.get(str)){
				//显示是资产名称，实际存值是资产名称(资产ID)
				if("4".equals(e.getCattach()) && StringUtils.isNotEmpty(e.getCivalue())){
					civalue[i] = e.getCivalue().substring(0, e.getCivalue().lastIndexOf("("));
					isUpgrade[i]= e.getCivalue().substring(e.getCivalue().lastIndexOf("(")+1, e.getCivalue().lastIndexOf(")"));
					entityItemCivalue[i] = e.getCivalue();
				} else {
					civalue[i] = e.getCivalue();
				}
				if(EntityItemKeyWords.ENTITY_DEFAULT_DEVICE_ENAME.equals(e.getClabel())){
					civalueTemp = civalue[i];
				}
				i++;
			}
		}
		
		if(civalueTemp!=null){
			form.setCivalues(civalueTemp.split("<br />"));
		}else{
			form.setCivalues(null);
		}
		form.setCivalue(civalue);
		form.setEntityItemCivalue(entityItemCivalue);
		form.setDelfile(delfile);
		form.setIsUpgrade(isUpgrade);
		dto.setConfigItemVWInfoMap(map);
//		dto.addMessage(new ActionMessage("IGCO10000.I007",totalCount));


		
		log.debug("========服务记录配置信息编辑画面初期化处理终了========");
		return dto;
	}
	
	/**
	 * 服务记录配置信息编辑处理
	 *
	 * @param dto IGASM14DTO
	 * @return IGASM14DTO
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public IGASM14DTO editEntityItemAction(IGASM14DTO dto) throws BLException, FileNotFoundException, IOException {
		log.debug("========服务记录配置信息编辑处理开始========");
		//版本号生成
		IGASM1404Form form = dto.getIgasm1404Form();
		
		int version = form.getEiversion() + 1;
		
		//服务记录基本信息更新
		SOC0118TB entityItem = (SOC0118TB) this.soc0118BL.searchEntityItemByKey(Integer.parseInt(form.getEiid()));

		if(version - 1 != entityItem.getEiversion()) {
			throw new BLException("IGCO00000.E004");
		}
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
				        SOC0118TB cldEntityItem = (SOC0118TB) this.soc0118BL.searchEntityItemByKey(Integer.parseInt(cldeiid));
				        if(cldEntityItem!=null){
				        	 cldeiids[index]=cldeiid+"_"+cldEntityItem.getEiversion()+"_"+cldEntityItem.getEismallversion()+"_"+form.getCiid()[i];
				        }
				    }
					index++;
				}
			}
		}
		
		//资产关系信息版本升级处理
		this.soc0119BL.upgradeEntityItemRelationOne(entityItem.getEiid(), entityItem.getEiversion(), entityItem.getEismallversion(),
				version, 0,cldeiids);
		//服务记录状态
//		entityItem.setEistatus(form.getEistatus());
		//服务记录版本
		entityItem.setEiversion(version);
		
		//服务记录说明
		entityItem.setEidesc(form.getEidesc());

		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		
		//更新时间
		entityItem.setEiupdtime(datetime);
		
		entityItem = (SOC0118TB)this.soc0118BL.updateEntityItem(entityItem);
		
		//资产
		SOC0119TB eir1 = new SOC0119TB();
		eir1.setPareid(entityItem.getEid());
		eir1.setPareiid(entityItem.getEiid());
		eir1.setParversion(entityItem.getEiversion());
		eir1.setParsmallversion(entityItem.getEismallversion());
		//服务商
		SOC0119TB eir2 = new SOC0119TB();
		eir2.setPareid(entityItem.getEid());
		eir2.setPareiid(entityItem.getEiid());
		eir2.setParversion(entityItem.getEiversion());
		eir2.setParsmallversion(entityItem.getEismallversion());
		
		String pareid = "";
		String pareiid = "";
		String eirrelationcode = "";
		
		//服务记录配置信息更新
		if (form.getCiid() != null && form.getCiid().length > 0 ) {
			
			for( int i=0 ; i < form.getCiid().length; i++ ){
				SOC0107TB configItem = new SOC0107TB();
				//服务记录ID
				configItem.setEiid(Integer.parseInt(form.getEiid()));
				//资产配置ID
				configItem.setCid(form.getCid()[i]);
				//类型ID
				configItem.setEid(form.getEid()[i]);
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
				configItem = (SOC0107TB) this.soc0107BL.registSOC0107(configItem);
				if (StringUtils.isEmpty(form.getCiid()[i])) {
					//异常返回编辑页面时保留表单信息
					if(EntityItemKeyWords.ENTITY_DEFAULT_DEVICE_ENAME.equals(form.getClabel()[i])){
						form.setCivalues(form.getCivalue()[i].split("<br />"));
					}
					
					//属性类别为资产时，增加关联关系
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
						SOC0109Info config = this.soc0109BL.searchConfigurationByKey(form.getCid()[i]);
						String cname = config.getCname();
						e.setEirdesc("由配置项："+cname+"建立");
						//增加key
						e.setEirinfo(entityItem.getEiid()+"_"+configItem.getCiid()+"_"+ei.getEiid());
						//设置状态为C，关系管理中不可删除
						e.setEirstatus("C");
						this.soc0119BL.registEntityItemRelation(e);
					}
					log.debug("资产配置项：[资产配置ID:" + form.getCid()[i] + "]插入处理成功。");
					
					if(EntityItemKeyWords.ENTITY_DEFAULT_DEVICE_EID.equals(form.getClabel()[i])){
//						eir1.setPareid(Integer.parseInt(form.getCivalue()[i]));
						pareid = form.getCivalue()[i];
					}
					if(EntityItemKeyWords.ENTITY_DEFAULT_DEVICE_EIID.equals(form.getClabel()[i])){
//						eir1.setPareiid(Integer.parseInt(form.getCivalue()[i]));
						pareiid = form.getCivalue()[i];
					}
					if(EntityItemKeyWords.ENTITY_DEFAULT_SERVICE_EID.equals(form.getClabel()[i])){
						eir2.setCldeid(form.getCivalue()[i]);
					}
					if(EntityItemKeyWords.ENTITY_DEFAULT_SERVICE_EIID.equals(form.getClabel()[i])){
						eir2.setCldeiid(Integer.parseInt(form.getCivalue()[i]));
						SOC0118Info ei = this.soc0118BL.searchEntityItemByKey(eir2.getCldeiid());
						eir2.setCldversion(ei.getEiversion());
						eir2.setCldsmallversion(ei.getEismallversion());
					}
					
					eir1.setEirupdtime(datetime);
					eir2.setEirupdtime(datetime);
					
					eir1.setEirrelation(CommonDefineUtils.SERVICE_RECORD_EIRRELATION_CID);
					eir2.setEirrelation(CommonDefineUtils.SERVICE_RECORD_EIRRELATION_CID);
					if(EntityItemKeyWords.ENTITY_DEFAULT_DEVICE_ECATEGORY.equals(form.getClabel()[i])){
//						eir1.setEirrelationcode(form.getCivalue()[i]+"-"+CommonDefineUtils.ENTIY_CATEGORY_SERVICE_RECORD);
						eirrelationcode = form.getCivalue()[i];
					}
					if(EntityItemKeyWords.ENTITY_DEFAULT_SERVICE_ECATEGORY.equals(form.getClabel()[i])){
						eir2.setEirrelationcode(form.getCivalue()[i]+"-"+CommonDefineUtils.ENTIY_CATEGORY_SERVICE_RECORD);
					}		
					
				} else {
					//属性类别为资产时，增加关联关系
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
						//校验关系是否存在
						SOC0119SearchCondImpl condPar = new SOC0119SearchCondImpl();
						condPar.setPareiid(entityItem.getEiid());//资产ID
						condPar.setParversion(entityItem.getEiversion());//资产大版本
						condPar.setParsmallversion(entityItem.getEismallversion());//资产小版本
						condPar.setDeleteflag("0");
						condPar.setEirstatus("C");
						condPar.setEirinfo(entityItem.getEiid()+"_"+form.getCiid()[i]+"_"+ei.getEiid());
						List<SOC0119Info> eirlist = this.soc0119BL.searchEntityItemRelation(condPar);
						if(eirlist.isEmpty()){
							//删除原来已有的关系
							SOC0119SearchCondImpl eircond = new SOC0119SearchCondImpl();
							eircond.setEirinfo(entityItem.getEiid()+"_"+form.getCiid()[i]+"_");
							eircond.setEirstatus("C");
							eircond.setDeleteflag("0");
							List<SOC0119Info> eir = this.soc0119BL.searchMaxEntityItemRelation(eircond);
							for (SOC0119Info entityItemRelation : eir) {
								this.soc0119BL.deleteEntityItemRelation(entityItemRelation);
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
							SOC0109Info config = this.soc0109BL.searchConfigurationByKey(form.getCid()[i]);
							String cname = config.getCname();
							e.setEirdesc("由配置项："+cname+"建立");
							//增加key
							e.setEirinfo(entityItem.getEiid()+"_"+configItem.getCiid()+"_"+ei.getEiid());
							//设置状态为C，关系管理中不可删除
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
						//删除原来已有的关系
						SOC0119SearchCondImpl eircond = new SOC0119SearchCondImpl();
						eircond.setEirinfo(entityItem.getEiid()+"_"+form.getCiid()[i]+"_");
						eircond.setEirstatus("C");
						eircond.setDeleteflag("0");
						List<SOC0119Info> eir = this.soc0119BL.searchMaxEntityItemRelation(eircond);
						for (SOC0119Info entityItemRelation : eir) {
							this.soc0119BL.deleteEntityItemRelation(entityItemRelation);
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
						//服务记录ID
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
						
						this.soc0107BL.updateSOC0107(configItem);					
						
					}
				}
			}
			String[] pareids = pareid.split("<br />");
			String[] pareiids = pareiid.split("<br />");
			String[] eirrelationcodes = eirrelationcode.split("<br />");
			eir1.setEirstatus("C");
			eir2.setEirstatus("C");
			
			if((pareids.length ==pareiids.length)&&(pareids.length==eirrelationcodes.length)){
				for(int i=0;i<pareids.length;i++){
					if(!"".equals(pareids[i])){
						eir1.setCldeid(pareids[i]);
						eir1.setCldeiid(Integer.parseInt(pareiids[i]));
						SOC0118Info ei = this.soc0118BL.searchEntityItemByKey(eir1.getCldeiid());
						eir1.setCldversion(ei.getEiversion());
						eir1.setCldsmallversion(ei.getEismallversion());
						eir1.setEirrelationcode(eirrelationcodes[i]+"-"+CommonDefineUtils.ENTIY_CATEGORY_SERVICE_RECORD);
						this.soc0119BL.registEntityItemRelation(eir1);
					}
				}
			}else{
				throw new BLException("数据错误");
			}
//			this.soc0119BL.registEntityItemRelation(eir1);
			this.soc0119BL.registEntityItemRelation(eir2);
		}
	
		dto.addMessage(new ActionMessage("IGCO10000.I005","服务记录配置信息"));
		
		log.debug("========服务记录配置信息编辑处理终了========");
		
		return dto;
	}

	/**
	 * 服务记录配置信息历史记录画面初期化处理
	 *
	 * @param dto IGASM14DTO
	 * @return IGASM14DTO
	 */
	public IGASM14DTO initIGASM1405Action(IGASM14DTO dto) throws BLException {
		log.debug("========服务记录配置信息历史记录画面初期化处理开始========");
		
		//服务记录信息检索
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(
				dto.getIgasm1405Form().getEiid());
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","服务记录");
		}
		
		if (entityItemVWInfo.getEiversion() == 0 && entityItemVWInfo.getEismallversion() == 0) {
			dto.addMessage(new ActionMessage("IGASM0205.W001"));
		}
		
		dto.setEntityItemVWInfo(entityItemVWInfo);
		
		if ((dto.getIgasm1405Form().getCiversion())!=null) {
			dto.getIgasm1405Form().setCiversion(String.valueOf(entityItemVWInfo.getEiversion()));
		}
		//获取历史版本更新时间
		dto.setConfigItemVersionTime(this.soc0118BL.searchVersionUpdateTime(dto.getIgasm1405Form().getEiid()));
		
		//判断登陆用户是否有查看该资产配置信息的权限
		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(), entityItemVWInfo);

		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}else{
			dto.setFlag(flag);
		}
		
		log.debug("========服务记录配置信息历史记录画面初期化处理终了========");
		return dto;
	}

	/**
	 * 服务记录关系管理画面初期化处理
	 *
	 * @param dto IGASM14DTO
	 * @return IGASM14DTO
	 */
	public IGASM14DTO initIGASM1406Action(IGASM14DTO dto) throws BLException {
		log.debug("========服务记录关系管理画面初期化处理开始========");
		
		//服务记录信息检索
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(
				Integer.parseInt(dto.getIgasm1406Form().getEiid()));
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","服务记录");
		}
		
		dto.setEntityItemVWInfo(entityItemVWInfo);
		
		Map<String,List<SOC0119Info>> parmap = new LinkedHashMap<String,List<SOC0119Info>>();
		//正向关联关系检索
		SOC0119SearchCondImpl parcond = new SOC0119SearchCondImpl();
		
		parcond.setPareiid(Integer.parseInt(dto.getIgasm1406Form().getEiid()));
		parcond.setParversion(entityItemVWInfo.getEiversion());
		parcond.setParsmallversion(entityItemVWInfo.getEismallversion());
		parcond.setDeleteflag("0");
		//判断登陆用户是否有查看该资产配置信息的权限
		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(), entityItemVWInfo);

		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}else{
			dto.setFlag(flag);
		}
		//服务记录关系信息查询件数取得 
		int totalCount = this.soc0119BL.getEntityItemRelationSearchCount(parcond);
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========服务记录关系信息查询数据件数过多========");
			//服务记录关系信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		if ( totalCount>0 ) {
			//服务记录关系信息全件检索
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

		//逆向关联关系检索
		//关联关系检索
		SOC0119SearchCondImpl cldcond = new SOC0119SearchCondImpl();
		
		cldcond.setCldeiid(Integer.parseInt(dto.getIgasm1406Form().getEiid()));
		cldcond.setCldversion(entityItemVWInfo.getEiversion());
		cldcond.setCldsmallversion(entityItemVWInfo.getEismallversion());
		cldcond.setDeleteflag("0");
		
		//服务记录关系信息查询件数取得 
		totalCount = this.soc0119BL.getEntityItemRelationSearchCount(cldcond);
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========服务记录关系信息查询数据件数过多========");
			//服务记录关系信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//服务记录关系信息全件检索
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

		log.debug("========服务记录关系管理画面初期化处理终了========");
		return dto;
	}
	
	/**
	 * 服务记录关系删除处理
	 *
	 * @param dto IGASM14DTO
	 * @return IGASM14DTO
	 */
	public IGASM14DTO deleteEntityItemRelationAction(IGASM14DTO dto) throws BLException {
		log.debug("========服务记录关系删除处理开始========");
		
		for( int i=0;i<dto.getDeleteEntityItemRelation().length;i++ ){
			String eirid = dto.getDeleteEntityItemRelation()[i];
			
			SOC0119Info entityItemRelation = 
				this.soc0119BL.searchEntityItemRelationByKey(Integer.parseInt(eirid));
			
			if (entityItemRelation == null){
				throw new BLException("IGCO10000.E004","删除对象服务记录关系");
			}

			this.soc0119BL.deleteEntityItemRelation(entityItemRelation);
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I006","服务记录关系信息"));

		log.debug("========服务记录关系删除处理终了========");
		return dto;
	}

	/**
	 * 服务记录关系登记处理
	 *
	 * @param dto IGASM14DTO
	 * @return IGASM14DTO
	 */
	public IGASM14DTO insertEntityItemRelationAction(IGASM14DTO dto) throws BLException {
		log.debug("========服务记录关系登记处理开始========");
		
		IGASM1407Form form = dto.getIgasm1407Form();
		
		//服务记录ID（子）取得
		SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
		
		cond.setElabel(form.getElabel());
		cond.setEilabel(form.getEilabel());
		
		List<SOC0124Info> entityItemVWList = this.soc0118BL.searchEntityItemVW(cond, 0, 0);
		
		if ( entityItemVWList==null || entityItemVWList.size() == 0 ) {
			throw new BLException("IGCO10000.E004","(资产编号=" + form.getElabel() + ",服务记录编号=" 
					+ form.getEilabel() + ")服务记录");
		}
		
		form.setCldeiid(entityItemVWList.get(0).getEiid());
		form.setCldeid(entityItemVWList.get(0).getEid());
		form.setCldsmallversion(entityItemVWList.get(0).getEismallversion());
		form.setCldversion(entityItemVWList.get(0).getEiversion());
		
		//服务记录ID（父）和（子）检测
		if (form.getPareiid().intValue() == form.getCldeiid().intValue()) {
			//服务记录ID（父）= （子）
			throw new BLException(BLErrorType.ENTITY_ITEM_RELATION_ERROR,
					"IGCO10000.E012","服务记录");
		}
		
		//更新时间设定
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

		form.setEirupdtime(datetime);
		
		//资产关系登记
		SOC0119Info ret = 
			this.soc0119BL.registEntityItemRelation(dto.getIgasm1407Form());
		
		dto.setEntityItemRelation(ret);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "服务记录关系信息") );
		
		log.debug("========服务记录关系登记处理终了========");
		return dto;
	}
	
	/**
	 * 服务记录关系编辑画面初期化处理
	 *
	 * @param dto IGASM14DTO
	 * @return IGASM14DTO
	 */
	public IGASM14DTO initIGASM1407Action(IGASM14DTO dto) throws BLException {
		log.debug("========服务记录关系编辑画面初期化处理开始========");
		
		IGASM1407Form form = dto.getIgasm1407Form();
		SOC0119TB ret = 		
			(SOC0119TB) this.soc0119BL.searchEntityItemRelationByKey(
				form.getEirid());
		
		if ( ret == null ){
			throw new BLException("IGCO10000.E004","编辑对象服务记录关系");
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
		
		log.debug("========服务记录关系编辑画面初期化处理终了========");
		return dto;
	}

	/**
	 * 服务记录关系变更处理处理
	 *
	 * @param dto IGASM14DTO
	 * @return IGASM14DTO
	 */
	public IGASM14DTO updateEntityItemRelationAction(IGASM14DTO dto) throws BLException {
		log.debug("========服务记录关系变更处理处理开始========");
		IGASM1407Form form = dto.getIgasm1407Form();

		//更新时间设定
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

		form.setEirupdtime(datetime);
		
		this.soc0119BL.updateEntityItemRelation(form);

		dto.addMessage(new ActionMessage( "IGCO10000.I005", "服务记录关系信息") );

		log.debug("========服务记录关系变更处理处理终了========");
		return dto;
	}
	
	/**
	 *服务记录信息修改初期显示处理
	 *
	 * @param dto IGASM14DTO
	 * @return IGASM14DTO
	 */
	public IGASM14DTO initEntityItem(IGASM14DTO dto) throws BLException {

		log.debug("========服务记录信息编辑画面初期显示处理开始========");
		
		IGASM1412Form form = dto.getIgasm1412Form();
		
		//显示用资产信息取得
		SOC0124Info entityItem = this.soc0118BL.searchEntityItemVWByKey(form.getEiid());
		
		if ( entityItem == null ){
			throw new BLException("IGCO10000.E004","变更服务记录基本");
		}
		
		//画面显示设定
		
//		String orgsyscoding = entityItem.getEiorgsyscoding();
		String esyscoding = entityItem.getEsyscoding();
		SOC0117SearchCondImpl EntityCond = new SOC0117SearchCondImpl();
		EntityCond.setEsyscoding(esyscoding);
		List<SOC0117Info> entityList = this.soc0117BL.searchEntity(EntityCond, 0, 0);
		for (int i = 0; i < entityList.size(); i++) {
			form.setEname(entityList.get(0).getEname());
		}
//		OrganizationSearchCondImpl OrgCond = new OrganizationSearchCondImpl();
//		OrgCond.setOrgsyscoding(orgsyscoding);
		
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
		
		//判断登陆用户是否有查看该资产配置信息的权限
		boolean permission = this.soc0118BL.checkEntityItemDomain(dto.getUser(), entityItem);
		boolean isRoleManager = this.userRoleBL.checkRoleManagerByType(dto.getUser().getUserid(), EntityCategory.ROLE_TYPE_SERVICE);
		form.setRoleManager(isRoleManager);
		form.setPermission(permission);
		
		dto.setIgasm1412Form(form);
		
		//dto.addMessage(new ActionMessage("IGCO10000.I001","服务记录基本信息"));
		if(!permission) {
			dto.addMessage(new ActionMessage("IGCO10000.E023","修改"));
		}
		log.debug("========服务记录信息编辑画面初期显示处理终了========");
		return dto;
	}
	/**
	 *服务记录信息修改处理
	 *
	 * @param dto IGASM14DTO
	 * @return IGASM14DTO
	 */
	public IGASM14DTO updateEntityItem(IGASM14DTO dto) throws BLException {
		
		log.debug("========服务记录信息编辑画面初期显示处理开始========");
		
		IGASM1412Form form = dto.getIgasm1412Form();
		if(!form.getEilabel().equals(form.getEilabelbak())){
			this.soc0118BL.checkNotExistEntityItem(form.getEilabel());
		}
	
		SOC0118Info entityItem = this.soc0118BL.searchEntityItemByKey(form.getEiid());
		
		//找configitem中完全匹配的civalue
		//与该资产存在关系的名称同步修改
		//正常全匹配
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
			
		
		
		//EntityItemRelation中取得有关系的资产列表
		SOC0119SearchCondImpl ercond = new SOC0119SearchCondImpl();
		ercond.setCldeiid(entityItem.getEiid());
//		ercond.setCldeid(String.valueOf(entityItem.getEid()));
		List<SOC0119Info> erlist = this.soc0119BL.searchEntityItemRelation(ercond);
		
		if(!erlist.isEmpty()){
			
			//服务记录
			//Configuration中取得资产相关资产的cid
			SOC0109SearchCondImpl ccond = new SOC0109SearchCondImpl();
			//资产ID的cid
			ccond.setClabel(EntityItemKeyWords.ENTITY_DEFAULT_DEVICE_EIID);
			List<SOC0109Info> clist1 = this.soc0109BL.searchConfiguration(ccond);
			IG225TB cTB1 = (IG225TB)SerializationUtils.clone(clist1.get(0));
			//资产名称的cid
			ccond.setClabel(EntityItemKeyWords.ENTITY_DEFAULT_DEVICE_ENAME);
			List<SOC0109Info> clist2 = this.soc0109BL.searchConfiguration(ccond);
			IG225TB cTB2 = (IG225TB)SerializationUtils.clone(clist2.get(0));
			
			cicond.setCivalue(null);
			for(int j = 0; j < erlist.size(); j++){
				//服务记录
				//资产ID
				SOC0119TB erTB = (SOC0119TB)SerializationUtils.clone(erlist.get(j));
				cicond.setEiid(String.valueOf(erTB.getPareiid()));
				cicond.setCid(String.valueOf(cTB1.getCid()));
				List<SOC0107Info> cilist1 = this.soc0107BL.searchSOC0107(cicond);
				//如果关系了其他资产civalue中有资产ID的值,则查下一条中的资产名称
				if(!cilist1.isEmpty()){
					SOC0107TB ciTB1 = (SOC0107TB)SerializationUtils.clone(cilist1.get(0));
					cicond.setCid(String.valueOf(cTB2.getCid()));
					List<SOC0107Info> cilist2 = this.soc0107BL.searchSOC0107(cicond);
					SOC0107TB ciTB2 = (SOC0107TB)SerializationUtils.clone(cilist2.get(0));
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
					this.soc0107BL.updateSOC0107(ciTB2);
				}
			}
		}
	
		this.soc0118BL.updateEntityItem(form);
		dto.addMessage(new ActionMessage("IGCO10000.I005","服务记录基本信息"));
		log.debug("========服务记录信息编辑画面初期显示处理终了========");
		return dto;
	}
	
	/**
	 * 获取服务记录编号最大值
	 *
	 * @param dto IGASM14DTO
	 * @return IGASM14DTO
	 */
	public IGASM14DTO searchEntityItemLableAction(IGASM14DTO dto) throws BLException {
		
		log.debug("========获取服务记录编号最大值处理开始========");
		
		IGASM1402Form form = dto.getIgasm1402Form();
		
		SOC0118SearchCondImpl cond = new SOC0118SearchCondImpl();
		
		cond.setEilabel(CommonDefineUtils.ENTIY_CATEGORY_SERVICE_RECORD_KEY + IGStringUtils.getCurrentYear().substring(2));
		
		String eilabel = this.soc0118BL.searchNextEntityItemLable(cond);
		
		form.setEilabel(eilabel);
		
		log.debug("========获取服务记录编号最大值处理终了========");
		return dto;
	}
	
	/**
	 * 判断登陆用户是否是服务记录资产管理角色负责人
	 * 
	 * @param dto IGASM14DTO
	 * @return IGASM14DTO
	 * @throws BLException 
	 */
	public IGASM14DTO checkEntityItemDomain(IGASM14DTO dto) throws BLException{
		boolean isRoleManager = this.userRoleBL.checkRoleManagerByType(dto.getUser().getUserid(), EntityCategory.ROLE_TYPE_SERVICE);
		
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
			SOC0117SearchCondImpl entityCond = new SOC0117SearchCondImpl();
			entityCond.setEsyscoding(CommonDefineUtils.ENTIY_CATEGORY_SERVICE_RECORD_SYSCODING);
			List<SOC0117Info> entity = this.soc0117BL.searchEntity(entityCond, 0, 0);
			
			if(entity.size() != 1) {
				throw new BLException("IGCO10000.E004","服务记录模型");
			} else {
				dto.setEname(entity.get(0).getEname());
				dto.setEsyscoding(entity.get(0).getEsyscoding());
			}
		}
		
		dto.setFlag(isRoleManager);
		
		return dto;
	}
}
