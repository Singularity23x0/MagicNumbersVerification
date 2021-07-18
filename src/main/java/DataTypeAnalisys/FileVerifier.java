package DataTypeAnalisys;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.FileNotFoundException;

public class FileVerifier {

    public void verifyFileExtension(String[] filesPaths) throws Exception {
        for (String path : filesPaths
             ) {
            this.analyzeFile(path);
        }
    }

    private void analyzeFile(String path) throws Exception {
        File file = new File(path);
        DataType fileIntroducedAs = DataType.getTypeOf(path);
        if(fileIntroducedAs == DataType.UNDEFINED) {
            throw new Exception("The program did not recognize this file's extention");
        } else {
            DataTypeAnalyzer analyzer = new DataTypeAnalyzer(fileIntroducedAs);
            boolean isClaimedType = analyzer.isType(file);
            if(isClaimedType){
                System.out.println("This file is a: " + fileIntroducedAs.toString());
            } else {
                throw new Exception("File introduced as: " + fileIntroducedAs.toString() + ", but magic numbers proved that it is not true!");
            }
        }
    }
}
