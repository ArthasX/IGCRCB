package com.deliverik.infogovernor.soc.cim.dto;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.TableSpaceInfo;
import com.deliverik.framework.soc.asset.model.PlatformManagerInfo;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.SOC0110Info;
import com.deliverik.framework.soc.asset.model.SOC0113Info;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0119Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0128Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.framework.soc.asset.model.SOC0153Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0107SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0118SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.asset.form.IGASM0309Form;
import com.deliverik.infogovernor.asset.form.IGASM0311Form;
import com.deliverik.infogovernor.asset.form.IGASM0312Form;
import com.deliverik.infogovernor.asset.form.IGASM0313Form;
import com.deliverik.infogovernor.asset.form.IGASM0314Form;
import com.deliverik.infogovernor.asset.form.IGASM0315Form;
import com.deliverik.infogovernor.asset.form.IGASM0316Form;
import com.deliverik.infogovernor.asset.form.IGASM0317Form;
import com.deliverik.infogovernor.asset.form.IGASM0320Form;
import com.deliverik.infogovernor.asset.form.IGASM0341Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0101Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0102Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0104Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0105Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0106Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0107Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0108Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0110Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0111Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0112Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0114Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0121Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0122Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0124Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0125Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0126Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0127Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0128Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0129Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0135Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0136Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0137Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0139Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0140Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0146Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0148Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0149Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0152Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0155Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0160Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0161Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0911Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1101Form;
import com.deliverik.infogovernor.soc.cim.model.IG500VWInfo;
import com.deliverik.infogovernor.soc.model.CR01VWInfo;
import com.deliverik.infogovernor.soc.model.CR03Info;
import com.deliverik.infogovernor.soc.model.CR03VWInfo;
import com.deliverik.infogovernor.soc.model.NetDeviceInfo;

/**
 * �豸���ù���ҵ����DTO
 * 
 */
@SuppressWarnings("serial")
public class IGCIM01DTO extends BaseDTO implements Serializable{
	
	/** Ӧ����Ϣ */
	protected IGCIM0122Form igasm0802Form;

	/** Ӧ��������Ϣ */
	protected IGCIM0124Form igasm0804Form;
	
	protected IGCIM0148Form igcim0148Form;

	/** Ӧ��������Ϣ��ʷ��¼�������� */
	protected IGCIM0125Form igasm0805Form;
	
	/** Ӧ�ù�ϵ����������� */
	protected IGCIM0126Form igasm0806Form;
	
	/** Ӧ�ù�ϵ�༭��Ϣ */
	protected IGCIM0127Form igasm0807Form;
	
	/** FS��ϵ�༭��Ϣ */
	protected IGCIM0129Form igasm0813Form;
	protected IGCIM0128Form igasm0812Form;
	
	/**������ɼ���ѯForm*/
	protected IGCIM0112Form igcim0112Form;
	
	/**����ɼ��Ա�Form*/
	protected IGCIM0114Form igcim0114Form;
	
	protected IGCIM0135Form igcim0135Form;
	protected IGCIM0139Form igcim0139Form;
	
	protected IGCIM1101Form igcim1101Form;
	
	protected IGCIM0136Form igcim0136Form;
	
	protected IGCIM0137Form igcim0137Form;
	
	protected IGCIM0155Form igcim0155Form;
	
	protected IGCIM0140Form igcim0140Form;
	private String warnType;
	private IGCIM0160Form igcim0160Form;
	private IGCIM0161Form igcim0161Form;
	private List<SOC0153Info> soc0153List;
	private SOC0153Info soc0153Info;
	
	private IGCIM0911Form igcim0911Form;
	private List<NetDeviceInfo> netDeviceList;
	
	
	
	/** �ʲ��Զ��屨��Ԥ������ */
	protected  Map<String,List<String>> titleListMap;
	
	/** �������������� */
	protected Map<String,Integer> reportSizeMap;
	
	/** ������Ԥ�����ݳ��� */
	protected Map<String,Integer> columnSizeMap;
	
	/** ������title */
	protected String reportTitle;
	
	/** �ʲ��Զ��屨��Ԥ������ */
	protected  Map<String,List<String[]>> contentListMap;
	
	/** ������sheet���� */
	protected String sheetType;
	
	public IGCIM0114Form getIgcim0114Form() {
		return igcim0114Form;
	}

