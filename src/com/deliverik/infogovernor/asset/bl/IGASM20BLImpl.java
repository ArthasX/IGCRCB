/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.bl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.asset.EiDomainDetailCIInfo;
import com.deliverik.framework.asset.bl.task.CMDBConstants;
import com.deliverik.framework.asset.bl.task.EiDomainDefBL;
import com.deliverik.framework.asset.bl.task.EiDomainDefVWBL;
import com.deliverik.framework.asset.bl.task.EiDomainDetailBL;
import com.deliverik.framework.asset.bl.task.EiDomainDetailMaxVWBL;
import com.deliverik.framework.asset.bl.task.EiImportProgrammeBL;
import com.deliverik.framework.asset.bl.task.EiWaitTaskBL;
import com.deliverik.framework.asset.bl.task.IG013BL;
import com.deliverik.framework.asset.bl.task.ImportVersionBL;
import com.deliverik.framework.asset.model.EiDomainDefInfo;
import com.deliverik.framework.asset.model.EiDomainDefVWInfo;
import com.deliverik.framework.asset.model.EiDomainDetailInfo;
import com.deliverik.framework.asset.model.EiDomainDetailMaxVWInfo;
import com.deliverik.framework.asset.model.EiImportProgrammeInfo;
import com.deliverik.framework.asset.model.EiWaitTaskInfo;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.asset.model.ImportVersionInfo;
import com.deliverik.framework.asset.model.condition.EiDomainDetailSearchCond;
import com.deliverik.framework.asset.model.condition.EiWaitTaskSearchCondImpl;
import com.deliverik.framework.asset.model.condition.IG688SearchCondImpl;
import com.deliverik.framework.asset.model.condition.ImportVersionSearchCond;
import com.deliverik.framework.asset.model.condition.ImportVersionSearchCondImpl;
import com.deliverik.framework.asset.model.entity.EiDomainDefPK;
import com.deliverik.framework.asset.model.entity.EiDomainDetailPK;
import com.deliverik.framework.asset.model.entity.EiDomainDetailTB;
import com.deliverik.framework.asset.model.entity.EiWaitTaskTB;
import com.deliverik.framework.asset.model.entity.ImportVersionPK;
import com.deliverik.framework.asset.model.entity.ImportVersionTB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.asset.dto.IGASM20DTO;
import com.deliverik.infogovernor.asset.form.IGASM2001Form;
import com.deliverik.infogovernor.asset.form.IGASM2002Form;
import com.deliverik.infogovernor.asset.form.IGASM2003Form;
import com.deliverik.infogovernor.asset.form.IGASM2005Form;
import com.deliverik.infogovernor.asset.form.IGASM2006Form;
import com.deliverik.infogovernor.asset.form.IGASM2010Form;
import com.deliverik.infogovernor.asset.form.IGASM2012Form;
import com.deliverik.infogovernor.asset.form.IGASM2013Form;

/**
 * 概述: 资产域定义业务逻辑实现
 * 功能描述: 资产域定义业务逻辑实现
 * 创建记录: 2011/04/25
 * 修改记录: 
 */
public class IGASM20BLImpl extends BaseBLImpl implements IGASM20BL {
	static Log log = LogFactory.getLog(IGASM20BLImpl.class);

	/** 资产域定义BL */
	protected EiDomainDefBL eiDomainDefBL;

	/** 资产域明细 */
	protected EiDomainDetailBL eiDomainDetailBL;

	/** 导入数据版本 */
	protected ImportVersionBL importVersionBL;

	/** 待处理任务业务逻辑接口 */
	protected EiWaitTaskBL eiWaitTaskBL;
	/** 导入对象类型 */
	protected EiImportProgrammeBL eiImportProgrammeBL;
	
	/** 最新版本域业务逻辑接口 */
	protected EiDomainDefVWBL eiDomainDefVWBL;
	
	/**资产实体查询BL*/
	protected IG013BL ig013BL;
	
