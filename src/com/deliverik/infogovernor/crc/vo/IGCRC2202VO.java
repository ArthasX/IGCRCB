/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.crc.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;


/**	
 * ����: ���ͳ��ҳ����ʾ��
 * ������¼��yukexin    2014-8-20 10:12:18
 * �޸ļ�¼��null
 */	
public class IGCRC2202VO extends BaseVO implements Serializable {

	private static final long serialVersionUID = 1L;
	/** ���� */
	private String typeId;
	
	/** ������ */
	private String typeName;

	/** ���� */
	private Integer totalnum;

	/** ����ͨ������ */
	private Integer passnum;

	/** ����ͨ���� */
	private String passrate;

	/** �ɹ����� */
	private Integer successnum;

	/** �ɹ��� */
	private String successrate;

	/**
	 * ����ȡ��
	 * @return typeId  ����
	 */
	public String getTypeId() {
		return typeId;
	}
	public IGCRC2202VO() {
		super();
	}

	public IGCRC2202VO(String typeId, String typeName, Integer totalnum,
			Integer passnum, String passrate, Integer successnum,
			String successrate) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
		this.totalnum = totalnum;
		this.passnum = passnum;
		this.passrate = passrate;
		this.successnum = successnum;
		this.successrate = successrate;
	}
	
	/**
	 * �����趨
	 * @param typeId  ����
	 */
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	/**
	 * ������ȡ��
	 * @return typeName  ������
	 */
	public String getTypeName() {
		return typeName;
	}

	/**
	 * �������趨
	 * @param typeName  ������
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	/**
	 * ����ȡ��
	 * @return totalnum  ����
	 */
	public Integer getTotalnum() {
		return totalnum;
	}

	/**
	 * �����趨
	 * @param totalnum  ����
	 */
	public void setTotalnum(Integer totalnum) {
		this.totalnum = totalnum;
	}

	/**
	 * ����ͨ������ȡ��
	 * @return passnum  ����ͨ������
	 */
	public Integer getPassnum() {
		return passnum;
	}

	/**
	 * ����ͨ�������趨
	 * @param passnum  ����ͨ������
	 */
	public void setPassnum(Integer passnum) {
		this.passnum = passnum;
	}

	/**
	 * ����ͨ����ȡ��
	 * @return passrate  ����ͨ����
	 */
	public String getPassrate() {
		return passrate;
	}

	/**
	 * ����ͨ�����趨
	 * @param passrate  ����ͨ����
	 */
	public void setPassrate(String passrate) {
		this.passrate = passrate;
	}

	/**
	 * �ɹ�����ȡ��
	 * @return successnum  �ɹ�����
	 */
	public Integer getSuccessnum() {
		return successnum;
	}

	/**
	 * �ɹ������趨
	 * @param successnum  �ɹ�����
	 */
	public void setSuccessnum(Integer successnum) {
		this.successnum = successnum;
	}

	/**
	 * �ɹ���ȡ��
	 * @return successrate  �ɹ���
	 */
	public String getSuccessrate() {
		return successrate;
	}

	/**
	 * �ɹ����趨
	 * @param successrate  �ɹ���
	 */
	public void setSuccessrate(String successrate) {
		this.successrate = successrate;
	}

}
