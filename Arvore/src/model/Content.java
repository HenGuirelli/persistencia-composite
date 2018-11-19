package model;

public class Content implements XML {
    private String content;
    
    public Content(String content){
        this.content = content;
    }
    
    public Content()
    {
    
    }    
    
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public void print() {
        System.out.println(content);
    }

    @Override
    public String getString() {
        return content;
    }

    @Override
    public String getFormattedSQL(XML pai) {
        return "(" + this.hashCode() + ", " + pai.hashCode() + ", false, null, '" + content + "')";
    }
}
