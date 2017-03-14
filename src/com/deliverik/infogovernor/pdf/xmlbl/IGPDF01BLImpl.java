package com.deliverik.infogovernor.pdf.xmlbl;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.bl.AttachmentBL;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prr.bl.task.IG898BL;
import com.deliverik.framework.workflow.prr.model.IG036Info;
import com.deliverik.framework.workflow.prr.model.IG898Info;
import com.deliverik.framework.workflow.prr.model.condition.IG898SearchCondImpl;
import com.deliverik.infogovernor.pdf.bl.task.PdfConfigrationBL;
import com.deliverik.infogovernor.pdf.model.PdfConfigrationInfo;
import com.deliverik.infogovernor.pdf.model.condition.PdfConfigrationSearchCondImpl;
import com.deliverik.infogovernor.pdf.xmlbl.task.PdfTaskBL;
import com.deliverik.infogovernor.util.Zip;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfFileSpecification;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.XfaForm;

/**
 * ����: ����PDF�Ŀ���BL
 * ��������������PDF�Ŀ���BL
 * �����ˣ�deliverik
 * ������¼��2013-7-29
 * �޸ļ�¼��
 */
public class IGPDF01BLImpl extends BaseBLImpl implements IGPDF01BL {

    /** �����ӦBL��ģ���������ñ�ҵ���߼��ӿ���ͼBL*/ 
    protected PdfConfigrationBL pdfConfigrationBL;
    
    /** �������ݻ�ȡBL��*/ 
    protected PdfTaskBL pdfTaskBL;
    
    /** ����ģ����·��*/ 
    private final String PDF_TEMPLATE_PATH = 
        ResourceUtility.getString("PDF_TEMPLATE_PATH"); 
    
    /** ���������·��*/ 
    private final String PDF_EXPORT_PATH = 
        ResourceUtility.getString("PDF_EXPORT_PATH"); 
    
    /** ����ѹ���ļ�����*/ 
    private final String PDF_ZIP_NAME = 
        ResourceUtility.getString("PDF_ZIP_NAME"); 
    
    /** ����·������*/ 
    private final String UPLOAD_FILE_ROOT_PATH = 
    		ResourceUtility.getString("UPLOAD_FILE_ROOT_PATH"); 
	/** ������־*/ 
	static Log log = LogFactory.getLog(IGPDF01BLImpl.class);

    /**
     * @param �����ӦBL��ģ���������ñ�ҵ���߼��ӿ���ͼBL the pdfConfigrationBL to set
     */
    public void setPdfConfigrationBL(PdfConfigrationBL pdfConfigrationBL) {
        this.pdfConfigrationBL = pdfConfigrationBL;
    }
    
    /**
     * @param �������ݻ�ȡBL�� the pdfTaskBL to set
     */
    public void setPdfTaskBL(PdfTaskBL pdfTaskBL) {
        this.pdfTaskBL = pdfTaskBL;
    }
    
	/**
     * ��ȡ�����������XML��������PDF��
     *
     * @param pdid ���̶���id
     * @param prid ����id
     * @return String PDF����·�����ļ���
     */
	public String createPdf(String pdid, Integer prid) throws BLException  {
	    log.debug("========PDF��������ʼ========");
	    // ȡ�ñ���������Ϣ
	    PdfConfigrationSearchCondImpl cond = new PdfConfigrationSearchCondImpl();
	    cond.setPdid(pdid);
	    List<PdfConfigrationInfo>  pdfConfigrationInfolist = 
	        pdfConfigrationBL.searchPdfConfigration(cond);
	    String templatePath,exportPath;
	    if (pdfConfigrationInfolist.size() > 0) {
	    	String xmlData = null;
	        PdfConfigrationInfo info = pdfConfigrationInfolist.get(0);
	        //T-Q-3������ԭ�߼�����ʹ���������� 2015��11��17��19:42:47
	    	if(pdid.startsWith("21000")){
	    		xmlData = pdfTaskBL.getXmlFilledDataForTQ3(prid, pdid, info.getXmlname());
	    		xmlData = xmlData.replaceAll("null null:null:00", "");
        	}else{
        		xmlData = pdfTaskBL.getXmlFilledData(prid, pdid, info.getXmlname());
        		xmlData = xmlData.replaceAll("null null:null:00", "");
        	}
	        // ������PDF
	        templatePath = PDF_TEMPLATE_PATH +info.getTemplatename();
	        exportPath = PDF_EXPORT_PATH +  info.getExportname();
        	exportPdf(templatePath, exportPath, xmlData,pdid,prid);
	    } else {
	        throw new BLException("IGPDF0101.E001", pdid);
	    }
		log.debug("========PDF�����������========");
		return exportPath;
	}
    
    /** 
     * ���������PDF�����ļ�
     * 
     * @param fileNames PDF�����ļ�ȫ·��
     * @param response response
     * @return void
     * @throws BLException
     */
    public void toZipAndDownload(List<String> fileNames ,
    		HttpServletResponse res) throws BLException{
    	// �����
    	OutputStream output = null;
    	// ������
    	FileInputStream input = null;
    	try{
	    	Zip.toZip(PDF_EXPORT_PATH+PDF_ZIP_NAME, fileNames);
	        File file = new File(PDF_EXPORT_PATH+PDF_ZIP_NAME);
	    	//�ļ����ش���
			res.reset();
			res.setContentType("binary/octet-stream");
	    	res.setHeader("Content-Disposition", "attachment;filename=" +  new String(file.getName().getBytes("gb2312"),"iso-8859-1"));
	    	// �����ȡ��
			output = res.getOutputStream();
			// ������ȡ��
			input = new FileInputStream(file);
			int actual = 0;
			byte[] b = new byte[1024];
			
			while ((actual = input.read(b)) > 0) {
				output.write(b,0,actual);
			}
			output.flush();
    	}catch (Exception e) {
    		throw new BLException("IGPDF0101.E005");
		}finally {
			try {
				// �ر�������
				if(input != null){
					input.close();
					input = null;
				}
				// �ر������
				if(output != null){
					output.close();
					output = null;
				}
			} catch (Exception e) {
				log.error("DownloadAction Exception", e);
			}
		}
    }
    
