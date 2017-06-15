package com.deliverik.infogovernor.soc.cim.bl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;
import org.apache.struts.util.LabelValueBean;
import org.apache.struts.util.MessageResources;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.bl.FileUploadBL;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;
import com.deliverik.framework.model.entity.CodeDetailTBPK;
import com.deliverik.framework.soc.asset.EiDomainKeyWords;
import com.deliverik.framework.soc.asset.EiRelationKeyWords;
import com.deliverik.framework.soc.asset.EntityCategory;
import com.deliverik.framework.soc.asset.EntityItemKeyWords;
import com.deliverik.framework.soc.asset.SOC0138Info;
import com.deliverik.framework.soc.asset.TableSpaceInfo;
import com.deliverik.framework.soc.asset.bl.task.PlatformManagerBL;
import com.deliverik.framework.soc.asset.bl.task.SOC0107BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0109BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0110BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0111BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0112BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0113BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0114BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0117BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0119BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0126BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0151BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0152BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0153BL;
import com.deliverik.framework.soc.asset.model.PlatformManagerInfo;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.SOC0109Info;
import com.deliverik.framework.soc.asset.model.SOC0110Info;
import com.deliverik.framework.soc.asset.model.SOC0111Info;
import com.deliverik.framework.soc.asset.model.SOC0112Info;
import com.deliverik.framework.soc.asset.model.SOC0113Info;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0119Info;
import com.deliverik.framework.soc.asset.model.SOC0123Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0126Info;
import com.deliverik.framework.soc.asset.model.SOC0127Info;
import com.deliverik.framework.soc.asset.model.SOC0128Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.framework.soc.asset.model.SOC0152Info;
import com.deliverik.framework.soc.asset.model.SOC0153Info;
import com.deliverik.framework.soc.asset.model.condition.PlatformManagerVWSearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0107SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0107SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0109SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0110SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0117SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0118SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0119SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0126SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0127SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0152SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0153SearchCondImpl;
import com.deliverik.framework.soc.asset.model.entity.RelationTreeTB;
import com.deliverik.framework.soc.asset.model.entity.SOC0107TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0110TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0112PK;
import com.deliverik.framework.soc.asset.model.entity.SOC0112TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0118TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0119TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0123VW;
import com.deliverik.framework.soc.asset.model.entity.SOC0124VW;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.bl.task.OrganizationBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.OrganizationSearchCondImpl;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.utility.BLErrorType;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.asset.bl.IGASM03BLImpl;
import com.deliverik.infogovernor.soc.bl.task.CR01BL;
import com.deliverik.infogovernor.soc.bl.task.CR03BL;
import com.deliverik.infogovernor.soc.bl.task.SocRelationBL;
import com.deliverik.infogovernor.soc.cim.bl.task.IG500VWBL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM01DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0101Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0102Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0104Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0107Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0108Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0110Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0111Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0112Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0114Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0122Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0124Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0127Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0128Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0129Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0135Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0136Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0137Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0139Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0146Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0148Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0149Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0152Form;
import com.deliverik.infogovernor.soc.cim.model.IG500VWInfo;
import com.deliverik.infogovernor.soc.cim.model.condition.IG500VWSearchCondImpl;
import com.deliverik.infogovernor.soc.model.CR01VWInfo;
import com.deliverik.infogovernor.soc.model.CR03VWInfo;
import com.deliverik.infogovernor.soc.model.NetDeviceInfo;
import com.deliverik.infogovernor.soc.model.condition.CR01SearchCondImpl;
import com.deliverik.infogovernor.soc.model.condition.CR03SearchCondImpl;
import com.deliverik.infogovernor.soc.model.entity.SocRelationTB;
import com.deliverik.infogovernor.util.ASMHelper;
import com.deliverik.infogovernor.util.CodeDefine;

/**
 * 设备配置管理业务逻辑实现
 *
 */
public class IGCIM01BLImpl extends BaseBLImpl implements IGCIM01BL {

	static Log log = LogFactory.getLog(IGCIM01BLImpl.class);
	
	protected static Map<String,String> resource_cid = new HashMap<String,String>();
	static{
		resource_cid.put("CM01010001", "CI010100010025");	//主机
		resource_cid.put("CM01010034", "CI010100010025");	//linux
		resource_cid.put("CM01010039", "CI010100010025");	//windows
		resource_cid.put("CM02010001", "CI020100010005");	//oracle
		resource_cid.put("CM02110001", "CI021100010005");	//sqlserver
	}
	
	public static final String DEVICE_DEVICE = "001-001";
	
	public static final String DEVICE_DEVICE_CONN_ID = "1";
	/** 资产信息BL */
	protected SOC0117BL soc0117BL;

	/** 配置项信息BL */
	protected SOC0118BL soc0118BL;
	
	/** 资产配置项BL */
	protected SOC0107BL soc0107BL;
	
	/**链路BL*/
	protected SOC0114BL soc0114BL;
	
	/** 配置项关系BL */
	protected SOC0119BL soc0119BL;
	
	/** 文件上传BL */
	protected FileUploadBL fileUploadBL;
	
	/** 资产取值范围下拉数据BL */
	protected SOC0151BL soc0151BL;
	
	/** 资产关联关系下拉数据BL */
	protected CodeDetailBL codeDetailBL;
	
	/** 机构BL */
	protected OrganizationBL organizationBL;
	
	/** 配置项BL */
	protected SOC0109BL soc0109BL;
	
	/** 用户角色BL */
	protected UserRoleBL userRoleBL;
	
	/** SOC关系表BL */
	protected SocRelationBL socRelationBL;

	protected MessageResources resources = MessageResources.getMessageResources("com.deliverik.infogovernor.soc.cim.asmResources"); 
	
	/** 依赖关系表BL */
	protected SOC0110BL soc0110BL;
	
	/** 最大版本域明细BL */
	protected SOC0126BL soc0126BL;
	
	/** 域明细BL */
	protected SOC0112BL soc0112BL;
	
	/** 域定义信息BL */
	protected SOC0111BL soc0111BL;
	
	/** 配置元数据版本信息BL */
	protected CR03BL cr03BL;
	
	/** 采集结果BL */
	protected CR01BL cr01BL;
	
	/** 资产关系 */
	protected SOC0152BL soc0152BL;
	
	/**日志信息BL*/
	private SOC0153BL soc0153BL;
	private SOC0113BL soc0113BL;
	
	protected PlatformManagerBL platformManagerBL;
	
	protected IG500VWBL ig500VWBL;
	
	public void setSoc0114BL(SOC0114BL soc0114bl) {
		soc0114BL = soc0114bl;
	}

	
	public void setSoc0113BL(SOC0113BL soc0113bl) {
		soc0113BL = soc0113bl;
	}


	public void setPlatformManagerBL(PlatformManagerBL platformManagerBL) {
		this.platformManagerBL = platformManagerBL;
	}

