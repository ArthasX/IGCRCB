/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * ����: �ʲ�����ҵ���߼�ʵ��
 * ��������: �ʲ�����ҵ���߼�ʵ��
 * ������¼: 2011/04/25
 * �޸ļ�¼: 
 */
public class IGASM20BLImpl extends BaseBLImpl implements IGASM20BL {
	static Log log = LogFactory.getLog(IGASM20BLImpl.class);

	/** �ʲ�����BL */
	protected EiDomainDefBL eiDomainDefBL;

	/** �ʲ�����ϸ */
	protected EiDomainDetailBL eiDomainDetailBL;

	/** �������ݰ汾 */
	protected ImportVersionBL importVersionBL;

	/** ����������ҵ���߼��ӿ� */
	protected EiWaitTaskBL eiWaitTaskBL;
	/** ����������� */
	protected EiImportProgrammeBL eiImportProgrammeBL;
	
	/** ���°汾��ҵ���߼��ӿ� */
	protected EiDomainDefVWBL eiDomainDefVWBL;
	
	/**�ʲ�ʵ���ѯBL*/
	protected IG013BL ig013BL;
	
	/** �ʲ�����ϸҵ���߼��ӿ� */
	protected EiDomainDetailMaxVWBL eiDomainDetailMaxVWBL;
	
	
	/**
	 * �ʲ�����ϸҵ���߼��ӿ��趨
	 * @param eiDomainDetailMaxVWBL�ʲ�����ϸҵ���߼��ӿ�
	 */
	public void seteiDomainDetailMaxVWBL(EiDomainDetailMaxVWBL eiDomainDetailMaxVWBL) {
		this.eiDomainDetailMaxVWBL = eiDomainDetailMaxVWBL;
	}
	
	
	/**
	 * �����ʲ�ʵ��
	 * @param ig013BL
	 */	
	public void setIg013BL(IG013BL ig013BL) {
		this.ig013BL = ig013BL;
	}

	/**
	 * ���°汾��ҵ���߼��ӿ��趨
	 * @param eiDomainDefVWBL���°汾��ҵ���߼��ӿ�
	 */
	public void setEiDomainDefVWBL(EiDomainDefVWBL eiDomainDefVWBL) {
		this.eiDomainDefVWBL = eiDomainDefVWBL;
	}

	/**
	 * �����������
	 * @param eiImportProgrammeBL�����������
	 */
	public void setEiImportProgrammeBL(EiImportProgrammeBL eiImportProgrammeBL) {
		this.eiImportProgrammeBL = eiImportProgrammeBL;
	}

	/**
	 * �ʲ�����BL����
	 * 
	 * @param eiDomainDefBL�ʲ�����BL
	 */
	public void setEiDomainDefBL(EiDomainDefBL eiDomainDefBL) {
		this.eiDomainDefBL = eiDomainDefBL;
	}

	/**
	 * ����������ҵ���߼��ӿ�����
	 * 
	 * @param eiWaitTaskBL����������ҵ���߼��ӿ�
	 */
	public void setEiWaitTaskBL(EiWaitTaskBL eiWaitTaskBL) {
		this.eiWaitTaskBL = eiWaitTaskBL;
	}
	/**
	 * �������ݰ汾BL����
	 * 
	 * @param eiDomainDefBL�ʲ�����BL
	 */
	public void setImportVersionBL(ImportVersionBL importVersionBL) {
		this.importVersionBL = importVersionBL;
	}

	/**
	 * �ʲ�����ϸBL����
	 * 
	 * @param eiDomainDefBL�ʲ�����BL
	 */
	public void setEiDomainDetailBL(EiDomainDetailBL eiDomainDetailBL) {
		this.eiDomainDetailBL = eiDomainDetailBL;
	}

