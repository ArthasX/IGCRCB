/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.asset.model.RiskIndexContextVWInfo;
import com.deliverik.infogovernor.asset.model.RiskIndexSearchVWInfo;
import com.deliverik.infogovernor.asset.model.RiskIndexShowVWInfo;

/**
 * @Description: 
 * @Author       zhangqiang
 * @History      @2014-7-26�½� 
 * �޸�:	1.��� ����ָ���ѯ���ؼ���	yukexin 2014-8-19 09:13:05
 * @Version V1.0
 */
@SuppressWarnings("serial")
public class IGASM31071VO extends BaseVO implements Serializable{

	/**����ָ��չʾ*/
	protected List<RiskIndexShowVWInfo> riskIndexShowList;
	
	/**��������*/
	protected List<RiskIndexContextVWInfo> searchRiskIndexContextVW ;

	/**����ָ���ѯ���ؼ���*/
	protected List<RiskIndexSearchVWInfo> searchRiskIndexSearchVWList;
	
	/**
	 * ��������ȡ��
	 * @return searchRiskIndexContextVW ��������
	 */
	public List<RiskIndexContextVWInfo> getSearchRiskIndexContextVW() {
		return searchRiskIndexContextVW;
	}

	/**
	 * ���������趨
	 * @param searchRiskIndexContextVW ��������
	 */
	public void setSearchRiskIndexContextVW(
			List<RiskIndexContextVWInfo> searchRiskIndexContextVW) {
		this.searchRiskIndexContextVW = searchRiskIndexContextVW;
	}

	/**
	 * ����ָ��չʾȡ��
	 * @return riskIndexShowList ����ָ��չʾ
	 */
	public List<RiskIndexShowVWInfo> getRiskIndexShowList() {
		return riskIndexShowList;
	}

	/**
	 * ����ָ��չʾ�趨
	 * @param riskIndexShowList ����ָ��չʾ
	 */
	public void setRiskIndexShowList(List<RiskIndexShowVWInfo> riskIndexShowList) {
		this.riskIndexShowList = riskIndexShowList;
	}

	/**
	 * ����ָ���ѯ���ؼ���ȡ��
	 * @return searchRiskIndexSearchVWList  ����ָ���ѯ���ؼ���
	 */
	public List<RiskIndexSearchVWInfo> getSearchRiskIndexSearchVWList() {
		return searchRiskIndexSearchVWList;
	}

	/**
	 * ����ָ���ѯ���ؼ����趨
	 * @param searchRiskIndexSearchVWList  ����ָ���ѯ���ؼ���
	 */
	public void setSearchRiskIndexSearchVWList(
			List<RiskIndexSearchVWInfo> searchRiskIndexSearchVWList) {
		this.searchRiskIndexSearchVWList = searchRiskIndexSearchVWList;
	}
}
