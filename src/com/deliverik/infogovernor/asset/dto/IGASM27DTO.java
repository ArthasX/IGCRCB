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
import com.deliverik.infogovernor.asset.form.IGASM2702Form;
import com.deliverik.infogovernor.asset.form.IGASM2704Form;
import com.deliverik.infogovernor.asset.form.IGASM2705Form;
import com.deliverik.infogovernor.asset.form.IGASM2706Form;
import com.deliverik.infogovernor.asset.form.IGASM2707Form;
import com.deliverik.infogovernor.asset.form.IGASM2712Form;
import com.deliverik.infogovernor.asset.form.IGASM2713Form;
import com.deliverik.infogovernor.asset.model.RiskCheckVWInfo;
import com.deliverik.infogovernor.asset.model.RiskPointVMInfo;
import com.deliverik.infogovernor.asset.model.RiskToZhRelateVWInfo;

/**
 * ���յ����ù���ҵ����DTO
 * 
 */
@SuppressWarnings("serial")
public class IGASM27DTO extends BaseDTO implements Serializable{

	/** ���յ���Ϣ */
	protected IGASM2702Form igasm2702Form;
	
	/**���յ��ѯ*/
	protected IGASM2713Form igasm2713Form;
	
	/** ���յ���Ϣ�������� */
	protected SOC0124SearchCond entityItemVWSearchCond;
	
	/** ���������� */
	protected int maxSearchCount;

	/** ��ҳ��DTO */
	protected PagingDTO pagingDto;

	/** ���յ������� */
	protected List<SOC0124Info> entityItemVWInfoList;

	/** ���յ�ɾ������ */
	protected String[] deleteEntityItem;

	/** ���յ�������Ϣ */
	protected IGASM2704Form igasm2704Form;
	
	/** ���յ�������Ϣ������� */
	protected List<SOC0129Info> configItemVWInfoList;

	/** ���յ�������Ϣ������յ���Ϣ */
	protected SOC0124Info entityItemVWInfo;

	/** ���յ�������Ϣ��ʷ��¼�������� */
	protected IGASM2705Form igasm2705Form;
	
	/** ���յ�������Ϣ��ʷ��¼������� */
	protected List<SOC0107Info> configItemList;
	
	/** ���յ��ϵ����������� */
	protected IGASM2706Form igasm2706Form;
	
	/** �ʲ����ϵ������Ϣ�������1 */
	protected List<SOC0119Info> parEntityItemRelationList;
	
	/** �ʲ����ϵ������Ϣ�������2 */
	protected List<SOC0119Info> cldEntityItemRelationList;
	
	/** ���յ��ϵ�༭��Ϣ */
	protected IGASM2707Form igasm2707Form;
	
	/** ���յ��ϵ�༭����Ϣ */
	protected SOC0119Info entityItemRelation;

	/** ���յ��ϵɾ������ */
	protected String[] deleteEntityItemRelation;
	
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
	/** ���յ������������� */
	protected String eiorgname;
	protected IGASM2712Form igasm2712Form;
	
	/**���յ��ѯ */
	protected List<RiskPointVMInfo> riskPointList;
	/**�汾����*/
	protected Map<Integer,Integer> checkVersionMap;
	
	/**����---�����*/
	protected List<RiskCheckVWInfo> searchRiskCheckList;
	
	/**����---ָ���ϵ*/
	protected List<RiskToZhRelateVWInfo> riskToZhRelateList;
	
	/**
	 * ����---ָ���ϵȡ��
	 * @return riskToZhRelateList ����---ָ���ϵ
	 */
	public List<RiskToZhRelateVWInfo> getRiskToZhRelateList() {
		return riskToZhRelateList;
	}

	/**
	 * ����---ָ���ϵ�趨
	 * @param riskToZhRelateList ����---ָ���ϵ
	 */
	public void setRiskToZhRelateList(List<RiskToZhRelateVWInfo> riskToZhRelateList) {
		this.riskToZhRelateList = riskToZhRelateList;
	}

