/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prr.util.excel;

import jxl.format.CellFormat;
import jxl.write.WriteException;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 生成Format对象
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface FormatFactory {

	/**
	 * 取得格式化对象
	 * @return 格式化对象
	 */
	public CellFormat getFormat() throws WriteException;
}
