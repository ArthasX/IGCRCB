/**
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利
 */
package com.deliverik.infogovernor.rpt.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.infogovernor.rpt.bl.IGRptConstantDefine;
import com.deliverik.infogovernor.rpt.model.entity.SOC0210;
import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

/**
 * 概述: 合并word文档工具类
 * 功能描述:合并word文档工具类
 * 创建记录: 杨龙全 2012/06/07
 * 修改记录:
 */
 @SuppressWarnings("unused")
public class JacobWordUtil {
	private Dispatch doc;//模板word文档
	private ActiveXComponent word ;//word运行程序对象
	private Dispatch docs ;//获取所有文档对象
	private Dispatch selection;// 选定的范围或插入点
	private boolean saveOnExit = true;//是否退出
	
	Log log = LogFactory.getLog(JacobWordUtil.class);
	/**
	 * 构造方法
	 * @param visible 为true表示word应用程序可见
	 */
	public JacobWordUtil(boolean visible) {
		if(word==null){
			word=new ActiveXComponent("Word.Application");
			word.setProperty("Visible", new Variant(visible)); 
		}
		 if (docs == null){
			 docs = word.getProperty("Documents").toDispatch(); 
		 }
	}
	/**
	 * 创建一个新的word文档
	 */
	public void  createNewDocument(){
		doc = Dispatch.call(docs, "Add").toDispatch();
		selection = Dispatch.get(word, "Selection").toDispatch();
	}
	/** 
　　　 * 打开一个已存在的文档 
　　　 * @param docPath 
　　　 */ 
	public void openDocument(String docPath) { 
		closeDocument(); 
//		doc = Dispatch.call(docs, "Open", docPath).toDispatch(); 
		doc = Dispatch.invoke(
				docs,
				"Open",
				Dispatch.Method,
				new Object[] { docPath, new Variant(false),
						new Variant(false) }, new int[1]).toDispatch();
		selection = Dispatch.get(word, "Selection").toDispatch(); 
	}
	 /**
　　　 * 把选定的内容或插入点向上移动 
　　　 *　　　　 
　　　 * @param pos 移动的距离 
　　　 */ 
	public void moveUp(int pos) { 
		if (selection == null){
			selection = Dispatch.get(word, "Selection").toDispatch(); 
		}
		for (int i = 0; i < pos; i++){ 
			Dispatch.call(selection, "MoveUp");
		}
	}
	/**
　　　 * Esc 
　　　 *　　　　 
　　　 */ 
	public void typeEscapeKey() { 
		if (selection == null){
			selection = Dispatch.get(word, "Selection").toDispatch(); 
		}
		Dispatch.call(selection, "EscapeKey");
	}
	 /**
	　 * 把选定的内容或插入点向下移动 
	　 *　　　　 
	　 * @param pos 移动的距离 
	　 */ 
	public void moveDown(int pos){
		if (selection == null){
			selection = Dispatch.get(word, "Selection").toDispatch(); 
		}
		for (int i = 0; i < pos; i++){ 
			Dispatch.call(selection, "MoveDown");
		}
	}
	/**
　　　 * 把选定的内容或者插入点向右移动 
　　　 *　　　　 
　　　 * @param pos 移动的距离 
　　　 */ 
	public void moveRight(int pos) { 
		if (selection == null){
			selection = Dispatch.get(word, "Selection").toDispatch(); 
		}
		for (int i = 0; i < pos; i++){ 
			Dispatch.call(selection, "MoveRight");
		}
	}
	/**
　　　 * 把选定的内容或者插入点向左移动 
　　　 *　　　　 
　　　 * @param pos 移动的距离 
　　　 */ 
	public void moveLeft(int pos) { 
		if (selection == null){
			selection = Dispatch.get(word, "Selection").toDispatch(); 
		}
		for (int i = 0; i < pos; i++){ 
			Dispatch.call(selection, "MoveLeft");
		}
	}
	/**
	　 * 删除 
	　 * @param pos 移动的距离 
	　 */ 
	public void typeBackSpace(int pos){
		if (selection == null){
			selection = Dispatch.get(word, "Selection").toDispatch(); 
		}
		for (int i = 0; i < pos; i++){ 
			Dispatch.call(selection, "TypeBackspace");
		}
	}
	/**
	　 * 回车换行
	　 * @param pos 移动的距离 
	　 */ 
	public void typeParagraph(int pos){
		if (selection == null){
			selection = Dispatch.get(word, "Selection").toDispatch(); 
		}
		for (int i = 0; i < pos; i++){ 
			Dispatch.call(selection, "TypeParagraph");
		}
	}
	/**
	 * 移到文件首位置
	 */
	 public void moveStart() { 
		if (selection == null){
			selection = Dispatch.get(word, "Selection").toDispatch(); 
		}
		Dispatch.call(selection, "HomeKey", new Variant(6)); 
	 } 

