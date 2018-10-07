import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Este é o primeiro inimigo,
 * sua principal funcionalidade é andar
 * e atirar bolas de fogo.
 * 
 * @since Novembro,2013.
 */
public class Inimigo01 extends Inimigos
{
    /**
     * No construtor é invertido a imagem do ator   
     */
     public Inimigo01()
     {
         setAlturaPadrao(45);
    }
    
    /**
     * Este método é chamado pelo sistema
     * do greenfoot quando  o ator é inserido
     * no mundo.
     * @param world
     */
    protected void addedToWorld(World world){
        hp = new VidaInimigos();
        getWorld().addObject(hp, getX()+25, getY()-50);    
    }
    
    
   /**
     * Este método é chamado pela estrutura do greenfoot,
     * realizando todas as ações deste ator.
     */
   public void act() 
    {
        if(!morreu()){
            if(parar==false){
                if(frameDanoExecutado==true){
                    colisao();
                    gravidade();
                    frame();
                    levouDano();
                    andar();
                }else
                    frameDano();
            }else{
                levouDano();
                colisao();
            }
        }
   }
   
   /**
    * Esse método verifica se o ator morreu
    * caso tenha morrido ele remove a vida, e o
    * ator do cenário.
    */
   private boolean morreu()
    {
      if(hp.getPontoVida()<=0)
      {
         Actor ob =((MoveMundo)getWorld()).getPersonagemPrincipal();
          ((Jogador)ob).getEnergia().recuperarPontoEnergia();
          ((MoveMundo)getWorld()).removerObjeto(hp);
          ((MoveMundo)getWorld()).removerObjeto(this);
       
         return true;
      }
      else{
        return false;
      }
        
    }
    
    
    /**
     * Método responsável por verificar
     * se o ator levou dano, caso tenha levado
     * ele diminui a vida do ator.
     */
    public void levouDano(){
         if(dano==true){
             hp.perderPontoVida();
             dano=false;
             frameDanoExecutado=false;
         }
         if(dano2==true){
             for(int x=0;x<valorDano2Padrao;x++){
                hp.perderPontoVida();
                if(hp.getPontoVida()==0)
                    break;
            }
             dano2=false;   
             frameDanoExecutado=false;
         }
    }
   
    /**
     * Método responsável por adicionar o tiro no mundo,
     * como também fornecer a direção para o tiro.
     */
    private void atirar(){
            if(direcao==1)
                ((MoveMundo)getWorld()).adicionarObjeto(new TiroBicho01(direcao), getX()-80, getY(),false);
            
            if(direcao==2)
                ((MoveMundo)getWorld()).adicionarObjeto(new TiroBicho01(direcao), getX()+80, getY(),false);
 
     }
     
     /**
      * Método responsável por verificar a 
      * direção do ator.
      */
     public void andar(){
        if(moveBack==false&&direcao==1)
           mover();
           
        
           if(moveBack==true&&direcao==1){
           direcao=2;
           mover();
           moveBack=false;
           inverImagemDesteInimigo();
        }
        
        if(moveBack==false&&direcao==2)
           mover(); 
           
           if(moveBack==true&&direcao==2){
           direcao=1;
           mover();
           moveBack=false;
           inverImagemDesteInimigo();
        }
            
     }
    
     /**
      * Move o ator e chama o método
      * que movimenta a vida.
      */
    public void mover(){
        switch (direcao){
                case 1: setLocation(getX()-1, getY());
                    movimentaVida();
                    break;
                case 2:setLocation(getX()+1, getY());
                    movimentaVida();
                    break;
        }
    }
   
    /**
     * Movimenta a vida do ator.
     */
    private void movimentaVida(){
                    if(direcao==1)
                        hp.setLocation(getX()-25, getY()-50);
                    if(direcao==2)
                        hp.setLocation(getX()+25, getY()-50);
    }
        
   /**
    * Método responsável por inverter a imagem
    * do ator.
    */    
    private void inverImagemDesteInimigo(){
        for(int x =0;x<image.length;x++)
            image[x].mirrorHorizontally();
        
        for(int x=0;x<frameDano.length;x++)
            frameDano[x].mirrorHorizontally();
    }    
   
    /**
     * Este método é responsável por 
     * efetuar as animações do ator
     * e chamar o método atirar quando
     * o frameImage atingir 30;
     */
    private void frame(){
        if(frameImage%10==0)
           setImage(image[frameImage/10]);
        
        if(frameImage==48){
           frameImage=-1;
           atirar();
        }
        frameImage++; 
    }
    
   private void frameDano(){
       if(posDano%10==0)
            setImage(frameDano[posDano/10]);
       
       if(posDano==15){
            posDano=-1;
            frameDanoExecutado=true;
        }
            
       posDano++;     
   }
    
        private GreenfootImage[] image = { new GreenfootImage("lobo6.png"),new GreenfootImage("lobo7.png"),new GreenfootImage("lobo8.png"),
            new GreenfootImage("lobo9.png"), new GreenfootImage("lobo10.png")};
        private GreenfootImage[] frameDano = {new GreenfootImage("lobo20.png"), new GreenfootImage("lobo22.png")};    
        
        private int posDano;
        private int direcao=1;
        private boolean frameDanoExecutado=true;
    }    

    

