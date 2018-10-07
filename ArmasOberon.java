import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta é classe base para as armas de Oberon,
 * ela fornece funcionalidades básicas como
 * verificar colisão com os inimigos, cenário e
 * limites do cenário.
 * 
 * @since Novembro 2013.
 */
public class ArmasOberon extends Actor implements Colisao
{
    /**
     * Este método verifica se o ator 
     * colidiu com o ator.
     */
    public void colisao()
    {   possivelColisor=getOneIntersectingObject(Inimigos.class);
        
        if(possivelColisor!=null){
            ((Dano)possivelColisor).dano();
            remossao=true;
        }
        else 
            colisaoCenario();
        
        if(remossao==true){
            getWorld().removeObject(this);
        }
    }
    
    public void colisao2(){
      possivelColisor=getOneIntersectingObject(Inimigos.class);
        
        if(possivelColisor!=null){
            ((Dano)possivelColisor).dano2();
            remossao=true;
        }
        else 
            colisaoCenario();
        
        if(remossao==true){
            getWorld().removeObject(this);
        }
    
    }

    /**
     * Este método verifica se o ator
     * colidiu com algum elemento do cenário
     */
    public void colisaoCenario(){
        possivelColisor=getOneIntersectingObject(Terrain.class);
        if(possivelColisor!=null)
            remossao=true;
    
            limitesCenario();        
        
    }
    
    /**
     * Este método verifica se o ator
     * colidiu com os limites do cenário.
     */
    public void limitesCenario(){
        if(getX()<(getWorld().getWidth())-(getWorld().getWidth()+1))
            remossao=true;
        
        if(getX()>getWorld().getWidth())
            remossao=true;
    } 
    
     protected boolean remossao;
     private Actor possivelColisor;
}
