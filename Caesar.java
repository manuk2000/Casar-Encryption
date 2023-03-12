import java.io.*;

public class Caesar {

    final int countNumbers = 10;
    final int countLetters = 26;
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    void caesarEncryption(File inputFile, File outputFile, int deviation, boolean isEncryption) {
        // Input two file type File of input message and output message
        // Input deviation of Encryption
        // Input Encryption/true or Decryption/false
        // Returns Encryption or decryption message into outputfile
        deviation = (isEncryption) ? deviation : (-1) * deviation;
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, false))) {
            String tmpSym;
            char chr;
            int numberdeviation = deviationNumber(deviation);
            int lettersdeviation = deviationLetters(deviation);
            while ((tmpSym = reader.readLine()) != null) {
                for (int i = 0; i < tmpSym.length(); ++i) {
                    chr = tmpSym.charAt(i);
                    if (chr >= '0' && chr <= '9') {
                        chr = numberEncryption(chr, numberdeviation);
                        writer.append(chr);
                    } else if (chr >= 'a' && chr <= 'z') {
                        chr = lowerLetterEncryption(chr, lettersdeviation);
                        writer.append(chr);
                    } else if (chr >= 'A' && chr <= 'Z') {
                        chr = upperLetterEncryption(chr, lettersdeviation);
                        writer.append(chr);
                    } else {
                        writer.append(chr);
                    }
                }
                writer.newLine();
                writer.flush();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    char numberEncryption(char chr, int deviationNumber) {
        // Input character number symbol and deviation
        // Returns a strikethrough character
        chr = (char) (((chr + deviationNumber) % ('9' + 1)));
        if (chr < ('0' - countNumbers)) {
            chr += '0';
            return chr;
        } else if (chr < '0' && chr > ('0' - countNumbers)) {
            chr = (char) (('9' + 1) - ('0' - chr));
            return chr;
        }
        return chr;
    }

    char lowerLetterEncryption(char chr, int lettersDevaitio) {
        // Input character lower letter symbol and deviation
        // Returns a strikethrough character
        chr = (char) ((chr + lettersDevaitio) % ('z' + 1));
        if (chr < ('a' - countNumbers)) {
            chr += 'a';
            return chr;
        } else if (chr < 'a' && chr > ('a' - countLetters)) {
            chr = (char) (('z' + 1) - ('a' - chr));
            return chr;
        }
        return chr;
    }

    char upperLetterEncryption(char chr, int lettersDevaitio) {
        // Input character upper letter symbol and deviation
        // Returns a strikethrough character
        chr = (char) ((chr + lettersDevaitio) % ('Z' + 1));
        if (chr < ('A' - countNumbers)) {
            chr += 'A';
            return chr;
        } else if (chr < 'A' && chr > ('A' - countLetters)) {
            chr = (char) (('Z' + 1) - ('A' - chr));
            return chr;
        }
        return chr;
    }

    int deviationNumber(int deviation) {
        // Input deviation
        // Return deviation of character number
        return deviation % countNumbers;
    }

    int deviationLetters(int deviation) {
        // Input deviation
        // Return deviation of character letter
        return deviation % countLetters;
    }

    void inputMessageToFile(File file) {
        // Input file and importing a letter and writing it to a file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            boolean condination;
            String tmpSym;
            System.out.write("Please input message \n for completed input, write wq!".getBytes());
            System.out.println();
            while (true) {
                tmpSym = reader.readLine();
                condination = isContinueInput(tmpSym);
                if (condination == false) {
                    writer.write(tmpSym.replace("wq!", ""));
                    break;
                }
                writer.write(tmpSym);
                writer.newLine();
            }
            writer.flush();
        } catch (IOException e) {
            System.out.println("Error Input Message To File");
        }
    }

    boolean isContinueInput(String sym) {
        // Input String 
        // determining the end of the input
        sym = sym.trim();
        return !(sym.endsWith("wq!"));
    }

    int inputDeviation() {
        // Input Deviation
        System.out.println("Please input deviation");
        try {
            String line = reader.readLine();
            // reader.mark(10); //Comment minus will also work correctly
            // reader.reset();
            return Integer.parseInt(line);
        } catch (IOException e) {
            System.out.println("Error input deviation");
            return -1;
        }

    }

    boolean isEncryption() {
        // Return Encryption or Decryption
        System.out.println("You want Encryption/true or Decryption/fasle  ");
        String line;
        try {
            do {
                line = reader.readLine();
            } while (!(line.equalsIgnoreCase("true") || line.equalsIgnoreCase("true")));
            return line.equalsIgnoreCase("true");
        } catch (IOException e) {
            System.out.println("Error input deviation");
            return false;
        }
    }

    File creatFile(String nameFile) {
        // Input name file
        // returns with nameFile File
        nameFile = (nameFile.endsWith(".txt")) ? nameFile : nameFile + ".txt";
        File file = new File(nameFile);
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("Erroe creat file");
            e.printStackTrace();
        }
        return file;
    }
}