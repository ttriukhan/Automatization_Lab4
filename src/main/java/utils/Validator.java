package utils;

import annotations.*;
import models.PositionsEnum;


import java.lang.reflect.Field;
import java.util.regex.Pattern;

public class Validator {
    public static void validate(Object obj) throws Exception {
        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);

            if (field.isAnnotationPresent(Address.class)) {
                String address = (String) field.get(obj);
                if (!Pattern.matches("^[A-Za-z(\\s,\\-)\\d]*$", address)) {
                    throw new Exception(field.getAnnotation(Address.class).message());
                }
            }

            if (field.isAnnotationPresent(Email.class)) {
                String email = (String) field.get(obj);
                if (!Pattern.matches("^[\\w-.]+@([A-Za-z\\d-]+\\.)+[A-Za-z]{2,}$", email)) {
                    throw new Exception(field.getAnnotation(Email.class).message());
                }
            }

            if (field.isAnnotationPresent(Name.class)) {
                String name = (String) field.get(obj);
                if (!Pattern.matches("^[A-Z][A-Za-z]*([\\s-][A-Za-z]*)*$", name)) {
                    throw new Exception(field.getAnnotation(Name.class).message());
                }
            }

            if (field.isAnnotationPresent(Phone.class)) {
                String phone = (String) field.get(obj);
                if (!Pattern.matches("^(\\+)?\\d{7,12}$", phone)) {
                    throw new Exception(field.getAnnotation(Phone.class).message());
                }
            }

            if (field.isAnnotationPresent(Position.class)) {
                try {
                    PositionsEnum position = PositionsEnum.valueOf((String) field.get(obj));
                }catch(Exception e) {
                    throw new Exception(field.getAnnotation(Position.class).message());
                }
            }

            if (field.isAnnotationPresent(Salary.class)) {
                double salary = field.getDouble(obj);
                if (salary <= 0) {
                    throw new Exception(field.getAnnotation(Salary.class).message());
                }
            }


        }
    }
}
