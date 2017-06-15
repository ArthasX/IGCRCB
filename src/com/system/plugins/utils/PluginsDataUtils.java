package com.system.plugins.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

import com.deliverik.framework.utility.IGStringUtils;

public class PluginsDataUtils {

	/***
	 * 解析指定DATA_XML并生成PK INSERT_OR_UPDATE语句  2012.11.12 add
	 * @param filePath
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	public List<SQLBean> parseXmlToList_INSERT_OR_UPDATE(String filePath) throws Exception{
		String tableName;
		SAXBuilder builder = new SAXBuilder();
	    Document doc = builder.build(filePath);
	    Element root = doc.getRootElement();
	    List<Element> rootList = root.getChildren("TABLE");
	    List<SQLBean> sqlList = new ArrayList<SQLBean>();
	    List<String> dataValues = null;
	    List<String> pkDataValues = null;
	    List<String> temp_pkDataValues = null;
	    StringBuffer sqlColumn = null;
	    StringBuffer upSqlColumn = null;
	    StringBuffer sqlValue = null;
	    StringBuffer upSqlValue = null;
	    StringBuffer PK = null;
	    String nodeText=null;
	    
	    //遍历<ROOT>节点
	    for(int i=0;i<rootList.size();i++){
	    	Element rootEL = (Element)rootList.get(i);
	    	tableName = rootEL.getAttributeValue("NAME");
	    	List<Element> tableList = rootEL.getChildren();
		    List<String[]> valueList = new ArrayList<String[]>();
		    
	    	//遍历<TABLE>节点
	    	for(int j=0;j<tableList.size();j++){
	    		Element tableEL = (Element)tableList.get(j);
	    		List<Element> dataList = tableEL.getChildren();
	    		dataValues = new ArrayList<String>();
	    		pkDataValues = new ArrayList<String>();
	    		temp_pkDataValues = new ArrayList<String>();
	    		sqlColumn = new StringBuffer("");
	    		upSqlColumn = new StringBuffer("");
	    		sqlValue = new StringBuffer("");
	    		upSqlValue = new StringBuffer("");
			    PK = new StringBuffer("");
			    String columnTypes[] = new String[dataList.size()]; 
	    		//遍历<DATA>节点
	    		for(int k=0;k<dataList.size();k++){
	    			Element dataEL = (Element)dataList.get(k);
	    			if(StringUtils.isEmpty(dataEL.getText())){
	    				continue;
	    			}
	    			//===add
	    			if(dataEL.getAttribute("PK")!=null){
	    				if("PK".equals(dataEL.getAttribute("PK").getValue())){
	    					if(PK.length()==0){
	    						PK.append("WHERE "+dataEL.getName()+" = ?");
	    					}else{
	    						PK.append(" AND "+dataEL.getName()+" = ?");
	    					}
	    					pkDataValues.add(dataEL.getText());
	    				}
	    			}else{
	    				upSqlColumn.append(dataEL.getName()+",");
	    				upSqlValue.append("?, ");
		    			if(dataEL.getText().equals("$NOW")){
		    				temp_pkDataValues.add(new String(IGStringUtils.getCurrentDateTime()));
		    			}else{
		    				temp_pkDataValues.add(dataEL.getText());
		    			}
	    				
	    			}
	    			//===add
    				sqlColumn.append(dataEL.getName()+",");
    				if(dataEL.getAttribute("TYPE")!=null){
    					columnTypes[k] = dataEL.getAttribute("TYPE").getValue();
    				}else{
    					columnTypes[k] = "STRING";
    				}
    				sqlValue.append("?, ");
	    			//=== get now time
	    			if(dataEL.getText().equals("$NOW")){
	    				dataValues.add(new String(IGStringUtils.getCurrentDateTime()));
	    			}else{
	    				dataValues.add(dataEL.getText());
	    			}
	    			//=== get now time
	    		}
	    		
	    		String updSQL = upSqlColumn.toString().substring(0,upSqlColumn.toString().length()-1);
	    		String updVal = upSqlValue.toString().substring(0,upSqlValue.toString().length()-2);
	    		String insSQL = sqlColumn.toString().substring(0,sqlColumn.toString().length()-1);
	    		String insVal = sqlValue.toString().substring(0,sqlValue.toString().length()-2);
	    		
	    		String sql_select = "SELECT * FROM " +tableName+" "+PK;
	    		String sql_insert = "INSERT INTO "+tableName+" ("+insSQL+") VALUES ("+insVal+")";
	    		String sql_update = "UPDATE "+tableName+" SET "+updSQL.replace(","," = ? , ")+" = ? "+PK;
	    		
	    		SQLBean sqlBean = new SQLBean();
	    		sqlBean.setValues(dataValues.toArray(new String[dataValues.size()]));
	    		sqlBean.setPks(pkDataValues.toArray(new String[pkDataValues.size()]));//pk[]
	    		for (int w = 0; w < pkDataValues.size(); w++) {
	    			temp_pkDataValues.add(pkDataValues.get(w));
				}
	    		sqlBean.setPkvalues(temp_pkDataValues.toArray(new String[temp_pkDataValues.size()]));//only for update sql
		    	sqlBean.setSql(sql_insert);
		    	sqlBean.setSelectSql(sql_select);
		    	sqlBean.setUpdateSql(sql_update);
		    	sqlBean.setColumntypes(columnTypes);
		    	sqlList.add(sqlBean);
	    	}

	    }
		return sqlList;
	}
	
	/**
	 * 主键删除 2012.11.13 add
	 * @param filePath
	 * @return List<SQLBean>
	 */
	public List<SQLBean> parseXmlToList_DELETE_BY_PK(String filePath)throws Exception {
		String tableName;
		SAXBuilder builder = new SAXBuilder();
	    Document doc = builder.build(filePath);
	    Element root = doc.getRootElement();
	    List<Element> rootList = root.getChildren("TABLE");
	    List<SQLBean> sqlList = new ArrayList<SQLBean>();
	    List<String> pkDataValues = null;
	    StringBuffer PK = null;
	    
	    
	    //遍历<ROOT>节点
	    for(int i=0;i<rootList.size();i++){
	    	Element rootEL = (Element)rootList.get(i);
	    	tableName = rootEL.getAttributeValue("NAME");
	    	List<Element> tableList = rootEL.getChildren();

	    	//遍历<TABLE>节点
	    	for(int j=0;j<tableList.size();j++){
	    		Element tableEL = (Element)tableList.get(j);
	    		List<Element> dataList = tableEL.getChildren();
	    		pkDataValues = new ArrayList<String>();
			    PK = new StringBuffer("");
			    String columnTypes[] = new String[dataList.size()]; 
			    int ck =0;
	    		//遍历<DATA>节点
	    		for(int k=0;k<dataList.size();k++){
	    			Element dataEL = (Element)dataList.get(k);
	    			if(StringUtils.isEmpty(dataEL.getText())){
	    				continue;
	    			}
	    			//add
	    			if(dataEL.getAttribute("PK")!=null){
	    				if("PK".equals(dataEL.getAttribute("PK").getValue())){
	    					if(PK.length()==0){
	    						PK.append("WHERE "+dataEL.getName()+" = ?");
	    					}else{
	    						PK.append(" AND "+dataEL.getName()+" = ?");
	    					}
	    					pkDataValues.add(dataEL.getText());
	    					if(dataEL.getAttribute("TYPE")!=null){
	    						columnTypes[k] = dataEL.getAttribute("TYPE").getValue();
	    					}else{
	    						columnTypes[k] = "STRING";
	    					}
	    					ck+=1;
	    				}
	    			}
	    			//add
	    		}
	    		String sql_select = "SELECT * FROM "+tableName+" "+PK;
	    		String sql = "DELETE FROM "+tableName+" "+PK;
	    		SQLBean sqlBean = new SQLBean();
	    		sqlBean.setSql(sql);
	    		sqlBean.setSelectSql(sql_select);
	    		sqlBean.setPks(pkDataValues.toArray(new String[pkDataValues.size()]));
	    		sqlBean.setColumntypes(columnTypes);
	    		sqlList.add(sqlBean);
	    	}
	    }
		return sqlList;
	}
	
