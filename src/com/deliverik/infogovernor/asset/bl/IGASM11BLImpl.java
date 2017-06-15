package com.deliverik.infogovernor.asset.bl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
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

import com.deliverik.framework.asset.bl.task.IG545BL;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.FileUploadBL;
import com.deliverik.framework.soc.asset.EntityItemKeyWords;
import com.deliverik.framework.soc.asset.bl.task.EquipmentInquireVWBL;
import com.deliverik.framework.soc.asset.bl.task.IndicatorLightsSystemBL;
import com.deliverik.framework.soc.asset.bl.task.MonitoringAlarmIPVWBL;
import com.deliverik.framework.soc.asset.bl.task.SOC0107BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0109BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0117BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0119BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0601BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0602BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0603BL;
import com.deliverik.framework.soc.asset.bl.task.SynchronizationAlarmSystemVWBL;
import com.deliverik.framework.soc.asset.model.EquipmentInquireVWInfo;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.SOC0109Info;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0119Info;
import com.deliverik.framework.soc.asset.model.SOC0601Info;
import com.deliverik.framework.soc.asset.model.SOC0602Info;
import com.deliverik.framework.soc.asset.model.SOC0603Info;
import com.deliverik.framework.soc.asset.model.SOC0605Info;
import com.deliverik.framework.soc.asset.model.SOC0606Info;
import com.deliverik.framework.soc.asset.model.SynchronizationAlarmSystemVWInfo;
import com.deliverik.framework.soc.asset.model.condition.EquipmentInquireVWSearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0107SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0109SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0117SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0119SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0601SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0602SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0603SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0606SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SynchronizationAlarmSystemVWSearchCondImpl;
import com.deliverik.framework.soc.asset.model.entity.IndicatorLightsSystemTB;
import com.deliverik.framework.soc.asset.model.entity.SOC0107TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0118TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0119TB;
import com.deliverik.framework.utility.BLErrorType;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.asset.dto.IGASM11DTO;
import com.deliverik.infogovernor.asset.form.IGASM1102Form;
import com.deliverik.infogovernor.asset.form.IGASM1104Form;
import com.deliverik.infogovernor.asset.form.IGASM1105Form;
import com.deliverik.infogovernor.asset.form.IGASM1112Form;
import com.deliverik.infogovernor.asset.form.IGASM1114Form;
import com.deliverik.infogovernor.asset.form.IGASM1115Form;
import com.deliverik.infogovernor.asset.form.IGASM1116Form;
import com.deliverik.infogovernor.asset.form.IGASM1120Form;
import com.deliverik.infogovernor.asset.vo.IGASM11041VO;
import com.deliverik.infogovernor.asset.vo.IGASM11042VO;
import com.deliverik.infogovernor.asset.vo.IGASM11141VO;
import com.deliverik.infogovernor.asset.vo.IGASM11142VO;
import com.deliverik.infogovernor.room.bl.task.CompareTemplateBL;
import com.deliverik.infogovernor.room.model.CompareTemplateInfo;
import com.deliverik.infogovernor.room.model.condition.CompareTemplateSearchCondImpl;

/**
 * @Description: 机房配置管理业务逻辑实现
 * @Author  
 * @History 2009-8-18     新建
 * @History 2010-5-07     0000428: 增加机房属性管理
 * @Version V2.0
 */
public class IGASM11BLImpl extends BaseBLImpl implements IGASM11BL {

	static Log log = LogFactory.getLog(IGASM11BLImpl.class);

	/** 资产信息BL */
	protected SOC0117BL soc0117BL;

	/** 资产项信息BL */
	protected SOC0118BL soc0118BL;
	
	/** 资产配置项BL */
	protected SOC0107BL soc0107BL;
	
	/** 资产项关系BL */
	protected SOC0119BL soc0119BL;
	
	/** 机房视图BL */
	protected SOC0601BL soc0601BL;
	
	/** 资产配置BL */
	protected SOC0109BL soc0109BL;
	
	/** 机柜视图BL */
	protected SOC0603BL soc0603BL;
	
	/** 设备视图BL */
	protected SOC0602BL soc0602BL;
	
	/** 文件上传BL */
	protected FileUploadBL fileUploadBL;
	
	protected CompareTemplateBL compareTemplateBL;
	
	/** 3D机房支持IP查询BL */
	protected EquipmentInquireVWBL equipmentInquireVWBL;
	
	/** 资产取值范围下拉数据BL */
	protected IG545BL ig545BL;
	
	/** 监控告警ip视图BL */
	protected MonitoringAlarmIPVWBL monitoringAlarmIPVWBL;
	
	/** 同步告警系统视图BL */
	protected SynchronizationAlarmSystemVWBL synchronizationAlarmSystemVWBL;
	
	/** 告警系统显示信息BL */
	protected IndicatorLightsSystemBL indicatorLightsSystemBL;
	
	public void setIg545BL(
			IG545BL ig545BL) {
		this.ig545BL = ig545BL;
	}

	public void setSoc0117BL(SOC0117BL soc0117bl) {
		soc0117BL = soc0117bl;
	}

	public void setSoc0118BL(SOC0118BL soc0118bl) {
		soc0118BL = soc0118bl;
	}

	public void setSoc0107BL(SOC0107BL soc0107bl) {
		soc0107BL = soc0107bl;
	}

	public void setSoc0119BL(SOC0119BL soc0119bl) {
		soc0119BL = soc0119bl;
	}

	public void setSoc0601BL(SOC0601BL soc0601bl) {
		soc0601BL = soc0601bl;
	}

	public void setSoc0109BL(SOC0109BL soc0109bl) {
		soc0109BL = soc0109bl;
	}

	public void setSoc0603BL(SOC0603BL soc0603bl) {
		soc0603BL = soc0603bl;
	}

	public void setSoc0602BL(SOC0602BL soc0602bl) {
		soc0602BL = soc0602bl;
	}

	public void setEquipmentInquireVWBL(EquipmentInquireVWBL equipmentInquireVWBL) {
		this.equipmentInquireVWBL = equipmentInquireVWBL;
	}
	
	/**
	 * 监控告警ip视图BL设定
	 */
	public void setMonitoringAlarmIPVWBL(MonitoringAlarmIPVWBL monitoringAlarmIPVWBL) {
		this.monitoringAlarmIPVWBL = monitoringAlarmIPVWBL;
	}
	
	/**
	 * 同步告警系统视图BL设定
	 */
	public void setSynchronizationAlarmSystemVWBL(
			SynchronizationAlarmSystemVWBL synchronizationAlarmSystemVWBL) {
		this.synchronizationAlarmSystemVWBL = synchronizationAlarmSystemVWBL;
	}

	/**
	 * 告警系统显示信息BL设定
	 */
	public void setIndicatorLightsSystemBL(
			IndicatorLightsSystemBL indicatorLightsSystemBL) {
		this.indicatorLightsSystemBL = indicatorLightsSystemBL;
	}

	/**
	 * 机房列表画面初期显示
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO initIGASM1101Action(IGASM11DTO dto) throws BLException {

		log.debug("========机房列表画面初期显示处理开始========");
		
		//机房信息查询件数取得 
		SOC0601SearchCondImpl cond = new SOC0601SearchCondImpl();
		
		int totalCount = this.soc0601BL.getSOC0601InfoSearchCount(cond);
		
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
		pDto.setTotalCount(totalCount);

		//当前页机房信息取得
		List<SOC0601Info> entityItemVWInfoList = this.soc0601BL.searchSOC0601Info(cond, pDto.getFromCount(), pDto.getPageDispCount());
		
		
		for(Iterator<SOC0601Info> iter = entityItemVWInfoList.iterator();iter.hasNext();){
			SOC0601Info crvw = iter.next();
			if(StringUtils.isNotEmpty(crvw.getRelateroom())){
				iter.remove();
			}
		}
		//pDto.setTotalCount(entityItemVWInfoList.size());
		dto.setComputerRoomVWInfoList(entityItemVWInfoList);

		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========机房列表画面初期显示处理终了========");
		return dto;
	}

	/**
	 * 机房信息编辑画面初期显示
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO initIGASM1102Action(IGASM11DTO dto) throws BLException {
		log.debug("========机房信息编辑画面初期显示处理开始========");
		
		IGASM1102Form form = dto.getIgasm1102Form();
		
		//机房esyscoding为999007
		SOC0117SearchCondImpl econd = new SOC0117SearchCondImpl();
		econd.setEsyscoding("999007");
		econd.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_ROOM);
		List<SOC0117Info> li = this.soc0117BL.searchEntity(econd);
		//机房不允许类型登记,信息唯一,取eid
		SOC0117Info entity = li.get(0);
		SOC0109SearchCondImpl cond = new SOC0109SearchCondImpl();
		cond.setEid(entity.getEid().toString());
		cond.setCstatus("1");
		//取机房所有属性
		List<SOC0109Info> configurationList = this.soc0109BL.searchConfiguration(cond, 0, 0);
		String[] civalue = new String[configurationList.size()];
		int j = 0;
		for(SOC0109Info e : configurationList){
			if("2".equals(e.getCattach())){
				List<LabelValueBean> list = ig545BL.searchLabelValueBeanList(e.getCoption());
				form.setSelectedListMap(j++, list);
			}else
			if("5".equals(e.getCattach())){
				List<LabelValueBean> list = ig545BL.searchLabelValueBeanList(e.getCoption());
				if(list.size() > 0){
					list.remove(0);
				}
				form.setSelectedListMap(j++, list);
			}
		}

		form.setCivalue(civalue);
		dto.setConfigurationList(configurationList);
		dto.addMessage(new ActionMessage("IGCO10000.I001","机房信息"));
		
		log.debug("========机房信息编辑画面初期显示处理终了========");
		return dto;

	}

	/**
	 * 机房信息编辑画面初期显示
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO initEditIGASM1102Action(IGASM11DTO dto) throws BLException {
		log.debug("========机房信息编辑画面初期显示处理开始========");
		
		IGASM1102Form form = dto.getIgasm1102Form();
		
		//机房信息检索
		SOC0605Info entityItemVWInfo = this.soc0118BL.searchSOC0605InfoByKey(form.getEiid());
		
		SOC0606SearchCondImpl ciVW = new SOC0606SearchCondImpl();
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","机房");
		}

//		ciVW.setEiid(entityItemVWInfo.getEiid().toString());
		ciVW.setEiid(String.valueOf(entityItemVWInfo.getEiid()));
		form.setEilabel(entityItemVWInfo.getEilabel());
		form.setEiname(entityItemVWInfo.getEiname());
		form.setEiinsdate(entityItemVWInfo.getEiinsdate());
		form.setEidesc(entityItemVWInfo.getEidesc());
		dto.setEntityItemVWInfo(entityItemVWInfo);
		ciVW.setEsyscoding_q("999007");
		
		//机房配置信息查询件数取得 
		int totalCount = this.soc0107BL.getSOC0606InfoSearchCount(ciVW);
		
		if (totalCount == 0) {
			log.debug("========机房配置信息查询数据不存在========");
			//机房配置信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I007",0));
			return dto;
		} 
		
//		if ( totalCount > dto.getMaxSearchCount() ) {
//			log.debug("========机房配置信息查询数据件数过多========");
//			//机房配置信息查询数据件数过多
//			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
//			return dto;
//		}
		
		//机房配置信息全件查询
		List<SOC0606Info> configItemVWInfoList = this.soc0107BL.searchSOC0606Info(ciVW, 0, 0);
		
		String[] civalue = new String[totalCount];
		String[] delfile = new String[totalCount];
		int j = 0;
		int i = 0;
		for(SOC0606Info e : configItemVWInfoList){
			civalue[i++] = e.getCivalue();
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
		
		form.setCivalue(civalue);
		form.setDelfile(delfile);
		
		dto.setIgasm1102Form(form);
		dto.setConfigItemVWInfoList(configItemVWInfoList);
		dto.addMessage(new ActionMessage("IGCO10000.I001","机房信息"));
		
		log.debug("========机房信息编辑画面初期显示处理终了========");
		return dto;
		
	}
	
	/**
	 * 机房信息登记处理
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 * @update 0000428
	 */
	public IGASM11DTO insertComputerRoomInfoAction(IGASM11DTO dto) throws BLException, FileNotFoundException, IOException{
		log.debug("========机房信息登记处理开始========");
		
		//=============>   修改  0000428
		//1.输入Form取得
		IGASM1102Form form = dto.getIgasm1102Form();
		
		//2.资产类型ID取得
		SOC0117SearchCondImpl cond = new SOC0117SearchCondImpl();
		cond.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_ROOM);
		cond.setEsyscoding("999007");
		
