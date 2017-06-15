/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.bl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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

import com.deliverik.framework.asset.bl.task.CIConfigItemBL;
import com.deliverik.framework.asset.bl.task.CIEntityItemBL;
import com.deliverik.framework.asset.bl.task.CIResultBL;
import com.deliverik.framework.asset.bl.task.CITaskBL;
import com.deliverik.framework.asset.bl.task.CIWaitTaskBL;
import com.deliverik.framework.asset.bl.task.CMDBConstants;
import com.deliverik.framework.asset.bl.task.IG013BL;
import com.deliverik.framework.asset.bl.task.IG545BL;
import com.deliverik.framework.asset.bl.task.IG800BL;
import com.deliverik.framework.asset.bl.task.ImportVersionBL;
import com.deliverik.framework.asset.bl.task.SocImpactGraphBL;
import com.deliverik.framework.asset.model.CIConfigItemInfo;
import com.deliverik.framework.asset.model.CIEntityItemInfo;
import com.deliverik.framework.asset.model.CIResultInfo;
import com.deliverik.framework.asset.model.CITaskInfo;
import com.deliverik.framework.asset.model.CIWaitTaskInfo;
import com.deliverik.framework.asset.model.IG002Info;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.asset.model.ImportVersionInfo;
import com.deliverik.framework.asset.model.condition.CIEntityItemSearchCondImpl;
import com.deliverik.framework.asset.model.condition.CITaskSearchCondImpl;
import com.deliverik.framework.asset.model.condition.CIWaitTaskSearchCondImpl;
import com.deliverik.framework.asset.model.condition.ImportVersionSearchCondImpl;
import com.deliverik.framework.asset.model.entity.CIResultTB;
import com.deliverik.framework.asset.model.entity.CITaskTB;
import com.deliverik.framework.asset.model.entity.CIWaitTaskTB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.bl.task.OrganizationBL;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.condition.OrganizationSearchCondImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.asset.dto.IGASM22DTO;
import com.deliverik.infogovernor.asset.form.IGASM2201Form;
import com.deliverik.infogovernor.asset.form.IGASM2202Form;
import com.deliverik.infogovernor.asset.form.IGASM2203Form;
import com.deliverik.infogovernor.asset.form.IGASM2205Form;
import com.deliverik.infogovernor.asset.form.IGASM2208Form;
import com.deliverik.infogovernor.asset.form.IGASM2209Form;

/**
 * ����: �ʲ�CI���ҵ���߼�ʵ��
 * ��������: �ʲ�CI���ҵ���߼�ʵ��
 * ������¼: 2211/04/25
 * �޸ļ�¼: 
 */
public class IGASM22BLImpl extends BaseBLImpl implements IGASM22BL {
	static Log log = LogFactory.getLog(IGASM22BLImpl.class);

	/** ����������ҵ���߼��ӿ� */
	protected CIWaitTaskBL ciWaitTaskBL;
	
	/** �������ݰ汾ҵ���߼��ӿ� */
	protected ImportVersionBL importVersionBL;
	
	/** CI����ԱȽ��ҵ���߼��ӿ� */
	protected CIResultBL ciResultBL;
	
	/** CI�������ҵ���߼��ӿ� */
	protected CITaskBL ciTaskBL;
	
	/** CI����ʲ�ҵ���߼��ӿ� */
	protected CIEntityItemBL ciEntityItemBL;
	
	/** CI����ʲ�����ҵ���߼��ӿ� */
	protected CIConfigItemBL ciConfigItemBL;
	
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
	 * CI����ʲ�ҵ���߼��ӿ��趨
	 * @param ciEntityItemBLCI����ʲ�ҵ���߼��ӿ�
	 */
	public void setCiEntityItemBL(CIEntityItemBL ciEntityItemBL) {
		this.ciEntityItemBL = ciEntityItemBL;
	}

	/**
	 * CI����ʲ�����ҵ���߼��ӿ��趨
	 * @param ciConfigItemBLCI����ʲ�����ҵ���߼��ӿ�
	 */
	public void setCiConfigItemBL(CIConfigItemBL ciConfigItemBL) {
		this.ciConfigItemBL = ciConfigItemBL;
	}

	/**
	 * CI�������ҵ���߼��ӿ��趨
	 * @param ciTaskBLCI�������ҵ���߼��ӿ�
	 */
	public void setCiTaskBL(CITaskBL ciTaskBL) {
		this.ciTaskBL = ciTaskBL;
	}

