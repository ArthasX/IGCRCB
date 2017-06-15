/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model.condition;

/**
  * 概述: 演练计划条目检索条件实现
  * 功能描述: 演练计划条目检索条件实现
  * 创建记录: 2015/02/28
  * 修改记录: 
  */
public class DrillplanitemSearchCondImpl implements
		DrillplanitemSearchCond {
    
    /** 演练计划id */
    protected Integer did;

    /** 演练流程prid */
    protected Integer prid;

    /** 演练状态 已演练/未演练 */
    protected String status;

    /** 演练预期开始时间 */
    protected String expecttimestart;
    
    /** 演练预期开始时间 */
    protected String expecttimeend;

    /** 演练名称 */
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

    public String getExpecttimestart() {
        return expecttimestart;
    }

    public void setExpecttimestart(String expecttimestart) {
        this.expecttimestart = expecttimestart;
    }

    public String getExpecttimeend() {
        return expecttimeend;
    }

    public void setExpecttimeend(String expecttimeend) {
        this.expecttimeend = expecttimeend;
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
    
    
}