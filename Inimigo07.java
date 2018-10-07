import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta classe representa um necromancer
 * ele comanda a terceira fase. 
 * Enquanto sua energia não estiver vazia, 
 * ele é invencível.Sua principal ação, nesse
 * estágio é evocar outros inimigos.
 * @since Dezembro, 2013.
 */
public class Inimigo07 extends Inimigos
{
    /**
     * No construtor é invertido todas as imagens deste
     * personagem na horizontal, também é inicializado a variável
     * hp.
     */
    public Inimigo07(){
        inverterImagem();
        hp = new VidaInimigos();
    }
    
    
    protected void addedToWorld(World world){
        ((MoveMundo)getWorld()).adicionarObjeto(hp, getX(), getY()-70,false);
    }
    
    public void act() 
    {
        if(parar==false){
            if(! morreu()){
                if(inimigosEvocados<8){
                    if(podeEvocar==true)
                        frame();
                        else
                        tempoEspera();
                    }
                if(inimigosEvocados>6&&inimigosEvocados<20)
                if(podeEvocar==true)
                    evocacao2();
                else 
                    tempoEspera(); 
                if(inimigosEvocados>=20&&((Terceira)getWorld()).verificaInimigosVivos()==1){
                    if(acolitosEvocado==false)
                        evocacao3();
                     else{
                        levouDano();
                    }
                } 
            }
        }else
            levouDano();
    } 
    
    /**
     * Este método é referente a um temporizador.
     */
    private void tempoEspera(){
        if(tempoEspera==800){
            podeEvocar=true;
            tempoEspera=-1;
        }
    
       tempoEspera++;
    }
    
    /**
     * Este método verifica se o personage levou dano
     * caso ele tenha levado é diminuido em 1 o ponto de
     * vida do personagem.
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
     * Este método veririca se o personagem morreu
     * caso ele tenha morrido ele remove a vida e o 
     * próprio personagem do mundo.
     * @return true caso o personagem tenha morrido, do contrário
     * retorna falsae.
     */
    public boolean morreu(){
        if(hp.getPontoVida()==0){
           ((Terceira)getWorld()).removerObjeto(hp);
           ((Terceira)getWorld()).removerObjeto(this);
           return true;
        }else
            return false;
    }
    
    /**
     * Este método é responsável por exibir
     * a primeira animação de evocação deste
     * ator.
     */
    private void frame(){
        if(frameImage%15==0)
            setImage(image[frameImage/15]);
            
        if(frameImage==195){
            frameImage=-1;
            evocarMonstros();
            podeEvocar=false;
        }
            
        frameImage++;    
    }
    
    /**
     * Este método é responsável por exibir a segunda
     * animação de evocação deste ator.
     */
    private void evocacao2(){
        if(frameEvocacao2%15==0)
            setImage(image[frameEvocacao2/15]);
            
        if(frameEvocacao2==105){  
            frameEvocacao2=-1;
            evocarMonstros();
            evocarMonstros();
            podeEvocar=false;
        }
        
        frameEvocacao2++;    
    }
    
    /**
     * Este método é responsável por exibir a terceira
     * animação de evocação deste ator.
     */
    private void evocacao3(){
        if(frameEvocacao3%20==0)
            setImage(evocacao3[frameEvocacao3/20]);
        
        if(frameEvocacao3==211){
            frameEvocacao3=-1;
            evocarAcolitos();
        }
        
        frameEvocacao3++;    
    }
    
    
    /**
     * Este método é usado para inverter a imagem na horizontal
     * do ator.
     */
    private void inverterImagem(){
        for(int x=0;x<image.length;x++)
            image[x].mirrorHorizontally();
            
        for(int x=0;x<evocacao2.length;x++)
            evocacao2[x].mirrorHorizontally();
     
        for(int x=0;x<evocacao3.length;x++)
            evocacao3[x].mirrorHorizontally();
        
    }
    
    /**
     * Este método é chamado para evocar monstros
     * aleatórios em locais aleatórios.
     */
    private void evocarMonstros(){
        ((Terceira)getWorld()).adicionarPersonagemAleatorio(); 
        inimigosEvocados++;
    }
    
    /**
     * Este método efetua a última evocação,
     * adicionando Acolitos ao mundo.
     */
    private void evocarAcolitos(){
        ((Terceira)getWorld()).adicionarObjeto(new Inimigo09(), 300, 300,false);
        acolitosEvocado=true;
    }
    
    private GreenfootImage[] image ={new GreenfootImage("necro0.png"),new GreenfootImage("necro1.png"),new GreenfootImage("necro2.png"),
        new GreenfootImage("necro3.png"),new GreenfootImage("necro4.png"), new GreenfootImage("necro5.png"),new GreenfootImage("necro6.png"), 
        new GreenfootImage("necro7.png"),new GreenfootImage("necro8.png"),new GreenfootImage("necro9.png"),new GreenfootImage("necro10.png"),
        new GreenfootImage("necro11.png"),new GreenfootImage("necro12.png"), new GreenfootImage("necro13.png")};
   
    private GreenfootImage[] evocacao2 ={new GreenfootImage("necro14.png"),new GreenfootImage("necro15.png"),
        new GreenfootImage("necro16.png"),new GreenfootImage("necro17.png"),new GreenfootImage("necro17.png"),
        new GreenfootImage("necro18.png"),new GreenfootImage("necro19.png"),new GreenfootImage("necro20.png")};
    
    private GreenfootImage[] evocacao3 ={new GreenfootImage("necro21.png"),new GreenfootImage("necro22.png"),
        new GreenfootImage("necro23.png"),new GreenfootImage("necro24.png"),new GreenfootImage("necro25.png"),new GreenfootImage("necro26.png"),
        new GreenfootImage("necro27.png"),new GreenfootImage("necro28.png"),new GreenfootImage("necro29.png"),new GreenfootImage("necro30.png"),
        new GreenfootImage("necro31.png"),new GreenfootImage("necro32.png"),new GreenfootImage("necro33.png"),new GreenfootImage("necro34.png"),
        new GreenfootImage("necro35.png")};
    
    private int frameEvocacao2;
    private int frameEvocacao3;
    private int inimigosEvocados;
    private boolean podeEvocar=true;
    private int tempoEspera;
    private boolean acolitosEvocado;
}