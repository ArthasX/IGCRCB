package com.deliverik.infogovernor.asset.bl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;
import org.apache.struts.util.LabelValueBean;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.deliverik.framework.asset.EntityCategory;
import com.deliverik.framework.asset.EntityItemKeyWords;
import com.deliverik.framework.asset.bl.task.EiBelongRelationBL;
import com.deliverik.framework.asset.bl.task.IG013BL;
import com.deliverik.framework.asset.bl.task.IG117BL;
import com.deliverik.framework.asset.bl.task.IG225BL;
import com.deliverik.framework.asset.bl.task.IG313BL;
import com.deliverik.framework.asset.bl.task.IG545BL;
import com.deliverik.framework.asset.bl.task.IG800BL;
import com.deliverik.framework.asset.bl.task.IG912BL;
import com.deliverik.framework.asset.model.EiBelongRelationVWInfo;
import com.deliverik.framework.asset.model.IG013Info;
import com.deliverik.framework.asset.model.IG117Info;
import com.deliverik.framework.asset.model.IG313Info;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.asset.model.IG749Info;
import com.deliverik.framework.asset.model.IG800Info;
import com.deliverik.framework.asset.model.IG887Info;
import com.deliverik.framework.asset.model.IG912Info;
import com.deliverik.framework.asset.model.condition.EiBelongRelationVWSearchCondImpl;
import com.deliverik.framework.asset.model.condition.IG013SearchCondImpl;
import com.deliverik.framework.asset.model.condition.IG117SearchCondImpl;
import com.deliverik.framework.asset.model.condition.IG313SearchCondImpl;
import com.deliverik.framework.asset.model.condition.IG688SearchCondImpl;
import com.deliverik.framework.asset.model.condition.IG800SearchCond;
import com.deliverik.framework.asset.model.condition.IG800SearchCondImpl;
import com.deliverik.framework.asset.model.condition.IG912SearchCondImpl;
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
import com.deliverik.framework.soc.asset.SOC0138Info;
import com.deliverik.framework.soc.asset.bl.task.SOC0107BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0109BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0110BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0112BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0117BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0119BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0126BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0151BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0601BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0603BL;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.SOC0109Info;
import com.deliverik.framework.soc.asset.model.SOC0112Info;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0119Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0128Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.framework.soc.asset.model.SOC0601Info;
import com.deliverik.framework.soc.asset.model.SOC0603Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0107SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0109SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0117SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0118SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0119SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0126SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0601SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0603SearchCondImpl;
import com.deliverik.framework.soc.asset.model.entity.SOC0107TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0109TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0112PK;
import com.deliverik.framework.soc.asset.model.entity.SOC0112TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0118TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0119TB;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.bl.task.OrganizationBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.condition.OrganizationSearchCondImpl;
import com.deliverik.framework.utility.BLErrorType;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.asset.dto.IGASM03DTO;
import com.deliverik.infogovernor.asset.form.IGASM0301Form;
import com.deliverik.infogovernor.asset.form.IGASM0302Form;
import com.deliverik.infogovernor.asset.form.IGASM0304Form;
import com.deliverik.infogovernor.asset.form.IGASM0307Form;
import com.deliverik.infogovernor.asset.form.IGASM0317Form;
import com.deliverik.infogovernor.asset.form.IGASM0321Form;
import com.deliverik.infogovernor.asset.form.IGASM0346Form;
import com.deliverik.infogovernor.util.ASMHelper;
import com.deliverik.infogovernor.util.CodeDefine;

/**
 * 设备配置管理业务逻辑实现
 *
 */
public class IGASM03BLImpl extends BaseBLImpl implements IGASM03BL {

	static Log log = LogFactory.getLog(IGASM03BLImpl.class);
	
	public static final String DEVICE_DEVICE = "001-001";
	
	public static final String DEVICE_DEVICE_CONN_ID = "1";
	
	/** 版本号升级标识 */
	public static final String SAVE_VERSION_UP = "1";

	/** 版本号不升级标识 */
	public static final String SAVE_VERSION = "0";
	
	public static final String EIRRELATIONCODE="'001-001','001-002','003-001','012-001','012-001','013-001','001-005','001-006','001-011','001-010','001-008','007-001'";
	
	/** 资产信息BL */
	protected IG117BL ig117BL;
	
	protected SOC0117BL soc0117BL;

	/** 配置项信息BL */
	protected IG013BL ig013BL;
	
	protected SOC0118BL soc0118BL;
	
	/** 资产配置项BL */
	protected IG800BL ig800BL;
	
	protected SOC0107BL soc0107BL;
	
	/** 配置项关系BL */
	protected IG313BL ig313BL;
	
	protected SOC0119BL soc0119BL;
	
	/** 机房资产BL*/
	protected SOC0601BL soc0601BL;
	
	/** 机柜资产BL*/
	protected SOC0603BL soc0603BL;
	
	/** 文件上传BL */
	protected FileUploadBL fileUploadBL;
	
	/** 资产取值范围下拉数据BL */
	protected IG545BL ig545BL;
	
	protected SOC0151BL soc0151BL;
	
	/** 资产关联关系下拉数据BL */
	protected CodeDetailBL codeDetailBL;
	
	/** 机构BL */
	protected OrganizationBL organizationBL;
	
	/** 配置项BL */
	protected IG225BL ig225BL;
	
	protected SOC0109BL soc0109BL;
	
	/** 用户角色BL */
	protected UserRoleBL userRoleBL;
	
	/** 依赖关系表BL */
	protected EiBelongRelationBL eiBelongRelationBL;
	
	protected SOC0110BL soc0110BL;
	
	/** 最大版本域明细BL */
	protected SOC0126BL soc0126BL;
	
	/** 域明细BL */
	protected SOC0112BL soc0112BL;
	
	
	/** 域明细BL */
	protected IG912BL ig912BL;
	
	public void setEiBelongRelationBL(EiBelongRelationBL eiBelongRelationBL) {
		this.eiBelongRelationBL = eiBelongRelationBL;
	}
	
	public void setIg225BL(IG225BL ig225BL) {
		this.ig225BL = ig225BL;
	}

	/**
	 * @param soc0601bl the soc0601BL to set
	 */
	public void setSoc0601BL(SOC0601BL soc0601bl) {
		soc0601BL = soc0601bl;
	}

	/**
	 * @param soc0603bl the soc0603BL to set
	 */
	public void setSoc0603BL(SOC0603BL soc0603bl) {
		soc0603BL = soc0603bl;
	}

