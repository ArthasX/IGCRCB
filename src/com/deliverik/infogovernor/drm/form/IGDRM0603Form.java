package com.deliverik.infogovernor.drm.form;
/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �����ƻ���Ŀ����Form
 * </p>
 * 
 * @author sunkaiyu@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGDRM0603Form extends BaseForm{
    //id
    protected Integer did;
    //����id
    protected String[] diid;

    /** ����Ԥ�ڿ�ʼʱ�� */
    protected String[] expecttime;

    /** �������� */
    protected String[] diname;

    /** �������� */
    protected String[] dicontant;

    /** ����Ŀ�� */
    protected String[] didestination;

    /** �������� */
    protected String[] discene;

    /** Ӱ�췶Χ */
    protected String[] discope;

    /** ���������� */
    protected String[] didutyorg;

    /** ���벿�� */
    protected String[] partorg;
    
    /** ���ر�ʶ */
    protected String flag;

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String[] getDiid() {
        return diid;
    }

    public void setDiid(String[] diid) {
        this.diid = diid;
    }

    public String[] getExpecttime() {
        return expecttime;
    }

    public void setExpecttime(String[] expecttime) {
        this.expecttime = expecttime;
    }

    public String[] getDiname() {
        return diname;
    }

    public void setDiname(String[] diname) {
        this.diname = diname;
    }

    public String[] getDicontant() {
        return dicontant;
    }

    public void setDicontant(String[] dicontant) {
        this.dicontant = dicontant;
    }

    public String[] getDidestination() {
        return didestination;
    }

    public void setDidestination(String[] didestination) {
        this.didestination = didestination;
    }

    public String[] getDiscene() {
        return discene;
    }

    public void setDiscene(String[] discene) {
        this.discene = discene;
    }

    public String[] getDiscope() {
        return discope;
    }

    public void setDiscope(String[] discope) {
        this.discope = discope;
    }

    public String[] getDidutyorg() {
        return didutyorg;
    }

    public void setDidutyorg(String[] didutyorg) {
        this.didutyorg = didutyorg;
    }

    public String[] getPartorg() {
        return partorg;
    }

    public void setPartorg(String[] partorg) {
        this.partorg = partorg;
    }

	/**
	 * flagȡ��
	 *
	 * @return flag flag
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * flag�趨
	 *
	 * @param flag flag
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}
    
}
