package com.deliverik.infogovernor.drm.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.igflow.resultset.RoleInfo;

/**
 * 角色组织架构关系VO
 */
public class IGDRM10022VO extends BaseVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
    /**rolelist*/
    protected List<RoleInfo> rolelist;

    public List<RoleInfo> getRolelist() {
        return rolelist;
    }

    public void setRolelist(List<RoleInfo> rolelist) {
        this.rolelist = rolelist;
    }
    
}