	/**
	 * 移到文件尾位置
	 */
	public void moveEnd() { 
		if (selection == null){ 
			selection = Dispatch.get(word, "Selection").toDispatch(); 
		}
		Dispatch.call(selection, "EndKey", new Variant(6)); 
	}

	/** 
　　　 * 另存为 
　　　 * @param savePath 另存为路径 
　　　 */ 
	public void saveAS(String savePath) { 
		Dispatch.call(doc, "SaveAs", savePath); 
	} 
	/**
　　　 * 从选定内容或插入点开始查找文本 
　　　 *　　　　 
　　　 * @param toFindText 要查找的文本 
　　　 * @return boolean true-查找到并选中该文本，false-未查找到文本 
　　　 */ 
	@SuppressWarnings("static-access")
	public boolean find(String toFindText) { 
		if (toFindText == null || toFindText.equals("")){ 
			return false; 
		}
		moveStart();
		// 从selection所在位置开始查询 
		Dispatch find = word.call(selection, "Find").toDispatch(); 
		// 设置要查找的内容 
		Dispatch.put(find, "Text", toFindText); 
		 // 向前查找 
		Dispatch.put(find, "Forward", "True"); 
		// 设置格式 
		Dispatch.put(find, "Format", "True"); 
		// 大小写匹配 
		Dispatch.put(find, "MatchCase", "True"); 
		// 全字匹配 
		Dispatch.put(find, "MatchWholeWord", "True"); 
		// 查找并选中 
		return Dispatch.call(find, "Execute").getBoolean(); 
	}

	/** 
　　　 * 把选定选定内容设定为替换文本 
　　　 * @param toFindText 查找字符串 
　　　 * @param newText 要替换的内容 
　　　 * @return 
　　　 */ 
	public boolean replaceText(String toFindText, String newText) { 
		if (!find(toFindText)){ 
			return false; 
		}
		Dispatch.put(selection, "Text", newText); 
		return true; 
	}
	/**
　　　 *　选定内容替换成图片　　　 
　　　 * @param toFindText 要查找的字符串 
　　　 * @param imagePath 图片路径 
　　　 * @return 
　　　 */ 
	public boolean replaceImage(String toFindText, String imagePath) { 
		if (!find(toFindText)){ 
			return false; 
		}
		Dispatch.call(Dispatch.get(selection, "InLineShapes").toDispatch(),"AddPicture", imagePath); 
		return true; 
	}
	/** 
　　　 * 全局替换图片 
　　　 *　　　　 
　　　 * @param toFindText 查找字符串 
　　　 * @param imagePath 图片路径 
　　　 */ 
	public void replaceAllImage(String toFindText, String imagePath) { 
		while (find(toFindText)) { 
			Dispatch.call(Dispatch.get(selection, "InLineShapes").toDispatch(),"AddPicture", imagePath); 
			Dispatch.call(selection, "MoveRight"); 
		} 
	}

