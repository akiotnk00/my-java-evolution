package Testes;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

import javax.swing.JFileChooser;

public class FileChosen {

	
	public static String pegarLocalArquivo() throws IOException{
		String local = null;

		JFileChooser fc = new JFileChooser(System.getProperty("user.dir"));
		fc.setMultiSelectionEnabled(false);
		javax.swing.filechooser.FileFilter filter = new javax.swing.filechooser.FileFilter() {
			public boolean accept(File f) {
				return f.isDirectory() || f.getName().toLowerCase().endsWith(".txt");
			}

			public String getDescription() {
				return "(.txt)";
				// return "(.xls)";
			}
		};
		fc.addChoosableFileFilter(filter);
		int returnVal = fc.showDialog(null, "Open");
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			local = fc.getSelectedFile().getAbsolutePath();

		} else if (returnVal == JFileChooser.CANCEL_OPTION) {
			throw new IOException(
					"Operação cancelada pelo usuário.");

		} else if (returnVal == JFileChooser.UNDEFINED_CONDITION) {
			throw new IOException(
					"Operação inválida.");
		}
		return local;
	}

	public static void main(String[] args) throws IOException{

		
		try {
			System.out.println(pegarLocalArquivo());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		LocalDate locdate = LocalDate.now();
		System.out.println(locdate);

	}
}
