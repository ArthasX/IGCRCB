/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.cim.bl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.LabelValueBean;
import org.apache.struts.util.MessageResources;
import org.hyperic.hq.hqapi1.HQApi;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.soc.asset.SOC0136Info;
import com.deliverik.framework.soc.asset.SOC0138Info;
import com.deliverik.framework.soc.asset.bl.task.CMDBConstants;
import com.deliverik.framework.soc.asset.bl.task.CicollecttaskBL;
import com.deliverik.framework.soc.asset.bl.task.SOC0111BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0112BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0113BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0115BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0116BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0120BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0125BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0126BL;
import com.deliverik.framework.soc.asset.model.SOC0111Info;
import com.deliverik.framework.soc.asset.model.SOC0112Info;
import com.deliverik.framework.soc.asset.model.SOC0113Info;
import com.deliverik.framework.soc.asset.model.SOC0115Info;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0120Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0125Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0112SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0115SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0120SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0120SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCondImpl;
import com.deliverik.framework.soc.asset.model.entity.SOC0111PK;
import com.deliverik.framework.soc.asset.model.entity.SOC0112PK;
import com.deliverik.framework.soc.asset.model.entity.SOC0112TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0113TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0115TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0116TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0120PK;
import com.deliverik.framework.soc.asset.model.entity.SOC0120TB;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.CodeListUtils;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.soc.bl.task.CR03BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM02DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0201Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0202Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0203Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0205Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0206Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0210Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0212Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0213Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0802Form;
import com.deliverik.infogovernor.soc.model.CR03Info;
import com.deliverik.infogovernor.soc.model.CR03VWInfo;
import com.deliverik.infogovernor.soc.model.condition.CR03SearchCondImpl;
import com.deliverik.infogovernor.soc.model.entity.CR03PK;
import com.deliverik.infogovernor.soc.model.entity.CR03TB;
import com.deliverik.infogovernor.util.HQUtil;

/**
 * 概述: 资产域定义业务逻辑实现
 * 功能描述: 资产域定义业务逻辑实现
 * 创建记录: 2011/04/25
 * 修改记录: 
 */
public class IGCIM02BLImpl extends BaseBLImpl implements IGCIM02BL {
	static Log log = LogFactory.getLog(IGCIM02BLImpl.class);

	protected MessageResources resources = MessageResources
			.getMessageResources("com.deliverik.infogovernor.soc.cim.asmResources");

	/** 资产域定义BL */
	protected SOC0111BL soc0111BL;

	/** 资产域明细 */
	protected SOC0112BL soc0112BL;

	/** 导入数据版本 */
	protected SOC0120BL soc0120BL;

	/** 待处理任务业务逻辑接口 */
	protected SOC0115BL soc0115BL;
	/** 待处理任务业务逻辑临时表接口 */
	protected SOC0116BL soc0116BL;
	/** 导入对象类型 */
	protected SOC0113BL soc0113BL;
	
	/** 最新版本域业务逻辑接口 */
	protected SOC0125BL soc0125BL;
	
	/**资产实体查询BL*/
	protected SOC0118BL soc0118BL;
	
	/** 资产域明细业务逻辑接口 */
	protected SOC0126BL soc0126BL;
	
	
	/** 配置原数据*/
	protected CR03BL cr03BL;
	
	HQApi hqapi;
	private CicollecttaskBL cicollecttaskBL;

	/**
	 * 资产域定义BL设定
	 *
	 * @param soc0111BL 资产域定义BL
	 */
	public void setSoc0111BL(SOC0111BL soc0111BL) {
		this.soc0111BL = soc0111BL;
	}

	/**
	 * 资产域明细设定
	 *
	 * @param soc0112BL 资产域明细
	 */
	public void setSoc0112BL(SOC0112BL soc0112BL) {
		this.soc0112BL = soc0112BL;
	}

	/**
	 * 导入数据版本设定
	 *
	 * @param soc0120BL 导入数据版本
	 */
	public void setSoc0120BL(SOC0120BL soc0120BL) {
		this.soc0120BL = soc0120BL;
	}

	/**
	 * 待处理任务业务逻辑接口设定
	 *
	 * @param soc0115BL 待处理任务业务逻辑接口
	 */
	public void setSoc0115BL(SOC0115BL soc0115BL) {
		this.soc0115BL = soc0115BL;
	}

	/**
	 * 待处理任务业务逻辑临时表接口设定
	 *
	 * @param soc0116BL 待处理任务业务逻辑临时表接口
	 */
	public void setSoc0116BL(SOC0116BL soc0116BL) {
		this.soc0116BL = soc0116BL;
	}

	/**
	 * 导入对象类型设定
	 *
	 * @param soc0113BL 导入对象类型
	 */
	public void setSoc0113BL(SOC0113BL soc0113BL) {
		this.soc0113BL = soc0113BL;
	}

	/**
	 * 最新版本域业务逻辑接口设定
	 *
	 * @param soc0125BL 最新版本域业务逻辑接口
	 */
	public void setSoc0125BL(SOC0125BL soc0125BL) {
		this.soc0125BL = soc0125BL;
	}

	/**
	 * 资产实体查询BL设定
	 *
	 * @param soc0118BL 资产实体查询BL
	 */
	public void setSoc0118BL(SOC0118BL soc0118BL) {
		this.soc0118BL = soc0118BL;
	}

	/**
	 * 资产域明细业务逻辑接口设定
	 *
	 * @param soc0126BL 资产域明细业务逻辑接口
	 */
	public void setSoc0126BL(SOC0126BL soc0126BL) {
		this.soc0126BL = soc0126BL;
	}
	
	/**
	 * 配置原数据与主机关系表业务逻辑接口
	 *
	 * @param cr03BL 配置原数据与主机关系表业务逻辑接口
	 */
	public void setCr03BL(CR03BL cr03BL) {
		this.cr03BL = cr03BL;
	}
	
	/**
	 * 资产域定义信息登记处理
	 * 
	 * @param dtoIGCIM02DTO
	 * @return IGCIM02DTO
	 */
	public IGCIM02DTO insertEiDomainDefAction(IGCIM02DTO dto)
			throws BLException {
		log.debug("========资产域定义信息登记处理开始========");
		// 输入Form取得
		IGCIM0202Form form = dto.getIgcim0202Form();
		Integer eiddid = soc0111BL.findMaxEiddId();
		if (eiddid == null) {
			form.setEiddid(1000);
		} else {
			form.setEiddid(eiddid + 1);
		}
		form.setVersion(0);
		this.soc0111BL.registEiDomainDef(dto.getIgcim0202Form());
		// 资产域定义基本信息
		dto.addMessage(new ActionMessage("IGCO10000.I004", resources
				.getMessage(dto.getLocale(), "message.IGCIM02BLImpl.001")));
		log.debug("========资产域定义信息登记处理终了========");
		return dto;
	}

	/**
	 * Description: 删除用户角色
	 * 
	 * @param dtoIGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */

	public IGCIM02DTO revokeImportVesionAction(IGCIM02DTO dto)
			throws BLException {
		log.debug("========删除用户角色处理开始========");
		// 循环删除
		for (int i = 0; i < dto.getOwneiddids().length; i++) {
			Integer eiddid = dto.getEiddid();
			Integer eiddversion = dto.getEiddversion();
			String key = dto.getOwneiddids()[i];
			String impeiname = key.split(";")[1];
			String impversion = key.split(";")[0];
			// 用户角色删除主键
			soc0112BL.deleteEiDomainDetailByPK(new SOC0112PK(
					eiddid, eiddversion, impeiname, Integer
							.parseInt(impversion)));
		}
		dto.addMessage(new ActionMessage("IGCIM0204.I002"));
		log.debug("========删除用户角色处理终了========");
		return dto;
	}

