package com.deliverik.infogovernor.drm.form;
/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 演练计划条目管理Form
 * </p>
 * 
 * @author sunkaiyu@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGDRM0603Form extends BaseForm{
    //id
    protected Integer did;
    //演练id
    protected String[] diid;

    /** 演练预期开始时间 */
    protected String[] expecttime;

    /** 演练名称 */
    protected String[] diname;

    /** 演练内容 */
    protected String[] dicontant;

    /** 演练目的 */
    protected String[] didestination;

    /** 演练场景 */
    protected String[] discene;

    /** 影响范围 */
    protected String[] discope;

    /** 演练负责部门 */
    protected String[] didutyorg;

    /** 参与部门 */
    protected String[] partorg;
    
    /** 返回标识 */
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
	 * flag取得
	 *
	 * @return flag flag
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * flag设定
	 *
	 * @param flag flag
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}
    
}
