package fs.four.gamo.board.dto;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class PostDto {
    private String title;
    private String content;
    private List<MultipartFile> files; // 다중 파일 업로드를 지원

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<MultipartFile> getFiles() {
        return files;
    }

    public void setFiles(List<MultipartFile> files) {
        this.files = files;
    }
}
