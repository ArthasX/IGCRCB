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
import com.deliverik.infogovernor.asset.form.IGASM1802Form;
import com.deliverik.infogovernor.asset.form.IGASM1804Form;
import com.deliverik.infogovernor.asset.form.IGASM1805Form;
import com.deliverik.infogovernor.asset.form.IGASM1806Form;
import com.deliverik.infogovernor.asset.form.IGASM1807Form;
import com.deliverik.infogovernor.asset.form.IGASM1812Form;

/**
 * ϵͳ���ù���ҵ����DTO
 * 
 */
@SuppressWarnings("serial")
public class IGASM18DTO extends BaseDTO implements Serializable{

	/** ϵͳ��Ϣ */
	protected IGASM1802Form igasm1802Form;
	
	/** ϵͳ��Ϣ�������� */
	protected SOC0124SearchCond entityItemVWSearchCond;
	
	/** ���������� */
	protected int maxSearchCount;

	/** ��ҳ��DTO */
	protected PagingDTO pagingDto;

	/** ϵͳ������� */
	protected List<SOC0124Info> entityItemVWInfoList;

	/** ϵͳɾ������ */
	protected String[] deleteEntityItem;

	/** ϵͳ������Ϣ */
	protected IGASM1804Form igasm1804Form;
	
	/** ϵͳ������Ϣ������� */
	protected List<SOC0129Info> configItemVWInfoList;

	/** ϵͳ������Ϣ����ϵͳ��Ϣ */
	protected SOC0124Info entityItemVWInfo;

	/** ϵͳ������Ϣ��ʷ��¼�������� */
	protected IGASM1805Form igasm1805Form;
	
	/** ϵͳ������Ϣ��ʷ��¼������� */
	protected List<SOC0107Info> configItemList;
	
	/** ϵͳ��ϵ����������� */
	protected IGASM1806Form igasm1806Form;
	
	/** �ʲ����ϵ������Ϣ�������1 */
	protected List<SOC0119Info> parEntityItemRelationList;
	
	/** �ʲ����ϵ������Ϣ�������2 */
	protected List<SOC0119Info> cldEntityItemRelationList;
	
	/** ϵͳ��ϵ�༭��Ϣ */
	protected IGASM1807Form igasm1807Form;
	
	/** ϵͳ��ϵ�༭����Ϣ */
	protected SOC0119Info entityItemRelation;

	/** ϵͳ��ϵɾ������ */
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
	/** ϵͳ������������ */
	protected String eiorgname;
	protected IGASM1812Form igasm1812Form;
	
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
	
	
	public IGASM1812Form getIgasm1812Form() {
		return igasm1812Form;
	}

