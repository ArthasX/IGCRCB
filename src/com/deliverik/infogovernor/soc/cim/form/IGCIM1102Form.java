package com.deliverik.infogovernor.soc.cim.form;

import com.deliverik.framework.base.BaseForm;
/**
 * @Description: 转授权编辑画面FORM
 * @Author
 * @History 2011-12-14 新建
 * @Version V1.0
 */
public class IGCIM1102Form extends BaseForm {
    private static final long serialVersionUID = 1L;
    
    /**ccid*/
    protected String ccid;

    /**报表名称*/
    protected String rdname;

    /**报表名称*/
    protected String rdname_like;

    /**资产报表定义表ID*/
    protected Integer rdid;
    
    /**资产类型*/
    protected String esyscoding;
    
    protected String[] selectRelation;

    /** 操作步骤 */
    protected String rdstep;
    
    /** 报表状态 */
	protected String rdstatus;
    
    /** 条件表值 */
    protected String[] condvalues;
    
    /** 条件表id*/
    protected String[] condids;
    
    /**条件属性值*/
	protected String[] condvalue;
	/**条件属性值*/
	protected String[] condvaluetwo;
	
	/**条件属性值名称*/
	protected String[] condvaluename;
	
	
	/**报表更新时间开始*/
	protected String rdupdatetime_from;
	
	/**报表更新时间结束*/
	protected String rdupdatetime_to;

    public String getCcid() {
        return ccid;
    }

    public void setCcid(String ccid) {
        this.ccid = ccid;
    }

    public String getRdname() {
        return rdname;
    }

    public void setRdname(String rdname) {
        this.rdname = rdname;
    }

    public Integer getRdid() {
        return rdid;
    }

    public void setRdid(Integer rdid) {
        this.rdid = rdid;
    }

    public String getEsyscoding() {
        return esyscoding;
    }

    public void setEsyscoding(String esyscoding) {
        this.esyscoding = esyscoding;
    }

    public String[] getSelectRelation() {
        return selectRelation;
    }

    public void setSelectRelation(String[] selectRelation) {
        this.selectRelation = selectRelation;
    }

    public String getRdname_like() {
        return rdname_like;
    }

    public void setRdname_like(String rdname_like) {
        this.rdname_like = rdname_like;
    }

    public String getRdstep() {
        return rdstep;
    }

    public void setRdstep(String rdstep) {
        this.rdstep = rdstep;
    }

	public String[] getCondvalues() {
		return condvalues;
	}

	public void setCondvalues(String[] condvalues) {
		this.condvalues = condvalues;
	}

	public String[] getCondids() {
		return condids;
	}

	public void setCondids(String[] condids) {
		this.condids = condids;
	}

	public String[] getCondvalue() {
		return condvalue;
	}

	public void setCondvalue(String[] condvalue) {
		this.condvalue = condvalue;
	}


	public String[] getCondvaluetwo() {
		return condvaluetwo;
	}

	public void setCondvaluetwo(String[] condvaluetwo) {
		this.condvaluetwo = condvaluetwo;
	}

	public String[] getCondvaluename() {
		return condvaluename;
	}

	public void setCondvaluename(String[] condvaluename) {
		this.condvaluename = condvaluename;
	}

	public String getRdstatus() {
		return rdstatus;
	}

	public void setRdstatus(String rdstatus) {
		this.rdstatus = rdstatus;
	}

	public String getRdupdatetime_from() {
		return rdupdatetime_from;
	}

	public void setRdupdatetime_from(String rdupdatetime_from) {
		this.rdupdatetime_from = rdupdatetime_from;
	}

	public String getRdupdatetime_to() {
		return rdupdatetime_to;
	}

	public void setRdupdatetime_to(String rdupdatetime_to) {
		this.rdupdatetime_to = rdupdatetime_to;
	}
	
    
}
