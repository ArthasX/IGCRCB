package com.deliverik.infogovernor.pdf.xmlbean;

import java.io.File;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.pdf.model.PdfIg898MapVWInfo;

/**
 * ����: ����XML�ļ���
 * ��������������XML�ļ���
 * �����ˣ�deliverik
 * ������¼��2013-7-26
 * �޸ļ�¼��
 */
public class PdfXmlDoc {
    
    /** ����XML���·��*/ 
    private final String PDF_XML_PATH = 
        ResourceUtility.getString("PDF_XML_PATH"); 
        
    /** XML��������*/ 
    private Document xmlDocument;

    /** XML���ڵ�*/ 
    private Element root ;
    
    
    
    public Element getRootElement(){
    	return root;
    }
    
    /** 
    * ����XML�๹�췽������ȡXML�ļ��õ��ɲ�������
    * 
    * @param xmlFileName xml�ļ�����
    * @return void
    * @throws 
    */
    public PdfXmlDoc(String xmlFileName) throws BLException {
        try {
            File f = new File(PDF_XML_PATH + xmlFileName);
            SAXReader reader = new SAXReader();
            xmlDocument= reader.read(f);
            root = xmlDocument.getRootElement(); 
        } catch (DocumentException e) {
            throw new BLException("IGPDF0101.E003", PDF_XML_PATH +xmlFileName);
        }
    }
    
    /** 
    * ȡ��XML����
    * @param 
    * @return String Xml����
    * @throws 
    */
    public String asXml() {
        return xmlDocument.asXML();
    }
    
    /** 
    * ���xml�ڵ�
    * @param xml�ڵ����
    * @return void
    * @throws 
    */
    public void addElement(Element pelement, Element element) {
        pelement.add(element);
    }
    
    /** 
     * ���xml�ڵ�
     * @param xml�ڵ����
     * @return void
     * @throws 
     */
    public void addElement(Element element) {
        root.add(element);
    }
    
    /** 
    * ɾ��xml�ڵ�
    * @param xml�ڵ����
    * @return void
    * @throws 
    */
    public void removeElement(Element element) {
        root.remove(element);
    }
    
    /** 
     * ɾ��xml�ڵ�
     * @param xml�ڵ����
     * @return void
     * @throws 
     */
    public void removeElement(Element pelement, Element element) {
        pelement.remove(element);
    }
    
    /** 
    * ����ָ�����ڵ�·��ȡ��xml�ڵ����
    * @param ���ڵ�·������#�ָ���
    * @return Element
    * @throws 
    */
    public Element getElement(String pdatabinding) {
        Element element = root;
        if (StringUtils.isNotEmpty(pdatabinding)) {
            String[] pdatabindings = pdatabinding.split("#");
            for (int i = 0; i < pdatabindings.length; i++) {
                element = element.element(pdatabindings[i]);
            }
        }
        return element;
    }
    
    /** 
     * ���̱��������xml
     * @param pdatabinding xml���ڵ���
     * @param databinding xml�ڵ���
     * @param pvalue ����������
     * @param formtype ��ֵ����
     * @return void
     * @throws 
     */
    public static void setPvalueIntoXml(Element element, String databinding, String pvalue, String formtype) {
        if (StringUtils.isNotEmpty(pvalue)) {
            if ("E".equals(formtype)) {
                // ��ѡ���� 
                setDanxuanQita(element, databinding, pvalue);
             } else if ("S".equals(formtype)) {
                 // ��ѡ����
                 setDuoxuanQita(element, databinding, pvalue);
             } else if ("3".equals(formtype)) {
                 // ����
                 pvalue = pvalue.replaceAll("/", "-");
                 element.element(databinding).setText(pvalue);
             } else if("C".equals(formtype)) {
                 // ��ѡ
                 if (databinding.equals("isempty")) {
                     element.element(databinding).setText(pvalue);
                 } else {
                     pvalue =","+pvalue.replaceAll("#", ",");
                     element.element(databinding).setText(pvalue);
                 }
             } else if ("A".equals(formtype)) {
                 // ʱ��
                 setShijian(element, databinding, pvalue) ;
             } else if ("9".equals(formtype)) {
                 // �ı���
            	String temp = pvalue.replaceAll("<P>", "").replaceAll("</P>", "").replaceAll("&nbsp;", " ").replaceAll("<BR>", "\r\n");
                 element.element(databinding).setText(temp);
             } else {
            	 String temp = pvalue.replaceAll("<P>", "").replaceAll("</P>", "").replaceAll("&nbsp;", " ").replaceAll("<BR>", "\r\n");
                 element.element(databinding).setText(temp);
            }
        }
     }
    
