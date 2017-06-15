package com.deliverik.infogovernor.asset.dto;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.asset.model.EiBelongRelationInfo;
import com.deliverik.framework.asset.model.IG002Info;
import com.deliverik.framework.asset.model.IG013Info;
import com.deliverik.framework.asset.model.IG800Info;
import com.deliverik.framework.asset.model.condition.IG800SearchCond;
import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.SOC0119Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0128Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.asset.form.IGASM0301Form;
import com.deliverik.infogovernor.asset.form.IGASM0302Form;
import com.deliverik.infogovernor.asset.form.IGASM0304Form;
import com.deliverik.infogovernor.asset.form.IGASM0305Form;
import com.deliverik.infogovernor.asset.form.IGASM0306Form;
import com.deliverik.infogovernor.asset.form.IGASM0307Form;
import com.deliverik.infogovernor.asset.form.IGASM0309Form;
import com.deliverik.infogovernor.asset.form.IGASM0311Form;
import com.deliverik.infogovernor.asset.form.IGASM0312Form;
import com.deliverik.infogovernor.asset.form.IGASM0313Form;
import com.deliverik.infogovernor.asset.form.IGASM0314Form;
import com.deliverik.infogovernor.asset.form.IGASM0315Form;
import com.deliverik.infogovernor.asset.form.IGASM0316Form;
import com.deliverik.infogovernor.asset.form.IGASM0317Form;
import com.deliverik.infogovernor.asset.form.IGASM0320Form;
import com.deliverik.infogovernor.asset.form.IGASM0321Form;
import com.deliverik.infogovernor.asset.form.IGASM0341Form;
import com.deliverik.infogovernor.asset.form.IGASM0346Form;

/**
 * �豸���ù���ҵ����DTO
 * 
 */
@SuppressWarnings("serial")
public class IGASM03DTO extends BaseDTO implements Serializable{

	protected IG800SearchCond configItemSearchCond;
	public IG800SearchCond getConfigItemSearchCond() {
		return configItemSearchCond;
	}

	public void setConfigItemSearchCond(IG800SearchCond configItemSearchCond) {
		this.configItemSearchCond = configItemSearchCond;
	}

	/** �豸��Ϣ */
	protected IGASM0302Form igasm0302Form;
	
	/** �豸��Ϣ�������� */
	protected SOC0124SearchCond entityItemVWSearchCond;
	
	/** ���������� */
	protected int maxSearchCount;

	/** ��ҳ��DTO */
	protected PagingDTO pagingDto;

	/** �豸������� */
	protected List<SOC0124Info> entityItemVWInfoList;

	/** �豸ɾ������ */
	protected String[] deleteEntityItem;
	
	/** �豸����������� */
	protected String[] batchEntityItem;

	/** �豸������Ϣ */
	protected IGASM0304Form igasm0304Form;
	/** �豸�����ļ���ʷ�汾�Ƚ���Ϣ */
	protected IGASM0341Form igasm0341Form;
	
	
	/** �豸������Ϣ������� */
	protected List<IG002Info> configItemVWInfoList;

	/** �豸������Ϣ�����豸��Ϣ */
	protected SOC0124Info entityItemVWInfo;

	/** �豸������Ϣ��ʷ��¼�������� */
	protected IGASM0305Form igasm0305Form;
	
	/** �豸������Ϣ��ʷ��¼������� */
	protected List<IG800Info> configItemList;
	
	/** �豸��ϵ����������� */
	protected IGASM0306Form igasm0306Form;
	
	protected IGASM0309Form igasm0309Form;
	
	protected IGASM0311Form igasm0311Form;
	
	protected IGASM0312Form igasm0312Form;
	
	protected IGASM0314Form igasm0314Form;
	
	protected IGASM0315Form igasm0315Form;
	
	protected IGASM0316Form igasm0316Form;
	
	protected IGASM0317Form igasm0317Form;
	
	/** �ʲ����ϵ��Ϣ1���� */
	protected int parCount;
	
	/** �ʲ����ϵ��Ϣ2���� */
	protected int cldCount;
	
	/** �ʲ������ϵ�����б� */
	protected List<LabelValueBean> relationList;
	
	/** �ʲ����ϵ������Ϣ�������1 */
	protected List<SOC0119Info> parEntityItemRelationList;
	
	/** �ʲ����ϵ������Ϣ�������1 */
	protected Map<String,List<SOC0119Info>> parEntityItemRelationMap;
	
	/** �ʲ����ϵ������Ϣ�������2 */
	protected List<SOC0119Info> cldEntityItemRelationList;
	
