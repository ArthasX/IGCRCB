package com.deliverik.infogovernor.crc.model.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.crc.dto.IGCRC02DTO;
import com.deliverik.infogovernor.crc.model.IgalarmInfo;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �澯��Ϣ��ѯVO
 * </p>
 * 
 * @author changhao@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGCRC0203VO extends BaseVO {
	
	/***
	 * �澯��Ϣ�б�
	 */
	private List<IgalarmInfo> igalarmInfos;
	
	/** �澯��Ϣ  */	
	private IgalarmInfo igalarmInfo;
	
	/** ������������״̬��(1Ϊ���� 2Ϊ����) */
	private String appnamestatus;
	
	/** ip��ַ����״̬��(1Ϊ���� 2Ϊ����) */
	private String ipaddrstatus;
	
	/** ����ʱ������״̬��(1Ϊ���� 2Ϊ����) */
	private String lasttimestatus;
	
	/** �ָ�ʱ������״̬��(1Ϊ���� 2Ϊ����) */
	private String recoverytimestatus;
	
	
	/***
	 * �澯��ϢVO��ʼ��
	 */
	public IGCRC0203VO(IGCRC02DTO dto){
		igalarmInfos = dto.getIgalarmInfos();
	}

	public IGCRC0203VO() {
		super();
	}

	/**
	 * �澯��Ϣ��ȡ
	 * @return �澯��Ϣ�б�
	 */
	public List<IgalarmInfo> getIgalarmInfos() {
		return igalarmInfos;
	}

	/**
	 * �澯��Ϣ����
	 * @param igalarmInfos �澯��Ϣ�б�
	 */
	public void setIgalarmInfos(List<IgalarmInfo> igalarmInfos) {
		this.igalarmInfos = igalarmInfos;
	}

	/**
	 * �澯��Ϣȡ��
	 * @return igalarmInfo  �澯��Ϣ
	 */
	public IgalarmInfo getIgalarmInfo() {
		return igalarmInfo;
	}

	/**
	 * �澯��Ϣ�趨
	 * @param igalarmInfo  �澯��Ϣ
	 */
	public void setIgalarmInfo(IgalarmInfo igalarmInfo) {
		this.igalarmInfo = igalarmInfo;
	}

	/**
	 * ������������״̬��(1Ϊ���� 2Ϊ����)ȡ��
	 * 
	 * @return ������������״̬��
	 */
	public String getAppnamestatus() {
		return appnamestatus;
	}

	/**
	 * ������������״̬��(1Ϊ���� 2Ϊ����)����
	 * 
	 * @param ������������״̬��
	 */
	public void setAppnamestatus(String appnamestatus) {
		this.appnamestatus = appnamestatus;
	}

	/**
	 * ip��ַ����״̬��(1Ϊ���� 2Ϊ����)ȡ��
	 * 
	 * @return ip��ַ����״̬��(1Ϊ���� 2Ϊ����)
	 */
	public String getIpaddrstatus() {
		return ipaddrstatus;
	}

	/**
	 * ip��ַ����״̬��(1Ϊ���� 2Ϊ����)����
	 * 
	 * @param  ip��ַ����״̬��(1Ϊ���� 2Ϊ����)
	 */
	public void setIpaddrstatus(String ipaddrstatus) {
		this.ipaddrstatus = ipaddrstatus;
	}

	/**
	 * ����ʱ������״̬��(1Ϊ���� 2Ϊ����)ȡ��
	 * 
	 * @return ����ʱ������״̬��(1Ϊ���� 2Ϊ����)
	 */
	public String getLasttimestatus() {
		return lasttimestatus;
	}

	/**
	 * ����ʱ������״̬��(1Ϊ���� 2Ϊ����)����
	 * 
	 * @param ����ʱ������״̬��(1Ϊ���� 2Ϊ����)
	 */
	public void setLasttimestatus(String lasttimestatus) {
		this.lasttimestatus = lasttimestatus;
	}

	/**
	 * �ָ�ʱ������״̬��(1Ϊ���� 2Ϊ����)ȡ��
	 * 
	 * @return �ָ�ʱ������״̬��(1Ϊ���� 2Ϊ����)
	 */
	public String getRecoverytimestatus() {
		return recoverytimestatus;
	}

	/**
	 * �ָ�ʱ������״̬��(1Ϊ���� 2Ϊ����)����
	 * 
	 * @param �ָ�ʱ������״̬��(1Ϊ���� 2Ϊ����)
	 */
	public void setRecoverytimestatus(String recoverytimestatus) {
		this.recoverytimestatus = recoverytimestatus;
	}

	
	
	
	
	
}
