package DataTypeAnalisys;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

public class DataTypeAnalyzer {
    protected DataType type;

    public DataTypeAnalyzer(DataType type) {
        this.type = type;
    }

    public boolean isType(File file) {
        String hexContent = this.getContentInHex(file);
        return this.checkPrefix(hexContent) && this.checkSuffix(hexContent);
    }

    public DataType getType(File file){
        return this.type;
    }

    private boolean checkPrefix(String hexContent){
        return hexContent.startsWith(this.type.getPrefix());
    }

    private boolean checkSuffix(String hexContent){
        return hexContent.endsWith(this.type.getSuffix());
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
