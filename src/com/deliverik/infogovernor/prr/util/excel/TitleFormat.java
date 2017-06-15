/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prr.util.excel;

import jxl.format.Alignment;
import jxl.format.CellFormat;
import jxl.format.Colour;
import jxl.format.VerticalAlignment;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WriteException;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 标题格式化对象生成器
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class TitleFormat extends BaseFormatFactory{

	/**
	 * 取得格式化对象
	 * @return 格式化对象
	 */
	public CellFormat getFormat() throws WriteException{
		//实例化字体对象
		WritableFont font = new WritableFont(WritableFont.ARIAL,12,WritableFont.BOLD);
		//实例化格式化对象
		WritableCellFormat format = new WritableCellFormat(font);
		//设置文字水平居中
		format.setAlignment(Alignment.RIGHT);
		//设置文字垂直居中
		format.setVerticalAlignment(VerticalAlignment.CENTRE);
		//设置文字自动换行
		format.setWrap(true);
		//设置边框
		setBorder(format);
		//设置背景颜色
		format.setBackground(Colour.GRAY_25);
		return format;
	}
}
