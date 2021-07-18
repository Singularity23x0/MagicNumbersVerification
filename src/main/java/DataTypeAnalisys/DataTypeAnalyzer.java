package DataTypeAnalisys;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

public class DataTypeAnalyzer {

    public DataType findType(File file){
        String hexContent = this.getContentInHex(file);
        DataType fileType = DataType.UNDEFINED;

        for (DataType type : DataType.values()
             ) {
            if(fileType == DataType.UNDEFINED && this.isType(hexContent, type)){
                fileType = type;
            }
        }

        return fileType;
    }

    private boolean isType(String hexContent, DataType type) {
        return this.checkPrefix(hexContent, type) && this.checkSuffix(hexContent, type);
    }

    private boolean checkPrefix(String hexContent, DataType type){
        return hexContent.startsWith(type.getPrefix());
    }

    private boolean checkSuffix(String hexContent, DataType type){
        return hexContent.endsWith(type.getSuffix());
    }

    private String getContentInHex(File file){
        StringBuilder result = new StringBuilder();

        try{
            byte[] fileContent = Files.readAllBytes(file.toPath());
            String encodedString = Base64.getEncoder().encodeToString(fileContent);
            for (byte oneByte : fileContent) {
                int decimal = (int) oneByte & 0xff;
                String hex = Integer.toHexString(decimal);
                if (hex.length() % 2 == 1) {
                    hex = "0" + hex;
                }
                result.append(hex);
            }
        } catch (IOException e) {
            System.out.println("Error reading file.");
            e.printStackTrace();
        }

        return result.toString();
    }
}
