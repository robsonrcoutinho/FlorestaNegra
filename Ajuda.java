import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ajuda here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ajuda extends World
{

    /**
     * Constructor for objects of class Ajuda.
     * 
     */
    public Ajuda(World fasePausada)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 400, 1); 
        img.scale(800,400);
        setBackground(img);
        this.fasePausada=fasePausada;
        
        botoes[0]=new ObjetivoDoJogo();
        botoes[1]=new Teclas();
        botoes[2]=new Voltar(fasePausada);
        
        addObject(botoes[0], 150, 265);
        addObject(botoes[1], 645, 265);
        addObject(botoes[2], 397, 350);
    }
    
    private World fasePausada;
    private ItensMenu[] botoes = new ItensMenu[3];
    private GreenfootImage img = new GreenfootImage("menuAjuda.jpg");
}
