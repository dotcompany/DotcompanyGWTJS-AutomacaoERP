package br.com.dotcompany.core;
 
 import java.util.Properties;
 
 public abstract class DotRegistry  {
   private static Properties properties = new Properties();
 
   public static void setProperty(String key, String value) {
     properties.put(key, value);
   }
 
   public static String getProperty(String key) {
     return properties.getProperty(key);
   }
 }