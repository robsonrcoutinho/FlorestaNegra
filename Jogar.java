import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Este é o botão do meu Jogar, ao clicar sobre ele
 * ele rerediciona para a primeira fase do jogo.
 * 
 * @since Novembro, 2013.
 */
public class Jogar extends ItensMenu
{
    /**
     * Este método é chamado pela estrutura do greenfoot,
     * realizando todas as ações deste ator.
     * @param world
     */
    protected void  addedToWorld(World world){
            img.scale(200,33);
            setImage(img);
    }
    
    /**
     * Este método é responsável por
     * realizar todas as ações de todos os 
     * ator.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            ((Menu)getWorld()).desligarSom();    
            Greenfoot.setWorld(new Primeira());
        }
    }
    
    
    GreenfootImage img = new GreenfootImage("Botao1.jpg");
}
