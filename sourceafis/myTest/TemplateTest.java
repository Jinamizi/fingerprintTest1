
package com.machinezoo.sourceafis.myTest;
import java.io.ByteArrayOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import com.machinezoo.sourceafis.FingerprintMatcher;
import com.machinezoo.sourceafis.FingerprintTemplate;
import com.machinezoo.sourceafis.FingerprintTemplateTest;
import java.awt.Image;
import javax.swing.ImageIcon;
public class TemplateTest {
    
    public static void main(String argd[]){
        FingerprintTemplate probe = new FingerprintTemplate().create(loadImage("C:\\tonny\\projecting\\Test1\\src\\test\\resources\\com\\machinezoo\\sourceafis\\probe.png")); //FingerprintTemplateTest.probe();
        FingerprintTemplate matching = new FingerprintTemplate().create(loadImage("C:\\tonny\\projecting\\Test1\\src\\test\\resources\\com\\machinezoo\\sourceafis\\nonmatching.png"));;
        //FingerprintTemplate nonmatching = FingerprintTemplateTest.nonmatching();
        
        FingerprintMatcher matcher = new FingerprintMatcher().index(probe);
        double score = matcher.match(matching);
        
        System.out.println(score);
    }
    
    static byte[] loadImage(String file){
        try {
            BufferedImage bImage = ImageIO.read(new File(file));
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ImageIO.write(bImage, "jpg", bos );
            
            byte [] data = bos.toByteArray();
            return data;
        }catch(Exception e){}
        return new byte[0];   
    }
}