	/**
　　　 * 在当前插入点插入图片 
　　　 *　　　　 
　　　 * @param imagePath 图片路径 
　　　 */ 
	public void insertImage(String imagePath) { 
		Dispatch.call(Dispatch.get(selection, "InLineShapes").toDispatch(), "AddPicture", imagePath); 
	}
	/**
	  * 合并单元格
	  * 
	  * @param tableIndex
	  * @param fstCellRowIdx
	  * @param fstCellColIdx
	  * @param secCellRowIdx
	  * @param secCellColIdx
	  */
	 public void mergeCell(int tableIndex, int fstCellRowIdx, int fstCellColIdx,
	   int secCellRowIdx, int secCellColIdx) {
	  // 所有表格
	  Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();
	  // 要填充的表格
	  Dispatch table = Dispatch.call(tables, "Item", new Variant(tableIndex))
	    .toDispatch();
	  Dispatch fstCell = Dispatch.call(table, "Cell",
	    new Variant(fstCellRowIdx), new Variant(fstCellColIdx))
	    .toDispatch();
	  Dispatch secCell = Dispatch.call(table, "Cell",
	    new Variant(secCellRowIdx), new Variant(secCellColIdx))
	    .toDispatch();
	  Dispatch.call(fstCell, "Merge", secCell);
	 } 

	 /**
	  * 在指定的单元格里填写数据
	  * 
	  * @param tableIndex
	  * @param cellRowIdx
	  * @param cellColIdx
	  * @param txt
	  */
	 public void putTxtToCell(int tableIndex, int cellRowIdx, int cellColIdx,
	   String txt) {
	  // 所有表格
	  Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();
	  // 要填充的表格
	  Dispatch table = Dispatch.call(tables, "Item", new Variant(tableIndex))
	    .toDispatch();
	  Dispatch cell = Dispatch.call(table, "Cell", new Variant(cellRowIdx),
	    new Variant(cellColIdx)).toDispatch();
	  Dispatch.call(cell, "Select");
	  Dispatch.put(selection, "Text", txt);
	 }
	 /**
	  * 在当前文档拷贝剪贴板数据
	  * @param pos
	  */
	    public void pasteExcelSheet(String pos){
	     moveStart();
	     if (this.find(pos)) {
	   Dispatch textRange = Dispatch.get(selection, "Range").toDispatch();
	   Dispatch.call(textRange, "Paste");
	  }
	    }
	    
	 /**
	  * 在当前文档指定的位置拷贝表格
	  * 
	  * @param pos
	  *            当前文档指定的位置
	  * @param tableIndex
	  *            被拷贝的表格在word文档中所处的位置
	  */
	 public void copyTable(String pos, int tableIndex) {
	  // 所有表格
	  Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();
	  // 要填充的表格
	  Dispatch table = Dispatch.call(tables, "Item", new Variant(tableIndex))
	    .toDispatch();
	  Dispatch range = Dispatch.get(table, "Range").toDispatch();
	  Dispatch.call(range, "Copy");
	  if (this.find(pos)) {
	   Dispatch textRange = Dispatch.get(selection, "Range").toDispatch();
	   Dispatch.call(textRange, "Paste");
	  }
	 } 
	 /**
	  * 复制空格，防止出现图片放入剪切板画面弹出
	  */
	 public void copySpace(String pos) {
		  if (this.find(pos)) {
		   Dispatch.call(selection, "Copy");
		   Dispatch.call(selection, "Paste");
		  }
		 } 

