import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Este é o tiro da besta de Oberon
 * sua principal funcionaldade é locomover-se
 * através d eixo X, e caso atingir inimigos
 * lhe causar danos.
 * 
 * @since Novembro 2013.
 */
public class TiroBesta extends ArmasOberon
{
    /**
     * Este método é responsável por mover
     * esse ator.
     */
    private void move(){
        if(direita==false)
            setLocation(getX()-3, getY());
        else
            setLocation(getX()+3, getY());
    }
    
    /**
     * No construtor é setado a direção na qual
     * o ator deve seguir
     * @param direita - reprenta  a direção na qual o ator deve seguir.
     */
    public TiroBesta(boolean direita){
        this.direita=direita;
    }
    
    /**
     * Este método é chamado pelo sistema
     * do greenfoot quando  o ator é inserido
     * no mundo.
     * @param world .
     */
    protected void addedToWorld(World world){
        somTiro.play();
    }
   
    /**
     * Este método é chamado pela estrutura do greenfoot,
     * realizando todas as ações deste ator.
     */
    public void act() 
    {
        move();
        colisao2();
        animacao();
        
    }
    
    private void animacao(){
        if(posFrame%10==0)
            setImage(img[posFrame/10]);
        
        if(posFrame==68)
            posFrame=-1;
        
        posFrame++;    
    }

   private GreenfootImage[] img ={new GreenfootImage("poderOb0.png"), new GreenfootImage("poderOb1.png"),new GreenfootImage("poderOb2.png"),
    new GreenfootImage("poderOb3.png"),new GreenfootImage("poderOb4.png"),new GreenfootImage("poderOb5.png"),new GreenfootImage("poderOb6.png")};     
   private boolean direita;
   private int posFrame;
   
   GreenfootSound somTiro = new GreenfootSound("tiroFlecha.mp3");
}
