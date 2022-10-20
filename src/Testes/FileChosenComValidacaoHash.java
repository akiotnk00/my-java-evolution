package Testes;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.swing.JFileChooser;

public class FileChosenComValidacaoHash {

	private static String gerarFileChecksum(MessageDigest digest, File file) throws IOException {

		FileInputStream fis = new FileInputStream(file);

		byte[] byteArray = new byte[1024];
		int bytesCount = 0;

		while ((bytesCount = fis.read(byteArray)) != -1) {
			digest.update(byteArray, 0, bytesCount);
		}
		;
		fis.close();

		byte[] bytes = digest.digest();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
		}

		return sb.toString();
	}

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

	public static void main(String[] args) throws NoSuchAlgorithmException, IOException{

		File file1 = null;
		File file2 = null;
		try {
			file1 = new File(pegarLocalArquivo());
			file2 = new File(pegarLocalArquivo());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		// Parte da validação
		MessageDigest md5Digest = MessageDigest.getInstance("MD5");
		
		// Pega o valor hash do primeiro arquivo.
		String hashfile1 = gerarFileChecksum(md5Digest,file1);
		
		// Pega o valor hash do segundo arquivo.
		String hashfile2 = gerarFileChecksum(md5Digest,file2);

		System.out.println("hash file 1: " + hashfile1);
		System.out.println("hash file 2: " + hashfile2);

		if (hashfile1.equals(hashfile2)) {
			System.out.println("Validado");
		} else {
			System.out.println("Não é valido");
		}

	}
}
