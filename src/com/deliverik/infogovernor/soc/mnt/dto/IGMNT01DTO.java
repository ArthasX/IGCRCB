/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.mnt.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.soc.dbs.model.Collect_Symmetrix_Info;
import com.deliverik.infogovernor.soc.mnt.form.IGMNT0102Form;
import com.deliverik.infogovernor.soc.mnt.form.IGMNT0103Form;
import com.deliverik.infogovernor.soc.mnt.form.IGMNT0104Form;
import com.deliverik.infogovernor.soc.mnt.form.IGMNT0107Form;
import com.deliverik.infogovernor.soc.mnt.model.MonitorObjectDefInfo;
import com.deliverik.infogovernor.soc.mnt.model.MonitorObjectInfo;
import com.deliverik.infogovernor.soc.mnt.model.MonitorTypeDefInfo;
import com.deliverik.infogovernor.soc.mnt.model.Object_ListInfo;
import com.deliverik.infogovernor.soc.mnt.model.SOC0304Info;
/**
 * ����:��ع���DTO
 * ����������
 * ������¼�����    2012/02/09
 */

@SuppressWarnings("serial")
public class IGMNT01DTO extends BaseDTO implements Serializable{
	
	/** 
	 * ���ʻ���Ϣ 
	 */
	protected Locale locale;
	/**��ǰ�û�*/
	protected User user;
	/** 
	 * ��������� 
	 */
	protected Map<String,TreeNode> treeNodeMap;
	
	/** 
	 * ������ͼ��� 
	 */
	protected List<LabelValueBean> monitorTypeList;
	
	/**
	 * ��ض������Ƽ���
	 */
	protected List<LabelValueBean> moNameList;
	
	/**
	 * ��ض��󼯺�
	 */
	protected List<MonitorObjectInfo> monitorObjectList;
	
	/**
	 * ��ض���ֵ����
	 */
	protected List<MonitorObjectDefInfo> monitorObjectDefList;
	
	
	/**
	 * ��ض���ʵ��
	 */
	protected MonitorObjectInfo monitorObject;

	/**
	 * ������ͷ�ֵ��Ϣform
	 */
	protected IGMNT0102Form igmnt0102Form;
	
	/**
	 * ��ض���Ǽ�form
	 */
	protected IGMNT0103Form igmnt0103Form;
	
	/**
	 * ��ض������form
	 */
	protected IGMNT0104Form igmnt0104Form;
	
	/**
	 * debug�������form
	 */
	protected IGMNT0107Form igmnt0107Form;
	
	/**
	 * �������к�
	 */
	protected String mtSsn;
	/**
	 * ѡ������
	 */
	protected String checkedCount;
	/** 
	 * ���������� 
	 */
	protected int maxSearchCount;

	/** 
	 * ��ҳ��DTO 
	 */
	protected PagingDTO pagingDto;
	
	/** �ʲ�ģ�Ͳ���� */
	protected String esyscoding;
	
	/** �ʲ�ģ������ */
	protected String ename;
	
	/** �ʲ�����Ϣ�������� */
	protected SOC0124SearchCond entityItemVWSearchCond;
	
	/** �ʲ��������� */
	protected List<SOC0124Info> entityItemVWInfoList;
	
	/**
	 * �������id
	 */
	protected String mtId;
	
	/** �洢����� */
	protected String syscoding;
	
	/** �洢�����µı�����Ϣ */
	protected List<CodeDetail> codeDetailList;
	
	/** �洢�����µı�����Ϣ */
	protected CodeDetail codeDetailInfo;
	
	/**�ʲ����Ͳ���뼯��*/
	protected List<LabelValueBean> esyscodingList;
	
	/**
	 * �洢������Ϣʵ�弯��
	 */
	protected List<Collect_Symmetrix_Info> collect_Symmetrix_InfoList;
	
	/**�����ؼ���*/
	protected List<SOC0304Info> soc0304List=new ArrayList<SOC0304Info>();
	
	
	/**���󼯺�*/
	protected List<Object_ListInfo> olInfoList=new ArrayList<Object_ListInfo>();
	
	/**ʱ��Ĭ��*/
	protected String interValDefault;
	
