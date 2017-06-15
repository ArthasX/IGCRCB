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
 * 概述: 报表XML文件类
 * 功能描述：报表XML文件类
 * 创建人：deliverik
 * 创建记录：2013-7-26
 * 修改记录：
 */
public class PdfXmlDoc {
    
    /** 报表XML存放路径*/ 
    private final String PDF_XML_PATH = 
        ResourceUtility.getString("PDF_XML_PATH"); 
        
    /** XML操作对象*/ 
    private Document xmlDocument;

    /** XML根节点*/ 
    private Element root ;
    
    
    
    public Element getRootElement(){
    	return root;
    }
    
    /** 
    * 报表XML类构造方法（读取XML文件得到可操作对象）
    * 
    * @param xmlFileName xml文件名称
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
    * 取得XML内容
    * @param 
    * @return String Xml内容
    * @throws 
    */
    public String asXml() {
        return xmlDocument.asXML();
    }
    
    /** 
    * 添加xml节点
    * @param xml节点对象
    * @return void
    * @throws 
    */
    public void addElement(Element pelement, Element element) {
        pelement.add(element);
    }
    
    /** 
     * 添加xml节点
     * @param xml节点对象
     * @return void
     * @throws 
     */
    public void addElement(Element element) {
        root.add(element);
    }
    
    /** 
    * 删除xml节点
    * @param xml节点对象
    * @return void
    * @throws 
    */
    public void removeElement(Element element) {
        root.remove(element);
    }
    
    /** 
     * 删除xml节点
     * @param xml节点对象
     * @return void
     * @throws 
     */
    public void removeElement(Element pelement, Element element) {
        pelement.remove(element);
    }
    
    /** 
    * 按照指定父节点路径取得xml节点对象
    * @param 父节点路径（用#分隔）
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
     * 流程表单数据填充xml
     * @param pdatabinding xml父节点名
     * @param databinding xml节点名
     * @param pvalue 待填充的数据
     * @param formtype 表单值类型
     * @return void
     * @throws 
     */
    public static void setPvalueIntoXml(Element element, String databinding, String pvalue, String formtype) {
        if (StringUtils.isNotEmpty(pvalue)) {
            if ("E".equals(formtype)) {
                // 单选其他 
                setDanxuanQita(element, databinding, pvalue);
             } else if ("S".equals(formtype)) {
                 // 多选其他
                 setDuoxuanQita(element, databinding, pvalue);
             } else if ("3".equals(formtype)) {
                 // 日期
                 pvalue = pvalue.replaceAll("/", "-");
                 element.element(databinding).setText(pvalue);
             } else if("C".equals(formtype)) {
                 // 多选
                 if (databinding.equals("isempty")) {
                     element.element(databinding).setText(pvalue);
                 } else {
                     pvalue =","+pvalue.replaceAll("#", ",");
                     element.element(databinding).setText(pvalue);
                 }
             } else if ("A".equals(formtype)) {
                 // 时间
                 setShijian(element, databinding, pvalue) ;
             } else if ("9".equals(formtype)) {
                 // 文本域
            	String temp = pvalue.replaceAll("<P>", "").replaceAll("</P>", "").replaceAll("&nbsp;", " ").replaceAll("<BR>", "\r\n");
                 element.element(databinding).setText(temp);
             } else {
            	 String temp = pvalue.replaceAll("<P>", "").replaceAll("</P>", "").replaceAll("&nbsp;", " ").replaceAll("<BR>", "\r\n");
                 element.element(databinding).setText(temp);
            }
        }
     }
    
    /** 
     * 把表格式类型流程表单数据设置到xml中
     * 
     * @param element XML操作对象
     * @param oneFormValueList 一个表格式表单的值列表
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
     * 多选其他类型表单值填充
     * @param element XML操作对象
     * @param databindings 多选其他表单的XML绑定字段
     * @param pvalue 多选其他表单值
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
                   String checkedItem = pvalue.replaceAll(elseContent, "其他");
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
      * 单选其他类型表单值填充
      * @param element XML操作对象
      * @param databindings 单选其他表单的XML绑定字段
      * @param pvalue 单选其他表单值
      * @return void
      * @throws 
      */
      private static void setDanxuanQita(Element element, String databinding, String pvalue) {
          String[] databindings = databinding.split(",");
          if (databindings.length == 2) {
              if (pvalue.indexOf("cv_cev_") != -1) {
                  // 如果选择了其他，同时设置其他选项和其他内容
                  element.element(databindings[0]).setText("其他");
                  element.element(databindings[1]).setText(pvalue.replaceAll("cv_cev_", ""));
              } else {
                  element.element(databindings[0]).setText(pvalue);
              }
          }
      }
      
      /** 
       * 时间类型表单值填充
       * @param element XML操作对象
       * @param databindings 单选其他表单的XML绑定字段
       * @param pvalue 单选其他表单值
       * @return void
       * @throws 
       */
       private static void setShijian(Element element, String databinding, String pvalue) {
           pvalue = pvalue.replaceAll("/", "-");
           String xmlTimeValue =element.element(databinding).getText();
           String[] xmlTimeValues = xmlTimeValue.split(",");
           if (xmlTimeValues.length > 1 ) {
               // 当默认值格式为“null null:null:00,null null:null:00”时
               if (xmlTimeValues[0].indexOf("null") == -1) {
                // 结束时间填充
                   element.element(databinding).setText(
                           xmlTimeValue.replaceAll("null null:null:00", pvalue));
               } else {
                // 开始时间填充
                   element.element(databinding).setText(
                           xmlTimeValue.replaceAll("null null:null:00,", pvalue+","));
               }
           } else {
               // 当默认值格式为“null null:null:00”时
               element.element(databinding).setText(pvalue);
           }
       }
}
