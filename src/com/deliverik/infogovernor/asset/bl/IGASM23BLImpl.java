/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.bl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.asset.bl.task.ImportVersionBL;
import com.deliverik.framework.asset.model.ImportVersionInfo;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.asset.dto.IGASM23DTO;

/**
 * 概述: 采集控制台业务逻辑实现
 * 功能描述: 采集控制台业务逻辑实现
 * 创建记录: 2311/04/25
 * 修改记录: 
 */
public class IGASM23BLImpl extends BaseBLImpl implements IGASM23BL {
	static Log log = LogFactory.getLog(IGASM23BLImpl.class);

	/** 导入数据版本 */
	protected ImportVersionBL importVersionBL;

	/**
	 * 导入数据版本BL设置
	 * 
	 * @param eiDomainDefBL资产域定义BL
	 */
	public void setImportVersionBL(ImportVersionBL importVersionBL) {
		this.importVersionBL = importVersionBL;
	}

	/**
	 * 采集控制台查询处理
	 * @param dto IGASM23DTO
	 * @throws BLException
	 */
	public IGASM23DTO initIGASM2301Action(IGASM23DTO dto) throws BLException {
		log.debug("========采集控制台信息查询处理开始========");
		
		// 当前页采集控制台信息取得
		List<ImportVersionInfo> importVersionInfoList = this.importVersionBL
		.searchImportVersion(dto.getImportVersionSearchCond(), 0, 0);
		
		dto.setImportVersionInfoList(importVersionInfoList);
		
		log.debug("========采集控制台信息查询处理终了========");
		return dto;
	}
	
	/**
	 * 采集处理
	 * @param dto IGASM23DTO
	 * @throws BLException
	 */
	public IGASM23DTO collectIGASM2301Action(IGASM23DTO dto) throws BLException {
		log.debug("========采集处理开始========");//取得安装路径
		String[] collectIds = dto.getCollectIds();
		if(collectIds != null) {
			Properties properties = getProperties();
			String filepath = properties.getProperty("INSTALL_FILE_PATH");
			String collectBatName = properties.getProperty("CI_COLLECT_BAT_NAME");
			StringBuffer sbf = new StringBuffer();
			for(String collectId : collectIds) {
				sbf.append(collectId).append("!");
			}
			String[] cmd = new String[6];
			cmd[0] = "cmd";
			cmd[1] = "/c";
			cmd[2] = "start";
			cmd[3] = " ";
			cmd[4] = filepath + collectBatName;
			cmd[5] = sbf.substring(0, sbf.length() - 1).toString();
			//调用bat文件执行
			try {
				java.lang.Runtime.getRuntime().exec(cmd);
			} catch (Exception e) {
				log.error("采集应用程序启动失败", e);
				throw new BLException("IGASM2301.E001");
			}
		}
		
		log.debug("========采集处理终了========");
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

}
