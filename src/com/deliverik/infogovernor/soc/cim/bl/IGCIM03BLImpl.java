/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.cim.bl;

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
import org.apache.struts.util.MessageResources;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.SOC0137Info;
import com.deliverik.framework.soc.asset.bl.task.CMDBConstants;
import com.deliverik.framework.soc.asset.bl.task.SOC0101BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0102BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0103BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0104BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0105BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0106BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0107BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0120BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0151BL;
import com.deliverik.framework.soc.asset.bl.task.SocImpactGraphBL;
import com.deliverik.framework.soc.asset.model.SOC0102Info;
import com.deliverik.framework.soc.asset.model.SOC0103Info;
import com.deliverik.framework.soc.asset.model.SOC0104Info;
import com.deliverik.framework.soc.asset.model.SOC0105Info;
import com.deliverik.framework.soc.asset.model.SOC0120Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0102SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0103SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0104SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0105SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0120SearchCondImpl;
import com.deliverik.framework.soc.asset.model.entity.SOC0103TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0104TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0105TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0106TB;
import com.deliverik.framework.user.bl.task.OrganizationBL;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.condition.OrganizationSearchCondImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM03DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0301Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0302Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0303Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0305Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0308Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0309Form;

/**
 * ����: �ʲ����ҵ���߼�ʵ��
 * ��������: �ʲ����ҵ���߼�ʵ��
 * ������¼: 2111/04/25
 * �޸ļ�¼: 
 */
public class IGCIM03BLImpl extends BaseBLImpl implements IGCIM03BL {
	static Log log = LogFactory.getLog(IGCIM03BLImpl.class);

	protected MessageResources resources = MessageResources
			.getMessageResources("com.deliverik.infogovernor.soc.cim.asmResources");

	/** ����������ҵ���߼��ӿ� */
	protected SOC0105BL soc0105BL;
	/** ����������ҵ����ʱ�߼��ӿ� */
	protected SOC0106BL soc0106BL;
	
	/** �������ݰ汾ҵ���߼��ӿ� */
	protected SOC0120BL soc0120BL;
	
	/** ��ƶԱȽ��ҵ���߼��ӿ� */
	protected SOC0103BL soc0103BL;
	
	/** �������ҵ���߼��ӿ� */
	protected SOC0104BL soc0104BL;
	
	/** ����ʲ�ҵ���߼��ӿ� */
	protected SOC0102BL soc0102BL;
	
	/** ����ʲ�����ҵ���߼��ӿ� */
	protected SOC0101BL soc0101BL;
	
	/** ��������ϢBL */
	protected SOC0118BL soc0118BL;
	
	/** �ʲ�ȡֵ��Χ��������BL */
	protected SOC0151BL soc0151BL;
	
	/** �ʲ�������BL */
	protected SOC0107BL soc0107BL;
	
	/** ����BL */
	protected OrganizationBL organizationBL;
	
	/** Ӱ�췶Χ��ʾҵ���߼��ӿ� */
	protected SocImpactGraphBL socImpactGraphBL;
	
	
	


	/**
	 * ����������ҵ���߼��ӿ�ȡ��
	 *
	 * @return soc0105BL ����������ҵ���߼��ӿ�
	 */
	public SOC0105BL getSoc0105BL() {
		return soc0105BL;
	}

	/**
	 * ����������ҵ���߼��ӿ��趨
	 *
	 * @param soc0105BL ����������ҵ���߼��ӿ�
	 */
	public void setSoc0105BL(SOC0105BL soc0105BL) {
		this.soc0105BL = soc0105BL;
	}

	/**
	 * ����������ҵ����ʱ�߼��ӿ�ȡ��
	 *
	 * @return soc0106BL ����������ҵ����ʱ�߼��ӿ�
	 */
	public SOC0106BL getSoc0106BL() {
		return soc0106BL;
	}

	/**
	 * ����������ҵ����ʱ�߼��ӿ��趨
	 *
	 * @param soc0106BL ����������ҵ����ʱ�߼��ӿ�
	 */
	public void setSoc0106BL(SOC0106BL soc0106BL) {
		this.soc0106BL = soc0106BL;
	}

