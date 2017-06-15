/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.cic.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.cic.model.CompareobjectHistoryInfo;

/**
 * 概述: 对比对象历史表实体 功能描述: 对比对象历史表实体 创建记录: 2014/04/24 修改记录:
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "compareobject_h")
public class CompareobjectHistoryTB extends BaseEntity implements Serializable, Cloneable, CompareobjectHistoryInfo {

    /** 对象历史表主键 */
    @Id
    @GeneratedValue(generator = "cohid")
    @GenericGenerator(name = "cohid", strategy = "sequence", parameters = { @Parameter(name = "sequence", value = "compareobject_h_seq") })
    protected Integer cohid;

    /** 对象表主键 */
    protected Integer coid;

    /** 对比规则外键 */
    protected Integer fkCrid;

    /** 名称 */
    protected String coname;
    
    /** 对比源主机id */
    protected Integer cosource;

    /** 对比目标主机id */
    protected Integer cotarget;

    /** 源主机IP */
    protected String sourceIP;

    /** targetIP */
    protected String targetIP;

    /** 比对规则表版本 */
    protected Integer crversion;

    /**
     * 对象历史表主键取得
     * 
     * @return 对象历史表主键
     */
    public Integer getCohid() {
        return cohid;
    }

    /**
     * 对象历史表主键设定
     * 
     * @param cohid
     *            对象历史表主键
     */
    public void setCohid(Integer cohid) {
        this.cohid = cohid;
    }

    /**
     * 对象表主键取得
     * 
     * @return 对象表主键
     */
    public Integer getCoid() {
        return coid;
    }

    /**
     * 对象表主键设定
     * 
     * @param coid
     *            对象表主键
     */
    public void setCoid(Integer coid) {
        this.coid = coid;
    }

    /** 
     * 对比规则外键 取得
     * @return fkCrid 对比规则外键 
     */
    public Integer getFkCrid() {
        return fkCrid;
    }

    /** 
     * 对比规则外键 设定
     * @param fkCrid 对比规则外键 
     */
    public void setFkCrid(Integer fkCrid) {
        this.fkCrid = fkCrid;
    }

    /**
     * 名称取得
     * 
     * @return 名称
     */
    public String getConame() {
        return coname;
    }

    /**
     * 名称设定
     * 
     * @param coname
     *            名称
     */
    public void setConame(String coname) {
        this.coname = coname;
    }

    /** 
     * 对比源主机id 取得
     * @return cosource 对比源主机id 
     */
    public Integer getCosource() {
        return cosource;
    }

    /** 
     * 对比源主机id 设定
     * @param cosource 对比源主机id 
     */
    public void setCosource(Integer cosource) {
        this.cosource = cosource;
    }

    /**
     * 对比目标主机id取得
     * 
     * @return 对比目标主机id
     */
    public Integer getCotarget() {
        return cotarget;
    }

    /**
     * 对比目标主机id设定
     * 
     * @param cotarget
     *            对比目标主机id
     */
    public void setCotarget(Integer cotarget) {
        this.cotarget = cotarget;
    }

    /**
     * 源主机IP取得
     * 
     * @return 源主机IP
     */
    public String getSourceIP() {
        return sourceIP;
    }

    /**
     * 源主机IP设定
     * 
     * @param sourceIP
     *            源主机IP
     */
    public void setSourceIP(String sourceIP) {
        this.sourceIP = sourceIP;
    }

    /**
     * targetIP取得
     * 
     * @return targetIP
     */
    public String getTargetIP() {
        return targetIP;
    }

    /**
     * targetIP设定
     * 
     * @param targetIP
     *            targetIP
     */
    public void setTargetIP(String targetIP) {
        this.targetIP = targetIP;
    }

    /**
     * 比对规则表版本取得
     * 
     * @return 比对规则表版本
     */
    public Integer getCrversion() {
        return crversion;
    }

    /**
     * 比对规则表版本设定
     * 
     * @param crversion
     *            比对规则表版本
     */
    public void setCrversion(Integer crversion) {
        this.crversion = crversion;
    }
    
    



	/**
     * 主键取得
     * 
     * @return 主键
     */
    @Override
	public Serializable getPK() {
        return cohid;
    }

}