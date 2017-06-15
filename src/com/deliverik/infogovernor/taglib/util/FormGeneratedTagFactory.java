/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.taglib.util;

import java.util.Map;

import org.apache.axis.utils.StringUtils;

import com.deliverik.framework.workflow.IGPRDCONSTANTS;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ����Ϣ���ɶ�Ӧ��ǩʵ�ֲ�����
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class FormGeneratedTagFactory {

	/** ����Ϣ���ɶ�Ӧ��ǩʵ�ּ��� */
	protected Map<String, FormGeneratedTag> formGenerateTagMap;

	/**
	 * ����Ϣ���ɶ�Ӧ��ǩʵ�ּ����趨
	 * @param formGenerateTagMap ����Ϣ���ɶ�Ӧ��ǩʵ�ּ���
	 */
	public void setFormGenerateTagMap(
			Map<String, FormGeneratedTag> formGenerateTagMap) {
		this.formGenerateTagMap = formGenerateTagMap;
	}
	
	/**
	 * ���ɱ�ǩ
	 * @param formType ������
	 * @param params �������
	 * @return ��ǩ�ַ���
	 */
	public String generatedTag(Map<String, Object> params){
		//ȡ�ñ�����
		String formType = "";
		if(!params.get(FormGeneratedTag.PARAMS_FORM_TYPE).toString().isEmpty()){
			formType = params.get(FormGeneratedTag.PARAMS_FORM_TYPE).toString();
		}
		
		if(formGenerateTagMap == null || formGenerateTagMap.isEmpty() || StringUtils.isEmpty(formType)){
			return null;
		}
		//��ǩ���ɶ���ȡ��
		FormGeneratedTag generatedTag = formGenerateTagMap.get(formType);
		if(generatedTag!=null){
			String tagString = null;
			//�жϱ�ģʽ
			//���б�
			if(IGPRDCONSTANTS.PIDMODE_PUBLIC.equals(params.get(FormGeneratedTag.PARAMS_PIDMODE))){
				//����ǲ��ɼ����������ر�
				if(IGPRDCONSTANTS.PUBLIC_ACCESS_HIDE.equals(params.get(FormGeneratedTag.PARAMS_PIDACCESS))){
					tagString = generatedTag.generatedPublicHideTag(params);
				//�����ֻ����
				}else if(IGPRDCONSTANTS.PUBLIC_ACCESS_READABLE.equals(params.get(FormGeneratedTag.PARAMS_PIDACCESS))){
					tagString = generatedTag.generatedPublicReadableTag(params);
				//����ǿ�д��
				}else if(IGPRDCONSTANTS.PUBLIC_ACCESS_WRITEABLE.equals(params.get(FormGeneratedTag.PARAMS_PIDACCESS))){
					tagString = generatedTag.generatedPublicWriteableTag(params);
				}
			//˽�б�
			}else if(IGPRDCONSTANTS.PIDMODE_PRIVATE.equals(params.get(FormGeneratedTag.PARAMS_PIDMODE))){
				//����ǲ��ɼ����������ر�
				if(IGPRDCONSTANTS.PUBLIC_ACCESS_HIDE.equals(params.get(FormGeneratedTag.PARAMS_PIDACCESS))){
					tagString = generatedTag.generatedPrivateHideTag(params);
				//�����ֻ����
				}else if(IGPRDCONSTANTS.PUBLIC_ACCESS_READABLE.equals(params.get(FormGeneratedTag.PARAMS_PIDACCESS))){
					tagString = generatedTag.generatedPrivateReadableTag(params);
				//����ǿ�д��
				}else if(IGPRDCONSTANTS.PUBLIC_ACCESS_WRITEABLE.equals(params.get(FormGeneratedTag.PARAMS_PIDACCESS))){
					tagString = generatedTag.generatedPrivateWriteableTag(params);
				//˽�б���ȫ���ɼ�
				}else if(IGPRDCONSTANTS.PRIVATE_ACCESS_READABLE_ALL.equals(params.get(FormGeneratedTag.PARAMS_PIDACCESS))){
					tagString = generatedTag.generatedPrivateReadableAllTag(params);
				}
			//״̬��
			}else if(IGPRDCONSTANTS.PIDMODE_STATUS.equals(params.get(FormGeneratedTag.PARAMS_PIDMODE))){
			    //��������սڵ�
			    if("Y".equals(params.get("stuatsclose"))){
			        tagString = generatedTag.generatedStatusCloseTag(params);
			    }
			    //����ǲ��ɼ����������ر�
			    else if(IGPRDCONSTANTS.PUBLIC_ACCESS_HIDE.equals(params.get(FormGeneratedTag.PARAMS_PIDACCESS))){
                    tagString = generatedTag.generatedStatusHideTag(params);
                //�����ֻ����
                }else if(IGPRDCONSTANTS.PUBLIC_ACCESS_READABLE.equals(params.get(FormGeneratedTag.PARAMS_PIDACCESS))){
                    tagString = generatedTag.generatedStatusReadableTag(params);
                //����ǿ�д��
                }else if(IGPRDCONSTANTS.PUBLIC_ACCESS_WRITEABLE.equals(params.get(FormGeneratedTag.PARAMS_PIDACCESS))){
                    tagString = generatedTag.generatedStatusWriteableTag(params);
                }
            }
			//���Ӹ�����Ϣ
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
		//��ǩ���ɶ���ȡ��
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
