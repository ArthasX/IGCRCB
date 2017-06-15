/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prr.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prr.model.IG602Info;

/**
 * @Description: ���̶���_������Vo
 * @Author  
 * @History 2009-8-23     �½� 
 * @Version V2.0
 */
@SuppressWarnings("serial")
public class IGPRR01041VO extends BaseVO implements Serializable {
	
	/** ִ���� */
	private List<IGPRR01042VO> lst_IGPRR01042VO;
	
	/**
	 * ���캯��
	 * 
	 * @param lst_IGPRR01042VO ִ����
	 */
	public IGPRR01041VO(List<IG602Info> processExecutorVWList){
		if(processExecutorVWList != null) {
			this.lst_IGPRR01042VO = new ArrayList<IGPRR01042VO>();
			IGPRR01042VO vo = null;
			for(IG602Info pe : processExecutorVWList) {
				boolean flag = true;
				for(IGPRR01042VO bean : lst_IGPRR01042VO) {
					if(bean.getRoleid().equals(pe.getRoleid())){
						bean.add(pe);//��ɫ�����Ѵ�����׷��
						flag = false;
						break;
					}
				}
				if(flag) {//��ɫ���ϲ��������½�
					vo = new IGPRR01042VO(pe.getRoleid(), pe.getRolename());
					vo.add(pe);
					this.lst_IGPRR01042VO.add(vo);
				}
			}
		}
	}
	
	/**
	 * ִ����ȡ��
	 * 
	 * @return ִ����
	 */
	public List<IGPRR01042VO> getLst_IGPRR01042VO() {
		return lst_IGPRR01042VO;
	}

}