	/** �ʲ����ϵ������Ϣ�������2 */
	protected Map<String,List<SOC0119Info>> cldEntityItemRelationMap;
	
	/** �豸��ϵ�༭��Ϣ */
	protected IGASM0307Form igasm0307Form;
	
	/** �豸��ϵ�༭����Ϣ */
	protected SOC0119Info entityItemRelation;

	/** �豸��ϵɾ������ */
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
	
	/** �豸������������ */
	protected String eiorgname;
	
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
	
	/** ������ϢXML�� */
	protected Map<String,TreeNode> treeNodeMap = new LinkedHashMap<String,TreeNode>();
	
	/** ������ϢXML�������Ϣ */
	protected Map<String,String> infoMap;
	
	protected IGASM0301Form igASM0301Form;
	
	/** ������ϢXML�ļ�·�� */
	protected String filepath;
	
	/** ������ϢXML�ļ�·�� */
	protected String otherfilepath;
	
	protected List<String> section_list;
	
	protected List<String> command_list1;
	
	protected List<String> output_list1;
	
	protected List<String> command_list2;
	
	protected List<String> output_list2;

	protected Map<String,List<TreeNode>> command_map;
	
	protected Map<String,List<TreeNode>> map1;
	
	protected Map<String,List<TreeNode>> map2;
	
	protected List<String> command_color_list;//0����ɫ 1��ɫ
	
	protected List<String> output_color_list;//0����ɫ 1��ɫ
	
	protected String inJiguiFlg;  //�豸�Ƿ����ϼܱ�־λ
	
	
	/** ������ϵ */
	protected List<EiBelongRelationInfo> eiBelongRelationList;
	
	
	/** ���ð�����ϵ��ʾFORM */
	protected IGASM0346Form igasm0346Form;
	
	/** �豸�ʲ���������*/
	protected String area;
	

	public List<EiBelongRelationInfo> getEiBelongRelationList() {
		return eiBelongRelationList;
	}

	public void setEiBelongRelationList(List<EiBelongRelationInfo> eiBelongRelationList) {
		this.eiBelongRelationList = eiBelongRelationList;
	}

	public List<String> getCommand_color_list() {
		return command_color_list;
	}

	public void setCommand_color_list(List<String> command_color_list) {
		this.command_color_list = command_color_list;
	}

	public List<String> getOutput_color_list() {
		return output_color_list;
	}

	public void setOutput_color_list(List<String> output_color_list) {
		this.output_color_list = output_color_list;
	}

	public Map<String, List<TreeNode>> getMap1() {
		return map1;
	}

	public void setMap1(Map<String, List<TreeNode>> map1) {
		this.map1 = map1;
	}

	public Map<String, List<TreeNode>> getMap2() {
		return map2;
	}

	public void setMap2(Map<String, List<TreeNode>> map2) {
		this.map2 = map2;
	}

	public List<String> getCommand_list1() {
		return command_list1;
	}

	public void setCommand_list1(List<String> command_list1) {
		this.command_list1 = command_list1;
	}

	public List<String> getOutput_list1() {
		return output_list1;
	}

	public void setOutput_list1(List<String> output_list1) {
		this.output_list1 = output_list1;
	}

	public List<String> getCommand_list2() {
		return command_list2;
	}

	public void setCommand_list2(List<String> command_list2) {
		this.command_list2 = command_list2;
	}

	public List<String> getOutput_list2() {
		return output_list2;
	}

	public void setOutput_list2(List<String> output_list2) {
		this.output_list2 = output_list2;
	}

	public String getOtherfilepath() {
		return otherfilepath;
	}

	public void setOtherfilepath(String otherfilepath) {
		this.otherfilepath = otherfilepath;
	}

	

	public List<String> getSection_list() {
		return section_list;
	}

	public void setSection_list(List<String> section_list) {
		this.section_list = section_list;
	}

	public Map<String, List<TreeNode>> getCommand_map() {
		return command_map;
	}

	public void setCommand_map(Map<String, List<TreeNode>> command_map) {
		this.command_map = command_map;
	}

	public Map<String, String> getInfoMap() {
		return infoMap;
	}

