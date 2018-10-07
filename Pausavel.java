import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta é uma interface para classes que
 * nescessitam de ser pausadas.
 * 
 * @since Janeiro, 2014.
 */
public interface Pausavel 
{
    /**
     * Este método é resonsável
     * por pausar as fases que utilizarem
     * esta interface.
     */
    void pause();
    
    /**
     * Este método é responsável 
     * por continuar as fases que implementarem
     * esta interface.
     */
    void continuar();
}
