import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta classe é referente ao décimo inimigo
 * suas ações princiapais são andar e efetuar dois tipos
 * de ataque.
 * 
 * @since Novembro, 2013.
 */
public class Inimigo10 extends Inimigos
{   
    /**
     * Neste construtor é inicializado a vida.
    */
    public Inimigo10(){
        hp = new VidaInimigos();
        inverterImagem();
        setAlturaPadrao(45);
    }
    
    protected void addedToWorld(World world){
       ((MoveMundo)getWorld()).adicionarObjeto(hp , getX(), getY()-50,false); 
    }
    
    public void act() 
    {
        if(!morreu()){
            if(parar==true){
                levouDano();
                gravidade();
                colisao();
            }else{
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
            }
         }else{
                animacaoMorrendo();
        }
    }
    
    /**
     * Este método chama 
     * um dos métodos responsáveis pelas
     * animações de ataque.
     * @param vezAtaque - este inteiro é referente a qual dos ataques deve ser chamado.
     */
    private void executarAtaque(int vezAtaque){
        if(vezAtaque==1)
            ataque();
        if(vezAtaque==2)
            ataque2();
    }
    
    /**
     * Este método é responsável por veirificar se o
     * ator levou dano.
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
     * se o personagem morreu.
     * Ele remove a barra de vida, remove o próprio 
     * objeto.
     * @return boolean -  retorna true se o objeto morreu, do contrário retorna false. 
     * 
     */
    public boolean morreu(){
        if(hp.getPontoVida()==0){
            ((MoveMundo)getWorld()).removerObjeto(hp);
            return true;
        }else 
            return false;
    }
    
    /**
     * Este mmétodo é responsável por exibir
     * a animação do ator andando.
     */
    private void andando(){
        if(frameImage%10==0)
            setImage(image[frameImage/10]);
        if(frameImage==41)
            frameImage=-1;
        frameImage++;    
    }
    
    /**
     * Este método executa a  movimentação geral do 
     * ator.
     */
    private void mover(){
        if(posOberonX<getX()&&direcaoDireita==false){
            setLocation(getX()-1,getY());
            movimentaVida();
            andando();
            levouDano();
            gravidade();
        }
        if(posOberonX<getX()&&direcaoDireita==true){
               setLocation(getX()-1,getY());
               movimentaVida();
               inverterImagem();
               andando();
               levouDano();
               direcaoDireita=false;
        }
        if(posOberonX>getX()&&direcaoDireita==false){
            setLocation(getX()+1,getY());
            movimentaVida();
            inverterImagem();
            andando();
            levouDano();
            direcaoDireita=true;
        }
        if(posOberonX>getX()&&direcaoDireita==true){
            setLocation(getX()+1,getY());
            movimentaVida();
            andando();
            levouDano();
        }
    }
    
    /**
     * Este método é responsável por exibir a nimação do
     * ator morrendo
     */
    private void animacaoMorrendo(){
        if(frameMorrendo%10==0)
            setImage(morreu[frameMorrendo/10]);
            
        if(frameMorrendo==21){
            ((MoveMundo)getWorld()).removerObjeto(this);
        }
        
        frameMorrendo++;    
    }
    
    /**
     * Este método é responsável por exibir a animação
     * do primeiro ataque.
     */
    private void ataque(){
        if(frameAtaque%10==0)
            setImage(ataque1[frameAtaque/10]);
        
        if(frameAtaque==51){
            frameAtaque=-1;
            vezAtaque=2;
            ataqueExecutado=true;
            ataque=false;
        }
       
        frameAtaque++;    
    }
    
    /**
     * Este método é responsável por exibir a animação
     * do segundo ataque.
     */
    private void ataque2(){
        if(frameAtaque2%10==0)
            setImage(ataque2[frameAtaque/10]);
       
        if(frameAtaque2==31){ 
            frameAtaque2=-1;
            vezAtaque=1;
            ataqueExecutado=true;
            ataque=false;
        }
        
       frameAtaque2++;     
    }
    
    /**
     * Este método é resonsável por
     * movimentar a vida do ator.
     */
    private void movimentaVida(){
                   hp.setLocation(getX(), getY()-50);
    }
    
    /**
     * Este método é responsável por inveter
     * na horizontal todas as imagens do ator.
     */
    public void inverterImagem(){
        for(int x=0; x<image.length;x++)
            image[x].mirrorHorizontally();
        
        for(int x=0; x<morreu.length;x++)
            morreu[x].mirrorHorizontally();
        
        for(int x=0; x<ataque1.length;x++)
            ataque1[x].mirrorHorizontally();
        
        for(int x=0; x<ataque2.length;x++)
            ataque2[x].mirrorHorizontally();
    }
    
    
    /**
     * Este método é responsável por obter
     * as cordenadas de oberon para que esse
     * ator possa ir em sua direção.
     */
    private void travarMiraEmOberon(){
        Actor ob = getPersonagemPrincipal();
        posOberonX=ob.getX();
        posOberonY=ob.getY();
    }
    
    private GreenfootImage [] image ={new GreenfootImage("castor4.png"),new GreenfootImage("castor5.png"),
        new GreenfootImage("castor6.png"),new GreenfootImage("castor7.png"),new GreenfootImage("castor8.png")};
   
    private GreenfootImage [] morreu={new GreenfootImage("castor30.png"),new GreenfootImage("castor31.png"),new GreenfootImage("castor32.png")};
    
    private GreenfootImage[] ataque1={new GreenfootImage("castor33.png"),new GreenfootImage("castor34.png"),new GreenfootImage("castor35.png"),
    new GreenfootImage("castor36.png"),new GreenfootImage("castor37.png"),new GreenfootImage("castor38.png")};
    
    private GreenfootImage[] ataque2={new GreenfootImage("castor28.png"),new GreenfootImage("castor27.png"),new GreenfootImage("castor29.png"),
    new GreenfootImage("castor20.png")};
    
    private int frameMorrendo;
    private int frameAtaque;
    private int frameAtaque2;
    private int posOberonX;
    private int posOberonY;
    private int vezAtaque=1;
    private boolean ataqueExecutado;
    private boolean direcaoDireita;
}
