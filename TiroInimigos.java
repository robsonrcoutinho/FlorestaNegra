import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Classe base para tiros posteiores dos inimigos
 * Esta classe fornece, o controle de colisões
 * e dois tipos diferentes de movimentações
 * 
 * @version Novembro, 2013.
 */
public class TiroInimigos extends Actor implements Colisao
{
    /**
     * Este método verifica todas as colisões
     * inclusive colisões com o jogador,
     * caso o objeto colida com alguma delas
     * o tiro é removido.
     */
    public void colisao()
    {   possivelColisor=getOneIntersectingObject(Jogador.class);
        
        if(possivelColisor!=null){
            ((Jogador)possivelColisor).dano2();
            remossao=true;
        }
        
        colisaoCenario();
        
        if(remossao==true){
            ((MoveMundo)getWorld()).removerObjeto(this);
        }
        
    }
    /**
     * Este método verifica se o tiro colidiu
     * com um elemento do cenário como por exemplo
     * uma caixa
     */
    public void colisaoCenario(){
        possivelColisor=getOneIntersectingObject(Terrain.class);
        if(possivelColisor!=null)
            remossao=true;
    
            limitesCenario();        
        
    }
    
    /**
     * Este método verifica se o tiro atingiu  os limites do cenário.
     */
    public void limitesCenario(){
        if(getX()<(getWorld().getWidth())-(getWorld().getWidth()+1))
            remossao=true;
        
        if(getX()>getWorld().getWidth())
            remossao=true;
    }
    
    
    /**
     * Este método verifica a direcao
     * na qual deve seguir e movimenta
     * o tiro no eixo X.
     */
    public void move(){
        if(direcao==1)
            setLocation(getX()-4, getY());
       
        if(direcao==2)
            setLocation(getX()+4, getY());
        
    }
    
    /**
     * Este método verifica a direção
     * no qual o ator deve seguir e movimenta o tiro
     * no eixo Y
     */
    public void move2(){
        if(direcao==1)
            setLocation(getX(), getY()-2);
        if(direcao==2)    
            setLocation(getX(), getY()+2);
    }
    protected int direcao=1;
    private boolean remossao;
    private Actor possivelColisor;
}
