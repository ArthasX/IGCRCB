package com.deliverik.infogovernor.asset.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.asset.model.IG002Info;
import com.deliverik.framework.asset.model.IG313Info;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.asset.model.IG800Info;
import com.deliverik.framework.asset.model.IG887Info;
import com.deliverik.framework.asset.model.condition.IG688SearchCond;
import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.model.SOC0119Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0128Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.asset.form.IGASM1004Form;
import com.deliverik.infogovernor.asset.form.IGASM1005Form;
import com.deliverik.infogovernor.asset.form.IGASM1006Form;

/**
 * �ʲ����ù���ҵ����DTO
 * 
 */
@SuppressWarnings("serial")
public class IGASM10DTO extends BaseDTO implements Serializable{

	/** �ʲ�����Ϣ�������� */
	protected IG688SearchCond entityItemVWSearchCond;
	protected SOC0124SearchCond socEntityItemVWSearchCond;
	protected List<SOC0124Info> socEntityItemVWInfoList;
	protected SOC0124Info socEntityItemVWInfo;
	/** �ʲ���������Ϣ������� */
	protected Map<String,List<SOC0129Info>> socConfigItemVWInfoMap;
	
	/** ���������� */
	protected int maxSearchCount;

	/** ��ҳ��DTO */
	protected PagingDTO pagingDto;

	/** �ʲ��������� */
	protected List<IG688Info> entityItemVWInfoList;

	/** �ʲ���ɾ������ */
	protected String[] deleteEntityItem;

	/** �ʲ���������Ϣ */
	protected IGASM1004Form igasm1004Form;
	
	/** �ʲ���������Ϣ������� */
	protected List<IG002Info> configItemVWInfoList;

	/** �ʲ���������Ϣ�����ʲ�����Ϣ */
	protected IG688Info entityItemVWInfo;

	/** �ʲ���������Ϣ��ʷ��¼�������� */
	protected IGASM1005Form igasm1005Form;
	
	/** �ʲ���������Ϣ��ʷ��¼������� */
	protected List<IG800Info> configItemList;
	
	/** �ʲ����ϵ����������� */
	protected IGASM1006Form igasm1006Form;
	
	/** �ʲ����ϵ������Ϣ�������1 */
	protected List<IG313Info> parEntityItemRelationList;
	/** soc�ʲ����ϵ������Ϣ�������1 */
	protected List<SOC0119Info> socParEntityItemRelationList;
	
	/** �ʲ����ϵ������Ϣ�������2 */
	protected List<IG313Info> cldEntityItemRelationList;
	
	/** �ʲ����ϵ�༭����Ϣ */
	protected IG313Info entityItemRelation;
	
	/** �ʲ���������Ϣ������� */
	protected Map<String,List<IG800Info>> configItemMap;

	/** �ʲ����ϵɾ������ */
	protected String[] deleteEntityItemRelation;
	protected Map<String,List<IG313Info>> parEntityItemRelationMap;
	protected Map<String,List<SOC0119Info>> socParEntityItemRelationMap;
	protected Map<String,List<IG313Info>> cldEntityItemRelationMap;
	protected Map<String,List<SOC0119Info>> socCldEntityItemRelationMap;
	protected int parCount;
	protected int cldCount;
	
	/** �ʲ���������Ϣ������� */
	protected Map<String,List<IG002Info>> configItemVWInfoMap;

	
	/** �û����� */
	private User user;
	
	/** Ȩ�ޱ�ʶ */
	protected Boolean flag;
	
