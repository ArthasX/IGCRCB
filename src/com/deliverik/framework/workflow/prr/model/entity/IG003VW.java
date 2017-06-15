/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.framework.workflow.prr.model.IG003Info;

/**
 * <p>����:����ͳ����Ϣʵ��</p>
 * <p>����������</p>
 * <p>������¼��</p>
 */
@SuppressWarnings("serial")
@Entity
public class IG003VW implements Serializable,
	Cloneable, IG003Info {
	@Id
	/** �·�*/
	public String month;
	
	/** ��ǰ�¼�*/
	public Integer currentIncident;
	
	/** ��ǰ�¼�*/
	public Integer precedingIncident;
	
	/** ��ǰ����*/
	public Integer currentProblem;
	
	/** ��ǰ����*/
	public Integer precedingProblem;
	
	/** ��ǰ���*/
	public Integer currentChange;
	
	/** ��ǰ���*/
	public Integer precedingChange;
	
	/** ��ǰ����*/
	public Integer currentDeployment;
	
	/** ��ǰ����*/
	public Integer precedingDeployment;
	
	/** ��ǰ����*/
	public Integer currentWork;
	
	/** ��ǰ����*/
	public Integer precedingWork;
	
	/** ��ǰ�ܹ�����*/
	public Integer totalCurrent;
	
	/** ��ǰ�ܹ�����*/
	public Integer totalPreceding;
	
	/**
	 * ���ܣ���ǰ�ܹ�����ȡ��
	 * @return totalCurrent
	 */
	public Integer getTotalCurrent() {
		return totalCurrent;
	}

	/**
	 * ���ܣ���ǰ�ܹ���������
	 * @param totalCurrent
	 */
	public void setTotalCurrent(Integer totalCurrent) {
		this.totalCurrent = totalCurrent;
	}

	/**
	 * ���ܣ���ǰ�ܹ�����ȡ��
	 * @return totalPreceding
	 */
	public Integer getTotalPreceding() {
		return totalPreceding;
	}

	/**
	 * ���ܣ���ǰ�ܹ������趨
	 * @param totalPreceding
	 */
	public void setTotalPreceding(Integer totalPreceding) {
		this.totalPreceding = totalPreceding;
	}

	/**
	 * ���ܣ��·�ȡ��
	 * @return month
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * ���ܣ��·��趨
	 * @param month
	 */
	public void setMonth(String month) {
		this.month = month;
	}

	/**
	 * ���ܣ���ǰ�¼�ȡ��
	 * @return currentIncident
	 */
	public Integer getCurrentIncident() {
		return currentIncident;
	}

	/**
	 * ���ܣ���ǰ�¼�����
	 * @param currentIncident
	 */
	public void setCurrentIncident(Integer currentIncident) {
		this.currentIncident = currentIncident;
	}

	/**
	 * ���ܣ���ǰ�¼�ȡ��
	 * @return precedingIncident
	 */
	public Integer getPrecedingIncident() {
		return precedingIncident;
	}

	/**
	 * ���ܣ���ǰ�¼��趨
	 * @param precedingIncident
	 */
	public void setPrecedingIncident(Integer precedingIncident) {
		this.precedingIncident = precedingIncident;
	}

	/**
	 * ���ܣ���ǰ����ȡ��
	 * @return currentProblem
	 */
	public Integer getCurrentProblem() {
		return currentProblem;
	}

	/**
	 * ���ܣ���ǰ�����趨
	 * @param currentProblem
	 */
	public void setCurrentProblem(Integer currentProblem) {
		this.currentProblem = currentProblem;
	}

	/**
	 * ���ܣ���ǰ����ȡ��
	 * @return precedingProblem
	 */
	public Integer getPrecedingProblem() {
		return precedingProblem;
	}

	/**
	 * ���ܣ���ǰ�����趨
	 * @param precedingProblem
	 */
	public void setPrecedingProblem(Integer precedingProblem) {
		this.precedingProblem = precedingProblem;
	}

	/**
	 * ���ܣ���ǰ���ȡ��
	 * @return currentChange
	 */
	public Integer getCurrentChange() {
		return currentChange;
	}

	/**
	 * ���ܣ���ǰ����趨
	 * @param currentChange
	 */
	public void setCurrentChange(Integer currentChange) {
		this.currentChange = currentChange;
	}

	/**
	 * ���ܣ���ǰ���ȡ��
	 * @return precedingChange
	 */
	public Integer getPrecedingChange() {
		return precedingChange;
	}

	/**
	 * ���ܣ���ǰ����趨
	 * @param precedingChange
	 */
	public void setPrecedingChange(Integer precedingChange) {
		this.precedingChange = precedingChange;
	}

	/**
	 * ���ܣ���ǰ����ȡ��
	 * @return currentDeployment
	 */
	public Integer getCurrentDeployment() {
		return currentDeployment;
	}

	/**
	 * ���ܣ���ǰ�����趨
	 * @param currentDeployment
	 */
	public void setCurrentDeployment(Integer currentDeployment) {
		this.currentDeployment = currentDeployment;
	}

	/**
	 * ���ܣ���ǰ����ȡ��
	 * @return precedingDeployment
	 */
	public Integer getPrecedingDeployment() {
		return precedingDeployment;
	}

	/**
	 * ���ܣ���ǰ�����趨
	 * @param precedingDeployment
	 */
	public void setPrecedingDeployment(Integer precedingDeployment) {
		this.precedingDeployment = precedingDeployment;
	}

	/**
	 * ���ܣ���ǰ����ȡ��
	 * @return currentWork
	 */
	public Integer getCurrentWork() {
		return currentWork;
	}

	/**
	 * ���ܣ���ǰ�����趨
	 * @param currentWork
	 */
	public void setCurrentWork(Integer currentWork) {
		this.currentWork = currentWork;
	}

	/**
	 * ���ܣ���ǰ����ȡ��
	 * @return precedingWork
	 */
	public Integer getPrecedingWork() {
		return precedingWork;
	}

	/**
	 * ���ܣ���ǰ�����趨
	 * @param precedingWork
	 */
	public void setPrecedingWork(Integer precedingWork) {
		this.precedingWork = precedingWork;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof IG003VW))
			return false;
		IG003Info target = (IG003Info) obj;
		if (!(getMonth() == target.getMonth()))
			return false;

		return true;
	}

}