	/** 资产域明细业务逻辑接口 */
	protected EiDomainDetailMaxVWBL eiDomainDetailMaxVWBL;
	
	
	/**
	 * 资产域明细业务逻辑接口设定
	 * @param eiDomainDetailMaxVWBL资产域明细业务逻辑接口
	 */
	public void seteiDomainDetailMaxVWBL(EiDomainDetailMaxVWBL eiDomainDetailMaxVWBL) {
		this.eiDomainDetailMaxVWBL = eiDomainDetailMaxVWBL;
	}
	
	
	/**
	 * 设置资产实体
	 * @param ig013BL
	 */	
	public void setIg013BL(IG013BL ig013BL) {
		this.ig013BL = ig013BL;
	}

	/**
	 * 最新版本域业务逻辑接口设定
	 * @param eiDomainDefVWBL最新版本域业务逻辑接口
	 */
	public void setEiDomainDefVWBL(EiDomainDefVWBL eiDomainDefVWBL) {
		this.eiDomainDefVWBL = eiDomainDefVWBL;
	}

	/**
	 * 导入对象类型
	 * @param eiImportProgrammeBL导入对象类型
	 */
	public void setEiImportProgrammeBL(EiImportProgrammeBL eiImportProgrammeBL) {
		this.eiImportProgrammeBL = eiImportProgrammeBL;
	}

	/**
	 * 资产域定义BL设置
	 * 
	 * @param eiDomainDefBL资产域定义BL
	 */
	public void setEiDomainDefBL(EiDomainDefBL eiDomainDefBL) {
		this.eiDomainDefBL = eiDomainDefBL;
	}

	/**
	 * 待处理任务业务逻辑接口设置
	 * 
	 * @param eiWaitTaskBL待处理任务业务逻辑接口
	 */
	public void setEiWaitTaskBL(EiWaitTaskBL eiWaitTaskBL) {
		this.eiWaitTaskBL = eiWaitTaskBL;
	}
	/**
	 * 导入数据版本BL设置
	 * 
	 * @param eiDomainDefBL资产域定义BL
	 */
	public void setImportVersionBL(ImportVersionBL importVersionBL) {
		this.importVersionBL = importVersionBL;
	}

	/**
	 * 资产域明细BL设置
	 * 
	 * @param eiDomainDefBL资产域定义BL
	 */
	public void setEiDomainDetailBL(EiDomainDetailBL eiDomainDetailBL) {
		this.eiDomainDetailBL = eiDomainDetailBL;
	}

	/**
	 * 资产域定义信息登记处理
	 * 
	 * @param dtoIGASM20DTO
	 * @return IGASM20DTO
	 */
	public IGASM20DTO insertEiDomainDefAction(IGASM20DTO dto)
			throws BLException {
		log.debug("========资产域定义信息登记处理开始========");
		// 输入Form取得
		IGASM2002Form form = dto.getIgasm2002Form();
		Integer eiddid = eiDomainDefBL.findMaxEiddId();
		if (eiddid == null) {
			form.setEiddid(1000);
		} else {
			form.setEiddid(eiddid + 1);
		}
		form.setVersion(0);
		this.eiDomainDefBL.registEiDomainDef(dto.getIgasm2002Form());
		// 资产域定义基本信息
		dto.addMessage(new ActionMessage("IGCO10000.I004", "Domain基本信息"));
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

	public IGASM20DTO revokeImportVesionAction(IGASM20DTO dto)
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
			eiDomainDetailBL.deleteEiDomainDetailByPK(new EiDomainDetailPK(
					eiddid, eiddversion, impeiname, Integer
							.parseInt(impversion)));
		}
		dto.addMessage(new ActionMessage("IGASM2004.I002"));
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