	/**
	 * �ʲ�������Ϣ�ǼǴ���
	 * 
	 * @param dtoIGASM20DTO
	 * @return IGASM20DTO
	 */
	public IGASM20DTO insertEiDomainDefAction(IGASM20DTO dto)
			throws BLException {
		log.debug("========�ʲ�������Ϣ�ǼǴ���ʼ========");
		// ����Formȡ��
		IGASM2002Form form = dto.getIgasm2002Form();
		Integer eiddid = eiDomainDefBL.findMaxEiddId();
		if (eiddid == null) {
			form.setEiddid(1000);
		} else {
			form.setEiddid(eiddid + 1);
		}
		form.setVersion(0);
		this.eiDomainDefBL.registEiDomainDef(dto.getIgasm2002Form());
		// �ʲ����������Ϣ
		dto.addMessage(new ActionMessage("IGCO10000.I004", "Domain������Ϣ"));
		log.debug("========�ʲ�������Ϣ�ǼǴ�������========");
		return dto;
	}

	/**
	 * Description: ɾ���û���ɫ
	 * 
	 * @param dtoIGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */

	public IGASM20DTO revokeImportVesionAction(IGASM20DTO dto)
			throws BLException {
		log.debug("========ɾ���û���ɫ����ʼ========");
		// ѭ��ɾ��
		for (int i = 0; i < dto.getOwneiddids().length; i++) {
			Integer eiddid = dto.getEiddid();
			Integer eiddversion = dto.getEiddversion();
			String key = dto.getOwneiddids()[i];
			String impeiname = key.split(";")[1];
			String impversion = key.split(";")[0];
			// �û���ɫɾ������
			eiDomainDetailBL.deleteEiDomainDetailByPK(new EiDomainDetailPK(
					eiddid, eiddversion, impeiname, Integer
							.parseInt(impversion)));
		}
		dto.addMessage(new ActionMessage("IGASM2004.I002"));
		log.debug("========ɾ���û���ɫ��������========");
		return dto;
	}

	/**
	 * Description: ����û���ɫ
	 * 
	 * @param dtoIGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */

	public IGASM20DTO InsertImportVesionAction(IGASM20DTO dto)
			throws BLException {
		log.debug("========����û���ɫ����ʼ========");
		// ѭ�����
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
		log.debug("========����û���ɫ��������========");
		return dto;
	}

	/**
	 * ������������
	 * 
	 * @param cond��������
	 * @return ��������б�
	 */
	public List<EiDomainDetailInfo> searchEiDomainDetailAction(
			EiDomainDetailSearchCond cond) {
		return eiDomainDetailBL.searchEiDomainDetail(cond, 0, 0);
	}
	/**
	 * �������Ӧ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public List<IG688Info>searchAppForDomainDetail()throws BLException{
		
		List<IG688Info> appList = new ArrayList<IG688Info>();
		IG688SearchCondImpl cond = new IG688SearchCondImpl();		
		//ҵ��ϵͳ
		cond.setEsyscoding("999003001");
		appList.addAll(ig013BL.searchIG688Info(cond));
		//Ӧ���ʲ�
		cond.setEsyscoding("999003002");
		appList.addAll(ig013BL.searchIG688Info(cond));
		return appList;
	}

	/**
	 * ������������
	 * 
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<ImportVersionInfo> searchImportVersionAction(
			ImportVersionSearchCond cond) {
		return importVersionBL.searchImportVersion(cond, 0, 0);
	}

	/**
	 * ��������
	 * 
	 * @param instance����ʵ��
	 * @return ����ʵ��
	 */
	public EiDomainDetailInfo registEiDomainDetailAction(EiDomainDetailInfo instance)
			throws BLException {
		return eiDomainDetailBL.registEiDomainDetail(instance);
	}



