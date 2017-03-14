package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.soc.asset.model.SOC0603Info;

/**
 * <p>
 * 机柜视图信息实体
 * </p>
 */
@Entity
@org.hibernate.annotations.Entity(mutable=false)
@Table(name = "SOC0603")
@SuppressWarnings("serial")
//public class ComputerContainerVW extends BaseEntity implements Serializable, ComputerContainerVWInfo {
public class SOC0603VW implements Serializable, Cloneable, SOC0603Info {

	/** 机柜ID */
	@Id
	protected Integer eiid;
	
	/** 资产模型ID */
	protected String eid;
	
	/** 机柜名称 */
	protected String einame;
	
	/** 机柜编号 */
	protected String eilabel;
	
	/** 机柜说明 */
	protected String eidesc;
	
	/** 机柜版本号 */
	protected Integer eiversion;
	
	/** 登记日 */
	protected String eiinsdate;
	
	/** 机柜位置（X） */
	protected String x_value;
	
	/** 机柜位置（Y） */
	protected String y_value;
	
	/** 机柜中位置 */
	protected String u_value;
	
	/** 机柜高度（U） */
	protected String u_total;
	
	/** 机柜横向宽 */
	protected String x_width;
	
	/** 机柜纵向宽 */
	protected String y_width;
	
	/** 所属机房ID */
	protected Integer room_eiid;
	
	/** 所属机房编号 */
	protected String room_eilabel;
	
	/** 所属机房名 */
	protected String room_einame;

	/** 机房显示图用：层 */
	protected String graphindex;
	
	/** 机房显示图用：是否已设置 */
	protected String graphstatus;
	
	/** 机房显示图用：类型标识 */
	protected String graphtypeid;
	
	/** 机房显示图用：类型名称 */
	protected String graphtypename;

	/** 额定电压 */
	protected String voltage;

	/** 机柜重量 */
	protected String weight;

	/** 机柜规格 */
	protected String standard;
	
	/** 资产类型（空调用来区分立式挂式） */
	protected String eitype;
	
	/** 机架横向U数 */
	protected String width;
	
	/** 容器类型 */
	protected String containertype;

	/** 最大负载*/
	protected String maxload;
	
	/** 最大电力*/
	protected String maxpower;

	/** 剩余U高*/
	protected Integer u_last;
	
	/** 剩余功率*/
	protected Integer power_last;
	
	/** 剩余载重*/
	protected Integer load_last;
	
	/**
	 * 主键取得
	 * @return 
	 */
	public Serializable getPK() {
		return eiid;
	}

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
	 * @param eiid 机柜ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * 资产模型ID取得
	 * @return 资产模型ID
	 */
	public String getEid() {
		return eid;
	}

