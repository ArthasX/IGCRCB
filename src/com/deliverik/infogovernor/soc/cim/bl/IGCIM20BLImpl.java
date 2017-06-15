package com.deliverik.infogovernor.soc.cim.bl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

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
import com.deliverik.framework.soc.asset.EiDomainKeyWords;
import com.deliverik.framework.soc.asset.EiRelationKeyWords;
import com.deliverik.framework.soc.asset.EntityCategory;
import com.deliverik.framework.soc.asset.EntityItemKeyWords;
import com.deliverik.framework.soc.asset.SOC0138Info;
import com.deliverik.framework.soc.asset.bl.task.SOC0107BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0109BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0110BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0111BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0112BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0117BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0119BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0126BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0151BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0163BL;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.SOC0109Info;
import com.deliverik.framework.soc.asset.model.SOC0110Info;
import com.deliverik.framework.soc.asset.model.SOC0111Info;
import com.deliverik.framework.soc.asset.model.SOC0112Info;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0119Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.framework.soc.asset.model.SOC0163Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0107SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0110SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0117SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0118SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0119SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0126SearchCondImpl;
import com.deliverik.framework.soc.asset.model.entity.SOC0107TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0110TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0112PK;
import com.deliverik.framework.soc.asset.model.entity.SOC0112TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0118TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0119TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0124VW;
import com.deliverik.framework.user.bl.task.OrganizationBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.condition.OrganizationSearchCondImpl;
import com.deliverik.framework.utility.BLErrorType;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.asset.bl.IGASM03BLImpl;
import com.deliverik.infogovernor.soc.bl.task.SocRelationBL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM20DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM2001Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM2002Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM2003Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM2006Form;
import com.deliverik.infogovernor.soc.model.entity.SocRelationTB;
import com.deliverik.infogovernor.util.ASMHelper;
import com.deliverik.infogovernor.util.CodeDefine;

/**
 * 网络管理BL实现
 * @author Administrator
 *
 */
public class IGCIM20BLImpl  extends BaseBLImpl implements IGCIM20BL{
	
	static Log log = LogFactory.getLog(IGCIM20BLImpl.class);
	
	private SOC0118BL soc0118BL;
	private SOC0117BL soc0117BL;
	private SOC0119BL soc0119BL;
	private SOC0110BL soc0110BL;
	private SOC0111BL soc0111BL;
	private SOC0163BL soc0163BL;
	
	private SOC0109BL soc0109BL;
	private OrganizationBL organizationBL;
	private SocRelationBL socRelationBL;
	private SOC0107BL soc0107BL;
	private SOC0151BL soc0151BL;
	private SOC0126BL soc0126BL;
	private SOC0112BL soc0112BL;
	private CodeDetailBL codeDetailBL;
	private UserRoleBL userRoleBL;
	private FileUploadBL fileUploadBL;
	
	protected MessageResources resources = MessageResources.getMessageResources("com.deliverik.infogovernor.soc.cim.asmResources"); 
	
	
	