	/**
	 * Description: 添加用户角色
	 * 
	 * @param dtoIGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */

	public IGCIM02DTO InsertImportVesionAction(IGCIM02DTO dto)
			throws BLException {
		log.debug("========添加用户角色处理开始========");
		// 循环添加
		for (int i = 0; i < dto.getEiddids().length; i++) {
			Integer eiddid = dto.getEiddid();
			Integer eiddversion = dto.getEiddversion();
			String key = dto.getEiddids()[i];
			String impeiname = key.split(";")[1];
			String impversion = key.split(";")[0];
			String date = IGStringUtils.getCurrentDateTime();
			soc0112BL
					.registEiDomainDetail(new SOC0112TB(eiddid,
							eiddversion, impeiname, Integer
									.parseInt(impversion), date));
		}
		dto.addMessage(new ActionMessage("IGCIM0204.I001"));
		log.debug("========添加用户角色处理终了========");
		return dto;
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0112Info> searchEiDomainDetailAction(
			SOC0112SearchCond cond) {
		return soc0112BL.searchEiDomainDetail(cond, 0, 0);
	}
	/**
	 * 给域添加应用
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public List<SOC0124Info>searchAppForDomainDetail()throws BLException{
		
		List<SOC0124Info> appList = new ArrayList<SOC0124Info>();
		SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();		
		//业务系统
		cond.setEsyscoding("999003001");
		appList.addAll(soc0118BL.searchEntityItemVW(cond));
		//应用资产
		cond.setEsyscoding("999003002");
		appList.addAll(soc0118BL.searchEntityItemVW(cond));
		return appList;
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond检索条件
	 * @param start检索记录起始行号
	 * @param count检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0120Info> searchImportVersionAction(
			SOC0120SearchCond cond) {
		return soc0120BL.searchImportVersion(cond, 0, 0);
	}

	/**
	 * 新增处理
	 * 
	 * @param instance新增实例
	 * @return 新增实例
	 */
	public SOC0112Info registEiDomainDetailAction(SOC0112Info instance)
			throws BLException {
		return soc0112BL.registEiDomainDetail(instance);
	}



	/**
	 * 资产域定义信息查询处理
	 * 
	 * @param dtoIGCIM02DTO
	 * @return IGCIM02DTO
	 */
	public IGCIM02DTO searchEiDomainDefAction(IGCIM02DTO dto) throws BLException {
		log.debug("========资产域定义信息查询处理开始========");

		// 资产域定义信息查询件数取得
		int totalCount = this.soc0111BL.getSearchCount(dto
				.getEiDomainDefSearchCond());

		if (totalCount == 0) {
			log.debug("========资产域定义信息查询数据不存在========");
			// 资产域定义信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}

		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========资产域定义信息查询数据件数过多========");
			// 资产域定义信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}

		// 分页用信息取得
		PagingDTO pDto = dto.getPagingDto();

		// 当前页资产域定义信息取得
		List<SOC0111Info> eiDomainDefInfoList = this.soc0111BL
				.searchEiDomainDef(dto.getEiDomainDefSearchCond(), pDto
						.getFromCount(), pDto.getPageDispCount());

		pDto.setTotalCount(totalCount);

		dto.setEiDomainDefInfoList(eiDomainDefInfoList);

		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));

		log.debug("========资产域定义信息查询处理终了========");
		return dto;
	}

