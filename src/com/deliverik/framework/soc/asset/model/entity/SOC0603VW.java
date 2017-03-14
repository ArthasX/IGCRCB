package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.soc.asset.model.SOC0603Info;

/**
 * <p>
 * ������ͼ��Ϣʵ��
 * </p>
 */
@Entity
@org.hibernate.annotations.Entity(mutable=false)
@Table(name = "SOC0603")
@SuppressWarnings("serial")
//public class ComputerContainerVW extends BaseEntity implements Serializable, ComputerContainerVWInfo {
public class SOC0603VW implements Serializable, Cloneable, SOC0603Info {

	/** ����ID */
	@Id
	protected Integer eiid;
	
	/** �ʲ�ģ��ID */
	protected String eid;
	
	/** �������� */
	protected String einame;
	
	/** ������ */
	protected String eilabel;
	
	/** ����˵�� */
	protected String eidesc;
	
	/** ����汾�� */
	protected Integer eiversion;
	
	/** �Ǽ��� */
	protected String eiinsdate;
	
	/** ����λ�ã�X�� */
	protected String x_value;
	
	/** ����λ�ã�Y�� */
	protected String y_value;
	
	/** ������λ�� */
	protected String u_value;
	
	/** ����߶ȣ�U�� */
	protected String u_total;
	
	/** �������� */
	protected String x_width;
	
	/** ��������� */
	protected String y_width;
	
	/** ��������ID */
	protected Integer room_eiid;
	
	/** ����������� */
	protected String room_eilabel;
	
	/** ���������� */
	protected String room_einame;

	/** ������ʾͼ�ã��� */
	protected String graphindex;
	
	/** ������ʾͼ�ã��Ƿ������� */
	protected String graphstatus;
	
	/** ������ʾͼ�ã����ͱ�ʶ */
	protected String graphtypeid;
	
	/** ������ʾͼ�ã��������� */
	protected String graphtypename;

	/** ���ѹ */
	protected String voltage;

	/** �������� */
	protected String weight;

	/** ������ */
	protected String standard;
	
	/** �ʲ����ͣ��յ�����������ʽ��ʽ�� */
	protected String eitype;
	
	/** ���ܺ���U�� */
	protected String width;
	
	/** �������� */
	protected String containertype;

	/** �����*/
	protected String maxload;
	
	/** ������*/
	protected String maxpower;

	/** ʣ��U��*/
	protected Integer u_last;
	
	/** ʣ�๦��*/
	protected Integer power_last;
	
	/** ʣ������*/
	protected Integer load_last;
	
	/**
	 * ����ȡ��
	 * @return 
	 */
	public Serializable getPK() {
		return eiid;
	}

	/**
	 * ����IDȡ��
	 * @return ����ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * ����ID�趨
	 *
	 * @param eiid ����ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * �ʲ�ģ��IDȡ��
	 * @return �ʲ�ģ��ID
	 */
	public String getEid() {
		return eid;
	}

	/**
	 * �ʲ�ģ��ID�趨
	 *
	 * @param eid �ʲ�ģ��ID
	 */
	public void setEid(String eid) {
		this.eid = eid;
	}

	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * ���������趨
	 *
	 * @param einame ��������
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * ����˵��ȡ��
	 * @return ����˵��
	 */
	public String getEidesc() {
		return eidesc;
	}

	/**
	 * ����˵���趨
	 *
	 * @param eidesc ����˵��
	 */
	public void setEidesc(String eidesc) {
		this.eidesc = eidesc;
	}

	/**
	 * ������ȡ��
	 * @return ������
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * �������趨
	 *
	 * @param eilabel ������
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * ����汾��ȡ��
	 * @return ����汾��
	 */
	public Integer getEiversion() {
		return eiversion;
	}

	/**
	 * ����汾���趨
	 *
	 * @param eiversion ����汾��
	 */
	public void setEiversion(Integer eiversion) {
		this.eiversion = eiversion;
	}

	/**
	 * �Ǽ���ȡ��
	 * @return �Ǽ���
	 */
	public String getEiinsdate() {
		return eiinsdate;
	}