	public void setSoc0163BL(SOC0163BL soc0163bl) {
		soc0163BL = soc0163bl;
	}
	public void setSoc0111BL(SOC0111BL soc0111bl) {
		soc0111BL = soc0111bl;
	}
	public void setSocRelationBL(SocRelationBL socRelationBL) {
		this.socRelationBL = socRelationBL;
	}
	
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}
	
	public void setSoc0109BL(SOC0109BL soc0109bl) {
		soc0109BL = soc0109bl;
	}
	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}



	public void setSoc0119BL(SOC0119BL soc0119bl) {
		soc0119BL = soc0119bl;
	}



	public void setSoc0110BL(SOC0110BL soc0110bl) {
		soc0110BL = soc0110bl;
	}



	public void setOrganizationBL(OrganizationBL organizationBL) {
		this.organizationBL = organizationBL;
	}



	public void setSoc0107BL(SOC0107BL soc0107bl) {
		soc0107BL = soc0107bl;
	}



	public void setSoc0151BL(SOC0151BL soc0151bl) {
		soc0151BL = soc0151bl;
	}


	public void setSoc0118BL(SOC0118BL soc0118bl) {
		soc0118BL = soc0118bl;
	}



	public void setSoc0117BL(SOC0117BL soc0117bl) {
		soc0117BL = soc0117bl;
	}



	public void setSoc0112BL(SOC0112BL soc0112BL) {
		this.soc0112BL = soc0112BL;
	}
	
	
	public void setSoc0126BL(SOC0126BL soc0126BL) {
		this.soc0126BL = soc0126BL;
	}
	public void setFileUploadBL(FileUploadBL fileUploadBL) {
		this.fileUploadBL = fileUploadBL;
	}
	/**
	 * 获取设备编号最大值
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM20DTO searchEntityItemLableAction(IGCIM20DTO dto) throws BLException {
		
		log.debug("========获取设备编号最大值处理开始========");
		
		IGCIM2001Form form = dto.getIgcim2001Form();
		
		SOC0118SearchCondImpl cond = new SOC0118SearchCondImpl();
		
		cond.setEilabel(CommonDefineUtils.ENTIY_CATEGORY_DEVICE_KEY + IGStringUtils.getCurrentYear().substring(2));
		
		String eilabel = this.soc0118BL.searchNextEntityItemLable(cond);
		
		form.setEilabel(eilabel);
		
		log.debug("========获取设备编号最大值处理终了========");
		return dto;
	}
	
	/**
	 * 设备信息登记处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM20DTO insertEntityItemAction(IGCIM20DTO dto) throws BLException {
		log.debug("========网络设备信息登记处理开始========");
		//输入Form取得
		IGCIM2001Form form = dto.getIgcim2001Form();
		
		form.setEidStr(form.getEid().toString());
		
		//更新时间设定
		
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		
		form.setEiupdtime(datetime);
		
		//大版本设定（固定设为1）
		form.setEiversion(1);
		
		//小版本设定（固定设为0）
		form.setEismallversion(0);
		
		form.setEistatus(CommonDefineUtils.ENTITYITEM_STARUS_NEW);

		SOC0118TB soc0118 = new SOC0118TB();
		
		BeanUtils.copyProperties(form, soc0118);
		//设备信息登录
		SOC0118Info entityItem = this.soc0118BL.registEntityItem(soc0118);
		SOC0118TB ei=(SOC0118TB)SerializationUtils.clone(entityItem);
		ei.setEirootmark(entityItem.getEiid());
		this.soc0118BL.updateEntityItem(ei);
		
		form.setEiidStr(entityItem.getEiid().toString());
		
		dto.setIgcim2001Form(form);
		//设备基本信息
		dto.addMessage(new ActionMessage( "IGCO10000.I004", resources.getMessage(dto.getLocale(),"message.IGCIM01BLImpl.001")) );
		
		log.debug("========网络设备信息登记处理终了========");
		return dto;
	}
	
	/**
	 * 设备配置信息编辑画面初期化处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM20DTO initIGCIM2002Action(IGCIM20DTO dto) throws BLException {

		log.debug("========设备配置信息编辑画面初期化处理开始========");
		
		IGCIM2003Form form = dto.getIgcim2003Form();
		
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

		
		log.debug("========网络设备配置信息编辑画面初期化处理终了========");
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
	public IGCIM20DTO editEntityItemAction(IGCIM20DTO dto) throws BLException,FileNotFoundException,IOException {
		log.debug("========设备配置信息编辑处理开始========");
		//版本号生成
		IGCIM2003Form form = dto.getIgcim2003Form();
		
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
	private String saveXMLFrist(IGCIM2002Form form,User user) throws BLException, FileNotFoundException, IOException {
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
	 * 判断登陆用户是否是设备资产管理角色负责人
	 * 
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 * @throws BLException 
	 */
	public IGCIM20DTO checkEntityItemDomain(IGCIM20DTO dto) throws BLException{
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
	 * 设备信息查询处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM20DTO searchEntityItemAction(IGCIM20DTO dto) throws BLException {

		log.debug("========设备信息查询处理开始========");
		
		//设备信息查询件数取得 
		int totalCount = this.soc0163BL.getSearchCountForNetAsset(dto.getIgcim2004Form());
	//	int totalCount = this.soc0118BL.getEntityItemVWSearchCount(dto.getEntityItemVWSearchCond());
		
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
		List<SOC0163Info> entityVWInfoList = this.soc0163BL.findByCondForNetAsset(dto.getIgcim2004Form(), pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		dto.setEntityVWInfoList(entityVWInfoList);
		//dto.setEntityItemVWInfoList(entityItemVWInfoList);

		Integer domainid = EiDomainKeyWords.DOOMAIN_ID_DEFAULT;
		SOC0111Info domain  = this.soc0111BL.searchDomainMaxVersion(domainid);
		Integer domainversion = domain.getVersion();
		String createtime = domain.getUpdatetime();
		String showRelation = "N";
		Map<String,String> showRelationMap = new HashMap<String,String>();
		if(entityVWInfoList!=null){
			//主机，交换机，存储可以查看关系
			for(SOC0163Info bean:entityVWInfoList){
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
	 * 设备信息删除处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM20DTO deleteEntityItemAction(IGCIM20DTO dto) throws BLException {
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
		 *	获取应用关联关系处理
		 *
		 * @param dto IGCIM01DTO
		 * @return IGCIM01DTO
		 */
		public IGCIM20DTO searchRelationListActionApp(IGCIM20DTO dto) throws BLException {
			log.debug("========获取应用关联关系处理开始========");
//			List<LabelValueBean> list = this.codeDetailBL.searchLabelValueBeanList(CommonDefineUtils.ENTIY_CATEGORY_APPLICATION,CodeDefine.getCodeDefine("ENTITYITEM_RELATION_CODE").getCcid());
			CodeDetailSearchCondImpl cond = new CodeDetailSearchCondImpl();
			cond.setCcid(CodeDefine.getCodeDefine("ENTITYITEM_RELATION_CODE").getCcid());
			cond.setCdinfo_eq(dto.getIgcim2006Form().getPareid());
			List<CodeDetail> codetailList = this.codeDetailBL.searchCodeDetail(cond,0);
			dto.setRelationList(codetailList);
			log.debug("========获取应用关联关系处理终了========");
			return dto;
		}
		
		/**
		 * 应用关系登记处理
		 *
		 * @param dto IGCIM01DTO
		 * @return IGCIM01DTO
		 */
		public IGCIM20DTO insertEntityItemRelationActionApp(IGCIM20DTO dto) throws BLException {
			log.debug("========网络设备关系登记处理开始========");
			
			IGCIM2006Form form = dto.getIgcim2006Form();
			
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
			
			SOC0110SearchCondImpl soc0110cond = new SOC0110SearchCondImpl();
			
			soc0110cond.setBrpareiid(form.getPareiid().toString());
			soc0110cond.setBrcldeiid(form.getCldeiid().toString());
			soc0110cond.setBrassetrelation(form.getEirrelation());
			soc0110cond.setDeleteflag("0");
			
			List<SOC0110Info> list_eirl = this.soc0110BL.searchEiBelongRelation(soc0110cond);
			
			soc0110cond = new SOC0110SearchCondImpl();
			
			soc0110cond.setBrpareiid(form.getPareiid().toString());
			soc0110cond.setBrcldeiid(form.getCldeiid().toString());
			soc0110cond.setBrassetrelation(form.getEirrelation());
			soc0110cond.setDeleteflag("0");
			
			List<SOC0110Info> list_cld = this.soc0110BL.searchEiBelongRelation(soc0110cond);
			
			if(list_eirl.size()>0||list_cld.size()>0){
				throw new BLException(BLErrorType.ENTITY_ITEM_RELATION_ERROR,"IGASM0307.E001",resources.getMessage(dto.getLocale(),"message.IGASM03BLImpl.020"));
			}
			
			//更新子设备的rootmark
			SOC0118TB cldEntity = (SOC0118TB)soc0118BL.searchEntityItemByKey(form.getCldeiid());
			cldEntity.setEirootmark(form.getPareiid());
			
			SOC0110TB soc0110Tb = new SOC0110TB();
			
			soc0110Tb.setBrassetrelation(form.getTempeirrelation());
			soc0110Tb.setBrcldeiid(form.getCldeiid());
			soc0110Tb.setBrcldsmallversion(form.getCldsmallversion());
			soc0110Tb.setBrcldversion(form.getCldversion());
			soc0110Tb.setBrcreatetime(datetime);
			soc0110Tb.setBrpareiid(form.getPareiid());
			soc0110Tb.setBrparsmallversion(form.getParsmallversion());
			soc0110Tb.setBrparversion(form.getParversion());
			soc0110Tb.setBrraletioncode(form.getEirrelationcode());
			soc0110Tb.setDeleteflag("0");
			soc0110Tb.setEirootmark(form.getPareiid());
			soc0110Tb.setBrtype("1");
			soc0110Tb.setBrdes(form.getEirdesc());
			soc0110Tb.setBrraletioncode("001-001");
			SOC0110Info result = soc0110BL.registEiBelongRelation(soc0110Tb);
			
			dto.setEntityRelation(result);
			//dto.addMessage(new ActionMessage( "IGCO10000.I004", resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.013")) );
			dto.addMessage(new ActionMessage("IGCIM2005.I001"));
			log.debug("========应用关系登记处理终了========");
			return dto;
		}
		
		/**
		 * 创建业务系统与DB之间的关系
		 * @param form
		 * @param soc0124Info
		 * @throws BLException
		 */
		public void createEntityItemRelationActionAppToOracle(IGCIM2006Form form,SOC0124Info soc0124Info) throws BLException {
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
		 * 创建业务系统与webapp
		 * @param form
		 * @param soc0124Info
		 */
		private void createEntityItemRelationActionAppToWEBAPP(IGCIM2006Form form,
				SOC0124Info soc0124Info) throws BLException {
			SOC0110SearchCondImpl soc0110Cond=new SOC0110SearchCondImpl();
			soc0110Cond.setBrcldeiid(soc0124Info.getEiid()+"");
			soc0110Cond.setBrcldversion(soc0124Info.getEiversion()+"");
			soc0110Cond.setBrcldsmallversion(soc0124Info.getEismallversion()+"");
			soc0110Cond.setBrassetrelation("CR020200010001");
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
		 * 应用关系变更处理处理
		 *
		 * @param dto IGCIM01DTO
		 * @return IGCIM01DTO
		 */
		public IGCIM20DTO updateEntityItemRelationActionApp(IGCIM20DTO dto) throws BLException {
			log.debug("========应用关系变更处理处理开始========");
			IGCIM2006Form form = dto.getIgcim2006Form();

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
		 * 应用关系编辑画面初期化处理
		 *
		 * @param dto IGCIM01DTO
		 * @return IGCIM01DTO
		 */
		public IGCIM20DTO initIGCIM2006Action(IGCIM20DTO dto) throws BLException {
			log.debug("========应用关系编辑画面初期化处理开始========");
			
			IGCIM2006Form form = dto.getIgcim2006Form();
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
		 * 应用关系管理画面初期化处理
		 *
		 * @param dto IGCIM01DTO
		 * @return IGCIM01DTO
		 */
		public IGCIM20DTO initIGCIM2005Action(IGCIM20DTO dto) throws BLException {
			log.debug("========设备依赖关系管理画面初期化处理开始========");
			
			//设备信息检索
			SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(
					Integer.parseInt(dto.getIgcim2005Form().getEiid()));
			
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

			Map<String,List<SOC0110Info>> parmap = new LinkedHashMap<String,List<SOC0110Info>>();
			
			if ( totalCount>0 ) {
				//设备依赖关系信息全件检索
				eiBelongRelationList = this.soc0110BL.searchEiBelongRelation(belongcond);
				
				for (SOC0110Info info : eiBelongRelationList) {
					String key = "";
					if("CR010100450001".equals(info.getBrassetrelation())){
						key="交换机-VLAN";
					}else if("CR010100450002".equals(info.getBrassetrelation())){
						key="交换机-端口";
					}else if("CR010100460001".equals(info.getBrassetrelation())){
						key="路由器-VLAN";
					}else if("CR010100460002".equals(info.getBrassetrelation())){
						key="路由器-端口";
					}else if("CR010100470001".equals(info.getBrassetrelation())){
						key="防火墙-端口";
					}
					if(!parmap.containsKey(key)){
						parmap.put(key, new ArrayList<SOC0110Info>());
					}
					parmap.get(key).add(info);
				}
			}
			
			dto.setParEntityRelationMap(parmap);
			
			Map<String,List<SOC0110Info>> cldmap = new LinkedHashMap<String,List<SOC0110Info>>();
			//逆向关联关系检索
			SOC0110SearchCondImpl cldcond = new SOC0110SearchCondImpl();
			
			cldcond.setBrcldeiid(entityItemVWInfo.getEiid().toString());
			cldcond.setBrcldsmallversion(entityItemVWInfo.getEismallversion().toString());
			cldcond.setBrcldversion(entityItemVWInfo.getEiversion().toString());
			cldcond.setDeleteflag("0");
			//设备依赖关系信息查询件数取得 
			totalCount = this.soc0110BL.getSearchCount(cldcond);
			
			
			if ( totalCount > dto.getMaxSearchCount() ) {
				log.debug("========设备关系信息查询数据件数过多========");
				//设备关系信息查询数据件数过多
				dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
				return dto;
			}

			if ( totalCount>0 ) {
				//设备依赖关系信息全件检索
				eiBelongRelationList = this.soc0110BL.searchEiBelongRelation(cldcond);
				
				for (SOC0110Info info : eiBelongRelationList) {
					String key = "";
					if("CR010100450001".equals(info.getBrassetrelation())){
						key="交换机-VLAN";
					}else if("CR010100450002".equals(info.getBrassetrelation())){
						key="交换机-端口";
					}else if("CR010100460001".equals(info.getBrassetrelation())){
						key="路由器-VLAN";
					}else if("CR010100460001".equals(info.getBrassetrelation())){
						key="路由器-端口";
					}else if("CR010100470001".equals(info.getBrassetrelation())){
						key="防火墙-端口";
					}
					if(!cldmap.containsKey(key)){
						cldmap.put(key, new ArrayList<SOC0110Info>());
					}
					cldmap.get(key).add(info);
				}
			}
			dto.setCldEntityRelationMap(cldmap);
			
			log.debug("========设备依赖关系管理画面初期化处理终了========");
			
			return dto;
		}
		
		/**
		 * 应用关系删除处理
		 *
		 * @param dto IGCIM01DTO
		 * @return IGCIM01DTO
		 */
		public IGCIM20DTO deleteEntityItemRelationActionApp(IGCIM20DTO dto) throws BLException {
			log.debug("========应用关系删除处理开始========");
			
			for( int i=0;i<dto.getDeleteEntityItemRelation().length;i++ ){
				String eirid = dto.getDeleteEntityItemRelation()[i];
			
				soc0110BL.deleteEiBelongRelationByPK(Integer.valueOf(eirid));
				
			}
			
			dto.addMessage(new ActionMessage("IGCIM2005.I002"));

			log.debug("========应用关系删除处理终了========");
			return dto;
		}
		
		/**
		 * 网络设备升级大版本
		 * @param dto
		 * @return
		 * @throws BLException
		 */
		public IGCIM20DTO updateVersion(IGCIM20DTO dto) throws BLException {
			log.debug("========网络设备升级大版本开始========");
			Properties properties = getProperties();
			String filepath = properties.getProperty("INSTALL_FILE_PATH");
			String batName = properties.getProperty("UPDATE_VERSION_BAT_NAME");
			String[] cmd = new String[5];
			cmd[0] = "cmd";
			cmd[1] = "/c";
			cmd[2] = "start";
			cmd[3] = " ";
			cmd[4] = filepath + batName;
			try {
				java.lang.Runtime.getRuntime().exec(cmd);
			} catch (Exception e) {
				log.error("网络设备升级大版本应用程序启动失败", e);
				throw new BLException("IGCIM2004.E001");
			}finally{
			}
			log.debug("========网络设备升级大版本终了========");
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
}
