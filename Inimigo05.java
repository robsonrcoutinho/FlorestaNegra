import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Inimigo_05 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inimigo05 extends Inimigos
{
   public Inimigo05(){
       setAlturaPadrao(65);
   }
   
    protected void addedToWorld(World world){
        hp = new VidaInimigos();
        getWorld().addObject(hp, getX(), getY()-50);    
    }
    
   public void act() 
    {
        if(!morreu()){
            if(parar==false){
                if(naoLevouDano==true){
                    if(ataque==true){
                        ((Jogador)possivelColisor).dano();
                        if(ataqueExecutado==false){    
                            ataque();
                            levouDano();
                            gravidade();
                        }
                    }else{
                        levouDano();
                        possivelColisor = colisao();
                        gravidade();
                        andando();
                        andar();
                        ataqueExecutado=false;
                    }
                }else
                    frameDano();
            }else{
                levouDano();
                colisao();
            }
        }
   }
   
   private boolean morreu()
    {
      if(hp.getPontoVida()<=0)
      {
        getWorld().removeObject(hp);
        getWorld().removeObject(this);
        return true;
      }
      else{
        return false;
      }
   }
    
    
    public void levouDano(){
         if(dano==true){
             hp.perderPontoVida();
             dano=false;
             naoLevouDano=false;
         }
         if(dano2==true){
             for(int x=0;x<valorDano2Padrao;x++){
                hp.perderPontoVida();
                if(hp.getPontoVida()==0)
                    break;
            }
             dano2=false;   
             naoLevouDano=false;
         }
    }
   
    /**
     * Este método executa a
     * movimentação geral do ator.
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
      * Este método executa a movimentação
      * do ator no eixo X.
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
     * Este método é responsável por
     * movimentar a vida do ator.
     */
    private void movimentaVida(){
                   hp.setLocation(getX(), getY()-50);
    }
    
    /**
     * Este método é responsável por inverter na horizontal as
     * imagens que este ator utiliza
     */
    private void inverImagemDesteInimigo(){
        for(int x =0;x<andando.length;x++)
            andando[x].mirrorHorizontally();  
            
        for(int x=0;x<frameAtaque.length;x++)
            frameAtaque[x].mirrorHorizontally();
            
            levouDano[0].mirrorHorizontally();
    }    
              
    /**
     * Este método exibe a animação do personagem
     * andando.
     */
    private void andando(){
        if(frameImage%10==0)
           setImage(andando[frameImage/10]);
        
        if(frameImage==38){
           frameImage=-1;
        }
        frameImage++; 
    }
    
    /**
     * Este método exibe a animação
     * do personagem levando dano.
     */
    private void frameDano(){
       setImage(levouDano[0]);
        if(frameLevouDano==10){
            frameLevouDano=-1;
            naoLevouDano=true;
        }
       frameLevouDano++;
    }
    
    /**
     * Este método exibe a animação do 
     * primeiro aaque do personagem
     */
    private void ataque(){
        if(posAtaque%10==0)
           setImage(frameAtaque[posAtaque/10]);
        
        if(posAtaque==68){
           posAtaque=-1;
           ataqueExecutado=true;
           ataque=false;
        }
        posAtaque++; 
    }
        private GreenfootImage[] andando ={new GreenfootImage("leviat6.png"),  new GreenfootImage("leviat7.png"),  new GreenfootImage("leviat8.png"),  new GreenfootImage("leviat9.png")};
        private GreenfootImage[] frameAtaque = {new GreenfootImage("leviat10.png"),new GreenfootImage("leviat11.png"),  new GreenfootImage("leviat12.png"), 
            new GreenfootImage("leviat13.png"),  new GreenfootImage("leviat14.png"),  new GreenfootImage("leviat15.png"),new GreenfootImage("leviat16.png")};
       private GreenfootImage[] levouDano= {new GreenfootImage("leviat0.png")};
            
       private int direcao=1;
       private int frameLevouDano;
       private int posAtaque;
  
       private boolean naoLevouDano=true;
       private boolean ataqueExecutado=false;
    }
