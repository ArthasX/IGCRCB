/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.bl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.asset.bl.task.AuditConfigItemBL;
import com.deliverik.framework.asset.bl.task.AuditEntityItemBL;
import com.deliverik.framework.asset.bl.task.AuditResultBL;
import com.deliverik.framework.asset.bl.task.AuditTaskBL;
import com.deliverik.framework.asset.bl.task.AuditWaitTaskBL;
import com.deliverik.framework.asset.bl.task.CMDBConstants;
import com.deliverik.framework.asset.bl.task.IG013BL;
import com.deliverik.framework.asset.bl.task.IG545BL;
import com.deliverik.framework.asset.bl.task.IG800BL;
import com.deliverik.framework.asset.bl.task.ImportVersionBL;
import com.deliverik.framework.asset.bl.task.SocImpactGraphBL;
import com.deliverik.framework.asset.model.AuditEntityItemInfo;
import com.deliverik.framework.asset.model.AuditResultInfo;
import com.deliverik.framework.asset.model.AuditTaskInfo;
import com.deliverik.framework.asset.model.AuditWaitTaskInfo;
import com.deliverik.framework.asset.model.IG002Info;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.asset.model.ImportVersionInfo;
import com.deliverik.framework.asset.model.condition.AuditEntityItemSearchCondImpl;
import com.deliverik.framework.asset.model.condition.AuditTaskSearchCondImpl;
import com.deliverik.framework.asset.model.condition.AuditWaitTaskSearchCondImpl;
import com.deliverik.framework.asset.model.condition.ImportVersionSearchCondImpl;
import com.deliverik.framework.asset.model.entity.AuditResultTB;
import com.deliverik.framework.asset.model.entity.AuditTaskTB;
import com.deliverik.framework.asset.model.entity.AuditWaitTaskTB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.bl.task.OrganizationBL;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.condition.OrganizationSearchCondImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.asset.dto.IGASM21DTO;
import com.deliverik.infogovernor.asset.form.IGASM2101Form;
import com.deliverik.infogovernor.asset.form.IGASM2102Form;
import com.deliverik.infogovernor.asset.form.IGASM2103Form;
import com.deliverik.infogovernor.asset.form.IGASM2105Form;
import com.deliverik.infogovernor.asset.form.IGASM2108Form;
import com.deliverik.infogovernor.asset.form.IGASM2109Form;

/**
 * ����: �ʲ����ҵ���߼�ʵ��
 * ��������: �ʲ����ҵ���߼�ʵ��
 * ������¼: 2111/04/25
 * �޸ļ�¼: 
 */
public class IGASM21BLImpl extends BaseBLImpl implements IGASM21BL {
	static Log log = LogFactory.getLog(IGASM21BLImpl.class);

	/** ����������ҵ���߼��ӿ� */
	protected AuditWaitTaskBL auditWaitTaskBL;
	
	/** �������ݰ汾ҵ���߼��ӿ� */
	protected ImportVersionBL importVersionBL;
	
	/** ��ƶԱȽ��ҵ���߼��ӿ� */
	protected AuditResultBL auditResultBL;
	
	/** �������ҵ���߼��ӿ� */
	protected AuditTaskBL auditTaskBL;
	
	/** ����ʲ�ҵ���߼��ӿ� */
	protected AuditEntityItemBL auditEntityItemBL;
	
	/** ����ʲ�����ҵ���߼��ӿ� */
	protected AuditConfigItemBL auditConfigItemBL;
	
	/** ��������ϢBL */
	protected IG013BL ig013BL;
	
	/** �ʲ�ȡֵ��Χ��������BL */
	protected IG545BL ig545BL;
	
	/** �ʲ�������BL */
	protected IG800BL ig800BL;
	
	/** ����BL */
	protected OrganizationBL organizationBL;
	
	/** Ӱ�췶Χ��ʾҵ���߼��ӿ� */
	protected SocImpactGraphBL socImpactGraphBL;
	
	
	
	/**
	 * Ӱ�췶Χ��ʾҵ���߼��ӿ��趨
	 * @param socImpactGraphBLӰ�췶Χ��ʾҵ���߼��ӿ�
	 */
	public void setSocImpactGraphBL(SocImpactGraphBL socImpactGraphBL) {
		this.socImpactGraphBL = socImpactGraphBL;
	}

	/**
	 * ����BL�趨
	 * @param organizationBL����BL
	 */
	public void setOrganizationBL(OrganizationBL organizationBL) {
		this.organizationBL = organizationBL;
	}