	public void setOrganizationBL(OrganizationBL organizationBL) {
		this.organizationBL = organizationBL;
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
	
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
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

	public void setSoc0109BL(SOC0109BL soc0109BL) {
		this.soc0109BL = soc0109BL;
	}

	public void setSoc0151BL(SOC0151BL soc0151BL) {
		this.soc0151BL = soc0151BL;
	}

	public void setSoc0110BL(SOC0110BL soc0110BL) {
		this.soc0110BL = soc0110BL;
	}

	public void setSoc0126BL(SOC0126BL soc0126BL) {
		this.soc0126BL = soc0126BL;
	}

	public void setSoc0112BL(SOC0112BL soc0112BL) {
		this.soc0112BL = soc0112BL;
	}

	/**
	 * 设备信息查询处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO searchEntityItemAction(IGASM03DTO dto) throws BLException {

		log.debug("========设备信息查询处理开始========");
		
		//设备信息查询件数取得 
		int totalCount = this.soc0118BL.getEntityItemVWSearchCount(dto.getEntityItemVWSearchCond());
		
		if (totalCount == 0) {
			log.debug("========设备信息查询数据不存在========");
			//设备信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========设备信息查询数据件数过多========");
			//设备信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//分页用信息取得
		PagingDTO pDto = dto.getPagingDto();

		//当前页设备信息取得
		List<SOC0124Info> entityItemVWInfoList = this.soc0118BL.searchEntityItemVW(dto.getEntityItemVWSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setEntityItemVWInfoList(entityItemVWInfoList);

		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========设备信息查询处理终了========");
		return dto;
	}
	
	/**
	 * 设备信息登记处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO insertEntityItemAction(IGASM03DTO dto) throws BLException {
		log.debug("========设备信息登记处理开始========");
		//输入Form取得
		IGASM0302Form form = dto.getIgasm0302Form();
		
		//类型ID取得
//		EntitySearchCondImpl cond = new EntitySearchCondImpl();
//		cond.setElabel(form.getElabel());
		//登记处理前的资产信息确认
//		List<Entity> entityList = this.ig117BL.searchEntity(cond, 0, 0);
//		if ( entityList == null || entityList.size() ==0 ) {
//			throw new BLException(BLErrorType.ENTITY_ITEM_NOT_EXISTS_ERROR,
//					"IGCO10000.E004","(编号=" + form.getEilabel() + ")设备基本");
//		}
		
//		Entity entity = entityList.get(0);
//		EntityItem entityItem = entityitemList.get(0);
		
		//***************************************************************************
		//类型分类检测
//		if (!entity.getEcategory().equals(CommonDefineUtils.ENTIY_CATEGORY_DEVICE)) {
//			//设备以外的情况
//			throw new BLException(BLErrorType.ENTITY_CATEGORY_ERROR,
//					"IGCO10000.E011","设备");
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
		
		form.setEistatus(CommonDefineUtils.ENTITYITEM_STARUS_NEW);

		//设备信息登录
		SOC0118Info entityItem = this.soc0118BL.registEntityItem(dto.getIgasm0302Form());
		
		form.setEiidStr(entityItem.getEiid().toString());
		
		dto.setIgasm0302Form(form);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "设备基本信息") );

		log.debug("========设备信息登记处理终了========");
		return dto;
	}

	/**
	 * 设备信息删除处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO deleteEntityItemAction(IGASM03DTO dto) throws BLException {
		log.debug("========设备信息删除处理开始========");
		
		List<Integer> retList = new ArrayList<Integer>();//递归删除的与用户选择删除的有重复
		for( int i=0;i<dto.getDeleteEntityItem().length;i++ ){
			String eiid = dto.getDeleteEntityItem()[i];
			if(!retList.contains(Integer.parseInt(eiid))){
				cycleDelete (eiid,retList);
			}
		}
		for(Integer eiid : retList){
			//删除前删除对象设备确认
			SOC0118Info entityItem = this.soc0118BL.searchEntityItemByKey(eiid);
			
			if (entityItem == null){
				throw new BLException("IGCO10000.E004","删除对象设备基本");
			}
			//设备删除
			this.soc0118BL.deleteEntityItem(entityItem);
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I006","设备信息"));

		log.debug("========设备信息删除处理终了========");
		return dto;
	}
	//递归删除设备所属的组件
	private List<Integer> cycleDelete (String eiid,List<Integer> retList) throws BLException{
		SOC0119SearchCondImpl cond = new SOC0119SearchCondImpl();
		cond.setEirinfo("#" + eiid + "#");
		cond.setEirstatus("C");
		cond.setDeleteflag("0");
		//查找指定设备下的所属组件，组件递归查找
		List<SOC0119Info> list = this.soc0119BL.searchEntityItemRelation(cond);
		for(SOC0119Info eir : list){
			this.cycleDelete(eir.getPareiid()+"",retList);
		}
		if(!retList.contains(Integer.parseInt(eiid))){
			retList.add(Integer.parseInt(eiid));
		}
		return retList;
	}


	/**
	 * 设备配置信息编辑画面初期化处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO initIGASM0304Action(IGASM03DTO dto) throws BLException {

		log.debug("========设备配置信息编辑画面初期化处理开始========");
		
		IGASM0304Form form = dto.getIgasm0304Form();
		
		//设备信息检索
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(
			Integer.parseInt(form.getEiid()));
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","设备");
		}
		
		form.setEidesc(entityItemVWInfo.getEidesc());
		form.setEistatus(entityItemVWInfo.getEistatus());
		form.setEmodeltype(entityItemVWInfo.getEmodeltype());
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
		
		
		//设备配置信息查询件数取得 
		int totalCount = this.soc0107BL.getConfigItemVWSearchCount(form);
		
		if (totalCount == 0) {
			log.debug("========设备配置信息查询数据不存在========");
			//设备配置信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I007",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========设备配置信息查询数据件数过多========");
			//设备配置信息查询数据件数过多
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
			if("IG_0012".equals(e.getClabel())){
				List<LabelValueBean> list = new ArrayList<LabelValueBean>();
				list.add(new LabelValueBean("", ""));
				SOC0601SearchCondImpl soc0601cond = new SOC0601SearchCondImpl();
				List<SOC0601Info> soc0601List = soc0601BL.searchSOC0601Info(soc0601cond);
				for(SOC0601Info ccd : soc0601List){
					list.add(new LabelValueBean(ccd.getEiname(), ccd.getEiname()));
				}
				form.setSelectedListMap(j++, list);
				continue;
			}
			
			if("IG_0013".equals(e.getClabel())){
				List<LabelValueBean> list = new ArrayList<LabelValueBean>();
				if(e.getCivalue()!=null && !(e.getCivalue().equals(""))){
					dto.setArea(e.getCivalue());					
				}
				form.setSelectedListMap(j++, list);
				continue;
			}
			if("IG_0014".equals(e.getClabel())){
				List<LabelValueBean> list = new ArrayList<LabelValueBean>();
				list.add(new LabelValueBean("", ""));
				SOC0603SearchCondImpl soc0603cond = new SOC0603SearchCondImpl();
				List<SOC0603Info> soc0603List = soc0603BL.searchSOC0603Info(soc0603cond);
				for(SOC0603Info ccd : soc0603List){
					list.add(new LabelValueBean(ccd.getEiname(), ccd.getEiname()));
				}
				form.setSelectedListMap(j++, list);
				continue;
			}
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
		
		
		//获取历史版本更新时间
		if(entityItemVWInfo.getEiversion() > 0) {
			dto.setConfigItemVersionTime(this.soc0118BL.searchVersionUpdateTime(entityItemVWInfo.getEiid()));
		}

    	IG912SearchCondImpl cond = new IG912SearchCondImpl();
    	cond.setInJiguiFlg("Y");
    	cond.setEiid(Integer.parseInt(form.getEiid()));
		//当前页设备信息取得
		List<IG912Info> computerDeviceVWInfoList = ig912BL.searchIG912Info(cond,0,0);
		if(computerDeviceVWInfoList!=null&&computerDeviceVWInfoList.size()>0){
			dto.setInJiguiFlg("Y");
		}else{
			dto.setInJiguiFlg("N");
		}
		log.debug("========设备配置信息编辑画面初期化处理终了========");
		return dto;
	}
	
	
	/**
	 * 设备配置信息编辑处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public IGASM03DTO editEntityItemAction(IGASM03DTO dto) throws BLException, FileNotFoundException, IOException {
		log.debug("========设备配置信息编辑处理开始========");
		//版本号生成
		IGASM0304Form form = dto.getIgasm0304Form();
		
		//设备基本信息更新
		SOC0118TB entityItem = (SOC0118TB) this.soc0118BL.searchEntityItemByKey(Integer.parseInt(form.getEiid()));
		
		// 取得版本是否升级标识
		String ident = form.getIdent();
		if(StringUtils.isEmpty(ident)){
			ident = IGASM03BLImpl.SAVE_VERSION_UP;
		}
		
		//配置模型升级小版本，其余升级大版本
		int version = form.getEiversion();//大版本
		int smallversion = form.getEismallversion();//小版本
		String fileversion = version + "";//附件版本
		boolean versonFlag = false;
		if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(form.getEmodeltype())) {
			// 判断是否升级版本号
			// =====================>> 修改 start
			if (IGASM03BLImpl.SAVE_VERSION_UP.equals(ident)) { // 升级版本号
				smallversion++;
				
				//资产关系信息版本升级处理
				this.soc0119BL.upgradeEntityItemRelation(entityItem.getEiid(), entityItem.getEiversion(), entityItem.getEismallversion(),
						version, smallversion);
				
				if(smallversion - 1 != entityItem.getEismallversion()) {
					throw new BLException("IGCO00000.E004");
				}
			} else if (IGASM03BLImpl.SAVE_VERSION.equals(ident)) { // 不升级版本号

//				version = form.getEiversion();
				if (smallversion != entityItem.getEismallversion()) {
					throw new BLException("IGCO00000.E004");
				}

				if (form.getEismallversion() == 0) { // 如果为第一版时设定版本号为 “0.1”
					smallversion = 1;
				}
			}
			//  << =================  end
			fileversion = version + "." + smallversion;
		} else {
//			version++;
			// 判断是否升级版本号
			// =====================>> 修改 start
			if (IGASM03BLImpl.SAVE_VERSION_UP.equals(ident)) { // 升级版本号
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
			} else if (IGASM03BLImpl.SAVE_VERSION.equals(ident)) { // 不升级版本号

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
		}

		
		if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(form.getEmodeltype())) {
			//资产所属关系信息版本升级处理
			this.soc0110BL.upgradeEntityItemRelation(entityItem.getEiid(), entityItem.getEiversion(), entityItem.getEismallversion(),
					version, smallversion);
		}
		
		
		//设备状态
		entityItem.setEistatus(form.getEistatus());
		
		//设备大版本
		entityItem.setEiversion(version);
		
		//设备小版本
		entityItem.setEismallversion(smallversion);
		
		//设备说明
		entityItem.setEidesc(form.getEidesc());

		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		
		//更新时间
		entityItem.setEiupdtime(datetime);
		
		SOC0118Info hostei = this.soc0118BL.updateEntityItem(entityItem);
		//=======更新关系开始========
		if(version ==1&&versonFlag){
			SOC0119SearchCondImpl eircond1 = new SOC0119SearchCondImpl();
			//删除标识
			eircond1.setDeleteflag("0");
			//与该资产相关的关系码
			eircond1.setEirrelationcode(IGASM03BLImpl.EIRRELATIONCODE);
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
		String rootPath = ResourceUtility.getString("UPLOAD_FILE_ROOT_PATH");
		String fileNameXML = null;
		SOC0118Info hosteiXML = null;
		boolean flagXML = false;
		
		boolean copyFlag = false;//是否为拷贝的配置文件
		SOC0107TB configItemXML = new SOC0107TB();
		//设备配置信息更新
		if (form.getCiid() != null && form.getCiid().length > 0 ) {
			
			for( int i=0 ; i < form.getCiid().length; i++ ){
				SOC0107TB configItem = new SOC0107TB();
				//设备ID
				configItem.setEiid(Integer.parseInt(form.getEiid()));
				//资产配置ID
				configItem.setCid(form.getCid()[i]);
				//类型ID
				configItem.setEid(form.getEid()[i].toString());
				//类型层次码
				configItem.setEsyscoding(form.getEsyscoding()[i]);
				//大版本号
				configItem.setCiversion(version);
				//小版本号
				configItem.setCismallversion(smallversion);
				//更新时间
				configItem.setCiupdtime(datetime);
				
				if (StringUtils.isEmpty(form.getCiid()[i])) {
					//默认属性：设备状态
					if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_STATUS.equals(form.getClabel()[i])){
						configItem.setCivalue(CommonDefineUtils.ENTITYITEM_STARUS_NEW);
					}else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_OPERATORID.equals(form.getClabel()[i])){
						//默认属性：操作人id
						configItem.setCivalue(dto.getUserid());
					}else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_OPERATORNAME.equals(form.getClabel()[i])){
						//默认属性：操作人
						configItem.setCivalue(dto.getUsername());
					}else{
						//显示是资产名称，实际存值是资产名称(资产ID)
						if("4".equals(form.getCiattach()[i]) && StringUtils.isNotEmpty(form.getEntityItemCivalue()[i])){
							configItem.setCivalue(form.getEntityItemCivalue()[i]);
						}else {
							configItem.setCivalue(form.getCivalue()[i]);
						}
					}
					
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
						if(IGASM03BLImpl.DEVICE_DEVICE.equals(relationcode)){
							e.setEirrelation(IGASM03BLImpl.DEVICE_DEVICE_CONN_ID);
							e.setEirrelationcode(IGASM03BLImpl.DEVICE_DEVICE);
						}else{
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
					if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_OPERATORID.equals(form.getClabel()[i])){
						//默认属性：操作人id
						configItem.setCivalue(dto.getUserid());
					}else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_OPERATORNAME.equals(form.getClabel()[i])){
						//默认属性：操作人
						configItem.setCivalue(dto.getUsername());
					}else{
						//显示是资产名称，实际存值是资产名称(资产ID)
						if("4".equals(form.getCiattach()[i]) && StringUtils.isNotEmpty(form.getEntityItemCivalue()[i])){
							configItem.setCivalue(form.getEntityItemCivalue()[i]);
						}else {
							configItem.setCivalue(form.getCivalue()[i]);
						}
					}
					
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

					//附件删除
					if("1".equals(form.getCiattach()[i]) && "1".equals(form.getDelfile()[i])){
						configItem.setCivalue("");
					}
					
					// 判断是否升级版本号 如果升级版本号执行插入否则则根据 ciid 进行更新
					if (IGASM03BLImpl.SAVE_VERSION_UP.equals(ident)) { // 升级版本号
						
						configItem = (SOC0107TB) this.soc0107BL.registSOC0107(configItem);

					} else if (IGASM03BLImpl.SAVE_VERSION.equals(ident)) { // 不升级版本号
					
						Integer ciid = Integer.valueOf(form.getCiid()[i]);
						 
						// 获取当前配置项
						IG800Info cfi = this.ig800BL.searchIG800InfoByKey(ciid);
						
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
						SOC0118Info ei =null;
						try{
							ei = this.soc0118BL.searchEntityItemByKey(Integer.parseInt(str.substring(str.lastIndexOf("(")+1, str.length()-1)));
						}catch(Exception er){
							throw new BLException("IGCO10000.E004", new String[] {
									"("+str.substring(0, str.lastIndexOf("("))+")资产配置"
					            });
						}
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
							if(IGASM03BLImpl.DEVICE_DEVICE.equals(relationcode)){
								e.setEirrelation(IGASM03BLImpl.DEVICE_DEVICE_CONN_ID);
								e.setEirrelationcode(IGASM03BLImpl.DEVICE_DEVICE);
							}else{
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
						
						StringBuffer pathBuf = new StringBuffer();
						
						//根目录
						pathBuf.append(rootPath);
						//机能ID
						pathBuf.append("asm"+File.separator);
						//设备ID
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
						fileName.append(fileversion);
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
				//=================================>
				//上传xml文件检测
				if (form.getCiattach()[i].toUpperCase().equals("8")) {
					FormFile file = form.getAttachFileXML(i);
					if ( file != null && file.getFileSize() > 0) {
						//上传文件存在的情况
						//上传文件路径
						
						StringBuffer pathBuf = new StringBuffer();
						
						//根目录
						pathBuf.append(rootPath+"XML"+File.separator+"asm"+File.separator);
						//设备ID
						pathBuf.append(configItem.getEiid()+File.separator);
						
						StringBuffer fileName = new StringBuffer();
						
						//扩展名取得
						//String fileType = "";
						//String sFileName = file.getFileName();
//						int point = sFileName.lastIndexOf(".");
//						if (point != -1) {
//							fileType = sFileName.substring(point);
//							fileName.append(sFileName.substring(0, point));
//
//						}

						//文件扩展名
						//fileName.append(fileType);
//						fileName.append("config-view.xml");
						fileName.append(file.getFileName());
						fileName.append("_"+String.valueOf(fileversion));//大版本
						//文件上传处理
						this.fileUploadBL.saveFile(file, pathBuf.toString(), fileName.toString());
						
						//上传文件名保存
						configItem.setCivalue(fileName.toString());
						
						//更新属性标识
						configItem.setCicurver("1");
						
						this.soc0107BL.updateSOC0107(configItem);			
						hosteiXML = hostei;
						flagXML = true;
						fileNameXML = fileName.toString();
						configItemXML = configItem;
						
						copyFlag = true;
					}else{
						if(!copyFlag){
							//进行文件拷贝
							//根据模板创建Excel文件
							Integer ver = configItem.getCiversion() - 1;
							if(ver==0){
								ver = 1;
							}
							File modelfile = new File(rootPath+"XML"+File.separator+"asm"+File.separator+String.valueOf(configItem.getEiid())+File.separator+"config-view.xml_"+String.valueOf(ver));
							
							if(modelfile.exists()){
								File newfile = new File(rootPath+"XML"+File.separator+"asm"+File.separator+String.valueOf(configItem.getEiid())+File.separator+"config-view.xml_" + fileversion);
								
								FileInputStream fis = new FileInputStream(modelfile);
								BufferedReader in = new BufferedReader(new InputStreamReader(fis));
								
								FileOutputStream output = new FileOutputStream(newfile);
								String str = null;
								while((str=in.readLine())!=null){
									output.write(str.getBytes());
								}
								
								in.close();
								output.flush();
								output.close();
								
								copyFlag = false;
								
								SOC0107TB newConfigItem = (SOC0107TB)SerializationUtils.clone(configItem);
								newConfigItem.setCivalue("config-view.xml_" + fileversion);
								
								this.soc0107BL.updateSOC0107(newConfigItem);			
							}
							
							
							
						}
						
					}
				}
				//<============================================
			}
			
			if(copyFlag){
				//saveXML(new File(rootPath+"XML"+File.separator+"asm"+File.separator+String.valueOf(configItemXML.getEiid())+File.separator+fileNameXML),dto.getUser(),hostei);
			}
			
			
		}
		
		 //属性值发生变化时，将该实体的顶级CI标记为修改，提高手动快照的效率
		if (entityItem.getEirootmark() != null) {
			SOC0118TB topCI = (SOC0118TB) this.soc0118BL.searchEntityItemByKey(entityItem.getEirootmark());
			String topciName = topCI.getEiname();
			SOC0126SearchCondImpl eiDomainDetailMaxVWSearchCond = new SOC0126SearchCondImpl();
			eiDomainDetailMaxVWSearchCond.setTypeId("1");
			eiDomainDetailMaxVWSearchCond.setEiname(topciName);
			List<SOC0138Info> listEiDomainDetailMax=soc0126BL.searchEiDomainDetailVW(eiDomainDetailMaxVWSearchCond,0,0);
			for(SOC0138Info eiDomainDetailMaxVWInfo:listEiDomainDetailMax){
				
				SOC0112PK pk = new SOC0112PK(eiDomainDetailMaxVWInfo.getEiddid(),
						eiDomainDetailMaxVWInfo.getEiddversion(),
						eiDomainDetailMaxVWInfo.getEiname(),
						eiDomainDetailMaxVWInfo.getEiImportversion());
				SOC0112Info eiDomainDetailInfo =soc0112BL.searchEiDomainDetailByPK(pk);
				SOC0112TB instance = (SOC0112TB)SerializationUtils.clone(eiDomainDetailInfo);
				instance.setModifyFlag("1");
				soc0112BL.updateEiDomainDetail(instance);
				
			}
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I005","设备配置信息"));
		
		log.debug("========设备配置信息编辑处理终了========");
		
		return dto;
	}

	/**
	 * 设备配置信息历史记录画面初期化处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO initIGASM0305Action(IGASM03DTO dto) throws BLException {
		log.debug("========设备配置信息历史记录画面初期化处理开始========");
		
		//设备信息检索
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(
				dto.getIgasm0305Form().getEiid());
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","设备");
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
		
		if (dto.getIgasm0305Form().getCiversion()!=null) {
			dto.getIgasm0305Form().setCiversion(String.valueOf(entityItemVWInfo.getEiversion()));
		}
		//获取历史版本更新时间
		dto.setConfigItemVersionTime(this.soc0118BL.searchVersionUpdateTime(dto.getIgasm0305Form().getEiid()));
		
		//判断登陆用户是否有查看该资产配置信息的权限
		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(), entityItemVWInfo);

		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}else{
			dto.setFlag(flag);
		}
		
		log.debug("========设备配置信息历史记录画面初期化处理终了========");
		return dto;
	}
	
	/**
	 * 设备配置信息版本比较画面初期化处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO initIGASM0305ActionForXML(IGASM03DTO dto) throws BLException {
		log.debug("========设备配置信息历史记录画面初期化处理开始========");
		
		//设备信息检索
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(
				dto.getIgasm0305Form().getEiid());
		Integer eiid = dto.getIgasm0305Form().getEiid();
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004", "设备基本");
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
		
		if (StringUtils.isEmpty(dto.getIgasm0305Form().getCiversion()+"")) {
			dto.getIgasm0305Form().setCiversion(String.valueOf(entityItemVWInfo.getEiversion()));
		}
		
		String fileversion = entityItemVWInfo.getEiversion() + "";//XML文件版本
		
		if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(entityItemVWInfo.getEmodeltype())) {
			fileversion = fileversion + "_" + entityItemVWInfo.getEismallversion();
		}
		//获取历史版本更新时间
		List<SOC0128Info> old_civtList = this.soc0118BL.searchVersionUpdateTime(dto.getIgasm0305Form().getEiid());
		List<SOC0128Info> civtList = new ArrayList<SOC0128Info>();
		String rootPath = ResourceUtility.getString("UPLOAD_FILE_ROOT_PATH");
		for(SOC0128Info civt:old_civtList){
			File verfile = new File(rootPath+"XML"+File.separator+"asm"+File.separator+eiid+File.separator+"config-view.xml_" + fileversion);
			if(verfile.exists()){
				civtList.add(civt);
			}
		}
		
		dto.setConfigItemVersionTime(civtList);
		
		//判断登陆用户是否有查看该资产配置信息的权限
		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(), entityItemVWInfo);

		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}else{
			dto.setFlag(flag);
		}
		
		log.debug("========设备配置信息历史记录画面初期化处理终了========");
		return dto;
	}

	/**
	 * 设备关系管理画面初期化处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO initIGASM0306Action(IGASM03DTO dto) throws BLException {
		log.debug("========设备关系管理画面初期化处理开始========");
		
		//设备信息检索
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(
				Integer.parseInt(dto.getIgasm0306Form().getEiid()));
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","设备");
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
		//判断登陆用户是否有查看该资产配置信息的权限
		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(), entityItemVWInfo);
		
		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}else{
			dto.setFlag(flag);
		}
		
		//正向关联关系检索
		SOC0119SearchCondImpl parcond = new SOC0119SearchCondImpl();
		if((dto.getIgasm0306Form().getEiid())!=null)
		{parcond.setEiid(dto.getIgasm0306Form().getEiid());}
		parcond.setParversion(entityItemVWInfo.getEiversion());
		parcond.setParsmallversion(entityItemVWInfo.getEismallversion());
		parcond.setDeleteflag("0");
		//设备关系信息查询件数取得 
		int totalCount = this.soc0119BL.getEntityItemRelationSearchCount(parcond);
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========设备关系信息查询数据件数过多========");
			//设备关系信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		if ( totalCount>0 ) {
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
//		IG313SearchCondImpl cldcond = new IG313SearchCondImpl();
//		
//		cldcond.setCldeiid(dto.getIgasm0306Form().getEiid());
//		cldcond.setCldversion(entityItemVWInfo.getEiversion().toString());
//		cldcond.setCldsmallversion(entityItemVWInfo.getEismallversion().toString());
//		cldcond.setDeleteflag("0");
//		//设备关系信息查询件数取得 
//		totalCount = this.ig313BL.getIG313InfoSearchCount(cldcond);
//		
//		if ( totalCount > dto.getMaxSearchCount() ) {
//			log.debug("========设备关系信息查询数据件数过多========");
//			//设备关系信息查询数据件数过多
//			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
//			return dto;
//		}
//
//		//设备关系信息全件检索
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

		
		log.debug("========设备关系管理画面初期化处理终了========");
		return dto;
	}
	
	
	/**
	 * 设备关系树画面初期化处理(显示全树，顶级EI为根)
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO initIGASM0346Action(IGASM03DTO dto) throws BLException {
		log.debug("========配置包含关系显示处理开始========");
		
		IGASM0346Form form = dto.getIgasm0346Form();
		//查询顶级配置资产的所有子节点
		EiBelongRelationVWSearchCondImpl cond = new EiBelongRelationVWSearchCondImpl();
		cond.setEirootmark(Integer.parseInt(form.getEirootmark()));
		cond.setBrparversion(Integer.parseInt(form.getEiversion()));
		cond.setBrcldversion(cond.getBrparversion());
		List<EiBelongRelationVWInfo> eibrList = this.eiBelongRelationBL.searchEiBelongRelationVW(cond);
		//查询顶级EI
		IG749Info rootEi = this.ig013BL.searchIG749InfoByKey(Integer.parseInt(form.getEirootmark()));
		//根据选中资产大版本查询顶级EI的最大小版本
		Integer rootEiMaxSmallveision = this.ig800BL.searchEiMaxSmallVersion(rootEi.getEiid(), Integer.parseInt(form.getEiversion()));
		//构造树集合
		Map<String,TreeNode> treeNodeMap = new LinkedHashMap<String,TreeNode>();
		//构造根	
		TreeNode rootNode = new TreeNode();
		rootNode.setId(rootEi.getEiid() + "_" + rootEi.getEiversion() + "_" + rootEiMaxSmallveision);//资产ID|大版本|小版本
		rootNode.setName(rootEi.getEiname() + "(" + form.getEiversion() + "." + rootEiMaxSmallveision + ")");//资产名称
		//递归构造包含关系树
		searchConfigurationTreeNode(eibrList, rootEi, rootNode);
		//填充更节点
		treeNodeMap.put(rootNode.getId(),rootNode);		
		dto.setTreeNodeMap(treeNodeMap);
		
		log.debug("========配置包含关系显示处理终了========");
		return dto;
	}
	
	/**
	 * 设备关系树画面初期化处理(选中的资产为根)
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	/*public IGASM03DTO initIGASM0346Action(IGASM03DTO dto) throws BLException {
		log.debug("========配置包含关系显示处理开始========");
		
		IGASM0346Form form = dto.getIgasm0346Form();
		//查询顶级配置资产的所有子节点
		EiBelongRelationVWSearchCondImpl cond = new EiBelongRelationVWSearchCondImpl();
		cond.setEirootmark(Integer.parseInt(form.getEirootmark()));
		cond.setBrparversion(Integer.parseInt(form.getEiversion()));
		cond.setBrcldversion(cond.getBrparversion());
		List<EiBelongRelationVWInfo> eibrList = this.eiBelongRelationBL.searchEiBelongRelationVW(cond);
		//查询当前EI
		EntityItemEntityVWInfo rootEi = this.ig013BL.searchEntityItemEntityVWByKey(Integer.parseInt(form.getEiid()));
		//构造树集合
		Map<String,TreeNode> treeNodeMap = new LinkedHashMap<String,TreeNode>();
		//构造根	
		TreeNode rootNode = new TreeNode();
		rootNode.setId(rootEi.getEiid() + "_" + form.getEiversion() + "_" + form.getEismallversion());//资产ID|大版本|小版本
		rootNode.setName(rootEi.getEiname() + "(" + form.getEiversion() + "." + form.getEismallversion() + ")");//资产名称
		//递归构造包含关系树
		searchConfigurationTreeNode(eibrList, rootEi, rootNode);
		//填充更节点
		treeNodeMap.put(rootNode.getId(),rootNode);		
		dto.setTreeNodeMap(treeNodeMap);
		
		log.debug("========配置包含关系显示处理终了========");
		return dto;
	}*/
	
	/**
	 * 递归构造配置包含树处理
	 *
	 * @param eibrList 节点集合
	 * @param ei 父级资产节点
	 * @param parNode 父级节点
	 */
	public void searchConfigurationTreeNode(List<EiBelongRelationVWInfo> eibrList,
			IG749Info ei, TreeNode parNode) throws BLException {
		
		//迭代节点集合
		for(EiBelongRelationVWInfo eibr : eibrList) {
			if(ei.getEiid().equals(eibr.getBrpareiid())) {//匹配ID
				//构造子节点
				TreeNode cldNode = new TreeNode();
				cldNode.setId(eibr.getBrcldeiid() + "_" + eibr.getBrcldversion() + "_" + eibr.getBrcldsmallversion());//资产ID|大版本|小版本
				cldNode.setName(eibr.getCldEntityItemVW().getEiname() + "(" + eibr.getBrcldversion() + "." + eibr.getBrcldsmallversion() + ")");//资产名称
				//填充子节点
				parNode.addChildTreeNode(cldNode.getId(),cldNode);
				//递归
				searchConfigurationTreeNode(eibrList, eibr.getCldEntityItemVW(), cldNode);
			}
		}
		
	}
	
	/**
	 * 设备关系删除处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO deleteEntityItemRelationAction(IGASM03DTO dto) throws BLException {
		log.debug("========设备关系删除处理开始========");
		
		for( int i=0;i<dto.getDeleteEntityItemRelation().length;i++ ){
			String eirid = dto.getDeleteEntityItemRelation()[i];
			
			SOC0119Info entityItemRelation = 
				this.soc0119BL.searchEntityItemRelationByKey(Integer.parseInt(eirid));
			
			if (entityItemRelation == null){
				throw new BLException("IGCO10000.E004","删除对象设备关系");
			}

			this.soc0119BL.deleteEntityItemRelation(entityItemRelation);
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I006","设备关系信息"));

		log.debug("========设备关系删除处理终了========");
		return dto;
	}

	/**
	 * 设备关系登记处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO insertEntityItemRelationAction(IGASM03DTO dto) throws BLException {
		log.debug("========设备关系登记处理开始========");
		
		IGASM0307Form form = dto.getIgasm0307Form();
		
		//设备ID（子）取得
		IG688SearchCondImpl cond = new IG688SearchCondImpl();
		
		cond.setElabel(form.getElabel());
		cond.setEilabel(form.getEilabel());
		
		List<IG688Info> entityItemVWList = this.ig013BL.searchIG688Info(cond, 0, 0);
		
		if ( entityItemVWList==null || entityItemVWList.size() == 0 ) {
			throw new BLException("IGCO10000.E004","(资产编号=" + form.getElabel() + ",设备编号=" 
					+ form.getEilabel() + ")设备");
		}
		
		form.setCldeiid(entityItemVWList.get(0).getEiid());
		form.setCldeid(entityItemVWList.get(0).getEid().toString());
		
		//设备ID（父）和（子）检测
		if (form.getPareiid().intValue() == form.getCldeiid().intValue()) {
			//设备ID（父）= （子）
			throw new BLException("IGCO10000.E012","设备");
		}
		
		//更新时间设定
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

		form.setEirupdtime(datetime);
		form.setCldsmallversion(entityItemVWList.get(0).getEismallversion());
		form.setCldversion(entityItemVWList.get(0).getEiversion());
		//资产关系登记
		SOC0119Info ret = 
			this.soc0119BL.registEntityItemRelation(dto.getIgasm0307Form());
		
		dto.setEntityItemRelation(ret);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "资产关系信息") );
		
		log.debug("========设备关系登记处理终了========");
		return dto;
	}
	
	/**
	 * 设备关系编辑画面初期化处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO initIGASM0307Action(IGASM03DTO dto) throws BLException {
		log.debug("========设备关系编辑画面初期化处理开始========");
		
		IGASM0307Form form = dto.getIgasm0307Form();
		IG313TB ret = 		
			(IG313TB) this.ig313BL.searchIG313InfoByKey(
				form.getEirid());
		
		if ( ret == null ){
			throw new BLException("IGCO10000.E004","编辑对象设备关系");
		}
		
		//检索结果设定
		form.setPareiname(ret.getParEntityItemVW().getEiname());
		form.setPareid(ret.getPareid().toString());
		form.setPareiid(ret.getPareiid());
		form.setCldeid(ret.getCldeid().toString());
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
		
		log.debug("========设备关系编辑画面初期化处理终了========");
		return dto;
	}

	/**
	 * 设备关系变更处理处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO updateEntityItemRelationAction(IGASM03DTO dto) throws BLException {
		log.debug("========设备关系变更处理处理开始========");
		IGASM0307Form form = dto.getIgasm0307Form();

		//更新时间设定
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

		form.setEirupdtime(datetime);
		
		this.soc0119BL.updateEntityItemRelation(form);

		dto.addMessage(new ActionMessage( "IGCO10000.I005", "设备关系信息") );

		log.debug("========设备关系变更处理处理终了========");
		return dto;
	}
	
	/**
	 * 设备下发信息查询处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO searchNewAndReciveEntityItemAction(IGASM03DTO dto) throws BLException {

		log.debug("========设备下发信息查询处理开始========");
		
		//设备信息查询件数取得 
		int totalCount = this.soc0118BL.getEntityItemVWSearchCount(dto.getEntityItemVWSearchCond());
		
		if (totalCount == 0) {
			log.debug("========设备信息查询数据不存在========");
			//设备信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========设备信息查询数据件数过多========");
			//设备信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//分页用信息取得
		PagingDTO pDto = dto.getPagingDto();

		//当前页设备信息取得
		List<SOC0124Info> entityItemVWInfoList = this.soc0118BL.searchEntityItemVW(dto.getEntityItemVWSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setEntityItemVWInfoList(entityItemVWInfoList);

		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========设备下发信息查询处理终了========");
		return dto;
	}
	

	
	/**
	 * 设备上缴信息查询处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO searchUsingEntityItemAction(IGASM03DTO dto)
			throws BLException {
		log.debug("========设备上缴信息查询处理开始========");
		
		//设备信息查询件数取得 
		int totalCount = this.soc0118BL.getEntityItemVWSearchCount(dto.getEntityItemVWSearchCond());
		
		if (totalCount == 0) {
			log.debug("========设备信息查询数据不存在========");
			//设备信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========设备信息查询数据件数过多========");
			//设备信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//分页用信息取得
		PagingDTO pDto = dto.getPagingDto();

		//当前页设备信息取得
		List<SOC0124Info> entityItemVWInfoList = this.soc0118BL.searchEntityItemVW(dto.getEntityItemVWSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setEntityItemVWInfoList(entityItemVWInfoList);

		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========设备上缴信息查询处理终了========");
		return dto;
	}
	
	/**
	 * 设备报废信息查询处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO searchCanScrapEntityItemAction(IGASM03DTO dto) throws BLException {
		log.debug("========设备报废信息查询处理开始========");
		//设备信息查询件数取得 
		int totalCount = this.soc0118BL.getEntityItemVWSearchCount(dto.getEntityItemVWSearchCond());
		if (totalCount == 0) {
			log.debug("========设备信息查询数据不存在========");
			//设备信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========设备信息查询数据件数过多========");
			//设备信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		//分页用信息取得
		PagingDTO pDto = dto.getPagingDto();
		//当前页设备信息取得
		List<SOC0124Info> entityItemVWInfoList = this.soc0118BL.searchEntityItemVW(dto.getEntityItemVWSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);
		dto.setEntityItemVWInfoList(entityItemVWInfoList);
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		log.debug("========设备报废信息查询处理终了========");
		return dto;
	}
	
	/**
	 * 设备下发处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public void entityIssueAction(IGASM03DTO dto) throws BLException {

		log.debug("========设备下发处理开始========");
		
		IG013TB entityItem = (IG013TB)ig013BL.searchIG013InfoByKey(dto.getIgasm0309Form().getEiid());
		entityItem.setEistatus(CommonDefineUtils.ENTITYITEM_STARUS_USE);
//		entityItem.setEiorgsyscoding(dto.getIgasm0309Form().getOrgid());
		
		IG800SearchCondImpl cond = new IG800SearchCondImpl();
		cond.setEiid(dto.getIgasm0309Form().getEiid());
		if((dto.getIgasm0309Form().getEiversion())!=null){
		cond.setCiversion(dto.getIgasm0309Form().getEiversion());}
		cond.setCismallversion(entityItem.getEismallversion().toString());
		List<IG800Info> configItemList = ig800BL.searchIG800Info(cond, 0, 0);
		
		IG117Info entity = this.ig117BL.searchIG117InfoByKey(entityItem.getEid());
		
		Integer old_eiversion = entityItem.getEiversion();
		Integer old_eismallversion = entityItem.getEismallversion();
		
		if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(entity.getEmodeltype())) {
			entityItem.setEismallversion(entityItem.getEismallversion() + 1);
		} else {
			entityItem.setEiversion(entityItem.getEiversion() + 1);
		}
		
		//资产关系信息版本升级处理
		this.ig313BL.upgradeIG313Info(entityItem.getEiid(), old_eiversion, old_eismallversion,
				entityItem.getEiversion(), entityItem.getEismallversion());
		
		if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(entity.getEmodeltype())) {
			//资产所属关系信息版本升级处理
			this.eiBelongRelationBL.upgradeEntityItemRelation(entityItem.getEiid(), old_eiversion, old_eismallversion,
					entityItem.getEiversion(), entityItem.getEismallversion());
		}
		ig013BL.updateIG013Info(entityItem);
		String updatetime = IGStringUtils.getCurrentDateTime();
		for (IG800Info configItem : configItemList) {
			IG800TB ciTB = (IG800TB)SerializationUtils.clone(configItem);
			ciTB.setCiid(null);
			if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(entity.getEmodeltype())) {
				ciTB.setCismallversion(configItem.getCismallversion() + 1);
			} else {
				ciTB.setCiversion(configItem.getCiversion() + 1);
			}
			String cLabel = configItem.getConfiguration().getClabel();
			if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_STATUS.equals(cLabel)){
				ciTB.setCivalue(CommonDefineUtils.ENTITYITEM_STARUS_USE);
			} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_OPERATORID.equals(cLabel)){
				ciTB.setCivalue(dto.getUserid());
			} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_OPERATORNAME.equals(cLabel)){
				ciTB.setCivalue(dto.getUsername());
			} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_RECIVENAME.equals(cLabel)){
				ciTB.setCivalue(dto.getIgasm0309Form().getReciveUser());
			} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_RECIVEORGNAME.equals(cLabel)){
				ciTB.setCivalue(dto.getIgasm0309Form().getOrgname());
			} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_RECIVEORGCODE.equals(cLabel)){
				ciTB.setCivalue(dto.getIgasm0309Form().getOrgid());
			}
			String civalue = configItem.getCivalue();
			String tbcivalue = ciTB.getCivalue();
			if(civalue == null){
				civalue = "";
			}
			if(tbcivalue == null){
				tbcivalue = "";
			}
			if(civalue.equals(tbcivalue)) {
				//属性更新标识
				ciTB.setCicurver("0");
			} else {
				//属性更新标识
				ciTB.setCicurver("1");
			}
			ciTB.setCiupdtime(updatetime);
			IG800Info ci = ig800BL.registIG800Info(ciTB);
			//属性类别为资产时，修改关联关系
			if("4".equals(configItem.getConfiguration().getCattach()) && StringUtils.isNotEmpty(configItem.getCivalue())){
				


				String str = ci.getCivalue();	
				IG013Info ei = new IG013TB(); 
				Integer eiid = Integer.parseInt(str.substring(str.lastIndexOf("(")+1, str.length()-1)); 
				try{
					ei = ig013BL.searchIG013InfoByKey(eiid);
					//校验关系是否存在
					IG313SearchCondImpl eirCond = new IG313SearchCondImpl();
					eirCond.setEirinfo(ci.getEiid()+"_"+configItem.getCiid()+"_"+ei.getEiid());
					eirCond.setEirstatus("C");
					eirCond.setDeleteflag("0");
					eirCond.setParversion(ci.getCiversion());//资产大版本
					eirCond.setParsmallversion(configItem.getCismallversion());//资产小版本
					
					List<IG313Info> eirlist = ig313BL.searchMaxIG313Info(eirCond);
					if(eirlist.size() != 1) {
						throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR, "IGCO10000.E017");
					} else {
						IG313TB eirTB = (IG313TB)SerializationUtils.clone(eirlist.get(0));
//						eirTB.setEirid(null);
						eirTB.setEirupdtime(IGStringUtils.getCurrentDateTime());
						eirTB.setEirinfo(eirTB.getEirinfo().replaceAll("_" + configItem.getCiid() + "_", "_" + ci.getCiid() + "_"));
						eirTB.setParversion(ci.getCiversion());
						eirTB.setParsmallversion(ci.getCismallversion());
						ig313BL.updateIG313Info(eirTB);
					}
				}catch(Exception ex){
					log.warn("有模式关系信息中存在的资产eiid在资产表中不存在。eiid:"+eiid);
				}
			
			}
		}
		
		dto.addMessage(new ActionMessage("IGASM0309.I001"));
	}
	
	/**
	 * 设备批量下发处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public void entityBatchIssueAction(IGASM03DTO dto) throws BLException{
		for (int i = 0; i < dto.getBatchEntityItem().length; i++) {
			IG800SearchCondImpl cond = new IG800SearchCondImpl();
			Integer eiid =Integer.parseInt(dto.getBatchEntityItem()[i]);
			cond.setEiid(eiid);
			IG013TB entityItem = (IG013TB)ig013BL.searchIG013InfoByKey(eiid);
			cond.setCiversion(String.valueOf(entityItem.getEiversion()));
			cond.setCismallversion(entityItem.getEismallversion().toString());
			List<IG800Info> configItemList = ig800BL.searchIG800Info(cond, 0, 0);
			
			IG117Info entity = this.ig117BL.searchIG117InfoByKey(entityItem.getEid());

			Integer old_eiversion = entityItem.getEiversion();
			Integer old_eismallversion = entityItem.getEismallversion();
			if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(entity.getEmodeltype())) {
				entityItem.setEismallversion(entityItem.getEismallversion() + 1);
			} else {
				entityItem.setEiversion(entityItem.getEiversion() + 1);
			}
			
			entityItem.setEistatus(CommonDefineUtils.ENTITYITEM_STARUS_USE);
			ig013BL.updateIG013Info(entityItem);
			
			//资产关系信息版本升级处理
			this.ig313BL.upgradeIG313Info(entityItem.getEiid(), old_eiversion, old_eismallversion,
					entityItem.getEiversion(), entityItem.getEismallversion());
			
			if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(entity.getEmodeltype())) {
				//资产所属关系信息版本升级处理
				this.eiBelongRelationBL.upgradeEntityItemRelation(entityItem.getEiid(), old_eiversion, old_eismallversion,
						entityItem.getEiversion(), entityItem.getEismallversion());
			}
			
			for (IG800Info configItem : configItemList) {
				IG800TB ciTB = (IG800TB)SerializationUtils.clone(configItem);
				ciTB.setCiid(null);
				if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(entity.getEmodeltype())) {
					ciTB.setCismallversion(configItem.getCismallversion() + 1);
				} else {
					ciTB.setCiversion(configItem.getCiversion() + 1);
				}
				String cLabel = configItem.getConfiguration().getClabel();
				if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_STATUS.equals(cLabel)){
					ciTB.setCivalue(CommonDefineUtils.ENTITYITEM_STARUS_USE);
				} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_OPERATORID.equals(cLabel)){
					ciTB.setCivalue(dto.getUserid());
				} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_OPERATORNAME.equals(cLabel)){
					ciTB.setCivalue(dto.getUsername());
				} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_RECIVENAME.equals(cLabel)){
					ciTB.setCivalue(dto.getIgasm0309Form().getReciveUser());
				} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_RECIVEORGNAME.equals(cLabel)){
					ciTB.setCivalue(dto.getIgasm0309Form().getOrgname());
				} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_RECIVEORGCODE.equals(cLabel)){
					ciTB.setCivalue(dto.getIgasm0309Form().getOrgid());
				}
				if(configItem.getCivalue()==null&&ciTB.getCivalue()==null) {
					//属性更新标识
					ciTB.setCicurver("0");
				}else if(configItem.getCivalue()!=null&&configItem.getCivalue().equals(ciTB.getCivalue())){
					ciTB.setCicurver("0");
				}else {
					//属性更新标识
					ciTB.setCicurver("1");
				}
				IG800Info ci = ig800BL.registIG800Info(ciTB);
				//属性类别为资产时，修改关联关系
				if("4".equals(configItem.getConfiguration().getCattach()) && StringUtils.isNotEmpty(configItem.getCivalue())){
					IG313TB e = new IG313TB();
					e.setPareid(entityItem.getEid());
					e.setPareiid(entityItem.getEiid());
					e.setParversion(entityItem.getEiversion());
					e.setParsmallversion(entityItem.getEismallversion());
					String str = configItem.getCivalue();			
					IG013Info ei = this.ig013BL.searchIG013InfoByKey(Integer.parseInt(str.substring(str.lastIndexOf("(")+1, str.length()-1)));
					e.setCldeid(ei.getEid());
					e.setCldeiid(ei.getEiid());
					e.setCldversion(ei.getEiversion());
					e.setCldsmallversion(ei.getEismallversion());
					//校验关系是否存在
					IG313SearchCondImpl eirCond = new IG313SearchCondImpl();
					eirCond.setEirinfo(entityItem.getEiid()+"_"+configItem.getCiid()+"_"+ei.getEiid());
					eirCond.setEirstatus("C");
					eirCond.setDeleteflag("0");
					List<IG313Info> eirlist = this.ig313BL.searchMaxIG313Info(eirCond);
					if(eirlist.size() != 1) {
						throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR, "IGCO10000.E017");
					} else {
						IG313TB eirTB = (IG313TB)SerializationUtils.clone(eirlist.get(0));
						
						eirTB.setEirinfo(eirTB.getEirinfo().replaceAll("_" + configItem.getCiid() + "_", "_" + ci.getCiid() + "_"));
						
						this.ig313BL.updateIG313Info(eirTB);
					}
				}
			}
			
		}
		dto.addMessage(new ActionMessage("IGASM0309.I001"));
	}
	
	/**
	 * 查询指定eiid的待上缴设备
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO searchEntityPayByEiidAction(IGASM03DTO dto) throws BLException {

		log.debug("========待上缴设备查询开始========");
		IG800SearchCondImpl cond = new IG800SearchCondImpl();
		cond.setEiid(dto.getIgasm0313Form().getEiid());
		List<IG800Info> configItemList = ig800BL.searchIG800Info(cond, 0, 0);
		ArrayList<IG800Info> list = new ArrayList<IG800Info>();//存储最新的设备版本信息
		//int version = 0;
		//取得最新的版本信息
//		for(int i = 0,j = configItemList.size();i<j;i++ ){
//			if(i==0){
//				version = configItemList.get(i).getCiversion();
//				list.add(configItemList.get(i));
//			}else{
//				if(version==configItemList.get(i).getCiversion()){
//					list.add(configItemList.get(i));
//				}
//			}
//			
//		}
		IG013Info entityItem = ig013BL.searchIG013InfoByKey(dto.getIgasm0313Form().getEiid());
		for(int i = 0,j = configItemList.size();i<j;i++ ){
			if(entityItem.getEiversion().equals(configItemList.get(i).getCiversion())
					&& entityItem.getEismallversion().equals(configItemList.get(i).getCismallversion())){
				list.add(configItemList.get(i));
			}
		}
		//取得领用人,机构
		for(IG800Info config:list){
			if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_RECIVENAME.equals(config.getConfiguration().getClabel())){//领用人name
				dto.setRecivename(config.getCivalue());
			}
			if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_RECIVEORGNAME.equals(config.getConfiguration().getClabel())){//领用人org
				dto.setOrgname(config.getCivalue());
				
			}
		}
		log.debug("========待上缴设备查询结束========");
		return dto;
	}
	
	/**
	 * 设备上缴处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public void entityPayAction(IGASM03DTO dto) throws BLException {

		log.debug("========设备上缴处理开始========");
		IG013TB entityItem = (IG013TB)ig013BL.searchIG013InfoByKey(dto.getIgasm0313Form().getEiid());
		entityItem.setEistatus(CommonDefineUtils.ENTITYITEM_STARUS_RENEW);
	//	entityItem.setEiorgsyscoding(dto.getIgasm0313Form().getEiiorgid().substring(0, 4));//取领用人机构的1级机构
		IG117Info entity = this.ig117BL.searchIG117InfoByKey(entityItem.getEid());
		
		IG800SearchCondImpl cond = new IG800SearchCondImpl();
		cond.setEiid(dto.getIgasm0313Form().getEiid());
		cond.setCiversion(dto.getIgasm0313Form().getEiversion());
		cond.setCismallversion(entityItem.getEismallversion().toString());
		List<IG800Info> configItemList = ig800BL.searchIG800Info(cond, 0, 0);

		Integer old_eiversion = entityItem.getEiversion();
		Integer old_eismallversion = entityItem.getEismallversion();
		if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(entity.getEmodeltype())) {
			entityItem.setEismallversion(entityItem.getEismallversion() + 1);
		} else {
			entityItem.setEiversion(entityItem.getEiversion() + 1);
		}
		ig013BL.updateIG013Info(entityItem);
		//资产关系信息版本升级处理
		this.ig313BL.upgradeIG313Info(entityItem.getEiid(), old_eiversion, old_eismallversion,
				entityItem.getEiversion(), entityItem.getEismallversion());
		
		if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(entity.getEmodeltype())) {
			//资产所属关系信息版本升级处理
			this.eiBelongRelationBL.upgradeEntityItemRelation(entityItem.getEiid(), old_eiversion, old_eismallversion,
					entityItem.getEiversion(), entityItem.getEismallversion());
		}
		String updatetime = IGStringUtils.getCurrentDateTime();
		for (IG800Info configItem : configItemList) {
			IG800TB ciTB = (IG800TB)SerializationUtils.clone(configItem);
			ciTB.setCiid(null);
			if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(entity.getEmodeltype())) {
				ciTB.setCismallversion(configItem.getCismallversion() + 1);
			} else {
				ciTB.setCiversion(configItem.getCiversion() + 1);
			}
			String cLabel = configItem.getConfiguration().getClabel();
			if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_STATUS.equals(cLabel)){//资产状态
				ciTB.setCivalue(CommonDefineUtils.ENTITYITEM_STARUS_RENEW);
			} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_OPERATORID.equals(cLabel)){//操作人ID
				ciTB.setCivalue(dto.getUserid());
			} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_OPERATORNAME.equals(cLabel)){//操作人name
				ciTB.setCivalue(dto.getUsername());
			} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_RECIVENAME.equals(cLabel)){
				ciTB.setCivalue("");
			} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_RECIVEORGNAME.equals(cLabel)){
				ciTB.setCivalue("");
			} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_RECIVEORGCODE.equals(cLabel)){
				ciTB.setCivalue("");
			}
			if(configItem.getCivalue()==null&&ciTB.getCivalue()==null){
				//属性更新标识
				ciTB.setCicurver("0");
			}else if(configItem.getCivalue()!=null&&configItem.getCivalue().equals(ciTB.getCivalue())) {
				//属性更新标识
				ciTB.setCicurver("0");
			} else {
				//属性更新标识
				ciTB.setCicurver("1");
			}
			ciTB.setCiupdtime(updatetime);
			IG800Info ci = ig800BL.registIG800Info(ciTB);
			//属性类别为资产时，修改关联关系
			if("4".equals(configItem.getConfiguration().getCattach()) && StringUtils.isNotEmpty(configItem.getCivalue())){
				IG313TB e = new IG313TB();
				e.setPareid(entityItem.getEid());
				e.setPareiid(entityItem.getEiid());
				e.setParversion(entityItem.getEiversion());
				e.setParsmallversion(entityItem.getEismallversion());
				String str = configItem.getCivalue();			
				IG013Info ei = this.ig013BL.searchIG013InfoByKey(Integer.parseInt(str.substring(str.lastIndexOf("(")+1, str.length()-1)));
				e.setCldeid(ei.getEid());
				e.setCldeiid(ei.getEiid());
				e.setCldversion(ei.getEiversion());
				e.setCldsmallversion(ei.getEismallversion());
				//校验关系是否存在
				IG313SearchCondImpl eirCond = new IG313SearchCondImpl();
				eirCond.setEirinfo(entityItem.getEiid()+"_"+configItem.getCiid()+"_"+ei.getEiid());
				eirCond.setEirstatus("C");
				eirCond.setDeleteflag("0");
				List<IG313Info> eirlist = this.ig313BL.searchMaxIG313Info(eirCond);
				if(eirlist.size() != 1) {
					throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR, "IGCO10000.E017");
				} else {
					IG313TB eirTB = (IG313TB)SerializationUtils.clone(eirlist.get(0));
					
					eirTB.setEirinfo(eirTB.getEirinfo().replaceAll("_" + configItem.getCiid() + "_", "_" + ci.getCiid() + "_"));
					
					this.ig313BL.updateIG313Info(eirTB);
				}
			}
		}
		
		dto.addMessage(new ActionMessage("IGASM0313.I001"));
		
	}
	
	/**
	 * 设备批量上缴处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public void entityBatchPayAction(IGASM03DTO dto) throws BLException {

		log.debug("========设备批量上缴处理开始========");
		for (int i = 0; i < dto.getBatchEntityItem().length; i++) {
		IG800SearchCondImpl cond = new IG800SearchCondImpl();
		Integer eiid =Integer.parseInt(dto.getBatchEntityItem()[i]);
		cond.setEiid(eiid);
		IG013TB entityItem = (IG013TB)ig013BL.searchIG013InfoByKey(eiid);
		IG117Info entity = this.ig117BL.searchIG117InfoByKey(entityItem.getEid());
		cond.setCiversion(String.valueOf(entityItem.getEiversion()));
		cond.setCismallversion(entityItem.getEismallversion().toString());
		List<IG800Info> configItemList = ig800BL.searchIG800Info(cond, 0, 0);
		entityItem.setEistatus(CommonDefineUtils.ENTITYITEM_STARUS_RENEW);

		Integer old_eiversion = entityItem.getEiversion();
		Integer old_eismallversion = entityItem.getEismallversion();
		if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(entity.getEmodeltype())) {
			entityItem.setEismallversion(entityItem.getEismallversion() + 1);
		} else {
			entityItem.setEiversion(entityItem.getEiversion() + 1);
		}
		ig013BL.updateIG013Info(entityItem);
		//资产关系信息版本升级处理
		this.ig313BL.upgradeIG313Info(entityItem.getEiid(), old_eiversion, old_eismallversion,
				entityItem.getEiversion(), entityItem.getEismallversion());
		
		if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(entity.getEmodeltype())) {
			//资产所属关系信息版本升级处理
			this.eiBelongRelationBL.upgradeEntityItemRelation(entityItem.getEiid(), old_eiversion, old_eismallversion,
					entityItem.getEiversion(), entityItem.getEismallversion());
		}
		for (IG800Info configItem : configItemList) {
			IG800TB ciTB = (IG800TB)SerializationUtils.clone(configItem);
			ciTB.setCiid(null);
			if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(entity.getEmodeltype())) {
				ciTB.setCismallversion(configItem.getCismallversion() + 1);
			} else {
				ciTB.setCiversion(configItem.getCiversion() + 1);
			}
			String cLabel = configItem.getConfiguration().getClabel();
			if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_STATUS.equals(cLabel)){//资产状态
				ciTB.setCivalue(CommonDefineUtils.ENTITYITEM_STARUS_RENEW);
			} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_OPERATORID.equals(cLabel)){//操作人ID
				ciTB.setCivalue(dto.getUserid());
			} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_OPERATORNAME.equals(cLabel)){//操作人name
				ciTB.setCivalue(dto.getUsername());
			} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_RECIVENAME.equals(cLabel)){
				ciTB.setCivalue("");
			} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_RECIVEORGNAME.equals(cLabel)){
				ciTB.setCivalue("");
			} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_RECIVEORGCODE.equals(cLabel)){
				ciTB.setCivalue("");
			}
			if(configItem.getCivalue()==null&&ciTB.getCivalue()==null) {
				//属性更新标识
				ciTB.setCicurver("0");
			} else if(configItem.getCivalue()!=null&&configItem.getCivalue().equals(ciTB.getCivalue())){
				//属性更新标识
				ciTB.setCicurver("0");
			}else {
				//属性更新标识
				ciTB.setCicurver("1");
			}
			IG800Info ci = ig800BL.registIG800Info(ciTB);
			//属性类别为资产时，修改关联关系
			if("4".equals(configItem.getConfiguration().getCattach()) && StringUtils.isNotEmpty(configItem.getCivalue())){
				IG313TB e = new IG313TB();
				e.setPareid(entityItem.getEid());
				e.setPareiid(entityItem.getEiid());
				e.setParversion(entityItem.getEiversion());
				e.setParsmallversion(entityItem.getEismallversion());
				String str = configItem.getCivalue();			
				IG013Info ei = this.ig013BL.searchIG013InfoByKey(Integer.parseInt(str.substring(str.lastIndexOf("(")+1, str.length()-1)));
				e.setCldeid(ei.getEid());
				e.setCldeiid(ei.getEiid());
				e.setCldversion(ei.getEiversion());
				e.setCldsmallversion(ei.getEismallversion());
				//校验关系是否存在
				IG313SearchCondImpl eirCond = new IG313SearchCondImpl();
				eirCond.setEirinfo(entityItem.getEiid()+"_"+configItem.getCiid()+"_"+ei.getEiid());
				eirCond.setEirstatus("C");
				eirCond.setDeleteflag("0");
				List<IG313Info> eirlist = this.ig313BL.searchMaxIG313Info(eirCond);
				if(eirlist.size() != 1) {
					throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR, "IGCO10000.E017");
				} else {
					IG313TB eirTB = (IG313TB)SerializationUtils.clone(eirlist.get(0));
					
					eirTB.setEirinfo(eirTB.getEirinfo().replaceAll("_" + configItem.getCiid() + "_", "_" + ci.getCiid() + "_"));
					
					this.ig313BL.updateIG313Info(eirTB);
				}
			}
		}
		
		}
		dto.addMessage(new ActionMessage("IGASM0313.I001"));
		log.debug("========设备批量上缴处理开始========");
		
	}
	public IGASM03DTO searchPreScrapEntityItemAction(IGASM03DTO dto) throws BLException {
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(dto.getIgasm0311Form().getEiid());
		dto.setEntityItemVWInfo(entityItemVWInfo);
		//判断登陆用户是否有查看该资产配置信息的权限
		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(), entityItemVWInfo);
		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E023","预报废"));
		}
		dto.setFlag(flag);
		return dto;
	}
	
	public IGASM03DTO searchScrapEntityItemAction(IGASM03DTO dto) throws BLException {
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(dto.getIgasm0314Form().getEiid());
		dto.setEntityItemVWInfo(entityItemVWInfo);
		//判断登陆用户是否有查看该资产配置信息的权限
		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(), entityItemVWInfo);
		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E023","报废"));
		}
		dto.setFlag(flag);
		return dto;
	}
	
	public IGASM03DTO searchReceiveEntityItemAction(IGASM03DTO dto) throws BLException {
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(dto.getIgasm0315Form().getEiid());
		dto.setEntityItemVWInfo(entityItemVWInfo);
		//判断登陆用户是否有查看该资产配置信息的权限
		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(), entityItemVWInfo);
		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E023","撤销预报废"));
		}
		dto.setFlag(flag);
		return dto;
	}
		
	/**
	 * 设备预报废处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public void entityPreScrapAction(IGASM03DTO dto) throws BLException {
			IG013TB entityItem = (IG013TB)ig013BL.searchIG013InfoByKey(dto.getIgasm0311Form().getEiid());
			IG800SearchCondImpl cond = new IG800SearchCondImpl();
			cond.setEiid(dto.getIgasm0311Form().getEiid());
			cond.setCiversion(dto.getIgasm0311Form().getEiversion());
			cond.setCismallversion(entityItem.getEismallversion().toString());
			this.saveConfigItem(dto, cond, CommonDefineUtils.ENTITYITEM_STARUS_PRESCRAP);
			
			entityItem.setEistatus(CommonDefineUtils.ENTITYITEM_STARUS_PRESCRAP);
			IG117Info entity = this.ig117BL.searchIG117InfoByKey(entityItem.getEid());
			Integer old_eiversion = entityItem.getEiversion();
			Integer old_eismallversion = entityItem.getEismallversion();
			if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(entity.getEmodeltype())) {
				entityItem.setEismallversion(entityItem.getEismallversion() + 1);
			} else {
				entityItem.setEiversion(entityItem.getEiversion() + 1);
			}
			ig013BL.updateIG013Info(entityItem);
			//资产关系信息版本升级处理
			this.ig313BL.upgradeIG313Info(entityItem.getEiid(), old_eiversion, old_eismallversion,
					entityItem.getEiversion(), entityItem.getEismallversion());
			
			if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(entity.getEmodeltype())) {
				//资产所属关系信息版本升级处理
				this.eiBelongRelationBL.upgradeEntityItemRelation(entityItem.getEiid(), old_eiversion, old_eismallversion,
						entityItem.getEiversion(), entityItem.getEismallversion());
			}
	}
	
	public void entityPreScrapBatchAction(IGASM03DTO dto) throws BLException {
		for (int i = 0; i < dto.getBatchEntityItem().length; i++) {
			IG800SearchCondImpl cond = new IG800SearchCondImpl();
			cond.setEiid(Integer.parseInt(dto.getBatchEntityItem()[i]));
			IG013TB entityItem = (IG013TB)ig013BL.searchIG013InfoByKey(Integer.parseInt(dto.getBatchEntityItem()[i]));
			cond.setCiversion(String.valueOf(entityItem.getEiversion()));
			cond.setCismallversion(entityItem.getEismallversion().toString());
			this.saveConfigItem(dto, cond, CommonDefineUtils.ENTITYITEM_STARUS_PRESCRAP);
			
			entityItem.setEistatus(CommonDefineUtils.ENTITYITEM_STARUS_PRESCRAP);
			IG117Info entity = this.ig117BL.searchIG117InfoByKey(entityItem.getEid());
			Integer old_eiversion = entityItem.getEiversion();
			Integer old_eismallversion = entityItem.getEismallversion();
			if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(entity.getEmodeltype())) {
				entityItem.setEismallversion(entityItem.getEismallversion() + 1);
			} else {
				entityItem.setEiversion(entityItem.getEiversion() + 1);
			}
			ig013BL.updateIG013Info(entityItem);
			//资产关系信息版本升级处理
			this.ig313BL.upgradeIG313Info(entityItem.getEiid(), old_eiversion, old_eismallversion,
					entityItem.getEiversion(), entityItem.getEismallversion());
			
			if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(entity.getEmodeltype())) {
				//资产所属关系信息版本升级处理
				this.eiBelongRelationBL.upgradeEntityItemRelation(entityItem.getEiid(), old_eiversion, old_eismallversion,
						entityItem.getEiversion(), entityItem.getEismallversion());
			}
		}
	}
	
	/**
	 * 设备报废处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public void entityScrapAction(IGASM03DTO dto) throws BLException {
		IG800SearchCondImpl cond = new IG800SearchCondImpl();
		cond.setEiid(dto.getIgasm0314Form().getEiid());
		cond.setCiversion(dto.getIgasm0314Form().getEiversion());
		IG013TB entityItem = (IG013TB)ig013BL.searchIG013InfoByKey(dto.getIgasm0314Form().getEiid());
		cond.setCismallversion(entityItem.getEismallversion().toString());
		this.saveConfigItem(dto, cond, CommonDefineUtils.ENTITYITEM_STARUS_SCRAP);
		
		entityItem.setEistatus(CommonDefineUtils.ENTITYITEM_STARUS_SCRAP);
		IG117Info entity = this.ig117BL.searchIG117InfoByKey(entityItem.getEid());
		Integer old_eiversion = entityItem.getEiversion();
		Integer old_eismallversion = entityItem.getEismallversion();
		if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(entity.getEmodeltype())) {
			entityItem.setEismallversion(entityItem.getEismallversion() + 1);
		} else {
			entityItem.setEiversion(entityItem.getEiversion() + 1);
		}
		ig013BL.updateIG013Info(entityItem);
		//资产关系信息版本升级处理
		this.ig313BL.upgradeIG313Info(entityItem.getEiid(), old_eiversion, old_eismallversion,
				entityItem.getEiversion(), entityItem.getEismallversion());
		
		if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(entity.getEmodeltype())) {
			//资产所属关系信息版本升级处理
			this.eiBelongRelationBL.upgradeEntityItemRelation(entityItem.getEiid(), old_eiversion, old_eismallversion,
					entityItem.getEiversion(), entityItem.getEismallversion());
		}
	}
	
	public void entityScrapBatchAction(IGASM03DTO dto) throws BLException {
		for (int i = 0; i < dto.getBatchEntityItem().length; i++) {
			IG800SearchCondImpl cond = new IG800SearchCondImpl();
			cond.setEiid(Integer.parseInt(dto.getBatchEntityItem()[i]));
			IG013TB entityItem = (IG013TB)ig013BL.searchIG013InfoByKey(Integer.parseInt(dto.getBatchEntityItem()[i]));
			cond.setCiversion(String.valueOf(entityItem.getEiversion()));
			cond.setCismallversion(entityItem.getEismallversion().toString());
			this.saveConfigItem(dto, cond, CommonDefineUtils.ENTITYITEM_STARUS_SCRAP);
			
			entityItem.setEistatus(CommonDefineUtils.ENTITYITEM_STARUS_SCRAP);
			IG117Info entity = this.ig117BL.searchIG117InfoByKey(entityItem.getEid());
			Integer old_eiversion = entityItem.getEiversion();
			Integer old_eismallversion = entityItem.getEismallversion();
			if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(entity.getEmodeltype())) {
				entityItem.setEismallversion(entityItem.getEismallversion() + 1);
			} else {
				entityItem.setEiversion(entityItem.getEiversion() + 1);
			}
			ig013BL.updateIG013Info(entityItem);
			//资产关系信息版本升级处理
			this.ig313BL.upgradeIG313Info(entityItem.getEiid(), old_eiversion, old_eismallversion,
					entityItem.getEiversion(), entityItem.getEismallversion());
			
			if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(entity.getEmodeltype())) {
				//资产所属关系信息版本升级处理
				this.eiBelongRelationBL.upgradeEntityItemRelation(entityItem.getEiid(), old_eiversion, old_eismallversion,
						entityItem.getEiversion(), entityItem.getEismallversion());
			}
		}
	}
	
	/**
	 * 设备预报废撤销处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public void entityCancelPreScrapAction(IGASM03DTO dto) throws BLException {
		IG800SearchCondImpl cond = new IG800SearchCondImpl();
		cond.setEiid(dto.getIgasm0315Form().getEiid());
		cond.setCiversion(dto.getIgasm0315Form().getEiversion());
		IG013TB entityItem = (IG013TB)ig013BL.searchIG013InfoByKey(dto.getIgasm0315Form().getEiid());
		cond.setCismallversion(entityItem.getEismallversion().toString());
		this.saveConfigItem(dto, cond, CommonDefineUtils.ENTITYITEM_STARUS_RENEW);
		
		entityItem.setEistatus(CommonDefineUtils.ENTITYITEM_STARUS_RENEW);
		IG117Info entity = this.ig117BL.searchIG117InfoByKey(entityItem.getEid());
		Integer old_eiversion = entityItem.getEiversion();
		Integer old_eismallversion = entityItem.getEismallversion();
		if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(entity.getEmodeltype())) {
			entityItem.setEismallversion(entityItem.getEismallversion() + 1);
		} else {
			entityItem.setEiversion(entityItem.getEiversion() + 1);
		}
		ig013BL.updateIG013Info(entityItem);
		//资产关系信息版本升级处理
		this.ig313BL.upgradeIG313Info(entityItem.getEiid(), old_eiversion, old_eismallversion,
				entityItem.getEiversion(), entityItem.getEismallversion());
		
		if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(entity.getEmodeltype())) {
			//资产所属关系信息版本升级处理
			this.eiBelongRelationBL.upgradeEntityItemRelation(entityItem.getEiid(), old_eiversion, old_eismallversion,
					entityItem.getEiversion(), entityItem.getEismallversion());
		}
	}
	public void entityCancelPreScrapBatchAction(IGASM03DTO dto) throws BLException {
		for (int i = 0; i < dto.getBatchEntityItem().length; i++) {
			IG800SearchCondImpl cond = new IG800SearchCondImpl();
			cond.setEiid(Integer.parseInt(dto.getBatchEntityItem()[i]));
			IG013TB entityItem = (IG013TB)ig013BL.searchIG013InfoByKey(Integer.parseInt(dto.getBatchEntityItem()[i]));
			cond.setCiversion(String.valueOf(entityItem.getEiversion()));
			cond.setCismallversion(entityItem.getEismallversion().toString());
			this.saveConfigItem(dto, cond, CommonDefineUtils.ENTITYITEM_STARUS_RENEW);
			
			entityItem.setEistatus(CommonDefineUtils.ENTITYITEM_STARUS_RENEW);
			
			IG117Info entity = this.ig117BL.searchIG117InfoByKey(entityItem.getEid());

			Integer old_eiversion = entityItem.getEiversion();
			Integer old_eismallversion = entityItem.getEismallversion();
			if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(entity.getEmodeltype())) {
				entityItem.setEismallversion(entityItem.getEismallversion() + 1);
			} else {
				entityItem.setEiversion(entityItem.getEiversion() + 1);
			}
			
			ig013BL.updateIG013Info(entityItem);
			//资产关系信息版本升级处理
			this.ig313BL.upgradeIG313Info(entityItem.getEiid(), old_eiversion, old_eismallversion,
					entityItem.getEiversion(), entityItem.getEismallversion());
			
			if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(entity.getEmodeltype())) {
				//资产所属关系信息版本升级处理
				this.eiBelongRelationBL.upgradeEntityItemRelation(entityItem.getEiid(), old_eiversion, old_eismallversion,
						entityItem.getEiversion(), entityItem.getEismallversion());
			}
		}
	}
	
	private void saveConfigItem(IGASM03DTO dto,IG800SearchCond cond,String status) throws BLException {
		IG688Info entityItem = ig013BL.searchIG688InfoByKey(cond.getEiid());
		List<IG800Info> configItemList = ig800BL.searchIG800Info(cond, 0, 0);
		for (IG800Info configItem : configItemList) {
			IG800TB ciTB = (IG800TB)SerializationUtils.clone(configItem);

			ciTB.setCiid(null);
			if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(entityItem.getEmodeltype())) {
				ciTB.setCismallversion(configItem.getCismallversion() + 1);
			} else {
				ciTB.setCiversion(configItem.getCiversion() + 1);
			}
			
			
			String cLabel = configItem.getConfiguration().getClabel();
			if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_STATUS.equals(cLabel)){
				ciTB.setCivalue(status);
			} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_OPERATORID.equals(cLabel)){
				ciTB.setCivalue(dto.getUserid());
			} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_OPERATORNAME.equals(cLabel)){
				ciTB.setCivalue(dto.getUsername());
			} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_RECIVENAME.equals(cLabel)){
				ciTB.setCivalue("");
			} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_RECIVEORGNAME.equals(cLabel)){
				ciTB.setCivalue("");
			} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_RECIVEORGCODE.equals(cLabel)){
				ciTB.setCivalue("");
			}
			String civalue = configItem.getCivalue();
			String citbvalue = ciTB.getCivalue();
			if(civalue == null){
				civalue="";
			}
			if(citbvalue == null){
				citbvalue="";
			}
			if(civalue.equals(citbvalue)) {
				//属性更新标识
				ciTB.setCicurver("0");
			} else {
				//属性更新标识
				ciTB.setCicurver("1");
			}
			IG800Info ci = ig800BL.registIG800Info(ciTB);
			//属性类别为资产时，修改关联关系
			if("4".equals(configItem.getConfiguration().getCattach()) && StringUtils.isNotEmpty(configItem.getCivalue())){
				IG313TB e = new IG313TB();
				e.setPareid(Integer.parseInt(entityItem.getEid()));
				e.setPareiid(entityItem.getEiid());
				e.setParversion(entityItem.getEiversion());
				e.setParsmallversion(entityItem.getEismallversion());
				String str = configItem.getCivalue();			
				IG013Info ei = this.ig013BL.searchIG013InfoByKey(Integer.parseInt(str.substring(str.lastIndexOf("(")+1, str.length()-1)));
				e.setCldeid(ei.getEid());
				e.setCldeiid(ei.getEiid());
				e.setCldversion(ei.getEiversion());
				e.setCldsmallversion(ei.getEismallversion());
				//校验关系是否存在
				IG313SearchCondImpl eirCond = new IG313SearchCondImpl();
				eirCond.setEirinfo(entityItem.getEiid()+"_"+configItem.getCiid()+"_"+ei.getEiid());
				eirCond.setEirstatus("C");
				eirCond.setDeleteflag("0");
				List<IG313Info> eirlist = this.ig313BL.searchMaxIG313Info(eirCond);
				if(eirlist.size() != 1) {
					throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR, "IGCO10000.E017");
				} else {
					IG313TB eirTB = (IG313TB)SerializationUtils.clone(eirlist.get(0));
					
					eirTB.setEirinfo(eirTB.getEirinfo().replaceAll("_" + configItem.getCiid() + "_", "_" + ci.getCiid() + "_"));
					
					this.ig313BL.updateIG313Info(eirTB);
				}
			}
		}
	}	
	/**
	 *设备信息修改初期显示处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO initEntityItem(IGASM03DTO dto) throws BLException {

		log.debug("========设备信息编辑画面初期显示处理开始========");
		
		IGASM0321Form form = dto.getIgasm0321Form();
		
		//显示用资产信息取得
		SOC0124Info entityItem = this.soc0118BL.searchEntityItemVWByKey(form.getEiid());
		
		if ( entityItem == null ){
			throw new BLException("IGCO10000.E004","变更设备基本");
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
		form.setEismallversion(entityItem.getEismallversion());
		form.setEirootmark(entityItem.getEirootmark());
		
		//判断登陆用户是否有查看该资产配置信息的权限
		boolean permission = this.soc0118BL.checkEntityItemDomain(dto.getUser(), entityItem);
		boolean isRoleManager = this.userRoleBL.checkRoleManagerByType(dto.getUser().getUserid(), EntityCategory.ROLE_TYPE_DEVICE);
		form.setRoleManager(isRoleManager);
		form.setPermission(permission);
		
		dto.setIgasm0321Form(form);
		
		//dto.addMessage(new ActionMessage("IGCO10000.I001","设备基本信息"));
		
		if(!permission) {
			dto.addMessage(new ActionMessage("IGCO10000.E023","修改"));
		}
		
		log.debug("========设备信息编辑画面初期显示处理终了========");
		return dto;
	}
	/**
	 *设备信息修改处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO updateEntityItem(IGASM03DTO dto) throws BLException {
		
		log.debug("========设备信息编辑画面初期显示处理开始========");
		
		IGASM0321Form form = dto.getIgasm0321Form();
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
		dto.addMessage(new ActionMessage("IGCO10000.I005","设备基本信息"));
		log.debug("========设备信息编辑画面初期显示处理终了========");
		return dto;
	}
	
	/**
	 *	获取设备关联关系处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO searchRelationListAction(IGASM03DTO dto) throws BLException {
		log.debug("========获取设备关联关系处理开始========");
		List<LabelValueBean> list = this.codeDetailBL.searchLabelValueBeanList(CommonDefineUtils.ENTIY_CATEGORY_DEVICE,CodeDefine.getCodeDefine("ENTITY_ITEM_RELATION_CODE").getCcid());
		dto.setRelationList(list);
		log.debug("========获取设备关联关系处理终了========");
		return dto;
	}
	
	
	/**
	 * 设备批量入库登记编辑画面初期化处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO initIGASM0317Action(IGASM03DTO dto) throws BLException{
		
		log.debug("========设备批量入库登记信息编辑画面初期显示处理开始========");
		
		IGASM0317Form form = dto.getIgasm0317Form();
		///显示用资产信息取得
		IG013Info entityItem = this.ig013BL.searchIG013InfoByKey(Integer.parseInt(form.getPareiid()));
		
		if ( entityItem == null ){
			throw new BLException("IGCO10000.E004","批量入库设备模版基本");
		}
		
		//画面显示设定
		
		String orgsyscoding = entityItem.getEiorgsyscoding();
		String esyscoding = entityItem.getEsyscoding();
		IG117SearchCondImpl EntityCond = new IG117SearchCondImpl();
		EntityCond.setEsyscoding(esyscoding);
		List<IG117Info> entityList = this.ig117BL.searchIG117Info(EntityCond, 0, 0);
		for (int i = 0; i < entityList.size(); i++) {
			form.setEname(entityList.get(0).getEname());
		}
		form.setEsyscoding(esyscoding);
		OrganizationSearchCondImpl OrgCond = new OrganizationSearchCondImpl();
		OrgCond.setOrgsyscoding(orgsyscoding);
		List<Organization> orgList = this.organizationBL.searchOrganization(OrgCond, 0, 0);
		for (int i = 0; i < orgList.size(); i++) {
			form.setEiorgname(orgList.get(0).getOrgname());
		}
		form.setEiorgsyscoding(orgsyscoding);
		Date nowDateTime = new Date();
		String date = CommonDefineUtils.DATE_FORMAT.format(nowDateTime);
		form.setEid(entityItem.getEid());
		form.setEiinsdate(date);
		form.setEidesc(entityItem.getEidesc());
		form.setEiname(entityItem.getEiname());
		dto.setIgasm0317Form(form);
		log.debug("========设备批量入库登记信息编辑画面初期显示处理开始========");
		return dto;
	}
	
	/**
	 * 设备批量入库登记处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public synchronized IGASM03DTO insertBatchEntityItemAction(IGASM03DTO dto) throws BLException {
		//输入Form取得
		IGASM0317Form form = dto.getIgasm0317Form();
		String[] ids_default = form.getIds_default();//设定要提交的条数
		String[] ids = form.getIds();//真正提交的条数
		boolean id_flag = false;
		if(form.getEinames() != null) {
			int length = ids_default.length;
			int id_length = ids.length;
			List<LabelValueBean> label = new ArrayList<LabelValueBean>();
			//获取起始设备编号
			IG013SearchCondImpl eiCond = new IG013SearchCondImpl();
			
			eiCond.setEilabel(CommonDefineUtils.ENTIY_CATEGORY_DEVICE_KEY + IGStringUtils.getCurrentYear().substring(2));
			
			String eilabel = this.ig013BL.searchNextIG013InfoLable(eiCond);
			
			eiCond = null;
			
			Integer serialnum = new Integer(eilabel.substring(EntityItemKeyWords.LABEL_LEFT_LENGTH));
			
			List<IG800Info> configitemList = this.ig800BL.searchIG800InfoHistoryByEiid(Integer.parseInt(form.getPareiid()), -1, null, null);
			
			Map<String,IG313TB> map = new HashMap<String, IG313TB>();
			form.setEid(form.getEid());
			form.setEidesc(form.getEidesc());
			form.setEiinsdate(form.getEiinsdate());
			form.setEiorgsyscoding(form.getEiorgsyscoding());
			form.setEsyscoding(form.getEsyscoding());
			form.setEistatus(CommonDefineUtils.ENTITYITEM_STARUS_NEW);
			IG688Info entityItemVW = this.ig013BL.searchIG688InfoByKey(Integer.parseInt(form.getPareiid()));
			
			if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(entityItemVW.getEmodeltype())) {
				form.setEiversion(0);
				form.setEismallversion(1);
			} else {
				form.setEiversion(1);
				form.setEismallversion(0);
			}
			
			int num = 0;
			for (int i = 0; i < length; i++) {
				id_flag = false;
	
				for(int n = 0;n<id_length;n++){
					if(ids_default[i].equals(ids[n])){
						id_flag = true;
						break;
					}
				}
				if(!id_flag){
					continue;
				}
				
				form.setEilabel(CommonDefineUtils.ENTIY_CATEGORY_DEVICE_KEY + IGStringUtils.getCurrentYear().substring(2)
						+ StringUtils.leftPad(String.valueOf(serialnum + num) , EntityItemKeyWords.LABEL_LENGTH, EntityItemKeyWords.LABEL_LEFT_PAD));
				num++;
				form.setEiname(form.getEinames()[i]);
				label.add(new LabelValueBean(form.getEiname(), form.getEilabel()));
				
				String serial = form.getSerials()[i];//设备序列号
			
				//更新时间设定
				Date nowDateTime = new Date();
				String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
				nowDateTime = null;
				form.setEiupdtime(datetime);
				//dto.setIgasm0317Form(form);
				//设备信息登录
				IG013Info entityitem  = this.ig013BL.registIG013Info(form);
				for (IG800Info configItem : configitemList) {
					IG800TB configitemTB = (IG800TB)SerializationUtils.clone(configItem);
					configitemTB.setCiid(null);
					configitemTB.setEiid(entityitem.getEiid());
					configitemTB.setCiversion(entityitem.getEiversion());
					configitemTB.setCismallversion(entityitem.getEismallversion());
					// add by songhy 2010-05-31 start
					//批量入库时，在设备名称后添加一列填写设备序列号，102为Configuration表中序列号的键值
					if(EntityItemKeyWords.ENTITY_DEFAULT_SERIAL_NUMBER.equals(configItem.getConfiguration().getClabel())){
						configitemTB.setCivalue(serial);
					}
					// add by songhy 2010-05-31 end
					//属性更新标识
					if(StringUtils.isEmpty(configItem.getCivalue())) {
						configitemTB.setCicurver("0");
					} else {
						configitemTB.setCicurver("1");
					}
					IG800Info ci = ig800BL.registIG800Info(configitemTB);
					
					configitemTB = null;
					//属性类别为资产时，增加关联关系
					if("4".equals(configItem.getConfiguration().getCattach()) && StringUtils.isNotEmpty(ci.getCivalue())){
						if(map.containsKey(ci.getCid().toString())){
							IG313TB e = map.get(ci.getCid().toString());
							e.setEirid(null);
							e.setPareid(entityitem.getEid());
							e.setPareiid(entityitem.getEiid());
							e.setParversion(entityitem.getEiversion());
							e.setParsmallversion(entityitem.getEismallversion());
							e.setEirinfo(entityitem.getEiid()+"_"+ci.getCiid()+"_"+e.getCldeiid());
							this.ig313BL.registIG313Info(e);
							e = null;
						} else {
							IG313TB e = new IG313TB();
							e.setPareid(entityitem.getEid());
							e.setPareiid(entityitem.getEiid());
							e.setParversion(entityitem.getEiversion());
							e.setParsmallversion(entityitem.getEismallversion());
							String str = ci.getCivalue();
							IG013Info ei = this.ig013BL.searchIG013InfoByKey(Integer.parseInt(str.substring(str.lastIndexOf("(")+1, str.length()-1)));
							e.setCldeid(ei.getEid());
							e.setCldeiid(ei.getEiid());
							e.setCldversion(ei.getEiversion());
							e.setCldsmallversion(ei.getEismallversion());
							//双向
							String relationcode = entityitem.getEsyscoding().substring(3, 6)+"-"+ei.getEsyscoding().substring(3, 6);	
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
								condimpl.setBusinesscode_like(ei.getEsyscoding().substring(3, 6)+"-"+entityitem.getEsyscoding().substring(3, 6));
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
							String cname = configItem.getConfiguration().getCname();
							e.setEirdesc("由配置项："+cname+"建立");
							//增加key
							e.setEirinfo(entityitem.getEiid()+"_"+ci.getCiid()+"_"+ei.getEiid());
							//设置状态为C，关系管理中不可删除
							e.setEirstatus("C");
							this.ig313BL.registIG313Info(e);
							map.put(ci.getCid().toString(), e);
							ei = null;
						}
					}
				}
				entityitem = null;
				
			}		
			dto.setRelationList(label);
		}
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "资产基本信息") );
		log.debug("========设备信息登记处理终了========");
		return dto;
	}
	

	/**
	 * 获取设备编号最大值
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO searchEntityItemLableAction(IGASM03DTO dto) throws BLException {
		
		log.debug("========获取设备编号最大值处理开始========");
		
		IGASM0302Form form = dto.getIgasm0302Form();
		
		SOC0118SearchCondImpl cond = new SOC0118SearchCondImpl();
		
		cond.setEilabel(CommonDefineUtils.ENTIY_CATEGORY_DEVICE_KEY + IGStringUtils.getCurrentYear().substring(2));
		
		String eilabel = this.soc0118BL.searchNextEntityItemLable(cond);
		
		form.setEilabel(eilabel);
		
		log.debug("========获取设备编号最大值处理终了========");
		return dto;
	}
	
	/**
	 * 判断登陆用户是否是设备资产管理角色负责人
	 * 
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 * @throws BLException 
	 */
	public IGASM03DTO checkEntityItemDomain(IGASM03DTO dto) throws BLException{
		boolean isRoleManager = this.userRoleBL.checkRoleManagerByType(dto.getUser().getUserid(), EntityCategory.ROLE_TYPE_DEVICE);
		
		if(isRoleManager) {
			OrganizationSearchCondImpl orgCond = new OrganizationSearchCondImpl();
			orgCond.setOrgpar("0001");
			List<Organization> org = this.organizationBL.searchOrganization(orgCond);
			
			if(org.size() != 1) {
			    log.info("========顶级机构信息不存在！！！=======");
				throw new BLException("IGCO10000.E004","顶级机构");
			} else {
				dto.setOrgname(org.get(0).getOrgname());
				dto.setOrgsyscoding(org.get(0).getOrgsyscoding());
			}
			SOC0117SearchCondImpl entityCond = new SOC0117SearchCondImpl();
			entityCond.setEsyscoding(CommonDefineUtils.ENTIY_CATEGORY_DEVICE_SYSCODING);
			List<SOC0117Info> entity = this.soc0117BL.searchEntity(entityCond, 0, 0);
			
			if(entity.size() != 1) {
				throw new BLException("IGCO10000.E004","设备模型");
			} else {
				dto.setEname(entity.get(0).getEname());
				dto.setEsyscoding(entity.get(0).getEsyscoding());
			}
		}
		
		dto.setFlag(isRoleManager);
		
		return dto;
	}
	/**
	 * 获取历史版本更新时间
	 * @param version
	 * @return list
	 * @throws BLException
	 */
	public List<IG887Info> getVersionUpdateTime (String eiid)throws BLException{
		
		
		List<IG887Info> resultList=this.ig013BL.searchVersionUpdateTime(Integer.parseInt(eiid));
		return resultList;
	}
	
	

	/**
	 * 初始化资产配置信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGASM03DTO initXMLInfo(IGASM03DTO dto) throws BLException{
		//dto.setTreeNodeMap(parseXML(new File(dto.getFilepath())));
		dto.setTreeNodeMap(parseXML(dto.getFilepath()));
		return dto;
	}
	
	/**
	 * 查看配置信息指定结点的信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGASM03DTO readXMLNodeInfo(IGASM03DTO dto) throws BLException{
		IGASM0301Form form = dto.getIgASM0301Form();
		//dto.setInfoMap(parseXMLNode(new File(dto.getFilepath()),form.getNodeID()));
		dto.setInfoMap(parseXMLNode(dto.getFilepath(),form.getNodeID()));
		//dto.setInfoMap(parseXMLNode(new File(dto.getFilepath()),form.getNodeID()));
		return dto;
	}
	
	
	
	/**
	 * 解析配置信息XML文件中的指定结点的数据
	 * @param File
	 * @return Map<String,TreeNode> 
	 */
	@SuppressWarnings({"finally" })
	public Map<String,String> parseXMLNode(String filepath,String id) {
		Map<String,String> infoMap=new LinkedHashMap<String,String>();
		try{
			DocumentBuilderFactory domfac = DocumentBuilderFactory.newInstance();
			DocumentBuilder dombuilder = domfac.newDocumentBuilder();
		    //InputStream is = new FileInputStream(file); //从文件中取得
		    InputSource is = new InputSource(new InputStreamReader(new FileInputStream(new File(filepath)), "GBK"));
			
//			DocumentBuilderFactory domfac = DocumentBuilderFactory.newInstance();
//			DocumentBuilder dombuilder = domfac.newDocumentBuilder();
//		    InputStream is = new FileInputStream(file); //从文件中取得
		    Document doc = dombuilder.parse(is);   
		    Element root = doc.getDocumentElement();
		    NodeList nodes = root.getChildNodes();
		    String key = ASMHelper.NODE_KEY;
		    if(nodes!=null){
		    	//设置根结点
		    	TreeNode rootNode = new TreeNode();
	    	    rootNode.setId(key);
	    	    rootNode.setName(root.getNodeName());

	    	    //添加一级孩子结点
		    	for(int i=0,j=nodes.getLength();i<j;i++){
		    		Node node = nodes.item(i);
		    		
		    		if(node.getNodeType()==Node.ELEMENT_NODE && !"DATE".equals(node.getNodeName()) && !"VER".equals(node.getNodeName())){

			    	    TreeNode ptNode = new TreeNode();
			    	    key = getXMLKey(key,2);
			    		ptNode.setId(key);
			 			ptNode.setName(node.getNodeName());
			 			//检查孩子结点
			 			checkChildNodes(node,ptNode,key,3,id,infoMap);

		    		}
		    		
		    	}
		    	
		    }
		}catch(Exception e){
			log.debug("Exception:", e);
		}finally{
			return infoMap;
		}
	}
	
	/**
	 * 检查每级结点是否为选定的结点
	 * @param node	当前结点
	 * @param ptNode 上级结点
	 */
	public  void checkChildNodes(Node node,TreeNode ptNode,String key,Integer level,String id,Map<String,String> infoMap) {
		 NodeList nodes = node.getChildNodes();
		 
		 for(int i=0,j=nodes.getLength();i<j;i++){
			 Node tempnode = nodes.item(i);
			 if(tempnode.getNodeType()==Node.ELEMENT_NODE){
				 String temp_key = getXMLKey(key,level);
				 
				 TreeNode pdNode = new TreeNode();
				 pdNode.setId(temp_key);
				 pdNode.setName(tempnode.getNodeName());
				 //如果为选定结点的孩子结点则取得其内容
				 if(pdNode.getId().substring(0, id.length()).equals(id) && pdNode.getId().length()>id.length()){
					 infoMap.put(tempnode.getNodeName(), tempnode.getTextContent());
				 }

				 if(tempnode.getChildNodes().getLength()>0 && level <= 3){
					 checkChildNodes(tempnode,pdNode,pdNode.getId(),(level+1),id,infoMap);
				 }
				 ptNode.addChildTreeNode(pdNode.getId(),pdNode); 
				 
				 key = getXMLKey(key,level);
			 }
		 }
	}
	
	
	/**
	 * 解析配置信息XML文件中的数据
	 * @param File
	 * @return Map<String,TreeNode> 
	 */
	@SuppressWarnings({"finally" })
	public Map<String,TreeNode> parseXML(File file) {
		Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
		try{
			DocumentBuilderFactory domfac = DocumentBuilderFactory.newInstance();
			DocumentBuilder dombuilder = domfac.newDocumentBuilder();
		    InputStream is = new FileInputStream(file); //从文件中取得
		    Document doc = dombuilder.parse(is);   
		    Element root = doc.getDocumentElement();
		    NamedNodeMap rootmap = root.getAttributes();//root结点的属性集合
		    NodeList nodes = root.getChildNodes();
		    String key = ASMHelper.NODE_KEY;
		    if(nodes!=null){
		    	//设置根结点
		    	TreeNode rootNode = new TreeNode();
	    	    rootNode.setId(key);
	    	    String tmp = "";
	    	    if(rootmap!=null && rootmap.getLength()>0){
	    	    	tmp = rootmap.getNamedItem("label").getNodeValue();
	    	    }
	    	    rootNode.setName(root.getNodeName()+"_"+tmp);

	    	    //添加一级孩子结点
		    	for(int i=0,j=nodes.getLength();i<j;i++){
		    		Node node = nodes.item(i);
		    		
		    		if(node.getNodeType()==Node.ELEMENT_NODE && !"DATE".equals(node.getNodeName()) && !"VER".equals(node.getNodeName())){
		    			NamedNodeMap nodemap = node.getAttributes();//当前结点的属性集合
		    			
			    	    TreeNode ptNode = new TreeNode();
			    	    key = getXMLKey(key,2);
			    		ptNode.setId(key);
			    		if(nodemap!=null && nodemap.getLength()>0){
			    			ptNode.setName(nodemap.getNamedItem("label").getNodeValue());
			    		}else{
			    			ptNode.setName(node.getNodeName());
			    		}
			 			
			 			
			 			//添加孩子结点
			 			getChildNodes(node,ptNode,key,3);
			 			rootNode.addChildTreeNode(ptNode.getId(), ptNode);
		    		}
		    		
		    	}
		    	treeNodeMap.put(rootNode.getId(),rootNode);
		    	
		    }
		}catch(Exception e){
			log.debug("Exception:", e);
		}finally{
			return treeNodeMap;
		}
	}
	
	/**
	 * 取得下级结点
	 * @param node	当前结点
	 * @param ptNode 上级结点
	 */
	public  void getChildNodes(Node node,TreeNode ptNode,String key,Integer level) {
		 NodeList nodes = node.getChildNodes();
		 
		 for(int i=0,j=nodes.getLength();i<j;i++){
			 Node tempnode = nodes.item(i);
			 if(tempnode.getNodeType()==Node.ELEMENT_NODE){
				 NamedNodeMap nodemap = tempnode.getAttributes();//当前结点的属性集合
				 
				 String temp_key = getXMLKey(key,level);
				 TreeNode pdNode = new TreeNode();
				 pdNode.setId(temp_key);
				 if(nodemap!=null && nodemap.getLength()>0){
					 pdNode.setName(nodemap.getNamedItem("label").getNodeValue());
				 }else{
					 pdNode.setName(tempnode.getNodeName());
				 }
				 
				 String temp_name = pdNode.getName().replace("'", "");
				 pdNode.setName(temp_name);
				 
				 
				 //只取前3级的结点作为组成树的元素
				 if(tempnode.getChildNodes().getLength()>0 && level <= 3){
					getChildNodes(tempnode,pdNode,pdNode.getId(),(level+1));
				 }
				 if(level <= 3){
					//代表为COMMAND级别
					ptNode.addChildTreeNode(pdNode.getId(),pdNode); 
				 }
				 key = getXMLKey(key,level);
			 }
		 }
	}
	
	/**
	 * 取得各结点的唯一ID(每3位为一级)
	 * @param String key
	 * @param String level
	 * @return String
	 */
	public static synchronized String getXMLKey(String key,Integer level){
		String syscode = key;
		String temp = "";
		if(key.length()>=(level*3)){
			temp = key.substring(key.length()-3);	
			if("0".equals(temp.substring(0, 1))){//0**
				String tmp = String.valueOf(Integer.valueOf(temp)+1);
				if(tmp.length()==1){
					temp = "00"+tmp;
				}else if(tmp.length()==2){
					temp = "0"+tmp;
				}else{
					temp = tmp;
				}
				syscode = syscode.substring(0,syscode.length()-3)+temp;
			}else{//***
				syscode = syscode.substring(0,syscode.length()-3)+String.valueOf(Integer.valueOf(temp)+1);
			}
		}else{
			syscode = key + "001";
		}

		return syscode;
	 }
	

	
	
	/**
	 * 解析配置信息XML文件中的数据
	 * @param File
	 * @return Map<String,TreeNode> 
	 */
	@SuppressWarnings({"finally" })
	public Map<String,TreeNode> parseXML(String filepath) {
		Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
		try{
			DocumentBuilderFactory domfac = DocumentBuilderFactory.newInstance();
			DocumentBuilder dombuilder = domfac.newDocumentBuilder();
			
		    //InputStream is = new FileInputStream(file); //从文件中取得
			InputSource is = new InputSource(new InputStreamReader(new FileInputStream(new File(filepath)), "GBK"));
		    Document doc = dombuilder.parse(is);   
		    Element root = doc.getDocumentElement();
		    NamedNodeMap rootmap = root.getAttributes();//root结点的属性集合
		    NodeList nodes = root.getChildNodes();
		    String key = ASMHelper.NODE_KEY;
		    if(nodes!=null){
		    	//设置根结点
		    	TreeNode rootNode = new TreeNode();
	    	    rootNode.setId(key);
	    	    String tmp = "";//HOST Name
	    	    String tmp_type = "";//AIX etc.
	    	    if(rootmap!=null && rootmap.getLength()>0){
	    	    	if(rootmap.getNamedItem("label")!=null){
	    	    		tmp = rootmap.getNamedItem("label").getNodeValue();
	    	    	}
	    	    	if(rootmap.getNamedItem("type")!=null){
	    	    		tmp_type = rootmap.getNamedItem("type").getNodeValue();
	    	    	}
	    	    	
	    	    	
	    	    }
	    	    if(StringUtils.isNotEmpty(tmp_type) && StringUtils.isNotEmpty(tmp)){
	    	    	rootNode.setName(tmp_type+"-"+tmp);
	    	    }else if(StringUtils.isEmpty(tmp_type) && StringUtils.isNotEmpty(tmp)){
	    	    	rootNode.setName(tmp);	
	    	    }else if(StringUtils.isEmpty(tmp) && StringUtils.isNotEmpty(tmp_type)){
	    	    	rootNode.setName(tmp_type);	
	    	    }else{
	    	    	rootNode.setName("Host");	
	    	    }
	    	    
	    	    

	    	    //添加一级孩子结点
		    	for(int i=0,j=nodes.getLength();i<j;i++){
		    		Node node = nodes.item(i);
		    		if(node.getNodeType()==Node.ELEMENT_NODE && !"DATE".equals(node.getNodeName().toUpperCase()) && !"VER".equals(node.getNodeName().toUpperCase()) && !"RELATION".equals(node.getNodeName().toUpperCase())){
		    			NamedNodeMap nodemap = node.getAttributes();
		    			
			    	    TreeNode ptNode = new TreeNode();
			    	    key = getXMLKey(key,2);
			    		ptNode.setId(key);
			    		if(nodemap!=null && nodemap.getNamedItem("label")!=null){
			    			ptNode.setName(nodemap.getNamedItem("label").getNodeValue());
			    		}else{
			    			ptNode.setName(node.getNodeName());
			    		}
			 			
			 			
			 			//添加孩子结点
			 			getChildNodes(node,ptNode,key,3);
			 			String temp_name = ptNode.getName().replace("'", "");
			 			ptNode.setName(temp_name);
			 			rootNode.addChildTreeNode(ptNode.getId(), ptNode);
		    		}
		    		
		    	}
		    	treeNodeMap.put(rootNode.getId(),rootNode);
		    	
		    }
		}catch(Exception e){
			log.debug("Exception:", e);
		}finally{
			return treeNodeMap;
		}
	}
	

	
	
	/**
	 * 比较2个版本配置信息XML中的数据(两个XML文件中的SCETION必需一样才能进行比较)
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGASM03DTO compareXMLInfoByVersion(IGASM03DTO dto) throws BLException{
		
		//取得第1个版本的数据
		//dto = searchXMLInfo(new File(dto.getFilepath()),dto);
		dto = searchXMLInfo(dto.getFilepath(),dto);
		List<String> section_list = new ArrayList<String>();
	    Map<String,List<TreeNode>> command_map_1 = dto.getCommand_map();
	    
	    //取得第2个版本的数据
		//dto = searchXMLInfo(new File(dto.getOtherfilepath()),dto);
		dto = searchXMLInfo(dto.getOtherfilepath(),dto);
	    Map<String,List<TreeNode>> command_map_2 = dto.getCommand_map();
	    
	    //比较数据
		Set<Map.Entry<String,List<TreeNode>>> set_1 = command_map_1.entrySet();
		
		List<String> new_command_list1 = new ArrayList<String>();
		List<String> new_command_list2 = new ArrayList<String>();
		List<String> new_output_list1 = new ArrayList<String>();
		List<String> new_output_list2 = new ArrayList<String>();
		List<String> command_color_list = new ArrayList<String>();//0不变色 1变色
		List<String> output_color_list = new ArrayList<String>();//0不变色 1变色
		
		for(Iterator<Map.Entry<String,List<TreeNode>>> iter = set_1.iterator();iter.hasNext();){
			Map.Entry<String,List<TreeNode>> entry_1 = iter.next();
			String section =  entry_1.getKey();//eitype: HOST HBA etc.
			
			List<TreeNode> list1 = entry_1.getValue();
			List<TreeNode> list2 = command_map_2.get(section);
			
			
			//设置SECTION
			if(list2==null ||(list1!=null &&  list1.size()>=list2.size())){
				for(TreeNode node:list1){
					section_list.add(section);
				}
			}else{
				for(TreeNode node:list2){
					section_list.add(section);
				}
			}
			
				//以一个版本为出发点比较与另一个版本中的区别
				if(list1!=null){
					for(int i=0,j=list1.size();i<j;i++){
						TreeNode node1 = list1.get(i);
						boolean flag = true;
						boolean flag2 = true;
						
						//比较command
						if(list2!=null){
							for(int m=0,n=list2.size();m<n;m++){
								TreeNode node2 = list2.get(m);	
								if(node1!=null && node1.getName()!=null && 
										node2!=null && node2.getName()!=null){
									if(node1.getName().equals(node2.getName())){
										//当command1等于command2时，直接将当前command保存到自己新的list中
										new_command_list1.add(node1.getName());
										new_command_list2.add(node2.getName());
										flag = false;
										command_color_list.add("0");
										break;
									}
								}
								
							}
						}
						
						
						if(flag){
							//当command2不存在于list1中并且new_command_list2不包含command2时，在new_command_list2中添加一个空行，并设置变色
							new_command_list1.add(node1.getName());
							new_command_list2.add("");
							command_color_list.add("1");
						}
	
						//比较output
						if(list2!=null){
							for(int m=0,n=list2.size();m<n;m++){
								TreeNode node2 = list2.get(m);
								
								if(node1!=null && node1.getBelong()!=null && 
										node2!=null && node2.getBelong()!=null){
									if(node1.getBelong().equals(node2.getBelong())){
										new_output_list1.add(node1.getBelong());
										new_output_list2.add(node2.getBelong());
										flag2 = false;
										output_color_list.add("0");
										break;
									}
								}
								
								
							}
						}
						
						
						if(flag2){
							//当output2不存在于list1中并且new_output_list1不包含output2时，在new_output_list2中添加一个空行，并设置变色
							new_output_list1.add(node1.getBelong());
							String out_put = "";
							if(list2!=null){
								for(int m=0,n=list2.size();m<n;m++){
									TreeNode node2 = list2.get(m);	
									if(node1!=null && node1.getName()!=null && 
											node2!=null && node2.getName()!=null){
										if(node1.getName().equals(node2.getName())){
											//当command1等于command2时，保存输出内容
											out_put = node2.getBelong();
											break;
										}
									}
								}
								
							}
							new_output_list2.add(out_put);
							output_color_list.add("1");
						}
						
					}
				}
				

				//以另一个版本为出发点比较区别
				if(list2!=null){
					for(int i=0,j=list2.size();i<j;i++){
						TreeNode node2 = list2.get(i);
						boolean flag = true;
						boolean flag2 = true;
						
						
						if(node2!=null && node2.getName()!=null){
							String command = node2.getName();
							if(!new_command_list2.contains(command) && !new_command_list1.contains(command)){
								//比较command
								if(list1!=null){
									for(int m=0,n=list1.size();m<n;m++){
										TreeNode node1 = list1.get(m);
										if(node1!=null && node1.getName()!=null && 
												node2!=null && node2.getName()!=null){
											if(node2.getName().equals(node1.getName())){
												//new_command_list1.add(node1.getName());
												//new_command_list2.add(node2.getName());
												//command_color_list.add("0");
												flag = false;
												break;
											}
										}
										
									}
								}
								
								if(flag){
									new_command_list1.add("");
									new_command_list2.add(node2.getName());
									command_color_list.add("1");
								}
								
								//比较output
								if(list1!=null){
									for(int m=0,n=list1.size();m<n;m++){
										TreeNode node1 = list1.get(m);
										if(node1!=null && node1.getBelong()!=null && 
												node2!=null && node2.getBelong()!=null){
											if(node2.getBelong().equals(node1.getBelong())){
												//new_output_list1.add(node1.getBelong());
												//new_output_list2.add(node2.getBelong());
												//output_color_list.add("0");
												flag2 = false;
												break;
											}
										}
										
									}
								}
								
								if(flag2){
									String out_put = "";
									if(list1!=null){
										for(int m=0,n=list1.size();m<n;m++){
											TreeNode node1 = list1.get(m);
											if(node1!=null && node1.getName()!=null && 
													node2!=null && node2.getName()!=null){
												if(node1.getName().equals(node2.getName())){
													//当command1等于command2时，保存输出内容
													out_put = node1.getBelong();
													break;
												}
											}
										}
										
									}
									
									new_output_list1.add(out_put);
									new_output_list2.add(node2.getBelong());
									output_color_list.add("1");
								}
							}
							
						}

						
					}
				}
				
			
		}

		//保存比较后的数据
	    dto.setSection_list(section_list);
	    dto.setCommand_list1(new_command_list1);
	    dto.setCommand_list2(new_command_list2);
	    dto.setOutput_list1(new_output_list1);
	    dto.setOutput_list2(new_output_list2);
	    dto.setCommand_color_list(command_color_list);
	    dto.setOutput_color_list(output_color_list);
	    
		return dto;
	}
	
	/**
	 * 从XML文件中取得需要的数据
	 * @param File
	 * @param IGASM03DTO
	 * @return IGASM03DTO
	 */
	@SuppressWarnings({"finally" })
	public IGASM03DTO searchXMLInfo(String filepath,IGASM03DTO dto) {
		try{
			
			DocumentBuilderFactory domfac = DocumentBuilderFactory.newInstance();
			DocumentBuilder dombuilder = domfac.newDocumentBuilder();
		    //InputStream is = new FileInputStream(file); //从文件中取得
		    InputSource is = new InputSource(new InputStreamReader(new FileInputStream(new File(filepath)), "GBK"));
//			DocumentBuilderFactory domfac = DocumentBuilderFactory.newInstance();
//			DocumentBuilder dombuilder = domfac.newDocumentBuilder();
//		    InputStream is = new FileInputStream(file); //从文件中取得
		    Document doc = dombuilder.parse(is);   
		    Element root = doc.getDocumentElement();
		    NodeList nodes = root.getChildNodes();
		    //List<String> section_list = new ArrayList<String>();
		    Map<String,List<TreeNode>> command_map = new LinkedHashMap<String,List<TreeNode>>();
		    if(nodes!=null){
		    	for(int i=0,j=nodes.getLength();i<j;i++){
			    	//取得所有SECTION NODE
		    		Node node = nodes.item(i);
		    		//NamedNodeMap nodemap1 = node.getAttributes();
//		    		if(nodemap1!=null && nodemap1.getLength()>0){
//		    			System.out.println("name==="+node.getNodeName()+"----"+nodemap1.getNamedItem("label").getNodeValue());
//		    		}
		    		
		    		if(node.getNodeType()==Node.ELEMENT_NODE && !"DATE".equals(node.getNodeName()) && !"VER".equals(node.getNodeName())){
		    			List<TreeNode> commandList = new ArrayList<TreeNode>();
		    			//保存SECTION
		    			NamedNodeMap nodemap = node.getAttributes();//当前结点的属性集合
		    			String section_name = "";
		    			if(nodemap!=null && nodemap.getLength()>0){
		    				section_name = nodemap.getNamedItem("label").getNodeValue();
		    			}else{
		    				section_name = node.getNodeName();
		    			}
		    			
		    			//section_list.add(section_name);
			 			NodeList commandnodes = node.getChildNodes();
			 			//取得COMMAND
			 			for(int m=0,n=commandnodes.getLength();m<n;m++){
			 				Node commandnode = commandnodes.item(m);
			 				if(commandnode.getNodeType()==Node.ELEMENT_NODE){
			 					TreeNode pdNode = new TreeNode();
			 					//保存COMMAND
			 					NamedNodeMap commandnodemap = commandnode.getAttributes();//当前结点的属性集合
			 					String command_LBL = "";
			 					if(commandnodemap!=null && commandnodemap.getLength()>0){
			 						command_LBL = commandnodemap.getNamedItem("label").getNodeValue();
			 					}
			 					
			 					
//			 					NodeList lblnodes = commandnode.getChildNodes();
//			 					for(int x=0,y=lblnodes.getLength();x<y;x++){
//			 						Node temp = lblnodes.item(x);
//			 						if(temp.getNodeType()==Node.ELEMENT_NODE && "RUN_CMD".equals(temp.getNodeName())){
//			 							command_LBL = temp.getTextContent();
//			 						}
//			 					}
			 					pdNode.setName(command_LBL);
			 					//System.out.println("command==="+command_LBL);
				 				NodeList outputnodes = commandnode.getChildNodes();
				 				//取得OUTPUT
				 				for(int x=0,y=outputnodes.getLength();x<y;x++){
				 					Node outputnode = outputnodes.item(x);
				 					//判断当前结点是否为页面选择的结点
				 					if(outputnode.getNodeType()==Node.ELEMENT_NODE && "OUTPUT".equals(outputnode.getNodeName())){
				 						//保存OUTPUT
				 						pdNode.setBelong(outputnode.getTextContent());
				 						//System.out.println("OUTPUT==="+outputnode.getTextContent());
				 					}
				 					
				 				}
				 				commandList.add(pdNode);
			 				}
			 			}
			 			
			 			//为section补相同section_name的行
//			 			int num = commandList.size()-1;
//			 			for(int m=0,n=num;m<n;m++){
//			 				section_list.add(section_name);
//			 			}
			 			
			 			command_map.put(section_name, commandList);
		    		}
		    		
		    	}
		    	dto.setCommand_map(command_map);
		    	//dto.setSection_list(section_list);
		    }
		}catch(Exception e){
			log.debug("Exception:", e);
		}finally{
			return dto;
		}
	}

	/**
	 * @param ig912BL the ig912BL to set
	 */
	public void setIg912BL(IG912BL ig912BL) {
		this.ig912BL = ig912BL;
	}
	
	/**
	 * 设备关系管理POP画面初期化处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 * @update 0000201
	 */
	public IGASM03DTO initIGASM1110Action(IGASM03DTO dto) throws BLException {
		log.debug("========设备关系管理画面初期化处理开始========");
		
		//设备信息检索
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(
				Integer.parseInt(dto.getIgasm0306Form().getEiid()));
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","设备");
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
		
		parcond.setEiid(dto.getIgasm0306Form().getEiid());
		parcond.setParversion(entityItemVWInfo.getEiversion());
		parcond.setParsmallversion(entityItemVWInfo.getEismallversion());
		parcond.setDeleteflag("0");
		
		Map<String,List<SOC0119Info>> parmap = new LinkedHashMap<String,List<SOC0119Info>>();
		//设备关系信息查询件数取得 
		int totalCount = this.soc0119BL.getEntityItemRelationSearchCount(parcond);
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========设备关系信息查询数据件数过多========");
			//设备关系信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		if ( totalCount>0 ) {
			//设备关系信息全件检索
			List<SOC0119Info> parEntityItemRelationList = 
				this.soc0119BL.searchEntityItemRelation(parcond, 0, 0);
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
//		IG313SearchCondImpl cldcond = new IG313SearchCondImpl();
//		
//		cldcond.setCldeiid(dto.getIgasm0306Form().getEiid());
//		cldcond.setCldversion(entityItemVWInfo.getEiversion().toString());
//		cldcond.setCldsmallversion(entityItemVWInfo.getEismallversion().toString());
//		cldcond.setDeleteflag("0");
//		
//		//设备关系信息查询件数取得 
//		totalCount = this.ig313BL.getIG313InfoSearchCount(cldcond);
//		
//		if ( totalCount > dto.getMaxSearchCount() ) {
//			log.debug("========设备关系信息查询数据件数过多========");
//			//设备关系信息查询数据件数过多
//			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
//			return dto;
//		}
//
//		//设备关系信息全件检索
//		List<IG313Info> cldEntityItemRelationList = 
//			this.ig313BL.searchIG313Info(
//					cldcond, 0, 0);
//		dto.setParCount(dto.getParCount()+cldEntityItemRelationList.size());
////		dto.addMessage(new ActionMessage("IGCO10000.I007",dto.getParCount()));
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

		log.debug("========设备关系管理画面初期化处理终了========");
		return dto;
	}
	

	
	
	
}
