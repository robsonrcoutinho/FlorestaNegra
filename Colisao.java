import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta é interface de colisão
 * ela controla as possíveis colisões
 * de quem a implementar
 * 
 * @since Dezembro, 2013.
 */
public interface Colisao 
{
    /**
     * Este método verifica se o ator que a 
     * implementar colidiu.
     */
    void colisao();
    
    /**
     * Este método verifica se o ator que a implementar
     * colidiu com algum elemento do cenário.
     */
    void colisaoCenario();
    
    /**
     * Este método verifica se o ator que a implementar
     * atingiu os limites do cenário.
     */
    void limitesCenario();
}