	/**��������ID*/
	protected String tmpMtId;
	/**�����ʶ*/
	protected String errFlag;
	/**
	 * �洢�����ȡ��
	 * @return �洢�����
	 */
	public String getSyscoding() {
		return syscoding;
	}

	/**
	 * �洢������趨
	 * @param syscoding�洢�����
	 */
	public void setSyscoding(String syscoding) {
		this.syscoding = syscoding;
	}
	
	/**
	 * �ʲ���������ȡ��
	 * @return �ʲ���������
	 */
	public List<SOC0124Info> getEntityItemVWInfoList() {
		return entityItemVWInfoList;
	}

	/**
	 * �ʲ����������趨
	 *
	 * @param entityItemVWInfoList �ʲ���������
	 */
	public void setEntityItemVWInfoList(List<SOC0124Info> entityItemVWInfoList) {
		this.entityItemVWInfoList = entityItemVWInfoList;
	}
	
	/**
	 * �ʲ�����Ϣ��������ȡ��
	 * @return �ʲ�����Ϣ��������
	 */
	public SOC0124SearchCond getEntityItemVWSearchCond() {
		return entityItemVWSearchCond;
	}

	/**
	 * �ʲ�����Ϣ���������趨
	 *
	 * @param entityItemVWSearchCond �ʲ�����Ϣ��������
	 */
	public void setEntityItemVWSearchCond(
			SOC0124SearchCond entityItemVWSearchCond) {
		this.entityItemVWSearchCond = entityItemVWSearchCond;
	}
	
	/**
	 * �ʲ�ģ������ȡ��
	 * @return �ʲ�ģ������
	 */
	public String getEname() {
		return ename;
	}

	/**
	 * �ʲ�ģ�������趨
	 *
	 * @param eiid �ʲ�ģ������
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}
	
	/**
	 * �ʲ�ģ�Ͳ����ȡ��
	 * @return �ʲ�ģ�Ͳ����
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * �ʲ�ģ�Ͳ�����趨
	 *
	 * @param eiid �ʲ�ģ�Ͳ����
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}
	
	/**
	 * ��ض���Ǽ�form��ȡ
	 * @return
	 */
	public IGMNT0103Form getIgmnt0103Form() {
		return igmnt0103Form;
	}

	/**
	 * ��ض���Ǽ�form�趨
	 * @param igmnt0103Form
	 */
	public void setIgmnt0103Form(IGMNT0103Form igmnt0103Form) {
		this.igmnt0103Form = igmnt0103Form;
	}

	/**
	 * ������ͷ�ֵ��Ϣ����
	 */
	protected List<MonitorTypeDefInfo> monitorTypeDefInfoList;

	/**
	 * ������ͷ�ֵ��Ϣ���ϻ�ȡ
	 * @return
	 */
	public List<MonitorTypeDefInfo> getMonitorTypeDefInfoList() {
		return monitorTypeDefInfoList;
	}

	/**
	 * ������ͷ�ֵ��Ϣ�����趨
	 * @param monitorTypeDefInfoList
	 */
	public void setMonitorTypeDefInfoList(
			List<MonitorTypeDefInfo> monitorTypeDefInfoList) {
		this.monitorTypeDefInfoList = monitorTypeDefInfoList;
	}

	/**
	 * ������ͷ�ֵ��Ϣform��ȡ
	 * @return
	 */
	public IGMNT0102Form getIgmnt0102Form() {
		return igmnt0102Form;
	}

	/**
	 * ������ͷ�ֵ��Ϣform�趨
	 * @param form
	 */
	public void setIgmnt0102Form(IGMNT0102Form igmnt0102Form) {
		this.igmnt0102Form = igmnt0102Form;
	}

	/**
	 * ��ط�����ȡ��
	 * @return
	 */
	public Map<String, TreeNode> getTreeNodeMap() {
		return treeNodeMap;
	}

	/**
	 * ��ط������趨
	 * @param treeNodeMap
	 */
	public void setTreeNodeMap(Map<String, TreeNode> treeNodeMap) {
		this.treeNodeMap = treeNodeMap;
	}

	/**
	 * ������ͼ��ϻ�ȡ
	 * @return
	 */
	public List<LabelValueBean> getMonitorTypeList() {
		return monitorTypeList;
	}

