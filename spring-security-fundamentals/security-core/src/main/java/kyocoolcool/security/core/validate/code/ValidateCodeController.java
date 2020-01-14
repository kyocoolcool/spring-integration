package kyocoolcool.security.core.validate.code;

import kyocoolcool.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName ValidateCodeController
 * @Description 驗證碼Controller
 * @Author Chris Chen
 * @Date 2020/1/10 1:45 PM
 * @Version 1.0
 **/

@RestController
public class ValidateCodeController  {

    public final static String SESSION_KEY = "SESSION_KEY_IMAGE_CODE";
    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();
    private Set<String> urls=new HashSet<>();

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private ValidateCodeGenerator imageCodeGenerator;

    @RequestMapping("/code/image")
    public void createCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ImageCode imageCode=imageCodeGenerator.createImageCode(new ServletWebRequest(request));
        sessionStrategy.setAttribute(new ServletWebRequest(request),SESSION_KEY,imageCode);
        ImageIO.write(imageCode.getImage(), "JPEG", response.getOutputStream());
    }

//封裝改由提供interface實現
//    private ImageCode createImageCode(ServletWebRequest request) {
//        int width = ServletRequestUtils.getIntParameter(request.getRequest(),"width",securityProperties.getCode().getImage().getWidth());
//        int height = ServletRequestUtils.getIntParameter(request.getRequest(),"height",securityProperties.getCode().getImage().getHeight());
//        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
//        Graphics g = image.getGraphics();
//        Random random = new Random();
//        g.setColor(getRandColor(200,250));
//        g.fillRect(0,0,width,height);
//        g.setFont(new Font("Times New Roman",Font.ITALIC,20));
//        g.setColor(getRandColor(160,200));
//        for (int i = 0; i < 155; i++) {
//            int x = random.nextInt(width);
//            int y = random.nextInt(height);
//            int x1 = random.nextInt(12);
//            int y1 = random.nextInt(12);
//            g.drawLine(x,y,x+x1,y+y1);
//        }
//        String sRand = "";
//        //產生4位的驗證碼
//        for (int i = 0; i < securityProperties.getCode().getImage().getLength(); i++) {
//            String rand = String.valueOf(random.nextInt(10));
//            sRand += rand;
//            g.setColor(new Color(20,random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
//            g.drawString(rand, 13 * i + 6, 16);
//        }
//        g.dispose();
//
//        return new ImageCode(image, sRand, securityProperties.getCode().getImage().getExpireIn());
//    }
//
//    /**
//     * @description: 產生隨機背景條紋
//     * @param fc
//     * @param bc
//     * @return: java.awt.Color
//     * @author: Chris Chen
//     * @time: 2020/1/10 2:26 PM
//     */
//    private Color getRandColor(int fc, int bc) {
//        Random random = new Random();
//        if (fc > 255) {
//            fc = 255;
//        }
//        if (bc > 255) {
//            bc = 255;
//        }
//        int r = fc + random.nextInt(bc - fc);
//        int g = fc + random.nextInt(bc - fc);
//        int b = fc + random.nextInt(bc - fc);
//
//        return new Color(r, g, b);
//    }

}