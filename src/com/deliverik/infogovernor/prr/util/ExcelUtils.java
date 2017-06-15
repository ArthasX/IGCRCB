/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: Excel������
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class ExcelUtils {
	
	/**
	 * ����
	 */
	public static enum Type{
		/** �ܱ��� */
		MAIN_TITLE(1),
		/** С���� */
		TITLE(2),
		/** ��� */
		SIGN(3),
		/** ���� */
		CONTENT(4),
		;
		
		private int code;
		
		/**
		 * ���췽��
		 * @param _code
		 */
		private Type(int _code){
			this.code = _code;
		}
		
		public String toString(){
			return String.valueOf(this.code);
		}
	}
	
	
	/** ����ʵ�� */
	private static ExcelUtils entity = null;
	
	/** ��ʽ�����������༯�� */
	private Map<String, FormatFactory> map = new HashMap<String, FormatFactory>();
	
	/**
	 * ���췽��
	 */
	private ExcelUtils(){}
	
	/**
	 * ʵ��ȡ��
	 * @return ����ʵ��
	 */
	public static ExcelUtils getInstance(){
		if(entity == null){
			entity = new ExcelUtils(); 
			entity.init();
		}
		return entity;
	}
	
	/**
	 * ��ʼ������
	 */
	private void init(){
		map.put("1", new MainTitleFormat());
		map.put("2", new TitleFormat());
		map.put("3", new SignFormat());
		map.put("4", new ContentFormat());
	}
	
	/**
	 * ȡ�ø�ʽ������
	 * @param type ��ʽ����������
	 * @return ��ʽ������
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
	 * ȡ�ø�ʽ����
	 * @param format ��ʽ����
	 * @return
	 */
	public Type getType(CellFormat format){
		//ȡ�ñ�����ɫ
		Colour colour = format.getBackgroundColour();
		//ȡ����ɫ˵��
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
	 * �������
	 */
	public void flush(){
		new Thread(new Runnable() {
			public void run() {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				//ȡ�õ�ǰ����
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
				String currentDate = sdf.format(new Date());
				//ȡ�û���Ŀ¼
				String rootPath = ImportProcessUtils.getInstance().get("TEMPLATE_TEMP_PATH").toString();
				//����Ŀ¼����
				File file = new File(rootPath);
				if(file.exists()){
					for(File f:file.listFiles()){
						//ɾ���ǵ�����ļ����ļ���
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