	/**
	 * �Ǽ����趨
	 *
	 * @param eiinsdate �Ǽ���
	 */
	public void setEiinsdate(String eiinsdate) {
		this.eiinsdate = eiinsdate;
	}

	/**
	 * ����λ�ã�X��ȡ��
	 * @return ����λ�ã�X��
	 */
	public String getX_value() {
		return x_value;
	}

	/**
	 * ����λ�ã�X���趨
	 *
	 * @param x_value ����λ�ã�X��
	 */
	public void setX_value(String x_value) {
		this.x_value = x_value;
	}

	/**
	 * ����λ�ã�Y��ȡ��
	 * @return ����λ�ã�Y��
	 */
	public String getY_value() {
		return y_value;
	}

	/**
	 * ����λ�ã�Y���趨
	 *
	 * @param y_value ����λ�ã�Y��
	 */
	public void setY_value(String y_value) {
		this.y_value = y_value;
	}

	/**
	 * ����߶ȣ�U��ȡ��
	 * @return ����߶ȣ�U��
	 */
	public String getU_total() {
		return u_total;
	}

	/**
	 * ����߶ȣ�U���趨
	 *
	 * @param u_total ����߶ȣ�U��
	 */
	public void setU_total(String u_total) {
		this.u_total = u_total;
	}

	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getX_width() {
		return x_width;
	}

	/**
	 * ���������趨
	 *
	 * @param x_width ��������
	 */
	public void setX_width(String x_width) {
		this.x_width = x_width;
	}

	/**
	 * ���������ȡ��
	 * @return ���������
	 */
	public String getY_width() {
		return y_width;
	}

	/**
	 * ����������趨
	 *
	 * @param y_width ���������
	 */
	public void setY_width(String y_width) {
		this.y_width = y_width;
	}

	/**
	 * ��������IDȡ��
	 * @return ��������ID
	 */
	public Integer getRoom_eiid() {
		return room_eiid;
	}

	/**
	 * ��������ID�趨
	 *
	 * @param room_eiid ��������ID
	 */
	public void setRoom_eiid(Integer room_eiid) {
		this.room_eiid = room_eiid;
	}

	/**
	 * �����������ȡ��
	 * @return �����������
	 */
	public String getRoom_eilabel() {
		return room_eilabel;
	}

	/**
	 * ������������趨
	 *
	 * @param room_eilabel �����������
	 */
	public void setRoom_eilabel(String room_eilabel) {
		this.room_eilabel = room_eilabel;
	}

	/**
	 * ����������ȡ��
	 * @return ����������
	 */
	public String getRoom_einame() {
		return room_einame;
	}

	/**
	 * �����������趨
	 *
	 * @param room_einame ����������
	 */
	public void setRoom_einame(String room_einame) {
		this.room_einame = room_einame;
	}

	/**
	 * ������ʾͼ�ã���ȡ��
	 * 
	 * @return ��
	 */
	public String getGraphindex() {
		return graphindex;
	}

	/**
	 * ������ʾͼ�ã����趨
	 * 
	 * @param graphindex ��
	 */
	public void setGraphindex(String graphindex) {
		this.graphindex = graphindex;
	}

	/**
	 * ������ʾͼ�ã��Ƿ�������ȡ��
	 * 
	 * @return �Ƿ�������
	 */
	public String getGraphstatus() {
		return graphstatus;
	}

	/**
	 * ������ʾͼ�ã��Ƿ��������趨
	 * 
	 * @param graphstatus �Ƿ�������
	 */
	public void setGraphstatus(String graphstatus) {
		this.graphstatus = graphstatus;
	}

	/**
	 * ������ʾͼ�ã����ͱ�ʶȡ��
	 * 
	 * @return ���ͱ�ʶ
	 */
	public String getGraphtypeid() {
		return graphtypeid;
	}

	/**
	 * ������ʾͼ�ã����ͱ�ʶ�趨
	 * 
	 * @param graphtypeid ���ͱ�ʶ
	 */
	public void setGraphtypeid(String graphtypeid) {
		this.graphtypeid = graphtypeid;
	}

	/**
	 * ������ʾͼ�ã���������ȡ��
	 * 
	 * @return ��������
	 */
	public String getGraphtypename() {
		return graphtypename;
	}

