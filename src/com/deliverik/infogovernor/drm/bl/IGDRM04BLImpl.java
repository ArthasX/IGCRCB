/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.bl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;
import org.apache.struts.util.LabelValueBean;
import org.springframework.beans.BeanUtils;

import com.deliverik.framework.asset.bl.task.IG611BL;
import com.deliverik.framework.asset.model.IG612Info;
import com.deliverik.framework.asset.model.condition.IG611SearchCondImpl;
import com.deliverik.framework.asset.model.condition.IG912SearchCondImpl;
import com.deliverik.framework.asset.model.entity.IG013TB;
import com.deliverik.framework.asset.model.entity.IG611TB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.bl.FileUploadBL;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.soc.asset.bl.task.SOC0107BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0107VWBL;
import com.deliverik.framework.soc.asset.bl.task.SOC0109BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0109VWBL;
import com.deliverik.framework.soc.asset.bl.task.SOC0117BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0117VWBL;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0118VWBL;
import com.deliverik.framework.soc.asset.bl.task.SOC0119BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0151BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0151VWBL;
import com.deliverik.framework.soc.asset.model.ConfigurationCodeDetailBean;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.SOC0109Info;
import com.deliverik.framework.soc.asset.model.SOC0109VWInfo;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.framework.soc.asset.model.SOC0117VWInfo;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0118VWInfo;
import com.deliverik.framework.soc.asset.model.SOC0119Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.framework.soc.asset.model.SOC0151Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0107SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0109SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0109VWSearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0117SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0117VWSearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0118SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0118VWSearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0119SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0129SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0151SearchCondImpl;
import com.deliverik.framework.soc.asset.model.entity.SOC0107TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0109TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0117TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0117VWPK;
import com.deliverik.framework.soc.asset.model.entity.SOC0118TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0118VWPK;
import com.deliverik.framework.soc.asset.model.entity.SOC0119TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0129VW;
import com.deliverik.framework.soc.asset.model.entity.SOC0151TB;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.bl.task.OrganizationBL;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.condition.OrganizationSearchCondImpl;
import com.deliverik.framework.utility.BLErrorType;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.asset.bl.IGASM05BLImpl;
import com.deliverik.infogovernor.drm.bl.task.EmergencyResourceBL;
import com.deliverik.infogovernor.drm.bl.task.ErRelationBL;
import com.deliverik.infogovernor.drm.dto.IGDRM04DTO;
import com.deliverik.infogovernor.drm.form.IGDRM0401Form;
import com.deliverik.infogovernor.drm.form.IGDRM0402Form;
import com.deliverik.infogovernor.drm.form.IGDRM0404Form;
import com.deliverik.infogovernor.drm.form.IGDRM0406Form;
import com.deliverik.infogovernor.drm.form.IGDRM0408Form;
import com.deliverik.infogovernor.drm.form.IGDRM0411Form;
import com.deliverik.infogovernor.drm.form.IGDRM0412Form;
import com.deliverik.infogovernor.drm.form.IGDRM0414Form;
import com.deliverik.infogovernor.drm.form.IGDRM0418Form;
import com.deliverik.infogovernor.drm.form.IGDRM0421Form;
import com.deliverik.infogovernor.drm.form.IGDRM0424Form;
import com.deliverik.infogovernor.drm.form.IGDRM0430Form;
import com.deliverik.infogovernor.drm.model.EmergencyResourceInfo;
import com.deliverik.infogovernor.drm.model.ErRelationInfo;
import com.deliverik.infogovernor.drm.model.condition.EmergencyResourceSearchCondImpl;
import com.deliverik.infogovernor.drm.model.condition.ErRelationSearchCondImpl;
import com.deliverik.infogovernor.drm.model.entity.EmergencyResourceTB;
import com.deliverik.infogovernor.drm.model.entity.ErRelationTB;
import com.deliverik.infogovernor.sym.bl.IGSYM01BL;
import com.deliverik.infogovernor.sym.bl.IGSYM02BL;
import com.deliverik.infogovernor.sym.dto.IGSYM01DTO;
import com.deliverik.infogovernor.sym.dto.IGSYM02DTO;
import com.deliverik.infogovernor.util.DateUtils;
import com.google.gson.Gson;

/**
 * 应急资源管理BL实现
 * 
 * @author 张剑
 *
 * 2015-2-12 上午11:07:19
 */
public class IGDRM04BLImpl implements IGDRM04BL {
	
	static Log log = LogFactory.getLog(IGDRM04BLImpl.class);
	
	protected SOC0118BL soc0118BL;
	
	protected SOC0117BL soc0117BL;
	
	protected SOC0109BL soc0109BL;
	
	protected SOC0107BL soc0107BL;
	
	protected SOC0118VWBL soc0118VWBL;
	
	protected SOC0117VWBL soc0117VWBL;
	
	protected SOC0109VWBL soc0109VWBL;
	
	protected SOC0107VWBL soc0107VWBL; 
	
	protected SOC0151VWBL soc0151VWBL;
	/** 文件上传BL */
	protected FileUploadBL fileUploadBL;
	
	protected OrganizationBL organizationBL;
	
	protected SOC0119BL soc0119BL;
	
	protected SOC0151BL soc0151BL;
	
	protected CodeDetailBL codeDetailBL;

	/** 应急资源资产关系BL */
	protected ErRelationBL erRelationBL;

	/** 应急资源资模型BL */
	protected EmergencyResourceBL emergencyResourceBL;
	
	

	/**
	 * @param soc0151vwbl the soc0151VWBL to set
	 */
	public void setSoc0151VWBL(SOC0151VWBL soc0151vwbl) {
		soc0151VWBL = soc0151vwbl;
	}

	/**
	 * @param soc0118vwbl the soc0118VWBL to set
	 */
	public void setSoc0118VWBL(SOC0118VWBL soc0118vwbl) {
		soc0118VWBL = soc0118vwbl;
	}

	/**
	 * @param soc0117vwbl the soc0117VWBL to set
	 */
	public void setSoc0117VWBL(SOC0117VWBL soc0117vwbl) {
		soc0117VWBL = soc0117vwbl;
	}

	/**
	 * @param soc0109vwbl the soc0109VWBL to set
	 */
	public void setSoc0109VWBL(SOC0109VWBL soc0109vwbl) {
		soc0109VWBL = soc0109vwbl;
	}

	/**
	 * @param soc0107vwbl the soc0107VWBL to set
	 */
	public void setSoc0107VWBL(SOC0107VWBL soc0107vwbl) {
		soc0107VWBL = soc0107vwbl;
	}

	/**
	 * @param soc0151bl the soc0151BL to set
	 */
	public void setSoc0151BL(SOC0151BL soc0151bl) {
		soc0151BL = soc0151bl;
	}

	/**
	 * @param erRelationBL the erRelationBL to set
	 */
	public void setErRelationBL(ErRelationBL erRelationBL) {
		this.erRelationBL = erRelationBL;
	}

	/**
	 * @param emergencyResourceBL the emergencyResourceBL to set
	 */
	public void setEmergencyResourceBL(EmergencyResourceBL emergencyResourceBL) {
		this.emergencyResourceBL = emergencyResourceBL;
	}