	/**
	 * 资产模型ID设定
	 *
	 * @param eid 资产模型ID
	 */
	public void setEid(String eid) {
		this.eid = eid;
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
	 * 机柜说明取得
	 * @return 机柜说明
	 */
	public String getEidesc() {
		return eidesc;
	}

	/**
	 * 机柜说明设定
	 *
	 * @param eidesc 机柜说明
	 */
	public void setEidesc(String eidesc) {
		this.eidesc = eidesc;
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
	 * 机柜版本号取得
	 * @return 机柜版本号
	 */
	public Integer getEiversion() {
		return eiversion;
	}

	/**
	 * 机柜版本号设定
	 *
	 * @param eiversion 机柜版本号
	 */
	public void setEiversion(Integer eiversion) {
		this.eiversion = eiversion;
	}

	/**
	 * 登记日取得
	 * @return 登记日
	 */
	public String getEiinsdate() {
		return eiinsdate;
	}

	/**
	 * 登记日设定
	 *
	 * @param eiinsdate 登记日
	 */
	public void setEiinsdate(String eiinsdate) {
		this.eiinsdate = eiinsdate;
	}

	/**
	 * 机柜位置（X）取得
	 * @return 机柜位置（X）
	 */
	public String getX_value() {
		return x_value;
	}

	/**
	 * 机柜位置（X）设定
	 *
	 * @param x_value 机柜位置（X）
	 */
	public void setX_value(String x_value) {
		this.x_value = x_value;
	}

	/**
	 * 机柜位置（Y）取得
	 * @return 机柜位置（Y）
	 */
	public String getY_value() {
		return y_value;
	}

	/**
	 * 机柜位置（Y）设定
	 *
	 * @param y_value 机柜位置（Y）
	 */
	public void setY_value(String y_value) {
		this.y_value = y_value;
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
	 * 机柜横向宽取得
	 * @return 机柜横向宽
	 */
	public String getX_width() {
		return x_width;
	}

	/**
	 * 机柜横向宽设定
	 *
	 * @param x_width 机柜横向宽
	 */
	public void setX_width(String x_width) {
		this.x_width = x_width;
	}

	/**
	 * 机柜纵向宽取得
	 * @return 机柜纵向宽
	 */
	public String getY_width() {
		return y_width;
	}

	/**
	 * 机柜纵向宽设定
	 *
	 * @param y_width 机柜纵向宽
	 */
	public void setY_width(String y_width) {
		this.y_width = y_width;
	}

	/**
	 * 所属机房ID取得
	 * @return 所属机房ID
	 */
	public Integer getRoom_eiid() {
		return room_eiid;
	}

	/**
	 * 所属机房ID设定
	 *
	 * @param room_eiid 所属机房ID
	 */
	public void setRoom_eiid(Integer room_eiid) {
		this.room_eiid = room_eiid;
	}

	/**
	 * 所属机房编号取得
	 * @return 所属机房编号
	 */
	public String getRoom_eilabel() {
		return room_eilabel;
	}

	/**
	 * 所属机房编号设定
	 *
	 * @param room_eilabel 所属机房编号
	 */
	public void setRoom_eilabel(String room_eilabel) {
		this.room_eilabel = room_eilabel;
	}

	/**
	 * 所属机房名取得
	 * @return 所属机房名
	 */
	public String getRoom_einame() {
		return room_einame;
	}

	/**
	 * 所属机房名设定
	 *
	 * @param room_einame 所属机房名
	 */
	public void setRoom_einame(String room_einame) {
		this.room_einame = room_einame;
	}

	/**
	 * 机房显示图用：层取得
	 * 
	 * @return 层
	 */
	public String getGraphindex() {
		return graphindex;
	}

	/**
	 * 机房显示图用：层设定
	 * 
	 * @param graphindex 层
	 */
	public void setGraphindex(String graphindex) {
		this.graphindex = graphindex;
	}

	/**
	 * 机房显示图用：是否已设置取得
	 * 
	 * @return 是否已设置
	 */
	public String getGraphstatus() {
		return graphstatus;
	}

	/**
	 * 机房显示图用：是否已设置设定
	 * 
	 * @param graphstatus 是否已设置
	 */
	public void setGraphstatus(String graphstatus) {
		this.graphstatus = graphstatus;
	}

	/**
	 * 机房显示图用：类型标识取得
	 * 
	 * @return 类型标识
	 */
	public String getGraphtypeid() {
		return graphtypeid;
	}

	/**
	 * 机房显示图用：类型标识设定
	 * 
	 * @param graphtypeid 类型标识
	 */
	public void setGraphtypeid(String graphtypeid) {
		this.graphtypeid = graphtypeid;
	}

	/**
	 * 机房显示图用：类型名称取得
	 * 
	 * @return 类型名称
	 */
	public String getGraphtypename() {
		return graphtypename;
	}

	/**
	 * 机房显示图用：类型名称设定
	 * 
	 * @param graphtypename 类型名称
	 */
	public void setGraphtypename(String graphtypename) {
		this.graphtypename = graphtypename;
	}

	/**
	 * 额定电压取得
	 * 
	 * @return 额定电压
	 */
	public String getVoltage() {
		return voltage;
	}

	/**
	 * 额定电压设定
	 * 
	 * @param voltage 额定电压
	 */
	public void setVoltage(String voltage) {
		this.voltage = voltage;
	}

	/**
	 * 机柜重量取得
	 * 
	 * @return 机柜重量
	 */
	public String getWeight() {
		return weight;
	}

	/**
	 * 机柜重量设定
	 * 
	 * @param weight 机柜重量
	 */
	public void setWeight(String weight) {
		this.weight = weight;
	}

	/**
	 * 机柜规格取得
	 * 
	 * @return 机柜规格
	 */
	public String getStandard() {
		return standard;
	}

	/**
	 * 机柜规格设定
	 * 
	 * @param standard 机柜规格
	 */
	public void setStandard(String standard) {
		this.standard = standard;
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
	 * 机架横向U数取得
	 * 
	 * @return 机架横向U数
	 */
	public String getWidth() {
		return width;
	}
	
	/**
	 * 机架横向U数设定
	 * 
	 * @param standard 机架横向U数
	 */
	public void setWidth(String width) {
		this.width = width;
	}

    /**
     * 最大负载取得
     *
     * @return maxload 最大负载
     */
    public String getMaxload() {
        return maxload;
    }

    /**
     * 最大电力取得
     *
     * @return maxpower 最大电力
     */
    public String getMaxpower() {
        return maxpower;
    }

    /**
     * 最大负载设定
     *
     * @param maxload 最大负载
     */
    public void setMaxload(String maxload) {
        this.maxload = maxload;
    }

    /**
     * 最大电力设定
     *
     * @param maxpower 最大电力
     */
    public void setMaxpower(String maxpower) {
        this.maxpower = maxpower;
    }

    /**
     * 剩余U高取得
     *
     * @return u_last 剩余U高
     */
    public Integer getU_last() {
        return u_last;
    }

    /**
     * 剩余功率取得
     *
     * @return power_last 剩余功率
     */
    public Integer getPower_last() {
        return power_last;
    }

    /**
     * 剩余载重取得
     *
     * @return load_last 剩余载重
     */
    public Integer getLoad_last() {
        return load_last;
    }

    /**
     * 剩余U高设定
     *
     * @param u_last 剩余U高
     */
    public void setU_last(Integer u_last) {
        this.u_last = u_last;
    }

    /**
     * 剩余功率设定
     *
     * @param power_last 剩余功率
     */
    public void setPower_last(Integer power_last) {
        this.power_last = power_last;
    }

    /**
     * 剩余载重设定
     *
     * @param load_last 剩余载重
     */
    public void setLoad_last(Integer load_last) {
        this.load_last = load_last;
    }

	
}