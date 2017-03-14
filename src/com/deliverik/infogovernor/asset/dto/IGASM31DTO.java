package com.deliverik.infogovernor.asset.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.SOC0109Info;
import com.deliverik.framework.soc.asset.model.SOC0119Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0128Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.framework.soc.asset.model.SOC0151Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.asset.form.IGASM3101Form;
import com.deliverik.infogovernor.asset.form.IGASM3102Form;
import com.deliverik.infogovernor.asset.form.IGASM3104Form;
import com.deliverik.infogovernor.asset.form.IGASM3105Form;
import com.deliverik.infogovernor.asset.form.IGASM3106Form;
import com.deliverik.infogovernor.asset.form.IGASM3107Form;
import com.deliverik.infogovernor.asset.form.IGASM3112Form;
import com.deliverik.infogovernor.asset.model.RiskIndexSearchVWInfo;
import com.deliverik.infogovernor.asset.form.IGASM3115Form;
import com.deliverik.infogovernor.asset.form.IGASM3116Form;
import com.deliverik.infogovernor.asset.model.MaintenanceInfo;
import com.deliverik.infogovernor.asset.model.RiskIndexContextVWInfo;
import com.deliverik.infogovernor.asset.model.RiskIndexShowVWInfo;
/**
 * ��������ù���ҵ����DTO
 * 
 */
@SuppressWarnings("serial")
public class IGASM31DTO extends BaseDTO implements Serializable{

	/** �������Ϣ */
	protected IGASM3102Form igasm3102Form;
	
	protected String hiddenmguserid;
	
	protected String identyFlag;

	/** �������Ϣ�������� */
	protected SOC0124SearchCond entityItemVWSearchCond;
	
	/** ���������� */
	protected int maxSearchCount;

	/** ��ҳ��DTO */
	protected PagingDTO pagingDto;

	/** ����������� */
	protected List<SOC0124Info> entityItemVWInfoList;

	/** �����ɾ������ */
	protected String[] deleteEntityItem;

	/** �����������Ϣ */
	protected IGASM3104Form igasm3104Form;
	
	/** �����������Ϣ������� */
	protected List<SOC0129Info> configItemVWInfoList;

	/** �����������Ϣ����������Ϣ */
	protected SOC0124Info entityItemVWInfo;

	/** �����������Ϣ��ʷ��¼�������� */
	protected IGASM3105Form igasm3105Form;
	
	/** �����������Ϣ��ʷ��¼������� */
	protected List<SOC0107Info> configItemList;
	
	/** ������ϵ����������� */
	protected IGASM3106Form igasm3106Form;
	
	/** �ʲ����ϵ������Ϣ�������1 */
	protected List<SOC0119Info> parEntityItemRelationList;
	
	/** �ʲ����ϵ������Ϣ�������2 */
	protected List<SOC0119Info> cldEntityItemRelationList;
	
	/** ������ϵ�༭��Ϣ */
	protected IGASM3107Form igasm3107Form;
	
	/** ������ϵ�༭����Ϣ */
	protected SOC0119Info entityItemRelation;

	/** ������ϵɾ������ */
	protected String[] deleteEntityItemRelation;
	
	protected Map<Integer,Integer> checkVersionMap;
	
	/** �ʲ������ϵ�����б� */
	protected List<LabelValueBean> relationList;
	
	/** �ʲ���������Ϣ������� */
	protected Map<String,List<SOC0107Info>> configItemMap;
	
	/** �ʲ���������Ϣ������� */
	protected Map<String,List<SOC0129Info>> configItemVWInfoMap;
	
	protected Map<String,List<SOC0119Info>> parEntityItemRelationMap;
	protected Map<String,List<SOC0119Info>> cldEntityItemRelationMap;
	protected int parCount;
	protected int cldCount;
	/** ����������������� */
	protected String eiorgname;
	protected IGASM3112Form igasm3112Form;
	
	protected IGASM3115Form igasm3115Form;
	protected MaintenanceInfo searchMaintenanceByPK;
	
	/**
	 * searchMaintenanceByPKȡ��
	 * @return searchMaintenanceByPK searchMaintenanceByPK
	 */
	public MaintenanceInfo getSearchMaintenanceByPK() {
		return searchMaintenanceByPK;
	}

	/**
	 * searchMaintenanceByPK�趨
	 * @param searchMaintenanceByPK searchMaintenanceByPK
	 */
	public void setSearchMaintenanceByPK(MaintenanceInfo searchMaintenanceByPK) {
		this.searchMaintenanceByPK = searchMaintenanceByPK;
	}

	/**����ָ�����չʾ*/
	protected List<RiskIndexContextVWInfo> searchRiskIndexContextVW;
	
