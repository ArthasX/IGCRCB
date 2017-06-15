/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.svc.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.svc.model.IncidentTypeVWInfo;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��������ͳ��ʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@Entity
public class IncidentTypeVW implements IncidentTypeVWInfo{

	/** ���� */
	@Id
	protected Integer id;
	
	/** OA�칫 */
	protected Integer oaWork;
	
	/** �û��������� */
	protected Integer userNameOrPassWord;
	
	/** ���ʹ��� */
	protected Integer materialsManager;
	
	/** ���ﵼҽ */
	protected Integer triageDaoYi;
	
	/** ������� */
	protected Integer netWorkMalfunction;
	
	/** ������ʧ�һ� */
	protected Integer casesOfLossBack;
	
	/** �����Э�� */
	protected Integer computerHelp;
	
	/** ��ʿ����վ */
	protected Integer nurseWorkstation;
	
	/** ��ظ澯 */
	protected Integer prossessingErrorAlarm;

	/**
	 * ����ȡ��
	 * @return id ����
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * �����趨
	 * @param id ����
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * OA�칫ȡ��
	 * @return oaWork OA�칫
	 */
	public Integer getOaWork() {
		return oaWork;
	}

	/**
	 * OA�칫�趨
	 * @param oaWork OA�칫
	 */
	public void setOaWork(Integer oaWork) {
		this.oaWork = oaWork;
	}

	/**
	 * �û���������ȡ��
	 * @return userNameOrPassWord �û���������
	 */
	public Integer getUserNameOrPassWord() {
		return userNameOrPassWord;
	}

	/**
	 * �û����������趨
	 * @param userNameOrPassWord �û���������
	 */
	public void setUserNameOrPassWord(Integer userNameOrPassWord) {
		this.userNameOrPassWord = userNameOrPassWord;
	}

	/**
	 * ���ʹ���ȡ��
	 * @return materialsManager ���ʹ���
	 */
	public Integer getMaterialsManager() {
		return materialsManager;
	}

	/**
	 * ���ʹ����趨
	 * @param materialsManager ���ʹ���
	 */
	public void setMaterialsManager(Integer materialsManager) {
		this.materialsManager = materialsManager;
	}

	/**
	 * ���ﵼҽȡ��
	 * @return triageDaoYi ���ﵼҽ
	 */
	public Integer getTriageDaoYi() {
		return triageDaoYi;
	}

	/**
	 * ���ﵼҽ�趨
	 * @param triageDaoYi ���ﵼҽ
	 */
	public void setTriageDaoYi(Integer triageDaoYi) {
		this.triageDaoYi = triageDaoYi;
	}

	/**
	 * �������ȡ��
	 * @return netWorkMalfunction �������
	 */
	public Integer getNetWorkMalfunction() {
		return netWorkMalfunction;
	}

	/**
	 * ��������趨
	 * @param netWorkMalfunction �������
	 */
	public void setNetWorkMalfunction(Integer netWorkMalfunction) {
		this.netWorkMalfunction = netWorkMalfunction;
	}

	/**
	 * ������ʧ�һ�ȡ��
	 * @return casesOfLossBack ������ʧ�һ�
	 */
	public Integer getCasesOfLossBack() {
		return casesOfLossBack;
	}

	/**
	 * ������ʧ�һ��趨
	 * @param casesOfLossBack ������ʧ�һ�
	 */
	public void setCasesOfLossBack(Integer casesOfLossBack) {
		this.casesOfLossBack = casesOfLossBack;
	}

	/**
	 * �����Э��ȡ��
	 * @return computerHelp �����Э��
	 */
	public Integer getComputerHelp() {
		return computerHelp;
	}

	/**
	 * �����Э���趨
	 * @param computerHelp �����Э��
	 */
	public void setComputerHelp(Integer computerHelp) {
		this.computerHelp = computerHelp;
	}

	/**
	 * ��ʿ����վȡ��
	 * @return nurseWorkstation ��ʿ����վ
	 */
	public Integer getNurseWorkstation() {
		return nurseWorkstation;
	}

	/**
	 * ��ʿ����վ�趨
	 * @param nurseWorkstation ��ʿ����վ
	 */
	public void setNurseWorkstation(Integer nurseWorkstation) {
		this.nurseWorkstation = nurseWorkstation;
	}

	/**
	 * ��ظ澯ȡ��
	 * @return prossessingErrorAlarm ��ظ澯
	 */
	public Integer getProssessingErrorAlarm() {
		return prossessingErrorAlarm;
	}

	/**
	 * ��ظ澯�趨
	 * @param prossessingErrorAlarm ��ظ澯
	 */
	public void setProssessingErrorAlarm(Integer prossessingErrorAlarm) {
		this.prossessingErrorAlarm = prossessingErrorAlarm;
	}
}