	/**
	 * �ʲ�������BL�趨
	 * @param ig800BL�ʲ�������BL 
	 */
	public void setIg800BL(IG800BL ig800BL) {
		this.ig800BL = ig800BL;
	}

	/**
	 * �ʲ�ȡֵ��Χ��������BL�趨
	 * @param Ig545BL�ʲ�ȡֵ��Χ��������BL
	 */
	public void setIg545BL(
			IG545BL ig545BL) {
		this.ig545BL = ig545BL;
	}

	/**
	 * ��������ϢBL
	 * @param ig013BL��������ϢBL
	 */
	public void setIg013BL(IG013BL ig013BL) {
		this.ig013BL = ig013BL;
	}

	/**
	 * ����ʲ�ҵ���߼��ӿ��趨
	 * @param auditEntityItemBL����ʲ�ҵ���߼��ӿ�
	 */
	public void setAuditEntityItemBL(AuditEntityItemBL auditEntityItemBL) {
		this.auditEntityItemBL = auditEntityItemBL;
	}

	/**
	 * ����ʲ�����ҵ���߼��ӿ��趨
	 * @param auditConfigItemBL����ʲ�����ҵ���߼��ӿ�
	 */
	public void setAuditConfigItemBL(AuditConfigItemBL auditConfigItemBL) {
		this.auditConfigItemBL = auditConfigItemBL;
	}

	/**
	 * �������ҵ���߼��ӿ��趨
	 * @param auditTaskBL�������ҵ���߼��ӿ�
	 */
	public void setAuditTaskBL(AuditTaskBL auditTaskBL) {
		this.auditTaskBL = auditTaskBL;
	}

	/** ��ƶԱȽ��ҵ���߼��ӿ��趨
	 * 
	 * @param auditResultBL ��ƶԱȽ��ҵ���߼��ӿ�
	 */
	public void setAuditResultBL(AuditResultBL auditResultBL) {
		this.auditResultBL = auditResultBL;
	}

	/**
	 * ����������ҵ���߼��ӿ��趨
	 * 
	 * @param auditWaitTaskBL ����������ҵ���߼��ӿ�
	 */
	public void setAuditWaitTaskBL(AuditWaitTaskBL auditWaitTaskBL) {
		this.auditWaitTaskBL = auditWaitTaskBL;
	}

	/**
	 * �������ݰ汾ҵ���߼��ӿ��趨
	 * 
	 * @param importVersionBL �������ݰ汾ҵ���߼��ӿ�
	 */
	public void setImportVersionBL(ImportVersionBL importVersionBL) {
		this.importVersionBL = importVersionBL;
	}

