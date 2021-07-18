package DataTypeAnalisys;

import java.io.File;

public class TXTAnalyzer extends AbstractDataTypeAnalyzer {
    public TXTAnalyzer() {
        this.type = DataType.TXT;
    }

    @Override
    public boolean isType(File file) {
        return false;
    }
}
