/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */
package com.deliverik.infogovernor.soc.mnt.form;


import java.io.Serializable;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.soc.dbs.model.Collect_Symmetrix_Info;

/**
 * ����:��ض���Ǽǡ��޸�form
 * ����������
 * ������¼�����    2012/02/09
 */
@SuppressWarnings("serial")
public class IGMNT0103Form extends BaseForm implements Collect_Symmetrix_Info{
	
	/**
	 * ��ض���id
	 */
	protected String moId;
	
	/**
	 * ip��ַ
	 */
	protected String ip;
	
	/**
	 * ����ʱ��
	 */
	protected String moCreateTime;
	
	/**
	 * ��ض���״̬
	 */
	protected String deleteFlag;
	
	/**
	 * ��ض���ֵ״̬����
	 */
	protected String[] modDeleteFlag;
	
	/**
	 * ������Ͳ����
	 */
	protected String mtSyscoding;
	
	/**
	 * �������ID
	 */
	protected String mtId;
	
	/**
	 * �����������
	 */
	protected String mtName;
	
	/**
	 * ��ض���ֵ��������
	 */
	protected String[] modName;
	
	/**
	 * ��ض���ֵ����
	 */
	protected String[] modValue;
	
	/**
	 * ��תҳ��ʶ
	 */
	protected String flag;
	
	/**
	 * �ȽϷ�����
	 */
	protected String[] compare;
	
	/**
	 * *����ID
	 */
	protected Integer id;

	/**
	 *����IDȡ��
	 * 
	 * @return ����ID
	 */
	public Integer getId() {
		return id;
	}

	/**
	 *����ID�趨
	 * 
	 * @param id����ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 *���к�
	 */
	protected String symm_id;

	/**
	 *���к�ȡ��
	 * 
	 * @return ���к�
	 */
	public String getSymm_id() {
		return symm_id;
	}

	/**
	 *���к��趨
	 * 
	 * @param symm_id���к�
	 */
	public void setSymm_id(String symm_id) {
		this.symm_id = symm_id;
	}

	/**
	 *�ͺ�
	 */
	protected String symm_model;

	/**
	 *�ͺ�ȡ��
	 * 
	 * @return �ͺ�
	 */
	public String getSymm_model() {
		return symm_model;
	}

	/**
	 *�ͺ��趨
	 * 
	 * @param symm_model�ͺ�
	 */
	public void setSymm_model(String symm_model) {
		this.symm_model = symm_model;
	}

	/**
	 *΢��汾
	 */
	protected String symm_version;

	/**
	 *΢��汾ȡ��
	 * 
	 * @return ΢��汾
	 */
	public String getSymm_version() {
		return symm_version;
	}

	/**
	 *΢��汾�趨
	 * 
	 * @param symm_version΢��汾
	 */
	public void setSymm_version(String symm_version) {
		this.symm_version = symm_version;
	}

	/**
	 *����
	 */
	protected String symm_cachesize;

	/**
	 *����ȡ��
	 * 
	 * @return ����
	 */
	public String getSymm_cachesize() {
		return symm_cachesize;
	}

	/**
	 *�����趨
	 * 
	 * @param symm_cachesize����
	 */
	public void setSymm_cachesize(String symm_cachesize) {
		this.symm_cachesize = symm_cachesize;
	}

	public Serializable getPK() {
		return id;
	}
	
	/**
	 *�洢����
	 */
	protected String symm_type;

	/**
	 * @return �洢����
	 */
	public String getSymm_type() {
		return symm_type;
	}

	/**
	 * @param �洢����
	 */
	public void setSymm_type(String symm_Type) {
		symm_type = symm_Type;
	}

	/**
	 * ������Ͳ�����ȡ
	 * @return
	 */
	public String getMtSyscoding() {
		return mtSyscoding;
	}

	/**
	 * ������Ͳ�����趨
	 * @param mtSyscoding
	 */
	public void setMtSyscoding(String mtSyscoding) {
		this.mtSyscoding = mtSyscoding;
	}

	/**
	 * ����ʱ���ȡ
	 * @return
	 */
	public String getMoCreateTime() {
		return moCreateTime;
	}

	/**
	 * ����ʱ���趨
	 * @param moCreateTime
	 */
	public void setMoCreateTime(String moCreateTime) {
		this.moCreateTime = moCreateTime;
	}

	/**
	 * ��ض���״̬��ȡ
	 * @return
	 */
	public String getDeleteFlag() {
		return deleteFlag;
	}

	/**
	 * ��ض���״̬�趨
	 * @param deleteFlag
	 */
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	/**
	 * ��ض���ֵ���ƻ�ȡ
	 * @return
	 */
	public String[] getModName() {
		return modName;
	}

	/**
	 * ��ض���ֵ�����趨
	 * @param modName
	 */
	public void setModName(String[] modName) {
		this.modName = modName;
	}

	/**
	 * ��ض���ֵ��ȡ
	 * @return
	 */
	public String[] getModValue() {
		return modValue;
	}

	/**
	 * ��ض���ֵ�趨
	 * @param modValue
	 */
	public void setModValue(String[] modValue) {
		this.modValue = modValue;
	}

	/**
	 * ��ض���ֵ״̬�����ȡ
	 * @return
	 */
	public String[] getModDeleteFlag() {
		return modDeleteFlag;
	}

	/**
	 * ��ض���ֵ״̬�����趨
	 * @param modDeleteFlag
	 */
	public void setModDeleteFlag(String[] modDeleteFlag) {
		this.modDeleteFlag = modDeleteFlag;
	}

	/**
	 * ip��ַ��ȡ
	 * @return
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * ip��ַ�趨
	 * @param ip
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * �������ID��ȡ
	 * @return
	 */
	public String getMtId() {
		return mtId;
	}

	/**
	 * �������IDȡ��
	 * @param mtId
	 */
	public void setMtId(String mtId) {
		this.mtId = mtId;
	}

	/**
	 * ��ض���idȡ��
	 * @return
	 */
	public String getMoId() {
		return moId;
	}

	/**
	 * ��ض���id�趨
	 * @param moId
	 */
	public void setMoId(String moId) {
		this.moId = moId;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	/**
	 * �ȽϷ�����ȡ��
	 * @return
	 */
	public String[] getCompare() {
		return compare;
	}

	/**
	 * �ȽϷ������趨
	 * @param compare
	 */
	public void setCompare(String[] compare) {
		this.compare = compare;
	}

	/**
	 * �����������ȡ��
	 * @return
	 */
	public String getMtName() {
		return mtName;
	}

	/**
	 * ������������趨
	 * @param mtName
	 */
	public void setMtName(String mtName) {
		this.mtName = mtName;
	}
}
