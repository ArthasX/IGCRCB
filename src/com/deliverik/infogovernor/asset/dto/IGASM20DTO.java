/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.dto;

import java.io.Serializable;
import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.asset.EiDomainDetailCIInfo;
import com.deliverik.framework.asset.model.EiDomainDefInfo;
import com.deliverik.framework.asset.model.EiDomainDetailMaxVWInfo;
import com.deliverik.framework.asset.model.EiImportProgrammeInfo;
import com.deliverik.framework.asset.model.EiWaitTaskInfo;
import com.deliverik.framework.asset.model.ImportVersionInfo;
import com.deliverik.framework.asset.model.condition.EiDomainDefSearchCond;
import com.deliverik.framework.asset.model.condition.EiDomainDetailMaxVWSearchCond;
import com.deliverik.framework.asset.model.condition.ImportVersionSearchCond;
import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.asset.form.IGASM2001Form;
import com.deliverik.infogovernor.asset.form.IGASM2002Form;
import com.deliverik.infogovernor.asset.form.IGASM2003Form;
import com.deliverik.infogovernor.asset.form.IGASM2005Form;
import com.deliverik.infogovernor.asset.form.IGASM2006Form;
import com.deliverik.infogovernor.asset.form.IGASM2007Form;
import com.deliverik.infogovernor.asset.form.IGASM2010Form;
import com.deliverik.infogovernor.asset.form.IGASM2012Form;
import com.deliverik.infogovernor.asset.form.IGASM2013Form;
/**
 * ����: �ʲ�����ҵ����DTO
 * ��������: �ʲ�����ҵ����DTO
 * ������¼: 2011/04/25
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGASM20DTO extends BaseDTO implements Serializable {

	/**
	 * �ʲ��������������ӿ�
	 */
	protected EiDomainDefSearchCond eiDomainDefSearchCond;
	
	/**
	 * �ʲ�����ϸ����������ӿ�
	 */
	protected EiDomainDetailMaxVWSearchCond eiDomainDetailVWSearchCond;
	
	/**
	 * ����������������ӿ�
	 */
	protected ImportVersionSearchCond importVersionSearchCond;
	
	/**
	 * �����������
	 */
	protected List<EiImportProgrammeInfo> eiImportProgrammeList;
	
	/** ����ϸ��Ϣ */
	protected List<EiDomainDetailMaxVWInfo> eiDomainDetailVWInfoList;
	
	
	protected List<EiDomainDetailCIInfo> eiDomainDetailCIInfoList;
	
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
	

	/** �ʲ�������Ϣ */
	protected IGASM2002Form igasm2002Form;
	
	/** �ʲ�������ϸ��Ϣ */
	protected IGASM2005Form igasm2005Form;
	
	/** ���������Ϣ */
	protected IGASM2006Form igasm2006Form;
	
	/** ���������Ϣ */
	protected IGASM2007Form igasm2007Form;
	
	/** �ʲ�����汾Form */
	protected IGASM2012Form igasm2012Form;
	
	/** ��CI��ѯ������Ϣ*/
	protected IGASM2013Form igasm2013Form;
	
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
	protected EiDomainDefInfo eiDomainDefInfo;

	/** �ʲ����������� */
	protected List<EiDomainDefInfo> eiDomainDefInfoList;
	
	/** ������������� */
	protected List<ImportVersionInfo> importVersionInfoList;
	
	/** ������������� */
	protected ImportVersionInfo importVersionInfo;
	
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
	protected IGASM2001Form igasm2001Form;
	
	/** ����̨�����б� */
	protected List<EiWaitTaskInfo> eiWaitTaskList;
	
	/** ����̨��ʾFORM */
	protected IGASM2010Form igasm2010Form;
	
	/** ����̨���� */
	protected EiWaitTaskInfo eiWaitTask;
	/** �û���Ϣ */
	protected User user;
	
	/** �ʲ�������ϸ��Ϣ */
	protected IGASM2003Form igasm2003Form;
	
	public IGASM2003Form getIgasm2003Form() {
		return igasm2003Form;
	}
	public void setIgasm2003Form(IGASM2003Form igasm2003Form) {
		this.igasm2003Form = igasm2003Form;
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
	public EiDomainDefSearchCond getEiDomainDefSearchCond() {
		return eiDomainDefSearchCond;
	}

	/**
	 * �ʲ��������������ӿ�����
	 * 
	 * @param eiDomainDefSearchCond�ʲ��������������ӿ�
	 */
	public void setEiDomainDefSearchCond(
			EiDomainDefSearchCond eiDomainDefSearchCond) {
		this.eiDomainDefSearchCond = eiDomainDefSearchCond;
	}


	/**
	 * �ʲ�������Ϣȡ��
	 * 
	 * @return �ʲ�������Ϣ
	 */
	public IGASM2002Form getIgasm2002Form() {
		return igasm2002Form;
	}

	/**
	 * �ʲ�������Ϣ����
	 * 
	 * @param igasm2002Form�ʲ�������Ϣ
	 */
	public void setIgasm2002Form(IGASM2002Form igasm2002Form) {
		this.igasm2002Form = igasm2002Form;
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
	public List<EiDomainDefInfo> getEiDomainDefInfoList() {
		return eiDomainDefInfoList;
	}

	/**
	 * �ʲ������������趨
	 * 
	 * @param eiDomainDefInfoList�ʲ�����������
	 */
	public void setEiDomainDefInfoList(List<EiDomainDefInfo> eiDomainDefInfoList) {
		this.eiDomainDefInfoList = eiDomainDefInfoList;
	}

	/**
	 * �ʲ�������ϸ��Ϣȡ��
	 * @return �ʲ�������ϸ��Ϣ
	 */
	public IGASM2005Form getIgasm2005Form() {
		return igasm2005Form;
	}
	/**
	 * �ʲ�������ϸ��Ϣ�趨
	 * @param igasm2005Form�ʲ�������ϸ��Ϣ
	 */
	public void setIgasm2005Form(IGASM2005Form igasm2005Form) {
		this.igasm2005Form = igasm2005Form;
	}

	/**
	 * ����̨��ʾFORMȡ��
	 * 
	 * @return ����̨��ʾFORM
	 */
	public IGASM2001Form getIgasm2001Form() {
		return igasm2001Form;
	}

	/**
	 * ����̨��ʾFORM�趨
	 * 
	 * @param igasm2001Form ����̨��ʾFORM
	 */
	public void setIgasm2001Form(IGASM2001Form igasm2001Form) {
		this.igasm2001Form = igasm2001Form;
	}

	/**
	 * ����̨�����б�
	 * 
	 * @return ����̨�����б�ȡ��
	 */
	public List<EiWaitTaskInfo> getEiWaitTaskList() {
		return eiWaitTaskList;
	}

	/**
	 * ����̨�����б��趨
	 * 
	 * @param eiWaitTaskList ����̨�����б�
	 */
	public void setEiWaitTaskList(List<EiWaitTaskInfo> eiWaitTaskList) {
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
	public IGASM2006Form getIgasm2006Form() {
		return igasm2006Form;
	}
	
	/**
	 * ���������Ϣ
	 * @param igasm2006Form���������Ϣ
	 */
	public void setIgasm2006Form(IGASM2006Form igasm2006Form) {
		this.igasm2006Form = igasm2006Form;
	}
	
	/**
	 * ������������� 
	 * @return ������������� 
	 */
	public List<ImportVersionInfo> getImportVersionInfoList() {
		return importVersionInfoList;
	}

	/**
	 * ������������� 
	 * @param importVersionInfoList������������� 
	 */
	public void setImportVersionInfoList(
			List<ImportVersionInfo> importVersionInfoList) {
		this.importVersionInfoList = importVersionInfoList;
	}

	/**
	 * ����������������ӿ�ȡ��
	 * @return ����������������ӿ�
	 */
	public ImportVersionSearchCond getImportVersionSearchCond() {
		return importVersionSearchCond;
	}

	/**
	 * ����������������ӿ��趨
	 * @param importVersionSearchCond����������������ӿ�
	 */
	public void setImportVersionSearchCond(
			ImportVersionSearchCond importVersionSearchCond) {
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
	public IGASM2007Form getIgasm2007Form() {
		return igasm2007Form;
	}
	/**
	 * ���������Ϣ�趨
	 * @param igasm2007Form���������Ϣ
	 */
	public void setIgasm2007Form(IGASM2007Form igasm2007Form) {
		this.igasm2007Form = igasm2007Form;
	}

	/**
	 * ����̨��ʾFORMȡ��
	 * 
	 * @return ����̨��ʾFORM
	 */
	public IGASM2010Form getIgasm2010Form() {
		return igasm2010Form;
	}

	/**
	 * ����̨��ʾFORM�趨
	 * 
	 * @param igasm2010Form ����̨��ʾFORM
	 */
	public void setIgasm2010Form(IGASM2010Form igasm2010Form) {
		this.igasm2010Form = igasm2010Form;
	}

	/**
	 * ����̨����ȡ��
	 * 
	 * @return ����̨����
	 */
	public EiWaitTaskInfo getEiWaitTask() {
		return eiWaitTask;
	}

	/**
	 * ����̨�����趨
	 * 
	 * @param eiWaitTask ����̨����
	 */
	public void setEiWaitTask(EiWaitTaskInfo eiWaitTask) {
		this.eiWaitTask = eiWaitTask;
	}
	
	/**
	 * �����������ȡ��
	 * @return �����������
	 */
	public List<EiImportProgrammeInfo> getEiImportProgrammeList() {
		return eiImportProgrammeList;
	}

	/**
	 * ������������趨
	 * @param eiImportProgrammeList�����������
	 */
	public void setEiImportProgrammeList(
			List<EiImportProgrammeInfo> eiImportProgrammeList) {
		this.eiImportProgrammeList = eiImportProgrammeList;
	}
	
	/**
	 * �������������
	 * @return �������������
	 */
	public ImportVersionInfo getImportVersionInfo() {
		return importVersionInfo;
	}

	/**
	 * �������������
	 * @param importVersionInfo�������������
	 */
	public void setImportVersionInfo(ImportVersionInfo importVersionInfo) {
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
	public IGASM2012Form getIgasm2012Form() {
		return igasm2012Form;
	}
	/**
	 * �ʲ�����汾Form�趨
	 * @param igasm2012Form�ʲ�����汾Form
	 */
	public void setIgasm2012Form(IGASM2012Form igasm2012Form) {
		this.igasm2012Form = igasm2012Form;
	}
	/**
	 * �ʲ�����������ȡ��
	 * @return �ʲ�����������
	 */
	public EiDomainDefInfo getEiDomainDefInfo() {
		return eiDomainDefInfo;
	}
	/**
	 * �ʲ������������趨
	 * @param eiDomainDefInfo�ʲ�����������
	 */
	public void setEiDomainDefInfo(EiDomainDefInfo eiDomainDefInfo) {
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
	public List<EiDomainDetailMaxVWInfo> getEiDomainDetailVWInfoList() {
		return eiDomainDetailVWInfoList;
	}

	/**
	 * ����ϸ��Ϣ�趨
	 * @param eiDomainDetailInfoList����ϸ��Ϣ
	 */
	public void setEiDomainDetailVWInfoList(
			List<EiDomainDetailMaxVWInfo> eiDomainDetailVWInfoList) {
		this.eiDomainDetailVWInfoList = eiDomainDetailVWInfoList;
	}
	
	/**
	 * ����ϸ��Ϣȡ��
	 * @return ����ϸ��Ϣ
	 */
	public IGASM2013Form getIgasm2013Form() {
		return igasm2013Form;
	}
	/**
	 * ����ϸ��Ϣ�趨
	 * @param igasm2013Form����ϸ��Ϣ
	 */
	public void setIgasm2013Form(IGASM2013Form igasm2013Form) {
		this.igasm2013Form = igasm2013Form;
	}
	
	/**
	 * �ʲ�����ϸ����������ӿ�ȡ��
	 * @return �ʲ�����ϸ����������ӿ�
	 */
	public EiDomainDetailMaxVWSearchCond getEiDomainDetailVWSearchCond() {
		return eiDomainDetailVWSearchCond;
	}
	
	/**
	 * �ʲ�����ϸ����������ӿ��趨
	 * @param eiDomainDetailVWSearchCond�ʲ�����ϸ����������ӿ�
	 */
	public void setEiDomainDetailVWSearchCond(
			EiDomainDetailMaxVWSearchCond eiDomainDetailVWSearchCond) {
		this.eiDomainDetailVWSearchCond = eiDomainDetailVWSearchCond;
	}
	public List<EiDomainDetailCIInfo> getEiDomainDetailCIInfoList() {
		return eiDomainDetailCIInfoList;
	}
	public void setEiDomainDetailCIInfoList(
			List<EiDomainDetailCIInfo> eiDomainDetailCIInfoList) {
		this.eiDomainDetailCIInfoList = eiDomainDetailCIInfoList;
	}
	
	
	
}
