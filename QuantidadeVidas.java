import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Este classe é referente a quantidade
 *  de vidas do personagem principal.
 * 
 * @since Novembro, 2013.
 */
public class QuantidadeVidas extends Actor
{
    /**
     * Este método é responsável por
     *  executar todas as ações do ator.
     */
    public QuantidadeVidas(){
        for(int x=0;x<qtdVidas.length;x++)
            qtdVidas[x].scale(130, 30);
        }
    
    /**
     * Este método é chamado pelo sistema
     * do greenfoot quando  o ator é inserido
     * no mundo.
     * @param world
     */
    protected void addedToWorld(World world){
        setImage(qtdVidas[0]);
    }
    
    /**
     * Este método é chamado pela estrutura do greenfoot,
     * realizando todas as ações deste ator.
     */
    public void act(){
        if(vidas==3)
            setImage(qtdVidas[0]);
        
        if(vidas==2)
            setImage(qtdVidas[1]);
        
        if(vidas==1)
            setImage(qtdVidas[2]);
        
        if(vidas==0)
            Greenfoot.setWorld(new FimDeJogo());
    }
    
    /**
     * Este método é responsável por
     * diminuir a vida  do ator
     * e realocar o ator em relação a vida.
     */
    public void diminuirVidas(){
        if(vidas>0){
            this.vidas--;
            ((MoveMundo)getWorld()).reiniciarParcialmente();
       }else
            this.vidas--;
    }

    /**
     * Este método retorna a
     * quantidade de vidas.
     * @return vidas - número de vidas.
     */    
    public int getVidas(){
        return this.vidas;
    }
    
    public void recuperarVidas(){  
    
       vidas = 3;
    
    }
    private static int vidas=3;
 
    
    private GreenfootImage[] qtdVidas ={
    new GreenfootImage("3vidas.png"),new GreenfootImage("2vidas.png"),new GreenfootImage("1vidas.png")};
   
}