	/**
	 * ������ͼ���ȡ��
	 * @param monitorTypeList
	 */
	public void setMonitorTypeList(List<LabelValueBean> monitorTypeList) {
		this.monitorTypeList = monitorTypeList;
	}

	/**
	 * ���ʻ���ȡ
	 * @return
	 */
	public Locale getLocale() {
		return locale;
	}

	/**
	 * ���ʻ��趨
	 * @param locale
	 */
	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	/**
	 * ��ض������form��ȡ
	 * @return
	 */
	public IGMNT0104Form getIgmnt0104Form() {
		return igmnt0104Form;
	}

	/**
	 * ��ض������form�趨
	 * @param igmnt0104Form
	 */
	public void setIgmnt0104Form(IGMNT0104Form igmnt0104Form) {
		this.igmnt0104Form = igmnt0104Form;
	}

	/**
	 * ��ض��󼯺ϻ�ȡ
	 * @return
	 */
	public List<MonitorObjectInfo> getMonitorObjectList() {
		return monitorObjectList;
	}

	/**
	 * ��ض��󼯺��趨
	 * @param monitorObjectList
	 */
	public void setMonitorObjectList(List<MonitorObjectInfo> monitorObjectList) {
		this.monitorObjectList = monitorObjectList;
	}

	/**
	 * ����������ȡ��
	 * @return
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**�����������趨
	 * 
	 * @param maxSearchCount
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * ��ҳ��DTOȡ��
	 * @return
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * ��ҳ��DTO�趨
	 * @param pagingDto
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * ��ض���ʵ��ȡ��
	 * @return
	 */
	public MonitorObjectInfo getMonitorObject() {
		return monitorObject;
	}

	/**
	 * ��ض���ʵ���趨
	 * @param monitorObject
	 */
	public void setMonitorObject(MonitorObjectInfo monitorObject) {
		this.monitorObject = monitorObject;
	}

	/**
	 * ��ض���ֵ����ȡ��
	 * @return
	 */
	public List<MonitorObjectDefInfo> getMonitorObjectDefList() {
		return monitorObjectDefList;
	}

	/**
	 * ��ض���ֵ�����趨
	 * @param monitorObjectDefList
	 */
	public void setMonitorObjectDefList(
			List<MonitorObjectDefInfo> monitorObjectDefList) {
		this.monitorObjectDefList = monitorObjectDefList;
	}

	/**
	 * ��ض������Ƽ���ȡ��
	 * @return
	 */
	public List<LabelValueBean> getMoNameList() {
		return moNameList;
	}

	/**
	 * ��ض������Ƽ����趨
	 * @param moNameList
	 */
	public void setMoNameList(List<LabelValueBean> moNameList) {
		this.moNameList = moNameList;
	}

	/**
	 * �������idȡ��
	 * @return
	 */
	public String getMtId() {
		return mtId;
	}

	/**
	 * �������id�趨
	 * @param mtId
	 */
	public void setMtId(String mtId) {
		this.mtId = mtId;
	}

	/**
	 * �洢�����µı�����Ϣȡ��
	 * @return �洢�����µı�����Ϣ
	 */
	public List<CodeDetail> getCodeDetailList() {
		return codeDetailList;
	}

	/**
	 * �洢�����µı�����Ϣ�趨
	 * @param codeDetailList�洢�����µı�����Ϣ
	 */
	public void setCodeDetailList(List<CodeDetail> codeDetailList) {
		this.codeDetailList = codeDetailList;
	}
	
	/**
	 * �洢�����µı�����Ϣȡ��
	 * @return �洢�����µı�����Ϣ
	 */
	public CodeDetail getCodeDetailInfo() {
		return codeDetailInfo;
	}

	/**
	 * �洢�����µı�����Ϣ�趨
	 * @param codeDetailInfo�洢�����µı�����Ϣ
	 */
	public void setCodeDetailInfo(CodeDetail codeDetailInfo) {
		this.codeDetailInfo = codeDetailInfo;
	}

	/**
	 * �洢������Ϣʵ�弯��ȡ��
	 * @return
	 */
	public List<Collect_Symmetrix_Info> getCollect_Symmetrix_InfoList() {
		return collect_Symmetrix_InfoList;
	}