	/**
	 * 资产域定义变更初始化
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM02DTO initIGCIM0202Action(IGCIM02DTO dto) throws BLException {
		log.debug("========变更资产域定义基本信息查询处理开始========");
		IGCIM0202Form form = dto.getIgcim0202Form();
		SOC0111Info ei = this.soc0111BL.searchEiDomainDefByPK(
				new SOC0111PK(form.getEiddid(),form.getVersion()));
		form.setEiddid(ei.getEiddid());//资产域定义Eidddid
		form.setName(ei.getName());//资产域定义名称
		form.setVersion(ei.getVersion());//版本号
		form.setDescription(ei.getDescription());//描述
		form.setCreatetime(ei.getCreatetime());//创建时间
		form.setUpdatetime(ei.getUpdatetime());//更新时间
		form.setFingerPrint(ei.getFingerPrint());//时间戳
		// 变更初始化模式
		form.setMode("1");
		dto.addMessage(new ActionMessage("IGCO10000.I001", resources
				.getMessage(dto.getLocale(), "message.IGCIM02BLImpl.001")));
		log.debug("========变更资产域定义基本信息查询处理终了========");
		return dto;
	}

	/**
	 * 资产域定义变更处理
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM02DTO updateEiDomainDefAction(IGCIM02DTO dto)
			throws BLException {
		log.debug("========变更资产域定义基本信息处理开始========");
		soc0111BL.updateEiDomainDef(dto.getIgcim0202Form());
		dto.addMessage(new ActionMessage("IGCO10000.I005", resources
				.getMessage(dto.getLocale(), "message.IGCIM02BLImpl.001")));
		log.debug("========变更资产域定义基本信息处理终了========");
		return dto;
	}

	/**
	 * 资产域定义详细信息初始化
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM02DTO initIGCIM0205Action(IGCIM02DTO dto) throws BLException {
		log.debug("========显示资产域定义基本信息查询处理开始========");
		IGCIM0205Form form = dto.getIgcim0205Form();
		SOC0111Info ei = this.soc0111BL.searchEiDomainDefByPK(new SOC0111PK(form.getEiddid(),form.getVersion()));
		form.setEiddid(ei.getEiddid());//资产域定义Eidddid
		form.setName(ei.getName());//资产域定义名称
		form.setVersion(ei.getVersion());//版本号
		form.setDescription(ei.getDescription());//描述
		form.setCreatetime(ei.getCreatetime());//创建时间
		form.setUpdatetime(ei.getUpdatetime());//更新时间
		form.setFingerPrint(ei.getFingerPrint());//时间戳
		dto.addMessage(new ActionMessage("IGCO10000.I001", resources
				.getMessage(dto.getLocale(), "message.IGCIM02BLImpl.001")));
		log.debug("========显示资产域定义基本信息查询处理终了========");
		return dto;
	}
	
	/**
	 * 域手动快照生成
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM02DTO handSnapshotAction(IGCIM02DTO dto) throws BLException {
		log.debug("========域手动快照生成处理开始========");
		IGCIM0203Form form = dto.getIgcim0203Form();
		//取得安装路径
		Properties properties = getProperties();
		String filepath = properties.getProperty("INSTALL_FILE_PATH");
		String batName = properties.getProperty("HAND_SNAPSHOT_BAT_NAME");
		String[] cmd = new String[7];
		cmd[0] = "cmd";
		cmd[1] = "/c";
		cmd[2] = "start";
		cmd[3] = " ";

		try {
			cmd[4] = filepath + batName;
			cmd[5] =form.getEiddid().toString();
			cmd[6] =form.getVersion().toString();
			
		    //调用bat文件执行
			java.lang.Runtime.getRuntime().exec(cmd);

		} catch (IOException e) {
			log.error("手动快照应用程序启动失败", e);
			throw new BLException("IGCIM0205.E001");
		}
		log.debug("========域手动快照生成处理终了========");
		return dto;
	}
	

	/**
	 * 控制台显示处理
	 * 
	 * @param dto IGCIM02DTO
	 * @return IGCIM02DTO
	 * @throws BLException
	 */
	public IGCIM02DTO initIGCIM0201Action(IGCIM02DTO dto) throws BLException {
		log.debug("========控制台显示处理开始========");
		
		IGCIM0201Form form = dto.getIgcim0201Form();
		
		//检索条件生成
		SOC0115SearchCondImpl cond = new SOC0115SearchCondImpl();
		
		if("0".equals(form.getTaskDone())) {
			cond.setTaskDone(false);//未完成
		} else if("1".equals(form.getTaskDone())) {
			cond.setTaskDone(true);//已完成
		} else {
			cond.setTaskError(true);//异常
		}
		cond.setDeleteflag_eq("0");//启用
		
		//待处理任务列表
		List<SOC0115Info> eiWaitTaskList = this.soc0115BL.searchEiWaitTask(cond);
		
		try {
			if("0".equals(form.getTaskDone())) {//未完成
				//CI导入应用资源文件
				Properties properties = this.getProperties();
				//待插入文件名列表
				List<String> fileNames = new ArrayList<String>();
				//CI导入文件夹路径
				File ciFile = new File(properties.getProperty("CI_IMPORT_FILE_PATH"));
				//判断文件夹是否存在
				if(ciFile.exists() && ciFile.isDirectory()) {
					//获取文件列表
//					 List<File> files = Arrays.asList(ciFile.listFiles());
//					 //将文件进行排序
//					 Collections.sort(files, new Comparator<File>(){  
//						      public int compare(File o1, File o2) {  
//							     if(o1.isDirectory() && o2.isDirectory()){ 
//							        return 0;  
//							     }
//							     if(o1.isDirectory() && o2.isFile()){
//							    	 return -1;  
//							     }
//							     if(o1.isFile() && o2.isDirectory()) { 
//								        return 1;  
//								 }
//						         long s1=o1.length();
//						         long s2=o2.length();
//						         if(s1==s2){
//						        	 return 0;
//						         }else{
//						        	 return s1>s2?1:-1;
//						         }
//						      }  
//						  });  
					File[] files=ciFile.listFiles();
					 for(File file : files) {
						 //判断是否是文件
						 if(file.isFile()) {
							 fileNames.add(file.getName());
						 }
					 }
				} else {
					throw new BLException("IGCIM0201.E002");
				}
			
				//导入数据列表
				SOC0120SearchCondImpl ivCond = new SOC0120SearchCondImpl();
				ivCond.setDeleteflag_eq("0");//启用
				List<SOC0120Info> importVersionList = this.soc0120BL.searchImportVersion(ivCond);
				//顶级CI类型信息
				List<SOC0113Info> eiImportProgrammeInfoList=this.soc0113BL.searchEiImportProgramme();
				//检索最大版本的默认域
				SOC0125Info eiDomainDefVWInfo=this.soc0125BL.searchEiDomainDefVW(CMDBConstants.EIDOMAINDEF_EIDDID);
				//当前时间
				String createTime = IGStringUtils.getCurrentDateTime();
				
				//插入在导入数据列表中存在，并且不在待处理任务中的文件
				for(String fileName : fileNames) {
					checkCiImportFileName(fileName);//检测采集文件名是否合法
					String ciName = fileName.substring(0, fileName.lastIndexOf("_"));//顶级CI名称
					String typeNumber=fileName.split("\\(")[1].split("\\)")[0];//顶级CI类型ID
				
					boolean flag = true;
					boolean impflag=true;
					if(eiWaitTaskList!=null&&eiWaitTaskList.size()>0){
						for(SOC0115Info ewt : eiWaitTaskList){
							//判断文件是否在待处理任务中存在
							if(ewt.getEitfilename().equals(fileName)) {
								flag = false;
								break;
							}
						}
					}
					if(importVersionList!=null&&importVersionList.size()>0){
						for(SOC0120Info importVersionInfo:importVersionList){
							//判断文件是否登记过导入对象
							if(importVersionInfo.getImpeiname().equals(ciName)){
								impflag = false;
								break;
							}
						}
					}
					//添加导入任务操作
					if(flag) {
						for(SOC0113Info eiImportProgrammeInfo:eiImportProgrammeInfoList){
							if(typeNumber.equals(Integer.toString(eiImportProgrammeInfo.getImpTypeid()))){
								SOC0113TB eiImportProgrammeTB=(SOC0113TB)SerializationUtils.clone(eiImportProgrammeInfo);
								SOC0115TB eiWaitTask = this.soc0115BL.getEiWaitTaskTBInstance();
								eiWaitTask.setEittopci(ciName);//顶级CI名称
								eiWaitTask.setEitfilename(fileName);//文件名
								eiWaitTask.setEitcreatetime(createTime);//任务创建时间
								eiWaitTask.setEitstatus(CMDBConstants.TASK_STATUS_WAIT);//待处理
								eiWaitTask.setImpTypeid(Integer.parseInt(typeNumber));//顶级CI类型
								eiWaitTask.setEiImportProgrammeTB(eiImportProgrammeTB);//不设第一次不好使，不显示对应名称。
								this.soc0115BL.registEiWaitTask(eiWaitTask);
								log.debug("增加文件" + fileName);
								}
							}
						}
					//添加导入对象操作
					if(impflag){
						SOC0120TB importVersionTB=new SOC0120TB();
						importVersionTB.setImpversion(0);//顶级CI版本
						importVersionTB.setImpeiname(ciName);//顶级CI名称
						importVersionTB.setImpeiid(0);//导入后资产EIID
						importVersionTB.setImpcitype(Integer.parseInt(typeNumber));//顶级CI类型
						importVersionTB.setDeleteflag("0");//默认标识
						//执行添加导入对象处理
						this.soc0120BL.registImportVersion(importVersionTB);
						SOC0112TB eiDomainDetailTB=new SOC0112TB();
						eiDomainDetailTB.setEiddid(eiDomainDefVWInfo.getEiddid());//域ID
						eiDomainDetailTB.setEiddversion(eiDomainDefVWInfo.getVersion());//域版本
						eiDomainDetailTB.setEiname(ciName);//实体名称
						eiDomainDetailTB.setCreatetime(IGStringUtils.getCurrentDateTime());//创建时间
						eiDomainDetailTB.setEiImportversion(0);//导入版本
						eiDomainDetailTB.setDeleteflag("0");//默认标识
						//将新实体添加到默认域中
						this.soc0112BL.registEiDomainDetail(eiDomainDetailTB);
					}
				}
				
				//查询任务列表
				dto.setEiWaitTaskList(this.soc0115BL.searchEiWaitTask(cond));
			
			} else {//已完成
				dto.setEiWaitTaskList(eiWaitTaskList);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			log.debug("控制台异常："+e.getMessage());
			log.debug(e);
		}
		
		log.debug("========控制台显示处理终了========");
		return dto;
	}
	
	/**
	 * 控制台任务查看处理
	 * 
	 * @param dto IGCIM02DTO
	 * @return IGCIM02DTO
	 * @throws BLException
	 */
	public IGCIM02DTO initIGCIM0210Action(IGCIM02DTO dto) throws BLException {
		log.debug("========控制台任务查看处理开始========");
		
		IGCIM0210Form form = dto.getIgcim0210Form();
		
		dto.setEiWaitTask(this.soc0115BL.searchEiWaitTaskByPK(form.getEitid()));
			
		log.debug("========控制台任务查看处理终了========");
		return dto;
	}
	
	/**
	 * 待处理任务删除处理
	 * 
	 * @param dto IGCIM02DTO
	 * @return IGCIM02DTO
	 * @throws BLException
	 */
	public IGCIM02DTO deleteEiWaitTaskAction(IGCIM02DTO dto) throws BLException {
		log.debug("========删除待处理任务处理开始========");
		
		IGCIM0201Form form = dto.getIgcim0201Form();
		
		String[] eitids = form.getEitids();//主键
		
		//CI导入应用资源文件
		Properties properties = this.getProperties();
		
		//CI导入文件夹路径
		String ciFilePath  = properties.getProperty("CI_IMPORT_FILE_PATH");
		
		//删除任务和相应文件
		if(eitids != null) {
			for(String eitid : eitids) {
				SOC0115Info eit = this.soc0115BL.searchEiWaitTaskByPK(Integer.parseInt(eitid));
				File file = new File(ciFilePath + File.separator + eit.getEitfilename());
				if(file.exists()) {
					file.delete();
				}
				this.soc0115BL.deleteEiWaitTask(eit);
			}
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I006", resources
				.getMessage(dto.getLocale(), "message.IGCIM0201.005")));
		
		log.debug("========删除待处理任务处理终了========");
		return dto;
	}
	
