package model;

import java.util.Iterator;

public class Set<T> extends java.util.HashSet<T> {
    
    public T getByHashCode(int hash){
        Iterator<T> itens = this.iterator();
        while(itens.hasNext()){
            T item = itens.next();
            int itemHash = item.hashCode();
            if (item.hashCode() == hash){
                return item;
            }
        }
        return null;
    }
    
}