	/**
	 * ������ʾͼ�ã����������趨
	 * 
	 * @param graphtypename ��������
	 */
	public void setGraphtypename(String graphtypename) {
		this.graphtypename = graphtypename;
	}

	/**
	 * ���ѹȡ��
	 * 
	 * @return ���ѹ
	 */
	public String getVoltage() {
		return voltage;
	}

	/**
	 * ���ѹ�趨
	 * 
	 * @param voltage ���ѹ
	 */
	public void setVoltage(String voltage) {
		this.voltage = voltage;
	}

	/**
	 * ��������ȡ��
	 * 
	 * @return ��������
	 */
	public String getWeight() {
		return weight;
	}

	/**
	 * ���������趨
	 * 
	 * @param weight ��������
	 */
	public void setWeight(String weight) {
		this.weight = weight;
	}

	/**
	 * ������ȡ��
	 * 
	 * @return ������
	 */
	public String getStandard() {
		return standard;
	}

	/**
	 * �������趨
	 * 
	 * @param standard ������
	 */
	public void setStandard(String standard) {
		this.standard = standard;
	}

	/**
	 * ������λ��ȡ��
	 * 
	 * @return ������λ��
	 */
	public String getU_value() {
		return u_value;
	}

	/**
	 * ������λ���趨
	 * 
	 * @param standard ������λ��
	 */
	public void setU_value(String u_value) {
		this.u_value = u_value;
	}

	/**
	 * �ʲ����ͣ��յ�����������ʽ��ʽ��ȡ��
	 * 
	 * @return �ʲ����ͣ��յ�����������ʽ��ʽ��
	 */
	public String getEitype() {
		return eitype;
	}

	/**
	 * �ʲ����ͣ��յ�����������ʽ��ʽ���趨
	 * 
	 * @param standard �ʲ����ͣ��յ�����������ʽ��ʽ��
	 */
	public void setEitype(String eitype) {
		this.eitype = eitype;
	}

	/**
	 * ��������ȡ��
	 * 
	 * @return ��������
	 */
	public String getContainertype() {
		return containertype;
	}

	/**
	 * ���������趨
	 * 
	 * @param standard ��������
	 */
	public void setContainertype(String containertype) {
		this.containertype = containertype;
	}

	/**
	 * ���ܺ���U��ȡ��
	 * 
	 * @return ���ܺ���U��
	 */
	public String getWidth() {
		return width;
	}
	
	/**
	 * ���ܺ���U���趨
	 * 
	 * @param standard ���ܺ���U��
	 */
	public void setWidth(String width) {
		this.width = width;
	}

    /**
     * �����ȡ��
     *
     * @return maxload �����
     */
    public String getMaxload() {
        return maxload;
    }

    /**
     * ������ȡ��
     *
     * @return maxpower ������
     */
    public String getMaxpower() {
        return maxpower;
    }

    /**
     * ������趨
     *
     * @param maxload �����
     */
    public void setMaxload(String maxload) {
        this.maxload = maxload;
    }

    /**
     * �������趨
     *
     * @param maxpower ������
     */
    public void setMaxpower(String maxpower) {
        this.maxpower = maxpower;
    }

    /**
     * ʣ��U��ȡ��
     *
     * @return u_last ʣ��U��
     */
    public Integer getU_last() {
        return u_last;
    }

    /**
     * ʣ�๦��ȡ��
     *
     * @return power_last ʣ�๦��
     */
    public Integer getPower_last() {
        return power_last;
    }

    /**
     * ʣ������ȡ��
     *
     * @return load_last ʣ������
     */
    public Integer getLoad_last() {
        return load_last;
    }

    /**
     * ʣ��U���趨
     *
     * @param u_last ʣ��U��
     */
    public void setU_last(Integer u_last) {
        this.u_last = u_last;
    }

    /**
     * ʣ�๦���趨
     *
     * @param power_last ʣ�๦��
     */
    public void setPower_last(Integer power_last) {
        this.power_last = power_last;
    }

    /**
     * ʣ�������趨
     *
     * @param load_last ʣ������
     */
    public void setLoad_last(Integer load_last) {
        this.load_last = load_last;
    }

	
}