import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Este é o tiro do Inimigo02,
 * suas principais funcionalidades são
 * mover-se no eixo X, caso acerte o ator 
 * principal ele efetua dano ao mesmo.
 * @since Novembro 2013.
 */
public class TiroBicho02 extends TiroInimigos
{    
    /**
     * No construtor deste ator,
     * é setado a direção na qual ele deve seguir
     * @param direcao - direcao na qual o ator deve seguir.
     */
    public TiroBicho02(int direcao){
        this.direcao=direcao;
    }
    
    /**
     * Quando o ator é adicionado ao mundo
     * este método é chamado, assim
     * é setado sua imagem
     * @param world
     */
    protected void addedToWorld(World world){
        setImage("z6.png");
    
    }
    
    /**
     * Este método é responsável por
     * efetuar todas as ações do ator
     */
    public void act() 
    {
        move();
        colisao();
    }    
}
