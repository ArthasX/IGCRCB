/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.vo;

import com.deliverik.framework.base.BaseVO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description:����Դ���ݰ汾�Ƚ���Ϣvo 
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGCIM01112VO extends BaseVO{

	/** ���� */
	protected String category;
	
	/** �ؼ��� */
	protected String keys;
	
	/** �ɼ����� */
	protected String command;
	
	/** ���Ƚ����� */
	protected String compare1;
	
	/** �Ƚ����� */
	protected String compare2;
	
	/** �ȽϽ����ʾ��ʽ */
	protected String compareStyle;

	/**
	 * ����ȡ��
	 * @return ����
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * �����趨
	 * @param category ����
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * �ؼ���ȡ��
	 * @return �ؼ���
	 */
	public String getKeys() {
		return keys;
	}

	/**
	 * �ؼ����趨
	 * @param keys �ؼ���
	 */
	public void setKeys(String keys) {
		this.keys = keys;
	}
	
	/**
	 * �ɼ�����ȡ��
	 * @return �ɼ�����
	 */
	public String getCommand() {
		return command;
	}

	/**
	 * �ɼ������趨
	 * @param command �ɼ�����
	 */
	public void setCommand(String command) {
		this.command = command;
	}

	/**
	 * ���Ƚ�����ȡ��
	 * @return ���Ƚ�����
	 */
	public String getCompare1() {
		return compare1;
	}

	/**
	 * ���Ƚ������趨
	 * @param compare1 ���Ƚ�����
	 */
	public void setCompare1(String compare1) {
		this.compare1 = compare1;
	}

	/**
	 * �Ƚ�����ȡ��
	 * @return �Ƚ�����
	 */
	public String getCompare2() {
		return compare2;
	}

	/**
	 * �Ƚ������趨
	 * @param compare2 �Ƚ�����
	 */
	public void setCompare2(String compare2) {
		this.compare2 = compare2;
	}

	/**
	 * �ȽϽ����ʾ��ʽȡ��
	 * @return �ȽϽ����ʾ��ʽ
	 */
	public String getCompareStyle() {
		return compareStyle;
	}

	/**
	 * �ȽϽ����ʾ��ʽ�趨
	 * @param compareStyle �ȽϽ����ʾ��ʽ
	 */
	public void setCompareStyle(String compareStyle) {
		this.compareStyle = compareStyle;
	}
	
	
}
