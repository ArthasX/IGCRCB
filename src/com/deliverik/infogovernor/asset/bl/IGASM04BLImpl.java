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
 * 合同配置管理业务逻辑实现
 *
 */
public class IGASM04BLImpl extends BaseBLImpl implements IGASM04BL {

	static Log log = LogFactory.getLog(IGASM04BLImpl.class);
	
	private final static String XML_HEADER= "%3C?xml%20version=%221.0%22%20encoding=%22utf-8%22%20?%3E";
	
	private final static String SERVICE_PROVIDER = "4";
	
	/** 读取SystemConfigResources消息资源文件 */
	private MessageResources resources = MessageResources.getMessageResources("SystemConfigResources");

	/** 版本号升级标识 */
	public static final String SAVE_VERSION_UP = "1";

	/** 版本号不升级标识 */
	public static final String SAVE_VERSION = "0";
	
	public static final String EIRRELATIONCODE="'002-011','003-011','011-005','006-011','011-011','011-010','001-011'";
	
	/** 资产信息BL */
	protected SOC0117BL soc0117BL;

	/** 配置项信息BL */
	protected IG013BL ig013BL;
	protected SOC0118BL soc0118BL;
	
	/** 资产配置项BL */
	protected SOC0107BL soc0107BL;
	
	/** 配置项关系BL */
	protected SOC0119BL soc0119BL;
	
	/** 文件上传BL */
	protected FileUploadBL fileUploadBL;
	
	/** 资产关联关系下拉数据BL */
	protected CodeDetailBL codeDetailBL;
	
	/** 资产取值范围下拉数据BL */
//	protected IG545BL ig545BL;
	protected SOC0151BL soc0151BL;

	/** 机构BL */
	protected OrganizationBL organizationBL;
	
	/** 配置项BL */
	protected SOC0109BL soc0109BL;
	
	/** 用户角色BL */
	protected UserRoleBL userRoleBL;
	
	protected IG499BL ig499BL;
	
	/** 基础数据BL */
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
	 * 基础数据BL设定
	 * 
	 * @param codeListUtils 基础数据BL
	 */
	public void setCodeListUtils(CodeListUtils codeListUtils) {
		this.codeListUtils = codeListUtils;
	}

	/**
	 * 合同信息查询处理
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO searchEntityItemAction(IGASM04DTO dto) throws BLException {

		log.debug("========合同信息查询处理开始========");
		
		//合同信息查询件数取得 
		int totalCount = this.ig499BL.getSearchCount(dto.getEntityItemCompactVWSearchCond());
		List<LabelValueBean> selectList = this.soc0151BL.searchLabelValueBeanList("039");
		dto.setSelectList(selectList);
		
		if (totalCount == 0) {
			log.debug("========合同信息查询数据不存在========");
			//合同信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========合同信息查询数据件数过多========");
			//合同信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//分页用信息取得
		PagingDTO pDto = dto.getPagingDto();

		//当前页合同信息取得
		List<IG499Info> entityItemCompactVWInfoList = this.ig499BL.searchIG499Info(dto.getEntityItemCompactVWSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setEntityItemCompactVWInfoList(entityItemCompactVWInfoList);

		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========合同信息查询处理终了========");
		return dto;
	}
	
	/**
	 * 合同信息登记处理
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO insertEntityItemAction(IGASM04DTO dto) throws BLException {
		log.debug("========合同信息登记处理开始========");
		//输入Form取得
		IGASM0402Form form = dto.getIgasm0402Form();
		
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
		if (!entity.getEcategory().equals(CommonDefineUtils.ENTIY_CATEGORY_CONTRACT)) {
			//合同以外的情况
			throw new BLException(BLErrorType.ENTITY_CATEGORY_ERROR,
					"IGCO10000.E011","合同");
		}
		//***************************************************************************
		
		form.setEid(entity.getEid());*/
		form.setEidStr(form.getEid().toString());
		//设置资产类型
//		form.setEid(CommonDefineUtils.ENTIY_CATEGORY_CONTRACT);
		form.setEid(form.getEid().toString());
		//设置资产模型码
		form.setEsyscoding(CommonDefineUtils.ENTIY_CATEGORY_CONTRACT_SYSCODING);
		//设置合同资产默认机构（本部）
		form.setEiorgsyscoding(dto.getUser().getOrgid());
		
		//更新时间设定
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		
		form.setEiupdtime(datetime);
		
		//大版本设定（固定设为0）
		form.setEiversion(0);
		
		//小版本设定（固定设为0）
		form.setEismallversion(0);

		//合同信息登录
		SOC0118Info entityItem = this.soc0118BL.registEntityItem(dto.getIgasm0402Form());
		
		form.setEiidStr(entityItem.getEiid().toString());
		
