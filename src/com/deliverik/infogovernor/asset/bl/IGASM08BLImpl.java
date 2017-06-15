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
 * 应用配置管理业务逻辑实现
 *
 */
public class IGASM08BLImpl extends BaseBLImpl implements IGASM08BL {

	static Log log = LogFactory.getLog(IGASM08BLImpl.class);

	/** 版本号升级标识 */
	public static final String SAVE_VERSION_UP = "1";

	/** 版本号不升级标识 */
	public static final String SAVE_VERSION = "0";
	
	public static final String  EIRRELATIONCODE="'002-003','003-003','003-005','003-006','003-011','003-010','003-001','012-003','013-003'";
	
	/** 文件上传BL */
	protected FileUploadBL fileUploadBL;
	
	/** 资产关联关系下拉数据BL */
	protected CodeDetailBL codeDetailBL;
	
	/** 机构BL */
	protected OrganizationBL organizationBL;
	
	
	/** 用户角色BL */
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
	 * 应用信息查询处理
	 *
	 * @param dto IGASM08DTO
	 * @return IGASM08DTO
	 */
	public IGASM08DTO searchEntityItemAction(IGASM08DTO dto) throws BLException {

		log.debug("========应用信息查询处理开始========");
		
		//应用信息查询件数取得 
		int totalCount = this.soc0118BL.getEntityItemVWSearchCount(dto.getEntityItemVWSearchCond());
		
		if (totalCount == 0) {
			log.debug("========应用信息查询数据不存在========");
			//应用信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========应用信息查询数据件数过多========");
			//应用信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//分页用信息取得
		PagingDTO pDto = dto.getPagingDto();

		//当前页应用信息取得
		List<SOC0124Info> entityItemVWInfoList = this.soc0118BL.searchEntityItemVW(dto.getEntityItemVWSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setEntityItemVWInfoList(entityItemVWInfoList);

		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========应用信息查询处理终了========");
		return dto;
	}
	
	/**
	 * 应用信息登记处理
	 *
	 * @param dto IGASM08DTO
	 * @return IGASM08DTO
	 */
	public IGASM08DTO insertEntityItemAction(IGASM08DTO dto) throws BLException {
		log.debug("========应用信息登记处理开始========");
		//输入Form取得
		IGASM0802Form form = dto.getIgasm0802Form();
		
		/*//类型ID取得
		EntitySearchCondImpl cond = new EntitySearchCondImpl();
		cond.setElabel(form.getElabel());
		
		//登记处理前的资产信息确认
		List<Entity> entityList = this.soc0117BL.searchEntity(cond, 0, 0);
		
		if ( entityList == null || entityList.size() ==0 ) {
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","(编号=" + form.getElabel() + ")资产基本");
		}
		
		Entity entity = entityList.get(0);
		
		//***************************************************************************
		//类型分类检测
		if (!entity.getEcategory().equals(CommonDefineUtils.ENTIY_CATEGORY_APPLICATION)) {
			//应用以外的情况
			throw new BLException(BLErrorType.ENTITY_CATEGORY_ERROR,
					"IGCO10000.E011","应用");
		}
		//***************************************************************************
		
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

		//应用信息登录
		SOC0118Info entityItem = this.soc0118BL.registEntityItem(dto.getIgasm0802Form());
		
		form.setEiidStr(entityItem.getEiid().toString());
		
		dto.setIgasm0802Form(form);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "应用基本信息") );

		log.debug("========应用信息登记处理终了========");
		return dto;
	}

	/**
	 * 应用信息删除处理
	 *
	 * @param dto IGASM08DTO
	 * @return IGASM08DTO
	 */
	public IGASM08DTO deleteEntityItemAction(IGASM08DTO dto) throws BLException {
		log.debug("========应用信息删除处理开始========");
		
		for( int i=0;i<dto.getDeleteEntityItem().length;i++ ){
			String eiid = dto.getDeleteEntityItem()[i];
			
			//删除前删除对象应用确认
			SOC0118Info entityItem = this.soc0118BL.searchEntityItemByKey(Integer.parseInt(eiid));
			
			if (entityItem == null){
				throw new BLException("IGCO10000.E004","删除对象应用基本");
			}

			//应用删除
			this.soc0118BL.deleteEntityItem(entityItem);
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I006","应用信息"));

		log.debug("========应用信息删除处理终了========");
		return dto;
	}

	/**
	 * 应用配置信息编辑画面初期化处理
	 *
	 * @param dto IGASM08DTO
	 * @return IGASM08DTO
	 */
	public IGASM08DTO initIGASM0804Action(IGASM08DTO dto) throws BLException {

		log.debug("========应用配置信息编辑画面初期化处理开始========");
		
		IGASM0804Form form = dto.getIgasm0804Form();
		
		//应用信息检索
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(
				Integer.parseInt(form.getEiid()));
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","应用");
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
		//判断登陆用户是否有查看该资产配置信息的权限
		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(), entityItemVWInfo);

		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}else{
			dto.setFlag(flag);
		}
		//应用配置信息查询件数取得 
		int totalCount = this.soc0107BL.getConfigItemVWSearchCount(form);
		
		if (totalCount == 0) {
			log.debug("========应用配置信息查询数据不存在========");
			//应用配置信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I007",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========应用配置信息查询数据件数过多========");
			//应用配置信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//应用配置信息全件查询
		List<SOC0129Info> configItemVWInfoList = this.soc0107BL.searchConfigItemVW(
				form, 0, 0);
		
		String[] civalue = new String[totalCount];
		String[] delfile = new String[totalCount];
		String[] entityItemCivalue = new String[totalCount];
		String[] isUpgrade=new String[totalCount];
		//存放旧版本值
		String[] civalue_bak = new String[totalCount];
		Map<String,List<SOC0129Info>> map = new LinkedHashMap<String,List<SOC0129Info>>();
		int i = 0;
		int j = 0;
		List<String> strlist = new ArrayList<String>();
		Map<String, String> cldVersionMap=new HashMap<String, String>();//子资产版本集合
		for(SOC0129Info e : configItemVWInfoList){
			if("4".equals(e.getCattach())){
				String value = e.getCivalue();
				if(StringUtils.isNotEmpty(value)){
					Integer cldeiid = Integer.parseInt(value.substring(value.lastIndexOf("(")+1, value.length()-1));//子资产eiid
					
					SOC0119SearchCondImpl cond=new SOC0119SearchCondImpl();
					cond.setPareiid(Integer.parseInt(form.getEiid()));
					cond.setCldeiid(cldeiid);
					cond.setParversion(entityItemVWInfo.getEiversion());
					cond.setEirinfo("_"+e.getCiid()+"_");
					cond.setDeleteflag("0");
					List<SOC0119Info> ig313Info = soc0119BL.searchEntityItemRelation(cond);
					String cldversion="";
					if(ig313Info!=null&&ig313Info.size()>0){
						cldversion = String.valueOf(ig313Info.get(0).getCldversion());//子资产版本
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


		
		log.debug("========应用配置信息编辑画面初期化处理终了========");
		return dto;
	}
	
	/**
	 * 应用配置信息编辑处理
	 *
	 * @param dto IGASM08DTO
	 * @return IGASM08DTO
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public IGASM08DTO editEntityItemAction(IGASM08DTO dto) throws BLException, FileNotFoundException, IOException {
		log.debug("========应用配置信息编辑处理开始========");
		//版本号生成
		IGASM0804Form form = dto.getIgasm0804Form();
		
		//应用基本信息更新
		SOC0118TB entityItem = (SOC0118TB) this.soc0118BL.searchEntityItemByKey(Integer.parseInt(form.getEiid()));
		
		// 取得版本是否升级标识
		String ident = form.getIdent();
		if(StringUtils.isEmpty(ident)){
			ident = IGASM08BLImpl.SAVE_VERSION;
		}
		// 版本号初始化
		int version = 1;
		boolean versonFlag = false;
		// 判断是否升级版本号
		// =====================>> 修改 start
		if (IGASM08BLImpl.SAVE_VERSION_UP.equals(ident)) { // 升级版本号
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
			
			if (version - 1 != entityItem.getEiversion()) {
				throw new BLException("IGCO00000.E004");
			}
		} else if (IGASM08BLImpl.SAVE_VERSION.equals(ident)) { // 不升级版本号

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
		
		//应用状态
//		entityItem.setEistatus(form.getEistatus());
		//应用版本
		entityItem.setEiversion(version);
		
		//应用说明
		entityItem.setEidesc(form.getEidesc());

		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		
		//更新时间
		entityItem.setEiupdtime(datetime);
		
		this.soc0118BL.updateEntityItem(entityItem);
		//=======更新关系开始========
		if(version ==1&&versonFlag){
			SOC0119SearchCondImpl eircond1 = new SOC0119SearchCondImpl();
			//删除标识
			eircond1.setDeleteflag("0");
			//与该资产相关的关系码
			eircond1.setEirrelationcode(IGASM08BLImpl.EIRRELATIONCODE);
			eircond1.setEiid(entityItem.getEiid().toString());
			//该资产现有的关系信息
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
					//正向关系时
					if(entityItem.getEiid().equals(ig313Info.getPareiid())){
						ig313tb.setParversion(entityItem.getEiversion());
						this.soc0119BL.registEntityItemRelation(ig313tb);
					}
					//方向关系时
					if(entityItem.getEiid().equals(ig313Info.getCldeiid())){
						ig313tb.setCldversion(entityItem.getEiversion());
						this.soc0119BL.registEntityItemRelation(ig313tb);
					}
				}
			}
		}
		//=======更新关系结束========
		
		//调用更新BL
		
		//应用配置信息更新
		if (form.getCiid() != null && form.getCiid().length > 0 ) {
			
			for( int i=0 ; i < form.getCiid().length; i++ ){
				SOC0107TB configItem = new SOC0107TB();
				//应用ID
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
				
				if (StringUtils.isEmpty(form.getCiid()[i])) {	
					//更新标识
					if(StringUtils.isEmpty(configItem.getCivalue())) {
						configItem.setCicurver("0");
					} else {
						configItem.setCicurver("1");
					}
					configItem = (SOC0107TB) this.soc0107BL.registSOC0107(configItem);
					
					//属性类别为资产时，增加关联关系
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
					if (IGASM08BLImpl.SAVE_VERSION_UP.equals(ident)) { // 升级版本号

						configItem = (SOC0107TB) this.soc0107BL.registSOC0107(configItem);

					} else if (IGASM08BLImpl.SAVE_VERSION.equals(ident)) { // 不升级版本号
					
						Integer ciid = Integer.valueOf(form.getCiid()[i]); 
						
						// 查询当前配置项
						SOC0107Info cfi = this.soc0107BL.searchSOC0107ByKey(ciid);
						
						// 判断当前配置项是否是新增的
						if(configItem.getCid().equals(cfi.getCid())){ // 不是新增配置项进行更新
							
							configItem.setCiid(ciid);
							configItem = (SOC0107TB) this.soc0107BL
								.updateSOC0107(configItem);
							
						}else{  // 新增配置项进行新增
							
							configItem = (SOC0107TB) this.soc0107BL
							.registSOC0107(configItem);
							
						}
					}
					
					//属性类别为资产时，增加关联关系
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
						//应用ID
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
						
						this.soc0107BL.updateSOC0107(configItem);					
						
					}
				}
			}
			
		}
	
		dto.addMessage(new ActionMessage("IGCO10000.I005","应用配置信息"));
		
		log.debug("========应用配置信息编辑处理终了========");
		
		return dto;
	}

	/**
	 * 应用配置信息历史记录画面初期化处理
	 *
	 * @param dto IGASM08DTO
	 * @return IGASM08DTO
	 */
	public IGASM08DTO initIGASM0805Action(IGASM08DTO dto) throws BLException {
		log.debug("========应用配置信息历史记录画面初期化处理开始========");
		
		//应用信息检索
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(
				dto.getIgasm0805Form().getEiid());
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","应用");
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
		//获取历史版本更新时间
		dto.setConfigItemVersionTime(this.soc0118BL.searchVersionUpdateTime(dto.getIgasm0805Form().getEiid()));
		
		//判断登陆用户是否有查看该资产配置信息的权限
		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(), entityItemVWInfo);

		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}else{
			dto.setFlag(flag);
		}
		
		log.debug("========应用配置信息历史记录画面初期化处理终了========");
		return dto;
	}

	/**
	 * 应用关系管理画面初期化处理
	 *
	 * @param dto IGASM08DTO
	 * @return IGASM08DTO
	 */
	public IGASM08DTO initIGASM0806Action(IGASM08DTO dto) throws BLException {
		log.debug("========应用关系管理画面初期化处理开始========");
		
		//应用信息检索
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(
				Integer.parseInt(dto.getIgasm0806Form().getEiid()));
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","应用");
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
		//正向关联关系检索
		SOC0119SearchCondImpl parcond = new SOC0119SearchCondImpl();
		if((dto.getIgasm0806Form().getEiid())!=null){
		parcond.setPareiid(Integer.parseInt(dto.getIgasm0806Form().getEiid()));}
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
		//应用关系信息查询件数取得 
		int totalCount = this.soc0119BL.getEntityItemRelationSearchCount(parcond);
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========应用关系信息查询数据件数过多========");
			//应用关系信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		if ( totalCount>0 ) {
			//应用关系信息全件检索
			//设备关系信息全件检索
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
//		SOC0119SearchCondImpl cldcond = new SOC0119SearchCondImpl();
//		
//		cldcond.setCldeiid(dto.getIgasm0806Form().getEiid());
//		cldcond.setCldversion(entityItemVWInfo.getEiversion().toString());
//		cldcond.setCldsmallversion(entityItemVWInfo.getEismallversion().toString());
//		cldcond.setDeleteflag("0");
//		
//		//应用关系信息查询件数取得 
//		totalCount = this.soc0119BL.getIG313InfoSearchCount(cldcond);
//		
//		if ( totalCount > dto.getMaxSearchCount() ) {
//			log.debug("========应用关系信息查询数据件数过多========");
//			//应用关系信息查询数据件数过多
//			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
//			return dto;
//		}
//
//		//应用关系信息全件检索
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

		log.debug("========应用关系管理画面初期化处理终了========");
		return dto;
	}
	
	/**
	 * 应用关系删除处理
	 *
	 * @param dto IGASM08DTO
	 * @return IGASM08DTO
	 */
	public IGASM08DTO deleteEntityItemRelationAction(IGASM08DTO dto) throws BLException {
		log.debug("========应用关系删除处理开始========");
		
		for( int i=0;i<dto.getDeleteEntityItemRelation().length;i++ ){
			String eirid = dto.getDeleteEntityItemRelation()[i];
			
			SOC0119Info entityItemRelation = 
				this.soc0119BL.searchEntityItemRelationByKey(Integer.parseInt(eirid));
			
			if (entityItemRelation == null){
				throw new BLException("IGCO10000.E004","删除对象应用关系");
			}

			this.soc0119BL.deleteEntityItemRelation(entityItemRelation);
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I006","应用关系信息"));

		log.debug("========应用关系删除处理终了========");
		return dto;
	}

	/**
	 * 应用关系登记处理
	 *
	 * @param dto IGASM08DTO
	 * @return IGASM08DTO
	 */
	public IGASM08DTO insertEntityItemRelationAction(IGASM08DTO dto) throws BLException {
		log.debug("========应用关系登记处理开始========");
		
		IGASM0807Form form = dto.getIgasm0807Form();
		
		//应用ID（子）取得
		SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
		
		cond.setElabel(form.getElabel());
		cond.setEilabel(form.getEilabel());
		
		List<SOC0124Info> entityItemVWList = this.soc0118BL.searchEntityItemVW(cond, 0, 0);
		
		if ( entityItemVWList==null || entityItemVWList.size() == 0 ) {
			throw new BLException("IGCO10000.E004","(资产编号=" + form.getElabel() + ",应用编号=" 
					+ form.getEilabel() + ")应用");
		}
		
		form.setCldeiid(entityItemVWList.get(0).getEiid());
		form.setCldeid(entityItemVWList.get(0).getEid());
		form.setCldversion(entityItemVWList.get(0).getEiversion());
		form.setCldsmallversion(entityItemVWList.get(0).getEismallversion());
		//应用ID（父）和（子）检测
		if (form.getPareiid().intValue() == form.getCldeiid().intValue()) {
			//应用ID（父）= （子）
			throw new BLException(BLErrorType.ENTITY_ITEM_RELATION_ERROR,
					"IGCO10000.E012","应用");
		}
		
		//更新时间设定
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

		form.setEirupdtime(datetime);
		
		//资产关系登记
		SOC0119Info ret = 
			this.soc0119BL.registEntityItemRelation(dto.getIgasm0807Form());
		
		dto.setEntityItemRelation(ret);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "应用关系信息") );
		
		log.debug("========应用关系登记处理终了========");
		return dto;
	}
	
	/**
	 * 应用关系编辑画面初期化处理
	 *
	 * @param dto IGASM08DTO
	 * @return IGASM08DTO
	 */
	public IGASM08DTO initIGASM0807Action(IGASM08DTO dto) throws BLException {
		log.debug("========应用关系编辑画面初期化处理开始========");
		
		IGASM0807Form form = dto.getIgasm0807Form();
		SOC0119TB ret = 		
			(SOC0119TB) this.soc0119BL.searchEntityItemRelationByKey(
				form.getEirid());
		
		if ( ret == null ){
			throw new BLException("IGCO10000.E004","编辑对象应用关系");
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
		form.setTempeirrelation(ret.getEirrelation()+"#"+ret.getEirrelationcode());
		form.setEiname(ret.getCldEntityItemVW().getEiname());
		form.setMode("1");
		
		log.debug("========应用关系编辑画面初期化处理终了========");
		return dto;
	}

	/**
	 * 应用关系变更处理处理
	 *
	 * @param dto IGASM08DTO
	 * @return IGASM08DTO
	 */
	public IGASM08DTO updateEntityItemRelationAction(IGASM08DTO dto) throws BLException {
		log.debug("========应用关系变更处理处理开始========");
		IGASM0807Form form = dto.getIgasm0807Form();

		//更新时间设定
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

		form.setEirupdtime(datetime);
		
		this.soc0119BL.updateEntityItemRelation(form);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "应用关系信息") );

		log.debug("========应用关系变更处理处理终了========");
		return dto;
	}
	
	/**
	 *	获取应用关联关系处理
	 *
	 * @param dto IGASM08DTO
	 * @return IGASM08DTO
	 */
	public IGASM08DTO searchRelationListAction(IGASM08DTO dto) throws BLException {
		log.debug("========获取应用关联关系处理开始========");
		List<LabelValueBean> list = this.codeDetailBL.searchLabelValueBeanList(CommonDefineUtils.ENTIY_CATEGORY_APPLICATION,CodeDefine.getCodeDefine("ENTITY_ITEM_RELATION_CODE").getCcid());
		dto.setRelationList(list);
		log.debug("========获取应用关联关系处理终了========");
		return dto;
	}
	

	/**
	 *应用信息修改初期显示处理
	 *
	 * @param dto IGASM08DTO
	 * @return IGASM08DTO
	 */
	public IGASM08DTO initEntityItem(IGASM08DTO dto) throws BLException {

		log.debug("========应用信息编辑画面初期显示处理开始========");
		
		IGASM0812Form form = dto.getIgasm0812Form();
		
		//显示用资产信息取得
		SOC0124Info entityItem = this.soc0118BL.searchEntityItemVWByKey(form.getEiid());
		
		if ( entityItem == null ){
			throw new BLException("IGCO10000.E004","变更应用基本");
		}
		
		//画面显示设定
		
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
		
		//判断登陆用户是否有查看该资产配置信息的权限
		boolean permission = this.soc0118BL.checkEntityItemDomain(dto.getUser(), entityItem);
		boolean isRoleManager = this.userRoleBL.checkRoleManagerByType(dto.getUser().getUserid(), EntityCategory.ROLE_TYPE_APPLICATION);
		form.setRoleManager(isRoleManager);
		form.setPermission(permission);
		
		dto.setIgasm0812Form(form);
		
		//dto.addMessage(new ActionMessage("IGCO10000.I001","应用基本信息"));
		if(!permission) {
			dto.addMessage(new ActionMessage("IGCO10000.E023","修改"));
		}
		log.debug("========应用信息编辑画面初期显示处理终了========");
		return dto;
	}
	/**
	 *应用信息修改处理
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM08DTO updateEntityItem(IGASM08DTO dto) throws BLException {
		
		log.debug("========应用信息编辑画面初期显示处理开始========");
		
		IGASM0812Form form = dto.getIgasm0812Form();
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
			SOC0109TB cTB1 = (SOC0109TB)SerializationUtils.clone(clist1.get(0));
			//资产名称的cid
			ccond.setClabel(EntityItemKeyWords.ENTITY_DEFAULT_DEVICE_ENAME);
			List<SOC0109Info> clist2 = this.soc0109BL.searchConfiguration(ccond);
			SOC0109TB cTB2 = (SOC0109TB)SerializationUtils.clone(clist2.get(0));
			
			cicond.setCivalue(null);
			for(int j = 0; j < erlist.size(); j++){
				//服务记录
				//资产ID
				SOC0119TB erTB = (SOC0119TB)SerializationUtils.clone(erlist.get(j));
				cicond.setEiid(erTB.getPareiid().toString());
				cicond.setCid(cTB1.getCid());
				List<SOC0107Info> cilist1 = this.soc0107BL.searchSOC0107(cicond);
				//如果关系了其他资产civalue中有资产ID的值,则查下一条中的资产名称
				if(!cilist1.isEmpty()){
					SOC0107TB ciTB1 = (SOC0107TB)SerializationUtils.clone(cilist1.get(0));
					cicond.setCid(cTB2.getCid());
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
		dto.addMessage(new ActionMessage("IGCO10000.I005","应用基本信息"));
		log.debug("========应用信息编辑画面初期显示处理终了========");
		return dto;
	}
	
	/**
	 * 获取应用编号最大值
	 *
	 * @param dto IGASM08DTO
	 * @return IGASM08DTO
	 */
	public IGASM08DTO searchEntityItemLableAction(IGASM08DTO dto) throws BLException {
		
		log.debug("========获取应用编号最大值处理开始========");
		
		IGASM0802Form form = dto.getIgasm0802Form();
		
		SOC0118SearchCondImpl cond = new SOC0118SearchCondImpl();
		
		cond.setEilabel(CommonDefineUtils.ENTIY_CATEGORY_APPLICATION_KEY + IGStringUtils.getCurrentYear().substring(2));
		
		String eilabel = this.soc0118BL.searchNextEntityItemLable(cond);
		
		form.setEilabel(eilabel);
		
		log.debug("========获取应用编号最大值处理终了========");
		return dto;
	}
	
	/**
	 * 判断登陆用户是否是应用资产管理角色负责人
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
				throw new BLException("IGCO10000.E004","顶级机构");
			} else {
				dto.setOrgname(org.get(0).getOrgname());
				dto.setOrgsyscoding(org.get(0).getOrgsyscoding());
			}
			SOC0117SearchCondImpl entityCond = new SOC0117SearchCondImpl();
			entityCond.setEsyscoding(CommonDefineUtils.ENTIY_CATEGORY_APPLICATION_SYSCODING);
			List<SOC0117Info> entity = this.soc0117BL.searchEntity(entityCond, 0, 0);
			
			if(entity.size() != 1) {
				throw new BLException("IGCO10000.E004","应用模型");
			} else {
				dto.setEname(entity.get(0).getEname());
				dto.setEsyscoding(entity.get(0).getEsyscoding());
			}
		}
		
		dto.setFlag(isRoleManager);
		
		return dto;
	}
}
