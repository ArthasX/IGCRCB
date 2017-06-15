/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prr.util.excel;

import jxl.format.CellFormat;
import jxl.format.Colour;
import jxl.write.WritableCellFormat;
import jxl.write.WriteException;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 标记格式化对象生成器
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class SignFormat extends BaseFormatFactory{

	/**
	 * 取得格式化对象
	 * @return 格式化对象
	 */
	public CellFormat getFormat() throws WriteException{
		//实例化格式化对象
		WritableCellFormat format = new WritableCellFormat();
		//设置边框
		setBorder(format);
		//设置背景颜色
		format.setBackground(Colour.PINK);
		return format;
	}
}