	public void setIgcim0114Form(IGCIM0114Form igcim0114Form) {
		this.igcim0114Form = igcim0114Form;
	}

	/**
	 * FS��ϵ��ѡ�б�
	 */
	protected List<SOC0118Info> entityItemList;
	
	/**
	 * FS��ϵ�Ѿ�ѡ�б�
	 */
	protected List<SOC0118Info> entityItemedList;
	
	protected SOC0107SearchCond configItemSearchCond;
	public SOC0107SearchCond getConfigItemSearchCond() {
		return configItemSearchCond;
	}

	public void setConfigItemSearchCond(SOC0107SearchCond configItemSearchCond) {
		this.configItemSearchCond = configItemSearchCond;
	}

	/** �豸��Ϣ */
	protected IGCIM0102Form igasm0302Form;
	
	/** �豸��Ϣ�������� */
	protected SOC0124SearchCond entityItemVWSearchCond;
	
	/** ���������� */
	protected int maxSearchCount;

	/** ��ҳ��DTO */
	protected PagingDTO pagingDto;
	
	

	/** �豸������� */
	protected List<SOC0124Info> entityItemVWInfoList;
	
	protected List<SOC0119Info> soc0119InfoList;

	/** �豸ɾ������ */
	protected String[] deleteEntityItem;
	
	/** �豸����������� */
	protected String[] batchEntityItem;

	/** �豸������Ϣ */
	protected IGCIM0104Form igasm0304Form;
	/** �豸�����ļ���ʷ�汾�Ƚ���Ϣ */
	protected IGASM0341Form igasm0341Form;
	
	
	/** �豸������Ϣ������� */
	protected List<SOC0129Info> configItemVWInfoList;

	/** �豸������Ϣ�����豸��Ϣ */
	protected SOC0124Info entityItemVWInfo;

	/** �豸������Ϣ��ʷ��¼�������� */
	protected IGCIM0105Form igasm0305Form;
	
	/** �豸������Ϣ��ʷ��¼������� */
	protected List<SOC0107Info> configItemList;
	
	/** �豸��ϵ����������� */
	protected IGCIM0106Form igcim0106Form;

	/** ����ԭ������ʾform */
	protected IGCIM0110Form igcim0110Form;
	
	/** ����Դ���ݱȽϰ汾form */
	protected IGCIM0111Form igcim0111Form;
	
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
	protected IGCIM0107Form igcim0107Form;
	
	/** �豸��ϵ�༭����Ϣ */
	protected SOC0119Info entityItemRelation;

	/** �豸��ϵɾ������ */
	protected String[] deleteEntityItemRelation;
	
	/** �ʲ���������Ϣ������� */
	protected Map<String,List<SOC0129Info>> configItemVWInfoMap;
	
	/** �ʲ���������Ϣ������� */
	protected Map<String,List<SOC0107Info>> configItemMap;
	
	protected List<SOC0113Info> soc0113List;
	
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
	protected Map<TreeNode,String> infoMap;
	
	protected IGCIM0101Form igcim0101Form;
	
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
	protected Locale locale;
	
	/**��ʼ���������ַ���*/
	protected String initTreeStr;
	
	/**��ʼ��������Ĭ��ֵID*/
	protected String initNodeID;
	
	/** ��ID */
	protected Integer domainid;
	
	/** ��汾 */
	protected Integer domainversion;
	
	/** ��������ʱ�� */
	protected String createtime;
	
	/** �Ƿ���ʾ�߼���ϵMAP */
	protected Map<String,String> showRelationMap;
	
	/** ������ϵ */
	protected List<SOC0110Info> eiBelongRelationList;
	
	
	/** ���ð�����ϵ��ʾFORM */
	protected IGCIM0146Form igcim0146Form;
	/** ���ð�����ϵ��ʾFORM */
	protected IGCIM0149Form igcim0149Form;
	
	/** ������� */
	protected List<CR03Info> cr03List;
	
	/** �ɼ���¼�汾��Ϣ */
	protected CR03Info cr03;
	
	/** �ɼ�������� */
	protected List<CR01VWInfo> cr01List;
	
	/** �ɼ�������ϰ汾1 */
	protected List<CR01VWInfo> cr01List1;
	
	/** �ɼ�������ϰ汾2 */
	protected List<CR01VWInfo> cr01List2;
	
