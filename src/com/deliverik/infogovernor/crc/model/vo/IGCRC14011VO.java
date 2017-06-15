package com.deliverik.infogovernor.crc.model.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.crc.model.ChangeProcessVWInfo;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �����ѯVO
 * </p>
 * 
 * @author changhao@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGCRC14011VO extends BaseVO {
	
	/** vo*/
	List<IGCRC14012VO> igcrc14012vos;

	/** ������̼���*/
	List<ChangeProcessVWInfo> changeProcessVWInfos;
	/**
	 * voȡ��
	 * @return the igcrc14012vos
	 */
	public List<IGCRC14012VO> getIgcrc14012vos() {
		return igcrc14012vos;
	}

	/**
	 * vo�趨
	 * @param igcrc14012vos the vo
	 */
	public void setIgcrc14012vos(List<IGCRC14012VO> igcrc14012vos) {
		this.igcrc14012vos = igcrc14012vos;
	}

	/**
	 * ������̼���ȡ��
	 * @return the changeProcessVWInfos
	 */
	public List<ChangeProcessVWInfo> getChangeProcessVWInfos() {
		return changeProcessVWInfos;
	}

	/**
	 * ������̼����趨
	 * @param changeProcessVWInfos the ������̼���
	 */
	public void setChangeProcessVWInfos(
			List<ChangeProcessVWInfo> changeProcessVWInfos) {
		this.changeProcessVWInfos = changeProcessVWInfos;
	}
	
}
