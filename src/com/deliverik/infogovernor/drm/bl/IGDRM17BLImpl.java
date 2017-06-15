/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
 * Title : InfoGovernor 模块名称
 * </p>
 * <p>
 * Description:培训记录处理BL实现
 * </p>
 * 
 * @author zhangbo@deliverik.com
 * @version 1.0
 */
public class IGDRM17BLImpl extends BaseBLImpl implements IGDRM17BL {
	
	/** 日志对象实例 */
	private static final Log log = LogFactory.getLog(IGDRM17BLImpl.class);
	
	/** 培训操作BL */
	protected TrainrecordBL trainrecordBL;
	
	/** 培训人员BL */
	protected TrainparticipateBL trainparticipateBL;
	
	/** 附件处理BL */
	protected FileUploadBL fileUploadBL;
	
	/** 附件管理BL */
	protected AttachmentBL attachmentBL;
	
	/** 用户角色BL */
	protected UserRoleBL userRoleBL;
	
	

	/**  
	 * 设置用户角色BL  
	 * @param userRoleBL 用户角色BL  
	 */
	
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}

	/**  
	 * 设置培训操作BL  
	 * @param trainrecordBL 培训操作BL  
	 */
	
	public void setTrainrecordBL(TrainrecordBL trainrecordBL) {
		this.trainrecordBL = trainrecordBL;
	}

	/**  
	 * 设置培训人员BL  
	 * @param trainparticipateBL 培训人员BL  
	 */
	
	public void setTrainparticipateBL(TrainparticipateBL trainparticipateBL) {
		this.trainparticipateBL = trainparticipateBL;
	}

	/**  
	 * 设置附件处理BL  
	 * @param fileUploadBL 附件处理BL  
	 */
	
	public void setFileUploadBL(FileUploadBL fileUploadBL) {
		this.fileUploadBL = fileUploadBL;
	}
	
	/**  
	 * 设置附件管理BL  
	 * @param attachmentBL 附件管理BL  
	 */
	
	public void setAttachmentBL(AttachmentBL attachmentBL) {
		this.attachmentBL = attachmentBL;
	}

	/**
	 * 培训记录查询操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM17DTO searchTrainAction(IGDRM17DTO dto) throws BLException {
		log.debug("===========培训记录查询操作开始============");
		//实例化查询条件
		TrainrecordSearchCondImpl cond = new TrainrecordSearchCondImpl();
		this.copyProperties(cond, dto.getForm());
		// 查询记录总数
		int totalCount = trainrecordBL.getSearchCount(cond);
		if (totalCount == 0) {
			log.debug("========查询数据不存在========");
			// 查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========查询数据件数过多========");
			// 查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto.getMaxSearchCount(), totalCount));
			return dto;
		}
		// 获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		// 调用DAO接口查询
		List<TrainrecordInfo> list = trainrecordBL.searchTrainrecord(cond,pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);
		dto.setTrainrecordList(list);
		log.debug("===========培训记录查询操作结束============");
		return dto;
	}
	
	/**
	 * 初始化培训记录信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM17DTO initTrainRecordAction(IGDRM17DTO dto) throws BLException {
		log.debug("=============初始化培训记录操作开始==============");
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
		log.debug("=============初始化培训记录操作结束==============");
		return dto;
	}
	
	/**
	 * 培训记录新增操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM17DTO insertTrainRecordAction(IGDRM17DTO dto) throws BLException {
		log.debug("============培训记录新增操作开始=============");
		if(dto.getForm() != null && dto.getForm() instanceof IGDRM1702Form){
			IGDRM1702Form form = (IGDRM1702Form) dto.getForm();
			//实例化培训记录实体
			TrainrecordTB entity = new TrainrecordTB();
			this.copyProperties(entity, form);
			String attKey = this.fileUploadBL.uploadFile(form.getFileMap());
			entity.setTratt(attKey);
			TrainrecordInfo info = trainrecordBL.registTrainrecord(entity);
			if(form.getTpaname() != null && form.getTpaorg() != null && form.getTpatel() != null){
				for(int i=0;i<form.getTpaname().length;i++){
					//实例化培训人员对象
					TrainparticipateTB tb = new TrainparticipateTB();
					tb.setTpaname(form.getTpaname()[i]);
					tb.setTpaorg(form.getTpaorg()[i]);
					tb.setTpatel(form.getTpatel()[i]);
					tb.setTrid(info.getTrid());
					this.trainparticipateBL.registTrainparticipate(tb);
				}
			}
		}
		log.debug("============培训记录新增操作结束=============");
		return dto;
	}
	
	/**
	 * 培训记录修改操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM17DTO changeTrainRecordAction(IGDRM17DTO dto) throws BLException {
		log.debug("===========培训记录修改操作开始============");
		if(dto.getForm() != null && dto.getForm() instanceof IGDRM1702Form){
			//页面参数取得
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
			//查询培训人员信息
			TrainparticipateSearchCondImpl cond = new TrainparticipateSearchCondImpl();
			cond.setTrid(info.getTrid());
			List<TrainparticipateInfo> list = trainparticipateBL.searchTrainparticipate(cond);
			for(TrainparticipateInfo tp:list){
				trainparticipateBL.deleteTrainparticipate(tp);
			}
			if(form.getTpaname() != null && form.getTpaorg() != null && form.getTpatel() != null){
				for(int i=0;i<form.getTpaname().length;i++){
					//实例化培训人员对象
					TrainparticipateTB tb = new TrainparticipateTB();
					tb.setTpaname(form.getTpaname()[i]);
					tb.setTpaorg(form.getTpaorg()[i]);
					tb.setTpatel(form.getTpatel()[i]);
					tb.setTrid(info.getTrid());
					this.trainparticipateBL.registTrainparticipate(tb);
				}
			}
		}
		log.debug("===========培训记录修改操作结束============");
		return dto;
	}
	
	/**
	 * 培训记录删除操作
	 * @param dto
	 * @throws BLException
	 */
	public IGDRM17DTO delTrainRecordAction(IGDRM17DTO dto)throws BLException{
		
		log.debug("===========培训记录删除操作结束============");
		
		if(dto.getForm() != null && dto.getForm() instanceof IGDRM1701Form){
		//查询培训人员信息
			Integer trid = ((IGDRM1701Form)dto.getForm()).getTrid();
			trainrecordBL.deleteTrainrecordByPK(trid);
			TrainparticipateSearchCondImpl cond = new TrainparticipateSearchCondImpl();
			cond.setTrid(trid);
			List<TrainparticipateInfo> list = trainparticipateBL.searchTrainparticipate(cond);
			for(TrainparticipateInfo tp:list){
				trainparticipateBL.deleteTrainparticipate(tp);
			}
		}
		
		log.debug("===========培训记录删除操作结束============");
		
		return dto;
	}
	
	/**
	 * 培训记录批量删除处理
	 *
	 * @param dto IGDRM17DTO
	 * @return IGDRM17DTO
	 */
	public IGDRM17DTO deleteEntityItemAction(IGDRM17DTO dto) throws BLException {
		log.debug("===========培训记录删除操作开始============");
		if(dto.getDeleteEntityItem() != null){
			for(int i=0;i<dto.getDeleteEntityItem().length;i++ ) {
				String trid = dto.getDeleteEntityItem()[i];
				//查询培训人员信息
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
		dto.addMessage(new ActionMessage("IGCO10000.I006", "培训记录"));
		log.debug("===========培训记录删除操作结束============");
		return dto;
	}
	
	/**
	 * 查询用户信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM17DTO searchUserRoleAction(IGDRM17DTO dto) throws BLException{
		log.debug("=============查询用户信息操作开始=============");
		//参数取得
		IGDRM1703Form form = (IGDRM1703Form) dto.getForm();
		UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
		cond.setRoletype(form.getRoletype());
		cond.setOrgid_like(form.getOrgsyscoding());
		cond.setRoleid(form.getRoleid());
		cond.setUsername_like(form.getUsername_like());
		//角色过滤
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
		log.debug("=============查询用户信息操作结束=============");
		return dto;
	}
}
