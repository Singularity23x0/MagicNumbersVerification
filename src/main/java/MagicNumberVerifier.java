import DataTypeAnalisys.FileVerifier;

public class MagicNumberVerifier {
    public static void main(String[] args) throws Exception {
        FileVerifier verifier = new FileVerifier();
        verifier.verifyFileExtension(args);
    }
}