	public IGASM20DTO InsertImportVesionAction(IGASM20DTO dto)
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
			eiDomainDetailBL
					.registEiDomainDetail(new EiDomainDetailTB(eiddid,
							eiddversion, impeiname, Integer
									.parseInt(impversion), date));
		}
		dto.addMessage(new ActionMessage("IGASM2004.I001"));
		log.debug("========添加用户角色处理终了========");
		return dto;
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond检索条件
	 * @return 检索结果列表
	 */
	public List<EiDomainDetailInfo> searchEiDomainDetailAction(
			EiDomainDetailSearchCond cond) {
		return eiDomainDetailBL.searchEiDomainDetail(cond, 0, 0);
	}
	/**
	 * 给域添加应用
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public List<IG688Info>searchAppForDomainDetail()throws BLException{
		
		List<IG688Info> appList = new ArrayList<IG688Info>();
		IG688SearchCondImpl cond = new IG688SearchCondImpl();		
		//业务系统
		cond.setEsyscoding("999003001");
		appList.addAll(ig013BL.searchIG688Info(cond));
		//应用资产
		cond.setEsyscoding("999003002");
		appList.addAll(ig013BL.searchIG688Info(cond));
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
	public List<ImportVersionInfo> searchImportVersionAction(
			ImportVersionSearchCond cond) {
		return importVersionBL.searchImportVersion(cond, 0, 0);
	}

	/**
	 * 新增处理
	 * 
	 * @param instance新增实例
	 * @return 新增实例
	 */
	public EiDomainDetailInfo registEiDomainDetailAction(EiDomainDetailInfo instance)
			throws BLException {
		return eiDomainDetailBL.registEiDomainDetail(instance);
	}



	/**
	 * 资产域定义信息查询处理
	 * 
	 * @param dtoIGASM20DTO
	 * @return IGASM20DTO
	 */
	public IGASM20DTO searchEiDomainDefAction(IGASM20DTO dto) throws BLException {
		log.debug("========资产域定义信息查询处理开始========");

		// 资产域定义信息查询件数取得
		int totalCount = this.eiDomainDefBL.getSearchCount(dto
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
		List<EiDomainDefInfo> eiDomainDefInfoList = this.eiDomainDefBL
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
	public IGASM20DTO initIGASM2002Action(IGASM20DTO dto) throws BLException {
		log.debug("========变更资产域定义基本信息查询处理开始========");
		IGASM2002Form form = dto.getIgasm2002Form();
		EiDomainDefInfo ei = this.eiDomainDefBL.searchEiDomainDefByPK(
				new EiDomainDefPK(form.getEiddid(),form.getVersion()));
		form.setEiddid(ei.getEiddid());//资产域定义Eidddid
		form.setName(ei.getName());//资产域定义名称
		form.setVersion(ei.getVersion());//版本号
		form.setDescription(ei.getDescription());//描述
		form.setCreatetime(ei.getCreatetime());//创建时间
		form.setUpdatetime(ei.getUpdatetime());//更新时间
		form.setFingerPrint(ei.getFingerPrint());//时间戳
		// 变更初始化模式
		form.setMode("1");
		dto.addMessage(new ActionMessage("IGCO10000.I001", "Domain基本信息"));
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
	public IGASM20DTO updateEiDomainDefAction(IGASM20DTO dto)
			throws BLException {
		log.debug("========变更资产域定义基本信息处理开始========");
		eiDomainDefBL.updateEiDomainDef(dto.getIgasm2002Form());
		dto.addMessage(new ActionMessage("IGCO10000.I005", "Domain基本信息"));
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
	public IGASM20DTO initIGASM2005Action(IGASM20DTO dto) throws BLException {
		log.debug("========显示资产域定义基本信息查询处理开始========");
		IGASM2005Form form = dto.getIgasm2005Form();
		EiDomainDefInfo ei = this.eiDomainDefBL.searchEiDomainDefByPK(new EiDomainDefPK(form.getEiddid(),form.getVersion()));
		form.setEiddid(ei.getEiddid());//资产域定义Eidddid
		form.setName(ei.getName());//资产域定义名称
		form.setVersion(ei.getVersion());//版本号
		form.setDescription(ei.getDescription());//描述
		form.setCreatetime(ei.getCreatetime());//创建时间
		form.setUpdatetime(ei.getUpdatetime());//更新时间
		form.setFingerPrint(ei.getFingerPrint());//时间戳
		dto.addMessage(new ActionMessage("IGCO10000.I001", "Domain基本信息"));
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
	public IGASM20DTO handSnapshotAction(IGASM20DTO dto) throws BLException {
		log.debug("========域手动快照生成处理开始========");
		IGASM2003Form form = dto.getIgasm2003Form();
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
			throw new BLException("IGASM2005.E001");
		}
		log.debug("========域手动快照生成处理终了========");
		return dto;
	}
	

	/**
	 * 控制台显示处理
	 * 
	 * @param dto IGASM20DTO
	 * @return IGASM20DTO
	 * @throws BLException
	 */
	public IGASM20DTO initIGASM2001Action(IGASM20DTO dto) throws BLException {
		log.debug("========控制台显示处理开始========");
		
		IGASM2001Form form = dto.getIgasm2001Form();
		
		//检索条件生成
		EiWaitTaskSearchCondImpl cond = new EiWaitTaskSearchCondImpl();
		
		if("0".equals(form.getTaskDone())) {
			cond.setTaskDone(false);//未完成
		} else if("1".equals(form.getTaskDone())) {
			cond.setTaskDone(true);//已完成
		} else {
			cond.setTaskError(true);//异常
		}
		cond.setDeleteflag_eq("0");//启用
		
		//待处理任务列表
		List<EiWaitTaskInfo> eiWaitTaskList = this.eiWaitTaskBL.searchEiWaitTask(cond);
		
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
				 List<File> files = Arrays.asList(ciFile.listFiles());
				 //将文件进行排序
				 Collections.sort(files, new Comparator<File>(){  
					      public int compare(File o1, File o2) {  
						     if(o1.isDirectory() && o2.isDirectory()){ 
						        return 0;  
						     }
						     if(o1.isDirectory() && o2.isFile()){
						    	 return -1;  
						     }
						     if(o1.isFile() && o2.isDirectory()) { 
							        return 1;  
							 }
					         long s1=o1.length();
					         long s2=o2.length();
					         if(s1==s2){
					        	 return 0;
					         }else{
					        	 return s1>s2?1:-1;
					         }
					      }  
					  });  
				 for(File file : files) {
					 //判断是否是文件
					 if(file.isFile()) {
						 fileNames.add(file.getName());
					 }
				 }
			} else {
				throw new BLException("IGASM2001.E002");
			}
		
			//导入数据列表
			ImportVersionSearchCondImpl ivCond = new ImportVersionSearchCondImpl();
			ivCond.setDeleteflag_eq("0");//启用
			List<ImportVersionInfo> importVersionList = this.importVersionBL.searchImportVersion(ivCond);
			
			//当前时间
			String createTime = IGStringUtils.getCurrentDateTime();
			
			//插入在导入数据列表中存在，并且不在待处理任务中的文件
			for(String fileName : fileNames) {
				checkCiImportFileName(fileName);//检测采集文件名是否合法
				String ciName = fileName.substring(0, fileName.lastIndexOf("_"));//顶级CI名称
				for(ImportVersionInfo iv : importVersionList) {
					if(iv.getImpeiname().equals(ciName)) {//判断顶级CI是否在导入数据表中存在
						boolean flag = true;
						for(EiWaitTaskInfo ewt : eiWaitTaskList){
							if(ewt.getEitfilename().equals(fileName)) {//判断文件是否在待处理任务中存在
								flag = false;
								break;
							}
						}
						//插入操作
						if(flag) {
							EiWaitTaskTB eiWaitTask = this.eiWaitTaskBL.getEiWaitTaskTBInstance();
							eiWaitTask.setEittopci(ciName);//顶级CI名称
							eiWaitTask.setEitfilename(fileName);//文件名
							eiWaitTask.setEitcreatetime(createTime);//任务创建时间
							eiWaitTask.setEitstatus(CMDBConstants.TASK_STATUS_WAIT);//待处理
							eiWaitTask.setImpTypeid(iv.getImpcitype());//顶级CI类型
							eiWaitTask.setEiImportProgrammeTB(iv.getEiImportProgrammeTB());//不设第一次不好使，不显示对应名称。
							this.eiWaitTaskBL.registEiWaitTask(eiWaitTask);
							log.debug("增加文件" + fileName);
						}
						break;
					}
				}
			}
			
			//查询任务列表
			dto.setEiWaitTaskList(this.eiWaitTaskBL.searchEiWaitTask(cond));
		
		} else {//已完成
			dto.setEiWaitTaskList(eiWaitTaskList);
		}
		
		log.debug("========控制台显示处理终了========");
		return dto;
	}
	
	/**
	 * 控制台任务查看处理
	 * 
	 * @param dto IGASM20DTO
	 * @return IGASM20DTO
	 * @throws BLException
	 */
	public IGASM20DTO initIGASM2010Action(IGASM20DTO dto) throws BLException {
		log.debug("========控制台任务查看处理开始========");
		
		IGASM2010Form form = dto.getIgasm2010Form();
		
		dto.setEiWaitTask(this.eiWaitTaskBL.searchEiWaitTaskByPK(form.getEitid()));
			
		log.debug("========控制台任务查看处理终了========");
		return dto;
	}
	
	/**
	 * 待处理任务删除处理
	 * 
	 * @param dto IGASM20DTO
	 * @return IGASM20DTO
	 * @throws BLException
	 */
	public IGASM20DTO deleteEiWaitTaskAction(IGASM20DTO dto) throws BLException {
		log.debug("========删除待处理任务处理开始========");
		
		IGASM2001Form form = dto.getIgasm2001Form();
		
		String[] eitids = form.getEitids();//主键
		
		//CI导入应用资源文件
		Properties properties = this.getProperties();
		
		//CI导入文件夹路径
		String ciFilePath  = properties.getProperty("CI_IMPORT_FILE_PATH");
		
		//删除任务和相应文件
		if(eitids != null) {
			for(String eitid : eitids) {
				EiWaitTaskInfo eit = this.eiWaitTaskBL.searchEiWaitTaskByPK(Integer.parseInt(eitid));
				File file = new File(ciFilePath + File.separator + eit.getEitfilename());
				if(file.exists()) {
					file.delete();
				}
				this.eiWaitTaskBL.deleteEiWaitTask(eit);
			}
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I006", "任务"));
		
		log.debug("========删除待处理任务处理终了========");
		return dto;
	}
	
	/**
	 * 检测CI采集文件名是否合法
	 * 文件名格式为：顶级CI标识+‘_’+时间戳(YYMMDDHHMI)
	 * @param fileName 文件名
	 * @throws BLException 
	 */
	private void checkCiImportFileName(String fileName) throws BLException {
		if(fileName.indexOf("_") > 0 && fileName.indexOf(".") > 0 && fileName.lastIndexOf("_") < fileName.lastIndexOf(".")
				&& fileName.substring(fileName.lastIndexOf("_") + 1, fileName.lastIndexOf(".")).length() == 10) {
		} else {
			throw new BLException("IGASM2001.E003", fileName);
		}
	}

	/**
	 * 资产域定义删除处理
	 * 
	 * @param dto
	 */
	public IGASM20DTO deleteEiDomainDefAction(IGASM20DTO dto)
			throws BLException {
		log.debug("========资产域定义信息删除处理开始========");
		// 循环删除
		for (int i = 0; i < dto.getDeleteEiddid().length; i++) {
			String key = dto.getDeleteEiddid()[i];
			String eiddid = key.split("_")[0];
//			String version = key.split("_")[1];
			List<EiDomainDefInfo> eiDomainDefInfoList=this.eiDomainDefBL.searchEiDomainDefByPK(Integer.parseInt(eiddid),null);
			// 资产域定义删除主键
			for(EiDomainDefInfo eiDomainDefInfo:eiDomainDefInfoList){
			eiDomainDefBL.deleteEiDomainDef(eiDomainDefInfo);
			}
		}
		dto.addMessage(new ActionMessage("IGASM2004.I002"));
		log.debug("========资产域定义信息删除处理终了========");
		return dto;
	}

	/**
	 * 控制台导入处理
	 * 
	 * @param dtoIGASM20DTO
	 * @return IGASM20DTO
	 * @throws BLException
	 */
	public IGASM20DTO importIGASM2001Action(IGASM20DTO dto) throws BLException {
		log.debug("========控制台导入处理开始========");
		//取得安装路径
		Properties properties = getProperties();
		String filepath = properties.getProperty("INSTALL_FILE_PATH");
		String importBatName = properties.getProperty("CI_IMPORT_BAT_NAME");
		String[] cmd = new String[10];
		cmd[0] = "cmd";
		cmd[1] = "/c";
		cmd[2] = "start";
		cmd[3] = " ";
		IGASM2001Form form = dto.getIgasm2001Form();
		String[] eitids = form.getEitids();
        //从form中得到顶级ei名的数组、导入文件名数组、实体名数组
		String batNames = null;
		String filenames = null;
		String einames = null;
		String eitidParms = null;
		for(int i =0 ;i<eitids.length;i++){
			String eitid = eitids[i];
			EiWaitTaskInfo eiWaitTaskInfo = eiWaitTaskBL.searchEiWaitTaskByPK(Integer.valueOf(eitid));
			
			//通过顶级ei名，去导入数据版本管理表中取得版本最大的那条数据的导入类型
			//通过类型，从导入程序管理表中取得批处理文件名和相对目录
			ImportVersionSearchCondImpl cond = new ImportVersionSearchCondImpl();
			cond.setImpeiname(eiWaitTaskInfo.getEittopci());
			List<ImportVersionInfo>	importVersionList = importVersionBL.searchImportVersion(cond);
			String batName = null;
			if(importVersionList.size() == 1) {
				batName = importVersionList.get(0).getEiImportProgrammeTB().getImpProgramme();
			} else {
				throw new BLException("IGCO10000.E004", eiWaitTaskInfo.getEittopci());
			}
			String filename = eiWaitTaskInfo.getEitfilename();
			String einame = eiWaitTaskInfo.getEittopci();
			if(i==0){
				batNames = batName;
				filenames = filename;
				einames = einame;
				eitidParms = eitid;
			}else{
				batNames = batNames + "!"+ batName;
				filenames = filenames + "!" + filename;
				einames = einames + "!" + einame;
				eitidParms = eitidParms + "!" + eitid;
			}
			
		}
		try {
			User user = dto.getUser();	
			
			cmd[4] = filepath + importBatName;
			cmd[5] =filenames;
			cmd[6] =batNames;
			cmd[7] =einames;
			cmd[8] =user.getUserid()+ "!" + user.getUsername();
			cmd[9] =eitidParms;
		    //调用bat文件执行
			java.lang.Runtime.getRuntime().exec(cmd);

		} catch (Exception e) {
			log.error("导入应用程序启动失败", e);
			throw new BLException("IGASM2001.E005");
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
			throw new BLException("IGASM2001.E001");
		} catch (IOException e) {
			log.error("CI导入应用资源文件读取错误", e);
			throw new BLException("IGASM2001.E001");
		} finally {
			if(inputFile != null) {
				try {
					inputFile.close();
				} catch (IOException e) {
					log.error("CI导入应用资源文件读取错误", e);
					throw new BLException("IGASM2001.E001");
				}
			}
		}
		return properties;
	}

	/**
	 * 导入对象信息登记处理
	 */
	public IGASM20DTO insertImportVersionAction(IGASM20DTO dto)
			throws BLException {
		log.debug("========导入对象信息登记处理开始========");
		// 输入Form取得
		IGASM2006Form form = dto.getIgasm2006Form();
		form.setImpversion(0);//版本号
		form.setImpeiid(0);//实体ID
		//资产模型层次码
//		if(form.getImpcitype()==1){
//			form.setEsyscoding("999001001");//主机
//		}else if(form.getImpcitype()==2){
//			form.setEsyscoding("999001009001");//磁盘阵列
//		}else if(form.getImpcitype()==3){
//			form.setEsyscoding("999003");//应用资产
//		}else if(form.getImpcitype()==4){
//			form.setEsyscoding("999001006001");//SAN交换机
//		}
		this.importVersionBL.registImportVersion(dto.getIgasm2006Form());
		// 导入对象基本信息
		dto.addMessage(new ActionMessage("IGCO10000.I004", "导入对象基本信息"));
		log.debug("========导入对象信息登记处理终了========");
		return dto;
	}

	/**
	 * 导入对象信息查询处理
	 */
	public IGASM20DTO searchImportVersionAction(IGASM20DTO dto) throws BLException {
		log.debug("========导入对象信息查询处理开始========");

		// 导入对象信息查询件数取得
		int totalCount = this.importVersionBL.getSearchCount(dto
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
		List<ImportVersionInfo> importVersionInfoList = this.importVersionBL
				.searchImportVersion(dto.getImportVersionSearchCond(), pDto
						.getFromCount(), pDto.getPageDispCount());

		pDto.setTotalCount(totalCount);

		dto.setImportVersionInfoList(importVersionInfoList);

		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));

		log.debug("========导入对象信息查询处理终了========");
		return dto;
	}
	
	/**
	 * 采集控制台查询处理
	 * @param dto IGASM20DTO
	 * @throws BLException
	 */
	public IGASM20DTO initIGASM2014Action(IGASM20DTO dto) throws BLException {
		log.debug("========采集控制台信息查询处理开始========");
		
		// 导入对象信息查询件数取得
		int totalCount = this.importVersionBL.getSearchCount(dto
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
		List<ImportVersionInfo> importVersionInfoList = this.importVersionBL
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
	public IGASM20DTO deleteImportVersionAction(IGASM20DTO dto) throws BLException {
		log.debug("========导入对象信息删除处理开始========");
		// 循环删除
		for (int i = 0; i < dto.getDeleteImpeiid().length; i++) {
			String key = dto.getDeleteImpeiid()[i];
			String impeiname = key.split("_")[0];
			String impversion = key.split("_")[1];
			// 导入对象删除主键
			importVersionBL.deleteImportVersionByPK(new ImportVersionPK(Integer.parseInt(impversion),impeiname));
		}
		dto.addMessage(new ActionMessage("IGASM2004.I002"));
		log.debug("========导入对象信息删除处理终了========");
		return dto;
	}

	/**
	 * 导入对象状态调整
	 * @param dto
	 * @throws BLException
	 */
	public void changeDeleteFlagAction(IGASM20DTO dto) throws BLException {
		log.debug("========导入对象状态变化处理开始========");
		ImportVersionInfo importVersionInfo = importVersionBL.searchImportVersionByPK(new ImportVersionPK(dto.getImpversion(),dto.getImpeiname()));
		ImportVersionTB importVersionTB = (ImportVersionTB)SerializationUtils.clone(importVersionInfo);
		if("0".equals(importVersionInfo.getDeleteflag())){
			importVersionTB.setDeleteflag("1");
		} else if ("1".equals(importVersionInfo.getDeleteflag())){
			importVersionTB.setDeleteflag("0");
		}
		importVersionBL.updateImportVersion(importVersionTB);
		log.debug("========导入对象状态变化处理结束========");
	}

	/**
	 * 导入对象类型
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGASM20DTO getEiImportProgrammeAction(IGASM20DTO dto) throws BLException {
		log.debug("========导入对象类型查询处理开始========");
		List<EiImportProgrammeInfo> impTypeInfoList=this.eiImportProgrammeBL.searchEiImportProgramme();
		List<LabelValueBean> impTypeList = new ArrayList<LabelValueBean>();
		impTypeList.add(new LabelValueBean("",""));
		for(EiImportProgrammeInfo info : impTypeInfoList){
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
	public IGASM20DTO searchImportVersionIGASM2010Action(IGASM20DTO dto)
			throws BLException {
		log.debug("========导入对象版本查询处理开始========");
		ImportVersionInfo importVersionInfo = importVersionBL.searchImportVersionByPK(new ImportVersionPK(dto.getImpversion(),dto.getImpeiname()));
		List<ImportVersionInfo> importVersionInfoList = this.importVersionBL
		.searchImportVersionByPK(dto.getImpeiname(),dto.getImpversion());
		if(importVersionInfoList==null){
			dto.addMessage(new ActionMessage("IGCO10000.E004","历史版本"));
			
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
	public IGASM20DTO searchIGASM2012Action(IGASM20DTO dto) throws BLException {
		log.debug("========资产域定义版本查询处理开始========");
		IGASM2012Form form=dto.getIgasm2012Form();
		EiDomainDefInfo eiDomainDefInfo = this.eiDomainDefBL.searchEiDomainDefByPK(new EiDomainDefPK(form.getEiddid(),form.getVersion()));
		List<EiDomainDefInfo> eiDomainDefInfoList = this.eiDomainDefBL.searchEiDomainDefByPK(form.getEiddid(),form.getVersion());
		if(eiDomainDefInfoList==null){
			dto.addMessage(new ActionMessage("IGCO10000.E004","历史版本"));
			
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
	public IGASM20DTO searchIGASM2013Action(IGASM20DTO dto) throws BLException {
		log.debug("========最新版本域信息查询处理开始========");
		List<EiDomainDefVWInfo> eiDomainDefVWInfoList=this.eiDomainDefVWBL.searchEiDomainDefVW();
		List<LabelValueBean> domainList = new ArrayList<LabelValueBean>();
		domainList.add(new LabelValueBean("",""));
		for(EiDomainDefVWInfo info : eiDomainDefVWInfoList){
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
	public IGASM20DTO searchDoaminCiInfoAction(IGASM20DTO dto)
			throws BLException {
		log.debug("========域CI查询处理开始========");
		IGASM2013Form form=dto.getIgasm2013Form();
		//版本取得
		if(StringUtils.isNotEmpty(form.getEiddid())){
		EiDomainDefVWInfo eiDomainDefVWInfo=this.eiDomainDefVWBL.searchEiDomainDefVW(form.getEiddid());
		form.setEiddversion(eiDomainDefVWInfo.getVersion().toString());
		dto.setEiDomainDetailVWSearchCond(form);
		}
		if(StringUtils.isNotEmpty(form.getEilabel())){
			if("1".equals(form.getTypeId())){
				int totalCount = this.eiDomainDetailMaxVWBL.getSearchCountCI(dto
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
				List<EiDomainDetailCIInfo> eiDomainDetailCIInfoList = this.eiDomainDetailMaxVWBL
						.searchEiDomainDetailVWCI(dto.getEiDomainDetailVWSearchCond(), pDto
								.getFromCount(), pDto.getPageDispCount());

				pDto.setTotalCount(totalCount);
				dto.setEiDomainDetailCIInfoList(eiDomainDetailCIInfoList);
				dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
			}
			if("2".equals(form.getTypeId())){
				
			}
		}else{
			if("1".equals(form.getTypeId())){
				// 域CI查询件数取得
				int totalCount = this.eiDomainDetailMaxVWBL.getSearchCount(dto
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
				List<EiDomainDetailMaxVWInfo> eiDomainDetailVWInfoList = this.eiDomainDetailMaxVWBL
						.searchEiDomainDetailVW(dto.getEiDomainDetailVWSearchCond(), pDto
								.getFromCount(), pDto.getPageDispCount());

				pDto.setTotalCount(totalCount);
				dto.setEiDomainDetailVWInfoList(eiDomainDetailVWInfoList);

				dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
			}
			if("2".equals(form.getTypeId())){
				// 域CI查询件数取得
				int totalCount = this.eiDomainDetailMaxVWBL.getSearchCount(dto
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
				List<EiDomainDetailMaxVWInfo> eiDomainDetailVWInfoList = this.eiDomainDetailMaxVWBL
						.searchEiDomainDetailVW(dto.getEiDomainDetailVWSearchCond(), pDto
								.getFromCount(), pDto.getPageDispCount());

				pDto.setTotalCount(totalCount);
				dto.setEiDomainDetailVWInfoList(eiDomainDetailVWInfoList);

				dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
			}
		}
		
		log.debug("========域CI查询处理结束========");
		return dto;
	}

}
