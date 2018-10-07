import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta classe reprenta o Inimigo09.
 * Suas principais funcionalidades são
 * andar e efetuar dois tipos de ataque.
 * 
 * @since Novembro, 2013.
 */
public class Inimigo09 extends Inimigos
{
    /**
     * Neste construtor é inicializado. 
     */
    public Inimigo09(){
        hp = new VidaInimigos();
        inverterImagem();
    }
    
    protected void addedToWorld(World world){
        ((MoveMundo)getWorld()).adicionarObjeto(hp, getX(), getY()-50, false);
    }
    
    public void act() 
    {
        if(parar==false){
            if(entradaExibida==false)
                animacaoEntrada();
                else
                if(!morreu()){
                    if(ataque==true){
                        ((Jogador)possivelColisor).dano();
                        if(ataqueExecutado==false){    
                            levouDano();
                            gravidade();
                            executarAtaque(vezAtaque);
                        }
                    }else{
                        travarMiraEmOberon();  
                        mover();
                        gravidade();
                        levouDano();  
                        possivelColisor=colisao();
                        ataqueExecutado=false;
                    }
                }else{
                    animacaoMorrendo();
                } 
         }else
            colisao();
         
    }
    
    /**
     * Este método é responsável por executar o ataque de acolitos
     * @paran vezAtaque - inteiro referente ao múmero do ataque selecionado.
     */
    private void executarAtaque(int vezAtaque){
        if(vezAtaque==1)
            ataque1();
            
        if(vezAtaque==2)
            ataque2();
        
        if(vezAtaque==3)
            ataque3();
    }
    