	/**
	 * ����ָ�����չʾȡ��
	 * @return searchRiskIndexContextVW ����ָ�����չʾ
	 */
	public List<RiskIndexContextVWInfo> getSearchRiskIndexContextVW() {
		return searchRiskIndexContextVW;
	}

	/**
	 * ����ָ�����չʾ�趨
	 * @param searchRiskIndexContextVW ����ָ�����չʾ
	 */
	public void setSearchRiskIndexContextVW(
			List<RiskIndexContextVWInfo> searchRiskIndexContextVW) {
		this.searchRiskIndexContextVW = searchRiskIndexContextVW;
	}

	
	/**
	 * @return the hiddenmguserid
	 */
	public String getHiddenmguserid() {
		return hiddenmguserid;
	}

	/**
	 * @param hiddenmguserid the hiddenmguserid to set
	 */
	public void setHiddenmguserid(String hiddenmguserid) {
		this.hiddenmguserid = hiddenmguserid;
	}

	/**
	 * igasm3116formȡ��
	 * @return igasm3116form igasm3116form
	 */
	public IGASM3116Form getIgasm3116form() {
		return igasm3116form;
	}

	
	/**
	 * @return the identyFlag
	 */
	public String getIdentyFlag() {
		return identyFlag;
	}

	/**
	 * @param identyFlag the identyFlag to set
	 */
	public void setIdentyFlag(String identyFlag) {
		this.identyFlag = identyFlag;
	}

	/**
	 * igasm3116form�趨
	 * @param igasm3116form igasm3116form
	 */
	public void setIgasm3116form(IGASM3116Form igasm3116form) {
		this.igasm3116form = igasm3116form;
	}

	protected IGASM3116Form igasm3116form;
	
	/**
	 * igasm3115Formȡ��
	 * @return igasm3115Form igasm3115Form
	 */
	public IGASM3115Form getIgasm3115Form() {
		return igasm3115Form;
	}

	/**
	 * igasm3115Form�趨
	 * @param igasm3115Form igasm3115Form
	 */
	public void setIgasm3115Form(IGASM3115Form igasm3115Form) {
		this.igasm3115Form = igasm3115Form;
	}

	/** �û����� */
	private User user;
	
	/** Ȩ�ޱ�ʶ */
	protected Boolean flag;
	
	/** ��������� */
	protected String orgsyscoding;
	
	/** �������� */
	protected String orgname;
	
	/** ģ�Ͳ���� */
	protected String esyscoding;
	
	/** ģ������ */
	protected String ename;
	
	/** �ʲ��汾�б� */
	protected List<SOC0128Info> configItemVersionTime;
	/**����ָ��չʾ*/
	protected List<RiskIndexShowVWInfo> riskIndexShowList;
	
	/**
	 * ����ָ��չʾȡ��
	 * @return riskIndexShowList ����ָ��չʾ
	 */
	public List<RiskIndexShowVWInfo> getRiskIndexShowList() {
		return riskIndexShowList;
	}

	/**
	 * ����ָ��չʾ�趨
	 * @param riskIndexShowList ����ָ��չʾ
	 */
	public void setRiskIndexShowList(List<RiskIndexShowVWInfo> riskIndexShowList) {
		this.riskIndexShowList = riskIndexShowList;
	}

	/**����ָ��--�Ƿ�ؼ�ָ������*/
	protected List<SOC0151Info> keyIndexList;
	
	/**����ָ��--ָ��ģ������*/
	protected List<SOC0151Info> titList;
	
	/**����ָ��--��ֵ����*/
	protected List<SOC0151Info> thresholdList;
	
	/**����ָ��������Ϣ����*/
	protected List<SOC0109Info> soc0109List;
	
	/**����ָ��Ǽǳɹ��󷵻�ҳ������ֵ*/
	protected Integer eiid;
	
	/**����ָ���ѯ���ؼ���*/
	protected List<RiskIndexSearchVWInfo> searchRiskIndexSearchVWList;
	
	/** ����ָ���ѯ */
	protected IGASM3101Form IGASM3101FORM;
	
	
	/**˵��*/
	protected String fingerprint;
	
	/** ����ID */
	protected Integer riid;

	/** ģ������ */
	protected String rimtype;

	/** ���㷽�� */
	protected String rimdesc;

	/** SQL��� */
	protected String rimsql;
	
	
	
	
	public String getFingerprint() {
		return fingerprint;
	}

