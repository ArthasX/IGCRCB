/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prr.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import jxl.format.CellFormat;
import jxl.format.Colour;
import jxl.write.WriteException;

import com.deliverik.infogovernor.prr.util.excel.ContentFormat;
import com.deliverik.infogovernor.prr.util.excel.FormatFactory;
import com.deliverik.infogovernor.prr.util.excel.MainTitleFormat;
import com.deliverik.infogovernor.prr.util.excel.SignFormat;
import com.deliverik.infogovernor.prr.util.excel.TitleFormat;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: Excel工具类
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class ExcelUtils {
	
	/**
	 * 类型
	 */
	public static enum Type{
		/** 总标题 */
		MAIN_TITLE(1),
		/** 小标题 */
		TITLE(2),
		/** 标记 */
		SIGN(3),
		/** 内容 */
		CONTENT(4),
		;
		
		private int code;
		
		/**
		 * 构造方法
		 * @param _code
		 */
		private Type(int _code){
			this.code = _code;
		}
		
		public String toString(){
			return String.valueOf(this.code);
		}
	}
	
	
	/** 对象实例 */
	private static ExcelUtils entity = null;
	
	/** 格式化对象生成类集合 */
	private Map<String, FormatFactory> map = new HashMap<String, FormatFactory>();
	
	/**
	 * 构造方法
	 */
	private ExcelUtils(){}
	
	/**
	 * 实例取得
	 * @return 对象实例
	 */
	public static ExcelUtils getInstance(){
		if(entity == null){
			entity = new ExcelUtils(); 
			entity.init();
		}
		return entity;
	}
	
	/**
	 * 初始化方法
	 */
	private void init(){
		map.put("1", new MainTitleFormat());
		map.put("2", new TitleFormat());
		map.put("3", new SignFormat());
		map.put("4", new ContentFormat());
	}
	
	/**
	 * 取得格式化对象
	 * @param type 格式化对象类型
	 * @return 格式化对象
	 */
	public CellFormat format(Type type){
		FormatFactory factory = map.get(type.toString());
		CellFormat format = null;
		if(factory != null){
			try {
				format = factory.getFormat();
			} catch (WriteException e) {
				e.printStackTrace();
			}
		}
		return format;
	}
	
	/**
	 * 取得格式类型
	 * @param format 格式对象
	 * @return
	 */
	public Type getType(CellFormat format){
		//取得背景颜色
		Colour colour = format.getBackgroundColour();
		//取得颜色说明
		String description = colour.getDescription();
		Type type = null;
		if("pink".equals(description)){
			type = Type.SIGN;
		}else if("grey".equals(description)){
			type = Type.TITLE;
		}
		return type;
	}
	
	/**
	 * 清除缓存
	 */
	public void flush(){
		new Thread(new Runnable() {
			public void run() {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				//取得当前日期
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
				String currentDate = sdf.format(new Date());
				//取得缓存目录
				String rootPath = ImportProcessUtils.getInstance().get("TEMPLATE_TEMP_PATH").toString();
				//缓存目录对象
				File file = new File(rootPath);
				if(file.exists()){
					for(File f:file.listFiles()){
						//删除非当天的文件或文件夹
						if(!f.getName().startsWith(currentDate)){
							delete(f);
						}
					}
				}
			}

			private void delete(File file) {
				if(file.exists()){
					if(file.isFile()){
						file.delete();
					}else if(file.isDirectory()){
						for(File f:file.listFiles()){
							delete(f);
						}
						file.delete();
					}
				}
			}
		}).start();
	}
}
