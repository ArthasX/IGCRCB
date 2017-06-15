/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.cim.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.SOC0136Info;
import com.deliverik.framework.soc.asset.SOC0138Info;
import com.deliverik.framework.soc.asset.model.SOC0111Info;
import com.deliverik.framework.soc.asset.model.SOC0113Info;
import com.deliverik.framework.soc.asset.model.SOC0115Info;
import com.deliverik.framework.soc.asset.model.SOC0120Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0111SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0120SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0126SearchCond;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0201Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0202Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0203Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0205Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0206Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0207Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0210Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0212Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0213Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0802Form;
import com.deliverik.infogovernor.soc.model.CR03Info;
import com.deliverik.infogovernor.soc.model.CR03VWInfo;
/**
 * ����: �ʲ�����ҵ����DTO
 * ��������: �ʲ�����ҵ����DTO
 * ������¼: 2011/04/25
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGCIM02DTO extends BaseDTO implements Serializable {

	/**
	 * �ʲ��������������ӿ�
	 */
	protected SOC0111SearchCond eiDomainDefSearchCond;
	
	/**
	 * �ʲ�����ϸ����������ӿ�
	 */
	protected SOC0126SearchCond eiDomainDetailVWSearchCond;
	
	/**
	 * ����������������ӿ�
	 */
	protected SOC0120SearchCond importVersionSearchCond;
	
	/**
	 * �����������
	 */
	protected List<SOC0113Info> eiImportProgrammeList;
	
	/** ����ϸ��Ϣ */
	protected List<SOC0138Info> eiDomainDetailCIOneInfoList;
	
	protected List<SOC0136Info> eiDomainDetailCIInfoList;
	
	/**
	 * ����������Ϣ
	 */
	protected List<LabelValueBean> impTypeList;
	/**
	 * ���°�����Ϣ
	 */
	protected List<LabelValueBean> domainList;
	
	/**
	 * ��ѯ����
	 */
	protected List<LabelValueBean> typeList;
	
	/**
	 * ���ʻ���Ϣ
	 */
	protected Locale locale;

	/** �ʲ�������Ϣ */
	protected IGCIM0202Form igcim0202Form;
	
	/** �ʲ�������ϸ��Ϣ */
	protected IGCIM0205Form igcim0205Form;
	
	/** ���������Ϣ */
	protected IGCIM0206Form igcim0206Form;
	

	/** ���������Ϣ */
	protected IGCIM0207Form igcim0207Form;
	
	/** �ʲ�����汾Form */
	protected IGCIM0212Form igcim0212Form;
	
	/** ��CI��ѯ������Ϣ*/
	protected IGCIM0213Form igcim0213Form;
	
	/** ������Ϣ*/
	protected IGCIM0802Form igcim0802Form;
	
	/** ���� */
	protected String deleteflag;
	
	/** ʵ���� */
	protected String impeiname;
	
	/** �汾�� */
	protected Integer impversion;

	/** ���������� */
	protected int maxSearchCount;

	/** ��ҳ��DTO */
	protected PagingDTO pagingDto;
	
	/** �ʲ����������� */
	protected SOC0111Info eiDomainDefInfo;

	/** �ʲ����������� */
	protected List<SOC0111Info> eiDomainDefInfoList;
	
	/** ������������� */
	protected List<SOC0120Info> importVersionInfoList;
	
	/** ������������� */
	protected SOC0120Info importVersionInfo;
	
	/** Ԥɾ���ʲ�������Ϣ */
	protected String[] deleteEiddid;
	
	/** Ԥɾ��������Ϣ */
	protected String[] deleteImpeiid;

	/**
	 * ����ӵ����ʲ�
	 */
	protected String[] owneiddids;

	/**
	 * δ��ӵ����ʲ�
	 */
	protected String[] eiddids;

	/** �汾�� */
	protected Integer eiddversion;

	/** eidomaindetail���� */
	protected Integer eiddid;
	
	/** ����̨��ʾFORM */
	protected IGCIM0201Form igcim0201Form;
	
	/** ����̨�����б�ci2 */
	protected List<SOC0115Info> eiWaitTaskList;
	
	
	/** ����̨��ʾFORM */
	protected IGCIM0210Form igcim0210Form;
	
	/** ����̨���� */
	protected SOC0115Info eiWaitTask;
	/** �û���Ϣ */
	protected User user;
	
	/** �ʲ�������ϸ��Ϣ */
	protected IGCIM0203Form igcim0203Form;
	
	/**�ɼ����󼯺�*/
	protected List<CR03Info> cr03InfoList;
	
	protected List<CR03VWInfo> cr03VWInfoList;
	
	protected Integer eiid;
	
	
	
	public List<CR03VWInfo> getCr03VWInfoList() {
		return cr03VWInfoList;
	}
	public void setCr03VWInfoList(List<CR03VWInfo> cr03VWInfoList) {
		this.cr03VWInfoList = cr03VWInfoList;
	}
	public Integer getEiid() {
		return eiid;
	}
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}
	public IGCIM0203Form getIgcim0203Form() {
		return igcim0203Form;
	}
	public void setIgcim0203Form(IGCIM0203Form igcim0203Form) {
		this.igcim0203Form = igcim0203Form;
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
	 * �ʲ��������������ӿ�ȡ��
	 * 
	 * @return �ʲ��������������ӿ�
	 */
	public SOC0111SearchCond getEiDomainDefSearchCond() {
		return eiDomainDefSearchCond;
	}

	/**
	 * �ʲ��������������ӿ�����
	 * 
	 * @param eiDomainDefSearchCond�ʲ��������������ӿ�
	 */
	public void setEiDomainDefSearchCond(
			SOC0111SearchCond eiDomainDefSearchCond) {
		this.eiDomainDefSearchCond = eiDomainDefSearchCond;
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
	 * �ʲ�������Ϣȡ��
	 * 
	 * @return �ʲ�������Ϣ
	 */
	public IGCIM0202Form getIgcim0202Form() {
		return igcim0202Form;
	}

	/**
	 * �ʲ�������Ϣ����
	 * 
	 * @param igcim0202Form�ʲ�������Ϣ
	 */
	public void setIgcim0202Form(IGCIM0202Form igcim0202Form) {
		this.igcim0202Form = igcim0202Form;
	}

	/**
	 * ����ӵ����ʲ�ȡ��
	 */
	public String[] getOwneiddids() {
		return owneiddids;
	}

	/**
	 * ����ӵ����ʲ�����
	 */
	public void setOwneiddids(String[] owneiddids) {
		this.owneiddids = owneiddids;
	}

	/**
	 * δ��ӵ����ʲ�ȡ��
	 */
	public String[] getEiddids() {
		return eiddids;
	}

	/**
	 * δ��ӵ����ʲ�����
	 */
	public void setEiddids(String[] eiddids) {
		this.eiddids = eiddids;
	}

	/**
	 * ����ȡ��
	 * @return ����
	 */
	public Integer getEiddid() {
		return eiddid;
	}

	/**
	 * �����趨
	 * @param eiddid����
	 */
	public void setEiddid(Integer eiddid) {
		this.eiddid = eiddid;
	}

	/**
	 * �汾��ȡ��
	 * @return �汾��
	 */
	public Integer getEiddversion() {
		return eiddversion;
	}

	/**
	 * �汾���趨
	 * @param eiddversion�汾��
	 */
	public void setEiddversion(Integer eiddversion) {
		this.eiddversion = eiddversion;
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
	 * �ʲ�����������ȡ��
	 * 
	 * @return �ʲ�����������
	 */
	public List<SOC0111Info> getEiDomainDefInfoList() {
		return eiDomainDefInfoList;
	}

	/**
	 * �ʲ������������趨
	 * 
	 * @param eiDomainDefInfoList�ʲ�����������
	 */
	public void setEiDomainDefInfoList(List<SOC0111Info> eiDomainDefInfoList) {
		this.eiDomainDefInfoList = eiDomainDefInfoList;
	}

	/**
	 * �ʲ�������ϸ��Ϣȡ��
	 * @return �ʲ�������ϸ��Ϣ
	 */
	public IGCIM0205Form getIgcim0205Form() {
		return igcim0205Form;
	}
	/**
	 * �ʲ�������ϸ��Ϣ�趨
	 * @param igcim0205Form�ʲ�������ϸ��Ϣ
	 */
	public void setIgcim0205Form(IGCIM0205Form igcim0205Form) {
		this.igcim0205Form = igcim0205Form;
	}

	/**
	 * ����̨��ʾFORMȡ��
	 * 
	 * @return ����̨��ʾFORM
	 */
	public IGCIM0201Form getIgcim0201Form() {
		return igcim0201Form;
	}

	/**
	 * ����̨��ʾFORM�趨
	 * 
	 * @param igcim0201Form ����̨��ʾFORM
	 */
	public void setIgcim0201Form(IGCIM0201Form igcim0201Form) {
		this.igcim0201Form = igcim0201Form;
	}

	/**
	 * ����̨�����б�
	 * 
	 * @return ����̨�����б�ȡ��
	 */
	public List<SOC0115Info> getEiWaitTaskList() {
		return eiWaitTaskList;
	}

	/**
	 * ����̨�����б��趨
	 * 
	 * @param eiWaitTaskList ����̨�����б�
	 */
	public void setEiWaitTaskList(List<SOC0115Info> eiWaitTaskList) {
		this.eiWaitTaskList = eiWaitTaskList;
	}
	
	/**
	 * Ԥɾ���ʲ�������Ϣȡ��
	 * @return Ԥɾ���ʲ�������Ϣ
	 */
	public String[] getDeleteEiddid() {
		return deleteEiddid;
	}

	/**
	 * Ԥɾ���ʲ�������Ϣ�趨
	 * @param deleteEiddidԤɾ���ʲ�������Ϣ
	 */
	public void setDeleteEiddid(String[] deleteEiddid) {
		this.deleteEiddid = deleteEiddid;
	}
	
	/**
	 * ���������Ϣ
	 * @return ���������Ϣ
	 */
	public IGCIM0206Form getIgcim0206Form() {
		return igcim0206Form;
	}
	
	/**
	 * ���������Ϣ
	 * @param igcim0206Form���������Ϣ
	 */
	public void setIgcim0206Form(IGCIM0206Form igcim0206Form) {
		this.igcim0206Form = igcim0206Form;
	}
	
	/**
	 * ������������� 
	 * @return ������������� 
	 */
	public List<SOC0120Info> getImportVersionInfoList() {
		return importVersionInfoList;
	}

	/**
	 * ������������� 
	 * @param importVersionInfoList������������� 
	 */
	public void setImportVersionInfoList(
			List<SOC0120Info> importVersionInfoList) {
		this.importVersionInfoList = importVersionInfoList;
	}

	/**
	 * ����������������ӿ�ȡ��
	 * @return ����������������ӿ�
	 */
	public SOC0120SearchCond getImportVersionSearchCond() {
		return importVersionSearchCond;
	}

	/**
	 * ����������������ӿ��趨
	 * @param importVersionSearchCond����������������ӿ�
	 */
	public void setImportVersionSearchCond(
			SOC0120SearchCond importVersionSearchCond) {
		this.importVersionSearchCond = importVersionSearchCond;
	}

	/**
	 * Ԥɾ��������Ϣ
	 * @return Ԥɾ��������Ϣ
	 */
	public String[] getDeleteImpeiid() {
		return deleteImpeiid;
	}

	/**
	 * Ԥɾ��������Ϣ
	 * @param deleteImpeiidԤɾ��������Ϣ
	 */
	public void setDeleteImpeiid(String[] deleteImpeiid) {
		this.deleteImpeiid = deleteImpeiid;
	}

	/**
	 * ����ȡ��
	 * @return ����
	 */
	public String getDeleteflag() {
		return deleteflag;
	}

	/**
	 * �����趨
	 * @param deleteflag����
	 */
	public void setDeleteflag(String deleteflag) {
		this.deleteflag = deleteflag;
	}

	/**
	 * ʵ����ȡ��
	 *
	 * @return ʵ����
	 */
	public String getImpeiname() {
		return impeiname;
	}

	/**
	 * ʵ�����趨
	 * @param impeinameʵ����
	 */
	public void setImpeiname(String impeiname) {
		this.impeiname = impeiname;
	}

	/**
	 * �汾��ȡ��
	 * @return �汾��
	 */
	public Integer getImpversion() {
		return impversion;
	}

	/**
	 * �汾���趨
	 * @param impversion�汾��
	 */
	public void setImpversion(Integer impversion) {
		this.impversion = impversion;
	}
	/**
	 * ���������Ϣ
	 * @return ���������Ϣ
	 */
	public IGCIM0207Form getIgcim0207Form() {
		return igcim0207Form;
	}
	/**
	 * ���������Ϣ�趨
	 * @param igcim0207Form���������Ϣ
	 */
	public void setIgcim0207Form(IGCIM0207Form igcim0207Form) {
		this.igcim0207Form = igcim0207Form;
	}

	/**
	 * ����̨��ʾFORMȡ��
	 * 
	 * @return ����̨��ʾFORM
	 */
	public IGCIM0210Form getIgcim0210Form() {
		return igcim0210Form;
	}

	/**
	 * ����̨��ʾFORM�趨
	 * 
	 * @param igcim0210Form ����̨��ʾFORM
	 */
	public void setIgcim0210Form(IGCIM0210Form igcim0210Form) {
		this.igcim0210Form = igcim0210Form;
	}

	/**
	 * ����̨����ȡ��
	 * 
	 * @return ����̨����
	 */
	public SOC0115Info getEiWaitTask() {
		return eiWaitTask;
	}

	/**
	 * ����̨�����趨
	 * 
	 * @param eiWaitTask ����̨����
	 */
	public void setEiWaitTask(SOC0115Info eiWaitTask) {
		this.eiWaitTask = eiWaitTask;
	}
	
	/**
	 * �����������ȡ��
	 * @return �����������
	 */
	public List<SOC0113Info> getEiImportProgrammeList() {
		return eiImportProgrammeList;
	}

	/**
	 * ������������趨
	 * @param eiImportProgrammeList�����������
	 */
	public void setEiImportProgrammeList(
			List<SOC0113Info> eiImportProgrammeList) {
		this.eiImportProgrammeList = eiImportProgrammeList;
	}
	
	/**
	 * �������������
	 * @return �������������
	 */
	public SOC0120Info getImportVersionInfo() {
		return importVersionInfo;
	}

	/**
	 * �������������
	 * @param importVersionInfo�������������
	 */
	public void setImportVersionInfo(SOC0120Info importVersionInfo) {
		this.importVersionInfo = importVersionInfo;
	}
	
	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public List<LabelValueBean> getImpTypeList() {
		return impTypeList;
	}
	/**
	 * ���������趨
	 * @param impTypeList��������
	 */
	public void setImpTypeList(List<LabelValueBean> impTypeList) {
		this.impTypeList = impTypeList;
	}
	/**
	 * �ʲ�����汾Formȡ��
	 * @return �ʲ�����汾Form
	 */
	public IGCIM0212Form getIgcim0212Form() {
		return igcim0212Form;
	}
	/**
	 * �ʲ�����汾Form�趨
	 * @param igcim0212Form�ʲ�����汾Form
	 */
	public void setIgcim0212Form(IGCIM0212Form igcim0212Form) {
		this.igcim0212Form = igcim0212Form;
	}
	/**
	 * �ʲ�����������ȡ��
	 * @return �ʲ�����������
	 */
	public SOC0111Info getEiDomainDefInfo() {
		return eiDomainDefInfo;
	}
	/**
	 * �ʲ������������趨
	 * @param eiDomainDefInfo�ʲ�����������
	 */
	public void setEiDomainDefInfo(SOC0111Info eiDomainDefInfo) {
		this.eiDomainDefInfo = eiDomainDefInfo;
	}
	/**
	 * ���°�����Ϣȡ��
	 * @return ���°�����Ϣ
	 */
	public List<LabelValueBean> getDomainList() {
		return domainList;
	}
	/**
	 * ���°�����Ϣ�趨
	 * @param domainList���°�����Ϣ
	 */
	public void setDomainList(List<LabelValueBean> domainList) {
		this.domainList = domainList;
	}
	
	/**
	 * ��ѯ����ȡ��
	 * @return ��ѯ����
	 */
	public List<LabelValueBean> getTypeList() {
		return typeList;
	}
	/**
	 * ��ѯ�����趨
	 * @param typeList��ѯ����
	 */
	public void setTypeList(List<LabelValueBean> typeList) {
		this.typeList = typeList;
	}
	
	
	/**
	 * ����ϸ��Ϣȡ��
	 * @return ����ϸ��Ϣ
	 */
	public IGCIM0213Form getIgcim0213Form() {
		return igcim0213Form;
	}
	/**
	 * ����ϸ��Ϣ�趨
	 * @param igcim0213Form����ϸ��Ϣ
	 */
	public void setIgcim0213Form(IGCIM0213Form igcim0213Form) {
		this.igcim0213Form = igcim0213Form;
	}
	
	/**
	 * �ʲ�����ϸ����������ӿ�ȡ��
	 * @return �ʲ�����ϸ����������ӿ�
	 */
	public SOC0126SearchCond getEiDomainDetailVWSearchCond() {
		return eiDomainDetailVWSearchCond;
	}
	
	/**
	 * �ʲ�����ϸ����������ӿ��趨
	 * @param eiDomainDetailVWSearchCond�ʲ�����ϸ����������ӿ�
	 */
	public void setEiDomainDetailVWSearchCond(
			SOC0126SearchCond eiDomainDetailVWSearchCond) {
		this.eiDomainDetailVWSearchCond = eiDomainDetailVWSearchCond;
	}
	public List<SOC0136Info> getSOC0136InfoList() {
		return eiDomainDetailCIInfoList;
	}
	public void setSOC0136InfoList(
			List<SOC0136Info> eiDomainDetailCIInfoList) {
		this.eiDomainDetailCIInfoList = eiDomainDetailCIInfoList;
	}
	
	/**
	 * ����ϸ��Ϣȡ��
	 * @return ����ϸ��Ϣ
	 */
	public List<SOC0138Info> getSOC0138InfoList() {
		return eiDomainDetailCIOneInfoList;
	}

	/**
	 * ����ϸ��Ϣ�趨
	 * @param eiDomainDetailInfoList����ϸ��Ϣ
	 */
	public void setSOC0138InfoList(
			List<SOC0138Info> eiDomainDetailCIOneInfoList) {
		this.eiDomainDetailCIOneInfoList = eiDomainDetailCIOneInfoList;
	}
	
	public IGCIM0802Form getIgcim0802Form() {
		return igcim0802Form;
	}
	public void setIgcim0802Form(IGCIM0802Form igcim0802Form) {
		this.igcim0802Form = igcim0802Form;
	}
	public List<CR03Info> getCr03InfoList() {
		return cr03InfoList;
	}
	public void setCr03InfoList(List<CR03Info> cr03InfoList) {
		this.cr03InfoList = cr03InfoList;
	}
	
}