		dto.setIgasm0402Form(form);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "合同基本信息") );

		log.debug("========合同信息登记处理终了========");
		return dto;
	}

	/**
	 * 合同信息删除处理
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO deleteEntityItemAction(IGASM04DTO dto) throws BLException {
		log.debug("========合同信息删除处理开始========");
		
		for( int i=0;i<dto.getDeleteEntityItem().length;i++ ){
			String eiid = dto.getDeleteEntityItem()[i];
			
			//删除前删除对象合同确认
			SOC0118Info entityItem = this.soc0118BL.searchEntityItemByKey(Integer.parseInt(eiid));
			
			if (entityItem == null){
				throw new BLException("IGCO10000.E004","删除对象合同基本");
			}

			//合同删除
			this.soc0118BL.deleteEntityItem(entityItem);
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I006","合同信息"));

		log.debug("========合同信息删除处理终了========");
		return dto;
	}

	/**
	 * 合同配置信息编辑画面初期化处理
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO initIGASM0404Action(IGASM04DTO dto) throws BLException {

		log.debug("========合同配置信息编辑画面初期化处理开始========");
		
		IGASM0404Form form = dto.getIgasm0404Form();
		//获取消息资源文件标识
		String image_flag = resources.getMessage("IMAGE_FLAG");
		
		//合同信息检索
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(
			Integer.parseInt(form.getEiid()));
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","合同");
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
		
		//合同配置信息查询件数取得 
		int totalCount = this.soc0107BL.getConfigItemVWSearchCount(form);
		
		if (totalCount == 0) {
			log.debug("========合同配置信息查询数据不存在========");
			//合同配置信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I007",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========合同配置信息查询数据件数过多========");
			//合同配置信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//合同配置信息全件查询
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
		
		//第6笔付款
		dismap.put("IG_0191","n");
		dismap.put("IG_0192","n");
		dismap.put("IG_0193","n");
		dismap.put("IG_0194","n");
		dismap.put("IG_0195","n");
		dismap.put("IG_0196","n");
		dismap.put("IG_0197","n");
		
		//第7笔付款
        dismap.put("IG_0198","n");
        dismap.put("IG_0199","n");
        dismap.put("IG_0200","n");
        dismap.put("IG_0201","n");
        dismap.put("IG_0202","n");
        dismap.put("IG_0203","n");
        dismap.put("IG_0204","n");
        
      //第8笔付款
        dismap.put("IG_0205","n");
        dismap.put("IG_0206","n");
        dismap.put("IG_0207","n");
        dismap.put("IG_0208","n");
        dismap.put("IG_0209","n");
        dismap.put("IG_0210","n");
        dismap.put("IG_0211","n");
        
      //第9笔付款
        dismap.put("IG_0212","n");
        dismap.put("IG_0213","n");
        dismap.put("IG_0214","n");
        dismap.put("IG_0215","n");
        dismap.put("IG_0216","n");
        dismap.put("IG_0217","n");
        dismap.put("IG_0218","n");
        
      //第10笔付款
        dismap.put("IG_0219","n");
        dismap.put("IG_0220","n");
        dismap.put("IG_0221","n");
        dismap.put("IG_0222","n");
        dismap.put("IG_0223","n");
        dismap.put("IG_0224","n");
        dismap.put("IG_0225","n");
        
      //第11笔付款
        dismap.put("IG_0226","n");
        dismap.put("IG_0227","n");
        dismap.put("IG_0228","n");
        dismap.put("IG_0229","n");
        dismap.put("IG_0230","n");
        dismap.put("IG_0231","n");
        dismap.put("IG_0232","n");
        
      //第12笔付款
        dismap.put("IG_0233","n");
        dismap.put("IG_0234","n");
        dismap.put("IG_0235","n");
        dismap.put("IG_0236","n");
        dismap.put("IG_0237","n");
        dismap.put("IG_0238","n");
        dismap.put("IG_0239","n");
        
      //第13笔付款
        dismap.put("IG_0240","n");
        dismap.put("IG_0241","n");
        dismap.put("IG_0242","n");
        dismap.put("IG_0243","n");
        dismap.put("IG_0244","n");
        dismap.put("IG_0245","n");
        dismap.put("IG_0246","n");
        
      //第14笔付款
        dismap.put("IG_0247","n");
        dismap.put("IG_0248","n");
        dismap.put("IG_0249","n");
        dismap.put("IG_0250","n");
        dismap.put("IG_0251","n");
        dismap.put("IG_0252","n");
        dismap.put("IG_0253","n");
        
      //第15笔付款
        dismap.put("IG_0254","n");
        dismap.put("IG_0255","n");
        dismap.put("IG_0256","n");
        dismap.put("IG_0257","n");
        dismap.put("IG_0258","n");
        dismap.put("IG_0259","n");
        dismap.put("IG_0260","n");

		
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
				//第6笔付款
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
				//第7笔付款
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
              //第8笔付款
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
              //第9笔付款
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
              //第10笔付款
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
              //第11笔付款
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
              //第12笔付款
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
              //第13笔付款
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
              //第14笔付款
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
              //第15笔付款
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
		//影响加密XML设定
		//如果IMAGE_FLAG为true则不进行XML的创建
		if(image_flag.equals("true")){
			dto.setImage_flag(true);
		}else {
			dto.setImage_flag(false);
			dto.setPicuXml(createImageXml(entityItemVWInfo.getEiid(), entityItemVWInfo.getEilabel(),
					entityItemVWInfo.getEiname(), entityItemVWInfo.getEidesc(), "1"));
			dto.setPicsXml(createImageXml(entityItemVWInfo.getEiid(), entityItemVWInfo.getEilabel(),
					entityItemVWInfo.getEiname(), entityItemVWInfo.getEidesc(), "2"));
		}
		
		log.debug("========合同配置信息编辑画面初期化处理终了========");
		return dto;
	}
	
	/**
	 * 生成影像加密XML
	 * @param eiid 合同ID
	 * @param eilabel 合同编号
	 * @param einame 合同名称
	 * @param eidesc 合同说明
	 * @param operType 操作类型：1查看，2上传
	 * @return XML
	 */
	private String createImageXml(Integer eiid, String eilabel,
			String einame, String eidesc, String operType) {
		//生成XML
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
		//生成加密后的XML
		StringBuffer xml = new StringBuffer();
		xml.append(this.codeListUtils.getCodeValue("158", null, null, "1"));
		xml.append(XML_HEADER);
		log.debug(sbf.toString());
		try {
			xml.append(URLEncoder.encode(sbf.toString(), "UTF-8"));
			xml.append("&nocache=");
			xml.append(new Date());
		} catch (UnsupportedEncodingException e) {
			log.error("异常：", e);
		}
		return xml.toString();
	}
	
	/**
	 * 合同配置信息编辑处理
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public IGASM04DTO editEntityItemAction(IGASM04DTO dto) throws BLException, FileNotFoundException, IOException {
		log.debug("========合同配置信息编辑处理开始========");
		//版本号生成
		IGASM0404Form form = dto.getIgasm0404Form();
		
		//合同基本信息更新
		SOC0118TB entityItem = (SOC0118TB) this.soc0118BL.searchEntityItemByKey(Integer.parseInt(form.getEiid()));
		// 取得版本是否升级标识
		String ident = form.getIdent();
		if(StringUtils.isEmpty(ident)){
			ident = IGASM04BLImpl.SAVE_VERSION;
		}
		// 版本号初始化
		int version = 1;
		boolean versonFlag = false;
		// 判断是否升级版本号
		// =====================>> 修改 start
		if (IGASM04BLImpl.SAVE_VERSION_UP.equals(ident)) { // 升级版本号
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
		} else if (IGASM04BLImpl.SAVE_VERSION.equals(ident)) { // 不升级版本号

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
		
		//合同状态
//		entityItem.setEistatus(form.getEistatus());
		//合同版本
		entityItem.setEiversion(version);
		
		//合同说明
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
			eircond1.setEirrelationcode(IGASM04BLImpl.EIRRELATIONCODE);
			eircond1.setEiid(String.valueOf(entityItem.getEiid()));
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
		
		//合同配置信息更新
		if (form.getCiid() != null && form.getCiid().length > 0 ) {
			
			for( int i=0 ; i < form.getCiid().length; i++ ){
				SOC0107TB configItem = new SOC0107TB();
				//合同ID
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
					if (IGASM04BLImpl.SAVE_VERSION_UP.equals(ident)) { // 升级版本号

						configItem = (SOC0107TB) this.soc0107BL.registSOC0107(configItem);

					} else if (IGASM04BLImpl.SAVE_VERSION.equals(ident)) { // 不升级版本号
					
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
						//合同ID
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
	
		dto.addMessage(new ActionMessage("IGCO10000.I005","合同配置信息"));
		
		log.debug("========合同配置信息编辑处理终了========");
		
		return dto;
	}

	/**
	 * 合同配置信息历史记录画面初期化处理
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO initIGASM0405Action(IGASM04DTO dto) throws BLException {
		log.debug("========合同配置信息历史记录画面初期化处理开始========");
		
		//合同信息检索
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(
				dto.getIgasm0405Form().getEiid());
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","合同");
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
		//获取历史版本更新时间
		dto.setConfigItemVersionTime(this.soc0118BL.searchVersionUpdateTime(dto.getIgasm0405Form().getEiid()));
		
		//判断登陆用户是否有查看该资产配置信息的权限
		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(), entityItemVWInfo);

		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}else{
			dto.setFlag(flag);
		}
		
		log.debug("========合同配置信息历史记录画面初期化处理终了========");
		return dto;
	}

	/**
	 * 合同关系管理画面初期化处理
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO initIGASM0406Action(IGASM04DTO dto) throws BLException {
		log.debug("========合同关系管理画面初期化处理开始========");
		
		//合同信息检索
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(
				Integer.parseInt(dto.getIgasm0406Form().getEiid()));
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","合同");
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
		
		//正向关联关系检索
		SOC0119SearchCondImpl parcond = new SOC0119SearchCondImpl();
		if(dto.getIgasm0406Form().getEiid()!=null){
		parcond.setPareiid(Integer.parseInt(dto.getIgasm0406Form().getEiid()));}
		parcond.setParversion(entityItemVWInfo.getEiversion());
		parcond.setParsmallversion(entityItemVWInfo.getEismallversion());
		parcond.setDeleteflag("0");
		
		Map<String,List<SOC0119Info>> parmap = new LinkedHashMap<String,List<SOC0119Info>>();
		//判断登陆用户是否有查看该资产配置信息的权限
		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(), entityItemVWInfo);

		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}else{
			dto.setFlag(flag);
		}
		//合同关系信息查询件数取得 
		int totalCount = this.soc0119BL.getEntityItemRelationSearchCount(parcond);
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========合同关系信息查询数据件数过多========");
			//合同关系信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		if ( totalCount>0 ) {
			//合同关系信息全件检索
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
		
		//逆向关联关系检索
		//关联关系检索
		SOC0119SearchCondImpl cldcond = new SOC0119SearchCondImpl();
		if((dto.getIgasm0406Form().getEiid())!=null){
		cldcond.setCldeiid(Integer.parseInt(dto.getIgasm0406Form().getEiid()));}
		cldcond.setCldversion(entityItemVWInfo.getEiversion());
		cldcond.setCldsmallversion(entityItemVWInfo.getEismallversion());
		cldcond.setDeleteflag("0");
		
		//合同关系信息查询件数取得 
		totalCount = this.soc0119BL.getEntityItemRelationSearchCount(cldcond);
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========合同关系信息查询数据件数过多========");
			//合同关系信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//合同关系信息全件检索
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

		
		log.debug("========合同关系管理画面初期化处理终了========");
		return dto;
	}
	
	/**
	 * 合同关系删除处理
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO deleteEntityItemRelationAction(IGASM04DTO dto) throws BLException {
		log.debug("========合同关系删除处理开始========");
		
		for( int i=0;i<dto.getDeleteEntityItemRelation().length;i++ ){
			String eirid = dto.getDeleteEntityItemRelation()[i];
			
			SOC0119Info entityItemRelation = 
				this.soc0119BL.searchEntityItemRelationByKey(Integer.parseInt(eirid));
			
			if (entityItemRelation == null){
				throw new BLException("IGCO10000.E004","删除对象合同关系");
			}

			this.soc0119BL.deleteEntityItemRelation(entityItemRelation);
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I006","合同关系信息"));

		log.debug("========合同关系删除处理终了========");
		return dto;
	}

	/**
	 * 合同关系登记处理
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO insertEntityItemRelationAction(IGASM04DTO dto) throws BLException {
		log.debug("========合同关系登记处理开始========");
		
		IGASM0407Form form = dto.getIgasm0407Form();
		
		//合同ID（子）取得
		SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
		
		cond.setElabel(form.getElabel());
		cond.setEilabel(form.getEilabel());
		
		List<SOC0124Info> entityItemVWList = this.soc0118BL.searchEntityItemVW(cond, 0, 0);
		
		if ( entityItemVWList==null || entityItemVWList.size() == 0 ) {
			throw new BLException("IGCO10000.E004","(资产编号=" + form.getElabel() + ",合同编号=" 
					+ form.getEilabel() + ")合同");
		}
		
		form.setCldeiid(entityItemVWList.get(0).getEiid());
		form.setCldeid(entityItemVWList.get(0).getEid());
		form.setCldsmallversion(entityItemVWList.get(0).getEismallversion());
		form.setCldversion(entityItemVWList.get(0).getEiversion());
		
		//合同ID（父）和（子）检测
		if (form.getPareiid().intValue() == form.getCldeiid().intValue()) {
			//合同ID（父）= （子）
			throw new BLException(BLErrorType.ENTITY_ITEM_RELATION_ERROR,
					"IGCO10000.E012","合同");
		}
		
		//更新时间设定
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

		form.setEirupdtime(datetime);
		
		//资产关系登记
		SOC0119Info ret = 
			this.soc0119BL.registEntityItemRelation(dto.getIgasm0407Form());
		
		dto.setEntityItemRelation(ret);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "合同关系信息") );
		
		log.debug("========合同关系登记处理终了========");
		return dto;
	}
	
	/**
	 * 合同关系编辑画面初期化处理
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO initIGASM0407Action(IGASM04DTO dto) throws BLException {
		log.debug("========合同关系编辑画面初期化处理开始========");
		
		IGASM0407Form form = dto.getIgasm0407Form();
		SOC0119TB ret = 		
			(SOC0119TB) this.soc0119BL.searchEntityItemRelationByKey(
				form.getEirid());
		
		if ( ret == null ){
			throw new BLException("IGCO10000.E004","编辑对象合同关系");
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
		
		log.debug("========合同关系编辑画面初期化处理终了========");
		return dto;
	}

	/**
	 * 合同关系变更处理处理
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO updateEntityItemRelationAction(IGASM04DTO dto) throws BLException {
		log.debug("========合同关系变更处理处理开始========");
		IGASM0407Form form = dto.getIgasm0407Form();

		//更新时间设定
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

		form.setEirupdtime(datetime);
		
		this.soc0119BL.updateEntityItemRelation(form);

		dto.addMessage(new ActionMessage( "IGCO10000.I005", "合同关系信息") );

		log.debug("========合同关系变更处理处理终了========");
		return dto;
	}
	
	/**
	 *	获取合同关联关系处理
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO searchRelationListAction(IGASM04DTO dto) throws BLException {
		log.debug("========获取合同关联关系处理开始========");
		List<LabelValueBean> list = this.codeDetailBL.searchLabelValueBeanList(CommonDefineUtils.ENTIY_CATEGORY_CONTRACT,CodeDefine.getCodeDefine("ENTITY_ITEM_RELATION_CODE").getCcid());
		dto.setRelationList(list);
		log.debug("========获取合同关联关系处理终了========");
		return dto;
	}
	
	/**
	 *合同信息修改初期显示处理
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO initEntityItem(IGASM04DTO dto) throws BLException {

		log.debug("========合同信息编辑画面初期显示处理开始========");
		
		IGASM0412Form form = dto.getIgasm0412Form();
		
		//显示用资产信息取得
		SOC0124Info entityItem = this.soc0118BL.searchEntityItemVWByKey(form.getEiid());
		
		if ( entityItem == null ){
			throw new BLException("IGCO10000.E004","变更合同基本");
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
		boolean isRoleManager = this.userRoleBL.checkRoleManagerByType(dto.getUser().getUserid(), EntityCategory.ROLE_TYPE_CONTRACT);
		form.setRoleManager(isRoleManager);
		form.setPermission(permission);
		
		dto.setIgasm0412Form(form);
		
		//dto.addMessage(new ActionMessage("IGCO10000.I001","合同基本信息"));
		if(!permission) {
			dto.addMessage(new ActionMessage("IGCO10000.E023","修改"));
		}
		log.debug("========合同信息编辑画面初期显示处理终了========");
		return dto;
	}
	/**
	 *合同信息修改处理
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO updateEntityItem(IGASM04DTO dto) throws BLException {
		
		log.debug("========合同信息编辑画面初期显示处理开始========");
		
		IGASM0412Form form = dto.getIgasm0412Form();
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
		dto.addMessage(new ActionMessage("IGCO10000.I005","合同基本信息"));
		log.debug("========合同信息编辑画面初期显示处理终了========");
		return dto;
	}
	
	/**
	 * 获取合同编号最大值
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO searchEntityItemLableAction(IGASM04DTO dto) throws BLException {
		
		log.debug("========获取合同编号最大值处理开始========");
		
//		IGASM0402Form form = dto.getIgasm0402Form();
//		
//		SOC0118SearchCondImpl cond = new SOC0118SearchCondImpl();
//		
//		cond.setEilabel(CommonDefineUtils.ENTIY_CATEGORY_CONTRACT_KEY + IGStringUtils.getCurrentYear().substring(2));
//		
//		String eilabel = this.soc0118BL.searchNextEntityItemLable(cond);
//		
//		form.setEilabel(eilabel);
		
		log.debug("========获取合同编号最大值处理终了========");
		return dto;
	}
	
	/**
	 * 判断登陆用户是否是合同资产管理角色负责人
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
				throw new BLException("IGCO10000.E004","顶级机构");
			} else {
				dto.setOrgname(org.get(0).getOrgname());
				dto.setOrgsyscoding(org.get(0).getOrgsyscoding());
			}
			SOC0117SearchCondImpl entityCond = new SOC0117SearchCondImpl();
			entityCond.setEsyscoding(CommonDefineUtils.ENTIY_CATEGORY_CONTRACT_SYSCODING);
			List<SOC0117Info> entity = this.soc0117BL.searchEntity(entityCond, 0, 0);
			
			if(entity.size() != 1) {
				throw new BLException("IGCO10000.E004","合同模型");
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
	 * 应付款登记查询处理(对应应付款登记查询)
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO searchEntityItemCompactVWAction(IGASM04DTO dto) throws BLException {
		log.debug("========合同应付款查询开始========");
		
		//合同信息查询件数取得 
		//int totalCount = this.ig499BL.getSearchCount(dto.getEntityItemCompactVWSearchCond());
		
//		if (totalCount == 0) {
//			log.debug("========合同应付款查询数据不存在========");
//			//合同信息查询数据不存在
//			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
//			return dto;
//		} 
//		
//		if ( totalCount > dto.getMaxSearchCount() ) {
//			log.debug("========合同应付款查询数据件数过多========");
//			//合同信息查询数据件数过多
//			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
//			return dto;
//		}

		//分页用信息取得
		PagingDTO pDto = dto.getPagingDto();

		//所有合同信息取得
		List<IG499Info> entityItemCompactVWInfoListA = this.ig499BL.searchIG499Info(dto.getEntityItemCompactVWSearchCond());
		
		//合同付款未完成的信息取得
		List<IG499Info> entityItemCompactVWInfoListB=new ArrayList<IG499Info>();
		for (IG499Info entityItemCompactVWInfo : entityItemCompactVWInfoListA) {
			if(entityItemCompactVWInfo.getEiversion()!=0){
				entityItemCompactVWInfoListB.add(entityItemCompactVWInfo);
			}
		}
		int totalCount=entityItemCompactVWInfoListB.size();
		if (totalCount == 0) {
			log.debug("========合同应付款查询数据不存在========");
			//合同信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========合同应付款查询数据件数过多========");
			//合同信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		
		//当前页合同信息取得
		List<IG499Info> entityItemCompactVWInfoList=new ArrayList<IG499Info>();
		int fromCount = pDto.getFromCount();
		int pageDispCount = pDto.getPageDispCount();
		for (int i = fromCount; i < entityItemCompactVWInfoListB.size()&&i<fromCount+pageDispCount; i++) {
			entityItemCompactVWInfoList.add(entityItemCompactVWInfoListB.get(i));
		}
		
		pDto.setTotalCount(totalCount);
		
		dto.setEntityItemCompactVWInfoList(entityItemCompactVWInfoList);

		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========合同应付款查询终了========");
		return dto;
	}
	/**
	 * 应付款登记查询处理2(对应应付款查询)
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO searchEntityItemCompactVW2Action(IGASM04DTO dto) throws BLException {
		log.debug("========合同应付款查询开始========");
		
		//强制默认时间点防止NULL值报错
		if(dto.getEntityItemCompactVWSearchCond().getDatetime()==null){
			//建立新查询条件
			IG499SearchCondImpl newcond=new IG499SearchCondImpl();
			//加入现在日期
			newcond.setDatetime(IGStringUtils.getCurrentDate());
			//放入dto
			dto.setEntityItemCompactVWSearchCond(newcond);
		}

		//分页用信息取得
		PagingDTO pDto = dto.getPagingDto();

		//当前页合同信息取得
		List<IG499Info> entityItemCompactVWInfoList = this.ig499BL.findImprestByCond(dto.getEntityItemCompactVWSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		
		//合同信息查询件数取得 
		//int totalCount = this.ig499BL.getSearchImprestCount(dto.getEntityItemCompactVWSearchCond());
		//合同信息查询件数通过list取得
		int totalCount = entityItemCompactVWInfoList.size();
		
		if (totalCount == 0) {
			log.debug("========合同应付款查询数据不存在========");
			//合同信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========合同应付款查询数据件数过多========");
			//合同信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		
		pDto.setTotalCount(totalCount);
		
		dto.setEntityItemCompactVWInfoList(entityItemCompactVWInfoList);

		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========合同应付款查询终了========");
		return dto;
	}


	/**
	 * 合同付款导出处理
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGASM04DTO intiIGASM0422Action(IGASM04DTO dto) throws BLException {
		//根据条件检索出报表内容
		List<IG499Info> entityItemCompactVWInfoList = this.ig499BL.findImprestByCond(dto.getEntityItemCompactVWSearchCond(), 0, 0);
		//报表数据存入dto
		dto.setReportDataList(entityItemCompactVWInfoList);
		return dto;
	}

	/**
	 * 合同付款登记初期显示
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGASM04DTO initIGASM0421Action(IGASM04DTO dto) throws BLException {
		log.debug("========合同付款登记画面初期化处理开始========");
		//Form取得
		IGASM0421Form form = dto.getIgasm0421Form();
		//获取消息资源文件标识
		String image_flag = resources.getMessage("IMAGE_FLAG");
		
		IG499SearchCondImpl eCond=new IG499SearchCondImpl();
		eCond.setEiid(form.getEiid().toString());
		//合同信息检索
		List<IG499Info> entityItemCompactVWInfoList = this.ig499BL.searchIG499Info(eCond);
		
		if (entityItemCompactVWInfoList == null ) {
			throw new BLException("IGCO10000.E004","合同");
		}
		//合同机构层次码
		String eiorgsyscoding = entityItemCompactVWInfoList.get(0).getEiorgsyscoding();
		form.setEiorgsyscoding(eiorgsyscoding);
		form.setEsyscoding_q(entityItemCompactVWInfoList.get(0).getEsyscoding());
		//机构层次码
		if(!StringUtils.isEmpty(eiorgsyscoding)){
			OrganizationSearchCondImpl OrgCond = new OrganizationSearchCondImpl();
			OrgCond.setOrgsyscoding(eiorgsyscoding);
			//根据机构层次码查询
			List<Organization> orgList = this.organizationBL.searchOrganization(OrgCond, 0, 0);
			for (int i = 0; i < orgList.size(); i++) {
				dto.setEiorgname(orgList.get(0).getOrgname());
			}
		}
		dto.setEntityItemCompactVWInfo(entityItemCompactVWInfoList.get(0));
		
		String facilitator = entityItemCompactVWInfoList.get(0).getFacilitator();//服务商信息
		if(StringUtils.isNotEmpty(facilitator)){
			Integer eiid = Integer.parseInt(facilitator.substring(facilitator.indexOf("(")+1, facilitator.length()-1));//服务商eiid
			
			SOC0119SearchCondImpl ig313cond=new SOC0119SearchCondImpl();
			ig313cond.setPareiid(Integer.parseInt(form.getEiid()));
			ig313cond.setCldeiid(eiid);
			ig313cond.setParversion(entityItemCompactVWInfoList.get(0).getEiversion());//合同版本
			List<SOC0119Info> ig313Info = soc0119BL.searchEntityItemRelation(ig313cond);
			if(ig313Info!=null&&ig313Info.size()>0){
				Integer cldversion = ig313Info.get(0).getCldversion();//服务商版本
				SOC0107SearchCondImpl cond=new SOC0107SearchCondImpl();
				cond.setEiid(String.valueOf(eiid));
				cond.setCiversion(String.valueOf(cldversion));
				List<SOC0107Info> ig800InfoList = soc0107BL.searchSOC0107(cond);
				for (SOC0107Info info : ig800InfoList) {
//					int cid = Integer.parseInt(info.getCid());
//					if(cid==1736){//开户行
//						dto.setKaihuhang(info.getCivalue());
//					}
//					if(cid==1737){//开户账号
//						dto.setKaihuzhanghao(info.getCivalue());
//					}
//					if(cid==1738){//开户名称
//						dto.setKaihumingcheng(info.getCivalue());
//					}
					String cid = info.getCid();
					if("CI040000000014".equals(cid)){//开户行
						dto.setKaihuhang(info.getCivalue());
					}
					if("CI040000000015".equals(cid)){//开户账号
						dto.setKaihuzhanghao(info.getCivalue());
					}
					if("CI040000000016".equals(cid)){//开户名称
						dto.setKaihumingcheng(info.getCivalue());
					}
				}
			}
		}
		
		//判断登陆用户是否有查看该资产配置信息的权限
//		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(), entityItemCompactVWInfoList.get(0));

//		if(!flag) {
//			dto.addMessage(new ActionMessage("IGCO10000.E022"));
//			dto.setFlag(flag);
//			return dto;
//		}else{
//			dto.setFlag(flag);
//		}
		
		
		//合同配置信息查询件数取得 
		int totalCount = this.soc0107BL.getConfigItemVWSearchCount(form);
		
		if (totalCount == 0) {
			log.debug("========合同付款信息查询数据不存在========");
			//合同配置信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I007",0));
			return dto;
		} 
		
		if (totalCount > dto.getMaxSearchCount() ) {
			log.debug("========合同配置信息查询数据件数过多========");
			//合同配置信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//合同配置信息全件查询
		List<SOC0129Info> configItemVWInfoList = this.soc0107BL.searchConfigItemVW(
				form, 0, 0);
		
		//如果存在合同配置信息
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
		
		//影响加密XML设定
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
		log.debug("========合同付款登记画面初期化处理终了========");
		return dto;
	}
	
	/**
	 * 获取合同付款信息
	 * @param configItemVWInfo
	 * @param form
	 */
	public void getCompactInfo(SOC0129Info configItemVWInfo,IGASM0421Form form){
		String civalue = configItemVWInfo.getCivalue();
		//第一笔付款额
		if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY1.equals(configItemVWInfo.getClabel())){
			form.setActualmoney1(configItemVWInfo.getCivalue());
			if(StringUtils.isEmpty(civalue)){
				form.setBtnFlag1(true);
			}
			//影像集成
			String eiid = configItemVWInfo.getEiid();
			String cid = configItemVWInfo.getCid();
			form.setContractId1(eiid+"_"+cid);
			String clabel = configItemVWInfo.getEilabel();
			form.setContractLabel1(clabel);
			String cname = configItemVWInfo.getCname();
			form.setContractName1(configItemVWInfo.getEiname()+"_"+cname);
		}
		//第一笔应付日
		if(CommonDefineUtils.ENTIY_COMPACT_EXPECTDAY1.equals(configItemVWInfo.getClabel())){
			form.setExpectday1(configItemVWInfo.getCivalue());
			if(StringUtils.isEmpty(civalue)){
				form.setBtnFlag1(true);
			}
		}
		//第一笔实付日
		if(CommonDefineUtils.ENTIY_COMPACT_ACTUALDAY1.equals(configItemVWInfo.getClabel())){
			form.setActualday1(configItemVWInfo.getCivalue());
			if(StringUtils.isEmpty(civalue)){
				form.setBtnFlag1(true);
			}
		}
		//发票说明
		if(CommonDefineUtils.ENTIY_COMPACT_INVOICEEXPLAIN1.equals(configItemVWInfo.getClabel())){
			form.setInvoiceexplain1(configItemVWInfo.getCivalue());
			form.setContractDesc1(configItemVWInfo.getCivalue());
		}
		//第二笔付款额
		if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY2.equals(configItemVWInfo.getClabel())){
			form.setActualmoney2(configItemVWInfo.getCivalue());
			if(StringUtils.isEmpty(civalue)){
				form.setBtnFlag2(true);
			}
			//影像集成
			String eiid = configItemVWInfo.getEiid();
			String cid = configItemVWInfo.getCid();
			form.setContractId2(eiid+"_"+cid);
			String clabel = configItemVWInfo.getEilabel();
			form.setContractLabel2(clabel);
			String cname = configItemVWInfo.getCname();
			form.setContractName2(configItemVWInfo.getEiname()+"_"+cname);
		}
		//第二笔应付日
		if(CommonDefineUtils.ENTIY_COMPACT_EXPECTDAY2.equals(configItemVWInfo.getClabel())){
			form.setExpectday2(configItemVWInfo.getCivalue());
			if(StringUtils.isEmpty(civalue)){
				form.setBtnFlag2(true);
			}
		}
		//第二笔实付日
		if(CommonDefineUtils.ENTIY_COMPACT_ACTUALDAY2.equals(configItemVWInfo.getClabel())){
			form.setActualday2(configItemVWInfo.getCivalue());
			if(StringUtils.isEmpty(civalue)){
				form.setBtnFlag2(true);
			}
		}
		//发票说明
		if(CommonDefineUtils.ENTIY_COMPACT_INVOICEEXPLAIN2.equals(configItemVWInfo.getClabel())){
			form.setInvoiceexplain2(configItemVWInfo.getCivalue());
			form.setContractDesc2(configItemVWInfo.getCivalue());
		}
		//第三笔付款额
		if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY3.equals(configItemVWInfo.getClabel())){
			form.setActualmoney3(configItemVWInfo.getCivalue());
			if(StringUtils.isEmpty(civalue)){
				form.setBtnFlag3(true);
			}
			//影像集成
			String eiid = configItemVWInfo.getEiid();
			String cid = configItemVWInfo.getCid();
			form.setContractId3(eiid+"_"+cid);
			String clabel = configItemVWInfo.getEilabel();
			form.setContractLabel3(clabel);
			String cname = configItemVWInfo.getCname();
			form.setContractName3(configItemVWInfo.getEiname()+"_"+cname);
		}
		//第三笔应付日
		if(CommonDefineUtils.ENTIY_COMPACT_EXPECTDAY3.equals(configItemVWInfo.getClabel())){
			form.setExpectday3(configItemVWInfo.getCivalue());
			if(StringUtils.isEmpty(civalue)){
				form.setBtnFlag3(true);
			}
		}
		//第三笔实付日
		if(CommonDefineUtils.ENTIY_COMPACT_ACTUALDAY3.equals(configItemVWInfo.getClabel())){
			form.setActualday3(configItemVWInfo.getCivalue());
			if(StringUtils.isEmpty(civalue)){
				form.setBtnFlag3(true);
			}
		}
		//发票说明
		if(CommonDefineUtils.ENTIY_COMPACT_INVOICEEXPLAIN3.equals(configItemVWInfo.getClabel())){
			form.setInvoiceexplain3(configItemVWInfo.getCivalue());
			form.setContractDesc3(configItemVWInfo.getCivalue());
		}
		//第四笔付款额
		if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY4.equals(configItemVWInfo.getClabel())){
			form.setActualmoney4(configItemVWInfo.getCivalue());
			if(StringUtils.isEmpty(civalue)){
				form.setBtnFlag4(true);
			}
			//影像集成
			String eiid = configItemVWInfo.getEiid();
			String cid = configItemVWInfo.getCid();
			form.setContractId4(eiid+"_"+cid);
			String clabel = configItemVWInfo.getEilabel();
			form.setContractLabel4(clabel);
			String cname = configItemVWInfo.getCname();
			form.setContractName4(configItemVWInfo.getEiname()+"_"+cname);
		}
		//第四笔应付日
		if(CommonDefineUtils.ENTIY_COMPACT_EXPECTDAY4.equals(configItemVWInfo.getClabel())){
			form.setExpectday4(configItemVWInfo.getCivalue());
			if(StringUtils.isEmpty(civalue)){
				form.setBtnFlag4(true);
			}
		}
		//第四笔实付日
		if(CommonDefineUtils.ENTIY_COMPACT_ACTUALDAY4.equals(configItemVWInfo.getClabel())){
			form.setActualday4(configItemVWInfo.getCivalue());
			if(StringUtils.isEmpty(civalue)){
				form.setBtnFlag4(true);
			}
		}
		//发票说明
		if(CommonDefineUtils.ENTIY_COMPACT_INVOICEEXPLAIN4.equals(configItemVWInfo.getClabel())){
			form.setInvoiceexplain4(configItemVWInfo.getCivalue());
			form.setContractDesc4(configItemVWInfo.getCivalue());
		}
		//第五笔付款额
		if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY5.equals(configItemVWInfo.getClabel())){
			form.setActualmoney5(configItemVWInfo.getCivalue());
			if(StringUtils.isEmpty(civalue)){
				form.setBtnFlag5(true);
			}
			//影像集成
			String eiid = configItemVWInfo.getEiid();
			String cid = configItemVWInfo.getCid();
			form.setContractId5(eiid+"_"+cid);
			String clabel = configItemVWInfo.getEilabel();
			form.setContractLabel5(clabel);
			String cname = configItemVWInfo.getCname();
			form.setContractName5(configItemVWInfo.getEiname()+"_"+cname);
		}
		//第五笔应付日
		if(CommonDefineUtils.ENTIY_COMPACT_EXPECTDAY5.equals(configItemVWInfo.getClabel())){
			form.setExpectday5(configItemVWInfo.getCivalue());
			if(StringUtils.isEmpty(civalue)){
				form.setBtnFlag5(true);
			}
		}
		//第五笔实付日
		if(CommonDefineUtils.ENTIY_COMPACT_ACTUALDAY5.equals(configItemVWInfo.getClabel())){
			form.setActualday5(configItemVWInfo.getCivalue());
			if(StringUtils.isEmpty(civalue)){
				form.setBtnFlag5(true);
			}
		}
		//发票说明
		if(CommonDefineUtils.ENTIY_COMPACT_INVOICEEXPLAIN5.equals(configItemVWInfo.getClabel())){
			form.setInvoiceexplain5(configItemVWInfo.getCivalue());
			form.setContractDesc5(configItemVWInfo.getCivalue());
		}
		
		////////////////////////////////////////////////////
		//第6笔付款额
        if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY6.equals(configItemVWInfo.getClabel())){
            form.setActualmoney6(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag6(true);
            }
            //影像集成
            String eiid = configItemVWInfo.getEiid();
            String cid = configItemVWInfo.getCid();
            form.setContractId6(eiid+"_"+cid);
            String clabel = configItemVWInfo.getEilabel();
            form.setContractLabel6(clabel);
            String cname = configItemVWInfo.getCname();
            form.setContractName6(configItemVWInfo.getEiname()+"_"+cname);
        }
        //第6笔应付日
        if(CommonDefineUtils.ENTIY_COMPACT_EXPECTDAY6.equals(configItemVWInfo.getClabel())){
            form.setExpectday6(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag6(true);
            }
        }
        //第6笔实付日
        if(CommonDefineUtils.ENTIY_COMPACT_ACTUALDAY6.equals(configItemVWInfo.getClabel())){
            form.setActualday6(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag6(true);
            }
        }
        //发票说明
        if(CommonDefineUtils.ENTIY_COMPACT_INVOICEEXPLAIN6.equals(configItemVWInfo.getClabel())){
            form.setInvoiceexplain6(configItemVWInfo.getCivalue());
            form.setContractDesc6(configItemVWInfo.getCivalue());
        }
        
      //第7笔付款额
        if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY7.equals(configItemVWInfo.getClabel())){
            form.setActualmoney7(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag7(true);
            }
            //影像集成
            String eiid = configItemVWInfo.getEiid();
            String cid = configItemVWInfo.getCid();
            form.setContractId7(eiid+"_"+cid);
            String clabel = configItemVWInfo.getEilabel();
            form.setContractLabel7(clabel);
            String cname = configItemVWInfo.getCname();
            form.setContractName7(configItemVWInfo.getEiname()+"_"+cname);
        }
        //第7笔应付日
        if(CommonDefineUtils.ENTIY_COMPACT_EXPECTDAY7.equals(configItemVWInfo.getClabel())){
            form.setExpectday7(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag7(true);
            }
        }
        //第7笔实付日
        if(CommonDefineUtils.ENTIY_COMPACT_ACTUALDAY7.equals(configItemVWInfo.getClabel())){
            form.setActualday7(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag7(true);
            }
        }
        //发票说明
        if(CommonDefineUtils.ENTIY_COMPACT_INVOICEEXPLAIN7.equals(configItemVWInfo.getClabel())){
            form.setInvoiceexplain7(configItemVWInfo.getCivalue());
            form.setContractDesc7(configItemVWInfo.getCivalue());
        }
        
      //第8笔付款额
        if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY8.equals(configItemVWInfo.getClabel())){
            form.setActualmoney8(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag8(true);
            }
            //影像集成
            String eiid = configItemVWInfo.getEiid();
            String cid = configItemVWInfo.getCid();
            form.setContractId8(eiid+"_"+cid);
            String clabel = configItemVWInfo.getEilabel();
            form.setContractLabel8(clabel);
            String cname = configItemVWInfo.getCname();
            form.setContractName8(configItemVWInfo.getEiname()+"_"+cname);
        }
        //第8笔应付日
        if(CommonDefineUtils.ENTIY_COMPACT_EXPECTDAY8.equals(configItemVWInfo.getClabel())){
            form.setExpectday8(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag8(true);
            }
        }
        //第8笔实付日
        if(CommonDefineUtils.ENTIY_COMPACT_ACTUALDAY8.equals(configItemVWInfo.getClabel())){
            form.setActualday8(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag8(true);
            }
        }
        //发票说明
        if(CommonDefineUtils.ENTIY_COMPACT_INVOICEEXPLAIN8.equals(configItemVWInfo.getClabel())){
            form.setInvoiceexplain8(configItemVWInfo.getCivalue());
            form.setContractDesc8(configItemVWInfo.getCivalue());
        }
        
      //第9笔付款额
        if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY9.equals(configItemVWInfo.getClabel())){
            form.setActualmoney9(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag9(true);
            }
            //影像集成
            String eiid = configItemVWInfo.getEiid();
            String cid = configItemVWInfo.getCid();
            form.setContractId9(eiid+"_"+cid);
            String clabel = configItemVWInfo.getEilabel();
            form.setContractLabel9(clabel);
            String cname = configItemVWInfo.getCname();
            form.setContractName9(configItemVWInfo.getEiname()+"_"+cname);
        }
        //第9笔应付日
        if(CommonDefineUtils.ENTIY_COMPACT_EXPECTDAY9.equals(configItemVWInfo.getClabel())){
            form.setExpectday9(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag9(true);
            }
        }
        //第9笔实付日
        if(CommonDefineUtils.ENTIY_COMPACT_ACTUALDAY9.equals(configItemVWInfo.getClabel())){
            form.setActualday9(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag9(true);
            }
        }
        //发票说明
        if(CommonDefineUtils.ENTIY_COMPACT_INVOICEEXPLAIN9.equals(configItemVWInfo.getClabel())){
            form.setInvoiceexplain9(configItemVWInfo.getCivalue());
            form.setContractDesc9(configItemVWInfo.getCivalue());
        }
        
      //第10笔付款额
        if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY10.equals(configItemVWInfo.getClabel())){
            form.setActualmoney10(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag10(true);
            }
            //影像集成
            String eiid = configItemVWInfo.getEiid();
            String cid = configItemVWInfo.getCid();
            form.setContractId10(eiid+"_"+cid);
            String clabel = configItemVWInfo.getEilabel();
            form.setContractLabel10(clabel);
            String cname = configItemVWInfo.getCname();
            form.setContractName10(configItemVWInfo.getEiname()+"_"+cname);
        }
        //第10笔应付日
        if(CommonDefineUtils.ENTIY_COMPACT_EXPECTDAY10.equals(configItemVWInfo.getClabel())){
            form.setExpectday10(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag10(true);
            }
        }
        //第10笔实付日
        if(CommonDefineUtils.ENTIY_COMPACT_ACTUALDAY10.equals(configItemVWInfo.getClabel())){
            form.setActualday10(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag10(true);
            }
        }
        //发票说明
        if(CommonDefineUtils.ENTIY_COMPACT_INVOICEEXPLAIN10.equals(configItemVWInfo.getClabel())){
            form.setInvoiceexplain10(configItemVWInfo.getCivalue());
            form.setContractDesc10(configItemVWInfo.getCivalue());
        }
        
      //第11笔付款额
        if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY11.equals(configItemVWInfo.getClabel())){
            form.setActualmoney11(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag11(true);
            }
            //影像集成
            String eiid = configItemVWInfo.getEiid();
            String cid = configItemVWInfo.getCid();
            form.setContractId11(eiid+"_"+cid);
            String clabel = configItemVWInfo.getEilabel();
            form.setContractLabel11(clabel);
            String cname = configItemVWInfo.getCname();
            form.setContractName11(configItemVWInfo.getEiname()+"_"+cname);
        }
        //第11笔应付日
        if(CommonDefineUtils.ENTIY_COMPACT_EXPECTDAY11.equals(configItemVWInfo.getClabel())){
            form.setExpectday11(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag11(true);
            }
        }
        //第11笔实付日
        if(CommonDefineUtils.ENTIY_COMPACT_ACTUALDAY11.equals(configItemVWInfo.getClabel())){
            form.setActualday11(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag11(true);
            }
        }
        //发票说明
        if(CommonDefineUtils.ENTIY_COMPACT_INVOICEEXPLAIN11.equals(configItemVWInfo.getClabel())){
            form.setInvoiceexplain11(configItemVWInfo.getCivalue());
            form.setContractDesc11(configItemVWInfo.getCivalue());
        }
        
      //第12笔付款额
        if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY12.equals(configItemVWInfo.getClabel())){
            form.setActualmoney12(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag12(true);
            }
            //影像集成
            String eiid = configItemVWInfo.getEiid();
            String cid = configItemVWInfo.getCid();
            form.setContractId12(eiid+"_"+cid);
            String clabel = configItemVWInfo.getEilabel();
            form.setContractLabel12(clabel);
            String cname = configItemVWInfo.getCname();
            form.setContractName12(configItemVWInfo.getEiname()+"_"+cname);
        }
        //第12笔应付日
        if(CommonDefineUtils.ENTIY_COMPACT_EXPECTDAY12.equals(configItemVWInfo.getClabel())){
            form.setExpectday12(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag12(true);
            }
        }
        //第12笔实付日
        if(CommonDefineUtils.ENTIY_COMPACT_ACTUALDAY12.equals(configItemVWInfo.getClabel())){
            form.setActualday12(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag12(true);
            }
        }
        //发票说明
        if(CommonDefineUtils.ENTIY_COMPACT_INVOICEEXPLAIN12.equals(configItemVWInfo.getClabel())){
            form.setInvoiceexplain12(configItemVWInfo.getCivalue());
            form.setContractDesc12(configItemVWInfo.getCivalue());
        }
        
      //第13笔付款额
        if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY13.equals(configItemVWInfo.getClabel())){
            form.setActualmoney13(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag13(true);
            }
            //影像集成
            String eiid = configItemVWInfo.getEiid();
            String cid = configItemVWInfo.getCid();
            form.setContractId13(eiid+"_"+cid);
            String clabel = configItemVWInfo.getEilabel();
            form.setContractLabel13(clabel);
            String cname = configItemVWInfo.getCname();
            form.setContractName13(configItemVWInfo.getEiname()+"_"+cname);
        }
        //第13笔应付日
        if(CommonDefineUtils.ENTIY_COMPACT_EXPECTDAY13.equals(configItemVWInfo.getClabel())){
            form.setExpectday13(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag13(true);
            }
        }
        //第13笔实付日
        if(CommonDefineUtils.ENTIY_COMPACT_ACTUALDAY13.equals(configItemVWInfo.getClabel())){
            form.setActualday13(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag13(true);
            }
        }
        //发票说明
        if(CommonDefineUtils.ENTIY_COMPACT_INVOICEEXPLAIN13.equals(configItemVWInfo.getClabel())){
            form.setInvoiceexplain13(configItemVWInfo.getCivalue());
            form.setContractDesc13(configItemVWInfo.getCivalue());
        }
        
      //第14笔付款额
        if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY14.equals(configItemVWInfo.getClabel())){
            form.setActualmoney14(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag14(true);
            }
            //影像集成
            String eiid = configItemVWInfo.getEiid();
            String cid = configItemVWInfo.getCid();
            form.setContractId14(eiid+"_"+cid);
            String clabel = configItemVWInfo.getEilabel();
            form.setContractLabel14(clabel);
            String cname = configItemVWInfo.getCname();
            form.setContractName14(configItemVWInfo.getEiname()+"_"+cname);
        }
        //第14笔应付日
        if(CommonDefineUtils.ENTIY_COMPACT_EXPECTDAY14.equals(configItemVWInfo.getClabel())){
            form.setExpectday14(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag14(true);
            }
        }
        //第14笔实付日
        if(CommonDefineUtils.ENTIY_COMPACT_ACTUALDAY14.equals(configItemVWInfo.getClabel())){
            form.setActualday14(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag14(true);
            }
        }
        //发票说明
        if(CommonDefineUtils.ENTIY_COMPACT_INVOICEEXPLAIN14.equals(configItemVWInfo.getClabel())){
            form.setInvoiceexplain14(configItemVWInfo.getCivalue());
            form.setContractDesc14(configItemVWInfo.getCivalue());
        }
        
      //第15笔付款额
        if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY15.equals(configItemVWInfo.getClabel())){
            form.setActualmoney15(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag15(true);
            }
            //影像集成
            String eiid = configItemVWInfo.getEiid();
            String cid = configItemVWInfo.getCid();
            form.setContractId15(eiid+"_"+cid);
            String clabel = configItemVWInfo.getEilabel();
            form.setContractLabel15(clabel);
            String cname = configItemVWInfo.getCname();
            form.setContractName15(configItemVWInfo.getEiname()+"_"+cname);
        }
        //第15笔应付日
        if(CommonDefineUtils.ENTIY_COMPACT_EXPECTDAY15.equals(configItemVWInfo.getClabel())){
            form.setExpectday15(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag15(true);
            }
        }
        //第15笔实付日
        if(CommonDefineUtils.ENTIY_COMPACT_ACTUALDAY15.equals(configItemVWInfo.getClabel())){
            form.setActualday15(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag15(true);
            }
        }
        //发票说明
        if(CommonDefineUtils.ENTIY_COMPACT_INVOICEEXPLAIN15.equals(configItemVWInfo.getClabel())){
            form.setInvoiceexplain15(configItemVWInfo.getCivalue());
            form.setContractDesc15(configItemVWInfo.getCivalue());
        }
        
        /////////////////////////////////////////////////////////////////
		//第一笔制单日
		if(CommonDefineUtils.ENTIY_COMPACT_ZHIDANDAY1.equals(configItemVWInfo.getClabel())){
			form.setZhidanday1(configItemVWInfo.getCivalue());
			if(StringUtils.isEmpty(civalue)){
				form.setBtnFlag1(true);
			}
		}
		//第一笔应付款比例
		if(CommonDefineUtils.ENTIY_COMPACT_YINGFUMONEYRATIO1.equals(configItemVWInfo.getClabel())){
			form.setYingfumoneyratio1(configItemVWInfo.getCivalue());
			if(StringUtils.isEmpty(civalue)){
				form.setBtnFlag1(true);
			}
		}
		//第一笔实付款额
		if(CommonDefineUtils.ENTIY_COMPACT_SHIFUMONEY1.equals(configItemVWInfo.getClabel())){
			form.setShifumoney1(configItemVWInfo.getCivalue());
			if(StringUtils.isEmpty(civalue)){
				form.setBtnFlag1(true);
			}
		}
		
		//第二笔制单日
		if(CommonDefineUtils.ENTIY_COMPACT_ZHIDANDAY2.equals(configItemVWInfo.getClabel())){
			form.setZhidanday2(configItemVWInfo.getCivalue());
			if(StringUtils.isEmpty(civalue)){
				form.setBtnFlag2(true);
			}
		}
		//第二笔应付款比例
		if(CommonDefineUtils.ENTIY_COMPACT_YINGFUMONEYRATIO2.equals(configItemVWInfo.getClabel())){
			form.setYingfumoneyratio2(configItemVWInfo.getCivalue());
			if(StringUtils.isEmpty(civalue)){
				form.setBtnFlag2(true);
			}
		}
		//第二笔实付款额
		if(CommonDefineUtils.ENTIY_COMPACT_SHIFUMONEY2.equals(configItemVWInfo.getClabel())){
			form.setShifumoney2(configItemVWInfo.getCivalue());
			if(StringUtils.isEmpty(civalue)){
				form.setBtnFlag2(true);
			}
		}
		
		//第三笔制单日
		if(CommonDefineUtils.ENTIY_COMPACT_ZHIDANDAY3.equals(configItemVWInfo.getClabel())){
			form.setZhidanday3(configItemVWInfo.getCivalue());
			if(StringUtils.isEmpty(civalue)){
				form.setBtnFlag3(true);
			}
		}
		//第三笔应付款比例
		if(CommonDefineUtils.ENTIY_COMPACT_YINGFUMONEYRATIO3.equals(configItemVWInfo.getClabel())){
			form.setYingfumoneyratio3(configItemVWInfo.getCivalue());
			if(StringUtils.isEmpty(civalue)){
				form.setBtnFlag3(true);
			}
		}
		//第三笔实付款额
		if(CommonDefineUtils.ENTIY_COMPACT_SHIFUMONEY3.equals(configItemVWInfo.getClabel())){
			form.setShifumoney3(configItemVWInfo.getCivalue());
			if(StringUtils.isEmpty(civalue)){
				form.setBtnFlag3(true);
			}
		}
		
		//第四笔制单日
		if(CommonDefineUtils.ENTIY_COMPACT_ZHIDANDAY4.equals(configItemVWInfo.getClabel())){
			form.setZhidanday4(configItemVWInfo.getCivalue());
			if(StringUtils.isEmpty(civalue)){
				form.setBtnFlag4(true);
			}
		}
		//第四笔应付款比例
		if(CommonDefineUtils.ENTIY_COMPACT_YINGFUMONEYRATIO4.equals(configItemVWInfo.getClabel())){
			form.setYingfumoneyratio4(configItemVWInfo.getCivalue());
			if(StringUtils.isEmpty(civalue)){
				form.setBtnFlag4(true);
			}
		}
		//第四笔实付款额
		if(CommonDefineUtils.ENTIY_COMPACT_SHIFUMONEY4.equals(configItemVWInfo.getClabel())){
			form.setShifumoney4(configItemVWInfo.getCivalue());
			if(StringUtils.isEmpty(civalue)){
				form.setBtnFlag4(true);
			}
		}
		
		//第五笔制单日
		if(CommonDefineUtils.ENTIY_COMPACT_ZHIDANDAY5.equals(configItemVWInfo.getClabel())){
			form.setZhidanday5(configItemVWInfo.getCivalue());
			if(StringUtils.isEmpty(civalue)){
				form.setBtnFlag5(true);
			}
		}
		//第五笔应付款比例
		if(CommonDefineUtils.ENTIY_COMPACT_YINGFUMONEYRATIO5.equals(configItemVWInfo.getClabel())){
			form.setYingfumoneyratio5(configItemVWInfo.getCivalue());
			if(StringUtils.isEmpty(civalue)){
				form.setBtnFlag5(true);
			}
		}
		//第五笔实付款额
		if(CommonDefineUtils.ENTIY_COMPACT_SHIFUMONEY5.equals(configItemVWInfo.getClabel())){
			form.setShifumoney5(configItemVWInfo.getCivalue());
			if(StringUtils.isEmpty(civalue)){
				form.setBtnFlag5(true);
			}
		}
		
		//////////////////////////////////////////////////////
		//第6笔制单日
        if(CommonDefineUtils.ENTIY_COMPACT_ZHIDANDAY6.equals(configItemVWInfo.getClabel())){
            form.setZhidanday6(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag6(true);
            }
        }
        //第6笔应付款比例
        if(CommonDefineUtils.ENTIY_COMPACT_YINGFUMONEYRATIO6.equals(configItemVWInfo.getClabel())){
            form.setYingfumoneyratio6(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag6(true);
            }
        }
        //第6笔实付款额
        if(CommonDefineUtils.ENTIY_COMPACT_SHIFUMONEY6.equals(configItemVWInfo.getClabel())){
            form.setShifumoney6(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag6(true);
            }
        }
        
      //第7笔制单日
        if(CommonDefineUtils.ENTIY_COMPACT_ZHIDANDAY7.equals(configItemVWInfo.getClabel())){
            form.setZhidanday7(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag7(true);
            }
        }
        //第7笔应付款比例
        if(CommonDefineUtils.ENTIY_COMPACT_YINGFUMONEYRATIO7.equals(configItemVWInfo.getClabel())){
            form.setYingfumoneyratio7(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag7(true);
            }
        }
        //第7笔实付款额
        if(CommonDefineUtils.ENTIY_COMPACT_SHIFUMONEY7.equals(configItemVWInfo.getClabel())){
            form.setShifumoney7(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag7(true);
            }
        }
        
      //第8笔制单日
        if(CommonDefineUtils.ENTIY_COMPACT_ZHIDANDAY8.equals(configItemVWInfo.getClabel())){
            form.setZhidanday8(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag8(true);
            }
        }
        //第8笔应付款比例
        if(CommonDefineUtils.ENTIY_COMPACT_YINGFUMONEYRATIO8.equals(configItemVWInfo.getClabel())){
            form.setYingfumoneyratio8(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag8(true);
            }
        }
        //第8笔实付款额
        if(CommonDefineUtils.ENTIY_COMPACT_SHIFUMONEY8.equals(configItemVWInfo.getClabel())){
            form.setShifumoney8(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag8(true);
            }
        }
        
      //第9笔制单日
        if(CommonDefineUtils.ENTIY_COMPACT_ZHIDANDAY9.equals(configItemVWInfo.getClabel())){
            form.setZhidanday9(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag9(true);
            }
        }
        //第9笔应付款比例
        if(CommonDefineUtils.ENTIY_COMPACT_YINGFUMONEYRATIO9.equals(configItemVWInfo.getClabel())){
            form.setYingfumoneyratio9(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag9(true);
            }
        }
        //第9笔实付款额
        if(CommonDefineUtils.ENTIY_COMPACT_SHIFUMONEY9.equals(configItemVWInfo.getClabel())){
            form.setShifumoney9(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag9(true);
            }
        }
        
      //第10笔制单日
        if(CommonDefineUtils.ENTIY_COMPACT_ZHIDANDAY10.equals(configItemVWInfo.getClabel())){
            form.setZhidanday10(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag10(true);
            }
        }
        //第10笔应付款比例
        if(CommonDefineUtils.ENTIY_COMPACT_YINGFUMONEYRATIO10.equals(configItemVWInfo.getClabel())){
            form.setYingfumoneyratio10(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag10(true);
            }
        }
        //第10笔实付款额
        if(CommonDefineUtils.ENTIY_COMPACT_SHIFUMONEY10.equals(configItemVWInfo.getClabel())){
            form.setShifumoney10(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag10(true);
            }
        }
        
      //第11笔制单日
        if(CommonDefineUtils.ENTIY_COMPACT_ZHIDANDAY11.equals(configItemVWInfo.getClabel())){
            form.setZhidanday11(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag11(true);
            }
        }
        //第11笔应付款比例
        if(CommonDefineUtils.ENTIY_COMPACT_YINGFUMONEYRATIO11.equals(configItemVWInfo.getClabel())){
            form.setYingfumoneyratio11(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag11(true);
            }
        }
        //第11笔实付款额
        if(CommonDefineUtils.ENTIY_COMPACT_SHIFUMONEY11.equals(configItemVWInfo.getClabel())){
            form.setShifumoney11(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag11(true);
            }
        }
        
      //第12笔制单日
        if(CommonDefineUtils.ENTIY_COMPACT_ZHIDANDAY12.equals(configItemVWInfo.getClabel())){
            form.setZhidanday12(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag12(true);
            }
        }
        //第12笔应付款比例
        if(CommonDefineUtils.ENTIY_COMPACT_YINGFUMONEYRATIO12.equals(configItemVWInfo.getClabel())){
            form.setYingfumoneyratio12(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag12(true);
            }
        }
        //第12笔实付款额
        if(CommonDefineUtils.ENTIY_COMPACT_SHIFUMONEY12.equals(configItemVWInfo.getClabel())){
            form.setShifumoney12(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag12(true);
            }
        }
        
      //第13笔制单日
        if(CommonDefineUtils.ENTIY_COMPACT_ZHIDANDAY13.equals(configItemVWInfo.getClabel())){
            form.setZhidanday13(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag13(true);
            }
        }
        //第13笔应付款比例
        if(CommonDefineUtils.ENTIY_COMPACT_YINGFUMONEYRATIO13.equals(configItemVWInfo.getClabel())){
            form.setYingfumoneyratio13(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag13(true);
            }
        }
        //第13笔实付款额
        if(CommonDefineUtils.ENTIY_COMPACT_SHIFUMONEY13.equals(configItemVWInfo.getClabel())){
            form.setShifumoney13(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag13(true);
            }
        }
        
      //第14笔制单日
        if(CommonDefineUtils.ENTIY_COMPACT_ZHIDANDAY14.equals(configItemVWInfo.getClabel())){
            form.setZhidanday14(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag14(true);
            }
        }
        //第14笔应付款比例
        if(CommonDefineUtils.ENTIY_COMPACT_YINGFUMONEYRATIO14.equals(configItemVWInfo.getClabel())){
            form.setYingfumoneyratio14(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag14(true);
            }
        }
        //第14笔实付款额
        if(CommonDefineUtils.ENTIY_COMPACT_SHIFUMONEY14.equals(configItemVWInfo.getClabel())){
            form.setShifumoney14(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag14(true);
            }
        }
        
      //第15笔制单日
        if(CommonDefineUtils.ENTIY_COMPACT_ZHIDANDAY15.equals(configItemVWInfo.getClabel())){
            form.setZhidanday15(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag15(true);
            }
        }
        //第15笔应付款比例
        if(CommonDefineUtils.ENTIY_COMPACT_YINGFUMONEYRATIO15.equals(configItemVWInfo.getClabel())){
            form.setYingfumoneyratio15(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag15(true);
            }
        }
        //第15笔实付款额
        if(CommonDefineUtils.ENTIY_COMPACT_SHIFUMONEY15.equals(configItemVWInfo.getClabel())){
            form.setShifumoney15(configItemVWInfo.getCivalue());
            if(StringUtils.isEmpty(civalue)){
                form.setBtnFlag15(true);
            }
        }
        
	}

	/**
	 * 合同付款登记处理
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGASM04DTO editIGASM0421Action(IGASM04DTO dto) throws BLException {
		log.debug("========合同付款信息编辑处理开始========");
		//版本号生成
		IGASM0421Form form = dto.getIgasm0421Form();
		
		int version = form.getEiversion() + 1;
		
		//合同基本信息更新
		SOC0118TB entityItem = (SOC0118TB)SerializationUtils.clone(this.soc0118BL.searchEntityItemByKey(Integer.parseInt(form.getEiid())));

		if(version - 1 != entityItem.getEiversion()) {
			throw new BLException("IGCO00000.E004");
		}
		String[] cldeiids=null;
		
		//资产关系信息版本升级处理
		this.soc0119BL.upgradeEntityItemRelationOne(entityItem.getEiid(), entityItem.getEiversion(), entityItem.getEismallversion(),
				version, 0,cldeiids);
		//合同版本
		entityItem.setEiversion(version);
		
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		
		//更新时间
		entityItem.setEiupdtime(datetime);
		
		//设置查询条件
		SOC0129SearchCondImpl cond=new SOC0129SearchCondImpl();
		cond.setEiid(form.getEiid());
		cond.setEsyscoding_q("999011");
		//根据查询条件检索合同付款信息
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
				//更新标识
                if((StringUtils.isEmpty(configItemVWInfo.getCivalue()) && StringUtils.isNotEmpty(configItemTB.getCivalue()))
                        || (StringUtils.isNotEmpty(configItemVWInfo.getCivalue()) && StringUtils.isEmpty(configItemTB.getCivalue()))
                        || (configItemVWInfo.getCivalue() != null && configItemTB.getCivalue() != null && !configItemVWInfo.getCivalue().equals(configItemTB.getCivalue()))) {
                    configItemTB.setCicurver("1");//变色
                } else {
                    configItemTB.setCicurver("0");
                }
                SOC0107Info info=this.soc0107BL.registSOC0107(configItemTB);
                //更新服务商关系
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
		dto.addMessage(new ActionMessage("IGCO10000.I005","合同付款信息"));
		
		log.debug("========合同付款信息编辑处理终了========");
		return dto;
	}

	/**
	 * 更新合同付款信息
	 * @param configItemTB
	 * @param form
	 * @return
	 */
	private SOC0107TB getCompactOneInfo(SOC0129Info configItemVWInfo, IGASM0421Form form,SOC0107TB configItemTB) {
		log.debug("========合同付款信息设置开始========");
		//第一笔付款额
		if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY1.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getActualmoney1());
		}
		//第一笔应付日
		else if(CommonDefineUtils.ENTIY_COMPACT_EXPECTDAY1.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getExpectday1());
		}
		//第一笔实付日
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
		//发票说明
		else if(CommonDefineUtils.ENTIY_COMPACT_INVOICEEXPLAIN1.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getInvoiceexplain1());
		}
		//第二笔付款额
		else if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY2.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getActualmoney2());
		}
		//第二笔应付日
		else if(CommonDefineUtils.ENTIY_COMPACT_EXPECTDAY2.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getExpectday2());
		}
		//第二笔实付日
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
		//发票说明
		else if(CommonDefineUtils.ENTIY_COMPACT_INVOICEEXPLAIN2.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getInvoiceexplain2());
		}
		//第三笔付款额
		else if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY3.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getActualmoney3());
		}
		//第三笔应付日
		else if(CommonDefineUtils.ENTIY_COMPACT_EXPECTDAY3.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getExpectday3());
		}
		//第三笔实付日
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
		//发票说明
		else if(CommonDefineUtils.ENTIY_COMPACT_INVOICEEXPLAIN3.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getInvoiceexplain3());
		}
		//第四笔付款额
		else if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY4.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getActualmoney4());
		}
		//第四笔应付日
		else if(CommonDefineUtils.ENTIY_COMPACT_EXPECTDAY4.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getExpectday4());
		}
		//第四笔实付日
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
		//发票说明
		else if(CommonDefineUtils.ENTIY_COMPACT_INVOICEEXPLAIN4.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getInvoiceexplain4());
		}
		//第五笔付款额
		else if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY5.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getActualmoney5());
		}
		//第五笔应付日
		else if(CommonDefineUtils.ENTIY_COMPACT_EXPECTDAY5.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getExpectday5());
		}
		//第五笔实付日
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
		//发票说明
		else if(CommonDefineUtils.ENTIY_COMPACT_INVOICEEXPLAIN5.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getInvoiceexplain5());
		}
		
		////////////////////////////////////////////////////////////////////
		//第6笔付款额
		else if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY6.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getActualmoney6());
		}
		//第6笔应付日
		else if(CommonDefineUtils.ENTIY_COMPACT_EXPECTDAY6.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getExpectday6());
		}
		//第6笔实付日
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
		//发票说明
		else if(CommonDefineUtils.ENTIY_COMPACT_INVOICEEXPLAIN6.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getInvoiceexplain6());
		}
		
		//第7笔付款额
		else if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY7.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getActualmoney7());
		}
		//第7笔应付日
		else if(CommonDefineUtils.ENTIY_COMPACT_EXPECTDAY7.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getExpectday7());
		}
		//第7笔实付日
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
		//发票说明
		else if(CommonDefineUtils.ENTIY_COMPACT_INVOICEEXPLAIN7.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getInvoiceexplain7());
		}
		
		//第8笔付款额
		else if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY8.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getActualmoney8());
		}
		//第8笔应付日
		else if(CommonDefineUtils.ENTIY_COMPACT_EXPECTDAY8.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getExpectday8());
		}
		//第8笔实付日
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
		//发票说明
		else if(CommonDefineUtils.ENTIY_COMPACT_INVOICEEXPLAIN8.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getInvoiceexplain8());
		}
		
		//第9笔付款额
		else if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY9.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getActualmoney9());
		}
		//第9笔应付日
		else if(CommonDefineUtils.ENTIY_COMPACT_EXPECTDAY9.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getExpectday9());
		}
		//第9笔实付日
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
		//发票说明
		else if(CommonDefineUtils.ENTIY_COMPACT_INVOICEEXPLAIN9.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getInvoiceexplain9());
		}
		
		//第10笔付款额
		else if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY10.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getActualmoney10());
		}
		//第10笔应付日
		else if(CommonDefineUtils.ENTIY_COMPACT_EXPECTDAY10.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getExpectday10());
		}
		//第10笔实付日
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
		//发票说明
		else if(CommonDefineUtils.ENTIY_COMPACT_INVOICEEXPLAIN10.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getInvoiceexplain10());
		}
		
		//第11笔付款额
		else if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY11.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getActualmoney11());
		}
		//第11笔应付日
		else if(CommonDefineUtils.ENTIY_COMPACT_EXPECTDAY11.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getExpectday11());
		}
		//第11笔实付日
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
		//发票说明
		else if(CommonDefineUtils.ENTIY_COMPACT_INVOICEEXPLAIN11.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getInvoiceexplain11());
		}
		
		//第12笔付款额
		else if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY12.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getActualmoney12());
		}
		//第12笔应付日
		else if(CommonDefineUtils.ENTIY_COMPACT_EXPECTDAY12.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getExpectday12());
		}
		//第12笔实付日
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
		//发票说明
		else if(CommonDefineUtils.ENTIY_COMPACT_INVOICEEXPLAIN12.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getInvoiceexplain12());
		}
		
		//第13笔付款额
		else if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY13.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getActualmoney13());
		}
		//第13笔应付日
		else if(CommonDefineUtils.ENTIY_COMPACT_EXPECTDAY13.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getExpectday13());
		}
		//第13笔实付日
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
		//发票说明
		else if(CommonDefineUtils.ENTIY_COMPACT_INVOICEEXPLAIN13.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getInvoiceexplain13());
		}
		
		//第14笔付款额
		else if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY14.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getActualmoney14());
		}
		//第14笔应付日
		else if(CommonDefineUtils.ENTIY_COMPACT_EXPECTDAY14.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getExpectday14());
		}
		//第14笔实付日
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
		//发票说明
		else if(CommonDefineUtils.ENTIY_COMPACT_INVOICEEXPLAIN14.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getInvoiceexplain14());
		}
		
		//第15笔付款额
		else if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY15.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getActualmoney15());
		}
		//第15笔应付日
		else if(CommonDefineUtils.ENTIY_COMPACT_EXPECTDAY15.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getExpectday15());
		}
		//第15笔实付日
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
		//发票说明
		else if(CommonDefineUtils.ENTIY_COMPACT_INVOICEEXPLAIN15.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getInvoiceexplain15());
		}
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////
		//已付款
		else if(CommonDefineUtils.ENTIY_COMPACT_ACCOUNTMONEY.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getAccountMoney().toString());
		}
		//最后付款日
		else if(CommonDefineUtils.ENTIY_COMPACT_LASTDATETIME.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getLastDateTime());
		}
		//第一笔制单日
		else if(CommonDefineUtils.ENTIY_COMPACT_ZHIDANDAY1.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getZhidanday1());
		}
		//第一笔应付款比例
		else if(CommonDefineUtils.ENTIY_COMPACT_YINGFUMONEYRATIO1.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getYingfumoneyratio1());
		}
		//第一笔实付款额
		else if(CommonDefineUtils.ENTIY_COMPACT_SHIFUMONEY1.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getShifumoney1());
		}
		
		//第二笔制单日
		else if(CommonDefineUtils.ENTIY_COMPACT_ZHIDANDAY2.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getZhidanday2());
		}
		//第二笔应付款比例
		else if(CommonDefineUtils.ENTIY_COMPACT_YINGFUMONEYRATIO2.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getYingfumoneyratio2());
		}
		//第二笔实付款额
		else if(CommonDefineUtils.ENTIY_COMPACT_SHIFUMONEY2.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getShifumoney2());
		}
		
		//第三笔制单日
		else if(CommonDefineUtils.ENTIY_COMPACT_ZHIDANDAY3.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getZhidanday3());
		}
		//第三笔应付款比例
		else if(CommonDefineUtils.ENTIY_COMPACT_YINGFUMONEYRATIO3.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getYingfumoneyratio3());
		}
		//第三笔实付款额
		else if(CommonDefineUtils.ENTIY_COMPACT_SHIFUMONEY3.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getShifumoney3());
		}
		
		//第四笔制单日
		else if(CommonDefineUtils.ENTIY_COMPACT_ZHIDANDAY4.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getZhidanday4());
		}
		//第四笔应付款比例
		else if(CommonDefineUtils.ENTIY_COMPACT_YINGFUMONEYRATIO4.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getYingfumoneyratio4());
		}
		//第四笔实付款额
		else if(CommonDefineUtils.ENTIY_COMPACT_SHIFUMONEY4.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getShifumoney4());
		}
		
		//第五笔制单日
		else if(CommonDefineUtils.ENTIY_COMPACT_ZHIDANDAY5.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getZhidanday5());
		}
		//第五笔应付款比例
		else if(CommonDefineUtils.ENTIY_COMPACT_YINGFUMONEYRATIO5.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getYingfumoneyratio5());
		}
		//第五笔实付款额
		else if(CommonDefineUtils.ENTIY_COMPACT_SHIFUMONEY5.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getShifumoney5());
		}
		
		///////////////////////////////////////////////////////////////////////////////////////
		
		//第6笔制单日
		else if(CommonDefineUtils.ENTIY_COMPACT_ZHIDANDAY6.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getZhidanday6());
		}
		//第6笔应付款比例
		else if(CommonDefineUtils.ENTIY_COMPACT_YINGFUMONEYRATIO6.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getYingfumoneyratio6());
		}
		//第6笔实付款额
		else if(CommonDefineUtils.ENTIY_COMPACT_SHIFUMONEY6.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getShifumoney6());
		}
		
		//第7笔制单日
		else if(CommonDefineUtils.ENTIY_COMPACT_ZHIDANDAY7.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getZhidanday7());
		}
		//第7笔应付款比例
		else if(CommonDefineUtils.ENTIY_COMPACT_YINGFUMONEYRATIO7.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getYingfumoneyratio7());
		}
		//第7笔实付款额
		else if(CommonDefineUtils.ENTIY_COMPACT_SHIFUMONEY7.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getShifumoney7());
		}
		
		//第8笔制单日
		else if(CommonDefineUtils.ENTIY_COMPACT_ZHIDANDAY8.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getZhidanday8());
		}
		//第8笔应付款比例
		else if(CommonDefineUtils.ENTIY_COMPACT_YINGFUMONEYRATIO8.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getYingfumoneyratio8());
		}
		//第8笔实付款额
		else if(CommonDefineUtils.ENTIY_COMPACT_SHIFUMONEY8.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getShifumoney8());
		}
		
		//第9笔制单日
		else if(CommonDefineUtils.ENTIY_COMPACT_ZHIDANDAY9.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getZhidanday9());
		}
		//第9笔应付款比例
		else if(CommonDefineUtils.ENTIY_COMPACT_YINGFUMONEYRATIO9.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getYingfumoneyratio9());
		}
		//第9笔实付款额
		else if(CommonDefineUtils.ENTIY_COMPACT_SHIFUMONEY9.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getShifumoney9());
		}
		
		//第10笔制单日
		else if(CommonDefineUtils.ENTIY_COMPACT_ZHIDANDAY10.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getZhidanday10());
		}
		//第10笔应付款比例
		else if(CommonDefineUtils.ENTIY_COMPACT_YINGFUMONEYRATIO10.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getYingfumoneyratio10());
		}
		//第10笔实付款额
		else if(CommonDefineUtils.ENTIY_COMPACT_SHIFUMONEY10.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getShifumoney10());
		}
		
		//第11笔制单日
		else if(CommonDefineUtils.ENTIY_COMPACT_ZHIDANDAY11.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getZhidanday11());
		}
		//第11笔应付款比例
		else if(CommonDefineUtils.ENTIY_COMPACT_YINGFUMONEYRATIO11.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getYingfumoneyratio11());
		}
		//第11笔实付款额
		else if(CommonDefineUtils.ENTIY_COMPACT_SHIFUMONEY11.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getShifumoney11());
		}
		
		//第12笔制单日
		else if(CommonDefineUtils.ENTIY_COMPACT_ZHIDANDAY12.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getZhidanday12());
		}
		//第12笔应付款比例
		else if(CommonDefineUtils.ENTIY_COMPACT_YINGFUMONEYRATIO12.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getYingfumoneyratio12());
		}
		//第12笔实付款额
		else if(CommonDefineUtils.ENTIY_COMPACT_SHIFUMONEY12.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getShifumoney12());
		}
		
		//第13笔制单日
		else if(CommonDefineUtils.ENTIY_COMPACT_ZHIDANDAY13.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getZhidanday13());
		}
		//第13笔应付款比例
		else if(CommonDefineUtils.ENTIY_COMPACT_YINGFUMONEYRATIO13.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getYingfumoneyratio13());
		}
		//第13笔实付款额
		else if(CommonDefineUtils.ENTIY_COMPACT_SHIFUMONEY13.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getShifumoney13());
		}
		
		//第14笔制单日
		else if(CommonDefineUtils.ENTIY_COMPACT_ZHIDANDAY14.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getZhidanday14());
		}
		//第14笔应付款比例
		else if(CommonDefineUtils.ENTIY_COMPACT_YINGFUMONEYRATIO14.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getYingfumoneyratio14());
		}
		//第14笔实付款额
		else if(CommonDefineUtils.ENTIY_COMPACT_SHIFUMONEY14.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getShifumoney14());
		}
		
		//第15笔制单日
		else if(CommonDefineUtils.ENTIY_COMPACT_ZHIDANDAY15.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getZhidanday15());
		}
		//第15笔应付款比例
		else if(CommonDefineUtils.ENTIY_COMPACT_YINGFUMONEYRATIO15.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getYingfumoneyratio15());
		}
		//第15笔实付款额
		else if(CommonDefineUtils.ENTIY_COMPACT_SHIFUMONEY15.equals(configItemVWInfo.getClabel())){
			configItemTB.setCivalue(form.getShifumoney15());
		}
		
		///////////////////////////////////////////////////////////////////////////////////////////
		else{
			configItemTB.setCivalue(configItemVWInfo.getCivalue());
		}
		log.debug("========合同付款信息设置终了========");
		return configItemTB;
	}
	
	/**
	 * 大数转换不显示科学计数法
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
     * 合同统计查询处理
     * add by zhangze
     * @param dto IGASM04DTO
     * @return IGASM04DTO
     */
    public IGASM04DTO searchStatics(IGASM04DTO dto) throws BLException {
        log.debug("========合同应付款查询开始========");
        
        //分页用信息取得
        PagingDTO pDto = dto.getPagingDto();

        //所有合同信息取得
        List<IG499Info> entityItemCompactVWInfoListA = this.ig499BL.searchIG499Info(dto.getEntityItemCompactVWSearchCond());
        
        //满足查询条件的合同 entityItemCompactVWInfoListA过滤后的结果
        List<IG499Info> entityItemCompactVWInfoListB=new ArrayList<IG499Info>();
        
        List<String> eiid_list = new ArrayList<String>() ;
        
        for (IG499Info entityItemCompactVWInfo : entityItemCompactVWInfoListA) {
            //得到所有满足条件合同eiid的集合
            eiid_list.add(entityItemCompactVWInfo.getEiid()+"");
        }
        //共15个付款实付日
        //{"1694","1701","1708","1715","1722","1785","1792","1799","1806","1813","1820","1827","1834","1841","1848"};
        String[] cid = IGASM04BLType.CID; 
        //共15个付款金额
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
        
        //开始时间，结束时间
        //Date beginOfDate = new Date(IGStringUtils.getCurrentYear()+"/01/01");
        Date beginOfDate = stringToDate(year+"/01/01");
        //Date endOfDate = new Date();
        Date endOfDate = calendars.getTime();
        IGASM0424Form form = (IGASM0424Form)dto.getEntityItemCompactVWSearchCond();
        //如有页面输入开始时间，则赋值
        if(form.getTime_from()!=null && !"".equals(form.getTime_from())){
            //beginOfDate = new Date(form.getTime_from());
            beginOfDate = stringToDate(form.getTime_from());
        }
        //如有页面输入结束时间，则赋值        
        if(form.getTime_to()!=null && !"".equals(form.getTime_to())){
            //endOfDate = new Date(form.getTime_to());
            endOfDate = stringToDate(form.getTime_to());
        } 
            
        //如果开始时间在结束时间之后，则自动修改开始时间为合理的开始时间
        if(endOfDate != null && beginOfDate != null && beginOfDate.after(endOfDate)){
            //如果不调整，则查询结果为空
            //beginOfDate.setYear(endOfDate.getYear());
            Calendar bcal = Calendar.getInstance();
            Calendar ecal = Calendar.getInstance();
            bcal.setTime(beginOfDate);
            ecal.setTime(endOfDate);
            bcal.set(Calendar.YEAR, ecal.get(Calendar.YEAR));
            beginOfDate = bcal.getTime();
        }

        
        List<Integer> resultOfEiid = new ArrayList<Integer>();
        //组成页面需要显示的信息
        Map<String,List<SOC0129Info>> mapOfSOC0129Info = new HashMap<String,List<SOC0129Info>>();
        SOC0129SearchCondImpl ig002SearchCondImpl = new SOC0129SearchCondImpl();
        ig002SearchCondImpl.setEsyscoding_q("999011");
        for(String str : (List<String>)eiid_list){
            //遍历
            ig002SearchCondImpl.setEiid(str);
            
            configItemVWInfoList = this.soc0107BL.searchConfigItemVW(ig002SearchCondImpl,0,0);
            
            for(SOC0129Info info : configItemVWInfoList){
                
                //去除没有的
                if(cid_list.contains(info.getCid()) ){
                    //判断时候在时间段内，默认是一年
//                  System.out.println("info:::"+info.getCid()+":::"+info.getCivalue()+IGStringUtils.getCurrentDate());
                    String civalue = info.getCivalue();
                    if(civalue != null && civalue != ""){
                        //Date date = new Date(civalue); 
                        Date date = stringToDate(civalue); 
                        if(endOfDate != null && beginOfDate != null && date.before(endOfDate) && date.after(beginOfDate)){
                            //时间段满足条件
                            resultOfEiid.add(Integer.parseInt(info.getEiid()));
                            mapOfSOC0129Info.put(str, configItemVWInfoList);
                            break;
                        }
                    }
                    
                }
            }//for
        }//for
        
        //生成页面显示的内容
        for (IG499Info entityItemCompactVWInfo : entityItemCompactVWInfoListA) {
            if(resultOfEiid.contains(entityItemCompactVWInfo.getEiid())){
                int eiid = entityItemCompactVWInfo.getEiid();
                //在区间内的已付款的金额
                Double ekey1 = new Double(0);
                Map<String,String> temp = new HashMap<String,String>();
                for(SOC0129Info info : mapOfSOC0129Info.get(eiid+"")){
                    //15个日期，15个金额
                    if(civalueOfMoney_list.contains(info.getCid()) || cid_list.contains(info.getCid())){
                        temp.put(info.getCid(), info.getCivalue());
                    }
                    temp.put(info.getCid(), info.getCivalue());
                }//for
                //按时间，满足条件的赋给key1
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
            log.debug("========合同统计查询数据不存在========");
            //合同信息查询数据不存在
            dto.addMessage(new ActionMessage("IGCO10000.I002",0));
            return dto;
        } 
        
        if ( totalCount > dto.getMaxSearchCount() ) {
            log.debug("========合同统计查询数据件数过多========");
            //合同信息查询数据件数过多
            dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
            return dto;
        }
        
        //当前页合同信息取得
        List<IG499Info> entityItemCompactVWInfoList=new ArrayList<IG499Info>();
        int fromCount = pDto.getFromCount();
        int pageDispCount = pDto.getPageDispCount();
        for (int i = fromCount; i < entityItemCompactVWInfoListB.size()&&i<fromCount+pageDispCount; i++) {
            entityItemCompactVWInfoList.add(entityItemCompactVWInfoListB.get(i));
        }
        
        pDto.setTotalCount(totalCount);
        
        dto.setEntityItemCompactVWInfoList(entityItemCompactVWInfoList);

        dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
        log.debug("========合同统计查询终了========");
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
	 * 合同付款导出处理
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGASM04DTO intiIGASM0420Action(IGASM04DTO dto) throws BLException {
		//根据条件检索出报表内容
		List<IG499Info> entityItemCompactVWInfoList = this.ig499BL.searchIG499Info(dto.getEntityItemCompactVWSearchCond(), 0, 0);
		//合同付款未完成的信息取得
        List<IG499Info> entityItemCompactVWInfoListB=new ArrayList<IG499Info>();
        for (IG499Info entityItemCompactVWInfo : entityItemCompactVWInfoList) {
            if(entityItemCompactVWInfo.getEiversion()!=0){
                entityItemCompactVWInfoListB.add(entityItemCompactVWInfo);
            }
        }
		//报表数据存入dto
		dto.setReportDataList(entityItemCompactVWInfoListB);
		return dto;
	}
}