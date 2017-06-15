package com.deliverik.infogovernor.asset.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.asset.model.IG013Info;
import com.deliverik.framework.asset.model.condition.IG800SearchCond;
import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.SOC0119Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0128Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.asset.form.IGASM1902Form;
import com.deliverik.infogovernor.asset.form.IGASM1904Form;
import com.deliverik.infogovernor.asset.form.IGASM1905Form;
import com.deliverik.infogovernor.asset.form.IGASM1906Form;
import com.deliverik.infogovernor.asset.form.IGASM1907Form;
import com.deliverik.infogovernor.asset.form.IGASM1912Form;

/**
 * ��Ա���ù���ҵ����DTO
 * 
 */
@SuppressWarnings("serial")
public class IGASM19DTO extends BaseDTO implements Serializable{

	protected IG800SearchCond configItemSearchCond;
	public IG800SearchCond getConfigItemSearchCond() {
		return configItemSearchCond;
	}

	public void setConfigItemSearchCond(IG800SearchCond configItemSearchCond) {
		this.configItemSearchCond = configItemSearchCond;
	}

	/** ��Ա��Ϣ */
	protected IGASM1902Form igasm1902Form;
	
	/** ��Ա��Ϣ�������� */
	protected SOC0124SearchCond entityItemVWSearchCond;
	
	/** ���������� */
	protected int maxSearchCount;

	/** ��ҳ��DTO */
	protected PagingDTO pagingDto;

	/** ��Ա������� */
	protected List<SOC0124Info> entityItemVWInfoList;

	/** ��Աɾ������ */
	protected String[] deleteEntityItem;

	/** ��Ա������Ϣ */
	protected IGASM1904Form igasm1904Form;
	
	/** ��Ա������Ϣ������� */
	protected List<SOC0129Info> configItemVWInfoList;

	/** ��Ա������Ϣ������Ա��Ϣ */
	protected SOC0124Info entityItemVWInfo;

	/** ��Ա������Ϣ��ʷ��¼�������� */
	protected IGASM1905Form igasm1905Form;
	
	/** ��Ա������Ϣ��ʷ��¼������� */
	protected List<SOC0107Info> configItemList;
	
	/** ��Ա��ϵ����������� */
	protected IGASM1906Form igasm1906Form;
	
	/** �ʲ����ϵ������Ϣ�������1 */
	protected List<SOC0119Info> parEntityItemRelationList;
	
	/** �ʲ����ϵ������Ϣ�������2 */
	protected List<SOC0119Info> cldEntityItemRelationList;
	
	/** ��Ա��ϵ�༭��Ϣ */
	protected IGASM1907Form igasm1907Form;
	
	/** ��Ա��ϵ�༭����Ϣ */
	protected SOC0119Info entityItemRelation;

	/** ��Ա��ϵɾ������ */
	protected String[] deleteEntityItemRelation;
	
	/** �ʲ���������Ϣ������� */
	protected Map<String,List<SOC0129Info>> configItemVWInfoMap;
	
	/** �ʲ���������Ϣ������� */
	protected Map<String,List<SOC0107Info>> configItemMap;
	
	/**������id*/
	protected String userid;
	
	/**����������*/
	protected String username;
	
	/** �ʲ������ϵ�����б� */
	protected List<LabelValueBean> relationList;
	
	protected String reciveUser;
	protected Map<String,List<SOC0119Info>> parEntityItemRelationMap;
	protected Map<String,List<SOC0119Info>> cldEntityItemRelationMap;
	protected int parCount;
	protected int cldCount;
	
	/** ��Ա������������ */
	protected String eiorgname;
	/** ��Ա��Ϣ�޸� */
	protected IGASM1912Form igasm1912Form;
	
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
	
	/** �ʲ��汾�б� */
	protected List<SOC0128Info> configItemVersionTime;
	
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
	
	
	public IGASM1912Form getIgasm1912Form() {
		return igasm1912Form;
	}

