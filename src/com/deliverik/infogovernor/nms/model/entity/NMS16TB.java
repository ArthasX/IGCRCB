/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.nms.model.NMS16Info;
import com.deliverik.infogovernor.nms.model.dao.annotation.FieldType;
import com.deliverik.infogovernor.nms.model.dao.annotation.Fk;
import com.deliverik.infogovernor.nms.model.dao.annotation.TableSpace;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���豸������Ϣʵ��
 * </p>
 * 
 * @version 1.0
 */
@SuppressWarnings("serial")
@Entity
@Table(name="NMS16")
@TableSpace(name="ig_space")
public class NMS16TB extends BaseEntity implements NMS16Info {

    /** ���� */
    @FieldType(value="VARCHAR(36)")
    @Id
    protected String id;
    
	/** ��ID */
	@FieldType(value="INTEGER")
	@Fk(tablename="NMS01",fkfield="ID",deleteCascade=true,updateCascade=true)
	protected Integer gid;
	
	/** �豸ID */
	@FieldType(value="VARCHAR(128)")
	@Fk(tablename="NMS04",fkfield="ID",deleteCascade=true,updateCascade=true)
	protected String did;
	
	/** ��汾 */
	@FieldType(value="INTEGER")
	protected Integer gversion;
	
	/** �û�id */
	@FieldType(value="VARCHAR(16)")
	protected String userid;
	
	/** X���� */
	@FieldType(value="VARCHAR(16)")
	protected String x;
	
	/** Y���� */
	@FieldType(value="VARCHAR(16)")
	protected String y;

    /** ����չ�����ͣ�1��ȫ������ͼ 2�������豸����ͼ�� */
	@FieldType(value="VARCHAR(2)")
    protected String showtype;
    
    /**
     * ��ȡ����
     * @return ���� 
     */
    public String getId() {
        return id;
    }

    /**
     * ��������
     * @param id ����
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * ��ȡ��ID
     * @return ��ID 
     */
    public Integer getGid() {
        return gid;
    }

    /**
     * ������ID
     * @param gid ��ID
     */
    public void setGid(Integer gid) {
        this.gid = gid;
    }

    /**
     * ��ȡ�豸ID
     * @return �豸ID 
     */
    public String getDid() {
        return did;
    }

    /**
     * �����豸ID
     * @param did �豸ID
     */
    public void setDid(String did) {
        this.did = did;
    }

    /**
     * ��ȡ��汾
     * @return ��汾 
     */
    public Integer getGversion() {
        return gversion;
    }

    /**
     * ������汾
     * @param gversion ��汾
     */
    public void setGversion(Integer gversion) {
        this.gversion = gversion;
    }

    /**
     * ��ȡ�û�id
     * @return �û�id 
     */
    public String getUserid() {
        return userid;
    }

    /**
     * �����û�id
     * @param userid �û�id
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * ��ȡX����
     * @return X���� 
     */
    public String getX() {
        return x;
    }

    /**
     * ����X����
     * @param x X����
     */
    public void setX(String x) {
        this.x = x;
    }

    /**
     * ��ȡY����
     * @return Y���� 
     */
    public String getY() {
        return y;
    }

    /**
     * ����Y����
     * @param y Y����
     */
    public void setY(String y) {
        this.y = y;
    }
    
    public Serializable getPK() {
        return this.id;
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


}
