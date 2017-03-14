/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.asset.model.CIResultInfo;
import com.deliverik.framework.asset.model.CITaskInfo;
import com.deliverik.framework.asset.model.CIWaitTaskInfo;
import com.deliverik.framework.asset.model.IG002Info;
import com.deliverik.framework.asset.model.IG887Info;
import com.deliverik.framework.asset.model.IG749Info;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.asset.model.condition.CIResultSearchCond;
import com.deliverik.framework.asset.model.condition.CITaskSearchCond;
import com.deliverik.framework.asset.model.condition.IG688SearchCond;
import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.asset.form.IGASM2201Form;
import com.deliverik.infogovernor.asset.form.IGASM2202Form;
import com.deliverik.infogovernor.asset.form.IGASM2203Form;
import com.deliverik.infogovernor.asset.form.IGASM2205Form;
import com.deliverik.infogovernor.asset.form.IGASM2206Form;
import com.deliverik.infogovernor.asset.form.IGASM2207Form;
import com.deliverik.infogovernor.asset.form.IGASM2208Form;
import com.deliverik.infogovernor.asset.form.IGASM2209Form;

/**
 * ����: �ʲ�CI���ҵ����DTO
 * ��������: �ʲ�CI���ҵ����DTO
 * ������¼: 2211/04/25
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGASM22DTO extends BaseDTO implements Serializable {


	/** CI�������̨��ʾFORM */
	protected IGASM2201Form igasm2201Form;

	/** CI����ԱȽ��FORM */
	protected IGASM2202Form igasm2202Form;
	
	/** CI�������̨����鿴FORM */
	protected IGASM2203Form igasm2203Form;
	
	/** CI�������Ǽ�/�޸�FORM */
	protected IGASM2205Form igasm2205Form;
	
	/** CI������������תFORM */
	protected IGASM2206Form igasm2206Form;
	
	/** CI����������FORM */
	protected IGASM2207Form igasm2207Form;
	
	/** �豸��ϢFORM */
	protected IGASM2208Form igasm2208Form;
	
	/** �豸��ϸ��ϢFORM */
	protected IGASM2209Form igasm2209Form;
	
	/** CI���������Ϣ */
	protected CITaskInfo ciTaskInfo;
	
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
	
	/** CI��������ѯ�����ӿ� */
	protected CITaskSearchCond ciTaskSearchCond;
	
	/** CI������������� */
	protected List<CITaskInfo> ciTaskInfoList;
	
	/** CI�������̨�����б� */
	protected List<CIWaitTaskInfo> ciWaitTaskList;
	
	/** CI�������̨���� */
	protected CIWaitTaskInfo ciWaitTask;
	
	/** �û���Ϣ */
	protected User user;
	
	/** CI����ԱȽ����ѯ�ӿ� */
	protected CIResultSearchCond ciResultSearchCond;
	
	/** CI����ԱȽ��������� */
	protected List<CIResultInfo> ciResultList;
	
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
	 * CI�������̨��ʾFORMȡ��
	 * 
	 * @return CI�������̨��ʾFORM
	 */
	public IGASM2201Form getIgasm2201Form() {
		return igasm2201Form;
	}
	
	/**
	 * CI�������̨����鿴FORMȡ��
	 * 
	 * @return CI�������̨����鿴FORM
	 */
	public IGASM2203Form getIgasm2203Form() {
		return igasm2203Form;
	}
	
	
	/**
	 * CI�������̨����鿴FORM�趨
	 * 
	 * @param igasm2203Form CI�������̨����鿴FORM
	 */
	public void setIgasm2203Form(IGASM2203Form igasm2203Form) {
		this.igasm2203Form = igasm2203Form;
	}
	/**
	 * CI�������̨��ʾFORM�趨
	 * 
	 * @param igasm2201Form CI�������̨��ʾFORM
	 */
	public void setIgasm2201Form(IGASM2201Form igasm2201Form) {
		this.igasm2201Form = igasm2201Form;
	}

	/**
	 * CI�������̨�����б�
	 * 
	 * @return CI�������̨�����б�ȡ��
	 */
	public List<CIWaitTaskInfo> getCiWaitTaskList() {
		return ciWaitTaskList;
	}

	/**
	 * CI�������̨�����б��趨
	 * 
	 * @param ciWaitTaskList CI�������̨�����б�
	 */
	public void setCiWaitTaskList(List<CIWaitTaskInfo> ciWaitTaskList) {
		this.ciWaitTaskList = ciWaitTaskList;
	}
	
	/**
	 * CI�������̨����ȡ��
	 * 
	 * @return CI�������̨����
	 */
	public CIWaitTaskInfo getCiWaitTask() {
		return ciWaitTask;
	}

	/**
	 * CI�������̨�����趨
	 * 
	 * @param ciWaitTask CI�������̨����
	 */
	public void setCiWaitTask(CIWaitTaskInfo ciWaitTask) {
		this.ciWaitTask = ciWaitTask;
	}
	
	/**
	 * CI����ԱȽ����ѯ�ӿ�ȡ��
	 * @return CI����ԱȽ����ѯ�ӿ�
	 */
	public CIResultSearchCond getCiResultSearchCond() {
		return ciResultSearchCond;
	}
	
	/**
	 * CI����ԱȽ����ѯ�ӿ��趨
	 * @param ciResultSearchCond CI����ԱȽ����ѯ�ӿ�
	 */
	public void setCiResultSearchCond(CIResultSearchCond ciResultSearchCond) {
		this.ciResultSearchCond = ciResultSearchCond;
	}

	/**
	 * CI����ԱȽ���������ȡ��
	 * @return CI����ԱȽ���������
	 */
	public List<CIResultInfo> getCiResultList() {
		return ciResultList;
	}

	/**
	 * CI����ԱȽ�������������
	 * @param ciResultList CI����ԱȽ���������
	 */
	public void setCiResultList(List<CIResultInfo> ciResultList) {
		this.ciResultList = ciResultList;
	}
	
	/**
	 * CI����ԱȽ��FORMȡ��
	 * @return CI����ԱȽ��FORM
	 */
	public IGASM2202Form getIgasm2202Form() {
		return igasm2202Form;
	}
	
	/**
	 * CI����ԱȽ��FORM�趨
	 * @param igasm2202Form CI����ԱȽ��FORM
	 */
	public void setIgasm2202Form(IGASM2202Form igasm2202Form) {
		this.igasm2202Form = igasm2202Form;
	}
	/**
	 * CI�������Ǽ�/�޸�FORMȡ��
	 * @return CI�������Ǽ�/�޸�FORM
	 */
	public IGASM2205Form getIgasm2205Form() {
		return igasm2205Form;
	}
	/**
	 * CI�������Ǽ�/�޸�FORM�趨
	 * @param igasm2205FormCI�������Ǽ�/�޸�FORM
	 */
	public void setIgasm2205Form(IGASM2205Form igasm2205Form) {
		this.igasm2205Form = igasm2205Form;
	}
	/**
	 * CI������������תFORMȡ��
	 * @return CI������������תFORM
	 */
	public IGASM2206Form getIgasm2206Form() {
		return igasm2206Form;
	}
	/**
	 *  CI������������תFORM�趨
	 * @param igasm2206FormCI������������תFORM
	 */
	public void setIgasm2206Form(IGASM2206Form igasm2206Form) {
		this.igasm2206Form = igasm2206Form;
	}
	/**
	 * CI����������FORMȡ��
	 * @return CI����������FORM
	 */
	public IGASM2207Form getIgasm2207Form() {
		return igasm2207Form;
	}
	/**
	 * CI����������FORM�趨
	 * @param igasm2207FormCI����������FORM
	 */
	public void setIgasm2207Form(IGASM2207Form igasm2207Form) {
		this.igasm2207Form = igasm2207Form;
	}
	/**
	 * CI���������Ϣȡ��
	 * @return CI���������Ϣ
	 */
	public CITaskInfo getCiTaskInfo() {
		return ciTaskInfo;
	}
	/**
	 * CI���������Ϣ�趨
	 * @param ciTaskInfoCI���������Ϣ
	 */
	public void setCiTaskInfo(CITaskInfo ciTaskInfo) {
		this.ciTaskInfo = ciTaskInfo;
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
	 * CI��������ѯ�����ӿ�ȡ��
	 * @return CI��������ѯ�����ӿ�
	 */
	public CITaskSearchCond getCiTaskSearchCond() {
		return ciTaskSearchCond;
	}
	/**
	 * CI��������ѯ�����ӿ��趨
	 * @param ciTaskSearchCondCI��������ѯ�����ӿ�
	 */
	public void setCiTaskSearchCond(CITaskSearchCond ciTaskSearchCond) {
		this.ciTaskSearchCond = ciTaskSearchCond;
	}
	
	/**
	 * CI�������������ȡ��
	 * @return CI�������������
	 */
	public List<CITaskInfo> getCiTaskInfoList() {
		return ciTaskInfoList;
	}

	/**
	 * CI��������������趨
	 * @param ciTaskInfoListCI�������������
	 */
	public void setCiTaskInfoList(List<CITaskInfo> ciTaskInfoList) {
		this.ciTaskInfoList = ciTaskInfoList;
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
	public IGASM2209Form getIgasm2209Form() {
		return igasm2209Form;
	}
	/**
	 * �豸��ϸ��ϢFORM�趨
	 * @param igasm2209Form�豸��ϸ��ϢFORM
	 */
	public void setIgasm2209Form(IGASM2209Form igasm2209Form) {
		this.igasm2209Form = igasm2209Form;
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
	public IGASM2208Form getIgasm2208Form() {
		return igasm2208Form;
	}
	/**
	 * �豸��ϢFORM�趨
	 * @param igasm2208Form�豸��ϢFORM
	 */
	public void setIgasm2208Form(IGASM2208Form igasm2208Form) {
		this.igasm2208Form = igasm2208Form;
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
