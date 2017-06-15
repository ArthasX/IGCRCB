/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * Title : InfoGovernor ģ������
 * </p>
 * <p>
 * Description:��ѵ��¼����DTO
 * </p>
 * 
 * @author zhangbo@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDRM17DTO extends BaseDTO implements Serializable {
	
	/** �����ѯ������¼�� */
	protected int maxSearchCount;

	/** ��ҳBean */
	protected PagingDTO pagingDto;
	
	/** ��ѵ��¼���� */
	protected List<TrainrecordInfo> trainrecordList;
	
	/** ��ѵ��Ա��Ϣ���� */
	protected List<TrainparticipateInfo> trainparticipantList;
	
	/** ������Ϣ���� */
	protected List<AttachmentTB> attList;
	
	/** �û���ɫMap */
	protected Map<Integer, Map<String,List<UserRoleInfo>>> userRoleInfoMap;

	/** ��ѵ��¼���� */
	protected String[] deleteEntityItem;
	
	/**
	 * ��ѵɾ����¼����ȡ��
	 * @return ��ѵ��¼����
	 */
	public String[] getDeleteEntityItem() {
		return deleteEntityItem;
	}

	/**
	 * ��ѵɾ����¼�����趨
	 *
	 * @param deleteEntityItem ��ѵ��¼����
	 */
	public void setDeleteEntityItem(String[] deleteEntityItem) {
		this.deleteEntityItem = deleteEntityItem;
	}

	/**  
	 * ��ȡ�����ѯ������¼��  
	 * @return maxSearchCount �����ѯ������¼��  
	 */
	
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**  
	 * ���������ѯ������¼��  
	 * @param maxSearchCount �����ѯ������¼��  
	 */
	
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**  
	 * ��ȡ��ҳBean  
	 * @return pagingDto ��ҳBean  
	 */
	
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**  
	 * ���÷�ҳBean  
	 * @param pagingDto ��ҳBean  
	 */
	
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**  
	 * ��ȡ��ѵ��¼����  
	 * @return trainrecordList ��ѵ��¼����  
	 */
	
	public List<TrainrecordInfo> getTrainrecordList() {
		return trainrecordList;
	}

	/**  
	 * ������ѵ��¼����  
	 * @param trainrecordList ��ѵ��¼����  
	 */
	
	public void setTrainrecordList(List<TrainrecordInfo> trainrecordList) {
		this.trainrecordList = trainrecordList;
	}

	/**  
	 * ��ȡ��ѵ��Ա��Ϣ����  
	 * @return trainparticipantList ��ѵ��Ա��Ϣ����  
	 */
	
	public List<TrainparticipateInfo> getTrainparticipantList() {
		return trainparticipantList;
	}

	/**  
	 * ������ѵ��Ա��Ϣ����  
	 * @param trainparticipantList ��ѵ��Ա��Ϣ����  
	 */
	
	public void setTrainparticipantList(
			List<TrainparticipateInfo> trainparticipantList) {
		this.trainparticipantList = trainparticipantList;
	}

	/**  
	 * ��ȡ������Ϣ����  
	 * @return attList ������Ϣ����  
	 */
	
	public List<AttachmentTB> getAttList() {
		return attList;
	}

	/**  
	 * ���ø�����Ϣ����  
	 * @param attList ������Ϣ����  
	 */
	
	public void setAttList(List<AttachmentTB> attList) {
		this.attList = attList;
	}

	/**  
	 * ��ȡ�û���ɫMap  
	 * @return userRoleInfoMap �û���ɫMap  
	 */
	
	public Map<Integer, Map<String, List<UserRoleInfo>>> getUserRoleInfoMap() {
		return userRoleInfoMap;
	}

	/**  
	 * �����û���ɫMap  
	 * @param userRoleInfoMap �û���ɫMap  
	 */
	
	public void setUserRoleInfoMap(
			Map<Integer, Map<String, List<UserRoleInfo>>> userRoleInfoMap) {
		this.userRoleInfoMap = userRoleInfoMap;
	}
}