		//登记处理前的资产信息确认
		List<SOC0117Info> entityList = this.soc0117BL.searchEntity(cond, 0, 0);
		
		if ( entityList == null || entityList.size() ==0 ) {
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","机房资产基本");
		}
		
		SOC0117Info entity = entityList.get(0);
		
		form.setEid(entity.getEid());
		form.setEidStr(entity.getEid().toString());
		
		//3.更新时间设定
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		
		form.setEiupdtime(datetime);
		//4.版本设定（固定设为1）
		form.setEiversion(1);
		
		//小版本设定（固定设为0）
		form.setEismallversion(0);
		form.setEiidStr(null);
		
		form.setEiuserid(dto.getUser().getUserid());
		form.setEiusername(dto.getUser().getUsername());
		//5.机房信息登录
		SOC0118Info ei = this.soc0118BL.registEntityItem(form);	

		
//--------------------------------------------------
			
		for( int i=0 ; i < form.getCid().length; i++ ){
			SOC0107TB configItem = new SOC0107TB();
			//机房ID
			configItem.setEiid(ei.getEiid());
			//资产配置ID
			configItem.setCid(form.getCid()[i]);
			//类型ID
			configItem.setEid(form.getEid());
			//类型层次码
			configItem.setEsyscoding("999007");
			//内容
			configItem.setCivalue(form.getCivalue()[i]);
			//更新时间
			configItem.setCiupdtime(datetime);
			//版本为1
			configItem.setCiversion(1);
			configItem.setCismallversion(0);
			configItem = (SOC0107TB) this.soc0107BL.registSOC0107(configItem);
			
			log.debug("资产配置项：[资产配置ID:" + form.getCid()[i] + "]登记处理成功。");
			
			
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
					
					this.soc0107BL.updateSOC0107(configItem);					
					
				}
			}
		}
			
