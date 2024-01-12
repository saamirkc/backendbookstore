//package samir.onlinebookstored.Controller;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.util.StreamUtils;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//import samir.onlinebookstored.Seervice.FileService;
//import samir.onlinebookstored.entity.FileResponse;
//import javax.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//import java.io.InputStream;
//
//@RestController
//@RequestMapping("/file")
//public class FileController {
//    @Autowired
//    private FileService fileService;
//
//    @Value("${project.image}")
//    private String path;
//
//    @PostMapping("/upload")
//    public ResponseEntity<FileResponse> fileUpload(@RequestParam("image") MultipartFile image) {
//
//
//        String fileName = null;
//        try {
//            fileName = this.fileService.uploadImage(path, image);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(new FileResponse(null,"Image is not uploaded due to some error"), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//
//        return new ResponseEntity<>(new FileResponse(fileName, "Image successfully uploaded"), HttpStatus.OK);
//    }
//
//@GetMapping(value = "/profiles/{imageName}",produces = MediaType.IMAGE_JPEG_VALUE)
//    public void downloadImage( @PathVariable("imageName") String imageName,
//    HttpServletResponse response
//) throws IOException {
//    InputStream resource =this.fileService.getResource(path,imageName);
//    response.setContentType(MediaType.IMAGE_JPEG_VALUE);
//    StreamUtils.copy(resource,response.getOutputStream());
//    }
//}
