package com.caner.yemeksepeti.utility;

import java.util.UUID;

public class CodeGenerator {
    public static String generateCode(){
        String code = UUID.randomUUID().toString(); //Örnek UUID ---> 1b9318d- e123 -4744-8ef2-3963e3128aa
        String[] data = code.split("-");
        String newCode="";
        for(String str : data){
            newCode += str.charAt(0); //1e483
        }
        return newCode;
    }
}