	public void setIgasm1812Form(IGASM1812Form igasm1812Form) {
		this.igasm1812Form = igasm1812Form;
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
	 * ϵͳ��Ϣȡ��
	 * @return ϵͳ��Ϣ
	 */
	public IGASM1802Form getIgasm1802Form() {
		return igasm1802Form;
	}

	/**
	 * ϵͳ��Ϣ�趨
	 *
	 * @param igasm1802Form ϵͳ��Ϣ
	 */
	public void setIgasm1802Form(IGASM1802Form igasm1802Form) {
		this.igasm1802Form = igasm1802Form;
	}

	/**
	 * ϵͳ��Ϣ��������ȡ��
	 * @return ϵͳ��Ϣ��������
	 */
	public SOC0124SearchCond getEntityItemVWSearchCond() {
		return entityItemVWSearchCond;
	}

	/**
	 * ϵͳ��Ϣ���������趨
	 *
	 * @param entityItemVWSearchCond ϵͳ��Ϣ��������
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
	 * ϵͳ�������ȡ��
	 * @return ϵͳ�������
	 */
	public List<SOC0124Info> getEntityItemVWInfoList() {
		return entityItemVWInfoList;
	}

	/**
	 * ϵͳ��������趨
	 *
	 * @param entityItemVWInfoList ϵͳ�������
	 */
	public void setEntityItemVWInfoList(List<SOC0124Info> entityItemVWInfoList) {
		this.entityItemVWInfoList = entityItemVWInfoList;
	}

	/**
	 * ϵͳɾ������ȡ��
	 * @return ϵͳɾ������
	 */
	public String[] getDeleteEntityItem() {
		return deleteEntityItem;
	}

	/**
	 * ϵͳɾ�������趨
	 *
	 * @param deleteEntityItem ϵͳɾ������
	 */
	public void setDeleteEntityItem(String[] deleteEntityItem) {
		this.deleteEntityItem = deleteEntityItem;
	}

	/**
	 * ϵͳ������Ϣȡ��
	 * @return ϵͳ������Ϣ
	 */
	public IGASM1804Form getIgasm1804Form() {
		return igasm1804Form;
	}


	/**
	 * ϵͳ������Ϣ���������趨
	 *
	 * @param igasm1804Form ϵͳ������Ϣ��������
	 */
	public void setIgasm1804Form(IGASM1804Form igasm1804Form) {
		this.igasm1804Form = igasm1804Form;
	}

	/**
	 * ϵͳ������Ϣ�������ȡ��
	 * @return ϵͳ������Ϣ�������
	 */
	public List<SOC0129Info> getConfigItemVWInfoList() {
		return configItemVWInfoList;
	}

	/**
	 * ϵͳ������Ϣ��������趨
	 *
	 * @param configItemVWInfoList ϵͳ������Ϣ�������
	 */
	public void setConfigItemVWInfoList(List<SOC0129Info> configItemVWInfoList) {
		this.configItemVWInfoList = configItemVWInfoList;
	}

	/**
	 * ϵͳ������Ϣ����ϵͳ��Ϣȡ��
	 * @return ϵͳ������Ϣ����ϵͳ��Ϣ
	 */
	public SOC0124Info getEntityItemVWInfo() {
		return entityItemVWInfo;
	}

	/**
	 * ϵͳ������Ϣ����ϵͳ��Ϣ�趨
	 *
	 * @param entityItemVWInfo ϵͳ������Ϣ����ϵͳ��Ϣ
	 */
	public void setEntityItemVWInfo(SOC0124Info entityItemVWInfo) {
		this.entityItemVWInfo = entityItemVWInfo;
	}

	/**
	 * ϵͳ������Ϣ��ʷ��¼��������ȡ��
	 * @return ϵͳ������Ϣ��ʷ��¼��������
	 */
	public IGASM1805Form getIgasm1805Form() {
		return igasm1805Form;
	}

	/**
	 * ϵͳ������Ϣ��ʷ��¼���������趨
	 *
	 * @param igasm1805Form ϵͳ������Ϣ��ʷ��¼��������
	 */
	public void setIgasm1805Form(IGASM1805Form igasm1805Form) {
		this.igasm1805Form = igasm1805Form;
	}

	/**
	 * ϵͳ������Ϣ��ʷ��¼�������ȡ��
	 * @return ϵͳ������Ϣ��ʷ��¼�������
	 */
	public List<SOC0107Info> getConfigItemList() {
		return configItemList;
	}

	/**
	 * ϵͳ������Ϣ��ʷ��¼��������趨
	 *
	 * @param configItemList ϵͳ������Ϣ��ʷ��¼�������
	 */
	public void setConfigItemList(List<SOC0107Info> configItemList) {
		this.configItemList = configItemList;
	}

	/**
	 * ϵͳ��ϵ�����������ȡ��
	 * @return ϵͳ��ϵ�����������
	 */
	public IGASM1806Form getIgasm1806Form() {
		return igasm1806Form;
	}

	/**
	 * ϵͳ��ϵ������������趨
	 *
	 * @param igasm1806Form ϵͳ��ϵ�����������
	 */
	public void setIgasm1806Form(IGASM1806Form igasm1806Form) {
		this.igasm1806Form = igasm1806Form;
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
	 * ϵͳ��ϵ�༭��Ϣȡ��
	 * @return �༭��Ϣ
	 */
	public IGASM1807Form getIgasm1807Form() {
		return igasm1807Form;
	}

	/**
	 * ϵͳ��ϵ�༭��Ϣ�趨
	 *
	 * @param igasm1807Form ϵͳ��ϵ�༭��Ϣ
	 */
	public void setIgasm1807Form(IGASM1807Form igasm1807Form) {
		this.igasm1807Form = igasm1807Form;
	}

	/**
	 * ϵͳ��ϵ�༭����Ϣȡ��
	 * @return ϵͳ��ϵ�༭����Ϣ
	 */
	public SOC0119Info getEntityItemRelation() {
		return entityItemRelation;
	}

	/**
	 * ϵͳ��ϵ�༭����Ϣ�趨
	 *
	 * @param entityItemRelation ϵͳ��ϵ�༭����Ϣ
	 */
	public void setEntityItemRelation(SOC0119Info entityItemRelation) {
		this.entityItemRelation = entityItemRelation;
	}

	/**
	 * ϵͳ��ϵɾ������ȡ��
	 * @return ϵͳ��ϵɾ������
	 */
	public String[] getDeleteEntityItemRelation() {
		return deleteEntityItemRelation;
	}

	/**
	 * ϵͳ��ϵɾ�������趨
	 *
	 * @param entityItemRelation ϵͳ��ϵɾ������
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


