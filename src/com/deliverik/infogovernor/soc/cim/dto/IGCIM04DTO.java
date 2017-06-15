package com.deliverik.infogovernor.soc.cim.dto;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.asset.model.IG545Bean;
import com.deliverik.framework.asset.model.IG545Info;
import com.deliverik.framework.asset.model.IG612Info;
import com.deliverik.framework.asset.model.condition.IG545SearchCond;
import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.soc.asset.model.SOC0109Info;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.framework.soc.asset.model.SOC0151Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0109SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0117SearchCond;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.asset.form.IGASM0114Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0401Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0402Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0404Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0408Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0409Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0410Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0411Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1202Form;

/**
 * �ʲ�����ģ�͹���ҵ����DTO
 * 
 */
@SuppressWarnings("serial")
public class IGCIM04DTO extends BaseDTO implements Serializable{

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
	protected IGCIM0404Form igcim0404Form;

	/** ������ʲ�������Ϣ */
	protected IGCIM0402Form igcim0402Form;
	
	protected IGCIM0410Form igcim0410Form;
	
	protected IGCIM0411Form igcim0411Form;
	
	protected IGCIM0409Form igcim0409Form;

	protected String flag;
	
	/** ��ѯ���ʲ�������Ϣ */
	protected IGCIM0401Form igcim0401Form;
	
	protected IGCIM1202Form igcim1202Form;
	
	/** �ʲ�ģ��״̬ 1���� 0ͣ�� */
	protected String estatus;

	/** �ʲ��������ݱ�ʶ�б� */
	protected List<IG545Bean> configurationCodeDetailBeanList;
	
	protected List<IG545Info> ConfigurationCodeDetailList;
	
	protected String esyscoding;
	
	/** �ʲ�����Ĭ��ֵ�༭Form */
	protected IGASM0114Form igASM0114Form;
	
	/** �ʲ�������Ϣ��������� */
	protected List<Map<String,List<SOC0109Info>>> configurationMapList;
	
	/** �ʲ�����Ĭ��ֵ���� */
	protected Map<String,List<IG612Info>> map_IG612Info;
	
	/** �ʲ�������ʶ���� */
	protected List<CodeDetail> types1;
	
	/** �ʲ�С����ʶ���� */
	protected List<CodeDetail> types2;
	
	protected String stopFlag;
	
	protected String startFlag;
	
	public String getStopFlag() {
		return stopFlag;
	}

	public void setStopFlag(String stopFlag) {
		this.stopFlag = stopFlag;
	}

	public String getStartFlag() {
		return startFlag;
	}

	public void setStartFlag(String startFlag) {
		this.startFlag = startFlag;
	}


	/**������Ϣ��*/
	protected Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
	
	
	public Map<String, TreeNode> getTreeNodeMap() {
		return treeNodeMap;
	}

	public void setTreeNodeMap(Map<String, TreeNode> treeNodeMap) {
		this.treeNodeMap = treeNodeMap;
	}

	public List<CodeDetail> getTypes1() {
		return types1;
	}

	public void setTypes1(List<CodeDetail> types1) {
		this.types1 = types1;
	}

	public List<CodeDetail> getTypes2() {
		return types2;
	}

	public void setTypes2(List<CodeDetail> types2) {
		this.types2 = types2;
	}

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

	public List<IG545Info> getConfigurationCodeDetailList() {
		return ConfigurationCodeDetailList;
	}

	public IGCIM0409Form getIgcim0409Form() {
		return igcim0409Form;
	}

	public void setIgcim0409Form(IGCIM0409Form igcim0409Form) {
		this.igcim0409Form = igcim0409Form;
	}

	public String getFlag() {
		return flag;
	}

	
	public IGCIM0411Form getIgcim0411Form() {
		return igcim0411Form;
	}

	public void setIgcim0411Form(IGCIM0411Form igcim0411Form) {
		this.igcim0411Form = igcim0411Form;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public void setConfigurationCodeDetailList(
			List<IG545Info> configurationCodeDetailList) {
		ConfigurationCodeDetailList = configurationCodeDetailList;
	}

	
	public IGCIM0410Form getIgcim0410Form() {
		return igcim0410Form;
	}

	public void setIgcim0410Form(IGCIM0410Form igcim0410Form) {
		this.igcim0410Form = igcim0410Form;
	}


	/** �ʲ��������ݻ�����Ϣ */
	protected IGCIM0408Form igcim0408Form;
	
	/** �ʲ�����������Ϣ */
	protected IG545Info configurationcodedetail;
	
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
	
	/** �ʲ�ģ��id */
	protected String eid;
	
	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public IG545SearchCond getConfigurationcodedetailsearchcond() {
		return configurationcodedetailsearchcond;
	}

	public void setConfigurationcodedetailsearchcond(
			IG545SearchCond configurationcodedetailsearchcond) {
		this.configurationcodedetailsearchcond = configurationcodedetailsearchcond;
	}

	public IG545Info getConfigurationcodedetail() {
		return configurationcodedetail;
	}

	public void setConfigurationcodedetail(
			IG545Info configurationcodedetail) {
		this.configurationcodedetail = configurationcodedetail;
	}

	
	public IGCIM0408Form getIgcim0408Form() {
		return igcim0408Form;
	}

	public void setIgcim0408Form(IGCIM0408Form igcim0408Form) {
		this.igcim0408Form = igcim0408Form;
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
	
	public IGCIM0401Form getIgcim0401Form() {
		return igcim0401Form;
	}

	public void setIgcim0401Form(IGCIM0401Form igcim0401Form) {
		this.igcim0401Form = igcim0401Form;
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
	public IGCIM0404Form getIgcim0404Form() {
		return igcim0404Form;
	}
	
	/**
	 * ������ʲ�������Ϣ�趨
	 * 
	 * @param igasm0104Form ������ʲ�������Ϣ
	 */
	public void setIgcim0404Form(IGCIM0404Form igcim0404Form) {
		this.igcim0404Form = igcim0404Form;
	}
	
	
	/**
	 * ������ʲ�������Ϣȡ��
	 * @return ������ʲ�������Ϣ
	 */
	public IGCIM0402Form getIgcim0402Form() {
		return igcim0402Form;
	}

	/**
	 * ������ʲ�������Ϣ�趨
	 * 
	 * @param igasm0102Form ������ʲ�������Ϣ
	 */
	public void setIgcim0402Form(IGCIM0402Form igcim0402Form) {
		this.igcim0402Form = igcim0402Form;
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
	public List<IG545Bean> getConfigurationCodeDetailBeanList() {
		return configurationCodeDetailBeanList;
	}

	/**
	 * �ʲ��������ݱ�ʶ�б��趨
	 * 
	 * @param configurationCodeDetailBeanList �ʲ��������ݱ�ʶ�б�
	 */
	public void setConfigurationCodeDetailBeanList(
			List<IG545Bean> configurationCodeDetailBeanList) {
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

	public IGCIM1202Form getIgcim1202Form() {
		return igcim1202Form;
	}

	public void setIgcim1202Form(IGCIM1202Form igcim1202Form) {
		this.igcim1202Form = igcim1202Form;
	}
	
}


