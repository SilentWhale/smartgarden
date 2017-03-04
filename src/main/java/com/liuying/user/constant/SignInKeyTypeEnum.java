package com.liuying.user.constant;

import org.springframework.util.StringUtils;


public enum SignInKeyTypeEnum {
    NAME("username"),
    MAIL("mail"),
    PHONENUMBER("phonenumber");

    private String type;

    public static SignInKeyTypeEnum findType(String type) {
        if(StringUtils.isEmpty(type)) {
            return null;
        }
        for (SignInKeyTypeEnum temp:SignInKeyTypeEnum.values()
             ) {
           if (type.equals(temp.getType())) {
               return temp;
           }
        }
        return null;
    }
    SignInKeyTypeEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
