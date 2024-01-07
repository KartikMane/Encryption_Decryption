import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.io.BufferedWriter;

public class File
{
    public static void main(String[] args)
                throws IOException
    {
        Scanner obj = new Scanner(System.in);
        System.out.println("Choose the operation to be performed :");
        System.out.println("1: Encryption");
        System.out.println("2 :Decryption");
        int n = obj.nextInt();

        Path filename=Path.of("C:\\Users\\HP\\Desktop\\Coding\\Java\\Cognifyz\\Level2\\input.txt");
        String str = Files.readString(filename);

        Path filename2 = Path.of("C:\\Users\\HP\\Desktop\\Coding\\Java\\Cognifyz\\Level2\\encrypted.txt");
        Path filename3 = Path.of("C:\\Users\\HP\\Desktop\\Coding\\Java\\Cognifyz\\Level2\\decrypted.txt");
        try
        {
            KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
            SecretKey myDesKey = keygenerator.generateKey();

            Cipher desCipher;
            desCipher = Cipher.getInstance("DES");

            byte[] textfile =str.getBytes("UTF8");
            byte[] textEncrypted;
            byte[] text;

            desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);
            textEncrypted = desCipher.doFinal(textfile);
            String s = new String(textEncrypted);
            //System.out.println(s);

            desCipher.init(Cipher.DECRYPT_MODE, myDesKey);
            byte[] textDecrypted = desCipher.doFinal(textEncrypted);
            String a = new String(textDecrypted);
            //System.out.println(a);

            if(n==1)
            {

                BufferedWriter ow =null;
                ow = new BufferedWriter(new FileWriter("C:\\Users\\HP\\Desktop\\Coding\\Java\\Cognifyz\\Level2\\encrypted.txt"));
                for(int j=0;j<textEncrypted.length;j++)
                {
                    ow.write(textEncrypted[j]);
                }
                ow.flush();
                ow.close();
                //Files.writeString(filename2,textEncrypted);
            }
            if(n==2)
            {
                BufferedWriter z= null;
                z= new BufferedWriter(new FileWriter("C:\\Users\\HP\\Desktop\\Coding\\Java\\Cognifyz\\Level2\\decrypted.txt"));
                for(int k=0;k< textDecrypted.length;k++)
                {
                    z.write(textDecrypted[k]);
                }
                z.flush();
                z.close();
            }
            //String s = new String(textEncrypted);
            //System.out.println(s);

            //desCipher.init(Cipher.DECRYPT_MODE, myDesKey);
            //byte[] textDecrypted = desCipher.doFinal(text);
            //String a = new String(textDecrypted);
            //System.out.println(a);
        }catch(Exception e)
        {
            System.out.println("Exception");
        }

    }
}