	 /**
	  * 在当前文档指定的位置拷贝来自另一个文档中的表格
	  * 
	  * @param anotherDocPath
	  *            另一个文档的磁盘路径
	  * @param tableIndex
	  *            被拷贝的表格在另一格文档中的位置
	  * @param pos
	  *            当前文档指定的位置
	  */
	 public void copyTableFromAnotherDoc(String anotherDocPath, int tableIndex,
	   String pos) {
	  Dispatch doc2 = null;
	  try {
	   doc2 = Dispatch.call(docs, "Open", anotherDocPath)
	     .toDispatch();
	   // 所有表格
	   Dispatch tables = Dispatch.get(doc2, "Tables").toDispatch();
	   // 要填充的表格
	   Dispatch table = Dispatch.call(tables, "Item",
	     new Variant(tableIndex)).toDispatch();
	   Dispatch range = Dispatch.get(table, "Range").toDispatch();
	   Dispatch.call(range, "Copy");
	   if (this.find(pos)) {
	    Dispatch textRange = Dispatch.get(selection, "Range").toDispatch();
	    Dispatch.call(textRange, "Paste");
	   }
	  } catch (Exception e) {
	   e.printStackTrace();
	  } finally {
	   if (doc2 != null) {
	    Dispatch.call(doc2, "Close", new Variant(saveOnExit));
	    doc2 = null;
	   }
	  }
	 }
	 /**
	  * 在文档当前位置拷贝来自另一个文档中的图片，并指定图片大小
	  * @param anotherDocPath 另一个文档的磁盘路径
	  * @param shapeIndex 被拷贝的图片在另一格文档中的位置
	  * @param width 图片宽 
	  * @param height 图片高 
	  * @return true 找到 false为找不到
	  */
	 public boolean copyImageFromAnotherDoc(String anotherDocPath,int shapeIndex,Float width,Float height){
		  Dispatch doc2 = null;
		  boolean isFind=false;
		  try {
			  doc2 = Dispatch.call(docs, "Open", anotherDocPath).toDispatch();
			  Dispatch shapes = Dispatch.get(doc2, "InLineShapes").toDispatch();
			  int imgCount=Dispatch.call(shapes, "Count").getInt();
			  if(imgCount>0){
				   Dispatch shape = Dispatch.call(shapes, "Item", new Variant(shapeIndex)).toDispatch();
				   Dispatch.put(shape, "Width", width);
				   Dispatch.put(shape, "Height", height);
				   Dispatch imageRange = Dispatch.get(shape, "Range").toDispatch();
				   Dispatch.call(imageRange, "Copy");
				   Dispatch textRange = Dispatch.get(selection, "Range").toDispatch();
				   Dispatch.call(textRange, "Paste");
				   isFind=true;
			  }else{
				  isFind=false;
				  log.debug("====="+anotherDocPath+"====not find img");
			  }
		  } catch (Exception e) {
			  e.printStackTrace();
			  log.error("====="+anotherDocPath+"====not find doc");
			  isFind=false;
		  } finally {
			  if (doc2 != null) {
				  Dispatch.call(doc2, "Close", new Variant(saveOnExit));
				  doc2 = null;
			  }
		  }
		  return isFind;
	 }
	 
	 /**
	  * 创建表格
	  * 
	  * @param pos
	  *            位置
	  * @param cols
	  *            列数
	  * @param rows
	  *            行数
	  */
	 public void createTable(String pos, int numCols, int numRows) {
	  if (find(pos)) {
	   Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();
	   Dispatch range = Dispatch.get(selection, "Range").toDispatch();
	   Dispatch newTable = Dispatch.call(tables, "Add", range,
	     new Variant(numRows), new Variant(numCols)).toDispatch();
	   Dispatch.call(selection, "MoveRight");
	  }else{
	    Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();
	    Dispatch range = Dispatch.get(selection, "Range").toDispatch();
	    Dispatch newTable = Dispatch.call(tables, "Add", range,
	      new Variant(numRows), new Variant(numCols)).toDispatch();
	    Dispatch.call(selection, "MoveRight");
	  }
	 } 

	 /**
	  * 在指定行前面增加行
	  * 
	  * @param tableIndex
	  *            word文件中的第N张表(从1开始)
	  * @param rowIndex
	  *            指定行的序号(从1开始)
	  */
	 public void addTableRow(int tableIndex, int rowIndex) {
	  // 所有表格
	  Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();
	  // 要填充的表格
	  Dispatch table = Dispatch.call(tables, "Item", new Variant(tableIndex))
	    .toDispatch();
	  // 表格的所有行
	  Dispatch rows = Dispatch.get(table, "Rows").toDispatch();
	  Dispatch row = Dispatch.call(rows, "Item", new Variant(rowIndex))
	    .toDispatch();
	  Dispatch.call(rows, "Add", new Variant(row));
	 } 

	 /**
	  * 在第1行前增加一行
	  * 
	  * @param tableIndex
	  *  word文档中的第N张表(从1开始)
	  */
	 public void addFirstTableRow(int tableIndex) {
	  // 所有表格
	  Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();
	  // 要填充的表格
	  Dispatch table = Dispatch.call(tables, "Item", new Variant(tableIndex))
	    .toDispatch();
	  // 表格的所有行
	  Dispatch rows = Dispatch.get(table, "Rows").toDispatch();
	  Dispatch row = Dispatch.get(rows, "First").toDispatch();
	  Dispatch.call(rows, "Add", new Variant(row));
	 } 

