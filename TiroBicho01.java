import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Este é o tiro do Inimigo01,
 * suas principais funcionalidades são 
 * mover-se no eixo x, caso acertar o personagem
 * efetuar dano no mesmo.
 * 
 * @since Novembro 2013.
 */
public class TiroBicho01 extends TiroInimigos
{
    /**
     * No construtor desse ator
     * é setado a direção na qual ele deve
     * seguir.
     * @param direcao - direcao na qual o ator deve seguir.
     */
    public TiroBicho01(int direcao){
        this.direcao=direcao;
    }
    
    /**
     * Este método é chamado pelo sistema
     * do greenfoot quando  o ator é inserido
     * no mundo.
     * @param world
     */
    protected void addedToWorld(World world){
        if(direcao==1){
            img.mirrorHorizontally();
            setImage(img);
        }else
            setImage(img);
    }
    
    /**
     * Este método é chamado pela estrutura do greenfoot,
     * realizando todas as ações deste ator.
     */
    public void act() 
    {
        move();
        colisao();
    }
    
   private GreenfootImage img = new GreenfootImage("2.png");
    
}
