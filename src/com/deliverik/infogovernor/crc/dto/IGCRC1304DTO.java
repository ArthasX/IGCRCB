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
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.crc.form.IGCRC1301Form;
import com.deliverik.infogovernor.crc.form.IGCRC1304Form;
import com.deliverik.infogovernor.crc.model.IGCRC1303VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC1304Cond;
import com.deliverik.infogovernor.crc.model.entity.DepartModelVW;

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
public class IGCRC1304DTO extends BaseDTO implements Serializable{
	
	
	/** �ĵ���ѯ����FORM */
	private IGCRC1304Form igcrc1304Form;
	
	
	protected IGCRC1301Form igcrc1301Form;
	
	/** �ĵ���Ϣ�������� */
	protected IGCRC1304Cond entityItemVWSearchCond;

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
	
	/** ������Ϣ���� */
	protected List<IG500Info> processList;
	
	protected Map<String,Integer> maps = new HashMap<String,Integer>();
	
	/** ��װDepartModelVW����  */
	protected List<DepartModelVW> ListVM = new ArrayList<DepartModelVW>();

	public List<DepartModelVW> getListVM() {
		return ListVM;
	}

	public void setListVM(List<DepartModelVW> listVM) {
		ListVM = listVM;
	}

	/**
	 * @return the processList
	 */
	public List<IG500Info> getProcessList() {
		return processList;
	}

	/**
	 * @param processList the processList to set
	 */
	public void setProcessList(List<IG500Info> processList) {
		this.processList = processList;
	}

	public Map<String, Integer> getMaps() {
		return maps;
	}

	public void setMaps(Map<String, Integer> maps) {
		this.maps = maps;
	}

	  
	/**
	 * @return the igcrc1301Form
	 */
	public IGCRC1301Form getIgcrc1301Form() {
		return igcrc1301Form;
	}

	/**
	 * @param igcrc1301Form the igcrc1301Form to set
	 */
	public void setIgcrc1301Form(IGCRC1301Form igcrc1301Form) {
		this.igcrc1301Form = igcrc1301Form;
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

	
	
	public IGCRC1304Form getIgcrc1304Form() {
		return igcrc1304Form;
	}

	public void setIgcrc1304Form(IGCRC1304Form igcrc1304Form) {
		this.igcrc1304Form = igcrc1304Form;
	}

	/**
	 * �ĵ���Ϣ��������ȡ��
	 * @return �ĵ���Ϣ��������
	 */
	public IGCRC1304Cond getEntityItemVWSearchCond() {
		return entityItemVWSearchCond;
	}

	/**
	 * �ĵ���Ϣ���������趨
	 *
	 * @param entityItemVWSearchCond �ĵ���Ϣ��������
	 */
	public void setEntityItemVWSearchCond(IGCRC1304Cond entityItemVWSearchCond) {
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