    /**
     * Este método é responsável por verificar
     * se o ator levou dano. Caso ele tenha
     * levado ele diminui um ponto de vida.
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
     * Este método verifica se o personagem morreu
     * caso morreu ele remove a vida e próprio personagem do mundo.
     * @return boolean - retorna true caso ele tenha morrido, do contrário retorna false.
     */
    public boolean morreu(){
        if(hp.getPontoVida()==0){
            ((MoveMundo)getWorld()).removerObjeto(hp);
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * Este método exibe a animação 
     * do ator andando.
     */
    private void andando(){
        if(frameImage%15==0)
            setImage(image[frameImage/15]);
        
        if(frameImage==61){
            frameImage=-1;
        }
    
        frameImage++;    
    }   
    
    private void mover(){
        if(posOberonX<getX()&&direcaoDireita==false){
            setLocation(getX()-2,getY());
            movimentaVida();
            andando();
            levouDano();
            gravidade();
        }
        if(posOberonX<getX()&&direcaoDireita==true){
               setLocation(getX()-2,getY());
               movimentaVida();
               inverterImagem();
               andando();
               levouDano();
               direcaoDireita=false;
        }
        if(posOberonX>getX()&&direcaoDireita==false){
            setLocation(getX()+2,getY());
            movimentaVida();
            inverterImagem();
            andando();
            levouDano();
            direcaoDireita=true;
        }
        if(posOberonX>getX()&&direcaoDireita==true){
            setLocation(getX()+2,getY());
            movimentaVida();
            andando();
            levouDano();
        }
    
    }
    /**
     * Este método é responsável por exibir a animação 
     * referente ao primeiro ataque do ator.
     */
    private void ataque1(){
        if(frameAtaque1%10==0)
            setImage(ataque1[frameAtaque1/10]);
            
        if(frameAtaque1==58){
            frameAtaque1=-1;
            ataqueExecutado=true;
            ataque=false;
            vezAtaque=2;
        }
            
            frameAtaque1++;    
    }
    
    /**
     * Este método é responsável por exibir a animação
     * do segundo ataque do ator.
     */
    private void ataque2(){
        if(frameAtaque2%10==0)
            setImage(ataque2[frameAtaque2/10]);
        
        if(frameAtaque2==20)
            ((MoveMundo)getWorld()).adicionarObjeto(new AtaqueAcolitos1(), 300, 500,true);
            
        if(frameAtaque2==28){
            frameAtaque2=-1;
            ataqueExecutado=true;
            ataque=false;
            vezAtaque=3;
        }
        
        frameAtaque2++;    
    }
    
    /**
     * Este método é responsável por exibir a 
     * animação do terceiro ataque do ator.
     */
    private void ataque3(){
        if(frameAtaque3%10==0)
            setImage(ataque3[frameAtaque3/10]);
        
        if(frameAtaque3==21)
            if(direcaoDireita==false)
                ((MoveMundo)getWorld()).adicionarObjeto(new AtaqueAcolitos2(1), getX(), getY(),true);
            else
                ((MoveMundo)getWorld()).adicionarObjeto(new AtaqueAcolitos2(2), getX(), getY(),true);  
      
        if(frameAtaque3==28){
            frameAtaque3=-1;
            ataqueExecutado=true;
            ataque=false;
            vezAtaque=1;
        }
            
        frameAtaque3++;    
    }
   
    /**
     * Este método é responsável por movimentar
     * a vida do ator.
     */
    private void movimentaVida(){
                   hp.setLocation(getX(), getY()-50);
    }
    
     /**
     * Este método obtém as cordenadas
     * de oberon, para que o ator mova em sua direção.
     */
    private void travarMiraEmOberon(){
        Actor ob = getPersonagemPrincipal();
        posOberonX=ob.getX();
        posOberonY=ob.getY();
    }
    
   /**
    * Este método é responsável por exibir
    * a animação do ator morrendo.
    */
    private void animacaoMorrendo(){
        if(morrendo%10==0)
            setImage(frameMorrendo[morrendo/10]);
        
        if(morrendo==31)
          ((MoveMundo)getWorld()).removerObjeto(this);
            
        morrendo++;
   }
   
   private void animacaoEntrada(){
       if(frameEntrada%20==0)
            setImage(entrada[frameEntrada/20]);
       
       if(frameEntrada==48){
             frameEntrada=-1;
             entradaExibida=true;
       }
       
       frameEntrada++;         
   }
     
    
   /**
     * Este método é responsável por inveter
     * na horizontal todas as imagens do ator.
     */
    public void inverterImagem(){
        for(int x=0; x<image.length;x++)
            image[x].mirrorHorizontally();
        
        for(int x=0; x<frameMorrendo.length;x++)
            frameMorrendo[x].mirrorHorizontally();
        
        for(int x=0; x<ataque1.length;x++)
            ataque1[x].mirrorHorizontally();
        
        for(int x=0; x<ataque2.length;x++)
            ataque2[x].mirrorHorizontally();
    
        for(int x=0; x<ataque3.length;x++)
             ataque3[x].mirrorHorizontally();
       
        for(int x=0;x<entrada.length;x++)
            entrada[x].mirrorHorizontally();
   } 
    
    private GreenfootImage[] entrada={new GreenfootImage("Acolitos0.png"),new GreenfootImage("Acolitos1.png"),new GreenfootImage("Acolitos2.png")};
    private GreenfootImage[] ataque1={new GreenfootImage("Acolitos8.png"),new GreenfootImage("Acolitos9.png"),new GreenfootImage("Acolitos10.png"),
        new GreenfootImage("Acolitos11.png"),new GreenfootImage("Acolitos12.png"),new GreenfootImage("Acolitos13.png")};
    private GreenfootImage[] ataque2={new GreenfootImage("Acolitos15.png"),new GreenfootImage("Acolitos16.png"),new GreenfootImage("Acolitos17.png")};
    private GreenfootImage[] ataque3={new GreenfootImage("Acolitos18.png"),new GreenfootImage("Acolitos19.png"),new GreenfootImage("Acolitos20.png")};
    private GreenfootImage[] frameMorrendo={new GreenfootImage("Acolitos21.png"),new GreenfootImage("Acolitos22.png"),
        new GreenfootImage("Acolitos23.png"),new GreenfootImage("Acolitos24.png")};
    private GreenfootImage[] image={new GreenfootImage("Acolitos3.png"),new GreenfootImage("Acolitos4.png"),new GreenfootImage("Acolitos5.png"),
        new GreenfootImage("Acolitos6.png"),new GreenfootImage("Acolitos7.png"),new GreenfootImage("Acolitos14.png")};
    
   private int morrendo;
   private int frameAtaque1;
   private int frameAtaque2;
   private int frameAtaque3;
   private int frameEntrada;
   private int posOberonX;
   private int posOberonY;
   private int vezAtaque=1;
   
   private boolean entradaExibida;
   private boolean ataqueExecutado;
   private boolean direcaoDireita;
 
   
}
 