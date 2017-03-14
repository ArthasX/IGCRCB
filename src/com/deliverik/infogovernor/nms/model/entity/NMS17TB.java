/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.nms.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.nms.model.NMS17Info;

/**
  * ����: ����������Ϣʵ��
  * ��������: ����������Ϣʵ��
  * ������¼: 2014/01/07
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="NMS17")
public class NMS17TB extends BaseEntity implements Serializable,
		Cloneable, NMS17Info {

	/** ���� */
	@Id
	protected String id;

	/** ���������� */
	protected Integer gid;

	/** ������汾 */
	protected Integer gversion;

	/** �����û���ȫ��ʱΪ�գ� */
	protected String userid;

	/** x���� */
	protected String x;

	/** y���� */
	protected String y;

	/** ��� */
	protected String width;

	/** �߶� */
	protected String height;
	
	/** ������� */
	protected String title;
	
	/** ��ת�Ƕ� */
	protected String rotation;

    /** ����չ�����ͣ�1��ȫ������ͼ 2�������豸����ͼ�� */
//    protected String showtype;
    
	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getId() {
		return id;
	}

	/**
	 * �����趨
	 *
	 * @param id ����
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * ����������ȡ��
	 *
	 * @return ����������
	 */
	public Integer getGid() {
		return gid;
	}

	/**
	 * �����������趨
	 *
	 * @param gid ����������
	 */
	public void setGid(Integer gid) {
		this.gid = gid;
	}

	/**
	 * ������汾ȡ��
	 *
	 * @return ������汾
	 */
	public Integer getGversion() {
		return gversion;
	}

	/**
	 * ������汾�趨
	 *
	 * @param gversion ������汾
	 */
	public void setGversion(Integer gversion) {
		this.gversion = gversion;
	}

	/**
	 * �����û���ȫ��ʱΪ�գ�ȡ��
	 *
	 * @return �����û���ȫ��ʱΪ�գ�
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * �����û���ȫ��ʱΪ�գ��趨
	 *
	 * @param userid �����û���ȫ��ʱΪ�գ�
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * x����ȡ��
	 *
	 * @return x����
	 */
	public String getX() {
		return x;
	}

	/**
	 * x�����趨
	 *
	 * @param x x����
	 */
	public void setX(String x) {
		this.x = x;
	}

	/**
	 * y����ȡ��
	 *
	 * @return y����
	 */
	public String getY() {
		return y;
	}

	/**
	 * y�����趨
	 *
	 * @param y y����
	 */
	public void setY(String y) {
		this.y = y;
	}

	/**
	 * ���ȡ��
	 *
	 * @return ���
	 */
	public String getWidth() {
		return width;
	}

	/**
	 * ����趨
	 *
	 * @param width ���
	 */
	public void setWidth(String width) {
		this.width = width;
	}

	/**
	 * �߶�ȡ��
	 *
	 * @return �߶�
	 */
	public String getHeight() {
		return height;
	}

	/**
	 * �߶��趨
	 *
	 * @param height �߶�
	 */
	public void setHeight(String height) {
		this.height = height;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return id;
	}

    /**
     * �������ȡ��
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * ��������趨
     * @param title title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * ��ȡ��ת�Ƕ�
     * @return ��ת�Ƕ� 
     */
    public String getRotation() {
        return rotation;
    }

    /**
     * ������ת�Ƕ�
     * @param rotation ��ת�Ƕ�
     */
    public void setRotation(String rotation) {
        this.rotation = rotation;
    }

}