	/**
	 * ����---�����ȡ��
	 * @return searchRiskCheckList ����---�����
	 */
	public List<RiskCheckVWInfo> getSearchRiskCheckList() {
		return searchRiskCheckList;
	}

	/**
	 * ����---������趨
	 * @param searchRiskCheckList ����---�����
	 */
	public void setSearchRiskCheckList(List<RiskCheckVWInfo> searchRiskCheckList) {
		this.searchRiskCheckList = searchRiskCheckList;
	}

	/**������ID*/
	protected String  hiddenmguserid;
	
	/**
	 * ������IDȡ��
	 * @return hiddenmguserid ������ID
	 */
	public String getHiddenmguserid() {
		return hiddenmguserid;
	}

	/**
	 * ������ID�趨
	 * @param hiddenmguserid ������ID
	 */
	public void setHiddenmguserid(String hiddenmguserid) {
		this.hiddenmguserid = hiddenmguserid;
	}

	/**��ʶ �ܿ�����*/
	protected String identyFlag;
	
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

	/**
	 * ���յ��ѯȡ��
	 * @return riskPointList ���յ��ѯ
	 */
	public List<RiskPointVMInfo> getRiskPointList() {
		return riskPointList;
	}

	/**
	 * ���յ��ѯ�趨
	 * @param riskPointList ���յ��ѯ
	 */
	public void setRiskPointList(List<RiskPointVMInfo> riskPointList) {
		this.riskPointList = riskPointList;
	}

	/**���յ�����*/
	protected Integer eiid;
	
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
	
	/**�������صȼ����ϻ�ȡ*/
	protected List<SOC0151Info> gradeList;
	
	/**���ռ��𼯺ϻ�ȡ*/
	protected List<SOC0151Info> levelList;
	
	/**���յ������*/
	protected List<SOC0151Info> possibleList;
	
	/**���ձ�ʶ����*/
	protected List<SOC0151Info> signList;
	
	/**�����������Ϣ����*/
	protected List<SOC0109Info> soc0109List;
	
	/**���յ� ��ѯ ����*/
	protected List<RiskPointVMInfo> riskList;
	
	/**
	 * �����������Ϣ����ȡ��
	 * @return soc0109List �����������Ϣ����
	 */
	public List<SOC0109Info> getSoc0109List() {
		return soc0109List;
	}

