package DataTypeAnalisys;

import java.io.File;

public class JPGAnalyzer extends AbstractDataTypeAnalyzer {
    public JPGAnalyzer() {
        this.type = DataType.JPG;
    }

    @Override
    public boolean isType(File file) {
        return false;
    }
}