	 /**
	  * 在最后1行前增加一行
	  * 
	  * @param tableIndex
	  *            word文档中的第N张表(从1开始)
	  */
	 public void addLastTableRow(int tableIndex) {
	  // 所有表格
	  Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();
	  // 要填充的表格
	  Dispatch table = Dispatch.call(tables, "Item", new Variant(tableIndex))
	    .toDispatch();
	  // 表格的所有行
	  Dispatch rows = Dispatch.get(table, "Rows").toDispatch();
	  Dispatch row = Dispatch.get(rows, "Last").toDispatch();
	  Dispatch.call(rows, "Add", new Variant(row));
	 } 
	 /**
	  * 增加一行
	  * 
	  * @param tableIndex
	  *            word文档中的第N张表(从1开始)
	  */
	 public void addRow(int tableIndex) {
	  Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();
	  // 要填充的表格
	  Dispatch table = Dispatch.call(tables, "Item", new Variant(tableIndex))
	    .toDispatch();
	  // 表格的所有行
	  Dispatch rows = Dispatch.get(table, "Rows").toDispatch();
	  Dispatch.call(rows, "Add");
	 } 

	 /**
	  * 增加一列
	  * 
	  * @param tableIndex
	  *            word文档中的第N张表(从1开始)
	  */
	 public void addCol(int tableIndex) {
	  // 所有表格
	  Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();
	  // 要填充的表格
	  Dispatch table = Dispatch.call(tables, "Item", new Variant(tableIndex))
	    .toDispatch();
	  // 表格的所有行
	  Dispatch cols = Dispatch.get(table, "Columns").toDispatch();
	  Dispatch.call(cols, "Add").toDispatch();
	  Dispatch.call(cols, "AutoFit");
	 } 

	 /**
	  * 在指定列前面增加表格的列
	  * 
	  * @param tableIndex
	  *            word文档中的第N张表(从1开始)
	  * @param colIndex
	  *            制定列的序号 (从1开始)
	  */
	 public void addTableCol(int tableIndex, int colIndex) {
	  // 所有表格
	  Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();
	  // 要填充的表格
	  Dispatch table = Dispatch.call(tables, "Item", new Variant(tableIndex))
	    .toDispatch();
	  // 表格的所有行
	  Dispatch cols = Dispatch.get(table, "Columns").toDispatch();
	  System.out.println(Dispatch.get(cols, "Count"));
	  Dispatch col = Dispatch.call(cols, "Item", new Variant(colIndex))
	    .toDispatch();
	  // Dispatch col = Dispatch.get(cols, "First").toDispatch();
	  Dispatch.call(cols, "Add", col).toDispatch();
	  Dispatch.call(cols, "AutoFit");
	 } 

	 /**
	  * 在第1列前增加一列
	  * 
	  * @param tableIndex
	  *            word文档中的第N张表(从1开始)
	  */
	 public void addFirstTableCol(int tableIndex) {
	  Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();
	  // 要填充的表格
	  Dispatch table = Dispatch.call(tables, "Item", new Variant(tableIndex))
	    .toDispatch();
	  // 表格的所有行
	  Dispatch cols = Dispatch.get(table, "Columns").toDispatch();
	  Dispatch col = Dispatch.get(cols, "First").toDispatch();
	  Dispatch.call(cols, "Add", col).toDispatch();
	  Dispatch.call(cols, "AutoFit");
	 } 

	 /**
	  * 在最后一列前增加一列
	  * 
	  * @param tableIndex
	  *            word文档中的第N张表(从1开始)
	  */
	 public void addLastTableCol(int tableIndex) {
	  Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();
	  // 要填充的表格
	  Dispatch table = Dispatch.call(tables, "Item", new Variant(tableIndex))
	    .toDispatch();
	  // 表格的所有行
	  Dispatch cols = Dispatch.get(table, "Columns").toDispatch();
	  Dispatch col = Dispatch.get(cols, "Last").toDispatch();
	  Dispatch.call(cols, "Add", col).toDispatch();
	  Dispatch.call(cols, "AutoFit");
	 }
	 /**
	  * 自动调整表格
	  *
	  */
	   
