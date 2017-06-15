package com.deliverik.infogovernor.fxk.vo;



import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.fxk.model.RiskprojectvwInfo;

public class IGFXK03011VO extends BaseVO {
    /**获得的信息map*/
    protected Map<RiskprojectvwInfo,Map<String,Map<String,String>>> infomap;
    

    public Map<RiskprojectvwInfo, Map<String, Map<String, String>>> getInfomap() {
        return infomap;
    }

    public void setInfomap(Map<RiskprojectvwInfo, Map<String, Map<String, String>>> infomap) {
        this.infomap = infomap;
    }


}
