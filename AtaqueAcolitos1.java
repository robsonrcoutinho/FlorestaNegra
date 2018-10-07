import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AtaqueAcolitos1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AtaqueAcolitos1 extends TiroInimigos
{
    public AtaqueAcolitos1(){
        this.direcao=2;
    }
    
    public void act() 
    {
        if(miraTravada!=true)
            mira();
        else{
            move2();
            colisao();
            animacao();
        }
    }
    
    public void animacao(){
        if(posAnimacao%10==0)
            setImage(img[posAnimacao/10]);
        
        if(posAnimacao==18)
            posAnimacao=-1;
            
        posAnimacao++;    
    }
    
    /**
     * Este metodo obtem a posição de oberon
     * e posiona o ator na mesma cordenada X,
     * e acima de Oberon
     */
    public void mira(){
        posOberon=((MoveMundo)getWorld()).getPersonagemPrincipal();
        setLocation(posOberon.getX(), getY()-420);
        miraTravada=true;
    }
    
    private GreenfootImage[] img ={new GreenfootImage("acolitosRaio.png"), 
        new GreenfootImage("acolitosRaio2.png")};
    private int posAnimacao;    
    private Actor posOberon;
    private boolean miraTravada;

}