		public void autoFitTable(){
	     Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();
	     int count = Dispatch.get(tables, "Count").getInt();
	     for(int i=0;i<count;i++){
	      Dispatch table = Dispatch.call(tables, "Item", new Variant(i+1))
	   .toDispatch();
	      Dispatch cols = Dispatch.get(table, "Columns").toDispatch();
	      Dispatch.call(cols, "AutoFit");
	     }
	    }
	    /**
	     * 调用word里的宏以调整表格的宽度,其中宏保存在document下
	     *
	     */
	    
		public void callWordMacro(){
	     Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();
	     int count = Dispatch.get(tables, "Count").getInt();
	     Variant vMacroName = new Variant("Normal.NewMacros.tableFit");
	     Variant vParam = new Variant("param1");
	     Variant para[]=new Variant[]{vMacroName};
	     for(int i=0;i<count;i++){      
	    	 Dispatch table = Dispatch.call(tables, "Item", new Variant(i+1)).toDispatch();
	      Dispatch.call(table, "Select");
	      Dispatch.call(word,"Run","tableFitContent");
	     } 
	    }
	 /**
	  * 设置当前选定内容的字体
	  * 
	  * @param boldSize
	  * @param italicSize
	  * @param underLineSize
	  *            下划线
	  * @param colorSize
	  *            字体颜色
	  * @param size
	  *            字体大小
	  * @param name
	  *            字体名称
	  */
	 public void setFont(boolean bold, boolean italic, boolean underLine,
	   String colorSize, String size, String name) {
	  Dispatch font = Dispatch.get(selection, "Font").toDispatch();
	  Dispatch.put(font, "Name", new Variant(name));
	  Dispatch.put(font, "Bold", new Variant(bold));
	  Dispatch.put(font, "Italic", new Variant(italic));
	  Dispatch.put(font, "Underline", new Variant(underLine));
	  Dispatch.put(font, "Color", colorSize);
	  Dispatch.put(font, "Size", size);
	 } 

	/**
	 * 保存word
	 */
	public void save(){
		Dispatch.call(doc, "Save");
	}
 	/**
　　　 * 关闭当前word文档 
　　　 */ 
	public void closeDocument() { 
		if (doc != null) { 
			Dispatch.call(doc, "Close", new Variant(saveOnExit)); 
			doc = null; 
		} 
	} 
	/**
　　　 * 关闭全部应用 
　　　 */ 
	public void close() { 
		closeDocument(); 
		if (word != null) { 
			Dispatch.call(word, "Quit");
			word.safeRelease();
		 	word = null; 
		 } 
		selection = null; 
		docs = null; 
	}
	/**
	 * saveOnExit设定
	 * @param saveOnExit saveOnExit
	 */
	public void setSaveOnExit(boolean saveOnExit) {
		this.saveOnExit = saveOnExit;
	} 
	
	
	/**
	 * 获取图片对象
	 * @param index
	 * @return
	 */
	public Dispatch getShape(Integer index){
		Dispatch shapes = Dispatch.get(doc, "InLineShapes").toDispatch();//获取图片
		Dispatch shape = Dispatch.call(shapes, "Item", new Variant(index)).toDispatch();
		return shape;
	}
	/**
	 * 获取word文档图片数量
	 * @return
	 */
	public int getShapeCount(){
		Dispatch shapes = Dispatch.get(doc, "InLineShapes").toDispatch();//获取图片
		return Dispatch.call(shapes, "Count").getInt();
	}
	/**
	 *  获取图片宽度
	 * @param shape
	 * @return
	 */
	public Float getShapeWidth(Dispatch shape){
		Float width=Dispatch.call(shape, "Width").getFloat();
		return width;
	}
	/**
	 * 获取图片高度
	 * @param shape
	 * @return
	 */
	public Float getShapeHeight(Dispatch shape){
		Float height=Dispatch.call(shape, "Height").getFloat();
		return height;
	}
	/**
	 * 删除图片并退格
	 * @param shape
	 */
	public void deleteShape(Dispatch shape){
		Dispatch.call(shape, "Delete");
		typeBackSpace(1);
	}

