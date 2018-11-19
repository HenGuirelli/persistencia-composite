package arvore;

import DAO.ArvoreDAO;
import model.*;

/**
 *
 * @author Henrique Guirelli
 */
public class Arvore {

    public static void main(String[] args) {
        Tag tagRaiz = new Tag(); // topo da arvore
        tagRaiz.setName("Raiz");
        
        Tag tag1 = new Tag();
        tag1.setName("Tag1");
        tag1.add(new Content("conteudo tag 1"));
        
        Tag tag2 = new Tag();
        tag2.setName("Tag2");
        tag2.add(new Content("conteudo tag 2"));
        
        Tag tag3 = new Tag();
        tag3.setName("Tag3");
        
        Tag tag4 = new Tag();
        tag4.setName("Tag4");
        tag4.add(new Content("conteudo 4"));
        tag3.add(tag4);        
        
        tagRaiz.add(tag1);
        tagRaiz.add(tag2);        
        tagRaiz.add(tag3);
        
        tagRaiz.print();
        System.out.println("---------------------------");
        ArvoreDAO.salvar(tagRaiz);
        
        XML carregado = ArvoreDAO.carregar();
        carregado.print();
    }
    
}
