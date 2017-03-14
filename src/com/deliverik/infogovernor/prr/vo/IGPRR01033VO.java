/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prr.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG333Info;

/**
 * @Description: ���̶���_������Vo
 * @Author  
 * @History 2009-8-23     �½� 
 * @Version V2.0
 */
@SuppressWarnings("serial")
public class IGPRR01033VO extends BaseVO implements Serializable {
	
	/** �ɷ��ɲ����߼��� */
	private List<IGPRR01034VO> lst_IGPRR01034VO;

	/** �����ߴ����ʶ����(0δ����1�Ѵ���) */
	protected Map<String, String> map_ParticipantDoneFlag;

	/**
	 * �ɷ��ɽ�ɫ�趨
	 * 
	 * @param map_AssignParticipant �ɷ��ɽ�ɫ
	 */
	public IGPRR01033VO(Map<IG333Info, IGPRR01036VO> map_AssignParticipant) {
		if(map_AssignParticipant != null) {
			Set<Map.Entry<IG333Info, IGPRR01036VO>> set = map_AssignParticipant.entrySet();
			if(set.size() > 0) {
				this.lst_IGPRR01034VO = new ArrayList<IGPRR01034VO>();
				Map.Entry<IG333Info, IGPRR01036VO> entry = null;
				for(Iterator<Map.Entry<IG333Info, IGPRR01036VO>> iter = set.iterator();iter.hasNext();){
					entry = iter.next();
					this.lst_IGPRR01034VO.add(new IGPRR01034VO(entry.getKey(), entry.getValue()));
				}
			}
		}
	}

	/**
	 * �ɷ��ɲ����߼���
	 * 
	 * @return �ɷ��ɲ����߼���
	 */
	public List<IGPRR01034VO> getLst_IGPRR01034VO() {
		return lst_IGPRR01034VO;
	}
	
	/**
	 * �����ߴ����ʶ����ȡ��
	 * 
	 * @return �����ߴ����ʶ����
	 */
	public Map<String, String> getMap_ParticipantDoneFlag() {
		return map_ParticipantDoneFlag;
	}

	/**
	 * �����ߴ����ʶ�����趨
	 * 
	 * @param map_ParticipantDoneFlag �����ߴ����ʶ����
	 */
	public void setMap_ParticipantDoneFlag(
			Map<String, String> map_ParticipantDoneFlag) {
		this.map_ParticipantDoneFlag = map_ParticipantDoneFlag;
	}

}
