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
 * @Description: �������ù���ҵ���߼�ʵ��
 * @Author  
 * @History 2009-8-18     �½�
 * @History 2010-5-07     0000428: ���ӻ������Թ���
 * @Version V2.0
 */
public class IGASM11BLImpl extends BaseBLImpl implements IGASM11BL {

	static Log log = LogFactory.getLog(IGASM11BLImpl.class);

	/** �ʲ���ϢBL */
	protected SOC0117BL soc0117BL;

	/** �ʲ�����ϢBL */
	protected SOC0118BL soc0118BL;
	
	/** �ʲ�������BL */
	protected SOC0107BL soc0107BL;
	
	/** �ʲ����ϵBL */
	protected SOC0119BL soc0119BL;
	
	/** ������ͼBL */
	protected SOC0601BL soc0601BL;
	
	/** �ʲ�����BL */
	protected SOC0109BL soc0109BL;
	
	/** ������ͼBL */
	protected SOC0603BL soc0603BL;
	
	/** �豸��ͼBL */
	protected SOC0602BL soc0602BL;
	
	/** �ļ��ϴ�BL */
	protected FileUploadBL fileUploadBL;
	
	protected CompareTemplateBL compareTemplateBL;
	
	/** 3D����֧��IP��ѯBL */
	protected EquipmentInquireVWBL equipmentInquireVWBL;
	
	/** �ʲ�ȡֵ��Χ��������BL */
	protected IG545BL ig545BL;
	
	/** ��ظ澯ip��ͼBL */
	protected MonitoringAlarmIPVWBL monitoringAlarmIPVWBL;
	
	/** ͬ���澯ϵͳ��ͼBL */
	protected SynchronizationAlarmSystemVWBL synchronizationAlarmSystemVWBL;
	
	/** �澯ϵͳ��ʾ��ϢBL */
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
	 * ��ظ澯ip��ͼBL�趨
	 */
	public void setMonitoringAlarmIPVWBL(MonitoringAlarmIPVWBL monitoringAlarmIPVWBL) {
		this.monitoringAlarmIPVWBL = monitoringAlarmIPVWBL;
	}
	
	/**
	 * ͬ���澯ϵͳ��ͼBL�趨
	 */
	public void setSynchronizationAlarmSystemVWBL(
			SynchronizationAlarmSystemVWBL synchronizationAlarmSystemVWBL) {
		this.synchronizationAlarmSystemVWBL = synchronizationAlarmSystemVWBL;
	}

	/**
	 * �澯ϵͳ��ʾ��ϢBL�趨
	 */
	public void setIndicatorLightsSystemBL(
			IndicatorLightsSystemBL indicatorLightsSystemBL) {
		this.indicatorLightsSystemBL = indicatorLightsSystemBL;
	}

	/**
	 * �����б��������ʾ
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO initIGASM1101Action(IGASM11DTO dto) throws BLException {

		log.debug("========�����б��������ʾ����ʼ========");
		
		//������Ϣ��ѯ����ȡ�� 
		SOC0601SearchCondImpl cond = new SOC0601SearchCondImpl();
		
		int totalCount = this.soc0601BL.getSOC0601InfoSearchCount(cond);
		
		if (totalCount == 0) {
			log.debug("========������Ϣ��ѯ���ݲ�����========");
			//������Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========������Ϣ��ѯ���ݼ�������========");
			//������Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();
		pDto.setTotalCount(totalCount);

		//��ǰҳ������Ϣȡ��
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
		
		log.debug("========�����б��������ʾ��������========");
		return dto;
	}

	/**
	 * ������Ϣ�༭���������ʾ
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO initIGASM1102Action(IGASM11DTO dto) throws BLException {
		log.debug("========������Ϣ�༭���������ʾ����ʼ========");
		
		IGASM1102Form form = dto.getIgasm1102Form();
		
		//����esyscodingΪ999007
		SOC0117SearchCondImpl econd = new SOC0117SearchCondImpl();
		econd.setEsyscoding("999007");
		econd.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_ROOM);
		List<SOC0117Info> li = this.soc0117BL.searchEntity(econd);
		//�������������͵Ǽ�,��ϢΨһ,ȡeid
		SOC0117Info entity = li.get(0);
		SOC0109SearchCondImpl cond = new SOC0109SearchCondImpl();
		cond.setEid(entity.getEid().toString());
		cond.setCstatus("1");
		//ȡ������������
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
		dto.addMessage(new ActionMessage("IGCO10000.I001","������Ϣ"));
		
		log.debug("========������Ϣ�༭���������ʾ��������========");
		return dto;

	}

	/**
	 * ������Ϣ�༭���������ʾ
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO initEditIGASM1102Action(IGASM11DTO dto) throws BLException {
		log.debug("========������Ϣ�༭���������ʾ����ʼ========");
		
		IGASM1102Form form = dto.getIgasm1102Form();
		
		//������Ϣ����
		SOC0605Info entityItemVWInfo = this.soc0118BL.searchSOC0605InfoByKey(form.getEiid());
		
		SOC0606SearchCondImpl ciVW = new SOC0606SearchCondImpl();
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","����");
		}

//		ciVW.setEiid(entityItemVWInfo.getEiid().toString());
		ciVW.setEiid(String.valueOf(entityItemVWInfo.getEiid()));
		form.setEilabel(entityItemVWInfo.getEilabel());
		form.setEiname(entityItemVWInfo.getEiname());
		form.setEiinsdate(entityItemVWInfo.getEiinsdate());
		form.setEidesc(entityItemVWInfo.getEidesc());
		dto.setEntityItemVWInfo(entityItemVWInfo);
		ciVW.setEsyscoding_q("999007");
		
		//����������Ϣ��ѯ����ȡ�� 
		int totalCount = this.soc0107BL.getSOC0606InfoSearchCount(ciVW);
		
		if (totalCount == 0) {
			log.debug("========����������Ϣ��ѯ���ݲ�����========");
			//����������Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I007",0));
			return dto;
		} 
		
//		if ( totalCount > dto.getMaxSearchCount() ) {
//			log.debug("========����������Ϣ��ѯ���ݼ�������========");
//			//����������Ϣ��ѯ���ݼ�������
//			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
//			return dto;
//		}
		
		//����������Ϣȫ����ѯ
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
		dto.addMessage(new ActionMessage("IGCO10000.I001","������Ϣ"));
		
		log.debug("========������Ϣ�༭���������ʾ��������========");
		return dto;
		
	}
	
	/**
	 * ������Ϣ�ǼǴ���
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 * @update 0000428
	 */
	public IGASM11DTO insertComputerRoomInfoAction(IGASM11DTO dto) throws BLException, FileNotFoundException, IOException{
		log.debug("========������Ϣ�ǼǴ���ʼ========");
		
		//=============>   �޸�  0000428
		//1.����Formȡ��
		IGASM1102Form form = dto.getIgasm1102Form();
		
		//2.�ʲ�����IDȡ��
		SOC0117SearchCondImpl cond = new SOC0117SearchCondImpl();
		cond.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_ROOM);
		cond.setEsyscoding("999007");
		
		//�ǼǴ���ǰ���ʲ���Ϣȷ��
		List<SOC0117Info> entityList = this.soc0117BL.searchEntity(cond, 0, 0);
		
		if ( entityList == null || entityList.size() ==0 ) {
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","�����ʲ�����");
		}
		
		SOC0117Info entity = entityList.get(0);
		
		form.setEid(entity.getEid());
		form.setEidStr(entity.getEid().toString());
		
		//3.����ʱ���趨
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		
		form.setEiupdtime(datetime);
		//4.�汾�趨���̶���Ϊ1��
		form.setEiversion(1);
		
		//С�汾�趨���̶���Ϊ0��
		form.setEismallversion(0);
		form.setEiidStr(null);
		
		form.setEiuserid(dto.getUser().getUserid());
		form.setEiusername(dto.getUser().getUsername());
		//5.������Ϣ��¼
		SOC0118Info ei = this.soc0118BL.registEntityItem(form);	

		
//--------------------------------------------------
			
