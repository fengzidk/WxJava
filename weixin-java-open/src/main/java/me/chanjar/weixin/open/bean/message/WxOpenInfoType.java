package me.chanjar.weixin.open.bean.message;

import me.chanjar.weixin.common.bean.IWxEnums;

/**
 * Created by DK on 2019/1/14 14:25 .
 **/
public enum WxOpenInfoType implements IWxEnums {
  /**
   * 未知 当微信升级而项目未更新时,会使用此枚举值, 此时,Value字段的值为微信接口返回的值
   */
  UNKNOWN(""),
  /**
   * 发放ticket
   */
  COMPONENT_VERIFY_TICKET("component_verify_ticket"),
  /**
   * 授权
   */
  AUTHORIZED("authorized"),
  /**
   * 更新授权
   */
  UPDATEAUTHORIZED("updateauthorized"),
  /**
   * 取消授权
   */
  UNAUTHORIZED("unauthorized");

  private String value;

  WxOpenInfoType(String value) {
    this.value = value;
  }

  @Override
  public WxOpenInfoType instance(String value) {
    for (WxOpenInfoType infoType : WxOpenInfoType.values()) {
      if (infoType.value.equals(value)) {
        return infoType;
      }
    }
    WxOpenInfoType unknown = WxOpenInfoType.UNKNOWN;
    unknown.value = value;
    return unknown;
  }


  @Override
  public String getValue() {
    return value;
  }

}
