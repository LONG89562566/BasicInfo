package com.info.admin.controller.upload;

import com.info.admin.controller.base.BaseController;
import com.info.admin.entity.FileAttr;
import com.info.admin.result.*;
import com.info.admin.service.FileAttrService;
import com.info.admin.utils.ImgTools;
import com.info.admin.utils.MultipartFileUtils;
import net.sf.json.JSONObject;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 文件上传
 *
 * @author administrator
 */
@Controller
@RequestMapping("/admin")
public class UploadController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
    // windows
    private String PATH = "/webser/storage/";

    private String PATH_LINE = "/";

    @Autowired
    private FileAttrService fileAttrService;

    /**
     * 上传图片
     *
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/uploadImgs", method = {RequestMethod.GET, RequestMethod.POST})
    public JsonResult uploadImgs(HttpServletRequest request, HttpServletResponse response,
                                 @RequestParam("imgFiles") MultipartFile[] imgFiles, @ModelAttribute FileAttr fileAttr) {
        try {
            if (imgFiles != null) {
                List<String> pathList = MultipartFileUtils.getImgPath(request, response, imgFiles);
                if (CollectionUtils.isNotEmpty(pathList)) {
                    //保存文件到文件表
                    fileAttr.setCreateUser(getLoginUserId(request));
                    fileAttrService.insertBatchFileAttr(fileAttr, pathList);
                    // 返回图片的路径
                    return new JsonResult(JsonResultCode.SUCCESS, "上传成功", pathList);
                } else {
                    return new JsonResult(JsonResultCode.FAILURE, "上传失败", "");
                }
            }
            return new JsonResult(JsonResultCode.FAILURE, "参数有误", "");
        } catch (Exception e) {
            logger.error("[UploadController][uploadImgs] exception:", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统故障，请联系管理员", "");
        }
    }

    /**
     * layUI富文本编辑器上传图片
     */
    @ResponseBody
    @RequestMapping(value = "/uploadImgsByLayedit", method = {RequestMethod.GET, RequestMethod.POST})
    public LayuiResult uploadImgsByLayedit(HttpServletRequest request, HttpServletResponse response, MultipartFile[] file) {
        try {
            if (file != null) {
                List<String> logoPathList = MultipartFileUtils.getImgPath(request, response, file);
                Data data = new Data();
                data.setSrc(logoPathList.get(0));
                data.setTitle("图片");
                if (CollectionUtils.isNotEmpty(logoPathList)) {
                    // 返回图片的路径
                    return new LayuiResult(LayuiResultCode.SUCCESS, "上传成功", data);
                }
                return new LayuiResult(LayuiResultCode.FAILURE, "上传失败", data);

            }
            return new LayuiResult(LayuiResultCode.FAILURE, "参数有误", null);
        } catch (Exception e) {
            logger.error("[UploadController][uploadImgsByLayedit] exception:", e);
            return new LayuiResult(LayuiResultCode.FAILURE, "系统故障，请联系管理员", null);
        }
    }

    /**
     * 文件上传
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public void fileUpload(HttpServletRequest request, HttpServletResponse response,
                           @RequestParam("imgFile") MultipartFile[] files, @ModelAttribute FileAttr fileAttr) {
        try {
            response.setCharacterEncoding("utf-8");
            PrintWriter out = response.getWriter();
            //文件保存本地目录路径  
            String savePath = "";
            String os = System.getProperty("os.name");
            if (os.toLowerCase().startsWith("win")) {
                //windows 下路径
                savePath = request.getSession().getServletContext().getRealPath("/") + PATH;
            } else {
                //linux 下路径
                savePath = PATH;
            }
            //文件保存目录URL 
            String saveUrl = request.getContextPath() + PATH;
            if (!ServletFileUpload.isMultipartContent(request)) {
                out.print(getError("请选择文件。"));
                out.close();
                return;
            }
            //检查目录  
            File uploadDir = new File(savePath);
            if (!uploadDir.isDirectory()) {
                uploadDir.mkdirs();
            }
            //检查目录写权限  
            if (!uploadDir.canWrite()) {
                out.print(getError("上传目录没有写权限。"));
                out.close();
                return;
            }

            String dirName = request.getParameter("dir");
            if (dirName == null) {
                dirName = "image";
            }

            //定义允许上传的文件扩展名  
            Map<String, String> extMap = new HashMap<String, String>();
            extMap.put("image", "gif,jpg,jpeg,png,bmp");
            extMap.put("flash", "swf,flv");
            extMap.put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
            extMap.put("file", "doc,docx,xls,xlsx,ppt,htm,html,xml,txt,zip,rar,gz,bz2");

            if (!extMap.containsKey(dirName)) {
                out.print(getError("目录名不正确。"));
                out.close();
                return;
            }
            //创建文件夹  
            savePath += dirName + PATH_LINE;
            saveUrl += dirName + PATH_LINE;
            File saveDirFile = new File(savePath);
            if (!saveDirFile.exists()) {
                saveDirFile.mkdirs();
            }

            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String ymd = sdf.format(new Date());
            savePath += ymd + PATH_LINE;
            saveUrl += ymd + PATH_LINE;
            File dirFile = new File(savePath);
            if (!dirFile.exists()) {
                dirFile.mkdirs();
            }
            //最大文件大小  
            long maxSize = 1000000;
            // 保存文件  
            for (MultipartFile iFile : files) {
                String fileName = iFile.getOriginalFilename();

                //检查文件大小  
                if (iFile.getSize() > maxSize) {
                    out.print(getError("上传文件大小超过限制。"));
                    out.close();
                    return;
                }
                //检查扩展名  
                String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
                if (!Arrays.<String>asList(extMap.get(dirName).split(",")).contains(fileExt)) {
                    out.print(getError("上传文件扩展名是不允许的扩展名。\n只允许" + extMap.get(dirName) + "格式。"));
                    out.close();
                    return;
                }

                SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
                String newFileName = df.format(new Date()) + "_" + new Random().nextInt(1000) + "." + fileExt;
                try {
                    File uploadedFile = new File(savePath, newFileName);
                    // 写入文件  
                    FileUtils.copyInputStreamToFile(iFile.getInputStream(), uploadedFile);
                    if (iFile.getSize() > 120 * 1024) {
                        ImgTools.zipWidthHeightImageFile(uploadedFile, uploadedFile, 1080, 1920, 1f);
                    }
                } catch (Exception e) {
                    out.print(getError("上传文件失败。"));
                    out.close();
                    return;
                }

                JSONObject obj = new JSONObject();
                obj.put("error", 0);
                obj.put("url", saveUrl + newFileName);

                out.print(obj.toString());
                out.close();

            }


        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    private Map<String, Object> getError(String errorMsg) {
        Map<String, Object> errorMap = new HashMap<String, Object>();
        errorMap.put("error", 1);
        errorMap.put("message", errorMsg);
        return errorMap;
    }

    /**
     * 文件空间
     *
     * @param request  {@link HttpServletRequest}
     * @param response {@link HttpServletResponse}
     * @return json
     */
    @RequestMapping(value = "/fileManager")
    @ResponseBody
    public void fileManager(HttpServletRequest request, HttpServletResponse response) {
        try {
            //根目录路径，可以指定绝对路径  
            String rootPath = request.getSession().getServletContext().getRealPath(PATH_LINE) + "upload" + PATH_LINE + "goods" + PATH_LINE;
            //根目录URL，可以指定绝对路径，比如 http://www.yoursite.com/attached/  
            String rootUrl = request.getContextPath() + PATH_LINE + "upload" + PATH_LINE + "goods" + PATH_LINE;

            response.setContentType("application/json; charset=UTF-8");
            PrintWriter out = response.getWriter();

            //图片扩展名  
            String[] fileTypes = new String[]{"gif", "jpg", "jpeg", "png", "bmp"};

            String dirName = request.getParameter("dir");
            if (dirName != null) {
                if (!Arrays.<String>asList(new String[]{"image", "flash", "media", "file"}).contains(dirName)) {
                    out.print("无效的文件夹。");
                    out.close();
                    return;
                }
                rootPath += dirName + PATH_LINE;
                rootUrl += dirName + PATH_LINE;
                File saveDirFile = new File(rootPath);
                if (!saveDirFile.exists()) {
                    saveDirFile.mkdirs();
                }
            }
            //根据path参数，设置各路径和URL  
            String path = request.getParameter("path") != null ? request.getParameter("path") : "";
            String currentPath = rootPath + path;
            String currentUrl = rootUrl + path;
            String currentDirPath = path;
            String moveupDirPath = "";
            if (!"".equals(path)) {
                String str = currentDirPath.substring(0, currentDirPath.length() - 1);
                moveupDirPath = str.lastIndexOf(PATH_LINE) >= 0 ? str.substring(0, str.lastIndexOf(PATH_LINE) + 1) : "";
            }

            //排序形式，name or size or type  
            String order = request.getParameter("order") != null ? request.getParameter("order").toLowerCase() : "name";

            //不允许使用..移动到上一级目录  
            if (path.indexOf("..") >= 0) {
                out.print("访问权限拒绝。");
                out.close();
                return;
            }
            //最后一个字符不是/  
            if (!"".equals(path) && !path.endsWith(PATH_LINE)) {
                out.print("无效的访问参数验证。");
                out.close();
                return;
            }
            //目录不存在或不是目录  
            File currentPathFile = new File(currentPath);
            if (!currentPathFile.isDirectory()) {
                out.print("文件夹不存在。");
                out.close();
                return;
            }

            //遍历目录取的文件信息  
            List<Map<String, Object>> fileList = new ArrayList<Map<String, Object>>();
            if (currentPathFile.listFiles() != null) {
                for (File file : currentPathFile.listFiles()) {
                    Hashtable<String, Object> hash = new Hashtable<String, Object>();
                    String fileName = file.getName();
                    if (file.isDirectory()) {
                        hash.put("is_dir", true);
                        hash.put("has_file", (file.listFiles() != null));
                        hash.put("filesize", 0L);
                        hash.put("is_photo", false);
                        hash.put("filetype", "");
                    } else if (file.isFile()) {
                        String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
                        hash.put("is_dir", false);
                        hash.put("has_file", false);
                        hash.put("filesize", file.length());
                        hash.put("is_photo", Arrays.<String>asList(fileTypes).contains(fileExt));
                        hash.put("filetype", fileExt);
                    }
                    hash.put("filename", fileName);
                    hash.put("datetime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(file.lastModified()));
                    fileList.add(hash);
                }
            }

            if ("size".equals(order)) {
                Collections.sort(fileList, new SizeComparator());
            } else if ("type".equals(order)) {
                Collections.sort(fileList, new TypeComparator());
            } else {
                Collections.sort(fileList, new NameComparator());
            }

            JSONObject result = new JSONObject();
            result.put("moveup_dir_path", moveupDirPath);
            result.put("current_dir_path", currentDirPath);
            result.put("current_url", currentUrl);
            result.put("total_count", fileList.size());
            result.put("file_list", fileList);

            out.println(result.toString());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class NameComparator implements Comparator<Map<String, Object>> {
        public int compare(Map<String, Object> hashA, Map<String, Object> hashB) {
            if (((Boolean) hashA.get("is_dir")) && !((Boolean) hashB.get("is_dir"))) {
                return -1;
            } else if (!((Boolean) hashA.get("is_dir")) && ((Boolean) hashB.get("is_dir"))) {
                return 1;
            } else {
                return ((String) hashA.get("filename")).compareTo((String) hashB.get("filename"));
            }
        }
    }

    private class SizeComparator implements Comparator<Map<String, Object>> {
        public int compare(Map<String, Object> hashA, Map<String, Object> hashB) {
            if (((Boolean) hashA.get("is_dir")) && !((Boolean) hashB.get("is_dir"))) {
                return -1;
            } else if (!((Boolean) hashA.get("is_dir")) && ((Boolean) hashB.get("is_dir"))) {
                return 1;
            } else {
                if (((Long) hashA.get("filesize")) > ((Long) hashB.get("filesize"))) {
                    return 1;
                } else if (((Long) hashA.get("filesize")) < ((Long) hashB.get("filesize"))) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
    }

    private class TypeComparator implements Comparator<Map<String, Object>> {
        public int compare(Map<String, Object> hashA, Map<String, Object> hashB) {
            if (((Boolean) hashA.get("is_dir")) && !((Boolean) hashB.get("is_dir"))) {
                return -1;
            } else if (!((Boolean) hashA.get("is_dir")) && ((Boolean) hashB.get("is_dir"))) {
                return 1;
            } else {
                return ((String) hashA.get("filetype")).compareTo((String) hashB.get("filetype"));
            }
        }
    }
}
