import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Este ataque é o primeiro ataque de flora,
 * sua principal funcionalidade é: 
 * mover-se no eixo Y, caso colida com
 * o ator primcipal ele efetua dano no mesmo.
 * 
 * @since Novembro, 2013.
*/
public class Ataque1Flora extends TiroInimigos
{
    /**
     * No construtor deste ator
     * recebe um parâmetro inteiro
     * referente a direção na qual ele deve seguir
     * @param direcao - direcao na qual o ator deve seguir.
     */
    public Ataque1Flora(int direcao){
        this.direcao=direcao;
        
    }
    
    /**
     * Método responsável por realizar
     * as ações do persoangem
     */
    public void act() 
    {
        if(miraTravada!=true)
            mira();
        else{    
        move2();
        colisao();
       }
    }    
    
    /**
     * Este metodo obtem a posição de oberon
     * e posiona o ator na mesma cordenada X,
     * e abaixo de Oberon
     */
    public void mira(){
        posOberon=((Apocalipse)getWorld()).getPersonagemPrincipal();
        setLocation(posOberon.getX(), getY()+10);
        miraTravada=true;
    }
    
    private Actor posOberon;
    private boolean miraTravada;
}
