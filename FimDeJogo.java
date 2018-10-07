import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta classe é referente ao menu
 * do fim do jogo.
 * 
 * @since Novembro, 2013.
 */
public class FimDeJogo extends World
{

    /**
     * Nesse construtor é redimensionado a imagem
     * de fundo para 800*400
     * e setado ao mundo.
     * 
     */
    public FimDeJogo()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 400, 1); 
        img.scale(800,400);
        setBackground(img);
    }

    GreenfootImage img = new GreenfootImage("fimDeJogo.jpg");
}
