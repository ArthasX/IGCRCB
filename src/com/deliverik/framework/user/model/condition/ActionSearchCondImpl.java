package com.deliverik.framework.user.model.condition;

/**
 * 菜单信息检索条件实现
 * 
 */
public class ActionSearchCondImpl implements ActionSearchCond {

	/** 菜单显示名称 */
	protected String actlabel;
	
	/** 菜单可授予角色类型 */
	protected String actroletype;
	
	/** 菜单名称 */
	protected String actname_like;
	
	/**URL查询 */
	protected String acturl_like;
	
	/**菜单类型 */
	protected String acttype;
	
	/**自定义流程自动生成菜单的状态标记（1代表无效） */
    protected String actl1id;
	
	/**
     * 菜单类型取得
     * @return 菜单类型
     */
    public String getActtype() {
        return acttype;
    }

    /**
     * 菜单类型设定
     *
     * @param acttype 菜单类型
     */
    public void setActtype(String acttype) {
        this.acttype = acttype;
    }

    /**
	 * 菜单显示名称取得
	 * 
	 * @return 菜单显示名称
	 */
	public String getActlabel() {
		return actlabel;
	}

	/**
	 * 菜单显示名称设定
	 *
	 * @param actlabel 菜单显示名称
	 */
	public void setActlabel(String actlabel) {
		this.actlabel = actlabel;
	}

	/**
	 * 菜单可授予角色类型(逗号分割)取得
	 * @return 菜单可授予角色类型(逗号分割)
	 */
	public String getActroletype() {
		return actroletype;
	}

	/**
	 * 菜单可授予角色类型设定
	 *
	 * @param actroletype 菜单可授予角色类型
	 */
	public void setActroletype(String actroletype) {
		this.actroletype = actroletype;
	}

	/**
	 * 菜单名称取得
	 * @return 菜单名称
	 */
	public String getActname_like() {
		return actname_like;
	}

	/**
	 * 菜单名称设定
	 * @param actname_like菜单名称
	 */
	public void setActname_like(String actname_like) {
		this.actname_like = actname_like;
	}

	public String getActurl_like() {
		return acturl_like;
	}

	public void setActurl_like(String acturl_like) {
		this.acturl_like = acturl_like;
	}

    /**
     * @return the 自定义流程自动生成菜单的状态标记（1代表无效）
     */
    public String getActl1id() {
        return actl1id;
    }

    /**
     * @param 自定义流程自动生成菜单的状态标记（1代表无效） the actl1id to set
     */
    public void setActl1id(String actl1id) {
        this.actl1id = actl1id;
    }
	
}
