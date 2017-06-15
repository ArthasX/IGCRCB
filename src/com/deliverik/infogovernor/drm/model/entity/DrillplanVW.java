/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.drm.model.DrillplanVWInfo;

/**
  * 概述: 演练计划条目实体
  * 功能描述: 演练计划条目实体
  * 创建记录: 2015/02/28
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
public class DrillplanVW extends BaseEntity implements Serializable,
		Cloneable, DrillplanVWInfo {

	/** 演练计划条目id */
	@Id
	protected Integer diid;

	/** 演练计划id */
	protected Integer did;

	/** 演练流程prid */
	protected Integer prid;

    /** 演练状态 已演练/未演练 */
    protected String status;

    /** 演练预期开始时间 */
    protected String expecttime;

    /** 演练实际开始时间 */
    protected String actstarttime;

    /** 任务名称 */
    protected String diname;

    /** 演练内容 */
    protected String dicontant;

    /** 演练目的 */
    protected String didestination;

    /** 演练场景 */
    protected String discene;

    /** 影响范围 */
    protected String discope;

    /** 演练负责部门 */
    protected String didutyorg;

    /** 参与部门 */
    protected String partorg;
	
	/** 演练计划制定人id */
    protected String duserid;

    /** 演练计划指定人名 */
    protected String dusername;

    /** 创建时间 */
    protected String crttime;

    /** 审批时间 */
    protected String judgetime;

    /** 演练计划编号 */
    protected String dserial;

    /** 演练计划名称 */
    protected String dname;

    /** 审批状态 a 为送审，b审批中，c审批完成 */
    protected String judgestatus;

    public Integer getDiid() {
        return diid;
    }

    public void setDiid(Integer diid) {
        this.diid = diid;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Integer getPrid() {
        return prid;
    }

    public void setPrid(Integer prid) {
        this.prid = prid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getExpecttime() {
        return expecttime;
    }

    public void setExpecttime(String expecttime) {
        this.expecttime = expecttime;
    }

    public String getActstarttime() {
        return actstarttime;
    }

    public void setActstarttime(String actstarttime) {
        this.actstarttime = actstarttime;
    }

    public String getDiname() {
        return diname;
    }

    public void setDiname(String diname) {
        this.diname = diname;
    }

    public String getDicontant() {
        return dicontant;
    }

    public void setDicontant(String dicontant) {
        this.dicontant = dicontant;
    }

    public String getDidestination() {
        return didestination;
    }

    public void setDidestination(String didestination) {
        this.didestination = didestination;
    }

    public String getDiscene() {
        return discene;
    }

    public void setDiscene(String discene) {
        this.discene = discene;
    }

    public String getDiscope() {
        return discope;
    }

    public void setDiscope(String discope) {
        this.discope = discope;
    }

    public String getDidutyorg() {
        return didutyorg;
    }

    public void setDidutyorg(String didutyorg) {
        this.didutyorg = didutyorg;
    }

    public String getPartorg() {
        return partorg;
    }

    public void setPartorg(String partorg) {
        this.partorg = partorg;
    }

    public String getDuserid() {
        return duserid;
    }

    public void setDuserid(String duserid) {
        this.duserid = duserid;
    }

    public String getDusername() {
        return dusername;
    }

    public void setDusername(String dusername) {
        this.dusername = dusername;
    }

    public String getCrttime() {
        return crttime;
    }

    public void setCrttime(String crttime) {
        this.crttime = crttime;
    }

    public String getJudgetime() {
        return judgetime;
    }

    public void setJudgetime(String judgetime) {
        this.judgetime = judgetime;
    }

    public String getDserial() {
        return dserial;
    }

    public void setDserial(String dserial) {
        this.dserial = dserial;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getJudgestatus() {
        return judgestatus;
    }

    public void setJudgestatus(String judgestatus) {
        this.judgestatus = judgestatus;
    }

    /* 
     * <p>Title: getPK</p> 
     * <p>Description: </p> 
     * @return 
     * @see com.deliverik.framework.base.BaseEntity#getPK() 
     */
    @Override
    public Serializable getPK() {
        // TODO Auto-generated method stub
        return diid;
    }

   
}