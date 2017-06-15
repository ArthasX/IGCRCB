/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.condition;

/**
 * 机柜信息检索条件实现
 * 
 */
public class SOC0603SearchCondImpl implements SOC0603SearchCond {

	/** 机柜ID */
	protected Integer eiid;
	
	/** 机房ID */
	protected Integer room_eiid;
	
	/** 机柜编号 */
	protected String eilabel;

	/** 机柜编号 */
	protected String eilabel_like;
	
	/** 机柜名称 */
	protected String einame;
	
	/** 机柜高 */
	protected String u_total;
	
	/** 机柜是否已上架 */
	protected String graphstatus;
	
	/** 机柜中位置 */
	protected String u_value;
	
	/** 资产类型（空调用来区分立式挂式） */
	protected String eitype;
	
	/** 容器类型 */
	protected String containertype;

	/** 剩余U高 */
	protected String u_last;

	/** 剩余负载*/
	protected String load_last;

	/** 剩余电力*/
	protected String power_last;
	
	/**
	 * 机柜ID取得
	 * @return 机柜ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * 机柜ID设定
	 *
	 * @param eiid 机房ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * 机房ID取得
	 * @return 机房ID
	 */
	public Integer getRoom_eiid() {
		return room_eiid;
	}

	/**
	 * 机房ID设定
	 *
	 * @param room_eiid 机房ID
	 */
	public void setRoom_eiid(Integer room_eiid) {
		this.room_eiid = room_eiid;
	}

	/**
	 * 机柜编号取得
	 * @return 机柜编号
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * 机柜编号设定
	 *
	 * @param eilabel 机柜编号
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * 机柜名称取得
	 * @return 机柜名称
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * 机柜名称设定
	 *
	 * @param einame 机柜名称
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * 机柜高度（U）取得
	 * @return 机柜高度（U）
	 */
	public String getU_total() {
		return u_total;
	}

	/**
	 * 机柜高度（U）设定
	 *
	 * @param u_total 机柜高度（U）
	 */
	public void setU_total(String u_total) {
		this.u_total = u_total;
	}
	/**
	 * 机柜是否已上架
	 * @return 机柜是否已上架
	 */
	public String getGraphstatus() {
		return graphstatus;
	}
	
	/**
	 * 机柜是否已上架设定
	 *
	 * @param 机柜是否已上架
	 */
	public void setGraphstatus(String graphstatus) {
		this.graphstatus = graphstatus;
	}
	
	/**
	 * 机柜中位置取得
	 * 
	 * @return 机柜中位置
	 */
	public String getU_value() {
		return u_value;
	}

	/**
	 * 机柜中位置设定
	 * 
	 * @param standard 机柜中位置
	 */
	public void setU_value(String u_value) {
		this.u_value = u_value;
	}

	/**
	 * 资产类型（空调用来区分立式挂式）取得
	 * 
	 * @return 资产类型（空调用来区分立式挂式）
	 */
	public String getEitype() {
		return eitype;
	}

	/**
	 * 资产类型（空调用来区分立式挂式）设定
	 * 
	 * @param standard 资产类型（空调用来区分立式挂式）
	 */
	public void setEitype(String eitype) {
		this.eitype = eitype;
	}

	/**
	 * 容器类型取得
	 * 
	 * @return 容器类型
	 */
	public String getContainertype() {
		return containertype;
	}

	/**
	 * 容器类型设定
	 * 
	 * @param standard 容器类型
	 */
	public void setContainertype(String containertype) {
		this.containertype = containertype;
	}

    /**
     * 剩余U高取得
     *
     * @return u_last 剩余U高
     */
    public String getU_last() {
        return u_last;
    }

    /**
     * 剩余负载取得
     *
     * @return load_last 剩余负载
     */
    public String getLoad_last() {
        return load_last;
    }

    /**
     * 剩余电力取得
     *
     * @return power_last 剩余电力
     */
    public String getPower_last() {
        return power_last;
    }

    /**
     * 剩余U高设定
     *
     * @param u_last 剩余U高
     */
    public void setU_last(String u_last) {
        this.u_last = u_last;
    }

    /**
     * 剩余负载设定
     *
     * @param load_last 剩余负载
     */
    public void setLoad_last(String load_last) {
        this.load_last = load_last;
    }

    /**
     * 剩余电力设定
     *
     * @param power_last 剩余电力
     */
    public void setPower_last(String power_last) {
        this.power_last = power_last;
    }

    /**
     * 机柜编号取得
     *
     * @return eilabel_like 机柜编号
     */
    public String getEilabel_like() {
        return eilabel_like;
    }

    /**
     * 机柜编号设定
     *
     * @param eilabel_like 机柜编号
     */
    public void setEilabel_like(String eilabel_like) {
        this.eilabel_like = eilabel_like;
    }
}
