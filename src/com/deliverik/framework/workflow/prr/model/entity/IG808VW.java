/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.framework.workflow.prr.model.IG808Info;

/**
 * <p>����:��ҳ�ϰ�����ͳ�ƹ���������ͼʵ��</p>
 * <p>����������</p>
 * <p>������¼���κ��� 2010/11/13</p>
 */
@SuppressWarnings("serial")
@Entity
public class IG808VW implements Serializable,
	Cloneable, IG808Info {
	@Id
	/** ������*/
	protected String orgname;
	/** ��������*/
	protected String workCount;
	
	/**
	 * ���ܣ���������ȡ��
	 * @return workCount ��������
	 */
	public String getWorkCount() {
		return workCount;
	}

	/**
	 * ���ܣ����������趨
	 * @param workCount ��������
	 */
	public void setWorkCount(String workCount) {
		this.workCount = workCount;
	}

	/**
	 * ���ܣ���������ȡ��
	 * @return orgname ��������
	 */
	public String getOrgname() {
		return orgname;
	}

	/**
	 * ���ܣ����������趨
	 * @param orgname ��������
	 */
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}


	public boolean equals(Object obj) {
		if (!(obj instanceof IG808VW))
			return false;

		return true;
	}

}