	/****
	 * 取得所有插件路径地址
	 * @param 插件目录
	 * @return
	 */
	public List<String> getPluginPath(String pluginPath){
		File pluginFile = new File(pluginPath);
		List<String> pluginList = new ArrayList<String>();
		if(pluginFile.isDirectory()){
			File[] files = pluginFile.listFiles();
			for(File file:files){
				if(file.isDirectory()){
					pluginList.add(file.getPath());
				}
			}
		}
		return pluginList;
	}
	
	
	/***
	 * 解析指定DATA_XML并生成INSERT语句
	 * @param filePath
	 * @return
	 * @throws Exception
	 */
	public List<String> parseXmlToEntityList(String filePath) throws Exception{
		String entityName;
		SAXBuilder builder = new SAXBuilder();
	    Document doc = builder.build(filePath);
	    Element root = doc.getRootElement();
	    List<Element> rootList = root.getChildren("ENTITY");
	    List<String> entityList = new ArrayList<String>();
	    //遍历<ROOT>节点
	    for(int i=0;i<rootList.size();i++){
	    	Element rootEL = (Element)rootList.get(i);
	    	entityName = rootEL.getText();
	    	entityList.add(entityName);

	    }
		return entityList;
	}
	
	/**
	 * 通过类路径来取工程路径
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getAbsolutePathByClass(){
		String webPath = this.getClass().getResource("").getPath().replaceAll("^\\/", "");
		webPath = webPath.substring(0,webPath.indexOf("/com/"));
		webPath = webPath.replaceAll("[\\\\\\/]WEB-INF[\\\\\\/]classes[\\\\\\/]?", "/");
		webPath = webPath.replaceAll("[\\\\\\/]+", "/");
		webPath = webPath.replaceAll("%20", " ");
		if (webPath.matches("^[a-zA-Z]:.*?$")) {

		} else {
			webPath = "/" + webPath;
		}
		webPath += "/";
		webPath = webPath.replaceAll("[\\\\\\/]+", "/");
		return webPath;
	}
}
