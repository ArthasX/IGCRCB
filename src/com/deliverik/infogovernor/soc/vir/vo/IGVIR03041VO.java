package com.deliverik.infogovernor.soc.vir.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.soc.vir.model.VIM02Info;

/**
 * 项目列表显示VO
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGVIR03041VO extends BaseVO implements Serializable{
    
    /** 项目列表 */
    protected List<VIM02Info> vim02List;

    /**
     * 获取项目列表
     * @return 项目列表 
     */
    public List<VIM02Info> getVim02List() {
        return vim02List;
    }

    /**
     * 设置项目列表
     * @param vim02List 项目列表
     */
    public void setVim02List(List<VIM02Info> vim02List) {
        this.vim02List = vim02List;
    }
}