	public void setSoc0153BL(SOC0153BL soc0153bl) {
		soc0153BL = soc0153bl;
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


	public void setSoc0110BL(SOC0110BL soc0110BL) {
		this.soc0110BL = soc0110BL;
	}


	public void setSoc0126BL(SOC0126BL soc0126BL) {
		this.soc0126BL = soc0126BL;
	}


	public void setSoc0112BL(SOC0112BL soc0112BL) {
		this.soc0112BL = soc0112BL;
	}


	public void setSoc0111BL(SOC0111BL soc0111BL) {
		this.soc0111BL = soc0111BL;
	}


	public void setSocRelationBL(SocRelationBL socRelationBL) {
		this.socRelationBL = socRelationBL;
	}


	public void setOrganizationBL(OrganizationBL organizationBL) {
		this.organizationBL = organizationBL;
	}


	public void setFileUploadBL(FileUploadBL fileUploadBL) {
		this.fileUploadBL = fileUploadBL;
	}
	
	
	public void setSoc0151BL(SOC0151BL soc0151BL) {
		this.soc0151BL = soc0151BL;
	}


	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}
	
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}

	/**
	 * 配置元数据版本信息BL设定
	 * @param cr03bl 配置元数据版本信息BL
	 */
	public void setCr03BL(CR03BL cr03bl) {
		cr03BL = cr03bl;
	}
	
	/**
	 * 采集结果BL设定
	 * @param cr01bl 采集结果BL
	 */
	public void setCr01BL(CR01BL cr01bl) {
		cr01BL = cr01bl;
	}
	
	
	/**
	 * 资产关系设定
	 *
	 * @param soc0152BL 资产关系
	 */
	
	public void setSoc0152BL(SOC0152BL soc0152BL) {
		this.soc0152BL = soc0152BL;
	}
	
	

	/**
	 * ig500VWBL设定
	 * @param ig500VWBL ig500VWBL
	 */
	public void setIg500VWBL(IG500VWBL ig500vwbl) {
		ig500VWBL = ig500vwbl;
	}


	/**
	 * 设备信息查询处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO searchEntityItemAction(IGCIM01DTO dto) throws BLException {

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

		Integer domainid = EiDomainKeyWords.DOOMAIN_ID_DEFAULT;
		SOC0111Info domain  = this.soc0111BL.searchDomainMaxVersion(domainid);
		Integer domainversion = domain.getVersion();
		String createtime = domain.getUpdatetime();
		String showRelation = "N";
		Map<String,String> showRelationMap = new HashMap<String,String>();
		if(entityItemVWInfoList!=null){
			//主机，交换机，存储可以查看关系
			// 将存储改为只查看DMX存储 --20130607 yanglongquan
			for(SOC0124Info bean:entityItemVWInfoList){
				if(bean.getEsyscoding().startsWith(EiRelationKeyWords.HOST) 
						|| bean.getEsyscoding().startsWith(EiRelationKeyWords.SWITCH)
						|| bean.getEsyscoding().startsWith(EiRelationKeyWords.STORAGE_DMX)) {
					showRelation = "Y";
				}else{
					showRelation = "N";
				}
				showRelationMap.put(String.valueOf(bean.getEiid()), showRelation);
			}
		}
		dto.setDomainid(domainid);
		dto.setDomainversion(domainversion);
		dto.setCreatetime(createtime);
		dto.setShowRelationMap(showRelationMap);
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
	public IGCIM01DTO insertEntityItemAction(IGCIM01DTO dto) throws BLException {
		log.debug("========设备信息登记处理开始========");
		//输入Form取得
		IGCIM0102Form form = dto.getIgasm0302Form();
		
		form.setEidStr(form.getEid().toString());
		
		//更新时间设定
		
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		
		form.setEiupdtime(datetime);
		
		//大版本设定（固定设为0）2014/01/26 wj
		form.setEiversion(1);
		
		//小版本设定（固定设为0）
		form.setEismallversion(0);
		
		form.setEistatus(CommonDefineUtils.ENTITYITEM_STARUS_NEW);

		//获取登记Eilabel
		String[] eilabel = form.getEilabel().split("_");
		String ip = "";
		if(eilabel.length>1){
			ip = eilabel[1];
		}
		SOC0107SearchCondImpl cond = new SOC0107SearchCondImpl();
		cond.setCivalue(ip);
		cond.setCid("CI010100010005");
		List<SOC0107Info> soc0107infoList = this.soc0107BL.searchSOC0107(cond);
		
		//设备信息登录
		SOC0118Info entityItem = this.soc0118BL.registEntityItem(dto.getIgasm0302Form());
		SOC0118TB ei=(SOC0118TB)SerializationUtils.clone(entityItem);
		if(ei.getEirootmark()==null && soc0107infoList.size()>0){
			ei.setEirootmark(soc0107infoList.get(0).getEiid());
		}else{
			ei.setEirootmark(entityItem.getEiid());
		}
		this.soc0118BL.updateEntityItem(ei);
		form.setEiidStr(entityItem.getEiid().toString());
		
		dto.setIgasm0302Form(form);
		//设备基本信息
		dto.addMessage(new ActionMessage( "IGCO10000.I004", resources.getMessage(dto.getLocale(),"message.IGCIM01BLImpl.001")) );
		
		log.debug("========设备信息登记处理终了========");
		return dto;
	}

	/**
	 * 设备信息删除处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO deleteEntityItemAction(IGCIM01DTO dto) throws BLException {
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
				throw new BLException("IGCO10000.E004",resources.getMessage(dto.getLocale(),"message.IGCIM01BLImpl.002"));
			}
			this.soc0110BL.delByEiid(eiid);
			//删除关系
			this.soc0119BL.delByEiid(eiid);
			//设备删除
			this.soc0118BL.deleteEntityItem(entityItem);
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I006",resources.getMessage(dto.getLocale(),"message.IGCIM01BLImpl.003")));

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
		List<SOC0119Info> list = this.soc0119BL.searchEntityItemRelation(cond, 0, 0);
		for(SOC0119Info eir : list){
			this.cycleDelete(eir.getPareiid()+"",retList);
		}
		if(!retList.contains(Integer.parseInt(eiid))){
			retList.add(Integer.parseInt(eiid));
		}
		return retList;
	}


	
	

	/**
	 * 设备配置信息历史记录画面初期化处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO initIGASM0305Action(IGCIM01DTO dto) throws BLException {
		log.debug("========设备配置信息历史记录画面初期化处理开始========");
		
		//设备信息检索
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(
				Integer.parseInt(dto.getIgasm0305Form().getEiid()));
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004",resources.getMessage(dto.getLocale(),"message.IGASM03BLImpl.004"));
		}
		
		if ( entityItemVWInfo.getEiversion() == 0 ) {
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
		
		if (StringUtils.isEmpty(dto.getIgasm0305Form().getCiversion())) {
			dto.getIgasm0305Form().setCiversion(entityItemVWInfo.getEiversion()+"");
		}
		//获取历史版本更新时间
		dto.setConfigItemVersionTime(this.soc0118BL.searchVersionUpdateTime(Integer.parseInt(dto.getIgasm0305Form().getEiid())));
		
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
	public IGCIM01DTO initIGASM0305ActionForXML(IGCIM01DTO dto) throws BLException {
		log.debug("========设备配置信息历史记录画面初期化处理开始========");
		
		//设备信息检索
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(
				Integer.parseInt(dto.getIgasm0305Form().getEiid()));
		String eiid = dto.getIgasm0305Form().getEiid();
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004",resources.getMessage(dto.getLocale(),"message.IGASM03BLImpl.004"));
		}
		
		if ( entityItemVWInfo.getEiversion() == 0 ) {
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
		
		if (StringUtils.isEmpty(dto.getIgasm0305Form().getCiversion())) {
			dto.getIgasm0305Form().setCiversion(entityItemVWInfo.getEiversion()+"");
		}
		
		String fileversion = entityItemVWInfo.getEiversion() + "";//XML文件版本
		
		if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(entityItemVWInfo.getEmodeltype())) {
			fileversion = fileversion + "_" + entityItemVWInfo.getEismallversion();
		}
		//获取历史版本更新时间
		List<SOC0128Info> old_civtList = this.soc0118BL.searchVersionUpdateTime(Integer.parseInt(dto.getIgasm0305Form().getEiid()));
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
	public IGCIM01DTO initIGASM0306Action(IGCIM01DTO dto) throws BLException {
		log.debug("========设备关系管理画面初期化处理开始========");
		
		//设备信息检索
//		EntityItemVWInfo entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(
//				Integer.parseInt(dto.getIgasm0306Form().getEiid()));
		//以前查视图，考虑到方法下面与页面只用到2个表内容，只查出2个表内容，然后拼成视图对象. _ylq
		SOC0118Info entityItemInfo=soc0118BL.searchEntityItemByKey(Integer.parseInt(dto.getIgcim0106Form().getEiid()));
		SOC0117Info entity=soc0117BL.searchEntityByKey(entityItemInfo.getEid());
		SOC0124VW entityItemVWInfo=new SOC0124VW();
		entityItemVWInfo.setEname(entity.getEname());
		entityItemVWInfo.setEilabel(entityItemInfo.getEilabel());
		entityItemVWInfo.setEiname(entityItemInfo.getEiname());
		entityItemVWInfo.setEidesc(entityItemInfo.getEidesc());
		entityItemVWInfo.setEistatus(entityItemInfo.getEistatus());
		entityItemVWInfo.setEiusername(entityItemInfo.getEiusername());
		entityItemVWInfo.setEiinsdate(entityItemInfo.getEiinsdate());
		entityItemVWInfo.setEiupdtime(entityItemInfo.getEiupdtime());
		entityItemVWInfo.setEiorgsyscoding(entityItemInfo.getEiorgsyscoding());
		entityItemVWInfo.setEiversion(entityItemInfo.getEiversion());
		entityItemVWInfo.setEismallversion(entityItemInfo.getEismallversion());
		entityItemVWInfo.setEid(entityItemInfo.getEid());
		entityItemVWInfo.setEiid(entityItemInfo.getEiid());
		entityItemVWInfo.setEirootmark(entityItemInfo.getEirootmark());
		entityItemVWInfo.setEsyscoding(entityItemInfo.getEsyscoding());
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004",resources.getMessage(dto.getLocale(),"message.IGASM03BLImpl.004"));
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
//		Boolean flag=true;
		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}else{
			dto.setFlag(flag);
		}
		
		//正向关联关系检索
		SOC0119SearchCondImpl parcond = new SOC0119SearchCondImpl();
		parcond.setPareiid(Integer.parseInt(dto.getIgcim0106Form().getEiid()));
		parcond.setParversion(Integer.parseInt(entityItemVWInfo.getEiversion().toString()));
		parcond.setParsmallversion(Integer.parseInt(entityItemVWInfo.getEismallversion().toString()));
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
		
		cldcond.setCldeiid(Integer.parseInt(dto.getIgcim0106Form().getEiid()));
		cldcond.setCldversion(entityItemVWInfo.getEiversion());
		cldcond.setCldsmallversion(entityItemVWInfo.getEismallversion());
		cldcond.setDeleteflag("0");
		//设备关系信息查询件数取得 
		totalCount = this.soc0119BL.getEntityItemRelationSearchCount(cldcond);
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========设备关系信息查询数据件数过多========");
			//设备关系信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//设备关系信息全件检索
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

		
		log.debug("========设备关系管理画面初期化处理终了========");
		return dto;
	}
	/**
	 * 设备依赖关系画面初期化处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO initIGASM0306BelongAction(IGCIM01DTO dto) throws BLException {
		log.debug("========设备依赖关系管理画面初期化处理开始========");
		
		//设备信息检索
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(
				Integer.parseInt(dto.getIgcim0106Form().getEiid()));
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004",resources.getMessage(dto.getLocale(),"message.IGASM03BLImpl.004"));
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
		
		//判断登陆用户是否有查看该资产配置信息的权限
		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(), entityItemVWInfo);

		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}else{
			dto.setFlag(flag);
		}
		
		//所属关系正向检索
		SOC0110SearchCondImpl belongcond = new SOC0110SearchCondImpl();
		belongcond.setBrpareiid(entityItemVWInfo.getEiid().toString());
		belongcond.setBrparsmallversion(entityItemVWInfo.getEismallversion().toString());
		belongcond.setBrparversion(entityItemVWInfo.getEiversion().toString());
		belongcond.setDeleteflag("0");
		List<SOC0110Info> eiBelongRelationList = null;
		//设备依赖关系信息查询件数取得 
		int totalCount = this.soc0110BL.getSearchCount(belongcond);
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========设备关系信息查询数据件数过多========");
			//设备依赖关系信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		Map<String,List<SOC0110Info>> rlnmap = new LinkedHashMap<String,List<SOC0110Info>>();
		if ( totalCount>0 ) {
			//设备依赖关系信息全件检索
			eiBelongRelationList = this.soc0110BL.searchEiBelongRelation(belongcond);
			
			for (SOC0110Info info : eiBelongRelationList) {
				String key = "";
				if("003-002".equals(info.getBrraletioncode())){
					key="业务系统与软件";
				}else if("002-002".equals(info.getBrraletioncode())){
					key="软件与软件";
				}else if("001-001".equals(info.getBrraletioncode())){
					key = "设备与设备";
				}else if("001-002".equals(info.getBrraletioncode())){
					key = "设备与软件";
				}
				if(!rlnmap.containsKey(key)){
					rlnmap.put(key, new ArrayList<SOC0110Info>());
				}
				rlnmap.get(key).add(info);
			}
		}
		
		
//		//逆向关联关系检索
//		SOC0110SearchCondImpl cldcond = new SOC0110SearchCondImpl();
//		
//		cldcond.setBrcldeiid(entityItemVWInfo.getEiid().toString());
//		cldcond.setBrcldsmallversion(entityItemVWInfo.getEismallversion().toString());
//		cldcond.setBrcldversion(entityItemVWInfo.getEiversion().toString());
//		cldcond.setDeleteflag("0");
//		//设备依赖关系信息查询件数取得 
//		totalCount = this.soc0110BL.getSearchCount(cldcond);
//		
//		if ( totalCount > dto.getMaxSearchCount() ) {
//			log.debug("========设备关系信息查询数据件数过多========");
//			//设备关系信息查询数据件数过多
//			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
//			return dto;
//		}
//
//		if ( totalCount>0 ) {
//			//设备依赖关系信息全件检索
//			eiBelongRelationList = this.soc0110BL.searchEiBelongRelation(cldcond);
//			
//			for (SOC0110Info info : eiBelongRelationList) {
//				String key = "";
//				if("003-002".equals(info.getBrraletioncode())){
//					key="业务系统与软件";
//				}else if("002-002".equals(info.getBrraletioncode())){
//					key="软件与软件";
//				}else if("001-001".equals(info.getBrraletioncode())){
//					key = "设备与设备";
//				}else if("001-002".equals(info.getBrraletioncode())){
//					key = "设备与软件";
//				}
//				if(!rlnmap.containsKey(key)){
//					rlnmap.put(key, new ArrayList<SOC0110Info>());
//				}
//				rlnmap.get(key).add(info);
//			}
//		}
		
		dto.setRlnmap(rlnmap);
		//dto.setEiBelongRelationList(eiBelongRelationList);

		log.debug("========设备依赖关系管理画面初期化处理终了========");
		return dto;
	}
	
	
	/**
	 * 设备关系树画面初期化处理(显示全树，顶级EI为根)
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO initIGASM0346Action(IGCIM01DTO dto) throws BLException {
		log.debug("========配置包含关系显示处理开始========");
		
		IGCIM0146Form form = dto.getIgcim0146Form();
		//查询顶级配置资产的所有子节点
		SOC0127SearchCondImpl cond = new SOC0127SearchCondImpl();
		cond.setEirootmark(Integer.parseInt(form.getEirootmark()));
		cond.setBrparversion(Integer.parseInt(form.getEiversion()));
		cond.setBrcldversion(cond.getBrparversion());
		List<SOC0127Info> eibrList = this.soc0110BL.searchEiBelongRelationVW(cond);
		//查询顶级EI
		SOC0123Info rootEi = this.soc0118BL.searchEntityItemEntityVWByKey(Integer.parseInt(form.getEirootmark()));
		//根据选中资产大版本查询顶级EI的最大小版本
		Integer rootEiMaxSmallveision = this.soc0107BL.searchEiMaxSmallVersion(rootEi.getEiid(), Integer.parseInt(form.getEiversion()));
		//构造树集合
		Map<String,TreeNode> treeNodeMap = new LinkedHashMap<String,TreeNode>();
		//构造根	
		TreeNode rootNode = new TreeNode();
		rootNode.setId(rootEi.getEiid() + "_" + rootEi.getEiversion() + "_" + rootEiMaxSmallveision);//资产ID|大版本|小版本
		rootNode.setName(rootEi.getEiname() + "(" + form.getEiversion() + "." + rootEiMaxSmallveision + ")");//资产名称
		//递归构造包含关系树
		searchConfigurationTreeNode(eibrList, rootEi, rootNode);
		if(rootEi.getEsyscoding().startsWith(EiRelationKeyWords.STORAGE)){
			searchTreeNodeForStorage(eibrList, rootEi, rootNode);
		}
		//填充更节点
		treeNodeMap.put(rootNode.getId(),rootNode);		
		dto.setTreeNodeMap(treeNodeMap);
		
		log.debug("========配置包含关系显示处理终了========");
		return dto;
	}
	
	/**
	 * 设备关系树画面初期化处理(显示全树，顶级EI为根)
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO initIGCIM0149Action(IGCIM01DTO dto) throws BLException {
		log.debug("========配置包含关系显示处理开始========");
		
		IGCIM0146Form form = dto.getIgcim0146Form();
		//查询顶级配置资产的所有子节点
		SOC0127SearchCondImpl cond = new SOC0127SearchCondImpl();
		cond.setEirootmark(Integer.parseInt(form.getEirootmark()));
		cond.setBrparversion(Integer.parseInt(form.getEiversion()));
		cond.setBrcldversion(cond.getBrparversion());
		List<SOC0127Info> eibrList = this.soc0110BL.searchEiBelongRelationVW(cond);
		//查询顶级EI
		SOC0123Info rootEi = this.soc0118BL.searchEntityItemEntityVWByKey(Integer.parseInt(form.getEirootmark()));
		//根据选中资产大版本查询顶级EI的最大小版本
		Integer rootEiMaxSmallveision = this.soc0107BL.searchEiMaxSmallVersion(rootEi.getEiid(), Integer.parseInt(form.getEiversion()));
		//构造树集合
		Map<String,TreeNode> treeNodeMap = new LinkedHashMap<String,TreeNode>();
		//构造根	
		TreeNode rootNode = new TreeNode();
		rootNode.setId(rootEi.getEiid() + "_" + rootEi.getEiversion() + "_" + rootEiMaxSmallveision);//资产ID|大版本|小版本
		rootNode.setName(rootEi.getEiname() + "(" + form.getEiversion() + "." + rootEiMaxSmallveision + ")");//资产名称
		//递归构造包含关系树
		searchConfigurationTreeNode(eibrList, rootEi, rootNode);
		if(rootEi.getEsyscoding().startsWith(EiRelationKeyWords.STORAGE)){
			searchTreeNodeForStorage(eibrList, rootEi, rootNode);
		}
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
		List<EiBelongRelationVWInfo> eibrList = this.soc0110BL.searchEiBelongRelationVW(cond);
		//查询当前EI
		EntityItemEntityVWInfo rootEi = this.soc0118BL.searchEntityItemEntityVWByKey(Integer.parseInt(form.getEiid()));
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
	public void searchConfigurationTreeNode(List<SOC0127Info> eibrList,
			SOC0123Info ei, TreeNode parNode) throws BLException {
		
		//迭代节点集合
		for(SOC0127Info eibr : eibrList) {
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
	 * 存储情况特殊faport-fa fa-storage
	 *
	 * @param eibrList 节点集合
	 * @param ei 父级资产节点
	 * @param parNode 父级节点
	 */
	public void searchTreeNodeForStorage(List<SOC0127Info> eibrList,
			SOC0123Info ei, TreeNode parNode) throws BLException {
		
		//迭代节点集合
		for(SOC0127Info eibr : eibrList) {
			if(ei.getEiid().equals(eibr.getBrcldeiid())) {//匹配ID
				//构造子节点
				TreeNode cldNode = new TreeNode();
				cldNode.setId(eibr.getBrpareiid() + "_" + eibr.getBrparversion() + "_" + eibr.getBrparsmallversion());//资产ID|大版本|小版本
				cldNode.setName(eibr.getParEntityItemVW().getEiname() + "(" + eibr.getBrparversion() + "." + eibr.getBrparsmallversion() + ")");//资产名称
				//填充子节点
				parNode.addChildTreeNode(cldNode.getId(),cldNode);
				//递归
				searchTreeNodeForStorage(eibrList, eibr.getParEntityItemVW(), cldNode);
			}
		}
		
	}
	
	/**
	 * 设备关系删除处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO deleteEntityItemRelationAction(IGCIM01DTO dto) throws BLException {
		log.debug("========设备关系删除处理开始========");
		
		for( int i=0;i<dto.getDeleteEntityItemRelation().length;i++ ){
			String eirid = dto.getDeleteEntityItemRelation()[i];
			
			SOC0119Info entityItemRelation = 
				this.soc0119BL.searchEntityItemRelationByKey(Integer.parseInt(eirid));
			
			if (entityItemRelation == null){
				throw new BLException("IGCO10000.E004",resources.getMessage(dto.getLocale(),"message.IGCIM01BLImpl.008"));
			}

			this.soc0119BL.deleteEntityItemRelation(entityItemRelation);
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I006",resources.getMessage(dto.getLocale(),"message.IGCIM01BLImpl.009")));

		log.debug("========设备关系删除处理终了========");
		return dto;
	}

	/**
	 * 设备依赖关系删除处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO deleteEiBelongRelationAction(IGCIM01DTO dto) throws BLException {
		log.debug("========设备依赖关系删除处理开始========");
		
		for( int i=0;i<dto.getDeleteEntityItemRelation().length;i++ ){
			String eirid = dto.getDeleteEntityItemRelation()[i];
			
			SOC0110Info eiBelongRelationInfo = 
				this.soc0110BL.searchEiBelongRelationByPK(Integer.parseInt(eirid));
			
			if (eiBelongRelationInfo == null){
				throw new BLException("IGCO10000.E004",resources.getMessage(dto.getLocale(),"message.IGCIM01BLImpl.013"));
			}

			this.soc0110BL.deleteEiBelongRelation(eiBelongRelationInfo);
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I006",resources.getMessage(dto.getLocale(),"message.IGCIM01BLImpl.013")));

		log.debug("========设备依赖关系删除处理终了========");
		return dto;
	}
	/**
	 * 设备依赖关系登记处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO insertEntityItemEiBelongRelationAction(IGCIM01DTO dto) throws BLException {
		log.debug("========设备依赖关系登记处理开始========");
		
		IGCIM0107Form form = dto.getIgcim0107Form();
		
		//设备ID（子）取得
		SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
		
		cond.setElabel(form.getElabel());
		cond.setEilabel(form.getEilabel());
		
		List<SOC0124Info> entityItemVWList = this.soc0118BL.searchEntityItemVW(cond, 0, 0);
		
		if ( entityItemVWList==null || entityItemVWList.size() == 0 ) {
			throw new BLException("IGCO10000.E004",resources.getMessage(dto.getLocale(),"message.IGASM03BLImpl.010")
					+ form.getElabel() + resources.getMessage(dto.getLocale(),"message.IGASM03BLImpl.011") 
					+ form.getEilabel() + resources.getMessage(dto.getLocale(),"message.IGASM03BLImpl.012"));
		}
		
		
		//设备ID（父）和（子）检测
		if (form.getPareiid().intValue() == form.getCldeiid().intValue()) {
			//设备ID（父）= （子）
			throw new BLException(BLErrorType.ENTITY_ITEM_RELATION_ERROR,
					"IGCO10000.E012",resources.getMessage(dto.getLocale(),"message.IGASM03BLImpl.004"));
		}
		
		
		SOC0110SearchCondImpl belongcond = new SOC0110SearchCondImpl();
		belongcond.setBrpareiid(form.getPareiid().toString());
		belongcond.setBrparsmallversion(form.getParsmallversion().toString());
		belongcond.setBrparversion(form.getParversion().toString());
		belongcond.setBrcldeiid(entityItemVWList.get(0).getEiid().toString());
		belongcond.setBrcldversion(entityItemVWList.get(0).getEiversion().toString());
		belongcond.setBrcldsmallversion(entityItemVWList.get(0).getEismallversion().toString());
		belongcond.setDeleteflag("0");
		
		int totalCount = this.soc0110BL.getSearchCount(belongcond);
		if(totalCount>0){
			//同一依赖关系已经存在
			throw new BLException(BLErrorType.ENTITY_ITEM_RELATION_ERROR,"IGCO10000.E026");
		}
		
		//依赖关系登记
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		SOC0110TB eiBelongRelationTB = soc0110BL.getEiBelongRelationTBInstance();
		eiBelongRelationTB.setBrpareiid(form.getPareiid());
		eiBelongRelationTB.setBrparsmallversion(form.getParsmallversion());
		eiBelongRelationTB.setBrparversion(form.getParversion());
		eiBelongRelationTB.setBrcldeiid(entityItemVWList.get(0).getEiid());
		eiBelongRelationTB.setBrcldsmallversion(entityItemVWList.get(0).getEismallversion());
		eiBelongRelationTB.setBrcldversion(entityItemVWList.get(0).getEiversion());
		eiBelongRelationTB.setBrcreatetime(datetime);
		eiBelongRelationTB.setBrdes(form.getEirdesc());
		
		eiBelongRelationTB.setBrraletioncode(form.getEirrelationcode());
		eiBelongRelationTB.setBrassetrelation(form.getEirrelation());
		
		eiBelongRelationTB.setBrtype(form.getBelongType());
		eiBelongRelationTB.setEirootmark(form.getEirootmark());
		
		soc0110BL.registEiBelongRelation(eiBelongRelationTB);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", resources.getMessage(dto.getLocale(),"message.IGCIM01BLImpl.013")) );
		
		log.debug("========设备依赖关系登记处理终了========");
		return dto;
	}
	/**
	 * 设备关系编辑画面初期化处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO initIGASM0307Action(IGCIM01DTO dto) throws BLException {
		log.debug("========设备关系编辑画面初期化处理开始========");
		
		IGCIM0107Form form = dto.getIgcim0107Form();
		SOC0119TB ret = 		
			(SOC0119TB) this.soc0119BL.searchEntityItemRelationByKey(
				form.getEirid());
		
		if ( ret == null ){
			throw new BLException("IGCO10000.E004",resources.getMessage(dto.getLocale(),"message.IGASM03BLImpl.014"));
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
		
		log.debug("========设备关系编辑画面初期化处理终了========");
		return dto;
	}

	
	/**
	 * 设备下发信息查询处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO searchNewAndReciveEntityItemAction(IGCIM01DTO dto) throws BLException {

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
	public IGCIM01DTO searchUsingEntityItemAction(IGCIM01DTO dto)
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
	public IGCIM01DTO searchCanScrapEntityItemAction(IGCIM01DTO dto) throws BLException {
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
	public void entityIssueAction(IGCIM01DTO dto) throws BLException {

		log.debug("========设备下发处理开始========");
		
		SOC0118TB entityItem = (SOC0118TB)soc0118BL.searchEntityItemByKey(dto.getIgasm0309Form().getEiid());
		entityItem.setEistatus(CommonDefineUtils.ENTITYITEM_STARUS_USE);
//		entityItem.setEiorgsyscoding(dto.getIgasm0309Form().getOrgid());
		entityItem.setEiversion(entityItem.getEiversion() + 1);
		soc0118BL.updateEntityItem(entityItem);
		
		SOC0107SearchCondImpl cond = new SOC0107SearchCondImpl();
		cond.setEiid(String.valueOf(dto.getIgasm0309Form().getEiid()));
		cond.setCiversion(dto.getIgasm0309Form().getEiversion());
		List<SOC0107Info> configItemList = soc0107BL.searchSOC0107(cond, 0, 0);
		
		for (SOC0107Info configItem : configItemList) {
			SOC0107TB ciTB = (SOC0107TB)SerializationUtils.clone(configItem);
			ciTB.setCiversion(configItem.getCiversion() + 1);
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
			if(configItem.getCivalue().equals(ciTB.getCivalue())) {
				//属性更新标识
				ciTB.setCicurver("0");
			} else {
				//属性更新标识
				ciTB.setCicurver("1");
			}
			SOC0107Info ci = soc0107BL.registSOC0107(ciTB);
			//属性类别为资产时，修改关联关系
			if("4".equals(configItem.getConfiguration().getCattach()) && StringUtils.isNotEmpty(configItem.getCivalue())){
				SOC0119TB e = new SOC0119TB();
				e.setPareid(entityItem.getEid());
				e.setPareiid(entityItem.getEiid());
				String str = configItem.getCivalue();			
				SOC0118Info ei = this.soc0118BL.searchEntityItemByKey(Integer.parseInt(str.substring(str.lastIndexOf("(")+1, str.length()-1)));
				e.setCldeid(ei.getEid());
				e.setCldeiid(ei.getEiid());
				//校验关系是否存在
				SOC0119SearchCondImpl eirCond = new SOC0119SearchCondImpl();
				eirCond.setEirinfo(entityItem.getEiid()+"_"+configItem.getCiid()+"_"+ei.getEiid());
				eirCond.setEirstatus("C");
				eirCond.setDeleteflag("0");
				List<SOC0119Info> eirlist = this.soc0119BL.searchEntityItemRelation(eirCond, 0, 0);
				if(eirlist.size() != 1) {
					throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR, "IGCO10000.E017");
				} else {
					SOC0119TB eirTB = (SOC0119TB)SerializationUtils.clone(eirlist.get(0));
					
					eirTB.setEirinfo(eirTB.getEirinfo().replaceAll("_" + configItem.getCiid() + "_", "_" + ci.getCiid() + "_"));
					
					this.soc0119BL.updateEntityItemRelation(eirTB);
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
	public void entityBatchIssueAction(IGCIM01DTO dto) throws BLException{
		for (int i = 0; i < dto.getBatchEntityItem().length; i++) {
			SOC0107SearchCondImpl cond = new SOC0107SearchCondImpl();
			String eiid = dto.getBatchEntityItem()[i];
			cond.setEiid(eiid);
			SOC0118TB entityItem = (SOC0118TB)soc0118BL.searchEntityItemByKey(Integer.parseInt(eiid));
			cond.setCiversion(String.valueOf(entityItem.getEiversion()));
			List<SOC0107Info> configItemList = soc0107BL.searchSOC0107(cond, 0, 0);
			
			for (SOC0107Info configItem : configItemList) {
				SOC0107TB ciTB = (SOC0107TB)SerializationUtils.clone(configItem);
				ciTB.setCiversion(configItem.getCiversion() + 1);
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
				if(configItem.getCivalue().equals(ciTB.getCivalue())) {
					//属性更新标识
					ciTB.setCicurver("0");
				} else {
					//属性更新标识
					ciTB.setCicurver("1");
				}
				SOC0107Info ci = soc0107BL.registSOC0107(ciTB);
				//属性类别为资产时，修改关联关系
				if("4".equals(configItem.getConfiguration().getCattach()) && StringUtils.isNotEmpty(configItem.getCivalue())){
					SOC0119TB e = new SOC0119TB();
					e.setPareid(entityItem.getEid());
					e.setPareiid(entityItem.getEiid());
					String str = configItem.getCivalue();			
					SOC0118Info ei = this.soc0118BL.searchEntityItemByKey(Integer.parseInt(str.substring(str.lastIndexOf("(")+1, str.length()-1)));
					e.setCldeid(ei.getEid());
					e.setCldeiid(ei.getEiid());
					//校验关系是否存在
					SOC0119SearchCondImpl eirCond = new SOC0119SearchCondImpl();
					eirCond.setEirinfo(entityItem.getEiid()+"_"+configItem.getCiid()+"_"+ei.getEiid());
					eirCond.setEirstatus("C");
					eirCond.setDeleteflag("0");
					List<SOC0119Info> eirlist = this.soc0119BL.searchEntityItemRelation(eirCond, 0, 0);
					if(eirlist.size() != 1) {
						throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR, "IGCO10000.E017");
					} else {
						SOC0119TB eirTB = (SOC0119TB)SerializationUtils.clone(eirlist.get(0));
						
						eirTB.setEirinfo(eirTB.getEirinfo().replaceAll("_" + configItem.getCiid() + "_", "_" + ci.getCiid() + "_"));
						
						this.soc0119BL.updateEntityItemRelation(eirTB);
					}
				}
			}
			
			entityItem.setEistatus(CommonDefineUtils.ENTITYITEM_STARUS_USE);
			entityItem.setEiversion(entityItem.getEiversion() + 1);
			soc0118BL.updateEntityItem(entityItem);
		}
		dto.addMessage(new ActionMessage("IGASM0309.I001"));
	}
	
	/**
	 * 查询指定eiid的待上缴设备
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO searchEntityPayByEiidAction(IGCIM01DTO dto) throws BLException {

		log.debug("========待上缴设备查询开始========");
		SOC0107SearchCondImpl cond = new SOC0107SearchCondImpl();
		cond.setEiid(String.valueOf(dto.getIgasm0313Form().getEiid()));
		List<SOC0107Info> configItemList = soc0107BL.searchSOC0107(cond, 0, 0);
		ArrayList<SOC0107Info> list = new ArrayList<SOC0107Info>();//存储最新的设备版本信息
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
		for(int i = 0,j = configItemList.size();i<j;i++ ){
			if(Integer.valueOf(dto.getEiversion())==configItemList.get(i).getCiversion()){
				list.add(configItemList.get(i));
			}
		}
		//取得领用人,机构
		for(SOC0107Info config:list){
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
	public void entityPayAction(IGCIM01DTO dto) throws BLException {

		log.debug("========设备上缴处理开始========");
		SOC0118TB entityItem = (SOC0118TB)soc0118BL.searchEntityItemByKey(dto.getIgasm0313Form().getEiid());
		entityItem.setEistatus(CommonDefineUtils.ENTITYITEM_STARUS_RENEW);
	//	entityItem.setEiorgsyscoding(dto.getIgasm0313Form().getEiiorgid().substring(0, 4));//取领用人机构的1级机构
		entityItem.setEiversion(entityItem.getEiversion() + 1);
		soc0118BL.updateEntityItem(entityItem);
		
		SOC0107SearchCondImpl cond = new SOC0107SearchCondImpl();
		cond.setEiid(String.valueOf(dto.getIgasm0313Form().getEiid()));
		cond.setCiversion(dto.getIgasm0313Form().getEiversion());
		List<SOC0107Info> configItemList = soc0107BL.searchSOC0107(cond, 0, 0);
		
		for (SOC0107Info configItem : configItemList) {
			SOC0107TB ciTB = (SOC0107TB)SerializationUtils.clone(configItem);
			ciTB.setCiversion(configItem.getCiversion() + 1);
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
			if(configItem.getCivalue().equals(ciTB.getCivalue())) {
				//属性更新标识
				ciTB.setCicurver("0");
			} else {
				//属性更新标识
				ciTB.setCicurver("1");
			}
			SOC0107Info ci = soc0107BL.registSOC0107(ciTB);
			//属性类别为资产时，修改关联关系
			if("4".equals(configItem.getConfiguration().getCattach()) && StringUtils.isNotEmpty(configItem.getCivalue())){
				SOC0119TB e = new SOC0119TB();
				e.setPareid(entityItem.getEid());
				e.setPareiid(entityItem.getEiid());
				String str = configItem.getCivalue();			
				SOC0118Info ei = this.soc0118BL.searchEntityItemByKey(Integer.parseInt(str.substring(str.lastIndexOf("(")+1, str.length()-1)));
				e.setCldeid(ei.getEid());
				e.setCldeiid(ei.getEiid());
				//校验关系是否存在
				SOC0119SearchCondImpl eirCond = new SOC0119SearchCondImpl();
				eirCond.setEirinfo(entityItem.getEiid()+"_"+configItem.getCiid()+"_"+ei.getEiid());
				eirCond.setEirstatus("C");
				eirCond.setDeleteflag("0");
				List<SOC0119Info> eirlist = this.soc0119BL.searchEntityItemRelation(eirCond, 0, 0);
				if(eirlist.size() != 1) {
					throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR, "IGCO10000.E017");
				} else {
					SOC0119TB eirTB = (SOC0119TB)SerializationUtils.clone(eirlist.get(0));
					
					eirTB.setEirinfo(eirTB.getEirinfo().replaceAll("_" + configItem.getCiid() + "_", "_" + ci.getCiid() + "_"));
					
					this.soc0119BL.updateEntityItemRelation(eirTB);
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
	public void entityBatchPayAction(IGCIM01DTO dto) throws BLException {

		log.debug("========设备批量上缴处理开始========");
		for (int i = 0; i < dto.getBatchEntityItem().length; i++) {
		SOC0107SearchCondImpl cond = new SOC0107SearchCondImpl();
		String eiid = dto.getBatchEntityItem()[i];
		cond.setEiid(eiid);
		SOC0118TB entityItem = (SOC0118TB)soc0118BL.searchEntityItemByKey(Integer.parseInt(eiid));
		cond.setCiversion(String.valueOf(entityItem.getEiversion()));
		List<SOC0107Info> configItemList = soc0107BL.searchSOC0107(cond, 0, 0);
		
		for (SOC0107Info configItem : configItemList) {
			SOC0107TB ciTB = (SOC0107TB)SerializationUtils.clone(configItem);
			ciTB.setCiversion(configItem.getCiversion() + 1);
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
			if(configItem.getCivalue().equals(ciTB.getCivalue())) {
				//属性更新标识
				ciTB.setCicurver("0");
			} else {
				//属性更新标识
				ciTB.setCicurver("1");
			}
			SOC0107Info ci = soc0107BL.registSOC0107(ciTB);
			//属性类别为资产时，修改关联关系
			if("4".equals(configItem.getConfiguration().getCattach()) && StringUtils.isNotEmpty(configItem.getCivalue())){
				SOC0119TB e = new SOC0119TB();
				e.setPareid(entityItem.getEid());
				e.setPareiid(entityItem.getEiid());
				String str = configItem.getCivalue();			
				SOC0118Info ei = this.soc0118BL.searchEntityItemByKey(Integer.parseInt(str.substring(str.lastIndexOf("(")+1, str.length()-1)));
				e.setCldeid(ei.getEid());
				e.setCldeiid(ei.getEiid());
				//校验关系是否存在
				SOC0119SearchCondImpl eirCond = new SOC0119SearchCondImpl();
				eirCond.setEirinfo(entityItem.getEiid()+"_"+configItem.getCiid()+"_"+ei.getEiid());
				eirCond.setEirstatus("C");
				eirCond.setDeleteflag("0");
				List<SOC0119Info> eirlist = this.soc0119BL.searchEntityItemRelation(eirCond, 0, 0);
				if(eirlist.size() != 1) {
					throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR, "IGCO10000.E017");
				} else {
					SOC0119TB eirTB = (SOC0119TB)SerializationUtils.clone(eirlist.get(0));
					
					eirTB.setEirinfo(eirTB.getEirinfo().replaceAll("_" + configItem.getCiid() + "_", "_" + ci.getCiid() + "_"));
					
					this.soc0119BL.updateEntityItemRelation(eirTB);
				}
			}
		}
		entityItem.setEistatus(CommonDefineUtils.ENTITYITEM_STARUS_RENEW);
		entityItem.setEiversion(entityItem.getEiversion() + 1);
		soc0118BL.updateEntityItem(entityItem);
		}
		dto.addMessage(new ActionMessage("IGASM0313.I001"));
		log.debug("========设备批量上缴处理开始========");
		
	}
	public IGCIM01DTO searchPreScrapEntityItemAction(IGCIM01DTO dto) throws BLException {
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
	
	public IGCIM01DTO searchScrapEntityItemAction(IGCIM01DTO dto) throws BLException {
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
	
	public IGCIM01DTO searchReceiveEntityItemAction(IGCIM01DTO dto) throws BLException {
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
	public void entityPreScrapAction(IGCIM01DTO dto) throws BLException {
			SOC0107SearchCondImpl cond = new SOC0107SearchCondImpl();
			cond.setEiid(String.valueOf(dto.getIgasm0311Form().getEiid()));
			cond.setCiversion(dto.getIgasm0311Form().getEiversion());
			this.saveConfigItem(dto, cond, CommonDefineUtils.ENTITYITEM_STARUS_PRESCRAP);
			
			SOC0118TB entityItem = (SOC0118TB)soc0118BL.searchEntityItemByKey(dto.getIgasm0311Form().getEiid());
			entityItem.setEistatus(CommonDefineUtils.ENTITYITEM_STARUS_PRESCRAP);
			entityItem.setEiversion(entityItem.getEiversion() + 1);
			soc0118BL.updateEntityItem(entityItem);
	}
	
	public void entityPreScrapBatchAction(IGCIM01DTO dto) throws BLException {
		for (int i = 0; i < dto.getBatchEntityItem().length; i++) {
			SOC0107SearchCondImpl cond = new SOC0107SearchCondImpl();
			cond.setEiid(dto.getBatchEntityItem()[i]);
			SOC0118TB entityItem = (SOC0118TB)soc0118BL.searchEntityItemByKey(Integer.parseInt(dto.getBatchEntityItem()[i]));
			cond.setCiversion(String.valueOf(entityItem.getEiversion()));
			this.saveConfigItem(dto, cond, CommonDefineUtils.ENTITYITEM_STARUS_PRESCRAP);
			
			entityItem.setEistatus(CommonDefineUtils.ENTITYITEM_STARUS_PRESCRAP);
			entityItem.setEiversion(entityItem.getEiversion() + 1);
			soc0118BL.updateEntityItem(entityItem);
		}
	}
	
	/**
	 * 设备报废处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public void entityScrapAction(IGCIM01DTO dto) throws BLException {
		SOC0107SearchCondImpl cond = new SOC0107SearchCondImpl();
		cond.setEiid(String.valueOf(dto.getIgasm0314Form().getEiid()));
		cond.setCiversion(dto.getIgasm0314Form().getEiversion());
		this.saveConfigItem(dto, cond, CommonDefineUtils.ENTITYITEM_STARUS_SCRAP);
		
		SOC0118TB entityItem = (SOC0118TB)soc0118BL.searchEntityItemByKey(dto.getIgasm0314Form().getEiid());
		entityItem.setEistatus(CommonDefineUtils.ENTITYITEM_STARUS_SCRAP);
		entityItem.setEiversion(entityItem.getEiversion() + 1);
		soc0118BL.updateEntityItem(entityItem);
	}
	
	public void entityScrapBatchAction(IGCIM01DTO dto) throws BLException {
		for (int i = 0; i < dto.getBatchEntityItem().length; i++) {
			SOC0107SearchCondImpl cond = new SOC0107SearchCondImpl();
			cond.setEiid(dto.getBatchEntityItem()[i]);
			SOC0118TB entityItem = (SOC0118TB)soc0118BL.searchEntityItemByKey(Integer.parseInt(dto.getBatchEntityItem()[i]));
			cond.setCiversion(String.valueOf(entityItem.getEiversion()));
			this.saveConfigItem(dto, cond, CommonDefineUtils.ENTITYITEM_STARUS_SCRAP);
			
			entityItem.setEistatus(CommonDefineUtils.ENTITYITEM_STARUS_SCRAP);
			entityItem.setEiversion(entityItem.getEiversion() + 1);
			soc0118BL.updateEntityItem(entityItem);
		}
	}
	
	/**
	 * 设备预报废撤销处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public void entityCancelPreScrapAction(IGCIM01DTO dto) throws BLException {
		SOC0107SearchCondImpl cond = new SOC0107SearchCondImpl();
		cond.setEiid(String.valueOf(dto.getIgasm0315Form().getEiid()));
		cond.setCiversion(dto.getIgasm0315Form().getEiversion());
		this.saveConfigItem(dto, cond, CommonDefineUtils.ENTITYITEM_STARUS_RENEW);
		
		SOC0118TB entityItem = (SOC0118TB)soc0118BL.searchEntityItemByKey(dto.getIgasm0315Form().getEiid());
		entityItem.setEistatus(CommonDefineUtils.ENTITYITEM_STARUS_RENEW);
		entityItem.setEiversion(entityItem.getEiversion() + 1);
		soc0118BL.updateEntityItem(entityItem);
	}
	public void entityCancelPreScrapBatchAction(IGCIM01DTO dto) throws BLException {
		for (int i = 0; i < dto.getBatchEntityItem().length; i++) {
			SOC0107SearchCondImpl cond = new SOC0107SearchCondImpl();
			cond.setEiid(dto.getBatchEntityItem()[i]);
			SOC0118TB entityItem = (SOC0118TB)soc0118BL.searchEntityItemByKey(Integer.parseInt(dto.getBatchEntityItem()[i]));
			cond.setCiversion(String.valueOf(entityItem.getEiversion()));
			this.saveConfigItem(dto, cond, CommonDefineUtils.ENTITYITEM_STARUS_RENEW);
			
			entityItem.setEistatus(CommonDefineUtils.ENTITYITEM_STARUS_RENEW);
			entityItem.setEiversion(entityItem.getEiversion() + 1);
			soc0118BL.updateEntityItem(entityItem);
		}
	}
	
	private void saveConfigItem(IGCIM01DTO dto,SOC0107SearchCond cond,String status) throws BLException {
		List<SOC0107Info> configItemList = soc0107BL.searchSOC0107(cond, 0, 0);
		for (SOC0107Info configItem : configItemList) {
			SOC0107TB ciTB = (SOC0107TB)SerializationUtils.clone(configItem);
			ciTB.setCiversion(configItem.getCiversion() + 1);
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
			if(configItem.getCivalue().equals(ciTB.getCivalue())) {
				//属性更新标识
				ciTB.setCicurver("0");
			} else {
				//属性更新标识
				ciTB.setCicurver("1");
			}
			SOC0107Info ci = soc0107BL.registSOC0107(ciTB);
			SOC0118TB entityItem = (SOC0118TB)soc0118BL.searchEntityItemByKey(Integer.parseInt(cond.getEiid()));
			//属性类别为资产时，修改关联关系
			if("4".equals(configItem.getConfiguration().getCattach()) && StringUtils.isNotEmpty(configItem.getCivalue())){
				SOC0119TB e = new SOC0119TB();
				e.setPareid(entityItem.getEid());
				e.setPareiid(entityItem.getEiid());
				String str = configItem.getCivalue();			
				SOC0118Info ei = this.soc0118BL.searchEntityItemByKey(Integer.parseInt(str.substring(str.lastIndexOf("(")+1, str.length()-1)));
				e.setCldeid(ei.getEid());
				e.setCldeiid(ei.getEiid());
				//校验关系是否存在
				SOC0119SearchCondImpl eirCond = new SOC0119SearchCondImpl();
				eirCond.setEirinfo(entityItem.getEiid()+"_"+configItem.getCiid()+"_"+ei.getEiid());
				eirCond.setEirstatus("C");
				eirCond.setDeleteflag("0");
				List<SOC0119Info> eirlist = this.soc0119BL.searchEntityItemRelation(eirCond, 0, 0);
				if(eirlist.size() != 1) {
					throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR, "IGCO10000.E017");
				} else {
					SOC0119TB eirTB = (SOC0119TB)SerializationUtils.clone(eirlist.get(0));
					
					eirTB.setEirinfo(eirTB.getEirinfo().replaceAll("_" + configItem.getCiid() + "_", "_" + ci.getCiid() + "_"));
					
					this.soc0119BL.updateEntityItemRelation(eirTB);
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
	public IGCIM01DTO initEntityItem(IGCIM01DTO dto) throws BLException {

		log.debug("========设备信息编辑画面初期显示处理开始========");
		
		IGCIM0108Form form = dto.getIgcim0108Form();
		
		//显示用资产信息取得
		SOC0124Info entityItem = this.soc0118BL.searchEntityItemVWByKey(form.getEiid());
		
		if ( entityItem == null ){
			throw new BLException("IGCO10000.E004",resources.getMessage(dto.getLocale(),"message.IGASM03BLImpl.015"));
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
		
		dto.setIgcim0108Form(form);
		
		if(!permission) {
			dto.addMessage(new ActionMessage("IGCO10000.E023",resources.getMessage(dto.getLocale(),"message.IGCIM01BLImpl.016")));
		}
		
		log.debug("========设备信息编辑画面初期显示处理终了========");
		return dto;
	}
	
	
	/**
	 *	获取设备关联关系处理
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
//	public IGCIM01DTO searchRelationListAction(IGCIM01DTO dto) throws BLException {
//		log.debug("========获取设备关联关系处理开始========");
//		List<LabelValueBean> newlist=new ArrayList<LabelValueBean>();
//		CodeDetailSearchCondImpl cond=new CodeDetailSearchCondImpl();
//		LabelValueBean lvb=null;
//		cond.setCcid("832");
//		cond.setBusinesscode_like("003-001");// host relation
//		List<CodeDetail> list=this.codeDetailBL.searchCodeDetail(cond, 0);
//		if(list.size()>0){
//			newlist.add(new LabelValueBean("",""));
//			for (int i = 0; i < list.size(); i++) {
//				lvb=new LabelValueBean();
//				lvb.setLabel(list.get(i).getCvalue());
//				lvb.setValue(list.get(i).getCid()+"#"+list.get(i).getBusinesscode());
//				newlist.add(lvb);
//			}
//		}
//		dto.setRelationList(newlist);
//		log.debug("========获取设备关联关系处理终了========");
//		return dto;
//	}
	
	public IGCIM01DTO searchRelationListAction(IGCIM01DTO dto) throws BLException {
		log.debug("========获取设备关联关系处理开始========");
		IGCIM0107Form form = dto.getIgcim0107Form();
		String esyscoding = form.getEsyscoding();
		List<LabelValueBean> newlist=new ArrayList<LabelValueBean>();
		CodeDetailSearchCondImpl cond=new CodeDetailSearchCondImpl();
		LabelValueBean lvb=null;
		cond.setCcid("832");
		//主机——应用模块
		if (esyscoding.startsWith(CommonDefineUtils.HOST_ESYSCODING)) {
			cond.setBusinesscode_like("001-003");
		} 
		//软件-软件
		else {
			cond.setBusinesscode_like("002-002");
		}
		List<CodeDetail> list=this.codeDetailBL.searchCodeDetail(cond, 0);
		if(list.size()>0){
			newlist.add(new LabelValueBean("",""));
			for (int i = 0; i < list.size(); i++) {
				lvb=new LabelValueBean();
				CodeDetail codeDetail = list.get(i);
				String cid = codeDetail.getCid();
//				主机——应用模块
				if (esyscoding.startsWith(CommonDefineUtils.HOST_ESYSCODING)) {
					lvb.setLabel(codeDetail.getCvalue());
					lvb.setValue(codeDetail.getCid()+"#"+codeDetail.getBusinesscode());
					newlist.add(lvb);
				} 
//				Tuxedo Machine——INSTANCE
//				Tuxedo Machine——Informix Server
				if (esyscoding.startsWith(EntityItemKeyWords.MACHINE_ESYSCODING)) {
					if (cid.equals(EntityItemKeyWords.Machine_INSTANCE_Relation) 
							|| cid.equals(EntityItemKeyWords.Machine_Informix_Server_Relation)) {
						lvb.setLabel(codeDetail.getCvalue());
						lvb.setValue(codeDetail.getCid()+"#"+codeDetail.getBusinesscode());
						newlist.add(lvb);
					}
				}
//				Jboss Webapp——INSTANCE
//				Jboss Webapp——Informix Server
				if (esyscoding.startsWith(EntityItemKeyWords.JBOSSWEBAPP_ESYSCODING)) {
					if (cid.equals(EntityItemKeyWords.JbossWebapp_INSTANCE_Relation) 
							|| cid.equals(EntityItemKeyWords.JbossWebapp_Informix_Server_Relation)) {
						lvb.setLabel(codeDetail.getCvalue());
						lvb.setValue(codeDetail.getCid()+"#"+codeDetail.getBusinesscode());
						newlist.add(lvb);
					}
				}
//				Webligc Webapp——INSTANCE
//				Webligc Webapp——Informix Server
				if (esyscoding.startsWith(EntityItemKeyWords.WEBAPP_ESYSCODING)) {
					if (cid.equals(EntityItemKeyWords.WEBAPP_INSTANCE_Relation) 
							|| cid.equals(EntityItemKeyWords.WEBAPP_Informix_Server_Relation)) {
						lvb.setLabel(codeDetail.getCvalue());
						lvb.setValue(codeDetail.getCid()+"#"+codeDetail.getBusinesscode());
						newlist.add(lvb);
					}
				}
				if (esyscoding.startsWith(EntityItemKeyWords.APPCOURSE)) {
					if (cid.equals(EntityItemKeyWords.APPCOURSE_INSTANCE_Relation)) {
						lvb.setLabel(codeDetail.getCvalue());
						lvb.setValue(codeDetail.getCid()+"#"+codeDetail.getBusinesscode());
						newlist.add(lvb);
					}
				}

			}
		}
		dto.setRelationList(newlist);
		log.debug("========获取设备关联关系处理终了========");
		return dto;
	}
	
	/**
	 *	获取设备关联关系处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO searchEiBelongRelationListAction(IGCIM01DTO dto) throws BLException {
		log.debug("========获取设备依赖关系处理开始========");
		//List<LabelValueBean> list = this.codeDetailBL.searchLabelValueBeanList(CommonDefineUtils.ENTIY_CATEGORY_DEVICE,CodeDefine.getCodeDefine("ENTITY_ITEM_BELONG_RELATION_CODE").getCcid());
		List<LabelValueBean> list=new ArrayList<LabelValueBean>();
		list.add(new LabelValueBean("", ""));
		IGCIM0107Form form = dto.getIgcim0107Form();
		String pareid = form.getPareid();
		String esyscoding = form.getEsyscoding();
		
		if(esyscoding.startsWith(EiRelationKeyWords.HOST)){
			pareid = EntityItemKeyWords.HOST_EID;
		}
		if(esyscoding.startsWith(EiRelationKeyWords.SWITCH)){
			pareid = EntityItemKeyWords.SWITCH_EID;
		}
		if(esyscoding.startsWith(EiRelationKeyWords.STORAGE)){
			pareid = EntityItemKeyWords.STORAGE_EID;
		}
		//正向查询
		SOC0152SearchCondImpl cond=new SOC0152SearchCondImpl();
		cond.setFromModelEid_eq(pareid);
		List<SOC0152Info> list1 = soc0152BL.searchSOC0152(cond);
		if(list1!=null&&list1.size()>0){
			for (SOC0152Info info : list1) {
				CodeDetail cod = codeDetailBL.searchCodeDetailByPK(new CodeDetailTBPK(CodeDefine.ENTITYITEM_RELATION_CODE.getCcid(),info.getRlnCode()));
				if(cod!=null){
					list.add(new LabelValueBean(info.getRlnDesc(), info.getRlnCode()+"#"+cod.getBusinesscode()+"#"+info.getTo0117TB().getEsyscoding()));
				}
			}
		}
		//反向查询
		cond=new SOC0152SearchCondImpl();
		cond.setToModelEid_eq(pareid);
		List<SOC0152Info> list2 = soc0152BL.searchSOC0152(cond);
		if(list2!=null&&list2.size()>0){
			for (SOC0152Info info : list2) {
				//业务系统-主机关系不保留
				if (EntityItemKeyWords.BUSINESS_HOST_Relation.equals(info.getRlnCode())) {
					continue;
				}
				CodeDetail cod = codeDetailBL.searchCodeDetailByPK(new CodeDetailTBPK(CodeDefine.ENTITYITEM_RELATION_CODE.getCcid(),info.getRlnCode()));
				if(cod!=null){
					list.add(new LabelValueBean(info.getRlnDesc(), info.getRlnCode()+"#"+cod.getBusinesscode()+"#"+info.getFrom0117TB().getEsyscoding()));
				}
			}
		}
		
		dto.setRelationList(list);
		log.debug("========获取设备依赖关系处理终了========");
		return dto;
	}
	
//	/**
//	 * 设备批量入库登记编辑画面初期化处理
//	 *
//	 * @param dto IGASM03DTO
//	 * @return IGASM03DTO
//	 */
//	public IGCIM01DTO initIGASM0317Action(IGCIM01DTO dto) throws BLException{
//		
//		log.debug("========设备批量入库登记信息编辑画面初期显示处理开始========");
//		
//		IGASM0317Form form = dto.getIgasm0317Form();
//		///显示用资产信息取得
//		SOC0118Info entityItem = this.soc0118BL.searchEntityItemByKey(Integer.parseInt(form.getPareiid()));
//		
//		if ( entityItem == null ){
//			throw new BLException("IGCO10000.E004","批量入库设备模版基本");
//		}
//		
//		//画面显示设定
//		
//		String orgsyscoding = entityItem.getEiorgsyscoding();
//		String esyscoding = entityItem.getEsyscoding();
//		SOC0117SearchCondImpl EntityCond = new SOC0117SearchCondImpl();
//		EntityCond.setEsyscoding(esyscoding);
//		List<SOC0117Info> entityList = this.soc0117BL.searchEntity(EntityCond, 0, 0);
//		for (int i = 0; i < entityList.size(); i++) {
//			form.setEname(entityList.get(0).getEname());
//		}
//		form.setEsyscoding(esyscoding);
//		OrganizationSearchCondImpl OrgCond = new OrganizationSearchCondImpl();
//		OrgCond.setOrgsyscoding(orgsyscoding);
//		List<Organization> orgList = this.organizationBL.searchOrganization(OrgCond, 0, 0);
//		for (int i = 0; i < orgList.size(); i++) {
//			form.setEiorgname(orgList.get(0).getOrgname());
//		}
//		form.setEiorgsyscoding(orgsyscoding);
//		Date nowDateTime = new Date();
//		String date = CommonDefineUtils.DATE_FORMAT.format(nowDateTime);
//		form.setEid(entityItem.getEid());
//		form.setEiinsdate(date);
//		form.setEidesc(entityItem.getEidesc());
//		form.setEiname(entityItem.getEiname());
//		dto.setIgasm0317Form(form);
//		log.debug("========设备批量入库登记信息编辑画面初期显示处理开始========");
//		return dto;
//	}
	
	

	/**
	 * 获取设备编号最大值
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO searchEntityItemLableAction(IGCIM01DTO dto) throws BLException {
		
		log.debug("========获取设备编号最大值处理开始========");
		
		IGCIM0102Form form = dto.getIgasm0302Form();
		
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
	public IGCIM01DTO checkEntityItemDomain(IGCIM01DTO dto) throws BLException{
		boolean isRoleManager = this.userRoleBL.checkRoleManagerByType(dto.getUser().getUserid(), EntityCategory.ROLE_TYPE_STORAGE);
		
		if(isRoleManager) {
			OrganizationSearchCondImpl orgCond = new OrganizationSearchCondImpl();
			orgCond.setOrgpar("0001");
			List<Organization> org = this.organizationBL.searchOrganization(orgCond);
			
			if(org.size() != 1) {
				throw new BLException("IGCO10000.E004",resources.getMessage(dto.getLocale(),"message.IGASM03BLImpl.017"));
			} else {
				dto.setOrgname(org.get(0).getOrgname());
				dto.setOrgsyscoding(org.get(0).getOrgsyscoding());
			}
			SOC0117SearchCondImpl entityCond = new SOC0117SearchCondImpl();
			entityCond.setEsyscoding(CommonDefineUtils.ENTIY_CATEGORY_DEVICE_SYSCODING);
			List<SOC0117Info> entity = this.soc0117BL.searchEntity(entityCond, 0, 0);
			
			if(entity.size() != 1) {
				throw new BLException("IGCO10000.E004",resources.getMessage(dto.getLocale(),"message.IGASM03BLImpl.018"));
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
	public List<SOC0128Info> getVersionUpdateTime (String eiid)throws BLException{
		
		
		List<SOC0128Info> resultList=this.soc0118BL.searchVersionUpdateTime(Integer.parseInt(eiid));
		return resultList;
	}

	/**
	 * 初始化资产配置信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM01DTO initXMLInfo(IGCIM01DTO dto) throws BLException{
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
	public IGCIM01DTO readXMLNodeInfo(IGCIM01DTO dto) throws BLException{
		IGCIM0101Form form = dto.getIgcim0101Form();
		//dto.setInfoMap(parseXMLNode(new File(dto.getFilepath()),form.getNodeID()));
		dto.setInfoMap(parseXMLNode(dto.getFilepath(),form.getNodeID()));
		return dto;
	}
	
	/**
	 * 解析配置信息XML文件中的指定结点的数据
	 * @param File
	 * @return Map<String,TreeNode> 
	 */
	@SuppressWarnings({"finally" })
	public Map<TreeNode,String> parseXMLNode(String filepath,String id) {
		Map<TreeNode,String> infoMap=new LinkedHashMap<TreeNode,String>();
		try{
			DocumentBuilderFactory domfac = DocumentBuilderFactory.newInstance();
			DocumentBuilder dombuilder = domfac.newDocumentBuilder();
		    //InputStream is = new FileInputStream(file); //从文件中取得
		    InputSource is = new InputSource(new InputStreamReader(new FileInputStream(new File(filepath)), "GBK"));
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
		    		
		    		if(node.getNodeType()==Node.ELEMENT_NODE && !"DATE".equals(node.getNodeName().toUpperCase()) && !"VER".equals(node.getNodeName().toUpperCase()) && !"RELATION".equals(node.getNodeName().toUpperCase())){

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
			e.printStackTrace();
			log.debug(e.getCause());
		}finally{
			return infoMap;
		}
	}
	
	/**
	 * 检查每级结点是否为选定的结点
	 * @param node	当前结点
	 * @param ptNode 上级结点
	 */
	public  void checkChildNodes(Node node,TreeNode ptNode,String key,Integer level,String id,Map<TreeNode,String> infoMap) {
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
					 NamedNodeMap nodemap = tempnode.getAttributes();//当前结点的属性集合
					 TreeNode showNode = new TreeNode();
					 String value = "";
					 showNode.setId(nodemap.getNamedItem("cid").getNodeValue());
					 showNode.setName(nodemap.getNamedItem("cname").getNodeValue());
					 NodeList temp_nodes = tempnode.getChildNodes();
					 for(int x=0,y=temp_nodes.getLength();x<y;x++){
						 Node cinode = temp_nodes.item(x);
						 if(cinode.getNodeType()==Node.ELEMENT_NODE && "value".equals(cinode.getNodeName().toLowerCase())){
							 value = cinode.getTextContent();
							 break;
						 }
					 }
					 infoMap.put(showNode, value);
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
	    	    	tmp = rootmap.getNamedItem("label").getNodeValue();
	    	    	tmp_type = rootmap.getNamedItem("type").getNodeValue();
	    	    }
	    	    rootNode.setName(tmp_type+"-"+tmp);

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
			    		//ptNode.setName(node.getNodeName());
			    		
			 			//添加孩子结点
			 			getChildNodes(node,ptNode,key,3);
			 			rootNode.addChildTreeNode(ptNode.getId(), ptNode);
		    		}
		    		
		    	}
		    	treeNodeMap.put(rootNode.getId(),rootNode);
		    	
		    }
		}catch(Exception e){
			e.printStackTrace();
			log.debug(e.getCause());
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
					 pdNode.setName(nodemap.getNamedItem("einame").getNodeValue());
				 }else{
					 pdNode.setName(tempnode.getNodeName());
				 }
				 
				 //只取前3级的结点作为组成树的元素
