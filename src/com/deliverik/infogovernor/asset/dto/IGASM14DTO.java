package com.deliverik.infogovernor.asset.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.asset.model.IG013Info;
import com.deliverik.framework.asset.model.condition.IG800SearchCond;
import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0119Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0128Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.asset.form.IGASM1402Form;
import com.deliverik.infogovernor.asset.form.IGASM1404Form;
import com.deliverik.infogovernor.asset.form.IGASM1405Form;
import com.deliverik.infogovernor.asset.form.IGASM1406Form;
import com.deliverik.infogovernor.asset.form.IGASM1407Form;
import com.deliverik.infogovernor.asset.form.IGASM1412Form;

/**
 * �����¼���ù���ҵ����DTO
 * 
 */
@SuppressWarnings("serial")
public class IGASM14DTO extends BaseDTO implements Serializable{

	protected IG800SearchCond configItemSearchCond;
	public IG800SearchCond getConfigItemSearchCond() {
		return configItemSearchCond;
	}

	public void setConfigItemSearchCond(IG800SearchCond configItemSearchCond) {
		this.configItemSearchCond = configItemSearchCond;
	}

	/** �����¼��Ϣ */
	protected IGASM1402Form igasm1402Form;
	
	/** �����¼��Ϣ�������� */
	protected SOC0124SearchCond entityItemVWSearchCond;
	
	/** ���������� */
	protected int maxSearchCount;

	/** ��ҳ��DTO */
	protected PagingDTO pagingDto;

	/** �����¼������� */
	protected List<SOC0124Info> entityItemVWInfoList;

	/** �����¼ɾ������ */
	protected String[] deleteEntityItem;

	/** �����¼������Ϣ */
	protected IGASM1404Form igasm1404Form;
	
	/** �����¼������Ϣ������� */
	protected List<SOC0129Info> configItemVWInfoList;

	/** �����¼������Ϣ��������¼��Ϣ */
	protected SOC0124Info entityItemVWInfo;

	/** �����¼������Ϣ��ʷ��¼�������� */
	protected IGASM1405Form igasm1405Form;
	
	/** �����¼������Ϣ��ʷ��¼������� */
	protected List<SOC0107Info> configItemList;
	
	/** �����¼��ϵ����������� */
	protected IGASM1406Form igasm1406Form;
	
	/** �ʲ����ϵ������Ϣ�������1 */
	protected List<SOC0119Info> parEntityItemRelationList;
	
	/** �ʲ����ϵ������Ϣ�������2 */
	protected List<SOC0119Info> cldEntityItemRelationList;
	
	/** �����¼��ϵ�༭��Ϣ */
	protected IGASM1407Form igasm1407Form;
	
	/** �����¼��ϵ�༭����Ϣ */
	protected SOC0119Info entityItemRelation;

	/** �����¼��ϵɾ������ */
	protected String[] deleteEntityItemRelation;
	
	/** �ʲ���������Ϣ������� */
	protected Map<String,List<SOC0129Info>> configItemVWInfoMap;
	
	/** �ʲ���������Ϣ������� */
	protected Map<String,List<SOC0107Info>> configItemMap;
	
	/**������id*/
	protected String userid;
	
	/**����������*/
	protected String username;
	
	protected String reciveUser;
	protected Map<String,List<SOC0119Info>> parEntityItemRelationMap;
	protected Map<String,List<SOC0119Info>> cldEntityItemRelationMap;
	protected int parCount;
	protected int cldCount;
	
	/** �����¼��Ϣ�޸� */
	protected IGASM1412Form igasm1412Form;
	
	/** �û����� */
	private User user;
	
	/** Ȩ�ޱ�ʶ */
	protected Boolean flag;
	
	/** ��������� */
	protected String orgsyscoding;
	
	/** ģ�Ͳ���� */
	protected String esyscoding;
	
	/** ģ������ */
	protected String ename;
	/** �����¼������� */
	protected List<SOC0118Info> entityItemList;
	
	/** �ʲ��汾�б� */
	protected List<SOC0128Info> configItemVersionTime;

