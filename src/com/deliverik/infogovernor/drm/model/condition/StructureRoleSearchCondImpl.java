/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model.condition;

import java.util.List;

/**
  * 概述: 组织架构关联表检索条件实现
  * 功能描述: 组织架构关联表检索条件实现
  * 创建记录: 2015/03/09
  * 修改记录: 
  */
public class StructureRoleSearchCondImpl implements
		StructureRoleSearchCond {
    /** 组织架构层次码 */
    protected String syscoding;

    /** 组织架构cid */
    protected String cid;

    /** 组织架构名称 */
    protected String sname;

    /** 角色id */
    protected Integer roleid;

    /** 角色名称 */
    protected String rolename;

    /** 组织架构类型 Y应急组织架构，R日常组织架构 */
    protected String srtype;
    //完全匹配
    protected String syscoding_q;
    
    protected List<Integer> roleid_in;

    public List<Integer> getRoleid_in() {
		return roleid_in;
	}

	public void setRoleid_in(List<Integer> roleid_in) {
		this.roleid_in = roleid_in;
	}

	public String getSyscoding_q() {
        return syscoding_q;
    }

    public void setSyscoding_q(String syscoding_q) {
        this.syscoding_q = syscoding_q;
    }

    public String getSyscoding() {
        return syscoding;
    }

    public void setSyscoding(String syscoding) {
        this.syscoding = syscoding;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getSrtype() {
        return srtype;
    }

    public void setSrtype(String srtype) {
        this.srtype = srtype;
    }
    
    
}