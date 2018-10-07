import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta classe representa um Totem
 * @since Novembro, 2013.
*/
public class Totem extends Terrain
{
    /**
     * Este método é chamado pela estrutura do greenfoot,
     * realizando todas as ações do ator.
     */
    public void act() 
    {
        sobe();
        desce();
    }
    
    /**
     * Este método é responsável por fazer o
     * ator subir até atingir a altura limite
     */
    private void sobe()
    {
        if(subiu==false){
            if(this.getY()<=getWorld().getHeight()/2){
                subiu=true;
                setImage(img[0]);
            }else{
                Actor teste = colisao();
                if(teste!=null) 
                    if(teste.getY()<getY())
                        teste.setLocation(teste.getX(), teste.getY()-2);
                
                        setLocation(getX(),getY()-2);
            }
        }
   }
   
   /**
    * Este método é responsável por fazer
    * o ator descer até a altura limite
    */
   private void desce()
   {
       if(subiu==true){
          if(this.getY()>=getWorld().getHeight()-45){
              subiu=false;
              setImage(img[1]);
          } else{
                Actor teste = colisao();
                    if(teste!=null){ 
                        if(teste.getY()<getY())
                            teste.setLocation(teste.getX(), teste.getY()+2);
                        if(teste.getY()>getY())
                            teste.setLocation(teste.getX(), teste.getX()-2);
                        }
                            
              
                        setLocation(getX(),getY()+2);
              }        
        }
   }
   
   /**
    * Este método verifica se o ator
    * colidiu com  algum ator do tipo Oberon.
    *@return Actor
    */
   public Actor colisao(){
        possivelColisor= getOneIntersectingObject(Oberon.class);
            if(possivelColisor!=null){
                return possivelColisor;       
            }
            else
                return null;
    }
    
    private Actor possivelColisor;
    private boolean subiu = false; 
    private GreenfootImage[] img = {new GreenfootImage("toten0.png"),new GreenfootImage("toten2.png")};
}
