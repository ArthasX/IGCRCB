/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.nms.model.NMS09Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �û�������ͼ��Ϣʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
@Entity
@Table(name="NMS09")
public class NMS09TB extends BaseEntity implements NMS09Info {

	/** ���� */
	@Id
	@TableGenerator(
			name="NMS09_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="NMS09_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE,generator="NMS09_TABLE_GENERATOR")
	protected Integer id;
	
	/** ��ID */
	protected Integer gid;
	
	/** ��汾 */
	protected Integer gversion;
	
	/** �û�ID */
	protected String userid;
	
	/** ����ͼ */
	protected String xml;
	
	/** ����� */
	protected String width;
	
	/** ���߶� */
	protected String height;
	
	/** ����ʱ�� */
	protected String instime;
	
	/** ����չ�����ͣ�1��ȫ������ͼ 2�������豸����ͼ�� */
	protected String showtype;
	
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
	 * ��IDȡ��
	 * @return gid ��ID
	 */
	public Integer getGid() {
		return gid;
	}

	/**
	 * ��ID�趨
	 * @param gid ��ID
	 */
	public void setGid(Integer gid) {
		this.gid = gid;
	}

	/**
	 * ��汾ȡ��
	 * @return gversion ��汾
	 */
	public Integer getGversion() {
		return gversion;
	}

	/**
	 * ��汾�趨
	 * @param gversion ��汾
	 */
	public void setGversion(Integer gversion) {
		this.gversion = gversion;
	}

	/**
	 * �û�IDȡ��
	 * @return userid �û�ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * �û�ID�趨
	 * @param userid �û�ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * ����ͼȡ��
	 * @return xml ����ͼ
	 */
	public String getXml() {
		return xml;
	}

	/**
	 * ����ͼ�趨
	 * @param xml ����ͼ
	 */
	public void setXml(String xml) {
		this.xml = xml;
	}

	/**
     * ��ȡ�����
     * @return ����� 
     */
    public String getWidth() {
        return width;
    }

    /**
     * ���������
     * @param width �����
     */
    public void setWidth(String width) {
        this.width = width;
    }

    /**
     * ��ȡ���߶�
     * @return ���߶� 
     */
    public String getHeight() {
        return height;
    }

    /**
     * �������߶�
     * @param height ���߶�
     */
    public void setHeight(String height) {
        this.height = height;
    }

    /**
	 * ����ʱ��ȡ��
	 * @return instime ����ʱ��
	 */
	public String getInstime() {
		return instime;
	}

	/**
	 * ����ʱ���趨
	 * @param instime ����ʱ��
	 */
	public void setInstime(String instime) {
		this.instime = instime;
	}

    /**
     * ��ȡ����չ�����ͣ�1��ȫ������ͼ2�������豸����ͼ��
     * @return ����չ�����ͣ�1��ȫ������ͼ2�������豸����ͼ�� 
     */
    public String getShowtype() {
        return showtype;
    }

    /**
     * ��������չ�����ͣ�1��ȫ������ͼ2�������豸����ͼ��
     * @param showtype ����չ�����ͣ�1��ȫ������ͼ2�������豸����ͼ��
     */
    public void setShowtype(String showtype) {
        this.showtype = showtype;
    }

    /**
	 * ����ȡ��
	 * @return ����
	 */
	public Serializable getPK() {
		return this.id;
	}

}
