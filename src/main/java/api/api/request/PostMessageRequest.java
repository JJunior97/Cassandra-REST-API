package api.api.request;

public class PostMessageRequest {

    private String email;
    private String title;
    private String content;
    private int magic_number;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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

    public int getMagic_number() {
        return magic_number;
    }

    public void setMagic_number(int magic_number) {
        this.magic_number = magic_number;
    }
}
