/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.asset.model.AuditResultInfo;
import com.deliverik.framework.asset.model.AuditTaskInfo;
import com.deliverik.framework.asset.model.AuditWaitTaskInfo;
import com.deliverik.framework.asset.model.IG002Info;
import com.deliverik.framework.asset.model.IG887Info;
import com.deliverik.framework.asset.model.IG749Info;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.asset.model.condition.AuditResultSearchCond;
import com.deliverik.framework.asset.model.condition.AuditTaskSearchCond;
import com.deliverik.framework.asset.model.condition.IG688SearchCond;
import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.asset.form.IGASM2101Form;
import com.deliverik.infogovernor.asset.form.IGASM2102Form;
import com.deliverik.infogovernor.asset.form.IGASM2103Form;
import com.deliverik.infogovernor.asset.form.IGASM2105Form;
import com.deliverik.infogovernor.asset.form.IGASM2106Form;
import com.deliverik.infogovernor.asset.form.IGASM2107Form;
import com.deliverik.infogovernor.asset.form.IGASM2108Form;
import com.deliverik.infogovernor.asset.form.IGASM2109Form;

/**
 * ����: �ʲ����ҵ����DTO
 * ��������: �ʲ����ҵ����DTO
 * ������¼: 2111/04/25
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGASM21DTO extends BaseDTO implements Serializable {

	/** ��ƿ���̨��ʾFORM */
	protected IGASM2101Form igasm2101Form;

	/** ��ƶԱȽ��FORM */
	protected IGASM2102Form igasm2102Form;
	
	/** ��ƿ���̨����鿴FORM */
	protected IGASM2103Form igasm2103Form;
	
	/** �������Ǽ�/�޸�FORM */
	protected IGASM2105Form igasm2105Form;
	
	/** ������������תFORM */
	protected IGASM2106Form igasm2106Form;
	
	/** ����������FORM */
	protected IGASM2107Form igasm2107Form;
	
	/** �豸��ϢFORM */
	protected IGASM2108Form igasm2108Form;
	
	/** �豸��ϸ��ϢFORM */
	protected IGASM2109Form igasm2109Form;
	
	/** ���������Ϣ */
	protected AuditTaskInfo auditTaskInfo;
	
	/** �豸������� */
	protected List<IG688Info> entityItemVWInfoList;
	
	/** �豸��Ϣ�������� */
	protected IG688SearchCond entityItemVWSearchCond;
	
	/** �豸��Ϣ */
	protected IG688Info entityItemVWInfo;
	
	/** ��Ӱ����豸��Ϣ */
	protected Map<String,List<IG749Info>> entityItemVWInfoMap;
	
	/** �豸������������ */
	protected String eiorgname;
	
	/** Ȩ�ޱ�ʶ */
	protected Boolean flag;
	
	/** �ʲ���������Ϣ������� */
	protected Map<String,List<IG002Info>> configItemVWInfoMap;
	
	/** �ʲ��汾�б� */
	protected List<IG887Info> configItemVersionTime;
	
	/** ���������� */
	protected int maxSearchCount;

	/** ��ҳ��DTO */
	protected PagingDTO pagingDto;
	
	/** ��������ѯ�����ӿ� */
	protected AuditTaskSearchCond auditTaskSearchCond;
	
	/** ������������� */
	protected List<AuditTaskInfo> auditTaskInfoList;
	
	/** ��ƿ���̨�����б� */
	protected List<AuditWaitTaskInfo> auditWaitTaskList;
	
	/** ��ƿ���̨���� */
	protected AuditWaitTaskInfo auditWaitTask;
	
	/** �û���Ϣ */
	protected User user;
	
	/** ��ƶԱȽ����ѯ�ӿ� */
	protected AuditResultSearchCond auditResultSearchCond;
	
	/** ��ƶԱȽ��������� */
	protected List<AuditResultInfo> auditResultList;
	
	/** ����Ķ���IC���Ƽ��� */
	protected Map<Integer, String> ICNameMap;
	
	/**
	 * �û���Ϣȡ��
	 * 
	 * @return �û���Ϣ
	 */
	public User getUser() {
		return user;
	}
	/**
	 * �û���Ϣ����
	 * 
	 * @param User �û���Ϣ 
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * ��ƿ���̨��ʾFORMȡ��
	 * 
	 * @return ��ƿ���̨��ʾFORM
	 */
	public IGASM2101Form getIgasm2101Form() {
		return igasm2101Form;
	}
	
	/**
	 * ��ƿ���̨����鿴FORMȡ��
	 * 
	 * @return ��ƿ���̨����鿴FORM
	 */
	public IGASM2103Form getIgasm2103Form() {
		return igasm2103Form;
	}
	
	
	/**
	 * ��ƿ���̨����鿴FORM�趨
	 * 
	 * @param igasm2103Form ��ƿ���̨����鿴FORM
	 */
	public void setIgasm2103Form(IGASM2103Form igasm2103Form) {
		this.igasm2103Form = igasm2103Form;
	}
	/**
	 * ��ƿ���̨��ʾFORM�趨
	 * 
	 * @param igasm2101Form ��ƿ���̨��ʾFORM
	 */
	public void setIgasm2101Form(IGASM2101Form igasm2101Form) {
		this.igasm2101Form = igasm2101Form;
	}

	/**
	 * ��ƿ���̨�����б�
	 * 
	 * @return ��ƿ���̨�����б�ȡ��
	 */
	public List<AuditWaitTaskInfo> getAuditWaitTaskList() {
		return auditWaitTaskList;
	}

	/**
	 * ��ƿ���̨�����б��趨
	 * 
	 * @param auditWaitTaskList ��ƿ���̨�����б�
	 */
	public void setAuditWaitTaskList(List<AuditWaitTaskInfo> auditWaitTaskList) {
		this.auditWaitTaskList = auditWaitTaskList;
	}
	
	/**
	 * ��ƿ���̨����ȡ��
	 * 
	 * @return ��ƿ���̨����
	 */
	public AuditWaitTaskInfo getAuditWaitTask() {
		return auditWaitTask;
	}

	/**
	 * ��ƿ���̨�����趨
	 * 
	 * @param auditWaitTask ��ƿ���̨����
	 */
	public void setAuditWaitTask(AuditWaitTaskInfo auditWaitTask) {
		this.auditWaitTask = auditWaitTask;
	}
	
	/**
	 * ��ƶԱȽ����ѯ�ӿ�ȡ��
	 * @return ��ƶԱȽ����ѯ�ӿ�
	 */
	public AuditResultSearchCond getAuditResultSearchCond() {
		return auditResultSearchCond;
	}
	
	/**
	 * ��ƶԱȽ����ѯ�ӿ��趨
	 * @param auditResultSearchCond ��ƶԱȽ����ѯ�ӿ�
	 */
	public void setAuditResultSearchCond(AuditResultSearchCond auditResultSearchCond) {
		this.auditResultSearchCond = auditResultSearchCond;
	}

	/**
	 * ��ƶԱȽ���������ȡ��
	 * @return ��ƶԱȽ���������
	 */
	public List<AuditResultInfo> getAuditResultList() {
		return auditResultList;
	}

	/**
	 * ��ƶԱȽ�������������
	 * @param auditResultList ��ƶԱȽ���������
	 */
	public void setAuditResultList(List<AuditResultInfo> auditResultList) {
		this.auditResultList = auditResultList;
	}
	
	/**
	 * ��ƶԱȽ��FORMȡ��
	 * @return ��ƶԱȽ��FORM
	 */
	public IGASM2102Form getIgasm2102Form() {
		return igasm2102Form;
	}
	
	/**
	 * ��ƶԱȽ��FORM�趨
	 * @param igasm2102Form ��ƶԱȽ��FORM
	 */
	public void setIgasm2102Form(IGASM2102Form igasm2102Form) {
		this.igasm2102Form = igasm2102Form;
	}
	/**
	 * �������Ǽ�/�޸�FORMȡ��
	 * @return �������Ǽ�/�޸�FORM
	 */
	public IGASM2105Form getIgasm2105Form() {
		return igasm2105Form;
	}
	/**
	 * �������Ǽ�/�޸�FORM�趨
	 * @param igasm2105Form�������Ǽ�/�޸�FORM
	 */
	public void setIgasm2105Form(IGASM2105Form igasm2105Form) {
		this.igasm2105Form = igasm2105Form;
	}
	/**
	 * ������������תFORMȡ��
	 * @return ������������תFORM
	 */
	public IGASM2106Form getIgasm2106Form() {
		return igasm2106Form;
	}
	/**
	 *  ������������תFORM�趨
	 * @param igasm2106Form������������תFORM
	 */
	public void setIgasm2106Form(IGASM2106Form igasm2106Form) {
		this.igasm2106Form = igasm2106Form;
	}
	/**
	 * ����������FORMȡ��
	 * @return ����������FORM
	 */
	public IGASM2107Form getIgasm2107Form() {
		return igasm2107Form;
	}
	/**
	 * ����������FORM�趨
	 * @param igasm2107Form����������FORM
	 */
	public void setIgasm2107Form(IGASM2107Form igasm2107Form) {
		this.igasm2107Form = igasm2107Form;
	}
	/**
	 * ���������Ϣȡ��
	 * @return ���������Ϣ
	 */
	public AuditTaskInfo getAuditTaskInfo() {
		return auditTaskInfo;
	}
	/**
	 * ���������Ϣ�趨
	 * @param auditTaskInfo���������Ϣ
	 */
	public void setAuditTaskInfo(AuditTaskInfo auditTaskInfo) {
		this.auditTaskInfo = auditTaskInfo;
	}
	
	/**
	 * ����������ȡ��
	 * 
	 * @return ����������
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * �����������趨
	 * 
	 * @param maxSearchCount����������
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * ��ҳ��DTOȡ��
	 * 
	 * @return ��ҳ��DTO
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * ��ҳ��DTO�趨
	 * 
	 * @param pagingDto��ҳ��DTO
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}
	/**
	 * ��������ѯ�����ӿ�ȡ��
	 * @return ��������ѯ�����ӿ�
	 */
	public AuditTaskSearchCond getAuditTaskSearchCond() {
		return auditTaskSearchCond;
	}
	/**
	 * ��������ѯ�����ӿ��趨
	 * @param auditTaskSearchCond��������ѯ�����ӿ�
	 */
	public void setAuditTaskSearchCond(AuditTaskSearchCond auditTaskSearchCond) {
		this.auditTaskSearchCond = auditTaskSearchCond;
	}
	
	/**
	 * �������������ȡ��
	 * @return �������������
	 */
	public List<AuditTaskInfo> getAuditTaskInfoList() {
		return auditTaskInfoList;
	}

	/**
	 * ��������������趨
	 * @param auditTaskInfoList�������������
	 */
	public void setAuditTaskInfoList(List<AuditTaskInfo> auditTaskInfoList) {
		this.auditTaskInfoList = auditTaskInfoList;
	}
	
	/**
	 * �豸�������ȡ��
	 * @return �豸�������
	 */
	public List<IG688Info> getEntityItemVWInfoList() {
		return entityItemVWInfoList;
	}

	/**
	 * �豸��������趨
	 *
	 * @param entityItemVWInfoList �豸�������
	 */
	public void setEntityItemVWInfoList(List<IG688Info> entityItemVWInfoList) {
		this.entityItemVWInfoList = entityItemVWInfoList;
	}
	
	/**
	 * �豸��Ϣ��������ȡ��
	 * @return �豸��Ϣ��������
	 */
	public IG688SearchCond getEntityItemVWSearchCond() {
		return entityItemVWSearchCond;
	}

	/**
	 * �豸��Ϣ���������趨
	 *
	 * @param entityItemVWSearchCond �豸��Ϣ��������
	 */
	public void setEntityItemVWSearchCond(
			IG688SearchCond entityItemVWSearchCond) {
		this.entityItemVWSearchCond = entityItemVWSearchCond;
	}
	/**
	 * �豸��ϸ��ϢFORMȡ��
	 * @return �豸��ϸ��ϢFORM
	 */
	public IGASM2109Form getIgasm2109Form() {
		return igasm2109Form;
	}
	/**
	 * �豸��ϸ��ϢFORM�趨
	 * @param igasm2109Form�豸��ϸ��ϢFORM
	 */
	public void setIgasm2109Form(IGASM2109Form igasm2109Form) {
		this.igasm2109Form = igasm2109Form;
	}
	
	/**
	 * �豸��Ϣȡ��
	 * @return �豸��Ϣ
	 */
	public IG688Info getEntityItemVWInfo() {
		return entityItemVWInfo;
	}

	/**
	 * �豸��Ϣ�趨
	 * @param �豸��Ϣ
	 */
	public void setEntityItemVWInfo(IG688Info entityItemVWInfo) {
		this.entityItemVWInfo = entityItemVWInfo;
	}

	/**
	 * �ʲ��汾�б�ȡ��
	 * @return �ʲ��汾�б�
	 */
	public List<IG887Info> getConfigItemVersionTime() {
		return configItemVersionTime;
	}

	/**
	 * �ʲ��汾�б��趨
	 * @param configItemVersionTime�ʲ��汾�б�
	 */
	public void setConfigItemVersionTime(
			List<IG887Info> configItemVersionTime) {
		this.configItemVersionTime = configItemVersionTime;
	}

	/**
	 * �ʲ���������Ϣ�������ȡ��
	 * @return �ʲ���������Ϣ�������
	 */
	public Map<String, List<IG002Info>> getConfigItemVWInfoMap() {
		return configItemVWInfoMap;
	}

	/**
	 * �ʲ���������Ϣ��������趨
	 * @param configItemVWInfoMap�ʲ���������Ϣ�������
	 */
	public void setConfigItemVWInfoMap(
			Map<String, List<IG002Info>> configItemVWInfoMap) {
		this.configItemVWInfoMap = configItemVWInfoMap;
	}

	/**
	 * �豸������������ȡ��
	 * @return �豸������������
	 */
	public String getEiorgname() {
		return eiorgname;
	}

	/**
	 * �豸�������������趨
	 * @param eiorgname�豸������������
	 */
	public void setEiorgname(String eiorgname) {
		this.eiorgname = eiorgname;
	}

	/**
	 * Ȩ�ޱ�ʶȡ��
	 * @return Ȩ�ޱ�ʶ
	 */
	public Boolean getFlag() {
		return flag;
	}

	/**
	 * Ȩ�ޱ�ʶ�趨
	 * @param flagȨ�ޱ�ʶ
	 */
	public void setFlag(Boolean flag) {
		this.flag = flag;
	}
	/**
	 * �豸��ϢFORMȡ��
	 * @return �豸��ϢFORM
	 */
	public IGASM2108Form getIgasm2108Form() {
		return igasm2108Form;
	}
	/**
	 * �豸��ϢFORM�趨
	 * @param igasm2108Form�豸��ϢFORM
	 */
	public void setIgasm2108Form(IGASM2108Form igasm2108Form) {
		this.igasm2108Form = igasm2108Form;
	}

	/**
	 * ��Ӱ����豸��Ϣȡ��
	 * @return ��Ӱ����豸��Ϣ
	 */
	public Map<String, List<IG749Info>> getEntityItemVWInfoMap() {
		return entityItemVWInfoMap;
	}
	
	/**
	 * ��Ӱ����豸��Ϣ�趨
	 * @param ��Ӱ����豸��Ϣ
	 */
	public void setEntityItemVWInfoMap(
			Map<String, List<IG749Info>> entityItemVWInfoMap) {
		this.entityItemVWInfoMap = entityItemVWInfoMap;
	}
	
	/**
	 * ����Ķ���IC���Ƽ���ȡ��
	 * @return ����Ķ���IC���Ƽ���
	 */
	public Map<Integer, String> getICNameMap() {
		return ICNameMap;
	}
	
	/**
	 * ����Ķ���IC���Ƽ����趨
	 * @param nameMap ����Ķ���IC���Ƽ���
	 */
	public void setICNameMap(Map<Integer, String> nameMap) {
		ICNameMap = nameMap;
	}
	
	
}