	/**
	 * 初始化应急资源新增页面
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM04DTO init0401Action(IGDRM04DTO dto) throws BLException{
		
		log.info("==========应急资源登记初始化开始============");
		
		
//		Integer eiid = dto.getIgdrm0401Form().getEiid();
		String eiid = dto.getIgdrm0401Form().getEiidstr();
		IGDRM0401Form form = new IGDRM0401Form();
		form.setEiid(Integer.parseInt(eiid.split("_")[1]));
		form.setEiidstr(eiid);
		if(StringUtils.isNotEmpty(eiid)){
			SOC0118VWInfo soc0124 = soc0118VWBL.searchEntityItemByKey(new SOC0118VWPK(Integer.parseInt((eiid+"").split("_")[0]), Integer.parseInt((eiid+"").split("_")[1])));
			SOC0129SearchCondImpl cond = new SOC0129SearchCondImpl();
			cond.setId((eiid+"").split("_")[0]);
			cond.setEiid((eiid+"").split("_")[1]);
			cond.setEsyscoding_q(soc0124.getEsyscoding());
			List<SOC0129Info> soc0129List = soc0107BL.searchConfigItemVW(cond);
			dto.setConfigItemList(soc0129List);
			dto.setEntityItemVW(soc0124);
			form.setEiname(soc0124.getEiname());
			form.setEilabel(soc0124.getEilabel());
			form.setEiinsdate(soc0124.getEiinsdate());
			form.setEsyscoding(soc0124.getEsyscoding());
			dto.setIgdrm0401Form(form);
		}else{
			String eid = "CM40000000";
			SOC0109VWSearchCondImpl cond = new SOC0109VWSearchCondImpl();
			cond.setEid(eid);
			List<SOC0109VWInfo> soc0119List = soc0109VWBL.searchConfiguration(cond);
			dto.setConfigurationList(soc0119List);
		}
		
		
		log.info("==========应急资源登记初始化结束============");
		
		return dto;
	}
	
	/**
	 * 应急资源配置信息编辑画面初期化处理
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO initIGDRM0404Action(IGDRM04DTO dto) throws BLException {

		log.debug("========应急资源配置信息编辑画面初期化处理开始========");
		
		IGDRM0404Form form = dto.getIgdrm0404Form();
		
		//应急资源信息检索
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(
				Integer.parseInt(form.getEiid()));
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","应急资源");
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
//		dto.setEntityItemVW(entityItemVWInfo);
		//判断登陆用户是否有查看该资产配置信息的权限
		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(), entityItemVWInfo);

		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}else{
			dto.setFlag(flag);
		}
		
		
		//应急资源配置信息查询件数取得 
		int totalCount = this.soc0107BL.getConfigItemVWSearchCount(form);
		
		if (totalCount == 0) {
			log.debug("========应急资源配置信息查询数据不存在========");
			//应急资源配置信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I007",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========应急资源配置信息查询数据件数过多========");
			//应急资源配置信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//应急资源配置信息全件查询
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
					List<SOC0119Info> soc0119Info = soc0119BL.searchEntityItemRelation(cond);
					String cldversion="";
					if(soc0119Info!=null&&soc0119Info.size()>0){
						cldversion = String.valueOf(soc0119Info.get(0).getCldversion());//子资产版本
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


		
		log.debug("========应急资源配置信息编辑画面初期化处理终了========");
		return dto;
	}
	/**
	 * 设备配置信息编辑画面初期化处理
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO initIGDRM0430Action(IGDRM04DTO dto) throws BLException {

		log.debug("========设备配置信息编辑画面初期化处理开始========");
		
		IGDRM0430Form form = dto.getIgdrm0430Form();
		String eiidstr = form.getEiid();
		String id = form.getId();
		//设备信息检索
		SOC0118VWInfo entityItemVWInfo = soc0118VWBL.searchEntityItemByKey(new SOC0118VWPK(Integer.parseInt(id), Integer.parseInt(eiidstr)));

		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","设备");
		}
		
		form.setEidesc(entityItemVWInfo.getEidesc());
		form.setEistatus(entityItemVWInfo.getEistatus());
//		form.setEmodeltype(entityItemVWInfo.getEmodeltype());
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
		Boolean flag = this.soc0118VWBL.checkEntityItemDomain(dto.getUser(), entityItemVWInfo);

		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}else{
			dto.setFlag(flag);
		}
		
		
		//设备配置信息查询件数取得 
		int totalCount = this.soc0107VWBL.getConfigItemVWSearchCount(form);
		
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
		List<SOC0129Info> configItemVWInfoList = this.soc0107VWBL.searchConfigItemVW(
				form, 0, 0);
		
		String[] civalue = new String[totalCount];
		String[] delfile = new String[totalCount];
		String[] entityItemCivalue = new String[totalCount];
		String[] isUpgrade=new String[totalCount];
		//存放旧版本值
		String[] civalue_bak = new String[totalCount];
		Map<String,List<SOC0129Info>> map = new LinkedHashMap<String,List<SOC0129Info>>();
		int i = 0;
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
					cond.setParversion(Integer.parseInt(entityItemVWInfo.getEiversion()));
					cond.setEirinfo("_"+e.getCiid()+"_");
					cond.setDeleteflag("0");
//					List<SOC0119VWInfo> ig313Info = soc0119VWBL.searchEntityItemRelation(cond);
//					String cldversion="";
//					if(ig313Info!=null&&ig313Info.size()>0){
//						cldversion = String.valueOf(ig313Info.get(0).getCldversion());//子资产版本
//					}
//					cldVersionMap.put(cldeiid, cldversion);
				}
			}
			if(!map.containsKey(e.getCcategory())){
				map.put(e.getCcategory(), new ArrayList<SOC0129Info>());
				strlist.add(e.getCcategory());
			}
			map.get(e.getCcategory()).add(e);
//			if("IG_0012".equals(e.getClabel())){
//				List<LabelValueBean> list = new ArrayList<LabelValueBean>();
//				list.add(new LabelValueBean("", ""));
//				SOC0601SearchCondImpl soc0601cond = new SOC0601SearchCondImpl();
//				List<SOC0601Info> soc0601List = soc0601BL.searchSOC0601Info(soc0601cond);
//				for(SOC0601Info ccd : soc0601List){
//					list.add(new LabelValueBean(ccd.getEiname(), ccd.getEiname()));
//				}
//				form.setSelectedListMap(j++, list);
//				continue;
//			}
//			
//			if("IG_0013".equals(e.getClabel())){
//				List<LabelValueBean> list = new ArrayList<LabelValueBean>();
//				if(e.getCivalue()!=null && !(e.getCivalue().equals(""))){
//					dto.setArea(e.getCivalue());					
//				}
//				form.setSelectedListMap(j++, list);
//				continue;
//			}
//			if("IG_0014".equals(e.getClabel())){
//				List<LabelValueBean> list = new ArrayList<LabelValueBean>();
//				list.add(new LabelValueBean("", ""));
//				SOC0603SearchCondImpl soc0603cond = new SOC0603SearchCondImpl();
//				List<SOC0603Info> soc0603List = soc0603BL.searchSOC0603Info(soc0603cond);
//				for(SOC0603Info ccd : soc0603List){
//					list.add(new LabelValueBean(ccd.getEiname(), ccd.getEiname()));
//				}
//				form.setSelectedListMap(j++, list);
//				continue;
//			}
			if("2".equals(e.getCattach())){
//				List<LabelValueBean> list = soc0151BL.searchLabelValueBeanList(e.getCoption());
//				form.setSelectedListMap(j++, list);
			}
			if("5".equals(e.getCattach())){
//				List<LabelValueBean> list = soc0151BL.searchLabelValueBeanList(e.getCoption());
//				if(list.size() > 0){
//					list.remove(0);
//				}
//				form.setSelectedListMap(j++, list);
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
		if(Integer.parseInt(entityItemVWInfo.getEiversion()) > 0) {
//			dto.setConfigItemVersionTime(this.soc0118VWBL.searchVersionUpdateTime(entityItemVWInfo.getEiid()));
		}

    	IG912SearchCondImpl cond = new IG912SearchCondImpl();
    	cond.setInJiguiFlg("Y");
    	cond.setEiid(Integer.parseInt(form.getEiid()));
		//当前页设备信息取得
//		List<IG912Info> computerDeviceVWInfoList = ig912BL.searchIG912Info(cond,0,0);
//		if(computerDeviceVWInfoList!=null&&computerDeviceVWInfoList.size()>0){
//			dto.setInJiguiFlg("Y");
//		}else{
//			dto.setInJiguiFlg("N");
//		}
		log.debug("========设备配置信息编辑画面初期化处理终了========");
		return dto;
	}
	/***
	 * 查询应急资源属性列表
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM04DTO searchConfigList(IGDRM04DTO dto) throws BLException{//0129qwer
		log.info("==========应急资源属性列表获取开始============");
		
		IGDRM0401Form form = dto.getIgdrm0401Form();
//		Integer eiid = form.getEiid();
		String eiidstr = form.getEiidstr();
			////查询 所有属性
			String esyscoding = form.getEsyscoding();
			if(StringUtils.isEmpty(esyscoding)){
				SOC0118VWInfo info = soc0118VWBL.searchEntityItemByKey(new SOC0118VWPK(Integer.parseInt(eiidstr.split("_")[0]), Integer.parseInt(eiidstr.split("_")[1])));
				esyscoding = info.getEsyscoding();
			}
			SOC0109VWSearchCondImpl cond = new SOC0109VWSearchCondImpl();
			cond.setId(Integer.parseInt(eiidstr.split("_")[0]));
			List<String> esyscodingList  = new ArrayList<String>();
			for(int i=6;i<=esyscoding.length();){
				esyscodingList.add(esyscoding);
				esyscoding = esyscoding.substring(0,esyscoding.length()-3);
			}
			cond.setEsyscodingList(esyscodingList);
			//启用状态
			cond.setCstatus("1");
			List<SOC0109VWInfo> soc0109List = soc0109VWBL.searchConfiguration(cond);
			
//			int j = 0;
//			for(int i=0;i<soc0109List.size();i++){
//				SOC0109VWInfo info = soc0109List.get(i);
//				//2:下拉菜单
//				if("2".equals(info.getCattach())){
//					List<LabelValueBean> list = soc0151VWBL.searchLabelValueBeanList(info.getCoption(),Integer.parseInt((eiidstr+"").split("_")[0]));
//					dto.setSelectedListMap(j++, list);
//				}
//				if("5".equals(info.getCattach())){
//					List<LabelValueBean> list = soc0151BL.searchLabelValueBeanList(info.getCoption());
//					if(list.size() > 0){
//						list.remove(0);
//					}
//					form.setSelectedListMap(j++, list);
//				}
//			}
			
		//修订和查看页面
//			SOC0124Info soc0124 = soc0118BL.searchEntityItemVWByKey(eiid);
		SOC0118VWInfo soc0124 = soc0118VWBL.searchEntityItemByKey(new SOC0118VWPK(Integer.parseInt((eiidstr+"").split("_")[0]), Integer.parseInt((eiidstr+"").split("_")[1])));
		SOC0129SearchCondImpl soc0129cond = new SOC0129SearchCondImpl();
		soc0129cond.setId((eiidstr+"").split("_")[0]);
		soc0129cond.setEiid((eiidstr+"").split("_")[1]);
		soc0129cond.setEsyscoding_q(soc0124.getEsyscoding());
		//查询出所有已经存在的属性值信息
		List<SOC0129Info> soc0129List = soc0107BL.searchConfigItemVW(soc0129cond);
		
		//
		Map<String, SOC0129Info> configItemMap = new HashMap<String, SOC0129Info>(); 
		for (SOC0129Info soc0129Info : soc0129List) {
			configItemMap.put(soc0129Info.getCid(), soc0129Info);
		}
		//遍历改模型的属性,装载没有赋值过的属性
		for (SOC0109VWInfo soc0109Info : soc0109List) {
			//如果属性值中没有 所有属性中的一项则添加一个空的属性值到列表中
			if(!configItemMap.containsKey(soc0109Info.getCid())){
				SOC0129VW soc0129vw = new SOC0129VW();
				BeanUtils.copyProperties(soc0109Info, soc0129vw,new String[]{"cseq"});
//					soc0129vw.setCattach(soc0109Info.getCattach());
//					soc0129vw.setCcategory(soc0109Info.getCattach());
//					soc0129vw.setCdesc(soc0109Info.getCdesc());
//					soc0129vw.setCid(soc0109Info.getCid());
//					soc0129vw.setClabel(soc0109Info.getClabel());
//					soc0129vw.setCname(soc0109Info.getCname());
//					soc0129vw.setCoption(soc0109Info.getCoption());
//					soc0129vw.setCrequired(soc0109Info.getCrequired());
				soc0129vw.setCseq(soc0109Info.getCseq()+"");
//					soc0129vw.setCunit(soc0109Info.getCunit());
//					soc0129vw.setEid(soc0109Info.getEid());
//					soc0129vw.setEsyscoding(soc0109Info.getEsyscoding());
				soc0129List.add(soc0129vw);
			}else{
				//否则 删除map中的属性项
				configItemMap.remove(soc0109Info.getCid());
			}
		}
		
		for(Iterator<SOC0129Info> it = configItemMap.values().iterator();it.hasNext();){
			SOC0129Info soc0129Info = it.next();
			soc0129List.remove(soc0129Info);
		}

		
		
		dto.setConfigItemList(soc0129List);
		dto.setEntityItemVW(soc0124);
		
		log.info("==========应急资源属性列表获取结束============");
		
		
		return dto;
	}
	
	/**
	 * 应急资源登记属性信息列表
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 * @throws IOException 
	 */
	public String getConfigList(IGDRM04DTO dto) throws BLException {
		IGDRM0412Form form = dto.getIgdrm0412Form();
		Map<String, String> nameMap = new HashMap<String, String>();
		SOC0117VWSearchCondImpl s117Cond = new SOC0117VWSearchCondImpl();
		String cids = "";
		String erid =form.getFingerPrint();
		String id = form.getEsyscoding().split("_")[0];
		String esyscoding = form.getEsyscoding().split("_")[2];
		s117Cond.setId(Integer.parseInt(id));
		s117Cond.setEsyscoding(esyscoding);
		List<SOC0117VWInfo> firstList = soc0117VWBL.searchEntity(s117Cond);
		if(firstList!=null&&firstList.size()>0){
			nameMap.put(esyscoding, firstList.get(0).getEname());
		}
		if(StringUtils.isNotEmpty(erid)){
			EmergencyResourceInfo erInfo = emergencyResourceBL.searchEmergencyResourceByPK(Integer.parseInt(erid));
			cids = erInfo.getErcids();
		}
		SOC0109VWSearchCondImpl cond = new SOC0109VWSearchCondImpl();
		cond.setId(Integer.parseInt(id));
		List<String> esyscodingList  = new ArrayList<String>();
		for(int i=6;i<=esyscoding.length();){
			esyscodingList.add(esyscoding);
			esyscoding = esyscoding.substring(0,esyscoding.length()-3);
			s117Cond.setEsyscoding(esyscoding);
			List<SOC0117VWInfo> s117List = soc0117VWBL.searchEntity(s117Cond);
			if(s117List!=null&&s117List.size()>0){//不继承为止
				if(s117List.get(0).getEkey2()!=null&&s117List.get(0).getEkey2() == "1") break;
				nameMap.put(esyscoding, s117List.get(0).getEname());
			}
		}
		cond.setEsyscodingList(esyscodingList);
		//启用状态
		cond.setCstatus("1");
		cond.setCcategory("ASCCCATEGORY");
		List<SOC0109VWInfo> soc0109VWList = soc0109VWBL.searchConfiguration(cond);
		Map<String , List<Map<String,String>>> finalMap = new LinkedHashMap<String, List<Map<String,String>>>();
		//模型分类基础数据
		CodeDetailBL codeDetailBL = (CodeDetailBL) WebApplicationSupport.getBean("codeDetailBL");
		CodeDetailSearchCondImpl ccond = new CodeDetailSearchCondImpl();
		ccond.setCcid("008");//属性分类
		List<CodeDetail> detailList = codeDetailBL.searchCodeDetailTree(ccond,2);
		Map<String, String> cdMap = new LinkedHashMap<String, String>();
		for(CodeDetail cd : detailList){
			cdMap.put(cd.getCid(), cd.getCvalue());
		}
		Set<String> ccategorySet = new LinkedHashSet<String>();//过滤掉没有的模型
		for(SOC0109VWInfo info : soc0109VWList){
			if(!ccategorySet.contains(info.getCcategory()))
				ccategorySet.add(info.getCcategory());
		}
		Iterator<String> it = ccategorySet.iterator();
		while (it.hasNext()) {  
			String str = it.next();  
			List<Map<String,String>> ccategoryList = new ArrayList<Map<String,String>>();
			for(SOC0109VWInfo info : soc0109VWList){
				Map<String,String> map = null ;
				if(str.equals(info.getCcategory())){
					map = new HashMap<String, String>();
					map.put("cid", info.getCid());
					map.put("cname", info.getCname());
					map.put("esyscoding", info.getEsyscoding());
					map.put("codename", nameMap.get(info.getEsyscoding()));
					map.put("ccategory", nameMap.get(info.getCcategory()));
					if("new".equals(form.getFlag())){
						map.put("checked", "0");
					}else{
						if(cids.indexOf(info.getCid())>-1) {
							map.put("checked", "1");
						} else{
							map.put("checked", "0");
						}
					}
				}
				if(map!=null)
					ccategoryList.add(map);
			}
			if(ccategoryList.size()>0)
			finalMap.put(str + "_" + cdMap.get(str), ccategoryList);
		} 
		Gson g = new Gson();
		return g.toJson(finalMap);
	}
	/**
	 * 应急资源配置信息编辑处理
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public IGDRM04DTO editEntityItemAction(IGDRM04DTO dto) throws BLException, FileNotFoundException, IOException {
		log.debug("========应急资源配置信息编辑处理开始========");
		//版本号生成
		IGDRM0404Form form = dto.getIgdrm0404Form();
		//应急资源基本信息更新
		SOC0118TB entityItem = (SOC0118TB) this.soc0118BL.searchEntityItemByKey(Integer.parseInt(form.getEiid()));
		// 取得版本是否升级标识
		String ident = form.getIdent();
		if(StringUtils.isEmpty(ident)){
			ident = IGASM05BLImpl.SAVE_VERSION;
		}
		// 版本号初始化
		int version = 1;
		boolean versonFlag = false;
		// 判断是否升级版本号
		// =====================>> 修改 start
		if (IGASM05BLImpl.SAVE_VERSION_UP.equals(ident)) { // 升级版本号
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
                            IG013TB cldEntityItem = (IG013TB) this.soc0118BL.searchEntityItemByKey(Integer.parseInt(cldeiid));
                            if(cldEntityItem!=null){
                            	 cldeiids[index]=cldeiid+"_"+cldEntityItem.getEiversion()+"_"+cldEntityItem.getEismallversion()+"_"+form.getCiid()[i];
                            }
                        }
                        index++;
                    }
                }
            }
			
//			//资产关系信息版本升级处理
			this.soc0119BL.upgradeEntityItemRelationOne(entityItem.getEiid(), entityItem.getEiversion(), entityItem.getEismallversion(),
					version, 0,cldeiids);
			
			if (version - 1 != entityItem.getEiversion()) {
				throw new BLException("IGCO00000.E004");
			}
		} else if (IGASM05BLImpl.SAVE_VERSION.equals(ident)) { // 不升级版本号

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
		
		//版本
		entityItem.setEiversion(version);
		
		entityItem.setEidesc(form.getEidesc());
		
		entityItem.setEid(form.getEid_q());

		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		
		
		
		//更新时间
		entityItem.setEiupdtime(datetime);
		
		entityItem.setEsyscoding(form.getEsyscoding_q());
		
		entityItem.setEid(form.getEid()[0]);
		
		//====================add at 2013-03-24 start========================
		if(StringUtils.isNotEmpty(form.getEiname())){
			entityItem.setEiname(form.getEiname());
		}
		if(StringUtils.isNotEmpty(form.getEiinsdate())){
			entityItem.setEiinsdate(form.getEiinsdate());
		}
		if(StringUtils.isNotEmpty(form.getEilabel())){
			entityItem.setEilabel(form.getEilabel());
		}
		//====================add at 2013-03-24 end========================
		
		this.soc0118BL.updateEntityItem(entityItem);
		//=======更新关系开始========
		if(version ==1&&versonFlag){
			SOC0119SearchCondImpl eircond1 = new SOC0119SearchCondImpl();
			//删除标识
			eircond1.setDeleteflag("0");
			//与该资产相关的关系码
			eircond1.setEirrelationcode(IGASM05BLImpl.EIRRELATIONCODE);
			eircond1.setEiid(String.valueOf(entityItem.getEiid()));
			//该资产现有的关系信息
			List<SOC0119Info> soc0119InfoList = this.soc0119BL.searchMaxEntityItemRelation(eircond1);
			if(soc0119InfoList!=null&&soc0119InfoList.size()>0){
				for(SOC0119Info soc0119Info:soc0119InfoList){
					SOC0119TB soc0119tb=new SOC0119TB();
					soc0119tb.setPareiid(soc0119Info.getPareiid());
					soc0119tb.setPareid(soc0119Info.getPareid());
					soc0119tb.setParsmallversion(soc0119Info.getParsmallversion());
					soc0119tb.setParversion(soc0119Info.getParversion());
					soc0119tb.setCldeiid(soc0119Info.getCldeiid());
					soc0119tb.setCldeid(soc0119Info.getCldeid());
					soc0119tb.setCldsmallversion(soc0119Info.getCldsmallversion());
					soc0119tb.setCldversion(soc0119Info.getCldversion());
					soc0119tb.setEirdesc(soc0119Info.getEirdesc());
					soc0119tb.setEirinfo(soc0119Info.getEirinfo());
					soc0119tb.setEirrelation(soc0119Info.getEirrelation());
					soc0119tb.setEirrelationcode(soc0119Info.getEirrelationcode());
					soc0119tb.setDeleteflag(soc0119Info.getDeleteflag());
					soc0119tb.setEirstatus(soc0119Info.getEirstatus());
					soc0119tb.setEirupdtime(soc0119Info.getEirupdtime());
					soc0119tb.setFingerPrint(soc0119tb.getFingerPrint());
					//正向关系时
					if(entityItem.getEiid().equals(soc0119Info.getPareiid())){
						soc0119tb.setParversion(entityItem.getEiversion());
						this.soc0119BL.registEntityItemRelation(soc0119tb);
					}
					//方向关系时
					if(entityItem.getEiid().equals(soc0119Info.getCldeiid())){
						soc0119tb.setCldversion(entityItem.getEiversion());
						this.soc0119BL.registEntityItemRelation(soc0119tb);
					}
				}
			}
		}
		//=======更新关系结束========
		
		//调用更新BL
		
		//应急资源配置信息更新
		if (form.getCiid() != null && form.getCiid().length > 0 ) {
			
			for( int i=0 ; i < form.getCiid().length; i++ ){
				SOC0107TB configItem = new SOC0107TB();
				//应急资源ID
				configItem.setEiid(Integer.parseInt(form.getEiid()));
				//资产配置ID
				configItem.setCid(form.getCid()[i]);
				//类型ID
				configItem.setEid(form.getEid()[i]);
				//类型层次码
				configItem.setEsyscoding(form.getEsyscoding()[i]);
				//内容
				if("CI070000000011".equalsIgnoreCase(form.getCid()[i])){
					configItem.setCivalue(version+"");
				}else {
					configItem.setCivalue(form.getCivalue()[i]);
				}
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
					if (IGASM05BLImpl.SAVE_VERSION_UP.equals(ident)) { // 升级版本号

						configItem = (SOC0107TB) this.soc0107BL.registSOC0107(configItem);

					} else if (IGASM05BLImpl.SAVE_VERSION.equals(ident)) { // 不升级版本号
					
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
				//删除附件不检验上传zyl
//				if(form.getDelfile().length<i&&StringUtils.isEmpty(form.getDelfile()[i]))
				if(form.getDelfile()[i]==null)
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
						//应急资源ID
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
	
		dto.addMessage(new ActionMessage("IGCO10000.I005","应急资源维护"));
		
		log.debug("========应急资源配置信息编辑处理终了========");
		
		return dto;
	}
	
	
	
	/**
	 * 应急资源查询
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM04DTO searchEmergencyResource(IGDRM04DTO dto)throws BLException{
		
		log.info("============应急资源列表查询开始==============");
		
		IGDRM0402Form form = dto.getIgdrm0402Form();
		
 		dto.setRootEsyscoding("000");
		this.initNewNodeMap(dto);//新版应急资源树
		SOC0118VWSearchCondImpl cond = new SOC0118VWSearchCondImpl();
		cond.setEiname(form.getEiname());
		cond.setEiusername(form.getEiusername());
		cond.setEiinsdate_gt(form.getPropentime());
		cond.setEiinsdate_lt(form.getPrclosetime());
		cond.setEsyscoding_like(form.getErcode());
		cond.setEiidNotIn(form.getEiidNotIn());
		cond.setResourceType(form.getResourceType());
		// 应急资源查询件数取得
		int totalCount = this.soc0118VWBL.getEmergencyRelationCount(cond );
		if (totalCount == 0) {
			log.debug("========查询数据不存在========"); 
			// 应急资源查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
 
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========资产域定义信息查询数据件数过多========");
			// 应急资源查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto.getMaxSearchCount(), totalCount));
			return dto;
		}

		// 分页用信息取得
		PagingDTO pDto = dto.getPagingDto();
		int from = pDto.getFromCount();
		int to = pDto.getPageDispCount();
		List<SOC0118VWInfo> entitys = this.soc0118VWBL.getEmergencyRelationList(cond, from, to);
		// 应急资源取得
		pDto.setTotalCount(totalCount);
	

		dto.setEntityVWItemList(entitys);

		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		
		log.info("============应急资源列表查询结束==============");
		return dto;
		
	}
	public List<SOC0118VWInfo> getList(List<SOC0118VWInfo> list ,int from ,int to){
		List<SOC0118VWInfo> newList = new LinkedList<SOC0118VWInfo>();
		newList = list.subList(from, to);
		return newList;
		
	}
	/**
	 * 初始化树
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM04DTO initNodeMap(IGDRM04DTO dto)throws BLException{
		
		List<Map<String, Object>> soc0117List = soc0117BL.getEntityNum(dto.getRootEsyscoding());
		Hashtable<String,TreeNode> tempMap = new Hashtable<String, TreeNode>();
		Map<String,TreeNode> allNode = new HashMap<String, TreeNode>();
		for(Map<String, Object> map : soc0117List){
			TreeNode node = new TreeNode();
			node.setId(map.get("ESYSCODING").toString());
			node.setRemark(map.get("EPARCODING").toString());
			//设备信息查询件数取得 
			node.setName(map.get("ENAME").toString()+"("+map.get("ACCOUNT").toString()+")");
			
			if(allNode.get(map.get("EPARCODING").toString())==null){
				tempMap.put(map.get("ESYSCODING").toString(), node);
			} else{
				allNode.get(map.get("EPARCODING").toString()).addChildTreeNode(map.get("ESYSCODING").toString(), node);
			}
			allNode.put(map.get("ESYSCODING").toString(), node);	
		}
		dto.setNodeMap(tempMap);
		
		return dto;
	}
	/**
	 * 初始化树
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM04DTO initNewNodeMap(IGDRM04DTO dto)throws BLException{
		
		List<Map<String, Object>> soc0117List = soc0117BL.getEntityNumNEW(dto.getRootEsyscoding(),dto.getResourceType());
		Hashtable<String,TreeNode> tempMap = new Hashtable<String, TreeNode>();
		Map<String,TreeNode> allNode = new HashMap<String, TreeNode>();
		for(Map<String, Object> map : soc0117List){
			TreeNode node = new TreeNode();
			node.setId(map.get("ERCODE").toString());
			node.setRemark(map.get("ERID").toString()+"_"+map.get("ESYSCODING").toString());
//			node.setRemark(map.get("ERPARCODE").toString());
			//设备信息查询件数取得 
			node.setName(map.get("ERNAME").toString()+"("+map.get("ACCOUNT").toString()+")");
			
			if(allNode.get(map.get("ERPARCODE").toString())==null){
				tempMap.put(map.get("ERCODE").toString(), node);
			} else{
				allNode.get(map.get("ERPARCODE").toString()).addChildTreeNode(map.get("ERCODE").toString(), node);
			}
			allNode.put(map.get("ERCODE").toString(), node);	
		}
		dto.setNodeMap(tempMap);
		
		return dto;
	}
	
	
	
	/**
	 * 应急资源保存操作
	 * @param dto
	 * @return
	 * @throws BLException
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public IGDRM04DTO regEmergencyResource(IGDRM04DTO dto)throws BLException, FileNotFoundException, IOException{
		IGDRM0401Form form = dto.getIgdrm0401Form();
		SOC0118TB soc0118tb = new SOC0118TB();
		BeanUtils.copyProperties(form, soc0118tb);
		if(soc0118tb.getEiid()==null || soc0118tb.getEiid()==0){
			//新增操作
			soc0118tb.setEiversion(1);
			soc0118tb.setEismallversion(0);
			soc0118tb.setEiuserid(dto.getUser().getUserid());
			soc0118tb.setEiusername(dto.getUser().getUsername());
			soc0118tb.setEiorgsyscoding(dto.getUser().getOrgid());
			SOC0118Info soc0118Info = soc0118BL.registEntityItem(soc0118tb);
			String[] cids = form.getCids();
			String[] civalues = form.getCivalues();
			int i = 0;
			for (String cid : cids) {
				SOC0107TB soc0107tb = new SOC0107TB();
				soc0107tb.setCid(cid);
				soc0107tb.setCiupdtime(DateUtils.getCurrentTime());
				soc0107tb.setEid(soc0118Info.getEid());
				soc0107tb.setEsyscoding(soc0118Info.getEsyscoding());
				soc0107tb.setEiid(soc0118Info.getEiid());
				soc0107tb.setCiversion(soc0118Info.getEiversion());
				soc0107tb.setCismallversion(soc0118Info.getEismallversion());
				if("ciattach".equals(civalues[i])){
					//如果是附件
					uploadFile(form.getFiles(),soc0107tb);
				}else{
					soc0107tb.setCivalue(civalues[i]);
				}
				soc0107BL.registSOC0107(soc0107tb);
				i++;
			}
		}else{
			//修改操作
		}
		
		return dto;
	}
	
	private SOC0107TB uploadFile( FormFile file,SOC0107TB soc0107tb) throws FileNotFoundException, IOException, BLException{
		if ( file != null && file.getFileSize() > 0) {
			//上传文件存在的情况
			//上传文件路径
			StringBuffer pathBuf = new StringBuffer();
			String rootPath = ResourceUtility.getString("UPLOAD_FILE_ROOT_PATH");
			//根目录
			pathBuf.append(rootPath);
			//机能ID
			pathBuf.append("asm"+File.separator);
			//设备ID
			pathBuf.append(soc0107tb.getEiid());
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
			fileName.append(soc0107tb.getCiversion()+"_"+soc0107tb.getCismallversion());
			//文件扩展名
			fileName.append(fileType);

			//文件上传处理
			this.fileUploadBL.saveFile(file, pathBuf.toString(), fileName.toString());
			
			//上传文件名保存
			soc0107tb.setCivalue(fileName.toString());
			
			//更新属性标识
			soc0107tb.setCicurver("1");
			
		}else{
			soc0107tb.setCivalue(null);
		}
		return soc0107tb;
	}
	
	/**
	 * 应急资源删除处理
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO deleteEntityItemAction(IGDRM04DTO dto) throws BLException {
		log.debug("========应急资源删除处理开始========");
		
		for( int i=0;i<dto.getDeleteEntityItem().length;i++ ){
			String eiid = dto.getDeleteEntityItem()[i];
			
			//删除前删除对象文档确认
			SOC0118Info entityItem = this.soc0118BL.searchEntityItemByKey(Integer.parseInt(eiid));
			
			if (entityItem == null){
				throw new BLException("IGCO10000.E004","删除对象文档基本");
			}

			//应急资源删除
			SOC0118TB soc0118tb = (SOC0118TB) SerializationUtils.clone(entityItem);
			soc0118tb.setEistatus("D");
			//应急资源逻辑删除
			this.soc0118BL.updateEntityItem(soc0118tb);
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I006","应急资源"));

		log.debug("========应急资源删除处理终了========");
		return dto;
	}
	
	/**
	 * 获取应急资源编号
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM04DTO getLabel(IGDRM04DTO dto)throws BLException{
		IGDRM0401Form form = dto.getIgdrm0401Form();
		dto.setEilabel(creatEiLabel(form.getEid()));
		return dto;
	}

	private String creatEiLabel( String eid)
			throws BLException {
		SOC0117Info soc0117Info = soc0117BL.searchEntityByKey(eid);
		
		SOC0118SearchCondImpl cond = new SOC0118SearchCondImpl();
		
		cond.setEilabel_like(soc0117Info.getElabel());
		
		List<SOC0118Info> entitys = soc0118BL.searchEntityItem(cond);
		
		if(entitys.size()>0){
			String num = String.valueOf(Integer.valueOf(entitys.get(entitys.size()-1).getEilabel().split("-")[1])+1);
			
			return soc0117Info.getElabel()+"-"+("0000".substring(num.length())+num);
			
		}else{
			return soc0117Info.getElabel()+"-0001";
		}
	}
	
	/**
	 * 获取应急资源中附件的ciid
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM04DTO getArrId(IGDRM04DTO dto)throws BLException{
		
		SOC0107SearchCondImpl cond = new SOC0107SearchCondImpl();
		cond.setEiid(""+dto.getEiid());
		cond.setCiversion(""+dto.getEiversion());
		cond.setCid("CI400000000001");
		List<SOC0107Info> list = soc0107BL.searchSOC0107(cond);
		if(list.size()>0){
			dto.setCiid(list.get(0).getCiid());
		}
		
		return dto;
	}
	
	
	
	/**
	 * 应急资源快捷保存操作
	 * @param dto
	 * @return
	 * @throws BLException
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public IGDRM04DTO regEmergencyResourceShortcut(IGDRM04DTO dto)throws BLException, FileNotFoundException, IOException{
		
		IGDRM0408Form form = (IGDRM0408Form)dto.getForm();
		SOC0118TB soc0118Tb = new SOC0118TB();
		soc0118Tb.setEid("CM40000000");
		soc0118Tb.setEsyscoding("999040");
		soc0118Tb.setEiuserid(dto.getUser().getUserid());
		soc0118Tb.setEiusername(dto.getUser().getUsername());
		soc0118Tb.setEiinsdate(DateUtils.getCurrentTime().substring(0,10));
		soc0118Tb.setEilabel(this.creatEiLabel(soc0118Tb.getEid()));
		soc0118Tb.setEiorgsyscoding(dto.getUser().getOrgid());
		soc0118Tb.setEiname(form.getEiname());
		soc0118Tb.setEiversion(1);
		soc0118Tb.setEismallversion(0);
		SOC0118Info soc0118Info = soc0118BL.registEntityItem(soc0118Tb);
		String[] cids = form.getCids();
		String[] civalues = form.getCivalues();
		form.setEiid(soc0118Info.getEiid());
		int i = 0;
		for (String cid : cids) {
			SOC0107TB soc0107tb = new SOC0107TB();
			soc0107tb.setCid(cid);
			soc0107tb.setCiupdtime(DateUtils.getCurrentTime());
			soc0107tb.setEid(soc0118Info.getEid());
			soc0107tb.setEsyscoding(soc0118Info.getEsyscoding());
			soc0107tb.setEiid(soc0118Info.getEiid());
			soc0107tb.setCiversion(soc0118Info.getEiversion());
			soc0107tb.setCismallversion(soc0118Info.getEismallversion());
			if("ciattach".equals(civalues[i])){
				//如果是附件
				uploadFile(form.getFiles(),soc0107tb);
			}else{
				soc0107tb.setCivalue(civalues[i]);
			}
			soc0107BL.registSOC0107(soc0107tb);
			i++;
		}
		return dto;
	}

	/**
	 * soc0118BL   取得
	 * @return soc0118BL soc0118BL
	 */
	public SOC0118BL getSoc0118BL() {
		return soc0118BL;
	}