	/**
	 * 插入文字
	 * @param textToInsert
	 */
	public void insertText(String textToInsert) {
    	Dispatch.put(selection, "Text", textToInsert);
    	moveRight(1);
	}
	/**
	 * 生成需要word报告
	 * @param temPathName  模板位置
	 * @param objList	   集合对象(策略)
	 * @param savePath	   生成文件位置
	 * @return Map<String,String> 返回信息
	 */
	public Map<String,String> createWordReport(String temPathName,List<SOC0210> objList,String savePath){
		openDocument(temPathName);
		Map<String, String> msgMap=new HashMap<String, String>();
		if(objList!=null&&objList.size()>0){
			for (int i = 0; i < objList.size(); i++) {
				Float width=IGRptConstantDefine.SHAPEWIDTH;
				Float height=IGRptConstantDefine.SHAPEHEIGHT;
				SOC0210 obj=objList.get(i);
				//标识
				String flag=obj.getFlag();
				String anotherDocPath=obj.getDocPath();
				int shapeIndex=obj.getShapeIndex();
				String imgStr=obj.getImgStr();
				String docName=obj.getDocName();
				boolean isf=find(flag);
				if(isf==true){
				//向上移动一位
				moveRight(1);
				moveUp(1);
				//选中右边一位
				Dispatch.call(selection,"MoveRight",new Variant(1),new Variant(1),new Variant(1));
				Dispatch shapes = Dispatch.get(selection, "InLineShapes").toDispatch();	
				//选中图片数量
				int imgCount=Dispatch.call(shapes, "Count").getInt();
				//判断图片中数量是否大于0.
				if(imgCount>0){
					Dispatch shape = Dispatch.call(shapes, "Item", new Variant(1)).toDispatch();
					width=getShapeWidth(shape);
					height=getShapeHeight(shape);
					deleteShape(shape);
					find(flag);
					moveLeft(1);
					typeBackSpace(1);
					
				}
				//向左移为了取消选中
				moveLeft(1);
				}
				boolean isFind=find(flag);
				//如果没有找到移动尾巴
				if(!isFind){
					moveEnd();
					typeParagraph(1);
				}
				//插入一行文字,然后换行
				insertText(imgStr);
				typeParagraph(1);
				//复制图片
				boolean isSucceed=copyImageFromAnotherDoc(anotherDocPath,shapeIndex, width, height);
				if(!isSucceed){
					msgMap.put(IGRptConstantDefine.NOT_FIND_PATH_MSG, docName);
				}
			}
			copySpace(objList.get(0).getImgStr());
		}
		saveAS(savePath);
		closeDocument();
		return msgMap;
	}
	
	@SuppressWarnings("static-access")
	public List<SOC0210> scanDoc(String docPath,String prefix,String suffix){
		openDocument(docPath);
		// 从selection所在位置开始查询 
		Dispatch find = word.call(selection, "Find").toDispatch(); 
		// 设置要查找的内容 
		boolean tmp=true;
		//返回对象集合
		List<SOC0210> docList=new ArrayList<SOC0210>();
		int index=1;
		while(tmp){
		Dispatch.put(find, "Text", prefix); 
		 // 向前查找 
		Dispatch.put(find, "Forward", "True"); 
		// 设置格式 
		Dispatch.put(find, "Format", "True"); 
		// 大小写匹配 
		Dispatch.put(find, "MatchCase", "True"); 
		// 全字匹配 
		Dispatch.put(find, "MatchWholeWord", "True"); 
		// 查找并选中 
		tmp=Dispatch.call(find, "Execute").getBoolean();
		if(tmp){
			boolean isTure=true;
			while(isTure){
				Dispatch.call(selection,"MoveRight",new Variant(1),new Variant(1),new Variant(1));
				String text=Dispatch.get(selection, "Text").toString();
				String sub=text.substring(text.length()-1, text.length());
				if(sub.equals(suffix)){
					isTure=false;
				}
			}
			String text=Dispatch.get(selection, "Text").toString();
			moveRight(1);
			SOC0210 dto=new SOC0210();
			dto.setFlag(text);
			dto.setLocationNum(index);
			docList.add(dto);
			index++;
		}
		}
		closeDocument();
		return docList;
	}
	
	
}
