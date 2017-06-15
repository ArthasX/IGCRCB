/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.crc.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.workflow.prr.model.IG500Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: 
 * </p>
 * 
 * @author shenbing@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGCRC1302DTO extends BaseDTO implements Serializable{
	
	/** ��ҳ��DTO */
	protected PagingDTO pagingDto;
	
	/** �ĵ����ļ������ */
	protected List<IG500Info> entityItemInfoList;
	
	/** ��ǰ�û�ID */
	protected String userId;

	/**
	 * ��ҳ��DTOȡ��
	 * @return pagingDto ��ҳ��DTO
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * ��ҳ��DTO�趨
	 * @param pagingDto ��ҳ��DTO
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * �ĵ����ļ������ȡ��
	 * @return entityItemInfoList �ĵ����ļ������
	 */
	public List<IG500Info> getEntityItemInfoList() {
		return entityItemInfoList;
	}

	/**
	 * �ĵ����ļ�������趨
	 * @param entityItemInfoList �ĵ����ļ������
	 */
	public void setEntityItemInfoList(List<IG500Info> entityItemInfoList) {
		this.entityItemInfoList = entityItemInfoList;
	}

	/**
	 * ��ǰ�û�IDȡ��
	 * @return userId ��ǰ�û�ID
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * ��ǰ�û�ID�趨
	 * @param userId ��ǰ�û�ID
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