	/**
	 * soc0118BL   设定
	 * @param soc0118BL soc0118BL
	 */
	public void setSoc0118BL(SOC0118BL soc0118bl) {
		soc0118BL = soc0118bl;
	}

	/**
	 * soc0117BL   取得
	 * @return soc0117BL soc0117BL
	 */
	public SOC0117BL getSoc0117BL() {
		return soc0117BL;
	}

	/**
	 * soc0117BL   设定
	 * @param soc0117BL soc0117BL
	 */
	public void setSoc0117BL(SOC0117BL soc0117bl) {
		soc0117BL = soc0117bl;
	}

	/**
	 * soc0109BL   取得
	 * @return soc0109BL soc0109BL
	 */
	public SOC0109BL getSoc0109BL() {
		return soc0109BL;
	}

	/**
	 * soc0109BL   设定
	 * @param soc0109BL soc0109BL
	 */
	public void setSoc0109BL(SOC0109BL soc0109bl) {
		soc0109BL = soc0109bl;
	}

	/**
	 * soc0107BL   取得
	 * @return soc0107BL soc0107BL
	 */
	public SOC0107BL getSoc0107BL() {
		return soc0107BL;
	}

	/**
	 * soc0107BL   设定
	 * @param soc0107BL soc0107BL
	 */
	public void setSoc0107BL(SOC0107BL soc0107bl) {
		soc0107BL = soc0107bl;
	}
	/**
	 * organizationBL   设定
	 * @param organizationBL organizationBL
	 */
	public void setOrganizationBL(OrganizationBL organizationBL) {
		this.organizationBL = organizationBL;
	}