	/**
	 * 检测CI采集文件名是否合法
	 * 文件名格式为：顶级CI标识+‘_’+时间戳(YYYYMMDDHHMI)
	 * @param fileName 文件名
	 * @throws BLException 
	 */
	private void checkCiImportFileName(String fileName) throws BLException {
		if(fileName.indexOf("_") > 0 && fileName.indexOf(".") > 0&& fileName.indexOf("(") > 0 && fileName.lastIndexOf("_") < fileName.lastIndexOf(".")
				&& fileName.substring(fileName.lastIndexOf("_") + 1, fileName.lastIndexOf("(")).length() == 12) {
		} else {
			throw new BLException("IGCIM0201.E003", fileName);
		}
	}

	/**
	 * 资产域定义删除处理
	 * 
	 * @param dto
	 */
	public IGCIM02DTO deleteEiDomainDefAction(IGCIM02DTO dto)
			throws BLException {
		log.debug("========资产域定义信息删除处理开始========");
		// 循环删除
		for (int i = 0; i < dto.getDeleteEiddid().length; i++) {
			String key = dto.getDeleteEiddid()[i];
			String eiddid = key.split("_")[0];
//			String version = key.split("_")[1];
			List<SOC0111Info> eiDomainDefInfoList=this.soc0111BL.searchEiDomainDefByPK(Integer.parseInt(eiddid),null);
			// 资产域定义删除主键
			for(SOC0111Info eiDomainDefInfo:eiDomainDefInfoList){
			soc0111BL.deleteEiDomainDef(eiDomainDefInfo);
			}
		}
		dto.addMessage(new ActionMessage("IGCIM0204.I002"));
		log.debug("========资产域定义信息删除处理终了========");
		return dto;
	}

	/**
	 * 控制台导入处理
	 * 
	 * @param dtoIGCIM02DTO
	 * @return IGCIM02DTO
	 * @throws BLException
	 */
	public IGCIM02DTO importIGCIM0201Action(IGCIM02DTO dto) throws BLException {
		log.debug("========控制台导入处理开始========");
		//取得安装路径
		Properties properties = getProperties();
		String filepath = properties.getProperty("INSTALL_FILE_PATH");
		String importBatName = properties.getProperty("CI_IMPORT_BAT_NAME");
		String[] cmd = new String[5];
		cmd[0] = "cmd";
		cmd[1] = "/c";
		cmd[2] = "start";
		cmd[3] = " ";
		IGCIM0201Form form = dto.getIgcim0201Form();
		String[] eitids = form.getEitids();
        //从form中得到顶级ei名的数组、导入文件名数组、实体名数组
//		String batNames = null;
//		String filenames = null;
//		String einames = null;
//		String eitidParms = null;
		for(int i =0 ;i<eitids.length;i++){
			String eitid = eitids[i];
			SOC0115Info eiWaitTaskInfo = soc0115BL.searchEiWaitTaskByPK(Integer.valueOf(eitid));
			
			//通过顶级ei名，去导入数据版本管理表中取得版本最大的那条数据的导入类型
			//通过类型，从导入程序管理表中取得批处理文件名和相对目录
			SOC0120SearchCondImpl cond = new SOC0120SearchCondImpl();
			cond.setImpeiname(eiWaitTaskInfo.getEittopci());
/*			List<SOC0120Info>	importVersionList = soc0120BL.searchImportVersion(cond);
			String batName = null;
			if(importVersionList.size() == 1) {
				batName = importVersionList.get(0).getSoc0113TB().getImpProgramme();
			} else {
				throw new BLException("IGCO10000.E004", eiWaitTaskInfo.getEittopci());
			}*/
			String filename = eiWaitTaskInfo.getEitfilename();
			String einame = eiWaitTaskInfo.getEittopci();
			User user = dto.getUser();
			String userId = user.getUserid()+"!"+user.getUsername();
			//插入临时表
			SOC0116TB ewttTB=new SOC0116TB();
			ewttTB.setFileName(filename);
			ewttTB.setUserId(userId);
			ewttTB.setEiName(einame);
			ewttTB.setEitId(eitid);
			
			soc0116BL.registEiWaitTaskTemp(ewttTB);
			
//			if(i==0){
//				batNames = batName;
//				filenames = filename;
//				einames = einame;
//				eitidParms = eitid;
//			}else{
//				batNames = batNames + "!"+ batName;
//				filenames = filenames + "!" + filename;
//				einames = einames + "!" + einame;
//				eitidParms = eitidParms + "!" + eitid;
//			}
			
		}
		try {
//			User user = dto.getUser();	
			
			cmd[4] = filepath + importBatName;
//			cmd[5] =user.getUserid()+ "!" + user.getUsername();
//			cmd[5] =filenames;
//			cmd[6] =batNames;
//			cmd[7] =einames;
//			cmd[8] =user.getUserid()+ "!" + user.getUsername();
//			cmd[9] =eitidParms;
		    //调用bat文件执行
			java.lang.Runtime.getRuntime().exec(cmd);

		} catch (Exception e) {
			log.error("导入应用程序启动失败", e);
			throw new BLException("IGCIM0201.E005");
		}
		log.debug("========控制台导入处理终了========");
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
	 * 导入对象信息登记处理
	 */
	public IGCIM02DTO insertImportVersionAction(IGCIM02DTO dto)
			throws BLException {
		log.debug("========导入对象信息登记处理开始========");
		// 输入Form取得
		IGCIM0206Form form = dto.getIgcim0206Form();
		form.setImpversion(0);//版本号
		form.setImpeiid(0);//实体ID
		//资产模型层次码
//		if(form.getImpcitype()==1){
//			form.setEsyscoding("999001001001");//主机
//		}else if(form.getImpcitype()==2){
//			form.setEsyscoding("999001009001");//磁盘阵列
//		}else if(form.getImpcitype()==3){
//			form.setEsyscoding("999003");//应用资产
//		}else if(form.getImpcitype()==4){
//			form.setEsyscoding("999001006");//SAN交换机
//		}
		this.soc0120BL.registImportVersion(dto.getIgcim0206Form());
		// 导入对象基本信息
		dto.addMessage(new ActionMessage("IGCO10000.I004", resources
				.getMessage(dto.getLocale(), "message.IGCIM02BLImpl.002")));
		log.debug("========导入对象信息登记处理终了========");
		return dto;
	}

	/**
	 * 导入对象信息查询处理
	 */
	public IGCIM02DTO searchImportVersionAction(IGCIM02DTO dto) throws BLException {
		log.debug("========导入对象信息查询处理开始========");

		// 导入对象信息查询件数取得
		int totalCount = this.soc0120BL.getSearchCount(dto
				.getImportVersionSearchCond());
		
		if (totalCount == 0) {
			log.debug("========导入对象信息查询数据不存在========");
			// 导入对象信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}

		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========导入对象信息查询数据件数过多========");
			// 导入对象信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}

		// 分页用信息取得
		PagingDTO pDto = dto.getPagingDto();

		// 当前页导入对象信息取得
		List<SOC0120Info> importVersionInfoList = this.soc0120BL
				.searchImportVersion(dto.getImportVersionSearchCond(), pDto
						.getFromCount(), pDto.getPageDispCount());

		pDto.setTotalCount(totalCount);

		dto.setImportVersionInfoList(importVersionInfoList);

		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));

		log.debug("========导入对象信息查询处理终了========");
		return dto;
	}
	