	/** CI����ԱȽ��ҵ���߼��ӿ��趨
	 * 
	 * @param ciResultBL CI����ԱȽ��ҵ���߼��ӿ�
	 */
	public void setCiResultBL(CIResultBL ciResultBL) {
		this.ciResultBL = ciResultBL;
	}

	/**
	 * ����������ҵ���߼��ӿ��趨
	 * 
	 * @param ciWaitTaskBL ����������ҵ���߼��ӿ�
	 */
	public void setCiWaitTaskBL(CIWaitTaskBL ciWaitTaskBL) {
		this.ciWaitTaskBL = ciWaitTaskBL;
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
	 * CI�������̨��ʾ����
	 * 
	 * @param dto IGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public IGASM22DTO initIGASM2201Action(IGASM22DTO dto) throws BLException {
		log.debug("========CI�������̨��ʾ����ʼ========");
		
		IGASM2201Form form = dto.getIgasm2201Form();
		
		//����Ƿ�����������
		CITaskSearchCondImpl citCond = new CITaskSearchCondImpl();
		List<CITaskInfo> citList = this.ciTaskBL.searchCITask(citCond, 0, 0);
		if(citList.isEmpty()) {
			throw new BLException("IGASM2201.E007");
		} else {
			dto.setCiTaskInfo(citList.get(0));
		}
		
		//������������
		CIWaitTaskSearchCondImpl cond = new CIWaitTaskSearchCondImpl();
		
		if("0".equals(form.getTaskDone())) {
			cond.setTaskDone(false);//δ���
		} else if("1".equals(form.getTaskDone())) {
			cond.setTaskDone(true);//�����
		} else {
			cond.setTaskError(true);//�쳣
		}
		cond.setDeleteflag_eq("0");//����
		
		//�����������б�
		List<CIWaitTaskInfo> ciWaitTaskList = this.ciWaitTaskBL.searchCIWaitTask(cond);
		
		if("0".equals(form.getTaskDone())) {//δ���
			
			//CI����Ӧ����Դ�ļ�
			Properties properties = this.getProperties();
			//�������ļ����б�
			List<String> fileNames = new ArrayList<String>();
			//CI�����ļ���·��
			File ciFile = new File(properties.getProperty("UPDATE_CI_IMPORT_FILE_PATH"));
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
				throw new BLException("IGASM2201.E002");
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
						for(CIWaitTaskInfo ewt : ciWaitTaskList){
							if(ewt.getCiwtfilename().equals(fileName)) {//�ж��ļ��Ƿ��ڴ����������д���
								flag = false;
								break;
							}
						}
						//�������
						if(flag) {
							CIWaitTaskTB ciWaitTask = this.ciWaitTaskBL.getCIWaitTaskTBInstance();
							ciWaitTask.setCiwttopci(ciName);//����CI����
							ciWaitTask.setCiwtfilename(fileName);//�ļ���
							ciWaitTask.setCiwtcreatetime(createTime);//���񴴽�ʱ��
							ciWaitTask.setCiwtstatus(CMDBConstants.TASK_STATUS_WAIT);//������
							ciWaitTask.setImpTypeid(iv.getImpcitype());//����CI����
							ciWaitTask.setEiImportProgrammeTB(iv.getEiImportProgrammeTB());//�����һ�β���ʹ������ʾ��Ӧ���ơ�
							this.ciWaitTaskBL.registCIWaitTask(ciWaitTask);
							log.debug("�����ļ�" + fileName);
						}
						break;
					}
				}
			}
			
