/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prd.model.entity;

/**
 * <p>����:���̹�ͨ����ʵ��</p>
 * <p>����������1.���̳�ʼ��</p>
 * <p>          2.���̲�ѯ</p>
 * <p>������¼��</p>
 */
import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG202Info;


@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="IG202")
public class IG202TB extends BaseEntity implements Serializable, Cloneable,IG202Info{
	@Id
	@TableGenerator(
			name="IG202_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="IG202_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IG202_TABLE_GENERATOR")
	/**
	* ���̱�������ID
	*/
	protected Integer pidid;

	/**
	* ���̱�������
	*/
	protected String pidname;

	/**
	* ���̱�����ʾ����
	*/
	protected String pidlabel;

	/**
	* ���̱�������
	*/
	protected String piddesc;

	/**
	* ���̱�������
	*/
	protected String pidtype;

	/**
	* ���̱���ѡ��
	*/
	protected String pidoption;

	/**
	* ���̱���Ĭ��ֵ
	*/
	protected String piddefault;

	/**
	* ���̱����Ƿ����
	*/
	protected String pidrequired;

	/**
	* ���̱��������ʶ
	*/
	protected String pidsortid;

	/**
	* �������̱���CCID
	*/
	protected String ccid;
	
	/** ����Ϣ��ģʽ */
	protected String pidmode;
	
	/** ����Ϣ������ʾģʽ */
	protected String rowwidth;
	
	/** ˽�б���Ȩ�޷�Χ */
	protected String privatescope;

	/**
	* ���ܣ����̱�������IDȡ��
	* @return pidid ���̱�������ID
	*/
	public Integer getPidid(){
	return pidid;
	}
	/**
	* ���ܣ����̱�������ID�趨
	* @param pidid ���̱�������ID
	*/
	public void setPidid(Integer pidid){
	this.pidid=pidid;
	}
	/**
	* ���ܣ����̱�������ȡ��
	* @return pidname ���̱�������
	*/
	public String getPidname(){
	return pidname;
	}
	/**
	* ���ܣ����̱��������趨
	* @param pidname ���̱�������
	*/
	public void setPidname(String pidname){
	this.pidname=pidname;
	}
	/**
	* ���ܣ����̱�����ʾ����ȡ��
	* @return pidlabel ���̱�����ʾ����
	*/
	public String getPidlabel(){
	return pidlabel;
	}
	/**
	* ���ܣ����̱�����ʾ�����趨
	* @param pidlabel ���̱�����ʾ����
	*/
	public void setPidlabel(String pidlabel){
	this.pidlabel=pidlabel;
	}
	/**
	* ���ܣ����̱�������ȡ��
	* @return piddesc ���̱�������
	*/
	public String getPiddesc(){
	return piddesc;
	}
	/**
	* ���ܣ����̱��������趨
	* @param piddesc ���̱�������
	*/
	public void setPiddesc(String piddesc){
	this.piddesc=piddesc;
	}
	/**
	* ���ܣ����̱�������ȡ��
	* @return pidtype ���̱�������
	*/
	public String getPidtype(){
	return pidtype;
	}
	/**
	* ���ܣ����̱��������趨
	* @param pidtype ���̱�������
	*/
	public void setPidtype(String pidtype){
	this.pidtype=pidtype;
	}
	/**
	* ���ܣ����̱���ѡ��ȡ��
	* @return pidoption ���̱���ѡ��
	*/
	public String getPidoption(){
	return pidoption;
	}
	/**
	* ���ܣ����̱���ѡ���趨
	* @param pidoption ���̱���ѡ��
	*/
	public void setPidoption(String pidoption){
	this.pidoption=pidoption;
	}
	/**
	* ���ܣ����̱���Ĭ��ֵȡ��
	* @return piddefault ���̱���Ĭ��ֵ
	*/
	public String getPiddefault(){
	return piddefault;
	}
	/**
	* ���ܣ����̱���Ĭ��ֵ�趨
	* @param piddefault ���̱���Ĭ��ֵ
	*/
	public void setPiddefault(String piddefault){
	this.piddefault=piddefault;
	}
	/**
	* ���ܣ����̱����Ƿ����ȡ��
	* @return pidrequired ���̱����Ƿ����
	*/
	public String getPidrequired(){
	return pidrequired;
	}
	/**
	* ���ܣ����̱����Ƿ�����趨
	* @param pidrequired ���̱����Ƿ����
	*/
	public void setPidrequired(String pidrequired){
	this.pidrequired=pidrequired;
	}
	/**
	* ���ܣ����̱��������ʶȡ��
	* @return pidsortid ���̱��������ʶ
	*/
	public String getPidsortid(){
	return pidsortid;
	}
	/**
	* ���ܣ����̱��������ʶ�趨
	* @param pidsortid ���̱��������ʶ
	*/
	public void setPidsortid(String pidsortid){
	this.pidsortid=pidsortid;
	}
	/**
	* ���ܣ��������̱���CCIDȡ��
	* @return ccid �������̱���CCID
	*/
	public String getCcid(){
	return ccid;
	}
	/**
	* ���ܣ��������̱���CCID�趨
	* @param ccid �������̱���CCID
	*/
	public void setCcid(String ccid){
	this.ccid=ccid;
	}


	
	@Override
	public Serializable getPK() {
		// TODO Auto-generated method stub
		return pidid;
	}
	public String getRowwidth() {
		return rowwidth;
	}
	public void setRowwidth(String rowwidth) {
		this.rowwidth = rowwidth;
	}
	public String getPrivatescope() {
		return privatescope;
	}
	public void setPrivatescope(String privatescope) {
		this.privatescope = privatescope;
	}
	public String getPidmode() {
		return pidmode;
	}
	public void setPidmode(String pidmode) {
		this.pidmode = pidmode;
	}

}
