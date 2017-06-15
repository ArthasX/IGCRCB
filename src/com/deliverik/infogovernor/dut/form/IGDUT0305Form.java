/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dut.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.dut.model.condition.OnDutyPersonRecordSearchCond;

/**
 * ����: �ճ�ά����ѯ����Form
 * ��������: �ճ�ά����ѯ����Form
 * ������¼: 2012/04/01
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGDUT0305Form extends BaseForm implements OnDutyPersonRecordSearchCond{
	
	
	/** ����ɾ��id���� */
	protected String[] delall;

	/** �����ؼ��� */
	protected String keywords_like;
	
	/** ��ʼָ������ */
	protected String odprctime_ge;
	
	/** ����ָ������ */
	protected String odprctime_le;	
	
    /** ��������ѯȡ�� */
	protected Integer odprid_eq;
	
	


    /**
	 * ��������ѯȡ��ȡ��
	 *
	 * @return odprid_eq ��������ѯȡ��
	 */
	public Integer getOdprid_eq() {
		return odprid_eq;
	}

	/**
	 * ��������ѯȡ���趨
	 *
	 * @param odprid_eq ��������ѯȡ��
	 */
	public void setOdprid_eq(Integer odprid_eq) {
		this.odprid_eq = odprid_eq;
	}

	/**
     * �����ؼ���ȡ��
     *
     * @return keywords_like �����ؼ���
     */
    public String getKeywords_like() {
        return keywords_like;
    }

    /**
     * �����ؼ����趨
     *
     * @param keywords_like �����ؼ���
     */
    public void setKeywords_like(String keywords_like) {
        this.keywords_like = keywords_like;
    }

    /**
     * ʱ���������� ȡ��
     * @return ʱ����������
     */
	public String getOdprctime_ge() {
		return odprctime_ge;
	}

	/**
	 * ʱ�����������趨
	 * @param odprctime_geʱ����������
	 */
	public void setOdprctime_ge(String odprctime_ge) {
		this.odprctime_ge = odprctime_ge;
	}

	/**
	 * ʱ����������ȡ��
	 * @return ʱ����������
	 */
	public String getOdprctime_le() {
		return odprctime_le;
	}

	/**
	 * ʱ�����������趨
	 * @param odprctime_leʱ����������
	 */
	public void setOdprctime_le(String odprctime_le) {
		this.odprctime_le = odprctime_le;
	}

	/**
	 * ����ɾ��id����ȡ��
	 *
	 * @return delall ����ɾ��id����
	 */
	public String[] getDelall() {
		return delall;
	}

	/**
	 * ����ɾ��id�����趨
	 *
	 * @param delall ����ɾ��id����
	 */
	public void setDelall(String[] delall) {
		this.delall = delall;
	}


}
    

