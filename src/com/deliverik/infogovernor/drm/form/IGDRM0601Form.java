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
 * Description: 演练计划登记/修改Form
 * </p>
 * 
 * @author sunkaiyu@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGDRM0601Form extends BaseForm{
    protected Integer did;
    
    /** 演练id */
    protected String[] diid;

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

    /** 描述 */
    protected String depict;
    
    /**审批人userid*/
    protected String judgeuserid;

    /**审批人username*/
    protected String judgeusername;
    
    /** 演练名称 */
    protected String[] diname;
    
    /** 演练预期开始时间 */
    protected String[] expecttime;
    
    /** 演练负责部门 */
    protected String[] didutyorg;
    
    /** 参与部门 */
    protected String[] partorg;
    
    /** 演练内容 */
    protected String[] dicontant;

    public String getJudgeuserid() {
        return judgeuserid;
    }

    public void setJudgeuserid(String judgeuserid) {
        this.judgeuserid = judgeuserid;
    }

    public String getJudgeusername() {
        return judgeusername;
    }

    public void setJudgeusername(String judgeusername) {
        this.judgeusername = judgeusername;
    }

    /**
     * 演练计划id取得
     *
     * @return 演练计划id
     */
    public Integer getDid() {
        return did;
    }

    /**
     * 演练计划id设定
     *
     * @param did 演练计划id
     */
    public void setDid(Integer did) {
        this.did = did;
    }

    /**
	 * diid取得
	 *
	 * @return diid diid
	 */
	public String[] getDiid() {
		return diid;
	}

	/**
	 * diid设定
	 *
	 * @param diid diid
	 */
	public void setDiid(String[] diid) {
		this.diid = diid;
	}

	/**
     * 演练计划制定人id取得
     *
     * @return 演练计划制定人id
     */
    public String getDuserid() {
        return duserid;
    }

    /**
     * 演练计划制定人id设定
     *
     * @param duserid 演练计划制定人id
     */
    public void setDuserid(String duserid) {
        this.duserid = duserid;
    }

    /**
     * 演练计划指定人名取得
     *
     * @return 演练计划指定人名
     */
    public String getDusername() {
        return dusername;
    }

    /**
     * 演练计划指定人名设定
     *
     * @param dusername 演练计划指定人名
     */
    public void setDusername(String dusername) {
        this.dusername = dusername;
    }

    /**
     * 创建时间取得
     *
     * @return 创建时间
     */
    public String getCrttime() {
        return crttime;
    }

    /**
     * 创建时间设定
     *
     * @param crttime 创建时间
     */
    public void setCrttime(String crttime) {
        this.crttime = crttime;
    }

    /**
     * 审批时间取得
     *
     * @return 审批时间
     */
    public String getJudgetime() {
        return judgetime;
    }

    /**
     * 审批时间设定
     *
     * @param judgetime 审批时间
     */
    public void setJudgetime(String judgetime) {
        this.judgetime = judgetime;
    }

    /**
     * 演练计划编号取得
     *
     * @return 演练计划编号
     */
    public String getDserial() {
        return dserial;
    }

    /**
     * 演练计划编号设定
     *
     * @param dserial 演练计划编号
     */
    public void setDserial(String dserial) {
        this.dserial = dserial;
    }

    /**
     * 演练计划名称取得
     *
     * @return 演练计划名称
     */
    public String getDname() {
        return dname;
    }

    /**
     * 演练计划名称设定
     *
     * @param dname 演练计划名称
     */
    public void setDname(String dname) {
        this.dname = dname;
    }

    /**
     * 审批状态 a 为送审，b审批中，c审批完成取得
     *
     * @return 审批状态 a 为送审，b审批中，c审批完成
     */
    public String getJudgestatus() {
        return judgestatus;
    }

    /**
     * 审批状态 a 为送审，b审批中，c审批完成设定
     *
     * @param judgestatus 审批状态 a 为送审，b审批中，c审批完成
     */
    public void setJudgestatus(String judgestatus) {
        this.judgestatus = judgestatus;
    }

    /**
     * 描述取得
     *
     * @return 描述
     */
    public String getDepict() {
        return depict;
    }

    /**
     * 描述设定
     *
     * @param depict 描述
     */
    public void setDepict(String depict) {
        this.depict = depict;
    }

	/**
	 * diname取得
	 *
	 * @return diname diname
	 */
	public String[] getDiname() {
		return diname;
	}

	/**
	 * diname设定
	 *
	 * @param diname diname
	 */
	public void setDiname(String[] diname) {
		this.diname = diname;
	}

	/**
	 * expecttime取得
	 *
	 * @return expecttime expecttime
	 */
	public String[] getExpecttime() {
		return expecttime;
	}

	/**
	 * expecttime设定
	 *
	 * @param expecttime expecttime
	 */
	public void setExpecttime(String[] expecttime) {
		this.expecttime = expecttime;
	}

	/**
	 * didutyorg取得
	 *
	 * @return didutyorg didutyorg
	 */
	public String[] getDidutyorg() {
		return didutyorg;
	}

	/**
	 * didutyorg设定
	 *
	 * @param didutyorg didutyorg
	 */
	public void setDidutyorg(String[] didutyorg) {
		this.didutyorg = didutyorg;
	}

	/**
	 * partorg取得
	 *
	 * @return partorg partorg
	 */
	public String[] getPartorg() {
		return partorg;
	}

	/**
	 * partorg设定
	 *
	 * @param partorg partorg
	 */
	public void setPartorg(String[] partorg) {
		this.partorg = partorg;
	}

	/**
	 * dicontant取得
	 *
	 * @return dicontant dicontant
	 */
	public String[] getDicontant() {
		return dicontant;
	}

	/**
	 * dicontant设定
	 *
	 * @param dicontant dicontant
	 */
	public void setDicontant(String[] dicontant) {
		this.dicontant = dicontant;
	}

}
