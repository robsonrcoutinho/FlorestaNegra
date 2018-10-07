import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta é uma interface de dano
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface Dano{
     
     /**
      * Este método verifica se o ator
      * levou dano;
      */
     void levouDano();
    
     /**
      * Este método seta dano a oponentes do ator
      * que implementar esta interface.
      */
     void dano();
     
     /**
      * Este seta o segundo dano a oponentes
      * do ator que implementar esta interface
      */
     void dano2();
          
}