	public void setIgasm1912Form(IGASM1912Form igasm1912Form) {
		this.igasm1912Form = igasm1912Form;
	}

	public String getEiorgname() {
		return eiorgname;
	}

	public void setEiorgname(String eiorgname) {
		this.eiorgname = eiorgname;
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
	
	/** ��Ա��������id */
	protected String orgid;
	
	/** ��Ա��������name */
	protected String orgname;
	
	/** ��Ա�·�ʱ�� */
	protected String issuetime;
	
	/** ��Ա������ */
	protected String recivename;
	
	/** ��Ա��ǰ�汾�� */
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
	
	/** ��Ա��Ϣ������Ա��Ϣ */
	protected IG013Info entityItem;
	
	public IG013Info getEntityItem() {
		return entityItem;
	}

	public void setEntityItem(IG013Info entityItem) {
		this.entityItem = entityItem;
	}
	/**
	 * ��Ա��Ϣȡ��
	 * @return ��Ա��Ϣ
	 */
	public IGASM1902Form getIgasm1902Form() {
		return igasm1902Form;
	}

	/**
	 * ��Ա��Ϣ�趨
	 *
	 * @param igasm1902Form ��Ա��Ϣ
	 */
	public void setIgasm1902Form(IGASM1902Form igasm1902Form) {
		this.igasm1902Form = igasm1902Form;
	}


	/**
	 * ��Ա��Ϣ��������ȡ��
	 * @return ��Ա��Ϣ��������
	 */
	public SOC0124SearchCond getEntityItemVWSearchCond() {
		return entityItemVWSearchCond;
	}

	/**
	 * ��Ա��Ϣ���������趨
	 *
	 * @param entityItemVWSearchCond ��Ա��Ϣ��������
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
	 * ��Ա�������ȡ��
	 * @return ��Ա�������
	 */
	public List<SOC0124Info> getEntityItemVWInfoList() {
		return entityItemVWInfoList;
	}

	/**
	 * ��Ա��������趨
	 *
	 * @param entityItemVWInfoList ��Ա�������
	 */
	public void setEntityItemVWInfoList(List<SOC0124Info> entityItemVWInfoList) {
		this.entityItemVWInfoList = entityItemVWInfoList;
	}

	/**
	 * ��Աɾ������ȡ��
	 * @return ��Աɾ������
	 */
	public String[] getDeleteEntityItem() {
		return deleteEntityItem;
	}

	/**
	 * ��Աɾ�������趨
	 *
	 * @param deleteEntityItem ��Աɾ������
	 */
	public void setDeleteEntityItem(String[] deleteEntityItem) {
		this.deleteEntityItem = deleteEntityItem;
	}

	/**
	 * ��Ա������Ϣȡ��
	 * @return ��Ա������Ϣ
	 */
	public IGASM1904Form getIgasm1904Form() {
		return igasm1904Form;
	}


	/**
	 * ��Ա������Ϣ���������趨
	 *
	 * @param igasm1904Form ��Ա������Ϣ��������
	 */
	public void setIgasm1904Form(IGASM1904Form igasm1904Form) {
		this.igasm1904Form = igasm1904Form;
	}

	/**
	 * ��Ա������Ϣ�������ȡ��
	 * @return ��Ա������Ϣ�������
	 */
	public List<SOC0129Info> getConfigItemVWInfoList() {
		return configItemVWInfoList;
	}

	/**
	 * ��Ա������Ϣ��������趨
	 *
	 * @param configItemVWInfoList ��Ա������Ϣ�������
	 */
	public void setConfigItemVWInfoList(List<SOC0129Info> configItemVWInfoList) {
		this.configItemVWInfoList = configItemVWInfoList;
	}

	/**
	 * ��Ա������Ϣ������Ա��Ϣȡ��
	 * @return ��Ա������Ϣ������Ա��Ϣ
	 */
	public SOC0124Info getEntityItemVWInfo() {
		return entityItemVWInfo;
	}

	/**
	 * ��Ա������Ϣ������Ա��Ϣ�趨
	 *
	 * @param entityItemVWInfo ��Ա������Ϣ������Ա��Ϣ
	 */
	public void setEntityItemVWInfo(SOC0124Info entityItemVWInfo) {
		this.entityItemVWInfo = entityItemVWInfo;
	}

	/**
	 * ��Ա������Ϣ��ʷ��¼��������ȡ��
	 * @return ��Ա������Ϣ��ʷ��¼��������
	 */
	public IGASM1905Form getIgasm1905Form() {
		return igasm1905Form;
	}

	/**
	 * ��Ա������Ϣ��ʷ��¼���������趨
	 *
	 * @param igasm1905Form ��Ա������Ϣ��ʷ��¼��������
	 */
	public void setIgasm1905Form(IGASM1905Form igasm1905Form) {
		this.igasm1905Form = igasm1905Form;
	}

	/**
	 * ��Ա������Ϣ��ʷ��¼�������ȡ��
	 * @return ��Ա������Ϣ��ʷ��¼�������
	 */
	public List<SOC0107Info> getConfigItemList() {
		return configItemList;
	}

	/**
	 * ��Ա������Ϣ��ʷ��¼��������趨
	 *
	 * @param configItemList ��Ա������Ϣ��ʷ��¼�������
	 */
	public void setConfigItemList(List<SOC0107Info> configItemList) {
		this.configItemList = configItemList;
	}

	/**
	 * ��Ա��ϵ�����������ȡ��
	 * @return ��Ա��ϵ�����������
	 */
	public IGASM1906Form getIgasm1906Form() {
		return igasm1906Form;
	}

	/**
	 * ��Ա��ϵ������������趨
	 *
	 * @param igasm1906Form ��Ա��ϵ�����������
	 */
	public void setIgasm1906Form(IGASM1906Form igasm1906Form) {
		this.igasm1906Form = igasm1906Form;
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
	 * ��Ա��ϵ�༭��Ϣȡ��
	 * @return �༭��Ϣ
	 */
	public IGASM1907Form getIgasm1907Form() {
		return igasm1907Form;
	}

	/**
	 * ��Ա��ϵ�༭��Ϣ�趨
	 *
	 * @param igasm1907Form ��Ա��ϵ�༭��Ϣ
	 */
	public void setIgasm1907Form(IGASM1907Form igasm1907Form) {
		this.igasm1907Form = igasm1907Form;
	}

	/**
	 * ��Ա��ϵ�༭����Ϣȡ��
	 * @return ��Ա��ϵ�༭����Ϣ
	 */
	public SOC0119Info getEntityItemRelation() {
		return entityItemRelation;
	}

	/**
	 * ��Ա��ϵ�༭����Ϣ�趨
	 *
	 * @param entityItemRelation ��Ա��ϵ�༭����Ϣ
	 */
	public void setEntityItemRelation(SOC0119Info entityItemRelation) {
		this.entityItemRelation = entityItemRelation;
	}

	/**
	 * ��Ա��ϵɾ������ȡ��
	 * @return ��Ա��ϵɾ������
	 */
	public String[] getDeleteEntityItemRelation() {
		return deleteEntityItemRelation;
	}

	/**
	 * ��Ա��ϵɾ�������趨
	 *
	 * @param entityItemRelation ��Ա��ϵɾ������
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
	 * �ʲ������ϵ�����б�ȡ��
	 * @return �ʲ������ϵ�����б�
	 */
	public List<LabelValueBean> getRelationList() {
		return relationList;
	}
	
	/**
	 * �ʲ������ϵ�����б��趨
	 *
	 * @param username �ʲ������ϵ�����б�
	 */
	public void setRelationList(List<LabelValueBean> relationList) {
		this.relationList = relationList;
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


