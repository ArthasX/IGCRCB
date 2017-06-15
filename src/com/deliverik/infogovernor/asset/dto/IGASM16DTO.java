package com.deliverik.infogovernor.asset.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.SOC0119Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0128Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.asset.form.IGASM1602Form;
import com.deliverik.infogovernor.asset.form.IGASM1604Form;
import com.deliverik.infogovernor.asset.form.IGASM1605Form;
import com.deliverik.infogovernor.asset.form.IGASM1606Form;
import com.deliverik.infogovernor.asset.form.IGASM1607Form;
import com.deliverik.infogovernor.asset.form.IGASM1612Form;

/**
 * �������ù���ҵ����DTO
 * 
 */
@SuppressWarnings("serial")
public class IGASM16DTO extends BaseDTO implements Serializable{

	/** ������Ϣ */
	protected IGASM1602Form igasm1602Form;
	
	/** ������Ϣ�������� */
	protected SOC0124SearchCond entityItemVWSearchCond;
	
	/** ���������� */
	protected int maxSearchCount;

	/** ��ҳ��DTO */
	protected PagingDTO pagingDto;

	/** ���ݼ������ */
	protected List<SOC0124Info> entityItemVWInfoList;

	/** ����ɾ������ */
	protected String[] deleteEntityItem;

	/** ����������Ϣ */
	protected IGASM1604Form igasm1604Form;
	
	/** ����������Ϣ������� */
	protected List<SOC0129Info> configItemVWInfoList;

	/** ����������Ϣ����������Ϣ */
	protected SOC0124Info entityItemVWInfo;

	/** ����������Ϣ��ʷ��¼�������� */
	protected IGASM1605Form igasm1605Form;
	
	/** ����������Ϣ��ʷ��¼������� */
	protected List<SOC0107Info> configItemList;
	
	/** ���ݹ�ϵ����������� */
	protected IGASM1606Form igasm1606Form;
	
	/** �ʲ����ϵ������Ϣ�������1 */
	protected List<SOC0119Info> parEntityItemRelationList;
	
	/** �ʲ����ϵ������Ϣ�������2 */
	protected List<SOC0119Info> cldEntityItemRelationList;
	
	/** ���ݹ�ϵ�༭��Ϣ */
	protected IGASM1607Form igasm1607Form;
	
	/** ���ݹ�ϵ�༭����Ϣ */
	protected SOC0119Info entityItemRelation;

	/** ���ݹ�ϵɾ������ */
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
	
	/** ���������������� */
	protected String eiorgname;
	/** ������Ϣ�޸� */
	protected IGASM1612Form igasm1612Form;
	
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
	
	public IGASM1612Form getIgasm1612Form() {
		return igasm1612Form;
	}