	/**
	 * �����������Ϣ�����趨
	 * @param soc0109List �����������Ϣ����
	 */
	public void setSoc0109List(List<SOC0109Info> soc0109List) {
		this.soc0109List = soc0109List;
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
	
	
	public IGASM2712Form getIgasm2712Form() {
		return igasm2712Form;
	}

	public void setIgasm2712Form(IGASM2712Form igasm2712Form) {
		this.igasm2712Form = igasm2712Form;
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
	 * ���յ���Ϣȡ��
	 * @return ���յ���Ϣ
	 */
	public IGASM2702Form getIgasm2702Form() {
		return igasm2702Form;
	}

	/**
	 * ���յ���Ϣ�趨
	 *
	 * @param igasm2702Form ���յ���Ϣ
	 */
	public void setIgasm2702Form(IGASM2702Form igasm2702Form) {
		this.igasm2702Form = igasm2702Form;
	}

	/**
	 * ���յ���Ϣ��������ȡ��
	 * @return ���յ���Ϣ��������
	 */
	public SOC0124SearchCond getEntityItemVWSearchCond() {
		return entityItemVWSearchCond;
	}

	/**
	 * ���յ���Ϣ���������趨
	 *
	 * @param entityItemVWSearchCond ���յ���Ϣ��������
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
	 * ���յ�������ȡ��
	 * @return ���յ�������
	 */
	public List<SOC0124Info> getEntityItemVWInfoList() {
		return entityItemVWInfoList;
	}

	/**
	 * ���յ��������趨
	 *
	 * @param entityItemVWInfoList ���յ�������
	 */
	public void setEntityItemVWInfoList(List<SOC0124Info> entityItemVWInfoList) {
		this.entityItemVWInfoList = entityItemVWInfoList;
	}

	/**
	 * ���յ�ɾ������ȡ��
	 * @return ���յ�ɾ������
	 */
	public String[] getDeleteEntityItem() {
		return deleteEntityItem;
	}

	/**
	 * ���յ�ɾ�������趨
	 *
	 * @param deleteEntityItem ���յ�ɾ������
	 */
	public void setDeleteEntityItem(String[] deleteEntityItem) {
		this.deleteEntityItem = deleteEntityItem;
	}

	/**
	 * ���յ�������Ϣȡ��
	 * @return ���յ�������Ϣ
	 */
	public IGASM2704Form getIgasm2704Form() {
		return igasm2704Form;
	}


	/**
	 * ���յ�������Ϣ���������趨
	 *
	 * @param igasm2704Form ���յ�������Ϣ��������
	 */
	public void setIgasm2704Form(IGASM2704Form igasm2704Form) {
		this.igasm2704Form = igasm2704Form;
	}

	/**
	 * ���յ�������Ϣ�������ȡ��
	 * @return ���յ�������Ϣ�������
	 */
	public List<SOC0129Info> getConfigItemVWInfoList() {
		return configItemVWInfoList;
	}

	/**
	 * ���յ�������Ϣ��������趨
	 *
	 * @param configItemVWInfoList ���յ�������Ϣ�������
	 */
	public void setConfigItemVWInfoList(List<SOC0129Info> configItemVWInfoList) {
		this.configItemVWInfoList = configItemVWInfoList;
	}

	/**
	 * ���յ�������Ϣ������յ���Ϣȡ��
	 * @return ���յ�������Ϣ������յ���Ϣ
	 */
	public SOC0124Info getEntityItemVWInfo() {
		return entityItemVWInfo;
	}

	/**
	 * ���յ�������Ϣ������յ���Ϣ�趨
	 *
	 * @param entityItemVWInfo ���յ�������Ϣ������յ���Ϣ
	 */
	public void setEntityItemVWInfo(SOC0124Info entityItemVWInfo) {
		this.entityItemVWInfo = entityItemVWInfo;
	}

	/**
	 * ���յ�������Ϣ��ʷ��¼��������ȡ��
	 * @return ���յ�������Ϣ��ʷ��¼��������
	 */
	public IGASM2705Form getIgasm2705Form() {
		return igasm2705Form;
	}

	/**
	 * ���յ�������Ϣ��ʷ��¼���������趨
	 *
	 * @param igasm2705Form ���յ�������Ϣ��ʷ��¼��������
	 */
	public void setIgasm2705Form(IGASM2705Form igasm2705Form) {
		this.igasm2705Form = igasm2705Form;
	}

	/**
	 * ���յ�������Ϣ��ʷ��¼�������ȡ��
	 * @return ���յ�������Ϣ��ʷ��¼�������
	 */
	public List<SOC0107Info> getConfigItemList() {
		return configItemList;
	}

	/**
	 * ���յ�������Ϣ��ʷ��¼��������趨
	 *
	 * @param configItemList ���յ�������Ϣ��ʷ��¼�������
	 */
	public void setConfigItemList(List<SOC0107Info> configItemList) {
		this.configItemList = configItemList;
	}

	/**
	 * ���յ��ϵ�����������ȡ��
	 * @return ���յ��ϵ�����������
	 */
	public IGASM2706Form getIgasm2706Form() {
		return igasm2706Form;
	}

	/**
	 * ���յ��ϵ������������趨
	 *
	 * @param igasm2706Form ���յ��ϵ�����������
	 */
	public void setIgasm2706Form(IGASM2706Form igasm2706Form) {
		this.igasm2706Form = igasm2706Form;
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
	 * ���յ��ϵ�༭��Ϣȡ��
	 * @return �༭��Ϣ
	 */
	public IGASM2707Form getIgasm2707Form() {
		return igasm2707Form;
	}

	/**
	 * ���յ��ϵ�༭��Ϣ�趨
	 *
	 * @param igasm2707Form ���յ��ϵ�༭��Ϣ
	 */
	public void setIgasm2707Form(IGASM2707Form igasm2707Form) {
		this.igasm2707Form = igasm2707Form;
	}

	/**
	 * ���յ��ϵ�༭����Ϣȡ��
	 * @return ���յ��ϵ�༭����Ϣ
	 */
	public SOC0119Info getEntityItemRelation() {
		return entityItemRelation;
	}

	/**
	 * ���յ��ϵ�༭����Ϣ�趨
	 *
	 * @param entityItemRelation ���յ��ϵ�༭����Ϣ
	 */
	public void setEntityItemRelation(SOC0119Info entityItemRelation) {
		this.entityItemRelation = entityItemRelation;
	}

	/**
	 * ���յ��ϵɾ������ȡ��
	 * @return ���յ��ϵɾ������
	 */
	public String[] getDeleteEntityItemRelation() {
		return deleteEntityItemRelation;
	}

	/**
	 * ���յ��ϵɾ�������趨
	 *
	 * @param entityItemRelation ���յ��ϵɾ������
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
	 * �������صȼ����ϻ�ȡȡ��
	 * @return gradeList �������صȼ����ϻ�ȡ
	 */
	public List<SOC0151Info> getGradeList() {
		return gradeList;
	}

	/**
	 * �������صȼ����ϻ�ȡ�趨
	 * @param gradeList �������صȼ����ϻ�ȡ
	 */
	public void setGradeList(List<SOC0151Info> gradeList) {
		this.gradeList = gradeList;
	}

	/**
	 * ���ռ��𼯺ϻ�ȡȡ��
	 * @return levelList ���ռ��𼯺ϻ�ȡ
	 */
	public List<SOC0151Info> getLevelList() {
		return levelList;
	}

	/**
	 * ��ʶ�ܿ�����ȡ��
	 * @return identyFlag ��ʶ�ܿ�����
	 */
	public String getIdentyFlag() {
		return identyFlag;
	}

	/**
	 * ��ʶ�ܿ������趨
	 * @param identyFlag ��ʶ�ܿ�����
	 */
	public void setIdentyFlag(String identyFlag) {
		this.identyFlag = identyFlag;
	}

	/**
	 * ���ռ��𼯺ϻ�ȡ�趨
	 * @param levelList ���ռ��𼯺ϻ�ȡ
	 */
	public void setLevelList(List<SOC0151Info> levelList) {
		this.levelList = levelList;
	}

	/**
	 * ���յ������ȡ��
	 * @return possibleList ���յ������
	 */
	public List<SOC0151Info> getPossibleList() {
		return possibleList;
	}

	/**
	 * ���յ�������趨
	 * @param possibleList ���յ������
	 */
	public void setPossibleList(List<SOC0151Info> possibleList) {
		this.possibleList = possibleList;
	}

	/**
	 * ���ձ�ʶ����ȡ��
	 * @return signList ���ձ�ʶ����
	 */
	public List<SOC0151Info> getSignList() {
		return signList;
	}

	/**
	 * ���ձ�ʶ�����趨
	 * @param signList ���ձ�ʶ����
	 */
	public void setSignList(List<SOC0151Info> signList) {
		this.signList = signList;
	}

	/**
	 * ���յ��ѯ����ȡ��
	 * @return riskList ���յ��ѯ����
	 */
	public List<RiskPointVMInfo> getRiskList() {
		return riskList;
	}

	/**
	 * ���յ��ѯ�����趨
	 * @param riskList ���յ��ѯ����
	 */
	public void setRiskList(List<RiskPointVMInfo> riskList) {
		this.riskList = riskList;
	}

	/**
	 * ���յ�����ȡ��
	 * @return eiid ���յ�����
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * ���յ������趨
	 * @param eiid ���յ�����
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * ���յ��ѯȡ��
	 * @return igasm2713Form ���յ��ѯ
	 */
	public IGASM2713Form getIgasm2713Form() {
		return igasm2713Form;
	}

	/**
	 * ���յ��ѯ�趨
	 * @param igasm2713Form ���յ��ѯ
	 */
	public void setIgasm2713Form(IGASM2713Form igasm2713Form) {
		this.igasm2713Form = igasm2713Form;
	}

}