	/**
	 * �ʲ�������Ϣ��ѯ����
	 * 
	 * @param dtoIGASM20DTO
	 * @return IGASM20DTO
	 */
	public IGASM20DTO searchEiDomainDefAction(IGASM20DTO dto) throws BLException {
		log.debug("========�ʲ�������Ϣ��ѯ����ʼ========");

		// �ʲ�������Ϣ��ѯ����ȡ��
		int totalCount = this.eiDomainDefBL.getSearchCount(dto
				.getEiDomainDefSearchCond());

		if (totalCount == 0) {
			log.debug("========�ʲ�������Ϣ��ѯ���ݲ�����========");
			// �ʲ�������Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}

		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========�ʲ�������Ϣ��ѯ���ݼ�������========");
			// �ʲ�������Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}

		// ��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();

		// ��ǰҳ�ʲ�������Ϣȡ��
		List<EiDomainDefInfo> eiDomainDefInfoList = this.eiDomainDefBL
				.searchEiDomainDef(dto.getEiDomainDefSearchCond(), pDto
						.getFromCount(), pDto.getPageDispCount());

		pDto.setTotalCount(totalCount);

		dto.setEiDomainDefInfoList(eiDomainDefInfoList);

		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));

		log.debug("========�ʲ�������Ϣ��ѯ��������========");
		return dto;
	}

	/**
	 * �ʲ���������ʼ��
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGASM20DTO initIGASM2002Action(IGASM20DTO dto) throws BLException {
		log.debug("========����ʲ����������Ϣ��ѯ����ʼ========");
		IGASM2002Form form = dto.getIgasm2002Form();
		EiDomainDefInfo ei = this.eiDomainDefBL.searchEiDomainDefByPK(
				new EiDomainDefPK(form.getEiddid(),form.getVersion()));
		form.setEiddid(ei.getEiddid());//�ʲ�����Eidddid
		form.setName(ei.getName());//�ʲ���������
		form.setVersion(ei.getVersion());//�汾��
		form.setDescription(ei.getDescription());//����
		form.setCreatetime(ei.getCreatetime());//����ʱ��
		form.setUpdatetime(ei.getUpdatetime());//����ʱ��
		form.setFingerPrint(ei.getFingerPrint());//ʱ���
		// �����ʼ��ģʽ
		form.setMode("1");
		dto.addMessage(new ActionMessage("IGCO10000.I001", "Domain������Ϣ"));
		log.debug("========����ʲ����������Ϣ��ѯ��������========");
		return dto;
	}

	/**
	 * �ʲ�����������
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGASM20DTO updateEiDomainDefAction(IGASM20DTO dto)
			throws BLException {
		log.debug("========����ʲ����������Ϣ����ʼ========");
		eiDomainDefBL.updateEiDomainDef(dto.getIgasm2002Form());
		dto.addMessage(new ActionMessage("IGCO10000.I005", "Domain������Ϣ"));
		log.debug("========����ʲ����������Ϣ��������========");
		return dto;
	}

	/**
	 * �ʲ�������ϸ��Ϣ��ʼ��
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGASM20DTO initIGASM2005Action(IGASM20DTO dto) throws BLException {
		log.debug("========��ʾ�ʲ����������Ϣ��ѯ����ʼ========");
		IGASM2005Form form = dto.getIgasm2005Form();
		EiDomainDefInfo ei = this.eiDomainDefBL.searchEiDomainDefByPK(new EiDomainDefPK(form.getEiddid(),form.getVersion()));
		form.setEiddid(ei.getEiddid());//�ʲ�����Eidddid
		form.setName(ei.getName());//�ʲ���������
		form.setVersion(ei.getVersion());//�汾��
		form.setDescription(ei.getDescription());//����
		form.setCreatetime(ei.getCreatetime());//����ʱ��
		form.setUpdatetime(ei.getUpdatetime());//����ʱ��
		form.setFingerPrint(ei.getFingerPrint());//ʱ���
		dto.addMessage(new ActionMessage("IGCO10000.I001", "Domain������Ϣ"));
		log.debug("========��ʾ�ʲ����������Ϣ��ѯ��������========");
		return dto;
	}
	
	/**
	 * ���ֶ���������
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGASM20DTO handSnapshotAction(IGASM20DTO dto) throws BLException {
		log.debug("========���ֶ��������ɴ���ʼ========");
		IGASM2003Form form = dto.getIgasm2003Form();
		//ȡ�ð�װ·��
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
			
		    //����bat�ļ�ִ��
			java.lang.Runtime.getRuntime().exec(cmd);

		} catch (IOException e) {
			log.error("�ֶ�����Ӧ�ó�������ʧ��", e);
			throw new BLException("IGASM2005.E001");
		}
		log.debug("========���ֶ��������ɴ�������========");
		return dto;
	}
	

	/**
	 * ����̨��ʾ����
	 * 
	 * @param dto IGASM20DTO
	 * @return IGASM20DTO
	 * @throws BLException
	 */
	public IGASM20DTO initIGASM2001Action(IGASM20DTO dto) throws BLException {
		log.debug("========����̨��ʾ����ʼ========");
		
		IGASM2001Form form = dto.getIgasm2001Form();
		
		//������������
		EiWaitTaskSearchCondImpl cond = new EiWaitTaskSearchCondImpl();
		
		if("0".equals(form.getTaskDone())) {
			cond.setTaskDone(false);//δ���
		} else if("1".equals(form.getTaskDone())) {
			cond.setTaskDone(true);//�����
		} else {
			cond.setTaskError(true);//�쳣
		}
		cond.setDeleteflag_eq("0");//����
		
		//�����������б�
		List<EiWaitTaskInfo> eiWaitTaskList = this.eiWaitTaskBL.searchEiWaitTask(cond);
		
		if("0".equals(form.getTaskDone())) {//δ���
			
			//CI����Ӧ����Դ�ļ�
			Properties properties = this.getProperties();
			//�������ļ����б�
			List<String> fileNames = new ArrayList<String>();
			//CI�����ļ���·��
			File ciFile = new File(properties.getProperty("CI_IMPORT_FILE_PATH"));
			//�ж��ļ����Ƿ����
			if(ciFile.exists() && ciFile.isDirectory()) {
				//��ȡ�ļ��б�
				 List<File> files = Arrays.asList(ciFile.listFiles());
				 //���ļ���������
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
					 //�ж��Ƿ����ļ�
					 if(file.isFile()) {
						 fileNames.add(file.getName());
					 }
				 }
			} else {
				throw new BLException("IGASM2001.E002");
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
						for(EiWaitTaskInfo ewt : eiWaitTaskList){
							if(ewt.getEitfilename().equals(fileName)) {//�ж��ļ��Ƿ��ڴ����������д���
								flag = false;
								break;
							}
						}
						//�������
						if(flag) {
							EiWaitTaskTB eiWaitTask = this.eiWaitTaskBL.getEiWaitTaskTBInstance();
							eiWaitTask.setEittopci(ciName);//����CI����
							eiWaitTask.setEitfilename(fileName);//�ļ���
							eiWaitTask.setEitcreatetime(createTime);//���񴴽�ʱ��
							eiWaitTask.setEitstatus(CMDBConstants.TASK_STATUS_WAIT);//������
							eiWaitTask.setImpTypeid(iv.getImpcitype());//����CI����
							eiWaitTask.setEiImportProgrammeTB(iv.getEiImportProgrammeTB());//�����һ�β���ʹ������ʾ��Ӧ���ơ�
							this.eiWaitTaskBL.registEiWaitTask(eiWaitTask);
							log.debug("�����ļ�" + fileName);
						}
						break;
					}
				}
			}
			
			//��ѯ�����б�
			dto.setEiWaitTaskList(this.eiWaitTaskBL.searchEiWaitTask(cond));
		
		} else {//�����
			dto.setEiWaitTaskList(eiWaitTaskList);
		}
		
		log.debug("========����̨��ʾ��������========");
		return dto;
	}
	
	/**
	 * ����̨����鿴����
	 * 
	 * @param dto IGASM20DTO
	 * @return IGASM20DTO
	 * @throws BLException
	 */
	public IGASM20DTO initIGASM2010Action(IGASM20DTO dto) throws BLException {
		log.debug("========����̨����鿴����ʼ========");
		
		IGASM2010Form form = dto.getIgasm2010Form();
		
		dto.setEiWaitTask(this.eiWaitTaskBL.searchEiWaitTaskByPK(form.getEitid()));
			
		log.debug("========����̨����鿴��������========");
		return dto;
	}
	
	/**
	 * ����������ɾ������
	 * 
	 * @param dto IGASM20DTO
	 * @return IGASM20DTO
	 * @throws BLException
	 */
	public IGASM20DTO deleteEiWaitTaskAction(IGASM20DTO dto) throws BLException {
		log.debug("========ɾ��������������ʼ========");
		
		IGASM2001Form form = dto.getIgasm2001Form();
		
		String[] eitids = form.getEitids();//����
		
		//CI����Ӧ����Դ�ļ�
		Properties properties = this.getProperties();
		
		//CI�����ļ���·��
		String ciFilePath  = properties.getProperty("CI_IMPORT_FILE_PATH");
		
		//ɾ���������Ӧ�ļ�
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
		
		dto.addMessage(new ActionMessage("IGCO10000.I006", "����"));
		
		log.debug("========ɾ������������������========");
		return dto;
	}
	
	/**
	 * ���CI�ɼ��ļ����Ƿ�Ϸ�
	 * �ļ�����ʽΪ������CI��ʶ+��_��+ʱ���(YYMMDDHHMI)
	 * @param fileName �ļ���
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
	 * �ʲ�����ɾ������
	 * 
	 * @param dto
	 */
	public IGASM20DTO deleteEiDomainDefAction(IGASM20DTO dto)
			throws BLException {
		log.debug("========�ʲ�������Ϣɾ������ʼ========");
		// ѭ��ɾ��
		for (int i = 0; i < dto.getDeleteEiddid().length; i++) {
			String key = dto.getDeleteEiddid()[i];
			String eiddid = key.split("_")[0];
//			String version = key.split("_")[1];
			List<EiDomainDefInfo> eiDomainDefInfoList=this.eiDomainDefBL.searchEiDomainDefByPK(Integer.parseInt(eiddid),null);
			// �ʲ�����ɾ������
			for(EiDomainDefInfo eiDomainDefInfo:eiDomainDefInfoList){
			eiDomainDefBL.deleteEiDomainDef(eiDomainDefInfo);
			}
		}
		dto.addMessage(new ActionMessage("IGASM2004.I002"));
		log.debug("========�ʲ�������Ϣɾ����������========");
		return dto;
	}

	/**
	 * ����̨���봦��
	 * 
	 * @param dtoIGASM20DTO
	 * @return IGASM20DTO
	 * @throws BLException
	 */
	public IGASM20DTO importIGASM2001Action(IGASM20DTO dto) throws BLException {
		log.debug("========����̨���봦��ʼ========");
		//ȡ�ð�װ·��
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
        //��form�еõ�����ei�������顢�����ļ������顢ʵ��������
		String batNames = null;
		String filenames = null;
		String einames = null;
		String eitidParms = null;
		for(int i =0 ;i<eitids.length;i++){
			String eitid = eitids[i];
			EiWaitTaskInfo eiWaitTaskInfo = eiWaitTaskBL.searchEiWaitTaskByPK(Integer.valueOf(eitid));
			
			//ͨ������ei����ȥ�������ݰ汾�������ȡ�ð汾�����������ݵĵ�������
			//ͨ�����ͣ��ӵ������������ȡ���������ļ��������Ŀ¼
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
		    //����bat�ļ�ִ��
			java.lang.Runtime.getRuntime().exec(cmd);

		} catch (Exception e) {
			log.error("����Ӧ�ó�������ʧ��", e);
			throw new BLException("IGASM2001.E005");
		}
		log.debug("========����̨���봦������========");
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

	/**
	 * ���������Ϣ�ǼǴ���
	 */
	public IGASM20DTO insertImportVersionAction(IGASM20DTO dto)
			throws BLException {
		log.debug("========���������Ϣ�ǼǴ���ʼ========");
		// ����Formȡ��
		IGASM2006Form form = dto.getIgasm2006Form();
		form.setImpversion(0);//�汾��
		form.setImpeiid(0);//ʵ��ID
		//�ʲ�ģ�Ͳ����
//		if(form.getImpcitype()==1){
//			form.setEsyscoding("999001001");//����
//		}else if(form.getImpcitype()==2){
//			form.setEsyscoding("999001009001");//��������
//		}else if(form.getImpcitype()==3){
//			form.setEsyscoding("999003");//Ӧ���ʲ�
//		}else if(form.getImpcitype()==4){
//			form.setEsyscoding("999001006001");//SAN������
//		}
		this.importVersionBL.registImportVersion(dto.getIgasm2006Form());
		// ������������Ϣ
		dto.addMessage(new ActionMessage("IGCO10000.I004", "������������Ϣ"));
		log.debug("========���������Ϣ�ǼǴ�������========");
		return dto;
	}

	/**
	 * ���������Ϣ��ѯ����
	 */
	public IGASM20DTO searchImportVersionAction(IGASM20DTO dto) throws BLException {
		log.debug("========���������Ϣ��ѯ����ʼ========");

		// ���������Ϣ��ѯ����ȡ��
		int totalCount = this.importVersionBL.getSearchCount(dto
				.getImportVersionSearchCond());
		
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
		List<ImportVersionInfo> importVersionInfoList = this.importVersionBL
				.searchImportVersion(dto.getImportVersionSearchCond(), pDto
						.getFromCount(), pDto.getPageDispCount());

		pDto.setTotalCount(totalCount);

		dto.setImportVersionInfoList(importVersionInfoList);

		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));

		log.debug("========���������Ϣ��ѯ��������========");
		return dto;
	}
	
	/**
	 * �ɼ�����̨��ѯ����
	 * @param dto IGASM20DTO
	 * @throws BLException
	 */
	public IGASM20DTO initIGASM2014Action(IGASM20DTO dto) throws BLException {
		log.debug("========�ɼ�����̨��Ϣ��ѯ����ʼ========");
		
		// ���������Ϣ��ѯ����ȡ��
		int totalCount = this.importVersionBL.getSearchCount(dto
				.getImportVersionSearchCond());
		
		if (totalCount == 0) {
			log.debug("========�ɼ�����̨��Ϣ��ѯ���ݲ�����========");
			// �ɼ�����̨��Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========�ɼ�����̨��Ϣ��ѯ���ݼ�������========");
			// �ɼ�����̨��Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}
		
		// ��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();
		
		// ��ǰҳ�ɼ�����̨��Ϣȡ��
		List<ImportVersionInfo> importVersionInfoList = this.importVersionBL
		.searchImportVersion(dto.getImportVersionSearchCond(), pDto
				.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setImportVersionInfoList(importVersionInfoList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		
		log.debug("========�ɼ�����̨��Ϣ��ѯ��������========");
		return dto;
	}

	/**
	 * �������ɾ������
	 * @param dto
	 * @throws BLException
	 */
	public IGASM20DTO deleteImportVersionAction(IGASM20DTO dto) throws BLException {
		log.debug("========���������Ϣɾ������ʼ========");
		// ѭ��ɾ��
		for (int i = 0; i < dto.getDeleteImpeiid().length; i++) {
			String key = dto.getDeleteImpeiid()[i];
			String impeiname = key.split("_")[0];
			String impversion = key.split("_")[1];
			// �������ɾ������
			importVersionBL.deleteImportVersionByPK(new ImportVersionPK(Integer.parseInt(impversion),impeiname));
		}
		dto.addMessage(new ActionMessage("IGASM2004.I002"));
		log.debug("========���������Ϣɾ����������========");
		return dto;
	}

	/**
	 * �������״̬����
	 * @param dto
	 * @throws BLException
	 */
	public void changeDeleteFlagAction(IGASM20DTO dto) throws BLException {
		log.debug("========�������״̬�仯����ʼ========");
		ImportVersionInfo importVersionInfo = importVersionBL.searchImportVersionByPK(new ImportVersionPK(dto.getImpversion(),dto.getImpeiname()));
		ImportVersionTB importVersionTB = (ImportVersionTB)SerializationUtils.clone(importVersionInfo);
		if("0".equals(importVersionInfo.getDeleteflag())){
			importVersionTB.setDeleteflag("1");
		} else if ("1".equals(importVersionInfo.getDeleteflag())){
			importVersionTB.setDeleteflag("0");
		}
		importVersionBL.updateImportVersion(importVersionTB);
		log.debug("========�������״̬�仯�������========");
	}

	/**
	 * �����������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGASM20DTO getEiImportProgrammeAction(IGASM20DTO dto) throws BLException {
		log.debug("========����������Ͳ�ѯ����ʼ========");
		List<EiImportProgrammeInfo> impTypeInfoList=this.eiImportProgrammeBL.searchEiImportProgramme();
		List<LabelValueBean> impTypeList = new ArrayList<LabelValueBean>();
		impTypeList.add(new LabelValueBean("",""));
		for(EiImportProgrammeInfo info : impTypeInfoList){
			impTypeList.add(new LabelValueBean(info.getImpTypename(),info.getImpTypeid().toString()));
		}
		dto.setImpTypeList(impTypeList);
		log.debug("========����������Ͳ�ѯ�������========");
		return dto;
	}

	/**
	 * �������汾����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGASM20DTO searchImportVersionIGASM2010Action(IGASM20DTO dto)
			throws BLException {
		log.debug("========�������汾��ѯ����ʼ========");
		ImportVersionInfo importVersionInfo = importVersionBL.searchImportVersionByPK(new ImportVersionPK(dto.getImpversion(),dto.getImpeiname()));
		List<ImportVersionInfo> importVersionInfoList = this.importVersionBL
		.searchImportVersionByPK(dto.getImpeiname(),dto.getImpversion());
		if(importVersionInfoList==null){
			dto.addMessage(new ActionMessage("IGCO10000.E004","��ʷ�汾"));
			
		}else{
			dto.setImportVersionInfoList(importVersionInfoList);
		}
			dto.setImportVersionInfo(importVersionInfo);
		log.debug("========�������汾��ѯ�������========");
		return dto;
	}

	/**
	 * �ʲ�����汾����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGASM20DTO searchIGASM2012Action(IGASM20DTO dto) throws BLException {
		log.debug("========�ʲ�����汾��ѯ����ʼ========");
		IGASM2012Form form=dto.getIgasm2012Form();
		EiDomainDefInfo eiDomainDefInfo = this.eiDomainDefBL.searchEiDomainDefByPK(new EiDomainDefPK(form.getEiddid(),form.getVersion()));
		List<EiDomainDefInfo> eiDomainDefInfoList = this.eiDomainDefBL.searchEiDomainDefByPK(form.getEiddid(),form.getVersion());
		if(eiDomainDefInfoList==null){
			dto.addMessage(new ActionMessage("IGCO10000.E004","��ʷ�汾"));
			
		}else{
			dto.setEiDomainDefInfoList(eiDomainDefInfoList);
		}
			dto.setEiDomainDefInfo(eiDomainDefInfo);
		log.debug("========�ʲ�����汾��ѯ�������========");
		return dto;
	}

	/**
	 * ���°汾����Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGASM20DTO searchIGASM2013Action(IGASM20DTO dto) throws BLException {
		log.debug("========���°汾����Ϣ��ѯ����ʼ========");
		List<EiDomainDefVWInfo> eiDomainDefVWInfoList=this.eiDomainDefVWBL.searchEiDomainDefVW();
		List<LabelValueBean> domainList = new ArrayList<LabelValueBean>();
		domainList.add(new LabelValueBean("",""));
		for(EiDomainDefVWInfo info : eiDomainDefVWInfoList){
			domainList.add(new LabelValueBean(info.getName(),info.getEiddid().toString()));
		}
		List<LabelValueBean> typeList = new ArrayList<LabelValueBean>();
		typeList.add(new LabelValueBean("����","1"));
//		typeList.add(new LabelValueBean("ȫ��","2"));
		dto.setDomainList(domainList);
		dto.setTypeList(typeList);
		log.debug("========���°汾����Ϣ��ѯ�������========");
		return dto;
	}

	/**
	 * ��CI��ѯ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGASM20DTO searchDoaminCiInfoAction(IGASM20DTO dto)
			throws BLException {
		log.debug("========��CI��ѯ����ʼ========");
		IGASM2013Form form=dto.getIgasm2013Form();
		//�汾ȡ��
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
					log.debug("========��CI��ѯ���ݲ�����========");
					// ��CI��ѯ���ݲ�����
					dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
					return dto;
				}

				if (totalCount > dto.getMaxSearchCount()) {
					log.debug("========��CI��ѯ���ݼ�������========");
					// ��CI��ѯ���ݼ�������
					dto.addMessage(new ActionMessage("IGCO00000.E005", dto
							.getMaxSearchCount(), totalCount));
					return dto;
				}

				// ��ҳ����Ϣȡ��
				PagingDTO pDto = dto.getPagingDto();

				// ��ǰҳ��CIȡ��
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
				// ��CI��ѯ����ȡ��
				int totalCount = this.eiDomainDetailMaxVWBL.getSearchCount(dto
						.getEiDomainDetailVWSearchCond());
				
				if (totalCount == 0) {
					log.debug("========��CI��ѯ���ݲ�����========");
					// ��CI��ѯ���ݲ�����
					dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
					return dto;
				}

				if (totalCount > dto.getMaxSearchCount()) {
					log.debug("========��CI��ѯ���ݼ�������========");
					// ��CI��ѯ���ݼ�������
					dto.addMessage(new ActionMessage("IGCO00000.E005", dto
							.getMaxSearchCount(), totalCount));
					return dto;
				}

				// ��ҳ����Ϣȡ��
				PagingDTO pDto = dto.getPagingDto();

				// ��ǰҳ��CIȡ��
				List<EiDomainDetailMaxVWInfo> eiDomainDetailVWInfoList = this.eiDomainDetailMaxVWBL
						.searchEiDomainDetailVW(dto.getEiDomainDetailVWSearchCond(), pDto
								.getFromCount(), pDto.getPageDispCount());

				pDto.setTotalCount(totalCount);
				dto.setEiDomainDetailVWInfoList(eiDomainDetailVWInfoList);

				dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
			}
			if("2".equals(form.getTypeId())){
				// ��CI��ѯ����ȡ��
				int totalCount = this.eiDomainDetailMaxVWBL.getSearchCount(dto
						.getEiDomainDetailVWSearchCond());
				
				if (totalCount == 0) {
					log.debug("========��CI��ѯ���ݲ�����========");
					// ��CI��ѯ���ݲ�����
					dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
					return dto;
				}

				if (totalCount > dto.getMaxSearchCount()) {
					log.debug("========��CI��ѯ���ݼ�������========");
					// ��CI��ѯ���ݼ�������
					dto.addMessage(new ActionMessage("IGCO00000.E005", dto
							.getMaxSearchCount(), totalCount));
					return dto;
				}

				// ��ҳ����Ϣȡ��
				PagingDTO pDto = dto.getPagingDto();

				// ��ǰҳ��CIȡ��
				List<EiDomainDetailMaxVWInfo> eiDomainDetailVWInfoList = this.eiDomainDetailMaxVWBL
						.searchEiDomainDetailVW(dto.getEiDomainDetailVWSearchCond(), pDto
								.getFromCount(), pDto.getPageDispCount());

				pDto.setTotalCount(totalCount);
				dto.setEiDomainDetailVWInfoList(eiDomainDetailVWInfoList);

				dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
			}
		}
		
		log.debug("========��CI��ѯ�������========");
		return dto;
	}

}
