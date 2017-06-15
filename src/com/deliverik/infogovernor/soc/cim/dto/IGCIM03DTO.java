/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.cim.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.SOC0137Info;
import com.deliverik.framework.soc.asset.model.SOC0103Info;
import com.deliverik.framework.soc.asset.model.SOC0104Info;
import com.deliverik.framework.soc.asset.model.SOC0105Info;
import com.deliverik.framework.soc.asset.model.SOC0123Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0128Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0103SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0104SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0301Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0302Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0303Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0305Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0306Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0307Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0308Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0309Form;

/**
 * ����: �ʲ����ҵ����DTO
 * ��������: �ʲ����ҵ����DTO
 * ������¼: 2111/04/25
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGCIM03DTO extends BaseDTO implements Serializable {

	/**
	 * ���ʻ���Ϣ
	 */
	protected Locale locale;

	/** ��ƿ���̨��ʾFORM */
	protected IGCIM0301Form igcim0301Form;

	/** ��ƶԱȽ��FORM */
	protected IGCIM0302Form igcim0302Form;
	
	/** ��ƿ���̨����鿴FORM */
	protected IGCIM0303Form igcim0303Form;
	
	/** �������Ǽ�/�޸�FORM */
	protected IGCIM0305Form igcim0305Form;
	
	/** ������������תFORM */
	protected IGCIM0306Form igcim0306Form;
	
	/** ����������FORM */
	protected IGCIM0307Form igcim0307Form;
	
	/** �豸��ϢFORM */
	protected IGCIM0308Form igcim0308Form;
	
	/** �豸��ϸ��ϢFORM */
	protected IGCIM0309Form igcim0309Form;
	
	/** ���������Ϣ */
	protected SOC0104Info auditTaskInfo;
	
	/** �豸������� */
	protected List<SOC0124Info> entityItemVWInfoList;
	
	/** �豸��Ϣ�������� */
	protected SOC0124SearchCond entityItemVWSearchCond;
	
	/** �豸��Ϣ */
	protected SOC0124Info entityItemVWInfo;
	
	/** ��Ӱ����豸��Ϣ */
	protected Map<String,List<SOC0123Info>> entityItemVWInfoMap;
	
	/** �豸������������ */
	protected String eiorgname;
	
	/** Ȩ�ޱ�ʶ */
	protected Boolean flag;
	
	/** �ʲ���������Ϣ������� */
	protected Map<String,List<SOC0129Info>> configItemVWInfoMap;
	
	/** �ʲ��汾�б� */
	protected List<SOC0128Info> configItemVersionTime;
	
	/** ���������� */
	protected int maxSearchCount;

	/** ��ҳ��DTO */
	protected PagingDTO pagingDto;
	
	/** ��������ѯ�����ӿ� */
	protected SOC0104SearchCond auditTaskSearchCond;
	
	/** ������������� */
	protected List<SOC0104Info> auditTaskInfoList;
	
	/** ��ƿ���̨�����б� */
	protected List<SOC0105Info> auditWaitTaskList;
	
	/** ��ƿ���̨���� */
	protected SOC0105Info auditWaitTask;
	
	/** �û���Ϣ */
	protected User user;
	
	/** ��ƶԱȽ����ѯ�ӿ� */
	protected SOC0103SearchCond auditResultSearchCond;
	
	/** ��ƶԱȽ��������� */
	protected List<SOC0103Info> auditResultList;
	
	/** ����Ķ���IC���Ƽ��� */
	protected Map<Integer, String> ICNameMap;
	
	/** ��ƶԱȽ��������� */
	protected List<SOC0137Info> auditResultOneInfoList;
	
	public List<SOC0137Info> getAuditResultOneInfoList() {
		return auditResultOneInfoList;
	}
	
	public void setAuditResultOneInfoList(
			List<SOC0137Info> auditResultOneInfoList) {
		this.auditResultOneInfoList = auditResultOneInfoList;
	}
	
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
	 * ���ʻ���Ϣȡ��
	 * 
	 * @return ���ʻ���Ϣ
	 */
	public Locale getLocale() {
		return locale;
	}

	/**
	 * ���ʻ���Ϣ����
	 * 
	 * @param locale���ʻ���Ϣ
	 */
	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	/**
	 * ��ƿ���̨��ʾFORMȡ��
	 * 
	 * @return ��ƿ���̨��ʾFORM
	 */
	public IGCIM0301Form getIgcim0301Form() {
		return igcim0301Form;
	}
	
	/**
	 * ��ƿ���̨����鿴FORMȡ��
	 * 
	 * @return ��ƿ���̨����鿴FORM
	 */
	public IGCIM0303Form getIgcim0303Form() {
		return igcim0303Form;
	}
	
	
	/**
	 * ��ƿ���̨����鿴FORM�趨
	 * 
	 * @param igcim0303Form ��ƿ���̨����鿴FORM
	 */
	public void setIgcim0303Form(IGCIM0303Form igcim0303Form) {
		this.igcim0303Form = igcim0303Form;
	}
	/**
	 * ��ƿ���̨��ʾFORM�趨
	 * 
	 * @param igcim0301Form ��ƿ���̨��ʾFORM
	 */
	public void setIgcim0301Form(IGCIM0301Form igcim0301Form) {
		this.igcim0301Form = igcim0301Form;
	}

	/**
	 * ��ƿ���̨�����б�
	 * 
	 * @return ��ƿ���̨�����б�ȡ��
	 */
	public List<SOC0105Info> getAuditWaitTaskList() {
		return auditWaitTaskList;
	}

	/**
	 * ��ƿ���̨�����б��趨
	 * 
	 * @param auditWaitTaskList ��ƿ���̨�����б�
	 */
	public void setAuditWaitTaskList(List<SOC0105Info> auditWaitTaskList) {
		this.auditWaitTaskList = auditWaitTaskList;
	}
	
	/**
	 * ��ƿ���̨����ȡ��
	 * 
	 * @return ��ƿ���̨����
	 */
	public SOC0105Info getAuditWaitTask() {
		return auditWaitTask;
	}

	/**
	 * ��ƿ���̨�����趨
	 * 
	 * @param auditWaitTask ��ƿ���̨����
	 */
	public void setAuditWaitTask(SOC0105Info auditWaitTask) {
		this.auditWaitTask = auditWaitTask;
	}
	
	/**
	 * ��ƶԱȽ����ѯ�ӿ�ȡ��
	 * @return ��ƶԱȽ����ѯ�ӿ�
	 */
	public SOC0103SearchCond getAuditResultSearchCond() {
		return auditResultSearchCond;
	}
	
	/**
	 * ��ƶԱȽ����ѯ�ӿ��趨
	 * @param auditResultSearchCond ��ƶԱȽ����ѯ�ӿ�
	 */
	public void setAuditResultSearchCond(SOC0103SearchCond auditResultSearchCond) {
		this.auditResultSearchCond = auditResultSearchCond;
	}

	/**
	 * ��ƶԱȽ���������ȡ��
	 * @return ��ƶԱȽ���������
	 */
	public List<SOC0103Info> getAuditResultList() {
		return auditResultList;
	}

	/**
	 * ��ƶԱȽ�������������
	 * @param auditResultList ��ƶԱȽ���������
	 */
	public void setAuditResultList(List<SOC0103Info> auditResultList) {
		this.auditResultList = auditResultList;
	}
	
	/**
	 * ��ƶԱȽ��FORMȡ��
	 * @return ��ƶԱȽ��FORM
	 */
	public IGCIM0302Form getIgcim0302Form() {
		return igcim0302Form;
	}
	
	/**
	 * ��ƶԱȽ��FORM�趨
	 * @param igcim0302Form ��ƶԱȽ��FORM
	 */
	public void setIgcim0302Form(IGCIM0302Form igcim0302Form) {
		this.igcim0302Form = igcim0302Form;
	}
	/**
	 * �������Ǽ�/�޸�FORMȡ��
	 * @return �������Ǽ�/�޸�FORM
	 */
	public IGCIM0305Form getIgcim0305Form() {
		return igcim0305Form;
	}
	/**
	 * �������Ǽ�/�޸�FORM�趨
	 * @param igcim0305Form�������Ǽ�/�޸�FORM
	 */
	public void setIgcim0305Form(IGCIM0305Form igcim0305Form) {
		this.igcim0305Form = igcim0305Form;
	}
	/**
	 * ������������תFORMȡ��
	 * @return ������������תFORM
	 */
	public IGCIM0306Form getIgcim0306Form() {
		return igcim0306Form;
	}
	/**
	 *  ������������תFORM�趨
	 * @param igcim0306Form������������תFORM
	 */
	public void setIgcim0306Form(IGCIM0306Form igcim0306Form) {
		this.igcim0306Form = igcim0306Form;
	}
	/**
	 * ����������FORMȡ��
	 * @return ����������FORM
	 */
	public IGCIM0307Form getIgcim0307Form() {
		return igcim0307Form;
	}
	/**
	 * ����������FORM�趨
	 * @param igcim0307Form����������FORM
	 */
	public void setIgcim0307Form(IGCIM0307Form igcim0307Form) {
		this.igcim0307Form = igcim0307Form;
	}
	/**
	 * ���������Ϣȡ��
	 * @return ���������Ϣ
	 */
	public SOC0104Info getAuditTaskInfo() {
		return auditTaskInfo;
	}
	/**
	 * ���������Ϣ�趨
	 * @param auditTaskInfo���������Ϣ
	 */
	public void setAuditTaskInfo(SOC0104Info auditTaskInfo) {
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
	public SOC0104SearchCond getAuditTaskSearchCond() {
		return auditTaskSearchCond;
	}
	/**
	 * ��������ѯ�����ӿ��趨
	 * @param auditTaskSearchCond��������ѯ�����ӿ�
	 */
	public void setAuditTaskSearchCond(SOC0104SearchCond auditTaskSearchCond) {
		this.auditTaskSearchCond = auditTaskSearchCond;
	}
	
	/**
	 * �������������ȡ��
	 * @return �������������
	 */
	public List<SOC0104Info> getAuditTaskInfoList() {
		return auditTaskInfoList;
	}

	/**
	 * ��������������趨
	 * @param auditTaskInfoList�������������
	 */
	public void setAuditTaskInfoList(List<SOC0104Info> auditTaskInfoList) {
		this.auditTaskInfoList = auditTaskInfoList;
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
	/**
	 * �豸��ϸ��ϢFORMȡ��
	 * @return �豸��ϸ��ϢFORM
	 */
	public IGCIM0309Form getIgcim0309Form() {
		return igcim0309Form;
	}
	/**
	 * �豸��ϸ��ϢFORM�趨
	 * @param igcim0309Form�豸��ϸ��ϢFORM
	 */
	public void setIgcim0309Form(IGCIM0309Form igcim0309Form) {
		this.igcim0309Form = igcim0309Form;
	}
	
	/**
	 * �豸��Ϣȡ��
	 * @return �豸��Ϣ
	 */
	public SOC0124Info getEntityItemVWInfo() {
		return entityItemVWInfo;
	}

	/**
	 * �豸��Ϣ�趨
	 * @param �豸��Ϣ
	 */
	public void setEntityItemVWInfo(SOC0124Info entityItemVWInfo) {
		this.entityItemVWInfo = entityItemVWInfo;
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
	 * @param configItemVersionTime�ʲ��汾�б�
	 */
	public void setConfigItemVersionTime(
			List<SOC0128Info> configItemVersionTime) {
		this.configItemVersionTime = configItemVersionTime;
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
	 * @param configItemVWInfoMap�ʲ���������Ϣ�������
	 */
	public void setConfigItemVWInfoMap(
			Map<String, List<SOC0129Info>> configItemVWInfoMap) {
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
	public IGCIM0308Form getIgcim0308Form() {
		return igcim0308Form;
	}
	/**
	 * �豸��ϢFORM�趨
	 * @param igcim0308Form�豸��ϢFORM
	 */
	public void setIgcim0308Form(IGCIM0308Form igcim0308Form) {
		this.igcim0308Form = igcim0308Form;
	}

	/**
	 * ��Ӱ����豸��Ϣȡ��
	 * @return ��Ӱ����豸��Ϣ
	 */
	public Map<String, List<SOC0123Info>> getEntityItemVWInfoMap() {
		return entityItemVWInfoMap;
	}
	
	/**
	 * ��Ӱ����豸��Ϣ�趨
	 * @param ��Ӱ����豸��Ϣ
	 */
	public void setEntityItemVWInfoMap(
			Map<String, List<SOC0123Info>> entityItemVWInfoMap) {
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
