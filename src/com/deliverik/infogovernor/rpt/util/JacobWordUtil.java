/**
 * ��������������������޹�˾��Ȩ���У���������Ȩ��
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
 * ����: �ϲ�word�ĵ�������
 * ��������:�ϲ�word�ĵ�������
 * ������¼: ����ȫ 2012/06/07
 * �޸ļ�¼:
 */
 @SuppressWarnings("unused")
public class JacobWordUtil {
	private Dispatch doc;//ģ��word�ĵ�
	private ActiveXComponent word ;//word���г������
	private Dispatch docs ;//��ȡ�����ĵ�����
	private Dispatch selection;// ѡ���ķ�Χ������
	private boolean saveOnExit = true;//�Ƿ��˳�
	
	Log log = LogFactory.getLog(JacobWordUtil.class);
	/**
	 * ���췽��
	 * @param visible Ϊtrue��ʾwordӦ�ó���ɼ�
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
	 * ����һ���µ�word�ĵ�
	 */
	public void  createNewDocument(){
		doc = Dispatch.call(docs, "Add").toDispatch();
		selection = Dispatch.get(word, "Selection").toDispatch();
	}
	/** 
������ * ��һ���Ѵ��ڵ��ĵ� 
������ * @param docPath 
������ */ 
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
������ * ��ѡ�������ݻ����������ƶ� 
������ *�������� 
������ * @param pos �ƶ��ľ��� 
������ */ 
	public void moveUp(int pos) { 
		if (selection == null){
			selection = Dispatch.get(word, "Selection").toDispatch(); 
		}
		for (int i = 0; i < pos; i++){ 
			Dispatch.call(selection, "MoveUp");
		}
	}
	/**
������ * Esc 
������ *�������� 
������ */ 
	public void typeEscapeKey() { 
		if (selection == null){
			selection = Dispatch.get(word, "Selection").toDispatch(); 
		}
		Dispatch.call(selection, "EscapeKey");
	}
	 /**
	�� * ��ѡ�������ݻ����������ƶ� 
	�� *�������� 
	�� * @param pos �ƶ��ľ��� 
	�� */ 
	public void moveDown(int pos){
		if (selection == null){
			selection = Dispatch.get(word, "Selection").toDispatch(); 
		}
		for (int i = 0; i < pos; i++){ 
			Dispatch.call(selection, "MoveDown");
		}
	}
	/**
������ * ��ѡ�������ݻ��߲���������ƶ� 
������ *�������� 
������ * @param pos �ƶ��ľ��� 
������ */ 
	public void moveRight(int pos) { 
		if (selection == null){
			selection = Dispatch.get(word, "Selection").toDispatch(); 
		}
		for (int i = 0; i < pos; i++){ 
			Dispatch.call(selection, "MoveRight");
		}
	}
	/**
������ * ��ѡ�������ݻ��߲���������ƶ� 
������ *�������� 
������ * @param pos �ƶ��ľ��� 
������ */ 
	public void moveLeft(int pos) { 
		if (selection == null){
			selection = Dispatch.get(word, "Selection").toDispatch(); 
		}
		for (int i = 0; i < pos; i++){ 
			Dispatch.call(selection, "MoveLeft");
		}
	}
	/**
	�� * ɾ�� 
	�� * @param pos �ƶ��ľ��� 
	�� */ 
	public void typeBackSpace(int pos){
		if (selection == null){
			selection = Dispatch.get(word, "Selection").toDispatch(); 
		}
		for (int i = 0; i < pos; i++){ 
			Dispatch.call(selection, "TypeBackspace");
		}
	}
	/**
	�� * �س�����
	�� * @param pos �ƶ��ľ��� 
	�� */ 
	public void typeParagraph(int pos){
		if (selection == null){
			selection = Dispatch.get(word, "Selection").toDispatch(); 
		}
		for (int i = 0; i < pos; i++){ 
			Dispatch.call(selection, "TypeParagraph");
		}
	}
	/**
	 * �Ƶ��ļ���λ��
	 */
	 public void moveStart() { 
		if (selection == null){
			selection = Dispatch.get(word, "Selection").toDispatch(); 
		}
		Dispatch.call(selection, "HomeKey", new Variant(6)); 
	 } 

	/**
	 * �Ƶ��ļ�βλ��
	 */
	public void moveEnd() { 
		if (selection == null){ 
			selection = Dispatch.get(word, "Selection").toDispatch(); 
		}
		Dispatch.call(selection, "EndKey", new Variant(6)); 
	}

