package com.deliverik.infogovernor.asset.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.asset.model.IG612Info;
import com.deliverik.framework.asset.model.condition.IG545SearchCond;
import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.model.ConfigurationCodeDetailBean;
import com.deliverik.framework.soc.asset.model.SOC0109Info;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.framework.soc.asset.model.SOC0151Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0109SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0117SearchCond;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.asset.form.IGASM0101Form;
import com.deliverik.infogovernor.asset.form.IGASM0102Form;
import com.deliverik.infogovernor.asset.form.IGASM0104Form;
import com.deliverik.infogovernor.asset.form.IGASM0108Form;
import com.deliverik.infogovernor.asset.form.IGASM0109Form;
import com.deliverik.infogovernor.asset.form.IGASM0110Form;
import com.deliverik.infogovernor.asset.form.IGASM0111Form;
import com.deliverik.infogovernor.asset.form.IGASM0114Form;

/**
 * �ʲ�����ģ�͹���ҵ����DTO
 * 
 */
@SuppressWarnings("serial")
public class IGASM01DTO extends BaseDTO implements Serializable{

	/** �ʲ���Ϣ�������� */
	protected SOC0117SearchCond entitySearchCond;
	
	/** ȡֵ��Χ��Ϣ��������� */
	protected List<SOC0151Info> ccdList;
	
	/** ������Ϣ��������� */
	protected List<Organization> orglist;
	
	/** �û���Ϣ��������� */
	protected List<User> userlist;

	/** �ʲ�һ��ģ����Ϣ��������� */
	protected List<SOC0117Info> topEntityList;
	
	/** �ʲ���Ϣ��������� */
	protected List<SOC0117Info> entityList;

	/** �ʲ���Ϣ���������� */
	protected int maxSearchCount;

	/** ��ҳ��DTO */
	protected PagingDTO pagingDto;

	/** �Ǽ��ʲ���Ϣ */
	protected SOC0117Info entity;

	/** �Ǽ��ʲ�������Ϣ */
	protected SOC0109Info configuration;

	/** �ʲ�������Ϣ�������� */
	protected SOC0109SearchCond configurationSearchCond;
	
	/** �ʲ�������Ϣ��������� */
	protected List<SOC0109Info> configurationList;
	
	/** �ʲ�������Ϣ��������� */
	Map<String,List<SOC0109Info>> configurationMap;
	
	/** �ʲ���Ϣɾ������ */
	protected String[] deleteEntity;

	/** �ʲ�������Ϣɾ������ */
	protected String[] deleteConfiguration;
	
	/** ������ʲ�������Ϣ */
	protected IGASM0104Form igasm0104Form;

	/** ������ʲ�������Ϣ */
	protected IGASM0102Form igasm0102Form;
	
	protected IGASM0110Form igasm0110Form;
	
	protected IGASM0111Form igasm0111Form;
	
	protected IGASM0109Form igasm0109Form;

	protected String flag;
	
	/** ��ѯ���ʲ�������Ϣ */
	protected IGASM0101Form igasm0101Form;
	
	/** �ʲ�ģ��״̬ 1���� 0ͣ�� */
	protected String estatus;

	/** �ʲ��������ݱ�ʶ�б� */
	protected List<ConfigurationCodeDetailBean> configurationCodeDetailBeanList;
	
	protected List<SOC0151Info> ConfigurationCodeDetailList;
	
	protected String esyscoding;
	
	/** �ʲ�����Ĭ��ֵ�༭Form */
	protected IGASM0114Form igASM0114Form;
	
	/** �ʲ�������Ϣ��������� */
	protected List<Map<String,List<SOC0109Info>>> configurationMapList;
	
	/** �ʲ�����Ĭ��ֵ���� */
	protected Map<String,List<IG612Info>> map_IG612Info;
	
	public List<Map<String, List<SOC0109Info>>> getConfigurationMapList() {
		return configurationMapList;
	}

	public void setConfigurationMapList(
			List<Map<String, List<SOC0109Info>>> configurationMapList) {
		this.configurationMapList = configurationMapList;
	}

