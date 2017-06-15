package com.deliverik.infogovernor.soc.vir.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.soc.vir.model.VIM02Info;

/**
 * ��Ŀ�б���ʾVO
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGVIR03041VO extends BaseVO implements Serializable{
    
    /** ��Ŀ�б� */
    protected List<VIM02Info> vim02List;

    /**
     * ��ȡ��Ŀ�б�
     * @return ��Ŀ�б� 
     */
    public List<VIM02Info> getVim02List() {
        return vim02List;
    }

    /**
     * ������Ŀ�б�
     * @param vim02List ��Ŀ�б�
     */
    public void setVim02List(List<VIM02Info> vim02List) {
        this.vim02List = vim02List;
    }
}


