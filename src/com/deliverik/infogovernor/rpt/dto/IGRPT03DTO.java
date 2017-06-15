/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.rpt.dto;

import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.entity.CodeDetailEntity;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.rpt.form.IGRPT0302Form;
import com.deliverik.infogovernor.rpt.model.SOC0401Info;
import com.deliverik.infogovernor.rpt.model.SOC0415Info;
import com.deliverik.infogovernor.sym.model.ReportFileDefinition;

/**
 * ����: ����ͳ��
 * ��������: ���𱨱�ͳ�Ʋ�ѯ
 * ������¼: ����ȫ 2012/07/03
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGRPT03DTO extends BaseDTO{
	/**�洢����*/
	protected List<SOC0118Info> scList;
	/**ҵ��ϵͳ����*/
	protected List<SOC0118Info> bcVWList;
	/**��������*/
	protected List<SOC0118Info> hcVWList;
	/**VG����*/
	protected List<SOC0124Info> vgList=new ArrayList<SOC0124Info>();
	/**FS����*/
	protected List<SOC0124Info> fsList=new ArrayList<SOC0124Info>();
	
	/**DB����*/
	protected List<SOC0401Info> dbList=new ArrayList<SOC0401Info>();
	/**TS����*/
	protected List<SOC0415Info> tsList=new ArrayList<SOC0415Info>();
	
	protected IGRPT0302Form igrpt0302Form;
	/**���ܱ���˵�*/
	protected List<CodeDetailEntity> catagoryCodeDeatilList=new ArrayList<CodeDetailEntity>();
	/**���󱨱�˵�*/
	protected List<CodeDetailEntity> objCodeDeatilList=new ArrayList<CodeDetailEntity>();
	/**���񱨱�*/
	protected List<ReportFileDefinition> reportFileDefinitionList=new ArrayList<ReportFileDefinition>();
	
	protected User user;
	
	/**
	 * �洢����ȡ��
	 *
	 * @return scList �洢����
	 */
	public List<SOC0118Info> getScList() {
		return scList;
	}

	/**
	 * �洢�����趨
	 *
	 * @param scList �洢����
	 */
	public void setScList(List<SOC0118Info> scList) {
		this.scList = scList;
	}

	/**
	 * ҵ��ϵͳ����ȡ��
	 *
	 * @return bcVWList ҵ��ϵͳ����
	 */
	public List<SOC0118Info> getBcVWList() {
		return bcVWList;
	}

	/**
	 * ҵ��ϵͳ�����趨
	 *
	 * @param bcVWList ҵ��ϵͳ����
	 */
	public void setBcVWList(List<SOC0118Info> bcVWList) {
		this.bcVWList = bcVWList;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return hcVWList ��������
	 */
	public List<SOC0118Info> getHcVWList() {
		return hcVWList;
	}

	/**
	 * ���������趨
	 *
	 * @param hcVWList ��������
	 */
	public void setHcVWList(List<SOC0118Info> hcVWList) {
		this.hcVWList = hcVWList;
	}
	/**
	 * VG����ȡ��
	 *
	 * @return vgList VG����
	 */
	public List<SOC0124Info> getVgList() {
		return vgList;
	}

	/**
	 * VG�����趨
	 *
	 * @param vgList VG����
	 */
	public void setVgList(List<SOC0124Info> vgList) {
		this.vgList = vgList;
	}

	/**
	 * FS����ȡ��
	 *
	 * @return fsList FS����
	 */
	public List<SOC0124Info> getFsList() {
		return fsList;
	}

	/**
	 * FS�����趨
	 *
	 * @param fsList FS����
	 */
	public void setFsList(List<SOC0124Info> fsList) {
		this.fsList = fsList;
	}

	/**
	 * DB����ȡ��
	 *
	 * @return dbList DB����
	 */
	public List<SOC0401Info> getDbList() {
		return dbList;
	}

	/**
	 * DB�����趨
	 *
	 * @param dbList DB����
	 */
	public void setDbList(List<SOC0401Info> dbList) {
		this.dbList = dbList;
	}

	/**
	 * TS����ȡ��
	 *
	 * @return tsList TS����
	 */
	public List<SOC0415Info> getTsList() {
		return tsList;
	}

	/**
	 * TS�����趨
	 *
	 * @param tsList TS����
	 */
	public void setTsList(List<SOC0415Info> tsList) {
		this.tsList = tsList;
	}

	/**
	 * igrpt0302Formȡ��
	 *
	 * @return igrpt0302Form igrpt0302Form
	 */
	public IGRPT0302Form getIgrpt0302Form() {
		return igrpt0302Form;
	}

	/**
	 * igrpt0302Form�趨
	 *
	 * @param igrpt0302Form igrpt0302Form
	 */
	public void setIgrpt0302Form(IGRPT0302Form igrpt0302Form) {
		this.igrpt0302Form = igrpt0302Form;
	}

	



	/**
	 * ���ܱ���˵�ȡ��
	 *
	 * @return catagoryCodeDeatilList ���ܱ���˵�
	 */
	public List<CodeDetailEntity> getCatagoryCodeDeatilList() {
		return catagoryCodeDeatilList;
	}

	/**
	 * ���ܱ���˵��趨
	 *
	 * @param catagoryCodeDeatilList ���ܱ���˵�
	 */
	public void setCatagoryCodeDeatilList(
			List<CodeDetailEntity> catagoryCodeDeatilList) {
		this.catagoryCodeDeatilList = catagoryCodeDeatilList;
	}

	/**
	 * ���󱨱�˵�ȡ��
	 *
	 * @return objCodeDeatilList ���󱨱�˵�
	 */
	public List<CodeDetailEntity> getObjCodeDeatilList() {
		return objCodeDeatilList;
	}

	/**
	 * ���󱨱�˵��趨
	 *
	 * @param objCodeDeatilList ���󱨱�˵�
	 */
	public void setObjCodeDeatilList(List<CodeDetailEntity> objCodeDeatilList) {
		this.objCodeDeatilList = objCodeDeatilList;
	}

	/**
	 * ���񱨱�ȡ��
	 *
	 * @return reportFileDefinitionList ���񱨱�
	 */
	public List<ReportFileDefinition> getReportFileDefinitionList() {
		return reportFileDefinitionList;
	}

	/**
	 * ���񱨱��趨
	 *
	 * @param reportFileDefinitionList ���񱨱�
	 */
	public void setReportFileDefinitionList(
			List<ReportFileDefinition> reportFileDefinitionList) {
		this.reportFileDefinitionList = reportFileDefinitionList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
}