	/**
	 * �洢������Ϣʵ�弯���趨
	 * @param collect_Symmetrix_InfoList
	 */
	public void setCollect_Symmetrix_InfoList(
			List<Collect_Symmetrix_Info> collect_Symmetrix_InfoList) {
		this.collect_Symmetrix_InfoList = collect_Symmetrix_InfoList;
	}

	/**
	 * �ʲ����Ͳ���뼯��ȡ��
	 * @return
	 */
	public List<LabelValueBean> getEsyscodingList() {
		return esyscodingList;
	}

	/**
	 * �ʲ����Ͳ���뼯���趨
	 * @param esyscodingList
	 */
	public void setEsyscodingList(List<LabelValueBean> esyscodingList) {
		this.esyscodingList = esyscodingList;
	}

	/**
	 * debug�������formȡ��
	 *
	 * @return igmnt0107Form debug�������form
	 */
	public IGMNT0107Form getIgmnt0107Form() {
		return igmnt0107Form;
	}

	/**
	 * debug�������form�趨
	 *
	 * @param igmnt0107Form debug�������form
	 */
	public void setIgmnt0107Form(IGMNT0107Form igmnt0107Form) {
		this.igmnt0107Form = igmnt0107Form;
	}



	/**
	 * ���󼯺�ȡ��
	 *
	 * @return olInfoList ���󼯺�
	 */
	public List<Object_ListInfo> getOlInfoList() {
		return olInfoList;
	}

	/**
	 * ���󼯺��趨
	 *
	 * @param olInfoList ���󼯺�
	 */
	public void setOlInfoList(List<Object_ListInfo> olInfoList) {
		this.olInfoList = olInfoList;
	}

	/**
	 * ��ǰ�û�ȡ��
	 *
	 * @return user ��ǰ�û�
	 */
	public User getUser() {
		return user;
	}

	/**
	 * ��ǰ�û��趨
	 *
	 * @param user ��ǰ�û�
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * �������к�ȡ��
	 *
	 * @return mtSsn �������к�
	 */
	public String getMtSsn() {
		return mtSsn;
	}

	/**
	 * �������к��趨
	 *
	 * @param mtSsn �������к�
	 */
	public void setMtSsn(String mtSsn) {
		this.mtSsn = mtSsn;
	}

	/**
	 * ѡ������ȡ��
	 *
	 * @return checkedCount ѡ������
	 */
	public String getCheckedCount() {
		return checkedCount;
	}

	/**
	 * ѡ�������趨
	 *
	 * @param checkedCount ѡ������
	 */
	public void setCheckedCount(String checkedCount) {
		this.checkedCount = checkedCount;
	}

	/**
	 * ʱ��Ĭ��ȡ��
	 *
	 * @return interValDefault ʱ��Ĭ��
	 */
	public String getInterValDefault() {
		return interValDefault;
	}

	/**
	 * ʱ��Ĭ���趨
	 *
	 * @param interValDefault ʱ��Ĭ��
	 */
	public void setInterValDefault(String interValDefault) {
		this.interValDefault = interValDefault;
	}

	/**
	 * ��������IDȡ��
	 *
	 * @return tmpMtId ��������ID
	 */
	public String getTmpMtId() {
		return tmpMtId;
	}

	/**
	 * ��������ID�趨
	 *
	 * @param tmpMtId ��������ID
	 */
	public void setTmpMtId(String tmpMtId) {
		this.tmpMtId = tmpMtId;
	}

	/**
	 * �����ʶȡ��
	 *
	 * @return errFlag �����ʶ
	 */
	public String getErrFlag() {
		return errFlag;
	}

	/**
	 * �����ʶ�趨
	 *
	 * @param errFlag �����ʶ
	 */
	public void setErrFlag(String errFlag) {
		this.errFlag = errFlag;
	}

	/**
	 * �����ؼ���ȡ��
	 *
	 * @return soc0304List �����ؼ���
	 */
	public List<SOC0304Info> getSoc0304List() {
		return soc0304List;
	}

	/**
	 * �����ؼ����趨
	 *
	 * @param soc0304List �����ؼ���
	 */
	public void setSoc0304List(List<SOC0304Info> soc0304List) {
		this.soc0304List = soc0304List;
	}

	
	
}
