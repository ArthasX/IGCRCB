/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.drm.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.AttachmentBL;
import com.deliverik.framework.bl.FileUploadBL;
import com.deliverik.framework.model.entity.AttachmentTB;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.infogovernor.drm.bl.task.TrainparticipateBL;
import com.deliverik.infogovernor.drm.bl.task.TrainrecordBL;
import com.deliverik.infogovernor.drm.dto.IGDRM17DTO;
import com.deliverik.infogovernor.drm.form.IGDRM1701Form;
import com.deliverik.infogovernor.drm.form.IGDRM1702Form;
import com.deliverik.infogovernor.drm.form.IGDRM1703Form;
import com.deliverik.infogovernor.drm.model.TrainparticipateInfo;
import com.deliverik.infogovernor.drm.model.TrainrecordInfo;
import com.deliverik.infogovernor.drm.model.condition.TrainparticipateSearchCondImpl;
import com.deliverik.infogovernor.drm.model.condition.TrainrecordSearchCondImpl;
import com.deliverik.infogovernor.drm.model.entity.TrainparticipateTB;
import com.deliverik.infogovernor.drm.model.entity.TrainrecordTB;

/**
 * <p>
 * Title : InfoGovernor ģ������
 * </p>
 * <p>
 * Description:��ѵ��¼����BLʵ��
 * </p>
 * 
 * @author zhangbo@deliverik.com
 * @version 1.0
 */
public class IGDRM17BLImpl extends BaseBLImpl implements IGDRM17BL {
	
	/** ��־����ʵ�� */
	private static final Log log = LogFactory.getLog(IGDRM17BLImpl.class);
	
	/** ��ѵ����BL */
	protected TrainrecordBL trainrecordBL;
	
	/** ��ѵ��ԱBL */
	protected TrainparticipateBL trainparticipateBL;
	
	/** ��������BL */
	protected FileUploadBL fileUploadBL;
	
	/** ��������BL */
	protected AttachmentBL attachmentBL;
	
	/** �û���ɫBL */
	protected UserRoleBL userRoleBL;
	
	