		for( int i=0 ; i < form.getCid().length; i++ ){
			SOC0107TB configItem = new SOC0107TB();
			//����ID
			configItem.setEiid(ei.getEiid());
			//�ʲ�����ID
			configItem.setCid(form.getCid()[i]);
			//����ID
			configItem.setEid(form.getEid());
			//���Ͳ����
			configItem.setEsyscoding("999007");
			//����
			configItem.setCivalue(form.getCivalue()[i]);
			//����ʱ��
			configItem.setCiupdtime(datetime);
			//�汾Ϊ1
			configItem.setCiversion(1);
			configItem.setCismallversion(0);
			configItem = (SOC0107TB) this.soc0107BL.registSOC0107(configItem);
			
			log.debug("�ʲ������[�ʲ�����ID:" + form.getCid()[i] + "]�ǼǴ���ɹ���");
			
			
			//�ϴ��ļ����
			if (form.getCiattach()[i].toUpperCase().equals("1")) {
				FormFile file = form.getAttachFile(i);
				if ( file != null && file.getFileSize() > 0) {
					//�ϴ��ļ����ڵ����
					//�ϴ��ļ�·��
					String rootPath = ResourceUtility.getString("UPLOAD_FILE_ROOT_PATH");
					StringBuffer pathBuf = new StringBuffer();
					
					//��Ŀ¼
					pathBuf.append(rootPath);
					//����ID
					pathBuf.append("asm"+File.separator);
					//����ID
					pathBuf.append(configItem.getEiid());
					pathBuf.append(File.separator);
					
					StringBuffer fileName = new StringBuffer();
					
					//��չ��ȡ��
					String fileType = "";
					String sFileName = file.getFileName();
					int point = sFileName.lastIndexOf(".");
					if (point != -1) {
						fileType = sFileName.substring(point);
						fileName.append(sFileName.substring(0, point));
					}
					
					//�ļ�����Ӱ汾��
					fileName.append("_");
					fileName.append(configItem.getCiversion());
					//�ļ���չ��
					fileName.append(fileType);

					//�ļ��ϴ�����
					this.fileUploadBL.saveFile(file, pathBuf.toString(), fileName.toString());
					
					//�ϴ��ļ�������
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
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "������Ϣ") );

		log.debug("========������Ϣ�ǼǴ�������========");
		return dto;
	}