	/**
	 * 采集查询
	 * 
	 * @param dtoIGCIM02DTO
	 * @return IGCIM02DTO
	 */
	public IGCIM02DTO searchCr03Action(IGCIM02DTO dto) throws BLException{
		log.debug("========采集查询开始========");
		//获取form
		IGCIM0802Form form=dto.getIgcim0802Form();
		
		//采集文件查询条件
		CR03SearchCondImpl cr03Cond=new CR03SearchCondImpl();
		// 导入对象信息查询件数取得
		if(form!=null){
			cr03Cond.setEsyscoding(form.getEsyscoding());
			if(StringUtils.isNotEmpty(form.getImpcreatetime_s())){
				String formTime=form.getImpcreatetime_s().replaceAll("/", "")+"000000";
				cr03Cond.setCollecttimeFrom(formTime);
			}
			if(StringUtils.isNotEmpty(form.getImpcreatetime_e())){
				String toTime=form.getImpcreatetime_e().replaceAll("/", "")+"595959";
				cr03Cond.setCollecttimeTo(toTime);
			}
			cr03Cond.setHost(form.getImpeiname_like());
			cr03Cond.setIp(form.getImpip());
		}
		int totalCount = cr03BL.getSearchCountByCondMaxAndEsyscoding(cr03Cond);
		
		if (totalCount == 0) {
			log.debug("========查询数据不存在========");
			// 查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}

		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========导入对象信息查询数据件数过多========");
			// 查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}

		// 分页用信息取得
		PagingDTO pDto = dto.getPagingDto();

		// 当前页导入对象信息取得
		List<CR03VWInfo> cr03VWInfoList = cr03BL.findByCondMaxAndEsyscoding(cr03Cond, pDto
						.getFromCount(), pDto.getPageDispCount());

		pDto.setTotalCount(totalCount);

		dto.setCr03VWInfoList(cr03VWInfoList);

		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		
		log.debug("========采集查询结束========");
		return dto;
	}
	
	
	/**
	 * 采集控制台查询处理
	 * @param dto IGCIM02DTO
	 * @throws BLException
	 */
	public IGCIM02DTO initIGCIM0214Action(IGCIM02DTO dto) throws BLException {
		log.debug("========采集控制台信息查询处理开始========");
		
		// 导入对象信息查询件数取得
		int totalCount = this.soc0120BL.getSearchCount(dto
				.getImportVersionSearchCond());
		
		if (totalCount == 0) {
			log.debug("========采集控制台信息查询数据不存在========");
			// 采集控制台信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========采集控制台信息查询数据件数过多========");
			// 采集控制台信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}
		
		// 分页用信息取得
		PagingDTO pDto = dto.getPagingDto();
		
		// 当前页采集控制台信息取得
		List<SOC0120Info> importVersionInfoList = this.soc0120BL
		.searchImportVersion(dto.getImportVersionSearchCond(), pDto
				.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setImportVersionInfoList(importVersionInfoList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		
		log.debug("========采集控制台信息查询处理终了========");
		return dto;
	}

	/**
	 * 导入对象删除处理
	 * @param dto
	 * @throws BLException
	 */
	public IGCIM02DTO deleteImportVersionAction(IGCIM02DTO dto) throws BLException {
		log.debug("========导入对象信息删除处理开始========");
		// 循环删除
		for (int i = 0; i < dto.getDeleteImpeiid().length; i++) {
			String key = dto.getDeleteImpeiid()[i];
			String impeiname = key.split("_")[0];
			String impversion = key.split("_")[1];
			// 导入对象删除主键
			soc0120BL.deleteImportVersionByPK(new SOC0120PK(Integer.parseInt(impversion),impeiname));
		}
		dto.addMessage(new ActionMessage("IGCIM0204.I002"));
		log.debug("========导入对象信息删除处理终了========");
		return dto;
	}

	/**
	 * 导入对象状态调整
	 * @param dto
	 * @throws BLException
	 */
	public void changeDeleteFlagAction(IGCIM02DTO dto) throws BLException {
		log.debug("========导入对象状态变化处理开始========");
		SOC0120Info importVersionInfo = soc0120BL.searchImportVersionByPK(new SOC0120PK(dto.getImpversion(),dto.getImpeiname()));
		SOC0120TB importVersionTB = (SOC0120TB)SerializationUtils.clone(importVersionInfo);
		if("0".equals(importVersionInfo.getDeleteflag())){
			importVersionTB.setDeleteflag("1");
		} else if ("1".equals(importVersionInfo.getDeleteflag())){
			importVersionTB.setDeleteflag("0");
		}
		soc0120BL.updateImportVersion(importVersionTB);
		log.debug("========导入对象状态变化处理结束========");
	}

	/**
	 * 导入对象类型
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM02DTO getEiImportProgrammeAction(IGCIM02DTO dto) throws BLException {
		log.debug("========导入对象类型查询处理开始========");
		List<SOC0113Info> impTypeInfoList=this.soc0113BL.searchEiImportProgramme();
		List<LabelValueBean> impTypeList = new ArrayList<LabelValueBean>();
		impTypeList.add(new LabelValueBean("",""));
		for(SOC0113Info info : impTypeInfoList){
			impTypeList.add(new LabelValueBean(info.getImpTypename(),info.getImpTypeid().toString()));
		}
		dto.setImpTypeList(impTypeList);
		log.debug("========导入对象类型查询处理结束========");
		return dto;
	}

	/**
	 * 导入对象版本检索
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM02DTO searchImportVersionIGCIM0210Action(IGCIM02DTO dto)
			throws BLException {
		log.debug("========导入对象版本查询处理开始========");
		SOC0120Info importVersionInfo = soc0120BL.searchImportVersionByPK(new SOC0120PK(dto.getImpversion(),dto.getImpeiname()));
		List<SOC0120Info> importVersionInfoList = this.soc0120BL
		.searchImportVersionByPK(dto.getImpeiname(),dto.getImpversion());
		if(importVersionInfoList==null){
			dto.addMessage(new ActionMessage("IGCO10000.E004",resources
					.getMessage(dto.getLocale(),"message.IGCIM02BLImpl.003")));
			
		}else{
			dto.setImportVersionInfoList(importVersionInfoList);
		}
			dto.setImportVersionInfo(importVersionInfo);
		log.debug("========导入对象版本查询处理结束========");
		return dto;
	}

	/**
	 * 资产域定义版本检索
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM02DTO searchIGCIM0212Action(IGCIM02DTO dto) throws BLException {
		log.debug("========资产域定义版本查询处理开始========");
		IGCIM0212Form form=dto.getIgcim0212Form();
		SOC0111Info eiDomainDefInfo = this.soc0111BL.searchEiDomainDefByPK(new SOC0111PK(form.getEiddid(),form.getVersion()));
		List<SOC0111Info> eiDomainDefInfoList = this.soc0111BL.searchEiDomainDefByPK(form.getEiddid(),form.getVersion());
		if(eiDomainDefInfoList==null){
			dto.addMessage(new ActionMessage("IGCO10000.E004",resources
					.getMessage(dto.getLocale(),"message.IGCIM02BLImpl.003")));
			
		}else{
			dto.setEiDomainDefInfoList(eiDomainDefInfoList);
		}
			dto.setEiDomainDefInfo(eiDomainDefInfo);
		log.debug("========资产域定义版本查询处理结束========");
		return dto;
	}

	/**
	 * 最新版本域信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM02DTO searchIGCIM0213Action(IGCIM02DTO dto) throws BLException {
		log.debug("========最新版本域信息查询处理开始========");
		List<SOC0125Info> eiDomainDefVWInfoList=this.soc0125BL.searchEiDomainDefVW();
		List<LabelValueBean> domainList = new ArrayList<LabelValueBean>();
		domainList.add(new LabelValueBean("",""));
		for(SOC0125Info info : eiDomainDefVWInfoList){
			domainList.add(new LabelValueBean(info.getName(),info.getEiddid().toString()));
		}
		List<LabelValueBean> typeList = new ArrayList<LabelValueBean>();
		typeList.add(new LabelValueBean("顶级","1"));
//		typeList.add(new LabelValueBean("全部","2"));
		dto.setDomainList(domainList);
		dto.setTypeList(typeList);
		log.debug("========最新版本域信息查询处理结束========");
		return dto;
	}

	/**
	 * 域CI查询处理
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM02DTO searchDoaminCiInfoAction(IGCIM02DTO dto)
			throws BLException {
		log.debug("========域CI查询处理开始========");
		IGCIM0213Form form=dto.getIgcim0213Form();
		
		Integer temp_eiid = 0;
		boolean flag=false;
		SOC0118Info ei=null;
		if(StringUtils.isNotEmpty(form.getEiid())){
			temp_eiid = Integer.valueOf(form.getEiid());
			//判断资产类型，如果为DA或者DISK则需要先找到其所属存储（顶级CI）的EIID，再按照该EIID进行域CI查询
			if(temp_eiid > 0){
				ei = soc0118BL.searchEntityItemByKey(temp_eiid);
				if(ei!=null){
					//判断是否为硬盘
					if("999001013".equals(ei.getEsyscoding())){
						flag=true;
						dto.setEiid(temp_eiid);
					}
					//判断是否为DA
					if("999001012".equals(ei.getEsyscoding())){
						temp_eiid = ei.getEirootmark();
					}else{
						temp_eiid = 0;
					}
				}
			}
		}
		
		
		

		//版本取得
		if(StringUtils.isNotEmpty(form.getEiddid())){
			SOC0125Info eiDomainDefVWInfo=this.soc0125BL.searchEiDomainDefVW(form.getEiddid());
			form.setEiddversion(eiDomainDefVWInfo.getVersion().toString());
			dto.setEiDomainDetailVWSearchCond(form);
		}
		
		
		
		if(StringUtils.isNotEmpty(form.getEilabel())){
			if("1".equals(form.getTypeId())){
				//如果是硬盘时
				if(flag){
					searchCIInfoAction(dto);
				}else{
					int totalCount = this.soc0126BL.getSearchCountCI(dto
							.getEiDomainDetailVWSearchCond(),temp_eiid);
					
					if (totalCount == 0) {
						log.debug("========域CI查询数据不存在========");
						// 域CI查询数据不存在
						dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
						return dto;
					}

					if (totalCount > dto.getMaxSearchCount()) {
						log.debug("========域CI查询数据件数过多========");
						// 域CI查询数据件数过多
						dto.addMessage(new ActionMessage("IGCO00000.E005", dto
								.getMaxSearchCount(), totalCount));
						return dto;
					}

					// 分页用信息取得
					PagingDTO pDto = dto.getPagingDto();

					// 当前页域CI取得
					List<SOC0136Info> eiDomainDetailCIInfoList = this.soc0126BL
							.searchEiDomainDetailVWCI(dto.getEiDomainDetailVWSearchCond(), pDto
									.getFromCount(), pDto.getPageDispCount(),temp_eiid);

					pDto.setTotalCount(totalCount);
					dto.setSOC0136InfoList(eiDomainDetailCIInfoList);
					dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
				}
			}
			if("2".equals(form.getTypeId())){
				
			}
		}else{
			if("1".equals(form.getTypeId())){
				// 域CI查询件数取得
				int totalCount = this.soc0126BL.getSearchCount(dto
						.getEiDomainDetailVWSearchCond());
				
				if (totalCount == 0) {
					log.debug("========域CI查询数据不存在========");
					// 域CI查询数据不存在
					dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
					return dto;
				}

				if (totalCount > dto.getMaxSearchCount()) {
					log.debug("========域CI查询数据件数过多========");
					// 域CI查询数据件数过多
					dto.addMessage(new ActionMessage("IGCO00000.E005", dto
							.getMaxSearchCount(), totalCount));
					return dto;
				}

				// 分页用信息取得
				PagingDTO pDto = dto.getPagingDto();

				// 当前页域CI取得
				List<SOC0138Info> eiDomainDetailCIOneInfoList = this.soc0126BL
						.searchEiDomainDetailVW(dto.getEiDomainDetailVWSearchCond(), pDto
								.getFromCount(), pDto.getPageDispCount());

				pDto.setTotalCount(totalCount);
				dto.setSOC0138InfoList(eiDomainDetailCIOneInfoList);

				dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
			}
			if("2".equals(form.getTypeId())){
				// 域CI查询件数取得
				int totalCount = this.soc0126BL.getSearchCount(dto
						.getEiDomainDetailVWSearchCond());
				
				if (totalCount == 0) {
					log.debug("========域CI查询数据不存在========");
					// 域CI查询数据不存在
					dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
					return dto;
				}

				if (totalCount > dto.getMaxSearchCount()) {
					log.debug("========域CI查询数据件数过多========");
					// 域CI查询数据件数过多
					dto.addMessage(new ActionMessage("IGCO00000.E005", dto
							.getMaxSearchCount(), totalCount));
					return dto;
				}

				// 分页用信息取得
				PagingDTO pDto = dto.getPagingDto();

				// 当前页域CI取得
				List<SOC0138Info> eiDomainDetailCIOneInfoList = this.soc0126BL
						.searchEiDomainDetailVW(dto.getEiDomainDetailVWSearchCond(), pDto
								.getFromCount(), pDto.getPageDispCount());

				pDto.setTotalCount(totalCount);
				dto.setSOC0138InfoList(eiDomainDetailCIOneInfoList);

				dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
			}
		}
		
		log.debug("========域CI查询处理结束========");
		return dto;
	}

	/**
	 * 当影响CI为硬盘时，只检索出主机
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM02DTO searchCIInfoAction(IGCIM02DTO dto) throws BLException {
		log.debug("========硬盘影响的主机查询处理开始========");
		int totalCount = this.soc0126BL.getSearchCountCIByDisk(dto
				.getEiDomainDetailVWSearchCond(),dto.getEiid());
		
		if (totalCount == 0) {
			log.debug("========域CI查询数据不存在========");
			// 域CI查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}

		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========域CI查询数据件数过多========");
			// 域CI查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}

		// 分页用信息取得
		PagingDTO pDto = dto.getPagingDto();

		// 当前页域CI取得
		List<SOC0136Info> eiDomainDetailCIInfoList = this.soc0126BL
				.searchEiDomainDetailVWCIByDisk(dto.getEiDomainDetailVWSearchCond(), pDto
						.getFromCount(), pDto.getPageDispCount(),dto.getEiid());

		pDto.setTotalCount(totalCount);
		dto.setSOC0136InfoList(eiDomainDetailCIInfoList);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		
		log.debug("========硬盘影响的主机查询处理结束========");
		return dto;
	}

	public IGCIM02DTO searchEiDomainDefActionNoPage(IGCIM02DTO dto)
			throws BLException {
		
		// 当前页资产域定义信息取得
		List<SOC0111Info> eiDomainDefInfoList = this.soc0111BL
				.searchEiDomainDef(dto.getEiDomainDefSearchCond());


		dto.setEiDomainDefInfoList(eiDomainDefInfoList);

		log.debug("========资产域定义信息查询处理终了========");
		return dto;
	}

	/**
	 * 原始数据导入处理
	 * 
	 * @param dto IGCIM02DTO
	 * @return IGCIM02DTO
	 * @throws BLException
	 */
	public IGCIM02DTO initIGCIM0803Action(IGCIM02DTO dto) throws BLException {

		log.debug("========控制台显示处理开始========");
		
		IGCIM0201Form form = dto.getIgcim0201Form();
		
		//检索条件生成
		CR03SearchCondImpl cr03Cond = new CR03SearchCondImpl();
		if(StringUtils.isNotEmpty(form.getImpcreatetime_s())){
			cr03Cond.setCollecttimeFrom(form.getImpcreatetime_s().replace("/", "")+"000000");
		}
		if(StringUtils.isNotEmpty(form.getImpcreatetime_e())){
			cr03Cond.setCollecttimeTo(form.getImpcreatetime_e().replace("/", "")+"999999");
		}
		cr03Cond.setStatus(form.getStatus());
		
		//待处理任务列表
		//List<SOC0115Info> eiWaitTaskList = this.soc0115BL.searchEiWaitTask();
		
		try {	
				//待插入任务列表
//				List<CR03Info> cr03List = this.cr03BL.searchCR03(cr03Cond);
				List<CR03Info> cr03List = this.cr03BL.findByCondMax(cr03Cond,0,0);
				
				//导入数据列表
				SOC0120SearchCondImpl ivCond = new SOC0120SearchCondImpl();
				//ivCond.setDeleteflag_eq("0");//启用
				List<SOC0120Info> importVersionList = this.soc0120BL.searchImportVersion(ivCond);
				//顶级CI类型信息
				List<SOC0113Info> eiImportProgrammeInfoList=this.soc0113BL.searchEiImportProgramme();
				//检索最大版本的默认域
				SOC0125Info eiDomainDefVWInfo=this.soc0125BL.searchEiDomainDefVW(CMDBConstants.EIDOMAINDEF_EIDDID);
				
				List<SOC0120TB> ivlist = new ArrayList<SOC0120TB>();
				//插入在导入数据列表中存在，并且不在待处理任务中的文件
				List<CR03Info> removecr03List = new ArrayList<CR03Info>();
				for(CR03Info cr03Info : cr03List) {
					//checkCiImportFileName(fileName);//检测采集文件名是否合法
					String ciName = cr03Info.getHost();
					Integer typeNumber = cr03Info.getType();//顶级CI类型ID
					String tableName = cr03Info.getTablename();
					String collecttime = cr03Info.getCollecttime().trim();
					String ip = cr03Info.getIp();
					String servername = cr03Info.getServername();
					boolean flag = true;
					boolean impflag=true;
					if(importVersionList!=null&&importVersionList.size()>0){
						for(SOC0120Info importVersionInfo:importVersionList){
							//判断文件是否登记过导入对象
							if(importVersionInfo.getImpeiname().equals(ciName)){
								impflag = false;
								if(importVersionInfo.getDeleteflag().equals("1"))
									removecr03List.add(cr03Info);
								break;
							}
						}
					}
					//添加导入任务操作
					if(flag) {
						for(SOC0113Info eiImportProgrammeInfo:eiImportProgrammeInfoList){
							if(typeNumber.equals(eiImportProgrammeInfo.getImpTypeid())){
								SOC0113TB eiImportProgrammeTB=(SOC0113TB)SerializationUtils.clone(eiImportProgrammeInfo);
								SOC0115TB eiWaitTask = this.soc0115BL.getEiWaitTaskTBInstance();
								eiWaitTask.setEittopci(ciName);//顶级CI名称
								eiWaitTask.setEitfilename(ciName+"#"+ip+"#"+servername);//文件名
								eiWaitTask.setEitcreatetime(collecttime);//任务创建时间
								eiWaitTask.setEitstatus(CMDBConstants.TASK_STATUS_WAIT);//待处理
								eiWaitTask.setImpTypeid(typeNumber);//顶级CI类型
								eiWaitTask.setEiImportProgrammeTB(eiImportProgrammeTB);//不设第一次不好使，不显示对应名称。
								eiWaitTask.setFingerPrint(tableName);
								if(StringUtils.isEmpty(cr03Info.getFingerPrint())) {
									this.soc0115BL.registEiWaitTask(eiWaitTask);
								}
								log.debug("增加文件" + ciName);
								}
							}
						}
					//添加导入对象操作
					if(impflag){
						SOC0120TB importVersionTB=new SOC0120TB();
						importVersionTB.setImpversion(0);//顶级CI版本
						importVersionTB.setImpeiname(ciName);//顶级CI名称
						importVersionTB.setImpeiid(0);//导入后资产EIID
						importVersionTB.setImpcitype(typeNumber);//顶级CI类型
						importVersionTB.setDeleteflag("0");//默认标识
						//执行添加导入对象处理
						boolean fl=false;
						for(SOC0120TB ivtb : ivlist){
							if(ivtb.getImpeiname().equals(ciName)){
								fl=true;
							}
						}
						if(!fl){
							this.soc0120BL.registImportVersion(importVersionTB);
							ivlist.add(importVersionTB);
						}
						SOC0112TB eiDomainDetailTB=new SOC0112TB();
						eiDomainDetailTB.setEiddid(eiDomainDefVWInfo.getEiddid());//域ID
						eiDomainDetailTB.setEiddversion(eiDomainDefVWInfo.getVersion());//域版本
						eiDomainDetailTB.setEiname(ciName);//实体名称
						eiDomainDetailTB.setCreatetime(IGStringUtils.getCurrentDateTime());//创建时间
						eiDomainDetailTB.setEiImportversion(0);//导入版本
						eiDomainDetailTB.setDeleteflag("0");//默认标识
						//将新实体添加到默认域中
						this.soc0112BL.registEiDomainDetail(eiDomainDetailTB);
					}
				}
				//删除list中已经停用的对象
				cr03List.removeAll(removecr03List);
				//查询任务列表
				dto.setCr03InfoList(cr03List);
				dto.setEiWaitTaskList(this.soc0115BL.searchEiWaitTask());			
		} catch (NumberFormatException e) {
			e.printStackTrace();
			log.debug("控制台异常："+e.getMessage());
			log.debug(e);
		}
		
		log.debug("========控制台显示处理终了========");
		return dto;
	}
	/**
	 * 处理CR03状态
	 * 
	 * @param dto IGCIM02DTO
	 * @return IGCIM02DTO
	 * @throws BLException
	 */
	public IGCIM02DTO initCR03Action(IGCIM02DTO dto) throws BLException {
        
        List<SOC0115Info> soc0115List = dto.getEiWaitTaskList();
        List<CR03Info> cr03List = new ArrayList<CR03Info>();
        List<CR03Info> cr03InfoList = dto.getCr03InfoList();
        
        for(CR03Info cr03info : cr03InfoList){
        	 for(SOC0115Info soc0115Info : soc0115List){
        		 String eitfilename = soc0115Info.getEitfilename();
        		 String[] split = eitfilename.split("_");
        		 String ip="";
        		 if(split.length>1){
        			 ip=split[1];
        		 }
        		 if(cr03info.getCollecttime().trim().equals(soc0115Info.getEitcreatetime().trim()) &&
        				 cr03info.getHost().equals(soc0115Info.getEittopci()) && 
        				 cr03info.getTablename().equals(soc0115Info.getFingerPrint()) &&
        				 cr03info.getIp().equals(ip) && cr03info.getType().toString().equals(soc0115Info.getImpTypeid().toString())){
        				
        			CR03TB cr03tb =(CR03TB) this.cr03BL.searchCR03ByPK(new CR03PK(soc0115Info.getImpTypeid(),ip,soc0115Info.getEittopci(),soc0115Info.getEitcreatetime().trim()));
        			if(!cr03tb.getStatus().equals("5")){
        				if("6,7,8".indexOf(soc0115Info.getEitstatus())!=-1){
        					cr03tb.setStatus("1");
        				} else if("1".equals(soc0115Info.getEitstatus())){
        					cr03tb.setStatus("2");
        				} else if("2,4".indexOf(soc0115Info.getEitstatus())!=-1){
        					cr03tb.setStatus("3");
        				} else if("3,5".indexOf(soc0115Info.getEitstatus())!=-1){
        					cr03tb.setStatus("4");
        				}
        			}
                 	cr03tb.setFingerPrint(soc0115Info.getEitid().toString());
                 	cr03List.add(cr03tb);
                 	if(cr03tb.getFingerPrint().equals(""))
                 		this.cr03BL.updateCR03(cr03tb);
                 	break;
        		 }
             }
        }
 
		dto.setCr03InfoList(cr03List);
		return dto;
	}
	
	/**
	 * 控制台导入处理
	 * 
	 * @param dtoIGCIM02DTO
	 * @return IGCIM02DTO
	 * @throws BLException
	 */
	public IGCIM02DTO importIGCIM0803Action(IGCIM02DTO dto) throws BLException {
		log.debug("========控制台导入处理开始========");
		
		//取得安装路径
		Properties properties = getProperties();
		String filepath = properties.getProperty("INSTALL_FILE_PATH");
		String importBatName = properties.getProperty("CI_IMPORT_BAT_NAME_CI02");
		String[] cmd = new String[5];
		cmd[0] = "cmd";
		cmd[1] = "/c";
		cmd[2] = "start";
		cmd[3] = " ";
		
		IGCIM0201Form form = dto.getIgcim0201Form();
		form.setTaskBeing(true);
		String[] eitids = form.getEitids();
        //从form中得到顶级ei名的数组、导入文件名数组、实体名数组
		for(int i =0 ;i<eitids.length;i++){
			String eitid = eitids[i];
			SOC0115Info eiWaitTaskInfo = soc0115BL.searchEiWaitTaskByPK(Integer.valueOf(eitid));
			
			//通过顶级ei名，去导入数据版本管理表中取得版本最大的那条数据的导入类型
			//通过类型，从导入程序管理表中取得批处理文件名和相对目录
			SOC0120SearchCondImpl cond = new SOC0120SearchCondImpl();
			cond.setImpeiname(eiWaitTaskInfo.getEittopci());
			String filename = eiWaitTaskInfo.getEitfilename()+"_"+eiWaitTaskInfo.getEitcreatetime().trim()+"("+eiWaitTaskInfo.getImpTypeid()+")";
			String einame = eiWaitTaskInfo.getEittopci();
			String tableName = eiWaitTaskInfo.getFingerPrint();
			User user = dto.getUser();
			String userId = user.getUserid()+"!"+user.getUsername();
			//插入临时表
			SOC0116TB ewttTB=new SOC0116TB();
			ewttTB.setFileName(filename);
			ewttTB.setUserId(userId);
			ewttTB.setEiName(einame);
			ewttTB.setEitId(eitid);
			ewttTB.setFingerPrint(tableName);
			soc0116BL.registEiWaitTaskTemp(ewttTB);
		}
		List<CR03Info> cr03List = this.cr03BL.searchCR03();
		for(CR03Info cr03info:cr03List){
			if(StringUtils.isEmpty(cr03info.getFingerPrint())){
    			CR03TB cr03tb =(CR03TB) this.cr03BL.searchCR03ByPK(new CR03PK(cr03info.getType(),cr03info.getIp(),cr03info.getHost(),cr03info.getCollecttime().trim()));
    			cr03tb.setStatus("5");
				this.cr03BL.updateCR03(cr03info);
			}
		}
		try {
			
			cmd[4] = filepath + importBatName;
			
			java.lang.Runtime.getRuntime().exec(cmd);

		} catch (Exception e) {
			log.error("导入应用程序启动失败", e);
			throw new BLException("IGCIM0201.E005");
		}finally{
			//closeHQServer();
		}
		log.debug("========控制台导入处理终了========");
		return dto;
	}
	/**
	 * 待处理任务删除处理
	 * 
	 * @param dto IGCIM02DTO
	 * @return IGCIM02DTO
	 * @throws BLException
	 */
	public IGCIM02DTO deleteEiWaitTaskAction0803(IGCIM02DTO dto) throws BLException {
		log.debug("========删除待处理任务处理开始========");

		IGCIM0201Form form = dto.getIgcim0201Form();
		
		String[] eitids = form.getEitids();//主键
		
		//删除任务和相应文件
		if(eitids != null) {
			for(String eitid : eitids) {
				SOC0115Info eit = this.soc0115BL.searchEiWaitTaskByPK(Integer.parseInt(eitid));
				String eitfilename = eit.getEitfilename();
				String[] split = eitfilename.split("_");
				String ip=split[1];
    			CR03TB cr03 =(CR03TB) this.cr03BL.searchCR03ByPK(new CR03PK(eit.getImpTypeid(),ip,eit.getEittopci(),eit.getEitcreatetime().trim()));
				cr03.setStatus("5");
				cr03BL.updateCR03(cr03);
				this.soc0115BL.deleteEiWaitTask(eit);
			}
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I006", resources
				.getMessage(dto.getLocale(), "message.IGCIM0201.005")));
		
		log.debug("========删除待处理任务处理终了========");
		return dto;
	}

	public CicollecttaskBL getCicollecttaskBL() {
		return cicollecttaskBL;
	}

	public void setCicollecttaskBL(CicollecttaskBL cicollecttaskBL) {
		this.cicollecttaskBL = cicollecttaskBL;
	}
	public void init() throws Exception {
		CodeListUtils codeListUtils = this.getCodeListUtils();
		hqapi = HQUtil.getHQApi(codeListUtils);
	}
	/**
	 * get CodeList Utils
	 * 
	 * @return
	 * @throws Exception
	 */
	private CodeListUtils getCodeListUtils() throws Exception {
		CodeListUtils codeListUtils = (CodeListUtils) WebApplicationSupport
				.getBean("codeListUtils");
		return codeListUtils;
	}
}
