package Testes;

import java.io.File;

import javax.swing.JFileChooser;

public class FileChosen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String local = null;
		
		JFileChooser fc = new JFileChooser(System
                .getProperty("user.dir"));
        fc.setMultiSelectionEnabled(false);
        javax.swing.filechooser.FileFilter filter = new javax.swing.filechooser.FileFilter() {
            public boolean accept(File f) {
                return f.isDirectory()
                        || f.getName().toLowerCase().endsWith(
                                ".txt");
            }

            public String getDescription() {
                return "(.txt)";
                // return "(.xls)";
            }
        };
        fc.addChoosableFileFilter(filter);
        int returnVal = fc.showDialog(null,
                "Open");
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            local = fc.getSelectedFile().getAbsolutePath();

        } else if (returnVal == JFileChooser.CANCEL_OPTION) {
            return;

        } else if (returnVal == JFileChooser.UNDEFINED_CONDITION) {
            return;
	}

        System.out.println(local);
	}}
