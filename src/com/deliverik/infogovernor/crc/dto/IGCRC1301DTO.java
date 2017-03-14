/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.crc.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.crc.form.IGCRC1301Form;
import com.deliverik.infogovernor.crc.model.IGCRC1301VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC1301Cond;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �ĵ���ѯ��DTO
 * </p>
 * 
 * @author 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGCRC1301DTO extends BaseDTO implements Serializable{
	
	/** �ĵ���ѯ����FORM */
	private IGCRC1301Form igcrc1301Form;
	
	/** �ĵ���Ϣ�������� */
	protected IGCRC1301Cond entityItemVWSearchCond;

	/** ��ҳ��DTO */
	protected PagingDTO pagingDto;

	/** ����������� */
	protected List<IGCRC1301VWInfo> entityItemVWInfoList;

	/** ���������� */
	protected int maxSearchCount;
	
	/** �û� */
	protected User user;
	
	/** �ǲ��ǹ���Ա */
	protected String isManeger;
	
	/** �ĵ�����*/
	protected String type;
	/**
	 * ����������ȡ��
	 * @return ����������
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}


	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}


	/**
	 * �����������趨
	 *
	 * @param maxSearchCount ����������
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * ��ҳ��DTOȡ��
	 * @return ��ҳ��DTO
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * ��ҳ��DTO�趨
	 *
	 * @param pagingDto ��ҳ��DTO
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * �ĵ���Ϣ�������ȡ��
	 * @return �ĵ���Ϣ�������
	 */
	public List<IGCRC1301VWInfo> getEntityItemVWInfoList() {
		return entityItemVWInfoList;
	}

	/**
	 * �ĵ���Ϣ��������趨
	 *
	 * @param entityItemVWInfoList �ĵ���Ϣ�������
	 */
	public void setEntityItemVWInfoList(List<IGCRC1301VWInfo> entityItemVWInfoList) {
		this.entityItemVWInfoList = entityItemVWInfoList;
	}

	/** 
     * �ĵ���ѯ����FORM ȡ��
     * @return igcrc1301Form �Ա�ִ�������ѯ����FORM 
     */
	public IGCRC1301Form getIgcrc1301Form() {
		return igcrc1301Form;
	}

	/** 
     * �Ա�ִ�������ѯ����FORM �趨
     * @param igcrc1301Form �Ա�ִ�������ѯ����FORM 
     */
	public void setIgcrc1301Form(IGCRC1301Form igcrc1301Form) {
		this.igcrc1301Form = igcrc1301Form;
	}
	
	/**
	 * �ĵ���Ϣ��������ȡ��
	 * @return �ĵ���Ϣ��������
	 */
	public IGCRC1301Cond getEntityItemVWSearchCond() {
		return entityItemVWSearchCond;
	}

	/**
	 * �ĵ���Ϣ���������趨
	 *
	 * @param entityItemVWSearchCond �ĵ���Ϣ��������
	 */
	public void setEntityItemVWSearchCond(IGCRC1301Cond entityItemVWSearchCond) {
		this.entityItemVWSearchCond = entityItemVWSearchCond;
	}

	/**
	 * �û�ȡ��
	 * @return user �û�
	 */
	public User getUser() {
		return user;
	}

	/**
	 * �û��趨
	 * @param user �û�
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * �ǲ��ǹ���Աȡ��
	 * @return isManeger �ǲ��ǹ���Ա
	 */
	public String getIsManeger() {
		return isManeger;
	}

	/**
	 * �ǲ��ǹ���Ա�趨
	 * @param isManeger �ǲ��ǹ���Ա
	 */
	public void setIsManeger(String isManeger) {
		this.isManeger = isManeger;
	}

}
