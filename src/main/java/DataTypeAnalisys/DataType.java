package DataTypeAnalisys;

import java.io.File;

public enum DataType {
    GIF("474946383961", "", "gif file"),
    JPG("ffd8", "ffd9", "jpg file"),
    TXT("efbbbf", "", "text file"),
    PNG("89504e470d0a1a0a", "", "png"),
    UNDEFINED("", "", "undefined type");

    public final String prefix;
    public final String suffix;
    public final String name;

    private DataType(String prefix, String suffix, String name) {
        this.prefix = prefix;
        this.suffix = suffix;
        this.name = name;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public static DataType getTypeOf(String path){
        DataType type = UNDEFINED;
        if(path.endsWith(".txt")){
            type = TXT;
        } else if(path.endsWith(".gif")){
            type = GIF;
        } else if(path.endsWith(".jpg")){
            type = JPG;
        } else if(path.endsWith(".png")){
            type = PNG;
        }
        return type;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
