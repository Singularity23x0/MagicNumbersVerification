package DataTypeAnalisys;

import java.io.File;

public enum DataType {
    GIF,
    JPG,
    TXT,
    PNG,
    UNDEFINED;

    public static DataType getTypeOf(String path){
        return UNDEFINED;
    }

    public static DataType getTypeOf(File file){
        return UNDEFINED;
    }
}