	/** 
������ * ���Ϊ 
������ * @param savePath ���Ϊ·�� 
������ */ 
	public void saveAS(String savePath) { 
		Dispatch.call(doc, "SaveAs", savePath); 
	} 
	/**
������ * ��ѡ�����ݻ����㿪ʼ�����ı� 
������ *�������� 
������ * @param toFindText Ҫ���ҵ��ı� 
������ * @return boolean true-���ҵ���ѡ�и��ı���false-δ���ҵ��ı� 
������ */ 
	@SuppressWarnings("static-access")
	public boolean find(String toFindText) { 
		if (toFindText == null || toFindText.equals("")){ 
			return false; 
		}
		moveStart();
		// ��selection����λ�ÿ�ʼ��ѯ 
		Dispatch find = word.call(selection, "Find").toDispatch(); 
		// ����Ҫ���ҵ����� 
		Dispatch.put(find, "Text", toFindText); 
		 // ��ǰ���� 
		Dispatch.put(find, "Forward", "True"); 
		// ���ø�ʽ 
		Dispatch.put(find, "Format", "True"); 
		// ��Сдƥ�� 
		Dispatch.put(find, "MatchCase", "True"); 
		// ȫ��ƥ�� 
		Dispatch.put(find, "MatchWholeWord", "True"); 
		// ���Ҳ�ѡ�� 
		return Dispatch.call(find, "Execute").getBoolean(); 
	}

	/** 
������ * ��ѡ��ѡ�������趨Ϊ�滻�ı� 
������ * @param toFindText �����ַ��� 
������ * @param newText Ҫ�滻������ 
������ * @return 
������ */ 
	public boolean replaceText(String toFindText, String newText) { 
		if (!find(toFindText)){ 
			return false; 
		}
		Dispatch.put(selection, "Text", newText); 
		return true; 
	}
	/**
������ *��ѡ�������滻��ͼƬ������ 
������ * @param toFindText Ҫ���ҵ��ַ��� 
������ * @param imagePath ͼƬ·�� 
������ * @return 
������ */ 
	public boolean replaceImage(String toFindText, String imagePath) { 
		if (!find(toFindText)){ 
			return false; 
		}
		Dispatch.call(Dispatch.get(selection, "InLineShapes").toDispatch(),"AddPicture", imagePath); 
		return true; 
	}
	/** 
������ * ȫ���滻ͼƬ 
������ *�������� 
������ * @param toFindText �����ַ��� 
������ * @param imagePath ͼƬ·�� 
������ */ 
	public void replaceAllImage(String toFindText, String imagePath) { 
		while (find(toFindText)) { 
			Dispatch.call(Dispatch.get(selection, "InLineShapes").toDispatch(),"AddPicture", imagePath); 
			Dispatch.call(selection, "MoveRight"); 
		} 
	}

