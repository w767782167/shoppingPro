package lwd.utils;

public class StringUtils {
  private StringUtils(){
	  
  }
  
  public static boolean hasLength(String value){
	  return value!=null && !"".equals(value.trim());
  }
}