	/**
	 * �������ݰ汾ҵ���߼��ӿ�ȡ��
	 *
	 * @return soc0120BL �������ݰ汾ҵ���߼��ӿ�
	 */
	public SOC0120BL getSoc0120BL() {
		return soc0120BL;
	}

	/**
	 * �������ݰ汾ҵ���߼��ӿ��趨
	 *
	 * @param soc0120BL �������ݰ汾ҵ���߼��ӿ�
	 */
	public void setSoc0120BL(SOC0120BL soc0120BL) {
		this.soc0120BL = soc0120BL;
	}

	/**
	 * ��ƶԱȽ��ҵ���߼��ӿ�ȡ��
	 *
	 * @return soc0103BL ��ƶԱȽ��ҵ���߼��ӿ�
	 */
	public SOC0103BL getSoc0103BL() {
		return soc0103BL;
	}

	/**
	 * ��ƶԱȽ��ҵ���߼��ӿ��趨
	 *
	 * @param soc0103BL ��ƶԱȽ��ҵ���߼��ӿ�
	 */
	public void setSoc0103BL(SOC0103BL soc0103BL) {
		this.soc0103BL = soc0103BL;
	}

	/**
	 * �������ҵ���߼��ӿ�ȡ��
	 *
	 * @return soc0104BL �������ҵ���߼��ӿ�
	 */
	public SOC0104BL getSoc0104BL() {
		return soc0104BL;
	}

	/**
	 * �������ҵ���߼��ӿ��趨
	 *
	 * @param soc0104BL �������ҵ���߼��ӿ�
	 */
	public void setSoc0104BL(SOC0104BL soc0104BL) {
		this.soc0104BL = soc0104BL;
	}

	/**
	 * ����ʲ�ҵ���߼��ӿ�ȡ��
	 *
	 * @return soc0102BL ����ʲ�ҵ���߼��ӿ�
	 */
	public SOC0102BL getSoc0102BL() {
		return soc0102BL;
	}

	/**
	 * ����ʲ�ҵ���߼��ӿ��趨
	 *
	 * @param soc0102BL ����ʲ�ҵ���߼��ӿ�
	 */
	public void setSoc0102BL(SOC0102BL soc0102BL) {
		this.soc0102BL = soc0102BL;
	}

	/**
	 * ����ʲ�����ҵ���߼��ӿ�ȡ��
	 *
	 * @return soc0101BL ����ʲ�����ҵ���߼��ӿ�
	 */
	public SOC0101BL getSoc0101BL() {
		return soc0101BL;
	}

	/**
	 * ����ʲ�����ҵ���߼��ӿ��趨
	 *
	 * @param soc0101BL ����ʲ�����ҵ���߼��ӿ�
	 */
	public void setSoc0101BL(SOC0101BL soc0101BL) {
		this.soc0101BL = soc0101BL;
	}

	/**
	 * ��������ϢBLȡ��
	 *
	 * @return soc0118BL ��������ϢBL
	 */
	public SOC0118BL getSoc0118BL() {
		return soc0118BL;
	}

	/**
	 * ��������ϢBL�趨
	 *
	 * @param soc0118BL ��������ϢBL
	 */
	public void setSoc0118BL(SOC0118BL soc0118BL) {
		this.soc0118BL = soc0118BL;
	}


	public SOC0151BL getSoc0151BL() {
		return soc0151BL;
	}

	public void setSoc0151BL(SOC0151BL soc0151BL) {
		this.soc0151BL = soc0151BL;
	}

	/**
	 * �ʲ�������BLȡ��
	 *
	 * @return soc0107BL �ʲ�������BL
	 */
	public SOC0107BL getSoc0107BL() {
		return soc0107BL;
	}

	/**
	 * �ʲ�������BL�趨
	 *
	 * @param soc0107BL �ʲ�������BL
	 */
	public void setSoc0107BL(SOC0107BL soc0107BL) {
		this.soc0107BL = soc0107BL;
	}

