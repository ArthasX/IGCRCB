/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dut.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.dut.model.OnDutyPersonRecordInfo;

/**
 * 概述: 日常维护登记表实体类
 * 功能描述: 日常维护登记表实体类
 * 创建记录: 2012/04/01
 * 修改记录: 
 */
@SuppressWarnings("serial")
@Entity
@Table(name="OnDutyPersonRecord")
public class OnDutyPersonRecordTB extends BaseEntity implements Serializable,Cloneable,OnDutyPersonRecordInfo{
    @Id
    @TableGenerator(
            name="OnDutyPersonRecord_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
            pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
            pkColumnValue="ONDUTYPERSONRECORD_SEQUENCE", initialValue=1, allocationSize=1
    )
    @GeneratedValue(strategy = GenerationType.TABLE, generator="OnDutyPersonRecord_TABLE_GENERATOR")
    /** 日常维护登记表主键 */
    protected Integer odprid;
    
    /** 来访人员 */
    protected String odprguest;
    
    /** 所属单位 */
    protected String odprguestorg;
    
    /** 身份证明 */
    protected String odprguestidnum;
    
    /** 进入区域 */
    protected String odprarea;
    
    /** 进入时间 */
    protected String odprctime;
    
    /** 离开时间 */
    protected String odprltime;
    
    /** 操作人 */
    protected String odpropter;
    
    /** 批准人 */
    protected String odpracter;
    
    /** 记录人 */
    protected String odprusername;
    
    /** 操作目标 */
    protected String odprtarget;
    
    /** 操作记录 */
    protected String odprrecord;
    
    /** 记录时间 */
    protected String odprinserttime;
    
    /** 编辑时间 */
    protected String odprmodtime;

    /**
     * odprid取得
     *
     * @return odprid odprid
     */
    public Integer getOdprid() {
        return odprid;
    }

    /**
     * odprid设定
     *
     * @param odprid odprid
     */
    public void setOdprid(Integer odprid) {
        this.odprid = odprid;
    }

    /**
     * 来访人员取得
     *
     * @return odprguest 来访人员
     */
    public String getOdprguest() {
        return odprguest;
    }

    /**
     * 来访人员设定
     *
     * @param odprguest 来访人员
     */
    public void setOdprguest(String odprguest) {
        this.odprguest = odprguest;
    }

    /**
     * 所属单位取得
     *
     * @return odprguestorg 所属单位
     */
    public String getOdprguestorg() {
        return odprguestorg;
    }

    /**
     * 所属单位设定
     *
     * @param odprguestorg 所属单位
     */
    public void setOdprguestorg(String odprguestorg) {
        this.odprguestorg = odprguestorg;
    }

    /**
     * 身份证明取得
     *
     * @return odprguestidnum 身份证明
     */
    public String getOdprguestidnum() {
        return odprguestidnum;
    }

    /**
     * 身份证明设定
     *
     * @param odprguestidnum 身份证明
     */
    public void setOdprguestidnum(String odprguestidnum) {
        this.odprguestidnum = odprguestidnum;
    }



    /**
	 * 进入区域取得
	 *
	 * @return odprarea 进入区域
	 */
	public String getOdprarea() {
		return odprarea;
	}

	/**
	 * 进入区域设定
	 *
	 * @param odprarea 进入区域
	 */
	public void setOdprarea(String odprarea) {
		this.odprarea = odprarea;
	}

	/**
     * 进入时间取得
     *
     * @return odprctime 进入时间
     */
    public String getOdprctime() {
        return odprctime;
    }

    /**
     * 进入时间设定
     *
     * @param odprctime 进入时间
     */
    public void setOdprctime(String odprctime) {
        this.odprctime = odprctime;
    }

    /**
     * 离开时间取得
     *
     * @return odprltime 离开时间
     */
    public String getOdprltime() {
        return odprltime;
    }

    /**
     * 离开时间设定
     *
     * @param odprltime 离开时间
     */
    public void setOdprltime(String odprltime) {
        this.odprltime = odprltime;
    }

    /**
     * 操作人取得
     *
     * @return odpropter 操作人
     */
    public String getOdpropter() {
        return odpropter;
    }

    /**
     * 操作人设定
     *
     * @param odpropter 操作人
     */
    public void setOdpropter(String odpropter) {
        this.odpropter = odpropter;
    }

    /**
     * 批准人取得
     *
     * @return odpracter 批准人
     */
    public String getOdpracter() {
        return odpracter;
    }

    /**
     * 批准人设定
     *
     * @param odpracter 批准人
     */
    public void setOdpracter(String odpracter) {
        this.odpracter = odpracter;
    }

    /**
     * 记录人取得
     *
     * @return odprusername 记录人
     */
    public String getOdprusername() {
        return odprusername;
    }

    /**
     * 记录人设定
     *
     * @param odprusername 记录人
     */
    public void setOdprusername(String odprusername) {
        this.odprusername = odprusername;
    }

    /**
     * 操作目标取得
     *
     * @return odprtarget 操作目标
     */
    public String getOdprtarget() {
        return odprtarget;
    }

    /**
     * 操作目标设定
     *
     * @param odprtarget 操作目标
     */
    public void setOdprtarget(String odprtarget) {
        this.odprtarget = odprtarget;
    }

    /**
     * 操作记录取得
     *
     * @return odprrecord 操作记录
     */
    public String getOdprrecord() {
        return odprrecord;
    }

    /**
     * 操作记录设定
     *
     * @param odprrecord 操作记录
     */
    public void setOdprrecord(String odprrecord) {
        this.odprrecord = odprrecord;
    }

    /**
     * 记录时间取得
     *
     * @return odprinserttime 记录时间
     */
    public String getOdprinserttime() {
        return odprinserttime;
    }

    /**
     * 记录时间设定
     *
     * @param odprinserttime 记录时间
     */
    public void setOdprinserttime(String odprinserttime) {
        this.odprinserttime = odprinserttime;
    }

    /**
     * 编辑时间取得
     *
     * @return odprmodtime 编辑时间
     */
    public String getOdprmodtime() {
        return odprmodtime;
    }

    /**
     * 编辑时间设定
     *
     * @param odprmodtime 编辑时间
     */
    public void setOdprmodtime(String odprmodtime) {
        this.odprmodtime = odprmodtime;
    }

    /**
     * 
     *
     * @return
     */
    @Override
    public Serializable getPK() {
        // TODO Auto-generated method stub
        return odprid;
    }

 
    
    
}