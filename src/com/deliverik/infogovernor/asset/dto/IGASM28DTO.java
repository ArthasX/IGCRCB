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
import com.deliverik.infogovernor.asset.form.IGASM2802Form;
import com.deliverik.infogovernor.asset.form.IGASM2804Form;
import com.deliverik.infogovernor.asset.form.IGASM2805Form;
import com.deliverik.infogovernor.asset.form.IGASM2806Form;
import com.deliverik.infogovernor.asset.form.IGASM2807Form;
import com.deliverik.infogovernor.asset.form.IGASM2812Form;
import com.deliverik.infogovernor.asset.form.IGASM2814Form;
import com.deliverik.infogovernor.asset.model.CheckItemVWInfo;
import com.deliverik.infogovernor.asset.model.CheckToRiskRelateVWInfo;
import com.deliverik.infogovernor.asset.model.RiskToZhRelateVWInfo;

/**
 * ��������ù���ҵ����DTO
 * 
 */
@SuppressWarnings("serial")
public class IGASM28DTO extends BaseDTO implements Serializable{

	/** �������Ϣ */
	protected IGASM2802Form igasm2802Form;
	
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
	protected IGASM2804Form igasm2804Form;
	
	/** �����������Ϣ������� */
	protected List<SOC0129Info> configItemVWInfoList;

	/** �����������Ϣ����������Ϣ */
	protected SOC0124Info entityItemVWInfo;

	/** �����������Ϣ��ʷ��¼�������� */
	protected IGASM2805Form igasm2805Form;
	
	/** �����������Ϣ��ʷ��¼������� */
	protected List<SOC0107Info> configItemList;
	
	/** ������ϵ����������� */
	protected IGASM2806Form igasm2806Form;
	
	/** �ʲ����ϵ������Ϣ�������1 */
	protected List<SOC0119Info> parEntityItemRelationList;
	
	/** �ʲ����ϵ������Ϣ�������2 */
	protected List<SOC0119Info> cldEntityItemRelationList;
	
	/** ������ϵ�༭��Ϣ */
	protected IGASM2807Form igasm2807Form;
	
	/** ������ϵ�༭����Ϣ */
	protected SOC0119Info entityItemRelation;

	/** ������ϵɾ������ */
	protected String[] deleteEntityItemRelation;
	
	/** �ʲ������ϵ�����б� */
	protected List<LabelValueBean> relationList;
	
	/** �ʲ���������Ϣ������� */
	protected Map<String,List<SOC0107Info>> configItemMap;
	
	/**�ʲ����Խ�����Ƶ�� ȡֵ��Χ����*/
	protected List<SOC0151Info> checkfrequencyList;
	
	/** �ʲ���������Ϣ������� */
	protected Map<String,List<SOC0129Info>> configItemVWInfoMap;
	
	
	/**�����������Ϣ*/
	protected List<SOC0109Info> soc0109List;
	
	/**�汾����*/
	protected Map<Integer,Integer> checkVersionMap;
	
	protected Map<String,List<SOC0119Info>> parEntityItemRelationMap;
	protected Map<String,List<SOC0119Info>> cldEntityItemRelationMap;
	protected int parCount;
	protected int cldCount;
	/** ����������������� */
	protected String eiorgname;
	protected IGASM2812Form igasm2812Form;
	
	protected Integer eiid;
	
	/**���յ��ʲ�FORM*/
	protected IGASM2814Form Igasm2814form;
	
	/**���յ��ѯ����*/
	private  List<CheckItemVWInfo> itemList;
	
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
	
	
	/**���������*/
	protected String[] civalue;
	
	/**�Ƿ���Ȩ���޸�*/
	protected String identyFlag; 
	
	/**������id*/
	protected String hiddenmguserid;
	
	/**����� ----���յ��ϵ����*/
	protected List<CheckToRiskRelateVWInfo> checkToRiskRelateList;
	/**�����---ָ��*/
	protected List<RiskToZhRelateVWInfo> riskToZhRelateList;
	
	/**
	 * �����---ָ��ȡ��
	 * @return riskToZhRelateList �����---ָ��
	 */
	public List<RiskToZhRelateVWInfo> getRiskToZhRelateList() {
		return riskToZhRelateList;
	}

	/**
	 * �����---ָ���趨
	 * @param riskToZhRelateList �����---ָ��
	 */
	public void setRiskToZhRelateList(List<RiskToZhRelateVWInfo> riskToZhRelateList) {
		this.riskToZhRelateList = riskToZhRelateList;
	}

	/**
	 * ������idȡ��
	 * @return hiddenmguserid ������id
	 */
	public String getHiddenmguserid() {
		return hiddenmguserid;
	}

	/**
	 * ������id�趨
	 * @param hiddenmguserid ������id
	 */
	public void setHiddenmguserid(String hiddenmguserid) {
		this.hiddenmguserid = hiddenmguserid;
	}

	/**
	 * �Ƿ���Ȩ���޸�ȡ��
	 * @return identyFlag �Ƿ���Ȩ���޸�
	 */
	public String getIdentyFlag() {
		return identyFlag;
	}

	/**
	 * �Ƿ���Ȩ���޸��趨
	 * @param identyFlag �Ƿ���Ȩ���޸�
	 */
	public void setIdentyFlag(String identyFlag) {
		this.identyFlag = identyFlag;
	}

	/**
	 * ���������ȡ��
	 * @return civalue ���������
	 */
	public String[] getCivalue() {
		return civalue;
	}