	/**  
	 * �����û���ɫBL  
	 * @param userRoleBL �û���ɫBL  
	 */
	
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}

	/**  
	 * ������ѵ����BL  
	 * @param trainrecordBL ��ѵ����BL  
	 */
	
	public void setTrainrecordBL(TrainrecordBL trainrecordBL) {
		this.trainrecordBL = trainrecordBL;
	}

	/**  
	 * ������ѵ��ԱBL  
	 * @param trainparticipateBL ��ѵ��ԱBL  
	 */
	
	public void setTrainparticipateBL(TrainparticipateBL trainparticipateBL) {
		this.trainparticipateBL = trainparticipateBL;
	}

	/**  
	 * ���ø�������BL  
	 * @param fileUploadBL ��������BL  
	 */
	
	public void setFileUploadBL(FileUploadBL fileUploadBL) {
		this.fileUploadBL = fileUploadBL;
	}
	
	/**  
	 * ���ø�������BL  
	 * @param attachmentBL ��������BL  
	 */
	
	public void setAttachmentBL(AttachmentBL attachmentBL) {
		this.attachmentBL = attachmentBL;
	}

	/**
	 * ��ѵ��¼��ѯ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM17DTO searchTrainAction(IGDRM17DTO dto) throws BLException {
		log.debug("===========��ѵ��¼��ѯ������ʼ============");
		//ʵ������ѯ����
		TrainrecordSearchCondImpl cond = new TrainrecordSearchCondImpl();
		this.copyProperties(cond, dto.getForm());
		// ��ѯ��¼����
		int totalCount = trainrecordBL.getSearchCount(cond);
		if (totalCount == 0) {
			log.debug("========��ѯ���ݲ�����========");
			// ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========��ѯ���ݼ�������========");
			// ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto.getMaxSearchCount(), totalCount));
			return dto;
		}
		// ��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		// ����DAO�ӿڲ�ѯ
		List<TrainrecordInfo> list = trainrecordBL.searchTrainrecord(cond,pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);
		dto.setTrainrecordList(list);
		log.debug("===========��ѵ��¼��ѯ��������============");
		return dto;
	}
	
	/**
	 * ��ʼ����ѵ��¼��Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM17DTO initTrainRecordAction(IGDRM17DTO dto) throws BLException {
		log.debug("=============��ʼ����ѵ��¼������ʼ==============");
		if(dto.getForm() != null && dto.getForm() instanceof IGDRM1702Form){
			IGDRM1702Form form = (IGDRM1702Form) dto.getForm();
			if(form.getTrid() != null && form.getTrid() > 0){
				TrainrecordInfo info = trainrecordBL.searchTrainrecordByPK(form.getTrid());
				this.copyProperties(form, info);
				TrainparticipateSearchCondImpl cond = new TrainparticipateSearchCondImpl();
				cond.setTrid(info.getTrid());
				List<TrainparticipateInfo> list = trainparticipateBL.searchTrainparticipate(cond);
				dto.setTrainparticipantList(list);
				if(info.getAttachmentList() != null && info.getAttachmentList().size() > 0){
					dto.setAttList(info.getAttachmentList());
				}
			}
		}
		log.debug("=============��ʼ����ѵ��¼��������==============");
		return dto;
	}
	
	/**
	 * ��ѵ��¼��������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM17DTO insertTrainRecordAction(IGDRM17DTO dto) throws BLException {
		log.debug("============��ѵ��¼����������ʼ=============");
		if(dto.getForm() != null && dto.getForm() instanceof IGDRM1702Form){
			IGDRM1702Form form = (IGDRM1702Form) dto.getForm();
			//ʵ������ѵ��¼ʵ��
			TrainrecordTB entity = new TrainrecordTB();
			this.copyProperties(entity, form);
			String attKey = this.fileUploadBL.uploadFile(form.getFileMap());
			entity.setTratt(attKey);
			TrainrecordInfo info = trainrecordBL.registTrainrecord(entity);
			if(form.getTpaname() != null && form.getTpaorg() != null && form.getTpatel() != null){
				for(int i=0;i<form.getTpaname().length;i++){
					//ʵ������ѵ��Ա����
					TrainparticipateTB tb = new TrainparticipateTB();
					tb.setTpaname(form.getTpaname()[i]);
					tb.setTpaorg(form.getTpaorg()[i]);
					tb.setTpatel(form.getTpatel()[i]);
					tb.setTrid(info.getTrid());
					this.trainparticipateBL.registTrainparticipate(tb);
				}
			}
		}
		log.debug("============��ѵ��¼������������=============");
		return dto;
	}
	
	/**
	 * ��ѵ��¼�޸Ĳ���
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM17DTO changeTrainRecordAction(IGDRM17DTO dto) throws BLException {
		log.debug("===========��ѵ��¼�޸Ĳ�����ʼ============");
		if(dto.getForm() != null && dto.getForm() instanceof IGDRM1702Form){
			//ҳ�����ȡ��
			IGDRM1702Form form = (IGDRM1702Form) dto.getForm();
			TrainrecordTB entry = (TrainrecordTB) trainrecordBL.searchTrainrecordByPK(form.getTrid());
			this.copyProperties(entry, form);
			if(StringUtils.isNotEmpty(entry.getTratt())){
				fileUploadBL.uploadFile(form.getFileMap(), entry.getTratt());
			}else{
				String attKey = fileUploadBL.uploadFile(form.getFileMap());
				entry.setTratt(attKey);
			}
			TrainrecordInfo info = trainrecordBL.updateTrainrecord(entry);
			if(StringUtils.isNotEmpty(form.getPredelkey())){
				for(String attid:form.getPredelkey().split(",")){
					AttachmentTB attTB = new AttachmentTB();
					attTB.setAttid(Integer.valueOf(attid));
					attachmentBL.deleteAttachment(attTB);
				}
			}
			//��ѯ��ѵ��Ա��Ϣ
			TrainparticipateSearchCondImpl cond = new TrainparticipateSearchCondImpl();
			cond.setTrid(info.getTrid());
			List<TrainparticipateInfo> list = trainparticipateBL.searchTrainparticipate(cond);
			for(TrainparticipateInfo tp:list){
				trainparticipateBL.deleteTrainparticipate(tp);
			}
			if(form.getTpaname() != null && form.getTpaorg() != null && form.getTpatel() != null){
				for(int i=0;i<form.getTpaname().length;i++){
					//ʵ������ѵ��Ա����
					TrainparticipateTB tb = new TrainparticipateTB();
					tb.setTpaname(form.getTpaname()[i]);
					tb.setTpaorg(form.getTpaorg()[i]);
					tb.setTpatel(form.getTpatel()[i]);
					tb.setTrid(info.getTrid());
					this.trainparticipateBL.registTrainparticipate(tb);
				}
			}
		}
		log.debug("===========��ѵ��¼�޸Ĳ�������============");
		return dto;
	}
	
	/**
	 * ��ѵ��¼ɾ������
	 * @param dto
	 * @throws BLException
	 */
	public IGDRM17DTO delTrainRecordAction(IGDRM17DTO dto)throws BLException{
		
		log.debug("===========��ѵ��¼ɾ����������============");
		
		if(dto.getForm() != null && dto.getForm() instanceof IGDRM1701Form){
		//��ѯ��ѵ��Ա��Ϣ
			Integer trid = ((IGDRM1701Form)dto.getForm()).getTrid();
			trainrecordBL.deleteTrainrecordByPK(trid);
			TrainparticipateSearchCondImpl cond = new TrainparticipateSearchCondImpl();
			cond.setTrid(trid);
			List<TrainparticipateInfo> list = trainparticipateBL.searchTrainparticipate(cond);
			for(TrainparticipateInfo tp:list){
				trainparticipateBL.deleteTrainparticipate(tp);
			}
		}
		
		log.debug("===========��ѵ��¼ɾ����������============");
		
		return dto;
	}
	
	/**
	 * ��ѵ��¼����ɾ������
	 *
	 * @param dto IGDRM17DTO
	 * @return IGDRM17DTO
	 */
	public IGDRM17DTO deleteEntityItemAction(IGDRM17DTO dto) throws BLException {
		log.debug("===========��ѵ��¼ɾ��������ʼ============");
		if(dto.getDeleteEntityItem() != null){
			for(int i=0;i<dto.getDeleteEntityItem().length;i++ ) {
				String trid = dto.getDeleteEntityItem()[i];
				//��ѯ��ѵ��Ա��Ϣ
	//			Integer trid = ((IGDRM1701Form)dto.getForm()).getTrid();
				trainrecordBL.deleteTrainrecordByPK(Integer.valueOf(trid));
				TrainparticipateSearchCondImpl cond = new TrainparticipateSearchCondImpl();
				cond.setTrid(Integer.valueOf(trid));
				List<TrainparticipateInfo> list = trainparticipateBL.searchTrainparticipate(cond);
				for(TrainparticipateInfo tp:list){
					trainparticipateBL.deleteTrainparticipate(tp);
				}
			}
		}
		dto.addMessage(new ActionMessage("IGCO10000.I006", "��ѵ��¼"));
		log.debug("===========��ѵ��¼ɾ����������============");
		return dto;
	}
	
	/**
	 * ��ѯ�û���Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM17DTO searchUserRoleAction(IGDRM17DTO dto) throws BLException{
		log.debug("=============��ѯ�û���Ϣ������ʼ=============");
		//����ȡ��
		IGDRM1703Form form = (IGDRM1703Form) dto.getForm();
		UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
		cond.setRoletype(form.getRoletype());
		cond.setOrgid_like(form.getOrgsyscoding());
		cond.setRoleid(form.getRoleid());
		cond.setUsername_like(form.getUsername_like());
		//��ɫ����
		if(StringUtils.isNotEmpty(form.getRoleid_in())){
			List<Integer> roleids = new ArrayList<Integer>();
			String[] roleid_not_in = form.getRoleid_in().split(",");
			for(String s:roleid_not_in){
				roleids.add(Integer.valueOf(s));
			}
			cond.setRoleid_in(roleids);
		}
		List<UserRoleInfo> userRoleList = userRoleBL.searchUserRoleVW(cond);
		if(userRoleList != null){
			Map<Integer, Map<String,List<UserRoleInfo>>> userRoleInfoMap = new LinkedHashMap<Integer, Map<String,List<UserRoleInfo>>>();
			for(UserRoleInfo ur:userRoleList){
				if(userRoleInfoMap.get(ur.getRoleid()) == null){
					Map<String, List<UserRoleInfo>> map = new HashMap<String, List<UserRoleInfo>>();
					List<UserRoleInfo> list = new ArrayList<UserRoleInfo>();
					list.add(ur);
					map.put(ur.getRolename(), list);
					userRoleInfoMap.put(ur.getRoleid(), map);
				}else{
					userRoleInfoMap.get(ur.getRoleid()).get(ur.getRolename()).add(ur);
				}
			}
			dto.setUserRoleInfoMap(userRoleInfoMap);
		}
		log.debug("=============��ѯ�û���Ϣ��������=============");
		return dto;
	}
}
