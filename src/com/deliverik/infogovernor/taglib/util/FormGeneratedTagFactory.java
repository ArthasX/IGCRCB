/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.taglib.util;

import java.util.Map;

import org.apache.axis.utils.StringUtils;

import com.deliverik.framework.workflow.IGPRDCONSTANTS;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 表单信息生成对应标签实现产生类
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class FormGeneratedTagFactory {

	/** 表单信息生成对应标签实现集合 */
	protected Map<String, FormGeneratedTag> formGenerateTagMap;

	/**
	 * 表单信息生成对应标签实现集合设定
	 * @param formGenerateTagMap 表单信息生成对应标签实现集合
	 */
	public void setFormGenerateTagMap(
			Map<String, FormGeneratedTag> formGenerateTagMap) {
		this.formGenerateTagMap = formGenerateTagMap;
	}
	
	/**
	 * 生成标签
	 * @param formType 表单类型
	 * @param params 所需参数
	 * @return 标签字符串
	 */
	public String generatedTag(Map<String, Object> params){
		//取得表单类型
		String formType = "";
		if(!params.get(FormGeneratedTag.PARAMS_FORM_TYPE).toString().isEmpty()){
			formType = params.get(FormGeneratedTag.PARAMS_FORM_TYPE).toString();
		}
		
		if(formGenerateTagMap == null || formGenerateTagMap.isEmpty() || StringUtils.isEmpty(formType)){
			return null;
		}
		//标签生成对象取得
		FormGeneratedTag generatedTag = formGenerateTagMap.get(formType);
		if(generatedTag!=null){
			String tagString = null;
			//判断表单模式
			//公有表单
			if(IGPRDCONSTANTS.PIDMODE_PUBLIC.equals(params.get(FormGeneratedTag.PARAMS_PIDMODE))){
				//如果是不可见，生成隐藏表单
				if(IGPRDCONSTANTS.PUBLIC_ACCESS_HIDE.equals(params.get(FormGeneratedTag.PARAMS_PIDACCESS))){
					tagString = generatedTag.generatedPublicHideTag(params);
				//如果是只读表单
				}else if(IGPRDCONSTANTS.PUBLIC_ACCESS_READABLE.equals(params.get(FormGeneratedTag.PARAMS_PIDACCESS))){
					tagString = generatedTag.generatedPublicReadableTag(params);
				//如果是可写表单
				}else if(IGPRDCONSTANTS.PUBLIC_ACCESS_WRITEABLE.equals(params.get(FormGeneratedTag.PARAMS_PIDACCESS))){
					tagString = generatedTag.generatedPublicWriteableTag(params);
				}
			//私有表单
			}else if(IGPRDCONSTANTS.PIDMODE_PRIVATE.equals(params.get(FormGeneratedTag.PARAMS_PIDMODE))){
				//如果是不可见，生成隐藏表单
				if(IGPRDCONSTANTS.PUBLIC_ACCESS_HIDE.equals(params.get(FormGeneratedTag.PARAMS_PIDACCESS))){
					tagString = generatedTag.generatedPrivateHideTag(params);
				//如果是只读表单
				}else if(IGPRDCONSTANTS.PUBLIC_ACCESS_READABLE.equals(params.get(FormGeneratedTag.PARAMS_PIDACCESS))){
					tagString = generatedTag.generatedPrivateReadableTag(params);
				//如果是可写表单
				}else if(IGPRDCONSTANTS.PUBLIC_ACCESS_WRITEABLE.equals(params.get(FormGeneratedTag.PARAMS_PIDACCESS))){
					tagString = generatedTag.generatedPrivateWriteableTag(params);
				//私有表单的全部可见
				}else if(IGPRDCONSTANTS.PRIVATE_ACCESS_READABLE_ALL.equals(params.get(FormGeneratedTag.PARAMS_PIDACCESS))){
					tagString = generatedTag.generatedPrivateReadableAllTag(params);
				}
			//状态表单
			}else if(IGPRDCONSTANTS.PIDMODE_STATUS.equals(params.get(FormGeneratedTag.PARAMS_PIDMODE))){
			    //如果是最终节点
			    if("Y".equals(params.get("stuatsclose"))){
			        tagString = generatedTag.generatedStatusCloseTag(params);
			    }
			    //如果是不可见，生成隐藏表单
			    else if(IGPRDCONSTANTS.PUBLIC_ACCESS_HIDE.equals(params.get(FormGeneratedTag.PARAMS_PIDACCESS))){
                    tagString = generatedTag.generatedStatusHideTag(params);
                //如果是只读表单
                }else if(IGPRDCONSTANTS.PUBLIC_ACCESS_READABLE.equals(params.get(FormGeneratedTag.PARAMS_PIDACCESS))){
                    tagString = generatedTag.generatedStatusReadableTag(params);
                //如果是可写表单
                }else if(IGPRDCONSTANTS.PUBLIC_ACCESS_WRITEABLE.equals(params.get(FormGeneratedTag.PARAMS_PIDACCESS))){
                    tagString = generatedTag.generatedStatusWriteableTag(params);
                }
            }
			//增加附件信息
			if("Y".equals(params.get(FormGeneratedTag.PARAMS_HASATTACH))){
				if(IGPRDCONSTANTS.PUBLIC_ACCESS_READABLE.equals(params.get(FormGeneratedTag.PARAMS_PIDACCESS))){
					String attTagString = generatedTag.readableAttachmentInfoShow(params);
					tagString = tagString +" "+attTagString;
				}else if(IGPRDCONSTANTS.PUBLIC_ACCESS_WRITEABLE.equals(params.get(FormGeneratedTag.PARAMS_PIDACCESS))){
					String attTagString = generatedTag.writeableAttachmentInfoShow(params);
					tagString = tagString +" "+ attTagString;
				}
			}
			return tagString;
		}else{
			return null;
		}
	}
	
	public String generatedColumn(Map<String, Object> params){
		String formType = (String) params.get(FormGeneratedTag.PARAMS_FORM_TYPE);
		String pidaccess = (String) params.get(FormGeneratedTag.PARAMS_PIDACCESS);
		if(formGenerateTagMap == null || formGenerateTagMap.isEmpty() || StringUtils.isEmpty(formType)){
			return null;
		}
		//标签生成对象取得
		FormGeneratedTag generatedTag = formGenerateTagMap.get(formType);
		String tagString = "";
		if(generatedTag!=null){
			if(IGPRDCONSTANTS.PUBLIC_ACCESS_READABLE.equals(pidaccess)){
				tagString = generatedTag.generatedPublicReadableTableColumn(params);
			}else if(IGPRDCONSTANTS.PUBLIC_ACCESS_WRITEABLE.equals(pidaccess)){
				tagString = generatedTag.generatedPublicWriteableTableColumn(params);
			}
		}
		return tagString;
	}
}