	public List<User> getUserlist() {
		return userlist;
	}

	public void setUserlist(List<User> userlist) {
		this.userlist = userlist;
	}

	/**
	 * @return the ccdList
	 */
	public List<SOC0151Info> getCcdList() {
		return ccdList;
	}

	/**
	 * @param ccdList the ccdList to set
	 */
	public void setCcdList(List<SOC0151Info> ccdList) {
		this.ccdList = ccdList;
	}

	/**
	 * @return the orglist
	 */
	public List<Organization> getOrglist() {
		return orglist;
	}

	/**
	 * @param orglist the orglist to set
	 */
	public void setOrglist(List<Organization> orglist) {
		this.orglist = orglist;
	}

	/**
	 * @return the topEntityList
	 */
	public List<SOC0117Info> getTopEntityList() {
		return topEntityList;
	}

	/**
	 * @param topEntityList the topEntityList to set
	 */
	public void setTopEntityList(List<SOC0117Info> topEntityList) {
		this.topEntityList = topEntityList;
	}

	public String getEsyscoding() {
		return esyscoding;
	}

	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	public List<SOC0151Info> getConfigurationCodeDetailList() {
		return ConfigurationCodeDetailList;
	}

	public IGASM0109Form getIgasm0109Form() {
		return igasm0109Form;
	}

	public void setIgasm0109Form(IGASM0109Form igasm0109Form) {
		this.igasm0109Form = igasm0109Form;
	}

	public String getFlag() {
		return flag;
	}

	public IGASM0111Form getIgasm0111Form() {
		return igasm0111Form;
	}

