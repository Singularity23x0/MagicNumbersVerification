package DataTypeAnalisys;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.FileNotFoundException;

public class FileVerifier {
    public void verifyFileExtension(String[] filesPaths) throws Exception {
        for (String path : filesPaths
             ) {
            File file = new File(path);
            DataType fileIntroducedAs = DataType.getTypeOf(path);
            if(fileIntroducedAs == DataType.UNDEFINED) {
                throw new Exception("The program did not recognize this file's extention");
            } else {

            }
        }
    }
}