	/**
	 * ��ƿ���̨��ʾ����
	 * 
	 * @param dto IGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public IGASM21DTO initIGASM2101Action(IGASM21DTO dto) throws BLException {
		log.debug("========��ƿ���̨��ʾ����ʼ========");
		
		IGASM2101Form form = dto.getIgasm2101Form();
		//����Ƿ�����������
		AuditTaskSearchCondImpl atCond = new AuditTaskSearchCondImpl();
		List<AuditTaskInfo> atList = this.auditTaskBL.searchAuditTask(atCond, 0, 0);
		if(atList.isEmpty()) {
			throw new BLException("IGASM2101.E007");
		} else {
			dto.setAuditTaskInfo(atList.get(0));
		}
		
		//������������
		AuditWaitTaskSearchCondImpl cond = new AuditWaitTaskSearchCondImpl();
		
		if("0".equals(form.getTaskDone())) {
			cond.setTaskDone(false);//δ���
		} else if("1".equals(form.getTaskDone())) {
			cond.setTaskDone(true);//�����
		} else {
			cond.setTaskError(true);//�쳣
		}
		cond.setDeleteflag_eq("0");//����
		
		//�����������б�
		List<AuditWaitTaskInfo> auditWaitTaskList = this.auditWaitTaskBL.searchAuditWaitTask(cond);
		
		if("0".equals(form.getTaskDone())) {//δ���
			
			//CI����Ӧ����Դ�ļ�
			Properties properties = this.getProperties();
			//�������ļ����б�
			List<String> fileNames = new ArrayList<String>();
			//CI�����ļ���·��
			File ciFile = new File(properties.getProperty("AUDIT_CI_IMPORT_FILE_PATH"));
			//�ж��ļ����Ƿ����
			if(ciFile.exists() && ciFile.isDirectory()) {
				//��ȡ�ļ��б�
				 File[] files = ciFile.listFiles();
				 for(File file : files) {
					 //�ж��Ƿ����ļ�
					 if(file.isFile()) {
						 fileNames.add(file.getName());
					 }
				 }
			} else {
				throw new BLException("IGASM2101.E002");
			}
		
			//���������б�
			ImportVersionSearchCondImpl ivCond = new ImportVersionSearchCondImpl();
			ivCond.setDeleteflag_eq("0");//����
			List<ImportVersionInfo> importVersionList = this.importVersionBL.searchImportVersion(ivCond);
			
			//��ǰʱ��
			String createTime = IGStringUtils.getCurrentDateTime();
			
			//�����ڵ��������б��д��ڣ����Ҳ��ڴ����������е��ļ�
			for(String fileName : fileNames) {
				checkCiImportFileName(fileName);//���ɼ��ļ����Ƿ�Ϸ�
				String ciName = fileName.substring(0, fileName.lastIndexOf("_"));//����CI����
				for(ImportVersionInfo iv : importVersionList) {
					if(iv.getImpeiname().equals(ciName)) {//�ж϶���CI�Ƿ��ڵ������ݱ��д���
						boolean flag = true;
						for(AuditWaitTaskInfo ewt : auditWaitTaskList){
							if(ewt.getAuwtfilename().equals(fileName)) {//�ж��ļ��Ƿ��ڴ����������д���
								flag = false;
								break;
							}
						}
						//�������
						if(flag) {
							AuditWaitTaskTB auditWaitTask = this.auditWaitTaskBL.getAuditWaitTaskTBInstance();
							auditWaitTask.setAuwttopci(ciName);//����CI����
							auditWaitTask.setAuwtfilename(fileName);//�ļ���
							auditWaitTask.setAuwtcreatetime(createTime);//���񴴽�ʱ��
							auditWaitTask.setAuwtstatus(CMDBConstants.TASK_STATUS_WAIT);//������
							auditWaitTask.setImpTypeid(iv.getImpcitype());//����CI����
							auditWaitTask.setEiImportProgrammeTB(iv.getEiImportProgrammeTB());//�����һ�β���ʹ������ʾ��Ӧ���ơ�
							this.auditWaitTaskBL.registAuditWaitTask(auditWaitTask);
							log.debug("�����ļ�" + fileName);
						}
						break;
					}
				}
			}
			
			//��ѯ�����б�
			dto.setAuditWaitTaskList(this.auditWaitTaskBL.searchAuditWaitTask(cond));
		
		} else {//�����
			dto.setAuditWaitTaskList(auditWaitTaskList);
		}
		
		log.debug("========��ƿ���̨��ʾ��������========");
		return dto;
	}
	
	/**
	 * ����������ɾ������
	 * 
	 * @param dto IGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public IGASM21DTO deleteAuditWaitTaskAction(IGASM21DTO dto) throws BLException {
		log.debug("========ɾ��������������ʼ========");
		
		IGASM2101Form form = dto.getIgasm2101Form();
		
		String[] auwtids = form.getAuwtids();//����
		
		//CI����Ӧ����Դ�ļ�
		Properties properties = this.getProperties();
		
		//CI�����ļ���·��
		String ciFilePath  = properties.getProperty("AUDIT_CI_IMPORT_FILE_PATH");
		
		//ɾ���������Ӧ�ļ�
		if(auwtids != null) {
			for(String auwtid : auwtids) {
				AuditWaitTaskInfo eit = this.auditWaitTaskBL.searchAuditWaitTaskByPK(Integer.parseInt(auwtid));
				File file = new File(ciFilePath + File.separator + eit.getAuwtfilename());
				if(file.exists()) {
					file.delete();
				}
				this.auditWaitTaskBL.deleteAuditWaitTask(eit);
			}
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I006", "����"));
		
		log.debug("========ɾ������������������========");
		return dto;
	}
	
	/**
	 * ����̨����鿴����
	 * 
	 * @param dto IGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public IGASM21DTO initIGASM2103Action(IGASM21DTO dto) throws BLException {
		log.debug("========����̨����鿴����ʼ========");
		
		IGASM2103Form form = dto.getIgasm2103Form();
		
		dto.setAuditWaitTask(this.auditWaitTaskBL.searchAuditWaitTaskByPK(form.getAuwtid()));
			
		log.debug("========����̨����鿴��������========");
		return dto;
	}
	
	/**
	 * ���CI�ɼ��ļ����Ƿ�Ϸ�
	 * �ļ�����ʽΪ������CI��ʶ+��_��+ʱ���(YYYYMMDDHHMI)
	 * @param fileName �ļ���
	 * @throws BLException 
	 */
	private void checkCiImportFileName(String fileName) throws BLException {
		if(fileName.indexOf("_") > 0 && fileName.indexOf(".") > 0 && fileName.lastIndexOf("_") < fileName.lastIndexOf(".")
				&& fileName.substring(fileName.lastIndexOf("_") + 1, fileName.lastIndexOf(".")).length() == 10) {
		} else {
			throw new BLException("IGASM2101.E003", fileName);
		}
	}