	/**
	 * ������Ϣ�༭���������ʾ
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO updateComputerRoomAction(IGASM11DTO dto) throws BLException, FileNotFoundException, IOException {
		
		log.debug("========������Ϣ���´���ʼ========");
		//1.����Formȡ��
		IGASM1102Form form = dto.getIgasm1102Form();
		
		//2.�ʲ�����IDȡ��
		SOC0117SearchCondImpl cond = new SOC0117SearchCondImpl();
		cond.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_ROOM);
		cond.setEsyscoding("999007");
		
		//�ǼǴ���ǰ���ʲ���Ϣȷ��
		List<SOC0117Info> entityList = this.soc0117BL.searchEntity(cond, 0, 0);
		
		if ( entityList == null || entityList.size() ==0 ) {
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","�����ʲ�����");
		}
		
		SOC0117Info entity = entityList.get(0);
		
		form.setEid(entity.getEid());
		form.setEidStr(entity.getEid().toString());
		
		//3.����ʱ���趨
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		
		form.setEiupdtime(datetime);
		
		//4.�汾�趨���̶���Ϊ1��
		form.setEiversion(1);
		form.setEiidStr(null);
		

		
//--------------------------------------------------
		//����������Ϣ����
		if (form.getCiid() != null && form.getCiid().length > 0 ) {		
			
			for( int i=0 ; i < form.getCiid().length; i++ ){
				SOC0107TB configItem = new SOC0107TB();
				//����ID
				configItem.setEiid(form.getEiid());
				//�ʲ�����ID
				configItem.setCid(form.getCid()[i]);
				//����ID
				configItem.setEid(form.getEid());
				//���Ͳ����
				configItem.setEsyscoding("999007");
				//����
				configItem.setCivalue(form.getCivalue()[i]);
				//����ʱ��
				configItem.setCiupdtime(datetime);
				//��汾��
				configItem.setCiversion(1);
				//С�汾��
				configItem.setCismallversion(0);
				//����ɾ��
				if("1".equals(form.getCiattach()[i]) && "1".equals(form.getDelfile()[i])){
					configItem.setCivalue("");
				}
				if(StringUtils.isEmpty(form.getCiid()[i])){
					configItem = (SOC0107TB) this.soc0107BL.registSOC0107(configItem);
				}else{
					configItem.setCiid(Integer.parseInt(form.getCiid()[i]));
				}
				//���»�����Ϣ
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
				
				
				//�ϴ��ļ����
				if (form.getCiattach()[i].toUpperCase().equals("1")) {
					FormFile file = form.getAttachFile(i);
					if ( file != null && file.getFileSize() > 0) {
						//�ϴ��ļ����ڵ����
						//�ϴ��ļ�·��
						String rootPath = ResourceUtility.getString("UPLOAD_FILE_ROOT_PATH");
						StringBuffer pathBuf = new StringBuffer();
						
						//��Ŀ¼
						pathBuf.append(rootPath);
						//����ID
						pathBuf.append("asm"+File.separator);
						//����ID
						pathBuf.append(configItem.getEiid());
						pathBuf.append(File.separator);
						
						StringBuffer fileName = new StringBuffer();
						
						//��չ��ȡ��
						String fileType = "";
						String sFileName = file.getFileName();
						int point = sFileName.lastIndexOf(".");
						if (point != -1) {
							fileType = sFileName.substring(point);
							fileName.append(sFileName.substring(0, point));
						}
						
						//�ļ�����Ӱ汾��
						fileName.append("_");
						fileName.append(configItem.getCiversion());
						//�ļ���չ��
						fileName.append(fileType);

						//�ļ��ϴ�����
						this.fileUploadBL.saveFile(file, pathBuf.toString(), fileName.toString());
						
						//�ϴ��ļ�������
						configItem.setCivalue(fileName.toString());
						
						this.soc0107BL.updateSOC0107(configItem);					
						
					}
				}
			}
		}
//---------------------------------------------------------
		
		
//		form.setEiidStr(entityItem.getEiid().toString());
		
		dto.setIgasm1102Form(form);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "������Ϣ") );

		log.debug("========������Ϣ���´�������========");
		return dto;
	}
	
	/**
	 * ������Ϣ�ǼǴ���
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO insertComputerContainerInfoAction(IGASM11DTO dto) throws BLException {
		log.debug("========������Ϣ�ǼǴ���ʼ========");
		//1.����Formȡ��
		IGASM1112Form form = dto.getIgasm1112Form();
		
		//2.�ʲ�����IDȡ��
		SOC0117SearchCondImpl cond = new SOC0117SearchCondImpl();
		cond.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_CONTAINER);
		cond.setEcategory_q(CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_CONTAINER);
		
		//�ǼǴ���ǰ���ʲ���Ϣȷ��
		List<SOC0117Info> entityList = this.soc0117BL.searchEntity(cond, 0, 0);
		
		if ( entityList == null || entityList.size() ==0 ) {
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","�����ʲ�����");
		}
		
		SOC0117Info entity = entityList.get(0);
		
		form.setEid(entity.getEid());
		form.setEidStr(entity.getEid().toString());
		
		//3.����ʱ���趨
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		
		form.setEiupdtime(datetime);
		
		//��汾�趨���̶���Ϊ1��
		form.setEiversion(1);
		
		//С�汾�趨���̶���Ϊ0��
		form.setEismallversion(0);
		
		form.setEiidStr(null);

		//5.������Ϣ��¼
		SOC0118Info entityItem = this.soc0118BL.registEntityItem(dto.getIgasm1112Form());
		
		if(EntityItemKeyWords.VALUE_PULLDOWN.equals(form.getEimark()))
		{   
			//6.1������������������
			insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_L_TOTAL,
					form.getEimark(),"����","��������",1,datetime);
			
			//6.1����λ�ã�X������������
			insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_X_VALUE,
					form.getX_value(),"����","������λ�ã�X��",1,datetime);
			
			//6.2����λ�ã�Y������������
			insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_Y_VALUE,
					form.getY_value(),"����","������λ�ã�Y��",1,datetime);
			
			//6.3���ܸ߶ȣ�U������������
			insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_U_TOTAL,
					form.getJ_total(),"����","���ܸ߶ȣ�U��",1,datetime);
			//6.3���ܿ�ȣ�W������������
			insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_W_TOTAL,
					form.getW_total(),"����","���ܿ�ȣ�W��",1,datetime);
			//6.4������������������
			insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_X_WIDTH,
					form.getX_width(),"����","���ܺ����",1,datetime);
			//6.5�������������������
			insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_Y_WIDTH,
					form.getY_width(),"����","���������",1,datetime);
			
			insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_GRAPHSTATUS,
	                 "0", "����","�����ϼ�����",1,datetime);
			////6.7�����ϼ���������
			insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_GRAPHINDEX,
				"0","����","���ܲ�����",1,datetime);
			
			////6.8�����ڻ����λ��
			insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_WZ_VALUE,
				"0","����","����λ������",1,datetime);
			
			//6.9�������������
	        insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_MAXLOAD,
	                form.getMaxload(),"����","�������������",1,datetime);

	        //6.10��������������
	        insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_MAXPOWER,
	                form.getMaxpower(),"����","��������������",1,datetime);
		}
		else 
		{
		//6.1������������������
			insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_L_TOTAL,
					form.getEimark(),"����","��������",1,datetime);
		//6.1����λ�ã�X������������
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_X_VALUE,
				form.getX_value(),"����","����λ�ã�X��",1,datetime);
		
		//6.2����λ�ã�Y������������
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_Y_VALUE,
				form.getY_value(),"����","����λ�ã�Y��",1,datetime);
		
		//6.3����߶ȣ�U������������
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_U_TOTAL,
				form.getU_total(),"����","����߶ȣ�U��",1,datetime);
		
		//6.4������������������
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_X_WIDTH,
				form.getX_width(),"����","��������",1,datetime);

		//6.5�������������������
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_Y_WIDTH,
				form.getY_width(),"����","���������",1,datetime);
		
//		//6.6�����ϼ���������
		
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_GRAPHSTATUS,
				                 "0", "����","�����ϼ�����",1,datetime);
//		
//		//6.7�����ϼ���������
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_GRAPHINDEX,
				"0","����","���������",1,datetime);
//		
		//6.10�����ѹ��������
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_VOLTAGE,
				form.getVoltage(),"����","�����ѹ����",1,datetime);
		
		//6.8������������
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_WEIGHT,
				form.getWeight(),"����","������������",1,datetime);
		
		//6.9��������������
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_STANDARD,
				form.getStandard(),"����","����������",1,datetime);
		
		//6.11�������������
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_MAXLOAD,
		        form.getMaxload(),"����","�������������",1,datetime);

		//6.12��������������
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_MAXPOWER,
		        form.getMaxpower(),"����","��������������",1,datetime);
		}
		
		form.setEiidStr(entityItem.getEiid().toString());
		
		dto.setIgasm1112Form(form);
		
		if(EntityItemKeyWords.VALUE_PULLDOWN.equals(form.getEimark()))
		{
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "������Ϣ") );
		}
		else
		{
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "������Ϣ") );
		}

		log.debug("========������Ϣ�ǼǴ�������========");
		return dto;
	}

	/**
	 * ��������Ϣ��Ӵ���
	 *
	 * @param entityItem EntityItem �ʲ���
	 * @param clabel String ���ñ��
	 * @param civalue String ����ֵ
	 * @param sErrParam0 String ������Ϣ����0
	 * @param sErrParam1 String ������Ϣ����1 
	 * @param civersion Integer ���ð汾
	 * @return
	 */
	protected void insertConfigItem(SOC0118Info entityItem,
			String clabel,String civalue,String sErrParam0,String sErrParam1,
			Integer civersion) throws BLException {
		//1.��ѯ��������
		SOC0109SearchCondImpl configCond = new SOC0109SearchCondImpl();
		//configCond.setEid(entityItem.getEid().toString());
		configCond.setClabel(clabel);
		
		//2.�������ѯ
		List<SOC0109Info> configList = this.soc0109BL.searchConfiguration(configCond, 0, 0);
		
		if ( configList == null || configList.size()==0 ) {
			throw new BLException("IGCO10000.E013",sErrParam0,sErrParam1);
		}
		
		//2.��������������
		SOC0107TB configItemTB = new SOC0107TB();
		
		//�ʲ���ID
		configItemTB.setEiid(entityItem.getEiid());
		//�ʲ�ID
		configItemTB.setEid(entityItem.getEid());
		//�ʲ�����ID
		configItemTB.setCid(configList.get(0).getCid());
		//�ʲ�����ֵ
		configItemTB.setCivalue(civalue);
		
		//�ʲ����ð汾
		configItemTB.setCiversion(civersion);
		
		if(EntityItemKeyWords.CLABEL_U_VALUE.equals(clabel)) {
			//���Ը��±�ʶ
			configItemTB.setCicurver("1");
		} else {
			//���Ը��±�ʶ
			configItemTB.setCicurver("0");
		}
		
		//�ʲ����ø���ʱ��
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		
		configItemTB.setCiupdtime(datetime);
		
		//3.������Ϣ�Ǽ�
		this.soc0107BL.registSOC0107(configItemTB);
		
	}
	protected void insertConfigItem(SOC0118Info entityItem,
			String clabel,String civalue,String sErrParam0,String sErrParam1,
			Integer civersion, String nowdate) throws BLException {
		//1.��ѯ��������
		SOC0109SearchCondImpl configCond = new SOC0109SearchCondImpl();
		//configCond.setEid(entityItem.getEid().toString());
		configCond.setClabel(clabel);
		
		//2.�������ѯ
		List<SOC0109Info> configList = this.soc0109BL.searchConfiguration(configCond, 0, 0);
		
		if ( configList == null || configList.size()==0 ) {
			throw new BLException("IGCO10000.E013",sErrParam0,sErrParam1);
		}
		
		//2.��������������
		SOC0107TB configItemTB = new SOC0107TB();
		
		//�ʲ���ID
		configItemTB.setEiid(entityItem.getEiid());
		//�ʲ�ID
		configItemTB.setEid(entityItem.getEid());
		//�ʲ�����ID
		configItemTB.setCid(configList.get(0).getCid());
		//�ʲ�����ֵ
		configItemTB.setCivalue(civalue);
		
		//�ʲ����ð汾
		configItemTB.setCiversion(civersion);
		
		//�ʲ����ø���ʱ��
		configItemTB.setCiupdtime(nowdate);
		
		configItemTB.setCismallversion(0);
		
		//3.������Ϣ�Ǽ�
		this.soc0107BL.registSOC0107(configItemTB);
		
	}
	/**
	 * ������Ϣɾ������
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO deleteComputerRoomInfoAction(IGASM11DTO dto) throws BLException {
		log.debug("========������Ϣɾ������ʼ========");
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
			
			//ɾ��ǰɾ���������ȷ��
			SOC0118Info entityItem = this.soc0118BL.searchEntityItemByKey(Integer.parseInt(eiid));
			
			if (entityItem == null){
				throw new BLException("IGCO10000.E004","ɾ���������");
			}

			//����ɾ��
			this.soc0118BL.deleteEntityItem(entityItem);
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I006","������Ϣ"));

		log.debug("========������Ϣɾ����������========");
		return dto;
	}

	/**
	 * �����Ƴ�����
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO moveoutComputerContainerAction(IGASM11DTO dto) throws BLException {
		log.debug("========�����Ƴ�����ʼ========");
		IGASM1104Form form = dto.getIgasm1104Form();

		//1.�����趨��Ϣ����
		SOC0119SearchCondImpl cond = 
			new SOC0119SearchCondImpl();
		//����ID
//		cond.setPareiid(form.getEiid());
		cond.setPareiid(Integer.parseInt(form.getEiid()));
		//����ID�趨
//		cond.setCldeiid(form.getContainer_eiid());
		cond.setCldeiid(Integer.parseInt(form.getContainer_eiid()));
		
		//����ͻ�����������ϵ�趨
		cond.setEirrelation(CommonDefineUtils.ROOM_CONTAINER_ASSIGN_RELATION);
		
		List<SOC0119Info> entityItemRelationList = 
			this.soc0119BL.searchMaxEntityItemRelation(cond);
		
		//2.���й�ϵɾ��
		if (entityItemRelationList != null && entityItemRelationList.size()>0 ) {
			for (SOC0119Info res:entityItemRelationList) {
				this.soc0119BL.deleteEntityItemRelation(res);
			}
		}
		
		//3.������Ϣȡ��
		SOC0118Info entityItem = 
			this.soc0118BL.searchEntityItemByKey(Integer.parseInt(form.getContainer_eiid()));
		
		if (entityItem == null) {
			throw new BLException("IGCO10000.E004","����");
		}
		
		//4.��ǰ�汾ȡ��
		Integer cur_version = entityItem.getEiversion();
		
		//5.��ǰ������Ϣȡ��
		SOC0107SearchCondImpl ciCond = new SOC0107SearchCondImpl();
		
//		ciCond.setEiid(form.getContainer_eiid());
		ciCond.setEiid(form.getContainer_eiid());
		ciCond.setCiversion(cur_version.toString());
		
		List<SOC0107Info> configItemList = 
			this.soc0107BL.searchSOC0107(ciCond, 0, 0);
		
		//����ʱ���趨
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

		//6.����λ��������������ð汾��Ϣ����
		if (configItemList!=null && configItemList.size()>0) {
			//�汾����
			for (SOC0107Info item:configItemList) {
				String clabel = item.getConfiguration().getClabel();
				//����λ����������ð汾����
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
		
		//7.����λ�ã�X������������
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_X_VALUE,
				"","����","����λ�ã�X��",cur_version+1,datetime);
		
		//8.����λ�ã�Y������������
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_Y_VALUE,
				"","����","����λ�ã�Y��",cur_version+1,datetime);
		
		//9.����汾����
		SOC0118TB entityItemTB = (SOC0118TB)entityItem;
		
		entityItemTB.setEiversion(cur_version+1);
		
		this.soc0118BL.updateEntityItem(entityItemTB);
		
		log.debug("========�����Ƴ���������========");
		
		return dto;
	}
	
	/**
	 * ����ƽ��ͼ��������ڻ�����
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO initIGASM1104Action(IGASM11DTO dto) throws BLException {

		log.debug("========����ƽ��ͼ��������ڻ�����ʼ========");
		
		IGASM1104Form form = dto.getIgasm1104Form();
		
		//1.������Ϣ����
		SOC0601Info computerRoomVWInfo = 
			this.soc0601BL.searchSOC0601InfoByKey(form.getEiid());
		
		if ( computerRoomVWInfo == null) {
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","����");
		}
		
		//2.��������������趨���
		if (StringUtils.isEmpty(computerRoomVWInfo.getX_total())) {
			throw new BLException("IGCO10000.E013","����","�����");
		}
		
		if (StringUtils.isEmpty(computerRoomVWInfo.getY_total())) {
			throw new BLException("IGCO10000.E013","����","�����");
		}

		//4.������Ϣȡ��
		SOC0603SearchCondImpl cond = 
			new SOC0603SearchCondImpl();
		
		cond.setRoom_eiid(Integer.parseInt(form.getEiid()));
		
		List<SOC0603Info> computerContainerVWInfoList = 
			this.soc0603BL.searchSOC0603Info(cond, 0, 0);
		
		dto.setComputerRoomVWInfo(computerRoomVWInfo);
		dto.setComputerContainerVWInfoList(computerContainerVWInfoList);
		
		log.debug("========����ƽ��ͼ��������ڻ���������========");
		return dto;
	}
	
	/**
	 * ����ѡ������ڻ�����
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO initIGASM1105Action(IGASM11DTO dto) throws BLException {

		log.debug("========����ѡ������ڻ�����ʼ========");
		
		IGASM1105Form form = dto.getIgasm1105Form();
		
		//1.������Ϣȡ��
		SOC0601Info computerRoomVW = 
			this.soc0601BL.searchSOC0601InfoByKey(form.getCur_room_eiid());
		
		//
		form.setCur_room_name(computerRoomVW.getEiname());
		form.setRoom_eid(computerRoomVW.getEid().toString());
		
		//2.������Ϣȡ��
		//�����ѯ����ȡ�� 
		int totalCount = this.soc0603BL.getSOC0603InfoSearchCount(form);
		
		if (totalCount == 0) {
			log.debug("========�ʲ���Ϣ��ѯ���ݲ�����========");
			//�����ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========�ʲ���Ϣ��ѯ���ݼ�������========");
			//�����ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();

		pDto.setTotalCount(totalCount);
		
		List<SOC0603Info> computerContainerVWInfoList = 
			this.soc0603BL.searchSOC0603Info(form,  pDto.getFromCount(), pDto.getPageDispCount());
		
		dto.setComputerContainerVWInfoList(computerContainerVWInfoList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));

		log.debug("========����ѡ������ڻ���������========");
		return dto;
	}

	/**
	 * �����趨����
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO setComputerContainerAction(IGASM11DTO dto) throws BLException {
		log.debug("========�����趨����ʼ========");
		//0.�����趨ǰ���
		checkContainer(dto);
		
		IGASM1105Form form = dto.getIgasm1105Form();

		//1.�����趨��Ϣ����
		SOC0119SearchCondImpl cond = 
			new SOC0119SearchCondImpl();
		//����ID
		//cond.setPareiid(form.getCur_room_eiid());
		//����ID�趨
		cond.setCldeiid(Integer.parseInt(form.getSel_container_eiid()));
		
		//����ͻ�����������ϵ�趨
		cond.setEirrelation(CommonDefineUtils.ROOM_CONTAINER_ASSIGN_RELATION);
		
		List<SOC0119Info> entityItemRelationList = 
			this.soc0119BL.searchMaxEntityItemRelation(cond);
		
		//2.���й�ϵɾ��
		if (entityItemRelationList != null && entityItemRelationList.size()>0 ) {
			for (SOC0119Info res:entityItemRelationList) {
				this.soc0119BL.deleteEntityItemRelation(res);
			}
		}
		
		//3.������Ϣȡ��
		SOC0118Info entityItem = 
			this.soc0118BL.searchEntityItemByKey(Integer.parseInt(form.getSel_container_eiid()));
		
		if (entityItem == null) {
			throw new BLException("IGCO10000.E004","����");
		}
		
		//4.��������������ϵ����
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
		
		//5.��ǰ�汾ȡ��
		Integer cur_version = entityItem.getEiversion();
		
		//6.��ǰ������Ϣȡ��
		SOC0107SearchCondImpl ciCond = new SOC0107SearchCondImpl();
		
		ciCond.setEiid(form.getSel_container_eiid());
		ciCond.setCiversion(cur_version.toString());
		
		List<SOC0107Info> configItemList = 
			this.soc0107BL.searchSOC0107(ciCond, 0, 0);
		
		//7.����λ��������������ð汾��Ϣ����
		if (configItemList!=null && configItemList.size()>0) {
			//�汾����
			for (SOC0107Info item:configItemList) {
				String clabel = item.getConfiguration().getClabel();
				//����λ����������ð汾����
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
		
		//8.����λ�ã�X������������
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_X_VALUE,
				form.getCur_room_x_value(),"����","����λ�ã�X��",cur_version+1,datetime);
		
		//9.����λ�ã�Y������������
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_Y_VALUE,
				form.getCur_room_y_value(),"����","����λ�ã�Y��",cur_version+1,datetime);
		
		//10.����汾����
		SOC0118TB entityItemTB = (SOC0118TB)entityItem;
		
		entityItemTB.setEiversion(cur_version+1);
		
		this.soc0118BL.updateEntityItem(entityItemTB);
		
		log.debug("========�����趨��������========");
		return dto;
	}
	
	/**
	 * ȡ�����ϼܵĻ����б���װ��XML
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO getDefJiguiXml(IGASM11DTO dto) throws BLException {

		log.debug("========����XML���ڻ�����ʼ========");
		
		//1.���������������
		SOC0603SearchCondImpl cond = new SOC0603SearchCondImpl();
		List<SOC0603Info> computerContainerVWInfoList = this.soc0603BL.searchSOC0603Info(cond,  0, 0);
		StringBuffer jiguiXml =  new StringBuffer("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		jiguiXml.append("<ROOT>");
		jiguiXml.append("<TOOLS>");

		if(computerContainerVWInfoList!=null){
			for(SOC0603Info ccBean:computerContainerVWInfoList){
				jiguiXml.append("<img x=\"0\" y=\"0\" ontools=\"y\" " +
						"id=\"jiguiImg"+ccBean.getEiid()+ "\"  " +				//����ID
						"type=\""+"t1"+"\"  "+			//��������		
						"title=\""+ccBean.getEiname()+"\"  "+  					//��������
						"eilabel=\""+ccBean.getEilabel()+"\"  "+				//������
						"gaodu=\""+ccBean.getU_total()+"(U)\" />"); 			//����߶�
			}
		}
		jiguiXml.append("</TOOLS>");
		jiguiXml.append("</ROOT>");

		dto.setJiguiXml(jiguiXml.toString());

		log.debug("========����XML���ڻ���������========");
		return dto;
	}
	
	/**
	 * ȡ��δ�ϼܵĻ����б���װ��XML
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO getToolsXml(IGASM11DTO dto) throws BLException {

		log.debug("========����XML���ڻ�����ʼ========");
		
		//1.���������������
		SOC0603SearchCondImpl cond = new SOC0603SearchCondImpl();
		cond.setGraphstatus("0");
		List<SOC0603Info> computerContainerVWInfoList = this.soc0603BL.searchSOC0603Info(cond,  0, 0);
		
		// ���˵�δ���������Ϣ���ʲ�����
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
				} else if (ccBean.getContainertype() != null && ccBean.getContainertype().startsWith(EntityItemKeyWords.VALUE_AIR_CONDITION)) {// �յ�
					// ȡ�ÿյ�����
					if (StringUtils.isNotEmpty(ccBean.getEitype()) && ccBean.getEitype().equals("��ʽ")) {
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
						.append(" id=\"" + id + "\"  ")							//����ID
						.append(" type=\""+type+"\"  ")							//��������		
						.append(" title=\""+ccBean.getEiname()+"\"  ")  		//��������
						.append(" eilabel=\""+ eilabel +"\"  ")					//������
						.append(" gaodu=\""+ccBean.getU_total()+"(U)\" />"); 	//����߶�
			}
		}
		toolsXml.append("</TOOLS>");
		toolsXml.append("</ROOT>");

		dto.setToolsXml(toolsXml.toString());

		log.debug("========����XML���ڻ���������========");
		return dto;
	}
	/**
	 * ȡ�ù����ذ���Ϣ����װ��XML
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO getGuodaoXml(IGASM11DTO dto) throws BLException {

		log.debug("========����XML���ڻ�����ʼ========");
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

		log.debug("========����XML���ڻ���������========");
		return dto;
	}
	
	/**
	 * ȡ�����ϼܵĻ����б���װ��XML
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO getJiguiXml(IGASM11DTO dto) throws BLException {

		log.debug("========����XML���ڻ�����ʼ========");
		IGASM1104Form form = dto.getIgasm1104Form();
	
		//��ѯ�������꣬������Ϣ
		CompareTemplateSearchCondImpl ctcond = new CompareTemplateSearchCondImpl();
		ctcond.setCategory(form.getEiid());
		ctcond.setNotZoneAndNotNafFlag("ok");
	
		//��ȡ����XML
		StringBuffer jiguiXml =  new StringBuffer("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		jiguiXml.append("<ROOT>");
		jiguiXml.append("<JIGUI>");

		
		List<CompareTemplateInfo> ctlegList = compareTemplateBL.searchCompareTemplate(ctcond, 0, 0);
		
		if(ctlegList!=null&& !ctlegList.isEmpty()){
			for(CompareTemplateInfo legbean:ctlegList){
				String id = (legbean.getCteiid()==null?legbean.getCtpid().toString():legbean.getCteiid());
				jiguiXml.append("<img ");
				jiguiXml.append("x=\""+legbean.getCtx()+ "\"  " );				    //X����
				jiguiXml.append("y=\""+legbean.getCty()+ "\"  " );				    //Y����
				jiguiXml.append("floorx=\""+legbean.getCtfloorx()+ "\"  " );	    	//�ذ��X����
				jiguiXml.append("floory=\""+legbean.getCtfloory()+ "\"  " );	    	//�ذ��y����
				jiguiXml.append("title=\" "+(legbean.getCteiid()!=null?searchDeviceInfo(legbean.getCteiid()).getEiname():"")+ "\"  " );//�豸�ʲ�name
				jiguiXml.append("eilabel=\" "+(legbean.getCteiid()==null?legbean.getCtpid().toString():legbean.getCteiid())+ "\"  " );//�豸�ʲ�id
				jiguiXml.append("zone=\""+legbean.getCtZoneId()+ "\"  " );			//��������
				jiguiXml.append("id=\"" + (legbean.getCteiid()==null?legbean.getCtpid().toString():legbean.getCteiid()) + "\"  " );//����ID
				jiguiXml.append("type=\""+legbean.getCttype()+"\"  ");				//��������
				jiguiXml.append("pkid=\""+legbean.getCtpid().toString()+"\" />");	//��ˮ��
				jiguiXml.append("lightstype=\""+getIndicatorLights(id)+"\" />");	//ָʾ������
			}
		}
		
		jiguiXml.append("</JIGUI>");
		jiguiXml.append("</ROOT>");

		dto.setJiguiXml(jiguiXml.toString());

		log.debug("========����XML���ڻ���������========");
		return dto;
	}
	public static void main(String[] args) {
	  //��ȡ����XML
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
	 * �����б�����ڻ�����
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO initIGASM1111Action(IGASM11DTO dto) throws BLException {

		log.debug("========�����б�����ڻ�����ʼ========");
		
		//1.���������������
		SOC0603SearchCondImpl cond = 
			new SOC0603SearchCondImpl();
		
		//2.������Ϣȡ��
		//�����ѯ����ȡ�� 
		int totalCount = this.soc0603BL.getSOC0603InfoSearchCount(cond);
		
		if (totalCount == 0) {
			log.debug("========�ʲ���Ϣ��ѯ���ݲ�����========");
			//�����ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========�ʲ���Ϣ��ѯ���ݼ�������========");
			//�����ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();

		pDto.setTotalCount(totalCount);
		
		List<SOC0603Info> computerContainerVWInfoList = 
			this.soc0603BL.searchSOC0603Info(cond,  pDto.getFromCount(), pDto.getPageDispCount());
		
		dto.setComputerContainerVWInfoList(computerContainerVWInfoList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));

		log.debug("========�����б�����ڻ���������========");
		return dto;
	}

	/**
	 * ������Ϣɾ������
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO deleteComputerContainerInfoAction(IGASM11DTO dto) throws BLException {
		log.debug("========������Ϣɾ������ʼ========");
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
			
			//ɾ��ǰɾ���������ȷ��
			SOC0118Info entityItem = this.soc0118BL.searchEntityItemByKey(Integer.parseInt(eiid));
			
			if (entityItem == null){
				throw new BLException("IGCO10000.E004","ɾ���������");
			}

			//����ɾ��
			this.soc0118BL.deleteEntityItem(entityItem);
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I006","������Ϣ"));

		log.debug("========������Ϣɾ����������========");
		return dto;
	}

	/**
	 * ������Ϣ�༭���������ʾ
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO initIGASM1112Action(IGASM11DTO dto) throws BLException {
		log.debug("========������Ϣ�༭���������ʾ����ʼ========");
		
		IGASM1112Form form = dto.getIgasm1112Form();
		
		String eiidStr = form.getEiidStr();
		SOC0107SearchCondImpl cond = new SOC0107SearchCondImpl();
		//cond.setCid(EntityItemKeyWords.LABEL_PULLDOWN);
		cond.setEiid(eiidStr);
		List<SOC0107Info> configItem =this.soc0107BL.searchSOC0107(cond);
		if(configItem==null)
		{
			throw new BLException("IGCO10000.E004","�������");
		}
		
		//��ʾ�û�����Ϣȡ��
		SOC0603Info computerContainerVWInfo = 
			this.soc0603BL.searchSOC0603InfoByKey(eiidStr);
		
		if ( computerContainerVWInfo == null ){
			throw new BLException("IGCO10000.E004","����������");
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
		//������ʾ�趨
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
		//�汾��Ϣ
		if (StringUtils.isNotEmpty(computerContainerVWInfo.getEiversion().toString())) {
			form.setEiversion(computerContainerVWInfo.getEiversion());
		} else {
			form.setEiversion(1);
		}
		
		//�༭ģʽ�趨
		form.setMode("1");
		
		//dto.setIgasm1102Form(form);
		// ��ֵ1������ܣ�0�������
		if(EntityItemKeyWords.VALUE_PULLDOWN.equals(eimark))
		{
		dto.addMessage(new ActionMessage( "IGCO10000.I001", "������Ϣ"));
		}
		else
		{
		dto.addMessage(new ActionMessage("IGCO10000.I001","������Ϣ"));
		}
		log.debug("========������Ϣ�༭���������ʾ��������========");
		return dto;
	}
	
	/**
	 * ������Ϣ���´���
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO updateComputerContainerAction(IGASM11DTO dto) throws BLException {
		log.debug("========������Ϣ���´���ʼ========");
		
		//1.����Formȡ��
		IGASM1112Form form = dto.getIgasm1112Form();
		
		//2.����ʱ���趨
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		
		Integer cur_version = form.getEiversion();
		//ͬ��
		if(!this.soc0118BL.searchEntityItemByKey(form.getEiid()).getEiversion().equals(cur_version)) {
			throw new BLException("IGCO00000.E004");
		}
		form.setEiversion(cur_version+1);
		
		form.setEiupdtime(datetime);
		
		//3.������Ϣ��¼
		SOC0118Info entityItem = this.soc0118BL.updateEntityItem(dto.getIgasm1112Form());
		
		//4.��ǰ������Ϣȡ��
		SOC0107SearchCondImpl ciCond = new SOC0107SearchCondImpl();
		
		ciCond.setEiid(form.getEiidStr());
		ciCond.setCiversion(cur_version.toString());
		
		List<SOC0107Info> configItemList = 
			this.soc0107BL.searchSOC0107(ciCond, 0, 0);
		
		//5.����������������ð汾��Ϣ����
		if (configItemList!=null && configItemList.size()>0) {
			//�汾����
			for (SOC0107Info item:configItemList) {
				String clabel = item.getConfiguration().getClabel();
				//����λ����������ð汾����
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
		
		//6.�����������¼
		
		//6.1���������������
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_U_TOTAL,
				form.getU_total(),"����","�����",cur_version+1,datetime);
		
		//6.2����λ�ã�X������������
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_X_VALUE,
				form.getX_value(),"����","����λ�ã�X��",cur_version+1,datetime);
		
		//6.3����������������
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_Y_VALUE,
				form.getY_value(),"����","����λ�ã�Y��",cur_version+1,datetime);
		
		//6.4������������������
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_X_WIDTH,
				form.getX_width(),"����","��������",cur_version+1,datetime);
		
		//6.3�������������������
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_Y_WIDTH,
				form.getY_width(),"����","���������",cur_version+1,datetime);
		
		//6.8������������
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_WEIGHT,
				form.getWeight(),"����","������������",cur_version+1,datetime);
		
		//6.9��������������
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_STANDARD,
				form.getStandard(),"����","����������",cur_version+1,datetime);
		
		//6.10�����ѹ��������
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_VOLTAGE,
				form.getVoltage(),"����","�����ѹ����",cur_version+1,datetime);
		
		//6.11�������������
        insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_MAXLOAD,
                form.getMaxload(),"����","�������������",cur_version+1,datetime);

        //6.12��������������
        insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_MAXPOWER,
                form.getMaxpower(),"����","��������������",cur_version+1,datetime);
		
		form.setEiversion(cur_version+1);
		
		dto.setIgasm1112Form(form);
		
		if ("0".equals(form.getEimark())) {
			dto.addMessage(new ActionMessage("IGCO10000.I005", "������Ϣ"));
		} else {
			dto.addMessage(new ActionMessage("IGCO10000.I005", "������Ϣ"));
		}
		log.debug("========������Ϣ���´�������========");
		return dto;
	}
	
	/**
	 * ����ƽ��ͼ��������ڻ�����
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO initIGASM1114Action(IGASM11DTO dto) throws BLException {

		log.debug("========����ƽ��ͼ��������ڻ�����ʼ========");
		
		IGASM1114Form form = dto.getIgasm1114Form();
		
		//1.������Ϣ����
		SOC0603Info computerContainerVWInfo = 
			this.soc0603BL.searchSOC0603InfoByKey(form.getEiid());
		
		if ( computerContainerVWInfo == null) {
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","����");
		}
		
		//2.������趨���
		if (StringUtils.isEmpty(computerContainerVWInfo.getU_total())) {
			throw new BLException("IGCO10000.E013","����","�����");
		}
		
		//3.�豸��Ϣȡ��
		SOC0602SearchCondImpl cond = 
			new SOC0602SearchCondImpl();
		
		cond.setContainer_eiid(Integer.parseInt(form.getEiid()));
		
		List<SOC0602Info> computerDeviceVWInfoList = 
			this.soc0602BL.searchSOC0602Info(cond, 0, 0);
		
		dto.setComputerContainerVWInfo(computerContainerVWInfo);
		dto.setComputerDeviceVWInfoList(computerDeviceVWInfoList);
		
		log.debug("========����ƽ��ͼ��������ڻ���������========");
		return dto;
	}
	
	/**
	 * �豸ѡ������ڻ�����
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO initIGASM1115Action(IGASM11DTO dto) throws BLException {

		log.debug("========�豸ѡ������ڻ�����ʼ========");
		
		IGASM1115Form form = dto.getIgasm1115Form();
		
		//1.������Ϣȡ��
		SOC0603Info computerContainerVW = 
			this.soc0603BL.searchSOC0603InfoByKey(form.getCur_container_eiid());
		
		//
		form.setCur_container_name(computerContainerVW.getEiname());
		form.setContainer_eid(computerContainerVW.getEid().toString());
		
		//2.�豸��Ϣȡ��
		//�豸��ѯ����ȡ�� 
		int totalCount = this.soc0602BL.getSOC0602InfoSearchCount(form);
		
		if (totalCount == 0) {
			log.debug("========�ʲ���Ϣ��ѯ���ݲ�����========");
			//�豸��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========�ʲ���Ϣ��ѯ���ݼ�������========");
			//�豸��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();

		pDto.setTotalCount(totalCount);
		
		List<SOC0602Info> computerDeviceVWInfoList = 
			this.soc0602BL.searchSOC0602Info(form,  pDto.getFromCount(), pDto.getPageDispCount());
		
		dto.setComputerDeviceVWInfoList(computerDeviceVWInfoList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));

		log.debug("========�豸ѡ������ڻ���������========");
		return dto;
	}

	/**
	 * �豸�趨����
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO setComputerDeviceAction(IGASM11DTO dto) throws BLException {
		log.debug("========�豸�趨����ʼ========");
		
		//0.�豸�ϼ�ǰ���
		checkDevice(dto);
		
		IGASM1115Form form = dto.getIgasm1115Form();

		//1.�豸�趨��Ϣ����
		SOC0119SearchCondImpl cond = 
			new SOC0119SearchCondImpl();
		//����ID
		//cond.setPareiid(form.getCur_room_eiid());
		//�豸ID�趨
		cond.setCldeiid(Integer.parseInt(form.getSel_device_eiid()));
		
		//�豸�ͻ����������ϵ�趨
		cond.setEirrelation(CommonDefineUtils.CONTAINER_DEVICE_ASSIGN_RELATION);
		
		List<SOC0119Info> entityItemRelationList = 
			this.soc0119BL.searchMaxEntityItemRelation(cond);
		
		//2.���й�ϵɾ��
		if (entityItemRelationList != null && entityItemRelationList.size()>0 ) {
			for (SOC0119Info res:entityItemRelationList) {
				this.soc0119BL.deleteEntityItemRelation(res);
			}
		}
		
		//3.�豸��Ϣȡ��
		SOC0118Info entityItem = 
			this.soc0118BL.searchEntityItemByKey(Integer.parseInt(form.getSel_device_eiid()));
		
		if (entityItem == null) {
			throw new BLException("IGCO10000.E004","�豸");
		}
		
		//4.�����豸������ϵ����
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
		
		//5.��ǰ�汾ȡ��
		Integer cur_version = entityItem.getEiversion();
		
		//6.��ǰ������Ϣȡ��
		SOC0107SearchCondImpl ciCond = new SOC0107SearchCondImpl();
		
		ciCond.setEiid(form.getSel_device_eiid());
		ciCond.setCiversion(cur_version.toString());
		
		List<SOC0107Info> configItemList = 
			this.soc0107BL.searchSOC0107(ciCond, 0, 0);
		
		//7.�豸λ��������������ð汾��Ϣ����
		if (configItemList!=null && configItemList.size()>0) {
			//�汾����
			for (SOC0107Info item:configItemList) {
				String clabel = item.getConfiguration().getClabel();
				//�豸λ����������ð汾����
				if (clabel==null||!clabel.equals(EntityItemKeyWords.CLABEL_U_VALUE)) {
					SOC0107TB configItemTB = (SOC0107TB) SerializationUtils.clone((Serializable) item);
					configItemTB.setCiid(null);
					configItemTB.setCiversion(cur_version+1);
					configItemTB.setCiupdtime(datetime);
					configItemTB.setCicurver("0");
					SOC0107Info ci = this.soc0107BL.registSOC0107(configItemTB);
					
					//�������Ϊ�ʲ�ʱ���޸Ĺ�����ϵ
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
						//У���ϵ�Ƿ����
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
		
		//8.�豸λ�ã�U������������
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_U_VALUE,
				form.getCur_container_u_value(),"�豸","�豸λ�ã�U��",cur_version+1);
		
		//9.�豸�汾����
		SOC0118TB entityItemTB = (SOC0118TB)entityItem;
		
		entityItemTB.setEiversion(cur_version+1);
		entityItemTB.setEiupdtime(datetime);
		
		this.soc0118BL.updateEntityItem(entityItemTB);
		
		log.debug("========�豸�趨��������========");
		return dto;
	}
	
	/**
	 * �豸�Ƴ�����
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO moveoutComputerDeviceAction(IGASM11DTO dto) throws BLException {
		log.debug("========�豸�Ƴ�����ʼ========");
		IGASM1114Form form = dto.getIgasm1114Form();

		//1.�豸�趨��Ϣ����
		SOC0119SearchCondImpl cond = 
			new SOC0119SearchCondImpl();
		//����ID
		cond.setPareiid(Integer.parseInt(form.getEiid().toString()));
		//�豸ID�趨
		cond.setCldeiid(Integer.parseInt(form.getDevice_eiid()));
		
		//�豸�ͻ����������ϵ�趨
		cond.setEirrelation(CommonDefineUtils.CONTAINER_DEVICE_ASSIGN_RELATION);
		
		List<SOC0119Info> entityItemRelationList = 
			this.soc0119BL.searchMaxEntityItemRelation(cond);
		
		//2.���й�ϵɾ��
		if (entityItemRelationList != null && entityItemRelationList.size()>0 ) {
			for (SOC0119Info res:entityItemRelationList) {
				this.soc0119BL.deleteEntityItemRelation(res);
			}
		}
		
		//3.�豸��Ϣȡ��
		SOC0118Info entityItem = 
			this.soc0118BL.searchEntityItemByKey(Integer.parseInt(form.getDevice_eiid()));
		
		if (entityItem == null) {
			throw new BLException("IGCO10000.E004","�豸");
		}
		
		//4.��ǰ�汾ȡ��
		Integer cur_version = entityItem.getEiversion();
		
		//5.��ǰ������Ϣȡ��
		SOC0107SearchCondImpl ciCond = new SOC0107SearchCondImpl();
		
		ciCond.setEiid(form.getDevice_eiid());
		ciCond.setCiversion(cur_version.toString());
		
		List<SOC0107Info> configItemList = 
			this.soc0107BL.searchSOC0107(ciCond, 0, 0);
		
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		
		//6.�豸λ��������������ð汾��Ϣ����
		if (configItemList!=null && configItemList.size()>0) {
			//�汾����
			for (SOC0107Info item:configItemList) {
				String clabel = item.getConfiguration().getClabel();
				//�豸λ����������ð汾����
				if (clabel==null||!clabel.equals(EntityItemKeyWords.CLABEL_U_VALUE)) {
					SOC0107TB configItemTB = (SOC0107TB) SerializationUtils.clone((Serializable) item);
					configItemTB.setCiid(null);
					configItemTB.setCiversion(cur_version+1);
					configItemTB.setCiupdtime(datetime);
					configItemTB.setCicurver("0");
					SOC0107Info ci = this.soc0107BL.registSOC0107(configItemTB);
					
					//�������Ϊ�ʲ�ʱ���޸Ĺ�����ϵ
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
						//У���ϵ�Ƿ����
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
		
		//7.�豸λ�ã�U������������
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_U_VALUE,
				"","�豸","�豸λ�ã�U��",cur_version+1,datetime);
		
		//8.�豸�汾����
		SOC0118TB entityItemTB = (SOC0118TB)entityItem;
		
		entityItemTB.setEiversion(cur_version+1);
		entityItemTB.setEiupdtime(datetime);
		
		this.soc0118BL.updateEntityItem(entityItemTB);
		
		log.debug("========�豸�Ƴ���������========");
		
		return dto;
	}
	
	/**
	 * �豸������ϸ��Ϣ������ڻ�����
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO initIGASM1116Action(IGASM11DTO dto) throws BLException {
		log.debug("========�豸������ϸ��Ϣ������ڻ�����ʼ========");
		
		IGASM1116Form form = dto.getIgasm1116Form();
		//�豸��Ϣ����
		SOC0605Info entityItemVWInfo = this.soc0118BL.searchSOC0605InfoByKey(
				Integer.parseInt(dto.getIgasm1116Form().getEiid()));
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","�豸");
		}
		dto.setEntityItemVWInfo(entityItemVWInfo);
		
		form.setEsyscoding_q(entityItemVWInfo.getEsyscoding());
		//�жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
		Boolean flag = this.soc0118BL.checkSOC0605InfoDomain(dto.getUser(), entityItemVWInfo);

		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}else{
			dto.setFlag(flag);
		}
		//�ʲ���������Ϣ��ѯ����ȡ�� 
		int totalCount = this.soc0107BL.getSOC0606InfoSearchCount(form);
		
		if (totalCount == 0) {
			log.debug("========��ѯ���ݲ�����========");
			//��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I007",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========��ѯ���ݼ�������========");
			//��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		//ϵͳ������Ϣȫ����ѯ
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
		


		
		log.debug("========�豸������ϸ��Ϣ���ڻ���������========");
		return dto;
		
	}

	/**
	 * �豸�ϼܼ��
	 *
	 * @param dto IGASM11DTO
	 * @return
	 */
	protected void checkDevice(IGASM11DTO dto) throws BLException {

		log.debug("========�豸�ϼܼ�⴦��ʼ========");
		
		IGASM1115Form form = dto.getIgasm1115Form();
		
		//1.������Ϣ����
		SOC0603Info computerContainerVWInfo = 
			this.soc0603BL.searchSOC0603InfoByKey(form.getCur_container_eiid());
		
		if ( computerContainerVWInfo == null) {
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","����");
		}
		
		//2.�������豸��Ϣȡ��
		SOC0602SearchCondImpl cond = 
			new SOC0602SearchCondImpl();
		
		cond.setContainer_eiid(Integer.parseInt(form.getCur_container_eiid()));
		
		List<SOC0602Info> computerDeviceVWInfoList = 
			this.soc0602BL.searchSOC0602Info(cond, 0, 0);
		
		//3.����ƽ��ͼ��Ϣ����
		IGASM11141VO vo = new IGASM11141VO(computerContainerVWInfo,
				computerDeviceVWInfoList);
		
		//4.�ϼ��豸��Ϣȡ��
		SOC0602Info computerDeviceVWInfo = 
			this.soc0602BL.searchSOC0602InfoByKey(form.getSel_device_eiid());
		
		//5.�������Ϣȡ��
		//�豸��
		int device_u_total = Integer.parseInt(computerDeviceVWInfo.getU_width());
		
		//�豸λ��
		int device_u_value = Integer.parseInt(form.getCur_container_u_value());
		
		//�����
		int container_u_total = Integer.parseInt(computerContainerVWInfo.getU_total());
		
		//6.�ϼ��豸���
		List<IGASM11142VO> rowList = vo.getRowList();
		
		for ( int i=0; i<device_u_total;i++ ) {
			int rownum = container_u_total - (device_u_value + i);
			if (rownum<0){
				//�ϼ��豸�߳��������
				throw new BLException("IGASM1115.E001",String.valueOf(device_u_total),
						String.valueOf(device_u_value),String.valueOf(container_u_total));
			}
			
			if (!rowList.get(rownum).isSpace()) {
				if (!rowList.get(rownum).getEntityData().getEiid().equals(form.getSel_device_eiid())) {
					//�ϼ�λ�������豸����
					throw new BLException("IGASM1115.E002");
				}
			}
		}
		
		log.debug("========�豸�ϼܼ�⴦������========");
	}
	
