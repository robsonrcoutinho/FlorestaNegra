import greenfoot.*;
/**
 * Esta classe é um elevador,
 * suas principais ações são:
 * subir, descer e elevar o personagem.
 * @since Novembro, 2013.
   */
public class Elevador extends Terrain
{
    /**
     * Este método é chamado pela estrutura do greenfoot,
     * realizando todas as ações do ator.
     */
    public void act() 
    {
        if(pausado==false){
            sobe();
            desce();
        }
    }
    
    /**
     * Este método é responsável por fazer o
     * ator subir até atingir a altura limite
     */
    private void sobe()
    {
        if(subiu==false){
            if(this.getY()==getWorld().getHeight()/2){
                subiu=true;
            }else{
                Actor teste = colisao();
                if(teste!=null) 
                    if(teste.getY()<getY())
                        teste.setLocation(teste.getX(), teste.getY()-1);
                
                        setLocation(getX(),getY()-1);
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
          if(this.getY()==getWorld().getHeight()-45){
              subiu=false;
          }else{
                    Actor teste = colisao();
                    if(teste!=null) 
                        if(teste.getY()<getY())
                            teste.setLocation(teste.getX(), teste.getY()+1);
              
                    setLocation(getX(),getY()+1);
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
    
   public void pausar(){
       pausado=true;
   }
   
   public void despausar(){
       pausado=false;
   }
    
    private Actor possivelColisor;
    private boolean subiu = false;
    private boolean pausado;
    
}
