/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.model.condition;

/**
  * 概述: 检查项到风险点关系模型检索条件实现
  * 功能描述: 检查项到风险点关系模型检索条件实现
  * 创建记录: 2014/07/23
  * 修改记录: 
  */
public class CheckToRiskRelateVWSearchCondImpl implements
		CheckToRiskRelateVWSearchCond {

		/**检查项ID*/
		protected String eiid;

		/**
		 * 检查项ID取得
		 * @return eiid 检查项ID
		 */
		public String getEiid() {
			return eiid;
		}

		/**
		 * 检查项ID设定
		 * @param eiid 检查项ID
		 */
		public void setEiid(String eiid) {
			this.eiid = eiid;
		}
}