	/** �ɼ��汾�б� */
	protected List<CR03VWInfo> cr03VWList;	
	
	protected CR03VWInfo cr03VW;
	
	/** ��ʾ��ʶ */
	protected String showFlag;
	
	protected IGCIM0152Form igcim0152Form;
	
	/** ����ԭ���ݰ汾�Ƚ�map */
	protected Map<String, List<CR01VWInfo>> compareVersionsMap;
	
	/** ������ϵmap */
	protected Map<String,List<SOC0110Info>> rlnmap;

	protected String treeXml;
	
	/** ��ϵ����������*/
	protected List<LabelValueBean> relationTypeList;
	
	protected String eiid;
	
	protected List<PlatformManagerInfo> platformManagerList;

	protected String resid;
	
	
	protected SOC0118SearchCond entityItemSearchCond;
	
	protected List<IG500VWInfo> res500VWList;
	
	public List<PlatformManagerInfo> getPlatformManagerList() {
		return platformManagerList;
	}

	public void setPlatformManagerList(List<PlatformManagerInfo> platformManagerList) {
		this.platformManagerList = platformManagerList;
	}

	public IGCIM0140Form getIgcim0140Form() {
		return igcim0140Form;
	}

	public void setIgcim0140Form(IGCIM0140Form igcim0140Form) {
		this.igcim0140Form = igcim0140Form;
	}

	public String getEiid() {
		return eiid;
	}

	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	public CR03VWInfo getCr03VW() {
		return cr03VW;
	}

	public void setCr03VW(CR03VWInfo cr03VW) {
		this.cr03VW = cr03VW;
	}

	public List<CR03VWInfo> getCr03VWList() {
		return cr03VWList;
	}

	public void setCr03VWList(List<CR03VWInfo> cr03VWList) {
		this.cr03VWList = cr03VWList;
	}

	public Map<String, List<SOC0110Info>> getRlnmap() {
		return rlnmap;
	}

	public void setRlnmap(Map<String, List<SOC0110Info>> rlnmap) {
		this.rlnmap = rlnmap;
	}

	public List<SOC0110Info> getEiBelongRelationList() {
		return eiBelongRelationList;
	}

