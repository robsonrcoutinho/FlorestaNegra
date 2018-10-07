import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AtaqueAcolitos2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AtaqueAcolitos2 extends TiroInimigos
{
    public AtaqueAcolitos2(int direcao){
        this.direcao=direcao;
    }
    
    public void act() 
    {
        if(animacaoExibida=false)
            animacao();
        
        move();    
        colisao();    
    }
    
    private void animacao(){
        if(posAnimacao%10==0)
            setImage(img[posAnimacao/10]);
        
        if(posAnimacao==28){
            posAnimacao=-1;
            animacaoExibida=true;
        }
        
        posAnimacao++;
    }
    
    private void inverterImagem(){
        for(int x=0;x<img.length;x++)
            img[x].mirrorHorizontally();
    }
    private GreenfootImage[] img ={new GreenfootImage("fogoacolitos.png"), new GreenfootImage("fogoacolitos2.png"), 
        new GreenfootImage("fogoacolitos3.png")};
    
    private int posAnimacao;
    private boolean animacaoExibida;
}
