/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.drm.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.model.entity.AttachmentTB;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.infogovernor.drm.model.TrainparticipateInfo;
import com.deliverik.infogovernor.drm.model.TrainrecordInfo;


/**
 * <p>
 * Title : InfoGovernor 模块名称
 * </p>
 * <p>
 * Description:培训记录处理DTO
 * </p>
 * 
 * @author zhangbo@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDRM17DTO extends BaseDTO implements Serializable {
	
	/** 允许查询的最大记录数 */
	protected int maxSearchCount;

	/** 分页Bean */
	protected PagingDTO pagingDto;
	
	/** 培训记录集合 */
	protected List<TrainrecordInfo> trainrecordList;
	
	/** 培训人员信息集合 */
	protected List<TrainparticipateInfo> trainparticipantList;
	
	/** 附件信息集合 */
	protected List<AttachmentTB> attList;
	
	/** 用户角色Map */
	protected Map<Integer, Map<String,List<UserRoleInfo>>> userRoleInfoMap;

	/** 培训记录对象 */
	protected String[] deleteEntityItem;
	
	/**
	 * 培训删除记录对象取得
	 * @return 培训记录对象
	 */
	public String[] getDeleteEntityItem() {
		return deleteEntityItem;
	}

	/**
	 * 培训删除记录对象设定
	 *
	 * @param deleteEntityItem 培训记录对象
	 */
	public void setDeleteEntityItem(String[] deleteEntityItem) {
		this.deleteEntityItem = deleteEntityItem;
	}

	/**  
	 * 获取允许查询的最大记录数  
	 * @return maxSearchCount 允许查询的最大记录数  
	 */
	
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**  
	 * 设置允许查询的最大记录数  
	 * @param maxSearchCount 允许查询的最大记录数  
	 */
	
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**  
	 * 获取分页Bean  
	 * @return pagingDto 分页Bean  
	 */
	
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**  
	 * 设置分页Bean  
	 * @param pagingDto 分页Bean  
	 */
	
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**  
	 * 获取培训记录集合  
	 * @return trainrecordList 培训记录集合  
	 */
	
	public List<TrainrecordInfo> getTrainrecordList() {
		return trainrecordList;
	}

	/**  
	 * 设置培训记录集合  
	 * @param trainrecordList 培训记录集合  
	 */
	
	public void setTrainrecordList(List<TrainrecordInfo> trainrecordList) {
		this.trainrecordList = trainrecordList;
	}

	/**  
	 * 获取培训人员信息集合  
	 * @return trainparticipantList 培训人员信息集合  
	 */
	
	public List<TrainparticipateInfo> getTrainparticipantList() {
		return trainparticipantList;
	}

	/**  
	 * 设置培训人员信息集合  
	 * @param trainparticipantList 培训人员信息集合  
	 */
	
	public void setTrainparticipantList(
			List<TrainparticipateInfo> trainparticipantList) {
		this.trainparticipantList = trainparticipantList;
	}

	/**  
	 * 获取附件信息集合  
	 * @return attList 附件信息集合  
	 */
	
	public List<AttachmentTB> getAttList() {
		return attList;
	}

	/**  
	 * 设置附件信息集合  
	 * @param attList 附件信息集合  
	 */
	
	public void setAttList(List<AttachmentTB> attList) {
		this.attList = attList;
	}

	/**  
	 * 获取用户角色Map  
	 * @return userRoleInfoMap 用户角色Map  
	 */
	
	public Map<Integer, Map<String, List<UserRoleInfo>>> getUserRoleInfoMap() {
		return userRoleInfoMap;
	}

	/**  
	 * 设置用户角色Map  
	 * @param userRoleInfoMap 用户角色Map  
	 */
	
	public void setUserRoleInfoMap(
			Map<Integer, Map<String, List<UserRoleInfo>>> userRoleInfoMap) {
		this.userRoleInfoMap = userRoleInfoMap;
	}
}