	/**
	 * �����趨���
	 *
	 * @param dto IGASM11DTO
	 * @return 
	 */
	protected void checkContainer(IGASM11DTO dto) throws BLException {

		log.debug("========�����趨��⴦��ʼ========");
		
		IGASM1105Form form = dto.getIgasm1105Form();
		
		//1.������Ϣ����
		SOC0601Info computerRoomVWInfo = 
			this.soc0601BL.searchSOC0601InfoByKey(form.getCur_room_eiid());
		
		if ( computerRoomVWInfo == null) {
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","����");
		}
		
		//2.������Ϣȡ��
		SOC0603SearchCondImpl cond = 
			new SOC0603SearchCondImpl();
		
		cond.setRoom_eiid(Integer.parseInt(form.getCur_room_eiid()));
		
		List<SOC0603Info> computerContainerVWInfoList = 
			this.soc0603BL.searchSOC0603Info(cond, 0, 0);
		
		//3.����ƽ��ͼ��Ϣ����
		IGASM11041VO vo = new IGASM11041VO(computerRoomVWInfo,
				computerContainerVWInfoList);
		
		//4.�趨������Ϣȡ��
		SOC0603Info computerContainerVWInfo = 
			this.soc0603BL.searchSOC0603InfoByKey(form.getSel_container_eiid());
		
		//5.�������Ϣȡ��
		//�������
		int container_x_total = Integer.parseInt(computerContainerVWInfo.getX_width());
		
		//��������
		int container_y_total = Integer.parseInt(computerContainerVWInfo.getY_width());
		
		//�������λ��
		int container_x_value = Integer.parseInt(form.getCur_room_x_value());
		
		//��������λ��
		int container_y_value = Integer.parseInt(form.getCur_room_y_value());

		//���������
		int room_x_total = Integer.parseInt(computerRoomVWInfo.getX_total());
		
		//���������
		int room_y_total = Integer.parseInt(computerRoomVWInfo.getY_total());

		//6.�趨������
		List<IGASM11042VO> rowList = vo.getRowList();
		
		for ( int i=0; i<container_y_total;i++ ) {
			int rownum = container_y_value + i - 1;
			if (rownum > (room_y_total-1)){
				//�趨���񳬳����������
				throw new BLException("IGASM1105.E002");
			}
			
			IGASM11042VO rowVO = rowList.get(rownum);
			
			for ( int j=0; j<container_x_total;j++ ) {
				int colnum = container_x_value + j - 1;
				if (colnum>(room_x_total-1)) {
					//�趨���񳬳����������
					throw new BLException("IGASM1105.E001");
				}
				if (!rowVO.getColumnList().get(colnum).isSpace()) {
					String containerId = rowVO.getColumnList().get(colnum).getEntityData().getEiid().toString();
					if (!containerId.equals(form.getSel_container_eiid())) {
						//�趨����λ������������
						throw new BLException("IGASM1105.E003");
					}
				}
			}
		}
		
		log.debug("========�����趨��⴦������========");
	}

