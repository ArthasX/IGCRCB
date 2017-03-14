/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.crc.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.crc.form.IGCRC1303Form;
import com.deliverik.infogovernor.crc.model.IGCRC1303VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC1303Cond;
import com.deliverik.infogovernor.crc.model.entity.ModelVW;

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
public class IGCRC1303DTO extends BaseDTO implements Serializable{
	
	
	/** �ĵ���ѯ����FORM */
	private IGCRC1303Form igcrc1303Form;
	
	/** �ĵ���Ϣ�������� */
	protected IGCRC1303Cond entityItemVWSearchCond;

	/** ��ҳ��DTO */
	protected PagingDTO pagingDto;

	/** ����������� */
	protected List<IGCRC1303VWInfo> entityItemVWInfoList;

	/** ���������� */
	protected int maxSearchCount;
	
	/** �û� */
	protected User user;
	
	/** �ǲ��ǹ���Ա */
	protected String isManeger;
	
	/** �����������*/
	protected Integer ddid;
	
	/** ������Ĳ�������*/
	protected String civalue;
	
	public Integer getDdid() {
		return ddid;
	}

	public void setDdid(Integer ddid) {
		this.ddid = ddid;
	}

	public String getCivalue() {
		return civalue;
	}

	public void setCivalue(String civalue) {
		this.civalue = civalue;
	}

	protected Map<String,Integer> maps = new HashMap<String,Integer>();
	
	protected List<ModelVW> ListVM = new ArrayList<ModelVW>();
	
	
	public List<ModelVW> getListVM() {
		return ListVM;
	}

	public void setListVM(List<ModelVW> listVM) {
		ListVM = listVM;
	}

	public Map<String, Integer> getMaps() {
		return maps;
	}

	public void setMaps(Map<String, Integer> maps) {
		this.maps = maps;
	}

	/**
	 * ����������ȡ��
	 * @return ����������
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
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
	public List<IGCRC1303VWInfo> getEntityItemVWInfoList() {
		return entityItemVWInfoList;
	}

	/**
	 * �ĵ���Ϣ��������趨
	 *
	 * @param entityItemVWInfoList �ĵ���Ϣ�������
	 */
	public void setEntityItemVWInfoList(List<IGCRC1303VWInfo> entityItemVWInfoList) {
		this.entityItemVWInfoList = entityItemVWInfoList;
	}

	
	
	public IGCRC1303Form getIgcrc1303Form() {
		return igcrc1303Form;
	}

	public void setIgcrc1303Form(IGCRC1303Form igcrc1303Form) {
		this.igcrc1303Form = igcrc1303Form;
	}

	/**
	 * �ĵ���Ϣ��������ȡ��
	 * @return �ĵ���Ϣ��������
	 */
	public IGCRC1303Cond getEntityItemVWSearchCond() {
		return entityItemVWSearchCond;
	}

	/**
	 * �ĵ���Ϣ���������趨
	 *
	 * @param entityItemVWSearchCond �ĵ���Ϣ��������
	 */
	public void setEntityItemVWSearchCond(IGCRC1303Cond entityItemVWSearchCond) {
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