//---------------------------------------------------------
		
		
//		form.setEiidStr(entityItem.getEiid().toString());
		dto.setEiid(ei.getEiid());
		dto.setIgasm1102Form(form);
		//<=============
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "机房信息") );

		log.debug("========机房信息登记处理终了========");
		return dto;
	}

	/**
	 * 机房信息编辑画面初期显示
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO updateComputerRoomAction(IGASM11DTO dto) throws BLException, FileNotFoundException, IOException {
		
		log.debug("========机房信息更新处理开始========");
		//1.输入Form取得
		IGASM1102Form form = dto.getIgasm1102Form();
		
		//2.资产类型ID取得
		SOC0117SearchCondImpl cond = new SOC0117SearchCondImpl();
		cond.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_ROOM);
		cond.setEsyscoding("999007");
		
		//登记处理前的资产信息确认
		List<SOC0117Info> entityList = this.soc0117BL.searchEntity(cond, 0, 0);
		
		if ( entityList == null || entityList.size() ==0 ) {
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","机房资产基本");
		}
		
		SOC0117Info entity = entityList.get(0);
		
		form.setEid(entity.getEid());
		form.setEidStr(entity.getEid().toString());
		
		//3.更新时间设定
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		
		form.setEiupdtime(datetime);
		
		//4.版本设定（固定设为1）
		form.setEiversion(1);
		form.setEiidStr(null);
		

		
//--------------------------------------------------
		//机房配置信息更新
		if (form.getCiid() != null && form.getCiid().length > 0 ) {		
			
			for( int i=0 ; i < form.getCiid().length; i++ ){
				SOC0107TB configItem = new SOC0107TB();
				//机房ID
				configItem.setEiid(form.getEiid());
				//资产配置ID
				configItem.setCid(form.getCid()[i]);
				//类型ID
				configItem.setEid(form.getEid());
				//类型层次码
				configItem.setEsyscoding("999007");
				//内容
				configItem.setCivalue(form.getCivalue()[i]);
				//更新时间
				configItem.setCiupdtime(datetime);
				//大版本号
				configItem.setCiversion(1);
				//小版本号
				configItem.setCismallversion(0);
				//附件删除
				if("1".equals(form.getCiattach()[i]) && "1".equals(form.getDelfile()[i])){
					configItem.setCivalue("");
				}
				if(StringUtils.isEmpty(form.getCiid()[i])){
					configItem = (SOC0107TB) this.soc0107BL.registSOC0107(configItem);
				}else{
					configItem.setCiid(Integer.parseInt(form.getCiid()[i]));
				}
				//更新机房信息
				SOC0118Info entityItem = this.soc0118BL.searchEntityItemByKey(form.getEiid());
				SOC0118TB eiTB = (SOC0118TB)SerializationUtils.clone(entityItem);
				eiTB.setEiname(form.getEiname());
				eiTB.setEilabel(form.getEilabel());
				eiTB.setEidesc(form.getEidesc());
				eiTB.setEiinsdate(form.getEiinsdate());
				eiTB.setEiupdtime(IGStringUtils.getCurrentDateTime());
				eiTB.setEiuserid(dto.getUser().getUserid());
				eiTB.setEiusername(dto.getUser().getUsername());
				
				this.soc0118BL.updateEntityItem(eiTB);		
				this.soc0107BL.updateSOC0107(configItem);		
				
				
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
						
						this.soc0107BL.updateSOC0107(configItem);					
						
					}
				}
			}
		}
//---------------------------------------------------------
		
		
//		form.setEiidStr(entityItem.getEiid().toString());
		
		dto.setIgasm1102Form(form);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "机房信息") );

		log.debug("========机房信息更新处理终了========");
		return dto;
	}
	
	/**
	 * 机柜信息登记处理
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO insertComputerContainerInfoAction(IGASM11DTO dto) throws BLException {
		log.debug("========机柜信息登记处理开始========");
		//1.输入Form取得
		IGASM1112Form form = dto.getIgasm1112Form();
		
		//2.资产类型ID取得
		SOC0117SearchCondImpl cond = new SOC0117SearchCondImpl();
		cond.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_CONTAINER);
		cond.setEcategory_q(CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_CONTAINER);
		
		//登记处理前的资产信息确认
		List<SOC0117Info> entityList = this.soc0117BL.searchEntity(cond, 0, 0);
		
		if ( entityList == null || entityList.size() ==0 ) {
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","机柜资产基本");
		}
		
		SOC0117Info entity = entityList.get(0);
		
		form.setEid(entity.getEid());
		form.setEidStr(entity.getEid().toString());
		
		//3.更新时间设定
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		
		form.setEiupdtime(datetime);
		
		//大版本设定（固定设为1）
		form.setEiversion(1);
		
		//小版本设定（固定设为0）
		form.setEismallversion(0);
		
		form.setEiidStr(null);

		//5.机柜信息登录
		SOC0118Info entityItem = this.soc0118BL.registEntityItem(dto.getIgasm1112Form());
		
		if(EntityItemKeyWords.VALUE_PULLDOWN.equals(form.getEimark()))
		{   
			//6.1容器类型配置项生成
			insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_L_TOTAL,
					form.getEimark(),"容器","容器类型",1,datetime);
			
			//6.1机柜位置（X）配置项生成
			insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_X_VALUE,
					form.getX_value(),"机架","机房中位置（X）",1,datetime);
			
			//6.2机柜位置（Y）配置项生成
			insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_Y_VALUE,
					form.getY_value(),"机架","机房中位置（Y）",1,datetime);
			
			//6.3机架高度（U）配置项生成
			insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_U_TOTAL,
					form.getJ_total(),"机架","机架高度（U）",1,datetime);
			//6.3机架宽度（W）配置项生成
			insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_W_TOTAL,
					form.getW_total(),"机架","机架宽度（W）",1,datetime);
			//6.4机柜横向宽配置项生成
			insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_X_WIDTH,
					form.getX_width(),"机架","机架横向宽",1,datetime);
			//6.5机柜纵向宽配置项生成
			insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_Y_WIDTH,
					form.getY_width(),"机架","机架纵向宽",1,datetime);
			
			insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_GRAPHSTATUS,
	                 "0", "机架","机柜上架设置",1,datetime);
			////6.7机柜上架设置生成
			insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_GRAPHINDEX,
				"0","机架","机架层设置",1,datetime);
			
			////6.8机架在机柜的位置
			insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_WZ_VALUE,
				"0","机架","机架位置设置",1,datetime);
			
			//6.9机架最大负载生成
	        insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_MAXLOAD,
	                form.getMaxload(),"机架","机架最大负载设置",1,datetime);

	        //6.10机架最大电力生成
	        insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_MAXPOWER,
	                form.getMaxpower(),"机架","机架最大电力设置",1,datetime);
		}
		else 
		{
		//6.1容器类型配置项生成
			insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_L_TOTAL,
					form.getEimark(),"容器","容器类型",1,datetime);
		//6.1机柜位置（X）配置项生成
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_X_VALUE,
				form.getX_value(),"机柜","机柜位置（X）",1,datetime);
		
		//6.2机柜位置（Y）配置项生成
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_Y_VALUE,
				form.getY_value(),"机柜","机柜位置（Y）",1,datetime);
		
		//6.3机柜高度（U）配置项生成
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_U_TOTAL,
				form.getU_total(),"机柜","机柜高度（U）",1,datetime);
		
		//6.4机柜横向宽配置项生成
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_X_WIDTH,
				form.getX_width(),"机柜","机柜横向宽",1,datetime);

		//6.5机柜纵向宽配置项生成
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_Y_WIDTH,
				form.getY_width(),"机柜","机柜纵向宽",1,datetime);
		
//		//6.6机柜上架设置生成
		
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_GRAPHSTATUS,
				                 "0", "机柜","机柜上架设置",1,datetime);
//		
//		//6.7机柜上架设置生成
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_GRAPHINDEX,
				"0","机柜","机柜层设置",1,datetime);
//		
		//6.10机柜电压设置生成
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_VOLTAGE,
				form.getVoltage(),"机柜","机柜电压设置",1,datetime);
		
		//6.8机柜重量设置
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_WEIGHT,
				form.getWeight(),"机柜","机柜重量设置",1,datetime);
		
		//6.9机柜规格设置生成
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_STANDARD,
				form.getStandard(),"机柜","机柜规格设置",1,datetime);
		
		//6.11机柜最大负载生成
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_MAXLOAD,
		        form.getMaxload(),"机柜","机柜最大负载设置",1,datetime);

		//6.12机柜最大电力生成
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_MAXPOWER,
		        form.getMaxpower(),"机柜","机柜最大电力设置",1,datetime);
		}
		
		form.setEiidStr(entityItem.getEiid().toString());
		
		dto.setIgasm1112Form(form);
		
		if(EntityItemKeyWords.VALUE_PULLDOWN.equals(form.getEimark()))
		{
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "机架信息") );
		}
		else
		{
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "机柜信息") );
		}

		log.debug("========机柜信息登记处理终了========");
		return dto;
	}

	/**
	 * 配置项信息添加处理
	 *
	 * @param entityItem EntityItem 资产项
	 * @param clabel String 配置编号
	 * @param civalue String 配置值
	 * @param sErrParam0 String 错误信息参数0
	 * @param sErrParam1 String 错误信息参数1 
	 * @param civersion Integer 配置版本
	 * @return
	 */
	protected void insertConfigItem(SOC0118Info entityItem,
			String clabel,String civalue,String sErrParam0,String sErrParam1,
			Integer civersion) throws BLException {
		//1.查询条件生成
		SOC0109SearchCondImpl configCond = new SOC0109SearchCondImpl();
		//configCond.setEid(entityItem.getEid().toString());
		configCond.setClabel(clabel);
		
		//2.配置项查询
		List<SOC0109Info> configList = this.soc0109BL.searchConfiguration(configCond, 0, 0);
		
		if ( configList == null || configList.size()==0 ) {
			throw new BLException("IGCO10000.E013",sErrParam0,sErrParam1);
		}
		
		//2.配置项内容生成
		SOC0107TB configItemTB = new SOC0107TB();
		
		//资产项ID
		configItemTB.setEiid(entityItem.getEiid());
		//资产ID
		configItemTB.setEid(entityItem.getEid());
		//资产配置ID
		configItemTB.setCid(configList.get(0).getCid());
		//资产配置值
		configItemTB.setCivalue(civalue);
		
		//资产配置版本
		configItemTB.setCiversion(civersion);
		
		if(EntityItemKeyWords.CLABEL_U_VALUE.equals(clabel)) {
			//属性更新标识
			configItemTB.setCicurver("1");
		} else {
			//属性更新标识
			configItemTB.setCicurver("0");
		}
		
		//资产配置更新时间
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		
		configItemTB.setCiupdtime(datetime);
		
		//3.配置信息登记
		this.soc0107BL.registSOC0107(configItemTB);
		
	}
	protected void insertConfigItem(SOC0118Info entityItem,
			String clabel,String civalue,String sErrParam0,String sErrParam1,
			Integer civersion, String nowdate) throws BLException {
		//1.查询条件生成
		SOC0109SearchCondImpl configCond = new SOC0109SearchCondImpl();
		//configCond.setEid(entityItem.getEid().toString());
		configCond.setClabel(clabel);
		
		//2.配置项查询
		List<SOC0109Info> configList = this.soc0109BL.searchConfiguration(configCond, 0, 0);
		
		if ( configList == null || configList.size()==0 ) {
			throw new BLException("IGCO10000.E013",sErrParam0,sErrParam1);
		}
		
		//2.配置项内容生成
		SOC0107TB configItemTB = new SOC0107TB();
		
		//资产项ID
		configItemTB.setEiid(entityItem.getEiid());
		//资产ID
		configItemTB.setEid(entityItem.getEid());
		//资产配置ID
		configItemTB.setCid(configList.get(0).getCid());
		//资产配置值
		configItemTB.setCivalue(civalue);
		
		//资产配置版本
		configItemTB.setCiversion(civersion);
		
		//资产配置更新时间
		configItemTB.setCiupdtime(nowdate);
		
		configItemTB.setCismallversion(0);
		
		//3.配置信息登记
		this.soc0107BL.registSOC0107(configItemTB);
		
	}
	/**
	 * 机房信息删除处理
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO deleteComputerRoomInfoAction(IGASM11DTO dto) throws BLException {
		log.debug("========机房信息删除处理开始========");
		for(int i=0;i<dto.getDeleteEntityItem().length;i++){
			String eiid = dto.getDeleteEntityItem()[i];
			SOC0119SearchCondImpl cond = new SOC0119SearchCondImpl();
//			cond.setPareiid(eiid);
			cond.setPareiid(Integer.parseInt(eiid));
			cond.setDeleteflag("0");
			int count = this.soc0119BL.getEntityItemRelationSearchCount(cond);
			if(count>0){
				SOC0118Info entityItem = this.soc0118BL.searchEntityItemByKey(Integer.parseInt(eiid));
				dto.addMessage(new ActionMessage("IGASM1101.E001",entityItem.getEiname()));
				return dto;
			}
		}
		for( int i=0;i<dto.getDeleteEntityItem().length;i++ ){
			String eiid = dto.getDeleteEntityItem()[i];
			
			//删除前删除对象机房确认
			SOC0118Info entityItem = this.soc0118BL.searchEntityItemByKey(Integer.parseInt(eiid));
			
			if (entityItem == null){
				throw new BLException("IGCO10000.E004","删除对象机房");
			}

			//机房删除
			this.soc0118BL.deleteEntityItem(entityItem);
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I006","机房信息"));

		log.debug("========机房信息删除处理终了========");
		return dto;
	}

	/**
	 * 机柜移除处理
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO moveoutComputerContainerAction(IGASM11DTO dto) throws BLException {
		log.debug("========机柜移除处理开始========");
		IGASM1104Form form = dto.getIgasm1104Form();

		//1.机柜设定信息检索
		SOC0119SearchCondImpl cond = 
			new SOC0119SearchCondImpl();
		//机房ID
//		cond.setPareiid(form.getEiid());
		cond.setPareiid(Integer.parseInt(form.getEiid()));
		//机柜ID设定
//		cond.setCldeiid(form.getContainer_eiid());
		cond.setCldeiid(Integer.parseInt(form.getContainer_eiid()));
		
		//机柜和机房的所属关系设定
		cond.setEirrelation(CommonDefineUtils.ROOM_CONTAINER_ASSIGN_RELATION);
		
		List<SOC0119Info> entityItemRelationList = 
			this.soc0119BL.searchMaxEntityItemRelation(cond);
		
		//2.现有关系删除
		if (entityItemRelationList != null && entityItemRelationList.size()>0 ) {
			for (SOC0119Info res:entityItemRelationList) {
				this.soc0119BL.deleteEntityItemRelation(res);
			}
		}
		
		//3.机柜信息取得
		SOC0118Info entityItem = 
			this.soc0118BL.searchEntityItemByKey(Integer.parseInt(form.getContainer_eiid()));
		
		if (entityItem == null) {
			throw new BLException("IGCO10000.E004","机柜");
		}
		
		//4.当前版本取得
		Integer cur_version = entityItem.getEiversion();
		
		//5.当前配置信息取得
		SOC0107SearchCondImpl ciCond = new SOC0107SearchCondImpl();
		
//		ciCond.setEiid(form.getContainer_eiid());
		ciCond.setEiid(form.getContainer_eiid());
		ciCond.setCiversion(cur_version.toString());
		
		List<SOC0107Info> configItemList = 
			this.soc0107BL.searchSOC0107(ciCond, 0, 0);
		
		//更新时间设定
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

		//6.机柜位置配置以外的配置版本信息升级
		if (configItemList!=null && configItemList.size()>0) {
			//版本升级
			for (SOC0107Info item:configItemList) {
				String clabel = item.getConfiguration().getClabel();
				//机柜位置以外的配置版本更新
				if (clabel==null||(!clabel.equals(EntityItemKeyWords.CLABEL_X_VALUE) 
						&& !clabel.equals(EntityItemKeyWords.CLABEL_Y_VALUE) )) {
					SOC0107TB configItemTB = (SOC0107TB) SerializationUtils.clone((Serializable) item);				
					configItemTB.setCiid(null);
					configItemTB.setCiversion(cur_version+1);
					configItemTB.setCiupdtime(datetime);
					this.soc0107BL.registSOC0107(configItemTB);
				}
			}
		}
		
		//7.机柜位置（X）配置项生成
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_X_VALUE,
				"","机柜","机柜位置（X）",cur_version+1,datetime);
		
		//8.机柜位置（Y）配置项生成
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_Y_VALUE,
				"","机柜","机柜位置（Y）",cur_version+1,datetime);
		
		//9.机柜版本升级
		SOC0118TB entityItemTB = (SOC0118TB)entityItem;
		
		entityItemTB.setEiversion(cur_version+1);
		
		this.soc0118BL.updateEntityItem(entityItemTB);
		
		log.debug("========机柜移除处理终了========");
		
		return dto;
	}
	
	/**
	 * 机房平面图管理画面初期化处理
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO initIGASM1104Action(IGASM11DTO dto) throws BLException {

		log.debug("========机房平面图管理画面初期化处理开始========");
		
		IGASM1104Form form = dto.getIgasm1104Form();
		
		//1.机房信息检索
		SOC0601Info computerRoomVWInfo = 
			this.soc0601BL.searchSOC0601InfoByKey(form.getEiid());
		
		if ( computerRoomVWInfo == null) {
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","机房");
		}
		
		//2.机房横向和纵向长设定检测
		if (StringUtils.isEmpty(computerRoomVWInfo.getX_total())) {
			throw new BLException("IGCO10000.E013","机房","横向宽");
		}
		
		if (StringUtils.isEmpty(computerRoomVWInfo.getY_total())) {
			throw new BLException("IGCO10000.E013","机房","纵向宽");
		}

		//4.机柜信息取得
		SOC0603SearchCondImpl cond = 
			new SOC0603SearchCondImpl();
		
		cond.setRoom_eiid(Integer.parseInt(form.getEiid()));
		
		List<SOC0603Info> computerContainerVWInfoList = 
			this.soc0603BL.searchSOC0603Info(cond, 0, 0);
		
		dto.setComputerRoomVWInfo(computerRoomVWInfo);
		dto.setComputerContainerVWInfoList(computerContainerVWInfoList);
		
		log.debug("========机房平面图管理画面初期化处理终了========");
		return dto;
	}
	
	/**
	 * 机柜选择画面初期化处理
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO initIGASM1105Action(IGASM11DTO dto) throws BLException {

		log.debug("========机柜选择画面初期化处理开始========");
		
		IGASM1105Form form = dto.getIgasm1105Form();
		
		//1.机房信息取得
		SOC0601Info computerRoomVW = 
			this.soc0601BL.searchSOC0601InfoByKey(form.getCur_room_eiid());
		
		//
		form.setCur_room_name(computerRoomVW.getEiname());
		form.setRoom_eid(computerRoomVW.getEid().toString());
		
		//2.机柜信息取得
		//机柜查询件数取得 
		int totalCount = this.soc0603BL.getSOC0603InfoSearchCount(form);
		
		if (totalCount == 0) {
			log.debug("========资产信息查询数据不存在========");
			//机柜查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========资产信息查询数据件数过多========");
			//机柜查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//分页用信息取得
		PagingDTO pDto = dto.getPagingDto();

		pDto.setTotalCount(totalCount);
		
		List<SOC0603Info> computerContainerVWInfoList = 
			this.soc0603BL.searchSOC0603Info(form,  pDto.getFromCount(), pDto.getPageDispCount());
		
		dto.setComputerContainerVWInfoList(computerContainerVWInfoList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));

		log.debug("========机柜选择画面初期化处理终了========");
		return dto;
	}

	/**
	 * 机柜设定处理
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO setComputerContainerAction(IGASM11DTO dto) throws BLException {
		log.debug("========机柜设定处理开始========");
		//0.机柜设定前检测
		checkContainer(dto);
		
		IGASM1105Form form = dto.getIgasm1105Form();

		//1.机柜设定信息检索
		SOC0119SearchCondImpl cond = 
			new SOC0119SearchCondImpl();
		//机房ID
		//cond.setPareiid(form.getCur_room_eiid());
		//机柜ID设定
		cond.setCldeiid(Integer.parseInt(form.getSel_container_eiid()));
		
		//机柜和机房的所属关系设定
		cond.setEirrelation(CommonDefineUtils.ROOM_CONTAINER_ASSIGN_RELATION);
		
		List<SOC0119Info> entityItemRelationList = 
			this.soc0119BL.searchMaxEntityItemRelation(cond);
		
		//2.现有关系删除
		if (entityItemRelationList != null && entityItemRelationList.size()>0 ) {
			for (SOC0119Info res:entityItemRelationList) {
				this.soc0119BL.deleteEntityItemRelation(res);
			}
		}
		
		//3.机柜信息取得
		SOC0118Info entityItem = 
			this.soc0118BL.searchEntityItemByKey(Integer.parseInt(form.getSel_container_eiid()));
		
		if (entityItem == null) {
			throw new BLException("IGCO10000.E004","机柜");
		}
		
		//4.机房机柜所属关系生成
		SOC0119TB entityItemRelation = new SOC0119TB();
		entityItemRelation.setPareiid(Integer.parseInt(form.getCur_room_eiid()));
		entityItemRelation.setPareid(form.getRoom_eid());
		entityItemRelation.setCldeiid(Integer.parseInt(form.getSel_container_eiid()));
		entityItemRelation.setCldeid(entityItem.getEid());
		entityItemRelation.setEirrelation(CommonDefineUtils.ROOM_CONTAINER_ASSIGN_RELATION);
		entityItemRelation.setEirrelationcode(CommonDefineUtils.ROOM_CONTAINER_ASSIGN_RELATION_CODE);
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		
		entityItemRelation.setEirupdtime(datetime);
		
		this.soc0119BL.registEntityItemRelation(entityItemRelation);
		
		//5.当前版本取得
		Integer cur_version = entityItem.getEiversion();
		
		//6.当前配置信息取得
		SOC0107SearchCondImpl ciCond = new SOC0107SearchCondImpl();
		
		ciCond.setEiid(form.getSel_container_eiid());
		ciCond.setCiversion(cur_version.toString());
		
		List<SOC0107Info> configItemList = 
			this.soc0107BL.searchSOC0107(ciCond, 0, 0);
		
		//7.机柜位置配置以外的配置版本信息升级
		if (configItemList!=null && configItemList.size()>0) {
			//版本升级
			for (SOC0107Info item:configItemList) {
				String clabel = item.getConfiguration().getClabel();
				//机柜位置以外的配置版本更新
				if (clabel==null||(!clabel.equals(EntityItemKeyWords.CLABEL_X_VALUE) 
						&& !clabel.equals(EntityItemKeyWords.CLABEL_Y_VALUE) )) {
					SOC0107TB configItemTB = (SOC0107TB) SerializationUtils.clone((Serializable) item);
					configItemTB.setCiid(null);
					configItemTB.setCiversion(cur_version+1);
					configItemTB.setCiupdtime(datetime);
					this.soc0107BL.registSOC0107(configItemTB);
				}
			}
		}
		
		//8.机柜位置（X）配置项生成
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_X_VALUE,
				form.getCur_room_x_value(),"机柜","机柜位置（X）",cur_version+1,datetime);
		
		//9.机柜位置（Y）配置项生成
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_Y_VALUE,
				form.getCur_room_y_value(),"机柜","机柜位置（Y）",cur_version+1,datetime);
		
		//10.机柜版本升级
		SOC0118TB entityItemTB = (SOC0118TB)entityItem;
		
		entityItemTB.setEiversion(cur_version+1);
		
		this.soc0118BL.updateEntityItem(entityItemTB);
		
		log.debug("========机柜设定处理终了========");
		return dto;
	}
	
	/**
	 * 取得已上架的机柜列表并组装成XML
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO getDefJiguiXml(IGASM11DTO dto) throws BLException {

		log.debug("========机柜XML初期化处理开始========");
		
		//1.机柜检索条件生成
		SOC0603SearchCondImpl cond = new SOC0603SearchCondImpl();
		List<SOC0603Info> computerContainerVWInfoList = this.soc0603BL.searchSOC0603Info(cond,  0, 0);
		StringBuffer jiguiXml =  new StringBuffer("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		jiguiXml.append("<ROOT>");
		jiguiXml.append("<TOOLS>");

		if(computerContainerVWInfoList!=null){
			for(SOC0603Info ccBean:computerContainerVWInfoList){
				jiguiXml.append("<img x=\"0\" y=\"0\" ontools=\"y\" " +
						"id=\"jiguiImg"+ccBean.getEiid()+ "\"  " +				//机柜ID
						"type=\""+"t1"+"\"  "+			//机柜类型		
						"title=\""+ccBean.getEiname()+"\"  "+  					//机柜名称
						"eilabel=\""+ccBean.getEilabel()+"\"  "+				//机柜编号
						"gaodu=\""+ccBean.getU_total()+"(U)\" />"); 			//机柜高度
			}
		}
		jiguiXml.append("</TOOLS>");
		jiguiXml.append("</ROOT>");

		dto.setJiguiXml(jiguiXml.toString());

		log.debug("========机柜XML初期化处理终了========");
		return dto;
	}
	
	/**
	 * 取得未上架的机柜列表并组装成XML
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO getToolsXml(IGASM11DTO dto) throws BLException {

		log.debug("========机柜XML初期化处理开始========");
		
		//1.机柜检索条件生成
		SOC0603SearchCondImpl cond = new SOC0603SearchCondImpl();
		cond.setGraphstatus("0");
		List<SOC0603Info> computerContainerVWInfoList = this.soc0603BL.searchSOC0603Info(cond,  0, 0);
		
		// 过滤掉未添加配置信息的资产数据
		List<SOC0603Info> upsList = this.soc0603BL.searchUpsAndAirSOC0603Info(cond);
		for (int i = 0; i < upsList.size(); i++) {
			SOC0107SearchCondImpl configCond = new SOC0107SearchCondImpl();
			configCond.setEiid(upsList.get(i).getEiid().toString());
			List<SOC0107Info> configList = soc0107BL.searchSOC0107(configCond);
			if (configList != null && !configList.isEmpty()) {
				computerContainerVWInfoList.add(upsList.get(i));
			}
		}
		
		CompareTemplateSearchCondImpl ctcond = new CompareTemplateSearchCondImpl();
		ctcond.setCategory("jigui");
		List<CompareTemplateInfo> ctList = compareTemplateBL.searchCompareTemplate(ctcond, 0, 0);
		Map<String,String> ctMap = new HashMap<String,String>();
		if(ctList!=null){
			for(CompareTemplateInfo ctbean:ctList){
				ctMap.put(ctbean.getCtx()+ctbean.getCty(), ctbean.getCttype());
			}
		}
		
		StringBuffer toolsXml =  new StringBuffer("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		toolsXml.append("<ROOT>");
		toolsXml.append("<TOOLS>");
		String type = "t1";
		String id = "";
		if(computerContainerVWInfoList!=null){
			for(SOC0603Info ccBean:computerContainerVWInfoList){
				if (EntityItemKeyWords.VALUE_PULLDOWN.equals(ccBean.getContainertype())) {
					type = "shelf14";
					id = ccBean.getEiid().toString();
				} else if (ccBean.getContainertype() != null && ccBean.getContainertype().startsWith(EntityItemKeyWords.VALUE_UPS)) {// UPS
					type = "UPS";
					id = ccBean.getEiid().toString();
				} else if (ccBean.getContainertype() != null && ccBean.getContainertype().startsWith(EntityItemKeyWords.VALUE_AIR_CONDITION)) {// 空调
					// 取得空调类型
					if (StringUtils.isNotEmpty(ccBean.getEitype()) && ccBean.getEitype().equals("挂式")) {
						type = "a1";
					}else{
						type = "a3";
					}
					id = ccBean.getEiid().toString();
				} else {
					type = "t1";
					id = ccBean.getEiid().toString();
				}
				if(ctMap.get(ccBean.getX_width()+ccBean.getY_width())!=null){
					type = ctMap.get(ccBean.getX_width()+ccBean.getY_width());
				}
				String eilabel = ccBean.getEilabel().startsWith("SBZC") ? ccBean.getEilabel().substring(4) : ccBean.getEilabel();
				toolsXml.append("<img x=\"0\" y=\"0\" ontools=\"y\"")
						.append(" id=\"" + id + "\"  ")							//机柜ID
						.append(" type=\""+type+"\"  ")							//机柜类型		
						.append(" title=\""+ccBean.getEiname()+"\"  ")  		//机柜名称
						.append(" eilabel=\""+ eilabel +"\"  ")					//机柜编号
						.append(" gaodu=\""+ccBean.getU_total()+"(U)\" />"); 	//机柜高度
			}
		}
		toolsXml.append("</TOOLS>");
		toolsXml.append("</ROOT>");

		dto.setToolsXml(toolsXml.toString());

		log.debug("========机柜XML初期化处理终了========");
		return dto;
	}
	/**
	 * 取得过道地板信息并组装成XML
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO getGuodaoXml(IGASM11DTO dto) throws BLException {

		log.debug("========机柜XML初期化处理开始========");
		IGASM1104Form form = dto.getIgasm1104Form();
		CompareTemplateSearchCondImpl ctcond = new CompareTemplateSearchCondImpl();
		ctcond.setCategory(form.getEiid());
		ctcond.setType("guodao");
		List<CompareTemplateInfo> ctList = compareTemplateBL.searchCompareTemplate(ctcond, 0, 0);
		
		StringBuffer guodaoXml =  new StringBuffer("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		guodaoXml.append("<ROOT>");
		guodaoXml.append("<GUODAO>");
		if(ctList!=null){
			for(CompareTemplateInfo ctbean:ctList){
				guodaoXml.append("<img id=\""+ctbean.getCttype()+"\"/>");
			}
		}
		guodaoXml.append("</GUODAO>");
		guodaoXml.append("</ROOT>");

		dto.setGuodaoXML(guodaoXml.toString());

		log.debug("========机柜XML初期化处理终了========");
		return dto;
	}
	
	/**
	 * 取得已上架的机柜列表并组装成XML
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO getJiguiXml(IGASM11DTO dto) throws BLException {

		log.debug("========机柜XML初期化处理开始========");
		IGASM1104Form form = dto.getIgasm1104Form();
	
		//查询机柜坐标，类型信息
		CompareTemplateSearchCondImpl ctcond = new CompareTemplateSearchCondImpl();
		ctcond.setCategory(form.getEiid());
		ctcond.setNotZoneAndNotNafFlag("ok");
	
		//获取机柜XML
		StringBuffer jiguiXml =  new StringBuffer("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		jiguiXml.append("<ROOT>");
		jiguiXml.append("<JIGUI>");

		
		List<CompareTemplateInfo> ctlegList = compareTemplateBL.searchCompareTemplate(ctcond, 0, 0);
		
		if(ctlegList!=null&& !ctlegList.isEmpty()){
			for(CompareTemplateInfo legbean:ctlegList){
				String id = (legbean.getCteiid()==null?legbean.getCtpid().toString():legbean.getCteiid());
				jiguiXml.append("<img ");
				jiguiXml.append("x=\""+legbean.getCtx()+ "\"  " );				    //X坐标
				jiguiXml.append("y=\""+legbean.getCty()+ "\"  " );				    //Y坐标
				jiguiXml.append("floorx=\""+legbean.getCtfloorx()+ "\"  " );	    	//地板块X坐标
				jiguiXml.append("floory=\""+legbean.getCtfloory()+ "\"  " );	    	//地板块y坐标
				jiguiXml.append("title=\" "+(legbean.getCteiid()!=null?searchDeviceInfo(legbean.getCteiid()).getEiname():"")+ "\"  " );//设备资产name
				jiguiXml.append("eilabel=\" "+(legbean.getCteiid()==null?legbean.getCtpid().toString():legbean.getCteiid())+ "\"  " );//设备资产id
				jiguiXml.append("zone=\""+legbean.getCtZoneId()+ "\"  " );			//所属分区
				jiguiXml.append("id=\"" + (legbean.getCteiid()==null?legbean.getCtpid().toString():legbean.getCteiid()) + "\"  " );//机柜ID
				jiguiXml.append("type=\""+legbean.getCttype()+"\"  ");				//机柜类型
				jiguiXml.append("pkid=\""+legbean.getCtpid().toString()+"\" />");	//流水号
				jiguiXml.append("lightstype=\""+getIndicatorLights(id)+"\" />");	//指示灯类型
			}
		}
		
		jiguiXml.append("</JIGUI>");
		jiguiXml.append("</ROOT>");

		dto.setJiguiXml(jiguiXml.toString());

		log.debug("========机柜XML初期化处理终了========");
		return dto;
	}
	public static void main(String[] args) {
	  //获取机柜XML
        StringBuffer jiguiXml =  new StringBuffer("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        jiguiXml.append("<ROOT>");
        jiguiXml.append("<JIGUI>");
        jiguiXml.append("</JIGUI>");
        jiguiXml.append("</ROOT>");

       System.out.println(jiguiXml.toString());

    }
	//
	private SOC0118Info searchDeviceInfo(String PK){
		SOC0118Info devInfo=null;
		try {
			devInfo=soc0118BL.searchEntityItemByKey( Integer.parseInt(PK) );
		} catch (NumberFormatException e) {
			//
			e.printStackTrace();
		} catch (BLException e) {
			//
			e.printStackTrace();
		}
		if(devInfo == null){
			return new SOC0118TB();
		}
		return devInfo;
	}
	
	/**
	 * 机柜列表画面初期化处理
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO initIGASM1111Action(IGASM11DTO dto) throws BLException {

		log.debug("========机柜列表画面初期化处理开始========");
		
		//1.机柜检索条件生成
		SOC0603SearchCondImpl cond = 
			new SOC0603SearchCondImpl();
		
		//2.机柜信息取得
		//机柜查询件数取得 
		int totalCount = this.soc0603BL.getSOC0603InfoSearchCount(cond);
		
		if (totalCount == 0) {
			log.debug("========资产信息查询数据不存在========");
			//机柜查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========资产信息查询数据件数过多========");
			//机柜查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//分页用信息取得
		PagingDTO pDto = dto.getPagingDto();

		pDto.setTotalCount(totalCount);
		
		List<SOC0603Info> computerContainerVWInfoList = 
			this.soc0603BL.searchSOC0603Info(cond,  pDto.getFromCount(), pDto.getPageDispCount());
		
		dto.setComputerContainerVWInfoList(computerContainerVWInfoList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));

		log.debug("========机柜列表画面初期化处理终了========");
		return dto;
	}

	/**
	 * 机柜信息删除处理
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO deleteComputerContainerInfoAction(IGASM11DTO dto) throws BLException {
		log.debug("========机柜信息删除处理开始========");
		for(int i=0;i<dto.getDeleteEntityItem().length;i++){
			String eiid = dto.getDeleteEntityItem()[i];
			SOC0119SearchCondImpl cond = new SOC0119SearchCondImpl();
			cond.setPareiid(Integer.parseInt(eiid));
			cond.setDeleteflag("0");
			int count = this.soc0119BL.getEntityItemRelationSearchCount(cond);
			if(count>0){
				SOC0118Info entityItem = this.soc0118BL.searchEntityItemByKey(Integer.parseInt(eiid));
				dto.addMessage(new ActionMessage("IGASM1111.E001",entityItem.getEilabel()));
				return dto;
			}
		}
		for( int i=0;i<dto.getDeleteEntityItem().length;i++ ){
			String eiid = dto.getDeleteEntityItem()[i];
			
			//删除前删除对象机房确认
			SOC0118Info entityItem = this.soc0118BL.searchEntityItemByKey(Integer.parseInt(eiid));
			
			if (entityItem == null){
				throw new BLException("IGCO10000.E004","删除对象机柜");
			}

			//机房删除
			this.soc0118BL.deleteEntityItem(entityItem);
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I006","机柜信息"));

		log.debug("========机柜信息删除处理终了========");
		return dto;
	}

	/**
	 * 机柜信息编辑画面初期显示
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO initIGASM1112Action(IGASM11DTO dto) throws BLException {
		log.debug("========机柜信息编辑画面初期显示处理开始========");
		
		IGASM1112Form form = dto.getIgasm1112Form();
		
		String eiidStr = form.getEiidStr();
		SOC0107SearchCondImpl cond = new SOC0107SearchCondImpl();
		//cond.setCid(EntityItemKeyWords.LABEL_PULLDOWN);
		cond.setEiid(eiidStr);
		List<SOC0107Info> configItem =this.soc0107BL.searchSOC0107(cond);
		if(configItem==null)
		{
			throw new BLException("IGCO10000.E004","变更对象");
		}
		
		//显示用机柜信息取得
		SOC0603Info computerContainerVWInfo = 
			this.soc0603BL.searchSOC0603InfoByKey(eiidStr);
		
		if ( computerContainerVWInfo == null ){
			throw new BLException("IGCO10000.E004","变更对象机柜");
		}
		
		CompareTemplateSearchCondImpl ctcond = new CompareTemplateSearchCondImpl();
		ctcond.setType("jigui"+computerContainerVWInfo.getEiid());
		
		List<CompareTemplateInfo> ctList = compareTemplateBL.searchCompareTemplate(ctcond, 0, 0);
		
		String eimark = "";
		for (SOC0107Info soc0107Info : configItem) {
			if(soc0107Info.getCid().equals("CI110000000019")){
				eimark = soc0107Info.getCivalue();
			}
		}
		//画面显示设定
		if(configItem.size()==0) {
			form.setEimark(EntityItemKeyWords.CLABEL_PULLDOWN);
		} else {
			form.setEimark(eimark);
		}
		
		
		form.setEilabel(computerContainerVWInfo.getEilabel());
		form.setEiname(computerContainerVWInfo.getEiname());
		form.setEidesc(computerContainerVWInfo.getEidesc());
		form.setEiidStr(computerContainerVWInfo.getEiid().toString());
		form.setEidStr(computerContainerVWInfo.getEid().toString());
		form.setEiinsdate(computerContainerVWInfo.getEiinsdate());
		form.setU_total(computerContainerVWInfo.getU_total());
		form.setW_total(computerContainerVWInfo.getWidth());
		if(ctList != null && ctList.size() !=0){
		    form.setX_value(ctList.get(0).getCtx());
		    form.setY_value(ctList.get(0).getCty());
		} else {
			form.setX_value("");
			form.setY_value("");
			form.setWz_value(computerContainerVWInfo.getU_value());
		}
		form.setX_width(computerContainerVWInfo.getX_width());
		form.setY_width(computerContainerVWInfo.getY_width());
		form.setVoltage(computerContainerVWInfo.getVoltage());
		form.setWeight(computerContainerVWInfo.getWeight());
		form.setX_value(computerContainerVWInfo.getX_value());
		form.setY_value(computerContainerVWInfo.getY_value());
		
		form.setStandard(computerContainerVWInfo.getStandard());
		form.setMaxload(computerContainerVWInfo.getMaxload());
		form.setMaxpower(computerContainerVWInfo.getMaxpower());
		//版本信息
		if (StringUtils.isNotEmpty(computerContainerVWInfo.getEiversion().toString())) {
			form.setEiversion(computerContainerVWInfo.getEiversion());
		} else {
			form.setEiversion(1);
		}
		
		//编辑模式设定
		form.setMode("1");
		
		//dto.setIgasm1102Form(form);
		// 数值1代表机架，0代表机柜
		if(EntityItemKeyWords.VALUE_PULLDOWN.equals(eimark))
		{
		dto.addMessage(new ActionMessage( "IGCO10000.I001", "机架信息"));
		}
		else
		{
		dto.addMessage(new ActionMessage("IGCO10000.I001","机柜信息"));
		}
		log.debug("========机柜信息编辑画面初期显示处理终了========");
		return dto;
	}
	
	/**
	 * 机柜信息更新处理
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO updateComputerContainerAction(IGASM11DTO dto) throws BLException {
		log.debug("========机柜信息更新处理开始========");
		
		//1.输入Form取得
		IGASM1112Form form = dto.getIgasm1112Form();
		
		//2.更新时间设定
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		
		Integer cur_version = form.getEiversion();
		//同步
		if(!this.soc0118BL.searchEntityItemByKey(form.getEiid()).getEiversion().equals(cur_version)) {
			throw new BLException("IGCO00000.E004");
		}
		form.setEiversion(cur_version+1);
		
		form.setEiupdtime(datetime);
		
		//3.机柜信息登录
		SOC0118Info entityItem = this.soc0118BL.updateEntityItem(dto.getIgasm1112Form());
		
		//4.当前配置信息取得
		SOC0107SearchCondImpl ciCond = new SOC0107SearchCondImpl();
		
		ciCond.setEiid(form.getEiidStr());
		ciCond.setCiversion(cur_version.toString());
		
		List<SOC0107Info> configItemList = 
			this.soc0107BL.searchSOC0107(ciCond, 0, 0);
		
		//5.机柜配置以外的配置版本信息升级
		if (configItemList!=null && configItemList.size()>0) {
			//版本升级
			for (SOC0107Info item:configItemList) {
				String clabel = item.getConfiguration().getClabel();
				//机柜位置以外的配置版本更新
				if (clabel==null||(!clabel.equals(EntityItemKeyWords.CLABEL_U_TOTAL) 
						&& !clabel.equals(EntityItemKeyWords.CLABEL_X_VALUE)
						&& !clabel.equals(EntityItemKeyWords.CLABEL_Y_VALUE)
						&& !clabel.equals(EntityItemKeyWords.CLABEL_X_WIDTH)
						&& !clabel.equals(EntityItemKeyWords.CLABEL_Y_WIDTH)
						&& !clabel.equals(EntityItemKeyWords.CLABEL_WEIGHT)
						&& !clabel.equals(EntityItemKeyWords.CLABEL_STANDARD)
						&& !clabel.equals(EntityItemKeyWords.CLABEL_VOLTAGE)
						&& !clabel.equals(EntityItemKeyWords.CLABEL_MAXLOAD)
						&& !clabel.equals(EntityItemKeyWords.CLABEL_MAXPOWER)
				)) {
					SOC0107TB configItemTB = (SOC0107TB) SerializationUtils.clone((Serializable) item);
					configItemTB.setCiid(null);
					configItemTB.setCiversion(cur_version+1);
					configItemTB.setCiupdtime(datetime);
					this.soc0107BL.registSOC0107(configItemTB);
				}
			}
		}
		
		//6.机柜配置项登录
		
		//6.1机柜高配置项生成
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_U_TOTAL,
				form.getU_total(),"机柜","机柜高",cur_version+1,datetime);
		
		//6.2机柜位置（X）配置项生成
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_X_VALUE,
				form.getX_value(),"机柜","机柜位置（X）",cur_version+1,datetime);
		
		//6.3负责人配置项生成
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_Y_VALUE,
				form.getY_value(),"机柜","机柜位置（Y）",cur_version+1,datetime);
		
		//6.4机柜横向宽配置项生成
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_X_WIDTH,
				form.getX_width(),"机柜","机柜横向宽",cur_version+1,datetime);
		
		//6.3机柜纵向宽配置项生成
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_Y_WIDTH,
				form.getY_width(),"机柜","机柜纵向宽",cur_version+1,datetime);
		
		//6.8机柜重量设置
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_WEIGHT,
				form.getWeight(),"机柜","机柜重量设置",cur_version+1,datetime);
		
		//6.9机柜规格设置生成
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_STANDARD,
				form.getStandard(),"机柜","机柜规格设置",cur_version+1,datetime);
		
		//6.10机柜电压设置生成
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_VOLTAGE,
				form.getVoltage(),"机柜","机柜电压设置",cur_version+1,datetime);
		
		//6.11机柜最大负载生成
        insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_MAXLOAD,
                form.getMaxload(),"机柜","机柜最大负载设置",cur_version+1,datetime);

        //6.12机柜最大电力生成
        insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_MAXPOWER,
                form.getMaxpower(),"机柜","机柜最大电力设置",cur_version+1,datetime);
		
		form.setEiversion(cur_version+1);
		
		dto.setIgasm1112Form(form);
		
		if ("0".equals(form.getEimark())) {
			dto.addMessage(new ActionMessage("IGCO10000.I005", "机柜信息"));
		} else {
			dto.addMessage(new ActionMessage("IGCO10000.I005", "机架信息"));
		}
		log.debug("========机柜信息更新处理终了========");
		return dto;
	}
	
	/**
	 * 机柜平面图管理画面初期化处理
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO initIGASM1114Action(IGASM11DTO dto) throws BLException {

		log.debug("========机柜平面图管理画面初期化处理开始========");
		
		IGASM1114Form form = dto.getIgasm1114Form();
		
		//1.机柜信息检索
		SOC0603Info computerContainerVWInfo = 
			this.soc0603BL.searchSOC0603InfoByKey(form.getEiid());
		
		if ( computerContainerVWInfo == null) {
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","机柜");
		}
		
		//2.机柜高设定检测
		if (StringUtils.isEmpty(computerContainerVWInfo.getU_total())) {
			throw new BLException("IGCO10000.E013","机柜","机柜高");
		}
		
		//3.设备信息取得
		SOC0602SearchCondImpl cond = 
			new SOC0602SearchCondImpl();
		
		cond.setContainer_eiid(Integer.parseInt(form.getEiid()));
		
		List<SOC0602Info> computerDeviceVWInfoList = 
			this.soc0602BL.searchSOC0602Info(cond, 0, 0);
		
		dto.setComputerContainerVWInfo(computerContainerVWInfo);
		dto.setComputerDeviceVWInfoList(computerDeviceVWInfoList);
		
		log.debug("========机柜平面图管理画面初期化处理终了========");
		return dto;
	}
	
	/**
	 * 设备选择画面初期化处理
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO initIGASM1115Action(IGASM11DTO dto) throws BLException {

		log.debug("========设备选择画面初期化处理开始========");
		
		IGASM1115Form form = dto.getIgasm1115Form();
		
		//1.机柜信息取得
		SOC0603Info computerContainerVW = 
			this.soc0603BL.searchSOC0603InfoByKey(form.getCur_container_eiid());
		
		//
		form.setCur_container_name(computerContainerVW.getEiname());
		form.setContainer_eid(computerContainerVW.getEid().toString());
		
		//2.设备信息取得
		//设备查询件数取得 
		int totalCount = this.soc0602BL.getSOC0602InfoSearchCount(form);
		
		if (totalCount == 0) {
			log.debug("========资产信息查询数据不存在========");
			//设备查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========资产信息查询数据件数过多========");
			//设备查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//分页用信息取得
		PagingDTO pDto = dto.getPagingDto();

		pDto.setTotalCount(totalCount);
		
		List<SOC0602Info> computerDeviceVWInfoList = 
			this.soc0602BL.searchSOC0602Info(form,  pDto.getFromCount(), pDto.getPageDispCount());
		
		dto.setComputerDeviceVWInfoList(computerDeviceVWInfoList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));

		log.debug("========设备选择画面初期化处理终了========");
		return dto;
	}

	/**
	 * 设备设定处理
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO setComputerDeviceAction(IGASM11DTO dto) throws BLException {
		log.debug("========设备设定处理开始========");
		
		//0.设备上架前检测
		checkDevice(dto);
		
		IGASM1115Form form = dto.getIgasm1115Form();

		//1.设备设定信息检索
		SOC0119SearchCondImpl cond = 
			new SOC0119SearchCondImpl();
		//机房ID
		//cond.setPareiid(form.getCur_room_eiid());
		//设备ID设定
		cond.setCldeiid(Integer.parseInt(form.getSel_device_eiid()));
		
		//设备和机柜的所属关系设定
		cond.setEirrelation(CommonDefineUtils.CONTAINER_DEVICE_ASSIGN_RELATION);
		
		List<SOC0119Info> entityItemRelationList = 
			this.soc0119BL.searchMaxEntityItemRelation(cond);
		
		//2.现有关系删除
		if (entityItemRelationList != null && entityItemRelationList.size()>0 ) {
			for (SOC0119Info res:entityItemRelationList) {
				this.soc0119BL.deleteEntityItemRelation(res);
			}
		}
		
		//3.设备信息取得
		SOC0118Info entityItem = 
			this.soc0118BL.searchEntityItemByKey(Integer.parseInt(form.getSel_device_eiid()));
		
		if (entityItem == null) {
			throw new BLException("IGCO10000.E004","设备");
		}
		
		//4.机柜设备所属关系生成
		SOC0119TB entityItemRelation = new SOC0119TB();
		entityItemRelation.setPareiid(Integer.parseInt(form.getCur_container_eiid()));
		entityItemRelation.setPareid(form.getContainer_eid());
		entityItemRelation.setCldeiid(Integer.parseInt(form.getSel_device_eiid()));
		entityItemRelation.setCldeid(entityItem.getEid());
		entityItemRelation.setEirrelation(CommonDefineUtils.CONTAINER_DEVICE_ASSIGN_RELATION);
		entityItemRelation.setEirrelationcode(CommonDefineUtils.CONTAINER_DEVICE_ASSIGN_RELATION_CODE);
		
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		
		entityItemRelation.setEirupdtime(datetime);
		
		this.soc0119BL.registEntityItemRelation(entityItemRelation);
		
		//5.当前版本取得
		Integer cur_version = entityItem.getEiversion();
		
		//6.当前配置信息取得
		SOC0107SearchCondImpl ciCond = new SOC0107SearchCondImpl();
		
		ciCond.setEiid(form.getSel_device_eiid());
		ciCond.setCiversion(cur_version.toString());
		
		List<SOC0107Info> configItemList = 
			this.soc0107BL.searchSOC0107(ciCond, 0, 0);
		
		//7.设备位置配置以外的配置版本信息升级
		if (configItemList!=null && configItemList.size()>0) {
			//版本升级
			for (SOC0107Info item:configItemList) {
				String clabel = item.getConfiguration().getClabel();
				//设备位置以外的配置版本更新
				if (clabel==null||!clabel.equals(EntityItemKeyWords.CLABEL_U_VALUE)) {
					SOC0107TB configItemTB = (SOC0107TB) SerializationUtils.clone((Serializable) item);
					configItemTB.setCiid(null);
					configItemTB.setCiversion(cur_version+1);
					configItemTB.setCiupdtime(datetime);
					configItemTB.setCicurver("0");
					SOC0107Info ci = this.soc0107BL.registSOC0107(configItemTB);
					
					//属性类别为资产时，修改关联关系
					if("4".equals(item.getConfiguration().getCattach()) && StringUtils.isNotEmpty(item.getCivalue())){
						SOC0119TB e = new SOC0119TB();
						e.setPareid(entityItem.getEid());
						e.setPareiid(entityItem.getEiid());
						e.setParversion(entityItem.getEiversion());
						e.setParsmallversion(entityItem.getEismallversion());
						String str = item.getCivalue();			
						SOC0118Info ei = this.soc0118BL.searchEntityItemByKey(Integer.parseInt(str.substring(str.lastIndexOf("(")+1, str.length()-1)));
						e.setCldeid(ei.getEid());
						e.setCldeiid(ei.getEiid());
						e.setCldversion(ei.getEiversion());
						e.setCldsmallversion(ei.getEismallversion());
						//校验关系是否存在
						SOC0119SearchCondImpl eirCond = new SOC0119SearchCondImpl();
						eirCond.setEirinfo(entityItem.getEiid()+"_"+item.getCiid()+"_"+ei.getEiid());
						eirCond.setEirstatus("C");
						eirCond.setDeleteflag("0");
						List<SOC0119Info> eirlist = this.soc0119BL.searchMaxEntityItemRelation(eirCond);
						if(eirlist.size() != 1) {
							throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR, "IGCO10000.E017");
						} else {
							SOC0119TB eirTB = (SOC0119TB)SerializationUtils.clone(eirlist.get(0));
							
							eirTB.setEirinfo(eirTB.getEirinfo().replaceAll("_" + item.getCiid() + "_", "_" + ci.getCiid() + "_"));
							
							this.soc0119BL.updateEntityItemRelation(eirTB);
						}
					}
				}
			}
		}
		
		//8.设备位置（U）配置项生成
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_U_VALUE,
				form.getCur_container_u_value(),"设备","设备位置（U）",cur_version+1);
		
		//9.设备版本升级
		SOC0118TB entityItemTB = (SOC0118TB)entityItem;
		
		entityItemTB.setEiversion(cur_version+1);
		entityItemTB.setEiupdtime(datetime);
		
		this.soc0118BL.updateEntityItem(entityItemTB);
		
		log.debug("========设备设定处理终了========");
		return dto;
	}
	
	/**
	 * 设备移除处理
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO moveoutComputerDeviceAction(IGASM11DTO dto) throws BLException {
		log.debug("========设备移除处理开始========");
		IGASM1114Form form = dto.getIgasm1114Form();

		//1.设备设定信息检索
		SOC0119SearchCondImpl cond = 
			new SOC0119SearchCondImpl();
		//机房ID
		cond.setPareiid(Integer.parseInt(form.getEiid().toString()));
		//设备ID设定
		cond.setCldeiid(Integer.parseInt(form.getDevice_eiid()));
		
		//设备和机柜的所属关系设定
		cond.setEirrelation(CommonDefineUtils.CONTAINER_DEVICE_ASSIGN_RELATION);
		
		List<SOC0119Info> entityItemRelationList = 
			this.soc0119BL.searchMaxEntityItemRelation(cond);
		
		//2.现有关系删除
		if (entityItemRelationList != null && entityItemRelationList.size()>0 ) {
			for (SOC0119Info res:entityItemRelationList) {
				this.soc0119BL.deleteEntityItemRelation(res);
			}
		}
		
		//3.设备信息取得
		SOC0118Info entityItem = 
			this.soc0118BL.searchEntityItemByKey(Integer.parseInt(form.getDevice_eiid()));
		
		if (entityItem == null) {
			throw new BLException("IGCO10000.E004","设备");
		}
		
		//4.当前版本取得
		Integer cur_version = entityItem.getEiversion();
		
		//5.当前配置信息取得
		SOC0107SearchCondImpl ciCond = new SOC0107SearchCondImpl();
		
		ciCond.setEiid(form.getDevice_eiid());
		ciCond.setCiversion(cur_version.toString());
		
		List<SOC0107Info> configItemList = 
			this.soc0107BL.searchSOC0107(ciCond, 0, 0);
		
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		
		//6.设备位置配置以外的配置版本信息升级
		if (configItemList!=null && configItemList.size()>0) {
			//版本升级
			for (SOC0107Info item:configItemList) {
				String clabel = item.getConfiguration().getClabel();
				//设备位置以外的配置版本更新
				if (clabel==null||!clabel.equals(EntityItemKeyWords.CLABEL_U_VALUE)) {
					SOC0107TB configItemTB = (SOC0107TB) SerializationUtils.clone((Serializable) item);
					configItemTB.setCiid(null);
					configItemTB.setCiversion(cur_version+1);
					configItemTB.setCiupdtime(datetime);
					configItemTB.setCicurver("0");
					SOC0107Info ci = this.soc0107BL.registSOC0107(configItemTB);
					
					//属性类别为资产时，修改关联关系
					if("4".equals(item.getConfiguration().getCattach()) && StringUtils.isNotEmpty(item.getCivalue())){
						SOC0119TB e = new SOC0119TB();
						e.setPareid(entityItem.getEid());
						e.setPareiid(entityItem.getEiid());
						e.setParversion(entityItem.getEiversion());
						e.setParsmallversion(entityItem.getEismallversion());
						String str = item.getCivalue();			
						SOC0118Info ei = this.soc0118BL.searchEntityItemByKey(Integer.parseInt(str.substring(str.lastIndexOf("(")+1, str.length()-1)));
						e.setCldeid(ei.getEid());
						e.setCldeiid(ei.getEiid());
						e.setCldversion(ei.getEiversion());
						e.setCldsmallversion(ei.getEismallversion());
						//校验关系是否存在
						SOC0119SearchCondImpl eirCond = new SOC0119SearchCondImpl();
						eirCond.setEirinfo(entityItem.getEiid()+"_"+item.getCiid()+"_"+ei.getEiid());
						eirCond.setEirstatus("C");
						eirCond.setDeleteflag("0");
						List<SOC0119Info> eirlist = this.soc0119BL.searchMaxEntityItemRelation(eirCond);
						if(eirlist.size() != 1) {
							throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR, "IGCO10000.E017");
						} else {
							SOC0119TB eirTB = (SOC0119TB)SerializationUtils.clone(eirlist.get(0));
							
							eirTB.setEirinfo(eirTB.getEirinfo().replaceAll("_" + item.getCiid() + "_", "_" + ci.getCiid() + "_"));
							
							this.soc0119BL.updateEntityItemRelation(eirTB);
						}
					}
				}
			}
		}
		
		//7.设备位置（U）配置项生成
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_U_VALUE,
				"","设备","设备位置（U）",cur_version+1,datetime);
		
		//8.设备版本升级
		SOC0118TB entityItemTB = (SOC0118TB)entityItem;
		
		entityItemTB.setEiversion(cur_version+1);
		entityItemTB.setEiupdtime(datetime);
		
		this.soc0118BL.updateEntityItem(entityItemTB);
		
		log.debug("========设备移除处理终了========");
		
		return dto;
	}
	
	/**
	 * 设备配置详细信息画面初期化处理
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO initIGASM1116Action(IGASM11DTO dto) throws BLException {
		log.debug("========设备配置详细信息画面初期化处理开始========");
		
		IGASM1116Form form = dto.getIgasm1116Form();
		//设备信息检索
		SOC0605Info entityItemVWInfo = this.soc0118BL.searchSOC0605InfoByKey(
				Integer.parseInt(dto.getIgasm1116Form().getEiid()));
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","设备");
		}
		dto.setEntityItemVWInfo(entityItemVWInfo);
		
		form.setEsyscoding_q(entityItemVWInfo.getEsyscoding());
		//判断登陆用户是否有查看该资产配置信息的权限
		Boolean flag = this.soc0118BL.checkSOC0605InfoDomain(dto.getUser(), entityItemVWInfo);

		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}else{
			dto.setFlag(flag);
		}
		//资产项配置信息查询件数取得 
		int totalCount = this.soc0107BL.getSOC0606InfoSearchCount(form);
		
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
		//系统配置信息全件查询
		List<SOC0606Info> configItemVWInfoList = this.soc0107BL.searchSOC0606Info(
				form, 0, 0);
		
		String[] civalue = new String[totalCount];
		Map<String,List<SOC0606Info>> map = new LinkedHashMap<String,List<SOC0606Info>>();
		int i = 0;
		int j = 0;
		List<String> strlist = new ArrayList<String>();
		for(SOC0606Info e : configItemVWInfoList){
			if(!map.containsKey(e.getCcategory())){
				map.put(e.getCcategory(), new ArrayList<SOC0606Info>());
				strlist.add(e.getCcategory());
			}
			map.get(e.getCcategory()).add(e);
			if("2".equals(e.getCattach())){
				List<LabelValueBean> list = ig545BL.searchLabelValueBeanList(e.getCoption());
				form.setSelectedListMap(j++, list);
			}
		}
		for(String str : strlist){
			for(SOC0606Info e : map.get(str)){
				civalue[i] = e.getCivalue();
				i++;
			}
		}
		
		form.setCivalue(civalue);
		
		dto.setConfigItemVWInfoMap(map);
//		dto.addMessage(new ActionMessage("IGCO10000.I007",totalCount));
		


		
		log.debug("========设备配置详细信息初期化处理终了========");
		return dto;
		
	}

	/**
	 * 设备上架检测
	 *
	 * @param dto IGASM11DTO
	 * @return
	 */
	protected void checkDevice(IGASM11DTO dto) throws BLException {

		log.debug("========设备上架检测处理开始========");
		
		IGASM1115Form form = dto.getIgasm1115Form();
		
		//1.机柜信息检索
		SOC0603Info computerContainerVWInfo = 
			this.soc0603BL.searchSOC0603InfoByKey(form.getCur_container_eiid());
		
		if ( computerContainerVWInfo == null) {
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","机柜");
		}
		
		//2.机柜内设备信息取得
		SOC0602SearchCondImpl cond = 
			new SOC0602SearchCondImpl();
		
		cond.setContainer_eiid(Integer.parseInt(form.getCur_container_eiid()));
		
		List<SOC0602Info> computerDeviceVWInfoList = 
			this.soc0602BL.searchSOC0602Info(cond, 0, 0);
		
		//3.机柜平面图信息生成
		IGASM11141VO vo = new IGASM11141VO(computerContainerVWInfo,
				computerDeviceVWInfoList);
		
		//4.上架设备信息取得
		SOC0602Info computerDeviceVWInfo = 
			this.soc0602BL.searchSOC0602InfoByKey(form.getSel_device_eiid());
		
		//5.检测用信息取得
		//设备高
		int device_u_total = Integer.parseInt(computerDeviceVWInfo.getU_width());
		
		//设备位置
		int device_u_value = Integer.parseInt(form.getCur_container_u_value());
		
		//机柜高
		int container_u_total = Integer.parseInt(computerContainerVWInfo.getU_total());
		
		//6.上架设备检测
		List<IGASM11142VO> rowList = vo.getRowList();
		
		for ( int i=0; i<device_u_total;i++ ) {
			int rownum = container_u_total - (device_u_value + i);
			if (rownum<0){
				//上架设备高超出机柜高
				throw new BLException("IGASM1115.E001",String.valueOf(device_u_total),
						String.valueOf(device_u_value),String.valueOf(container_u_total));
			}
			
			if (!rowList.get(rownum).isSpace()) {
				if (!rowList.get(rownum).getEntityData().getEiid().equals(form.getSel_device_eiid())) {
					//上架位置其他设备存在
					throw new BLException("IGASM1115.E002");
				}
			}
		}
		
		log.debug("========设备上架检测处理终了========");
	}
	
	/**
	 * 机柜设定检测
	 *
	 * @param dto IGASM11DTO
	 * @return 
	 */
	protected void checkContainer(IGASM11DTO dto) throws BLException {

		log.debug("========机柜设定检测处理开始========");
		
		IGASM1105Form form = dto.getIgasm1105Form();
		
		//1.机房信息检索
		SOC0601Info computerRoomVWInfo = 
			this.soc0601BL.searchSOC0601InfoByKey(form.getCur_room_eiid());
		
		if ( computerRoomVWInfo == null) {
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","机房");
		}
		
		//2.机柜信息取得
		SOC0603SearchCondImpl cond = 
			new SOC0603SearchCondImpl();
		
		cond.setRoom_eiid(Integer.parseInt(form.getCur_room_eiid()));
		
		List<SOC0603Info> computerContainerVWInfoList = 
			this.soc0603BL.searchSOC0603Info(cond, 0, 0);
		
		//3.机房平面图信息生成
		IGASM11041VO vo = new IGASM11041VO(computerRoomVWInfo,
				computerContainerVWInfoList);
		
		//4.设定机柜信息取得
		SOC0603Info computerContainerVWInfo = 
			this.soc0603BL.searchSOC0603InfoByKey(form.getSel_container_eiid());
		
		//5.检测用信息取得
		//机柜横向长
		int container_x_total = Integer.parseInt(computerContainerVWInfo.getX_width());
		
		//机柜纵向长
		int container_y_total = Integer.parseInt(computerContainerVWInfo.getY_width());
		
		//机柜横向位置
		int container_x_value = Integer.parseInt(form.getCur_room_x_value());
		
		//机柜纵向位置
		int container_y_value = Integer.parseInt(form.getCur_room_y_value());

		//机房横向宽
		int room_x_total = Integer.parseInt(computerRoomVWInfo.getX_total());
		
		//机房纵向宽
		int room_y_total = Integer.parseInt(computerRoomVWInfo.getY_total());

		//6.设定机柜检测
		List<IGASM11042VO> rowList = vo.getRowList();
		
		for ( int i=0; i<container_y_total;i++ ) {
			int rownum = container_y_value + i - 1;
			if (rownum > (room_y_total-1)){
				//设定机柜超出机房纵向宽
				throw new BLException("IGASM1105.E002");
			}
			
			IGASM11042VO rowVO = rowList.get(rownum);
			
			for ( int j=0; j<container_x_total;j++ ) {
				int colnum = container_x_value + j - 1;
				if (colnum>(room_x_total-1)) {
					//设定机柜超出机房横向宽
					throw new BLException("IGASM1105.E001");
				}
				if (!rowVO.getColumnList().get(colnum).isSpace()) {
					String containerId = rowVO.getColumnList().get(colnum).getEntityData().getEiid().toString();
					if (!containerId.equals(form.getSel_container_eiid())) {
						//设定机柜位置有其他机柜
						throw new BLException("IGASM1105.E003");
					}
				}
			}
		}
		
		log.debug("========机柜设定检测处理终了========");
	}

	public IGASM11DTO getContainerNameByEiid(IGASM11DTO dto) throws BLException {
		IGASM1115Form form = dto.getIgasm1115Form();
		//1.机柜信息取得
		SOC0603Info computerContainerVW = 
			this.soc0603BL.searchSOC0603InfoByKey(form.getCur_container_eiid());
		form.setCur_container_name(computerContainerVW.getEiname());
		return dto;
	}

	public IGASM11DTO getRoomNameByEiid(IGASM11DTO dto) throws BLException {
		IGASM1105Form form = dto.getIgasm1105Form();
		SOC0601Info computerRoomVW = 
			this.soc0601BL.searchSOC0601InfoByKey(form.getCur_room_eiid());
		form.setCur_room_name(computerRoomVW.getEiname());
		return dto;
	}

	public void setFileUploadBL(FileUploadBL fileUploadBL) {
		this.fileUploadBL = fileUploadBL;
	}

	/**
	 * @param compareTemplateBL the compareTemplateBL to set
	 */
	public void setCompareTemplateBL(CompareTemplateBL compareTemplateBL) {
		this.compareTemplateBL = compareTemplateBL;
	}
	
	/**
	 * 取得图例信息并组装成XML
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO getLegendXml(IGASM11DTO dto) throws BLException {

		log.debug("========图例信息XML初期化处理开始========");
		IGASM1104Form form = dto.getIgasm1104Form();
		CompareTemplateSearchCondImpl ctcond = new CompareTemplateSearchCondImpl();
		String[] legend = {"d1","d2","d3","d4","w1","w2","f1","c1","c2"};
		ctcond.setCategory(form.getEiid());
		ctcond.setLegendArray(legend);
		List<CompareTemplateInfo> ctList = compareTemplateBL.searchCompareTemplate(ctcond, 0, 0);
		
		StringBuffer legendXml =  new StringBuffer("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		legendXml.append("<ROOT>");
		legendXml.append("<ZONE>");
		if(ctList!=null){
			for(CompareTemplateInfo ctbean:ctList){
				legendXml.append("<img id=\""+ctbean.getCttype()+"\" " +
									  "x=\""+ctbean.getCtx()+"\" " +
									  "y=\""+ctbean.getCty()+"\" " +
									  "type=\""+ctbean.getCttype()+"\"/>");
			}
		}
		legendXml.append("</ZONE>");
		legendXml.append("</ROOT>");

		dto.setLegendXML(legendXml.toString());
		System.out.println(legendXml.toString());
		log.debug("========图例信息XML初期化处理终了========");
		return dto;
	}
	
	/**
	 * 取得无效地区信息并组装成XML
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO getWuXiaoXml(IGASM11DTO dto) throws BLException {

		log.debug("========无效地区XML初期化处理开始========");
		IGASM1104Form form = dto.getIgasm1104Form();
		CompareTemplateSearchCondImpl ctcond = new CompareTemplateSearchCondImpl();
		ctcond.setCategory(form.getEiid());
		ctcond.setType("naf");
		List<CompareTemplateInfo> ctList = compareTemplateBL.searchCompareTemplate(ctcond, 0, 0);
		
		StringBuffer wuxiaoXml =  new StringBuffer("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		wuxiaoXml.append("<ROOT>");
		wuxiaoXml.append("<NAF>");
		if(ctList!=null){
			for(CompareTemplateInfo ctbean:ctList){
				wuxiaoXml.append("<img id=\""+ctbean.getCtpid()+"\"")
				.append(" x=\""+ctbean.getCtx()+"\" ")
				.append(" y=\""+ctbean.getCty()+"\" ")
				.append(" floorx=\""+ctbean.getCtfloorx()+"\" ")
				.append(" floory=\""+ctbean.getCtfloory()+"\" />");
			}
		}
		wuxiaoXml.append("</NAF>");
		wuxiaoXml.append("</ROOT>");

		dto.setWuxiaoXML(wuxiaoXml.toString());

		log.debug("========无效地区XML初期化处理终了========");
		return dto;
	}
	
	/**
	 * 取得关系机房信息并组装成XML
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO getRelateRoomXml(IGASM11DTO dto) throws BLException {

		log.debug("========取得关系机房信息处理开始========");
		IGASM1104Form form = dto.getIgasm1104Form();
		SOC0107SearchCondImpl cond = new SOC0107SearchCondImpl();
		cond.setCivalue(form.getEiid());
		//查询关联机房分区
		cond.setCid(String.valueOf(IGASMBL11Type.ASM_RELATEROOM));
		List<SOC0107Info> crlist = this.soc0107BL.searchSOC0107(cond);
		cond = new SOC0107SearchCondImpl();
		List<SOC0107Info> cxlist = new ArrayList<SOC0107Info>();
		List<SOC0107Info> cylist = new ArrayList<SOC0107Info>();
		for(SOC0107Info cibean:crlist){
			cond.setEiid(cibean.getEiid()+"");
			//查询关联机房分区中的X座标范围
			cond.setCid(String.valueOf(IGASMBL11Type.ASM_RELATEX));
			List<SOC0107Info> txlist = this.soc0107BL.searchSOC0107(cond);
			//查询关联机房分区中的Y座标范围
			cond.setCid(String.valueOf(IGASMBL11Type.ASM_RELATEY));
			List<SOC0107Info> tylist = this.soc0107BL.searchSOC0107(cond);
			if(txlist!=null && txlist.size()>0){
				cxlist.add(txlist.get(0));
			}
			if(tylist!=null && tylist.size()>0){
				cylist.add(tylist.get(0));
			}
		}
		
		Map<Integer,Map<String,String>> rrMap = new LinkedHashMap<Integer,Map<String,String>>();
		
		//组装map
		for(SOC0107Info cibean:crlist){
			Map<String,String> ssMap = new LinkedHashMap<String,String>();
			String x = "";
			String y = "";
			for(SOC0107Info cxbean:cxlist){
				if(cibean.getEiid().equals(cxbean.getEiid())){
					x = cxbean.getCivalue();
				}
			}
			for(SOC0107Info cybean:cylist){
				if(cibean.getEiid().equals(cybean.getEiid())){
					y = cybean.getCivalue();
				}
			}
			ssMap.put(x, y);
			rrMap.put(cibean.getEiid(), ssMap);
		}
		
		StringBuffer relateRoomXml =  new StringBuffer("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		relateRoomXml.append("<ROOT>");
		Set<Map.Entry<Integer,Map<String,String>>> cset = rrMap.entrySet();
		for(Iterator<Map.Entry<Integer,Map<String,String>>> iter = cset.iterator();iter.hasNext();){
			Map.Entry<Integer,Map<String,String>> entry = iter.next();
			Map<String,String> ssMap = entry.getValue();
			//关联分区ID
			relateRoomXml.append("<ROOM id=\""+entry.getKey()+"\">");
				Set<Map.Entry<String,String>> sset = ssMap.entrySet();
				for(Iterator<Map.Entry<String,String>> siter = sset.iterator();siter.hasNext();){
					//关联分区X座标范围
					Map.Entry<String,String> sentry = siter.next();
					relateRoomXml.append("<img id=\"x\">");
					relateRoomXml.append(sentry.getKey());
					relateRoomXml.append("</img>");
					//关联分区Y座标范围
					relateRoomXml.append("<img id=\"y\">");
					relateRoomXml.append(sentry.getValue());
					relateRoomXml.append("</img>");
				}
			relateRoomXml.append("</ROOM>");
		}
		relateRoomXml.append("</ROOT>");

		dto.setRelateRoomXML(relateRoomXml.toString());

		log.debug("========取得关系机房信息处理终了========");
		return dto;
	}

	public IGASM11DTO getEquipmentAndIpAction(IGASM11DTO dto)
			throws BLException {
		log.debug("========3D机房支持IP查询开始========");
		// 获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		//查询结果
		List<EquipmentInquireVWInfo> eilist = null;
		//new一个cond
		EquipmentInquireVWSearchCondImpl cond = new EquipmentInquireVWSearchCondImpl();
		//获得3D机房支持IP查询Form
		IGASM1120Form form = dto.getIgasm1120Form();
		//如果Form不为空则将form中的的条件放入cond中
		if(form!=null){
			//如果业务系统不为空，则将业务系统放进cond中
			if(StringUtils.isNotEmpty(form.getBusinesssys())){
				cond.setBusinesssys(form.getBusinesssys());
			}
			//如果IP地址不为空，则将IP地址放进cond中
			if(StringUtils.isNotEmpty(form.getIp())){
				cond.setIp(form.getIp());
			}
			//如果所属机柜不为空，则将所属机柜放进cond中
			if(StringUtils.isNotEmpty(form.getComputerContainer())){
				cond.setComputerContainer(form.getComputerContainer());
			}
			//设备名
			if(StringUtils.isNotEmpty(form.getEiname())){
			    cond.setEiname(form.getEiname());
			}
			//设备编号
			if(StringUtils.isNotEmpty(form.getEilabel())){
			    cond.setEilabel(form.getEilabel());
			}
			
			
		}
		//如果所属机柜Id不为空，则将所属机柜id放进cond中
		if(StringUtils.isNotEmpty(dto.getComputerContainerId())){
			cond.setComputerContainerId(Integer.parseInt(dto.getComputerContainerId()));
		}
		if(pDto==null){
			eilist = equipmentInquireVWBL.getEquipmentAndIP(cond, 0,  0);
		}else{
			int count = equipmentInquireVWBL.getEquipmentAndIPCount(cond);
			pDto.setTotalCount(count);
			//查询3D机房支持IP查询
			eilist = equipmentInquireVWBL.getEquipmentAndIP(cond, pDto.getFromCount(),  pDto.getPageDispCount());
		}			
		dto.setEilist(eilist);
		log.debug("========3D机房支持IP查询终了========");
		return dto;
	}
	
	//返回告警指示灯闪烁类别
	private String getIndicatorLights(String eiid) throws BLException{
		SOC0602SearchCondImpl soc0602Cond =  new SOC0602SearchCondImpl();
		soc0602Cond.setContainer_eiid(Integer.parseInt(eiid));
		List<SOC0602Info> computerDeviceVWInfoList =  this.soc0602BL.searchSOC0602Info(soc0602Cond, 0, 0);
		String serial="";
		for (SOC0602Info soc0602Info : computerDeviceVWInfoList) {
//			// 当前配置信息取得
			SOC0107SearchCondImpl ciCond = new SOC0107SearchCondImpl();
			ciCond.setEiid(String.valueOf(soc0602Info.getEiid()));
			List<SOC0107Info> configItemList = monitoringAlarmIPVWBL.findByCond(ciCond);
			String ip = "";
			for (SOC0107Info item : configItemList) {
				ip = item.getCivalue();
			}
			if(StringUtils.isEmpty(ip)){
				break;
			}
			if("3".equals(serial)){
				continue;
			}
		}
		return serial;
	}
	
	/**
	 * 同步告警系统
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO getSynchronizationAlarmSystem(IGASM11DTO dto) throws BLException {
		log.debug("========同步告警系统开始========");
		SynchronizationAlarmSystemVWSearchCondImpl cond =  new SynchronizationAlarmSystemVWSearchCondImpl();
		// 查询未同步系统
		cond.setItype("1");
		List<SynchronizationAlarmSystemVWInfo> notSynchronizedList = synchronizationAlarmSystemVWBL.findByCond(cond);
		for (SynchronizationAlarmSystemVWInfo sysInfo : notSynchronizedList) {
			if(StringUtils.isEmpty(sysInfo.getIlsname())){
				IndicatorLightsSystemTB ind =  new IndicatorLightsSystemTB();
				ind.setIlsname(sysInfo.getEaname());
				ind.setIlsstatus("0");
				// 在告警系统显示信息表创建新系统
				indicatorLightsSystemBL.registIndicatorLightsSystem(ind);
			}
		}
		// 查询已同步系统
		cond.setItype("2");
		List<SynchronizationAlarmSystemVWInfo> hasSynchronizedList = synchronizationAlarmSystemVWBL.findByCond(cond);
		for (SynchronizationAlarmSystemVWInfo sysInfo : hasSynchronizedList) {
			if(StringUtils.isEmpty(sysInfo.getEaname())){
				// 在告警系统显示信息表删除分组已删除系统
				indicatorLightsSystemBL.deleteIndicatorLightsSystemByPK(sysInfo.getIlsid());
			}
		}
		log.debug("========同步告警系统终了========");
		return dto;
	}
}
