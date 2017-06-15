/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.mnt.form;

import java.io.Serializable;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.rpt.model.SOC0423Info;

/**
 * ����: ������ع���Form
 * ��������: ������ع���Form
 * ������¼: 2012-8-2
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGMNT0205Form extends BaseForm implements SOC0423Info{
	//Ԥ��
	//private String[] delArr;
	/**���±�ʾ*/
	protected String[] selArr;

	protected Integer id;

	/** ���� */
	protected String name;

	/** �������� */
	protected String objectType;

	/** �������� */
	protected String objectName;
	
	/** ������� */
	protected Integer errorNum;
	
	/** �澯���� */
	protected Integer warningNum;
	
	/** ״̬ */
	protected Integer status;
	
	/** ���´���������� */
	protected Integer[] errorNums;
	/** ���¸澯�������� */
	protected Integer[] warningNums;
	/** ����id���� */
	protected String[] ids;
	/** ����name���� */
	protected String[] names;
	/** ������������ */
	protected String[] objectNames;
	/** ������������ */
	protected String[] objectTypes;
	
	public Integer getId() {
		return id;
	}

	/**
	 * �����趨
	 *
	 * @param id ����
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getName() {
		return name;
	}

	/**
	 * �����趨
	 *
	 * @param name ����
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getObjectType() {
		return objectType;
	}

	/**
	 * ���������趨
	 *
	 * @param objectType ��������
	 */
	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getObjectName() {
		return objectName;
	}

	/**
	 * ���������趨
	 *
	 * @param objectName ��������
	 */
	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return id;
	}

	/**
	 * �������ȡ��
	 *
	 * @return errorNum �������
	 */
	public Integer getErrorNum() {
		return errorNum;
	}

	/**
	 * ��������趨
	 *
	 * @param errorNum �������
	 */
	public void setErrorNum(Integer errorNum) {
		this.errorNum = errorNum;
	}

	/**
	 * �澯����ȡ��
	 *
	 * @return warningNum �澯����
	 */
	public Integer getWarningNum() {
		return warningNum;
	}

	/**
	 * �澯�����趨
	 *
	 * @param warningNum �澯����
	 */
	public void setWarningNum(Integer warningNum) {
		this.warningNum = warningNum;
	}

	/**
	 * ״̬ȡ��
	 *
	 * @return status ״̬
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * ״̬�趨
	 *
	 * @param status ״̬
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	//
	public String getFingerPrint() {
		//
		return null;
	}

	/**
	 * Ԥ��pȡ��
	 *
	 * @return selArr Ԥ��p
	 */
	public String[] getSelArr() {
		return selArr;
	}

	/**
	 * Ԥ��p�趨
	 *
	 * @param selArr Ԥ��p
	 */
	public void setSelArr(String[] selArr) {
		this.selArr = selArr;
	}

	/**
	 * ���´����������ȡ��
	 *
	 * @return errorNums ���´����������
	 */
	public Integer[] getErrorNums() {
		return errorNums;
	}

	/**
	 * ���´�����������趨
	 *
	 * @param errorNums ���´����������
	 */
	public void setErrorNums(Integer[] errorNums) {
		this.errorNums = errorNums;
	}

	/**
	 * ���¸澯��������ȡ��
	 *
	 * @return warningNums ���¸澯��������
	 */
	public Integer[] getWarningNums() {
		return warningNums;
	}

	/**
	 * ���¸澯���������趨
	 *
	 * @param warningNums ���¸澯��������
	 */
	public void setWarningNums(Integer[] warningNums) {
		this.warningNums = warningNums;
	}

	/**
	 * ����id����ȡ��
	 *
	 * @return ids ����id����
	 */
	public String[] getIds() {
		return ids;
	}

	/**
	 * ����id�����趨
	 *
	 * @param ids ����id����
	 */
	public void setIds(String[] ids) {
		this.ids = ids;
	}

	/**
	 * ����name����ȡ��
	 *
	 * @return names ����name����
	 */
	public String[] getNames() {
		return names;
	}

	/**
	 * ����name�����趨
	 *
	 * @param names ����name����
	 */
	public void setNames(String[] names) {
		this.names = names;
	}

	/**
	 * ������������ȡ��
	 *
	 * @return objectNames ������������
	 */
	public String[] getObjectNames() {
		return objectNames;
	}

	/**
	 * �������������趨
	 *
	 * @param objectNames ������������
	 */
	public void setObjectNames(String[] objectNames) {
		this.objectNames = objectNames;
	}

	/**
	 * ������������ȡ��
	 *
	 * @return objectTypes ������������
	 */
	public String[] getObjectTypes() {
		return objectTypes;
	}

	/**
	 * �������������趨
	 *
	 * @param objectTypes ������������
	 */
	public void setObjectTypes(String[] objectTypes) {
		this.objectTypes = objectTypes;
	}

}