	public IGASM11DTO getContainerNameByEiid(IGASM11DTO dto) throws BLException {
		IGASM1115Form form = dto.getIgasm1115Form();
		//1.������Ϣȡ��
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
	 * ȡ��ͼ����Ϣ����װ��XML
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO getLegendXml(IGASM11DTO dto) throws BLException {

		log.debug("========ͼ����ϢXML���ڻ�����ʼ========");
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
		log.debug("========ͼ����ϢXML���ڻ���������========");
		return dto;
	}
	
	/**
	 * ȡ����Ч������Ϣ����װ��XML
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO getWuXiaoXml(IGASM11DTO dto) throws BLException {

		log.debug("========��Ч����XML���ڻ�����ʼ========");
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

		log.debug("========��Ч����XML���ڻ���������========");
		return dto;
	}
	
	/**
	 * ȡ�ù�ϵ������Ϣ����װ��XML
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO getRelateRoomXml(IGASM11DTO dto) throws BLException {

		log.debug("========ȡ�ù�ϵ������Ϣ����ʼ========");
		IGASM1104Form form = dto.getIgasm1104Form();
		SOC0107SearchCondImpl cond = new SOC0107SearchCondImpl();
		cond.setCivalue(form.getEiid());
		//��ѯ������������
		cond.setCid(String.valueOf(IGASMBL11Type.ASM_RELATEROOM));
		List<SOC0107Info> crlist = this.soc0107BL.searchSOC0107(cond);
		cond = new SOC0107SearchCondImpl();
		List<SOC0107Info> cxlist = new ArrayList<SOC0107Info>();
		List<SOC0107Info> cylist = new ArrayList<SOC0107Info>();
		for(SOC0107Info cibean:crlist){
			cond.setEiid(cibean.getEiid()+"");
			//��ѯ�������������е�X���귶Χ
			cond.setCid(String.valueOf(IGASMBL11Type.ASM_RELATEX));
			List<SOC0107Info> txlist = this.soc0107BL.searchSOC0107(cond);
			//��ѯ�������������е�Y���귶Χ
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
		
		//��װmap
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
			//��������ID
			relateRoomXml.append("<ROOM id=\""+entry.getKey()+"\">");
				Set<Map.Entry<String,String>> sset = ssMap.entrySet();
				for(Iterator<Map.Entry<String,String>> siter = sset.iterator();siter.hasNext();){
					//��������X���귶Χ
					Map.Entry<String,String> sentry = siter.next();
					relateRoomXml.append("<img id=\"x\">");
					relateRoomXml.append(sentry.getKey());
					relateRoomXml.append("</img>");
					//��������Y���귶Χ
					relateRoomXml.append("<img id=\"y\">");
					relateRoomXml.append(sentry.getValue());
					relateRoomXml.append("</img>");
				}
			relateRoomXml.append("</ROOM>");
		}
		relateRoomXml.append("</ROOT>");

		dto.setRelateRoomXML(relateRoomXml.toString());

		log.debug("========ȡ�ù�ϵ������Ϣ��������========");
		return dto;
	}

	public IGASM11DTO getEquipmentAndIpAction(IGASM11DTO dto)
			throws BLException {
		log.debug("========3D����֧��IP��ѯ��ʼ========");
		// ��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		//��ѯ���
		List<EquipmentInquireVWInfo> eilist = null;
		//newһ��cond
		EquipmentInquireVWSearchCondImpl cond = new EquipmentInquireVWSearchCondImpl();
		//���3D����֧��IP��ѯForm
		IGASM1120Form form = dto.getIgasm1120Form();
		//���Form��Ϊ����form�еĵ���������cond��
		if(form!=null){
			//���ҵ��ϵͳ��Ϊ�գ���ҵ��ϵͳ�Ž�cond��
			if(StringUtils.isNotEmpty(form.getBusinesssys())){
				cond.setBusinesssys(form.getBusinesssys());
			}
			//���IP��ַ��Ϊ�գ���IP��ַ�Ž�cond��
			if(StringUtils.isNotEmpty(form.getIp())){
				cond.setIp(form.getIp());
			}
			//�����������Ϊ�գ�����������Ž�cond��
			if(StringUtils.isNotEmpty(form.getComputerContainer())){
				cond.setComputerContainer(form.getComputerContainer());
			}
			//�豸��
			if(StringUtils.isNotEmpty(form.getEiname())){
			    cond.setEiname(form.getEiname());
			}
			//�豸���
			if(StringUtils.isNotEmpty(form.getEilabel())){
			    cond.setEilabel(form.getEilabel());
			}
			
			
		}
		//�����������Id��Ϊ�գ�����������id�Ž�cond��
		if(StringUtils.isNotEmpty(dto.getComputerContainerId())){
			cond.setComputerContainerId(Integer.parseInt(dto.getComputerContainerId()));
		}
		if(pDto==null){
			eilist = equipmentInquireVWBL.getEquipmentAndIP(cond, 0,  0);
		}else{
			int count = equipmentInquireVWBL.getEquipmentAndIPCount(cond);
			pDto.setTotalCount(count);
			//��ѯ3D����֧��IP��ѯ
			eilist = equipmentInquireVWBL.getEquipmentAndIP(cond, pDto.getFromCount(),  pDto.getPageDispCount());
		}			
		dto.setEilist(eilist);
		log.debug("========3D����֧��IP��ѯ����========");
		return dto;
	}
	
	//���ظ澯ָʾ����˸���
	private String getIndicatorLights(String eiid) throws BLException{
		SOC0602SearchCondImpl soc0602Cond =  new SOC0602SearchCondImpl();
		soc0602Cond.setContainer_eiid(Integer.parseInt(eiid));
		List<SOC0602Info> computerDeviceVWInfoList =  this.soc0602BL.searchSOC0602Info(soc0602Cond, 0, 0);
		String serial="";
		for (SOC0602Info soc0602Info : computerDeviceVWInfoList) {
//			// ��ǰ������Ϣȡ��
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
	 * ͬ���澯ϵͳ
	 *
	 * @param dto IGASM11DTO
	 * @return IGASM11DTO
	 */
	public IGASM11DTO getSynchronizationAlarmSystem(IGASM11DTO dto) throws BLException {
		log.debug("========ͬ���澯ϵͳ��ʼ========");
		SynchronizationAlarmSystemVWSearchCondImpl cond =  new SynchronizationAlarmSystemVWSearchCondImpl();
		// ��ѯδͬ��ϵͳ
		cond.setItype("1");
		List<SynchronizationAlarmSystemVWInfo> notSynchronizedList = synchronizationAlarmSystemVWBL.findByCond(cond);
		for (SynchronizationAlarmSystemVWInfo sysInfo : notSynchronizedList) {
			if(StringUtils.isEmpty(sysInfo.getIlsname())){
				IndicatorLightsSystemTB ind =  new IndicatorLightsSystemTB();
				ind.setIlsname(sysInfo.getEaname());
				ind.setIlsstatus("0");
				// �ڸ澯ϵͳ��ʾ��Ϣ������ϵͳ
				indicatorLightsSystemBL.registIndicatorLightsSystem(ind);
			}
		}
		// ��ѯ��ͬ��ϵͳ
		cond.setItype("2");
		List<SynchronizationAlarmSystemVWInfo> hasSynchronizedList = synchronizationAlarmSystemVWBL.findByCond(cond);
		for (SynchronizationAlarmSystemVWInfo sysInfo : hasSynchronizedList) {
			if(StringUtils.isEmpty(sysInfo.getEaname())){
				// �ڸ澯ϵͳ��ʾ��Ϣ��ɾ��������ɾ��ϵͳ
				indicatorLightsSystemBL.deleteIndicatorLightsSystemByPK(sysInfo.getIlsid());
			}
		}
		log.debug("========ͬ���澯ϵͳ����========");
		return dto;
	}
}