	/** �ʲ��汾�б� */
	protected List<IG887Info> configItemVersionTime;
	/** �ʲ��汾�б� */
	protected List<SOC0128Info> socConfigItemVersionTime;
	
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}
	
	public Map<String, List<IG313Info>> getParEntityItemRelationMap() {
		return parEntityItemRelationMap;
	}

	public void setParEntityItemRelationMap(
			Map<String, List<IG313Info>> parEntityItemRelationMap) {
		this.parEntityItemRelationMap = parEntityItemRelationMap;
	}

	public Map<String, List<IG313Info>> getCldEntityItemRelationMap() {
		return cldEntityItemRelationMap;
	}

	public void setCldEntityItemRelationMap(
			Map<String, List<IG313Info>> cldEntityItemRelationMap) {
		this.cldEntityItemRelationMap = cldEntityItemRelationMap;
	}

	public int getParCount() {
		return parCount;
	}

	public void setParCount(int parCount) {
		this.parCount = parCount;
	}

	public int getCldCount() {
		return cldCount;
	}

	public void setCldCount(int cldCount) {
		this.cldCount = cldCount;
	}
	/**
	 * �ʲ�����Ϣ��������ȡ��
	 * @return �ʲ�����Ϣ��������
	 */
	public IG688SearchCond getEntityItemVWSearchCond() {
		return entityItemVWSearchCond;
	}

	/**
	 * �ʲ�����Ϣ���������趨
	 *
	 * @param entityItemVWSearchCond �ʲ�����Ϣ��������
	 */
	public void setEntityItemVWSearchCond(
			IG688SearchCond entityItemVWSearchCond) {
		this.entityItemVWSearchCond = entityItemVWSearchCond;
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
	 * �ʲ���������ȡ��
	 * @return �ʲ���������
	 */
	public List<IG688Info> getEntityItemVWInfoList() {
		return entityItemVWInfoList;
	}

	/**
	 * �ʲ����������趨
	 *
	 * @param entityItemVWInfoList �ʲ���������
	 */
	public void setEntityItemVWInfoList(List<IG688Info> entityItemVWInfoList) {
		this.entityItemVWInfoList = entityItemVWInfoList;
	}

	/**
	 * �ʲ���ɾ������ȡ��
	 * @return �ʲ���ɾ������
	 */
	public String[] getDeleteEntityItem() {
		return deleteEntityItem;
	}

	/**
	 * �ʲ���ɾ�������趨
	 *
	 * @param deleteEntityItem �ʲ���ɾ������
	 */
	public void setDeleteEntityItem(String[] deleteEntityItem) {
		this.deleteEntityItem = deleteEntityItem;
	}

	/**
	 * �ʲ���������Ϣȡ��
	 * @return �ʲ���������Ϣ
	 */
	public IGASM1004Form getIgasm1004Form() {
		return igasm1004Form;
	}


	/**
	 * �ʲ���������Ϣ���������趨
	 *
	 * @param igasm1004Form �ʲ���������Ϣ��������
	 */
	public void setIgasm1004Form(IGASM1004Form igasm1004Form) {
		this.igasm1004Form = igasm1004Form;
	}

	/**
	 * �ʲ���������Ϣ�������ȡ��
	 * @return �ʲ���������Ϣ�������
	 */
	public List<IG002Info> getConfigItemVWInfoList() {
		return configItemVWInfoList;
	}

	/**
	 * �ʲ���������Ϣ��������趨
	 *
	 * @param configItemVWInfoList �ʲ���������Ϣ�������
	 */
	public void setConfigItemVWInfoList(List<IG002Info> configItemVWInfoList) {
		this.configItemVWInfoList = configItemVWInfoList;
	}

	/**
	 * �ʲ���������Ϣ�����ʲ�����Ϣȡ��
	 * @return �ʲ���������Ϣ�����ʲ�����Ϣ
	 */
	public IG688Info getEntityItemVWInfo() {
		return entityItemVWInfo;
	}

	/**
	 * �ʲ���������Ϣ�����ʲ�����Ϣ�趨
	 *
	 * @param entityItemVWInfo �ʲ���������Ϣ�����ʲ�����Ϣ
	 */
	public void setEntityItemVWInfo(IG688Info entityItemVWInfo) {
		this.entityItemVWInfo = entityItemVWInfo;
	}

	/**
	 * �ʲ���������Ϣ��ʷ��¼��������ȡ��
	 * @return �ʲ���������Ϣ��ʷ��¼��������
	 */
	public IGASM1005Form getIgasm1005Form() {
		return igasm1005Form;
	}

	/**
	 * �ʲ���������Ϣ��ʷ��¼���������趨
	 *
	 * @param igasm1005Form �ʲ���������Ϣ��ʷ��¼��������
	 */
	public void setIgasm1005Form(IGASM1005Form igasm1005Form) {
		this.igasm1005Form = igasm1005Form;
	}

	/**
	 * �ʲ���������Ϣ��ʷ��¼�������ȡ��
	 * @return �ʲ���������Ϣ��ʷ��¼�������
	 */
	public List<IG800Info> getConfigItemList() {
		return configItemList;
	}

	/**
	 * �ʲ���������Ϣ��ʷ��¼��������趨
	 *
	 * @param configItemList �ʲ���������Ϣ��ʷ��¼�������
	 */
	public void setConfigItemList(List<IG800Info> configItemList) {
		this.configItemList = configItemList;
	}

	/**
	 * �ʲ����ϵ�����������ȡ��
	 * @return �ʲ����ϵ�����������
	 */
	public IGASM1006Form getIgasm1006Form() {
		return igasm1006Form;
	}

	/**
	 * �ʲ����ϵ������������趨
	 *
	 * @param igasm1006Form �ʲ����ϵ�����������
	 */
	public void setIgasm1006Form(IGASM1006Form igasm1006Form) {
		this.igasm1006Form = igasm1006Form;
	}

	/**
	 * �ʲ����ϵ������Ϣ�������1ȡ��
	 * @return �ʲ����ϵ������Ϣ�������1
	 */
	public List<IG313Info> getParEntityItemRelationList() {
		return parEntityItemRelationList;
	}

	/**
	 * �ʲ����ϵ������Ϣ�������1�趨
	 *
	 * @param parEntityItemRelationList �ʲ����ϵ������Ϣ�������1
	 */
	public void setParEntityItemRelationList(
			List<IG313Info> parEntityItemRelationList) {
		this.parEntityItemRelationList = parEntityItemRelationList;
	}

	/**
	 * �ʲ����ϵ������Ϣ�������2ȡ��
	 * @return �ʲ����ϵ������Ϣ�������2
	 */
	public List<IG313Info> getCldEntityItemRelationList() {
		return cldEntityItemRelationList;
	}

	/**
	 * �ʲ����ϵ������Ϣ�������2�趨
	 *
	 * @param cldEntityItemRelationList �ʲ����ϵ������Ϣ�������2
	 */
	public void setCldEntityItemRelationList(
			List<IG313Info> cldEntityItemRelationList) {
		this.cldEntityItemRelationList = cldEntityItemRelationList;
	}

	/**
	 * �ʲ����ϵ�༭����Ϣȡ��
	 * @return �ʲ����ϵ�༭����Ϣ
	 */
	public IG313Info getEntityItemRelation() {
		return entityItemRelation;
	}

	/**
	 * �ʲ����ϵ�༭����Ϣ�趨
	 *
	 * @param entityItemRelation �ʲ����ϵ�༭����Ϣ
	 */
	public void setEntityItemRelation(IG313Info entityItemRelation) {
		this.entityItemRelation = entityItemRelation;
	}

	/**
	 * �ʲ����ϵɾ������ȡ��
	 * @return �ʲ����ϵɾ������
	 */
	public String[] getDeleteEntityItemRelation() {
		return deleteEntityItemRelation;
	}

	/**
	 * �ʲ����ϵɾ�������趨
	 *
	 * @param entityItemRelation �ʲ����ϵɾ������
	 */
	public void setDeleteEntityItemRelation(String[] deleteEntityItemRelation) {
		this.deleteEntityItemRelation = deleteEntityItemRelation;
	}
	
	/**
	 * �ʲ���������Ϣ�������ȡ��
	 * @return �ʲ���������Ϣ�������
	 */
	public Map<String, List<IG800Info>> getConfigItemMap() {
		return configItemMap;
	}
	/**
	 * �ʲ���������Ϣ��������趨
	 *
	 * @param configItemMap �ʲ���������Ϣ�������
	 */
	public void setConfigItemMap(
			Map<String, List<IG800Info>> configItemMap) {
		this.configItemMap = configItemMap;
	}
	
	/**
	 * �ʲ���������Ϣ�������ȡ��
	 * @return �ʲ���������Ϣ�������
	 */
	public Map<String, List<IG002Info>> getConfigItemVWInfoMap() {
		return configItemVWInfoMap;
	}
	/**
	 * �ʲ���������Ϣ��������趨
	 *
	 * @param configItemVWInfoMap �ʲ���������Ϣ�������
	 */
	public void setConfigItemVWInfoMap(
			Map<String, List<IG002Info>> configItemVWInfoMap) {
		this.configItemVWInfoMap = configItemVWInfoMap;
	}
	
	/**
	 * �ʲ��汾�б�ȡ��
	 * @return �ʲ��汾�б�
	 */
	public List<IG887Info> getConfigItemVersionTime() {
		return configItemVersionTime;
	}
	
	

	public SOC0124Info getSocEntityItemVWInfo() {
		return socEntityItemVWInfo;
	}

	public void setSocEntityItemVWInfo(SOC0124Info socEntityItemVWInfo) {
		this.socEntityItemVWInfo = socEntityItemVWInfo;
	}

	/**
	 * �ʲ��汾�б��趨
	 *
	 * @param configItemVersionTime �ʲ��汾�б�
	 */
	public void setConfigItemVersionTime(
			List<IG887Info> configItemVersionTime) {
		this.configItemVersionTime = configItemVersionTime;
	}

	public SOC0124SearchCond getSocEntityItemVWSearchCond() {
		return socEntityItemVWSearchCond;
	}

	public void setSocEntityItemVWSearchCond(
			SOC0124SearchCond socEntityItemVWSearchCond) {
		this.socEntityItemVWSearchCond = socEntityItemVWSearchCond;
	}

	public List<SOC0124Info> getSocEntityItemVWInfoList() {
		return socEntityItemVWInfoList;
	}

	public void setSocEntityItemVWInfoList(List<SOC0124Info> socEntityItemVWInfoList) {
		this.socEntityItemVWInfoList = socEntityItemVWInfoList;
	}

	public Map<String, List<SOC0129Info>> getSocConfigItemVWInfoMap() {
		return socConfigItemVWInfoMap;
	}

	public void setSocConfigItemVWInfoMap(
			Map<String, List<SOC0129Info>> socConfigItemVWInfoMap) {
		this.socConfigItemVWInfoMap = socConfigItemVWInfoMap;
	}

	public List<SOC0119Info> getSocParEntityItemRelationList() {
		return socParEntityItemRelationList;
	}

	public void setSocParEntityItemRelationList(
			List<SOC0119Info> socParEntityItemRelationList) {
		this.socParEntityItemRelationList = socParEntityItemRelationList;
	}

	public Map<String, List<SOC0119Info>> getSocParEntityItemRelationMap() {
		return socParEntityItemRelationMap;
	}

	public void setSocParEntityItemRelationMap(
			Map<String, List<SOC0119Info>> socParEntityItemRelationMap) {
		this.socParEntityItemRelationMap = socParEntityItemRelationMap;
	}

	public Map<String, List<SOC0119Info>> getSocCldEntityItemRelationMap() {
		return socCldEntityItemRelationMap;
	}

	public void setSocCldEntityItemRelationMap(
			Map<String, List<SOC0119Info>> socCldEntityItemRelationMap) {
		this.socCldEntityItemRelationMap = socCldEntityItemRelationMap;
	}

	public List<SOC0128Info> getSocConfigItemVersionTime() {
		return socConfigItemVersionTime;
	}

	public void setSocConfigItemVersionTime(
			List<SOC0128Info> socConfigItemVersionTime) {
		this.socConfigItemVersionTime = socConfigItemVersionTime;
	}
	
	
	
	

}