	public void setInfoMap(Map<String, String> infoMap) {
		this.infoMap = infoMap;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public IGASM0301Form getIgASM0301Form() {
		return igASM0301Form;
	}

	public void setIgASM0301Form(IGASM0301Form igASM0301Form) {
		this.igASM0301Form = igASM0301Form;
	}

	public Map<String, TreeNode> getTreeNodeMap() {
		return treeNodeMap;
	}

	public void setTreeNodeMap(Map<String, TreeNode> treeNodeMap) {
		this.treeNodeMap = treeNodeMap;
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
	
	
	/**
	 * @return the area
	 */
	public String getArea() {
		return area;
	}

	/**
	 * @param area the area to set
	 */
	public void setArea(String area) {
		this.area = area;
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
	
	
	public String getEiorgname() {
		return eiorgname;
	}

	public void setEiorgname(String eiorgname) {
		this.eiorgname = eiorgname;
	}

	public String getReciveUser() {
		return reciveUser;
	}

	public void setReciveUser(String reciveUser) {
		this.reciveUser = reciveUser;
	}
	
	protected IGASM0313Form igasm0313Form;
	
	/** �豸��������id */
	protected String orgid;
	
	/** �豸��������name */
	protected String orgname;
	
	/** �豸�·�ʱ�� */
	protected String issuetime;
	
	/** �豸������ */
	protected String recivename;
	
	/** �豸��ǰ�汾�� */
	protected String eiversion;
	
	public IGASM0317Form getIgasm0317Form() {
		return igasm0317Form;
	}

	public void setIgasm0317Form(IGASM0317Form igasm0317Form) {
		this.igasm0317Form = igasm0317Form;
	}

	public IGASM0316Form getIgasm0316Form() {
		return igasm0316Form;
	}

	public void setIgasm0316Form(IGASM0316Form igasm0316Form) {
		this.igasm0316Form = igasm0316Form;
	}

	public IGASM0312Form getIgasm0312Form() {
		return igasm0312Form;
	}

	public void setIgasm0312Form(IGASM0312Form igasm0312Form) {
		this.igasm0312Form = igasm0312Form;
	}

	public String[] getBatchEntityItem() {
		return batchEntityItem;
	}

	public void setBatchEntityItem(String[] batchEntityItem) {
		this.batchEntityItem = batchEntityItem;
	}

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

	public IGASM0315Form getIgasm0315Form() {
		return igasm0315Form;
	}

	public void setIgasm0315Form(IGASM0315Form igasm0315Form) {
		this.igasm0315Form = igasm0315Form;
	}

	public IGASM0311Form getIgasm0311Form() {
		return igasm0311Form;
	}

	public void setIgasm0311Form(IGASM0311Form igasm0311Form) {
		this.igasm0311Form = igasm0311Form;
	}
	
	/** �޸����豸������Ϣ��ʾ */
	protected IGASM0320Form igasm0320Form;
	
	/** �޸����豸������Ϣ */
	protected IGASM0321Form igasm0321Form;
	
	/** �豸��Ϣ�����豸��Ϣ */
	protected IG013Info entityItem;

	public IGASM0321Form getIgasm0321Form() {
		return igasm0321Form;
	}

	public void setIgasm0321Form(IGASM0321Form igasm0321Form) {
		this.igasm0321Form = igasm0321Form;
	}

	public IG013Info getEntityItem() {
		return entityItem;
	}

	public void setEntityItem(IG013Info entityItem) {
		this.entityItem = entityItem;
	}

	public IGASM0320Form getIgasm0320Form() {
		return igasm0320Form;
	}

	public void setIgasm0320Form(IGASM0320Form igasm0320Form) {
		this.igasm0320Form = igasm0320Form;
	}

	public IGASM0313Form getIgasm0313Form() {
		return igasm0313Form;
	}

	public void setIgasm0313Form(IGASM0313Form igasm0313Form) {
		this.igasm0313Form = igasm0313Form;
	}

	/**
	 * �豸��Ϣȡ��
	 * @return �豸��Ϣ
	 */
	public IGASM0302Form getIgasm0302Form() {
		return igasm0302Form;
	}

	/**
	 * �豸��Ϣ�趨
	 *
	 * @param igasm0302Form �豸��Ϣ
	 */
	public void setIgasm0302Form(IGASM0302Form igasm0302Form) {
		this.igasm0302Form = igasm0302Form;
	}
	
	public IGASM0314Form getIgasm0314Form() {
		return igasm0314Form;
	}

	public void setIgasm0314Form(IGASM0314Form igasm0314Form) {
		this.igasm0314Form = igasm0314Form;
	}

	/**
	 * �豸��Ϣ��������ȡ��
	 * @return �豸��Ϣ��������
	 */
	public SOC0124SearchCond getEntityItemVWSearchCond() {
		return entityItemVWSearchCond;
	}

	/**
	 * �豸��Ϣ���������趨
	 *
	 * @param entityItemVWSearchCond �豸��Ϣ��������
	 */
	public void setEntityItemVWSearchCond(
			SOC0124SearchCond entityItemVWSearchCond) {
		this.entityItemVWSearchCond = entityItemVWSearchCond;
	}

	public IGASM0309Form getIgasm0309Form() {
		return igasm0309Form;
	}

	public void setIgasm0309Form(IGASM0309Form igasm0309Form) {
		this.igasm0309Form = igasm0309Form;
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
	 * �豸�������ȡ��
	 * @return �豸�������
	 */
	public List<SOC0124Info> getEntityItemVWInfoList() {
		return entityItemVWInfoList;
	}

	/**
	 * �豸��������趨
	 *
	 * @param entityItemVWInfoList �豸�������
	 */
	public void setEntityItemVWInfoList(List<SOC0124Info> entityItemVWInfoList) {
		this.entityItemVWInfoList = entityItemVWInfoList;
	}

	/**
	 * �豸ɾ������ȡ��
	 * @return �豸ɾ������
	 */
	public String[] getDeleteEntityItem() {
		return deleteEntityItem;
	}

	/**
	 * �豸ɾ�������趨
	 *
	 * @param deleteEntityItem �豸ɾ������
	 */
	public void setDeleteEntityItem(String[] deleteEntityItem) {
		this.deleteEntityItem = deleteEntityItem;
	}

	/**
	 * �豸������Ϣȡ��
	 * @return �豸������Ϣ
	 */
	public IGASM0304Form getIgasm0304Form() {
		return igasm0304Form;
	}


	/**
	 * �豸������Ϣ���������趨
	 *
	 * @param igasm0304Form �豸������Ϣ��������
	 */
	public void setIgasm0304Form(IGASM0304Form igasm0304Form) {
		this.igasm0304Form = igasm0304Form;
	}

	/**
	 * �豸������Ϣ�������ȡ��
	 * @return �豸������Ϣ�������
	 */
	public List<IG002Info> getConfigItemVWInfoList() {
		return configItemVWInfoList;
	}

	/**
	 * �豸������Ϣ��������趨
	 *
	 * @param configItemVWInfoList �豸������Ϣ�������
	 */
	public void setConfigItemVWInfoList(List<IG002Info> configItemVWInfoList) {
		this.configItemVWInfoList = configItemVWInfoList;
	}

	/**
	 * �豸������Ϣ�����豸��Ϣȡ��
	 * @return �豸������Ϣ�����豸��Ϣ
	 */
	public SOC0124Info getEntityItemVWInfo() {
		return entityItemVWInfo;
	}

	/**
	 * �豸������Ϣ�����豸��Ϣ�趨
	 *
	 * @param entityItemVWInfo �豸������Ϣ�����豸��Ϣ
	 */
	public void setEntityItemVWInfo(SOC0124Info entityItemVWInfo) {
		this.entityItemVWInfo = entityItemVWInfo;
	}

	/**
	 * �豸������Ϣ��ʷ��¼��������ȡ��
	 * @return �豸������Ϣ��ʷ��¼��������
	 */
	public IGASM0305Form getIgasm0305Form() {
		return igasm0305Form;
	}

	/**
	 * �豸������Ϣ��ʷ��¼���������趨
	 *
	 * @param igasm0305Form �豸������Ϣ��ʷ��¼��������
	 */
	public void setIgasm0305Form(IGASM0305Form igasm0305Form) {
		this.igasm0305Form = igasm0305Form;
	}

	/**
	 * �豸������Ϣ��ʷ��¼�������ȡ��
	 * @return �豸������Ϣ��ʷ��¼�������
	 */
	public List<IG800Info> getConfigItemList() {
		return configItemList;
	}

	/**
	 * �豸������Ϣ��ʷ��¼��������趨
	 *
	 * @param configItemList �豸������Ϣ��ʷ��¼�������
	 */
	public void setConfigItemList(List<IG800Info> configItemList) {
		this.configItemList = configItemList;
	}

	/**
	 * �豸��ϵ�����������ȡ��
	 * @return �豸��ϵ�����������
	 */
	public IGASM0306Form getIgasm0306Form() {
		return igasm0306Form;
	}

	/**
	 * �豸��ϵ������������趨
	 *
	 * @param igasm0306Form �豸��ϵ�����������
	 */
	public void setIgasm0306Form(IGASM0306Form igasm0306Form) {
		this.igasm0306Form = igasm0306Form;
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
	 * �豸��ϵ�༭��Ϣȡ��
	 * @return �༭��Ϣ
	 */
	public IGASM0307Form getIgasm0307Form() {
		return igasm0307Form;
	}

	/**
	 * �豸��ϵ�༭��Ϣ�趨
	 *
	 * @param igasm0307Form �豸��ϵ�༭��Ϣ
	 */
	public void setIgasm0307Form(IGASM0307Form igasm0307Form) {
		this.igasm0307Form = igasm0307Form;
	}

	/**
	 * �豸��ϵ�༭����Ϣȡ��
	 * @return �豸��ϵ�༭����Ϣ
	 */
	public SOC0119Info getEntityItemRelation() {
		return entityItemRelation;
	}

	/**
	 * �豸��ϵ�༭����Ϣ�趨
	 *
	 * @param entityItemRelation �豸��ϵ�༭����Ϣ
	 */
	public void setEntityItemRelation(SOC0119Info entityItemRelation) {
		this.entityItemRelation = entityItemRelation;
	}

	/**
	 * �豸��ϵɾ������ȡ��
	 * @return �豸��ϵɾ������
	 */
	public String[] getDeleteEntityItemRelation() {
		return deleteEntityItemRelation;
	}

	/**
	 * �豸��ϵɾ�������趨
	 *
	 * @param entityItemRelation �豸��ϵɾ������
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
	 * �ʲ����ϵ������Ϣ�������1ȡ��
	 * @return �ʲ����ϵ������Ϣ�������1
	 */
	public Map<String, List<SOC0119Info>> getParEntityItemRelationMap() {
		return parEntityItemRelationMap;
	}

	/**
	 * �ʲ����ϵ������Ϣ�������1�趨
	 *
	 * @param username �ʲ����ϵ������Ϣ�������1
	 */
	public void setParEntityItemRelationMap(
			Map<String, List<SOC0119Info>> parEntityItemRelationMap) {
		this.parEntityItemRelationMap = parEntityItemRelationMap;
	}

	/**
	 * �ʲ����ϵ������Ϣ�������2ȡ��
	 * @return �ʲ����ϵ������Ϣ�������2
	 */
	public Map<String, List<SOC0119Info>> getCldEntityItemRelationMap() {
		return cldEntityItemRelationMap;
	}

	/**
	 * �ʲ����ϵ������Ϣ�������2�趨
	 *
	 * @param cldEntityItemRelationMap �ʲ����ϵ������Ϣ�������2
	 */
	public void setCldEntityItemRelationMap(
			Map<String, List<SOC0119Info>> cldEntityItemRelationMap) {
		this.cldEntityItemRelationMap = cldEntityItemRelationMap;
	}

	/**
	 * �ʲ����ϵ��Ϣ1����ȡ��
	 * @return �ʲ����ϵ��Ϣ1����
	 */
	public int getParCount() {
		return parCount;
	}

	/**
	 * �ʲ����ϵ��Ϣ2�����趨
	 *
	 * @param parCount �ʲ����ϵ��Ϣ2����
	 */
	public void setParCount(int parCount) {
		this.parCount = parCount;
	}

	/**
	 * �ʲ����ϵ��Ϣ1����ȡ��
	 * @return �ʲ����ϵ��Ϣ1����
	 */
	public int getCldCount() {
		return cldCount;
	}

	/**
	 * �ʲ����ϵ��Ϣ2�����趨
	 *
	 * @param cldCount �ʲ����ϵ��Ϣ2����
	 */
	public void setCldCount(int cldCount) {
		this.cldCount = cldCount;
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

	public IGASM0341Form getIgasm0341Form() {
		return igasm0341Form;
	}

	public void setIgasm0341Form(IGASM0341Form igasm0341Form) {
		this.igasm0341Form = igasm0341Form;
	}

	/**
	 * ���ð�����ϵ��ʾFORMȡ��
	 * 
	 * @return ���ð�����ϵ��ʾFORM
	 */
	public IGASM0346Form getIgasm0346Form() {
		return igasm0346Form;
	}

	/**
	 * ���ð�����ϵ��ʾFORM�趨
	 * 
	 * @param igasm0346Form���ð�����ϵ��ʾFORM
	 */
	public void setIgasm0346Form(IGASM0346Form igasm0346Form) {
		this.igasm0346Form = igasm0346Form;
	}

	/**
	 * @return the inJiguiFlg
	 */
	public String getInJiguiFlg() {
		return inJiguiFlg;
	}

	/**
	 * @param inJiguiFlg the inJiguiFlg to set
	 */
	public void setInJiguiFlg(String inJiguiFlg) {
		this.inJiguiFlg = inJiguiFlg;
	}
	
}


