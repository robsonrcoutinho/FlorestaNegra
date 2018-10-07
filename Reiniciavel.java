/**
 * Esta é uma interface para 
 * classes que possam ser reiniciadas.
 * 
 * @since dezembro 2013.
 */
public interface Reiniciavel 
{   
    /**
     * Este método reinicia parcialmente
     * a fase implementada.
     */
    void reiniciarParcialmente();
    
    /**
     * Este método reincia totalmente a 
     * fase implementada.
     */
    void reiniciarTotalmente();
}
