import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Inimigo08 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inimigo08 extends Inimigos
{
    /**
     * Neste constutor a variável hp(vida) é inicializada.
     */
    public Inimigo08 (){
        hp =new VidaInimigos();
        setAlturaPadrao(65);
    }
    
    protected void addedToWorld(World world){
       ((MoveMundo)getWorld()).adicionarObjeto(hp , getX(), getY()-50,false); 
    }
    
    public void act() 
    {
       if(parar==false){
           if(!morreu()){
               if(naoLevouDano==true){
                   if(ataque==true){
                       ((Jogador)possivelColisor).dano();
                       if(ataqueExecutado==false){    
                           frameAtaque();
                           ataqueEspada.play();                                                             
                           levouDano();
                        }
                    }else{
                        levouDano();
                        possivelColisor = colisao();
                        andando();
                        andar();
                        ataqueExecutado=false;
                    }
                }else
                    frameDano();
           }else
                    morrendo();
        }else{
            levouDano();
            colisao();            
        }
    }
    
    /**
     * Este método é responsável por verificar se o personagem levou dano.
     * Caso o personagem levou dano, ele diminui 1 ponto de vida.
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
     * Este método é responsável por verificar
     * se o personagem morreu. Caso o personagem morreu
     * ele remove a vida e o próprio personagem do mundo.
     * @return boolean - true caso o personagem morreu, do contrário false.
     */
    public boolean morreu(){
        if(hp.getPontoVida()==0){
            ((MoveMundo)getWorld()).removerObjeto(hp);
            return true;
        }else
            return false;
    }
    
    /**
     * Este método exibe a animação
     * principal do inimigo.
     */
    private void andando (){
        if(frameImage%10==0)
            setImage(andando[frameImage/10]);
        
        if(frameImage==48)
            frameImage=-1;
        
        frameImage++;    
    }
    
    /**
     * Este método é responsável por
     * exibir a animação do ataque
     * do ator.
     */
    private void frameAtaque(){
        if(frameAtaque%10==0)   
            setImage(imgAtaque[frameAtaque/10]);
                    
        if(frameAtaque==58){
            frameAtaque=-1;
            ataque=false;
            ataqueExecutado=true;
        }
       
        frameAtaque++;    
    }
    
    /**
     * Este método é responsável
     * por exibir a animação do ator levando dano.
     */
    private void frameDano(){
        setImage(imgDano[0]);
        
        if(posDano==10){
            posDano=-1;         
            naoLevouDano=true;
        }
        
        posDano++;    
    }
    
    /**
     * Este método é responsável
     * por exibir a animação do ator morrendo.
     */
    private void morrendo(){
        if(frameMorrendo%10==0)
            setImage(morrendo[frameMorrendo/10]);
        
        if(frameMorrendo==28){
            frameMorrendo=-1;
            ((MoveMundo)getWorld()).removerObjeto(this);
        }
            
        frameMorrendo++;
    }
    
    /**
     * Este método é responsável
     * por movimentar a vida do ator.
     */
    private void movimentaVida(){
                   hp.setLocation(getX(), getY()-50);
    }
    
    /**
     * Este método é responsável por
     * realizar a movimentação geral do ator.
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
     * mover o ator no eixo X, para a direita ou esquerda;
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
     * Este método é responsável por inverter
     * todas as imagens deste ator.
     */
    private void inverterImagem(){
        for(int x=0;x<image.length;x++)
            image[x].mirrorHorizontally();
    
        for(int x=0;x<imgAtaque.length;x++)
            imgAtaque[x].mirrorHorizontally();
        
        for(int x=0;x<andando.length;x++)
            andando[x].mirrorHorizontally();    
    
        for(int x=0;x<morrendo.length;x++)
            morrendo[x].mirrorHorizontally();
        
           imgDano[0].mirrorHorizontally(); 
    }
    
    private GreenfootImage [] image={ new GreenfootImage("tauros14.png"),  new GreenfootImage("tauros15.png"),new GreenfootImage("tauros16.png"),  
        new GreenfootImage("tauros17.png"),  new GreenfootImage("tauros18.png"), new GreenfootImage("tauros20.png")};
    private GreenfootImage[] andando={new GreenfootImage("tauros1.png"),  new GreenfootImage("tauros2.png"),  new GreenfootImage("tauros3.png"),  new GreenfootImage("tauros4.png"),  new GreenfootImage("tauros5.png")};
    private GreenfootImage[] imgAtaque={ new GreenfootImage("tauros6.png"),  new GreenfootImage("tauros7.png"),  new GreenfootImage("tauros8.png"),  new GreenfootImage("tauros9.png"),  new GreenfootImage("tauros10.png"),  
        new GreenfootImage("tauros11.png"),  new GreenfootImage("tauros12.png")};    
    private GreenfootImage[] imgDano={new GreenfootImage("tauros13.png")};
    private GreenfootImage[] morrendo={new GreenfootImage("tauros21.png"),  new GreenfootImage("tauros22.png"),  new GreenfootImage("tauros23.png")};
    
    private  GreenfootSound ataqueEspada = new GreenfootSound("somEspada.mp3");
    

    private int frameAtaque;
    private int frameMorrendo;
    private int posDano;
    private int direcao=1;
    
    private boolean ataqueExecutado=false;
    private boolean naoLevouDano=true;
}
