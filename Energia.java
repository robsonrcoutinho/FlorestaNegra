import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta classe é referente a energia
 * do mundo.
 * 
 * @since Novembro, 2013.
 */
public class Energia extends Actor
{
    /**
     * Este método é chamado quando
     * o ator é adicionado ao mundo.
     */
    public Energia(){
        for(int x=0;x<energiaImg.length;x++)
            energiaImg[x].scale(130, 30);
    }
    
    /**
     * Este método é chamado pelo sistema
     * do greenfoot quando  o ator é inserido
     * no mundo.
     * @param world
     */
    protected void addedToWorld(World world){
       setImage(energiaImg[4]);
    }
   
    /**
     * Este método é chamado pela estrutura do greenfoot,
     * realizando todas as ações deste ator.
     */
    public void act(){
        setImage(energiaImg[energia]);
    }
    
    /**
     * Este método é responsável por
     * diminuir a energia do ator.
     */
    public void diminuirEnergia(){
        this.energia--;
    }
    
    /**
     * Este método é responsável  por
     * retorna os ponstos de energia.
     * @return int - Pontos de energia. 
     */
    public int getEnergia(){
        return this.energia;
    }
    
    /**
     * Este método é responsável
     * por recuperar os pontos de energia.
     */
    public void recuperarPontoEnergia(){
        if(energia<4){
             this.energia++;
        }
    }
    
    /**
     * Este método é responsável
     * por recuperar toda a energia do personagem.
     */
    public void recuperarTodaEnergia(){
         this.energia=4;
    }
    
    private GreenfootImage[] energiaImg ={ new GreenfootImage("Energia04.png"),new GreenfootImage("Energia03.png"),
                                           new GreenfootImage("Energia02.png"),new GreenfootImage("Energia01.png"),
                                           new GreenfootImage("Energia05.png")};
    private static int energia=4;
}
