/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * ����: �ɼ�����̨ҵ���߼�ʵ��
 * ��������: �ɼ�����̨ҵ���߼�ʵ��
 * ������¼: 2311/04/25
 * �޸ļ�¼: 
 */
public class IGASM23BLImpl extends BaseBLImpl implements IGASM23BL {
	static Log log = LogFactory.getLog(IGASM23BLImpl.class);

	/** �������ݰ汾 */
	protected ImportVersionBL importVersionBL;

	/**
	 * �������ݰ汾BL����
	 * 
	 * @param eiDomainDefBL�ʲ�����BL
	 */
	public void setImportVersionBL(ImportVersionBL importVersionBL) {
		this.importVersionBL = importVersionBL;
	}

	/**
	 * �ɼ�����̨��ѯ����
	 * @param dto IGASM23DTO
	 * @throws BLException
	 */
	public IGASM23DTO initIGASM2301Action(IGASM23DTO dto) throws BLException {
		log.debug("========�ɼ�����̨��Ϣ��ѯ����ʼ========");
		
		// ��ǰҳ�ɼ�����̨��Ϣȡ��
		List<ImportVersionInfo> importVersionInfoList = this.importVersionBL
		.searchImportVersion(dto.getImportVersionSearchCond(), 0, 0);
		
		dto.setImportVersionInfoList(importVersionInfoList);
		
		log.debug("========�ɼ�����̨��Ϣ��ѯ��������========");
		return dto;
	}
	
	/**
	 * �ɼ�����
	 * @param dto IGASM23DTO
	 * @throws BLException
	 */
	public IGASM23DTO collectIGASM2301Action(IGASM23DTO dto) throws BLException {
		log.debug("========�ɼ�����ʼ========");//ȡ�ð�װ·��
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
			//����bat�ļ�ִ��
			try {
				java.lang.Runtime.getRuntime().exec(cmd);
			} catch (Exception e) {
				log.error("�ɼ�Ӧ�ó�������ʧ��", e);
				throw new BLException("IGASM2301.E001");
			}
		}
		
		log.debug("========�ɼ���������========");
		return dto;
	}
	
	private Properties getProperties() throws BLException {
		//CI����Ӧ����Դ�ļ�
		Properties properties = null;
		//������
		FileInputStream inputFile = null;
		//���������ļ�
		try {
			properties = new Properties();
			inputFile = new FileInputStream(ResourceUtility.getString("CI_IMPORT_FILE_PATH"));
			properties.load(inputFile);
		} catch (FileNotFoundException e) {
			log.error("CI����Ӧ����Դ�ļ���ȡ����", e);
			throw new BLException("IGASM2001.E001");
		} catch (IOException e) {
			log.error("CI����Ӧ����Դ�ļ���ȡ����", e);
			throw new BLException("IGASM2001.E001");
		} finally {
			if(inputFile != null) {
				try {
					inputFile.close();
				} catch (IOException e) {
					log.error("CI����Ӧ����Դ�ļ���ȡ����", e);
					throw new BLException("IGASM2001.E001");
				}
			}
		}
		return properties;
	}

}
