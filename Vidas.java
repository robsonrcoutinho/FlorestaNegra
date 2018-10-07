import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta é a classe base para todas as vidas
 * 
 * @since Novembro, 2013.
 */
public abstract class Vidas extends Actor
{
    /**
     * Método responsável por retornar
     * o número de pontos de vida.
     * @return int - retorna os pontos de vida.
     */
    public int getPontoVida(){
        return  this.vidas;
    } 
    
    /**
     * Método para setar o número de vidas. 
     * @param vidas - número de vidas.
     */
    public void setPontosDeVida(int vidas){
        this.vidas=vidas;
    }
    
    /**
     * Este método verifica se a vida é
     * menor que 10, caso seja ele
     * aumenta em 1 os pontos de vida.
     */
    public void aumentarPontoVida(){
        if(vidas<10){
             this.vidas++;
        }
    }
    
    /**
     * Este método seta a vida para 10.
     */
    public void recuperarTodaVida(){
         this.vidas=10;
    }
    
    /**
     * Este método seta a vida para 0.
     */
    public void perderTodaVida(){
         this.vidas=0;
    }
    
    public void perderPontoVida(){
        this.vidas-=1;
    }
    
    private int vidas;

}