			//��ѯ�����б�
			dto.setCiWaitTaskList(this.ciWaitTaskBL.searchCIWaitTask(cond));
		
		} else {//�����
			dto.setCiWaitTaskList(ciWaitTaskList);
		}
		
		log.debug("========CI�������̨��ʾ��������========");
		return dto;
	}
	
	/**
	 * ����������ɾ������
	 * 
	 * @param dto IGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public IGASM22DTO deleteCIWaitTaskAction(IGASM22DTO dto) throws BLException {
		log.debug("========ɾ��������������ʼ========");
		
		IGASM2201Form form = dto.getIgasm2201Form();
		
		String[] ciwtids = form.getCiwtids();//����
		
		//CI����Ӧ����Դ�ļ�
		Properties properties = this.getProperties();
		
		//CI�����ļ���·��
		String ciFilePath  = properties.getProperty("CI_UPDATE_IMPORT_FILE_PATH");
		
		//ɾ���������Ӧ�ļ�
		if(ciwtids != null) {
			for(String ciwtid : ciwtids) {
				CIWaitTaskInfo eit = this.ciWaitTaskBL.searchCIWaitTaskByPK(Integer.parseInt(ciwtid));
				File file = new File(ciFilePath + File.separator + eit.getCiwtfilename());
				if(file.exists()) {
					file.delete();
				}
				this.ciWaitTaskBL.deleteCIWaitTask(eit);
			}
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I006", "����"));
		
		log.debug("========ɾ������������������========");
		return dto;
	}
	
	/**
	 * ����̨����鿴����
	 * 
	 * @param dto IGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public IGASM22DTO initIGASM2203Action(IGASM22DTO dto) throws BLException {
		log.debug("========����̨����鿴����ʼ========");
		
		IGASM2203Form form = dto.getIgasm2203Form();
		
		dto.setCiWaitTask(this.ciWaitTaskBL.searchCIWaitTaskByPK(form.getCiwtid()));
			
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
			throw new BLException("IGASM2201.E003", fileName);
		}
	}

	/**
	 * CI�������̨���봦��
	 * 
	 * @param dtoIGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public IGASM22DTO importIGASM2201Action(IGASM22DTO dto) throws BLException {
		log.debug("========CI�������̨���봦��ʼ========");
		IGASM2201Form form = dto.getIgasm2201Form();
		String[] ciwtids = form.getCiwtids();
		List<String> topCIList = new ArrayList<String>();
		List<CIWaitTaskInfo> ciwtList = new ArrayList<CIWaitTaskInfo>();
		for(int i =0 ;i<ciwtids.length;i++){
			String auwtid = ciwtids[i];
			ciwtList.add(ciWaitTaskBL.searchCIWaitTaskByPK(Integer.valueOf(auwtid)));
			topCIList.add(ciwtList.get(i).getCiwttopci());
		}
		//��ͬ����CIֻ������һ��,�����ٵ���
		CIEntityItemSearchCondImpl cieiCond = new CIEntityItemSearchCondImpl();
		cieiCond.setTopCIList(topCIList);
		List<CIEntityItemInfo> aeiList = this.ciEntityItemBL.searchCIEntityItem(cieiCond);
		if(aeiList.size() > 0) {
			StringBuffer names = new StringBuffer();
			for(CIEntityItemInfo aei : aeiList) {
				names.append(aei.getEiname()).append(",");
			}
			throw new BLException("IGASM2201.E008", names.toString().substring(0, names.length() - 1));
		}
		
		//ȡ�ð�װ·��
		Properties properties = getProperties();
		String filepath = properties.getProperty("INSTALL_FILE_PATH");
		String importBatName = properties.getProperty("UPDATE_CI_IMPORT_BAT_NAME");
		String[] cmd = new String[10];
		cmd[0] = "cmd";
		cmd[1] = "/c";
		cmd[2] = "start";
		cmd[3] = " ";
        //��form�еõ�����ei�������顢�����ļ������顢ʵ��������
		String batNames = null;
		String filenames = null;
		String einames = null;
		String ciwtidParms = null;
		CIWaitTaskInfo ciWaitTaskInfo = null;
		for(int i =0 ;i<ciwtids.length;i++){
			String ciwtid = ciwtids[i];
			ciWaitTaskInfo = ciwtList.get(i);
			
			//ͨ������ei����ȥ�������ݰ汾�������ȡ�ð汾�����������ݵĵ�������
			//ͨ�����ͣ��ӵ������������ȡ���������ļ��������Ŀ¼
			ImportVersionSearchCondImpl cond = new ImportVersionSearchCondImpl();
			cond.setImpeiname(ciWaitTaskInfo.getCiwttopci());
			List<ImportVersionInfo>	importVersionList = importVersionBL.searchImportVersion(cond);
			String batName = null;
			if(importVersionList.size() == 1) {
				batName = importVersionList.get(0).getEiImportProgrammeTB().getImpProgrammeUpdate();
			} else {
				throw new BLException("IGCO10000.E004", ciWaitTaskInfo.getCiwttopci());
			}
			String filename = ciWaitTaskInfo.getCiwtfilename();
			String einame = ciWaitTaskInfo.getCiwttopci();
			if(i==0){
				batNames = batName;
				filenames = filename;
				einames = einame;
				ciwtidParms = ciwtid;
			}else{
				batNames = batNames + "!"+ batName;
				filenames = filenames + "!" + filename;
				einames = einames + "!" + einame;
				ciwtidParms = ciwtidParms + "!" + ciwtid;
			}
			
		}
		try {
			User user = dto.getUser();	
			
			cmd[4] = filepath + importBatName;
			cmd[5] =filenames;
			cmd[6] =batNames;
			cmd[7] =einames;
			cmd[8] =user.getUserid()+ "!" + user.getUsername();
			cmd[9] =ciwtidParms;
		    //����bat�ļ�ִ��
			java.lang.Runtime.getRuntime().exec(cmd);

		} catch (Exception e) {
			log.error("����Ӧ�ó�������ʧ��", e);
			throw new BLException("IGASM2201.E005");
		}
		log.debug("========CI�������̨���봦������========");
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
			throw new BLException("IGASM2201.E001");
		} catch (IOException e) {
			log.error("CI����Ӧ����Դ�ļ���ȡ����", e);
			throw new BLException("IGASM2201.E001");
		} finally {
			if(inputFile != null) {
				try {
					inputFile.close();
				} catch (IOException e) {
					log.error("CI����Ӧ����Դ�ļ���ȡ����", e);
					throw new BLException("IGASM2201.E001");
				}
			}
		}
		return properties;
	}
	
	/**
	 * CI����ԱȽ����ѯ����
	 * 
	 * @param dtoIGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public IGASM22DTO searchCIResultAction(IGASM22DTO dto) throws BLException{
		
		log.debug("========CI����ԱȽ����ѯ����ʼ========");
		
		List<CIResultInfo> ciResultList = ciResultBL.searchCIResult(dto.getCiResultSearchCond());
		
		dto.setCiResultList(ciResultList);
		
		log.debug("========CI����ԱȽ����ѯ��������========");
		
		return dto;
	}
	
	/**
	 * CI����ԱȽ�����洦��
	 * 
	 * @param dtoIGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public void updateCIResultAction(IGASM22DTO dto) throws BLException{
		
		log.debug("========CI����ԱȽ�����洦��ʼ========");
		
		IGASM2202Form form = dto.getIgasm2202Form();
		
		// ѡ�м���
		Integer[] checkeds = form.getCheckbox(); 
		// �����ʶID����
		Integer[] cirids = form.getCirids();
		// ����˵������
		String[] ciresultdesces = form.getCiresultdesces();
		
		// ����ǰ�����óɲ�����
		ciResultBL.updateCIResultWithout(dto.getCiResultSearchCond());
		
		if(checkeds != null && checkeds.length > 0){
			
			// ��ѡ�еļ��Ϸ���list��
			List<Integer> checkedslist = new ArrayList<Integer>();
			for(Integer checked : checkeds){
				checkedslist.add(checked);
			}
			
			// ѡ�н��Ϊ������, ��ԭֵ���ǻ�CI������Ա�
			if(cirids != null && cirids.length > 0){
				int i = 0;
				for(Integer cirid : cirids){
					if(checkedslist.contains(cirid)){
						// ѡ�н��Ϊ������
						CIResultInfo ar = ciResultBL.searchCIResultByPK(cirid);
						CIResultTB arTB = (CIResultTB) SerializationUtils.clone(ar);
						arTB.setCiflag(CMDBConstants.RESULT_AUFLAG_OUT);
						arTB.setCiresultdesc(ciresultdesces[i]);
						ciResultBL.updateCIResult(arTB);
					}
					i++;
				}
			}
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I010", "�ύ"));
		log.debug("========CI����ԱȽ�����洦������========");
		
	}

	/**
	 * CI�������ǼǴ���
	 * @param dtoIGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public IGASM22DTO insertCITaskAction(IGASM22DTO dto) throws BLException {
		log.debug("========CI���������Ϣ�ǼǴ���ʼ========");
		// ����Formȡ��
		IGASM2205Form form = dto.getIgasm2205Form();
		//����CI�������ɾ����ʶ�����߼�ɾ��
		CITaskSearchCondImpl ciTaskSearchCond=new CITaskSearchCondImpl();
		ciTaskSearchCond.setCitstatus_eq("0");
		List<CITaskInfo> ciTaskInfoList=this.ciTaskBL.searchCITask(ciTaskSearchCond);
		if(ciTaskInfoList!=null){
			for(CITaskInfo ciTaskInfo:ciTaskInfoList){
				CITaskTB ciTask=(CITaskTB)SerializationUtils.clone(ciTaskInfo);
				ciTask.setCitstatus("1");
				this.ciTaskBL.updateCITask(ciTask);
			}
		}
		//��CI����ʲ����е����ݽ�������ɾ��
		List<CIEntityItemInfo> ciEntityItemInfoList=this.ciEntityItemBL.searchCIEntityItem();
		if(ciEntityItemInfoList!=null){
			for(CIEntityItemInfo ciEntityItemInfo:ciEntityItemInfoList){
				this.ciEntityItemBL.deleteCIEntityItem(ciEntityItemInfo);
			}
		}
		//��CI����ʲ����Ա��е����ݽ�������ɾ��
		List<CIConfigItemInfo> ciConfigItemInfoList=this.ciConfigItemBL.searchCIConfigItem();
		if(ciConfigItemInfoList!=null){
			for(CIConfigItemInfo ciConfigItemInfo:ciConfigItemInfoList){
				this.ciConfigItemBL.deleteCIConfigItem(ciConfigItemInfo);
			}
		}
		//CI�������Ҫ�Ǽǵ���Ϣ
		String cittime=IGStringUtils.getCurrentDateTime();
		form.setCittime(cittime);
		form.setCitstatus("0");
		dto.setIgasm2205Form(form);
		this.ciTaskBL.registCITask(dto.getIgasm2205Form());
		// CI������������Ϣ
		dto.addMessage(new ActionMessage("IGCO10000.I004", "CI�������������Ϣ"));
		log.debug("========��CI���������Ϣ�ǼǴ�������========");
		return dto;
	}

	/**
	 * CI��������ѯ����
	 * @param dtoIGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public IGASM22DTO searchCITaskAction(IGASM22DTO dto) throws BLException {
		log.debug("========CI���������Ϣ��ѯ����ʼ========");

		// CI���������Ϣ��ѯ����ȡ��
		int totalCount = this.ciTaskBL.getSearchCount(dto.getCiTaskSearchCond());
		
		if (totalCount == 0) {
			log.debug("========CI���������Ϣ��ѯ���ݲ�����========");
			// CI���������Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}

		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========CI���������Ϣ��ѯ���ݼ�������========");
			// CI���������Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}

		// ��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();

		// ��ǰҳCI���������Ϣȡ��
		List<CITaskInfo> ciTaskInfoList = this.ciTaskBL
				.searchCITask(dto.getCiTaskSearchCond(), pDto
						.getFromCount(), pDto.getPageDispCount());

		pDto.setTotalCount(totalCount);

		dto.setCiTaskInfoList(ciTaskInfoList);

		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));

		log.debug("========CI���������Ϣ��ѯ��������========");
		return dto;
	}

	/**
	 * CI���������������ʾ
	 * @param dtoIGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public IGASM22DTO initIGASM2205Action(IGASM22DTO dto) throws BLException {
		log.debug("========���CI������������Ϣ��ѯ����ʼ========");
		IGASM2205Form form = dto.getIgasm2205Form();
		CITaskInfo ciTaskInfo=this.ciTaskBL.searchCITaskByPK(form.getCitid());
		form.setCitid(ciTaskInfo.getCitid());//CI�������ID
		form.setCitdesc(ciTaskInfo.getCitdesc());//CI�����������
		form.setCittime(ciTaskInfo.getCittime());//CI������񴴽�ʱ��
		form.setCitstatus(ciTaskInfo.getCitstatus());//CI�������ɾ����ʶ
		// �����ʼ��ģʽ
		form.setMode("1");
		dto.addMessage(new ActionMessage("IGCO10000.I001", "CI�������������Ϣ"));
		log.debug("========���CI������������Ϣ��ѯ��������========");
		return dto;
	}

	/**
	 * CI�������������
	 * @param dtoIGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public IGASM22DTO updateCITaskAction(IGASM22DTO dto) throws BLException {
		log.debug("========���CI������������Ϣ����ʼ========");
		this.ciTaskBL.updateCITask(dto.getIgasm2205Form());
		dto.addMessage(new ActionMessage("IGCO10000.I005","CI�������������Ϣ"));
		log.debug("========���CI������������Ϣ��������========");
		return dto;
	}

	/**
	 * CI��ѯ����
	 * @param dtoIGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public IGASM22DTO searchEntityItemAction(IGASM22DTO dto) throws BLException {
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
	 * @param dtoIGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public IGASM22DTO initIGASM2209Action(IGASM22DTO dto) throws BLException {
		log.debug("========�豸������Ϣ�༭������ڻ�����ʼ========");
		
		IGASM2209Form form = dto.getIgasm2209Form();
		
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
	 * @param dtoIGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public IGASM22DTO initIGASM2208Action(IGASM22DTO dto) throws BLException {
		log.debug("========�豸Ӱ�췶������ڻ�����ʼ========");
		
		IGASM2208Form form = dto.getIgasm2208Form();
		
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
	 * CI�������̨�Աȴ���
	 * 
	 * @param dtoIGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public IGASM22DTO compareIGASM2201Action(IGASM22DTO dto) throws BLException {
		log.debug("========CI�������̨�Աȴ���ʼ========");
		
		//����ʵ�����������Ҫ�ڿ���̨��ʾ���ݻ�δ���е������Ϣ
		int count = this.ciEntityItemBL.getSearchCount(new CIEntityItemSearchCondImpl());
		if(count == 0) {
			throw new BLException("IGASM2201.E009");
		}

		//ȡ�ð�װ·��
		Properties properties = getProperties();
		String filepath = properties.getProperty("INSTALL_FILE_PATH");
		String importBatName = properties.getProperty("UPDATE_CI_COMPARE_BAT_NAME");
		String[] cmd = new String[5];
		cmd[0] = "cmd";
		cmd[1] = "/c";
		cmd[2] = "start";
		cmd[3] = " ";
		try {
			cmd[4] = filepath + importBatName;
		    //����bat�ļ�ִ��
			java.lang.Runtime.getRuntime().exec(cmd);

		} catch (IOException e) {
			log.error("�Ա�Ӧ�ó�������ʧ��", e);
			throw new BLException("IGASM2201.E005");
		}
		log.debug("========CI�������̨�Աȴ�������========");
		return dto;
	
	}
	
	/**
	 * �ʲ����´���
	 * 
	 * @param dtoIGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public IGASM22DTO updateEntityAction(IGASM22DTO dto) throws BLException{
		log.debug("========�ʲ����´���ʼ========");

		//ȡ�ð�װ·��
		Properties properties = getProperties();
		String filepath = properties.getProperty("INSTALL_FILE_PATH");
		String importBatName = properties.getProperty("UPDATE_CI_UPDATE_BAT_NAME");
		String[] cmd = new String[5];
		cmd[0] = "cmd";
		cmd[1] = "/c";
		cmd[2] = "start";
		cmd[3] = " ";
		try {
			cmd[4] = filepath + importBatName;
		    //����bat�ļ�ִ��
			java.lang.Runtime.getRuntime().exec(cmd);

		} catch (IOException e) {
			log.error("����Ӧ�ó�������ʧ��", e);
			throw new BLException("IGASM2202.E003");
		}
		log.debug("========�ʲ����´�������========");
		return dto;
	
	}

	
	/**
	 * ��������CI(���ù�ϵ������bat)
	 * 
	 * @param dtoIGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public IGASM22DTO rootMarkUpdateAction(IGASM22DTO dto) throws BLException{
		
		String eirootmarks = "";// ����CI��ID�ַ���
		String einames = "";// ����CI�����ַ���

		// ��ȡ����CI���Ƽ���
		Map<Integer, String> map = dto.getICNameMap();
		if(map != null && map.size() > 0){
			Iterator<Integer> iter = map.keySet().iterator();
			while(iter.hasNext()){
				Integer eirootmark = iter.next();
				eirootmarks += "!" + String.valueOf(eirootmark);
				einames += "!" + map.get(eirootmark);
			}
		}else{
			// �����ڶ���CI
			throw new BLException("IGASM2202.E001");
		}
		
		if(StringUtils.isNotEmpty(eirootmarks)){
			eirootmarks = eirootmarks.substring(2, eirootmarks.length());
			einames = einames.substring(2, einames.length());
		}

		//ȡ�ð�װ·��
		Properties properties = getProperties();
		String filepath = properties.getProperty("INSTALL_FILE_PATH");
		String updateBatName = properties.getProperty("ROOTMARK_UPDATE_BAT_NAME");
		String[] cmd = new String[7];
		cmd[0] = "cmd";
		cmd[1] = "/c";
		cmd[2] = "start";
		cmd[3] = " ";
		try {
			cmd[4] = filepath + updateBatName;
			cmd[5] = eirootmarks;
			cmd[6] = einames;
		    //����bat�ļ�ִ��
			java.lang.Runtime.getRuntime().exec(cmd);

		} catch (IOException e) {
			log.error("����CIӦ�ó�������ʧ��", e);
			throw new BLException("IGASM2202.E002");
		}
		
		return dto;
	}
}