//				 if(tempnode.getChildNodes().getLength()>0 && level <= 3){
//					getChildNodes(tempnode,pdNode,pdNode.getId(),(level+1));
//				 }
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
	 * 比较2个版本配置信息XML中的数据(两个XML文件中的SCETION必需一样才能进行比较)
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM01DTO compareXMLInfoByVersion(IGCIM01DTO dto) throws BLException{
		
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
				for(int i=0,j=list1.size();i<j;i++){
					TreeNode node1 = list1.get(i);
					boolean flag = true;
					boolean flag2 = true;
					
					//比较command
					if(list2!=null){
						for(int m=0,n=list2.size();m<n;m++){
							TreeNode node2 = list2.get(m);	
							if(node1.getId().equals(node2.getId())){
								//当command1等于command2时，直接将当前command保存到自己新的list中
								new_command_list1.add(node1.getName());
								new_command_list2.add(node2.getName());
								flag = false;
								command_color_list.add("0");
								break;
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
							if(node1.getBelong().equals(node2.getBelong())){
								new_output_list1.add(node1.getBelong());
								new_output_list2.add(node2.getBelong());
								flag2 = false;
								output_color_list.add("0");
								break;
							}
						}
					}
					
					
					if(flag2){
						//当output2不存在于list1中并且new_output_list1不包含output2时，在new_output_list2中添加一个空行，并设置变色
						new_output_list1.add(node1.getBelong());
						new_output_list2.add("");
						output_color_list.add("1");
					}
					
				}

				//以另一个版本为出发点比较区别
				if(list2!=null){
					for(int i=0,j=list2.size();i<j;i++){
						TreeNode node2 = list2.get(i);
						boolean flag = true;
						boolean flag2 = true;
						
						//比较command
						if(list1!=null){
							for(int m=0,n=list1.size();m<n;m++){
								TreeNode node1 = list1.get(m);
								if(node2.getId().equals(node1.getId())){
									//new_command_list1.add(node1.getName());
									//new_command_list2.add(node2.getName());
									//command_color_list.add("0");
									flag = false;
									break;
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
								if(node2.getBelong().equals(node1.getBelong())){
									//new_output_list1.add(node1.getBelong());
									//new_output_list2.add(node2.getBelong());
									//output_color_list.add("0");
									flag2 = false;
									break;
								}
							}
						}
						
						if(flag2){
							new_output_list1.add("");
							new_output_list2.add(node2.getBelong());
							output_color_list.add("1");
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
	 * @param IGVIR06DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO searchXMLInfo(String filepath,IGCIM01DTO dto) throws BLException {
		try{
			DocumentBuilderFactory domfac = DocumentBuilderFactory.newInstance();
			DocumentBuilder dombuilder = domfac.newDocumentBuilder();
		    //InputStream is = new FileInputStream(file); //从文件中取得
		    InputSource is = new InputSource(new InputStreamReader(new FileInputStream(new File(filepath)), "GBK"));
		    Document doc = dombuilder.parse(is);   
		    Element root = doc.getDocumentElement();
		    NodeList nodes = root.getChildNodes();
		    Map<String,List<TreeNode>> command_map = new LinkedHashMap<String,List<TreeNode>>();
		    if(nodes!=null){
		    	for(int i=0,j=nodes.getLength();i<j;i++){
			    	//取得所有SECTION NODE
		    		Node node = nodes.item(i);
		    		
		    		if(node.getNodeType()==Node.ELEMENT_NODE && !"DATE".equals(node.getNodeName().toUpperCase()) && !"VER".equals(node.getNodeName().toUpperCase()) && !"RELATION".equals(node.getNodeName().toUpperCase())){
		    			NamedNodeMap rootnodemap = node.getAttributes();
		    			
		    			List<TreeNode> commandList = new ArrayList<TreeNode>();
		    			//保存SECTION
		    			TreeNode rootNode = new TreeNode();
		    			String section_name = "";
		    			
		    			if(rootnodemap!=null && rootnodemap.getNamedItem("label")!=null){
		    				section_name = rootnodemap.getNamedItem("label").getNodeValue();
			    		}else{
			    			section_name = node.getNodeName();
			    		}
		    			rootNode.setName(section_name);
		    			
		    			//rootNode.setId(eilabel);
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
			 					String command_eilabel = "";
			 					if(commandnodemap!=null && commandnodemap.getLength()>0){
			 						command_LBL = commandnodemap.getNamedItem("einame").getNodeValue();
			 						command_eilabel = commandnodemap.getNamedItem("eilabel").getNodeValue();
			 					}

			 					pdNode.setName(command_LBL);//einame
			 					pdNode.setId(command_eilabel);//eilabel

				 				NodeList outputnodes = commandnode.getChildNodes();
				 				//取得OUTPUT（CI）
				 				StringBuffer buff = new StringBuffer();
				 				for(int x=0,y=outputnodes.getLength();x<y;x++){
				 					Node outputnode = outputnodes.item(x);
				 					//判断当前结点是否为页面选择的结点
				 					if(outputnode.getNodeType()==Node.ELEMENT_NODE && "CI".equals(outputnode.getNodeName().toUpperCase())){
				 						NodeList cinodes = outputnode.getChildNodes();
				 						String cname = "";
				 						String value = "";
				 						for(int a=0,b=cinodes.getLength();a<b;a++){
				 							Node cinode = cinodes.item(a);
				 							if(cinode.getNodeType()==Node.ELEMENT_NODE && "CNAME".equals(cinode.getNodeName().toUpperCase())){
				 								cname = cinode.getTextContent();
				 							}else if(cinode.getNodeType()==Node.ELEMENT_NODE && "VALUE".equals(cinode.getNodeName().toUpperCase())){
				 								value = cinode.getTextContent();
				 							}
				 						}
				 						
				 						//保存OUTPUT
				 						buff.append("\n");
				 						buff.append(cname);
				 						buff.append(" : ");
				 						buff.append(value);
				 						buff.append("\n");
				 					}
				 					
				 				}
				 				pdNode.setBelong(buff.toString());
				 				commandList.add(pdNode);
			 				}
			 			}
			 			
			 			command_map.put(section_name, commandList);
		    		}
		    		
		    	}
		    	dto.setCommand_map(command_map);
		    }
		}catch(Exception e){
			log.debug(e.getCause());
			throw new BLException("IGCO10000.E004","配置文件");
		}
		return dto;
	}
	
	
	
	
	public static void main(String[] args){
		try{
			Date data = new Date();
//			DocumentBuilderFactory domfac = DocumentBuilderFactory.newInstance();
//			DocumentBuilder dombuilder = domfac.newDocumentBuilder();
////		    InputStream is = new FileInputStream("F:/SOC/AIX XML Resource/Result/x/config-view.xml"); //从文件中取得
////		    Document doc = dombuilder.parse(is);   
//		    //Document doc = dombuilder.parse(new InputSource(new StringReader(source)));
//			InputSource is = new InputSource(new InputStreamReader(new FileInputStream(new File("C:\\parseXML\\AIX_XML\\config-view.xml")), "GBK"));
//		    Document doc = dombuilder.parse(is);   
//		    Element root = doc.getDocumentElement();
//		    NodeList nodes = root.getChildNodes();
//		    NamedNodeMap map = root.getAttributes();
//		    System.out.println("root==="+root.getNodeName()+"----"+map.getNamedItem("label").getNodeValue()); 
//		    if(nodes!=null){
//		    	for(int i=0,j=nodes.getLength();i<j;i++){
//		    		 Node node = nodes.item(i);
//		    		 if(node.getNodeType()==Node.ELEMENT_NODE && !"RELATION".equals(node.getNodeName().toUpperCase()) && !"DATE".equals(node.getNodeName().toUpperCase()) && !"VER".equals(node.getNodeName().toUpperCase())){
//		    			 NamedNodeMap nodemap = node.getAttributes();
//		    			 if(nodemap!=null && nodemap.getLength()>0){
//		    				 System.out.println("name==="+node.getNodeName()+"----"+nodemap.getNamedItem("esyscoding").getNodeValue());
//		    			 }
//		    			 
//		    			 //System.out.println("pppp==="+node.a); 
//		    			// getChildNodes(node,ptNode,key,3);
//		    		 }else if(node.getNodeType()==Node.ELEMENT_NODE && "RELATION".equals(node.getNodeName().toUpperCase())){
//		    			 NamedNodeMap nodemap = node.getAttributes();
//		    			 System.out.println("name==="+node.getNodeName()+"----"+nodemap.getNamedItem("ename").getNodeValue());
//		    		 }
//
//		    	}
//			
//		    }
//		    
		}catch(Exception e ){
			e.printStackTrace();
		}
		
	}
	/**
	 * 设备配置信息编辑画面初期化处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO initIGCIM0104Action(IGCIM01DTO dto) throws BLException {

		log.debug("========设备配置信息编辑画面初期化处理开始========");
		
		IGCIM0104Form form = dto.getIgasm0304Form();
		
		//设备信息检索
//		EntityItemVWInfo entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(
//				Integer.parseInt(form.getEiid()));
		//以前查视图，考虑到方法下面与页面只用到2个表内容，只查出2个表内容，然后拼成视图对象. _ylq
		SOC0118Info entityItemInfo=soc0118BL.searchEntityItemByKey(Integer.parseInt(form.getEiid()));
		SOC0117Info entity=soc0117BL.searchEntityByKey(entityItemInfo.getEid());
		SOC0124VW entityItemVWInfo=new SOC0124VW();
		entityItemVWInfo.setEname(entity.getEname());
		entityItemVWInfo.setEilabel(entityItemInfo.getEilabel());
		entityItemVWInfo.setEiname(entityItemInfo.getEiname());
		entityItemVWInfo.setEidesc(entityItemInfo.getEidesc());
		entityItemVWInfo.setEistatus(entityItemInfo.getEistatus());
		entityItemVWInfo.setEiusername(entityItemInfo.getEiusername());
		entityItemVWInfo.setEiinsdate(entityItemInfo.getEiinsdate());
		entityItemVWInfo.setEiupdtime(entityItemInfo.getEiupdtime());
		entityItemVWInfo.setEsyscoding(entityItemInfo.getEsyscoding());
		entityItemVWInfo.setEiorgsyscoding(entityItemInfo.getEiorgsyscoding());
		entityItemVWInfo.setEiversion(entityItemInfo.getEiversion());
		entityItemVWInfo.setEismallversion(entityItemInfo.getEismallversion());
		entityItemVWInfo.setEid(entityItemInfo.getEid());
		entityItemVWInfo.setEiid(entityItemInfo.getEiid());
		entityItemVWInfo.setEirootmark(entityItemInfo.getEirootmark());
		entityItemVWInfo.setEmodeltype(entity.getEmodeltype());
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004",resources.getMessage(dto.getLocale(),"message.IGASM03BLImpl.004"));
		}
		
		form.setEidesc(entityItemVWInfo.getEidesc());
		form.setEistatus(entityItemVWInfo.getEistatus());
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
		
		//是否可继承标识，使用entity表中预留字段EKEY2, 0代表继承，1代表不继承
		String ekey2 = entity.getEkey2();
		form.setEkey2(ekey2);
		
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
		String[] entityItemCivalue = new String[totalCount];
		//存放旧版本值
		String[] civalue_bak = new String[totalCount];
		Map<String,List<SOC0129Info>> map = new LinkedHashMap<String,List<SOC0129Info>>();
		int i = 0;
		int j = 0;
		List<String> strlist = new ArrayList<String>();
		Collections.reverse(configItemVWInfoList);
		for(SOC0129Info e : configItemVWInfoList){
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
		for(String str : strlist){
			for(SOC0129Info e : map.get(str)){
				//显示是资产名称，实际存值是资产名称(资产ID)
				if("4".equals(e.getCattach()) && StringUtils.isNotEmpty(e.getCivalue())){
					civalue[i] = e.getCivalue().substring(0, e.getCivalue().lastIndexOf("("));
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
		//form.setDelfile(delfile);
		form.setCivalue_bak(civalue_bak);
		
		dto.setConfigItemVWInfoMap(map);
//		dto.addMessage(new ActionMessage("IGCO10000.I007",totalCount));
		
		
		//获取历史版本更新时间
		if(entityItemVWInfo.getEiversion() > 0) {
			dto.setConfigItemVersionTime(this.soc0118BL.searchVersionUpdateTime(entityItemVWInfo.getEiid()));
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
		public IGCIM01DTO editEntityItemAction(IGCIM01DTO dto) throws BLException,FileNotFoundException,IOException {
			log.debug("========设备配置信息编辑处理开始========");
			//版本号生成
			IGCIM0104Form form = dto.getIgasm0304Form();
			
			//配置模型升级小版本，其余升级大版本
			int version = form.getEiversion();//大版本
			int smallversion = form.getEismallversion();//小版本
			String fileversion = version + "";//附件版本
			
			if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(form.getEmodeltype())) {
				smallversion++;
				fileversion = version + "_" + smallversion;
			} else {
				version++;
			}
			
			//设备基本信息更新
			SOC0118TB entityItem = (SOC0118TB) this.soc0118BL.searchEntityItemByKey(Integer.parseInt(form.getEiid()));

			//判断数据是否已经被保存
			if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(form.getEmodeltype())) {
				if(smallversion - 1 != entityItem.getEismallversion()) {
					throw new BLException("IGCO00000.E004");
				}
			} else {
				if(version - 1 != entityItem.getEiversion()) {
					throw new BLException("IGCO00000.E004");
				}
			}
			
			//资产关系信息版本升级处理
			this.soc0119BL.upgradeEntityItemRelation(entityItem.getEiid(), entityItem.getEiversion(), entityItem.getEismallversion(),
					version, smallversion);
			
			//资产所属关系信息版本升级处理
			this.soc0110BL.upgradeEntityItemRelation(entityItem.getEiid(), entityItem.getEiversion(), entityItem.getEismallversion(),
					version, smallversion);
			
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
			
			//设备名称
			entityItem.setEiname(form.getEiname());
			
			SOC0118Info hostei = this.soc0118BL.updateEntityItem(entityItem);
			
			//调用更新BL
			String rootPath = ResourceUtility.getString("UPLOAD_FILE_ROOT_PATH");
			String fileNameXML = null;
			SOC0118Info hosteiXML = null;
			boolean flagXML = false;
			
			boolean copyFlag = false;//是否为拷贝的配置文件
			SOC0107TB configItemXML = new SOC0107TB();
			//设备配置信息更新
			if (form.getCiid() != null && form.getCiid().length > 0 ) {
				//当修改属性时，取得不包含扩展属性的其他属性，将其与对比属性想对应的属性赋予给它
				Map<String,String> ssMap = new HashMap<String,String>();
				for( int i=0 ; i < form.getCiid().length; i++ ){
					if(form.getCid()[i].indexOf("CI")!=-1){
						ssMap.put(form.getCid()[i], form.getCivalue()[i]);
					}
				}
				for( int i=0 ; i < form.getCiid().length; i++ ){
					SOC0107TB configItem = new SOC0107TB();
					//设备ID
					configItem.setEiid(Integer.parseInt(form.getEiid()));
					//资产配置ID
					configItem.setCid(form.getCid()[i]);
					//类型ID
					configItem.setEid(form.getEid()[i]);
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
							e.setEirdesc(resources.getMessage(dto.getLocale(),"message.IGCIM01BLImpl.005")+cname+
									resources.getMessage(dto.getLocale(),"message.IGACIM01BLImpl.006"));
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
								//修改对比属性
								if(form.getCid()[i].indexOf("BI")!=-1){
									String value = ssMap.get(form.getCid()[i].replace("BI", "CI"));
									if(StringUtils.isNotEmpty(value)){
										configItem.setCivalue(value);
									}
								}
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
							//校验关系是否存在
							SOC0119SearchCondImpl cond = new SOC0119SearchCondImpl();
							cond.setEirinfo(entityItem.getEiid()+"_"+form.getCiid()[i]+"_"+ei.getEiid());
							cond.setEirstatus("C");
							cond.setParversion(Integer.parseInt(entityItem.getEiversion().toString()));
							cond.setParsmallversion(Integer.parseInt(entityItem.getEismallversion().toString()));
							cond.setDeleteflag("0");
							List<SOC0119Info> eirlist = this.soc0119BL.searchEntityItemRelation(cond, 0, 0);
							if(eirlist.isEmpty()){
								//删除原来已有的关系
								SOC0119SearchCondImpl eircond = new SOC0119SearchCondImpl();
								eircond.setEirinfo(entityItem.getEiid()+"_"+form.getCiid()[i]+"_");
								eircond.setEirstatus("C");
								eircond.setParversion(Integer.parseInt(entityItem.getEiversion().toString()));
								eircond.setParsmallversion(Integer.parseInt(entityItem.getEismallversion().toString()));
								eircond.setDeleteflag("0");
								List<SOC0119Info> eir = this.soc0119BL.searchEntityItemRelation(eircond, 0, 0);
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
								e.setEirdesc(resources.getMessage(dto.getLocale(),"message.IGCIM01BLImpl.005")+cname+
										resources.getMessage(dto.getLocale(),"message.IGCIM01BLImpl.006"));
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
							eircond.setParversion(Integer.parseInt(entityItem.getEiversion().toString()));
							eircond.setParsmallversion(Integer.parseInt(entityItem.getEismallversion().toString()));
							eircond.setDeleteflag("0");
							List<SOC0119Info> eir = this.soc0119BL.searchEntityItemRelation(eircond, 0, 0);
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
							String fileType = "";
							String sFileName = file.getFileName();
							int point = sFileName.lastIndexOf(".");
							if (point != -1) {
								fileType = sFileName.substring(point);
								fileName.append(sFileName.substring(0, point));
							}

							//文件扩展名
							fileName.append(fileType);
							fileName.append("_" + fileversion);
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
					saveXML(new File(rootPath+"XML"+File.separator+"asm"+File.separator+String.valueOf(configItemXML.getEiid())+File.separator+fileNameXML),dto.getUser(),hostei);
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
			
			dto.addMessage(new ActionMessage("IGCO10000.I005",resources.getMessage(dto.getLocale(),"message.IGCIM01BLImpl.007")));
			
			log.debug("========设备配置信息编辑处理终了========");
			
			return dto;
		}
	

		/**
		 * 首次保存符合IG规范的XML文件中的数据
		 * @param filepath
		 * @param user
		 * @throws IOException 
		 * @throws FileNotFoundException 
		 */
		public void insertIntoDBFromXMLFirst(IGCIM0104Form form,User user) throws BLException,FileNotFoundException,IOException {

			saveXMLFrist(form,user);

//			File filedir = new File(filepath);//IG规范XML文件夹
//			if(filedir.isDirectory()){
//				File[] files = filedir.listFiles();
//				if(files!=null && files.length>0){
//					saveXML(files[0],user,null);
//					//files[0].delete();//删除导入过的文件
//				}else{
//					throw new BLException("IGASM0322.E003");
//				}
//				
//			}
		}

	
	/**
	 * 将符合IG平台规范的XML数据文件导入到CMDB中
	 * @param file
	 * @param user
	 * @param eiid 有值代表需要更新主机的信息
	 * @return
	 * @throws BLException
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@SuppressWarnings({"finally" })
	private String saveXMLFrist(IGCIM0104Form form,User user) throws BLException, FileNotFoundException, IOException {
		String result = "";
		String eiorgsyscoding = ASMHelper.XML_FILE_ORG_ID;
		String eiuserid = user.getUserid();
		String eiusername = user.getUsername();
		try{
			
			//创建主机实体
			SOC0118TB ei_temp = new SOC0118TB();
			ei_temp.setEilabel("NO_NAME_ENTITY");
			ei_temp.setEid("CM0101");
			SOC0118Info host_ei = this.soc0118BL.registEntityItem(ei_temp);
			String rootPath = ResourceUtility.getString("UPLOAD_XML_FILE_ROOT_PATH");
			String ci_Civalue = "";//上传文件名
			String ci_Cicurver = "1";//属性更新标识
			String file_eid = "CM01010001";
			String file_cid = "CI010100010021";
			String file_esyscoding = "999001001";
			
			//保存附件
			FormFile file = form.getAttachFileXML(0);
			if ( file != null && file.getFileSize() > 0) {
				//上传文件存在的情况
				//上传文件路径
				
				StringBuffer pathBuf = new StringBuffer();
				
				//根目录
				pathBuf.append(rootPath+File.separator);
				//设备ID
				pathBuf.append(host_ei.getEiid()+File.separator);
				
				StringBuffer fileName = new StringBuffer();
				
				//扩展名取得
				String fileType = "";
				String sFileName = file.getFileName();
				int point = sFileName.lastIndexOf(".");
				if (point != -1) {
					fileType = sFileName.substring(point);
					fileName.append(sFileName.substring(0, point));
				}

				//文件扩展名
				fileName.append(fileType);
				fileName.append("_1");
				//文件上传处理
				this.fileUploadBL.saveFile(file, pathBuf.toString(), fileName.toString());
				
				//上传文件名保存
				ci_Civalue = fileName.toString();
				//configItem.setCivalue(fileName.toString());

			}
			File xmlfile = new File(rootPath+String.valueOf(host_ei.getEiid())+File.separator+ci_Civalue);
			DocumentBuilderFactory domfac = DocumentBuilderFactory.newInstance();
			DocumentBuilder dombuilder;

			dombuilder = domfac.newDocumentBuilder();
			
		    //InputStream is = new FileInputStream(file); //从文件中取得
			
		    InputSource is = new InputSource(new InputStreamReader(new FileInputStream(xmlfile), "GBK"));
		    Document doc;
			
			doc = dombuilder.parse(is);
			
		    //Document doc = dombuilder.parse(new InputSource(new StringReader(source)));
		    Element root = doc.getDocumentElement();
		    //NamedNodeMap rootmap = root.getAttributes();//root结点的属性集合
		    NodeList nodes = root.getChildNodes();
		    //String key = ASMHelper.NODE_KEY;
		    if(nodes!=null){
		    	//取得模型esyscoding
		    	String nowdate = IGStringUtils.getCurrentDateTime();
		    	String indate = "";
		    	List<String> existList = new ArrayList<String>();//保存已经存在的资产实体eilabel
		    	for(int i=0,j=nodes.getLength();i<j;i++){
		    		Node node = nodes.item(i);
		    		Integer ver = 1;
		    		if(node.getNodeType()==Node.ELEMENT_NODE && "DATE".equals(node.getNodeName())){
		    			//取得登记日期
		    			indate = node.getTextContent();
		    		}else if(node.getNodeType()==Node.ELEMENT_NODE && "RELATION".equals(node.getNodeName().toUpperCase())){
		    			NamedNodeMap nodemap = node.getAttributes();
		    			NodeList relation_nodes = node.getChildNodes();//from,to
		    			String esyscoding_to = nodemap.getNamedItem("esyscoding").getNodeValue().trim();
		    			String ename_to = nodemap.getNamedItem("ename").getNodeValue().trim();
		    			SocRelationTB soctb = new SocRelationTB();
		    			soctb.setSresycoding(esyscoding_to);
		    			soctb.setSrename(ename_to);
		    			soctb.setVersion(Integer.valueOf(ver));//版本号
		    			for(int n=0,m=relation_nodes.getLength();n<m;n++){
		    				Node relation_node = relation_nodes.item(n);
		    				if(relation_node.getNodeType()==Node.ELEMENT_NODE && "FROM".equals(relation_node.getNodeName().toUpperCase())){
			    				soctb.setSreilabel(relation_node.getTextContent());
			    			}else if(relation_node.getNodeType()==Node.ELEMENT_NODE && "TO".equals(relation_node.getNodeName().toUpperCase())){
			    				soctb.setSrpareilabel(relation_node.getTextContent());
			    			}
		    			}
		    			
		    			//当资产未保存过时保存该资产关系
		    			if(!existList.contains(soctb.getSrpareilabel())){
		    				//保存资产关系
			    			this.socRelationBL.registSocRelation(soctb);
		    			}
		    			
		    			
		    			
		    		}else if(node.getNodeType()==Node.ELEMENT_NODE  && "ATTR_SELF".equals(node.getNodeName().toUpperCase())){//HOST
		    			
		    			NodeList ei_nodes = node.getChildNodes();
		    			
		    			if(ei_nodes!=null && ei_nodes.getLength()>0){
		    				for(int a=0,b=ei_nodes.getLength();a<b;a++){
		    					Node einode = ei_nodes.item(a);
		    					if(einode.getNodeType()==Node.ELEMENT_NODE && "ENTITYITEM".equals(einode.getNodeName().toUpperCase())){
		    						NamedNodeMap nodemap = einode.getAttributes();
		    		    			//取得资产信息
		    		    			//查询该资产是否已存在,如不存在则保存，如存在则更新
		    						String esyscoding = nodemap.getNamedItem("esyscoding").getNodeValue();
		    				    	String eid = nodemap.getNamedItem("eid").getNodeValue();;
		    		    			String eilabel = nodemap.getNamedItem("eilabel").getNodeValue().trim();//资产编号
		    		    			String einame = nodemap.getNamedItem("einame").getNodeValue().trim();//资产名称
		    		    			SOC0118Info ei = null;

		    		    			//查询entityitem是否存在
		    		    			SOC0118SearchCondImpl cond = new SOC0118SearchCondImpl();
		    		    			cond.setEilabel(eilabel);
		    		    			List<SOC0118Info> eilist = this.soc0118BL.searchEntityItem(cond);
		    		    			
		    		    			//不存在，则保存
		    		    			if(eilist==null || eilist.size()==0){
		    		    				//保存
		    		    				ver = 1;
		    		    				SOC0118TB eitb = (SOC0118TB)SerializationUtils.clone(host_ei);
		    			    			eitb.setEid(eid);
		    			    			eitb.setEiname(einame);//资产名称
		    			    			eitb.setEiorgsyscoding(eiorgsyscoding);//所属机构
		    			    			eitb.setEiinsdate(indate);//登记日
		    			    			eitb.setEiupdtime(nowdate);//更新时间
		    			    			eitb.setEsyscoding(esyscoding.trim());//资产模型层次码
		    			    			eitb.setEilabel(eilabel);//资产编号
		    			    			eitb.setEiuserid(eiuserid);//登记人ID
		    			    			eitb.setEiusername(eiusername);//登记人姓名
		    			    			if(esyscoding!=null && esyscoding.length()>=6 && "999001".equals(esyscoding.substring(0, 6))){
		    			    				eitb.setEistatus("N");
		    							}else{
		    								eitb.setEistatus("");//EISTATUS 
		    							}
		    			    			eitb.setEiversion(ver);
		    			    			
		    			    			ei = this.soc0118BL.updateEntityItem(eitb);
		    			    			
			    		    			if(ei == null){
			    		    				throw new BLException("IGASM0322.E001");
			    		    			}
			    		    			
			    		    			//保存附件属性
			    		    			SOC0107TB file_citb = new SOC0107TB();
			    		    			file_citb.setEiid(ei.getEiid());
			    		    			file_citb.setCiupdtime(nowdate);//更新时间
			    		    			file_citb.setCiversion(ver);//属性版本
			    		    			file_citb.setEid(file_eid);
			    		    			file_citb.setEsyscoding(file_esyscoding);
			    		    			file_citb.setCid(file_cid);//CID
			    		    			file_citb.setCivalue(ci_Civalue);
			    		    			file_citb.setCicurver(ci_Cicurver);
	        							this.soc0107BL.registSOC0107(file_citb);
			    		    			
			    		    			//取得该资产的属性集合
			    		    			NodeList cinodes = einode.getChildNodes();
			    		    			for(int n=0,m=cinodes.getLength();n<m;n++){
			    		    				Node cinode = cinodes.item(n);
			    		    				if(cinode.getNodeType()==Node.ELEMENT_NODE && "CI".equals(cinode.getNodeName().toUpperCase())){
			    		    					NamedNodeMap ci_nodemap = cinode.getAttributes();
			    		    					NodeList cid_nodes = cinode.getChildNodes();//cname,value

			    		    					SOC0107TB citb = new SOC0107TB();
			    		    					citb.setEiid(ei.getEiid());
			    		    					citb.setCiupdtime(nowdate);//更新时间
			    		    					citb.setCiversion(ver);//属性版本
			    		    					citb.setEid(ci_nodemap.getNamedItem("eid").getNodeValue());
			        							citb.setEsyscoding(ci_nodemap.getNamedItem("esyscoding").getNodeValue().trim());
			        							citb.setCid(ci_nodemap.getNamedItem("cid").getNodeValue());//CID
			    		    					for(int x=0,y=cid_nodes.getLength();x<y;x++){
			    		    						Node cid_node = cid_nodes.item(x);
			    		    						//设置属性信息
			    		    						if(cid_node.getNodeType()==Node.ELEMENT_NODE && "VALUE".equals(cid_node.getNodeName().toUpperCase())){
			    		    							citb.setCivalue(cid_node.getTextContent()==null?"":cid_node.getTextContent());
			    		    							//CICURVER为0代表未修改该属性，1代表修改了该属性
			    		    							if(StringUtils.isNotEmpty(cid_node.getTextContent().trim())){
			    		    								citb.setCicurver("1");
			    		    							}else{
			    		    								citb.setCicurver("0");
			    		    							}
			    		    						}	
			    		    					}
			    		    					//保存属性
			    		    					this.soc0107BL.registSOC0107(citb);
			    		    				}
			    		    			}
		    		    			}else{
		    		    				//保存已经存在的资产的资产编号
		    		    				existList.add(eilabel);
		    		    				//删除占位的entityitem
		    		    				this.soc0118BL.deleteEntityItem(host_ei);
		    		    			}

		    					}
		    				}
		    			}

		    		}else if(node.getNodeType()==Node.ELEMENT_NODE){//HBA、VG等
		    			
		    			NodeList ei_nodes = node.getChildNodes();
		    			
		    			if(ei_nodes!=null && ei_nodes.getLength()>0){
		    				for(int a=0,b=ei_nodes.getLength();a<b;a++){
		    					Node einode = ei_nodes.item(a);
		    					if(einode.getNodeType()==Node.ELEMENT_NODE && "ENTITYITEM".equals(einode.getNodeName().toUpperCase())){
		    						NamedNodeMap nodemap = einode.getAttributes();
		    		    			//取得资产信息
		    		    			//查询该资产是否已存在,如不存在则保存，如存在则更新
		    		    			String esyscoding = nodemap.getNamedItem("esyscoding").getNodeValue();
		    				    	String eid = nodemap.getNamedItem("eid").getNodeValue();;
		    		    			String eilabel = nodemap.getNamedItem("eilabel").getNodeValue().trim();//资产编号
		    		    			String einame = nodemap.getNamedItem("einame").getNodeValue().trim();//资产名称
		    		    			SOC0118SearchCondImpl cond = new SOC0118SearchCondImpl();
		    		    			cond.setEilabel(eilabel);
		    		    			List<SOC0118Info> eiList = this.soc0118BL.searchEntityItem(cond);
		    		    			SOC0118Info ei = null;
		    		    			//存在，则不保存
		    		    			if(eiList!=null && eiList.size()>0){
		    		    				//更新
//		    		    				ver = eiList.get(0).getEiversion()+1;
//		    		    				EntityItemTB eitb = (EntityItemTB)SerializationUtils.clone(eiList.get(0));
//		    		    				eitb.setEiupdtime(nowdate);//更新时间
//		    		    				eitb.setEiversion(ver);
//		    		    				
//		    		    				ei = this.soc0118BL.updateEntityItem(eitb);
		    		    				
		    		    				//保存已经存在的资产的资产编号
		    		    				existList.add(eilabel);
		    		    			}else{
		    		    				//保存
		    		    				ver = 1;
		    		    				SOC0118TB eitb = new SOC0118TB();
		    			    			eitb.setEid(eid);
		    			    			eitb.setEiname(einame);//资产名称
		    			    			eitb.setEiorgsyscoding(eiorgsyscoding);//所属机构
		    			    			eitb.setEiinsdate(indate);//登记日
		    			    			eitb.setEiupdtime(nowdate);//更新时间
		    			    			eitb.setEsyscoding(esyscoding.trim());//资产模型层次码
		    			    			eitb.setEilabel(eilabel);//资产编号
		    			    			eitb.setEiuserid(eiuserid);//登记人ID
		    			    			eitb.setEiusername(eiusername);//登记人姓名
		    			    			if(esyscoding!=null && esyscoding.length()>=6 && "999001".equals(esyscoding.substring(0, 6))){
		    			    				eitb.setEistatus("N");
		    							}else{
		    								eitb.setEistatus("");//EISTATUS 
		    							}
		    			    			eitb.setEiversion(ver);

		    			    			ei = this.soc0118BL.registEntityItem(eitb);
		    			    			
		    			    			if(ei == null){
			    		    				throw new BLException("IGASM0322.E001");
			    		    			}
			    		    			//取得该资产的属性集合
			    		    			NodeList cinodes = einode.getChildNodes();
			    		    			for(int n=0,m=cinodes.getLength();n<m;n++){
			    		    				Node cinode = cinodes.item(n);
			    		    				if(cinode.getNodeType()==Node.ELEMENT_NODE && "CI".equals(cinode.getNodeName().toUpperCase())){
			    		    					NamedNodeMap ci_nodemap = cinode.getAttributes();
			    		    					NodeList cid_nodes = cinode.getChildNodes();//cname,value

			    		    					SOC0107TB citb = new SOC0107TB();
			    		    					citb.setEiid(ei.getEiid());
			    		    					citb.setCiupdtime(nowdate);//更新时间
			    		    					citb.setCiversion(ver);//属性版本
			    		    					citb.setEid(ci_nodemap.getNamedItem("eid").getNodeValue());
			        							citb.setEsyscoding(ci_nodemap.getNamedItem("esyscoding").getNodeValue().trim());
			        							citb.setCid(ci_nodemap.getNamedItem("cid").getNodeValue());//CID
			    		    					for(int x=0,y=cid_nodes.getLength();x<y;x++){
			    		    						Node cid_node = cid_nodes.item(x);
			    		    						//设置属性信息
			    		    						if(cid_node.getNodeType()==Node.ELEMENT_NODE && "VALUE".equals(cid_node.getNodeName().toUpperCase())){
			    		    							citb.setCivalue(cid_node.getTextContent()==null?"":cid_node.getTextContent());
			    		    							//CICURVER为0代表未修改该属性，1代表修改了该属性
			    		    							if(StringUtils.isNotEmpty(cid_node.getTextContent().trim())){
			    		    								citb.setCicurver("1");
			    		    							}else{
			    		    								citb.setCicurver("0");
			    		    							}
			    		    						}	
			    		    					}
			    		    					//保存属性
			    		    					this.soc0107BL.registSOC0107(citb);
			    		    				}
			    		    			}

		    		    			}
		    		    			
		    					}
		    				}
		    			}
		    			
		    			
		    			
		    		}
		    		
		    	}
		    	
		    }
		    
		    return result;
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			log.debug(e.getCause());
			throw new BLException("IGASM0322.E002");
		} catch (SAXException e) {
			e.printStackTrace();
			log.debug(e.getCause());
			throw new BLException("IGASM0322.E002");
		}  
	}
	/**
	 * 将符合IG平台规范的XML数据文件导入到CMDB中
	 * @param file
	 * @param user
	 * @param eiid 有值代表需要更新主机的信息
	 * @return
	 * @throws BLException
	 */
	@SuppressWarnings({"finally" })
	private String saveXML(File file,User user,SOC0118Info hostei) throws BLException {
		String result = "";
		String eiorgsyscoding = ASMHelper.XML_FILE_ORG_ID;
		String eiuserid = user.getUserid();
		String eiusername = user.getUsername();
		try{
			DocumentBuilderFactory domfac = DocumentBuilderFactory.newInstance();
			DocumentBuilder dombuilder = domfac.newDocumentBuilder();
		    //InputStream is = new FileInputStream(file); //从文件中取得
			
		    InputSource is = new InputSource(new InputStreamReader(new FileInputStream(file), "GBK"));
		    Document doc = dombuilder.parse(is);   
		    //Document doc = dombuilder.parse(new InputSource(new StringReader(source)));
		    Element root = doc.getDocumentElement();
		    //NamedNodeMap rootmap = root.getAttributes();//root结点的属性集合
		    NodeList nodes = root.getChildNodes();
		    //String key = ASMHelper.NODE_KEY;
		    if(nodes!=null){
		    	//取得模型esyscoding
		    	String nowdate = IGStringUtils.getCurrentDateTime();
		    	String indate = "";
		    	
		    	for(int i=0,j=nodes.getLength();i<j;i++){
		    		Integer ver = hostei.getEiversion();//最新版本号
		    		Node node = nodes.item(i);
		    		if(node.getNodeType()==Node.ELEMENT_NODE && "DATE".equals(node.getNodeName())){
		    			//取得登记日期
		    			indate = node.getTextContent();
		    		}else if(node.getNodeType()==Node.ELEMENT_NODE && "RELATION".equals(node.getNodeName().toUpperCase())){
		    			NamedNodeMap nodemap = node.getAttributes();
		    			NodeList relation_nodes = node.getChildNodes();//from,to
		    			String esyscoding_to = nodemap.getNamedItem("esyscoding").getNodeValue().trim();
		    			String ename_to = nodemap.getNamedItem("ename").getNodeValue().trim();
		    			SocRelationTB soctb = new SocRelationTB();
		    			soctb.setSresycoding(esyscoding_to);
		    			soctb.setSrename(ename_to);
		    			soctb.setVersion(Integer.valueOf(ver));//版本号
		    			for(int n=0,m=relation_nodes.getLength();n<m;n++){
		    				Node relation_node = relation_nodes.item(n);
		    				if(relation_node.getNodeType()==Node.ELEMENT_NODE && "FROM".equals(relation_node.getNodeName().toUpperCase())){
			    				soctb.setSreilabel(relation_node.getTextContent());
			    			}else if(relation_node.getNodeType()==Node.ELEMENT_NODE && "TO".equals(relation_node.getNodeName().toUpperCase())){
			    				soctb.setSrpareilabel(relation_node.getTextContent());
			    			}
		    			}
		    			//保存资产关系
		    			this.socRelationBL.registSocRelation(soctb);
		    			
		    		}else if(node.getNodeType()==Node.ELEMENT_NODE  && "ATTR_SELF".equals(node.getNodeName().toUpperCase())){//HOST
		    			
		    			NodeList ei_nodes = node.getChildNodes();
		    			
		    			if(ei_nodes!=null && ei_nodes.getLength()>0){
		    				for(int a=0,b=ei_nodes.getLength();a<b;a++){
		    					Node einode = ei_nodes.item(a);
		    					if(einode.getNodeType()==Node.ELEMENT_NODE && "ENTITYITEM".equals(einode.getNodeName().toUpperCase())){
		    						NamedNodeMap nodemap = einode.getAttributes();
		    		    			//取得资产信息
		    		    			//查询该资产是否已存在,如不存在则保存，如存在则更新
//		    						String esyscoding = nodemap.getNamedItem("esyscoding").getNodeValue();
//		    				    	String eid = nodemap.getNamedItem("eid").getNodeValue();;
//		    		    			String eilabel = nodemap.getNamedItem("eilabel").getNodeValue().trim();//资产编号
		    		    			String einame = nodemap.getNamedItem("einame").getNodeValue().trim();//资产名称
		    		    			SOC0118Info ei = null;
		    						
	    							
	    							//更新
	    		    				//ver = entityitem.getEiversion()+1;
	    		    				SOC0118TB eitb = (SOC0118TB)SerializationUtils.clone(hostei);
	    		    				eitb.setEiname(einame);
	    		    				eitb.setEiupdtime(nowdate);//更新时间
	    		    				eitb.setEiversion(ver);
	    		    				
	    		    				ei = this.soc0118BL.updateEntityItem(eitb);
		    						

		    		    			if(ei == null){
		    		    				throw new BLException("IGASM0322.E001");
		    		    			}
		    		    			
		    		    			//查找当前版本的属性，并更新
    		    					SOC0107SearchCondImpl cond = new SOC0107SearchCondImpl();
    		    					cond.setEiid(String.valueOf(ei.getEiid()));
    		    					cond.setCiversion(String.valueOf(ver));//属性版本
    		    					List<SOC0107Info>  cilist = this.soc0107BL.searchSOC0107(cond);
		    		    			
		    		    			//取得该资产的属性集合
		    		    			NodeList cinodes = einode.getChildNodes();
		    		    			for(int n=0,m=cinodes.getLength();n<m;n++){
		    		    				Node cinode = cinodes.item(n);
		    		    				if(cinode.getNodeType()==Node.ELEMENT_NODE && "CI".equals(cinode.getNodeName().toUpperCase())){
		    		    					NamedNodeMap ci_nodemap = cinode.getAttributes();
		    		    					NodeList cid_nodes = cinode.getChildNodes();//cname,value
	
		    		    					//boolean ciflag = true;//是否需要保存属性
		    		    					SOC0107TB citb = new SOC0107TB();
		    		    					citb.setEiid(ei.getEiid());
		    		    					citb.setCiupdtime(nowdate);//更新时间
		    		    					citb.setCiversion(ver);//属性版本
		    		    					citb.setEid(ci_nodemap.getNamedItem("eid").getNodeValue());
		        							citb.setEsyscoding(ci_nodemap.getNamedItem("esyscoding").getNodeValue().trim());
		        							citb.setCid(ci_nodemap.getNamedItem("cid").getNodeValue());//CID
		        							for(int x=0,y=cid_nodes.getLength();x<y;x++){
		    		    						Node cid_node = cid_nodes.item(x);
		    		    						//设置属性信息
		    		    						if(cid_node.getNodeType()==Node.ELEMENT_NODE && "VALUE".equals(cid_node.getNodeName().toUpperCase())){
		    		    							citb.setCivalue(cid_node.getTextContent()==null?"":cid_node.getTextContent());
		    		    							//CICURVER为0代表未修改该属性，1代表修改了该属性
		    		    							if(StringUtils.isNotEmpty(cid_node.getTextContent().trim())){
		    		    								citb.setCicurver("1");
		    		    							}else{
		    		    								citb.setCicurver("0");
		    		    							}
		    		    						}	
		    		    					}

		        							for(SOC0107Info config:cilist){
		    		    						if(config.getCid().equals(citb.getCid())){
		    		    							citb.setCiid(config.getCiid());//设置主键
		    		    							//更新属性
				    		    					this.soc0107BL.updateSOC0107(citb);
				    		    					break;
		    		    						}
		    		    					}

		    		    					//保存属性
//		        							if(ciflag){
//		        								this.soc0107BL.registSOC0107(citb);
//		        							}
		    		    					
		    		    				}
		    		    			}
		    					}
		    				}
		    			}

		    		}else if(node.getNodeType()==Node.ELEMENT_NODE){//HBA、VG等
		    			
		    			NodeList ei_nodes = node.getChildNodes();
		    			
		    			if(ei_nodes!=null && ei_nodes.getLength()>0){
		    				for(int a=0,b=ei_nodes.getLength();a<b;a++){
		    					Node einode = ei_nodes.item(a);
		    					if(einode.getNodeType()==Node.ELEMENT_NODE && "ENTITYITEM".equals(einode.getNodeName().toUpperCase())){
		    						NamedNodeMap nodemap = einode.getAttributes();
		    		    			//取得资产信息
		    		    			//查询该资产是否已存在,如不存在则保存，如存在则更新
		    		    			String esyscoding = nodemap.getNamedItem("esyscoding").getNodeValue();
		    				    	String eid = nodemap.getNamedItem("eid").getNodeValue();;
		    		    			String eilabel = nodemap.getNamedItem("eilabel").getNodeValue().trim();//资产编号
		    		    			String einame = nodemap.getNamedItem("einame").getNodeValue().trim();//资产名称
		    		    			SOC0118SearchCondImpl cond = new SOC0118SearchCondImpl();
		    		    			cond.setEilabel(eilabel);
		    		    			List<SOC0118Info> eiList = this.soc0118BL.searchEntityItem(cond);
		    		    			SOC0118Info ei = null;
		    		    			if(eiList!=null && eiList.size()>0){
		    		    				//更新
		    		    				ver = eiList.get(0).getEiversion()+1;
		    		    				SOC0118TB eitb = (SOC0118TB)SerializationUtils.clone(eiList.get(0));
		    		    				eitb.setEiupdtime(nowdate);//更新时间
		    		    				eitb.setEiversion(ver);
		    		    				
		    		    				ei = this.soc0118BL.updateEntityItem(eitb);
		    		    			}else{
		    		    				//保存
		    		    				ver = 1;
		    		    				SOC0118TB eitb = new SOC0118TB();
		    			    			eitb.setEid(eid);
		    			    			eitb.setEiname(einame);//资产名称
		    			    			eitb.setEiorgsyscoding(eiorgsyscoding);//所属机构
		    			    			eitb.setEiinsdate(indate);//登记日
		    			    			eitb.setEiupdtime(nowdate);//更新时间
		    			    			eitb.setEsyscoding(esyscoding.trim());//资产模型层次码
		    			    			eitb.setEilabel(eilabel);//资产编号
		    			    			eitb.setEiuserid(eiuserid);//登记人ID
		    			    			eitb.setEiusername(eiusername);//登记人姓名
		    			    			if(esyscoding!=null && esyscoding.length()>=6 && "999001".equals(esyscoding.substring(0, 6))){
		    			    				eitb.setEistatus("N");
		    							}else{
		    								eitb.setEistatus("");//EISTATUS 
		    							}
		    			    			eitb.setEiversion(ver);

		    			    			ei = this.soc0118BL.registEntityItem(eitb);
		    		    			}
		    		    			if(ei == null){
		    		    				throw new BLException("IGASM0322.E001");
		    		    			}
		    		    			//取得该资产的属性集合
		    		    			NodeList cinodes = einode.getChildNodes();
		    		    			for(int n=0,m=cinodes.getLength();n<m;n++){
		    		    				Node cinode = cinodes.item(n);
		    		    				if(cinode.getNodeType()==Node.ELEMENT_NODE && "CI".equals(cinode.getNodeName().toUpperCase())){
		    		    					NamedNodeMap ci_nodemap = cinode.getAttributes();
		    		    					NodeList cid_nodes = cinode.getChildNodes();//cname,value

		    		    					SOC0107TB citb = new SOC0107TB();
		    		    					citb.setEiid(ei.getEiid());
		    		    					citb.setCiupdtime(nowdate);//更新时间
		    		    					citb.setCiversion(ver);//属性版本
		    		    					citb.setEid(ci_nodemap.getNamedItem("eid").getNodeValue());
		        							citb.setEsyscoding(ci_nodemap.getNamedItem("esyscoding").getNodeValue().trim());
		        							citb.setCid(ci_nodemap.getNamedItem("cid").getNodeValue());//CID
		    		    					for(int x=0,y=cid_nodes.getLength();x<y;x++){
		    		    						Node cid_node = cid_nodes.item(x);
		    		    						//设置属性信息
		    		    						if(cid_node.getNodeType()==Node.ELEMENT_NODE && "VALUE".equals(cid_node.getNodeName().toUpperCase())){
		    		    							citb.setCivalue(cid_node.getTextContent()==null?"":cid_node.getTextContent());
		    		    							//CICURVER为0代表未修改该属性，1代表修改了该属性
		    		    							if(StringUtils.isNotEmpty(cid_node.getTextContent().trim())){
		    		    								citb.setCicurver("1");
		    		    							}else{
		    		    								citb.setCicurver("0");
		    		    							}
		    		    						}	
		    		    					}
		    		    					//保存属性
		    		    					this.soc0107BL.registSOC0107(citb);
		    		    				}
		    		    			}
		    					}
		    				}
		    			}
		    			
		    			
		    			
		    		}
		    		
		    	}
		    	
		    }
		}catch(Exception e){
			e.printStackTrace();
			log.debug(e.getCause());
			throw new BLException("IGASM0322.E002");
		}finally{
			return result;
		}
	}


	/**
	 *设备信息修改处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO updateEntityItem(IGCIM01DTO dto) throws BLException {
		
		log.debug("========设备信息编辑画面初期显示处理开始========");
		
		IGCIM0108Form form = dto.getIgcim0108Form();
		if(!form.getEilabel().equals(form.getEilabelbak())){
			this.soc0118BL.checkNotExistEntityItem(form.getEilabel());
		}
		this.soc0118BL.updateEntityItem(form);
		dto.addMessage(new ActionMessage("IGCO10000.I005",resources.getMessage(dto.getLocale(),"message.IGCIM01BLImpl.001")));
		log.debug("========设备信息编辑画面初期显示处理终了========");
		return dto;
	}


	/**
	 * 设备关系登记处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO insertEntityItemRelationAction(IGCIM01DTO dto) throws BLException{
		log.debug("========设备关系登记处理开始========");
		
		IGCIM0107Form form = dto.getIgcim0107Form();
		
		//设备ID（子）取得
		SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
		
		cond.setElabel(form.getElabel());
		cond.setEilabel(form.getEilabel());
		
		List<SOC0124Info> entityItemVWList = this.soc0118BL.searchEntityItemVW(cond, 0, 0);
		
		if ( entityItemVWList==null || entityItemVWList.size() == 0 ) {
			try {
				throw new BLException("IGCO10000.E004",resources.getMessage(dto.getLocale(),"message.IGCIM01BLImpl.010")
						+ form.getElabel() + resources.getMessage(dto.getLocale(),"message.IGCIM01BLImpl.011") 
						+ form.getEilabel() + resources.getMessage(dto.getLocale(),"message.IGCIM01BLImpl.012"));
			} catch (BLException e) {
				//
				e.printStackTrace();
			}
		}
		
		form.setCldeiid(entityItemVWList.get(0).getEiid());
		form.setCldeid(entityItemVWList.get(0).getEid());
		
		//设备ID（父）和（子）检测
		if (form.getPareiid().intValue() == form.getCldeiid().intValue()) {
			//设备ID（父）= （子）
			try {
				throw new BLException(BLErrorType.ENTITY_ITEM_RELATION_ERROR,
						"IGCO10000.E012",resources.getMessage(dto.getLocale(),"message.IGCIM01BLImpl.004"));
			} catch (BLException e) {
				//
				e.printStackTrace();
			}
		}
		
		//更新时间设定
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

		form.setEirupdtime(datetime);
		form.setCldsmallversion(entityItemVWList.get(0).getEismallversion());
		form.setCldversion(entityItemVWList.get(0).getEiversion());
		
		//资产关系登记      20120731 add 重复关系验证
		SOC0119SearchCondImpl condeir =new SOC0119SearchCondImpl();
		condeir.setPareiid(Integer.parseInt(form.getPareiid().toString()));
		condeir.setCldeiid(form.getCldeiid());
		condeir.setEirrelationcode(form.getEirrelationcode());
		condeir.setDeleteflag("0");
		List<SOC0119Info> list_eir=this.soc0119BL.searchEntityItemRelation(condeir);
		condeir =new SOC0119SearchCondImpl();
		condeir.setCldeiid(form.getPareiid());
		condeir.setPareiid(Integer.parseInt(form.getCldeiid().toString()));
		condeir.setEirrelationcode(form.getEirrelationcode());
		condeir.setDeleteflag("0");
		List<SOC0119Info> list_eirCld=this.soc0119BL.searchEntityItemRelation(condeir);
		if(list_eir.size()>0||list_eirCld.size()>0){
				throw new BLException(BLErrorType.ENTITY_ITEM_RELATION_ERROR,"IGASM0307.E001",resources.getMessage(dto.getLocale(),"message.IGCIM01BLImpl.020"));
		}
		SOC0119Info ret = null;
		try {
			ret = this.soc0119BL.registEntityItemRelation(dto.getIgcim0107Form());
		} catch (BLException e) {
			//
			e.printStackTrace();
		}
		
		dto.setEntityItemRelation(ret);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", resources.getMessage(dto.getLocale(),"message.IGCIM01BLImpl.013")) );
		
		log.debug("========设备关系登记处理终了========");
		return dto;
	}


	/**
	 * 设备关系变更处理处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO updateEntityItemRelationAction(IGCIM01DTO dto) {
		log.debug("========设备关系变更处理处理开始========");
		IGCIM0107Form form = dto.getIgcim0107Form();

		//更新时间设定
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

		form.setEirupdtime(datetime);
		
		try {
			this.soc0119BL.updateEntityItemRelation(form);
		} catch (BLException e) {
			//
			e.printStackTrace();
		}

		dto.addMessage(new ActionMessage( "IGCO10000.I005", resources.getMessage(dto.getLocale(),"message.IGASM03BLImpl.009")) );

		log.debug("========设备关系变更处理处理终了========");
		return dto;
	}
	//add from asm08blimpl
	/**
	 * 应用信息查询处理
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO searchEntityItemActionApp(IGCIM01DTO dto) throws BLException {

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
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO insertEntityItemActionApp(IGCIM01DTO dto) throws BLException {
		log.debug("========应用信息登记处理开始========");
		//输入Form取得
		IGCIM0122Form form = dto.getIgasm0802Form();
		
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
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.001")) );

		log.debug("========应用信息登记处理终了========");
		return dto;
	}

	/**
	 * 应用信息删除处理
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO deleteEntityItemActionApp(IGCIM01DTO dto) throws BLException {
		log.debug("========应用信息删除处理开始========");
		
		for( int i=0;i<dto.getDeleteEntityItem().length;i++ ){
			String eiid = dto.getDeleteEntityItem()[i];
			
			//删除前删除对象应用确认
			SOC0118Info entityItem = this.soc0118BL.searchEntityItemByKey(Integer.parseInt(eiid));
			
			if (entityItem == null){
				throw new BLException("IGCO10000.E004",resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.002"));
			}

			//删除链路
			this.soc0114BL.delByEiid(entityItem.getEiid());
			//删除关系
			this.soc0119BL.delByEiid(entityItem.getEiid());
			//应用删除
			this.soc0118BL.deleteEntityItem(entityItem);
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I006",resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.003")));

		log.debug("========应用信息删除处理终了========");
		return dto;
	}

	/**
	 * 应用配置信息编辑画面初期化处理
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO initIGCIM0124Action(IGCIM01DTO dto) throws BLException {

		log.debug("========应用配置信息编辑画面初期化处理开始========");
		
		IGCIM0124Form form = dto.getIgasm0804Form();
		
		//应用信息检索
//		EntityItemVWInfo entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(
//				Integer.parseInt(form.getEiid()));
		//以前查视图，考虑到方法下面与页面只用到2个表内容，只查出2个表内容，然后拼成视图对象. _ylq
		if (StringUtils.isEmpty(form.getEiid())) {
			return dto;
		}
		SOC0118Info entityItemInfo=soc0118BL.searchEntityItemByKey(Integer.parseInt(form.getEiid()));
		SOC0117Info entity=soc0117BL.searchEntityByKey(entityItemInfo.getEid());
		SOC0124VW entityItemVWInfo=new SOC0124VW();
		entityItemVWInfo.setEname(entity.getEname());
		entityItemVWInfo.setEilabel(entityItemInfo.getEilabel());
		entityItemVWInfo.setEiname(entityItemInfo.getEiname());
		entityItemVWInfo.setEidesc(entityItemInfo.getEidesc());
		entityItemVWInfo.setEistatus(entityItemInfo.getEistatus());
		entityItemVWInfo.setEiusername(entityItemInfo.getEiusername());
		entityItemVWInfo.setEiinsdate(entityItemInfo.getEiinsdate());
		entityItemVWInfo.setEiupdtime(entityItemInfo.getEiupdtime());
		entityItemVWInfo.setEsyscoding(entityItemInfo.getEsyscoding());
		entityItemVWInfo.setEiorgsyscoding(entityItemInfo.getEiorgsyscoding());
		entityItemVWInfo.setEiversion(entityItemInfo.getEiversion());
		entityItemVWInfo.setEismallversion(entityItemInfo.getEismallversion());
		entityItemVWInfo.setEid(entityItemInfo.getEid());
		entityItemVWInfo.setEiid(entityItemInfo.getEiid());
		entityItemVWInfo.setEirootmark(entityItemInfo.getEirootmark());
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004",resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.004"));
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
		
		//获取历史版本更新时间
		dto.setConfigItemVersionTime(this.soc0118BL.searchVersionUpdateTime(Integer.parseInt(form.getEiid())));
		
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
		String[] entityItemCivalue = new String[totalCount];
		//存放旧版本值
		String[] civalue_bak = new String[totalCount];
		Map<String,List<SOC0129Info>> map = new LinkedHashMap<String,List<SOC0129Info>>();
		int i = 0;
		int j = 0;
		List<String> strlist = new ArrayList<String>();
		for(SOC0129Info e : configItemVWInfoList){
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
		for(String str : strlist){
			for(SOC0129Info e : map.get(str)){
				//显示是资产名称，实际存值是资产名称(资产ID)
				if("4".equals(e.getCattach()) && StringUtils.isNotEmpty(e.getCivalue())){
					civalue[i] = e.getCivalue().substring(0, e.getCivalue().lastIndexOf("("));
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
		form.setCivalue_bak(civalue_bak);
		dto.setConfigItemVWInfoMap(map);
//		dto.addMessage(new ActionMessage("IGCO10000.I007",totalCount));


		
		log.debug("========应用配置信息编辑画面初期化处理终了========");
		return dto;
	}
	
	/**
	 * 应用配置信息编辑画面初期化处理
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO initIGCIM0148Action(IGCIM01DTO dto) throws BLException {

		log.debug("========应用配置信息编辑画面初期化处理开始========");
		
		IGCIM0148Form form = dto.getIgcim0148Form();
		
		//应用信息检索
//		EntityItemVWInfo entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(
//				Integer.parseInt(form.getEiid()));
		//以前查视图，考虑到方法下面与页面只用到2个表内容，只查出2个表内容，然后拼成视图对象. _ylq
		if (StringUtils.isEmpty(form.getEiid())) {
			return dto;
		}
		SOC0118Info entityItemInfo=soc0118BL.searchEntityItemByKey(Integer.parseInt(form.getEiid()));
		SOC0117Info entity=soc0117BL.searchEntityByKey(entityItemInfo.getEid());
		SOC0124VW entityItemVWInfo=new SOC0124VW();
		entityItemVWInfo.setEname(entity.getEname());
		entityItemVWInfo.setEilabel(entityItemInfo.getEilabel());
		entityItemVWInfo.setEiname(entityItemInfo.getEiname());
		entityItemVWInfo.setEidesc(entityItemInfo.getEidesc());
		entityItemVWInfo.setEistatus(entityItemInfo.getEistatus());
		entityItemVWInfo.setEiusername(entityItemInfo.getEiusername());
		entityItemVWInfo.setEiinsdate(entityItemInfo.getEiinsdate());
		entityItemVWInfo.setEiupdtime(entityItemInfo.getEiupdtime());
		entityItemVWInfo.setEsyscoding(entityItemInfo.getEsyscoding());
		entityItemVWInfo.setEiorgsyscoding(entityItemInfo.getEiorgsyscoding());
		entityItemVWInfo.setEiversion(entityItemInfo.getEiversion());
		entityItemVWInfo.setEismallversion(entityItemInfo.getEismallversion());
		entityItemVWInfo.setEid(entityItemInfo.getEid());
		entityItemVWInfo.setEiid(entityItemInfo.getEiid());
		entityItemVWInfo.setEirootmark(entityItemInfo.getEirootmark());
		entityItemVWInfo.setEmodeltype(entity.getEmodeltype());
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004",resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.004"));
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
		
		//获取历史版本更新时间
		dto.setConfigItemVersionTime(this.soc0118BL.searchVersionUpdateTime(Integer.parseInt(form.getEiid())));
		
		//判断登陆用户是否有查看该资产配置信息的权限
		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(), entityItemVWInfo);

		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}else{
			dto.setFlag(flag);
		}
		
		//是否可继承标识，使用entity表中预留字段EKEY2, 0代表继承，1代表不继承
		String ekey2 = entity.getEkey2();
		form.setEkey2(ekey2);
		
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
		String[] entityItemCivalue = new String[totalCount];
		//存放旧版本值
		String[] civalue_bak = new String[totalCount];
		Map<String,List<SOC0129Info>> map = new LinkedHashMap<String,List<SOC0129Info>>();
		int i = 0;
		int j = 0;
		List<String> strlist = new ArrayList<String>();
		for(SOC0129Info e : configItemVWInfoList){
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
		for(String str : strlist){
			for(SOC0129Info e : map.get(str)){
				//显示是资产名称，实际存值是资产名称(资产ID)
				if("4".equals(e.getCattach()) && StringUtils.isNotEmpty(e.getCivalue())){
					civalue[i] = e.getCivalue().substring(0, e.getCivalue().lastIndexOf("("));
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
		form.setCivalue_bak(civalue_bak);
		dto.setConfigItemVWInfoMap(map);
//		dto.addMessage(new ActionMessage("IGCO10000.I007",totalCount));


		
		log.debug("========应用配置信息编辑画面初期化处理终了========");
		return dto;
	}
	
	/**
	 * 应用配置信息编辑处理
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public IGCIM01DTO editEntityItemActionApp(IGCIM01DTO dto) throws BLException, FileNotFoundException, IOException {
		log.debug("========应用配置信息编辑处理开始========");
		//版本号生成
		IGCIM0124Form form = dto.getIgasm0804Form();
		
		int version = form.getEiversion() + 1;
		
		//应用基本信息更新
		SOC0118TB entityItem = (SOC0118TB) this.soc0118BL.searchEntityItemByKey(Integer.parseInt(form.getEiid()));

		if(version - 1 != entityItem.getEiversion()) {
			throw new BLException("IGCO00000.E004");
		}
		//资产关系信息版本升级处理
		this.soc0119BL.upgradeEntityItemRelation(entityItem.getEiid(), entityItem.getEiversion(), entityItem.getEismallversion(),
				version, 0);
		
		//应用状态
//		entityItem.setEistatus(form.getEistatus());
		//应用版本
		entityItem.setEiversion(version);
		
		//应用说明
		entityItem.setEidesc(form.getEidesc());

		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		
		//更新时间
		entityItem.setEiname(form.getEiname());
		entityItem.setEidesc(form.getEidesc());
		entityItem.setEiupdtime(datetime);
		//调用更新BL
		this.soc0118BL.updateEntityItem(entityItem);
		
		
		SOC0126SearchCondImpl eiDomainCond = new SOC0126SearchCondImpl();
		eiDomainCond.setEiname(entityItem.getEiname());
		List<SOC0126Info> eiDomailMaxList = soc0126BL.searchEiDomainDetailAllVW(eiDomainCond,0,0);
		
		if(eiDomailMaxList!=null && eiDomailMaxList.size()>0){
			for(SOC0126Info eiDomainBean:eiDomailMaxList){
				SOC0112PK pk = new SOC0112PK();
				pk.setEiddid(eiDomainBean.getEiddid());
				pk.setEiddversion(eiDomainBean.getEiddversion());
				pk.setEiImportversion(eiDomainBean.getEiImportversion());
				pk.setEiname(eiDomainBean.getEiname());;
				SOC0112Info eiInfo = soc0112BL.searchEiDomainDetailByPK(pk);
				SOC0112TB eiddTB = (SOC0112TB)SerializationUtils.clone(eiInfo);
				eiddTB.setEiImportversion(version);
				soc0112BL.deleteEiDomainDetailByPK(pk);
				soc0112BL.registEiDomainDetail(eiddTB);
			}
		}
		

		
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
						e.setEirdesc(resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.005")+cname+
								resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.006"));
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
						//校验关系是否存在
						SOC0119SearchCondImpl cond = new SOC0119SearchCondImpl();
						cond.setEirinfo(entityItem.getEiid()+"_"+form.getCiid()[i]+"_"+ei.getEiid());
						cond.setEirstatus("C");
						cond.setParversion(Integer.parseInt(entityItem.getEiversion().toString()));
						cond.setParsmallversion(Integer.parseInt(entityItem.getEismallversion().toString()));
						cond.setDeleteflag("0");
						List<SOC0119Info> eirlist = this.soc0119BL.searchEntityItemRelation(cond, 0, 0);
						if(eirlist.isEmpty()){
							//删除原来已有的关系
							SOC0119SearchCondImpl eircond = new SOC0119SearchCondImpl();
							eircond.setEirinfo(entityItem.getEiid()+"_"+form.getCiid()[i]+"_");
							eircond.setEirstatus("C");
							eircond.setParversion(Integer.parseInt(entityItem.getEiversion().toString()));
							eircond.setParsmallversion(Integer.parseInt(entityItem.getEismallversion().toString()));
							eircond.setDeleteflag("0");
							List<SOC0119Info> eir = this.soc0119BL.searchEntityItemRelation(eircond, 0, 0);
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
							e.setEirdesc(resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.005")+cname+
									resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.006"));
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
						eircond.setParversion(Integer.parseInt(entityItem.getEiversion().toString()));
						eircond.setParsmallversion(Integer.parseInt(entityItem.getEismallversion().toString()));
						eircond.setDeleteflag("0");
						List<SOC0119Info> eir = this.soc0119BL.searchEntityItemRelation(eircond, 0, 0);
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
	
		//调用阜新链路分析
		Properties properties = getProperties();
		String importBatName = properties.getProperty("MANUALSNAPSHOTAPP_PATH");
		String[] cmd = new String[5];
		cmd[0] = "cmd";
		cmd[1] = "/c";
		cmd[2] = "start";
		cmd[3] = " ";
		try {
			cmd[4] = importBatName;
		    //调用bat文件执行
			if("true".equals(properties.getProperty("MANUALSNAPSHOTAPP_FLAG"))){
				java.lang.Runtime.getRuntime().exec(cmd);
			}
		} catch (IOException e) {
			log.error("调动链路分析异常", e);
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I005",resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.007")));
		
		log.debug("========应用配置信息编辑处理终了========");
		
		return dto;
	}
	
	private Properties getProperties() throws BLException {
		//CI导入应用资源文件
		Properties properties = null;
		//输入流
		FileInputStream inputFile = null;
		//加载属性文件
		try {
			properties = new Properties();
			inputFile = new FileInputStream(ResourceUtility.getString("CI_IMPORT_FILE_PATH"));
			properties.load(inputFile);
		} catch (FileNotFoundException e) {
			log.error("CI导入应用资源文件读取错误", e);
			throw new BLException("IGCIM0201.E001");
		} catch (IOException e) {
			log.error("CI导入应用资源文件读取错误", e);
			throw new BLException("IGCIM0201.E001");
		} finally {
			if(inputFile != null) {
				try {
					inputFile.close();
				} catch (IOException e) {
					log.error("CI导入应用资源文件读取错误", e);
					throw new BLException("IGCIM0201.E001");
				}
			}
		}
		return properties;
	}
	/**
	 * 应用配置信息编辑处理
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public IGCIM01DTO editIGCIM0148ActionApp(IGCIM01DTO dto) throws BLException, FileNotFoundException, IOException {
		log.debug("========设备配置信息编辑处理开始========");
		//版本号生成
		IGCIM0148Form form = dto.getIgcim0148Form();
		
		//配置模型升级小版本，其余升级大版本
		int version = form.getEiversion();//大版本
		int smallversion = form.getEismallversion();//小版本
		String fileversion = version + "";//附件版本
		
		if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(form.getEmodeltype())) {
			smallversion++;
			fileversion = version + "_" + smallversion;
		} else {
			version++;
		}
		
		//设备基本信息更新
		SOC0118TB entityItem = (SOC0118TB) this.soc0118BL.searchEntityItemByKey(Integer.parseInt(form.getEiid()));

		//判断数据是否已经被保存
		if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(form.getEmodeltype())) {
			if(smallversion - 1 != entityItem.getEismallversion()) {
				throw new BLException("IGCO00000.E004");
			}
		} else {
			if(version - 1 != entityItem.getEiversion()) {
				throw new BLException("IGCO00000.E004");
			}
		}
		
		//资产关系信息版本升级处理
		this.soc0119BL.upgradeEntityItemRelation(entityItem.getEiid(), entityItem.getEiversion(), entityItem.getEismallversion(),
				version, smallversion);
		
		//资产所属关系信息版本升级处理
		this.soc0110BL.upgradeEntityItemRelation(entityItem.getEiid(), entityItem.getEiversion(), entityItem.getEismallversion(),
				version, smallversion);
		
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
		
		//设备名称
		entityItem.setEiname(form.getEiname());
		
		SOC0118Info hostei = this.soc0118BL.updateEntityItem(entityItem);
		
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
				configItem.setEid(form.getEid()[i]);
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
						e.setEirdesc(resources.getMessage(dto.getLocale(),"message.IGCIM01BLImpl.005")+cname+
								resources.getMessage(dto.getLocale(),"message.IGACIM01BLImpl.006"));
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
						//校验关系是否存在
						SOC0119SearchCondImpl cond = new SOC0119SearchCondImpl();
						cond.setEirinfo(entityItem.getEiid()+"_"+form.getCiid()[i]+"_"+ei.getEiid());
						cond.setEirstatus("C");
						cond.setParversion(Integer.parseInt(entityItem.getEiversion().toString()));
						cond.setParsmallversion(Integer.parseInt(entityItem.getEismallversion().toString()));
						cond.setDeleteflag("0");
						List<SOC0119Info> eirlist = this.soc0119BL.searchEntityItemRelation(cond, 0, 0);
						if(eirlist.isEmpty()){
							//删除原来已有的关系
							SOC0119SearchCondImpl eircond = new SOC0119SearchCondImpl();
							eircond.setEirinfo(entityItem.getEiid()+"_"+form.getCiid()[i]+"_");
							eircond.setEirstatus("C");
							eircond.setParversion(Integer.parseInt(entityItem.getEiversion().toString()));
							eircond.setParsmallversion(Integer.parseInt(entityItem.getEismallversion().toString()));
							eircond.setDeleteflag("0");
							List<SOC0119Info> eir = this.soc0119BL.searchEntityItemRelation(eircond, 0, 0);
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
							e.setEirdesc(resources.getMessage(dto.getLocale(),"message.IGCIM01BLImpl.005")+cname+
									resources.getMessage(dto.getLocale(),"message.IGCIM01BLImpl.006"));
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
						eircond.setParversion(Integer.parseInt(entityItem.getEiversion().toString()));
						eircond.setParsmallversion(Integer.parseInt(entityItem.getEismallversion().toString()));
						eircond.setDeleteflag("0");
						List<SOC0119Info> eir = this.soc0119BL.searchEntityItemRelation(eircond, 0, 0);
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
						String fileType = "";
						String sFileName = file.getFileName();
						int point = sFileName.lastIndexOf(".");
						if (point != -1) {
							fileType = sFileName.substring(point);
							fileName.append(sFileName.substring(0, point));
						}

						//文件扩展名
						fileName.append(fileType);
						fileName.append("_" + fileversion);
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
				saveXML(new File(rootPath+"XML"+File.separator+"asm"+File.separator+String.valueOf(configItemXML.getEiid())+File.separator+fileNameXML),dto.getUser(),hostei);
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
		
		dto.addMessage(new ActionMessage("IGCO10000.I005",resources.getMessage(dto.getLocale(),"message.IGCIM01BLImpl.007")));
		
		log.debug("========设备配置信息编辑处理终了========");
		
		return dto;
	}

	/**
	 * 应用配置信息历史记录画面初期化处理
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO initIGCIM0125Action(IGCIM01DTO dto) throws BLException {
		log.debug("========应用配置信息历史记录画面初期化处理开始========");
		
		//应用信息检索
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(
				Integer.parseInt(dto.getIgasm0805Form().getEiid()));
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004",resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.004"));
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
		if ( entityItemVWInfo.getEiversion() == 0 ) {
			dto.addMessage(new ActionMessage("IGASM0205.W001"));
		}
		
		dto.setEntityItemVWInfo(entityItemVWInfo);
		
		if (StringUtils.isEmpty(dto.getIgasm0805Form().getCiversion())) {
			dto.getIgasm0805Form().setCiversion(entityItemVWInfo.getEiversion()+"");
		}
		//获取历史版本更新时间
		dto.setConfigItemVersionTime(this.soc0118BL.searchVersionUpdateTime(Integer.parseInt(dto.getIgasm0805Form().getEiid())));
		
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
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO initIGCIM0126Action(IGCIM01DTO dto) throws BLException {
		log.debug("========应用关系管理画面初期化处理开始========");
		
		//应用信息检索
//		EntityItemVWInfo entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(
//				Integer.parseInt(dto.getIgasm0806Form().getEiid()));
		//以前查视图，考虑到方法下面与页面只用到2个表内容，只查出2个表内容，然后拼成视图对象. _ylq
		String eiid = dto.getIgasm0806Form().getEiid();
		if (StringUtils.isEmpty(eiid)) {
			return dto;
		}
		SOC0118Info entityItemInfo=soc0118BL.searchEntityItemByKey(Integer.parseInt(dto.getIgasm0806Form().getEiid()));
		SOC0117Info entity=soc0117BL.searchEntityByKey(entityItemInfo.getEid());
		SOC0124VW entityItemVWInfo=new SOC0124VW();
		entityItemVWInfo.setEname(entity.getEname());
		entityItemVWInfo.setEilabel(entityItemInfo.getEilabel());
		entityItemVWInfo.setEiname(entityItemInfo.getEiname());
		entityItemVWInfo.setEidesc(entityItemInfo.getEidesc());
		entityItemVWInfo.setEistatus(entityItemInfo.getEistatus());
		entityItemVWInfo.setEiusername(entityItemInfo.getEiusername());
		entityItemVWInfo.setEiinsdate(entityItemInfo.getEiinsdate());
		entityItemVWInfo.setEiupdtime(entityItemInfo.getEiupdtime());
		entityItemVWInfo.setEiorgsyscoding(entityItemInfo.getEiorgsyscoding());
		entityItemVWInfo.setEiversion(entityItemInfo.getEiversion());
		entityItemVWInfo.setEismallversion(entityItemInfo.getEismallversion());
		entityItemVWInfo.setEid(entityItemInfo.getEid());
		entityItemVWInfo.setEiid(entityItemInfo.getEiid());
		entityItemVWInfo.setEirootmark(entityItemInfo.getEirootmark());
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004",resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.004"));
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
		
		parcond.setPareiid(Integer.parseInt(dto.getIgasm0806Form().getEiid()));
		parcond.setParversion(Integer.parseInt(entityItemVWInfo.getEiversion().toString()));
		parcond.setParsmallversion(Integer.parseInt(entityItemVWInfo.getEismallversion().toString()));
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
				this.soc0119BL.searchMaxEntityItemRelation(parcond);
			dto.setParCount(parEntityItemRelationList.size());
			for(SOC0119Info e : parEntityItemRelationList){
				String eirrelation = e.getEirrelation();
				//密码关系不显示
				if (EntityItemKeyWords.PASSWORD_Relation.equals(eirrelation)) {
					continue;
				}
				String key = e.getEirrelationcode().split("-")[0];
				String eirrelationcode = e.getEirrelationcode();
				String ecategory = e.getParEntityItemVW().getEcategory();
				if(!"-".equals(eirrelationcode.replaceAll(ecategory, ""))){
					key = eirrelationcode.replaceAll(ecategory, "").replaceAll("-", "");
				}
				if(!"014001".equals(key)){
					if(!parmap.containsKey(key)){
						parmap.put(key, new ArrayList<SOC0119Info>());
					}
					((SOC0119TB)e).setParflag("0");
					parmap.get(key).add(e);
				}
					
			}
		}
		
		//逆向关联关系检索
		//关联关系检索
		SOC0119SearchCondImpl cldcond = new SOC0119SearchCondImpl();
		
		cldcond.setCldeiid(Integer.parseInt(dto.getIgasm0806Form().getEiid()));
		cldcond.setCldversion(entityItemVWInfo.getEiversion());
		cldcond.setCldsmallversion(entityItemVWInfo.getEismallversion());
		cldcond.setDeleteflag("0");
		
		//应用关系信息查询件数取得 
		totalCount = this.soc0119BL.getEntityItemRelationSearchCount(cldcond);
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========应用关系信息查询数据件数过多========");
			//应用关系信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//应用关系信息全件检索
		List<SOC0119Info> cldEntityItemRelationList = 
			this.soc0119BL.searchMaxEntityItemRelation(
					cldcond);
		
		dto.setParCount(dto.getParCount()+cldEntityItemRelationList.size());
//		dto.addMessage(new ActionMessage("IGCO10000.I007",dto.getParCount()));
		for(SOC0119Info e : cldEntityItemRelationList){
			String eirrelation = e.getEirrelation();
			//密码关系不显示
			if (EntityItemKeyWords.PASSWORD_Relation.equals(eirrelation)) {
				continue;
			}
			String key = e.getEirrelationcode().split("-")[0];
			String eirrelationcode = e.getEirrelationcode();
			String ecategory = e.getCldEntityItemVW().getEcategory();
			if(!"-".equals(eirrelationcode.replaceAll(ecategory, ""))){
				key = eirrelationcode.replaceAll(ecategory, "").replaceAll("-", "");
			}
			if(!"014001".equals(key)){
				if(!parmap.containsKey(key)){
					parmap.put(key, new ArrayList<SOC0119Info>());
				}
				((SOC0119TB)e).setParflag("1");
				parmap.get(key).add(e);
			}
		}
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
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO deleteEntityItemRelationActionApp(IGCIM01DTO dto) throws BLException {
		log.debug("========应用关系删除处理开始========");
		
		for( int i=0;i<dto.getDeleteEntityItemRelation().length;i++ ){
			String eirid = dto.getDeleteEntityItemRelation()[i];
			
			SOC0119Info entityItemRelation = 
				this.soc0119BL.searchEntityItemRelationByKey(Integer.parseInt(eirid));
			
			if (entityItemRelation == null){
				throw new BLException("IGCO10000.E004",resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.008"));
			}
			//baiyf 2011/12/23  start
			SOC0118SearchCondImpl entityItemcond=new SOC0118SearchCondImpl();
			entityItemcond.setEid("115");
			entityItemcond.setEirootmark(entityItemRelation.getCldeiid());
			//该主机下的FS信息
			List<SOC0118Info> entityItemList=this.soc0118BL.searchEntityItem(entityItemcond);
			SOC0119SearchCondImpl cond=new SOC0119SearchCondImpl();
			cond.setPareiid(entityItemRelation.getPareiid());
			cond.setDeleteflag("0");
			//该应用的所有关系信息
			List<SOC0119Info> entityItemRelationList=this.soc0119BL.searchEntityItemRelation(cond);
			if(entityItemRelationList!=null&&entityItemRelationList.size()>0){
				for(SOC0119Info entityItemRelationInfo:entityItemRelationList){
					//删除该应用与该主机的所有关系（逻辑删除）
					if(entityItemRelationInfo.getCldeiid().equals(entityItemRelation.getCldeiid())){
						this.soc0119BL.deleteEntityItemRelation(entityItemRelationInfo);
					}
					//删除该应用与该主机下FS的所有关系（逻辑删除）
					if(entityItemList!=null&&entityItemList.size()>0){
						for(SOC0118Info entityItemInfo:entityItemList){
							if(entityItemInfo.getEiid().equals(entityItemRelationInfo.getCldeiid())){
								this.soc0119BL.deleteEntityItemRelation(entityItemRelationInfo);
							}
						}
					}
				}
			}
			//baiyf 2011/12/23  end
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I006",resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.009")));

		log.debug("========应用关系删除处理终了========");
		return dto;
	}

	/**
	 * 应用关系登记处理
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO insertEntityItemRelationActionApp(IGCIM01DTO dto) throws BLException {
		log.debug("========应用关系登记处理开始========");
		
		IGCIM0127Form form = dto.getIgasm0807Form();
		
		//应用ID（子）取得
		SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
		
		cond.setElabel(form.getElabel());
		cond.setEilabel(form.getEilabel());
		
		List<SOC0124Info> entityItemVWList = this.soc0118BL.searchEntityItemVW(cond, 0, 0);
		
		if ( entityItemVWList==null || entityItemVWList.size() == 0 ) {
			throw new BLException("IGCO10000.E004",resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.010")
					+ form.getElabel() + resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.011") 
					+ form.getEilabel() + resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.012"));
		}
		
		form.setCldeiid(entityItemVWList.get(0).getEiid());
		form.setCldeid(entityItemVWList.get(0).getEid());
		form.setCldversion(entityItemVWList.get(0).getEiversion());
		form.setCldsmallversion(entityItemVWList.get(0).getEismallversion());
		//应用ID（父）和（子）检测
		if (form.getPareiid().intValue() == form.getCldeiid().intValue()) {
			//应用ID（父）= （子）
			throw new BLException(BLErrorType.ENTITY_ITEM_RELATION_ERROR,
					"IGCO10000.E012",resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.004"));
		}
		
		//更新时间设定
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

		form.setEirupdtime(datetime);
		
		//资产关系登记      20120731 add 重复关系验证
		SOC0119SearchCondImpl condeir =new SOC0119SearchCondImpl();
		condeir.setPareiid(form.getPareiid());
		condeir.setCldeiid(form.getCldeiid());
		condeir.setEirrelationcode(form.getEirrelationcode());
		condeir.setDeleteflag("0");
		List<SOC0119Info> list_eir=this.soc0119BL.searchEntityItemRelation(condeir);
		condeir =new SOC0119SearchCondImpl();
		condeir.setCldeiid(form.getPareiid());
		condeir.setPareiid(form.getCldeiid());
		condeir.setEirrelationcode(form.getEirrelationcode());
		condeir.setDeleteflag("0");
		List<SOC0119Info> list_eirCld=this.soc0119BL.searchEntityItemRelation(condeir);
		if(list_eir.size()>0||list_eirCld.size()>0){
			throw new BLException(BLErrorType.ENTITY_ITEM_RELATION_ERROR,"IGASM0307.E001",resources.getMessage(dto.getLocale(),"message.IGASM03BLImpl.020"));
		}
		SOC0119Info ret = 
			this.soc0119BL.registEntityItemRelation(dto.getIgasm0807Form());
		//判断是实例时，创建业务系统与DB、业务系统与主机之间的关系
		if("CR030001000002".equals(form.getEirrelation())){
			createEntityItemRelationActionAppToWebServer(form,entityItemVWList.get(0));
			createEntityItemRelationActionAppToHost(form,entityItemVWList.get(0));
		}else if("CR030001000003".equals(form.getEirrelation())){
			createEntityItemRelationActionAppToWEBAPP2(form,entityItemVWList.get(0));
			createEntityItemRelationActionAppToHost(form,entityItemVWList.get(0));
		}
		dto.setEntityItemRelation(ret);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.013")) );
		
		log.debug("========应用关系登记处理终了========");
		return dto;
	}
	
	private void createEntityItemRelationActionAppToWEBAPP2(IGCIM0127Form form,
			SOC0124Info soc0124Info) throws BLException {
		SOC0110SearchCondImpl soc0110Cond=new SOC0110SearchCondImpl();
		soc0110Cond.setBrcldeiid(soc0124Info.getEiid()+"");
		soc0110Cond.setBrcldversion(soc0124Info.getEiversion()+"");
		soc0110Cond.setBrcldsmallversion(soc0124Info.getEismallversion()+"");
		soc0110Cond.setBrassetrelation("CR020004000001");
		List<SOC0110Info> soc0110InfoList=this.soc0110BL.searchEiBelongRelation(soc0110Cond);
		if(soc0110InfoList!=null&&soc0110InfoList.size()>0){
			SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
			List<String> eiidList=new ArrayList<String>();
			eiidList.add(soc0110InfoList.get(0).getBrpareiid()+"");
			cond.setEiidList(eiidList);
			List<SOC0124Info> entityItemVWList = this.soc0118BL.searchEntityItemVW(cond, 0, 0);
			if ( entityItemVWList==null || entityItemVWList.size() == 0 ) {
				throw new BLException("IGCO10000.E004","数据库");
			}
			form.setCldeiid(entityItemVWList.get(0).getEiid());
			form.setCldeid(entityItemVWList.get(0).getEid());
			form.setCldversion(entityItemVWList.get(0).getEiversion());
			form.setCldsmallversion(entityItemVWList.get(0).getEismallversion());
			form.setEirrelation("CR030001000005");
			//更新时间设定
			Date nowDateTime = new Date();
			String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

			form.setEirupdtime(datetime);
			
			//资产关系登记      20120731 add 重复关系验证
			SOC0119SearchCondImpl condeir =new SOC0119SearchCondImpl();
			condeir.setPareiid(form.getPareiid());
			condeir.setCldeiid(form.getCldeiid());
			condeir.setEirrelationcode(form.getEirrelationcode());
			condeir.setDeleteflag("0");
			List<SOC0119Info> list_eir=this.soc0119BL.searchEntityItemRelation(condeir);
			condeir =new SOC0119SearchCondImpl();
			condeir.setCldeiid(form.getPareiid());
			condeir.setPareiid(form.getCldeiid());
			condeir.setEirrelationcode(form.getEirrelationcode());
			condeir.setDeleteflag("0");
			List<SOC0119Info> list_eirCld=this.soc0119BL.searchEntityItemRelation(condeir);
			if(list_eir.size()>0||list_eirCld.size()>0){
			}else{
				this.soc0119BL.registEntityItemRelation(form);
			}
		}
	}
	
	/**
	 * 创建业务系统与主机之间的关系
	 * @param form
	 * @param soc0124Info
	 * @throws BLException
	 */
	public void createEntityItemRelationActionAppToHost(IGCIM0127Form form,SOC0124Info soc0124Info) throws BLException {
		SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
		List<String> eiidList=new ArrayList<String>();
		eiidList.add(soc0124Info.getEirootmark()+"");
		cond.setEiidList(eiidList);
		List<SOC0124Info> entityItemVWList = this.soc0118BL.searchEntityItemVW(cond, 0, 0);
		if ( entityItemVWList==null || entityItemVWList.size() == 0 ) {
			throw new BLException("IGCO10000.E004","主机");
		}
		form.setCldeiid(entityItemVWList.get(0).getEiid());
		form.setCldeid(entityItemVWList.get(0).getEid());
		form.setCldversion(entityItemVWList.get(0).getEiversion());
		form.setCldsmallversion(entityItemVWList.get(0).getEismallversion());
		form.setEirrelation("CR030100010001");
		form.setEirrelationcode("003-001");
		//更新时间设定
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

		form.setEirupdtime(datetime);
		
		//资产关系登记      20120731 add 重复关系验证
		SOC0119SearchCondImpl condeir =new SOC0119SearchCondImpl();
		condeir.setPareiid(form.getPareiid());
		condeir.setCldeiid(form.getCldeiid());
		condeir.setEirrelationcode(form.getEirrelationcode());
		condeir.setDeleteflag("0");
		List<SOC0119Info> list_eir=this.soc0119BL.searchEntityItemRelation(condeir);
		condeir =new SOC0119SearchCondImpl();
		condeir.setCldeiid(form.getPareiid());
		condeir.setPareiid(form.getCldeiid());
		condeir.setEirrelationcode(form.getEirrelationcode());
		condeir.setDeleteflag("0");
		List<SOC0119Info> list_eirCld=this.soc0119BL.searchEntityItemRelation(condeir);
		if(list_eir.size()>0||list_eirCld.size()>0){
		}else{
			this.soc0119BL.registEntityItemRelation(form);
		}
	}
	
	public void createEntityItemRelationActionAppToWebServer(IGCIM0127Form form,SOC0124Info soc0124Info) throws BLException {
		SOC0110SearchCondImpl soc0110Cond=new SOC0110SearchCondImpl();
		soc0110Cond.setBrcldeiid(soc0124Info.getEiid()+"");
		soc0110Cond.setBrcldversion(soc0124Info.getEiversion()+"");
		soc0110Cond.setBrcldsmallversion(soc0124Info.getEismallversion()+"");
		soc0110Cond.setBrassetrelation("CR020002000001");
		List<SOC0110Info> soc0110InfoList=this.soc0110BL.searchEiBelongRelation(soc0110Cond);
		if(soc0110InfoList!=null&&soc0110InfoList.size()>0){
			SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
			List<String> eiidList=new ArrayList<String>();
			eiidList.add(soc0110InfoList.get(0).getBrpareiid()+"");
			cond.setEiidList(eiidList);
			List<SOC0124Info> entityItemVWList = this.soc0118BL.searchEntityItemVW(cond, 0, 0);
			if ( entityItemVWList==null || entityItemVWList.size() == 0 ) {
				throw new BLException("IGCO10000.E004","Web服务器");
			}
			form.setCldeiid(entityItemVWList.get(0).getEiid());
			form.setCldeid(entityItemVWList.get(0).getEid());
			form.setCldversion(entityItemVWList.get(0).getEiversion());
			form.setCldsmallversion(entityItemVWList.get(0).getEismallversion());
			form.setEirrelation("CR030001000004");
			//更新时间设定
			Date nowDateTime = new Date();
			String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

			form.setEirupdtime(datetime);
			
			//资产关系登记      20120731 add 重复关系验证
			SOC0119SearchCondImpl condeir =new SOC0119SearchCondImpl();
			condeir.setPareiid(form.getPareiid());
			condeir.setCldeiid(form.getCldeiid());
			condeir.setEirrelationcode(form.getEirrelationcode());
			condeir.setDeleteflag("0");
			List<SOC0119Info> list_eir=this.soc0119BL.searchEntityItemRelation(condeir);
			condeir =new SOC0119SearchCondImpl();
			condeir.setCldeiid(form.getPareiid());
			condeir.setPareiid(form.getCldeiid());
			condeir.setEirrelationcode(form.getEirrelationcode());
			condeir.setDeleteflag("0");
			List<SOC0119Info> list_eirCld=this.soc0119BL.searchEntityItemRelation(condeir);
			if(list_eir.size()>0||list_eirCld.size()>0){
			}else{
				this.soc0119BL.registEntityItemRelation(form);
			}
			createEntityItemRelationWebToAppServer(form,entityItemVWList.get(0));
		}
	}
	
	public void createEntityItemRelationWebToAppServer(IGCIM0127Form form,SOC0124Info soc0124Info) throws BLException {
		SOC0110SearchCondImpl soc0110Cond=new SOC0110SearchCondImpl();
		soc0110Cond.setBrcldeiid(soc0124Info.getEiid()+"");
		soc0110Cond.setBrcldversion(soc0124Info.getEiversion()+"");
		soc0110Cond.setBrcldsmallversion(soc0124Info.getEismallversion()+"");
		soc0110Cond.setBrassetrelation("CR020001000001");
		List<SOC0110Info> soc0110InfoList=this.soc0110BL.searchEiBelongRelation(soc0110Cond);
		if(soc0110InfoList!=null&&soc0110InfoList.size()>0){
			for(SOC0110Info soc0110Info:soc0110InfoList){
				SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
				List<String> eiidList=new ArrayList<String>();
				eiidList.add(soc0110Info.getBrpareiid()+"");
				cond.setEiidList(eiidList);
				List<SOC0124Info> entityItemVWList = this.soc0118BL.searchEntityItemVW(cond, 0, 0);
				if ( entityItemVWList==null || entityItemVWList.size() == 0 ) {
				}else{
					form.setCldeiid(entityItemVWList.get(0).getEiid());
					form.setCldeid(entityItemVWList.get(0).getEid());
					form.setCldversion(entityItemVWList.get(0).getEiversion());
					form.setCldsmallversion(entityItemVWList.get(0).getEismallversion());
					form.setEirrelation("CR030001000001");
					form.setEirrelationcode("003-002");
					//更新时间设定
					Date nowDateTime = new Date();
					String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

					form.setEirupdtime(datetime);
					
					//资产关系登记      20120731 add 重复关系验证
					SOC0119SearchCondImpl condeir =new SOC0119SearchCondImpl();
					condeir.setPareiid(form.getPareiid());
					condeir.setCldeiid(form.getCldeiid());
					condeir.setEirrelationcode(form.getEirrelationcode());
					condeir.setDeleteflag("0");
					List<SOC0119Info> list_eir=this.soc0119BL.searchEntityItemRelation(condeir);
					condeir =new SOC0119SearchCondImpl();
					condeir.setCldeiid(form.getPareiid());
					condeir.setPareiid(form.getCldeiid());
					condeir.setEirrelationcode(form.getEirrelationcode());
					condeir.setDeleteflag("0");
					List<SOC0119Info> list_eirCld=this.soc0119BL.searchEntityItemRelation(condeir);
					if(list_eir.size()>0||list_eirCld.size()>0){
					}else{
						this.soc0119BL.registEntityItemRelation(form);
					}
					createEntityItemRelationAppToHostByWebServer(form,entityItemVWList.get(0));
				}
			}
		}
	}
	
	/**
	 * 创建业务系统与webapp
	 * @param form
	 * @param soc0124Info
	 */
	private void createEntityItemRelationActionAppToWEBAPP(IGCIM0127Form form,
			SOC0124Info soc0124Info) throws BLException {
		SOC0110SearchCondImpl soc0110Cond=new SOC0110SearchCondImpl();
		soc0110Cond.setBrcldeiid(soc0124Info.getEiid()+"");
		soc0110Cond.setBrcldversion(soc0124Info.getEiversion()+"");
		soc0110Cond.setBrcldsmallversion(soc0124Info.getEismallversion()+"");
		soc0110Cond.setBrassetrelation("CR020002000001");
		List<SOC0110Info> soc0110InfoList=this.soc0110BL.searchEiBelongRelation(soc0110Cond);
		if(soc0110InfoList!=null&&soc0110InfoList.size()>0){
			SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
			List<String> eiidList=new ArrayList<String>();
			eiidList.add(soc0110InfoList.get(0).getBrpareiid()+"");
			cond.setEiidList(eiidList);
			List<SOC0124Info> entityItemVWList = this.soc0118BL.searchEntityItemVW(cond, 0, 0);
			if ( entityItemVWList==null || entityItemVWList.size() == 0 ) {
				throw new BLException("IGCO10000.E004","Webapp");
			}
			form.setCldeiid(entityItemVWList.get(0).getEiid());
			form.setCldeid(entityItemVWList.get(0).getEid());
			form.setCldversion(entityItemVWList.get(0).getEiversion());
			form.setCldsmallversion(entityItemVWList.get(0).getEismallversion());
			form.setEirrelation("CR030100010005");
			//更新时间设定
			Date nowDateTime = new Date();
			String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

			form.setEirupdtime(datetime);
			
			//资产关系登记      20120731 add 重复关系验证
			SOC0119SearchCondImpl condeir =new SOC0119SearchCondImpl();
			condeir.setPareiid(form.getPareiid());
			condeir.setCldeiid(form.getCldeiid());
			condeir.setEirrelationcode(form.getEirrelationcode());
			condeir.setDeleteflag("0");
			List<SOC0119Info> list_eir=this.soc0119BL.searchEntityItemRelation(condeir);
			condeir =new SOC0119SearchCondImpl();
			condeir.setCldeiid(form.getPareiid());
			condeir.setPareiid(form.getCldeiid());
			condeir.setEirrelationcode(form.getEirrelationcode());
			condeir.setDeleteflag("0");
			List<SOC0119Info> list_eirCld=this.soc0119BL.searchEntityItemRelation(condeir);
			if(list_eir.size()>0||list_eirCld.size()>0){
			}else{
				this.soc0119BL.registEntityItemRelation(form);
			}
		}
	}


	/**
	 * 创建业务系统与主机之间的关系
	 * @param form
	 * @param soc0124Info
	 * @throws BLException
	 */
	public void createEntityItemRelationActionAppToHost(IGCIM0152Form form,SOC0124Info soc0124Info) throws BLException {
		SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
		List<String> eiidList=new ArrayList<String>();
		eiidList.add(soc0124Info.getEirootmark()+"");
		cond.setEiidList(eiidList);
		List<SOC0124Info> entityItemVWList = this.soc0118BL.searchEntityItemVW(cond, 0, 0);
		if ( entityItemVWList==null || entityItemVWList.size() == 0 ) {
			throw new BLException("IGCO10000.E004","主机");
		}
		form.setCldeiid(entityItemVWList.get(0).getEiid());
		form.setCldeid(entityItemVWList.get(0).getEid());
		form.setCldversion(entityItemVWList.get(0).getEiversion());
		form.setCldsmallversion(entityItemVWList.get(0).getEismallversion());
		form.setEirrelation("CR030100010001");
		form.setEirrelationcode("003-001");
		//更新时间设定
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

		form.setEirupdtime(datetime);
		
		//资产关系登记      20120731 add 重复关系验证
		SOC0119SearchCondImpl condeir =new SOC0119SearchCondImpl();
		condeir.setPareiid(form.getPareiid());
		condeir.setCldeiid(form.getCldeiid());
		condeir.setEirrelationcode(form.getEirrelationcode());
		condeir.setDeleteflag("0");
		List<SOC0119Info> list_eir=this.soc0119BL.searchEntityItemRelation(condeir);
		condeir =new SOC0119SearchCondImpl();
		condeir.setCldeiid(form.getPareiid());
		condeir.setPareiid(form.getCldeiid());
		condeir.setEirrelationcode(form.getEirrelationcode());
		condeir.setDeleteflag("0");
		List<SOC0119Info> list_eirCld=this.soc0119BL.searchEntityItemRelation(condeir);
		if(list_eir.size()>0||list_eirCld.size()>0){
		}else{
			this.soc0119BL.registEntityItemRelation(form);
		}
	}
	
	/**
	 * 创建业务系统与DB之间的关系
	 * @param form
	 * @param soc0124Info
	 * @throws BLException
	 */
	public void createEntityItemRelationActionAppToOracle(IGCIM0127Form form,SOC0124Info soc0124Info) throws BLException {
		SOC0110SearchCondImpl soc0110Cond=new SOC0110SearchCondImpl();
		soc0110Cond.setBrcldeiid(soc0124Info.getEiid()+"");
		soc0110Cond.setBrcldversion(soc0124Info.getEiversion()+"");
		soc0110Cond.setBrcldsmallversion(soc0124Info.getEismallversion()+"");
		soc0110Cond.setBrassetrelation("CR020004000001");
		List<SOC0110Info> soc0110InfoList=this.soc0110BL.searchEiBelongRelation(soc0110Cond);
		if(soc0110InfoList!=null&&soc0110InfoList.size()>0){
			SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
			List<String> eiidList=new ArrayList<String>();
			eiidList.add(soc0110InfoList.get(0).getBrpareiid()+"");
			cond.setEiidList(eiidList);
			List<SOC0124Info> entityItemVWList = this.soc0118BL.searchEntityItemVW(cond, 0, 0);
			if ( entityItemVWList==null || entityItemVWList.size() == 0 ) {
				throw new BLException("IGCO10000.E004","DB");
			}
			form.setCldeiid(entityItemVWList.get(0).getEiid());
			form.setCldeid(entityItemVWList.get(0).getEid());
			form.setCldversion(entityItemVWList.get(0).getEiversion());
			form.setCldsmallversion(entityItemVWList.get(0).getEismallversion());
			form.setEirrelation("CR030100010003");
			//更新时间设定
			Date nowDateTime = new Date();
			String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

			form.setEirupdtime(datetime);
			
			//资产关系登记      20120731 add 重复关系验证
			SOC0119SearchCondImpl condeir =new SOC0119SearchCondImpl();
			condeir.setPareiid(form.getPareiid());
			condeir.setCldeiid(form.getCldeiid());
			condeir.setEirrelationcode(form.getEirrelationcode());
			condeir.setDeleteflag("0");
			List<SOC0119Info> list_eir=this.soc0119BL.searchEntityItemRelation(condeir);
			condeir =new SOC0119SearchCondImpl();
			condeir.setCldeiid(form.getPareiid());
			condeir.setPareiid(form.getCldeiid());
			condeir.setEirrelationcode(form.getEirrelationcode());
			condeir.setDeleteflag("0");
			List<SOC0119Info> list_eirCld=this.soc0119BL.searchEntityItemRelation(condeir);
			if(list_eir.size()>0||list_eirCld.size()>0){
			}else{
				this.soc0119BL.registEntityItemRelation(form);
			}
		}
	}
	
	/**
	 * 创建业务系统与DB之间的关系
	 * @param form
	 * @param soc0124Info
	 * @throws BLException
	 */
	public void createEntityItemRelationWebAppToOracle(IGCIM0127Form form,SOC0124Info soc0124Info) throws BLException {
		SOC0110SearchCondImpl soc0110Cond=new SOC0110SearchCondImpl();
		soc0110Cond.setBrcldeiid(soc0124Info.getEiid()+"");
		soc0110Cond.setBrcldversion(soc0124Info.getEiversion()+"");
		soc0110Cond.setBrcldsmallversion(soc0124Info.getEismallversion()+"");
		soc0110Cond.setBrassetrelation("CR020100010001");
		List<SOC0110Info> soc0110InfoList=this.soc0110BL.searchEiBelongRelation(soc0110Cond);
		if(soc0110InfoList!=null&&soc0110InfoList.size()>0){
			SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
			List<String> eiidList=new ArrayList<String>();
			eiidList.add(soc0110InfoList.get(0).getBrpareiid()+"");
			cond.setEiidList(eiidList);
			List<SOC0124Info> entityItemVWList = this.soc0118BL.searchEntityItemVW(cond, 0, 0);
			if ( entityItemVWList==null || entityItemVWList.size() == 0 ) {
				throw new BLException("IGCO10000.E004","DB");
			}
			form.setCldeiid(entityItemVWList.get(0).getEiid());
			form.setCldeid(entityItemVWList.get(0).getEid());
			form.setCldversion(entityItemVWList.get(0).getEiversion());
			form.setCldsmallversion(entityItemVWList.get(0).getEismallversion());
			form.setEirrelation("CR030100010003");
			//更新时间设定
			Date nowDateTime = new Date();
			String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

			form.setEirupdtime(datetime);
			
			//资产关系登记      20120731 add 重复关系验证
			SOC0119SearchCondImpl condeir =new SOC0119SearchCondImpl();
			condeir.setPareiid(form.getPareiid());
			condeir.setCldeiid(form.getCldeiid());
			condeir.setEirrelationcode(form.getEirrelationcode());
			condeir.setDeleteflag("0");
			List<SOC0119Info> list_eir=this.soc0119BL.searchEntityItemRelation(condeir);
			condeir =new SOC0119SearchCondImpl();
			condeir.setCldeiid(form.getPareiid());
			condeir.setPareiid(form.getCldeiid());
			condeir.setEirrelationcode(form.getEirrelationcode());
			condeir.setDeleteflag("0");
			List<SOC0119Info> list_eirCld=this.soc0119BL.searchEntityItemRelation(condeir);
			if(list_eir.size()>0||list_eirCld.size()>0){
			}else{
				this.soc0119BL.registEntityItemRelation(form);
			}
		}
		
	}
	
	/**
	 * 应用关系编辑画面初期化处理
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO initIGCIM0127Action(IGCIM01DTO dto) throws BLException {
		log.debug("========应用关系编辑画面初期化处理开始========");
		
		IGCIM0127Form form = dto.getIgasm0807Form();
		SOC0119TB ret = 		
			(SOC0119TB) this.soc0119BL.searchEntityItemRelationByKey(
				form.getEirid());
		
		if ( ret == null ){
			throw new BLException("IGCO10000.E004",resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.014"));
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
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO updateEntityItemRelationActionApp(IGCIM01DTO dto) throws BLException {
		log.debug("========应用关系变更处理处理开始========");
		IGCIM0127Form form = dto.getIgasm0807Form();

		//更新时间设定
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

		form.setEirupdtime(datetime);
		
		this.soc0119BL.updateEntityItemRelation(form);

		dto.addMessage(new ActionMessage( "IGCO10000.I005", resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.013")) );

		log.debug("========应用关系变更处理处理终了========");
		return dto;
	}
	
	/**
	 *	获取应用关联关系处理
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO searchRelationListActionApp(IGCIM01DTO dto) throws BLException {
		log.debug("========获取应用关联关系处理开始========");
		List<LabelValueBean> list = this.codeDetailBL.searchLabelValueBeanList(CommonDefineUtils.ENTIY_CATEGORY_APPLICATION,CodeDefine.getCodeDefine("ENTITYITEM_RELATION_CODE").getCcid());
		dto.setRelationList(list);
		log.debug("========获取应用关联关系处理终了========");
		return dto;
	}
	

	/**
	 *	获取FS关联关系处理
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO searchFSRelationListAction(IGCIM01DTO dto) throws BLException {
		log.debug("========获取FS关联关系处理开始========");
		SOC0118SearchCondImpl econd = new SOC0118SearchCondImpl();
		econd.setEirootmark(dto.getIgasm0813Form().getEiid());		//FS归属的应用EIID
		econd.setEid(EntityItemKeyWords.FS_EID);					//FS的EID
		List<SOC0118Info> eiList = this.soc0118BL.searchEntityItem(econd);
		SOC0119SearchCondImpl ercond  = new SOC0119SearchCondImpl();
		ercond.setPareiid(dto.getIgasm0813Form().getPareiid());
		ercond.setEirrelationcode(EntityItemKeyWords.APP_FS_RelationCODE);
		ercond.setDeleteflag("0");
		List<SOC0119Info> eirList = this.soc0119BL.searchEntityItemRelation(ercond);
		List<SOC0118Info> choosedList = new ArrayList<SOC0118Info>();		//已经选择的fs关系列表
		List<SOC0118Info> choosableList = new ArrayList<SOC0118Info>();	//可以选择的fs关系列表
		if(eirList!=null&&eirList.size()>0){
			List<Integer> eiidList = new ArrayList<Integer>();
			for(SOC0119Info eir:eirList){//所有已经选择的fs eiid列表
				eiidList.add(eir.getCldeiid());
			}
			if(eiList!=null&&eiList.size()>0){
				for(SOC0118Info ei:eiList){
					if(eiidList.contains(ei.getEiid())){
						choosedList.add(ei);
					}else{
						choosableList.add(ei);
					}
				}
			}
			dto.setEntityItemList(choosableList);	//可以选择的fs关系列表
			dto.setEntityItemedList(choosedList);//已经选择的fs关系列表
		}else{
			dto.setEntityItemList(eiList);	//可以选择的fs关系列表
			dto.setEntityItemedList(choosedList);//已经选择的fs关系列表
		}
		
		
		log.debug("========获取FS关联关系处理终了========");
		return dto;
	}
	
	/**
	 *	新增FS关联关系处理
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO insertFSRelationAction(IGCIM01DTO dto) throws BLException {
		log.debug("========新增FS关联关系处理开始========");
		IGCIM0129Form form  = dto.getIgasm0813Form();
		String[] eiids = form.getEiids();
		if(eiids!=null&&eiids.length>0){
			for(int i=0;i<eiids.length;i++){
				SOC0119TB entityItemRelation = new SOC0119TB();
				entityItemRelation.setPareiid(form.getPareiid());	//应用eiid
				entityItemRelation.setPareid(EntityItemKeyWords.APP_EID); //应用EID
				entityItemRelation.setCldeiid(Integer.valueOf(eiids[i]));	//FS eiid
				entityItemRelation.setCldeid(EntityItemKeyWords.FS_EID); //FS EID
				entityItemRelation.setEirrelation(EntityItemKeyWords.APP_FS_Relation);	//应用fs关系
				entityItemRelation.setEirrelationcode(EntityItemKeyWords.APP_FS_RelationCODE);
				entityItemRelation.setEirupdtime(IGStringUtils.getCurrentDateTime());
				entityItemRelation.setParversion(form.getParversion());
				entityItemRelation.setParsmallversion(form.getParsmallversion());
				entityItemRelation.setCldversion(Integer.valueOf(form.getEiversions()[i]));
				entityItemRelation.setCldsmallversion(Integer.valueOf(form.getEismallversions()[i]));
				entityItemRelation.setDeleteflag("0");		//逻辑删除标识
				this.soc0119BL.registEntityItemRelation(entityItemRelation);
			}
		}
		
		
		log.debug("========新增FS关联关系处理终了========");
		return dto;
	}
	
	/**
	 *	删除FS关联关系处理
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO deleteFSRelationAction(IGCIM01DTO dto) throws BLException {
		log.debug("========删除FS关联关系处理开始========");
		IGCIM0129Form form  = dto.getIgasm0813Form();
		String[] eiids = form.getEiids();
		if(eiids!=null&&eiids.length>0){
			for(int i=0;i<eiids.length;i++){
				SOC0119SearchCondImpl ercond  = new SOC0119SearchCondImpl();
				ercond.setCldeiid(Integer.parseInt(eiids[i]));
				ercond.setEirrelationcode(EntityItemKeyWords.APP_FS_RelationCODE);
				ercond.setDeleteflag("0");
				List<SOC0119Info> eirList= this.soc0119BL.searchEntityItemRelation(ercond);
				if(eirList!=null&&eirList.size()>0){
					SOC0119TB eirTB = (SOC0119TB) eirList.get(0);
					eirTB.setDeleteflag("1");
					this.soc0119BL.updateEntityItemRelation(eirTB);
				}
			}
		}
		
		
		log.debug("========删除FS关联关系处理终了========");
		return dto;
	}
	
	/**
	 *应用信息修改初期显示处理
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO initEntityItemApp(IGCIM01DTO dto) throws BLException {

		log.debug("========应用信息编辑画面初期显示处理开始========");
		
		IGCIM0128Form form = dto.getIgasm0812Form();
		
		//显示用资产信息取得
		SOC0124Info entityItem = this.soc0118BL.searchEntityItemVWByKey(form.getEiid());
		
		if ( entityItem == null ){
			throw new BLException("IGCO10000.E004",resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.015"));
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
			dto.addMessage(new ActionMessage("IGCO10000.E023",resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.016")));
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
	public IGCIM01DTO updateEntityItemApp(IGCIM01DTO dto) throws BLException {
		
		log.debug("========应用信息编辑画面初期显示处理开始========");
		
		IGCIM0128Form form = dto.getIgasm0812Form();
		if(!form.getEilabel().equals(form.getEilabelbak())){
			this.soc0118BL.checkNotExistEntityItem(form.getEilabel());
		}
		this.soc0118BL.updateEntityItem(form);
		dto.addMessage(new ActionMessage("IGCO10000.I005",resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.001")));
		log.debug("========应用信息编辑画面初期显示处理终了========");
		return dto;
	}
	
	/**
	 * 获取应用编号最大值
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO searchEntityItemLableActionApp(IGCIM01DTO dto) throws BLException {
		
		log.debug("========获取应用编号最大值处理开始========");
		
		IGCIM0122Form form = dto.getIgasm0802Form();
		
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
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 * @throws BLException 
	 */
	public IGCIM01DTO checkEntityItemDomainApp(IGCIM01DTO dto) throws BLException{
		boolean isRoleManager = this.userRoleBL.checkRoleManagerByType(dto.getUser().getUserid(), EntityCategory.ROLE_TYPE_APPLICATION);
		
		if(isRoleManager) {
			OrganizationSearchCondImpl orgCond = new OrganizationSearchCondImpl();
			orgCond.setOrgpar("0001");
			List<Organization> org = this.organizationBL.searchOrganization(orgCond);
			
			if(org.size() != 1) {
				throw new BLException("IGCO10000.E004",resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.017"));
			} else {
				dto.setOrgname(org.get(0).getOrgname());
				dto.setOrgsyscoding(org.get(0).getOrgsyscoding());
			}
			SOC0117SearchCondImpl entityCond = new SOC0117SearchCondImpl();
			entityCond.setEsyscoding(CommonDefineUtils.ENTIY_CATEGORY_APPLICATION_SYSCODING);
			List<SOC0117Info> entity = this.soc0117BL.searchEntity(entityCond, 0, 0);
			
			if(entity.size() != 1) {
				throw new BLException("IGCO10000.E004",resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.018"));
			} else {
				dto.setEname(entity.get(0).getEname());
				dto.setEsyscoding(entity.get(0).getEsyscoding());
			}
		}
		
		dto.setFlag(isRoleManager);
		
		return dto;
	}

	/**
	 * 配置源数据版本信息取得
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM01DTO getRciVersionsAction(IGCIM01DTO dto) throws BLException {
		log.debug("==============配置源数据版本信息取得操作开始===============");
		//页面信息取得
		IGCIM0110Form form = dto.getIgcim0110Form();
		//资产信息取得
//		SOC0118Info entity = this.soc0118BL.searchEntityItemByKey(form.getEiid());
//		dto.setEntityItem(entity);
		//配置原数据索引列表查询
//		if(entity!=null&&StringUtils.isNotEmpty(entity.getEiname())){
		int count = Integer.valueOf(ResourceUtility.getString("CI_SHOW_CONT"));
		CR03SearchCondImpl cond = new CR03SearchCondImpl();
//			cond.setHost(entity.getEiname());
		cond.setHost(form.getHost());
		cond.setIp(form.getIp());
		cond.setType(form.getType());
		cond.setServername(form.getServername());
		try{
			if(StringUtils.isNotEmpty(form.getCollecttimeFrom())){
				SimpleDateFormat d1 = new SimpleDateFormat("yyyyMMddHHmmss");
				SimpleDateFormat d2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				cond.setCollecttimeFrom(d1.format(d2.parse(form.getCollecttimeFrom().trim()+" 00:00:00")));
				if(StringUtils.isNotEmpty(form.getCollecttimeTo())){
					cond.setCollecttimeTo(d1.format(d2.parse(form.getCollecttimeTo().trim()+" 23:59:59")));
					count = 0;
				}
			}
		}catch (Exception e) {
			log.error("",e);
		}
//		List<CR03Info> list = cr03BL.searchCR03(cond,0,count);
		List<CR03VWInfo> list = cr03BL.getRciVersions(cond, 0, count); 
//			dto.setEntityItem(entity);
		dto.setCr03VWList(list);
//		}
		if(dto.getCr03VWList()==null||dto.getCr03VWList().isEmpty()){
			dto.setShowFlag("N");
		}else{
			dto.setShowFlag("Y");
		}
		log.debug("==============配置源数据版本信息取得操作结束===============");
		return dto;
	}
	
	/**
	 * 当前最新版本信息取得
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM01DTO getCurrentNewCriVersionAction(IGCIM01DTO dto) throws BLException {
		log.debug("=============当前最新版本信息取得操作开始=============");
		//所有版本信息取得
		long maxTime = 0;
		List<CR03VWInfo> list = dto.getCr03VWList();
		//获取最新版本
		CR03VWInfo cr03 = null;
		if(list!=null){
			for(CR03VWInfo c:list){
				if(cr03 == null){
					maxTime = Long.valueOf(c.getMinctime());
					cr03 = c;
				}else{
					if(Long.valueOf(c.getMinctime())>Long.valueOf(cr03.getMinctime())){
						cr03 = c;
					}
					
				
				}
			}
		}
		dto.setCr03VW(cr03);
		log.debug("=============当前最新版本信息取得操作结束=============");
		return dto;
	}
	
	/**
	 * 历史版本信息取得
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM01DTO getHostoryVersions(IGCIM01DTO dto) throws BLException {
		log.debug("=============历史版本信息取得操作开始=============");
		//页面信息取得
		IGCIM0110Form form = dto.getIgcim0110Form();
		//分区表名取得
		String collecttime = form.getCollecttime();
		//资产实体取得
//		SOC0118Info entity = dto.getEntityItem();
//		if(StringUtils.isNotEmpty(tablename)&&entity!=null&&StringUtils.isNotEmpty(entity.getEiname())){
		if(StringUtils.isNotEmpty(collecttime)&&StringUtils.isNotEmpty(form.getHost())){
			CR03SearchCondImpl cond = new CR03SearchCondImpl();
			cond.setCollecttime(collecttime);
			cond.setHost(form.getHost());
			cond.setIp(form.getIp());
			cond.setType(form.getType());
			cond.setServername(form.getServername());
			List<CR03VWInfo> list = cr03BL.getRciVersions(cond, 0, 12);
			if(list!=null&&!list.isEmpty()){
				dto.setCr03VW(list.get(0));
			}
		}
		log.debug("=============历史版本信息取得操作结束=============");
		return dto;
	}
	
	/**
	 * 当前采集信息取得
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM01DTO getCR01InfoList(IGCIM01DTO dto) throws BLException {
		log.debug("============当前采集信息取得操作开始==============");
		IGCIM0110Form form=dto.getIgcim0110Form();
		//版本信息取得
		CR03VWInfo cr03 = dto.getCr03VW();
		//设备信息取得
//		SOC0118Info entity = dto.getEntityItem();
//		if(cr03!=null&&entity!=null&&StringUtils.isNotEmpty(entity.getEiname())){
		if(cr03!=null&&StringUtils.isNotEmpty(form.getHost())){
			CR01SearchCondImpl cond = new CR01SearchCondImpl();
			cond.setServertype(String.valueOf(cr03.getType()));
			cond.setTablename(cr03.getTablename());
			cond.setHost(form.getHost());
			cond.setIp(cr03.getIp());
			cond.setServername(cr03.getServername());
			cond.setCollecttime(cr03.getMinctime());
			List<CR01VWInfo> cr01List = cr01BL.searchCR01VWInfoList(cond, 0, 0);
			dto.setCr01List(cr01List);
		}
		log.debug("============当前采集信息取得操作结束==============");
		return dto;
	}
	

	/**
	 * 获取当前某个命令下的所有采集结果
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM01DTO getCR01InfoListByCommand(IGCIM01DTO dto) throws BLException {
		log.debug("============当前采集信息取得操作开始==============");
		IGCIM0112Form form=dto.getIgcim0112Form();
		//设备信息取得
		if(form!=null){
			CR01SearchCondImpl cond = new CR01SearchCondImpl();
			cond.setTablename(form.getTablename());
			cond.setHost(form.getHost());
			SimpleDateFormat d1 = new SimpleDateFormat("yyyyMMddHHmmss");
			SimpleDateFormat d2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			try {
				cond.setCollecttime(d1.format(d2.parse(form.getCollecttime().trim())));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			cond.setCommand(form.getKeys());
			cond.setServertype(form.getType());
			cond.setIp(form.getIp());
			cond.setServername(form.getServername());
			
			//设备信息查询件数取得 
			List<CR01VWInfo> cr01List = cr01BL.searchCR01VWInfoList(cond, 0, 0);
			if (cr01List == null||cr01List.size()==0) {
				log.debug("========需要查询的命令数据不存在========");
				//需要查询的命令数据不存在
				dto.addMessage(new ActionMessage("IGCO10000.I002",0));
				return dto;
			} 
			int totalCount=cr01List.size();
			if ( cr01List.size() > dto.getMaxSearchCount() ) {
				log.debug("========需要查询的命令数据过多========");
				//需要查询的命令数据过多
				dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
				return dto;
			}
			//分页用信息取得
			PagingDTO pDto = dto.getPagingDto();

			//当前页设备信息取得
			cr01List = cr01BL.searchCR01VWInfoList(cond, pDto.getFromCount(), pDto.getPageDispCount());;
			
			pDto.setTotalCount(totalCount);
			
			dto.setCr01List(cr01List);
		}
		log.debug("============当前采集信息取得操作结束==============");
		return dto;
	}
	
	/**
	 * 命令详细对比结果
	 * @param dto
	 * @return
	 * @throws BLException
	 * @throws ParseException 
	 */
	public IGCIM01DTO getCR01InfoListByCommand2(IGCIM01DTO dto) throws BLException {
		log.debug("============当前采集信息取得操作开始==============");
		IGCIM0114Form form=dto.getIgcim0114Form();
		//设备信息取得
		if(form!=null){
			String tablenames = form.getTablenames();
			String table1 = tablenames.split(",")[0];
			CR01SearchCondImpl cond = new CR01SearchCondImpl();
			cond.setTablename(table1.split("_sp_")[0]);
			cond.setHost(form.getHost());
			cond.setCollecttime(table1.split("_sp_")[1]);
			cond.setCommand(form.getKeys());
			cond.setServertype(form.getType());
			cond.setIp(form.getIp());
			cond.setServername(form.getServername());
			
			//设备信息查询件数取得 
			List<CR01VWInfo> cr01List1 = cr01BL.searchCR01VWInfoList(cond, 0, 0);
			if (cr01List1 == null||cr01List1.size()==0) {
				log.debug("========需要查询的命令数据不存在========");
				//需要查询的命令数据不存在
				dto.addMessage(new ActionMessage("IGCO10000.I002",0));
				return dto;
			} 
			int totalCount1=cr01List1.size();
			if ( cr01List1.size() > dto.getMaxSearchCount() ) {
				log.debug("========需要查询的命令数据过多========");
				//需要查询的命令数据过多
				dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount1));
				return dto;
			}

			//分页用信息取得
			PagingDTO pDto = dto.getPagingDto();
			
			//当前页设备信息取得
			//cr01List1 = cr01BL.searchCR01VWInfoList(cond, pDto.getFromCount(), pDto.getPageDispCount());
			
			String table2 = tablenames.split(",")[1];
			cond = new CR01SearchCondImpl();
			cond.setTablename(table2.split("_sp_")[0]);
			cond.setHost(form.getHost());
			cond.setCollecttime(table2.split("_sp_")[1]);
			cond.setCommand(form.getKeys());
			cond.setServertype(form.getType());
			cond.setIp(form.getIp());
			cond.setServername(form.getServername());
			
			//设备信息查询件数取得 
			List<CR01VWInfo> cr01List2 = cr01BL.searchCR01VWInfoList(cond, 0, 0);
			if (cr01List2 == null||cr01List2.size()==0) {
				log.debug("========需要查询的命令数据不存在========");
				//需要查询的命令数据不存在
				dto.addMessage(new ActionMessage("IGCO10000.I002",0));
				return dto;
			} 
			int totalCount2=cr01List2.size();
			if ( cr01List2.size() > dto.getMaxSearchCount() ) {
				log.debug("========需要查询的命令数据过多========");
				//需要查询的命令数据过多
				dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount2));
				return dto;
			}

			//当前页设备信息取得
			//cr01List2 = cr01BL.searchCR01VWInfoList(cond, pDto.getFromCount(), pDto.getPageDispCount());;
			
			
			pDto.setTotalCount(totalCount1>totalCount1?totalCount1:totalCount2);
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
			try {
				Date date1 = sdf.parse(table1.split("_sp_")[1]);
				Date date2 = sdf.parse(table2.split("_sp_")[1]);
				sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				dto.setCollecttime1(sdf.format(date1));
				dto.setCollecttime2(sdf.format(date2));
			} catch (ParseException e) {
				log.error("==============日期转换异常=============");
			}
			dto.setCr01List1(cr01List1);
			dto.setCr01List2(cr01List2);
		}
		log.debug("============当前采集信息取得操作结束==============");
		return dto;
	}
	
	/**
	 * 配置源数据多版本信息查询
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM01DTO compareVersionsAction(IGCIM01DTO dto) throws BLException {
		log.debug("===========配置源数据多版本信息查询操作开始=============");
		//页面信息取得
		IGCIM0111Form form = dto.getIgcim0111Form();
//		//设备信息取得
//		SOC0118Info entity = this.soc0118BL.searchEntityItemByKey(form.getEiid());
//		dto.setEntityItem(entity);
		if(StringUtils.isNotEmpty(form.getTablenames())){
			//表名取得
			String[] tablenames = form.getTablenames().split(",");
//			if(entity!=null&&StringUtils.isNotEmpty(entity.getEiname())){
			if(StringUtils.isNotEmpty(form.getHost())){
				Map<String, List<CR01VWInfo>> crMap = new HashMap<String, List<CR01VWInfo>>();
				if(tablenames!=null&&tablenames.length>0){
					for(String tablename:tablenames){
						if(StringUtils.isNotEmpty(tablename)){
							CR01SearchCondImpl cond = new CR01SearchCondImpl();
//							cond.setHost(entity.getEiname());
							cond.setHost(form.getHost());
							cond.setTablename(tablename.split("_sp_")[0]);
							cond.setCollecttime(tablename.split("_sp_")[1]);
							cond.setIp(form.getIp());
							cond.setServertype(form.getType());
							cond.setServername(form.getServername());
							List<CR01VWInfo> cr01List = cr01BL.searchCR01VWInfoList(cond, 0, 0);
							crMap.put(getShowtime(tablename.split("_sp_")[1]), cr01List);
						}
					}
				}
				dto.setCompareVersionsMap(crMap);
			}
			
		}
		log.debug("===========配置源数据多版本信息查询操作结束=============");
		return dto;
	}
	public String getShowtime(String collecttime) {
		String showtime ="";
		if(StringUtils.isNotEmpty(collecttime)){
			try{
				SimpleDateFormat d1 = new SimpleDateFormat("yyyyMMddHHmmss");
				SimpleDateFormat d2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				showtime = d2.format(d1.parse(collecttime));
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return showtime;
	}	/**
	 * 设备关系树画面初期化处理(显示全树，顶级EI为根)
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO initIGAIM0146Action(IGCIM01DTO dto) throws BLException {
		log.debug("========配置包含关系显示处理开始========");
		
		IGCIM0146Form form = dto.getIgcim0146Form();
		//查询顶级配置资产的所有子节点
		SOC0127SearchCondImpl cond = new SOC0127SearchCondImpl();
		cond.setEirootmark(Integer.parseInt(form.getEirootmark()));
		cond.setBrparversion(Integer.parseInt(form.getEiversion()));
		cond.setBrcldversion(cond.getBrparversion());
		List<SOC0127Info> eibrList = this.soc0110BL.searchEiBelongRelationVW2(cond);
		//查询顶级EI
		SOC0123Info rootEi = this.soc0118BL.searchEntityItemEntityVWByKey(Integer.parseInt(form.getEirootmark()));
		//根据选中资产大版本查询顶级EI的最大小版本
		Integer rootEiMaxSmallveision = this.soc0107BL.searchEiMaxSmallVersion(rootEi.getEiid(), Integer.parseInt(form.getEiversion()));
		//构造树集合
		Map<String,TreeNode> treeNodeMap = new LinkedHashMap<String,TreeNode>();
		//构造根	
		TreeNode rootNode = new TreeNode();
		rootNode.setId(rootEi.getEiid() + "_" + rootEi.getEiversion() + "_" + rootEiMaxSmallveision);//资产ID|大版本|小版本
		rootNode.setName(rootEi.getEiname() + "(" + form.getEiversion() + "." + rootEiMaxSmallveision + ")");//资产名称
		
		//递归构造包含关系树
		searchConfigurationTreeNode2(eibrList, rootEi, rootNode);
		if(rootEi.getEsyscoding().startsWith(EiRelationKeyWords.STORAGE)){
			searchTreeNodeForStorage2(eibrList, rootEi, rootNode);
		}
		//填充更节点
		treeNodeMap.put(rootNode.getId(),rootNode);
		dto.setTreeNodeMap(treeNodeMap);
		
		log.debug("========配置包含关系显示处理终了========");
		return dto;
	}
	
	/**
	 * 递归构造配置包含树处理
	 *
	 * @param eibrList 节点集合
	 * @param ei 父级资产节点
	 * @param parNode 父级节点
	 */
	public void searchConfigurationTreeNode2(List<SOC0127Info> eibrList,
			SOC0123Info ei, TreeNode parNode) throws BLException {
		
		//迭代节点集合
		for(SOC0127Info eibr : eibrList) {
			if(ei.getEiid().equals(eibr.getBrpareiid())) {//匹配ID
				//构造子节点
				TreeNode cldNode = new TreeNode();
				cldNode.setId(eibr.getBrcldeiid() + "_" + eibr.getBrcldversion() + "_" + eibr.getBrcldsmallversion());//资产ID|大版本|小版本
				cldNode.setName(eibr.getCldEntityItemVW().getEiname() + "(" + eibr.getBrcldversion() + "." + eibr.getBrcldsmallversion() + ")");//资产名称
				//获得模型节点
				String cldEsyscoding = eibr.getCldEntityItemVW().getEsyscoding();
				if(cldEsyscoding.startsWith(EiRelationKeyWords.SWITCH)){
					continue;
				}
				String parEsyscoding = ei.getEsyscoding();
				if(EiRelationKeyWords.SANPORT.equals(parEsyscoding)){
					continue;
				}
				LinkedHashMap<String, TreeNode> childTreeNodeMap = parNode.getChildTreeNodeMap();
				TreeNode treeNode = childTreeNodeMap.get(cldEsyscoding);
				SOC0117Info entity = soc0117BL.searchEntityByKey(eibr.getCldEntityItemVW().getEid());
				//设备添加模型名称子节点，模型名称节点添加模型子节点
				if(treeNode==null){
					if(parEsyscoding.startsWith(EiRelationKeyWords.HOST)
							||parEsyscoding.startsWith(EiRelationKeyWords.SWITCH)
							||parEsyscoding.startsWith(EiRelationKeyWords.STORAGE)){
						treeNode=new TreeNode();
						treeNode.setId(entity.getEsyscoding());
						treeNode.setName(entity.getEname());
						parNode.addChildTreeNode(treeNode.getId(), treeNode);
						treeNode.addChildTreeNode(cldNode.getId(),cldNode);
					}else{
						parNode.addChildTreeNode(cldNode.getId(),cldNode);
					}
				}else{
					treeNode.addChildTreeNode(cldNode.getId(),cldNode);
				}
					
				//递归
				searchConfigurationTreeNode2(eibrList, eibr.getCldEntityItemVW(), cldNode);
			}
		}
		
	}
	/**
	 * 存储情况特殊faport-fa fa-storage
	 *
	 * @param eibrList 节点集合
	 * @param ei 父级资产节点
	 * @param parNode 父级节点
	 */
	public void searchTreeNodeForStorage2(List<SOC0127Info> eibrList,
			SOC0123Info ei, TreeNode parNode) throws BLException {
		
		//迭代节点集合
		for(SOC0127Info eibr : eibrList) {
			if(ei.getEiid().equals(eibr.getBrcldeiid())) {//匹配ID
				//构造子节点
				TreeNode cldNode = new TreeNode();
				cldNode.setId(eibr.getBrpareiid() + "_" + eibr.getBrparversion() + "_" + eibr.getBrparsmallversion());//资产ID|大版本|小版本
				cldNode.setName(eibr.getParEntityItemVW().getEiname() + "(" + eibr.getBrparversion() + "." + eibr.getBrparsmallversion() + ")");//资产名称
				String parEsyscoding = eibr.getParEntityItemVW().getEsyscoding();
				LinkedHashMap<String, TreeNode> childTreeNodeMap = parNode.getChildTreeNodeMap();
				TreeNode treeNode = childTreeNodeMap.get(parEsyscoding);
				SOC0117Info entity = soc0117BL.searchEntityByKey(eibr.getParEntityItemVW().getEid());
				String cldEsyscoding = ei.getEsyscoding();
				
				if(treeNode==null){
//					if(EiRelationKeyWords.FA.equals(esyscoding)){
//						treeNode=new TreeNode();
//						treeNode.setId(EiRelationKeyWords.FA);
//						treeNode.setName("FA");
//						parNode.addChildTreeNode(treeNode.getId(), treeNode);
//						treeNode.addChildTreeNode(cldNode.getId(),cldNode);
//					}else{
//						parNode.addChildTreeNode(cldNode.getId(),cldNode);
//					}
					if(cldEsyscoding.startsWith(EiRelationKeyWords.STORAGE)){
						treeNode=new TreeNode();
						treeNode.setId(entity.getEsyscoding());
						treeNode.setName(entity.getEname());
						parNode.addChildTreeNode(treeNode.getId(), treeNode);
						treeNode.addChildTreeNode(cldNode.getId(),cldNode);
					}else{
						parNode.addChildTreeNode(cldNode.getId(),cldNode);
					}
				}else{
					treeNode.addChildTreeNode(cldNode.getId(),cldNode);
				}
				//填充子节点
//				if(treeNode!=null){
//					treeNode.addChildTreeNode(cldNode.getId(),cldNode);
//				}else{
//					parNode.addChildTreeNode(cldNode.getId(),cldNode);
//				}
				//递归
				searchTreeNodeForStorage2(eibrList, eibr.getParEntityItemVW(), cldNode);
			}
		}
	}


	public IGCIM01DTO initIGASM0317Action(IGCIM01DTO dto) throws BLException {
		return null;
	}
	/**
	 * 包含树
	 *
	 * @param eibrList 节点集合
	 * @param ei 父级资产节点
	 * @param parNode 父级节点
	 */
	public IGCIM01DTO getContainTree(IGCIM01DTO dto) throws BLException {
		IGCIM0146Form form=dto.getIgcim0146Form();
		Map<Integer,List<RelationTreeTB>> treeMap=new LinkedHashMap<Integer, List<RelationTreeTB>>();
		int levelNum=100;
		String jsonStr=null;
		Integer eiid=Integer.parseInt(form.getEiid());
		Integer eirootmark=Integer.parseInt(form.getEirootmark());
		Integer eiversion=Integer.parseInt(form.getEiversion());
		Integer eismallversion=Integer.parseInt(form.getEismallversion());
		//向上查询
		treeMap=searchUpTreeNode(eiid,eiversion,eismallversion,eirootmark,levelNum,treeMap);
		//向下查询
		treeMap=searchDownTreeNodeByEiid(eiid,eiversion,eismallversion,eirootmark,levelNum,treeMap);
		//然后处理treeMap
		jsonStr=initChangeJsonObject(treeMap,levelNum);
		//设置初始化结点
		String initNodeId=getInitNodeId(treeMap,levelNum);
		dto.setInitTreeStr(jsonStr);
		dto.setInitNodeID(initNodeId);
		return dto;
	}
	/**
	 * 包含树
	 *
	 * @param eibrList 节点集合
	 * @param ei 父级资产节点
	 * @param parNode 父级节点
	 */
	public IGCIM01DTO getContainTree0149Action(IGCIM01DTO dto) throws BLException {
		IGCIM0149Form form=dto.getIgcim0149Form();
		Map<Integer,List<RelationTreeTB>> treeMap=new LinkedHashMap<Integer, List<RelationTreeTB>>();
		int levelNum=100;
		String jsonStr=null;
		Integer eiid=Integer.parseInt(form.getEiid());
		Integer eirootmark=Integer.parseInt(form.getEirootmark());
		Integer eiversion=Integer.parseInt(form.getEiversion());
		Integer eismallversion=Integer.parseInt(form.getEismallversion());
		//向上查询
		treeMap=searchUpTreeNode(eiid,eiversion,eismallversion,eirootmark,levelNum,treeMap);
		//向下查询
		treeMap=searchDownTreeNodeByEiid(eiid,eiversion,eismallversion,eirootmark,levelNum,treeMap);
		//然后处理treeMap
		jsonStr=initChangeJsonObject(treeMap,levelNum);
		//设置初始化结点
		String initNodeId=getInitNodeId(treeMap,levelNum);
		dto.setInitTreeStr(jsonStr);
		dto.setInitNodeID(initNodeId);
		return dto;
	}


	

	/**
	 * 将获取初始化默认ID值
	 * @param Integer levelNum  结点级别号
	 * @param Map<Integer,List<RelationTreeTB>> treeMap  存放结点map
	 */
	public String getInitNodeId(Map<Integer,List<RelationTreeTB>> treeMap, Integer levelNum){
		List<RelationTreeTB> rtList=treeMap.get(levelNum-1);
		if(rtList!=null&&rtList.size()>0){
			RelationTreeTB tb=rtList.get(0);
			String objId="1_"+tb.getEiid()+"_"+tb.getEirootmark()+"_"+tb.getEiversion()+"_"+tb.getEismallversion()+"_"+(levelNum-1)+"_"+tb.getFatherEiid();
			return objId;
		}else{
			return "";
		}
	}
	
	/**
	 * 将treeMap转换为json对象，然后传个字符串
	 * @param Integer levelNum  结点级别号
	 * @param Map<Integer,List<RelationTreeTB>> treeMap  存放结点map
	 */
	public String initChangeJsonObject(Map<Integer,List<RelationTreeTB>> treeMap, Integer levelNum){
		//需要返回的字符串
		String returnStr="";
		if(treeMap!=null&&treeMap.size()>0){
			//1.首先将map中key排序
			Integer[] keyArr=new Integer[treeMap.size()];
			treeMap.keySet().toArray(keyArr);
			//排序
			Arrays.sort(keyArr);
			//2.将value值转为对象
			//遍历集合
			JSONArray jsonArr=new JSONArray();
			String lastId="0";
			Map<String, String> itemImageMap = this.getItemImagesInfoByCodeDetail();
			for (Integer key : keyArr) {
				//获取集合值
				List<RelationTreeTB> rtList=treeMap.get(key);
				//判断是否上结点
				//id:1, pId:0, name:"主机", open:true, iconSkin:"pIcon01"
				//ID命名, 模型 命名规则   0_eid值_eirootmark值_eiversion值_eismallversion值_LevelNum_父级eiid_关系码值
				//        对象命名规则    1_eiid值_eirootmark值_eiversion值_eismallversion值_LevelNum_父级eiid
				try{
				if(key<levelNum){
					for (RelationTreeTB tb : rtList) {
						String imagekey = tb.getEid();
						JSONObject objType=new JSONObject();
						String typeId="0_"+tb.getEid()+"_"+tb.getEirootmark()+"_"+tb.getEiversion()+"_"+tb.getEismallversion()+"_"+key+"_"+tb.getFatherEiid()+"_0_"+tb.getSourceEiid();
						objType.put(IGCIMConstants.TREE_PARAMETER_ID, typeId);
						objType.put(IGCIMConstants.TREE_PARAMETER_PID, lastId);
						objType.put(IGCIMConstants.TREE_PARAMETER_NAME, tb.getEname());
						objType.put(IGCIMConstants.TREE_PARAMETER_OPEN, IGCIMConstants.TREE_PARAMETER_OPEN_VALUE_TRUE);
//						objType.put(IGCIMConstants.TREE_PARAMETER_ICONSKIN, IGCIMConstants.TREE_PARAMETER_ICONSKIN_FATHERICON);
						objType = this.getItemImageByName(objType, itemImageMap, imagekey, tb.getIsLeaf(), true, tb.getEid());
						jsonArr.put(objType);
						lastId=typeId;
						
						JSONObject obj=new JSONObject();
						String objId="1_"+tb.getEiid()+"_"+tb.getEirootmark()+"_"+tb.getEiversion()+"_"+tb.getEismallversion()+"_"+key+"_"+tb.getFatherEiid()+"_"+tb.getSourceEiid();
						obj.put(IGCIMConstants.TREE_PARAMETER_ID, objId);
						obj.put(IGCIMConstants.TREE_PARAMETER_PID, lastId);
						obj.put(IGCIMConstants.TREE_PARAMETER_NAME, tb.getEiname());
						//不是父节点就是叶子节点
						if(IGCIMConstants.TREE_PARAMETER_ISLEAF_VALUE_TRUE.equals(tb.getIsLeaf())){
							obj.put(IGCIMConstants.TREE_PARAMETER_OPEN, IGCIMConstants.TREE_PARAMETER_OPEN_VALUE_TRUE);
						}else{
						}
						objType = this.getItemImageByName(obj, itemImageMap, imagekey, tb.getIsLeaf(), false, tb.getEid());
						jsonArr.put(obj);
						lastId=objId;
					}
				}else{
					for (RelationTreeTB tb : rtList) {
						String imagekey = tb.getEid();
						boolean isModule = false;
						JSONObject objType=new JSONObject();
						String typeId="";
						String name="";
						if(tb.getRlnCode()!=null&&!"".equals(tb.getRlnCode())){
							typeId="0_"+tb.getEid()+"_"+tb.getEirootmark()+"_"+tb.getEiversion()+"_"+tb.getEismallversion()+"_"+key+"_"+tb.getFatherEiid()+"_"+tb.getRlnCode()+"_"+tb.getSourceEiid();
							name=tb.getEname();
							isModule = true;
						}else{
							typeId="1_"+tb.getEiid()+"_"+tb.getEirootmark()+"_"+tb.getEiversion()+"_"+tb.getEismallversion()+"_"+key+"_"+tb.getFatherEiid()+"_"+tb.getSourceEiid();
							name=tb.getEiname();
						}
						objType.put(IGCIMConstants.TREE_PARAMETER_ID, typeId);
						objType.put(IGCIMConstants.TREE_PARAMETER_PID, lastId);
						objType.put(IGCIMConstants.TREE_PARAMETER_NAME, name);
						objType.put(IGCIMConstants.TREE_PARAMETER_OPEN, IGCIMConstants.TREE_PARAMETER_OPEN_VALUE_FALSE);
						//不是父节点就是叶子节点
						if(IGCIMConstants.TREE_PARAMETER_ISLEAF_VALUE_TRUE.equals(tb.getIsLeaf())){
							objType.put("isParent", false);
							objType = this.getItemImageByName(objType, itemImageMap, imagekey, tb.getIsLeaf(), isModule, tb.getEid());
//							objType.put(IGCIMConstants.TREE_PARAMETER_ICONSKIN, IGCIMConstants.TREE_PARAMETER_ICONSKIN_LEAFICON);
						}else{
							objType.put("isParent", true);
							objType = this.getItemImageByName(objType, itemImageMap, imagekey, tb.getIsLeaf(), isModule, tb.getEid());
//							objType.put(IGCIMConstants.TREE_PARAMETER_ICONSKIN, IGCIMConstants.TREE_PARAMETER_ICONSKIN_FATHERICON);
						}
						jsonArr.put(objType);
					}
				}
				}catch (JSONException e) {
					log.debug("=====JSON出错====="+e);
				}
			}
			returnStr=jsonArr.toString();
		}
		return returnStr;
	}
	
	
	/**
	 * 根据结点向上查询
	 * @param Integer eiid  需要查询的对象eiid
	 * @param Integer eiversion  对象版本
	 * @param Integer eismallversion  对象小版本
	 * @param Integer eirootmark  对象顶级eiid
	 * @param Integer levelNum  结点级别号
	 * @param Map<Integer,List<RelationTreeTB>> treeMap  存放结点map
	 */
	public Map<Integer,List<RelationTreeTB>> searchUpTreeNode(Integer eiid,Integer eiversion,Integer eismallversion,Integer eirootmark,
			Integer levelNum,Map<Integer,List<RelationTreeTB>> treeMap)throws BLException{
		//判断是否是顶级CI设备
		//查询出模型对象
		SOC0118Info soc0118Info=soc0118BL.searchEntityItemByKey(eiid);
		SOC0117Info soc0117Info=soc0117BL.searchEntityByKey(soc0118Info.getEid());
		RelationTreeTB tb=null;
		if(eiid.compareTo(eirootmark)==0){
			//生成结点对象
			
			List<RelationTreeTB> rtlist=new ArrayList<RelationTreeTB>();
			
			//查询下面是否还有值
			SOC0110SearchCondImpl cond0110=new SOC0110SearchCondImpl();
			cond0110.setBrpareiid(eiid+"");
			cond0110.setBrparversion(eiversion+"");
			cond0110.setBrparsmallversion(eismallversion+"");
			//所有关系码
			List<String> codeList=soc0110BL.searchBrassetrelationByBrpareiid(cond0110);
			if(codeList!=null&&codeList.size()>0){
				tb=new RelationTreeTB(eiid,soc0118Info.getEiname(),eirootmark,soc0117Info.getEname(),soc0117Info.getEid()+"",
						eiversion,eismallversion,eiid,IGCIMConstants.TREE_PARAMETER_ISLEAF_VALUE_TRUE,eirootmark);
			}else{
				tb=new RelationTreeTB(eiid,soc0118Info.getEiname(),eirootmark,soc0117Info.getEname(),soc0117Info.getEid()+"",
						eiversion,eismallversion,eiid,IGCIMConstants.TREE_PARAMETER_ISLEAF_VALUE_FALSE,eirootmark);
			}
			rtlist.add(tb);
			//向map中放入对象
			treeMap.put(levelNum-1, rtlist);
			
		}else{
			//如果不是，查询出该父亲结点
			//生成结点对象
			List<RelationTreeTB> rtlist=new ArrayList<RelationTreeTB>();
			//查询当前对象的父级对象
			SOC0110SearchCondImpl cond0110=new SOC0110SearchCondImpl();
			cond0110.setBrcldeiid(eiid+"");
			cond0110.setBrcldversion(eiversion+"");
			cond0110.setBrcldsmallversion(eismallversion+"");
			cond0110.setBrassetrelation_not("CR020001000001");
			List<SOC0110Info> soc0110InfoList=soc0110BL.searchEiBelongRelation(cond0110);
			
			//查询下面是否还有值
			cond0110=new SOC0110SearchCondImpl();
			cond0110.setBrpareiid(eiid+"");
			cond0110.setBrparversion(eiversion+"");
			cond0110.setBrparsmallversion(eismallversion+"");
			//所有关系码
			List<String> codeList=soc0110BL.searchBrassetrelationByBrpareiid(cond0110);
			
			//判断查询与之有关系的父级对象不为0
			if(soc0110InfoList!=null&&soc0110InfoList.size()>0){
				SOC0110Info soc0110Info=soc0110InfoList.get(0);
					//有子节点
					if(codeList!=null&&codeList.size()>0&&!"CM02060001".equals(soc0110Info.getCldEntityItemVW().getEid())){
						tb=new RelationTreeTB(eiid,soc0118Info.getEiname(),eirootmark,soc0117Info.getEname(),soc0117Info.getEid()+"",
								eiversion,eismallversion,soc0110Info.getBrpareiid(),IGCIMConstants.TREE_PARAMETER_ISLEAF_VALUE_TRUE,eirootmark);
					} 
					//无子节点
					else {
						tb=new RelationTreeTB(eiid,soc0118Info.getEiname(),eirootmark,soc0117Info.getEname(),soc0117Info.getEid()+"",
								eiversion,eismallversion,soc0110Info.getBrpareiid(),IGCIMConstants.TREE_PARAMETER_ISLEAF_VALUE_FALSE,eirootmark);
					}
					rtlist.add(tb);
					//向map中放入对象
					treeMap.put(levelNum-1, rtlist);
					//继续查询上级结点
					treeMap=searchUpTreeNode(soc0110Info.getBrpareiid(),soc0110Info.getBrparversion(),soc0110Info.getBrcldsmallversion(),eirootmark,
							levelNum-1,treeMap);
			}else{
				//有子节点
				if(codeList!=null&&codeList.size()>0){
					tb=new RelationTreeTB(eiid,soc0118Info.getEiname(),eirootmark,soc0117Info.getEname(),soc0117Info.getEid()+"",
							eiversion,eismallversion,eiid,IGCIMConstants.TREE_PARAMETER_ISLEAF_VALUE_FALSE,eirootmark);
				} 
				//无子节点
				else {
					tb=new RelationTreeTB(eiid,soc0118Info.getEiname(),eirootmark,soc0117Info.getEname(),soc0117Info.getEid()+"",
							eiversion,eismallversion,eiid,IGCIMConstants.TREE_PARAMETER_ISLEAF_VALUE_TRUE,eirootmark);
				}
				rtlist.add(tb);
				//向map中放入对象
				treeMap.put(levelNum-1, rtlist);
			}
		}
		return treeMap;
	}
	/**
	 * 根据结点向下查询出所有结点
	 * @param Integer eiid  需要查询的对象eiid
	 * @param Integer eiversion  对象版本
	 * @param Integer eismallversion  对象小版本
	 * @param Integer eirootmark  对象顶级eiid
	 * @param Integer levelNum  结点级别号
	 * @param Map<Integer,List<RelationTreeTB>> treeMap  存放结点map
	 */
	public Map<Integer,List<RelationTreeTB>> searchDownTreeNodeByEiid(Integer eiid,Integer eiversion,Integer eismallversion,Integer eirootmark,
			Integer levelNum,Map<Integer,List<RelationTreeTB>> treeMap)throws BLException{
		//查询是否有包含的关系子对象，如果有查出所有关系码
		SOC0110SearchCondImpl cond0110=new SOC0110SearchCondImpl();
		cond0110.setBrpareiid(eiid+"");
		cond0110.setBrparversion(eiversion+"");
		cond0110.setBrparsmallversion(eismallversion+"");
		cond0110.setEirootmark(eirootmark+"");
		//所有关系
		List<SOC0110Info> soc0110List=soc0110BL.searchMaxEiBelongRelation(cond0110);
		if(soc0110List!=null&&soc0110List.size()>0){
			//将关系模型放入树中
			List<RelationTreeTB> rtlist=new ArrayList<RelationTreeTB>();
			List<String>  formEiid_toEiid=new ArrayList<String>();
			for(SOC0110Info soc0110:soc0110List){
				//根据关系码查询关系详细信息
				SOC0152SearchCondImpl cond0152=new SOC0152SearchCondImpl();
				//包含关系码
				cond0152.setRlnType_eq(IGCIMConstants.TYPE_CODE_CONTAIN_RELATION);
				if("CM01010020".equals(soc0110.getParEntityItemVW().getEid())||
						"CM01010022".equals(soc0110.getParEntityItemVW().getEid())||
						"CM01010031".equals(soc0110.getParEntityItemVW().getEid())||
						"CM01010039".equals(soc0110.getParEntityItemVW().getEid())||
						"CM01010034".equals(soc0110.getParEntityItemVW().getEid())||
						"CM01010043".equals(soc0110.getParEntityItemVW().getEid())){
					cond0152.setFromModelEid_eq("CM01010001");
				}else{
					cond0152.setFromModelEid_eq(soc0110.getParEntityItemVW().getEid());
				}
				cond0152.setToModelEid_eq(soc0110.getCldEntityItemVW().getEid());
				String eiids=cond0152.getFromModelEid_eq()+"_"+cond0152.getToModelEid_eq();
				if(!formEiid_toEiid.contains(eiids)){
					formEiid_toEiid.add(eiids);
				}else{
					continue;
				}
				List<SOC0152Info> soc0152InfoList=soc0152BL.searchSOC0152(cond0152);
				if(soc0152InfoList!=null&soc0152InfoList.size()>0){
					for (SOC0152Info info : soc0152InfoList) {
						RelationTreeTB tb=new RelationTreeTB();
						tb.setEid(info.getToModelEid());
						tb.setEname(info.getToModelName());
						tb.setRlnCode(info.getRlnCode());
						tb.setFatherEiid(eiid);
						tb.setEiversion(eiversion);
						tb.setEismallversion(eismallversion);
						tb.setEirootmark(eirootmark);
						tb.setIsLeaf("false");
						tb.setSourceEiid(eirootmark);
						rtlist.add(tb);
					}
				}
			}
			//放入map中
			treeMap.put(levelNum+1, rtlist);
		}
		return treeMap;
	}
	/**
	 * 根据结点向下查询出所有结点
	 * @param Integer eiid  需要查询的对象eiid
	 * @param Integer eiversion  对象版本
	 * @param Integer eismallversion  对象小版本
	 * @param Integer eirootmark  对象顶级eiid
	 * @param Integer levelNum  结点级别号
	 * @param Map<Integer,List<RelationTreeTB>> treeMap  存放结点map
	 */
	public Map<Integer,List<RelationTreeTB>> searchDownTreeNodeByEid(String rlnCode,Integer fathereiid,Integer eiversion,Integer eismallversion,Integer eirootmark,
			Integer levelNum,Map<Integer,List<RelationTreeTB>> treeMap)throws BLException{
		//查询是否有包含的关系子对象，如果有查出所有关系码
		SOC0110SearchCondImpl cond0110=new SOC0110SearchCondImpl();
		cond0110.setBrpareiid(fathereiid+"");
		cond0110.setBrparversion(eiversion+"");
		cond0110.setBrparsmallversion(eismallversion+"");
		cond0110.setBrassetrelation(rlnCode);
		//所有子结点
		List<SOC0110Info> soc0110infoList=soc0110BL.searchEiBelongRelation(cond0110);
		if(soc0110infoList!=null&&soc0110infoList.size()>0){
			//将关系模型放入树中
			
			//首先查询是否还有子节点
			SOC0110Info fristInfo=soc0110infoList.get(0);
			SOC0123VW fristSoc0123vw=fristInfo.getCldEntityItemVW();
			//查询关系表
			SOC0152SearchCondImpl frist0152Cond=new SOC0152SearchCondImpl();
			//包含关系码
			frist0152Cond.setRlnType_eq(IGCIMConstants.TYPE_CODE_CONTAIN_RELATION);
			frist0152Cond.setFromModelEid_eq(fristSoc0123vw.getEid()+"");
			//查询结果集
			List<SOC0152Info> soc0152List=soc0152BL.searchSOC0152(frist0152Cond);
			//Map 判断是否有子节点的map
			Map<Integer, List<SOC0110Info>> isLeafMap=new HashMap<Integer, List<SOC0110Info>>();
		
			//如果查询出结果，那么该模型下还存在对象
			if(soc0152List!=null&&soc0152List.size()>0){
				StringBuilder sb=new StringBuilder();
				for (int i = 0; i < soc0152List.size(); i++) {
					String code=soc0152List.get(i).getRlnCode();
					if(i==(soc0152List.size()-1)){
						sb.append("'"+code+"'");
					}else{
						sb.append("'"+code+"'"+",");
					}
				}
				//查询该类型下是否有对象
				SOC0110SearchCondImpl soc0110Cond=new SOC0110SearchCondImpl();
				soc0110Cond.setEirootmark(eirootmark+"");
				soc0110Cond.setBrparversion(eiversion+"");
				soc0110Cond.setBrparsmallversion(eismallversion+"");
				soc0110Cond.setBrassetrelation_in(sb.toString());
				List<SOC0110Info> listtmp=soc0110BL.searchInBrassetrelationByEirootmark(soc0110Cond);
				if(listtmp!=null&&listtmp.size()>0){
					for (SOC0110Info info : listtmp) {
						Integer brpareiid=info.getBrpareiid();
						List<SOC0110Info> tmpList=isLeafMap.get(brpareiid);
						if(tmpList==null){
							tmpList=new ArrayList<SOC0110Info>();
						}
						tmpList.add(info);
						isLeafMap.put(brpareiid,tmpList);
					}
				}
			}
			List<RelationTreeTB> rtlist=new ArrayList<RelationTreeTB>();
			for (SOC0110Info info : soc0110infoList) {
				SOC0123VW soc0123vw=info.getCldEntityItemVW();
				RelationTreeTB tb=new RelationTreeTB();
				tb.setEiid(soc0123vw.getEiid());
				tb.setEiname(soc0123vw.getEiname());
				tb.setEirootmark(eirootmark);
				tb.setEid(soc0123vw.getEid()+"");
				tb.setFatherEiid(fathereiid);
				tb.setEiversion(eiversion);
				tb.setEismallversion(eismallversion);
				if(isLeafMap.containsKey(tb.getEiid())){
					tb.setIsLeaf("true");
				}else{
					tb.setIsLeaf("false");
				}
				rtlist.add(tb);
			}
			//放入map中
			treeMap.put(levelNum+1, rtlist);
		}
		return treeMap;
	}


	public IGCIM01DTO searchIGCIM0135Action(IGCIM01DTO dto) throws BLException {
		IGCIM0135Form form=dto.getIgcim0135Form();
		int num=1;
		StringBuffer pareiids=new StringBuffer();
		StringBuffer cldeiids=new StringBuffer();
		SOC0118SearchCondImpl soc0118cond=new SOC0118SearchCondImpl();
		List<SOC0118Info> soc0118InfoList=null;
		boolean flag=false;
		if(StringUtils.isNotEmpty(form.getEiname())){
			soc0118cond.setEiname(form.getEiname());
			soc0118cond.setEiorgsyscoding(form.getEiorgsyscoding());
			soc0118cond.setEsyscoding_eq("999010");
			soc0118InfoList=this.soc0118BL.searchEntityItem(soc0118cond);
			if(soc0118InfoList!=null&&soc0118InfoList.size()>0){
				for(SOC0118Info soc0118Info:soc0118InfoList){
					if(soc0118InfoList.size()==num){
						cldeiids.append(soc0118Info.getEiid());
					}else{
						cldeiids.append(soc0118Info.getEiid()).append(",");
					}
					num++;
				}
			}
			flag=true;
		}
		
		if(StringUtils.isNotEmpty(form.getBusinessName())){
			num=1;
			soc0118cond.setEiname(form.getBusinessName());
			soc0118cond.setEiorgsyscoding(form.getEiorgsyscoding());
			soc0118cond.setEsyscoding_eq("999003001");
			soc0118InfoList=this.soc0118BL.searchEntityItem(soc0118cond);
			if(soc0118InfoList!=null&&soc0118InfoList.size()>0){
				for(SOC0118Info soc0118Info:soc0118InfoList){
					if(soc0118InfoList.size()==num){
						pareiids.append(soc0118Info.getEiid());
					}else{
						pareiids.append(soc0118Info.getEiid()).append(",");
					}
					num++;
				}
			}
			flag=true;
		}
		
		SOC0119SearchCondImpl soc0119Cond=new SOC0119SearchCondImpl();
		soc0119Cond.setPareiids(pareiids.toString());
		soc0119Cond.setCldeiids(cldeiids.toString());
		soc0119Cond.setEirrelation("23");
		soc0119Cond.setFlag(flag);
		
		List<SOC0119Info> soc0119List = this.soc0119BL.searchMaxEntityItemRelation(soc0119Cond, 0, 0);
		if (soc0119List == null||soc0119List.size()==0) {
			log.debug("========需要查询的命令数据不存在========");
			//需要查询的命令数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		int totalCount=soc0119List.size();
		if ( soc0119List.size() > dto.getMaxSearchCount() ) {
			log.debug("========需要查询的命令数据过多========");
			//需要查询的命令数据过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		//分页用信息取得
		PagingDTO pDto = dto.getPagingDto();
		List<SOC0119Info> soc0119InfoList=this.soc0119BL.searchMaxEntityItemRelation(soc0119Cond, pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);
		dto.setSoc0119InfoList(soc0119InfoList);
		return dto;
	}

	public IGCIM01DTO searchIGCIM0139Action(IGCIM01DTO dto) throws BLException {
		IGCIM0139Form form=dto.getIgcim0139Form();
		int num=1;
		StringBuffer pareiids=new StringBuffer();
		StringBuffer cldeiids=new StringBuffer();
		SOC0118SearchCondImpl soc0118cond=new SOC0118SearchCondImpl();
		List<SOC0118Info> soc0118InfoList=null;
		boolean flag=false;
		if(StringUtils.isNotEmpty(form.getEiname())){
			soc0118cond.setEiname(form.getEiname());
			soc0118cond.setEiorgsyscoding(form.getEiorgsyscoding());
			soc0118cond.setEsyscoding_eq("999010");
			soc0118InfoList=this.soc0118BL.searchEntityItem(soc0118cond);
			if(soc0118InfoList!=null&&soc0118InfoList.size()>0){
				for(SOC0118Info soc0118Info:soc0118InfoList){
					if(soc0118InfoList.size()==num){
						cldeiids.append(soc0118Info.getEiid());
					}else{
						cldeiids.append(soc0118Info.getEiid()).append(",");
					}
					num++;
				}
			}
			flag=true;
		}
		
		if(StringUtils.isNotEmpty(form.getBusinessName())){
			num=1;
			soc0118cond.setEiname(form.getBusinessName());
			soc0118cond.setEiorgsyscoding(form.getEiorgsyscoding());
			soc0118cond.setEsyscoding_eq("999003001");
			soc0118InfoList=this.soc0118BL.searchEntityItem(soc0118cond);
			if(soc0118InfoList!=null&&soc0118InfoList.size()>0){
				for(SOC0118Info soc0118Info:soc0118InfoList){
					if(soc0118InfoList.size()==num){
						pareiids.append(soc0118Info.getEiid());
					}else{
						pareiids.append(soc0118Info.getEiid()).append(",");
					}
					num++;
				}
			}
			flag=true;
		}
		
		SOC0119SearchCondImpl soc0119Cond=new SOC0119SearchCondImpl();
		soc0119Cond.setPareiids(pareiids.toString());
		soc0119Cond.setCldeiids(cldeiids.toString());
		soc0119Cond.setEirrelation("23");
		soc0119Cond.setFlag(flag);
		
		List<SOC0119Info> soc0119List = this.soc0119BL.searchMaxEntityItemRelation(soc0119Cond, 0, 0);
		if (soc0119List == null||soc0119List.size()==0) {
			log.debug("========需要查询的命令数据不存在========");
			//需要查询的命令数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		int totalCount=soc0119List.size();
		if ( soc0119List.size() > dto.getMaxSearchCount() ) {
			log.debug("========需要查询的命令数据过多========");
			//需要查询的命令数据过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		//分页用信息取得
		PagingDTO pDto = dto.getPagingDto();
		List<SOC0119Info> soc0119InfoList=this.soc0119BL.searchMaxEntityItemRelation(soc0119Cond, pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);
		dto.setSoc0119InfoList(soc0119InfoList);
		return dto;
	}
	

	public IGCIM01DTO searchIGCIM0136Action(IGCIM01DTO dto) throws BLException {
		IGCIM0136Form form=dto.getIgcim0136Form();
		SOC0118SearchCondImpl soc0118Cond=new SOC0118SearchCondImpl();
		soc0118Cond.setTableName(form.getTableName());
		soc0118Cond.setTableSpaceName(form.getTableSpaceName());
		soc0118Cond.setInstanceName(form.getInstanceName());
		soc0118Cond.setBusinessName(form.getBusinessName());
		List<TableSpaceInfo> tableSpaceInfoCount=this.soc0118BL.searchTableRelationInfo(soc0118Cond,0,0); 
		if (tableSpaceInfoCount == null||tableSpaceInfoCount.size()==0) {
			log.debug("========需要查询的命令数据不存在========");
			//需要查询的命令数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		int totalCount=tableSpaceInfoCount.size();
		if ( tableSpaceInfoCount.size() > dto.getMaxSearchCount() ) {
			log.debug("========需要查询的命令数据过多========");
			//需要查询的命令数据过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		//分页用信息取得
		PagingDTO pDto = dto.getPagingDto();
		List<TableSpaceInfo> tableSpaceInfoList=this.soc0118BL.searchTableRelationInfo(soc0118Cond, pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);
		dto.setTableSpaceInfoList(tableSpaceInfoList);
		return dto;
	}


	public IGCIM01DTO initIGAIM0137Action(IGCIM01DTO dto) throws BLException {
		IGCIM0137Form form=dto.getIgcim0137Form();
		SOC0118Info soc0118Info=this.soc0118BL.searchEntityItemByKey(Integer.parseInt(form.getEiid()));
		if(soc0118Info!=null){
			form.setEiversion(soc0118Info.getEiversion()+"");
			form.setEismallversion(soc0118Info.getEismallversion()+"");
		}
		Map<Integer,List<RelationTreeTB>> treeMap=new LinkedHashMap<Integer, List<RelationTreeTB>>();
		int levelNum=100;
		String jsonStr=null;
		Integer eiid=Integer.parseInt(form.getEiid());
		Integer eirootmark=Integer.parseInt(form.getEirootmark());
		Integer eiversion=Integer.parseInt(form.getEiversion());
		Integer eismallversion=Integer.parseInt(form.getEismallversion());
		//向上查询
		treeMap=searchUpTreeNode(eiid,eiversion,eismallversion,eirootmark,levelNum,treeMap);
		//向下查询
		treeMap=searchDownTreeNodeByEiid(eiid,eiversion,eismallversion,eirootmark,levelNum,treeMap);
		//然后处理treeMap
		jsonStr=initChangeJsonObject(treeMap,levelNum);
		//设置初始化结点
		String initNodeId=getInitNodeId(treeMap,levelNum);
		dto.setInitTreeStr(jsonStr);
		dto.setInitNodeID(initNodeId);
		return dto;
	}
	/**初始化查询指标*/
	public IGCIM01DTO initIGCIM0155Action(IGCIM01DTO dto) throws BLException {
		return dto;
	}
	
	/**
	 * 阜新拓扑，取得应用关系树
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM01DTO getBusinessTree(IGCIM01DTO dto) throws BLException {
		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version='1.0' encoding='UTF-8' ?>");
		xml.append("<root>");
		xml.append("<node eiid='' eid='' name='业务系统' desc='业务系统' icon='bussImage'>");
		User user = dto.getUser();
		SOC0118SearchCondImpl cond0118 = new SOC0118SearchCondImpl();
		UserRoleVWSearchCondImpl rolecond = new UserRoleVWSearchCondImpl();
		rolecond.setUserid(user.getUserid());
		List<UserRoleInfo> urlist = userRoleBL.searchUserRoleVW(rolecond);
		boolean flag = false;//
		for(UserRoleInfo ur:urlist){
			//如果角色类型为耗材管理默认角色类型
			if(EntityItemKeyWords.ROLE_BUSINESS_MANAGER.equals(ur.getRoleid())){
					flag = true;
					break;
			}
			
		}
		if(!flag){
			cond0118.setMagName(dto.getUser().getUsername());
		}
		cond0118.setEid(EntityItemKeyWords.BUSINESS_EID);
		//取得所有业务系统
		List<SOC0118Info> businessList = soc0118BL.searchEntityItem(cond0118);

		if (businessList != null && businessList.size() >0 ) {
			int i=0;
			for (SOC0118Info info0118 : businessList) {
				if(i==0){
					dto.setEiid(info0118.getEiid().toString());
				}
				SOC0107SearchCondImpl cond0107 = new SOC0107SearchCondImpl();
		   		cond0107.setEiid(info0118.getEiid().toString());
		   		cond0107.setCiversion(info0118.getEiversion().toString());
		   		cond0107.setCismallversion(info0118.getEismallversion().toString());
		   		cond0107.setCid("CI030100010023");
		   		List<SOC0107Info> info0107_list=soc0107BL.searchSOC0107(cond0107);
		   		if(info0107_list == null){continue;}
		   		if(info0107_list.size() == 0){continue;}
		   		if(info0107_list.get(0).getCivalue().equals("是")){
		   			xml.append("<node eiid='" + info0118.getEiid() + "' eid='" + info0118.getEid() + "' name='" + info0118.getEiname() + "' desc='' icon='appImage'>");
		   			searchCldTreeNode(xml, info0118);
		   		}else{
		   			continue;
		   		}
				xml.append("</node>");
				i++;
			}
		}
		xml.append("</node>");
		xml.append("</root>");
		String treeXml = xml.toString();
		dto.setTreeXml(treeXml);
		return dto;
	}

	/**
	 * 阜新拓扑，查询业务系统关系树子节点
	 * @param xml
	 * @param info0118
	 * @throws BLException
	 */
	private void searchCldTreeNode(StringBuffer xml, SOC0118Info info0118) throws BLException {
		SOC0119SearchCondImpl cond0119 = new SOC0119SearchCondImpl();
		cond0119.setPareiid(info0118.getEiid());
		cond0119.setParversion(info0118.getEiversion());
		cond0119.setParsmallversion(info0118.getEismallversion());
		cond0119.setDeleteflag("0");
		List<SOC0119Info> soc0119List = soc0119BL.searchMaxEntityItemRelation(cond0119);
		if (soc0119List != null && soc0119List.size() > 0) {
			for (SOC0119Info info0119 : soc0119List) {
				//保留应用-服务的关系
				if (EntityItemKeyWords.APP_SERVICE_RelationCODE.equals(info0119.getEirrelationcode())) {
					if(!EntityItemKeyWords.BUSINESS_BUSINESS_Relation.equals(info0119.getEirrelation())
							&&!EntityItemKeyWords.BUSINESS_OTHER_Relation.equals(info0119.getEirrelation())
							&&!EntityItemKeyWords.BUSINESS_MODULE_Relation.equals(info0119.getEirrelation())
							&&!EntityItemKeyWords.BUSINESS_SP_Relation.equals(info0119.getEirrelation())
							&&!EntityItemKeyWords.BUSINESS_SI_Relation.equals(info0119.getEirrelation())){
						SOC0118Info soc0118Info = soc0118BL.searchEntityItemByKey(info0119.getCldeiid());
						String icon = "webappImage";
						if(EntityItemKeyWords.SERVICE_PROVIDER_EID.equals(soc0118Info.getEid())){
							icon = "srvproviderImage";
						} else {
							icon = "srvcallerImage";
						}
						SOC0107SearchCondImpl cond0107 = new SOC0107SearchCondImpl();
				   		cond0107.setEiid(info0118.getEiid().toString());
				   		cond0107.setCiversion(info0118.getEiversion().toString());
				   		cond0107.setCismallversion(info0118.getEismallversion().toString());
				   		cond0107.setCid("CI030100010023");
				   		List<SOC0107Info> info0107_list=soc0107BL.searchSOC0107(cond0107);
				   		if(info0107_list == null){continue;}
				   		if(info0107_list.size() == 0){continue;}
				   		if(info0107_list.get(0).getCivalue().equals("是")){
				   			xml.append("<node eiid='" + soc0118Info.getEiid() + "' eid='" + soc0118Info.getEid() + "' name='" + soc0118Info.getEiname() + "' desc='' icon='" + icon + "'>");
				   			searchCldTreeNode(xml, soc0118Info);
				   		}else{
					   		continue;
					   	}
						xml.append("</node>");
					}
				}
			}
		}
	}
	
	/**
	 *	阜新拓扑，应用关系登记初始化
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO initIGCIM0152Action(IGCIM01DTO dto) throws BLException {
		log.debug("========应用关系登记初始化处理开始========");
		List<LabelValueBean> lvList = new ArrayList<LabelValueBean>();
		lvList.add(new LabelValueBean("",""));
		dto.setRelationList(lvList);
		IGCIM0152Form form = dto.getIgcim0152Form();
		Integer eiid = form.getPareiid();
		if (eiid == null || eiid ==0) {
			return dto;
		}
		SOC0118Info info = soc0118BL.searchEntityItemByKey(eiid);
		form.setPareid(info.getEid());
		form.setPareilabel(info.getEilabel());
		form.setPareiname(info.getEiname());
		form.setParversion(info.getEiversion());
		form.setParsmallversion(info.getEismallversion());
		String eid = info.getEid();
		List<LabelValueBean> list = this.codeDetailBL.searchLabelValueBeanList(CommonDefineUtils.ENTIY_CATEGORY_APPLICATION,CodeDefine.getCodeDefine("ENTITYITEM_RELATION_CODE").getCcid());
		if (list != null && list.size() >0) {
			String type = form.getType();//service：应用-服务；software：应用-软件
			for (LabelValueBean lv : list) {
				String value = lv.getValue();
				//应用-服务
				if ("service".equals(type) && value.endsWith(EntityItemKeyWords.APP_SERVICE_RelationCODE)) {
					//from业务系统,业务系统-服务提供者或业务系统-服务调用者
					if (EntityItemKeyWords.BUSINESS_EID.equals(eid)) {
						if (value.startsWith(EntityItemKeyWords.BUSINESS_SP_Relation) ||
								value.startsWith(EntityItemKeyWords.BUSINESS_SI_Relation)||
								value.startsWith(EntityItemKeyWords.BUSINESS_BUSINESS_Relation)||
								value.startsWith(EntityItemKeyWords.BUSINESS_OTHER_Relation)||
								value.startsWith(EntityItemKeyWords.BUSINESS_MODULE_Relation)) {
							lvList.add(lv);
						}
					}
					//from服务提供者,服务提供者-服务调用者
					if (EntityItemKeyWords.SERVICE_PROVIDER_EID.equals(eid)) {
						if (value.startsWith(EntityItemKeyWords.SP_SI_Relation)) {
							lvList.add(lv);
						}
					}
					//from服务调用者,服务提供者-服务调用者
					if (EntityItemKeyWords.SERVICE_INVOKER_EID.equals(eid)) {
						if (value.startsWith(EntityItemKeyWords.SP_SI_Relation)) {
							lvList.add(lv);
						}
					}
				}
				
				//应用-软件
				if ("software".equals(type) && (value.endsWith(EntityItemKeyWords.APP_SW_RelationCODE)
						||value.endsWith(EntityItemKeyWords.APP_VM_RelationCODE))) {
					lvList.add(lv);
				}
			}
		}
		log.debug("========应用关系登记初始化处理终了========");
		return dto;
	}
	
	/**
	 * 阜新拓扑，应用关系登记处理
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO insertEntityItemRelationActionApp2(IGCIM01DTO dto) throws BLException {
		log.debug("========应用关系登记处理开始========");
		
		IGCIM0152Form form = dto.getIgcim0152Form();
		SOC0118Info soc0118Info=soc0118BL.searchEntityItemByKey(form.getPareiid());
		//应用ID（子）取得
		SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
		
		cond.setElabel(form.getElabel());
		cond.setEilabel(form.getEilabel());
		
		List<SOC0124Info> entityItemVWList = this.soc0118BL.searchEntityItemVW(cond, 0, 0);
		
		if ( entityItemVWList==null || entityItemVWList.size() == 0 ) {
			throw new BLException("IGCO10000.E004",resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.010")
					+ form.getElabel() + resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.011") 
					+ form.getEilabel() + resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.012"));
		}
		
		form.setCldeiid(entityItemVWList.get(0).getEiid());
		form.setCldeid(entityItemVWList.get(0).getEid());
		form.setCldversion(entityItemVWList.get(0).getEiversion());
		form.setCldsmallversion(entityItemVWList.get(0).getEismallversion());
		//应用ID（父）和（子）检测
		if (form.getPareiid().intValue() == form.getCldeiid().intValue()) {
			//应用ID（父）= （子）
			throw new BLException(BLErrorType.ENTITY_ITEM_RELATION_ERROR,
					"IGCO10000.E012",resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.004"));
		}
		
		//更新时间设定
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

		form.setEirupdtime(datetime);
		
		//资产关系登记      20120731 add 重复关系验证
		SOC0119SearchCondImpl condeir =new SOC0119SearchCondImpl();
		condeir.setPareiid(form.getPareiid());
		condeir.setCldeiid(form.getCldeiid());
		condeir.setEirrelationcode(form.getEirrelationcode());
		condeir.setDeleteflag("0");
		List<SOC0119Info> list_eir=this.soc0119BL.searchEntityItemRelation(condeir);
		condeir =new SOC0119SearchCondImpl();
		condeir.setCldeiid(form.getPareiid());
		condeir.setPareiid(form.getCldeiid());
		condeir.setEirrelationcode(form.getEirrelationcode());
		condeir.setDeleteflag("0");
		List<SOC0119Info> list_eirCld=this.soc0119BL.searchEntityItemRelation(condeir);
		if(list_eir.size()>0||list_eirCld.size()>0){
			throw new BLException(BLErrorType.ENTITY_ITEM_RELATION_ERROR,"IGASM0307.E001",resources.getMessage(dto.getLocale(),"message.IGASM03BLImpl.020"));
		}
		SOC0119Info ret = 
			this.soc0119BL.registEntityItemRelation(dto.getIgcim0152Form());
		//判断是创建业务系统与web应用的关系时，同时建立业务系统与主机、业务系统与web服务器的关系
		if("CR030001000002".equals(form.getEirrelation())){
			createEntityItemRelationActionAppToWebServer(form,entityItemVWList.get(0));
			createEntityItemRelationActionAppToHost(form,entityItemVWList.get(0));
		}else if("CR030001000003".equals(form.getEirrelation())){
			createEntityItemRelationActionAppToWEBAPP2(form,entityItemVWList.get(0));
			createEntityItemRelationActionAppToHost(form,entityItemVWList.get(0));
		}
		dto.setEntityItemRelation(ret);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.013")) );
		
		log.debug("========应用关系登记处理终了========");
		return dto;
	}
	
	/**
	 * 阜新拓扑，创建业务系统与Web服务器之间的关系
	 * @param form
	 * @param soc0124Info
	 * @throws BLException
	 */
	public void createEntityItemRelationActionAppToWebServer(IGCIM0152Form form,SOC0124Info soc0124Info) throws BLException {
		SOC0110SearchCondImpl soc0110Cond=new SOC0110SearchCondImpl();
		soc0110Cond.setBrcldeiid(soc0124Info.getEiid()+"");
		soc0110Cond.setBrcldversion(soc0124Info.getEiversion()+"");
		soc0110Cond.setBrcldsmallversion(soc0124Info.getEismallversion()+"");
		soc0110Cond.setBrassetrelation("CR020002000001");
		List<SOC0110Info> soc0110InfoList=this.soc0110BL.searchEiBelongRelation(soc0110Cond);
		if(soc0110InfoList!=null&&soc0110InfoList.size()>0){
			SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
			List<String> eiidList=new ArrayList<String>();
			eiidList.add(soc0110InfoList.get(0).getBrpareiid()+"");
			cond.setEiidList(eiidList);
			List<SOC0124Info> entityItemVWList = this.soc0118BL.searchEntityItemVW(cond, 0, 0);
			if ( entityItemVWList==null || entityItemVWList.size() == 0 ) {
				throw new BLException("IGCO10000.E004","Web服务器");
			}
			form.setCldeiid(entityItemVWList.get(0).getEiid());
			form.setCldeid(entityItemVWList.get(0).getEid());
			form.setCldversion(entityItemVWList.get(0).getEiversion());
			form.setCldsmallversion(entityItemVWList.get(0).getEismallversion());
			form.setEirrelation("CR030001000004");
			//更新时间设定
			Date nowDateTime = new Date();
			String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

			form.setEirupdtime(datetime);
			
			//资产关系登记      20120731 add 重复关系验证
			SOC0119SearchCondImpl condeir =new SOC0119SearchCondImpl();
			condeir.setPareiid(form.getPareiid());
			condeir.setCldeiid(form.getCldeiid());
			condeir.setEirrelationcode(form.getEirrelationcode());
			condeir.setDeleteflag("0");
			List<SOC0119Info> list_eir=this.soc0119BL.searchEntityItemRelation(condeir);
			condeir =new SOC0119SearchCondImpl();
			condeir.setCldeiid(form.getPareiid());
			condeir.setPareiid(form.getCldeiid());
			condeir.setEirrelationcode(form.getEirrelationcode());
			condeir.setDeleteflag("0");
			List<SOC0119Info> list_eirCld=this.soc0119BL.searchEntityItemRelation(condeir);
			if(list_eir.size()>0||list_eirCld.size()>0){
			}else{
				this.soc0119BL.registEntityItemRelation(form);
			}
			createEntityItemRelationWebToAppServer(form,entityItemVWList.get(0));
		}
	}
	
	/**
	 * 阜新拓扑，创建业务系统与Web服务器之间的关系
	 * @param form
	 * @param soc0124Info
	 * @throws BLException
	 */
	public void createEntityItemRelationWebToAppServer(IGCIM0152Form form,SOC0124Info soc0124Info) throws BLException {
		SOC0110SearchCondImpl soc0110Cond=new SOC0110SearchCondImpl();
		soc0110Cond.setBrcldeiid(soc0124Info.getEiid()+"");
		soc0110Cond.setBrcldversion(soc0124Info.getEiversion()+"");
		soc0110Cond.setBrcldsmallversion(soc0124Info.getEismallversion()+"");
		soc0110Cond.setBrassetrelation("CR020001000001");
		List<SOC0110Info> soc0110InfoList=this.soc0110BL.searchEiBelongRelation(soc0110Cond);
		if(soc0110InfoList!=null&&soc0110InfoList.size()>0){
			for(SOC0110Info soc0110Info:soc0110InfoList){
				SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
				List<String> eiidList=new ArrayList<String>();
				eiidList.add(soc0110Info.getBrpareiid()+"");
				cond.setEiidList(eiidList);
				List<SOC0124Info> entityItemVWList = this.soc0118BL.searchEntityItemVW(cond, 0, 0);
				if ( entityItemVWList==null || entityItemVWList.size() == 0 ) {
				}else{
					form.setCldeiid(entityItemVWList.get(0).getEiid());
					form.setCldeid(entityItemVWList.get(0).getEid());
					form.setCldversion(entityItemVWList.get(0).getEiversion());
					form.setCldsmallversion(entityItemVWList.get(0).getEismallversion());
					form.setEirrelation("CR030001000001");
					form.setEirrelationcode("003-002");
					//更新时间设定
					Date nowDateTime = new Date();
					String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

					form.setEirupdtime(datetime);
					
					//资产关系登记      20120731 add 重复关系验证
					SOC0119SearchCondImpl condeir =new SOC0119SearchCondImpl();
					condeir.setPareiid(form.getPareiid());
					condeir.setCldeiid(form.getCldeiid());
					condeir.setEirrelationcode(form.getEirrelationcode());
					condeir.setDeleteflag("0");
					List<SOC0119Info> list_eir=this.soc0119BL.searchEntityItemRelation(condeir);
					condeir =new SOC0119SearchCondImpl();
					condeir.setCldeiid(form.getPareiid());
					condeir.setPareiid(form.getCldeiid());
					condeir.setEirrelationcode(form.getEirrelationcode());
					condeir.setDeleteflag("0");
					List<SOC0119Info> list_eirCld=this.soc0119BL.searchEntityItemRelation(condeir);
					if(list_eir.size()>0||list_eirCld.size()>0){
					}else{
						this.soc0119BL.registEntityItemRelation(form);
					}
					createEntityItemRelationAppToHostByWebServer(form,entityItemVWList.get(0));
				}
			}
		}
	}
	
	public void createEntityItemRelationAppToHostByWebServer(IGCIM0152Form form,SOC0124Info soc0124Info) throws BLException {
		SOC0110SearchCondImpl soc0110Cond=new SOC0110SearchCondImpl();
		soc0110Cond.setBrcldeiid(soc0124Info.getEiid()+"");
		soc0110Cond.setBrcldversion(soc0124Info.getEiversion()+"");
		soc0110Cond.setBrcldsmallversion(soc0124Info.getEismallversion()+"");
		soc0110Cond.setBrassetrelation("CR010100010024");
		List<SOC0110Info> soc0110InfoList=this.soc0110BL.searchEiBelongRelation(soc0110Cond);
		if(soc0110InfoList!=null&&soc0110InfoList.size()>0){
			for(SOC0110Info soc0110Info:soc0110InfoList){
				SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
				List<String> eiidList=new ArrayList<String>();
				eiidList.add(soc0110Info.getBrpareiid()+"");
				cond.setEiidList(eiidList);
				List<SOC0124Info> entityItemVWList = this.soc0118BL.searchEntityItemVW(cond, 0, 0);
				if ( entityItemVWList==null || entityItemVWList.size() == 0 ) {
				}else{
					form.setCldeiid(entityItemVWList.get(0).getEiid());
					form.setCldeid(entityItemVWList.get(0).getEid());
					form.setCldversion(entityItemVWList.get(0).getEiversion());
					form.setCldsmallversion(entityItemVWList.get(0).getEismallversion());
					form.setEirrelation("CR030100010001");
					form.setEirrelationcode("003-001");
					//更新时间设定
					Date nowDateTime = new Date();
					String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

					form.setEirupdtime(datetime);
					
					//资产关系登记      20120731 add 重复关系验证
					SOC0119SearchCondImpl condeir =new SOC0119SearchCondImpl();
					condeir.setPareiid(form.getPareiid());
					condeir.setCldeiid(form.getCldeiid());
					condeir.setEirrelationcode("003-001");
					condeir.setDeleteflag("0");
					List<SOC0119Info> list_eir=this.soc0119BL.searchEntityItemRelation(condeir);
					condeir =new SOC0119SearchCondImpl();
					condeir.setCldeiid(form.getPareiid());
					condeir.setPareiid(form.getCldeiid());
					condeir.setEirrelationcode("003-001");
					condeir.setDeleteflag("0");
					List<SOC0119Info> list_eirCld=this.soc0119BL.searchEntityItemRelation(condeir);
					if(list_eir.size()>0||list_eirCld.size()>0){
					}else{
						this.soc0119BL.registEntityItemRelation(form);
					}
				}
			}
		}
	}
	
	public void createEntityItemRelationAppToHostByWebServer(IGCIM0127Form form,SOC0124Info soc0124Info) throws BLException {
		SOC0110SearchCondImpl soc0110Cond=new SOC0110SearchCondImpl();
		soc0110Cond.setBrcldeiid(soc0124Info.getEiid()+"");
		soc0110Cond.setBrcldversion(soc0124Info.getEiversion()+"");
		soc0110Cond.setBrcldsmallversion(soc0124Info.getEismallversion()+"");
		soc0110Cond.setBrassetrelation("CR010100010024");
		List<SOC0110Info> soc0110InfoList=this.soc0110BL.searchEiBelongRelation(soc0110Cond);
		if(soc0110InfoList!=null&&soc0110InfoList.size()>0){
			for(SOC0110Info soc0110Info:soc0110InfoList){
				SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
				List<String> eiidList=new ArrayList<String>();
				eiidList.add(soc0110Info.getBrpareiid()+"");
				cond.setEiidList(eiidList);
				List<SOC0124Info> entityItemVWList = this.soc0118BL.searchEntityItemVW(cond, 0, 0);
				if ( entityItemVWList==null || entityItemVWList.size() == 0 ) {
				}else{
					form.setCldeiid(entityItemVWList.get(0).getEiid());
					form.setCldeid(entityItemVWList.get(0).getEid());
					form.setCldversion(entityItemVWList.get(0).getEiversion());
					form.setCldsmallversion(entityItemVWList.get(0).getEismallversion());
					form.setEirrelation("CR030100010001");
					form.setEirrelationcode("003-001");
					//更新时间设定
					Date nowDateTime = new Date();
					String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

					form.setEirupdtime(datetime);
					
					//资产关系登记      20120731 add 重复关系验证
					SOC0119SearchCondImpl condeir =new SOC0119SearchCondImpl();
					condeir.setPareiid(form.getPareiid());
					condeir.setCldeiid(form.getCldeiid());
					condeir.setEirrelationcode("003-001");
					condeir.setDeleteflag("0");
					List<SOC0119Info> list_eir=this.soc0119BL.searchEntityItemRelation(condeir);
					condeir =new SOC0119SearchCondImpl();
					condeir.setCldeiid(form.getPareiid());
					condeir.setPareiid(form.getCldeiid());
					condeir.setEirrelationcode("003-001");
					condeir.setDeleteflag("0");
					List<SOC0119Info> list_eirCld=this.soc0119BL.searchEntityItemRelation(condeir);
					if(list_eir.size()>0||list_eirCld.size()>0){
					}else{
						this.soc0119BL.registEntityItemRelation(form);
					}
				}
			}
		}
	}
	
	/**
	 * 阜新拓扑，创建业务系统与主机之间的关系
	 * @param form
	 * @param soc0124Info
	 * @throws BLException
	 */
	public void createEntityItemRelationActionAppToHost2(IGCIM0152Form form,SOC0124Info soc0124Info) throws BLException {
		SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
		List<String> eiidList=new ArrayList<String>();
		eiidList.add(soc0124Info.getEirootmark()+"");
		cond.setEiidList(eiidList);
		List<SOC0124Info> entityItemVWList = this.soc0118BL.searchEntityItemVW(cond, 0, 0);
		if ( entityItemVWList==null || entityItemVWList.size() == 0 ) {
			throw new BLException("IGCO10000.E004","主机");
		}
		form.setCldeiid(entityItemVWList.get(0).getEiid());
		form.setCldeid(entityItemVWList.get(0).getEid());
		form.setCldversion(entityItemVWList.get(0).getEiversion());
		form.setCldsmallversion(entityItemVWList.get(0).getEismallversion());
		form.setEirrelation("CR030100010001");
		form.setEirrelationcode("003-001");
		//更新时间设定
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

		form.setEirupdtime(datetime);
		
		//资产关系登记      20120731 add 重复关系验证
		SOC0119SearchCondImpl condeir =new SOC0119SearchCondImpl();
		condeir.setPareiid(form.getPareiid());
		condeir.setCldeiid(form.getCldeiid());
		condeir.setEirrelationcode(form.getEirrelationcode());
		condeir.setDeleteflag("0");
		List<SOC0119Info> list_eir=this.soc0119BL.searchEntityItemRelation(condeir);
		condeir =new SOC0119SearchCondImpl();
		condeir.setCldeiid(form.getPareiid());
		condeir.setPareiid(form.getCldeiid());
		condeir.setEirrelationcode(form.getEirrelationcode());
		condeir.setDeleteflag("0");
		List<SOC0119Info> list_eirCld=this.soc0119BL.searchEntityItemRelation(condeir);
		if(list_eir.size()>0||list_eirCld.size()>0){
		}else{
			this.soc0119BL.registEntityItemRelation(form);
		}
	}
	
	/**
	 * 阜新拓扑，创建业务系统与webapp
	 * @param form
	 * @param soc0124Info
	 */
	private void createEntityItemRelationActionAppToWEBAPP2(IGCIM0152Form form,
			SOC0124Info soc0124Info) throws BLException {
		SOC0110SearchCondImpl soc0110Cond=new SOC0110SearchCondImpl();
		soc0110Cond.setBrcldeiid(soc0124Info.getEiid()+"");
		soc0110Cond.setBrcldversion(soc0124Info.getEiversion()+"");
		soc0110Cond.setBrcldsmallversion(soc0124Info.getEismallversion()+"");
		soc0110Cond.setBrassetrelation("CR020004000001");
		List<SOC0110Info> soc0110InfoList=this.soc0110BL.searchEiBelongRelation(soc0110Cond);
		if(soc0110InfoList!=null&&soc0110InfoList.size()>0){
			SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
			List<String> eiidList=new ArrayList<String>();
			eiidList.add(soc0110InfoList.get(0).getBrpareiid()+"");
			cond.setEiidList(eiidList);
			List<SOC0124Info> entityItemVWList = this.soc0118BL.searchEntityItemVW(cond, 0, 0);
			if ( entityItemVWList==null || entityItemVWList.size() == 0 ) {
				throw new BLException("IGCO10000.E004","数据库");
			}
			form.setCldeiid(entityItemVWList.get(0).getEiid());
			form.setCldeid(entityItemVWList.get(0).getEid());
			form.setCldversion(entityItemVWList.get(0).getEiversion());
			form.setCldsmallversion(entityItemVWList.get(0).getEismallversion());
			form.setEirrelation("CR030001000005");
			//更新时间设定
			Date nowDateTime = new Date();
			String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

			form.setEirupdtime(datetime);
			
			//资产关系登记      20120731 add 重复关系验证
			SOC0119SearchCondImpl condeir =new SOC0119SearchCondImpl();
			condeir.setPareiid(form.getPareiid());
			condeir.setCldeiid(form.getCldeiid());
			condeir.setEirrelationcode(form.getEirrelationcode());
			condeir.setDeleteflag("0");
			List<SOC0119Info> list_eir=this.soc0119BL.searchEntityItemRelation(condeir);
			condeir =new SOC0119SearchCondImpl();
			condeir.setCldeiid(form.getPareiid());
			condeir.setPareiid(form.getCldeiid());
			condeir.setEirrelationcode(form.getEirrelationcode());
			condeir.setDeleteflag("0");
			List<SOC0119Info> list_eirCld=this.soc0119BL.searchEntityItemRelation(condeir);
			if(list_eir.size()>0||list_eirCld.size()>0){
			}else{
				this.soc0119BL.registEntityItemRelation(form);
			}
		}
	}


	/**
	 * 关系类型查询
	 */
	public IGCIM01DTO searchRelationType(IGCIM01DTO dto) throws BLException {
//		IGCIM0107Form form = dto.getIgasm0307Form();
//		String esyscoding = form.getEsyscoding();
//		CodeDetailSearchCondImpl cond = new CodeDetailSearchCondImpl();
//		cond.setCcid(CodeDefine.BELONG_RELATION_TYPE.getCcid());
//		//设备
//		if(esyscoding.startsWith(EiRelationKeyWords.DEVICE)){
//			cond.setBusinesscode_like("001");
//		}
//		//软件
//		if(esyscoding.startsWith(EiRelationKeyWords.SOFTWARE)){
//			cond.setBusinesscode_like("002");
//		}
//		//应用
//		if(esyscoding.startsWith(EiRelationKeyWords.APP)){
//			cond.setBusinesscode_like("003");
//		}
//		List<CodeDetail> cdList = codeDetailBL.searchCodeDetail(cond, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_0);
//		List<LabelValueBean> list = new ArrayList<LabelValueBean>();
//		list.add(new LabelValueBean("", ""));
//		for(CodeDetail cd : cdList){
//			list.add(new LabelValueBean(cd.getCvalue(), cd.getCid()));
//		}
		List<LabelValueBean> lvList = new ArrayList<LabelValueBean>();
		lvList.add(new LabelValueBean("",""));
		IGCIM0107Form form=dto.getIgcim0107Form();
		List<LabelValueBean> list = this.codeDetailBL.searchLabelValueBeanList("002",CodeDefine.getCodeDefine("RELATIONCODE").getCcid());
		if(list!=null&&list.size()>0){
			for(LabelValueBean lv : list){
				String value=lv.getValue();
				if("999002003001".equals(form.getEsyscoding())){
					if(value.startsWith(EntityItemKeyWords.APP_Relation)){
						lvList.add(lv);
					}
				}else{
					if(!value.startsWith(EntityItemKeyWords.APP_Relation)&&StringUtils.isNotEmpty(value)){
						lvList.add(lv);
					}
				}
			}
		}
		dto.setRelationTypeList(lvList);
		dto.setRelationList(lvList);
		return dto;
	}
	
	
	/**
	 * 阜新拓扑，创建业务系统与Informix之间的关系
	 * @param form
	 * @param soc0124Info
	 * @throws BLException
	 */
	public void createEntityItemRelationActionAppToInformix(IGCIM0152Form form,SOC0124Info soc0124Info) throws BLException {
		SOC0110SearchCondImpl soc0110Cond=new SOC0110SearchCondImpl();
		soc0110Cond.setBrcldeiid(soc0124Info.getEiid()+"");
		soc0110Cond.setBrcldversion(soc0124Info.getEiversion()+"");
		soc0110Cond.setBrcldsmallversion(soc0124Info.getEismallversion()+"");
		soc0110Cond.setBrassetrelation("CR020300010001");
		List<SOC0110Info> soc0110InfoList=this.soc0110BL.searchEiBelongRelation(soc0110Cond);
		if(soc0110InfoList!=null&&soc0110InfoList.size()>0){
			SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
			List<String> eiidList=new ArrayList<String>();
			eiidList.add(soc0110InfoList.get(0).getBrpareiid()+"");
			cond.setEiidList(eiidList);
			List<SOC0124Info> entityItemVWList = this.soc0118BL.searchEntityItemVW(cond, 0, 0);
			if ( entityItemVWList==null || entityItemVWList.size() == 0 ) {
				throw new BLException("IGCO10000.E004","Informix");
			}
			form.setCldeiid(entityItemVWList.get(0).getEiid());
			form.setCldeid(entityItemVWList.get(0).getEid());
			form.setCldversion(entityItemVWList.get(0).getEiversion());
			form.setCldsmallversion(entityItemVWList.get(0).getEismallversion());
			form.setEirrelation("CR030100010011");
			//更新时间设定
			Date nowDateTime = new Date();
			String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

			form.setEirupdtime(datetime);
			
			//资产关系登记      20120731 add 重复关系验证
			SOC0119SearchCondImpl condeir =new SOC0119SearchCondImpl();
			condeir.setPareiid(form.getPareiid());
			condeir.setCldeiid(form.getCldeiid());
			condeir.setEirrelationcode(form.getEirrelationcode());
			condeir.setDeleteflag("0");
			List<SOC0119Info> list_eir=this.soc0119BL.searchEntityItemRelation(condeir);
			condeir =new SOC0119SearchCondImpl();
			condeir.setCldeiid(form.getPareiid());
			condeir.setPareiid(form.getCldeiid());
			condeir.setEirrelationcode(form.getEirrelationcode());
			condeir.setDeleteflag("0");
			List<SOC0119Info> list_eirCld=this.soc0119BL.searchEntityItemRelation(condeir);
			if(list_eir.size()>0||list_eirCld.size()>0){
			}else{
				this.soc0119BL.registEntityItemRelation(form);
			}
		}
	}
	
	
	/**
	 * get Item Images Info By Code Detail table
	 * @return
	 */
	private Map<String, String> getItemImagesInfoByCodeDetail(){
		CodeDetailSearchCondImpl cond=new CodeDetailSearchCondImpl();
		cond.setCcid("002");
		Map<String, String> imageMap = null;
		List<CodeDetail> imageInfolist = this.codeDetailBL.searchCodeDetail(cond, 0);
		if(imageInfolist != null && imageInfolist.size() != 0){
			imageMap = new HashMap<String, String>();
			for(CodeDetail codeDetail : imageInfolist){
				String keys[] = codeDetail.getCdinfo().split("_");
				if(keys.length == 3){
					imageMap.put(keys[0], codeDetail.getCvalue());
					//imageMap.put(keys[1]+"_"+keys[2], codeDetail.getCvalue());
				}else{
					imageMap.put(codeDetail.getCdinfo(), codeDetail.getCvalue());
				}
			}
		}
		return imageMap;
	}
	
	/**
	 * get Item Image By Name
	 * @param jsonObject
	 * @param itemImageMap
	 * @param key
	 * @return
	 * @throws JSONException
	 */
	private JSONObject getItemImageByName(JSONObject jsonObject, Map<String, 
			String> itemImageMap, String key, String isLeaf, boolean isModule, String deviceCode) throws JSONException{
		
//		if ("CM02060001".equals(deviceCode)) {
//			jsonObject.put(IGCIMConstants.TREE_PARAMETER_ICONSKIN,
//					IGCIMConstants.TREE_PARAMETER_ICONSKIN_LEAFICON);
//			log.info(" >> >> " + jsonObject.toString());
//			return jsonObject;
//		}
		//判断是否是叶子节点
		if (!IGCIMConstants.TREE_PARAMETER_ISLEAF_VALUE_TRUE.equals(isLeaf)&&!isModule) {
			if(itemImageMap.get(key)!=null){
				jsonObject.put(IGCIMConstants.TREE_PARAMETER_ICONSKIN, itemImageMap.get(key)+"leaf");
			}else{
				jsonObject.put(IGCIMConstants.TREE_PARAMETER_ICONSKIN,
						IGCIMConstants.TREE_PARAMETER_ICONSKIN_LEAFICON);
			}
		} else {
			if (itemImageMap != null && itemImageMap.containsKey(key)&& isModule) {
				//是模型节点，并且能获取到图片信息
				jsonObject.put(IGCIMConstants.TREE_PARAMETER_ICONSKIN,
						itemImageMap.get(key));

			} else if (itemImageMap != null && !itemImageMap.containsKey(key)
					&& isModule) {
				//是模型节点，并且不能获取到图片信息
				jsonObject.put(IGCIMConstants.TREE_PARAMETER_ICONSKIN,
						"modeliconCOMMON");
			} else {
				if (IGCIMConstants.TREE_PARAMETER_ISLEAF_VALUE_TRUE
						.equals(isLeaf)) {
					if(itemImageMap.get(key)!=null){
						jsonObject.put(IGCIMConstants.TREE_PARAMETER_ICONSKIN,
								itemImageMap.get(key));
					}else{
						jsonObject.put(IGCIMConstants.TREE_PARAMETER_ICONSKIN,
								IGCIMConstants.TREE_PARAMETER_ICONSKIN_FATHERICON);
					}
				} else {
//					if ("CM02060001".equals(deviceCode)) {
//						jsonObject.put(IGCIMConstants.TREE_PARAMETER_OPEN, IGCIMConstants.TREE_PARAMETER_OPEN_VALUE_FALSE);
//					}
					if(itemImageMap.get(key)!=null){
						jsonObject.put(IGCIMConstants.TREE_PARAMETER_ICONSKIN, itemImageMap.get(key)+"leaf");
					}else{
						jsonObject.put(IGCIMConstants.TREE_PARAMETER_ICONSKIN,
								IGCIMConstants.TREE_PARAMETER_ICONSKIN_LEAFICON);
					}
				}
			}
		}

		return jsonObject;
	}
	
	
	/**
	 * 查找
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM01DTO searchSoc0153List(IGCIM01DTO dto)throws BLException{
		
		
		log.debug("========日志信息查询处理开始========");
		
		SOC0153SearchCondImpl cond = new SOC0153SearchCondImpl();
		
		dto = searchSoc0113Info(dto);
		
		if("1".equals(dto.getWarnType())){
			BeanUtils.copyProperties(dto.getIgcim0160Form(), cond);
			
		}else{
			BeanUtils.copyProperties(dto.getIgcim0161Form(), cond);
		}
		
		cond.setWarnType(dto.getWarnType());

		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		String sDate = cond.getsDate();
		String eDate = cond.geteDate();
		try {
			if (StringUtils.isNotEmpty(sDate)) {
				cond.setsDate(sdf2.format(sdf1.parse(sDate)));
			}
			if (StringUtils.isNotEmpty(eDate)) {
				cond.seteDate(sdf2.format(sdf1.parse(eDate)));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		int totalCount = soc0153BL.getSearchCount(cond);
		if (totalCount == 0) {
			log.debug("========日志查询数据不存在========");
			//查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========日志信息查询数据件数过多========");
			//查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		
		//分页用信息取得
			PagingDTO pDto = dto.getPagingDto();
			
			//当前页应用信息取得
			List<SOC0153Info> soc0153List = soc0153BL.searchSoc0153(cond, pDto.getFromCount(), pDto.getPageDispCount());
			
			pDto.setTotalCount(totalCount);
			
			dto.setSoc0153List(soc0153List);
			
			dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));

			log.debug("========日志信息查询处理结束========");
		return dto;
		
		
	}

	/**
	 * 查询业务系统管理人员缺失
	 */
	public IGCIM01DTO searchIGCIM0140Action(IGCIM01DTO dto) throws BLException {
		
		log.debug("========业务系统管理人员缺失信息查询处理开始========");
		
		PlatformManagerVWSearchCondImpl cond = new PlatformManagerVWSearchCondImpl();
		
		BeanUtils.copyProperties(dto.getIgcim0140Form(), cond);
		platformManagerBL.getCount(cond);
		int totalCount = platformManagerBL.getCount(cond);
		if (totalCount == 0) {
			log.debug("========业务系统管理人员缺失查询数据不存在========");
			//查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========业务系统管理人员缺失信息查询数据件数过多========");
			//查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		
		//分页用信息取得
			PagingDTO pDto = dto.getPagingDto();
			
			//当前页应用信息取得
			List<PlatformManagerInfo> platformManagerList = platformManagerBL.findByCond(cond, pDto.getFromCount(), pDto.getPageDispCount());
			
			pDto.setTotalCount(totalCount);
			
			dto.setPlatformManagerList(platformManagerList);
			
			dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));

			log.debug("========业务系统管理人员缺失信息查询处理结束========");
		return dto;
	}
	/**
	 * 查询网络设备端口状态
	 */
	public IGCIM01DTO searchIGCIM0911Action(IGCIM01DTO dto) throws BLException {
		log.debug("========查询网络交换机端口状态查询处理开始========");
		int totalCount = soc0118BL.getNetDeviceInfoListCount(dto.getIgcim0911Form());
		if (totalCount == 0) {
			log.debug("========查询网络设备端口状态查询数据不存在========");
			//查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========查询网络设备端口状态查询数据件数过多========");
			//查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		//分页用信息取得
			PagingDTO pDto = dto.getPagingDto();
			//当前页应用信息取得
			List<NetDeviceInfo> eiList = soc0118BL.searchNetDeviceInfoList(dto.getIgcim0911Form(), pDto.getFromCount(), pDto.getPageDispCount());
			
			pDto.setTotalCount(totalCount);
			
			dto.setNetDeviceList(eiList);
			dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
			log.debug("========查询网络设备端口状态查询处理结束========");
		return dto;
	}
	
    /**
     *  资产自定义报表导出/预览处理
     * 
     * @param dto IGCIM01DTO
     * @return IGCIM01DTO 
     */
    public IGCIM01DTO exportReport(IGCIM01DTO dto) throws BLException {

		log.debug("========资产自定义报表导出/预览处理开始========");
		
		//查询出Excel表头数据
		SOC0109SearchCondImpl soc0109Cond = new SOC0109SearchCondImpl();
		soc0109Cond.setCseq(1);
		List<SOC0109Info> soc0109List = this.soc0109BL.searchConfiguration(soc0109Cond);
		Map<String,List<SOC0109Info>> ciMap = new HashMap<String,List<SOC0109Info>>();
		for(SOC0109Info ciInfo:soc0109List){
			if(ciMap.get(ciInfo.getEid())==null){
				List<SOC0109Info> temp_list = new ArrayList<SOC0109Info>();
				temp_list.add(ciInfo);
				ciMap.put(ciInfo.getEid(), temp_list);
			}else{
				ciMap.get(ciInfo.getEid()).add(ciInfo);
			}
		}
		//查询出所有属性表中的数据
		SOC0107SearchCondImpl configItemCond = new SOC0107SearchCondImpl();
		//查询出对应关系的所有孩子资产ID
		List<Integer> eiid_list = getEiidByParentList(dto);
		List<SOC0107Info> soc0107List = null;
		if(eiid_list.size()>0){
			StringBuffer sb = new StringBuffer();
			for(Integer i :eiid_list){
				sb.append(String.valueOf(i)).append(",");
			}
			sb.append(dto.getEiid());
			configItemCond.setEid(sb.toString());
			soc0107List = this.soc0107BL.getConfigItemByEid(configItemCond);
		}else{
			soc0107List = new ArrayList<SOC0107Info>();
		}
		Map<String,List<SOC0107Info>> confMap = new HashMap<String,List<SOC0107Info>>();
		for(SOC0107Info ciInfo:soc0107List){
			if(confMap.get(ciInfo.getEiid()+"_"+ciInfo.getCiversion()+"_"+ciInfo.getCismallversion())==null){
				List<SOC0107Info> temp_list = new ArrayList<SOC0107Info>();
				temp_list.add(ciInfo);
				confMap.put(ciInfo.getEiid()+"_"+ciInfo.getCiversion()+"_"+ciInfo.getCismallversion(), temp_list);
			}else{
				confMap.get(confMap.get(ciInfo.getEiid()+"_"+ciInfo.getCiversion()+"_"+ciInfo.getCismallversion()).add(ciInfo));
			}
		}
		
		//查询出当前业务系统基本信息
    	SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(Integer.parseInt(dto.getEiid()));
		
		dto.setSheetType(IGCIMConstants.SHEETTYPE_BUSSINESS);
		dto = getSheetBussinessData(dto,"业务",entityItemVWInfo,ciMap,confMap);
		List<SOC0119Info> soc0119list = getSOC0119List(dto,entityItemVWInfo);
		String eid = "";
		
		//通过CodeDetail查询出需要导出的关系
		CodeDetailSearchCondImpl condimpl = new CodeDetailSearchCondImpl();
		condimpl.setCcid("835");
		List<CodeDetail> cdList = codeDetailBL.searchCodeDetail(condimpl,CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
		Map<String,String> cdMap = new HashMap<String,String>();
		for(CodeDetail cd : cdList){
			cdMap.put(cd.getCid(), cd.getCvalue());
		}
		
		for(SOC0119Info soc0119info : soc0119list){
			if(soc0119info.getEirrelation().equals(IGCIMConstants.RELATION_HOST)){
				eid = IGCIMConstants.EID_HOST;
			}else{
				eid = soc0119info.getCldeid();
			}
			String cvalue = cdMap.get(soc0119info.getEirrelation());
			if(StringUtils.isNotEmpty(cvalue)){
				dto.setSheetType(cvalue);
		    	List<Integer> appList = getEiidList(soc0119info.getEirrelation(),dto);
		    	if(appList.size()>0)
		    		dto = getSheetAppModuleData(dto,appList,eid,cvalue.split("-")[1],ciMap,confMap);
			}
			
		}
    	
    	log.debug("========资产自定义报表导出/预览处理结束========");
		return dto;
    }
  
    /**
     *  获取对应sheet页所需数据信息
     * 
     * @param dto IGCIM01DTO
     * @param List<Integer> cldList
     * @return IGCIM01DTO 
     */
    public IGCIM01DTO getSheetAppModuleData(IGCIM01DTO dto,List<Integer> cldList,String eid,
    		String key,Map<String,List<SOC0109Info>> ciMap,Map<String,List<SOC0107Info>> confMap) throws BLException {
    	
    	List<String> eiidlist = new ArrayList<String>();
    	for(Integer eiid:cldList){
    		eiidlist.add(String.valueOf(eiid));
    	}
    	SOC0124SearchCondImpl soc0124cond = new SOC0124SearchCondImpl();
    	soc0124cond.setEiidList(eiidlist);
    	List<SOC0124Info> soc0124list =this.soc0118BL.searchEntityItemVW(soc0124cond);
    	
		//属性模型表【用于excel表头的显示】
		List<SOC0109Info> soc0109List =arraysList109(ciMap.get(eid));
    	
		//列标题集合
        List<String> titleList = new ArrayList<String>();
		List<String[]>  contentList =  new ArrayList<String[]>();
		
    	//查询出资产属性表中的属性值
    	String[] titlevalue = new String[soc0109List.size()+3];
		titlevalue[0] = key+"名称";
		titlevalue[1] = "资产类型";
		titlevalue[2] = key+"编号";
		int i = 3;
		Map<String,Boolean> soc0109Map = new HashMap<String,Boolean>();
		for(SOC0109Info soc0109Info :soc0109List){
			soc0109Map.put(soc0109Info.getCid(),true);
			titlevalue[i] = soc0109Info.getCname();
			i++;
		}
		for(String str :titlevalue){
			titleList.add(str);
		}
    	String[] contentvalue = null;
    	for(SOC0124Info soc0124info:soc0124list){
    		String cond = soc0124info.getEiid()+"_"+soc0124info.getEiversion()+"_"+soc0124info.getEismallversion();
    		List<SOC0107Info> soc0107List = null;
    		if(confMap.get(cond)==null){
    			soc0107List = new ArrayList<SOC0107Info>();
    		}else{
    			soc0107List = arraysList107(confMap.get(cond));
    		}
    		contentvalue = new String[soc0109List.size()+3];
    		contentvalue[0] =soc0124info.getEiname();
    		contentvalue[1] =soc0124info.getEname();
    		contentvalue[2] =soc0124info.getEilabel(); 
    		int k = 3;
    		for(SOC0107Info soc0107Info : soc0107List){
    			if(soc0109Map.get(soc0107Info.getCid())!=null)
	    			if(soc0109Map.get(soc0107Info.getCid())){
	    				contentvalue[k] = soc0107Info.getCivalue();
	    				k++;
	    			}
    		}
    		contentList.add(contentvalue);
    	}
    	if(contentList.size()>0){
        	dto.getTitleListMap().put(dto.getSheetType(), titleList);
            
            //保存数据条数（用于在预览页面显示记录总数）
        	dto.getReportSizeMap().put(dto.getSheetType(), contentList.size());
            
            //列数（用于导出/预览时合并单元格）
        	dto.getColumnSizeMap().put(dto.getSheetType(), titlevalue.length);
            
        	dto.getContentListMap().put(dto.getSheetType(), contentList);
    	}
    	
    	return dto;
    }
    /**
     *  获取对应sheet页所需数据信息
     * 
     * @param dto IGCIM01DTO
     * @return IGCIM01DTO 
     */
    public IGCIM01DTO getSheetBussinessData(IGCIM01DTO dto,String key,SOC0124Info entityItemVWInfo,
    		Map<String,List<SOC0109Info>> ciMap,Map<String,List<SOC0107Info>> confMap) throws BLException {
    
		List<SOC0109Info> soc0109List =arraysList109(ciMap.get(entityItemVWInfo.getEid()));
		
		//列标题集合
        List<String> titleList = new ArrayList<String>();
		List<String[]>  contentList =  new ArrayList<String[]>();
		
    	//查询出资产属性表中的属性值
    	String[] titlevalue = new String[soc0109List.size()+3];
		titlevalue[0] = key+"名称";
		titlevalue[1] = "资产类型";
		titlevalue[2] = key+"编号";
		int i = 3;
		Map<String,Boolean> soc0109Map = new HashMap<String,Boolean>();
		for(SOC0109Info soc0109Info :soc0109List){
			soc0109Map.put(soc0109Info.getCid(),true);
			titlevalue[i] = soc0109Info.getCname();
			i++;
		}
		for(String str :titlevalue){
			titleList.add(str);
		}
    	String[] contentvalue = null;
		String cond = entityItemVWInfo.getEiid()+"_"+entityItemVWInfo.getEiversion()+"_"+entityItemVWInfo.getEismallversion();
		List<SOC0107Info> soc0107List = null;
		if(confMap.get(cond)==null){
			soc0107List = new ArrayList<SOC0107Info>();
		}else{
			soc0107List = arraysList107(confMap.get(cond));
		}		
		contentvalue = new String[soc0109List.size()+3];
		contentvalue[0] =entityItemVWInfo.getEiname();
		contentvalue[1] =entityItemVWInfo.getEname();
		contentvalue[2] =entityItemVWInfo.getEilabel(); 
		int k = 3;
		for(SOC0107Info soc0107Info : soc0107List){
			if(soc0109Map.get(soc0107Info.getCid())!=null)
    			if(soc0109Map.get(soc0107Info.getCid())){
    				contentvalue[k] = soc0107Info.getCivalue();
    				k++;
    			}
		}
		
		contentList.add(contentvalue);
		
		dto.setReportTitle(entityItemVWInfo.getEiname());
		Map<String,List<String>> titleListMap = new LinkedHashMap<String,List<String>>();
		titleListMap.put(dto.getSheetType(), titleList);
		dto.setTitleListMap(titleListMap);
       
        //保存数据条数（用于在预览页面显示记录总数）
		Map<String,Integer> reportSizeMap = new LinkedHashMap<String,Integer>();
		reportSizeMap.put(dto.getSheetType(), contentList.size());
        dto.setReportSizeMap(reportSizeMap);
        
        //列数（用于导出/预览时合并单元格）
        Map<String,Integer> columnSizeMap = new LinkedHashMap<String,Integer>();
        columnSizeMap.put(dto.getSheetType(), titleList.size());
        dto.setColumnSizeMap(columnSizeMap);
        
        Map<String,List<String[]>> contentListMap = new LinkedHashMap<String,List<String[]>>();
        contentListMap.put(dto.getSheetType(), contentList);
        dto.setContentListMap(contentListMap);
    	
    	return dto;
    }
    
	/**
	 * 判断该业务系统下是否有该子模型
	 * @throws BLException 
	 * @throws Exception
	 */  
    public List<Integer> getEiidList(String relationCode,IGCIM01DTO dto) throws BLException{
    	SOC0119SearchCondImpl soc0119cond = new SOC0119SearchCondImpl();
    	soc0119cond.setPareiid(Integer.parseInt(dto.getEiid()));
    	soc0119cond.setEirrelation(relationCode);
    	soc0119cond.setDeleteflag("0");
    	return this.soc0119BL.searchCldeiidByPareiid(soc0119cond);
    }
    public List<Integer> getEiidByParentList(IGCIM01DTO dto) throws BLException{
    	SOC0119SearchCondImpl soc0119cond = new SOC0119SearchCondImpl();
    	soc0119cond.setPareiid(Integer.parseInt(dto.getEiid()));
    	soc0119cond.setDeleteflag("0");
    	return this.soc0119BL.searchCldeiidByPareiid(soc0119cond);
    }
    public List<SOC0119Info> getSOC0119List(IGCIM01DTO dto,SOC0124Info entityItemVWInfo) throws BLException{
    	SOC0119SearchCondImpl soc0119cond = new SOC0119SearchCondImpl();
    	soc0119cond.setParversion(entityItemVWInfo.getEiversion());
    	soc0119cond.setParsmallversion(entityItemVWInfo.getEismallversion());
    	soc0119cond.setPareiid(Integer.parseInt(dto.getEiid()));
    	soc0119cond.setDeleteflag("0");
    	return this.soc0119BL.searchMaxEntityItemRelation(soc0119cond);
    }
	/**
	 * 按CID排序
	 * @throws Exception
	 */
	public List<SOC0107Info> arraysList107(List<SOC0107Info> soc0107List){
        //list排序
		Collections.sort(soc0107List,new Comparator<SOC0107Info>(){
			public int compare(SOC0107Info soc1,SOC0107Info soc2){
				String len1 =  soc1.getCid().substring(soc1.getCid().length()-5,soc1.getCid().length());
				String len2 =  soc2.getCid().substring(soc2.getCid().length()-5,soc1.getCid().length());
			return Integer.parseInt(len1)-Integer.parseInt(len2);
			}
		  } 
		);
		return soc0107List;
	}
	/**
	 * 按CID排序
	 * @throws Exception
	 */
	public List<SOC0109Info> arraysList109(List<SOC0109Info> soc0109List){
        //list排序
		Collections.sort(soc0109List,new Comparator<SOC0109Info>(){
			public int compare(SOC0109Info soc1,SOC0109Info soc2){
				String len1 =  soc1.getCid().substring(soc1.getCid().length()-5,soc1.getCid().length());
				String len2 =  soc2.getCid().substring(soc2.getCid().length()-5,soc1.getCid().length());
			return Integer.parseInt(len1)-Integer.parseInt(len2);
			}
		  } 
		);
		return soc0109List;
	}
	/**
	 * 查询导入信息
	 * @param dto
	 * @return
	 */
	public IGCIM01DTO searchSoc0113Info(IGCIM01DTO dto){
		List<SOC0113Info> list = soc0113BL.searchEiImportProgramme();
		dto.setSoc0113List(list);
		return dto;
	}
	
	/**
	 * 设备信息查询处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO searchSOC0118(IGCIM01DTO dto) throws BLException {

		log.debug("========设备信息查询处理开始========");
		
		//设备信息查询件数取得 
		SOC0124SearchCond entityItemVWSearchCond = dto.getEntityItemVWSearchCond();
		String esyscoding = entityItemVWSearchCond.getEsyscoding();
		String einame = entityItemVWSearchCond.getEiname();
		String eiupdtime_from = entityItemVWSearchCond.getEiupdtime_from();
		String eiupdtime_to = entityItemVWSearchCond.getEiupdtime_to();
		Integer eirootmark_eq = entityItemVWSearchCond.getEirootmark_eq();
		
		SOC0118SearchCondImpl cond = new SOC0118SearchCondImpl();
		cond.setEsyscoding_eq(esyscoding);
		cond.setEiname(einame);
		cond.setEiupdtime_from(eiupdtime_from);
		cond.setEirootmark(eirootmark_eq);
		
		if (StringUtils.isNotEmpty(eiupdtime_to)) {
			cond.setEiupdtime_to(eiupdtime_to + " 23:59");
		}
		int totalCount = soc0118BL.getEntityItemSearchCount(cond);
		
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
		List<SOC0118Info> soc0118List = this.soc0118BL.searchEntityItem(cond, pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setEntityItemList(soc0118List);

		Integer domainid = EiDomainKeyWords.DOOMAIN_ID_DEFAULT;
		SOC0111Info domain  = this.soc0111BL.searchDomainMaxVersion(domainid);
		Integer domainversion = domain.getVersion();
		String createtime = domain.getUpdatetime();
		String showRelation = "N";
		Map<String,String> showRelationMap = new HashMap<String,String>();
		if(soc0118List!=null){
			//主机，交换机，存储可以查看关系
			// 将存储改为只查看DMX存储 --20130607 yanglongquan
			for(SOC0118Info bean:soc0118List){
				if(bean.getEsyscoding().startsWith(EiRelationKeyWords.HOST) 
						|| bean.getEsyscoding().startsWith(EiRelationKeyWords.SWITCH)
						|| bean.getEsyscoding().startsWith(EiRelationKeyWords.STORAGE_DMX)) {
					showRelation = "Y";
				}else{
					showRelation = "N";
				}
				showRelationMap.put(String.valueOf(bean.getEiid()), showRelation);
			}
		}
		dto.setDomainid(domainid);
		dto.setDomainversion(domainversion);
		dto.setCreatetime(createtime);
		dto.setShowRelationMap(showRelationMap);
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========设备信息查询处理终了========");
		return dto;
	}
	
	
	/**
     *  获取resourceid
     * 
     * @param dto IGCIM01DTO
     * @return IGCIM01DTO 
     */
    public IGCIM01DTO getResid(IGCIM01DTO dto) throws BLException {
    	SOC0118Info entityItem = soc0118BL.searchEntityItemByKey(Integer.parseInt(dto.getEiid()));
    	String cid = resource_cid.get(entityItem.getEid());
    	SOC0107SearchCondImpl cond = new SOC0107SearchCondImpl();
    	cond.setEiid(dto.getEiid());
    	cond.setCid(cid);
    	cond.setCiversion(""+entityItem.getEiversion());
    	cond.setCismallversion(""+entityItem.getEismallversion());
    	List<SOC0107Info> clist = soc0107BL.searchSOC0107(cond);
    	if(clist!=null&&clist.size()>0){
    		String resid = clist.get(0).getCivalue();
        	dto.setResid(resid);
    	}
    	if(StringUtils.isEmpty(dto.getResid())){
    		dto.addMessage(new ActionMessage("IGCIM0156.E001"));
    	}
    	return dto;
    }
    
    /**
     *  获取资产相关流程
     * 
     * @param dto IGCIM01DTO
     * @return IGCIM01DTO 
     */
    public IGCIM01DTO getProcessByEiid(IGCIM01DTO dto) throws BLException {
    	IG500VWSearchCondImpl cond = new IG500VWSearchCondImpl();
    	cond.setEiid(dto.getEiid());
    	List<String> prpdid_in = new ArrayList<String>();
    	prpdid_in.add("0108001");
    	prpdid_in.add("0108301");
    	prpdid_in.add("0108402");
    	prpdid_in.add("0110001");
    	cond.setPrpdid_in(prpdid_in);
    	List<IG500VWInfo> resList = ig500VWBL.findByCond(cond);
    	dto.setRes500VWList(resList);
    	return dto;
    }
    
    /**
     *  获取资产服务记录
     * 
     * @param dto IGCIM01DTO
     * @return IGCIM01DTO 
     */
    public IGCIM01DTO getMaintainByEiid(IGCIM01DTO dto) throws BLException {
    	IG500VWSearchCondImpl cond = new IG500VWSearchCondImpl();
    	cond.setEiid(dto.getEiid());
    	cond.setPrpdid_eq("0100201");
    	List<IG500VWInfo> resList = ig500VWBL.findByCond(cond);
    	dto.setRes500VWList(resList);
    	return dto;
    }
    
    /**
	 * 主机配置查询
	 */
	public IGCIM01DTO searchSOC0118ByHost(IGCIM01DTO dto) throws BLException {
		log.debug("========主机信息查询处理开始========");
		
		//主机信息查询件数取得 
		IGCIM0101Form form = dto.getIgcim0101Form();
		String esyscoding = form.getEsyscoding();
		String einame = form.getEiname();
		String eiupdtime_from = form.getEiupdtime_from();
		String eiupdtime_to = form.getEiupdtime_to();
		Integer eirootmark_eq = form.getEirootmark_eq();
		
		SOC0118SearchCondImpl cond = new SOC0118SearchCondImpl();
		cond.setEsyscoding_eq(esyscoding);
		cond.setEiname(einame);
		cond.setEiupdtime_from(eiupdtime_from);
		cond.setEirootmark(eirootmark_eq);
		cond.setEitype(form.getEitype());
		
		if (StringUtils.isNotEmpty(eiupdtime_to)) {
			cond.setEiupdtime_to(eiupdtime_to + " 23:59");
		}
		int totalCount = soc0118BL.getEntityItemSearchCountByHost(cond);
		
		if (totalCount == 0) {
			log.debug("========主机信息查询数据不存在========");
			//主机信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========主机信息查询数据件数过多========");
			//主机信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//分页用信息取得
		PagingDTO pDto = dto.getPagingDto();

		//当前页设备信息取得
		List<SOC0118Info> soc0118List = this.soc0118BL.searchEntityItemByHost(cond, pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setEntityItemList(soc0118List);

		Integer domainid = EiDomainKeyWords.DOOMAIN_ID_DEFAULT;
		SOC0111Info domain  = this.soc0111BL.searchDomainMaxVersion(domainid);
		Integer domainversion = domain.getVersion();
		String createtime = domain.getUpdatetime();
		String showRelation = "N";
		Map<String,String> showRelationMap = new HashMap<String,String>();
		if(soc0118List!=null){
			//主机，交换机，存储可以查看关系
			for(SOC0118Info bean:soc0118List){
				if(bean.getEsyscoding().startsWith(EiRelationKeyWords.HOST) 
						|| bean.getEsyscoding().startsWith(EiRelationKeyWords.SWITCH)
						|| bean.getEsyscoding().startsWith(EiRelationKeyWords.STORAGE_DMX)) {
					showRelation = "Y";
				}else{
					showRelation = "N";
				}
				showRelationMap.put(String.valueOf(bean.getEiid()), showRelation);
			}
		}
		dto.setDomainid(domainid);
		dto.setDomainversion(domainversion);
		dto.setCreatetime(createtime);
		dto.setShowRelationMap(showRelationMap);
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========主机信息查询处理终了========");
		return dto;
	}
}
