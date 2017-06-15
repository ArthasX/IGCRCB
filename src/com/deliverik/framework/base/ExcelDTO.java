/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.base;

import java.io.FileOutputStream;

import javax.servlet.http.HttpServletResponse;

import com.deliverik.infogovernor.wkm.form.IGWKM0101Form;

import jxl.Sheet;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * ����: Excel����ͨ��DTO
 * ��������: Excel����ͨ��DTO
 * ������¼:
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class ExcelDTO extends BaseDTO {
	
    /** ��Ӧ���� */
	protected HttpServletResponse response;
	
	/** ģ���ʶ */
	protected String fileid;
	
	/** ��дSheetҳ */
	protected WritableSheet writableSheet;
	
	/** ��дģ�� */
	protected WritableWorkbook writableWorkbook;
	
	/** ģ��Sheetҳ */
	protected Sheet templateSheet;
	
	/** ��ʾ���� */
	protected String displayName;
	
	/** �����б���ʼ���� */
	protected int startRow;
	
	protected IGWKM0101Form igwkm0101form;
	
	protected FileOutputStream fos_I;	
	
	public FileOutputStream getFos_I() {
		return fos_I;
	}

	public void setFos_I(FileOutputStream fos_I) {
		this.fos_I = fos_I;
	}

	/**
     * �����б���ʼ����ȡ��
     * 
     * @return �����б���ʼ����
     */
	public int getStartRow() {
		return startRow;
	}

	/**
     * �����б���ʼ�����趨
     * 
     * @param �����б���ʼ����
     */
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	/**
     * ��Ӧ����ȡ��
     * 
     * @return ��Ӧ����
     */
	public HttpServletResponse getResponse() {
        return response;
    }

	/**
     * ��Ӧ�����趨
     * 
     * @param ��Ӧ����
     */
    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

	/**
	 * ģ���ʶȡ��
	 * 
	 * @return ģ���ʶ
	 */
	public String getFileid() {
		return fileid;
	}

	/**
	 * ģ���ʶ�趨
	 * 
	 * @param fileid ģ���ʶ
	 */
	public void setFileid(String fileid) {
		this.fileid = fileid;
	}

	/**
	 * ��дSheetҳȡ��
	 * 
	 * @return ��дwritableSheetҳ
	 */
	public WritableSheet getWritableSheet() {
		return writableSheet;
	}

	/**
	 * ��дSheetҳ�趨
	 * 
	 * @param writableSheet ��дSheetҳ
	 */
	public void setWritableSheet(WritableSheet writableSheet) {
		this.writableSheet = writableSheet;
	}

	/**
	 * ��дģ��ȡ��
	 * 
	 * @return writableWorkbook ��дģ��
	 */
	public WritableWorkbook getWritableWorkbook() {
		return writableWorkbook;
	}

	/**
	 * ��дģ���趨
	 * 
	 * @param writableWorkbook ��дģ��
	 */
	public void setWritableWorkbook(WritableWorkbook writableWorkbook) {
		this.writableWorkbook = writableWorkbook;
	}

	/**
	 * ģ��Sheetҳȡ��
	 * 
	 * @return ģ��Sheetҳ
	 */
	public Sheet getTemplateSheet() {
		return templateSheet;
	}

	/**
	 * ģ��Sheetҳ�趨
	 * 
	 * @param templateSheet ģ��Sheetҳ
	 */
	public void setTemplateSheet(Sheet templateSheet) {
		this.templateSheet = templateSheet;
	}

	/**
	 * ��ʾ����ȡ��
	 * 
	 * @return ��ʾ����
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * ��ʾ�����趨
	 * 
	 * @param displayName ��ʾ����
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * @return the igwkm0101form
	 */
	public IGWKM0101Form getIgwkm0101form() {
		return igwkm0101form;
	}

	/**
	 * @param igwkm0101form the igwkm0101form to set
	 */
	public void setIgwkm0101form(IGWKM0101Form igwkm0101form) {
		this.igwkm0101form = igwkm0101form;
	}
	
	
	
	
}