	public List<SOC0118Info> getEntityItemList() {
		return entityItemList;
	}

	public void setEntityItemList(List<SOC0118Info> entityItemList) {
		this.entityItemList = entityItemList;
	}

	public String getOrgsyscoding() {
		return orgsyscoding;
	}

	public void setOrgsyscoding(String orgsyscoding) {
		this.orgsyscoding = orgsyscoding;
	}

	public String getEsyscoding() {
		return esyscoding;
	}

	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}
	
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
	
	
	public IGASM1412Form getIgasm1412Form() {
		return igasm1412Form;
	}

	public void setIgasm1412Form(IGASM1412Form igasm1412Form) {
		this.igasm1412Form = igasm1412Form;
	}
	public Map<String, List<SOC0119Info>> getParEntityItemRelationMap() {
		return parEntityItemRelationMap;
	}

	public void setParEntityItemRelationMap(
			Map<String, List<SOC0119Info>> parEntityItemRelationMap) {
		this.parEntityItemRelationMap = parEntityItemRelationMap;
	}

	public Map<String, List<SOC0119Info>> getCldEntityItemRelationMap() {
		return cldEntityItemRelationMap;
	}

	public void setCldEntityItemRelationMap(
			Map<String, List<SOC0119Info>> cldEntityItemRelationMap) {
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
	public String getReciveUser() {
		return reciveUser;
	}

	public void setReciveUser(String reciveUser) {
		this.reciveUser = reciveUser;
	}
	
	/** �����¼��������id */
	protected String orgid;
	
	/** �����¼��������name */
	protected String orgname;
	
	/** �����¼�·�ʱ�� */
	protected String issuetime;
	
	/** �����¼������ */
	protected String recivename;
	
	/** �����¼��ǰ�汾�� */
	protected String eiversion;
	
	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	public String getIssuetime() {
		return issuetime;
	}

	public void setIssuetime(String issuetime) {
		this.issuetime = issuetime;
	}

	public String getRecivename() {
		return recivename;
	}

	public void setRecivename(String recivename) {
		this.recivename = recivename;
	}

	public String getEiversion() {
		return eiversion;
	}

	public void setEiversion(String eiversion) {
		this.eiversion = eiversion;
	}

	public String getOrgid() {
		return orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}
	
	/** �����¼��Ϣ��������¼��Ϣ */
	protected IG013Info entityItem;
	
	public IG013Info getEntityItem() {
		return entityItem;
	}

	public void setEntityItem(IG013Info entityItem) {
		this.entityItem = entityItem;
	}
	/**
	 * �����¼��Ϣȡ��
	 * @return �����¼��Ϣ
	 */
	public IGASM1402Form getIgasm1402Form() {
		return igasm1402Form;
	}

	/**
	 * �����¼��Ϣ�趨
	 *
	 * @param igasm1402Form �����¼��Ϣ
	 */
	public void setIgasm1402Form(IGASM1402Form igasm1402Form) {
		this.igasm1402Form = igasm1402Form;
	}


	/**
	 * �����¼��Ϣ��������ȡ��
	 * @return �����¼��Ϣ��������
	 */
	public SOC0124SearchCond getEntityItemVWSearchCond() {
		return entityItemVWSearchCond;
	}

	/**
	 * �����¼��Ϣ���������趨
	 *
	 * @param entityItemVWSearchCond �����¼��Ϣ��������
	 */
	public void setEntityItemVWSearchCond(
			SOC0124SearchCond entityItemVWSearchCond) {
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
	 * �����¼�������ȡ��
	 * @return �����¼�������
	 */
	public List<SOC0124Info> getEntityItemVWInfoList() {
		return entityItemVWInfoList;
	}

	/**
	 * �����¼��������趨
	 *
	 * @param entityItemVWInfoList �����¼�������
	 */
	public void setEntityItemVWInfoList(List<SOC0124Info> entityItemVWInfoList) {
		this.entityItemVWInfoList = entityItemVWInfoList;
	}

	/**
	 * �����¼ɾ������ȡ��
	 * @return �����¼ɾ������
	 */
	public String[] getDeleteEntityItem() {
		return deleteEntityItem;
	}

	/**
	 * �����¼ɾ�������趨
	 *
	 * @param deleteEntityItem �����¼ɾ������
	 */
	public void setDeleteEntityItem(String[] deleteEntityItem) {
		this.deleteEntityItem = deleteEntityItem;
	}

	/**
	 * �����¼������Ϣȡ��
	 * @return �����¼������Ϣ
	 */
	public IGASM1404Form getIgasm1404Form() {
		return igasm1404Form;
	}


	/**
	 * �����¼������Ϣ���������趨
	 *
	 * @param igasm1404Form �����¼������Ϣ��������
	 */
	public void setIgasm1404Form(IGASM1404Form igasm1404Form) {
		this.igasm1404Form = igasm1404Form;
	}

	/**
	 * �����¼������Ϣ�������ȡ��
	 * @return �����¼������Ϣ�������
	 */
	public List<SOC0129Info> getConfigItemVWInfoList() {
		return configItemVWInfoList;
	}

	/**
	 * �����¼������Ϣ��������趨
	 *
	 * @param configItemVWInfoList �����¼������Ϣ�������
	 */
	public void setConfigItemVWInfoList(List<SOC0129Info> configItemVWInfoList) {
		this.configItemVWInfoList = configItemVWInfoList;
	}

	/**
	 * �����¼������Ϣ��������¼��Ϣȡ��
	 * @return �����¼������Ϣ��������¼��Ϣ
	 */
	public SOC0124Info getEntityItemVWInfo() {
		return entityItemVWInfo;
	}

	/**
	 * �����¼������Ϣ��������¼��Ϣ�趨
	 *
	 * @param entityItemVWInfo �����¼������Ϣ��������¼��Ϣ
	 */
	public void setEntityItemVWInfo(SOC0124Info entityItemVWInfo) {
		this.entityItemVWInfo = entityItemVWInfo;
	}

	/**
	 * �����¼������Ϣ��ʷ��¼��������ȡ��
	 * @return �����¼������Ϣ��ʷ��¼��������
	 */
	public IGASM1405Form getIgasm1405Form() {
		return igasm1405Form;
	}

	/**
	 * �����¼������Ϣ��ʷ��¼���������趨
	 *
	 * @param igasm1405Form �����¼������Ϣ��ʷ��¼��������
	 */
	public void setIgasm1405Form(IGASM1405Form igasm1405Form) {
		this.igasm1405Form = igasm1405Form;
	}

	/**
	 * �����¼������Ϣ��ʷ��¼�������ȡ��
	 * @return �����¼������Ϣ��ʷ��¼�������
	 */
	public List<SOC0107Info> getConfigItemList() {
		return configItemList;
	}

	/**
	 * �����¼������Ϣ��ʷ��¼��������趨
	 *
	 * @param configItemList �����¼������Ϣ��ʷ��¼�������
	 */
	public void setConfigItemList(List<SOC0107Info> configItemList) {
		this.configItemList = configItemList;
	}

	/**
	 * �����¼��ϵ�����������ȡ��
	 * @return �����¼��ϵ�����������
	 */
	public IGASM1406Form getIgasm1406Form() {
		return igasm1406Form;
	}

	/**
	 * �����¼��ϵ������������趨
	 *
	 * @param igasm1406Form �����¼��ϵ�����������
	 */
	public void setIgasm1406Form(IGASM1406Form igasm1406Form) {
		this.igasm1406Form = igasm1406Form;
	}

	/**
	 * �ʲ����ϵ������Ϣ�������1ȡ��
	 * @return �ʲ����ϵ������Ϣ�������1
	 */
	public List<SOC0119Info> getParEntityItemRelationList() {
		return parEntityItemRelationList;
	}

	/**
	 * �ʲ����ϵ������Ϣ�������1�趨
	 *
	 * @param parEntityItemRelationList �ʲ����ϵ������Ϣ�������1
	 */
	public void setParEntityItemRelationList(
			List<SOC0119Info> parEntityItemRelationList) {
		this.parEntityItemRelationList = parEntityItemRelationList;
	}

	/**
	 * �ʲ����ϵ������Ϣ�������2ȡ��
	 * @return �ʲ����ϵ������Ϣ�������2
	 */
	public List<SOC0119Info> getCldEntityItemRelationList() {
		return cldEntityItemRelationList;
	}

	/**
	 * �ʲ����ϵ������Ϣ�������2�趨
	 *
	 * @param cldEntityItemRelationList �ʲ����ϵ������Ϣ�������2
	 */
	public void setCldEntityItemRelationList(
			List<SOC0119Info> cldEntityItemRelationList) {
		this.cldEntityItemRelationList = cldEntityItemRelationList;
	}

	/**
	 * �����¼��ϵ�༭��Ϣȡ��
	 * @return �༭��Ϣ
	 */
	public IGASM1407Form getIgasm1407Form() {
		return igasm1407Form;
	}

	/**
	 * �����¼��ϵ�༭��Ϣ�趨
	 *
	 * @param igasm1407Form �����¼��ϵ�༭��Ϣ
	 */
	public void setIgasm1407Form(IGASM1407Form igasm1407Form) {
		this.igasm1407Form = igasm1407Form;
	}

	/**
	 * �����¼��ϵ�༭����Ϣȡ��
	 * @return �����¼��ϵ�༭����Ϣ
	 */
	public SOC0119Info getEntityItemRelation() {
		return entityItemRelation;
	}

	/**
	 * �����¼��ϵ�༭����Ϣ�趨
	 *
	 * @param entityItemRelation �����¼��ϵ�༭����Ϣ
	 */
	public void setEntityItemRelation(SOC0119Info entityItemRelation) {
		this.entityItemRelation = entityItemRelation;
	}

	/**
	 * �����¼��ϵɾ������ȡ��
	 * @return �����¼��ϵɾ������
	 */
	public String[] getDeleteEntityItemRelation() {
		return deleteEntityItemRelation;
	}

	/**
	 * �����¼��ϵɾ�������趨
	 *
	 * @param entityItemRelation �����¼��ϵɾ������
	 */
	public void setDeleteEntityItemRelation(String[] deleteEntityItemRelation) {
		this.deleteEntityItemRelation = deleteEntityItemRelation;
	}
	
	/**
	 * �ʲ���������Ϣ�������ȡ��
	 * @return �ʲ���������Ϣ�������
	 */
	public Map<String, List<SOC0129Info>> getConfigItemVWInfoMap() {
		return configItemVWInfoMap;
	}
	/**
	 * �ʲ���������Ϣ��������趨
	 *
	 * @param configItemVWInfoMap �ʲ���������Ϣ�������
	 */
	public void setConfigItemVWInfoMap(
			Map<String, List<SOC0129Info>> configItemVWInfoMap) {
		this.configItemVWInfoMap = configItemVWInfoMap;
	}
	
	/**
	 * �ʲ���������Ϣ�������ȡ��
	 * @return �ʲ���������Ϣ�������
	 */
	public Map<String, List<SOC0107Info>> getConfigItemMap() {
		return configItemMap;
	}
	/**
	 * �ʲ���������Ϣ��������趨
	 *
	 * @param configItemMap �ʲ���������Ϣ�������
	 */
	public void setConfigItemMap(
			Map<String, List<SOC0107Info>> configItemMap) {
		this.configItemMap = configItemMap;
	}

	/**
	 * ������idȡ��
	 * @return ������id
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * ������id�趨
	 *
	 * @param userid ������id
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * ����������ȡ��
	 * @return ����������
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * �����������趨
	 *
	 * @param username ����������
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * �ʲ��汾�б�ȡ��
	 * @return �ʲ��汾�б�
	 */
	public List<SOC0128Info> getConfigItemVersionTime() {
		return configItemVersionTime;
	}

	/**
	 * �ʲ��汾�б��趨
	 *
	 * @param configItemVersionTime �ʲ��汾�б�
	 */
	public void setConfigItemVersionTime(
			List<SOC0128Info> configItemVersionTime) {
		this.configItemVersionTime = configItemVersionTime;
	}
	
}


