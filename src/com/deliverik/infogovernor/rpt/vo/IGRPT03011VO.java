/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.rpt.vo;

import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.entity.CodeDetailEntity;
import com.deliverik.infogovernor.sym.model.ReportFileDefinition;

/**
 * ����: ����ͳ�Ƴ�ʼVO
 * ��������: 
 * ������¼: ����ȫ 2012/07/03
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGRPT03011VO extends BaseVO{
	
	/**�洢����*/
	List<SOC0118Info> scList;
	/**ҵ��ϵͳ����*/
	List<SOC0118Info> bcVWList;
	/**��������*/
	List<SOC0118Info> hcVWList;
	/**���ܱ���˵�*/
	protected List<CodeDetailEntity> catagoryCodeDeatilList=new ArrayList<CodeDetailEntity>();
	/**���󱨸�˵�*/
	protected List<CodeDetailEntity> objCodeDeatilList=new ArrayList<CodeDetailEntity>();
	
	/**���񱨱�*/
	protected List<ReportFileDefinition> reportFileDefinitionList=new ArrayList<ReportFileDefinition>();
	
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
	 * ���󱨸�˵�ȡ��
	 *
	 * @return objCodeDeatilList ���󱨸�˵�
	 */
	public List<CodeDetailEntity> getObjCodeDeatilList() {
		return objCodeDeatilList;
	}
	/**
	 * ���󱨸�˵��趨
	 *
	 * @param objCodeDeatilList ���󱨸�˵�
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
	
	
	
}