	/**
	 * ����������趨
	 * @param civalue ���������
	 */
	public void setCivalue(String[] civalue) {
		this.civalue = civalue;
	}

	/** �ʲ��汾�б� */
	protected List<SOC0128Info> configItemVersionTime;
	
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
	
	
	/**
	 * eiidȡ��
	 * @return eiid eiid
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * eiid�趨
	 * @param eiid eiid
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	public IGASM2812Form getIgasm2812Form() {
		return igasm2812Form;
	}

	public void setIgasm2812Form(IGASM2812Form igasm2812Form) {
		this.igasm2812Form = igasm2812Form;
	}
	/**
	 * �����������Ϣȡ��
	 * @return soc0109List �����������Ϣ
	 */
	public List<SOC0109Info> getSoc0109List() {
		return soc0109List;
	}

	/**
	 * �����������Ϣ�趨
	 * @param soc0109List �����������Ϣ
	 */
	public void setSoc0109List(List<SOC0109Info> soc0109List) {
		this.soc0109List = soc0109List;
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

	/**
	 * �汾����ȡ��
	 * @return checkVersionMap �汾����
	 */
	public Map<Integer, Integer> getCheckVersionMap() {
		return checkVersionMap;
	}

	/**
	 * �汾�����趨
	 * @param checkVersionMap �汾����
	 */
	public void setCheckVersionMap(Map<Integer, Integer> checkVersionMap) {
		this.checkVersionMap = checkVersionMap;
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
	public IGASM2802Form getIgasm2802Form() {
		return igasm2802Form;
	}

	/**
	 * �������Ϣ�趨
	 *
	 * @param igasm2802Form �������Ϣ
	 */
	public void setIgasm2802Form(IGASM2802Form igasm2802Form) {
		this.igasm2802Form = igasm2802Form;
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
	public IGASM2804Form getIgasm2804Form() {
		return igasm2804Form;
	}


	/**
	 * �����������Ϣ���������趨
	 *
	 * @param igasm2804Form �����������Ϣ��������
	 */
	public void setIgasm2804Form(IGASM2804Form igasm2804Form) {
		this.igasm2804Form = igasm2804Form;
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
	public IGASM2805Form getIgasm2805Form() {
		return igasm2805Form;
	}

	/**
	 * �����������Ϣ��ʷ��¼���������趨
	 *
	 * @param igasm2805Form �����������Ϣ��ʷ��¼��������
	 */
	public void setIgasm2805Form(IGASM2805Form igasm2805Form) {
		this.igasm2805Form = igasm2805Form;
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
	public IGASM2806Form getIgasm2806Form() {
		return igasm2806Form;
	}

	/**
	 * ������ϵ������������趨
	 *
	 * @param igasm2806Form ������ϵ�����������
	 */
	public void setIgasm2806Form(IGASM2806Form igasm2806Form) {
		this.igasm2806Form = igasm2806Form;
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
	public IGASM2807Form getIgasm2807Form() {
		return igasm2807Form;
	}

	/**
	 * ������ϵ�༭��Ϣ�趨
	 *
	 * @param igasm2807Form ������ϵ�༭��Ϣ
	 */
	public void setIgasm2807Form(IGASM2807Form igasm2807Form) {
		this.igasm2807Form = igasm2807Form;
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
	 * igasm2814formȡ��
	 * @return igasm2814form igasm2814form
	 */
	public IGASM2814Form getIgasm2814form() {
		return Igasm2814form;
	}

	/**
	 * igasm2814form�趨
	 * @param igasm2814form igasm2814form
	 */
	public void setIgasm2814form(IGASM2814Form igasm2814form) {
		Igasm2814form = igasm2814form;
	}

	/**
	 * ���յ��ѯ����ȡ��
	 * @return itemList ���յ��ѯ����
	 */
	public List<CheckItemVWInfo> getItemList() {
		return itemList;
	}

	/**
	 * ���յ��ѯ�����趨
	 * @param itemList ���յ��ѯ����
	 */
	public void setItemList(List<CheckItemVWInfo> itemList) {
		this.itemList = itemList;
	}

	/**
	 * �����----���յ��ϵ����ȡ��
	 * @return checkToRiskRelateList �����----���յ��ϵ����
	 */
	public List<CheckToRiskRelateVWInfo> getCheckToRiskRelateList() {
		return checkToRiskRelateList;
	}

	/**
	 * �����----���յ��ϵ�����趨
	 * @param checkToRiskRelateList �����----���յ��ϵ����
	 */
	public void setCheckToRiskRelateList(
			List<CheckToRiskRelateVWInfo> checkToRiskRelateList) {
		this.checkToRiskRelateList = checkToRiskRelateList;
	}

	/**
	 * �ʲ����Խ�����Ƶ��ȡֵ��Χ����ȡ��
	 * @return checkfrequencyList �ʲ����Խ�����Ƶ��ȡֵ��Χ����
	 */
	public List<SOC0151Info> getCheckfrequencyList() {
		return checkfrequencyList;
	}

	/**
	 * �ʲ����Խ�����Ƶ��ȡֵ��Χ�����趨
	 * @param checkfrequencyList �ʲ����Խ�����Ƶ��ȡֵ��Χ����
	 */
	public void setCheckfrequencyList(List<SOC0151Info> checkfrequencyList) {
		this.checkfrequencyList = checkfrequencyList;
	}

}


