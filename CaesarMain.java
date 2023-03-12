import java.io.File;

public class CaesarMain {
    public static void main(String[] args) {
        Caesar obj = new Caesar();
        
        File fInput = obj.creatFile("Input12");
        File fOutput = obj.creatFile("Output12");
        obj.inputMessageToFile(fInput);
        int deviation = obj.inputDeviation();
        boolean isEncryption = obj.isEncryption();
        obj.caesarEncryption(fInput, fOutput, deviation, isEncryption);
    }


}
