package com.deliverik.infogovernor.drm.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.CodeDetailDef;
import com.deliverik.infogovernor.drm.model.StructureRoleInfo;

/**
 * 角色组织架构关系VO
 */
public class IGDRM10021VO extends BaseVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**角色组织架构关系List*/
    protected List<StructureRoleInfo> relationlist;
    
    /**组织架构初始化*/
    protected CodeDetailDef codeDetailDef;
    
    
    public CodeDetailDef getCodeDetailDef() {
        return codeDetailDef;
    }
    public void setCodeDetailDef(CodeDetailDef codeDetailDef) {
        this.codeDetailDef = codeDetailDef;
    }
    public List<StructureRoleInfo> getRelationlist() {
        return relationlist;
    }
    public void setRelationlist(List<StructureRoleInfo> relationlist) {
        this.relationlist = relationlist;
    }
}