/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dut.model.condition;

/**
 * ����: �ճ�ά����ѯ����ʵ��
 * ��������: �ճ�ά����ѯ����ʵ��
 * ������¼: 2012/04/01
 * �޸ļ�¼: 
 */
public class OnDutyPersonRecordSearchCondImpl implements OnDutyPersonRecordSearchCond{
	
    /** ��������ѯ */
    protected Integer odprid_eq;
    
	/** ��ѯ�ؼ��� */
	protected String keywords_like;
	
	protected String odprctime_ge;
	
	protected String odprctime_le;


    /**
     * ��ѯ�ؼ���ȡ��
     *
     * @return keywords_like ��ѯ�ؼ���
     */
    public String getKeywords_like() {
        return keywords_like;
    }

    /**
     * ��ѯ�ؼ����趨
     *
     * @param keywords_like ��ѯ�ؼ���
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
     * ��������ѯȡ��
     *
     * @return odprid_eq ��������ѯ
     */
    public Integer getOdprid_eq() {
        return odprid_eq;
    }

    /**
     * ��������ѯ�趨
     *
     * @param odprid_eq ��������ѯ
     */
    public void setOdprid_eq(Integer odprid_eq) {
        this.odprid_eq = odprid_eq;
    }
	
	
}
