/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * ����: �ʲ�����ҵ���߼�ʵ��
 * ��������: �ʲ�����ҵ���߼�ʵ��
 * ������¼: 2011/04/25
 * �޸ļ�¼: 
 */
public class IGCIM02BLImpl extends BaseBLImpl implements IGCIM02BL {
	static Log log = LogFactory.getLog(IGCIM02BLImpl.class);

	protected MessageResources resources = MessageResources
			.getMessageResources("com.deliverik.infogovernor.soc.cim.asmResources");

	/** �ʲ�����BL */
	protected SOC0111BL soc0111BL;

	/** �ʲ�����ϸ */
	protected SOC0112BL soc0112BL;

	/** �������ݰ汾 */
	protected SOC0120BL soc0120BL;

	/** ����������ҵ���߼��ӿ� */
	protected SOC0115BL soc0115BL;
	/** ����������ҵ���߼���ʱ��ӿ� */
	protected SOC0116BL soc0116BL;
	/** ����������� */
	protected SOC0113BL soc0113BL;
	
	/** ���°汾��ҵ���߼��ӿ� */
	protected SOC0125BL soc0125BL;
	
	/**�ʲ�ʵ���ѯBL*/
	protected SOC0118BL soc0118BL;
	
	/** �ʲ�����ϸҵ���߼��ӿ� */
	protected SOC0126BL soc0126BL;
	
	
	/** ����ԭ����*/
	protected CR03BL cr03BL;
	
	HQApi hqapi;
	private CicollecttaskBL cicollecttaskBL;

	/**
	 * �ʲ�����BL�趨
	 *
	 * @param soc0111BL �ʲ�����BL
	 */
	public void setSoc0111BL(SOC0111BL soc0111BL) {
		this.soc0111BL = soc0111BL;
	}

	/**
	 * �ʲ�����ϸ�趨
	 *
	 * @param soc0112BL �ʲ�����ϸ
	 */
	public void setSoc0112BL(SOC0112BL soc0112BL) {
		this.soc0112BL = soc0112BL;
	}

	/**
	 * �������ݰ汾�趨
	 *
	 * @param soc0120BL �������ݰ汾
	 */
	public void setSoc0120BL(SOC0120BL soc0120BL) {
		this.soc0120BL = soc0120BL;
	}

	/**
	 * ����������ҵ���߼��ӿ��趨
	 *
	 * @param soc0115BL ����������ҵ���߼��ӿ�
	 */
	public void setSoc0115BL(SOC0115BL soc0115BL) {
		this.soc0115BL = soc0115BL;
	}

	/**
	 * ����������ҵ���߼���ʱ��ӿ��趨
	 *
	 * @param soc0116BL ����������ҵ���߼���ʱ��ӿ�
	 */
	public void setSoc0116BL(SOC0116BL soc0116BL) {
		this.soc0116BL = soc0116BL;
	}

	/**
	 * ������������趨
	 *
	 * @param soc0113BL �����������
	 */
	public void setSoc0113BL(SOC0113BL soc0113BL) {
		this.soc0113BL = soc0113BL;
	}

	/**
	 * ���°汾��ҵ���߼��ӿ��趨
	 *
	 * @param soc0125BL ���°汾��ҵ���߼��ӿ�
	 */
	public void setSoc0125BL(SOC0125BL soc0125BL) {
		this.soc0125BL = soc0125BL;
	}

	/**
	 * �ʲ�ʵ���ѯBL�趨
	 *
	 * @param soc0118BL �ʲ�ʵ���ѯBL
	 */
	public void setSoc0118BL(SOC0118BL soc0118BL) {
		this.soc0118BL = soc0118BL;
	}

	/**
	 * �ʲ�����ϸҵ���߼��ӿ��趨
	 *
	 * @param soc0126BL �ʲ�����ϸҵ���߼��ӿ�
	 */
	public void setSoc0126BL(SOC0126BL soc0126BL) {
		this.soc0126BL = soc0126BL;
	}
	
	/**
	 * ����ԭ������������ϵ��ҵ���߼��ӿ�
	 *
	 * @param cr03BL ����ԭ������������ϵ��ҵ���߼��ӿ�
	 */
	public void setCr03BL(CR03BL cr03BL) {
		this.cr03BL = cr03BL;
	}
	
	/**
	 * �ʲ�������Ϣ�ǼǴ���
	 * 
	 * @param dtoIGCIM02DTO
	 * @return IGCIM02DTO
	 */
	public IGCIM02DTO insertEiDomainDefAction(IGCIM02DTO dto)
			throws BLException {
		log.debug("========�ʲ�������Ϣ�ǼǴ���ʼ========");
		// ����Formȡ��
		IGCIM0202Form form = dto.getIgcim0202Form();
		Integer eiddid = soc0111BL.findMaxEiddId();
		if (eiddid == null) {
			form.setEiddid(1000);
		} else {
			form.setEiddid(eiddid + 1);
		}
		form.setVersion(0);
		this.soc0111BL.registEiDomainDef(dto.getIgcim0202Form());
		// �ʲ����������Ϣ
		dto.addMessage(new ActionMessage("IGCO10000.I004", resources
				.getMessage(dto.getLocale(), "message.IGCIM02BLImpl.001")));
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

	public IGCIM02DTO revokeImportVesionAction(IGCIM02DTO dto)
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
			soc0112BL.deleteEiDomainDetailByPK(new SOC0112PK(
					eiddid, eiddversion, impeiname, Integer
							.parseInt(impversion)));
		}
		dto.addMessage(new ActionMessage("IGCIM0204.I002"));
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