    /** 
    * ����ѹ��ָ���ļ���Ŀ¼
    * @param fileNames ��Ҫ������ļ�������
    * @return void
    * @throws 
    */
    public void toZip(List<String> fileNames) throws BLException{
        try {
            Zip.toZip(PDF_EXPORT_PATH+PDF_ZIP_NAME, fileNames);
        } catch (Exception e) {
            throw new BLException("IGPDF0101.E005");
        }
    }
    
	/** 
	* PDF�ļ���������
	* 
	* @param tempPath ģ���ȡĿ¼
	* @param exportPath ������Ŀ¼
	* @param doc ������ݺ��xml����
	* @return void
	* @throws 
	*/
	@SuppressWarnings("unchecked")
	private void exportPdf(String tempPath, String exportPath, String xmlData,String pdid, Integer prid) throws BLException {
	    try {
            PdfReader reader = new PdfReader(tempPath);
            PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(exportPath),'\0',true);
            AcroFields form = stamper.getAcroFields();
            XfaForm xfa = form.getXfa();
            xfa.fillXfaForm(new ByteArrayInputStream(xmlData.getBytes("UTF-8")));
            //�������������߼� 2015��11��23��15:30:22 R-R-1 �������ϴ�����
            if(pdid.startsWith("11040")){
            	AttachmentBL attachmentBL  = (AttachmentBL) WebApplicationSupport.getBean("attachmentBL");
            	IG898BL ig898BL = (IG898BL) WebApplicationSupport.getBean("ig898BL");
            	IG898SearchCondImpl cond = new IG898SearchCondImpl(); 
            	cond.setPidid(pdid+"444");
            	cond.setPrid(prid);
            	cond.setPidname("��Ϣ�Ƽ�������ȱ���");
				List<IG898Info> ig898List = ig898BL.searchIG898(cond);
				if(ig898List!=null&&ig898List.size()>0){
					for(IG898Info info : ig898List){
						if("����".equals(info.getPvcolname())){
							List<Attachment> searchAttachmentsByAttkey = attachmentBL.searchAttachmentsByAttkey(info.getAttkey());
							if(searchAttachmentsByAttkey!=null&searchAttachmentsByAttkey.size()>0){
								Attachment att = searchAttachmentsByAttkey.get(0);
								String name = att.getAttname();
								if(name.split("_").length==2){
									name=name.split("_")[1];
								}else if(name.split("_").length>2){
									name=name.substring(name.indexOf("_")+1, name.length());
								}
								PdfFileSpecification fs = PdfFileSpecification.fileEmbedded(stamper.getWriter(), UPLOAD_FILE_ROOT_PATH + att.getAtturl() + File.separator + att.getAttname(), name, null);
								fs.setUnicodeFileName(name, true);
								stamper.addFileAttachment("", fs);
//								stamper.addFileAttachment("", null, UPLOAD_FILE_ROOT_PATH+"svc"+File.separator+att.getAttname(), name);
							}									
								
						}
					}
				}
            }
            //T-B-13 ����з���ѯ�������������ѡ�����û�а�����Դ�����벻��ֵ����
            else if(pdid.startsWith("11085")){
            	StringBuffer js = new StringBuffer();
            	List<Map<String, String>> list = new ArrayList<Map<String,String>>();
            	try {
					Document document = DocumentHelper.parseText(xmlData);
					Element root = document.getRootElement();
					List<Element> elements = root.elements("TB13001");
					if(elements != null){
						for(int i=0;i<elements.size();i++){
							Map<String, String> map = new HashMap<String, String>();
							map.put("COL22", elements.get(i).elementText("COL22"));
							map.put("COL23", elements.get(i).elementText("COL23"));
							map.put("COL24", elements.get(i).elementText("COL24"));
							map.put("COL25", elements.get(i).elementText("COL25"));
							list.add(map);
						}
					}
				} catch (org.dom4j.DocumentException e) {
					e.printStackTrace();
				}
        		js.append("var bskb_val = xfa.resolveNode('T_B_13.ҳ��1.�ӱ�1.isempty').rawValue;");//���Ϳձ�
        		js.append("if(bskb_val == \"���Ϳձ�\"){");
        		js.append("xfa.resolveNode('T_B_13.ҳ��1.submitForm1.ND').rawValue = 1;");
        		js.append("}");
        		js.append("var index = -1;");
        		js.append("var tables1 = xfa.resolveNode('T_B_13.ҳ��1.�ӱ�1').nodes;");//14
        		js.append("for(var i=0;i<tables1.length;i++){");//���Ϳձ� START
        		js.append("var TBITEM = tables1.item(i);");//start if
        			js.append("if(TBITEM.name == 'TB1'){");//start if
        				js.append("index++;");
        				//��ȡִ�����ֵ�����ļ����Ƿ��Ǳ��������������ֵ
        				js.append("var is_insert = TBITEM.DR1.�ӱ�2.TB2.DR2.�ӱ�8.YN_01.Radio1.rawValue;");
        				js.append("if(is_insert == '��'){");
        				js.append("TBITEM.DR1.�ӱ�2.TB2.DR2.�ӱ�8.num05.rawValue = 1;");
        				js.append("}");
        				
        				//��ȡִ���л�������ɣ���Ӧ����������
        				js.append("var is_ing = TBITEM.DR1.�ӱ�2.TB2.DR2.�ӱ�8.YN_02.Radio1.rawValue;");
        				
        				js.append("if(is_ing == 'ִ����'){");
        				js.append("TBITEM.DR1.�ӱ�2.TB2.DR2.�ӱ�8.num06.rawValue = 1;");
        				js.append("}");
        				js.append("var is_non = TBITEM.DR1.�ӱ�2.TB2.DR2.�ӱ�8.YN_02.Radio2.rawValue;");
        				js.append("if(is_non == '���'){");
        				js.append("TBITEM.DR1.�ӱ�2.TB2.DR2.�ӱ�8.num07.rawValue = 1;");
        				js.append("}");
        				
        				//�Ƿ�������
        				js.append("var is_wb1 = TBITEM.DR1.�ӱ�2.TB2.DR4.�ӱ�6.YN_01.Radio1.rawValue;");
        				js.append("var is_wb2 = TBITEM.DR1.�ӱ�2.TB2.DR4.�ӱ�6.YN_01.Radio2.rawValue;");
        				js.append("if(is_wb1 == 'ĸ��˾���ӹ�˾' || is_wb2 == '������˾��������'){");
        				js.append("TBITEM.DR1.�ӱ�2.TB2.DR4.�ӱ�6.num09.rawValue = 1;");
        				js.append("}");
        				
        				//�쳣�˳����
        				js.append("var is_e = TBITEM.DR1.�ӱ�2.TB2.DR4.�ӱ�3.YN_01.Radio1.rawValue;");
        				js.append("if(is_e == '��'){");
        				js.append("TBITEM.DR1.�ӱ�2.TB2.DR4.�ӱ�3.num08.rawValue = 1;");
        				js.append("}");
        				
        				//�Ƿ�羳���
        				js.append("var is_kj = TBITEM.DR1.�ӱ�2.TB2.DR4.�ӱ�7.YN_01.Radio1.rawValue;");
        				js.append("if(is_kj == '�羳���'){");
        				js.append("TBITEM.DR1.�ӱ�2.TB2.DR4.�ӱ�7.num10.rawValue = 1;");
        				js.append("}");
        				
        				//�Ƿ��פ�����
        				js.append("var is_zc = TBITEM.DR1.�ӱ�2.TB2.DR2.�ӱ�4.YN_01.Radio2.rawValue;");
        				js.append("if(is_zc == '��פ�����'){");
        				js.append("TBITEM.DR1.�ӱ�2.TB2.DR2.�ӱ�4.num11.rawValue = 1;");
        				js.append("}");
        			
        				js.append("var yfzx_val = TBITEM.DR1.�ӱ�2.TB2.DR2.�ӱ�2.item1001.rawValue;");//�з���ѯ��
        				js.append("var strArr = yfzx_val.split(',');");
        					js.append("for(var j=0;j<strArr.length;j++){");//for start
        						js.append("if(strArr[j] == '�Ƽ������Ƽ��������ѯ���'){");
        						js.append("TBITEM.DR1.�ӱ�2.TB2.DR2.�ӱ�2.��ѡ��1.rawValue = 1;");//DR1.�ӱ�2.TB2.DR2.�ӱ�2.��ѡ��1
        						js.append("}");
        						js.append("if(strArr[j] == 'ϵͳ����'){");
        						js.append("TBITEM.DR1.�ӱ�2.TB2.DR2.�ӱ�2.��ѡ��2.rawValue = 1;");
        						js.append("}");
        						js.append("if(strArr[j] == '����'){");
        						js.append("TBITEM.DR1.�ӱ�2.TB2.DR2.�ӱ�2.��ѡ��3.rawValue = 1;");
        						js.append("}");
        						js.append("if(strArr[j] == '����'){");
        						js.append("TBITEM.DR1.�ӱ�2.TB2.DR2.�ӱ�2.��ѡ��4.rawValue = 1;");
        						js.append("var temp_obj = TBITEM.DR1.�ӱ�2.TB2.DR2.�ӱ�2.hidden01;");
        						js.append("temp_obj.presence = 'visible';");
        						js.append("if(temp_obj.rawValue == null || temp_obj.rawValue == ''){");
        						for(int i=0;i<list.size();i++){
                					js.append("if(index == " + i +  "){");
                					js.append("TBITEM.DR1.�ӱ�2.TB2.DR2.�ӱ�2.hidden01.rawValue = '" + list.get(i).get("COL22") + "';");
                					js.append("}");
                				}
        						js.append("}");
        						js.append("}");
        					js.append("}");//for strArr
        					
        					js.append("var xtyxwh_val = TBITEM.DR1.�ӱ�2.TB2.DR2.�ӱ�2.item1002.rawValue;");//ϵͳ����ά����
        					js.append("var strArr1 = xtyxwh_val.split(',');");
        					js.append("for(var w=0;w<strArr1.length;w++){");
        						js.append("if(strArr1[w] == '��������������ά'){");
        						js.append("TBITEM.DR1.�ӱ�2.TB2.DR2.�ӱ�2.��ѡ��5.rawValue = 1;");
        						js.append("}");
        						js.append("if(strArr1[w] == '����������ʩ��ά'){");
        						js.append("TBITEM.DR1.�ӱ�2.TB2.DR2.�ӱ�2.��ѡ��6.rawValue = 1;");
        						js.append("}");
        						js.append("if(strArr1[w] == '���罨�輰��ά'){");
        						js.append("TBITEM.DR1.�ӱ�2.TB2.DR2.�ӱ�2.��ѡ��7.rawValue = 1;");
        						js.append("}");
        						js.append("if(strArr1[w] == 'ϵͳ��Ӧ����ά'){");
        						js.append("TBITEM.DR1.�ӱ�2.TB2.DR2.�ӱ�2.��ѡ��8.rawValue = 1;");
        						js.append("}");
        						js.append("if(strArr1[w] == '�����豸��ά'){");
        						js.append("TBITEM.DR1.�ӱ�2.TB2.DR2.�ӱ�2.��ѡ��9.rawValue = 1;");
        						js.append("}");
        						js.append("if(strArr1[w] == '����'){");
        						js.append("TBITEM.DR1.�ӱ�2.TB2.DR2.�ӱ�2.��ѡ��10.rawValue = 1;");
        						js.append("var temp_obj2 = TBITEM.DR1.�ӱ�2.TB2.DR2.�ӱ�2.hidden02;");
        						js.append("temp_obj2.presence = 'visible';");
        						js.append("if(temp_obj2.rawValue == null || temp_obj2.rawValue == ''){");
        						for(int i=0;i<list.size();i++){
                					js.append("if(index == " + i +  "){");
                					js.append("TBITEM.DR1.�ӱ�2.TB2.DR2.�ӱ�2.hidden02.rawValue = '" + list.get(i).get("COL23") + "';");
                					js.append("}");
                				}
        						js.append("}");
        						js.append("}");
        					js.append("}");
        					
        					js.append("var ywwb_val = TBITEM.DR1.�ӱ�2.TB2.DR2.�ӱ�2.item1003.rawValue;");//ҵ������е���Ϣ�Ƽ����
        					js.append("var strArr2 = ywwb_val.split(',');");
        					js.append("for(var q=0;q<strArr2.length;q++){");
        						js.append("if(strArr2[q] == 'ϵͳ����'){");
        						js.append("TBITEM.DR1.�ӱ�2.TB2.DR2.�ӱ�2.��ѡ��11.rawValue = 1;");
        						js.append("}");
        						js.append("if(strArr2[q] == '����ά��'){");
        						js.append("TBITEM.DR1.�ӱ�2.TB2.DR2.�ӱ�2.��ѡ��12.rawValue = 1;");
        						js.append("}");
        						js.append("if(strArr2[q] == '���ݴ���'){");
        						js.append("TBITEM.DR1.�ӱ�2.TB2.DR2.�ӱ�2.��ѡ��13.rawValue = 1;");
        						js.append("}");
        						js.append("if(strArr2[q] == '����'){");
        						js.append("TBITEM.DR1.�ӱ�2.TB2.DR2.�ӱ�2.��ѡ��14.rawValue = 1;");
        						js.append("var temp_obj4 = TBITEM.DR1.�ӱ�2.TB2.DR2.�ӱ�2.hidden03;");
        						js.append("temp_obj4.presence = 'visible';");
        						js.append("if(temp_obj4.rawValue == null || temp_obj4.rawValue == ''){");
        						for(int i=0;i<list.size();i++){
                					js.append("if(index == " + i +  "){");
                					js.append("TBITEM.DR1.�ӱ�2.TB2.DR2.�ӱ�2.hidden03.rawValue = '" + list.get(i).get("COL25") + "';");
                					js.append("}");
                				}
        						js.append("}");
        					js.append("}");
        					js.append("}");
        					
        					js.append("var ht_yxywlx_val = TBITEM.DR1.�ӱ�2.TB2.DR2.�ӱ�5.item1004.rawValue;");//��ͬ-Ӱ��ҵ������
        					js.append("var strArr3 = ht_yxywlx_val.split(',');");
        					js.append("for(var p=0;p<strArr3.length;p++){");
        					js.append("		if(strArr3[p] == '����������'){");
        					js.append("			TBITEM.DR1.�ӱ�2.TB2.DR2.�ӱ�5.��ѡ��1.rawValue = 1;");
        					js.append("		}");
        					js.append("		if(strArr3[p] == '�ͻ�������'){");
        					js.append("			TBITEM.DR1.�ӱ�2.TB2.DR2.�ӱ�5.��ѡ��2.rawValue = 1;");
        					js.append("		}");
        					js.append("		if(strArr3[p] == '��Ʒ������'){");
        					js.append("			TBITEM.DR1.�ӱ�2.TB2.DR2.�ӱ�5.��ѡ��3.rawValue = 1;");
        					js.append("		}");
        					js.append("		if(strArr3[p] == '���������'){");
        					js.append("			TBITEM.DR1.�ӱ�2.TB2.DR2.�ӱ�5.��ѡ��4.rawValue = 1;");
        					js.append("		}");
        					js.append("		if(strArr3[p] == '����֧����'){");
        					js.append("			TBITEM.DR1.�ӱ�2.TB2.DR2.�ӱ�5.��ѡ��5.rawValue = 1;");
        					js.append("		}");
        					js.append("		if(strArr3[p] == '����֧����'){");
        					js.append("			TBITEM.DR1.�ӱ�2.TB2.DR2.�ӱ�5.��ѡ��6.rawValue = 1;");
        					js.append("		}");
        					js.append("		if(strArr3[p] == '������ʩ��'){");
        					js.append("			TBITEM.DR1.�ӱ�2.TB2.DR2.�ӱ�5.��ѡ��7.rawValue = 1;");
        					js.append("		}");
        					js.append("		if(strArr3[p] == '����'){");
        					js.append("			TBITEM.DR1.�ӱ�2.TB2.DR2.�ӱ�5.��ѡ��8.rawValue = 1;");
        					js.append("var temp_obj3 = TBITEM.DR1.�ӱ�2.TB2.DR2.�ӱ�5.hidden04;");
        					js.append("			temp_obj3.presence = 'visible';");
        					js.append("if(temp_obj3.rawValue == null || temp_obj3.rawValue == ''){");
        					for(int i=0;i<list.size();i++){
            					js.append("if(index == " + i +  "){");
            					js.append("TBITEM.DR1.�ӱ�2.TB2.DR2.�ӱ�5.hidden04.rawValue = '" + list.get(i).get("COL24") + "';");
            					js.append("}");
            				}
        					js.append("		}");
        					js.append("}");
        					js.append("}");
        					
        				js.append("}");//if table.name end
        			js.append("}");//for tables1 end
        			
        			stamper.addJavaScript(js.toString());
            }
            //���T-Q-2��δ������Դ�����´�����ֵ������
            else if(pdid.startsWith("21040")){
            	List<Map<String, String>> list = new ArrayList<Map<String,String>>();
            	try {
					Document document = DocumentHelper.parseText(xmlData);
					Element root = document.getRootElement();
					List<Element> elements = root.elements("TQ2001");
					if(elements != null){
						for(int i=0;i<elements.size();i++){
							Map<String, String> map = new HashMap<String, String>();
							map.put("COL14", elements.get(i).elementText("COL14"));
							map.put("COL15", elements.get(i).elementText("COL15"));
							map.put("COL16", elements.get(i).elementText("COL16"));
							map.put("COL17", elements.get(i).elementText("COL17"));
							map.put("COL18", elements.get(i).elementText("COL18"));
							map.put("COL19", elements.get(i).elementText("COL19"));
							map.put("COL20", elements.get(i).elementText("COL20"));
							list.add(map);
						}
					}
				} catch (org.dom4j.DocumentException e) {
					e.printStackTrace();
				}
            	StringBuffer js = new StringBuffer();
        		//��䱨�Ϳձ�ѡ���
        		js.append("var isempty = xfa.resolveNode('T_Q_2.isempty').rawValue;");
        		js.append("if(isempty == '���Ϳձ�'){");
        		js.append("xfa.resolveNode('T_Q_2.page1.Subform1.ND').rawValue = 1;");
        		js.append("}");
        		//��ȡ�������ݱ��
        		js.append("var tables = xfa.resolveNode('T_Q_2.page1').nodes;");
        		js.append("var index = -1;");
        		js.append("for(var i=0;i<tables.length;i++){");
        		js.append("var table = tables.item(i);");
        		js.append("if(table.name == 'DR1'){");
        		js.append("index++;");
        		
        		//��伾��ʵʩ���ѡ���
        		js.append("var quarter_info = table.Table8.Row1.subform10.item6.rawValue;");
        		js.append("if(quarter_info){");
        		js.append("var quarter_values = quarter_info.split(',');");
        		js.append("for(var n=0;n<quarter_values.length;n++){");
        		js.append("if(quarter_values[n] == '����'){");
        		js.append("table.Table8.Row1.subform10.CB_SYS_TYPE00.rawValue = 1;");
        		js.append("}");
        		js.append("if(quarter_values[n] == 'ִ����'){");
        		js.append("table.Table8.Row1.subform10.CB_SYS_TYPE01.rawValue = 1;");
        		js.append("}");
        		js.append("if(quarter_values[n] == '�����'){");
        		js.append("table.Table8.Row1.subform10.CB_SYS_TYPE02.rawValue = 1;");
        		js.append("}");
        		js.append("}");
        		js.append("}");
        		//���ϵͳ���ѡ���
        		js.append("var system_type_info = table.Table8.Row1.subform20.Table11.Row1.Cell1.item6.rawValue;");
        		js.append("if(system_type_info){");
        		js.append("var system_type_values = system_type_info.split(',');");
        		js.append("for(var n=0;n<system_type_values.length;n++){");
        		js.append("if(system_type_values[n] == '��������'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row1.Cell1.CB_SYS_TYPE1.rawValue = 1;");
        		//����������������
        		js.append("var channel_chile_type_info = table.Table8.Row1.subform20.Table11.Row1.Cell2.cell.rawValue;");
        		js.append("if(channel_chile_type_info){");
        		js.append("var channel_chile_type_values = channel_chile_type_info.split(',');");
        		js.append("for(var n1=0;n1<channel_chile_type_values.length;n1++){");
        		js.append("if(channel_chile_type_values[n1] == 'ǰ����'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row1.Cell2.CheckBox1.rawValue = 1;");
        		js.append("}");
        		js.append("if(channel_chile_type_values[n1] == '��Ա��'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row1.Cell2.CheckBox2.rawValue = 1;");
        		js.append("}");
        		js.append("if(channel_chile_type_values[n1] == 'ATM'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row1.Cell2.CheckBox3.rawValue = 1;");
        		js.append("}");
        		js.append("if(channel_chile_type_values[n1] == 'POS'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row1.Cell2.CheckBox4.rawValue = 1;");
        		js.append("}");
        		js.append("if(channel_chile_type_values[n1] == '���п�'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row1.Cell2.CheckBox5.rawValue = 1;");
        		js.append("}");
        		js.append("if(channel_chile_type_values[n1] == '�����ն�'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row1.Cell2.CheckBox6.rawValue = 1;");
        		js.append("}");
        		js.append("if(channel_chile_type_values[n1] == '��������'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row1.Cell2.CheckBox7.rawValue = 1;");
        		js.append("}");
        		js.append("if(channel_chile_type_values[n1] == '�绰����'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row1.Cell2.CheckBox8.rawValue = 1;");
        		js.append("}");
        		js.append("if(channel_chile_type_values[n1] == '�ֻ�����'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row1.Cell2.CheckBox9.rawValue = 1;");
        		js.append("}");
        		js.append("if(channel_chile_type_values[n1] == '����'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row1.Cell2.CheckBox10.rawValue = 1;");
        		js.append("var temp_obj1 = table.Table8.Row1.subform20.Table11.Row1.Cell2.O_item7;");
        		js.append("temp_obj1.presence = 'visible';");
        		js.append("if(temp_obj1.rawValue == null || temp_obj1.rawValue == ''){");
        		for(int i=0;i<list.size();i++){
        			js.append("if(index == " + i +  "){");
					js.append("temp_obj1.rawValue = '" + list.get(i).get("COL14") + "';");
					js.append("}");
        		}
        		js.append("}");
        		js.append("}");
        		js.append("}");
        		js.append("}");
        		js.append("}");
        		js.append("if(system_type_values[n] == '�ͻ�����'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row2.Cell1.CB_SYS_TYPE1.rawValue = 1;");
        		//���ͻ����������
        		js.append("var customer_manager_child_type_info = table.Table8.Row1.subform20.Table11.Row2.Cell2.cell.rawValue;");
        		js.append("if(customer_manager_child_type_info){");
        		js.append("var customer_manager_child_type_values = customer_manager_child_type_info.split(',');");
        		js.append("for(var n2=0;n2<customer_manager_child_type_values.length;n2++){");
        		js.append("if(customer_manager_child_type_values[n2] == '��˽�ͻ���ϵ����'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row2.Cell2.CheckBox1.rawValue = 1;");
        		js.append("}");
        		js.append("if(customer_manager_child_type_values[n2] == '�Թ��ͻ���ϵ����'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row2.Cell2.CheckBox2.rawValue = 1;");
        		js.append("}");
        		js.append("if(customer_manager_child_type_values[n2] == '�ͻ���Ϣ����'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row2.Cell2.CheckBox3.rawValue = 1;");
        		js.append("}");
        		js.append("if(customer_manager_child_type_values[n2] == '����'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row2.Cell2.CheckBox4.rawValue = 1;");
        		js.append("var temp_obj2 = table.Table8.Row1.subform20.Table11.Row2.Cell2.O_item9;");
        		js.append("temp_obj2.presence = 'visible';");
        		js.append("if(temp_obj2.rawValue == null || temp_obj2.rawValue == ''){");
        		for(int i=0;i<list.size();i++){
        			js.append("if(index == " + i +  "){");
					js.append("temp_obj2.rawValue = '" + list.get(i).get("COL15") + "';");
					js.append("}");
        		}
        		js.append("}");
        		
        		js.append("}");
        		js.append("}");
        		js.append("}");
        		js.append("}");
        		js.append("if(system_type_values[n] == '��Ʒ����'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row3.Cell1.CB_SYS_TYPE1.rawValue = 1;");
        		//����Ʒ���������ѡ���
        		js.append("var product_child_type_info = table.Table8.Row1.subform20.Table11.Row3.Cell2.cell.rawValue;");
        		js.append("if(product_child_type_info){");
        		js.append("var product_child_type_values = product_child_type_info.split(',');");
        		js.append("for(var n3=0;n3<product_child_type_values.length;n3++){");
        		js.append("if(product_child_type_values[n3] == '����ҵ��ϵͳ'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row3.Cell2.CheckBox1.rawValue = 1;");
        		js.append("}");
        		js.append("if(product_child_type_values[n3] == '�Թ�����'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row3.Cell2.CheckBox2.rawValue = 1;");
        		js.append("}");
        		js.append("if(product_child_type_values[n3] == '�Թ����'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row3.Cell2.CheckBox3.rawValue = 1;");
        		js.append("}");
        		js.append("if(product_child_type_values[n3] == '�Թ����'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row3.Cell2.CheckBox3.rawValue = 1;");
        		js.append("}");
        		js.append("if(product_child_type_values[n3] == '��˽����'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row3.Cell2.CheckBox4.rawValue = 1;");
        		js.append("}");
        		js.append("if(product_child_type_values[n3] == '��˽���'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row3.Cell2.CheckBox5.rawValue = 1;");
        		js.append("}");
        		js.append("if(product_child_type_values[n3] == '֧������'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row3.Cell2.CheckBox6.rawValue = 1;");
        		js.append("}");
        		js.append("if(product_child_type_values[n3] == 'Ͷ������'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row3.Cell2.CheckBox7.rawValue = 1;");
        		js.append("}");
        		js.append("if(product_child_type_values[n3] == 'ó������'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row3.Cell2.CheckBox8.rawValue = 1;");
        		js.append("}");
        		js.append("if(product_child_type_values[n3] == '������Ʒ'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row3.Cell2.CheckBox9.rawValue = 1;");
        		js.append("}");
        		js.append("if(product_child_type_values[n3] == '���ʽ���'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row3.Cell2.CheckBox10.rawValue = 1;");
        		js.append("}");
        		js.append("if(product_child_type_values[n3] == '�����Ʒ'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row3.Cell2.CheckBox11.rawValue = 1;");
        		js.append("}");
        		js.append("if(product_child_type_values[n3] == '�����Ʋ�Ʒ'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row3.Cell2.CheckBox12.rawValue = 1;");
        		js.append("}");
        		js.append("if(product_child_type_values[n3] == '����ҵ��'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row3.Cell2.CheckBox13.rawValue = 1;");
        		js.append("}");
        		js.append("if(product_child_type_values[n3] == '���ÿ�'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row3.Cell2.CheckBox14.rawValue = 1;");
        		js.append("}");
        		js.append("if(product_child_type_values[n3] == '����'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row3.Cell2.CheckBox15.rawValue = 1;");
        		js.append("}");
        		js.append("if(product_child_type_values[n3] == '����'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row3.Cell2.CheckBox16.rawValue = 1;");
        		
        		js.append("var temp_obj3 = table.Table8.Row1.subform20.Table11.Row3.Cell2.O_item11;");
        		js.append("temp_obj3.presence = 'visible';");
        		js.append("if(temp_obj3.rawValue == null || temp_obj3.rawValue == ''){");
        		for(int i=0;i<list.size();i++){
        			js.append("if(index == " + i +  "){");
					js.append("temp_obj3.rawValue = '" + list.get(i).get("COL16") + "';");
					js.append("}");
        		}
        		js.append("}");
        		
        		js.append("}");
        		js.append("}");
        		js.append("}");
        		js.append("}");
        		js.append("if(system_type_values[n] == '�������'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row4.Cell1.CB_SYS_TYPE1.rawValue = 1;");
        		//�������������ѡ���
        		js.append("var finance_child_type_info = table.Table8.Row1.subform20.Table11.Row4.Cell2.cell.rawValue;");
        		js.append("if(finance_child_type_info){");
        		js.append("var finance_child_type_values = finance_child_type_info.split(',');");
        		js.append("for(var n4=0;n4<finance_child_type_values.length;n4++){");
        		js.append("if(finance_child_type_values[n4] == 'Ԥ�����'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row4.Cell2.CheckBox1.rawValue = 1;");
        		js.append("}");
        		js.append("if(finance_child_type_values[n4] == '�̶��ʲ�'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row4.Cell2.CheckBox2.rawValue = 1;");
        		js.append("}");
        		js.append("if(finance_child_type_values[n4] == 'Ӧ��Ӧ��'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row4.Cell2.CheckBox3.rawValue = 1;");
        		js.append("}");
        		js.append("if(finance_child_type_values[n4] == '�ʽ���'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row4.Cell2.CheckBox4.rawValue = 1;");
        		js.append("}");
        		js.append("if(finance_child_type_values[n4] == '����'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row4.Cell2.CheckBox5.rawValue = 1;");
        		
        		js.append("var temp_obj4 = table.Table8.Row1.subform20.Table11.Row4.Cell2.O_item13;");
        		js.append("temp_obj4.presence = 'visible';");
        		js.append("if(temp_obj4.rawValue == null || temp_obj4.rawValue == ''){");
        		for(int i=0;i<list.size();i++){
        			js.append("if(index == " + i +  "){");
					js.append("temp_obj4.rawValue = '" + list.get(i).get("COL17") + "';");
					js.append("}");
        		}
        		js.append("}");
        		
        		js.append("}");
        		js.append("}");
        		js.append("}");
        		js.append("}");
        		js.append("if(system_type_values[n] == '����֧��'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row5.Cell1.CB_SYS_TYPE1.rawValue = 1;");
        		//������֧��ѡ���
        		js.append("var decision_support_child_type_info = table.Table8.Row1.subform20.Table11.Row5.Cell2.cell.rawValue;");
        		js.append("if(decision_support_child_type_info){");
        		js.append("var decision_support_child_type_values = decision_support_child_type_info.split(',');");
        		js.append("for(var n5=0;n5<decision_support_child_type_values.length;n5++){");
        		js.append("if(decision_support_child_type_values[n5] == '���ݲֿ�'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row5.Cell2.CheckBox1.rawValue = 1;");
        		js.append("}");
        		js.append("if(decision_support_child_type_values[n5] == '��Ч����'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row5.Cell2.CheckBox2.rawValue = 1;");
        		js.append("}");
        		js.append("if(decision_support_child_type_values[n5] == '���չ���'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row5.Cell2.CheckBox3.rawValue = 1;");
        		js.append("}");
        		js.append("if(decision_support_child_type_values[n5] == '�ʲ���ծ����'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row5.Cell2.CheckBox4.rawValue = 1;");
        		js.append("}");
        		js.append("if(decision_support_child_type_values[n5] == '����'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row5.Cell2.CheckBox5.rawValue = 1;");
        		
        		js.append("var temp_obj5 = table.Table8.Row1.subform20.Table11.Row5.Cell2.O_item15;");
        		js.append("temp_obj5.presence = 'visible';");
        		js.append("if(temp_obj5.rawValue == null || temp_obj5.rawValue == ''){");
        		for(int i=0;i<list.size();i++){
        			js.append("if(index == " + i +  "){");
					js.append("temp_obj5.rawValue = '" + list.get(i).get("COL18") + "';");
					js.append("}");
        		}
        		js.append("}");
        		
        		js.append("}");
        		js.append("}");
        		js.append("}");
        		js.append("}");
        		js.append("if(system_type_values[n] == '����֧��'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row6.Cell1.CB_SYS_TYPE1.rawValue = 1;");
        		//��乲��֧��ѡ���
        		js.append("var share_child_type_info = table.Table8.Row1.subform20.Table11.Row6.Cell2.cell.rawValue;");
        		js.append("if(share_child_type_info){");
        		js.append("var share_child_type_values = share_child_type_info.split(',');");
        		js.append("for(var n6=0;n6<share_child_type_values.length;n6++){");
        		js.append("if(share_child_type_values[n6] == '��ѺƷ/��ѺƷ����'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row6.Cell2.CheckBox1.rawValue = 1;");
        		js.append("}");
        		js.append("if(share_child_type_values[n6] == '���ݹ���'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row6.Cell2.CheckBox2.rawValue = 1;");
        		js.append("}");
        		js.append("if(share_child_type_values[n6] == '����֧��'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row6.Cell2.CheckBox3.rawValue = 1;");
        		js.append("}");
        		js.append("if(share_child_type_values[n6] == '����'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row6.Cell2.CheckBox4.rawValue = 1;");
        		
        		js.append("var temp_obj6 = table.Table8.Row1.subform20.Table11.Row6.Cell2.O_item17;");
        		js.append("temp_obj6.presence = 'visible';");
        		js.append("if(temp_obj6.rawValue == null || temp_obj6.rawValue == ''){");
        		for(int i=0;i<list.size();i++){
        			js.append("if(index == " + i +  "){");
					js.append("temp_obj6.rawValue = '" + list.get(i).get("COL19") + "';");
					js.append("}");
        		}
        		js.append("}");
        		
        		js.append("}");
        		js.append("}");
        		js.append("}");
        		js.append("}");
        		js.append("if(system_type_values[n] == '������ʩ'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row7.Cell1.CB_SYS_TYPE1.rawValue = 1;");
        		//��������ʩ����ѡ���
        		js.append("var basis_child_type_info = table.Table8.Row1.subform20.Table11.Row7.Cell2.cell.rawValue;");
        		js.append("if(basis_child_type_info){");
        		js.append("var basis_child_type_values = basis_child_type_info.split(',');");
        		js.append("for(var n7=0;n7<basis_child_type_values.length;n7++){");
        		js.append("if(basis_child_type_values[n7] == '���罨����'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row7.Cell2.CheckBox1.rawValue = 1;");
        		js.append("}");
        		js.append("if(basis_child_type_values[n7] == '���� /�洢������'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row7.Cell2.CheckBox2.rawValue = 1;");
        		js.append("}");
        		js.append("if(basis_child_type_values[n7] == '��������/����������'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row7.Cell2.CheckBox3.rawValue = 1;");
        		js.append("}");
        		js.append("if(basis_child_type_values[n7] == '����'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row7.Cell2.CheckBox4.rawValue = 1;");
        		
        		js.append("var temp_obj7 = table.Table8.Row1.subform20.Table11.Row7.Cell2.O_item88;");
        		js.append("temp_obj7.presence = 'visible';");
        		js.append("if(temp_obj7.rawValue == null || temp_obj7.rawValue == ''){");
        		for(int i=0;i<list.size();i++){
        			js.append("if(index == " + i +  "){");
					js.append("temp_obj7.rawValue = '" + list.get(i).get("COL20") + "';");
					js.append("}");
        		}
        		js.append("}");
        		
        		js.append("}");
        		js.append("}");
        		js.append("}");
        		js.append("}");
        		js.append("if(system_type_values[n] == '����'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row8.Cell1.CB_SYS_TYPE_O.rawValue = 1;");
        		js.append("table.Table8.Row1.subform20.Table11.Row8.CB_SYS_TYPE_O_Item.access = 'open';");
        		js.append("}");
        		js.append("}");
        		js.append("}");
        		
        		js.append("}");
        		js.append("}");
        		
        		
        		stamper.addJavaScript(js.toString());
            }
        	WorkFlowOperationBL workFlowOperationBL = (WorkFlowOperationBL) WebApplicationSupport.getBean("workFlowOperationBL");
        	Map<IG036Info, List<Attachment>> map = workFlowOperationBL.searchRecordLog(prid);
        	for(Iterator<Entry<IG036Info, List<Attachment>>> iter = map.entrySet().iterator();iter.hasNext();){
        		Entry<IG036Info, List<Attachment>> entry = iter.next();
        		List<Attachment> list = entry.getValue();
        		for(int i=0;i<list.size();i++){
        			Attachment att = list.get(i);
					String name = att.getAttname().substring(att.getAttname().toString().indexOf("_") + 1);
					PdfFileSpecification fs = PdfFileSpecification.fileEmbedded(stamper.getWriter(), UPLOAD_FILE_ROOT_PATH + att.getAtturl() + File.separator + att.getAttname(), name, null);
					fs.setUnicodeFileName(name, true);
					stamper.addFileAttachment("", fs);
        		}
        		
        	}
            stamper.close();
            reader.close();
	    } catch (DocumentException e) {
            throw new BLException("IGPDF0101.E004");
        } catch (IOException e) {
            throw new BLException("IGPDF0101.E002", tempPath);
        }
    }

	
}
