package org.zdanek.javabasic.coursera;

public class CeasarCipher {
	
	String alphabet="abcdefghijklmnopqrstuvwxyz";
	
	public static void main(String[] args) {
		CeasarCipher cipher=new CeasarCipher();
		String text="At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";
		int key=15;
		System.out.println(text);
		
		String encryptedText=cipher.encryptText(text,key);
		System.out.println(encryptedText);
	}
	
	private String encryptText(String text, int key) {
		
		String encryptedText = encryptAlghoritm(text, key,false);
		encryptedText = encryptAlghoritm(encryptedText, key,true);
		return encryptedText;
		// TODO Auto-generated method stub
		
	}


	private String encryptAlghoritm(String text, int key, boolean uppercase) {
		if(uppercase) {
			alphabet=alphabet.toUpperCase();
		}
		StringBuilder sb= new StringBuilder("");
		String shiftedAlphabet= shiftAlphabet(key);
		System.out.println(alphabet);
		System.out.println(shiftedAlphabet);
		
		char[] chars=text.toCharArray();
		char encryptedChar=' ';
		for(char i:chars) {
			int index= alphabet.indexOf(i);
			if(index==-1) {
				encryptedChar=i;
			}else {
				encryptedChar= shiftedAlphabet.charAt(index);
			}
			
			sb.append(encryptedChar);
		}
		
		String encryptedText=sb.toString();
		return encryptedText;
	}

	private String shiftAlphabet(int p) {
		
		String shiftedAphabet= alphabet.substring(p);
		shiftedAphabet=shiftedAphabet+alphabet.substring(0, p);
		
		return shiftedAphabet;
	}
	
	
}
