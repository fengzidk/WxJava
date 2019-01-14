package me.chanjar.weixin.common.util.xml;

import com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter;
import me.chanjar.weixin.common.bean.IWxEnums;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by DK on 2019/1/14 14:18 .
 **/
public class XStreamEnumConverter<T extends IWxEnums> extends AbstractSingleValueConverter {
  private Class<T> type;

  public XStreamEnumConverter(Class<T> type) {
    this.type = type;
  }

  @Override
  public boolean canConvert(Class type) {
    if (!(type.isEnum() && IWxEnums.class.isAssignableFrom(type))) {
      throw new IllegalArgumentException("XStreamEnumConverter 转换器仅支持 实现了IWxEnums接口的枚举 ");
    }
    return true;
  }

  @Override
  public Object fromString(String str) {
    try {
      //这段代码就是把Enum类的实现拎出来了 详情参考Enum.valueOf()
      Method values = type.getMethod("values");
      values.setAccessible(true);
      T[] temporaryConstants = (T[]) values.invoke(null);
      if (temporaryConstants == null || temporaryConstants.length == 0) {
        return null;
      }
      return ((IWxEnums) temporaryConstants[0]).instance(str);
    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public String toString(Object obj) {
    return "<![CDATA[" + ((IWxEnums)obj).getValue() + "]]>";
  }
}
