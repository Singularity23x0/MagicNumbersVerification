package DataTypeAnalisys;

import java.io.File;

public class GIFAnalyzer extends AbstractDataTypeAnalyzer {
    public GIFAnalyzer() {
        this.type = DataType.GIF;
    }

    @Override
    public boolean isType(File file) {
        return false;
    }
}
