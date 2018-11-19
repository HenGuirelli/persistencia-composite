package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Tag implements XML {
    private List<XML> list = new ArrayList<>();
    private String name;
    
    /*variavel de uso interno*/
    private int hash;
    
    public void add(XML tag){
        list.add(tag);
    }
    
    public void remove(XML tag){
        list.remove(tag);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void print() {
        System.out.println("<" + name + ">");
        list.forEach(u -> u.print());
        System.out.println("</" + name + ">");
    }

    public List<XML> getList(){
        return list;
    }

    @Override
    public String getString() {
        String resp = "<" + name + ">";
        for(XML content : list){
            resp += content.getString();
        }
        resp += "</" + name + ">"; 
        return resp;
    }
    
   @Override
    public String getFormattedSQL(XML pai) {
        String paiHash = pai == null ? "null" : Integer.toString(pai.hashCode());
        
        String resp = "(" + this.hashCode() + ", " + paiHash + ", true,'" + name + "', null)";
        
        for(XML content : list){
            resp +=  "," + content.getFormattedSQL(this);
        }        
        return resp;
    }

    @Override
    public int hashCode() {
        if (hash != 0) { return hash; }
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.name);
        return hash;
    }
    
    public void setHashCode(int hash){
        this.hash = hash;
    }
    
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tag other = (Tag) obj;
        return true;
    }
    
    
}