	public void setEiBelongRelationList(List<SOC0110Info> eiBelongRelationList) {
		this.eiBelongRelationList = eiBelongRelationList;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
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

	public Map<TreeNode, String> getInfoMap() {
		return infoMap;
	}

	public void setInfoMap(Map<TreeNode, String> infoMap) {
		this.infoMap = infoMap;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}


	public IGCIM0101Form getIgcim0101Form() {
		return igcim0101Form;
	}

	public void setIgcim0101Form(IGCIM0101Form igcim0101Form) {
		this.igcim0101Form = igcim0101Form;
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
	
	/** �汾����1 */
	protected String collecttime1;
	
	/** �汾����2 */
	protected String collecttime2;
	
	/** ���ݱ���Ϣ������� */
	protected List<TableSpaceInfo> tableSpaceInfoList;

	public List<TableSpaceInfo> getTableSpaceInfoList() {
		return tableSpaceInfoList;
	}

	public void setTableSpaceInfoList(List<TableSpaceInfo> tableSpaceInfoList) {
		this.tableSpaceInfoList = tableSpaceInfoList;
	}
	
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
	protected IGCIM0121Form igasm0321Form;
	
	/** �豸��Ϣ�����豸��Ϣ */
	protected SOC0118Info entityItem;
	
	protected IGCIM0108Form  igcim0108Form;
	

	public IGCIM0108Form getIgcim0108Form() {
		return igcim0108Form;
	}

	public void setIgcim0108Form(IGCIM0108Form igcim0108Form) {
		this.igcim0108Form = igcim0108Form;
	}

	public IGCIM0121Form getIgasm0321Form() {
		return igasm0321Form;
	}

	public void setIgasm0321Form(IGCIM0121Form igasm0321Form) {
		this.igasm0321Form = igasm0321Form;
	}

	public SOC0118Info getEntityItem() {
		return entityItem;
	}

	public void setEntityItem(SOC0118Info entityItem) {
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
	public IGCIM0102Form getIgasm0302Form() {
		return igasm0302Form;
	}

	/**
	 * �豸��Ϣ�趨
	 *
	 * @param igasm0302Form �豸��Ϣ
	 */
	public void setIgasm0302Form(IGCIM0102Form igasm0302Form) {
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
	public IGCIM0104Form getIgasm0304Form() {
		return igasm0304Form;
	}


	/**
	 * �豸������Ϣ���������趨
	 *
	 * @param igasm0304Form �豸������Ϣ��������
	 */
	public void setIgasm0304Form(IGCIM0104Form igasm0304Form) {
		this.igasm0304Form = igasm0304Form;
	}

	/**
	 * �豸������Ϣ�������ȡ��
	 * @return �豸������Ϣ�������
	 */
	public List<SOC0129Info> getConfigItemVWInfoList() {
		return configItemVWInfoList;
	}

	/**
	 * �豸������Ϣ��������趨
	 *
	 * @param configItemVWInfoList �豸������Ϣ�������
	 */
	public void setConfigItemVWInfoList(List<SOC0129Info> configItemVWInfoList) {
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
	public IGCIM0105Form getIgasm0305Form() {
		return igasm0305Form;
	}

	/**
	 * �豸������Ϣ��ʷ��¼���������趨
	 *
	 * @param igasm0305Form �豸������Ϣ��ʷ��¼��������
	 */
	public void setIgasm0305Form(IGCIM0105Form igasm0305Form) {
		this.igasm0305Form = igasm0305Form;
	}

	/**
	 * �豸������Ϣ��ʷ��¼�������ȡ��
	 * @return �豸������Ϣ��ʷ��¼�������
	 */
	public List<SOC0107Info> getConfigItemList() {
		return configItemList;
	}

	/**
	 * �豸������Ϣ��ʷ��¼��������趨
	 *
	 * @param configItemList �豸������Ϣ��ʷ��¼�������
	 */
	public void setConfigItemList(List<SOC0107Info> configItemList) {
		this.configItemList = configItemList;
	}


	/**
	 * �ʲ����ϵ������Ϣ�������1ȡ��
	 * @return �ʲ����ϵ������Ϣ�������1
	 */
	public List<SOC0119Info> getParEntityItemRelationList() {
		return parEntityItemRelationList;
	}

	public IGCIM0106Form getIgcim0106Form() {
		return igcim0106Form;
	}

	public void setIgcim0106Form(IGCIM0106Form igcim0106Form) {
		this.igcim0106Form = igcim0106Form;
	}
	
	/**
	 * ����ԭ������ʾformȡ��
	 * @return ����ԭ������ʾform
	 */
	public IGCIM0110Form getIgcim0110Form() {
		return igcim0110Form;
	}

	/**
	 * ����ԭ������ʾform�趨
	 * @param igcim0110Form ����ԭ������ʾform
	 */
	public void setIgcim0110Form(IGCIM0110Form igcim0110Form) {
		this.igcim0110Form = igcim0110Form;
	}
	
	/**
	 * ����Դ���ݱȽϰ汾formȡ��
	 * @return ����Դ���ݱȽϰ汾form
	 */
	public IGCIM0111Form getIgcim0111Form() {
		return igcim0111Form;
	}

	/**
	 * ����Դ���ݱȽϰ汾form�趨
	 * @param igcim0111Form ����Դ���ݱȽϰ汾form
	 */
	public void setIgcim0111Form(IGCIM0111Form igcim0111Form) {
		this.igcim0111Form = igcim0111Form;
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


	public IGCIM0107Form getIgcim0107Form() {
		return igcim0107Form;
	}

	public void setIgcim0107Form(IGCIM0107Form igcim0107Form) {
		this.igcim0107Form = igcim0107Form;
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

	public IGCIM0146Form getIgcim0146Form() {
		return igcim0146Form;
	}

	public void setIgcim0146Form(IGCIM0146Form igcim0146Form) {
		this.igcim0146Form = igcim0146Form;
	}

	/**
	 * @return the domainid
	 */
	public Integer getDomainid() {
		return domainid;
	}

	/**
	 * @param domainid the domainid to set
	 */
	public void setDomainid(Integer domainid) {
		this.domainid = domainid;
	}

	/**
	 * @return the domainversion
	 */
	public Integer getDomainversion() {
		return domainversion;
	}

	/**
	 * @param domainversion the domainversion to set
	 */
	public void setDomainversion(Integer domainversion) {
		this.domainversion = domainversion;
	}

	/**
	 * @return the createtime
	 */
	public String getCreatetime() {
		return createtime;
	}

	/**
	 * @param createtime the createtime to set
	 */
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	/**
	 * @return the showRelationMap
	 */
	public Map<String, String> getShowRelationMap() {
		return showRelationMap;
	}

	/**
	 * @param showRelationMap the showRelationMap to set
	 */
	public void setShowRelationMap(Map<String, String> showRelationMap) {
		this.showRelationMap = showRelationMap;
	}

	/**
	 * Ӧ����Ϣȡ��
	 *
	 * @return igasm0802Form Ӧ����Ϣ
	 */
	public IGCIM0122Form getIgasm0802Form() {
		return igasm0802Form;
	}

	/**
	 * Ӧ����Ϣ�趨
	 *
	 * @param igasm0802Form Ӧ����Ϣ
	 */
	public void setIgasm0802Form(IGCIM0122Form igasm0802Form) {
		this.igasm0802Form = igasm0802Form;
	}

	/**
	 * Ӧ��������Ϣȡ��
	 *
	 * @return igasm0804Form Ӧ��������Ϣ
	 */
	public IGCIM0124Form getIgasm0804Form() {
		return igasm0804Form;
	}

	/**
	 * Ӧ��������Ϣ�趨
	 *
	 * @param igasm0804Form Ӧ��������Ϣ
	 */
	public void setIgasm0804Form(IGCIM0124Form igasm0804Form) {
		this.igasm0804Form = igasm0804Form;
	}

	/**
	 * Ӧ��������Ϣ��ʷ��¼��������ȡ��
	 *
	 * @return igasm0805Form Ӧ��������Ϣ��ʷ��¼��������
	 */
	public IGCIM0125Form getIgasm0805Form() {
		return igasm0805Form;
	}

	/**
	 * Ӧ��������Ϣ��ʷ��¼���������趨
	 *
	 * @param igasm0805Form Ӧ��������Ϣ��ʷ��¼��������
	 */
	public void setIgasm0805Form(IGCIM0125Form igasm0805Form) {
		this.igasm0805Form = igasm0805Form;
	}

	/**
	 * Ӧ�ù�ϵ�����������ȡ��
	 *
	 * @return igasm0806Form Ӧ�ù�ϵ�����������
	 */
	public IGCIM0126Form getIgasm0806Form() {
		return igasm0806Form;
	}

	/**
	 * Ӧ�ù�ϵ������������趨
	 *
	 * @param igasm0806Form Ӧ�ù�ϵ�����������
	 */
	public void setIgasm0806Form(IGCIM0126Form igasm0806Form) {
		this.igasm0806Form = igasm0806Form;
	}

	/**
	 * Ӧ�ù�ϵ�༭��Ϣȡ��
	 *
	 * @return igasm0807Form Ӧ�ù�ϵ�༭��Ϣ
	 */
	public IGCIM0127Form getIgasm0807Form() {
		return igasm0807Form;
	}

	/**
	 * Ӧ�ù�ϵ�༭��Ϣ�趨
	 *
	 * @param igasm0807Form Ӧ�ù�ϵ�༭��Ϣ
	 */
	public void setIgasm0807Form(IGCIM0127Form igasm0807Form) {
		this.igasm0807Form = igasm0807Form;
	}

	/**
	 * FS��ϵ�༭��Ϣȡ��
	 *
	 * @return igasm0813Form FS��ϵ�༭��Ϣ
	 */
	public IGCIM0129Form getIgasm0813Form() {
		return igasm0813Form;
	}

	/**
	 * FS��ϵ�༭��Ϣ�趨
	 *
	 * @param igasm0813Form FS��ϵ�༭��Ϣ
	 */
	public void setIgasm0813Form(IGCIM0129Form igasm0813Form) {
		this.igasm0813Form = igasm0813Form;
	}

	/**
	 * igasm0812Formȡ��
	 *
	 * @return igasm0812Form igasm0812Form
	 */
	public IGCIM0128Form getIgasm0812Form() {
		return igasm0812Form;
	}

	/**
	 * igasm0812Form�趨
	 *
	 * @param igasm0812Form igasm0812Form
	 */
	public void setIgasm0812Form(IGCIM0128Form igasm0812Form) {
		this.igasm0812Form = igasm0812Form;
	}

	/**
	 * FS��ϵ��ѡ�б�ȡ��
	 *
	 * @return entityItemList FS��ϵ��ѡ�б�
	 */
	public List<SOC0118Info> getEntityItemList() {
		return entityItemList;
	}

	/**
	 * FS��ϵ��ѡ�б��趨
	 *
	 * @param entityItemList FS��ϵ��ѡ�б�
	 */
	public void setEntityItemList(List<SOC0118Info> entityItemList) {
		this.entityItemList = entityItemList;
	}

	/**
	 * FS��ϵ�Ѿ�ѡ�б�ȡ��
	 *
	 * @return entityItemedList FS��ϵ�Ѿ�ѡ�б�
	 */
	public List<SOC0118Info> getEntityItemedList() {
		return entityItemedList;
	}

	/**
	 * FS��ϵ�Ѿ�ѡ�б��趨
	 *
	 * @param entityItemedList FS��ϵ�Ѿ�ѡ�б�
	 */
	public void setEntityItemedList(List<SOC0118Info> entityItemedList) {
		this.entityItemedList = entityItemedList;
	}
	
	/**
	 * �������ȡ��
	 * @return �������
	 */
	public List<CR03Info> getCr03List() {
		return cr03List;
	}

	/**
	 * ��������趨
	 * @param cr03List �������
	 */
	public void setCr03List(List<CR03Info> cr03List) {
		this.cr03List = cr03List;
	}

	/**
	 * �ɼ���¼�汾��Ϣȡ��
	 * @return �ɼ���¼�汾��Ϣ
	 */
	public CR03Info getCr03() {
		return cr03;
	}

	/**
	 * �ɼ���¼�汾��Ϣ�趨
	 * @param cr03 �ɼ���¼�汾��Ϣ
	 */
	public void setCr03(CR03Info cr03) {
		this.cr03 = cr03;
	}

	/**
	 * �ɼ��������ȡ��
	 * @return �ɼ��������
	 */
	public List<CR01VWInfo> getCr01List() {
		return cr01List;
	}

	/**
	 * �ɼ��������ȡ���趨
	 * @param cr01List �ɼ��������ȡ��
	 */
	public void setCr01List(List<CR01VWInfo> cr01List) {
		this.cr01List = cr01List;
	}
	
	/**
	 * ��ʾ��ʶȡ��
	 * @return ��ʾ��ʶ
	 */
	public String getShowFlag() {
		return showFlag;
	}

	/**
	 * ��ʾ��ʶ�趨
	 * @param showFlag ��ʾ��ʶ
	 */
	public void setShowFlag(String showFlag) {
		this.showFlag = showFlag;
	}
	
	/**
	 * ����ԭ���ݰ汾�Ƚ�mapȡ��
	 * @return ����ԭ���ݰ汾�Ƚ�map
	 */
	public Map<String, List<CR01VWInfo>> getCompareVersionsMap() {
		return compareVersionsMap;
	}

	/**
	 * ����ԭ���ݰ汾�Ƚ�map�趨
	 * @param compareVersionsMap ����ԭ���ݰ汾�Ƚ�map
	 */
	public void setCompareVersionsMap(Map<String, List<CR01VWInfo>> compareVersionsMap) {
		this.compareVersionsMap = compareVersionsMap;
	}

	/**
	 * ���԰�����formȡ��
	 *
	 * @return igcim0148Form ���԰�����form
	 */
	

	/**
	 * ��ʼ���������ַ���ȡ��
	 *
	 * @return initTreeStr ��ʼ���������ַ���
	 */
	
	public String getInitTreeStr() {
		return initTreeStr;
	}

	/**
	 * ��ʼ���������ַ����趨
	 *
	 * @param initTreeStr ��ʼ���������ַ���
	 */
	
	public void setInitTreeStr(String initTreeStr) {
		this.initTreeStr = initTreeStr;
	}

	/**
	 * ��ʼ��������Ĭ��ֵIDȡ��
	 *
	 * @return initNodeID ��ʼ��������Ĭ��ֵID
	 */
	
	public String getInitNodeID() {
		return initNodeID;
	}

	/**
	 * ��ʼ��������Ĭ��ֵID�趨
	 *
	 * @param initNodeID ��ʼ��������Ĭ��ֵID
	 */
	
	public void setInitNodeID(String initNodeID) {
		this.initNodeID = initNodeID;
	}

	/**
	 * ������ɼ���ѯFormȡ��
	 *
	 * @return igcim0112Form ������ɼ���ѯForm
	 */
	
	public IGCIM0112Form getIgcim0112Form() {
		return igcim0112Form;
	}

	/**
	 * ������ɼ���ѯForm�趨
	 *
	 * @param igcim0112Form ������ɼ���ѯForm
	 */
	
	public void setIgcim0112Form(IGCIM0112Form igcim0112Form) {
		this.igcim0112Form = igcim0112Form;
	}

	public List<CR01VWInfo> getCr01List1() {
		return cr01List1;
	}

	public void setCr01List1(List<CR01VWInfo> cr01List1) {
		this.cr01List1 = cr01List1;
	}

	public List<CR01VWInfo> getCr01List2() {
		return cr01List2;
	}

	public void setCr01List2(List<CR01VWInfo> cr01List2) {
		this.cr01List2 = cr01List2;
	}

	public String getCollecttime1() {
		return collecttime1;
	}

	public void setCollecttime1(String collecttime1) {
		this.collecttime1 = collecttime1;
	}

	public String getCollecttime2() {
		return collecttime2;
	}

	public void setCollecttime2(String collecttime2) {
		this.collecttime2 = collecttime2;
	}

	public List<SOC0119Info> getSoc0119InfoList() {
		return soc0119InfoList;
	}

	public void setSoc0119InfoList(List<SOC0119Info> soc0119InfoList) {
		this.soc0119InfoList = soc0119InfoList;
	}

	public IGCIM0135Form getIgcim0135Form() {
		return igcim0135Form;
	}

	public void setIgcim0135Form(IGCIM0135Form igcim0135Form) {
		this.igcim0135Form = igcim0135Form;
	}

	public IGCIM0136Form getIgcim0136Form() {
		return igcim0136Form;
	}

	public void setIgcim0136Form(IGCIM0136Form igcim0136Form) {
		this.igcim0136Form = igcim0136Form;
	}

	public IGCIM0137Form getIgcim0137Form() {
		return igcim0137Form;
	}

	public void setIgcim0137Form(IGCIM0137Form igcim0137Form) {
		this.igcim0137Form = igcim0137Form;
	}


	/**
	 * igcim0155Formȡ��
	 *
	 * @return igcim0155Form igcim0155Form
	 */


	public IGCIM0152Form getIgcim0152Form() {
		return igcim0152Form;
	}

	public void setIgcim0152Form(IGCIM0152Form igcim0152Form) {
		this.igcim0152Form = igcim0152Form;
	}

	
	public IGCIM0155Form getIgcim0155Form() {
		return igcim0155Form;
	}

	/**
	 * igcim0155Form�趨
	 *
	 * @param igcim0155Form igcim0155Form
	 */
	
	public void setIgcim0155Form(IGCIM0155Form igcim0155Form) {
		this.igcim0155Form = igcim0155Form;
	}

	public String getTreeXml() {
		return treeXml;
	}

	public void setTreeXml(String treeXml) {
		this.treeXml = treeXml;
	}

	public List<LabelValueBean> getRelationTypeList() {
		return relationTypeList;
	}

	public void setRelationTypeList(List<LabelValueBean> relationTypeList) {
		this.relationTypeList = relationTypeList;
	}
	

	public IGCIM0160Form getIgcim0160Form() {
		return igcim0160Form;
	}

	public void setIgcim0160Form(IGCIM0160Form igcim0160Form) {
		this.igcim0160Form = igcim0160Form;
	}

	public IGCIM0161Form getIgcim0161Form() {
		return igcim0161Form;
	}

	public void setIgcim0161Form(IGCIM0161Form igcim0161Form) {
		this.igcim0161Form = igcim0161Form;
	}

	public List<SOC0153Info> getSoc0153List() {
		return soc0153List;
	}

	public void setSoc0153List(List<SOC0153Info> soc0153List) {
		this.soc0153List = soc0153List;
	}

	public SOC0153Info getSoc0153Info() {
		return soc0153Info;
	}

	public void setSoc0153Info(SOC0153Info soc0153Info) {
		this.soc0153Info = soc0153Info;
	}

	public String getWarnType() {
		return warnType;
	}

	public void setWarnType(String warnType) {
		this.warnType = warnType;
	}

	public IGCIM0139Form getIgcim0139Form() {
		return igcim0139Form;
	}

	public void setIgcim0139Form(IGCIM0139Form igcim0139Form) {
		this.igcim0139Form = igcim0139Form;
	}

	public IGCIM1101Form getIgcim1101Form() {
		return igcim1101Form;
	}

	public void setIgcim1101Form(IGCIM1101Form igcim1101Form) {
		this.igcim1101Form = igcim1101Form;
	}

	/**
	 * igcim0911Formȡ��
	 *
	 * @return igcim0911Form igcim0911Form
	 */
	public IGCIM0911Form getIgcim0911Form() {
		return igcim0911Form;
	}

	/**
	 * netDeviceListȡ��
	 *
	 * @return netDeviceList netDeviceList
	 */
	public List<NetDeviceInfo> getNetDeviceList() {
		return netDeviceList;
	}

	/**
	 * igcim0911Form�趨
	 *
	 * @param igcim0911Form igcim0911Form
	 */
	public void setIgcim0911Form(IGCIM0911Form igcim0911Form) {
		this.igcim0911Form = igcim0911Form;
	}

	/**
	 * netDeviceList�趨
	 *
	 * @param netDeviceList netDeviceList
	 */
	public void setNetDeviceList(List<NetDeviceInfo> netDeviceList) {
		this.netDeviceList = netDeviceList;
	}
	

	public Map<String, List<String>> getTitleListMap() {
		return titleListMap;
	}

	public void setTitleListMap(Map<String, List<String>> titleListMap) {
		this.titleListMap = titleListMap;
	}

	public Map<String, Integer> getReportSizeMap() {
		return reportSizeMap;
	}

	public void setReportSizeMap(Map<String, Integer> reportSizeMap) {
		this.reportSizeMap = reportSizeMap;
	}

	public Map<String, Integer> getColumnSizeMap() {
		return columnSizeMap;
	}

	public void setColumnSizeMap(Map<String, Integer> columnSizeMap) {
		this.columnSizeMap = columnSizeMap;
	}


	public String getReportTitle() {
		return reportTitle;
	}

	public void setReportTitle(String reportTitle) {
		this.reportTitle = reportTitle;
	}

	public Map<String, List<String[]>> getContentListMap() {
		return contentListMap;
	}

	public void setContentListMap(Map<String, List<String[]>> contentListMap) {
		this.contentListMap = contentListMap;
	}

	public String getSheetType() {
		return sheetType;
	}

	public void setSheetType(String sheetType) {
		this.sheetType = sheetType;
	}

	public List<SOC0113Info> getSoc0113List() {
		return soc0113List;
	}

	public void setSoc0113List(List<SOC0113Info> soc0113List) {
		this.soc0113List = soc0113List;
	}

	public IGCIM0148Form getIgcim0148Form() {
		return igcim0148Form;
	}

	public void setIgcim0148Form(IGCIM0148Form igcim0148Form) {
		this.igcim0148Form = igcim0148Form;
	}

	public IGCIM0149Form getIgcim0149Form() {
		return igcim0149Form;
	}

	public void setIgcim0149Form(IGCIM0149Form igcim0149Form) {
		this.igcim0149Form = igcim0149Form;
	}

	/**
	 * residȡ��
	 * @return resid resid
	 */
	public String getResid() {
		return resid;
	}

	/**
	 * resid�趨
	 * @param resid resid
	 */
	public void setResid(String resid) {
		this.resid = resid;
	}

	public SOC0118SearchCond getEntityItemSearchCond() {
		return entityItemSearchCond;
	}

	public void setEntityItemSearchCond(SOC0118SearchCond entityItemSearchCond) {
		this.entityItemSearchCond = entityItemSearchCond;
	}

	/**
	 * res500VWListȡ��
	 * @return res500VWList res500VWList
	 */
	public List<IG500VWInfo> getRes500VWList() {
		return res500VWList;
	}

	/**
	 * res500VWList�趨
	 * @param res500VWList res500VWList
	 */
	public void setRes500VWList(List<IG500VWInfo> res500vwList) {
		res500VWList = res500vwList;
	}

}