	public void setIgasm1612Form(IGASM1612Form igasm1612Form) {
		this.igasm1612Form = igasm1612Form;
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
	 * ������Ϣȡ��
	 * @return ������Ϣ
	 */
	public IGASM1602Form getIgasm1602Form() {
		return igasm1602Form;
	}

	/**
	 * ������Ϣ�趨
	 *
	 * @param igasm1602Form ������Ϣ
	 */
	public void setIgasm1602Form(IGASM1602Form igasm1602Form) {
		this.igasm1602Form = igasm1602Form;
	}

	/**
	 * ������Ϣ��������ȡ��
	 * @return ������Ϣ��������
	 */
	public SOC0124SearchCond getEntityItemVWSearchCond() {
		return entityItemVWSearchCond;
	}

	/**
	 * ������Ϣ���������趨
	 *
	 * @param entityItemVWSearchCond ������Ϣ��������
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
	 * ���ݼ������ȡ��
	 * @return ���ݼ������
	 */
	public List<SOC0124Info> getEntityItemVWInfoList() {
		return entityItemVWInfoList;
	}

	/**
	 * ���ݼ�������趨
	 *
	 * @param entityItemVWInfoList ���ݼ������
	 */
	public void setEntityItemVWInfoList(List<SOC0124Info> entityItemVWInfoList) {
		this.entityItemVWInfoList = entityItemVWInfoList;
	}

	/**
	 * ����ɾ������ȡ��
	 * @return ����ɾ������
	 */
	public String[] getDeleteEntityItem() {
		return deleteEntityItem;
	}

	/**
	 * ����ɾ�������趨
	 *
	 * @param deleteEntityItem ����ɾ������
	 */
	public void setDeleteEntityItem(String[] deleteEntityItem) {
		this.deleteEntityItem = deleteEntityItem;
	}

	/**
	 * ����������Ϣȡ��
	 * @return ����������Ϣ
	 */
	public IGASM1604Form getIgasm1604Form() {
		return igasm1604Form;
	}


	/**
	 * ����������Ϣ���������趨
	 *
	 * @param igasm1604Form ����������Ϣ��������
	 */
	public void setIgasm1604Form(IGASM1604Form igasm1604Form) {
		this.igasm1604Form = igasm1604Form;
	}

	/**
	 * ����������Ϣ�������ȡ��
	 * @return ����������Ϣ�������
	 */
	public List<SOC0129Info> getConfigItemVWInfoList() {
		return configItemVWInfoList;
	}

	/**
	 * ����������Ϣ��������趨
	 *
	 * @param configItemVWInfoList ����������Ϣ�������
	 */
	public void setConfigItemVWInfoList(List<SOC0129Info> configItemVWInfoList) {
		this.configItemVWInfoList = configItemVWInfoList;
	}

	/**
	 * ����������Ϣ����������Ϣȡ��
	 * @return ����������Ϣ����������Ϣ
	 */
	public SOC0124Info getEntityItemVWInfo() {
		return entityItemVWInfo;
	}

	/**
	 * ����������Ϣ����������Ϣ�趨
	 *
	 * @param entityItemVWInfo ����������Ϣ����������Ϣ
	 */
	public void setEntityItemVWInfo(SOC0124Info entityItemVWInfo) {
		this.entityItemVWInfo = entityItemVWInfo;
	}

	/**
	 * ����������Ϣ��ʷ��¼��������ȡ��
	 * @return ����������Ϣ��ʷ��¼��������
	 */
	public IGASM1605Form getIgasm1605Form() {
		return igasm1605Form;
	}

	/**
	 * ����������Ϣ��ʷ��¼���������趨
	 *
	 * @param igasm1605Form ����������Ϣ��ʷ��¼��������
	 */
	public void setIgasm1605Form(IGASM1605Form igasm1605Form) {
		this.igasm1605Form = igasm1605Form;
	}

	/**
	 * ����������Ϣ��ʷ��¼�������ȡ��
	 * @return ����������Ϣ��ʷ��¼�������
	 */
	public List<SOC0107Info> getConfigItemList() {
		return configItemList;
	}

	/**
	 * ����������Ϣ��ʷ��¼��������趨
	 *
	 * @param configItemList ����������Ϣ��ʷ��¼�������
	 */
	public void setConfigItemList(List<SOC0107Info> configItemList) {
		this.configItemList = configItemList;
	}

	/**
	 * ���ݹ�ϵ�����������ȡ��
	 * @return ���ݹ�ϵ�����������
	 */
	public IGASM1606Form getIgasm1606Form() {
		return igasm1606Form;
	}

	/**
	 * ���ݹ�ϵ������������趨
	 *
	 * @param igasm1606Form ���ݹ�ϵ�����������
	 */
	public void setIgasm1606Form(IGASM1606Form igasm1606Form) {
		this.igasm1606Form = igasm1606Form;
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
	 * ���ݹ�ϵ�༭��Ϣȡ��
	 * @return �༭��Ϣ
	 */
	public IGASM1607Form getIgasm1607Form() {
		return igasm1607Form;
	}

	/**
	 * ���ݹ�ϵ�༭��Ϣ�趨
	 *
	 * @param igasm1607Form ���ݹ�ϵ�༭��Ϣ
	 */
	public void setIgasm1607Form(IGASM1607Form igasm1607Form) {
		this.igasm1607Form = igasm1607Form;
	}

	/**
	 * ���ݹ�ϵ�༭����Ϣȡ��
	 * @return ���ݹ�ϵ�༭����Ϣ
	 */
	public SOC0119Info getEntityItemRelation() {
		return entityItemRelation;
	}

	/**
	 * ���ݹ�ϵ�༭����Ϣ�趨
	 *
	 * @param entityItemRelation ���ݹ�ϵ�༭����Ϣ
	 */
	public void setEntityItemRelation(SOC0119Info entityItemRelation) {
		this.entityItemRelation = entityItemRelation;
	}

	/**
	 * ���ݹ�ϵɾ������ȡ��
	 * @return ���ݹ�ϵɾ������
	 */
	public String[] getDeleteEntityItemRelation() {
		return deleteEntityItemRelation;
	}

	/**
	 * ���ݹ�ϵɾ�������趨
	 *
	 * @param entityItemRelation ���ݹ�ϵɾ������
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

}