	/**
	 * ��ƿ���̨���봦��
	 * 
	 * @param dtoIGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public IGASM21DTO importIGASM2101Action(IGASM21DTO dto) throws BLException {
		log.debug("========��ƿ���̨���봦��ʼ========");
		IGASM2101Form form = dto.getIgasm2101Form();
		String[] auwtids = form.getAuwtids();
		List<String> topCIList = new ArrayList<String>();
		List<AuditWaitTaskInfo> awtList = new ArrayList<AuditWaitTaskInfo>();
		for(int i =0 ;i<auwtids.length;i++){
			String auwtid = auwtids[i];
			awtList.add(auditWaitTaskBL.searchAuditWaitTaskByPK(Integer.valueOf(auwtid)));
			topCIList.add(awtList.get(i).getAuwttopci());
		}
		//��ͬ����CIֻ������һ��,�����ٵ���
		AuditEntityItemSearchCondImpl aeiCond = new AuditEntityItemSearchCondImpl();
		aeiCond.setTopCIList(topCIList);
		List<AuditEntityItemInfo> aeiList = this.auditEntityItemBL.searchAuditEntityItem(aeiCond);
		if(aeiList.size() > 0) {
			StringBuffer names = new StringBuffer();
			for(AuditEntityItemInfo aei : aeiList) {
				names.append(aei.getEiname()).append(",");
			}
			throw new BLException("IGASM2101.E008", names.toString().substring(0, names.length() - 1));
		}
		//ȡ�ð�װ·��
		Properties properties = getProperties();
		String filepath = properties.getProperty("INSTALL_FILE_PATH");
		String importBatName = properties.getProperty("AUDIT_CI_IMPORT_BAT_NAME");
		String[] cmd = new String[10];
		cmd[0] = "cmd";
		cmd[1] = "/c";
		cmd[2] = "start";
		cmd[3] = " ";
        //��form�еõ�����ei�������顢�����ļ������顢ʵ��������
		String batNames = null;
		String filenames = null;
		String einames = null;
		String auwtidParms = null;
		AuditWaitTaskInfo auditWaitTaskInfo = null;
		for(int i =0 ;i<auwtids.length;i++){
			String auwtid = auwtids[i];
			auditWaitTaskInfo = awtList.get(i);
			
			//ͨ������ei����ȥ�������ݰ汾�������ȡ�ð汾�����������ݵĵ�������
			//ͨ�����ͣ��ӵ������������ȡ���������ļ��������Ŀ¼
			ImportVersionSearchCondImpl cond = new ImportVersionSearchCondImpl();
			cond.setImpeiname(auditWaitTaskInfo.getAuwttopci());
			List<ImportVersionInfo>	importVersionList = importVersionBL.searchImportVersion(cond);
			String batName = null;
			if(importVersionList.size() == 1) {
				batName = importVersionList.get(0).getEiImportProgrammeTB().getImpProgrammeAudit();
			} else {
				throw new BLException("IGCO10000.E004", auditWaitTaskInfo.getAuwttopci());
			}
			String filename = auditWaitTaskInfo.getAuwtfilename();
			String einame = auditWaitTaskInfo.getAuwttopci();
			if(i==0){
				batNames = batName;
				filenames = filename;
				einames = einame;
				auwtidParms = auwtid;
			}else{
				batNames = batNames + "!"+ batName;
				filenames = filenames + "!" + filename;
				einames = einames + "!" + einame;
				auwtidParms = auwtidParms + "!" + auwtid;
			}
			
		}
		try {
			User user = dto.getUser();	
			
			cmd[4] = filepath + importBatName;
			cmd[5] =filenames;
			cmd[6] =batNames;
			cmd[7] =einames;
			cmd[8] =user.getUserid()+ "!" + user.getUsername();
			cmd[9] =auwtidParms;
		    //����bat�ļ�ִ��
			java.lang.Runtime.getRuntime().exec(cmd);

		} catch (Exception e) {
			log.error("����Ӧ�ó�������ʧ��", e);
			throw new BLException("IGASM2101.E005");
		}
		log.debug("========��ƿ���̨���봦������========");
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
			throw new BLException("IGASM2101.E001");
		} catch (IOException e) {
			log.error("CI����Ӧ����Դ�ļ���ȡ����", e);
			throw new BLException("IGASM2101.E001");
		} finally {
			if(inputFile != null) {
				try {
					inputFile.close();
				} catch (IOException e) {
					log.error("CI����Ӧ����Դ�ļ���ȡ����", e);
					throw new BLException("IGASM2101.E001");
				}
			}
		}
		return properties;
	}
	
	/**
	 * ��ƶԱȽ����ѯ����
	 * 
	 * @param dtoIGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public IGASM21DTO searchAuditResultAction(IGASM21DTO dto) throws BLException{
		
		log.debug("========��ƶԱȽ����ѯ����ʼ========");
		
		List<AuditResultInfo> auditResultList = auditResultBL.searchAuditResult(dto.getAuditResultSearchCond());
		
		dto.setAuditResultList(auditResultList);
		
		log.debug("========��ƶԱȽ����ѯ��������========");
		
		return dto;
	}
	
	/**
	 * ��ƶԱȽ�����洦��
	 * 
	 * @param dtoIGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public void updateAuditResultAction(IGASM21DTO dto) throws BLException{
		
		log.debug("========��ƶԱȽ�����洦��ʼ========");
		
		IGASM2102Form form = dto.getIgasm2102Form();
		
		// ѡ�м���
		Integer[] checkeds = form.getCheckbox(); 
		// �����ʶID����
		Integer[] aurids = form.getAurids();
		// ����˵������
		String[] auresultdesces = form.getAuresultdesces();
		
		// ����ǰ�����óɲ�����
		auditResultBL.updateAuditResultWithout(dto.getAuditResultSearchCond());
		
		if(checkeds != null && checkeds.length > 0){
			
			// ��ѡ�еļ��Ϸ���list��
			List<Integer> checkedslist = new ArrayList<Integer>();
			for(Integer checked : checkeds){
				checkedslist.add(checked);
			}
			
			// ѡ�н��Ϊ������, ��ԭֵ���ǻ�������Ա�
			if(aurids != null && aurids.length > 0){
				int i = 0;
				for(Integer aurid : aurids){
					if(checkedslist.contains(aurid)){
						// ѡ�н��Ϊ������
						AuditResultInfo ar = auditResultBL.searchAuditResultByPK(aurid);
						AuditResultTB arTB = (AuditResultTB) SerializationUtils.clone(ar);
						arTB.setAuflag(CMDBConstants.RESULT_AUFLAG_OUT);
						arTB.setAuresultdesc(auresultdesces[i]);
						auditResultBL.updateAuditResult(arTB);
					}
					i++;
				}
			}
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I010", "�ύ"));
		log.debug("========��ƶԱȽ�����洦������========");
		
	}

	/**
	 * �������ǼǴ���
	 * @param dtoIGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public IGASM21DTO insertAuditTaskAction(IGASM21DTO dto) throws BLException {
		log.debug("========���������Ϣ�ǼǴ���ʼ========");
		// ����Formȡ��
		IGASM2105Form form = dto.getIgasm2105Form();
		//�����������ɾ����ʶ�����߼�ɾ��
		AuditTaskSearchCondImpl auditTaskSearchCond=new AuditTaskSearchCondImpl();
		auditTaskSearchCond.setAutstatus_eq("0");
		List<AuditTaskInfo> auditTaskInfoList=this.auditTaskBL.searchAuditTask(auditTaskSearchCond);
		if(auditTaskInfoList!=null){
			for(AuditTaskInfo auditTaskInfo:auditTaskInfoList){
				AuditTaskTB auditTask=(AuditTaskTB)SerializationUtils.clone(auditTaskInfo);
				auditTask.setAutstatus("1");
				this.auditTaskBL.updateAuditTask(auditTask);
			}
		}
		//������ʲ����е����ݽ�������ɾ��
		this.auditEntityItemBL.deleteAuditEntityItem();
		//������ʲ����Ա��е����ݽ�������ɾ��
		this.auditConfigItemBL.deleteAuditConfigItem();
		//�������Ҫ�Ǽǵ���Ϣ
		String auttime=IGStringUtils.getCurrentDateTime();
		form.setAuttime(auttime);
		form.setAutstatus("0");
		dto.setIgasm2105Form(form);
		this.auditTaskBL.registAuditTask(dto.getIgasm2105Form());
		// ������������Ϣ
		dto.addMessage(new ActionMessage("IGCO10000.I004", "������������Ϣ"));
		log.debug("========�����������Ϣ�ǼǴ�������========");
		return dto;
	}

	/**
	 * ��������ѯ����
	 * @param dtoIGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public IGASM21DTO searchAuditTaskAction(IGASM21DTO dto) throws BLException {
		log.debug("========���������Ϣ��ѯ����ʼ========");

		// ���������Ϣ��ѯ����ȡ��
		int totalCount = this.auditTaskBL.getSearchCount(dto.getAuditTaskSearchCond());
		
		if (totalCount == 0) {
			log.debug("========���������Ϣ��ѯ���ݲ�����========");
			// ���������Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}

		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========���������Ϣ��ѯ���ݼ�������========");
			// ���������Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}

		// ��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();

		// ��ǰҳ���������Ϣȡ��
		List<AuditTaskInfo> auditTaskInfoList = this.auditTaskBL
				.searchAuditTask(dto.getAuditTaskSearchCond(), pDto
						.getFromCount(), pDto.getPageDispCount());

		pDto.setTotalCount(totalCount);

		dto.setAuditTaskInfoList(auditTaskInfoList);

		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));

		log.debug("========���������Ϣ��ѯ��������========");
		return dto;
	}

	/**
	 * ��������ѯ��������ҳ��
	 * @param dtoIGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public IGASM21DTO searchAuditTaskActionForChoose(IGASM21DTO dto) throws BLException {
		log.debug("========���������Ϣ��ѯ����ʼ========");

		// ���������Ϣ��ѯ����ȡ��
		int totalCount = this.auditTaskBL.getSearchCount(dto.getAuditTaskSearchCond());
		
		if (totalCount == 0) {
			log.debug("========���������Ϣ��ѯ���ݲ�����========");
			// ���������Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}

		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========���������Ϣ��ѯ���ݼ�������========");
			// ���������Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}

		// ��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();

		// ��ǰҳ���������Ϣȡ��
		List<AuditTaskInfo> auditTaskInfoList = this.auditTaskBL
				.searchAuditTask(dto.getAuditTaskSearchCond(), pDto
						.getFromCount(), pDto.getPageDispCount());

		pDto.setTotalCount(totalCount);

		dto.setAuditTaskInfoList(auditTaskInfoList);

		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));

		log.debug("========���������Ϣ��ѯ��������========");
		return dto;
	}

	/**
	 * ���������������ʾ
	 * @param dtoIGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public IGASM21DTO initIGASM2105Action(IGASM21DTO dto) throws BLException {
		log.debug("========���������������Ϣ��ѯ����ʼ========");
		IGASM2105Form form = dto.getIgasm2105Form();
		AuditTaskInfo auditTaskInfo=this.auditTaskBL.searchAuditTaskByPK(form.getAutid());
		form.setAutid(auditTaskInfo.getAutid());//�������ID
		form.setAutdesc(auditTaskInfo.getAutdesc());//�����������
		form.setAuttime(auditTaskInfo.getAuttime());//������񴴽�ʱ��
		form.setAutstatus(auditTaskInfo.getAutstatus());//�������ɾ����ʶ
		// �����ʼ��ģʽ
		form.setMode("1");
		dto.addMessage(new ActionMessage("IGCO10000.I001", "������������Ϣ"));
		log.debug("========���������������Ϣ��ѯ��������========");
		return dto;
	}

	/**
	 * �������������
	 * @param dtoIGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public IGASM21DTO updateAuditTaskAction(IGASM21DTO dto) throws BLException {
		log.debug("========���������������Ϣ����ʼ========");
		this.auditTaskBL.updateAuditTask(dto.getIgasm2105Form());
		dto.addMessage(new ActionMessage("IGCO10000.I005", "������������Ϣ"));
		log.debug("========���������������Ϣ��������========");
		return dto;
	}

	/**
	 * CI��ѯ����
	 * @param dtoIGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public IGASM21DTO searchEntityItemAction(IGASM21DTO dto) throws BLException {
		log.debug("========�豸��Ϣ��ѯ����ʼ========");
		
		//�豸��Ϣ��ѯ����ȡ�� 
		int totalCount = this.ig013BL.getIG688InfoSearchCount(dto.getEntityItemVWSearchCond());
		
		if (totalCount == 0) {
			log.debug("========�豸��Ϣ��ѯ���ݲ�����========");
			//�豸��Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========�豸��Ϣ��ѯ���ݼ�������========");
			//�豸��Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();

		//��ǰҳ�豸��Ϣȡ��
		List<IG688Info> entityItemVWInfoList = this.ig013BL.searchIG688Info(dto.getEntityItemVWSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setEntityItemVWInfoList(entityItemVWInfoList);

		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========�豸��Ϣ��ѯ��������========");
		return dto;
	}

	/**
	 * �豸��ϸ��Ϣ��ѯ����
	 * @param dtoIGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public IGASM21DTO initIGASM2109Action(IGASM21DTO dto) throws BLException {
		log.debug("========�豸������Ϣ�༭������ڻ�����ʼ========");
		
		IGASM2109Form form = dto.getIgasm2109Form();
		
		//�豸��Ϣ����
		IG688Info entityItemVWInfo = this.ig013BL.searchIG688InfoByKey(
				form.getEiid());
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","�豸");
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
		//�жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
		Boolean flag = this.ig013BL.checkIG688InfoDomain(dto.getUser(), entityItemVWInfo);

		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}else{
			dto.setFlag(flag);
		}
		
		
		//�豸������Ϣ��ѯ����ȡ�� 
		int totalCount = this.ig800BL.getIG002InfoSearchCount(form);
		
		if (totalCount == 0) {
			log.debug("========�豸������Ϣ��ѯ���ݲ�����========");
			//�豸������Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I007",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========�豸������Ϣ��ѯ���ݼ�������========");
			//�豸������Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//������������Ϣȫ����ѯ
		List<IG002Info> configItemVWInfoList = this.ig800BL.searchIG002Info(
				form, 0, 0);
		
		String[] civalue = new String[totalCount];
		String[] entityItemCivalue = new String[totalCount];
		//��žɰ汾ֵ
		String[] civalue_bak = new String[totalCount];
		Map<String,List<IG002Info>> map = new LinkedHashMap<String,List<IG002Info>>();
		int i = 0;
		int j = 0;
		List<String> strlist = new ArrayList<String>();
		for(IG002Info e : configItemVWInfoList){
			if(!map.containsKey(e.getCcategory())){
				map.put(e.getCcategory(), new ArrayList<IG002Info>());
				strlist.add(e.getCcategory());
			}
			map.get(e.getCcategory()).add(e);
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
		for(String str : strlist){
			for(IG002Info e : map.get(str)){
				//��ʾ���ʲ����ƣ�ʵ�ʴ�ֵ���ʲ�����(�ʲ�ID)
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
		
		
		//��ȡ��ʷ�汾����ʱ��
		if(entityItemVWInfo.getEiversion() > 0) {
			dto.setConfigItemVersionTime(this.ig013BL.searchVersionUpdateTime(entityItemVWInfo.getEiid()));
		}

		
		log.debug("========�豸������Ϣ�༭������ڻ���������========");
		return dto;
	}

	/**
	 * �豸Ӱ�췶Χ��ѯ����
	 * @param dtoIGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public IGASM21DTO initIGASM2108Action(IGASM21DTO dto) throws BLException {
		log.debug("========�豸Ӱ�췶������ڻ�����ʼ========");
		
		IGASM2108Form form = dto.getIgasm2108Form();
		
		IG688Info ei = this.ig013BL.searchIG688InfoByKey(Integer.parseInt(form.getEiid()));
		
		//�жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
		Boolean flag = this.ig013BL.checkIG688InfoDomain(dto.getUser(), ei);
		
		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			form.setFlag(flag);
			return dto;
		}else{
			form.setFlag(flag);
		}
		
//		Map<String,List<EntityItemEntityVWInfo>> entityItemEntityVWInfoMap=this.socImpactGraphBL.searchTopCI(ei);
//
//		dto.setEntityItemVWInfoMap(entityItemEntityVWInfoMap);
		
		log.debug("========�豸Ӱ�췶������ڻ���������========");
		return dto;
	}

	/**
	 * ��ƿ���̨�Աȴ���
	 * 
	 * @param dtoIGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public IGASM21DTO compareIGASM2101Action(IGASM21DTO dto) throws BLException {
		log.debug("========��ƿ���̨�Աȴ���ʼ========");
		
		//���ʵ�����������Ҫ�ڿ���̨��ʾ���ݻ�δ���е������Ϣ
		int count = this.auditEntityItemBL.getSearchCount(new AuditEntityItemSearchCondImpl());
		if(count == 0) {
			throw new BLException("IGASM2101.E009");
		}

		//ȡ�ð�װ·��
		Properties properties = getProperties();
		String filepath = properties.getProperty("INSTALL_FILE_PATH");
		String importBatName = properties.getProperty("AUDIT_COMPARE_BAT_NAME");
		String[] cmd = new String[6];
		cmd[0] = "cmd";
		cmd[1] = "/c";
		cmd[2] = "start";
		cmd[3] = " ";
		try {
			cmd[4] = filepath + importBatName;
			cmd[5] = dto.getIgasm2101Form().getAutid().toString();
		    //����bat�ļ�ִ��
			java.lang.Runtime.getRuntime().exec(cmd);

		} catch (IOException e) {
			log.error("�Ա�Ӧ�ó�������ʧ��", e);
			throw new BLException("IGASM2101.E005");
		}
		log.debug("========��ƿ���̨�Աȴ�������========");
		return dto;
	
	}
	
	/**
	 * �ʲ����´���
	 * 
	 * @param dtoIGASM21DTO
	 * @return IGASM21DTO
	 * @throws BLException
	 */
	public IGASM21DTO updateEntityAction(IGASM21DTO dto) throws BLException{
		log.debug("========�ʲ����´���ʼ========");

		//ȡ�ð�װ·��
		Properties properties = getProperties();
		String filepath = properties.getProperty("INSTALL_FILE_PATH");
		String importBatName = properties.getProperty("AUDIT_UPDATE_BAT_NAME");
		String[] cmd = new String[6];
		cmd[0] = "cmd";
		cmd[1] = "/c";
		cmd[2] = "start";
		cmd[3] = " ";
		try {
			cmd[4] = filepath + importBatName;
			cmd[5] = dto.getIgasm2102Form().getAutid().toString();
		    //����bat�ļ�ִ��
			java.lang.Runtime.getRuntime().exec(cmd);

		} catch (IOException e) {
			log.error("����Ӧ�ó�������ʧ��", e);
			throw new BLException("IGASM2102.E003");
		}
		
//		rootMarkUpdateAction(dto);
		
		log.debug("========�ʲ����´�������========");
		return dto;
	
	
	}


//	
//	/**
//	 * ��������CI(���ù�ϵ������bat)
//	 * 
//	 * @param dtoIGASM21DTO
//	 * @return IGASM21DTO
//	 * @throws BLException
//	 */
//	public IGASM21DTO rootMarkUpdateAction(IGASM21DTO dto) throws BLException{
//		
//		String eirootmarks = "";// ����CI��ID�ַ���
//		String einames = "";// ����CI�����ַ���
//
//		// ��ȡ����CI���Ƽ���
//		Map<Integer, String> map = dto.getICNameMap();
//		if(map != null && map.size() > 0){
//			Iterator<Integer> iter = map.keySet().iterator();
//			while(iter.hasNext()){
//				Integer eirootmark = iter.next();
//				eirootmarks += "!" + String.valueOf(eirootmark);
//				einames += "!" + map.get(eirootmark);
//			}
//		}else{
//			// �����ڶ���CI
//			throw new BLException("IGASM2102.E001");
//		}
//		
//		if(StringUtils.isNotEmpty(eirootmarks)){
//			eirootmarks = eirootmarks.substring(2, eirootmarks.length());
//			einames = einames.substring(2, einames.length());
//		}
//
//		//ȡ�ð�װ·��
//		Properties properties = getProperties();
//		String filepath = properties.getProperty("INSTALL_FILE_PATH");
//		String updateBatName = properties.getProperty("ROOTMARK_UPDATE_BAT_NAME");
//		String[] cmd = new String[7];
//		cmd[0] = "cmd";
//		cmd[1] = "/c";
//		cmd[2] = "start";
//		cmd[3] = " ";
//		try {
//			cmd[4] = filepath + updateBatName;
//			cmd[5] = eirootmarks;
//			cmd[6] = einames;
//		    //����bat�ļ�ִ��
//			java.lang.Runtime.getRuntime().exec(cmd);
//
//		} catch (IOException e) {
//			log.error("����CIӦ�ó�������ʧ��", e);
//			throw new BLException("IGASM2102.E002");
//		}
//		
//		return dto;
//	}
}
