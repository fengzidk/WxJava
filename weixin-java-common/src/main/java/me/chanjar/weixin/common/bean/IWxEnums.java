package me.chanjar.weixin.common.bean;

/**
 * Created by DK on 2019/1/14 14:23 .
 **/
public interface IWxEnums<T extends IWxEnums> {

  T instance(String type);


  String getValue();
}