    /** 
     * �ѱ��ʽ�������̱��������õ�xml��
     * 
     * @param element XML��������
     * @param oneFormValueList һ�����ʽ����ֵ�б�
     * @return void
     * @throws 
     */
    public static void setPvalueListIntoXml(Element element, List<PdfIg898MapVWInfo> oneFormValueList) {
         String pvalue, formtype, databinding ;
         for (int i = 0; i < oneFormValueList.size(); i++) {
             PdfIg898MapVWInfo info = oneFormValueList.get(i);
             pvalue = info.getPvalue();
             formtype = info.getFormtype();
             databinding = info.getDatabinding();
             if (StringUtils.isNotEmpty(pvalue)) {
                 String[] databindings = databinding.split("#");
                	 setPvalueIntoXml(element, databindings[i], pvalue, formtype);
             }
         }
     }
     
    /** 
     * ��ѡ�������ͱ�ֵ���
     * @param element XML��������
     * @param databindings ��ѡ��������XML���ֶ�
     * @param pvalue ��ѡ������ֵ
     * @return void
     * @throws 
     */
     private static void setDuoxuanQita(Element element, String databinding, String pvalue) {
           String[] databindings = databinding.split(",");
           if (databindings.length == 2) {
               int elseIndexFrom = pvalue.indexOf("cv_cev_") ;
               if (elseIndexFrom != -1) {
                   int elseIndexTo = pvalue.indexOf("#", elseIndexFrom);
                   if (elseIndexTo == -1) {
                       elseIndexTo = pvalue.length();
                   }
                   String elseContent = pvalue.substring(elseIndexFrom, elseIndexTo);
                   String checkedItem = pvalue.replaceAll(elseContent, "����");
                   if (StringUtils.isNotEmpty(checkedItem)) {
                       checkedItem =","+checkedItem.replaceAll("#", ",") + ",";
                       element.element(databindings[0]).setText(checkedItem);
                   }
                   element.element(databindings[1]).setText(elseContent.replaceAll("cv_cev_", ""));
               } else {
                   pvalue =","+pvalue.replaceAll("#", ",")+ ",";
                   element.element(databindings[0]).setText(pvalue);
               }
           }
       }
     
     /** 
      * ��ѡ�������ͱ�ֵ���
      * @param element XML��������
      * @param databindings ��ѡ��������XML���ֶ�
      * @param pvalue ��ѡ������ֵ
      * @return void
      * @throws 
      */
      private static void setDanxuanQita(Element element, String databinding, String pvalue) {
          String[] databindings = databinding.split(",");
          if (databindings.length == 2) {
              if (pvalue.indexOf("cv_cev_") != -1) {
                  // ���ѡ����������ͬʱ��������ѡ�����������
                  element.element(databindings[0]).setText("����");
                  element.element(databindings[1]).setText(pvalue.replaceAll("cv_cev_", ""));
              } else {
                  element.element(databindings[0]).setText(pvalue);
              }
          }
      }
      
      /** 
       * ʱ�����ͱ�ֵ���
       * @param element XML��������
       * @param databindings ��ѡ��������XML���ֶ�
       * @param pvalue ��ѡ������ֵ
       * @return void
       * @throws 
       */
       private static void setShijian(Element element, String databinding, String pvalue) {
           pvalue = pvalue.replaceAll("/", "-");
           String xmlTimeValue =element.element(databinding).getText();
           String[] xmlTimeValues = xmlTimeValue.split(",");
           if (xmlTimeValues.length > 1 ) {
               // ��Ĭ��ֵ��ʽΪ��null null:null:00,null null:null:00��ʱ
               if (xmlTimeValues[0].indexOf("null") == -1) {
                // ����ʱ�����
                   element.element(databinding).setText(
                           xmlTimeValue.replaceAll("null null:null:00", pvalue));
               } else {
                // ��ʼʱ�����
                   element.element(databinding).setText(
                           xmlTimeValue.replaceAll("null null:null:00,", pvalue+","));
               }
           } else {
               // ��Ĭ��ֵ��ʽΪ��null null:null:00��ʱ
               element.element(databinding).setText(pvalue);
           }
       }
}
