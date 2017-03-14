/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dut.form;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.infogovernor.dut.model.OnDutyPersonRecordInfo;

/**
 * ����: �ճ�ά���Ǽǻ���Form
 * ��������: �ճ�ά���Ǽǻ���Form
 * ������¼: 2012/04/01
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGDUT0304Form extends BaseForm implements OnDutyPersonRecordInfo{
    
	/** ���������б� */
	protected List<CodeDetail> codeDetailList;
	
	/**
	 * ���������б�ȡ��
	 *
	 * @return codeDetailList ���������б�
	 */
	public List<CodeDetail> getCodeDetailList() {
		return codeDetailList;
	}

	/**
	 * ���������б��趨
	 *
	 * @param codeDetailList ���������б�
	 */
	public void setCodeDetailList(List<CodeDetail> codeDetailList) {
		this.codeDetailList = codeDetailList;
	}

	/** �ճ�ά���ǼǱ����� */
    protected Integer odprid;
    
    /** ������Ա */
    protected String odprguest;
    
    /** ������λ */
    protected String odprguestorg;
    
    /** ���֤�� */
    protected String odprguestidnum;
    
    /** �������� */
    protected String odprarea;
    
    /** ��������checkbox */
    protected String[] odprareas;
    
    /** ����ʱ�� */
    protected String odprctime;
    
    /** �뿪ʱ�� */
    protected String odprltime;
    
    /** ������ */
    protected String odpropter;
    
    /** ��׼�� */
    protected String odpracter;
    
    /** ��¼�� */
    protected String odprusername;
    
    /** ����Ŀ�� */
    protected String odprtarget;
    
    /** ������¼ */
    protected String odprrecord;
    
    /** ��¼ʱ�� */
    protected String odprinserttime;
    
    /** �༭ʱ�� */
    protected String odprmodtime;
    
    /** ���or���� ģʽ */
    protected int mode=0;//��ʼ�����ģʽ

    /**
	 * ���or����ģʽȡ��
	 *
	 * @return mode ���or����ģʽ
	 */
	public int getMode() {
		return mode;
	}

	/**
	 * ���or����ģʽ�趨
	 *
	 * @param mode ���or����ģʽ
	 */
	public void setMode(int mode) {
		this.mode = mode;
	}

	/**
     * odpridȡ��
     *
     * @return odprid odprid
     */
    public Integer getOdprid() {
        return odprid;
    }

    /**
     * odprid�趨
     *
     * @param odprid odprid
     */
    public void setOdprid(Integer odprid) {
        this.odprid = odprid;
    }

    /**
     * ������Աȡ��
     *
     * @return odprguest ������Ա
     */
    public String getOdprguest() {
        return odprguest;
    }

    /**
     * ������Ա�趨
     *
     * @param odprguest ������Ա
     */
    public void setOdprguest(String odprguest) {
        this.odprguest = odprguest;
    }

    /**
     * ������λȡ��
     *
     * @return odprguestorg ������λ
     */
    public String getOdprguestorg() {
        return odprguestorg;
    }

    /**
     * ������λ�趨
     *
     * @param odprguestorg ������λ
     */
    public void setOdprguestorg(String odprguestorg) {
        this.odprguestorg = odprguestorg;
    }

    /**
     * ���֤��ȡ��
     *
     * @return odprguestidnum ���֤��
     */
    public String getOdprguestidnum() {
        return odprguestidnum;
    }

    /**
     * ���֤���趨
     *
     * @param odprguestidnum ���֤��
     */
    public void setOdprguestidnum(String odprguestidnum) {
        this.odprguestidnum = odprguestidnum;
    }



    /**
	 * ��������ȡ��
	 *
	 * @return odprarea ��������
	 */
	public String getOdprarea() {
		return odprarea;
	}

	/**
	 * ��������checkboxȡ��
	 *
	 * @return odprareas ��������checkbox
	 */
	public String[] getOdprareas() {
		return odprareas;
	}

	/**
	 * ��������checkbox�趨
	 *
	 * @param odprareas ��������checkbox
	 */
	public void setOdprareas(String[] odprareas) {
		this.odprareas = odprareas;
	}

	/**
	 * ���������趨
	 *
	 * @param odprarea ��������
	 */
	public void setOdprarea(String odprarea) {
		this.odprarea = odprarea;
	}

	/**
     * ����ʱ��ȡ��
     *
     * @return odprctime ����ʱ��
     */
    public String getOdprctime() {
        return odprctime;
    }

    /**
     * ����ʱ���趨
     *
     * @param odprctime ����ʱ��
     */
    public void setOdprctime(String odprctime) {
        this.odprctime = odprctime;
    }

    /**
     * �뿪ʱ��ȡ��
     *
     * @return odprltime �뿪ʱ��
     */
    public String getOdprltime() {
        return odprltime;
    }

    /**
     * �뿪ʱ���趨
     *
     * @param odprltime �뿪ʱ��
     */
    public void setOdprltime(String odprltime) {
        this.odprltime = odprltime;
    }

    /**
     * ������ȡ��
     *
     * @return odpropter ������
     */
    public String getOdpropter() {
        return odpropter;
    }

    /**
     * �������趨
     *
     * @param odpropter ������
     */
    public void setOdpropter(String odpropter) {
        this.odpropter = odpropter;
    }

    /**
     * ��׼��ȡ��
     *
     * @return odpracter ��׼��
     */
    public String getOdpracter() {
        return odpracter;
    }

    /**
     * ��׼���趨
     *
     * @param odpracter ��׼��
     */
    public void setOdpracter(String odpracter) {
        this.odpracter = odpracter;
    }

    /**
     * ��¼��ȡ��
     *
     * @return odprusername ��¼��
     */
    public String getOdprusername() {
        return odprusername;
    }

    /**
     * ��¼���趨
     *
     * @param odprusername ��¼��
     */
    public void setOdprusername(String odprusername) {
        this.odprusername = odprusername;
    }

    /**
     * ����Ŀ��ȡ��
     *
     * @return odprtarget ����Ŀ��
     */
    public String getOdprtarget() {
        return odprtarget;
    }

    /**
     * ����Ŀ���趨
     *
     * @param odprtarget ����Ŀ��
     */
    public void setOdprtarget(String odprtarget) {
        this.odprtarget = odprtarget;
    }

    /**
     * ������¼ȡ��
     *
     * @return odprrecord ������¼
     */
    public String getOdprrecord() {
        return odprrecord;
    }

    /**
     * ������¼�趨
     *
     * @param odprrecord ������¼
     */
    public void setOdprrecord(String odprrecord) {
        this.odprrecord = odprrecord;
    }

    /**
     * ��¼ʱ��ȡ��
     *
     * @return odprinserttime ��¼ʱ��
     */
    public String getOdprinserttime() {
        return odprinserttime;
    }

    /**
     * ��¼ʱ���趨
     *
     * @param odprinserttime ��¼ʱ��
     */
    public void setOdprinserttime(String odprinserttime) {
        this.odprinserttime = odprinserttime;
    }

    /**
     * �༭ʱ��ȡ��
     *
     * @return odprmodtime �༭ʱ��
     */
    public String getOdprmodtime() {
        return odprmodtime;
    }

    /**
     * �༭ʱ���趨
     *
     * @param odprmodtime �༭ʱ��
     */
    public void setOdprmodtime(String odprmodtime) {
        this.odprmodtime = odprmodtime;
    }

    /**
     * 
     *
     * @return
     */
    public Serializable getPK() {
        // TODO Auto-generated method stub
        return odprid;
    }
    
	public String getFingerPrint() {
		// TODO Auto-generated method stub
		return null;
	}

    
}


