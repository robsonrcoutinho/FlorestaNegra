import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pause here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pause extends World
{
    /**
     * Constructor for objects of class Pause.
     * 
     */
    public Pause(World world)
    {    
        
        super(800, 400, 1); 
        img.scale(800,400);
        setBackground(img);
        fasePausada=world;
        
        botoes[0]= new Continuar((Pausavel)fasePausada);
        botoes[1]= new Reiniciar((Reiniciavel)fasePausada);
        botoes[2]= new MenuPrincipal();
        botoes[3]= new botaoAjuda();
        
        addObject(botoes[0], 395, 160);
        addObject(botoes[1], 395, 213);
        addObject(botoes[2], 395, 267);
        addObject(botoes[3], 395, 321);
    }
    
    private World fasePausada;
    private ItensMenu[] botoes= new ItensMenu[4];
    private GreenfootImage img = new GreenfootImage("pause.jpg");
}