	public IGCIM02DTO InsertImportVesionAction(IGCIM02DTO dto)
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
			soc0112BL
					.registEiDomainDetail(new SOC0112TB(eiddid,
							eiddversion, impeiname, Integer
									.parseInt(impversion), date));
		}
		dto.addMessage(new ActionMessage("IGCIM0204.I001"));
		log.debug("========����û���ɫ��������========");
		return dto;
	}

	/**
	 * ������������
	 * 
	 * @param cond��������
	 * @return ��������б�
	 */
	public List<SOC0112Info> searchEiDomainDetailAction(
			SOC0112SearchCond cond) {
		return soc0112BL.searchEiDomainDetail(cond, 0, 0);
	}
	/**
	 * �������Ӧ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public List<SOC0124Info>searchAppForDomainDetail()throws BLException{
		
		List<SOC0124Info> appList = new ArrayList<SOC0124Info>();
		SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();		
		//ҵ��ϵͳ
		cond.setEsyscoding("999003001");
		appList.addAll(soc0118BL.searchEntityItemVW(cond));
		//Ӧ���ʲ�
		cond.setEsyscoding("999003002");
		appList.addAll(soc0118BL.searchEntityItemVW(cond));
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
	public List<SOC0120Info> searchImportVersionAction(
			SOC0120SearchCond cond) {
		return soc0120BL.searchImportVersion(cond, 0, 0);
	}

	/**
	 * ��������
	 * 
	 * @param instance����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0112Info registEiDomainDetailAction(SOC0112Info instance)
			throws BLException {
		return soc0112BL.registEiDomainDetail(instance);
	}



	/**
	 * �ʲ�������Ϣ��ѯ����
	 * 
	 * @param dtoIGCIM02DTO
	 * @return IGCIM02DTO
	 */
	public IGCIM02DTO searchEiDomainDefAction(IGCIM02DTO dto) throws BLException {
		log.debug("========�ʲ�������Ϣ��ѯ����ʼ========");

		// �ʲ�������Ϣ��ѯ����ȡ��
		int totalCount = this.soc0111BL.getSearchCount(dto
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
		List<SOC0111Info> eiDomainDefInfoList = this.soc0111BL
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
	public IGCIM02DTO initIGCIM0202Action(IGCIM02DTO dto) throws BLException {
		log.debug("========����ʲ����������Ϣ��ѯ����ʼ========");
		IGCIM0202Form form = dto.getIgcim0202Form();
		SOC0111Info ei = this.soc0111BL.searchEiDomainDefByPK(
				new SOC0111PK(form.getEiddid(),form.getVersion()));
		form.setEiddid(ei.getEiddid());//�ʲ�����Eidddid
		form.setName(ei.getName());//�ʲ���������
		form.setVersion(ei.getVersion());//�汾��
		form.setDescription(ei.getDescription());//����
		form.setCreatetime(ei.getCreatetime());//����ʱ��
		form.setUpdatetime(ei.getUpdatetime());//����ʱ��
		form.setFingerPrint(ei.getFingerPrint());//ʱ���
		// �����ʼ��ģʽ
		form.setMode("1");
		dto.addMessage(new ActionMessage("IGCO10000.I001", resources
				.getMessage(dto.getLocale(), "message.IGCIM02BLImpl.001")));
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
	public IGCIM02DTO updateEiDomainDefAction(IGCIM02DTO dto)
			throws BLException {
		log.debug("========����ʲ����������Ϣ����ʼ========");
		soc0111BL.updateEiDomainDef(dto.getIgcim0202Form());
		dto.addMessage(new ActionMessage("IGCO10000.I005", resources
				.getMessage(dto.getLocale(), "message.IGCIM02BLImpl.001")));
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
	public IGCIM02DTO initIGCIM0205Action(IGCIM02DTO dto) throws BLException {
		log.debug("========��ʾ�ʲ����������Ϣ��ѯ����ʼ========");
		IGCIM0205Form form = dto.getIgcim0205Form();
		SOC0111Info ei = this.soc0111BL.searchEiDomainDefByPK(new SOC0111PK(form.getEiddid(),form.getVersion()));
		form.setEiddid(ei.getEiddid());//�ʲ�����Eidddid
		form.setName(ei.getName());//�ʲ���������
		form.setVersion(ei.getVersion());//�汾��
		form.setDescription(ei.getDescription());//����
		form.setCreatetime(ei.getCreatetime());//����ʱ��
		form.setUpdatetime(ei.getUpdatetime());//����ʱ��
		form.setFingerPrint(ei.getFingerPrint());//ʱ���
		dto.addMessage(new ActionMessage("IGCO10000.I001", resources
				.getMessage(dto.getLocale(), "message.IGCIM02BLImpl.001")));
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
	public IGCIM02DTO handSnapshotAction(IGCIM02DTO dto) throws BLException {
		log.debug("========���ֶ��������ɴ���ʼ========");
		IGCIM0203Form form = dto.getIgcim0203Form();
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
			throw new BLException("IGCIM0205.E001");
		}
		log.debug("========���ֶ��������ɴ�������========");
		return dto;
	}
	

	/**
	 * ����̨��ʾ����
	 * 
	 * @param dto IGCIM02DTO
	 * @return IGCIM02DTO
	 * @throws BLException
	 */
	public IGCIM02DTO initIGCIM0201Action(IGCIM02DTO dto) throws BLException {
		log.debug("========����̨��ʾ����ʼ========");
		
		IGCIM0201Form form = dto.getIgcim0201Form();
		
		//������������
		SOC0115SearchCondImpl cond = new SOC0115SearchCondImpl();
		
		if("0".equals(form.getTaskDone())) {
			cond.setTaskDone(false);//δ���
		} else if("1".equals(form.getTaskDone())) {
			cond.setTaskDone(true);//�����
		} else {
			cond.setTaskError(true);//�쳣
		}
		cond.setDeleteflag_eq("0");//����
		
		//�����������б�
		List<SOC0115Info> eiWaitTaskList = this.soc0115BL.searchEiWaitTask(cond);
		
		try {
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
//					 List<File> files = Arrays.asList(ciFile.listFiles());
//					 //���ļ���������
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
						 //�ж��Ƿ����ļ�
						 if(file.isFile()) {
							 fileNames.add(file.getName());
						 }
					 }
				} else {
					throw new BLException("IGCIM0201.E002");
				}
			
				//���������б�
				SOC0120SearchCondImpl ivCond = new SOC0120SearchCondImpl();
				ivCond.setDeleteflag_eq("0");//����
				List<SOC0120Info> importVersionList = this.soc0120BL.searchImportVersion(ivCond);
				//����CI������Ϣ
				List<SOC0113Info> eiImportProgrammeInfoList=this.soc0113BL.searchEiImportProgramme();
				//�������汾��Ĭ����
				SOC0125Info eiDomainDefVWInfo=this.soc0125BL.searchEiDomainDefVW(CMDBConstants.EIDOMAINDEF_EIDDID);
				//��ǰʱ��
				String createTime = IGStringUtils.getCurrentDateTime();
				
				//�����ڵ��������б��д��ڣ����Ҳ��ڴ����������е��ļ�
				for(String fileName : fileNames) {
					checkCiImportFileName(fileName);//���ɼ��ļ����Ƿ�Ϸ�
					String ciName = fileName.substring(0, fileName.lastIndexOf("_"));//����CI����
					String typeNumber=fileName.split("\\(")[1].split("\\)")[0];//����CI����ID
				
					boolean flag = true;
					boolean impflag=true;
					if(eiWaitTaskList!=null&&eiWaitTaskList.size()>0){
						for(SOC0115Info ewt : eiWaitTaskList){
							//�ж��ļ��Ƿ��ڴ����������д���
							if(ewt.getEitfilename().equals(fileName)) {
								flag = false;
								break;
							}
						}
					}
					if(importVersionList!=null&&importVersionList.size()>0){
						for(SOC0120Info importVersionInfo:importVersionList){
							//�ж��ļ��Ƿ�Ǽǹ��������
							if(importVersionInfo.getImpeiname().equals(ciName)){
								impflag = false;
								break;
							}
						}
					}
					//��ӵ����������
					if(flag) {
						for(SOC0113Info eiImportProgrammeInfo:eiImportProgrammeInfoList){
							if(typeNumber.equals(Integer.toString(eiImportProgrammeInfo.getImpTypeid()))){
								SOC0113TB eiImportProgrammeTB=(SOC0113TB)SerializationUtils.clone(eiImportProgrammeInfo);
								SOC0115TB eiWaitTask = this.soc0115BL.getEiWaitTaskTBInstance();
								eiWaitTask.setEittopci(ciName);//����CI����
								eiWaitTask.setEitfilename(fileName);//�ļ���
								eiWaitTask.setEitcreatetime(createTime);//���񴴽�ʱ��
								eiWaitTask.setEitstatus(CMDBConstants.TASK_STATUS_WAIT);//������
								eiWaitTask.setImpTypeid(Integer.parseInt(typeNumber));//����CI����
								eiWaitTask.setEiImportProgrammeTB(eiImportProgrammeTB);//�����һ�β���ʹ������ʾ��Ӧ���ơ�
								this.soc0115BL.registEiWaitTask(eiWaitTask);
								log.debug("�����ļ�" + fileName);
								}
							}
						}
					//��ӵ���������
					if(impflag){
						SOC0120TB importVersionTB=new SOC0120TB();
						importVersionTB.setImpversion(0);//����CI�汾
						importVersionTB.setImpeiname(ciName);//����CI����
						importVersionTB.setImpeiid(0);//������ʲ�EIID
						importVersionTB.setImpcitype(Integer.parseInt(typeNumber));//����CI����
						importVersionTB.setDeleteflag("0");//Ĭ�ϱ�ʶ
						//ִ����ӵ��������
						this.soc0120BL.registImportVersion(importVersionTB);
						SOC0112TB eiDomainDetailTB=new SOC0112TB();
						eiDomainDetailTB.setEiddid(eiDomainDefVWInfo.getEiddid());//��ID
						eiDomainDetailTB.setEiddversion(eiDomainDefVWInfo.getVersion());//��汾
						eiDomainDetailTB.setEiname(ciName);//ʵ������
						eiDomainDetailTB.setCreatetime(IGStringUtils.getCurrentDateTime());//����ʱ��
						eiDomainDetailTB.setEiImportversion(0);//����汾
						eiDomainDetailTB.setDeleteflag("0");//Ĭ�ϱ�ʶ
						//����ʵ����ӵ�Ĭ������
						this.soc0112BL.registEiDomainDetail(eiDomainDetailTB);
					}
				}
				
				//��ѯ�����б�
				dto.setEiWaitTaskList(this.soc0115BL.searchEiWaitTask(cond));
			
			} else {//�����
				dto.setEiWaitTaskList(eiWaitTaskList);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			log.debug("����̨�쳣��"+e.getMessage());
			log.debug(e);
		}
		
		log.debug("========����̨��ʾ��������========");
		return dto;
	}
	
	/**
	 * ����̨����鿴����
	 * 
	 * @param dto IGCIM02DTO
	 * @return IGCIM02DTO
	 * @throws BLException
	 */
	public IGCIM02DTO initIGCIM0210Action(IGCIM02DTO dto) throws BLException {
		log.debug("========����̨����鿴����ʼ========");
		
		IGCIM0210Form form = dto.getIgcim0210Form();
		
		dto.setEiWaitTask(this.soc0115BL.searchEiWaitTaskByPK(form.getEitid()));
			
		log.debug("========����̨����鿴��������========");
		return dto;
	}
	
	/**
	 * ����������ɾ������
	 * 
	 * @param dto IGCIM02DTO
	 * @return IGCIM02DTO
	 * @throws BLException
	 */
	public IGCIM02DTO deleteEiWaitTaskAction(IGCIM02DTO dto) throws BLException {
		log.debug("========ɾ��������������ʼ========");
		
		IGCIM0201Form form = dto.getIgcim0201Form();
		
		String[] eitids = form.getEitids();//����
		
		//CI����Ӧ����Դ�ļ�
		Properties properties = this.getProperties();
		
		//CI�����ļ���·��
		String ciFilePath  = properties.getProperty("CI_IMPORT_FILE_PATH");
		
		//ɾ���������Ӧ�ļ�
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
		
		log.debug("========ɾ������������������========");
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
			throw new BLException("IGCIM0201.E003", fileName);
		}
	}

	/**
	 * �ʲ�����ɾ������
	 * 
	 * @param dto
	 */
	public IGCIM02DTO deleteEiDomainDefAction(IGCIM02DTO dto)
			throws BLException {
		log.debug("========�ʲ�������Ϣɾ������ʼ========");
		// ѭ��ɾ��
		for (int i = 0; i < dto.getDeleteEiddid().length; i++) {
			String key = dto.getDeleteEiddid()[i];
			String eiddid = key.split("_")[0];
//			String version = key.split("_")[1];
			List<SOC0111Info> eiDomainDefInfoList=this.soc0111BL.searchEiDomainDefByPK(Integer.parseInt(eiddid),null);
			// �ʲ�����ɾ������
			for(SOC0111Info eiDomainDefInfo:eiDomainDefInfoList){
			soc0111BL.deleteEiDomainDef(eiDomainDefInfo);
			}
		}
		dto.addMessage(new ActionMessage("IGCIM0204.I002"));
		log.debug("========�ʲ�������Ϣɾ����������========");
		return dto;
	}

	/**
	 * ����̨���봦��
	 * 
	 * @param dtoIGCIM02DTO
	 * @return IGCIM02DTO
	 * @throws BLException
	 */
	public IGCIM02DTO importIGCIM0201Action(IGCIM02DTO dto) throws BLException {
		log.debug("========����̨���봦��ʼ========");
		//ȡ�ð�װ·��
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
        //��form�еõ�����ei�������顢�����ļ������顢ʵ��������
//		String batNames = null;
//		String filenames = null;
//		String einames = null;
//		String eitidParms = null;
		for(int i =0 ;i<eitids.length;i++){
			String eitid = eitids[i];
			SOC0115Info eiWaitTaskInfo = soc0115BL.searchEiWaitTaskByPK(Integer.valueOf(eitid));
			
			//ͨ������ei����ȥ�������ݰ汾�������ȡ�ð汾�����������ݵĵ�������
			//ͨ�����ͣ��ӵ������������ȡ���������ļ��������Ŀ¼
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
			//������ʱ��
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
		    //����bat�ļ�ִ��
			java.lang.Runtime.getRuntime().exec(cmd);

		} catch (Exception e) {
			log.error("����Ӧ�ó�������ʧ��", e);
			throw new BLException("IGCIM0201.E005");
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
			throw new BLException("IGCIM0201.E001");
		} catch (IOException e) {
			log.error("CI����Ӧ����Դ�ļ���ȡ����", e);
			throw new BLException("IGCIM0201.E001");
		} finally {
			if(inputFile != null) {
				try {
					inputFile.close();
				} catch (IOException e) {
					log.error("CI����Ӧ����Դ�ļ���ȡ����", e);
					throw new BLException("IGCIM0201.E001");
				}
			}
		}
		return properties;
	}

	/**
	 * ���������Ϣ�ǼǴ���
	 */
	public IGCIM02DTO insertImportVersionAction(IGCIM02DTO dto)
			throws BLException {
		log.debug("========���������Ϣ�ǼǴ���ʼ========");
		// ����Formȡ��
		IGCIM0206Form form = dto.getIgcim0206Form();
		form.setImpversion(0);//�汾��
		form.setImpeiid(0);//ʵ��ID
		//�ʲ�ģ�Ͳ����
//		if(form.getImpcitype()==1){
//			form.setEsyscoding("999001001001");//����
//		}else if(form.getImpcitype()==2){
//			form.setEsyscoding("999001009001");//��������
//		}else if(form.getImpcitype()==3){
//			form.setEsyscoding("999003");//Ӧ���ʲ�
//		}else if(form.getImpcitype()==4){
//			form.setEsyscoding("999001006");//SAN������
//		}
		this.soc0120BL.registImportVersion(dto.getIgcim0206Form());
		// ������������Ϣ
		dto.addMessage(new ActionMessage("IGCO10000.I004", resources
				.getMessage(dto.getLocale(), "message.IGCIM02BLImpl.002")));
		log.debug("========���������Ϣ�ǼǴ�������========");
		return dto;
	}

	/**
	 * ���������Ϣ��ѯ����
	 */
	public IGCIM02DTO searchImportVersionAction(IGCIM02DTO dto) throws BLException {
		log.debug("========���������Ϣ��ѯ����ʼ========");

		// ���������Ϣ��ѯ����ȡ��
		int totalCount = this.soc0120BL.getSearchCount(dto
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
		List<SOC0120Info> importVersionInfoList = this.soc0120BL
				.searchImportVersion(dto.getImportVersionSearchCond(), pDto
						.getFromCount(), pDto.getPageDispCount());

		pDto.setTotalCount(totalCount);

		dto.setImportVersionInfoList(importVersionInfoList);

		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));

		log.debug("========���������Ϣ��ѯ��������========");
		return dto;
	}
	
	/**
	 * �ɼ���ѯ
	 * 
	 * @param dtoIGCIM02DTO
	 * @return IGCIM02DTO
	 */
	public IGCIM02DTO searchCr03Action(IGCIM02DTO dto) throws BLException{
		log.debug("========�ɼ���ѯ��ʼ========");
		//��ȡform
		IGCIM0802Form form=dto.getIgcim0802Form();
		
		//�ɼ��ļ���ѯ����
		CR03SearchCondImpl cr03Cond=new CR03SearchCondImpl();
		// ���������Ϣ��ѯ����ȡ��
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
			log.debug("========��ѯ���ݲ�����========");
			// ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}

		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========���������Ϣ��ѯ���ݼ�������========");
			// ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}

		// ��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();

		// ��ǰҳ���������Ϣȡ��
		List<CR03VWInfo> cr03VWInfoList = cr03BL.findByCondMaxAndEsyscoding(cr03Cond, pDto
						.getFromCount(), pDto.getPageDispCount());

		pDto.setTotalCount(totalCount);

		dto.setCr03VWInfoList(cr03VWInfoList);

		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		
		log.debug("========�ɼ���ѯ����========");
		return dto;
	}
	
	
	/**
	 * �ɼ�����̨��ѯ����
	 * @param dto IGCIM02DTO
	 * @throws BLException
	 */
	public IGCIM02DTO initIGCIM0214Action(IGCIM02DTO dto) throws BLException {
		log.debug("========�ɼ�����̨��Ϣ��ѯ����ʼ========");
		
		// ���������Ϣ��ѯ����ȡ��
		int totalCount = this.soc0120BL.getSearchCount(dto
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
		List<SOC0120Info> importVersionInfoList = this.soc0120BL
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
	public IGCIM02DTO deleteImportVersionAction(IGCIM02DTO dto) throws BLException {
		log.debug("========���������Ϣɾ������ʼ========");
		// ѭ��ɾ��
		for (int i = 0; i < dto.getDeleteImpeiid().length; i++) {
			String key = dto.getDeleteImpeiid()[i];
			String impeiname = key.split("_")[0];
			String impversion = key.split("_")[1];
			// �������ɾ������
			soc0120BL.deleteImportVersionByPK(new SOC0120PK(Integer.parseInt(impversion),impeiname));
		}
		dto.addMessage(new ActionMessage("IGCIM0204.I002"));
		log.debug("========���������Ϣɾ����������========");
		return dto;
	}

	/**
	 * �������״̬����
	 * @param dto
	 * @throws BLException
	 */
	public void changeDeleteFlagAction(IGCIM02DTO dto) throws BLException {
		log.debug("========�������״̬�仯����ʼ========");
		SOC0120Info importVersionInfo = soc0120BL.searchImportVersionByPK(new SOC0120PK(dto.getImpversion(),dto.getImpeiname()));
		SOC0120TB importVersionTB = (SOC0120TB)SerializationUtils.clone(importVersionInfo);
		if("0".equals(importVersionInfo.getDeleteflag())){
			importVersionTB.setDeleteflag("1");
		} else if ("1".equals(importVersionInfo.getDeleteflag())){
			importVersionTB.setDeleteflag("0");
		}
		soc0120BL.updateImportVersion(importVersionTB);
		log.debug("========�������״̬�仯�������========");
	}

	/**
	 * �����������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM02DTO getEiImportProgrammeAction(IGCIM02DTO dto) throws BLException {
		log.debug("========����������Ͳ�ѯ����ʼ========");
		List<SOC0113Info> impTypeInfoList=this.soc0113BL.searchEiImportProgramme();
		List<LabelValueBean> impTypeList = new ArrayList<LabelValueBean>();
		impTypeList.add(new LabelValueBean("",""));
		for(SOC0113Info info : impTypeInfoList){
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
	public IGCIM02DTO searchImportVersionIGCIM0210Action(IGCIM02DTO dto)
			throws BLException {
		log.debug("========�������汾��ѯ����ʼ========");
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
		log.debug("========�������汾��ѯ�������========");
		return dto;
	}

	/**
	 * �ʲ�����汾����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM02DTO searchIGCIM0212Action(IGCIM02DTO dto) throws BLException {
		log.debug("========�ʲ�����汾��ѯ����ʼ========");
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
		log.debug("========�ʲ�����汾��ѯ�������========");
		return dto;
	}

	/**
	 * ���°汾����Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM02DTO searchIGCIM0213Action(IGCIM02DTO dto) throws BLException {
		log.debug("========���°汾����Ϣ��ѯ����ʼ========");
		List<SOC0125Info> eiDomainDefVWInfoList=this.soc0125BL.searchEiDomainDefVW();
		List<LabelValueBean> domainList = new ArrayList<LabelValueBean>();
		domainList.add(new LabelValueBean("",""));
		for(SOC0125Info info : eiDomainDefVWInfoList){
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
	public IGCIM02DTO searchDoaminCiInfoAction(IGCIM02DTO dto)
			throws BLException {
		log.debug("========��CI��ѯ����ʼ========");
		IGCIM0213Form form=dto.getIgcim0213Form();
		
		Integer temp_eiid = 0;
		boolean flag=false;
		SOC0118Info ei=null;
		if(StringUtils.isNotEmpty(form.getEiid())){
			temp_eiid = Integer.valueOf(form.getEiid());
			//�ж��ʲ����ͣ����ΪDA����DISK����Ҫ���ҵ��������洢������CI����EIID���ٰ��ո�EIID������CI��ѯ
			if(temp_eiid > 0){
				ei = soc0118BL.searchEntityItemByKey(temp_eiid);
				if(ei!=null){
					//�ж��Ƿ�ΪӲ��
					if("999001013".equals(ei.getEsyscoding())){
						flag=true;
						dto.setEiid(temp_eiid);
					}
					//�ж��Ƿ�ΪDA
					if("999001012".equals(ei.getEsyscoding())){
						temp_eiid = ei.getEirootmark();
					}else{
						temp_eiid = 0;
					}
				}
			}
		}
		
		
		

		//�汾ȡ��
		if(StringUtils.isNotEmpty(form.getEiddid())){
			SOC0125Info eiDomainDefVWInfo=this.soc0125BL.searchEiDomainDefVW(form.getEiddid());
			form.setEiddversion(eiDomainDefVWInfo.getVersion().toString());
			dto.setEiDomainDetailVWSearchCond(form);
		}
		
		
		
		if(StringUtils.isNotEmpty(form.getEilabel())){
			if("1".equals(form.getTypeId())){
				//�����Ӳ��ʱ
				if(flag){
					searchCIInfoAction(dto);
				}else{
					int totalCount = this.soc0126BL.getSearchCountCI(dto
							.getEiDomainDetailVWSearchCond(),temp_eiid);
					
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
				// ��CI��ѯ����ȡ��
				int totalCount = this.soc0126BL.getSearchCount(dto
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
				List<SOC0138Info> eiDomainDetailCIOneInfoList = this.soc0126BL
						.searchEiDomainDetailVW(dto.getEiDomainDetailVWSearchCond(), pDto
								.getFromCount(), pDto.getPageDispCount());

				pDto.setTotalCount(totalCount);
				dto.setSOC0138InfoList(eiDomainDetailCIOneInfoList);

				dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
			}
			if("2".equals(form.getTypeId())){
				// ��CI��ѯ����ȡ��
				int totalCount = this.soc0126BL.getSearchCount(dto
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
				List<SOC0138Info> eiDomainDetailCIOneInfoList = this.soc0126BL
						.searchEiDomainDetailVW(dto.getEiDomainDetailVWSearchCond(), pDto
								.getFromCount(), pDto.getPageDispCount());

				pDto.setTotalCount(totalCount);
				dto.setSOC0138InfoList(eiDomainDetailCIOneInfoList);

				dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
			}
		}
		
		log.debug("========��CI��ѯ�������========");
		return dto;
	}

	/**
	 * ��Ӱ��CIΪӲ��ʱ��ֻ����������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM02DTO searchCIInfoAction(IGCIM02DTO dto) throws BLException {
		log.debug("========Ӳ��Ӱ���������ѯ����ʼ========");
		int totalCount = this.soc0126BL.getSearchCountCIByDisk(dto
				.getEiDomainDetailVWSearchCond(),dto.getEiid());
		
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
		List<SOC0136Info> eiDomainDetailCIInfoList = this.soc0126BL
				.searchEiDomainDetailVWCIByDisk(dto.getEiDomainDetailVWSearchCond(), pDto
						.getFromCount(), pDto.getPageDispCount(),dto.getEiid());

		pDto.setTotalCount(totalCount);
		dto.setSOC0136InfoList(eiDomainDetailCIInfoList);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		
		log.debug("========Ӳ��Ӱ���������ѯ�������========");
		return dto;
	}

	public IGCIM02DTO searchEiDomainDefActionNoPage(IGCIM02DTO dto)
			throws BLException {
		
		// ��ǰҳ�ʲ�������Ϣȡ��
		List<SOC0111Info> eiDomainDefInfoList = this.soc0111BL
				.searchEiDomainDef(dto.getEiDomainDefSearchCond());


		dto.setEiDomainDefInfoList(eiDomainDefInfoList);

		log.debug("========�ʲ�������Ϣ��ѯ��������========");
		return dto;
	}

	/**
	 * ԭʼ���ݵ��봦��
	 * 
	 * @param dto IGCIM02DTO
	 * @return IGCIM02DTO
	 * @throws BLException
	 */
	public IGCIM02DTO initIGCIM0803Action(IGCIM02DTO dto) throws BLException {

		log.debug("========����̨��ʾ����ʼ========");
		
		IGCIM0201Form form = dto.getIgcim0201Form();
		
		//������������
		CR03SearchCondImpl cr03Cond = new CR03SearchCondImpl();
		if(StringUtils.isNotEmpty(form.getImpcreatetime_s())){
			cr03Cond.setCollecttimeFrom(form.getImpcreatetime_s().replace("/", "")+"000000");
		}
		if(StringUtils.isNotEmpty(form.getImpcreatetime_e())){
			cr03Cond.setCollecttimeTo(form.getImpcreatetime_e().replace("/", "")+"999999");
		}
		cr03Cond.setStatus(form.getStatus());
		
		//�����������б�
		//List<SOC0115Info> eiWaitTaskList = this.soc0115BL.searchEiWaitTask();
		
		try {	
				//�����������б�
//				List<CR03Info> cr03List = this.cr03BL.searchCR03(cr03Cond);
				List<CR03Info> cr03List = this.cr03BL.findByCondMax(cr03Cond,0,0);
				
				//���������б�
				SOC0120SearchCondImpl ivCond = new SOC0120SearchCondImpl();
				//ivCond.setDeleteflag_eq("0");//����
				List<SOC0120Info> importVersionList = this.soc0120BL.searchImportVersion(ivCond);
				//����CI������Ϣ
				List<SOC0113Info> eiImportProgrammeInfoList=this.soc0113BL.searchEiImportProgramme();
				//�������汾��Ĭ����
				SOC0125Info eiDomainDefVWInfo=this.soc0125BL.searchEiDomainDefVW(CMDBConstants.EIDOMAINDEF_EIDDID);
				
				List<SOC0120TB> ivlist = new ArrayList<SOC0120TB>();
				//�����ڵ��������б��д��ڣ����Ҳ��ڴ����������е��ļ�
				List<CR03Info> removecr03List = new ArrayList<CR03Info>();
				for(CR03Info cr03Info : cr03List) {
					//checkCiImportFileName(fileName);//���ɼ��ļ����Ƿ�Ϸ�
					String ciName = cr03Info.getHost();
					Integer typeNumber = cr03Info.getType();//����CI����ID
					String tableName = cr03Info.getTablename();
					String collecttime = cr03Info.getCollecttime().trim();
					String ip = cr03Info.getIp();
					String servername = cr03Info.getServername();
					boolean flag = true;
					boolean impflag=true;
					if(importVersionList!=null&&importVersionList.size()>0){
						for(SOC0120Info importVersionInfo:importVersionList){
							//�ж��ļ��Ƿ�Ǽǹ��������
							if(importVersionInfo.getImpeiname().equals(ciName)){
								impflag = false;
								if(importVersionInfo.getDeleteflag().equals("1"))
									removecr03List.add(cr03Info);
								break;
							}
						}
					}
					//��ӵ����������
					if(flag) {
						for(SOC0113Info eiImportProgrammeInfo:eiImportProgrammeInfoList){
							if(typeNumber.equals(eiImportProgrammeInfo.getImpTypeid())){
								SOC0113TB eiImportProgrammeTB=(SOC0113TB)SerializationUtils.clone(eiImportProgrammeInfo);
								SOC0115TB eiWaitTask = this.soc0115BL.getEiWaitTaskTBInstance();
								eiWaitTask.setEittopci(ciName);//����CI����
								eiWaitTask.setEitfilename(ciName+"#"+ip+"#"+servername);//�ļ���
								eiWaitTask.setEitcreatetime(collecttime);//���񴴽�ʱ��
								eiWaitTask.setEitstatus(CMDBConstants.TASK_STATUS_WAIT);//������
								eiWaitTask.setImpTypeid(typeNumber);//����CI����
								eiWaitTask.setEiImportProgrammeTB(eiImportProgrammeTB);//�����һ�β���ʹ������ʾ��Ӧ���ơ�
								eiWaitTask.setFingerPrint(tableName);
								if(StringUtils.isEmpty(cr03Info.getFingerPrint())) {
									this.soc0115BL.registEiWaitTask(eiWaitTask);
								}
								log.debug("�����ļ�" + ciName);
								}
							}
						}
					//��ӵ���������
					if(impflag){
						SOC0120TB importVersionTB=new SOC0120TB();
						importVersionTB.setImpversion(0);//����CI�汾
						importVersionTB.setImpeiname(ciName);//����CI����
						importVersionTB.setImpeiid(0);//������ʲ�EIID
						importVersionTB.setImpcitype(typeNumber);//����CI����
						importVersionTB.setDeleteflag("0");//Ĭ�ϱ�ʶ
						//ִ����ӵ��������
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
						eiDomainDetailTB.setEiddid(eiDomainDefVWInfo.getEiddid());//��ID
						eiDomainDetailTB.setEiddversion(eiDomainDefVWInfo.getVersion());//��汾
						eiDomainDetailTB.setEiname(ciName);//ʵ������
						eiDomainDetailTB.setCreatetime(IGStringUtils.getCurrentDateTime());//����ʱ��
						eiDomainDetailTB.setEiImportversion(0);//����汾
						eiDomainDetailTB.setDeleteflag("0");//Ĭ�ϱ�ʶ
						//����ʵ����ӵ�Ĭ������
						this.soc0112BL.registEiDomainDetail(eiDomainDetailTB);
					}
				}
				//ɾ��list���Ѿ�ͣ�õĶ���
				cr03List.removeAll(removecr03List);
				//��ѯ�����б�
				dto.setCr03InfoList(cr03List);
				dto.setEiWaitTaskList(this.soc0115BL.searchEiWaitTask());			
		} catch (NumberFormatException e) {
			e.printStackTrace();
			log.debug("����̨�쳣��"+e.getMessage());
			log.debug(e);
		}
		
		log.debug("========����̨��ʾ��������========");
		return dto;
	}
	/**
	 * ����CR03״̬
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
	 * ����̨���봦��
	 * 
	 * @param dtoIGCIM02DTO
	 * @return IGCIM02DTO
	 * @throws BLException
	 */
	public IGCIM02DTO importIGCIM0803Action(IGCIM02DTO dto) throws BLException {
		log.debug("========����̨���봦��ʼ========");
		
		//ȡ�ð�װ·��
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
        //��form�еõ�����ei�������顢�����ļ������顢ʵ��������
		for(int i =0 ;i<eitids.length;i++){
			String eitid = eitids[i];
			SOC0115Info eiWaitTaskInfo = soc0115BL.searchEiWaitTaskByPK(Integer.valueOf(eitid));
			
			//ͨ������ei����ȥ�������ݰ汾�������ȡ�ð汾�����������ݵĵ�������
			//ͨ�����ͣ��ӵ������������ȡ���������ļ��������Ŀ¼
			SOC0120SearchCondImpl cond = new SOC0120SearchCondImpl();
			cond.setImpeiname(eiWaitTaskInfo.getEittopci());
			String filename = eiWaitTaskInfo.getEitfilename()+"_"+eiWaitTaskInfo.getEitcreatetime().trim()+"("+eiWaitTaskInfo.getImpTypeid()+")";
			String einame = eiWaitTaskInfo.getEittopci();
			String tableName = eiWaitTaskInfo.getFingerPrint();
			User user = dto.getUser();
			String userId = user.getUserid()+"!"+user.getUsername();
			//������ʱ��
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
			log.error("����Ӧ�ó�������ʧ��", e);
			throw new BLException("IGCIM0201.E005");
		}finally{
			//closeHQServer();
		}
		log.debug("========����̨���봦������========");
		return dto;
	}
	/**
	 * ����������ɾ������
	 * 
	 * @param dto IGCIM02DTO
	 * @return IGCIM02DTO
	 * @throws BLException
	 */
	public IGCIM02DTO deleteEiWaitTaskAction0803(IGCIM02DTO dto) throws BLException {
		log.debug("========ɾ��������������ʼ========");

		IGCIM0201Form form = dto.getIgcim0201Form();
		
		String[] eitids = form.getEitids();//����
		
		//ɾ���������Ӧ�ļ�
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
		
		log.debug("========ɾ������������������========");
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