	public void setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
	}

	public Integer getRiid() {
		return riid;
	}

	public void setRiid(Integer riid) {
		this.riid = riid;
	}

	public String getRimtype() {
		return rimtype;
	}

	public void setRimtype(String rimtype) {
		this.rimtype = rimtype;
	}

	public String getRimdesc() {
		return rimdesc;
	}

	public void setRimdesc(String rimdesc) {
		this.rimdesc = rimdesc;
	}

	public String getRimsql() {
		return rimsql;
	}

	public void setRimsql(String rimsql) {
		this.rimsql = rimsql;
	}

	public String getOrgsyscoding() {
		return orgsyscoding;
	}

	public void setOrgsyscoding(String orgsyscoding) {
		this.orgsyscoding = orgsyscoding;
	}

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	public Map<Integer, Integer> getCheckVersionMap() {
		return checkVersionMap;
	}

	public void setCheckVersionMap(Map<Integer, Integer> checkVersionMap) {
		this.checkVersionMap = checkVersionMap;
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
	
	
	public IGASM3112Form getIgasm3112Form() {
		return igasm3112Form;
	}

	public void setIgasm3112Form(IGASM3112Form igasm3112Form) {
		this.igasm3112Form = igasm3112Form;
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
	/**
	 * �������Ϣȡ��
	 * @return �������Ϣ
	 */
	public IGASM3102Form getIgasm3102Form() {
		return igasm3102Form;
	}

	/**
	 * �������Ϣ�趨
	 *
	 * @param igasm3102Form �������Ϣ
	 */
	public void setIgasm3102Form(IGASM3102Form igasm3102Form) {
		this.igasm3102Form = igasm3102Form;
	}

	/**
	 * �������Ϣ��������ȡ��
	 * @return �������Ϣ��������
	 */
	public SOC0124SearchCond getEntityItemVWSearchCond() {
		return entityItemVWSearchCond;
	}

	/**
	 * �������Ϣ���������趨
	 *
	 * @param entityItemVWSearchCond �������Ϣ��������
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
	 * �����������ȡ��
	 * @return �����������
	 */
	public List<SOC0124Info> getEntityItemVWInfoList() {
		return entityItemVWInfoList;
	}

	/**
	 * ������������趨
	 *
	 * @param entityItemVWInfoList �����������
	 */
	public void setEntityItemVWInfoList(List<SOC0124Info> entityItemVWInfoList) {
		this.entityItemVWInfoList = entityItemVWInfoList;
	}

	/**
	 * �����ɾ������ȡ��
	 * @return �����ɾ������
	 */
	public String[] getDeleteEntityItem() {
		return deleteEntityItem;
	}

	/**
	 * �����ɾ�������趨
	 *
	 * @param deleteEntityItem �����ɾ������
	 */
	public void setDeleteEntityItem(String[] deleteEntityItem) {
		this.deleteEntityItem = deleteEntityItem;
	}

	/**
	 * �����������Ϣȡ��
	 * @return �����������Ϣ
	 */
	public IGASM3104Form getIgasm3104Form() {
		return igasm3104Form;
	}


	/**
	 * �����������Ϣ���������趨
	 *
	 * @param igasm3104Form �����������Ϣ��������
	 */
	public void setIgasm3104Form(IGASM3104Form igasm3104Form) {
		this.igasm3104Form = igasm3104Form;
	}

	/**
	 * �����������Ϣ�������ȡ��
	 * @return �����������Ϣ�������
	 */
	public List<SOC0129Info> getConfigItemVWInfoList() {
		return configItemVWInfoList;
	}

	/**
	 * �����������Ϣ��������趨
	 *
	 * @param configItemVWInfoList �����������Ϣ�������
	 */
	public void setConfigItemVWInfoList(List<SOC0129Info> configItemVWInfoList) {
		this.configItemVWInfoList = configItemVWInfoList;
	}

	/**
	 * �����������Ϣ����������Ϣȡ��
	 * @return �����������Ϣ����������Ϣ
	 */
	public SOC0124Info getEntityItemVWInfo() {
		return entityItemVWInfo;
	}

	/**
	 * �����������Ϣ����������Ϣ�趨
	 *
	 * @param entityItemVWInfo �����������Ϣ����������Ϣ
	 */
	public void setEntityItemVWInfo(SOC0124Info entityItemVWInfo) {
		this.entityItemVWInfo = entityItemVWInfo;
	}

	/**
	 * �����������Ϣ��ʷ��¼��������ȡ��
	 * @return �����������Ϣ��ʷ��¼��������
	 */
	public IGASM3105Form getIgasm3105Form() {
		return igasm3105Form;
	}

	/**
	 * �����������Ϣ��ʷ��¼���������趨
	 *
	 * @param igasm3105Form �����������Ϣ��ʷ��¼��������
	 */
	public void setIgasm3105Form(IGASM3105Form igasm3105Form) {
		this.igasm3105Form = igasm3105Form;
	}

	/**
	 * �����������Ϣ��ʷ��¼�������ȡ��
	 * @return �����������Ϣ��ʷ��¼�������
	 */
	public List<SOC0107Info> getConfigItemList() {
		return configItemList;
	}

	/**
	 * �����������Ϣ��ʷ��¼��������趨
	 *
	 * @param configItemList �����������Ϣ��ʷ��¼�������
	 */
	public void setConfigItemList(List<SOC0107Info> configItemList) {
		this.configItemList = configItemList;
	}

	/**
	 * ������ϵ�����������ȡ��
	 * @return ������ϵ�����������
	 */
	public IGASM3106Form getIgasm3106Form() {
		return igasm3106Form;
	}

	/**
	 * ������ϵ������������趨
	 *
	 * @param igasm3106Form ������ϵ�����������
	 */
	public void setIgasm3106Form(IGASM3106Form igasm3106Form) {
		this.igasm3106Form = igasm3106Form;
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
	 * ������ϵ�༭��Ϣȡ��
	 * @return �༭��Ϣ
	 */
	public IGASM3107Form getIgasm3107Form() {
		return igasm3107Form;
	}

	/**
	 * ������ϵ�༭��Ϣ�趨
	 *
	 * @param igasm3107Form ������ϵ�༭��Ϣ
	 */
	public void setIgasm3107Form(IGASM3107Form igasm3107Form) {
		this.igasm3107Form = igasm3107Form;
	}

	/**
	 * ������ϵ�༭����Ϣȡ��
	 * @return ������ϵ�༭����Ϣ
	 */
	public SOC0119Info getEntityItemRelation() {
		return entityItemRelation;
	}

	/**
	 * ������ϵ�༭����Ϣ�趨
	 *
	 * @param entityItemRelation ������ϵ�༭����Ϣ
	 */
	public void setEntityItemRelation(SOC0119Info entityItemRelation) {
		this.entityItemRelation = entityItemRelation;
	}

	/**
	 * ������ϵɾ������ȡ��
	 * @return ������ϵɾ������
	 */
	public String[] getDeleteEntityItemRelation() {
		return deleteEntityItemRelation;
	}

	/**
	 * ������ϵɾ�������趨
	 *
	 * @param entityItemRelation ������ϵɾ������
	 */
	public void setDeleteEntityItemRelation(String[] deleteEntityItemRelation) {
		this.deleteEntityItemRelation = deleteEntityItemRelation;
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

	/**
	 * ����ָ��--�Ƿ�ؼ�ָ������ȡ��
	 * @return list����
	 */
	public List<SOC0151Info> getKeyIndexList() {
		return keyIndexList;
	}
	/**
	 * ����ָ��--�Ƿ�ؼ�ָ�������趨
	 */
	public void setKeyIndexList(List<SOC0151Info> keyIndexList) {
		this.keyIndexList = keyIndexList;
	}
	/**
	 * ����ָ��--ָ��ģ������ȡ��
	 * @return list����
	 */
	public List<SOC0151Info> getTitList() {
		return titList;
	}
	/**
	 * ����ָ��--ָ��ģ�������趨
	 */
	public void setTitList(List<SOC0151Info> titList) {
		this.titList = titList;
	}
	/**
	 * ����ָ��--��ֵ����ȡ��
	 * @return list����
	 */
	public List<SOC0151Info> getThresholdList() {
		return thresholdList;
	}
	/**
	 * ����ָ��--��ֵ�����趨
	 */
	public void setThresholdList(List<SOC0151Info> thresholdList) {
		this.thresholdList = thresholdList;
	}

	public List<SOC0109Info> getSoc0109List() {
		return soc0109List;
	}

	public void setSoc0109List(List<SOC0109Info> soc0109List) {
		this.soc0109List = soc0109List;
	}

	public Integer getEiid() {
		return eiid;
	}

	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	public List<RiskIndexSearchVWInfo> getSearchRiskIndexSearchVWList() {
		return searchRiskIndexSearchVWList;
	}

	public void setSearchRiskIndexSearchVWList(
			List<RiskIndexSearchVWInfo> searchRiskIndexSearchVWList) {
		this.searchRiskIndexSearchVWList = searchRiskIndexSearchVWList;
	}

	public IGASM3101Form getIGASM3101FORM() {
		return IGASM3101FORM;
	}

	public void setIGASM3101FORM(IGASM3101Form iGASM3101FORM) {
		IGASM3101FORM = iGASM3101FORM;
	}

}


