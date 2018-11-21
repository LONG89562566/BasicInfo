/**   
* @Title: QRCodeUtil.java 
* @Package come 
* @Description: TODO(用一句话描述该文件做什么) 
* @author LeiXiaoLong(1245920593@qq.com)   
* @date 2017年7月5日 下午5:56:17 
* @version V1.0   
*/
package com.info.admin.utils;

import com.google.zxing.*;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;


import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Date;
import java.util.Hashtable;



/**
 * @ClassName: QrCodeUtil
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author
 * @date
 */
public class QrCodeUtil {

    private static final String CHARSET = "utf-8";

    private static final String FORMAT_NAME = "PNG";
    // windows
    private static final String PATH = "/webser/storage/";

    private static final String PATH_LINE = "/";

    // 二维码尺寸
    private static final int QRCODE_SIZE = 300;

    // LOGO宽度
    private static final int WIDTH = 60;

    // LOGO高度
    private static final int HEIGHT = 60;

    private HttpServletResponse  response;

    private static BufferedImage createImage(String content, String imgPath, boolean needCompress) throws Exception {
        Hashtable hints = new Hashtable();
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        hints.put(EncodeHintType.CHARACTER_SET, CHARSET);
        hints.put(EncodeHintType.MARGIN, 1);
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, QRCODE_SIZE, QRCODE_SIZE, hints);
        int width = bitMatrix.getWidth();
        int height = bitMatrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
            }
        }
        if (imgPath == null || "".equals(imgPath)) {
            return image;
        }
        // 插入图片
        insertImage(image, imgPath, needCompress);
        return image;
    }

    private static void insertImage(BufferedImage source, String imgPath, boolean needCompress) throws Exception {
        File file = new File(imgPath);
        if (!file.exists()) {
            System.err.println("" + imgPath + "   该文件不存在！");
        }
        Image src = ImageIO.read(new File(imgPath));
        int width = src.getWidth(null);
        int height = src.getHeight(null);
        if (needCompress) { // 压缩LOGO
            if (width > WIDTH) {
                width = WIDTH;
            }
            if (height > HEIGHT) {
                height = HEIGHT;
            }
            Image image = src.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics g = tag.getGraphics();
            g.drawImage(image, 0, 0, null); // 绘制缩小后的图
            g.dispose();
            src = image;
        }
        // 插入LOGO
        Graphics2D graph = source.createGraphics();
        int x = (QRCODE_SIZE - width) / 2;
        int y = (QRCODE_SIZE - height) / 2;
        graph.drawImage(src, x, y, width, height, null);
        Shape shape = new RoundRectangle2D.Float(x, y, width, width, 6, 6);
        graph.setStroke(new BasicStroke(3f));
        graph.draw(shape);
        graph.dispose();
    }

    public static String encode(HttpServletRequest request, String content,String fileName, String imgPath, boolean needCompress) {
        String destPath = "";
        String rtPath = "";
        try {
            // 文件保存本地目录路径
            String os = System.getProperty("os.name");
            if (os.toLowerCase().startsWith("win")) {
                // windows 下路径
                destPath = request.getSession().getServletContext().getRealPath("/") + PATH + "image/UserShareQrCode";
            } else {
                // linux 下路径
                destPath = PATH + "image/UserShareQrCode";
            }
            rtPath = PATH + "image/UserShareQrCode";
            // 检查目录
            File uploadDir = new File(destPath);
            if (!uploadDir.isDirectory()) {
                uploadDir.mkdirs();
            }
            // 创建文件夹
            destPath += PATH_LINE;
            rtPath  += PATH_LINE;
            File saveDirFile = new File(destPath);
            if (!saveDirFile.exists()) {
                saveDirFile.mkdirs();
            }
            //当前时间的年月日
            String ymd = DateUtil.dateToString(new Date(), DateUtil.FMT_YMD_HM_COMPACT);
            destPath += ymd + PATH_LINE;
            rtPath += ymd+ PATH_LINE;
            File dirFile = new File(destPath);
            if (!dirFile.exists()) {
                dirFile.mkdirs();
            }

            BufferedImage image = createImage(content, imgPath, needCompress);
            mkdirs(destPath);
            String file = fileName+ ".png";
            rtPath += file;
            ImageIO.write(image, FORMAT_NAME, new File(destPath + "/" + file));
        } catch (Exception e) {

        }
        return rtPath;
    }

    public static void mkdirs(String destPath) {
        File file = new File(destPath);
        // 当文件夹不存在时，mkdirs会自动创建多层目录，区别于mkdir．(mkdir如果父目录不存在则会抛出异常)
        if (!file.exists() && !file.isDirectory()) {
            file.mkdirs();
        }
    }

    public static void encode(HttpServletRequest request, String content,String fileName, String imgPath) throws Exception {
        encode(request, content, imgPath, false);
    }

    public static void encode(HttpServletRequest request, String content,String fileName, boolean needCompress) throws Exception {
        encode(request, content, fileName, needCompress);
    }

    public static void encode(HttpServletRequest request, String content,String fileName) throws Exception {
        encode(request, content, fileName, false);
    }

    public static void encode(HttpServletRequest request, String content, String imgPath, OutputStream output, boolean needCompress) throws Exception {
        BufferedImage image = createImage(content, imgPath, needCompress);
        ImageIO.write(image, FORMAT_NAME, output);
    }

    public static void encode(HttpServletRequest request, String content, OutputStream output) throws Exception {
        encode(request, content, null, output, false);
    }

    public static String decode(File file) throws Exception {
        BufferedImage image;
        image = ImageIO.read(file);
        if (image == null) {
            return null;
        }
        BufferedImageLuminanceSource source = new BufferedImageLuminanceSource(image);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
        Result result;
        Hashtable hints = new Hashtable();
        hints.put(DecodeHintType.CHARACTER_SET, CHARSET);
        result = new MultiFormatReader().decode(bitmap, hints);
        String resultStr = result.getText();
        return resultStr;
    }

    public static String decode(String path) throws Exception {
        return decode(new File(path));
    }







}