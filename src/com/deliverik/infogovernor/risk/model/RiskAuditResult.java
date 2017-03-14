/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.risk.model;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.infogovernor.risk.model.entity.RiskAuditDefTB;
import com.deliverik.infogovernor.risk.model.entity.RiskAuditInsTB;

/**
 * 风险审计结果实体接口
 * 
 * @author lipeng@deliverik.com
 */
public interface RiskAuditResult  extends BaseModel {
	/**
	 * 风险审计评估结果ID取得
	 * @return 风险审计评估结果ID
	 */
	public Integer getRarid();

	/**
	 * 风险审计发起ID取得
	 * @return 风险审计发起ID
	 */
	public Integer getRaiid();
	
	/**
	 * 风险审计项ID取得
	 * @return 风险审计项ID
	 */
	public Integer getRadid();

	/**
	 * 风险审计评估日期取得
	 * @return 风险审计评估日期
	 */
	public String getRardate();

	/**
	 * 风险审计评估人id取得
	 * @return 风险审计评估人id
	 */
	public String getRaruserid();

	/**
	 * 风险审计评估人姓名取得
	 * @return 风险审计评估人姓名
	 */
	public String getRarusername();

	/**
	 * 风险审计制度建设评分取得
	 * @return 风险审计制度建设评分
	 */
	public String getRarplanscore();

	/**
	 * 风险审计制度建设评价取得
	 * @return 风险审计制度建设评价
	 */
	public String getRarplandesc();

	/**
	 * 风险审计制度执行评分取得
	 * @return 风险审计制度执行评分
	 */
	public String getRarexecscore();

	/**
	 * 风险审计制度执行评价取得
	 * @return 风险审计制度执行评价
	 */
	public String getRarexecdesc();

	/**
	 * 风险审计总体评分取得
	 * @return 风险审计总体评分
	 */
	public String getRarcomment();
	
	/**
	 * 风险审计总体评价取得
	 * @return 风险审计总体评价
	 */
	public String getRaroverallscore();
	
	/**
	 * 风险审计评估说明取得
	 * @return 风险审计评估说明
	 */
	public String getRaroveralldesc();
	
	/**
	 * 审计项实体取得
	 * @return 审计项实体
	 */
	public RiskAuditDefTB getRiskAuditDefTB();
	
	/**
	 * 审计发起实体取得
	 * @return 审计发起实体
	 */
	public RiskAuditInsTB getRiskAuditInsTB();
	
	/**
	 * 风险审计项层次码取得
	 * @return 风险审计项层次码
	 */
	public String getRadcode();
	
}