package DataTypeAnalisys;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.FileNotFoundException;

public class FileVerifier {

    public void verifyFilesExtensions(String[] filesPaths) throws Exception {
        for (String path : filesPaths
             ) {
            this.analyzeFile(path);
        }
    }

    private void analyzeFile(String path) throws Exception {
        File file = new File(path);
        DataType fileIntroducedAs = DataType.getTypeOf(path);

        DataTypeAnalyzer analyzer = new DataTypeAnalyzer();
        DataType fileActuallyIs = analyzer.findType(file);
        if(fileIntroducedAs == fileActuallyIs){
            System.out.println("The file \"" + path + "\" is a " + fileIntroducedAs.toString());
        } else {
            throw new Exception("For the file \"" + path + "\": "
                    + "Extension is " + fileIntroducedAs.getExtension()
                    + ", while actually it's a " + fileActuallyIs.getExtension());
        }

    }
}
