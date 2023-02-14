package service;

import java.util.regex.Pattern;

public class MyRegex {
    private String patternViet="^[a-zA-Z0-9\\sÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]{4,16}$";
    private String patternEmail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private String patternName = "[a-zA-Z0-9_-]{3,15}$";
    private String patternText = "[a-zA-Z0-9\\d]{4,60}$";
    private String patternPhone = "^0\\d{9}$";
    private String patternPassWord = "^[a-zA-Z0-9]{6,15}$";
    private String patternNumber="[0-9]+$";
    private String patternDouble="^[0-9.]+$";

    public MyRegex() {
    }

    public String getPatternViet() {
        return patternViet;
    }

    public String getPatternEmail() {
        return patternEmail;
    }

    public String getPatternName() {
        return patternName;
    }

    public String getPatternText() {
        return patternText;
    }

    public String getPatternPhone() {
        return patternPhone;
    }

    public String getPatternPassWord() {
        return patternPassWord;
    }

    public String getPatternNumber() {
        return patternNumber;
    }

    public String getPatternDouble() {
        return patternDouble;
    }

    public  boolean regex(String input, String pattern) {
        return Pattern.compile(pattern)
                .matcher(input)
                .matches();
    }

}
