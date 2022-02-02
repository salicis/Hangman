import javax.swing.JOptionPane;

public class ErrorReporter {

    static void missingFile(){
        JOptionPane.showMessageDialog(null, "Word list file missing, using default words instead");
    }

    static void missingFiles(){
        JOptionPane.showMessageDialog(null, "++No word list files in directory, using default words instead");
    }

    static void missingWords(){
        JOptionPane.showMessageDialog(null, "--No valid words in list or unable to read list, using default words instead");
    }

    static void missingDirectory(){
        JOptionPane.showMessageDialog(null, "**Word list directory missing, using default words instead");
    }

    static void notTextFile(){
        JOptionPane.showMessageDialog(null, "Chosen word list file not a text file, using default words instead");
    }

}