	/**
������ * �ڵ�ǰ��������ͼƬ 
������ *�������� 
������ * @param imagePath ͼƬ·�� 
������ */ 
	public void insertImage(String imagePath) { 
		Dispatch.call(Dispatch.get(selection, "InLineShapes").toDispatch(), "AddPicture", imagePath); 
	}
	/**
	  * �ϲ���Ԫ��
	  * 
	  * @param tableIndex
	  * @param fstCellRowIdx
	  * @param fstCellColIdx
	  * @param secCellRowIdx
	  * @param secCellColIdx
	  */
	 public void mergeCell(int tableIndex, int fstCellRowIdx, int fstCellColIdx,
	   int secCellRowIdx, int secCellColIdx) {
	  // ���б��
	  Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();
	  // Ҫ���ı��
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
	  * ��ָ���ĵ�Ԫ������д����
	  * 
	  * @param tableIndex
	  * @param cellRowIdx
	  * @param cellColIdx
	  * @param txt
	  */
	 public void putTxtToCell(int tableIndex, int cellRowIdx, int cellColIdx,
	   String txt) {
	  // ���б��
	  Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();
	  // Ҫ���ı��
	  Dispatch table = Dispatch.call(tables, "Item", new Variant(tableIndex))
	    .toDispatch();
	  Dispatch cell = Dispatch.call(table, "Cell", new Variant(cellRowIdx),
	    new Variant(cellColIdx)).toDispatch();
	  Dispatch.call(cell, "Select");
	  Dispatch.put(selection, "Text", txt);
	 }
	 /**
	  * �ڵ�ǰ�ĵ���������������
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
	  * �ڵ�ǰ�ĵ�ָ����λ�ÿ������
	  * 
	  * @param pos
	  *            ��ǰ�ĵ�ָ����λ��
	  * @param tableIndex
	  *            �������ı����word�ĵ���������λ��
	  */
	 public void copyTable(String pos, int tableIndex) {
	  // ���б��
	  Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();
	  // Ҫ���ı��
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
	  * ���ƿո񣬷�ֹ����ͼƬ������а廭�浯��
	  */
	 public void copySpace(String pos) {
		  if (this.find(pos)) {
		   Dispatch.call(selection, "Copy");
		   Dispatch.call(selection, "Paste");
		  }
		 } 

	 /**
	  * �ڵ�ǰ�ĵ�ָ����λ�ÿ���������һ���ĵ��еı��
	  * 
	  * @param anotherDocPath
	  *            ��һ���ĵ��Ĵ���·��
	  * @param tableIndex
	  *            �������ı������һ���ĵ��е�λ��
	  * @param pos
	  *            ��ǰ�ĵ�ָ����λ��
	  */
	 public void copyTableFromAnotherDoc(String anotherDocPath, int tableIndex,
	   String pos) {
	  Dispatch doc2 = null;
	  try {
	   doc2 = Dispatch.call(docs, "Open", anotherDocPath)
	     .toDispatch();
	   // ���б��
	   Dispatch tables = Dispatch.get(doc2, "Tables").toDispatch();
	   // Ҫ���ı��
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
	  * ���ĵ���ǰλ�ÿ���������һ���ĵ��е�ͼƬ����ָ��ͼƬ��С
	  * @param anotherDocPath ��һ���ĵ��Ĵ���·��
	  * @param shapeIndex ��������ͼƬ����һ���ĵ��е�λ��
	  * @param width ͼƬ�� 
	  * @param height ͼƬ�� 
	  * @return true �ҵ� falseΪ�Ҳ���
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
	  * �������
	  * 
	  * @param pos
	  *            λ��
	  * @param cols
	  *            ����
	  * @param rows
	  *            ����
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
	  * ��ָ����ǰ��������
	  * 
	  * @param tableIndex
	  *            word�ļ��еĵ�N�ű�(��1��ʼ)
	  * @param rowIndex
	  *            ָ���е����(��1��ʼ)
	  */
	 public void addTableRow(int tableIndex, int rowIndex) {
	  // ���б��
	  Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();
	  // Ҫ���ı��
	  Dispatch table = Dispatch.call(tables, "Item", new Variant(tableIndex))
	    .toDispatch();
	  // ����������
	  Dispatch rows = Dispatch.get(table, "Rows").toDispatch();
	  Dispatch row = Dispatch.call(rows, "Item", new Variant(rowIndex))
	    .toDispatch();
	  Dispatch.call(rows, "Add", new Variant(row));
	 } 

	 /**
	  * �ڵ�1��ǰ����һ��
	  * 
	  * @param tableIndex
	  *  word�ĵ��еĵ�N�ű�(��1��ʼ)
	  */
	 public void addFirstTableRow(int tableIndex) {
	  // ���б��
	  Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();
	  // Ҫ���ı��
	  Dispatch table = Dispatch.call(tables, "Item", new Variant(tableIndex))
	    .toDispatch();
	  // ����������
	  Dispatch rows = Dispatch.get(table, "Rows").toDispatch();
	  Dispatch row = Dispatch.get(rows, "First").toDispatch();
	  Dispatch.call(rows, "Add", new Variant(row));
	 } 

	 /**
	  * �����1��ǰ����һ��
	  * 
	  * @param tableIndex
	  *            word�ĵ��еĵ�N�ű�(��1��ʼ)
	  */
	 public void addLastTableRow(int tableIndex) {
	  // ���б��
	  Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();
	  // Ҫ���ı��
	  Dispatch table = Dispatch.call(tables, "Item", new Variant(tableIndex))
	    .toDispatch();
	  // ����������
	  Dispatch rows = Dispatch.get(table, "Rows").toDispatch();
	  Dispatch row = Dispatch.get(rows, "Last").toDispatch();
	  Dispatch.call(rows, "Add", new Variant(row));
	 } 
	 /**
	  * ����һ��
	  * 
	  * @param tableIndex
	  *            word�ĵ��еĵ�N�ű�(��1��ʼ)
	  */
	 public void addRow(int tableIndex) {
	  Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();
	  // Ҫ���ı��
	  Dispatch table = Dispatch.call(tables, "Item", new Variant(tableIndex))
	    .toDispatch();
	  // ����������
	  Dispatch rows = Dispatch.get(table, "Rows").toDispatch();
	  Dispatch.call(rows, "Add");
	 } 

	 /**
	  * ����һ��
	  * 
	  * @param tableIndex
	  *            word�ĵ��еĵ�N�ű�(��1��ʼ)
	  */
	 public void addCol(int tableIndex) {
	  // ���б��
	  Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();
	  // Ҫ���ı��
	  Dispatch table = Dispatch.call(tables, "Item", new Variant(tableIndex))
	    .toDispatch();
	  // ����������
	  Dispatch cols = Dispatch.get(table, "Columns").toDispatch();
	  Dispatch.call(cols, "Add").toDispatch();
	  Dispatch.call(cols, "AutoFit");
	 } 

	 /**
	  * ��ָ����ǰ�����ӱ�����
	  * 
	  * @param tableIndex
	  *            word�ĵ��еĵ�N�ű�(��1��ʼ)
	  * @param colIndex
	  *            �ƶ��е���� (��1��ʼ)
	  */
	 public void addTableCol(int tableIndex, int colIndex) {
	  // ���б��
	  Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();
	  // Ҫ���ı��
	  Dispatch table = Dispatch.call(tables, "Item", new Variant(tableIndex))
	    .toDispatch();
	  // ����������
	  Dispatch cols = Dispatch.get(table, "Columns").toDispatch();
	  System.out.println(Dispatch.get(cols, "Count"));
	  Dispatch col = Dispatch.call(cols, "Item", new Variant(colIndex))
	    .toDispatch();
	  // Dispatch col = Dispatch.get(cols, "First").toDispatch();
	  Dispatch.call(cols, "Add", col).toDispatch();
	  Dispatch.call(cols, "AutoFit");
	 } 

	 /**
	  * �ڵ�1��ǰ����һ��
	  * 
	  * @param tableIndex
	  *            word�ĵ��еĵ�N�ű�(��1��ʼ)
	  */
	 public void addFirstTableCol(int tableIndex) {
	  Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();
	  // Ҫ���ı��
	  Dispatch table = Dispatch.call(tables, "Item", new Variant(tableIndex))
	    .toDispatch();
	  // ����������
	  Dispatch cols = Dispatch.get(table, "Columns").toDispatch();
	  Dispatch col = Dispatch.get(cols, "First").toDispatch();
	  Dispatch.call(cols, "Add", col).toDispatch();
	  Dispatch.call(cols, "AutoFit");
	 } 

	 /**
	  * �����һ��ǰ����һ��
	  * 
	  * @param tableIndex
	  *            word�ĵ��еĵ�N�ű�(��1��ʼ)
	  */
	 public void addLastTableCol(int tableIndex) {
	  Dispatch tables = Dispatch.get(doc, "Tables").toDispatch();
	  // Ҫ���ı��
	  Dispatch table = Dispatch.call(tables, "Item", new Variant(tableIndex))
	    .toDispatch();
	  // ����������
	  Dispatch cols = Dispatch.get(table, "Columns").toDispatch();
	  Dispatch col = Dispatch.get(cols, "Last").toDispatch();
	  Dispatch.call(cols, "Add", col).toDispatch();
	  Dispatch.call(cols, "AutoFit");
	 }
	 /**
	  * �Զ��������
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
	     * ����word��ĺ��Ե������Ŀ��,���к걣����document��
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
	  * ���õ�ǰѡ�����ݵ�����
	  * 
	  * @param boldSize
	  * @param italicSize
	  * @param underLineSize
	  *            �»���
	  * @param colorSize
	  *            ������ɫ
	  * @param size
	  *            �����С
	  * @param name
	  *            ��������
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
	 * ����word
	 */
	public void save(){
		Dispatch.call(doc, "Save");
	}
 	/**
������ * �رյ�ǰword�ĵ� 
������ */ 
	public void closeDocument() { 
		if (doc != null) { 
			Dispatch.call(doc, "Close", new Variant(saveOnExit)); 
			doc = null; 
		} 
	} 
	/**
������ * �ر�ȫ��Ӧ�� 
������ */ 
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
	 * saveOnExit�趨
	 * @param saveOnExit saveOnExit
	 */
	public void setSaveOnExit(boolean saveOnExit) {
		this.saveOnExit = saveOnExit;
	} 
	
	
	/**
	 * ��ȡͼƬ����
	 * @param index
	 * @return
	 */
	public Dispatch getShape(Integer index){
		Dispatch shapes = Dispatch.get(doc, "InLineShapes").toDispatch();//��ȡͼƬ
		Dispatch shape = Dispatch.call(shapes, "Item", new Variant(index)).toDispatch();
		return shape;
	}
	/**
	 * ��ȡword�ĵ�ͼƬ����
	 * @return
	 */
	public int getShapeCount(){
		Dispatch shapes = Dispatch.get(doc, "InLineShapes").toDispatch();//��ȡͼƬ
		return Dispatch.call(shapes, "Count").getInt();
	}
	/**
	 *  ��ȡͼƬ���
	 * @param shape
	 * @return
	 */
	public Float getShapeWidth(Dispatch shape){
		Float width=Dispatch.call(shape, "Width").getFloat();
		return width;
	}
	/**
	 * ��ȡͼƬ�߶�
	 * @param shape
	 * @return
	 */
	public Float getShapeHeight(Dispatch shape){
		Float height=Dispatch.call(shape, "Height").getFloat();
		return height;
	}
	/**
	 * ɾ��ͼƬ���˸�
	 * @param shape
	 */
	public void deleteShape(Dispatch shape){
		Dispatch.call(shape, "Delete");
		typeBackSpace(1);
	}

	/**
	 * ��������
	 * @param textToInsert
	 */
	public void insertText(String textToInsert) {
    	Dispatch.put(selection, "Text", textToInsert);
    	moveRight(1);
	}
	/**
	 * ������Ҫword����
	 * @param temPathName  ģ��λ��
	 * @param objList	   ���϶���(����)
	 * @param savePath	   �����ļ�λ��
	 * @return Map<String,String> ������Ϣ
	 */
	public Map<String,String> createWordReport(String temPathName,List<SOC0210> objList,String savePath){
		openDocument(temPathName);
		Map<String, String> msgMap=new HashMap<String, String>();
		if(objList!=null&&objList.size()>0){
			for (int i = 0; i < objList.size(); i++) {
				Float width=IGRptConstantDefine.SHAPEWIDTH;
				Float height=IGRptConstantDefine.SHAPEHEIGHT;
				SOC0210 obj=objList.get(i);
				//��ʶ
				String flag=obj.getFlag();
				String anotherDocPath=obj.getDocPath();
				int shapeIndex=obj.getShapeIndex();
				String imgStr=obj.getImgStr();
				String docName=obj.getDocName();
				boolean isf=find(flag);
				if(isf==true){
				//�����ƶ�һλ
				moveRight(1);
				moveUp(1);
				//ѡ���ұ�һλ
				Dispatch.call(selection,"MoveRight",new Variant(1),new Variant(1),new Variant(1));
				Dispatch shapes = Dispatch.get(selection, "InLineShapes").toDispatch();	
				//ѡ��ͼƬ����
				int imgCount=Dispatch.call(shapes, "Count").getInt();
				//�ж�ͼƬ�������Ƿ����0.
				if(imgCount>0){
					Dispatch shape = Dispatch.call(shapes, "Item", new Variant(1)).toDispatch();
					width=getShapeWidth(shape);
					height=getShapeHeight(shape);
					deleteShape(shape);
					find(flag);
					moveLeft(1);
					typeBackSpace(1);
					
				}
				//������Ϊ��ȡ��ѡ��
				moveLeft(1);
				}
				boolean isFind=find(flag);
				//���û���ҵ��ƶ�β��
				if(!isFind){
					moveEnd();
					typeParagraph(1);
				}
				//����һ������,Ȼ����
				insertText(imgStr);
				typeParagraph(1);
				//����ͼƬ
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
		// ��selection����λ�ÿ�ʼ��ѯ 
		Dispatch find = word.call(selection, "Find").toDispatch(); 
		// ����Ҫ���ҵ����� 
		boolean tmp=true;
		//���ض��󼯺�
		List<SOC0210> docList=new ArrayList<SOC0210>();
		int index=1;
		while(tmp){
		Dispatch.put(find, "Text", prefix); 
		 // ��ǰ���� 
		Dispatch.put(find, "Forward", "True"); 
		// ���ø�ʽ 
		Dispatch.put(find, "Format", "True"); 
		// ��Сдƥ�� 
		Dispatch.put(find, "MatchCase", "True"); 
		// ȫ��ƥ�� 
		Dispatch.put(find, "MatchWholeWord", "True"); 
		// ���Ҳ�ѡ�� 
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