	/**
	 * fileUploadBL   设定
	 * @param fileUploadBL fileUploadBL
	 */
	public void setFileUploadBL(FileUploadBL fileUploadBL) {
		this.fileUploadBL = fileUploadBL;
	}

	/**
	 * soc0119BL   设定
	 * @param soc0119BL soc0119BL
	 */
	public void setSoc0119BL(SOC0119BL soc0119bl) {
		soc0119BL = soc0119bl;
	}

	/**
	 * codeDetailBL   设定
	 * @param codeDetailBL codeDetailBL
	 */
	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}
	
	
	
	
	/**
	 * <p>
	 * 判断每级资产分类是否可以停用
	 * </p>
	 * @param 资产分类esyscoding
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	private boolean isCouldStop(String syscode) {
		IGDRM0411Form form = new IGDRM0411Form();
		IGDRM04DTO dto = new IGDRM04DTO();
		boolean flag = true;
		
		form.setEparcoding_status(syscode);
		form.setEstatus("1");
		dto.setEntitySearchCond(form);
		List<SOC0117Info> ret = soc0117BL.searchEntity(dto.getEntitySearchCond(), 0, 0);//查该分类是否存在使用中的下级分类
		if(ret.size()>0){
			flag = false;
		}
		return flag;
	}
	
	/**
	 * <p>
	 * Description: 确定是否显示'停用'按钮
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	public Map<String,String> getButtonNameList(List<SOC0117Info> entityList) throws BLException {
		Map<String,String> org = new HashMap<String,String>();
		for(SOC0117Info ret:entityList){
			String flag = "0";//0不显示 1显示
			
			if(isCouldStop(ret.getEsyscoding())){
				flag = "1";
			}
			
			org.put(ret.getEid(), flag);
		}
		
		return org;
	}
	
	/**
	 * <p>
	 * 判断每级机构是否可以启用
	 * </p>
	 * @param 资产分类esyscoding
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	private boolean isCouldStart(String syscode) {
		IGDRM0411Form form = new IGDRM0411Form();
		IGDRM04DTO dto = new IGDRM04DTO();
		boolean flag = true;
		
		form.setEparcoding_status_start(syscode);
		dto.setEntitySearchCond(form);
		List<SOC0117Info> ret = soc0117BL.searchEntity(dto.getEntitySearchCond(), 0, 0);//查该资产分类是否存在停用的上级分类

		if(ret.size()>0&&ret.get(0).getEstatus().equals("2")){//如果当前结点的上级是停用状态则当前结点不可启用
			flag = false;
		}
		return flag;
	}
	
	/**
	 * <p>
	 * Description: 确定是否显示'启用'按钮
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	public Map<String,String> getStartButtonNameList(List<SOC0117Info> entityList) throws BLException {
		Map<String,String> org = new HashMap<String,String>();
		for(SOC0117Info ret:entityList){
			String flag = "0";//0不显示 1显示
			String syscode = ret.getEsyscoding();
			String parcode = ret.getEparcoding();
			if(parcode.equals("999")){//代表为1级分类，则直接设置flag为1
				flag = "1";
			}else{
				if(isCouldStart(syscode.substring(0,syscode.length()-3))){
					flag = "1";
				}
				
			}

			org.put(ret.getEid(), flag);
		}
		
		return org;
	}
	
	/**
	 * <p>
	 * Description: 资产分类属性状态变化
	 * </p>
	 * 
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 * @throws BLException
	 * @author duchong@deliverik.com
	 * @update
	 */
	public void changeConfigStatus(IGDRM04DTO dto) throws BLException {
		log.debug("========资产分类属性状态变化处理开始========");

		SOC0109Info configuration = soc0109BL.searchConfigurationByKey(dto.getCid());
		String status = "";
		if(configuration == null){
			throw new BLException("IGCO10000.E004","资产分类属性状态变更");
		}
		//1为启用 2为停用
		if("1".equals(dto.getCstatus())){
			status="2";
		}else if("2".equals(dto.getCstatus())){
			status="1";
		}
		SOC0109TB cfr = new SOC0109TB();
		//画面显示设定
		cfr.setCattach(configuration.getCattach());
		cfr.setCcategory(configuration.getCcategory());
		cfr.setCdesc(configuration.getCdesc());
		cfr.setCid(configuration.getCid());
		cfr.setClabel(configuration.getClabel());
		cfr.setCname(configuration.getCname());
		cfr.setCoption(configuration.getCoption());
		cfr.setCseq(configuration.getCseq());
		cfr.setCstatus(status);
		cfr.setEsyscoding(configuration.getEsyscoding());
		cfr.setCunit(configuration.getCunit());
		cfr.setEid(configuration.getEid());
		cfr.setCrequired(configuration.getCrequired());

		soc0109BL.updateConfiguration(cfr);

		log.debug("========资产分类属性状态变化处理结束========");
		
	}
	
	/**
	 * <p>
	 * Description: 资产分类状态变化
	 * </p>
	 * 
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 * @throws BLException
	 * @author duchong@deliverik.com
	 * @update
	 */
	public void changeEntityStatus(IGDRM04DTO dto) throws BLException {
		log.debug("========资产分类状态变化处理开始========");
		IGDRM0411Form form = dto.getIgdrm0411Form();
		EmergencyResourceInfo info = emergencyResourceBL.searchEmergencyResourceByPK(Integer.parseInt(form.getEid()));
		if(info == null){
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","应急资源状态变更");
		}
		EmergencyResourceTB Tb = (EmergencyResourceTB) SerializationUtils.clone(info);
		Tb.setErstatus(form.getEstatus()!=null&&"1".equals(form.getEstatus())? "0" : "1");
		emergencyResourceBL.updateEmergencyResource(Tb);
		if(form.getEstatus()!=null&&"1".equals(form.getEstatus())){
			EmergencyResourceSearchCondImpl cond = new EmergencyResourceSearchCondImpl();
			cond.setErparcode_like(info.getErcode());
			List<EmergencyResourceInfo> infoList = emergencyResourceBL.searchEmergencyResource(cond);
			
			if(infoList!=null&&infoList.size()>0){
				for(EmergencyResourceInfo temp : infoList){
					EmergencyResourceTB tempTB = (EmergencyResourceTB) SerializationUtils.clone(temp);
					tempTB.setErstatus("0");
					emergencyResourceBL.updateEmergencyResource(tempTB);
				}
			}
		}
		
//		SOC0117Info entity = soc0117BL.searchEntityByKey(form.getEid());
//		String status = "";
//		if(entity == null){
//			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
//					"IGCO10000.E004","资产分类状态变更");
//		}
//		//1为启用 2为停用
//		if("1".equals(dto.getEstatus())){
//			status="2";
//		}else if("2".equals(dto.getEstatus())){
//			status="1";
//		}
//		IGDRM0412Form form0102 = new IGDRM0412Form();
//		//画面显示设定
//		form0102.setEcategory(entity.getEcategory());
//		form0102.setEid(entity.getEid());
//		form0102.setEkey1(entity.getEkey1());
//		form0102.setEkey2(entity.getEkey2());
//		form0102.setEkey3(entity.getEkey3());
//		form0102.setElabel(entity.getElabel());
//		form0102.setEname(entity.getEname());
//		form0102.setEstatus(status);//设置资产分类状态
//		form0102.setEsyscoding(entity.getEsyscoding());
//		form0102.setEparcoding(entity.getEparcoding());
//		form0102.setEdesc(entity.getEdesc());
//		if("999".equals(entity.getEparcoding())){
//			form0102.setEparname("资产分类");
//		}
//		else{
//			SOC0117SearchCondImpl ret = new SOC0117SearchCondImpl();
//			ret.setEsyscoding(entity.getEparcoding());
//			List<SOC0117Info> list = this.soc0117BL.searchEntity(ret, 0, 0);
//			for (int i = 0; i < list.size(); i++) {
//				form0102.setEparname(list.get(0).getEname());
//			}
//		}
//		form0102.setEidStr(String.valueOf(form.getEid()));
//		
//		soc0117BL.updateEntity(form0102);

		log.debug("========资产分类状态变化处理结束========");
		
	}
	
	/**
	 * 查询不包括机房、机柜及服务记录的一级分类（生成EXCEL模板使用）
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO searchEntityActionForExportExcelModel(IGDRM04DTO dto) throws BLException {

		log.debug("========一级分类查询处理开始========");
		
		//资产信息查询件数取得 
		
		int totalCount = this.soc0117BL.getEntitySearchCount(dto.getEntitySearchCond());
		
		if (totalCount == 0) {
			log.debug("========资产信息查询数据不存在========");
			//资产信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========资产信息查询数据件数过多========");
			//资产信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//分页用信息取得
		//当前页资产信息取得
		PagingDTO pDto = dto.getPagingDto();
		List<SOC0117Info> entityList = this.soc0117BL.searchEntity(dto.getEntitySearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
//		List<Entity> newList = new ArrayList<Entity>();
//		for(Entity e:entityList){
//			if(!CommonDefineUtils.ENTIY_CATEGORY_SERVICE_RECORD_SYSCODING.equals(e.getEsyscoding())){
//				newList.add(e);
//			}
//		}
//		if(newList==null){
//			throw new BLException("IGDRM0411.E006");
//		}
		
		pDto.setTotalCount(totalCount);
		
		dto.setEntityList(entityList);
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========一级分类查询处理终了========");
		return dto;
	}
	
	
	/**
	 * 取得该结点的资产分类全名
	 * @param syscoding
	 * @return
	 */
	private String getCompleteEntityName(String syscoding) {
		StringBuffer ename = new StringBuffer();
		try{
			ArrayList<String> codelist = new ArrayList<String>();
			if(syscoding.length()==6){
				codelist.add(syscoding);
			}else{
				String pcode = syscoding.substring(0, 6);
				codelist.add(pcode);
				String childs = syscoding.substring(6);
				int j = childs.length()/3;
				for(int i=1;i<=j;i++){
					codelist.add(pcode+childs.substring(0, 3*i));
				}
				
			}
			SOC0117SearchCondImpl cond = new SOC0117SearchCondImpl();
			cond.setSelectList(codelist);
			List<SOC0117Info> ret = soc0117BL.searchEntity(cond, 0, 0);
			
			for(int i=0,j=ret.size();i<j;i++){
				String syscode = ret.get(i).getEsyscoding();
				if(syscoding.contains(syscode)){
					if(i>0){
						ename.append("-");
					}
					ename.append(ret.get(i).getEname());
				}
				
			}

		}catch(Exception e){
			e.printStackTrace();
		}
		return ename.toString();
	}
	
	
	/**
	 * 导出Excel模板
	 * @throws Exception
	 */
	public IGDRM04DTO searchInfoForExportExcel(String esyscode) throws BLException{

		try
		{
			IGDRM04DTO dto = new IGDRM04DTO();
			//查询资产分类（除机房、机柜、服务记录）
//			List<String> selectList = new ArrayList<String>();
//			selectList.add("999001");
//			selectList.add("999002");
//			selectList.add("999003");
//			selectList.add("999005");
//			selectList.add("999006");
//			selectList.add("999010");
//			selectList.add("999011");
//			selectList.add("999012");
//			selectList.add("999013");
			SOC0117SearchCondImpl cond = new SOC0117SearchCondImpl();
			//cond.setSelectList(selectList);
			cond.setEsyscoding(esyscode);
			List<SOC0117Info> list = soc0117BL.searchEntity(cond, 0, 0);
			dto.setTopEntityList(list);
			
			
			//查询资产分类（除机房、机柜、服务记录,并且为当前传入的资产分类编码对应的资产分类集合）
			List<String> delList = new ArrayList<String>();
			delList.add("999007");
			delList.add("999008");
			delList.add("999009");
			SOC0117SearchCondImpl cond1 = new SOC0117SearchCondImpl();
			cond1.setDelList(delList);
			cond1.setSyscoding_q(esyscode);
			List<SOC0117Info> elist = soc0117BL.searchEntity(cond1, 0, 0);
			List<SOC0117Info> entitylist = new ArrayList<SOC0117Info>();
			for(SOC0117Info entity:elist){
				SOC0117TB etb = (SOC0117TB)SerializationUtils.clone(entity);
				etb.setEname(getCompleteEntityName(etb.getEsyscoding()));
				entitylist.add(etb);
			}
			dto.setEntityList(entitylist);
			
			//查取值范围
			SOC0151SearchCondImpl ccdcond = new SOC0151SearchCondImpl();
			ccdcond.setCcdstatus("1");//查询状态为可用的数据
			List<SOC0151Info> ccdlist  = soc0151BL.searchConfigurationCodeDetail(ccdcond, 0, 0);
			dto.setCcdList(ccdlist);
			
			//查询机构
			IGSYM01BL sym01BL = (IGSYM01BL) WebApplicationSupport.getBean("igsym01BL");
			IGSYM01DTO sym01dto = sym01BL.searchOrganizationForIGASM0101();
			List<Organization> orglist = sym01dto.getOrganizationCondList();
			dto.setOrglist(orglist);
			
			//查询该资产的属性
			List<Map<String,List<SOC0109Info>>> maplist = new ArrayList<Map<String,List<SOC0109Info>>>();
			for(SOC0117Info entity:list){
				List<String> cattachList = new ArrayList<String>();
				Map<String,List<SOC0109Info>> map = new LinkedHashMap<String,List<SOC0109Info>>();
				//codedetail表中CCID为012的记录代表资产配置项类型，CID为资产配置项类型的值
				cattachList.add("0");//资产配置项类型为文本框
				cattachList.add("2");//资产配置项类型为下拉框
				cattachList.add("3");//资产配置项类型为日期
				
				//资产配置信息分层次查询
				List<SOC0117Info> parentlist = this.soc0117BL.getParentNodes(entity.getEid());
				for(SOC0117Info e : parentlist){
					SOC0109SearchCondImpl cond2 = new SOC0109SearchCondImpl();
					cond2.setCseq(1);//只查询页面显示的属性
					cond2.setEid(e.getEid().toString());
					cond2.setCattachList(cattachList);
					List<SOC0109Info> configurationList = this.soc0109BL.searchConfiguration(cond2, 0, 0);
					map.put(e.getEsyscoding(), configurationList);
				}
				maplist.add(map);
			}
			dto.setConfigurationMapList(maplist);

			
			//查询用户
			IGSYM02BL sym02BL = (IGSYM02BL) WebApplicationSupport.getBean("igsym02BL");
			IGSYM02DTO sym02dto = sym02BL.searchUserActionForIGASM0101();
			List<User> userlist = sym02dto.getUserList();
			dto.setUserlist(userlist);
			
			
			return dto;
		}catch (Exception e){
			e.printStackTrace();
			log.debug("=============生成一级资产分类模板出错！==============");
			log.debug(e.getMessage());
			throw new BLException("IGDRM0411.E007");
		}
		
	}

	
	/**
	 * 资产项信息查询
	 * 
	 * @param dto
	 *            IGDRM07DTO
	 * @return IGDRM07DTO
	 */
	public IGDRM04DTO searchEntityItem0406Action(IGDRM04DTO dto) throws BLException
	{
		
		log.debug("========资产项HELP查询处理开始========");
		IGDRM0406Form form = (IGDRM0406Form)dto.getForm();
		
		//找关联的资产关系eiid
		List<Integer> eiids = new ArrayList<Integer>();
		List<String> eiidstrs = new ArrayList<String>();
		SOC0124SearchCondImpl soc0124cond = new SOC0124SearchCondImpl();
		soc0124cond.setEsyscoding(form.getEsyscoding());
		soc0124cond.setEiname(form.getEiname());
		//场景关联专项预案
		if(dto.getSp_eiid()!=null&&!"".equals(dto.getSp_eiid())){
			if(soc0124cond.getEsyscoding()!=null&&"999060".equals(soc0124cond.getEsyscoding().substring(0, 6))){
				
			SOC0119SearchCondImpl soc0119cond = new SOC0119SearchCondImpl();
			soc0119cond.setPareiid(Integer.parseInt(dto.getSp_eiid()));
			soc0119cond.setDeleteflag("0");
			eiids = soc0119BL.searchCldeiidByPareiid(soc0119cond);
			if(eiids.size()>0){
				for(int i = 0; i<eiids.size();i++){
					eiidstrs.add(eiids.get(i)+"");
				}
				soc0124cond.setEiidList(eiidstrs);
			}else{
				//没有资产关联关系的情况
				eiidstrs.add("999");
				soc0124cond.setEiidList(eiidstrs);
			}
			}
		}
		soc0124cond.setEistatus("ISNULL");
		// 查询件数取得												  
		int totalCount = this.soc0118BL.getEntityItemVWSearchCount(soc0124cond);
	
		if (totalCount == 0)
		{
			log.debug("========查询数据不存在========");
			// 查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
	
		if (totalCount > dto.getMaxSearchCount())
		{
			log.debug("========查询数据件数过多========");
			// 查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}
	
		PagingDTO pDto = dto.getPagingDto();
	
		List<SOC0124Info> entityItemVWInfoList = this.soc0118BL.searchEntityItemVW(soc0124cond, pDto
						.getFromCount(), pDto.getPageDispCount());
	
		pDto.setTotalCount(totalCount);
	
		dto.setSoc0124List(entityItemVWInfoList);
	
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
	
		log.debug("========资产项HELP查询处理终了========");
		return dto;
	}
	/**
	 * 资产信息查询处理
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO searchEntityAction(IGDRM04DTO dto) throws BLException {

		log.debug("========资产信息查询处理开始========");
		IGDRM0411Form form = dto.getIgdrm0411Form();
		EmergencyResourceSearchCondImpl erCond = new EmergencyResourceSearchCondImpl();
		erCond.setErname(form.getEname());
		erCond.setErparcode_like(form.getEparcoding());
		//资产信息查询件数取得 
		int totalCount = emergencyResourceBL.getSearchCount(erCond);
		
		if (totalCount == 0) {
			log.debug("========资产信息查询数据不存在========");
			//资产信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========资产信息查询数据件数过多========");
			//资产信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//分页用信息取得
		PagingDTO pDto = dto.getPagingDto();

		//当前页资产信息取得
		List<EmergencyResourceInfo> erEntityList = emergencyResourceBL.searchEmergencyResource(erCond, pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
//		
		dto.setErEntityList(erEntityList);
		
//		dto.setStopbuttonMap(getButtonNameList(entityList));
//		dto.setStartbuttonMap(getStartButtonNameList(entityList));
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========资产信息查询处理终了========");
		return dto;
	}
	
	/**
	 * 资产信息登记处理
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
//	public IGDRM04DTO insertEntityAction(IGDRM04DTO dto) throws BLException {
//		log.debug("========资产信息登记处理开始========");
//		
//		IGDRM0412Form form = dto.getIgdrm0412Form();
//		dto.setEntity(form);
//		SOC0117SearchCondImpl cond = new SOC0117SearchCondImpl();
//		cond.setEsyscoding(form.getEparcoding());
//		List<SOC0117Info> entityList = this.soc0117BL.searchEntity(cond);
//		if(entityList!=null && entityList.size()>0){
//			//资产信息登记处理
//			SOC0117Info entity = this.soc0117BL.registEntity(dto.getEntity(),entityList.get(0).getEid());			
//			dto.setEntity(entity);
//		}else{
//			//资产信息登记处理
//			SOC0117Info entity = this.soc0117BL.registEntity(dto.getEntity(),"");		
//			dto.setEntity(entity);
//		}
//
//		dto.addMessage(new ActionMessage( "IGCO10000.I004", "分类基本信息") );
//
//		log.debug("========资产信息登记处理终了========");
//		return dto;
//	}
	/**
	 * 资产信息编辑画面初期显示处理
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
//	public IGDRM04DTO initIGDRM0412Action(IGDRM04DTO dto) throws BLException {
//
//		log.debug("========资产信息编辑画面初期显示处理开始========");
//		
//		IGDRM0412Form form = dto.getIgdrm0412Form();
//		
//		String eidStr = form.getEidStr();
//		
//		String eid = form.getEidStr();
//		
//		//显示用资产信息取得
//		SOC0117Info entity = this.soc0117BL.searchEntityByKey(eid);
//		
//		if ( entity == null ){
//			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
//					"IGCO10000.E004","变更对象资产基本");
//		}
//		
//		//画面显示设定
//		form.setEcategory(entity.getEcategory());
//		form.setEdesc(entity.getEdesc());
//		form.setEid(entity.getEid());
//		form.setEkey1(entity.getEkey1());
//		form.setEkey2(entity.getEkey2());
//		form.setEkey3(entity.getEkey3());
//		form.setElabel(entity.getElabel());
//		form.setEname(entity.getEname());
//		form.setEstatus(entity.getEstatus());
//		form.setEsyscoding(entity.getEsyscoding());
//		form.setEparcoding(entity.getEparcoding());
//		form.setEmodeltype(entity.getEmodeltype());
//		if("999".equals(entity.getEparcoding()))
//		{
//			form.setEparname("资源分类");
//		}
//		else{
//			SOC0117SearchCondImpl ret = new SOC0117SearchCondImpl();
//			ret.setEsyscoding(entity.getEparcoding());
//			List<SOC0117Info> list = this.soc0117BL.searchEntity(ret, 0, 0);
//			for (int i = 0; i < list.size(); i++) {
//				form.setEparname(list.get(0).getEname());
//			}
//		}
//		form.setEidStr(eidStr);
//		
//		//编辑模式设定
//		form.setMode("1");
//		
//		dto.setIgdrm0412Form(form);
//		
//		dto.addMessage(new ActionMessage("IGCO10000.I001","分类基本信息"));
//		
//		log.debug("========资产信息编辑画面初期显示处理终了========");
//		return dto;
//	}

	/**
	 * 资产信息更新处理
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
//	public IGDRM04DTO updateEntityAction(IGDRM04DTO dto) throws BLException {
//		log.debug("========资产信息更新处理开始========");
//		
//		//资产信息更新处理
//		this.soc0117BL.updateEntity(dto.getEntity());
//		
//		dto.addMessage(new ActionMessage( "IGCO10000.I005", "分类基本信息") );
//		log.debug("========资产信息更新处理终了========");
//		return dto;
//	}
	/**
	 * 应急资源信息登记处理
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO insertEntityAction(IGDRM04DTO dto) throws BLException {
		log.debug("========应急资源信息登记处理开始========");
		
		IGDRM0412Form form = dto.getIgdrm0412Form();
		//获取最大编号
		EmergencyResourceSearchCondImpl erCond = new EmergencyResourceSearchCondImpl();
		erCond.setErparcode(form.getEparcoding());
		erCond.setOrder("DESC");
		erCond.setOrderby("ercode");
		List<EmergencyResourceInfo> list = emergencyResourceBL.searchEmergencyResource(erCond);
		String ercode = "";
		if(list!=null&&list.size()>0){
			EmergencyResourceInfo info = list.get(0);
			String str = info.getErcode();
			String currentCount = str.substring(str.length()-3, str.length());
			Integer count = Integer.parseInt(currentCount.replaceAll("0", "")) + 1;
			ercode = form.getEparcoding() + "000".substring(0,3-(count + "").length()) + count;
		}else{
			ercode = form.getEparcoding() + "001";
		}
		EmergencyResourceTB erTB = new EmergencyResourceTB();
		String[] cids = form.getCids();
		String cidstr = "";
		if(cids!=null&&cids.length>0){
			for(String cid : cids){
				cidstr = cidstr + cid +"_";
			}
		}
		if(StringUtils.isNotEmpty(cidstr)) erTB.setErcids(cidstr.substring(0, cidstr.length()-1));
		erTB.setEsyscoding(form.getEsyscoding());
		erTB.setErparcode(form.getEparcoding());
		erTB.setErcode(ercode);
		erTB.setErname(form.getErname());
		erTB.setErdesc(form.getEdesc());
		erTB.setErcreatetime(DateUtils.getCurrentTime());
		erTB.setErstatus("1");
		erTB.setEruserid(dto.getUser().getUserid());
		erTB.setErusername(dto.getUser().getUsername());
		emergencyResourceBL.registEmergencyResource(erTB);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "应急资源模型基本信息") );
		
		log.debug("========应急资源信息登记处理终了========");
		return dto;
	}
	/**
	 * 应急资源信息编辑画面初期显示处理
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO initIGDRM0412Action(IGDRM04DTO dto) throws BLException {

		log.debug("========资产信息编辑画面初期显示处理开始========");
		
		IGDRM0412Form form = dto.getIgdrm0412Form();
		
		String eidStr = form.getEidStr();
		
		EmergencyResourceInfo info = emergencyResourceBL.searchEmergencyResourceByPK(Integer.parseInt(form.getEidStr()));
		//显示用资产信息取得
//		SOC0117Info entity = this.soc0117BL.searchEntityByKey(eid);
		
		if ( info == null ){
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","应急资源模型基本");
		}
		//画面显示设定
		form.setFingerPrint(info.getErid()+"");
		form.setEdesc(info.getErdesc());
		form.setErname(info.getErname());
//		form.setEname(info.getEname());
		form.setEstatus(info.getErstatus());
		if(StringUtils.isNotEmpty(info.getEsyscoding())){
			SOC0117VWInfo s0117info = soc0117VWBL.searchEntityByKey(new SOC0117VWPK(Integer.parseInt(info.getEsyscoding().split("_")[0]), info.getEsyscoding().split("_")[1]));
			if(s0117info!=null){
				form.setEsyscoding(s0117info.getId()+"_"+s0117info.getEid()+"_"+s0117info.getEsyscoding());
				form.setEname(s0117info.getEname());
			}
		}
		form.setEparcoding(info.getErparcode());
		if("000".equals(info.getErparcode()))
		{
			form.setEparname("资源模型");
		}
		else{
			EmergencyResourceSearchCondImpl erCond = new EmergencyResourceSearchCondImpl();
			erCond.setErcode(info.getErparcode());
			List<EmergencyResourceInfo> list = emergencyResourceBL.searchEmergencyResource(erCond);
			for (int i = 0; i < list.size(); i++) {
				form.setEparname(list.get(0).getErname());
			}
		}
		form.setEidStr(eidStr);
		
		//编辑模式设定
		form.setMode("1");
		
		dto.setIgdrm0412Form(form);
		
		dto.addMessage(new ActionMessage("IGCO10000.I001","应急资源模型基本信息"));
		
		log.debug("========资产信息编辑画面初期显示处理终了========");
		return dto;
	}

	/**
	 * 应急资源信息更新处理
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO updateEntityAction(IGDRM04DTO dto) throws BLException {
		log.debug("========应急资源信息更新处理开始========");
		
		IGDRM0412Form form = dto.getIgdrm0412Form();
		EmergencyResourceInfo info = emergencyResourceBL.searchEmergencyResourceByPK(Integer.parseInt(form.getEidStr()));
		EmergencyResourceTB erTB = (EmergencyResourceTB) SerializationUtils.clone(info);
		String[] cids = form.getCids();
		String cidstr = "";
		if(cids!=null&&cids.length>0){
			for(String cid : cids){
				cidstr = cidstr + cid +"_";
			}
		}
		if(StringUtils.isNotEmpty(cidstr)) erTB.setErcids(cidstr.substring(0, cidstr.length()-1));
		//应急资源信息更新处理
		erTB.setEsyscoding(form.getEsyscoding());
//		erTB.setErparcode(form.getEparcoding());
		erTB.setErname(form.getErname());
		erTB.setErdesc(form.getEdesc());
//		erTB.setErstatus(form.getEstatus());
		erTB.setEruserid(dto.getUser().getUserid());
		erTB.setErusername(dto.getUser().getUsername());
		emergencyResourceBL.updateEmergencyResource(erTB);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "应急资源模型基本信息") );
		log.debug("========应急资源信息更新处理终了========");
		return dto;
	}
	
	/**
	 * 资产配置信息登记处理
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO insertConfigurationAction(IGDRM04DTO dto) throws BLException {
		log.debug("========资产配置信息登记处理开始========");
		
	/*	//配置信息编号检测
		if (dto.getConfiguration().getClabel().compareTo(
				CommonDefineUtils.COMMON_CONFIG_LABEL_MIN) >=0 &&
				dto.getConfiguration().getClabel().compareTo(
						CommonDefineUtils.COMMON_CONFIG_LABEL_MAX) <=0 ) {
			throw new BLException(BLErrorType.CONFIGURATION_ALREADY_EXISTS,
			"IGCOM0102.E001");
			
		}*/

		//资产配置信息登记处理
		SOC0109Info configuration = this.soc0109BL.registConfiguration(dto.getConfiguration());
		
		dto.setConfiguration(configuration);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "分类配置信息") );

		log.debug("========资产配置信息登记处理终了========");
		return dto;
	}

	/**
	 * 资产详细信息画面初期显示处理
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO initIGDRM0416Action(IGDRM04DTO dto) throws BLException {

		log.debug("========资产详细信息画面初期显示处理开始========");
		//资产基本信息查询
		SOC0117Info entity = this.soc0117BL.searchEntityByKey(dto.getConfigurationSearchCond().getEid());
		
		if (entity == null) {
			//资产基本内容信息不存在
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E001");
		}
		
		dto.setEntity(entity);
		
		//资产配置信息查询件数取得 
		int totalCount = 0;
		List<SOC0117Info> list = this.soc0117BL.getParentNodes(entity.getEid());
		Map<String,List<SOC0109Info>> map = new LinkedHashMap<String,List<SOC0109Info>>();
		SOC0109SearchCondImpl cond = new SOC0109SearchCondImpl();
		cond.setCseq(1);
		//资产配置信息分层次查询
		for(SOC0117Info e : list){
			cond.setEid(e.getEid().toString());
			List<SOC0109Info> configurationList = this.soc0109BL.searchConfiguration(cond, 0, 0);
			map.put(e.getEname(), configurationList);
			totalCount+=configurationList.size();
		}
		if (totalCount == 0) {
			log.debug("========资产配置信息查询数据不存在========");
			//资产配置信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I007",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========资产配置信息查询数据件数过多========");
			//资产配置信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		dto.setConfigurationMap(map);

		dto.addMessage(new ActionMessage("IGCO10000.I007",totalCount));
		
		log.debug("========资产详细信息画面初期显示处理终了========");
		return dto;
	}

	/**
	 * 资产配置信息更新处理
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO updateConfigurationAction(IGDRM04DTO dto) throws BLException {
		log.debug("========资产配置信息更新处理开始========");
		
		//资产配置信息更新处理
		this.soc0109BL.updateConfiguration(dto.getConfiguration());
		
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "分类配置信息") );
		log.debug("========资产配置信息更新处理终了========");
		return dto;
	}
	
	/**
	 * 资产配置信息编辑画面初期显示处理
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO initIGDRM0414Action(IGDRM04DTO dto) throws BLException {

		log.debug("========变更用资产配置信息编辑画面初期显示处理开始========");
		IGDRM0414Form form = dto.getIgdrm0414Form();
		
		String cid = form.getCidStr();
		
		//显示用资产配置信息查询
		SOC0109Info configuration = this.soc0109BL.searchConfigurationByKey(cid);
		
		if ( configuration == null ){
			throw new BLException("IGCO10000.E004","变更对象资产配置");
		}
		
		//显示用设定
		//KEY
		form.setEid(configuration.getEid());
		form.setCid(configuration.getCid());
		//编号
		form.setClabel(configuration.getClabel());
		//名称
		form.setCname(configuration.getCname());
		//单位
		form.setCunit(configuration.getCunit());
		//必填
		form.setCrequired(configuration.getCrequired());
		//状态
		form.setCstatus(configuration.getCstatus());
		//说明
		form.setCdesc(configuration.getCdesc());
		//类别
		form.setCcategory(configuration.getCcategory());
		//取值范围
		form.setCoption(configuration.getCoption());
		//取值范围
		if("2".equals(configuration.getCattach())){
			SOC0151SearchCondImpl cond = new SOC0151SearchCondImpl();
			cond.setCcdcategory(configuration.getCoption());
			cond.setCcdstatus("1");
			List<SOC0151Info> list = soc0151BL.searchConfigurationCodeDetail(cond, 0, 0);
			if(!list.isEmpty()){
				form.setRangename(list.get(0).getCcdlabel());
			}
		}else if ("4".equals(configuration.getCattach())){//属性值关联分类
			SOC0117SearchCondImpl cond = new SOC0117SearchCondImpl();
			cond.setEsyscoding(configuration.getCoption());
			List<SOC0117Info> list = soc0117BL.searchEntity(cond, 0, 0);
			if(list.size() == 1){
				form.setCename(list.get(0).getEname());
			}else{
				throw new BLException("IGDRM0414.E001",dto.getEntitySearchCond().getEsyscoding());
			}
			form.setCesyscoding(configuration.getCoption());
			form.setCoption(null);
		}
		
		//顺序
		form.setCseq(configuration.getCseq());
		
		//附件标识
		form.setCattach(configuration.getCattach());
		
		form.setCstatus(configuration.getCstatus());
		
		//编辑模式设定
		form.setMode("1");
		
		dto.setIgdrm0414Form(form);
		
		dto.addMessage(new ActionMessage("IGCO10000.I001","分类配置信息"));
		
		log.debug("========变更用资产配置信息编辑画面初期显示处理终了========");
		return dto;
	}

	/**
	 * 资产信息删除处理
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO deleteEntityAction(IGDRM04DTO dto) throws BLException {
		log.debug("========资产信息删除处理开始========");
		
		for( int i=0;i<dto.getDeleteEntity().length;i++ ){
			String eid = dto.getDeleteEntity()[i];
			
			//资产信息查询处理
			SOC0117Info entity = this.soc0117BL.searchEntityByKey(eid);
			
			if (entity == null){
				throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
						"IGCO10000.E004","删除对象资产基本");
			}

			//资产信息删除处理
			this.soc0117BL.deleteEntity(entity);
		}
		
		log.debug("========资产信息删除处理终了========");
		return dto;
	}
	
	/**
	 * 资产配置信息删除处理
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO deleteConfigurationAction(IGDRM04DTO dto) throws BLException {
		log.debug("========资产配置信息删除处理开始========");
		
		for( int i=0;i<dto.getDeleteConfiguration().length;i++ ){
			String cid = dto.getDeleteConfiguration()[i];
			
			//资产配置信息查询
			SOC0109Info configuration = 
				this.soc0109BL.searchConfigurationByKey(cid);
			
			if (configuration == null){
				throw new BLException("IGCO10000.E004","删除对象资产配置");
			}
			
			//资产配置信息删除
			this.soc0109BL.deleteConfiguration(configuration);
		}
		
		log.debug("========资产配置信息删除处理终了========");
		return dto;
	}
	
	/**
	 * 资产下拉数据标识查询
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO searchConfigurationCodeDetailBean(IGDRM04DTO dto) throws BLException {
		log.debug("========资产下拉数据查询处理开始========");
		SOC0151SearchCondImpl cond = new SOC0151SearchCondImpl();
		cond.setCcdtype("A");
		cond.setCcdstatus("1");
		List<ConfigurationCodeDetailBean> list = this.soc0151BL.searchConfigurationCodeDetailBean(cond);
		dto.setConfigurationCodeDetailBeanList(list);
		log.debug("========资产下拉数据查询处理终了========");
		return dto;
	}
	
	/**
	 * 资产下拉数据标识查询
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO searchConfigurationCodeDetail(IGDRM04DTO dto) throws BLException {
		log.debug("========资产下拉数据查询处理开始========");
		if(dto.getIgdrm0419Form() != null){
			this.changeCfgCodeDetailLabel(dto);
		}
		SOC0151SearchCondImpl cond = new SOC0151SearchCondImpl();
		cond.setCcdtype("A");
		List<String> tempList = new ArrayList<String>();
		List<SOC0151Info> retList = new ArrayList<SOC0151Info>();
		List<SOC0151Info> list = this.soc0151BL.searchConfigurationCodeDetail(cond, 0, 0);
		for (SOC0151Info configurationCodeDetail : list) {
			String ccdcategory = configurationCodeDetail.getCcdcategory();
			if(!tempList.contains(ccdcategory)){
				tempList.add(ccdcategory);
				retList.add(configurationCodeDetail);
			}
		}
		dto.setConfigurationCodeDetailList(retList);
		log.debug("========资产下拉数据查询处理终了========");
		return dto;
	}
	
	protected void changeCfgCodeDetailLabel(IGDRM04DTO dto) throws BLException{
		SOC0151SearchCondImpl cond = new SOC0151SearchCondImpl();
		cond.setCcdcategory(dto.getIgdrm0419Form().getCcdcategory());
		List<SOC0151Info> list = this.soc0151BL.searchConfigurationCodeDetail(cond, 0, 0);
		for (SOC0151Info configurationCodeDetail : list) {
			SOC0151TB ccdTB = (SOC0151TB) configurationCodeDetail;
			ccdTB.setCcdlabel(dto.getIgdrm0419Form().getCcdlabel());
			this.soc0151BL.registConfigurationCodeDetail(ccdTB);
		}
	}
	
	public IGDRM04DTO searchCfgCodeDetailByCategory(IGDRM04DTO dto) throws BLException {
		log.debug("========资产下拉数据查询处理开始========");
		if("changeValue".equals(dto.getStrflag())){
			this.changeCfgCodeDetailValue(dto);
		} else if ("status".equals(dto.getStrflag())){
			this.changeCfgCodeDetailStatus(dto);
		}
		SOC0151SearchCondImpl cond = new SOC0151SearchCondImpl();
		cond.setCcdtype("A");
		cond.setCcdcategory(dto.getIgdrm0420Form().getCcdcategory());
		List<SOC0151Info> list = this.soc0151BL.searchConfigurationCodeDetail(cond, 0, 0);
		dto.setConfigurationCodeDetailList(list);
		log.debug("========资产下拉数据查询处理终了========");
		return dto;
	}
	
	protected void changeCfgCodeDetailValue(IGDRM04DTO dto) throws BLException{
		Integer ccdid = Integer.valueOf(dto.getIgdrm0420Form().getCcdid());
		SOC0151Info configurationCodeDetail = soc0151BL.searchConfigurationCodeDetailByKey(ccdid);
		SOC0151TB ccdTB = (SOC0151TB) configurationCodeDetail;
		ccdTB.setCcdvalue(dto.getIgdrm0420Form().getCcdvalue());
		this.soc0151BL.registConfigurationCodeDetail(ccdTB);
	}
	
	protected void changeCfgCodeDetailStatus(IGDRM04DTO dto) throws BLException{
		Integer ccdid = Integer.valueOf(dto.getIgdrm0420Form().getCcdid());
		SOC0151Info configurationCodeDetail = soc0151BL.searchConfigurationCodeDetailByKey(ccdid);
		SOC0151TB ccdTB = (SOC0151TB) configurationCodeDetail;
		if("1".equals(ccdTB.getCcdstatus())){
			ccdTB.setCcdstatus("0");
		}else if ("0".equals(ccdTB.getCcdstatus())){
			ccdTB.setCcdstatus("1");
		}
		this.soc0151BL.registConfigurationCodeDetail(ccdTB);
	}
	
	/**
	 * 资产下拉数据登记处理
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO insertConfigurationCodeDetailAction(IGDRM04DTO dto) throws BLException {
		log.debug("========资产信息登记处理开始========");
		
		IGDRM0418Form igdrm0418form = dto.getIgdrm0418Form();
		String[] values = igdrm0418form.getCcdvalues();
		igdrm0418form.setCcdtype("A");
		igdrm0418form.setCcdstatus("1");
		String ccdcategory = "";
		SOC0151SearchCondImpl cond = new SOC0151SearchCondImpl();
		List<SOC0151Info> list = this.soc0151BL.searchConfigurationCodeDetail(cond, 0, 0);
		if(list.size()>0){//存在下级机构
			SOC0151Info ConfigurationCodeDetail = list.get(list.size() - 1);
			ccdcategory = ConfigurationCodeDetail.getCcdcategory();
			
			if(ccdcategory.equals("999")){
				throw new BLException("IGSYM0101.E004","数据基本信息");
			}
			if(Integer.parseInt(ccdcategory)<999){
				String tmp = String.valueOf(Integer.valueOf(ccdcategory)+1);
				if(tmp.length()==1){
					ccdcategory = "00"+tmp;
				}else if(tmp.length()==2){
					ccdcategory = "0"+tmp;
				}else{
					ccdcategory = tmp;
				}
			}
			igdrm0418form.setCcdcategory(ccdcategory);
		}else{
			igdrm0418form.setCcdcategory("001");
		}
		if (values!=null && values.length>0) {
			for (int i = 0; i < values.length; i++) {
				igdrm0418form.setCcdvalue(values[i]);
				dto.setIgdrm0418Form(igdrm0418form);
				dto.setConfigurationcodedetail(igdrm0418form);
				SOC0151Info configurationcodedetail = this.soc0151BL.registConfigurationCodeDetail(dto.getConfigurationcodedetail());
				dto.setConfigurationcodedetail(configurationcodedetail);
			}
		}else{
			dto.setIgdrm0418Form(igdrm0418form);
			dto.setConfigurationcodedetail(igdrm0418form);
			SOC0151Info configurationcodedetail = this.soc0151BL.registConfigurationCodeDetail(dto.getConfigurationcodedetail());
			dto.setConfigurationcodedetail(configurationcodedetail);
		}
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "数据基本信息") );

		log.debug("========资产信息登记处理终了========");
		return dto;
	}
	
/**
 * 查询应急资源分类名称
 * @param dto
 * @return
 * @throws BLException
 */

	public IGDRM04DTO searchEntityNameActionSOC(IGDRM04DTO dto) throws BLException
	{
		SOC0117SearchCondImpl cond = new SOC0117SearchCondImpl();
		cond.setEsyscoding(dto.getEsyscoding());
		List<SOC0117Info> list = soc0117BL.searchEntity(cond, 0, 0);
		if (list.size() == 1)
		{
			dto.setEname(list.get(0).getEname());
		}
		else
		{
			throw new BLException("IGASM0104.E001", dto.getEsyscoding());
		}
		return dto;
	}
	
	/**
	 * 获取应急资源详细信息
	 * 
	 * @param dto    IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO getEntityFullInfo(IGDRM04DTO dto) throws BLException
	{
		log.debug("========应急资源详细信息画面初期化处理开始========");
		
		IGDRM0406Form form = (IGDRM0406Form)dto.getForm();

		// 设备信息检索
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(Integer.valueOf(form.getSp_eiid()));

		if (entityItemVWInfo == null)
		{
			throw new BLException("IGCO10000.E004", "属性");
		}

		dto.setSoc0124Info(entityItemVWInfo);

		// 配置信息查询件数取得
		SOC0107SearchCondImpl socCond = new SOC0107SearchCondImpl();
		BeanUtils.copyProperties(form, socCond);
		// 配置项配置信息全件查询
		SOC0129SearchCondImpl cond = new SOC0129SearchCondImpl();
		cond.setEiid(entityItemVWInfo.getEiid().toString());
		cond.setEsyscoding_q(entityItemVWInfo.getEsyscoding());
		List<SOC0129Info> configItemVWInfoList = this.soc0107BL.searchConfigItemVW(cond, 0, 0);

		Map<String, List<SOC0129Info>> map = new LinkedHashMap<String, List<SOC0129Info>>();
		List<String> strlist = new ArrayList<String>();
		for (SOC0129Info e : configItemVWInfoList)
		{
			if (!map.containsKey(e.getCcategory()))
			{
				map.put(e.getCcategory(), new ArrayList<SOC0129Info>());
				strlist.add(e.getCcategory());
			}
			map.get(e.getCcategory()).add(e);
		}

		dto.setSoc0129InfoVWMap(map);

		log.debug("========配置详细信息初期化处理终了========");
		return dto;

	}

	
	
	public IGDRM04DTO getCfgCodeDetailByCategory(IGDRM04DTO dto) throws BLException {
		log.debug("========资产下拉数据查询处理开始========");
		SOC0151SearchCondImpl cond = new SOC0151SearchCondImpl();
		cond.setCcdtype("A");
		cond.setCcdcategory(dto.getIgdrm0421Form().getCcdcategory());
		List<SOC0151Info> list = this.soc0151BL.searchConfigurationCodeDetail(cond, 0, 0);
		dto.setConfigurationcodedetail(list.get(0));
		log.debug("========资产下拉数据查询处理终了========");
		return dto;
	}
	
	public IGDRM04DTO insertCfgCodeDetailAction(IGDRM04DTO dto) throws BLException {
		log.debug("========资产信息登记处理开始========");
		IGDRM0421Form igdrm0421form = dto.getIgdrm0421Form();
		String[] values = igdrm0421form.getCcdvalues();
		igdrm0421form.setCcdtype("A");
		igdrm0421form.setCcdstatus("1");
		for (int i = 0; i < values.length; i++) {
			igdrm0421form.setCcdvalue(values[i]);
			dto.setConfigurationcodedetail(igdrm0421form);
			this.soc0151BL.registConfigurationCodeDetail(dto.getConfigurationcodedetail());
		}
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "数据基本信息") );

		log.debug("========资产信息登记处理终了========");
		return dto;
	}
	
	/**
	 * 资产属性默认值编辑画面初期化处理
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 * @throws BLException
	 */
	public IGDRM04DTO initIGDRM0424Action(IGDRM04DTO dto) throws BLException {
		log.debug("========资产属性默认值编辑画面初期化处理开始========");
		IGDRM0424Form form = dto.getIgDRM0424Form();
		IG611SearchCondImpl cond = new IG611SearchCondImpl();
		cond.setEsyscoding(form.getEsyscoding());
		cond.setEid(form.getEid());
		//配置项配置信息全件查询
		List<IG612Info> lst_IG612Info = this.ig611BL.searchDefaultValue(cond);
		//查询分类信息
		SOC0117Info ig117info = soc0117BL.searchEntityByKey(form.getEid());
		if(ig117info != null){
			//为分类名称与分类说明赋值
			form.setEname(ig117info.getEname());
			form.setEdesc(ig117info.getEdesc());
		}
		int totalCount = lst_IG612Info.size();
		String[] Cvalue = new String[totalCount];
		String[] entityItemCvalue = new String[totalCount];
		Map<String,List<IG612Info>> map = new LinkedHashMap<String,List<IG612Info>>();
		int i = 0;
		int j = 0;
		List<String> strlist = new ArrayList<String>();
		for(IG612Info e : lst_IG612Info){
			if(!map.containsKey(e.getCcategory())){
				map.put(e.getCcategory(), new ArrayList<IG612Info>());
				strlist.add(e.getCcategory());
			}
			map.get(e.getCcategory()).add(e);
			if("2".equals(e.getCattach())){
				List<LabelValueBean> list = soc0151BL.searchLabelValueBeanList(e.getCoption());
				form.setSelectedListMap(j++, list);
			}
			if ("5".equals(e.getCattach())) {
				List<LabelValueBean> list =soc0151BL.searchLabelValueBeanList(e
						.getCoption());
				if (list.size() > 0) {
					list.remove(0);
				}
				form.setSelectedListMap(j++, list);
			}
		}
		for(String str : strlist){
			for(IG612Info e : map.get(str)){
				//显示是资产名称，实际存值是资产名称(资产ID)
				if("4".equals(e.getCattach()) && StringUtils.isNotEmpty(e.getCvalue())){
					Cvalue[i] = e.getCvalue().substring(0, e.getCvalue().lastIndexOf("("));
					entityItemCvalue[i] = e.getCvalue();
				} else {
					Cvalue[i] = e.getCvalue();
				}
				i++;
			}
		}
		form.setCvalue(Cvalue);
		form.setEntityItemCvalue(entityItemCvalue);
		dto.setMap_IG612Info(map);
		log.debug("========资产属性默认值编辑画面初期化处理终了========");
		return dto;
	}
	
	/**
	 * 资产属性默认值编辑处理
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 * @throws BLException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public IGDRM04DTO editIGDRM0424Action(IGDRM04DTO dto) throws BLException, FileNotFoundException, IOException {
		log.debug("========资产属性默认值编辑处理开始========");
		IGDRM0424Form form = dto.getIgDRM0424Form();
		//查询分类信息
		SOC0117Info entity = this.soc0117BL.searchEntityByKey(form.getEid());
		SOC0117TB etb = (SOC0117TB)SerializationUtils.clone(entity);
		etb.setEdesc(form.getEdesc());
		etb.setEname(form.getEname());
		//更新分类信息
		this.soc0117BL.updateEntity(etb);
		for( int i=0 ; i < form.getCid().length; i++ ){
			IG611TB ig611 = new IG611TB();
			//类型ID
			ig611.setEid(Integer.parseInt(form.getEid()));
			//资产配置ID
			ig611.setCid(Integer.parseInt(form.getCid()[i]));
			//内容
			ig611.setCvalue(form.getCvalue()[i]);
			//显示是资产名称，实际存值是资产名称(资产ID)
			if("4".equals(form.getCiattach()[i]) && StringUtils.isNotEmpty(form.getEntityItemCvalue()[i])){
				ig611.setCvalue(form.getEntityItemCvalue()[i]);
			}
			//附件删除
			if("1".equals(form.getCiattach()[i]) && "1".equals(form.getDelfile()[i])){
				ig611.setCvalue("");
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
					//备件ID
					pathBuf.append("model");
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
					
					//文件名
					fileName.append("_");
					fileName.append(form.getEid());
					fileName.append("&");
					fileName.append(form.getCid()[i]);
					//文件扩展名
					fileName.append(fileType);

					//文件上传处理
					this.fileUploadBL.saveFile(file, pathBuf.toString(), fileName.toString());
					
					//内容
					//上传文件名保存
					ig611.setCvalue(fileName.toString());
				}
			}
			this.ig611BL.registIG611Info(ig611);
		}
		dto.addMessage(new ActionMessage("IGCO10000.I005","备件分类及其配置信息"));
		log.debug("========资产属性默认值编辑处理终了========");
		return dto;
	}
	/**
	 * 应急资源资产关联查询处理(初始化)
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO searchEntityDisp(IGDRM04DTO dto) throws BLException {
		
		log.debug("========设备信息查询处理开始========");
		//获取form
		IGDRM0402Form form = dto.getIgdrm0402Form();
		//分页用信息取得
		PagingDTO pDto = dto.getPagingDto();
		EmergencyResourceInfo erInfo = emergencyResourceBL.searchEmergencyResourceByPK(form.getErid());
		String esyscoding = erInfo.getEsyscoding();
		SOC0117VWInfo s117Info = soc0117VWBL.searchEntityByKey(new SOC0117VWPK(Integer.parseInt(esyscoding.split("_")[0]), esyscoding.split("_")[1]));
		form.setEname(s117Info.getEname());
		form.setEsyscoding(esyscoding.split("_")[0]+"_"+esyscoding.split("_")[2]);
		//设备信息查询件数取得 
		SOC0118VWSearchCondImpl cond = new SOC0118VWSearchCondImpl();
		cond.setId(Integer.parseInt(esyscoding.split("_")[0]));
		cond.setEsyscoding_like(esyscoding.split("_")[2]);
		int totalCount = this.soc0118VWBL.getEntityItemSearchCount(cond);
		if (totalCount == 0) {
			log.debug("========资产信息查询数据不存在========");
			//资产信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========资产信息查询数据件数过多========");
			//资产信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		List<SOC0118VWInfo> entityItemVWInfoList = this.soc0118VWBL.searchEntityItem(cond,  pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setEntityItemVWInfoList(entityItemVWInfoList);
		dto.setIgdrm0402Form(form);
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========设备信息查询处理终了========");
		return dto;
	}
	/**
	 * 应急资源资产关联查询处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGDRM04DTO searchEntityItemAction(IGDRM04DTO dto) throws BLException {

		log.debug("========设备信息查询处理开始========");
		//获取form
		IGDRM0402Form form = dto.getIgdrm0402Form();
		//分页用信息取得
		PagingDTO pDto = dto.getPagingDto();
		
		//设备信息查询件数取得 
//		int totalCount = this.soc0118BL.getEntityItemVWSearchCount(dto.getEntityItemVWSearchCond());\
		SOC0118VWSearchCondImpl cond = new SOC0118VWSearchCondImpl();
		cond.setId(Integer.parseInt(form.getEsyscoding().split("_")[0]));
		cond.setEiinsdate_gt(form.getEiupdtime_from());
		cond.setEiinsdate_lt(form.getEiupdtime_to());
		cond.setEiname(form.getEiname());
		cond.setEid(form.getEid());
		cond.setEiname(form.getEiname());
		cond.setEsyscoding_like(form.getEsyscoding().split("_")[1]);
		cond.setEiorgsyscoding(form.getEiorgsyscoding());
		cond.setResourceType(form.getResourceType());
		int totalCount = this.soc0118VWBL.getEntityItemSearchCount(cond);
//		int totalCount = entityItemVWInfoList!=null&&entityItemVWInfoList.size()>0?entityItemVWInfoList.size():0;
		if (totalCount == 0) {
			log.debug("========资产信息查询数据不存在========");
			//资产信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========资产信息查询数据件数过多========");
			//资产信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		List<SOC0118VWInfo> entityItemVWInfoList = this.soc0118VWBL.searchEntityItem(cond,  pDto.getFromCount(), pDto.getPageDispCount());


		//当前页资产信息取得
//		List<SOC0124Info> entityItemVWInfoList = this.soc0118BL.searchEntityItemVW(dto.getEntityItemVWSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setEntityItemVWInfoList(entityItemVWInfoList);

		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========设备信息查询处理终了========");
		return dto;
	}
	/**
	 * 应急资源资产关联处理
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO setRelationAction(IGDRM04DTO dto) throws BLException{
		log.debug("========应急资源关联资产处理开始========");
		IGDRM0402Form form = dto.getIgdrm0402Form();
		String[] relationEiid = form.getRelationEiid();//需要关联的资产
		String ercode = form.getErcode();//应急资源编码
		Integer erid = form.getErid();//应急资源id
		ErRelationSearchCondImpl errCond = new ErRelationSearchCondImpl();
		errCond.setErid(erid);
		errCond.setErcode(ercode);
		errCond.setResourceType(form.getResourceType());
		for(String eiid : relationEiid){
			errCond.setEiid(eiid);
			List<ErRelationInfo> errList = erRelationBL.searchErRelation(errCond);
			if(errList!=null&&errList.size()>0){
				if("1".equals(errList.get(0).getDeleteflag())){
					ErRelationTB errTB = (ErRelationTB) SerializationUtils.clone(errList.get(0));
					errTB.setDeleteflag("0");
					erRelationBL.updateErRelation(errTB);
				}
			}else{
				ErRelationTB errTB = new ErRelationTB();
				errTB.setEiid(eiid);
				errTB.setErid(erid);;
				errTB.setErcode(ercode);
				errTB.setDeleteflag("0");
				//占用 fingerprint字段存储 资源类型 (1:应急,0:演练);
				//张剑 2017年3月17日11:04:03
				errTB.setFingerPrint(form.getResourceType());
				erRelationBL.registErRelation(errTB);
			}
			
		}
		log.debug("========应急资源关联资产处理结束========");
		return dto;
	}
	/**
	 * 应急资源资产批量解除关联关系
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO deleteRelationAction(IGDRM04DTO dto) throws BLException{
		log.debug("========应急资源批量解除关联资产处理开始========");
		IGDRM0402Form form = dto.getIgdrm0402Form();
		String[] relationEiid = form.getDeleteEiid();//需要解除关联的资产
//		String ercode = form.getErcode();//应急资源编码
//		Integer erid = form.getErid();//应急资源id
		ErRelationSearchCondImpl errCond = new ErRelationSearchCondImpl();
//		errCond.setErid(erid);
//		errCond.setErcode(ercode);
		for(String eiid : relationEiid){
			errCond.setEiid(eiid.split("_")[0]+ "_" +eiid.split("_")[1]);
			errCond.setErcode(eiid.split("_")[2]);
			errCond.setResourceType(form.getResourceType());
			List<ErRelationInfo> errList = erRelationBL.searchErRelation(errCond);
			if(errList!=null&&errList.size()>0){
				ErRelationTB errTB = (ErRelationTB) SerializationUtils.clone(errList.get(0));
				errTB.setDeleteflag("1");
				erRelationBL.updateErRelation(errTB);
			}
		}
		dto.addMessage(new ActionMessage("IGCO10000.I006", "应急资源"));
		log.debug("========应急资源批量解除关联资产处理结束========");
		return dto;
	}
	/**
	 * 应急资源修改对应资产模型（已有关联不能修改）
	 *
	 * @param erid
	 * @return boolean
	 */
	public boolean searchRelationAjaxAction(Integer erid) throws BLException{
		ErRelationSearchCondImpl cond = new ErRelationSearchCondImpl();
		cond.setErid(erid);
		cond.setDeleteflag("NOTONE");
		List<ErRelationInfo> list = erRelationBL.searchErRelation(cond);
		if(list!=null&&list.size()>0){
			return true;
		}else{
			
			return false;
		}
	}
	/**
	 * 应急资源资产解除单个关联关系
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO deleteSigleRelationAction(IGDRM04DTO dto) throws BLException{
		log.debug("========应急资源关解除联资产处理开始========");
		IGDRM0402Form form = dto.getIgdrm0402Form();
		Integer eiid = form.getEiid();//需要解除关联的资产
		String ercode = form.getErcode();//应急资源编码
		Integer erid = form.getErid();//应急资源id
		ErRelationSearchCondImpl errCond = new ErRelationSearchCondImpl();
		errCond.setErid(erid);
		errCond.setErcode(ercode);
		errCond.setEiid(eiid+"");
		List<ErRelationInfo> errList = erRelationBL.searchErRelation(errCond);
			if(errList!=null&&errList.size()>0){
				ErRelationTB errTB = (ErRelationTB) SerializationUtils.clone(errList.get(0));
				errTB.setDeleteflag("1");
				erRelationBL.updateErRelation(errTB);
			}
		log.debug("========应急资源关解除联资产处理结束========");
		return dto;
	}
	
	/**
	 * 获取应急资源分类树显示内容
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM04DTO getTreeNodeNameCountAction(IGDRM04DTO dto) throws BLException {
		log.debug("=========获取应急资源分类树显示内容开始=========");
		IGDRM0402Form form = dto.getIgdrm0402Form();
		SOC0118VWSearchCondImpl cond = new SOC0118VWSearchCondImpl();
		cond.setEsyscoding_like(form.getErcode());
		cond.setResourceType(dto.getResourceType());
		// 应急资源查询件数取得
		int totalCount = this.soc0118VWBL.getEmergencyRelationCount(cond );
		dto.setAjaxResult(totalCount + "");
		log.debug("=========获取应急资源分类树显示内容结束=========");
		return dto;
	}
	
	/** 资产分类属性缺省值BL */
	protected IG611BL ig611BL;

	/**
	 * 资产分类属性缺省值BL设定
	 * 
	 * @param ig611BL 资产分类属性缺省值BL
	 */
	public void setIg611BL(IG611BL ig611BL) {
		this.ig611BL = ig611BL;
	}
}
