import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Inimigo_04 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inimigo04 extends Inimigos
{
    /**
     * Act - do whatever the Inimigo_04 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Inimigo04(){
        inverterImagem();
        setAlturaPadrao(65);
    }
    
    protected void addedToWorld(World world){
        hp=new VidaInimigos();
        getWorld().addObject(hp, getX(), getY()-50);    
    }
    
   public void act() 
    {
        if(!morreu()){
            if(parar==false){
                if(ataque==true){
                    ((Jogador)possivelColisor).dano();
                    if(ataqueExecutado==false){    
                        ataque();
                        levouDano();
                    }
                }else{
                    frameAndando();
                    levouDano();
                    andar();
                    possivelColisor = colisao();
                    ataqueExecutado=false;
                } 
            }else{
                levouDano();
                colisao();
            }
        }
         
    }
   
    /**
     * Este método é responsável
     * por verificar se o ator morreu
     * caso ele tenha morrido ele remove o inimigo.
     * @return boolean - true caso o ator tenha morrido, do contrário retorna false.
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
     * Este método é responsável por
     * verificar se o personagme levou dano,
     * caso tenha levado ele diminui a vida do personagem.
     */
    public void levouDano(){
         if(dano==true){
             hp.perderPontoVida();
             dano=false;
         }
         if(dano2==true){
             for(int x=0;x<valorDano2Padrao;x++){
                hp.perderPontoVida();
                if(hp.getPontoVida()==0)
                    break;
            }
             dano2=false;   
         }
    }
   
    
    /**
     * Este método é responsável por
     * efetuar a movimentação geral do personagem.
     */
    public void andar(){
        if(moveBack==false&&direcao==1)
           mover();
           
        if(moveBack==true&&direcao==1){
           direcao=2;
           mover();
           moveBack=false;
           inverterImagem();
        }
        
        if(moveBack==false&&direcao==2)
           mover(); 
           
           if(moveBack==true&&direcao==2){
           direcao=1;
           mover();
           moveBack=false;
           inverterImagem();
        }
    }
    
    /**
     * Este método é responsável por 
     * mover o personagem no eixo X.
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
     * Este método é resonsável por
     * movimentar a vida do ator.
     */
    private void movimentaVida(){
                   hp.setLocation(getX(), getY()-50);
    }
    
   /**
    * Este método é responsável por
    * inverter as imagens que esse 
    * ator utiliza.
    */
    private void inverterImagem(){
        for(int x =0;x<image.length;x++)
            image[x].mirrorHorizontally();
        for(int x =0;x<frameAndando.length;x++)
            frameAndando[x].mirrorHorizontally();
            
    }    
    
    /**
     * Este método é responsável por exibir 
     * a animação do ator andando.
     */
    public void frameAndando(){
        if (frameImage % 20 == 0)
            setImage(frameAndando[frameImage/20]);
            
        if (frameImage == 41)
            frameImage = -1;
        frameImage++; 
    
    }
    
    /**
     * Este método é responsável por
     * exibir a animação do personagem
     * efetuando o ataque.
     */
    public void ataque(){
        if (frameAtaque % 10 == 0)
            setImage(image[frameAtaque/10]);
            
        if (frameAtaque == 31){
            frameAtaque = -1;
            ataqueExecutado=true;
            ataque=false;
        }
        frameAtaque++; 
    
    }
    
        private GreenfootImage[] frameAndando ={new GreenfootImage("abg12.png"), new GreenfootImage("abg13.png"),new GreenfootImage("abg14.png")};
    
        private GreenfootImage[] image = {new GreenfootImage("abg15.png"), new GreenfootImage("abg16.png"),new GreenfootImage("abg17.png"), new GreenfootImage("abg18.png")};
         
        private int frameAtaque;
        private int direcao=1;
        private boolean ataqueExecutado=false;
    
}
