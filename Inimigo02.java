import greenfoot.*;
/**
 *  Este é o segundo inimigo
 *  suas principais funcionalidades são,
 *  virar-e na dreção do ator principal, e atirar.
 * 
 * @since Novembro, 2013.
 */
public class Inimigo02 extends Inimigos 
{
    /**
     * No construtor é invertido a imagem do ator.
     */
    public Inimigo02(){
        inverterImagem();
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
        ((MoveMundo)getWorld()).adicionarObjeto(hp, getX(), getY()-50,true);    
    }
    
    /**
     * Este método é chamado pela estrutura do greenfoot,
     * realizando todas as ações deste ator.
     */
    public void act() 
    {
        if(!morreu()){
            if(parar==false){
                verificaDirecaoPersonagem();
                if(direcaoPersonagem<getX()&&direcaoDireita==false){
                    frame();
                    levouDano();
                    direcaoTiro=1;
                }
                if(direcaoPersonagem<getX()&&direcaoDireita==true){
                    inverterImagem();
                    frame();
                    levouDano();
                    direcaoDireita=false;
                    direcaoTiro=1;
                }
                if(direcaoPersonagem>getX()&&direcaoDireita==false){
                    inverterImagem();
                    frame();
                    levouDano();
                    direcaoDireita=true;
                    direcaoTiro=2;
                }
                if(direcaoPersonagem>getX()&&direcaoDireita==true){
                    frame();
                    levouDano();
                    direcaoTiro=2;
                }
            }else{
                levouDano();
                colisao();
            }
        }
    }
    
    /**
     * Este método verifica a direção
     * do ator principal.
     */
    public void verificaDirecaoPersonagem(){
        direcaoPersonagem=((MoveMundo)getWorld()).getPersonagemPrincipal().getX();
    }
    
    /**
     * Este método adiciona o ataque no mundo.
     * 
     */
    private void atacar(){
        getWorld().addObject(new TiroBicho02(direcaoTiro), getX()-10, getY());
    }
    
    /**
     * Este método verifica se o ator morreu
     * Caso tenha morrido, ele remove  a vida e o
     * próprio ator.
     * @return boolean - true se o personagem morreu, false se ele permanece vivo.
     */
    private boolean morreu(){
     if(hp.getPontoVida()<=0)
      {
          Actor ob =((MoveMundo)getWorld()).getPersonagemPrincipal();
          ((Jogador)ob).getEnergia().recuperarPontoEnergia();
          ((MoveMundo)getWorld()).removerObjeto(hp);
          ((MoveMundo)getWorld()).removerObjeto(this);
       
        return true;
      }
      else
        return false;
    }
    
    /**
     * Este método verifica se o ator 
     * levou dano, caso tenha levado,
     * Ele seta dano ao ator
     */
    public void levouDano(){
         if(dano==true&&estaInvencivel==false){
             hp.perderPontoVida();
             dano=false;
         }else
            dano=false;
         
         if(dano2==true&&estaInvencivel==false){
             for(int x=0;x<valorDano2Padrao;x++){
                hp.perderPontoVida();
                if(hp.getPontoVida()==0)
                    break;
            }
             dano2=false;   
         }else
            dano2=false;
    }
    
    /**
     * Este método inverte a imagem  do ator  
     */
    private void inverterImagem(){
        for(int x =0;x<image.length;x++)
            image[x].mirrorHorizontally();
    }
    
    /**
    * Este método exibe a animação
    * também é responsável por setar o
    * ator como invencivel, através do boolean
    * estaInvencivel
    */  
    private void frame(){
        if(frameImage%20==0&&frameImage<=80)
            setImage(image[frameImage/20]);
        if(frameImage==80){
            estaInvencivel=true;
        }
        if(frameImage==240){
            estaInvencivel=false;
        }
        if(frameImage==270)
            setImage(image[6]);
        if(frameImage==300){
            setImage(image[7]);
            atacar();
        }
        if(frameImage==301)
            frameImage=-1;
            frameImage++;
    }
    
    
                private GreenfootImage[] image={ new GreenfootImage("z8.png"), new GreenfootImage("z9.png"),new GreenfootImage("z10.png"), new GreenfootImage("z1.png"),new GreenfootImage("z2.png"),  
                new GreenfootImage("z3.png"),new GreenfootImage("z4.png"),new GreenfootImage("z5.png")};
                
                private int direcaoPersonagem;
                private boolean direcaoDireita;
                private boolean estaInvencivel;
                private int direcaoTiro;
}
 