	/**
	 * ����BLȡ��
	 *
	 * @return organizationBL ����BL
	 */
	public OrganizationBL getOrganizationBL() {
		return organizationBL;
	}

	/**
	 * ����BL�趨
	 *
	 * @param organizationBL ����BL
	 */
	public void setOrganizationBL(OrganizationBL organizationBL) {
		this.organizationBL = organizationBL;
	}

	/**
	 * Ӱ�췶Χ��ʾҵ���߼��ӿ�ȡ��
	 *
	 * @return socImpactGraphBL Ӱ�췶Χ��ʾҵ���߼��ӿ�
	 */
	public SocImpactGraphBL getSocImpactGraphBL() {
		return socImpactGraphBL;
	}

	/**
	 * Ӱ�췶Χ��ʾҵ���߼��ӿ��趨
	 *
	 * @param socImpactGraphBL Ӱ�췶Χ��ʾҵ���߼��ӿ�
	 */
	public void setSocImpactGraphBL(SocImpactGraphBL socImpactGraphBL) {
		this.socImpactGraphBL = socImpactGraphBL;
	}

	/**
	 * ��ƿ���̨��ʾ����
	 * 
	 * @param dto IGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO initIGCIM0301Action(IGCIM03DTO dto) throws BLException {
		log.debug("========��ƿ���̨��ʾ����ʼ========");
		
		IGCIM0301Form form = dto.getIgcim0301Form();
		//����Ƿ�����������
		SOC0104SearchCondImpl atCond = new SOC0104SearchCondImpl();
		List<SOC0104Info> atList = this.soc0104BL.searchSOC0104(atCond, 0, 0);
		if(atList.isEmpty()) {
			throw new BLException("IGCIM0301.E007");
		} else {
			dto.setAuditTaskInfo(atList.get(0));
		}
		
		//������������
		SOC0105SearchCondImpl cond = new SOC0105SearchCondImpl();
		
		if("0".equals(form.getTaskDone())) {
			cond.setTaskDone(false);//δ���
		} else if("1".equals(form.getTaskDone())) {
			cond.setTaskDone(true);//�����
		} else {
			cond.setTaskError(true);//�쳣
		}
		cond.setDeleteflag_eq("0");//����
		
		//�����������б�
		List<SOC0105Info> auditWaitTaskList = this.soc0105BL.searchSOC0105(cond);
		
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
				throw new BLException("IGCIM0301.E002");
			}
		
			//���������б�
			SOC0120SearchCondImpl ivCond = new SOC0120SearchCondImpl();
			ivCond.setDeleteflag_eq("0");//����
			List<SOC0120Info> importVersionList = this.soc0120BL.searchImportVersion(ivCond);
			
			//��ǰʱ��
			String createTime = IGStringUtils.getCurrentDateTime();
			
			//�����ڵ��������б��д��ڣ����Ҳ��ڴ����������е��ļ�
			for(String fileName : fileNames) {
				checkCiImportFileName(fileName);//���ɼ��ļ����Ƿ�Ϸ�
				String ciName = fileName.substring(0, fileName.lastIndexOf("_"));//����CI����
				for(SOC0120Info iv : importVersionList) {
					if(iv.getImpeiname().equals(ciName)) {//�ж϶���CI�Ƿ��ڵ������ݱ��д���
						boolean flag = true;
						for(SOC0105Info ewt : auditWaitTaskList){
							if(ewt.getAuwtfilename().equals(fileName)) {//�ж��ļ��Ƿ��ڴ����������д���
								flag = false;
								break;
							}
						}
						//�������
						if(flag) {
							SOC0105TB auditWaitTask = this.soc0105BL.getSOC0105Instance();
							auditWaitTask.setAuwttopci(ciName);//����CI����
							auditWaitTask.setAuwtfilename(fileName);//�ļ���
							auditWaitTask.setAuwtcreatetime(createTime);//���񴴽�ʱ��
							auditWaitTask.setAuwtstatus(CMDBConstants.TASK_STATUS_WAIT);//������
							auditWaitTask.setImpTypeid(iv.getImpcitype());//����CI����
							auditWaitTask.setEiImportProgrammeTB(iv.getSoc0113TB());//�����һ�β���ʹ������ʾ��Ӧ���ơ�
							this.soc0105BL.registSOC0105(auditWaitTask);
							log.debug("�����ļ�" + fileName);
						}
						break;
					}
				}
			}
			
			//��ѯ�����б�
			dto.setAuditWaitTaskList(this.soc0105BL.searchSOC0105(cond));
		
		} else {//�����
			dto.setAuditWaitTaskList(auditWaitTaskList);
		}
		
		log.debug("========��ƿ���̨��ʾ��������========");
		return dto;
	}
	
	/**
	 * ����������ɾ������
	 * 
	 * @param dto IGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO deleteAuditWaitTaskAction(IGCIM03DTO dto) throws BLException {
		log.debug("========ɾ��������������ʼ========");
		
		IGCIM0301Form form = dto.getIgcim0301Form();
		
		String[] auwtids = form.getAuwtids();//����
		
		//CI����Ӧ����Դ�ļ�
		Properties properties = this.getProperties();
		
		//CI�����ļ���·��
		String ciFilePath  = properties.getProperty("AUDIT_CI_IMPORT_FILE_PATH");
		
		//ɾ���������Ӧ�ļ�
		if(auwtids != null) {
			for(String auwtid : auwtids) {
				SOC0105Info eit = this.soc0105BL.searchSOC0105ByPK(Integer.parseInt(auwtid));
				File file = new File(ciFilePath + File.separator + eit.getAuwtfilename());
				if(file.exists()) {
					file.delete();
				}
				this.soc0105BL.deleteSOC0105(eit);
			}
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I006", resources
				.getMessage(dto.getLocale(), "message.IGCIM0301.005")));
		
		log.debug("========ɾ������������������========");
		return dto;
	}
	
	/**
	 * ����̨����鿴����
	 * 
	 * @param dto IGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO initIGCIM0303Action(IGCIM03DTO dto) throws BLException {
		log.debug("========����̨����鿴����ʼ========");
		
		IGCIM0303Form form = dto.getIgcim0303Form();
		
		dto.setAuditWaitTask(this.soc0105BL.searchSOC0105ByPK(form.getAuwtid()));
			
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
		if(fileName.indexOf("_") > 0 && fileName.indexOf(".") > 0&& fileName.indexOf("(") > 0 && fileName.lastIndexOf("_") < fileName.lastIndexOf(".")
				&& fileName.substring(fileName.lastIndexOf("_") + 1, fileName.lastIndexOf("(")).length() == 12) {
		} else {
			throw new BLException("IGCIM0301.E003", fileName);
		}
	}

	/**
	 * ��ƿ���̨���봦��
	 * 
	 * @param dtoIGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO importIGCIM0301Action(IGCIM03DTO dto) throws BLException {
		log.debug("========��ƿ���̨���봦��ʼ========");
		IGCIM0301Form form = dto.getIgcim0301Form();
		String[] auwtids = form.getAuwtids();
		List<String> topCIList = new ArrayList<String>();
		List<SOC0105Info> awtList = new ArrayList<SOC0105Info>();
		for(int i =0 ;i<auwtids.length;i++){
			String auwtid = auwtids[i];
			awtList.add(soc0105BL.searchSOC0105ByPK(Integer.valueOf(auwtid)));
			topCIList.add(awtList.get(i).getAuwttopci());
		}
		//��ͬ����CIֻ������һ��,�����ٵ���
		SOC0102SearchCondImpl aeiCond = new SOC0102SearchCondImpl();
		aeiCond.setTopCIList(topCIList);
		List<SOC0102Info> aeiList = this.soc0102BL.searchSOC0102(aeiCond);
		if(aeiList.size() > 0) {
			StringBuffer names = new StringBuffer();
			for(SOC0102Info aei : aeiList) {
				names.append(aei.getEiname()).append(",");
			}
			throw new BLException("IGCIM0301.E008", names.toString().substring(0, names.length() - 1));
		}
		//ȡ�ð�װ·��
		Properties properties = getProperties();
		String filepath = properties.getProperty("INSTALL_FILE_PATH");
		String importBatName = properties.getProperty("AUDIT_CI_IMPORT_BAT_NAME");
		String[] cmd = new String[6];
		cmd[0] = "cmd";
		cmd[1] = "/c";
		cmd[2] = "start";
		cmd[3] = " ";
        //��form�еõ�����ei�������顢�����ļ������顢ʵ��������
//		String batNames = null;
//		String filenames = null;
//		String einames = null;
//		String auwtidParms = null;
		SOC0105Info auditWaitTaskInfo = null;
		for(int i =0 ;i<auwtids.length;i++){
			String auwtid = auwtids[i];
			auditWaitTaskInfo = awtList.get(i);
			
			//ͨ������ei����ȥ�������ݰ汾�������ȡ�ð汾�����������ݵĵ�������
			//ͨ�����ͣ��ӵ������������ȡ���������ļ��������Ŀ¼
			SOC0120SearchCondImpl cond = new SOC0120SearchCondImpl();
			cond.setImpeiname(auditWaitTaskInfo.getAuwttopci());
			List<SOC0120Info>	importVersionList = soc0120BL.searchImportVersion(cond);
			String batName = null;
			if(importVersionList.size() == 1) {
				batName = importVersionList.get(0).getSoc0113TB().getImpProgrammeAudit();
			} else {
				throw new BLException("IGCO10000.E004", auditWaitTaskInfo.getAuwttopci());
			}
			String filename = auditWaitTaskInfo.getAuwtfilename();
			String einame = auditWaitTaskInfo.getAuwttopci();
			SOC0106TB tb=new SOC0106TB();
			tb.setFileName(filename);
			tb.setBatName(batName);
			tb.setAuwtId(auwtid);
			tb.setEiName(einame);
			soc0106BL.registSOC0106(tb);
//			if(i==0){
//				batNames = batName;
//				filenames = filename;
//				einames = einame;
//				auwtidParms = auwtid;
//			}else{
//				batNames = batNames + "!"+ batName;
//				filenames = filenames + "!" + filename;
//				einames = einames + "!" + einame;
//				auwtidParms = auwtidParms + "!" + auwtid;
//			}
			
		}
		try {
			User user = dto.getUser();	
			
			cmd[4] = filepath + importBatName;
			cmd[5] = user.getUserid()+ "!" + user.getUsername();
//			cmd[5] =filenames;
//			cmd[6] =batNames;
//			cmd[7] =einames;
//			cmd[8] =user.getUserid()+ "!" + user.getUsername();
//			cmd[9] =auwtidParms;
		    //����bat�ļ�ִ��
			java.lang.Runtime.getRuntime().exec(cmd);

		} catch (Exception e) {
			log.error("����Ӧ�ó�������ʧ��", e);
			throw new BLException("IGCIM0301.E005");
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
			throw new BLException("IGCIM0301.E001");
		} catch (IOException e) {
			log.error("CI����Ӧ����Դ�ļ���ȡ����", e);
			throw new BLException("IGCIM0301.E001");
		} finally {
			if(inputFile != null) {
				try {
					inputFile.close();
				} catch (IOException e) {
					log.error("CI����Ӧ����Դ�ļ���ȡ����", e);
					throw new BLException("IGCIM0301.E001");
				}
			}
		}
		return properties;
	}
	
	/**
	 * ��ƶԱȽ����ѯ����
	 * 
	 * @param dtoIGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO searchAuditResultAction(IGCIM03DTO dto) throws BLException{
		
		log.debug("========��ƶԱȽ����ѯ����ʼ========");
		
		List<SOC0103Info> auditResultList = soc0103BL.searchSOC0103(dto.getAuditResultSearchCond());
		
		dto.setAuditResultList(auditResultList);
		
		log.debug("========��ƶԱȽ����ѯ��������========");
		
		return dto;
	}
	
	/**
	 * ��ƶԱȽ����ѯ����
	 * 
	 * @param dtoIGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO searchIGCIM0302Action(IGCIM03DTO dto) throws BLException{
		
		log.debug("========��ƶԱȽ����ѯ����ʼ========");
		
		List<SOC0137Info> auditResultOneInfoList = soc0103BL.searchAuditResultOne(dto.getAuditResultSearchCond());
		
		dto.setAuditResultOneInfoList(auditResultOneInfoList);
		
		log.debug("========��ƶԱȽ����ѯ��������========");
		
		return dto;
	}
	
	/**
	 * ��ƶԱȽ�����洦��
	 * 
	 * @param dtoIGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public void updateAuditResultAction(IGCIM03DTO dto) throws BLException{
		
		log.debug("========��ƶԱȽ�����洦��ʼ========");
		
		IGCIM0302Form form = dto.getIgcim0302Form();
		
		// ѡ�м���
		String[] checkeds = form.getCheckbox(); 
		
		// ����ǰ�����óɲ�����
		soc0103BL.updateSOC0103Without(dto.getAuditResultSearchCond());
		
		if(checkeds != null && checkeds.length > 0){
			
			//ѡ�н��Ϊ������, ��ԭֵ���ǻ�������Ա�
			for(int i=1;i<checkeds.length;i++){
				String autid=checkeds[i].split(",")[0];
				String eiid=checkeds[i].split(",")[1];
				SOC0103SearchCondImpl cond=new SOC0103SearchCondImpl();
				cond.setAutid(Integer.parseInt(autid));
				cond.setEiid(Integer.parseInt(eiid));
				List<SOC0103Info> auditResultInfoList=this.soc0103BL
				.searchSOC0103(cond);
				if(auditResultInfoList!=null&&auditResultInfoList.size()>0){
					for(SOC0103Info auditResultInfo:auditResultInfoList){
						SOC0103TB arTB = (SOC0103TB) SerializationUtils.clone(auditResultInfo);
						arTB.setAuflag(CMDBConstants.RESULT_AUFLAG_OUT);
						this.soc0103BL.updateSOC0103(arTB);
					}
				}
			}
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I010", resources.getMessage(dto.getLocale(), "message.IGCIM0302.002")));
		log.debug("========��ƶԱȽ�����洦������========");
		
	}

	/**
	 * �������ǼǴ���
	 * @param dtoIGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO insertAuditTaskAction(IGCIM03DTO dto) throws BLException {
		log.debug("========���������Ϣ�ǼǴ���ʼ========");
		// ����Formȡ��
		IGCIM0305Form form = dto.getIgcim0305Form();
		//�����������ɾ����ʶ�����߼�ɾ��
		SOC0104SearchCondImpl auditTaskSearchCond=new SOC0104SearchCondImpl();
		auditTaskSearchCond.setAutstatus_eq("0");
		List<SOC0104Info> auditTaskInfoList=this.soc0104BL.searchSOC0104(auditTaskSearchCond);
		if(auditTaskInfoList!=null){
			for(SOC0104Info auditTaskInfo:auditTaskInfoList){
				SOC0104TB auditTask=(SOC0104TB)SerializationUtils.clone(auditTaskInfo);
				auditTask.setAutstatus("1");
				this.soc0104BL.updateSOC0104(auditTask);
			}
		}
		//������ʲ����е����ݽ�������ɾ��
		this.soc0102BL.deleteSOC0102();
		//������ʲ����Ա��е����ݽ�������ɾ��
		this.soc0101BL.deleteSOC0101();
		//�� ����ʲ��ȴ�������������ɾ��
		this.soc0105BL.deleteSOC0105All();
		
		//�������Ҫ�Ǽǵ���Ϣ
		String auttime=IGStringUtils.getCurrentDateTime();
		form.setAuttime(auttime);
		form.setAutstatus("0");
		dto.setIgcim0305Form(form);
		this.soc0104BL.registSOC0104(dto.getIgcim0305Form());
		// ������������Ϣ
		dto.addMessage(new ActionMessage("IGCO10000.I004", resources
				.getMessage(dto.getLocale(), "message.IGCIM03BLImpl.001")));
		log.debug("========�����������Ϣ�ǼǴ�������========");
		return dto;
	}

	/**
	 * ��������ѯ����
	 * @param dtoIGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO searchAuditTaskAction(IGCIM03DTO dto) throws BLException {
		log.debug("========���������Ϣ��ѯ����ʼ========");

		// ���������Ϣ��ѯ����ȡ��
		int totalCount = this.soc0104BL.getSearchCount(dto.getAuditTaskSearchCond());
		
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
		List<SOC0104Info> auditTaskInfoList = this.soc0104BL
				.searchSOC0104(dto.getAuditTaskSearchCond(), pDto
						.getFromCount(), pDto.getPageDispCount());

		pDto.setTotalCount(totalCount);

		dto.setAuditTaskInfoList(auditTaskInfoList);

		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));

		log.debug("========���������Ϣ��ѯ��������========");
		return dto;
	}

	/**
	 * ��������ѯ��������ҳ��
	 * @param dtoIGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO searchAuditTaskActionForChoose(IGCIM03DTO dto) throws BLException {
		log.debug("========���������Ϣ��ѯ����ʼ========");

		// ���������Ϣ��ѯ����ȡ��
		int totalCount = this.soc0104BL.getSearchCount(dto.getAuditTaskSearchCond());
		
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
		List<SOC0104Info> auditTaskInfoList = this.soc0104BL
				.searchSOC0104(dto.getAuditTaskSearchCond(), pDto
						.getFromCount(), pDto.getPageDispCount());

		pDto.setTotalCount(totalCount);

		dto.setAuditTaskInfoList(auditTaskInfoList);

		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));

		log.debug("========���������Ϣ��ѯ��������========");
		return dto;
	}

	/**
	 * ���������������ʾ
	 * @param dtoIGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO initIGCIM0305Action(IGCIM03DTO dto) throws BLException {
		log.debug("========���������������Ϣ��ѯ����ʼ========");
		IGCIM0305Form form = dto.getIgcim0305Form();
		SOC0104Info auditTaskInfo=this.soc0104BL.searchSOC0104ByPK(form.getAutid());
		form.setAutid(auditTaskInfo.getAutid());//�������ID
		form.setAutdesc(auditTaskInfo.getAutdesc());//�����������
		form.setAuttime(auditTaskInfo.getAuttime());//������񴴽�ʱ��
		form.setAutstatus(auditTaskInfo.getAutstatus());//�������ɾ����ʶ
		// �����ʼ��ģʽ
		form.setMode("1");
		dto.addMessage(new ActionMessage("IGCO10000.I001", resources
				.getMessage(dto.getLocale(), "message.IGCIM03BLImpl.001")));
		log.debug("========���������������Ϣ��ѯ��������========");
		return dto;
	}

	/**
	 * �������������
	 * @param dtoIGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO updateAuditTaskAction(IGCIM03DTO dto) throws BLException {
		log.debug("========���������������Ϣ����ʼ========");
		this.soc0104BL.updateSOC0104(dto.getIgcim0305Form());
		dto.addMessage(new ActionMessage("IGCO10000.I005", resources
				.getMessage(dto.getLocale(), "message.IGCIM03BLImpl.001")));
		log.debug("========���������������Ϣ��������========");
		return dto;
	}

	/**
	 * CI��ѯ����
	 * @param dtoIGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO searchEntityItemAction(IGCIM03DTO dto) throws BLException {
		log.debug("========�豸��Ϣ��ѯ����ʼ========");
		
		//�豸��Ϣ��ѯ����ȡ�� 
		int totalCount = this.soc0118BL.getEntityItemVWSearchCount(dto.getEntityItemVWSearchCond());
		
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
		List<SOC0124Info> entityItemVWInfoList = this.soc0118BL.searchEntityItemVW(dto.getEntityItemVWSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setEntityItemVWInfoList(entityItemVWInfoList);

		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========�豸��Ϣ��ѯ��������========");
		return dto;
	}

	/**
	 * �豸��ϸ��Ϣ��ѯ����
	 * @param dtoIGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO initIGCIM0309Action(IGCIM03DTO dto) throws BLException {
		log.debug("========�豸������Ϣ�༭������ڻ�����ʼ========");
		
		IGCIM0309Form form = dto.getIgcim0309Form();
		
		//�豸��Ϣ����
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(
				Integer.parseInt(form.getEiid()));
		
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
		//�жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(), entityItemVWInfo);

		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}else{
			dto.setFlag(flag);
		}
		
		
		//�豸������Ϣ��ѯ����ȡ�� 
		int totalCount = this.soc0107BL.getConfigItemVWSearchCount(form);
		
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
		List<SOC0129Info> configItemVWInfoList = this.soc0107BL.searchConfigItemVW(
				form, 0, 0);
		
		String[] civalue = new String[totalCount];
		String[] entityItemCivalue = new String[totalCount];
		//��žɰ汾ֵ
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
			dto.setConfigItemVersionTime(this.soc0118BL.searchVersionUpdateTime(entityItemVWInfo.getEiid()));
		}

		
		log.debug("========�豸������Ϣ�༭������ڻ���������========");
		return dto;
	}

	/**
	 * �豸Ӱ�췶Χ��ѯ����
	 * @param dtoIGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO initIGCIM0308Action(IGCIM03DTO dto) throws BLException {
		log.debug("========�豸Ӱ�췶������ڻ�����ʼ========");
		
		IGCIM0308Form form = dto.getIgcim0308Form();
		
		SOC0124Info ei = this.soc0118BL.searchEntityItemVWByKey(Integer.parseInt(form.getEiid()));
		
		//�жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(), ei);
		
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
	 * @param dtoIGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO compareIGCIM0301Action(IGCIM03DTO dto) throws BLException {
		log.debug("========��ƿ���̨�Աȴ���ʼ========");
		
		//���ʵ�����������Ҫ�ڿ���̨��ʾ���ݻ�δ���е������Ϣ
		int count = this.soc0102BL.getSearchCount(new SOC0102SearchCondImpl());
		if(count == 0) {
			throw new BLException("IGCIM0301.E009");
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
			cmd[5] = dto.getIgcim0301Form().getAutid().toString();
		    //����bat�ļ�ִ��
			java.lang.Runtime.getRuntime().exec(cmd);

		} catch (IOException e) {
			log.error("�Ա�Ӧ�ó�������ʧ��", e);
			throw new BLException("IGCIM0301.E005");
		}
		log.debug("========��ƿ���̨�Աȴ�������========");
		return dto;
	
	}
	
	/**
	 * �ʲ����´���
	 * 
	 * @param dtoIGCIM03DTO
	 * @return IGCIM03DTO
	 * @throws BLException
	 */
	public IGCIM03DTO updateEntityAction(IGCIM03DTO dto) throws BLException{
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
			cmd[5] = dto.getIgcim0302Form().getAutid().toString();
		    //����bat�ļ�ִ��
			java.lang.Runtime.getRuntime().exec(cmd);

		} catch (IOException e) {
			log.error("����Ӧ�ó�������ʧ��", e);
			throw new BLException("IGCIM0302.E003");
		}
		
//		rootMarkUpdateAction(dto);
		
		log.debug("========�ʲ����´�������========");
		return dto;
	
	
	}


//	
//	/**
//	 * ��������CI(���ù�ϵ������bat)
//	 * 
//	 * @param dtoIGCIM03DTO
//	 * @return IGCIM03DTO
//	 * @throws BLException
//	 */
//	public IGCIM03DTO rootMarkUpdateAction(IGCIM03DTO dto) throws BLException{
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
//			throw new BLException("IGCIM0302.E001");
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
//			throw new BLException("IGCIM0302.E002");
//		}
//		
//		return dto;
//	}
}
