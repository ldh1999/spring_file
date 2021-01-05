package com.ldh.Method;

public class Method_ckeck {

    public static boolean isempt_str(String str){
        if(str.equals("")){
            return false;
        }
        else
            return true;
    }

    public static boolean isNumeric(String str){
        StringBuffer sb=new StringBuffer();
        sb.append(str);
        if(str.equals("")){
            return false;
        }
        for (int i = str.length();--i>=0;){
            if (!Character.isDigit(sb.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
