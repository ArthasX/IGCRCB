/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prr.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prr.model.IG602Info;

/**
 * @Description: 流程定义_参与者Vo
 * @Author  
 * @History 2009-8-23     新建 
 * @Version V2.0
 */
@SuppressWarnings("serial")
public class IGPRR01041VO extends BaseVO implements Serializable {
	
	/** 执行人 */
	private List<IGPRR01042VO> lst_IGPRR01042VO;
	
	/**
	 * 构造函数
	 * 
	 * @param lst_IGPRR01042VO 执行人
	 */
	public IGPRR01041VO(List<IG602Info> processExecutorVWList){
		if(processExecutorVWList != null) {
			this.lst_IGPRR01042VO = new ArrayList<IGPRR01042VO>();
			IGPRR01042VO vo = null;
			for(IG602Info pe : processExecutorVWList) {
				boolean flag = true;
				for(IGPRR01042VO bean : lst_IGPRR01042VO) {
					if(bean.getRoleid().equals(pe.getRoleid())){
						bean.add(pe);//角色集合已存在则追加
						flag = false;
						break;
					}
				}
				if(flag) {//角色集合不存在则新建
					vo = new IGPRR01042VO(pe.getRoleid(), pe.getRolename());
					vo.add(pe);
					this.lst_IGPRR01042VO.add(vo);
				}
			}
		}
	}
	
	/**
	 * 执行人取得
	 * 
	 * @return 执行人
	 */
	public List<IGPRR01042VO> getLst_IGPRR01042VO() {
		return lst_IGPRR01042VO;
	}

}