	public void setIgasm0111Form(IGASM0111Form igasm0111Form) {
		this.igasm0111Form = igasm0111Form;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public void setConfigurationCodeDetailList(
			List<SOC0151Info> configurationCodeDetailList) {
		ConfigurationCodeDetailList = configurationCodeDetailList;
	}

	public IGASM0110Form getIgasm0110Form() {
		return igasm0110Form;
	}

	public void setIgasm0110Form(IGASM0110Form igasm0110Form) {
		this.igasm0110Form = igasm0110Form;
	}

	/** �ʲ��������ݻ�����Ϣ */
	protected IGASM0108Form igasm0108Form;
	
	/** �ʲ�����������Ϣ */
	protected SOC0151Info configurationcodedetail;
	
	/** �ʲ�����������Ϣ */
	protected IG545SearchCond configurationcodedetailsearchcond;
	/**
	 * ÿ��ģ���Ƿ���ʾͣ�ð�ť
	 */
	
	protected  Map<String,String> stopbuttonMap;
	
	/**
	 * ÿ��ģ���Ƿ���ʾ���ð�ť
	 */
	
	protected  Map<String,String> startbuttonMap;
	
	/** �ʲ�ģ������״̬ 1���� 2ͣ�� */
	protected String cstatus;
	
	/** �ʲ�ģ������id */
	protected String cid;
	
	public IG545SearchCond getConfigurationcodedetailsearchcond() {
		return configurationcodedetailsearchcond;
	}

	public void setConfigurationcodedetailsearchcond(
			IG545SearchCond configurationcodedetailsearchcond) {
		this.configurationcodedetailsearchcond = configurationcodedetailsearchcond;
	}

	public SOC0151Info getConfigurationcodedetail() {
		return configurationcodedetail;
	}

	public void setConfigurationcodedetail(
			SOC0151Info configurationcodedetail) {
		this.configurationcodedetail = configurationcodedetail;
	}

	public IGASM0108Form getIgasm0108Form() {
		return igasm0108Form;
	}

	public void setIgasm0108Form(IGASM0108Form igasm0108Form) {
		this.igasm0108Form = igasm0108Form;
	}

	public String getCstatus() {
		return cstatus;
	}

	public void setCstatus(String cstatus) {
		this.cstatus = cstatus;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public Map<String, String> getStopbuttonMap() {
		return stopbuttonMap;
	}

	public void setStopbuttonMap(Map<String, String> stopbuttonMap) {
		this.stopbuttonMap = stopbuttonMap;
	}

	public Map<String, String> getStartbuttonMap() {
		return startbuttonMap;
	}

	public void setStartbuttonMap(Map<String, String> startbuttonMap) {
		this.startbuttonMap = startbuttonMap;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public IGASM0101Form getIgasm0101Form() {
		return igasm0101Form;
	}

	public void setIgasm0101Form(IGASM0101Form igasm0101Form) {
		this.igasm0101Form = igasm0101Form;
	}

	/**
	 * �ʲ���Ϣ��������ȡ��
	 * @return �ʲ���Ϣ��������
	 */
	public SOC0117SearchCond getEntitySearchCond() {
	    return this.entitySearchCond;
	}

	/**
	 * �ʲ���Ϣ���������趨
	 *
	 * @param entitySearchCond �ʲ���Ϣ��������
	 */
	public void setEntitySearchCond(SOC0117SearchCond entitySearchCond) {
	    this.entitySearchCond = entitySearchCond;
	}

	/**
	 * �ʲ���Ϣ���������ȡ��
	 * @return �ʲ���Ϣ���������
	 */
	public List<SOC0117Info> getEntityList() {
		return entityList;
	}

	/**
	 * �ʲ���Ϣ����������趨
	 *
	 * @param entityList �ʲ���Ϣ���������
	 */
	public void setEntityList(List<SOC0117Info> entityList) {
		this.entityList = entityList;
	}

	/**
	 * �ʲ���Ϣ����������ȡ��
	 * @return �ʲ���Ϣ����������
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * �ʲ���Ϣ�����������趨
	 * 
	 * @param maxSearchCount �ʲ���Ϣ����������
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
	 * �Ǽ��ʲ���Ϣȡ��
	 * @return �Ǽ��ʲ���Ϣ
	 */
	public SOC0117Info getEntity() {
		return entity;
	}

	/**
	 * �Ǽ��ʲ���Ϣ�趨
	 * 
	 * @param entity �Ǽ��ʲ���Ϣ
	 */
	public void setEntity(SOC0117Info entity) {
		this.entity = entity;
	}

	/**
	 * �Ǽ��ʲ�������Ϣȡ��
	 * @return �Ǽ��ʲ�������Ϣ
	 */
	public SOC0109Info getConfiguration() {
		return configuration;
	}

	/**
	 * �Ǽ��ʲ�������Ϣ�趨
	 * 
	 * @param configuration �Ǽ��ʲ�������Ϣ
	 */
	public void setConfiguration(SOC0109Info configuration) {
		this.configuration = configuration;
	}

	/**
	 * �ʲ�������Ϣ��������ȡ��
	 * @return �ʲ�������Ϣ��������
	 */
	public SOC0109SearchCond getConfigurationSearchCond() {
		return configurationSearchCond;
	}

	/**
	 * �ʲ�������Ϣ���������趨
	 * 
	 * @param configurationSearchCond �ʲ�������Ϣ��������
	 */
	public void setConfigurationSearchCond(
			SOC0109SearchCond configurationSearchCond) {
		this.configurationSearchCond = configurationSearchCond;
	}

	/**
	 * �ʲ�������Ϣ���������ȡ��
	 * @return �ʲ�������Ϣ���������
	 */
	public List<SOC0109Info> getConfigurationList() {
		return configurationList;
	}

	/**
	 * �ʲ�������Ϣ����������趨
	 * 
	 * @param configurationList �ʲ�������Ϣ���������
	 */
	public void setConfigurationList(List<SOC0109Info> configurationList) {
		this.configurationList = configurationList;
	}

	/**
	 * �ʲ���Ϣɾ������ȡ��
	 * @return �ʲ���Ϣɾ������
	 */
	public String[] getDeleteEntity() {
		return deleteEntity;
	}

	/**
	 * �ʲ���Ϣɾ�������趨
	 * 
	 * @param deleteEntity �ʲ���Ϣɾ������
	 */
	public void setDeleteEntity(String[] deleteEntity) {
		this.deleteEntity = deleteEntity;
	}

	/**
	 * �ʲ�������Ϣɾ������ȡ��
	 * @return �ʲ�������Ϣɾ������
	 */
	public String[] getDeleteConfiguration() {
		return deleteConfiguration;
	}

	/**
	 * �ʲ�������Ϣɾ�������趨
	 * 
	 * @param deleteConfiguration �ʲ�������Ϣɾ������
	 */
	public void setDeleteConfiguration(String[] deleteConfiguration) {
		this.deleteConfiguration = deleteConfiguration;
	}

	/**
	 * ������ʲ�������Ϣȡ��
	 * @return ������ʲ�������Ϣ
	 */
	public IGASM0104Form getIgasm0104Form() {
		return igasm0104Form;
	}

	/**
	 * ������ʲ�������Ϣ�趨
	 * 
	 * @param igasm0104Form ������ʲ�������Ϣ
	 */
	public void setIgasm0104Form(IGASM0104Form igasm0104Form) {
		this.igasm0104Form = igasm0104Form;
	}
	
	/**
	 * ������ʲ�������Ϣȡ��
	 * @return ������ʲ�������Ϣ
	 */
	public IGASM0102Form getIgasm0102Form() {
		return igasm0102Form;
	}

	/**
	 * ������ʲ�������Ϣ�趨
	 * 
	 * @param igasm0102Form ������ʲ�������Ϣ
	 */
	public void setIgasm0102Form(IGASM0102Form igasm0102Form) {
		this.igasm0102Form = igasm0102Form;
	}

	/**
	 * �ʲ�������Ϣ���������ȡ��
	 * @return �ʲ�������Ϣ���������
	 */
	public Map<String, List<SOC0109Info>> getConfigurationMap() {
		return configurationMap;
	}

	/**
	 * �ʲ�������Ϣ����������趨
	 * 
	 * @param configurationMap �ʲ�������Ϣ���������
	 */
	public void setConfigurationMap(
			Map<String, List<SOC0109Info>> configurationMap) {
		this.configurationMap = configurationMap;
	}

	/**
	 * �ʲ��������ݱ�ʶ�б�ȡ��
	 * @return �ʲ��������ݱ�ʶ�б�����
	 */
	public List<ConfigurationCodeDetailBean> getConfigurationCodeDetailBeanList() {
		return configurationCodeDetailBeanList;
	}

	/**
	 * �ʲ��������ݱ�ʶ�б��趨
	 * 
	 * @param configurationCodeDetailBeanList �ʲ��������ݱ�ʶ�б�
	 */
	public void setConfigurationCodeDetailBeanList(
			List<ConfigurationCodeDetailBean> configurationCodeDetailBeanList) {
		this.configurationCodeDetailBeanList = configurationCodeDetailBeanList;
	}

	/**
	 * �ʲ�����Ĭ��ֵ�༭Formȡ��
	 * 
	 * @return �ʲ�����Ĭ��ֵ�༭Form
	 */
	public IGASM0114Form getIgASM0114Form() {
		return igASM0114Form;
	}

	/**
	 * �ʲ�����Ĭ��ֵ�༭Form�趨
	 * 
	 * @param igASM0114Form �ʲ�����Ĭ��ֵ�༭Form
	 */
	public void setIgASM0114Form(IGASM0114Form igASM0114Form) {
		this.igASM0114Form = igASM0114Form;
	}

	/**
	 * �ʲ�����Ĭ��ֵ����ȡ��
	 * 
	 * @return �ʲ�����Ĭ��ֵ����
	 */
	public Map<String, List<IG612Info>> getMap_IG612Info() {
		return map_IG612Info;
	}

	/**
	 * �ʲ�����Ĭ��ֵ�����趨
	 * 
	 * @param map_IG612Info �ʲ�����Ĭ��ֵ����
	 */
	public void setMap_IG612Info(Map<String, List<IG612Info>> map_IG612Info) {
		this.map_IG612Info = map_IG612Info;
	}
	
}


