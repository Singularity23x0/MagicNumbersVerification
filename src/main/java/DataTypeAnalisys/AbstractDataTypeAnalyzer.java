package DataTypeAnalisys;

import java.io.File;

public abstract class AbstractDataTypeAnalyzer {
    protected DataType type;
    protected String hexPrefix;

    public boolean isType(File file) {

    }

    public DataType getType(File file){
        return this.type;
    }

    private String getContentInHex(File file){
        return "";
    }
}
